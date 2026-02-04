package _ciudadano;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;


public class _seguimientoUCT extends com.orionserver.http.OrionHttpJspPage {


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
    _seguimientoUCT page = this;
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
      
      	String strIdSolicitud = "";
      	strIdSolicitud 	=	(request.getParameter("id_solicitud") != null)?request.getParameter("id_solicitud"):"";
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+11,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("login.jsp?pagina="+ strTmp+"?id_solicitud="+strIdSolicitud);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
      	}
      
      out.write(__oracle_jsp_text[3]);
      
      	
      	String strIdAsunto = "";
      	String strGetSolicitus[][] = null;
      	String strFechaHora		=	"";
      	String strIdCiudadano	=	"";
      	int k = 0;
      	String strDatosCiudadano[][] = null;
      
      	if(strIdSolicitud != null && strIdSolicitud.length() > 0){
      		strGetSolicitus = ActualizaCiudadano.getDatosCiudadanoDetalle(strIdSolicitud);
      		strIdAsunto = strGetSolicitus[0][6];
      		strFechaHora = strGetSolicitus[0][8];
      		strIdCiudadano = strGetSolicitus[0][9];
      		if(strFechaHora.length()>3){
      			strFechaHora = strFechaHora.substring(0, strFechaHora.length()-2);
      		}
      //		//System.out.println("fechehora**-->"+strFechaHora);
      		strDatosCiudadano = ActualizaCiudadano.getDatosCiudadano(strIdCiudadano);
      	}
      
      out.write(__oracle_jsp_text[4]);
      out.print(strIdSolicitud);
      out.write(__oracle_jsp_text[5]);
      out.print(strGetSolicitus[0][2]);
      out.write(__oracle_jsp_text[6]);
      out.print(strDatosCiudadano[0][1]);
      out.write(__oracle_jsp_text[7]);
      out.print(strDatosCiudadano[0][2]);
      out.write(__oracle_jsp_text[8]);
      out.print(strDatosCiudadano[0][3]);
      out.write(__oracle_jsp_text[9]);
      out.print(strDatosCiudadano[0][7]);
      out.write(__oracle_jsp_text[10]);
      out.print(strDatosCiudadano[0][8]);
      out.write(__oracle_jsp_text[11]);
      out.print(strDatosCiudadano[0][9]);
      out.write(__oracle_jsp_text[12]);
      out.print(strDatosCiudadano[0][10]);
      out.write(__oracle_jsp_text[13]);
      out.print(strDatosCiudadano[0][4]);
      out.write(__oracle_jsp_text[14]);
      out.print(strDatosCiudadano[0][11]);
      out.write(__oracle_jsp_text[15]);
      out.print(strDatosCiudadano[0][6]);
      out.write(__oracle_jsp_text[16]);
      out.print(strDatosCiudadano[0][12]);
      out.write(__oracle_jsp_text[17]);
      out.print(strGetSolicitus[0][7]);
      out.write(__oracle_jsp_text[18]);
      out.print(strFechaHora);
      out.write(__oracle_jsp_text[19]);

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
  private static final char __oracle_jsp_text[][]=new char[20][];
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<TITLE>seguimientoUCT.jsp</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n\tfunction ImprPDF(){\n\t\twindow.open(\"../Report?id_sol=\"+".toCharArray();
    __oracle_jsp_text[5] = 
    ");\n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY>\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n<FORM action=\"seguimientoUCT.jsp\" name=\"seguimientoFormUCT\" method=\"post\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"SolicitudUCT.jsp\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/Regresar.gif\" width=\"82\" height=\"26\"> </a>\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">\n\t\t\t\t<a onclick=\"ImprPDF();\"><IMG border=\"0\" src=\"../Imagenes/Imprimir.gif\" width=\"32\"\n\t\t\t\theight=\"32\"></a>\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"268\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"#004080\" size=\"2\">\n\t\t\tSeguimiento</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"420\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#00204f\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<BR>\n<br>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR VALIGN=top>\n\t\t<!-- <TD width=\"200\"><IMG border=\"0\" src=\"../Imagenes/logoPortal.jpg\"\n\t\t\t\twidth=\"145\" height=\"116\"></TD>-->\n\t\t<TD width=\"200\"><IMG border=\"0\" src=\"../Imagenes/issste.jpg\"\n\t\t\t\twidth=\"145\" height=\"150\"></TD>\n\t\t<TD width=\"400\" align=\"center\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\"><br><br><br><br>\n\t\t\t\tSolicitud de Acceso a la información Pública<br>\n\t\t\t\tdel Gobierno del Estado de Baja California</FONT></b></TD>\n\t\t<TD width=\"286\" align=\"right\"><br><br><br><br><br><br>\n\t\t\t<FONT SIZE=2 FACE=\"Verdana\">\n\t\t\t<u><b>".toCharArray();
    __oracle_jsp_text[6] = 
    "</b></u><br>\n\t\t\tNo. de Solicitud\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\t\n</DIV>\n<br>\n<BR>\n<BR>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tDATOS DEL SOLICITANTE</font></b>\n\t\t</TD>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"286\" align=\"right\">&nbsp;</TD>\n\t</TR>\n</TBODY>\n</table>\t\n</DIV>\n<br>\n<br>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tNombre/Razón Social:</font></b>\n\t\t</TD>\n\t\t<TD width=\"300\"><FONT SIZE=2 FACE=\"Verdana\">\n\t\t".toCharArray();
    __oracle_jsp_text[7] = 
    "&nbsp;".toCharArray();
    __oracle_jsp_text[8] = 
    "&nbsp;".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t</FONT></TD>\n\t\t<TD width=\"286\" align=\"right\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"286\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tDomicilio:</font></b>\n\t\t</TD>\n\t\t<TD width=\"300\"><FONT SIZE=2 FACE=\"Verdana\">\n\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t</FONT></TD>\n\t\t<TD width=\"286\" align=\"right\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"286\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tPaís:</font></b>\n\t\t</TD>\n\t\t<TD width=\"300\"><FONT SIZE=2 FACE=\"Verdana\">\n\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t</FONT></TD>\n\t\t<TD width=\"286\" align=\"right\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"286\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tEstado:</font></b>\n\t\t</TD>\n\t\t<TD width=\"300\"><FONT SIZE=2 FACE=\"Verdana\">\n\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t</FONT></TD>\n\t\t<TD width=\"286\" align=\"right\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"286\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tMunicipio:</font></b>\n\t\t</TD>\n\t\t<TD width=\"300\"><FONT SIZE=2 FACE=\"Verdana\">\n\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t</FONT></TD>\n\t\t<TD width=\"286\" align=\"right\">&nbsp;</TD>\n\t</TR>\n</TBODY>\n</table>\t\n</DIV>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<td width=\"301\">&nbsp;</td>\n\t\t<td width=\"251\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"170\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"163\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<td width=\"301\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Correo Electrónico:</font></b>\n\t\t</td>\n\t\t<td width=\"251\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[14] = 
    "</font>\n\t\t</td>\n\t\t<td width=\"170\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Telefono:</font></b>\n\t\t</td>\n\t\t<td width=\"163\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[15] = 
    "</font><br></td>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"301\">&nbsp;</td>\n\t\t<td width=\"251\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"170\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"163\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<td width=\"301\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Ocupación:</font></b>\n\t\t</td>\n\t\t<td width=\"251\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[16] = 
    "</font>\n\t\t</td>\n\t\t<td width=\"170\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Sector:</font></b>\n\t\t</td>\n\t\t<td width=\"163\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[17] = 
    "</font><br></td>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"301\">&nbsp;</td>\n\t\t<td width=\"251\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"170\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"163\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n<BR><BR><BR>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tinformación QUE SOLICITA</font></b>\n\t\t</TD>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"286\" align=\"right\">&nbsp;</TD>\n\t</TR>\n</TBODY>\n</table>\t\n</DIV>\n<BR><BR>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR VALIGN=top>\n\t\t<TD width=\"884\">\n\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[18] = 
    "</font></TD>\n\t</TR>\n</TBODY>\n</table>\t\n</DIV>\n<br><br><br><br>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR VALIGN=top>\n\t\t<TD width=\"450\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tFecha y Hora de Recepción:</font></b>&nbsp;&nbsp;&nbsp;<u>".toCharArray();
    __oracle_jsp_text[19] = 
    "</u>\n\t\t</TD>\n\t\t<TD width=\"99\">&nbsp;</TD>\n\t\t<TD align=\"right\" width=\"337\"></TD>\n\t</TR>\n</TBODY>\n</table>\t\n</DIV>\n<br><br><br><br><br><br>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
