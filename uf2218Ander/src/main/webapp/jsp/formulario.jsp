<%String titulo = "Listar libros"; %>
<%@include file ="../includes/Cabecera.jsp" %>
<%-- <jsp:include page="includes/Cabecera.jsp" /> --%>

<br /><br />
<div class="container">
	<div class="row justify-content-center">
		<div class="col-lg-6">
			<form action="libro" method="post">
			 ${mensaje}
				<fieldset>
					<legend>Crear Libro</legend>
					
					<label for="nombre" >Nombre: </label>
					<input class="ml-3" type="text" name ="nombre" placeholder="entre 2 y 150 caracteres" value="${nombre}" />
					<br />
					
					<label class ="mr-2" for="precio" >Precio: </label>
					<input class="ml-4" type="text" name ="precio" placeholder="precio ej.: 3.000,42 " value="${precio}"/>
					<br />
					
					<label for="descuento" >Descuento: </label>
					<input class="ml-1" type="text" name ="descuento" placeholder="numero entre 0 y 100" value="${descuento}"/>
					<br />
					
				</fieldset>
				
				<input class="mt-2" type="submit" value="Registrar" />
				
			</form>
		</div> <!-- END OF COL -->
	</div> <!-- END OF ROW -->
</div> <!-- END OF CONTAINER -->
	
<jsp:include page="../includes/Pie.jsp" />

