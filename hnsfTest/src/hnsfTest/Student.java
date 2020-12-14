package hnsfTest;

public class Student {
	public Student() {
		
	}
	@TestAnnotation//相当于对这个方法一个身份证
	public void testA() {
		System.out.println("testA");
	}
	
	@TestAnnotation
	public void testB() {
		System.out.println("testB");
	}
}
