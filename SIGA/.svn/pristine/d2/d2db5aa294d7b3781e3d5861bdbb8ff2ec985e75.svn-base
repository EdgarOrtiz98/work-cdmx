<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerUCT.jsp" flush="false"></jsp:include>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="meve_front" prefix="meve_front"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.meve.sigma.beans.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+11,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("login.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}
	//System.err.println("BusarioNombre-->"+BUsuario.getNombre());
	//System.err.println("IdUsuario-->"+BUsuario.getIdUsuario());
	boolean bExiste = false;
	//bExiste = ActualizaCiudadano.getExisteSolicitud(BCiudadano.getIdUsuario());
%>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<STYLE type="text/css">
</STYLE>
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<script language="JavaScript" type="text/javascript">
</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY BGCOLOR="FFFFFF" background="../Imagenes/fondo_claro.jpg">
<FORM action="PortalCiudadanoUCT.jsp" name="formPortalCiuUCT" method="post">
<input type="hidden" name="__Click" value="0">
<INPUT type="hidden" value="guardar" name="accion">
<TABLE>
	<TBODY>
		<TR>
			<TD><FONT size="2" color="red" face="Arial">
				Bienvenido: <i><STRONG><%=BUsuario.getNombre()%></STRONG></i> al Portal Ciudadano</FONT>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE width="100%" border="1">
	
	<!-- <TR>
		<TD width="25%" align="left">Respuesta a ONG</TD>
		<TD width="25%" align="center">518-AS-128</TD>
		<TD width="25%" align="center">17 Enero 2005</TD>
		<TD width="25%" align="center">En proceso (91% avance)</TD>
	</TR>
	<TR>
		<TD width="25%" align="left">Solicitud impresión de información</TD>
		<TD width="25%" align="center">678-REV-17</TD>
		<TD width="25%" align="center">25 Marzo 2005</TD>
		<TD width="25%" align="center">En espera de respuesta del ciudadano</TD>
	</TR>
	<TR>
		<TD width="25%" align="left">Solicitud cambio de correo electrónico</TD>
		<TD width="25%" align="center">892-SIS-323</TD>
		<TD width="25%" align="center">14 Diciembre 2005</TD>
		<TD width="25%" align="center">No ha iniciado el proceso</TD>
	</TR>-->
</TABLE>
<DIV id="msg"></DIV>
<DIV class="documentBody" id="Body">
<DIV id="view">


</DIV>
</DIV>
</FORM>
</BODY>
</HTML>
