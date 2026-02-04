<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:useBean id="BList" class="com.meve.sigma.beans.ListUserUR" scope="page">
	<jsp:setProperty name="BList" property="*" />
<HTML>
<HEAD>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.meve.sigma.taglib.*, com.meve.sigma.actualiza.*,com.meve.sigma.util.*,java.util.*"%>
<%
	String p = (request.getParameter("para")== null)?"":request.getParameter("para");
	String c = (request.getParameter("cc")== null)?"":request.getParameter("cc");
	String ip = (request.getParameter("ipara")== null)?"":request.getParameter("ipara");
	String ic = (request.getParameter("icc")== null)?"":request.getParameter("icc");
	String tipoFolio= (request.getParameter("tipoFolio")== null)?"":request.getParameter("tipoFolio");
	String idAreaGen= (request.getParameter("idAreaGen")== null)?"":request.getParameter("idAreaGen");
	String strIdArea = (BList.getIdArea()== null)?"":BList.getIdArea();
	String nombreTO = (BList.getTmpSendToRef()== null)?p:BList.getTmpSendToRef();
	String nombreCC = (BList.getTmpCopyToRef()== null)?c:BList.getTmpCopyToRef();
	String strIdsTO = (BList.getIdsTO()== null)?ip:BList.getIdsTO();
	String strIdsCC = (BList.getIdsCC()== null)?ic:BList.getIdsCC();
	String strUsuarios[][] = new String[0][0];
	if(strIdArea.length() != 0 && strIdArea != null){
		strUsuarios = ActualizaUsuario.getUsuarioAreaAtencion(strIdArea);
	}
	Vector lista = Utilerias.getNombres1(nombreTO.trim());
	Vector listaCC = Utilerias.getNombres1(nombreCC.trim());
	Vector listaIPara = Utilerias.getNombres(strIdsTO.trim());
	Vector listaICC = Utilerias.getNombres(strIdsCC.trim());
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
<script type="text/javascript" src="../js/ajax.js"></script>
<script type="text/javascript" src="../js/link.js"></script>
<TITLE>Lista de Destinatarios</TITLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onunload="opener.hay_hija=true"
	onClick="opener.resetTimer();"
	onKeyPress="opener.resetTimer();">
<FORM name="listUserUA" action="listUserUR.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<input name="tmpSendToRef" type="hidden" value="<%=nombreTO%>">
<input name="tmpCopyToRef" type="hidden" value="<%=nombreCC%>">
<input name="idsTO" type="hidden" value="<%=strIdsTO%>">
<input name="idsCC" type="hidden" value="<%=strIdsCC%>">
<input name="tipoFolio" type="hidden" value="<%=tipoFolio %>">
<input name="idAreaGen" type="hidden" value="<%=idAreaGen %>">
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
		<td colspan="3">
			<SELECT  name="idArea" class="blue700a" onkeypress="buscar_op1(this)" 
					onblur="borrar_buffer()" onclick="borrar_buffer()" 
					onchange="reloadListUserUR();">
				<OPTION value="-1">---------------------------------------------- Selecciona una Unidad Administrativa ----------------------------------------------</OPTION>
				<%
				String strArea[][]=ComboData.getAreaComboListDes();
				for(int i=0;i<strArea.length;i++){
				%>
				<%if(strArea[i][2].equals("0")){%>
				<OPTION value="<%=strArea[i][0]%>" <%=(strIdArea.equals(strArea[i][0]))?"selected":""%>><%=strArea[i][1]%></OPTION>
				<%}else{%>
				<OPTION value="<%=strArea[i][0]%>" style="color:red;" <%=(strIdArea.equals(strArea[i][0]))?"selected":""%>><%=strArea[i][1]%></OPTION>
				<%}%>
				<%}%>
			</SELECT>
		</td>
	</tr>
