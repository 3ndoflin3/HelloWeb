<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ipartek.formacion.modelo.pojo.Producto" %>		
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body id="top">
<h1>Visualizar Productos</h1>

        
    <nav class="site-header sticky-top py-1">
        <div class="container d-flex flex-column flex-md-row justify-content-between">
            <a class="py-2" href="index.html">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mx-auto" role="img" viewBox="0 0 24 24" focusable="false"><title>Product</title><circle cx="12" cy="12" r="10"/><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/></svg>
            </a>
            <a class="py-2 d-none d-md-inline-block" href="login.html">Login</a>
            <a class="py-2 d-none d-md-inline-block" href="tabla.html">Tabla</a>
            <a class="py-2 d-none d-md-inline-block" href="formulario.html">Formulario</a>            
           
        </div>
    </nav>

    <main class="container">

		${mensaje}
 	<c:forEach items="${listaProductos}" var="producto">

        <div class="row contenedor-productos">

            <div class="col">

                <!-- producto -->
                <div class="producto">
                    <span class="descuento">${producto.descuento}</span>
                    <img src="${producto.imagen}" alt="imagen de ${producto.nombre}">

                    <div class="body">
                        <p>
                        <!-- Llama al metodo getPrecioDescuento() en el POJO -->
                            <span class="precio-descuento"><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" type="currency" currencySymbol="$" value="${producto.PrecioDescuento}" /></span>
                            <span class="precio-original"><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" type="currency" currencySymbol="$" value="${producto.precio}" /></span>
                        </p>
                        <p class="text-muted precio-unidad">
                        (     <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" type="currency" currencySymbol="$" value="${producto.precio}" />
                        / litro)
                        </p>
                        <p class="descripcion">${producto.descripcion }</p>
                    </div>

                    <div class="botones">
                        <button class="minus">-</button>
                        <input type="text" value="1">
                        <button class="plus">+</button>
                    </div>

                    <button class="carro">añadir al carro</button>

                </div>
                <!-- /.producto -->

            </div>            

                     
        </div> <!-- END OF row contenedor-productos -->



   

    
    </c:forEach>
    </main>
	  <div class="footer-wrapper">
        <footer class="container py-5">
            <div class="row">
                <div class="col-12 col-md">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mb-2" role="img" viewBox="0 0 24 24" focusable="false"><title>Product</title><circle cx="12" cy="12" r="10"/><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/></svg>
                    <small class="d-block mb-3 text-muted">&copy; 2019</small>
                </div>
    
                <div class="col-6 col-md offset-6">
                    <h5>Enlaces de Interes</h5>
                    <ul class="list-unstyled text-small">
                        <li><a class="text-muted" href="politica-privacidad.html">Politica Privacidad</a></li>
                        <li><a class="text-muted" href="localizacion.html">Localización</a></li>
                        <li><a class="text-muted" href="contacto.html">Contacto</a></li>                    
                    </ul>
                </div>

            </div>    
        </footer>
    </div>    
	 
	<a id="btn-top" href="#top" class="btn btn-primary">top</a>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    



</body>
</html>