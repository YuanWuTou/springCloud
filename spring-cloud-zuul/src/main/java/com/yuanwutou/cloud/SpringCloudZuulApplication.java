package com.yuanwutou.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import javax.accessibility.AccessibleRelation;

@EnableZuulProxy
@SpringBootApplication
public class SpringCloudZuulApplication {

	public static void main(String[] args) {
		System.out.println("1eee23sss4SS56677");
		SpringApplication.run(SpringCloudZuulApplication.class, args);
	}

	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}
}
