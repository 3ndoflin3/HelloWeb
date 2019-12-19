<%String titulo = "Inicio | Privado"; %>
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
		<div class="row">
			<div class="col mx-4">
				<!-- <div class="row"> -->
				<p>Tenemos estos libros: </p>
				<ul class ="list-group m-4 row">
					<c:forEach items="${listaLibros}" var="libro">
					
		     		  <li class ="list-group-item col">ID: ${libro.id} Nombre: ${libro.nombre} Precio:
			    		  <fmt:formatNumber pattern="#,##0.00" value="${libro.precio} "/>&#8364; Descuento: ${libro.descuento}
			    		  <a href=""><i class="fa fa-trash r-1" aria-hidden="true"> </i></a> <a href=""><i class="fa fa-pencil" aria-hidden="true"></i></a>
			    		  <!-- POSICIONAR LOS ICONOS COMO EL BOTON DE SUBIR (Y YA QUE ESTAMOS HACEMOS EL BOTON PARA SUBIR) -->
		    		  </li> 
					</c:forEach>
				</ul>
				<!-- </div> --><!-- END OF 2ND ROW -->
			</div> <!-- END OF 1ST COL -->
		</div> <!-- END OF 1ST ROW -->
	</div> <!-- END OF CONTAINER -->



<jsp:include page="includes/Pie.jsp" /> 