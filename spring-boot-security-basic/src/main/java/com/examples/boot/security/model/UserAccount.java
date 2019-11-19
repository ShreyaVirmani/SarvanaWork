package com.examples.boot.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Table(name = "users")
//@Document("users")
public class UserAccount {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    // Enable for MongoDB	
//	@Id
    // Enable for JPA
	@javax.persistence.Id
	@GeneratedValue
	long id;

	String userName;
	String password;
	String role;
	boolean active;
	
	public UserAccount() {
		
	}

	public UserAccount(String userName, String password, String role, boolean active) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.active = active;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}