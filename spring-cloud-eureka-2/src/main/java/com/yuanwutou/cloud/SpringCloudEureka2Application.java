package com.yuanwutou.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEureka2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEureka2Application.class, args);
	}
}
