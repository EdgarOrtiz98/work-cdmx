//-------------------------------------------------------------------------------------
// Funcion : 
// acepta teclas para valores flotantes
//
function AceptaSoloTeclaNumericaYPunto()
{
	if(event.keyCode >= 48 && event.keyCode <= 57)
	  	event.returnValue = true;
  	else
 		if(event.keyCode==46 ||  event.keyCode==44)
  			event.returnValue = true;
  		else
  			event.returnValue = false;
	
}

//-------------------------------------------------------------------------------------
// Funcion : 
// acepta teclas para valores flotantes
//
function AceptaSoloTeclaNumericaYPunto()
{
	if(event.keyCode >= 48 && event.keyCode <= 57)
	  	event.returnValue = true;
  	else
 		if(event.keyCode==46)
  			event.returnValue = true;
  		else
  			event.returnValue = false;
	
}

//-------------------------------------------------------------------------------------
// Funcion : 
// NO acepta caracteres del teclado
//
function NoAceptaCaracter()
{
	if(event.keyCode >= 0 && event.keyCode <= 255)
	  	event.returnValue = false;
  	else
		event.returnValue = true;  	
}

//-------------------------------------------------------------------------------------
// Funcion : 
// acepta teclas para escribir fechas dd/mm/aaaa
//
function AceptaSoloTeclaNumericaYDiagonal()
{
	if(event.keyCode >= 48 && event.keyCode <= 57)
	  	event.returnValue = true;
  	else
 		if(event.keyCode==47)
  			event.returnValue = true;
  		else
  			event.returnValue = false;
	
}

//-------------------------------------------------------------------------------------
// Funcion : 
// NO acepta caracteres del teclado
//
function NoAceptaSaltosDeLinea()
{
	if(event.keyCode == 13 || event.keyCode == 10)
	  	event.returnValue = false;
  	else
		event.returnValue = true;  	
}

//-------------------------------------------------------------------------------------
// Funcion : 
//
function AceptaSoloTeclaNumerica()
{
	if(event.keyCode >= 48 && event.keyCode <= 57)
	  	event.returnValue = true;
  	else
		event.returnValue = false;
}

//-------------------------------------------------------------------------------------
// Funcion : 
//
function DetectaCambios(bandera)
{
	//alert("Evento="+event.keyCode);
	if(	bandera=="false" && 
                ((event.keyCode>=112 && event.keyCode<=123) || 
                    (event.keyCode>=16 && event.keyCode<=18) || 
                    (event.keyCode>=33 && event.keyCode<=40) || 
                    event.keyCode==45 || 
                    event.keyCode==9 ||
                    event.keyCode==20 || 
                    event.keyCode==91 || 
                    event.keyCode==93 || 
                    event.keyCode==27 ||  
                    event.keyCode==144 || 
                    event.keyCode==145 || 
                    event.keyCode==255 ||
                    event.keyCode==39 ||
                    event.keyCode==191 ||
                    event.keyCode==44 ||
                    event.keyCode==124 ||
                    (event.keyCode>=61 && event.keyCode <=63))
            ){
		
		bandera = false;
		return bandera;
	}
	else{
		bandera = true;
		return bandera;
	}
}




