package _ciudadano;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.ldap.*;
import com.meve.sigma.actualiza.*;


public class _login extends com.orionserver.http.OrionHttpJspPage {


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
    _login page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
       
      	session.invalidate();
      	session = request.getSession(true);
      	session.setMaxInactiveInterval(1000);
      	session.setAttribute("UsuarioBean",null);
      	
      	String strAccion	=	"";
      	String strUsuario	=	"";
      	String strPassword	=	"";
      	String strPagina	=	"";
      	String strImagen	=	application.getInitParameter("Imagen");
      	String limite 		=	application.getInitParameter("NumIntentosAcceso");
      	String strActivarLDAP	=	application.getInitParameter("ActivarLDAP");
      
      	//Inicializar los valores de LDAP y pasarselos al bean LDAPBean para 
      	//recuperarlos cuando sea necesario 
      
      	int ir=0;
      	strAccion	=	request.getParameter("accion");
      	strPagina	=	request.getParameter("pagina");
      	
      	if(strAccion!=null && strAccion.equals("autenticar"))
      	{	
      		strUsuario	=	request.getParameter("Username");
      		strPassword	=	request.getParameter("Password");	
      		 
      		if(strActivarLDAP.equals("0")){
      			ir 	=	ActualizaAutentificacion.autentificaUsuario(strUsuario.trim(), strPassword.trim(), limite);
      			if(ir==1)
      			{
      				session.setAttribute("UsuarioBean",ActualizaUsuario.getUsuarioBean(strUsuario.trim()));
      				try{
      					if(strPagina!=null&&strPagina.trim().length()>0 && !strPagina.trim().equalsIgnoreCase("null"))
      						response.sendRedirect(strPagina);
      					else
      						response.sendRedirect("SolicitudUCT.jsp");
      				}
      				catch(java.io.IOException io){
      					//System.out.println("ERROR:"+io.getMessage());
      				}
      			}
      		}else{
      			ir	=	Autenticacion.AutenticaUsuario(strUsuario.trim(),strPassword.trim()/*, LDAP*/, limite);
      			if(ir==Autenticacion.AUTENTICADO)
      			{
      				session.setAttribute("UsuarioBean",ActualizaUsuario.getUsuarioBean(strUsuario.trim()));
      				try{
      					if(strPagina!=null&&strPagina.trim().length()>0 && !strPagina.trim().equalsIgnoreCase("null"))
      						response.sendRedirect(strPagina);
      					else
      						response.sendRedirect("portalPrincipal.jsp");
      				}
      				catch(java.io.IOException io){
      					//System.out.println("ERROR:"+io.getMessage());
      				}
      			}
      		}
      	}
      
      out.write(__oracle_jsp_text[5]);
      out.print(strPagina);
      out.write(__oracle_jsp_text[6]);
       if(strImagen.equals("1")){ 
      out.write(__oracle_jsp_text[7]);
       }else if(strImagen.equals("2")){ 
      out.write(__oracle_jsp_text[8]);
       }else if(strImagen.equals("3")){ 
      out.write(__oracle_jsp_text[9]);
       } 
      out.write(__oracle_jsp_text[10]);
       if(strImagen.equals("1")){ 
      out.write(__oracle_jsp_text[11]);
       }else if(strImagen.equals("2")){ 
      out.write(__oracle_jsp_text[12]);
       }else if(strImagen.equals("3")){ 
      out.write(__oracle_jsp_text[13]);
       } 
      out.write(__oracle_jsp_text[14]);
      
      		try{
            		if(ir==Autenticacion.CREDENCIALES_INVALIDAS)
            		{
            			out.print("<FONT color=#ff0000>La Contraseña es Incorrecta");
            			out.print("</FONT>");
      				out.print("<BR><BR><FONT color=#ff0000>Por favor introduzca su ID de usuario y Contraseña</FONT><BR><BR>");
            		}
            		else 
            		if(ir==Autenticacion.ERROR_CONNECT_SERVER)
            		{
            			out.print("<FONT color=#ff0000>Error de conexión con el Servidor LDAP");
            			out.print("</FONT>");
            			out.print("<BR><BR><FONT color=#ff0000>Pongase en contacto con el Administrador</FONT><BR><BR>");
            		}
            		else 
            		if(ir==Autenticacion.USUARIO_NO_EXISTE_DB)
            		{
      				out.print("<DIV align=center>");
            			out.print("<FONT color=#ff0000>El usuario no tiene Licencia ");
            			out.print("dentro de Sigma </FONT>");
            			out.print("<BR><BR><FONT color=#ff0000>Pongase en contacto con el Administrador</FONT><BR><BR>");
      				out.print("</DIV>");
            		}
            		else 
            		if(ir==Autenticacion.NO_EXISTE_CONFIG_LDAP)
            		{
            			out.print("<FONT color=#ff0000>Su servidor LDAP no esta configurado");
            			out.print("</FONT>");
            			out.print("<BR><BR><FONT color=#ff0000>Pongase en contacto con el Administrador</FONT><BR><BR>");
            		}
      			else if(ir==Autenticacion.USUARIO_INACTIVO)
      			{
      				out.print("<FONT color=#ff0000>El Usuario ha sido desactivado del sistema");
            			out.print("</FONT>");
            			out.print("<BR><BR><FONT color=#ff0000>Pongase en contacto con el Administrador</FONT><BR><BR>");
      			}
      			else if(ir==Autenticacion.PASSWORD_VACIO)
      			{
      				out.print("<FONT color=#ff0000>Introduzca su Contraseña, por favor");
            			out.print("</FONT><BR><BR>");
      			} 
            	}
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
            
