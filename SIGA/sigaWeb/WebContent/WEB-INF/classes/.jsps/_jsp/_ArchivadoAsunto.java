package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.taglib.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.*;


public class _ArchivadoAsunto extends com.orionserver.http.OrionHttpJspPage {


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
    _ArchivadoAsunto page = this;
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
      out.write(__oracle_jsp_text[3]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
      	}
      
      out.write(__oracle_jsp_text[4]);
      
      	String strIdAsunto		=	"";
      	String strUnidad		=	"";
      	String strArea			=	"";
      	String strFondo			=	"";
      	String strSubFondo		=	"";
      	String strSeccion		=	"";
      	String strSerie			=	"";
      	String strSubserie		=	"";
      	String strFechaApertura	=	"";
      	String strFechaCierre	=	"";
      	String strAsunto		=	"";
      	String strValorDocto	=	"";
      	String strVigenciaDocto	=	"";
      	String strFojas			=	"";
      	String strLegajos		=	"";	
      	String strTipoAsunto 	= 	"";
      	String strFechaCla		=	"";
      	String strFundamento	=	"";
      	String strPeriodoReserva=	"";
      	String strDesclasificacion= "";
      	String strAmpliacion	=	"";
      	String strNumAnios		=	"";
      	String strDesclasificacion1="";
      	String strResponsableExp=	"";
      	String strResponsableCla=	"";
      	String strAccion		=	"";
      	String strA				=	"";
      	String strIdSubfondo	=	"";
      
      	strIdAsunto	= 	(request.getParameter("idAsunto") != null)?request.getParameter("idAsunto"):"";
      	strAsunto	= 	(request.getParameter("asunto") != null)?request.getParameter("asunto"):"";
      	strAccion	= 	request.getParameter("accion");
      	strA		= 	(request.getParameter("a") != null)?request.getParameter("a"):"";
      	strArea		=	(request.getParameter("area") != null)?request.getParameter("area"):"";
      	strIdSubfondo=	(request.getParameter("id_sub") != null)?request.getParameter("id_sub"):"";
      	strSubFondo	=	(request.getParameter("id_sec") != null)?request.getParameter("id_sec"):"";
      	
