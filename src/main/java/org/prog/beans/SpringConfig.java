package org.prog.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfig {


    @Value("${my.db.url}")
    private String dbUrl;

    @Value("${my.db.user}")
    private String userName;

    @Value("${my.db.password}")
    private String password;

    @Value("${my.db.driver}")
    private String driverName;

    @Value("google.com")
    private String beanOneValue;

    @Value("${my.bean.two.value}")
    private String beanTwoValue;

    @Bean(name = "beanOne")
    public MyBean myBeanOne() {
        return new MyBean(beanOneValue);
    }

    @Bean(name = "beanTwo")
    public MyBean myBeanTwo() {
        return new MyBean(beanTwoValue);
    }

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(dbUrl, userName, password);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
}