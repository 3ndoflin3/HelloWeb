<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<title>Insert title here</title>

<style>
	.login-container{
		margin-top: 25vh;
		margin-left: 15vw;
		border: 2px solid black;
		width: 80vw;
		
	}

</style>



</head>
<body>
	
	
	
		
		
		
		
		
		
	




<div class="container login-container align-items-center">
            <div class="row ">
                <div class="col-md-6 login-form-1">
                    <h3>Login para solo Servlet</h3>
                    <form action ="/helloweb/ejemplo1" method = "post">
                        <div class="form-group">
                            <input type="text" name ="nombre" placeholder ="Nombre"><br><br>
                        </div>
                        <div class="form-group">
                            <input type="text" name ="pass" placeholder ="Contrasena"><br><br>
                        </div>
                        <div class="form-group">
                            <input type ="submit" class ="btn" value ="Ejemplo Servlet">
                        </div>
                        
                    </form>
                </div>
                <div class="col-md-6 login-form-2">
                    <h3>Login for Form 2</h3>
                    <form action ="/helloweb/ejemplo2" method = "post">
                        <div class="form-group">
                            <input type="text" name ="nombre" placeholder ="Nombre"><br><br>
                        </div>
                        <div class="form-group">
                            <input type="text" name ="pass" placeholder ="Contrasena"><br><br>
                        </div>
                        <div class="form-group">
                            <input type ="submit" class ="btn" value ="Ejemplo Servlet + JSP">
                        </div>
                       
                    </form>
                </div>
                
            </div>
        </div>



	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
	 
</body>
</html>
