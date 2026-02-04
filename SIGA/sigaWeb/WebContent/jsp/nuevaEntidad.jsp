<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.util.Utilerias,com.meve.sigma.taglib.*,com.meve.sigma.beans.*,java.util.*"%>
<%
			UsuarioBean BUsuario = (UsuarioBean) session
			.getAttribute("UsuarioBean");
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="./theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="./css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Entidad</TITLE>
<script type="text/javascript" src="./js/menu.js"></script>
<script type="text/javascript" src="./js/SigaJS.js"></script>
<script type="text/javascript" src="./js/ventana/ventanas.js"></script>
<script type="text/javascript"
	src="./js/ventana/controladorDeContenido.js"></script>
<jsp:useBean id="catalogoArea" scope="session"
	class="java.util.ArrayList" type="java.util.List"></jsp:useBean>
</HEAD>
<BODY background="./Imagenes/fondo_claro.jpg">
<html:form action="nuevaEntidad.siga">
	<input type="hidden" value="directorio" name="accion" />
	<input type="hidden" value="" name="idLink" />
	<h2></h2>
	<DIV align="center">
	<TABLE cellspacing="0" cellpadding="0" border="0">
		<TBODY>
			<TR valign="top">
				<TD width="150"><a href="" onclick="submitForm(document.catalogoEntidad,'regresar','');return false;"><img
					src="./Imagenes/NavLeft.gif" title="Regresar" border="0"> </a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
					onclick="submitForm(document.catalogoEntidad,'guardar','');return false;"> <img src="./Imagenes/Save.gif"
					title="Guardar" border="0"> </a> &nbsp;</TD>
				<TD width="150">&nbsp;</TD>
				<TD width="150">&nbsp;</TD>
				<TD width="217">&nbsp;</TD>
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
					color="#00204f" size="2">Entidad</FONT></B></TD>
				<TD width="144">&nbsp;</TD>
				<TD width="192">&nbsp;</TD>
			</TR>
			<TR valign="top">
				<td width="672" bgcolor="#004080" colspan="4"><img
					src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
			</TR>

			<TR valign="top">
				<TD width="144"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
				<TD width="528" align="right" colspan="3">&nbsp;</td>
			</TR>
			<TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD width="192">&nbsp;</TD>
				<TD width="144">&nbsp;</TD>
				<TD width="192">&nbsp;</TD>
			</TR>

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
				<html:select property="area" styleClass="blue500a" >
					<html:option 
						value="-1">------------- Seleccione una Unidad Administrativa ------------- </html:option>
						<logic:iterate id="registro" name="catalogoArea" type="com.meve.sigma.catalogos.CatalogoArea">
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
				<TD width="144"><FONT face="Verdana" size="2"><B>Entidad:</B></FONT>

				</TD>
				<TD width="528" colspan="3"><FONT face="Verdana" size="2">
				<html:text property="nombre" size="80" styleClass="blue500"></html:text> </FONT></TD>
			</TR>
			<TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD width="192">&nbsp;</TD>
				<TD width="144">&nbsp;</TD>
				<TD width="192">&nbsp;</TD>
			</TR>
			<TR valign="top">
				<TD width="144"><FONT face="Verdana" size="2">Clasificación:</FONT></TD>
				<TD width="528" colspan="3"><FONT face="Verdana" size="2">
				<html:select property="clasificacion"  styleClass="blue200a">
					<html:option value="Privada">Privada</html:option>
					<html:option value="Pública">Pública</html:option>
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
				<TD width="528" colspan="3"><FONT face="Verdana" size="2">
				<html:textarea property="direccion" styleClass="blue500" rows="3" cols="80"></html:textarea>
				</FONT></TD>
			</TR>
			<TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD width="192">&nbsp;</TD>
				<TD width="144">&nbsp;</TD>
				<TD width="192">&nbsp;</TD>
			</TR>
			<TR valign="top">
				<TD width="144"><FONT face="Verdana" size="2">Teléfono:</FONT></TD>
				<TD width="528" colspan="3"><FONT face="Arial" size="2">
				<html:text property="telefono" styleClass="blue500" maxlength="199"></html:text>
				</FONT></TD>
			</TR>
			<TR valign="top">
				<TD width="672" colspan="4">&nbsp;</TD>
			</TR>
		</TBODY>
	</TABLE>
	</DIV>
	<script>
	var bodyElement = document.body.all['Body'] ;
	function LayoutBodyElement() {  
	   bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;
	}
	function document.onreadystatechange(){ 
	   document.body.scroll = "no" ; 
	   LayoutBodyElement( ) ; 
	   window.onresize = LayoutBodyElement;
	 }
	 </script>
</html:form>
</BODY>
</HTML>