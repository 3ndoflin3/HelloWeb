<%String titulo = "Login"; %>

<%@ page errorPage="/error/error505.jsp" %>
	
<%@include file ="../includes/Cabecera.jsp" %>

	<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css" media="all" /> -->
    <!-- <link rel="stylesheet" href="css/form.css"> -->
    <!-- <title>Document</title>
</head>
<body background="/images/fondoform.jfif">
    
 -->
<%-- <% 	Object o = null; 
	o.toString(); 
%> --%>

    <h1>Inicia sesion</h1>

	<div class="row justify-content-center">
		<div class="col-6 mt-3">
			<form action="login" method="post">
		        <fieldset>
		            <legend>Login </legend>
		            <br> <br>
		            <input type ="text" name="name" id="name" placeholder="Nombre" required autofocus>
		            <br> <br>
		            <input type = "password" name ="pass" id ="pass" placeholder="Contraseña " required >
		           
		           <i class="fas fa-eye"></i>
		           <!--  <button id="verTexto" > <img src="images/eye.jfif" ></button> -->
		            <br> <br>
		
		            <!--**********************CHECKBOX*********************-->
		
		
		            <!--
		            <input type = "checkbox" name ="Español" id ="Español" value="1"> Español <br>
		            <input type = "checkbox" name ="Ingles" id ="Ingles" value="2"> Ingles <br>
		            <input type = "checkbox" name ="Catalan" id ="Catalan" value="3"> Catalan <br>
		            <input type = "checkbox" name ="Gallego" id ="Gallego" value="4"> Gallego <br>
		            <input type = "checkbox" name ="Euskera" id ="Euskera" value="5"> Euskera <br>
		            <input type = "checkbox" name ="Andaluz" id ="Andaluz" value="6"> Andaluz <br>
		            
		        -->
		            <select name ="idioma" id ="idioma">
		
		                <option value ="es">Español</option>
		                <option value ="en">Ingles</option>
		                <option value ="cat" selected>Catalan</option>
		                <option value = "eu">Euskera</option>
		
		
		            </select>
		            
		
		            <br> <br> <br>
		            <input type = "checkbox" name ="remember" id = "remember" class="d-block"> Recuerdame
		
		
		            <br><br>
		
		            <input type ="submit" value ="Entrar">
		
		        </fieldset>
		
			
		
		        <script src="js/eventos.js"></script>
		
		    </form>

		</div>
	</div>

		    	
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<%@include file ="../includes/Contacto.jsp" %>

<%
	String mensaje = (String) request.getAttribute("mensaje");
	
	if(mensaje == null){
		mensaje = (String) request.getParameter("mensaje");
	}
	
	if(mensaje!=null){
		%>
		<p style ="color: red;">${mensaje}</p>
		
		<% request.setAttribute("mensaje", "");
	}
	
%>