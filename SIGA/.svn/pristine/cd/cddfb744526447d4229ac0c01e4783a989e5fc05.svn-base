<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>

<%@taglib uri="meve_front" prefix="meve_front"%>

<html>
<head>
<TITLE>Asuntos por Turnar</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,com.meve.sigma.reportes.*,com.meve.sigma.util.*"%>
<%
			UsuarioBean BUsuario = (UsuarioBean) session
			.getAttribute("UsuarioBean");

	String strTmp = request.getRequestURI();
	strTmp = strTmp.substring(strTmp.indexOf('/', 2) + 5, strTmp
			.length());

	if (BUsuario == null) {
		response.sendRedirect("index.jsp?pagina=" + strTmp);
	} else if ((BUsuario.getAtencion() || BUsuario.getAsistente())
			&& !(BUsuario.getTurnado() || BUsuario.getSupervisor() || BUsuario
			.getRecepcion())) {
		response.sendRedirect("PortalAtender.jsp");
	} else if (BUsuario.getAdmon()) {
		response.sendRedirect("UsuariosView.jsp");
	}
%>
<link rel="stylesheet" href="../css/menu.css" type="text/css">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</head>
<body background="../Imagenes/fondo_claro.jpg" onLoad="timer_load()"
	onKeyPress="timer_reload()" onClick="timer_reload()" margin="0px">

<table cellspacing="0" cellpadding="0">
	<TR>
		<TD class="etiquetas">
		</TD>
	</TR>
</table>

<table cellspacing="2" cellpadding="2">
	<tr>
		<%
					if (BUsuario.getTurnado() || BUsuario.getRecepcion()
					|| BUsuario.getSupervisor()) {
		%>
		<td class="dominoTopTab"><a onclick="goAtencion()";>Asuntos
		en Recepción</a></td>
		<td class="dominoSelTopTab" bgcolor="#004080"><a
			onclick="goAsuntos()";>Asuntos por turnar</a></td>
		<td class="dominoTopTab"><a onclick="goAsuntosTr()";>Asuntos
		en trámite</a></td>
		<td class="dominoTopTab"><a onclick="goAsuntosTer()";>Asuntos
		terminados</a></td>
		<%
		if (BUsuario.getAtencion()) {
		%>
		<td class="dominoTopTab"><a onclick="goAtender()";>Instrucciones
		por atender</a></td>
		<td class="dominoTopTab"><a onclick="goTramite()";>Instrucciones
		en trámite</a></td>
		<td class="dominoTopTab"><a onclick="goTerminadas()";>Instrucciones
		terminadas</a></td>
		<td class="dominoTopTab"><a onclick="goRechazadas()";>Instrucciones
		rechazadas</a></td>
		<%
		} else {
		%>
		<td class="dominoTopTab"><a onclick="goRechazadas()";>Instrucciones
		rechazadas</a></td>
		<%
		}
		%>
		<%
		} else if (BUsuario.getAtencion()) {
		%>
		<td class="dominoSelTopTab" bgcolor="#004080"><a
			onclick="goAtender()";>Instrucciones por atender</a></td>
		<td class="dominoTopTab"><a onclick="goTramite()";>Instrucciones
		en trámite</a></td>
		<td class="dominoTopTab"><a onclick="goTerminadas()";>Instrucciones
		terminadas</a></td>
		<td class="dominoTopTab"><a onclick="goRechazadas()";>Instrucciones
		rechazadas</a></td>
		<%
		} else if (BUsuario.getAsistente()) {
		%>
		<td class="dominoSelTopTab" bgcolor="#004080"><a
			onclick="goAtender()";>Instrucciones por atender</a></td>
		<td class="dominoTopTab"><a onclick="goTramite()";>Instrucciones
		en trámite</a></td>
		<td class="dominoTopTab"><a onclick="goTerminadas()";>Instrucciones
		terminadas</a></td>
		<td class="dominoTopTab"><a onclick="goRechazadas()";>Instrucciones
		rechazadas</a></td>
		<%
		}
		%>
		<td class="dominoTopTab"><a onclick="goSolicitada()";>Asuntos
		Solicitados</a></td>
	</tr>
</table>
</body>
</html>
