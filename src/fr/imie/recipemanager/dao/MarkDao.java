package fr.imie.recipemanager.dao;

import java.util.List;

import fr.imie.recipemanager.entity.Mark;

/*
 * Initialize all mark function to use them in servlet
 */
public interface MarkDao {

	void addMark(Mark m);
	List<Mark> getAllMark();
	Mark findMarkById(long id);
	void removeMark(Mark m);
}
