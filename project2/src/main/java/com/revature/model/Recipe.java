package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="recipe_table")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="recipe_id")
	private int recipeId;
	private String image;
	@Column(name="recipe_name")
	private String label;
	private int yield;
	private int calories;
	private int fat;
	private int fiber;
	private int protein;
	private int carbs;
	private int sodium;
	private int cholesterol;
	@Column(name="recipe_url")
	private String recipe;
	
//	@ManyToOne
	@Column(name="diet_label_id")
	private int dietLabelId;
	
	@ManyToMany
	@JoinTable(name = "recipe_health_table", 
	joinColumns = @JoinColumn(name="recipe_id"),
	inverseJoinColumns = @JoinColumn(name="health_label_id"))
	private List<Health> healthLabel;
	
	@OneToMany(mappedBy = "recipe")
//	@JsonProperty(access = Access.WRITE_ONLY)
	private List<RecipeIngredients> ingredients;
	
//	@ManyToOne
//	@JoinColumn(name="recipe_id",insertable=false, updatable=false)
//	private Users user;

	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recipe(int recipeId, String image, String label, int yield, int calories, int fat, int fiber, int protein,
			int carbs, int sodium, int cholesterol, String recipe, int dietLabelId, List<Health> healthLabel,
			List<RecipeIngredients> ingredients) {
		super();
		this.recipeId = recipeId;
		this.image = image;
		this.label = label;
		this.yield = yield;
		this.calories = calories;
		this.fat = fat;
		this.fiber = fiber;
		this.protein = protein;
		this.carbs = carbs;
		this.sodium = sodium;
		this.cholesterol = cholesterol;
		this.recipe = recipe;
		this.dietLabelId = dietLabelId;
		this.healthLabel = healthLabel;
		this.ingredients = ingredients;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getYield() {
		return yield;
	}

	public void setYield(int yield) {
		this.yield = yield;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getFiber() {
		return fiber;
	}

	public void setFiber(int fiber) {
		this.fiber = fiber;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getCarbs() {
		return carbs;
	}

	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}

	public int getSodium() {
		return sodium;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public int getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(int cholesterol) {
		this.cholesterol = cholesterol;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public int getDietLabelId() {
		return dietLabelId;
	}

	public void setDietLabelId(int dietLabelId) {
		this.dietLabelId = dietLabelId;
	}

	public List<Health> getHealthLabel() {
		return healthLabel;
	}

	public void setHealthLabel(List<Health> healthLabel) {
		this.healthLabel = healthLabel;
	}

	public List<RecipeIngredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<RecipeIngredients> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calories;
		result = prime * result + carbs;
		result = prime * result + cholesterol;
		result = prime * result + dietLabelId;
		result = prime * result + fat;
		result = prime * result + fiber;
		result = prime * result + ((healthLabel == null) ? 0 : healthLabel.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + protein;
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
		result = prime * result + recipeId;
		result = prime * result + sodium;
		result = prime * result + yield;
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
		Recipe other = (Recipe) obj;
		if (calories != other.calories)
			return false;
		if (carbs != other.carbs)
			return false;
		if (cholesterol != other.cholesterol)
			return false;
		if (dietLabelId != other.dietLabelId)
			return false;
		if (fat != other.fat)
			return false;
		if (fiber != other.fiber)
			return false;
		if (healthLabel == null) {
			if (other.healthLabel != null)
				return false;
		} else if (!healthLabel.equals(other.healthLabel))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (protein != other.protein)
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		if (recipeId != other.recipeId)
			return false;
		if (sodium != other.sodium)
			return false;
		if (yield != other.yield)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", image=" + image + ", label=" + label + ", yield=" + yield
				+ ", calories=" + calories + ", fat=" + fat + ", fiber=" + fiber + ", protein=" + protein + ", carbs="
				+ carbs + ", sodium=" + sodium + ", cholesterol=" + cholesterol + ", recipe=" + recipe
				+ ", dietLabelId=" + dietLabelId + ", healthLabel=" + healthLabel + ", ingredients=" + ingredients
				+ "]";
	}
	
	
}