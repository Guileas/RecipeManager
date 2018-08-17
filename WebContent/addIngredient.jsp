<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="header.jsp" %>
	<form action="/RecipeManager/addIngredient" method="post" class="form-group">
		<input name="name" type="text" placeholder="Ingredient Name" class="form-control" required/>
		<input name="price" type="number" step="0.01" placeholder="Ingredient price" class="form-control" required/>
		<input type="submit" value="Send" class="btn btn-primary btn-form"/>
	</form>
</body>
</html>