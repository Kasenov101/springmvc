package com.kasenov.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.kasenov")
@EnableTransactionManagement
@PropertySource(value = "classpath:database.properties")
public class HibernateConfig {

    private Environment environment;

    @Autowired
    public HibernateConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(getDataSource());
        sessionFactoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
        sessionFactoryBean.setPackagesToScan("com.kasenov.entity");
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public DataSource getDataSource() {
        //ComboPooledDataSource dataSource = new ComboPooledDataSource();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("connection.driver_class"));
        dataSource.setUrl(environment.getRequiredProperty("connection.url"));
        dataSource.setUsername(environment.getRequiredProperty("connection.username"));
        dataSource.setPassword(environment.getRequiredProperty("connection.password"));
        return dataSource;
    }
}