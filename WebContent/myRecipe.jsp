<%@ page import="fr.imie.recipemanager.servlet.MyRecipeServlet"%>
<%@ page import="fr.imie.recipemanager.entity.Recipe"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="recipe.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Recipe</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div>
			<h1 class="title">Recipes</h1>
		</div>
		
		<div>
		
			<table class="table">
			
				<thead class="thead-dark">
					<tr>
						<th>#</th>
						<th>Name</th>
						<th>Price</th>
						<th>Manage recipe</th>
						<th>Delete recipe</th>
						<c:if test="${!(empty sessionScope.pseudo)}">
							<th></th>
						</c:if>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${recipes}" var="r" >
							<tr>
								<th onclick="location.href = 'http://localhost:8082/RecipeManager/detailRecipe?id=${r.id}';">
								<c:out value="${r.getId()}"></c:out></th>
								<th onclick="location.href = 'http://localhost:8082/RecipeManager/detailRecipe?id=${r.id}';">
								<c:out value="${r.getName()}"></c:out></th>
								<th onclick="location.href = 'http://localhost:8082/RecipeManager/detailRecipe?id=${r.id}';">
								<c:out value="${r.getTotalPrice()}"></c:out></th>
								<th></th>
								<c:if test="${!(empty sessionScope.pseudo)}">
									<th>
										<form method="get" action="deleteRecipe" >
											<input type="hidden" name="id" value="${r.getId()}">
											<button type="submit" value="Delete" class="btn btn-danger">DELETTE</button>
										</form>
									</th>
								</c:if>
							</tr>
					</c:forEach>
					<tr>
						<th>
							<a type="button" class="btn" href="/RecipeManager/addIngredient">Add a new Recipe</a>
						</th>
					</tr>
				</tbody>
				
			</table>
			
		</div>
</body>
</html>