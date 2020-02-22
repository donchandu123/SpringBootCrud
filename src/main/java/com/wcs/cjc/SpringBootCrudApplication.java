package com.wcs.cjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan
@EnableJpaRepositories
@SpringBootApplication
public class SpringBootCrudApplication {
     
	public static void main(String[] args) {
		System.out.println("main Start");
		SpringApplication.run(SpringBootCrudApplication.class, args);
		System.out.println("");
	}

}
