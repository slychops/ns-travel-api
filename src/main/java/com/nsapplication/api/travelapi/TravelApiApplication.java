package com.nsapplication.api.travelapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TravelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelApiApplication.class, args);
		System.out.println("Hello world");
	}

}
