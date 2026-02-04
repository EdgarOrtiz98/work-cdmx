<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*"
	import="com.meve.sigma.servlet.*"
	import="com.meve.sigma.actualiza.*"
%>
<%
	String contentUri = application.getInitParameter("content");
	String passContent = application.getInitParameter("user");
	String userContent = application.getInitParameter("passwd");
	String strCM = request.getParameter("cm");
	String strFolio = request.getParameter("Folio");
	String strIdAsunto = request.getParameter("IdAsunto");
	String strIdInstruccion = (request.getParameter("id_ins") != null)?request.getParameter("id_ins"):"";
	String strUrl =	request.getParameter("url");
	String a1 = request.getParameter("a");
	String strIdInst = request.getParameter("id_ins");
	String strActivarCM = application.getInitParameter("ActivarContent");
	String strMessage = request.getParameter("mess");
	String strName = request.getParameter("name");
	String srtExcp = request.getParameter("excp");
        String srtArcRep = request.getParameter("arcrep");
        String srtArcBig = request.getParameter("arcbig");

	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	String strIdUsuario =  BUsuario.getIdUsuario();
	String strRol = BUsuario.getIdRol();
	String content = "";
	String strTmp3 = request.getRequestURI();

	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");

	boolean bValidaEstatus = false;
	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
	if (strIdAsunto!=null && !strIdAsunto.equals("")){
		if (strIdInstruccion!=null && !strIdInstruccion.equals("")){
			if (strEstValidacion.equals("")){
				strEstValidacion = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
			}
			String strEstatusValida = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
			if (!strEstatusValida.equals(strEstValidacion)){ 
				bValidaEstatus = true; 
			}
		}else{
			if (strEstValidacion.equals("")){
				strEstValidacion = ActualizaAsunto.getEstatus(strIdAsunto);
			}
			String strEstatusValida = ActualizaAsunto.getEstatus(strIdAsunto);
			if (!strEstatusValida.equals(strEstValidacion) || strEstValidacion.equalsIgnoreCase("4")){ 
				bValidaEstatus = true; 
			}
		}
	}

	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+strTmp+"?cm="+strCM+"&Folio="+strFolio+"&IdAsunto="+strIdAsunto+"&a="+a1);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}
	try{
		content = statusOCS.statusContent(contentUri, passContent, userContent); 
	}catch(java.rmi.RemoteException ri){
		//System.err.println("Exception="+ri);
	}
	if (strFolio.equals("folio por asignar")){
		strFolio = strIdAsunto;
	}
%>
<%
	String strItemType  =  (application.getInitParameter("ItemType")==null)?"":application.getInitParameter("ItemType");
	String server =	application.getInitParameter("servername");
	String url = request.getRequestURI();
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<TITLE>Importar Archivos</TITLE>

<script type="text/javascript">

function valorRuta(){
	doc = document.insertarCM;
	doc.solicitud_view.value = doc.solicitud_archivo.value;
	doc.rutaArchivo.value = doc.solicitud_archivo.value;

	doc.solicitud_view.focus();
}
//-->
</script>

<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="valida=0;timer_load();"
		onclick="timer_reload()" onkeypress="timer_reload()"
		onmousemove="valorRuta();">

<FORM 	action="../UploadArchivo" name="insertarCM" 
		method="post" enctype="multipart/form-data">
<INPUT name="retURI" value="<%=retURI%>" type="hidden">
<INPUT name="rutaArchivo" value="<%=retURI%>" type="hidden">
<INPUT type="hidden" value="<%=strEstValidacion%>" name="estValidacion">
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%" colspan="2">
			<DIV align="right"></DIV>
			</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<% if(a1.equals("1")){ %>
			<TD width="50"><a href="<%=retURI%>"> <IMG border="0"
				src="../Imagenes/NavLeft.gif" width="32" height="32" title="Regresar"> </a></TD>
			<% }else if(a1.equals("2")){ %>
			<TD width="50"><a href="<%=retURI%>"> <IMG border="0"
				src="../Imagenes/NavLeft.gif" width="32" height="32" title="Regresar"> </a></TD>
			<% }else if(a1.equals("4")){ %>
			<TD width="50"><a href="<%=retURI%>"> <IMG border="0"
				src="../Imagenes/NavLeft.gif" width="32" height="32" title="Regresar"> </a></TD>
			<% }else if(a1.equals("3")){ %>
			<TD width="50"><a href="<%=retURI%>"> <IMG border="0"
				src="../Imagenes/NavLeft.gif" width="32" height="32" title="Regresar"> </a></TD>
			<% }else if(a1.equals("5")){ %>
			<TD width="50"><a href="<%=retURI%>"> <IMG border="0"
				src="../Imagenes/NavLeft.gif" width="32" height="32" title="Regresar"> </a></TD>
			<%}else if(a1.equals("6")){%>
			<TD width="50"><a href="<%=retURI%>"> <IMG border="0"
				src="../Imagenes/NavLeft.gif" width="32" height="32" title="Regresar"> </a></TD>
			<% }%>
			<TD width="50"><a onclick="guardarImportarCM()"> <img
				src="../Imagenes/Save.gif" width="32" border="0" title="Guardar archivo"> </a></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="214"></TD>
		</TR>
		<TR valign="top">
			<TD></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<DIV align="center">
