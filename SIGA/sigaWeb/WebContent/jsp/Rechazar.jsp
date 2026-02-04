<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.util.*"
%>
<%@ page import="com.meve.sigma.beans.*" %>
<%@ page import="com.meve.sigma.actualiza.*" %>
<%@ page import="javax.mail.MessagingException" %>
<%@ page import="java.io.UnsupportedEncodingException" %>
<%
	String strIdInstruccion		=	"";
	String strIdAsunto			=	"";
	String strAvance			=	"";
	String strTurnador			=	"";
	String strNombreInst		=	"";
	strIdInstruccion	=	(request.getParameter("id_ins") != null)?request.getParameter("id_ins"):"";
	strIdAsunto			=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
	strAvance			=	(request.getParameter("ava") != null)?request.getParameter("ava"):"";
	strTurnador			=	(request.getParameter("tur") != null)?request.getParameter("tur"):"";
	strNombreInst		=	(request.getParameter("ins") != null)?request.getParameter("ins"):"";

	String retURI1 = (request.getParameter("retURI1")== null)?"portalPrincipal.jsp":request.getParameter("retURI1");
	String retURI2 = (request.getParameter("retURI2")== null)?retURI1:request.getParameter("retURI2");
	
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
	
	String strRazon				=	"";
	String strIdRazonRechazo	=	"";
	String strAccion			=	"";
	String strFechaCreacion		=	"";
	
	boolean bInsetarRechazo		=	false;
	boolean bActualiza			=	false;
	boolean bInsertarBit		=	false;
	
	strAccion			=	request.getParameter("accion");

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaCreacion 				=	sdf.format(f);
	
	boolean bValidaEstatus = false;
	strIdInstruccion  = request.getParameter("id_ins");
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

	if(!bValidaEstatus && strAccion != null && strAccion.equals("guardar")){
		strIdInstruccion	=	request.getParameter("id_ins");
		strIdAsunto		=	request.getParameter("id_asunto");
		strRazon		=	request.getParameter("razonRechazo");
		strAvance		=	request.getParameter("ava");
		strTurnador		=	request.getParameter("tur");
		strNombreInst		=	request.getParameter("ins");
		if(BUsuario.getAsistente())
                    try{
                        bInsetarRechazo=ActualizaHistorial.InsertarRechazo(strIdInstruccion, strIdAsunto,strRazon, gob.hacienda.cgtic.siga.Usuario.aTitular(BUsuario.getIdUsuario()), strAvance, strFechaCreacion, BUsuario.getCargo()+" / "+BUsuario.getNombre()+" en Nombre de "+gob.hacienda.cgtic.siga.instruccion.Rechazo.aNombre(BUsuario,strIdInstruccion));  
                    }catch(Exception e){
                    }
                else
                    bInsetarRechazo=ActualizaHistorial.InsertarRechazo(strIdInstruccion, strIdAsunto,strRazon, BUsuario.getIdUsuario(), strAvance, strFechaCreacion, BUsuario.getCargo()+" / "+BUsuario.getNombre());  
                    
                bActualiza = ActualizaInstrucciones.ActualizarRechazo(strIdInstruccion, strAvance);
		String strFolioBit = ActualizaInstrucciones.getUltimoFolioTurnado(strIdInstruccion);
		bInsertarBit = ActualizaBitacora.InsertarEventoRechazar(BUsuario.getIdUsuario(), strFolioBit);
		//Envio de mail
		String strMailTurnador[][] = ActualizaInstrucciones.getMailNombreTurno(strIdInstruccion);
		String nombreT 	= 	strMailTurnador[0][0];
		String cargoT 	= 	strMailTurnador[0][4];
		String mailT  	= 	strMailTurnador[0][1];
		String asunto	=	strMailTurnador[0][2];
		String nombreR	=	BUsuario.getNombre();
		String mailR	=	BUsuario.getCorreo();
		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
		String portServer = application.getInitParameter("PortMail");
		String serverName = application.getInitParameter("servername");
		String strBase	  = application.getInitParameter("RutaBase");
		
		if(true){
			try{
				SenderMail mail = new SenderMail(); 
				if (ActualizaUsuario.getNotificacionMail(strMailTurnador[0][3])){
					mail.sendMailRechazo(cargoT, mailT, strRazon, strNombreInst, 
								asunto, strIdInstruccion, serverName, strBase,session.getServletContext());
				}
			}catch(MessagingException me){
        	    
                    me.printStackTrace();
        	}catch(UnsupportedEncodingException uee){
        	    
                    uee.printStackTrace();
        	}
		}
	}
