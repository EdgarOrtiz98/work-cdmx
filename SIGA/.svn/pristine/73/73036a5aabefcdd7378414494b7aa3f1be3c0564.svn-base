<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,com.meve.sigma.util.*"
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
	boolean bMostrar	=	true;
	boolean bExiste		=	true;
	String IdsArea[][]	=	ActualizaAsunto.getIdsAreaPertenece();
	int t = 0;
	bExiste		=	ActualizaAsunto.getExistenAsuntos(BUsuario.getIdArea(), BUsuario.getIdUsuario());
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
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Recepcion por Fecha</TITLE>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="recepcionFecha" action="RecepcionFecha.jsp" method="post">
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='20%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Folio</font></TD>
		<TD WIDTH='30%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Asunto</font></TD>
		<TD WIDTH='30%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Solicitante</font></TD>
		<TD WIDTH='20%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">Estatus</font></TD>
	</TR>
</TABLE>
<br>
<DIV class=documentBody id=Body>
<table>
	<% if(bExiste){ %>
	<% 
		for(int i=0;i<IdsArea.length;i++){
			if(BUsuario.getIdArea().equals(IdsArea[i][0])){
			
	%>
	<meve_front:ListaDatos datos="<%= ActualizaAsunto.AsuntosPorFecha() %>" campo="campo">
		<table border="0" cellpadding="2" cellspacing="0">
			<tr valign="top">
				<td colspan="2">
				<a>
					<img src="../Imagenes/<%=(bMostrar)?"collapse.gif":"expand.gif"%>"
					border="0" height="16" width="16"><%=Utilerias.formatearFechas(campo1)%>
				</a>
				</td>
				<td width="368"></td>
			</tr>
			<%if(bMostrar)
	  		{ 
			%>
			<meve_front:ListaDatos
				datos="<%= ActualizaAsunto.getFechaAsunto(campo1) %>" campo="usuario">
			<% t++; %>
				<tr valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
					<td width="2%"></td>
					<td align="center" width="18%"><font size="1" color="#000080" face="Arial">
						<A href="AsuntoTurnado.jsp?id_asunto=<%= usuario1 %>"><%= usuario2 %></A></font>
					</td>
					<td align="center" width="30%"><font size="1" color="#000080" face="Arial"> <%= usuario3 %>
					</font></td>
					<td align="center" width="30%">
					<font size="1" color="#000080" face="Arial">
						<% if(usuario6.equals("1")){ %>
						<%= ActualizaUsuario.NombreUsuario(usuario4) %>
						<% }else{ %>
						<%= ActualizaRemitente.getNombreRemitente(usuario4) %>
						<% } %>
					</font></td>
					<td align="center" width="20%">
						<IMG border="0" src="../Imagenes/gris5.gif" width="11" height="11">
					</td>
				</tr>
			</meve_front:ListaDatos>
			<% 
	  }
	%>
		</table>
	</meve_front:ListaDatos>
	<% 
			}
			if(BUsuario.getIdRol().equals("0"))
				break;
		}
		}else{ 
	%>
	<TR>
		<TD width="20%">
			<div align=center>
			<FONT face="verdana" size="4">******No Existen Asuntos******</FONT>
			</div>
		</TD>
	</TR>
	<% } %>
</table>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>
