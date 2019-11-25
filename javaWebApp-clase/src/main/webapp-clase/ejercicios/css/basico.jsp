<!DOCTYPE html> <!-- html5 -->
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Titulo Pestaña</title>

        <!-- la base para construir todas las rutas de esta pagina -->
        <base href="/pruebatecnica/">

        <!-- estilos -->
        <link rel="stylesheet" href="css/styles.css">

    </head>
    <body>
        <a href="index.html">Volver</a>
        <h1>CSS Básico</h1>

        <h2>Ejemplo de Especificida de los CSS</h2>
        <p>Inspeccionar con las herramientas desarrollador y ver css de los parrafos</p>

        <p style="color:red; font-size:20px;" >Mira este parrafo para ver un estilo en linea</p>

        <style>
            /* Tambien podemos usar CSS dentro de HTML */
            p{
                color: teal;
                font-size: 1.2m;;
            }

            .texto-rojo{
                color: red;
            }

            #texto-verde{
                color: green;
            }

            .super-importante{
                color: lightblue !important; /* es la mas especifica */
            }

            /* selector desdecente */
            .container p{
                color: orange;
            }
            .container p span{
                background: #000;
            }
            
            p .especial{
                font-size: 2em;
                font-weight: 600; /* bold */
            }

            /* selecicona solo los parrafos con la clase 'especial' no es dencendente */
            p.especial2{
                color: purple;
                background-color: #FFF;
            }


          
        </style>

        <p id="texto-verde" class="texto-rojo super-importante">Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus suscipit, dolorum sed obcaecati fugiat voluptatum ab est vitae at labore harum officia, consequatur atque itaque quidem similique voluptate soluta architecto?</p>
        <p>Illo a inventore voluptate tenetur <span>fugit</span>, magnam quisquam assumenda aut molestias officiis quis, sapiente vitae quasi quo corrupti quidem magni? Corrupti consequuntur, assumenda inventore enim quae laborum veniam culpa maxime.</p>
        <p>A rem quaerat non repudiandae voluptatem illum. Vitae quidem vero autem hic, commodi suscipit ratione enim? Voluptatem fugiat labore quidem perspiciatis, veniam iste excepturi? Impedit molestiae itaque numquam quasi asperiores.</p>
        <p>Sunt neque repellendus praesentium cumque impedit iusto maxime quia mollitia obcaecati, dignissimos modi natus, nisi hic, non fugiat consequuntur exercitationem sequi ab iure voluptatum reiciendis quis deleniti repudiandae! Error, dolorem!</p>
        <p>Minima nam placeat unde, incidunt odio beatae officia hic qui voluptate asperiores doloribus vero molestiae deleniti in voluptatibus nobis voluptatum, distinctio expedita modi. Ex accusamus eligendi adipisci. Maxime, harum assumenda?</p>


        <h2>Tipos de selectores</h2>
        <p>En este vídeo puedes ver los tipos de selectores, identificadores, clases y pseudoclases</p>
        <iframe width="560" height="315" 
                src="https://www.youtube.com/embed/ARaU6uGOa_k" 
                frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" 
                allowfullscreen></iframe>

        <h2>Selector descendente A B</h2>          
        <div class="container">
            <p><span>Vamos</span> a dar un estilo solo para estos parrafos que estan dentro de un <code>div.container</code> </p>
            <p>Lorem ipsum, <span>dolor</span> sit amet consectetur adipisicing elit. Sed, perferendis quos? Amet, quo quae dolor similique soluta distinctio eligendi. Rem omnis reiciendis animi ratione corporis placeat nesciunt quod temporibus mollitia.</p>
            <p class="especial2">
                <a class="especial" href="#">anla</a>
                Lorem <span class="especial">ipsum</span>, dolor sit amet consectetur adipisicing elit. Sed, perferendis quos? Amet, quo quae dolor similique soluta distinctio eligendi. Rem omnis reiciendis animi ratione corporis placeat nesciunt quod temporibus mollitia.
            </p>
        </div>
        


    </body>    
</html>