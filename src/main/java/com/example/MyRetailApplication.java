package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
//Replaces @Configuration,@EnableAutoConfiguration,@ComponentScan
@Configuration
@EnableAutoConfiguration
@ComponentScan({"controller","service","serviceImpl"})
public class MyRetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRetailApplication.class, args);
	}
}