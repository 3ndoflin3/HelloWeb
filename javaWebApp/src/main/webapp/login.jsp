<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="css/form.css">
    <title>Document</title>
</head>
<body background="images/fondoform.jfif">
    



    <h1>Inicia sesion</h1>

    <form action="login" method="post">
        <fieldset>
            <legend>Login </legend>
            <br> <br>
            <input type ="text" name="name" id="name" placeholder="Nombre">
            <br> <br>
            <input type = "password" name ="pass" id ="pass" placeholder="Contraseña ">
           
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
            <input type = "checkbox" name ="remember" id = "remember"> Recuerdame


            <br><br>

            <input type ="submit" value ="Entrar">

        </fieldset>

	

        <script src="js/eventos.js"></script>

    </form>
</body>
</html>

<%
	String mensaje = (String) request.getAttribute("mensaje");

	
%>