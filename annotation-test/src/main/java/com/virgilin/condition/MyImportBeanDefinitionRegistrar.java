package com.virgilin.condition;

import com.virgilin.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean definition = registry.containsBeanDefinition("com.virgilin.bean.Red");
		boolean definition1 = registry.containsBeanDefinition("com.virgilin.bean.Blue");
		if (definition && definition1) {
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
			registry.registerBeanDefinition("rainRow",rootBeanDefinition);
		}
	}
}
