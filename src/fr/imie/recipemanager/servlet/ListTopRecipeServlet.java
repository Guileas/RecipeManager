package fr.imie.recipemanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.recipemanager.dao.DaoFactory;
import fr.imie.recipemanager.dao.RecipeDao;
import fr.imie.recipemanager.entity.Recipe;

@WebServlet("/listTopRecipe")
public class ListTopRecipeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RecipeDao rdao = DaoFactory.getRecipeDao();
		List<Recipe> recipes = rdao.getAllRecipe();
		req.setAttribute("recipes", recipes);
		req.getRequestDispatcher("/listTopRecipe.jsp").forward(req, resp);
	}

}
