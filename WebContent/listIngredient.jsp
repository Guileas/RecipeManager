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
						<form method="get" action="deleteIngredient" >
							<input type="hidden" name="id" value="${i.getId()}">
							<button type="submit" value="Delete"></button>
						</form>
					</th>
				</tr>
				
			</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>