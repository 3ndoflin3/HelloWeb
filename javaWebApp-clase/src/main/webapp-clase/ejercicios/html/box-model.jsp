<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Visualización</title>
</head>
<body>

    <style>

        body{
            padding: 50px;
        }

        span {
            border: 3px dotted red;
            padding: 5px;
        }

        p{
            /* border: 1px solid #000; */
            padding: 5px;
        }

        p.prueba{
            color: teal;
            border: 5px solid green;
            margin: 10px;
            /* padding: 20px;  shorthand 4 lados */
            /* padding: 20px 40px; */
            /* padding: 20px 40px 50px; */
           /*  padding: 20px 40px 50px 100px;  */
            
            /*
            padding-left: 10px;
            padding-right: 10px;
            padding-top: 10px;
            padding-bottom: 10px;
            */

        }

        .box{

            display: inline-block;
            box-sizing: border-box;
            width: 100px;
            height: 100px;

            border: 2px solid teal;
            background-color: royalblue;
            border-radius: 10px;

            color: #FFF;
            font-size: 5em;
            text-align: center;
        }

        .box-texto{
            display: inline-block;
            width: 100px;
            height: 100px;
            border: 2px solid teal;
        }

        section{
            border:1px solid rgb(206, 205, 205);
            background-color:  rgb(245, 245, 245);
            padding: 10px;
            margin-bottom: 50px;

            -webkit-box-shadow: 13px 20px 31px -13px rgba(0,0,0,0.75);
            -moz-box-shadow: 13px 20px 31px -13px rgba(0,0,0,0.75);
            box-shadow: 13px 20px 31px -13px rgba(0,0,0,0.75);

        }

        .rosa{
            background-color: pink;
            position: relative;
            left: 140px;
            z-index: -2;
            bottom: -62px;
        }


    </style>

    <h1>Visualización</h1>

    <section>
        <h2>Box Model</h2>
        <p class="prueba">Toda etiqueta de html tiene una estrctura de caja</p>
    </section>

    <section>
        <h2>Display</h2>
        <p><code>display</code> es el atributo para gestionar si es linea o bloque ( existen muchos mas displays, ej: flex )</p>
        <p>*trick: usar inspector para verlo</p>
        <dl>
            <dt>block</dt>
            <dd>Elemento que ocupa todo el ancho del elemento padre</dd>
            <dt>inline</dt>
            <dd>Elemento que ocupa lo que tenga su contenido</dd>        
            <dt>inline-block</dt>
            <dd>Es una cosa hibrida de las dos anteriores</dd>      
        </dl>

        <p>Lorem <span>ipsum</span> dolor sit, amet consectetur adipisicing elit. Optio eveniet dolores culpa tempore enim repellat atque quam repellendus sapiente nostrum, nesciunt nulla perferendis, iste quibusdam molestiae voluptates non. Beatae, mollitia!</p>

        <div class="box">1</div>
        <div class="box">2</div>
    </section>


    <section>
        <h2>Visibility</h2>
        <p>Existen dos forma de ocultar elementos de html</p>
        <p>Usando <code>visibility</code></p>
        <div class="box">1</div>
        <div class="box" style="visibility: hidden;">2</div>
        <div class="box">3</div>

        <p>Usando <code>display: none</code></p>
        <div class="box">1</div>
        <div class="box" style="display:none;">2</div>
        <div class="box">3</div>
    </section>

    <section>
        <h2>Overflow</h2>
        <p>Como se muestra cuando no entra en el contendor padre <code>visible | hidden | scroll | auto </code></p>
        <p>Tambien se puede usar <code>overflow-x</code> y <code>overflow-y</code></p>

        <div class="box-texto" style="overflow: hidden;">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fuga asperiores sapiente reiciendis, rerum veritatis illo. Ea qui modi praesentium! Optio aspernatur ratione excepturi voluptatum exercitationem repellat placeat officia nulla obcaecati.</p>
        </div>
        <div class="box-texto" style="overflow: scroll;">
            <p>Iure quia nostrum provident delectus, ipsam repudiandae adipisci dolore ratione rem. Obcaecati numquam aspernatur temporibus aliquid? Odit quasi sunt voluptatem voluptatum odio? Deleniti sequi, maiores alias eum dolor ea veniam.</p>
        </div>
        <div class="box-texto" style="overflow: auto;">
            <p>Reprehenderit, labore assumenda? Provident vitae corrupti dolorem sit ratione aliquid nam. Porro modi corrupti accusamus sint ducimus, iste fugit aliquid ipsum quam harum soluta nam repellendus eum quos, eligendi et.</p>
        </div>
        <div class="box-texto" style="overflow: auto;">
                <p>auto con poco texto</p>
            </div>
        <div class="box-texto" style="overflow: visible;">
            <p>Repudiandae minima dicta numquam iure autem rem. Nostrum minima, praesentium perspiciatis consequatur vel recusandae officiis doloremque voluptatibus accusantium iusto quam possimus, rem quod quibusdam quaerat assumenda, autem delectus fugiat tempora!</p>
        </div>

    </section>

    
    <section>
        <h2>z-index</h2>
        <p>Se encarga de la profundidad de los elementos cuando se solapan.</p>
        <div class="box rosa">1</div>
        <div class="box" style="z-index: 5; position: relative; top: -20px; left: 50px; background-color: red;">2</div>
        <div class="box" style="z-index: 10; position: relative; " >3</div>
    </section>


    
</body>
</html>