<%String titulo = "formulario"; %>
<%@include file ="../includes/Cabecera.jsp" %>
<%-- <jsp:include page="includes/Cabecera.jsp" /> --%>


Pagina de bienvenida

Branch practicar






<br /><br />
<div class="container">
	<div class="row justify-content-center">
		<div class="col-lg-6">
		<form action="" method="post">
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
			
			<label for="descripcion" >Descripcion: </label>
			<input type="text" name ="descripcion" placeholder="descripcion" />
			<br />
			
			<label for="descuento" >Descuento: </label>
			<input type="number" name ="descuento" placeholder="descuento en porcentaje" />
			<br />
			
			<label for="enlace" >Enlace: </label>
			<input type="text" name ="enlace" placeholder="enlace de la imagen" />
			<br />
			
		</fieldset>
		
		<input type="submit" value="Registrar" />
	
	</form>



		
		
		
		</div>
	</div>
</div>
	
<jsp:include page="../includes/Pie.jsp" />

