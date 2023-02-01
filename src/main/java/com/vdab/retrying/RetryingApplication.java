package com.vdab.retrying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class RetryingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetryingApplication.class, args);
	}

}
