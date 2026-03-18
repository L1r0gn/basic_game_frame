package com.edu.element;

import javax.swing.ImageIcon;
import java.awt.Graphics;

public class play extends elementObj {

    public play(int x, int y, int w, int h, ImageIcon icon) {
        super(x, y, w, h, icon);
    }

    /**
     *
    面向对象思想：对象自己的事情自己做
     */
    @Override
    public void showElement(Graphics g) {
        g.drawImage(this.getIcon().getImage(),this.getX(),this.getY(),this.getW(),this.getH(),null);
    }

    /**
     *
     * @param bl 点击的类型（true表示按下，false表示松开）
     * @param key 代表出发的键盘的code值
     */
    @Override
    public void keyClick(boolean bl,int key) {
        if(bl){
            switch(key){
                case 37:this.setX(this.getX()-10);break;
                case 38:this.setY(this.getY()-10);break;
                case 39:this.setX(this.getX()+10);break;
                case 40:this.setY(this.getY()+10);break;
            }
        }
    }
}
