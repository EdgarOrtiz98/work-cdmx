
var ROL_ADMINISTRADOR = 0;
var ROL_ATENCION = 1;
var ROL_SCP =2;
var ROL_RECEPCION = 3;
var ROL_SUPERVISOR =4;
var ROL_TURNADOR = 5;
var ROL_ASISTENTE =6;

function seleccionaRol(rolObj){

   var rolChecked = rolObj.checked;
   var chkAdmin = document.getElementById("chkAdministrador");
   var chkAtencion = document.getElementById("chkAtencion");
   var chkSCP = document.getElementById("chkSCP");
   var chkRecepcion = document.getElementById("chkRecepcion");
   var chkSupervisor = document.getElementById("chkSupervisor");
   var chkTurnador = document.getElementById("chkTurnador");
   var chkAsistente = document.getElementById("chkAsistente");

   var chkMailNuevoAsu = document.getElementById("chkMailNuevoAsu");
   var chkMailTurnarIns = document.getElementById("chkMailTurnarIns");
   var chkMailResponderIns = document.getElementById("chkMailResponderIns");
   var chkNuevoAsunto = document.getElementById("chkMailRechazarIns");
   var chkMailDelegarIns = document.getElementById("chkMailDelegarIns");
   var chkMailReasignarIns = document.getElementById("chkMailReasignarIns");
   var chkMailHabilitarIns = document.getElementById("chkMailHabilitarIns");
   var chkMailCambioFechaIns = document.getElementById("chkMailCambioFechaIns");
   var chkMailResCambioFechaIns = document.getElementById("chkMailResCambioFechaIns");

   var chkAsistentes = document.getElementsByName("idAsistentes");
   switch(parseInt(rolObj.value)){
      case ROL_ADMINISTRADOR:
         if(rolChecked){
            chkAtencion.checked = !rolChecked;
            chkSCP.checked = !rolChecked;
   		    chkRecepcion.checked = !rolChecked;
            chkSupervisor.checked = !rolChecked;
		    chkTurnador.checked = !rolChecked;
		    chkAsistente.checked = !rolChecked;
		    
		    chkMailNuevoAsu.checked = !rolChecked;
		    chkMailTurnarIns.checked = !rolChecked;
		    chkMailResponderIns.checked = !rolChecked;
		    chkNuevoAsunto.checked = !rolChecked;
		    chkMailDelegarIns.checked = !rolChecked;
		    chkMailReasignarIns.checked = !rolChecked;
		    chkMailHabilitarIns.checked = !rolChecked;
		    chkMailCambioFechaIns.checked = !rolChecked;
		    chkMailResCambioFechaIns.checked = !rolChecked;
		    
		    chkMailNuevoAsu.disabled = rolChecked;
		    chkMailTurnarIns.disabled = rolChecked;
		    chkMailResponderIns.disabled = rolChecked;
		    chkNuevoAsunto.disabled = rolChecked;
		    chkMailDelegarIns.disabled = rolChecked;
		    chkMailReasignarIns.disabled = rolChecked;
		    chkMailHabilitarIns.disabled = rolChecked;
		    chkMailCambioFechaIns.disabled = rolChecked;
		    chkMailResCambioFechaIns.disabled = rolChecked;
            for(var i = 0; i<chkAsistentes.length;i++) {
               chkAsistentes[i].disabled = rolChecked;
               chkAsistentes[i].checked = !rolChecked;
           }
     
	
        }
        
         chkAtencion.disabled = rolChecked;
         chkSCP.disabled = rolChecked;
   		 chkRecepcion.disabled = rolChecked;
         chkSupervisor.disabled = rolChecked;
		 chkTurnador.disabled = rolChecked;
		 chkAsistente.disabled = rolChecked;

         break;
      case ROL_ATENCION:
		 chkMailResponderIns.checked = rolChecked;
		 chkMailDelegarIns.checked = rolChecked;
		 chkMailReasignarIns.checked = rolChecked;
		 chkMailHabilitarIns.checked = rolChecked;
		 chkMailCambioFechaIns.checked = rolChecked;
		 
		 chkMailResponderIns.disabled = !rolChecked;
		 chkMailDelegarIns.disabled = !rolChecked;
		 chkMailReasignarIns.disabled = !rolChecked;
		 chkMailHabilitarIns.disabled = !rolChecked;
		 chkMailCambioFechaIns.disabled = !rolChecked;
		 
		 document.getElementById("chkAtencionExternos").disabled = !rolChecked;
         for(var i = 0; i<chkAsistentes.length;i++) {
           chkAsistentes[i].disabled = !rolChecked;
         }
         break;
         
      case ROL_RECEPCION:
         chkMailNuevoAsu.checked = rolChecked;
		 chkMailNuevoAsu.disabled = !rolChecked;
         break;
      case ROL_TURNADOR:
         chkMailNuevoAsu.checked = rolChecked;
		 chkMailTurnarIns.checked = rolChecked;
		 chkMailResCambioFechaIns.checked = rolChecked;

         chkMailNuevoAsu.disabled = !rolChecked;
		 chkMailTurnarIns.disabled = !rolChecked;
		 chkMailResCambioFechaIns.disabled = !rolChecked;
         break;
      case ROL_ASISTENTE:
         if(rolChecked){
            chkAdmin.checked = !rolChecked;
        	chkAtencion.checked = !rolChecked;
   		 	chkRecepcion.checked = !rolChecked;
         	chkSupervisor.checked = !rolChecked;
		 	chkTurnador.checked = !rolChecked;

         	chkMailNuevoAsu.checked = !rolChecked;
		 	chkMailTurnarIns.checked = !rolChecked;
		 	chkMailResCambioFechaIns.checked = !rolChecked;

         	chkMailNuevoAsu.disabled = rolChecked;
		 	chkMailTurnarIns.disabled = rolChecked;
		 	chkMailResCambioFechaIns.disabled = rolChecked;
		 	         
            if(chkAsistentes){
           	   for(var i = 0; i<chkAsistentes.length;i++) {
                  chkAsistentes[i].disabled = rolChecked;
                  chkAsistentes[i].checked = !rolChecked;
            	}
            }
         }      
         
         chkMailResponderIns.disabled = !rolChecked;
		 chkNuevoAsunto.disabled = !rolChecked;
		 chkMailDelegarIns.disabled = !rolChecked;
		 chkMailReasignarIns.disabled = !rolChecked;
		 chkMailHabilitarIns.disabled = !rolChecked;
		 chkMailCambioFechaIns.disabled = !rolChecked;
         
         chkMailResponderIns.checked = rolChecked;
		 chkNuevoAsunto.checked = rolChecked;
		 chkMailDelegarIns.checked = rolChecked;
		 chkMailReasignarIns.checked = rolChecked;
		 chkMailHabilitarIns.checked = rolChecked;
		 chkMailCambioFechaIns.checked = rolChecked;

         chkAdmin.disabled = rolChecked;
         chkAtencion.disabled = rolChecked;
         chkSCP.disabled = rolChecked;
   		 chkRecepcion.disabled = rolChecked;
         chkSupervisor.disabled = rolChecked;
		 chkTurnador.disabled = rolChecked;
         break;
   }
}

