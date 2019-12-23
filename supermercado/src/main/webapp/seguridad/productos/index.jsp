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
                <th>imagen</th>                
                <th>descripcion</th>                
                <th>descuento</th>                
                <th>Editar</th>                
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${productos}" var="p">
            	<tr>
                	<td>${p.id}</td>
                	<td>${p.nombre }</td>
                	<td>${p.precio }</td>
                	<td>${p.imagen }</td>
                	<td>${p.descripcion}</td>
                	<td>${p.descuento }</td>
                	<td><a href="seguridad/productos?accion=formulario&id=${p.id}">Editar</a></td>
            	</tr>
            </c:forEach>	
        </tbody>    
    </table>
	
	

<%@ include file="/includes/footer.jsp" %> 