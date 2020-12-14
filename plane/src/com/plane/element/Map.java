package com.plane.element;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import com.plane.loader.GameLoad;

public class Map extends ElementObj{
//	�������� δʹ��
	private String mapType;
//	����ͼƬ�����ٶ�
	private int movespeed=2;
//	����ͼƬYֵ�ĳ�ʼλ��
	public int y=0;
	
	
//	�޲ι���
	public Map() {};
	
	public void showElement(Graphics g) {
		g.drawImage(this.getIcon().getImage(), 0, y,500,800, null);
		g.drawImage(this.getIcon().getImage(), 0, y-800, 500,800,null);
	};
//	�����ͼ����,strΪ���ִ���ͼƬ
	public ElementObj createElementObj(String str) {
		ImageIcon  icon=GameLoad.imgMap.get("map"+str);
		
		this.setIcon(icon);
		return this;
	};
//	ʵ�ֱ����ƶ�
	protected void move() {
		if(y>=800)
			y=0;
		y+=movespeed;
	};
}
