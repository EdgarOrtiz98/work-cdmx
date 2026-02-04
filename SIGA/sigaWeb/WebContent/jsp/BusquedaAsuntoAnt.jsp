<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="meve_front" prefix="meve_front"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.search.*, java.util.*,com.meve.sigma.actualiza.ActualizaRol"
%>

<%	
	String buscarAsunto 	= 	"";
	String buscarTipo		=	"";
	String strBuscarTipo	=	"";
	String strSearch		=	"";
	String strIdAsunto 		= 	"";
	String idAsuntoAnt		= 	"";
	String stridArea		=	"";
	String strIdUsuario		=	"";
	String buscar1[][]	=	new String[0][0];
	String buscar2[][]	=	new String[0][0];
    String roles[][] = new String[0][0];
	strIdAsunto 	=	request.getParameter("idAsunto");
	buscarAsunto	=	(request.getParameter("campo1") != null)?request.getParameter("campo1"):"";
	buscarTipo 		=	(request.getParameter("tipo") != null)?request.getParameter("tipo"):"";
	strBuscarTipo	=	request.getParameter("searchOpt");
	strSearch		=	request.getParameter("searchOption");
	stridArea		=	request.getParameter("idArea");
	strIdUsuario	=	request.getParameter("idUs");
    roles = ActualizaRol.getRoles(strIdUsuario);

	String idAsuntoAntBusca 	= (request.getParameter("idAsuntoAntBusca")==null)?"":request.getParameter("idAsuntoAntBusca");
	String idAsuntoRefBusca 	= (request.getParameter("idAsuntoRefBusca")==null)?"":request.getParameter("idAsuntoRefBusca");
	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");

	StringTokenizer tokens=new StringTokenizer(idAsuntoAntBusca, "|");
	int nDatos=tokens.countTokens();
	String datos = "";

	while(tokens.hasMoreTokens()){
		String str=tokens.nextToken();
		if (!str.equals(""))
			datos = datos + str + ",";
	}
	if (!datos.equals(""))
		datos = datos.substring(0,datos.length()-1);
	else
		datos = "-1";


	if(strSearch != null && strBuscarTipo.equals("title")){
		strBuscarTipo	=	request.getParameter("searchOpt");
		strSearch	=	request.getParameter("searchOption");
		stridArea	=	request.getParameter("idArea");
		strIdAsunto 	=	request.getParameter("idAsunto");
		strIdUsuario	=	request.getParameter("idUs");

		try{
			response.sendRedirect("BusquedaAsuntoAnt.jsp?campo1="+strSearch+"&tipo="+strBuscarTipo+"&idArea="+stridArea+"&idAsunto="+strIdAsunto+"&idUs="+strIdUsuario+"&idAsuntoAntBusca="+idAsuntoAntBusca+"&idAsuntoRefBusca="+idAsuntoRefBusca+"&estValidacion="+strEstValidacion);
		}catch(java.io.IOException io){
			//System.err.println("Error de redirección->"+io);
		}
	}

	if(strSearch != null && strBuscarTipo.equals("folio")){
		strBuscarTipo	=	request.getParameter("searchOpt");
		strSearch	=	request.getParameter("searchOption");
		stridArea	=	request.getParameter("idArea");
		strIdAsunto 	=	request.getParameter("idAsunto");
		strIdUsuario	=	request.getParameter("idUs");

		try{
			response.sendRedirect("BusquedaAsuntoAnt.jsp?campo1="+strSearch+"&tipo="+strBuscarTipo+"&idArea="+stridArea+"&idAsunto="+strIdAsunto+"&idUs="+strIdUsuario+"&idAsuntoAntBusca="+idAsuntoAntBusca+"&idAsuntoRefBusca="+idAsuntoRefBusca+"&estValidacion="+strEstValidacion);
		}catch(java.io.IOException io){
			//System.err.println("Error de redirección->"+io);
		}
	}

	if(strSearch != null && strBuscarTipo.equals("idDoc")){
		strBuscarTipo	=	request.getParameter("searchOpt");
		strSearch	=	request.getParameter("searchOption");
		stridArea	=	request.getParameter("idArea");
		strIdAsunto 	=	request.getParameter("idAsunto");
		strIdUsuario	=	request.getParameter("idUs");

		try{
			response.sendRedirect("BusquedaAsuntoAnt.jsp?campo1="+strSearch+"&tipo="+strBuscarTipo+"&idArea="+stridArea+"&idAsunto="+strIdAsunto+"&idUs="+strIdUsuario+"&idAsuntoAntBusca="+idAsuntoAntBusca+"&idAsuntoRefBusca="+idAsuntoRefBusca+"&estValidacion="+strEstValidacion);
		}catch(java.io.IOException io){
			//System.err.println("Error de redirección->"+io); 
		}
	} 

	if(strSearch != null && strBuscarTipo.equals("pClave")){
		strBuscarTipo	=	request.getParameter("searchOpt");
		strSearch	=	request.getParameter("searchOption");
		stridArea	=	request.getParameter("idArea");
		strIdAsunto 	=	request.getParameter("idAsunto");
		strIdUsuario	=	request.getParameter("idUs");

		try{
			response.sendRedirect("BusquedaAsuntoAnt.jsp?campo1="+strSearch+"&tipo="+strBuscarTipo+"&idArea="+stridArea+"&idAsunto="+strIdAsunto+"&idUs="+strIdUsuario+"&idAsuntoAntBusca="+idAsuntoAntBusca+"&idAsuntoRefBusca="+idAsuntoRefBusca+"&estValidacion="+strEstValidacion);
		}catch(java.io.IOException io){
			//System.err.println("Error de redirección->"+io); 
		}
	} 


	if(buscarAsunto!= null && buscarTipo != null && buscarAsunto.length() > 0 && buscarTipo.length() > 0 ){
			if(buscarAsunto != null && buscarAsunto.length() > 0 && buscarTipo.equals("folio")){
				buscar1	=	ActualizaBuscar.getBusquedaAsuntAnt(buscarAsunto, stridArea, strIdAsunto, datos, strIdUsuario);
                                //Buscar Asuntos Intrucciones si el usuario es turnador
                                for(int i=0;i<roles.length;i++) {
                                    if(roles[i][0].equals("5")) {
                                        buscar2	= ActualizaBuscar.getBusquedaAsuntAntIns(buscarAsunto, stridArea, datos, strIdUsuario);
                                        break;
                                    } else {
                                        buscar2 = new String[0][0]; 
                                    }
                                }
			}
		
			if(buscarAsunto != null && buscarAsunto.length() > 0 && buscarTipo.equals("title")){
				buscar1	=	ActualizaBuscar.getBusquedaAsuntAntD(buscarAsunto, stridArea, strIdAsunto, datos, strIdUsuario);
				//Buscar Asuntos Intrucciones si el usuario es turnador
                                for(int i=0;i<roles.length;i++) {
                                    if(roles[i][0].equals("5")) {
                                        buscar2	= ActualizaBuscar.getBusquedaAsuntAntDIns(buscarAsunto, stridArea, datos, strIdUsuario);
                                        break;
                                    } else {
                                        buscar2 = new String[0][0]; 
                                    }
                                }
			}
		
			if(buscarAsunto != null && buscarAsunto.length() > 0 && buscarTipo.equals("idDoc")){
				buscar1	=	ActualizaBuscar.getBusquedaAsuntAntIdDoc(buscarAsunto, stridArea, strIdAsunto, datos, strIdUsuario);
				//Buscar Asuntos Intrucciones si el usuario es turnador
                                for(int i=0;i<roles.length;i++) {
                                    if(roles[i][0].equals("5")) {
                                        buscar2	=	ActualizaBuscar.getAsuntosAntIdDocIns(buscarAsunto, stridArea, datos, strIdUsuario);
                                        break;
                                    } else {
                                        buscar2 = new String[0][0]; 
                                    }
                                }
			}
		
			if(buscarAsunto != null && buscarAsunto.length() > 0 && buscarTipo.equals("pClave")){
				buscar1	=	ActualizaBuscar.getAsuntosAntPalabraClave(buscarAsunto, stridArea, strIdAsunto, datos, strIdUsuario);
				//Buscar Asuntos Intrucciones si el usuario es turnador
                                for(int i=0;i<roles.length;i++) {
                                    if(roles[i][0].equals("5")) {
                                        buscar2	=	ActualizaBuscar.getAsuntosAntPalabraClaveIns(buscarAsunto, stridArea, datos, strIdUsuario);
                                        break;
                                    } else {
                                        buscar2 = new String[0][0]; 
                                    }
                                }
			}
	}
 %>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Anexar Referencia</TITLE>
