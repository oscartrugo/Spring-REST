package com.oscartrugo.di.lifecycle.lazy;

import com.oscartrugo.di.DependencyInjectionApplication;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(value = false)
public class BeanB {

    @Autowired
    private BeanA bean;

    private static final Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

    @PostConstruct
    public void init(){
        log.info("Init Bean B");
    }
}
