<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Posicionamiento</title>
    <!-- la base para construir todas las rutas de esta pagina -->
    <base href="/pruebatecnica/">

    <!-- estilos -->
    <link rel="stylesheet" href="css/styles.css">

</head>
<body>

    <h1>Posicionamiento</h1>

    <section>
        <h2>Relativo</h2>
    </section>

    <section>
        <h2>Fixed</h2>
    </section>

    <section>
        <h2>Sticky - css3</h2>
    </section>

    <section>
        <h2>Absoluto</h2>
        <p>la posición de una caja se establece de forma absoluta respecto de su <b>elemento contenedor</b> y el resto de elementos de la página ignoran la nueva posición del elemento</p>

        <style>
            .contenedor{
                /* acordaros siempre de que sea relative el contenedor */
                position: relative; 
                /*  */

                overflow: hidden;
              
                
                width: 400px;
                height: 400px;
                margin: auto;
            }

            .contenedor:hover .texto{
                bottom: 0;
                color: #0099CC;      
                background-color: rgba(0, 0, 0, 0.8);          
            }


            .absoluto{

                /* posicionamos de forma absoluta sobre el contenedor */
                position: absolute;
                right: 10px;
                top: 10px;

                background-color: red;
                border-radius: 50%;
                padding: 10px;
                color: #FFF;
            }

            .contenedor .texto{
                background-color: rgba(0, 0, 0, 0.36);
                position: absolute;
                bottom: -120px;
                color: #FFF;
                transition-duration: 2s;
            }

            .contenedor .texto h3{
                text-transform: uppercase;
            }    

            .contenedor .texto p{
                padding: 10px;
                text-align: justify;
            }    

        </style>

        <div class="contenedor">
            <span class="absoluto">1</span>
            <img src="http://lorempixel.com/400/400/" alt="iamgen aleatoria">

            <div class="texto">
                <h3>titulo</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quibusdam sapiente qui earum placeat commodi quidem hic ex! Quidem qui assumenda velit pariatur rerum facere cum? Voluptatibus minima qui vero architecto!</p>
            </div>                
        </div>

    </section>
    
</body>
</html>