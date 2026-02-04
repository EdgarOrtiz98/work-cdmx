<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@taglib uri="c" prefix="c"%>
<HTML>
<jsp:useBean id="BEscritura" class="com.meve.sigma.beans.EscrituraBean"
	scope="page"></jsp:useBean>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,com.meve.sigma.util.*,java.util.*"
%>
<%@ page
	import="java.io.UnsupportedEncodingException,javax.mail.MessagingException"%>
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
	String strIdInstruccion		=	"";
	String strIdUsuarioTurno	=	"";
	String strNombre			=	"";
	String strCargo	    		=	"";
	String strCorreo			=	"";
	String strAccion			=	"";
	String strComentario		=	"";
	String strFechaCambio		=	"";
	String strTieneFecha		=	"";
	String strRechazar			=	"";
	String strAceptar			=	"";
	String strNombreRed			=	"";
	String strNombreCorreo[][]	=	null;
	String strFechas[][]		=	null;
	boolean bCambioFecha		=	false;

	String strRutaBase 			= "";

	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
        //System.out.println("Pagina siguiente: " + retURI);
	Vector finesSemana = com.meve.sigma.util.Utilerias.getFinesSemana(1,1);
	String diasFestivos[][] = ActualizaDiaFestivo.getListaDiasFestivos();
	if (diasFestivos!=null && diasFestivos.length>0){
		for (int i=0; i<diasFestivos.length; i++){
			finesSemana.add(com.meve.sigma.util.Utilerias.formatearFechas(diasFestivos[i][1]));
		}
	}

	strIdUsuarioTurno	=	request.getParameter("tur");
	strIdInstruccion	=	request.getParameter("id_ins");
	strTieneFecha		=	(request.getParameter("i")==null)?"":request.getParameter("i");
	strAccion			=	request.getParameter("accion");
	strRechazar			=	request.getParameter("rechazar1");
	strAceptar			=	request.getParameter("aceptar1");
	String strRedirec	=	request.getParameter("re");
	String strIdAsunto	=	request.getParameter("id_asunto");
	strNombreCorreo		=	ActualizaUsuario.NombreMailUsuario(strIdUsuarioTurno);
	strFechas			=	ActualizaInstrucciones.getFechasInstruccion(strIdInstruccion);
	if(strNombreCorreo != null && strNombreCorreo.length > 0){
		strNombre	=	strNombreCorreo[0][0];
		strCorreo	=	strNombreCorreo[0][1];
		strCargo = strNombreCorreo[0][2];
	}

	strRutaBase =  (application.getInitParameter("RutaBase")==null)?"":application.getInitParameter("RutaBase");

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

	//**Cuando el responsable de la instrución hace la solicitud de cambio
	if(!bValidaEstatus && strAccion != null && strAccion.equals("cambio")){
		strComentario		=	request.getParameter("comentarioFecha");
		strIdInstruccion	=	request.getParameter("id_ins");
		strFechaCambio		=	request.getParameter("cambioFechaFin");
		String fecha		=	request.getParameter("fechaVenci");
		strIdAsunto		=	request.getParameter("id_asunto");
		String serverMail 	= 	session.getServletContext().getAttribute("app.siga.serverMail").toString();
		String portServer 	= 	application.getInitParameter("PortMail");
		String serverName 	= 	application.getInitParameter("servername");
                
		bCambioFecha	=	ActualizaInstrucciones.actualizarFechaCambio(strFechaCambio, 
															strIdInstruccion, strComentario);

		boolean bInsHis	=	ActualizaHistorial.insertarSolCambioFecha(strIdInstruccion,
							strComentario, Utilerias.formatearFechas(fecha), strFechaCambio,  
							BUsuario.getCargo()+" / "+BUsuario.getNombre(), BUsuario.getIdUsuario(), strIdAsunto);

		if(BUsuario.getSolCambio()){
				SenderMail sender = new SenderMail();
				if (ActualizaUsuario.getNotificacionMail(strIdUsuarioTurno)){
					sender.sendSolCambioFechaInst(	BUsuario.getCargo()+"/"+BUsuario.getNombre(), BUsuario.getCorreo(), 
												strCargo, strCorreo, strIdInstruccion,
												strComentario, serverName,strRutaBase,session.getServletContext());
				}
		}
		/*if(strRedirec.equals("1")){
			strNombreRed = "InstruccionesAtender";
		}
		if(strRedirec.equals("2")){
			strNombreRed = "InstruccionHija";
		}
		if(strRedirec.equals("3")){
			strNombreRed = "InstruccionTurnada";
		}*/
		try{
           response.sendRedirect(retURI);
		}catch(java.io.IOException io){
		}
	}
	else if(!bValidaEstatus && strRechazar != null && strRechazar.equals("Re")){
		strComentario	=	request.getParameter("comentarioFecha");
		strIdInstruccion=	request.getParameter("id_ins");
		String fecha	=	request.getParameter("fechaVenci");
		strIdAsunto		=	request.getParameter("id_asunto");
		String strD[][]	=	ActualizaInstrucciones.getSolicitudCambioId(strIdInstruccion);
		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
		String portServer = application.getInitParameter("PortMail");
		String serverName = application.getInitParameter("servername");
		
		bCambioFecha	=	ActualizaInstrucciones.actualizaRechazoCambio(strIdInstruccion);
		boolean bInsHis	=	ActualizaHistorial.insertarSolCambioFechaRechazo(strIdInstruccion,
							strComentario, 
							BUsuario.getCargo()+" / "+BUsuario.getNombre(), BUsuario.getIdUsuario(), strIdAsunto);

		//if(BUsuario.getRespCambio()){
		if(true){
		
				SenderMail sender = new SenderMail();
				if (ActualizaUsuario.getNotificacionMail(strD[0][5])){
					sender.sendRespuestaCambioFecha(BUsuario.getCargo()+"/"+BUsuario.getNombre(), BUsuario.getCorreo(),
							strD[0][6], strD[0][4],
							strIdInstruccion, strComentario,
							2, serverMail,session.getServletContext());
				}
		}
		/*if(strRedirec.equals("1")){
			strNombreRed = "InstruccionesAtender";
		}
		if(strRedirec.equals("2")){
			strNombreRed = "InstruccionHija";
		}
		if(strRedirec.equals("3")){
			strNombreRed = "InstruccionTurnada";
		}*/
		try{
                    //	response.sendRedirect(""+strNombreRed+".jsp?id_ins="+strIdInstruccion);
                    response.sendRedirect(retURI);
		}catch(java.io.IOException io){
			//System.err.println("Error de response->"+io);
		}
	}
	else if(!bValidaEstatus && strAceptar != null && strAceptar.equals("Ac")){
		strComentario	=	request.getParameter("comentarioFecha");
		strIdInstruccion=	request.getParameter("id_ins");
		String fecha	=	request.getParameter("fechaVenci");
		strIdAsunto		=	request.getParameter("id_asunto");
		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
		String portServer = application.getInitParameter("PortMail");
		String serverName = application.getInitParameter("servername");
		String strD[][]	=	ActualizaInstrucciones.getSolicitudCambioId(strIdInstruccion);
		bCambioFecha	=	ActualizaInstrucciones.actualizaFechaVencimiento(strIdInstruccion, Utilerias.formatearFechas(strD[0][0]));

		boolean bInsHis	=	ActualizaHistorial.insertarSolCambioFechaAceptacion(strIdInstruccion,
							strComentario, 
							BUsuario.getCargo()+" / "+BUsuario.getNombre(), BUsuario.getIdUsuario(), strIdAsunto);
		
		//if(BUsuario.getRespCambio()){
		if(true){
				SenderMail sender = new SenderMail();
				if (ActualizaUsuario.getNotificacionMail(strD[0][5])){
					sender.sendRespuestaCambioFecha(BUsuario.getCargo()+"/"+BUsuario.getNombre(), BUsuario.getCorreo(),
												strD[0][6], strD[0][4],
												strIdInstruccion, strComentario,
												1, serverMail, session.getServletContext());
				}
		}
		/*if(strRedirec.equals("1")){
			strNombreRed = "InstruccionesAtender";
		}
		if(strRedirec.equals("2")){
			strNombreRed = "InstruccionHija";
		}
		if(strRedirec.equals("3")){
			strNombreRed = "InstruccionTurnada";
		}*/
		try{
		    //	response.sendRedirect(""+strNombreRed+".jsp?id_ins="+strIdInstruccion);
                    response.sendRedirect(retURI);
		}catch(java.io.IOException io){
			//System.err.println("Error de response->"+io);
		}
	}

	if(BUsuario.getIdUsuario().equals(strIdUsuarioTurno))
		BEscritura.setValue(true);
	else
		BEscritura.setValue(false);
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Cambio de Fecha</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script type="text/javascript">
<!--
	
	function validaFechaFinesSem(campoFecha){
		doc = document.cambioFecha;
		var valida = 0 
	<% 	for (int ik=0; ik<finesSemana.size(); ik++){ %>	
		if (campoFecha != null && campoFecha.value == "<%= (String)finesSemana.get(ik) %>") {
			valida =1;
		}
	<%	} %>
		if (valida == 1){
			alert("La fecha seleccionada no es laborable");
			campoFecha.value = "";
		}
		if (valida==0 && doc.cambioFechaFin.value!="" && comparaFechas(doc.cambioFechaFin.value,"<%=Utilerias.getFechaActual()%>")==-1){
			alert("La Fecha no puede ser menor a la fecha actual");
			campoFecha.value = "";
		}
	}
