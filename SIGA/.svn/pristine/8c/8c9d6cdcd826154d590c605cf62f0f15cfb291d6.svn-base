<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="true"></jsp:include>
<jsp:useBean id="BResponder" class="com.meve.sigma.beans.ResponderBean"
	scope="page"></jsp:useBean>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,com.meve.sigma.util.*,gob.hacienda.cgtic.siga.beans.*"
%>
<%
	String strAvance		=	"";
	String strEstatus		=	"";
	String strIdInstruccion	=	"";
	String strIdAsunto		=	"";
	String strIdHistorial	=	"";
	String Avance1			=	"";
	String machote			=	""; 
	String strUsrOrg		=	"";
	String strFolio			=	"";
	String enviaEmailCheck	=	"";
	
	strIdInstruccion	=	(request.getParameter("id_ins") != null)?request.getParameter("id_ins"):"";
	strIdAsunto			=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
	strIdHistorial		=	(request.getParameter("id_his") != null)?request.getParameter("id_his"):"";
	strEstatus			=	(request.getParameter("id_es") != null)?request.getParameter("id_es"):"";
	strAvance			=	(request.getParameter("ava") != null)?request.getParameter("ava"):"";
	Avance1				=	(request.getParameter("ava") != null)?request.getParameter("ava"):"";
	machote				=	(request.getParameter("ma") != null)?request.getParameter("ma"):"";
	strUsrOrg			=	(request.getParameter("us_or") != null)?request.getParameter("us_or"):"";
	
	if(strIdHistorial.trim().length()==0)
		strFolio			=	ActualizaAsunto.getFolioAsunto(strIdAsunto);
	
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp = request.getRequestURI();
	////System.err.println("strTmp="+strTmp);
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+strTmp);
		}
		catch(java.io.IOException io){
			//System.out.println("E/RROR:"+io.getMessage());
		}
	}
%>
<%
	
	String strIdUsuario		=	"";
	String strIdUsrResp		=	"";
	String strRespuesta		=	"";
	String strResponderA	=	"";
	String strAccion		=	"";
	String strFechaCreacion	=	"";
	String strIdMachote		=	"";
	String nota				=	"";
	String oficio			=	"";
	String strIdPadre		=	"";
	String strCount[][]		=	null;
	String strSum[][]		=	null;
	String strDescripcionMachote[][] = null;
	
	boolean esHijo = false;

	strAccion	=	request.getParameter("accion");
	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
        String retURI2 = (request.getParameter("retURI2")== null)?retURI:request.getParameter("retURI2");

	String mensajeJS = "";
	boolean bValidaEstatus = false;
	strIdInstruccion  = request.getParameter("id_ins");
	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
	boolean eviamailResIns=   ActualizaUsuario.getEnviaEmailRespIns(session.getServletContext(),BUsuario.getIdArea());
	boolean recibeMailRemitente=ActualizaUsuario.getNotificacionMail(ActualizaInstrucciones.getTurnador(strIdInstruccion));
	enviaEmailCheck		=	(request.getParameter("enviaEmailCheckF") != null)?request.getParameter("enviaEmailCheckF"):"";
	
	if (strIdInstruccion!=null && !strIdInstruccion.equals("")){
		if (strEstValidacion.equals(""))
			strEstValidacion = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
                       // //System.out.println("strEstatusValidacion: "+strEstValidacion);
		String strEstatusValida = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
               // //System.out.println("strEstatusValida: "+strEstatusValida);
		if (!strEstatusValida.equals(strEstValidacion)){ 
			bValidaEstatus = true; 
			mensajeJS = "Esta Instrucción ha sido modificada por otro usuario y cambió su Estatus,\\npor lo que la acción solicitada será cancelada";
		}
	}
	if (!bValidaEstatus && ActualizaAsuntoTurnado.getCountInstNoTerminadas(strIdInstruccion)){
		bValidaEstatus = true; 
		mensajeJS = "Esta Instrucción tiene Instrucciones hijas que no han sido terminadas,\\npor lo que la acción solicitada será cancelada";
	}

	if(!bValidaEstatus && strAccion != null && strAccion.equals("guardar")){
//                //System.err.println("Procedimiento para guardar: ");
		strIdInstruccion  = request.getParameter("id_ins");
		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
		String portServer = application.getInitParameter("PortMail");
		String serverName = application.getInitParameter("servername");
		String strBase	  =	application.getInitParameter("RutaBase"); 
		String strTurnador= ActualizaInstrucciones.getTurnador(strIdInstruccion);
		//System.out.println("chec="+enviaEmailCheck+",parametro="+eviamailResIns);
		if (enviaEmailCheck=="true" || enviaEmailCheck.equals("true")){
			eviamailResIns=true;
		}
		else{
			eviamailResIns=false;
		}
		
	    gob.hacienda.cgtic.siga.beans.ResponderBean.responderInstruccion(request,BUsuario,strTurnador,serverName,strBase,eviamailResIns,session.getServletContext());
	    
	    
		
		String ava = ActualizaInstrucciones.getAvance(strIdInstruccion);
		strAvance	=	ava;//request.getParameter("responderAvance");
		float iAvance = new Float(strAvance).floatValue();
		if(iAvance >= 100){
%>

<SCRIPT language=JavaScript type=text/javascript> 
	//location.assign("PortalTerminado.jsp");
	location.assign("<%= retURI2 %>");
</SCRIPT>
<%			
		}else{
%>

<SCRIPT language=JavaScript type=text/javascript> 
	//location.assign("PortalTramite.jsp");
	location.assign("<%= retURI %>");
</SCRIPT>
<%
		}//cierre if de 100%
	}//fin guardar
	

	if(!bValidaEstatus && strIdHistorial != null && strIdHistorial.trim().length()>0)
	{
		String strHistorial[][]	= ActualizaHistorial.getHistorial(strIdHistorial);
		strRespuesta	=	strHistorial[0][0];
		strAvance		=	strHistorial[0][1];
	}
