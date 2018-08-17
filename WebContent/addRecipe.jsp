<%@ page import="fr.imie.recipemanager.servlet.AddRecipeServlet" %>
<%@ page import="fr.imie.recipemanager.entity.Ingredient" %>
<%@ page import="fr.imie.recipemanager.dao.jpa.JpaIngredientDao" %>
<%@ page import="fr.imie.recipemanager.dao.DaoFactory" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new Recipe</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div>
	<h1>Add a new Recipe</h1>
</div>
<form action="/RecipeManager/addRecipe" method="post" class="form-group">
	<table class="table">
			
		<thead class="thead-dark">
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Preparation Time</th>
				<th>Cooking Time</th>
				<th></th>
				<c:if test="${!(empty sessionScope.username)}">
				<th></th>
				</c:if>
			</tr>
		</thead>
				
		<tbody>
		<tr>
			<th><input name="name" type="text" placeholder="Recipe Name" class="form-control" required/></th>
			<th><input name="description" type="text" placeholder="Recipe Description" class="form-control"/></th>
			<th><input type="time" id="appt-time" name="preparationTime" min="00:00" max="72:00" /></th>
			<th><input type="time" id="appt-time" name="cookingTime" min="00:00" max="72:00" /></th>
			<th><input name="totalPrice" type="number" step="0.01" placeholder="Recipe price" class="form-control" /></th>
			<th><SELECT name="listeDeroulante" size="1">
				<c:forEach items="${is}" var="i">
					<th><c:out value="${i.getName()}"></c:out></th>
					<th><c:out value="${i.getPrice()}"></c:out></th>
					<th>
					<form method="post" action="addRecipe">
						<input type="hidden" name="id" value="${i.getId()}">
						<button name="addButton" type="submit" value="Add Ingredient"></button>
					</form>
				</th>
				<OPTION value="${i.getName()}">
				</c:forEach>
			</SELECT></th>
		</tr>
		<tr>
		</tr>
		<tr>
			<th><input name="validationButton" type="submit" value="Send" class="btn btn-primary btn-form"/></th>
		</tr>
		</tbody>
	</table>
	</form>
</body>
</html>