package com.application.covid.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@EnableJpaRepositories(
        basePackages = "com.application.covid.repo.db2"
)
@Configuration
public class DataSource2Configuration {

    @Autowired
    DataSource dataSource;

    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSource getDB2(){
        return dataSource;
    }
}
