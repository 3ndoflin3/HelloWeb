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
		
		
	<% String remember = String.valueOf(request.getAttribute("remember"));
		if(remember.equals("on")){
			%>		<p>Tienes la sesion guardada</p>
			
	<%	}else {%>
				<p>No tienes la sesion guardada</p>
	
	<%} %>
			
	</body>
</html>

	