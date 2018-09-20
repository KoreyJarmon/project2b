package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Friends;
import com.revature.repos.FriendsRepo;

@Service
public class FriendsService {
	
	@Autowired
	private FriendsRepo fr;

	public Friends save(Friends friend) {
		return fr.saveAndFlush(friend);	}

}
