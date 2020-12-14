package com.plane.element;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

import com.plane.loader.GameLoad;

public class EnemyObj extends ElementObj{


	private int pathType; //·������
	private int x0; //x����·��ƫ����
	protected int y0; //y����·��ƫ����
	private int originX; //��ʼλ��x
	private long time=0; //����ʱ��
	protected boolean bl = false;
	@Override
	public void showElement(Graphics g) {
		if(!bl)return;
		g.drawImage(this.getIcon().getImage(), this.getX(), 
					this.getY(), this.getW(), this.getH(), null);
	}
	
	@Override
	public ElementObj createElementObj(String str) {
		String[] split = str.split(",");
		this.setPathType(Integer.parseInt(split[0])); //����·������
		this.setX0(Integer.parseInt(split[1]));//x����·��ƫ����
		this.setY0(Integer.parseInt(split[2])); //y����·��ƫ����
		this.setOriginX(Integer.parseInt(split[3])); //��ʼλ��x
		this.setX(this.getOriginX());
		this.setY(MoveWay.track(this.getPathType(), this.getX0(), this.getY0(), this.getX()));
		this.time=Long.parseLong(split[4]);
		this.setIcon(GameLoad.imgMap.get("enemy1"));
		
		return this;
	}
	
	
	@Override
	protected void updateImage(long gameTime) {
		if(gameTime > time) {
			bl = true;
		}
		if(!bl)return;
		super.updateImage(gameTime);
	}
	
	@Override
	public boolean pk(ElementObj obj) {
		// TODO �Զ����ɵķ������
		if(!bl)return false;
		return super.pk(obj);
	}
	
	/**
	 * @˵�� ���ص��˵ĳ���ʱ��
	 * @return
	 */
	public long getTime() {
		return this.time;
	}
	
	
	
	public int getPathType() {
		return pathType;
	}

	public void setPathType(int pathType) {
		this.pathType = pathType;
	}

	public int getX0() {
		return x0;
	}

	public void setX0(int x0) {
		this.x0 = x0;
	}

	public int getY0() {
		return y0;
	}

	public void setY0(int y0) {
		this.y0 = y0;
	}

	public int getOriginX() {
		return originX;
	}

	public void setOriginX(int originX) {
		this.originX = originX;
	}
	
	
}
