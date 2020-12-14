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
 * @说明 加载器，一个工具类。用于将各个对象加载进ElementManager中的存储对象的集合中。对象是各个类和图片资源
 * @author 1205918114
 *
 */
public class GameLoad {
//	资源管理器
//	private static ElementManager em = ElementManager.getManager();
//	图片集合，使用map来进行存储图片。String是图片的名字，ImageIcon是图片。(图片的名字用枚举类型代替，这样或许能方便查找)
	public static Map<String,ImageIcon> imgMap = new HashMap<>();
//	读取文件时需要的类
	private static Properties pro =new Properties();
	private static ElementManager em=ElementManager.getManager();
	/**
	 * @说明 关卡读取方法。根据传入的关卡(即地图)的id，然后读取相应的map文件里面的信息。
	 * @例子 Enemy=1,2,2,5,10;1,-3,-4,12,11
	 * @param mapId
	 */
	public static void loadMap(int mapId) {
//		得到文件路径
		String mapName="com/plane/text/"+mapId+".map";
//		使用io流来获取文件对象   得到类加载器
		ClassLoader classLoader = GameLoad.class.getClassLoader();
		InputStream maps = classLoader.getResourceAsStream(mapName);
		if(maps ==null) {
			System.out.println("配置文件读取异常,请重新安装");
			return;
		}
		try {
			pro.clear();
			pro.load(maps);
//			可以直接动态的获取所有的key，有key就可以获取 value
			Enumeration<?> names = pro.propertyNames();
			while(names.hasMoreElements()) {//获取是无序的
//				一次迭代一个元素
				String key=names.nextElement().toString();
				System.out.println(key);
//				自动创建和加载敌人信息
				String [] arrs=pro.getProperty(key).split(";");
				for(int i=0;i<arrs.length;i++) {
//					敌人的位置
					String[] split = arrs[i].split(",");
					int type = Integer.parseInt(split[0]);//路径种类
					int x0 = Integer.parseInt(split[1]);//路径在x轴上偏移量x0
					int y0 = Integer.parseInt(split[2]);//路径在y轴上的偏移量y0
					int x = Integer.parseInt(split[3]);//初始出现的点x'
					int t = Integer.parseInt(split[4]);//出现时间t
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
	 * @说明 图片资源读取方法。读取所有的图片资源(除了地图(大概))，如敌人的飞机图片、子弹图片、玩家的图片。读取到的图片会放进imgMap中。
	 * @param mapId
	 */
	public static void loadImg() {
		String texturl="com/plane/text/GameData.pro";//文件的命名
		ClassLoader classLoader = GameLoad.class.getClassLoader();
		InputStream texts = classLoader.getResourceAsStream(texturl);
//		imgMap用于存放数据
		pro.clear();
		try {
//			System.out.println(texts);
			pro.load(texts);
			Set<Object> set = pro.keySet();//是一个set集合
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
	 * @说明 加载玩家
	 */
	public static void loadPlay() {
		String playStr="1,10";//飞机类型，血量
//		ElementObj play = obj.createElement(playStr);
		ElementObj play = new Play().createElementObj(playStr);
//		解耦,降低代码和代码之间的耦合度 可以直接通过 接口或者是抽象父类就可以获取到实体对象
//		通过配置文件的耦合，降低代码的耦合度
		em.addElement(play, GameElement.PLAY);
	}
}
