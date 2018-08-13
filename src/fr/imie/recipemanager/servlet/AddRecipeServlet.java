package fr.imie.recipemanager.servlet;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import fr.imie.recipemanager.dao.DaoFactory;
import fr.imie.recipemanager.dao.IngredientDao;
import fr.imie.recipemanager.dao.RecipeDao;
import fr.imie.recipemanager.dao.UserDao;
import fr.imie.recipemanager.entity.Ingredient;
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
			resp.sendRedirect("/RecipeManager/detailRecipe");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/addRecipe.jsp").forward(req, resp);
	}
	/*
	 * Get form parameters
	 */
	/*
	 * SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss"); Date
	 * parsedDate; try { parsedDate = (Date)
	 * dateFormat.parse(req.getParameter("cookingTime")); Timestamp cookingTime =
	 * new java.sql.Timestamp(parsedDate.getTime());
	 * 
	 * Date parsedPreparation = (Date)
	 * dateFormat.parse(req.getParameter("preparatonTime")); Timestamp
	 * preparationTime = new java.sql.Timestamp(parsedPreparation.getTime());
	 * 
	 * 
	 * 
	 * } catch (ParseException e) { System.out.println("Conversion fail"); }
	 */

	/*
	 * String nom = "test"; String description = "test d'insertion d'une date";
	 * Float prix = (float) 5.5; DateTimeFormatter dtw =
	 * DateTimeFormatter.ISO_LOCAL_TIME; String time = "10:15:30"; LocalTime time1 =
	 * LocalTime.parse(time, dtw);
	 * 
	 * Recipe testbdd = new Recipe(nom, description, prix, time1);
	 * System.out.println("Nom de ma recette : " + testbdd.getName());
	 * System.out.println("Description : " + testbdd.getDescription());
	 * System.out.println("Prix : " + testbdd.getTotalPrice());
	 * System.out.println("Test du temps : " + testbdd.getTest());
	 */
}
