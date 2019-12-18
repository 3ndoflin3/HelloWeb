<%String titulo = "formulario"; %>
<%@include file ="../includes/Cabecera.jsp" %>



	
	<!-- ID nombre precio descuento -->
	<div class="container">
		<p>Tenemos estos libros: </p>
			<ul class ="list-group m-4">
				<c:forEach items="${listaLibros}" var="libro">
					
		    		<li class ="list-group-item">ID: ${libro.id} Nombre: ${libro.nombre} Precio:
		    		 <fmt:formatNumber pattern="#,##0.00" value="${libro.precio} "/>&#8364; Descuento: ${libro.descuento} </li>
				</c:forEach>
			</ul>
	</div>



<jsp:include page="../includes/Pie.jsp" /> 