


function submitForm(form,accion,idLink){
   form.accion.value = accion;
   form.idLink.value = idLink;
  form.submit();
}

function submitAsunto(accion,idLink){
   document.asuntoForm.accion.value = accion;
   document.asuntoForm.idLink.value = idLink;
   document.asuntoForm.submit();
}

function obtenCalendario(field,boton){

 Calendar.setup({
					        inputField     :    field,
					        ifFormat       :    "%d/%m/%Y",
					        button         :    boton,
					        align          :    "Br", 
					        weekNumbers	   :	false,
					        showOthers     :    true,
					        singleClick    :    true
					    });
}

function muestraOcultaDIV(divName){
   var divObj = document.getElementById(divName);
   if(divObj.style.display=="none"){
   	  divObj.style.display="block";
   }else{
   	  divObj.style.display="none";
   }
}

function muestraOcultaSubordinados(divName,img){
   var divObj = document.getElementById(divName);
   if(divObj.style.display=="none"){
   	  divObj.style.display="block";
   	  img.src="./Imagenes/nolines_minus.gif";
   }else{
      img.src="./Imagenes/nolines_plus.gif";
   	  divObj.style.display="none";
   }
}

function validaRangoFechas(campoFechaInicial, campoFechaFinal, msg) {
	var fechaInicial = campoFechaInicial.value;
	var fechaFinal = campoFechaFinal.value;
	if (!fechaInicial || trim(fechaInicial) == "" || fechaInicial.length != 10)
		return false;

	var hoy = new Date();
	hoy.setHours(0);
	hoy.setMinutes(0);
	hoy.setSeconds(0);

	var	dia1 =	fechaInicial.substring(0, 2); 
	var	mes1 =	fechaInicial.substring(3, 5); 
	var anio1 =	fechaInicial.substring(6,10);     
	var fechaCapturadaInicial = new Date(anio1, mes1 - 1, dia1, 0, 0, 0, 0);

	if (fechaCapturadaInicial.getTime() > hoy.getTime()) {
		alert("La fecha inicial no puede fijarse en el futuro (" + msg + ")");
		campoFechaInicial.value = "";
		campoFechaFinal.value = "";
		if (campoFechaInicial.focus) {
			campoFechaInicial.focus();
		}			
		return false;
	}

	if (fechaFinal.length != 10)
		return false;
	var bandera=false;

	var	dia2 =	fechaFinal.substring(0, 2); 
	var	mes2 =	fechaFinal.substring(3, 5); 
	var anio2 =	fechaFinal.substring(6,10);     
	var fechaCapturadaFinal = new Date(anio2, mes2 - 1, dia2, 0, 0, 0, 0);

	if (fechaCapturadaInicial.getTime() > fechaCapturadaFinal.getTime()) {
		alert("La fecha final debe ser posterior a la inicial (" + msg + ")");
		campoFechaFinal.value = campoFechaInicial.value;
		if (campoFechaFinal.focus) {
			campoFechaFinal.focus();
		}			
		return false;
	}
	
	if (fechaCapturadaFinal.getTime() > hoy.getTime()) {
		alert("La fecha final no puede fijarse en el futuro (" + msg + ")");
		campoFechaFinal.value = campoFechaInicial.value;
		if (campoFechaFinal.focus) {
			campoFechaFinal.focus();
		}			
		return false;
	}
}

function verificarCheck(lista,checkName){
	var valorCheck = document.getElementsByName(checkName);
	if (lista && valorCheck) {
			for (i = 0; i < valorCheck.length; i++) {
				for (j = 0; j < lista.length; j++) {
					if (valorCheck[i].value == lista[j]) {
						valorCheck[i].checked="checked";
						break;
					}
				}
			}
	}
}

function validaFormatoFecha(campoFechaInicial, campoFechaFinal){
	var fechaInicial = campoFechaInicial.value;
	var fechaFinal = campoFechaFinal.value;
	
	if (!fechaInicial || trim(fechaInicial) == "" || fechaInicial.length != 10)
		return false;
		
	
	fecha = fechaInicial;
	mes	 =	fecha.substring(3, 5); 
	dia	 =	fecha.substring(0, 2); 
   	anio =	fecha.substring(6,10);     
	if (trim(fecha) != ""){
		var bandera=false;
		if(fecha.length != 10){
			bandera=true;
		}
		if(fecha.charAt(2) != '/' || fecha.charAt(5) != '/'){
			bandera=true;
		}
		if(mes>12 || mes<1){
			bandera=true;
		}
		else{
			if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){
				if (dia<1 || dia>31)
					bandera=true;
			}
			else{
				if (dia<1 || dia>30)
					bandera=true;
			}
			if(mes==2 && anio%4==0){
				if (dia<1 || dia>29)
					bandera=true;
			}
			if(mes==2 && anio%4!=0){
				if (dia<1 || dia>28)
					bandera=true;
			}
		}		
		if(bandera){
		alert("El formato de la Fecha Inicial es invalido");
		doc.asuntoFechaRecepcion.value = "";
		}
	}
	
	
	fecha = fechaFinal;
	mes	 =	fecha.substring(3, 5); 
	dia	 =	fecha.substring(0, 2); 
   	anio =	fecha.substring(6,10);     
	if (trim(fecha) != ""){
		var bandera=false;
		if(fecha.length != 10){
			bandera=true;
		}
		if(fecha.charAt(2) != '/' || fecha.charAt(5) != '/'){
			bandera=true;
		}
		if(mes>12 || mes<1){
			bandera=true;
		}
		else{
			if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){
				if (dia<1 || dia>31)
					bandera=true;
			}
			else{
				if (dia<1 || dia>30)
					bandera=true;
			}
			if(mes==2 && anio%4==0){
				if (dia<1 || dia>29)
					bandera=true;
			}
			if(mes==2 && anio%4!=0){
				if (dia<1 || dia>28)
					bandera=true;
			}
		}		
		if(bandera){
		alert("El formato de la Fecha Final es invalido");
		doc.asuntoFechaRecepcion.value = "";
		}
	}
}

function trim (strToTrim) {
	return(strToTrim.replace(/^\s+|\s+$/g, ''));
}

