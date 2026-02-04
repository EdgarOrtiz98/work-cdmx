package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _ViewFile extends com.orionserver.http.OrionHttpJspPage {


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
    _ViewFile page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      
      	String nombre = request.getParameter("id");
      
      out.write(__oracle_jsp_text[2]);
      out.print(nombre);
      out.write(__oracle_jsp_text[3]);
      out.print(nombre);
      out.write(__oracle_jsp_text[4]);

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
  private static final char __oracle_jsp_text[][]=new char[5][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/link.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Archivos</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n\tfunction Logeo(){\n\t\tlocation.assign('http://linux.meve.com:7778/content/dav/meve/SIGMA/gestion/contenedor/".toCharArray();
    __oracle_jsp_text[3] = 
    "');\n\t}\n</SCRIPT>\n</HEAD>\n<BODY onload=\"doc = document.loginForm; doc.submit();timer_load()\">\n<form name=\"loginForm\" method=\"POST\" action=\"http://linux.meve.com/sso/auth\" accept-charset=\"UTF-8\" onsubmit=\"return Logeo();\">\n<input type=\"hidden\" name=\"site2pstoretoken\" value=\"v1.4~3BF7E9CC~D1D3448BC056B9F10FF896BE01C0DAC4BF918953AA7726A38C3C1AFED4E97D16A596868917B661D8FA0CB4B41DA2B47A378F7AC782461A8498D4E908FFEB75B90E91C2704141D8282DD29FC548992B45B8F61D870AD7637B829C6969512094E82352D67BCE7DA69AAD54165D455A0B7DE6E27BCF5E3407489EDB6053ADDB07EA2824EB2675BABA1238E76AA35AFA3FDD1C038145E4772A41EB1139E668472AD99C4DCB11A4C143B9A11DB5B3B891E1B8542C24BD3A40173D84FE4CC87F772483\"/>\n<INPUT type=\"hidden\" name=\"ssousername\" value=\"orcladmin\">\n<INPUT type=\"hidden\" name=\"password\" value=\"password1\">\n<INPUT type=\"hidden\" name=\"p_submit_url\" value=\"http://linux.meve.com:7778/content/dav/meve/SIGMA/gestion/contenedor/".toCharArray();
    __oracle_jsp_text[4] = 
    "\">\n</form>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
