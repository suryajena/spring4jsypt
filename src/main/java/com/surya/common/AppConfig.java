/*package com.surya.common;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.jasypt.spring3.properties.EncryptablePropertyPlaceholderConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan(basePackages = {"com.surya.common","com.surya.customer.dao" })
 @PropertySource("classpath:database.properties")
public class AppConfig {
	@Autowired
	private Environment env;
	//Access denied for user 'root'@'localhost' (using password: YES)
	@Bean//("dataSource")
	public DataSource dataSource() throws SQLException {
	  DriverManagerDataSource ds = new DriverManagerDataSource();
	  ds.setDriverClassName("com.mysql.jdbc.Driver");
	  ds.setUsername(env.getRequiredProperty("dataSource.username"));
	  //ds.setPassword(env.getRequiredProperty("dataSource.password"));
	  ds.setPassword(env.getRequiredProperty("dataSource.password"));
	  ds.setUrl("jdbc:mysql://localhost:3306/testDb");
	  return ds;
	}
	
	@Bean("propertyPlaceholderConfigurer")
	public EncryptablePropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		EncryptablePropertyPlaceholderConfigurer configurer = new EncryptablePropertyPlaceholderConfigurer(stringEncryptor());
		configurer.setLocation(new ClassPathResource("database.properties"));
		return configurer;
	}
	 
		
	@Bean("environmentVariablesConfiguration")
	public EnvironmentStringPBEConfig environmentVariablesConfiguration() {
	   EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
	   config.setAlgorithm("PBEWITHMD5ANDDES");
	   config.setPasswordEnvName("CAS_PBE_PASSWORD");
	   return config;
	}
	 
	@Bean("configurationEncryptor")
	public StandardPBEStringEncryptor  stringEncryptor() {
		StandardPBEStringEncryptor  encryptor = new StandardPBEStringEncryptor ();
	   encryptor.setConfig(environmentVariablesConfiguration());
	   return encryptor;
	}
	 

}*/