package test.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.xml.User;


public class Test {
	@org.junit.Test
	public void testNameSpaceHandler(){
		ApplicationContext actx = new ClassPathXmlApplicationContext("beans.xml");
		User user = (User) actx.getBean("user");
		System.out.println(user);
	}
}
