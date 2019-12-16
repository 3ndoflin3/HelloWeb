<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ipartek.formacion.modelo.pojo.Producto" %>		
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Visualizar Productos</h1>

	<ul>
	
	 ${ listaProductos }
		<%-- <%ArrayList<Producto> listaProductos = (ArrayList<Producto>) request.getAttribute("listaProductos");
		
		for(Producto p : listaProductos){%>
			<li>El producto es <%p.getNombre(); %></li>  
		<% } %> --%>
	
	
	
	
	</ul>
	
	



</body>
</html>