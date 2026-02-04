<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="true"></jsp:include> 
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<%@ page import="com.meve.sigma.beans.*" %>
<%@ page import="com.meve.sigma.actualiza.*" %>    
<%
	String strIdInstruccion		=	"";
	String strIdAsunto			=	"";
	String strAvance			=	"";
	String strTurnador			=	""; 
	String strNombreInst		=	"";            
	String strA1		=	(request.getParameter("a") != null)?request.getParameter("a"):"";
	strIdInstruccion	=	(request.getParameter("id_ins") != null)?request.getParameter("id_ins"):"";
	strIdAsunto			=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";	
	strTurnador			=	(request.getParameter("tur") != null)?request.getParameter("tur"):"";
	strNombreInst		=	(request.getParameter("ins") != null)?request.getParameter("ins"):"";
	
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp = request.getRequestURI();
	
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+strTmp+"?id_ins="+strIdInstruccion+"&id_asunto="+strIdAsunto+"&tur="+strTurnador+"&ava="+strAvance+"&ins="+strNombreInst);
		}
		catch(java.io.IOException io){
			//System.out.println("E/RROR:"+io.getMessage());
		}
	}
%>
<%
	String strComentario		=	"";
	String strAccion			=	"";
	String strFechaCreacion		=	"";
	String strDireccion 		= 	"";
	
	boolean bInsertarComentario	=	false;
	boolean bActualiza			=	false;
	
	strAccion			=	request.getParameter("accion");
	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
    String retURI2 = (request.getParameter("retURI2")== null)?retURI:request.getParameter("retURI2");

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaCreacion 				=	sdf.format(f);

	java.text.SimpleDateFormat sdf1	=	new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date f1 				=	new java.util.Date();
	String strFecha					=	sdf1.format(f1);
	
	boolean bValidaEstatus = false;
	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
	if (strIdInstruccion!=null && !strIdInstruccion.equals("")){
		if (strEstValidacion.equals("")){
			strEstValidacion = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
		}
		String strEstatusValida = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
		if (!strEstatusValida.equals(strEstValidacion)){ 
			bValidaEstatus = true; 
		}
	}

	if(!bValidaEstatus && strAccion != null && strAccion.equals("guardar"))
	{
		strA1 = request.getParameter("a");
		String strDatosInstrucciones[][]	=	ActualizaInstrucciones.getInstruccionDatos(strIdInstruccion);

		strIdAsunto			=	ActualizaInstrucciones.getIdAsuntoInstruccion(strIdInstruccion);
		strAvance			=	strDatosInstrucciones[0][20];
		strComentario		=	request.getParameter("comentario");	
		
		bInsertarComentario	=	ActualizaHistorial.InsertarComentario(	strIdInstruccion, strIdAsunto,
																	strComentario, BUsuario.getIdUsuario(), 
																	strAvance, strFechaCreacion, BUsuario.getCargo()+" / "+BUsuario.getNombre());
		
		//boolean bInsertaNot	=	ActualizaCiudadano.insertarNotificacion(strComentario, strIdAsunto, BUsuario.getNombre(), 
		//															BUsuario.getCorreo(), strFecha);
		if(strA1.equals("1")){
			strDireccion = "InstruccionesAtender.jsp";
		}else if(strA1.equals("2")){
			strDireccion = "InstruccionTurnada.jsp";
		}else if(strA1.equals("3")){
			strDireccion = "InstruccionHija.jsp";
		}

%>
<SCRIPT language=JavaScript type=text/javascript>
    var url='<%=strDireccion%>?id_ins='+'<%=strIdInstruccion%>'+'&retURI=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(retURI2)%>';
	location.assign(url);
</SCRIPT>
<%

	}
	if(strA1.equals("1")){
		strDireccion = "InstruccionesAtender.jsp";
	}else if(strA1.equals("2")){
		strDireccion = "InstruccionTurnada.jsp";
	}else if(strA1.equals("3")){
		strDireccion = "InstruccionHija.jsp";
	}
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Agregar Comentario</TITLE>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT language="JavaScript" type="text/javascript">
function guardar(){
    forma1=document.forma;
	//valida = 0;
	msg="";
	forma1.id_ins.value='<%=strIdInstruccion%>';
	forma1.id_asunto.value='<%=strIdAsunto%>';
	forma1.tur.value='<%=strTurnador%>';
	forma1.ins.value='<%=strNombreInst%>';
	document.getElementById("btnReasignar").disabled = true;
	if(Trim(forma1.comentario.value)==""){
		valida =1;
		msg = msg + "Debe capturar un comentario"+ "\n";
	}
	if (valida == 1){
		alert(msg);
		valida = 0;
		return false;
	}else if(valida==2){
		alert("Su solicitud ya fue enviada");
		return false;
	}else{
		mensaje = 'Algunos de los campos tienen caracteres invalidos (&, ", <, >, \')\nPresione Aceptar para modificarlos automaticamente\no Cancelar para regresar'
		if(detectaCE(forma1.comentario.value)){
			if (confirm(mensaje)){
				forma1.comentario.value	= quitaCE(forma1.comentario.value);
				forma1.accion.value="guardar";
				forma1.submit();
			}
			else 
				forma1.accion.value="";
		}else{
			forma1.accion.value="guardar";
			valida=2;
			forma1.submit();
		}
	}
}
function regresar(){
    var url='<%= retURI %>';
	location.assign(url);
}
</SCRIPT>

<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load();valida=0;" onKeyPress="timer_reload()" 
	onClick="timer_reload()"
	onMouseMove="limitaTextArea(document.forma.comentario,'Comentario','4000')">
<form action="AgregarComentarioInstruccion.jsp" name="forma" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="" name="id_ins">  
<INPUT type="hidden" value="" name="id_asunto">
<INPUT type="hidden" value="" name="tur">
<INPUT type="hidden" value="" name="ins">
<INPUT type="hidden" value="<%=strA1%>" name="a">
<INPUT name="retURI" value="<%=retURI%>" type="hidden">
<INPUT name="retURI2" value="<%=retURI2%>" type="hidden">
<INPUT type="hidden" value="<%=strEstValidacion%>" name="estValidacion">
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
<DIV align="center">
<TABLE>
	<tr align="left">
		<TD align="left">
			<INPUT class="blue100" type="button" name="cancelarBtn" value="Cancelar" onclick="regresar();">&nbsp;&nbsp;
			<INPUT id="btnReasignar" name="btnReasignar" class="blue100" type="button" name="guardarBtn" value="Guardar" onclick="guardar();">
		</td>
	</tr>
	<tr align="left">
		<td>
			<FIELDSET dir="ltr"><LEGEND align="left">Comentarios de la Instrucción</LEGEND>
			<TEXTAREA cols="80" rows="5" name="comentario" class="blue500"
			onKeyDown="limitaTextArea(document.forma.comentario,'Comentario','4000')"></TEXTAREA>
			</FIELDSET>
		</td>
	</tr>
</TABLE>
</DIV>
<script type="text/javascript">
<!--
if (<%= bValidaEstatus %>){
	alert("Esta Instrucción ha sido modificada por otro usuario y cambió su Estatus,\npor lo que la acción solicitada será cancelada");
	location.assign("portalPrincipal.jsp");
}
//-->
</script>
</form>
</BODY>
</HTML>
