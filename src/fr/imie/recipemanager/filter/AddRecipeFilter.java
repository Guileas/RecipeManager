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

import fr.imie.recipemanager.servlet.AddRecipeServlet;

@WebFilter("/addRecipe")
public class AddRecipeFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		try {
			if (AddRecipeServlet.ingredients.equals(null)) {
				filter.doFilter(req, response);
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		req.getRequestDispatcher("/listIngredient").forward(req, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
