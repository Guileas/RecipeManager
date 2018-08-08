package fr.imie.recipemanager.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.recipemanager.dao.IngredientDao;
import fr.imie.recipemanager.entity.Ingredient;

/*
 * Override all the ingredient function, give them specific performance
 */
public class JpaIngredientDao implements IngredientDao {

	private EntityManagerFactory emf;

	public JpaIngredientDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void addIngredient(Ingredient i) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(i);
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
	public List<Ingredient> getAllIngredient() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT i FROM Ingredient AS i");
		List<Ingredient> ingredients = query.getResultList();
		em.close();
		return ingredients;
	}

	@Override
	public Ingredient findIngredientById(long id) {
		EntityManager em = emf.createEntityManager();
		Ingredient i = em.find(Ingredient.class, id);
		em.close();
		return i;
	}

	@Override
	public void removeIngredient(Ingredient i) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		 
		try {
			t.begin();
			if(!em.contains(i)) {
				i = em.merge(i);
			}
		}finally {
			if(t.isActive()) {
				t.rollback();
			}
			em.close();
		}
		
	}
}
