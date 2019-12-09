<%String titulo = "LoginExito"; %>

	
<%@include file ="../includes/Cabecera.jsp" %>
		<h1>Has iniciado sesion con exito</h1>
		
		
	<% String recuerdame = String.valueOf(request.getAttribute("recuerdame"));
		%>
		
		<p>${recuerdame} </p>
			
	</body>
</html>

	