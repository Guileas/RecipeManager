package fr.imie.recipemanager.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.recipemanager.dao.PictureDao;
import fr.imie.recipemanager.entity.Picture;

/*
 * Override all the picture function, give them specific performance
 */
public class JpaPictureDao implements PictureDao {

	private EntityManagerFactory emf;

	public JpaPictureDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void addPicture(Picture p) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(p);
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
	public List<Picture> getAllPicture() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Picture AS p");
		List<Picture> pictures = query.getResultList();
		em.close();
		return pictures;
	}

	@Override
	public Picture findPictureById(long id) {
		EntityManager em = emf.createEntityManager();
		Picture p = em.find(Picture.class, id);
		em.close();
		return p;
	}

	@Override
	public void removePicture(Picture p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		 
		try {
			t.begin();
			if(!em.contains(p)) {
				p = em.merge(p);
			}
		}finally {
			if(t.isActive()) {
				t.rollback();
			}
			em.close();
		}
	}
}
