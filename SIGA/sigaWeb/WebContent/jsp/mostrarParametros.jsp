<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="xg" tagdir="/WEB-INF/tags"%>

<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="./theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="./css/menu.css" rel="stylesheet" type="text/css">
<LINK rel="stylesheet" type="text/css"
	href="./css/calendar/calendar-meve.css" />
<TITLE>Parametros</TITLE>
<script type="text/javascript" src="./js/menu.js"></script>
<script type="text/javascript" src="./js/SigaJS.js"></script>
<STYLE type=text/css>
BODY {
	MARGIN: 0px
}
</STYLE>
<jsp:useBean id="tableManager" type="com.meve.util.ManejadorDeTablas"
	class="com.meve.util.ManejadorDeTablas" scope="session" />
</HEAD>
<jsp:include page="headerSIGAConf.jsp" flush="false" />
<BODY background="./Imagenes/fondo_claro.jpg">
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<html:form action="parametros.siga">
	<input type="hidden" value="" name="accion" />
	<input type="hidden" value="" name="idLink" />
	<a href="javascript:;"
		onclick="submitForm(document.parametrosForm,'nuevoParametro','');return false;">
	<img src="./Imagenes/nuevo1.gif" border="0" title="Nuevo"> </a>
	<A href="javascript:;"
		onclick="submitForm(document.parametrosForm,'eliminarParametros','');return false;">
	<IMG border="0" src="./Imagenes/borrar1.gif" title="Eliminar"> </A>
	<A href="javascript:;"
		onclick="submitForm(document.parametrosForm,'actualizarParametros','');return false;">
	<IMG border="0" src="./Imagenes/actualizar.gif" title="Actualizar Parametros"> </A>
	<table align="center" width="100%">

		<tr>
			<td>
			<%
			if (tableManager.getTotalRegistros() != 0) {
			%>
			<TABLE WIDTH="100%" align="center" border="0">
				<TR>
					<td colspan="3" align="right"><font color="#004080"
						face="Arial"><%=tableManager.getTotalRegistros()%>
					registros mostrados.</font></td>
				</TR>
				<TR BGCOLOR="00204F">
					<logic:iterate id="encabezado" type="com.meve.util.Encabezado"
						name="tableManager" property="encabezados" indexId="index">
						<TD align="center" width="${encabezado.width}%"><xg:sortedHeader
							key="${encabezado.titulo}" id="${index}" form="parametrosForm"
							orden="<%=tableManager.getOrden(index.intValue())%>" /></TD>
					</logic:iterate>
				</TR>
			</TABLE>
			<DIV class=documentBody id=Body>
			<TABLE width="100%" align="center" border="0">
				<logic:iterate id="registro" name="tableManager"
					property="registrosPaginaActual"
					type="com.meve.sigma.parametros.ParametrosForm" indexId="contador">
					<tr>
						<td WIDTH='35%'><input type="checkbox" name="registros"
							value="${registro.parametroId}"><a href="javascript:;"
							onclick="submitForm(document.parametrosForm,'verModificarParametro','<%=registro.getParametroId()%>');return false;">${registro.parametroId}</a></td>
						<td WIDTH='30%'>${registro.parametroValor}</td>
						<td WIDTH='35%'>${registro.parametroDescripcion}</td>
					</tr>
				</logic:iterate>
				<tr>
					<td colspan="6">
					<TABLE align="center">
						<tr><%=tableManager
										.getPaginacionHTML("parametrosForm")%></tr>
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
					<DIV align="center">
					<p><FONT size="4" face="Verdana">***** No se han
					encontrado Documentos ***** </FONT>
					</DIV>
					</TD>
				</tr>
			</table>
			</CENTER>
			<%
			}
			%>
			
			</td>
		</tr>
	</table>
</html:form>
<%
			String error = com.meve.sigma.util.Converters
			.getJavaScriptErrorString(request);
	if (!error.equals("")) {
%>
<script>alert('<%=error%>');</script>
<%
}
%>
</BODY>
</HTML>