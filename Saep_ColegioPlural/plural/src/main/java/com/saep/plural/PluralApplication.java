package com.saep.plural;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PluralApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralApplication.class, args);
		System.out.println("Aplicação iniciada com sucesso!");
	}

}
