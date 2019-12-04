
<%@page import="com.ipartek.formacion.controller.ConversorController"%>
<%@include file ="../includes/cabecera.jsp" %>

	<!-- BOOTSTRAP CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

    <!-- FONT AWESOME CDN -->
<!--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
-->

<form action ="/helloweb/conversor" method ="post">
	  <div class="form-group">
	    <label for="exampleInputEmail1">Distancia en metros</label>
	    <input type="number" class="form-control" name="metros"  placeholder="Ej. 8.45m">
	    <small id="emailHelp" class="form-text text-muted">Introducir la distancia a convertir en pies.</small>
	  </div>
	  
	  
	  <button type="submit" value="/helloweb/conversor" class="btn btn-primary">Submit</button>
</form>



<br />
<br />
<br />
<br />
<br />
<%
	String metros = request.getParameter("nMeters");
	String pies = request.getParameter("feet");
	int num1=0;
	int num2=0;
	String mensaje;

	if(metros!=null){
		num1 =  Integer.parseInt(metros);
		num2 =  Integer.parseInt(pies);
		mensaje = request.getParameter("mensaje");
		
	}else{
		mensaje = request.getParameter("mensaje");
	}
		
		
%>
<p>1 metro son ${ConversorController.METROS_PIES} pies </p>

<p> ${mensaje}  </p>

 <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    
    <!-- BOOTSTRAP JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 


<%@include file ="../includes/pie.jsp" %>

