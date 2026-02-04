<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<jsp:useBean id="BeanBuscar"
	class="com.meve.sigma.beans.search.BuscarCampo" scope="page">
	<jsp:setProperty name="BeanBuscar" property="*" />
</jsp:useBean>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="com.meve.sigma.beans.*,com.meve.sigma.beans.search.*,com.meve.sigma.actualiza.*,com.meve.sigma.util.*,
			java.util.StringTokenizer,com.meve.sigma.servlet.SearchArchiveByContent,
			java.util.Vector"
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
	String contentUri = application.getInitParameter("content");
	String passContent = application.getInitParameter("user");
	String userContent = application.getInitParameter("passwd");
	String pathContent = (application.getInitParameter("path")==null)?"/vmserver2/SIGA_WS/SIGA_LIB":application.getInitParameter("path");
	String strCreador1 = 	BUsuario.getIdUsuario();
	String strAreaUs	=	BUsuario.getIdArea();
	String[] strBusqueda = null;
	String[] strIdAsunto = null;
	StringTokenizer tokens;
	
	String strContenido = request.getParameter("buscaSobreContenido");
	String strBusquedaContent = request.getParameter("buscaContenido");
	
	if (strBusquedaContent== null || strBusquedaContent == ""){
		strBusquedaContent = "0";
	}
	
	String strResultado[][]	= null;
	String strEstatus = "99";

	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");

	int regPorPagina = 20;
	int muestraPaginas = 20;
	int iSAmarillo = 70;
	String[][] strConfig = com.meve.sigma.actualiza.ActualizaConfiguracion.getDatosConf();
	if(strConfig != null && strConfig.length > 0){
		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
		iSAmarillo		=	Integer.parseInt(strConfig[0][2]);
	}

	int numRegistros = 0;
	int numPaginas = 0;
	
	if(BeanBuscar.getbuscaEstatus() == null || BeanBuscar.getbuscaEstatus().equals("")){
		BeanBuscar 			= (BuscarCampo)session.getAttribute("UsuarioBuscaBean");
		//strResultado 		= (String[][])session.getAttribute("ResultadoBuscar");
		strContenido 		= (String)session.getAttribute("buscaSobreContenido");
		strBusquedaContent 	= (String)session.getAttribute("buscaContenido");
                strResultado = ActualizaBuscar.getBuscarMultiCampoAsunto(
						BeanBuscar, 
						strOrden, strTipo,
						BUsuario.getIdUsuario(),
						BUsuario.getIdArea(),
						strBusquedaContent);
	}//else{

		strResultado = ActualizaBuscar.getBuscarMultiCampoAsunto(
						BeanBuscar, 
						strOrden, strTipo,
						BUsuario.getIdUsuario(),
						BUsuario.getIdArea(),
						strBusquedaContent);	

		if (strBusquedaContent.equals("5")){

			strBusqueda = SearchArchiveByContent.searchByContent1(
								strContenido, strResultado, strAreaUs, contentUri, passContent, userContent, pathContent, "A");  

			if ( strBusqueda!=null && strBusqueda.length>0 && strResultado!=null && strResultado.length>0){
				////System.out.println("busqueda ....." + strBusqueda.length);

				Vector vContenido = new Vector();
				for (int i = 0; i < strBusqueda.length ; i++){

					if (!strBusqueda[i].equals("") && strBusqueda[i].length()>0){
						tokens=new StringTokenizer(strBusqueda[i], "|");
						int nDatos=tokens.countTokens();
						String[] datos=new String[nDatos];		
						int j=0;
					
						while(tokens.hasMoreTokens()){
   			         		String str=tokens.nextToken();
   		        		 	datos[j]=str;
   			         		//System.out.println(datos[j]);
   		    	     		j++;
   		     			}
				
						////System.out.println("  ***************  "+i+".- Folio="+datos[3]+" Archivo="+datos[0]);
						
						for (int k=0; k<strResultado.length; k++){
							if (strResultado[k][0].equals(datos[3]) && strResultado[k][12].equals(datos[0])){
								vContenido.add(strResultado[k]);
							}
						}
						
					}else{
						////System.out.println("  ***************  "+i+"    NADA    ");
					}
				}

				strResultado = new String[vContenido.size()][strResultado[0].length];
				for (int k=0; k<vContenido.size(); k++){
					strResultado[k] = (String[])vContenido.get(k);
				}

			}else {
				strResultado = new String[0][strResultado.length];
				////System.out.println("Sin resultados");
			}
		}

		int iDuracion = 0;
		float fPorcentaje = 0;
		float fAvance = 0;
		String[] semaforo = BeanBuscar.getSemaforoAsunto();
		String strSemaforo = "";
		if (semaforo!=null && semaforo.length>0){
			for (int i=0; i<semaforo.length; i++){
				strSemaforo += semaforo[i];
			}
		}

		if (strResultado!=null && strResultado.length>0){
			Vector vResult = new Vector();

			for (int i=0; i<strResultado.length; i++){
				iDuracion = Utilerias.DiasdeTrabajoEntre(Utilerias.StringCalendar(strResultado[i][9]), Utilerias.StringCalendar(strResultado[i][8]), 0);
				fPorcentaje = Utilerias.getPorcentajeDebido(iDuracion, strResultado[i][9], strResultado[i][8], 5);
				fAvance = new Float(strResultado[i][10]).floatValue();
				if(fPorcentaje>100){
					if (strSemaforo.indexOf('r')!=-1)
						vResult.add(strResultado[i]);				
				}else if(fPorcentaje>=iSAmarillo &&  fPorcentaje<=100){
					if(fPorcentaje<=fAvance){
						if (strSemaforo.indexOf('v')!=-1)
							vResult.add(strResultado[i]);				
					}else{	
						if (strSemaforo.indexOf('a')!=-1)
							vResult.add(strResultado[i]);				
				}
				}else if(fPorcentaje<iSAmarillo){
					if (strSemaforo.indexOf('v')!=-1)
						vResult.add(strResultado[i]);				
				}
			}
		
			strResultado = new String[vResult.size()][strResultado[0].length];
			for (int i=0; i<vResult.size(); i++){
				strResultado[i] = (String[])vResult.get(i);
			}
		}
