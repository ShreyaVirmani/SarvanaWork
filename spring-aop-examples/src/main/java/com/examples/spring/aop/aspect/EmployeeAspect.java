package com.examples.spring.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class EmployeeAspect {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeAspect.class);

	@Before("selectGetterPointcut()")
	public void executeBefore() {
		logger.info("Executing Before Advice");
	}
	
	@After("selectGetterPointcut()")
	public void executeAfter() {
		logger.info("Executing After Advice");
	}
	
	@Pointcut("execution(* com.examples.spring.aop.model.Employee.get*(..))")
	public void selectGetterPointcut() {
		logger.info("Inside getNamePointcut() executing get*()");
	}
	

//	@Before("execution(* com.examples.spring.aop.model.Employee.setName(..))")
////	@Before("execution(public String getName())")
//	public void getAllAdvice() {
//		logger.info("Executing Advice on setName and getName()");
//		System.out.println("This is injected from Employee Aspect 2");
//	}
}
