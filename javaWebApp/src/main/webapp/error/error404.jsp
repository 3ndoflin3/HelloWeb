<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page isErrorPage="false" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Pagina de Error 404 || Not Found</h1>
	<p>Perdona las molestias pero la pagina que buscas no existe</p>
	<p>Envia un <a href="mailto:admin@ipartek.com">email al administrador </a>para que lo arregle</p>
	<%-- <p>Causa <%=exception.getCause() %></p> --%>
	<p>Mensaje </p>
	<!-- Stack trace -->
	<pre>
		<%-- <jsp:scriptlet>
	  	exception.printStackTrace(new java.io.PrintWriter(out));
		</jsp:scriptlet> --%>
	</pre>
	<!-- <textarea name="" id="" cols="80" rows="20">
	
	</textarea> -->
</body>
</html>