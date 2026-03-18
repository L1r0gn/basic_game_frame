package com.edu.game;

import com.edu.controller.gameListener;
import com.edu.show.gameJFrame;
import com.edu.show.gameMainJPanel;

public class gameStart {
    /**
     * @author L1r0gn
     * 程序唯一入口
     */
    public static void main(String[] args) {
        gameJFrame gj =  new gameJFrame();

        /*
        实例化监听
         */
        gameListener listener = new gameListener();
        gj.setKeyListener(listener);

        /*
        实例化面板，注入jframe中
         */
        gameMainJPanel jp = new gameMainJPanel();
        gj.setjPenal(jp);

        gj.start();
    }
}
