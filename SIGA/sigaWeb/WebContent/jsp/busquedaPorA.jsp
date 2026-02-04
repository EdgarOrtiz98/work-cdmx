<jsp:useBean id="BPorAsunto" class="com.meve.sigma.beans.BeanPorAsunto"
	scope="page">
	<jsp:setProperty name="BPorAsunto" property="*" />
</jsp:useBean>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.search.*,com.meve.sigma.actualiza.*,com.meve.sigma.util.*"
%>
<%
	String strResultado[][] = ActualizaBuscar.buscarPorAsunto(BPorAsunto.getBuscarRecepcion(), 
								BPorAsunto.getBuscarArea(), BPorAsunto.getBuscarAsunto(), 
								BPorAsunto.getBuscarTDocto(), BPorAsunto.getBuscarFechaGen(), 
								BPorAsunto.getBuscarFechaVen());
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<TITLE>Busqueda por Asunto</TITLE>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%">&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<TBODY>
		<TR>
			<TD width="283"><INPUT type="button" class="blue200"
				value="Realizar Otra Busqueda"
				onclick="location.assign('busquedaPorAsunto.jsp');"></TD>
			<td width="133"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</TR>
	</TBODY>
</table>
</DIV>
<br>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<TBODY>
		<TR>
			<TD width="283"><b><FONT size="2" color="#004080" face="Arial">
			Resultados encontrados en SigmaDoc </FONT></b></TD>
			<td width="133"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</TR>
		<TR>
			<td width="863" bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</TR>
	</TBODY>
</table>
</DIV>
<br>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
<TBODY>
	<TR>
		<TD width="283"><b><FONT size="2" color="#004080" face="Arial">
			Numero de Resultados: <%=strResultado.length%></FONT></b></TD>
		<td width="133"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
</TBODY>
</table>
</DIV>
<br>
<DIV align="center">
<table border="0" width="863">
<TBODY>
	<TR bgcolor="#00204f">
		<TD width="172">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">Folio</FONT></b>
			</CENTER>
		</TD>
		<td width="172">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">Solicitante</FONT></b>
			</CENTER>
		</td>
		<td width="173">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">Destinatario</FONT></b>
			</CENTER>
		</td>
		<td width="173">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">Titulo</FONT></b>
			</CENTER>
		</td>
		<td width="173">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">Fecha Recepción</FONT></b>
			</CENTER>
		</td>
	</TR>
</TBODY>
</table>
</DIV>
<br>
<% if(strResultado.length == 0){ %>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
<TBODY>
	<TR>
		<TD width="383"><b><FONT size="2" color="red" face="Arial">
			No se encontraron Documentos</FONT></b></TD>
		<td width="33"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
</TBODY>
</table>
</DIV>
<% }else{ %>
<DIV class=documentBody id=Body>
<DIV align="center">
<table border="0" width="863">
<TBODY>
	<% for(int i=0;i<strResultado.length;i++){ %>
	<TR>
		<TD width="172">
			<CENTER>
				<FONT size="1" color="#000080" face="Arial">
				<a href="AsuntoTurnado.jsp?id_asunto=<%=strResultado[i][4]%>">
				<%=strResultado[i][0]%>
				</a>
				</FONT>
			</CENTER>
		</TD>
		<td width="172">
			<CENTER>
				<% if(strResultado[i][5].equals("0")){ %>
				<FONT size="1" color="#000080" face="Arial">
				<%=ActualizaRemitente.getNombreRemitente(strResultado[i][1])%>
				</FONT>
				<% }else if(strResultado[i][5].equals("1")){ %>
				<FONT size="1" color="#000080" face="Arial">
				<%=ActualizaUsuario.NombreUsuario(strResultado[i][1])%>
				</FONT>
				<% } %>
			</CENTER>
		</td>
		<td width="173">
			<CENTER>
				<FONT size="1" color="#000080" face="Arial">
				<%=ActualizaUsuario.NombreUsuario(strResultado[i][6])%>
				</FONT>
			</CENTER>
		</td>
		<td width="173">
			<CENTER>
				<FONT size="1" color="#000080" face="Arial"><%=strResultado[i][2]%></FONT>
			</CENTER>
		</td>
		<td width="173">
			<CENTER>
				<FONT size="1" color="#000080" face="Arial">
				<%=Utilerias.formatearFechas(strResultado[i][3])%>
				</FONT>
			</CENTER>
		</td>
	</TR>
	<% } %>
</TBODY>
</table>
</DIV>
</DIV>
<BR>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
<% } %>
</BODY>
</HTML>
