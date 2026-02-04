// SigmaJsCat.js

// newFunction
function newFunction() {
}

function guardarTramite(){
	doc = document.tramites;
	//valida = 0;
	msg="";

	if(doc.tArea[doc.tArea.selectedIndex].value == -1){
		valida =1;
		msg = msg + " Debe Seleccionar una Unidad Administrativa "+ "\n";
	}
	if (Trim(doc.tNombre.value) =="") {
		valida =1;
		msg = msg + " Debe capturar el Nombre del Tramite	"+ "\n";
	}
	if (Trim(doc.tClave.value) =="") {
		valida =1;
		msg = msg + " Debe capturar la Clave del Tramite	"+ "\n";
	}
	if (Trim(doc.tTiempo.value) =="") {
		valida =1;
		msg = msg + " Debe capturar el Tiempo del Tramite	"+ "\n";
	}
	if (Trim(quitaPuntos(doc.tNombre.value)) == "" && doc.tNombre.value!= "") {
		valida =1;
		msg = msg + " El Nombre del Tramite no es v\xE1lido "+ "\n";
	}
	if (Trim(quitaPuntos(doc.tClave.value)) == "" && doc.tClave.value!= "") {
		valida =1;
		msg = msg + " La Clave del Tramite no es v\xE1lida "+ "\n";
	}
	if (quitaNumeros(doc.tTiempo.value) != "") {
		valida =1;
		msg = msg + " El Tiempo del Tramite no es v\xE1lido "+ "\n";
	}
	if (Trim(quitaPuntos(doc.tDescripcion.value)) == "" && doc.tDescripcion.value!= "") {
		valida =1;
		msg = msg + " La Descripci\xF3n del Tramite no es v\xE1lida "+ "\n";
	}
	if (valida == 1){
		alert(msg);
		valida=0;
		return false;
	}else if(valida == 2){
		alert("Su solicitud ya fue enviada");
		return false;
	}else if (valida == 0){		
		mensaje = 'Algunos de los campos tienen caracteres invalidos \nPresione Aceptar para modificarlos automaticamente\no Cancelar para regresar'
		if(detectaCE(doc.tNombre.value) || detectaCE(doc.tClave.value) || detectaCE(doc.tTiempo.value) || detectaCE(doc.tDescripcion.value)){
			if (confirm(mensaje)){

				doc.tNombre.value			= quitaCE(doc.tNombre.value);
				doc.tClave.value			= quitaCE(doc.tClave.value);
				doc.tTiempo.value			= quitaCE(doc.tTiempo.value);
				doc.tDescripcion.value		= quitaCE(doc.tDescripcion.value);
				
				doc.accion.value="guardar";
				valida=2;
				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			doc.accion.value="guardar";
			valida=2;
			doc.submit();
		}	
	}
}

//**ReasignarRechazo.jsp
function ReasignarRechazo(){
	document.getElementById("btnReasignar").disabled = true;
	doc = document.reasignarRec;
	//valida = 0;
	msg="";

	if (doc.reasignarUsr[doc.reasignarUsr.selectedIndex].value == -1){
		valida =1;
		msg = msg + "Debe seleccionar un Puesto"+ "\n";
	}
		
	if (doc.reasignarComen.value == "") {
		valida =1;
		msg = msg + "Debe capturar un comentario de Reasignaci\xF3n"+ "\n";
	}
	
	if (valida==1){
		alert(msg);
		valida=0;
                document.getElementById("btnReasignar").disabled = false;
		return false;
	}else if(valida==2){
		alert("Su solicitud ya fue enviada");
                document.getElementById("btnReasignar").disabled = false;
		return false;
	}else{
		doc.accion.value="guardar";
		valida=2;
		doc.submit();
	}
}
function areaRR(){
	doc = document.reasignarRec;
	doc.id_area.value = doc.areaReasignar.value;
	doc.submit();
}
function puestoRR(){
	doc = document.reasignarRec;
	doc.id_usuario.value = doc.reasignarUsr.value;
	doc.submit();
}

function quitaPuntos(texto){
	while(texto.indexOf('.')!=-1){
		i = texto.indexOf('.');
		aux1 = texto.substring(0,i);
		aux2 = texto.substring(i+1,texto.length);
		texto = aux1 + aux2;
	}
	return texto;
}

function quitaNumeros(texto){
	while(texto.indexOf('0')!=-1){
		i = texto.indexOf('0');
		aux1 = texto.substring(0,i);
		aux2 = texto.substring(i+1,texto.length);
		texto = aux1 + aux2;
	}
	while(texto.indexOf('1')!=-1){
		i = texto.indexOf('1');
		aux1 = texto.substring(0,i);
		aux2 = texto.substring(i+1,texto.length);
		texto = aux1 + aux2;
	}
	while(texto.indexOf('2')!=-1){
		i = texto.indexOf('2');
		aux1 = texto.substring(0,i);
		aux2 = texto.substring(i+1,texto.length);
		texto = aux1 + aux2;
	}
	while(texto.indexOf('3')!=-1){
		i = texto.indexOf('3');
		aux1 = texto.substring(0,i);
		aux2 = texto.substring(i+1,texto.length);
		texto = aux1 + aux2;
	}
	while(texto.indexOf('4')!=-1){
		i = texto.indexOf('4');
		aux1 = texto.substring(0,i);
		aux2 = texto.substring(i+1,texto.length);
		texto = aux1 + aux2;
	}
	while(texto.indexOf('5')!=-1){
		i = texto.indexOf('5');
		aux1 = texto.substring(0,i);
		aux2 = texto.substring(i+1,texto.length);
		texto = aux1 + aux2;
	}
	while(texto.indexOf('6')!=-1){
		i = texto.indexOf('6');
		aux1 = texto.substring(0,i);
		aux2 = texto.substring(i+1,texto.length);
		texto = aux1 + aux2;
	}
	while(texto.indexOf('7')!=-1){
		i = texto.indexOf('7');
		aux1 = texto.substring(0,i);
		aux2 = texto.substring(i+1,texto.length);
		texto = aux1 + aux2;
	}
	while(texto.indexOf('8')!=-1){
		i = texto.indexOf('8');
		aux1 = texto.substring(0,i);
		aux2 = texto.substring(i+1,texto.length);
		texto = aux1 + aux2;
	}
	while(texto.indexOf('9')!=-1){
		i = texto.indexOf('9');
		aux1 = texto.substring(0,i);
		aux2 = texto.substring(i+1,texto.length);
		texto = aux1 + aux2;
	}
	return texto;
}

//**Fin ReasignarRechazo.jsp

function puestoReg(){
	doc = document.reasignar1;
	doc.id_usuario.value = doc.reasignarUsr.value;
	doc.submit();
}