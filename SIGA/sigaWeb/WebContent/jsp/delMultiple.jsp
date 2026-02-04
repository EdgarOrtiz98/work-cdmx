<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,
			com.meve.sigma.util.*"
%>
<%-- String server = application.getInitParameter("servername");--%>
<%-- String nameDb = application.getInitParameter("NameBD"); --%>
<%-- String portDb = application.getInitParameter("PortBD"); --%>
<%-- String serverDb = application.getInitParameter("ServerDB"); --%>
<%-- String user = application.getInitParameter("userapplet"); --%>
<%-- String user1 = application.getInitParameter("passapplet"); --%> 
<% String strRutaBase = (application.getInitParameter("RutaBase")==null)?"":application.getInitParameter("RutaBase"); %>
<% strRutaBase=request.getContextPath();%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null)
	try{
		response.sendRedirect("index.jsp?pagina="+ strTmp);
	}catch(java.io.IOException io){}
%>
<HTML> 
<%--**************************************************************
* 11 Enero 2007 SHCP 
* CGTIyC - DARG <alejandro_gavia@hacienda.gob.mx>
**************************************************************--%>
<head><link rel="stylesheet" type="text/css" 
    href="../cgtic/css/cgtic-siga.css"/>
<script src="<%=strRutaBase%>/cgtic/js/funcionesCGTIC-SIGA.js" 
    type="text/javascript"></script>
<script type="text/javascript">
    var globalURL = "<%=request.getParameter("retURI")%>";
    var rutaBase = "<%=strRutaBase%>";
</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>   
</head><BODY background="../Imagenes/fondo_claro.jpg">
<jsp:include page="/cgtic/delegarInstrucciones.jsp" flush="false"></jsp:include>
</BODY></HTML>
