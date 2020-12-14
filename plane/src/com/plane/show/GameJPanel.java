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
 * @˵�� ��Ϸ����ʾ���棬 ������ʾ��ˢ����Ϸ����(��Ϸ����Ҫ���)
 * @author 1205918114
 * @����˵�� ��Ҫ����Ԫ�ص���ʾ��ͬʱ���н����ˢ��(���߳�)
 * @�̳кͽӿ� �̳���JPanel,ʵ��Runnable�ӿڣ�����ɽ����ˢ��
 */
public class GameJPanel extends JPanel implements Runnable{
//	Ԫ�ع�����
	private ElementManager em;
	
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public GameJPanel() {
		init();
	}
	/**
	 * ʵ�ʵĹ��췽����������Ĭ�Ϲ��췽����
	 */
	public void init() {
		em = ElementManager.getManager();//�õ�Ԫ�ع���������
	}
	
	/**
	 * @˵�� ��ʾԪ�ع������е�����Ԫ��(�����ÿ��Ԫ������ķ���������Լ�����ʾ)
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);  //���ø����paint����
		Map<GameElement, List<ElementObj>> all = em.getGameElements();
		for(GameElement ge:GameElement.values()) {
			List<ElementObj> list = all.get(ge);
			for(int i=0;i<list.size();i++) {
				ElementObj obj=list.get(i);//��ȡΪ����
				obj.showElement(g);//����ÿ������Լ���show��������Լ�����ʾ
			}
		}
	}
	
	/**
	 * �̵߳�ʵ��
	 */
	@Override
		public void run() {//�ӿ�ʵ��
		while(true) {
//			System.out.println("���߳��˶�");
			this.repaint();
//			һ������£����̶߳���ʹ��һ������,�����ٶ�
			try {
				Thread.sleep(10); //����10���� 1��ˢ��20��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
}
