package com.oscartrugo.di.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LifeCycleBean implements BeanNameAware {

    private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);

    @Override
    public void setBeanName(String name) {
        log.info("Bean name {}", name);
    }

    /*
    * Esto se ejecutará después de la inyección de dependencias.
    * */

    @PostConstruct
    public void init(){
        log.info("Post construct");
    }

    /*
    * Antes de que el bean sea destruido se ejecutará el método PreDestroy
    * No se ejecutan para beans prototype.
    * Solo se ejecuta si termina la JVM de forma normal.
     * */

    @PreDestroy
    public void destroy(){
        log.info("Pre destroy");
    }
}
