package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.organizacional.vo.PuestoVO;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import java.util.ArrayList;
import java.util.*;
import com.meve.sigma.util.*;


public class _puesto extends com.orionserver.http.OrionHttpJspPage {


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
    _puesto page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      {
        String __url=OracleJspRuntime.toStr("headerSIGA.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
      
      			UsuarioBean BUsuario = (UsuarioBean) session
      			.getAttribute("UsuarioBean");
      	String strTmp = request.getRequestURI();
      	strTmp = strTmp.substring(strTmp.indexOf('/', 2) + 5, strTmp
      			.length());
      	if (BUsuario == null) {
      		try {
      			response.sendRedirect("index.jsp?pagina=" + strTmp);
      		} catch (java.io.IOException io) {
      			;
      		}
      	}
      
      out.write(__oracle_jsp_text[7]);
      com.meve.sigma.organizacional.vo.AreaVO area;
      synchronized (session) {
        if ((area = (com.meve.sigma.organizacional.vo.AreaVO) pageContext.getAttribute( "area", PageContext.SESSION_SCOPE)) == null) {
          area = (com.meve.sigma.organizacional.vo.AreaVO) new com.meve.sigma.organizacional.vo.AreaVO();
          pageContext.setAttribute( "area", area, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[8]);
      com.meve.sigma.organizacional.puesto.PuestoForm puestoForm;
      synchronized (session) {
        if ((puestoForm = (com.meve.sigma.organizacional.puesto.PuestoForm) pageContext.getAttribute( "puestoForm", PageContext.SESSION_SCOPE)) == null) {
          puestoForm = (com.meve.sigma.organizacional.puesto.PuestoForm) new com.meve.sigma.organizacional.puesto.PuestoForm();
          pageContext.setAttribute( "puestoForm", puestoForm, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[9]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("puesto");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[10]);
            if (BUsuario.getAdmon() || BUsuario.getSupervisor()) {
            out.write(__oracle_jsp_text[11]);
            
             }
             
            out.write(__oracle_jsp_text[12]);
            out.print("");
            out.write(__oracle_jsp_text[13]);
            out.print(Utilerias.codificaPostHTML(strTmp+"?id="+""+"&area="+""+"&retURI="+ Utilerias.codificaPostHTML("")));
            out.write(__oracle_jsp_text[14]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${puestoForm.puesto}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[15]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${puestoForm.responsable}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[16]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_2=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name property type");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setId("registro");
              __jsp_taghandler_2.setName("puestoForm");
              __jsp_taghandler_2.setProperty("roles");
              __jsp_taghandler_2.setType("com.meve.sigma.catalogos.CatalogoRol");
              com.meve.sigma.catalogos.CatalogoRol registro = null;
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_2,__jsp_tag_starteval,out);
                do {
                  registro = (com.meve.sigma.catalogos.CatalogoRol) pageContext.findAttribute("registro");
                  out.write(__oracle_jsp_text[17]);
                  out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.nombre}",java.lang.String.class, __ojsp_varRes, null));
                  out.write(__oracle_jsp_text[18]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[19]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${puestoForm.unidadAdministrativa}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[20]);
            out.print(Converters.convertElementToString(area.getCadenaMando(puestoForm.getIdPuesto()).getHTML(null)));
            out.write(__oracle_jsp_text[21]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_3=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name property type");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setId("subordinado");
              __jsp_taghandler_3.setName("puestoForm");
              __jsp_taghandler_3.setProperty("subordinados");
              __jsp_taghandler_3.setType("com.meve.sigma.organizacional.vo.PuestoVO");
              com.meve.sigma.organizacional.vo.PuestoVO subordinado = null;
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_3,__jsp_tag_starteval,out);
                do {
                  subordinado = (com.meve.sigma.organizacional.vo.PuestoVO) pageContext.findAttribute("subordinado");
                  out.write(__oracle_jsp_text[22]);
                  out.print(Converters.convertElementToString(subordinado.getHTML(null)));
                  out.write(__oracle_jsp_text[23]);
                } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[24]);
            {
              org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_4=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setName("puestoForm");
              __jsp_taghandler_4.setProperty("subordinados");
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[25]);
                } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[26]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_5=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name property type");
              __jsp_taghandler_5.setParent(__jsp_taghandler_1);
              __jsp_taghandler_5.setId("asistente");
              __jsp_taghandler_5.setName("puestoForm");
              __jsp_taghandler_5.setProperty("asistentes");
              __jsp_taghandler_5.setType("com.meve.sigma.organizacional.vo.AsistenteVO");
              com.meve.sigma.organizacional.vo.AsistenteVO asistente = null;
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_5,__jsp_tag_starteval,out);
                do {
                  asistente = (com.meve.sigma.organizacional.vo.AsistenteVO) pageContext.findAttribute("asistente");
                  out.write(__oracle_jsp_text[27]);
                  out.print(Converters.convertElementToString(asistente.getHTML(null)));
                  out.write(__oracle_jsp_text[28]);
                } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[29]);
            {
              org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_6=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
              __jsp_taghandler_6.setParent(__jsp_taghandler_1);
              __jsp_taghandler_6.setName("puestoForm");
              __jsp_taghandler_6.setProperty("asistentes");
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[30]);
                } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[31]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_7=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name property type");
              __jsp_taghandler_7.setParent(__jsp_taghandler_1);
              __jsp_taghandler_7.setId("companiero");
              __jsp_taghandler_7.setName("puestoForm");
              __jsp_taghandler_7.setProperty("companieros");
              __jsp_taghandler_7.setType("com.meve.sigma.organizacional.vo.PuestoVO");
              com.meve.sigma.organizacional.vo.PuestoVO companiero = null;
              __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_7,__jsp_tag_starteval,out);
                do {
                  companiero = (com.meve.sigma.organizacional.vo.PuestoVO) pageContext.findAttribute("companiero");
                  out.write(__oracle_jsp_text[32]);
                  out.print(Converters.convertElementToString(companiero.getHTML(null)));
                  out.write(__oracle_jsp_text[33]);
                } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,2);
            }
            out.write(__oracle_jsp_text[34]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[35]);

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
  private static final char __oracle_jsp_text[][]=new char[36][];
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
    "\n<HTML>\n<HEAD>\n<TITLE>Puestos</TITLE>\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"./theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/link.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<STYLE type=text/css>\nBODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY>\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t<input type=\"hidden\" value=\"\" name=\"accion\" />\n\t<input type=\"hidden\" value=\"\" name=\"idLink\" />\n\t<DIV align=\"center\">\n\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"70%\">\n\t\t<TBODY>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"500\"><A onclick=\"submitForm(puestoForm,'regresar','')\"> <IMG\n\t\t\t\t\tborder=\"0\" src=\"./Imagenes/NavLeft.gif\" alt=\"Regresar\"></A> \n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    " \n                   <A href=\"javascript:;\" target=\"_self\"> \n                      <IMG border=\"0\" src=\"./Imagenes/nuevo1.gif\" alt=\"Nuevo Puesto\"/>\n\t\t\t\t   <A href=\"javascript:;\"target=\"_self\" onclick=\"submitForm(puestoForm,'modificarPuesto','mostrar');return false;\"> \n\t\t\t\t      <IMG border=\"0\" src=\"./Imagenes/Edit2.gif\" alt=\"Editar Puesto\">\n\t\t\t\t   </A> \n\t\t\t\t   <A onclick=\"borrarUsuario();\" target=\"_self\"> \n\t\t\t\t\t   <IMG border=\"0\" src=\"./Imagenes/borrar1.gif\" alt=\"Borrar Puesto\"/>\n\t\t\t\t   </A> ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t\t</TD>\n\t\t\t\t<TD width=\"3\"></TD>\n\t\t\t\t<TD width=\"200\" align=\"right\" valign=\"middle\"><a\n\t\t\t\t\thref=\"Bitacora.jsp?id_usuario=".toCharArray();
    __oracle_jsp_text[13] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[14] = 
    "\">\n\t\t\t\t<u><FONT SIZE=2 FACE=\"Verdana\">botácora del Usuario</FONT></u> </a></TD>\n\t\t\t</TR>\n\t\t</TBODY>\n\t</TABLE>\n\t</DIV>\n\t<BR>\n\t<DIV align=\"center\">\n\t<TABLE border=\"0\" width=\"70%\">\n\t\t<tr bgcolor=\"#004080\">\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\"><B>Puesto</B>\n\t\t\t</TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "</TD>\n\t\t</tr>\n\t\t<tr bgcolor=\"#004080\">\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\"><B>Responsable</B>\n\t\t\t</TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "</TD>\n\t\t</tr>\n\t\t<tr bgcolor=\"#004080\">\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\"><B>Roles\n\t\t\tdel Usuario</B></TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t<UL>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n                 ".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t</UL>\n\t\t\t</TD>\n\t\t</tr>\n\t\t<tr bgcolor=\"#004080\">\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\"><B>Unidad\n\t\t\tAdministrativa</B></TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "</TD>\n\t\t</tr>\n\t\t<tr bgcolor=\"#004080\">\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\"><B>Cadena\n\t\t\tde Mando</B></TD>\n\t\t</tr>\n\t\t<tr align=\"left\">\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t</TD>\n\t\t<tr>\n\t\t<tr bgcolor=\"#004080\">\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\"><B>Subalternos</B>\n\t\t\t</TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n         \t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    " \n\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t   **No tiene Subalternos asignados**\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t</TD>\n\t\t</tr>\n\t\t<tr bgcolor=\"#004080\">\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\"><B>Asistente</B>\n\t\t\t</TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t<DL><DT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t**No tiene Asistentes asignados**\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t</DT></DL>\n\t\t\t</td>\n\n\t\t</tr>\n\t\t<tr bgcolor=\"#004080\">\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\"><B>Compañeros\n\t\t\tde la Unidad</B></TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t<DL><DT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t</DT></DL>\n\t\t\t</TD>\n\t\t</tr>\n\t</TABLE>\n\t</DIV>\n".toCharArray();
    __oracle_jsp_text[35] = 
    "\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
