package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Users;

@Repository
public interface UserRepo extends JpaRepository <Users, Integer> {
	
	Users findByUsername(String username);
	Users findByUsernameAndPassword(String username, String password);
	
}