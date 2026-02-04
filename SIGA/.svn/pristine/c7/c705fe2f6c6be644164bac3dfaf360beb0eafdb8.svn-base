<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,com.meve.sigma.util.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){;}
	}	

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
	int numRegistros = 0;
	int numPaginas = 0;
%>
<%
	boolean bMostrar	=	true;
	boolean bExiste		=	true;
	int t = 0;
	bExiste		=	ActualizaAsunto.getExistenAsuntosTramite(BUsuario.getIdArea(), BUsuario.getIdUsuario());
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
<% if (	BUsuario.getRecepcion() && 
		!(BUsuario.getAdmon() || BUsuario.getSupervisor() || BUsuario.getAtencion() || BUsuario.getTurnado() || BUsuario.getAsistente())){ %>
	<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Ordenado por Remitentes Externos</TITLE>
<script language="JavaScript" type="text/javascript">
function desplegar(id){
	doc = document.turnadoSol;
	doc.accion.value="reload";
	if (id==doc.idUs.value){
		doc.idUs.value=0;
		doc.submit();
	}else{
		doc.idUs.value=id;
		doc.contPag.value=0;
		doc.contligas.value=0;
		doc.submit();
	}
}
function cambio(o, t){
	doc = document.turnadoSol;
	doc.accion.value="reload";
	doc.orden.value=o;
	doc.tipo.value=t;
	doc.submit();
}
function pagina(contador){
	doc = document.turnadoSol;
	doc.contPag.value=contador;
	doc.submit();
}
function paginaLiga(contador){
	doc = document.turnadoSol;
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
<FORM name="turnadoSol" action="TurnadoPorSol.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%= strIdUsuario %>" name="idUs">
<INPUT type="hidden" name="orden" value="<%= strOrden %>">
<INPUT type="hidden" name="tipo" value="<%= strTipo %>">
<INPUT type="hidden" value="<%= contPag %>" name="contPag">
<INPUT type="hidden" value="<%= contligas %>" name="contligas">
<TABLE>
	<TBODY>
	<TR>
		<TD align="left" class="etiquetas">
		<FONT size="3"><B>Turnado por Remitentes Externos</B></FONT> 
		</TD>
	</TR>
	</TBODY>
</TABLE>
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='30%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">
			<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Folio
			<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font></TD>
		<TD WIDTH='25%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">
			<a onclick="cambio('asc', 3)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Asunto
			<a onclick="cambio('desc', 3)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font></TD>
		<TD WIDTH='20%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">
			<a onclick="cambio('asc', 8)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Fecha Recepción
			<a onclick="cambio('desc', 8)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font></TD>
		<TD WIDTH='20%' align="center"><FONT SIZE=2 COLOR="FFFFFF"
			FACE="Arial">
			<a onclick="cambio('asc', 9)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Fecha Termino
			<a onclick="cambio('desc', 9)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font></TD>
		<TD WIDTH='5%' align="center"><FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Estatus</font></TD>
	</TR>
</TABLE>
<br>
<DIV class=documentBody id=Body>
<table>
	<% if(bExiste){ %>
	<% int ki = 0; %>
	<meve_front:ListaDatos
		datos="<%= ActualizaAsunto.AsuntosPorSolicitanteExternoT() %>" campo="campo">
		<table border="0" cellpadding="2" cellspacing="0">
			<% if (	BUsuario.getIdArea().equals((ActualizaUsuario.getIdUsrArea(campo1)==null)?"":ActualizaUsuario.getIdUsrArea(campo1))){ %>
			<%bMostrar = strIdUsuario.equals(campo1);%>
			<tr valign="top">
				<td colspan="2">
					<a onClick="desplegar(<%=campo1%>)">
					<img src="../Imagenes/<%=(bMostrar)?"collapse.gif":"expand.gif"%>" border="0" height="16" width="16">
					<%= ActualizaRemitente.getNombreRemitente(campo1) %>
					</a>
				</td>
				<td width="368"></td>
			</tr>
			<%if(bMostrar)
	  		{ 
			%>
			<TR>
				<TD align="left" colspan="2">
				<%	numRegistros = ActualizaAsunto.getRemitenteAsuntoT(campo1,strOrden,strTipo).length;
					if (numRegistros>0){ %>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<A href="../ReporteAsuntoExcel?tip=turnado_rem_int&id_remitente=<%= campo1 %>">
					<img src="../Imagenes/button_xls.gif" border="0" height="16" width="16">
					<FONT face="Arial" size="2">Exportar a Excel</FONT>
					</A>
				<%	} %>
				</TD>
				<TD align="right" colspan="4">
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
			<%	String[][] sql = ActualizaAsunto.getRemitenteAsuntoT(campo1,strOrden,strTipo);
				for (int ix=contPag*regPorPagina; ix<sql.length && ix<(contPag+1)*regPorPagina; ix++){
					String usuario1 = sql[ix][0];
					String usuario2 = sql[ix][1];
					String usuario3 = sql[ix][2];
					String usuario4 = sql[ix][3];
					String usuario5 = sql[ix][4];
					String usuario6 = sql[ix][5];
					String usuario7 = sql[ix][6];
			%>
			<% t++; %>
				<tr valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
					<td width="2%"></td>
					<td align="left" width="28%"><font size="1" color="#000080"
						face="Arial"> <A href="AsuntoTurnado.jsp?id_asunto=<%= usuario1 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas+"&orden="+strOrden+"&tipo="+strTipo) %>">
						<%= usuario2 %></A></font>
					</td>
					<td align="center" width="25%"><font size="1" color="#000080"
						face="Arial"><%= usuario3 %> </font></td>
					<td align="center" width="20%"><font size="1" color="#000080"
						face="Arial"><%=Utilerias.formatearFechas(usuario6)%> </font></td>
					<td align="center" width="20%"><font size="1" color="#000080"
						face="Arial">En Proceso </font></td>
					<td align="center" width="5%"><font size="1" color="#000080"
						face="Arial"><% if(usuario5.equals("2")){ %>En Tramite<%}%> </font></td>
				</tr>
			<%	} %>
			<TR>
			<TD colspan="6" align="center"><BR>
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
			<% 
	  		}
			ki++;
		   }
			%>
		</table>
	</meve_front:ListaDatos>
	<% if(ki==0){ %>
	<TR>
		<TD width="20%">
			<div align=center>
				<FONT face="verdana" size="4">******No Existen Asuntos******</FONT>
			</div>
		</TD>
	</TR>
	<% } %>
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
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>
