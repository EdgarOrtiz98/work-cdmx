package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.graficas.Graficas;
import java.util.Date;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.Utilerias;
import com.meve.sigma.beans.*;
import com.meve.sigma.taglib.*;


public class _tablaAsuntosTotales extends com.orionserver.http.OrionHttpJspPage {


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
    _tablaAsuntosTotales page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
      out.write(__oracle_jsp_text[7]);
      com.meve.util.ManejadorDeTablas tableManager;
      synchronized (session) {
        if ((tableManager = (com.meve.util.ManejadorDeTablas) pageContext.getAttribute( "tableManager", PageContext.SESSION_SCOPE)) == null) {
          tableManager = (com.meve.util.ManejadorDeTablas) new com.meve.util.ManejadorDeTablas();
          pageContext.setAttribute( "tableManager", tableManager, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[8]);
      if (tableManager.getTotalRegistros() != 0) {
      out.write(__oracle_jsp_text[9]);
      {
        _oracle._jsp._tag._sortedHeader_tag __jsp_taghandler_1=(_oracle._jsp._tag._sortedHeader_tag)OracleJspRuntime.getSimpleTagHandler(_oracle._jsp._tag._sortedHeader_tag.class, pageContext);
        __jsp_taghandler_1.setJspContext(pageContext);
        __jsp_taghandler_1.setId("0");
        __jsp_taghandler_1.setKey("Num. Asuntos");
        __jsp_taghandler_1.setForm("reporteForm");
        __jsp_taghandler_1.setOrden(OracleJspRuntime.toStr( tableManager.getOrden(0)));
        __jsp_taghandler_1.doTag();
        OracleJspRuntime.simpleReleaseTagHandler(__jsp_taghandler_1, pageContext);
      }
      out.write(__oracle_jsp_text[10]);
      {
        _oracle._jsp._tag._sortedHeader_tag __jsp_taghandler_2=(_oracle._jsp._tag._sortedHeader_tag)OracleJspRuntime.getSimpleTagHandler(_oracle._jsp._tag._sortedHeader_tag.class, pageContext);
        __jsp_taghandler_2.setJspContext(pageContext);
        __jsp_taghandler_2.setId("1");
        __jsp_taghandler_2.setKey("Estatus");
        __jsp_taghandler_2.setForm("reporteForm");
        __jsp_taghandler_2.setOrden(OracleJspRuntime.toStr( tableManager.getOrden(1)));
        __jsp_taghandler_2.doTag();
        OracleJspRuntime.simpleReleaseTagHandler(__jsp_taghandler_2, pageContext);
      }
      out.write(__oracle_jsp_text[11]);
      {
        _oracle._jsp._tag._sortedHeader_tag __jsp_taghandler_3=(_oracle._jsp._tag._sortedHeader_tag)OracleJspRuntime.getSimpleTagHandler(_oracle._jsp._tag._sortedHeader_tag.class, pageContext);
        __jsp_taghandler_3.setJspContext(pageContext);
        __jsp_taghandler_3.setId("2");
        __jsp_taghandler_3.setKey("Origen");
        __jsp_taghandler_3.setForm("reporteForm");
        __jsp_taghandler_3.setOrden(OracleJspRuntime.toStr( tableManager.getOrden(2)));
        __jsp_taghandler_3.doTag();
        OracleJspRuntime.simpleReleaseTagHandler(__jsp_taghandler_3, pageContext);
      }
      out.write(__oracle_jsp_text[12]);
      {
        org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_4=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setId("registro");
        __jsp_taghandler_4.setIndexId("contador");
        __jsp_taghandler_4.setName("tableManager");
        __jsp_taghandler_4.setProperty("registros");
        __jsp_taghandler_4.setType("com.meve.sigma.asunto.AsuntoForm");
        com.meve.sigma.asunto.AsuntoForm registro = null;
        java.lang.Integer contador = null;
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_4,__jsp_tag_starteval,out);
          do {
            registro = (com.meve.sigma.asunto.AsuntoForm) pageContext.findAttribute("registro");
            contador = (java.lang.Integer) pageContext.findAttribute("contador");
            out.write(__oracle_jsp_text[13]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.totalPorEstatus}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[14]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.estatusNombre}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[15]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.procedencia}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[16]);
          } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[17]);
      out.print(Graficas.GRAFICA_PIE);
      out.write(__oracle_jsp_text[18]);
      out.print(String.valueOf(new Date().getTime()));
      out.write(__oracle_jsp_text[19]);
      } else {
      out.write(__oracle_jsp_text[20]);
      }
      out.write(__oracle_jsp_text[21]);

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
  private static final char __oracle_jsp_text[][]=new char[22][];
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
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n</HEAD>\n\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<TABLE WIDTH=\"800\" align=\"center\">\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='20%' align=\"center\">   \n\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t</TD>\n\t\t<TD WIDTH='30%' align=\"center\">\n\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t</TD>\n\t\t<TD WIDTH='50%' align=\"center\"> \n\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t</TD>\n\n\t</TR>\n</TABLE>\n<DIV class=documentBody id=Body>\n<TABLE width=\"780\" align=\"center\" >\n\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t<tr>\n\t\t\t<td WIDTH='20%'>".toCharArray();
    __oracle_jsp_text[14] = 
    "</td>\n\t\t\t<td WIDTH='30%'>".toCharArray();
    __oracle_jsp_text[15] = 
    "</td>\n\t\t\t<td WIDTH='50%'>".toCharArray();
    __oracle_jsp_text[16] = 
    "</td>\n\t\t</tr>\n\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t    <tr align=\"center\">\n\t\t\t<td align=\"center\" colspan=\"3\" >\n\t\t\t<img id=\"graficaImg\" alt=\"Grafica de Pie\" src=\"Graficas?tipo=".toCharArray();
    __oracle_jsp_text[18] = 
    "&idImagen=".toCharArray();
    __oracle_jsp_text[19] = 
    "\" /></td>\n\t\t</tr>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[20] = 
    "\n<CENTER>\n<table cellspacing=\"2\" cellpadding=\"2\">\n\t<tr>\n\t\t<TD align=\"center\">\n\t\t<DIV align=\"center\">\n\t\t<p><FONT size=\"4\" face=\"Verdana\">***** No se han encontrado\n\t\tDocumentos ***** </FONT>\n\t\t</DIV>\n\t\t</TD>\n\t</tr>\n</table>\n</CENTER>\n".toCharArray();
    __oracle_jsp_text[21] = 
    "\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
