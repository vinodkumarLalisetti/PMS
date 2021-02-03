package org.hcl.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class AppConfig {
	public Environment environment;

	@Autowired
	public AppConfig(Environment environment) {
		super();
		this.environment = environment;
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		datasource.setUrl(environment.getProperty("jdbc.url"));
		datasource.setUsername(environment.getProperty("jdbc.username"));
		datasource.setPassword(environment.getProperty("jdbc.password"));
		return datasource;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionfactory = new LocalSessionFactoryBean();
		sessionfactory.setDataSource(getDataSource());
		sessionfactory.setPackagesToScan("org.hcl.entities");
		sessionfactory.setHibernateProperties(getHibernateProperties());
		return sessionfactory;
	}

	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		prop.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
		prop.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		return prop;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(getSessionFactory().getObject());
		return manager;
	}

}
