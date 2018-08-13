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

@WebServlet("/myRecipe")
public class MyRecipeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao udao = DaoFactory.getUserDao();
		try {
			if (udao.findUserByPseudo(LoginServlet.pseudo).getId() == null) {
				System.out.println("It's null");
				JOptionPane jop = new JOptionPane();
				String msg = "You need to log you, please clik on 'LogIn'";
				jop.showMessageDialog(null, msg);
			} else {
				System.out.println(udao.findUserByPseudo(LoginServlet.pseudo).getId().toString());
				RecipeDao recipeDao = DaoFactory.getRecipeDao();
				List<Recipe> recipes = recipeDao.getAllUserRecipe((Long)udao.findUserByPseudo(LoginServlet.pseudo).getId());
				req.setAttribute("recipes", recipes);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		req.getRequestDispatcher("/myRecipe.jsp").forward(req, resp);
	}

}
