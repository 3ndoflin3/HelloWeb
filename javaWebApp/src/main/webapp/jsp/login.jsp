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

    <form action="login" method="post">
        <fieldset>
            <legend>Login </legend>
            <br> <br>
            <input type ="text" name="name" id="name" placeholder="Nombre">
            <br> <br>
            <input type = "password" name ="pass" id ="pass" placeholder="Contrase�a ">
           
           <i class="fas fa-eye"></i>
           <!--  <button id="verTexto" > <img src="images/eye.jfif" ></button> -->
            <br> <br>

            <!--**********************CHECKBOX*********************-->


            <!--
            <input type = "checkbox" name ="Espa�ol" id ="Espa�ol" value="1"> Espa�ol <br>
            <input type = "checkbox" name ="Ingles" id ="Ingles" value="2"> Ingles <br>
            <input type = "checkbox" name ="Catalan" id ="Catalan" value="3"> Catalan <br>
            <input type = "checkbox" name ="Gallego" id ="Gallego" value="4"> Gallego <br>
            <input type = "checkbox" name ="Euskera" id ="Euskera" value="5"> Euskera <br>
            <input type = "checkbox" name ="Andaluz" id ="Andaluz" value="6"> Andaluz <br>
            
        -->
            <select name ="idioma" id ="idioma">

                <option value ="es">Espa�ol</option>
                <option value ="en">Ingles</option>
                <option value ="cat" selected>Catalan</option>
                <option value = "eu">Euskera</option>


            </select>
            

            <br> <br> <br>
            <input type = "checkbox" name ="remember" id = "remember"> Recuerdame


            <br><br>

            <input type ="submit" value ="Entrar">

        </fieldset>

	

        <script src="js/eventos.js"></script>

    </form>



	
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