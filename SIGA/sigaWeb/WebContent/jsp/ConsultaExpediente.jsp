<jsp:useBean id="BAreaView" class="com.meve.sigma.beans.BeanAreaView" scope="page">
	<jsp:setProperty name="BAreaView" property="*" />
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%> 
<HTML>
<HEAD>
<TITLE>Consulta Expediente</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,com.meve.sigma.taglib.*, java.util.Vector"%>
<%@ page import="com.meve.sigma.util.*,java.util.*"%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	String 	cat	= BUsuario.getCatArchivado();
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}

%>
<% if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<%
	boolean bOperacion = false;
	boolean bMostrar   = false;
	int t = 0;

	String strClaveExp = (request.getParameter("claveExp") != null)?request.getParameter("claveExp"):"";
	String strDenomExp = (request.getParameter("denomExp") != null)?request.getParameter("denomExp"):"";


	String strIdArea = (request.getParameter("idExp") != null)?request.getParameter("idExp"):"0";
	String strAccion = "";
	String strIds_Borrar[] = null;

	strAccion = request.getParameter("accion");
	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
	String strpasa[][] = null;

	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");
	String strIdUsuario = (request.getParameter("idUs")!=null)?request.getParameter("idUs"):"0";
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
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<SCRIPT language="JavaScript" src="../js/GeneralFunctions.js"></SCRIPT>
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT language=JavaScript type=text/javascript>
function reload() {
	doc = document.Consulta;
	val = doc.idExp.value;
	if(val=="")
	{
		return false;
	}
	doc.accion.value="reload";
	doc.idUs.value=0;
	doc.contPag.value=0;
	doc.contligas.value=0;
	doc.submit();
}
function cambio(o, t){
	doc = document.Consulta;
	doc.orden.value=o;
	doc.tipo.value=t;
	doc.submit();
}
function pagina(contador){
	doc = document.Consulta;
	doc.contPag.value=contador;
	doc.submit();
}

function paginaLiga(contador){
	doc = document.Consulta;
	doc.contligas.value=contador;
	doc.submit();
}

