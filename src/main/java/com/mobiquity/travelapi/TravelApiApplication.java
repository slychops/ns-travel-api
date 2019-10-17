package com.mobiquity.travelapi;

import com.mobiquity.travelapi.integrations.nsclient.NsClient;
import com.mobiquity.travelapi.integrations.nsclient.responsemodel.TravelModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TravelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelApiApplication.class, args);
		System.out.println("Hello other world");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


}