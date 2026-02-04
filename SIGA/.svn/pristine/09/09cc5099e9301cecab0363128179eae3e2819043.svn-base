<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerCiudadano.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*"
%>
<%
	BeanCiudadano BCiudadano = (BeanCiudadano)session.getAttribute("CiudadanoBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+11,strTmp.length());
	if(BCiudadano==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}
	String strIdSol = "";
	String strFecha = "";
	String strAccion = "";
	String strRespuesta = "";
	strIdSol = request.getParameter("id_solicitud");

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date f 				=	new java.util.Date();
	strFecha		 				=	sdf.format(f);
	
	strAccion	=	request.getParameter("accion");
	//strIdAsunto	=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
	if(strAccion != null && strAccion.equals("guardar"))
	{
		strRespuesta	=	request.getParameter("respuesta");
		strIdSol		=	request.getParameter("id_solicitud");
		//stridRespuest	=	request.getParameter("tipoRespuesta");
		int i = 0;
		boolean bInsertar	=	ActualizaCiudadano.insertarNotificacion(strRespuesta, strIdSol, BCiudadano.getNombre(), 
																BCiudadano.getMail(), strFecha, null, null, null, "0", i);
		
		try{
			response.sendRedirect("DetalleRespuesta.jsp?id_solicitud="+strIdSol);
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
<LINK href="../css/calendar.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>Responder.jsp</TITLE>
<SCRIPT language=JavaScript type=text/javascript>
	
	function regresar(){
		location.assign('DetalleRespuesta.jsp?id_solicitud=<%= strIdSol %>');
	}
	
	function guardar(){	
		doc = document.responder;
		valida = 0;
		msg="";

		if (doc.respuesta.value == "") {
			valida =1;
			msg = msg + "- Debe capturar una Respuesta	"+ "\n";
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
<BODY background="../Imagenes/fondo_claro.jpg">
<FORM name="responder" action="Responder.jsp" method="post">
<INPUT name="accion" value="" type="hidden">
<INPUT name="id_solicitud" value="<%=strIdSol%>" type="hidden">
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
			<TD width="144"><FONT face="Arial" color="#004080" size="2">Responder:</FONT></TD>
			<TD width="528" colspan="3">
				<TEXTAREA cols="50" rows="5" class="blue500" name="respuesta"></TEXTAREA>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>