      out.write(__oracle_jsp_text[15]);

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
  private static final char __oracle_jsp_text[][]=new char[16][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\n<HEAD>\n<META http-equiv=Content-Type content=\"text/html; charset=utf-8\">\n<META http-equiv=expires content=0><LINK href=\"../css/cssLogin.css\" type=text/css rel=stylesheet>\n<SCRIPT language=JavaScript type=text/javascript>\n\n<!-- \nvar NN4 = (document.layers) ? true : false;\n\n// required for NN4 to reliably capture key events\nif (NN4) document.captureEvents(Event.KEYPRESS)\ndocument.onkeypress = function (event) {\n  checkEnter(event)\n  return true\n}\n\nfunction setFormFocus() {\n\tdocument.forms[0].Username.focus(); \n\tdocument.forms[0].Username.select();\n}\n\n//submit the form if the user presses the ENTER key\nfunction checkEnter(event)\n{ \t\n\tvar code = 0\n\t\n\tif (NN4) {\n\t\tcode = event.which\n\t} else {\n\t\tcode = window.event.keyCode\n\t}\n\t\t\n\tif (code==13)\n\t\tdocument.forms[0].submit()\n}\n\n// -->\n</SCRIPT>\n<style type=\"text/css\"> \ntable {font-family:Arial, Helvetica, sans-serif; font-size:13px; color:#FFFFFF; font-weight:bold}\n.login {position:relative; top: 35%;}\n</style>\n</head>\n\n<body onload=setFormFocus(); background=\"../Imagenes/L2background.jpg\" leftmargin=\"0\" topmargin=\"0\" style=\"background-repeat:repeat-x\">\n<FORM  action=\"login.jsp\" method=\"post\" name=\"autentificar\">\n<INPUT type=\"hidden\" value=\"autenticar\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\" name=\"pagina\">\n<table width=\"100%\" height=\"199\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"login\">\n  <tr>\n    <td height=\"18\" background=\"../Imagenes/L2background_top.jpg\" bgcolor=\"#114176\" style=\"background-repeat:repeat-x\">&nbsp;</td>\n  </tr>\n  <tr>\n    <td ".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t\tbackground=\"../Imagenes/background_login_repeat.jpg\" ".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\tbackground=\"../Imagenes/L2background_login_repeat.jpg\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\tbackground=\"../Imagenes/L2background_login_repeat.jpg\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\tbgcolor=\"#114176\" style=\"background-repeat:repeat-x\">\n\t<table width=\"100%\" height=\"199\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n      <tr>\n        <td ".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\tbackground=\"../Imagenes/background_login.jpg\" ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\tbackground=\"../Imagenes/background_loginISSSTE.jpg\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\tbackground=\"../Imagenes/background_login2.jpg\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\tstyle=\"background-repeat:repeat-y\"> \n\t\t\t<table width=\"760\" height=\"199\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t<!-- L2background_login.jsp -->\n          <tr>\n            <td width=\"392\"><table width=\"100%\" height=\"165\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n              <tr>\n                <td width=\"24\" rowspan=\"3\">&nbsp;</td>\n                <td align=\"right\">Por favor introduzca su nombre y contrase&ntilde;a :</td>\n                <td>&nbsp;</td>\n              </tr>\n                  ".toCharArray();
    __oracle_jsp_text[15] = 
    "\n               <tr>\n                <td width=\"324\" height=\"36\" align=\"right\"><p>Usuario :\n                  <input type=\"text\" TABINDEX=1 name=\"Username\" />\n                </p>\n                          <p>Contrase&ntilde;a :\n                            <input type=\"password\" TABINDEX=2 name=\"Password\" />\n                        </p></td>\n                <td width=\"40\" align=\"right\">&nbsp;</td>\n              </tr>\n\n              <tr>\n                <td align=\"right\" valign=\"top\"><BR>\n\t\t\t\t\t\t\t\t<img src=\"../Imagenes/L2boton.jpg\" TABINDEX=3 width=\"58\" height=\"22\" style=\"cursor:hand\" onclick=\"document.forms[0].submit();\"/>&nbsp; </td>\n                <td align=\"right\">&nbsp;</td>\n              </tr>\n            </table></td>\n            <td width=\"10\" align=\"right\" valign=\"middle\"><img src=\"../Imagenes/line.gif\" alt=\"\" width=\"2\" height=\"175\" /></td>\n            <td width=\"366\">&nbsp;</td>\n          </tr>\n        </table></td>\n      </tr>\n    </table></td>\n  </tr>\n  <tr>\n    <td height=\"18\" background=\"../Imagenes/L2background_bottom.jpg\" bgcolor=\"#114176\" style=\"background-repeat:repeat-x\">&nbsp;</td>\n  </tr>\n</table>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
