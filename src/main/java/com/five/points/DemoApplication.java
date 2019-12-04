package com.five.points;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.five.points.dao.PersonneRepository;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	PersonneRepository personneRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
