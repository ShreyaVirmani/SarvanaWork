package com.examples.boot.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.examples.boot.security.model.UserAccount;

public interface UserRepository extends JpaRepository<UserAccount, Long> {  //extends MongoRepository<UserAccount, Long> { 
	
	public Optional<UserAccount> findByUserName(String userName);
	
}
