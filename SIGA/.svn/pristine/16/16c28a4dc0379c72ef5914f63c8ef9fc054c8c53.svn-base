package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.Utilerias;
import com.meve.sigma.beans.*;
import com.meve.sigma.taglib.*;


public class _nuevoRemitente extends com.orionserver.http.OrionHttpJspPage {


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
    _nuevoRemitente page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      java.util.List catalogoArea;
      synchronized (session) {
        if ((catalogoArea = (java.util.List) pageContext.getAttribute( "catalogoArea", PageContext.SESSION_SCOPE)) == null) {
          catalogoArea = (java.util.List) new java.util.ArrayList();
          pageContext.setAttribute( "catalogoArea", catalogoArea, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[5]);
      java.util.List catalogoEntidad;
      synchronized (session) {
        if ((catalogoEntidad = (java.util.List) pageContext.getAttribute( "catalogoEntidad", PageContext.SESSION_SCOPE)) == null) {
          catalogoEntidad = (java.util.List) new java.util.ArrayList();
          pageContext.setAttribute( "catalogoEntidad", catalogoEntidad, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[6]);
      {
        org.apache.struts.taglib.html.SelectTag __jsp_taghandler_1=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag property styleClass");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setProperty("idArea");
        __jsp_taghandler_1.setStyleClass("blue500a");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_1,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[7]);
            {
              org.apache.struts.taglib.html.OptionTag __jsp_taghandler_2=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setValue("-1");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_2,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[8]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[9]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_3=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name type");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setId("registro");
              __jsp_taghandler_3.setName("catalogoArea");
              __jsp_taghandler_3.setType("com.meve.sigma.catalogos.CatalogoArea");
              com.meve.sigma.catalogos.CatalogoArea registro = null;
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_3,__jsp_tag_starteval,out);
                do {
                  registro = (com.meve.sigma.catalogos.CatalogoArea) pageContext.findAttribute("registro");
                  out.write(__oracle_jsp_text[10]);
                  {
                    org.apache.struts.taglib.html.OptionTag __jsp_taghandler_4=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                    __jsp_taghandler_4.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_4.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.id}",java.lang.String.class, __ojsp_varRes,null));
                    __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_4,__jsp_tag_starteval,out);
                      do {
                        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.nombre}",java.lang.String.class, __ojsp_varRes, null));
                      } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,3);
                  }
                  out.write(__oracle_jsp_text[11]);
                } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[12]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[13]);
      {
        org.apache.struts.taglib.html.TextTag __jsp_taghandler_5=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property size styleClass");
        __jsp_taghandler_5.setParent(null);
        __jsp_taghandler_5.setMaxlength("199");
        __jsp_taghandler_5.setProperty("nombre");
        __jsp_taghandler_5.setSize("80");
        __jsp_taghandler_5.setStyleClass("blue500");
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[14]);
      {
        org.apache.struts.taglib.html.TextTag __jsp_taghandler_6=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property size styleClass");
        __jsp_taghandler_6.setParent(null);
        __jsp_taghandler_6.setMaxlength("199");
        __jsp_taghandler_6.setProperty("cargo");
        __jsp_taghandler_6.setSize("80");
        __jsp_taghandler_6.setStyleClass("blue500");
        __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
        if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,1);
      }
      out.write(__oracle_jsp_text[15]);
      {
        org.apache.struts.taglib.html.SelectTag __jsp_taghandler_7=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag property styleClass");
        __jsp_taghandler_7.setParent(null);
        __jsp_taghandler_7.setProperty("idEntidad");
        __jsp_taghandler_7.setStyleClass("blue500a");
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_7,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[16]);
            {
              org.apache.struts.taglib.html.OptionTag __jsp_taghandler_8=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
              __jsp_taghandler_8.setParent(__jsp_taghandler_7);
              __jsp_taghandler_8.setValue("-1");
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_8,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[17]);
                } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[18]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_9=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name type");
              __jsp_taghandler_9.setParent(__jsp_taghandler_7);
              __jsp_taghandler_9.setId("registro");
              __jsp_taghandler_9.setName("catalogoEntidad");
              __jsp_taghandler_9.setType("com.meve.sigma.catalogos.CatalogoEntidad");
              com.meve.sigma.catalogos.CatalogoEntidad registro = null;
              __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_9,__jsp_tag_starteval,out);
                do {
                  registro = (com.meve.sigma.catalogos.CatalogoEntidad) pageContext.findAttribute("registro");
                  out.write(__oracle_jsp_text[19]);
                  {
                    org.apache.struts.taglib.html.OptionTag __jsp_taghandler_10=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                    __jsp_taghandler_10.setParent(__jsp_taghandler_9);
                    __jsp_taghandler_10.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.id}",java.lang.String.class, __ojsp_varRes,null));
                    __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_10,__jsp_tag_starteval,out);
                      do {
                        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.nombre}",java.lang.String.class, __ojsp_varRes, null));
                      } while (__jsp_taghandler_10.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,3);
                  }
                  out.write(__oracle_jsp_text[20]);
                } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
            }
            out.write(__oracle_jsp_text[21]);
          } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      out.write(__oracle_jsp_text[22]);
      {
        org.apache.struts.taglib.html.TextTag __jsp_taghandler_11=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property size styleClass");
        __jsp_taghandler_11.setParent(null);
        __jsp_taghandler_11.setMaxlength("199");
        __jsp_taghandler_11.setProperty("direccion");
        __jsp_taghandler_11.setSize("80");
        __jsp_taghandler_11.setStyleClass("blue500");
        __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
        if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,1);
      }
      out.write(__oracle_jsp_text[23]);
      {
        org.apache.struts.taglib.html.TextTag __jsp_taghandler_12=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property size styleClass");
        __jsp_taghandler_12.setParent(null);
        __jsp_taghandler_12.setMaxlength("199");
        __jsp_taghandler_12.setProperty("telefono");
        __jsp_taghandler_12.setSize("80");
        __jsp_taghandler_12.setStyleClass("blue500");
        __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
        if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,1);
      }
      out.write(__oracle_jsp_text[24]);
      {
        org.apache.struts.taglib.html.TextTag __jsp_taghandler_13=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property size styleClass");
        __jsp_taghandler_13.setParent(null);
        __jsp_taghandler_13.setMaxlength("199");
        __jsp_taghandler_13.setProperty("fax");
        __jsp_taghandler_13.setSize("80");
        __jsp_taghandler_13.setStyleClass("blue500");
        __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
        if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,1);
      }
      out.write(__oracle_jsp_text[25]);
      {
        org.apache.struts.taglib.html.TextTag __jsp_taghandler_14=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property size styleClass");
        __jsp_taghandler_14.setParent(null);
        __jsp_taghandler_14.setMaxlength("199");
        __jsp_taghandler_14.setProperty("correo");
        __jsp_taghandler_14.setSize("80");
        __jsp_taghandler_14.setStyleClass("blue500");
        __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
        if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,1);
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
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Remitente</TITLE>\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\"></SCRIPT>\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n<form action=\"nuevoRemitente.siga\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"150\"><a href=\"\"> <img\n\t\t\t\tsrc=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\" border=\"0\"> </a>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a onclick=\"\"> <img\n\t\t\t\tsrc=\"../Imagenes/Save.gif\" alt=\"Guardar\" border=\"0\"> </a> &nbsp;</TD>\n\t\t\t<TD width=\"150\">&nbsp;</TD>\n\t\t\t<TD width=\"150\"></TD>\n\t\t\t<TD width=\"217\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<BR>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\" colspan=\"2\"><B><FONT face=\"Verdana\"\n\t\t\t\tcolor=\"#00204f\" size=\"2\">Remitentes</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<td bgcolor=\"#004080\" colspan=\"4\" width=\"672\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t<TD align=\"right\" colspan=\"3\" width=\"528\"><FONT face=\"Verdana\"\n\t\t\t\tsize=\"2\"></FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n\n\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Unidad\n\t\t\tAdministrativa:</B></FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[8] = 
    "------------- Seleccione una Unidad Administrativa ------------- ".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    " </FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Nombre:</B></FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    " </FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Cargo:</B></FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    " </FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Entidad:</B></FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "------------- Seleccione una Entidad ------------- ".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    " </FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Dirección:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">".toCharArray();
    __oracle_jsp_text[23] = 
    "</FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Telefono:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "</FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Fax:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "</FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Correo:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "</FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\n\t</TBODY>\n</TABLE>\n</DIV>\n</form>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
