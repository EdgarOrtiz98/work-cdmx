package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.taglib.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _ExpedienteInstrccion extends com.orionserver.http.OrionHttpJspPage {


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
    _ExpedienteInstrccion page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	
      	String strAccion 			= "";
      	String strVal 				= "";
      	String strAreaUs 			= BUsuario.getIdArea();
      	String strIdExpediente		= "";
      	String strDescExpediente	= "";
      	String strFolioRecepcion	= "";
      	String strDatosExpInst[][] 	= null;
      
      	String strInstruccion = (request.getParameter("ida")!= null)?request.getParameter("ida"):"";
      	String strIdAsunto = (request.getParameter("strIdAsunto")!= null)?request.getParameter("strIdAsunto"):"";
              String editable = (request.getParameter("editable") != null)?request.getParameter("editable"):"true";
              
      
      	strAreaUs	=	BUsuario.getIdArea();
      	String strTipo	=	(request.getParameter("cls")!= null)?request.getParameter("cls"):"0";
      
         	String var[][] =	ActualizaExpArchivado.getDatosValorDeta(strTipo);
      	if (var.length >0) 
      	{
      		strVal = var[0][0];
      	}
      	else 
      	{
      	strVal = "0";
      	}
      	
      	strAccion	=	request.getParameter("accion");
      	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("guardar")){
      		strInstruccion = request.getParameter("idInst");
      		strIdExpediente = request.getParameter("asuntoExpediente");
      
      		if(strInstruccion!=null && strInstruccion.length()>0){
      			strDatosExpInst = ActualizaExpArchivado.getExpedienteInst(strInstruccion);
      			if (strDatosExpInst!=null && strDatosExpInst.length>0){
      				ActualizaBitacora.InsertarEventoAsignacionExpedienteInst(BUsuario.getIdUsuario(),strInstruccion,strDatosExpInst);
      			}
      			ActualizaExpArchivado.insertarExpInstruccion(strInstruccion, strIdExpediente);
      		}else if(strIdAsunto!=null && strIdAsunto.length()>0){
      			strDatosExpInst = ActualizaExpArchivado.getExpedienteAsunto(strIdAsunto);
      			if (strDatosExpInst!=null && strDatosExpInst.length>0){
      				ActualizaBitacora.InsertarEventoAsignacionExpedienteAsu(BUsuario.getIdUsuario(),strIdAsunto,strDatosExpInst);
      			}
      			ActualizaExpArchivado.insertarExpAsunto(strIdAsunto, strIdExpediente);
      		}
      	}
      
      	if(strInstruccion!=null && strInstruccion.length()>0){
      		strDatosExpInst = ActualizaExpArchivado.getExpedienteInst(strInstruccion);
      	}else if(strIdAsunto!=null && strIdAsunto.length()>0){
      		strDatosExpInst = ActualizaExpArchivado.getExpedienteAsunto(strIdAsunto);
      	}
      	if (strDatosExpInst!=null && strDatosExpInst.length>0){
      		strIdExpediente			=	strDatosExpInst[0][0];
      		strDescExpediente		=	strDatosExpInst[0][1];
      		strFolioRecepcion		= 	strDatosExpInst[0][2];
      	}
      
      
      out.write(__oracle_jsp_text[5]);
      out.print(strInstruccion);
      out.write(__oracle_jsp_text[6]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[7]);
      out.print(editable);
      out.write(__oracle_jsp_text[8]);
       if(editable.equalsIgnoreCase("true")) {
      out.write(__oracle_jsp_text[9]);
       if(strInstruccion != null && strInstruccion.trim().length()>0){ 
      out.write(__oracle_jsp_text[10]);
      
      						boolean bExisteExp = false;
      						String strExpedienteArea[][] = null; 
      						String strExpedienteGral[][] = null;
      						strExpedienteArea = ComboData.getExpedienteCombo(strAreaUs);
      						strExpedienteGral = ComboData.getExpedienteComboGral();
      						bExisteExp = ActualizaExpediente.getExisteExpedientesPorAreaArch(strAreaUs);
      					
      out.write(__oracle_jsp_text[11]);
       for(int z=0;z<strExpedienteArea.length;z++){ 
      out.write(__oracle_jsp_text[12]);
      out.print(strExpedienteArea[z][0]);
      out.write(__oracle_jsp_text[13]);
      out.print((strIdExpediente.trim().equals(strExpedienteArea[z][0])?"selected":""));
      out.write(__oracle_jsp_text[14]);
      out.print(strExpedienteArea[z][1]);
      out.write(__oracle_jsp_text[15]);
       } 
      out.write(__oracle_jsp_text[16]);
       }else{ 
      out.write(__oracle_jsp_text[17]);
      
      						boolean bExisteExp = false;
      						String strExpedienteArea[][] = null;
      						String strExpedienteGral[][] = null;
      						strExpedienteArea = ComboData.getExpedienteCombo(strAreaUs);
      						strExpedienteGral = ComboData.getExpedienteComboGral();
      						bExisteExp = ActualizaExpediente.getExisteExpedientesPorArea(strAreaUs);
      					
      out.write(__oracle_jsp_text[18]);
       for(int z=0;z<strExpedienteArea.length;z++){ 
      out.write(__oracle_jsp_text[19]);
      out.print(strExpedienteArea[z][0]);
      out.write(__oracle_jsp_text[20]);
      out.print((strIdExpediente.trim().equals(strExpedienteArea[z][0])?"selected":""));
      out.write(__oracle_jsp_text[21]);
      out.print(strExpedienteArea[z][1]);
      out.write(__oracle_jsp_text[22]);
       } 
      out.write(__oracle_jsp_text[23]);
       } 
      out.write(__oracle_jsp_text[24]);
      }
      out.write(__oracle_jsp_text[25]);
      out.print(strDescExpediente);
      out.write(__oracle_jsp_text[26]);

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
  private static final char __oracle_jsp_text[][]=new char[27][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[4] = 
    " \n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/link.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\" src=\"../js/link.js\"></script>\n<TITLE>ExpedienteInstrccion.jsp</TITLE>\n</HEAD>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\nfunction Consec(con) { \n\n\t}\nfunction AgregarExpInst(){ \t\n\n\t\tdocument.expedienteInst.accion.value=\"guardar\";\n\t\tdocument.expedienteInst.submit();\n\t\t}\n</SCRIPT>\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n<FORM name=\"expedienteInst\" action=\"ExpedienteInstrccion.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<input name=\"tmpCopyToRef\" type=\"hidden\" value=\"\">\n<input name=\"idsCC\" type=\"hidden\" value=\"\">\n<input name=\"idInst\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\">\n<input name=\"strIdAsunto\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\">\n<input name=\"editable\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\">\n\n\n<DIV align=\"center\">\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n    ".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Seleccione Expediente:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t\t<SELECT name=\"asuntoExpediente\" class=\"blue500a\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    " \n\t\t\t\t\t<OPTION value=\"null\">----- Expedientes de la Unidad Administrativa -----</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" ".toCharArray();
    __oracle_jsp_text[14] = 
    ">".toCharArray();
    __oracle_jsp_text[15] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t\t\t\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t<SELECT name=\"asuntoExpediente\" class=\"blue500a\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t\t\t<OPTION value=\"null\">------ Expedientes de la Unidad Administrativa ------</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\" ".toCharArray();
    __oracle_jsp_text[21] = 
    ">".toCharArray();
    __oracle_jsp_text[22] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t\t\t\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t</FONT> \n\t\t\t<INPUT type=\"button\" style=\"width:65;height:20;font: bold 12px Arial\" onclick=\"AgregarExpInst('');\"  value=\"Asignar\">\n\t\t</TD>\n\t</TR>\n        ".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Expediente Asignado:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">".toCharArray();
    __oracle_jsp_text[26] = 
    "</FONT>\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
