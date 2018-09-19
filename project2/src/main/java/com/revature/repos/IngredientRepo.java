package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Ingredients;
import com.revature.model.RecipeIngredients;

public interface IngredientRepo extends JpaRepository <Ingredients, Integer> {
	
	Ingredients findByIngredients(String ingredients);

	Ingredients saveAndFlush(List<Ingredients> i);

}
