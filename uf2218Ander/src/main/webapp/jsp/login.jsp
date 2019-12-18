<%String titulo = "Libros | login"; %>
<%@include file ="../includes/Cabecera.jsp" %>

${isLogged}
${mensaje}
${contador}

<div class="container mt-4">
	<div class="row justify-content-center" >
		<div class="col-lg-6">
			<form action="login" method="post" >
			<fieldset >
				<legend>Iniciar sesion</legend>
				
				<label for="nombre" >Nombre: </label>
				<input type="text" name ="nombre" placeholder="nombre" value="${nombre}" />
				<br />
				
				<label for="pass" >Password: </label>
				<input type="password" name ="contrasena" placeholder="contrasena" value ="${contrasena}"  />
				<br />
				
				
			</fieldset>
			
			<input type="submit" value="Iniciar sesion" />
		
		</form>
		
		</div>
	</div>
</div>

<jsp:include page="../includes/Pie.jsp" />
