package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.SecurityConfig;

@SpringBootApplication

@EnableJpaRepositories(basePackages= {"com.example.demo.repository"})
//@Import({SecurityConfig.class})


public class DemoM5Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoM5Application.class, args);
	}

}
