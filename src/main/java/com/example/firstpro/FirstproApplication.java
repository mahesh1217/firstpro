package com.example.firstpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirstproApplication {

	public static void main(final String[] args) {
		SpringApplication.run(FirstproApplication.class, args);
	}

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }


}
