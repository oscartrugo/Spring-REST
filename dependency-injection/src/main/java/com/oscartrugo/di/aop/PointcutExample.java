package com.oscartrugo.di.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutExample {

    @Pointcut("execution(* com.oscartrugo.di.aop.TargetObject.hello(..))")
    public void targetObjectMethods(){

    }

}
