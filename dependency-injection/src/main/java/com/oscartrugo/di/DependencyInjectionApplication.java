package com.oscartrugo.di;

import com.oscartrugo.di.lifecycle.ExplicitBean;
import com.oscartrugo.di.lifecycle.LifeCycleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DependencyInjectionApplication {

	private static final Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

	@Bean 
	public String getApplicationName(){
		return "DependencyInjectionApplication";
	}


//	@Bean(initMethod = "init", destroyMethod = "destroy") //Definimos un init method
//	public ExplicitBean getBean(){
//		return new ExplicitBean();
//	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		LifeCycleBean bean = context.getBean(LifeCycleBean.class);
	}
}
