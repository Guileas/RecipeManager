package fr.imie.recipemanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import fr.imie.recipemanager.dao.DaoFactory;
import fr.imie.recipemanager.dao.RecipeDao;
import fr.imie.recipemanager.dao.UserDao;
import fr.imie.recipemanager.entity.Recipe;
import fr.imie.recipemanager.entity.User;

@WebServlet("/myRecipe")
public class MyRecipeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException {
		UserDao udao = DaoFactory.getUserDao();
		User u = udao.findUserByPseudo((LoginServlet.pseudo));
		try {
			if (u.getId().equals(null)) {
				System.out.println("It's null");
				String msg = "You need to log you, please clik on 'LogIn'";
				JOptionPane.showMessageDialog(null, msg);
			} else {
				System.out.println("Mon id : " + udao.findUserByPseudo(LoginServlet.pseudo).getId().toString());
				RecipeDao recipeDao = DaoFactory.getRecipeDao();
				List<Recipe> recipes = recipeDao.getAllUserRecipe(u);
				if (recipes == null) {
					System.out.println("Mes recettes sont vides !!!");
				}
				for (Recipe recipe : recipes) {
					System.out.println("Ma recette : " + recipe.getName());
				}
				req.setAttribute("recipes", recipes);
			}
		} catch (NullPointerException e) {
			System.out.println("Message d'erreur du doGet : " + e.getMessage());
		}

		req.getRequestDispatcher("/myRecipe.jsp").forward(req, resp);
	}

}
