package com.oscartrugo.di.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype") Recordemos que PreDestroy no se ejecuta para beans de tipo Prototype
public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean {

    private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);

    /*
    * Se ejecutará durante la construcción del bean. "BeanNameAware"
    * */
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
    public void destroyBean(){
        log.info("Pre destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("After properties set method");
    }

    @Override
    public void destroy() throws Exception {
        log.info("Destroy method");
    }
}
