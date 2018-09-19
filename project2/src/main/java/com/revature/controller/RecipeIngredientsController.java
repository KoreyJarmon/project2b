package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.RecipeIngredients;
import com.revature.services.RecipeIngredientsService;

@RestController
@RequestMapping("recipeingredients")
public class RecipeIngredientsController {
	
	@Autowired
	private RecipeIngredientsService ris;
	
	@PostMapping
	public ResponseEntity <RecipeIngredients> save(@RequestBody RecipeIngredients newIngredients){
		RecipeIngredients ingredient = ris.addIngredients(newIngredients);
		ResponseEntity <RecipeIngredients> resp = new ResponseEntity<RecipeIngredients>(ingredient, HttpStatus.CREATED);
		return resp;
	}

}
