<%String titulo = "formulario"; %>
<%@include file ="../includes/Cabecera.jsp" %>
<%-- <jsp:include page="includes/Cabecera.jsp" /> --%>

<br /><br />
<div class="container">
	<div class="row justify-content-center">
		<div class="col-lg-6">
			<form action="libro" method="post">
				<fieldset>
					<legend>Libros</legend>
					
					<label for="id" >ID: </label>
					<input type="number" name ="id" placeholder="id" />
					<br />
					
					<label for="nombre" >Nombre: </label>
					<input type="text" name ="nombre" placeholder="nombre" />
					<br />
					
					<label for="precio" >Precio: </label>
					<input type="number" name ="precio" placeholder="precio en euros suprimo" />
					<br />
					
					<label for="descuento" >Descuento: </label>
					<input type="number" name ="descuento" placeholder="descuento en porcentaje" />
					<br />
					
				</fieldset>
				
				<input type="submit" value="Registrar" />
				
			</form>
		</div> <!-- END OF COL -->
	</div> <!-- END OF ROW -->
</div> <!-- END OF CONTAINER -->
	
<jsp:include page="../includes/Pie.jsp" />

