package com.revature.services;

import java.util.List;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Ingredients;
import com.revature.model.Recipe;
import com.revature.model.RecipeIngredients;
import com.revature.repos.IngredientRepo;

@Service
//@Table(name = "ingredients")
public class IngredientService {
	
	@Autowired
	private IngredientRepo ir;
	
	public Ingredients save(Ingredients i) {
		return ir.saveAndFlush(i);
	}
	
	public Ingredients findByIngredients(String ingredients) {
		return ir.findByIngredients(ingredients);
	}

	public List<Ingredients> findAll() {
		return ir.findAll();
	}

}
