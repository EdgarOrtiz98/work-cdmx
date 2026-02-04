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
	bExistenRem = ActualizaReportes.getExistenRem(BUsuario.getIdArea());
	String strIds_Borrar[]	=	null;
	String strAccion		=	"";
	strAccion				=	request.getParameter("accion");
	strIds_Borrar			=	request.getParameterValues("Borrar");
	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar"))
	{
		boolean bOperacion	=	ActualizaReportes.deleteReportes(strIds_Borrar);
	}

	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");

	int regPorPagina = 20;
	int muestraPaginas = 20;
	String[][] strConfig = com.meve.sigma.actualiza.ActualizaConfiguracion.getDatosConf();
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
<% if (	BUsuario.getRecepcion() && 
		!(BUsuario.getAdmon() || BUsuario.getSupervisor() || BUsuario.getAtencion() || BUsuario.getTurnado() || BUsuario.getAsistente())){ %>
	<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>Asuntos por Remitentes Externos</TITLE>
<SCRIPT language="JavaScript" src="../js/GeneralFunctions.js"></SCRIPT>
<script type="text/javascript">
<!--
	function cambio(o, t){
		doc = document.viewRem;
		doc.accion.value="reload";
		doc.orden.value=o;
		doc.tipo.value=t;
		doc.submit();
	}
	function pagina(contador){
		doc = document.viewRem;
		doc.contPag.value=contador;
		doc.submit();
	}
	function paginaLiga(contador){
		doc = document.viewRem;
		doc.contligas.value=contador;
		doc.submit();
	}
//-->
</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="viewRem" action="ViewRemitente.jsp" method="post">
<INPUT type="hidden" name="accion" value="">
<INPUT type="hidden" name="orden" value="<%=strOrden %>">
<INPUT type="hidden" name="tipo" value="<%=strTipo %>">
<INPUT type="hidden" value="<%=contPag %>" name="contPag">
<INPUT type="hidden" value="<%=contligas %>" name="contligas">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%">&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr valign="top">
	<td width="43%">
		<%if(BUsuario.getSupervisor()){%>
		<a href="ReporteRemitente.jsp" title="Genera Reporte">
			<img src="../Imagenes/nuevo1.gif" border="0" title="Generar Reporte">
		</a>
		<A href="javascript:Borrar()" target="_self">
			<IMG border="0" src="../Imagenes/borrar1.gif">
		</A>
		<%}%>
		<font size="2" face="Tahoma"></font>
	</td>
	<td width="57%" align="right">
	<font face="verdana" size="4">Asuntos por Remitentes Externos</font>
	</td>
</tr>
</table>
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='15%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">
			<a onclick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			No. de Reporte
			<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font></TD>
		<TD WIDTH='60%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">
			<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Reporte
			<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font></TD>
		<TD WIDTH='25%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">
			<a onclick="cambio('asc', 4)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Fecha de Creación
			<a onclick="cambio('desc', 4)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font></TD>
	</TR>
</TABLE>
<br>
<TABLE WIDTH='100%' BORDER=0>
	<TBODY>
	<% if(bExistenRem){ %> 
	<TR>
		<TD align="left" colspan="2">
		<%	numRegistros = ActualizaReportes.getReportesPorRemitente(BUsuario.getIdArea(),strOrden,strTipo).length;
			if (numRegistros>0){ %>
			<!-- &nbsp;&nbsp;&nbsp;&nbsp;
			<A href="../ReporteAsuntoExcel?tip=porturnar_01">
			<img src="../Imagenes/button_xls.gif" border="0" height="16" width="16">
			<FONT face="Arial" size="2">Exportar a Excel</FONT>
			</A> -->
		<%	} %>
		</TD>
		<TD align="right" colspan="3">
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
	<%	String[][] sql = ActualizaReportes.getReportesPorRemitente(BUsuario.getIdArea(),strOrden,strTipo);
		for (int ix=contPag*regPorPagina; ix<sql.length && ix<(contPag+1)*regPorPagina; ix++){
			String campo1 = sql[ix][0];
			String campo2 = sql[ix][1];
			String campo3 = sql[ix][2];
	%>
	<TR <%if(par(ix+1)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
		<TD WIDTH='15%' align="center">
			<FONT SIZE=2 COLOR="000000" FACE="Arial">
			<%if(BUsuario.getSupervisor()){%>
			<INPUT type=checkbox value="<%=campo1%>" name="Borrar">
			<%}%>
			<A href="ReporteRemitente.jsp?id_rep=<%=campo1%>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas)%>">
				<%=campo1%>
			</A>
			</font>
		</TD>
		<TD WIDTH='60%' align="center"><FONT SIZE=2 COLOR="000000"
			FACE="Arial"><%=campo2%></font></TD>
		<TD WIDTH='25%' align="center"><FONT SIZE=2 COLOR="000000"
			FACE="Arial"><%=campo3%></font></TD>
	</TR>
	<% 	} %>
	<TR>
	<TD colspan="5" align="center"><BR>
		<%
		if (contligas>0 && numPaginas > muestraPaginas){  %>
			<A onclick="paginaLiga(<%= (contligas-muestraPaginas<0)?0:contligas-muestraPaginas %>);pagina(<%= (contligas-muestraPaginas<0)?0:contligas-muestraPaginas %>);"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;
		<%	}
		if (contPag > 0){  
			if (contPag > contligas){%>
			<A onclick="paginaLiga(<%=contligas%>);pagina(<%=contPag-1%>);"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;
		<%	}else{%>
			<A onclick="paginaLiga(<%=contligas-1%>);pagina(<%=contPag-1%>);"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;
		<%	} 
		}
		if (numPaginas > 1){
			for (int ik=contligas; ik<muestraPaginas+contligas && ik<numPaginas; ik++){ 
				if (ik==contPag){  %>
					<A onclick="pagina(<%=ik%>)"><FONT color="red"><B>[<%=ik+1%>]</B></FONT></A> &nbsp;
		<%		}else{ %>
					<A onclick="pagina(<%=ik%>)"><%=ik+1%></A> &nbsp;
		<%		}
			}
		} 
		if (contPag < numPaginas-1){  
			if (contPag < contligas + muestraPaginas-1){%>
				<A onclick="paginaLiga(<%=contligas%>);pagina(<%=contPag+1%>);"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;
		<%	}else{%>
			<A onclick="paginaLiga(<%=contligas+1%>);pagina(<%=contPag+1%>);"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;
		<%	} 
		}
		if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){  %>
			<A onclick="paginaLiga(<%= numPaginas-muestraPaginas %>);pagina(<%= numPaginas-1 %>);"> <B>FINAL</B> </A>
		<%	
		} %>
	</TD>
	</TR>
	<% }else{ %>
	<TR>
		<TD align="center">
		<FONT face="verdana" size="4">
		***** No existen reportes generados *****
		</FONT></TD>
	</TR>
	<% } %>
	</TBODY>
</TABLE>

</FORM>
</BODY>
</HTML>
