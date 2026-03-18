package com.edu.show;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Game window - window operation - close show minimize maximize
 * @author L1r0gn
 * @apiNote need embedded panel, start main thread
 *
 * @apiNote 1.绑定面板 2.绑定监听 3.绑定游戏主线程 4.显示窗体
 */
public class gameJFrame extends JFrame {
    public static int gameX = 800; //
    public static int gameY = 600;
    private JPanel jPenal = null; // 正在显示的面板
    private KeyListener keyListener = null; // 键盘监听
    private MouseMotionListener mouseMotionListener = null;
    private MouseListener mouseListener = null;
    private Thread thread = null;// 游戏主进程

    public gameJFrame() {
        init();
    }

    public void init() {
        this.setSize(gameX, gameY);
        this.setTitle("game test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置退出并关闭
        this.setLocationRelativeTo(null); // 屏幕居中
    }

    /* 窗体布局：存档，读档等button功能 */
    public void addButton(){
//        this.setLayout(manager); // 布局格式，可以添加控件
    }

    /**
     * 启动方法
     * @author L1r0gn
     */
    public void start() {
        if(jPenal != null) {
            this.add(jPenal);
        }
        if(keyListener != null) {
            this.addKeyListener(keyListener);
        }
        if(thread != null) {
            thread.start();
        }
        this.setVisible(true); // 显示界面

        // 如果 jp 是 runnable 的子类实体对象
        if(this.jPenal instanceof Runnable ){
            // 已经做类型判定，强制类型转换不会出错
            new Thread((Runnable)this.jPenal).start();
        }
    }

    /* set 注入：学习ssm中，通过set方法注入配置文件中读取的数据，将配置文件中的数值赋值为类的属性
    *
    * 构造注入：需要配合构造方法
    * spring中ioc进行对象的自动生成，管理
    *  */
    public void setjPenal(JPanel jPenal) {
        this.jPenal = jPenal;
    }

    public void setKeyListener(KeyListener keyListener) {
        this.keyListener = keyListener;
    }

    public void setMouseMotionListener(MouseMotionListener mouseMotionListener) {
        this.mouseMotionListener = mouseMotionListener;
    }

    public void setMouseListener(MouseListener mouseListener) {
        this.mouseListener = mouseListener;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}


