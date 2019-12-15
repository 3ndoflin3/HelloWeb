<%String titulo = "Doges";
String mensaje = String.valueOf(request.getParameter("mensaje"));
%>

	
<%@page import="com.ipartek.formacion.modelo.pojo.Perro"%>
<%@page import="java.util.ArrayList"%>
<%@include file ="../includes/Cabecera.jsp" %>
<style>
img{
	width: 10vw;
	height: 20vh;
}
</style>
<h1>Perroz</h1>


<p style ="color:teal; font-size:2em;"> <%=mensaje %></p>

	<form action="doge" method="get">
        <fieldset>
            <legend>Añadir perros </legend>
            <br> <br>
            <input type ="text" name="nombre" id="nombre" placeholder="Nombre">
            <br> <br>
            <!-- <input type ="image" name="imagen" id="imagen" placeholder="Imagen">
            <br> <br>
            <input type ="text" name="nombre" id="nombre" placeholder="Nombre">
            
 -->
            <br><br>

            <input type ="submit" value ="Añadir">

        </fieldset>

    </form>
    
    <br />
    <br />
    <br />
    <br />
    
    <form action="doge" method="post">
        <fieldset>
            <legend>Matar Perro :D </legend>
            <label for="Matar">Oprima el boton de abajo para hacer 
            una suculenta hamburguesa de perro</label>
            <br><br>

            <input type ="submit" value ="Matalooooooo">

        </fieldset>
    </form>



	<%	ArrayList<Perro> listaPerros = (ArrayList<Perro>)request.getAttribute("perros");  %>

	<h2>Tenemos estos perros</h2>

	<%if(listaPerros == null){ 
		
	%>
	<h3>Actualmente no disponemos de un perro :c</h3>
		
	<%}else if(!listaPerros.isEmpty()){
		int cont = 0;
		%>	
		<ol>
		<%for(Perro p : listaPerros){ %>
			<li>Su nombre es: <%=p.getNombre() %>  Su id es: <%=cont+1 %> <img src="<%=p.getFoto()%>" alt="" />  </li>
		<% cont++;
		} %>
		
		</ol>
	<%} %>
	
	

<%@include file ="../includes/Contacto.jsp" %>
