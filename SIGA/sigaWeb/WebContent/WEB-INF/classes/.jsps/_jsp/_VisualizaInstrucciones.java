package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.util.*;


public class _VisualizaInstrucciones extends com.orionserver.http.OrionHttpJspPage {


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
    _VisualizaInstrucciones page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("header.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
       String strRutaBase = request.getContextPath();
      out.write(__oracle_jsp_text[3]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null)
      	try{
      		response.sendRedirect("index.jsp?pagina="+ strTmp);
      	}catch(java.io.IOException io){;}
      
      out.write(__oracle_jsp_text[4]);
      out.print(strRutaBase);
      out.write(__oracle_jsp_text[5]);
      out.print(strRutaBase);
      out.write(__oracle_jsp_text[6]);
      out.print(request.getParameter("Url"));
      out.write(__oracle_jsp_text[7]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(request.getParameter("retURI")));
      out.write(__oracle_jsp_text[8]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(request.getParameter("retURI")));
      out.write(__oracle_jsp_text[9]);
      out.print(strRutaBase);
      out.write(__oracle_jsp_text[10]);
      {
        String __url=OracleJspRuntime.toStr("/cgtic/asignarInstrucciones.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[11]);

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
  private static final char __oracle_jsp_text[][]=new char[12][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n<HTML> \n<head><link rel=\"stylesheet\" type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[5] = 
    "/cgtic/css/cgtic-siga.css\"/>\n<script src=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "/cgtic/js/funcionesCGTIC-SIGA.js\" type=\"text/javascript\"></script>\n<script type=\"text/javascript\">\n    var globalURL = \"".toCharArray();
    __oracle_jsp_text[7] = 
    "\"+\"&retURI=".toCharArray();
    __oracle_jsp_text[8] = 
    "\";\n    var retURI = \"".toCharArray();
    __oracle_jsp_text[9] = 
    "\";\n    var rutaBase = \"".toCharArray();
    __oracle_jsp_text[10] = 
    "\";\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</head><BODY background=\"../Imagenes/fondo_claro.jpg\">\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n</BODY></HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
