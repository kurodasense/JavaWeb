package com.plane.element;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import com.plane.loader.GameLoad;
import com.plane.manager.ElementManager;
import com.plane.manager.GameElement;

public class Boom extends ElementObj{
	private int imgx=0;
	private long time=0;

	@Override
	public void showElement(Graphics g) {
		// TODO 自动生成的方法存根
		g.drawImage(this.getIcon().getImage(),
				this.getX(), this.getY(),
				this.getX()+this.getW()/8, this.getY()+this.getH(),
				imgx*65, 0, 
				65+65*imgx, 62,
				null);
	}
	
	@Override
	protected void updateImage(long gameTime) {
		if(gameTime-time>5) {
			time=gameTime;
			imgx++;
			if(imgx>7) {
				this.setLive(false);
			}
		}
	}
	
	@Override
	public ElementObj createElementObj(String str) {
		String [] splits=str.split(",");
		this.setX(new Integer(splits[0]));
		this.setY(new Integer(splits[1]));
		ImageIcon icon=GameLoad.imgMap.get("boom");
		this.setIcon(icon);
		this.setW(icon.getIconWidth());
		this.setH(icon.getIconHeight());
		
		return this;
	}
	@Override
	public void die(long gameTime) {
		int x=getX();
		int y=getY();
		ElementObj prop = new Prop().createElementObj(this.getX() + "," + this.getY());
		ElementManager.getManager().addElement(prop, GameElement.PROP);
		
	}
}
