<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="meve_front" prefix="meve_front"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*"
%>
<%
	String strIdAreaUsr	= "";
	String strIdAreaGeneral = "1";
	strIdAreaUsr	=	request.getParameter("id_area");
//	//System.out.println("IdAreaUsr="+strIdAreaUsr);
%>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>Rechazar</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<SCRIPT language="JavaScript" type="text/javascript">
	
	function aceptar(){
		
		var form = document.forms[0];
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
			alert("Debe seleccionar una Razon de Rechazo"); 

		else {
        	if (numdoc >1)
					alert("Debe seleccionar sólo una Razon de Rechazo");
           	else {
				var ID = valor.substring(0, valor.indexOf("|"));
				var nombre = valor.substring(valor.indexOf("|")+1, valor.length);
				window.opener.document.forms[0].idRazon.value = ID;
				window.opener.document.forms[0].razonRechazo.value = nombre;
				window.close();
			}
		}
	}

</SCRIPT>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" onClick="timer_reload()"
	onblur="focus();">
<FORM action="RechazarVentana.jsp" name="rechazarVentana" method="post">
<INPUT type="hidden" value="<%= strIdAreaUsr %>" name="id_area">
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
	<TR valign="top">
		<TD width="100%" align="right">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<INPUT class="blue100" type="button" value="Aceptar" onclick="aceptar()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<INPUT class="blue100" type="button" value="Cancelar" onclick="window.close();">
		</TD>	
	</TR>
	<tr valign="top"> 
		<td width="100%" bgcolor="#00204F"></td>
	</tr>
	<TR valign="top">
		<TD width="100%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</TD>
    </TR>
</TBODY>
</TABLE>
</DIV>

<DIV class=documentBody id=Body>
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<meve_front:ListaDatos datos="<%= ActualizaRazonRechazo.getRazonesYGeneral(strIdAreaUsr,strIdAreaGeneral) %>" campo="campo">
	<TR valign="top">
		<TD width="100%">
			<INPUT type="radio" name="Sel" value="<%= campo1 %>|<%= campo2 %>"> <A title="<%= campo2 %>"><%= com.meve.sigma.util.Utilerias.recortaString(campo2,60) %></A> 
		</TD>
    </TR>
	</meve_front:ListaDatos>
</TBODY>
</TABLE>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>
