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
					<div class="form-group">
						<label for="nombre" >Nombre: </label>
						<input class="ml-3" type="text" name ="nombre" placeholder="entre 2 y 150 caracteres" value="${nombre}" />
					</div>
					
					<div class="form-group">
						<label class ="mr-2" for="precio" >Precio: </label>
						<input class="ml-4" type="text" name ="precio" placeholder="precio ej.: 3.000,42 " value="${precio}"/>
					</div>
					<div class="form-group">
						<label for="descuento" >Descuento: </label>
						<input class="ml-1" type="text" name ="descuento" placeholder="numero entre 0 y 100" value="${descuento}"/>
					</div>
					
					<div class="form-group">
						<label for="enlace" >Imagen: </label>
						<input class="ml-4" type="text" name ="enlace" placeholder="pega aqui el enlace" value="${descuento}"/>
					</div>
					
					<div class="form-group">
						<label for="autor" class="mr-3">Autor: </label>
						<input class="ml-4" type="text" name ="autor" value="${autor}"/>
					</div>
				</fieldset>
				
				<input class="mt-2" type="submit" value="Registrar" />
				
			</form>
		</div> <!-- END OF COL -->
	</div> <!-- END OF ROW -->
</div> <!-- END OF CONTAINER -->
	
<jsp:include page="../includes/Pie.jsp" />

