package hnsfTest;

public class Student {
	public Student() {
		
	}
	@TestAnnotation//�൱�ڶ��������һ�����֤
	public void testA() {
		System.out.println("testA");
	}
	
	@TestAnnotation
	public void testB() {
		System.out.println("testB");
	}
}
