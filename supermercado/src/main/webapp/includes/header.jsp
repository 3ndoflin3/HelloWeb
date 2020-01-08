<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="es_ES"/>

<%@ page contentType="text/html; charset=UTF-8" %>


<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Ander Uraga">
    <title>Supermercado</title>
    
   <base href="/supermecado/" >

   <!-- Bootstrap core CSS -->
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

	<!-- datatables -->
	<link href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"  rel="stylesheet">

   <!-- nuestro css -->
   <link rel="stylesheet" href="css/custom.css">

  </head>
  <body id="top">
  <div class="bs-example">
    <ul class="nav nav-pills mb-5">
        <li class="nav-item">
            <a href="#" class="nav-link active">Home</a>
        </li>
        <li class="nav-item">
            <a href="#" class="nav-link">Profile</a>
        </li>
        
        
        <c:if test="${empty usuarioLogeado }" >
            	<li class="nav-item">
            		<a class="py-2 d-none d-md-inline-block" href="login.jsp">Login</a>
            	</li>
        </c:if>
       
        <c:if test="${not empty usuarioLogeado }" >
         	
        <!--   <a class="py-2 d-none d-md-inline-block" href="seguridad/productos?accion=listar">Tabla</a>
            	<a class="py-2 d-none d-md-inline-block" href="seguridad/productos?accion=formulario">Formulario</a>
            	
		  -->
	 		<c:if test="${usuarioLogeado.rol.id eq rol[1]}" >
         		<!-- <p>el id es 2</p> --> <!-- User -->
         		<li class="nav-item dropdown">
		            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Productos</a>
		            <div class="dropdown-menu">
		                <a class="dropdown-item" href="mipanel/productos?accion=listar">Todos</a>
		            	<a class="dropdown-item" href="mipanel/productos?accion=formulario">Nuevo</a>
		            	
		                <div class="dropdown-divider"></div>
		                <a href="#"class="dropdown-item">Trash</a>
		            </div>
		        </li>
         	</c:if>
         	
         	
         	<c:if test="${usuarioLogeado.rol.id eq rol[0]}" >
         		<p>el id es 1</p> <!-- Admin -->
         		
   			  	<li class="nav-item dropdown">
		            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Productos</a>
		            <div class="dropdown-menu">
		                <a class="dropdown-item" href="seguridad/productos?accion=listar">Todos</a>
		            	<a class="dropdown-item" href="seguridad/productos?accion=formulario">Nuevo</a>
		            	
		                <div class="dropdown-divider"></div>
		                <a href="#"class="dropdown-item">Trash</a>
		            </div>
		        </li>
         		
         		 <li class="nav-item dropdown">
		            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Usuarios</a>
		            <div class="dropdown-menu">
		                <a class="dropdown-item" href="login?accion=listar">Todos</a>
		            	<a class="dropdown-item" href="seguridad/usuarios/formulario.jsp">Nuevo</a>
		            	
		                <div class="dropdown-divider"></div>
		                <a href="#"class="dropdown-item">Trash</a>
		            </div>
		        </li>
				
         	</c:if>
		    
	  	<li class="nav-item dropdown ml-auto">
           <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">${usuarioLogeado.nombre}</a>
           <div class="dropdown-menu dropdown-menu-right">
               <a href="#" class="dropdown-item">Settings</a>
               <div class="dropdown-divider"></div>
               <a class="dropdown-item" href="logout">Cerrar Sessión</a>
           </div>
        </li>
		 

               


         </c:if>	
    </ul>
   
</div>
       
               

    <main class="container">
    
   
	    <c:if test="${not empty mensajeAlerta }">
	    
		    <div class="alert alert-${mensajeAlerta.tipo} alert-dismissible fade show mt-3" role="alert">
			  ${mensajeAlerta.texto}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
		
		</c:if>
    
    