<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@page import="java.util.List"%>
<%@page import="com.meve.sigma.beans.UsuarioBean"%>
<%@page import="com.meve.sigma.beans.AreaBean"%>
<HTML>
<SCRIPT language=JavaScript type=text/javascript>
        if(history.length>0){
            history.go(+1);
        }
    </SCRIPT>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.ldap.*"%>
<%@ page import="com.meve.sigma.actualiza.*"%>
<%@ page import="java.util.Locale"%>
<%@ page session="true"%>
<%
	Locale.setDefault(new Locale("es", "MX"));

	session.invalidate();
	session = request.getSession(true);
	session.setMaxInactiveInterval(5400); // 90 minutos
	//session.setMaxInactiveInterval(30); // 30 seg
	session.setAttribute("UsuarioBean", null);

	String strAccion = "";
	String strUsuario = "";
	String strPassword = "";
	String strPagina = "";
	String strImagen = application.getInitParameter("Imagen");
	String limite = application.getInitParameter("NumIntentosAcceso");
	String strActivarLDAP = application.getInitParameter("ActivarLDAP");
        //Credenciales otorgadas el dia 09 de junio del 2011 para usuario principal; uso de LDAP
	String globalUserLDAP =	application.getInitParameter("globalUserLDAP");
	String globalPassLDAP =	application.getInitParameter("globalPassLDAP");
        
        String srtVersionEar = application.getInitParameter("versionEar");
        String strIdArea = request.getParameter("listAreas");
	int ir = 0;
	strAccion = request.getParameter("accion");
	strPagina = request.getParameter("pagina");
	List usuarioAreas=null;
	if (strAccion != null && strAccion.equals("autenticar")){
		strUsuario = request.getParameter("Username");
		strPassword = request.getParameter("Password");
		
		//**********             SQL   ***********************///
		if (strActivarLDAP.equals("0")) {
			ir = ActualizaAutentificacion.autentificaUsuario(
			strUsuario, strPassword, limite);
			if (ir == Autenticacion.AUTENTICADO) {
		       usuarioAreas = Autenticacion.getUsuarioAreas(strUsuario.trim());
		      if (1 == usuarioAreas.size()) {
		    	  session.setAttribute("UsuarioBean", ActualizaUsuario.getUsuarioBean(strUsuario.trim()));
			     try {
				     if (strPagina != null&& strPagina.trim().length() > 0
				         && !strPagina.trim().equalsIgnoreCase("null")){
			               response.sendRedirect(strPagina);
				      }else{
			             response.sendRedirect("/SIGA/jsp/portalPrincipal.jsp");
				      }
			     } catch (java.io.IOException io) {
				   ;
			     }
		      }
			}
		}/****************************   LDAP  -**************///
		else {
                        //Credenciales otorgadas el dia 09 de junio del 2011 para usuario principal; uso de LDAP
			//ir = Autenticacion.AutenticaUsuario2(strUsuario,strPassword, limite);
                        ir = Autenticacion.AutenticaUsuario2(strUsuario, strPassword, limite, globalUserLDAP, globalPassLDAP); 

			if (ir == Autenticacion.AUTENTICADO) {
		        usuarioAreas = Autenticacion.getUsuarioAreas(strUsuario.trim());
		        if (1 == usuarioAreas.size()) {
		        	session.setAttribute("UsuarioBean", ActualizaUsuario.getUsuarioBean(strUsuario.trim()));
			      try {
				     if (strPagina != null&& strPagina.trim().length() > 0
				          && !strPagina.trim().equalsIgnoreCase("null")){
        			       response.sendRedirect(strPagina);
				     }else{
			               response.sendRedirect("/SIGA/jsp/portalPrincipal.jsp");
				     }
			       } catch (java.io.IOException io) {
				     ;
			       }
		        }
			}
			/***************************  OTRA VEZ SQL   ****************////
			else{
				ir = ActualizaAutentificacion.autentificaUsuario(strUsuario, strPassword, limite);
				if (ir == Autenticacion.AUTENTICADO) {
			       usuarioAreas = Autenticacion.getUsuarioAreas(strUsuario.trim());
			      if (1 == usuarioAreas.size()) {
			    	  session.setAttribute("UsuarioBean", ActualizaUsuario.getUsuarioBean(strUsuario.trim()));
				     try {
					     if (strPagina != null&& strPagina.trim().length() > 0
					         && !strPagina.trim().equalsIgnoreCase("null")){
				               response.sendRedirect(strPagina);
					      }else{
				             response.sendRedirect("/SIGA/jsp/portalPrincipal.jsp");
					      }
				     } catch (java.io.IOException io) {
					   ;
				     }
			      }
				}
			}
		}
		/*************************************  FIN   *********************/
	}else if(strAccion != null && strAccion.equals("setArea")){
		if(strIdArea!=null){
			strUsuario = request.getParameter("Username");
			UsuarioBean usuBean = ActualizaUsuario.getUsuarioBeanPorArea(strUsuario.trim(),strIdArea);
			session.setAttribute("UsuarioBean", usuBean);
			 try {
			     if (strPagina != null&& strPagina.trim().length() > 0
			          && !strPagina.trim().equalsIgnoreCase("null")){
    			       response.sendRedirect(strPagina);
			     }else{
		               response.sendRedirect("/SIGA/jsp/portalPrincipal.jsp");
			     }
		       } catch (java.io.IOException io) {
			     ;
		       }
		}
	}
