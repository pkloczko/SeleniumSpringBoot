package com.example.SpringTestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringSeleniumApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringSeleniumApp.class, args);
		ApplicationContext applicationContext = SpringApplication.run(SpringSeleniumApp.class, args);
	}
}
