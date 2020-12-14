package com.plane.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.plane.element.ElementObj;

/**
 * @说明 本类是元素管理器，专门存储所有的元素，同时，提供方法
 * 		给予视图和控制获取数据
 */
public class ElementManager {

	private Map<GameElement,List<ElementObj>> gameElements;	
	public Map<GameElement, List<ElementObj>> getGameElements() {
		return gameElements;
	}
//	添加元素(多半由加载器调用)
	public void addElement(ElementObj obj,GameElement ge) {
		gameElements.get(ge).add(obj);//添加对象到集合中，按key值就行存储
	}
//	依据key返回 list集合，取出某一类元素
	public List<ElementObj> getElementsByKey(GameElement ge){
		return gameElements.get(ge);
	}	

	private static ElementManager EM=null; //引用
//	synchronized线程锁->保证本方法执行中只有一个线程
	public static synchronized ElementManager getManager() {
		if(EM == null) {//控制判定
			EM=new ElementManager();
		}
		return EM;
	}
	private ElementManager() {
		init(); 
	}

	public void init() {
		gameElements=new HashMap<GameElement,List<ElementObj>>();
		for(GameElement ge:GameElement.values()) { //通过循环读取枚举类型的方式添加集合
			gameElements.put(ge,new ArrayList<ElementObj>());
		}
	}
	
}







