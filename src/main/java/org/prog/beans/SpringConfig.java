package org.prog.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

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
}