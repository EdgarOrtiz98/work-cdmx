package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;


public class _Buscar extends com.orionserver.http.OrionHttpJspPage {


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
    _Buscar page = this;
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
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+strTmp);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
      	}
      
      out.write(__oracle_jsp_text[3]);

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
  private static final char __oracle_jsp_text[][]=new char[4][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n\n<SCRIPT language=JavaScript type=text/javascript>\n\tfunction activaBusqueda(){\n\t\tdoc = document.buscarC;\t\n\t\tif (doc.buscaContenido.checked == true){\n\t\t\tdoc.buscaSobreContenido.style.visibility = \"visible\";\n\t\t\tdoc.bContenido.value=1;\n\t\t}else{\n\t\t\tdoc.buscaSobreContenido.style.visibility = \"hidden\"\n\t\t\tdoc.bContenido.value=0;\n\t\t}\n\t}\n</SCRIPT>\n\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Buscar por instrucción</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n\n<form method=\"post\" action=\"BuscarBean.jsp\" name=\"buscarC\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TBODY>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"208\"><input type=\"button\" onclick=\"regresarBuscarIns()\"\n\t\t\t\tvalue=\"Limpiar Pantalla\" class=\"blue200\">&nbsp;</td>\n\t\t\t<td width=\"208\"><input type=\"button\" onclick=\"BurcarCampoIns()\"\n\t\t\t\tvalue=\"Buscar\" class=\"blue100\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\" align=\"right\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"> Ayuda:&nbsp;\n\t\t\t\t<A title=\"Para hacer una busqueda exacta escriba el criterio (p.ej. Asunto interno de CGTIC)\">\n\t\t\t\t<U>Busqueda exacta</U> &nbsp;</A>\n\t\t\t\t<A title=\"Para hacer una busqueda multicriterio escriba los criterios separados por comas (p.ej. CGTIC, instrucción rechazada, Asunto interno)\">\n\t\t\t\t<U>Busqueda multicriterio</U> &nbsp; </A> </td>\n\t\t</tr>\n\t</TBODY>\n</table>\n</DIV>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TBODY>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Busqueda por Instrucciones</font></b></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"863\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</tr>\n\t</TBODY>\n</table>\n</DIV>\n<BR>\n<DIV class=documentBody id=Body>\n<DIV align=\"center\">\n<table width=\"863\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TBODY>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Folio de Recepción:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaFolio\" value=\"\" class=\"blue300\" maxlength=\"199\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Folio de Control:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaFolioControl\" value=\"\" class=\"blue300\" maxlength=\"199\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Folio Intermedio:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaFolioInter\" value=\"\" class=\"blue300\" maxlength=\"199\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Estatus de la instrucción</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaEstatus\" type=\"checkbox\" value=\"1\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Por Atender&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t\t<input name=\"buscaEstatus\" type=\"checkbox\" value=\"2\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">En Tramite&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t\t<input name=\"buscaEstatus\" type=\"checkbox\" value=\"3\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Rechazada&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t\t<input name=\"buscaEstatus\" type=\"checkbox\" value=\"4\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Terminada&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Avance:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Del&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"avanceAsuntoI\" value=\"\" class=\"blue100\" maxlength=\"200\" onkeypress=\"AceptaSoloTeclaNumericaYPunto()\">&nbsp;% \n\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;al&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"avanceAsuntoF\" value=\"\" class=\"blue100\" maxlength=\"200\" onkeypress=\"AceptaSoloTeclaNumericaYPunto()\">&nbsp;% \n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Semaforo:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"semaforoAsunto\" type=\"checkbox\" value=\"v\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Verde&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t\t<input name=\"semaforoAsunto\" type=\"checkbox\" value=\"a\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Amarillo&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t\t<input name=\"semaforoAsunto\" type=\"checkbox\" value=\"r\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Rojo&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Responsable:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaResponsable\"  value=\"\" class=\"blue500\" maxlength=\"199\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Tipo de atención:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaTipoAte\" type=\"checkbox\" value=\"0\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Ejecutor&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t\t<input name=\"buscaTipoAte\" type=\"checkbox\" value=\"1\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Informativo&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Asunto:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaAsunto\"  value=\"\" class=\"blue500\" maxlength=\"199\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha de generación:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Del&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaGenI\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\" \n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaGenI\");'></a> \n\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;al&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaGenF\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\" \n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaGenF\");'></a> \n\t\t\t\t<font size=\"1\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;(DD/MM/AAAA)</font>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha de Vencimiento:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Del&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaVenI\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\" \n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaVenI\");'></a> \n\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;al&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaVenF\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\" \n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaVenF\");'></a> \n\t\t\t\t<font size=\"1\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;(DD/MM/AAAA)</font>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Asignada por:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaAsignadaPor\" value=\"\" class=\"blue500\" maxlength=\"199\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">instrucción:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaNomIns\" value=\"\" class=\"blue500\" maxlength=\"199\">\n\t\t\t</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Expediente:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaExpediente\" value=\"\" class=\"blue500\" maxlength=\"199\">\n\t\t\t</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td colspan=\"2\">\n\t\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">Busqueda en Contenido</font></b>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr><td bgcolor=\"#004080\" colspan=\"2\"></td></tr>\n\t\t<tr><td bgcolor=\"#004080\" colspan=\"2\"></td></tr>\n\t\t\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<input name=\"buscaContenido\" type=\"checkbox\" value=\"5\" onclick=\"activaBusqueda();\">\n\t\t\t\t<input name=\"bContenido\" value=\"0\" type=\"hidden\">&nbsp;\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Contenido: &nbsp;&nbsp;&nbsp;&nbsp;</font>\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<input name=\"buscaSobreContenido\" value=\"\" class=\"blue500\" maxlength=\"199\" style=\"visibility:hidden;\" >\n\t\t\t</td>\n\t\t</tr>\n\n\t</TBODY>\n</table>\n</DIV>\n<br>\n</DIV>\n<script>\n\tvar bodyElement = document.getElementById('Body') ;\n\tfunction LayoutBodyElement() {  \n\t\tbodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;\n\t} \n\tfunction document.onreadystatechange() { \n\t\tdocument.body.scroll = \"no\" ; \n\t\tLayoutBodyElement( ) ;\n\t\twindow.onresize = LayoutBodyElement;\n\t}\n</script>\n<br>\n</form>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
