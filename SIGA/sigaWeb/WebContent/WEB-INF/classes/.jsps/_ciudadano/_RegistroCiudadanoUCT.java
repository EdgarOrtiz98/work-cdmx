package _ciudadano;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;


public class _RegistroCiudadanoUCT extends com.orionserver.http.OrionHttpJspPage {


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
    _RegistroCiudadanoUCT page = this;
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
      com.meve.sigma.beans.CiudadanoBean BCiudadano;
      synchronized (pageContext) {
        if ((BCiudadano = (com.meve.sigma.beans.CiudadanoBean) pageContext.getAttribute( "BCiudadano", PageContext.PAGE_SCOPE)) == null) {
          BCiudadano = (com.meve.sigma.beans.CiudadanoBean) new com.meve.sigma.beans.CiudadanoBean();
          pageContext.setAttribute( "BCiudadano", BCiudadano, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      
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
      
      out.write(__oracle_jsp_text[4]);
      
      	int dia = 31;
      	int year = 1995;
      	int ir = 0;
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
      		//if(ir == 0){
      			//String stridCiudadano = ActualizaCiudadano.getUltimoIdCiudadano();
      		if(ir >= 0){
      			String stridCiudadano = Integer.toString(ir);
      			try{
      				response.sendRedirect("confirmacionUCT.jsp?id_ciu="+stridCiudadano);
      			}catch(java.io.IOException io){
      				//System.err.println("Error de reDirección-->"+io);
      			}
      		}
      	}
      
      out.write(__oracle_jsp_text[5]);
       if(ir == -1){
      out.write(__oracle_jsp_text[6]);
       } 
      out.write(__oracle_jsp_text[7]);
       if(ir == -2){
      out.write(__oracle_jsp_text[8]);
       } 
      out.write(__oracle_jsp_text[9]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[10]);
      out.print(strAP);
      out.write(__oracle_jsp_text[11]);
      out.print(strAM);
      out.write(__oracle_jsp_text[12]);
       for(int i=1;i<=dia;i++){ 
      out.write(__oracle_jsp_text[13]);
      out.print(i);
      out.write(__oracle_jsp_text[14]);
      out.print((strDia.trim().equals(""+i+"")?"selected":""));
      out.write(__oracle_jsp_text[15]);
      out.print(i);
      out.write(__oracle_jsp_text[16]);
       } 
      out.write(__oracle_jsp_text[17]);
      out.print((strMes.trim().equals("01")?"selected":""));
      out.write(__oracle_jsp_text[18]);
      out.print((strMes.trim().equals("02")?"selected":""));
      out.write(__oracle_jsp_text[19]);
      out.print((strMes.trim().equals("03")?"selected":""));
      out.write(__oracle_jsp_text[20]);
      out.print((strMes.trim().equals("04")?"selected":""));
      out.write(__oracle_jsp_text[21]);
      out.print((strMes.trim().equals("05")?"selected":""));
      out.write(__oracle_jsp_text[22]);
      out.print((strMes.trim().equals("06")?"selected":""));
      out.write(__oracle_jsp_text[23]);
      out.print((strMes.trim().equals("07")?"selected":""));
      out.write(__oracle_jsp_text[24]);
      out.print((strMes.trim().equals("08")?"selected":""));
      out.write(__oracle_jsp_text[25]);
      out.print((strMes.trim().equals("09")?"selected":""));
      out.write(__oracle_jsp_text[26]);
      out.print((strMes.trim().equals("10")?"selected":""));
      out.write(__oracle_jsp_text[27]);
      out.print((strMes.trim().equals("11")?"selected":""));
      out.write(__oracle_jsp_text[28]);
      out.print((strMes.trim().equals("12")?"selected":""));
      out.write(__oracle_jsp_text[29]);
       for(int y=1920;y<=year;y++){ 
      out.write(__oracle_jsp_text[30]);
      out.print(y);
      out.write(__oracle_jsp_text[31]);
      out.print((strYear.trim().equals(""+y+"")?"selected":""));
      out.write(__oracle_jsp_text[32]);
      out.print(y);
      out.write(__oracle_jsp_text[33]);
       } 
      out.write(__oracle_jsp_text[34]);
      out.print((strSexo.trim().equals("0")?"selected":""));
      out.write(__oracle_jsp_text[35]);
      out.print((strSexo.trim().equals("1")?"selected":""));
      out.write(__oracle_jsp_text[36]);
      out.print((strOcupacion.trim().equals("HOGAR")?"selected":""));
      out.write(__oracle_jsp_text[37]);
      out.print((strOcupacion.trim().equals("ESTUDIANTE")?"selected":""));
      out.write(__oracle_jsp_text[38]);
      out.print((strOcupacion.trim().equals("PROFESIONISTA")?"selected":""));
      out.write(__oracle_jsp_text[39]);
      out.print((strOcupacion.trim().equals("EMPLEADO")?"selected":""));
      out.write(__oracle_jsp_text[40]);
      out.print((strOcupacion.trim().equals("INVESTIGADOR")?"selected":""));
      out.write(__oracle_jsp_text[41]);
      out.print((strOcupacion.trim().equals("PROFESOR")?"selected":""));
      out.write(__oracle_jsp_text[42]);
      out.print((strOcupacion.trim().equals("REPORTERO")?"selected":""));
      out.write(__oracle_jsp_text[43]);
      out.print((strOcupacion.trim().equals("OTRO")?"selected":""));
      out.write(__oracle_jsp_text[44]);
      out.print((strSector.trim().equals("EMPRESARIAL")?"selected":""));
      out.write(__oracle_jsp_text[45]);
      out.print((strSector.trim().equals("GOBIERNO")?"selected":""));
      out.write(__oracle_jsp_text[46]);
      out.print((strSector.trim().equals("ACÁDEMICO")?"selected":""));
      out.write(__oracle_jsp_text[47]);
      out.print((strSector.trim().equals("MEDIOS DE COMUNICACIÃ“N")?"selected":""));
      out.write(__oracle_jsp_text[48]);
      out.print((strSector.trim().equals("PARTICULAR")?"selected":""));
      out.write(__oracle_jsp_text[49]);
      out.print(strDomicilio);
      out.write(__oracle_jsp_text[50]);
      out.print((strPais.trim().equals("MEXICO")?"selected":""));
      out.write(__oracle_jsp_text[51]);
      out.print((strEstado.trim().equals("AGUASCALIENTES")?"selected":""));
      out.write(__oracle_jsp_text[52]);
      out.print((strEstado.trim().equals("BAJA CALIFORNIA")?"selected":""));
      out.write(__oracle_jsp_text[53]);
      out.print((strEstado.trim().equals("BAJA CALIFORNIA SUR")?"selected":""));
      out.write(__oracle_jsp_text[54]);
      out.print((strEstado.trim().equals("CAMPECHE")?"selected":""));
      out.write(__oracle_jsp_text[55]);
      out.print((strEstado.trim().equals("CHIAPAS")?"selected":""));
      out.write(__oracle_jsp_text[56]);
      out.print((strEstado.trim().equals("CHIHUAHUA")?"selected":""));
      out.write(__oracle_jsp_text[57]);
      out.print((strEstado.trim().equals("COAHUILA")?"selected":""));
      out.write(__oracle_jsp_text[58]);
      out.print((strEstado.trim().equals("COLIMA")?"selected":""));
      out.write(__oracle_jsp_text[59]);
      out.print((strEstado.trim().equals("DISTRITO FEDERAL")?"selected":""));
      out.write(__oracle_jsp_text[60]);
      out.print((strEstado.trim().equals("DURANGO")?"selected":""));
      out.write(__oracle_jsp_text[61]);
      out.print((strEstado.trim().equals("GUANAJUATO")?"selected":""));
      out.write(__oracle_jsp_text[62]);
      out.print((strEstado.trim().equals("GUERRERO")?"selected":""));
      out.write(__oracle_jsp_text[63]);
      out.print((strEstado.trim().equals("HIDALGO")?"selected":""));
      out.write(__oracle_jsp_text[64]);
      out.print((strEstado.trim().equals("JALISCO")?"selected":""));
      out.write(__oracle_jsp_text[65]);
      out.print((strEstado.trim().equals("MICHOACAN")?"selected":""));
      out.write(__oracle_jsp_text[66]);
      out.print((strEstado.trim().equals("MORELOS")?"selected":""));
      out.write(__oracle_jsp_text[67]);
      out.print((strEstado.trim().equals("EDOMEXICO")?"selected":""));
      out.write(__oracle_jsp_text[68]);
      out.print((strEstado.trim().equals("NAYARIT")?"selected":""));
      out.write(__oracle_jsp_text[69]);
      out.print((strEstado.trim().equals("NUEVO LEON")?"selected":""));
      out.write(__oracle_jsp_text[70]);
      out.print((strEstado.trim().equals("OAXACA")?"selected":""));
      out.write(__oracle_jsp_text[71]);
      out.print((strEstado.trim().equals("PUEBLA")?"selected":""));
      out.write(__oracle_jsp_text[72]);
      out.print((strEstado.trim().equals("QUERETARO")?"selected":""));
      out.write(__oracle_jsp_text[73]);
      out.print((strEstado.trim().equals("QUINTANA ROO")?"selected":""));
      out.write(__oracle_jsp_text[74]);
      out.print((strEstado.trim().equals("SAN LUIS POTOSI")?"selected":""));
      out.write(__oracle_jsp_text[75]);
      out.print((strEstado.trim().equals("SINALOA")?"selected":""));
      out.write(__oracle_jsp_text[76]);
      out.print((strEstado.trim().equals("SONORA")?"selected":""));
      out.write(__oracle_jsp_text[77]);
      out.print((strEstado.trim().equals("TABASCO")?"selected":""));
      out.write(__oracle_jsp_text[78]);
      out.print((strEstado.trim().equals("TAMAULIPAS")?"selected":""));
      out.write(__oracle_jsp_text[79]);
      out.print((strEstado.trim().equals("TLAXCALA")?"selected":""));
      out.write(__oracle_jsp_text[80]);
      out.print((strEstado.trim().equals("VERACRUZ")?"selected":""));
      out.write(__oracle_jsp_text[81]);
      out.print((strEstado.trim().equals("YUCATAN")?"selected":""));
      out.write(__oracle_jsp_text[82]);
      out.print((strEstado.trim().equals("ZACATECAS")?"selected":""));
      out.write(__oracle_jsp_text[83]);
      out.print(strMunicipio);
      out.write(__oracle_jsp_text[84]);
      out.print(strTelefono);
      out.write(__oracle_jsp_text[85]);
      out.print(strMail);
      out.write(__oracle_jsp_text[86]);
      out.print(strUsuario);
      out.write(__oracle_jsp_text[87]);
      if(ir == 1){
      out.write(__oracle_jsp_text[88]);
      }
      out.write(__oracle_jsp_text[89]);
      if(ir == 2){
      out.write(__oracle_jsp_text[90]);
      }
      out.write(__oracle_jsp_text[91]);

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
  private static final char __oracle_jsp_text[][]=new char[92][];
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
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<STYLE type=\"text/css\">\n</STYLE>\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript> \n\tfunction cambioMun(opcion){\n\t\tdoc = document.registroCiuFormUCT;\n\t\tvalida = 0;\n\t\tmsg=\"\";\n\t\tif(opcion.options[opcion.selectedIndex].value==\"BAJA CALIFORNIA\"){\n\t\t\t\n   \t\t\tdoc.reg_municipio1.style.display='inline';  \n   \t\t\tdoc.reg_municipio.style.display='none';\n\t\t}else{\n\t\t\tdoc.reg_municipio1.style.display='none';  \n   \t\t\tdoc.reg_municipio.style.display='inline';\n\t\t}\n\t\t\n\t}\n\tfunction cancelar(){\n\t\tlocation.assign('SolicitudUCT.jsp');\n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY BGCOLOR=\"FFFFFF\" background=\"../Imagenes/fondo_claro.jpg\">\n<FORM action=\"RegistroCiudadanoUCT.jsp\" name=\"registroCiuFormUCT\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"1\" name=\"UCT\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"536\"><B><FONT face=\"Verdana\" color=\"RED\" size=\"3\">El Usuario que ingresaste ya existe. Ingresa uno nuevo</FONT></B></TD>\n\t\t\t<TD width=\"44\">&nbsp;</TD>\n\t\t\t<TD width=\"265\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"RED\" size=\"3\">La Clave no coincide</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"365\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"3\">Registro de Usuario</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"368\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Datos Personales</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"365\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV class=documentBody id=Body>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t<TD colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><I></I></FONT></TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Nombre(s): *</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\"><INPUT size=\"50\"\n\t\t\ttype=\"text\" name=\"reg_nombre\" class=\"blue200\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\"> </FONT></TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Apellido Paterno: *</font></b>\n\t\t</td>\n\t\t<td width=\"233\"><font size=\"2\" face=\"Arial\"> <input\n\t\t\tname=\"reg_apellidoP\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\" Size=25 onfocus=\"\" class=\"blue200\"> </font>\n\t\t</td>\n\t\t<td width=\"155\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Apellido Materno:</font>\n\t\t</td>\n\t\t<td width=\"276\"><font size=\"2\" face=\"Arial\"> <input name=\"reg_apellidoM\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" Size=24 class=\"blue200\"> </font></td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha de Nacimiento:</font>\n\t\t</td>\n\t\t<td colspan=\"3\">\n\t\t\t<font size=\"2\" face=\"Arial\">Día:\n\t\t\t\t<SELECT name=\"reg_dia\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\">\n\t\t\t\t\t<OPTION value=\"-1\">-dd-</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" ".toCharArray();
    __oracle_jsp_text[15] = 
    ">".toCharArray();
    __oracle_jsp_text[16] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t\tMes:\n\t\t\t\t<SELECT name=\"reg_mes\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\">\n\t\t\t\t\t<OPTION value=\"-1\">-Mes-</OPTION>\n\t\t\t\t\t<OPTION value=\"01\" ".toCharArray();
    __oracle_jsp_text[18] = 
    ">Enero</OPTION>\n\t\t\t\t\t<OPTION value=\"02\" ".toCharArray();
    __oracle_jsp_text[19] = 
    ">Febrero</OPTION>\n\t\t\t\t\t<OPTION value=\"03\" ".toCharArray();
    __oracle_jsp_text[20] = 
    ">Marzo</OPTION>\n\t\t\t\t\t<OPTION value=\"04\" ".toCharArray();
    __oracle_jsp_text[21] = 
    ">Abril</OPTION>\n\t\t\t\t\t<OPTION value=\"05\" ".toCharArray();
    __oracle_jsp_text[22] = 
    ">Mayo</OPTION>\n\t\t\t\t\t<OPTION value=\"06\" ".toCharArray();
    __oracle_jsp_text[23] = 
    ">Junio</OPTION>\n\t\t\t\t\t<OPTION value=\"07\" ".toCharArray();
    __oracle_jsp_text[24] = 
    ">Julio</OPTION>\n\t\t\t\t\t<OPTION value=\"08\" ".toCharArray();
    __oracle_jsp_text[25] = 
    ">Agosto</OPTION>\n\t\t\t\t\t<OPTION value=\"09\" ".toCharArray();
    __oracle_jsp_text[26] = 
    ">Septiembre</OPTION>\n\t\t\t\t\t<OPTION value=\"10\" ".toCharArray();
    __oracle_jsp_text[27] = 
    ">Octubre</OPTION>\n\t\t\t\t\t<OPTION value=\"11\" ".toCharArray();
    __oracle_jsp_text[28] = 
    ">Noviembre</OPTION>\n\t\t\t\t\t<OPTION value=\"12\" ".toCharArray();
    __oracle_jsp_text[29] = 
    ">Diciembre</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t\tAño:\n\t\t\t\t<SELECT name=\"reg_year\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\">\n\t\t\t\t\t<OPTION value=\"-1\">-aaaa-</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[31] = 
    "\" ".toCharArray();
    __oracle_jsp_text[32] = 
    ">".toCharArray();
    __oracle_jsp_text[33] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t</font>\n\t\t</td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Sexo:</font>\n\t\t</td>\n\t\t<td colspan=\"3\">\n\t\t\t<font size=\"2\" face=\"Arial\">\n\t\t\t\t<SELECT name=\"reg_sexo\" class=\"blue200\">\n\t\t\t\t\t<OPTION value=\"-1\">-Selecciona-</OPTION>\n\t\t\t\t\t<OPTION value=\"0\" ".toCharArray();
    __oracle_jsp_text[35] = 
    ">Femenino</OPTION>\n\t\t\t\t\t<OPTION value=\"1\" ".toCharArray();
    __oracle_jsp_text[36] = 
    ">Masculino</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</font>\n\t\t</td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Ocupación:</font>\n\t\t</td>\n\t\t<td width=\"233\">\n\t\t\t<FONT size=\"2\" face=\"Arial\">\n\t\t\t\t<SELECT name=\"reg_ocupacion\" class=\"blue200\">\n\t\t\t\t\t<OPTION value=\"-1\">--Selecciona--</OPTION>\n\t\t\t\t\t<OPTION value=\"HOGAR\" ".toCharArray();
    __oracle_jsp_text[37] = 
    ">Hogar</OPTION>\n\t\t\t\t\t<OPTION value=\"ESTUDIANTE\" ".toCharArray();
    __oracle_jsp_text[38] = 
    ">Estudiante</OPTION>\n\t\t\t\t\t<OPTION value=\"PROFESIONISTA\" ".toCharArray();
    __oracle_jsp_text[39] = 
    ">Profesionista</OPTION>\n\t\t\t\t\t<OPTION value=\"EMPLEADO\" ".toCharArray();
    __oracle_jsp_text[40] = 
    ">Empleado</OPTION>\n\t\t\t\t\t<OPTION value=\"INVESTIGADOR\" ".toCharArray();
    __oracle_jsp_text[41] = 
    ">Investigador</OPTION>\n\t\t\t\t\t<OPTION value=\"PROFESOR\" ".toCharArray();
    __oracle_jsp_text[42] = 
    ">Profesor</OPTION>\n\t\t\t\t\t<OPTION value=\"REPORTERO\" ".toCharArray();
    __oracle_jsp_text[43] = 
    ">Reportero</OPTION>\n\t\t\t\t\t<OPTION value=\"OTRO\" ".toCharArray();
    __oracle_jsp_text[44] = 
    ">Otro</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t</td>\n\t\t<TD width=\"155\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Sector:</FONT></TD>\n\t\t<TD width=\"276\">\n\t\t\t<FONT size=\"2\" face=\"Arial\">\n\t\t\t\t<SELECT name=\"reg_sector\" class=\"blue200\">\n\t\t\t\t\t<OPTION value=\"-1\">--Selecciona--</OPTION>\n\t\t\t\t\t<OPTION value=\"EMPRESARIAL\" ".toCharArray();
    __oracle_jsp_text[45] = 
    ">Empresarial</OPTION>\n\t\t\t\t\t<OPTION value=\"GOBIERNO\" ".toCharArray();
    __oracle_jsp_text[46] = 
    ">Gobierno</OPTION>\n\t\t\t\t\t<OPTION value=\"ACÁDEMICO\" ".toCharArray();
    __oracle_jsp_text[47] = 
    ">Académico</OPTION>\n\t\t\t\t\t<OPTION value=\"MEDIOS DE COMUNICACIÃ“N\" ".toCharArray();
    __oracle_jsp_text[48] = 
    ">Medios de COMUNICACIÃ“N</OPTION>\n\t\t\t\t\t<OPTION value=\"PARTICULAR\" ".toCharArray();
    __oracle_jsp_text[49] = 
    ">Particular</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Domicilio:</FONT></TD>\n\t\t<TD colspan=\"3\"><FONT size=\"2\" face=\"Arial\"> <INPUT size=\"50\"\n\t\t\ttype=\"text\" name=\"reg_domicilio\" class=\"blue500\" value=\"".toCharArray();
    __oracle_jsp_text[50] = 
    "\"></FONT></TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Pais:</FONT></TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT size=\"2\" face=\"Arial\">\n\t\t\t\t<SELECT name=\"reg_pais\" class=\"blue200\">\n\t\t\t\t\t<OPTION value=\"-1\">-Selecciona-</OPTION>\n\t\t\t\t\t<OPTION value=\"MEXICO\" ".toCharArray();
    __oracle_jsp_text[51] = 
    ">México</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Estado:</font>\n\t\t</td>\n\t\t<td width=\"233\">\n\t\t\t<font size=\"2\" face=\"Arial\">\n\t\t\t\t<SELECT name=\"reg_estado\" class=\"blue200\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\">\n\t\t\t\t\t<OPTION value=\"-1\">- Selecciona -</OPTION>\n\t\t\t\t\t<OPTION value=\"AGUASCALIENTES\" ".toCharArray();
    __oracle_jsp_text[52] = 
    ">Aguascalientes</OPTION>\n\t\t\t\t\t<OPTION value=\"BAJA CALIFORNIA\" ".toCharArray();
    __oracle_jsp_text[53] = 
    ">Baja California</OPTION>\n\t\t\t\t\t<OPTION value=\"BAJA CALIFORNIA SUR\" ".toCharArray();
    __oracle_jsp_text[54] = 
    ">Baja California Sur</OPTION>\n\t\t\t\t\t<OPTION value=\"CAMPECHE\" ".toCharArray();
    __oracle_jsp_text[55] = 
    ">Campeche</OPTION>\n\t\t\t\t\t<OPTION value=\"CHIAPAS\" ".toCharArray();
    __oracle_jsp_text[56] = 
    ">Chiapas</OPTION>\n\t\t\t\t\t<OPTION value=\"CHIHUAHUA\" ".toCharArray();
    __oracle_jsp_text[57] = 
    ">Chihuahua</OPTION>\n\t\t\t\t\t<OPTION value=\"COAHUILA\" ".toCharArray();
    __oracle_jsp_text[58] = 
    ">Coahuila</OPTION>\n\t\t\t\t\t<OPTION value=\"COLIMA\" ".toCharArray();
    __oracle_jsp_text[59] = 
    ">Colima</OPTION>\n\t\t\t\t\t<OPTION value=\"DISTRITO FEDERAL\" ".toCharArray();
    __oracle_jsp_text[60] = 
    ">Distrito Federal</OPTION>\n\t\t\t\t\t<OPTION value=\"DURANGO\" ".toCharArray();
    __oracle_jsp_text[61] = 
    ">Durango</OPTION>\n\t\t\t\t\t<OPTION value=\"GUANAJUATO\" ".toCharArray();
    __oracle_jsp_text[62] = 
    ">Guanajuato</OPTION>\n\t\t\t\t\t<OPTION value=\"GUERRERO\" ".toCharArray();
    __oracle_jsp_text[63] = 
    ">Guerrero</OPTION>\n\t\t\t\t\t<OPTION value=\"HIDALGO\" ".toCharArray();
    __oracle_jsp_text[64] = 
    ">Hidalgo</OPTION>\n\t\t\t\t\t<OPTION value=\"JALISCO\" ".toCharArray();
    __oracle_jsp_text[65] = 
    ">Jalisco</OPTION>\n\t\t\t\t\t<OPTION value=\"MICHOACAN\" ".toCharArray();
    __oracle_jsp_text[66] = 
    ">Michoacan</OPTION>\n\t\t\t\t\t<OPTION value=\"MORELOS\" ".toCharArray();
    __oracle_jsp_text[67] = 
    ">Morelos</OPTION>\n\t\t\t\t\t<OPTION value=\"EDOMEXICO\" ".toCharArray();
    __oracle_jsp_text[68] = 
    ">Edo. de México</OPTION>\n\t\t\t\t\t<OPTION value=\"NAYARIT\" ".toCharArray();
    __oracle_jsp_text[69] = 
    ">Nayarit</OPTION>\n\t\t\t\t\t<OPTION value=\"NUEVO LEON\" ".toCharArray();
    __oracle_jsp_text[70] = 
    ">Nuevo León</OPTION>\n\t\t\t\t\t<OPTION value=\"OAXACA\" ".toCharArray();
    __oracle_jsp_text[71] = 
    ">Oaxaca</OPTION>\n\t\t\t\t\t<OPTION value=\"PUEBLA\" ".toCharArray();
    __oracle_jsp_text[72] = 
    ">Puebla</OPTION>\n\t\t\t\t\t<OPTION value=\"QUERETARO\" ".toCharArray();
    __oracle_jsp_text[73] = 
    ">Querétaro</OPTION>\n\t\t\t\t\t<OPTION value=\"QUINTANA ROO\" ".toCharArray();
    __oracle_jsp_text[74] = 
    ">Quintana Roo</OPTION>\n\t\t\t\t\t<OPTION value=\"SAN LUIS POTOSI\" ".toCharArray();
    __oracle_jsp_text[75] = 
    ">San Luis Potosí</OPTION>\n\t\t\t\t\t<OPTION value=\"SINALOA\" ".toCharArray();
    __oracle_jsp_text[76] = 
    ">Sinaloa</OPTION>\n\t\t\t\t\t<OPTION value=\"SONORA\" ".toCharArray();
    __oracle_jsp_text[77] = 
    ">Sonora</OPTION>\n\t\t\t\t\t<OPTION value=\"TABASCO\" ".toCharArray();
    __oracle_jsp_text[78] = 
    ">Tabasco</OPTION>\n\t\t\t\t\t<OPTION value=\"TAMAULIPAS\" ".toCharArray();
    __oracle_jsp_text[79] = 
    ">Tamaulipas</OPTION>\n\t\t\t\t\t<OPTION value=\"TLAXCALA\" ".toCharArray();
    __oracle_jsp_text[80] = 
    ">Tlaxcala</OPTION>\n\t\t\t\t\t<OPTION value=\"VERACRUZ\" ".toCharArray();
    __oracle_jsp_text[81] = 
    ">Veracruz</OPTION>\n\t\t\t\t\t<OPTION value=\"YUCATAN\" ".toCharArray();
    __oracle_jsp_text[82] = 
    ">Yucatán</OPTION>\n\t\t\t\t\t<OPTION value=\"ZACATECAS\" ".toCharArray();
    __oracle_jsp_text[83] = 
    ">Zacatecas</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</font>\n\t\t</td>\n\t\t<td width=\"155\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Municipio:</font>\n\t\t</td>\n\t\t<td width=\"276\"><font size=\"2\" face=\"Arial\"> <input name=\"reg_municipio\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[84] = 
    "\" Size=24 class=\"blue200\"> </font>\n\t\t</td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Telefono:</font>\n\t\t</td>\n\t\t<td width=\"233\"><font size=\"2\" face=\"Arial\"> <input\n\t\t\tname=\"reg_telefono\" value=\"".toCharArray();
    __oracle_jsp_text[85] = 
    "\" Size=25 onfocus=\"\" class=\"blue200\"> </font>\n\t\t</td>\n\t\t<td width=\"155\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Correo Electronico: *</font></b>\n\t\t</td>\n\t\t<td width=\"276\"><font size=\"2\" face=\"Arial\"> <input name=\"reg_mail\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[86] = 
    "\" Size=24 class=\"blue200\"> </font></td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<!-- separación -->\n\t<tr valign=\"top\">\n\t\t<TD colspan=\"4\">\n\t\t\t<B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Datos de Usuario</FONT></B>\n\t\t</TD>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<TD bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Usuario*:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT size=\"2\" face=\"Arial\"><INPUT size=\"50\"\n\t\t\ttype=\"text\" name=\"reg_usuario\" class=\"blue200\" maxlength=\"10\" value=\"".toCharArray();
    __oracle_jsp_text[87] = 
    "\"></FONT><br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[88] = 
    "<FONT size=\"1\" face=\"Arial\" color=\"red\">El Usuario ya existe</FONT>".toCharArray();
    __oracle_jsp_text[89] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Clave*:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT size=\"2\" face=\"Arial\"><INPUT size=\"50\"\n\t\t\ttype=\"password\" name=\"reg_con1\" class=\"blue200\" maxlength=\"8\"></FONT></TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Confirmar Clave*:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT size=\"2\" face=\"Arial\"><INPUT size=\"50\"\n\t\t\ttype=\"password\" name=\"reg_con2\" class=\"blue200\" maxlength=\"8\"></FONT><br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[90] = 
    "<FONT size=\"1\" face=\"Arial\" color=\"red\">Ingresa la misma Clave para los mismos casilleros</FONT>".toCharArray();
    __oracle_jsp_text[91] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\" align=\"center\">\n\t\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Cancelar\" onclick=\"cancelar()\">&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Enviar\" onclick=\"guardarCiudadanoUCT()\">&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Limpiar\" onclick=\"limpiarRegistroUCT()\">\n\t\t</td>\n\t</tr>\n</TABLE>\n<br>\n</DIV></DIV></DIV></FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
