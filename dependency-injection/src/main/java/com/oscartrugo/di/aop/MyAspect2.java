package com.oscartrugo.di.aop;

import com.oscartrugo.di.DependencyInjectionApplication;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

@Component
@Aspect
@Order(0)
public class MyAspect2 {

    private static final Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

    //Si en vez de hello ponemos *, aplica el before advice para todos los métodos
    @Before("execution(* com.oscartrugo.di.aop.TargetObject.hello(..))")
    public void before(JoinPoint jointPoint) {
        log.info("1 Method name {}", jointPoint.getSignature().getName());
        log.info("1 Object type {}", jointPoint.getSignature().getDeclaringTypeName());
        log.info("1 Is public {}", Modifier.isPublic(jointPoint.getSignature().getModifiers()));
        log.info("1 Arguments {}", jointPoint.getArgs());
        log.info("1 Before advice");
    }
}
