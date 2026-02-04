<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<jsp:useBean id="BeanBuscar"
	class="com.meve.sigma.beans.search.BuscarCampoIns" scope="page">
	<jsp:setProperty name="BeanBuscar" property="*" />
</jsp:useBean>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*"
	import="com.meve.sigma.beans.*,com.meve.sigma.beans.search.*, com.meve.sigma.servlet.SearchArchiveByContent, com.meve.sigma.util.*"
%>
<%
	if(BeanBuscar.getbuscaEstatus() == null || BeanBuscar.getbuscaEstatus().equals("")){
		BeanBuscar = (BuscarCampoIns)session.getAttribute("UsuarioBuscaBeanIns");
		////System.out.println("entró-"+BeanBuscar);
	}

	String[] strBusqueda = null;
	String[] strIdAsunto = null;
	StringTokenizer tokens;

	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");

	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
	
	String strAsunto	=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
	String contentUri = application.getInitParameter("content");
	String passContent = application.getInitParameter("user");
	String userContent = application.getInitParameter("passwd");
	String pathContent = application.getInitParameter("path");
	String strContent	 = request.getParameter("buscaContenido");

	String strCreador1 = 	BUsuario.getIdUsuario();
	String strAreaUs	=	BUsuario.getIdArea();

	//System.out.println(  " --- " + strCreador1 + " "  +  strAreaUs );

	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+strTmp+"?id_asunto="+strIdAsunto);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}
	
%>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<SCRIPT language=JavaScript type=text/javascript>
	function BurcarArchivos(){

		var form = document.buscarArchivo;

		if ( form.buscaContenido.value == "" ){
			alert("Introduzca un criterio de busqueda");
		}else
			form.submit();
	}

	function regresarBuscar(){ 
		location.assign('BuscarArchivos.jsp');
	}
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<TITLE>BuscarArchivos.jsp</TITLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM method="post" action="BuscarArchivos.jsp" name="buscarArchivo">
<INPUT name="usuarioSiga" value="<%=strCreador1%>" type="hidden">
<INPUT name="areaSiga" value="<%=strAreaUs%>" type="hidden">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%">&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">
<TABLE border="0" cellspacing="0" cellpadding="0">
	<TBODY>
		<tr valign="top">
			<td width="208"><input type="button" onclick="regresarBuscar()"
				value="Limpiar Pantalla" class="blue200">&nbsp;</td>
			<td width="208"><input type="button" onclick="BurcarArchivos()" 
				value="Buscar" class="blue100"></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380" align="right"></td>
		</tr>
	</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<TBODY>
		<tr valign="top">
			<td width="393"><b><font size="2" color="#004080" face="Arial">B&uacute;squeda de archivos por contenido</font></b></td>
			<td width="23"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</tr>
	</TBODY>
</table>
</DIV>
<BR>
<DIV class=documentBody id=Body>
<DIV align="center">
	<TABLE>
		<TR>
		<TD width="163" height="34">
			<font size="2" color="#004080" face="Arial">Contenido:</font><BR>
		</TD>	
		<TD width="700" height="34">
			<input name="buscaContenido" onkeydown="" value="" class="blue500" maxlength="199"> 
		</TD>
		</TR>
	</TABLE>
	<BR>
	<BR>
<% if (strContent != null){ %>  
	<TABLE border="0" >
			<TR bgcolor="#00204f">
				<TH width="216">
				<CENTER><b><FONT size="1" color="white" face="verdana">UBICACIÓN</FONT></b>
				</CENTER>
				</TH>
				<TH width="216">
				<CENTER><b><FONT size="1" color="white" face="verdana">NOMBRE</FONT></b></CENTER>
				</TH>
				<TH width="216">
				<CENTER><b><FONT size="1" color="white" face="verdana">TAMAÑO</FONT></b></CENTER>
				</TH>
				<TH width="216">
				<CENTER><b><FONT size="1" color="white" face="verdana">FECHA DE CREACIÓN</FONT></b>
				</CENTER>
				</TH>
			</TR>
<%
	strBusqueda = SearchArchiveByContent.searchByContent(strContent, strCreador1, strAreaUs, contentUri, passContent, userContent, pathContent);

	if ( strBusqueda.length > 0 || strBusqueda != null ){
		////System.out.println("busqueda ....." + strBusqueda.length);

		for (int i = 0; i < strBusqueda.length; i++){

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
				
				strIdAsunto = SearchArchiveByContent.searchIdFolioAsunto(datos[0]);
				////System.out.println("Datos procesados ....  jsp " + strIdAsunto.length);

				for (int x = 0; x < datos.length; x++){

					////System.out.println("Datos procesados .... " + datos[x]);

				}
%>
			<TR>
				<TD width="216">
				<CENTER><b>
				<A href="AsuntoTurnado.jsp?id_asunto=<%= strIdAsunto[0] %>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?buscaContenido="+strContent) %>">
				<FONT size="1" face="verdana"><%=strIdAsunto[1] %></FONT></b>
				</CENTER>
				</TD>
				<TD width="216">
				<CENTER><b><FONT size="1" face="verdana"><%=datos[0] %></FONT></b></CENTER>
				</TD>
				<TD width="216">
				<CENTER><b><FONT size="1" face="verdana"><%=datos[1] %>B</FONT></b></CENTER>
				</TD>
				<TD width="216">
				<CENTER><b><FONT size="1" face="verdana"><%=datos[2] %></FONT></b>
				</CENTER>
				</TD>
			</TR>
<%
		}}
		if ( strBusqueda.length == 0 || strBusqueda == null ) {
%>	
	<TR>
		<TD colspan="4"> <BR> <CENTER><b> NO SE ENCONTRARÓN ARCHIVOS CON ESTE CRITERIO </b></CENTER></TD>
				
	</TR>

	
	</TABLE>
<%}}%>

</DIV>
<br>
</DIV>
<br>
</FORM>
</BODY>
</HTML> 
