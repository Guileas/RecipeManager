package fr.imie.recipemanager.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.recipemanager.dao.QuantityDao;
import fr.imie.recipemanager.entity.Quantity;

/*
 * Override all the quantity function, give them specific performance
 */
public class JpaQuantityDao implements QuantityDao {

	private EntityManagerFactory emf;

	public JpaQuantityDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void addQuantity(Quantity q) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(q);
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
	public List<Quantity> getAllQuantity() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT q FROM Quantity AS q");
		List<Quantity> quantitys = query.getResultList();
		em.close();
		return quantitys;
	}

	@Override
	public Quantity findQuantityByIdRecipe(long id) {
		EntityManager em = emf.createEntityManager();
		Quantity q = em.find(Quantity.class, id);
		em.close();
		return q;
	}

	@Override
	public void removeQuantity(Quantity q) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		 
		try {
			t.begin();
			if(!em.contains(q)) {
				q = em.merge(q);
			}
		}finally {
			if(t.isActive()) {
				t.rollback();
			}
			em.close();
		}
	}
}
