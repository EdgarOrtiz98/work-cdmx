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


public class _nuevaEntidad extends com.orionserver.http.OrionHttpJspPage {


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
    _nuevaEntidad page = this;
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
      
      			UsuarioBean BUsuario = (UsuarioBean) session
      			.getAttribute("UsuarioBean");
      
      out.write(__oracle_jsp_text[7]);
      java.util.List catalogoArea;
      synchronized (session) {
        if ((catalogoArea = (java.util.List) pageContext.getAttribute( "catalogoArea", PageContext.SESSION_SCOPE)) == null) {
          catalogoArea = (java.util.List) new java.util.ArrayList();
          pageContext.setAttribute( "catalogoArea", catalogoArea, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[8]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("nuevaEntidad.siga");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[9]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_2=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag property styleClass");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setProperty("area");
              __jsp_taghandler_2.setStyleClass("blue500a");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_2,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[10]);
                  {
                    org.apache.struts.taglib.html.OptionTag __jsp_taghandler_3=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                    __jsp_taghandler_3.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_3.setValue("-1");
                    __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_3,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[11]);
                      } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,3);
                  }
                  out.write(__oracle_jsp_text[12]);
                  {
                    org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_4=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name type");
                    __jsp_taghandler_4.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_4.setId("registro");
                    __jsp_taghandler_4.setName("catalogoArea");
                    __jsp_taghandler_4.setType("com.meve.sigma.catalogos.CatalogoArea");
                    com.meve.sigma.catalogos.CatalogoArea registro = null;
                    __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_4,__jsp_tag_starteval,out);
                      do {
                        registro = (com.meve.sigma.catalogos.CatalogoArea) pageContext.findAttribute("registro");
                        out.write(__oracle_jsp_text[13]);
                        {
                          org.apache.struts.taglib.html.OptionTag __jsp_taghandler_5=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                          __jsp_taghandler_5.setParent(__jsp_taghandler_4);
                          __jsp_taghandler_5.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.id}",java.lang.String.class, __ojsp_varRes,null));
                          __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_5,__jsp_tag_starteval,out);
                            do {
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.nombre}",java.lang.String.class, __ojsp_varRes, null));
                            } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,4);
                        }
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
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[16]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_6=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag property size styleClass");
              __jsp_taghandler_6.setParent(__jsp_taghandler_1);
              __jsp_taghandler_6.setProperty("nombre");
              __jsp_taghandler_6.setSize("80");
              __jsp_taghandler_6.setStyleClass("blue500");
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[17]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_7=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag property styleClass");
              __jsp_taghandler_7.setParent(__jsp_taghandler_1);
              __jsp_taghandler_7.setProperty("clasificacion");
              __jsp_taghandler_7.setStyleClass("blue200a");
              __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_7,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[18]);
                  {
                    org.apache.struts.taglib.html.OptionTag __jsp_taghandler_8=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                    __jsp_taghandler_8.setParent(__jsp_taghandler_7);
                    __jsp_taghandler_8.setValue("Privada");
                    __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_8,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[19]);
                      } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,3);
                  }
                  out.write(__oracle_jsp_text[20]);
                  {
                    org.apache.struts.taglib.html.OptionTag __jsp_taghandler_9=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                    __jsp_taghandler_9.setParent(__jsp_taghandler_7);
                    __jsp_taghandler_9.setValue("Pública");
                    __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_9,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[21]);
                      } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,3);
                  }
                  out.write(__oracle_jsp_text[22]);
                } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,2);
            }
            out.write(__oracle_jsp_text[23]);
            {
              org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_10=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols property rows styleClass");
              __jsp_taghandler_10.setParent(__jsp_taghandler_1);
              __jsp_taghandler_10.setCols("80");
              __jsp_taghandler_10.setProperty("direccion");
              __jsp_taghandler_10.setRows("3");
              __jsp_taghandler_10.setStyleClass("blue500");
              __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
              if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,2);
            }
            out.write(__oracle_jsp_text[24]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_11=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property styleClass");
              __jsp_taghandler_11.setParent(__jsp_taghandler_1);
              __jsp_taghandler_11.setMaxlength("199");
              __jsp_taghandler_11.setProperty("telefono");
              __jsp_taghandler_11.setStyleClass("blue500");
              __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
              if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,2);
            }
            out.write(__oracle_jsp_text[25]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[26]);

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
  private static final char __oracle_jsp_text[][]=new char[27][];
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
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"./theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Entidad</TITLE>\n<script type=\"text/javascript\" src=\"./js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"./js/SigaJS.js\"></script>\n<script type=\"text/javascript\" src=\"./js/ventana/ventanas.js\"></script>\n<script type=\"text/javascript\"\n\tsrc=\"./js/ventana/controladorDeContenido.js\"></script>\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n</HEAD>\n<BODY background=\"./Imagenes/fondo_claro.jpg\">\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t<input type=\"hidden\" value=\"directorio\" name=\"accion\" />\n\t<input type=\"hidden\" value=\"\" name=\"idLink\" />\n\t<h2></h2>\n\t<DIV align=\"center\">\n\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t<TBODY>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"150\"><a href=\"\" onclick=\"submitForm(document.catalogoEntidad,'regresar','');return false;\"><img\n\t\t\t\t\tsrc=\"./Imagenes/NavLeft.gif\" alt=\"Regresar\" border=\"0\"> </a>\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a\n\t\t\t\t\tonclick=\"submitForm(document.catalogoEntidad,'guardar','');return false;\"> <img src=\"./Imagenes/Save.gif\"\n\t\t\t\t\talt=\"Guardar\" border=\"0\"> </a> &nbsp;</TD>\n\t\t\t\t<TD width=\"150\">&nbsp;</TD>\n\t\t\t\t<TD width=\"150\">&nbsp;</TD>\n\t\t\t\t<TD width=\"217\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t</TBODY>\n\t</TABLE>\n\t</DIV>\n\t<BR>\n\t<DIV align=\"center\">\n\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t<TBODY>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"336\" colspan=\"2\"><B><FONT face=\"Verdana\"\n\t\t\t\t\tcolor=\"#00204f\" size=\"2\">Entidad</FONT></B></TD>\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<td width=\"672\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t\t</TR>\n\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t\t<TD width=\"528\" align=\"right\" colspan=\"3\">&nbsp;</td>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t</TR>\n\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Unidad\n\t\t\t\tAdministrativa:</B></FONT></TD>\n\t\t\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "------------- Seleccione una Unidad Administrativa ------------- ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    " </FONT></TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Entidad:</B></FONT>\n\n\t\t\t\t</TD>\n\t\t\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    " </FONT></TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Clasificación:</FONT></TD>\n\t\t\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "Privada".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "Pública".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    " </FONT></TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t</TR>\n\n\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Dirección:</FONT></TD>\n\t\t\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t</FONT></TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Teléfono:</FONT></TD>\n\t\t\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Arial\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t\t</FONT></TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"672\" colspan=\"4\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t</TBODY>\n\t</TABLE>\n\t</DIV>\n\t<script>\n\tvar bodyElement = document.body.all['Body'] ;\n\tfunction LayoutBodyElement() {  \n\t   bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;\n\t}\n\tfunction document.onreadystatechange(){ \n\t   document.body.scroll = \"no\" ; \n\t   LayoutBodyElement( ) ; \n\t   window.onresize = LayoutBodyElement;\n\t }\n\t </script>\n".toCharArray();
    __oracle_jsp_text[26] = 
    "\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
