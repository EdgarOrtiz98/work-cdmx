package _consulta;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _header extends com.orionserver.http.OrionHttpJspPage {


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
    _header page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);

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
  private static final char __oracle_jsp_text[][]=new char[2][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<META http-equiv=Content-Type content=\"text/html; charset=utf-8\">\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/link.css\" />\n<script type=\"text/javascript\" src=\"../js/link.js\">\n\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY text=#000000 bgColor=#ffffff>\n<FORM name=_header2>\n<TABLE cellSpacing=0 cellPadding=0 width=\"100%\" border=0>\n<TBODY>\n  \t<TR>\n    \t<TD background=../Imagenes/h1.jpg>\n      \t\t<TABLE cellSpacing=0 cellPadding=0 width=0 align=right border=0>\n        \t<TBODY>\n        \t<TR>\n          \t\t<TD>    \n\t\t\t\t\t<A onmouseover=\"MM_swapImage('Image19','','../Imagenes/b1_conf.jpg',1)\" \n            \t\t\tonmouseout=MM_swapImgRestore() \n            \t\t\thref=\"../jsp/UsuariosView.jsp\"></A>\n\t\t\t\t</TD>\n          \t\t<TD>\n\t\t\t\t\t<A onmouseover=\"MM_swapImage('Image18','','../Imagenes/b1_ayu.jpg',1)\" \n            \t\t\tonmouseout=MM_swapImgRestore() \n            \t\t\thref=\"http://www.bajacalifornia.gob.mx\" \n            \t\t\ttarget=B><IMG height=17 src=\"../Imagenes/b1_ayu.jpg\" width=75 \n            \t\t\tborder=0 name=Image18>\n\t\t\t\t\t</A>\n\t\t\t\t</TD>\n          \t\t<TD>\n\t\t\t\t\t<A onmouseover=\"MM_swapImage('Image20','','../Imagenes/b1_sal.jpg',1)\" \n            \t\t\tonmouseout=MM_swapImgRestore() \n            \t\t\thref=\"../ciudadano/MenuCiudadano.jsp\" target=\"_top\">\n\t\t\t\t\t<IMG height=17 src=\"../Imagenes/b1_sal.jpg\" width=68 \n            \t\t\tborder=0 name=Image20>\n\t\t\t\t\t</A>\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t</TD>\n\t</TR>\n  \t<TR>\n    \t<TD background=../Imagenes/fon_head1.jpg>\n\t\t\t<IMG height=87 src=\"../Imagenes/L2header1.jpg\" width=772>\n\t\t</TD>\n\t</TR>\n  \t<TR>\n    \t<TD background=../Imagenes/h2.jpg>\n      \t\t<TABLE cellSpacing=0 cellPadding=0 width=0 border=0>\n        \t<TBODY>\n        \t<TR>\n          \t\t<TD>\n\t\t\t\t</TD>\n          \t\t<TD>\n\t\t\t\t</TD>\n\t\t\t\t<TD>\n\t\t\t\t\t</TD>\n          \t\t<TD></TD>\n          \t\t<TD></TD>\n          \t\t<TD></TD>\n          \t\t<TD></TD>\n          \t\t<TD></TD>\n\t\t\t</TR>\n\t\t\t</TBODY>\n\t\t\t</TABLE></TD><!--   /TR /TBODY /TABLE -->\n</FORM>\n</BODY></HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
