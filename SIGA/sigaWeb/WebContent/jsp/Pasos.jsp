<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<TITLE>Pasos</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*"%>
<%@ page import="com.meve.sigma.taglib.*"%>
<%@ page import="com.meve.sigma.beans.*"%>
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

%>
<% if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ %>
<jsp:forward page="../Error/ERUsuarioInvalido.jsp"></jsp:forward>
<% } %>
<%
	String strIdPaso 				= 	"";
	String strIdArea				=	"";
	String strDescripcion 			= 	"";
	String strIdTipoDocto 			= 	"";
	String strSecuencia 			= 	"";
	String strFechaActualizacion	=	"";
	String strFechaActualizacion2	=	"";
	String strUsrActualizo 			= 	"";
	String strUsrActualizo1 		= 	"";
	String strAccion 				= 	"";

	strUsrActualizo1	=	BUsuario.getIdUsuario();
	String strCreador	= 	ActualizaUsuario.NombreUsuario(strUsrActualizo1);
	String retURI = (request.getParameter("retURI")== null)?"PasosView.jsp":request.getParameter("retURI");
	
	String strAux = "0", strAux2 = "0";
	int valida = -2;
	boolean bInsertar		=	false;
	boolean bActualizar		=	false;

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaActualizacion			=	sdf.format(f);
	strFechaActualizacion2			=	strFechaActualizacion;
	
	strAccion 	= 	request.getParameter("accion");
	strIdArea	=	request.getParameter("id_area");
	strIdPaso	=	(request.getParameter("id_pas") != null)?request.getParameter("id_pas"):"";
	int a = 0;

	if(strIdPaso != null && strIdPaso.trim().length()>0)
	{
		String strDatosPasos[][] = ActualizaPaso.getPaso(strIdPaso);
		strIdTipoDocto	=	strDatosPasos[0][0];
		strSecuencia	=	strDatosPasos[0][1];
		strDescripcion	=	strDatosPasos[0][2];
		strIdArea		=	strDatosPasos[0][5];

		strCreador					=	ActualizaUsuario.NombreUsuario(strDatosPasos[0][6]);
		strFechaActualizacion2		=	strDatosPasos[0][7];

		strAux = strSecuencia;
		strAux2 = strIdTipoDocto;
	}

	if(strAccion!=null && strAccion.trim().length()>0)
	{
		if(strAccion.equals("guardar"))
		{
			strDescripcion	=	request.getParameter("pasoNombre");
			strIdTipoDocto	=	request.getParameter("pasoTipoDocto");
			strSecuencia	=	request.getParameter("pasoSecuencia");

			valida = ActualizaPaso.getPasoExiste(strSecuencia, strAux, strIdTipoDocto, strAux2);	

			if (valida == 2){
				bInsertar		=	ActualizaPaso.InsertarPaso(	strIdTipoDocto, strSecuencia, strDescripcion,
																strUsrActualizo1, strFechaActualizacion);
				boolean b = ActualizaBitacora.InsertarEventoAltaPaso(BUsuario.getIdUsuario(),strSecuencia,strIdTipoDocto);
			
				try{
					//response.sendRedirect("PasosView.jsp");
					response.sendRedirect(retURI);
				}catch(java.io.IOException io){
					//System.out.println("ERROR REDIRECCON="+io);
				}
			}
		}
		else if(strAccion != null && strAccion.equals("cambiar"))
		{
			strDescripcion	=	request.getParameter("pasoNombre");
			strIdTipoDocto	=	request.getParameter("pasoTipoDocto");
			strSecuencia	=	request.getParameter("pasoSecuencia");
			strAux			=	request.getParameter("aux");
			strAux2			=	request.getParameter("aux2");

			//valida = ActualizaPaso.getPasoExiste(strSecuencia, strAux, strIdTipoDocto, strAux2);	
			String datos[][] = ActualizaPaso.getPaso(strIdPaso);
			bInsertar = ActualizaPaso.ActualizarPaso(strIdPaso, strIdTipoDocto, strSecuencia,
														strDescripcion, strUsrActualizo1, strFechaActualizacion);
			boolean b = ActualizaBitacora.InsertarEventoCambioPaso(BUsuario.getIdUsuario(),strSecuencia,strIdTipoDocto,strIdPaso,datos);
			try{
				//response.sendRedirect("PasosView.jsp");
				response.sendRedirect(retURI);
			}catch(java.io.IOException io){
				//System.out.println("ERROR REDIRECCON="+io);
			}
		}
	}

	String sec = null;
	if(strIdArea != null && strIdArea.trim().length()>0)
	{
		String strSec[][] = ActualizaPaso.getSec(strIdArea);
		sec	=	strSec[0][0];

	}

