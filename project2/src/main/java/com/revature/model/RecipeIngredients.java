package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="recipe_ingredients")
public class RecipeIngredients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="recipe_ingredient_id")
	private int recipeIngredientId;
	@ManyToOne
	@JoinColumn(name="ingredient_id")
	private Ingredients ingredient;
	
	@Column(name="recipe_id")
	private int recipe;
	
	private int quantity;

	public RecipeIngredients() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecipeIngredients(int recipeIngredientId, Ingredients ingredient, int recipe, int quantity) {
		super();
		this.recipeIngredientId = recipeIngredientId;
		this.ingredient = ingredient;
		this.recipe = recipe;
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
		result = prime * result + quantity;
		result = prime * result + recipe;
		result = prime * result + recipeIngredientId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeIngredients other = (RecipeIngredients) obj;
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
			return false;
		if (quantity != other.quantity)
			return false;
		if (recipe != other.recipe)
			return false;
		if (recipeIngredientId != other.recipeIngredientId)
			return false;
		return true;
	}

	public int getRecipeIngredientId() {
		return recipeIngredientId;
	}

	public void setRecipeIngredientId(int recipeIngredientId) {
		this.recipeIngredientId = recipeIngredientId;
	}

	public Ingredients getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredients ingredient) {
		this.ingredient = ingredient;
	}

	public int getRecipe() {
		return recipe;
	}

	public void setRecipe(int recipe) {
		this.recipe = recipe;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "RecipeIngredients [recipeIngredientId=" + recipeIngredientId + ", ingredient=" + ingredient
				+ ", recipe=" + recipe + ", quantity=" + quantity + "]";
	}
	
	
	
}
