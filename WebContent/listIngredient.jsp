<%@ page import="fr.imie.recipemanager.servlet.ListIngredientServlet" %>
<%@ page import="fr.imie.recipemanager.entity.Ingredient" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListIngredient</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div>
	<h1>My Ingredients list</h1>
</div>
<div>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<td>#</td>
				<td>Name</td>
				<td>Price</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ingredients}" var="i">
				<tr>
					<td><c:out value="${i.getId()}"></c:out></td>
					<td><c:out value="${i.getName()}"></c:out></td>
					<td><c:out value="${i.getPrice()}"></c:out></td>
					<td>
						<form method="get" action="deleteIngredient" >
							<input type="hidden" name="id" value="${r.getId()}">
							<button type="submit" value="Delete"></button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>