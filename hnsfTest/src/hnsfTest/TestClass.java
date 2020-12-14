package hnsfTest;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {
	public TestClass() {}
	/**
	 * ��̬���÷���
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		ͨ���ļ�·������ȡ�����
		String url = "D:\\javaProjects\\hnsfTest\\src\\hnsfTest";
		File file = new File(url);
//		��̬�����࣬��̬ʵ��������
		File[] listFiles = file.listFiles();
		String[] names = new String[2];
//		for(int i=0;i<listFiles.length;i++) {
//			File f = listFiles[i];
//			System.out.println(f.getName());
//		}
		names[0] = "hnsfTest.Student";
		names[1] = "hnsfTest.TestMain";
//		��������֣��Ϳ���ͨ���������ʵ����
		for(String str:names) {
			Class<?> className = Class.forName(str);
//			����ʵ����ÿ������	newInstance()�ǵ���Ĭ�Ϲ��췽��
			System.out.println(className.newInstance());
			Method[] methods = className.getMethods();//�õ�����������еķ���
			for(int i=0;i<methods.length;i++) {
//				System.out.println(methods[i]);
				Annotation[] annotations = methods[i].getAnnotations();//�õ����е�ע��
				for(int j=0;j<annotations.length;j++) {
					Annotation aa = annotations[j];
					if(aa instanceof TestAnnotation) {
//						ִ�������������Ҫ2������
						methods[i].invoke(className.newInstance());
					}
				}
			}
			
			
			/**
			 * �ڶ��������������顣ע��
			 * 
			 */
		}
	}
}
