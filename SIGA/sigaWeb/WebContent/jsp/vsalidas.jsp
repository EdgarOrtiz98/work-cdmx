<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_front" prefix="meve_front"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*"
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
	int t = 0;
	String strIdArea = BUsuario.getIdArea();
	bExiste	= ActualizaInstrucciones.getExisteFolioSalida(strIdArea);
	String strAccion = request.getParameter("accion");
	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";

	String strDatos[][] = null;
	if (bExiste)
		strDatos = ActualizaInstrucciones.getFolioSalida(strIdArea, strOrden, strTipo);

	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");

	int regPorPagina = 20;
	int muestraPaginas = 20;
	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
	if(strConfig != null && strConfig.length > 0){
		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
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
<%if(!BUsuario.getTurnado()){%>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<%}%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/link.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<TITLE>Folios de Salida</TITLE>
<script language="JavaScript" type="text/javascript">
	function cambio(o, t){
		doc = document.salidasF;
		doc.accion.value="reload";
		doc.orden.value=o;
		doc.tipo.value=t;
		doc.submit();
	}

	function pagina(contador){
		doc = document.salidasF;
		doc.contPag.value=contador;
		doc.submit();
	}

	function paginaLiga(contador){
		doc = document.salidasF;
		doc.contligas.value=contador;
		doc.submit();
	}

</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<body background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<form method="post" action="vsalidas.jsp" name="salidasF">
<INPUT type="hidden" name="accion" value="">
<INPUT type="hidden" name="PP" value="1">
<INPUT type="hidden" name="orden" value="<%=strOrden %>">
<INPUT type="hidden" name="tipo" value="<%=strTipo %>">
<INPUT type="hidden" value="<%=contPag %>" name="contPag">
<INPUT type="hidden" value="<%=contligas %>" name="contligas">
<table cellspacing="2" cellpadding="2" width="100%">
<TBODY>
	<TR>
		<TD class="etiquetas" width="30%">
			
		</TD>
		<TD class="etiquetas" width="40%" align="center">
			<b><FONT size="3">Folios de Salida</FONT></b>
		</TD>
		<TD class="etiquetas" align="center" width="30%">
			<B>
			<%
			if(bExiste && BUsuario.getTurnado()){

				int numeroPaginas = strDatos.length/regPorPagina;	
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
			<%	}
			}
			%>
			</B>
		</TD>

	</TR>
</TBODY>
</table>
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='30%' align="center">
			<FONT SIZE=2 COLOR="FFFFFF" FACE="verdana">
			<a onclick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Folio de Salida
			<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font></TD>

		<TD WIDTH='40%' align="center">
			<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<FONT SIZE=2 COLOR="FFFFFF" FACE="verdana">Folio del Documento</font>
			<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
		</TD>
		<TD WIDTH='30%' align="center">
			<a onclick="cambio('asc', 3)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<FONT SIZE=2 COLOR="FFFFFF" FACE="verdana">Identificador del Documento</font>
			<a onclick="cambio('desc', 3)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
		</TD>
	</TR>
</TABLE>
<div id="msg"></div>
<DIV class=documentBody id=Body>
<div id="view">
<table width="100%" border="0" cellpadding="2" cellspacing="0">
	<TBODY>
		<% 	int j = 0; %>
		<% 	if (bExiste){

				int numeroPaginas = strDatos.length/regPorPagina;	
				if (strDatos.length%regPorPagina != 0)
					numeroPaginas++;

				for (int i=contPag*regPorPagina; i<strDatos.length && i<(contPag+1)*regPorPagina; i++){
					String campo1 = strDatos[i][0];
					String campo2 = strDatos[i][1];
					String campo3 = strDatos[i][2];
					String campo4 = strDatos[i][3];
					String campo5 = strDatos[i][4];
					if(BUsuario.getTurnado()){
		 				t++; 
		%>
		<tr valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
			<td width='30%' align="center"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="16" title=""><FONT SIZE=2
				FACE="Verdana"> <A href="AsuntoTurnado.jsp?id_asunto=<%= campo2 %>&retURI=<%= strTmp %>"><%= campo1 %></A></Font></td>
			<td width='40%'>
				<div align=center>
					<font size="2" face="Arial"><%=campo4%></font>
				</div>
			</td>
			<td width='30%'>
				<div align=center>
					<font size="2" face="Arial"><%=campo5%></font>
				</div>
			</td>
		</tr>
		<% 				j++;  			
					}	 
		 		} 
		%>
		<% if (BUsuario.getTurnado()){ %>
		<TR>
			<TD colspan="3" align="center"><BR>
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
		<% 	} %>
		<% } %>
		<% if(j == 0){ %>
		<TR>
			<TD width="100%">
			<div align=center><FONT face="Arial" size="4">******No Hay Asuntos con Folio de Salida******</FONT></div>
			</TD>
		</TR>
		<% } %>
	</TBODY>
</table>
</div>
<br>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</form>
</body>
</HTML>
