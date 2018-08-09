<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In</title>
</head>
<body>
<h1>Sign in</h1>
<form method="post" action="/RecipeManager/signIn">
	<label>Lastname : </label>
	<input type="text" name="lastname" />
	<label>Firstname : </label>
	<input type="text" name="firstname" />
	<label>Choose your pseudo : </label>
	<input type="text" name="pseudo" />
	<label>Choose your password : </label>
	<input type="password" name="password" />
	<input type="submit" value="OK" />
</form>
<!-- J'aimerais un chamop avec une variable qui se mettra à jour en fonction de ce que j'ai mis
dans mon code InscriptionServlet (String message) -->
</body>
</html>