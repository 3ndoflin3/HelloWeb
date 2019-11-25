
// comentario de linea

/* commentario
    de 
    bloque
*/

/**
 * comentario de bloque para documentar
 */

 //alert('Esto funciona');

 var a = 2;
 
console.trace('Esto es una traza de log');
console.info('para informar sobre cosas');
console.debug('la variable a=' + a);
//console.warn('houston tenemos un problema');
//console.error('Error en la conexion al servidor rest');

function buscarVoluntario(){

    console.trace('click buscarVoluntario');
    var elemento = document.getElementById('nombre');

    var alumnos = [
                    {
                        "nombre": "pepe",
                        "github": "https://github.com/ipartek",
                        "edad": 34,
                        "aprobado": false
                    },
                    {
                        "nombre": "pepa",
                        "github": "https://github.com/ipartek",
                        "edad": 37,
                        "aprobado": true
                    },
                    {
                        "nombre": "doramein",
                        "github": "https://github.com/ipartek",
                        "edad": 18,
                        "aprobado": false
                    }
                  ];
    var numAleatorio = Math.floor(Math.random() * alumnos.length  );
    
    elemento.style.color = 'teal';
    var voluntario = alumnos[numAleatorio];
    elemento.innerHTML = `<span>
                                aprobado ${voluntario.aprobado}
                          </span>
                          <a href="${voluntario.github}" target="_blank">${voluntario.nombre}</a>
                        `;
 


}