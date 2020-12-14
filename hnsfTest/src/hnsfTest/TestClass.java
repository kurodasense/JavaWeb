package hnsfTest;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {
	public TestClass() {}
	/**
	 * 动态调用方法
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		通过文件路径来获取类对象
		String url = "D:\\javaProjects\\hnsfTest\\src\\hnsfTest";
		File file = new File(url);
//		动态加载类，动态实例化对象
		File[] listFiles = file.listFiles();
		String[] names = new String[2];
//		for(int i=0;i<listFiles.length;i++) {
//			File f = listFiles[i];
//			System.out.println(f.getName());
//		}
		names[0] = "hnsfTest.Student";
		names[1] = "hnsfTest.TestMain";
//		有类的名字，就可以通过反射进行实例化
		for(String str:names) {
			Class<?> className = Class.forName(str);
//			可以实例化每个对象	newInstance()是调用默认构造方法
			System.out.println(className.newInstance());
			Method[] methods = className.getMethods();//得到这个类下所有的方法
			for(int i=0;i<methods.length;i++) {
//				System.out.println(methods[i]);
				Annotation[] annotations = methods[i].getAnnotations();//得到所有的注解
				for(int j=0;j<annotations.length;j++) {
					Annotation aa = annotations[j];
					if(aa instanceof TestAnnotation) {
//						执行这个方法，需要2个参数
						methods[i].invoke(className.newInstance());
					}
				}
			}
			
			
			/**
			 * 众多框架里面做的事情。注解
			 * 
			 */
		}
	}
}
