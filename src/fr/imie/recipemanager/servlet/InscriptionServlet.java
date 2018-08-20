package fr.imie.recipemanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.recipemanager.dao.DaoFactory;
import fr.imie.recipemanager.dao.UserDao;
import fr.imie.recipemanager.entity.User;

@WebServlet("/signIn")
public class InscriptionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	String message = null;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String pseudo = req.getParameter("pseudo");
		String password = req.getParameter("password");
		
		if (lastname == null || firstname == null || pseudo == null || password == null) {
			message = "You must have to complete all the fields.";
			System.out.println(message);
			resp.sendRedirect("/RecipeManager/signIn");
			
		} else {
			User user = new User(lastname, firstname, pseudo, password);
			System.out.println(lastname + firstname + pseudo + password);
			
			try {
				
				UserDao udao = DaoFactory.getUserDao();
				
				if(udao.findUserByPseudo(pseudo).equals(null)) {
					message = "This pseudo already exists, please choose an other one.";
					System.out.println(message + " et le pseudo est : " + udao.findUserByPseudo(pseudo).getPseudo());
					resp.sendRedirect("/RecipeManager/signIn");
					
				} else {
					udao.addUser(user);
					message = null;
					resp.sendRedirect("/RecipeManager/addIngredient");
				}		
				
			} catch (Exception e) {
				message = e.getMessage();
				System.out.println(message);
				resp.sendRedirect("/RecipeManager/signIn");
				
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		/// instanciation
		EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory(); 
		EntityManager em = emf.createEntityManager();
		
		/// Vérification de toutes les entités :
		for (EntityType<?> iterable_element : em.getMetamodel().getEntities()) {
			System.out.println(iterable_element.getName());
		}
		
		/// récupération de tous les users dans la table user
		List<Query> queries = em.createNativeQuery("SELECT * FROM user").getResultList();
		
		for (Query query : queries) {
			System.out.println(query.toString());
		}*/
		
		req.getRequestDispatcher("/signIn.jsp").forward(req, resp);
	}
}
