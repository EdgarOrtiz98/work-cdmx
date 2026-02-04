<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page import="com.meve.sigma.reporte.ReporteForm;"%>
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="./theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="./css/menu.css" rel="stylesheet" type="text/css">
<LINK href="./css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="./css/link.css"  rel="stylesheet" type="text/css" />
<TITLE>Reporteador</TITLE>
<script type="text/javascript" src="./js/menuRep.js"></script>
<script type="text/javascript" src="./js/SigaJS.js"></script>
<script type="text/javascript" src="./js/ventana/ventanas.js"></script>
<script type="text/javascript" src="./js/ventana/controladorDeContenido.js"></script>
<script language="JavaScript" type="text/javascript">if (history.length > 0) { history.go(+1); }</script>
<STYLE type=text/css>
BODY {
	MARGIN: 0px
}
</STYLE>

<jsp:useBean id="tipoEntidades" scope="session" type="java.lang.String"
	class="java.lang.String" />
<jsp:useBean id="pantallaReporte" scope="session" type="java.lang.String"
	class="java.lang.String" />
<jsp:useBean id="UsuarioBean" scope="session" type="com.meve.sigma.beans.UsuarioBean" 
	class="com.meve.sigma.beans.UsuarioBean"/>
</HEAD>
<jsp:include page="headerSIGA.jsp" flush="false"/>
<BODY background="./Imagenes/fondo_claro.jpg">
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", 0);
%>
<html:form action="reporteador">
    <input type="hidden" value="" name="accion" />
	 <input type="hidden" value="" name="idLink" />
	<jsp:include page="${pantallaReporte}"/>
</html:form>
</BODY>
</HTML>