<br>
<br>
<%if(content.equals("activo")){ %>
<TABLE>
<TR valign="top">
		<TD width="183">
			<FONT size="2" color="#004080" face="Arial">Anexar un archivo(Opcional):</FONT>
		</TD>
		<TD colspan="3">
			<!-- <INPUT class="blue500" type="text" name="solicitud_view" onfocus="blur();">-->
			<INPUT  type="file" name="solicitud_archivo" size="50" onkeypress="valorRuta();">
		</TD>
</TR>
</TABLE>	
<%}else { %>
<TABLE>
<TR valign="top">
		<TD width="183">
			<FONT size="2" color="#004080" face="Arial">Anexar un archivo(Opcional):</FONT>
		</TD>
		<TD colspan="3">
			<!-- INPUT class="blue500" type="text" name="solicitud_view" onfocus="blur();"-->
			<INPUT  type="file" name="solicitud_archivo" size="50" onkeypress="valorRuta();">
		</TD>
</TR>
</TABLE>
<%} %>
	
<BR>
<TABLE>
<TR valign="top">
		<TD width="150"><p>
            <label><font size="2" color="#004080" face="Arial">
            <input type="radio" name="optionDoc" value="DP" checked>
            Documento Principal</font></label>
          </p></TD>
		<TD width="160"><p><label><font size="2" color="#004080" face="Arial">
            <input type="radio" name="optionDoc" value="DS">
            Documento Soporte</font></label></p></TD>
</TR>
</TABLE>
</DIV>
<br><br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="183"><B><FONT face="Arial" color="#004080"
				size="2">Documentos Anexados</FONT></B></TD>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="203"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</TR>
		<tr valign="top">
			<td bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</tr>
		<!-- <TR valign="top">
			<TD width="19%">&nbsp;</TD>
			<TD width="31%">&nbsp;</TD>
			<TD width="19%">&nbsp;</TD>
			<TD width="31%">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<c:choose>
				<c:when test='${BEscritura.value}'>
					<TD width="30%">&nbsp;</TD>
					<TD width="20%" align="center">
						<INPUT type="button" class="blue200" value="Agregar Archivo" onclick="agregarContent();">&nbsp;
					</TD>
					<TD width="20%" align="center">
						<INPUT type="button" class="blue200" value="Listado Archivos" onclick="listadoContent();">&nbsp;
					</TD>
					<TD width="50%">&nbsp;</TD>
				</c:when>
				<c:otherwise>
					<TD width="30%">&nbsp;</TD>
					<TD width="20%">&nbsp;</TD>
					<TD width="50%">&nbsp;</TD>
				</c:otherwise>
			</c:choose>
		</TR> -->
		<TR valign="top">
			<TD colspan="4">
				<div>
					<% if(strActivarCM.equals("si")){ %>
					<IFRAME ID="frame1" SRC="ImportarCMO.jsp?IdAsunto=<%=strIdAsunto%>&bo=false&fol=<%=strFolio%>&IdInst=<%=strIdInstruccion%>&mess=<%=strMessage%>&name=<%=strName %>&excp=<%=srtExcp %>" WIDTH="800" HEIGHT="250" frameborder=0></IFRAME> 
					<% }else{ %>
					<IFRAME ID="frame1" SRC="ImportarAR.jsp?IdAsunto=<%=strIdAsunto%>&bo=false&fol=<%=strFolio%>&IdInst=<%=strIdInstruccion%>&mess=<%=strMessage%>&name=<%=strName %>&excp=<%=srtExcp %>" WIDTH="800" HEIGHT="250" frameborder=0></IFRAME>
					<% } %>
				</div>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<input type="hidden" name ="cm" value="<%=strCM%>">
<input type="hidden" name ="Folio" value="<%=strFolio%>">
<input type="hidden" name ="IdAsunto" value="<%=strIdAsunto%>">
<input type="hidden" name ="url" value="<%=strUrl%>">
<input type="hidden" name ="ItemType" value="<%= strItemType%>">
<input type="hidden" name ="accion" value="">
<INPUT type="hidden" name="ActivarCM" value="<%=strActivarCM%>">
<INPUT type="hidden" name="id_ins" value="<%=strIdInstruccion%>">
<INPUT type="hidden" name="a1" value="<%=a1%>">
<INPUT type="hidden" name="server" value="<%=server%>">
<INPUT type="hidden" name="idUsuario" value="<%=strIdUsuario%>">
<INPUT type="hidden" name="uri" value="<%=strTmp3%>">

<script type="text/javascript">
<!--

	<% if (srtArcRep!=null){ %>
		alert("No es permitido guardar archivos con el mismo nombre dentro de un asunto, cambie el nombre del archivo o verifique por favor.");
	<% } %>

	<% if (srtArcBig!=null){ %>
		alert("El archivo no puede ser anexado por ser de un tamaño muy grande, por favor verifique.");
	<% } %>

if (<%= bValidaEstatus %>){
	<% if (strIdInstruccion!=null && !strIdInstruccion.equals("")){ %>
		alert("Esta Instrucción ha sido modificada por otro usuario y cambió su Estatus,\npor lo que la acción solicitada será cancelada");
	<% }else{ %>
		alert("Este Asunto ha sido modificado por otro usuario y cambió su Estatus,\npor lo que la acción solicitada será cancelada");
	<% } %>
	location.assign("portalPrincipal.jsp");
}

function valorRuta(){
	doc = document.insertarCM;
	doc.solicitud_view.value = doc.solicitud_archivo.value;
	doc.rutaArchivo.value = doc.solicitud_archivo.value;

	doc.solicitud_view.focus();
}
//-->
</script>

</FORM>
</BODY>
</HTML>
