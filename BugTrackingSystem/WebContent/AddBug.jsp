<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report Bug</title>
</head>
<h1>Enter Bug Details</h1>
<hr>
<body>
	<form action="addBug" method="POST">

		<table>
			<tr>
				<td>Enter Project name</td>
				<td><input type="text" name="projectname"></td>
			</tr>
			<tr>
				<td>Enter Bug Name</td>
				<td><input type="text" name="bugname"></td>
			</tr>
			<tr>
				<td>Enter Bug Description</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>Enter Tester Id</td>
				<td><input type="text" name="testerid"></td>
			</tr>
			<tr>
				<td>Enter Open Date</td>
				<td><input type="text" name="opendate"></td>
			</tr>
			<tr>
				<td>Enter Severity Level</td>
				<td><input type="text" name="severitylevel"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Add Bug"></td>
			</tr>
		</table>
	</form>
	<hr>


</body>
</html>