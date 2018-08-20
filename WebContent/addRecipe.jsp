<%@ page import="fr.imie.recipemanager.servlet.AddRecipeServlet" %>
<%@ page import="fr.imie.recipemanager.entity.Ingredient" %>
<%@ page import="fr.imie.recipemanager.dao.jpa.JpaIngredientDao" %>
<%@ page import="fr.imie.recipemanager.dao.DaoFactory" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="recipe.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new Recipe</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div>
<br>
	<h1 class="title">Add a new Recipe</h1>
<br>
</div>
	<table class="table">
				
		<tbody>
		<form action="/RecipeManager/addRecipe" method="post" class="form-group">
			<input name="name" type="text" placeholder="Recipe Name" class="form-control" required/>
			<input name="description" type="text" placeholder="Recipe Description" class="form-control"/>
			<input type="time" id="appt-time" name="preparationTime" min="00:00" max="72:00" />
			<input type="time" id="appt-time" name="cookingTime" min="00:00" max="72:00" />
			<input name="totalPrice" type="number" step="0.01" placeholder="Recipe price" class="form-control" />
			<SELECT name="listeDeroulante" size="1">
			<%for (Ingredient ingredient : DaoFactory.getIngredientDao().getAllIngredient()) {
				ingredient.getName();
				Long id = ingredient.getId();
			%>
			<OPTION><%out.println(ingredient.getName()); %>
			<%} %>
			</SELECT>
			<input type="submit" value="Send" class="btn btn-primary btn-form"/>
		</form>
		</tbody>
	</table>
</body>
</html>