<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div>
			<h1>Products</h1>
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
	</div>
</body>
</html>