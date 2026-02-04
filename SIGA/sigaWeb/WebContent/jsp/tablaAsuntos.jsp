<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="xg" tagdir="/WEB-INF/tags"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.util.Utilerias,com.meve.sigma.beans.*,com.meve.sigma.taglib.*"%>


<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<jsp:useBean id="tableManager" type="com.meve.util.ManejadorDeTablas"
	class="com.meve.util.ManejadorDeTablas" scope="session" />
</HEAD>
<BODY background="./Imagenes/fondo_claro.jpg">

<%
if (tableManager.getTotalRegistros() != 0) {
%>
<TABLE WIDTH="900" align="center">
	<TR>
		<td colspan="5"><font color="#004080" face="Arial"><strong>Asuntos
		de la Ventanilla</strong></font></td>
		<td><font color="#004080" face="Arial"><strong><%=tableManager.getTotalRegistros()%>
		Asuntos</strong></font></td>
	</TR>
	<TR BGCOLOR="00204F">
		<logic:iterate id="encabezado" type="com.meve.util.Encabezado"
			name="tableManager" property="encabezados" indexId="index">
			<TD align="center" width="${encabezado.width}%"><xg:sortedHeader
				key="${encabezado.titulo}" id="${index}" form="reporteForm"
				orden="<%=tableManager.getOrden(index.intValue())%>" /></TD>
		</logic:iterate>
	</TR>
</TABLE>
<DIV class=documentBody id=Body>

<TABLE width="900" align="center" border="0">
	<logic:iterate id="registro" name="tableManager"
		property="registrosPaginaActual"
		type="com.meve.sigma.asunto.AsuntoForm" indexId="contador">
		<tr>
			<td WIDTH='25%'>${registro.asuntoCorto}</td>
			<td WIDTH='20%'>${registro.folioRecepcion}</td>
			<td WIDTH='15%'>${registro.fechaRecepcion}</td>
			<td WIDTH='15%'>${registro.fechaDocto}</td>
			<td WIDTH='15%'>${registro.procedencia}</td>
			<td WIDTH='10%'>${registro.estatusNombre}</td>
		</tr>
	</logic:iterate>
	<tr>
		<td colspan="6">
		<TABLE align="center">
			<tr><%=tableManager.getPaginacionHTML("reporteForm")%></tr>
		</table>
		<td>
	</tr>
</TABLE>

<%
} else {
%>
<CENTER>
<table cellspacing="2" cellpadding="2">
	<tr>
		<TD align="center">
		<DIV align="center" class=documentBody id=Body>
		<p><FONT size="4" face="Verdana">***** No se han encontrado
		Documentos ***** </FONT>
		</DIV>
		</TD>
	</tr>
</table>
</CENTER>
<%
}
%>
</DIV>
</BODY>
</HTML>
