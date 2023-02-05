package com.fishfarming;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@PropertySource(value = { "classpath:application.properties" })
@Configuration
public class DatabaseConnector {
	
	@Value("${db1.driver}")
	private String driver;
	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String userName;
	@Value("${db.password}")
	private String password;
	@Value("${hibernate.hbm2ddl.auto}")
	private String createOrUpdate;
	@Value("${hibernate.show_sql}")
	private String showSql;
	@Value("${hibernate.format_sql}")
	private String formatSql;
	@Value("${hibernate.dialect}")
	private String dialect;
	
	
	/*
	Setting DB datasource values for Mysql DB
	 */
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, userName, password);
		//dataSource.setDriverClassName(driver);
		return dataSource;
	}


	/*
	Setting up Hibernate configurations
	 */
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.hbm2ddl.auto",createOrUpdate);
		properties.put("hibernate.show_sql", showSql);
		properties.put("hibernate.format_sql", formatSql);
		return properties;
	}

	/*
	Passing the created Datasource and hibernate properties to Create a Session factory
	 */
	@Primary @Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setHibernateProperties(hibernateProperties());
		factory.setPackagesToScan(new String[] { "com.fishfarming.model" });
		return factory;
	}


	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory factory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(factory);
		return transactionManager;
	}

}