//-->
</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()"
	onMouseMove="limitaTextArea(document.cambioFecha.comentarioFecha,'Comentario','4000');
		validaFechaFinesSem(document.cambioFecha.cambioFechaFin);">
<FORM name="cambioFecha" action="CambioFechaInst.jsp" method="post">
<INPUT type="hidden" value="cambiar" name="accion">
<INPUT type="hidden" value=" " name="rechazar1">
<INPUT type="hidden" value=" " name="aceptar1">
<INPUT type="hidden" value="<%=strIdUsuarioTurno%>" name="tur">
<INPUT type="hidden" value="<%=strIdInstruccion%>" name="id_ins">
<INPUT type="hidden" value="<%=strRedirec%>" name="re">
<INPUT name="retURI" value="<%=retURI%>" type="hidden">
<INPUT type="hidden" value="<%=strFechas[0][1]%>" name="fechaVenci">
<INPUT type="hidden" value="<%=strIdAsunto%>" name="id_asunto">
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
		<TR>
			<TD width="92">&nbsp;</TD>
			<TD width="44">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="344" align="right"><b><font size="4" color="#00204F"
				face="Verdana"> Solicitud de Cambio de Fecha</font></b></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="336" colspan="2"><% if(strTieneFecha.equals("2")){ %> <INPUT
				class="blue100" onclick="regresarCambio()" type="button"
				value="Cancelar">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <INPUT
				class="blue100" onclick="solicitarCambio()" type="button"
				value="Aceptar">
			<% }else if(strTieneFecha.equals("1")){ %>
			<c:choose>
			<c:when test='${BEscritura.value}'>
				<INPUT
				class="blue100" onclick="regresarCambio()" type="button"
				value="Regresar">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<INPUT
				class="blue100" onclick="rechazarCambio()" type="button"
				value="Rechazar">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <INPUT
				class="blue100" onclick="aceptarCambio()" type="button"
				value="Aceptar">
			</c:when>
			<c:otherwise>
				<INPUT
				class="blue100" onclick="regresarCambio()" type="button"
				value="Regresar">
			</c:otherwise>
			</c:choose>
			<% } %>
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
			<TD width="672" bgcolor="#00204f" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<br>
