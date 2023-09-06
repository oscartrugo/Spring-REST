package com.oscartrugo.di;

import com.oscartrugo.di.atributo.Coche;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		Coche coche = context.getBean(Coche.class); //Obtenemos los beans de la clase Coche

		System.out.println("coche = " + coche);
	}

}
