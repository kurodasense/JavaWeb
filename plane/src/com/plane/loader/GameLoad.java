package com.plane.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.ImageIcon;

import com.plane.element.Boss;
import com.plane.element.ElementObj;
import com.plane.element.Enemy;
import com.plane.element.Play;
import com.plane.manager.ElementManager;
import com.plane.manager.GameElement;


//import com.tedu.element.ElementObj;
//import com.tedu.manager.ElementManager;
//import com.tedu.manager.GameElement;
//import com.tedu.manager.GameLoad;

/**
 * @˵�� ��������һ�������ࡣ���ڽ�����������ؽ�ElementManager�еĴ洢����ļ����С������Ǹ������ͼƬ��Դ
 * @author 1205918114
 *
 */
public class GameLoad {
//	��Դ������
//	private static ElementManager em = ElementManager.getManager();
//	ͼƬ���ϣ�ʹ��map�����д洢ͼƬ��String��ͼƬ�����֣�ImageIcon��ͼƬ��(ͼƬ��������ö�����ʹ��棬���������ܷ������)
	public static Map<String,ImageIcon> imgMap = new HashMap<>();
//	��ȡ�ļ�ʱ��Ҫ����
	private static Properties pro =new Properties();
	private static ElementManager em=ElementManager.getManager();
	/**
	 * @˵�� �ؿ���ȡ���������ݴ���Ĺؿ�(����ͼ)��id��Ȼ���ȡ��Ӧ��map�ļ��������Ϣ��
	 * @���� Enemy=1,2,2,5,10;1,-3,-4,12,11
	 * @param mapId
	 */
	public static void loadMap(int mapId) {
//		�õ��ļ�·��
		String mapName="com/plane/text/"+mapId+".map";
//		ʹ��io������ȡ�ļ�����   �õ��������
		ClassLoader classLoader = GameLoad.class.getClassLoader();
		InputStream maps = classLoader.getResourceAsStream(mapName);
		if(maps ==null) {
			System.out.println("�����ļ���ȡ�쳣,�����°�װ");
			return;
		}
		try {
			pro.clear();
			pro.load(maps);
//			����ֱ�Ӷ�̬�Ļ�ȡ���е�key����key�Ϳ��Ի�ȡ value
			Enumeration<?> names = pro.propertyNames();
			while(names.hasMoreElements()) {//��ȡ�������
//				һ�ε���һ��Ԫ��
				String key=names.nextElement().toString();
				System.out.println(key);
//				�Զ������ͼ��ص�����Ϣ
				String [] arrs=pro.getProperty(key).split(";");
				for(int i=0;i<arrs.length;i++) {
//					���˵�λ��
					String[] split = arrs[i].split(",");
					int type = Integer.parseInt(split[0]);//·������
					int x0 = Integer.parseInt(split[1]);//·����x����ƫ����x0
					int y0 = Integer.parseInt(split[2]);//·����y���ϵ�ƫ����y0
					int x = Integer.parseInt(split[3]);//��ʼ���ֵĵ�x'
					int t = Integer.parseInt(split[4]);//����ʱ��t
					String enemyStr = type + "," + x0 + "," + y0 + "," + x + "," + t;
					System.out.println(enemyStr);
					ElementObj enemy = new Enemy().createElementObj(enemyStr);
					em.addElement(enemy, GameElement.ENEMY);
				}
			}
			ElementObj boss=new Boss().createElementObj("6,0,0,10,4000");
			em.addElement(boss, GameElement.ENEMY);
			ElementObj map=new com.plane.element.Map().createElementObj(new Integer(mapId).toString());
			em.addElement(map, GameElement.MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @˵�� ͼƬ��Դ��ȡ��������ȡ���е�ͼƬ��Դ(���˵�ͼ(���))������˵ķɻ�ͼƬ���ӵ�ͼƬ����ҵ�ͼƬ����ȡ����ͼƬ��Ž�imgMap�С�
	 * @param mapId
	 */
	public static void loadImg() {
		String texturl="com/plane/text/GameData.pro";//�ļ�������
		ClassLoader classLoader = GameLoad.class.getClassLoader();
		InputStream texts = classLoader.getResourceAsStream(texturl);
//		imgMap���ڴ������
		pro.clear();
		try {
//			System.out.println(texts);
			pro.load(texts);
			Set<Object> set = pro.keySet();//��һ��set����
			for(Object o:set) {
				String url=pro.getProperty(o.toString());
				imgMap.put(o.toString(), new ImageIcon(url));
				System.out.println(o.toString());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @˵�� �������
	 */
	public static void loadPlay() {
		String playStr="1,10";//�ɻ����ͣ�Ѫ��
//		ElementObj play = obj.createElement(playStr);
		ElementObj play = new Play().createElementObj(playStr);
//		����,���ʹ���ʹ���֮�����϶� ����ֱ��ͨ�� �ӿڻ����ǳ�����Ϳ��Ի�ȡ��ʵ�����
//		ͨ�������ļ�����ϣ����ʹ������϶�
		em.addElement(play, GameElement.PLAY);
	}
}
