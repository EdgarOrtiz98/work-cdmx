<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+strTmp);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}
%>
<SCRIPT language=JavaScript type=text/javascript>	
	function activaBusqueda(){
		doc = document.buscarC;	
		if (doc.buscaContenido.checked == true){			
			doc.buscaSobreContenido.style.visibility = "visible";
			doc.bContenido.value=1;
		}else{
			doc.buscaSobreContenido.style.visibility = "hidden";
			doc.bContenido.value=0;
		}
	}

	function activaCampos(){
		doc = document.buscarC;

		if (doc.buscaFechaRecI.value!=""){
			doc.horaRecepcionI.disabled	= false;
			doc.minRecepcionI.disabled	= false;
		}else{
			doc.horaRecepcionI.disabled	= true;
			doc.minRecepcionI.disabled	= true;
		}

		if (doc.buscaFechaRecF.value!=""){
			doc.horaRecepcionF.disabled	= false;
			doc.minRecepcionF.disabled	= false;
		}else{
			doc.horaRecepcionF.disabled	= true;
			doc.minRecepcionF.disabled	= true;
		}

		if (Trim(doc.relacionAnexada.value)!=""){
			doc.tipoRelacion[0].disabled = false;
			doc.tipoRelacion[1].disabled = false;
			doc.tipoRelacion[2].disabled = false;
		}else{
			doc.tipoRelacion[0].disabled = true;
			doc.tipoRelacion[1].disabled = true;
			doc.tipoRelacion[2].disabled = true;
			
			doc.tipoRelacion[0].checked = true;
			doc.tipoRelacion[1].checked = true;
			doc.tipoRelacion[2].checked = true;
		}

		if (doc.buscaFechaEveI.value!=""){
			doc.horaEventoI.disabled	= false;
			doc.minEventoI.disabled		= false;
		}else{
			doc.horaEventoI.disabled	= true;
			doc.minEventoI.disabled		= true;
		}

		if (doc.buscaFechaEveF.value!=""){
			doc.horaEventoF.disabled	= false;
			doc.minEventoF.disabled		= false;
		}else{
			doc.horaEventoF.disabled	= true;
			doc.minEventoF.disabled		= true;
		}
	}
</SCRIPT>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<TITLE>Buscar por Asunto</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load(); activaCampos(); " onKeyPress="timer_reload()" 
	onClick="timer_reload()" onmousemove="activaCampos()">

<form method="post" action="BuscarCampoBean.jsp" name="buscarC">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%">&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<TBODY>
		<tr valign="top">
			<td width="208"><input type="button" onclick="regresarBuscar()"
				value="Limpiar Pantalla" class="blue200">&nbsp;</td>
			<td width="208"><input type="button"  onclick="BurcarCampo()" 
				value="Buscar" class="blue100"></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380" align="right"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""> Ayuda:&nbsp;
				<A title="Para hacer una busqueda exacta escriba el criterio (p.ej. Asunto interno de CGTIC)">
				<U>Busqueda exacta</U> &nbsp;</A>
				<A title="Para hacer una busqueda multicriterio escriba los criterios separados por comas (p.ej. CGTIC, Instrucción rechazada, Asunto interno)">
				<U>Busqueda multicriterio</U> &nbsp; </A> </td>
		</tr>
	</TBODY>
