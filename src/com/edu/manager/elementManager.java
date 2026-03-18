package com.edu.manager;

import com.edu.element.elementObj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * element manager - store all element and provide approaches to give view and controller to get data
 * @author L1r0gn
 */
public class elementManager {
    private Map<gameElement, List<elementObj>> gameElements;
    public Map<gameElement, List<elementObj>> getGameElements(){
        return gameElements;
    }
    /**
     * Add elements
     *
     * @param obj elementObj
     * @param ge gameElement
     */
    public void addElements(elementObj obj, gameElement ge){
//        List<elementObj> list = gameElements.get(ge);
//        list.add(obj);
        gameElements.get(ge).add(obj); // add object to map and store by key
    }
    /**
     * Return list by key, get one element
     *
     * @param  ge gameElement
     * @return List<elementObj>
     */
    public List<elementObj> getElementByKey(gameElement ge){
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
    public void init() { // 实例化
        gameElements = new HashMap<gameElement, List<elementObj>>();
        // 将元素集合放入map中
//        gameElements.put(gameElement.PLAY,new ArrayList<elementObj>());
//        gameElements.put(gameElement.MAPS,new ArrayList<elementObj>());
//        gameElements.put(gameElement.ENEMY,new ArrayList<elementObj>());
//        gameElements.put(gameElement.BOSS,new ArrayList<elementObj>());
        for(gameElement ge : gameElement.values()){
            gameElements.put(ge,new ArrayList<elementObj>());
        }

    }

}
