<%@page import="java.util.List"%>
<%@page import="fr.imie.recipemanager.dao.DaoFactory"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="fr.imie.recipemanager.servlet.ListIngredientServlet" %>
<%@ page import="fr.imie.recipemanager.entity.Ingredient" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="ingredient.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListIngredient</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div>
<br>
	<h1 class="title">My Ingredients list</h1>
<br>
</div>
<div>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>#</th>
				<th>Name</th>
				<th>Price</th>
				<th>Delete an ingredient</th>
				<th>Choose ingredients for your recipe</th>
				<c:if test="${!(empty sessionScope.username)}">
				<th></th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ingredients}" var="i">
			<tr>
				<th><c:out value="${i.getId()}"></c:out></th>
				<th><c:out value="${i.getName()}"></c:out></th>
				<th><c:out value="${i.getPrice()}"></c:out></th>
				<th>
					<form method="get" action="deleteRecipe" >
							<input type="hidden" name="id" value="${i.getId()}">
							<button type="submit" value="Delete" class="btn btn-danger">DELETTE</button>
					</form>
				</th>
				<th>
					<input name="checkbox" type="checkbox" value="${i.getId()}"/>

				</th>
			</tr>
			</c:forEach>
		
		<tr></tr>	
			<c:forEach items="${ingredients}" var="i">
			<tr>
				<th>
					<form method="post" action="addRecipe">
						<input type=hidden value="${currentIngredient}">
						<button type="submit" onclick="addRecipe">Add a recipe</button>
					</form>
				</th>			
			</tr>
			</c:forEach>

		</tbody>
	</table>
</div>

</body>
</html>