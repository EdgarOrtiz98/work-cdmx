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


public class _remitentes extends com.orionserver.http.OrionHttpJspPage {


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
    _remitentes page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      java.util.List remitentes;
      synchronized (session) {
        if ((remitentes = (java.util.List) pageContext.getAttribute( "remitentes", PageContext.SESSION_SCOPE)) == null) {
          remitentes = (java.util.List) new java.util.ArrayList();
          pageContext.setAttribute( "remitentes", remitentes, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[5]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("remitente.siga");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[6]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_2=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property styleClass");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setMaxlength("199");
              __jsp_taghandler_2.setProperty("cadenaBusqueda");
              __jsp_taghandler_2.setStyleClass("blue200");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[7]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_3=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property styleClass");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setMaxlength("199");
              __jsp_taghandler_3.setProperty("segundaCadenaBusqueda");
              __jsp_taghandler_3.setStyleClass("blue200");
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[8]);
             if(remitentes.size()!=0){ 
            out.write(__oracle_jsp_text[9]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_4=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name type");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setId("registro");
              __jsp_taghandler_4.setIndexId("contador");
              __jsp_taghandler_4.setName("remitentes");
              __jsp_taghandler_4.setType("com.meve.sigma.beans.UsuarioBean");
              com.meve.sigma.beans.UsuarioBean registro = null;
              java.lang.Integer contador = null;
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_4,__jsp_tag_starteval,out);
                do {
                  registro = (com.meve.sigma.beans.UsuarioBean) pageContext.findAttribute("registro");
                  contador = (java.lang.Integer) pageContext.findAttribute("contador");
                  out.write(__oracle_jsp_text[10]);
                  {
                    org.apache.struts.taglib.html.RadioTag __jsp_taghandler_5=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag property value");
                    __jsp_taghandler_5.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_5.setProperty("idRemitente");
                    __jsp_taghandler_5.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.strIdUsuario}",java.lang.String.class, __ojsp_varRes,null));
                    __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                    if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,3);
                  }
                  out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.strCargo}",java.lang.String.class, __ojsp_varRes, null));
                  out.write(__oracle_jsp_text[11]);
                  out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.strNombre}",java.lang.String.class, __ojsp_varRes, null));
                  out.write(__oracle_jsp_text[12]);
                } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[13]);
             } else { 
            out.write(__oracle_jsp_text[14]);
            }
            out.write(__oracle_jsp_text[15]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[16]);

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
  private static final char __oracle_jsp_text[][]=new char[17][];
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
    "\n\n\n\n\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"./theme/Master.css\" rel=\"stylesheet\"type=\"text/css\">\n<LINK href=\"./css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Remitente</TITLE>\n<SCRIPT src=\"./js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"./js/valida.js\" type=text/javascript></SCRIPT>\n<script type=\"text/javascript\" src=\"./js/SigaJS.js\"></script>\n<script type=\"text/javascript\" src=\"./js/ventana/ventanas.js\"></script>\n<script type=\"text/javascript\" src=\"./js/ventana/controladorDeContenido.js\"></script>\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n</HEAD>\n<BODY background=\"./Imagenes/fondo_claro.jpg\">\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<INPUT type=\"hidden\" name=\"accion\" value=\"remitentes\">\n<INPUT type=\"hidden\" name=\"idLink\" value=\"\" >\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"367\" class=\"etiquetas\"> \n\t\t\t<div align=\"left\">\n\t\t\t\tPuesto:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[7] = 
    "<BR>\n\t\t\t\tResponsable:&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[8] = 
    "<BR>\n\t\t\t\tBuscar:&nbsp;<A title=\"Buscar\" onclick=\"submitForm(document.remitenteForm,'remitentes','cargaRemitentes'); return false;\"><IMG border=\"0\" src=\"./Imagenes/ico_bus.gif\" width=\"26\" height=\"26\" ></A><br>\n\t\t\t</div>\n\t\t</td>\n\t\t<td width=\"10\">\n\t\t\t<div align=\"right\">\n\t\t\t</div>\n\t\t</td>\n\t\t<td width=\"\">\n\t\t\t&nbsp;\n\t\t</td>\n\t\t<td width=\"500\">\n\t\t\t<DIV align=\"right\">\n\t\t\t\t<input type=\"button\" value=\"Otro Remitente...\" class=\"blue200a\" onclick=\"submitForm(document.remitenteForm,'remitentes','nuevoRemitente'); return false;\">\n\t\t\t\t<input type=\"button\" value=\"Aceptar\" class=\"blue100a\" onclick=\"submitForm(document.remitenteForm,'remitentes','guardaRemitente'); return false;\">\n\t\t\t\t<input type=\"button\" value=\"Cancelar\" class=\"blue100a\" onclick=\"cierraVentana('ventana');return false;\">\n\t\t\t</DIV>\n\t\t</td>\n\t</tr>\n</table>\n<BR>\n<div align=\"left\">\n</div>\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\">\n\t\t\t<b><font size=\"2\" color=\"#00204F\" face=\"Verdana\">Remitentes</font></b>\n\t\t\t<b><font size=\"2\" color=\"#00204F\" face=\"Verdana\">de la Unidad</font></b>\n\t\t</td>\n\t</tr>\n</table>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='50%' align=\"center\">\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"verdana\"><b>Puesto</b></font>\n\t\t</TD>\n\t\t<TD WIDTH='50%' align=\"center\">\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"verdana\"><b>Responsable</b></font>\n\t\t</TD>\n\t</TR>\t\n</TABLE>\n<DIV class=documentBody id=Body>\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<TABLE width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t<tr>\n\t\t\t\t<td width=\"80%\">\n\t\t\t\t    ".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\t    </td>\n\t\t\t\t<td width=\"20%\" align=\"center\">\n\t\t\t\t ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t\t </td>\n\t\t\t</tr>\n\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n<CENTER>\n<table cellspacing=\"2\" cellpadding=\"2\">\n\t<tr>\n\t\t<TD align=\"center\">\n\t\t\t<DIV align=\"center\">\n\t\t\t\t<p><FONT size=\"4\" face=\"Verdana\">***** No se han encontrado\n\t\tDocumentos ***** </FONT></DIV>\n\t\t</TD>\n\t</tr>\n</table>\n</CENTER>\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n<BR>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
