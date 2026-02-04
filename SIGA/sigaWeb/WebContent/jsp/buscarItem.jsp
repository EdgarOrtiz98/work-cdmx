<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String strIdAsunto = request.getParameter("IdAsunto");
	String strSeguridad= request.getParameter("bo");
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
<TITLE>Buscar Elemento</TITLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="archivoForm" action="buscarItem.jsp" method="post">
<INPUT type="hidden" name="accion" value="borrar">
<table>

<tr>
	<TD>
		<INPUT type="button" class="blue100" value="Eliminar" onclick="Eliminar()">
	</TD>
</tr>
<tr>

<TD align="center">
	<FONT face="Arial" size="5"><b>No se encontraron archivos que mostrar...</b></FONT>
</TD>
</tr>
</table>

</FORM>
</BODY>
</HTML>
