<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
   	 <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
   	<link rel="stylesheet" href="/css/Viper.css" media="all" />
	
	
    <title id = "Title"><%=titulo %></title>
</head>

<body>
	
	<div class = "row justify-content-center">	
		<nav class = "col-lg-6 mt-4 ">
			<!--  class="bg-secondary mb-3"-->
	            <a href="index.jsp">Inicio</a>
				<a href="libro">Listar Libros</a>
	            <a href = "jsp/formulario.jsp">Registrar libro</a>
			
		</nav>
	</div>
	
<main>