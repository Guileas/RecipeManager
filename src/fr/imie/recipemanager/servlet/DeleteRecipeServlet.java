package fr.imie.recipemanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.recipemanager.dao.DaoFactory;
import fr.imie.recipemanager.dao.RecipeDao;
import fr.imie.recipemanager.entity.Recipe;

@WebServlet("/deleteRecipe")
public class DeleteRecipeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RecipeDao recipeDao = DaoFactory.getRecipeDao();
		Recipe r = recipeDao.findRecipeById(Long.parseLong(req.getParameter("id")));
		Long id = Long.parseLong(req.getParameter("id"));
		System.out.println(id.toString());
		if (r != null) {
			System.out.println("Nom du produit à supprimer : " + r.getName());
			recipeDao.removeRecipe(r);
		} else {
			resp.getWriter().println("Cet id n'est pas en base de donnée :/");
		}
		resp.sendRedirect("/RecipeManager/listTopRecipe");
	}
}
