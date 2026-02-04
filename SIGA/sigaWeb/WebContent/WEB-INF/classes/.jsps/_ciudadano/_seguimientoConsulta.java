package _ciudadano;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.*;


public class _seguimientoConsulta extends com.orionserver.http.OrionHttpJspPage {


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
    _seguimientoConsulta page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("headerCiudadano.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      
      	String strIdSolicitud = "";
      	strIdSolicitud 	=	(request.getParameter("id_solicitud") != null)?request.getParameter("id_solicitud"):""; 
      
      out.write(__oracle_jsp_text[3]);
      
      	
      	String strIdAsunto = "";
      	String strGetSolicitus[][] = null;
      	String strGetFechaVen[][] = null;
      	String strFechaHora		=	"";
      	String strFechaVen		=	"";
      	int k = 0;
      	
      
      	if(strIdSolicitud != null && strIdSolicitud.length() > 0){
      		strGetSolicitus = ActualizaCiudadano.getDatosCiudadanoDetalle(strIdSolicitud);
      		strIdAsunto = strGetSolicitus[0][6];
      		strFechaHora = strGetSolicitus[0][8];
      
      		strGetFechaVen = ActualizaAsunto.getAsuntos(strIdAsunto);
      		strFechaVen = strGetFechaVen[0][15];
      		
      		if(strFechaHora.length()>3){
      			strFechaHora = strFechaHora.substring(0, strFechaHora.length()-2);
      		}
      //		//System.out.println("fechehora**-->"+strFechaHora);
      	}
      
      out.write(__oracle_jsp_text[4]);
      out.print(strGetSolicitus[0][2]);
      out.write(__oracle_jsp_text[5]);
      out.print(strGetSolicitus[0][7]);
      out.write(__oracle_jsp_text[6]);
      out.print(strFechaHora);
      out.write(__oracle_jsp_text[7]);
      out.print(Utilerias.formatearFechas(strFechaVen));
      out.write(__oracle_jsp_text[8]);

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
  private static final char __oracle_jsp_text[][]=new char[9][];
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<TITLE>seguimiento.jsp</TITLE>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n<FORM action=\"seguimientoConsulta.jsp\" name=\"seguimientoFormC\" method=\"post\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"ConsultaPublica.jsp\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/Regresar.gif\" width=\"82\" height=\"26\"> </a>\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">\n\t\t\t\t<a onclick=\"Imprimir10()\"><IMG border=\"0\" src=\"../Imagenes/Imprimir.gif\" width=\"32\"\n\t\t\t\theight=\"32\"></a>\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"268\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"#004080\" size=\"2\">\n\t\t\tSeguimiento</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"420\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#00204f\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<BR>\n<br>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR VALIGN=top>\n\t\t<!-- <TD width=\"200\"><IMG border=\"0\" src=\"../Imagenes/logoPortal.jpg\"\n\t\t\t\twidth=\"145\" height=\"116\"></TD>-->\n\t\t<TD width=\"200\"><IMG border=\"0\" src=\"../Imagenes/issste.jpg\"\n\t\t\t\twidth=\"145\" height=\"150\"></TD>\n\t\t<TD width=\"400\" align=\"center\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\"><br><br><br><br>\n\t\t\t\tSolicitud de Acceso a la información Pública<br>\n\t\t\t\tdel Gobierno del Estado de Baja California</FONT></b></TD>\n\t\t<TD width=\"286\" align=\"right\"><br><br><br><br><br><br>\n\t\t\t<FONT SIZE=2 FACE=\"Verdana\">\n\t\t\t<u><b>".toCharArray();
    __oracle_jsp_text[5] = 
    "</b></u><br>\n\t\t\tNo. de Solicitud\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\t\n</DIV>\n<br>\n<BR>\n<BR>\n<br>\n<BR>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR VALIGN=top>\n\t\t<TD width=\"300\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tinformación QUE SOLICITA</font></b>\n\t\t</TD>\n\t\t<TD width=\"300\">&nbsp;</TD>\n\t\t<TD width=\"286\" align=\"right\">&nbsp;</TD>\n\t</TR>\n</TBODY>\n</table>\t\n</DIV>\n<BR><BR>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR VALIGN=top>\n\t\t<TD width=\"884\">\n\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[6] = 
    "</font></TD>\n\t</TR>\n</TBODY>\n</table>\t\n</DIV>\n<br><br>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR VALIGN=top> \n\t\t<TD width=\"450\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tFecha y Hora de Recepción:</font></b>&nbsp;&nbsp;&nbsp;<u>".toCharArray();
    __oracle_jsp_text[7] = 
    "</u>\n\t\t</TD>\n\t\t<TD width=\"99\">&nbsp;</TD>\n\t\t<TD align=\"right\" width=\"337\"></TD>\n\t</TR>\n\t<TR VALIGN=top> \n\t\t<TD width=\"450\">\n\t\t\t&nbsp;\n\t\t</TD>\n\t\t<TD width=\"99\">&nbsp;</TD>\n\t\t<TD align=\"right\" width=\"337\">&nbsp;</TD>\n\t</TR>\n</TBODY>\n</table>\t\n</DIV>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR VALIGN=top> \n\t\t<TD width=\"549\">\n\t\t\t<font size=\"2\" FACE=\"Arial\">\n\t\t\tLe Recordamos que el termino para atender su solicitud es de 10 Días por lo que<br>\n\t\t\tsugerimos que con su usuario y Contraseña de seguimiento de a partir del <u>".toCharArray();
    __oracle_jsp_text[8] = 
    "</u> \n\t\t\t</font>\n\t\t</TD>\n\t\t\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n<br><br><br><br><br><br>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
