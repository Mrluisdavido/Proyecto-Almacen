function nuevo(){
 limpiar();
 habilitar('true');
 document.getElementById('codigo').focus();
}

function limpiar(){
 document.getElementById('codigo').value="";
 document.getElementById('nombre').value="";
 document.getElementById('precio').value="";
 document.getElementById('fecha').value="";
}

function habilitar (accion){
 if (accion=='false'){
     document.getElementById('codigo').disabled =accion;
    document.getElementById('nombre').disabled =accion;
    document.getElementById('precio').disabled =accion;
    document.getElementById('fecha').disabled =accion;
 }else{
    document.getElementById('codigo').removeAttribute("disabled");
    document.getElementById('nombre').removeAttribute("disabled");
    document.getElementById('precio').removeAttribute("disabled");
    document.getElementById('fecha').removeAttribute("disabled");
 } 
}

function cancelar (){
  limpiar();
  habilitar('false');
}



function guardar(){
 
 limpiar();
 habilitar('false');
 
}