%>
<% if(strIdPaso!=null && strIdPaso.length()!=0){ %>
<% if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ %>
<% }else{ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<% } %>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<STYLE type="text/css"></STYLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<SCRIPT language=JavaScript type=text/javascript>

	function guardar() { 
	
		doc = document.Pasos;
		//valida = 0;
		msg="";
		
//		else {
			mensaje = 'Algunos de los campos tienen caracteres invalidos (&, ", <, >, \', `, ´)\nPresione Aceptar para eliminarlos automaticamente\no Cancelar para regresar'
			if(detectaCE(doc.pasoNombre.value)){
				if (confirm(mensaje)){

					doc.pasoNombre.value	= quitaCE(doc.pasoNombre.value);
				
					if(document.Pasos.id_pas.value != "") 
						document.Pasos.accion.value="cambiar";
					else
						if(document.Pasos.id_pas.value == "")
							document.Pasos.accion.value="guardar";
//					document.Pasos.submit();
				}
				else 
					doc.accion.value="";
			}
			else{
				if(document.Pasos.id_pas.value != "") 
					document.Pasos.accion.value="cambiar";
				else
					if(document.Pasos.id_pas.value == "")
						document.Pasos.accion.value="guardar";
//				document.Pasos.submit();
			}
//		}		
		if (doc.pasoArea[doc.pasoArea.selectedIndex].value == -1) {
			valida =1;
			msg = msg + " Debe seleccionar una Unidad"+ "\n";
		}
		if (Trim(doc.pasoSecuencia.value) =="") {
			valida =1;
			msg = msg + " Debe capturar la secuencia del paso	"+ "\n";
		}

		var numsec = doc.pasoSecuencia.value;
		if (numsec == 0) {
			valida =1;
			msg = msg + " La secuencia debe ser mayor de 0	"+ "\n";
		}

		//if(sec == null || sec.equalsIgnoreCase("") )
		//	sec="0"; %>
		//var numsec2 = <%=sec%>;
		//if (numsec <= numsec2) {
		//	numsec2 = numsec2 + 1;
		//	valida =1;
		//	msg = msg + " Proxima secuencia: "  + numsec2 + "\n";
		//}

		if (doc.pasoTipoDocto[doc.pasoTipoDocto.selectedIndex].value == -1) {
			valida =1;
			msg = msg + " Debe seleccionar el Tipo de Documento	"+ "\n";
		}
		if (Trim(doc.pasoNombre.value) =="") {
			valida =1;
			msg = msg + " Debe capturar la Descripción del Paso	"+ "\n";
		}
		if (Trim(quitaPuntos(doc.pasoSecuencia.value)) =="" && doc.pasoSecuencia.value!="") {
			valida =1;
			msg = msg + " La Secuencia no es válida"+ "\n";
		}
		if (Trim(quitaPuntos(doc.pasoNombre.value)) =="" && doc.pasoNombre.value!="") {
			valida =1;
			msg = msg + " La Descripción no es válida"+ "\n";
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
			document.Pasos.submit();
		}
	}


	function area(){
		doc = document.Pasos;
		var a = doc.pasoArea.value;
		location.assign('Pasos.jsp?id_area='+a);
	}
	function paso(){
		doc = document.Pasos;
		var a = doc.pasoArea.value;
		var p = doc.pasoAreapasoArea.value;
		location.assign('Pasos.jsp?id_area='+a+ '&id_pas'+p);
	}
	function regresar(){
		location.assign('<%= retURI %>');
	}
	var digitos=10 //cantidad de digitos buscados 
	var puntero=0 
	var buffer=new Array(digitos) //declaración del array Buffer 
	var cadena="" 

	function buscar_opPAS(obj){
		var forma=document.Pasos;
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
				var a = forma.pasoArea.value;
				location.assign('Pasos.jsp?id_area='+a);
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
	function borrar_bufferPAS(){ 
    	cadena=""; 
    	puntero=0; 
	}

	function limpiarCampos(){
		document.Pasos.reset();
	}

</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="valida=0;timer_load();limpiarCampos();" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="Pasos.jsp" name="Pasos" method="post">
<INPUT type=hidden value="" name="accion">
<INPUT type=hidden value="<%=strIdPaso%>" name="id_pas">
<INPUT type=hidden value="<%=strIdArea%>" name="id_area">
<INPUT type=hidden value="<%=strAux%>" name="aux">
<INPUT type=hidden value="<%=strAux2%>" name="aux2">
<INPUT type=hidden value="<%=retURI%>" name="retURI">

<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>

		<TR valign="top">
			<TD colspan="2">
				<A onclick="regresar()"><IMG border="0" src="../Imagenes/NavLeft.gif" title="Regresar"></A>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 	
				<A onclick="guardar()">
				<img src="../Imagenes/Save.gif" title="Guardar">
			</A>
			</TD>
		</TR>

		<TR valign="top">
			<TD ><B><FONT face="Verdana" color="#00204f"
				size="2"><FONT size="+1" color="#004080">Pasos</FONT><FONT size="+1"></FONT></FONT></B></TD>
			<TD align="right" valign="middle">&nbsp;**Los datos marcados con negritas son obligatorios</TD>
		</TR>
		<TR valign="top">
			<td bgcolor="#004080" colspan="2"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</TR>

		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
			<TD align="right"><FONT face="Verdana" size="2"><I>
				<%=(strIdPaso!=null && !strIdPaso.equals(""))?"Última modificación por: ":"Creado por: "%><%= strCreador %> - <%= strFechaActualizacion2 %></I></FONT>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><BR>
			<BR>
			</TD>
			<TD width="528"></TD>
			<TD></TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Unidad
			Administrativa:</B></FONT></TD>
			<% if(BUsuario.getSupervisor()){ 
				if(strIdPaso.equals("")){
					strIdArea = BUsuario.getIdArea();
				} 
			%>
			<TD width="528"><FONT face="Verdana" size="2"><meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" name="pasoArea"
				classHtml="blue600a" selected="<%=strIdArea%>"
				textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
				valorNoSeleccion="-1" script="onchange='area()'"/></FONT></TD>
			<% }else{ %>
			<TD width="528"><FONT face="Verdana" size="2"><meve_combo:comboseleccion
				data="<%=ComboData.getAreasComboAll()%>" size="1" name="pasoArea"
				classHtml="blue600a" selected="<%=strIdArea%>"
				textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
				valorNoSeleccion="-1" script="onchange='area()' onKeypress='buscar_opPAS(this)' onblur='borrar_bufferPAS()' onclick='borrar_bufferPAS()'"/></FONT></TD>
			<% } %>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Tipo
			de Documento:</B></FONT></TD>
			<TD width="528">
				<FONT face="Verdana" size="2">
					<% if(strIdArea != null){ %>
					<meve_combo:comboseleccion
						data="<%= ComboData.getTipoDoctoCombo(strIdArea) %>" size="1" name="pasoTipoDocto"
						classHtml="blue600a" selected="<%=strIdTipoDocto%>"
						textoNoSeleccion=" ------------ Selecciona un Tipo de Documento ------------ "
						valorNoSeleccion="-1" />
					<% }else if(strIdPaso.length() != 0){ %>
					<meve_combo:comboseleccion
						data="<%= ComboData.getTipoDoctoCombo() %>" size="1" name="pasoTipoDocto"
						classHtml="blue600a" selected="<%=strIdTipoDocto%>"
						textoNoSeleccion=" ------------ Selecciona un Tipo de Documento ------------ "
						valorNoSeleccion="-1" />
					<% }else{ %>
					<SELECT class="blue100a" name="pasoTipoDocto">
						<OPTION value="-1">---</OPTION>
					</SELECT>
					<% } %>
				</FONT>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Secuencia:</B></FONT>
			<%if (valida == 1) {%><br>
			<FONT color="red"><B>*Esta Secuencia ya existe* </B></FONT><%} %>
			</TD>
			<TD width="528">
				<FONT face="Verdana" size="2">
					<INPUT class="blue100a" name="pasoSecuencia" value="<%=strSecuencia %>" onKeyPress='AceptaSoloTeclaNumericaYPunto();' maxlength="3">
				</FONT>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144">
				<B><FONT face="Verdana" size="2" color="#004080">Descripción:</FONT> </B></TD>
			<TD width="528">
				<FONT face="Verdana" size="2">
					<INPUT class="blue600a" name="pasoNombre" value="<%=strDescripcion%>" maxlength="199">
				</FONT>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>