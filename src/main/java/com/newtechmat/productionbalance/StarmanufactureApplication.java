package com.newtechmat.productionbalance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.newtechmat.productionbalance.repositories")
@EntityScan("com.newtechmat.productionbalance.data.models")
@SpringBootApplication
public class StarmanufactureApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarmanufactureApplication.class, args);
	}

}
