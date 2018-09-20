package com.revature.services;

import java.util.List;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Users;
import com.revature.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo ur;

	public List<Users> findAll() {
		return ur.findAll();
	}

	public Users findById(int id) {
		return ur.findById(id).get();
	}
	
	public Users findByUsername(String username) {
		return ur.findByUsername(username);
	}

	public Users findByUsernameAndPassword(String username, String password) {
		return ur.findByUsernameAndPassword(username, password);
	}
	
	public int save(Users u) {
		return ur.saveAndFlush(u).getUserId();
	}
}