</table>
</DIV>
<br>
<DIV align="center">
</DIV>
<BR>
<DIV class=documentBody id=Body>
<DIV align="center">
<table width="863" border="0" cellspacing="0" cellpadding="0" align="center">
	<TBODY>
		<tr>
			<td colspan="2">
				<b><font size="2" color="#004080" face="Arial">Busqueda por Asuntos</font></b>
			</td>
		</tr>
		<tr><td bgcolor="#004080" colspan="2"></td></tr>
		<tr><td bgcolor="#004080" colspan="2"></td></tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Folio de Recepción:</font><BR>
			</td>
			<td width="700">
				<input name="buscaFolio"  value="" class="blue500" maxlength="100">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Folio de Control:</font><BR>
			</td>
			<td width="700">
				<input name="buscaFolioControl" value="" class="blue500" maxlength="200">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Estatus del Asunto:</font><BR>
			</td>
			<td width="700">
				<input name="buscaEstatus" type="checkbox" value="0" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">En Recepción&nbsp;&nbsp;&nbsp;&nbsp;</font>			
				<input name="buscaEstatus" type="checkbox" value="1" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">Por Turnar&nbsp;&nbsp;&nbsp;&nbsp;</font>			
				<input name="buscaEstatus" type="checkbox" value="2" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">En Tramite&nbsp;&nbsp;&nbsp;&nbsp;</font>			
				<input name="buscaEstatus" type="checkbox" value="3" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">Terminado&nbsp;&nbsp;&nbsp;&nbsp;</font>			
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Fecha de Captura:</font><BR>
			</td>
			<td width="700">
				<font size="2" color="#004080" face="Arial">Del&nbsp;&nbsp;</font>
				<input name="buscaFechaCapI" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha"
				onclick='show_calendar("forms[0].buscaFechaCapI");'></a> 

				<font size="2" color="#004080" face="Arial">&nbsp;&nbsp;al&nbsp;&nbsp;</font>
				<input name="buscaFechaCapF" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha"
				onclick='show_calendar("forms[0].buscaFechaCapF");'></a> 
				<font size="1" color="#004080" face="Arial">&nbsp;&nbsp;(DD/MM/AAAA)</font>
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Fecha de Terminación:</font><BR>
			</td>
			<td width="700">
				<font size="2" color="#004080" face="Arial">Del&nbsp;&nbsp;</font>
				<input name="buscaFechaTerI" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha"
				onclick='show_calendar("forms[0].buscaFechaTerI");'></a> 

				<font size="2" color="#004080" face="Arial">&nbsp;&nbsp;al&nbsp;&nbsp;</font>
				<input name="buscaFechaTerF" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha"
				onclick='show_calendar("forms[0].buscaFechaTerF");'></a> 
				<font size="1" color="#004080" face="Arial">&nbsp;&nbsp;(DD/MM/AAAA)</font>
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Puesto que Capturó el Asunto:</font><BR>
			</td>
			<td width="700">
				<input name="buscaCaptura" value="" class="blue500" maxlength="100">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Relaciones Anexadas<BR>(Folio de Recepción)</font><BR>
			</td>
			<td width="700">
				<input name="relacionAnexada" value="" class="blue500" maxlength="100">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Tipo de Relacion</font><BR>
			</td>
			<td width="700">
				<input name="tipoRelacion" type="checkbox" value="r" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">Respuesta&nbsp;&nbsp;&nbsp;&nbsp;</font>			
				<input name="tipoRelacion" type="checkbox" value="f" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">Referencia&nbsp;&nbsp;&nbsp;&nbsp;</font>			
				<input name="tipoRelacion" type="checkbox" value="a" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">Alcance&nbsp;&nbsp;&nbsp;&nbsp;</font>			
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Avance:</font><BR>
			</td>
			<td width="700">
				<font size="2" color="#004080" face="Arial">Del&nbsp;&nbsp;</font>
				<input name="avanceAsuntoI" value="" class="blue100" maxlength="200" onkeypress="AceptaSoloTeclaNumericaYPunto()">&nbsp;% 

				<font size="2" color="#004080" face="Arial">&nbsp;&nbsp;al&nbsp;&nbsp;</font>
				<input name="avanceAsuntoF" value="" class="blue100" maxlength="200" onkeypress="AceptaSoloTeclaNumericaYPunto()">&nbsp;% 
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Semaforo:</font><BR>
			</td>
			<td width="700">
				<input name="semaforoAsunto" type="checkbox" value="v" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">Verde&nbsp;&nbsp;&nbsp;&nbsp;</font>			
				<input name="semaforoAsunto" type="checkbox" value="a" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">Amarillo&nbsp;&nbsp;&nbsp;&nbsp;</font>			
				<input name="semaforoAsunto" type="checkbox" value="r" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">Rojo&nbsp;&nbsp;&nbsp;&nbsp;</font>			
			</td>
		</tr>

		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">
				<b><font size="2" color="#004080" face="Arial">Campos capturados del Asunto</font></b>
			</td>
		</tr>
		<tr><td bgcolor="#004080" colspan="2"></td></tr>
		<tr><td bgcolor="#004080" colspan="2"></td></tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Entidad:</font><BR>
			</td>
			<td width="700">
				<input name="buscaEntidad"  value="" class="blue500" maxlength="200">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Remitente:</font><BR>
			</td>
			<td width="700">
				<input name="buscaRemitente"  value="" class="blue500" maxlength="200">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Firmante:</font><BR>
			</td>
			<td width="700">
				<input name="buscaFirmante"  value="" class="blue500" maxlength="200">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Supervisor de la Ventanilla:</font><BR>
			</td>
			<td width="700">
				<input name="buscaVentanilla"  value="" class="blue500" maxlength="200">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Documento de:</font><BR>
			</td>
			<td width="700">
				<input name="controlFolio" type="checkbox" value="0" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">Entrada&nbsp;&nbsp;&nbsp;&nbsp;</font>			
				<input name="controlFolio" type="checkbox" value="1" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">Salida&nbsp;&nbsp;&nbsp;&nbsp;</font>			
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Destinatarios:</font><BR>
			</td>
			<td width="700">
				<input name="buscaPara"  value="" class="blue500" maxlength="200">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Asunto:</font><BR>
			</td>
			<td width="700">
				<input name="buscaAsunto" value="" class="blue500" maxlength="200">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Tipo de Documento:</font><BR>
			</td>
			<td width="700">
				<input name="buscaTipoDoc"  value="" class="blue500" maxlength="200">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Fecha de Recepción:</font><BR>
			</td>
			<td width="700">
				<font size="2" color="#004080" face="Arial">Del&nbsp;&nbsp;</font>
				<input name="buscaFechaRecI" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha"
				onclick='show_calendar("forms[0].buscaFechaRecI");'></a> 

				<font size="2" color="#004080" face="Arial">&nbsp;&nbsp;al&nbsp;&nbsp;</font>
				<input name="buscaFechaRecF" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha"
				onclick='show_calendar("forms[0].buscaFechaRecF");'></a> 
				<font size="1" color="#004080" face="Arial">&nbsp;&nbsp;(DD/MM/AAAA)</font>
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Hora de Recepción:</font><BR>
			</td>
			<td width="700">
			<font size="2" color="#004080" face="Arial">Del&nbsp;&nbsp;</font>
			<SELECT name="horaRecepcionI" class="blue50a" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>
				<%for(int i=0;i<24;i++){%>
				<%
				String a = String.valueOf(i);
				if(a.length()==1)
					a="0"+a;
				%>
				<OPTION value="<%=a%>"><%=a%></OPTION>
				<%}%>
			</SELECT>
			<FONT face="Verdana" size="2">:</FONT>
			<SELECT name="minRecepcionI" class="blue50a" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>
				<%for(int i=0;i<60;i++){%>
				<%
				String a = String.valueOf(i);
				if(a.length()==1)
					a="0"+a;
				%>
				<OPTION value="<%=a%>"><%=a%></OPTION>
				<%}%>
			</SELECT>

			<font size="2" color="#004080" face="Arial">&nbsp;&nbsp;&nbsp;al&nbsp;&nbsp;</font>
			<SELECT name="horaRecepcionF" class="blue50a" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>
				<%for(int i=0;i<24;i++){%>
				<%
				String a = String.valueOf(i);
				if(a.length()==1)
					a="0"+a;
				%>
				<OPTION value="<%=a%>" <%= (a.equals("23"))?"selected=\"selected\"":"" %>><%=a%></OPTION>
				<%}%>
			</SELECT>
			<FONT face="Verdana" size="2">:</FONT>
			<SELECT name="minRecepcionF" class="blue50a" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>
				<%for(int i=0;i<60;i++){%>
				<%
				String a = String.valueOf(i);
				if(a.length()==1)
					a="0"+a;
				%>
				<OPTION value="<%=a%>" <%= (a.equals("59"))?"selected=\"selected\"":"" %>><%=a%></OPTION>
				<%}%>
			</SELECT>
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Fecha de Documento:</font><BR>
			</td>
			<td width="700">
				<font size="2" color="#004080" face="Arial">Del&nbsp;&nbsp;</font>
				<input name="buscaFechaDocI" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha"
				onclick='show_calendar("forms[0].buscaFechaDocI");'></a> 

				<font size="2" color="#004080" face="Arial">&nbsp;&nbsp;al&nbsp;&nbsp;</font>
				<input name="buscaFechaDocF" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha"
				onclick='show_calendar("forms[0].buscaFechaDocF");'></a> 
				<font size="1" color="#004080" face="Arial">&nbsp;&nbsp;(DD/MM/AAAA)</font>
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Trámite:</font><BR>
			</td>
			<td width="700">
				<input name="buscaTramite"  value="" class="blue500" maxlength="200">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Fecha de Compromiso:</font><BR>
			</td>
			<td width="700">
				<font size="2" color="#004080" face="Arial">Del&nbsp;&nbsp;</font>
				<input name="buscaFechaComI" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha"
				onclick='show_calendar("forms[0].buscaFechaComI");'></a> 

				<font size="2" color="#004080" face="Arial">&nbsp;&nbsp;al&nbsp;&nbsp;</font>
				<input name="buscaFechaComF" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha"
				onclick='show_calendar("forms[0].buscaFechaComF");'></a> 
				<font size="1" color="#004080" face="Arial">&nbsp;&nbsp;(DD/MM/AAAA)</font>
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Identificador del Documento:</font><BR>
			</td>
			<td width="700">
				<input name="buscaIdDoc" value="" class="blue500" maxlength="100">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Folio Intermedio:</font><BR>
			</td>
			<td width="700">
				<input name="buscaFolioInter" value="" class="blue500" maxlength="100">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Descripción:</font><BR>
			</td>
			<td width="700">
				<input name="buscaSolicitud" value="" class="blue500" maxlength="100">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Comentarios:</font><BR>
			</td>
			<td width="700">
				<input name="buscaComentario" value="" class="blue500" maxlength="100">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Palabra Clave:</font><BR>
			</td>
			<td width="700">
				<input name="buscaPalabraClave" value="" class="blue500" maxlength="100">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
 		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Expediente:</font><BR>
			</td>
			<td width="700">
				<input name="buscaExpediente" value="" class="blue500">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Fecha del Evento:</font><BR>
			</td>
			<td width="700">
				<font size="2" color="#004080" face="Arial">Del&nbsp;&nbsp;</font>
				<input name="buscaFechaEveI" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha"
				onclick='show_calendar("forms[0].buscaFechaEveI");'></a> 

				<font size="2" color="#004080" face="Arial">&nbsp;&nbsp;al&nbsp;&nbsp;</font>
				<input name="buscaFechaEveF" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha"
				onclick='show_calendar("forms[0].buscaFechaEveF");'></a> 
				<font size="1" color="#004080" face="Arial">&nbsp;&nbsp;(DD/MM/AAAA)</font>
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Hora del Evento:</font><BR>
			</td>
			<td width="700">
			<font size="2" color="#004080" face="Arial">Del&nbsp;&nbsp;</font>
			<SELECT name="horaEventoI" class="blue50a" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>
				<%for(int i=0;i<24;i++){%>
				<%
				String a = String.valueOf(i);
				if(a.length()==1)
					a="0"+a;
				%>
				<OPTION value="<%=a%>"><%=a%></OPTION>
				<%}%>
			</SELECT>
			<FONT face="Verdana" size="2">:</FONT>
			<SELECT name="minEventoI" class="blue50a" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>
				<%for(int i=0;i<60;i++){%>
				<%
				String a = String.valueOf(i);
				if(a.length()==1)
					a="0"+a;
				%>
				<OPTION value="<%=a%>"><%=a%></OPTION>
				<%}%>
			</SELECT>

			<font size="2" color="#004080" face="Arial">&nbsp;&nbsp;&nbsp;al&nbsp;&nbsp;</font>
			<SELECT name="horaEventoF" class="blue50a" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>
				<%for(int i=0;i<24;i++){%>
				<%
				String a = String.valueOf(i);
				if(a.length()==1)
					a="0"+a;
				%>
				<OPTION value="<%=a%>" <%= (a.equals("23"))?"selected=\"selected\"":"" %>><%=a%></OPTION>
				<%}%>
			</SELECT>
			<FONT face="Verdana" size="2">:</FONT>
			<SELECT name="minEventoF" class="blue50a" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>
				<%for(int i=0;i<60;i++){%>
				<%
				String a = String.valueOf(i);
				if(a.length()==1)
					a="0"+a;
				%>
				<OPTION value="<%=a%>" <%= (a.equals("59"))?"selected=\"selected\"":"" %>><%=a%></OPTION>
				<%}%>
			</SELECT>
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Lugar del Evento:</font><BR>
			</td>
			<td width="700">
				<input name="buscaEvento" value="" class="blue500" maxlength="100">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Prioridad:</font><BR>
			</td>
			<td width="700">
				<input name="buscaPrioridad" value="" class="blue500" maxlength="100">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Tipo de Asunto:</font><BR>
			</td>
			<td width="700">
				<input name="buscaTipoAsunto" value="" class="blue500" maxlength="100">
			</td>
		</tr>

		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">
				<b><font size="2" color="#004080" face="Arial">Busqueda en Contenido</font></b>
			</td>
		</tr>
		<tr><td bgcolor="#004080" colspan="2"></td></tr>
		<tr><td bgcolor="#004080" colspan="2"></td></tr>
		
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td>
				<input name="buscaContenido" type="checkbox" value="5" onclick="activaBusqueda();">&nbsp;
				<font size="2" color="#004080" face="Arial">Contenido: &nbsp;&nbsp;&nbsp;&nbsp;</font>
			</td>
			<td>
				<input name="bContenido" value="0" type="hidden">
				<input name="buscaSobreContenido" value="" class="blue500" maxlength="199" style="visibility:hidden;" >
			</td>
		</tr> 
	</TBODY>
</table>
</DIV>
<br>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
<br>
</form>
</BODY>
</HTML>
