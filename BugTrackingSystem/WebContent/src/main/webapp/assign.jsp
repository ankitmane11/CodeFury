<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title> </title>
        <meta charset="windows-1252">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
        <!-- This is the style for the header -->
        <link rel="stylesheet" href="css/style.css">
        
        <link rel="stylesheet" href="css/Extrastyle.css">
        <link rel="stylesheet" href="css/Loginstyle.css">
    
        <!-- This is just a font that we'll be using. You can remove lines 12-14 if you don't want to use Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
        <title>Home Page</title>
        


<style>
    
    form {  
                
     font-family: 'Exo', sans-serif; 
    border: 4px solid black;
    
    }
</style>



    
    </head>
    <header>
        <div class="inner">
            <div class="logo">
                <div>
                    <!-- The below line can be an image or a h1, either will work -->
                   Bug Tracker
                    <!-- <h1>My Logo</h1> -->
                </div>
            </div>

            <nav>
                <!-- Each of the below lines look complicated. There is a reason for this markup though!
                <li> tag will be the container for the table.
                <span> will be the part that centers the content inside it
                <a> is the actual clickable part -->
                
                  
                <li><span><a href="userinfo.jsp" >User Information</a></span></li>
                <li><span><a href="projectname.jsp">Project Name</a></span></li>
                <li><span><a href="mainmanager.jsp">Manager Home Page</a></span></li>
                <li><span ><a href="manager.jsp" >Home</a></span></li>
                <li><span ><a href="ProjectList.jsp">Add Project</a></span></li>
            
                
                <!-- On the line above, remove the class="button" if you don't want the final
                element to be a button -->
            </nav>
        </div>
    </header>
    <body>

        <div class="bg-image">

	<form action="assignBug" method="post">
		<table style="with: 20%">
		      <h1 style="text-align:center;">ASSIGN DEVELOPER FORM</h1>
			<tr>
				<td> Developer Name </td>
				<td><input type="text" name="developerName" /></td>
			</tr>
			<tr>
				<td> Developer Id </td>
				<td><input id="developerId" type="number" name="developerId" /></td>
			</tr>
			
		</table>
		<button type="submit">Assign</button> 
	</form>
	</div>
</body>
</html>
        
        

</div>

<body>
</html>