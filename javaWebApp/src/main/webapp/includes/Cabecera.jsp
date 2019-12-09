<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" user-scalable="no" >
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="/helloweb/">
    
    <link rel="stylesheet" href="css/stylesTabla.css?time=<%System.currentTimeMillis();%>">
	<!-- <link rel="stylesheet" href="ejercicios/css/responsivemenu.css" media="all" /> -->
	
	
    <title id = "Title">Inicio | <%=titulo %></title>
</head>

<body>

	<section id="usuario">
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
		
	
	</section>

	<!-- <nav class="topnav" id="myTopnav">
		<a href="#home" class="active">Home</a> <a href="#news">News</a> <a
			href="#contact">Contact</a>
		<div class="dropdown">
			<button class="dropbtn">
				Dropdown <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="#">Link 1</a> <a href="#">Link 2</a> <a href="#">Link 3</a>
			</div>
		</div>
		<a href="#about">About</a> <a href="javascript:void(0);"
			style="font-size: 15px;" class="icon" onclick="myFunction()">&#9776;</a>
	</nav>

	<script>
		function myFunction() {
			var x = document.getElementById("myTopnav");
			if (x.className === "topnav") {
				x.className += " responsive";
			} else {
				x.className = "topnav";
			}
		}
	</script> -->


	
	<div class = "nav-wrapper">	
		<nav>
			
				<a href="index.jsp">Index</a>
				<a href ="jsp/login.jsp">Login </a>
				<a href="ejercicios/howto/top-menu-responsive.jsp">Menu responsive</a>
				<a href  ="jsp/calculadora.jsp">Calculadora </a>
				<a href = "https://es.wallapop.com/search?keywords=cafetera&min_sale_price=20&max_sale_price=50">Wallapop.</a>
				<a href = "ejercicios/css/flexbox.jsp">Enlace para flexbox</a>
				<a href="html/animaciones.html">Animacion</a>
				<a href = "http://www.indicedejuegos.com/">Juegos de mi epoca</a>
	            <a href = "html/auxiliar.html">Viaja a la otra pagina</a>
	            <a href="js/datatable.jsp">Datatable</a>
	            <a href = "ejercicios/css/mediaqueries.jsp">Media Queries</a>
	            <a href = "doge">Perros</a>
	            <a href="doge2">Perros JSTL</a>
			
		</nav>
	</div>
	
<main>