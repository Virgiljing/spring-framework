package com.virgilin;

import com.virgilin.bean.Person;
import com.virgilin.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person bean = (Person) applicationContext.getBean("person");
		Person bean1 = (Person) applicationContext.getBean("person1");
		System.out.println(bean);
		System.out.println(bean1);
		String[] namesForType = applicationContext.getBeanDefinitionNames();
		for (String name : namesForType) {
			System.out.println(name);
		}
	}
}