%>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<TITLE>Responder</TITLE>
<STYLE type=text/css>.clsCursor {
	CURSOR: hand
} </STYLE>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<SCRIPT language=JavaScript type=text/javascript>

var botonBandera = true; 

function SaveHTMLPage() {
	doc = document.responder;
	valida = 0;
	msg="";
	avance = <%=strAvance%>
	
	if (doc.responderEnviarEmail.checked){
		doc.enviaEmailCheckF.value="true";		
	}
	else{		
		doc.enviaEmailCheckF.value="false";
	}	
	if (doc.responderAvance.value == avance){
		valida = 1;
		msg = msg + " Debe capturar el Avance de la Instrucción "+ "\n";
	}
	if (doc.responderAvance.value > 100){
		valida = 1;
		msg = msg + " El Avance maximo de una Instrucción es el 100% "+ "\n";
	}
	if (doc.responderAvance.value <= 0){
		valida = 1;
		msg = msg + " El Avance no puede ser menor o igual a cero "+ "\n";
	}
	//if (doc.responderAvance.value < avance){
	//	valida = 1;
	//	msg = msg + " El Avance debe ser mayor al "+avance+"% "+ "\n";
	//}
//	if (!validaCorreos(doc.responderA.value)){
//		valida = 1;
//		msg = msg + " El campo \"Informar a\" contiene información invalida "+ "\n";
//	}
	if (valida == 0){
		//limitaTextArea(doc.contestar,'Respuesta a la Instrucción', '4000');

		mensaje = 'El campo Respuesta a la Instrucción contiene caracteres invalidos \nPresione Aceptar para modificarlos automaticamente\no Cancelar para regresar'
		if(detectaCE(doc.contestar.value)){
			if (confirm(mensaje)){
				doc.contestar.value = quitaCE(doc.contestar.value);
				//alert(doc.contestar.value);
			}
			else{
				valida = 2;
				botonBandera = true; 
			}
		}
	}
	if (Trim(doc.contestar.value) == "") {
		valida =1;
		msg = msg + " Debe capturar una Respuesta a la instrucción	"+ "\n";
	}
	if (valida == 1){
		alert(msg);
		botonBandera = true; 
	} 

	if (valida == 0){
		doc.accion.value="guardar";
		if (confirm("Está usted seguro que desea Responder la Instrucción?")) 
		{
			doc.submit();
		}else{
			alert("Su petición de Respuesta ya fue cancelada");
			botonBandera = true; 
		}
	}
}

