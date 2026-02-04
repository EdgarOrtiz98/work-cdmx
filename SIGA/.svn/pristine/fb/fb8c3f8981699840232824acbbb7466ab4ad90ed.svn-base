<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_front" prefix="meve_front"%>
<html>
<head>
<TITLE>Busqueda de Asunto</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,com.meve.sigma.beans.search.*"
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
	String strBusqueda 	= 	"";
	String strAccion	=	"";
	String strPP		=	"";
	boolean bExiste		= 	false;
	int t 				= 	0;
	String strResult[][]=	null;
	bExiste	= ActualizaAsunto.getExistenAsuntos(BUsuario.getIdArea(), BUsuario.getIdUsuario());

  	strAccion = request.getParameter("accion");

	if(strAccion != null && strAccion.equals("buscar")){
		strBusqueda = 	request.getParameter("buscarAsunto");
		strPP		=	request.getParameter("PP");
		strResult = ActualizaBuscar.busquedaAsunto(strBusqueda, strPP);
	}
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
<link rel="stylesheet" href="../css/menu.css" type="text/css">
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</head>
<body background="../Imagenes/fondo_claro.jpg"
onclick="opener.timer_cancel()"
onkeypress="opener.timer_cancel()">

<input type="hidden" name="__Click" value="0">
<INPUT type="hidden" name="accion" value="buscar">

<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='25%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Asunto</font></TD>
		<TD WIDTH='25%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Folio</font></TD>
		<TD WIDTH='25%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Avance (%)</font></TD>
		<TD WIDTH='25%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Estatus</font></TD>
	</TR>
</TABLE>
<div id="msg"></div>
<br>
<DIV class=documentBody id=Body>
<div id="view">
<table width="100%" border="0" cellpadding="2" cellspacing="0">
	<TBODY>
		<% if(strBusqueda != null && strBusqueda.length() > 0){ %>
		<meve_front:ListaDatos datos="<%= strResult %>" campo="campo">
		<TR valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
		<% t++; %>
			<TD width="25%">
				<img src="../Imagenes/ecblank.gif" border="0" height="1" width="16" title="">
				<FONT SIZE=2 <%if(campo7.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo7 %>"<%}%>
					FACE="Verdana"> <A href="AsuntoTurnado.jsp?id_asunto=<%= campo1 %>"> <%= campo2 %></A>
				</Font>
			</TD>
			<TD width="25%" align="center">
				<font size="1" <%if(campo7.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo7 %>"<%}%> face="Arial"><%=campo4 %></font>
			</TD>
			<TD width="25%" align="center">
				<font size="1" <%if(campo7.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo7 %>"<%}%> face="Arial"><%=campo5 %></font>
			</TD>
			<TD width="25%" align="center">
				<IMG SRC='../Imagenes/gris5.gif' BORDER=0 ALT=''>
			</TD>
		</TR>
		</meve_front:ListaDatos>	
		<TR>
		<% }else{ %>
			<TD align="center">
				<FONT face="Arial" size="4">** Debe de capturar un criterio de Busqueda **</FONT>
			</TD>
		</TR>
		<% } %>
	</TBODY>
</table>
</div>
<br>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</body>
</html>
