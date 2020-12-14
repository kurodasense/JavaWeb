package com.plane.element;

import com.plane.loader.GameLoad;
import com.plane.manager.ElementManager;
import com.plane.manager.GameElement;

public class Boss extends EnemyObj{

	private long time=0;
	private long appeartime=0;
	
	public Boss() {
		this.setBlood(100);
	}
	
	@Override
	public ElementObj createElementObj(String str) {
		super.createElementObj(str);
		this.setIcon(GameLoad.imgMap.get("boss1"));
		this.setW(80);
		this.setH(80);
//		System.out.println(GameLoad.imgMap.get("enemy1"));
		appeartime=super.getTime();
		time=appeartime;
		
		return this;
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
			
			ElementObj bullet1=new Bullet().createElementObj(this.getX()+","+y+",3,10,enemyBullet1");
			ElementManager.getManager().addElement(bullet1, GameElement.BULLET);
			
			ElementObj bullet2=new Bullet().createElementObj((x + this.getW()/2)+","+y+",3,10,enemyBullet1");
			ElementManager.getManager().addElement(bullet2, GameElement.BULLET);
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
		this.setX(MoveWay.gox(6,(int)(time-appeartime)));
		this.setY(100);
		System.out.println(getX()+","+getY());
	}
	
	@Override
	public boolean underFire(Bullet b) {
		if(!bl)return false;
		if(!b.getType().equals("playBullet1")&&!b.getType().equals("playBullet2"))return false;
		this.setBlood(this.getBlood() - b.getAttack()); 
		if(this.getBlood() <= 0) {
			this.setLive(false);
		}
		return true;
	}
}