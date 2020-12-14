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
	public void run() {//��Ϸ��run����
		int level=2;
		int state=3;
		while(true){//֮����Խ�true��Ϊһ���������ڿ��ƽ���

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
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}

			gameOver();
			
			if(level>=state)level=0;
			
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}

		
	}
	/**
	 * ��Ϸ�ļ���
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
					// TODO �Զ����ɵ� catch ��
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
	 * @˵�� ��Ϸ����ʱ
	 * @����˵�� ��Ϸ����������Ҫ�������飺
	 *          1.�Զ�����ҵ��ƶ�����ײ������
	 *          2.��Ԫ�ص����ӣ�NPC��������ֵ��ߣ�
	 *          3.��Ϸ��ͣ�ȵ�
	 */
	private int gameRun(int level) {
		long gameTime=0L;
		boolean live=false;
		while(true){//Ԥ����չ  true���Ա�Ϊ���������ڿ��ƹؿ������ȡ�
			Map<GameElement, List<ElementObj>> all = em.getGameElements();
			
			moveAudUpdate(all, gameTime);//��ϷԪ���Զ�������
			
			List<ElementObj> enemys=em.getElementsByKey(GameElement.ENEMY);
			List<ElementObj> bullets=em.getElementsByKey(GameElement.BULLET);
			List<ElementObj> plays=em.getElementsByKey(GameElement.PLAY);
			List<ElementObj> props=em.getElementsByKey(GameElement.PROP);

			ElementPk(enemys,bullets);
			ElementPk(plays, bullets);
			ElementPk(plays, props);
			
			
			gameTime++;//Ψһ��ʱ�����
			
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
				sleep(10);//Ĭ�����Ϊ1��ˢ��100��
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
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
	 * ��Ϸ�л��ؿ�
	 */
	private int gameOver() {
		// TODO �Զ����ɵķ������
		Map<GameElement, List<ElementObj>> all = em.getGameElements();
		Set<GameElement> set = all.keySet();//�õ����е�key����
		for(GameElement ge:set){//������
			List<ElementObj> list=all.get(ge);
			list.clear();
		}
		return 0;
	}
	
//	��ϷԪ���Զ�������
	private void moveAudUpdate(Map<GameElement, List<ElementObj>> all,long gameTime){
		Set<GameElement> set = all.keySet();//�õ����е�key����
		for(GameElement ge:set){//������
			List<ElementObj> list = all.get(ge);
			for(int i=list.size()-1;i>=0;i--)  //���ַ�ʽ���Բ���iֵ���б仯 
			{
				ElementObj obj=list.get(i);//��ȡΪ����
				if(!obj.isLive()){
//					System.out.println(obj);
					obj.die(gameTime);//�ڲ�����ʵ���Լ�����
					list.remove(i);
					continue;
				}
				obj.model(gameTime);
			}
		}
	}

}
