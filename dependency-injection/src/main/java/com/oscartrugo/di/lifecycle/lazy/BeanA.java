package com.oscartrugo.di.lifecycle.lazy;

import com.oscartrugo.di.DependencyInjectionApplication;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BeanA {

    private static final Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

    @PostConstruct
    public void init(){
        log.info("Init Bean A");
    }
}
