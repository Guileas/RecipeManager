package fr.imie.recipemanager.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.imie.recipemanager.dao.DaoFactory;
import fr.imie.recipemanager.entity.Ingredient;

@Path("/ingredient")
public class IngredientRessource {

	@GET
	@Path("myIngredient")
	public Ingredient getIngredient() {
		Ingredient i = new Ingredient("ingredient 1", 10);
		return i;
	}

	@GET
	@Path("/id/{ingredientId}")
	public Ingredient getIngredientById(@PathParam("ingredientId") String ingredientId) {
		System.out.println();

		Long id = Long.parseLong(ingredientId);

		Ingredient i = DaoFactory.getIngredientDao().findIngredientById(id);

		return i;
	}

}
