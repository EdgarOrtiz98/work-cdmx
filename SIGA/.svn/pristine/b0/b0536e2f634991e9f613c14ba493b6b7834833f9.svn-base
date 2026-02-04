package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;


public class _BuscarCampo extends com.orionserver.http.OrionHttpJspPage {


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
    _BuscarCampo page = this;
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
      for(int i=0;i<24;i++){
      out.write(__oracle_jsp_text[4]);
      
      				String a = String.valueOf(i);
      				if(a.length()==1)
      					a="0"+a;
      				
      out.write(__oracle_jsp_text[5]);
      out.print(a);
      out.write(__oracle_jsp_text[6]);
      out.print(a);
      out.write(__oracle_jsp_text[7]);
      }
      out.write(__oracle_jsp_text[8]);
      for(int i=0;i<60;i++){
      out.write(__oracle_jsp_text[9]);
      
      				String a = String.valueOf(i);
      				if(a.length()==1)
      					a="0"+a;
      				
      out.write(__oracle_jsp_text[10]);
      out.print(a);
      out.write(__oracle_jsp_text[11]);
      out.print(a);
      out.write(__oracle_jsp_text[12]);
      }
      out.write(__oracle_jsp_text[13]);
      for(int i=0;i<24;i++){
      out.write(__oracle_jsp_text[14]);
      
      				String a = String.valueOf(i);
      				if(a.length()==1)
      					a="0"+a;
      				
      out.write(__oracle_jsp_text[15]);
      out.print(a);
      out.write(__oracle_jsp_text[16]);
      out.print( (a.equals("23"))?"selected=\"selected\"":"" );
      out.write(__oracle_jsp_text[17]);
      out.print(a);
      out.write(__oracle_jsp_text[18]);
      }
      out.write(__oracle_jsp_text[19]);
      for(int i=0;i<60;i++){
      out.write(__oracle_jsp_text[20]);
      
      				String a = String.valueOf(i);
      				if(a.length()==1)
      					a="0"+a;
      				
      out.write(__oracle_jsp_text[21]);
      out.print(a);
      out.write(__oracle_jsp_text[22]);
      out.print( (a.equals("59"))?"selected=\"selected\"":"" );
      out.write(__oracle_jsp_text[23]);
      out.print(a);
      out.write(__oracle_jsp_text[24]);
      }
      out.write(__oracle_jsp_text[25]);
      for(int i=0;i<24;i++){
      out.write(__oracle_jsp_text[26]);
      
      				String a = String.valueOf(i);
      				if(a.length()==1)
      					a="0"+a;
      				
      out.write(__oracle_jsp_text[27]);
      out.print(a);
      out.write(__oracle_jsp_text[28]);
      out.print(a);
      out.write(__oracle_jsp_text[29]);
      }
      out.write(__oracle_jsp_text[30]);
      for(int i=0;i<60;i++){
      out.write(__oracle_jsp_text[31]);
      
      				String a = String.valueOf(i);
      				if(a.length()==1)
      					a="0"+a;
      				
      out.write(__oracle_jsp_text[32]);
      out.print(a);
      out.write(__oracle_jsp_text[33]);
      out.print(a);
      out.write(__oracle_jsp_text[34]);
      }
      out.write(__oracle_jsp_text[35]);
      for(int i=0;i<24;i++){
      out.write(__oracle_jsp_text[36]);
      
      				String a = String.valueOf(i);
      				if(a.length()==1)
      					a="0"+a;
      				
      out.write(__oracle_jsp_text[37]);
      out.print(a);
      out.write(__oracle_jsp_text[38]);
      out.print( (a.equals("23"))?"selected=\"selected\"":"" );
      out.write(__oracle_jsp_text[39]);
      out.print(a);
      out.write(__oracle_jsp_text[40]);
      }
      out.write(__oracle_jsp_text[41]);
      for(int i=0;i<60;i++){
      out.write(__oracle_jsp_text[42]);
      
      				String a = String.valueOf(i);
      				if(a.length()==1)
      					a="0"+a;
      				
      out.write(__oracle_jsp_text[43]);
      out.print(a);
      out.write(__oracle_jsp_text[44]);
      out.print( (a.equals("59"))?"selected=\"selected\"":"" );
      out.write(__oracle_jsp_text[45]);
      out.print(a);
      out.write(__oracle_jsp_text[46]);
      }
      out.write(__oracle_jsp_text[47]);

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
  private static final char __oracle_jsp_text[][]=new char[48][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<SCRIPT language=JavaScript type=text/javascript>\t\n\tfunction activaBusqueda(){\n\t\tdoc = document.buscarC;\t\n\t\tif (doc.buscaContenido.checked == true){\t\t\t\n\t\t\tdoc.buscaSobreContenido.style.visibility = \"visible\";\n\t\t\tdoc.bContenido.value=1;\n\t\t}else{\n\t\t\tdoc.buscaSobreContenido.style.visibility = \"hidden\";\n\t\t\tdoc.bContenido.value=0;\n\t\t}\n\t}\n\n\tfunction activaCampos(){\n\t\tdoc = document.buscarC;\n\n\t\tif (doc.buscaFechaRecI.value!=\"\"){\n\t\t\tdoc.horaRecepcionI.disabled\t= false;\n\t\t\tdoc.minRecepcionI.disabled\t= false;\n\t\t}else{\n\t\t\tdoc.horaRecepcionI.disabled\t= true;\n\t\t\tdoc.minRecepcionI.disabled\t= true;\n\t\t}\n\n\t\tif (doc.buscaFechaRecF.value!=\"\"){\n\t\t\tdoc.horaRecepcionF.disabled\t= false;\n\t\t\tdoc.minRecepcionF.disabled\t= false;\n\t\t}else{\n\t\t\tdoc.horaRecepcionF.disabled\t= true;\n\t\t\tdoc.minRecepcionF.disabled\t= true;\n\t\t}\n\n\t\tif (Trim(doc.relacionAnexada.value)!=\"\"){\n\t\t\tdoc.tipoRelacion[0].disabled = false;\n\t\t\tdoc.tipoRelacion[1].disabled = false;\n\t\t\tdoc.tipoRelacion[2].disabled = false;\n\t\t}else{\n\t\t\tdoc.tipoRelacion[0].disabled = true;\n\t\t\tdoc.tipoRelacion[1].disabled = true;\n\t\t\tdoc.tipoRelacion[2].disabled = true;\n\t\t\t\n\t\t\tdoc.tipoRelacion[0].checked = true;\n\t\t\tdoc.tipoRelacion[1].checked = true;\n\t\t\tdoc.tipoRelacion[2].checked = true;\n\t\t}\n\n\t\tif (doc.buscaFechaEveI.value!=\"\"){\n\t\t\tdoc.horaEventoI.disabled\t= false;\n\t\t\tdoc.minEventoI.disabled\t\t= false;\n\t\t}else{\n\t\t\tdoc.horaEventoI.disabled\t= true;\n\t\t\tdoc.minEventoI.disabled\t\t= true;\n\t\t}\n\n\t\tif (doc.buscaFechaEveF.value!=\"\"){\n\t\t\tdoc.horaEventoF.disabled\t= false;\n\t\t\tdoc.minEventoF.disabled\t\t= false;\n\t\t}else{\n\t\t\tdoc.horaEventoF.disabled\t= true;\n\t\t\tdoc.minEventoF.disabled\t\t= true;\n\t\t}\n\t}\n</SCRIPT>\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Buscar por Asunto</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load(); activaCampos(); \" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\" onmousemove=\"activaCampos()\">\n\n<form method=\"post\" action=\"BuscarCampoBean.jsp\" name=\"buscarC\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TBODY>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"208\"><input type=\"button\" onclick=\"regresarBuscar()\"\n\t\t\t\tvalue=\"Limpiar Pantalla\" class=\"blue200\">&nbsp;</td>\n\t\t\t<td width=\"208\"><input type=\"button\"  onclick=\"BurcarCampo()\" \n\t\t\t\tvalue=\"Buscar\" class=\"blue100\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\" align=\"right\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"> Ayuda:&nbsp;\n\t\t\t\t<A title=\"Para hacer una busqueda exacta escriba el criterio (p.ej. Asunto interno de CGTIC)\">\n\t\t\t\t<U>Busqueda exacta</U> &nbsp;</A>\n\t\t\t\t<A title=\"Para hacer una busqueda multicriterio escriba los criterios separados por comas (p.ej. CGTIC, instrucción rechazada, Asunto interno)\">\n\t\t\t\t<U>Busqueda multicriterio</U> &nbsp; </A> </td>\n\t\t</tr>\n\t</TBODY>\n</table>\n</DIV>\n<br>\n<DIV align=\"center\">\n</DIV>\n<BR>\n<DIV class=documentBody id=Body>\n<DIV align=\"center\">\n<table width=\"863\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n\t<TBODY>\n\t\t<tr>\n\t\t\t<td colspan=\"2\">\n\t\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">Busqueda por Asuntos</font></b>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr><td bgcolor=\"#004080\" colspan=\"2\"></td></tr>\n\t\t<tr><td bgcolor=\"#004080\" colspan=\"2\"></td></tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Folio de Recepción:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaFolio\"  value=\"\" class=\"blue500\" maxlength=\"100\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Folio de Control:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaFolioControl\" value=\"\" class=\"blue500\" maxlength=\"200\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Estatus del Asunto:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaEstatus\" type=\"checkbox\" value=\"0\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">En Recepción&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t\t<input name=\"buscaEstatus\" type=\"checkbox\" value=\"1\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Por Turnar&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t\t<input name=\"buscaEstatus\" type=\"checkbox\" value=\"2\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">En Tramite&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t\t<input name=\"buscaEstatus\" type=\"checkbox\" value=\"3\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Terminado&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha de Captura:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Del&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaCapI\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\"\n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaCapI\");'></a> \n\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;al&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaCapF\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\"\n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaCapF\");'></a> \n\t\t\t\t<font size=\"1\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;(DD/MM/AAAA)</font>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha de terminación:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Del&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaTerI\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\"\n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaTerI\");'></a> \n\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;al&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaTerF\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\"\n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaTerF\");'></a> \n\t\t\t\t<font size=\"1\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;(DD/MM/AAAA)</font>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Puesto que Capturó el Asunto:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaCaptura\" value=\"\" class=\"blue500\" maxlength=\"100\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Relaciones Anexadas<BR>(Folio de Recepción)</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"relacionAnexada\" value=\"\" class=\"blue500\" maxlength=\"100\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Tipo de Relacion</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"tipoRelacion\" type=\"checkbox\" value=\"r\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Respuesta&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t\t<input name=\"tipoRelacion\" type=\"checkbox\" value=\"f\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Referencia&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t\t<input name=\"tipoRelacion\" type=\"checkbox\" value=\"a\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Alcance&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Avance:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Del&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"avanceAsuntoI\" value=\"\" class=\"blue100\" maxlength=\"200\" onkeypress=\"AceptaSoloTeclaNumericaYPunto()\">&nbsp;% \n\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;al&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"avanceAsuntoF\" value=\"\" class=\"blue100\" maxlength=\"200\" onkeypress=\"AceptaSoloTeclaNumericaYPunto()\">&nbsp;% \n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Semaforo:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"semaforoAsunto\" type=\"checkbox\" value=\"v\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Verde&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t\t<input name=\"semaforoAsunto\" type=\"checkbox\" value=\"a\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Amarillo&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t\t<input name=\"semaforoAsunto\" type=\"checkbox\" value=\"r\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Rojo&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td colspan=\"2\">\n\t\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">Campos capturados del Asunto</font></b>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr><td bgcolor=\"#004080\" colspan=\"2\"></td></tr>\n\t\t<tr><td bgcolor=\"#004080\" colspan=\"2\"></td></tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Entidad:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaEntidad\"  value=\"\" class=\"blue500\" maxlength=\"200\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Remitente:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaRemitente\"  value=\"\" class=\"blue500\" maxlength=\"200\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Firmante:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaFirmante\"  value=\"\" class=\"blue500\" maxlength=\"200\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Supervisor de la Ventanilla:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaVentanilla\"  value=\"\" class=\"blue500\" maxlength=\"200\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Documento de:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"controlFolio\" type=\"checkbox\" value=\"0\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Entrada&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t\t<input name=\"controlFolio\" type=\"checkbox\" value=\"1\" checked=\"checked\">&nbsp;\n\t\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Salida&nbsp;&nbsp;&nbsp;&nbsp;</font>\t\t\t\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Destinatarios:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaPara\"  value=\"\" class=\"blue500\" maxlength=\"200\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Asunto:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaAsunto\" value=\"\" class=\"blue500\" maxlength=\"200\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Tipo de Documento:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaTipoDoc\"  value=\"\" class=\"blue500\" maxlength=\"200\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha de Recepción:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Del&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaRecI\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\"\n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaRecI\");'></a> \n\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;al&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaRecF\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\"\n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaRecF\");'></a> \n\t\t\t\t<font size=\"1\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;(DD/MM/AAAA)</font>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Hora de Recepción:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Del&nbsp;&nbsp;</font>\n\t\t\t<SELECT name=\"horaRecepcionI\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[4] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\">".toCharArray();
    __oracle_jsp_text[7] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\t\t</SELECT>\n\t\t\t<FONT face=\"Verdana\" size=\"2\">:</FONT>\n\t\t\t<SELECT name=\"minRecepcionI\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\">".toCharArray();
    __oracle_jsp_text[12] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t</SELECT>\n\n\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;&nbsp;al&nbsp;&nbsp;</font>\n\t\t\t<SELECT name=\"horaRecepcionF\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" ".toCharArray();
    __oracle_jsp_text[17] = 
    ">".toCharArray();
    __oracle_jsp_text[18] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t</SELECT>\n\t\t\t<FONT face=\"Verdana\" size=\"2\">:</FONT>\n\t\t\t<SELECT name=\"minRecepcionF\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\" ".toCharArray();
    __oracle_jsp_text[23] = 
    ">".toCharArray();
    __oracle_jsp_text[24] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t</SELECT>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha de Documento:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Del&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaDocI\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\"\n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaDocI\");'></a> \n\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;al&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaDocF\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\"\n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaDocF\");'></a> \n\t\t\t\t<font size=\"1\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;(DD/MM/AAAA)</font>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Trámite:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaTramite\"  value=\"\" class=\"blue500\" maxlength=\"200\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha de Compromiso:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Del&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaComI\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\"\n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaComI\");'></a> \n\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;al&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaComF\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\"\n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaComF\");'></a> \n\t\t\t\t<font size=\"1\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;(DD/MM/AAAA)</font>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Identificador del Documento:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaIdDoc\" value=\"\" class=\"blue500\" maxlength=\"100\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Folio Intermedio:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaFolioInter\" value=\"\" class=\"blue500\" maxlength=\"100\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Descripción:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaSolicitud\" value=\"\" class=\"blue500\" maxlength=\"100\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Comentarios:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaComentario\" value=\"\" class=\"blue500\" maxlength=\"100\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Palabra Clave:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaPalabraClave\" value=\"\" class=\"blue500\" maxlength=\"100\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n \t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Expediente:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaExpediente\" value=\"\" class=\"blue500\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha del Evento:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Del&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaEveI\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\"\n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaEveI\");'></a> \n\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;al&nbsp;&nbsp;</font>\n\t\t\t\t<input name=\"buscaFechaEveF\" class=\"blue100\" onfocus=\"blur()\"> \n\t\t\t\t<a><img src=\"../Imagenes/act_calFormat.gif\" border=\"0\" alt=\"Selecciona una Fecha\"\n\t\t\t\tonclick='show_calendar(\"forms[0].buscaFechaEveF\");'></a> \n\t\t\t\t<font size=\"1\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;(DD/MM/AAAA)</font>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Hora del Evento:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Del&nbsp;&nbsp;</font>\n\t\t\t<SELECT name=\"horaEventoI\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[28] = 
    "\">".toCharArray();
    __oracle_jsp_text[29] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t</SELECT>\n\t\t\t<FONT face=\"Verdana\" size=\"2\">:</FONT>\n\t\t\t<SELECT name=\"minEventoI\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[33] = 
    "\">".toCharArray();
    __oracle_jsp_text[34] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t</SELECT>\n\n\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">&nbsp;&nbsp;&nbsp;al&nbsp;&nbsp;</font>\n\t\t\t<SELECT name=\"horaEventoF\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[38] = 
    "\" ".toCharArray();
    __oracle_jsp_text[39] = 
    ">".toCharArray();
    __oracle_jsp_text[40] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t</SELECT>\n\t\t\t<FONT face=\"Verdana\" size=\"2\">:</FONT>\n\t\t\t<SELECT name=\"minEventoF\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[44] = 
    "\" ".toCharArray();
    __oracle_jsp_text[45] = 
    ">".toCharArray();
    __oracle_jsp_text[46] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t\t</SELECT>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Lugar del Evento:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaEvento\" value=\"\" class=\"blue500\" maxlength=\"100\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Prioridad:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaPrioridad\" value=\"\" class=\"blue500\" maxlength=\"100\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Tipo de Asunto:</font><BR>\n\t\t\t</td>\n\t\t\t<td width=\"700\">\n\t\t\t\t<input name=\"buscaTipoAsunto\" value=\"\" class=\"blue500\" maxlength=\"100\">\n\t\t\t</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td colspan=\"2\">\n\t\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">Busqueda en Contenido</font></b>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr><td bgcolor=\"#004080\" colspan=\"2\"></td></tr>\n\t\t<tr><td bgcolor=\"#004080\" colspan=\"2\"></td></tr>\n\t\t\n\t\t<tr>\n\t\t\t<td width=\"163\">&nbsp;</td>\n\t\t\t<td width=\"700\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<input name=\"buscaContenido\" type=\"checkbox\" value=\"5\" onclick=\"activaBusqueda();\">&nbsp;\n\t\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Contenido: &nbsp;&nbsp;&nbsp;&nbsp;</font>\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<input name=\"bContenido\" value=\"0\" type=\"hidden\">\n\t\t\t\t<input name=\"buscaSobreContenido\" value=\"\" class=\"blue500\" maxlength=\"199\" style=\"visibility:hidden;\" >\n\t\t\t</td>\n\t\t</tr> \n\t</TBODY>\n</table>\n</DIV>\n<br>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n<br>\n</form>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
