<%String titulo = "formulario"; %>
<%@include file ="../includes/Cabecera.jsp" %>


<p>Visualizar libros (Deberia de ser en una lista)</p>
	
	
	<ul>
		<c:forEach items="${listaLibros}" var="libro">
    		<li>${libro}</li>
		</c:forEach>
	</ul>
	



<jsp:include page="../includes/Pie.jsp" /> 