function detectaComilla(texto){

	if (texto.indexOf('\'')>=0){
		return true;
	}
	else{ 
		return false;
	}
}

function quitaComilla(texto){

	for (i=0; i<texto.length; i++){
		c=texto.charAt(i);
		if(c=='\''){
			aux1 = texto.substring(0,i);
			aux2 = texto.substring(i+1,texto.length);
			texto = aux1 + aux2;
			continue;
		}
	}
	
	return texto;
}

function quitaSaltoDeLinea(texto){

	while (texto.indexOf('\n')!=-1){
		i = texto.indexOf('\n')
		aux1 = texto.substring(0,i-1);
		aux2 = texto.substring(i+1,texto.length);
		texto = aux1 + '' + aux2;
	}
	return texto;
}

function validaCorreos(texto){

	while (texto.indexOf(',')!=-1){
		i=texto.indexOf(',');
		mail 	= texto.substring(0,i);
		texto 	= texto.substring(i+1,texto.length);
		if (!isCorreo(mail)){
			return false;
		}
		if (Trim(mail)==""){
			return false;
		}
	}
	mail = texto;
	if (!isCorreo(mail)){
		return false;
	}
	return true;
}

function AnexarArchivoRes(){
	location.assign('ImportarCM.jsp?Folio=<%=strFolio%>&IdAsunto=<%=strIdAsunto%>&a=6&id_ins=<%=strIdInstruccion%>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&id_asunto="+strIdAsunto+"&id_es="+strEstatus+"&ava="+strAvance+"&us_or="+strUsrOrg+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');
}
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="timer_load();"
		onMouseMove="limitaTextArea(document.responder.contestar,'Respuesta a la Instrucción','4000');
					limitaTextArea(document.responder.responderA,'Informar a','300')"
		onKeyPress="timer_reload();" onClick="timer_reload();">

<FORM action="Responder.jsp" name="responder" method="post">
<INPUT type="hidden" name="enviaEmailCheckF" value="otro">
<INPUT type="hidden" name="nota" value='<%=nota %>'>
<INPUT type="hidden" name="oficio" value='<%=oficio %>'>
<INPUT type="hidden" value="guardar" name="accion">
<INPUT type="hidden" value="<%= strIdInstruccion %>" name="id_ins">
<INPUT type="hidden" value="<%= strIdAsunto %>" name="id_asunto">
<INPUT type="hidden" value="<%= strEstatus %>" name="id_es">
<INPUT type="hidden" value="<%= Avance1 %>" name="ava">
<INPUT type="hidden" name="idUsuario" value="<%= strIdUsuario %>">
<INPUT type="hidden" value="<%= strFechaCreacion %>" name="fechaIni">
<INPUT name="retURI" value="<%=retURI%>" type="hidden">
<INPUT name="retURI2" value="<%=retURI2%>" type="hidden">
<INPUT name="us_or" value="<%=strUsrOrg%>" type="hidden">
<INPUT type="hidden" value="<%=strEstValidacion%>" name="estValidacion">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%">&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<% if(strIdHistorial != null && strIdHistorial.trim().length()>0){ %>

<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0" width="1000">
	<TBODY>
		<TR valign="top">
			<TD width="34%"><INPUT class="blue100" onclick="RegresarResp()"
				type="button" value="Regresar"></TD>
			<TD width="20%">
				&nbsp;
			</TD>
			<TD width="20%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<BR>
<DIV class=documentBody id=Body align="center">
<TABLE cellspacing="0" cellpadding="0" border="0" width="1000">
	<TBODY>
		<TR align="left">
			<TD align="left" width="90%"><font face="Arial" color="#004080" size="2"><%= com.meve.sigma.util.Utilerias.cambioSaltosDeLinea(strRespuesta) %></font>
			</TD>
		</TR>
		<tr valign="top" align="left"> 
			<td align="left" width="15%">&nbsp;</td>
		</tr>
		<TR align="left">
			<TD width="10%" align="left" ><font face="Arial" color="#004080" size="2">Avance: <%= strAvance %>%</font>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<br>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
