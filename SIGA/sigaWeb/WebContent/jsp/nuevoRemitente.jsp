<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,
			com.meve.sigma.util.Utilerias,
			com.meve.sigma.beans.*,
			com.meve.sigma.taglib.*"%>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Remitente</TITLE>
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT language="JavaScript" type="text/javascript"></SCRIPT>
<jsp:useBean id="catalogoArea" scope="session"
	class="java.util.ArrayList" type="java.util.List"></jsp:useBean>
<jsp:useBean id="catalogoEntidad" scope="session"
	class="java.util.ArrayList" type="java.util.List"></jsp:useBean>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg">
<form action="nuevoRemitente.siga">
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="150"><a href=""> <img
				src="../Imagenes/NavLeft.gif" title="Regresar" border="0"> </a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a onclick=""> <img
				src="../Imagenes/Save.gif" title="Guardar" border="0"> </a> &nbsp;</TD>
			<TD width="150">&nbsp;</TD>
			<TD width="150"></TD>
			<TD width="217"></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<BR>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336" colspan="2"><B><FONT face="Verdana"
				color="#00204f" size="2">Remitentes</FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<td bgcolor="#004080" colspan="4" width="672"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
			<TD align="right" colspan="3" width="528"><FONT face="Verdana"
				size="2"></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>




<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2"><B>Unidad
			Administrativa:</B></FONT></TD>
			<TD width="528" colspan="3"><FONT face="Verdana" size="2">
			<html:select property="idArea" styleClass="blue500a">
				<html:option value="-1">------------- Seleccione una Unidad Administrativa ------------- </html:option>
				<logic:iterate id="registro" name="catalogoArea"
					type="com.meve.sigma.catalogos.CatalogoArea">
					<html:option value="${registro.id}">${registro.nombre}</html:option>
				</logic:iterate>
			</html:select> </FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2"><B>Nombre:</B></FONT></TD>
			<TD width="528" colspan="3"><FONT face="Verdana" size="2">
			<html:text property="nombre" size="80" styleClass="blue500"
				maxlength="199" /> </FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2"><B>Cargo:</B></FONT></TD>
			<TD width="528" colspan="3"><FONT face="Verdana" size="2">
			<html:text property="cargo" size="80" styleClass="blue500"
				maxlength="199" /> </FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2"><B>Entidad:</B></FONT></TD>
			<TD width="528" colspan="3"><FONT face="Verdana" size="2">
			<html:select property="idEntidad" styleClass="blue500a">
				<html:option value="-1">------------- Seleccione una Entidad ------------- </html:option>
				<logic:iterate id="registro" name="catalogoEntidad" type="com.meve.sigma.catalogos.CatalogoEntidad">
					<html:option value="${registro.id}">${registro.nombre}</html:option>
				</logic:iterate>
			</html:select> </FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">Dirección:</FONT></TD>
			<TD width="528" colspan="3"><html:text property="direccion"
				size="80" styleClass="blue500" maxlength="199" /></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">Telefono:</FONT></TD>
			<TD width="528" colspan="3"><FONT face="Verdana" size="2">
			<html:text property="telefono" size="80" styleClass="blue500"
				maxlength="199" /></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">Fax:</FONT></TD>
			<TD width="528" colspan="3"><FONT face="Verdana" size="2">
			<html:text property="fax" size="80" styleClass="blue500"
				maxlength="199" /></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">Correo:</FONT></TD>
			<TD width="528" colspan="3"><FONT face="Verdana" size="2">
			<html:text property="correo" size="80" styleClass="blue500"
				maxlength="199" /></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>

	</TBODY>
</TABLE>
</DIV>
</form>
</BODY>
</HTML>
