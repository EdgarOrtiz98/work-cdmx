package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.Utilerias;
import com.meve.sigma.taglib.*;
import com.meve.sigma.beans.*;
import java.util.*;


public class _directorioAreas extends com.orionserver.http.OrionHttpJspPage {


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
    _directorioAreas page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      
      			UsuarioBean BUsuario = (UsuarioBean) session
      			.getAttribute("UsuarioBean");
      
      out.write(__oracle_jsp_text[5]);
      java.util.List unidades;
      synchronized (session) {
        if ((unidades = (java.util.List) pageContext.getAttribute( "unidades", PageContext.SESSION_SCOPE)) == null) {
          unidades = (java.util.List) new java.util.ArrayList();
          pageContext.setAttribute( "unidades", unidades, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[6]);
      java.util.List externas;
      synchronized (session) {
        if ((externas = (java.util.List) pageContext.getAttribute( "externas", PageContext.SESSION_SCOPE)) == null) {
          externas = (java.util.List) new java.util.ArrayList();
          pageContext.setAttribute( "externas", externas, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[7]);
      java.lang.String tipoEntidades;
      synchronized (session) {
        if ((tipoEntidades = (java.lang.String) pageContext.getAttribute( "tipoEntidades", PageContext.SESSION_SCOPE)) == null) {
          tipoEntidades = (java.lang.String) new java.lang.String();
          pageContext.setAttribute( "tipoEntidades", tipoEntidades, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[8]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("directorio.siga");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[9]);
            {
              org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_2=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("tipoEntidades");
              __jsp_taghandler_2.setValue("externas");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[10]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_3=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property styleClass");
                    __jsp_taghandler_3.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_3.setMaxlength("199");
                    __jsp_taghandler_3.setProperty("cadenaBusqueda");
                    __jsp_taghandler_3.setStyleClass("blue200");
                    __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
                    if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,3);
                  }
                  out.write(__oracle_jsp_text[11]);
                  {
                    org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_4=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name type");
                    __jsp_taghandler_4.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_4.setId("registro");
                    __jsp_taghandler_4.setIndexId("contador");
                    __jsp_taghandler_4.setName("externas");
                    __jsp_taghandler_4.setType("com.meve.sigma.catalogos.CatalogoEntidad");
                    com.meve.sigma.catalogos.CatalogoEntidad registro = null;
                    java.lang.Integer contador = null;
                    __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_4,__jsp_tag_starteval,out);
                      do {
                        registro = (com.meve.sigma.catalogos.CatalogoEntidad) pageContext.findAttribute("registro");
                        contador = (java.lang.Integer) pageContext.findAttribute("contador");
                        out.write(__oracle_jsp_text[12]);
                        {
                          org.apache.struts.taglib.html.RadioTag __jsp_taghandler_5=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag property value");
                          __jsp_taghandler_5.setParent(__jsp_taghandler_4);
                          __jsp_taghandler_5.setProperty("idEntidad");
                          __jsp_taghandler_5.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.id}",java.lang.String.class, __ojsp_varRes,null));
                          __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                          if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,4);
                        }
                        out.write(__oracle_jsp_text[13]);
                        out.print(Utilerias.recortaString(registro.getNombre(),80));
                        out.write(__oracle_jsp_text[14]);
                      } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,3);
                  }
                  out.write(__oracle_jsp_text[15]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[16]);
            {
              org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_6=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
              __jsp_taghandler_6.setParent(__jsp_taghandler_1);
              __jsp_taghandler_6.setName("tipoEntidades");
              __jsp_taghandler_6.setValue("internas");
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[17]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_7=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property styleClass");
                    __jsp_taghandler_7.setParent(__jsp_taghandler_6);
                    __jsp_taghandler_7.setMaxlength("199");
                    __jsp_taghandler_7.setProperty("cadenaBusqueda");
                    __jsp_taghandler_7.setStyleClass("blue200");
                    __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
                    if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,3);
                  }
                  out.write(__oracle_jsp_text[18]);
                  {
                    org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_8=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name type");
                    __jsp_taghandler_8.setParent(__jsp_taghandler_6);
                    __jsp_taghandler_8.setId("registro");
                    __jsp_taghandler_8.setIndexId("contador");
                    __jsp_taghandler_8.setName("unidades");
                    __jsp_taghandler_8.setType("com.meve.sigma.catalogos.CatalogoArea");
                    com.meve.sigma.catalogos.CatalogoArea registro = null;
                    java.lang.Integer contador = null;
                    __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_8,__jsp_tag_starteval,out);
                      do {
                        registro = (com.meve.sigma.catalogos.CatalogoArea) pageContext.findAttribute("registro");
                        contador = (java.lang.Integer) pageContext.findAttribute("contador");
                        out.write(__oracle_jsp_text[19]);
                        {
                          org.apache.struts.taglib.html.RadioTag __jsp_taghandler_9=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag property value");
                          __jsp_taghandler_9.setParent(__jsp_taghandler_8);
                          __jsp_taghandler_9.setProperty("idArea");
                          __jsp_taghandler_9.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.id}",java.lang.String.class, __ojsp_varRes,null));
                          __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                          if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,4);
                        }
                        out.write(__oracle_jsp_text[20]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_10=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_10.setParent(__jsp_taghandler_8);
                          __jsp_taghandler_10.setName("registro");
                          __jsp_taghandler_10.setProperty("activa");
                          __jsp_taghandler_10.setValue("false");
                          __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[21]);
                              out.print(Utilerias.recortaString(registro.getNombre(),80));
                              out.write(__oracle_jsp_text[22]);
                            } while (__jsp_taghandler_10.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,4);
                        }
                        out.write(__oracle_jsp_text[23]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_11=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_11.setParent(__jsp_taghandler_8);
                          __jsp_taghandler_11.setName("registro");
                          __jsp_taghandler_11.setProperty("activa");
                          __jsp_taghandler_11.setValue("true");
                          __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[24]);
                              out.print(Utilerias.recortaString(registro.getNombre(),80));
                              out.write(__oracle_jsp_text[25]);
                            } while (__jsp_taghandler_11.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,4);
                        }
                        out.write(__oracle_jsp_text[26]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_12=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_12.setParent(__jsp_taghandler_8);
                          __jsp_taghandler_12.setName("registro");
                          __jsp_taghandler_12.setProperty("activa");
                          __jsp_taghandler_12.setValue("true");
                          __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[27]);
                            } while (__jsp_taghandler_12.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,4);
                        }
                        out.write(__oracle_jsp_text[28]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_13=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_13.setParent(__jsp_taghandler_8);
                          __jsp_taghandler_13.setName("registro");
                          __jsp_taghandler_13.setProperty("activa");
                          __jsp_taghandler_13.setValue("false");
                          __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[29]);
                            } while (__jsp_taghandler_13.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,4);
                        }
                        out.write(__oracle_jsp_text[30]);
                      } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,3);
                  }
                  out.write(__oracle_jsp_text[31]);
                } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[32]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[33]);

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
  private static final char __oracle_jsp_text[][]=new char[34][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"./theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Entidad</TITLE>\n<script type=\"text/javascript\" src=\"./js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"./js/SigaJS.js\"></script>\n<script type=\"text/javascript\" src=\"./js/ventana/ventanas.js\"></script>\n<script type=\"text/javascript\" src=\"./js/ventana/controladorDeContenido.js\"></script>\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n</HEAD>\n<BODY background=\"./Imagenes/fondo_claro.jpg\">\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n    <input type=\"hidden\" value=\"directorio\" name=\"accion\" />\n\t <input type=\"hidden\" value=\"\" name=\"idLink\" />\n\t<h2>&nbsp;&nbsp;&nbsp;\n\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t<font color=\"#2121ff\" face=\"Arial\"> <strong><em>Directorio</em></strong>\n\t</font></h2>\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"15%\">\n\t\t\t<div align=\"left\"><input type=\"button\" onclick=\"submitForm(document.directorioForm,'directorio','cargaInternos');return false;\"\n\t\t\t\tvalue=\"U.A. de la SHCP\" class=\"blue100a\"></div>\n\t\t\t</td>\n\t\t\t<td width=\"15%\">\n\t\t\t<div align=\"center\"><input type=\"button\" onclick=\"submitForm(document.directorioForm,'directorio','cargaExternos');return false;\"\n\t\t\t\tvalue=\"Areas Externas\" class=\"blue100a\"></div>\n\t\t\t</td>\n\n\t\t\t<td width=\"20%\">&nbsp;</td>\n\t\t\t<td width=\"50%\">\n\t\t\t<div align=\"right\"><input type=\"button\"\n\t\t\t\tonclick=\"submitForm(document.directorioForm,'directorio','nuevaEntidad'); return false;\" value=\"Otra Entidad...\"\n\t\t\t\tclass=\"blue100a\"> <input type=\"button\"\n\t\t\t\tonclick=\"submitVentana('directorio','guardaArea',document.directorioForm,'ventana');return false;\" value=\"Aceptar\" class=\"blue100a\">\n\t\t\t<input type=\"button\" value=\"Cancelar\" class=\"blue100a\"\n\t\t\t\tonclick=\"cierraVentana('ventana');return false;\"></div>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t<div align=\"left\">Buscar: &nbsp; ".toCharArray();
    __oracle_jsp_text[11] = 
    "<A title=\"Buscar\"\n\t\tonclick=\"submitForm(document.directorioForm,'directorio','buscaExternos'); return false;\">&nbsp; <IMG border=\"0\"\n\t\tsrc=\"./Imagenes/ico_bus.gif\" width=\"26\" height=\"26\"></A><br>\n\t</div>\n\t<BR>\n\t<table width=\"100%\" border=\"0\">\n\t\t<tr BGCOLOR=\"00204F\">\n\t\t\t<TD WIDTH='100%' align=\"center\"><FONT SIZE=1 COLOR=\"FFFFFF\"\n\t\t\t\tFACE=\"verdana\"> <a onclick=\"cambio('asc', 1)\"><IMG\n\t\t\t\tborder=\"0\" src=\"./Imagenes/arriba.gif\" align=\"middle\" width=\"10\"\n\t\t\t\theight=\"10\"></a> Entidades de la Unidad Administrativa <a\n\t\t\t\tonclick=\"cambio('desc', 1)\"><IMG border=\"0\"\n\t\t\t\tsrc=\"./Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font></TD>\n\t\t</tr>\n\t</table>\n\t<DIV class=documentBody id=Body>\n\t<TABLE width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t<tr>\n\t\t\t\t<td width=\"100%\">".toCharArray();
    __oracle_jsp_text[13] = 
    "   \n\t\t\t\t\t <FONT face=Arial color=\"#000080\" size=1>\n\t\t\t\t\t    <A> ".toCharArray();
    __oracle_jsp_text[14] = 
    "</A>\n\t\t\t\t\t </FONT>\n\t\t\t    </td>\n\t\t\t</tr>\n\n\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t</TABLE>\n\t</DIV>\n\t<br>\n\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n    <div align=\"left\">Buscar: &nbsp; ".toCharArray();
    __oracle_jsp_text[18] = 
    "<A title=\"Buscar\"\n\t\tonclick=\"submitForm(document.directorioForm,'directorio','buscaInternos'); return false;\">&nbsp; <IMG border=\"0\"\n\t\tsrc=\"./Imagenes/ico_bus.gif\" width=\"26\" height=\"26\"></A><br>\n\t</div>\n\t<BR>\n\t<TABLE WIDTH='100%' BORDER=0>\n\t\t<TR BGCOLOR=\"00204F\">\n\t\t\t<TD WIDTH='80%' align=\"center\"><FONT SIZE=1 COLOR=\"FFFFFF\"\n\t\t\t\tFACE=\"verdana\"> <a onclick=\"cambio('asc', 1)\"><IMG\n\t\t\t\tborder=\"0\" src=\"./Imagenes/arriba.gif\" align=\"middle\" width=\"10\"\n\t\t\t\theight=\"10\"></a> Unidad Administrativa <a\n\t\t\t\tonclick=\"cambio('desc', 1)\"><IMG border=\"0\"\n\t\t\t\tsrc=\"./Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font></TD>\n\t\t\t<TD WIDTH='20%' align=\"center\"><FONT SIZE=1 COLOR=\"FFFFFF\"\n\t\t\t\tFACE=\"verdana\"> <a onclick=\"cambio('desc', 2)\"><IMG\n\t\t\t\tborder=\"0\" src=\"./Imagenes/arriba.gif\" align=\"middle\" width=\"10\"\n\t\t\t\theight=\"10\"></a> Operando en SIGA <a onclick=\"cambio('asc', 2)\"><IMG\n\t\t\t\tborder=\"0\" src=\"./Imagenes/abajo.gif\" align=\"middle\" width=\"10\"\n\t\t\t\theight=\"10\"></a> </font></TD>\n\t\t</TR>\n\t</TABLE>\n\t<DIV class=documentBody id=Body>\n\t<TABLE width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t<tr>\n\t\t\t\t<td width=\"80%\">\n\t\t\t\t    ".toCharArray();
    __oracle_jsp_text[20] = 
    " \n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t\t\t<FONT face=Arial color=\"red\" size=1>\n\t\t\t\t\t   <A id=\"area\"> ".toCharArray();
    __oracle_jsp_text[22] = 
    "</A>\n\t\t\t\t\t </FONT>\n\t\t\t\t\t ".toCharArray();
    __oracle_jsp_text[23] = 
    "   \n\t\t\t\t\t ".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t\t <FONT face=Arial color=\"#000080\" size=1>\n\t\t\t\t\t    <A> ".toCharArray();
    __oracle_jsp_text[25] = 
    "</A>\n\t\t\t\t\t </FONT>\n\t\t\t\t\t ".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t    </td>\n\t\t\t\t<td width=\"20%\" align=\"center\">\n\t\t\t\t   ".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t       Si\n\t\t\t\t   ".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t\t   ".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t      No\n\t\t\t\t   ".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t </td>\n\t\t\t</tr>\n\n\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t</TABLE>\n\t</DIV>\n\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t<script>\n\tvar bodyElement = document.body.all['Body'] ;\n\tfunction LayoutBodyElement() {  \n\t   bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;\n\t}\n\tfunction document.onreadystatechange(){ \n\t   document.body.scroll = \"no\" ; \n\t   LayoutBodyElement( ) ; \n\t   window.onresize = LayoutBodyElement;\n\t }\n\t </script>\n".toCharArray();
    __oracle_jsp_text[33] = 
    "\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
