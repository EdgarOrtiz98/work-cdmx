<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.util.Utilerias,com.meve.sigma.beans.*,com.meve.sigma.taglib.*"%>




<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="./theme/Master.css" rel="stylesheet"type="text/css">
<LINK href="./css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Remitente</TITLE>
<SCRIPT src="./js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="./js/valida.js" type=text/javascript></SCRIPT>
<script type="text/javascript" src="./js/SigaJS.js"></script>
<script type="text/javascript" src="./js/ventana/ventanas.js"></script>
<script type="text/javascript" src="./js/ventana/controladorDeContenido.js"></script>
<jsp:useBean id="remitentes" scope="session" type="java.util.List" class="java.util.ArrayList" />
</HEAD>
<BODY background="./Imagenes/fondo_claro.jpg">
<html:form action="remitente.siga">
<INPUT type="hidden" name="accion" value="remitentes">
<INPUT type="hidden" name="idLink" value="" >
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="367" class="etiquetas"> 
			<div align="left">
				Puesto:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<html:text property="cadenaBusqueda" styleClass="blue200" maxlength="199" /><BR>
				Responsable:&nbsp;
				<html:text property="segundaCadenaBusqueda" styleClass="blue200" maxlength="199" /><BR>
				Buscar:&nbsp;<A title="Buscar" onclick="submitForm(document.remitenteForm,'remitentes','cargaRemitentes'); return false;"><IMG border="0" src="./Imagenes/ico_bus.gif" width="26" height="26" ></A><br>
			</div>
		</td>
		<td width="10">
			<div align="right">
			</div>
		</td>
		<td width="">
			&nbsp;
		</td>
		<td width="500">
			<DIV align="right">
				<input type="button" value="Otro Remitente..." class="blue200a" onclick="submitForm(document.remitenteForm,'remitentes','nuevoRemitente'); return false;">
				<input type="button" value="Aceptar" class="blue100a" onclick="submitForm(document.remitenteForm,'remitentes','guardaRemitente'); return false;">
				<input type="button" value="Cancelar" class="blue100a" onclick="cierraVentana('ventana');return false;">
			</DIV>
		</td>
	</tr>
</table>
<BR>
<div align="left">
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="100%">
			<b><font size="2" color="#00204F" face="Verdana">Remitentes</font></b>
			<b><font size="2" color="#00204F" face="Verdana">de la Unidad</font></b>
		</td>
	</tr>
</table>
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='50%' align="center">
			<FONT SIZE=2 COLOR="FFFFFF" FACE="verdana"><b>Puesto</b></font>
		</TD>
		<TD WIDTH='50%' align="center">
			<FONT SIZE=2 COLOR="FFFFFF" FACE="verdana"><b>Responsable</b></font>
		</TD>
	</TR>	
</TABLE>
<DIV class=documentBody id=Body>
<% if(remitentes.size()!=0){ %>
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
	<logic:iterate id="registro" name="remitentes"
			type="com.meve.sigma.beans.UsuarioBean"
			indexId="contador">
			<tr>
				<td width="80%">
				    <html:radio property="idRemitente" value="${registro.strIdUsuario}"/>${registro.strCargo}
			    </td>
				<td width="20%" align="center">
				 ${registro.strNombre}
				 </td>
			</tr>
		</logic:iterate>
</TABLE>
<% } else { %>
<CENTER>
<table cellspacing="2" cellpadding="2">
	<tr>
		<TD align="center">
			<DIV align="center">
				<p><FONT size="4" face="Verdana">***** No se han encontrado
		Documentos ***** </FONT></DIV>
		</TD>
	</tr>
</table>
</CENTER>
<%}%>
<BR>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</html:form>
</BODY>
</HTML>
