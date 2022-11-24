package com.application.covid.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@EnableJpaRepositories(
        basePackages = "com.application.covid.repo.db1"
)
@Configuration
public class DataSource1Configuration {

    @Autowired
    DataSource dataSource;

    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDB1(){
        return dataSource;
    }
}
