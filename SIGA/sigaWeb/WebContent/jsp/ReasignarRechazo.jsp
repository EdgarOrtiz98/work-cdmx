<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,com.meve.sigma.taglib.*,java.util.*"
%>
<%@ page import="com.meve.sigma.util.*" %>
<%@ page import="javax.mail.MessagingException" %>
<%@ page import="java.io.UnsupportedEncodingException" %>
<%@ page import = "gob.hacienda.cgtic.siga.Usuario" %>
<%@ page import = "gob.hacienda.cgtic.siga.util.Items"%>
<%@ page import = "gob.hacienda.cgtic.siga.instruccion.Rechazo"%>
<%
	String strIdAsunto		=	"";
	String strIdInstruc		=	"";
	String strAvance		=	"";
	strIdInstruc			=	(request.getParameter("id_ins") != null)?request.getParameter("id_ins"):"";
	strIdAsunto				=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
	strAvance				=	(request.getParameter("ava") != null)?request.getParameter("ava"):""; 
	String turno			=	ActualizaInstrucciones.getTurnador(strIdInstruc);
        UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp = request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+strTmp+"?id_ins="+strIdInstruc+"&id_asunto="+strIdAsunto+"&ava="+strAvance);
		}
		catch(java.io.IOException io){
			//System.out.println("E/RROR:"+io.getMessage());
		}
	}
