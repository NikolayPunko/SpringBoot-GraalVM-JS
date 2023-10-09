package com.example.SpringTestGraalVM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringTestGraalVmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTestGraalVmApplication.class, args);
	}

}
