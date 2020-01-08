<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/includes/header.jsp" %>   
    	
	
	<a href="login?accion=guardar">Nuevo Usuario</a>
	${productos}
	
	<table  class="tabla display" style="width:100%">
        <thead>
            <tr>
                <th>ID</th>                
                <th>Nombre</th>
                <th>Contraseña</th>               
                <th>Editar</th>                
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${usuarios}" var="u">
            	<tr>
                	<td>${u.id}</td>
                	<td>${u.nombre }</td>
                	<td>${u.contrasenia}</td>
                	
                	<td><a href="login?accion=eliminar&id=${u.id}">Editar</a></td>
            	</tr>
            </c:forEach>	
        </tbody>    
    </table>
	
	

<%@ include file="/includes/footer.jsp" %> 