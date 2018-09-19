package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Comments;
import com.revature.services.CommentsService;

@RestController
@RequestMapping("comment")
public class CommentsController {
	
	@Autowired
	private CommentsService cs;
	
	
	@PostMapping("{id}")
	public ResponseEntity<Comments> save(@PathVariable int id, @RequestBody Comments newComment){
		Comments comment = cs.addComment(id, newComment);
		ResponseEntity<Comments> resp = new ResponseEntity<Comments>(comment, HttpStatus.CREATED);
		return resp;
	}

}