%>
<% if(!bValidaEstatus && strAccion!=null && strAccion.equals("guardar")){ %>
<SCRIPT language=JavaScript type=text/javascript>
        location.assign('<%=retURI2%>');
//	location.assign("PortalAtender.jsp");
</SCRIPT>
<% } %>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>Rechazar</TITLE>
<SCRIPT language=JavaScript type=text/javascript>
	
	function Regresar(){
		location.assign("<%=retURI1%>?id_ins=<%=strIdInstruccion%>&retURI=<%=Utilerias.codificaPostHTML(retURI2)%>");
	}
	
	function guardar(){	
	
		doc = document.rechazar;
		valida = 0;
		msg="";

		if (doc.razonRechazo.value == "") {
			valida =1;
			msg = msg + " Debe capturar una Razon de rechazo de la instrucción	"+ "\n";
		}
	
		if (valida == 1) 
		{
			alert(msg);
		} 
		if (valida != 1)
		{
			doc.accion.value="guardar";
			if (confirm("Está usted seguro que desea Rechazar la instrucción?")) 
			{
				doc.submit();
			}else{
				alert("Su petición de Rechazo ya fue cancelada");
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
	onLoad="timer_load()" onKeyPress="timer_reload()" onClick="timer_reload()" 
	onMouseMove="limitaTextArea(document.rechazar.razonRechazo,'Razón de Rechazo','4000')">
<FORM action="Rechazar.jsp" name="rechazar" method="post">
<INPUT type="hidden" value="guardar" name="accion">
<INPUT type="hidden" value="<%= strIdInstruccion %>" name="id_ins">
<INPUT type="hidden" value="<%= strIdAsunto %>" name="id_asunto">
<INPUT type="hidden" value="<%= strAvance %>" name="ava">
<INPUT type="hidden" value="<%= strTurnador %>" name="tur">
<INPUT type="hidden" value="<%= strNombreInst %>" name="ins">
<INPUT type="hidden" value="<%= retURI1 %>" name="retURI1">
<INPUT type="hidden" value="<%= retURI2 %>" name="retURI2">
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
			<TD width="100%" align="left">
				<INPUT class="blue100" onclick="Regresar()" type="button" value="Cancelar">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<INPUT class="blue100" onclick="guardar()" type="button" value="Aceptar">
			</TD>
		</TR>
		<TR>
			<TD width="100%">&nbsp;</TD>
		</TR>
		<tr valign="top">
			<td width="100%" bgcolor="#00204F">
				<B><FONT face="Arial" color="white" size="2">
				Captura las razones del rechazo de la Instrucción:
				</FONT></B>
				<A onclick="if (navigator.appName =='Netscape') {window.open('RechazarVentana.jsp?id_area=<%=BUsuario.getIdArea()%>','Repeat','status=yes,scrollbars=no,screenX=120,screenY=100,width=640,height=280');} else {window.open('RechazarVentana.jsp?id_area=<%=BUsuario.getIdArea()%>','Repeat','status=yes,scrollbars=no,top=120,left=100,width=480,height=220');}return false;">
				<IMG border="0" src="../Imagenes/selec.jpg" width="12" height="8">
				</A>
			</td>
		</tr>
		<TR valign="top">
			<TD width="100%">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="100%"><TEXTAREA cols="70" rows="10" name="razonRechazo"
							onKeyDown="limitaTextArea(document.rechazar.razonRechazo,'Razón de Rechazo','4000')"></TEXTAREA></TD>
		</TR>
		<TR valign="top">
			<TD width="100%">&nbsp;</TD>
		</TR>
		<tr valign="top">
			<td width="100%" bgcolor="#00204F"></td>
		</tr>
	</TBODY>
</TABLE>
</DIV>
<INPUT type="hidden" value="<%= strIdRazonRechazo %>" name="idRazon">
<script type="text/javascript">
<!--
if (<%= bValidaEstatus %>){
	alert("Esta Instrucción ha sido modificada por otro usuario y cambió su Estatus,\npor lo que la acción solicitada será cancelada");
	location.assign("portalPrincipal.jsp");
}
//-->
</script>
</FORM>
</BODY>
</HTML>