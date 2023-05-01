package com.example.foftprogramme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.example")

@SpringBootApplication
public class FoftprogrammeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoftprogrammeApplication.class, args);
	}

}
