<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
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
	String strIdClaAsunto	=	"";
	String strIdArena		=	"";
	String strTipo			=	"";
	String strUsrActualizo	=	"";
	String strFecha			=	"";
	String strAccion		=	"";

	boolean bInsertar		=	false;

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFecha						=	sdf.format(f);

	strAccion	=	request.getParameter("accion");
	strIdClaAsunto	=	(request.getParameter("id_cla") != null)?request.getParameter("id_cla"):"";

	if(strAccion!=null && strAccion.trim().length()>0)
	{
		if(strAccion != null && strAccion.equals("guardar"))
		{
			//strIdArena		=	request.getParameter("claArea");
			strTipo			=	request.getParameter("claTipo");

			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Remitente
			strTipo		=	(strTipo.length()<= 200) ? strTipo : strTipo.substring(0,200);

			bInsertar		=	ActualizaClasificacion.InsertarClasificacion(strTipo,
																		BUsuario.getIdUsuario(), strFecha);
			try{
				response.sendRedirect("ClasificacionAsuntoView.jsp");
			}catch(java.io.IOException io){
				//System.out.println("Error-->"+io);
			}
		}
		else if(strAccion != null && strAccion.equals("cambiar"))
		{
			//strIdArena		=	request.getParameter("claArea");
			strTipo			=	request.getParameter("claTipo");
			
			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Remitente
			strTipo		=	(strTipo.length()<= 200) ? strTipo : strTipo.substring(0,200);

			bInsertar = ActualizaClasificacion.ActualizarClasificacion(strIdClaAsunto,strTipo,
																	BUsuario.getIdUsuario(), strFecha);
			try{
				response.sendRedirect("ClasificacionAsuntoView.jsp");
			}catch(java.io.IOException io){
				//System.out.println("Error-->"+io);
			}
		}
	}

	if(strIdClaAsunto != null && strIdClaAsunto.trim().length()>0)
	{
		String strDatosClasificacion[][] = ActualizaClasificacion.getDatosClasificacion(strIdClaAsunto);
		//strIdArena		=	strDatosClasificacion[0][0];
		strTipo			=	strDatosClasificacion[0][0];
		strUsrActualizo	=	strDatosClasificacion[0][1];
		strFecha		=	strDatosClasificacion[0][2];
		
	}
	
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Clasificacion Asunto</TITLE>
<SCRIPT language=JavaScript type=text/javascript>
<!-- 

function guardar() { 

	doc = document.clasifi;
	
	valida = 0;
	msg="";

	if (doc.claTipo.value == "") {
		valida =1;
		msg = msg + " Debes seleccionar el Tipo de clasificación de Asunto	"+ "\n";
	}
	
	
	if (valida == 1) 
	{
		alert(msg);
		return false;
	} 
	else if(document.clasifi.id_cla.value != "") 
		document.clasifi.accion.value="cambiar";
	else
	if(document.clasifi.id_cla.value == "")
		document.clasifi.accion.value="guardar";
	document.clasifi.submit();
}
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="ClasificacionAsunto.jsp" name="clasifi" method="post"><INPUT
	type="hidden" value="" name="accion"> <INPUT type="hidden"
	value="<%= strIdClaAsunto %>" name="id_cla">
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="125"><a onclick="history.go(-1);return false;"> <IMG
				border="0" src="../Imagenes/Regresar.gif" width="82" height="26"> </a>
			</TD>
			<TD width="125"><a><img
				src="../Imagenes/Guardar.gif" width="81" border="0"
				onclick="guardar()"></a></TD>
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
				size="2">Clasificación de Asunto</FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<td width="672" bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
			<TD width="528" align="right"><FONT face="Verdana" size="2">Creado
			por: <I><%= BUsuario.getNombre() %> - <%= strFecha %></I></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">Clasificación del
			Asunto:</FONT></TD>
			<TD width="528">
				<INPUT name="claTipo" value="<%=strTipo%>" type="text" class="blue500">
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
