<h1><a href ="calculadora.jsp">Resultado</a></h1>

  

<%
	String n1 = request.getParameter("num1");
	String n2 = request.getParameter("num2");
	
	int resultado =(int)request.getAttribute("resultado");
	int num1 =  Integer.parseInt(n1);
	int num2 =  Integer.parseInt(n2);
	String signo = String.valueOf(request.getAttribute("simbolo"));
	
%>


<p> El resultado de <%=num1+signo+num2%> es <%=resultado%> </p>