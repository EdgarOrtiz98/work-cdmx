<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerCiudadano.jsp" flush="false"></jsp:include>
<jsp:useBean id="CiudadanoBean" class="com.meve.sigma.beans.CiudadanoBean" scope="page"></jsp:useBean>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*"
%>
<%
	BeanCiudadano BCiudadano = (BeanCiudadano)session.getAttribute("CiudadanoBean"); 
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+11,strTmp.length());
	if(BCiudadano==null){  
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}

	int ir = 0;
	String strAccion = request.getParameter("accion");
	String strIdCiudadano = BCiudadano.getIdUsuario();
	String strMail		=	BCiudadano.getMail();
	String strNombre	=	BCiudadano.getNombre();
	String strUser		=	BCiudadano.getUsuario();

	if(strAccion != null && strAccion.equals("editar")){
		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
		String portServer = application.getInitParameter("PortMail");
		String serverName = application.getInitParameter("servername");
		ir = CiudadanoBean.editarPassword(request, serverMail, portServer, serverName);
		//ir = new Integer(strDatos[0]).intValue();
		//if(ir == 0){
			//String stridCiudadano = ActualizaCiudadano.getUltimoIdCiudadano();
		if(ir >= 0){
			//String stridCiudadano = Integer.toString(ir);
			try{
				response.sendRedirect("PortalCiudadano.jsp");
			}catch(java.io.IOException io){
				//System.err.println("Error de redirección-->"+io);
			}
		}
	}
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<TITLE>EditarPassword.jsp</TITLE>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="valida=0;">
<FORM name="formPassword" action="EditarPassword.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%=strIdCiudadano%>" name="reg_id">
<INPUT type="hidden" value="<%=strMail%>" name="mail">
<INPUT type="hidden" value="<%=strNombre%>" name="nombre">
<INPUT type="hidden" value="<%=strUser%>" name="user">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%" colspan="2">
			<DIV align="right"></DIV>
			</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<% if(ir == -1){%>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="536"><B><FONT face="Verdana" color="RED" size="3">La Clave Anterior no coincide</FONT></B></TD>
			<TD width="44">&nbsp;</TD>
			<TD width="265">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<BR>
<% } %>
<% if(ir == -2){%>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="628"><B><FONT face="Verdana" color="RED" size="3">Verifique que la nueva clave coincida con la clave de confirmación</FONT></B></TD>
			<TD width="111">&nbsp;</TD>
			<TD width="106">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<br>
<% } %>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="125"><a href="EditarDatos.jsp"> <IMG border="0"
				src="../Imagenes/Regresar.gif" width="82" height="26"> </a></TD>
			<TD width="125"><a onclick="EditarPassword()"> <img
				src="../Imagenes/Guardar.gif" width="81" border="0" name="guardaImg"> </a></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="227"></TD>
		</TR>
		<TR valign="top">
			<TD></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
	<TR valign="top">
		<TD width="183"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
		<TD colspan="3"><FONT face="Verdana" size="2"><I></I></FONT></TD>
	</TR>
	<tr valign="top">
		<TD colspan="4">
			<B><FONT face="Verdana" color="#00204f" size="2">Datos de Usuario</FONT></B>
		</TD>
	</tr>
	<tr valign="top">
		<TD bgcolor="#004080" colspan="4"><img src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
	</tr>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183"><b><font size="2" color="#004080" face="Arial">Usuario*:</FONT></b></TD>
		<TD colspan="3"><FONT size="2" face="Arial"><%=BCiudadano.getUsuario()%></FONT><br>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183"><b><font size="2" color="#004080" face="Arial">Clave Anterior*:</FONT></b></TD>
		<TD colspan="3"><FONT size="2" face="Arial"><INPUT size="50"
			type="password" name="pass1" class="blue100" maxlength="8"></FONT><br>
			<%if(ir == -1){%><FONT size="1" face="Arial" color="red">La clave anterior no coincide</FONT><%}%>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183"><b><font size="2" color="#004080" face="Arial">Nueva Clave*:</FONT></b></TD>
		<TD colspan="3"><FONT size="2" face="Arial"><INPUT size="50"
			type="password" name="pass2" class="blue100" maxlength="8"></FONT></TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183"><b><font size="2" color="#004080" face="Arial">Confirmar Nueva Clave*:</FONT></b></TD>
		<TD colspan="3"><FONT size="2" face="Arial"><INPUT size="50"
			type="password" name="pass3" class="blue100" maxlength="8"></FONT><br>
			<%if(ir == -2){%><FONT size="1" face="Arial" color="red">Ingresa la misma Clave para los mismos casilleros</FONT><%}%>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
</table>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="628"><FONT size="2" face="Arial" color="#004080">Si tienes tu correo electrónico registrado en el sistema,
			se te emitira un mail con tu nueva contraseña</FONT>
			<TD width="111">&nbsp;</TD>
			<TD width="106">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>
