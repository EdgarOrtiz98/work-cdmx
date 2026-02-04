package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.util.Estatus;
import java.util.Date;
import com.meve.util.DateFormatter;
import com.meve.sigma.graficas.Graficas;
import com.meve.sigma.reporte.ReporteUtil;


public class _reporteInstruccion extends com.orionserver.http.OrionHttpJspPage {


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
    _reporteInstruccion page = this;
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
      com.meve.sigma.beans.UsuarioBean UsuarioBean;
      synchronized (session) {
        if ((UsuarioBean = (com.meve.sigma.beans.UsuarioBean) pageContext.getAttribute( "UsuarioBean", PageContext.SESSION_SCOPE)) == null) {
          UsuarioBean = (com.meve.sigma.beans.UsuarioBean) new com.meve.sigma.beans.UsuarioBean();
          pageContext.setAttribute( "UsuarioBean", UsuarioBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[9]);
      com.meve.sigma.reporte.ReporteForm reporteForm;
      synchronized (session) {
        if ((reporteForm = (com.meve.sigma.reporte.ReporteForm) pageContext.getAttribute( "reporteForm", PageContext.SESSION_SCOPE)) == null) {
          reporteForm = (com.meve.sigma.reporte.ReporteForm) new com.meve.sigma.reporte.ReporteForm();
          pageContext.setAttribute( "reporteForm", reporteForm, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[10]);
      out.write(__oracle_jsp_text[11]);
      out.print(reporteForm.getSubordinadosToString());
      out.write(__oracle_jsp_text[12]);
      
       if (tableManager != null && tableManager.getTotalRegistros() != 0) {
       
      out.write(__oracle_jsp_text[13]);
      
       }
       
      out.write(__oracle_jsp_text[14]);
      {
        org.apache.struts.taglib.html.TextTag __jsp_taghandler_1=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag property");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setProperty("fechaInicial");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[15]);
      {
        org.apache.struts.taglib.html.TextTag __jsp_taghandler_2=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag property");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setProperty("fechaFinal");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[16]);
      out.print(String.valueOf(Estatus.INS_POR_ATENDER));
      out.write(__oracle_jsp_text[17]);
      out.print(reporteForm.getEstatusChecks(Estatus.INS_POR_ATENDER));
      out.write(__oracle_jsp_text[18]);
      out.print(String.valueOf(Estatus.INS_EN_TRAMITE));
      out.write(__oracle_jsp_text[19]);
      out.print(reporteForm.getEstatusChecks(Estatus.INS_EN_TRAMITE));
      out.write(__oracle_jsp_text[20]);
      out.print(String.valueOf(Estatus.INS_TERMINADA));
      out.write(__oracle_jsp_text[21]);
      out.print(reporteForm.getEstatusChecks(Estatus.INS_TERMINADA));
      out.write(__oracle_jsp_text[22]);
      out.print(String.valueOf(Estatus.INS_RECHAZADA));
      out.write(__oracle_jsp_text[23]);
      out.print(reporteForm.getEstatusChecks(Estatus.INS_RECHAZADA));
      out.write(__oracle_jsp_text[24]);
      out.print(reporteForm.getSubordinadosCheck());
      out.write(__oracle_jsp_text[25]);
      if (reporteForm.isMuestraSubordinados()) {
      out.write(__oracle_jsp_text[26]);
      } else {
      out.write(__oracle_jsp_text[27]);
      }
      out.write(__oracle_jsp_text[28]);
      out.print(ReporteUtil.getSubordinadosHTML(request,Integer
									.parseInt(UsuarioBean.getIdUsuario()),
									reporteForm));
      out.write(__oracle_jsp_text[29]);
      {
        org.apache.struts.taglib.html.RadioTag __jsp_taghandler_3=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag property value");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setProperty("totales");
        __jsp_taghandler_3.setValue("false");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[30]);
      {
        org.apache.struts.taglib.html.RadioTag __jsp_taghandler_4=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag property value");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setProperty("totales");
        __jsp_taghandler_4.setValue("true");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[31]);
      {
        org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_5=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag parameter value");
        __jsp_taghandler_5.setParent(null);
        __jsp_taghandler_5.setParameter("totales");
        __jsp_taghandler_5.setValue("true");
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[32]);
            {
              String __url=OracleJspRuntime.toStr("tablaInstruccionesTotales.jsp");
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[33]);
          } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[34]);
      {
        org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_6=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag parameter value");
        __jsp_taghandler_6.setParent(null);
        __jsp_taghandler_6.setParameter("totales");
        __jsp_taghandler_6.setValue("false");
        __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[35]);
            {
              String __url=OracleJspRuntime.toStr("tablaInstrucciones.jsp");
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[36]);
          } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,1);
      }
      out.write(__oracle_jsp_text[37]);

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
  private static final char __oracle_jsp_text[][]=new char[38][];
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
    "\n\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n<HTML>\n\n<BODY background=\"./Imagenes/fondo_claro.jpg\" onload=\"verificarCheck(".toCharArray();
    __oracle_jsp_text[12] = 
    ",'subordinados');return false;\">\n\n\n<table align=\"center\" width=\"900\">\n\t<tr>\n\t\t<td>\n\t\t<h2>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <font\n\t\t\tcolor=\"#2121ff\" face=\"Arial\"> <strong><em>Reporte\n\t\tInstrucci&oacute;n</em></strong> </font></h2>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td align=\"left\"><a\n\t\t\tonclick=\"submitForm(document.reporteForm,'buscaInstrucciones','');\">\n\t\t<img src=\"Imagenes/buscarCat.gif\" alt=\"Genera Reporte\"></a> ".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t<a href=\"GeneraReporte\"> <img src=\"Imagenes/ic_excel.gif\"\n\t\t\tborder=\"0\" alt=\"Genera Reporte\"> </a> ".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t<TABLE border=\"0\" width=\"100%\" align=\"center\">\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t\t\t\t<TBODY>\n\t\t\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\t\t\t\t\t\tface=\"Arial\">Rango de Fechas</font></b></td>\n\t\t\t\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t\t\t\t<td width=\"380\"></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t\t\t<td width=\"847\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\t\t\t\t\tsrc=\"./Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</TBODY>\n\t\t\t\t</TABLE>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>&nbsp;\n\t\t\t\t<TABLE width=\"70%\" border=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"40\">&nbsp;</td>\n\t\t\t\t\t\t<td>Del</td>\n\t\t\t\t\t\t<td>".toCharArray();
    __oracle_jsp_text[15] = 
    "<a\n\t\t\t\t\t\t\tid=\"btnFechaInicial\"><IMG height=\"20\"\n\t\t\t\t\t\t\tsrc=\"Imagenes/act_calFormat.gif\" width=\"20\"\n\t\t\t\t\t\t\tonmouseover=\"obtenCalendario('fechaInicial','btnFechaInicial');return false;\" /></a></td>\n\t\t\t\t\t\t<td width=\"50\">al</td>\n\t\t\t\t\t\t<td width=\"300\">".toCharArray();
    __oracle_jsp_text[16] = 
    "<a\n\t\t\t\t\t\t\tid=\"btnFechaFinal\"><IMG height=\"20\"\n\t\t\t\t\t\t\tsrc=\"Imagenes/act_calFormat.gif\" width=\"20\"\n\t\t\t\t\t\t\tonmouseover=\"obtenCalendario('fechaFinal','btnFechaFinal');return false;\"></a></td>\n\n\t\t\t\t\t</tr>\n\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t<TABLE border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td>&nbsp;\n\t\t\t\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\t\t\t\t\tface=\"Arial\">Estatus</font></b></td>\n\t\t\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t\t\t<td width=\"380\"></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t\t<td width=\"847\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\t\t\t\tsrc=\"./Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</TABLE>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>&nbsp;\n\t\t\t\t<TABLE width=\"90%\" align=\"center\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td><input type=\"checkbox\" name=\"estatus\" \n\t\t\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\"\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    " />Por\n\t\t\t\t\t\tAtender</td>\n\t\t\t\t\t\t<td>&nbsp;&nbsp;<input type=\"checkbox\" name=\"estatus\"\n\t\t\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\"\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    " />En\n\t\t\t\t\t\ttr&aacute;mite</td>\n\t\t\t\t\t\t<td>&nbsp;&nbsp;<input type=\"checkbox\" name=\"estatus\"\n\t\t\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\"\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    " />Terminada</td>\n\t\t\t\t\t\t<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input\n\t\t\t\t\t\t\ttype=\"checkbox\" name=\"estatus\"\n\t\t\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\"\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    " />Rechazadas</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t<DIV >\n\t\t<TABLE border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" >\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t<TABLE cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t<TBODY>\n\t\t\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\t\t\t\t\t\tface=\"Arial\">Subordinados</font></b> <input type=\"checkbox\"\n\t\t\t\t\t\t\t\tname=\"muestraSubordinados\"\n\t\t\t\t\t\t\t\tonclick=\"muestraOcultaDIV('subordinados');\"\n\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    " /></td>\n\t\t\t\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t\t\t\t<td width=\"380\"></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t\t\t<td width=\"847\" bgcolor=\"#004080\" colspan=\"5\"><img\n\t\t\t\t\t\t\t\tsrc=\"./Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</TBODY>\n\t\t\t\t</TABLE>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>&nbsp; \n\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t<div style=\"display: block\" id=\"subordinados\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t<div style=\"display: none\" id=\"subordinados\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    " \n\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</DIV>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t<TABLE border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t\t\t\t<TBODY>\n\t\t\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\t\t\t\t\t\tface=\"Arial\">Tipo de Reporte</font></b></td>\n\t\t\t\t\t\t\t<td width=\"233\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t\t\t\t<td width=\"67\"><img src=\"./Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t\t\t\t<td width=\"380\"></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t\t\t<td width=\"847\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\t\t\t\t\tsrc=\"./Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</TBODY>\n\t\t\t\t</TABLE>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>&nbsp;\n\t\t\t\t<TABLE width=\"200\" border=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"40\">&nbsp;</td>\n\t\t\t\t\t\t<td>".toCharArray();
    __oracle_jsp_text[30] = 
    "Detalle</td>\n\t\t\t\t\t\t<td>".toCharArray();
    __oracle_jsp_text[31] = 
    "Totales</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n\n</table>\n".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n".toCharArray();
    __oracle_jsp_text[34] = 
    "\n".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n".toCharArray();
    __oracle_jsp_text[37] = 
    "\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
