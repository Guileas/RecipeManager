<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
</head>
<body>

<%@ include file="header.jsp" %>
<form method="post" action="/RecipeManager/login">
	<label>Pseudo : </label>
	<input type="text" name="pseudo" />
	<label>Mot de passe : </label>
	<input type="password" name="password" />
	<input type="submit" value="OK" />
</form>
</body>
</html>