<SCRIPT language=JavaScript type=text/javascript>

	function aceptar(){
		var form = document.searchOpt;
  		var cadena = "";
		var cadena2 = "";
		var IdValue = "";
  		var numdoc=0;
		var numdoc2=0;
		var cadenaid;
		//var idsAnt = window.opener.document.forms[0].idAsuntoAnt.value;
		//var idsRef = window.opener.document.forms[0].idAsuntoRef.value;
		var idsAnt = form.idAsuntoAntBusca.value;
		var idsRef = form.idAsuntoRefBusca.value;

		/**
		*	Extrae id de Asunto para generar una  liga.
		*/
		for (var i = 0; i < form.elements.length; i++) {
    		if (form.elements[i].type == "checkbox") {
      			if (form.elements[i].name == "asuAnt") {
        			if (form.elements[i].checked == true){
        				valor = form.elements[i].value;
        				if(valor != ""){
							cadena = cadena + valor  + "|";
							cadena2 = cadena2 + "r" + "|";
        					numdoc=numdoc + 1;
							
						}
        			}
      			}
    		}
		}
		if (cadena == "")
			alert("Debe seleccionar un documento"); 
		
		else {
        	cadena  = cadena  + idsAnt;
			cadena2 = cadena2 + idsRef;
			/*window.opener.document.AnexarRef.idAsuntoAnt.value = cadena;
			window.opener.document.AnexarRef.idAsuntoRef.value = cadena2;
			window.opener.document.AnexarRef.submit();
			window.close();*/
			location.assign('AnexarReferencia.jsp?strIdAsunto=<%= strIdAsunto %>&idAsuntoAnt='+ cadena +'&idAsuntoRef='+ cadena2 +'&idArea=<%= stridArea %>&idUs=<%= strIdUsuario %>&estValidacion=<%=strEstValidacion%>');
								 
		}	

	}

	function cancelar(){
		var form = document.searchOpt;
		var idsAnt = form.idAsuntoAntBusca.value;
		var idsRef = form.idAsuntoRefBusca.value;
		location.assign('AnexarReferencia.jsp?strIdAsunto=<%= strIdAsunto %>&idAsuntoAnt='+ idsAnt +'&idAsuntoRef='+ idsRef +'&idArea=<%= stridArea %>&idUs=<%= strIdUsuario %>&estValidacion=<%=strEstValidacion%>');
	}