      	if(strIdAsunto != null && strAccion != null && strAccion.equals("guardar")){
      		//strUnidad		=	request.getParameter("archivadoUnidad");
      		//strArea			=	request.getParameter("archivadoArea");
      		//strFondo		=	request.getParameter("archivadoFondo");
      		strSubFondo		=	request.getParameter("archivadoSubfondo");
      		strSeccion		=	request.getParameter("archivadoSeccion");
      		strSerie		=	request.getParameter("archivadoSerie");
      		strSubserie		=	request.getParameter("archivadoSubserie");
      		strFechaApertura=	request.getParameter("archivadoFechaApertura");
      		strFechaCierre	=	request.getParameter("archivadoFechaCierre");
      		//strAsunto		=	request.getParameter("archivadoAsunto");
      		strValorDocto	=	request.getParameter("archivadoValorDocto");
      		strVigenciaDocto=	request.getParameter("archivadoVigenciaDocto");
      		strFojas		=	request.getParameter("archivadoFojas");
      		strLegajos		=	request.getParameter("archivadoLegajos");
      		strTipoAsunto 	= 	request.getParameter("archivadoTipoAsunto");
      		strFechaCla		=	request.getParameter("archivadoFechaCla");
      		strFundamento	=	request.getParameter("archivadoFundamento");
      		strPeriodoReserva=	request.getParameter("archivadoPeriodoReserva");
      		strDesclasificacion= request.getParameter("archivadoDesclasificacion");
      		strAmpliacion	=	request.getParameter("archivadoAmpliacion");
      		strNumAnios		=	request.getParameter("archivadoNumAnios");
      		strDesclasificacion1=request.getParameter("archivadoDesclasificacion1");
      		strResponsableExp=	request.getParameter("archivadoResponsableExp");
      		strResponsableCla=	request.getParameter("archivadoResponsableCla");
      		strIdAsunto		=	request.getParameter("idAsunto");
      		
      		boolean bInserta = ActualizaArchivado.InsertarArchivado(strSubFondo,
      																strSeccion, strSerie, strSubserie, strFechaApertura,
      																strFechaCierre, strValorDocto, strVigenciaDocto,
      																strFojas, strLegajos, strTipoAsunto, strFechaCla,
      																strFundamento, strPeriodoReserva, strDesclasificacion, strAmpliacion,
      																strNumAnios, strDesclasificacion1, strResponsableExp, strResponsableCla,
      																strIdAsunto);
      		try{
      			response.sendRedirect("AsuntoTurnado.jsp?id_asunto="+strIdAsunto);
      		}catch(java.io.IOException io){
      			//System.err.println("Error de redireccionamiento-->"+io);
      		}
      	}
      	if(strA != null && strA.length() > 0){
      		String strDatos[][] = 	ActualizaArchivado.getDatosArchivado(strIdAsunto);
      		//String strArea		=	ActualizaArea.NombreArea()
      		strSubFondo		=	strDatos[0][0];
      		strSeccion		=	strDatos[0][1];
      		strSerie		=	strDatos[0][2];
      		strSubserie		=	strDatos[0][3];
      		strFechaApertura=	Utilerias.formatearFechas(strDatos[0][4]);
      		strFechaCierre	=	Utilerias.formatearFechas(strDatos[0][5]);
      		strValorDocto	=	strDatos[0][6];
      		strVigenciaDocto=	Utilerias.formatearFechas(strDatos[0][7]);
      		strFojas		=	strDatos[0][8];
      		strLegajos		=	strDatos[0][9];
      		strTipoAsunto 	= 	strDatos[0][10];
      		strFechaCla		=	Utilerias.formatearFechas(strDatos[0][11]);
      		strFundamento	=	strDatos[0][12];
      		strPeriodoReserva=	strDatos[0][13];
      		strDesclasificacion= Utilerias.formatearFechas(strDatos[0][14]);
      		strAmpliacion	=	strDatos[0][15];
      		strNumAnios		=	strDatos[0][16];
      		strDesclasificacion1=Utilerias.formatearFechas(strDatos[0][17]);
      		strResponsableExp=	strDatos[0][18];
      		strResponsableCla=	strDatos[0][19];
      	}
      
