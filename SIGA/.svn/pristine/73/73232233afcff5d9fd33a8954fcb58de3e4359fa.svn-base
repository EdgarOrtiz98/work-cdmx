package _ciudadano;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.taglib.*;


public class _SolicitudUCT extends com.orionserver.http.OrionHttpJspPage {


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
    _SolicitudUCT page = this;
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
      com.meve.sigma.beans.AsuntoBean BAsunto;
      synchronized (pageContext) {
        if ((BAsunto = (com.meve.sigma.beans.AsuntoBean) pageContext.getAttribute( "BAsunto", PageContext.PAGE_SCOPE)) == null) {
          BAsunto = (com.meve.sigma.beans.AsuntoBean) new com.meve.sigma.beans.AsuntoBean();
          pageContext.setAttribute( "BAsunto", BAsunto, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+11,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("login.jsp?pagina="+ strTmp);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
      	}
      	////System.err.println("BusarioNombre-->"+BUsuario.getNombre());
      
      out.write(__oracle_jsp_text[5]);
      
      	String strAccion 	=	"";
      	String stridDestinatarioUCT = "";
      	String strMailUCT	=	"";
      	String strName		=	"";
      	String strMailCiu	=	"";
      	String strIdCiudadano=	"";
      	String strArea		=	"";
      
      	String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
      	String portServer = application.getInitParameter("PortMail");
      	String serverName = application.getInitParameter("servername");
      	String strItemType = application.getInitParameter("ItemType");
      	String strConfFolio =	application.getInitParameter("genFolio");
      
      	String strRutaBase = (application.getInitParameter("RutaBase")==null)?"":application.getInitParameter("RutaBase");
      	String url = strRutaBase+"/ciudadano/seguimientoUCT.jsp?id_solicitud=";
      	String URL = serverName+url;
      	
      
      out.write(__oracle_jsp_text[6]);
      out.print(strIdCiudadano);
      out.write(__oracle_jsp_text[7]);
      out.print(serverMail);
      out.write(__oracle_jsp_text[8]);
      out.print(portServer);
      out.write(__oracle_jsp_text[9]);
      out.print(serverName);
      out.write(__oracle_jsp_text[10]);
      out.print(URL);
      out.write(__oracle_jsp_text[11]);
      out.print(application.getInitParameter("content"));
      out.write(__oracle_jsp_text[12]);
      out.print(stridDestinatarioUCT);
      out.write(__oracle_jsp_text[13]);
      out.print(strMailUCT);
      out.write(__oracle_jsp_text[14]);
      out.print(strArea);
      out.write(__oracle_jsp_text[15]);
      out.print(strItemType);
      out.write(__oracle_jsp_text[16]);
      out.print(BUsuario.getIdUsuario());
      out.write(__oracle_jsp_text[17]);
      out.print(strConfFolio);
      out.write(__oracle_jsp_text[18]);
      
      				String[][] strCombo = ComboData.getCiudadanoCombo();
      			
      out.write(__oracle_jsp_text[19]);
       for(int i=0;i<strCombo.length;i++){ 
      out.write(__oracle_jsp_text[20]);
      out.print(strCombo[i][1]);
      out.write(__oracle_jsp_text[21]);
      out.print(strCombo[i][2]);
      out.write(__oracle_jsp_text[22]);
      out.print(strCombo[i][3]);
      out.write(__oracle_jsp_text[23]);
      out.print(strCombo[i][0]);
      out.write(__oracle_jsp_text[24]);
       } 
      out.write(__oracle_jsp_text[25]);

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
  private static final char __oracle_jsp_text[][]=new char[26][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<HTML>\n<HEAD> \n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n<!-- Se hace una instancia al Bean del usuario para la Sesión -->\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\" src=\"../js/link.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript> \n\tfunction limpiarSol(){\n\t\tdocument.SolUCT.reset()\n\t\tdocument.SolUCT.sol_asunto.focus()\n\t\t//forma.solicitud.value == \"\";\n\t}\n\tfunction cambioMun(opcion){\n\t\tdoc = document.SolUCT;\n\t\tvalida = 0;\n\t\tmsg=\"\";\n\t\tif(opcion.options[opcion.selectedIndex].value==\"BAJA CALIFORNIA\"){\n\t\t\t\n   \t\t\tdoc.sol_municipio1.style.display='inline';  \n   \t\t\tdoc.sol_municipio.style.display='none';\n\t\t}else{\n\t\t\tdoc.sol_municipio1.style.display='none';  \n   \t\t\tdoc.sol_municipio.style.display='inline';\n\t\t}\n\t\t\n\t}\n\tfunction area(opcion){\n\t\tdoc = document.SolUCT;\n\t\tvar cadena=\"\";\n\t\tif(opcion.options[opcion.selectedIndex].value != -1)\n\t\t{\n\t\t\tcadena = opcion.options[opcion.selectedIndex].value.substring(0, (opcion.options[opcion.selectedIndex].value.indexOf('|')));\n\t\t\tdoc.sol_name.value = cadena;\n\t\t\tcadena = opcion.options[opcion.selectedIndex].value.substring((opcion.options[opcion.selectedIndex].value.indexOf('|')+1), (opcion.options[opcion.selectedIndex].value.indexOf('/')));\n\t\t\tdoc.sol_mail1.value = cadena;\n\t\t\tcadena = opcion.options[opcion.selectedIndex].value.substring((opcion.options[opcion.selectedIndex].value.indexOf('/')+1), opcion.options[opcion.selectedIndex].value.length);\n\t\t\tdoc.id_ciudadano.value = cadena;\n\t\t}\n\t\telse{\n\t\t\tdoc.sol_name.value = \"\";\n\t\t\tdoc.sol_mail1.value = \"\";\n\t\t\tdoc.id_ciudadano.value = \"\";\n\t\t}\n\t}\n\nvar digitos=10 //cantidad de digitos buscados \nvar puntero=0 \nvar buffer=new Array(digitos) //declaración del array Buffer \nvar cadena=\"\" \n\nfunction buscar_opUCT(obj){\n\tvar forma=document.SolUCT;\n   \tvar letra = String.fromCharCode(event.keyCode)\n   \tif(puntero >= digitos){ \n    \tcadena=\"\"; \n       \tpuntero=0; \n    } \n   \t//si se presiona la tecla ENTER, borro el array de teclas presionadas y salto a otro objeto... \n   \tif (event.keyCode == 13){ \n    \tborrar_buffer(); \n       \t//if(objfoco!=0) objfoco.focus(); //evita foco a otro objeto si objfoco=0\n\t\tvar cad=\"\";\n\t\tif(obj.options[obj.selectedIndex].value!=\"-1\")\n\t\t{\t\n\t\t\tcad = obj.options[obj.selectedIndex].value.substring(0,(obj.options[obj.selectedIndex].value.indexOf('|')));\n\t\t\tforma.sol_name.value = cad;\n\t\t\tcad = obj.options[obj.selectedIndex].value.substring((obj.options[obj.selectedIndex].value.indexOf('|')+1),(obj.options[obj.selectedIndex].value.indexOf('/')));\n\t\t\tforma.sol_mail1.value = cad;\n\t\t\tcad = obj.options[obj.selectedIndex].value.substring((obj.options[obj.selectedIndex].value.indexOf('/')+1), obj.options[obj.selectedIndex].value.length);\n\t\t\tforma.id_ciudadano.value = cad;\n\t\t}\n\t\telse{\n\t\t\tforma.sol_name.value = \"\";\n\t\t\tforma.sol_mail1.value = \"\";\n\t\t\tforma.id_ciudadano.value = \"\";\n\t\t}\n    } \n   \t//sino busco la cadena tipeada dentro del combo... \n   \telse{ \n       \tbuffer[puntero]=letra; \n       \t//guardo en la posicion puntero la letra tipeada \n       \tcadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array \n       \tpuntero++; \n\n       \t//barro todas las opciones que contiene el combo y las comparo la cadena... \n       \tfor (var opcombo=0;opcombo < obj.length;opcombo++){ \n          \tif(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ \n          \t\tobj.selectedIndex=opcombo; \n        \t} \n       \t} \n    } \n   \tevent.returnValue = false; //invalida la acción de pulsado de tecla para evitar busqueda del primer caracter \n}\nfunction borrar_bufferUCT(){ \n   \t//inicializa la cadena buscada \n    cadena=\"\"; \n    puntero=0; \n} \n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0;limpiarSol();\">\n<!-- <FORM action=\"ConsultaCiudadano.jsp\" name=\"consultaForm\" method=\"post\"\n\tENCTYPE=\"multipart/form-data\">-->\n<FORM \taction=\"../CrearAsuntoCiudadanoUCT\" name=\"SolUCT\" \n\t\tmethod=\"post\" enctype=\"multipart/form-data\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\" name=\"id_ciudadano\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\" name=\"serverM\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\" name=\"portS\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\" name=\"serverName\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\" name=\"url\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"cm\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"idDestinatarioUCT\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"sol_mail\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"sol_area\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"ItemType\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"id_usuario\"> \n<INPUT type=\"hidden\" value=\"\" name=\"sol_destinatario\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"confFol\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"SolicitudUCT.jsp\"> <IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/Regresar.gif\" width=\"82\" height=\"26\"> </a></TD>\n\t\t\t<TD width=\"125\"><a onclick=\"guardarSolicitudUCT()\"> <img\n\t\t\t\tsrc=\"../Imagenes/Guardar.gif\" width=\"81\" border=\"0\"> </a></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"293\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV class=documentBody id=Body>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Datos\n\t\t\tdel Ciudadano</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"423\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#00204f\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TR valign=\"top\">\n\t\t<TD width=\"205\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t<TD align=\"right\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><I></I></FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"205\">&nbsp;</td>\n\t\t<td width=\"211\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"333\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<!-- <TR VALIGN=top>\n\t\t<TD width=\"144\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Tipo de\n\t\tSolicitud:</FONT></b></TD>\n\t\t<TD width=\"517\"><FONT SIZE=2 FACE=\"Verdana\"> <SELECT name=\"tipo_sol\"\n\t\t\tclass=\"blue200\">\n\t\t\t<OPTION value=\"1\">Pública</OPTION>\n\t\t\t<OPTION value=\"2\">Datos Personales</OPTION>\n\t\t\t<OPTION value=\"3\">Modificación de datos</OPTION>\n\t\t</SELECT> </FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"517\">&nbsp;</TD>\n\t</TR>-->\n\t<TR VALIGN=top>\n\t\t<TD width=\"205\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos del Solicitante:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t<SELECT name=\"sol_usuario\" class=\"blue200\" onchange=\"area(this)\" onKeypress=\"buscar_opUCT(this)\" onblur=\"borrar_bufferUCT()\" onclick=\"borrar_bufferUCT()\">\n\t\t\t\t<OPTION value=\"-1\">-- Clave Usuario --</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "|".toCharArray();
    __oracle_jsp_text[22] = 
    "/".toCharArray();
    __oracle_jsp_text[23] = 
    "\">".toCharArray();
    __oracle_jsp_text[24] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t</SELECT>\n\t\t</FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"205\">&nbsp;</td>\n\t\t<td width=\"211\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"333\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"205\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Nombre:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\"><INPUT name=\"sol_name\" value=\"\" class=\"blue200\"></FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"205\">&nbsp;</td>\n\t\t<td width=\"211\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"333\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"205\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Mail:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\"><INPUT name=\"sol_mail1\" value=\"\" class=\"blue200\"></FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"205\">&nbsp;</td>\n\t\t<td width=\"211\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"333\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t\n</table>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Datos\n\t\t\tde la Solicitud</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"423\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#00204f\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TR valign=\"top\">\n\t\t<td width=\"203\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<!-- <TR VALIGN=top>\n\t\t<TD width=\"183\">\n\t\t\t<b><font size=\"2\" color=\"#004080\" face=\"Arial\">Destinatario:</FONT></b>\n\t\t\t<INPUT type=\"button\" onclick=\"document.getElementById('pop4').style.visibility='visible';\" class=\"s-dropdown-btn\">\n\t\t\t<DIV class=\"popup\" id=\"pop4\">\n\t\t\t\t<IFRAME src=\"FrameDestinatarioUCT.jsp\" WIDTH=600 HEIGHT=300 frameborder=1></IFRAME>\n\t\t\t</DIV>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT SIZE=2 FACE=\"Verdana\">\n\t\t\t<INPUT class=\"blue500\" name=\"sol_destinatario\" value=\"\" onfocus=\"blur();\">\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"203\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>-->\n\t<TR VALIGN=top>\n\t\t<TD width=\"203\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Asunto:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\"><INPUT name=\"sol_asunto\" class=\"blue500\"></FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"203\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"203\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Detalle de la Solicitud:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\">Describa la información solicitada y proporcione todos aquellos\n\t\tdatos que considere puedan<br> facilitar su Búsqueda, con el fin de darle un mejor servicio.\n\t\t</FONT></TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"203\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\"></FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\"><TEXTAREA name=\"solicitud\"\n\t\t\trows=\"9\" cols=\"70\" class=\"blue700\"></TEXTAREA></FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"203\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"203\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"203\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Anexar un\n\t\tarchivo(Opcional):</FONT></TD>\n\t\t<TD colspan=\"3\"><input class=\"blue500\" type=\"file\"\n\t\t\tname=\"solicitud_archivo\"></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td width=\"203\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"176\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n</TABLE>\n</DIV>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
