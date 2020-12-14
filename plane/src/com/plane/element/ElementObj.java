package com.plane.element;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class ElementObj {
	/**
	 * x,y�����������棬Ѫ�����Լ�get.set����
	 */
	private int x;
	private int y;
	private int w;
	private int h;
	private ImageIcon icon;
	private boolean live=true;
	private int blood;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public int getBlood() {
		return blood;
	}
	public void setBlood(int blood) {
		this.blood=blood;
	}
	/**
	 * �вι���
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param icon
	 *
	 */
	public ElementObj(int x, int y, int w, int h, ImageIcon icon) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.icon = icon;
	}
	//�޲ι���
	public ElementObj() {
		super();
	}
	/**
	 * �滭���󷽷�
	 * @param g
	 */
	public abstract void showElement(Graphics g);
	
	public ElementObj createElementObj(String str) {
		return null;
	}
	/**
	 * ��װ
	 * @param gameTime
	 */
	protected void updateImage(long gameTime) {
		
	}
	/**
	 * �����ӵ�
	 * @param gameTime
	 */
	protected void fire(long gameTime) {
		
	}
	protected void move() {
		
	}
	public final void model(long gameTime) {
		updateImage(gameTime);
		move();
		fire(gameTime);
	}
	public void die(long gameTime) {
		
	}
	/**
	 * �������λ�øı�����λ��
	 * @param x
	 * @param y
	 */
	public void mousePosition(int x,int y) {
		
	}
	public Rectangle getRectangle() {
		return new Rectangle(x,y,w,h);
	}
	/**
	 * ��ײ���
	 * @param obj
	 * @return
	 */
	public boolean pk(ElementObj obj) {
		return this.getRectangle().intersects(obj.getRectangle());
	}
	public boolean underFire(Bullet b) {//�ܹ�������
		return false;
	}
	public void getProp(int type) {//��ȡ����
		
	}
	
}
