package com.examples.spring.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class EmployeeAspectJoinPoint {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeAspectJoinPoint.class);

	@Before("execution(public void com.examples.spring.aop.model.*.set*(..))")
	public void loggingAdvice(JoinPoint joinPoint) {
		System.out.println("Before running loggingAdvice =" + joinPoint.toString());

		System.out.println("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));

	}

	// Advice arguments, will be applied to bean methods with single String
	// argument
	/*
	 * @Before("args(name)") public void logStringArguments(String name) {
	 * logger.info("String argument passed=" + name); }
	 */
}
