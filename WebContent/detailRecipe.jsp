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
</div>
</body>
</html>