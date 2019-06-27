package com.seedsystem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;


@PropertySource(value = {"classpath:seedsystem-application-${spring.profiles.active}.properties" })
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })

public class SeedSystemApplication {

	  @Value("${server.port}")
	  private int redirectPort;
	
	public static void main(String[] args) {
		SpringApplication.run(SeedSystemApplication.class, args);
	}

}
