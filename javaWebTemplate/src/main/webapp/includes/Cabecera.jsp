<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" user-scalable="no" >
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="/javaWebTemplate/">
    	 <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
   	<link rel="stylesheet" href="/css/Viper.css" media="all" />
	
	
    <title id = "Title"><%=titulo %></title>
</head>

<body>

	<%-- <section id="usuario">
		<%
			String usuario = (String)session.getAttribute("usuarioLogeado");
			String idioma = (String)session.getAttribute("idioma");
		
			
			if(usuario == null || idioma == null || session == null){ %>
				<p>Por favor<a href="jsp/login.jsp"> inicia sesion</a></p>
			<%}else{ %>

				<p>Usuario: <%=usuario %></p>
				<p>Idioma: <%=idioma %> </p>
				<p><a href="logout">Cerrar sesion</a></p>
				
			<%}%>
		
	
	</section> --%>

	


	
	<div class = "row justify-content-center">	
		<nav class = "col-lg-6 mt-4">
			<c:if test="${not isLogged}">
					<a href ="jsp/login.jsp">Login </a>
			</c:if>
			
			<c:if test="${isLogged}">
					<a href ="jsp/logout.jsp">Logout </a>
			</c:if>
			
			
				<a href="html/animaciones.html">Animacion</a>
				<a href = "http://www.indicedejuegos.com/">Juegos de mi epoca</a>
	            <a href = "jsp/formulario.jsp">Registrar producto</a>
	            <a href="js/datatable.jsp">Datatable</a>
	            <a href = "ejercicios/css/mediaqueries.jsp">Media Queries</a>
			
		</nav>
	</div>
	
<main>