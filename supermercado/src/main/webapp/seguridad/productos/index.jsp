<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/includes/header.jsp" %>   
    	
	<a href="seguridad/productos?accion=formulario">Nuevo Producto</a>
	${productos}
	
	<table  class="tabla display" style="width:100%">
        <thead>
            <tr>
                <th>ID</th>                
                <th>Nombre</th>
                <th>Precio</th>
                <th>Imagen</th>                
                <th>Descripcion</th>                
                <th>Descuento</th>     
                <th>Nombre usuario</th>           
                <th>Editar</th>                
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${productos}" var="p">
            	<tr>
            	<!-- Cada vez que llamo a un atributo es como si llamase a un getter del mismo -->
                	<td>${p.id}</td>
                	<td>${p.nombre }</td>
                	<td>${p.precio }</td>
                	<td>${p.imagen }</td>
                	<td>${p.descripcion}</td>
                	<td>${p.descuento }</td>
                	<td>${p.usuario.nombre}</td>
                	<td><a href="seguridad/productos?accion=formulario&id=${p.id}">Editar</a></td>
            	</tr>
            </c:forEach>	
        </tbody>    
    </table>
	
	

<%@ include file="/includes/footer.jsp" %> 