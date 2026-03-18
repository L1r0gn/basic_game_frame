package com.edu.show;

import com.edu.element.play;
import com.edu.manager.elementManager;
import com.edu.element.elementObj;
import com.edu.manager.gameElement;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.List;
import java.util.Map;

/**
 * 游戏主面板
 * @author L1r0gn
 * @description 主要进行元素的显示，同时进行界面的刷新（涉及多线程）
 *
 * 多线程刷新：本类实现线程接口/本类中定义一个内部类来实现
 */
public class gameMainJPanel extends JPanel implements Runnable {
    /**
     * 联动管理器
     */
    private elementManager em;

    public gameMainJPanel(){
        init();
        // 以下代码后面会换地方重写（测试代码）
        load();
    }

    public void load(){
        ImageIcon icon = new ImageIcon("image/tank/play1/player1_up.png");
//      em.getElementByKey(gameElement.PLAY).add(obj); // 将对象放入元素管理器
        elementObj obj = new play(100, 100, 50, 50, icon); // 实例化对象
        em.addElements(obj,gameElement.PLAY); // 直接添加
    }

    public void init(){
        em = elementManager.getManager(); // 得到元素管理器对象
    }

    /**
     * 进行绘画元素
     * @param g  the <code>Graphics</code> context in which to paint
     * 本方法只使用一次，想实时刷新需要多线程
     */
    @Override // 重写绘画方法 Graphics 画笔
    public void paint(Graphics g){
        super.paint(g);

        Map<gameElement, List<elementObj>> all = em.getGameElements();
        // gameElement.values(); // 隐藏方法 - 返回值是一个数组，数组的顺序就是定义枚举的顺序
        for(gameElement ge : gameElement.values()){
            List<elementObj> list = all.get(ge);
            for(int i = 0; i<list.size(); i++){
                elementObj obj = list.get(i);
                obj.showElement(g); // 调用每个类的show方法完成自己的显示
            }
        }
    }


    @Override
    public void run(){
        while(true){
            this.repaint();
            // 一般来讲，多线程都会使用一个休眠，控制速度
            try{
                Thread.sleep(50);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
