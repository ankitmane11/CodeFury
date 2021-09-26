<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- This is the style for the header -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/Loginstyle.css">

<!-- This is just a font that we'll be using. You can remove lines 12-14 if you don't want to use Poppins -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap"
	rel="stylesheet">
<script src="myscript.js"></script>
<title>Login Form</title>
</head>
<header>
	<div class="inner">
		<div class="logo">
			<div>Bug Tracker</div>
		</div>

		<nav>
			<li><span><a href="Import.jsp">Import</a></span></li>
			<li><span><a href="Register.jsp">Register</a></span></li>
			<li><span><a href="Login.jsp" class="button">Login</a></span></li>
			<li><span><a href="home.html">Home</a></span></li>
		</nav>
	</div>
</header>


<body>

	<div class="bg-image">
		<form name="Login-form" onsubmit="return validateData()">

			<div>
				<table>
					<h3 style="text-align: center">Please Enter Login Details</h3>
					<br>
					<tr>
						<label>Username:</label>
						<input type="text" placeholder="Enter Username" name="username"
							required="required">
						<br>
						<br>
					</tr>
					<tr>
						<label>Password:</label>
						<input type="password" placeholder="Enter Password"
							name="password" required="required">
						<br>
						<br>
					</tr>
					<tr>
						<label>Role: </label>
						<select name="cars" id="cars">
							<option value="Manager">Manger</option>
							<option value="Developer">Developer</option>
							<option value="Tester">Tester</option>
						</select>
					</tr>

					<tr>
						<button type="submit" value="login">Login</button>

						<div id="error"></div>
					</tr>
				</table>
			</div>
		</form>
	</div>

</body>
</html>