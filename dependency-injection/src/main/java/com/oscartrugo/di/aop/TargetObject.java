package com.oscartrugo.di.aop;

import com.oscartrugo.di.DependencyInjectionApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TargetObject {

    private static final Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

    @OscartrugoAnnotation
    public void hello(String message){
        log.info(message);
    }

    public void foo(){
        log.info("foo");
    }

}
