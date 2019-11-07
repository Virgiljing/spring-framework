package com.virgilin.config;

import com.virgilin.bean.Color;
import com.virgilin.bean.ColorFactoryBean;
import com.virgilin.bean.Person;
import com.virgilin.bean.Red;
import com.virgilin.condition.LinuxCondition;
import com.virgilin.condition.MyImportBeanDefinitionRegistrar;
import com.virgilin.condition.MyImportSelector;
import com.virgilin.condition.WindowConditions;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author Administrator
 */
@Conditional(WindowConditions.class)
@Configuration
@Import({Color.class, ColorFactoryBean.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
	//默认是单实例的
	/**
	 * ConfigurableBeanFactory#SCOPE_PROTOTYPE
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION	 sesssion
	 * @return\
	 * @Scope:调整作用域
	 * prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。
	 * 					每次获取的时候才会调用方法创建对象；
	 * singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。
	 * 			以后每次获取就是直接从容器（map.get()）中拿，
	 * request：同一次请求创建一个实例
	 * session：同一个session创建一个实例
	 *
	 * 懒加载：
	 * 		单实例bean：默认在容器启动的时候创建对象；
	 * 		懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；
	 *
	 */
//	@Scope("prototype")
	@Lazy
	@Bean("person")
	public Person person(){
		System.out.println("给容器中添加Person....");
		return new Person("张三", 25,"ss");
	}

}
