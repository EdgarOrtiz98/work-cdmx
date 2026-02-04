<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ page 
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	import="com.meve.sigma.ldap.*,com.meve.sigma.actualiza.*"
%>
<%@ page session="true"%>
<% 
	session.invalidate();
	session = request.getSession(true);
	session.setMaxInactiveInterval(1000);
	session.setAttribute("CiudadanoBean",null);
	
	String strAccion	=	"";
	String strUsuario	=	"";
	String strPassword	=	"";
	String strPagina	=	"";
	String strImagen	=	application.getInitParameter("Imagen");
	String limite 		=	application.getInitParameter("NumIntentosAcceso");
	String strActivarLDAP	=	application.getInitParameter("ActivarLDAP");
        //Credenciales otorgadas el dia 09 de junio del 2011 para usuario principal; uso de LDAP
	String globalUserLDAP	=	application.getInitParameter("globalUserLDAP");
	String globalPassLDAP	=	application.getInitParameter("globalPassLDAP");

	//Inicializar los valores de LDAP y pasarselos al bean LDAPBean para 
	//recuperarlos cuando sea necesario 

	int ir=0;
	strAccion	=	request.getParameter("accion");
	strPagina	=	request.getParameter("pagina");
	
	if(strAccion!=null && strAccion.equals("autenticar"))
	{	
		strUsuario	=	request.getParameter("usuario");
		strPassword	=	request.getParameter("contrasenia");
		ir = ActualizaLdap.getValidaUsuario(strUsuario, strPassword);
		if(strActivarLDAP.equals("0")){
			ir 	=	ActualizaAutentificacion.autentificaUsuario(strUsuario, strPassword, limite);
			if(ir==1)
			{
				session.setAttribute("CiudadanoBean",ActualizaCiudadano.getCiudadanoBean(strUsuario.trim()));
				try{
					if(strPagina!=null&&strPagina.trim().length()>0 && !strPagina.trim().equalsIgnoreCase("null"))
						response.sendRedirect(strPagina);
					else
						response.sendRedirect("PortalCiudadano.jsp");
				}
				catch(java.io.IOException io){
					//System.out.println("ERROR:"+io.getMessage());
				}
			}
		}else{
                        //Credenciales otorgadas el dia 09 de junio del 2011 para usuario principal; uso de LDAP
                        //ir = Autenticacion.AutenticaUsuario2(strUsuario, strPassword, limite); 
                        ir = Autenticacion.AutenticaUsuario2(strUsuario, strPassword, limite, globalUserLDAP, globalPassLDAP); 
			if(ir==Autenticacion.AUTENTICADO)
			{
				session.setAttribute("CiudadanoBean",ActualizaCiudadano.getCiudadanoBean(strUsuario.trim()));
				try{
					if(strPagina!=null&&strPagina.trim().length()>0 && !strPagina.trim().equalsIgnoreCase("null"))
						response.sendRedirect(strPagina);
					else
						response.sendRedirect("PortalCiudadano.jsp");
				}
				catch(java.io.IOException io){
					//System.out.println("ERROR:"+io.getMessage());
				}
			}
		}
	}
%>

<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META http-equiv=expires content=0><LINK href="../css/cssLogin.css" type=text/css rel=stylesheet>
<SCRIPT language=JavaScript type=text/javascript>

<!-- 
var NN4 = (document.layers) ? true : false;

// required for NN4 to reliably capture key events
if (NN4) document.captureEvents(Event.KEYPRESS)
document.onkeypress = function (event) {
  checkEnter(event)
  return true
}

function setFormFocus() {
	document.forms[0].usuario.focus(); 
	document.forms[0].usuario.select();
}

//submit the form if the user presses the ENTER key
function checkEnter(event)
{ 	
	var code = 0
	
	if (NN4) {
		code = event.which
	} else {
		code = window.event.keyCode
	}
		
	if (code==13)
		document.forms[0].submit()
}

// -->
</SCRIPT>
<style type="text/css"> 
table {font-family:Arial, Helvetica, sans-serif; font-size:13px; color:#FFFFFF; font-weight:bold}
.login {position:relative; top: 35%;}
a {color:#FFFFFF; font-size:11px}
</style>
</head>

<body onload=setFormFocus(); background="../Imagenes/L2background.jpg" leftmargin="0" topmargin="0" style="background-repeat:repeat-x">
<FORM  action="index.jsp" method="post" name="autentificar">
<INPUT type="hidden" value="autenticar" name="accion">
<INPUT type="hidden" value="<%=strPagina%>" name="pagina">
<table width="100%" height="199" border="0" cellpadding="0" cellspacing="0" class="login">
  <tr>
    <td height="18" background="../Imagenes/L2background_top.jpg" bgcolor="#114176" style="background-repeat:repeat-x">&nbsp;</td>
  </tr>
  <tr>
    <td <% if(strImagen.equals("1")){ %>
		background="../Imagenes/background_login_repeat.jpg" <% }else if(strImagen.equals("2")){ %>
		background="../Imagenes/L2background_login_repeat.jpg"<% }else if(strImagen.equals("3")){ %>
		background="../Imagenes/L2background_login_repeat.jpg"<% } %>
		bgcolor="#114176" style="background-repeat:repeat-x">
	<table width="100%" height="199" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td <% if(strImagen.equals("1")){ %>
			background="../Imagenes/background_login.jpg" <% }else if(strImagen.equals("2")){ %>
			background="../Imagenes/background_loginISSSTE.jpg"<% }else if(strImagen.equals("3")){ %>
			background="../Imagenes/background_login2.jpg"<% } %>
			style="background-repeat:repeat-y"> 
			<table width="760" height="199" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="392"><table width="100%" height="165" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="24" rowspan="3">&nbsp;</td>
                <td align="right">Por favor introduzca su nombre y contrase&ntilde;a :</td>
                <td>&nbsp;</td>
              </tr>
              <!-- Codigo de Autentificacion -->
				<%
					try{
						if(ir==2)
      					{
      						out.print("<FONT color=#ff0000>Los datos estan incorrectos");
      						out.print("</FONT>");
							out.print("<BR><BR><FONT color=#ff0000>Por favor introduzca su ID de usuario y contraseña</FONT><BR><BR>");
      					}
					}catch(java.io.IOException io){
						//System.out.println("ERROR:"+io.getMessage());
					}
				%>
              <tr>
                <td width="324" height="36" align="right"><p>Usuario :
                  <input type="text" TABINDEX=1 name="usuario" />
                </p>
                          <p>Contrase&ntilde;a :
                            <input type="password" TABINDEX=2 name="contrasenia" />
                        </p></td>
                <td width="40" align="right">&nbsp;</td>
              </tr>

              <tr>
                <td align="right" valign="top"><BR>
								<img src="../Imagenes/L2boton.jpg" TABINDEX=3 width="58" height="22" style="cursor:hand" onClick="document.forms[0].submit();"/>&nbsp;<br>
								<A href="RegistroCiudadano.jsp"><br>
								Registrate Aqui</A> </td>
                <td align="right">&nbsp;</td>
              </tr>
			  <tr>
				<td></td>
			  </tr>
            </table></td>
            <td width="10" align="right" valign="middle"><img src="../Imagenes/line.gif" title="" width="2" height="175" /></td>
            <td width="366">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="18" background="../Imagenes/L2background_bottom.jpg" bgcolor="#114176" style="background-repeat:repeat-x">&nbsp;</td>
  </tr>
</table>
</FORM>
</BODY>


</HTML>
