package com.examples.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeXMLConfigAspect {

	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeXMLConfigAspect.class);

	public void beforeAdvice()
	{
		logger.info("BeforeAdvice -> Going to setup employee profile");
	}
	
	public void afterAdvice()
	{
		logger.info("AfterAdvice -> Employee profile has been setup");
	}
	
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		
		logger.info("EmployeeXMLConfigAspect:: inside employeeAroundAdvice() before invoking method");

		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		logger.info("EmployeeXMLConfigAspect:: value employeeAroundAdvice() after invoking method" + value);
		return value;
	}	
	
	public void returningAdvice(String retVal)
	{
		logger.info("ReturningAdvice -> " + retVal);
	}
	
	public void afterThrow(Exception ex)
	{
		logger.info("AfterThrow -> Exception has been thrown. " + ex.getMessage());
	}
	
}
