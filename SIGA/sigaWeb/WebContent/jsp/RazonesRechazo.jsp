<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo" %>
<HTML>
<HEAD>
<TITLE>Razones de Rechazo</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*" %>
<%@ page import="com.meve.sigma.taglib.*,com.meve.sigma.beans.*" %>
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
		String recCreador[][] 	= null;
		String recRazon[][]		= null;
		String strIdRazon 		= "";
		String strDescripcion	= "";
		String strIdArea 		= "";
		String strCreador 			= "";
		String strCreador1 			= "";
		String strFechaCreacion 	= "";
		String strFechaCreacion2 	= "";
		String strAccion 			= "";
		String strEstatus 			= "1";

		String retURI = (request.getParameter("retURI")== null)?"RazonesRechazoView.jsp":request.getParameter("retURI");
		String strAux = "1a2b3c", strAux2 = "1a2b3c";
		int valida = -2;

		boolean bInsertar = false;
		boolean bActualizar = false;

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.util.Date f = new java.util.Date();
		strFechaCreacion = sdf.format(f);
		strFechaCreacion2 	=	strFechaCreacion;
		
		strCreador1	=	BUsuario.getIdUsuario();
		strCreador	=	ActualizaUsuario.NombreUsuario(strCreador1);
		strAccion 	= request.getParameter("accion");

		if (strAccion != null && strAccion.equals("consultar")) {
			strIdRazon = request.getParameter("Razon_IdRazon");
			
			if (strIdRazon != null) {
				recRazon 		= ActualizaRazonRechazo.getRazonRechazo(strIdRazon);
				strIdArea 		= recRazon[0][0];
				strDescripcion	= recRazon[0][1];
				strCreador		=	ActualizaUsuario.NombreUsuario(recRazon[0][2]);
				strFechaCreacion2 = recRazon[0][3];

				strAux = strDescripcion;
				strAux2 = strIdArea;
			}
		}
		if (strAccion != null && strAccion.equals("cambiar")) {
			strIdRazon = request.getParameter("Razon_IdRazon");
			
			if (strIdRazon != null) {
				strDescripcion	= request.getParameter("Razon_Descripcion");
				strIdArea 		= request.getParameter("Razon_Area");

				strAux 		= request.getParameter("aux");
				strAux2 	= request.getParameter("aux2");

				valida = ActualizaRazonRechazo.getRazonExiste(strDescripcion, strAux, strIdArea, strAux2);	

				if (valida == 2){
					String datos[][] = ActualizaRazonRechazo.getRazonRechazo(strIdRazon);
					bInsertar 				= ActualizaRazonRechazo.ActualizarRazonRechazo(strIdRazon,
							strIdArea, strDescripcion, strCreador1, strFechaCreacion);
					boolean c = ActualizaBitacora.InsertarEventoCambioRazon(BUsuario.getIdUsuario(),strDescripcion,strIdArea,strIdRazon,datos);
				}
			}
		}

		if (strAccion != null && strAccion.equals("guardar")) {
			strDescripcion	= request.getParameter("Razon_Descripcion");
			strIdArea 		= request.getParameter("Razon_Area");

			valida = ActualizaRazonRechazo.getRazonExiste(strDescripcion, strAux, strIdArea, strAux2);	

			if (valida == 2){
				bInsertar 			= ActualizaRazonRechazo.InsertarRazonRechazo(strIdArea, strDescripcion,
										strCreador1, strFechaCreacion, strEstatus);
				boolean c = ActualizaBitacora.InsertarEventoAltaRazon(BUsuario.getIdUsuario(),strDescripcion,strIdArea);
				strIdArea		= ""; 
				strDescripcion 	= "";
			}
		}
		//recCreador  = ActualizaUsuario.getUsuario(strCreador1);
		//strCreador	= recCreador[0][0];
		if(strAccion!=null && (strAccion.equals("cambiar") || strAccion.equals("guardar")) && bInsertar)
		{
			strAccion 			= "";
%>
<SCRIPT language=JavaScript type=text/javascript>
	location.assign("<%= retURI %>");
</SCRIPT>
<%
		}
