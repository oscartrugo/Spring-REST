package com.oscartrugo.di.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutExample {

    //@Pointcut("execution(* com.oscartrugo.di.aop.TargetObject.hello(..))")
    //@Pointcut("within(com.oscartrugo.di.aop.TargetObject)") //Todos los métodos dentro del paquete serán targetObjects y se les ejecuta el pointcut
    @Pointcut("@annotation(OscartrugoAnnotation)")
    public void targetObjectMethods(){

    }

}
