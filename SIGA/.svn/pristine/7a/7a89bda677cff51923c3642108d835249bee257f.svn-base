<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="xg" tagdir="/WEB-INF/tags"%>
<%@page import="com.meve.sigma.graficas.Graficas"%>
<%@page import="java.util.Date"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.util.Utilerias,com.meve.sigma.beans.*,com.meve.sigma.taglib.*"%>
	<jsp:useBean id="tableManager" type="com.meve.util.ManejadorDeTablas"
	class="com.meve.util.ManejadorDeTablas" scope="session" />
</HEAD>

<%if (tableManager.getTotalRegistros() != 0) {%>
<TABLE WIDTH="800" align="center">
	<TR BGCOLOR="00204F">
		<TD WIDTH='20%' align="center">   
		<xg:sortedHeader key="Num. Asuntos" id="0" form="reporteForm" orden="<%=tableManager.getOrden(0)%>" />
		</TD>
		<TD WIDTH='30%' align="center">
		<xg:sortedHeader key="Estatus" id="1" form="reporteForm" orden="<%=tableManager.getOrden(1)%>" />
		</TD>
		<TD WIDTH='50%' align="center"> 
		<xg:sortedHeader key="Origen" id="2" form="reporteForm" orden="<%=tableManager.getOrden(2)%>" />
		</TD>

	</TR>
</TABLE>
<DIV class=documentBody id=Body>
<TABLE width="780" align="center" >
	<logic:iterate id="registro" name="tableManager" property="registros"
		type="com.meve.sigma.asunto.AsuntoForm" indexId="contador">
		<tr>
			<td WIDTH='20%'>${registro.totalPorEstatus}</td>
			<td WIDTH='30%'>${registro.estatusNombre}</td>
			<td WIDTH='50%'>${registro.procedencia}</td>
		</tr>
	</logic:iterate>
	    <tr align="center">
			<td align="center" colspan="3" >
			<img id="graficaImg" title="Grafica de Pie" src="Graficas?tipo=<%=Graficas.GRAFICA_PIE%>&idImagen=<%=String.valueOf(new Date().getTime())%>" /></td>
		</tr>
</TABLE>
</DIV>
<%} else {%>
<CENTER>
<table cellspacing="2" cellpadding="2">
	<tr>
		<TD align="center">
		<DIV align="center">
		<p><FONT size="4" face="Verdana">***** No se han encontrado
		Documentos ***** </FONT>
		</DIV>
		</TD>
	</tr>
</table>
</CENTER>
<%}%>
<!-- script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script-->
</HTML>
