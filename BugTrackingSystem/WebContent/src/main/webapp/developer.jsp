<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
    
    <link rel="stylesheet" href="style.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
     

    <div class="navbar">
       
        <a href="#"><i class="fa fa-fw fa-user"></i> Username</a> 
        <a href="#"><i class="fa fa-fw fa-envelope"></i> email</a> 
        <a href="#"><i class="fa fa-fw fa-power-off"></i> Logout</a>
      </div>

<div class="table-box">
        <div class="table-row table-head">
            <div class="table-cell first-cell">
                <p>Index</p>
            </div>
            <div class="table-cell">
                <p>Project-ID</p>
            </div>
            <div class="table-cell last-cell">
                <p>Project-Name</p>
            </div> 
        </div>


        


        <div class="table-row">
            <div class="table-cell first-cell">
                <p>1</p>
            </div>
            <div class="table-cell">
                <p>5672</p>
            </div>
            <div class="table-cell last-cell">
                <a href="ABC.html">ABC</a>
            </div>
        </div>

        <div class="table-row">
            <div class="table-cell first-cell">
                <p>2</p>
            </div>
            <div class="table-cell">
                <p>4662</p>
            </div>
            <div class="table-cell last-cell">
                <a href="XYZ.html">XYZ</a>
            </div>
        </div>

        <div class="table-row">
            <div class="table-cell first-cell">
                <p>3</p>
            </div>
            <div class="table-cell">
                <p>1234</p>
            </div>
            <div class="table-cell last-cell">
                <a href="LMN.html">LMN</a>
            </div>
        </div>

         

</div>   
  
<div class = "container">
    
    <button class="btn btn-success" data-target="#mymodel" data-toggle="modal">CLOSE BUG</button>

     <div class="modal fade" id ="mymodel">
         <div class="modal-dialog modal-dialog-centered">
             <div class="modal-content">

                 <div class="modal-header">
                     <h3 class = "text-primary">Enter Bug details!</h3>
                     <button type="button" class="close" data-dismiss="modal"> &times;</button>
                 </div>

                 <div class="modal-body">
                     <form>
                         <div class="form-group">
                             <label>Project-Name</label>
                             <input type="text" name ="" id="pname" class="form-control"> 
                         </div>

                         <div class="form-group">
                            <label>Bug-Title</label>
                            <input type="text" name ="" id="title" class="form-control"> 
                        </div>

                        <div class="form-group">
                            <label>Bug-ID</label>
                            <input type="text" name ="" id="bugid" class="form-control"> 
                        </div>

                        
                     </form>
                 </div>

               <!--<div class="modal-footer justify-content-center">---->  
                     <div class="modal-footer">
                     <button class="btn btn-danger " data-dismiss ="modal">Submit</button>
                 </div>

             </div>
         </div>
     </div>





</div>
     
     


</body>
</html>