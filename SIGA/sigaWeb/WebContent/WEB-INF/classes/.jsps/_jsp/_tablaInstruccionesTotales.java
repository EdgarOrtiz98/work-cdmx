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


public class _tablaInstruccionesTotales extends com.orionserver.http.OrionHttpJspPage {


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
    _tablaInstruccionesTotales page = this;
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
        __jsp_taghandler_3.setKey("Usuario");
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
        __jsp_taghandler_4.setProperty("registrosPaginaActual");
        __jsp_taghandler_4.setType("com.meve.sigma.instruccion.InstruccionForm");
        com.meve.sigma.instruccion.InstruccionForm registro = null;
        java.lang.Integer contador = null;
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_4,__jsp_tag_starteval,out);
          do {
            registro = (com.meve.sigma.instruccion.InstruccionForm) pageContext.findAttribute("registro");
            contador = (java.lang.Integer) pageContext.findAttribute("contador");
            out.write(__oracle_jsp_text[13]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.totalPorEstatus}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[14]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.estatusNombre}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[15]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.usuarioNombre}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[16]);
          } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[17]);
      out.print(tableManager.getPaginacionHTML("reporteForm"));
      out.write(__oracle_jsp_text[18]);
      out.print(Graficas.GRAFICA_PIE);
      out.write(__oracle_jsp_text[19]);
      out.print(String.valueOf(new Date().getTime()));
      out.write(__oracle_jsp_text[20]);
      
      } else {
      
      out.write(__oracle_jsp_text[21]);
      
      }
      
      out.write(__oracle_jsp_text[22]);

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
  private static final char __oracle_jsp_text[][]=new char[23][];
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
    "\n\n\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n\n\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n</HEAD>\n<BODY background=\"./Imagenes/fondo_claro.jpg\">\n\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<TABLE WIDTH=\"900\" align=\"center\">\n\t<TR>\n\t\t<td colspan=\"5\">\n\t\t<font color=\"#004080\" face=\"Arial\"><strong>Instrucciones</strong></font>\n\t\t</td>\n\t</TR>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='20%' align=\"center\">   \n\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t</TD>\n\t\t<TD WIDTH='30%' align=\"center\">\n\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t</TD>\n\t\t<TD WIDTH='50%' align=\"center\"> \n\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t</TD>\n\t</TR>\n</TABLE>\n<DIV>\t\n\n<TABLE width=\"900\" align=\"center\">\n\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t<tr>\n\t\t\t<td WIDTH='25%'>".toCharArray();
    __oracle_jsp_text[14] = 
    "</td>\n\t\t\t<td WIDTH='25%'>".toCharArray();
    __oracle_jsp_text[15] = 
    "</td>\n\t\t\t<td WIDTH='50%'>".toCharArray();
    __oracle_jsp_text[16] = 
    "</td>\n\n\t\t</tr>\n\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t<tr>\n\t\t<td colspan=\"6\">\n\t\t<TABLE align=\"center\">\n\t\t\t<tr>".toCharArray();
    __oracle_jsp_text[18] = 
    "</tr>\n\t\t</table>\n\t\t<td>\n\t</tr>\n\t <tr align=\"center\">\n\t\t\t<td align=\"center\" colspan=\"3\" >\n\t\t\t<img id=\"graficaImg\" alt=\"Grafica de Pie\" src=\"Graficas?tipo=".toCharArray();
    __oracle_jsp_text[19] = 
    "&idImagen=".toCharArray();
    __oracle_jsp_text[20] = 
    "\" /></td>\n\t\t</tr>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[21] = 
    "\n<CENTER>\n<table cellspacing=\"2\" cellpadding=\"2\">\n\t<tr>\n\t\t<TD align=\"center\">\n\t\t<DIV align=\"center\">\n\t\t<p><FONT size=\"4\" face=\"Verdana\">***** No se han encontrado\n\t\tDocumentos ***** </FONT>\n\t\t</DIV>\n\t\t</TD>\n\t</tr>\n</table>\n</CENTER>\n".toCharArray();
    __oracle_jsp_text[22] = 
    "\n</DIV>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