%>

<HEAD>
<TITLE>Inicio SIGA</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META http-equiv=expires content=0>
<LINK href="../css/cssLogin.css" type=text/css rel=stylesheet>
<SCRIPT language="JavaScript" src="../js/SigmaJS.js"></SCRIPT>
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
                    document.forms[0].Username.focus(); 
                    document.forms[0].Username.select();
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
table {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #FFFFFF;
	font-weight: bold
}

.login {
	position: relative;
	top: 35%;
}
</style>
</head>

<body onload="setFormFocus();" background="../Imagenes/L2background.jpg"
	leftmargin="0" topmargin="199px" style="background-repeat: repeat-x">
<FORM action="index.jsp" method="post" name="autentificar"><INPUT
	type="hidden" value="autenticar" name="accion"> <INPUT
	type="hidden" value="<%=strPagina%>" name="pagina">
<table width="100%" height="199" border="0" cellpadding="0"
	cellspacing="0" class="login">
	<tr>
		<td height="18" background="../Imagenes/L2background_top.jpg"
			bgcolor="#114176" style="background-repeat: repeat-x">&nbsp;</td>
	</tr>
	<tr>
		<td <% if(strImagen.equals("1")){ %>
			background="../Imagenes/background_login_repeat.jpg"
			<% }else if(strImagen.equals("2")){ %>
			background="../Imagenes/L2background_login_repeat.jpg"
			<% }else if(strImagen.equals("3")){ %>
			background="../Imagenes/L2background_login_repeat.jpg" <% } %>
			bgcolor="#114176" style="background-repeat: repeat-x">
		<table width="100%" height="199" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				
				<td 
					background="../Imagenes/background_login_shcp.jpg"
					style="background-repeat: repeat-y">
				<table width="760" height="199" border="0" cellpadding="0"
					cellspacing="0">
				
					<tr>
						<td width="392">
						<table width="100%" height="165" border="0" cellpadding="0"
							cellspacing="0">
							<%if(usuarioAreas==null){%>
							<tr>
								<td width="24" rowspan="3">&nbsp;</td>
								<td align="right">Por favor introduzca su nombre y
								contrase&ntilde;a :</td>
								<td>&nbsp;</td>
							</tr>
							<%}else{%>
							<tr>
								<td width="24" rowspan="3">&nbsp;</td>
								<td align="right">El usuario pertenece a mas de una una Unidad Administrativa.
								<br>Por favor seleccione en cual desea firmarse.</br>
								</td>
								<td>&nbsp;</td>
							</tr>
							<%} %>
							<%
									try {
									if (ir == Autenticacion.CREDENCIALES_INVALIDAS) {
										out.print("<DIV align=center>");
										out
										.print("<FONT color=#ff0000>La contrase&ntilde;a es Incorrecta");
										out.print("</FONT>");
										out
										.print("<BR><BR><FONT color=#ff0000>Por favor introduzca su ID de usuario y contrase&ntilde;a</FONT><BR><BR>");
									} else if (ir == Autenticacion.ERROR_CONNECT_SERVER) {
										out.print("<DIV align=center>");
										out
										.print("<FONT color=#ff0000>Error de Conexi�n con el Servidor LDAP");
										out.print("</FONT>");
										out
										.print("<BR><BR><FONT color=#ff0000>Pongase en contacto con el Administrador</FONT><BR><BR>");
									} else if (ir == Autenticacion.USUARIO_NO_EXISTE_DB) {
										out.print("<DIV align=center>");
										out
										.print("<FONT color=#ff0000>El usuario no tiene Licencia ");
										out.print("dentro de SIGA </FONT>");
										out
										.print("<BR><BR><FONT color=#ff0000>Pongase en contacto con el Administrador</FONT><BR><BR>");
										out.print("</DIV>");
									} else if (ir == Autenticacion.NO_EXISTE_CONFIG_LDAP) {
										out.print("<DIV align=center>");
										out
										.print("<FONT color=#ff0000>Su servidor LDAP no esta configurado");
										out.print("</FONT>");
										out
										.print("<BR><BR><FONT color=#ff0000>Pongase en contacto con el Administrador</FONT><BR><BR>");
									} else if (ir == Autenticacion.USUARIO_INACTIVO) {
										out.print("<DIV align=center>");
										out
										.print("<FONT color=#ff0000>El Usuario ha sido desactivado del sistema");
										out.print("</FONT>");
										out
										.print("<BR><BR><FONT color=#ff0000>Pongase en contacto con el Administrador</FONT><BR><BR>");
									} else if (ir == Autenticacion.PASSWORD_VACIO) {
										out.print("<DIV align=center>");
										out
										.print("<FONT color=#ff0000>Introduzca su contrase&ntilde;a, por favor");
										out.print("</FONT><BR><BR>");
									} else if (strPagina != null && strPagina.trim().length() > 0
									&& !strPagina.trim().equalsIgnoreCase("null")
									&& strAccion != null) {
										out.print("<DIV align=center>");
										out
										.print("<FONT color=#ff0000>Su sesi&oacute;n ha caducado");
										out.print("</FONT>");
										out
										.print("<BR><BR><FONT color=#ff0000>Por favor introduzca su ID de usuario y contrase&ntilde;a</FONT><BR><BR>");
									}
								} catch (java.io.IOException io) {
									;
								}
							%>
							
							<%if(usuarioAreas==null){%>
							<tr>
								<td width="324" height="36" align="right">
								<p>Usuario : <input type="text" TABINDEX=1 name="Username" />
								</p>
								<p>Contrase&ntilde;a : <input type="password" TABINDEX=2
									name="Password" /></p>
								</td>
								<td width="40" align="right">&nbsp;</td>
							</tr>
                            <%}else{%>
                            <tr>
								<td width="324" height="36" align="right">
								<p>Usuario : <input type="text" TABINDEX=1 name="Username" value="<%=strUsuario%>" readonly="readonly"/>
								</p>
								<p>Unidad Adminsitrativa :
								<select name="listAreas" class="blue300a">
								   <%for(int i=0; i <usuarioAreas.size();i++){ %>
								      <OPTION value="<%=((AreaBean)usuarioAreas.get(i)).getIdArea()%>"><%=((AreaBean)usuarioAreas.get(i)).getNombreArea()%></OPTION>
								   <%}%>
								</select>
								 </p>
								</td>
								<td width="40" align="right">&nbsp;</td>
							</tr>
                            <%}%>
                            <%if(usuarioAreas==null){%>
							<tr>
								<td align="right" valign="top"><BR>
								<img src="../Imagenes/L2boton.jpg" TABINDEX=3 width="58"
									height="22" style="cursor: hand"
									onclick="document.forms[0].submit();" /> <BR>
								<BR>
								<font size="-7"><%=srtVersionEar%></font> &nbsp;</td>
								<td align="right">&nbsp;</td>
							</tr>
							<%}else{%>
							<tr>
								<td align="right" valign="top"><BR>
								<img src="../Imagenes/L2boton.jpg" TABINDEX=3 width="58"
									height="22" style="cursor: hand"
									onclick="document.forms[0].accion.value='setArea';document.forms[0].submit();" /> <BR>
								<BR>
								<font size="-7"><%=srtVersionEar%></font> &nbsp;</td>
								<td align="right">&nbsp;</td>
							</tr>
							<%}%>
						</table>
						</td>
						<td width="10" align="right" valign="middle"><img
							src="../Imagenes/line.gif" title="" width="2" height="175" /></td>
						<td width="366">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td height="18" background="../Imagenes/L2background_bottom.jpg"
			bgcolor="#114176" style="background-repeat: repeat-x">&nbsp;</td>
	</tr>
</table>
</FORM>
</BODY>
</HTML>
