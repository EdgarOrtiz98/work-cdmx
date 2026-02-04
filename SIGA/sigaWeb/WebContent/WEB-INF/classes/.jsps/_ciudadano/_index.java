package _ciudadano;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.ldap.*;
import com.meve.sigma.actualiza.*;


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
      
      out.write(__oracle_jsp_text[3]);
      out.print(strPagina);
      out.write(__oracle_jsp_text[4]);
       if(strImagen.equals("1")){ 
      out.write(__oracle_jsp_text[5]);
       }else if(strImagen.equals("2")){ 
      out.write(__oracle_jsp_text[6]);
       }else if(strImagen.equals("3")){ 
      out.write(__oracle_jsp_text[7]);
       } 
      out.write(__oracle_jsp_text[8]);
       if(strImagen.equals("1")){ 
      out.write(__oracle_jsp_text[9]);
       }else if(strImagen.equals("2")){ 
      out.write(__oracle_jsp_text[10]);
       }else if(strImagen.equals("3")){ 
      out.write(__oracle_jsp_text[11]);
       } 
      out.write(__oracle_jsp_text[12]);
      
      					try{
      						if(ir==2)
            					{
            						out.print("<FONT color=#ff0000>Los datos estan incorrectos");
            						out.print("</FONT>");
      							out.print("<BR><BR><FONT color=#ff0000>Por favor introduzca su ID de usuario y Contraseña</FONT><BR><BR>");
            					}
      					}catch(java.io.IOException io){
      						//System.out.println("ERROR:"+io.getMessage());
      					}
      				
      out.write(__oracle_jsp_text[13]);

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
  private static final char __oracle_jsp_text[][]=new char[14][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n\n<HEAD>\n<META http-equiv=Content-Type content=\"text/html; charset=utf-8\">\n<META http-equiv=expires content=0><LINK href=\"../css/cssLogin.css\" type=text/css rel=stylesheet>\n<SCRIPT language=JavaScript type=text/javascript>\n\n<!-- \nvar NN4 = (document.layers) ? true : false;\n\n// required for NN4 to reliably capture key events\nif (NN4) document.captureEvents(Event.KEYPRESS)\ndocument.onkeypress = function (event) {\n  checkEnter(event)\n  return true\n}\n\nfunction setFormFocus() {\n\tdocument.forms[0].usuario.focus(); \n\tdocument.forms[0].usuario.select();\n}\n\n//submit the form if the user presses the ENTER key\nfunction checkEnter(event)\n{ \t\n\tvar code = 0\n\t\n\tif (NN4) {\n\t\tcode = event.which\n\t} else {\n\t\tcode = window.event.keyCode\n\t}\n\t\t\n\tif (code==13)\n\t\tdocument.forms[0].submit()\n}\n\n// -->\n</SCRIPT>\n<style type=\"text/css\"> \ntable {font-family:Arial, Helvetica, sans-serif; font-size:13px; color:#FFFFFF; font-weight:bold}\n.login {position:relative; top: 35%;}\na {color:#FFFFFF; font-size:11px}\n</style>\n</head>\n\n<body onload=setFormFocus(); background=\"../Imagenes/L2background.jpg\" leftmargin=\"0\" topmargin=\"0\" style=\"background-repeat:repeat-x\">\n<FORM  action=\"index.jsp\" method=\"post\" name=\"autentificar\">\n<INPUT type=\"hidden\" value=\"autenticar\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[4] = 
    "\" name=\"pagina\">\n<table width=\"100%\" height=\"199\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"login\">\n  <tr>\n    <td height=\"18\" background=\"../Imagenes/L2background_top.jpg\" bgcolor=\"#114176\" style=\"background-repeat:repeat-x\">&nbsp;</td>\n  </tr>\n  <tr>\n    <td ".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\t\tbackground=\"../Imagenes/background_login_repeat.jpg\" ".toCharArray();
    __oracle_jsp_text[6] = 
    "\n\t\tbackground=\"../Imagenes/L2background_login_repeat.jpg\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t\tbackground=\"../Imagenes/L2background_login_repeat.jpg\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\tbgcolor=\"#114176\" style=\"background-repeat:repeat-x\">\n\t<table width=\"100%\" height=\"199\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n      <tr>\n        <td ".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t\tbackground=\"../Imagenes/background_login.jpg\" ".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\tbackground=\"../Imagenes/background_loginISSSTE.jpg\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\tbackground=\"../Imagenes/background_login2.jpg\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\tstyle=\"background-repeat:repeat-y\"> \n\t\t\t<table width=\"760\" height=\"199\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n          <tr>\n            <td width=\"392\"><table width=\"100%\" height=\"165\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n              <tr>\n                <td width=\"24\" rowspan=\"3\">&nbsp;</td>\n                <td align=\"right\">Por favor introduzca su nombre y contrase&ntilde;a :</td>\n                <td>&nbsp;</td>\n              </tr>\n              <!-- Codigo de Autentificacion -->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n              <tr>\n                <td width=\"324\" height=\"36\" align=\"right\"><p>Usuario :\n                  <input type=\"text\" TABINDEX=1 name=\"usuario\" />\n                </p>\n                          <p>Contrase&ntilde;a :\n                            <input type=\"password\" TABINDEX=2 name=\"contrasenia\" />\n                        </p></td>\n                <td width=\"40\" align=\"right\">&nbsp;</td>\n              </tr>\n\n              <tr>\n                <td align=\"right\" valign=\"top\"><BR>\n\t\t\t\t\t\t\t\t<img src=\"../Imagenes/L2boton.jpg\" TABINDEX=3 width=\"58\" height=\"22\" style=\"cursor:hand\" onClick=\"document.forms[0].submit();\"/>&nbsp;<br>\n\t\t\t\t\t\t\t\t<A href=\"RegistroCiudadano.jsp\"><br>\n\t\t\t\t\t\t\t\tRegistrate Aqui</A> </td>\n                <td align=\"right\">&nbsp;</td>\n              </tr>\n\t\t\t  <tr>\n\t\t\t\t<td></td>\n\t\t\t  </tr>\n            </table></td>\n            <td width=\"10\" align=\"right\" valign=\"middle\"><img src=\"../Imagenes/line.gif\" alt=\"\" width=\"2\" height=\"175\" /></td>\n            <td width=\"366\">&nbsp;</td>\n          </tr>\n        </table></td>\n      </tr>\n    </table></td>\n  </tr>\n  <tr>\n    <td height=\"18\" background=\"../Imagenes/L2background_bottom.jpg\" bgcolor=\"#114176\" style=\"background-repeat:repeat-x\">&nbsp;</td>\n  </tr>\n</table>\n</FORM>\n</BODY>\n\n\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
