<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*, com.meve.sigma.taglib.*,com.meve.sigma.beans.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){;}
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
	String strIdUbicacion	=	"";
	String strUbicacion		=	"";
	String strIdArea		=	"";
	String strCreador		=	"";
	String strCreador1		=	"";		
	String strFechaCreacion	=	"";
	String strAccion		=	"";
	String strEstatus		=	"1";

	String strAux = "1a2b3c", strAux2 = "1a2b3c";
	int valida = -2;

	boolean bInsertar		=	false;
	boolean bActualizar		=	false;

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaCreacion 				=	sdf.format(f);

	String retURI = (request.getParameter("retURI")==null)?"UsuariosView.jsp":request.getParameter("retURI");
	strCreador1		=	BUsuario.getIdUsuario();
	strCreador		=	BUsuario.getNombre();
	strAccion		=	request.getParameter("accion");
	strIdUbicacion	=	(request.getParameter("id_ubi") != null)?request.getParameter("id_ubi"):"";
	
	if(strIdUbicacion != null && strIdUbicacion.trim().length()>0)
	{
		String strDatosUbicacion[][] = ActualizaUbicacion.getDatosUbicacion(strIdUbicacion);
		strIdArea		=	strDatosUbicacion[0][0];
		strUbicacion	=	strDatosUbicacion[0][1];

		strAux = strUbicacion;
		strAux2 = strIdArea;
	}
	
	if(strAccion!=null && strAccion.trim().length()>0)
	{
		if(strAccion.equals("guardar"))
		{
			strUbicacion	=	request.getParameter("ubicacion");
			strIdArea		=	request.getParameter("ubicArea");

			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Ubicacion
			strUbicacion	=	(strUbicacion.length()<= 200) ? strUbicacion : strUbicacion.substring(0,200);

			valida = ActualizaUbicacion.getUbicacionExiste(strUbicacion, strAux, strIdArea, strAux2);	

			if (valida == 2){
				bInsertar		=	ActualizaUbicacion.InsertarUbicacion(	strIdArea, strUbicacion,
																		strCreador1, strFechaCreacion);
				boolean b = ActualizaBitacora.InsertarEventoAltaUbicacion(BUsuario.getIdUsuario(),strUbicacion,strIdArea);
			}
		}
		
		else if(strAccion != null && strAccion.equals("cambiar"))
		{
			strUbicacion	=	request.getParameter("ubicacion");
			strIdArea		=	request.getParameter("ubicArea");

			strAux		=	request.getParameter("aux");
			strAux2		=	request.getParameter("aux2");


			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Ubicacion
			strUbicacion	=	(strUbicacion.length()<= 200) ? strUbicacion : strUbicacion.substring(0,200);

			valida = ActualizaUbicacion.getUbicacionExiste(strUbicacion, strAux, strIdArea, strAux2);	

			if (valida == 2){
				bInsertar = ActualizaUbicacion.ActualizarUbicacion(	strIdArea, strUbicacion,
																	strCreador1, strFechaCreacion,
																	strIdUbicacion);
				boolean b = ActualizaBitacora.InsertarEventoCambioUbicacion(BUsuario.getIdUsuario(),strUbicacion,strIdArea,strIdUbicacion);
			}
		}
	}
	
	
%>
<%
	if(strAccion!=null && (strAccion.equals("cambiar") || strAccion.equals("guardar")) && bInsertar)
	{
%>
<SCRIPT language=JavaScript type=text/javascript>
	location.assign('<%= retURI %>');
</SCRIPT>
<%
	}
%>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<SCRIPT language=JavaScript type=text/javascript>
<!-- 

