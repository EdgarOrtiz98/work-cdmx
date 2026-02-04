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
	int t = 0;
	bExiste		=	ActualizaAsunto.getExistenAsuntos(BUsuario.getIdArea(), BUsuario.getIdUsuario());

	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"2";

	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");

	int regPorPagina = 20;
	int muestraPaginas = 20;
	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
	if(strConfig != null && strConfig.length > 0){
		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
	}	

	String[][] strDatos = ActualizaAsunto.AsuntosPorFolio(BUsuario.getIdArea(),strOrden,strTipo);
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
<% if (	BUsuario.getRecepcion() && 
		!(BUsuario.getAdmon() || BUsuario.getSupervisor() || BUsuario.getAtencion() || BUsuario.getTurnado() || BUsuario.getAsistente())){ %>
	<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Ordenados por Folios</TITLE>
<script language="JavaScript" type="text/javascript">
	function cambio(o, t){
		doc = document.recepcionFolio;
		doc.orden.value=o;
		doc.tipo.value=t;
		doc.submit();
	}

	function pagina(contador){
		doc = document.recepcionFolio;
		doc.contPag.value=contador;
		doc.submit();
	}

	function paginaLiga(contador){
		doc = document.recepcionFolio;
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
<FORM name="recepcionFolio" action="RecepcionFolio.jsp" method="post">
<INPUT type="hidden" name="orden" value="<%=strOrden %>">
<INPUT type="hidden" name="tipo" value="<%=strTipo %>">
<INPUT type="hidden" value="<%=contPag %>" name="contPag">
<INPUT type="hidden" value="<%=contligas %>" name="contligas">
<table cellspacing="2" cellpadding="2" width="100%">
<TBODY>
	<TR>
		<TD class="etiquetas" width="30%">
			<b><FONT size="3">En recepción, Ordenados por Folios</FONT></b>
		</TD>
		<TD class="etiquetas" align="center" width="40%">
		</TD>
		<TD class="etiquetas" align="center" width="30%">
			&nbsp;
		</TD>
	</TR>
</TBODY>
</table>
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='20%' align="center">
			<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Folio</font>
			<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
		</TD>
		<TD WIDTH='30%' align="center">
			<a onclick="cambio('asc', 4)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Solicitante</font>
			<a onclick="cambio('desc', 4)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
		</TD>
		<TD WIDTH='30%' align="center">
			<a onclick="cambio('asc', 3)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Título</font>
			<a onclick="cambio('desc', 3)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
		</TD>
		<TD WIDTH='20%' align="center">
			<a onclick="cambio('asc', 6)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Fecha por Captura</font>
			<a onclick="cambio('desc', 6)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
		</TD>
	</TR>
</TABLE>
<br>
<table>
	<% if(bExiste){ %>
		<TR>
			<TD align="left">
				&nbsp;&nbsp;&nbsp;&nbsp;
				<A href="../ReporteAsuntoExcel?tip=recepcion_folio">
				<img src="../Imagenes/button_xls.gif" border="0" height="16" width="16">
				<FONT face="Arial" size="2">Exportar a Excel</FONT>
				</A>
			</TD>
			<TD align="right" colspan="4">
			<%	int numeroPaginas = strDatos.length/regPorPagina;	
				if (strDatos.length%regPorPagina != 0)
					numeroPaginas++;
				if (strDatos.length == 1){ %>
					<%= strDatos.length %> registro mostrado
			<%	}
				if (strDatos.length > 1){ %>
					<%= strDatos.length %> registros mostrados
			<%	}
				if (numeroPaginas > 1){ %>
					, &nbsp;Pagina <%= contPag+1 %> de <%= numeroPaginas %>
			<%	} %>
				&nbsp;&nbsp;&nbsp;&nbsp;
			</TD>
		</TR>
	<% 	
			numeroPaginas = strDatos.length/regPorPagina;	
			if (strDatos.length%regPorPagina != 0)
				numeroPaginas++;	

			for (int i=contPag*regPorPagina; i<strDatos.length && i<(contPag+1)*regPorPagina; i++){
				String usuario1 = strDatos[i][0];
				String usuario2 = strDatos[i][1];
				String usuario3 = strDatos[i][2];
				String usuario4 = strDatos[i][3];
				String usuario5 = strDatos[i][4];
				String usuario6 = strDatos[i][5];
				String usuario7 = strDatos[i][6];
				String usuario8 = strDatos[i][7];
		%>
		<% t++; %>
		<tr valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
			<td align="center" width="20%">
				<font size="1" color="#000080" face="Arial">
					<A href="AsuntoTurnado.jsp?id_asunto=<%= usuario1 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) %>">
					<%= usuario2 %></A>
				</font>
			</td>
			<td align="center" width="364">
				<font size="1" color="#000080" face="Arial">
					<% if(usuario8.equals("1")){ %>
					<%= ActualizaUsuario.NombreUsuario(usuario4) %>
					<% }else{ %>
					<%= ActualizaRemitente.getNombreRemitente(usuario4) %>
					<% } %>
				</font>
			</td>
			<td align="center" width="367"><font size="1" color="#000080"
				face="Arial"> <%= usuario3 %> </font></td>
			<td align="center" width="239"><font size="1" color="#000080"
				face="Arial"> <%=Utilerias.formatearFechas(usuario6)%> </font></td>
		</tr>
	<% 		} 	%>
		<TR>
			<TD colspan="4" align="center"><BR>
			<%
				if (contligas>0 && numeroPaginas > muestraPaginas){  %>
					<A onclick="paginaLiga(<%= (contligas-muestraPaginas<0)?0:contligas-muestraPaginas %>);pagina(<%= (contligas-muestraPaginas<0)?0:contligas-muestraPaginas %>);"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;
			<%	}
				if (contPag > 0){  
					if (contPag > contligas){%>
						<A onclick="paginaLiga(<%=contligas%>);pagina(<%=contPag-1%>);"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;
				<%	}else{%>
						<A onclick="paginaLiga(<%=contligas-1%>);pagina(<%=contPag-1%>);"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;
				<%	} 
				}
				if (numeroPaginas > 1){
					for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
						if (i==contPag){  %>
							<A onclick="pagina(<%=i%>)"><FONT color="red"><B>[<%=i+1%>]</B></FONT></A> &nbsp;
				<%		}else{ %>
							<A onclick="pagina(<%=i%>)"><%=i+1%></A> &nbsp;
				<%		}
					}
				} 
				if (contPag < numeroPaginas-1){  
					if (contPag < contligas + muestraPaginas-1){%>
						<A onclick="paginaLiga(<%=contligas%>);pagina(<%=contPag+1%>);"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;
				<%	}else{%>
						<A onclick="paginaLiga(<%=contligas+1%>);pagina(<%=contPag+1%>);"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;
				<%	} 
				}
				if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  %>
					<A onclick="paginaLiga(<%= contligas+muestraPaginas %>);pagina(<%= contligas+muestraPaginas %>);"> <B> | Siguiente&gt;&gt;</B> </A>
			<%	
				} %>
			</TD>
		</TR>

	<% }else{ %>
	<TR>
		<TD width="20%">
			<div align=center>
				<FONT face="verdana" size="4">******No Existen Asuntos******</FONT>
			</div>
		</TD>
	</TR>
	<% } %>
</table>
</FORM>

</BODY>
</HTML>
