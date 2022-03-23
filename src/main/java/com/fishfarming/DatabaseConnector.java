package com.fishfarming;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@PropertySource(value = { "classpath:application.properties" })
@Configuration
public class DatabaseConnector {
	
	@Value("${db1.driver}")
	private String driver;
	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String userName;
	@Value("${hibernate.hbm2ddl.auto}")
	private String createOrUpdate;
	@Value("${hibernate.show_sql}")
	private String showSql;
	@Value("${hibernate.format_sql}")
	private String formatSql;
	@Value("${hibernate.dialect}")
	private String dialect;
	
	
//	@Bean
//	public DataSource getDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
//		dataSource.setDriverClassName(driverClass);
//		return dataSource;
//	}

}
