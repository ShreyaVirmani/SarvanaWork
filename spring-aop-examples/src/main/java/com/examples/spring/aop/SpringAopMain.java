package com.examples.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examples.spring.aop.config.LoggingAopConfig;
import com.examples.spring.aop.service.EmployeeService;

public class SpringAopMain {

	public static void main(String[] args) {
		// Xml based configuration
//		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
		
		// Java based configuration
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(LoggingAopConfig.class);
		
		EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);
		System.out.println("Name: " + employeeService.getEmployee().getName());
		employeeService.getEmployee().setName("Kumar");
		System.out.println("Updated Name: " + employeeService.getEmployee().getName());
//		employeeService.getEmployee().throwException();
		ctx.close();
	}
}
