package com.edu.element;

import javax.swing.ImageIcon;
import java.awt.Graphics;

/**
 * @author L1r0gn
 * @description  所有元素的基类
 */
public abstract class elementObj {
    private int x;
    private int y;
    private int w;
    private int h;
    private ImageIcon icon;


    public  elementObj() { // 构造无作用，只是为了继承不报错
    }

    /**
     * 带参数的构造方法，可以由子类传输数据到父类
     *
     * @param x 左上角x坐标
     * @param y 左上角y坐标
     * @param w w宽度
     * @param h h高度
     * @param icon 图片
     */
    public elementObj(int x, int y, int w, int h, ImageIcon icon) {
        super();
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.icon = icon;
    }

    /**
     * 抽象方法 - 显示元素
     * @param g 画笔 - 用于进行绘画
     */
    public abstract void showElement(Graphics g);


    /**
     * 使用父类定义接收键盘事件的方法,只有需要键盘监听的子类，重写这个方法
     * 方法2：使用接口的方式；使用接口方式需要在监听类进行类型转换
     *
     * @param bl 点击的类型（true表示按下，false表示松开）
     * @param key 代表出发的键盘的code值
     */
    public void keyClick(boolean bl,int key) {

    }


     /*
     只要是VO类就为属性生成get和set方法
      */
    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
