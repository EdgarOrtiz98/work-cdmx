
var posicion = 1;


function getNavegador(){
   var navegador;
    // IE
    if(navigator.userAgent.indexOf("MSIE")>=0) {
       navegador=0;
     }
    // Otros
    else{ 
       navegador=1;
    }   
   return navegador;
}

function evitaEventos(event){
    if(getNavegador()==0){
        window.event.cancelBubble=true;
        window.event.returnValue=false;
    }
    
    if(getNavegador()==1){
        event.preventDefault();
    }
}



var ventana;

function mueveVentana(event, idVentana)
{
   ventana=document.getElementById(idVentana);

     // Obtengo la posicion del cursor
    if(getNavegador()==0)
     {
        cursorComienzoX=window.event.clientX+document.documentElement.scrollLeft+document.body.scrollLeft;
        cursorComienzoY=window.event.clientY+document.documentElement.scrollTop+document.body.scrollTop;
        document.attachEvent("onmousemove", moviendoVentana);
        document.attachEvent("onmouseup", deteniendoVentana);
    }
    if(getNavegador()==1)
    {    
        cursorComienzoX=event.clientX+window.scrollX;
        cursorComienzoY=event.clientY+window.scrollY;
        
        document.addEventListener("mousemove", moviendoVentana, true); 
        document.addEventListener("mouseup", deteniendoVentana, true);
    }
     
    elComienzoX=parseInt(ventana.style.left);
    elComienzoY=parseInt(ventana.style.top);
    // Actualizo el posicion del elemento
    //ventana.style.zIndex=++posicion;
    evitaEventos(event);
}


function moviendoVentana(event){  
    var xActual, yActual;
    if(getNavegador()==0)
    {    
        xActual=window.event.clientX+document.documentElement.scrollLeft+document.body.scrollLeft;
        yActual=window.event.clientY+document.documentElement.scrollTop+document.body.scrollTop;
    }  
    if(getNavegador()==1)
    {
        xActual=event.clientX+window.scrollX;
        yActual=event.clientY+window.scrollY;
    }
    
    ventana.style.left=(elComienzoX+xActual-cursorComienzoX)+"px";
    ventana.style.top=(elComienzoY+yActual-cursorComienzoY)+"px";
 
    evitaEventos(event);
}
 
function deteniendoVentana(event){
    if(getNavegador()==0)
    {    
        document.detachEvent("onmousemove", moviendoVentana);
        document.detachEvent("onmouseup", deteniendoVentana);
    }
    if(getNavegador()==1)
    {
        document.removeEventListener("mousemove", moviendoVentana, true);
        document.removeEventListener("mouseup", deteniendoVentana, true);
    }
}



function seleccionaPestania(obj,div){
   var agregar = document.getElementById("pestaniaAgregar");
   var modificar = document.getElementById("pestaniaModificar");
   var eliminar= document.getElementById("pestaniaEliminar");

   agregar.style.border="none";
   modificar.style.border = "none";
   eliminar.style.border= "none";
   
   agregar.style.borderBottom="solid  2px #C5D7EF";
   modificar.style.borderBottom = "solid  2px  #C5D7EF";
   eliminar.style.borderBottom = "solid  2px #C5D7EF";
   
   agregar.bgColor="#E5ECF9"
   modificar.bgColor="#E5ECF9"
   eliminar.bgColor="#E5ECF9"
   
   
   obj.style.border="solid 2px #C5D7EF";
   obj.style.borderBottom="solid 2px white";
   obj.bgColor="white";
   
   
   document.getElementById("agregar").style.display="none";
   document.getElementById("modificar").style.display="none";
   document.getElementById("eliminar").style.display="none";
   
   document.getElementById(div).style.display="block"; 

}

 function muestraVentana(ventana){
    var ventanaObj=document.getElementById(ventana);
    document.getElementById("transparencia").style.display="block";
    ventanaObj.style.display="block";
}

function escondeVentanas(ventana){

     document.getElementById(ventana).style.display="none";
     document.getElementById("transparencia").style.display="none";
   }

function cargaVentana(ventana, url){
   var ventanaFrame=document.getElementById(ventana+"_frame");
   ventanaFrame.src = url;
   muestraVentana(ventana);  
}


