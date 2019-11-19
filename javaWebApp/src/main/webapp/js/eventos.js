
let verTexto = document.getElementById('verTexto');
verTexto.addEventListener("click" (cambiarTipo()));

function cambiarTipo(){
    if(verTexto.type="password"){
        verTexto.type="text";
    }else{
        verTexto.type="password";
    }
}