function desplegar(id){
	doc = document.Consulta;
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

</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="timer_load();" onKeyPress="timer_reload();" 
	onClick="timer_reload();">
<span id="ruler" style="visibility:hidden;"></span> 
<FORM action="ConsultaExpediente.jsp" name="Consulta" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" name="orden" value="<%= strOrden %>">
<INPUT type="hidden" name="tipo" value="<%= strTipo %>">
<INPUT type="hidden" value="<%= strIdUsuario %>" name="idUs">
<INPUT type="hidden" value="<%= contPag %>" name="contPag">
<INPUT type="hidden" value="<%= contligas %>" name="contligas">

<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="100%" bgcolor="#00204f"><img src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>

<TABLE width="100%">
		<TR>      
			<TD class="etiquetas" align="right" width="30%"><b>Expediente:</b></TD>
			<TD align="left" width="70%">
				<% if(BUsuario.getSupervisor()){ %>
				<SELECT name="idExp" class="blue500" onKeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()" onchange="reload()">
					<OPTION value="todoexp" <%=(strIdArea.trim().equals("todoexp")?"selected":"")%>>-- Todos Expedientes --</OPTION>
					<OPTION value="sinexp" <%=(strIdArea.trim().equals("sinexp")?"selected":"")%>>-- Expedientes sin Asuntos --</OPTION>
					<OPTION value="todo" <%=(strIdArea.trim().equals("todo")?"selected":"")%>>-- Expedientes con Asuntos --</OPTION>
					<OPTION value="sin" <%=(strIdArea.trim().equals("sin")?"selected":"")%>>-- Asuntos sin Expediente  --</OPTION>
				</SELECT>
				<%}else{%>
			
				<SELECT name="idExp" class="blue500" onKeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()" onchange="reload()">
					<OPTION value="todoexp" <%=(strIdArea.trim().equals("todoexp")?"selected":"")%>>-- Todos Expedientes --</OPTION>
					<OPTION value="sinexp" <%=(strIdArea.trim().equals("sinexp")?"selected":"")%>>-- Expedientes sin Asuntos --</OPTION>
					<OPTION value="todo" <%=(strIdArea.trim().equals("todo")?"selected":"")%>>-- Expedientes con Asuntos --</OPTION>
					<OPTION value="sin" <%=(strIdArea.trim().equals("sin")?"selected":"")%>>-- Asuntos sin Expediente  --</OPTION>
				</SELECT>
				<%}%>
			</TD>
                </tr>
                <tr>
			<TD class="etiquetas" align="right" width="30%"><b>Clave:</b></TD>
			<TD align="left" width="70%">
                            <INPUT id="claveExp"  name="claveExp" type="text" style="width:100%">
			</TD>
                </tr>
                <tr>
			<TD class="etiquetas" align="right" width="30%"><b>Denominación:</b></TD>
			<TD align="left" width="70%">
                            <INPUT id="denomExp"  name="denomExp" type="text" style="width:100%">
			</TD>
                </tr>
                <tr>
			<TD class="etiquetas" colspan=2 align="center" width="100%">
                            <INPUT id="execFilter"  name="execFilter" type="button" onclick="submit()" value="Buscar...">
                        </TD>
		</TR>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
<TBODY>
	<TR valign="top">
		<TD width="43%" align="left">
			<A href="Archivado.jsp">
			<IMG border="0" title="Regresar" src="../Imagenes/NavLeft.gif" width="30" height="27">
			</A>
		</TD>
		<TD width="57%" align="right" valign="middle">
		<%	String[][] num = ActualizaExpArchivado.getporExpediente_Consulta(strIdArea, strOrden, strTipo, strClaveExp, strDenomExp, BUsuario.getIdArea());
			for (int i=0; i<num.length; i++){
			String regis = num[i][2];
			if (BUsuario.getAdmon() || BUsuario.getIdArea().equals(regis) || cat.equalsIgnoreCase("1"))
				{numRegistros = numRegistros + 1;
				}
			}
%>
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
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
<TBODY align="center">
	<TR bgcolor="#00204f">
		<TD align="center" >&nbsp;
					<FONT size="2" color="white" face="verdana">CATALOGO DE CONSULTAS DE EXPEDIENTES POR ASUNTO</FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="100%" colspan="2"></TD>
    </TR>
</TABLE>
<TABLE width="100%" border="0">
		<TR bgcolor="#00204f">
			<TD width="25%" align="center">
			<a onclick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Expediente</FONT></b>
			<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
			<TD id="Asunto_HD" width="15%" align="center">
			<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Asunto</FONT></b>
			<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
			<TD id="Asunto_HD2" width="15%" align="center">
			<a onclick="cambio('asc', 4)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Identificador</FONT></b>
			<a onclick="cambio('desc', 4)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
			<TD id="Asunto_HD3" width="15%" align="center">
			<a onclick="cambio('asc', 4)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Folio Recepción</FONT></b>
			<a onclick="cambio('desc', 4)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
			<TD id="Asunto_HD4" width="15%" align="center">
			<a onclick="cambio('asc', 4)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Folio Control</FONT></b>
			<a onclick="cambio('desc', 4)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
			<TD width="15%" align="center">
			<a onclick="cambio('asc', 4)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Fecha del Documento</FONT></b>
			<a onclick="cambio('desc', 4)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>						
		</TR>
</TABLE>
<BR>
<%if(strIdArea.length() != 0){%>
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0"> 
	<% int j = 0; %>
		<%	String[][] sql = ActualizaExpArchivado.getporExpediente_Consulta(strIdArea, strOrden, strTipo, strClaveExp, strDenomExp, BUsuario.getIdArea());
			for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
				String Lista1 = sql[i][0];
				String Lista2 = sql[i][1];
				String Lista3 = sql[i][2];
		%>
		<% 		bMostrar = strIdUsuario.equals(Lista1);
		 if (BUsuario.getAdmon() || Lista3.equals(BUsuario.getIdArea()) || cat.equalsIgnoreCase("1")){ 
		%>

			<tr>
				<td colspan="4" width="800">
					<a onClick="desplegar(<%=Lista1%>)" title="<%=Lista2%>">
					<img src="../Imagenes/<%=(bMostrar)?"collapse.gif":"expand.gif"%>" border="0" height="16" width="16"></a>&nbsp; 
					<% if(strIdArea.equals("sin")){ %>
						<%=Utilerias.recortaString(Lista2,45)%>
					<% }else{ %>
						<A 	href="ExpedienteArch.jsp?id_sub=<%= Lista1 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&idUs="+strIdUsuario+"&idExp="+strIdArea) %>"
							title="<%=Lista2%> (detalle)">
						<%=Utilerias.recortaString(Lista2,45)%></A> 
					<% } %>
				</td>
			</tr>
			<%}
			
			if(strIdUsuario.equals(Lista1)){ %>
			
			<%if(ActualizaExpArchivado.getporExpedienteAsunto(Lista1, strOrden, strTipo) != null
			&& ActualizaExpArchivado.getporExpedienteAsunto(Lista1, strOrden, strTipo).length > 0) {%>
			<meve_front:ListaDatos
				datos="<%= ActualizaExpArchivado.getporExpedienteAsunto(Lista1, strOrden, strTipo)%>" campo="usuario">
			
			<% if ( BUsuario.getAdmon() || usuario9.equals(BUsuario.getIdArea()) || cat.equalsIgnoreCase("1")){ %>
			<% t++; %>
			<TR valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
			<TD width="100%">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="25%" align="center"><FONT face=Arial color=#000080 size=1>
					<%=usuario2%>
					</FONT></td>
					<td width="15%" align="center">
					<!-- <a href="AsuntoTurnado.jsp?id_asunto=<%= usuario1 %>" title="<%=usuario3%>"><%=com.meve.sigma.util.Utilerias.recortaString(usuario3,20)%></a> -->
					<a title="<%=usuario3%>"><script> document.write(trunc('<%=usuario3%>','Asunto_HD'));</script></a>
					</td>
					<td width="15%" align="center">
					<a title="<%=usuario4%>"><script> document.write(trunc('<%=usuario4%>','Asunto_HD2'));</script></a>
					</td>
					<td width="15%" align="center">
					<a title="<%=usuario6%>"><script> document.write(trunc('<%=usuario6%>','Asunto_HD3'));</script></a>
					</td>
					<td width="15%" align="center">
					<a title="<%=usuario7%>"><script> document.write(trunc('<%=usuario7%>','Asunto_HD4'));</script></a>
					</td>
					<td width="15%" align="center">
					<%=usuario8%>
					</td>
				</tr>
			</table>
			</TD> 
		</TR>
		<%}%>
		</meve_front:ListaDatos>
		<% }
		 }%>
		<% j++; %>
		<% } %>
		<% if(j == 0){ %>
		<TR>
				<TD width="100%">
				<div align=center><FONT face="verdana" size="4">******No Hay Expedientes
				para el Área******</FONT></div>
				</TD>
		</TR>
	<% }else{ %>
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
				<A onclick="paginaLiga(<%= contligas+muestraPaginas %>);pagina(<%= contligas+muestraPaginas %>);"> <B> | Siguiente&gt;&gt;</B> </A>
		<%	
			} %>
		</TD>
		</TR>
	<% } %>
</TABLE>
<%}%>
<br>

<BR>
</FORM>
</BODY>
</HTML>
</jsp:useBean>