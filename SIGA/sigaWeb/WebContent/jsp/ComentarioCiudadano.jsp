<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.reportes.*,com.meve.sigma.actualiza.*,com.meve.sigma.taglib.*"
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
	String strIdComentario	=	"";
	String strIdAsunto		=	"";
	String strComentario	=	"";
	String strFecha			=	"";
	String strAccion		=	"";
	String stridRespuest	=	"";
	String strEstatus		=	"";
	boolean bInsertar		=	false;

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date f 				=	new java.util.Date();
	strFecha		 				=	sdf.format(f);
	
	strAccion	=	request.getParameter("accion");
	strIdAsunto	=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
	if(strAccion != null && strAccion.equals("guardar"))
	{
		strComentario	=	request.getParameter("Comentario1");
		strIdAsunto		=	request.getParameter("id_asunto");
		stridRespuest	=	request.getParameter("tipoRespuesta");
		strEstatus		=	request.getParameter("estatus");
		String strCerrar = "0";
		if(ActualizaCiudadano.getExistenNotificaciones(strIdAsunto)){
			String strIdNotDesctivar = ActualizaCiudadano.getNotificacionDesacticar(strIdAsunto);
			boolean bActualizaActiva = ActualizaCiudadano.actualizaActivarNuevaNot(strIdNotDesctivar);
		}

		boolean bCerrar = false;
		bCerrar = ActualizaEstatus.getCierre(strEstatus);
		if(bCerrar){
			strCerrar = "1";
		}
		int i = 1;
		boolean bInser	=	ActualizaCiudadano.insertarNotificacion(strComentario, strIdAsunto, BUsuario.getNombre(), 
																BUsuario.getCorreo(), strFecha, stridRespuest, strEstatus, strCerrar, "1", i); 
		try{
			response.sendRedirect("AsuntoTurnado.jsp?id_asunto="+strIdAsunto);
		}catch(java.io.IOException io){
			//System.out.println("Erro-->"+io);
		}
	}
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>Comentario Ciudadano</TITLE>
<SCRIPT language=JavaScript type=text/javascript>
	
	function regresar(){
		location.assign('AsuntoTurnado.jsp?id_asunto=<%= strIdAsunto %>');
	}
	
	function guardar(){	
		doc = document.comentarioUCT;
		valida = 0;
		msg="";

		if (doc.tipoRespuesta[doc.tipoRespuesta.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "- Debes seleccionar un tipo de Respuesta	"+ "\n";
		}
		if (doc.estatus[doc.estatus.selectedIndex].value == -1) {
			valida =1;
			msg = msg + "- Debes seleccionar un Estatus para la Respuesta	"+ "\n";
		}
		if (doc.Comentario1.value == "") {
			valida =1;
			msg = msg + "- Debe capturar un comentario para la delegación	"+ "\n";
		}
		if (valida == 1) 
		{
			alert(msg);
		} 
		if (valida != 1)
		{
			doc.accion.value="guardar";
			doc.submit();
		}
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
<FORM action="ComentarioCiudadano.jsp" name="comentarioUCT" method="post">
<INPUT type="hidden" value="guardar" name="accion">
<INPUT type="hidden" value="<%= strIdAsunto %>" name="id_asunto">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%">&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>

<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336" colspan="2">
				<INPUT class="blue100" onclick="regresar()" type="button" value="Cancelar">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<INPUT class="blue100" onclick="guardar()" type="button" value="Aceptar">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="672" bgcolor="#00204f" colspan="4"><FONT size="0"></FONT></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>

<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Arial" color="#004080" size="2">Tipo de Respuesta:</FONT></TD>
			<TD width="528" colspan="3">
				<meve_combo:comboseleccion data="<%= ComboData.getTipoRespuestaCombo() %>" size="1" name="tipoRespuesta" 
						classHtml="blue500" selected="" 
						textoNoSeleccion="-- Selecciona Tipo de Respuesta --" 
						valorNoSeleccion="-1"
						script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Arial" color="#004080" size="2">Estatus a la Respuesta:</FONT></TD>
			<TD width="528" colspan="3">
				<meve_combo:comboseleccion data="<%= ComboData.getEstatusCombo() %>" size="1" name="estatus" 
						classHtml="blue500" selected="" 
						textoNoSeleccion="-- Selecciona el Estatus --" 
						valorNoSeleccion="-1"
						script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Arial" color="#004080" size="2">Comentarios:</FONT></TD>
			<TD width="528" colspan="3">
				<TEXTAREA cols="50" rows="5" class="blue500" name="Comentario1"></TEXTAREA>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>

</FORM>
</BODY>
</HTML>
