package fr.imie.recipemanager.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class AuthentificationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		if ((req.getSession().getAttribute("pseudo") != null) || (req.getRequestURI().equals("/RecipeManager/login")) || (req.getRequestURI().equals("/RecipeManager/signIn"))) {
			filter.doFilter(req, response);
			
		} else {
			req.getRequestDispatcher("/login.jsp").forward(req, response);
			System.out.println("No user found");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
