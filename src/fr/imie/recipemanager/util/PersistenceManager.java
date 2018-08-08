package fr.imie.recipemanager.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

	public static EntityManagerFactory emf;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("RecipeManager_PU");
		}
		return emf;
	}
	
	public static void closeEntityManagerFactory() {
		if(emf != null && emf.isOpen()) {
			emf.close();
		}
	}
}
