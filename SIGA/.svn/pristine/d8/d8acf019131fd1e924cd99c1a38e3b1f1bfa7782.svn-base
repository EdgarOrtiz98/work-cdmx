<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD> 
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,com.meve.sigma.reportes.*,java.util.*"
%>
<%@ page import="com.meve.sigma.util.*" %>
<%@ page import="gob.hacienda.cgtic.siga.instruccion.Rechazo"%>
<%@ page import="gob.hacienda.cgtic.siga.Usuario"%>
<%@ page import="gob.hacienda.cgtic.siga.actualiza.AtenderInstrucciones"%>
<%@ page import="gob.hacienda.cgtic.siga.actualiza.RechazoInstruccion"%>
<%@ page import="gob.hacienda.cgtic.siga.util.Jefe"%>
<% 
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null)
		response.sendRedirect("index.jsp?pagina="+ strTmp);
%>
<%
	boolean bExiste	= false;
	boolean bExiste1 = false;
	boolean bExisteSup = false;
	boolean bMostrar	=	false;
	boolean bNoExiste = false;
	int t = 0;
	int y = 0;
	bExiste	= ActualizaInstrucciones.TieneInstruccionesRechazadas();
	bExiste1 = ActualizaInstrucciones.existeInstruccionesRechazadasPorAtender(BUsuario.getIdUsuario());
	bExisteSup = ActualizaInstrucciones.existeInstRechazadasAtenderSup(BUsuario.getIdArea());
	float fPorcentaje = 0;
 	String strActivarPortal = application.getInitParameter("ActivarPortal");
	String strAccion = request.getParameter("accion");
	String strIdUsuario = (request.getParameter("idUs")!=null)?request.getParameter("idUs"):"";
	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"6";

	String strIdsAsiste[][] =	null;
        if(BUsuario.getAsistente())
            strIdsAsiste = Rechazo.getInsRechazadasAsistente(BUsuario.getIdUsuario(),BUsuario.getIdArea());

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
<TITLE>Instrucciones Rechazadas</TITLE>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script language="JavaScript" type="text/javascript">
function desplegar(id){
	doc = document.pRechaza;
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
	doc = document.pRechaza;
	doc.accion.value="reload";
	doc.orden.value=o;
	doc.tipo.value=t;
	doc.submit();
}
function pagina(contador){
	doc = document.pRechaza;
	doc.contPag.value=contador;
	doc.submit();
}

function paginaLiga(contador){
	doc = document.pRechaza;
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
<span id="ruler" style="visibility:hidden;"></span> 
<FORM method="post" action="PortalRechazadas.jsp" name="pRechaza">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%= strIdUsuario %>" name="idUs">
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
                    <td class="dominoSelTopTab" bgcolor="#004080"><a onclick="goRechazadas()";>Instrucciones rechazadas</a></td>
		<%}%>
                <%if(BUsuario.getAtencion()||BUsuario.getAsistente()){%>
                    <td class="dominoTopTab"><a onclick="goSolicitada()";>Asuntos Solicitados</a></td>
                <%}%>
	</tr>
	</TBODY>
</table>
<br>
<!--- Encabezado de las instrucciones rechazadas -->
<TABLE WIDTH='100%' BORDER="0">
	<TR BGCOLOR="00204F">
		<TD id="Asunto_HD" WIDTH='20%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="Arial">
			<a onclick="cambio('asc', 6)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Folio
			<a onclick="cambio('desc', 6)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font>
		</TD>
		<TD id="Asunto_HD2" WIDTH='50%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="Arial">
			<a onclick="cambio('asc', 7)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Asunto(Instrucción)
			<a onclick="cambio('desc', 7)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font>
		</TD>
		<TD id="Asunto_HD3" WIDTH='20%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="Arial">
			<a onclick="cambio('asc', 14)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Recibido/Concluido
			<a onclick="cambio('desc', 14)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font>
		</TD>
		<TD id="Asunto_HD4" WIDTH='10%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="Arial">Estatus</font>
		</TD>
	</TR>	
 </TABLE> 
<div id="msg">
</div>

