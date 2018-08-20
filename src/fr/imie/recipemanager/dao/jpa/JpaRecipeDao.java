package fr.imie.recipemanager.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.QueryException;

import fr.imie.recipemanager.dao.RecipeDao;
import fr.imie.recipemanager.entity.Recipe;

/*
 * Override all the recipe function, give them specific performance
 */
public class JpaRecipeDao implements RecipeDao {

	private EntityManagerFactory emf;
	
	public JpaRecipeDao(EntityManagerFactory emf) {
		this.emf =emf;
	}
	
	@Override
	public void addRecipe(Recipe r) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(r);
			t.commit();
		}finally {
			if(t.isActive()) {
				t.rollback();
			}
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getAllRecipe() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT r FROM Recipe AS r");
		List<Recipe> recipes = query.getResultList();
		System.out.println(recipes);
		em.close();
		return recipes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getAllUserRecipe(long id) {
		EntityManager em = emf.createEntityManager();
		List<Recipe> recipes = null;
		try {
			Query query = em.createQuery("SELECT r FROM Recipe AS r WHERE r.userRecipe = :id");
			query.setParameter("id", id);
			recipes = query.getResultList();
			for (Recipe recipe : recipes) {
				System.out.println("L'utilisateur" + recipe.getUserRecipe().getLastname());
			}
		} catch (QueryException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		return recipes;
	}
	
	@Override
	public Recipe findRecipeById(long id) {
		EntityManager em = emf.createEntityManager();
		Recipe recipe = em.find(Recipe.class, id);
		em.close();
		return recipe;
	}

	@Override
	public void removeRecipe(Recipe r) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		 
		try {
			t.begin();
			if(!em.contains(r)) {
				r = em.merge(r);
			}
			em.remove(r);
			t.commit();
		}finally {
			if(t.isActive()) {
				t.rollback();
			}
			em.close();
		}
	}
 
	
}
