package com.fishfarming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fishfarming")
public class FishFarmingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FishFarmingAppApplication.class, args);
	}

}