<br>
<% }else{ %>
<!-- 
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<TBODY><tr>

			<TD width="994">
			<font face="Arial" color="#004080" size="2">Informar
			a: (correo electrónico)<BR>
			</font>  <INPUT type="hidden" name="contestar">  
			<font face="Verdana" color="#00204f"
			size="2"> 
			<TEXTAREA name="responderA" cols=80 rows="3" class="blue500" onfocus="" 
						onkeypress="NoAceptaSaltosDeLinea();"
						onKeyDown="limitaTextArea(document.responder.responderA,'Informar a','300')"></TEXTAREA>
			</font>
			</TD>
		</tr>
</table>
</DIV> 
<br>
-->

<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	
	<tr valign="top">		
		<td width=231><font face="Arial" color="#004080" size="2">Avance:</font>
		<input name="responderAvance" value="<%=strAvance%>" Size=4 onKeyPress='AceptaSoloTeclaNumericaYPunto();'
			class="blue50" maxlength="4"> <font face="Arial" color="#004080" size="2">%</font>
		</td>
		
		<%
			if (eviamailResIns && recibeMailRemitente){
			%>
			<td width="527"><font face="Arial" color="#004080" size="2"> <input
			type="checkbox" name="responderEnviarEmail" value="" checked > ¿Desea enviar respuesta al remitente por correo electrónico? </font>
			<%
			}
			else{%>
				<td width="527"><font face="Arial" color="#004080" size="2"> <input
				type="hidden" name="responderEnviarEmail" value="" ></font>				
				<%
			}			
			%>
		</td>	
	</tr>
	
	<tr valign="top">
		<td width="231"><font face="Arial" color="#004080" size="2"> <input
			type="checkbox" name="responderTerminar" value=""
			onclick="terminarInstruccion()"> Dar por terminada la instrucción? </font>
		</td>										
	</tr>
	<tr valign="top">
		<td width="231"><input type="checkbox" name="firmaDigital"
			style="display:none" onclick="firmarDigitalmente()" value="off">
		&nbsp;<input type="text" name="label1" style="display:none"
			value="¿Firmar digitalmente?" disabled></td>
	</tr>
		
	<tr valign="top">
		<td width="471"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	
	<tr valign="top">
		<td width="758" bgcolor="#00204F" colspan="2"><img src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
	</tr>
</table>
<br>

<TABLE cellSpacing=0 cellPadding=0 border=0 width="1000">
  <TBODY>
  	<TR align="left">
    	<TD align="left">
			<A 	onclick="if(botonBandera){botonBandera=false; RegresarResp();&#13;return false;}" onMouseOver="document.Regresar.src='../Imagenes/NavLeft2.gif';"
				onMouseOut="document.Regresar.src='../Imagenes/NavLeft.gif';">
			<IMG src="../Imagenes/NavLeft.gif" border=0 title="Regresar" name="Regresar"></A>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<A onclick="if(botonBandera){botonBandera=false; SaveHTMLPage();return false;}" onMouseOver="document.Salvar.src='../Imagenes/Save2.gif';"
				onMouseOut="document.Salvar.src='../Imagenes/Save.gif';">
			<IMG title="Guardar Respuesta" src="../Imagenes/Save.gif" border="0" name="Salvar"></A>
			<%--&nbsp;&nbsp;&nbsp;&nbsp;
			<a 	onclick="AnexarArchivoRes();" onMouseOver="document.Insertar.src='../Imagenes/Attach2.gif';" 
				onMouseOut="document.Insertar.src='../Imagenes/Attach.gif';">
			<IMG border="0" src="../Imagenes/Attach.gif" title="Insertar Archivo" name="Insertar"></a>--%>
			<br>
		</TD>
	</TR>
	<TR>
		<TD>
			<TEXTAREA name="contestar" class="blue1000" rows="20"
				onKeyDown="limitaTextArea(document.responder.contestar,'Respuesta a la Instrucción','4000');"></TEXTAREA>
		</TD>
	</TR>
</TBODY>
</TABLE>
</DIV>
<% } %> <INPUT type="hidden" value=false name="autenticado"></FORM>
<script type="text/javascript">

if (<%= bValidaEstatus %>){
	var mensaje = '<%= mensajeJS %>';
	alert(mensaje);
	location.assign("portalPrincipal.jsp");
}

</script>
</BODY>
</HTML>