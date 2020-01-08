<%String titulo = "Listar libros"; %>
<%@include file ="../includes/Cabecera.jsp" %>



<p>Vamos a listar los libros en la BBDD</p>

<p>${mensaje}</p>


	<c:forEach items="${listaLibros}" var="libro">
	
   		  <li class ="list-inline-item w-25 text-center">
   		  <p><img src="${libro.enlace}" alt="imagen" class="h-50 w-50 "/></p>
   		  <p class="w-100 text-center">ID: ${libro.id} Nombre: ${libro.nombre}</p>
   		   Precio: <fmt:formatNumber pattern="#,##0.00" value="${libro.precio} "/>&#8364; Descuento: ${libro.descuento}
   		 
  		  </li> 
  		  
	</c:forEach>


<jsp:include page ="../includes/Pie.jsp">
