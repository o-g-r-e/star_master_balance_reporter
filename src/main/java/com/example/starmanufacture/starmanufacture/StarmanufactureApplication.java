package com.example.starmanufacture.starmanufacture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.starmanufacture.starmanufacture.repositories")
@EntityScan("com.example.starmanufacture.starmanufacture.models")
@SpringBootApplication
public class StarmanufactureApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarmanufactureApplication.class, args);
	}

}
