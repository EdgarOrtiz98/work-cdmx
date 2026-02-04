<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<%@ page import="com.meve.sigma.actualiza.*,com.meve.sigma.taglib.*,com.meve.sigma.beans.*" %>
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
	String strIdExpediente	=	"";
	String strExpediente	=	"";
	String strIdArea		=	"";
	String strCreador		=	"";
	String strCreador1		=	"";		
	String strFechaCreacion	=	"";
	String strAccion		=	"";
	String strEstatus		=	"1";

	boolean bInsertar		=	false;

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaCreacion 				=	sdf.format(f);
	
	strCreador1		=	BUsuario.getIdUsuario();
	strCreador		=	BUsuario.getNombre();
	strAccion		=	request.getParameter("accion");
	strIdExpediente	=	(request.getParameter("id_exp") != null)?request.getParameter("id_exp"):"";
	
	if(strAccion!=null && strAccion.trim().length()>0)
	{
		if(strAccion != null && strAccion.equals("guardar"))
		{
			strExpediente	=	request.getParameter("expediente");
			strIdArea		=	request.getParameter("expArea");

			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Entidad
			strExpediente	=	(strExpediente.length()<= 200) ? strExpediente : strExpediente.substring(0,200);
			
			bInsertar		=	ActualizaExpediente.InsertarExpediente(	strIdArea, strExpediente,
																		strCreador1, strFechaCreacion);
		}
		else if(strAccion != null && strAccion.equals("cambiar"))
		{
			strExpediente	=	request.getParameter("expediente");
			strIdArea		=	request.getParameter("expArea");
			
			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Expedientes
			strExpediente	=	(strExpediente.length()<= 200) ? strExpediente : strExpediente.substring(0,200);
			
			bInsertar = ActualizaExpediente.ActualizarExpediente(	strIdArea, strExpediente,
																	strCreador1, strFechaCreacion,
																	strIdExpediente);
		}
	}

	if(strIdExpediente != null && strIdExpediente.trim().length()>0)
	{
		String strDatosExpediente[][] = ActualizaExpediente.getDatosExpediente(strIdExpediente);
		strIdArea		=	strDatosExpediente[0][0];
		strExpediente	=	strDatosExpediente[0][1];
	//	//System.out.println("IdUbicaciones="+strIdExpediente);
//		//System.out.println("strIdArea="+strIdArea);
//		//System.out.println("strUbicacion="+strExpediente);
	}
%>
<%
	if(strAccion!=null && (strAccion.equals("cambiar") || strAccion.equals("guardar")))
	{
%>
<SCRIPT language=JavaScript type=text/javascript>
	location.assign('ExpedienteView.jsp');
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
<TITLE>Expedientes</TITLE>
<SCRIPT language=JavaScript type=text/javascript>
<!-- 

function guardar() { 

	doc = document.Expedientes;
	
	valida = 0;
	msg="";

	if (doc.expArea[doc.expArea.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar una Unidad	"+ "\n";
	}
	if (doc.expediente.value =="") {
		valida =1;
		msg = msg + " Debes capturar el nombre del Expediente	"+ "\n";
	}
	if (valida == 1) 
	{
		alert(msg);
		return false;
	} 
	else if(document.Expedientes.id_exp.value != "") 
		document.Expedientes.accion.value="cambiar";
	else
	if(document.Expedientes.id_exp.value == "")
		document.Expedientes.accion.value="guardar";
	document.Expedientes.submit();
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
<FORM action="Expediente.jsp" name="Expedientes" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%= strIdExpediente %>" name="id_exp">
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<TD width="125">
			<a onclick="history.go(-1);return false;">
			<IMG border="0" src="../Imagenes/Regresar.gif" width="82" height="26">
			</a>
		</TD>
		<TD width="125">
			<a onclick="guardar()">
			<img src="../Imagenes/Guardar.gif" width="81" border="0">
			</a>
		</TD>
		<TD width="125">&nbsp;</TD>
		<TD width="125">&nbsp;</TD>
		<TD width="125">&nbsp;</TD>
		<TD width="48"></TD>
    </TR>
<TR valign="top">
<TD></TD>
<TD width="125">&nbsp;</TD>
<TD width="125">&nbsp;</TD>
        </TR>
    </TBODY>
</TABLE>
</DIV>


<DIV class="documentBody" id="Body" style="HEIGHT: 441px">
<DIV align="center">
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
        <TR valign="top">
            <TD width="336" colspan="2"><B><FONT face="Verdana" color="#00204f" size="2">Expedientes</FONT></B></TD>
            <TD width="144">&nbsp;</TD>
            <TD width="192">&nbsp;</TD>
        </TR>
        <TR valign="top">
			<td width="672" bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
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
		<TD width="144">&nbsp;</TD>
		<TD width="528">&nbsp;</TD>
    </TR>
<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2">Unidad Administrativa:</FONT></TD>
		<TD width="528">
			<FONT face="Verdana" size="2">
				<% if(BUsuario.getSupervisor()){ %>
				<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" 
					name="expArea" classHtml="blue500" 
					selected="<%= strIdArea %>" 
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
				<% }else{ %>
				<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo() %>" size="1" 
					name="expArea" classHtml="blue500" 
					selected="<%= strIdArea %>" 
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
		<TD width="144"><FONT face="Verdana" size="2">Expedientes:</FONT></TD>
		<TD width="528">
			<FONT face="Verdana" size="2">
			<INPUT class="blue500" size="80" name="expediente" value="<%= strExpediente %>">
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
