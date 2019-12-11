<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%-- 
	<c:set var="exception" value="${requestScope['javax.servlet.error.exception']}"/>
	 --%>
	
	<p>Error 505</p>
	<p>Tu servidor peta mas rapido que un irani en USA</p>
	<!-- Stack trace -->
	<pre>
		<jsp:scriptlet>
	  	exception.printStackTrace(new java.io.PrintWriter(out));
		</jsp:scriptlet>
	</pre>
	
	
</body>
</html>