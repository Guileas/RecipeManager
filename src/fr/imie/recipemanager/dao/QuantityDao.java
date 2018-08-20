package fr.imie.recipemanager.dao;

import java.util.List;

import fr.imie.recipemanager.entity.Quantity;

/*
 * Initialize all quantity function to use them in servlet
 */
public interface QuantityDao {

	void addQuantity(Quantity q);
	List<Quantity> getAllQuantity();
	Quantity findQuantityByIdRecipe(long id);
	void removeQuantity(Quantity q);
	
}
