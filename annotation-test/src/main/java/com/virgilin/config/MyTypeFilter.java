package com.virgilin.config;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		/**
		 * 获取当前类注解的信息
		 */
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		/**
		 * 获取当前类正在扫描类的类信息
		 */
		ClassMetadata classMetadata = metadataReader.getClassMetadata();

		String className = classMetadata.getClassName();
		System.out.println("--------"+ className);
		if (className.contains("er")) {
			return true;
		}


		return false;
	}
}
