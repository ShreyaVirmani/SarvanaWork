package com.examples.spring.boot.cirbreaker;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker
@RestController
public class SpringCloudHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixApplication.class, args);
	}

	@RequestMapping(value = "/")
	@HystrixCommand(fallbackMethod = "fallbackHello", commandProperties = {			
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name ="circuitBreaker.requestVolumeThreshold", value="3"),
			@HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds", value="10000"),
			@HystrixProperty(name ="circuitBreaker.errorThresholdPercentage", value="50"),
			@HystrixProperty(name ="metrics.rollingStats.timeInMilliseconds", value="10000")
			})	
	public String hello() throws InterruptedException {
		System.out.println("Request received - " + new Date());
		String response = new RestTemplate().getForObject("http://localhost:9091/products", String.class);
//		Thread.sleep(3000);
		System.out.println("Response sent - " + new Date());
		return response;
	}

	private String fallbackHello() {
		return "Request fails. It takes long time to response";
	}
}