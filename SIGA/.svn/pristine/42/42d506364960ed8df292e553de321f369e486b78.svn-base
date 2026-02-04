<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
<script type="text/javascript" src="./js/ventana/controladorDeContenido.js"></script>
<jsp:useBean id="unidades" scope="session" type="java.util.List"
	class="java.util.ArrayList" />
<jsp:useBean id="externas" scope="session" type="java.util.List"
	class="java.util.ArrayList" />
<jsp:useBean id="tipoEntidades" scope="session" type="java.lang.String"
	class="java.lang.String" />
</HEAD>
<BODY background="./Imagenes/fondo_claro.jpg">
<html:form action="directorio.siga">
    <input type="hidden" value="directorio" name="accion" />
	 <input type="hidden" value="" name="idLink" />
	<h2>&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<font color="#2121ff" face="Arial"> <strong><em>Directorio</em></strong>
	</font></h2>
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr valign="top">
			<td width="15%">
			<div align="left"><input type="button" onclick="submitForm(document.directorioForm,'directorio','cargaInternos');return false;"
				value="U.A. de la SHCP" class="blue100a"></div>
			</td>
			<td width="15%">
			<div align="center"><input type="button" onclick="submitForm(document.directorioForm,'directorio','cargaExternos');return false;"
				value="Areas Externas" class="blue100a"></div>
			</td>

			<td width="20%">&nbsp;</td>
			<td width="50%">
			<div align="right"><input type="button"
				onclick="submitForm(document.directorioForm,'directorio','nuevaEntidad'); return false;" value="Otra Entidad..."
				class="blue100a"> <input type="button"
				onclick="submitVentana('directorio','guardaArea',document.directorioForm,'ventana');return false;" value="Aceptar" class="blue100a">
			<input type="button" value="Cancelar" class="blue100a"
				onclick="cierraVentana('ventana');return false;"></div>
			</td>
		</tr>
	</table>
	<logic:equal value="externas" name="tipoEntidades">
	<div align="left">Buscar: &nbsp; <html:text property="cadenaBusqueda" maxlength="199" styleClass="blue200"/><A title="Buscar"
		onclick="submitForm(document.directorioForm,'directorio','buscaExternos'); return false;">&nbsp; <IMG border="0"
		src="./Imagenes/ico_bus.gif" width="26" height="26"></A><br>
	</div>
	<BR>
	<table width="100%" border="0">
		<tr BGCOLOR="00204F">
			<TD WIDTH='100%' align="center"><FONT SIZE=1 COLOR="FFFFFF"
				FACE="verdana"> <a onclick="cambio('asc', 1)"><IMG
				border="0" src="./Imagenes/arriba.gif" align="middle" width="10"
				height="10"></a> Entidades de la Unidad Administrativa <a
				onclick="cambio('desc', 1)"><IMG border="0"
				src="./Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font></TD>
		</tr>
	</table>
	<DIV class=documentBody id=Body>
	<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
		<logic:iterate id="registro" name="externas"
			type="com.meve.sigma.catalogos.CatalogoEntidad"
			indexId="contador">
			<tr>
				<td width="100%"><html:radio property="idEntidad" value="${registro.id}" />   
					 <FONT face=Arial color="#000080" size=1>
					    <A> <%=Utilerias.recortaString(registro.getNombre(),80)%></A>
					 </FONT>
			    </td>
			</tr>

		</logic:iterate>
	</TABLE>
	</DIV>
	<br>
	</logic:equal>
	<logic:equal value="internas" name="tipoEntidades">
    <div align="left">Buscar: &nbsp; <html:text property="cadenaBusqueda" maxlength="199" styleClass="blue200"/><A title="Buscar"
		onclick="submitForm(document.directorioForm,'directorio','buscaInternos'); return false;">&nbsp; <IMG border="0"
		src="./Imagenes/ico_bus.gif" width="26" height="26"></A><br>
	</div>
	<BR>
	<TABLE WIDTH='100%' BORDER=0>
		<TR BGCOLOR="00204F">
			<TD WIDTH='80%' align="center"><FONT SIZE=1 COLOR="FFFFFF"
				FACE="verdana"> <a onclick="cambio('asc', 1)"><IMG
				border="0" src="./Imagenes/arriba.gif" align="middle" width="10"
				height="10"></a> Unidad Administrativa <a
				onclick="cambio('desc', 1)"><IMG border="0"
				src="./Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font></TD>
			<TD WIDTH='20%' align="center"><FONT SIZE=1 COLOR="FFFFFF"
				FACE="verdana"> <a onclick="cambio('desc', 2)"><IMG
				border="0" src="./Imagenes/arriba.gif" align="middle" width="10"
				height="10"></a> Operando en SIGA <a onclick="cambio('asc', 2)"><IMG
				border="0" src="./Imagenes/abajo.gif" align="middle" width="10"
				height="10"></a> </font></TD>
		</TR>
	</TABLE>
	<DIV class=documentBody id=Body>
	<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
		<logic:iterate id="registro" name="unidades"
			type="com.meve.sigma.catalogos.CatalogoArea"
			indexId="contador">
			<tr>
				<td width="80%">
				    <html:radio property="idArea" value="${registro.id}"/> 
					<logic:equal value="false" property="activa" name="registro">
					<FONT face=Arial color="red" size=1>
					   <A id="area"> <%=Utilerias.recortaString(registro.getNombre(),80)%></A>
					 </FONT>
					 </logic:equal>   
					 <logic:equal value="true" property="activa" name="registro">
					 <FONT face=Arial color="#000080" size=1>
					    <A> <%=Utilerias.recortaString(registro.getNombre(),80)%></A>
					 </FONT>
					 </logic:equal>
			    </td>
				<td width="20%" align="center">
				   <logic:equal value="true" property="activa" name="registro">
				       Si
				   </logic:equal>
				   <logic:equal value="false" property="activa" name="registro">
				      No
				   </logic:equal>
				 </td>
			</tr>

		</logic:iterate>
	</TABLE>
	</DIV>
	</logic:equal>
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