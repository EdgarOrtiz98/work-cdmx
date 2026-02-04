package _ciudadano;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;


public class _confirmacionUCT extends com.orionserver.http.OrionHttpJspPage {


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
    _confirmacionUCT page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("headerUCT.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      
      	String strIdCiudadano = "";
      	strIdCiudadano = (request.getParameter("id_ciu") != null)?request.getParameter("id_ciu"):"";
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+11,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("login.jsp?pagina="+ strTmp+"?id_ciu="+strIdCiudadano);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
      	}
      	String nombre = "";
      	String ap = "";
      	String am = "";
      	String strDatosCiudadano[][] = null;
      	if(strIdCiudadano != null){
      		strDatosCiudadano = ActualizaCiudadano.getDatosCiudadano(strIdCiudadano);
      	}
      
      out.write(__oracle_jsp_text[3]);
      out.print(strIdCiudadano);
      out.write(__oracle_jsp_text[4]);
       if(strIdCiudadano != null){ 
      out.write(__oracle_jsp_text[5]);
      out.print(strDatosCiudadano[0][1]+" "+strDatosCiudadano[0][2]+" "+strDatosCiudadano[0][3]);
      out.write(__oracle_jsp_text[6]);
       } 
      out.write(__oracle_jsp_text[7]);
       if(strIdCiudadano != null){ 
      out.write(__oracle_jsp_text[8]);
      out.print(strDatosCiudadano[0][7]);
      out.write(__oracle_jsp_text[9]);
       } 
      out.write(__oracle_jsp_text[10]);
       if(strIdCiudadano != null){ 
      out.write(__oracle_jsp_text[11]);
      out.print(strDatosCiudadano[0][8]);
      out.write(__oracle_jsp_text[12]);
       } 
      out.write(__oracle_jsp_text[13]);
       if(strIdCiudadano != null){ 
      out.write(__oracle_jsp_text[14]);
      out.print(strDatosCiudadano[0][9]);
      out.write(__oracle_jsp_text[15]);
       } 
      out.write(__oracle_jsp_text[16]);
       if(strIdCiudadano != null){ 
      out.write(__oracle_jsp_text[17]);
      out.print(strDatosCiudadano[0][7]);
      out.write(__oracle_jsp_text[18]);
       } 
      out.write(__oracle_jsp_text[19]);
       if(strIdCiudadano != null){ 
      out.write(__oracle_jsp_text[20]);
      out.print(strDatosCiudadano[0][4]);
      out.write(__oracle_jsp_text[21]);
       } 
      out.write(__oracle_jsp_text[22]);
       if(strIdCiudadano != null){ 
      out.write(__oracle_jsp_text[23]);
      out.print(strDatosCiudadano[0][11]);
      out.write(__oracle_jsp_text[24]);
       } 
      out.write(__oracle_jsp_text[25]);
       if(strIdCiudadano != null){ 
      out.write(__oracle_jsp_text[26]);
      out.print(strDatosCiudadano[0][5]);
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
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<STYLE type=\"text/css\">\n</STYLE>\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=\"text/javascript\"></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript>\n\tfunction ImprPDF1(){\n\t\twindow.open(\"../ReportCiudadano?id_ciu=\"+".toCharArray();
    __oracle_jsp_text[4] = 
    ");\n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n<FORM name=\"confirmacionUCT\" action=\"confirmacionUCT.jsp\" method=\"post\">\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"SolicitudUCT.jsp\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/Regresar.gif\" width=\"82\" height=\"26\"> </a>\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">\n\t\t\t\t<a onclick=\"ImprPDF1()\"><IMG border=\"0\" src=\"../Imagenes/Imprimir.gif\" width=\"32\"\n\t\t\t\theight=\"32\"></a>\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"268\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"#004080\" size=\"2\">\n\t\t\tRegistro</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"420\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#00204f\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<BR>\n<br>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR VALIGN=top>\n\t\t<!-- <TD width=\"200\"><IMG border=\"0\" src=\"../Imagenes/logoPortal.jpg\"\n\t\t\t\twidth=\"145\" height=\"116\"></TD>-->\n\t\t<TD width=\"200\"><IMG border=\"0\" src=\"../Imagenes/issste.jpg\"\n\t\t\t\twidth=\"145\" height=\"150\"></TD>\n\t\t<TD width=\"400\" align=\"center\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\"><br><br><br><br>\n\t\t\t\tRegistro de Ciudadano<br>\n\t\t\t\tGobierno del Estado de Baja California</FONT></b></TD>\n\t\t<TD width=\"286\" align=\"right\"><br><br><br><br><br><br>\n\t\t\t<FONT SIZE=2 FACE=\"Verdana\">\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\t\n</DIV>\n<br>\n<BR>\n<BR>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tDATOS DEL SOLICITANTE</font></b>\n\t\t</TD>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"286\" align=\"right\">&nbsp;</TD>\n\t</TR>\n</TBODY>\n</table>\t\n</DIV>\n<br>\n<br>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tNombre/Razón Social:</font></b>\n\t\t</TD>\n\t\t<TD width=\"300\"><FONT SIZE=2 FACE=\"Verdana\">\n\t\t".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[6] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t\t</FONT></TD>\n\t\t<TD width=\"286\" align=\"right\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"286\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tDomicilio:</font></b>\n\t\t</TD>\n\t\t<TD width=\"300\"><FONT SIZE=2 FACE=\"Verdana\">\n\t\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t</FONT></TD>\n\t\t<TD width=\"286\" align=\"right\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"286\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tPaís:</font></b>\n\t\t</TD>\n\t\t<TD width=\"300\"><FONT SIZE=2 FACE=\"Verdana\">\n\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t</FONT></TD>\n\t\t<TD width=\"286\" align=\"right\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"286\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tEstado:</font></b>\n\t\t</TD>\n\t\t<TD width=\"300\"><FONT SIZE=2 FACE=\"Verdana\">\n\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t</FONT></TD>\n\t\t<TD width=\"286\" align=\"right\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"286\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tMunicipio:</font></b>\n\t\t</TD>\n\t\t<TD width=\"300\"><FONT SIZE=2 FACE=\"Verdana\">\n\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t</FONT></TD>\n\t\t<TD width=\"286\" align=\"right\">&nbsp;</TD>\n\t</TR>\n</TBODY>\n</table>\t\n</DIV>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<td width=\"301\">&nbsp;</td>\n\t\t<td width=\"251\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"170\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"163\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<td width=\"301\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Correo Electrónico:</font></b>\n\t\t</td>\n\t\t<td width=\"251\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "</font>\n\t\t</td>\n\t\t<td width=\"170\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Telefono:</font></b>\n\t\t</td>\n\t\t<td width=\"163\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "</font><br></td>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"301\">&nbsp;</td>\n\t\t<td width=\"251\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"170\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"163\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<td width=\"301\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Nombre de Usuario:</font></b>\n\t\t</td>\n\t\t<td width=\"251\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "</font>\n\t\t</td>\n\t\t<td width=\"170\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\"></font></b>\n\t\t</td>\n\t\t<td width=\"163\"><FONT SIZE=2 FACE=\"Verdana\"></font><br></td>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"301\">&nbsp;</td>\n\t\t<td width=\"251\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"170\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"163\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
