<!DOCTYPE html>
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
						<th>Description</th>
						<th>Price</th>
						<c:if test="${!(empty sessionScope.username)}">
							<th></th>
						</c:if>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="r" items="${recipes}">
							<tr onclick="location.href = 'http://localhost:8080/RecipeManager/detailRecipe?id=${r.id}';">
								<th>${r.id}</th>
								<td>${r.name}</td>
								<td>${r.description}</td>
								<td>${r.price}</td>
								<c:if test="${!(empty sessionScope.username)}">
									<td><button class="btn btn-danger" onclick="location.href = 'http://localhost:8080/RecipeManager/deleteRecipe?id=${r.id}';">Delete</button></td>
								</c:if>
							</tr>
					</c:forEach>
				</tbody>
				
			</table>
			
		</div>
</body>
</html>