<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<TITLE>Asuntos de Hoy</TITLE>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null)
		response.sendRedirect("index.jsp?pagina="+ strTmp);
%>
<%
	boolean bExiste	= false;
	int t = 0;
	int j = 0;
	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	String strFechaCreacion			=	sdf.format(f); 
	bExiste = ActualizaAsunto.getExistenAsuntosHoy(strFechaCreacion);
	String strActivarPortal = application.getInitParameter("ActivarPortal");
%>
<%!
	public static boolean par(int num)
    {
        boolean p = false;
        if (num % 2 == 0) 
        {
            p = true;
        }    
        return p;
    }
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>PortalTramite.jsp</TITLE>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM method="post" action="PortalHoy.jsp" name="pHoy">
<input type="hidden" name="__Click" value="0">
<table cellspacing="2" cellpadding="2">
<TBODY>
	<TR>
		<TD class="etiquetas">
			
		</TD>
	</TR>
</TBODY>
</table>
<table cellspacing="2" cellpadding="2">
<TBODY>
	<tr>
		<td class="dominoTopTab"><a onclick="goAtencion()";>Asuntos en Recepción</a></td>
		<td class="dominoTopTab"><a onclick="goAsuntos()";>Asuntos por turnar</a></td>
		<td class="dominoTopTab"><a onclick="goAsuntosTr()";>Asuntos en trámite</a></td>
		<td class="dominoTopTab"><a onclick="goAsuntosTer()";>Asuntos terminados</a></td>
		<td class="dominoTopTab"><a onclick="goAtender()";>Instrucciones por atender</a></td>
		<td class="dominoTopTab"><a onclick="goTramite()";>Instrucciones en trámite</a></td>
		<td class="dominoTopTab"><a onclick="goTerminadas()";>Instrucciones terminadas</a></td>
		<td class="dominoTopTab"><a onclick="goRechazadas()";>Instrucciones rechazadas</a></td>
		<td class="dominoSelTopTab" bgcolor="#004080"><a onclick="goHoy()";>Hoy</a></td>
		<% if(strActivarPortal.equals("si")){ %>
		<td class="dominoTopTab"><a onclick="goTipoRespuesta()";>Solicitudes Respondidas</a></td>
		<% } %>
		<!-- <td class="dominoTopTab"><a onclick="goTipoRespuestaSin()";>Solicitudes Sin Notificar</a></td>-->
	</tr>
</TBODY>
</table>
<br>
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='75%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Asunto</font></TD>
		<TD WIDTH='25%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Estatus</font></TD>
	</TR>
</TABLE> 
<div id="msg">
</div>

<DIV class=documentBody id=Body>
<table width="100%" border="0" cellpadding="2" cellspacing="0">
<TBODY>
	<% if(bExiste){ %>  
	<meve_front:ListaDatos datos="<%= ActualizaAsunto.getDatosAsuntoHoy(strFechaCreacion) %>" campo="campo">
	<% if(	BUsuario.getIdArea().equals(campo4)){ %>
	<% t++; %>
	<tr valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
		<td width='75%'>
			<img src="../Imagenes/ecblank.gif" border="0" height="1" width="16" title="">
			<FONT SIZE=1 FACE="Verdana">
				<A href="AsuntoTurnado.jsp?id_asunto=<%= campo1 %>&retURI=<%=strTmp %>"><%= campo2 %></A>
			</Font>
		</td>
		<td width='25%' align="center">
			<font size="1" face="Verdana">
				<% if(campo3.equals("1")){ %>
				Atención
				<% }else if(campo3.equals("2")){ %>
				En Tramite
				<% }else if(campo3.equals("3")){ %>
				Terminada
				<% } %>
			</font>				
		</td>
	</tr>
	<% j++; %>
	<% } %>
	</meve_front:ListaDatos>
	<% if(j == 0){ %>
		<TR>
			<% ////System.out.println("j-->"+j); %>
			<TD width="100%">
			<div align=center><FONT face="verdana" size="4">******No Hay Asuntos
			Capturados de su Unidad Administrativa******</FONT></div>
			</TD>
		</TR>
		<% } %>
	<% } else { %>
	<TR>
		<TD width="100%">
			<div align=center>
				<FONT face="verdana" size="4">******No Hay Asuntos generados el día de hoy******</FONT>
			</div>
		</TD>
	</TR>
	<% } %>
</TBODY>	
</table>
</div>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>

