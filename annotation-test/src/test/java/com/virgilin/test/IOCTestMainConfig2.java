package com.virgilin.test;

import com.virgilin.bean.Blue;
import com.virgilin.bean.Person;
import com.virgilin.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class IOCTestMainConfig2 {
	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);


	@Test
	public void test01(){
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
	}
	@Test
	public void test02(){

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();


		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}


		Object person = applicationContext.getBean("person");
		Object person2 = applicationContext.getBean("person");
		System.out.println(person==person2);

	}

	@Test
	public void test03(){

		String[] beanDefinitionNames = applicationContext.getBeanNamesForType(Person.class);
		Environment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("os.name");
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
		System.out.println(property);
		Map<String, Person> personMap = applicationContext.getBeansOfType(Person.class);
		System.out.println(personMap);

	}
	private void printBeans(ApplicationContext applicationContext){
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}

	@Test
	public void testImport(){
		printBeans(applicationContext);
		Blue bean = applicationContext.getBean(Blue.class);
		System.out.println(bean);

		//工厂Bean获取的是调用getObject创建的对象
		Object bean2 = applicationContext.getBean("com.virgilin.bean.ColorFactoryBean");
		Object bean3 = applicationContext.getBean("com.virgilin.bean.ColorFactoryBean");
		System.out.println("bean的类型："+bean2.getClass());
		System.out.println(bean2 == bean3);

		Object bean4 = applicationContext.getBean("&com.virgilin.bean.ColorFactoryBean");
		System.out.println(bean4.getClass());
	}
}