<% if(strTieneFecha.equals("2")){ %>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="390">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><b><FONT face="Arial" color="#004080" size="2">Fecha
			Inicio:</FONT></b></TD>
			<TD width="192"><FONT face="Arial" color="#004080" size="2"> <%=Utilerias.formatearFechas(strFechas[0][0])%>
			</FONT></TD>
			<TD width="144"><b><FONT face="Arial" color="#004080" size="2">Fecha
			Fin:</FONT></b></TD>
			<TD width="390"><FONT face="Arial" color="#004080" size="2"><%=Utilerias.formatearFechas(strFechas[0][1])%></FONT>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="390">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><b><FONT face="Arial" color="#004080" size="2">Nueva
			Fecha Solicitada:</FONT></b></TD>
			<TD width="192"><INPUT name="cambioFechaFin" value=""
				onfocus="blur();"
				onclick="document.forms.cambioFecha.cambioFechaFin.value=''"
				class="blue100"> <A><IMG height="20" title=""
				src="../Imagenes/act_calFormat.gif" width="20" border="0"
				onclick='show_calendar("forms[0].cambioFechaFin");'></A> <FONT
				face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="390">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="390">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><b><FONT face="Arial" color="#004080" size="2">Turnador:</FONT></b>
			</TD>
			<TD colspan="3"><FONT face="Arial" color="#004080" size="2"> <%=ActualizaUsuario.NombreUsuario(strIdUsuarioTurno)%>
			</FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="390">&nbsp;</TD>
		</TR> 
		<TR valign="top">
			<TD width="144"><b><FONT face="Arial" color="#004080" size="2">Razón
			de Cambio:</FONT></b></TD>
			<TD colspan="3">
				<TEXTAREA cols="50" rows="5" class="blue500"
				name="comentarioFecha"
				onKeyDown="limitaTextArea(document.cambioFecha.comentarioFecha,'Comentario','4000')"></TEXTAREA>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<% 
	} else if(strTieneFecha.equals("1")){
		String strDatos[][] = ActualizaInstrucciones.getSolicitudCambio(strIdInstruccion);
%>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="71">&nbsp;</TD>
			<TD width="95">&nbsp;</TD>
			<TD width="59">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="644"><FONT face="Arial" color="#004080" size="2"> El
			Puesto: <b><%=strDatos[0][3]%> </b>, ha solicitado que se haga una
			prorroga en la Fecha de Vencimiento de la instrucción que
			originalmente termina el <b><%=Utilerias.formatearFechas(strDatos[0][2])%></b>
			a la fecha solicitada por el usuario que es el <b><%=Utilerias.formatearFechas(strDatos[0][0])%></b>
			</FONT></TD>
			<TD width="71">&nbsp;</TD>
			<TD width="95">&nbsp;</TD>
			<TD width="59">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="71">&nbsp;</TD>
			<TD width="95">&nbsp;</TD>
			<TD width="59">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="644"><FONT face="Arial" color="#004080" size="2"> La razón
			de la solicitud de cambio de fecha es la siguiente: </FONT></TD>
			<TD width="71">&nbsp;</TD>
			<TD width="95">&nbsp;</TD>
			<TD width="59">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="71">&nbsp;</TD>
			<TD width="95">&nbsp;</TD>
			<TD width="59">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="644"><FONT face="Arial" color="#004080" size="2"> <b><%=strDatos[0][1] %></b>
			</FONT></TD>
			<TD width="71">&nbsp;</TD>
			<TD width="95">&nbsp;</TD>
			<TD width="59">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="71">&nbsp;</TD>
			<TD width="95">&nbsp;</TD>
			<TD width="59">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Arial" color="#004080" size="2">
			Comentarios: </FONT></TD>
			<TD width="71">&nbsp;</TD>
			<TD width="95">&nbsp;</TD>
			<TD width="59">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="644">
			<c:choose>
			<c:when test='${BEscritura.value}'>
				<FONT face="Arial" color="#004080" size="2"> <TEXTAREA
				cols="50" rows="5" class="blue500" name="comentarioFecha"
				onKeyDown="limitaTextArea(document.cambioFecha.comentarioFecha,'Comentario','4000')"></TEXTAREA>
			</FONT>
			</c:when>
			<c:otherwise>&nbsp;</c:otherwise>
			</c:choose>
			</TD>
			<TD width="71">&nbsp;</TD>
			<TD width="95">&nbsp;</TD>
			<TD width="59">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<% } %>
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
