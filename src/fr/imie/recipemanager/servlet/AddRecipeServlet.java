package fr.imie.recipemanager.servlet;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.recipemanager.dao.DaoFactory;
import fr.imie.recipemanager.dao.RecipeDao;
import fr.imie.recipemanager.dao.UserDao;
import fr.imie.recipemanager.entity.Recipe;

@WebServlet("/addRecipe")
public class AddRecipeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
		Recipe recipe = new Recipe(req.getParameter("name"),
				req.getParameter("description"),
				Float.parseFloat(req.getParameter("totalPrice")),
				LocalTime.parse(req.getParameter("preparationTime"), dateTimeFormatter),
				LocalTime.parse(req.getParameter("cookingTime"), dateTimeFormatter));
		
		UserDao udao = DaoFactory.getUserDao();
		
		if (udao.findUserByPseudo(LoginServlet.pseudo).getId() == null) {
			resp.sendRedirect("/RecipeManager/login");
		} else {
			RecipeDao recipeDao = DaoFactory.getRecipeDao();
			recipe.setUserRecipe(udao.findUserByPseudo(LoginServlet.pseudo));
			recipeDao.addRecipe(recipe);
			resp.sendRedirect("/RecipeManager/myRecipe");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/addRecipe.jsp").forward(req, resp);
	}
}
