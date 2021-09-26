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
                
                  
                <li><span><a href="userinfo.jsp" >User Information</a></span></li>
                <li><span><a href="projectname.jsp">Project Name</a></span></li>
                <li><span><a href="mainmanager.jsp">Manager Home Page</a></span></li>
                <li><span ><a href="manager.jsp" >Home</a></span></li>
                <li><span ><a href="ProjectList.jsp" class="button">Add Project</a></span></li>
            
                
                <!-- On the line above, remove the class="button" if you don't want the final
                element to be a button -->
            </nav>
        </div>
    </header>
    <body>

        <div class="bg-image">
        
        
                        
                        
                        <form name="Project-form" onsubmit="return validateData()">
                
                        <div>
                            <table>
                                <h3 style="text-align:center">Project Assignemnet</h3>
                                <tr> 
                                    <td>
                                    <label>Project Name:</label>
                                    </td>
                                    <td>
                                    <input type="text" placeholder="Enter ProjectName" name="projectname" required="required"> 
                                </td>
                                </tr>
                               
                                <tr>
                                    <td>
                                    <label>Details:</label>
                                </td>
                                <td>
                                    <input type="text" placeholder="Details" name="details" required="required"> 
                                </td>
                                </tr>
                                <tr>
                                    <td>
                                    <label>Project Manager:</label>
                                </td>
                                <td>
                                    <input type="text" placeholder="Project" name="projectmanager" required="required"> 
                                </td>
                                </tr>
                                <tr>
                                    <td>
                                    <label>Employee Name:</label>
                                </td>
                                <td>
                                    <input type="text" placeholder="EmployeeName" name="employeeName" required="required"> 
                                </td>
                                </tr>
                                <tr>
                                    <td>
                                    <label>Start Date:</label>
                                </td>
                                <td>
                                    <input type="date" placeholder="Enter" name="startdate" required="required"> 
                                </td>
                                </tr>
                                
                                <tr>
                                    <br>
                                    <td style="column-span: all;">
                                <button type="submit" value="addproject" style="margin-left: 95px;margin-top: 35px;">Add Project</button>
                            </td>
                            </tr>
                            </table>
                            
                        </div>
                    </form>
                    
                  
   
    </form>
</div>

<body>
</html>