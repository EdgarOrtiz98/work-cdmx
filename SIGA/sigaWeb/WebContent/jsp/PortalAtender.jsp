<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,com.meve.sigma.reportes.*,com.meve.sigma.util.*,java.util.*,java.io.*,gob.hacienda.cgtic.siga.actualiza.AtenderInstrucciones"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null)
		response.sendRedirect("index.jsp?pagina="+ strTmp);

	boolean bExiste		=	false;
	boolean bMostrar	=	false;
	int t 				= 	0; 
	float fPorcentaje	= 	0;

	String strActivarPortal =	application.getInitParameter("ActivarPortal");
	String strAccion 	=	request.getParameter("accion");
	String strIdUsuario 	=	(request.getParameter("idUs")!=null)?request.getParameter("idUs"):"";

	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"6";

	String strIdsAsiste[][] =	null;
	
	if(BUsuario.getAsistente()||AtenderInstrucciones.getTitular(BUsuario.getIdUsuario())){
                
                if(AtenderInstrucciones.getTitular(BUsuario.getIdUsuario()))                    
                    strIdsAsiste = ActualizaUsuario.getIdsUsAsistente(AtenderInstrucciones.getMyAsistente(BUsuario.getIdUsuario()));
                else
                    strIdsAsiste = ActualizaUsuario.getIdsUsAsistente(BUsuario.getIdUsuario());
		
                Vector vecUsr = new Vector();
		String strDatos[][] = null;
		
		if (strIdsAsiste != null && !strIdsAsiste.equals("") && strIdsAsiste.length>0){
			for (int i=0; i<strIdsAsiste.length; i++){
				vecUsr.addElement(strIdsAsiste[i][0]);
				strDatos = ActualizaUsuario.getSubordinados(strIdsAsiste[i][0]);
				AsignarArbol tree = new AsignarArbol(strDatos);
				Vector vNom = tree.getIds();

				if (vNom.size()>0){
					for (int k=0; k<vNom.size(); k++){
						vecUsr.addElement(vNom.get(k));
					}
				}
			}
		}else{
                    vecUsr.addElement(BUsuario.getIdUsuario());
				strDatos = ActualizaUsuario.getSubordinados(BUsuario.getIdUsuario());
				AsignarArbol tree = new AsignarArbol(strDatos);
				Vector vNom = tree.getIds();

				if (vNom.size()>0){
					for (int k=0; k<vNom.size(); k++){
						vecUsr.addElement(vNom.get(k));
					}
				}
                }
		for (int i=0; i<vecUsr.size(); i++){
			for (int j=0; j<vecUsr.size(); j++){
				if (i!=j){
                                    try{
					String aux1 = (String)vecUsr.get(i);
					String aux2 = (String)vecUsr.get(j);
					if(aux1.equals(aux2)){
						vecUsr.removeElementAt(i);
						i=-1;
						j=vecUsr.size();
					}
                                    }catch(Exception e){}
				}
			}
		}
                
		strIdsAsiste = new String[vecUsr.size()][1];
		for (int i=0; i<vecUsr.size(); i++){
			String aux = (String)vecUsr.get(i);
			strIdsAsiste[i][0] = aux;
		}
	}

	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");
	int regPorPagina = 20;
	int muestraPaginas = 20;
	int iSAmarillo = 70;
	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
	if(strConfig != null && strConfig.length > 0){
		regPorPagina 	= 	Integer.parseInt(strConfig[0][3]);
		muestraPaginas 	= 	Integer.parseInt(strConfig[0][4]);
		iSAmarillo		=	Integer.parseInt(strConfig[0][2]);
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
<TITLE>Instrucciones por Atender</TITLE>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script language="JavaScript" type="text/javascript">
function desplegar(id){
	doc = document.pAtender;
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
</script>
<script language="JavaScript" type="text/javascript">
function cambio(o, t){
	doc = document.pAtender;
	doc.accion.value="reload";
	doc.orden.value=o;
	doc.tipo.value=t;
	doc.submit();
}
function pagina(contador){
	doc = document.pAtender;
	doc.contPag.value=contador;
	doc.submit();
}
function paginaLiga(contador){
	doc = document.pAtender;
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

<FORM method="post" action="PortalAtender.jsp" name="pAtender">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%= strIdUsuario %>" name="idUs">
<INPUT type="hidden" value="<%= strOrden %>" name="orden" >
<INPUT type="hidden" value="<%= strTipo %>" name="tipo">
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
                    <td class="dominoSelTopTab" bgcolor="#004080"><a onclick="goAtender()";>Instrucciones por atender</a></td>
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
<br>
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='19%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">
			<a onclick="cambio('asc', 6)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Folio
			<a onclick="cambio('desc', 6)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font>
		</TD>
		<TD WIDTH='368' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">
			<a onclick="cambio('asc', 7)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Asunto(Instrucción)
			<a onclick="cambio('desc', 7)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font>
		</TD>
		<TD WIDTH='368' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">
			<a onclick="cambio('asc', 18)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Recibido/Vence
			<a onclick="cambio('desc', 18)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font>
		</TD>
		<TD WIDTH='243' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">
			Estatus
			</font>
		</TD>
	</TR>	
</TABLE>
<div id="msg">
</div>
<DIV class=documentBody id=Body>
<div id="view">
<table width="100%" border="0" cellpadding="2" cellspacing="0">
<TBODY>
	<%
	if(BUsuario.getAsistente()||AtenderInstrucciones.getTitular(BUsuario.getIdUsuario())){
		boolean bExisteAs = false;
		int j = 0;
		for(int i=0;i<strIdsAsiste.length;i++){%>
	<%		bExisteAs	= ActualizaInstrucciones.TieneInstruccionesPorAtender(strIdsAsiste[i][0]);
			if(bExisteAs){
				bMostrar = strIdUsuario.equals(strIdsAsiste[i][0]);
	%>
		<TR>
		<TD>
		<table border="0" cellpadding="2" cellspacing="0">
		<TBODY>
			<tr valign="top">
				<td colspan="5" width="100%">
					<a onClick="desplegar(<%=strIdsAsiste[i][0]%>)">
					<img src="../Imagenes/<%=(bMostrar)?"collapse.gif":"expand.gif"%>" 
						border="0" height="16" width="16">
						<%= ActualizaUsuario.NombreUsuario(strIdsAsiste[i][0]) %> / <%= ActualizaUsuario.NombrePuesto(strIdsAsiste[i][0]) %>
					</a>
				</td>
			</tr> 
			<%
			j++;
			String str[][]=ActualizaInstrucciones.getInstruccionAtenderUsuario(strIdsAsiste[i][0],strOrden,strTipo);
                        int longitud = str!=null ? str.length:0;
			if(bMostrar && longitud!=0){ %>
			<TR>
				<TD align="left" colspan="2">
				<%	numRegistros = ActualizaInstrucciones.getInstruccionAtenderUsuario(strIdsAsiste[i][0],strOrden,strTipo).length;
					if (numRegistros>0){ %>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<A href="../ReporteAsuntoExcel?tip=inst_atender_01&id_remitente=<%= strIdsAsiste[i][0] %>">
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
			<%	String[][] sql = ActualizaInstrucciones.getInstruccionAtenderUsuario(strIdsAsiste[i][0],strOrden,strTipo);
				for (int ix=contPag*regPorPagina; ix<sql.length && ix<(contPag+1)*regPorPagina; ix++){
					String usuario1 = sql[ix][0];
					String usuario2 = sql[ix][1];
					String usuario3 = sql[ix][2];
					String usuario4 = sql[ix][3];
					String usuario5 = sql[ix][4];
					String usuario6 = sql[ix][5];
					String usuario7 = sql[ix][6];
					String usuario8 = sql[ix][7];
					String usuario9 = sql[ix][8];
					String usuario10 = sql[ix][9];
					String usuario11 = sql[ix][10];
					String usuario12 = sql[ix][11];
					String usuario13 = sql[ix][12];
					String usuario14 = sql[ix][13];
					String usuario15 = sql[ix][14];
					String usuario16 = sql[ix][15];
					String usuario17 = sql[ix][16];
			%>
			<% t++; %>
			<tr valign="top" <%if(par(t)==true){;}else{%>bgcolor="#f6f6f6"<%}%>>
				<td width="2%"></td>
				<td align="left" width="17%">
					<font size="1" color="#000080" face="Arial">
						<% 
							if(usuario14.equals("0")){
								String padre1 = usuario17;
								if(padre1.length() != 0){ 
						%>
						<A href="InstruccionHija.jsp?id_ins=<%= usuario1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas+"&orden="+strOrden+"&tipo="+strTipo) %>" title="<%= usuario6 %>">
							<%= Utilerias.recortaString(usuario6,30) %>
						</A>
						<%
								}else{
						%>
<!--						<A href="InstruccionesAtender.jsp?id_ins=<%= usuario1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas+"&orden="+strOrden+"&tipo="+strTipo)+"uriU" %>" title="<%= usuario6 %>"> -->
                                                <A href="InstruccionesAtender.jsp?id_ins=<%= usuario1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas+"&orden="+strOrden+"&tipo="+strTipo)%>" title="<%= usuario6 %>">
							<%= Utilerias.recortaString(usuario6,30) %>
						</A>
						<% 		} %>
						<% }else if(usuario14.equals("1")){ %>
						<A href="InstruccionTurnada.jsp?id_ins=<%= usuario1 %>&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas+"&orden="+strOrden+"&tipo="+strTipo) %>" title="<%= usuario6 %>">
							<%= Utilerias.recortaString(usuario6,30) %>
						</A>
						<% } %>
					</font>
				</td>
				<td align="center" width="368">
					<a title="<%= usuario7 %><% if(usuario2.length() == 0){ %>(<%= usuario8 %>)
						<% }else{ %>(<%=ActualizaInst.getNombreInstruccion1(usuario2)%>)<% } %>">

					<font size="1" color="#000080" face="Arial">
						<%= Utilerias.recortaString(usuario7,20) %><% if(usuario2.length() == 0){ %>(<%= Utilerias.recortaString(usuario8,20) %>)
						<% }else{ %>(<%=Utilerias.recortaString(ActualizaInst.getNombreInstruccion1(usuario2),20)%>)<% } %>
					</font></a>
				</td>
				<td align="center" width="368">
					<font size="1" color="#000080" face="Arial">
						<%=Utilerias.formatearFechas(usuario3)%> -- <%=Utilerias.formatearFechas(usuario4)%>
					</font>
				</td>
				<td align="center" width="243">
					<font size="1" color="#000080" face="Arial">
						<%fPorcentaje = Utilerias.getPorcentajeDebido(new Integer(usuario9).intValue(), usuario3, usuario4, 5);
						float iAvance = new Float(usuario10).floatValue();
						if(fPorcentaje > 100){%>
						<IMG border="0" src="../Imagenes/rojob5.gif" width="10" height="10">
						<%}else if(fPorcentaje>=iSAmarillo &&  fPorcentaje<=100){%>
							<%if(fPorcentaje<=iAvance){%>
							<IMG border="0" src="../Imagenes/verde5.gif" width="11" height="11"/>
							<%}else{%>
							<IMG border="0" src="../Imagenes/amarillo5.gif" width="11" height="11" title="Debería llevar el <%=fPorcentaje%>%"/>
							<%}%>
						<%--<% }else if(iAvance>=fPorcentaje){ %>--%>
						<% }else if(fPorcentaje<iSAmarillo){ %>
						<IMG border="0" src="../Imagenes/verde5.gif" width="11" height="11">
						<% } %>
					</font>
				</td>
			</tr>
				<%}%>
			<TR>
			<TD colspan="5" align="center"><BR>
				<%
				if (contligas>0 && numPaginas > muestraPaginas){  
                                %>
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
                                        %>
                                            <A onclick="pagina(<%= ik+1 %>)">
						<%if (ik==contPag){%>
                                                    <FONT color='red'><B>[<%=ik+1%>]</B></FONT>
						<%}else{%>
                                                    <%=ik+1%>
						<%}%>
                                                </A> &nbsp; 
					<%}
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
				<%}%>
			</TD>
			</TR>
			<%}%>
		</TBODY>
		</table>
		</TD>
		</TR>

			<%}%><%--Fin If--%>
		<%}%><%--Fin for--%>
		<% if(j == 0){ %>
		<TR>
			<TD width="100%">
			<div align=center>
				<FONT face="verdana" size="4">****** No tiene Instrucciones por Atender ******</FONT>
			</div>
			</TD>
		</TR>
	<% } %>
	<%}else{%>
	<%bExiste	= ActualizaInstrucciones.TieneInstruccionesPorAtender(BUsuario.getIdUsuario());
          String strDatos[][] = null;
          strDatos = ActualizaInstrucciones.getSub1(BUsuario.getIdUsuario(), BUsuario.getIdArea());%>
        <%////System.out.println("bExiste: "+bExiste);%>
	<%if(bExiste || (strDatos != null && strDatos.length > 0)){
		
/*                if(AtenderInstrucciones.getTitular(BUsuario.getIdUsuario()))
                    strDatos = */
		
	%>
	<%=ListaInstrucciones.instruccionesPorAtender(	strDatos, 
													BUsuario.getIdUsuario(), 
													BUsuario.getIdArea(),
													BUsuario.getAsistente(),
													strIdUsuario,
													strOrden,
													strTipo,
													contPag,
													contligas,
													regPorPagina,
													muestraPaginas,
													iSAmarillo,
													numRegistros,
													numPaginas,
													bMostrar,
													t,
													strTmp,
													fPorcentaje) %>
	<% } else { %>
	<TR>
		<TD width="100%">
			<div align=center>
				<FONT face="verdana" size="4">****** No tiene Instrucciones por Atender ******</FONT>
			</div>
		</TD>
	</TR>
	<%}%>
	<%}%>
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