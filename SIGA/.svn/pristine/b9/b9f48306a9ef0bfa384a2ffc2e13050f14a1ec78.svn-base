<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:useBean id="BList" class="com.meve.sigma.beans.ListUserUR" scope="page">
	<jsp:setProperty name="BList" property="*" />
<HTML> 
<HEAD>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.meve.sigma.beans.*, com.meve.sigma.taglib.*, com.meve.sigma.actualiza.*,com.meve.sigma.util.*,java.util.*"%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String p = (request.getParameter("para")== null)?"":request.getParameter("para");
	String ip = (request.getParameter("ipara")== null)?"":request.getParameter("ipara");
	String strIdArea = (BList.getIdArea()== null)?"":BList.getIdArea();
	String nombreTO = (BList.getTmpSendToRef()== null)?p:BList.getTmpSendToRef();
	String strIdsTO = (BList.getIdsTO()== null)?ip:BList.getIdsTO();


	String strIdAreaUs = (request.getParameter("idAreaUs")== null)?"":request.getParameter("idAreaUs");

	String strUsuarios[][] = new String[0][0];
	if(strIdArea.length() != 0 && strIdArea != null){
		strUsuarios = ActualizaUsuario.getRemitenteXEntidad(strIdArea);  
	}
	
	Vector lista = Utilerias.getNombres1(nombreTO.trim());
	Vector listaIDSPara = Utilerias.getNombres(strIdsTO.trim());

%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="../css/link.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script type="text/javascript" src="../js/link.js"></script>
<script type="text/javascript">
<!--
	function verNuevaEntidad(idArea){
		location.assign('FrameEntidad.jsp?id_us='+idArea+'&porcedencia=receptor&b=2&retURI=<%=Utilerias.codificaPostHTML("listUserURExt.jsp?para=" + Utilerias.codificaPostHTML(nombreTO) + "&ipara=" + strIdsTO + "&idAreaUs=" + strIdAreaUs)%>');
	}

	function cambioVista(){
		location.assign('FrameRemitente.jsp?num=2&porcedencia=receptor&retURI=<%=Utilerias.codificaPostHTML("listUserURExt.jsp?para=" + Utilerias.codificaPostHTML(nombreTO) + "&ipara=" + strIdsTO + "&idAreaUs=" + strIdAreaUs)%>');
	}
//-->
</script>
<TITLE>Lista de Destinatarios Externos</TITLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onunload="opener.hay_hija=true"
	onClick="opener.resetTimer();"
	onKeyPress="opener.resetTimer();">
<FORM name="listUserUAE" action="listUserURExt.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<input name="tmpSendToRef" type="hidden" value="<%=nombreTO%>">
<input name="tmpCopyToRef" type="hidden" value="">
<input name="idsTO" type="hidden" value="<%=strIdsTO%>">
<input name="idsCC" type="hidden" value="">
<INPUT name="idAreaUs" type="hidden" value="<%= strIdAreaUs %>">
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="1">&nbsp;</td>   
		<td width="444"><img width="1" height="1"
			src="../Imagenes/ecblank.gif" border="0" title=""></td>
		<td width="88"><img width="1" height="1" src="../Imagenes/ecblank.gif"
			border="0" title=""></td>
		<td width="333"><IMG width="1" height="1"
			src="../Imagenes/ecblank.gif" border="0" title=""></td>
	</tr>
	<tr valign="top">
		<td class="etiquetas" width="1"></td>
		<td colspan="3"><meve_combo:comboseleccion
			data="<%= ComboData.getEntidadComboXArea(BUsuario.getIdArea()) %>" size="1" name="idArea"
			classHtml="blue700a" selected="<%=strIdArea%>"
			textoNoSeleccion="---------------------------------------------- Selecciona una Entidad ----------------------------------------------"
			valorNoSeleccion="-1"
			script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='reloadListUserURE()'" />
		</td>
	</tr>
