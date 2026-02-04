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


public class _reporteAsunto extends com.orionserver.http.OrionHttpJspPage {


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
    _reporteAsunto page = this;
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
      com.meve.sigma.reporte.ReporteForm reporteForm;
      synchronized (session) {
        if ((reporteForm = (com.meve.sigma.reporte.ReporteForm) pageContext.getAttribute( "reporteForm", PageContext.SESSION_SCOPE)) == null) {
          reporteForm = (com.meve.sigma.reporte.ReporteForm) new com.meve.sigma.reporte.ReporteForm();
          pageContext.setAttribute( "reporteForm", reporteForm, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[9]);
      if(tableManager!=null&& tableManager.getTotalRegistros()!= 0){ 
      out.write(__oracle_jsp_text[10]);
      }
      out.write(__oracle_jsp_text[11]);
      {
        org.apache.struts.taglib.html.TextTag __jsp_taghandler_1=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag onchange property");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setOnchange("validaRangoFechas(forms[0].fechaInicial,forms[0].fechaFinal,'verifique');return false;");
        __jsp_taghandler_1.setProperty("fechaInicial");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[12]);
      {
        org.apache.struts.taglib.html.TextTag __jsp_taghandler_2=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag onchange property");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setOnchange("validaRangoFechas(forms[0].fechaInicial,forms[0].fechaFinal,'verifique');return false;");
        __jsp_taghandler_2.setProperty("fechaFinal");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[13]);
      {
        org.apache.struts.taglib.html.SelectTag __jsp_taghandler_3=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag property styleClass size");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setProperty("tipoFecha");
        __jsp_taghandler_3.setStyleClass("blue250");
        __jsp_taghandler_3.setSize("1");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_3,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[14]);
            out.print(reporteForm.getComboSelected(1));
            out.write(__oracle_jsp_text[15]);
            out.print(reporteForm.getComboSelected(2));
            out.write(__oracle_jsp_text[16]);
            out.print(reporteForm.getComboSelected(3));
            out.write(__oracle_jsp_text[17]);
          } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[18]);
      out.print(String.valueOf(Estatus.ASU_EN_RECEPCION));
      out.write(__oracle_jsp_text[19]);
      out.print(reporteForm.getEstatusChecks(Estatus.ASU_EN_RECEPCION));
      out.write(__oracle_jsp_text[20]);
      out.print(String.valueOf(Estatus.ASU_POR_TURNAR));
      out.write(__oracle_jsp_text[21]);
      out.print(reporteForm.getEstatusChecks(Estatus.ASU_POR_TURNAR));
      out.write(__oracle_jsp_text[22]);
      out.print(String.valueOf(Estatus.ASU_TURNADO));
      out.write(__oracle_jsp_text[23]);
      out.print(reporteForm.getEstatusChecks(Estatus.ASU_TURNADO));
      out.write(__oracle_jsp_text[24]);
      out.print(String.valueOf(Estatus.ASU_TERMINADO));
      out.write(__oracle_jsp_text[25]);
      out.print(reporteForm.getEstatusChecks(Estatus.ASU_TERMINADO));
      out.write(__oracle_jsp_text[26]);
      out.print(reporteForm.getOtrasVentanillasCheck());
      out.write(__oracle_jsp_text[27]);
      if(reporteForm.isOtrasVentanillas()){
      out.write(__oracle_jsp_text[28]);
      }else{
      out.write(__oracle_jsp_text[29]);
      } 
      out.write(__oracle_jsp_text[30]);
      out.print(String.valueOf(Estatus.OV_POR_TURNAR));
      out.write(__oracle_jsp_text[31]);
      out.print(reporteForm.getEstatusOVChecks(Estatus.OV_POR_TURNAR) );
      out.write(__oracle_jsp_text[32]);
      out.print(String.valueOf(Estatus.OV_TURNADA));
      out.write(__oracle_jsp_text[33]);
      out.print(reporteForm.getEstatusOVChecks(Estatus.OV_TURNADA) );
      out.write(__oracle_jsp_text[34]);
      out.print(String.valueOf(Estatus.OV_TERMINADA));
      out.write(__oracle_jsp_text[35]);
      out.print(reporteForm.getEstatusOVChecks(Estatus.OV_TERMINADA) );
      out.write(__oracle_jsp_text[36]);
      {
        org.apache.struts.taglib.html.RadioTag __jsp_taghandler_4=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag property value");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setProperty("totales");
        __jsp_taghandler_4.setValue("false");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[37]);
      {
        org.apache.struts.taglib.html.RadioTag __jsp_taghandler_5=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag property value");
        __jsp_taghandler_5.setParent(null);
        __jsp_taghandler_5.setProperty("totales");
        __jsp_taghandler_5.setValue("true");
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[38]);
      {
        org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_6=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag parameter value");
        __jsp_taghandler_6.setParent(null);
        __jsp_taghandler_6.setParameter("totales");
        __jsp_taghandler_6.setValue("true");
        __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[39]);
            {
              String __url=OracleJspRuntime.toStr("tablaAsuntosTotales.jsp");
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[40]);
          } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,1);
      }
      out.write(__oracle_jsp_text[41]);
      {
        org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_7=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag parameter value");
        __jsp_taghandler_7.setParent(null);
        __jsp_taghandler_7.setParameter("totales");
        __jsp_taghandler_7.setValue("false");
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[42]);
            {
              String __url=OracleJspRuntime.toStr("tablaAsuntos.jsp");
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[43]);
          } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      out.write(__oracle_jsp_text[44]);

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
  private static final char __oracle_jsp_text[][]=new char[45][];
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
    "\n<HTML>\n\n<BODY background=\"./Imagenes/fondo_claro.jpg\">\n\n\n<table align=\"center\" width=\"900\">\n\t<tr>\n\t\t<td>\n\t\t<h2>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <font\n\t\t\tcolor=\"#2121ff\" face=\"Arial\"> <strong><em>Reporte\n\t\t Asunto</em></strong> </font></h2>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td align=\"left\"><a\n\t\t\tonclick=\"submitForm(document.reporteForm,'buscaAsuntos','');\"> <img\n\t\t\tsrc=\"Imagenes/buscarCat.gif\" alt=\"Genera Reporte\"></a> \n\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t<a href=\"GeneraReporte\"><img src=\"Imagenes/ic_excel.gif\"\n\t\t\tborder=\"0\" alt=\"Genera Reporte\"></a> ".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t<TABLE border=\"0\" width=\"100%\" align=\"center\">\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n\t\t\t\t\t<TBODY>\n\t\t\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t\t\t<td ><b><font size=\"2\" color=\"#004080\"\n\t\t\t\t\t\t\t\tface=\"Arial\">Rango de Fechas</font></b></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t\t\t<td width=\"100%\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\t\t\t\t\tsrc=\"./Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</TBODY>\n\t\t\t\t</TABLE>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>&nbsp;\n\t\t\t\t<TABLE width=\"95%\" border=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"40\">&nbsp;</td>\n\t\t\t\t\t\t<td>Del</td>\n\t\t\t\t\t\t<td>".toCharArray();
    __oracle_jsp_text[12] = 
    "<a\n\t\t\t\t\t\t\tid=\"btnFechaInicial\"><IMG height=\"20\"\n\t\t\t\t\t\t\tsrc=\"Imagenes/act_calFormat.gif\" width=\"20\" \n\t\t\t\t\t\t\tonmouseover=\"obtenCalendario('fechaInicial','btnFechaInicial');return false;\" /></a></td>\n\t\t\t\t\t\t<td width=\"50\" align=\"center\">al</td>\n\t\t\t\t\t\t<td width=\"300\">".toCharArray();
    __oracle_jsp_text[13] = 
    "<a\n\t\t\t\t\t\t\tid=\"btnFechaFinal\"><IMG height=\"20\"\n\t\t\t\t\t\t\tsrc=\"Imagenes/act_calFormat.gif\" width=\"20\" \n\t\t\t\t\t\t\tonmouseover=\"obtenCalendario('fechaFinal','btnFechaFinal');return false;\"></a></td>\n\t\t\t\t\t\t<td width=\"100\">Filtrado por:</td>\n\t\t\t\t\t\t<td width=\"200\">".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t\t\t\t\t<option value=\"1\" ".toCharArray();
    __oracle_jsp_text[15] = 
    ">Fecha de Captura</option>\n\t\t\t\t\t\t\t<option value=\"2\" ".toCharArray();
    __oracle_jsp_text[16] = 
    ">Fecha de Recepcion</option>\n\t\t\t\t\t\t\t<option value=\"3\" ".toCharArray();
    __oracle_jsp_text[17] = 
    ">Fecha del Documento</option>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "</td>\n\t\t\t\t\t</tr>\n\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t<TABLE border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td>&nbsp;\n\t\t\t\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n\t\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t\t<td width=\"100%\"><b><font size=\"2\" color=\"#004080\"\n\t\t\t\t\t\t\tface=\"Arial\">Estatus de Mis Asuntos y Asuntos de la Ventanilla</font></b></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr valign=\"top\" >\n\t\t\t\t\t\t<td width=\"100%\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\t\t\t\tsrc=\"./Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</TABLE>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>&nbsp;\n\t\t\t\t<TABLE width=\"90%\" align=\"center\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"25%\"><input type=\"checkbox\" name=\"estatus\" \n\t\t\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" \n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "/>Recepci&oacute;n\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"25%\">&nbsp;&nbsp;<input type=\"checkbox\" name=\"estatus\"\n\t\t\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\" \n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "/>Por Turnar</td>\n\t\t\t\t\t\t<td width=\"25%\">&nbsp;&nbsp;<input type=\"checkbox\" name=\"estatus\"\n\t\t\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\" \n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "/>En Tr&aacute;mite</td>\n\t\t\t\t\t\t<td width=\"25%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input\n\t\t\t\t\t\t\ttype=\"checkbox\" name=\"estatus\" \n\t\t\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[25] = 
    "\" \n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "/>Terminado</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t<TABLE border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\n\t\t\t\t\t<TBODY>\n\t\t\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t\t\t<td><b><font size=\"2\" color=\"#004080\"\n\t\t\t\t\t\t\t\tface=\"Arial\">Estatus de Otras Ventanillas</font></b> <input type=\"checkbox\"\n\t\t\t\t\t\t\t\tname=\"otrasVentanillas\" \n\t\t\t\t\t\t\t\tonclick=\"muestraOcultaDIV('estatusOV');\" \n\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t\t\t\t\t/></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t\t\t<td width=\"100%\" bgcolor=\"#004080\" colspan=\"5\"><img\n\t\t\t\t\t\t\t\tsrc=\"./Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</TBODY>\n\t\t\t\t</TABLE>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t\t<div style=\"display: block;\" id=\"estatusOV\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t<div style=\"display: none;\" id=\"estatusOV\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t<TABLE width=\"90%\" align=\"center\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t    <td width=\"25%\">&nbsp;</td>\n\t\t\t\t\t\t<td width=\"25%\"><input type=\"checkbox\" name=\"estatusOtrasVentanillas\"\n\t\t\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[31] = 
    "\" \n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "/>Por Turnar</td>\n\t\t\t\t\t\t<td width=\"25%\">&nbsp;&nbsp;<input type=\"checkbox\"\n\t\t\t\t\t\t\tname=\"estatusOtrasVentanillas\" \n\t\t\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[33] = 
    "\"\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "/>En Tr&aacute;mite</td>\n\t\t\t\t\t\t<td width=\"25%\">&nbsp;&nbsp;<input type=\"checkbox\"\n\t\t\t\t\t\t\tname=\"estatusOtrasVentanillas\"\n\t\t\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[35] = 
    "\" \n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "/>Terminado</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t<TABLE border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n\t\t\t\t\t<TBODY>\n\t\t\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t\t\t<td><b><font size=\"2\" color=\"#004080\"\n\t\t\t\t\t\t\t\tface=\"Arial\">Tipo de Reporte</font></b></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t\t\t<td width=\"100%\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\t\t\t\t\tsrc=\"./Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</TBODY>\n\t\t\t\t</TABLE>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>&nbsp;\n\t\t\t\t<TABLE width=\"200\" border=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"40\">&nbsp;</td>\n\t\t\t\t\t\t<td>".toCharArray();
    __oracle_jsp_text[37] = 
    "Detalle</td>\n\t\t\t\t\t\t<td>".toCharArray();
    __oracle_jsp_text[38] = 
    "Totales</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n\n</table>\n".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n".toCharArray();
    __oracle_jsp_text[41] = 
    "\n".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n".toCharArray();
    __oracle_jsp_text[44] = 
    "\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
