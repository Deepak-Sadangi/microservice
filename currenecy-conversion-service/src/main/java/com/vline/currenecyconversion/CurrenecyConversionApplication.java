package com.vline.currenecyconversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrenecyConversionApplication {

	private static final Logger logger = LoggerFactory.getLogger(CurrenecyConversionApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CurrenecyConversionApplication.class, args);
		logger.warn("Application is Started...");
	}

}
