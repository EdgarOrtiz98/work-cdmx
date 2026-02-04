<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,java.util.ArrayList,com.meve.sigma.taglib.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}

	String strSeleccion		=	""; 
	String strUsuarioSel	=	"";
	String strAreaSel		=	"";
	String strSupervisor	=	"";
	String strOrganigrama	=	"";
	String strMes	=	"";
	String strAsistente		=	"";

	String strCompanieros[][]		=	null;
	java.util.Stack st = new java.util.Stack();
	String cadenaMandoUsuario[][]	=	null;
	String usuario [][]				=	null;
	String area[][]					=	null;
	String strMiembros[][]			=	null;
	ArrayList subalternosUsuario	=	null;

	strSeleccion	=	request.getParameter("laSeleccion");
	strUsuarioSel	=	request.getParameter("usuarioSeleccionado");
	strAreaSel		=	request.getParameter("areaSeleccionada");
	strOrganigrama	=	request.getParameter("Organigrama");
	strMes	=	request.getParameter("mesSeleccionado");

	if(strSeleccion != null)
		strSeleccion=strSeleccion.toLowerCase();
 
 	boolean existeSeleccion	=	strSeleccion != null;
	
 	String usuarios[][]	=	ActualizaUsuario.getListaUsuarios();
 	String areas[][]	=	ActualizaUsuario.getAreas();
	
	//** Se ejecuta cuando es seleccionado un Usuario
	if(strUsuarioSel != null && strUsuarioSel.length() > 0)
	{
		ActualizaUsuario.getHistConfig(strUsuarioSel,strAreaSel,strMes); 

	}

%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Historial</TITLE>
<SCRIPT language="JavaScript" type="text/javascript">
	
	function seleccion()
	{
  		

		usu = document.historiaform.usuarios.value;
		area = document.historiaform.areas.value;
		mes = document.historiaform.mes.value;

	location.assign('HistorialAsunto.jsp?usuarioSeleccionado='+usu+'&areaSeleccionada='+area+'&mesSeleccionado='+mes);

	}

	function obtenSeleccion(control)
	{
    	if(control.selected)
			return control.value;
		else
    		for(var i=0;i<control.length;i++){

        	if(control[i].selected)
				return control[i].value;
		}
	}

	var digitos=10 //cantidad de digitos buscados 
	var puntero=0 
	var buffer=new Array(digitos) //declaración del array Buffer 
	var cadena="" 

	function buscar_opOR(obj){
		var forma=document.laForma;
	   	var letra = String.fromCharCode(event.keyCode)
	   	if(puntero >= digitos){ 
	    	cadena=""; 
	       	puntero=0; 
	    } 
	   	if (event.keyCode == 13){ 
	    	borrar_buffer(); 
			var cad="";
			if(obj.options[obj.selectedIndex].value!="-1")
			{
				var a = forma.usuarios.value;
				//location.assign('Pasos.jsp?id_area='+a);
				location.assign('Organigrama.jsp?usuarioSeleccionado='+a);
			}
	    } 
	   	else{ 
	       	buffer[puntero]=letra; 
	       	cadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array 
	       	puntero++; 
	
	       	for (var opcombo=0;opcombo < obj.length;opcombo++){ 
	          	if(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ 
	          		obj.selectedIndex=opcombo; 
	        	} 
	       	} 
	    } 
	   	event.returnValue = false; //invalida la acción de pulsado de tecla para evitar busqueda del primer caracter 
	}
	function borrar_bufferOR(){ 
    	cadena=""; 
    	puntero=0; 
	}

	function buscar_opAR(obj){
		var forma=document.laForma;
	   	var letra = String.fromCharCode(event.keyCode)
	   	if(puntero >= digitos){ 
	    	cadena=""; 
	       	puntero=0; 
	    } 
	   	if (event.keyCode == 13){ 
	    	borrar_buffer(); 
			var cad="";
			if(obj.options[obj.selectedIndex].value!="-1")
			{
				var a = forma.areas.value;
				//location.assign('Pasos.jsp?id_area='+a);
				location.assign('Organigrama.jsp?areaSeleccionada='+a);
			}
	    } 
	   	else{ 
	       	buffer[puntero]=letra; 
	       	cadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array 
	       	puntero++; 
	
	       	for (var opcombo=0;opcombo < obj.length;opcombo++){ 
	          	if(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ 
	          		obj.selectedIndex=opcombo; 
	        	} 
	       	} 
	    } 
	   	event.returnValue = false; //invalida la acción de pulsado de tecla para evitar busqueda del primer caracter 
	}
	function borrar_bufferAR(){ 
    	cadena=""; 
    	puntero=0; 
	}


</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="historiaform" action="HistorialAsunto.jsp" method="post">
<input type="hidden" name="laSeleccion" value="">
<input type="hidden" name="usuarioSeleccionado" value="<%=strUsuarioSel%>">
<input type="hidden" name="areaSeleccionada" value="<%=strAreaSel%>">
<input type="hidden" name="Organigrama" value="<%=strOrganigrama%>">
<input type="hidden" name="mesSeleccionada" value="<%=strMes%>">
<br>
<DIV align="center">
<TABLE border="1">
	<TR>
		<TD align="center" width="228"><b>Historial</b></TD>
		
	</TR>
	<TR align="center">
		<TD align="center" width="228"><meve_combo:comboseleccion
			data="<%= ComboData.getUsuarioCombo() %>" size="1"
			name="usuarios" classHtml="blue200" selected=""
			textoNoSeleccion=" -- Seleccionar Usuario --" valorNoSeleccion="-1"
			script="onclick=''" />
		</TD>
	</TR>
	<TR align="center">
		<TD align="center" width="228"><meve_combo:comboseleccion
			data="<%= ActualizaUsuario.getAreas() %>" size="1" name="areas"
			classHtml="blue200" selected=""
			textoNoSeleccion=" -- Seleccionar Unidad Administrativa --" valorNoSeleccion="-1"
			script="onclick=''" />
		</TD>
	</TR>
	<TR align="center">
		<TD align="center" width="228"><meve_combo:comboseleccion
			data="<%= ActualizaUsuario.getMeses() %>" size="1" name="mes"
			classHtml="blue200" selected=""
			textoNoSeleccion=" -- Seleccionar Rango --" valorNoSeleccion="-1"
			script="onclick=''" />
		</TD>
	</TR>
	<TR align="center">
		<TD align="center" rowspan="2" Valign="bottom" width="229">
			<!-- <INPUT type="button" value="Organigrama" name="organigramaBtn" onclick="seleccion('organigrama')"> -->
			<INPUT type="button" value="Aplicar" name="aplicar" onclick="seleccion()">
		</TD>
	</TR>
</TABLE>
</DIV>
<br>

</FORM>
</BODY>
</HTML>
