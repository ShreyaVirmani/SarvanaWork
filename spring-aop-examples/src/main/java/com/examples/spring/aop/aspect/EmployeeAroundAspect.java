package com.examples.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class EmployeeAroundAspect {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeAroundAspect.class);

	@Around("execution(* com.examples.spring.aop.model.*.*(..))")
	// @Around("within(com.examples.spring.aop.model.*)")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("Before invoking method: " + proceedingJoinPoint.getSignature());
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After invoking method. Return value=" + value);
		System.out.println("After invoking method: " + proceedingJoinPoint.getSignature());
		return value;
	}
}
