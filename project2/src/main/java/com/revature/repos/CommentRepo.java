package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Comments;

public interface CommentRepo extends JpaRepository <Comments, Integer>{

}
