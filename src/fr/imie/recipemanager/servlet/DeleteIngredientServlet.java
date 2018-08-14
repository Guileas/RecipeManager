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

@WebServlet("deleteIngredient")
public class DeleteIngredientServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IngredientDao idao = DaoFactory.getIngredientDao();
		Ingredient i = idao.findIngredientById(Long.parseLong(req.getParameter("id")));
		if (i != null) {
			idao.removeIngredient(i);
		}
		resp.sendRedirect("RecipeManager/listIngredient");
	}

}
