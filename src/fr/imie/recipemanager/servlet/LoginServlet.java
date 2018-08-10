package fr.imie.recipemanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.recipemanager.dao.DaoFactory;
import fr.imie.recipemanager.dao.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pseudo = req.getParameter("pseudo");
		String password = req.getParameter("password");
		String name = null;
		String psd = null;
		
		UserDao udao = DaoFactory.getUserDao();
		name = udao.findUserByPseudo(pseudo).getPseudo();
		psd = udao.findUserByPseudo(pseudo).getPassword();
		
		System.out.println("pseudo : " + name + " et mot de passe : " + psd);
		System.out.println("pseudo : " + pseudo + " et mot de passe : " + password);
		System.out.println(name.length() + " " + pseudo.length());
		
		/// Fonction à refaire avec recherche en BDD du pseudo et du mdp
		if (name.equals(pseudo) && psd.equals(password)) {
			req.getSession().setAttribute("pseudo", pseudo);
			req.getSession().setAttribute("password", password);
			resp.sendRedirect("/RecipeManager/addIngredient");
		} else {
			System.out.println("Your pseudo doesn't exists or your password is not exact");
			resp.sendRedirect("/RecipeManager/login");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

}
