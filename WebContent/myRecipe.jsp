<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div>
			<h1>Recipes</h1>
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
					<c:forEach items="${recipes}" var="r" >
							<tr onclick="location.href = 'http://localhost:8080/RecipeManager/detailRecipe?id=${r.id}';">
								<th>${r.id}</th>
								<td>${r.name}</td>
								<td>${r.description}</td>
								<td>${r.preparationTime}</td>
								<td>${r.cookingTime}</td>
								<td>${r.totalPrice}</td>
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