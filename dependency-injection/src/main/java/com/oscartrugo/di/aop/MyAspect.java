package com.oscartrugo.di.aop;

import com.oscartrugo.di.DependencyInjectionApplication;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    private static final Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

    //Si en vez de hello ponemos *, aplica el before advice para todos los métodos
    @Before("execution(* com.oscartrugo.di.aop.TargetObject.hello(..))")
    public void before(){
        log.info("Before advice");
    }

}
