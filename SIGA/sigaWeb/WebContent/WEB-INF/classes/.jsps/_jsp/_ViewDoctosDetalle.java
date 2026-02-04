package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.reportes.*;
import com.meve.sigma.util.*;
import java.util.*;


public class _ViewDoctosDetalle extends com.orionserver.http.OrionHttpJspPage {


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
    _ViewDoctosDetalle page = this;
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
      
      	java.text.SimpleDateFormat sdf	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	String strFechaActual			=	sdf.format(f);
      
      	String strIdAsunto = (request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
      	String strIdArea   = (request.getParameter("id_area") != null)?request.getParameter("id_area"):"";
      	String strAccion = request.getParameter("accion");
      
      	String strDetalleInstrucciones[][] = null;
      
      	if(strIdAsunto != null && strIdAsunto.length() > 0){
      		strDetalleInstrucciones = ActualizaInstrucciones.getInstruccionesDetalle(strIdAsunto);
      	}
      
      out.write(__oracle_jsp_text[3]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[4]);
      if(strDetalleInstrucciones != null && strDetalleInstrucciones.length > 0){
      out.write(__oracle_jsp_text[5]);
      for(int i=0;i<strDetalleInstrucciones.length;i++){
      out.write(__oracle_jsp_text[6]);
      if(strDetalleInstrucciones[i][1].length() == 0){
      out.write(__oracle_jsp_text[7]);
      out.print( strDetalleInstrucciones[i][2] );
      out.write(__oracle_jsp_text[8]);
      }else{
      out.write(__oracle_jsp_text[9]);
      out.print(ActualizaInst.getNombreInstruccion1(strDetalleInstrucciones[i][1]));
      out.write(__oracle_jsp_text[10]);
      }
      out.write(__oracle_jsp_text[11]);
      out.print(strDetalleInstrucciones[i][3]);
      out.write(__oracle_jsp_text[12]);
      if(strDetalleInstrucciones[i][5].length() == 0){
      out.write(__oracle_jsp_text[13]);
      }else{
      out.write(__oracle_jsp_text[14]);
      out.print(Utilerias.formatearFechas(strDetalleInstrucciones[i][5]));
      out.write(__oracle_jsp_text[15]);
      }
      out.write(__oracle_jsp_text[16]);
      
      						if(strDetalleInstrucciones[i][5].length() != 0){
      							Calendar cFechaIni = Utilerias.StringCalendar(strDetalleInstrucciones[i][5]);
      							Calendar cFechaAct = Utilerias.StringCalendar2(strFechaActual);
      							int iDiasAtrasado = Utilerias.DiasdeTrabajoEntre1(cFechaIni, cFechaAct);
      							int iDiasSinDFest = Utilerias.getSinDiasFestivos(cFechaIni, cFechaAct);
      							int iTotal = iDiasAtrasado - iDiasSinDFest;
      					
      out.write(__oracle_jsp_text[17]);
      out.print(iTotal);
      out.write(__oracle_jsp_text[18]);
      }else{
      out.write(__oracle_jsp_text[19]);
      }
      out.write(__oracle_jsp_text[20]);
      if(strDetalleInstrucciones[i][6].equals("0")){
      out.write(__oracle_jsp_text[21]);
      }else if(strDetalleInstrucciones[i][6].equals("1")){
      out.write(__oracle_jsp_text[22]);
      }else if(strDetalleInstrucciones[i][6].equals("2")){
      out.write(__oracle_jsp_text[23]);
      }else if(strDetalleInstrucciones[i][6].equals("3")){
      out.write(__oracle_jsp_text[24]);
      }else if(strDetalleInstrucciones[i][6].equals("4")){
      out.write(__oracle_jsp_text[25]);
      }
      out.write(__oracle_jsp_text[26]);
      }}else{
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
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Detalle de las Instrucciones</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n</HEAD>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"ViewDoctosDetalle.jsp\" name=\"viewDetalle\" method=\"post\">\n<INPUT type=\"hidden\" value=\"guardar\" name=\"accion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"ViewDoctosDetenidos.jsp?id_area=".toCharArray();
    __oracle_jsp_text[4] = 
    "\"> <IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/NavLeft.gif\" > </a></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"373\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"800\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">\n\t\t\tDetalle de las Instrucciones del Asunto</FONT></B></TD>\n\t\t\t<TD width=\"100\">&nbsp;</TD>\n\t\t\t<TD width=\"100\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#00204f\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE>\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#002060\" width=\"1000\">\t\t\n\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t<td width=\"968\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Instrucciones</font></b>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"32\">\n\t\t\t\t\t\t<div align=\"right\">\n\t\t\t\t\t\t\t<i><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\"></font></i>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\t<TR>\n\t\t<TD bgcolor=\"#002060\" width=\"1000\">\n\t\t\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t<TD bgcolor=\"#002060\" align=\"center\" width=\"300\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Nombre Instruccion</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD bgcolor=\"#002060\" align=\"center\" width=\"300\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Responsable</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD bgcolor=\"#002060\" align=\"center\" width=\"100\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Fecha de <br>Vencimiento</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD bgcolor=\"#002060\" align=\"center\" width=\"100\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Días de <br>Atraso</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD bgcolor=\"#002060\" align=\"center\" width=\"200\">\n\t\t\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">Estatus</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD width=\"1000\">\n\t\t\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[6] = 
    "\n\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t<TD align=\"center\" width=\"300\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[8] = 
    "</font></b>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t\t\t\t</font></b>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD align=\"center\" width=\"300\">\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[12] = 
    "</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD align=\"center\" width=\"100\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">-</font></b>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[15] = 
    "</font></b>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD align=\"center\" width=\"100\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[18] = 
    "</font></b>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">-</font></b>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD align=\"center\" width=\"200\">\n\t\t\t\t\t\t<b><font size=\"1\" face=\"Arial\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t\t\t\tNo ha sido Turnada\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t\t\t\tEsta en atención\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t\t\t\tEsta en Tramite\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t\t\tHa sido Rechazada\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t\t\t\tHa sido Terminada\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t\t\t</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t</tr>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t<tr>\n\t\t\t\t\t<TD align=\"center\" colspan=\"4\" width=\"1000\">\n\t\t\t\t\t\t<b><font size=\"2\" face=\"Arial\">*** No tiene Instrucciones Asignadas ***</font></b>\n\t\t\t\t\t</TD>\n\t\t\t\t</tr>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t</table>\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
