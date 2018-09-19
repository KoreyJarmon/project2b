package com.revature.services;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.model.Comments;
import com.revature.model.Users;
import com.revature.repos.CommentRepo;
import com.revature.repos.UserRepo;

@Service
//@Table(name = "comment_table")
public class CommentsService {

	@Autowired
	private CommentRepo cr;
	@Autowired
	private UserRepo ur;
	
	public Comments addComment(int id, Comments newComment) {
		Users user = ur.getOne(id);
		newComment.setUser(user);
		cr.saveAndFlush(newComment);
		return newComment;
	}

}
