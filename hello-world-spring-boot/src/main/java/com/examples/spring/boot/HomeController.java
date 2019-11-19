package com.examples.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
	ApplicationContext ctx;
	

	@GetMapping("/")
	public String sayHello() {
		System.out.println("Beans count: " + ctx.getBeanDefinitionCount());
		for (String beanName: ctx.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		return "Hello World!!!";
	}
}
