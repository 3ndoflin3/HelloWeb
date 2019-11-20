<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<title>Document</title>
	</head>
	
	<body>
		
		<section>
			<ul>
				<li><a href = "https://css-tricks.com/snippets/css/a-guide-to-flexbox/">Guia de flexbox</a></li>
				<li><a href = "https://flexboxfroggy.com/">Juego flexbox</a></li>
				<li><a href = "http://www.falconmasters.com/web-design/sitio-web-layout-flexbox/">Maquetar pagina web con flexbox</a></li>
				
			</ul>
		</section>
		
		<p>Flex es una nueva forma de <code>display </code>de CSS3 totalmente nueva para que las cajas no sean inline o block. Se comportaran de una nueva forma mucho mas flexible</p>
		<p>Sirve para distribuir los elementos contenidos (hijos) en una etiqueta con <code>display: flex;</code></p>
		
		<style>
			/*Estilos para practicar con flexbox*/
			ul{
				display: flex;
				list-style: none;
				flex-direction: row;
				justify-content: space-between;
			}
			
			li{
				background-color: gray;
			}
			
			.container{
				display: flex;
				flex-direction:column;
				/*flex-direction: row-reverse; /*default = row*/
				flex-wrap: wrap; /*default = nowrap; acomoda a todos los hijos, no desborda*/
				justify-content: center; /* para poder justificar el contenido necesitas quitar el width del
				hijo*/
				
				
				border: 5px solid black;
				width: 80%;
				margin: auto;
			}
		
			.container div{
				border: 5px solid teal;
				background-color: orange;	
				box-sizing: border-box;
				/*width:45%;*/
				margin:5px;
				text-align: center;
				min-height: 70px;
			}
		</style>
		
		
		<div class = "container">
			<div>hijo1</div>
			<div>hijo2</div>
			<div>hijo3</div>
			<div>hijo4</div>
			<div>hijo5</div>
			<div>hijo6</div>
		</div>
		
		
	</body>
</html>