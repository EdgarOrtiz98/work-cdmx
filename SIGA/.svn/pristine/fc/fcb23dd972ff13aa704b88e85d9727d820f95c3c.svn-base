<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}

%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>Seleccionar Usuarios</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<SCRIPT language="JavaScript" type="text/javascript">
	
	function aceptar(){
		
		var form = document.forms[0];
  		var cadena = "";
  		var numdoc=0;
		for (var i = 0; i < form.elements.length; i++) {
    		if (form.elements[i].type == "checkbox") {
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
			alert("Debe seleccionar un Usuario"); 

		else{ 
        	if (numdoc >1)
					alert("Debe seleccionar sólo un documento");
           	else {
				var ID = valor.substring(0, valor.indexOf("|"));
				var nombre = valor.substring(valor.indexOf("|")+1, valor.length);
				window.opener.document.forms[0].idUsuario.value = ID;
				window.opener.document.forms[0].responderA.value = nombre;
				window.close();
			}
		}
	}

</SCRIPT>

</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="SeleccionarUsuarios.jsp" name="SelUsr" method="post">
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
			<INPUT class="blue100" type="button" value="Aceptar" onclick="aceptar()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<INPUT class="blue100" type="button" value="Cancelar" onclick="window.close();">
		</TD>	
	</TR>
	<tr valign="top">
		<td width="100%" bgcolor="#00204F"></td>
	</tr>
</TBODY>
</TABLE>
<DIV class=documentBody id=Body>
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<meve_front:ListaDatos datos="<%= ActualizaUsuario.getListaUsuarios() %>" campo="Lista">
		<TR valign="top">
			
			<TD align="left" width="100%">
				<INPUT type="checkbox" value="<%=Lista1 %>|<%=Lista2%>" name="Sel">
				<IMG height=1 src="../Imagenes/ecblank.gif" width=16 border=0>
				<FONT face=Arial color=#000080 size=1><%=Lista2%>/meve</FONT>
			</TD>
		</TR>
	</meve_front:ListaDatos>
</TBODY>
</TABLE>
</DIV>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>

</FORM>
</BODY>
</HTML>
