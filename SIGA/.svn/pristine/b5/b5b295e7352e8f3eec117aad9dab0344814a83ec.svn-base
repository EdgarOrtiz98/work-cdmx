<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<HTML>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
%>
<!--<jsp:useBean id="ldap" class="com.meve.sigma.beans.LDAPBean"
	scope="page">
</jsp:useBean>-->

<%@ page import="com.meve.sigma.ldap.*"%>
<%
	String usuario=request.getParameter("j_username");
  	String contra=request.getParameter("j_password");
  	String mensaje="";
  	String limite = application.getInitParameter("NumIntentosAcceso");
  
  	boolean autenticado	=	false;
  	if(usuario!=null && contra!=null){
  		int r=Autenticacion.AutenticaUsuario1(usuario.trim(),contra.trim(), ""/*, serverLDAP*/);
  		if(r!=Autenticacion.AUTENTICADO){
  		      mensaje="Verifique sus datos e intente de nuevo";
				autenticado=false;
		}
  		else
			autenticado=true;
  	}
  	else
		autenticado=false;
%>

<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<TITLE>Autenticación de Firma</TITLE>
<SCRIPT language="JavaScript">
function carga(){

  //alert('self.opener.document.responder.firmaDigital.checked: '+self.opener.document.responder.firmaDigital.checked);
	self.opener.document.responder.firmaDigital.checked=<%=autenticado%>;
  
  //alert('self.opener.document.responder.firmaDigital.checked: '+self.opener.document.responder.firmaDigital.checked);
  

  	if(<%=autenticado%>){
		self.opener.document.responder.firmaDigital.value = 'on';
		//alert(self.opener.document.responder.firmaDigital.value);
    	self.close();
	}

}


function validaCampos(){

  forma=document.forma1;
  if(forma.j_username==undefined || forma.j_username.value.length==0){
    alert('No ha proporcionado el nombre de usuario.');
    forma.j_username.focus();
	return false;
  }

  if(forma.j_password==undefined || forma.j_password.value.length==0){
    alert('No ha proporcionado la contraseña del usuario.');
    forma.j_password.focus();
	return false;
  }



}
</SCRIPT>

</HEAD>
<BODY onBlur="window.focus()" onload="carga();timer_load()" 
	onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="AutenticaFirma.jsp" name="forma1">
<h4 align="center">Ingrese sus datos para completar la operaci&oacute;n</h4>
<TABLE align="center" cellspacing="5">
<TR align="center">

<TD align="right" width="40">
 Nombre de Usuario</TD><TD align="left">
 <INPUT type="text" name="j_username">
</TD>
</TR>
<TR align="center">
<TD align="right" width="40">
 Contrase&ntilde;a&nbsp;</TD>
<TD align="left"><INPUT type="password" name="j_password">
</TD>
</TR>
<TR align="center">
<TD align="center" colspan="2">
<INPUT type="submit" value="Enviar" onclick="return validaCampos();">
</TD>
</TR>
</TABLE>
<p align="center"><font color="red"><%=mensaje%></font></p>

</FORM>
</BODY>
</HTML>
