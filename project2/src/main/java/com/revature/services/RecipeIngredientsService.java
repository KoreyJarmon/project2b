package com.revature.services;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.RecipeIngredients;
import com.revature.repos.RecipeIngredientsRepo;

@Service
public class RecipeIngredientsService {
	
	@Autowired
	private RecipeIngredientsRepo rir;
	
	public RecipeIngredients addIngredients(RecipeIngredients newIngredient) {
		return rir.save(newIngredient);
	}

}
