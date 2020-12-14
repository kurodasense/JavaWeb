package com.plane.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.plane.element.ElementObj;

/**
 * @˵�� ������Ԫ�ع�������ר�Ŵ洢���е�Ԫ�أ�ͬʱ���ṩ����
 * 		������ͼ�Ϳ��ƻ�ȡ����
 */
public class ElementManager {

	private Map<GameElement,List<ElementObj>> gameElements;	
	public Map<GameElement, List<ElementObj>> getGameElements() {
		return gameElements;
	}
//	���Ԫ��(����ɼ���������)
	public void addElement(ElementObj obj,GameElement ge) {
		gameElements.get(ge).add(obj);//��Ӷ��󵽼����У���keyֵ���д洢
	}
//	����key���� list���ϣ�ȡ��ĳһ��Ԫ��
	public List<ElementObj> getElementsByKey(GameElement ge){
		return gameElements.get(ge);
	}	

	private static ElementManager EM=null; //����
//	synchronized�߳���->��֤������ִ����ֻ��һ���߳�
	public static synchronized ElementManager getManager() {
		if(EM == null) {//�����ж�
			EM=new ElementManager();
		}
		return EM;
	}
	private ElementManager() {
		init(); 
	}

	public void init() {
		gameElements=new HashMap<GameElement,List<ElementObj>>();
		for(GameElement ge:GameElement.values()) { //ͨ��ѭ����ȡö�����͵ķ�ʽ��Ӽ���
			gameElements.put(ge,new ArrayList<ElementObj>());
		}
	}
	
}







