<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css" media="all" />
<title>Crud producto</title>
</head>
<body>
	
	<main>
		<form action="../producto" method ="POST">
			
			<fieldset>
				<p style="color:red;">${mensaje}</p>
				<legend>Introducir datos del producto</legend>
				
				<label for="id">ID: </label>
				<input type="text" name ="id" placeholder="Introduce el ID del producto" value="${id}"/>
				<br /> 
				
				
				<label for="Nombre">Nombre: </label>
				<input type="text" name ="nombre"  placeholder="Introduce el nombre del producto" value="${nombre}"/>
				<br />
				
				<label for="precio">Precio: </label>
				<input type="number" name="precio" placeholder="Introduce el precio del producto" value="${precio}"/>
				<br />
				
				<label for="Imagen">Imagen: </label>
				<input type="text" name="imagen" placeholder="Introduce el enlace de la imagen del producto" value="${imagen}"/>
				<br />
		
				<label for="descripcion">Descripcion: </label>
				<input type="text" name="descripcion" placeholder="Introduce la descripcion del producto" value="${descripcion}"/>
				<br />
				<!-- entre 0 y 100, validate in controller 		 -->
				<label for="descuento">Descuento: </label>
				<input type="number" name ="descuento" placeholder="Introduce el descuento del producto" value="${descuento}"/>
				<br /> 
				
				<input type="submit" value="Registrar" />
				
				<br />
				
				<%--
				${id}
				${nombre }
				${precio }
				${imagen }
				${descripcion }
				${descuento }
				 --%>
				
				
			</fieldset>
			<!-- <select name="" id="">
				<option value=""></option>
				<option value=""></option>
				<option value=""></option>
			</select>
		 -->
		</form>
		
		
		
	</main>
	
</body>
</html>