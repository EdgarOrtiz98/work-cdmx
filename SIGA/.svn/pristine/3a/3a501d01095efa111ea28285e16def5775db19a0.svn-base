<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){;}
	}	

%>
<%
	boolean bMostrar	=	true;
	boolean bExiste		=	true;

	bExiste		=	ActualizaAsunto.getExistenAsuntos(BUsuario.getIdArea(), BUsuario.getIdUsuario());
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>Turnado por Fecha</TITLE>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="turnadoFechaV" action="TurnadoPorFechaV.jsp" method="post">
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='20%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Folio</font></TD>
		<TD WIDTH='30%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Titulo</font></TD>
		<TD WIDTH='30%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Solicitante</font></TD>
		<TD WIDTH='20%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Estatus</font></TD>
	</TR>
</TABLE>
<br>
<table>
	<% if(bExiste){ %>
	<meve_front:ListaDatos
		datos="<%= ActualizaAsunto.AsuntosPorFechaTV() %>" campo="campo">
		<table border="0" cellpadding="2" cellspacing="0">
			<tr valign="top">
				<td colspan="2" nowrap onClick="document.recepcionFecha.submit();">
				<a name="1"></a> <img
					src="../Imagenes/<%=(bMostrar)?"collapse.gif":"expand.gif"%>"
					border="0" height="16" width="16"
					title="<%=(bMostrar)?"Hide":"Show"%> details for <%= campo1 %>"> <%= campo1 %></td>
				<td width="368"></td>
			</tr>
			<%if(bMostrar)
	  		{ 
		%>
			<meve_front:ListaDatos
				datos="<%= ActualizaAsunto.getFechaAsuntoTV(campo1) %>"
				campo="usuario">
				<tr valign="top">
					<td nowrap></td>
					<td align="center" width="19%"><font size="1" color="#000080"
						face="Arial"> <A href="Asuntos.jsp?id_asunto=<%= usuario1 %>"><%= usuario2 %></A></font>
					</td>
					<td align="center" width="368"><font size="1" color="#000080"
						face="Arial"> <%= usuario3 %> </font></td>
					<td align="center" width="368"><font size="1" color="#000080"
						face="Arial"> <%= ActualizaRemitente.getNombreRemitente(usuario4) %>
					</font></td>
					<td align="center" width="243"><font size="1" color="#000080"
						face="Arial"> <%= usuario5 %> </font></td>
				</tr>
			</meve_front:ListaDatos>
			<% 
	  		}
	%>
		</table>
	</meve_front:ListaDatos>
	<% }else{ %>
	<TR>
		<TD width="100%">
		<div align=center><FONT face="verdana" size="4">******No Existen
		Asuntos por Fecha de Vencimiento******</FONT></div>
		</TD>
	</TR>
	<% } %>
</table>
</FORM>
</BODY>

</HTML>
