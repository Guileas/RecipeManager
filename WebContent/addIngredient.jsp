<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="ingredient.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add ingredients</title>
</head>
<body>

<%@ include file="header.jsp" %>
<br>
<h1 class="title">Add new ingredients for your future recipes</h1>
<br>
<form action="/RecipeManager/addIngredient" method="post" class="form-group">
<div class="row">
		<div class="container">
			<div class="row">
    			<div class="col align-self-center">
			<input name="name" type="text" placeholder="Ingredient Name" class="form-control" required/>
				</div>
				<div class="col align-self-center">
			<input name="price" type="number" step="0.01" placeholder="Ingredient price" class="form-control" required/>
				</div>
			<input type="submit" value="Send" class="btn btn-primary btn-form"/>
		</div>
	</div>
</div>
</form>
</body>
</html>