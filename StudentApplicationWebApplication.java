package com.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
public class StudentApplicationWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplicationWebApplication.class, args);
	}
	
}
