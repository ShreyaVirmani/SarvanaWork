package com.examples.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class EmployeeAfterAspect {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeAfterAspect.class);

	// @After("args(name)")
	@AfterReturning(pointcut = "execution(* get*())", returning = "name")
	public void logStringArguments(String name) {
		logger.info("Running After Advice. String argument passed =" + name);
		System.out.println("Running After Advice. String argument passed =" + name);
	}

	@AfterThrowing("within(com.examples.spring.aop.model.*)")
	public void logExceptions(JoinPoint joinPoint) {
		System.out.println("Exception thrown in Employee Method=" + joinPoint.toString());
		logger.error("Exception thrown in Genweb Portfolio Method=" + joinPoint.toString());
		System.out
				.println("Running After Advice. String argument passed Employee After aspect=" + joinPoint.toString());
	}

	@AfterReturning(pointcut = "execution(* get*())", returning = "returnString")
	public void getNameReturningAdvice(String returnString) {
		System.out.println("getNameReturningAdvice executed. Returned String=" + returnString);
		logger.info("getNameReturningAdvice executed. Returned String=" + returnString);
	}

}
