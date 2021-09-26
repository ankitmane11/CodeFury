<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- This is the style for the header -->

<!-- This is just a font that we'll be using. You can remove lines 12-14 if you don't want to use Poppins -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/Loginstyle.css">
<title>Import</title>

</head>
<header>
	<div class="inner">
		<div class="logo">
			<div>Bug Tracker</div>
		</div>

		<nav>
			<li><span><a href="Import.jsp" class="button">Import</a></span></li>
			<li><span><a href="Register.jsp">Register</a></span></li>
			<li><span><a href="Login.jsp">Login</a></span></li>
			<li><span><a href="home.jsp">Home</a></span></li>
		</nav>
	</div>
</header>


<body>

	<div class="bg-image">

		<div>
			<form id="import">
				<table>
					<caption style="text-align: center; font-weight: bolder;">Choose
						A JSON File</caption>
					<tr>


						<td><label id="file" style="margin-left: 30px;">
								Click here to trigger JSON file uploader ! <input type="file"
								accept=".json">
						</label></td>
					</tr>
					<tr>
						<td><label style="color: red" id="err"></label><label
							style="color: green" id="succ"></label></td>
					</tr>
					<tr>

						<td><br> <br> <br>
							<button type="button" id="btn">Submit</button></td>
					</tr>

				</table>
			</form>
		</div>
	</div>


<script src="filescript.js"></script>
</body>

</html>