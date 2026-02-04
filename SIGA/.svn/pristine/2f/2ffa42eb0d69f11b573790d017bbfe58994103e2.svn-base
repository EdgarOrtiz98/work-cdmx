package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import java.util.*;


public class _CargarSisi extends com.orionserver.http.OrionHttpJspPage {


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
    _CargarSisi page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("headerC.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      
      	Vector a = new Vector();
      	String solicitud_sisi = request.getParameter("solicitud_sisi");
      //	System.out.println ("Dato: " + solicitud_sisi );
      	if(solicitud_sisi != null && !solicitud_sisi.equalsIgnoreCase(""))
          a.addElement(ActualizaArchivo.getCargaSisi(solicitud_sisi));
      
      out.write(__oracle_jsp_text[3]);
      out.print(a.size());
      out.write(__oracle_jsp_text[4]);
      for (int i=0; i< a.size();i++) {
      out.write(__oracle_jsp_text[5]);
      out.print(a.elementAt(i));
      out.write(__oracle_jsp_text[6]);
       }
      out.write(__oracle_jsp_text[7]);

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
  private static final char __oracle_jsp_text[][]=new char[8][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<html>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<TITLE>Cargar Sisi</TITLE>\n</HEAD>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<SCRIPT language=JavaScript type=text/javascript>\n\n  function agregarContentS()\n\t{\n\t\tdocument.cargarSisi.submit();\n\t}\n function folios()\n\t{\n\tfolio =".toCharArray();
    __oracle_jsp_text[4] = 
    ";\n\tif(folio > 0)\n\t{\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\t\talert('Se insertaron los siguientes folios:".toCharArray();
    __oracle_jsp_text[6] = 
    "');\n\t\t\t\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t}\n\t}\n</SCRIPT>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"folios();timer_load();\"\n\tonKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM \taction=\"CargarSisi.jsp\" name=\"cargarSisi\" \n\t\tmethod=\"post\">\n\n<SCRIPT language=JavaScript type=text/javascript>\nfolios();\n</SCRIPT>\n<TABLE>\n<TR valign=\"top\">\n\t\t<TD width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Agregar archivo Sisi:</FONT></TD>\n\t\t<TD colspan=\"3\"><input class=\"blue500\" type=\"file\"\n\t\t\tname=\"solicitud_sisi\"></TD>\n</TR>\n<TR valign=\"top\">\n\t\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t\t\t</TD>\n</TR>\n<TR valign=\"top\">\n\t\t\t\t\t<TD>\n\t\t\t\t\t&nbsp;\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD align=\"center\">\n\t\t\t\t\t\t<INPUT type=\"button\" class=\"blue200\" value=\"Aceptar\" onclick=\"agregarContentS();\">\n\t\t\t\t\t</TD>\n</TR>\n</TABLE>\n</FORM>\n</BODY>\n</html>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
