package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.util.*;
import java.util.*;
import com.meve.sigma.reportes.*;


public class _ViewDoctosDetenidos extends com.orionserver.http.OrionHttpJspPage {


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
    _ViewDoctosDetenidos page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("header.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null)
      	try{
      		response.sendRedirect("index.jsp?pagina="+ strTmp);
      	}catch(java.io.IOException io){;}
      	String strIdAreaUsuario = BUsuario.getIdArea();
      	String strIdArea = BUsuario.getIdArea();
      	String strAccion = request.getParameter("accion");
      
      	java.text.SimpleDateFormat sdf	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	String strFechaActual			=	sdf.format(f);
      
      	String strDoctosDetenidos[][] 	= 	null;
      	String strDiasVenAsuntos[][]	=	null;
      	String strDoctosEnTramite[][]	=	null;
      
      	if(strAccion != null && strAccion.equals("guardar")){
      		strIdArea = request.getParameter("id_area");
      		try{
      			response.sendRedirect("ViewDoctosDetenidos.jsp?id_area="+strIdArea);
      		}catch(java.io.IOException io){;}
      	}
      	if(strIdArea != null && strIdArea.length() > 0){
      		strDoctosDetenidos 	= 	ActualizaAsunto.getAsuntosPorTurnarRetrasados(strIdArea);
      		strDiasVenAsuntos	=	ActualizaConfiguracion.getDatosConf();
      		strDoctosEnTramite	=	ActualizaAsunto.getAsuntosEnTramiteRetrasados(strIdArea);
      	}
      	
      
      out.write(__oracle_jsp_text[3]);
       if (	BUsuario.getRecepcion() && 
      		!(BUsuario.getAdmon() || BUsuario.getSupervisor() || BUsuario.getAtencion() || BUsuario.getTurnado() || BUsuario.getAsistente())){ 
      out.write(__oracle_jsp_text[4]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[5]);
       } 
      out.write(__oracle_jsp_text[6]);
      out.write(__oracle_jsp_text[7]);
      out.print(BUsuario.getIdArea());
      out.write(__oracle_jsp_text[8]);
      out.print(ActualizaArea.NombreArea(BUsuario.getIdArea()));
      out.write(__oracle_jsp_text[9]);
      out.write(__oracle_jsp_text[10]);
      if(strIdArea!= null && strIdArea.length() > 0){
      out.write(__oracle_jsp_text[11]);
      out.print(strDoctosDetenidos[0][1]);
      out.write(__oracle_jsp_text[12]);
      if(strDoctosDetenidos != null && strDoctosDetenidos.length> 0){
      out.write(__oracle_jsp_text[13]);
      ArrayList al = new ArrayList(); 
      out.write(__oracle_jsp_text[14]);
      for(int i=0;i<strDoctosDetenidos.length;i++){
      out.write(__oracle_jsp_text[15]);
      
      					Calendar cFechaCap = Utilerias.StringCalendar(strDoctosDetenidos[i][5]);
      					String strFecha = Utilerias.getFechaTerminacionInst((Calendar)cFechaCap.clone(), String.valueOf(strDiasVenAsuntos[0][1]));
      					Calendar cFechaEst = Utilerias.StringCalendar2(strFecha);
      					int iSinDiasFest = Utilerias.getSinDiasFestivos(cFechaCap, cFechaEst);
      					String strFechaEst = Utilerias.getFechaTerminacionInst((Calendar)cFechaEst.clone(), String.valueOf(iSinDiasFest));
      					Calendar cFechaIni = Utilerias.StringCalendar2(strFechaEst);
      					Calendar cFechaAct = Utilerias.StringCalendar2(strFechaActual);
      					boolean bAtrasado = Utilerias.fechasAtrasadas(cFechaIni, cFechaAct);
      				
      out.write(__oracle_jsp_text[16]);
      if(bAtrasado){
      out.write(__oracle_jsp_text[17]);
      out.print(strDoctosDetenidos[i][6]);
      out.write(__oracle_jsp_text[18]);
      out.print(strDoctosDetenidos[i][2]);
      out.write(__oracle_jsp_text[19]);
      out.print(strDoctosDetenidos[i][3]);
      out.write(__oracle_jsp_text[20]);
      
      							int iDiasAtrasado = Utilerias.DiasdeTrabajoEntre1(cFechaIni, cFechaAct);
      							int iDiasSinDFest = Utilerias.getSinDiasFestivos(cFechaIni, cFechaAct);
      							int iTotal = iDiasAtrasado - iDiasSinDFest;
      						
      out.write(__oracle_jsp_text[21]);
      out.print(iTotal);
      out.write(__oracle_jsp_text[22]);
      String strCount = ActualizaAsunto.getCountInstSinTurnar(strDoctosDetenidos[i][0]);
      out.write(__oracle_jsp_text[23]);
       String estatus = ""; 
      out.write(__oracle_jsp_text[24]);
      if(strCount.equals("0")){
      out.write(__oracle_jsp_text[25]);
       estatus = "No se ha credo Ruta de atención"; 
      out.write(__oracle_jsp_text[26]);
      }else{
      out.write(__oracle_jsp_text[27]);
       estatus = "Tiene "+ strCount + " Instruccion(es) sin Turnar"; 
      out.write(__oracle_jsp_text[28]);
      }
      out.write(__oracle_jsp_text[29]);
      out.print( estatus );
      out.write(__oracle_jsp_text[30]);
       	BeanReporteAtrasados BReporte = new BeanReporteAtrasados();
      					BReporte.setCampos(strDoctosDetenidos[i]);
      					BReporte.setAtraso("" + iTotal);
      					BReporte.setEstatus(estatus);
      					al.add(BReporte); 
      out.write(__oracle_jsp_text[31]);
      }
      out.write(__oracle_jsp_text[32]);
      }
      				session.setAttribute("ArrayReporte",al);
      				}else{
      out.write(__oracle_jsp_text[33]);
      }
      out.write(__oracle_jsp_text[34]);
      out.print(strDoctosEnTramite[0][1]);
      out.write(__oracle_jsp_text[35]);
      if(strDoctosEnTramite != null && strDoctosEnTramite.length> 0){
      out.write(__oracle_jsp_text[36]);
      ArrayList al = new ArrayList(); 
      out.write(__oracle_jsp_text[37]);
      for(int i=0;i<strDoctosEnTramite.length;i++){
      out.write(__oracle_jsp_text[38]);
      
      					Calendar cFechaCad = Utilerias.StringCalendar(strDoctosEnTramite[i][6]);
      					Calendar cFechaAct = Utilerias.StringCalendar2(strFechaActual);
      					boolean bAtrasado = Utilerias.fechasAtrasadas(cFechaCad, cFechaAct);
      				
      out.write(__oracle_jsp_text[39]);
      if(bAtrasado){
      out.write(__oracle_jsp_text[40]);
      out.print(strDoctosEnTramite[i][7]);
      out.write(__oracle_jsp_text[41]);
      out.print(strDoctosEnTramite[i][2]);
      out.write(__oracle_jsp_text[42]);
      out.print(strDoctosEnTramite[i][3]);
      out.write(__oracle_jsp_text[43]);
      
      							int iDiasAtrasado = Utilerias.DiasdeTrabajoEntre1(cFechaCad, cFechaAct);
      							int iDiasSinDFest = Utilerias.getSinDiasFestivos(cFechaCad, cFechaAct);
      							int iTotal = iDiasAtrasado - iDiasSinDFest;
      						
      out.write(__oracle_jsp_text[44]);
      out.print(iTotal);
      out.write(__oracle_jsp_text[45]);
      out.print(strDoctosEnTramite[i][0]);
      out.write(__oracle_jsp_text[46]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[47]);
       	BeanReporteAtrasados2 BReporte = new BeanReporteAtrasados2();
      					BReporte.setCampos(strDoctosEnTramite[i]);
      					BReporte.setAtraso("" + iTotal);
      					BReporte.setEstatus("Ver Detalle");
      					al.add(BReporte); 
      out.write(__oracle_jsp_text[48]);
      }
      out.write(__oracle_jsp_text[49]);
      }
      				session.setAttribute("ArrayReporte2",al);
      				}else{
      out.write(__oracle_jsp_text[50]);
      }
      out.write(__oracle_jsp_text[51]);
      }
      out.write(__oracle_jsp_text[52]);

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
  private static final char __oracle_jsp_text[][]=new char[53][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Asuntos por Turnar Atrasados</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n\tfunction guardar() {\n\t\tdoc = document.viewDetenidos;\n\t\tvalida = 0;\n\t\tmsg=\"\";\n\t\tdoc.accion.value=\"guardar\";\n\t\tdoc.submit();\n\t}\n</SCRIPT>\n</HEAD>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"ViewDoctosDetenidos.jsp\" name=\"viewDetenidos\" method=\"post\">\n<INPUT type=\"hidden\" value=\"guardar\" name=\"accion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" width=\"1000\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"25%\"><a\n\t\t\thref=\"portalPrincipal.jsp\"> <img src=\"../Imagenes/NavLeft.gif\" border=\"0\" alt=\"Regresar\"> </a> </td>\n\t\t<td width=\"25%\">\n\t\t\t<!-- <A onclick=\"guardar()\">\n\t\t\t<IMG src=\"../Imagenes/bot_nue_tem.gif\" width=\"108\" height=\"29\">\n\t\t\t</A> -->\n\t\t</td>\n\t\t<td width=\"25%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"25%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</table>\n</DIV>\n<br>\n<!-- \n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"546\"><b><font size=\"2\" color=\"#002060\" face=\"Arial\">Condiciones\n\t\tpara Generar Reporte</font></b>\n\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"100%\" bgcolor=\"#002060\"><img src=\"../Imagenes/shim.gif\"\n\t\t\t\t\twidth=\"1\" height=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<br>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"546\">\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"23\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"498\"><font size=\"2\" face=\"Arial\">Proporcione la\n\t\t\t\tinformacion solicitada y posteriormente de clic en el botón\n\t\t\t\t&quot;Generar Reporte&quot;. Para salir de clic en el botón\n\t\t\t\t&quot;Cancelar&quot;.</font></td>\n\t\t\t\t<td width=\"24\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<hr>\n\t\t<br>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"546\">\n\t\t<center>\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"117\">\n\t\t\t\t<div align=\"left\"><b><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Seleccione Unidad:</font></b>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"380\">\n\t\t\t\t\t<FONT SIZE=2 FACE=\"Verdana\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t\t\t\t\t<SELECT name=\"id_area\" class=\"blue200\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\">\n\t\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\">".toCharArray();
    __oracle_jsp_text[9] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t\t\t</SELECT>\n\t\t\t\t\t</FONT>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</center>\n\t\t<br>\n\t\t<hr>\n\t\t<br>\n\t\t</td>\n\t</tr>\n</table>\n</DIV>\n -->\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"1\" cellpadding=\"1\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#002060\" width=\"1000\">\t\t\n\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t<td width=\"968\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[12] = 
    "<BR>Asuntos por Turnar Atrasados</font></b>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"32\">\n\t\t\t\t\t\t<div align=\"right\">\n\t\t\t\t\t\t\t<i><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\"></font></i>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\t<TR>\n\t\t<TD bgcolor=\"#002060\" width=\"1000\">\n\t\t\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t<TD bgcolor=\"#002060\" align=\"center\" width=\"165\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Folio</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD bgcolor=\"#002060\" align=\"center\" width=\"303\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Asunto</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD bgcolor=\"#002060\" align=\"center\" width=\"223\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Responsable</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD bgcolor=\"#002060\" align=\"center\" width=\"69\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Días de <br>Atraso</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD bgcolor=\"#002060\" align=\"center\" width=\"236\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Estatus</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<TD width=\"1000\"> \n\t\t\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t\t<TR>\n\t\t\t\t\t<TD align=\"center\">\n\t\t\t\t\t\t<A onclick=\"window.open('../ReporteBeanExcel?tip=AnalisisPorAtrasadosExcel');\" title=\"Exportar a Excel\">\n\t\t\t\t\t\t<img src=\"../Imagenes/ic_excel.gif\" border=\"0\"></A>\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<A onclick=\"window.open('../ReporteBeanPDF?tip=AnalisisPorAtrasados');\" title=\"Exportar a PDF\">\n\t\t\t\t\t\t<img src=\"../Imagenes/ic_pdf.gif\" border=\"0\"></A>\n\t\t\t\t\t</TD>\n\t\t\t\t</TR>\n\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t<TD align=\"center\" width=\"165\">\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[18] = 
    "</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD align=\"center\" width=\"303\">\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[19] = 
    "</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD align=\"center\" width=\"223\">\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[20] = 
    "</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD align=\"center\" width=\"69\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[22] = 
    "</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD align=\"center\" width=\"236\">\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t\t\t\t<b>".toCharArray();
    __oracle_jsp_text[30] = 
    "</b>\n\t\t\t\t\t\t</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t</TR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t<tr>\n\t\t\t\t\t<TD align=\"center\" colspan=\"4\" width=\"1000\">\n\t\t\t\t\t\t<b><font size=\"2\" face=\"Arial\">*** No hay Asuntos Atrasados ***</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t</tr>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t</table>\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n<br>\n<!-- Tabla donde se muestra los asuntos que tienen un atraso, en tramite -->\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"1\" cellpadding=\"1\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#002060\" width=\"1000\">\t\t\n\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t<td width=\"968\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[35] = 
    "<BR>Asuntos en Tramite Atrasados</font></b>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"32\">\n\t\t\t\t\t\t<div align=\"right\">\n\t\t\t\t\t\t\t<i><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\"></font></i>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\t<TR>\n\t\t<TD bgcolor=\"#002060\" width=\"1000\">\n\t\t\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t<TD bgcolor=\"#002060\" align=\"center\" width=\"165\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Folio</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD bgcolor=\"#002060\" align=\"center\" width=\"303\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Nombre del Docto.</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD bgcolor=\"#002060\" align=\"center\" width=\"223\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Responsable</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD bgcolor=\"#002060\" align=\"center\" width=\"69\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Días de <br>Atraso</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD bgcolor=\"#002060\" align=\"center\" width=\"236\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Estatus</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<TD width=\"1000\"> \n\t\t\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t\t<TR>\n\t\t\t\t\t<TD align=\"center\">\n\t\t\t\t\t\t<A onclick=\"window.open('../ReporteBeanExcel?tip=AnalisisPorAtrasadosExcel&control=1');\" title=\"Exportar a Excel\">\n\t\t\t\t\t\t<img src=\"../Imagenes/ic_excel.gif\" border=\"0\"></A>\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<A onclick=\"window.open('../ReporteBeanPDF?tip=AnalisisPorAtrasados&control=1');\" title=\"Exportar a PDF\">\n\t\t\t\t\t\t<img src=\"../Imagenes/ic_pdf.gif\" border=\"0\"></A>\n\t\t\t\t\t</TD>\n\t\t\t\t</TR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t<TD align=\"center\" width=\"165\">\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[41] = 
    "</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD align=\"center\" width=\"303\">\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[42] = 
    "</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD align=\"center\" width=\"223\">\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[43] = 
    "</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD align=\"center\" width=\"69\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[45] = 
    "</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD align=\"center\" width=\"236\">\n\t\t\t\t\t\t<font size=\"1\" face=\"Arial\"> \n\t\t\t\t\t\t\t<a href=\"ViewDoctosDetalle.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[46] = 
    "&id_area=".toCharArray();
    __oracle_jsp_text[47] = 
    "\">Ver Detalle</a>\n\t\t\t\t\t\t</font>\n\t\t\t\t\t</TD>\n\t\t\t\t</TR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t\t\t<tr>\n\t\t\t\t\t<TD align=\"center\" colspan=\"4\" width=\"1000\">\n\t\t\t\t\t\t<b><font size=\"2\" face=\"Arial\">*** No hay Asuntos Atrasados ***</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t</tr>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t\t</table>\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n\n".toCharArray();
    __oracle_jsp_text[52] = 
    "\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
