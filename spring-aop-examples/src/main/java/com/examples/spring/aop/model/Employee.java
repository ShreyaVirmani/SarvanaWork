package com.examples.spring.aop.model;

import com.examples.spring.aop.aspect.Loggable;

public class Employee {
	
	private String name;

	@Loggable
	public String getName() {
		return name;
	}

	@Loggable
	public void setName(String nm) {
		this.name = nm;
	}

	public void throwException() {
		throw new RuntimeException("Dummy Exception");
	}

}