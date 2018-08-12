package fr.imie.recipemanager.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
		
		/*
		 * Get form parameters
		 */
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		Date parsedDate;
		
		Recipe recipe = new Recipe(req.getParameter("name"),
				req.getParameter("description"),
				Float.parseFloat(req.getParameter("totalPrice")),
				LocalTime.parse(req.getParameter("preparationTime"), dateTimeFormatter),
				LocalTime.parse(req.getParameter("cookingTime"), dateTimeFormatter));
		
		RecipeDao recipeDao = DaoFactory.getRecipeDao();
		recipeDao.addRecipe(recipe);
		
		resp.sendRedirect("/RecipeManager/myRecipe");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/addRecipe.jsp").forward(req, resp);
	}

}
