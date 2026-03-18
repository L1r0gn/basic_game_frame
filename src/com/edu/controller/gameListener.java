package com.edu.controller;

import com.edu.element.elementObj;
import com.edu.manager.elementManager;
import com.edu.manager.gameElement;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

/**
 * @description 监听类，用于监听用户的操作 KeyListener
 * @author L1r0gn
 */
public class gameListener implements KeyListener {
    private elementManager em = elementManager.getManager();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 按下：左37，上38，右39，下40
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // 得到玩家集合
        List<elementObj> play = em.getElementByKey(gameElement.PLAY);
        for(elementObj obj : play) {
            obj.keyClick(true,e.getKeyCode());
        }
    }

    /**
     * 松开
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        List<elementObj> play = em.getElementByKey(gameElement.PLAY);
        for(elementObj obj : play) {
            obj.keyClick(false,e.getKeyCode());
        }
    }
}