<DIV class=documentBody id=Body>
<%if(BUsuario.getAtencion() && !BUsuario.getTurnado() && !BUsuario.getSupervisor()){%>
<div id="view">
<!-- Instrucciones rechazadas de usuario con rol de atención -->
<table width="100%" border="0" cellpadding="2" cellspacing="0">
<TBODY>
	<% 
		int j = 0;
		boolean bExisteAs = false;

                String[][] strSubAlternos = Rechazo.getInsRechazadasOtros(BUsuario.getIdUsuario(),BUsuario.getIdArea());
		///String[][] strSubAlternos = ActualizaUsuario.getInsRechazadas(BUsuario.getIdUsuario());
		AsignarArbol tree = new AsignarArbol(strSubAlternos);
		Vector vIdsCadena = tree.getIds();
		//vIdsCadena.add(0,BUsuario.getIdUsuario());
	%>
	<%for(int k=0; vIdsCadena!=null && k<vIdsCadena.size(); k++){%>
	<%
//                bExisteAs = Rechazo.getDatosInstruccionUsuario((String)vIdsCadena.get(k),strOrden,strTipo).length>0?true:false;
                    //bExisteAs	= ActualizaInstrucciones.TieneInstruccionesRechazadas((String)vIdsCadena.get(k));
                    bExisteAs = Rechazo.getDatosInstruccionUsuario((String)vIdsCadena.get(k),strOrden,strTipo).length>0?true:false;
                    ////System.out.println("Analisando al usuario: "+(String)vIdsCadena.get(k)+" Valor: "+bExiste);
			if(bExisteAs){ 
				bMostrar = strIdUsuario.equals((String)vIdsCadena.get(k));
	%>
	<TR>
		<TD colspan="4">
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<TBODY>
				<tr valign="top">
					<td colspan="5" width="100%"><a onClick="desplegar(<%=(String)vIdsCadena.get(k)%>)"> <img
						src="../Imagenes/<%=(bMostrar)?"collapse.gif":"expand.gif"%>"
						border="0" height="16" width="16"> 
						<%= ActualizaUsuario.NombreUsuario((String)vIdsCadena.get(k)) %> / <%= ActualizaUsuario.NombrePuesto((String)vIdsCadena.get(k)) %>
					</a></td>
				</tr>
				<% j++; %>
				<%if(bMostrar){ %>
				<TR>
					<TD align="left" colspan="2">
					<%numRegistros = Rechazo.getDatosInstruccionUsuario((String)vIdsCadena.get(k),strOrden,strTipo).length;
                                        //numRegistros = ActualizaInstrucciones.getInstruccionRechazadaUsuario((String)vIdsCadena.get(k),strOrden,strTipo).length;
						if (numRegistros>0){ %>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<A href="../ReporteAsuntoExcel?tip=inst_rechazada_01&id_remitente=<%= (String)vIdsCadena.get(k) %>">
							<img src="../Imagenes/button_xls.gif" border="0" height="16" width="16">
							<FONT face="Arial" size="2">Exportar a Excel</FONT>
							</A>
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
				<%      String[][] sql = Rechazo.getDatosInstruccionUsuario((String)vIdsCadena.get(k),strOrden,strTipo);
                                //	String[][] sql = ActualizaInstrucciones.getInstruccionRechazadaUsuario((String)vIdsCadena.get(k),strOrden,strTipo);
					for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
						String usuario1 = sql[i][0];
						String usuario2 = sql[i][1];
						String usuario3 = sql[i][2];
						String usuario4 = sql[i][3];
						String usuario5 = sql[i][4];
						String usuario6 = sql[i][5];
						String usuario7 = sql[i][6];
						String usuario8 = sql[i][7];
						String usuario9 = sql[i][8];
						String usuario10 = sql[i][9];
						String usuario15 = sql[i][14];
						String usuario16 = sql[i][15];
				%>
					<% t++; %>
					<tr valign="top" <%if(par(t)==true){%> <%}else{%> bgcolor="#f6f6f6"<%}%>>
						<td align="left" width="20%">
                                                &nbsp;&nbsp;&nbsp;&nbsp;
						<font size="1" color="#000080" face="Arial"> 
						<% 	if(usuario15.equals("0")){
								String padre1 = usuario16;
								if(padre1.length() != 0){ 
						%>
							<A href="InstruccionHija.jsp?id_ins=<%= usuario1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) %>"
							title="<%= usuario6 %>"><script> document.write(trunc('<%=usuario6%>','Asunto_HD'));</script>
							</A> 
						<%		}else{ %>
							<A href="InstruccionesAtender.jsp?id_ins=<%= usuario1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) %>"
							title="<%= usuario6 %>"><script> document.write(trunc('<%=usuario6%>','Asunto_HD'));</script>
							</A> 
						<% 		} %>
						<% } else if(usuario15.equals("1")){ %>
							<A href="InstruccionTurnada.jsp?id_ins=<%= usuario1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) %>"
							title="<%= usuario6 %>"><script> document.write(trunc('<%=usuario6%>','Asunto_HD'));</script>
							</A> 
						<% } %>
						</font>
						</td>
						<td align="center" width="50%"><A
							title="<%= usuario7 %><% if(usuario2.length() == 0){ %>(<%= usuario8 %>)
						<% }else{ %>(<%=ActualizaInst.getNombreInstruccion1(usuario2)%>)<% } %>">
						<font size="1" color="#000080" face="Arial"> <script>document.write(trunc('<%=usuario7%>','Asunto_HD2'));</script><% if(usuario2.length() == 0){ %>(<script>document.write(trunc('<%=usuario8%>','Asunto_HD2'));</script>)
						<% }else{ %>(<script>document.write(trunc('<%=ActualizaInst.getNombreInstruccion1(usuario2)%>','Asunto_HD2'));</script>)<% } %>
						</font></A></td>
						<td align="center" width="20%"><font size="1" color="#000080"
							face="Arial"> <%= Utilerias.formatearFechas(usuario3) %> -- <%= Utilerias.formatearFechas(usuario4) %>
						</font>
                                                </td>
						<td align="center" width="10%"><font size="1" color="#000080"
							face="Arial"> <%
							fPorcentaje = Utilerias.getPorcentajeDebido(new Integer(usuario9).intValue(), usuario3, usuario4, 5);
							float iAvance = new Float(usuario10).floatValue();
							if(fPorcentaje > 100){
						%> <IMG border="0" src="../Imagenes/rojob5.gif" width="10"
							height="10" title="Deberia llevar el 100%"> <% }else if(iAvance<fPorcentaje-10){ %>
						<IMG border="0" src="../Imagenes/rojo5.gif" width="11" height="11">
						<% }else if(iAvance > 20 || iAvance < 80){ %> <IMG border="0"
							src="../Imagenes/amarillo5.gif" width="11" height="11"> <% }if(iAvance>fPorcentaje){ %>
						<IMG border="0" src="../Imagenes/verde5.gif" width="11"
							height="11"> <% } %> </font></td>
					</tr>
					<% } %>
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
							for (int i=contligas; i<muestraPaginas+contligas && i<numPaginas; i++){ 
								if (i==contPag){  %>
									<A onclick="pagina(<%=i%>)"><FONT color="red"><B>[<%=i+1%>]</B></FONT></A> &nbsp;
						<%		}else{ %>
									<A onclick="pagina(<%=i%>)"><%=i+1%></A> &nbsp;
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
				<% } %>
			</TBODY>
		</table>
		<% } %>
		<% } %>
		<% if(j == 0){ 
		bNoExiste = true;
	%>
                </TD>
        </TR>
	<TR>
		<TD width="100%">
			<div align=center>
				<FONT face="verdana" size="4">****** No tiene Instrucciones Rechazadas ******</FONT>
			</div>
		</TD>
	</TR>
	<% } %>
</TBODY>
</table>
</div>
<%} else if(BUsuario.getAsistente()){%>
<div id="view">
<!-- Instruccion es rechazadas de usurio con rol de tipo Asistente -->
<table width="100%" border="0" cellpadding="2" cellspacing="0">
<TBODY>
	<% 
		int j = 0;
		boolean bExisteAs = false;
	%>
	<%
        try{
        for(int k=0;k<strIdsAsiste.length;k++){%>
	<%
//		bExisteAs	= ActualizaInstrucciones.TieneInstruccionesRechazadas(strIdsAsiste[k][0]);
                //bExisteAs = ActualizaInstrucciones.getInstruccionRechazadaUsuario(strIdsAsiste[k][0],strOrden,strTipo).length>0?true:false;
                bExisteAs = Rechazo.getDatosInstruccionUsuario(strIdsAsiste[k][0],strOrden,strTipo).length>0?true:false;
			if(bExisteAs){ 
				bMostrar = strIdUsuario.equals(strIdsAsiste[k][0]);
	%>
	<TR>
		<TD>
		<table border="0" cellpadding="2" cellspacing="0" width="100%>
			<TBODY>
				<tr valign="top">
					<td colspan="5" width="100%"><a onClick="desplegar(<%=strIdsAsiste[k][0]%>)"> <img
						src="../Imagenes/<%=(bMostrar)?"collapse.gif":"expand.gif"%>"
						border="0" height="16" width="16"> 
						<%= ActualizaUsuario.NombreUsuario(strIdsAsiste[k][0]) %> / <%= ActualizaUsuario.NombrePuesto(strIdsAsiste[k][0]) %>
					</a></td>
				</tr>
				<% j++; %>
				<%if(bMostrar){ %>
				<TR>
					<TD align="left" colspan="2">
                                        <%  numRegistros = Rechazo.getDatosInstruccionUsuario(strIdsAsiste[k][0],strOrden,strTipo).length;
					//	numRegistros = ActualizaInstrucciones.getInstruccionRechazadaUsuario(strIdsAsiste[k][0],strOrden,strTipo).length;
						if (numRegistros>0){ %>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<A href="../ReporteAsuntoExcel?tip=inst_rechazada_01&id_remitente=<%= strIdsAsiste[k][0] %>">
							<img src="../Imagenes/button_xls.gif" border="0" height="16" width="16">
							<FONT face="Arial" size="2">Exportar a Excel</FONT>
							</A>
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
				<%	String[][] sql = Rechazo.getDatosInstruccionUsuario(strIdsAsiste[k][0],strOrden,strTipo);
					for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
						String usuario1 = sql[i][0];
						String usuario2 = sql[i][1];
						String usuario3 = sql[i][2];
						String usuario4 = sql[i][3];
						String usuario5 = sql[i][4];
						String usuario6 = sql[i][5];
						String usuario7 = sql[i][6];
						String usuario8 = sql[i][7];
						String usuario9 = sql[i][8];
						String usuario10 = sql[i][9];
						String usuario15 = sql[i][14];
						String usuario16 = sql[i][15];
				%>
					<% t++; %>
					<tr valign="top" <%if(par(t)==true){%> <%}else{%> bgcolor="#f6f6f6"<%}%>>
<!--						<td width="2%"></td>    -->
						<td align="left" width="20%">
                                                &nbsp;&nbsp;&nbsp;&nbsp;
						<font size="1" color="#000080" face="Arial"> 
						<% 	if(usuario15.equals("0")){
								String padre1 = usuario16;
								if(padre1.length() != 0){ 
						%>
							<A href="InstruccionHija.jsp?id_ins=<%= usuario1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) %>"
							title="<%= usuario6 %>"><script> document.write(trunc('<%=usuario6%>','Asunto_HD'));</script>
							</A> 
						<%		}else{ %>
							<A href="InstruccionesAtender.jsp?id_ins=<%= usuario1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) %>"
							title="<%= usuario6 %>"><script> document.write(trunc('<%=usuario6%>','Asunto_HD'));</script>
							</A> 
						<% 		} %>
						<% } else if(usuario15.equals("1")){ %>
							<A href="InstruccionTurnada.jsp?id_ins=<%= usuario1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) %>"
							title="<%= usuario6 %>"><script> document.write(trunc('<%=usuario6%>','Asunto_HD'));</script>
							</A> 
						<% } %>
						</font>
						</td>
						<td align="center" width="50%"><A
							title="<%= usuario7 %><% if(usuario2.length() == 0){ %>(<%= usuario8 %>)
						<% }else{ %>(<%=ActualizaInst.getNombreInstruccion1(usuario2)%>)<% } %>">
						<font size="1" color="#000080" face="Arial"> <script> document.write(trunc('<%=usuario7%>','Asunto_HD2'));</script><% if(usuario2.length() == 0){ %>(<script> document.write(trunc('<%=usuario8%>','Asunto_HD2'));</script>)
						<% }else{ %>(<script> document.write(trunc('<%=ActualizaInst.getNombreInstruccion1(usuario2)%>','Asunto_HD2'));</script>)<% } %>
						</font></A></td>
						<td align="center" width="20%"><font size="1" color="#000080"
							face="Arial"> <%= Utilerias.formatearFechas(usuario3) %> -- <%= Utilerias.formatearFechas(usuario4) %>
						</font></td>
						<td align="center" width="10%"><font size="1" color="#000080"
							face="Arial"> <%
							fPorcentaje = Utilerias.getPorcentajeDebido(new Integer(usuario9).intValue(), usuario3, usuario4, 5);
							float iAvance = new Float(usuario10).floatValue();
							if(fPorcentaje > 100){
						%> <IMG border="0" src="../Imagenes/rojob5.gif" width="10"
							height="10" title="Deberia llevar el 100%"> <% }else if(iAvance<fPorcentaje-10){ %>
						<IMG border="0" src="../Imagenes/rojo5.gif" width="11" height="11">
						<% }else if(iAvance > 20 || iAvance < 80){ %> <IMG border="0"
							src="../Imagenes/amarillo5.gif" width="11" height="11"> <% }if(iAvance>fPorcentaje){ %>
						<IMG border="0" src="../Imagenes/verde5.gif" width="11"
							height="11"> <% } %> </font></td>
					</tr>
					<% } %>
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
							for (int i=contligas; i<muestraPaginas+contligas && i<numPaginas; i++){ 
								if (i==contPag){  %>
									<A onclick="pagina(<%=i%>)"><FONT color="red"><B>[<%=i+1%>]</B></FONT></A> &nbsp;
						<%		}else{ %>
									<A onclick="pagina(<%=i%>)"><%=i+1%></A> &nbsp;
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
				<% } %>
			</TBODY>
		</table>
		<% } %>
		<% }}catch(Exception e){} %>
		<% if(j == 0){ 
		bNoExiste = true;
	%>
	<TR>
		<TD width="100%">
			<div align=center>
				<FONT face="verdana" size="4">****** No tiene Instrucciones Rechazadas ******</FONT>
			</div>
		</TD>
	</TR>
	<% } %>
</TBODY>	
</table>
</div>
<%} else if(BUsuario.getTurnado() || BUsuario.getSupervisor()){%>
<div id="view">
<!-- Instrucciones rechazadas de usuario con rol de tipo turnador -->
<table width="100%" border="0" cellpadding="2" cellspacing="0">
<TBODY>
<!-- Se verifica que este pool, contiene instrucciones rechazadas -->
	<% if(RechazoInstruccion.boleanInstruccionRechazadaVentannilla(BUsuario.getIdArea())){ %>
	<% int j = 0; %>
	<% String[][] dstosLista = null; %>
	<%/* dstosLista = ActualizaInstrucciones.UsuarioInstruccionRechazadaPorTurnador(BUsuario.getIdUsuario()); */
	/*Consulta todas las instrucciones que han sido rechazadas, dentro de su area */
            dstosLista = RechazoInstruccion.getDatosInstruccionRechazados(BUsuario.getIdArea());
	%>
	<meve_front:ListaDatos datos="<%= dstosLista %>" campo="campo">     
	<%bMostrar = strIdUsuario.equals(campo1);%>
            <table border="0" cellpadding="2" cellspacing="0" width="100%">
                <TBODY>
                    <tr valign="top">
                        <td colspan="5" width="100%">
                            <a onClick="desplegar(<%=campo1%>)">
                                <img src="../Imagenes/<%=(bMostrar)?"collapse.gif":"expand.gif"%>" border="0" height="16" width="16"/>
                                    <%= ActualizaUsuario.NombreUsuario(campo1) %> / <%= ActualizaUsuario.NombrePuesto(campo1) %>
                            </a>
                        </td>
                    </tr>
                    <% j++; %>
                    <%if(bMostrar){ %>
                    <TR>
                        <TD align="left" colspan="2">
			<%numRegistros = Rechazo.getDatosInstruccionUsuarioVentanilla(campo1,strOrden,strTipo).length;
                          if (numRegistros>0){%>
                            &nbsp;&nbsp;&nbsp;&nbsp;
			  <A href="../ReporteAsuntoExcel?tip=inst_rechazada_01&id_remitente=<%= campo1 %>">
					<img src="../Imagenes/button_xls.gif" border="0" height="16" width="16">
					<FONT face="Arial" size="2">Exportar a Excel</FONT>
					</A>
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
			<%	String[][] sql = Rechazo.getDatosInstruccionUsuarioVentanilla(campo1,strOrden,strTipo);
				for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
					String usuario1 = sql[i][0];
					String usuario2 = sql[i][1];
					String usuario3 = sql[i][2];
					String usuario4 = sql[i][3];
					String usuario5 = sql[i][4];
					String usuario6 = sql[i][5];
					String usuario7 = sql[i][6];
					String usuario8 = sql[i][7];
					String usuario9 = sql[i][8];
					String usuario10 = sql[i][9];
					String usuario15 = sql[i][14];
					String usuario16 = sql[i][15];
			%>
			<% t++; %>
			<tr valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
				<td align="left" width="20%">&nbsp;&nbsp;&nbsp;&nbsp;
					<font size="1" color="#000080" face="Arial">
						<% 	if(usuario15.equals("0")){
								String padre1 = usuario16;
								if(padre1.length() != 0){ 
						%>
							<A href="InstruccionHija.jsp?id_ins=<%= usuario1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) %>"
								title="<%= usuario6 %>"><script> document.write(trunc('<%=usuario6%>','Asunto_HD'));</script>
							</A>
						<%		}else{ %>
							<A href="InstruccionesAtender.jsp?id_ins=<%= usuario1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) %>"
								title="<%= usuario6 %>"><script> document.write(trunc('<%=usuario6%>','Asunto_HD'));</script>
							</A>
						<% 		} %>
						<% } else if(usuario15.equals("1")){ %>
							<A href="InstruccionTurnada.jsp?id_ins=<%= usuario1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) %>"
								title="<%= usuario6 %>"><script> document.write(trunc('<%=usuario6%>','Asunto_HD'));</script>
							</A>
						<% } %>
					</font>
				</td>
				<td align="center" width="50%">
					<A title="<%= usuario7 %><% if(usuario2.length() == 0){ %>(<%= usuario8 %>)
						<% }else{ %>(<%=ActualizaInst.getNombreInstruccion1(usuario2)%>)<% } %>">
					<font size="1" color="#000080" face="Arial">
						<script> document.write(trunc('<%=usuario7%>','Asunto_HD2'));</script><% if(usuario2.length() == 0){ %>(<script> document.write(trunc('<%=usuario8%>','Asunto_HD2'));</script>)
						<% }else{ %>(<script> document.write(trunc('<%=ActualizaInst.getNombreInstruccion1(usuario2)%>','Asunto_HD2'));</script>)<% } %>
					</font></A>
				</td>
				<td align="center" width="20%">
					<font size="1" color="#000080" face="Arial">
						<%= Utilerias.formatearFechas(usuario3) %> -- <%= Utilerias.formatearFechas(usuario4) %>
					</font>
				</td>
				<td align="center" width="10%">
					<font size="1" color="#000080" face="Arial">
						<%
							fPorcentaje = Utilerias.getPorcentajeDebido(new Integer(usuario9).intValue(), usuario3, usuario4, 5);
							float iAvance = new Float(usuario10).floatValue();
							if(fPorcentaje > 100){
						%>
						<IMG border="0" src="../Imagenes/rojob5.gif" width="10"	height="10" title="Deberia llevar el 100%">
						<% }else if(iAvance<fPorcentaje-10){ %>
						<IMG border="0" src="../Imagenes/rojo5.gif" width="11" height="11">
						<% }else if(iAvance > 20 || iAvance < 80){ %>
						<IMG border="0" src="../Imagenes/amarillo5.gif" width="11" height="11">
						<% }if(iAvance>fPorcentaje){ %>
						<IMG border="0" src="../Imagenes/verde5.gif" width="11" height="11">
						<% } %>
					</font>
				</td>
			</tr>
				<% } %>
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
					for (int i=contligas; i<muestraPaginas+contligas && i<numPaginas; i++){ 
						if (i==contPag){  %>
							<A onclick="pagina(<%=i%>)"><FONT color="red"><B>[<%=i+1%>]</B></FONT></A> &nbsp;
				<%		}else{ %>
							<A onclick="pagina(<%=i%>)"><%=i+1%></A> &nbsp;
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
			<% } %>
		</TBODY>
		</table>
	</meve_front:ListaDatos>
	<% if(j == 0 && !bNoExiste){ %>
	<TR>
		<TD width="100%">
			<div align=center>
				<FONT face="verdana" size="4">****** No tiene Instrucciones Rechazadas ******</FONT>
			</div>
		</TD>
	</TR>
	<% } %>
	<% } else if (!bNoExiste){ %> 
	<TR>
		<TD width="100%">
			<div align=center>
				<FONT face="verdana" size="4">****** No tiene Instrucciones Rechazadas ******</FONT>
			</div>
		</TD>
	</TR>
	<% } %>
</TBODY>	
</table>
</div>
<%}%>
<BR>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
<BR>
</FORM>
</BODY>
</HTML>