package fr.imie.recipemanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pseudo = req.getParameter("pseudo");
		String password = req.getParameter("password");
		String name = "test";
		String psd = "test";
		
		if ((pseudo.equals(name)) && (password.equals(psd))) {
			req.getSession().setAttribute("pseudo", pseudo);
			req.getSession().setAttribute("password", password);
			resp.sendRedirect("/RecipeManager/addIngredient");
		} else if ((pseudo != name) || (password != psd)) {
			System.out.println("le pseudo est erroné");
			resp.sendRedirect("/RecipeManager/login");
		} else {
			System.out.println("else");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

}
