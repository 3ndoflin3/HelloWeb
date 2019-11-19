
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	
	<a href ="login.jsp">Volver</a>
	
	<form action ="sumar" method = "post">
		
		<input type = "checkbox" name ="op" value = "1" checked> Sumar <br>
		<input type = "checkbox" name ="op" value = "2"> Restar <br>
		<input type = "checkbox" name ="op" value = "3"> Multiplicar <br>
		<input type = "checkbox" name ="op" value = "4"> Dividir <br><br>
		
		<input type="text" name ="num1" placeholder ="numero1"><br><br>
		<input type="text" name ="num2" placeholder ="numero2"><br><br>
		
		<input type ="submit" value ="Calcular">
	
		<!--  <h1><a href ="src/main/java/com/ipartek/formacion/controller/CalculadoraController.java">Calcular</a></h1>-->
	
	</form>
	
	
	
	
	
</body>
</html>


	