package fr.imie.recipemanager.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.recipemanager.dao.UserDao;
import fr.imie.recipemanager.entity.User;

/*
 * Override all the user function, give them specific performance
 */
public class JpaUserDao implements UserDao {
	
	private EntityManagerFactory emf;

	public JpaUserDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void addUser(User u) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(u);
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
	public List<User> getAllUser() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT u FROM User AS u");
		List<User> users = query.getResultList();
		em.close();
		return users;
	}

	@Override
	public User findUserById(long id) {
		EntityManager em = emf.createEntityManager();
		User u = em.find(User.class, id);
		em.close();
		return u;
	}

	@Override
	public void removeUser(User u) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		 
		try {
			t.begin();
			if(!em.contains(u)) {
				u = em.merge(u);
			}
		}finally {
			if(t.isActive()) {
				t.rollback();
			}
			em.close();
		}
	}
}
