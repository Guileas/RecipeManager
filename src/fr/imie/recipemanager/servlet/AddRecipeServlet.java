package fr.imie.recipemanager.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		
		/*
		 * Get form parameters
		 */
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		Date parsedDate;
		/*try {
			parsedDate = (Date) dateFormat.parse(req.getParameter("cookingTime"));
			Timestamp cookingTime = new java.sql.Timestamp(parsedDate.getTime());
			
			Date parsedPreparation = (Date) dateFormat.parse(req.getParameter("preparatonTime"));
			Timestamp preparationTime = new java.sql.Timestamp(parsedPreparation.getTime());
			
			
			
		} catch (ParseException e) {
			System.out.println("Conversion fail");
		}*/
		
		Recipe recipe = new Recipe(req.getParameter("name"), req.getParameter("description"), req.getParameter("cookingTime"), 
				req.getParameter("preparatonTime"), Float.parseFloat(req.getParameter("totalPrice")));
		
		/*
		 * Db insertion
		 */
		RecipeDao recipeDao = DaoFactory.getRecipeDao();
		recipeDao.addRecipe(recipe);
		
		resp.sendRedirect("/RecipeManager/myRecipe");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/addRecipe.jsp").forward(req, resp);
	}

}
