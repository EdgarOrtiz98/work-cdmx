package _ciudadano;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;


public class _RegistroCiudadano extends com.orionserver.http.OrionHttpJspPage {


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
    _RegistroCiudadano page = this;
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
      com.meve.sigma.beans.CiudadanoBean BCiudadano;
      synchronized (pageContext) {
        if ((BCiudadano = (com.meve.sigma.beans.CiudadanoBean) pageContext.getAttribute( "BCiudadano", PageContext.PAGE_SCOPE)) == null) {
          BCiudadano = (com.meve.sigma.beans.CiudadanoBean) new com.meve.sigma.beans.CiudadanoBean();
          pageContext.setAttribute( "BCiudadano", BCiudadano, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      
      	int dia = 31;
      	int year = 1995;
      	int ir = 0;
      	String strDatos[] = null;
      	String strAccion 	= 	"";
      	String strNombre 	=	(request.getParameter("reg_nombre") != null)?request.getParameter("reg_nombre"):"";
      	String strAP 		=	(request.getParameter("reg_apellidoP") != null)?request.getParameter("reg_apellidoP"):"";
      	String strAM		=	(request.getParameter("reg_apellidoM") != null)?request.getParameter("reg_apellidoM"):"";
      	String strDia		=	(request.getParameter("reg_dia") != null)?request.getParameter("reg_dia"):"";
      	String strMes		=	(request.getParameter("reg_mes") != null)?request.getParameter("reg_mes"):"";
      	String strYear		=	(request.getParameter("reg_year") != null)?request.getParameter("reg_year"):"";
      	String strSexo		=	(request.getParameter("reg_sexo") != null)?request.getParameter("reg_sexo"):"";
      	String strOcupacion	=	(request.getParameter("reg_ocupacion") != null)?request.getParameter("reg_ocupacion"):"";
      	String strDomicilio	=	(request.getParameter("reg_domicilio") != null)?request.getParameter("reg_domicilio"):"";
      	String strPais		=	(request.getParameter("reg_pais") != null)?request.getParameter("reg_pais"):"";
      	String strEstado	=	(request.getParameter("reg_estado") != null)?request.getParameter("reg_estado"):"";
      	String strMunicipio	=	(request.getParameter("reg_municipio") != null)?request.getParameter("reg_municipio"):"";
      	String strTelefono	=	(request.getParameter("reg_telefono") != null)?request.getParameter("reg_telefono"):"";
      	String strMail		=	(request.getParameter("reg_mail") != null)?request.getParameter("reg_mail"):"";
      	String strUsuario	=	(request.getParameter("reg_usuario") != null)?request.getParameter("reg_usuario"):"";
      	String strSector	=	(request.getParameter("reg_sector") != null)?request.getParameter("reg_sector"):"";
      
      	String mun = request.getParameter("mun");
      	
      	strAccion = request.getParameter("accion");
      
      	if(strAccion != null && strAccion.equals("guardar")){
      		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
      		String portServer = application.getInitParameter("PortMail");
      		String serverName = application.getInitParameter("servername");
      		ir = BCiudadano.guardarCiudadano(request, serverMail, portServer, serverName); 
      		//ir = new Integer(strDatos[0]).intValue();
      		//if(ir == 0){
      			//String stridCiudadano = ActualizaCiudadano.getUltimoIdCiudadano();
      		if(ir >= 0){
      			String stridCiudadano = Integer.toString(ir);
      			try{
      				response.sendRedirect("confirmacion.jsp?id_ciu="+stridCiudadano);
      			}catch(java.io.IOException io){
      				//System.err.println("Error de reDirección-->"+io);
      			}
      		}
      	}
      
      out.write(__oracle_jsp_text[4]);
       if(ir == -1){
      out.write(__oracle_jsp_text[5]);
       } 
      out.write(__oracle_jsp_text[6]);
       if(ir == -2){
      out.write(__oracle_jsp_text[7]);
       } 
      out.write(__oracle_jsp_text[8]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[9]);
      out.print(strAP);
      out.write(__oracle_jsp_text[10]);
      out.print(strAM);
      out.write(__oracle_jsp_text[11]);
       for(int i=1;i<=dia;i++){ 
      out.write(__oracle_jsp_text[12]);
      out.print(i);
      out.write(__oracle_jsp_text[13]);
      out.print((strDia.trim().equals(""+i+"")?"selected":""));
      out.write(__oracle_jsp_text[14]);
      out.print(i);
      out.write(__oracle_jsp_text[15]);
       } 
      out.write(__oracle_jsp_text[16]);
      out.print((strMes.trim().equals("01")?"selected":""));
      out.write(__oracle_jsp_text[17]);
      out.print((strMes.trim().equals("02")?"selected":""));
      out.write(__oracle_jsp_text[18]);
      out.print((strMes.trim().equals("03")?"selected":""));
      out.write(__oracle_jsp_text[19]);
      out.print((strMes.trim().equals("04")?"selected":""));
      out.write(__oracle_jsp_text[20]);
      out.print((strMes.trim().equals("05")?"selected":""));
      out.write(__oracle_jsp_text[21]);
      out.print((strMes.trim().equals("06")?"selected":""));
      out.write(__oracle_jsp_text[22]);
      out.print((strMes.trim().equals("07")?"selected":""));
      out.write(__oracle_jsp_text[23]);
      out.print((strMes.trim().equals("08")?"selected":""));
      out.write(__oracle_jsp_text[24]);
      out.print((strMes.trim().equals("09")?"selected":""));
      out.write(__oracle_jsp_text[25]);
      out.print((strMes.trim().equals("10")?"selected":""));
      out.write(__oracle_jsp_text[26]);
      out.print((strMes.trim().equals("11")?"selected":""));
      out.write(__oracle_jsp_text[27]);
      out.print((strMes.trim().equals("12")?"selected":""));
      out.write(__oracle_jsp_text[28]);
       for(int y=1920;y<=year;y++){ 
      out.write(__oracle_jsp_text[29]);
      out.print(y);
      out.write(__oracle_jsp_text[30]);
      out.print((strYear.trim().equals(""+y+"")?"selected":""));
      out.write(__oracle_jsp_text[31]);
      out.print(y);
      out.write(__oracle_jsp_text[32]);
       } 
      out.write(__oracle_jsp_text[33]);
      out.print((strSexo.trim().equals("0")?"selected":""));
      out.write(__oracle_jsp_text[34]);
      out.print((strSexo.trim().equals("1")?"selected":""));
      out.write(__oracle_jsp_text[35]);
      
      				String strOcu[][] = ActualizaCiudadano.getListaOcupacion();
      				
      out.write(__oracle_jsp_text[36]);
      
      				for(int i=0;i<strOcu.length;i++){
      				
      out.write(__oracle_jsp_text[37]);
      out.print(strOcu[i][0]);
      out.write(__oracle_jsp_text[38]);
      out.print((strOcupacion.equals(strOcu[i][1])?"selected":""));
      out.write(__oracle_jsp_text[39]);
      out.print(strOcu[i][1]);
      out.write(__oracle_jsp_text[40]);
      }
      out.write(__oracle_jsp_text[41]);
      out.print((strSector.trim().equals("EMPRESARIAL")?"selected":""));
      out.write(__oracle_jsp_text[42]);
      out.print((strSector.trim().equals("GOBIERNO")?"selected":""));
      out.write(__oracle_jsp_text[43]);
      out.print((strSector.trim().equals("ACÁDEMICO")?"selected":""));
      out.write(__oracle_jsp_text[44]);
      out.print((strSector.trim().equals("MEDIOS DE COMUNICACIÃ“N")?"selected":""));
      out.write(__oracle_jsp_text[45]);
      out.print((strSector.trim().equals("PARTICULAR")?"selected":""));
      out.write(__oracle_jsp_text[46]);
      out.print(strDomicilio);
      out.write(__oracle_jsp_text[47]);
      out.print((strPais.trim().equals("MEXICO")?"selected":""));
      out.write(__oracle_jsp_text[48]);
      String strEst[][] = ActualizaCiudadano.getListaEstado();
      out.write(__oracle_jsp_text[49]);
      for(int i=0;i<strEst.length;i++){
      out.write(__oracle_jsp_text[50]);
      out.print(strEst[i][0]);
      out.write(__oracle_jsp_text[51]);
      out.print((strEstado.equals(strEst[i][0])?"selected":""));
      out.write(__oracle_jsp_text[52]);
      out.print(strEst[i][1]);
      out.write(__oracle_jsp_text[53]);
      }
      out.write(__oracle_jsp_text[54]);
      String strMun[][] = ActualizaCiudadano.getListaMunicipio();
      out.write(__oracle_jsp_text[55]);
      for(int i=0;i<strMun.length;i++){
      out.write(__oracle_jsp_text[56]);
      out.print(strMun[i][0]);
      out.write(__oracle_jsp_text[57]);
      out.print((strMunicipio.equals(strMun[i][0])?"selected":""));
      out.write(__oracle_jsp_text[58]);
      out.print(strMun[i][1]);
      out.write(__oracle_jsp_text[59]);
      }
      out.write(__oracle_jsp_text[60]);
      out.print(strTelefono);
      out.write(__oracle_jsp_text[61]);
      out.print(strMail);
      out.write(__oracle_jsp_text[62]);
      out.print(strUsuario);
      out.write(__oracle_jsp_text[63]);
      if(ir == 1){
      out.write(__oracle_jsp_text[64]);
      }
      out.write(__oracle_jsp_text[65]);
      if(ir == 2){
      out.write(__oracle_jsp_text[66]);
      }
      out.write(__oracle_jsp_text[67]);

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
  private static final char __oracle_jsp_text[][]=new char[68][];
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
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<STYLE type=\"text/css\">\n</STYLE>\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript> \n\tfunction cambioMun(opcion){\n\t\tdoc = document.registroCiuForm;\n\t\tvalida = 0;\n\t\tmsg=\"\";\n\t\tif(opcion.options[opcion.selectedIndex].value==\"BAJA CALIFORNIA\"){\n\t\t\t\n   \t\t\tdoc.reg_municipio1.style.display='inline';  \n   \t\t\tdoc.reg_municipio.style.display='none';\n\t\t}else{\n\t\t\tdoc.reg_municipio1.style.display='none';  \n   \t\t\tdoc.reg_municipio.style.display='inline';\n\t\t}\n\t\t\n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY BGCOLOR=\"FFFFFF\" background=\"../Imagenes/fondo_claro.jpg\">\n<FORM action=\"../ciudadano/RegistroCiudadano.jsp\" name=\"registroCiuForm\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"536\"><B><FONT face=\"Verdana\" color=\"RED\" size=\"3\">El Usuario que ingresaste ya existe. Ingresa uno nuevo</FONT></B></TD>\n\t\t\t<TD width=\"44\">&nbsp;</TD>\n\t\t\t<TD width=\"265\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"RED\" size=\"3\">La Clave no coincide</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"365\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"3\">Registro de Usuario</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"368\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Datos Personales</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"365\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV class=documentBody id=Body>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t<TD colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><I></I></FONT></TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Nombre(s): *</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\"><INPUT size=\"50\"\n\t\t\ttype=\"text\" name=\"reg_nombre\" class=\"blue200a\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\"> </FONT></TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Apellido Paterno: *</font></b>\n\t\t</td>\n\t\t<td width=\"233\"><font size=\"2\" face=\"Arial\"> <input\n\t\t\tname=\"reg_apellidoP\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\" Size=25 onfocus=\"\" class=\"blue200a\"> </font>\n\t\t</td>\n\t\t<td width=\"155\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Apellido Materno:</font>\n\t\t</td>\n\t\t<td width=\"276\"><font size=\"2\" face=\"Arial\"> <input name=\"reg_apellidoM\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\" Size=24 class=\"blue200a\"> </font></td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha de Nacimiento:</font>\n\t\t</td>\n\t\t<td colspan=\"3\">\n\t\t\t<font size=\"2\" face=\"Arial\">Día:\n\t\t\t\t<SELECT name=\"reg_dia\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\" class=\"blue50a\">\n\t\t\t\t\t<OPTION value=\"-1\">-dd-</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" ".toCharArray();
    __oracle_jsp_text[14] = 
    ">".toCharArray();
    __oracle_jsp_text[15] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t\tMes:\n\t\t\t\t<SELECT name=\"reg_mes\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\" class=\"blue100a\">\n\t\t\t\t\t<OPTION value=\"-1\">-Mes-</OPTION>\n\t\t\t\t\t<OPTION value=\"01\" ".toCharArray();
    __oracle_jsp_text[17] = 
    ">Enero</OPTION>\n\t\t\t\t\t<OPTION value=\"02\" ".toCharArray();
    __oracle_jsp_text[18] = 
    ">Febrero</OPTION>\n\t\t\t\t\t<OPTION value=\"03\" ".toCharArray();
    __oracle_jsp_text[19] = 
    ">Marzo</OPTION>\n\t\t\t\t\t<OPTION value=\"04\" ".toCharArray();
    __oracle_jsp_text[20] = 
    ">Abril</OPTION>\n\t\t\t\t\t<OPTION value=\"05\" ".toCharArray();
    __oracle_jsp_text[21] = 
    ">Mayo</OPTION>\n\t\t\t\t\t<OPTION value=\"06\" ".toCharArray();
    __oracle_jsp_text[22] = 
    ">Junio</OPTION>\n\t\t\t\t\t<OPTION value=\"07\" ".toCharArray();
    __oracle_jsp_text[23] = 
    ">Julio</OPTION>\n\t\t\t\t\t<OPTION value=\"08\" ".toCharArray();
    __oracle_jsp_text[24] = 
    ">Agosto</OPTION>\n\t\t\t\t\t<OPTION value=\"09\" ".toCharArray();
    __oracle_jsp_text[25] = 
    ">Septiembre</OPTION>\n\t\t\t\t\t<OPTION value=\"10\" ".toCharArray();
    __oracle_jsp_text[26] = 
    ">Octubre</OPTION>\n\t\t\t\t\t<OPTION value=\"11\" ".toCharArray();
    __oracle_jsp_text[27] = 
    ">Noviembre</OPTION>\n\t\t\t\t\t<OPTION value=\"12\" ".toCharArray();
    __oracle_jsp_text[28] = 
    ">Diciembre</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t\tAño:\n\t\t\t\t<SELECT name=\"reg_year\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\" class=\"blue100a\">\n\t\t\t\t\t<OPTION value=\"-1\">-aaaa-</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[30] = 
    "\" ".toCharArray();
    __oracle_jsp_text[31] = 
    ">".toCharArray();
    __oracle_jsp_text[32] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t</font>\n\t\t</td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Sexo:</font>\n\t\t</td>\n\t\t<td colspan=\"3\">\n\t\t\t<font size=\"2\" face=\"Arial\">\n\t\t\t\t<SELECT name=\"reg_sexo\" class=\"blue200a\">\n\t\t\t\t\t<OPTION value=\"-1\">-Selecciona-</OPTION>\n\t\t\t\t\t<OPTION value=\"0\" ".toCharArray();
    __oracle_jsp_text[34] = 
    ">Femenino</OPTION>\n\t\t\t\t\t<OPTION value=\"1\" ".toCharArray();
    __oracle_jsp_text[35] = 
    ">Masculino</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</font>\n\t\t</td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Ocupación:</font>\n\t\t</td>\n\t\t<td width=\"233\">\n\t\t\t<FONT size=\"2\" face=\"Arial\">\n\t\t\t\t<SELECT name=\"reg_ocupacion\" class=\"blue200a\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t\t\t<OPTION value=\"-1\">--Selecciona--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[38] = 
    "\" ".toCharArray();
    __oracle_jsp_text[39] = 
    ">".toCharArray();
    __oracle_jsp_text[40] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t</td>\n\t\t<TD width=\"155\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Sector:</FONT></TD>\n\t\t<TD width=\"276\">\n\t\t\t<FONT size=\"2\" face=\"Arial\">\n\t\t\t\t<SELECT name=\"reg_sector\" class=\"blue200a\">\n\t\t\t\t\t<OPTION value=\"-1\">--Selecciona--</OPTION>\n\t\t\t\t\t<OPTION value=\"EMPRESARIAL\" ".toCharArray();
    __oracle_jsp_text[42] = 
    ">Empresarial</OPTION>\n\t\t\t\t\t<OPTION value=\"GOBIERNO\" ".toCharArray();
    __oracle_jsp_text[43] = 
    ">Gobierno</OPTION>\n\t\t\t\t\t<OPTION value=\"ACÁDEMICO\" ".toCharArray();
    __oracle_jsp_text[44] = 
    ">Académico</OPTION>\n\t\t\t\t\t<OPTION value=\"MEDIOS DE COMUNICACIÃ“N\" ".toCharArray();
    __oracle_jsp_text[45] = 
    ">Medios de COMUNICACIÃ“N</OPTION>\n\t\t\t\t\t<OPTION value=\"PARTICULAR\" ".toCharArray();
    __oracle_jsp_text[46] = 
    ">Particular</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Domicilio:</FONT></TD>\n\t\t<TD colspan=\"3\"><FONT size=\"2\" face=\"Arial\"> <INPUT size=\"50\"\n\t\t\ttype=\"text\" name=\"reg_domicilio\" class=\"blue600a\" value=\"".toCharArray();
    __oracle_jsp_text[47] = 
    "\"></FONT></TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Pais:</FONT></TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT size=\"2\" face=\"Arial\">\n\t\t\t\t<SELECT name=\"reg_pais\" class=\"blue200a\">\n\t\t\t\t\t<OPTION value=\"-1\">-Selecciona-</OPTION>\n\t\t\t\t\t<OPTION value=\"MEXICO\" ".toCharArray();
    __oracle_jsp_text[48] = 
    ">México</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Estado:</font>\n\t\t</td>\n\t\t<td width=\"233\">\n\t\t\t<font size=\"2\" face=\"Arial\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t\t<SELECT name=\"reg_estado\" class=\"blue200a\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\">\n\t\t\t\t\t<OPTION value=\"-1\">- Selecciona -</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[51] = 
    "\" ".toCharArray();
    __oracle_jsp_text[52] = 
    ">".toCharArray();
    __oracle_jsp_text[53] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t</font>\n\t\t</td>\n\t\t<td width=\"155\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Municipio:</font>\n\t\t</td>\n\t\t<td width=\"276\"><font size=\"2\" face=\"Arial\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[55] = 
    "\n\t\t\t<SELECT name=\"reg_municipio\" class=\"blue200a\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\">\n\t\t\t\t<OPTION value=\"-1\">- Selecciona -</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[57] = 
    "\" ".toCharArray();
    __oracle_jsp_text[58] = 
    ">".toCharArray();
    __oracle_jsp_text[59] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t\t</SELECT>\n\t\t</td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Telefono:</font>\n\t\t</td>\n\t\t<td width=\"233\"><font size=\"2\" face=\"Arial\"> <input\n\t\t\tname=\"reg_telefono\" value=\"".toCharArray();
    __oracle_jsp_text[61] = 
    "\" Size=25 onfocus=\"\" class=\"blue200a\"> </font>\n\t\t</td>\n\t\t<td width=\"155\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Correo Electronico: *</font></b>\n\t\t</td>\n\t\t<td width=\"276\"><font size=\"2\" face=\"Arial\"> <input name=\"reg_mail\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[62] = 
    "\" Size=24 class=\"blue200a\"> </font></td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<!-- separación -->\n\t<tr valign=\"top\">\n\t\t<TD colspan=\"4\">\n\t\t\t<B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Datos de Usuario</FONT></B>\n\t\t</TD>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<TD bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Usuario*:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT size=\"2\" face=\"Arial\"><INPUT size=\"50\"\n\t\t\ttype=\"text\" name=\"reg_usuario\" class=\"blue200a\" maxlength=\"10\" value=\"".toCharArray();
    __oracle_jsp_text[63] = 
    "\"></FONT><br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[64] = 
    "<FONT size=\"1\" face=\"Arial\" color=\"red\">El Usuario ya existe</FONT>".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Clave*:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT size=\"2\" face=\"Arial\"><INPUT size=\"50\"\n\t\t\ttype=\"password\" name=\"reg_con1\" class=\"blue200a\" maxlength=\"8\"></FONT></TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Confirmar Clave*:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT size=\"2\" face=\"Arial\"><INPUT size=\"50\"\n\t\t\ttype=\"password\" name=\"reg_con2\" class=\"blue200a\" maxlength=\"8\"></FONT><br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[66] = 
    "<FONT size=\"1\" face=\"Arial\" color=\"red\">Ingresa la misma Clave para los mismos casilleros</FONT>".toCharArray();
    __oracle_jsp_text[67] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\" align=\"center\">\n\t\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Enviar\" onclick=\"guardarCiudadano()\">&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Limpiar\" onclick=\"limpiarRegistro()\">&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Cancelar\" onclick=\"CancelarRegistroCiu()\">\n\t\t</td>\n\t</tr>\n</TABLE>\n<br>\n</DIV></DIV></DIV></FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
