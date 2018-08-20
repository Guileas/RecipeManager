<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div>
	<h1>My Recipe</h1>
</div>
<div>
	<h1>${recipe.getName()}</h1>
	<p>${recipe.getDescription()}</p>
	<p>${recipe.getPreparationTime()}</p>
	<p>${recipe.getCookingTime()}</p>
	<p>${recipe.getTotalPrice()}</p>
	
	<form action="/RecipeManager/detailRecipe" method="post" class="form-group">
	<SELECT name="listeDeroulante" size="1">
		<option>1</option>
		<option>2</option>
		<option>3</option>
		<option>4</option>
		<option>5</option>
		<option>6</option>
		<option>7</option>
		<option>8</option>
		<option>9</option>
		<option>10</option>
	</SELECT>
	<input type="submit" value="Send" class="btn btn-primary btn-form"/>
	</form>
	
</div>
</body>
</html>