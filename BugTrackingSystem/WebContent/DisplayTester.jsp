<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tester Information</title>
</head>
<h1>Tester Details</h1>
	<hr>
	<form action="displayTester" method="POST">
			
			<table>
			<tr>
				<td>Enter email id</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Enter password</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Display Tester"></td>
			</tr>
		</table>
	</form>
	<hr>
	
	
	

<body>
	<table>
		<tr>
			<td>Email</td>
			<td><c:out value="${testeruser.email}" /></td>
		</tr>
		<tr>
			<td>Username</td>
			<td><c:out value="${testeruser.name}" /></td>
		</tr>		
	</table>
	
	<%
	List<Bugs> buglist = (List<Bugs>) session.getAttribute("buglist");
	if (buglist.size() > 0) {
	%>
	<table>
		<thead>
			<tr>
				<th>BugID</th>
			</tr>
			<% for(Bugs b:buglist){%>
			<tr>
				<td><%=b.getId() %></td>
			</tr>
			<%} %>
		</thead>
	</table>
	<%
	}
	%>
	<a href="AddBug.jsp ">Report new bug</a>
</body>
</html>