      out.write(__oracle_jsp_text[5]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[6]);
       if(strA != null && strA.length() > 0){ 
      out.write(__oracle_jsp_text[7]);
      //System.err.println("Area="+strArea);
      out.write(__oracle_jsp_text[8]);
      //System.err.println("Asunto="+strAsunto);
      out.write(__oracle_jsp_text[9]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[10]);
       }else{ 
      out.write(__oracle_jsp_text[11]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[12]);
       } 
      out.write(__oracle_jsp_text[13]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[14]);
      out.print(strArea);
      out.write(__oracle_jsp_text[15]);
      out.print(strAsunto);
      out.write(__oracle_jsp_text[16]);
       if(!strA.equals("1")){ 
      out.write(__oracle_jsp_text[17]);
       }else{ 
      out.write(__oracle_jsp_text[18]);
       } 
      out.write(__oracle_jsp_text[19]);
      out.print(strUnidad);
      out.write(__oracle_jsp_text[20]);
      out.print(strArea);
      out.write(__oracle_jsp_text[21]);
      out.print(strFondo);
      out.write(__oracle_jsp_text[22]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getSubFondoCombo());
        __jsp_taghandler_1.setName("archivadoSubfondo");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strSubFondo));
        __jsp_taghandler_1.setClassHtml("blue500");
        __jsp_taghandler_1.setScript("onchange='subfondo()'");
        __jsp_taghandler_1.setTextoNoSeleccion("-- Selecciona una opción --");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[23]);
       if(strA != null && strA.length() > 0){ 
      out.write(__oracle_jsp_text[24]);
       //System.err.println("Entra si a == null"); 
      out.write(__oracle_jsp_text[25]);
       //System.err.println("*******"); 
      out.write(__oracle_jsp_text[26]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getSeccionCombo(strSubFondo));
        __jsp_taghandler_2.setName("archivadoSeccion");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strSeccion));
        __jsp_taghandler_2.setClassHtml("blue500");
        __jsp_taghandler_2.setTextoNoSeleccion("-- Selecciona una opción --");
        __jsp_taghandler_2.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[27]);
       }else{ 
      out.write(__oracle_jsp_text[28]);
       if(strIdSubfondo != null && strIdSubfondo.length() > 0){ 
      out.write(__oracle_jsp_text[29]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setData(ComboData.getSeccionCombo(strIdSubfondo));
        __jsp_taghandler_3.setName("archivadoSeccion");
        __jsp_taghandler_3.setSize(1);
        __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( strSeccion));
        __jsp_taghandler_3.setClassHtml("blue500");
        __jsp_taghandler_3.setTextoNoSeleccion("-- Selecciona una opción --");
        __jsp_taghandler_3.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[30]);
       }else{ 
      out.write(__oracle_jsp_text[31]);
       } 
      out.write(__oracle_jsp_text[32]);
       } 
      out.write(__oracle_jsp_text[33]);
      out.print(strSerie);
      out.write(__oracle_jsp_text[34]);
      out.print(strSubserie);
      out.write(__oracle_jsp_text[35]);
      out.print(strFechaApertura);
      out.write(__oracle_jsp_text[36]);
      out.print(strFechaCierre);
      out.write(__oracle_jsp_text[37]);
      out.print(strAsunto);
      out.write(__oracle_jsp_text[38]);
      out.print(strValorDocto);
      out.write(__oracle_jsp_text[39]);
      out.print(strVigenciaDocto);
      out.write(__oracle_jsp_text[40]);
      out.print(strFojas);
      out.write(__oracle_jsp_text[41]);
      out.print(strLegajos);
      out.write(__oracle_jsp_text[42]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_4=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setData(ComboData.getClasificacionAreaCombo());
        __jsp_taghandler_4.setName("archivadoTipoAsunto");
        __jsp_taghandler_4.setSize(1);
        __jsp_taghandler_4.setSelected(OracleJspRuntime.toStr( strTipoAsunto));
        __jsp_taghandler_4.setClassHtml("blue500");
        __jsp_taghandler_4.setTextoNoSeleccion("-- Selecciona un opción --");
        __jsp_taghandler_4.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[43]);
      out.print(strFechaCla);
      out.write(__oracle_jsp_text[44]);
      out.print(strFundamento);
      out.write(__oracle_jsp_text[45]);
      out.print(strPeriodoReserva);
      out.write(__oracle_jsp_text[46]);
      out.print(strDesclasificacion);
      out.write(__oracle_jsp_text[47]);
      out.print(strNumAnios);
      out.write(__oracle_jsp_text[48]);
      out.print(strDesclasificacion1);
      out.write(__oracle_jsp_text[49]);
      out.print(strResponsableExp);
      out.write(__oracle_jsp_text[50]);
      out.print(strResponsableCla);
      out.write(__oracle_jsp_text[51]);

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
  private static final char __oracle_jsp_text[][]=new char[52][];
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
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Archivado Asunto</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n\tfunction regresar(){\n\t\tlocation.assign('AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[6] = 
    "');\n\t\t//history.go(-1);\n\t}\n\tfunction subfondo(){\n\t\tdoc = document.archivadoAsunto;\n\t\tvar a = doc.archivadoSubfondo.value;\n\t\tvar b = doc.archivadoSubfondo.value;\n\t\tvar c = doc.area.value;\n\t\tvar d = doc.asunto.value;\n\t\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\tlocation.assign('ArchivadoAsunto.jsp?idAsunto=".toCharArray();
    __oracle_jsp_text[10] = 
    "&asunto='+d+'&area='+c+'&id_sub='+a+'&id_sec='+b+'&a=1');\n\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\tlocation.assign('ArchivadoAsunto.jsp?idAsunto=".toCharArray();
    __oracle_jsp_text[12] = 
    "&asunto='+d+'&area='+c+'&id_sub='+a+'&id_sec='+b);\n\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t//location.assign('FlujoAtencion.jsp?id_area=1');\n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"ArchivadoAsunto.jsp\" name=\"archivadoAsunto\" method=\"post\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"guardar\">\n<INPUT type=\"hidden\" name=\"idAsunto\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\">\n<INPUT type=\"hidden\" name=\"area\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\">\n<INPUT type=\"hidden\" name=\"asunto\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TBODY>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"110\"><input type=\"button\" onclick=\"regresar()\"\n\t\t\t\tvalue=\"Regresar\" class=\"blue100\">&nbsp;</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t<td width=\"110\"><input type=\"button\" onclick=\"guardarArchivado()\"\n\t\t\t\tvalue=\"Guardar\" class=\"blue100\"></td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t<td width=\"110\">&nbsp;</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t<td width=\"263\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"400\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t</TBODY>\n</table>\n</DIV>\n<br>\n<DIV class=documentBody id=Body>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos\n\t\t\tbásicos</font></b></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"386\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</tr>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Unidad Administrativa:</FONT>\n\t\t\t</TD>\n\t\t\t<TD colspan=\"3\">\n\t\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t\t<INPUT name=\"archivadoUnidad\" class=\"blue500\" value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\">\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td width=\"226\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Unidad Generadora:</FONT>\n\t\t\t</TD>\n\t\t\t<TD colspan=\"3\">\n\t\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t\t<INPUT name=\"archivadoArea\" class=\"blue500\" value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\">\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td width=\"226\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fondo:</FONT>\n\t\t\t</TD>\n\t\t\t<TD colspan=\"3\">\n\t\t\t\t<INPUT name=\"archivadoFondo\" class=\"blue200\" value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td width=\"226\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<b><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Subfondo:</FONT></b>\n\t\t\t</TD>\n\t\t\t<TD colspan=\"3\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td width=\"226\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<b><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Sección:</FONT></b>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t<TD colspan=\"3\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t<SELECT name=\"archivadoSeccion\" class=\"blue500\">\n\t\t\t\t\t<OPTION value=\"-1\">-- Selecciona una opción --</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td width=\"226\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Serie:</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"226\">\n\t\t\t\t<INPUT name=\"archivadoSerie\" class=\"blue200\" value=\"".toCharArray();
    __oracle_jsp_text[34] = 
    "\">\n\t\t\t</TD>\n\t\t\t<TD width=\"67\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Subserie:</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"380\">\n\t\t\t\t<INPUT name=\"archivadoSubserie\" class=\"blue200\" value=\"".toCharArray();
    __oracle_jsp_text[35] = 
    "\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td width=\"226\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fecha de Apertura:</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"226\">\n\t\t\t\t<INPUT name=\"archivadoFechaApertura\" class=\"blue100\" value=\"".toCharArray();
    __oracle_jsp_text[36] = 
    "\">\n\t\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick='show_calendar(\"forms[0].archivadoFechaApertura\");'></A>\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"67\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fecha de Cierre:</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"380\">\n\t\t\t\t<INPUT name=\"archivadoFechaCierre\" class=\"blue100\" value=\"".toCharArray();
    __oracle_jsp_text[37] = 
    "\">\n\t\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick='show_calendar(\"forms[0].archivadoFechaCierre\");'></A>\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td width=\"226\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Asunto:</FONT>\n\t\t\t</TD>\n\t\t\t<TD colspan=\"3\">\n\t\t\t\t<INPUT name=\"archivadoAsunto\" class=\"blue500\" value=\"".toCharArray();
    __oracle_jsp_text[38] = 
    "\">\n\t\t\t</TD>\n\t\t\t\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td width=\"226\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Valor Documental:</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"226\">\n\t\t\t\t<INPUT name=\"archivadoValorDocto\" class=\"blue200\" value=\"".toCharArray();
    __oracle_jsp_text[39] = 
    "\">\n\t\t\t</TD>\n\t\t\t<TD width=\"67\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Vigencia Documental:</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"380\">\n\t\t\t\t<INPUT name=\"archivadoVigenciaDocto\" class=\"blue100\" value=\"".toCharArray();
    __oracle_jsp_text[40] = 
    "\">\n\t\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick='show_calendar(\"forms[0].archivadoVigenciaDocto\");'></A>\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td width=\"226\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Número de Fojas útiles:</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"226\">\n\t\t\t\t<INPUT name=\"archivadoFojas\" class=\"blue200\" value=\"".toCharArray();
    __oracle_jsp_text[41] = 
    "\">\n\t\t\t</TD>\n\t\t\t<TD width=\"67\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Número de Legajos:</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"380\">\n\t\t\t\t<INPUT name=\"archivadoLegajos\" class=\"blue200\" value=\"".toCharArray();
    __oracle_jsp_text[42] = 
    "\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td width=\"226\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Carácter\n\t\t\tde la información</font></b></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"386\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</tr>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<b><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Clasificación del Asunto:</FONT></b>\n\t\t\t</TD>\n\t\t\t<TD colspan=\"3\">\n\t\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"356\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fecha de Clasificación:</FONT>\n\t\t\t</TD>\n\t\t\t<TD colspan=\"3\">\n\t\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t\t<INPUT name=\"archivadoFechaCla\" class=\"blue100\" value=\"".toCharArray();
    __oracle_jsp_text[44] = 
    "\">\n\t\t\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick='show_calendar(\"forms[0].archivadoFechaCla\");'></A>\n\t\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"356\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fundamento Legal:</FONT>\n\t\t\t</TD>\n\t\t\t<TD colspan=\"3\">\n\t\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t\t<INPUT name=\"archivadoFundamento\" class=\"blue500\" value=\"".toCharArray();
    __oracle_jsp_text[45] = 
    "\">\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"356\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Periodo de Reserva:</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"226\">\n\t\t\t\t<INPUT name=\"archivadoPeriodoReserva\" class=\"blue200\" value=\"".toCharArray();
    __oracle_jsp_text[46] = 
    "\">\n\t\t\t</TD>\n\t\t\t<TD width=\"67\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fecha de DesClasificación:</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"356\">\n\t\t\t\t<INPUT name=\"archivadoDesclasificacion\" class=\"blue100\" value=\"".toCharArray();
    __oracle_jsp_text[47] = 
    "\">\n\t\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick='show_calendar(\"forms[0].archivadoDesclasificacion\");'></A>\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td width=\"226\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"356\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Ampliación del Periodo de Reserva:</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"226\">\n\t\t\t\t<SELECT name=\"archivadoAmpliacion\" class=\"blue50\">\n\t\t\t\t\t<OPTION value=\"0\">Si</OPTION>\n\t\t\t\t\t<OPTION value=\"1\">No</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</TD>\n\t\t\t<TD width=\"67\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Numero de Años:</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"356\">\n\t\t\t\t<INPUT name=\"archivadoNumAnios\" class=\"blue100\" value=\"".toCharArray();
    __oracle_jsp_text[48] = 
    "\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td width=\"226\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"356\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\">\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fecha de DesClasificación:</FONT>\n\t\t\t</TD>\n\t\t\t<TD colspan=\"3\">\n\t\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t\t<INPUT name=\"archivadoDesclasificacion1\" class=\"blue100\" value=\"".toCharArray();
    __oracle_jsp_text[49] = 
    "\">\n\t\t\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick='show_calendar(\"forms[0].archivadoDesclasificacion1\");'></A>\n\t\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"190\">&nbsp;</td>\n\t\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"356\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"432\" align=\"center\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t<INPUT name=\"archivadoResponsableExp\" class=\"blue200\" value=\"".toCharArray();
    __oracle_jsp_text[50] = 
    "\">\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"431\" align=\"center\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t<INPUT name=\"archivadoResponsableCla\" class=\"blue200\" value=\"".toCharArray();
    __oracle_jsp_text[51] = 
    "\">\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"432\" align=\"center\">\n\t\t\t<FONT face=\"Arial\" size=\"2\" color=\"#004080\">\n\t\t\t\tNombre del Responsable del<br>\n\t\t\t\tde la Unidad Generadora del Expediente\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"431\" align=\"center\">\n\t\t\t<FONT face=\"Arial\" size=\"2\" color=\"#004080\">\n\t\t\t\tNombre del Responsable de<br>\n\t\t\t\tla Clasificación de la información\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n<br>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