function muestraOcultaRoles(idRol){
   rolImg = document.getElementById("img_"+idRol);
   rolDiv = document.getElementById("div_"+idRol);
   if(rolDiv.style.display=="none"){
      rolDiv.style.display="block";
      rolImg.src="./Imagenes/collapse.gif";
   }else{
      rolDiv.style.display="none";
      rolImg.src="./Imagenes/expand.gif";
   }
}

function setChecksAsistentes(idAsistentes){
   var chkAsistentes = document.getElementsByName("idAsistentes");
   if(chkAsistentes&&chkAsistentes){
      for(i=0;i<chkAsistentes.length;i++){
         for( j =0;j<idAsistentes.length;j++){
            if(chkAsistentes[i].value==idAsistentes[j]){
               chkAsistentes[i].checked="checked";
               break;
            }
         
         }
      }
   }
}

function setCheckRoles(idsRoles){
   var chkRoles = document.getElementsByName("idRoles");
   if(idsRoles&&chkRoles){
     for(i=0;i<chkRoles.length;i++){
         for(j=0;j<idsRoles.length;j++){
            if(chkRoles[i].value==idsRoles[j]){
 			   chkRoles[i].checked="checked";
 			   seleccionaRol(chkRoles[i]);
               break;
            }
         }
      }
   }
}

function setChecksCorreos(idsCorreos){
   var chkCorreos = document.getElementsByName("idCorreosSalida");
   if(idsCorreos&&chkCorreos){
     for(i=0;i<chkRoles.length;i++){
         for(j=0;j<idsRoles.length;j++){
            if(chkRoles[i].value==idsRoles[j]){
 			   chkRoles[i].checked="checked";
 			   seleccionaRol(chkRoles[i]);
               break;
            }
         }
      }
   }
}