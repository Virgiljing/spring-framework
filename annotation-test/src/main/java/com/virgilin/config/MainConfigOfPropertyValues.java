package com.virgilin.config;

import com.virgilin.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value={"classpath:/person.properties"},encoding = "utf-8")
@Configuration
public class MainConfigOfPropertyValues {

	@Bean
	public Person person(){
		return new Person();
	}

}
