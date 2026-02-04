<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_front" prefix="meve_front"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,com.meve.sigma.reportes.*,com.meve.sigma.util.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null)
	try{
		response.sendRedirect("index.jsp?pagina="+ strTmp);
	}catch(java.io.IOException io){;}

	boolean bExiste	= false;
	boolean bMostrar = false;
	int t = 0;
	bExiste = ActualizaAsunto.getExistenAsuntosSolicitadas(BUsuario.getIdUsuario(), BUsuario.getIdArea());
	String strAccion = request.getParameter("accion");
	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";

	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");
	int regPorPagina = 20;
	int muestraPaginas = 20;
	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
	if(strConfig != null && strConfig.length > 0){
		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
	}
	int numRegistros = 0;
	int numPaginas = 0;
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
<link rel="stylesheet" href="../css/menu.css" type="text/css">
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<TITLE>Asuntos Solicitados</TITLE>
<script language="JavaScript" type="text/javascript">
	function cambio(o, t){
		doc = document.pSolicitados;
		doc.orden.value=o;
		doc.tipo.value=t;
		doc.submit();
	}
function pagina(contador){
	doc = document.pSolicitados;
	doc.contPag.value=contador;
	doc.submit();
}

function paginaLiga(contador){
	doc = document.pSolicitados;
	doc.contligas.value=contador;
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
<form method="post" action="portalAsuntosSolicitados.jsp" name="pSolicitados">
<INPUT type="hidden" name="accion" value="">
<INPUT type="hidden" name="orden" value="<%= strOrden %>">
<INPUT type="hidden" name="tipo" value="<%= strTipo %>">
<INPUT type="hidden" value="<%= contPag %>" name="contPag">
<INPUT type="hidden" value="<%= contligas %>" name="contligas">
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
		<%if(BUsuario.getTurnado() || BUsuario.getRecepcion()){%>
                    <td class="dominoTopTab"><a onclick="goAtencion()";>Asuntos en Recepción</a></td>
                <%}%>
                <%if(BUsuario.getTurnado()){%>
                    <td class="dominoTopTab"><a onclick="goAsuntos()";>Asuntos por turnar</a></td>
                    <td class="dominoTopTab"><a onclick="goAsuntosTr()";>Asuntos en trámite</a></td>
                    <td class="dominoTopTab"><a onclick="goAsuntosTer()";>Asuntos terminados</a></td>
		<%}%>
                <%if(BUsuario.getAtencion()||BUsuario.getAsistente()){%>
                    <td class="dominoTopTab"><a onclick="goAtender()";>Instrucciones por atender</a></td>
                    <td class="dominoTopTab"><a onclick="goTramite()";>Instrucciones en trámite</a></td>
                    <td class="dominoTopTab"><a onclick="goTerminadas()";>Instrucciones terminadas</a></td>
                <%}%>
                <%if(BUsuario.getAtencion()||BUsuario.getRecepcion()||BUsuario.getSupervisor()||BUsuario.getTurnado()||BUsuario.getAsistente()){%>
                    <td class="dominoTopTab" ><a onclick="goRechazadas()";>Instrucciones rechazadas</a></td>
		<%}%>
                <%if(BUsuario.getAtencion()||BUsuario.getAsistente()){%>
                    <td class="dominoSelTopTab" bgcolor="#004080"><a onclick="goSolicitada()";>Asuntos Solicitados</a></td>
                <%}%>
	</tr>
	</TBODY>
</table>
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='30%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">
			<a onClick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Asunto
			<a onClick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font></TD>

		<TD WIDTH='15%' align="center">
			<a onClick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">Folio</font>
			<a onClick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
		</TD>
		<TD WIDTH='20%' align="center">
			<a onClick="cambio('asc', 3)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">Identificador del Docto.</font>
			<a onClick="cambio('desc', 3)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
		</TD>
		<TD WIDTH='10%' align="center">
			<a onClick="cambio('asc', 4)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">Avance(%)</font>
			<a onClick="cambio('desc', 4)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
		</TD>
		<TD WIDTH='15%' align="center">
			<a onClick="cambio('asc', 5)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">Atendido Por</font>
			<a onClick="cambio('desc', 5)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
		</TD>
		<TD WIDTH='10%' align="center"><FONT SIZE=1 COLOR="FFFFFF"
			FACE="verdana">Estatus</font></TD>
	</TR>
</TABLE>
<DIV class=documentBody id=Body>
<div id="view">
<TABLE width="100%" border="0">
<TBODY>
	<TR>
		<TD align="left">
		<%	numRegistros = ActualizaAsunto.getAsuntosSolicitados(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea()).length;
			if (numRegistros>0){ %>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<A href="../ReporteAsuntoExcel?tip=solicitado_01">
			<img src="../Imagenes/button_xls.gif" border="0" height="16" width="16">
			<FONT face="Arial" size="2">Exportar a Excel</FONT>
			</A>
		<%	} %>
		</TD>
		<TD align="right">
		<%	numPaginas = numRegistros/regPorPagina;	
			if (numRegistros%regPorPagina != 0)
				numPaginas++; %>
		<%	if (numRegistros > 0){	%>
			<%= numRegistros %> registros mostrados.
		<%	} %>
		<%	if (numPaginas > 1){	%>
			Pagina <%= contPag+1 %> de <%= numPaginas %>
		<% 	} %>
			&nbsp;&nbsp;&nbsp;&nbsp;
		</TD>
	</TR>
</TBODY>
</TABLE>
<table width="100%" border="0" cellpadding="2" cellspacing="0">
	<TBODY>
		<%if(bExiste){%>
		<% int j = 0; %>
		<%	String[][] sql = ActualizaAsunto.getAsuntosSolicitados(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea());
			for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
				String campo1 = sql[i][0];
				String campo2 = sql[i][1];
				String campo3 = sql[i][2];
				String campo4 = sql[i][3];
				String campo5 = sql[i][4];
				String campo6 = sql[i][5];
				String campo7 = sql[i][6];
		%>
		<% t++; %>
			<tr valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
				<td width='30%' align="left">
					<FONT SIZE=2 FACE="Arial">&nbsp;&nbsp;
						<A href="AsuntoTurnado.jsp?id_asunto=<%=campo1%>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) %>" 
						title="<%= campo2 %>"> <%= Utilerias.recortaString(campo2,40) %></A>
				</Font></td>
				<td width='15%'>
				<div align=center>
					<font size="1" face="Arial"><%=campo3%></font>
				</div>
				</td>
				<td width='20%'>
				<div align=center>
					<a title="<%=campo5 %>">
					<font size="1" face="Arial"><%=Utilerias.recortaString(campo5,20) %></font>
					</a>
				</div>
				</td>
				<td width='10%'>
				<div align=center>
					<font size="1" face="Arial"><%=campo4 %></font>
				</div>
				</td>
				<td width='15%'>
				<div align=center>
					<a title="<%=campo7 %>">
					<font size="1" face="Arial"><%=Utilerias.recortaString(campo7,20) %></font>
					</a>
				</div>
				</td>
				<td width='10%'>
				<div align=center><IMG SRC='../Imagenes/gris5.gif' BORDER=0 ALT=''></div>
				</td>
			</tr>
			<% j++; %>
		<% } %>
		<% if(j == 0){ %>
		<TR>
			<TD width="100%">
			<div align=center><FONT face="Arial" size="4">******No Tiene Asuntos
			Solicitados******</FONT></div>
			</TD>
		</TR>
		<% } else {%>
		<TR>
		<TD colspan="5" align="center"><BR>
		<%
			int numeroPaginas = (sql!=null)?sql.length/regPorPagina:0;	
			if (sql.length%regPorPagina != 0)
				numeroPaginas++; 
			if (contligas>0 && numeroPaginas > muestraPaginas){  %>
				<A onClick="paginaLiga(<%= (contligas-muestraPaginas<0)?0:contligas-muestraPaginas %>);pagina(<%= (contligas-muestraPaginas<0)?0:contligas-muestraPaginas %>);"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;
		<%	}
			if (contPag > 0){  
				if (contPag > contligas){%>
					<A onClick="paginaLiga(<%=contligas%>);pagina(<%=contPag-1%>);"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;
			<%	}else{%>
					<A onClick="paginaLiga(<%=contligas-1%>);pagina(<%=contPag-1%>);"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;
			<%	} 
			}
			if (numeroPaginas > 1){
				for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
					if (i==contPag){  %>
						<A onClick="pagina(<%=i%>)"><FONT color="red"><B>[<%=i+1%>]</B></FONT></A> &nbsp;
			<%		}else{ %>
						<A onClick="pagina(<%=i%>)"><%=i+1%></A> &nbsp;
			<%		}
				}
			} 
			if (contPag < numeroPaginas-1){  
				if (contPag < contligas + muestraPaginas-1){%>
					<A onClick="paginaLiga(<%=contligas%>);pagina(<%=contPag+1%>);"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;
			<%	}else{%>
					<A onClick="paginaLiga(<%=contligas+1%>);pagina(<%=contPag+1%>);"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;
			<%	} 
			}
			if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  %>
				<A onClick="paginaLiga(<%= contligas+muestraPaginas %>);pagina(<%= contligas+muestraPaginas %>);"> <B> | Siguiente&gt;&gt;</B> </A>
		<%	
			} %>
		</TD>
		</TR>
		<% } %>
		<% } else { %>
		<TR>
			<TD width="100%">
			<div align=center><FONT face="Arial" size="4">******No Tiene Asuntos
			Solicitados******</FONT></div>
			</TD>
		</TR>
		<% } %>
	</TBODY>
</table>
<BR>
</div>
<br>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</form>
</BODY>
</HTML>