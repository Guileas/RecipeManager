package fr.imie.recipemanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.recipemanager.dao.DaoFactory;
import fr.imie.recipemanager.dao.IngredientDao;
import fr.imie.recipemanager.dao.RecipeDao;
import fr.imie.recipemanager.entity.Ingredient;
import fr.imie.recipemanager.entity.Recipe;

@SuppressWarnings("serial")
@WebServlet("/listIngredient")
public class ListIngredientServlet extends HttpServlet {
	
	private static IngredientDao idao = DaoFactory.getIngredientDao();
	private static List<Ingredient> ingredients;
	private static List<Ingredient> currentIngredient;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		for (Ingredient ingredient : currentIngredient) {
			String res = req.getParameter("checkbox").toString();
			System.out.println("Le résultat de ma chackbox est : " + res);
			if (res == "on") {
				currentIngredient.add(ingredient);
				System.out.println(ingredient.getName());
			}
		}
	}

	@SuppressWarnings("null")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ingredients = idao.getAllIngredient();
		
		req.setAttribute("ingredients", ingredients);
		req.getRequestDispatcher("/listIngredient.jsp").forward(req, resp);
	}
	
	protected void addRecipe(List<Ingredient> currentIngredient) {
		RecipeDao rdao = DaoFactory.getRecipeDao();
		Recipe r = new Recipe();
	}

}
