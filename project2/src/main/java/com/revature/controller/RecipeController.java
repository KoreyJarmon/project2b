package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Comments;
import com.revature.model.Recipe;
import com.revature.model.RecipeIngredients;
import com.revature.services.IngredientService;
import com.revature.services.RecipeService;

@CrossOrigin
@RestController
@RequestMapping("recipe")
public class RecipeController {

	@Autowired
	private RecipeService rs;
	@Autowired
	private IngredientService is;
	@Autowired
	private IngredientController ic;

	@Transactional
	@PostMapping
	public ResponseEntity<Recipe> save(@RequestBody Recipe newRecipe) {
		Recipe recipeName = rs.findByLabel(newRecipe.getLabel());
		if (recipeName != null) {
			ResponseEntity<Recipe> resp1 = new ResponseEntity<Recipe>(recipeName, HttpStatus.CREATED);
			return resp1;
		} else {

			newRecipe.setIngredients(newRecipe.getIngredients());
			newRecipe.getIngredients().forEach(each -> {
				ic.save(each.getIngredient());
			});

			Recipe recipe = rs.save(newRecipe);
			newRecipe.getIngredients().forEach(each -> {
				rs.addItem(newRecipe.getRecipeId(), each);
			});
			ResponseEntity<Recipe> resp = new ResponseEntity<Recipe>(recipe, HttpStatus.CREATED);
			return resp;
		}
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

	@PostMapping("ids")
	public List<Recipe> findByIds(@RequestBody List<Comments> comments) {
		List<Recipe> listOfRecipes = new ArrayList<Recipe>();
		comments.forEach(each -> {
			listOfRecipes.add(rs.findById(each.getRecipeId()));
		});
		return listOfRecipes;
	}

	// /recipe/:id
	@PostMapping("recipeingredients/{id}")
	public ResponseEntity<RecipeIngredients> save(@PathVariable int id, @RequestBody RecipeIngredients newIngredient) {
		RecipeIngredients ingredient = rs.addItem(id, newIngredient);
		ResponseEntity<RecipeIngredients> resp = new ResponseEntity<RecipeIngredients>(ingredient, HttpStatus.CREATED);
		return resp;
	}

	// /recipe/:dietid
	@GetMapping("/diet/{diet}")
	public List<Recipe> findByDietLabel(@PathVariable String diet) {
		return rs.findByDietLabel(diet);
	}

	// /name/:label
	@GetMapping("/name/{label}")
	public Recipe findByLabel(@PathVariable String label) {
		return rs.findByLabel(label);
	}

}
