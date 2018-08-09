package fr.imie.recipemanager.dao;

import java.util.List;

import fr.imie.recipemanager.entity.User;

/*
 * Initialize all user function to use them in servlet
 */
public interface UserDao {

	void addUser(User u);
	List<User> getAllUser();
	User findUserById(long id);
	User findUserByPseudo(String pseudo);
	void removeUser(User u);
}
