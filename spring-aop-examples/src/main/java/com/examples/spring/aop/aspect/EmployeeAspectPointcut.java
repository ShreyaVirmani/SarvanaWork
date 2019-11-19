package com.examples.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class EmployeeAspectPointcut {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeAspectPointcut.class);

	@Before("getNamePointcut()")
	public void loggingAdvice() {
		logger.info("Executing loggingAdvice() in EmployeeAspectPointcut");
		System.out.println("Executing loggingAdvice() in EmployeeAspectPointcut");
	}

	@Before("getNamePointcut()")
	public void secondAdvice() {
		logger.info("Executing secondAdvice() in EmployeeAspectPointcut");
		System.out.println("Executing secondAdvice() in EmployeeAspectPointcut");
	}

	@Pointcut("execution(public String get*())")
	public void getNamePointcut() {
		logger.info("Inside getNamePointcut() executing get*()");
		System.out.println("Inside getNamePointcut() executing get*()");
	}

	@Before("allMethodsPointcut()")
	public void allServiceMethodsAdvice() {
		logger.info("Inside allServiceMethodsAdvice() before allMethodsPointcut()");
		System.out.println(
				"Inside allServiceMethodsAdvice() before allMethodsPointcut()");
	}

	// Pointcut to execute on all the methods of classes in a package
	@Pointcut("within(com.examples.spring.aop.model.*)")
	public void allMethodsPointcut() {
		logger.info("within executing allMethodsPointcut() method");
		System.out.println("within executing allMethodsPointcut() method");
	}

}
