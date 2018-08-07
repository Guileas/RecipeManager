package fr.imie.recipemanager.ws;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/ws")
public class RestService extends Application {

	public RestService() {
	}
	
	/// Override à reprendre
	/*
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> returnValue = new HashSet();
		returnValue.add(ProductRessource.class);
		return returnValue;
	}
	*/

}
