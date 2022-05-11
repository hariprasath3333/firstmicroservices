package com.trial.microservices.springcloudsonfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudSonfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSonfigServerApplication.class, args);
	}

}