%>
<%
	
	String strIdUsuario		=	"";
	String strComentarios	=	"";
	String strAccion		=	"";
	String strFechaCreacion	=	"";
	String strIdArea		=	"";
	boolean bReasignar		=	false;
	boolean bInsertar		=	false;
	boolean bInsertarBit	=	false;
	
	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaCreacion 				=	sdf.format(f);
	
	String strIdUsrReasigna	=	BUsuario.getIdUsuario();
	
	strAccion	=	request.getParameter("accion");
	strIdArea	=	(request.getParameter("id_area") != null)?request.getParameter("id_area"):"";
	strIdUsuario=	(request.getParameter("id_usuario") != null)?request.getParameter("id_usuario"):"";
	strComentarios= (request.getParameter("reasignarComen") != null)?request.getParameter("reasignarComen"):"";

	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
        String retURI2 = (request.getParameter("retURI2")== null)?"portalPrincipal.jsp":request.getParameter("retURI2");
	boolean bValidaEstatus = false;
	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
	if (strIdInstruc!=null && !strIdInstruc.equals("")){
		if (strEstValidacion.equals("")){
			strEstValidacion = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruc);
		}
		String strEstatusValida = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruc);
		if (!strEstatusValida.equals(strEstValidacion)){ 
			bValidaEstatus = true; 
		}
	}

	if(!bValidaEstatus && strAccion != null && strAccion.equals("guardar")){
		strIdInstruc	=	request.getParameter("id_ins");
		strIdAsunto		=	request.getParameter("id_asunto");
		strAvance		=	request.getParameter("ava");
		strIdUsuario	=	request.getParameter("reasignarUsr");
		strComentarios	=	request.getParameter("reasignarComen");
		strIdArea		=	request.getParameter("id_area");
                
                if(BUsuario.getAsistente()){
                    try{
                        bInsertar = ActualizaHistorial.InsertarReasignacion(strIdInstruc, strIdAsunto, strComentarios,Usuario.aTitular(BUsuario.getIdUsuario()), strFechaCreacion, BUsuario.getCargo()+" / "+BUsuario.getNombre()+" en Nombre de "+Rechazo.aNombre(BUsuario,strIdInstruc));
                    }catch(Exception e){ 
                    }
                }
                else
                    bInsertar = ActualizaHistorial.InsertarReasignacion(strIdInstruc, strIdAsunto, strComentarios,strIdUsrReasigna, strFechaCreacion, BUsuario.getCargo()+" / "+BUsuario.getNombre());
                
                bReasignar = ActualizaInstrucciones.ActualizaReasignar(strIdInstruc, strIdUsuario, strAvance);

		String strFolioBit = ActualizaInstrucciones.getUltimoFolioTurnado(strIdInstruc);
		bInsertarBit	=	ActualizaBitacora.InsertarEventoReasignar(BUsuario.getIdUsuario(), strFolioBit);
		
		String strUsr[][]			=	ActualizaUsuario.NombreMailUsuario(strIdUsuario);
		String UsrNombreResponde = BUsuario.getCargo()+"/"+BUsuario.getNombre();
		String UsrMailResponde		=	BUsuario.getCorreo();
		String UsrDirigido			=	strUsr[0][2];
		String UsrMailDirigido		=	strUsr[0][1];
		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
		String portServer = application.getInitParameter("PortMail");
		String serverName = application.getInitParameter("servername");
		String strRutaBase = (application.getInitParameter("RutaBase")==null)?"":application.getInitParameter("RutaBase");
		
		
				if (ActualizaUsuario.getNotificacionMail(strIdUsuario)){
					SenderMail mail = new SenderMail();
					mail.sendNotificarInstruccionReasignada(
							UsrMailDirigido, UsrDirigido,
							UsrNombreResponde, Integer
							.parseInt(strIdInstruc),
							strComentarios, session.getServletContext());
				}
				
		try{
                    response.sendRedirect(retURI2);
		}catch(java.io.IOException io){
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
<TITLE>Reasignar Rechazadas</TITLE>
<SCRIPT src="../js/SigmaJsCat.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT language=JavaScript type=text/javascript>
	
	function regresar(){
		//location.assign('InstruccionesAtender.jsp?id_ins=<%=strIdInstruc%>');
		location.assign('<%= retURI %>');
	}
	
	var digitos=10 //cantidad de digitos buscados 
	var puntero=0 
	var buffer=new Array(digitos) //declaración del array Buffer 
	var cadena="" 

	function buscar_opRAZ(obj){
		var forma=document.reasignarRec;
	   	var letra = String.fromCharCode(event.keyCode)
	   	if(puntero >= digitos){ 
	    	cadena=""; 
	       	puntero=0; 
	    } 
	   	if (event.keyCode == 13){ 
	    	borrar_buffer(); 
			var cad="";
			if(obj.options[obj.selectedIndex].value!="-1")
			{
				var a = forma.areaReasignar.value;
				location.assign('ReasignarRechazo.jsp?id_ins=<%=strIdInstruc%>&id_asunto=<%=strIdAsunto%>&ava=<%=strAvance%>&id_area='+a);	
			}
	    } 
	   	else{ 
	       	buffer[puntero]=letra; 
	       	cadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array 
	       	puntero++; 
	       	for (var opcombo=0;opcombo < obj.length;opcombo++){ 
	          	if(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ 
	          		obj.selectedIndex=opcombo; 
	        	} 
	       	} 
	    }
	   	event.returnValue = false; //invalida la acción de pulsado de tecla para evitar busqueda del primer caracter 
	}
	function borrar_bufferRAZ(){ 
    	cadena=""; 
    	puntero=0; 
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
	onMouseMove="limitaTextArea(document.reasignarRec.reasignarComen,'Comentarios','1000')">
<FORM name="reasignarRec" action="ReasignarRechazo.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%= strIdInstruc %>" name="id_ins">
<INPUT type="hidden" value="<%= strIdAsunto %>" name="id_asunto">
<INPUT type="hidden" value="<%= strAvance %>" name="ava">
<INPUT type="hidden" value="<%=strIdArea%>" name="id_area">
<INPUT type="hidden" value="<%=strIdUsuario%>" name="id_usuario">
<INPUT type="hidden" value="<%=retURI%>" name="retURI">
<INPUT type="hidden" value="<%=retURI2%>" name="retURI2">
<INPUT type="hidden" value="<%=strEstValidacion%>" name="estValidacion">
<TABLE cellspacing="0" cellpadding="0" border="0" width="100%">
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
				<INPUT class="blue100" onclick="regresar();" type="button" value="Cancelar">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<INPUT id="btnReasignar" name="btnReasignar" class="blue100" onclick="ReasignarRechazo();" type="button" value="Aceptar">
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
			<TD width="672" bgcolor="#00204f" colspan="4"><FONT size="0">&nbsp;</FONT></TD>
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
		<% if( (BUsuario.getAtencion()||BUsuario.getAsistente()) && !BUsuario.getTurnado() && !BUsuario.getSupervisor()){ 
                        String[][] strSubAlternos = null;
                 	if(Usuario.equalsTitular(BUsuario.getIdUsuario())&&Usuario.equalsTitular(turno))
                            strSubAlternos = Items.listarSubordinadosTitular(BUsuario.getIdArea());
                        else{
                            turno = gob.hacienda.cgtic.siga.util.Jefe.getAtencion(turno);
                            strSubAlternos = ActualizaUsuario.getSubordinados(turno);//ActualizaUsuario.getSubalterno(BUsuario.getIdUsuario());
                        }
			//Arboles tree = new Arboles(strSubAlternos);
			AsignarArbol tree = new AsignarArbol(strSubAlternos);
			Vector vIdsCadena = tree.getIds();
 		%>
		<TR valign="top">
			<TD width="144"><FONT face="Arial" color="#004080" size="2">Puesto:</FONT></TD>
			<TD width="528" colspan="3">
				<% if(vIdsCadena != null && vIdsCadena.size()!=0){ %>
				<SELECT name="reasignarUsr" class="blue500a" 
					onchange='puestoRR()' onKeypress='buscar_op1(this)' 
					onblur='borrar_buffer()' onclick='borrar_buffer()'>
					<OPTION value="-1">------------------------------ Selecciona un Puesto ------------------------------</OPTION>
				<%	for(int i=0; i<vIdsCadena.size(); i++){ %>
						<OPTION value="<%= (String)vIdsCadena.get(i) %>" 
							<%= (strIdUsuario.equals((String)vIdsCadena.get(i)))?"selected=\"selected\"":"" %>>
							<%= ActualizaUsuario.NombreUsuario((String)vIdsCadena.get(i)) %>/<%= ActualizaUsuario.NombrePuesto((String)vIdsCadena.get(i)) %>
						</OPTION>
				<%	} %>
				</SELECT>
				<% }else{ %>
				<SELECT class="blue100a" name="reasignarUsr">
					<OPTION value="-1">---</OPTION>
				</SELECT>
				<% } %>
		</TD>
		
		<%}else if(BUsuario.getSupervisor() || BUsuario.getTurnado()){%>
		<%      String[][] strSubAlternos=null;
                        if(Usuario.esVentanilla(turno))
                            strSubAlternos = Items.listarSubordinadosTitular(BUsuario.getIdArea());
                        else
                            strSubAlternos= ActualizaUsuario.getSubordinados(turno);//ActualizaUsuario.getSubalterno(turno);
			//Arboles tree = new Arboles(strSubAlternos);
			AsignarArbol tree = new AsignarArbol(strSubAlternos);
			Vector vIdsCadena = tree.getIds();
 		%>
		<TR valign="top">
			<TD width="144"><FONT face="Arial" color="#004080" size="2">Puesto:</FONT></TD>
			<TD width="528" colspan="3">
				<% if(vIdsCadena != null && vIdsCadena.size()!=0){ %>
				<SELECT name="reasignarUsr" class="blue500a" 
					onchange='puestoRR()' onKeypress='buscar_op1(this)' 
					onblur='borrar_buffer()' onclick='borrar_buffer()'>
					<OPTION value="-1">------------------------------ Selecciona un Puesto ------------------------------</OPTION>
				<%	for(int i=0; i<vIdsCadena.size(); i++){ %>
						<OPTION value="<%= (String)vIdsCadena.get(i) %>" 
							<%= (strIdUsuario.equals((String)vIdsCadena.get(i)))?"selected=\"selected\"":"" %>>
							<%= ActualizaUsuario.NombreUsuario((String)vIdsCadena.get(i)) %>/<%= ActualizaUsuario.NombrePuesto((String)vIdsCadena.get(i)) %>
						</OPTION>
				<%	} %>
				</SELECT>
				<% }else{ %>
				<SELECT class="blue100a" name="reasignarUsr">
					<OPTION value="-1">---</OPTION>
				</SELECT>
				<% } %>
		</TD>
		<%}%>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Arial" color="#004080" size="2">Responsable:</FONT></TD>
			<TD width="528" colspan="3">
                        <%String nombre = ActualizaUsuario.NombreUsuario(strIdUsuario)==null? "---" : ActualizaUsuario.NombreUsuario(strIdUsuario);%>
                        <FONT face="Arial" color="#004080" size="2"><%=nombre%></FONT>
                        <!--
				<%if(strIdUsuario!= null && strIdUsuario.length()!=0){%>
				<FONT face="Arial" color="#004080" size="2"><%=ActualizaUsuario.NombreUsuario(strIdUsuario)%></FONT>
				<%}%>
				-->
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
				<TEXTAREA cols="50" rows="5" class="blue500" name="reasignarComen"
				onKeyDown="limitaTextArea(document.reasignarRec.reasignarComen,'Comentarios','1000')"><%=strComentarios.trim()%></TEXTAREA>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<script type="text/javascript">
<!--
if (<%= bValidaEstatus %>){
	alert("Esta Instrucción ha sido modificada por otro usuario y cambió su Estatus,\npor lo que la acción solicitada será cancelada");
	location.assign("<%=retURI%>");
}
//-->
</script>
</FORM>
</BODY>
</HTML>
