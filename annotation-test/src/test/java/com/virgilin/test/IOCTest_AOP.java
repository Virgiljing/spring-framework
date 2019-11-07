package com.virgilin.test;

import com.virgilin.aop.MathCalculator;
import com.virgilin.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_AOP {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		
		//1、不要自己创建对象
		MathCalculator mathCalculator1 = new MathCalculator();
		mathCalculator1.div(1, 1);
		MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
		
		mathCalculator.div(1, 11);
		
		applicationContext.close();
	}

}
