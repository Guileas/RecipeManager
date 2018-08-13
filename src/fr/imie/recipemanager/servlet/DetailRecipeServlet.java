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

@WebServlet("/detailRecipe")
public class DetailRecipeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/// Redirection à faire
		resp.sendRedirect("/RecipeManager/listRecipe");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RecipeDao rdao = DaoFactory.getRecipeDao();
		Recipe recipes = rdao.findRecipeById(Long.valueOf(req.getParameter("id")));
		
		
		req.setAttribute("recipe", recipes);		
		req.getRequestDispatcher("/detailRecipe.jsp").forward(req, resp);
	}

}
