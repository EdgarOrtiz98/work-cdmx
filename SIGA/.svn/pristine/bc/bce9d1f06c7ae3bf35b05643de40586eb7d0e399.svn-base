
var READY_STATE_UNINITIALIZED=0;
var READY_STATE_LOADING=1;
var READY_STATE_LOADED=2;
var READY_STATE_INTERACTIVE=3;
var READY_STATE_COMPLETE=4;

var http_request = getXMLHTTPRequest();

function getXMLHTTPRequest() {
   if (window.XMLHttpRequest) {
       return new XMLHttpRequest();
    }else if (window.ActiveXObject) {
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function cargaUrl(url,accion,funcion){
   url = url + accion;
      if(http_request) {
	     http_request.open('GET', url , true);
	     http_request.send(null);
	     http_request.onreadystatechange = funcion;
      }
}

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

function muestraUsuarios(){
   if(http_request.readyState == READY_STATE_COMPLETE) {
     if (http_request.status == 200) {
        var usuarios = http_request.responseXML.getElementsByTagName("usuario");
        if(usuarios!=null){
           var usuariosHtml = "<table width='180' border='0' cellspacing='2' cellpadding='1'   bordercolor='#666666' style='border:dashed; border-width:thin;' bgcolor='#FFFFFF'>";
	       for (i = 0; i < usuarios.length; i++) {
				var nombre = usuarios[i].getAttribute("nombre");
				var id = usuarios[i].getAttribute("id");
				usuariosHtml = usuariosHtml +"<tr id = 'row_"+id+"' onmouseover=\"seleccionarRenglon(this);document.body.style.cursor='pointer'; return false;\" ";
				usuariosHtml = usuariosHtml + " onmouseout=\"deseleccionarRenglon(this);document.body.style.cursor='auto'; return false;\" ";
				usuariosHtml = usuariosHtml + " onclick=\"seleccionaNombre('"+nombre+"',"+id+")\">";
				usuariosHtml = usuariosHtml + "<td>" + nombre + "</td></tr>";
			}
		   usuariosHtml = usuariosHtml+"</table>"
		   var divLista = document.getElementById("divUsuarios")
		   divLista.innerHTML=usuariosHtml;
		   if (usuarios.length == 0){
				divLista.style.display = "none";
			}else{
			   var posX=0;
			   var posY=0;
			   var destinoObj= document.getElementById("busqueda");
			   if(getNavegador()==0){
        		  posX=destinoObj.offsetLeft+document.documentElement.scrollLeft;
       			  posY=destinoObj.offsetTop+document.documentElement.scrollTop;
  		       }if(getNavegador()==1){    
        		  posX=destinoObj.offsetLeft+window.pageXOffset;
       			  posY=destinoObj.offsetTop+window.pageYOffset;
   		       }
   		       while (destinoObj.offsetParent) {
     			   posX += destinoObj.offsetLeft;
        		   posY += destinoObj.offsetTop;
        		   destinoObj=destinoObj.offsetParent;
     			}
                divLista.style.top=posY+15+"px";
				divLista.style.left=posX+"px";
				divLista.style.display = "block";
			}
	    }
      }
    }
}

function compruebaAreaDestinatarios(idAreaGen,listaPara,listaCC,tipoFolio){

   if(tipoFolio==0){
      var url = "../AjaxUtil?accion=compruebaAreaDestinatarios&listaPara="+listaPara+"&listaCC="+listaCC+"&idAreaGen=";
         cargaUrl(url,idAreaGen,getMensajeComprobacion);
      }else{
      	aceptarListAsk();
      }
} 

function seleccionaNombre(nombre,id){
   document.getElementById("busqueda").value=nombre;
   document.getElementById("divUsuarios").style.display = "none";
   cargaUrl('./EstructuraOrganizacionalAjax?accion=seleccionar&idPuesto=',id,muestraOrganigrama)
}

function muestraOrganigrama(){
 if(http_request.readyState == READY_STATE_COMPLETE) {
     if (http_request.status == 200) {
 		var orgPrincipal= http_request.responseXML.getElementsByTagName("principal")[0];
 		var orgSinRelacion= http_request.responseXML.getElementsByTagName("sinRelacion")[0];
 		var principalHTML = getPuestoHTML(orgPrincipal.childNodes[0]);
 		var sinRelacionHTML="";
 		for(var j = 0; j < orgSinRelacion.childNodes.length; j++){
 		   sinRelacionHTML = sinRelacionHTML + getPuestoHTML(orgSinRelacion.childNodes[j]);
 		}
 		if(orgSinRelacion.childNodes.length==0){
 		   sinRelacionHTML="** No tiene Subalternos asignados **";
 		}
 		if(orgPrincipal.childNodes.length==0){
 		   principalHTML="";
 		}
 		document.getElementById("orgPrincipal").innerHTML=principalHTML;
 		document.getElementById("orgNoRelacionado").innerHTML=sinRelacionHTML;
      }
    }
}

function getPuestoHTML(puesto){
   var idUsuario = puesto.getAttribute("idUsuario")
   var cargo = puesto.getAttribute("cargo")
   var nombre = puesto.getAttribute("nombre")
   var desplegado = puesto.getAttribute("desplegado");
   var seleccionado = puesto.getAttribute("seleccionado");
   var puestoHTML = "<DIV id = 'puesto_" + idUsuario + "'><DL><DT>";
   if(puesto.childNodes.length!=0){
      if(desplegado=="true"){
         puestoHTML = puestoHTML + "<img src =\"./Imagenes/nolines_minus.gif\" ";
      }else{
		 puestoHTML = puestoHTML + "<img src =\"./Imagenes/nolines_plus.gif\" ";
	  }
	  puestoHTML = puestoHTML + " id=\"expadir_"+idUsuario+"\" ";
	  puestoHTML = puestoHTML + "onclick=\"muestraOcultaSubordinados('subordinados_"+ idUsuario + "',this);return false;\" />";
   }else{
	  puestoHTML = puestoHTML + "<img src =\"./Imagenes/noLines_join.gif\" />";
   }  
   puestoHTML = puestoHTML + "<A  href = './puesto.siga?accion=mostrarPuesto&idLink=" + idUsuario + "' title='" + nombre + "'>";
   if(seleccionado=="true"){
      puestoHTML = puestoHTML + "<B style='color:#FF0000;'>"+cargo + "/" + nombre+"</B>";
   }else{
      puestoHTML = puestoHTML + cargo + "/" + nombre;
   }
   puestoHTML = puestoHTML + "</A>";
   if(desplegado=="true"){
	  puestoHTML = puestoHTML + "<DIV style=\"display: block;\" ";
	}else{
	  puestoHTML = puestoHTML + "<DIV style=\"display: none;\" ";
	}
    puestoHTML = puestoHTML + " id = 'subordinados_" + idUsuario + "'>";
    for (var i = 0; i < puesto.childNodes.length; i++) {
			puestoHTML = puestoHTML + getPuestoHTML(puesto.childNodes[i]);
	}
    puestoHTML = puestoHTML + "</DIV><DT></DL></DIV>";
    return puestoHTML;
}

function getMensajeComprobacion(){
   if(http_request.readyState == READY_STATE_COMPLETE) {
     if (http_request.status == 200) {
        var alerta = http_request.responseXML.getElementsByTagName("alerta")[0];
             if(alerta!=null){
     	   var mensaje = alerta.getAttribute("mensaje");
           if(mensaje!='OK'){
	     	   if(confirm(mensaje)){
	     		   aceptarListAsk();
	         }
		   }else{
			 aceptarListAsk();
		   }
        }
      }
    }
}


function aceptarListAsk(){
		
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

function seleccionarRenglon(renglon) {
	transicionBackground = renglon.style.backgroundColor;
	transicionColor = renglon.style.color;
	renglon.style.backgroundColor = "#E0E0E0";
}

function deseleccionarRenglon(renglon) {
	renglon.style.backgroundColor = transicionBackground;
	renglon.style.color = transicionColor;
}