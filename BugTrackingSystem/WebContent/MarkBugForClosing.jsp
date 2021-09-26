<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Close Bug</title>
</head>
<h1>Enter Bug Id</h1>
<hr>
<body>
	<form action="markBugForClosing" method="POST">

		<table>
			<tr>
				<td>Enter Bug Id</td>
				<td><input type="text" name="bugId"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Mark Bug for Closing"></td>
			</tr>
		</table>
	</form>
	<hr>


</body>
</html>