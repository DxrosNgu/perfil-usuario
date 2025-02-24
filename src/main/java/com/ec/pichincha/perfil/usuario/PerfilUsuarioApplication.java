package com.ec.pichincha.perfil.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PerfilUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerfilUsuarioApplication.class, args);
	}

}
