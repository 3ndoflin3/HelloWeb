<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	 <meta name="viewport" content="width=device-width, initial-scale=1.0" user-scalable="no" >
	
	
	<!--  RESPONSIVE TABLE  -->
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"/>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.dataTables.min.css"/>
	
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>	
	 
	<script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>	
			
	<script type ="text/javascript" src="../js/responsive-table.js"></script>
	
	<link rel="stylesheet" href="../css/styles.css" media="all" />
	<title>Document</title>
		
</head>
<body>
	
	
	<!--CABECERA HASTA AQUI -->


	<!-- COMIENZO PARALLAX -->
	<div class="parallax"><h1>Prueba técnica</h1> </div>
    
    
    <!-- NAV START -->
    <div class = "nav-wrapper">	
		<nav>
			
				<a href ="jsp/login.jsp">Login </a>
				<a href="ejercicios/howto/top-menu-responsive.jsp">Menu responsive</a>
				<a href  ="jsp/calculadora.jsp">Calculadora </a>
				<a href = "https://es.wallapop.com/search?keywords=cafetera&min_sale_price=20&max_sale_price=50">Wallapop.</a>
				<a href = "ejercicios/css/flexbox.jsp">Enlace para flexbox</a>
				<a href="html/animaciones.html">Animacion</a>
				<a href = "http://www.indicedejuegos.com/">Juegos de mi epoca</a>
	            <a href = "html/auxiliar.html">Viaja a la otra pagina</a>
	            <a href="js/datatable.jsp">Datatable</a>
	            <a href = "ejercicios/css/mediaqueries.jsp">Media Queries</a>
			
		</nav>
	</div>
    
    <!--MAIN START -->
    <main>
    	<div>
    	
    	
    	
        <h2>Cosas</h2>
        <h3>Voluntario <span id="Voluntario">X</span></h3>
        <button onclick="buscarVoluntario()">Quien lee</button>

  
       
        <h2>Basic HTML table</h2>
        <br><a target="_blank" href="https://www.w3schools.com/html/html_tables.asp">Documentacion y ejemplo</a>
    	</div>
    
    
            <br>
            <table class="tabla responsive display">
	            <thead>
	            	<tr>
		            	<td colspan="2"> CLASE IPARTEK </td>
		            </tr>
	            </thead>
	            
	            
            	<tbody>
	                <tr>
	                    <td>Aitor</td>
	                    <td>Lorem Ipsum</td>
	                </tr>
	
	                <tr>
	                    <td>Endika</td>
	                    <td>Iker</td>
	                </tr>
	                <tr>
	                    <td>Iñigo</td>
	                    <td>Kiryl</td>
	                </tr>
	                <tr>
	                    <td>Juan Carlos</td>
	                    <td>Maria</td>
	                </tr>
	                <tr>
	                    <td>Alejandro</td>
	                    <td>Ana</td>
	                </tr>
	                <tr>
	                    <td>Christian</td>
	                    <td>Erlantz</td>
	                </tr>
	                <tr>
	                    <td>Raul</td>
	                    <td>Andres</td>
	                </tr>
	                <tr>
	                    <td>Mikel</td>
	                    <td>Joseba</td>
	                </tr>
	                <tr class="Teacher">
	                    <td colspan="2">Ander Da Teacher</td>
	                </tr>
                </tbody>
            </table>
    
    </main>
    
    
    <!--FOOTER  -->
    
		
		<div class="Espacio">
		
        </div>

		<div class ="footer-wrapper">
	        <footer>
		        
			        <a href="mailto:rafa@gmail.com?Subject=Interesado%20en%20el%20curso">Contactar por correo</a>
		            <a href="#Title" id ="end">Ir al Principio</a>
		            <a href="tel:555-555-5555">Contactar por telefono</a>
			        
	        </footer>
        </div>
	        
    <!-- FOOTER ICONS -->
    <!--
    
    
    <i class="fas fa-phone"></i>

    
    <i class="fas fa-at"></i>
    
    YOU NEED TO LINK:CSS (LINK BELOW)

    https://cdnjs.com/libraries/font-awesome
    
    
      -->
    
    
</body>
</html>