</table>
</DIV>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="1">&nbsp;</td>   
		<td width="444"><img width="1" height="1"
			src="../Imagenes/ecblank.gif" border="0" title=""></td>
		<td width="88"><img width="1" height="1" src="../Imagenes/ecblank.gif"
			border="0" title=""></td>
		<td width="333"><IMG width="1" height="1"
			src="../Imagenes/ecblank.gif" border="0" title=""></td>
	</tr>
	<tr valign="top">
		<td class="etiquetas" width="1"></td>
		<td width="444"><img width="1" height="1" src="../Imagenes/ecblank.gif"
			border="0" title=""></td>
		<td width="88"><img width="1" height="1" src="../Imagenes/ecblank.gif"
			border="0" title=""></td>
		<td width="333">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" onclick="verNuevaEntidad(<%=strIdAreaUs%>)" value="Otra Entidad" class="blue100a">
			&nbsp;&nbsp;<input type="button" onclick="cambioVista()" value="Otro Remitente" class="blue100a" >
		</td>
	</tr>
	<tr valign="top">
		<td width="1">&nbsp;</td>
		<td width="444"><img width="1" height="1"
			src="../Imagenes/ecblank.gif" border="0" title=""></td>
		<td width="88"><img width="1" height="1" src="../Imagenes/ecblank.gif"
			border="0" title=""></td>
		<td width="333"><img width="1" height="1" src="../Imagenes/ecblank.gif"
			border="0" title=""></td>
	</tr>

	<tr valign="top">
		<td rowspan="3" colspan="2" align="left">
		 	<SELECT NAME="EntryList" size="20" multiple="multiple" class="blue400a">
				<%for(int i=0;i<strUsuarios.length;i++){%>
				<OPTION value="<%=strUsuarios[i][0]%>"><%=strUsuarios[i][1]%> - <%=ActualizaEntidad.getNombreEntidad(strIdArea)%></OPTION>
				<%}%>
			</SELECT><BR>
			<%if(strUsuarios.length!=0){%>
			<B>Buscar:</B> &nbsp;&nbsp;&nbsp;<IMG width="1" height="1"
				src="../Imagenes/ecblank.gif" border="0" title=""><INPUT type="text"
				name="buscaDest" class="blue300"
				onkeyup="buscaElementosLista(document.listUserUAE.EntryList, document.listUserUAE.buscaDest)" maxlength="199">
			<%}else{%>
			<B>Buscar:</B> &nbsp;&nbsp;&nbsp;<IMG width="1" height="1"
				src="../Imagenes/ecblank.gif" border="0" title=""><INPUT type="text"
				name="buscaDest" class="blue300" disabled="disabled"
				onkeyup="buscaElementosLista(document.listUserUAE.EntryList, document.listUserUAE.buscaDest)" maxlength="199">
			<%}%>
		</td>
		<td align="center" width="88"><input type="button" 
			onclick="addSelected(document.listUserUAE.listTO, document.listUserUAE.EntryList, document.listUserUAE.listTO);
					tmpSendToRef.value = selectToStringAndID(document.listUserUAE.listTO);
					idsTO.value = selectToIdString(document.listUserUAE.listTO)"
			value=" Para &gt; " class="blue50"><BR>
			<BR>
			<INPUT type="button"
				onclick="quitaElementosListTOE(document.listUserUAE.listTO);
					tmpSendToRef.value = selectToStringAndID(document.listUserUAE.listTO);
					idsTO.value = selectToIdString(document.listUserUAE.listTO)"
				value="&lt;&lt; " class="blue50" name="quitaTO"><BR><BR>
			</td>
		<td align="center" width="333">
			<select name="listTO" size="6" class="blue300a" multiple="multiple">
			<%for(int t=0;t<lista.size();t++){%>
			<OPTION value="<%=listaIDSPara.elementAt(t)%>"><%=lista.elementAt(t)%></OPTION>
			<%}%>
			</select>
		<BR>
			<BR>
			<BR>
			<BR>
			<BR>
			</td>
		
	</tr>

	<tr valign="top">
		<td align="center" height="115" width="88"><BR>
			<BR>
			<BR>
			<BR>
			<!--<input type="button" 
			onclick="RemoveSelected(document.listUserUA.listCC);"
			value="&lt;" class="blue50"> -->
			</td>
		<td align="center" height="115" width="333">
			</td>
	</tr>

	<tr valign="top">
		<td align="center" width="88" height="25"></td>
		<td align="center" width="333" height="25">
		<div align="center"><input type="button" onclick="RemoveAllClickE()"
			value="Eliminar Todo" class="blue100"></div>
		</td>
	</tr>

	<tr valign="top">
			<td colspan="2" align="center" height="9"></td>
			<td width="88" height="9"><img width="1" height="1" src="../Imagenes/ecblank.gif"
			border="0" title=""></td>
		<td width="333" height="9"></td>
	</tr>

	<tr valign="top">
			<td colspan="4" height="43">
			<div align="center">
			<hr width="100%" size="2" align="center">
			</div>
			<div align="right"><input type="button" onclick="aceptarListExt()"
				value="OK" name="OK" class="blue100"> <input type="button"
				onclick="Cancelar();"
				value=" Cancel" class="blue100"></div>
			</td>
		</tr>
</table>
</DIV>
</FORM>
</BODY>
</HTML>
</jsp:useBean>