</table>
</DIV>
<br>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="1">&nbsp;</td>
		<td width="444"><img width="1" height="1"
			src="../Imagenes/ecblank.gif" border="0" title=""></td>
		<td width="88"><img width="1" height="1" src="../Imagenes/ecblank.gif"
			border="0" title=""></td>
			<td width="333" align="left"><B></B></td>
		</tr>

	<tr valign="top">
		<td rowspan="3" colspan="2" align="left" valign="top">
			<SELECT NAME="EntryList" size="20" multiple="multiple" class="blue400a">
				<%for(int i=0;i<strUsuarios.length;i++){%>
				<OPTION value="<%=strUsuarios[i][0]%>"><%=strUsuarios[i][4]%>/<%=strUsuarios[i][1]%></OPTION>
				<%}%>
			</SELECT><BR>
			<%if(strUsuarios.length!=0){%>
			<B>Buscar:</B>&nbsp;&nbsp;&nbsp;<IMG width="1" height="1"
				src="../Imagenes/ecblank.gif" border="0" title=""><INPUT type="text"
				name="buscaDest" class="blue300"
				onkeyup="buscaElementosLista(document.listUserUA.EntryList, document.listUserUA.buscaDest)" maxlength="199">
			<%}else{%>
			<B>Buscar:</B>&nbsp;&nbsp;&nbsp;<IMG width="1" height="1"
				src="../Imagenes/ecblank.gif" border="0" title=""><INPUT type="text"
				name="buscaDest" class="blue300" disabled="disabled"
				onkeyup="buscaElementosLista(document.listUserUA.EntryList, document.listUserUA.buscaDest)" maxlength="199">
			<%}%>
			</td>
		<td align="center" width="88"><input type="button" 
			onclick="addSelected(document.listUserUA.listTO, document.listUserUA.EntryList, document.listUserUA.listCC);
					tmpSendToRef.value = selectToStringAndID(document.listUserUA.listTO,'<%=strIdArea%>');
					idsTO.value = selectToIdString(document.listUserUA.listTO)"
			value=" Para &gt; " class="blue50"><BR>
			<BR>
			<INPUT type="button"
				onclick="quitaElementosListTO(document.listUserUA.listTO);
					tmpSendToRef.value = selectToStringAndID(document.listUserUA.listTO);
					idsTO.value = selectToIdString(document.listUserUA.listTO)"
				value="&lt;&lt; " class="blue50" name="quitaTO"><BR><BR>
		</td>
		<td align="center" width="333">
			<select name="listTO" size="6" class="blue300a" multiple="multiple">
			<%for(int t=0;t<lista.size();t++){%>
			<OPTION value="<%=listaIPara.elementAt(t)%>"><%=lista.elementAt(t)%></OPTION>
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
		<td align="center" height="115" width="88"><input type="button" 
			onclick="addSelected(document.listUserUA.listCC, document.listUserUA.EntryList, document.listUserUA.listTO);
					tmpCopyToRef.value = selectToStringAndID(document.listUserUA.listCC);
					idsCC.value = selectToIdString(document.listUserUA.listCC)"
			value=" Ccp &gt; " class="blue50"><BR>
			<BR>
			<INPUT type="button"
				onclick="quitaElementosListCC(document.listUserUA.listCC);
					tmpCopyToRef.value = selectToStringAndID(document.listUserUA.listCC);
					idsCC.value = selectToIdString(document.listUserUA.listCC)"
				value="&lt;&lt; " class="blue50" name="quitaCC"><BR>
			<BR>
		</td>
		<td align="center" height="115" width="333">
			<select name="listCC" size="6" class="blue300a" multiple="multiple">
				<%for(int t=0;t<listaCC.size();t++){%>
				<OPTION value="<%=listaICC.elementAt(t)%>"><%=listaCC.elementAt(t)%></OPTION>
				<%}%>
			</select>
		</td>
	</tr>
	<tr valign="top">
		<td align="center" width="88" height="25"></td>
		<td align="center" width="333" height="25">
		<div align="center"><input type="button" onclick="RemoveAllClick()"
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
			<div align="right"><input type="button" onclick="compruebaAreaDestinatarios('<%=idAreaGen%>',idsTO.value,idsCC.value,'<%=tipoFolio%>'); return false;"
				value="Aceptar" name="OK" class="blue100"> <input type="button"
				onclick="Cancelar()"
				value=" Cancelar" class="blue100"></div>
			</td>
		</tr>
</table>
</DIV>
</FORM>
</BODY>
</HTML>
</jsp:useBean>
