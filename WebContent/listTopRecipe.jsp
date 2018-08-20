<%@ page import="fr.imie.recipemanager.servlet.ListIngredientServlet"%>
<%@ page import="fr.imie.recipemanager.entity.Ingredient"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListTopRecipes</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div>
		<h1 class="title">Top Recipes list</h1>
	</div>
	<div>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<td>#</td>
					<td>Name</td>
					<td>Total Price</td>
					<td>Delete</td>
					<c:if test="${!(empty sessionScope.username)}">
						<th></th>
					</c:if>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${recipes}" var="r">
					<tr>
						<td
							onclick="location.href = 'http://localhost:8082/RecipeManager/detailRecipe?id=${r.id}';"><c:out
								value="${r.getId()}"></c:out></td>
						<td
							onclick="location.href = 'http://localhost:8082/RecipeManager/detailRecipe?id=${r.id}';"><c:out
								value="${r.getName()}"></c:out></td>
						<td
							onclick="location.href = 'http://localhost:8082/RecipeManager/detailRecipe?id=${r.id}';"><c:out
								value="${r.getTotalPrice()}"></c:out></td>
<<<<<<< HEAD

						<c:if test="${!(empty sessionScope.pseudo)}">
							<td><button class="btn btn-danger"
									onclick="location.href = 'http://localhost:8082/RecipeManager/deleteRecipe?id=${r.id}';">Delete</button></td>
						</c:if>
=======
>>>>>>> origin/coco
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>