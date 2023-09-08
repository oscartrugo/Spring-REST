package com.oscartrugo.di;

import com.oscartrugo.di.atributo.Coche;
import com.oscartrugo.di.profiles.EnvironmentService;
import com.oscartrugo.di.qualifiers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

	private static final Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		EnvironmentService environmentService = context.getBean(EnvironmentService.class);
		log.info("Active environment: ".concat(environmentService.getEnvironment()));
		/*		Coche coche = context.getBean(Coche.class); //Obtenemos los beans de la clase Coche
		Perro perro = context.getBean(Perro.class);
		Pajaro pajaro = context.getBean(Pajaro.class);
		Avion avion = context.getBean(Avion.class);
		Animal animal = context.getBean("pajaro",Animal.class);
		Animal animal2 = context.getBean("perro",Animal.class);

		log.info("Objeto Coche {}", coche.getModelo());
		log.info("Objeto Perro {}", perro.getNombre());
		log.info("Objeto Pájaro {}", pajaro.getNombre());
		log.info("Objeto Avon {}", avion.toString());
		log.info("Objeto Animal - Pájaro {}", animal.getNombre());
		log.info("Objeto Animal - Perro {}", animal2.getNombre());

		Nido animalNido = context.getBean(Nido.class);
		animalNido.imprimir();*/
		//context.getBean("qualifier", Animal.class);
	}

}
