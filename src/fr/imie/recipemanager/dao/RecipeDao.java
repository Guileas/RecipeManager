package fr.imie.recipemanager.dao;

import java.util.List;

import fr.imie.recipemanager.entity.Recipe;

/*
 * Initialize all recipe function to use them in servlet
 */
public interface RecipeDao {

	void addRecipe(Recipe r);
	List<Recipe> getAllRecipe();
	List<Recipe> getAllUserRecipe(long id);
	Recipe findRecipeById(long id);
	void removeRecipe(Recipe r);
}
