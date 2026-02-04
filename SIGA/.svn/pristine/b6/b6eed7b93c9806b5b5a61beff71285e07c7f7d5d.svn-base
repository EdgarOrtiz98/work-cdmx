<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.taglib.*"
%>
<%
	String strIdArea 					= 	"";
	String strDatosRemitenteArea[][]	=	null;
	
	boolean	bExisteReg = false;
	bExisteReg		   = ActualizaUsuario.getExistenUsuarios();
	int t = 0;
	boolean bMostrar	=	false;
	String strAccion = request.getParameter("accion");
	String strIdUsuario = (request.getParameter("idUs")!=null)?request.getParameter("idUs"):"";
	String strIdAsunto = (request.getParameter("ida")!=null)?request.getParameter("ida"):"";
%>
<%!
	public static boolean par(int num)
    {
        boolean p = false;
        if (num % 2 == 0) 
        {
            p = true;
        }    
        return p;
    }
%> 
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>FrameDestinatario.jsp</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<SCRIPT language="JavaScript" type="text/javascript">
	
	function aceptar(){
		
		var form = document.framedestinatario;
  		var cadena = "";
  		var numdoc=0;
		for (var i = 0; i < form.elements.length; i++) {
    		if (form.elements[i].type == "radio") {
      			if (form.elements[i].name == "Sel") {
        			if (form.elements[i].checked == true){
        				valor = form.elements[i].value;
        				if(valor != ""){
							cadena = cadena + valor;
        					numdoc=numdoc + 1;
						}
        			}
      			}
    		}
		}
		if (cadena == "")
			alert("Debe seleccionar un documento"); 

		else {
        	if (numdoc >1)
					alert("Debe seleccionar sólo un documento");
           	else {
				var ID = valor.substring(0, valor.indexOf("|"));
				var nombre = valor.substring(valor.indexOf("|")+1, valor.indexOf("/"));
				var cargo = valor.substring(valor.indexOf("/")+1, valor.indexOf("*"));
				var area = valor.substring(valor.indexOf("*")+1, valor.indexOf("&"));
				var correo = valor.substring(valor.indexOf("&")+1, valor.length);
				parent.window.document.forms[0].idDestinatario.value = ID;
				parent.window.document.forms[0].asuntoDestinatario.value = nombre;
				parent.window.document.forms[0].asuntoCargoDest.value = cargo;
				parent.window.document.forms[0].asuntoAreaDest.value = area;
				parent.window.document.forms[0].mailDest.value = correo;
				cerrarIframe('pop4', '<%=strIdAsunto%>');
			}
		}
	}

	function desplegar(id){
		doc = document.framedestinatario;
		doc.accion.value="reload";
		doc.idUs.value=id;
		doc.submit();
	}

</SCRIPT>

</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg">
<form name="framedestinatario" action="FrameDestinatario.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="" name="idUs">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="50%">
			<DIV>
				<input type="button" value="Aceptar" class="blue100" onclick="aceptar()">
				<input type="button" value="Cancelar" class="blue100" onclick="cerrarIframe('pop4', '<%=strIdAsunto%>');">
			</DIV>
		</td>
		<td width="50%" align="right">
			<b><font size="2" color="#00204F" face="Verdana">Destinatario</font></b>
		</td>
	</tr>
</table>
<TABLE width="100%" BORDER="0">
	<TR BGCOLOR="00204F">
		<TD WIDTH="50%" align="center">
			<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial"><b>Destinatario</b></font>
		</TD>
		<TD WIDTH="50%" align="center">
			<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial"><b>Unidad Administrativa</b></font>
		</TD>
	</TR>	
</TABLE>
<% if(bExisteReg){ %>
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
	<meve_front:ListaDatos datos="<%= ComboData.getAreasCombo() %>" campo="campo">
		<% bMostrar = strIdUsuario.equals(campo1); %>
		<table border="0" cellpadding="2" cellspacing="0">
		<TBODY>
			<tr valign="top">
				<td colspan="2" width="600">
					<a onClick="desplegar(<%=campo1%>)">
					<img src="../Imagenes/<%=(bMostrar)?"collapse.gif":"expand.gif"%>" 
						border="0" height="16" width="16">
						<%= ActualizaArea.NombreArea(campo1) %>
					</a>
				</td>
			</tr>
			<%if(bMostrar){ %>  
			<meve_front:ListaDatos datos="<%= ActualizaUsuario.getUsuarioPorRol(campo1) %>" campo="usuario">
			<%t++;%>
			<tr valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
				<td width="50%" align="left">
					<INPUT type="radio" name="Sel" value="<%= usuario1 %>|<%= usuario2 %>/<%= usuario3 %>*<%= usuario4 %>&<%= usuario5 %>">
					<IMG height=1 src="../Imagenes/ecblank.gif" width=16 border=0>
					<FONT face=Arial color=#000080 size=1>
						<%= usuario2 %>
					</FONT>
				</td>
				<TD width="50%" align="center">
					<FONT face=Arial color=#000080 size=1>
						<%= usuario5 %>
					</FONT>
				</TD>
			</tr>
			</meve_front:ListaDatos>
			<%}%>
		</TBODY>
		</table>
	</meve_front:ListaDatos>
</TABLE>
<% }else{ %>
<CENTER>
<table cellspacing="2" cellpadding="2">
	<tr>
		<TD align="center">
			<DIV align="center">
				<p><FONT size="4" face="Verdana">***** No se han encontrado
		Documentos ***** </FONT></DIV>
		</TD>
	</tr>
</table>
</CENTER>
<% } %>
</form>
</BODY>

</HTML>
