package com.creation.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@ComponentScan
public class UsuarioregisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioregisterApplication.class, args);
	}

}
