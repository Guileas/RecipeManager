package fr.imie.recipemanager.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.recipemanager.dao.MarkDao;
import fr.imie.recipemanager.entity.Mark;

/*
 * Override all the mark function, give them specific performance
 */
public class JpaMarkDao implements MarkDao {

	private EntityManagerFactory emf;

	public JpaMarkDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void addMark(Mark m) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(m);
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
	public List<Mark> getAllMark() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT m FROM Mark AS m");
		List<Mark> marks = query.getResultList();
		em.close();
		return marks;
	}

	@Override
	public Mark findMarkById(long id) {
		EntityManager em = emf.createEntityManager();
		Mark m = em.find(Mark.class, id);
		em.close();
		return m;
	}

	@Override
	public void removeMark(Mark m) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		 
		try {
			t.begin();
			if(!em.contains(m)) {
				m = em.merge(m);
			}
		}finally {
			if(t.isActive()) {
				t.rollback();
			}
			em.close();
		}
		
	}
}
