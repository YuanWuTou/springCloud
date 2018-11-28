package com.yuanwutou.cloud;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Trace2Application {

	private final Logger logger = LogManager.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(Trace2Application.class, args);
	}

	@RequestMapping(value="/trace-2",method = RequestMethod.GET)
	public String trace(){
		logger.info("<-------call trace-2---------->");
		return "Trace";
	}
}
