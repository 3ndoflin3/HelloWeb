<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" user-scalable="no" >
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	
   <!--  <base href="/helloweb/"> -->
    <base href="${pageContext.request.contextPath}/"></base>
    <link rel="stylesheet" href="css/stylesTabla.css?time=<%System.currentTimeMillis();%>">
	<!-- <link rel="stylesheet" href="ejercicios/css/responsivemenu.css" media="all" /> -->
	<!-- Latest compiled and minified CSS -->
	<style>
		a{
		color: black;
		}
	</style>
	
    <title id = "Title">Inicio | <%=titulo %></title>
</head>

<body>
	
	<%-- 
	<c:if test="${ empty usuarioLogeado }">
		</c:if>
		usarlo en vez de el if 
		 --%>
		<%-- 
		<c:if test="${not empty usuarioLogeado }">
		href="seguridad/productos?accion=listar" los proximos parametros irian separados con &, el primero siempre con ?
												 se usa para mandar diferentes parametros al controlador
			</c:if>
		usarlo en vez de el if 
		 --%>
		<section id="usuario">
		
		
		<c:if test="${ empty usuarioLogeado }">
			</c:if>
			
			
			<c:if test="${not empty usuarioLogeado }">
			
			<a href="seguridad/productos?accion=listar">Listar</a> 
			<a href="seguridad/productos?accion=tabla">Tabla</a> 
			<!-- <a href="seguridad/productos?accion=listar"></a> --> 
								
			</c:if>
			
		
			<%-- <%
				String usuario = (String)session.getAttribute("usuarioLogeado");
				String idioma = (String)session.getAttribute("idioma");
			
				
				if(usuario == null || idioma == null || session == null){ %>
					<p>Por favor<a href="login"> inicia sesion</a></p>
				<%}else{ %>
	
					<p>Usuario: <%=usuario %></p>
					<p>Idioma: <%=idioma %> </p>
					<p><a href="logout">Cerrar sesion</a></p>
					
				<%}%>
		TODO WITH JSLT 
		<c:if test="${not empty usuarioLogeado}">
			<p>El usuario logeado es: ${usuarioLogeado}</p>
		</c:if>	
		 --%>
			<p>Usuarios Conectados ${applicationScope.numeroUsuariosConectados }</p>
			<p>Intentos de inicio de sesion fallidos ${applicationScope.numeroIntentosFallidos}</p>
		
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
	            <a href="jsp/producto.jsp">Add Producto</a>
	            <a href="jsp/visualizar-productos.jsp">Ver Productos</a>
			
		</nav>
	</div>
	
<main class="container">

	<c:if test="${not empty mensajeAlerta }">
		<div class="alert alert-${mensajeAlerta.tipo} alert-dismissible fade show mt-3" role ="alert">
		${mensajeAlerta.texto }
		<button type="button" data-dismiss="alert" class="close" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		</div>
	</c:if>
