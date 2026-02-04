package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _mostrarParametros extends com.orionserver.http.OrionHttpJspPage {


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
    _mostrarParametros page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      com.meve.util.ManejadorDeTablas tableManager;
      synchronized (session) {
        if ((tableManager = (com.meve.util.ManejadorDeTablas) pageContext.getAttribute( "tableManager", PageContext.SESSION_SCOPE)) == null) {
          tableManager = (com.meve.util.ManejadorDeTablas) new com.meve.util.ManejadorDeTablas();
          pageContext.setAttribute( "tableManager", tableManager, PageContext.SESSION_SCOPE);
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
            
            			if (tableManager.getTotalRegistros() != 0) {
            			
            out.write(__oracle_jsp_text[9]);
            out.print(tableManager.getTotalRegistros());
            out.write(__oracle_jsp_text[10]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_2=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setId("encabezado");
              __jsp_taghandler_2.setIndexId("index");
              __jsp_taghandler_2.setName("tableManager");
              __jsp_taghandler_2.setProperty("encabezados");
              __jsp_taghandler_2.setType("com.meve.util.Encabezado");
              com.meve.util.Encabezado encabezado = null;
              java.lang.Integer index = null;
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_2,__jsp_tag_starteval,out);
                do {
                  encabezado = (com.meve.util.Encabezado) pageContext.findAttribute("encabezado");
                  index = (java.lang.Integer) pageContext.findAttribute("index");
                  out.write(__oracle_jsp_text[11]);
                  out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${encabezado.width}",java.lang.String.class, __ojsp_varRes, null));
                  out.write(__oracle_jsp_text[12]);
                  {
                    _oracle._jsp._tag._sortedHeader_tag __jsp_taghandler_3=(_oracle._jsp._tag._sortedHeader_tag)OracleJspRuntime.getSimpleTagHandler(_oracle._jsp._tag._sortedHeader_tag.class, pageContext);
                    __jsp_taghandler_3.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_3.setJspContext(pageContext);
                    __jsp_taghandler_3.setId((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${index}",java.lang.String.class, __ojsp_varRes,null));
                    __jsp_taghandler_3.setKey((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${encabezado.titulo}",java.lang.String.class, __ojsp_varRes,null));
                    __jsp_taghandler_3.setForm("parametrosForm");
                    __jsp_taghandler_3.setOrden(OracleJspRuntime.toStr( tableManager.getOrden(index.intValue())));
                    __jsp_taghandler_3.doTag();
                    OracleJspRuntime.simpleReleaseTagHandler(__jsp_taghandler_3, pageContext);
                  }
                  out.write(__oracle_jsp_text[13]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[14]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_4=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setId("registro");
              __jsp_taghandler_4.setIndexId("contador");
              __jsp_taghandler_4.setName("tableManager");
              __jsp_taghandler_4.setProperty("registrosPaginaActual");
              __jsp_taghandler_4.setType("com.meve.sigma.parametros.ParametrosForm");
              com.meve.sigma.parametros.ParametrosForm registro = null;
              java.lang.Integer contador = null;
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_4,__jsp_tag_starteval,out);
                do {
                  registro = (com.meve.sigma.parametros.ParametrosForm) pageContext.findAttribute("registro");
                  contador = (java.lang.Integer) pageContext.findAttribute("contador");
                  out.write(__oracle_jsp_text[15]);
                  out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.parametroId}",java.lang.String.class, __ojsp_varRes, null));
                  out.write(__oracle_jsp_text[16]);
                  out.print(registro.getParametroId());
                  out.write(__oracle_jsp_text[17]);
                  out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.parametroId}",java.lang.String.class, __ojsp_varRes, null));
                  out.write(__oracle_jsp_text[18]);
                  out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.parametroValor}",java.lang.String.class, __ojsp_varRes, null));
                  out.write(__oracle_jsp_text[19]);
                  out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.parametroDescripcion}",java.lang.String.class, __ojsp_varRes, null));
                  out.write(__oracle_jsp_text[20]);
                } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[21]);
            out.print(tableManager
										.getPaginacionHTML("parametrosForm"));
            out.write(__oracle_jsp_text[22]);
            
            			} else {
            			
            out.write(__oracle_jsp_text[23]);
            
            			}
            			
            out.write(__oracle_jsp_text[24]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[25]);
      
      			String error = com.meve.sigma.util.Converters
      			.getJavaScriptErrorString(request);
      	if (!error.equals("")) {
      
      out.write(__oracle_jsp_text[26]);
      out.print(error);
      out.write(__oracle_jsp_text[27]);
      
      }
      
      out.write(__oracle_jsp_text[28]);

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
  private static final char __oracle_jsp_text[][]=new char[29][];
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
    "\n\n<HTML>\n<HEAD>\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"./theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK rel=\"stylesheet\" type=\"text/css\"\n\thref=\"./css/calendar/calendar-meve.css\" />\n<TITLE>Parametros</TITLE>\n<script type=\"text/javascript\" src=\"./js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"./js/SigaJS.js\"></script>\n<STYLE type=text/css>\nBODY {\n\tMARGIN: 0px\n}\n</STYLE>\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n</HEAD>\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<BODY background=\"./Imagenes/fondo_claro.jpg\">\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t<input type=\"hidden\" value=\"\" name=\"accion\" />\n\t<input type=\"hidden\" value=\"\" name=\"idLink\" />\n\t<a href=\"javascript:;\"\n\t\tonclick=\"submitForm(document.parametrosForm,'nuevoParametro','');return false;\">\n\t<img src=\"./Imagenes/nuevo1.gif\" border=\"0\" alt=\"Nuevo\"> </a>\n\t<A href=\"javascript:;\"\n\t\tonclick=\"submitForm(document.parametrosForm,'eliminarParametros','');return false;\">\n\t<IMG border=\"0\" src=\"./Imagenes/borrar1.gif\" alt=\"Eliminar\"> </A>\n\t<A href=\"javascript:;\"\n\t\tonclick=\"submitForm(document.parametrosForm,'actualizarParametros','');return false;\">\n\t<IMG border=\"0\" src=\"./Imagenes/actualizar.gif\" alt=\"Actualizar Parametros\"> </A>\n\t<table align=\"center\" width=\"100%\">\n\n\t\t<tr>\n\t\t\t<td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t\t<TABLE WIDTH=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t<TR>\n\t\t\t\t\t<td colspan=\"3\" align=\"right\"><font color=\"#004080\"\n\t\t\t\t\t\tface=\"Arial\">".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t\t\tregistros mostrados.</font></td>\n\t\t\t\t</TR>\n\t\t\t\t<TR BGCOLOR=\"00204F\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\t\t\t\t<TD align=\"center\" width=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "%\">".toCharArray();
    __oracle_jsp_text[13] = 
    "</TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t\t</TR>\n\t\t\t</TABLE>\n\t\t\t<DIV class=documentBody id=Body>\n\t\t\t<TABLE width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td WIDTH='35%'><input type=\"checkbox\" name=\"registros\"\n\t\t\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\"><a href=\"javascript:;\"\n\t\t\t\t\t\t\tonclick=\"submitForm(document.parametrosForm,'verModificarParametro','".toCharArray();
    __oracle_jsp_text[17] = 
    "');return false;\">".toCharArray();
    __oracle_jsp_text[18] = 
    "</a></td>\n\t\t\t\t\t\t<td WIDTH='30%'>".toCharArray();
    __oracle_jsp_text[19] = 
    "</td>\n\t\t\t\t\t\t<td WIDTH='35%'>".toCharArray();
    __oracle_jsp_text[20] = 
    "</td>\n\t\t\t\t\t</tr>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"6\">\n\t\t\t\t\t<TABLE align=\"center\">\n\t\t\t\t\t\t<tr>".toCharArray();
    __oracle_jsp_text[22] = 
    "</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t<td>\n\t\t\t\t</tr>\n\t\t\t</TABLE>\n\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t<CENTER>\n\t\t\t<table cellspacing=\"2\" cellpadding=\"2\">\n\t\t\t\t<tr>\n\t\t\t\t\t<TD align=\"center\">\n\t\t\t\t\t<DIV align=\"center\">\n\t\t\t\t\t<p><FONT size=\"4\" face=\"Verdana\">***** No se han\n\t\t\t\t\tencontrado Documentos ***** </FONT>\n\t\t\t\t\t</DIV>\n\t\t\t\t\t</TD>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</CENTER>\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n".toCharArray();
    __oracle_jsp_text[25] = 
    "\n".toCharArray();
    __oracle_jsp_text[26] = 
    "\n<script>alert('".toCharArray();
    __oracle_jsp_text[27] = 
    "');</script>\n".toCharArray();
    __oracle_jsp_text[28] = 
    "\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
