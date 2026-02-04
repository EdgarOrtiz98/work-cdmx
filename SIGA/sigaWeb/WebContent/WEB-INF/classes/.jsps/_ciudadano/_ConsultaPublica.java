package _ciudadano;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.search.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.taglib.*;


public class _ConsultaPublica extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


	public static boolean par(int num)
    {
        boolean p = false;
        if (num % 2 == 0) 
        {
            p = true;
        }    
        return p;
    }

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
    _ConsultaPublica page = this;
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
      out.write(__oracle_jsp_text[3]);
      
      	int j = 0;
      	String strConsulta[][] = null;
      	String strAccion 		= 	"";
      	String strFechaInicio 	= 	"";
      	String strFechaFin 		= 	"";
      	String strSolicitud 	= 	"";
      	String strFolio			=	"";
      	String strFecha			=	"";
      	String strEstatus		=	"";
      	String strRespuesta		=	"";
      	String strArea			=	"";
      	String strTipoRespuesta	=	"";
      	
      	strAccion		=	request.getParameter("accion");
      	strFechaInicio	=	(request.getParameter("bi") != null)?request.getParameter("bi"):"";
      	strFechaFin		=	(request.getParameter("bf") != null)?request.getParameter("bf"):"";
      	strArea			=	(request.getParameter("ba") != null)?request.getParameter("ba"):"";
      	strTipoRespuesta=	(request.getParameter("btr") != null)?request.getParameter("btr"):"";
      
      	if(strAccion != null && strAccion.equals("consultar")){
      		
      		strFechaInicio	=	request.getParameter("bi");
      		strFechaFin		=	request.getParameter("bf");
      		strArea			=	request.getParameter("ba");
      		strTipoRespuesta=	request.getParameter("btr");
      		//strConsulta		=	ActualizaBuscar.getConsultaCiudadano(strFechaInicio, strFechaFin);
      		try{
      			response.sendRedirect("ConsultaPublica.jsp?bi="+strFechaInicio+"&bf="+strFechaFin+"&ba="+strArea+"&btr="+strTipoRespuesta);
      		}catch(java.io.IOException io){
      			//System.err.println("Error redireccion-->"+io);
      		}
      	}
      	if(strFechaInicio.length() > 0 && strFechaInicio != null
      		&& strFechaFin.length() > 0 && strFechaFin != null){
      		strConsulta	=	ActualizaBuscar.getConsultaCiudadanoTerminados(strFechaInicio, strFechaFin, 
      																strTipoRespuesta, strArea); 
      	}
      	
      
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      
      				String strTipoRespuestas[][] = null;
      				strTipoRespuestas = ComboData.getTipoRespuestaCombo();
      			
      out.write(__oracle_jsp_text[6]);
       for(int i=0;i<strTipoRespuestas.length;i++){ 
      out.write(__oracle_jsp_text[7]);
      out.print(strTipoRespuestas[i][0]);
      out.write(__oracle_jsp_text[8]);
      out.print(strTipoRespuestas[i][1]);
      out.write(__oracle_jsp_text[9]);
       } 
      out.write(__oracle_jsp_text[10]);
      
      				String strAreas[][] = null;
      				strAreas = ActualizaArea.getAreasCiudadano();
      			
      out.write(__oracle_jsp_text[11]);
       for(int i=0;i<strAreas.length;i++){ 
      out.write(__oracle_jsp_text[12]);
      out.print(strAreas[i][0]);
      out.write(__oracle_jsp_text[13]);
      out.print(strAreas[i][1]);
      out.write(__oracle_jsp_text[14]);
       } 
      out.write(__oracle_jsp_text[15]);
       if(strConsulta != null){ 
      out.write(__oracle_jsp_text[16]);
      out.print(strConsulta.length);
      out.write(__oracle_jsp_text[17]);
       if(strConsulta.length > 0){ 
      out.write(__oracle_jsp_text[18]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(strConsulta);
        __jsp_taghandler_1.setCampo("campo");
        java.lang.String campo1 = null;
        java.lang.String campo2 = null;
        java.lang.String campo3 = null;
        java.lang.String campo4 = null;
        java.lang.String campo5 = null;
        java.lang.String campo6 = null;
        java.lang.String campo7 = null;
        java.lang.String campo8 = null;
        java.lang.String campo9 = null;
        java.lang.String campo10 = null;
        java.lang.String campo11 = null;
        java.lang.String campo12 = null;
        java.lang.String campo13 = null;
        java.lang.String campo14 = null;
        java.lang.String campo15 = null;
        java.lang.String campo16 = null;
        java.lang.String campo17 = null;
        java.lang.String campo18 = null;
        java.lang.String campo19 = null;
        java.lang.String campo20 = null;
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_1,__jsp_tag_starteval,out);
          do {
            campo1 = (java.lang.String) pageContext.findAttribute("campo1");
            campo2 = (java.lang.String) pageContext.findAttribute("campo2");
            campo3 = (java.lang.String) pageContext.findAttribute("campo3");
            campo4 = (java.lang.String) pageContext.findAttribute("campo4");
            campo5 = (java.lang.String) pageContext.findAttribute("campo5");
            campo6 = (java.lang.String) pageContext.findAttribute("campo6");
            campo7 = (java.lang.String) pageContext.findAttribute("campo7");
            campo8 = (java.lang.String) pageContext.findAttribute("campo8");
            campo9 = (java.lang.String) pageContext.findAttribute("campo9");
            campo10 = (java.lang.String) pageContext.findAttribute("campo10");
            campo11 = (java.lang.String) pageContext.findAttribute("campo11");
            campo12 = (java.lang.String) pageContext.findAttribute("campo12");
            campo13 = (java.lang.String) pageContext.findAttribute("campo13");
            campo14 = (java.lang.String) pageContext.findAttribute("campo14");
            campo15 = (java.lang.String) pageContext.findAttribute("campo15");
            campo16 = (java.lang.String) pageContext.findAttribute("campo16");
            campo17 = (java.lang.String) pageContext.findAttribute("campo17");
            campo18 = (java.lang.String) pageContext.findAttribute("campo18");
            campo19 = (java.lang.String) pageContext.findAttribute("campo19");
            campo20 = (java.lang.String) pageContext.findAttribute("campo20");
            out.write(__oracle_jsp_text[19]);
             j++; 
            out.write(__oracle_jsp_text[20]);
            if(par(j)==true){
            }else{
            out.write(__oracle_jsp_text[21]);
            }
            out.write(__oracle_jsp_text[22]);
            out.print(campo1);
            out.write(__oracle_jsp_text[23]);
            out.print(campo2);
            out.write(__oracle_jsp_text[24]);
             
            					//boolean bexiste = false;
            					//bexiste = ActualizaCiudadano.getExistenNotificaciones(campo3);
            					//if(bexiste){ 
            					//	String strS[][] = null;
            					//	strS = ActualizaCiudadano.getDatosNotificacion(campo3);
            					//	for(int s=0;s<strS.length;s++){
            				
            out.write(__oracle_jsp_text[25]);
            out.print(campo3);
            out.write(__oracle_jsp_text[26]);
            out.print(ActualizaTipoRespuesta.getNombreTipoRespuesta(campo4)[0][0]);
            out.write(__oracle_jsp_text[27]);
            out.print(campo6);
            out.write(__oracle_jsp_text[28]);
            out.print(ActualizaEstatus.getNombreEstatus(campo5)[0][0]);
            out.write(__oracle_jsp_text[29]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[30]);
       }else{ 
      out.write(__oracle_jsp_text[31]);
       } 
      out.write(__oracle_jsp_text[32]);
       } 
      out.write(__oracle_jsp_text[33]);

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
  private static final char __oracle_jsp_text[][]=new char[34][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>ConsultaPublica.jsp</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n<FORM name=\"consultaPublicaForm\" action=\"ConsultaPublica.jsp\" method=\"post\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"#004080\" size=\"2\">\n\t\t\tConsulta Pública</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"380\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#00204f\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br><br>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">\n\t\t<div align=\"right\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha Inicio:&nbsp;&nbsp;</font></b>\n\t\t</div>\n\t\t</td>\n\t\t<td width=\"233\" valign=\"middle\"><font size=\"2\" face=\"Arial\"> <input\n\t\t\tname=\"bi\" value=\"\" onfocus=\"blur()\" onkeydown=\"\"\n\t\t\tclass=\"blue100\"> </font><a><img src=\"../Imagenes/cal.gif\" border=\"0\"\n\t\t\talt=\"Selecciona una Fecha\" width=\"16\" height=\"16\"\n\t\t\tonclick='show_calendar(\"forms[1].bi\");'></a> <font\n\t\t\tsize=\"1\" color=\"#004080\" face=\"Arial\">(dd/mm/aaaa)</font>\n\t\t\t<!-- <input type=\"button\" onclick=\"\" value=\"\" class=\"s-dropdown-btn\"> -->\n\t\t</td>\n\t\t<td width=\"171\">\n\t\t<div align=\"right\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha Fin:&nbsp;&nbsp;</font></b>\n\t\t</div>\n\t\t</td>\n\t\t<td valign=\"middle\" width=\"275\"><font size=\"2\" face=\"Arial\"> <input\n\t\t\tname=\"bf\" value=\"\" onfocus=\"\" onclick=\"blur()\" class=\"blue100\">\n\t\t</font><a><img src=\"../Imagenes/cal.gif\" border=\"0\"\n\t\t\talt=\"Selecciona una Fecha\" width=\"16\" height=\"16\"\n\t\t\tonclick='show_calendar(\"forms[1].bf\");'></a> <font\n\t\t\tsize=\"1\" color=\"#004080\" face=\"Arial\">(dd/mm/aaaa)</font> <!-- <input type=\"button\" onclick=\"\" value=\"\" class=\"s-dropdown-btn\"> -->\n\t\t</td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"171\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"275\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\" align=\"left\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Por Tipo de Respuesta:</FONT>&nbsp;&nbsp;</b></TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT SIZE=2 FACE=\"Verdana\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[6] = 
    "\n\t\t\t<SELECT name=\"btr\" class=\"blue500\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\">\n\t\t\t\t<OPTION value=\"-1\">--TODAS--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\">".toCharArray();
    __oracle_jsp_text[9] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"171\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"275\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\" align=\"left\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">área:</FONT>&nbsp;&nbsp;</b></TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT SIZE=2 FACE=\"Verdana\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\t<SELECT name=\"ba\" class=\"blue500\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\">\n\t\t\t\t<OPTION value=\"-1\">--TODAS--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\">".toCharArray();
    __oracle_jsp_text[14] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"171\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"275\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n</TBODY>\n</table>\n<br>\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD>\n\t\t\t<INPUT \tname=\"consulta\" value=\"Consultar\" \n\t\t\t\t\ttype=\"button\" class=\"blue200\" onclick=\"consultaBuscar()\">\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n<br>\n<br>\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD width=\"283\"><b><FONT size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\tResultados: </FONT></b></TD>\n\t\t<td width=\"133\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR>\n\t\t<td width=\"863\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD width=\"283\"><b><FONT size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tNumero de Resultados: ".toCharArray();
    __oracle_jsp_text[17] = 
    "</FONT></b></TD>\n\t\t<td width=\"133\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE border=\"0\" width=\"863\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD align=\"left\"><FONT size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\t\tDar click al <b><u>Folio</u></b> para consultar Solicitud. Dar click en <b><u>Tipo de Respuesta</u></b></FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<table border=\"0\" width=\"863\">\n<TBODY>\n\t<TR bgcolor=\"#00204f\">\n\t\t<td width=\"215\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Folio</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"218\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Tipo de Respuesta</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"215\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Fecha terminación</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"215\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Estatus</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t</TR>\n</TBODY>\n</table>\n<DIV class=documentBody id=Body>\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\n<table border=\"0\" width=\"863\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t<TR ".toCharArray();
    __oracle_jsp_text[21] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[22] = 
    ">\n\t\t<td width=\"215\">\n\t\t\t<CENTER>\n\t\t\t\t<A href=\"seguimientoConsulta.jsp?id_solicitud=".toCharArray();
    __oracle_jsp_text[23] = 
    "\">\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"verdana\">".toCharArray();
    __oracle_jsp_text[24] = 
    "</FONT>\n\t\t\t\t</A>\n\t\t\t</CENTER>\n\t\t</td>\n\n\t\t<td width=\"218\">\n\t\t\t<CENTER>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"verdana\">\n\t\t\t\t<A href=\"DetalleConsulta.jsp?id_solicitud=".toCharArray();
    __oracle_jsp_text[26] = 
    "\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t</A>\n\t\t\t\t</FONT><br>\n\t\t\t\t<!-- //}}else{ %>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"verdana\">No tiene Respuesta</FONT>\n\t\t\t\t//} %> -->\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"215\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"verdana\">".toCharArray();
    __oracle_jsp_text[28] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"215\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"verdana\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t<!-- \n\t\t\t\tif(campo5.equals(\"1\")){ %>\n\t\t\t\tPor Atender\n\t\t\t\t }else if(campo5.equals(\"2\")){ %>\n\t\t\t\tEn proceso\n\t\t\t\t }else if(campo5.equals(\"3\")){ %>\n\t\t\t\tTerminados\n\t\t\t\t } %> -->\n\t\t\t\t</FONT>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t\n\t\t<!-- <td width=\"172\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"verdana\">\n\t\t\t\t%\n\t\t\t\t\t//if(strArea.equals(\"-1\")){\n\t\t\t\t\t//\tString strAreasAtencion[][] = null;\n\t\t\t\t\t//\tstrAreasAtencion = ActualizaBuscar.getAreasAtencion(campo3);\n\t\t\t\t\t//\tif(strAreasAtencion.length > 0){\n\t\t\t\t\t//\t\tfor(int r = 0;r<strAreasAtencion.length;r++){\n\t\t\t\t%>\n\t\t\t\t\t%=//ActualizaArea.NombreArea(strAreasAtencion[r][0])%<br>\n\t\t\t\t\t% }}else{ %>\n\t\t\t\t\tNo se le ha generado ruta de atención\n\t\t\t\t% } }else{ %>\n\t\t\t\t\t%=campo7%>\n\t\t\t\t% } %>\n\t\t\t\t</FONT>\n\t\t\t</CENTER>\n\t\t</td>-->\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n</TBODY>\n</table>\n".toCharArray();
    __oracle_jsp_text[31] = 
    "\n<table border=\"0\" width=\"863\">\n<TBODY>\n\t<TR>\n\t\t<TD><b><FONT size=\"3\" color=\"#004080\" face=\"Arial\">** No se encontraron Registros **</FONT></b></TD>\n\t</TR>\n</TBODY>\n</table>\n".toCharArray();
    __oracle_jsp_text[32] = 
    "\n</DIV>\n".toCharArray();
    __oracle_jsp_text[33] = 
    "\n</DIV>\n<BR>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
