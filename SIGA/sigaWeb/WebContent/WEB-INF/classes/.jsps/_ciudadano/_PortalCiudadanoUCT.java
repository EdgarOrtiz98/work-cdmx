package _ciudadano;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;


public class _PortalCiudadanoUCT extends com.orionserver.http.OrionHttpJspPage {


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
    _PortalCiudadanoUCT page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("headerUCT.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+11,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("login.jsp?pagina="+ strTmp);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
      	}
      	//System.err.println("BusarioNombre-->"+BUsuario.getNombre());
      	//System.err.println("IdUsuario-->"+BUsuario.getIdUsuario());
      	boolean bExiste = false;
      	//bExiste = ActualizaCiudadano.getExisteSolicitud(BCiudadano.getIdUsuario());
      
      out.write(__oracle_jsp_text[4]);
      out.print(BUsuario.getNombre());
      out.write(__oracle_jsp_text[5]);

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
  private static final char __oracle_jsp_text[][]=new char[6][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<STYLE type=\"text/css\">\n</STYLE>\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<script language=\"JavaScript\" type=\"text/javascript\">\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY BGCOLOR=\"FFFFFF\" background=\"../Imagenes/fondo_claro.jpg\">\n<FORM action=\"PortalCiudadanoUCT.jsp\" name=\"formPortalCiuUCT\" method=\"post\">\n<input type=\"hidden\" name=\"__Click\" value=\"0\">\n<INPUT type=\"hidden\" value=\"guardar\" name=\"accion\">\n<TABLE>\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD><FONT size=\"2\" color=\"red\" face=\"Arial\">\n\t\t\t\tBienvenido: <i><STRONG>".toCharArray();
    __oracle_jsp_text[5] = 
    "</STRONG></i> al Portal Ciudadano</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE width=\"100%\" border=\"1\">\n\t\n\t<!-- <TR>\n\t\t<TD width=\"25%\" align=\"left\">Respuesta a ONG</TD>\n\t\t<TD width=\"25%\" align=\"center\">518-AS-128</TD>\n\t\t<TD width=\"25%\" align=\"center\">17 Enero 2005</TD>\n\t\t<TD width=\"25%\" align=\"center\">En proceso (91% avance)</TD>\n\t</TR>\n\t<TR>\n\t\t<TD width=\"25%\" align=\"left\">Solicitud impresión de información</TD>\n\t\t<TD width=\"25%\" align=\"center\">678-REV-17</TD>\n\t\t<TD width=\"25%\" align=\"center\">25 Marzo 2005</TD>\n\t\t<TD width=\"25%\" align=\"center\">En espera de respuesta del ciudadano</TD>\n\t</TR>\n\t<TR>\n\t\t<TD width=\"25%\" align=\"left\">Solicitud cambio de correo Electrónico</TD>\n\t\t<TD width=\"25%\" align=\"center\">892-SIS-323</TD>\n\t\t<TD width=\"25%\" align=\"center\">14 Diciembre 2005</TD>\n\t\t<TD width=\"25%\" align=\"center\">No ha iniciado el proceso</TD>\n\t</TR>-->\n</TABLE>\n<DIV id=\"msg\"></DIV>\n<DIV class=\"documentBody\" id=\"Body\">\n<DIV id=\"view\">\n\n\n</DIV>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
