package com.backend.vetter;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.backend.vetter",
        entityManagerFactoryRef = "backendvetterEntityManagerFactory",
        transactionManagerRef = "backendvetterTransactionManager")

public class VetterDatasourceConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.vetter")
    public DataSourceProperties backendvetterDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.vetter.configuration")
    public DataSource backendvetterDataSource() {
        DataSource dataSource = backendvetterDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();


        return dataSource;
    }

    @Primary
    @Bean(name = "backendvetterEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean backendvetterEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(backendvetterDataSource())
                .packages("com.backend.vetter")
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager backendvetterTransactionManager(
            final @Qualifier("backendvetterEntityManagerFactory") LocalContainerEntityManagerFactoryBean backendvetterEntityManagerFactory) {
        return new JpaTransactionManager(backendvetterEntityManagerFactory.getObject());
    }

}