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
import fr.imie.recipemanager.entity.Ingredient;

@SuppressWarnings("serial")
@WebServlet("/listIngredient")
public class ListIngredientServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IngredientDao idao = DaoFactory.getIngredientDao();
		List<Ingredient> ingredients = idao.getAllIngredient();
		List<Ingredient> currentIngredient = null;
		
		req.setAttribute("ingredients", ingredients);
		req.getRequestDispatcher("/listIngredient.jsp").forward(req, resp);
	}

}
