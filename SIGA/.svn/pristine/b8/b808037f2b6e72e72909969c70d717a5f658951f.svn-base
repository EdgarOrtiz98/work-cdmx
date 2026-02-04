package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import java.util.List;
import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.beans.AreaBean;
import com.meve.sigma.ldap.*;
import com.meve.sigma.actualiza.*;
import java.util.Locale;


public class _index extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html; charset=ISO-8859-1");
    /* set up the intrinsic variables using the pageContext goober:
    ** session = HttpSession
    ** application = ServletContext
    ** out = JspWriter
    ** page = this
    ** config = ServletConfig
    ** all session/app beans declared in globals.jsa
    */
    PageContext pageContext = JspFactory.getDefaultFactory().getPageContext( this, request, response, null, true, JspWriter.DEFAULT_BUFFER, true);
    // Note: this is not emitted if the session directive == false
    HttpSession session = pageContext.getSession();
    int __jsp_tag_starteval;
    ServletContext application = pageContext.getServletContext();
    JspWriter out = pageContext.getOut();
    _index page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
      out.write(__oracle_jsp_text[7]);
      out.write(__oracle_jsp_text[8]);
      
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
      			             response.sendRedirect("portalPrincipal.jsp");
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
      			               response.sendRedirect("portalPrincipal.jsp");
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
      				             response.sendRedirect("portalPrincipal.jsp");
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
      		               response.sendRedirect("portalPrincipal.jsp");
      			     }
      		       } catch (java.io.IOException io) {
      			     ;
      		       }
      		}
      	}
      
      out.write(__oracle_jsp_text[9]);
      out.print(strPagina);
      out.write(__oracle_jsp_text[10]);
       if(strImagen.equals("1")){ 
      out.write(__oracle_jsp_text[11]);
       }else if(strImagen.equals("2")){ 
      out.write(__oracle_jsp_text[12]);
       }else if(strImagen.equals("3")){ 
      out.write(__oracle_jsp_text[13]);
       } 
      out.write(__oracle_jsp_text[14]);
      if(usuarioAreas==null){
      out.write(__oracle_jsp_text[15]);
      }else{
      out.write(__oracle_jsp_text[16]);
      } 
      out.write(__oracle_jsp_text[17]);
      
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
      										.print("<FONT color=#ff0000>Error de conexión con el Servidor LDAP");
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
      							
      out.write(__oracle_jsp_text[18]);
      if(usuarioAreas==null){
      out.write(__oracle_jsp_text[19]);
      }else{
      out.write(__oracle_jsp_text[20]);
      out.print(strUsuario);
      out.write(__oracle_jsp_text[21]);
      for(int i=0; i <usuarioAreas.size();i++){ 
      out.write(__oracle_jsp_text[22]);
      out.print(((AreaBean)usuarioAreas.get(i)).getIdArea());
      out.write(__oracle_jsp_text[23]);
      out.print(((AreaBean)usuarioAreas.get(i)).getNombreArea());
      out.write(__oracle_jsp_text[24]);
      }
      out.write(__oracle_jsp_text[25]);
      }
      out.write(__oracle_jsp_text[26]);
      if(usuarioAreas==null){
      out.write(__oracle_jsp_text[27]);
      out.print(srtVersionEar);
      out.write(__oracle_jsp_text[28]);
      }else{
      out.write(__oracle_jsp_text[29]);
      out.print(srtVersionEar);
      out.write(__oracle_jsp_text[30]);
      }
      out.write(__oracle_jsp_text[31]);

    }
    catch (Throwable e) {
      if (!(e instanceof javax.servlet.jsp.SkipPageException)){
        try {
          if (out != null) out.clear();
        }
        catch (Exception clearException) {
        }
        pageContext.handlePageException(e);
      }
    }
    finally {
      OracleJspRuntime.extraHandlePCFinally(pageContext, true);
      JspFactory.getDefaultFactory().releasePageContext(pageContext);
    }

  }
  private static final char __oracle_jsp_text[][]=new char[32][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<HTML>\n<SCRIPT language=JavaScript type=text/javascript>\n        if(history.length>0){\n            history.go(+1);\n        }\n    </SCRIPT>\n\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\n<HEAD>\n<TITLE>Inicio SIGA</TITLE>\n<META http-equiv=Content-Type content=\"text/html; charset=utf-8\">\n<META http-equiv=expires content=0>\n<LINK href=\"../css/cssLogin.css\" type=text/css rel=stylesheet>\n<SCRIPT language=\"JavaScript\" src=\"../js/SigmaJS.js\"></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript>\n        <!-- \n            var NN4 = (document.layers) ? true : false;\n\n            // required for NN4 to reliably capture key events\n            if (NN4) document.captureEvents(Event.KEYPRESS)\n            document.onkeypress = function (event) {\n              checkEnter(event)\n              return true\n            }\n\n            function setFormFocus() {\n                    document.forms[0].Username.focus(); \n                    document.forms[0].Username.select();\n            }\n\n            //submit the form if the user presses the ENTER key\n            function checkEnter(event)\n            { \t\n                    var code = 0\n                    \n                    if (NN4) {\n                            code = event.which\n                    } else {\n                            code = window.event.keyCode\n                    }\n                            \n                    if (code==13)\n                            document.forms[0].submit()\n            }\n        // -->\n        </SCRIPT>\n<style type=\"text/css\">\ntable {\n\tfont-family: Arial, Helvetica, sans-serif;\n\tfont-size: 13px;\n\tcolor: #FFFFFF;\n\tfont-weight: bold\n}\n\n.login {\n\tposition: relative;\n\ttop: 35%;\n}\n</style>\n</head>\n\n<body onload=\"setFormFocus();\" background=\"../Imagenes/L2background.jpg\"\n\tleftmargin=\"0\" topmargin=\"0\" style=\"background-repeat: repeat-x\">\n<FORM action=\"index.jsp\" method=\"post\" name=\"autentificar\"><INPUT\n\ttype=\"hidden\" value=\"autenticar\" name=\"accion\"> <INPUT\n\ttype=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\" name=\"pagina\">\n<table width=\"100%\" height=\"199\" border=\"0\" cellpadding=\"0\"\n\tcellspacing=\"0\" class=\"login\">\n\t<tr>\n\t\t<td height=\"18\" background=\"../Imagenes/L2background_top.jpg\"\n\t\t\tbgcolor=\"#114176\" style=\"background-repeat: repeat-x\">&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td ".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\tbackground=\"../Imagenes/background_login_repeat.jpg\"\n\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\tbackground=\"../Imagenes/L2background_login_repeat.jpg\"\n\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\tbackground=\"../Imagenes/L2background_login_repeat.jpg\" ".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\tbgcolor=\"#114176\" style=\"background-repeat: repeat-x\">\n\t\t<table width=\"100%\" height=\"199\" border=\"0\" cellpadding=\"0\"\n\t\t\tcellspacing=\"0\">\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<td \n\t\t\t\t\tbackground=\"../Imagenes/background_login_shcp.jpg\"\n\t\t\t\t\tstyle=\"background-repeat: repeat-y\">\n\t\t\t\t<table width=\"760\" height=\"199\" border=\"0\" cellpadding=\"0\"\n\t\t\t\t\tcellspacing=\"0\">\n\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"392\">\n\t\t\t\t\t\t<table width=\"100%\" height=\"165\" border=\"0\" cellpadding=\"0\"\n\t\t\t\t\t\t\tcellspacing=\"0\">\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\"24\" rowspan=\"3\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td align=\"right\">Por favor introduzca su nombre y\n\t\t\t\t\t\t\t\tcontrase&ntilde;a :</td>\n\t\t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\"24\" rowspan=\"3\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td align=\"right\">El usuario pertenece a mas de una una Unidad Administrativa.\n\t\t\t\t\t\t\t\t<br>Por favor seleccione en cual desea firmarse.</br>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\"324\" height=\"36\" align=\"right\">\n\t\t\t\t\t\t\t\t<p>Usuario : <input type=\"text\" TABINDEX=1 name=\"Username\" />\n\t\t\t\t\t\t\t\t</p>\n\t\t\t\t\t\t\t\t<p>Contrase&ntilde;a : <input type=\"password\" TABINDEX=2\n\t\t\t\t\t\t\t\t\tname=\"Password\" /></p>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td width=\"40\" align=\"right\">&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n                            ".toCharArray();
    __oracle_jsp_text[20] = 
    "\n                            <tr>\n\t\t\t\t\t\t\t\t<td width=\"324\" height=\"36\" align=\"right\">\n\t\t\t\t\t\t\t\t<p>Usuario : <input type=\"text\" TABINDEX=1 name=\"Username\" value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\" readonly=\"readonly\"/>\n\t\t\t\t\t\t\t\t</p>\n\t\t\t\t\t\t\t\t<p>Unidad Adminsitrativa :\n\t\t\t\t\t\t\t\t<select name=\"listAreas\" class=\"blue300a\">\n\t\t\t\t\t\t\t\t   ".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t\t\t\t\t\t      <OPTION value=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\">".toCharArray();
    __oracle_jsp_text[24] = 
    "</OPTION>\n\t\t\t\t\t\t\t\t   ".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t </p>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td width=\"40\" align=\"right\">&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n                            ".toCharArray();
    __oracle_jsp_text[26] = 
    "\n                            ".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td align=\"right\" valign=\"top\"><BR>\n\t\t\t\t\t\t\t\t<img src=\"../Imagenes/L2boton.jpg\" TABINDEX=3 width=\"58\"\n\t\t\t\t\t\t\t\t\theight=\"22\" style=\"cursor: hand\"\n\t\t\t\t\t\t\t\t\tonclick=\"document.forms[0].submit();\" /> <BR>\n\t\t\t\t\t\t\t\t<BR>\n\t\t\t\t\t\t\t\t<font size=\"-7\">".toCharArray();
    __oracle_jsp_text[28] = 
    "</font> &nbsp;</td>\n\t\t\t\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td align=\"right\" valign=\"top\"><BR>\n\t\t\t\t\t\t\t\t<img src=\"../Imagenes/L2boton.jpg\" TABINDEX=3 width=\"58\"\n\t\t\t\t\t\t\t\t\theight=\"22\" style=\"cursor: hand\"\n\t\t\t\t\t\t\t\t\tonclick=\"document.forms[0].accion.value='setArea';document.forms[0].submit();\" /> <BR>\n\t\t\t\t\t\t\t\t<BR>\n\t\t\t\t\t\t\t\t<font size=\"-7\">".toCharArray();
    __oracle_jsp_text[30] = 
    "</font> &nbsp;</td>\n\t\t\t\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"10\" align=\"right\" valign=\"middle\"><img\n\t\t\t\t\t\t\tsrc=\"../Imagenes/line.gif\" alt=\"\" width=\"2\" height=\"175\" /></td>\n\t\t\t\t\t\t<td width=\"366\">&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td height=\"18\" background=\"../Imagenes/L2background_bottom.jpg\"\n\t\t\tbgcolor=\"#114176\" style=\"background-repeat: repeat-x\">&nbsp;</td>\n\t</tr>\n</table>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
