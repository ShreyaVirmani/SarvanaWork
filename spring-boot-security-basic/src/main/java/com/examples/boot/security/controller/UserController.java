package com.examples.boot.security.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/")
	@CrossOrigin("*")
	public String greetings() {
		return "Hey! Welcome to Spring Security Training";
	}

	@RequestMapping("/authenticate")
	@CrossOrigin("*")
	public Principal authenticate(Principal user) {
		return user;
	}

	@RequestMapping("/user")
	@CrossOrigin("*")
	public Principal user(Principal user) {
		return user;
	}

	@RequestMapping("/manager")
	@CrossOrigin("*")
	public Principal manager(Principal user) {
		return user;
	}

	@RequestMapping("/admin")
	@CrossOrigin("*")
	public Principal admin(Principal user) {
		return user;
	}
}