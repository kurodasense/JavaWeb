package com.plane.element;

import com.plane.loader.GameLoad;
import com.plane.manager.ElementManager;
import com.plane.manager.GameElement;

public class Enemy extends EnemyObj{
	
	
	private long time=0;
	private long appeartime=0;

	public Enemy() {
		if(this.getPathType() == 1) {
			this.setBlood(6);
		}
		if(this.getPathType() == 2) {
			this.setBlood(9);
		}
	}
	
	@Override
	public ElementObj createElementObj(String str) {
		this.setIcon(GameLoad.imgMap.get("enemy1"));
		this.setW(30);
		this.setH(30);
//		System.out.println(GameLoad.imgMap.get("enemy1"));
		appeartime=super.getTime();
		return super.createElementObj(str);
	}
	
	@Override
	protected void fire(long gameTime) {
		if(!bl)return;
		if(gameTime-time>50) {
			time=gameTime;
			int x=this.getX() + (this.getW()/2);
			int y=this.getY();
			ElementObj bullet=new Bullet().createElementObj(x+","+y+",3,10,enemyBullet1");
			ElementManager.getManager().addElement(bullet, GameElement.BULLET);
		}
	}
	
	@Override
	public void die(long gameTime) {
		ElementObj boom = new Boom().createElementObj(this.getX() + "," + this.getY());
		ElementManager.getManager().addElement(boom, GameElement.BOOM);
		
	}
	
	@Override
	protected void move() {
		if(!bl)return;
		if(this.getX()<0||this.getX()>500) {
			this.setLive(false);;
		}
		if(this.getY()<0||this.getY()>800) {
			this.setLive(false);;
		}
		this.setX(MoveWay.gox(this.getPathType(), this.getX()));
		this.setY(MoveWay.track(this.getPathType(), this.getX0(), this.getY0(), this.getX()));
		if(getPathType()==5)y0+=2;
//		System.out.println(getX()+","+getY());
	}
	
	@Override
	public boolean underFire(Bullet b) {
		if(!b.getType().equals("playBullet1")&&!b.getType().equals("playBullet2"))return false;
		this.setBlood(this.getBlood() - b.getAttack()); 
		if(this.getBlood() <= 0) {
			this.setLive(false);
		}
		return true;
	}
	
}
