<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page import="com.meve.sigma.util.Utilerias"%>
<%@page import="com.meve.sigma.util.Converters"%>
<HTML>
<HEAD>
<TITLE>Puestos</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="./theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="./css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="./css/link.css" rel="stylesheet" type="text/css">
<LINK href="./css/menu.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="./js/SigaJS.js"></script>
<script type="text/javascript" src="./js/ajax.js"></script>
<jsp:useBean id="UsuarioBean" scope="session" 
	type="com.meve.sigma.beans.UsuarioBean"
	class="com.meve.sigma.beans.UsuarioBean" />
<jsp:useBean id="areas" scope="session" class="java.util.ArrayList"
	type="java.util.List"></jsp:useBean>
<jsp:useBean id="area" scope="session"
	class="com.meve.sigma.organizacional.vo.AreaVO"
	type="com.meve.sigma.organizacional.vo.AreaVO"></jsp:useBean>
<STYLE type=text/css>
BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<jsp:include page="headerSIGA.jsp" flush="false" />
<BODY background="../Imagenes/fondo_claro.jpg">
<%
	String strTmp = request.getRequestURI();
	strTmp = strTmp.substring(strTmp.indexOf('/', 2) + 5, strTmp
			.length());
	if (UsuarioBean == null) {
		try {
			response.sendRedirect("index.jsp?pagina=" + strTmp);
		} catch (java.io.IOException io) {
		}
	}
%>
<html:form action="estructuraOrganizacional">
	<input type="hidden" value="" name="accion" />
	<input type="hidden" value="" name="idLink" />
	<%
	if (UsuarioBean.getAdmon()) {
	%>
	<DIV align="center">
	<TABLE border="0" >
		<TR>
			<TD align="center" width="500"><b>Unidad Administrativa</b></TD>
		</TR>
		<TR align="center">
			<TD align="center" width="500">
			<html:select property="idArea" onchange="submitForm(estructuraOrganizacionalForm,'mostrar',this.value);return false;"
				styleClass="blue500a">
				<html:option value="-1">------------- Seleccione una Unidad Administrativa ------------- </html:option>
				<logic:iterate id="registro" name="areas"
					type="com.meve.sigma.organizacional.vo.AreaVO">
					<html:option value="${registro.idArea}">${registro.nombreHTML}</html:option>
				</logic:iterate>
			</html:select></TD>
		</TR>
	</TABLE>
	</DIV>
	<%
	}
	%>
	<DIV align="center">
	<TABLE border="0" width="70%">
		<TBODY>
			<TR valign="middle">
				<TD class="etiquetas1v" align="left">
					<% if (UsuarioBean.getAdmon() || UsuarioBean.getSupervisor()){ %>
				<A href="./puesto.siga?accion=nuevoPuesto&idLink=mostrar"  target="_self"> 
				<IMG height="26" src="./Imagenes/nuevo1.gif" width="27" border="0" title="Nuevo Puesto"> 
				</A> 
			    <A href="javascript:;" onclick="submitForm(estructuraOrganizacionalForm,'mostrarPorRoles','2');return false;" target="_self"> 
				<IMG height="26" src="./Imagenes/mostrarPorRoles.gif" width="27" border="0" title="Mostrar Puestos por Roles"> 
				</A> 
			<%	} %>
				<B><FONT size="+1">&nbsp;&nbsp;Puestos</FONT></B></TD>
				<TD align="right">
				   <TABLE ><TR>
		              <TD><B>Busqueda</B></TD>
		              <TD><input type="text" class="blue200a" id="busqueda" onkeyup="cargaUrl('./EstructuraOrganizacionalAjax?accion=buscar&cadena=',this.value,muestraUsuarios);"></TD>
		           </TR></TABLE>
		           <div id="divUsuarios" style="display: none; position: absolute"></div>
		        </TD>
			</TR>
			<TR valign="middle">
				<td bgcolor="#004080" colspan="2"><img src="../Imagenes/shim.gif" width="1" 
					height="2" title=""></td>
			</TR>
		</TBODY>
	</TABLE>
	</DIV>

	<DIV align="center">
	<TABLE border="0" width="70%">
		<tr bgcolor="#004080">
			<TD align="left" width="696" class="etiquetasTit"><B>Responsable
			de la Unidad Administrativa: ${estructuraOrganizacionalForm.areaNombre}</B></TD>
		</tr>
		<tr>
			<TD align="left" width="696" class="etiquetas"><A
				href="javascript:;"
				class="etiquetas"
				title="${estructuraOrganizacionalForm.responsableNombre}"><B><U>
			${estructuraOrganizacionalForm.cargoNombre}</U></B></A></TD>
		</tr>
		<TR>
			<TD>&nbsp;</TD>
		</TR>

		<tr>
			<TD align="left" class="etiquetas">
			<FIELDSET dir="ltr" class="bluethinBorder"><LEGEND align="left"><FONT
					SIZE=2 FACE="Verdana" color="#004080"><B>Organigrama
			de la Unidad</B></FONT></LEGEND> 
			   <div id="orgPrincipal">
			      <%=Converters.convertElementToString(area.getOrganigramaPrincipalHTML(null))%></div>
			 </FIELDSET> 
			</TD>
		</tr>

		<tr>
			<TD align="left" class="etiquetas">
			<FIELDSET dir="ltr" class="bluethinBorder" ><LEGEND align="left"><FONT
					SIZE=2 FACE="Verdana" color="#004080"><B>Puestos
			de la Unidad sin relación al Organigrama principal</B></FONT></LEGEND> 
			<div id="orgNoRelacionado">
			<DL><DT><%=Converters.convertElementToString(area.getOrganigramaSinRelacionHTML(null))%></DT></DL></div>
			</FIELDSET>
			</TD>
		</tr>
	</TABLE>
	</DIV>
</html:form>
</BODY>
</HTML>
