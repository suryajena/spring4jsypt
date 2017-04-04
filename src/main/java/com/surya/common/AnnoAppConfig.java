package com.surya.common;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.jasypt.spring3.properties.EncryptablePropertyPlaceholderConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
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
@ComponentScan(basePackages = "com.surya")
public class AnnoAppConfig {


	@Value("${dataSource.username}")
	private String username;

	@Value("${dataSource.password}")
	private String password;


	@Bean 
	public DataSource dataSource() throws SQLException {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setUrl("jdbc:mysql://localhost:3306/testDb");
		return ds;
	}

	@Bean
	public static EnvironmentStringPBEConfig environmentVariablesConfiguration() {
		EnvironmentStringPBEConfig environmentVariablesConfiguration = new EnvironmentStringPBEConfig();
		environmentVariablesConfiguration.setAlgorithm("PBEWITHMD5ANDDES");
		//environmentVariablesConfiguration.setPasswordEnvName("CAS_PBE_PASSWORD");
		//super.setPassword(System.getenv(passwordEnvName));
		 environmentVariablesConfiguration.setPassword("master password");
		return environmentVariablesConfiguration;
	}

	@Bean
	public static StringEncryptor configurationEncryptor() {
		StandardPBEStringEncryptor configurationEncryptor = new StandardPBEStringEncryptor();
		configurationEncryptor.setConfig(environmentVariablesConfiguration());
		return configurationEncryptor;
	}

	@Bean
	public static PropertyPlaceholderConfigurer propertyConfigurer() {
		EncryptablePropertyPlaceholderConfigurer propertyConfigurer = new EncryptablePropertyPlaceholderConfigurer(configurationEncryptor());
		propertyConfigurer.setLocation(new ClassPathResource("database.properties"));
		//        propertyConfigurer.setLocation(resource);
		return propertyConfigurer;
	}
	 



}