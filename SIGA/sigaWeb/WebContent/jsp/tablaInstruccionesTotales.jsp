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


<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<jsp:useBean id="tableManager" type="com.meve.util.ManejadorDeTablas"
	class="com.meve.util.ManejadorDeTablas" scope="session" />
</HEAD>
<BODY background="./Imagenes/fondo_claro.jpg">

<%if (tableManager.getTotalRegistros() != 0) {%>
<TABLE WIDTH="900" align="center">
	<TR>
		<td colspan="5">
		<font color="#004080" face="Arial"><strong>Instrucciones</strong></font>
		</td>
	</TR>
	<TR BGCOLOR="00204F">
		<TD WIDTH='20%' align="center">   
		<xg:sortedHeader key="Num. Asuntos" id="0" form="reporteForm" orden="<%=tableManager.getOrden(0)%>" />
		</TD>
		<TD WIDTH='30%' align="center">
		<xg:sortedHeader key="Estatus" id="1" form="reporteForm" orden="<%=tableManager.getOrden(1)%>" />
		</TD>
		<TD WIDTH='50%' align="center"> 
		<xg:sortedHeader key="Usuario" id="2" form="reporteForm" orden="<%=tableManager.getOrden(2)%>" />
		</TD>
	</TR>
</TABLE>
<DIV>	

<TABLE width="900" align="center">
	<logic:iterate id="registro" name="tableManager" property="registrosPaginaActual"
		type="com.meve.sigma.instruccion.InstruccionForm" indexId="contador">
		<tr>
			<td WIDTH='25%'>${registro.totalPorEstatus}</td>
			<td WIDTH='25%'>${registro.estatusNombre}</td>
			<td WIDTH='50%'>${registro.usuarioNombre}</td>

		</tr>
	</logic:iterate>
	<tr>
		<td colspan="6">
		<TABLE align="center">
			<tr><%=tableManager.getPaginacionHTML("reporteForm")%></tr>
		</table>
		<td>
	</tr>
	 <tr align="center">
			<td align="center" colspan="3" >
			<img id="graficaImg" title="Grafica de Pie" src="Graficas?tipo=<%=Graficas.GRAFICA_PIE%>&idImagen=<%=String.valueOf(new Date().getTime())%>" /></td>
		</tr>
</TABLE>
<%
} else {
%>
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
<%
}
%>
</DIV>
</BODY>
</HTML>
