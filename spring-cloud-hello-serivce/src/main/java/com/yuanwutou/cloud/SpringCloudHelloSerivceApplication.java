package com.yuanwutou.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudHelloSerivceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHelloSerivceApplication.class, args);
	}
}
