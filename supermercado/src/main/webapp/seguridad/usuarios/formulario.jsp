<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/includes/header.jsp" %>   
    	
	<h1>FORMULARIO</h1>
	
	<form action="login" method="post">
	
		
		<input type="text" name="id" value="${usuario.id}">
		<br>
		<label>Nombre:</label>
		<input type="text" name="nombre" value="${usuario.nombre}">
		
		<br>
		<label>Contraseña:</label>
		<input type="text" name="precio" value="${usuario.contrasenia}">
		
		
		<br>
		
		<input type="hidden" name="accion" value="guardar">
		<input type="submit" value="${(producto.id>0)?"editar":"guardar" }">
	
	</form>
	
	<c:if test="${usuario.id > 0}">
	

		
	
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#exampleModal">
			  Eliminar
			</button>
			
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Eliminar</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        ...
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			        <a class="btn btn-danger" href="login?id=${usuario.id}&accion=eliminar">Eliminar</a>
			      </div>
			    </div>
			  </div>
			</div>


	</c:if>
	

<%@ include file="/includes/footer.jsp" %> 