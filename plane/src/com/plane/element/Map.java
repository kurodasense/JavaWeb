package com.plane.element;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import com.plane.loader.GameLoad;

public class Map extends ElementObj{
//	背景类型 未使用
	private String mapType;
//	背景图片滚动速度
	private int movespeed=2;
//	背景图片Y值的初始位置
	public int y=0;
	
	
//	无参构造
	public Map() {};
	
	public void showElement(Graphics g) {
		g.drawImage(this.getIcon().getImage(), 0, y,500,800, null);
		g.drawImage(this.getIcon().getImage(), 0, y-800, 500,800,null);
	};
//	传入地图类型,str为数字代表图片
	public ElementObj createElementObj(String str) {
		ImageIcon  icon=GameLoad.imgMap.get("map"+str);
		
		this.setIcon(icon);
		return this;
	};
//	实现背景移动
	protected void move() {
		if(y>=800)
			y=0;
		y+=movespeed;
	};
}
