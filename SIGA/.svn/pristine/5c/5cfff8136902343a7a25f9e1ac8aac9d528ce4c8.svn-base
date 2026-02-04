package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.ldap.*;


public class _AutenticaFirma extends com.orionserver.http.OrionHttpJspPage {


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
    _AutenticaFirma page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      com.meve.sigma.beans.LDAPBean ldap;
      synchronized (pageContext) {
        if ((ldap = (com.meve.sigma.beans.LDAPBean) pageContext.getAttribute( "ldap", PageContext.PAGE_SCOPE)) == null) {
          ldap = (com.meve.sigma.beans.LDAPBean) new com.meve.sigma.beans.LDAPBean();
          pageContext.setAttribute( "ldap", ldap, PageContext.PAGE_SCOPE);
          out.write(__oracle_jsp_text[2]);
        }
      }
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      
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
      
      out.write(__oracle_jsp_text[5]);
      out.print(autenticado);
      out.write(__oracle_jsp_text[6]);
      out.print(autenticado);
      out.write(__oracle_jsp_text[7]);
      out.print(mensaje);
      out.write(__oracle_jsp_text[8]);

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
  private static final char __oracle_jsp_text[][]=new char[9][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"> \n<HTML>\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<!--".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "-->\n\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\n<HEAD>\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Autenticación de Firma</TITLE>\n<SCRIPT language=\"JavaScript\">\nfunction carga(){\n\n  //alert('self.opener.document.responder.firmaDigital.checked: '+self.opener.document.responder.firmaDigital.checked);\n\tself.opener.document.responder.firmaDigital.checked=".toCharArray();
    __oracle_jsp_text[6] = 
    ";\n  \n  //alert('self.opener.document.responder.firmaDigital.checked: '+self.opener.document.responder.firmaDigital.checked);\n  \n\n  \tif(".toCharArray();
    __oracle_jsp_text[7] = 
    "){\n\t\tself.opener.document.responder.firmaDigital.value = 'on';\n\t\t//alert(self.opener.document.responder.firmaDigital.value);\n    \tself.close();\n\t}\n\n}\n\n\nfunction validaCampos(){\n\n  forma=document.forma1;\n  if(forma.j_username==undefined || forma.j_username.value.length==0){\n    alert('No ha proporcionado el nombre de usuario.');\n    forma.j_username.focus();\n\treturn false;\n  }\n\n  if(forma.j_password==undefined || forma.j_password.value.length==0){\n    alert('No ha proporcionado la Contraseña del usuario.');\n    forma.j_password.focus();\n\treturn false;\n  }\n\n\n\n}\n</SCRIPT>\n\n</HEAD>\n<BODY onBlur=\"window.focus()\" onload=\"carga();timer_load()\" \n\tonKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"AutenticaFirma.jsp\" name=\"forma1\">\n<h4 align=\"center\">Ingrese sus datos para completar la operaci&oacute;n</h4>\n<TABLE align=\"center\" cellspacing=\"5\">\n<TR align=\"center\">\n\n<TD align=\"right\" width=\"40\">\n Nombre de Usuario</TD><TD align=\"left\">\n <INPUT type=\"text\" name=\"j_username\">\n</TD>\n</TR>\n<TR align=\"center\">\n<TD align=\"right\" width=\"40\">\n Contrase&ntilde;a&nbsp;</TD>\n<TD align=\"left\"><INPUT type=\"password\" name=\"j_password\">\n</TD>\n</TR>\n<TR align=\"center\">\n<TD align=\"center\" colspan=\"2\">\n<INPUT type=\"submit\" value=\"Enviar\" onclick=\"return validaCampos();\">\n</TD>\n</TR>\n</TABLE>\n<p align=\"center\"><font color=\"red\">".toCharArray();
    __oracle_jsp_text[8] = 
    "</font></p>\n\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
