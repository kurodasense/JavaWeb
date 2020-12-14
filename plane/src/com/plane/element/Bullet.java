package com.plane.element;

import java.awt.Graphics;

import com.plane.loader.GameLoad;

public class Bullet extends ElementObj{
	
	private int orgattack;
	private int attack;
	private int speed;
	private String type;
	
	public Bullet() {
		// TODO 自动生成的构造函数存根
	}

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
		this.setW(10);
		this.setH(20);
		this.setAttack(new Integer(splits[2]));
		orgattack=attack;
		this.setSpeed(new Integer(splits[3]));
		this.setType(splits[4]);
		this.setIcon(GameLoad.imgMap.get(this.getType()));
		
		return this;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	protected void move() {
		if(this.getX()>=0&&this.getX()<=500&&this.getY()>=0&&this.getY()<=800)
		{
			switch(this.getType()) {
			case "playBullet1":this.setY(this.getY()-speed);break;
			case "playBullet2":this.setY(this.getY()-speed);this.setAttack(orgattack+3);break;
			case "enemyBullet1":this.setY(this.getY()+speed);break;
			case "enemyBullet2":this.setY(this.getY()+speed);this.setAttack(orgattack+3);break;
			case "bossBullet1":this.setY(this.getY()+speed);break;
			}
		}
		else {
			this.setLive(false);
		}
	}
	
}