</SCRIPT>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" LEFTMARGIN="0" TOPMARGIN="0" MARGINWIDTH="0" MARGINHEIGHT="0" 
		onload="document.searchOpt.searchOption.focus();" onunload="opener.hay_hija_uno=false">
<form name="searchOpt" action="BusquedaAsuntoAnt.jsp" method="post">
<INPUT type="hidden" name="idAsuntoAntBusca" value="<%= idAsuntoAntBusca %>">
<INPUT type="hidden" name="idAsuntoRefBusca" value="<%= idAsuntoRefBusca %>">
<INPUT type="hidden" name="idArea" value="<%=stridArea%>">
<INPUT type="hidden" name="idAsunto" value="<%=strIdAsunto%>">
<INPUT type="hidden" name="idUs" value="<%=strIdUsuario%>">
<INPUT type="hidden" value="<%=strEstValidacion%>" name="estValidacion">
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tr> 
    <td width="10%">&nbsp;</td>
    <td width="20%">&nbsp;</td>
    <td width="20%" align="center">&nbsp;
		<INPUT type="button" class="blue100" value="Aceptar" title="aceptar"  onclick="aceptar();">
    <td width="20%" align="center">&nbsp;
		<input type="button" value="Cancelar" class="blue100" onclick="cancelar();">
	</td>
    <td width="20%" colspan="2">Ayuda:&nbsp;<BR>
		<A title="Para hacer una busqueda exacta escriba el criterio (p.ej. Asunto interno de CGTIC)">
		<U>Búsqueda exacta</U> &nbsp;</A><BR>
		<A title="Para hacer una busqueda multicriterio escriba los criterios separados por comas (p.ej. CGTIC, Instrucción rechazada, Asunto interno)">
		<U>Búsqueda multicriterio</U> &nbsp; </A></td>
    <td width="10%">&nbsp;</td>
  </tr>
  <tr> 
    <td width="10%">&nbsp;</td>
    <td width="20%">&nbsp;</td>
    <td width="20%">&nbsp;</td>
    <td width="20%">&nbsp;</td>
    <td width="20%">&nbsp;</td>
    <td width="10%">&nbsp;</td>
  </tr>
  <tr> 
    <td colspan="6" align="center">
		<input type="text" name="searchOption" value="<%= buscarAsunto %>" class="blue200" onblur="focus()";>&nbsp;&nbsp;
		<IMG src="../Imagenes/ico_bus.gif" title="Buscar Asuntos" onclick="validSearch()">
	</td>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tr> 
    <td width="25%" align="center">
		<input type="radio" name="searchOpt" value="title" <%= (buscarTipo.equals("title") || buscarTipo.equals(""))?"checked":"" %>> T&iacute;tulo </td>
    <td width="25%" align="center">
    	<input type="radio" name="searchOpt" value="folio" <%= (buscarTipo.equals("folio"))?"checked":"" %>> Folio </td>
    <td width="25%" align="center">
		<input type="radio" name="searchOpt" value="idDoc" <%= (buscarTipo.equals("idDoc"))?"checked":"" %>> Identificador de Documento </td>
    <td width="25%" align="center">
		<input type="radio" name="searchOpt" value="pClave" <%= (buscarTipo.equals("pClave"))?"checked":"" %>> Palabra Clave </td>
  </tr>
