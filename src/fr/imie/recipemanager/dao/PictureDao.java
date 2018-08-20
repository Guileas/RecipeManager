package fr.imie.recipemanager.dao;

import java.util.List;

import fr.imie.recipemanager.entity.Picture;

/*
 * Initialize all picture function to use them in servlet
 */
public interface PictureDao {

	void addPicture(Picture p);
	List<Picture> getAllPicture();
	Picture findPictureById(long id);
	void removePicture(Picture p);
}
