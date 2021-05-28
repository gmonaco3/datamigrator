package com.example.demo;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "oldEntityManagerFactory",
  transactionManagerRef = "oldTransactionManager",
  basePackages = { "com.example.demo.old.repository" }
)
public class OldDBConfig {
	
	  @Bean(name = "oldDataSource")
	  @ConfigurationProperties(prefix = "old.datasource")
	  public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	  }
	  
	  @Bean(name = "oldEntityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean 
	  oldEntityManagerFactory(
	    EntityManagerFactoryBuilder builder,
	    @Qualifier("oldDataSource") DataSource dataSource
	  ) {
	    return builder
	      .dataSource(dataSource)
	      .packages("com.example.demo.dto")
	      .persistenceUnit("oldDB")
	      .build();
	  }
	    
	  @Bean(name = "oldTransactionManager")
	  public PlatformTransactionManager oldTransactionManager(
	    @Qualifier("oldEntityManagerFactory") EntityManagerFactory 
	    oldEntityManagerFactory
	  ) {
	    return new JpaTransactionManager(oldEntityManagerFactory);
	  }

}
