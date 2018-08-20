<!DOCTYPE html>
<html>
<head><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="recipe.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div>
<br>
	<h1 class="title">Add a new Recipe</h1>
<br>
</div>
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
		<form action="/RecipeManager/addRecipe" method="post" class="form-group">
			<input name="name" type="text" placeholder="Recipe Name" class="form-control" required/>
			<input name="description" type="text" placeholder="Recipe Description" class="form-control"/>
			<input type="time" id="appt-time" name="preparationTime" min="00:00" max="72:00" />
			<input type="time" id="appt-time" name="cookingTime" min="00:00" max="72:00" />
			<input name="totalPrice" type="number" step="0.01" placeholder="Recipe price" class="form-control" />
			<input type="submit" value="Send" class="btn btn-primary btn-form"/>
		</form>
		</tbody>
	</table>
</body>
</html>