<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*"
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
	String strIdTipoRespuesta 	=	"";
	String strNombreTipo		=	"";
	String strFecha				=	"";
	String strUsuario			=	"";
	String strAccion			=	"";
	
	strAccion			=	request.getParameter("accion");
	strIdTipoRespuesta	=	(request.getParameter("id_res") != null)?request.getParameter("id_res"):"";
	
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f = new java.util.Date();
	strFecha = sdf.format(f);

	if(strAccion!=null && strAccion.trim().length()>0)
	{
		if(strAccion != null && strAccion.equals("guardar"))
		{
			strNombreTipo = request.getParameter("tipo_respuesta");  
			boolean b = ActualizaTipoRespuesta.getInsertaTipoRespuesta(strNombreTipo, 
														BUsuario.getIdUsuario(), strFecha);
			try{
				response.sendRedirect("TipoRespuestaView.jsp");
			}catch(java.io.IOException io){;}
		}
		else if(strAccion != null && strAccion.equals("cambiar"))
		{
			strIdTipoRespuesta = request.getParameter("id_res"); 
			strNombreTipo = request.getParameter("tipo_respuesta"); 
			boolean c = ActualizaTipoRespuesta.getActualizarTipoRespuesta(strIdTipoRespuesta, strNombreTipo, 
																		BUsuario.getIdUsuario(), strFecha);

			try{
				response.sendRedirect("TipoRespuestaView.jsp");
			}catch(java.io.IOException io){;}
		}
		
	}
	if(strIdTipoRespuesta != null && strIdTipoRespuesta.trim().length()>0)
	{
		String strTip[][] = ActualizaTipoRespuesta.getTipoInstrucciones(strIdTipoRespuesta);
		strNombreTipo 	=	strTip[0][0];
		strFecha		=	strTip[0][1];
		strUsuario		=	strTip[0][3];
	}
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<SCRIPT language="JavaScript" type="text/javascript">
<!-- 
function guardarTipoRespuesta() { 
	var doc = document.tiporespuesta
	var valida = 0;
	var msg="";

	if (doc.tipo_respuesta.value =="") {
		valida =1;
		msg = msg + " Debe capturar un Tipo de Respuesta"+ "\n";
	}
	if (valida == 1){
		alert(msg);
	} 
	if (valida != 1)
	{
	if(doc.id_res.value != "")
		doc.accion.value="cambiar";
	if(doc.id_res.value == "")
		doc.accion.value="guardar";
	doc.submit();
	}
}
</SCRIPT>
<TITLE>Tipo de Respuesta</TITLE>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="TipoRespuesta.jsp" name="tiporespuesta" method="post">
<INPUT type=hidden value="" name="accion">
<INPUT type=hidden value="<%=strIdTipoRespuesta%>" name="id_res">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%" colspan="2">
			<DIV align="right"></DIV>
			</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="125"><A href="TipoRespuestaView.jsp"> <IMG
				border="0" src="../Imagenes/Regresar.gif" width="82" height="26"></A></TD>
			<TD width="553">
				<a onclick="guardarTipoRespuesta()">
				<img src="../Imagenes/Guardar.gif" width="81" border="0">
				</a>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>

	</TBODY>
</TABLE>
<BR>

<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD colspan="2" width="574"><B><FONT face="Verdana" color="#00204f"
				size="2">Tipo de Respuestas</FONT></B></TD>
			<TD width="98">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#00204f" colspan="3"><FONT size="1">&nbsp;</FONT></TD>
		</TR>
	</TBODY>
</TABLE>

<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
			<TD width="528" align="right"><FONT face="Verdana" size="2"><I>
			<% if(strIdTipoRespuesta != null && strIdTipoRespuesta.trim().length()>0){ %>
			Creado por: <%= ActualizaUsuario.NombreUsuario(strUsuario) %> - <%= strFecha%>
			<% }else{ %>
			Creado por: <%= BUsuario.getNombre() %> - <%= strFecha%>
			<% } %>
			</I></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528" align="right">&nbsp;</TD>
		</TR>
			
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">Tipo de Respuesta:</FONT></TD>
			<TD width="528"><FONT face="Verdana" size="2"><INPUT class="blue500"
				name="tipo_respuesta" value="<%=strNombreTipo%>"></FONT></TD>
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
</BODY>
</HTML>
