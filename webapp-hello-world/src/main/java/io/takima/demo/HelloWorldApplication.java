package io.takima.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);

	}

	@PostConstruct
	public void init() {
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println("Hello World!");
		System.out.println("Félicitations, votre setup fonctionne parfaitement.");
		System.out.println("Vous pouvez maintenant supprimer ce projet.");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
	}

}
