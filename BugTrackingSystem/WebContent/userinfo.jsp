<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Information</title>
</head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- This is the style for the header -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/Loginstyle.css">
<link rel="stylesheet" href="css/Extrastyle.css">

<!-- This is just a font that we'll be using. You can remove lines 12-14 if you don't want to use Poppins -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
<title>Home Page</title>
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
            
              
                <ul>
				  <li><span><a href="userinfo.html" >User Information</a></span></li>
                <li><span><a href="projectname.html" class="button">Project Name</a></span></li>
                <li><span><a href="mainmanager.html">Manager Home Page</a></span></li>
                <li><span ><a href="manager.html">Home</a></span></li>
                <li><span ><a href="ProjectList.html" >Add Project</a></span></li>
			</ul>
            
            
            <!-- On the line above, remove the class="button" if you don't want the final
            element to be a button -->
        </nav>
    </div>
</header>
<body>
    <div class="bg-image">
        <table border="10px" style="margin-left:450px;margin-top:150px;">
            
            <tr>
               <td style="padding:10px; font-size:40px ;">Email :</td>
               <td id="email" style="padding:10px; font-size:40px;"></td>
             </tr>
             <tr>
                <td style="padding:10px; font-size:40px;">Role :</td>
                <td id="role" style="padding:10px; font-size:40px;">Test Value</td>
             </tr>
             <tr>
                <td style="padding:10px; font-size:40px;">Login Details :</td>
                <td id="login" style="padding:10px; font-size:40px;"></td>
             </tr>
                  
        </table>
    </div>

</body>
</html>