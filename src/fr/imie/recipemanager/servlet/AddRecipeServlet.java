package fr.imie.recipemanager.servlet;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.recipemanager.dao.DaoFactory;
import fr.imie.recipemanager.dao.RecipeDao;
import fr.imie.recipemanager.entity.Recipe;

@WebServlet("/addRecipe")
public class AddRecipeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/// Instancier un ingrédient
		Recipe recipe = new Recipe(req.getParameter("name"));
		/// Instancier le DAO et ajouter les ingrédients
		RecipeDao recipeDao = DaoFactory.getRecipeDao();
		recipeDao.addRecipe(recipe);
		/// Redirection à faire :
		resp.sendRedirect("/RecipeManager/myRecipe");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/addRecipe.jsp").forward(req, resp);
	}

}
