<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="login.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
</head>
<body>
<div>
	<h1 class="title">You need to log :</h1>
	<br>
</div>
<form method="post" action="/RecipeManager/login" class="form-group">
	<div class="row">
		<div class="container">
			<div class="row">
    			<div class="col align-self-center">
					<label class="pseudo">Pseudo : </label>
					<input type="text" name="pseudo" class="form-control"/>
				</div>
				<div class="col align-self-center">
					<label class="pwd">Mot de passe : </label>
					<input type="password" name="password" class="form-control"/>
				</div>
				<div class="col align-self-center">
					<input type="submit" value="OK" class="btn btn-primary btn-form"/>
				</div>
		</div>
	</div>
	
  </div>
  <a class="nav-link active" href="/RecipeManager/signIn">sign In</a>
</form>
</body>
</html>