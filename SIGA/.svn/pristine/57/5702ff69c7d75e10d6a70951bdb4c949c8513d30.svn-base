<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.reportes.*"
	import="com.meve.sigma.actualiza.*"
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
	boolean bInsertar		=	false;

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date f 				=	new java.util.Date();
	strFecha		 				=	sdf.format(f);
	
	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
	strAccion	=	request.getParameter("accion");
	strIdAsunto	=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";

	boolean bValidaEstatus = false;
	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
	if (strIdAsunto!=null && !strIdAsunto.equals("")){
		if (strEstValidacion.equals("")){
			strEstValidacion = ActualizaAsunto.getEstatus(strIdAsunto);
		}
		String strEstatusValida = ActualizaAsunto.getEstatus(strIdAsunto);
		if (!strEstatusValida.equals(strEstValidacion) || strEstValidacion.equalsIgnoreCase("4")){ 
			bValidaEstatus = true; 
		}
	}

	if(!bValidaEstatus && strAccion != null && strAccion.equals("guardar"))
	{
		strComentario	=	request.getParameter("Comentario1");
		strIdAsunto		=	request.getParameter("id_asunto");
		//stridRespuest	=	request.getParameter("tipoRespuesta");
		bInsertar		=	ActualizaComentario.InsertarEventoResponder(strComentario, BUsuario.getIdUsuario(), 
																		strFecha, strIdAsunto, BUsuario.getCargo());
		
		try{
			//response.sendRedirect("AsuntoTurnado.jsp?id_asunto="+strIdAsunto);
			response.sendRedirect(retURI);
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
<TITLE>Comentarios</TITLE>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT language=JavaScript type=text/javascript>
	

	function regresar(){
		//location.assign('AsuntoTurnado.jsp?id_asunto=<%= strIdAsunto %>');
		location.assign('<%= retURI %>');
	}
	
    function guardar(){	
        document.getElementById("btnAceptar").disabled = true;
    
        doc = document.comentario;
        valida = 0;
        msg="";

        mensaje = 'Algunos de los campos tienen caracteres invalidos (&, ", <, >, \', `, ´)\nPresione Aceptar para modificarlos automaticamente\no Cancelar para regresar'
        
        if(detectaCE(doc.Comentario1.value)){
            if (confirm(mensaje)){
                    doc.Comentario1.value	= quitaCE(doc.Comentario1.value);
                    doc.accion.value="guardar";
            }
            else 
                        doc.accion.value="";
        }
        else{
                doc.accion.value="guardar";
        }
    
        if (Trim(doc.Comentario1.value) == "") {
                valida =1;
                msg = msg + "Debe capturar un comentario para el Asunto	"+ "\n";
        }
    
        if (valida == 1) 
        {
                alert(msg);
                return false;
        }
    
        doc.submit();
    }
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()"
	onMouseMove="limitaTextArea(document.comentario.Comentario1,'Comentario','4000')">
<FORM action="Comentarios.jsp" name="comentario" method="post">
<INPUT type="hidden" value="guardar" name="accion">
<INPUT type="hidden" value="<%= strIdAsunto %>" name="id_asunto">
<INPUT name="retURI" value="<%=retURI%>" type="hidden">
<INPUT type="hidden" value="<%=strEstValidacion%>" name="estValidacion">
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
				<INPUT id="btnAceptar" name="btnAcertar()" class="blue100" onclick="guardar()" type="button" value="Aceptar">
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
			<TD width="144"><FONT face="Arial" color="#004080" size="2">Comentarios:</FONT></TD>
			<TD width="528" colspan="3">
				<TEXTAREA cols="50" rows="5" class="blue500" name="Comentario1"
				onKeyDown="limitaTextArea(document.comentario.Comentario1,'Comentario','4000');"></TEXTAREA>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<script type="text/javascript">
<!--
if (<%= bValidaEstatus %>){
	alert("Este Asunto ha sido modificado por otro usuario y cambió su Estatus,\npor lo que la acción solicitada será cancelada");
	location.assign("portalPrincipal.jsp");
}
//-->
</script>
</FORM>
</BODY>
</HTML>
