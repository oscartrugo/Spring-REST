package com.oscartrugo.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:areas.properties")
public class FigurePropertyConfiguration {

    @Bean
    public PropertySourcesPlaceholderConfigurer getProperties(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
