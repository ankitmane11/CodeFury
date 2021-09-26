<%@ page language="java" import="java.util.List, com.app.beans.Bugs" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DevloperP1</title>
     <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

     <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <link rel="stylesheet" href="otherstyle.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<head>
 <div class="navbar">
       
        <a href="#"><i class="fa fa-fw fa-user"></i> Username</a> 
        <a href="#"><i class="fa fa-fw fa-envelope"></i> email</a> 
        <a href="#"><i class="fa fa-fw fa-power-off"></i> Logout</a>
      </div>

<body>
<div class="bg-image">
<div class="table-box">
        <div class="table-row table-head">
            <div class="table-cell first-cell">
                <p>BUG ID</p>
            </div>
            <div class="table-cell">
                <p>BUG DETAILS</p>
            </div>
            <div class="table-cell last-cell">
                <p>ASSIGN/CLOSE</p>
            </div> 
        </div>

		<%
		List<Bugs> blist = (List<Bugs>)request.getAttribute("bugs");
	     for(Bugs b: blist){
		%>
        <div class="table-row">
            <div class="table-cell first-cell">
            <% session.setAttribute("bugId", b.getId()); %>
                <p><%= b.getId()  %></p>
            </div>
            <div class="table-cell">
                <p><%= b.getTitle() %> : <%=b.getDescription() %></p>
            </div>
            <div class="table-cell last-cell">
            	<form method="post" action="closeBug">
                	<input id="bugId" type="submit" name="CLOSE BUG" value="CLOSE BUG">
                </form>
                <form method="post" action="assignBug">
                	<a href="assign.jsp"><input id="assignbug" type="submit" name="ASSIGN BUG" value="ASSIGN BUG"></a>
                </form>
            </div>
        </div>      
		<%} %>
</div>   
</div>

</body>
</html>