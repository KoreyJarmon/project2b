package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Friends;

public interface FriendsRepo extends JpaRepository <Friends, Integer>{

}
