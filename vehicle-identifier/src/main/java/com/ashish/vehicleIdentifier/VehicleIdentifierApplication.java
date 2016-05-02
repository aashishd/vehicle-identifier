package com.ashish.vehicleIdentifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.ashish"})
@SpringBootApplication
public class VehicleIdentifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleIdentifierApplication.class, args);
	}
}
