

var myTableArray = [];

/** inner html es el contenido dentro del span */
function buscarVoluntario(){

    console.trace('Bucando voluntario');
    //document.getElementById('nombre').innerHTML = "X";

    var elements = document.getElementsByName('td');

    for(var i = 0; i<elements.length; i++){

    }

    for (const element of elements) {
        myTableArray.push(element);        
    }

    document.getElementById('Voluntario').innerHTML = myTableArray[Math.floor(Math.random() * myArray.length)];

}

/*
var myTableArray = [];




var rand = Math.floor(Math.random() * myArray.length);

console.log(rand);*/


