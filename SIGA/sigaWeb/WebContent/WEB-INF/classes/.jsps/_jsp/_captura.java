package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.asunto.AsuntoForm;
import com.meve.sigma.taglib.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.util.*;
import java.util.*;
import com.meve.sigma.beans.search.*;


public class _captura extends com.orionserver.http.OrionHttpJspPage {


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
    _captura page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      
      			UsuarioBean BUsuario = (UsuarioBean) session
      			.getAttribute("UsuarioBean");
      	if (BUsuario == null) {
      		try {
      			response.sendRedirect("./jsp/index.jsp");
      			return;
      		} catch (Exception io) {
      			System.out.println("ERROR:" + io.getMessage());
      		}
      	}
      
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
      out.write(__oracle_jsp_text[7]);
      out.write(__oracle_jsp_text[8]);
      out.write(__oracle_jsp_text[9]);
      out.write(__oracle_jsp_text[10]);
      out.write(__oracle_jsp_text[11]);
      {
        String __url=OracleJspRuntime.toStr("headerSIGA.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[12]);
      
      response.setHeader("Cache-Control","no-cache");
      response.setHeader("Pragma","no-cache"); 
      response.setDateHeader ("Expires", 0);
      
      out.write(__oracle_jsp_text[13]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("captura.siga");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[14]);
            {
              org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_2=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("asuntoForm");
              __jsp_taghandler_2.setProperty("estatus");
              __jsp_taghandler_2.setValue(OracleJspRuntime.toStr( String.valueOf(Estatus.ASU_EN_RECEPCION)));
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[15]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[16]);
            {
              org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_3=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setName("asuntoForm");
              __jsp_taghandler_3.setProperty("estatus");
              __jsp_taghandler_3.setValue(OracleJspRuntime.toStr( String.valueOf(Estatus.ASU_POR_TURNAR)));
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[17]);
                } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[18]);
            {
              org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_4=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setName("asuntoForm");
              __jsp_taghandler_4.setProperty("estatus");
              __jsp_taghandler_4.setValue(OracleJspRuntime.toStr( String.valueOf(Estatus.ASU_TURNADO)));
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[19]);
                } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[20]);
            {
              org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_5=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
              __jsp_taghandler_5.setParent(__jsp_taghandler_1);
              __jsp_taghandler_5.setName("asuntoForm");
              __jsp_taghandler_5.setProperty("estatus");
              __jsp_taghandler_5.setValue(OracleJspRuntime.toStr( String.valueOf(Estatus.ASU_TERMINADO)));
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[21]);
                } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[22]);
            {
              String __url=OracleJspRuntime.toStr("./menuOperacionAsunto.jsp");
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[23]);
            out.print(BUsuario.getCargo());
            out.write(__oracle_jsp_text[24]);
            out.print(new java.util.Date());
            out.write(__oracle_jsp_text[25]);
            out.write(__oracle_jsp_text[26]);
            {
              org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_6=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
              __jsp_taghandler_6.setParent(__jsp_taghandler_1);
              __jsp_taghandler_6.setName("asuntoForm");
              __jsp_taghandler_6.setProperty("idEntidad");
              __jsp_taghandler_6.setValue("-1");
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[27]);
                  out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${asuntoForm.area}",java.lang.String.class, __ojsp_varRes, null));
                  out.write(__oracle_jsp_text[28]);
                } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[29]);
            {
              org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_7=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
              __jsp_taghandler_7.setParent(__jsp_taghandler_1);
              __jsp_taghandler_7.setName("asuntoForm");
              __jsp_taghandler_7.setProperty("idEntidad");
              __jsp_taghandler_7.setValue("-1");
              __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[30]);
                  out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${asuntoForm.entidad}",java.lang.String.class, __ojsp_varRes, null));
                  out.write(__oracle_jsp_text[31]);
                } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,2);
            }
            out.write(__oracle_jsp_text[32]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${asuntoForm.idArea}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[33]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${asuntoForm.idEntidad}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[34]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${asuntoForm.remitenteNombre}",java.lang.String.class, __ojsp_varRes, null));
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${asuntoForm.puesto}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[35]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_8=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag property size styleClass value");
              __jsp_taghandler_8.setParent(__jsp_taghandler_1);
              __jsp_taghandler_8.setProperty("firmanteNombre");
              __jsp_taghandler_8.setSize("80");
              __jsp_taghandler_8.setStyleClass("blue600a");
              __jsp_taghandler_8.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${asuntoForm.remitenteNombre}",java.lang.String.class, __ojsp_varRes,null));
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[36]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${asuntoForm.tipoAsunto}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[37]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_9=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag property");
              __jsp_taghandler_9.setParent(__jsp_taghandler_1);
              __jsp_taghandler_9.setProperty("destinatarioNombre");
              __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
              if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
            }
            out.write(__oracle_jsp_text[38]);
            {
              _oracle._jsp._tag._ventana_tag __jsp_taghandler_10=(_oracle._jsp._tag._ventana_tag)OracleJspRuntime.getSimpleTagHandler(_oracle._jsp._tag._ventana_tag.class, pageContext);
              __jsp_taghandler_10.setParent(__jsp_taghandler_1);
              __jsp_taghandler_10.setJspContext(pageContext);
              __jsp_taghandler_10.setId("ventana");
              __jsp_taghandler_10.setUrl("jsp/cargando.jsp");
              __jsp_taghandler_10.setTitulo("Areas");
              __jsp_taghandler_10.setWidth("800");
              __jsp_taghandler_10.setHeight("450");
              __jsp_taghandler_10.setTop("30px");
              __jsp_taghandler_10.setLeft("370px");
              __jsp_taghandler_10.doTag();
              OracleJspRuntime.simpleReleaseTagHandler(__jsp_taghandler_10, pageContext);
            }
            out.write(__oracle_jsp_text[39]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[40]);

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
  private static final char __oracle_jsp_text[][]=new char[41][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n".toCharArray();
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
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Nuevo Asunto</TITLE>\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\n<LINK href=\"./theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/link.css\" />\n<script type=\"text/javascript\" src=\"./js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"./js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"./js/SigaJS.js\"></script>\n<script type=\"text/javascript\" src=\"./js/ventana/ventanas.js\"></script>\n<script type=\"text/javascript\" src=\"./js/link.js\"></script>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<STYLE type=text/css>\nBODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n<BODY background=\"./Imagenes/fondo_claro.jpg\"\">\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n\t<INPUT type=\"hidden\" value=\"\" name=\"idLink\">\n\t<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"99%\" border=\"0\">\n\t\t<TBODY>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t\t</TD>\n\t\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t</TBODY>\n\t</TABLE>\n\t<BR />\n\t<DIV align=\"center\">\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"863\">".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\t\t\tface=\"Verdana\">Asunto En Recepci&oacute;n</font></b></div>\n\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    " ".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\t\t\tface=\"Verdana\">Asunto Por Turnar</font></b></div>\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    " ".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\t\t\tface=\"Verdana\">Asunto En Tr&aacute;mite</font></b></div>\n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    " ".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\t\t\tface=\"Verdana\">Asunto Terminado</font></b></div>\n\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "</td>\n\t\t</tr>\n\t</table>\n\t</DIV>\n\t<BR />\n\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t<DIV align=\"center\">\n\t<TABLE>\n\t\t<TBODY>\n\t\t\t<TR>\n\t\t\t\t<TD width=\"863\" align=\"center\"><FONT face=\"Arial\" color=\"red\"\n\t\t\t\t\tsize=\"4\"></FONT></TD>\n\t\t\t</TR>\n\t\t</TBODY>\n\t</TABLE>\n\t</DIV>\n\t<BR>\n\t<DIV align=\"center\">\n\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t<TBODY>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\t\t\tface=\"Arial\">Datos Generales</font></b></td>\n\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"380\">\n\t\t\t\t<DIV align=\"right\"><FONT face=\"Arial\" color=\"#00204f\" size=\"2\">**Los\n\t\t\t\tdatos marcados con negritas son obligatorios</FONT></DIV>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"847\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\t\tsrc=\"./Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t</TBODY>\n\t</TABLE>\n\t</DIV>\n\t<DIV align=\"center\">\n\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t<TBODY>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<td width=\"183\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<TD width=\"380\">\n\t\t\t\t<DIV align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[24] = 
    " - ".toCharArray();
    __oracle_jsp_text[25] = 
    "</I></FONT>\n\t\t\t\t</DIV>\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t</TBODY>\n\t</TABLE>\n\t</DIV>\n\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t<br>\n\t<DIV align=\"center\">\n\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t<TBODY>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\t\t\tface=\"Arial\">Datos del Remitente</font></b></td>\n\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"363\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\t\tsrc=\"./Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t</TBODY>\n\t</TABLE>\n\t</DIV>\n\n\t<DIV align=\"center\">\n\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t<TBODY>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"360\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"183\"><B><FONT face=\"Arial\" color=\"#004080\"\n\t\t\t\t\tsize=\"2\">&Aacute;rea Generadora:</FONT></B> <INPUT name=\"botEntidad\"\n\t\t\t\t\ttype=\"button\"\n\t\t\t\t\tonclick=\"cargaVentana('ventana','directorio.siga?accion=directorio&idLink=cargaInternos');return false; \"\n\t\t\t\t\tclass=\"s-dropdown-btn\"></TD>\n\n\t\t\t\t<TD colspan=\"3\">\n\t\t\t\t   ".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t\t   <FONT face=\"Arial\" size=\"2\"> \n\t\t\t\t\t   <input type=\"text\" size=\"80\"  class=\"blue600a\"  readonly=\"readonly\" value=\"".toCharArray();
    __oracle_jsp_text[28] = 
    "\"> \n\t\t\t\t\t   </FONT>\n\t\t\t\t    ".toCharArray();
    __oracle_jsp_text[29] = 
    " \n\t\t\t\t   ".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t\t   <FONT face=\"Arial\" size=\"2\"> \n\t\t\t\t\t       <input type=\"text\" size=\"80\"  class=\"blue600a\"  readonly=\"readonly\" value=\"".toCharArray();
    __oracle_jsp_text[31] = 
    "\"> \n\t\t\t\t   ".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t</TD>\n\t\t\t</TR>\n\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"360\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"183\"><B><FONT face=\"Arial\" color=\"#004080\"\n\t\t\t\t\tsize=\"2\">De:</FONT></B> <INPUT name=\"botDe\" type=\"button\"\n\t\t\t\t\tonclick=\"cargaVentana('ventana','remitente.siga?accion=remitentes&idLink=cargaRemitentes&idArea=".toCharArray();
    __oracle_jsp_text[33] = 
    "&idEntidad=".toCharArray();
    __oracle_jsp_text[34] = 
    "');return false; \"\n\t\t\t\t\tclass=\"s-dropdown-btn\"></TD>\n\t\t\t\t<TD colspan=\"3\"><FONT face=\"Arial\" size=\"2\"> \n\t\t\t\t\n\t\t\t\t<input type=\"text\" class=\"blue600a\" size=\"80\" readonly=\"readonly\" value=\"".toCharArray();
    __oracle_jsp_text[35] = 
    "\"/> </FONT></TD>\n\t\t\t</TR>\n\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"360\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Firmante:</FONT>\n\t\t\t\t</TD>\n\t\t\t\t<TD colspan=\"3\">".toCharArray();
    __oracle_jsp_text[36] = 
    "</TD>\n\t\t\t</TR>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"360\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\"><B>Documento\n\t\t\t\tde:</B></FONT></TD>\n\t\t\t\t<TD colspan=\"3\"><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t </font></TD>\n\t\t\t</TR>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"360\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t</TBODY>\n\t</TABLE>\n\t</DIV>\n\t<br>\n\t<DIV align=\"center\">\n\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t<TBODY>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\t\t\tface=\"Arial\">Datos de Ventanilla</font></b></td>\n\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"363\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\t\tsrc=\"./Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t</TBODY>\n\t</TABLE>\n\t</DIV>\n\t<br>\n\t<DIV align=\"center\">\n\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t<TBODY>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"364\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"183\"><B><FONT face=\"Arial\" color=\"#004080\"\n\t\t\t\t\tsize=\"2\">Responsable del<BR>\n\t\t\t\tTurno:</FONT></B> <INPUT name=\"botVentanilla\" type=\"button\"\n\t\t\t\t\tonclick=\"AbrirV('FrameVentanilla.jsp?idArea=&ida=&num=1');\"\n\t\t\t\t\tclass=\"s-dropdown-btn\"></TD>\n\t\t\t\t<TD colspan=\"3\">".toCharArray();
    __oracle_jsp_text[38] = 
    "</TD>\n\t\t\t</TR>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"360\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t</TBODY>\n\t</TABLE>\n\t</DIV>\n\t<br>\n\t<DIV align=\"center\">\n\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t<TBODY>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\t\t\tface=\"Arial\">Destinatarios</font></b></td>\n\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"363\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\t\tsrc=\"./Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t</TBODY>\n\t</TABLE>\n\t</DIV>\n\t<br>\n\t<DIV align=\"center\">\n\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t<TBODY>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"183\"><B><FONT face=\"Arial\" color=\"#004080\"\n\t\t\t\t\tsize=\"2\">Destinatarios Internos<BR>\n\t\t\t\tde la SHCP :</FONT></B> <INPUT type=\"button\"\n\t\t\t\t\tonclick=\"document.Asunto.strBandera.value=true;Abrir('', '', '', '' );\"\n\t\t\t\t\tclass=\"s-dropdown-btn\"></TD>\n\t\t\t\t<TD colspan=\"3\"></TD>\n\t\t\t</TR>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"183\"><B><FONT face=\"Arial\" color=\"#004080\"\n\t\t\t\t\tsize=\"2\">Para:</FONT></B></TD>\n\t\t\t\t<TD colspan=\"3\"><FONT face=\"Arial\" size=\"2\"> <SELECT\n\t\t\t\t\tname=\"listTO\" size=\"6\" class=\"blue600a\" multiple=\"multiple\">\n\n\t\t\t\t</SELECT> </FONT></TD>\n\t\t\t</TR>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Ccp:</FONT>\n\t\t\t\t</TD>\n\t\t\t\t<TD colspan=\"3\"><FONT face=\"Arial\" size=\"2\"> <SELECT\n\t\t\t\t\tname=\"listCC\" size=\"6\" class=\"blue600a\" multiple=\"multiple\">\n\t\t\t\t</SELECT> </FONT></TD>\n\t\t\t</TR>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Destinatarios\n\t\t\t\tExternos:</FONT> <INPUT type=\"button\"\n\t\t\t\t\tonclick=\"document.Asunto.strBandera.value=true;AbrirDest('');\"\n\t\t\t\t\tclass=\"s-dropdown-btn\"></TD>\n\t\t\t\t<TD colspan=\"3\"></TD>\n\t\t\t</TR>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Para:</FONT>\n\t\t\t\t</TD>\n\t\t\t\t<TD colspan=\"3\"><FONT face=\"Arial\" size=\"2\"> <SELECT\n\t\t\t\t\tname=\"listTOE\" size=\"6\" class=\"blue600a\" multiple=\"multiple\">\n\t\t\t\t</SELECT> </FONT></TD>\n\t\t\t</TR>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t</TBODY>\n\t</TABLE>\n\t</DIV>\n\t<br>\n\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n".toCharArray();
    __oracle_jsp_text[40] = 
    "\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