</table>

<% if(buscarAsunto!= null && buscarTipo != null && buscarAsunto.length() > 0 && buscarTipo.length() > 0 ){%>
<table border="0" cellspacing="0" cellpadding="0">
	<TBODY>
		<TR>
			<TD width="283"><b><FONT size="2" color="#004080" face="Arial">
			Resultados encontrados en SIGA </FONT></b></TD>
			<td width="133"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</TR>
		<TR>
			<td width="863" bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</TR>
	</TBODY>
</table>
<BR>
<% if(buscar1.length == 0 && buscar2.length == 0){ %>
<table border="0" cellspacing="0" cellpadding="0">
<TBODY>
	<TR>
		<TD width="383"><b><FONT size="2" color="red" face="Arial">
			No se encontraron Documentos</FONT></b></TD>
		<td width="33"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
</TBODY>
</table>
<% }else{ %>
<DIV class=documentBody id=Body>
<table border="0" width="608" align="center">
	<TR bgcolor="#00204f">
		<TH width="30">
		<CENTER><b><FONT size="2" color="white" face="verdana"></FONT></b></CENTER>
		</TH>
		<TH width="133">
		<CENTER><b><FONT size="1" color="white" face="verdana">FOLIO</FONT></b>
		</CENTER>
		</TH>
		<TH width="172">
		<CENTER><b><FONT size="1" color="white" face="verdana">NOMBRE DEL
		ASUNTO</FONT></b></CENTER>
		</TH>
		<TH width="168">
		<CENTER><b><FONT size="1" color="white" face="verdana">FOLIO DOCUMENTO</FONT></b></CENTER>
		</TH>
		<TH width="95">
		<CENTER><b><FONT size="1" color="white" face="verdana">ESTATUS</FONT></b>
		</CENTER>
	</TR>
	<TBODY>
		<% if(buscarTipo.equals("title")){%>
		<% for(int i=0;i<buscar1.length;i++){
			
			String strEstatus		=	"";
			switch(Integer.parseInt(buscar1[i][4])){
                    case 0:
                        strEstatus = "Recepción";
                    break;
                    case 1:
                        strEstatus = "Por Turnar";
                    break;
                    case 2: 
                        strEstatus = "Turnado";
                    break;
                    case 3:
                        strEstatus = "Terminado";
                    break;
                    default:
                    break;
		}			
		 %>
		<TR>
			<TD width="30">
			<CENTER><input type=checkbox name="asuAnt" value="<%=buscar1[i][0]%>"></CENTER>
			</TD>
			<TD width="133">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar1[i][1]%></FONT>
			</CENTER>
			</TD>
			<td width="172">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar1[i][2]%></FONT>
			</CENTER>
			</td>
			<td width="168">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar1[i][3]%></FONT>
			</CENTER>
			</td>
			<td width="95">
			<CENTER><input type="hidden" value="r" name="ref">
			<FONT size="1" color="#000080" face="Arial"><%=strEstatus%></FONT>
			</CENTER>
			</td>
		</TR>
		<% } %>
		<% for(int i=0;i<buscar2.length;i++){
			
			String strEstatus		=	"";
                    switch(Integer.parseInt(buscar2[i][4])){
                    case 0:
                        strEstatus = "Recepción";
                    break;
                    case 1:
                        strEstatus = "Por Turnar";
                    break;
                    case 2: 
                        strEstatus = "Turnado";
                    break;
                    case 3:
                        strEstatus = "Terminado";
                    break;
                    default:
                    break;
                } 
					
		 %>
		<TR>
			<TD width="30">
			<CENTER><input type=checkbox name="asuAnt" value="<%=buscar2[i][0]%>"></CENTER>
			</TD>
			<TD width="133">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar2[i][1]%></FONT>
			</CENTER>
			</TD>
			<td width="172">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar2[i][2]%></FONT>
			</CENTER>
			</td>
			<td width="168">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar2[i][3]%></FONT>
			</CENTER>
			</td>
			<td width="95">
			<CENTER><input type="hidden" value="r" name="ref">
			<FONT size="1" color="#000080" face="Arial"><%=strEstatus%></FONT>
			</CENTER>
			</td>
		</TR>
		<% } %>
		<% }else{ %>
		<% if(buscarTipo.equals("folio")){ %>
		<% for(int i=0;i<buscar1.length;i++){ 
			
			String strEstatus		=	"";
                        switch(Integer.parseInt(buscar1[i][4])){
                    case 0:
                        strEstatus = "Recepción";
                    break;
                    case 1:
                        strEstatus = "Por Turnar";
                    break;
                    case 2: 
                        strEstatus = "Turnado";
                    break;
                    case 3:
                        strEstatus = "Terminado";
                    break;
                    default:
                    break;
                    }		

		%>
		<TR>
			<TD width="30">
			<CENTER><input type=checkbox name="asuAnt" value="<%=buscar1[i][0]%>"></CENTER>
			</TD>
			<TD width="133">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar1[i][1]%></FONT>
			</CENTER>
			</TD>
			<td width="172">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar1[i][2]%></FONT>
			</CENTER>
			</td>
			<td width="168">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar1[i][3]%></FONT>
			</CENTER>
			</td>
			<td width="95">
			<CENTER><input type="hidden" value="r" name="ref">
			<FONT size="1" color="#000080" face="Arial"><%=strEstatus%></FONT>
			</CENTER>
			</td>
		</TR>
		<%}%>
		<% for(int i=0;i<buscar2.length;i++){ 
			
			String strEstatus		=	"";
			switch(Integer.parseInt(buscar2[i][4])){
                    case 0:
                        strEstatus = "Recepción";
                    break;
                    case 1:
                        strEstatus = "Por Turnar";
                    break;
                    case 2: 
                        strEstatus = "Turnado";
                    break;
                    case 3:
                        strEstatus = "Terminado";
                    break;
                    default:
                    break;
                    }

		%>
		<TR>
			<TD width="30">
			<CENTER><input type=checkbox name="asuAnt" value="<%=buscar2[i][0]%>"></CENTER>
			</TD>
			<TD width="133">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar2[i][1]%></FONT>
			</CENTER>
			</TD>
			<td width="172">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar2[i][2]%></FONT>
			</CENTER>
			</td>
			<td width="168">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar2[i][3]%></FONT>
			</CENTER>
			</td>
			<td width="95">
			<CENTER><input type="hidden" value="r" name="ref">
			<FONT size="1" color="#000080" face="Arial"><%=strEstatus%></FONT>
			</CENTER>
			</td>
		</TR>
		<%}%>
		<%}%>
		<%}%>
		<% if(buscarTipo.equals("idDoc")){ %>
		<% for(int i=0;i<buscar1.length;i++){ 

			String strEstatus		=	"";
			switch(Integer.parseInt(buscar1[i][4])){
                    case 0:
                        strEstatus = "Recepción";
                    break;
                    case 1:
                        strEstatus = "Por Turnar";
                    break;
                    case 2: 
                        strEstatus = "Turnado";
                    break;
                    case 3:
                        strEstatus = "Terminado";
                    break;
                    default:
                    break;
                    }
		%>
		<TR>
			<TD width="30">
			<CENTER><input type=checkbox name="asuAnt" value="<%=buscar1[i][0]%>"></CENTER>
			</TD>
			<TD width="133">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar1[i][1]%></FONT>
			</CENTER>
			</TD>
			<td width="172">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar1[i][2]%></FONT>
			</CENTER>
			</td>
			<td width="168">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar1[i][3]%></FONT>
			</CENTER>
			</td>
			<td width="95">
			<CENTER><input type="hidden" value="r" name="ref">
			<FONT size="1" color="#000080" face="Arial"><%=strEstatus%></FONT>
			</CENTER>
			</td>
		</TR>
		<%}%>
		<% for(int i=0;i<buscar2.length;i++){ 

			String strEstatus = "";
			switch(Integer.parseInt(buscar2[i][4])){
                    case 0:
                        strEstatus = "Recepción";
                    break;
                    case 1:
                        strEstatus = "Por Turnar";
                    break;
                    case 2: 
                        strEstatus = "Turnado";
                    break;
                    case 3:
                        strEstatus = "Terminado";
                    break;
                    default:
                    break;
                    }
		%>
		<TR>
			<TD width="30">
			<CENTER><input type=checkbox name="asuAnt" value="<%=buscar2[i][0]%>"></CENTER>
			</TD>
			<TD width="133">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar2[i][1]%></FONT>
			</CENTER>
			</TD>
			<td width="172">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar2[i][2]%></FONT>
			</CENTER>
			</td>
			<td width="168">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar2[i][3]%></FONT>
			</CENTER>
			</td>
			<td width="95">
			<CENTER><input type="hidden" value="r" name="ref">
			<FONT size="1" color="#000080" face="Arial"><%=strEstatus%></FONT>
			</CENTER>
			</td>
		</TR>
		<%}%>
		<%}%>
		<% if(buscarTipo.equals("pClave")){ %>
		<% for(int i=0;i<buscar1.length;i++){ 

			String strEstatus		=	"";
			switch(Integer.parseInt(buscar1[i][4])){
                    case 0:
                        strEstatus = "Recepción";
                    break;
                    case 1:
                        strEstatus = "Por Turnar";
                    break;
                    case 2: 
                        strEstatus = "Turnado";
                    break;
                    case 3:
                        strEstatus = "Terminado";
                    break;
                    default:
                    break;
                    }	

		%>
		<TR>
			<TD width="30">
			<CENTER><input type=checkbox name="asuAnt" value="<%=buscar1[i][0]%>"></CENTER>
			</TD>
			<TD width="133">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar1[i][1]%></FONT>
			</CENTER>
			</TD>
			<td width="172">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar1[i][2]%></FONT>
			</CENTER>
			</td>
			<td width="168">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar1[i][3]%></FONT>
			</CENTER>
			</td>
			<td width="95">
			<CENTER><input type="hidden" value="r" name="ref">
			<FONT size="1" color="#000080" face="Arial"><%=strEstatus%></FONT>
			</CENTER>
			</td>
		</TR>
		<%}%>
		<% for(int i=0;i<buscar2.length;i++){ 

			String strEstatus		=	"";
			switch(Integer.parseInt(buscar2[i][4])){
                    case 0:
                        strEstatus = "Recepción";
                    break;
                    case 1:
                        strEstatus = "Por Turnar";
                    break;
                    case 2: 
                        strEstatus = "Turnado";
                    break;
                    case 3:
                        strEstatus = "Terminado";
                    break;
                    default:
                    break;
                    }

		%>
		<TR>
			<TD width="30">
			<CENTER><input type=checkbox name="asuAnt" value="<%=buscar2[i][0]%>"></CENTER>
			</TD>
			<TD width="133">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar2[i][1]%></FONT>
			</CENTER>
			</TD>
			<td width="172">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar2[i][2]%></FONT>
			</CENTER>
			</td>
			<td width="168">
			<CENTER><FONT size="1" color="#000080" face="Arial"><%=buscar2[i][3]%></FONT>
			</CENTER>
			</td>
			<td width="95">
			<CENTER><input type="hidden" value="r" name="ref">
			<FONT size="1" color="#000080" face="Arial"><%=strEstatus%></FONT>
			</CENTER>
			</td>
		</TR>
		<%}%>
		<%}%>
	</TBODY>
</table>
<BR>
</DIV>
<BR>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
<% } %>
<%}  %>
<BR>
</form>
</BODY>
</HTML>