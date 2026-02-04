package _consulta;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;


public class _DetalleRespuesta extends com.orionserver.http.OrionHttpJspPage {


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
    _DetalleRespuesta page = this;
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
      
      	String strIdNotificacion = "";
      	String strIdSol	= "";
      	strIdNotificacion = request.getParameter("id_not");
      	strIdSol = request.getParameter("id_solicitud");
      
      out.write(__oracle_jsp_text[3]);
      
      	String strCM = application.getInitParameter("content");
      	String strItemType  =  (application.getInitParameter("ItemType")==null)?"":application.getInitParameter("ItemType");
      
      
      //	//System.out.println("idSol="+strIdSol);
      	String getDetalle[][] = null;
      	if(strIdSol != null && strIdSol.length() > 0){
      		getDetalle = ActualizaCiudadano.getDatosNot(strIdSol);
      	}
      
      out.write(__oracle_jsp_text[4]);
       for(int i=0;i<getDetalle.length;i++){ 
      out.write(__oracle_jsp_text[5]);
      
      				String strRespondio = "";
      				if(getDetalle[i][4].equals("1")){
      					strRespondio = "UCT";
      				}else{
      					strRespondio = "Ciudadano";
      				}
      			
      out.write(__oracle_jsp_text[6]);
      out.print(getDetalle[i][1]);
      out.write(__oracle_jsp_text[7]);
      out.print(strRespondio);
      out.write(__oracle_jsp_text[8]);
       if(getDetalle[i][2].length() > 0){ 
      out.write(__oracle_jsp_text[9]);
      out.print(ActualizaTipoRespuesta.getNombreTipoRespuesta(getDetalle[i][2])[0][0]);
      out.write(__oracle_jsp_text[10]);
       } 
      out.write(__oracle_jsp_text[11]);
      out.print(getDetalle[i][0]);
      out.write(__oracle_jsp_text[12]);
       } 
      out.write(__oracle_jsp_text[13]);
      out.print(strCM);
      out.write(__oracle_jsp_text[14]);
      out.print(strIdSol);
      out.write(__oracle_jsp_text[15]);
      out.print(strItemType);
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
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>DetalleRespuesta.jsp</TITLE>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"Consulta.jsp\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/Regresar.gif\" width=\"82\" height=\"26\"> </a>\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">\n\t\t\t\t&nbsp;\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"305\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"#004080\" size=\"2\">\n\t\t\tDetalle de la notificación</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"451\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#00204f\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<BR>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\t<TR VALIGN=top>\n\t\t<TD width=\"23\"><IMG border=\"0\" src=\"../Imagenes/expand.gif\"\n\t\t\t\twidth=\"16\" height=\"16\"></TD>\n\t\t<TD width=\"906\">\n\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[6] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[7] = 
    "(".toCharArray();
    __oracle_jsp_text[8] = 
    ")\n\t\t\t\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"23\">&nbsp;</TD>\n\t\t<TD width=\"906\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"23\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\"></FONT></b></TD>\n\t\t<TD width=\"906\">\n\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"23\">&nbsp;</TD>\n\t\t<TD width=\"906\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"23\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\"></FONT></b></TD>\n\t\t<TD width=\"906\">\n\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "<br>\n\t\t\t-------------------------------------------------------------------------\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n</TBODY>\n</table>\n</DIV>\n<br><br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"#004080\" size=\"2\">\n\t\t\tDocumentos Anexados</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"451\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#00204f\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"451\">&nbsp;</TD>\n\t\t</TR>\n\t\t\n\t\t<TR VALIGN=top>\n\t\t\t<TD colspan=\"3\">\n\t\t\t\t<div>\n\t\t\t\t\t<IFRAME ID=\"frame1\" SRC=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "/eclient/SIGMA/Buscar.jsp?id=".toCharArray();
    __oracle_jsp_text[15] = 
    "&it=".toCharArray();
    __oracle_jsp_text[16] = 
    "\" WIDTH=\"100%\" HEIGHT=\"200\" frameborder=0></IFRAME>\n\t\t\t\t</div>\n\t\t\t</TD>\n\t\t</TR> \n\t</TBODY>\n</TABLE>\n</DIV>\n\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
