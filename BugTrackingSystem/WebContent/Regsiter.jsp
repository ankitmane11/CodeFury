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
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
	<script src="myscript.js"></script>
<title>Login Form</title>
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

                <li><span><a href="Import.html" >Import</a></span></li>
                <li><span><a href="Register.html"class="button">Register</a></span></li>
                <li><span><a href="Login.html">Login</a></span></li>
                <li><span ><a href="home.html">Home</a></span></li>

                <!-- On the line above, remove the class="button" if you don't want the final
                element to be a button -->
            </nav>
        </div>
    </header>


<body>
    
    <div class="bg-image">
        <form name="Login-form" onsubmit="return validateData()">

        <div>
            <table>
                <h3 style="text-align:center">Please Enter Registration Details</h3><br>
                <tr> 
                    <label>Username:</label>
                    <input type="text" placeholder="Enter Username" name="username" required="required"> <br><br>
                </tr>
                <tr>
                    <label>Password:</label>
                    <input type="password" placeholder="Enter Password" name="password" required="required"> <br><br>
                </tr>
                <tr>
                    <label >Role: </label>
                    <select name="cars" id="cars">
                      <option value="Manager">Manger</option>
                      <option value="Developer">Developer</option>
                      <option value="Tester">Tester</option>
                    </select>
                </tr>
                <tr>
                    <button type="submit" value="login">Register</button>
                 
                    <div id="error"></div>
                </tr>
            </table>
        </div>
    </form>
    </div>
    
</body>
</html>