//	}

	session.setAttribute("UsuarioBuscaBean",BeanBuscar);
	session.setAttribute("ResultadoBuscar",strResultado);
	session.setAttribute("buscaSobreContenido",strContenido);
	session.setAttribute("buscaContenido",strBusquedaContent);

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
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Buscar por Asunto</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script type="text/javascript">
<!--
	function cambio(o, t){
		doc = document.BuscarCampoBean;
		doc.orden.value=o;
		doc.tipo.value=t;
		doc.submit();
	}
	function pagina(contador){
		doc = document.BuscarCampoBean;
		doc.contPag.value=contador;
		doc.submit();
	}
	function paginaLiga(contador){
		doc = document.BuscarCampoBean;
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
<BODY background="../Imagenes/fondo_claro.jpg">
<FORM name="BuscarCampoBean" action="BuscarCampoBean.jsp" method="post">
<INPUT type="hidden" name="orden" value="<%=strOrden %>">
<INPUT type="hidden" name="tipo" value="<%=strTipo %>">
<INPUT type="hidden" value="<%=contPag %>" name="contPag">
<INPUT type="hidden" value="<%=contligas %>" name="contligas">
<INPUT type="hidden" value="<%=strContenido %>" name="buscaSobreContenido">
<INPUT type="hidden" value="<%=strBusquedaContent %>" name="buscaContenido">

<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%">&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
<TBODY>
	<TR>
		<TD width="20%" align="center">
			<INPUT type="button" class="blue200" value="Realizar Otra Busqueda" onclick="regresarBC()">
		</TD>
		<td width="30%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="25%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="25%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
</TBODY>
</table>
</DIV>
<br>

<%	
%>

<DIV align="center">
<table border="0" width="100%">
<TBODY>
	<TR bgcolor="#00204f">
		<TD width="15%">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">
				<a onclick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
				FOLIO DE RECEPCIÓN
				<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
				</FONT></b>
			</CENTER>
		</TD>
		<td width="15%">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">
				<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
				FOLIO DE CONTROL
				<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
				</FONT></b>
			</CENTER>
		</td>
		<td width="30%">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">
				<a onclick="cambio('asc', 3)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
				ASUNTO
				<a onclick="cambio('desc', 3)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
				</FONT></b>
			</CENTER>
		</td>
		<td width="15%">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">
				<a onclick="cambio('asc', 4)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
				FECHA DE CREACIÓN
				<a onclick="cambio('desc', 4)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
				</FONT></b>
			</CENTER>
		</td>
		<td width="25%">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">
				DOCUMENTOS ANEXADOS				
				</FONT></b>
			</CENTER>
		</td>
	</TR>
</TBODY>
</table>
</DIV>
<BR>
<% if(strResultado == null || strResultado.length == 0){ %>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
<TBODY>
	<TR>
		<TD width="383"><b><FONT size="2" color="red" face="Arial">
			No se encontraron Documentos</FONT></b></TD>
		<td width="33"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
</TBODY>
</table>
</DIV>
<% }else{ %>
<DIV class=documentBody id=Body>
<DIV align="center">
<table border="0" width="100%">
<TBODY>
	<TR>			
		<TD align="left" colspan="2">
		<%	numRegistros = strResultado.length;
			if (numRegistros>0){ %>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<A onclick="window.open('../ReporteBeanExcel?tip=busqueda_beanExcel');" title="Exportar a Excel">
			<img src="../Imagenes/ic_excel.gif" border="0"></A>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<A onclick="window.open('../ReporteBeanPDF?tip=busqueda_bean');" title="Exportar a PDF">
			<img src="../Imagenes/ic_pdf.gif" border="0"></A>
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
	<TR><TD><BR></TD></TR>
	<% 	//for(int i=0;i<strResultado.length;i++){ %>
	<%	for (int i=contPag*regPorPagina; i<strResultado.length && i<(contPag+1)*regPorPagina; i++){ %>
	<TR <%if(par(i+1)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
		<TD width="15%">
			<CENTER>
				<FONT size="1" color="#000080" face="Arial">
				<% if(strResultado[i][0].equals("folio por asignar")){ %>
					<a href="AsuntoRecepcion.jsp?id_asunto=<%=strResultado[i][4]%>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&buscaSobreContenido="+strContenido+"&buscaContenido="+strBusquedaContent) %>">			
					<%= strResultado[i][0] %></a>
				<% }else{ %>
					<a href="AsuntoTurnado.jsp?id_asunto=<%=strResultado[i][4]%>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&buscaSobreContenido="+strContenido+"&buscaContenido="+strBusquedaContent) %>">			
					<%= strResultado[i][0] %></a>
				<% } %>
				</FONT>
			</CENTER>
		</TD>
		<td width="15%">
			<CENTER>
				<FONT size="1" color="#000080" face="Arial">
				<%= strResultado[i][11].equals("")?"Sin Folio de Control":strResultado[i][11] %></FONT>
			</CENTER>
		</td>
		<td width="30%">
			<CENTER>
				<FONT size="1" color="#000080" face="Arial">
				<A title="<%=strResultado[i][2]%>" ><%=Utilerias.recortaString(strResultado[i][2],35)%></A></FONT>
			</CENTER>
		</td>
		<td width="15%">
			<CENTER>
				<FONT size="1" color="#000080" face="Arial"><%=strResultado[i][3]%></FONT>
			</CENTER>
		</td>
		<td width="25%">
			<CENTER>
				<% if (strBusquedaContent.equals("5")){ %>
					<FONT size="1" color="#000080" face="Arial">
					<A title="<%= strResultado[i][12] %>">
					<%= Utilerias.recortaString(strResultado[i][12],30) %></A></FONT>
				<% }else{ %>
					<FONT size="1" color="#000080" face="Arial">
					<A title="<%= ActualizaArchivo.getStringNombreArchivos(strResultado[i][4]) %>">
					<%= Utilerias.recortaString(ActualizaArchivo.getStringNombreArchivos(strResultado[i][4]),30) %></A></FONT>
				<% } %>
			</CENTER>
		</td>
	</TR>
	<% } %>
	<TR>
	<TD colspan="5" align="center"><BR>
		<%
		if (contligas>0 && numPaginas > muestraPaginas){ %>
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
</TBODY>
</table>
</DIV>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
<% } %>
</FORM>
</BODY>
</HTML>
