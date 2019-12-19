<%String titulo = "Inicio"; %>
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
			<div class="col">
			<br />
				<p class ="mt-4">${mensaje}</p>
				<p class="">Tenemos estos libros: </p>
				
				<ul class ="list-group m-4">
					<c:forEach items="${listaLibros}" var="libro">
					
		     		  <li class ="list-group-item">ID: ${libro.id} Nombre: ${libro.nombre} Precio:
			    		  <fmt:formatNumber pattern="#,##0.00" value="${libro.precio} "/>&#8364; Descuento: ${libro.descuento}
			    		 
		    		  </li> 
		    		  
					</c:forEach>
				</ul>
			</div>
		</div> <!-- END OF 1ST ROW -->
	</div> <!-- END OF CONTAINER -->



<jsp:include page="includes/Pie.jsp" /> 