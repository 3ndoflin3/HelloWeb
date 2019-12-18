<%String titulo = "formulario"; %>
<%@include file ="../includes/Cabecera.jsp" %>


<p>Visualizar libros (Deberia de ser en una lista)</p>
	
	<!-- ID nombre precio descuento -->
	
	<ul>
		<c:forEach items="${listaLibros}" var="libro">
    		<li>ID: ${libro.id} Nombre: ${libro.nombre} Precio: ${libro.precio} Descuento: ${libro.descuento} </li>
		</c:forEach>
	</ul>
	



<jsp:include page="../includes/Pie.jsp" /> 