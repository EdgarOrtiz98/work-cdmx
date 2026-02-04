


function cierraVentana(ventana){
     parent.document.getElementById(ventana).style.display="none";
     parent.document.getElementById("transparencia").style.display="none";
}


function submitVentana(accion,idLink,form,ventana) {
	form.accion.value=accion;
	form.idLink.value=idLink;
	if(ventana!=null){
	   cierraVentana(ventana);
	}
	form.submit();
}

function submitParent(accion,idLink){

		parent.document.forms[0].accion.value=accion;
		parent.document.forms[0].idLink.value=idLink;
	    parent.document.forms[0].submit();
	    
}

function submitParentAsunto(accion,idLink){
		parent.document.asuntoForm.accion.value=accion;
		parent.document.asuntoForm.idLink.value=idLink;
	    parent.document.asuntoForm.submit();
}
