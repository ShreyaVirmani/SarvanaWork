package com.examples.spring.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.examples.spring.aop.aspect.EmployeeAspect;
import com.examples.spring.aop.model.Employee;
import com.examples.spring.aop.service.EmployeeService;

@Configuration
@EnableAspectJAutoProxy
public class LoggingAopConfig {
	
	@Bean
	public EmployeeService employeeService() {
		EmployeeService empService = new EmployeeService();
		empService.setEmployee(employee());
		return empService;
	}
	
	@Bean
	public Employee employee() {
		Employee emp = new Employee();
		emp.setName("Johnson");
		return emp;
	}
	
	@Bean
	public EmployeeAspect employeeAspect() {
		return new EmployeeAspect();
	}
	
	
}
