
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.* , com.meve.sigma.util.*"
%>
<% String strRutaBase = request.getContextPath();%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null)
	try{
		response.sendRedirect("index.jsp?pagina="+ strTmp);
	}catch(java.io.IOException io){;}
%>
<HTML> 
<head><link rel="stylesheet" type="text/css" href="<%=strRutaBase%>/cgtic/css/cgtic-siga.css"/>
<script src="<%=strRutaBase%>/cgtic/js/funcionesCGTIC-SIGA.js" type="text/javascript"></script>
<script type="text/javascript">
    var globalURL = "<%=request.getParameter("Url")%>"+"&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(request.getParameter("retURI"))%>";
    var retURI = "<%=com.meve.sigma.util.Utilerias.codificaPostHTML(request.getParameter("retURI"))%>";
    var rutaBase = "<%=strRutaBase%>";
</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</head><BODY background="../Imagenes/fondo_claro.jpg">
<jsp:include page="/cgtic/asignarInstrucciones.jsp" flush="false"></jsp:include>
</BODY></HTML>
