package fr.imie.recipemanager.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/ws")
public class RestService extends Application {

	public RestService() {
	}

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> returnValue = new HashSet<>();
		returnValue.add(IngredientRessource.class);
		return returnValue;
	}

}
