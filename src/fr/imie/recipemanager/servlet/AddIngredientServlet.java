package fr.imie.recipemanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.recipemanager.dao.DaoFactory;
import fr.imie.recipemanager.dao.IngredientDao;
import fr.imie.recipemanager.entity.Ingredient;

@WebServlet("/addIngredient")
public class AddIngredientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Ingredient ingredient = new Ingredient(req.getParameter("name"),Float.parseFloat(req.getParameter("price")));
		IngredientDao ingredientDao = DaoFactory.getIngredientDao();
		ingredientDao.addIngredient(ingredient);
		resp.sendRedirect("/RecipeManager/listIngredient");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/addIngredient.jsp").forward(req, resp);
	}

}
