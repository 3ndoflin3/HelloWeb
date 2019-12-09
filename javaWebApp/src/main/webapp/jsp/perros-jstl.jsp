<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%String titulo = "perro"; %>

<%@include file ="../includes/Cabecera.jsp"%>



<h1>Perros JSTL</h1>
<p>Mismo ejemplo del CRUD pero utilizando JSLT</p>

<h2>Tenemos ${fn:length(perros)} perros en adopcion </h2>



	<c:if test="${not empty mensaje }">
		<p style ="color: red;">Tenemos mensajes</p>
	</c:if>
	
	
	<c:if test="${empty mensaje }">
		<p style ="color: red;">No tenemos mensajes</p>
	</c:if>
	
	
	
	
	
<ol>
	<c:forEach items="${perros}" var ="p">
		<li>${p.nombre}
		
		<a href="perros2?id=${p.id} }"></a>
		</li>
	</c:forEach>

</ol>



<c:if test="${empty perroEditar }">
		No tenemos perro para Editar, vamos a inicializarlo
		<jsp:useBean id="perroEditar" class="com.ipartek.formacion.modelo.pojo.Perro"></jsp:useBean>
		<p style ="color: red;">No tenemos mensajes</p>
	</c:if>
	
	id=> ${p.id}
	<br />
	nombre=> ${p.nombre }
	
	<br />




<%@include file ="../includes/Pie.jsp"%>