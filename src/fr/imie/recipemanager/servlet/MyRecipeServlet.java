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

@WebServlet("/myRecipe")
public class MyRecipeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RecipeDao recipeDao = DaoFactory.getRecipeDao();
		List<Recipe> recipes = recipeDao.getAllRecipe();
		
		req.setAttribute("recipes", recipes);
		req.getRequestDispatcher("/myRecipe.jsp").forward(req, resp);
	}
	

}
