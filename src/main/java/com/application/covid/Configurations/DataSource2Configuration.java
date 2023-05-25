package com.application.covid.Configurations;

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

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@EnableJpaRepositories(
        basePackages = "com.application.covid.repo.db2",
        entityManagerFactoryRef = "db2EntityManagerFactory",
        transactionManagerRef = "db2TransactionManager"
)
@Configuration
public class DataSource2Configuration {

    @Bean(name = "db2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("db2DataSource") DataSource dataSource) {

        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");

        return builder
                .dataSource(dataSource)
                .packages("com.application.covid.Models.db2")
                .persistenceUnit("db2")
                .properties(properties)
                .build();
    }

    @Bean(name = "db2TransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("db2EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
