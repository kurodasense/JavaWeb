package com.plane.element;

import java.awt.Graphics;
import java.util.Random;

import com.plane.loader.GameLoad;

public class Prop extends ElementObj{
	Random random=new Random();
	private int propType=random.nextInt(2)+1;
	private long localtime=0;
	private int count=0;
	@Override
	public void showElement(Graphics g) {
		// TODO 自动生成的方法存根
		g.drawImage(this.getIcon().getImage(), this.getX(), this.getY(), this.getW(), this.getH(), null);
		
	}
	@Override
	public ElementObj createElementObj(String str) {
		String [] splits=str.split(",");
		this.setX(new Integer(splits[0]));
		this.setY(new Integer(splits[1]));
		this.setW(40);
		this.setH(40);
		this.setIcon(GameLoad.imgMap.get("prop"+propType));
		
		return this;
	}
	public int getPropType() {
		return propType;
	}
	public void move(long gametime){
		
		if(gametime>localtime+30)
		{
			localtime=gametime;
			count++;
		}
		if(count>10)this.setLive(false);
	}
	
}
