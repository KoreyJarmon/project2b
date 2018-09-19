package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.RecipeIngredients;

public interface RecipeIngredientsRepo extends JpaRepository <RecipeIngredients, Integer>{

}