function guardar() { 
	doc = document.Ubicacion;
	msg="";
	
		mensaje = 'Algunos de los campos tienen caracteres invalidos (&, ", <, >, \' )\nPresione Aceptar para eliminarlos automaticamente\no Cancelar para regresar'
		if(detectaCE(doc.ubicacion.value)){
			if (confirm(mensaje)){

				doc.ubicacion.value		= quitaCE(doc.ubicacion.value);
	
				doc.aux.value	= quitaCE(doc.aux.value);
				
				if(document.Ubicacion.id_ubi.value != "") 
					document.Ubicacion.accion.value="cambiar";
				if(document.Ubicacion.id_ubi.value == "")
						document.Ubicacion.accion.value="guardar";
			}
			else 
				doc.accion.value="";
		}
		else{
			if(document.Ubicacion.id_ubi.value != "") 
				document.Ubicacion.accion.value="cambiar";
			if(document.Ubicacion.id_ubi.value == "")
				document.Ubicacion.accion.value="guardar";
		}
		if (doc.ubicArea[doc.ubicArea.selectedIndex].value == -1) {
			valida =1;
			msg = msg + " Debes seleccionar una Unidad	"+ "\n";
		}
		if (Trim(doc.ubicacion.value) =="") {
			valida =1;
			msg = msg + " Debes capturar el nombre de la Ubicacion	"+ "\n";
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
			document.Ubicacion.submit();	
		}
}

function limpiarUBI(){
	document.Ubicacion.reset();
}
</SCRIPT>

<TITLE>Ubicación</TITLE>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load();limpiarUBI();" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="Ubicacion.jsp" name="Ubicacion" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%= strIdUbicacion %>" name="id_ubi">
<INPUT type="hidden" value="<%= strAux %>" name="aux">
<INPUT type="hidden" value="<%= strAux2 %>" name="aux2">
<INPUT type="hidden" value="<%=retURI%>" name="retURI">
<DIV align="center">
<BR>
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<TD width="125">
			<a href="<%= retURI %>">
			<IMG border="0" src="../Imagenes/NavLeft.gif" title="Regresar">
			</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a onclick="guardar()">
			<img src="../Imagenes/Save.gif" title="Guardar">
			</a>
		</TD>
		<TD width="125">

		</TD>
		<TD width="125">&nbsp;</TD>
		<TD width="125">&nbsp;</TD>
		<TD width="125">&nbsp;</TD>
		<TD width="48"></TD>
    </TR>
    </TBODY>
</TABLE>
</DIV>


<DIV class="documentBody" id="Body" style="HEIGHT: 441px">
<DIV align="center">
<DIV align="center">
<BR>
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
        <TR valign="top">
            <TD colspan="2" width="254"><B><FONT face="Verdana" color="#00204f" size="2"><FONT
				size="+1" color="#004080">Ubicación</FONT></FONT></B></TD>
            <TD width="111">&nbsp;</TD>
            <TD width="307" align="right">&nbsp;**Los datos marcados con negritas son obligatorios</TD>
        </TR>
		<TR valign="top" bgcolor="#004080">
			<TD colspan="2" width="254"></TD>
			<TD width="111"></TD>
			<TD width="307"></TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD colspan="2" width="254" height="0"></TD>
			<TD width="111" height="0"></TD>
			<TD width="307" height="0"></TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<TD width="144">
			<FONT face="Verdana" size="2">&nbsp;</FONT>
		</TD>
		<TD width="528" align="right">
			<FONT face="Verdana" size="2">Creado por: <I><%= strCreador %> - <%= strFechaCreacion %></I></FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="144"><BR>
			<BR>
			&nbsp;</TD>
		<TD width="528">&nbsp;</TD>
    </TR>
<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Unidad
			Administrativa:</B></FONT></TD>
		<TD width="528">
			<FONT face="Verdana" size="2">
				<% if(BUsuario.getSupervisor()){ %>
				<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" 
						size="1" name="ubicArea" 
						classHtml="blue500" selected="<%= strIdArea %>" 
						textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
						valorNoSeleccion="-1" 
						script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
				<% }else{ %>
				<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo() %>" 
						size="1" name="ubicArea" 
						classHtml="blue500" selected="<%= strIdArea %>" 
						textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
						valorNoSeleccion="-1" 
						script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
				<% } %>
			</FONT>
		</TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="528">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Ubicación:</B></FONT>
		<%if (valida == 1) {%><br>
		<FONT color="red"><B>*Esta Ubicación ya existe* </B></FONT><%} %>
		</TD>
		<TD width="528">
			<FONT face="Verdana" size="2">
			<INPUT class="blue500" size="80" name="ubicacion"  value="<%= strUbicacion %>" maxlength="199">
			</FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="528">&nbsp;</TD>
    </TR>
</TBODY>
</TABLE>
<BR>
<BR>
</DIV>
</DIV>
</DIV>
</FORM>

</BODY>
</HTML>
