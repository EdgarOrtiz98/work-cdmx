package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _modificarParametros extends com.orionserver.http.OrionHttpJspPage {


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
    _modificarParametros page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      com.meve.sigma.parametros.ParametrosForm paremetrosForm;
      synchronized (session) {
        if ((paremetrosForm = (com.meve.sigma.parametros.ParametrosForm) pageContext.getAttribute( "paremetrosForm", PageContext.SESSION_SCOPE)) == null) {
          paremetrosForm = (com.meve.sigma.parametros.ParametrosForm) new com.meve.sigma.parametros.ParametrosForm();
          pageContext.setAttribute( "paremetrosForm", paremetrosForm, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[5]);
      {
        String __url=OracleJspRuntime.toStr("headerSIGAConf.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[6]);
      
      	response.setHeader("Cache-Control", "no-cache");
      	response.setHeader("Pragma", "no-cache");
      	response.setDateHeader("Expires", 0);
      
      out.write(__oracle_jsp_text[7]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("parametros.siga");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[8]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_2=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag property readonly size value");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setProperty("parametroId");
              __jsp_taghandler_2.setReadonly(true);
              __jsp_taghandler_2.setSize("50");
              __jsp_taghandler_2.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${paremetrosForm.parametroId}",java.lang.String.class, __ojsp_varRes,null));
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[9]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_3=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag property size value");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setProperty("parametroValor");
              __jsp_taghandler_3.setSize("50");
              __jsp_taghandler_3.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${paremetrosForm.parametroValor}",java.lang.String.class, __ojsp_varRes,null));
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[10]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_4=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag property size value");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setProperty("parametroDescripcion");
              __jsp_taghandler_4.setSize("50");
              __jsp_taghandler_4.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${paremetrosForm.parametroDescripcion}",java.lang.String.class, __ojsp_varRes,null));
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[11]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[12]);
      
      	String error =com.meve.sigma.util.Converters.getJavaScriptErrorString(request);
      	if (!error.equals("")) {
      
      out.write(__oracle_jsp_text[13]);
      out.print(error);
      out.write(__oracle_jsp_text[14]);
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
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n\n<HTML>\n<HEAD>\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"./theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK rel=\"stylesheet\" type=\"text/css\"\n\thref=\"./css/calendar/calendar-meve.css\" />\n<TITLE>modificar Parametro</TITLE>\n<script type=\"text/javascript\" src=\"./js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"./js/SigaJS.js\"></script>\n<STYLE type=text/css>\nBODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<BODY background=\"./Imagenes/fondo_claro.jpg\">\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t<input type=\"hidden\" value=\"\" name=\"accion\" />\n\t<input type=\"hidden\" value=\"\" name=\"idLink\" />\n\t<TABLE align=\"center\">\n\t\t<TBODY>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD colspan=\"2\">\n\t\t\t\t<A href=\"javascript:;\" onclick=\"submitForm(document.parametrosForm,'','');return false;\"> <IMG border=\"0\"\n\t\t\t\t\tsrc=\"./Imagenes/NavLeft.gif\" alt=\"Regresar\" alt=\"Regresar\"> \n\t\t\t\t</A>\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n\t\t\t\t<A onclick=\"submitForm(document.parametrosForm,'actualizarParametro','');return false;\">\n\t\t\t\t  <img src=\"./Imagenes/Save.gif\" alt=\"Guardar\"> \n\t\t\t    </a></TD>\n\t\t\t</TR>\n\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"336\" colspan=\"2\"><FONT color=\"#00204f\"\n\t\t\t\t\tsize=\"37777777777\"><B><FONT size=\"+1\" color=\"#004080\">Parametros</FONT></B></FONT><FONT></FONT>\n\t\t\t\t</TD>\n\t\t\t\t<TD width=\"53\">&nbsp;</TD>\n\t\t\t\t<TD align=\"right\" width=\"355\">&nbsp;<FONT color=\"black\">**Los\n\t\t\t\tdatos marcados con negritas son obligatorios</FONT></TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD colspan=\"3\"></TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\"><BR>\n\t\t\t\t<BR>\n\t\t\t\t</TD>\n\t\t\t\t<TD width=\"192\"></TD>\n\t\t\t\t<TD width=\"53\"></TD>\n\t\t\t\t<TD width=\"355\"></TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Parametro:</B></FONT><FONT\n\t\t\t\t\tcolor=\"#004080\"></FONT></TD> \n\t\t\t\t<TD>".toCharArray();
    __oracle_jsp_text[9] = 
    "</TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t\t<TD width=\"53\">&nbsp;</TD>\n\t\t\t\t<TD width=\"355\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t\t<TR>\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Valor:\n\t\t\t\t</B></FONT></TD>\n\t\t\t\t<TD>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t\t<TD width=\"53\">&nbsp;</TD>\n\t\t\t\t<TD width=\"355\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">Descripción:\n\t\t\t\t</FONT></TD>\n\t\t\t\t<TD colspan=\"3\">".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t<TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD colspan=\"4\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t</TBODY>\n\n\t</TABLE>\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n".toCharArray();
    __oracle_jsp_text[13] = 
    " <script>alert('".toCharArray();
    __oracle_jsp_text[14] = 
    "');</script> ".toCharArray();
    __oracle_jsp_text[15] = 
    "\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
