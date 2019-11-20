<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<h1>Has iniciado sesion con exito</h1>
		
		
	<% String recuerdame = String.valueOf(request.getAttribute("recuerdame"));
		%>
		
		<p>${recuerdame} </p>
			
	</body>
</html>

	