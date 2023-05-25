package com.application.covid.Configurations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@EnableJpaRepositories(
        basePackages = "com.application.covid.repo.db1",
        entityManagerFactoryRef = "db1EntityManagerFactory",
        transactionManagerRef = "db1TransactionManager"
)
@Configuration
public class DataSource1Configuration {

    @Primary
    @Bean(name = "db1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "db1EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("db1DataSource") DataSource dataSource) {

        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create");

        return builder
                .dataSource(dataSource)
                .packages("com.application.covid.Models.db1")
                .persistenceUnit("db1")
                .properties(properties)
                .build();
    }

    @Primary
    @Bean(name = "db1TransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("db1EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
