package _ciudadano;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;


public class _ConsultaCiudadano extends com.orionserver.http.OrionHttpJspPage {


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
    _ConsultaCiudadano page = this;
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
      com.meve.sigma.beans.AsuntoBean BAsunto;
      synchronized (pageContext) {
        if ((BAsunto = (com.meve.sigma.beans.AsuntoBean) pageContext.getAttribute( "BAsunto", PageContext.PAGE_SCOPE)) == null) {
          BAsunto = (com.meve.sigma.beans.AsuntoBean) new com.meve.sigma.beans.AsuntoBean();
          pageContext.setAttribute( "BAsunto", BAsunto, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      
      	BeanCiudadano BCiudadano = (BeanCiudadano)session.getAttribute("CiudadanoBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+11,strTmp.length());
      	if(BCiudadano==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
      	}
      
      out.write(__oracle_jsp_text[4]);
      
      	String strAccion 	=	"";
      	String strSolicitud =	"";
      	String strArchivo 	= 	"";
      	String strFecha		=	"";
      	String strFechaFol  =	"";
      	String strIdRem		=	"";
      	//String strTipoSol	=	"";
      	String strIdUsuario	=	BCiudadano.getIdUsuario();
      	String strNombre	=	BCiudadano.getNombre();
      	String strApellidoP	=	BCiudadano.getApellidoPaterno();
      	String strApellidoM	=	BCiudadano.getApellidoMaterno();
      	String strOcupacion	=	BCiudadano.getOcupacion();
      	String strMail		=	BCiudadano.getMail();
      
      	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f = new java.util.Date();
      	strFecha = sdf.format(f);
      
      	java.text.SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("ddMMyyyy");
      	java.util.Date f1 = new java.util.Date();
      	strFechaFol = sdf1.format(f1);
      
      	String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
      	String portServer = application.getInitParameter("PortMail");
      	String serverName = application.getInitParameter("servername");
      	String strItemType = application.getInitParameter("ItemType");
      	String strConfFolio =	application.getInitParameter("genFolio");
      
      	String strRutaBase = (application.getInitParameter("RutaBase")==null)?"":application.getInitParameter("RutaBase");
      	String url = strRutaBase+"/ciudadano/seguimiento.jsp?id_solicitud=";
      
      	String URL = serverName+url;
      	
      
      out.write(__oracle_jsp_text[5]);
      out.print(strIdUsuario);
      out.write(__oracle_jsp_text[6]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[7]);
      out.print(strApellidoP);
      out.write(__oracle_jsp_text[8]);
      out.print(strApellidoM);
      out.write(__oracle_jsp_text[9]);
      out.print(strOcupacion);
      out.write(__oracle_jsp_text[10]);
      out.print(strMail);
      out.write(__oracle_jsp_text[11]);
      out.print(serverMail);
      out.write(__oracle_jsp_text[12]);
      out.print(portServer);
      out.write(__oracle_jsp_text[13]);
      out.print(serverName);
      out.write(__oracle_jsp_text[14]);
      out.print(URL);
      out.write(__oracle_jsp_text[15]);
      out.print(strItemType);
      out.write(__oracle_jsp_text[16]);
      out.print(application.getInitParameter("content"));
      out.write(__oracle_jsp_text[17]);
      out.print(strConfFolio);
      out.write(__oracle_jsp_text[18]);
      out.print(BCiudadano.getNombre()+" "+BCiudadano.getApellidoPaterno()+" "+BCiudadano.getApellidoMaterno());
      out.write(__oracle_jsp_text[19]);
      out.print(BCiudadano.getDomicilio());
      out.write(__oracle_jsp_text[20]);
      out.print(BCiudadano.getPais());
      out.write(__oracle_jsp_text[21]);
      out.print(BCiudadano.getEstado());
      out.write(__oracle_jsp_text[22]);
      out.print(BCiudadano.getMunicipio());
      out.write(__oracle_jsp_text[23]);
      out.print(BCiudadano.getMail());
      out.write(__oracle_jsp_text[24]);
      out.print(BCiudadano.getTelefono());
      out.write(__oracle_jsp_text[25]);
      out.print(BCiudadano.getOcupacion());
      out.write(__oracle_jsp_text[26]);
      out.print(BCiudadano.getSector());
      out.write(__oracle_jsp_text[27]);

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
  private static final char __oracle_jsp_text[][]=new char[28][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<!-- Se hace una instancia al Bean del usuario para la Sesión -->\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript>\n\tfunction limpiarSol(){\n\t\tdocument.consultaForm.reset()\n\t\tdocument.consultaForm.solicitud.focus()\n\t\t//forma.solicitud.value == \"\";\n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0;limpiarSol();\">\n<!-- <FORM action=\"ConsultaCiudadano.jsp\" name=\"consultaForm\" method=\"post\"\n\tENCTYPE=\"multipart/form-data\">-->\n<FORM \taction=\"../CrearAsuntoCiudadano\" name=\"consultaForm\" \n\t\tmethod=\"post\" enctype=\"multipart/form-data\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\" name=\"id_ciudadano\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\" name=\"nombre\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\" name=\"AP\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\" name=\"AM\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\" name=\"ocupacion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\" name=\"mail\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"serverM\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"portS\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"serverName\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"url\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"ItemType\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"cm\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"confFol\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"PortalCiudadano.jsp\"> <IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/Regresar.gif\" width=\"82\" height=\"26\"> </a></TD>\n\t\t\t<TD width=\"125\"><a onclick=\"guardarSolicitud()\"> <img\n\t\t\t\tsrc=\"../Imagenes/Guardar.gif\" width=\"81\" border=\"0\" name=\"guardaImg\"> </a></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"293\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV class=documentBody id=Body>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Favor\n\t\t\tde anotar la Descripción de su solicitud</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"446\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#00204f\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t<TD align=\"right\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><I></I></FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<!-- <TR VALIGN=top>\n\t\t<TD width=\"144\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Tipo de\n\t\tSolicitud:</FONT></b></TD>\n\t\t<TD width=\"517\"><FONT SIZE=2 FACE=\"Verdana\"> <SELECT name=\"tipo_sol\"\n\t\t\tclass=\"blue200\">\n\t\t\t<OPTION value=\"1\">Pública</OPTION>\n\t\t\t<OPTION value=\"2\">Datos Personales</OPTION>\n\t\t\t<OPTION value=\"3\">Modificación de datos</OPTION>\n\t\t</SELECT> </FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"517\">&nbsp;</TD>\n\t</TR>-->\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos del Solicitante:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[19] = 
    "</FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Domicilio:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[20] = 
    "</FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Pais:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[21] = 
    "</FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Estado:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[22] = 
    "</FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Municipio:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[23] = 
    "</FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Correo Electrónico:</font></b>\n\t\t</td>\n\t\t<td width=\"233\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[24] = 
    "</font>\n\t\t</td>\n\t\t<td width=\"155\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Telefono:</font></b>\n\t\t</td>\n\t\t<td width=\"176\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[25] = 
    "</font><br></td>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Ocupación:</font></b>\n\t\t</td>\n\t\t<td width=\"233\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[26] = 
    "</font>\n\t\t</td>\n\t\t<td width=\"155\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Sector:</font></b>\n\t\t</td>\n\t\t<td width=\"176\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[27] = 
    "</font><br></td>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Detalle de la Solicitud:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\">Describa la información solicitada y proporcione todos aquellos\n\t\tdatos que considere puedan<br> facilitar su Búsqueda, con el fin de darle un mejor servicio.\n\t\t<INPUT name=\"solicitud1\" type=\"hidden\" class=\"blue500\" value=\"-\"></FONT></TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\"></FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\"><TEXTAREA name=\"solicitud\"\n\t\t\trows=\"9\" cols=\"70\" class=\"blue700\"></TEXTAREA></FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Anexar un\n\t\tarchivo(Opcional):</FONT></TD>\n\t\t<TD colspan=\"3\"><input class=\"blue500\" type=\"file\"\n\t\t\tname=\"solicitud_archivo\"></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n</TABLE>\n</DIV>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
