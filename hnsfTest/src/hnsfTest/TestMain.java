package hnsfTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMain {
	/**
	 * ������ų�
	 * 
	 * @param args
	 */
	@TestAnnotation
	public void testC() {
		System.out.println("testC");
	}
	
	public TestMain() {}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		List<String> list = new ArrayList<>();
		list.add("ccc");
		list.add("aaa");
		list.add("abc");
		list.add("cac");
		Collections.sort(list);
		
	}
	
}
