<%String titulo = "formulario"; %>
<%@include file ="includes/Cabecera.jsp" %>



	<!-- Bootstrap 4 cheatsheets 
	
	https://www.creative-tim.com/cheatsheet/bootstrap4/
	https://hackerthemes.com/bootstrap-cheatsheet/
	https://bootstrapcreative.com/resources/bootstrap-4-css-classes-index/
	https://www.cheatography.com/kemmojoo/cheat-sheets/bootstrap-v4/
	https://hackerthemes.com/bootstrap-cheatsheet/
	
	
	
	 -->
	<!-- ID nombre precio descuento -->
	<div class="container">
		<p>Tenemos estos libros: </p>
			<ul class ="list-group m-4">
				<c:forEach items="${listaLibros}" var="libro">
					
		    		<li class ="list-group-item">ID: ${libro.id} Nombre: ${libro.nombre} Precio:
		    		 <fmt:formatNumber pattern="#,##0.00" value="${libro.precio} "/>&#8364; Descuento: ${libro.descuento}
		    		  <a href=""><i class="fa fa-trash" aria-hidden="true"> </i></a> <a href=""><i class="fa fa-pencil" aria-hidden="true"></i></a>
		    		  </li> 
				</c:forEach>
			</ul>
	</div>



<jsp:include page="includes/Pie.jsp" /> 