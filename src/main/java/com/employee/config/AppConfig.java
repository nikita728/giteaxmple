package com.employee.config;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages="com.employee")
@PropertySource(value= {"classpath:application.properties"})
@EnableWebMvc
public class AppConfig {
	
	@Autowired
	private Environment env;
	@Bean
	public InternalResourceViewResolver resolver()
	{
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public DataSource datasources()
	{
		DriverManagerDataSource datasources= new DriverManagerDataSource();
		datasources.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
		datasources.setUrl(env.getRequiredProperty("jdbc.url"));
		datasources.setUsername(env.getRequiredProperty("jdbc.username"));
		datasources.setPassword(env.getRequiredProperty("jdbc.password"));
		return datasources;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSources)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSources);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
		
	}

	
	

}
