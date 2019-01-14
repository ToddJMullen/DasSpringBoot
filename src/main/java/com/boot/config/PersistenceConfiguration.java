package com.boot.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersistenceConfiguration {
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")//< name maps to spring.datasource .properties db configs
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}


	@Bean
	@ConfigurationProperties(prefix="datasource.flyway")//< name maps to datasource.flyway .properties
	@FlywayDataSource
	public DataSource flywayDataSource() {
		return DataSourceBuilder.create().build();
	}



}//PersistenceConfiguration
