package com.dcebilingualeducation;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/dce ?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("@kika2012");
		return dataSource;
	}	
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapte = new HibernateJpaVendorAdapter();
		adapte.setDatabase(Database.MYSQL);
		adapte.setShowSql(true);
		adapte.setGenerateDdl(true);
		adapte.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		adapte.setPrepareConnection(true);
		return adapte;		
	}
}
