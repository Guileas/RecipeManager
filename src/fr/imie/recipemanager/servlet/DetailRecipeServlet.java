package fr.imie.recipemanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.recipemanager.dao.DaoFactory;
import fr.imie.recipemanager.dao.MarkDao;
import fr.imie.recipemanager.dao.RecipeDao;
import fr.imie.recipemanager.entity.Mark;
import fr.imie.recipemanager.entity.Recipe;

@WebServlet("/detailRecipe")
public class DetailRecipeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("listeDeroulante"));
		MarkDao markDao = DaoFactory.getMarkDao();
		Mark mark = new Mark(Float.parseFloat(req.getParameter("listeDeroulante")));
		markDao.addMark(mark);
		resp.sendRedirect("/RecipeManager/listRecipe");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RecipeDao rdao = DaoFactory.getRecipeDao();
		Recipe recipes = rdao.findRecipeById(Long.parseLong(req.getParameter("id")));

		req.setAttribute("recipe", recipes);		
		req.getRequestDispatcher("/detailRecipe.jsp").forward(req, resp);
	}

}
