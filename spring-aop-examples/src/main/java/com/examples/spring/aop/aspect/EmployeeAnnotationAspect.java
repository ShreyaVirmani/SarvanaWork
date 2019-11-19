package com.examples.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class EmployeeAnnotationAspect {

	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeAnnotationAspect.class);

	@Before("@annotation(com.examples.spring.aop.aspect.Loggable)")
	public void myAdvice() {
		 System.out.println("Executing myAdvice!!");
		logger.info("Executing myAdvice!!");

	}
}
