package com.plane.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.plane.element.Bullet;
import com.plane.element.ElementObj;
import com.plane.element.Prop;
import com.plane.loader.GameLoad;
import com.plane.manager.ElementManager;
import com.plane.manager.GameElement;


public class GameThread extends Thread{
	private ElementManager em;
	
	public GameThread(){
		em=ElementManager.getManager();
	}
	
	@Override
	public void run() {//游戏的run方法
		int level=2;
		int state=3;
		while(true){//之后可以将true变为一个变量用于控制结束

			level=gameLoad(level);
			if(level==0)
			{
				gameOver();
				level++;
				continue;
			}

			level=gameRun(level);
			try {
				sleep(1000);
			} catch (InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}

			gameOver();
			
			if(level>=state)level=0;
			
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

		
	}
	/**
	 * 游戏的加载
	 */

	private int gameLoad(int level) {
		if(level==0)
		{
			ElementManager em=ElementManager.getManager();
			ElementObj map=new com.plane.element.Map().createElementObj(new Integer(0).toString());
			em.addElement(map, GameElement.MAP);

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			
			return 0;
		}
		GameLoad.loadImg();
		GameLoad.loadMap(level);
		GameLoad.loadPlay();
		return level;
		
	}
	/**
	 * @说明 游戏进行时
	 * @任务说明 游戏过程这种需要做的事情：
	 *          1.自动化玩家的移动，碰撞，死亡
	 *          2.新元素的增加（NPC死亡后出现道具）
	 *          3.游戏暂停等等
	 */
	private int gameRun(int level) {
		long gameTime=0L;
		boolean live=false;
		while(true){//预留扩展  true可以变为变量，用于控制关卡结束等。
			Map<GameElement, List<ElementObj>> all = em.getGameElements();
			
			moveAudUpdate(all, gameTime);//游戏元素自动化方法
			
			List<ElementObj> enemys=em.getElementsByKey(GameElement.ENEMY);
			List<ElementObj> bullets=em.getElementsByKey(GameElement.BULLET);
			List<ElementObj> plays=em.getElementsByKey(GameElement.PLAY);
			List<ElementObj> props=em.getElementsByKey(GameElement.PROP);

			ElementPk(enemys,bullets);
			ElementPk(plays, bullets);
			ElementPk(plays, props);
			
			
			gameTime++;//唯一的时间控制
			
			List<ElementObj> play=em.getElementsByKey(GameElement.PLAY);
			live=false;
			for(ElementObj p:play)
			{
				if(p.isLive())live=true;
			}
			if(live==false)
			{
				level=3;
				break;
			}
			for(ElementObj e:enemys)
			{
				if(e.isLive())live=false;
			}
			if(live==true)
			{
				level++;
				break;
			}
			
			try {
				sleep(10);//默认理解为1秒刷新100次
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
		return level;
	}
	private void ElementPk(List<ElementObj> listA,List<ElementObj> listB){
		
		for(int i=0;i<listA.size();i++){
			ElementObj enemy=listA.get(i);
			for(int j=0;j<listB.size();j++){
				ElementObj file=listB.get(j);
				if(enemy.pk(file)){
					if((file instanceof Bullet))
					{				
						Bullet bullet=(Bullet)file;
						if(enemy.underFire(bullet))
						{
							file.setLive(false);
						}
						break;
					}
					if(file instanceof Prop)
					{
						Prop prop=(Prop)file;
						enemy.getProp(prop.getPropType());
						prop.setLive(false);
					}
				}
			}
		}
	}
	/**
	 * 游戏切换关卡
	 */
	private int gameOver() {
		// TODO 自动生成的方法存根
		Map<GameElement, List<ElementObj>> all = em.getGameElements();
		Set<GameElement> set = all.keySet();//得到所有的key集合
		for(GameElement ge:set){//迭代器
			List<ElementObj> list=all.get(ge);
			list.clear();
		}
		return 0;
	}
	
//	游戏元素自动化方法
	private void moveAudUpdate(Map<GameElement, List<ElementObj>> all,long gameTime){
		Set<GameElement> set = all.keySet();//得到所有的key集合
		for(GameElement ge:set){//迭代器
			List<ElementObj> list = all.get(ge);
			for(int i=list.size()-1;i>=0;i--)  //这种方式可以不对i值进行变化 
			{
				ElementObj obj=list.get(i);//读取为基类
				if(!obj.isLive()){
//					System.out.println(obj);
					obj.die(gameTime);//内部方法实现自己补充
					list.remove(i);
					continue;
				}
				obj.model(gameTime);
			}
		}
	}

}
