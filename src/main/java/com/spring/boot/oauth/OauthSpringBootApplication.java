package com.spring.boot.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
public class OauthSpringBootApplication  {

	public static void main(String[] args) {
		SpringApplication.run(OauthSpringBootApplication.class, args);
	}

}
