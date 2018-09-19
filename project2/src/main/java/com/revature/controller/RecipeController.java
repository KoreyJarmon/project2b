package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Recipe;
import com.revature.model.RecipeIngredients;
import com.revature.services.IngredientService;
import com.revature.services.RecipeService;

@RestController
@RequestMapping("recipe")
public class RecipeController {

	@Autowired
	private RecipeService rs;
	@Autowired
	private IngredientService is;

	// /recipe
	@PostMapping
	public ResponseEntity<Recipe> save(@RequestBody Recipe newRecipe) {
		Recipe recipe = rs.save(newRecipe);
		ResponseEntity<Recipe> resp = new ResponseEntity<Recipe>(recipe, HttpStatus.CREATED);
		return resp;
	}

	// /recipe
	@GetMapping
	public List<Recipe> findAll() {
		System.out.println("finding all recipes");
		return rs.findAll();
	}

	// /recipe/:id
	@GetMapping("{id}")
	public Recipe findById(@PathVariable int id) {
		return rs.findById(id);
	}

	// /recipe/:id
	@PostMapping("recipeingredients/{id}")
	public ResponseEntity<RecipeIngredients> save(@PathVariable int id, @RequestBody RecipeIngredients newIngredient) {
		RecipeIngredients ingredient = rs.addItem(id, newIngredient);
		ResponseEntity<RecipeIngredients> resp = new ResponseEntity<RecipeIngredients>(ingredient, HttpStatus.CREATED);
		return resp;
	}

	// /recipe/:dietid
	@GetMapping("/diet/{id}")
	public List<Recipe> findByDietLabelId(@PathVariable int id) {
		return rs.findByDietLabelId(id);
	}

	// /name/:label
	@GetMapping("/name/{label}")
	public Recipe findByLabel(@PathVariable String label) {
		return rs.findByLabel(label);
	}

}
