package fr.imie.recipemanager.dao;

import java.util.List;

import fr.imie.recipemanager.entity.Ingredient;

/*
 * Initialize all ingredient function to use them in servlet
 */
public interface IngredientDao {

	void addIngredient(Ingredient i);
	List<Ingredient> getAllIngredient();
	Ingredient findIngredientById(long id);
	void removeIngredient(Ingredient i);
}
