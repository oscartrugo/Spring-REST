package com.oscartrugo.di.aop;

import com.oscartrugo.di.DependencyInjectionApplication;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

@Component
@Aspect
public class MyAspect {

    private static final Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

    //Si en vez de hello ponemos *, aplica el before advice para todos los métodos
    @Before("PointcutExample.targetObjectMethods()")
    public void before(JoinPoint jointPoint){
        log.info("Method name {}", jointPoint.getSignature().getName());
        log.info("Object type {}", jointPoint.getSignature().getDeclaringTypeName());
        log.info("Is public {}", Modifier.isPublic(jointPoint.getSignature().getModifiers()));
        log.info("Arguments {}", jointPoint.getArgs());
        log.info("Before advice");
    }

}
