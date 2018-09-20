package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Friends;
import com.revature.services.FriendsService;
import com.revature.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("friend")
public class FriendsController {
	
	@Autowired
	private FriendsService fs;
	@Autowired
	private UserService us;
	
	@PostMapping("{you}")
	public void save(@PathVariable int you, @RequestBody Friends friend) {
//		int f = us.findByUsername(username).getUserId();
//		friend.setFuser(you);
		friend.setUserId(you);
		fs.save(friend);
		System.out.println(friend);
	}
}
