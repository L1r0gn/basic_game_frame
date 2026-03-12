package com.edu.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * element manager - store all element and provide approaches to give view and controller to get data
 *
 * @author L1r0gn
 */
public class elementManager {
    private Map<GameElement, List<ElementObj>> gameElements;
    public Map<GameElement, List<ElementObj>> getGameElements(){
        return gameElements;
    }
    /**
     * Add elements
     *
     * @param ElementObj obj
     * @param GameElement ge
     */
    public void addElements(ElementObj obj,GameElement ge){
//        List<ElementObj> list = gameElements.get(ge);
//        list.add(obj);
        gameElements.get(ge).add(obj); // add object to map and store by key
    }
    /**
     * Return list by key, get one element
     *
     * @param GameElement ge
     * @return List<ElementObj>
     */
    public List<ElementObj> getElementByKey(GameElement ge){
        return gameElements.get(ge);
    }

    /**
     * 单例模式：have and only have one example in memory
     * 1.饿汉模式 - autoload example when start
     * 2.饱汉模式 - load example when need
     * Writing approaches
     * 1.need a static attribute(define a const value)
     * 2.provide a static approach(return the example)
     * 3.prevent others to use
     */
    private static elementManager EM = null;

    // synchronized: thread loce -> keep only one thread in the execute of approach
    public static synchronized elementManager getManager() {
        if(EM == null) { // control judge
            EM = new elementManager();
        }
        return EM;
    }
    private elementManager() { // private construct approach
        init();
    }
//    static { // autoload when the class loading
//        EM = new elementManager();
//    }

    /**
     * prepare for future to rewrite init - used for function extension
     */
    public static void init() { // do instance here
        gameElements = new HashMap<GameElement, list<ElementObj>>();
        // put each elements into map
        gameElements.put(GameElement.PLAY,new ArrayList<ElementObj>());
        gameElements.put(GameElement.MAPS,new ArrayList<ElementObj>());
        gameElements.put(GameElement.ENEMY,new ArrayList<ElementObj>());
        gameElements.put(GameElement.BOSS,new ArrayList<ElementObj>());

    }

}
