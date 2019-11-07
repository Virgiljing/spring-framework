package spring.load;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderMain {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
		String classPath = "E:\\myproject\\spring-framework\\my-test\\src\\main\\java\\spring\\load\\Log.class";
		MyClassLoader myClassLoader = new MyClassLoader(classPath);

		String packageNamePath = "spring.load.Log";
		Class<?> log = myClassLoader.findClass(packageNamePath);
		System.out.println("类加载器是：" + log.getClassLoader());
		Method method = log.getDeclaredMethod("main", String[].class);
		Object o = log.newInstance();
		String [] arg = {"abc"};
		method.invoke(o,(Object) args);


	}
}
