<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,com.meve.sigma.taglib.*"
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
<% if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ %>
<jsp:forward page="../Error/ERUsuarioInvalido.jsp"></jsp:forward>
<% } %>
<%
	String idSeccion		=	"";
	String idSubfondo		=	"";
	String strCodigo		=	"";
	String strSerie			=	"";
	String strUsrActualiza	=	"";
	String strFecha			=	"";
	String strAccion		=	"";

	boolean bInsertar		=	false;
	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFecha						=	sdf.format(f);

	strAccion		=	request.getParameter("accion");
	idSeccion		=	(request.getParameter("id_sec") != null)?request.getParameter("id_sec"):"";
	if(strAccion!=null && strAccion.trim().length()>0)
	{
		if(strAccion != null && strAccion.equals("guardar"))
		{
			strSerie	=	request.getParameter("secSerie");
			strCodigo	=	request.getParameter("secCodigo");
			idSubfondo	=	request.getParameter("secSubfondo");

			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Seccion
			strSerie	=	(strSerie.length()<= 500) ? strSerie : strSerie.substring(0,500);
			strCodigo	=	(strCodigo.length()<= 50) ? strCodigo : strCodigo.substring(0,50);

			bInsertar	=	ActualizaSeccion.insertarSeccion(	strCodigo, strSerie, idSubfondo,
																strFecha, BUsuario.getIdUsuario());
			try{
				response.sendRedirect("SeccionView.jsp");
			}catch(java.io.IOException io){
				//System.out.println("Error-->"+io);
			}
		}
		else if(strAccion != null && strAccion.equals("cambiar"))
		{
			strSerie	=	request.getParameter("secSerie");
			strCodigo	=	request.getParameter("secCodigo");
			idSubfondo	=	request.getParameter("secSubfondo");
			
			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Seccion
			strSerie	=	(strSerie.length()<= 500) ? strSerie : strSerie.substring(0,500);
			strCodigo	=	(strCodigo.length()<= 50) ? strCodigo : strCodigo.substring(0,50);

			bInsertar = ActualizaSeccion.actualizaSeccion(	strCodigo, strSerie, idSubfondo, strFecha, 
															BUsuario.getIdUsuario(), idSeccion);
			try{
				response.sendRedirect("SeccionView.jsp");
			}catch(java.io.IOException io){
				//System.out.println("Error-->"+io);
			}
		}
	}
	if(idSeccion != null && idSeccion.trim().length()>0)
	{
		String strDatosSeccion[][] = ActualizaSeccion.getSeccion(idSeccion); 
		strCodigo		=	strDatosSeccion[0][0];
		strSerie		=	strDatosSeccion[0][1];
		idSubfondo		=	strDatosSeccion[0][2];
		strFecha		=	strDatosSeccion[0][3];
		strUsrActualiza	=	strDatosSeccion[0][4];
		
	}
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Sección</TITLE>
<STYLE type=text/css>
	BODY {
		margin: 0px;
	}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="Seccion.jsp" name="seccion1" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%=idSeccion%>" name="id_sec">
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="125"><a onclick="location.assign('SeccionView.jsp');"> <IMG
				border="0" src="../Imagenes/Regresar.gif" width="82" height="26"> </a>
			</TD>
			<TD width="125"><a><img
				src="../Imagenes/Guardar.gif" width="81" border="0"
				onclick="GuardarSeccion()"></a></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="48"></TD>
		</TR>
		<TR valign="top">
			<TD></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>


<DIV class="documentBody" id="Body" style="HEIGHT: 441px">
<DIV align="center">
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336" colspan="2"><B><FONT face="Verdana" color="#00204f"
				size="2">Sección</FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="672" bgcolor="#00204f" colspan="4"><FONT size="1">&nbsp;</FONT></TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
			<% if(idSeccion != null && idSeccion.trim().length()>0){ %>
			<TD width="528" align="right"><FONT face="Verdana" size="2">Creado
			por: <I><%=ActualizaUsuario.NombreUsuario(strUsrActualiza)%> - <%= strFecha %></I></FONT>
			</TD>
			<% }else{ %>
			<TD width="528" align="right"><FONT face="Verdana" size="2">Creado
			por: <I><%= BUsuario.getNombre() %> - <%= strFecha %></I></FONT>
			</TD>
			<% } %>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">
			Subfondo:</FONT></TD>
			<TD width="528">
				<meve_combo:comboseleccion data="<%= ComboData.getSubFondoCombo() %>" 
					size="1" name="secSubfondo" classHtml="blue500" 
					selected="<%=idSubfondo%>" textoNoSeleccion="-- Seleccione un Subfondo --" 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">
			Código:</FONT></TD>
			<TD width="528">
				<INPUT name="secCodigo" value="<%=strCodigo%>" type="text" class="blue100">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">
			Serie:</FONT></TD>
			<TD width="528">
				<INPUT name="secSerie" value="<%=strSerie%>" type="text" class="blue500">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<BR>
<BR>
</DIV>
</DIV>
</DIV>

</FORM>
</BODY>
</HTML>
