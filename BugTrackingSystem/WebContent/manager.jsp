<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
        <link rel="stylesheet" href="css/Loginstyle.css">
        <link rel="stylesheet" href="css/Extrastyle.css">
    
        <!-- This is just a font that we'll be using. You can remove lines 12-14 if you don't want to use Poppins -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
        <title>Home Page</title>
        

        
        <script>
            
            function addRow()
            {
                
                // get input values
                var pname = document.getElementById('pname').value;
                 var startdate = document.getElementById('startdate').value;
                  var pmanager = document.getElementById('pmanager').value;
                  var emp = document.getElementById('emp').value;
                  var details = document.getElementById('details').value;
                  
                  // get the html table
                  // 0 = the first table
                  var table = document.getElementsByTagName('table')[0];
                  
                  // add new empty row to the table
                  // 0 = in the top 
                  // table.rows.length = the end
                  // table.rows.length/2+1 = the center
                  var newRow = table.insertRow(table.rows.length/2+1);
                  
                  // add cells to the row
                  var cel1 = newRow.insertCell(0);
                  var cel2 = newRow.insertCell(1);
                  var cel3 = newRow.insertCell(2);
                  var cel4 = newRow.insertCell(3);
                  var cel5 = newRow.insertCell(4);
                  
                  // add values to the cells
                  cel1.innerHTML = pname;
                  cel2.innerHTML = startdate;
                  cel3.innerHTML = pmanager;
                  cel4.innerHTML = emp;
                  cel5.innerHTML= details;
            }
            
        </script>
        
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
                
                  
                    <li><span><a href="userinfo.html" >User Information</a></span></li>
                <li><span><a href="projectname.html">Project Name</a></span></li>
                <li><span><a href="mainmanager.html">Manager Home Page</a></span></li>
                <li><span ><a href="manager.html" class="button">Home</a></span></li>
                <li><span ><a href="ProjectList.html">Add Project</a></span></li>
            
            
                
                <!-- On the line above, remove the class="button" if you don't want the final
                element to be a button -->
            </nav>
        </div>
    </header>
    <body>

    <!--
        <form>
            <table>
                
                <tr>
                    <td>
        Project Name: <input type="text" name="pname" id="pname" >
        </td>
    </tr>
    <tr>
        <td>
        Start Date: <input type="text" name="startdate" id="startdate" />
    </td>
    </tr>
    <tr>
        <td>
        Project Manager: <input type="text" name="pmanager" id="pmanager" />
    </td>
    </tr>
    <tr>
        <td>
        Employee name: <input type="text" name="emp" id="emp" />
    </td>
    </tr>
    <tr>
        <td>
        Details: <input type="text" name="details" id="details" />
    </td>
    </tr>
        
    </table>
    </form>
    <button onclick="addRow();">Add Project</button><br/><br/>
    </form>
    -->
    <div class="bg-image">
        <table border="10px"style="margin-left:250px; margin-top:150px;">
            
            <tr>
                <th style="padding:10px; font-size:20px ;">Project Name</th>
                <th style="padding:10px; font-size:20px ;">Start Date</th>
                <th style="padding:10px; font-size:20px ;">Project Manger</th>
                <th style="padding:10px; font-size:20px ;">Employee name</th>
                <th style="padding:10px; font-size:20px ;">Age</th>
            </tr>
            <tr>
                
                <td id="projectname"style="padding:10px; font-size:40px ;">1 :</td>
                <td id="startdate" style="padding:10px; font-size:40px;">2</td>
                <td id="ProjectManger"style="padding:10px; font-size:40px ;">Test Values :</td>
                <td id="Employeename" style="padding:10px; font-size:40px;">4</td>
                <td id="Age"style="padding:10px; font-size:40px ;">Test Values :</td>
                
         

        </table>
    </div>
    </body>

</html>