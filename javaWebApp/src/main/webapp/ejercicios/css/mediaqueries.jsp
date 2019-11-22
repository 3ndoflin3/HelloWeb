<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<!-- <link rel="stylesheet" href="css/stylesTabla.css" media="all" /> -->
</head>
<body>
	
	<h1 id ="title">Media Queries</h1>
	
	
	<section>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
		 Quas fuga laudantium est et deserunt modi iusto ipsum ratione incidunt velit debitis vero dolores excepturi.
		  Culpa nesciunt vitae natus dolore magni. </p>
		</section>
	
	<button class ="boton-top" href="#title">^</button>
	<style>
		
		
		.boton-top{
			display: none;
			
		}
		
		/*Laptop*/
		/*@media screen and (max-width: 1024px) and (min.width: 768px){
			
				section{
					background-color: pink;
				
				}
				
				h1{
					color: purple;
				}
			
			}*/
		
		/*Tablet*/
		/*@media screen and (max-width: 768px) and (min.width: 425px){
				
				section{
					background-color: gray;
				
				}
				
				h1{
					color: gray;
				}
			
			}
	
	
		/*Movil*/
		@media screen and (max-width: 425px){
			
			.boton-top{
				display:flex;
				bottom : 10px;
				right: 10px;
				border-radius: 15%;
				background-color: red;
				
			
			}
			
			
			section{
				background-color: red;
			
			}
			
			h1{
				color: red;
			}
		
		}
	
	
	
		
	
	
	
	</style>
	
</body>
</html>