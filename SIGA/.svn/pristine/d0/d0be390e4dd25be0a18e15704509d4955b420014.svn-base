<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
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
	String strIdSubfondo	=	"";
	String strCodigo		=	"";
	String strSeccion		=	"";
	String strUsrActualiza	=	"";
	String strFecha			=	"";
	String strAccion		=	"";

	boolean bInsertar		=	false;
	int valida		=	0;	
	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFecha						=	sdf.format(f);

	strAccion		=	request.getParameter("accion");
	strIdSubfondo	=	(request.getParameter("id_sub") != null)?request.getParameter("id_sub"):"";
	if(strAccion!=null && strAccion.trim().length()>0)
	{
		if(strAccion != null && strAccion.equals("guardar"))
		{
			strSeccion	=	request.getParameter("subSeccion");
			strCodigo	=	request.getParameter("subCodigo");
			bInsertar	=	ActualizaSubfondo.insertarSubfondo(strCodigo, strSeccion,
																strFecha, BUsuario.getIdUsuario());
			try{
				response.sendRedirect("SubFondoView.jsp");
			}catch(java.io.IOException io){
				//System.out.println("Error-->"+io);
			}
		}
		else if(strAccion != null && strAccion.equals("cambiar"))
		{
			strSeccion	=	request.getParameter("subSeccion");
			strCodigo	=	request.getParameter("subCodigo");
			
			bInsertar = ActualizaSubfondo.actualizaSubfondo(strCodigo, strSeccion, strFecha, 
															BUsuario.getIdUsuario(), strIdSubfondo);
			try{
				response.sendRedirect("SubFondoView.jsp");
			}catch(java.io.IOException io){
				//System.out.println("Error-->"+io);
			}
		}
	}
	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
	{
		String strDatosSubfondo[][] = ActualizaSubfondo.getSubfondo(strIdSubfondo);
		strCodigo		=	strDatosSubfondo[0][0];
		strSeccion		=	strDatosSubfondo[0][1];
		strFecha		=	strDatosSubfondo[0][2];
		strUsrActualiza	=	strDatosSubfondo[0][3];
		
		valida	=	ActualizaExpArchivado.getValidaExpedienteArch(strIdSubfondo);
	}
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
<TITLE>Subfondos</TITLE>
<STYLE type=text/css>
	BODY {
		margin: 0px;
	}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="setFormFocusSubFondo()">
<FORM action="Subfondo.jsp" name="subfondo1" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%=strIdSubfondo%>" name="id_sub">
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="125"><a onclick="history.go(-1);return false;"> <IMG
				border="0" src="../Imagenes/Regresar.gif" width="82" height="26"> </a>
			</TD>
			<TD width="125"><a><img
				src="../Imagenes/Guardar.gif" width="81" border="0"
				onclick="GuardarSubfondo()"></a></TD>
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
				size="2">SubFondos</FONT></B></TD>
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
			<% if(strIdSubfondo != null && strIdSubfondo.trim().length()>0){ %>
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
			Código:</FONT></TD>
			<TD width="528">
				<INPUT name="subCodigo" value="<%=strCodigo%>" type="text" class="blue100">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">
			Secciones:</FONT></TD>
			<TD width="528">
				<INPUT name="subSeccion" value="<%=strSeccion%>" type="text" class="blue500">
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
