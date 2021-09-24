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
        <link rel="preconnect" href="https://fonts.gstatic.com" >
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/Loginstyle.css">
        <title>Import</title>
        
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

                <li><span><a class="button">Import</a></span></li>
                <li><span><a href="Register.html">Register</a></span></li>
                <li><span><a href="Login.html">Login</a></span></li>
                <li><span><a href="Index.html">Home</a></span></li>

                <!-- On the line above, remove the class="button" if you don't want the final
                    element to be a button -->
            </nav>
        </div>
    </header>


    <body>

        <div class="bg-image">

            <div>
                <form id="import">
                    <table>
                        <tr>
                            <h1 style="text-align:center; font-weight:bolder;">Choose A JSON File </h1><br><br><br>
                            <td>
                                <label id="file">
                                    <h2 style="margin-left:30px;">Click here to trigger JSON file uploader!<h2>
                                        <input type="file"  accept=".json">
                                </label>

                            </td>
                        </tr>
                        <tr>
                            <td><label style="color: red" id="err"></label><label style="color: green" id="succ"></label></td>
                        </tr>
                        <tr>
                            
                            <td><br><br><br><button type="button">Submit</button></td>
                        </tr>

                    </table>
                </form>
            </div>

            <script src="filescript.js"></script>

   

    <div id="error"></div>
</body>

</html>