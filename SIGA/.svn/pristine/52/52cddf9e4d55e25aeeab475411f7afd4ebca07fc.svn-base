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
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}	

%>
<%
	boolean bMostrar	=	false;
	boolean bExiste		=	false;
	//String IdsArea[][]	=	ActualizaAsunto.getIdsAreaPertenece();
	int t = 0;
	int j = 0;
	bExiste		=	ActualizaTipoRespuesta.existenTipoRespuesta();
	String strAccion = request.getParameter("accion");
	String strIdUsuario = (request.getParameter("idUs")!=null)?request.getParameter("idUs"):"";
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
<LINK href="../css/calendar.css" rel="stylesheet"
	type="text/css">
<TITLE>Tipo de Respuesta</TITLE>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script language="JavaScript" type="text/javascript">
function desplegar(id){
	doc = document.portalTRES;
	doc.accion.value="reload";
	doc.idUs.value=id;
	doc.submit();
}
</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="portalTRES" action="PortalTipoRespuesta.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="" name="idUs">
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
		<td class="dominoSelTopTab" bgcolor="#004080"><a onclick="goTipoRespuesta()";>Solicitudes Respondidas</a></td>
		<!-- <td class="dominoTopTab"><a onclick="goTipoRespuestaSin()";>Solicitudes Sin Notificar</a></td>-->
	</tr>
</TBODY>
</table>
<br>
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='30%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="Arial">Asunto</font>
		</TD>
		<TD WIDTH='20%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="Arial">Folio</font>
		</TD>
		<TD WIDTH='20%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="Arial">Estatus</font>
		</TD>
		<TD WIDTH='15%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="Arial">Respuesta</font>
		</TD>
		<TD WIDTH='15%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="Arial">Fecha ultima respuesta</font>
		</TD>
	</TR>	
</TABLE>


<DIV class=documentBody id=Body>
<div id="view">
<table width="100%" border="0" cellpadding="2" cellspacing="0">
<TBODY>
	<% if(bExiste){ %>
	<meve_front:ListaDatos datos="<%= ActualizaTipoRespuesta.getTiposRespuestaPortal() %>" campo="campo">
	<%
		String area = ActualizaUsuario.getIdUsrArea(BUsuario.getIdUsuario());
		if(BUsuario.getAdmon() || BUsuario.getIdArea().equals(area)){
		bMostrar = strIdUsuario.equals(campo1);
	%>
		<table border="0" cellpadding="2" cellspacing="0">
		<TBODY>
			<tr valign="top">
				<td colspan="2">
					<a onClick="desplegar(<%=campo1%>)">
					<img src="../Imagenes/<%=(bMostrar)?"collapse.gif":"expand.gif"%>" 
						border="0" height="16" width="16">
						<%= campo2 %>
					</a>
				</td>
			</tr>
			<% j++; %>
			<%if(ActualizaCiudadano.getExisteRespuestas(campo1)){ %>
			<meve_front:ListaDatos datos="<%= ActualizaCiudadano.getAsuntosPorTipoRespuesta(campo1) %>" campo="usuario">
			<% t++; %>
			<tr valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
				<td width="2%"></td>
				<td align="left" width="28%">
					<font size="1" color="#000080" face="Arial">
						
						<A href="AsuntoTurnado.jsp?id_asunto=<%= usuario1 %>&retURI=<%=strTmp %>">
							<%= usuario2 %>						
						</A>
						
					</font>
				</td>
				<td align="center" width="20%">
					<font size="1" color="#000080" face="Arial">
						<%= usuario3 %>
					</font>
				</td>
				<td align="center" width="20%">
					<font size="1" color="#000080" face="Arial">
						<%= ActualizaEstatus.getNombreEstatus(usuario4)[0][0] %>
					</font>
				</td>
				<td align="center" width="15%">
					<font size="1" color="#000080" face="Arial">
						<% if(ActualizaCiudadano.getTieneContestacion(usuario1)){ %>
						Tiene Respuesta
						<% }else{ %>
						No tiene Respuesta
						<% } %>
					</font>
				</td>
				<td align="center" width="15%">
					<font size="1" color="#000080" face="Arial">
						<% if(ActualizaCiudadano.getTieneContestacion(usuario1)){ %>
						<%= ActualizaCiudadano.getUltimaRespuestaCiudadano(usuario1) %>
						<% }else{ %>
						No ha respondido
						<% } %>
					</font>
				</td>
			</tr>
			</meve_front:ListaDatos>
			<% } %>
		</TBODY>
		</table>
	<% } %>
	</meve_front:ListaDatos>
	<% if(j == 0){ %>
	<TR>
		<TD width="100%">
			<div align=center>
				<FONT face="verdana" size="4">******No Hay Solicitudes Respondidas en tu Unidad Administrativa******</FONT>
			</div>
		</TD>
	</TR>
	<% } %>
	<% } else { %>
	<TR>
		<TD width="100%">
			<div align=center>
				<FONT face="verdana" size="4">******No Hay Solicitudes Respondidas******</FONT>
			</div>
		</TD>
	</TR>
	<% } %>
</TBODY>	
</table>
</div>
<BR>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
<BR>
</FORM>
</BODY>
</HTML>
