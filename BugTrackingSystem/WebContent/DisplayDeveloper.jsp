<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Developer Information</title>
</head>
<h1>Developer Details</h1>
<hr>
<form action="displayDeveloper" method="POST">

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
				value="Display Developer"></td>
		</tr>
	</table>
</form>
<hr>




<body>
	<table>
		<tr>
			<td>Email</td>
			<td><c:out value="${developeruser.email}" /></td>
		</tr>
		<tr>
			<td>Username</td>
			<td><c:out value="${developeruser.name}" /></td>
		</tr>
		<tr>
			<td>Project</td>
			<td><c:out value="${developeruser.name}" /></td>
		</tr>
	</table>

	<%
	List<Bugs> buglist = (List<Bugs>) session.getAttribute("buglist");
	if (buglist.size() > 0) {
	%>
	<table>
		<thead>
			<tr>
				<th>Bug Details</th>
			</tr>
			<% for(Bugs b:buglist){%>
			<tr>
				<td><%=b.getId() %></td>
				<td><%=b.getOpenDate() %></td>
				<td><%=b.getStatus() %></td>
			</tr>
			<%} %>
		</thead>
	</table>
	<%
	}
	%>

	<%
	List<Project> pList = (List<Project>) session.getAttribute("pList");
	if (pList.size() > 0) {
	%>
	<table>
		<thead>
			<tr>
				<th>Project Details</th>
			</tr>
			<% for(Project p:pList){%>
			<tr>
				<td><%=p.getName() %></td>
				<td><%=p.getDescription() %></td>
				<td><%=p.getStartDate() %></td>
				<td><%=p.getStatus() %></td>
			</tr>
			<%} %>
		</thead>
	</table>
	<%
	}
	%>

	<a href="MarkBugForClosing.jsp">Mark bug for closing</a>
</body>
</html>