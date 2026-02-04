<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,java.util.*"
%>
<%@ page import="com.meve.sigma.util.*" %>
<%@ page import="javax.mail.MessagingException" %>
<%@ page import="java.io.UnsupportedEncodingException" %>

<%
	String strIdAsunto			=	"";
	String strIdInstruc			=	"";
	String strAvance			=	"";
	String strUsuarioOriginal	=	"";
	
	strIdInstruc			=	(request.getParameter("id_ins") != null)?request.getParameter("id_ins"):"";
	strIdAsunto				=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
	strAvance				=	(request.getParameter("ava") != null)?request.getParameter("ava"):"";
	strUsuarioOriginal		=	(request.getParameter("usr_ori") != null)?request.getParameter("usr_ori"):"";
	
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp = request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+strTmp+"?id_ins="+strIdInstruc+"&id_asunto="+strIdAsunto+"&ava="+strAvance+"&usr_ori="+strUsuarioOriginal);
		}
		catch(java.io.IOException io){
			//System.out.println("E/RROR:"+io.getMessage());
		}
	}
%>
<%
	String strIdUsuario			=	"";
	String strComentarios		=	"";
	String strAccion			=	"";
	String strFechaCreacion		=	"";
	
	boolean bDelegar		=	false;
	boolean bInsertar		=	false;
	boolean bInsertarBit	=	false;
	
	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaCreacion 				=	sdf.format(f);
	
	String strIdAreaUs		=	BUsuario.getIdArea();
	String strIdUsrDelega	=	BUsuario.getIdUsuario();
	strAccion				=	request.getParameter("accion");

	if(strAccion != null && strAccion.equals("guardar"))
	{
		strIdInstruc	=	request.getParameter("id_ins");
		strIdAsunto		=	request.getParameter("id_asunto");
		strAvance		=	request.getParameter("ava");
		strIdUsuario	=	request.getParameter("delegarUsr");
		strComentarios	=	request.getParameter("delegarComentario");
		strUsuarioOriginal	=	request.getParameter("usr_ori");
		  
		bInsertar		=	ActualizaHistorial.InsertarDelegar(	strIdInstruc, strIdAsunto, strComentarios,
																strUsuarioOriginal, strFechaCreacion, BUsuario.getCargo()+" / "+BUsuario.getNombre());
		 
		bDelegar		=	ActualizaInstrucciones.ActualizaDelegar(strIdInstruc, strAvance, strIdUsuario);
		
		String strFolioBit = ActualizaInstrucciones.getUltimoFolioTurnado(strIdInstruc);
		bInsertarBit	=	ActualizaBitacora.InsertarEventoDelegar(BUsuario.getIdUsuario(), strFolioBit);
		
		String strUsr[][]			=	ActualizaUsuario.NombreMailUsuario(strIdUsuario);
		String UsrNombreResponde 	=	BUsuario.getNombre();
		String UsrMailResponde		=	BUsuario.getCorreo();
		String UsrDirigido			=	strUsr[0][0];
		String UsrMailDirigido		=	strUsr[0][1];
		
		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
		String portServer = application.getInitParameter("PortMail");
		String serverName = application.getInitParameter("servername");

		String strRutaBase = (application.getInitParameter("RutaBase")==null)?"":application.getInitParameter("RutaBase");
		if(BUsuario.getDelegar()){
			try{
				if (ActualizaUsuario.getNotificacionMail(strIdUsuario)){
					SenderMail mail = new SenderMail(UsrDirigido, UsrMailDirigido, UsrNombreResponde, 
											UsrMailResponde, strComentarios, strIdInstruc,
											serverMail, portServer, serverName,strRutaBase);
					mail.sendDelegacion(session.getServletContext());
				}
			}catch(MessagingException me){
        	    //System.err.println("Mensaje="+me.getMessage());
        	}catch(UnsupportedEncodingException uee){
        	    //System.err.println("Mensaje1="+uee.getMessage());
        	}
		}
		try{
		response.sendRedirect("PortalAtender.jsp");
		}catch(java.io.IOException io){
			//System.out.println("E/RROR:"+io.getMessage());
		}
	}
	//String strUsuarios[][] = ActualizaUsuario.getSubalterno(strUsuarioOriginal);
	String strUsuarios[][] = ActualizaUsuario.getSubordinados(strUsuarioOriginal);
	//Arboles tree = new Arboles(strUsuarios);
	AsignarArbol tree = new AsignarArbol(strUsuarios);
	Vector vNombres1 = new Vector();
	Vector vIds = new Vector();
	vNombres1 = tree.getNombres();
	vIds = tree.getIds();
%>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>Delegar</TITLE>
<SCRIPT language=JavaScript type=text/javascript>
	
	function regresar(){
		history.go(-1);
	}
	
	function Delegar(){	
		doc = document.delegar;
		valida = 0;
		msg="";

		if (doc.delegarUsr[doc.delegarUsr.selectedIndex].value == -1){
			valida =1;
			msg = msg + " Debes seleccionar un Usuario	"+ "\n";
		}
		
		if (doc.delegarComentario.value == "") {
			valida =1;
			msg = msg + " Debe capturar un comentario para la delegación	"+ "\n";
		}
	
		if (valida == 1) 
		{
			alert(msg);
		} 
		if (valida != 1)
		{
			doc.accion.value="guardar";
			if (confirm("Está usted seguro que desea Delegar la Instrucción?")) 
			{
				doc.submit();
			}else{
				alert("Su petición de Delegación ya fue cancelada");
			}
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
	onClick="timer_reload()"
	onMouseMove="limitaTextArea(document.delegar.delegarComentario,'Delegar','4000')">
<FORM action="Delegar.jsp" name="delegar" method="post">
<INPUT type="hidden" value="guardar" name="accion">
<INPUT type="hidden" value="<%= strIdInstruc %>" name="id_ins">
<INPUT type="hidden" value="<%= strIdAsunto %>" name="id_asunto">
<INPUT type="hidden" value="<%= strAvance %>" name="ava">
<INPUT type="hidden" value="<%= strUsuarioOriginal %>" name="usr_ori">
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
				<INPUT class="blue100" onclick="Delegar()" type="button" value="Aceptar">
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
			<TD width="144"><FONT face="Arial" color="#004080" size="2">Usuario:</FONT></TD>
			<TD width="528" colspan="3">
				<SELECT name="delegarUsr" onkeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()" class="blue500" >
					<OPTION value="-1">-- Selecciona Usuario a Delegar --</OPTION>
					<%for(int i=0;i<vNombres1.size();i++){%>
					<OPTION value="<%=vIds.get(i)%>"><%=vNombres1.get(i)%></OPTION>
					<%}%>
				</SELECT>
			</TD>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Arial" color="#004080" size="2">Comentarios:</FONT></TD>
			<TD width="528" colspan="3">
				<TEXTAREA cols="50" rows="5" class="blue500" name="delegarComentario" 
							onKeyDown="limitaTextArea(document.delegar.delegarComentario,'Delegar','4000')"></TEXTAREA>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>

</FORM>
</BODY>
</HTML>
