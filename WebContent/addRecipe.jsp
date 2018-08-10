<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
		<form action="/RecipeManager/addRecipe" method="post" class="form-group">
			<input name="name" type="text" placeholder="Recipe Name" class="form-control" required/>
			<input name="description" type="text" placeholder="Recipe Description" class="form-control"/>
			<input type="time" id="appt-time" name="preparationTime" min="00:00" max="72:00" />
			<input type="time" id="appt-time" name="cookingTime" min="00:00" max="72:00" />
			<input name="totalPrice" type="number" step="0.01" placeholder="Recipe price" class="form-control" />
			<input type="submit" value="Send" class="btn btn-primary btn-form"/>
		</form>
</body>
</html>