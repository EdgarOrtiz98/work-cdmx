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
			doc.buscaSobreContenido.style.visibility = "hidden"
			doc.bContenido.value=0;
		}
	}
</SCRIPT>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<TITLE>Buscar por Instrucción</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">

<form method="post" action="BuscarBean.jsp" name="buscarC">
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
			<td width="208"><input type="button" onclick="regresarBuscarIns()"
				value="Limpiar Pantalla" class="blue200">&nbsp;</td>
			<td width="208"><input type="button" onclick="BurcarCampoIns()"
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
<table border="0" cellspacing="0" cellpadding="0">
	<TBODY>
		<tr valign="top">
			<td width="183"><b><font size="2" color="#004080" face="Arial">Busqueda por Instrucciones</font></b></td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td width="863" bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</tr>
	</TBODY>
</table>
</DIV>
<BR>
<DIV class=documentBody id=Body>
<DIV align="center">
<table width="863" border="0" cellspacing="0" cellpadding="0">
	<TBODY>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Folio de Recepción:</font><BR>
			</td>
			<td width="700">
				<input name="buscaFolio" value="" class="blue300" maxlength="199">
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
				<input name="buscaFolioControl" value="" class="blue300" maxlength="199">
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
				<input name="buscaFolioInter" value="" class="blue300" maxlength="199">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Estatus de la Instrucción</font><BR>
			</td>
			<td width="700">
				<input name="buscaEstatus" type="checkbox" value="1" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">Por Atender&nbsp;&nbsp;&nbsp;</font>			
				<input name="buscaEstatus" type="checkbox" value="2" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">En Tramite&nbsp;&nbsp;&nbsp;&nbsp;</font>			
				<input name="buscaEstatus" type="checkbox" value="3" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">Rechazada&nbsp;&nbsp;&nbsp;&nbsp;</font>			
				<input name="buscaEstatus" type="checkbox" value="4" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">Terminada&nbsp;&nbsp;&nbsp;&nbsp;</font>			
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
			<td width="163">
				<font size="2" color="#004080" face="Arial">Responsable:</font><BR>
			</td>
			<td width="700">
				<input name="buscaResponsable"  value="" class="blue500" maxlength="199">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Tipo de Atención:</font><BR>
			</td>
			<td width="700">
				<input name="buscaTipoAte" type="checkbox" value="0" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">Ejecutor&nbsp;&nbsp;&nbsp;&nbsp;</font>			
				<input name="buscaTipoAte" type="checkbox" value="1" checked="checked">&nbsp;
					<font size="2" color="#004080" face="Arial">Informativo&nbsp;&nbsp;&nbsp;&nbsp;</font>			
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
				<input name="buscaAsunto"  value="" class="blue500" maxlength="199">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Fecha de Generación:</font><BR>
			</td>
			<td width="700">
				<font size="2" color="#004080" face="Arial">Del&nbsp;&nbsp;</font>
				<input name="buscaFechaGenI" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha" 
				onclick='show_calendar("forms[0].buscaFechaGenI");'></a> 

				<font size="2" color="#004080" face="Arial">&nbsp;&nbsp;al&nbsp;&nbsp;</font>
				<input name="buscaFechaGenF" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha" 
				onclick='show_calendar("forms[0].buscaFechaGenF");'></a> 
				<font size="1" color="#004080" face="Arial">&nbsp;&nbsp;(DD/MM/AAAA)</font>
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Fecha de Vencimiento:</font><BR>
			</td>
			<td width="700">
				<font size="2" color="#004080" face="Arial">Del&nbsp;&nbsp;</font>
				<input name="buscaFechaVenI" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha" 
				onclick='show_calendar("forms[0].buscaFechaVenI");'></a> 

				<font size="2" color="#004080" face="Arial">&nbsp;&nbsp;al&nbsp;&nbsp;</font>
				<input name="buscaFechaVenF" class="blue100" onfocus="blur()"> 
				<a><img src="../Imagenes/act_calFormat.gif" border="0" title="Selecciona una Fecha" 
				onclick='show_calendar("forms[0].buscaFechaVenF");'></a> 
				<font size="1" color="#004080" face="Arial">&nbsp;&nbsp;(DD/MM/AAAA)</font>
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Asignada por:</font><BR>
			</td>
			<td width="700">
				<input name="buscaAsignadaPor" value="" class="blue500" maxlength="199">
			</td>
		</tr>
		<tr>
			<td width="163">&nbsp;</td>
			<td width="700">&nbsp;</td>
		</tr>
		<tr>
			<td width="163">
				<font size="2" color="#004080" face="Arial">Instrucción:</font><BR>
			</td>
			<td width="700">
				<input name="buscaNomIns" value="" class="blue500" maxlength="199">
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
				<input name="buscaExpediente" value="" class="blue500" maxlength="199">
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
				<input name="buscaContenido" type="checkbox" value="5" onclick="activaBusqueda();">
				<input name="bContenido" value="0" type="hidden">&nbsp;
				<font size="2" color="#004080" face="Arial">Contenido: &nbsp;&nbsp;&nbsp;&nbsp;</font>
			</td>
			<td>
				<input name="buscaSobreContenido" value="" class="blue500" maxlength="199" style="visibility:hidden;" >
			</td>
		</tr>

	</TBODY>
</table>
</DIV>
<br>
</DIV>
<script>
	var bodyElement = document.getElementById('Body') ;
	function LayoutBodyElement() {  
		bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;
	} 
	function document.onreadystatechange() { 
		document.body.scroll = "no" ; 
		LayoutBodyElement( ) ;
		window.onresize = LayoutBodyElement;
	}
</script>
<br>
</form>
</BODY>
</HTML>
