package com.virgilin;

import com.virgilin.bean.Person;
import com.virgilin.config.MainConfig;
import com.virgilin.config.MainConfig2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main2Test {
	public static void main(String[] args) {
		new FileSystemXmlApplicationContext();
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

		String[] namesForType = applicationContext.getBeanDefinitionNames();
		for (String name : namesForType) {
			System.out.println(name);
		}
	}
}
