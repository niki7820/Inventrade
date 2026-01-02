package com.inventrade.inventrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InventradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventradeApplication.class, args);
	}

}
