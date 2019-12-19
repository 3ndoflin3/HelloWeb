<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" user-scalable="no" >
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- NO SE PORQUE PERO AUN CAMBIANDO TU NOMBRE EN TODOS SITIOS SE HA QUEDADO EN LA RUTA :( -->
    <base href="/kiryl/">
    <!-- BOOTSTRAP CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
   	<!-- Font awesome cdn -->
   	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" media="all" />
   	<link rel="stylesheet" href="/css/Viper.css" media="all" />
   	
	
	
    <title id = "Title"><%=titulo %></title>
</head>

<body>
	
	<!-- <div class = "row justify-content-center">	
		<nav class = "navcol-lg-6 mt-4 ">
			 class="bg-secondary mb-3"
	            <a href="libro">Inicio</a>
	            <a href = "jsp/formulario.jsp">Registrar libro</a>
			
		</nav>
	</div> -->
	
	
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Libros</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="true" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="navbar-collapse collapse show" id="navbarSupportedContent" style="">
    <ul class="navbar-nav mr-auto">
      
      <li class="nav-item">
        <a class="nav-link" href="jsp/login.jsp">Login</a>
      </li>
      <li><a href="jsp/formulario.jsp" class="nav-link ">A�adir libro</a></li>
      
      
    </ul>
   
  </div>
</nav>
	
	
<main>