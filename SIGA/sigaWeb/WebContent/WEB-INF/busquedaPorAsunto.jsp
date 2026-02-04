<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>

<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.taglib.*"
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
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<TITLE>Busqueda por Asunto</TITLE>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="porAsunto" action="busquedaPorA.jsp" method="post">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%">&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<br>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<TBODY>
		<tr valign="top">
			<td width="183"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380" align="right"><b><font size="3" color="#004080" face="Arial">Busquedas
			por Asuntos</font></b></td>
		</tr>
		<tr valign="top">
			<td width="863" bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</tr>
	</TBODY>
</table>
</DIV>
<br>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<TBODY>
		<tr valign="top">
			<td width="183">&nbsp;</td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="381"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td width="183"><font size="2" color="#004080" face="Arial">Por Folio:
			</font> <font size="2" face="Arial"></font></td>
			<td colspan="3"><font size="2" face="Arial"> <input
				name="buscarRecepcion" value="" class="blue500"> </font></td>
		</tr>
		<tr valign="top">
			<td width="183">&nbsp;</td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="381"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td width="183"><font size="2" color="#004080" face="Arial">Por Unidad:</font>
			</td>
			<td colspan="3">
				<font size="2" face="Arial">
				<meve_combo:comboseleccion
					data="<%= ComboData.getAreasCombo() %>" size="1" name="buscarArea"
					classHtml="blue500"
					textoNoSeleccion=" ------------ Selecciona una Unidad ------------ "
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
				</font>
			</td>
		</tr>
		<tr valign="top">
			<td width="183">&nbsp;</td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="381"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td width="183"><font size="2" color="#004080" face="Arial">Por Asunto:</font>
			</td>
			<td colspan="3"><font size="2" face="Arial"> <input
				name="buscarAsunto" value="" Size="80" onfocus="" class="blue500"> </font>
			</td>
		</tr>
		<tr valign="top">
			<td width="183"><img src="../Imagenes/shim.gif" width="1" height="1"
				title="">&nbsp;</td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="381"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td width="183"><font size="2" color="#004080" face="Arial">Por Tipo de Documento:</font>
			</td>
			<td colspan="3"><font size="2" face="Arial"> <input
				name="buscarTDocto" value="" Size="80" onfocus="" class="blue500"> </font>
			</td>
		</tr>
		<tr valign="top">
			<td width="183"><img src="../Imagenes/shim.gif" width="1" height="1"
				title="">&nbsp;</td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="381"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td width="183"><img src="../Imagenes/shim.gif" width="1" height="1"
				title="">&nbsp;</td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="381"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td colspan="3">
			<div align="right"><b><font size="2" color="#004080" face="Arial">BUSCAR
			ENTRE FECHAS</font></b></div>
			</td>
			<td width="381"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td width="183"><img src="../Imagenes/shim.gif" width="1" height="1"
				title="">&nbsp;</td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="381"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td width="183">
			<div align="center"><font size="2" color="#004080" face="Arial">Inicio</font>
			</div>
			</td>
			<td width="233" valign="middle"><font size="2" face="Arial"> <input
				name="buscarFechaGen" value="" onfocus="blur();" 
				onclick="document.forms.porAsunto.buscarFechaGen.value=''"
				class="blue100"> </font><a><img src="../Imagenes/cal.gif" border="0"
				title="Selecciona una Fecha" width="16" height="16"
				onclick='show_calendar("forms[0].buscarFechaGen");'></a> <font
				size="1" color="#004080" face="Arial">(dd/mm/aaaa)</font>
				<!-- <input type="button" onclick="" value="" class="s-dropdown-btn"> -->
			</td>
			<td width="67">
			<div align="center"><font size="2" color="#004080" face="Arial">Fin</font>
			</div>
			</td>
			<td valign="middle" width="381"><font size="2" face="Arial"> <input
				name="buscarFechaVen" value="" onfocus="blur();" 
				onclick="document.forms.porAsunto.buscarFechaVen.value=''" class="blue100">
			</font><a><img src="../Imagenes/cal.gif" border="0"
				title="Selecciona una Fecha" width="16" height="16"
				onclick='show_calendar("forms[0].buscarFechaVen");'></a> <font
				size="1" color="#004080" face="Arial">(dd/mm/aaaa)</font> <!-- <input type="button" onclick="" value="" class="s-dropdown-btn"> -->
			</td>
		</tr>
	</TBODY>
</table>
</DIV>
<br><br>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<TBODY>
		<tr valign="top">
			<td width="863" colspan="4" align="center">
				<input type="button" onclick="buscarPorAsunto()" 
				value="Buscar" class="blue100">
			</td>
		</tr>
	</TBODY>
</table>
</DIV>
</FORM>
</BODY>
</HTML>
