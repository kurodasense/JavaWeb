package com.plane.show;

import java.awt.Graphics;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import com.plane.element.ElementObj;
import com.plane.manager.ElementManager;
import com.plane.manager.GameElement;

/**
 * 
 * @说明 游戏的显示界面， 用于显示和刷新游戏对象(游戏的主要面板)
 * @author 1205918114
 * @功能说明 主要进行元素的显示，同时进行界面的刷新(多线程)
 * @继承和接口 继承自JPanel,实现Runnable接口，以完成界面的刷新
 */
public class GameJPanel extends JPanel implements Runnable{
//	元素管理器
	private ElementManager em;
	
	/**
	 * 默认构造方法
	 */
	public GameJPanel() {
		init();
	}
	/**
	 * 实际的构造方法，用于在默认构造方法中
	 */
	public void init() {
		em = ElementManager.getManager();//得到元素管理器对象
	}
	
	/**
	 * @说明 显示元素管理器中的所有元素(会调用每个元素自身的方法来完成自己的显示)
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);  //调用父类的paint方法
		Map<GameElement, List<ElementObj>> all = em.getGameElements();
		for(GameElement ge:GameElement.values()) {
			List<ElementObj> list = all.get(ge);
			for(int i=0;i<list.size();i++) {
				ElementObj obj=list.get(i);//读取为基类
				obj.showElement(g);//调用每个类的自己的show方法完成自己的显示
			}
		}
	}
	
	/**
	 * 线程的实现
	 */
	@Override
		public void run() {//接口实现
		while(true) {
//			System.out.println("多线程运动");
			this.repaint();
//			一般情况下，多线程都会使用一个休眠,控制速度
			try {
				Thread.sleep(10); //休眠10毫秒 1秒刷新20次
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
}
