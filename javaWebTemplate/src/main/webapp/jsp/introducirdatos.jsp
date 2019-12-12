<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<base href="${pageContext.request.contextPath}/"></base>
<title>Insert title here</title>
</head>
<body>
	
	<form action="validar" method="post">
	
		<div class="form-group">
			<label for="nombre">Nombre: </label>
			<input type="text" name ="nombre" id ="nombre" value ="${nombre}"/>
		</div>
		
		<div class="form-group">
			<label for="email">Email: </label>
			<input type="text" name="email" id="email" />
		</div>
		
		<div class="form-group">
			<label for="deportes">Deportes: </label>
			<input type="text" />
		</div>
		
		<div class="form-group">
			
			<label for="Skate">
				<input type="checkbox" name="deporte" value ="skate"/> Skate 
			</label>
			
			<label for="Planchado extremo">
				<input type="checkbox" name="deporte" value ="planchado extremo"/> Planchado extremo
			</label>	
				
			<label for="Chess boxing">	
				<input type="checkbox" name="deporte" value ="chess boxing"/> Chess boxing
			</label>
				
			<label for="Jugger">
				<input type="checkbox" name="deporte" value ="jugger"/> Jugger
			</label>
			<br />
			<input type="submit" value="Registrarse" />
		</div>
		
	</form>
	
	
	
	<% String[] keyDeportes = request.getAttribute("keyDeportes");
	
	%>
	

	
	 
<%-- 	 <c:forEach items="${deporte}" var="dep">
		<input type="checkbox" name="deporte" value ="${dep.key} "/> ${dep.name}
		<br />
	</c:forEach>  --%>
	

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> 

</body>
</html>