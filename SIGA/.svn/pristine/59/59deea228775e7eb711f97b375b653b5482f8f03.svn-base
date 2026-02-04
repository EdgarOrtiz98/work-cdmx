package _ciudadano;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import java.util.*;


public class _EditarDatos extends com.orionserver.http.OrionHttpJspPage {


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
    _EditarDatos page = this;
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
      com.meve.sigma.beans.CiudadanoBean CiudadanoBean;
      synchronized (pageContext) {
        if ((CiudadanoBean = (com.meve.sigma.beans.CiudadanoBean) pageContext.getAttribute( "CiudadanoBean", PageContext.PAGE_SCOPE)) == null) {
          CiudadanoBean = (com.meve.sigma.beans.CiudadanoBean) new com.meve.sigma.beans.CiudadanoBean();
          pageContext.setAttribute( "CiudadanoBean", CiudadanoBean, PageContext.PAGE_SCOPE);
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
      	int dia = 31;
      	int year = 1995;
      	int ir = 0;
      	String strDatosCiudadano[][] = null;
      	strDatosCiudadano = ActualizaCiudadano.getCiudadanoEditar(BCiudadano.getIdUsuario()); 
      	String strAccion 	= 	"";
      	String strNombre 	=	"";
      	String strAP 		=	"";
      	String strAM		=	"";
      	String strDia		=	"";
      	String strMes		=	"";
      	String strYear		=	"";
      	String strSexo		=	"";
      	String strOcupacion	=	"";
      	String strDomicilio	=	"";
      	String strPais		=	"";
      	String strEstado	=	"";
      	String strMunicipio	=	"";
      	String strTelefono	=	"";
      	String strMail		=	"";
      	String strUsuario	=	"";
      	String strSector	=	"";
      	String strFechaNac	=	"";
      	String strIDCiu		=	"";
      	
      	strAccion = request.getParameter("accion");
      
      	if(strAccion != null && strAccion.equals("editar")){
      		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
      		String portServer = application.getInitParameter("PortMail");
      		String serverName = application.getInitParameter("servername");
      		CiudadanoBean.ActualizarCiudadano(request, serverMail, portServer, serverName);  
      		
      		try{
      				response.sendRedirect("PortalCiudadano.jsp");
      		}catch(java.io.IOException io){
      			//System.err.println("Error de reDirección-->"+io);
      		}
      		
      	}
      	if(strDatosCiudadano != null && strDatosCiudadano.length > 0){
      		strIDCiu	=	strDatosCiudadano[0][0];
      		strNombre 	=	strDatosCiudadano[0][1];
      		strAP		=	strDatosCiudadano[0][2];
      		strAM		=	strDatosCiudadano[0][3];
      		strMail		=	strDatosCiudadano[0][4];
      		strOcupacion=	strDatosCiudadano[0][6];
      		strDomicilio=	strDatosCiudadano[0][7];
      		strPais		=	strDatosCiudadano[0][8];
      		strEstado	=	strDatosCiudadano[0][9];
      		strMunicipio=	strDatosCiudadano[0][10];
      		strTelefono	=	strDatosCiudadano[0][11];
      		strSector	=	strDatosCiudadano[0][12];
      		strSexo		=	strDatosCiudadano[0][13];
      		strFechaNac	=	strDatosCiudadano[0][14];
      		String strDia1		=	"";
      		StringTokenizer strAux = new StringTokenizer(strFechaNac,"-");
      		if(strAux.hasMoreTokens())
      		{
      			strYear = strAux.nextToken();
      			strMes	= strAux.nextToken();
      			strDia	= strAux.nextToken();
      			if(strDia.equals("01"))
      				strDia = "1";
      			if(strDia.equals("02"))
      				strDia = "2";
      			if(strDia.equals("03"))
      				strDia = "3";
      			if(strDia.equals("04"))
      				strDia = "4";
      			if(strDia.equals("05"))
      				strDia = "5";
      			if(strDia.equals("06"))
      				strDia = "6";
      			if(strDia.equals("07"))
      				strDia = "7";
      			if(strDia.equals("08"))
      				strDia = "8";
      			if(strDia.equals("09"))
      				strDia = "9";
      		//	//System.out.println("dia-->"+strDia);
      			//strDia1 = strDia1.substring(0);
      			////System.out.println("dia-->"+strDia1);
      		}
      	}
      
      out.write(__oracle_jsp_text[4]);
      out.print(strIDCiu);
      out.write(__oracle_jsp_text[5]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[6]);
      out.print(strAP);
      out.write(__oracle_jsp_text[7]);
      out.print(strAM);
      out.write(__oracle_jsp_text[8]);
       for(int i=1;i<=dia;i++){ 
      out.write(__oracle_jsp_text[9]);
      out.print(i);
      out.write(__oracle_jsp_text[10]);
      out.print((strDia.trim().equals(""+i+"")?"selected":""));
      out.write(__oracle_jsp_text[11]);
      out.print(i);
      out.write(__oracle_jsp_text[12]);
       } 
      out.write(__oracle_jsp_text[13]);
      out.print((strMes.trim().equals("01")?"selected":""));
      out.write(__oracle_jsp_text[14]);
      out.print((strMes.trim().equals("02")?"selected":""));
      out.write(__oracle_jsp_text[15]);
      out.print((strMes.trim().equals("03")?"selected":""));
      out.write(__oracle_jsp_text[16]);
      out.print((strMes.trim().equals("04")?"selected":""));
      out.write(__oracle_jsp_text[17]);
      out.print((strMes.trim().equals("05")?"selected":""));
      out.write(__oracle_jsp_text[18]);
      out.print((strMes.trim().equals("06")?"selected":""));
      out.write(__oracle_jsp_text[19]);
      out.print((strMes.trim().equals("07")?"selected":""));
      out.write(__oracle_jsp_text[20]);
      out.print((strMes.trim().equals("08")?"selected":""));
      out.write(__oracle_jsp_text[21]);
      out.print((strMes.trim().equals("09")?"selected":""));
      out.write(__oracle_jsp_text[22]);
      out.print((strMes.trim().equals("10")?"selected":""));
      out.write(__oracle_jsp_text[23]);
      out.print((strMes.trim().equals("11")?"selected":""));
      out.write(__oracle_jsp_text[24]);
      out.print((strMes.trim().equals("12")?"selected":""));
      out.write(__oracle_jsp_text[25]);
       for(int y=1920;y<=year;y++){ 
      out.write(__oracle_jsp_text[26]);
      out.print(y);
      out.write(__oracle_jsp_text[27]);
      out.print((strYear.trim().equals(""+y+"")?"selected":""));
      out.write(__oracle_jsp_text[28]);
      out.print(y);
      out.write(__oracle_jsp_text[29]);
       } 
      out.write(__oracle_jsp_text[30]);
      out.print((strSexo.trim().equals("0")?"selected":""));
      out.write(__oracle_jsp_text[31]);
      out.print((strSexo.trim().equals("1")?"selected":""));
      out.write(__oracle_jsp_text[32]);
      out.print((strOcupacion.trim().equals("HOGAR")?"selected":""));
      out.write(__oracle_jsp_text[33]);
      out.print((strOcupacion.trim().equals("ESTUDIANTE")?"selected":""));
      out.write(__oracle_jsp_text[34]);
      out.print((strOcupacion.trim().equals("PROFESIONISTA")?"selected":""));
      out.write(__oracle_jsp_text[35]);
      out.print((strOcupacion.trim().equals("EMPLEADO")?"selected":""));
      out.write(__oracle_jsp_text[36]);
      out.print((strOcupacion.trim().equals("INVESTIGADOR")?"selected":""));
      out.write(__oracle_jsp_text[37]);
      out.print((strOcupacion.trim().equals("PROFESOR")?"selected":""));
      out.write(__oracle_jsp_text[38]);
      out.print((strOcupacion.trim().equals("REPORTERO")?"selected":""));
      out.write(__oracle_jsp_text[39]);
      out.print((strOcupacion.trim().equals("OTRO")?"selected":""));
      out.write(__oracle_jsp_text[40]);
      out.print((strSector.trim().equals("EMPRESARIAL")?"selected":""));
      out.write(__oracle_jsp_text[41]);
      out.print((strSector.trim().equals("GOBIERNO")?"selected":""));
      out.write(__oracle_jsp_text[42]);
      out.print((strSector.trim().equals("ACÁDEMICO")?"selected":""));
      out.write(__oracle_jsp_text[43]);
      out.print((strSector.trim().equals("MEDIOS DE COMUNICACIÃ“N")?"selected":""));
      out.write(__oracle_jsp_text[44]);
      out.print((strSector.trim().equals("PARTICULAR")?"selected":""));
      out.write(__oracle_jsp_text[45]);
      out.print(strDomicilio);
      out.write(__oracle_jsp_text[46]);
      out.print((strPais.trim().equals("MEXICO")?"selected":""));
      out.write(__oracle_jsp_text[47]);
      out.print((strEstado.trim().equals("AGUASCALIENTES")?"selected":""));
      out.write(__oracle_jsp_text[48]);
      out.print((strEstado.trim().equals("BAJA CALIFORNIA")?"selected":""));
      out.write(__oracle_jsp_text[49]);
      out.print((strEstado.trim().equals("BAJA CALIFORNIA SUR")?"selected":""));
      out.write(__oracle_jsp_text[50]);
      out.print((strEstado.trim().equals("CAMPECHE")?"selected":""));
      out.write(__oracle_jsp_text[51]);
      out.print((strEstado.trim().equals("CHIAPAS")?"selected":""));
      out.write(__oracle_jsp_text[52]);
      out.print((strEstado.trim().equals("CHIHUAHUA")?"selected":""));
      out.write(__oracle_jsp_text[53]);
      out.print((strEstado.trim().equals("COAHUILA")?"selected":""));
      out.write(__oracle_jsp_text[54]);
      out.print((strEstado.trim().equals("COLIMA")?"selected":""));
      out.write(__oracle_jsp_text[55]);
      out.print((strEstado.trim().equals("DISTRITO FEDERAL")?"selected":""));
      out.write(__oracle_jsp_text[56]);
      out.print((strEstado.trim().equals("DURANGO")?"selected":""));
      out.write(__oracle_jsp_text[57]);
      out.print((strEstado.trim().equals("GUANAJUATO")?"selected":""));
      out.write(__oracle_jsp_text[58]);
      out.print((strEstado.trim().equals("GUERRERO")?"selected":""));
      out.write(__oracle_jsp_text[59]);
      out.print((strEstado.trim().equals("HIDALGO")?"selected":""));
      out.write(__oracle_jsp_text[60]);
      out.print((strEstado.trim().equals("JALISCO")?"selected":""));
      out.write(__oracle_jsp_text[61]);
      out.print((strEstado.trim().equals("MICHOACAN")?"selected":""));
      out.write(__oracle_jsp_text[62]);
      out.print((strEstado.trim().equals("MORELOS")?"selected":""));
      out.write(__oracle_jsp_text[63]);
      out.print((strEstado.trim().equals("EDOMEXICO")?"selected":""));
      out.write(__oracle_jsp_text[64]);
      out.print((strEstado.trim().equals("NAYARIT")?"selected":""));
      out.write(__oracle_jsp_text[65]);
      out.print((strEstado.trim().equals("NUEVO LEON")?"selected":""));
      out.write(__oracle_jsp_text[66]);
      out.print((strEstado.trim().equals("OAXACA")?"selected":""));
      out.write(__oracle_jsp_text[67]);
      out.print((strEstado.trim().equals("PUEBLA")?"selected":""));
      out.write(__oracle_jsp_text[68]);
      out.print((strEstado.trim().equals("QUERETARO")?"selected":""));
      out.write(__oracle_jsp_text[69]);
      out.print((strEstado.trim().equals("QUINTANA ROO")?"selected":""));
      out.write(__oracle_jsp_text[70]);
      out.print((strEstado.trim().equals("SAN LUIS POTOSI")?"selected":""));
      out.write(__oracle_jsp_text[71]);
      out.print((strEstado.trim().equals("SINALOA")?"selected":""));
      out.write(__oracle_jsp_text[72]);
      out.print((strEstado.trim().equals("SONORA")?"selected":""));
      out.write(__oracle_jsp_text[73]);
      out.print((strEstado.trim().equals("TABASCO")?"selected":""));
      out.write(__oracle_jsp_text[74]);
      out.print((strEstado.trim().equals("TAMAULIPAS")?"selected":""));
      out.write(__oracle_jsp_text[75]);
      out.print((strEstado.trim().equals("TLAXCALA")?"selected":""));
      out.write(__oracle_jsp_text[76]);
      out.print((strEstado.trim().equals("VERACRUZ")?"selected":""));
      out.write(__oracle_jsp_text[77]);
      out.print((strEstado.trim().equals("YUCATAN")?"selected":""));
      out.write(__oracle_jsp_text[78]);
      out.print((strEstado.trim().equals("ZACATECAS")?"selected":""));
      out.write(__oracle_jsp_text[79]);
      out.print(strMunicipio);
      out.write(__oracle_jsp_text[80]);
      out.print(strTelefono);
      out.write(__oracle_jsp_text[81]);
      out.print(strMail);
      out.write(__oracle_jsp_text[82]);

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
  private static final char __oracle_jsp_text[][]=new char[83][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[3] = 
    " \n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<TITLE>EditarDatos.jsp</TITLE>\n<SCRIPT language=JavaScript type=text/javascript> \n\tfunction cambioMun(opcion){\n\t\tdoc = document.FormEditar;\n\t\tvalida = 0;\n\t\tmsg=\"\";\n\t\tif(opcion.options[opcion.selectedIndex].value==\"BAJA CALIFORNIA\"){\n\t\t\t\n   \t\t\tdoc.reg_municipio1.style.display='inline';  \n   \t\t\tdoc.reg_municipio.style.display='none';\n\t\t\tdoc.reg_municipio.value='';\n\t\t}else{\n\t\t\tdoc.reg_municipio1.style.display='none';  \n   \t\t\tdoc.reg_municipio.style.display='inline';\n\t\t}\n\t\t\n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0;\">\n<FORM name=\"FormEditar\" action=\"EditarDatos.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[5] = 
    "\" name=\"reg_id\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"PortalCiudadano.jsp\"> <IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/Regresar.gif\" width=\"82\" height=\"26\"> </a></TD>\n\t\t\t<TD width=\"125\"><a onclick=\"EditarSolicitud()\"> <img\n\t\t\t\tsrc=\"../Imagenes/Guardar.gif\" width=\"81\" border=\"0\" name=\"guardaImg\"> </a></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"227\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Mis Datos Personales</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"365\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV class=documentBody id=Body>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t<TD colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><I></I></FONT></TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Nombre/s*:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\"><INPUT size=\"50\"\n\t\t\ttype=\"text\" name=\"reg_nombre\" class=\"blue200\" value=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\"> </FONT></TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Apellido Paterno:</font>\n\t\t</td>\n\t\t<td width=\"233\"><font size=\"2\" face=\"Arial\"> <input\n\t\t\tname=\"reg_apellidoP\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\" Size=25 onfocus=\"\" class=\"blue200\"> </font>\n\t\t</td>\n\t\t<td width=\"155\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Apellido Materno:</font>\n\t\t</td>\n\t\t<td width=\"276\"><font size=\"2\" face=\"Arial\"> <input name=\"reg_apellidoM\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\" Size=24 class=\"blue200\"> </font></td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha de Nacimiento:</font>\n\t\t</td>\n\t\t<td colspan=\"3\">\n\t\t\t<font size=\"2\" face=\"Arial\">Día:\n\t\t\t\t<SELECT name=\"reg_dia\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\">\n\t\t\t\t\t<OPTION value=\"-1\">-dd-</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\" ".toCharArray();
    __oracle_jsp_text[11] = 
    ">".toCharArray();
    __oracle_jsp_text[12] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t\tMes:\n\t\t\t\t<SELECT name=\"reg_mes\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\">\n\t\t\t\t\t<OPTION value=\"-1\">-Mes-</OPTION>\n\t\t\t\t\t<OPTION value=\"01\" ".toCharArray();
    __oracle_jsp_text[14] = 
    ">Enero</OPTION>\n\t\t\t\t\t<OPTION value=\"02\" ".toCharArray();
    __oracle_jsp_text[15] = 
    ">Febrero</OPTION>\n\t\t\t\t\t<OPTION value=\"03\" ".toCharArray();
    __oracle_jsp_text[16] = 
    ">Marzo</OPTION>\n\t\t\t\t\t<OPTION value=\"04\" ".toCharArray();
    __oracle_jsp_text[17] = 
    ">Abril</OPTION>\n\t\t\t\t\t<OPTION value=\"05\" ".toCharArray();
    __oracle_jsp_text[18] = 
    ">Mayo</OPTION>\n\t\t\t\t\t<OPTION value=\"06\" ".toCharArray();
    __oracle_jsp_text[19] = 
    ">Junio</OPTION>\n\t\t\t\t\t<OPTION value=\"07\" ".toCharArray();
    __oracle_jsp_text[20] = 
    ">Julio</OPTION>\n\t\t\t\t\t<OPTION value=\"08\" ".toCharArray();
    __oracle_jsp_text[21] = 
    ">Agosto</OPTION>\n\t\t\t\t\t<OPTION value=\"09\" ".toCharArray();
    __oracle_jsp_text[22] = 
    ">Septiembre</OPTION>\n\t\t\t\t\t<OPTION value=\"10\" ".toCharArray();
    __oracle_jsp_text[23] = 
    ">Octubre</OPTION>\n\t\t\t\t\t<OPTION value=\"11\" ".toCharArray();
    __oracle_jsp_text[24] = 
    ">Noviembre</OPTION>\n\t\t\t\t\t<OPTION value=\"12\" ".toCharArray();
    __oracle_jsp_text[25] = 
    ">Diciembre</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t\tAño:\n\t\t\t\t<SELECT name=\"reg_year\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\">\n\t\t\t\t\t<OPTION value=\"-1\">-aaaa-</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[27] = 
    "\" ".toCharArray();
    __oracle_jsp_text[28] = 
    ">".toCharArray();
    __oracle_jsp_text[29] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t</font>\n\t\t</td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Sexo:</font>\n\t\t</td>\n\t\t<td colspan=\"3\">\n\t\t\t<font size=\"2\" face=\"Arial\">\n\t\t\t\t<SELECT name=\"reg_sexo\" class=\"blue200\">\n\t\t\t\t\t<OPTION value=\"-1\">-Selecciona-</OPTION>\n\t\t\t\t\t<OPTION value=\"0\" ".toCharArray();
    __oracle_jsp_text[31] = 
    ">Femenino</OPTION>\n\t\t\t\t\t<OPTION value=\"1\" ".toCharArray();
    __oracle_jsp_text[32] = 
    ">Masculino</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</font>\n\t\t</td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Ocupación:</font>\n\t\t</td>\n\t\t<td width=\"233\">\n\t\t\t<FONT size=\"2\" face=\"Arial\">\n\t\t\t\t<SELECT name=\"reg_ocupacion\" class=\"blue200\">\n\t\t\t\t\t<OPTION value=\"-1\">--Selecciona--</OPTION>\n\t\t\t\t\t<OPTION value=\"HOGAR\" ".toCharArray();
    __oracle_jsp_text[33] = 
    ">Hogar</OPTION>\n\t\t\t\t\t<OPTION value=\"ESTUDIANTE\" ".toCharArray();
    __oracle_jsp_text[34] = 
    ">Estudiante</OPTION>\n\t\t\t\t\t<OPTION value=\"PROFESIONISTA\" ".toCharArray();
    __oracle_jsp_text[35] = 
    ">Profesionista</OPTION>\n\t\t\t\t\t<OPTION value=\"EMPLEADO\" ".toCharArray();
    __oracle_jsp_text[36] = 
    ">Empleado</OPTION>\n\t\t\t\t\t<OPTION value=\"INVESTIGADOR\" ".toCharArray();
    __oracle_jsp_text[37] = 
    ">Investigador</OPTION>\n\t\t\t\t\t<OPTION value=\"PROFESOR\" ".toCharArray();
    __oracle_jsp_text[38] = 
    ">Profesor</OPTION>\n\t\t\t\t\t<OPTION value=\"REPORTERO\" ".toCharArray();
    __oracle_jsp_text[39] = 
    ">Reportero</OPTION>\n\t\t\t\t\t<OPTION value=\"OTRO\" ".toCharArray();
    __oracle_jsp_text[40] = 
    ">Otro</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t</td>\n\t\t<TD width=\"155\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Sector:</FONT></TD>\n\t\t<TD width=\"276\">\n\t\t\t<FONT size=\"2\" face=\"Arial\">\n\t\t\t\t<SELECT name=\"reg_sector\" class=\"blue200\">\n\t\t\t\t\t<OPTION value=\"-1\">--Selecciona--</OPTION>\n\t\t\t\t\t<OPTION value=\"EMPRESARIAL\" ".toCharArray();
    __oracle_jsp_text[41] = 
    ">Empresarial</OPTION>\n\t\t\t\t\t<OPTION value=\"GOBIERNO\" ".toCharArray();
    __oracle_jsp_text[42] = 
    ">Gobierno</OPTION>\n\t\t\t\t\t<OPTION value=\"ACADÃ‰MICO\" ".toCharArray();
    __oracle_jsp_text[43] = 
    ">Académico</OPTION>\n\t\t\t\t\t<OPTION value=\"MEDIOS DE COMUNICACIÃ“N\" ".toCharArray();
    __oracle_jsp_text[44] = 
    ">Medios de COMUNICACIÃ“N</OPTION>\n\t\t\t\t\t<OPTION value=\"PARTICULAR\" ".toCharArray();
    __oracle_jsp_text[45] = 
    ">Particular</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Domicilio:</FONT></TD>\n\t\t<TD colspan=\"3\"><FONT size=\"2\" face=\"Arial\"> <INPUT size=\"50\"\n\t\t\ttype=\"text\" name=\"reg_domicilio\" class=\"blue500\" value=\"".toCharArray();
    __oracle_jsp_text[46] = 
    "\"></FONT></TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<TD width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Pais:</FONT></TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT size=\"2\" face=\"Arial\">\n\t\t\t\t<SELECT name=\"reg_pais\" class=\"blue200\">\n\t\t\t\t\t<OPTION value=\"-1\">-Selecciona-</OPTION>\n\t\t\t\t\t<OPTION value=\"MEXICO\" ".toCharArray();
    __oracle_jsp_text[47] = 
    ">México</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Estado:</font>\n\t\t</td>\n\t\t<td width=\"233\">\n\t\t\t<font size=\"2\" face=\"Arial\">\n\t\t\t\t<SELECT name=\"reg_estado\" class=\"blue200\" onchange=\"cambioMun(this)\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\">\n\t\t\t\t\t<OPTION value=\"-1\">- Selecciona -</OPTION>\n\t\t\t\t\t<OPTION value=\"AGUASCALIENTES\" ".toCharArray();
    __oracle_jsp_text[48] = 
    ">Aguascalientes</OPTION>\n\t\t\t\t\t<OPTION value=\"BAJA CALIFORNIA\" ".toCharArray();
    __oracle_jsp_text[49] = 
    ">Baja California</OPTION>\n\t\t\t\t\t<OPTION value=\"BAJA CALIFORNIA SUR\" ".toCharArray();
    __oracle_jsp_text[50] = 
    ">Baja California Sur</OPTION>\n\t\t\t\t\t<OPTION value=\"CAMPECHE\" ".toCharArray();
    __oracle_jsp_text[51] = 
    ">Campeche</OPTION>\n\t\t\t\t\t<OPTION value=\"CHIAPAS\" ".toCharArray();
    __oracle_jsp_text[52] = 
    ">Chiapas</OPTION>\n\t\t\t\t\t<OPTION value=\"CHIHUAHUA\" ".toCharArray();
    __oracle_jsp_text[53] = 
    ">Chihuahua</OPTION>\n\t\t\t\t\t<OPTION value=\"COAHUILA\" ".toCharArray();
    __oracle_jsp_text[54] = 
    ">Coahuila</OPTION>\n\t\t\t\t\t<OPTION value=\"COLIMA\" ".toCharArray();
    __oracle_jsp_text[55] = 
    ">Colima</OPTION>\n\t\t\t\t\t<OPTION value=\"DISTRITO FEDERAL\" ".toCharArray();
    __oracle_jsp_text[56] = 
    ">Distrito Federal</OPTION>\n\t\t\t\t\t<OPTION value=\"DURANGO\" ".toCharArray();
    __oracle_jsp_text[57] = 
    ">Durango</OPTION>\n\t\t\t\t\t<OPTION value=\"GUANAJUATO\" ".toCharArray();
    __oracle_jsp_text[58] = 
    ">Guanajuato</OPTION>\n\t\t\t\t\t<OPTION value=\"GUERRERO\" ".toCharArray();
    __oracle_jsp_text[59] = 
    ">Guerrero</OPTION>\n\t\t\t\t\t<OPTION value=\"HIDALGO\" ".toCharArray();
    __oracle_jsp_text[60] = 
    ">Hidalgo</OPTION>\n\t\t\t\t\t<OPTION value=\"JALISCO\" ".toCharArray();
    __oracle_jsp_text[61] = 
    ">Jalisco</OPTION>\n\t\t\t\t\t<OPTION value=\"MICHOACAN\" ".toCharArray();
    __oracle_jsp_text[62] = 
    ">Michoacan</OPTION>\n\t\t\t\t\t<OPTION value=\"MORELOS\" ".toCharArray();
    __oracle_jsp_text[63] = 
    ">Morelos</OPTION>\n\t\t\t\t\t<OPTION value=\"EDOMEXICO\" ".toCharArray();
    __oracle_jsp_text[64] = 
    ">Edo. de México</OPTION>\n\t\t\t\t\t<OPTION value=\"NAYARIT\" ".toCharArray();
    __oracle_jsp_text[65] = 
    ">Nayarit</OPTION>\n\t\t\t\t\t<OPTION value=\"NUEVO LEON\" ".toCharArray();
    __oracle_jsp_text[66] = 
    ">Nuevo León</OPTION>\n\t\t\t\t\t<OPTION value=\"OAXACA\" ".toCharArray();
    __oracle_jsp_text[67] = 
    ">Oaxaca</OPTION>\n\t\t\t\t\t<OPTION value=\"PUEBLA\" ".toCharArray();
    __oracle_jsp_text[68] = 
    ">Puebla</OPTION>\n\t\t\t\t\t<OPTION value=\"QUERETARO\" ".toCharArray();
    __oracle_jsp_text[69] = 
    ">Querétaro</OPTION>\n\t\t\t\t\t<OPTION value=\"QUINTANA ROO\" ".toCharArray();
    __oracle_jsp_text[70] = 
    ">Quintana Roo</OPTION>\n\t\t\t\t\t<OPTION value=\"SAN LUIS POTOSI\" ".toCharArray();
    __oracle_jsp_text[71] = 
    ">San Luis Potosí</OPTION>\n\t\t\t\t\t<OPTION value=\"SINALOA\" ".toCharArray();
    __oracle_jsp_text[72] = 
    ">Sinaloa</OPTION>\n\t\t\t\t\t<OPTION value=\"SONORA\" ".toCharArray();
    __oracle_jsp_text[73] = 
    ">Sonora</OPTION>\n\t\t\t\t\t<OPTION value=\"TABASCO\" ".toCharArray();
    __oracle_jsp_text[74] = 
    ">Tabasco</OPTION>\n\t\t\t\t\t<OPTION value=\"TAMAULIPAS\" ".toCharArray();
    __oracle_jsp_text[75] = 
    ">Tamaulipas</OPTION>\n\t\t\t\t\t<OPTION value=\"TLAXCALA\" ".toCharArray();
    __oracle_jsp_text[76] = 
    ">Tlaxcala</OPTION>\n\t\t\t\t\t<OPTION value=\"VERACRUZ\" ".toCharArray();
    __oracle_jsp_text[77] = 
    ">Veracruz</OPTION>\n\t\t\t\t\t<OPTION value=\"YUCATAN\" ".toCharArray();
    __oracle_jsp_text[78] = 
    ">Yucatán</OPTION>\n\t\t\t\t\t<OPTION value=\"ZACATECAS\" ".toCharArray();
    __oracle_jsp_text[79] = 
    ">Zacatecas</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</font>\n\t\t</td>\n\t\t<td width=\"155\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Municipio:</font>\n\t\t</td>\n\t\t<td width=\"276\">\n\t\t\t<font size=\"2\" face=\"Arial\">\n\t\t\t<input name=\"reg_municipio\" value=\"".toCharArray();
    __oracle_jsp_text[80] = 
    "\" Size=24 class=\"blue200\"></font>\n\t\t\t\n\t\t</td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR VALIGN=top>\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Telefono:</font>\n\t\t</td>\n\t\t<td width=\"233\"><font size=\"2\" face=\"Arial\"> <input\n\t\t\tname=\"reg_telefono\" value=\"".toCharArray();
    __oracle_jsp_text[81] = 
    "\" Size=25 onfocus=\"\" class=\"blue200\"> </font>\n\t\t</td>\n\t\t<td width=\"155\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Correo Electronico:</font>\n\t\t</td>\n\t\t<td width=\"276\"><font size=\"2\" face=\"Arial\"> <input name=\"reg_mail\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[82] = 
    "\" Size=24 class=\"blue200\"> </font></td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">\n\t\t\t<A href=\"EditarPassword.jsp\"><u><font size=\"2\" color=\"#004080\" face=\"Arial\">Editar Mi Contraseña</font></u></A>\n\t\t</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t\n</TABLE>\n<br>\n</DIV></DIV></DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
