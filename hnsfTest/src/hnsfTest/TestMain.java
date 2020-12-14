package hnsfTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMain {
	/**
	 * 对象的排除
	 * 
	 * @param args
	 */
	@TestAnnotation
	public void testC() {
		System.out.println("testC");
	}
	
	public TestMain() {}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		List<String> list = new ArrayList<>();
		list.add("ccc");
		list.add("aaa");
		list.add("abc");
		list.add("cac");
		Collections.sort(list);
		
	}
	
}
