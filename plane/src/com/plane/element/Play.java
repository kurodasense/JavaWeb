package com.plane.element;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import com.plane.loader.GameLoad;
import com.plane.manager.ElementManager;
import com.plane.manager.GameElement;

public class Play extends ElementObj{
	public Play() {
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public void showElement(Graphics g) {
		// TODO �Զ����ɵķ������
		g.drawImage(this.getIcon().getImage(),
				this.getX(), this.getY(), this.getW(),this.getH(),null);
		
	}
	/**
	 * ���ڷɻ���ʼλ��һ����ֻ��Ҫ����ɻ�Ѫ�����ɻ�����,��"1,10"�ɻ�����1��Ѫ��10���ɴ����ַ���
	 */
	@Override
	public ElementObj createElementObj(String str) {
		String [] splits=str.split(",");
		this.setX(200);
		this.setY(700);
		this.setW(80);
		this.setH(100);
		int type=new Integer(splits[0]);
		this.setIcon(GameLoad.imgMap.get("play"+type));
//		this.setIcon(new ImageIcon("image/play/3.png"));
		this.setBlood(new Integer(splits[1]));
		return this;
	}
	@Override
	public void mousePosition(int x, int y) {
		if(this.getX()>=0&&this.getX()<=500) {
			this.setX(x-40);
		}
		if(this.getY()>=0&&this.getY()<=800) {
			this.setY(y-40);
		}
	}
	private long time=0;
	private int bullettype=1;
	@Override
	public void fire(long gameTime) {
		if(gameTime-time>20) {
			time=gameTime;
			int x=this.getX()+15;
			int y=this.getY();
			ElementObj bullet=new Bullet().createElementObj(x+","+y+",3,10,playBullet"+bullettype);
			ElementManager.getManager().addElement(bullet,GameElement.BULLET);
		}
	}
	@Override
	public void getProp(int type) {
		switch(type) {
		case 1:this.setBlood(getBlood()+20);break;
		case 2:this.bullettype=2;break;
		}
	}
	@Override
	public boolean underFire(Bullet b) {
		// TODO �Զ����ɵķ������
		if(b.getType().equals("playBullet1")||b.getType().equals("playBullet2"))return false;
		this.setBlood(this.getBlood()-b.getAttack());
		if(this.getBlood()<=0) {
			this.setLive(false);
//			System.out.println(b.getType());
//			System.out.println(b);
			
		}
		return true;
	}
}
