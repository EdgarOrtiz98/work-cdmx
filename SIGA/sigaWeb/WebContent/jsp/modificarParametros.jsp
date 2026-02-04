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
<TITLE>modificar Parametro</TITLE>
<script type="text/javascript" src="./js/menu.js"></script>
<script type="text/javascript" src="./js/SigaJS.js"></script>
<STYLE type=text/css>
BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<jsp:useBean id="paremetrosForm" type="com.meve.sigma.parametros.ParametrosForm"
	class="com.meve.sigma.parametros.ParametrosForm" scope="session" />
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
	<TABLE align="center">
		<TBODY>
			<TR valign="top">
				<TD colspan="2">
				<A href="javascript:;" onclick="submitForm(document.parametrosForm,'','');return false;"> <IMG border="0"
					src="./Imagenes/NavLeft.gif" title="Regresar" title="Regresar"> 
				</A>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<A onclick="submitForm(document.parametrosForm,'actualizarParametro','');return false;">
				  <img src="./Imagenes/Save.gif" title="Guardar"> 
			    </a></TD>
			</TR>

			<TR valign="top">
				<TD width="336" colspan="2"><FONT color="#00204f"
					size="37777777777"><B><FONT size="+1" color="#004080">Parametros</FONT></B></FONT><FONT></FONT>
				</TD>
				<TD width="53">&nbsp;</TD>
				<TD align="right" width="355">&nbsp;<FONT color="black">**Los
				datos marcados con negritas son obligatorios</FONT></TD>
			</TR>
			<TR valign="top">
				<td bgcolor="#004080" colspan="4"><img
					src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
			</TR>
			<TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD colspan="3"></TD>
			</TR>
			<TR valign="top">
				<TD width="144"><BR>
				<BR>
				</TD>
				<TD width="192"></TD>
				<TD width="53"></TD>
				<TD width="355"></TD>
			</TR>
			<TR valign="top">
				<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Parametro:</B></FONT><FONT
					color="#004080"></FONT></TD> 
				<TD><html:text property="parametroId" size="50" readonly="true" value="${paremetrosForm.parametroId}"></html:text></TD>
			</TR>
			<TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD width="192">&nbsp;</TD>
				<TD width="53">&nbsp;</TD>
				<TD width="355">&nbsp;</TD>
			</TR>
			<TR>
			<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Valor:
				</B></FONT></TD>
				<TD>
				<html:text property="parametroValor" size="50" value="${paremetrosForm.parametroValor}"></html:text>
				</TD>
			</TR>
			<TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD width="192">&nbsp;</TD>
				<TD width="53">&nbsp;</TD>
				<TD width="355">&nbsp;</TD>
			</TR>
			<TR valign="top">
				<TD width="144"><FONT face="Verdana" size="2" color="#004080">Descripción:
				</FONT></TD>
				<TD colspan="3"><html:text property="parametroDescripcion" value="${paremetrosForm.parametroDescripcion}" size="50"></html:text>
				</TD>
			</TR>
			<TR>
			<TR valign="top">
				<TD colspan="4">&nbsp;</TD>
			</TR>
		</TBODY>

	</TABLE>
</html:form>
<%
	String error =com.meve.sigma.util.Converters.getJavaScriptErrorString(request);
	if (!error.equals("")) {
%> <script>alert('<%=error%>');</script> <% } %>
</BODY>
</HTML>