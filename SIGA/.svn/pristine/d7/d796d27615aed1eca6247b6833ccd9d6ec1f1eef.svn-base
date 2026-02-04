// SigmaJS.js

// newFunction
function newFunction() {
}
//var foco = 0;

function recuperarAsunto(){
   if (confirm("Este proceso eliminara las instrucciones turnadas a todos los destinatarios ya sean de su unidad o de otras unidades,\n \xBFDesea continuar con la recuperaci\xF3n del asunto?")) {
	   doc = document.asuntoTurnado;
	   doc.accion.value="recuperar";
	   doc.submit();
	}else{
	   botonBandera=true;
	}
}

function Imprimir1(idAsunto){
	var isCenter ='true';
	var features = '';

	if(window.screen)if(isCenter)if(isCenter=="true"){
	    var myLeft = (screen.width-800)/2;
	    var myTop = (screen.height-600)/2;
	    features+=(features!='')?',':'';
	    features+=',left='+myLeft+',top='+myTop; 
	}
	window.open("../ReportAsunto?id_asu="+idAsunto, "", features+((features!='')?',':'')+'width=800, height=600 , resizable=yes');
}
function turnar(){
	doc = document.asuntoTurnado;
	doc.accion.value="turnar";
	if(valid == 0){
		if (confirm("Est\xE1 usted seguro que desea Turnar las instrucciones?")) 
		{
			doc.submit();
			valid=1;
		}else{
			botonBandera=true;
			alert("Su petici\xF3n de Turnado ya fue cancelada");
		}
	}else if(valid == 1){
		botonBandera=true;
		alert("No se permite el Doble Click");
	}
}
function turnarNuevo(){
	doc = document.asuntoTurnado;
	doc.accion.value="turnar1";
	if(valid == 0){
		if (confirm("Est\xE1 usted seguro que desea Turnar las instrucciones?")) 
		{
			doc.submit();
			valid=1;
		}else{
			botonBandera=true;
			alert("Su petici\xF3n de Turnado ya fue cancelada");
		}
	}else if(valid == 1){
		botonBandera=true;
		alert("Su solicitud ya fue enviada");
	}
}
function cargaApplet1(){
	doc = document.asuntoTurnado;
	
	valida = 0;
	msg="";
	if(doc.asuPri_1.value==1){
		if (doc.asuntoPrioridad[doc.asuntoPrioridad.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe Seleccionar la Prioridad	"+ "\n";
		}
	}
	if(doc.asuTip_1.value==1){
		if (doc.asuntoTipoAsunto[doc.asuntoTipoAsunto.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe Seleccionar el tipo de asunto	"+ "\n";
		}
	}
	
	if (valida == 1)
	{
		botonBandera=true;
		alert(msg);
		if(doc.asuPri_1.value == 1)
			doc.asuntoPrioridad.focus();
		if(doc.asuTip_1.value == 1)
			doc.asuntoTipoAsunto.focus();
		if(doc.asuPri_1.value == 1 && doc.asuTip_1.value == 1)
			doc.asuntoPrioridad.focus();
		return false; 
	}else{
		doc.accion.value="cargar";
		doc.submit();
	}
	//doc.accion.value="cargar";
	//doc.submit();
}
function cargaApplet2(){
	doc = document.asuntoTurnado;
	if (confirm("Se crear\xE1n autom\xE1ticamente las instrucciones para los destinatarios seleccionados!\nAdicionalmente ya no podr\xE1 editar los siguientes campos en el formato de asunto:\n-Entidad\n-Remitente\n-Destinatarios Internos y Externos\n\n")){
		doc.accion.value="cargar";
		doc.submit();
	}
	else{
		botonBandera=true;
		alert("Su petici\xF3n ya fue cancelada");
	}
}
function cargaAppletTur(){
		
	doc = document.asuntoTurnado;
	valida = 0;
	msg="";
	if(doc.asuPri_1.value==1){
		if (doc.asuntoPrioridad[doc.asuntoPrioridad.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe Seleccionar la Prioridad	"+ "\n";
		}
	}
	if(doc.asuTip_1.value==1){
		if (doc.asuntoTipoAsunto[doc.asuntoTipoAsunto.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe Seleccionar el tipo de asunto	"+ "\n";
		}
	}
	if (valida == 1)
	{
		botonBandera=true;
		alert(msg);
		if(doc.asuPri_1.value == 1)
			doc.asuntoPrioridad.focus();
		if(doc.asuTip_1.value == 1)
			doc.asuntoTipoAsunto.focus();
		if(doc.asuPri_1.value == 1 && doc.asuTip_1.value == 1)
			doc.asuntoPrioridad.focus();
		return false; 
	}else{
		if (confirm("Se crear\xE1n autom\xE1ticamente las instrucciones para los destinatarios seleccionados!\nAdicionalmente ya no podr\xE1 editar  los siguientes campos en el formato de asunto:\n-Entidad\n-Remitente\n-Destinatarios Internos y Externos\n\n")){
			doc.accion.value="guardar";
			doc.submit();
		}
		else{
			botonBandera=true;
			alert("Su petici\xF3n ya fue cancelada");
		}
	}
}
function activarNotificarA(){
	doc = document.asuntoTurnado;
	if(doc.CHNotificar.checked)
	{
		doc.usuarioNombre.disabled = false;
	}
	else{
		doc.usuarioNombre.disabled = true;
	}
}
function finalizar(){
	doc = document.asuntoTurnado;
	doc.accion.value="finalizar";
	doc.submit();
}


function mayor(fecha, fecha2) {
    
    	var xMes=fecha.substring(3, 5); 
        var xDia=fecha.substring(0, 2); 
        var xAnio=fecha.substring(6,10);     
        var yMes=fecha2.substring(3, 5); 
        var yDia=fecha2.substring(0, 2); 
        var yAnio=fecha2.substring(6,10);     
      if (xAnio > yAnio)
           return(true) 
      else   
        if (xAnio == yAnio) 
        {  if (xMes > yMes) 
             return(true) 
           else 
           { if (xMes == yMes){ 
               if (xDia > yDia) 
                   return(true); 
               else 
                   return(false);} 
             else 
                return(false);        
           } 
        }        
        else 
          return(false); 
    }   

function validaFechaRec() {
		
		doc = document.Asunto;
		//valida = 0;
		msg="";

		fechaRecepcion = new Date()
		today = new Date();
		fechaActual = new Date();
		fechaActualA = new Date();
		
		today = new Date();
		day   = "" + today.getDate();
		month = "" + (today.getMonth()+1);
		year  = "" + today.getFullYear();

		if (day.length == 1){
			day ="0" + day;
		}
		if (month.length == 1){
			month ="0" + month;
		}
		
		if (doc.asuntoFechaRecepcion!=null){
			fechaActual = day + "/" + month + "/" + year;
			fechaRecepcion = doc.asuntoFechaRecepcion.value;
			fechaActualA = fechaActual;

			//if (fechaRecepcion > fechaActualA){
			if (comparaFechas(fechaRecepcion, fechaActualA)==1){
		
				msg = msg + "La Fecha de Recepci\xF3n debe ser menor o igual a la Actual " + "\n";
				doc.asuntoFechaRecepcion.value="";
				//doc.asuntoFechaRecepcion.focus();
				alert(msg);
			}
		}
	}

function showCalFechaDocRec(){
		doc = document.Asunto;
		show_calendar("forms[0].asuntoFechaRecepcion");
		//doc.asuntoFechaRecepcion.focus();	  		
}

function validaFechaDoc() {
		
		doc = document.Asunto;	
		msg="";

		fechaRecepcion = new Date()
		fechaDocto = new Date()
				
		if (doc.asuntoFechaRecepcion!=null && doc.asuntoFechaDocto!=null){

			fechaRecepcion = doc.asuntoFechaRecepcion.value;
			fechaDocto = doc.asuntoFechaDocto.value;
		
			if(fechaRecepcion == "" && fechaDocto != ""){
		
				msg = msg + "Debe de capturar la Fecha de Recepci\xF3n del documento";
				//doc.asuntoFechaRecepcion.focus();
				doc.asuntoFechaDocto.value = "";
				alert(msg);
			}
			else 
			if (fechaRecepcion.length >= 10 && fechaDocto.length >= 10){
				if (comparaFechas(fechaDocto,fechaRecepcion)==1){
			
					msg = msg + "La Fecha del Documento debe ser menor o igual a la Fecha de Recepci\xF3n "+ "\n";
					doc.asuntoFechaDocto.value="";
					//doc.asuntoFechaDocto.focus();
					alert(msg);
				}
			}
		}
	}
	
function showCalFechaDoc(){

		doc = document.Asunto;
		show_calendar("forms[0].asuntoFechaDocto");
		//doc.asuntoFechaDocto.focus();
		
}

function validaFechaCom() {
		
		doc = document.Asunto;
		msg="";
		
		fechaRecepcion = new Date()
		fechaCompromiso = new Date()
		
		if (doc.asuntoFechaRecepcion!=null && doc.asuntoFechaCad!=null){
			
			fechaRecepcion = doc.asuntoFechaRecepcion.value;
			fechaCompromiso = doc.asuntoFechaCad.value;
		
			if (fechaRecepcion!=null && fechaCompromiso!=null){
				if(fechaRecepcion == "" && fechaCompromiso != ""){
		
					msg = msg + "Debe de capturar la Fecha de Recepci\xF3n del documento";
					//doc.asuntoFechaRecepcion.focus();
					doc.asuntoFechaCad.value = "";
					alert(msg);
				}
				else
				if (fechaRecepcion.length >= 10 && fechaCompromiso.length >= 10){
					if (comparaFechas(fechaRecepcion,fechaCompromiso)==1){
				
						msg = msg + "La Fecha Compromiso debe ser mayor o igual a la Fecha de Recepci\xF3n"+ "\n";
						doc.asuntoFechaCad.value = "";
						//doc.asuntoFechaCad.focus();
						alert(msg);
					}
				}
			}
		}
	}
	
function showCalFechaCom(){

		doc = document.Asunto;
		show_calendar("forms[0].asuntoFechaCad");
		//doc.asuntoFechaCad.focus();
		
}

// Funciones para el Asunto
// Funci\xF3n que valida los campos de un nuevo Asunto
function validSearch(){
	
	doc = document.searchOpt;
	valida = 0;
	msg="";
	if(  document.searchOpt.searchOption.value == '"' ){
			valida = 1;
			msg = msg + "No esta permitido colocar UNA sola comilla " + "\n";
			if(valida == 1){
				alert(msg);
				}
	}else{
				if (doc.searchOption.value =="") {
					valida =1;
					msg = msg + "Debe capturar alg\xFAn dato para realizar la busqueda	"+ "\n";
				}
				
				if(detectaCEBusquedaB(doc.searchOption.value) ){
					valida = 1;
					msg = msg + "No son permitidos los caracteres ( ' & < > \" ` ´ ) "+ "\n";
					}
				if (valida == 1) 
				{
					alert(msg);
					return false;
				}else{
					doc.submit();
				}
	}
}


//fucnion de cambio al seleccionar un tipo de docuemnto
function cambio(){
	doc = document.Asunto;
	doc.focus.value = "1";
	doc.submit();
}

//fucnion de cambio jefe/puesto
function cambio1(){
	doc = document.usuarioForm;
	//checkRol();
	doc.submit();
}

function cambioArea(valor){
	doc = document.Area;
	doc.idres.value = valor.value;
	doc.submit();
}


//fin fucnion de cambio al seleccionar un tipo de docuemnto

// funcion para cargar el applet en un nuevo asunto
function cargaApplet(){
		
	doc = document.Asunto;
	valida = 0;
	msg="";
		
	if(doc.esRecepcion.value == 1){
		if (doc.asuntoTipoDocto[doc.asuntoTipoDocto.selectedIndex].value == "null") {
			valida =1;
			msg = msg + "Debe seleccionar el Tipo de Documento	"+ "\n";
		}
	}
	if (doc.asuntoPrioridad[doc.asuntoPrioridad.selectedIndex].value == "null") {
		valida =1;
		msg = msg + "Debe seleccionar la Prioridad	"+ "\n";
	}
	if (doc.asuntoTipoAsunto[doc.asuntoTipoAsunto.selectedIndex].value == "null") {
		valida =1;
		msg = msg + "Debe seleccionar el tipo de asunto	"+ "\n";
	}
	if (valida == 1) 
	{ 
		alert(msg);
		return false;
	}else{
		doc.accion.value="cambiar2";
		doc.submit();
		//location.assign('VisualizaInstrucciones.jsp?idAsunto=<%=strIdAsunto%>');
	}
}
// fin funcion para cargar el applet en un nuevo asunto

// Funciones para el Asunto
// Funci\xF3n que valida los campos de un nuevo Asunto
function validacionesAsunto(){
	doc = document.Asunto;
	valida = 0;
	msg="";

	/**
	*	Valida si ha sido capturado un Asunto
	*/
	if (doc.asuntoEntidad.value =="") {
		valida =1;
		msg = msg + "Debe seleccionar una Entidad	"+ "\n";
	}
	if (doc.asuntoRemitente.value =="") {
		valida =1;
		msg = msg + "Debe seleccionar un Remitente	"+ "\n";
	}
	if (Trim(doc.asunto.value) =="") {
		valida =1;
		msg = msg + "Debe capturar el Asunto	"+ "\n";
	}
	if(doc.asuntoDestinatario.value==""){
		valida =1;
		msg = msg + "Debe seleccionar una Ventanilla al Asunto	"+ "\n";
	}
	if(doc.asuntoPara.value==""){
		valida =1;
		msg = msg + "Debe tener datos en el campo Para	"+ "\n";
	}
	if(doc.esRecepcion.value == 1){
		if (doc.asuntoTipoDocto[doc.asuntoTipoDocto.selectedIndex].value == "null") {
			valida =1;
			msg = msg + "Debe seleccionar el Tipo de Documento	"+ "\n";
		}
	}
	if(doc.asuntoFechaRecepcion.value==""){
		valida =1;
		msg = msg + "Debe capturar la Fecha de recepci\xF3n del documento"+ "\n";
	}
	if(doc.asuntoFechaDocto.value==""){
		valida =1;
		msg = msg + "Debe capturar la Fecha del documento"+ "\n";
	}
	if(doc.asuntoFechaCad.value==""){
		valida =1;
		msg = msg + "Debe capturar la Fecha compromiso"+ "\n";
	}
	if(doc.asuntoFolioExt.value==""){
		valida =1;
		msg = msg + "Debe capturar el Identificador del Documento"+ "\n";
	}
	if (doc.asuntoPrioridad[doc.asuntoPrioridad.selectedIndex].value == 'null') {
		valida =1;
		msg = msg + "Debe seleccionar la Prioridad	"+ "\n";
	}
	if (doc.asuntoTipoAsunto[doc.asuntoTipoAsunto.selectedIndex].value == 'null') {
		valida =1;
		msg = msg + "Debe seleccionar el tipo de asunto	"+ "\n";
	}
	//if (doc.asuntoCategoriaDocto[doc.asuntoCategoriaDocto.selectedIndex].text == "") {
	//	valida =1;
	//	msg = msg + "Debe seleccionar la Clasificaci\xF3n del Asunto	"+ "\n";
	//}
	if (valida == 1) 
	{
		alert(msg);
		valida =0;
		doc.accion.value="";
		return false;
	}else if(valida == 2){
		alert("Su solicitud ya fue enviada");
	}else{
		doc.accion.value="guardar1";
		doc.submit();
		valida = 2;
	}
}
/** funcion para validaciones para agregar archivos */
function validacionesAsunto11(){
	doc = document.Asunto;
	//valida = 0;
	msg="";

	/**
	*	Valida si ha sido capturado un Asunto
	*/
	if (doc.asuntoEntidad.value =="") {
		valida =1;
		msg = msg + "Debe seleccionar una Entidad	"+ "\n";
	}
	if (doc.asuntoRemitente.value =="") {
		valida =1;
		msg = msg + "Debe seleccionar un Remitente	"+ "\n";
	}
	if(doc.asuntoDestinatario.value==""){
		valida =1;
		msg = msg + "Debe seleccionar una Ventanilla al Asunto	"+ "\n";
	}
	if(doc.asuntoPara.value==""){
		valida =1;
		msg = msg + "Debe tener datos en el campo Para	"+ "\n";
	}
	if (Trim(doc.asunto.value) =="") {
		valida =1;
		msg = msg + "Debe capturar el Asunto	"+ "\n";
	}
	//if(doc.esRecepcion.value == 1){
	//	if (doc.asuntoTipoDocto[doc.asuntoTipoDocto.selectedIndex].value == "null") {
	//		valida =1;
	//		msg = msg + "Debe seleccionar el Tipo de Documento	"+ "\n";
	//	}
	//}
	if (doc.asuntoTipoDocto[doc.asuntoTipoDocto.selectedIndex].value != "null") {
		valida =1;
		msg = msg + "- Selecionar el Tipo de Documento solo en el caso \"Guardar para Turnar\"	"+ "\n";
	}
	if(doc.asuntoFechaRecepcion.value==""){
		valida =1;
		msg = msg + "Debe capturar la Fecha de recepci\xF3n del documento"+ "\n";
	}
	if(doc.asuntoFechaDocto.value==""){
		valida =1;
		msg = msg + "Debe capturar la Fecha del documento"+ "\n";
	}
	if(doc.asuntoFechaCad.value==""){
		valida =1;
		msg = msg + "Debe capturar la Fecha compromiso"+ "\n";
	}
	if(doc.asuntoFolioExt.value==""){
		valida =1;
		msg = msg + "Debe capturar el Identificador del Documento"+ "\n";
	}
	if (valida == 1) 
	{
		alert(msg);
		valida =0;
		doc.accion.value="";
		return false;
	}
	else if(valida == 2){
		alert("Su solicitud ya fue enviada");
	}
	else if(doc.esRecepcion.value != 1){
		doc.accion.value="guardarAttTur";
		doc.submit();
		valida = 2;
	}else if(doc.esRecepcion.value == 1){
		doc.accion.value="guardarAttRep";
		doc.submit();
		valida = 2;
	}
}

function validacionesAsunto1(){
	doc = document.Asunto;
	valida = 0;
	msg="";

	/**
	*	Valida si ha sido capturado un Asunto
	*/
	if (doc.asuntoEntidad.value =="") {
		valida =1;
		msg = msg + "Debe seleccionar una Entidad	"+ "\n";
	}
	if (doc.asuntoRemitente.value =="") {
		valida =1;
		msg = msg + "Debe seleccionar un Remitente	"+ "\n";
	}
	if(doc.asuntoDestinatario.value==""){
		valida =1;
		msg = msg + "Debe seleccionar una Ventanilla al Asunto	"+ "\n";
	}
	if(doc.asuntoPara.value==""){
		valida =1;
		msg = msg + "Debe tener datos en el campo Para	"+ "\n";
	}
	if (Trim(doc.asunto.value) =="") {
		valida =1;
		msg = msg + "Debe capturar el Asunto	"+ "\n";
	}
	if(doc.esRecepcion.value == 1){
		if (doc.asuntoTipoDocto[doc.asuntoTipoDocto.selectedIndex].value == "null") {
			valida =1;
			msg = msg + "Debe seleccionar el Tipo de Documento	"+ "\n";
		}
	}
	if(doc.asuntoFechaRecepcion.value==""){
		valida =1;
		msg = msg + "Debe capturar la Fecha de recepci\xF3n del documento"+ "\n";
	}
	if(doc.asuntoFechaDocto.value==""){
		valida =1;
		msg = msg + "Debe capturar la Fecha del documento"+ "\n";
	}
	if(doc.asuntoFechaCad.value==""){
		valida =1;
		msg = msg + "Debe capturar la Fecha compromiso"+ "\n";
	}
	if(doc.asuntoFolioExt.value==""){
		valida =1;
		msg = msg + "Debe capturar el Identificador del Documento"+ "\n";
	}
	//if (doc.asuntoCategoriaDocto[doc.asuntoCategoriaDocto.selectedIndex].text == "") {
	//	valida =1;
	//	msg = msg + "Debe seleccionar la Clasificaci\xF3n del Asunto	"+ "\n";
	//}
	if (valida == 1) 
	{
		alert(msg);
		doc.accion.value="";
		return false;
	}else{
		doc.accion.value="guardar2";
		return true;
	}
}

function horarioVentanilla(){
	doc = document.Asunto;
	//valida = 0;
	
	hoy = new Date();
	strFechaHoy = ""+(hoy.getMonth()+1)+"/"+hoy.getDate()+"/"+hoy.getFullYear()+"";
	strHora = ""+hoy.getHours()+":"+hoy.getMinutes()+"";
	
	horaEntrada = new Date (strFechaHoy + " " + doc.horarioEntrada.value);
	horaSalida 	= new Date (strFechaHoy + " " + doc.horarioSalida.value);
	
	bErrorHora = false;
	if(hoy < horaEntrada){
		bErrorHora = true;
	}
	if(hoy > horaSalida){
		bErrorHora = true;
	}
	return bErrorHora;
}

function guardarAsunto(accionInsArch) { 
        
	doc = document.Asunto;
	//valida = 0;
	
	hoy = new Date();
	strFechaHoy = ""+(hoy.getMonth()+1)+"/"+hoy.getDate()+"/"+hoy.getFullYear()+"";
	strHora = ""+hoy.getHours()+":"+hoy.getMinutes()+"";
	
	horaEntrada = new Date (strFechaHoy + " " + doc.horarioEntrada.value);
	horaSalida 	= new Date (strFechaHoy + " " + doc.horarioSalida.value);
	
	bErrorHora = false;
	if(hoy < horaEntrada){
		bErrorHora = true;
	}
	if(hoy > horaSalida){
		bErrorHora = true;
	}
	/**
	*	Valida si ha sido capturado un Asunto
	*/
	msg="";
	
	validaCE = 0;
	mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente \no Cancelar para regresar'

	if(	detectaCE(doc.asuntoFirmante.value) || detectaCE(doc.asunto.value) || 
		detectaCE(doc.asuntoFechaCad.value) || detectaCE(doc.asuntoFolioExt.value) || 
		detectaCE(doc.asuntoFolioInt.value) || detectaCE(doc.asuntoSintesis.value) || 
		detectaCE(doc.asuntoComentario.value) || detectaCE(doc.asuntoPalabraClave.value) || 
		detectaCE(doc.lugarEvento.value)){

		if (confirm(mensaje)){

			doc.asuntoFirmante.value	= quitaCE(doc.asuntoFirmante.value);
			doc.asunto.value		= quitaCE(doc.asunto.value);
			//doc.asuntoReferencia.value	= quitaCE(doc.asuntoReferencia.value);
			doc.asuntoFechaCad.value	= quitaCE(doc.asuntoFechaCad.value);
			doc.asuntoFolioExt.value	= quitaCE(doc.asuntoFolioExt.value);
			doc.asuntoFolioInt.value	= quitaCE(doc.asuntoFolioInt.value);
			doc.asuntoSintesis.value	= quitaCE(doc.asuntoSintesis.value);
			doc.asuntoComentario.value	= quitaCE(doc.asuntoComentario.value);
			doc.asuntoPalabraClave.value    = quitaCE(doc.asuntoPalabraClave.value);
			doc.lugarEvento.value		= quitaCE(doc.lugarEvento.value);
			}
		else 
			validaCE = 1;
	}
	
	if (doc.asuntoEntidad.value =="") {
		valida =1;
		msg = msg + "Debe seleccionar una Entidad	"+ "\n";
	}
	if (doc.asuntoRemitente.value =="") {
		valida =1;
		msg = msg + "Debe seleccionar un Remitente	"+ "\n";
	}
	if (Trim(doc.asunto.value) =="") {
		valida =1;
		msg = msg + "Debe capturar el Asunto	"+ "\n";
	}
	if(doc.asuntoDestinatario.value==""){
		valida =1;
		msg = msg + "Debe seleccionar una Ventanilla al Asunto	"+ "\n";
	}
	//if(doc.asuntoPara.value=="" && doc.asuntoCC.value=="" && doc.asuntoParaE.value==""){
	if(doc.asuntoIdsPara.value=="" && doc.asuntoIdsCC.value=="" && doc.asuntoIdsParaE.value==""){
		valida =1;
		msg = msg + "Debe tener datos en el campo Para, CC o Destinatarios Externos	"+ "\n";
	}
        
	if(doc.esRecepcion.value == 1){
		if (doc.asuntoTipoDocto[doc.asuntoTipoDocto.selectedIndex].value == "null") {
			valida =1;
			msg = msg + "Debe seleccionar el Tipo de Documento	"+ "\n";
		}
	}
	if(doc.asuntoFechaRecepcion.value==""){
		valida =1;
		msg = msg + "Debe capturar la Fecha de recepci\xF3n del documento"+ "\n";
	}
	if(doc.asuntoFechaDocto.value==""){
		valida =1;
		msg = msg + "Debe capturar la Fecha del documento"+ "\n";
	}
	if(doc.asuntoFechaCad.value==""){
		valida =1;
		msg = msg + "Debe capturar la Fecha compromiso"+ "\n";
	}
	if(doc.asuntoFolioExt.value==""){ 
		valida =1;
		msg = msg + "Debe capturar el Identificador del Documento"+ "\n";
	}
        try{
            if(doc.asuntoPrioridad[doc.asuntoPrioridad.selectedIndex].value == "null"){
                valida =1;
                msg = msg + "Debe seleccionar la Prioridad del Asunto"+ "\n";
            }
        }catch(e){}
        try{            
            if(doc.asuntoTipoAsunto[doc.asuntoTipoAsunto.selectedIndex].value == "null"){
		valida =1;
		msg = msg + "Debe seleccionar el Tipo de Asunto"+ "\n";
            }
        }catch(e){}
	//if(!document.Asunto.asuntoTipoFolio[0].checked && !document.Asunto.asuntoTipoFolio[1].checked){
	//	valida =1;
	//	msg = msg + "Debe de seleccionar el Control de Folio"+ "\n";
	//}
	if (Trim(quitaNumeros(quitaPuntos(doc.asuntoFirmante.value)))=="" && doc.asuntoFirmante.value.length>0) {
		valida =1;
		msg = msg + "El Firmante no es v\xE1lido"+ "\n";
	}
	if (Trim(doc.asuntoSintesis.value)=="") {
		valida =1;
		msg = msg + "Debe capturar la Descripci\xF3n"+ "\n";
	}
	if (Trim(doc.asuntoComentario.value)=="" && doc.asuntoComentario.value.length>0) {
		valida =1;
		msg = msg + "El Comentario no debe contener espacios vacios"+ "\n";
	}
	if (Trim(doc.asuntoPalabraClave.value)=="" && doc.asuntoPalabraClave.value.length>0) {
		valida =1;
		msg = msg + "La Palabra Clave no debe contener espacios vacios"+ "\n";
	}
	//if ((doc.asuntoTipoFolio[0].checked && doc.idAreaUsuario.value==doc.idEntidad.value) || (doc.asuntoTipoFolio[1].checked && doc.idAreaUsuario.value!=doc.idEntidad.value)) {
	//	valida =1;
	//	msg = msg + "El Folio de Control no es correcto"+ "\n";
	//}
	if (doc.horaRecepcion[doc.horaRecepcion.selectedIndex].value == "-1") {
		valida =1;
		msg = msg + "Debe seleccionar la Hora de Recepci\xF3n"+ "\n";
	}
	if (doc.minRecepcion[doc.minRecepcion.selectedIndex].value == "-1") {
		valida =1;
		msg = msg + "Debe seleccionar el Minuto de Recepci\xF3n"+ "\n";
	}
	if (valida==0 && bErrorHora) {
		mensaje = "La hora actual est\xE1 fuera del rango de atenci\xF3n de la Unidad Administrativa\n¿Deseas continuar?";
		if(!confirm(mensaje)){
			valida = 2;
		}
	}
	
	if (valida == 1 && validaCE == 0){
		alert(msg);
		botonBandera = true;
		valida = 0;
		doc.accion.value="";
		return false;
	}
	else if(valida==2){
		botonBandera = true;
		alert("Su solicitud ya fue enviada");
	}else if (valida == 0){
	
			if(valida == 2){
				botonBandera = true;
				alert("Su solicitud ya fue enviada");
			}
			else 
				if(doc.id_asunto.value != "" && doc.esRecepcion.value == 1){
					doc.accion.value="cambiar1";
					if (confirm("Est\xE1 usted seguro que desea Guardar el Asunto para Turnar?")){
						if (accionInsArch!="")
							doc.accionArchivo.value=accionInsArch;                                                        
						doc.submit();
						valida = 2;
					}
					else{
						botonBandera = true;
						alert("Su petici\xF3n de Guardado ya fue cancelada");
					}
					//doc.submit();
					//valida = 2;
				}
				else 
					if(doc.id_asunto.value != "" && doc.esRecepcion.value == 2){
						doc.accion.value="cambiar";
						if (confirm("Est\xE1 usted seguro que desea Actualizar el Asunto para Turnar?")){
							if (accionInsArch!="")
								doc.accionArchivo.value=accionInsArch;
							doc.submit();
							valida = 2;
						}
						else{
							botonBandera = true;
							alert("Su petici\xF3n de Actualizaci\xF3n ya fue cancelada");
						}
					}
					else 
						if(doc.id_asunto.value != "" && doc.esRecepcion.value == 0){
							doc.accion.value="cambiarGuaTur";
							if (accionInsArch!="")
								doc.accionArchivo.value=accionInsArch;
							doc.submit();
							valida = 2;
						}
						else 
							if(doc.id_asunto.value == ""){
								doc.accion.value="guardar";
								if (confirm("Est\xE1 usted seguro que desea Guardar el Asunto para Turnar?")){
									if (accionInsArch!="")
										doc.accionArchivo.value=accionInsArch;
									doc.submit();
									valida = 2;
								}
								else{
									botonBandera = true;
									alert("Su petici\xF3n de Guardado ya fue cancelada");
								}
							}
	}
}

function guardarAsuntoEnRecepcion(accionInsArch) { 

	doc = document.Asunto;
	//valida = 0;
	
	if (accionInsArch!="")
		doc.accionArchivo.value=accionInsArch;
	
	hoy = new Date();
	strFechaHoy = ""+(hoy.getMonth()+1)+"/"+hoy.getDate()+"/"+hoy.getFullYear()+"";
	strHora = ""+hoy.getHours()+":"+hoy.getMinutes()+"";
	
	horaEntrada = new Date (strFechaHoy + " " + doc.horarioEntrada.value);
	horaSalida 	= new Date (strFechaHoy + " " + doc.horarioSalida.value);
	
	bErrorHora = false;
	if(hoy < horaEntrada){
		bErrorHora = true;
	}
	if(hoy > horaSalida){
		bErrorHora = true;
	}
	
	validaCE = 0;
	mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente \no Cancelar para regresar'

	if(	detectaCE(doc.asuntoFirmante.value) || detectaCE(doc.asunto.value) || 
		detectaCE(doc.asuntoFechaCad.value) || detectaCE(doc.asuntoFolioExt.value) || 
		detectaCE(doc.asuntoFolioInt.value) || detectaCE(doc.asuntoSintesis.value) || 
		detectaCE(doc.asuntoComentario.value) || detectaCE(doc.asuntoPalabraClave.value) || 
		detectaCE(doc.lugarEvento.value)){

		if (confirm(mensaje)){

			doc.asuntoFirmante.value	= quitaCE(doc.asuntoFirmante.value);
			doc.asunto.value			= quitaCE(doc.asunto.value);
			//doc.asuntoReferencia.value	= quitaCE(doc.asuntoReferencia.value);
			doc.asuntoFechaCad.value	= quitaCE(doc.asuntoFechaCad.value);
			doc.asuntoFolioExt.value	= quitaCE(doc.asuntoFolioExt.value);
			doc.asuntoFolioInt.value	= quitaCE(doc.asuntoFolioInt.value);
			doc.asuntoSintesis.value	= quitaCE(doc.asuntoSintesis.value);
			doc.asuntoComentario.value	= quitaCE(doc.asuntoComentario.value);
			doc.asuntoPalabraClave.value= quitaCE(doc.asuntoPalabraClave.value);
			doc.lugarEvento.value		= quitaCE(doc.lugarEvento.value);
			}
		else 
			validaCE = 1;
	}
	
	
	msg="";
	/**
	*	Valida si ha sido capturado un Asunto
	*/
	if (doc.asuntoEntidad.value =="") {
		valida =1;
		msg = msg + "Debe seleccionar una Entidad	"+ "\n";
	}
	if (doc.asuntoRemitente.value =="") {
		valida =1;
		msg = msg + "Debe seleccionar un Remitente	"+ "\n";
	}
	if(doc.asuntoDestinatario.value==""){
		valida =1;
		msg = msg + "Debe seleccionar una Ventanilla al Asunto	"+ "\n";
	}
	//if(doc.asuntoPara.value=="" && doc.asuntoCC.value=="" && doc.asuntoParaE.value==""){
	if(doc.asuntoIdsPara.value=="" && doc.asuntoIdsCC.value=="" && doc.asuntoIdsParaE.value==""){
		valida =1;
		msg = msg + "Debe tener datos en el campo Para, CC o Destinatarios Externos	"+ "\n";
	}
	if (Trim(doc.asunto.value) =="") {
		valida =1;
		msg = msg + "Debe capturar el Nombre del Asunto	"+ "\n";
	}
	
	if(doc.asuntoFechaRecepcion.value==""){
		valida =1;
		msg = msg + "Debe capturar la Fecha de recepci\xF3n del documento"+ "\n";
	}
	if(doc.asuntoFechaDocto.value==""){
		valida =1;
		msg = msg + "Debe capturar la Fecha del documento"+ "\n";
	}
	if(doc.asuntoFechaCad.value==""){
		valida =1;
		msg = msg + "Debe capturar la Fecha compromiso"+ "\n";
	}
	if(doc.asuntoFolioExt.value==""){
		valida =1;
		msg = msg + "Debe capturar el Identificador del Documento"+ "\n";
	}

	if (Trim(quitaNumeros(quitaPuntos(doc.asuntoFirmante.value)))=="" && doc.asuntoFirmante.value.length>0) {
		valida =1;
		msg = msg + "El Firmante no es v\xE1lido"+ "\n";
	}
	if (Trim(doc.asuntoSintesis.value)=="") {
		valida =1;
		msg = msg + "Debe capturar la Descripci\xF3n"+ "\n";
	}
	if (Trim(doc.asuntoComentario.value)=="" && doc.asuntoComentario.value.length>0) {
		valida =1;
		msg = msg + "El Comentario no debe contener espacios vacios"+ "\n";
	}
	if (Trim(doc.asuntoPalabraClave.value)=="" && doc.asuntoPalabraClave.value.length>0) {
		valida =1;
		msg = msg + "La Palabra Clave no debe contener espacios vacios"+ "\n";
	} 
	
	if (doc.horaRecepcion[doc.horaRecepcion.selectedIndex].value == "-1") {
		valida =1;
		msg = msg + "Debe seleccionar la Hora de Recepci\xF3n"+ "\n";
	}
	if (doc.minRecepcion[doc.minRecepcion.selectedIndex].value == "-1") {
		valida =1;
		msg = msg + "Debe seleccionar el Minuto de Recepci\xF3n"+ "\n";
	}
	if (valida==0 && bErrorHora) {
		mensaje = "La hora actual est\xE1 fueran del rango de atenci\xF3n de la Unidad Administrativa\n¿Deseas continuar?";
		if(!confirm(mensaje)){
			valida = 2;
		}
	}
	if (valida == 1 && validaCE == 0){
		alert(msg);
		botonBandera = true;
		valida = 0;
		doc.accion.value="";
		return false;
	}else if(valida==2){
		botonBandera = true;
		alert("Su solicitud ya fue enviada");
	}else if (valida == 0){
	
			if(valida == 2){
				botonBandera = true;
				alert("Su solicitud ya fue enviada");
			}
			else if(doc.id_asunto.value != ""){
				doc.accion.value="cambiarRep";
				if (confirm("Est\xE1 usted seguro que desea Actualizar el Asunto en Recepci\xF3n?")) 
				{
					doc.submit();
					valida = 2;
				}else{
					botonBandera = true;
					alert("Su petici\xF3n de Actualizaci\xF3n ya fue cancelada");
				}
			}
			else if(doc.id_asunto.value == ""){
				doc.accion.value="guardarRep";
				if (confirm("Est\xE1 usted seguro que desea Guardar el Asunto en Recepci\xF3n?")) 
				{
					doc.submit();
					valida = 2;
				}else{
					botonBandera = true;
					alert("Su petici\xF3n de Guardado ya fue cancelada");
				}
			}
	}


}



function HomeAsunto(){
	location.assign('portalPrincipal.jsp');
}

function BorrarAsunto(){
	doc = document.Asunto;
	msg = "";
	if(doc.id_asunto.value == ""){
		alert("No se puede eliminar el asunto");
		return false;
	}
	else 
	{
		if(confirm("Est\xE1 usted seguro de que desea borrar el/los documento(s)?")){
			doc.accion.value='borrar';
	    	doc.submit();
    	}else{
    	    botonBandera = true;
			alert("Su petici\xF3n de Actualizaci\xF3n ya fue cancelada");
		}
	}
}
function guardarArchivado() { 

	doc = document.archivadoAsunto;
	valida = 0;
	msg="";
	
	if (doc.archivadoSubfondo[doc.archivadoSubfondo.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar un Subfondo "+ "\n";
	}
	if (doc.archivadoSeccion[doc.archivadoSeccion.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar una Secci\xF3n "+ "\n";
	}
	if (doc.archivadoTipoAsunto[doc.archivadoTipoAsunto.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar una clasificaci\xF3n del asunto "+ "\n";
	}
	if (valida == 1) 
	{
		alert(msg);
		return false;
	}
	else{
		doc.accion.value="guardar";
		doc.submit(); 	
	}
}
// ** Fin funciones Asuntos

// Funciones para el header
function MM_swapImgRestore() { //v3.0
	var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
	var d=document;
	if(d.images){
		if(!d.MM_p) d.MM_p=new Array();
    		var i,j=d.MM_p.length,a=MM_preloadImages.arguments;
    		for(i=0; i<a.length; i++)
    			if (a[i].indexOf("#")!=0){
    				d.MM_p[j]=new Image;
    				d.MM_p[j++].src=a[i];
    			}
    		}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

// Fin funciones del header

// Funciones para el catalogo de Usuario

function guardarUsuario() {
	doc = document.usuarioForm;
	form = document.usuarioForm;
	//valida = 0;
	valor = "";
	valorNot = "";
	msg="";
	
	checkRol();
	checkMail();
	
	//if (doc.usuarioNombre[doc.usuarioNombre.selectedIndex].value == -1) {
	//	valida =1;
	//	msg = msg + "Debe seleccionar un Usuario	"+ "\n";
	//}
	for (var i = 0; i < form.elements.length; i++) {
		if (form.elements[i].type == "checkbox") {
  			if (form.elements[i].name == "catArch") {
    			if (form.elements[i].checked == true){
    				valor = form.elements[i].value;
    			}else
    				valor = 0;
  			}
  			if (form.elements[i].name == "not") {
    			if (form.elements[i].checked == true){
    				valorNot = form.elements[i].value;
    			}else
    				valorNot = 1;
  			}
		}
	}
//		if (valida != 1)	{
		/*mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar'
		if(detectaCE(doc.uid.value) || detectaCE(doc.usuarioNombre.value) || detectaCE(doc.usuarioCargo.value)){
			if (confirm(mensaje)){

				doc.uid.value				= quitaCE(doc.uid.value);
				doc.usuarioNombre.value		= quitaCE(doc.usuarioNombre.value);
				doc.usuarioCargo.value		= quitaCE(doc.usuarioCargo.value);
				
				if(doc.id_usuario.value != "")
					doc.accion.value="cambiar";
				if(doc.id_usuario.value == "")
					doc.accion.value="guardar";
//				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			if(doc.id_usuario.value != "")
				doc.accion.value="cambiar";
			if(doc.id_usuario.value == "")
				doc.accion.value="guardar";
			document.usuarioForm.catArch1.value = valor;
			document.usuarioForm.not1.value = valorNot;
//			doc.submit();
			document.usuarioForm.catArch1.value = valor;
		}	*/
//	}
	
	if(doc.controlUSR.value == 1){
		if (doc.uid.value =="") {
			valida =1;
			msg = msg + "Debe capturar el Id de Usuario "+ "\n";
		}
		if (Trim(quitaPuntos(doc.uid.value)) =="" && doc.uid.value!="") {
			valida =1;
			msg = msg + "El Id de Usuario no es v\xE1lido"+ "\n";
		}
		if (detectaCE(doc.uid.value) || doc.uid.value.indexOf(" ")>=0) {
			valida =1;
			msg = msg + "El Id de Usuario no debe contener los caracteres & \" ' < > (espacio en blanco) "+ "\n";
		}
		if (doc.usuarioPassword.value =="") {
			valida =1;
			msg = msg + "Debe capturar la Contraseña del Id de Usuario	"+ "\n";
		}
		if (detectaCE(doc.usuarioPassword.value) || doc.usuarioPassword.value.indexOf(" ")>=0) {
			valida =1;
			msg = msg + "La Contraseña no debe contener los caracteres & \" ' < >  (espacio en blanco) "+ "\n";
		}
	}
	if (Trim(doc.usuarioNombre.value) =="") {
		valida =1;
		msg = msg + "Debe capturar el Puesto"+ "\n";
	}
	if (doc.usuarioArea[doc.usuarioArea.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar una Unidad Administrativa para el Puesto"+ "\n";
	}
	//if (doc.usuarioRol[doc.usuarioRol.selectedIndex].value == -1) {
	//	valida =1;
	//	msg = msg + "Debe seleccionar un Rol para el Usuario	"+ "\n";
	//}
	if (Trim(doc.usuarioCargo.value) =="") {
		valida =1;
		msg = msg + "Debe capturar el Responsable del Puesto"+ "\n";
	}
	if (Trim(doc.usuarioEmail.value) =="") {
		valida =1;
		msg = msg + "Debe capturar el Correo Electr\xF3nico"+ "\n";
	}
	if(Trim(doc.usuarioConsecutivo.value)==""){
		valida =1;
		msg = msg + "Debe capturar el Consecutivo"+ "\n";
	}
	if(Trim(doc.usuarioRol1.value) == ""){
		valida =1;
		msg = msg + "Debe seleccionar alg\xFAn Rol para el Usuario"+ "\n";
	}
	
	if(Trim(doc.usuarioConfMails1.value) == ""){
		/*if(	!(doc.usuarioRol[0].checked || doc.usuarioRol[4].checked) || 
			doc.usuarioRol[1].checked || doc.usuarioRol[2].checked || 
			doc.usuarioRol[3].checked || doc.usuarioRol[5].checked || 
			doc.usuarioRol[6].checked ){
			valida =1;
			msg = msg + "Debe seleccionar alg\xFAna Configuraci\xF3n de Correo"+ "\n";
		}*/	
	}
	
	if (!isCorreo(Trim(doc.usuarioEmail.value))) {
		valida =1;
		msg = msg + "El Correo Electr\xF3nico es inv\xE1lido"+ "\n";
	}
	if (!isTelefono(Trim(doc.usuarioTelefono.value))) {
		valida =1;
		msg = msg + "El n\xFAmero de Tel\xE9fono es inv\xE1lido"+ "\n";
	}
	if (Trim(quitaPuntos(doc.usuarioNombre.value)) =="" && doc.usuarioNombre.value!="") {
		valida =1;
		msg = msg + "El Puesto no es v\xE1lido"+ "\n";
	}
	if (Trim(quitaPuntos(doc.usuarioCargo.value)) =="" && doc.usuarioCargo.value!="") {
		valida =1;
		msg = msg + "El Responsable no es v\xE1lido"+ "\n";
	}
	if (quitaNumeros(doc.usuarioConsecutivo.value) != "") {
		valida =1;
		msg = msg + "El Consecutivo no es v\xE1lido"+ "\n";
	}

	if (valida == 1) 
	{
		alert(msg);
		valida=0;
		return false;
	}else if(valida == 2){
		alert("Su solicitud ya fue enviada");
		return false;
	}else{
		valida=2;
		if(doc.id_usuario.value != "")
			doc.accion.value="cambiar";
		if(doc.id_usuario.value == "")
			doc.accion.value="guardar";
		document.usuarioForm.catArch1.value = valor;
		document.usuarioForm.not1.value = valorNot;
		doc.submit();
	}
}

function checkRol()
{
	var id_rol='';
	for (var i = 0; i < doc.elements.length; i++) 
  	{
    	if (doc.elements[i].type == "checkbox") 
    	{
      		if (doc.elements[i].name == "usuarioRol") 
      		{
        		if (doc.elements[i].checked == true)
        		{
        			id_rol += doc.elements[i].value+',';
        		}
      		}
    	}
  	}
  	doc.usuarioRol1.value = id_rol;
	
}

function desavilitarOtrosChecks(){

	doc = document.usuarioForm;
	if(doc.usuarioRol[0].checked)
	{
		doc.usuarioRol[1].checked = false;
		doc.usuarioRol[1].disabled = true;
		
		doc.usuarioRol[2].checked = false;				
		doc.usuarioRol[2].disabled = true;

		doc.usuarioRol[3].checked = false;		
		doc.usuarioRol[3].disabled = true;

		doc.usuarioRol[4].checked = false;
		doc.usuarioRol[4].disabled = true;
		
		doc.usuarioRol[5].checked = false;		
		doc.usuarioRol[5].disabled = true;
		
		doc.usuarioRol[6].checked = false;
		doc.usuarioRol[6].disabled = true;
		//doc.usuarioNombre.style.display='inline';
		//doc.usuarioNombre.submit();style="display:none"
	}
	else{
		//doc.usuarioRol[1].checked = false;
		doc.usuarioRol[1].disabled = false;
		
		//doc.usuarioRol[2].checked = false;
		doc.usuarioRol[2].disabled = false;
		
		//doc.usuarioRol[3].checked = false;
		doc.usuarioRol[3].disabled = false;

		//doc.usuarioRol[4].checked = false;
		doc.usuarioRol[4].disabled = false;
		
		//doc.usuarioRol[5].checked = false;
		doc.usuarioRol[5].disabled = false;
		
		//doc.usuarioRol[6].checked = false;
		doc.usuarioRol[6].disabled = false;
	}
	
}

function desavilitarOtrosChecksAsistente(){

	doc = document.usuarioForm;
	if(doc.usuarioRol[6].checked)
	{
		doc.usuarioRol[0].checked = false;
		doc.usuarioRol[0].disabled = true;
		
		doc.usuarioRol[1].checked = false;				
		doc.usuarioRol[1].disabled = true;

		doc.usuarioRol[2].checked = false;		
    	doc.usuarioRol[2].disabled = true;

		//doc.usuarioRol[3].checked = false;
		//doc.usuarioRol[3].disabled = true;
		
		doc.usuarioRol[4].checked = false;		
		doc.usuarioRol[4].disabled = true;
		
		doc.usuarioRol[5].checked = false;
		doc.usuarioRol[5].disabled = true;
                
                if(doc.usuarioAsistente.length) {
                    for(var i = 0; i<doc.usuarioAsistente.length;i++) {
                        doc.usuarioAsistente[i].disabled = true;
                    }
                } else {
                    doc.usuarioAsistente.disabled = true;
                }
	}
	else{
		doc.usuarioRol[0].checked = false;
		doc.usuarioRol[0].disabled = false;
		
		doc.usuarioRol[1].checked = false;
		doc.usuarioRol[1].disabled = false;
		
		doc.usuarioRol[2].checked = false;
		doc.usuarioRol[2].disabled = false;

		doc.usuarioRol[3].checked = false;
		doc.usuarioRol[3].disabled = false;
		
		doc.usuarioRol[4].checked = false;
		doc.usuarioRol[4].disabled = false;
		
		doc.usuarioRol[5].checked = false;
		doc.usuarioRol[5].disabled = false;
    	}
	
}

function seleccionarTodos(){
	doc = document.usuarioForm;

	if(doc.selectAll1.checked)
	{
		doc.usuarioConfMails[0].checked = true;
		doc.usuarioConfMails[1].checked = true;				
		doc.usuarioConfMails[2].checked = true;		
		doc.usuarioConfMails[3].checked = true;
		doc.usuarioConfMails[4].checked = true;		
		doc.usuarioConfMails[5].checked = true;
		doc.usuarioConfMails[6].checked = true;
		doc.usuarioConfMails[7].checked = true;
		doc.usuarioConfMails[8].checked = true;
	}else{
		doc.usuarioConfMails[0].checked = false;
		doc.usuarioConfMails[1].checked = false;
		doc.usuarioConfMails[2].checked = false;
		doc.usuarioConfMails[3].checked = false;
		doc.usuarioConfMails[4].checked = false;
		doc.usuarioConfMails[5].checked = false;
		doc.usuarioConfMails[6].checked = false;
		doc.usuarioConfMails[7].checked = false;
		doc.usuarioConfMails[8].checked = false;
	}
}
//** Funci\xF3n que concatena los valores de los check
//** de la configuraci\xF3n de Correos
function checkMail()
{
	var id_correo='';
	for (var i = 0; i < doc.elements.length; i++) 
  	{
    	if (doc.elements[i].type == "checkbox") 
    	{
      		if (doc.elements[i].name == "usuarioConfMails") 
      		{
        		if (doc.elements[i].checked == true)
        		{
        			id_correo += doc.elements[i].value+',';
        		}
      		}
    	}
  	}
  	doc.usuarioConfMails1.value = id_correo;	
}


//** Fin de catalogo de asuntos

//** Inicio Validacion BuscarCampo.jsp

function BurcarCampo() {
	doc = document.buscarC;
	valida = 0;
	msg="";
				
	if( document.buscarC.buscaEntidad.value == '"' 		||
		document.buscarC.buscaRemitente.value == '"'    ||
		document.buscarC.buscaVentanilla.value == '"'	||
		document.buscarC.buscaPara.value == '"'			||
		//document.buscarC.buscaCC.value == '"'			||
		document.buscarC.buscaAsunto.value == '"'		||
		document.buscarC.buscaExpediente.value == '"'	||
		document.buscarC.buscaTipoDoc.value == '"'		||
		document.buscarC.buscaTramite.value == '"'		||
		document.buscarC.buscaIdDoc.value == '"'		||
		document.buscarC.buscaFolio.value == '"'		||
		document.buscarC.relacionAnexada.value == '"'	){

			valida = 1;
			msg = msg + "No esta permitido colocar UNA sola comilla " + "\n";
			if(valida == 1){
				alert(msg);
				}
	}else{
				doc.buscaEntidad.value 		= Trim(doc.buscaEntidad.value);
				doc.buscaRemitente.value 	= Trim(doc.buscaRemitente.value);
				doc.buscaVentanilla.value 	= Trim(doc.buscaVentanilla.value);
				doc.buscaPara.value 		= Trim(doc.buscaPara.value);
				//doc.buscaCC.value 		= Trim(doc.buscaCC.value);
				doc.buscaAsunto.value 		= Trim(doc.buscaAsunto.value);
				doc.buscaExpediente.value 	= Trim(doc.buscaExpediente.value);
				doc.buscaTipoDoc.value 		= Trim(doc.buscaTipoDoc.value);
				doc.buscaTramite.value 		= Trim(doc.buscaTramite.value);
				doc.buscaIdDoc.value 		= Trim(doc.buscaIdDoc.value);
				doc.buscaFolio.value 		= Trim(doc.buscaFolio.value);
				doc.buscaFirmante.value 	= Trim(doc.buscaFirmante.value);
				doc.buscaFolioInter.value 	= Trim(doc.buscaFolioInter.value);
				doc.buscaSolicitud.value 	= Trim(doc.buscaSolicitud.value);
				doc.buscaComentario.value 	= Trim(doc.buscaComentario.value);
				doc.buscaEvento.value 		= Trim(doc.buscaEvento.value);
				doc.buscaPrioridad.value 	= Trim(doc.buscaPrioridad.value);
				doc.buscaTipoAsunto.value 	= Trim(doc.buscaTipoAsunto.value);
				doc.buscaCaptura.value 		= Trim(doc.buscaCaptura.value);
				doc.relacionAnexada.value 	= Trim(doc.relacionAnexada.value);
			
				if (doc.buscaEstatus[0].checked == false &&
					doc.buscaEstatus[1].checked == false &&
					doc.buscaEstatus[2].checked == false &&
					doc.buscaEstatus[3].checked == false ){
			
					valida =1;
					msg = msg + "Debe seleccionar por lo menos un Estatus "+ "\n";
				}
			
				if (doc.tipoRelacion[0].checked == false &&
					doc.tipoRelacion[1].checked == false &&
					doc.tipoRelacion[2].checked == false &&
					Trim(doc.relacionAnexada.value)!="" ){
			
					valida =1;
					msg = msg + "Debe seleccionar por lo menos un Tipo de Relaci\xF3n "+ "\n";
				}
			
				if (doc.controlFolio[0].checked == false &&
					doc.controlFolio[1].checked == false ){
			
					valida =1;
					msg = msg + "Debe seleccionar si el Asunto es de Entrada o Salida "+ "\n";
				}
			
				if (doc.semaforoAsunto[0].checked == false &&
					doc.semaforoAsunto[1].checked == false &&
					doc.semaforoAsunto[2].checked == false ){
			
					valida =1;
					msg = msg + "Debe seleccionar por lo menos un color de Semaforo "+ "\n";
				}
			
				if (doc.buscaFechaCapI.value!="" && doc.buscaFechaCapF.value!="" && comparaFechas(doc.buscaFechaCapI.value,doc.buscaFechaCapF.value)==1) {
					valida =1;
					msg = msg + "La Fecha de Captura Inicial debe ser menor o igual a la Fecha de Captura Final "+ "\n";
				}
				if (doc.buscaFechaRecI.value!="" && doc.buscaFechaRecF.value!="" && comparaFechas(doc.buscaFechaRecI.value,doc.buscaFechaRecF.value)==1) {
					valida =1;
					msg = msg + "La Fecha de Recepci\xF3n Inicial debe ser menor o igual a la Fecha de Recepci\xF3n Final "+ "\n";
				}
				if (doc.buscaFechaDocI.value!="" && doc.buscaFechaDocF.value!="" && comparaFechas(doc.buscaFechaDocI.value,doc.buscaFechaDocF.value)==1) {
					valida =1;
					msg = msg + "La Fecha de Documento Inicial debe ser menor o igual a la Fecha de Documento Final "+ "\n";
				}
				if (doc.buscaFechaComI.value!="" && doc.buscaFechaComF.value!="" && comparaFechas(doc.buscaFechaComI.value,doc.buscaFechaComF.value)==1) {
					valida =1;
					msg = msg + "La Fecha de Compromiso Inicial debe ser menor o igual a la Fecha de Compromiso Final "+ "\n";
				}
				if (doc.buscaFechaEveI.value!="" && doc.buscaFechaEveF.value!="" && comparaFechas(doc.buscaFechaEveI.value,doc.buscaFechaEveF.value)==1) {
					valida =1;
					msg = msg + "La Fecha del Evento Inicial debe ser menor o igual a la Fecha del Evento Final "+ "\n";
				}
				if (doc.buscaFechaRecI.value == doc.buscaFechaRecF.value && 
					comparaHorarios(doc.horaRecepcionI.value,doc.minRecepcionI.value,doc.horaRecepcionF.value,doc.minRecepcionF.value)==1 ){
					valida =1;
					msg = msg + "La Fecha/Hora de Recepci\xF3n Inicial debe ser menor o igual a la Fecha/Hora de Recepci\xF3n Final "+ "\n";
				}
				if (detectaCEBusquedaB(doc.buscaEntidad.value) || 
					detectaCEBusquedaB(doc.buscaRemitente.value) || 
					detectaCEBusquedaB(doc.buscaVentanilla.value) || 
					detectaCEBusquedaB(doc.buscaPara.value) || 
					detectaCEBusquedaB(doc.buscaAsunto.value) || 
					detectaCEBusquedaB(doc.buscaExpediente.value) || 
					detectaCEBusquedaB(doc.buscaTipoDoc.value) || 
					detectaCEBusquedaB(doc.buscaTramite.value) || 
					detectaCEBusquedaB(doc.buscaIdDoc.value) || 
					detectaCEBusquedaB(doc.buscaFolio.value) ||
					detectaCEBusquedaB(doc.buscaFirmante.value) ||
					detectaCEBusquedaB(doc.buscaFolioInter.value) ||
					detectaCEBusquedaB(doc.buscaSolicitud.value) ||
					detectaCEBusquedaB(doc.buscaComentario.value) ||
					detectaCEBusquedaB(doc.buscaEvento.value) ||
					detectaCEBusquedaB(doc.buscaPrioridad.value) ||
					detectaCEBusquedaB(doc.buscaTipoAsunto.value) ||
					detectaCEBusquedaB(doc.buscaCaptura.value) ||
					detectaCEBusquedaB(doc.relacionAnexada.value) ){
					valida = 1;
					msg = msg + "No son permitidos los caracteres ( ' & < > ` ´  ) "+ "\n";
				}	
				if (!validaDecimal(doc.avanceAsuntoI.value) || !validaDecimal(doc.avanceAsuntoF.value)){
					valida =1;
					msg = msg + "El formato del Avance no es valido "+ "\n";
				}else if (doc.avanceAsuntoI.value > 100 || doc.avanceAsuntoF.value > 100){
					valida =1;
					msg = msg + "El Avance debe estar entre 0% y 100% "+ "\n";
				}else if(doc.avanceAsuntoI.value!="" && doc.avanceAsuntoF.value!="" && doc.avanceAsuntoI.value > doc.avanceAsuntoF.value){
					valida =1;
					msg = msg + "El Avance inicial debe ser menor o igual al Avance final "+ "\n";
				}
				
				if(doc.bContenido.value == 1 && Trim(doc.buscaSobreContenido.value)==""){
					valida =1;
					msg = msg + "Debe capturar un criterio de Busqueda en Contenido"+ "\n";
				}
				if(valida == 1){
					alert(msg);
				}else{
					doc.submit();
				}

		}

}

function validaDecimal(decimal){

	i = decimal.indexOf('.');
	if (i==0)
		return false;
	else if (i!=-1){
		decimal = decimal.substring(0,i) + decimal.substring(i+1,decimal.length);
		i = decimal.indexOf('.');
		if (i!=-1)
			return false;
		else 
			return true;
	}else 
		return true;
}

function comparaHorarios(horaInicial, minutoInicial, horaFinal, minutoFinal){
	var hi = horaInicial;
	var mi = minutoInicial;
	var hf = horaFinal;
	var mf = minutoFinal;
	
	var valida;
	if (hi < hf){
		valida = -1;
	}else if (hi > hf){
		valida = 1;
	}else {
		if (mi < mf){
			valida = -1;
		}else if (mi > mf){
			valida = 1;
		}else {
			valida = 0;
		}
	}
	return valida;
}

function regresarBuscar(){
	document.buscarC.reset()
    document.buscarC.buscaEntidad.focus()
}
function regresarBC(){
	location.assign('BuscarCampo.jsp');
}
//** Fin BuscarCampo.jsp

//** Inicio Validacion Buscar.jsp

function avanzada(){
	location.assign('Buscar.jsp?ava=1');
}
function activar1(){
	location.assign('Buscar.jsp?ava=1&f=0');
}
function activar2(){
	location.assign('Buscar.jsp?ava=1&f=1');
}
function activar3(){
	location.assign('Buscar.jsp?ava=1&f=2');
}
function activar4(){
	location.assign('Buscar.jsp?ava=1&f=3');
}
function BuscarCampo(){
	doc = document.buscar1;
	valida = 0;
	msg = "";
		
	if (Trim(doc.buscarCampo.value) == "") {
		valida = 1;
		msg = msg + "Debe de capturar algun datos para realizar la busqueda "+ "\n";
	}
	if (detectaCEBusqueda(doc.buscarCampo.value)) {
		valida = 1;
		msg = msg + "No son permitidos los caracteres ( ' % & < > \" ` ´  ) "+ "\n";
	}	
	if (valida == 1){	
		alert(msg);
		return false;
	}else{
		doc.accion.value="buscar";
	}
	doc.submit();
}
function BuscarPorFolio(){
	doc = document.buscar1;
	valida = 0;
	msg = "";
	
	if (Trim(doc.buscarPorFolio.value) == "") {
		valida = 1;
		msg = msg + "Debe de capturar algun datos para realizar la busqueda "+ "\n";
	}
	if (detectaCEBusqueda(doc.buscarPorFolio.value)) {
		valida = 1;
		msg = msg + "No son permitidos los caracteres ( ' % & < > \" ` ´  ) "+ "\n";
	}	
	if (valida == 1){	
		alert(msg);
		return false;
	}else{
		doc.accion.value="buscarFolio";
	}
	doc.submit();
}
function BuscarPorSolicitante(){
	doc = document.buscar1;
	valida = 0;
	msg = "";
	
	if (Trim(doc.buscarPorSolicitante.value) == "") {
		valida = 1;
		msg = msg + "Debe de capturar algun dato para el solicitante "+ "\n";
	}
	if (detectaCEBusqueda(doc.buscarPorSolicitante.value)) {
		valida = 1;
		msg = msg + "No son permitidos los caracteres ( ' % & < > \" ` ´  ) "+ "\n";
	}	
	if (valida == 1){	
		alert(msg);
		return false;
	}else{
		doc.accion.value="buscarSol";
	}
	doc.submit();
}
function BuscarPorArea(){
	doc = document.buscar1;
	valida = 0;
	msg = "";
	
	if (Trim(doc.buscarPorArea.value) == "") {
		valida = 1;
		msg = msg + "Debe de capturar algun datos para realizar la busqueda "+ "\n";
	}
	if (detectaCEBusqueda(doc.buscarPorArea.value)) {
		valida = 1;
		msg = msg + "No son permitidos los caracteres ( ' % & < > \" ` ´  ) "+ "\n";
	}	
	if (valida == 1){	
		alert(msg);
		return false;
	}else{
		doc.accion.value="buscarArea";
	}
	doc.submit();
}
function BuscarPorFecha(){
	doc = document.buscar1;
	valida = 0;
	msg = "";
	
	if (doc.buscarPorFecha.value == "") {
		valida = 1;
		msg = msg + "Debe de capturar algun dato de Fecha "+ "\n";
	}
	if (valida == 1){	
		alert(msg);
		return false;
	}else{
		doc.accion.value="buscarFecha";
	}
	doc.submit();
}//** Fin Validacion Buscar.jsp

//** Validaciones Responder.jsp

var avanceCach;

function firmarDigitalmente()
{
	if(!document.responder.firmaDigital.checked){
       	//alert('Seleccionado --> No seleccionado');
    }
    else{
		//alert('No seleccionado --> seleccionado');
       	ventana=window.open('AutenticaFirma.jsp','usuario','width=300,height=300',true);

       	if(document.responder.autenticado==false)
           	document.responder.firmaDigital.checked=false;
    }
}
function RegresarResp(){
	//history.go(-1);
	doc = document.responder;
	location.assign(doc.retURI.value);
}	
function guardarResp(){	
	doc = document.responder;
	valida = 0;
	msg="";

	if (doc.contestar.value == "") {
		valida =1;
		msg = msg + "Debe capturar una Respuesta a la instrucci\xF3n	"+ "\n";
	}

	if (valida == 1) 
	{
		alert(msg);
	} 
	if (valida != 1)
	{
		doc.accion.value="guardar";
		doc.submit();
	}
}
function terminarInstruccion()
{
	doc=document.responder;

   	if(doc.responderTerminar.checked){
   		// alert('Se ha seleccionado terminar la instrucci\xF3n');
      
   		avanceCach=doc.responderAvance.value;
   		doc.responderAvance.value='100';
   		//doc.firmaDigital.style.display='inline';  
   		//doc.label1.style.display='inline';
	}
   	else{
		//alert('Se ha seleccionado no terminar la instrucci\xF3n');
		doc.responderAvance.value=avanceCach;
		//doc.firmaDigital.style.display='none';
       	//doc.label1.style.display='none';
       	doc.firmaDigital.checked=false;
	}
}

//** Fin validaci\xF3n Responder.jsp

//** Inicio Validaci\xF3n CambioFechaInst.jsp
function regresarCambio(){
	doc = document.cambioFecha;
	location.assign(doc.retURI.value);
}
function solicitarCambio(){
	doc = document.cambioFecha;
	valida = 0;
	msg="";
	
	if (Trim(doc.cambioFechaFin.value) == "") {
		valida =1;
		msg = msg + "- Se debe capturar la Fecha Solicitada "+ "\n";
	}
	if (Trim(doc.comentarioFecha.value) == "") {
		valida =1;
		msg = msg + "- Se debe capturar una Raz\xF3n del Cambio de Fecha	"+ "\n"; 
	}
	if (detectaCE(doc.comentarioFecha.value)) {
		valida =1;
		msg = msg + "- No se permiten caracteres especiales ( < , > , & , \" , ' ) en el campo Raz\xF3n del Cambio de Fecha	"+ "\n"; 
	}
	if (valida == 1) 
	{
		alert(msg);
		return false;
	} 
	if (valida != 1)
	{
		doc.accion.value="cambio";
		doc.submit();
	}
}
function rechazarCambio(){
	doc = document.cambioFecha;
	valida = 0;
	msg="";
	
	if (valida == 1) 
	{
		alert(msg);
	} 
	if (valida != 1)
	{
		doc.rechazar1.value="Re";
		doc.submit();
	}
}
function aceptarCambio(){
	doc = document.cambioFecha;
	valida = 0;
	msg="";
	
	if (detectaCE(doc.comentarioFecha.value)) {
		valida =1;
		msg = msg + "- No se permiten caracteres especiales ( < , > , & , \" , ', `,´) en el campo Raz\xF3n del Cambio de Fecha	"+ "\n"; 
	}
	if (valida == 1) 
	{
		alert(msg);
	} 
	if (valida != 1)
	{
		doc.aceptar1.value="Ac";
		doc.submit();
	}
}
//** Fin Validaci\xF3n CambioFechaInst.jsp

//** Funciones portalPrincipal.jsp

	function goAtencion(){
		location.assign('PortalBorrador.jsp');
	}
	function goAsuntos(){
		location.assign('portalPrincipal.jsp');
	}
	function goAsuntosTr(){
		location.assign('PortalATramite.jsp');
	}
	function goAsuntosTer(){
		location.assign('PortalATerminado.jsp');
	}
	function goTramite(){
		location.assign('PortalTramite.jsp');
	}
	function goAtender(){
		location.assign('PortalAtender.jsp');
	}
	function goTerminadas(){
		location.assign('PortalTerminado.jsp');
	}
	function goRechazadas(){
		location.assign('PortalRechazadas.jsp');
	}
	function goHoy(){
		location.assign('PortalHoy.jsp');
	}
	function goTipoRespuesta(){
		location.assign('PortalTipoRespuesta.jsp');
	}
	function goSolicitada(){
		location.assign('portalAsuntosSolicitados.jsp');
	}
	//function goTipoRespuestaSin(){
	//	location.assign('PortalSinNotificacion.jsp');
	//}

//** Fin Funciones portalPrincipal.jsp

//** Inicio SubFondo.jsp

	function GuardarSubfondo(){
		doc = document.subfondo1;
		valida = 0;
		msg="";
		
		if (doc.subCodigo.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar el C\xF3digo del Subfondo "+ "\n";
		}
		if (doc.subSeccion.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar la secci\xF3n del Subfondo "+ "\n";
		}
		if (valida == 1) 
		{
			alert(msg);
		} 
		else if(document.subfondo1.id_sub.value != "") 
			document.subfondo1.accion.value="cambiar";
		else
		if(document.subfondo1.id_sub.value == "")
			document.subfondo1.accion.value="guardar";
		
		document.subfondo1.submit();
	}
	function setFormFocusSubFondo() {
		doc = document.subfondo1;
		doc.subCodigo.focus(); 
		doc.subCodigo.select();
	}
//** Fin Subfondo.jsp

//** Inicio Seccion.jsp

	function GuardarSeccion(){
		doc = document.seccion1;
		valida = 0;
		msg="";
		
		if (doc.secSubfondo[doc.secSubfondo.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe seleccionar un  SubFondo	"+ "\n";
		}
		if (doc.secSerie.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Serie de la Seccion "+ "\n";
		}
		if (doc.secCodigo.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Codigo de la Secci\xF3n "+ "\n";
		}
		if (valida == 1) 
		{
			alert(msg);
			return false;
		} 
		else if(document.seccion1.id_sec.value != "") 
			document.seccion1.accion.value="cambiar";
		else
		if(document.seccion1.id_sec.value == "")
			document.seccion1.accion.value="guardar";
		
		document.seccion1.submit();
	}
//** Fin Seccion.jsp

//** RegistroCiudadano
	function guardarCiudadano(){
		doc = document.registroCiuForm;
		//valida = 0;
		msg="";
		
		if (doc.reg_nombre.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar tu Nombre(s) "+ "\n";
		}
		if(doc.reg_apellidoP.value == ""){
			valida = 1;
			msg = msg + "Debe de capturar tu Apellido Paterno "+ "\n";
		}
		/*if (doc.reg_dia[doc.reg_dia.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe seleccionar el D\xEDa de tu Fecha de Nacimiento	"+ "\n";
		}
		if (doc.reg_mes[doc.reg_mes.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe seleccionar el Mes de tu Fecha de Nacimiento	"+ "\n";
		}
		if (doc.reg_year[doc.reg_year.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe seleccionar el Año de tu Fecha de Nacimiento	"+ "\n";
		}
		if (doc.reg_sexo[doc.reg_sexo.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe seleccionar tu Sexo	"+ "\n";
		}
		if (doc.reg_ocupacion.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar tu Ocupaci\xF3n "+ "\n";
		}
		if (doc.reg_sector[doc.reg_sector.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe seleccionar un Sector	"+ "\n";
		}
		if (doc.reg_pais[doc.reg_pais.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe seleccionar un Pais	"+ "\n";
		}
		if (doc.reg_estado[doc.reg_estado.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe seleccionar un Estado	"+ "\n";
		}*/
		if (doc.reg_mail.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar tu Correo Electronico "+ "\n";
		}
		if (doc.reg_usuario.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar tu Usuario "+ "\n";
		}
		if (doc.reg_con1.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar tu Contraseña "+ "\n";
		}
		if (doc.reg_con2.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar la confirmaci\xF3n de la Contraseña "+ "\n";
		}
		if (valida == 1) 
		{
			alert(msg);
			valida =0;
			return false;
		}
		else if(valida == 2){
			alert("Su solicitud ya fue enviada");
		}
		else{
			doc.accion.value="guardar";
			doc.submit();
			valida =2;
		}
	}
	
	function guardarCiudadanoUCT(){
		doc = document.registroCiuFormUCT;
		valida = 0;
		msg="";
		
		if (doc.reg_nombre.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar tu Nombre(s) "+ "\n";
		}
		if(doc.reg_apellidoP.value == ""){
			valida = 1;
			msg = msg + "Debe de capturar tu Apellido Paterno "+ "\n";
		}
		//if (doc.reg_dia[doc.reg_dia.selectedIndex].value == -1) {
		//	valida =1;
		//	msg = msg + "Debe seleccionar el D\xEDa de tu Fecha de Nacimiento	"+ "\n";
		//}
		//if (doc.reg_mes[doc.reg_mes.selectedIndex].value == -1) {
		//	valida =1;
		//	msg = msg + "Debe seleccionar el Mes de tu Fecha de Nacimiento	"+ "\n";
		//}
		//if (doc.reg_year[doc.reg_year.selectedIndex].value == -1) {
		//	valida =1;
		//	msg = msg + "Debe seleccionar el Año de tu Fecha de Nacimiento	"+ "\n";
		//}
		//if (doc.reg_sexo[doc.reg_sexo.selectedIndex].value == -1) {
		//	valida =1;
		//	msg = msg + "Debe seleccionar tu Sexo	"+ "\n";
		//}
		//if (doc.reg_ocupacion.value == "") {
		//	valida = 1;
		//	msg = msg + "Debe de capturar tu Ocupaci\xF3n "+ "\n";
		//}
		//if (doc.reg_sector[doc.reg_sector.selectedIndex].value == -1) {
		//	valida =1;
		//	msg = msg + "Debe seleccionar un Sector	"+ "\n";
		//}
		//if (doc.reg_pais[doc.reg_pais.selectedIndex].value == -1) {
		//	valida =1;
		//	msg = msg + "Debe seleccionar un Pais	"+ "\n";
		//}
		//if (doc.reg_estado[doc.reg_estado.selectedIndex].value == -1) {
		//	valida =1;
		//	msg = msg + "Debe seleccionar un Estado	"+ "\n";
		//}
		if (doc.reg_mail.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar tu Correo Electronico "+ "\n";
		}
		if (doc.reg_usuario.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar tu Usuario "+ "\n";
		}
		if (doc.reg_con1.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar tu Contraseña "+ "\n";
		}
		if (doc.reg_con2.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar la confirmaci\xF3n de la Contraseña "+ "\n";
		}
		if (valida == 1) 
		{
			alert(msg);
			valida =0;
			return false;
		}
		else if(valida == 2){
			alert("Su solicitud ya fue enviada");
		}else{
			doc.accion.value="guardar";
			doc.submit();
			valida =2;
		}
	}
	
	function limpiarRegistro(){
		document.registroCiuForm.reset()
    	document.registroCiuForm.reg_nombre.focus()
	}
	function limpiarRegistroUCT(){
		document.registroCiuFormUCT.reset()
    	document.registroCiuFormUCT.reg_nombre.focus()
	}
	function CancelarRegistroCiu(){
		location.assign('index.jsp');
	}
	
	function guardarSolicitud(){
		doc = document.consultaForm;
		//valida = 0;
		msg="";
		
		if (doc.solicitud.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Detalle de la Solicitud "+ "\n";
		}
		if (valida == 1) 
		{
			alert(msg);
			valida = 0;
		}else if(valida == 2){
			alert("Su solicitud ya fue enviada");
		}else{
			if(valida == 0){
				doc.accion.value="guardar";
				doc.submit();
				valida = 2;
			}
		}
		
	}
	
	function guardarSolicitudUCT(){
		doc = document.SolUCT;
		//valida = 0;
		msg="";
		
		if (doc.sol_usuario[doc.sol_usuario.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe seleccionar un Usuario	"+ "\n";
		}
		if (doc.sol_asunto.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Asunto "+ "\n";
		}
		if (doc.solicitud.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Detalle de la Solicitud "+ "\n";
		}
		if (valida == 1) 
		{
			alert(msg);
			valida = 0;
		}else if(valida == 2){
			alert("Su solicitud ya fue enviada")
		}
		else{
			doc.accion.value="guardar";
			doc.submit();
			valida = 2;
		}
		
	}
	
	function guardarImportarCM(){
		doc = document.insertarCM;
		//valida = 0;
		msg="";
		
		if (doc.solicitud_archivo.value == "") {
			valida = 1;
			msg = msg + "Debe de anexar un archivo"+ "\n";
		}
		if (valida == 1) 
		{
			valida = 0;
			alert(msg);
		}else if(valida == 2){
			alert("Su solicitud ya fue enviada");
		}else{
			doc.accion.value="guardar";
			valida = 2;
			doc.submit();
		}
		
	}
	
	function consultaBuscar(){
		doc = document.consultaPublicaForm;
		valida = 0;
		msg="";
		
		if (doc.bi.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Fecha de Inicio "+ "\n";
		}
		if (doc.bf.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Fecha Fin "+ "\n";
		}
		if (valida == 1) 
		{
			alert(msg);
		}else{
			doc.accion.value="consultar";
			doc.submit();
			valida = 2;
		}
	}
	function Imprimir(){
		doc = document.consultaForm;
		valida = 0;
		msg="";
		if (doc.solicitud.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Nombre de la Solicitud "+ "\n";
		}
		if (valida == 1) 
		{
			alert(msg);
		}else{
			print();
		}
	}
	function Imprimir2(){
		doc = document.seguimientoForm;
		print();
	}
	function Imprimir3(){
		doc = document.confirmacionUCT;
		print();
	}
	function Imprimir4(){
		doc = document.seguimientoFormUCT;
		print();
	}
	function Imprimir5(){
		doc = document.confirmacion;
		print();
	}
	function Imprimir10(){
		doc = document.seguimientoFormC;
		print();
	}
//** Fin RegistroCiudadano

//**Busqueda de campo en combos
function ActuliazaCorreoA(opcion)
{
	var forma=document.usuarioForm;
	var cadena="";
	if(opcion.options[opcion.selectedIndex].value!="-1")
	{	
		cadena = opcion.options[opcion.selectedIndex].value.substring(0,(opcion.options[opcion.selectedIndex].value.indexOf('|')));
		forma.usuarioNombre.value = cadena;
		cadena = opcion.options[opcion.selectedIndex].value.substring((opcion.options[opcion.selectedIndex].value.indexOf('|')+1),(opcion.options[opcion.selectedIndex].value.indexOf('~')));
		forma.uid.value = cadena;
		cadena = opcion.options[opcion.selectedIndex].value.substring((opcion.options[opcion.selectedIndex].value.indexOf('~')+1), opcion.options[opcion.selectedIndex].value.length);
		forma.usuarioEmail.value = cadena;
	}
	else{
		forma.usuarioEmail.value="";
		forma.uid.value = "";
		forma.usuarioNombre.value = "";
	}
}
function ActuliazaCorreo(opcion)
{
	var forma=document.usuarioForm;
	var cadena="";
	if(opcion.options[opcion.selectedIndex].value!="-1")
	{	
		cadena = opcion.options[opcion.selectedIndex].value.substring(0,(opcion.options[opcion.selectedIndex].value.indexOf('|')));
		forma.usuarioNombre.value = cadena;
		cadena = opcion.options[opcion.selectedIndex].value.substring((opcion.options[opcion.selectedIndex].value.indexOf('|')+1),(opcion.options[opcion.selectedIndex].value.indexOf('~')));
		forma.uid.value = cadena;
		cadena = opcion.options[opcion.selectedIndex].value.substring((opcion.options[opcion.selectedIndex].value.indexOf('~')+1), opcion.options[opcion.selectedIndex].value.length);
		forma.usuarioEmail.value = cadena;
	}
	else{
		forma.usuarioEmail.value="";
		forma.uid.value = "";
		forma.usuarioNombre.value = "";
	}
}
var digitos=10 //cantidad de digitos buscados 
var puntero=0 
var buffer=new Array(digitos) //declaraci\xF3n del array Buffer 
var cadena="" 
var cadena2="" 

function buscar_op(obj){
	var forma=document.usuarioForm;
   	var letra = String.fromCharCode(event.keyCode)
   	if(puntero >= digitos){ 
    	cadena=""; 
       	puntero=0; 
    } 
   	//si se presiona la tecla ENTER, borro el array de teclas presionadas y salto a otro objeto... 
   	if (event.keyCode == 13){ 
    	borrar_buffer(); 
       	//if(objfoco!=0) objfoco.focus(); //evita foco a otro objeto si objfoco=0
		var cad="";
		if(obj.options[obj.selectedIndex].value!="-1")
		{	
			cad = obj.options[obj.selectedIndex].value.substring(0,(obj.options[obj.selectedIndex].value.indexOf('|')));
			forma.usuarioNombre.value = cad;
			cad = obj.options[obj.selectedIndex].value.substring((obj.options[obj.selectedIndex].value.indexOf('|')+1),(obj.options[obj.selectedIndex].value.indexOf('~')));
			forma.uid.value = cad;
			cad = obj.options[obj.selectedIndex].value.substring((obj.options[obj.selectedIndex].value.indexOf('~')+1), obj.options[obj.selectedIndex].value.length);
			forma.usuarioEmail.value = cad;
		}
		else{
			forma.usuarioEmail.value="";
			forma.uid.value = "";
			forma.usuarioNombre.value = "";
		}
    } 
   	//sino busco la cadena tipeada dentro del combo... 
   	else{ 
       	buffer[puntero]=letra; 
       	//guardo en la posicion puntero la letra tipeada 
       	cadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array 
       	puntero++; 

       	//barro todas las opciones que contiene el combo y las comparo la cadena... 
       	for (var opcombo=0;opcombo < obj.length;opcombo++){ 
          	if(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ 
          		obj.selectedIndex=opcombo; 
        	} 
       	} 
    } 
   	event.returnValue = false; //invalida la acci\xF3n de pulsado de tecla para evitar busqueda del primer caracter 
}

function buscar_op1(obj){
   	var letra = String.fromCharCode(event.keyCode)
   	if(puntero >= digitos){ 
    	cadena=""; 
       	puntero=0; 
    } 
   	//si se presiona la tecla ENTER, borro el array de teclas presionadas y salto a otro objeto... 
   	if (event.keyCode == 13){ 
    	borrar_buffer(); 
       	//if(objfoco!=0) objfoco.focus(); //evita foco a otro objeto si objfoco=0
    } 
   	//sino busco la cadena tipeada dentro del combo... 
   	else{ 
       	buffer[puntero]=letra; 
       	//guardo en la posicion puntero la letra tipeada 
       	cadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array 
       	puntero++; 

       	//barro todas las opciones que contiene el combo y las comparo la cadena... 
       	for (var opcombo=0;opcombo < obj.length;opcombo++){ 
          	if(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ 
          		obj.selectedIndex=opcombo; 
        	} 
       	} 
    } 
   	event.returnValue = false; //invalida la acci\xF3n de pulsado de tecla para evitar busqueda del primer caracter 
}


function borrar_buffer(){ 
   	//inicializa la cadena buscada 
    cadena=""; 
    puntero=0; 
} 
//**


//** Buscar por Asunto
function buscarPorAsunto(){ 
   	doc=document.porAsunto;
   	valida = 0;
	msg="";
	
	if(	doc.buscarRecepcion.value == "" && 
		doc.buscarArea.value == -1 && doc.buscarAsunto.value == "" && 
		doc.buscarTDocto.value == "" && doc.buscarFechaGen.value == "" &&
		doc.buscarFechaVen.value == ""){
		
		valida = 1
		alert("Debe de Capturar alg\xFAn dato");
		return false;
	}
	if(doc.buscarFechaGen.value == "" && doc.buscarFechaVen.value != ""){
		valida = 1
		alert("Debe Capturar la Fecha de Inicio");
		return false;
	}
	if(doc.buscarFechaGen.value != "" && doc.buscarFechaVen.value == ""){
		valida = 1
		alert("Debe Capturar la Fecha Fin");
		return false;
	}
	if(valida != 1){
		doc.submit();
	}
} 

//** Fin Buscar por Asunto

//** Configuracion
function guardarConf(){
	doc=document.confForm;
   	//valida = 0;
	msg="";
	
	if(doc.confDuracion.value == ""){
		valida =1;
		msg = msg + "Debe Capturar el n\xFAmero de d\xEDas	"+ "\n";
	}
	if(doc.confAmarillo.value == ""){
		valida =1;
		msg = msg + "Debe Capturar el porcentaje para calcular el semaforo amarrillo	"+ "\n";
	}
	if(doc.confAmarillo.value > 100){
		valida =1;
		msg = msg + "El Porcentaje debe ser menor a 100%	"+ "\n";
	}
	if (quitaNumeros(doc.confDuracion.value) != "") {
		valida =1;
		msg = msg + "El n\xFAmero de Dias no es v\xE1lido "+ "\n";
	}
	if (quitaNumeros(doc.confAmarillo.value) != "") {
		valida =1;
		msg = msg + "El porcentaje para calcular el semaforo amarrillo no es v\xE1lido "+ "\n";
	}
	if(doc.registros.value < 1){
		valida =1;
		msg = msg + "El n\xFAmero de Registros debe ser mayor a cero"+ "\n";
	}
	if(doc.paginas.value < 1){
		valida =1;
		msg = msg + "El n\xFAmero de Paginas debe ser mayor a cero"+ "\n";
	}
	if (quitaNumeros(doc.registros.value) != "") {
		valida =1;
		msg = msg + "El n\xFAmero de Registros no es v\xE1lido "+ "\n";
	}
	if (quitaNumeros(doc.paginas.value) != "") {
		valida =1;
		msg = msg + "El n\xFAmero de Paginas no es v\xE1lido "+ "\n";
	}
	if (valida == 1) 
	{
		alert(msg);
		valida = 0;
	}else if(valida == 2){
		alert("Su solicitud ya fue enviada")
	}
	else{
		if(doc.id_conf.value != "")
			doc.accion.value="cambiar";
		if(doc.id_conf.value == "")
			doc.accion.value="guardar";
		doc.submit();
		valida = 2;
	}
}
//** fin configuraciones

//** Actualizar los datos del ciudadano, denotro del portal
function EditarSolicitud(){
	doc=document.FormEditar;
   	//valida = 0;
	msg="";
	
	if (doc.reg_nombre.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar tu Nombre/s "+ "\n";
	}
	if (valida == 1) 
	{
		alert(msg);
		valida = 0;
	}else if(valida == 2){
		alert("Su solicitud ya fue enviada");
	}else{
		doc.accion.value="editar";
		doc.submit();
	}
}

function EditarPassword(){
	doc=document.formPassword;
	msg="";
	
	if (doc.pass1.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Password Anterior "+ "\n";
	}
	if (doc.pass2.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Password Nuevo "+ "\n";
	}
	if (doc.pass3.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Confirmaci\xF3n del Password Nuevo "+ "\n";
	}
	if (valida == 1) 
	{
		alert(msg);
		valida = 0;
	}else if(valida == 2){
		alert("Su solicitud ya fue enviada");
	}else{
		doc.accion.value="editar";
		doc.submit();
	}
}
//** Fin actualizar

//** funci\xF3n de validacion de area
function guardarArea() { 

	doc = document.Area;
	//valida = 0;
	msg="";

//	else{
		mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar'
		if(detectaCE(doc.area.value) || detectaCE(doc.areaClave.value) || detectaCE(doc.areaDescripcion.value)){
			if (confirm(mensaje)){

				doc.area.value	= quitaCE(doc.area.value);
				doc.areaClave.value	= quitaCE(doc.areaClave.value);
				doc.areaDescripcion.value	= quitaCE(doc.areaDescripcion.value);
				
				doc.accion.value="guardar";
//				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			doc.accion.value="guardar";
//			doc.submit();
		}
	if (Trim(doc.area.value) =="") {
		valida =1;
		msg = msg + " Debe capturar el nombre de la Unidad	"+ "\n";
	}
	if (Trim(doc.areaClave.value) =="") {
		valida =1;
		msg = msg + " Debe capturar la Clave de la Unidad	"+ "\n";
	}
	if(doc.bandera.value==1){
		if(doc.hora_entrada[doc.hora_entrada.selectedIndex].value == -1){
			valida =1;
			msg = msg + " Debe capturar la Hora de Entrada	"+ "\n";
		}
		if(doc.min_entrada[doc.min_entrada.selectedIndex].value == -1){
			valida =1;
			msg = msg + " Debe capturar los Minutos de Entrada	"+ "\n";
		}
		if(doc.hora_salida[doc.hora_salida.selectedIndex].value == -1){
			valida =1;
			msg = msg + " Debe capturar la Hora de Salida	"+ "\n";
		}
		if(doc.min_salida[doc.min_salida.selectedIndex].value == -1){
			valida =1;
			msg = msg + " Debe capturar los Minutos de Salida	"+ "\n";
		}
	}
	if (Trim(doc.areaCtrlEntrada.value) =="") {
		valida =1;
		msg = msg + " Debe capturar el Consecutivo	"+ "\n";
	}
	if (Trim(doc.areaCtrlSalida.value) =="") {
		valida =1;
		msg = msg + " Debe capturar el Año"+ "\n";
	}
	if(doc.bandera.value==1){
		if(doc.hora_entrada[doc.hora_entrada.selectedIndex].value >= doc.hora_salida[doc.hora_salida.selectedIndex].value){
			if (doc.hora_entrada[doc.hora_entrada.selectedIndex].value == doc.hora_salida[doc.hora_salida.selectedIndex].value){
				if (doc.min_entrada[doc.min_entrada.selectedIndex].value >= doc.min_salida[doc.min_salida.selectedIndex].value){
					valida = 1;
					msg = msg + " La hora de entrada debe ser menor a la de salida	"+ "\n";
				}
			}
			else{
				valida = 1;
				msg = msg + " La hora de entrada debe ser menor a la de salida	"+ "\n";
			}
		}
	}
	if (Trim(quitaPuntos(doc.area.value)) == "" && doc.area.value!= "") {
		valida =1;
		msg = msg + " El Nombre de la UA no es v\xE1lido "+ "\n";
	}
	if (Trim(quitaPuntos(doc.areaClave.value)) == "" && doc.areaClave.value!= "") {
		valida =1;
		msg = msg + " La Clave de la UA no es v\xE1lida "+ "\n";
	}
	if (Trim(quitaPuntos(doc.areaDescripcion.value)) == "" && doc.areaDescripcion.value!= "") {
		valida =1;
		msg = msg + " La Descripci\xF3n de la UA no es v\xE1lida "+ "\n";
	}
	if (quitaNumeros(doc.areaCtrlEntrada.value) != "") {
		valida =1;
		msg = msg + " El Consecutivo de la UA no es v\xE1lido "+ "\n";
	}
	if (quitaNumeros(doc.areaCtrlSalida.value) != "" || doc.areaCtrlSalida.value.length!=4 ) {
		valida =1;
		msg = msg + " El Año de la UA no es v\xE1lido "+ "\n";
	}
	if (valida == 1) 
	{
		alert(msg);
		valida=0;
		return false;
	}else if(valida == 2){
		alert("Su solicitud ya fue enviada");
		return false;
	}else{
		valida=2;
		doc.submit();
	}
//	}
}
//** fin funci\xF3n de validacion de area

//** funci\xF3n para listUserUR
function reloadListUserUR() {
	doc = document.listUserUA;
	doc.accion.value="reload";
	doc.submit();
}

function RemoveSelected(sel, nombres, ids)
{
	var sl = sel.selectedIndex;
	var nom = nombres.value;
	var id = ids.value;
	alert("nom="+nom);
	var quitanto = nom.split(',');
	alert("="+quitanto);
	if (sl != -1)
	{
		for(var i=0; i<sel.options.length; i++){
			if (sel.options[i].selected){
				alert(sel.options[i].text); 
				sel.options[i] = null; 
				i--; 
			} 
		} 
	}
	else 
		alert('Por favor seleccione el campo a eliminar de esta lista.'); 
} 

function addSelected(sel,origen,sel2){

	var msg = "";
	if (origen.selectedIndex != -1){
		
		for(i=0; i<origen.options.length; i++){ 
			
			if (origen.options[i].selected){
				
				band1 = true; 
				band2 = true;
				for(j=0; j<sel.options.length; j++){
					if (origen.options[i].text == sel.options[j].text){
						band1 = false;
						msg = msg + origen.options[i].text + ",\n";
						break;
					}
				}
				if (band1){
					for(j=0; j<sel2.options.length; j++){
						if (origen.options[i].text == sel2.options[j].text){
							band2 = false;
							msg = msg + origen.options[i].text + ",\n";
							break;
						}
					}
				}
				if (band1 && band2){
					sel.options[sel.options.length] = new Option (origen.options[i].text, origen.options[i].value);
				}
			} 
		}
		if(msg!="")
			alert(msg+ "ya existen"); 
	}
	else 
		alert('Por favor seleccione el campo a agregar de esta lista.'); 
}


function addSelectedIds(sel,origen)
{ 
	var sl = origen.selectedIndex; 
	var rt="";
	if (sl != -1)
	{
		for(var i=0; i<origen.options.length; i++)
		{ 
			if (origen.options[i].selected)
			{
				if(sel.options.length>0)
				{
					rt = sel.options[0].value;
					if (rt != "")
					{
						var encontrado = -1;
						for (j=0;j<sel.options.length;j++)
						{
							if (encontrado == -1)
							{
								if (origen.options[i].value == sel.options[j].value )
								{
									alert(origen.options[i].value+" ya existe");
									encontrado = -2;
									break;
								}
								else if ( i< sel.options[j].value )
								{
									encontrado = j;
									break;
								}
							}
						}
						if (encontrado > -1)
						{
							for(k=sel.length;k>encontrado;k--)
							{
								
								sel.options[k] = new Option (sel.options[k-1].value,sel.options[k-1].value); 
							}
							sel.options[encontrado] = new Option (origen.options[i].value, i); 
						}
						else if (encontrado == -1)
							sel.options[sel.length] = new Option (origen.options[i].value,i); 
					}
					else
						sel.options[sel.length-1] = new Option (origen.options[i].value,i);
				}
				else{
					sel.options[0] = new Option (origen.options[i].value,i);
				}
			} 
		} 
	}
	else 
		alert('Por favor seleccione el campo a agregar de esta lista.'); 
}

function RemoveAllClick()
{
	if (confirm("Est\xE1 usted seguro de que desea Eliminar los Registros?")) 
	{    
		document.listUserUA.listTO.options.length=0;
		document.listUserUA.listCC.options.length=0;
		document.listUserUA.tmpSendToRef.value="";
		document.listUserUA.tmpCopyToRef.value="";
		document.listUserUA.idsTO.value="";
		document.listUserUA.idsCC.value="";
	} 
}	

function selectToString(field){

	var cadena = "";
	var div = ",";
	
	for (i=0; i<field.options.length; i++){
		cadena = cadena + field.options[i].text + div;
	}
	return cadena;
}
function StringTokenizer(str, delim){
	this.str = str;
	this.delim = delim;
	
	this.getTokens = getTokens;
	this.hasMoreElements = hasMoreElements;
	this.nextElement = nextElement;
	this.tokens = this.getTokens();
	this.actuel = 0;
}

function getTokens(){
	var tokens = new Array();
   	var nextToken;
 
   	if (this.str.indexOf(this.delim) < 0) {
   		tokens[0] = this.str;
     	return tokens;
   	}
 
   	start = 0;
   	end = this.str.indexOf(this.delim, start);
 
   	var i = 0;
   
   	while (this.str.length - start >= 1) {
    	nextToken = this.str.slice(start, end);
     	start = end + 1;
     	if (this.str.indexOf (this.delim, start + 1) < 0) 
       		end = this.str.length;
     	else
       		end = this.str.indexOf (this.delim, start + 1);
 
     	nextToken = trim (nextToken);
 
     	while (nextToken.slice(0, this.delim.length) == this.delim) 
       		nextToken = nextToken.slice(this.delim.length);
 
     	nextToken = trim(nextToken);
 
     	if (nextToken == "") continue;
     	tokens[i++] = nextToken;
   	}
   
   	return tokens;
}
function hasMoreElements() {
	return this.actuel < this.tokens.length;
}
function nextElement() {
	if (this.actuel >= this.tokens.length)
    	return null;
   	else {
   		var r = this.tokens[this.actuel];
    	this.actuel++;
    	return r;
   	}
}
function countTokens() {
	return this.tokens.length;
}
function trim (strToTrim) {
	return(strToTrim.replace(/^\s+|\s+$/g, ''));
}

function selectToIdString(field){

	var cadena = "";
	var div = ",";
	
	for (i=0; i<field.options.length; i++){
		cadena = cadena+field.options[i].value+div;
	}
	//alert(cadena);
	return cadena;
}
function OpenWindowList(){
	var url='listUserUR.jsp';
    var ventanaImpresion=window.open(url,'','height=400,width=800,status=yes,toolbar=no,menubar=no,location=no',true);
}
function aceptarList(){
		
	var form = document.listUserUA;
  	
	window.opener.document.forms[0].asuntoPara.value = form.tmpSendToRef.value;
	window.opener.document.forms[0].asuntoCC.value = form.tmpCopyToRef.value;
	
	form.idsTO.value = Trim(form.idsTO.value);
	cadenaIds = form.idsTO.value;
	if (form.idsTO.value!="" && cadenaIds.charAt(0)!=','){
		form.idsTO.value = ',' + form.idsTO.value;
	}
	window.opener.document.forms[0].asuntoIdsPara.value = form.idsTO.value;

	form.idsCC.value = Trim(form.idsCC.value);
	cadenaIds = form.idsCC.value;
	if (form.idsCC.value!="" && cadenaIds.charAt(0)!=','){
		form.idsCC.value = ',' + form.idsCC.value;
	}
	window.opener.document.forms[0].asuntoIdsCC.value = form.idsCC.value;

	opener.hay_hija = new Boolean(false);
	opener.hija = null;
	window.opener.document.forms[0].accion.value = "EditDest";
	window.opener.document.forms[0].setFoco.value = 'asunto';
	window.opener.document.Asunto.submit();
	window.close();
}



//** Fin funci\xF3n para listUserUR

//** funci\xF3n destinatarios externo
function reloadListUserURE() {
	doc = document.listUserUAE;
	doc.accion.value="reload";
	doc.submit();
}
function aceptarListExt(){
		
	var form = document.listUserUAE; 
  	//parent.window.document.forms[0].asuntoParaE.value = form.tmpSendToRef.value;
	//parent.window.document.forms[0].asuntoIdsParaE.value = form.idsTO.value;
	//parent.window.document.getElementById("pop9").style.visibility="hidden";
	
	window.opener.document.forms[0].asuntoParaE.value = form.tmpSendToRef.value;

	form.idsTO.value = Trim(form.idsTO.value);
	cadenaIds = form.idsTO.value;
	//alert(cadenaIds);
	//alert(cadenaIds.charAt(0));
	if (form.idsTO.value!="" && cadenaIds.charAt(0)!=','){
		form.idsTO.value = ',' + form.idsTO.value;
	}
	window.opener.document.forms[0].asuntoIdsParaE.value = form.idsTO.value;

	opener.hay_hija = new Boolean(false);
	opener.hija = null;
	window.opener.document.forms[0].accion.value = "EditDest";	
	window.opener.document.forms[0].setFoco.value = 'asunto';
	window.opener.document.Asunto.submit();
	window.close();
}
function guardarDestino() {
	doc = document.DestExtForm;
	valida = 0;
	msg="";

	if (Trim(doc.usuarioNombre.value) =="") {
		valida =1;
		msg = msg + "Debe capturar el Nombre	"+ "\n";
	}
	if (doc.usuarioArea[doc.usuarioArea.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar un \xE1rea	"+ "\n";
	}

	if (Trim(doc.usuarioDesc.value) =="") {
		valida =1;
		msg = msg + "Debe capturar Descripcion	"+ "\n";
	}
	if (Trim(doc.usuarioEmail.value) =="") {
		valida =1;
		msg = msg + "Debe capturar el Correo Electr\xF3nico	"+ "\n";
	}
	if (!isCorreo(Trim(doc.usuarioEmail.value))) {
		valida =1;
		msg = msg + "El Correo Electr\xF3nico es inv\xE1lido	"+ "\n";
	}
	if (!isTelefono(Trim(doc.usuarioTelefono.value))) {
		valida =1;
		msg = msg + "El n\xFAmero de Tel\xE9fono es inv\xE1lido	"+ "\n";
	}

	
	if (valida == 1) 
	{
		alert(msg);
		return false;
	} 
	if (valida != 1)
	{
		mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar'

		if(detectaCE(doc.usuarioNombre.value) || detectaCE(doc.usuarioDesc.value)){

			if (confirm(mensaje)){

				doc.usuarioNombre.value	= quitaCE(doc.usuarioNombre.value);
				doc.usuarioDesc.value	= quitaCE(doc.usuarioDesc.value);
	
				doc.aux.value	= quitaCE(doc.aux.value);
				
				if(doc.id_usuario.value != "")
					doc.accion.value="cambiar";
				if(doc.id_usuario.value == "")
					doc.accion.value="guardar";
				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			if(doc.id_usuario.value != "")
				doc.accion.value="cambiar";
			if(doc.id_usuario.value == "")
				doc.accion.value="guardar";
			doc.submit();
		}	
	}
}
//** funcion destinatario externos
// Funsiones para generar la alerta de fin de sesion...

timer = setTimeout("timer_set(4)",86500000);
function timer_set(opcion) {

	bloqueaBackHistory();
	
    if (opcion == 1){
		timer = setTimeout("timer_accion()",2700000);
		//timer = setTimeout("timer_accion()",20000);
		//alert("timer=" + timer);
	}
	else {
		if (opcion == 2){
		    clearTimeout(timer);
		    //alert('Timer Reset');
			timer_set(1);
		}
		else{
			if(opcion == 3){
				timer_set(1);
			    clearTimeout(timer);
			}
		}
	}	
}

function timer_accion() {
	timer_set(1);
    clearTimeout(timer);
	alert('                                    ** Sesi\xF3n terminada **\n\nSu tiempo de sesi\xF3n ha terminado debido a un per\xEDodo de inactividad prolongado');	
	location.href='index.jsp';
}

function timer_load(){
	timer_set(1);
}

function timer_reload(){
	timer_set(2);
}

function timer_cancel(){
	timer_set(3);
}

// Funciones Trim()

function TrimLeft( str ) {
	var resultStr = "";
	var i = len = 0;

	if (str.length == 0) 
		resultStr = "";
	else { 
		len = str.length;
		while ((i <= len) && (str.charAt(i) == " "))
			i++;
		resultStr = str.substring(i, len);
	}
	return resultStr;
}

function TrimRight( str ) {
	var resultStr = "";
	var i = 0;

	if (str.length == 0) 
		resultStr = "";
	else {
		i = str.length - 1;
		while ((i >= 0) && (str.charAt(i) == " "))
			i--;

		resultStr = str.substring(0, i + 1);
	}
	return resultStr; 
}

function Trim( str ) {
	var resultStr = "";

	resultStr = TrimLeft(str);
	resultStr = TrimRight(resultStr);

	return resultStr;
}

/**********************************************************************************ARCHIVO EXPEDIENTE*/
//** Inicio SubFondo.jsp

	function GuardarSubfondoA(){
		doc = document.subfondo1A;
		//valida = 0;
		msg="";


			mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar';
			if( detectaCE(doc.subCodigo.value)  || detectaCE(doc.subSeccion.value) || detectaCE(doc.justif.value) ){
				if(confirm(mensaje)){
					doc.subCodigo.value	= quitaCE(doc.subCodigo.value);
					doc.subSeccion.value	= quitaCE(doc.subSeccion.value);
					doc.justif.value	= quitaCE(doc.justif.value);

					if(document.subfondo1A.id_sub.value != "") 
						document.subfondo1A.accion.value="cambiar";
					if(document.subfondo1A.id_sub.value == "")
						document.subfondo1A.accion.value="guardar";
				}
				else
					document.subfondo1A.accion.value="";
			}
			else{
				if(document.subfondo1A.id_sub.value != "") 
					document.subfondo1A.accion.value="cambiar";
				if(document.subfondo1A.id_sub.value == "")
					document.subfondo1A.accion.value="guardar";
			}

		if (doc.fondo[doc.fondo.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar un Fondo	"+ "\n";
		}
		
		if (Trim(doc.subCodigo.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Nombre "+ "\n";
		}
		if (Trim(doc.subSeccion.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Descripci\xF3n"+ "\n";
		}
		if (Trim(doc.clave.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Clave "+ "\n";
		}
		if (doc.inactivo.checked == true) {
			if (Trim(doc.fecinact.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Fecha de Inactividad"+ "\n";
			}
/*			if (Trim(doc.justif.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Justificaci\xF3n de Inactividad"+ "\n";
			}*/
		}					
		if (valida == 1) 
		{
			alert(msg);
			valida=0;
			return false;
		}else if(valida == 2){
			alert("Su solicitud ya fue enviada");
			return false;
		}else{
			valida=2;
			document.subfondo1A.submit();
		}
	}




	function setFormFocusSubFondoA() {
		doc = document.subfondo1A;
		doc.clave.focus(); 
		doc.clave.select();
	}
//** Fin Subfondo.jsp

//** Inicio Valoraciones.jsp
	function GuardarValoraciones(){
		doc = document.valoracionf;
		//valida = 0;
		msg="";
		
		var cadena="";
		for (var i = 0; i < doc.elements.length; i++) 
		{  
			if (doc.elements[i].type == 'checkbox') 
			{      
				if (doc.elements[i].name == 'agregar') 
				{       
					if (doc.elements[i].checked == true)
					{
						valor = doc.elements[i].value;
						if(valor != "") 
							cadena = cadena +valor + ' ';        
					}
				}
			}
		}
	if (cadena == ""){
		valida = 1;
		msg = msg + "Debe de seleccionar por lo menos uno de los Valores"+ "\n";
	}
//		if (valida != 1){
			mensaje = "Algunos de los campos tienen caracteres inv\xE1lidos (&, \", <, >, ', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar";
			if( detectaCE(doc.subCodigo.value)   || detectaCE(doc.subSeccion.value) || detectaCE(doc.justif.value) ) {
				if (confirm(mensaje)){
					doc.subCodigo.value		= 	quitaCE(doc.subCodigo.value);
					doc.subSeccion.value	= 	quitaCE(doc.subSeccion.value);
					doc.justif.value		= 	quitaCE(doc.justif.value);
					
					if(document.valoracionf.id_sub.value != "") 
						document.valoracionf.accion.value="cambiar";
					if(document.valoracionf.id_sub.value == "")
						document.valoracionf.accion.value="guardar";
				}
			 }
			else{
				if(document.valoracionf.id_sub.value != "") 
					document.valoracionf.accion.value="cambiar";
				if(document.valoracionf.id_sub.value == "")
					document.valoracionf.accion.value="guardar";
			}
	//	}
		
		if (Trim(doc.subCodigo.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Nombre"+ "\n";
		}
		if (Trim(doc.subSeccion.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Descripcion"+ "\n";
		}
		if (Trim(doc.clave.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Clave"+ "\n";
		}
		if (valida == 1) 
		{
			alert(msg);
			valida=0;
			return false;
		}else if(valida == 2){
			alert("Su solicitud ya fue enviada");
			return false;
		}else{
			valida=2;
			doc.submit();
		}		
		
	}
	
	
	
// funcion setFocusValoreaciones
function setFormFocusValoraciones() {
	doc = document.valoracionf;
	doc.clave.focus(); 
	doc.clave.select();
}
//** Fin Valoraciones.jsp


//** Inicio Subserie.jsp
	function GuardarSubfondoAS(){
		doc = document.subfondo1AS;
		valida = 0;
		msg="";
		
		if (Trim(doc.subCodigo.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Nombre "+ "\n";
		}
		if (Trim(doc.subSeccion.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Descripci\xF3n "+ "\n";
		}
		if (Trim(doc.clave.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Clave "+ "\n";
		}		
		if (valida == 1) 
		{
			alert(msg);
			return false;
		} 
		else if(document.subfondo1AS.id_sub.value != "") 
			document.subfondo1AS.accion.value="cambiar";
		else
		if(document.subfondo1AS.id_sub.value == "")
			document.subfondo1AS.accion.value="guardar";
		
		document.subfondo1AS.submit();
	}
	
	function setFormFocusSubFondoAS() {
		doc = document.subfondo1AS;
		doc.clave.focus(); 
		doc.clave.select();
	}
//** Fin Subserie.jsp


//** Inicio Expediente.jsp
	function GuardarExpediente(){
		doc = document.expedientef;
		//valida = 0;
		msg="";
		

//		else {
			mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar'
			if(	detectaCE(document.expedientef.areatxt.value) ||  detectaCE(doc.totalcls.value) || detectaCE(doc.interno.value)|| 
				detectaCE(doc.ubica.value)|| detectaCE(doc.UbicaFis.value) || detectaCE(doc.denom.value) || 
				detectaCE(doc.subSeccion.value) || detectaCE(doc.ano_AT.value) || detectaCE(doc.ano_AC.value)||
				detectaCE(doc.totaldisp.value) || detectaCE(doc.anioresv.value) || detectaCE(doc.anioreal.value)|| 
				detectaCE(doc.ano_Amp.value)  || detectaCE(doc.fecinact.value) || 
				detectaCE(doc.justif.value) ||  detectaCE(doc.fundamento.value) || detectaCE(doc.motivo.value) || 
				detectaCE(doc.observ.value)   
				){
				if(confirm(mensaje)){
				
					doc.areatxt.value		= quitaCE(doc.areatxt.value);
					doc.interno.value		= quitaCE(doc.interno.value);
					doc.ubica.value			= quitaCE(doc.ubica.value);
					doc.UbicaFis.value		= quitaCE(doc.UbicaFis.value);
					doc.denom.value			= quitaCE(doc.denom.value);
					doc.subSeccion.value	= quitaCE(doc.subSeccion.value);
					doc.ano_AT.value		= quitaCE(doc.ano_AT.value);
					doc.ano_AC.value		= quitaCE(doc.ano_AC.value);
					doc.totaldisp.value		= quitaCE(doc.totaldisp.value);
					doc.fundamento.value	= quitaCE(doc.fundamento.value);
					doc.motivo.value		= quitaCE(doc.motivo.value);
					doc.observ.value		= quitaCE(doc.observ.value);
					doc.anioresv.value		= quitaCE(doc.anioresv.value);
					doc.anioreal.value		= quitaCE(doc.anioreal.value);
					doc.totalcls.value		= quitaCE(doc.totalcls.value);
					doc.ano_Amp.value		= quitaCE(doc.ano_Amp.value);
					doc.fecinact.value		= quitaCE(doc.fecinact.value);
					doc.justif.value		= quitaCE(doc.justif.value);
					doc.clave.value			= quitaCE(doc.clave.value);
					
					if(document.expedientef.id_sub.value != "") 
						document.expedientef.accion.value="cambiar";
					if(document.expedientef.id_sub.value == "")
						document.expedientef.accion.value="guardar";
//					doc.submit();				
				}
				else
					doc.accion.value="";
			}
			else{
				if(document.expedientef.id_sub.value != "") 
						document.expedientef.accion.value="cambiar";
				if(document.expedientef.id_sub.value == "")
						document.expedientef.accion.value="guardar";
//				document.expedientef.submit();
			}
//		}
		if (Trim(doc.ubica.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Ubicacion "+ "\n";
		}	
	
		if (doc.ced_tip[doc.ced_tip.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar un Tipo de Cedula	"+ "\n";
		}

		if (Trim(doc.observ.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar las observaciones"+ "\n";
		}

		if (Trim(doc.anioresv.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar los años reservados"+ "\n";
		}
		if (Trim(doc.motivo.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la motivacion"+ "\n";
		}
		if (Trim(doc.fundamento.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar el fundamento juridico"+ "\n";
		}
		if (doc.valor[doc.valor.selectedIndex].value == -1) {
			valida = 1;
			msg = msg + "Debe seleccionar una la valoracion"+ "\n";
		}
		if (Trim(doc.denom.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la denominaci\xF3n"+ "\n";
		}
		if (Trim(doc.interno.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar un identificador Interno"+ "\n";
		}
		if (Trim(doc.areatxt.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Descripci\xF3n del Area"+ "\n";
		}
		if (Trim(doc.subSeccion.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Descripci\xF3n "+ "\n";
		}
		if (Trim(doc.cve_UA.value) == "") {
			valida = 1;
			msg = msg + "Debe seleccionar una Unidad Administrativa "+ "\n";
		}

		if (Trim(doc.fec_apert.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Fecha de Apertura "+ "\n";
		}		

		if (Trim(doc.ano_AC.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Año AC "+ "\n";
		}	

		if (Trim(doc.ano_AT.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Año AT "+ "\n";
		}

/*		if (Trim(doc.justif.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Justificaci\xF3n "+ "\n";
		}*/

		if (doc.idclsinf.selectedIndex == 0) {
			valida =1;
			msg = msg + "Debe seleccionar la Clasificaci\xF3n de Informaci\xF3n"+ "\n";
		}
		//alert (doc.idclsinf.selectedIndex);
		
		if (valida == 1) 
		{
			alert(msg);
			valida=0;
			return false;
		}else if(valida == 2){
			alert("Su solicitud ya fue enviada");
			return false;
		}else{
			valida=2;
			doc.submit();
		}
}

// ---------
function setFormFocusExpediente() {
	doc = document.expedientef;
	doc.clave.focus(); 
	doc.clave.select();
}
//** Fin Subserie.jsp
//** Inicio Valor.jsp
	function GuardarValor(){
		doc = document.valorf;
		//valida = 0;
		msg="";
		
			mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar';
			if( detectaCE(doc.subSeccion.value)  || detectaCE(doc.subCodigo.value) || detectaCE(doc.justif.value) ){
				if(confirm(mensaje)){
					
					doc.subSeccion.value	= quitaCE(doc.subSeccion.value);
					doc.subCodigo.value	= quitaCE(doc.subCodigo.value);
					doc.justif.value	= quitaCE(doc.justif.value);
					
					if(document.valorf.id_sub.value != "") 
						document.valorf.accion.value="cambiar";
					if(document.valorf.id_sub.value == "")
						document.valorf.accion.value="guardar";
				}
				else
					document.valorf.accion.value="";
			}
			else{
				if(document.valorf.id_sub.value != "") 
					document.valorf.accion.value="cambiar";
				if(document.valorf.id_sub.value == "")
					document.valorf.accion.value="guardar";
			}

		if (Trim(doc.subCodigo.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Nombre"+ "\n";
		}
		if (Trim(doc.subSeccion.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Descripcion"+ "\n";
		}
		if (Trim(doc.clave.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Clave "+ "\n";
		}		
		if (valida == 1) 
		{
			alert(msg);
			valida=0;
			return false;
		}else if(valida==2){
			alert("Su solicitud ya fue enviada");
			return false;
		}else{
			valida=2;
			document.valorf.submit();
		}	
	}
//Fin de GuardarValor.jsp

	function setFormFocusValor() {
		doc = document.valorf;
		doc.clave.focus(); 
		doc.clave.select();
	}
//** Fin Valor.jsp


//** Inicio Tipo Cedula.jsp
	function GuardarTipCed(){
		doc = document.tipcedf;
		//valida = 0;
		msg="";

		if (doc.idArea[doc.idArea.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar una Unidad Administrativa "+ "\n";
		}		
		
		if (Trim(doc.Subserie.value) == ""  && Trim(doc.Serie.value) == "") {
		valida =1;
		msg = msg + "Debe seleccionar una serie o subserie "+ "\n";
		}	
		
		if (Trim(doc.Subserie.value) != ""  && Trim(doc.Serie.value) != "") {
			valida =1;
			msg = msg + "Solo debe seleccionar una opcion de serie o subserie "+ "\n";
			doc.Subserie.value = -1;
			doc.Serie.value = -1;
		}
		if (Trim(doc.motivo.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar una Motivacion "+ "\n";
		}
		if (Trim(doc.fundar.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar un fundamento "+ "\n";
		}
		if (Trim(doc.subCodigo.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar el Nombre "+ "\n";
		}
		if (Trim(doc.subSeccion.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Descripci\xF3n "+ "\n";
		}
		if (Trim(doc.clave.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Clave "+ "\n";
		}			
		if (valida == 1) 
		{
			alert(msg);
			valida=0;
			return false;
		}else if(valida == 2){
			alert("Su solicitud ya fue enviada");
			return false;
		}else{
			mensaje = "Algunos de los campos tienen caracteres inv\xE1lidos (&, \", <, >, ', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar";
			if(detectaCE(doc.clave.value) || detectaCE(doc.subCodigo.value) || detectaCE(doc.subSeccion.value) 
			   || detectaCE(doc.fundar.value) || detectaCE(doc.motivo.value)) {
					if (confirm(mensaje)){
						doc.clave.value			= quitaCE(doc.clave.value);
						doc.subCodigo.value		= quitaCE(doc.subCodigo.value);
						doc.subSeccion.value	= quitaCE(doc.subSeccion.value);
						doc.fundar.value		= quitaCE(doc.fundar.value);
						doc.motivo.value		= quitaCE(doc.motivo.value);
						
						if(document.tipcedf.id_sub.value != "") 
							document.tipcedf.accion.value="cambiar";
						if(document.tipcedf.id_sub.value == "")
							document.tipcedf.accion.value="guardar";
						//doc.submit();					
					}
				else
					document.tipcedf.accion.value="";
			}
			else{
				if(document.tipcedf.id_sub.value != "") 
					document.tipcedf.accion.value="cambiar";
				if(document.tipcedf.id_sub.value == "")
					document.tipcedf.accion.value="guardar";
				//doc.submit();					
			}
			valida=2;
			doc.submit();
		}
}
	
//	
	function setFormFocusTipCed() {
		doc = document.tipcedf;
		doc.clave.focus(); 
		doc.clave.select();
	}

	
//** Fin Tipo Cedula.jsp
//** Inicio Seleccion.jsp
	function GuardarSeleccion(){
		doc = document.seleccionf;
		//valida = 0;
		msg="";
		
			mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar';
			if( detectaCE(doc.subCodigo.value)  || detectaCE(doc.subSeccion.value) || detectaCE(doc.justif.value) ){
				if(confirm(mensaje)){
					doc.subCodigo.value	   	= 	quitaCE(doc.subCodigo.value);
					doc.subSeccion.value	= 	quitaCE(doc.subSeccion.value);
					doc.justif.value	   	= 	quitaCE(doc.justif.value);

					if(document.seleccionf.id_sub.value != "") 
						document.seleccionf.accion.value="cambiar";
					if(document.seleccionf.id_sub.value == "")
						document.seleccionf.accion.value="guardar";
				}
				else
					document.seleccionf.accion.value="";
			}
			else{
				if(document.seleccionf.id_sub.value != "") 
					document.seleccionf.accion.value="cambiar";
				if(document.seleccionf.id_sub.value == "")
					document.seleccionf.accion.value="guardar";
			}
		if (Trim(doc.subCodigo.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar el Nombre "+ "\n";
		}
		if (Trim(doc.subSeccion.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Descripci\xF3n "+ "\n";
		}
		if (Trim(doc.clave.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Clave "+ "\n";
		}		
		if (valida == 1) 
		{
			alert(msg);
			valida=0;
			return false;
		}else if(valida == 2){
			alert("Su solicitud ya fue enviada");
			return false;
		}else{		
			valida=2;
			document.seleccionf.submit();
		}
	}
	
	// funcion
	function setFormFocusSelecccion() {
		doc = document.seleccionf;
		doc.clave.focus(); 
		doc.clave.select();
	}
//** Fin Seleccion.jsp



//** Inicio Seccion.jsp
	function GuardarSeccionArch(){
		doc = document.seccionf;
		//valida = 0;
		msg="";
		
			mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar';
			if( detectaCE(doc.clave.value)  || detectaCE(doc.subCodigo.value) || detectaCE(doc.subSeccion.value)  || detectaCE(doc.justif.value) ){
				if(confirm(mensaje)){
				
					doc.clave.value			= 	quitaCE(doc.clave.value);
					doc.subCodigo.value		= 	quitaCE(doc.subCodigo.value);
					doc.subSeccion.value	= 	quitaCE(doc.subSeccion.value);
					doc.justif.value		= 	quitaCE(doc.justif.value);

					msg="Hay campos vacios\ndebe de ser capturarlos";
					if( (doc.clave.value == "")  || (doc.subCodigo.value== "") 	|| 
						(doc.subSeccion.value == "") || (doc.justif.value)  ){
						alert(msg);
						return false;
					}			
					
					if(document.seccionf.id_sub.value != "") 
						document.seccionf.accion.value="cambiar";
					if(document.seccionf.id_sub.value == "")
						document.seccionf.accion.value="guardar";		
				}
				else
					document.seccionf.accion.value="";
			}
			else{
				if(document.seccionf.id_sub.value != "") 
					document.seccionf.accion.value="cambiar";
				if(document.seccionf.id_sub.value == "")
					document.seccionf.accion.value="guardar";		
			}

		if (doc.fondo[doc.fondo.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar un Fondo	"+ "\n";
		}
		if (doc.subfondo[doc.subfondo.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar un SubFondo	"+ "\n";
		}
		if (Trim(doc.subCodigo.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Nombre "+ "\n";
		}
		if (Trim(doc.subSeccion.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Descripci\xF3n "+ "\n";
		}
		if (Trim(doc.clave.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Clave "+ "\n";
		}
		if (parseInt(doc.clave.value) < 1) {
			valida = 1;
			msg = msg + "La Clave no puede ser cero "+ "\n";
		}			
		if (valida == 1) 
		{
			alert(msg);
			valida=0;
			return false;
		}else if(valida == 2){
			alert("Su solicitud ya fue enviada");
			return false;
		}else{
			valida=2;
			document.seccionf.submit();
		}
	}



	function setFormFocusSeccionArch() {
		doc = document.seccionf;
		doc.clave.focus(); 
		doc.clave.select();
	}
//** Fin Seccion.jsp




//** Inicio Icdd.jsp
	function GuardarIcdd(){
		doc = document.Icdd;
		//valida = 0;
		msg="";
		
	for (var i = 0; i < doc.elements.length; i++) 
	{  if (doc.elements[i].type == 'checkbox') 
		{  if (doc.elements[i].name == 'series') 
			{  if (doc.elements[i].checked == true)
				{  valor = doc.elements[i].value;
					if(valor != "") 
						cadena = cadena +valor + ' ';        
				}
			}
		}
	}
	for (var i = 0; i < doc.elements.length; i++) 
	{  if (doc.elements[i].type == 'checkbox') 
		{  if (doc.elements[i].name == 'subseries') 
			{  if (doc.elements[i].checked == true)
				{  valor = doc.elements[i].value;
					if(valor != "") 
						cadena2 = cadena2 +valor + ' ';        
				}
			}
		}
	}
	
	if (cadena == "" && cadena2 == ""){
		valida = 1;
		msg = msg + "Debe de seleccionar por lo menos una serie o subserie"+ "\n";
	}
		
	if (doc.idArea[doc.idArea.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar un Area "+ "\n";
		}
		if (doc.secciona[doc.secciona.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar una Secci\xF3n "+ "\n";
		}
		if (valida == 1) 
		{
			alert(msg);
			valida=0;
			return false;
		}else if(valida == 2){
			alert("Su solicitud ya fue enviada");
			return false;
		}else{
			mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar';
			if(detectaCE(doc.justif.value)){ 
				if(confirm(mensaje)){

					doc.justif.value	= quitaCE(doc.justif.value);
					doc.justif.value	= quitaCE(doc.justif.value);
					doc.justif.value	= quitaCE(doc.justif.value);
					doc.justif.value	= quitaCE(doc.justif.value);
					doc.justif.value	= quitaCE(doc.justif.value);
					
					if(document.Icdd.id_sub.value != "") 
						document.Icdd.accion.value="cambiar";
					if(document.Icdd.id_sub.value == "")
						document.Icdd.accion.value="guardar";
				}
				else
					document.Icdd.accion.value="";
			}
			else{
					if(document.Icdd.id_sub.value != "") 
						document.Icdd.accion.value="cambiar";
					if(document.Icdd.id_sub.value == "")
						document.Icdd.accion.value="guardar";
			}
			valida=2;
			doc.submit();
		}		
		
	}	
//** Fin Icdd.jsp


//** Inicio Fondo.jsp
	function Guardarfondo(){
		doc = document.fondo1AS;
		//valida = 0;
		msg="";
		

			mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar';
			if( detectaCE(doc.subCodigo.value)  || detectaCE(doc.subSeccion.value) 
			|| detectaCE(doc.justif.value) || detectaCE(doc.clave.value)  ){
				if(confirm(mensaje)){

					doc.subSeccion.value	= quitaCE(doc.subSeccion.value);
					doc.clave.value			= quitaCE(doc.clave.value);
					doc.subCodigo.value		= quitaCE(doc.subCodigo.value);
					doc.justif.value		= quitaCE(doc.justif.value);
					if(document.fondo1AS.id_sub.value != "") 
						document.fondo1AS.accion.value="cambiar";
					if(document.fondo1AS.id_sub.value == "")
						document.fondo1AS.accion.value="guardar";	
				}			
				else
					document.fondo1AS.submit();			
			}
			else{
				if(document.fondo1AS.id_sub.value != "") 
					document.fondo1AS.accion.value="cambiar";
				if(document.fondo1AS.id_sub.value == "")
					document.fondo1AS.accion.value="guardar";	
			
			}
		if (Trim(doc.subCodigo.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Nombre"+ "\n";
		}
		if (Trim(doc.subSeccion.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Descripcion"+ "\n";
		}
		if (Trim(doc.clave.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Clave"+ "\n";
		}
		
		if (parseInt(doc.clave.value.substring(1,doc.clave.length)) < 1) {
			valida = 1;
			msg = msg + "La Clave debe tener un cosecutivo mayor a cero"+ "\n";
		}
				
		if (Trim(doc.sisiNum.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar los Años Sisi"+ "\n";
		}		
		if (doc.inactivo.checked == true) {
			if (Trim(doc.fecinact.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Fecha de Inactividad"+ "\n";
			}
/*		if (Trim(doc.justif.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Justificaci\xF3n de Inactividad"+ "\n";
			}*/
		}
		if (valida == 1) 
		{
			alert(msg);
			valida=0;
			return false;
		}else if(valida == 2){
			alert("Su solicitud ya fue enviada");
			return false;
		}else{
			valida = 2;
			document.fondo1AS.submit();
		}
	}



	function setFormFocusFondo() {
		doc = document.fondo1AS;
		doc.clave.focus(); 
		doc.clave.select();
	}
//** Fin fondo.jsp
//** Inicio Combinaciones.jsp
	function GuardarComb(){
		doc = document.combf;
		valida = 0;
		msg="";
		
		if (doc.fondoP[doc.fondoP.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar un Fondo	"+ "\n";
		}
		if (doc.fondo[doc.fondo.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar un SubFondo	"+ "\n";
		}
		if (doc.secciona[doc.secciona.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar una Seccion	"+ "\n";
		}
		if (doc.serieP[doc.serieP.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar una Serie	"+ "\n";
		}
		if (doc.serie[doc.serie.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar una SubSerie	"+ "\n";
		}
		if (doc.tipcomb[doc.tipcomb.selectedIndex].value == "") {
		valida =1;
		msg = msg + "Debe seleccionar un Tipo de Estructura	"+ "\n";
		}
		if (Trim(doc.subCodigo.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Nombre "+ "\n";
		}
		if (Trim(doc.subSeccion.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Descripcion "+ "\n";
		}
		/*if (Trim(doc.clave.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la clave "+ "\n";
		}*/				
		if (valida == 1) 
		{
			alert(msg);
			return false;
		} 
		else if(document.combf.id_sub.value != "") 
			document.combf.accion.value="cambiar";
		else
		if(document.combf.id_sub.value == "")
			document.combf.accion.value="guardar";
		
		document.combf.submit();
	}
	
	function setFormFocusComb() {
		doc = document.combf;
		doc.subCodigo.focus(); 
		doc.subCodigo.select();
	}
//** Fin Combinaciones.jsp
//** Inicio Clasificacion.jsp
	function GuardarClasf(){
		doc = document.clsf;
		//valida = 0;
		msg="";

			mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar';
			if( detectaCE(doc.clave.value)  || detectaCE(doc.subCodigo.value) || detectaCE(doc.subSeccion.value) || 
			detectaCE(doc.obvser.value) || detectaCE(doc.justif.value)
			){
				if(confirm(mensaje)){
					doc.clave.value	= quitaCE(doc.clave.value);
					doc.subCodigo.value	 	= quitaCE(doc.subCodigo.value); //subCodigo
					doc.subSeccion.value	= quitaCE(doc.subSeccion.value);
					doc.obvser.value		= quitaCE(doc.obvser.value);
					doc.justif.value		= quitaCE(doc.justif.value);

					if(document.clsf.id_sub.value != "") 
						document.clsf.accion.value="cambiar";
					if(document.clsf.id_sub.value == "")
						document.clsf.accion.value="guardar";
				}
				else
					document.clsf.accion.value="";
			}
			else{
				if(document.clsf.id_sub.value != "") 
					document.clsf.accion.value="cambiar";
				if(document.clsf.id_sub.value == "")
					document.clsf.accion.value="guardar";
			}
		
		if (doc.valor[doc.valor.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe seleccionar una Valoraci\xF3n	"+ "\n";
		}
		if (Trim(doc.clave.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Clave "+ "\n";
		}				
		if (parseInt(doc.clave.value) < 1) {
			valida = 1;
			msg = msg + "La Clave no puede ser cero "+ "\n";
		}		
		if (doc.seleccion[doc.seleccion.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe seleccionar una Seleccion	"+ "\n";
		}
		if (Trim(doc.reserv.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Año de Reserva "+ "\n";
		}		
		if (Trim(doc.vigenciatot.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Vigencia Total "+ "\n";
		}
		if (Trim(doc.vigenciaac.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Vigencia AC "+ "\n";
		}				
		if (Trim(doc.vigenciaat.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Vigencia AT "+ "\n";
		}
		if (Trim(doc.subCodigo.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Nombre "+ "\n";
		}	
		if (Trim(doc.subSeccion.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Descripci\xF3n "+ "\n";
		}	
/*		if (Trim(doc.justif.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Justificaci "+ "\n";
		}	*/
		if (valida == 1) 
		{
			alert(msg);
			valida=0;
			return false;
		}else if(valida == 2){
			alert("Su solicitud ya fue enviada");
			return false;
		}else{
			valida=2;
			document.clsf.submit();  //justif
		}
	}
	
	
	function setFormFocusClasif() {
		doc = document.clsf;
		doc.clave.focus(); 
		doc.clave.select();
	}
//** Fin Clasificacion.jsp
//** Inicio Clasificacion.jsp
	function GuardarClasfsub(){
		doc = document.clsfsub;
		//valida = 0;
		msg="";
		
			mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar';
// obvser
			if( detectaCE(doc.clave.value)  || detectaCE(doc.obvser.value) || detectaCE(doc.justif.value) 
				|| detectaCE(doc.subSeccion.value) || detectaCE(doc.subCodigo.value)|| detectaCE(doc.obvser.value)
			 ){
				if(confirm(mensaje)){
					doc.clave.value	= quitaCE(doc.clave.value);
					doc.obvser.value	= quitaCE(doc.obvser.value);
					doc.justif.value	= quitaCE(doc.justif.value);
					doc.subSeccion.value = quitaCE(doc.subSeccion.value);
					doc.subCodigo.value = quitaCE(doc.subCodigo.value);
					doc.obvser.value = quitaCE(doc.obvser.value);

					if(document.clsfsub.id_sub.value != "") 
						document.clsfsub.accion.value="cambiar";
					if(document.clsfsub.id_sub.value == "")
						document.clsfsub.accion.value="guardar";
				}
				else
					document.clsfsub.accion="";
			}
			else{
				if(document.clsfsub.id_sub.value != "") 
					document.clsfsub.accion.value="cambiar";
				if(document.clsfsub.id_sub.value == "")
					document.clsfsub.accion.value="guardar";
			}

		if (doc.valor[doc.valor.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar una Valoraci\xF3n	"+ "\n";
		}
		if (Trim(doc.clave.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Clave "+ "\n";
		}				
		if (parseInt(doc.clave.value) < 1) {
			valida = 1;
			msg = msg + "La Clave no puede ser cero "+ "\n";
		}		
		if (doc.seleccion[doc.seleccion.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar una Seleccion	"+ "\n";
		}
		
/*		if (Trim(doc.conf.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar si es confidencial "+ "\n";
		}*/
		
		if (Trim(doc.reserv.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Año de Reserva "+ "\n";
		}		
		if (Trim(doc.vigenciatot.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Vigencia Total "+ "\n";
		}
		if (Trim(doc.vigenciaac.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Vigencia AC "+ "\n";
		}				
		if (Trim(doc.vigenciaat.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Vigencia AT "+ "\n";
		}
		if (Trim(doc.subCodigo.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Nombre "+ "\n";
		}	
		if (Trim(doc.subSeccion.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Descripci\xF3n "+ "\n";
		}	
		/*if (doc.reserv.value > 12 ) {
			valida = 1;
			msg = msg + "El limite de Años Reserva es 12 "+ "\n";
		}*/
/*		if (Trim(doc.justif.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Justificacion "+ "\n";
		}	*/
		if (valida == 1) 
		{
			alert(msg);
			valida=0;
			return false;
		}else if(valida == 2){
			alert("Su solicitud ya fue enviada");
			return false;
		}else{
			valida=2;
			document.clsfsub.submit();   //justif
		} 
	}

	
	function setFormFocusClasifsub() {
		doc = document.clsfsub;
		doc.clave.focus(); 
		doc.clave.select();
	}
//** Fin ClasificacionSub.jsp
//** Inicio Serie.jsp
	function Guardarserie(){
		doc = document.serief;
		valida = 0;
		msg="";
		
		if (Trim(doc.subCodigo.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Nombre"+ "\n";
		}
		if (Trim(doc.subSeccion.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Descripci\xF3n"+ "\n";
		}
		if (Trim(doc.clave.value) == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Clave"+ "\n";
		}		
		if (valida == 1) 
		{
			alert(msg);
			return false;
		} 
		else if(document.serief.id_sub.value != "") 
			document.serief.accion.value="cambiar";
		else
		if(document.serief.id_sub.value == "")
			document.serief.accion.value="guardar";
		
		document.serief.submit();
	}
	
	function setFormFocusserie() {
		doc = document.serief;
		doc.clave.focus(); 
		doc.clave.select();
	}
	
//** Fin serie.jsp
//** Inicio Clasificacion de Informacion.jsp
	function GuardarClasifInf(){
		doc = document.clsifinf;
		//valida = 0;
		msg="";

			mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar';
			if( detectaCE(doc.subCodigo.value)  || detectaCE(doc.subSeccion.value) || detectaCE(doc.justif.value) ){
				if(confirm(mensaje)){
					doc.subCodigo.value		= 	quitaCE(doc.subCodigo.value);
					doc.subSeccion.value	= 	quitaCE(doc.subSeccion.value);
					doc.justif.value		= 	quitaCE(doc.justif.value);
					
					if(document.clsifinf.id_sub.value != "") 
						document.clsifinf.accion.value="cambiar";
					if(document.clsifinf.id_sub.value == "")
						document.clsifinf.accion.value="guardar";
				}		
				else
					document.clsifinf.accion.value="";
			}	
			else{
				if(document.clsifinf.id_sub.value != "") 
					document.clsifinf.accion.value="cambiar";
				if(document.clsifinf.id_sub.value == "")
					document.clsifinf.accion.value="guardar";
			}
			
		if (Trim(doc.subCodigo.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar el Nombre " + "\n";
		}
		if (Trim(doc.subSeccion.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Descripci\xF3n "+ "\n";
		}
		if (Trim(doc.clave.value) == "") {
			valida = 1;
			msg = msg + "Debe capturar la Clave "+ "\n";
		}	
 		if (valida == 1) 
		{
			alert(msg);
			valida=0;
			return false;
		}else if(valida == 2){
			alert("Su solicitud ya fue enviada");
			return false;
		}else{
			valida=2;
			document.clsifinf.submit();
		}
	}
	
	
	
// funcion setFormFocusClasifInf
	function setFormFocusClasifInf() {
		doc = document.clsifinf;
		doc.clave.focus(); 
		doc.clave.select();
	}
//** Fin Clasificacion de Informacion.jsp
//** Inicio Seccion.jsp

	function GuardarSeccion(){
		doc = document.seccion1;
		valida = 0;
		msg="";
		
		if (doc.secSubfondo[doc.secSubfondo.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "Debe seleccionar un  SubFondo	"+ "\n";
		}
		if (doc.secSerie.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar la Serie de la Seccion "+ "\n";
		}
		if (doc.clave.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar la clave del Seccion "+ "\n";
		}
		if (doc.secCodigo.value == "") {
			valida = 1;
			msg = msg + "Debe de capturar el Codigo de la Secci\xF3n "+ "\n";
		}
		if (valida == 1) 
		{
			alert(msg);
			return false;
		} 
		else if(document.seccion1.id_sec.value != "") 
			document.seccion1.accion.value="cambiar";
		else
		if(document.seccion1.id_sec.value == "")
			document.seccion1.accion.value="guardar";
		
		document.seccion1.submit();
	}
//** Fin Seccion.jsp
/***********************************************************************************TERMINA*/
// Funsion para validar el numero telefonico

function isTelefono(telefono){

	longitud = telefono.length;
	i = 0;
	bandera = true;
	
	for (i=0; i<longitud; i++){
		c = telefono.charAt(i);
		if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9' && c != ' ' && c != '-' && c != '(' && c != ')')
			bandera = false;
	}
	return bandera;
}

// Funcion para validar el correo Electr\xF3nico

function isCorreo(correo){

	cEspeciales = '|°¬!"#$%&/()=\\\'?¿¡ᩭ󺁉͓ڤ믶üċϖܫ*~{[⪮��Δ۠謲ùÀȌҙ}],;:񑴨^` <>';
	longitud = correo.length;
	c = correo.indexOf("@");
	bandera = true;

	if (longitud == 0)
		return bandera;

	if (c <= 0 || c >= longitud-1)
		bandera = false;
	
	if (bandera){
		i = 0;
		cont = 0;
		for (i=0; i<longitud; i++){
			c = correo.charAt(i);
			if (c == '@')
				cont++;
			j=0;
			for (j=0; j<cEspeciales.length; j++){
				if (c==cEspeciales.charAt(j))
					bandera = false;
			}
		}
		if (cont > 1){
			bandera = false;
		}
	}
	
	for (i=0; i<longitud; i++){
		c = correo.charAt(i);
		if (c == '.'){
			if (i<longitud-1 && correo.charAt(i+1) == '.')
				bandera = false;				
			if (i <= 0 || i >= longitud-1)
				bandera = false;				
		}
	}
	
	return bandera;
}


// Funcion para detectar y eliminar los caracteres especiales

function detectaCE(texto){

	if (texto.indexOf('&')>=0 || texto.indexOf('"')>=0 || texto.indexOf('<')>=0 || texto.indexOf('>')>=0 || texto.indexOf('\'')>=0 || texto.indexOf('\`')>=0 || texto.indexOf('\´')>=0 )
	{
		return true;
	}
	else{ 
		return false;
	}
}

function quitaCE(texto){
	var textoMod=texto.replace(/[<|>|&|'|`|´|"]/g,"");
	if(texto.indexOf("&lt;")==-1&&texto.indexOf("&gt;")==-1&&texto.indexOf("&amp;")==-1&&texto.indexOf("&quot;")==-1)
		 textoMod=textoMod.replace(/[&]/g,"");
	return textoMod;
}

function quitaCEB(texto){
	var textoMod=texto.replace(/[<|>|&|'|`|´|"]/g,"");
	if(texto.indexOf("&lt;")==-1&&texto.indexOf("&gt;")==-1&&texto.indexOf("&amp;")==-1&&texto.indexOf("&quot;")==-1)
		 textoMod=textoMod.replace(/[&]/g,"");
	return textoMod;
}



//Modificacciones en guardaUsuario y guardaDestino
function guardarDestinoExt() {
	doc = document.DestExtFormDinamic;
	valida = 0;
	msg="";

	if (doc.usuarioNombre.value =="") {
		valida =1;
		msg = msg + "Debe capturar el Nombre	"+ "\n";
	}
	if (doc.usuarioArea[doc.usuarioArea.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar un \xE1rea	"+ "\n";
	}

	if (doc.usuarioDesc.value =="") {
		valida =1;
		msg = msg + "Debe capturar Descripcion	"+ "\n";
	}
	if (doc.usuarioEmail.value =="") {
		valida =1;
		msg = msg + "Debe capturar el E-mail	"+ "\n";
	}
	if (!isTelefono(Trim(doc.usuarioTelefono.value))) {
		valida =1;
		msg = msg + "El n\xFAmero de Tel\xE9fono es inv\xE1lido	"+ "\n";
	}
	if (Trim(doc.usuarioTelefono.value)=="" && doc.usuarioTelefono.value.length>0) {
		valida =1;
		msg = msg + "El Tel\xE9fono no debe contener solo espacios vacios"+ "\n";
	}
	if (!isCorreo(Trim(doc.usuarioEmail.value))) {
		valida =1;
		msg = msg + "El Correo Electr\xF3nico es inv\xE1lido	"+ "\n";
	}

	
	if (valida == 1) 
	{
		alert(msg);
		return false;
	} 
	if (valida != 1)
	{
	if(doc.id_usuario.value != "")
		doc.accion.value="cambiar";
	if(doc.id_usuario.value == "")
		doc.accion.value="guardar";
	doc.submit();
	}
}
//** funcion destinatario externos dinamicos

//** funciones de asunto para bloqueo
function Cancelar(){
	
	/*var formP = window.opener.document.forms[0];

		for (var i = 0; i < formP.elements.length; i++) {
			if (formP.elements[i].type == "button") {
	  			
	  			formP.elements[i].disabled=false;
			}
		}
		
		for (var j = 0; j < formP.elements.length; j++) {    	
  			if (formP.elements[j].type == "text") {
    				formP.elements[j].disabled=false;
    		}
    	}
    
	    for (var k = 0; k < formP.elements.length; k++) {    	
  			if (formP.elements[k].type == "select-one") {
    				formP.elements[k].disabled=false;
    		}
	    }
	    
	    for (var l = 0; l < formP.elements.length; l++) {   	
  			if (formP.elements[l].type == "textarea") {
    				formP.elements[l].disabled=false;
    		}
	    }*/
		opener.hay_hija = new Boolean(false);
		opener.hija = null;

		window.opener.document.forms[0].accion.value = "";
		window.opener.document.Asunto.submit();
		window.close();
}

function DesbloquearElementos(idAsunto, numero){

		var formP = opener.window.document.forms[0];

		for (var i = 0; i < formP.elements.length; i++) {
			if (formP.elements[i].type == "button") {
	  			
	  			formP.elements[i].disabled=false;
			}
		}
		
		for (var j = 0; j < formP.elements.length; j++) {    	
  			if (formP.elements[j].type == "text") {
    				formP.elements[j].disabled=false;
    		}
    	}
    
	    for (var k = 0; k < formP.elements.length; k++) {    	
  			if (formP.elements[k].type == "select-one") {
    				formP.elements[k].disabled=false;
    		}
	    }
	    
	    for (var l = 0; l < formP.elements.length; l++) {   	
  			if (formP.elements[l].type == "textarea") {
    				formP.elements[l].disabled=false;
    		}
	    }
	    if(numero==1){
	    	formP.guardarBtn.style.display='inline';
			if(idAsunto==""){
				formP.guardarRepBtn.style.display='inline';
			}else{
				formP.Refe.style.display='inline';
				formP.Attach.style.display='inline';
				formP.Borrar.style.display='inline';
			}
			formP.cRep.style.display='inline';
			formP.cDoc.style.display='inline';
			formP.fechaCom.style.display='inline';
			formP.cEvento.style.display='inline';
			formP.listTO.style.display='inline';
			formP.listCC.style.display='inline';
			formP.listTOE.style.display='inline';
			formP.oEntidad.style.display='inline';
			formP.oRemitente.style.display='inline';
		}else{
			formP.guardarBtn.style.display='inline';
			formP.guardarRepBtn.style.display='inline';
			formP.Refe.style.display='inline';
			formP.Attach.style.display='inline';
			formP.Borrar.style.display='inline';
			formP.cRep.style.display='inline';
			formP.cDoc.style.display='inline';
			formP.fechaCom.style.display='inline';
			formP.cEvento.style.display='inline';
			formP.listTO.style.display='inline';
			formP.listCC.style.display='inline';
			formP.listTOE.style.display='inline';
			formP.oEntidad.style.display='inline';
			formP.oRemitente.style.display='inline';
		}
}

function BloquearElementos(idAsunto){

	var form = parent.window.document.forms[0];
	
	for (var i = 0; i < form.elements.length; i++) {
    		if (form.elements[i].type == "button") {
      			
      			form.elements[i].disabled="disabled";
    		}
	}
	
	for (var j = 0; j < form.elements.length; j++) {    	
      			if (form.elements[j].type == "text") {
        				form.elements[j].disabled="disabled";
        		}
    }
    
    for (var k = 0; k < form.elements.length; k++) {    	
      			if (form.elements[k].type == "select-one") {
        				form.elements[k].disabled="disabled";
        		}
    }
    
    for (var l = 0; l < form.elements.length; l++) {    	
      			if (form.elements[l].type == "textarea") {
        				form.elements[l].disabled="disabled";
        		}
    }
    form.guardarBtn.style.display='none';
    if(idAsunto==""){
		form.guardarRepBtn.style.display='none';
	}else{
		form.Refe.style.display='none';
		form.Attach.style.display='none';
		form.Borrar.style.display='none';
	}
	form.cRep.style.display='none';
	form.oEntidad.style.display='none';
	form.oRemitente.style.display='none';
	form.cDoc.style.display='none';
	form.fechaCom.style.display='none';
	form.cEvento.style.display='none';
	form.listTO.style.display='none';
	form.listCC.style.display='none';
	form.listTOE.style.display='none';
}
function BloquearElementosRep(){

	var form = parent.window.document.forms[0];
	
	for (var i = 0; i < form.elements.length; i++) {
    		if (form.elements[i].type == "button") {
      			
      			form.elements[i].disabled="disabled";
    		}
	}
	
	for (var j = 0; j < form.elements.length; j++) {    	
      			if (form.elements[j].type == "text") {
        				form.elements[j].disabled="disabled";
        		}
    }
    
    for (var k = 0; k < form.elements.length; k++) {    	
      			if (form.elements[k].type == "select-one") {
        				form.elements[k].disabled="disabled";
        		}
    }
    
    for (var l = 0; l < form.elements.length; l++) {    	
      			if (form.elements[l].type == "textarea") {
        				form.elements[l].disabled="disabled";
        		}
    }
    form.guardarBtn.style.display='none';
    form.guardarRepBtn.style.display='none';
	form.Refe.style.display='none';
	form.Attach.style.display='none';
	form.Borrar.style.display='none';
	form.oEntidad.style.display='none';
	form.oRemitente.style.display='none';
	form.cRep.style.display='none';
	form.cDoc.style.display='none';
	form.fechaCom.style.display='none';
	form.cEvento.style.display='none';
	form.listTO.style.display='none';
	form.listCC.style.display='none';
	form.listTOE.style.display='none';
}

function cerrarIframe(elementoVista, idAsunto, numero){

	var formP = opener.window.document.forms[0];

	opener.window.document.getElementById(elementoVista).style.visibility='hidden';

	DesbloquearElementos(idAsunto, numero);

}

function AbrirIframe(elementoVista, idAsunto){

	var form =document.Asunto;
	document.getElementById(elementoVista).style.visibility='visible'; 
	
	BloquearElementos(idAsunto);
  
}
function AbrirIframeRep(elementoVista, idAsunto){

	var form =document.Asunto;
	document.getElementById(elementoVista).style.visibility='visible'; 
	
	BloquearElementosRep();
  
}

function Abrir(nWindow, ancho, alto){

	var isCenter ='true';
	var features = '';

	if(window.screen)if(isCenter)if(isCenter=="true"){
	    var myLeft = (screen.width-ancho)/2;
	    var myTop = (screen.height-alto)/2;
	    features+=(features!='')?',':'';
	    features+=',left='+myLeft+',top='+myTop; 
	}
	hija = window.open(nWindow,'hija',features+((features!='')?',':'')+'width=' + ancho + ', height=' + alto+ ', status=yes');
	hay_hija = true; 
}

function quitaElementosListTO(lista){

	nuevaLista = lista;
	for (i=0; i<nuevaLista.options.length; i++){
		if (nuevaLista.options[i].selected){
			nuevaLista.options[i] = null;
			i=-1;
		}
	}
	document.listUserUA.tmpSendToRef.value="";
	document.listUserUA.idsTO.value="";
	lista = nuevaLista;
}

function quitaElementosListCC(lista){

	nuevaLista = lista;
	for (i=0; i<nuevaLista.options.length; i++){
		if (nuevaLista.options[i].selected){
			nuevaLista.options[i] = null;
			i=-1
		}
	}
	document.listUserUA.tmpCopyToRef.value="";
	document.listUserUA.idsCC.value="";	
	lista = nuevaLista;
}

function selectToStringAndID(field){

	var cadena = "";
	var div = "|";
	
	for (i=0; i<field.options.length; i++){
		//cadena = cadena + field.options[i].text + div + field.options[i].value + div;
		cadena = cadena+field.options[i].text+div;
	}
	return cadena;
}


function buscaElementosLista (lista, criterio){
	
	var strCriterio = Trim(criterio.value);
	strCriterio = strCriterio.toLowerCase();
	
	if (strCriterio != ""){
		bandera = true;
		for (var i=0; i<lista.options.length; i++){	
			cadena = lista.options[i].text;
			cadena = cadena.toLowerCase();
			if (cadena.indexOf(strCriterio)==0 && bandera){
				lista.options[i].selected = true;
				bandera = false;
			}
			else{
				lista.options[i].selected = false;
			}				
		}
	} 
}

function quitaElementosListTOE(lista){

	nuevaLista = lista;
	for (i=0; i<nuevaLista.options.length; i++){
		if (nuevaLista.options[i].selected){
			nuevaLista.options[i] = null;
			i=-1;
		}
	}
	document.listUserUAE.tmpSendToRef.value="";
	document.listUserUAE.idsTO.value="";
	lista = nuevaLista;
}

function RemoveAllClickE()
{
	if (confirm("Est\xE1 usted seguro de que desea Eliminar los Registros?")) 
	{    
		document.listUserUAE.listTO.options.length=0;
		document.listUserUAE.tmpSendToRef.value="";
		document.listUserUAE.idsTO.value="";
	} 
}


/*function quitaElementosListTOE(lista){

	nuevaLista = lista;
	for (i=0; i<nuevaLista.options.length; i++){
		if (nuevaLista.options[i].selected){
			nuevaLista.options[i] = null;
			i=-1;
		}
	}
	document.listUserUAE.tmpSendToRef.value="";
	document.listUserUAE.idsTO.value="";
	lista = nuevaLista;
}

function RemoveAllClickE()
{
	if (confirm("Est\xE1 usted seguro de que desea Eliminar los Registros?")) 
	{    
		document.listUserUAE.listTO.options.length=0;
		document.listUserUAE.tmpSendToRef.value="";
		document.listUserUAE.idsTO.value="";
	} 
}*/	

function limitaTextArea(campo,nombre,n){

	if (campo != null){
		texto = campo.value;
		cantidadL = n;
		if( texto.length > cantidadL  ){
			campo.value = texto.substring(0,cantidadL-1);
			alert('El campo ' + nombre + ' fue truncado a ' + cantidadL + ' caracteres');
		}			
	}
}


// Comparacion de 2 fechas 
// 		regersa -1 si fecha1 < fecha2
// 		regersa  0 si fecha1 = fecha2
// 		regersa  1 si fecha1 > fecha2

function comparaFechas(fecha1, fecha2) {
    
		var xMes	=	fecha1.substring(3, 5); 
	   	var xDia	=	fecha1.substring(0, 2); 
   		var xAnio	=	fecha1.substring(6,10);     

        var yMes	=	fecha2.substring(3, 5); 
        var yDia	=	fecha2.substring(0, 2); 
        var yAnio	=	fecha2.substring(6,10);     

		if (xAnio >= yAnio){
			if (xAnio == yAnio){
				if (xMes >= yMes){
					if (xMes == yMes){
						if (xDia >= yDia){
							if (xDia == yDia){
								return 0;
							}
							else 
								return 1;
						}
						else 
							return -1;
					}
					else 
						return 1;
				}
				else
					return -1;
			}
			else	
				return 1;
		}
		else 
			return -1;
}   

function validaFormatoFecha(){

	doc = document.Asunto;	
	FR = doc.asuntoFechaRecepcion.value;
	FD = doc.asuntoFechaDocto.value;
	FC = doc.asuntoFechaCad.value;
	FE = doc.fechaEvento.value;
	
	fecha = FR;
	mes	 =	fecha.substring(3, 5); 
	dia	 =	fecha.substring(0, 2); 
   	anio =	fecha.substring(6,10);     
	if (Trim(fecha) != ""){
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
		alert("El formato de la Fecha de Recepci\xF3n es invalido");
		doc.asuntoFechaRecepcion.value = "";
		}
	}
	
	fecha = FD;
	mes	 =	fecha.substring(3, 5); 
	dia	 =	fecha.substring(0, 2); 
   	anio =	fecha.substring(6,10);     
	if (Trim(fecha) != ""){
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
		alert("El formato de la Fecha del Documento es invalido");
		doc.asuntoFechaDocto.value = "";
		}
	}
	
	fecha = FC;
	mes	 =	fecha.substring(3, 5); 
	dia	 =	fecha.substring(0, 2); 
   	anio =	fecha.substring(6,10);     
	if (Trim(fecha) != ""){
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
		alert("El formato de la Fecha Compromiso es invalido");
		doc.asuntoFechaCad.value = "";
		}
	}
	
	fecha = FE;
	mes	 =	fecha.substring(3, 5); 
	dia	 =	fecha.substring(0, 2); 
   	anio =	fecha.substring(6,10);     
	if (Trim(fecha) != ""){
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
		alert("El formato de la Fecha del Evento es invalido");
		doc.fechaEvento.value = "";
		}
	}
}

function bloqueaBackHistory(){
	if(history.length>0){
		history.go(+1);
	}
}

function getfechaActual(){

	today = new Date();
	day   = "" + today.getDate();
	month = "" + (today.getMonth()+1);
	year  = "" + today.getFullYear();

	if (day.length == 1){
		day ="0" + day;
	}
	if (month.length == 1){
		month ="0" + month;
	}
		
	fechaActual = day + "/" + month + "/" + year;
	return fechaActual;
}

function detectaCEBusqueda(texto){

	if (texto.indexOf('%')>=0 || texto.indexOf('\'')>=0 || texto.indexOf('&')>=0 || texto.indexOf('<')>=0 || texto.indexOf('>')>=0 || texto.indexOf('"')>=0 || 
		texto.indexOf('`')>=0 || texto.indexOf('´')>=0
		)    
	{
		return true;
	}
	else{ 
		return false;
	}
}
function detectaCEBusquedaB(texto){

	if (texto.indexOf('%')>=0 || texto.indexOf('\'')>=0 || texto.indexOf('&')>=0 || texto.indexOf('<')>=0 || texto.indexOf('>')>=0 || texto.indexOf('`')>=0 || 
		texto.indexOf('´')>=0	)    
	{
		return true;
	}
	else{ return false;}
}

// 


function selectConfigCorreo(){
	
	doc = document.usuarioForm;
	
	if (doc.id_usuario.value != ""){
	
		if (doc.nuevoAsunto.value == "0")
			doc.usuarioConfMails[0].checked = true;
		else 
			doc.usuarioConfMails[0].checked = false;
	
		if (doc.turnar.value == "1")
			doc.usuarioConfMails[1].checked = true;
		else 
			doc.usuarioConfMails[1].checked = false;
	
		if (doc.responder.value == "2")
			doc.usuarioConfMails[2].checked = true;
		else 
			doc.usuarioConfMails[2].checked = false;
	
		if (doc.rechazar.value == "3")
			doc.usuarioConfMails[3].checked = true;
		else 
			doc.usuarioConfMails[3].checked = false;
	
		if (doc.delegar.value == "4")
			doc.usuarioConfMails[4].checked = true;
		else 
			doc.usuarioConfMails[4].checked = false;
	
		if (doc.reasignar.value == "5")
			doc.usuarioConfMails[5].checked = true;
		else 
			doc.usuarioConfMails[5].checked = false;
	
		if (doc.habilitar.value == "6")
			doc.usuarioConfMails[6].checked = true;
		else 
			doc.usuarioConfMails[6].checked = false;
	
		if (doc.solicitudCambio.value == "7")
			doc.usuarioConfMails[7].checked = true;
		else 
			doc.usuarioConfMails[7].checked = false;
	
		if (doc.respuestaCambio.value == "8")
			doc.usuarioConfMails[8].checked = true;
		else 
			doc.usuarioConfMails[8].checked = false;
	}
}

function desabilitaConfigCorreo(){

	doc = document.usuarioForm;
	doc.usuarioConfMails[0].disabled	= true;
	doc.usuarioConfMails[1].disabled 	= true;
	doc.usuarioConfMails[2].disabled 	= true;
	doc.usuarioConfMails[3].disabled 	= true;
	doc.usuarioConfMails[4].disabled 	= true;
	doc.usuarioConfMails[5].disabled 	= true;
	doc.usuarioConfMails[6].disabled 	= true;
	doc.usuarioConfMails[7].disabled 	= true;
	doc.usuarioConfMails[8].disabled 	= true;
		
	if(doc.usuarioRol[1].checked || doc.usuarioRol[6].checked){
		doc.usuarioConfMails[2].disabled 	= false;
		doc.usuarioConfMails[3].disabled 	= false;
		doc.usuarioConfMails[4].disabled 	= false;
		doc.usuarioConfMails[5].disabled 	= false;
		doc.usuarioConfMails[6].disabled 	= false;
		doc.usuarioConfMails[7].disabled 	= false;
	}
	if(doc.usuarioRol[3].checked){
		doc.usuarioConfMails[0].disabled 	= false;
	}
	if(doc.usuarioRol[5].checked){
		doc.usuarioConfMails[0].disabled 	= false;
		doc.usuarioConfMails[1].disabled 	= false;
		doc.usuarioConfMails[8].disabled 	= false;
	}
}

function selAdminCorreo(){

	doc = document.usuarioForm;
	if(doc.usuarioRol[0].checked || doc.usuarioRol[4].checked){

		if(doc.usuarioRol[0].checked){

			doc.usuarioConfMails[0].disabled	= true;
			doc.usuarioConfMails[1].disabled 	= true;
			doc.usuarioConfMails[2].disabled 	= true;
			doc.usuarioConfMails[3].disabled 	= true;
			doc.usuarioConfMails[4].disabled 	= true;
			doc.usuarioConfMails[5].disabled 	= true;
			doc.usuarioConfMails[6].disabled 	= true;
			doc.usuarioConfMails[7].disabled 	= true;
			doc.usuarioConfMails[8].disabled 	= true;

			doc.admon.value = "0";
			doc.supervisor.value = "";
			if(doc.usuarioArea.value != 0){
				alert("Solo se permite la captura del Rol Administrador en el \xE1rea General");
				doc.admon.value = "-1";
				doc.submit();
			}
			
			doc.usuarioConfMails[0].checked 	= false;
			doc.usuarioConfMails[1].checked 	= false;
			doc.usuarioConfMails[2].checked 	= false;
			doc.usuarioConfMails[3].checked 	= false;
			doc.usuarioConfMails[4].checked 	= false;
			doc.usuarioConfMails[5].checked 	= false;
			doc.usuarioConfMails[6].checked 	= false;
			doc.usuarioConfMails[7].checked 	= false;
			doc.usuarioConfMails[8].checked 	= false;
		}
		else{
		
			desabilitaConfigCorreo();
			doc.admon.value = "-1";
			doc.supervisor.value = "4";
		}
		
	}
	else{

		desabilitaConfigCorreo();
		if(!doc.usuarioRol[0].checked)
			doc.admon.value = "-1";
		if(!doc.usuarioRol[4].checked)
			doc.supervisor.value = "";
	}
}

function selSCPCorreo(){

	doc = document.usuarioForm;
	if(doc.usuarioRol[2].checked){
		desabilitaConfigCorreo();
		doc.gestion.value = "2";
	}
	else{
		desabilitaConfigCorreo();
		doc.gestion.value = "";
	}
}

function selAtencionCorreo(){

	doc = document.usuarioForm;
        
        if (doc.usuarioRol[1].checked){
                if(doc.usuarioAsistente.length) {
                    for(var i = 0; i<doc.usuarioAsistente.length;i++) {
                        doc.usuarioAsistente[i].disabled = false;
                    }
                } else {
                    doc.usuarioAsistente.disabled = false;
                }
		doc.usuarioDesExt.disabled	= false;
	}else{
                if(doc.usuarioAsistente.length) {
                    for(var i = 0; i<doc.usuarioAsistente.length;i++) {
                        doc.usuarioAsistente[i].disabled = true;
                    }
                } else {
                    doc.usuarioAsistente.disabled = true;
                }
                //doc.usuarioAsistente.disabled	= true;
		doc.usuarioDesExt.disabled	= true;
	}
		
	if(doc.usuarioRol[1].checked || doc.usuarioRol[6].checked){

		doc.usuarioConfMails[2].checked 	= true;
		doc.usuarioConfMails[2].disabled 	= false;
		
		doc.usuarioConfMails[3].checked 	= true;
		doc.usuarioConfMails[3].disabled 	= false;
		
		doc.usuarioConfMails[4].checked 	= true;
		doc.usuarioConfMails[4].disabled 	= false;
		
		doc.usuarioConfMails[5].checked 	= true;
		doc.usuarioConfMails[5].disabled 	= false;
		
		doc.usuarioConfMails[6].checked 	= true;
		doc.usuarioConfMails[6].disabled 	= false;
		
		doc.usuarioConfMails[7].checked 	= true;
		doc.usuarioConfMails[7].disabled 	= false;
		
		desabilitaConfigCorreo();		

		if(doc.usuarioRol[6].checked){
		
			doc.usuarioConfMails[0].checked 	= false;
			doc.usuarioConfMails[1].checked 	= false;
			doc.usuarioConfMails[8].checked 	= false;

			doc.usuarioConfMails[0].disabled 	= true;
			doc.usuarioConfMails[1].disabled 	= true;
			doc.usuarioConfMails[8].disabled 	= true;
		}

		if(doc.usuarioRol[1].checked){
			doc.atencion.value = "1";
		}
		if(doc.usuarioRol[6].checked){
			doc.asistente.value = "6";
		}
		if(!doc.usuarioRol[1].checked){
			doc.atencion.value = "";
		}
		if(!doc.usuarioRol[6].checked){
			doc.asistente.value = "";
		}
		
	}
	else{
		doc.usuarioConfMails[2].checked 	= false;
		doc.usuarioConfMails[3].checked 	= false;
		doc.usuarioConfMails[4].checked 	= false;
		doc.usuarioConfMails[5].checked 	= false;
		doc.usuarioConfMails[6].checked 	= false;
		doc.usuarioConfMails[7].checked 	= false;
	
		desabilitaConfigCorreo();

		if(!doc.usuarioRol[1].checked){
			doc.atencion.value = "";
		}
		if(!doc.usuarioRol[6].checked){
			doc.asistente.value = "";
		}
	}
}

function selTurnadoCorreo(){

	doc = document.usuarioForm;
	if(doc.usuarioRol[5].checked){

		doc.usuarioConfMails[0].checked 	= true;
		doc.usuarioConfMails[0].disabled 	= false;
		
		doc.usuarioConfMails[1].checked 	= true;
		doc.usuarioConfMails[1].disabled 	= false;
		
		doc.usuarioConfMails[8].checked 	= true;
		doc.usuarioConfMails[8].disabled 	= false;
		
		desabilitaConfigCorreo();		
		doc.turnado.value = "5";
		
		doc.usuarioSubVent.disabled	= false;
		
	}
	else{
	
		if(!(doc.usuarioRol[2].checked || doc.usuarioRol[3].checked))
			doc.usuarioConfMails[0].checked 	= false;
		doc.usuarioConfMails[1].checked 	= false;
		doc.usuarioConfMails[8].checked 	= false;
		
		desabilitaConfigCorreo();
		doc.turnado.value = "";
		
		doc.usuarioSubVent.disabled	= true;
		
	}
}

function selRecepcionCorreo(){

	doc = document.usuarioForm;
	if(doc.usuarioRol[2].checked || doc.usuarioRol[3].checked){

		doc.usuarioConfMails[0].checked 	= true;
		doc.usuarioConfMails[0].disabled 	= false;
		
		desabilitaConfigCorreo();		
		doc.recepcion.value = "3";
		
	}
	else{
	
		if(!doc.usuarioRol[5].checked)
			doc.usuarioConfMails[0].checked 	= false;

		desabilitaConfigCorreo();
		doc.recepcion.value = "";
	}
}

function validaFechaEve() {
		
	doc = document.Asunto;
	if (doc.asuntoFechaRecepcion!=null && doc.asuntoFechaCad!=null && doc.fechaEvento!=null){

		fechaRecepcion 	= (doc.asuntoFechaRecepcion.value!="")?doc.asuntoFechaRecepcion.value:"";
		fechaCompromiso	= (doc.asuntoFechaCad.value!="")?doc.asuntoFechaCad.value:"";
		fechaEve	 	= (doc.fechaEvento.value!="")?doc.fechaEvento.value:"";

		//alert(fechaRecepcion +fechaRecepcion.length+" "+ fechaCompromiso +fechaCompromiso.length+" "+ fechaEve +fechaEve.length);
		//alert(comparaFechas(fechaEve,fechaRecepcion) + " " + comparaFechas(fechaEve,fechaCompromiso));

		if (fechaRecepcion.length >= 10 && fechaCompromiso.length >= 10 && fechaEve.length >= 10){
			if (comparaFechas(fechaEve,fechaRecepcion)==-1 || comparaFechas(fechaEve,fechaCompromiso)==1){
				doc.fechaEvento.value = "";
				alert("La Fecha del Evento debe estar entre la Fecha de Recepci\xF3n y la Fecha Compromiso");
			}
		}
	}
}

function BurcarCampoIns() {
	doc = document.buscarC;
	valida = 0;
	msg="";

	if( document.buscarC.buscaResponsable.value == '"' ||
		document.buscarC.buscaNomIns.value == '"'      ||
		document.buscarC.buscaFolio.value == '"'	   ){
		valida = 1;
		msg = msg + "No esta permitido colocar UNA sola comilla " + "\n";
		if(valida == 1){
			alert(msg);
		}
	}else{
			doc.buscaResponsable.value 	= Trim(doc.buscaResponsable.value);
			doc.buscaNomIns.value 		= Trim(doc.buscaNomIns.value);
			doc.buscaFolio.value 		= Trim(doc.buscaFolio.value);

				if(	Trim(doc.buscaResponsable.value) == "" &&
				Trim(doc.buscaNomIns.value) == "" &&
				Trim(doc.buscaFolio.value) == "" &&
		
				doc.buscaFechaGenI.value == "" &&
				doc.buscaFechaGenF.value == "" &&
				doc.buscaFechaVenI.value == "" &&
				doc.buscaFechaVenF.value == "" &&
		
				doc.buscaEstatus[0].checked == false &&
				doc.buscaEstatus[1].checked == false &&
				doc.buscaEstatus[2].checked == false &&
				doc.buscaEstatus[3].checked == false &&
				
				doc.buscaTipoAte[0].checked == false &&
				doc.buscaTipoAte[1].checked == false ){
		
				valida = 1;
				msg = msg + "Debe de Capturar alg\xFAn dato " + "\n";
			}
		
			if (doc.buscaTipoAte[0].checked == false &&
				doc.buscaTipoAte[1].checked == false  ){
		
				valida =1;
				msg = msg + "Debe seleccionar por lo menos un Tipo de Atenci\xF3n "+ "\n";
			}
		
			if (doc.buscaEstatus[0].checked == false &&
				doc.buscaEstatus[1].checked == false &&
				doc.buscaEstatus[2].checked == false &&
				doc.buscaEstatus[3].checked == false ){
		
				valida =1;
				msg = msg + "Debe seleccionar por lo menos un Estatus "+ "\n";
			}
		
			if (doc.semaforoAsunto[0].checked == false &&
				doc.semaforoAsunto[1].checked == false &&
				doc.semaforoAsunto[2].checked == false ){
		
				valida =1;
				msg = msg + "Debe seleccionar por lo menos un color de Semaforo "+ "\n";
			}
			
			if(doc.buscaFechaGenI.value=="" && doc.buscaFechaGenF.value==""){
				valida =1;
				msg = msg + "Debe capturar un criterio de Busqueda en La Fecha de Generaci\xF3n Inicial "+ "\n";
			}
		
			if (doc.buscaFechaGenI.value!="" && doc.buscaFechaGenF.value!="" && comparaFechas(doc.buscaFechaGenI.value,doc.buscaFechaGenF.value)==1) {
				valida =1;
				msg = msg + "La Fecha de Generaci\xF3n Inicial debe ser menor o igual a la Fecha de Generaci\xF3n Final "+ "\n";
			}
			if (doc.buscaFechaVenI.value!="" && doc.buscaFechaVenF.value!="" && comparaFechas(doc.buscaFechaVenI.value,doc.buscaFechaVenF.value)==1) {
				valida =1;
				msg = msg + "La Fecha de Vencimiento Inicial debe ser menor o igual a la Fecha de Vencimiento Final "+ "\n";
			}
			
			
			if (!validaDecimal(doc.avanceAsuntoI.value) || !validaDecimal(doc.avanceAsuntoF.value)){
				valida =1;
				msg = msg + "El formato del Avance no es valido "+ "\n";
			}else if (doc.avanceAsuntoI.value > 100 || doc.avanceAsuntoF.value > 100){
				valida =1;
				msg = msg + "El Avance debe estar entre 0% y 100% "+ "\n";
			}else if(doc.avanceAsuntoI.value=="" && doc.avanceAsuntoF.value=="" ){
				valida =1;
				msg = msg + "Debe capturar un criterio de Busqueda en Avance "+ "\n";
			}else if(parseInt(doc.avanceAsuntoI.value) > parseInt(doc.avanceAsuntoF.value)){
				valida =1;
				msg = msg + "El Avance inicial debe ser menor o igual al Avance final "+ "\n";
			}
		
			if (detectaCEBusquedaB(doc.buscaResponsable.value) || 
				detectaCEBusquedaB(doc.buscaNomIns.value) || 
				detectaCEBusquedaB(doc.buscaFolio.value) ){
				
				valida = 1;
				msg = msg + "No son permitidos los caracteres ( ' & < >  ` ´  ) "+ "\n";
			}	
			if(doc.bContenido.value == 1 && Trim(doc.buscaSobreContenido.value)==""){
				valida =1;
				msg = msg + "Debe capturar un criterio de Busqueda en Contenido"+ "\n";
			}
			if(valida == 1){
				alert(msg);
			}else{
				doc.submit();
			}
			
		}
}
function regresarBuscarIns(){
	document.buscarC.reset()
    document.buscarC.buscaResponsable.focus()
}

function regresarBCIns(){
	location.assign('Buscar.jsp');
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

function validaSoloNumeros(objeto,descripcion){
	texto = objeto.value;
	texto_sin = quitaNumeros(texto);
	if (texto_sin!="" && texto!=""){
		alert("El campo "+descripcion+" solo acepta caracteres Num\xE9ricos" );
		objeto.value = "";
	}
}




function AceptarEntidadFrame(IdArea){
	var form = document.frameentidad;
	var formP = parent.window.document.forms[0];
  	var cadena = "";
  	var numdoc=0;
	for (var i = 0; i < form.elements.length; i++) {
    	if (form.elements[i].type == "radio") {
     		if (form.elements[i].name == "Sel") {
       			if (form.elements[i].checked == true){
       				valor = form.elements[i].value;
       				if(valor != ""){
						cadena = cadena + valor;
       					numdoc=numdoc + 1;
					}
       			}
     		}
    	}
	}
	if (cadena == "")
		alert("Debe seleccionar una Entidad"); 

	else {
       	if (numdoc >1)
				alert("Debe seleccionar una Entidad");
       	else {
			var ID = valor.substring(0, valor.indexOf("|"));
			var nombre = valor.substring(valor.indexOf("|")+1, valor.indexOf("/"));
			var ar = valor.substring(valor.indexOf("/")+1, valor.length);
			window.opener.document.forms[0].idEntidad.value = ID;
			window.opener.document.forms[0].asuntoEntidad.value = nombre;
			window.opener.document.forms[0].control.value = ar;
			if (ID!=form.idEntidadRef.value){
				window.opener.document.forms[0].asuntoRemitente.value = '';
				window.opener.document.forms[0].asuntoCargo.value = '';
				window.opener.document.forms[0].asuntoCorreo.value = '';
				window.opener.document.forms[0].asuntoFirmante.value = '';
			}
			window.opener.document.forms[0].accion.value = "EditDest";
			if(ar==1){
				if(ID==IdArea){
					window.opener.document.forms[0].asuntoTipoFolio.value = 1;
				}else{
					window.opener.document.forms[0].asuntoTipoFolio.value = 0;
				}
			}else{
				window.opener.document.forms[0].asuntoTipoFolio.value = 0;
			}
			opener.hay_hija = new Boolean(false);
			opener.hija = null;
			window.opener.document.forms[0].setFoco.value = 'botDe'; //'asuntoFirmante';
			window.opener.document.Asunto.submit();
			window.close();
		}
	}
}
function AbrirF(idArea, idAsunto, control, refEntidad){
	var isCenter ='true';
	var features = '';
	if(window.screen)if(isCenter)if(isCenter=="true"){
	    var myLeft = (screen.width-800)/2;
	    var myTop = (screen.height-450)/2;
	    features+=(features!='')?',':'';
	    features+=',left='+myLeft+',top='+myTop; 
	}
	hija = window.open('FrameEntidad.jsp?id_us='+idArea+'&b='+control+'&int=1&ida='+idAsunto+'&refEntidad='+refEntidad,'hija',features+((features!='')?',':'')+'width=800, height=450, status=yes');
	hay_hija = true; 
}
function AbrirR(jsp){
	var isCenter ='true';
	var features = '';

	if(window.screen)if(isCenter)if(isCenter=="true"){
	    var myLeft = (screen.width-800)/2;
	    var myTop = (screen.height-450)/2;
	    features+=(features!='')?',':'';
	    features+=',left='+myLeft+',top='+myTop; 
	}
	hija = window.open(jsp,'hija',features+((features!='')?',':'')+'width=800, height=450, status=yes');
	hay_hija = true; 
}

function AbrirV(jsp){
	var isCenter ='true';
	var features = '';

	if(window.screen)if(isCenter)if(isCenter=="true"){
	    var myLeft = (screen.width-800)/2;
	    var myTop = (screen.height-450)/2;
	    features+=(features!='')?',':'';
	    features+=',left='+myLeft+',top='+myTop; 
	}
	hija = window.open(jsp,'hija',features+((features!='')?',':'')+'width=800, height=450, status=yes');
	hay_hija = true; 
}

function AbrirDest(paraE, iparaE, idAreaUs){

	var isCenter ='true';
	var features = '';

	if(window.screen)if(isCenter)if(isCenter=="true"){
	    var myLeft = (screen.width-800)/2;
	    var myTop = (screen.height-450)/2;
	    features+=(features!='')?',':'';
	    features+=',left='+myLeft+',top='+myTop; 
	}
	hija = window.open('listUserURExt.jsp?para=' + paraE + '&ipara=' + iparaE + '&idAreaUs='+ idAreaUs ,'hija',features+((features!='')?',':'')+'width=800, height=450, status=yes');
	hay_hija = true; 
}

function focos(){
	doc = document.Asunto;
	foc = doc.focus.value;
	if(foc == 1){
		doc.asuntoTipoDocto.focus();
	}
}
function corrigeFormatoFecha(fecha){
	fecha_nueva = "";
	i = 0;
	i = fecha.indexOf('/',i);
	dia = "" + fecha.substring(0,i);
	if (dia.length==1)
		dia = "0" + dia;	

	j = fecha.indexOf('/',i+1);
	mes = "" + fecha.substring(i+1,j);
	if (mes.length==1)
		mes = "0" + mes;
		
	anio = fecha.substring(j+1,fecha.length);
	
	fecha_nueva = dia + "/" + mes + "/" + anio; 
	return fecha_nueva;
}

function pruebaCom(opcion){
	doc = document.Asunto;
	doc.id_tra.value = opcion;
	if(opcion==-1)
		doc.asuntoFechaCad.value = "";
	doc.submit();
}
function focoTra(){
	doc = document.Asunto;
	if(doc.id_tra.value!="")
		doc.asuntoTramite.focus();
}
function keyTra(){
	doc = document.Asunto;
	if(doc.id_tra.value!="" && doc.id_tra.value!=-1)
		doc.submit();
}

function cambioFechaCompro(opcion){
	doc = document.Asunto;
	var cadena = "";
	if(opcion.options[opcion.selectedIndex].value != "-1"){
		cadena = opcion.options[opcion.selectedIndex].value.substring((opcion.options[opcion.selectedIndex].value.indexOf('|')+1), opcion.options[opcion.selectedIndex].value.length);
		cadena = corrigeFormatoFecha(cadena);
		doc.asuntoFechaCad.value = cadena;
		doc.asuntoFechaCad.style.display='none';
		doc.fechaOcultoCompromiso.value = cadena;
		doc.fechaOcultoCompromiso.style.display='inline';
		doc.fechaCom.style.display='none';
	}else{
		doc.asuntoFechaCad.value = "";
		doc.asuntoFechaCad.style.display='inline';
		doc.fechaOcultoCompromiso.value = cadena;
		doc.fechaOcultoCompromiso.style.display='none';
		doc.fechaCom.style.display='inline';
	}
}

function Abrir(para, cc, ipara, icc){

	var isCenter ='true';
	var features = '';

	if(window.screen)if(isCenter)if(isCenter=="true"){
	    var myLeft = (screen.width-800)/2;
	    var myTop = (screen.height-450)/2;
	    features+=(features!='')?',':'';
	    features+=',left='+myLeft+',top='+myTop; 
	}	
	hija = window.open('listUserUR.jsp?para=' + para + '&cc=' + cc + '&ipara=' + ipara + '&icc= ' +icc  ,'hija',features+((features!='')?',':'')+'width=800, height=450, status=yes');
	hay_hija = true; 
}

function AbrirPara(tipo, idArea ,para, cc, ipara, icc){
	var isCenter ='true';
	var features = '';

	if(window.screen)if(isCenter)if(isCenter=="true"){
	    var myLeft = (screen.width-800)/2;
	    var myTop = (screen.height-450)/2;
	    features+=(features!='')?',':'';
	    features+=',left='+myLeft+',top='+myTop; 
	}	
	hija = window.open('listUserUR.jsp?para='+ para +'&idAreaGen='+ idArea +'&tipoFolio=' + tipo + '&cc=' + cc + '&ipara=' + ipara + '&icc= ' +icc  ,'hija',features+((features!='')?',':'')+'width=800, height=450, status=yes');
	hay_hija = true; 
}

function AbrirCatDinamic(jsp){

	var isCenter ='true';
	var features = '';

	if(window.screen)if(isCenter)if(isCenter=="true"){
	    var myLeft = (screen.width-700)/2;
	    var myTop = (screen.height-500)/2;
	    features+=(features!='')?',':'';
	    features+=',left='+myLeft+',top='+myTop; 
	}	
	hija = window.open(jsp ,'hija',features+((features!='')?',':'')+'width=700, height=500, status=yes');
	hay_hija = true; 
}

function buscarEntidad(){
	doc = document.frameentidad;
	valida = 0;
	msg = "";

	doc.buscar.value = Trim(doc.buscar.value);

	if (detectaCEBusqueda(doc.buscar.value)) {
		valida =1;
		msg = msg + "No se permiten caracteres especiales ( ' % & < > \" ` ´  ) en la Busqueda "+ "\n";
	}
	if (valida == 1) {
		alert(msg);
	}else{
		doc.submit();
	}
}

function guardarEntidadOtro() { 

	doc = document.dEntidad;
	
	valida = 0;
	msg="";

	if (doc.entidadArea[doc.entidadArea.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debe seleccionar una Unidad Administrativa	"+ "\n";
	}
	if (Trim(doc.entidad.value) =="") {
		valida =1;
		msg = msg + " Debe capturar el nombre de la Entidad	"+ "\n";
	}
	if (!isTelefono(Trim(doc.tel.value))) {
		valida =1;
		msg = msg + " El n\xFAmero de Tel\xE9fono es inv\xE1lido	"+ "\n";
	}
	if (Trim(doc.direccion.value)=="" && doc.direccion.value.length>0) {
		valida =1;
		msg = msg + " La Direcci\xF3n no debe contener espacios vacios"+ "\n";
	}
	if (Trim(doc.tel.value)=="" && doc.tel.value.length>0) {
		valida =1;
		msg = msg + " El Tel\xE9fono no debe contener espacios vacios"+ "\n";
	}
	if (valida == 1) 
	{
		alert(msg);
		doc.accion.value="";
	} 
	else 
	{
		mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar'
		if(detectaCE(doc.direccion.value) || detectaCE(doc.entidad.value)){
			if (confirm(mensaje)){

				doc.entidad.value		= quitaCE(doc.entidad.value);
				doc.direccion.value		= quitaCE(doc.direccion.value);
				
				doc.accion.value="guardar";
				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			doc.accion.value="guardar";
			doc.submit();
		}
	}
}

function guardarRemitenteOtro() { 

	doc = document.dRemitente;
	valida = 0;
	msg="";

	if (doc.remitenteArea[doc.remitenteArea.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar una Unidad	"+ "\n";
	}
	if (Trim(doc.remitente.value) =="") {
		valida =1;
		msg = msg + " Debes capturar el nombre del Remitente	"+ "\n";
	}
	if (doc.remitenteEntidad[doc.remitenteEntidad.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar una Entidad para el Remitente	"+ "\n";
	}
	if (!isTelefono(Trim(doc.remitenteTelefono.value))) {
		valida =1;
		msg = msg + " El n\xFAmero de Tel\xE9fono es inv\xE1lido	"+ "\n";
	}
	if (Trim(doc.remitenteCargo.value)=="" && doc.remitenteCargo.value.length>0) {
		valida =1;
		msg = msg + " El Cargo no debe contener espacios vacios"+ "\n";
	}
	if (Trim(doc.remitenteDireccion.value)=="" && doc.remitenteDireccion.value.length>0) {
		valida =1;
		msg = msg + " La Direcci\xF3n no debe contener espacios vacios"+ "\n";
	}
	if (Trim(doc.remitenteTelefono.value)=="" && doc.remitenteTelefono.value.length>0) {
		valida =1;
		msg = msg + " El Tel\xE9fono no debe contener espacios vacios"+ "\n";
	}
	if (!isTelefono(Trim(doc.remitenteFax.value))) {
		valida =1;
		msg = msg + " El n\xFAmero de Fax es inv\xE1lido	"+ "\n";
	}
	if (Trim(doc.remitenteFax.value)=="" && doc.remitenteFax.value.length>0) {
		valida =1;
		msg = msg + " El Fax no debe contener solo espacios vacios"+ "\n";
	}
	if (!isCorreo(Trim(doc.remitenteCorreo.value))) {
		valida =1;
		msg = msg + " El Correo Electr\xF3nico es inv\xE1lido	"+ "\n";
	}
	if (Trim(doc.remitenteCorreo.value)=="" && doc.remitenteCorreo.value.length>0) {
		valida =1;
		msg = msg + " El Correo no debe contener espacios vacios"+ "\n";
	}

	if (valida == 1) 
	{
		alert(msg);
		return false;
	} 
	else 
	{
		mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar'
		if(detectaCE(doc.remitenteDireccion.value) || detectaCE(doc.remitenteCargo.value) || detectaCE(doc.remitente.value)){
			if (confirm(mensaje)){

				doc.remitenteDireccion.value		= quitaCE(doc.remitenteDireccion.value);
				doc.remitenteCargo.value		= quitaCE(doc.remitenteCargo.value);
				doc.remitente.value		= quitaCE(doc.remitente.value);
					
				doc.accion.value="guardar";
				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			doc.accion.value="guardar";
			doc.submit();
		}
	}
}

function buscarRemitente(){
	doc = document.frameremitente;
	valida = 0;
	msg = "";

	doc.buscar.value = Trim(doc.buscar.value);

	if (detectaCEBusqueda(doc.buscar.value)) {
		valida =1;
		msg = msg + "No se permiten caracteres especiales ( ' % & < > \" ` ´  ) en la Busqueda por Puesto "+ "\n";
	}
	if (detectaCEBusqueda(doc.buscar2.value)) {
		valida =1;
		msg = msg + "No se permiten caracteres especiales ( ' % & < > \" ` ´  ) en la Busqueda por Responsable "+ "\n";
	}
	if (valida == 1) {
		alert(msg);
	}else{
		doc.submit();
	}
}

function AceptarRemitenteFrame(control){
		
	var form = document.forms[0];
	var formP = parent.window.document.forms[0];
  	var cadena = "";
  	var numdoc=0;
	for (var i = 0; i < form.elements.length; i++) {
    	if (form.elements[i].type == "radio") {
    		if (form.elements[i].name == "Sel") {
       			if (form.elements[i].checked == true){
       				valor = form.elements[i].value;
       				if(valor != ""){
						cadena = cadena + valor;
       					numdoc=numdoc + 1;
					}
       			}
    		}
    	}
	}
	if (cadena == "")
		alert("Debes seleccionar un Remitente"); 

	else {
       	if (numdoc >1)
				alert("Debes seleccionar un Remitente");
       	else {
			var ID = valor.substring(0, valor.indexOf("|"));
			var nombre = valor.substring(valor.indexOf("|")+1, valor.indexOf("/"));
			var cargo = valor.substring(valor.indexOf("/")+1, valor.indexOf("*"));
			var correo = valor.substring(valor.indexOf("*")+1, valor.length);
			window.opener.document.forms[0].idRemitente.value = ID;
			if(control==1){
				window.opener.document.forms[0].asuntoRemitente.value = cargo+" / "+nombre; //nombre;
				window.opener.document.forms[0].asuntoCargo.value = cargo; //cargo;
				window.opener.document.forms[0].asuntoFirmante.value = cargo +" / "+nombre; //cargo;
			}else{
				window.opener.document.forms[0].asuntoRemitente.value = nombre+" / "+cargo; //nombre;
				window.opener.document.forms[0].asuntoCargo.value = nombre; //cargo;
				window.opener.document.forms[0].asuntoFirmante.value = nombre +" / "+cargo; //cargo;
			}
			window.opener.document.forms[0].asuntoCorreo.value = correo;
			window.opener.document.forms[0].accion.value = "EditDest";

			opener.hay_hija = new Boolean(false);
			opener.hija = null;
			window.opener.document.forms[0].setFoco.value = 'asuntoFirmante';
			window.opener.document.Asunto.submit();
			window.close();
		}
	}
}

//funci\xF3n que se encarga de mandar el foco el el campo de asunto
function cargaFoco(){
	doc = document.Asunto;
	if (doc.setFoco.value == 'asunto'){
		doc.asunto.focus();
	}
	else{
		var elemento = document.getElementsByName(doc.setFoco.value);
		if(elemento[0]!=null){
			elemento[0].focus();
		}
	}
}
function windowExt()
{
	window.open('DinamicExterno.jsp','window','width=620,height=350');
	window.focus;
}

function guardarEntidadOtro1() { 

	doc = document.frameentidad;
	valida = 0;
	msg="";

	if (doc.entidadArea[doc.entidadArea.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debe seleccionar una Unidad Administrativa	"+ "\n";
	}
	if (Trim(doc.entidad.value) =="") {
		valida =1;
		msg = msg + " Debe capturar el nombre de la Entidad	"+ "\n";
	}
	if (!isTelefono(Trim(doc.tel.value))) {
		valida =1;
		msg = msg + " El n\xFAmero de Tel\xE9fono es inv\xE1lido	"+ "\n";
	}
	if (Trim(doc.direccion.value)=="" && doc.direccion.value.length>0) {
		valida =1;
		msg = msg + " La Direcci\xF3n no debe contener espacios vacios"+ "\n";
	}
	if (Trim(doc.tel.value)=="" && doc.tel.value.length>0) {
		valida =1;
		msg = msg + " El Tel\xE9fono no debe contener espacios vacios"+ "\n";
	}
	if (valida == 1) 
	{
		alert(msg);
		doc.accion.value="";
	} 
	else 
	{
		mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar'
		if(detectaCE(doc.direccion.value) || detectaCE(doc.entidad.value)){
			if (confirm(mensaje)){
				doc.entidad.value		= quitaCE(doc.entidad.value);
				doc.direccion.value		= quitaCE(doc.direccion.value);
				doc.accion.value="guardar";
				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			doc.accion.value="guardar";
			doc.submit();
		}
	}
}
function guardarRemitenteOtro1() { 

	doc = document.frameremitente;
	valida = 0;
	msg="";

	if (Trim(doc.remitente.value) =="") {
		valida =1;
		msg = msg + " Debes capturar el Nombre del Remitente	"+ "\n";
	}
	if (Trim(doc.remitenteCargo.value) =="") {
		valida =1;
		msg = msg + " Debes capturar el Cargo del Remitente	"+ "\n";
	}
	if (doc.remitenteEntidad[doc.remitenteEntidad.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar una Entidad para el Remitente	"+ "\n";
	}
	if (!isTelefono(Trim(doc.remitenteTelefono.value))) {
		valida =1;
		msg = msg + " El n\xFAmero de Tel\xE9fono es inv\xE1lido	"+ "\n";
	}
	if (Trim(doc.remitenteCargo.value)=="" && doc.remitenteCargo.value.length>0) {
		valida =1;
		msg = msg + " El Cargo no debe contener espacios vacios"+ "\n";
	}
	if (Trim(doc.remitenteDireccion.value)=="" && doc.remitenteDireccion.value.length>0) {
		valida =1;
		msg = msg + " La Direcci\xF3n no debe contener espacios vacios"+ "\n";
	}
	if (Trim(doc.remitenteTelefono.value)=="" && doc.remitenteTelefono.value.length>0) {
		valida =1;
		msg = msg + " El Tel\xE9fono no debe contener espacios vacios"+ "\n";
	}
	if (!isTelefono(Trim(doc.remitenteFax.value))) {
		valida =1;
		msg = msg + " El n\xFAmero de Fax es inv\xE1lido	"+ "\n";
	}
	if (Trim(doc.remitenteFax.value)=="" && doc.remitenteFax.value.length>0) {
		valida =1;
		msg = msg + " El Fax no debe contener solo espacios vacios"+ "\n";
	}
	if (!isCorreo(Trim(doc.remitenteCorreo.value))) {
		valida =1;
		msg = msg + " El Correo Electr\xF3nico es inv\xE1lido	"+ "\n";
	}
	if (Trim(doc.remitenteCorreo.value)=="" && doc.remitenteCorreo.value.length>0) {
		valida =1;
		msg = msg + " El Correo no debe contener espacios vacios"+ "\n";
	}

	if (valida == 1) 
	{
		alert(msg);
		return false;
	} 
	else 
	{
		mensaje = 'Algunos de los campos tienen caracteres inv\xE1lidos (&, ", <, >, \', `,´)\nPresione Aceptar para eliminarlos autom\xE1ticamente\no Cancelar para regresar'
		if(detectaCE(doc.remitenteDireccion.value) || detectaCE(doc.remitenteCargo.value) || detectaCE(doc.remitente.value)){
			if (confirm(mensaje)){

				doc.remitenteDireccion.value		= quitaCE(doc.remitenteDireccion.value);
				doc.remitenteCargo.value		= quitaCE(doc.remitenteCargo.value);
				doc.remitente.value		= quitaCE(doc.remitente.value);
					
				doc.accion.value="guardar";
				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			doc.accion.value="guardar";
			doc.submit();
		}
	}
}

function trunc(s, idElemento){
	var newText=s;
	var prevWidth=0;
	var ix=s.length;
        
    var objeto = document.getElementById(idElemento); 
    var pixels = objeto.offsetWidth - 45;
        
	while (textWidth(newText) > pixels ){
		newText=s.substr(0,ix);
		ix--;
	}
    if (ix !=  s.length) 
    	return newText + '...';
    else 
    	return newText;
}

function textWidth(s){ 
	var rulerSpan = document.getElementById('ruler'); 
    rulerSpan.innerHTML = s; 
    return rulerSpan.offsetWidth; 
}