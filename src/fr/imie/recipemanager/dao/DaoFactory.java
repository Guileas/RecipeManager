package fr.imie.recipemanager.dao;

import fr.imie.recipemanager.dao.jpa.JpaIngredientDao;
import fr.imie.recipemanager.dao.jpa.JpaMarkDao;
import fr.imie.recipemanager.dao.jpa.JpaPictureDao;
import fr.imie.recipemanager.dao.jpa.JpaQuantityDao;
import fr.imie.recipemanager.dao.jpa.JpaRecipeDao;
import fr.imie.recipemanager.dao.jpa.JpaUserDao;
import fr.imie.recipemanager.util.PersistenceManager;

/*
 * Call all the Jpa for getting them in the servlet
 */
public class DaoFactory {
	
	private DaoFactory() {
		
	}
	
	public static IngredientDao getIngredientDao() {
		return new JpaIngredientDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static MarkDao getMarkDao() {
		return new JpaMarkDao( PersistenceManager.getEntityManagerFactory());
	}
	
	public static PictureDao getPictureDao() {
		return new JpaPictureDao(PersistenceManager.getEntityManagerFactory());
	}
	
	
	public static QuantityDao getQuantityDao() {
		return new JpaQuantityDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static RecipeDao getRecipeDao() {
		return new JpaRecipeDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static UserDao getUserDao() {
		return new JpaUserDao(PersistenceManager.getEntityManagerFactory());
	}
}
