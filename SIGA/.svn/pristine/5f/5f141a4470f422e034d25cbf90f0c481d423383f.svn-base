<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

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
	int t = 0;
	int j = 0;
	bExiste		=	ActualizaAsunto.getExistenAsuntos(BUsuario.getIdArea(), BUsuario.getIdUsuario());//ActualizaTipoRespuesta.existenTipoRespuesta();

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
<LINK href="../css/calendar.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Asuntos sin Notificación</TITLE>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script language="JavaScript" type="text/javascript">
<!-- 
document._domino_target = "_self";
function _doClick(v, o, t, h) {
  var form = document.portalTSNOT;
  if (form.onsubmit) {
     var retVal = form.onsubmit();
     if (typeof retVal == "boolean" && retVal == false)
       return false;
  }
  var target = document._domino_target;
  if (o.href != null) {
    if (o.target != null)
       target = o.target;
  } else {
    if (t != null)
      target = t;
  }
  form.target = target;
  form.__Click.value = v;
  if (h != null)
    form.action += h;
  form.submit();
  return false;
}
// -->
</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="PortalSinNotificacion.jsp" method="post" name="portalTSNOT">
<input type="hidden" name="__Click" value="0">
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
		<td class="dominoTopTab"><a onclick="goHoy()";>Hoy</a></td>
		<td class="dominoSelTopTab" bgcolor="#004080"><a onclick="goTipoRespuesta()";>Solicitudes Respondidas</a></td>
		<td class="dominoTopTab"><a onclick="goTipoRespuestaSin()";>Solicitudes Sin Notificar</a></td>
	</tr>
</TBODY>
</table>
<br>
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='40%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="Arial">Asunto</font>
		</TD>
		<TD WIDTH='40%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="Arial">Folio</font>
		</TD>
		<TD WIDTH='10%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="Arial">Estatus</font>
		</TD>
		<TD WIDTH='10%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="Arial">Respuesta</font>
		</TD>
	</TR>	
</TABLE>
<DIV class=documentBody id=Body>
<table width="100%" border="0" cellpadding="2" cellspacing="0">
<TBODY>
	<% 
		if(bExiste){
			String strDatosNotificados[][] = ActualizaCiudadano.getAsuntosNotificados(); 
	%>
	
		<meve_front:ListaDatos datos="<%= ActualizaTipoRespuesta.getTiposRespuestaPortal() %>" campo="campo">
		<%
			String area = ActualizaUsuario.getIdUsrArea(BUsuario.getIdUsuario());
			if(BUsuario.getIdArea().equals(area)){
		%>
			<TR>
				<td align="center" width="40%">
					<font size="1" color="#000080" face="Arial">
						
					</font>
				</td>
				<td align="center" width="40%">
					<font size="1" color="#000080" face="Arial">
						
					</font>
				</td>
				<td align="center" width="10%">
					<font size="1" color="#000080" face="Arial">
						
					</font>
				</td>
				<td align="center" width="10%">
					<font size="1" color="#000080" face="Arial">
						
					</font>
				</td>
			</TR>
		<% } %>
		</meve_front:ListaDatos>
		<% if(j == 0){ %>
		<TR>
			<TD width="100%">
				<div align=center>
					<FONT face="verdana" size="4">******No Hay Solicitudes Sin Notificar en tu Unidad Administrativa******</FONT>
				</div>
			</TD>
		</TR>
		<% } %>
	<% } else { %>
	<TR>
		<TD width="100%">
			<div align=center>
				<FONT face="verdana" size="4">******No Hay Solicitudes Sin Notificar******</FONT>
			</div>
		</TD>
	</TR>
	<% } %>
</TBODY>	
</table>
<BR>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
<BR>
</FORM>
</BODY>
</HTML>
