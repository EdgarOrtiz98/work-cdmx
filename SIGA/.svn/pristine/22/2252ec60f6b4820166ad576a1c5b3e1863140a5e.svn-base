package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.reporte.ReporteForm;;


public class _reporteador extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html");
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
    _reporteador page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      java.lang.String tipoEntidades;
      synchronized (session) {
        if ((tipoEntidades = (java.lang.String) pageContext.getAttribute( "tipoEntidades", PageContext.SESSION_SCOPE)) == null) {
          tipoEntidades = (java.lang.String) new java.lang.String();
          pageContext.setAttribute( "tipoEntidades", tipoEntidades, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[5]);
      java.lang.String pantallaReporte;
      synchronized (session) {
        if ((pantallaReporte = (java.lang.String) pageContext.getAttribute( "pantallaReporte", PageContext.SESSION_SCOPE)) == null) {
          pantallaReporte = (java.lang.String) new java.lang.String();
          pageContext.setAttribute( "pantallaReporte", pantallaReporte, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[6]);
      com.meve.sigma.beans.UsuarioBean UsuarioBean;
      synchronized (session) {
        if ((UsuarioBean = (com.meve.sigma.beans.UsuarioBean) pageContext.getAttribute( "UsuarioBean", PageContext.SESSION_SCOPE)) == null) {
          UsuarioBean = (com.meve.sigma.beans.UsuarioBean) new com.meve.sigma.beans.UsuarioBean();
          pageContext.setAttribute( "UsuarioBean", UsuarioBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[7]);
      {
        String __url=OracleJspRuntime.toStr("headerSIGA.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[8]);
      
      response.setHeader("Cache-Control","no-cache");
      response.setHeader("Pragma","no-cache"); 
      response.setDateHeader ("Expires", 0);
      
      out.write(__oracle_jsp_text[9]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("reporteador");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[10]);
            {
              String __url= (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${pantallaReporte}",java.lang.String.class, __ojsp_varRes, null);
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[11]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[12]);

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
  private static final char __oracle_jsp_text[][]=new char[13][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n<HTML>\n<HEAD>\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"./theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK rel=\"stylesheet\" type=\"text/css\" href=\"./css/calendar/calendar-meve.css\" />\n<TITLE>Reporteador</TITLE>\n<script type=\"text/javascript\" src=\"./js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"./js/SigaJS.js\"></script>\n<script type=\"text/javascript\" src=\"./js/ventana/ventanas.js\"></script>\n<script type=\"text/javascript\" src=\"./js/ventana/controladorDeContenido.js\"></script>\n<SCRIPT type=\"text/javascript\" src=\"./js/calendar/calendar.js\"></SCRIPT>\n<SCRIPT type=\"text/javascript\" src=\"./js/calendar/lang/calendar-es.js\"></SCRIPT>\n<SCRIPT type=\"text/javascript\" src=\"./js/calendar/calendar-setup.js\"></SCRIPT>\n<script language=\"JavaScript\" type=\"text/javascript\">if (history.length > 0) { history.go(+1); }</script>\n<STYLE type=text/css>\nBODY {\n\tMARGIN: 0px\n}\n</STYLE>\n\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n</HEAD>\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n<BODY background=\"./Imagenes/fondo_claro.jpg\">\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n    <input type=\"hidden\" value=\"\" name=\"accion\" />\n\t <input type=\"hidden\" value=\"\" name=\"idLink\" />\n\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
