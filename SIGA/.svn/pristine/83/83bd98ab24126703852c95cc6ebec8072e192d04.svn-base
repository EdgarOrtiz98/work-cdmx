<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,com.meve.sigma.reportes.*,com.meve.sigma.util.*,java.util.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null)
	try{
		response.sendRedirect("index.jsp?pagina="+ strTmp);
	}catch(java.io.IOException io){;}

	java.text.SimpleDateFormat sdf	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	String strFechaActual			=	sdf.format(f);

	String strIdAsunto = (request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
	String strIdArea   = (request.getParameter("id_area") != null)?request.getParameter("id_area"):"";
	String strAccion = request.getParameter("accion");

	String strDetalleInstrucciones[][] = null;

	if(strIdAsunto != null && strIdAsunto.length() > 0){
		strDetalleInstrucciones = ActualizaInstrucciones.getInstruccionesDetalle(strIdAsunto);
	}
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>Detalle de las Instrucciones</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
</HEAD>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="ViewDoctosDetalle.jsp" name="viewDetalle" method="post">
<INPUT type="hidden" value="guardar" name="accion">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%">&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="125"><a href="ViewDoctosDetenidos.jsp?id_area=<%=strIdArea%>"> <IMG border="0"
				src="../Imagenes/NavLeft.gif" > </a></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="373"></TD>
		</TR>
		<TR valign="top">
			<TD></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="800"><B><FONT face="Verdana" color="#00204f" size="2">
			Detalle de las Instrucciones del Asunto</FONT></B></TD>
			<TD width="100">&nbsp;</TD>
			<TD width="100">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#00204f" colspan="4"><img src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<TABLE>
<TBODY>
	<tr valign="top">
		<td bgcolor="#002060" width="1000">		
			<table border="0" cellspacing="0" cellpadding="0">
				<tr valign="top">
					<td width="968">
						<b><font size="2" color="#FFFFFF" face="Arial">Instrucciones</font></b>
					</td>
					<td width="32">
						<div align="right">
							<i><font size="2" color="#FFFFFF" face="Arial"></font></i>
						</div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<TR>
		<TD bgcolor="#002060" width="1000">
			<table border="1" cellspacing="0" cellpadding="0">
				<tr valign="top">
					<TD bgcolor="#002060" align="center" width="300">
						<b><font size="2" color="#FFFFFF" face="Arial">Nombre Instruccion</font></b>
					</TD>
					<TD bgcolor="#002060" align="center" width="300">
						<b><font size="2" color="#FFFFFF" face="Arial">Responsable</font></b>
					</TD>
					<TD bgcolor="#002060" align="center" width="100">
						<b><font size="2" color="#FFFFFF" face="Arial">Fecha de <br>Vencimiento</font></b>
					</TD>
					<TD bgcolor="#002060" align="center" width="100">
						<b><font size="2" color="#FFFFFF" face="Arial">Días de <br>Atraso</font></b>
					</TD>
					<TD bgcolor="#002060" align="center" width="200">
						<b><font size="2" color="#FFFFFF" face="Arial">Estatus</font></b>
					</TD>
				</tr>
			</table>
		</TD>
	</TR>
</TBODY>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR>
		<TD width="1000">
			<table border="1" cellspacing="0" cellpadding="0">
				<%if(strDetalleInstrucciones != null && strDetalleInstrucciones.length > 0){%>
				<%for(int i=0;i<strDetalleInstrucciones.length;i++){%>
				<tr valign="top">
					<TD align="center" width="300">
						<%if(strDetalleInstrucciones[i][1].length() == 0){%>
						<b><font size="1" face="Arial"><%= strDetalleInstrucciones[i][2] %></font></b>
						<%}else{%>
						<b><font size="1" face="Arial">
						<%=ActualizaInst.getNombreInstruccion1(strDetalleInstrucciones[i][1])%>
						</font></b>
						<%}%>
					</TD>
					<TD align="center" width="300">
						<b><font size="1" face="Arial"><%=strDetalleInstrucciones[i][3]%></font></b>
					</TD>
					<TD align="center" width="100">
						<%if(strDetalleInstrucciones[i][5].length() == 0){%>
						<b><font size="1" face="Arial">-</font></b>
						<%}else{%>
						<b><font size="1" face="Arial"><%=Utilerias.formatearFechas(strDetalleInstrucciones[i][5])%></font></b>
						<%}%>
					</TD>
					<TD align="center" width="100">
					<%
						if(strDetalleInstrucciones[i][5].length() != 0){
							Calendar cFechaIni = Utilerias.StringCalendar(strDetalleInstrucciones[i][5]);
							Calendar cFechaAct = Utilerias.StringCalendar2(strFechaActual);
							int iDiasAtrasado = Utilerias.DiasdeTrabajoEntre1(cFechaIni, cFechaAct);
							int iDiasSinDFest = Utilerias.getSinDiasFestivos(cFechaIni, cFechaAct);
							int iTotal = iDiasAtrasado - iDiasSinDFest;
					%>
						<b><font size="1" face="Arial"><%=iTotal%></font></b>
						<%}else{%>
						<b><font size="1" face="Arial">-</font></b>
						<%}%>
					</TD>
					<TD align="center" width="200">
						<b><font size="1" face="Arial">
						<%if(strDetalleInstrucciones[i][6].equals("0")){%>
						No ha sido Turnada
						<%}else if(strDetalleInstrucciones[i][6].equals("1")){%>
						Esta en Atención
						<%}else if(strDetalleInstrucciones[i][6].equals("2")){%>
						Esta en Tramite
						<%}else if(strDetalleInstrucciones[i][6].equals("3")){%>
						Ha sido Rechazada
						<%}else if(strDetalleInstrucciones[i][6].equals("4")){%>
						Ha sido Terminada
						<%}%>
						</font></b>
					</TD>
				</tr>
				<%}}else{%>
				<tr>
					<TD align="center" colspan="4" width="1000">
						<b><font size="2" face="Arial">*** No tiene Instrucciones Asignadas ***</font></b>
					</TD>
				</tr>
				<%}%>
			</table>
		</TD>
	</TR>
</TBODY>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>