%>
<% if(strIdRazon!=null && strIdRazon.length()!=0){ %>
<% if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ %>
<% }else{ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<% } %>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<STYLE type="text/css">
</STYLE>
<SCRIPT language=JavaScript type=text/javascript>
	
	function limpiarCampos(){
		document.RazonesRechazo.reset();
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
<FORM action="RazonesRechazo.jsp" name="RazonesRechazo" method="post">
<INPUT type=hidden value="guardar" name="accion">
<INPUT type=hidden value="<%=strIdRazon%>" name="Razon_IdRazon">
<INPUT type=hidden value="<%=strAux%>" name="aux">
<INPUT type=hidden value="<%=strAux2%>" name="aux2">
<INPUT type=hidden value="<%=retURI%>" name="retURI">
<DIV align="center">
<BR>
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>

		<TR valign="top">
			<TD colspan="2"><A href="<%= retURI %>"> <IMG
				border="0" src="../Imagenes/NavLeft.gif" title="Regresar"
				title="Regresar"> </A>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a onclick="guardar()">
				<img src="../Imagenes/Save.gif" title="Guardar">
				</a>
			</TD>
		</TR>

		<TR valign="top">
			<TD width="25%"><B><FONT face="Verdana" color="#00204f"
				size="2"><FONT size="+1" color="#004080">Razones de Rechazo</FONT></FONT></B></TD>
			<TD width="75%" align="right">&nbsp;**Los datos marcados con negritas son obligatorios</TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD colspan="2" ></TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD colspan="2" ></TD>
		</TR>

		<TR valign="top">
			<TD ><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
			<TD align="right"><FONT face="Verdana" size="2"><I>
				<%=(strIdRazon!=null && !strIdRazon.equals(""))?"Última modificación por: ":"Creado por: "%><%= strCreador%> - <%= strFechaCreacion2%></I></FONT>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><BR>
			<BR>
			</TD>
			<TD width="528" align="right">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Unidad
			Administrativa:</B></FONT></TD>
			<% if(BUsuario.getSupervisor()){
				if(strIdRazon.equals("")){
					strIdArea = BUsuario.getIdArea();
				}  %>
			<TD width="528"><FONT face="Verdana" size="2"><meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" name="Razon_Area"
				classHtml="blue600a" selected="<%= strIdArea %>"
				textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
				valorNoSeleccion="-1" 
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/></FONT></TD>
			<% }else{ %>
			<TD width="528"><FONT face="Verdana" size="2"><meve_combo:comboseleccion
				data="<%= ComboData.getAreasComboAll()%>" size="1" name="Razon_Area"
				classHtml="blue600a" selected="<%= strIdArea %>"
				textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
				valorNoSeleccion="-1" 
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/></FONT></TD>
			<% } %>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528" align="right">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Descripción:</B></FONT>
			<%if (valida == 1) {%><br>
			<FONT color="red"><B>*Esta Descripción ya existe* </B></FONT><%} %>
			</TD>
			<TD width="528"><FONT face="Verdana" size="2">
			<INPUT class="blue600a" name="Razon_Descripcion"  value="<%=strDescripcion%>" maxlength="200">
			</FONT>	
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"></TD>
			<TD width="528"></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<BR>
</FORM>
<SCRIPT language="JavaScript" type="text/javascript"><!-- 
function guardar() { 
	var doc = document.RazonesRechazo
	//var valida = 0;
	var msg="";

//	if (valida != 1)	{
		mensaje = 'Algunos de los campos tienen caracteres invalidos (&, <, >, \', ", `, ´)\nPresione Aceptar para eliminarlos automaticamente\no Cancelar para regresar'
		if(detectaCE(doc.Razon_Descripcion.value)){
			if (confirm(mensaje)){

				doc.Razon_Descripcion.value	= quitaCE(doc.Razon_Descripcion.value);
	
				doc.aux.value	= quitaCE(doc.aux.value);
				
				if(doc.Razon_IdRazon.value != "")
					doc.accion.value="cambiar";
				if(doc.Razon_IdRazon.value == "")
					doc.accion.value="guardar";
//				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			if(doc.Razon_IdRazon.value != "")
				doc.accion.value="cambiar";
			if(doc.Razon_IdRazon.value == "")
				doc.accion.value="guardar";
//			doc.submit();
		}
//	}
	if (doc.Razon_Area[doc.Razon_Area.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar una Unidad	"+ "\n";
	}
	if (Trim(doc.Razon_Descripcion.value) =="") {
		valida =1;
		msg = msg + " Debe capturar la Descripción de la Razon de Rechazo"+ "\n";
	}
	if (Trim(quitaPuntos(doc.Razon_Descripcion.value)) =="" && doc.Razon_Descripcion.value!="") {
		valida =1;
		msg = msg + " La Descripción de la Razon de Rechazo no es válida"+ "\n";
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
</SCRIPT>
</BODY>
</HTML>