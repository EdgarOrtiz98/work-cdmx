<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
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
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}
%>
<%
	String strIdAsunto = "";
	strIdAsunto = request.getParameter("id_asunto");
	String getDetalle[][] = null;
	if(strIdAsunto != null && strIdAsunto.length() > 0){
		getDetalle = ActualizaCiudadano.getDatosNot(strIdAsunto);
	}
	//boolean bCerrar = false;
	//bCerrar = ActualizaCiudadano.getCerrar();
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
<TITLE>Detalle de la Notificación</TITLE>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
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
			<TD width="125"><a href="AsuntoTurnado.jsp?id_asunto=<%=strIdAsunto%>"> <IMG
				border="0" src="../Imagenes/Regresar.gif" width="82" height="26"> </a>
			</TD>
			<TD width="125">
				&nbsp;
			</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="305"></TD>
		</TR>
		<TR valign="top">
			<TD></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336"><B><FONT face="Verdana" color="#004080" size="2">
			Detalle de la Notificación al Ciudadano</FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="451">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#00204f" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<BR>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<% for(int i=0;i<getDetalle.length;i++){ %>
	<TR VALIGN=top>
		<TD width="23"><IMG border="0" src="../Imagenes/expand.gif"
				width="16" height="16"></TD>
		<TD width="906">
			<font size="2" color="#004080" face="Arial">
			<%
				String strRespondio = "";
				if(getDetalle[i][4].equals("1")){
					strRespondio = "UCT";
				}else{
					strRespondio = "Ciudadano";
				}
			%>
			<%=getDetalle[i][1]%>(<%=strRespondio%>)
			
			</FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="23">&nbsp;</TD>
		<TD width="906">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="23"><b><font size="2" color="#004080" face="Arial"></FONT></b></TD>
		<TD width="906">
			<font size="2" color="#004080" face="Arial">
			<% if(getDetalle[i][2].length() > 0){ %>
			<%=ActualizaTipoRespuesta.getNombreTipoRespuesta(getDetalle[i][2])[0][0]%>
			<% } %>
			</FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="23">&nbsp;</TD>
		<TD width="906">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="23"><b><font size="2" color="#004080" face="Arial"></FONT></b></TD>
		<TD width="906">
			<font size="2" color="#004080" face="Arial">
			<%=getDetalle[i][0]%><br>
			-------------------------------------------------------------------------
			</FONT>
		</TD>
	</TR>
	<% } %>
</TBODY>
</table>
</DIV>
</BODY>
</HTML>
