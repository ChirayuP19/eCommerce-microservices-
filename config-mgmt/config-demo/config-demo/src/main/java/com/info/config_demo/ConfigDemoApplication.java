package com.info.config_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication

public class ConfigDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigDemoApplication.class, args);
	}

}
