package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Ingredients;
import com.revature.model.Recipe;
import com.revature.model.RecipeIngredients;
import com.revature.services.IngredientService;

@RestController
@RequestMapping("ingredient")
public class IngredientController {
	
	@Autowired
	private IngredientService is;
	
	// /ingredient/
	@PostMapping
	public Ingredients save(@RequestBody List<Ingredients> i) {
		return is.save(i);
	}
	
	// /ingredient/:label
	@GetMapping("{label}")
	public int findByIngredients(@PathVariable String label){
		return is.findByIngredients(label).getIngredientId();
	}
	
	@GetMapping
	public List<Ingredients> findAll(){
		return is.findAll();
	}

}
