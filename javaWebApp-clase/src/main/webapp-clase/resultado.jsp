<h1>Resultado</h1>

<%
	//recibir atributos del controlador
	String mensaje = (String)request.getAttribute("mensaje");	
	String simbolo = (String)request.getAttribute("simbolo");
	String op1 = (String)request.getAttribute("op1");
	String op2 = (String)request.getAttribute("op2");
	float resultado = (float)request.getAttribute("resultado");
	
	
	if (mensaje != null) {
%>

	<p style="color:red;"><%=mensaje%></p>

<% }else { %>

	<p>El resultado  <%=op1%> <%=simbolo %> <%=op2%> = <%=resultado%></p>

<% } // final del if %>	

<a href="calculadora.jsp">Volver a Calcular</a>