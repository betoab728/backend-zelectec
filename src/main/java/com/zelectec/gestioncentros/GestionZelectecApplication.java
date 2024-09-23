package com.zelectec.gestioncentros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.zelectec.gestioncentros.model")
@SpringBootApplication
@EnableJpaAuditing
public class GestionZelectecApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionZelectecApplication.class, args);
	}

}
