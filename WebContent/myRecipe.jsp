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
						<th>Price</th>
						<c:if test="${!(empty sessionScope.pseudo)}">
							<th></th>
						</c:if>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${recipes}" var="r" >
							<tr>
								<th onclick="location.href = 'http://localhost:8082/RecipeManager/detailRecipe?id=${r.id}';">${r.id}</th>
								<td onclick="location.href = 'http://localhost:8082/RecipeManager/detailRecipe?id=${r.id}';">${r.name}</td>
								<td onclick="location.href = 'http://localhost:8082/RecipeManager/detailRecipe?id=${r.id}';">${r.totalPrice}</td>
								<c:if test="${!(empty sessionScope.pseudo)}">
									<td><button class="btn btn-danger" onclick="location.href = 'http://localhost:8082/RecipeManager/deleteRecipe?id=${r.id}';">Delete</button></td>
								</c:if>
							</tr>
					</c:forEach>
				</tbody>
				
			</table>
			
		</div>
</body>
</html>