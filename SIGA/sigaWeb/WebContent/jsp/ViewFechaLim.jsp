<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.reportes.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null)
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}catch(java.io.IOException io){;}

%>
<%
	boolean bExistenRem = false;
	bExistenRem = ActualizaReportes.getExistenTiempoLim();
%>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>Asuntos por Fecha Límite</TITLE>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="viewFechLim" action="ViewFechaLim.jsp" method="post">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%">&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="right">
<IMG border="0" src="../Imagenes/tit_por_fec_lim.gif" width="244" height="32">
</DIV>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr valign="top">
	<td width="43%">
		<%if(BUsuario.getSupervisor()){%>
		<a title="Genera Reporte">
			<img src="../Imagenes/nuevo1.gif" width="27" height="24" border="0" title="Generar Reporte">
		</a>
		<%}%>
		<font size="2" face="Tahoma"></font>
	</td>
	<td width="57%">
	<div align="right">
		<a>
			<img src="../Imagenes/flech_cal1.gif" width="11" height="9" border="0" title="">
		</a>
		<a>
			<img src="../Imagenes/flech_cal.gif" width="11" height="9" border="0" title="">
		</a>
			<img src="../Imagenes/trans.gif" width="20" height="3" title="">
	</div>
	</td>
</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr valign="top">
	<td width="100%" bgcolor="#002060"><img src="../Imagenes/shim.gif" width="1" height="1" title=""></td>
</tr>
</table>
<br>
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='15%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">No. de Reporte</font></TD>
		<TD WIDTH='60%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Reporte</font></TD>
		<TD WIDTH='25%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Fecha de Creación</font></TD>
	</TR>
</TABLE>
<br>
<TABLE WIDTH='100%' BORDER=0>
	<TBODY>
	<% if(bExistenRem){ %>
	<meve_front:ListaDatos datos="<%= ActualizaReportes.getReportesPorFechaLim()%>" campo="campo">
	<TR>
		<TD WIDTH='15%' align="center">
			<FONT SIZE=2 COLOR="000000" FACE="Arial">
			<A>
				<%=campo1%>
			</A>
			</font>
		</TD>
		<TD WIDTH='60%' align="center"><FONT SIZE=2 COLOR="000000"
			FACE="Arial"><%=campo2%></font></TD>
		<TD WIDTH='25%' align="center"><FONT SIZE=2 COLOR="000000"
			FACE="Arial"><%=campo3%></font></TD>
	</TR>
	</meve_front:ListaDatos>
	<% }else{ %>
	<TR>
		<TD>******** No existen reportes generados *******</TD>
	</TR>
	<% } %>
	</TBODY>
</TABLE>

</FORM>
</BODY>

</HTML>
