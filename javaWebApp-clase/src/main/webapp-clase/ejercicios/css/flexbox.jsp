<% String titulo = "HelloWeb | Flex"; %>

<%@include file="/includes/cabecera.jsp" %>
<%@include file="/includes/navegacion.jsp" %>


	<h1>Flexbox</h1>
	
	<section>
		<ul>
			<li><a href="https://css-tricks.com/snippets/css/a-guide-to-flexbox/" target="_blank">Guia de Flebox</a></li>
			<li><a href="https://flexboxfroggy.com/#es" target="_blank">Juego Flebox</a></li>
			<li><a href="http://www.falconmasters.com/web-design/sitio-web-layout-flexbox/" target="_blank">Maquetar pagina web con flexbox</a></li>
		</ul>
		<p>Flex es una nueva forma de <code>display</code> de css3 totalmente nueva, para que las cajas no sean inline o block. Se comportaran de una nueva forma mucho mas flexible.</p>
		<p>Sirve para distribuir los elementos contenidos (hijos) en una etiqueta (contenedor) con <code>display:flex</code></p>
	</section>
	
	<style>
		/* estilos para practicar con flexbox */
		.container{
			border:5px solid #000;
			width: 80%;
			margin: auto;
			
			/* flexbox */
			display: flex;
			flex-direction: row; /* por defecto */
			flex-wrap: nowrap; /* por defecto acomoda todos los hijos, no desborda */
			justify-content: center; /* quitar  width: 46%; de los hijos */
			 
		}
		
		.container div{
			border: 5px solid teal;
		    background-color: orange;
		    box-sizing: border-box;
		    width: 46%;
		    margin: 5px;
		    text-align: center;
		    min-height: 80px;
			
			/* flexbox */			
			
		}
		
		
	</style>
	
	<div class="container">
		<div>hijo1</div>
		<div>hijo2</div>
		<div>hijo3</div>
		<div>hijo4</div>
		<div>hijo5</div>
		<div>hijo6</div>
	</div>
	
	
<%@include file="/includes/pie.jsp" %>	