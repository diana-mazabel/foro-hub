package com.mazabel.forohub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.mazabel.forohub.domain.usuario", "com.mazabel.forohub.domain.topico"})
@EnableJpaRepositories(basePackages = "com.mazabel.forohub.domain.repository")
public class ForohubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForohubApplication.class, args);
	}

}
