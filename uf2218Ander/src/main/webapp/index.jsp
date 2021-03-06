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
				
				<ul class ="list-inline m-4">
					<c:forEach items="${listaLibros}" var="libro">
					
		     		  <li class ="list-inline-item w-25 text-center">
		     		  <p><img src="${libro.enlace}" alt="imagen" class="h-50 w-50 "/></p>
		     		  <p class="w-100 text-center">ID: ${libro.id} Nombre: ${libro.nombre}</p>
		     		   Precio: <fmt:formatNumber pattern="#,##0.00" value="${libro.precio} "/>&#8364; Descuento: ${libro.descuento}
			    		 
		    		  </li> 
		    		  
					</c:forEach>
				</ul>
			</div>
		</div> <!-- END OF 1ST ROW -->
	</div> <!-- END OF CONTAINER -->



<jsp:include page="includes/Pie.jsp" /> 