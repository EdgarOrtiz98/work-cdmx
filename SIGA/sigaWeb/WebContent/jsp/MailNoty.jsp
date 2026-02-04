<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="meve_front" prefix="meve_front"%>
<HTML>
<HEAD>
<%@ page import="com.meve.sigma.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.reportes.*"
%>
<%
	String strIdAsunto	=	"";
	String strIdAsunto2	=	"";
	String strAsunto	=	"";
	String strfoliom = 		"";
	String strenviar = 		"";
	String mailsend = "";

	strIdAsunto2			=	"72";//request.getParameter("id_asunto");
	strIdAsunto	=	request.getParameter("id_asunto");
	strAsunto	=	request.getParameter("asunto");
	strfoliom	=	request.getParameter("foliom");
	strenviar	=	request.getParameter("enviar");
	mailsend	=	request.getParameter("mailsend");
	String serverName = application.getInitParameter("servername");
	SenderMail mail = new SenderMail();

	if(strenviar!= null && !strenviar.equalsIgnoreCase("")){
	  	mail.sendConfirmacionTerminado(strIdAsunto,strAsunto,strfoliom,mailsend, session.getServletContext());
		boolean bActualiza = ActualizaAsunto.getUpdateMail(strIdAsunto);
	}

%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/link.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>Notificar Correo Electrónico</TITLE>
<SCRIPT language=JavaScript type=text/javascript>
	function enviar(){
	location.assign('MailNoty.jsp?id_asunto=<%=strIdAsunto%>&enviar=yes&asunto=<%=strAsunto%>&foliom=<%=strfoliom%>&mailsend=<%=mailsend%>');
	
	}
	function sierra()
	{
	<%if(strenviar != null && !strenviar.equalsIgnoreCase("")){
	%>
		alert("Confirmación Enviada");
		window.close();
	<%}%>
	}

</SCRIPT>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" 
	onblur=(window.focus()) 
	onload="sierra();">
<TABLE cellspacing="0" cellpadding="0" width="99%" border="0">
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
			<TD width="183"><FONT face="Arial" color="#004080" size="2">Presente</FONT></TD>
			<TD colspan="3" width="660">
				<FONT face="Arial" size="2">
				</FONT>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="183" colspan="4">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="183" colspan="4" align="justify">Por&nbsp;medio de la presente manifiesto que el asunto
			<b><%=strAsunto%></b><BR>con el número de folio <b><%=strfoliom%> </b>ya ha sido terminado.<BR>
			<BR>A continuación se detalla el historial de las respuestas hacia la solicitud:<BR>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="183" colspan="4">&nbsp;</TD>
		</TR>
		<meve_front:ListaDatos
			datos="<%= ActualizaInstrucciones.InstruccionPorIdAsunto(strIdAsunto) %>"
			campo="campo">
		<tr>
		<TD>
			<DIV align="left">
			<FONT face="Verdana" color="#000000" size="1">
			<% if(campo3.length() == 0){ %>
			<%= campo8 %>
			<% }else{ %>
			<%= ActualizaInst.getNombreInstruccion1(campo3) %>
			<% } %>
			</FONT>
			</DIV>
		</TD>
		</tr>
		<tr>
			<TD>
				<TABLE>
				<TBODY>
					<meve_front:ListaDatos
						datos="<%= ActualizaHistorial.getHistorialRespuestasPorInstruccion(campo12) %>"
						campo="lista">
					<TR>
						<TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TD>
						<TD><%=lista2%></TD>
					</TR>
					</meve_front:ListaDatos>
				</TBODY>
			</TABLE>
			</TD>
		</tr>
		</meve_front:ListaDatos>
	</TBODY>
</TABLE>
</DIV>
<TABLE align="center">
		<tr align="center">
			<TD align="center">
				<INPUT type="button" value="Enviar" name="Enviar" onclick="enviar()">
				<INPUT type="button" value="Cancelar" name="Cancelar" onClick="javascript:window.close();">
			</TD>
		</tr>
</TABLE>
</BODY>
</HTML>
