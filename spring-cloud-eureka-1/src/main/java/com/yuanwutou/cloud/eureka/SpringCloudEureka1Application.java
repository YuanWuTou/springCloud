package com.yuanwutou.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEureka1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEureka1Application.class, args);
	}
}
