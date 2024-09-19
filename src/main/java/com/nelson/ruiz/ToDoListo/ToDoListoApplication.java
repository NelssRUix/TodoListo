package com.nelson.ruiz.ToDoListo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ToDoListoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListoApplication.class, args);
	}

}
