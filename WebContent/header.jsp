<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib	prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="nav">
  	<c:if test="${empty sessionScope.username}">
		<a class="nav-link active" href="/RecipeManager/login">login</a>
		<a class="nav-link active" href="/RecipeManager/signIn">sign In</a>
  	</c:if>
  	<c:if test="${!(empty sessionScope.username)}">
		<a class="nav-link active" href="/RecipeManager/addIngredient">Add a ingredient</a>
		<a class="nav-link active" href="/RecipeManager/addRecipe">Add recipe</a>
  	</c:if>
  	<a class="nav-link active" href="/RecipeManager/addIngredient">Add a ingredient</a>
		<a class="nav-link active" href="/RecipeManager/addRecipe">Add recipe</a>
  		<a class="nav-link" href="/RecipeManager/myRecipe">List of my recipe</a>
  		<a class="nav-link" href="/RecipeManager/listTopRecipe">List top recipe</a>
  		
  	<c:if test="${!(empty sessionScope.username)}">
  		<a class="nav-link" href="/RecipeManager/logout">Logout</a>
  	</c:if>
</nav>


