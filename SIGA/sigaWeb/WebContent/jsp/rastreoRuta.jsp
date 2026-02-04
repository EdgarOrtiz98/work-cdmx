<%--
*******************************************************************************
* Copyright (C) 2007 SHCP 
* CGTIyC - alejandro_gavia@hacienda.gob.mx
* 
* $$Archivo 	rastreoRuta.jsp
* $$Revisión 	DARG - Modificaciones y adaptaciones para SIGA. 
* $$Fecha 	29 Marzo 2007
* $$Descripción Redireccionamiento de la carpeta JSP a AsuntosRelacionados.jsp
* 
* Este software es información propietaria y confidencial de la SHCP - CGTIyC. 
*******************************************************************************
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*" %>
<%
UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
String strTmp=request.getRequestURI();
strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
if(BUsuario==null)
try{
        response.sendRedirect("index.jsp?pagina="+ strTmp);
}catch(java.io.IOException io){;}

    String folio = request.getParameter("folio");
    if (folio!= null){}else{folio="";}
%>
<jsp:include page="/cgtic/seguimiento/AsuntosRelacionados.jsp" flush="false">
    <jsp:param name="folio" value="<%=folio %>"/>
</jsp:include>
