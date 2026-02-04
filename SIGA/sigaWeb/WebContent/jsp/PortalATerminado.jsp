<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@page import="gob.hacienda.cgtic.siga.asunto.AsuntoVerifica"%>
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,com.meve.sigma.util.*,com.meve.sigma.reportes.*"
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
	boolean bExisteInsAsunto = false;
	boolean bExisteMisAsuntos = false;
	boolean noPuedeVerVentanillas		=   AsuntoVerifica.noPuedeUaVerVentanillas(session.getServletContext(),BUsuario.getIdArea());
	int iDuracion = 0;
	float fPorcentaje = 0;
	float fAvance = 0;
	int t = 0;
	String strActivarPortal = application.getInitParameter("ActivarPortal");
	String strAccion 	= 	request.getParameter("accion");
	String strOrden 	= 	(request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	String strTipo 		= 	(request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
	String strCambio 	= 	(request.getParameter("cambio1")!=null)?request.getParameter("cambio1"):"0";
	String strCambioT	=	(request.getParameter("cambioT")!=null)?request.getParameter("cambioT"):"0";
	//String subVentanilla=	ActualizaInstrucciones.getAreaSubventanilla(BUsuario.getIdArea());
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
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>Asuntos Terminados</TITLE>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script language="JavaScript" type="text/javascript">
	function cambio(o, t){
		doc = document.pATerminado;
		doc.accion.value="reload";
		doc.orden.value=o;
		doc.tipo.value=t;
		//doc.cambio1.value=<%=strCambio%>;
		doc.submit();
	}
	function desplegar(id){
		doc = document.pATerminado;
		if (id==doc.cambio1.value){
			doc.cambio1.value=0;
			doc.submit();
		}else{
			doc.cambio1.value=id;
			doc.contPag.value=0;
			doc.contligas.value=0;
			doc.submit();
		}
	}
	function desplegarT(id, ido){
		doc = document.pATerminado;
		if (id==doc.cambioT.value){
			doc.cambioT.value=0;
			doc.cambio1.value=ido
			doc.submit();
		}else{
			doc.cambioT.value=id;
			doc.cambio1.value=ido
			doc.contPag.value=0;
			doc.contligas.value=0;
			doc.submit();
		}
	}
function pagina(contador){
	doc = document.pATerminado;
	doc.contPag.value=contador;
	doc.submit();
}

function paginaLiga(contador){
	doc = document.pATerminado;
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

<form method="post" action="PortalATerminado.jsp" name="pATerminado">
<INPUT type="hidden" name="orden" value="<%= strOrden %>">
<INPUT type="hidden" name="tipo" value="<%=strTipo %>">
<INPUT type="hidden" name="accion" value="">
<INPUT type="hidden" name="cambio1" value="<%=strCambio%>">
<INPUT type="hidden" name="cambioT" value="<%=strCambioT%>">
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
                    <td class="dominoSelTopTab" bgcolor="#004080"><a onclick="goAsuntosTer()";>Asuntos terminados</a></td>
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
                    <td class="dominoTopTab"><a onclick="goSolicitada()";>Asuntos Solicitados</a></td>
                <%}%>
	</tr>
	</TBODY>
</table>
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='40%' align="center">
		<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">
		<a onclick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
		Asunto
		<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
		</font></TD>
		<TD WIDTH='20%' align="center">
		<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">
		<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
		Folio
		<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
		</font></TD>
		<TD WIDTH='10%' align="center">
		<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">
		<a onclick="cambio('asc', 3)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
		Avance (%)
		<a onclick="cambio('desc', 3)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
		</font></TD>
		<TD WIDTH='20%' align="center">
		<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">
		<a onclick="cambio('asc', 4)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
		Fecha Terminación
		<a onclick="cambio('desc', 4)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
		</font></TD>
		<TD WIDTH='10%' align="center"><FONT SIZE=1 COLOR="FFFFFF"
			FACE="verdana">Estatus</font></TD>
	</TR>
</TABLE>
<DIV class=documentBody id=Body>
<div id="view">
<A onclick="desplegar(1)">
<img src="../Imagenes/<%=(strCambio.equals("1"))?"collapse.gif":"expand.gif"%>" border="0" height="16" width="16">
<FONT face="Arial" size="2"><b>Mis Asuntos</b></FONT>
</A>
<%	if(strCambio.equals("1")){%>
<TABLE width="100%" border="0">
<TBODY>
	<TR>
		<TD align="left">
		<%	numRegistros = ActualizaAsunto.getDatosMisAsuntosTerminado(strOrden, strTipo, BUsuario.getIdUsuario()).length;
			if (numRegistros>0){ %>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<A href="../ReporteAsuntoExcel?tip=terminado_01">
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
<%	} %>
<BR>
<%if(strCambio.equals("1")){%>
<table width="100%" border="0" cellpadding="2" cellspacing="0">
	<TBODY>
		<%
		bExisteMisAsuntos = ActualizaAsunto.getExistenMisAsuntosTerminados(BUsuario.getIdUsuario());
		if(bExisteMisAsuntos){
		%>
		<% int j = 0; %>
		<%	String[][] sql = ActualizaAsunto.getDatosMisAsuntosTerminado(strOrden, strTipo, BUsuario.getIdUsuario());
			for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
				String campo1 = sql[i][0];
				String campo2 = sql[i][1];
				String campo3 = sql[i][2];
				String campo4 = sql[i][3];
				String campo5 = sql[i][4];
				String campo6 = sql[i][5];
				String campo7 = sql[i][6];
				String campo8 = sql[i][7];
		%>
		<% t++; %>
			<tr valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
				<td width='40%'><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="16" title=""> <FONT SIZE=2 <%if(campo7.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo7 %>"<%}%>
					FACE="Verdana"> <A href="AsuntoTurnado.jsp?id_asunto=<%= campo1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&cambio1="+strCambio+"&contPag="+contPag+"&contligas="+contligas) %>" 
					title="<%= campo2 %>"> <%= Utilerias.recortaString(campo2,40) %></A>
				</Font></td>
				<td width='20%'>
				<div align=center>
					<font size="1" <%if(campo7.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo7 %>"<%}%> face="Arial"><%=campo4 %></font>
				</div>
				</td>
				<td width='10%'>
				<div align=center>
					<font size="1" <%if(campo7.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo7 %>"<%}%> face="Arial"><%=campo5 %></font>
				</div>
				</td>
				<td width='20%'>
				<div align=center>
					<font size="1" <%if(campo7.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo7 %>"<%}%> face="Arial"><%=campo8 %></font>
				</div>
				</td>
				<td width='10%'><font size="2" face="Verdana"></font>
				<%	
					fAvance = new Float(campo5).floatValue();
					if(fAvance >= 100){
				%>
				<div align=center>
					<font size="1" <%if(campo7.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo7 %>"<%}%> face="Arial">Terminado</font>
				</div>
				<%}else{%>
				<div align=center>
					<font size="1" <%if(campo7.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo7 %>"<%}%> face="Arial">Por Aprobar</font>
				</div>
				<%}%>
				</td>
			</tr>
			<% j++; %>
		<% } %>
		<% if(j == 0){ %>
		<TR>
			<TD width="100%">
			<div align=center><FONT face="verdana" size="4">****** No tiene Asuntos Terminados ******</FONT></div>
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
		<% } %>
		<% } else { %>
		<TR>
			<TD width="100%">
			<div align=center><FONT face="verdana" size="4">****** No tiene Asuntos Terminados ******</FONT></div>
			</TD>
		</TR>
		<% } %>
	</TBODY>
</table>
<BR>
<%}
if(!noPuedeVerVentanillas){%>
<A onclick="desplegar(2)">
<img src="../Imagenes/<%=(strCambio.equals("2"))?"collapse.gif":"expand.gif"%>" border="0" height="16" width="16">
<FONT face="Arial" size="2"><b>Asuntos de la Ventanilla</b></FONT>
</A>
<%	if(strCambio.equals("2")){%>
<TABLE width="100%" border="0">
<TBODY>
	<TR>
		<TD align="left">
		<%	numRegistros = ActualizaAsunto.getDatosAsuntoTerminado(strOrden, strTipo, BUsuario.getIdArea(), BUsuario.getIdUsuario()).length;
			if (numRegistros>0){ %>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<A href="../ReporteAsuntoExcel?tip=terminado_02">
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
		&nbsp;&nbsp;&nbsp;&nbsp;
		</TD>
	</TR>
</TBODY>
</TABLE>
<%	} %>
<BR>
<%if(strCambio.equals("2")){%>
<table width="100%" border="0" cellpadding="2" cellspacing="0">
	<TBODY>
		<%
		String[][] turnadores = ActualizaAsunto.getTurnadoreUnidadTerminado(BUsuario.getIdArea(), BUsuario.getIdUsuario());
                if(turnadores.length==0){%>
                <TR>
						<TD width="100%">
							<div align=center><FONT face="Arial" size="4">****** No hay Asuntos Terminados de la Ventanilla ******</FONT></div>
						</TD>
					</TR>
                <%}
                for(int i=0;i<turnadores.length;i++){
		int iCount = i+4;
		String count = String.valueOf(iCount);
		%>
		<TR>
		<TD width="1%">&nbsp;</TD>
		<TD width="99%">
		<A onclick="desplegarT(<%=count%>, 2)">
		<img src="../Imagenes/<%=(strCambioT.equals(count))?"collapse.gif":"expand.gif"%>" border="0" height="16" width="16">
		<FONT face="Arial" size="2"><b><%=turnadores[i][1]%></b></FONT>
		</A>
			<%if(strCambioT.equals(count)){%>
			<TABLE width="100%" border="0" cellpadding="2" cellspacing="0">
				<TBODY>
					<TR>
						<TD align="left" width="50%">
						<%numRegistros = ActualizaAsunto.datosAsuntoTurnadorTerminado(strOrden, strTipo, BUsuario.getIdArea(), turnadores[i][0]).length; %>
						</TD>
						<TD align="right" width="50%">
						<%	numPaginas = numRegistros/regPorPagina;	
						if (numRegistros%regPorPagina != 0)
						numPaginas++; %>
						<%if(numRegistros > 0){%>
						<%=numRegistros%> registros mostrados. 
						<%}%>
						&nbsp;&nbsp;&nbsp;&nbsp;
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE width="100%" border="0" cellpadding="2" cellspacing="0">
				<TBODY>
					<%
					bExiste	= ActualizaAsunto.existeAsuntoTurnadorTerminado(BUsuario.getIdArea(), turnadores[i][0]); 
					if(bExiste){
					%>
					<% int j = 0; %>
					<%	String[][] sql = ActualizaAsunto.datosAsuntoTurnadorTerminado(strOrden, strTipo, BUsuario.getIdArea(), turnadores[i][0]);
						for (int y=contPag*regPorPagina; y<sql.length && y<(contPag+1)*regPorPagina; y++){
							String campo1 = sql[y][0];
							String campo2 = sql[y][1];
							String campo3 = sql[y][2];
							String campo4 = sql[y][3];
							String campo5 = sql[y][4];
							String campo6 = sql[y][5];
							String campo7 = sql[y][6];
							String campo8 = sql[y][7];
					
					%>
					<% t++; %>
					<tr valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
						<td width='40%'><img src="../Imagenes/ecblank.gif" border="0"
							height="1" width="16" title=""> <FONT SIZE=2 <%if(campo7.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo7 %>"<%}%>
							FACE="Verdana"> <A href="AsuntoTurnado.jsp?id_asunto=<%= campo1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&cambio1="+strCambio+"&contPag="+contPag+"&contligas="+contligas) %>" 
							title="<%= campo2 %>"> <%= Utilerias.recortaString(campo2,40) %></A>
							</Font></td>
						<td width='20%'>
							<div align=center>
								<font size="1" <%if(campo7.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo7 %>"<%}%> face="Arial"><%=campo4 %></font>
							</div>
						</td>
						<td width='10%'>
							<div align=center>
								<font size="1" <%if(campo7.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo7 %>"<%}%> face="Arial"><%=campo5 %></font>
							</div>
						</td>
						<td width='20%'>
							<div align=center>
								<font size="1" <%if(campo7.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo7 %>"<%}%> face="Arial"><%=campo8 %></font>
							</div>
						</td>
						<td width='10%'><font size="2" face="Verdana"></font>
						<%	
						fAvance = new Float(campo5).floatValue();
						if(fAvance >= 100){
						%>
						<div align=center>
						<font size="1" <%if(campo7.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo7 %>"<%}%> face="Arial">Terminado</font>
						</div>
						<%}else{%>
						<div align=center>
						<font size="1" <%if(campo7.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo7 %>"<%}%> face="Arial">Por Aprobar</font>
						</div>
						<%}%>
						</td>
					</tr>
					<% j++; %>
					<%}%>
					<% if(j == 0){ %>
					<TR>
						<TD width="100%">
							<div align=center><FONT face="Arial" size="4">****** No hay Asuntos Terminados de la Ventanilla ******</FONT></div>
						</TD>
					</TR>
					<%}else{%>
					<TR>
						<TD colspan="5" align="center"><BR>
						<%
						int numeroPaginas = (sql!=null)?sql.length/regPorPagina:0;	
						if (sql.length%regPorPagina != 0)
							numeroPaginas++; 
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
							for (int k=contligas; k<muestraPaginas+contligas && k<numeroPaginas; k++){ 
								if (i==contPag){  %>
									<A onclick="pagina(<%=k%>)"><FONT color="red"><B>[<%=k+1%>]</B></FONT></A> &nbsp;
							<%	}else{ %>
									<A onclick="pagina(<%=k%>)"><FONT color="red"><B>[<%=k+1%>]</B></FONT></A> &nbsp;
							<%	}
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
						<%}%>
						</TD>
					</TR>
					<%}%>
					<%}else{%>
					<TR>
						<TD width="100%">
							<div align=center><FONT face="Arial" size="4">****** No hay Asuntos Terminados de la Ventanilla ******</FONT></div>
						</TD>
					</TR>
					<%}%>
				</TBODY>
			</TABLE>
			<%}%>
		</TD>
		</TR>
		<%}%>
	</TBODY>
</table>
<BR>
<%}%>
<A onclick="desplegar(3)">
<img src="../Imagenes/<%=(strCambio.equals("3"))?"collapse.gif":"expand.gif"%>" border="0" height="16" width="16">
<FONT face="Arial" size="2"><b>De otras Ventanillas</b></FONT>
</A>
<%	if(strCambio.equals("3")){%>
<TABLE width="100%" border="0">
<TBODY>
	<TR>
		<TD align="left">
		<%	if(!BUsuario.getSupervisor()){//Un rol de atención 
			numRegistros = ActualizaInstrucciones.getInstruccionTerminadaUsuarioAsunto(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea(), 1).length;
			}else{
			numRegistros = ActualizaInstrucciones.getInstruccionTerminadaUsuarioAsunto(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea(), 1).length;
			}
			if (numRegistros>0){ %> 
			&nbsp;&nbsp;&nbsp;&nbsp;
			<A href="../ReporteAsuntoExcel?tip=terminado_03">
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
<%	} %>
<BR>
<%if(strCambio.equals("3")){%>
<table width="100%" border="0" cellpadding="2" cellspacing="0">
	<TBODY>
		<%
		bExisteInsAsunto = ActualizaInstrucciones.TieneInstruccionesTerminadasAsunto(BUsuario.getIdUsuario());
		if(numRegistros!=0){
		%>
		<% int j = 0; %>
		<%	String[][] sql = null;
			if(!BUsuario.getSupervisor()){//Un rol de atención
			sql = ActualizaInstrucciones.getInstruccionTerminadaUsuarioAsunto(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea(), 1);
			}else{
			sql = ActualizaInstrucciones.getInstruccionTerminadaUsuarioAsunto(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea(), 1);
			}
			for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
				String campo1 = sql[i][0];
				String campo2 = sql[i][1];
				String campo3 = sql[i][2];
				String campo4 = sql[i][3];
				String campo5 = sql[i][4];
				String campo6 = sql[i][5];
				String campo7 = sql[i][6];
				String campo8 = sql[i][7];
				String campo9 = sql[i][8];
				String campo10 = sql[i][9];
				String campo11 = sql[i][10];
				String campo12 = sql[i][11];
		%>
		<% t++; %>
			<tr valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
				<td width='40%'>
					<img src="../Imagenes/ecblank.gif" border="0" height="1" width="16" title="">
					<FONT SIZE=2 <%if(campo10.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo10 %>"<%}%> FACE="Verdana">
					<A href="InstruccionTurnada.jsp?id_ins=<%= campo1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&cambio1="+strCambio+"&contPag="+contPag+"&contligas="+contligas) %>" 
						title="<%=campo11%>(<% if(campo2.length() == 0){ %> <%= campo3 %> <% }else{ %> <%= ActualizaInst.getNombreInstruccion1(campo2) %><%}%>)">
					<%=Utilerias.recortaString(campo12,20)%>(<% if(campo2.length() == 0){ %> <%= Utilerias.recortaString(campo3,20) %> <% }else{ %> <%= Utilerias.recortaString(ActualizaInst.getNombreInstruccion1(campo2),20) %><%}%>)
					</A>
					</Font>
					
				</td>
				<td width='20%'>
				<div align=center>
					<font size="1" <%if(campo10.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo10 %>"<%}%> face="Arial"><%=campo7 %></font>
				</div>
				</td>
				<td width='10%'>
				<div align=center>
					<font size="1" <%if(campo10.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo10 %>"<%}%> face="Arial"><%=campo9 %></font>
				</div>
				</td>
				<td width='20%'>
				<div align=center>
					<font size="1" <%if(campo10.length() == 0){%>color="black"<%}else{%>COLOR="<%=campo10 %>"<%}%> face="Arial"><%=campo4 %></font>
				</div>
				</td>
				<td width='10%'>
					<div align=center>
						<%
							iDuracion = Utilerias.DiasdeTrabajoEntre(Utilerias.StringCalendar(campo4), 
																	Utilerias.StringCalendar(campo5), 0);
							fPorcentaje = Utilerias.getPorcentajeDebido(iDuracion, campo4, campo5, 5);
							fAvance = new Float(campo9).floatValue();
							if(fPorcentaje>=100){
						%> 
							<IMG border="0" src="../Imagenes/rojo5.gif" width="11" height="11">
						<% }else if(fPorcentaje < 75  ){ %>
							<IMG border="0" src="../Imagenes/verde5.gif" width="11" height="11">
						<% }else if(fPorcentaje >= 75){ %>
							<IMG border="0" src="../Imagenes/amarillo5.gif" width="11" height="11">
						<% } %>
					</div>
				</td>
			</tr>
			<% j++; %>
		<% } %>
		<% if(j == 0){ %>
		<TR>
			<TD width="100%">
			<div align=center><FONT face="Arial" size="4">****** No hay Asuntos Terminados de otras Ventanillas ******</FONT></div>
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
		<% } %>
		<% } else { %>
		<TR>
			<TD width="100%">
			<div align=center><FONT face="Arial" size="4">****** No hay Asuntos Terminados de otras Ventanillas ******</FONT></div>
			</TD>
		</TR>
		<% } %>
	</TBODY>
</table>
<%}
}%>
</div>
<BR>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</form>
</BODY>
</HTML>
