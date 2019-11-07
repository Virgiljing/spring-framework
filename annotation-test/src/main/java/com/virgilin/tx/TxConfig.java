package com.virgilin.tx;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


@ComponentScan("com.virgilin.tx")
@Configuration
@EnableTransactionManagement
public class TxConfig {

	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/tests?useSSL=false");
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
		//Spring对@Configuration类会特殊处理；给容器中加组件的方法，多次调用都只是从容器中找组件
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
	//注册事务管理器在容器中
	@Bean
	public PlatformTransactionManager transactionManager() throws PropertyVetoException {
		return new DataSourceTransactionManager(dataSource());
	}
}
