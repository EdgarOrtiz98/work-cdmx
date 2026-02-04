package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;


public class _ImprimeInstruccionTerminada extends com.orionserver.http.OrionHttpJspPage {


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
    _ImprimeInstruccionTerminada page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      
      	String strIdInstruccion		=	""; //Contiene el ID de la instrucción
      	strIdInstruccion		=	(request.getParameter("idInstruccion") != null)?request.getParameter("idInstruccion"):"";
          String strDelegado =(request.getParameter("delegado")!=null)?request.getParameter("delegado"):"";
          
          boolean bHistorial=false;
          if(strIdInstruccion !=null)
          	bHistorial	=	ActualizaHistorial.TieneHistorial(strIdInstruccion);
          request.setAttribute("idInstruccion",strIdInstruccion);
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp = request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp+"?id_ins="+strIdInstruccion);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("E/RROR:"+io.getMessage());
      		}
      	}
      	String [][]historialInstruccion=ActualizaHistorial.getHistorialInstruccion(strIdInstruccion);
      	request.setAttribute("historial",historialInstruccion);
      
      out.write(__oracle_jsp_text[3]);
      
      
      String strIdAsunto			=	""; //Contiene el ID del Asunto
      	String strNombre			=	"";
      	String strTelefono			=	"";
      	String strCorreo			=	"";
      	String strTipoAtencion		=	"";
      	String strAcceso			=	"";
      	String strAsunto			=	"";
      	String strPaso				=	"";
      	String strFecGeneracion		=	"";
      	String strFecVencimiento	=	"";
      	String strEstatus			=	"";
      	String strTurnadoPor		=	"";
      	String strFolioRecepcion	=	"";
      	String strFolioTurnado		=	"";
      	String strFolioIntermedio	=	"";
      	String strInstruccion		=	"";
      	String strInstruccionOtro	=	"";
      	String strSintesis			=	"";
      	String strAtencion			=	"";
      	String strVerDocto			=	"";
      	String strNombreInstruccion	=	"";
      	String strAvance			=	"";
      	String strMostrarHabilitado	=	"";
      	String strUsuarioOriginal	=	"";
          String strFirmaDigital		= 	"";
          String strFechaTerminacionReal = "";
      
       
      out.write(__oracle_jsp_text[4]);
      
      
          strMostrarHabilitado	=	request.getParameter("tur");
      	
      	if(strInstruccion != null)
      	{
      		String strDatosInstrucciones[][]	=	ActualizaInstrucciones.getInstruccionDatos(strIdInstruccion);
      		
      		strIdAsunto			=	ActualizaInstrucciones.getIdAsuntoInstruccion(strIdInstruccion);
      		strNombre			=	strDatosInstrucciones[0][13];
      		strTelefono			=	strDatosInstrucciones[0][14];
      		strCorreo			=	strDatosInstrucciones[0][15];
      		strTipoAtencion		=	strDatosInstrucciones[0][3];
      		strAcceso			=	strDatosInstrucciones[0][4];
      		strAsunto			=	strDatosInstrucciones[0][10];
      		//strPaso				=	strDatosInstrucciones[0][17];
      		strFecGeneracion	=	strDatosInstrucciones[0][7];
      		strFecVencimiento	=	strDatosInstrucciones[0][8];
      		strTurnadoPor		=	strDatosInstrucciones[0][12];
      		strFolioRecepcion	=	strDatosInstrucciones[0][16];
      		strFolioIntermedio	=	strDatosInstrucciones[0][17];
      		strInstruccion		=	strDatosInstrucciones[0][1];
      		strInstruccionOtro	=	strDatosInstrucciones[0][9];
      		strSintesis			=	strDatosInstrucciones[0][11];
      		strFolioTurnado		=	strDatosInstrucciones[0][18];
      		strEstatus			=	strDatosInstrucciones[0][19];
      		strAvance			=	strDatosInstrucciones[0][20];
      		strDelegado			=	strDatosInstrucciones[0][21];
      		strUsuarioOriginal	=	strDatosInstrucciones[0][0];
      		strFirmaDigital		= 	strDatosInstrucciones[0][23];
              strFechaTerminacionReal = strDatosInstrucciones[0][24];
              
      		request.setAttribute("delegado",strDelegado);
              
      		
      		////System.out.println("Avance="+strAvance);
      		////System.out.println("DelegadoA="+strDelegado);
      		
      		if(strTipoAtencion.equals("0"))
      			strAtencion = "Ejecutor";
      		else
      			strAtencion = "Informativo";
      		
      		if(strAcceso.equals("0"))
      			strVerDocto = "No";
      		else
      			strVerDocto = "Si";
      		
      		//** Verifica si del query trae el ID de la instrucción
      		//** ó otra instrucción 
      		if(strInstruccion.length() == 0)
      			strNombreInstruccion = strInstruccionOtro;
      
      		bHistorial	=	ActualizaHistorial.TieneHistorial(strIdInstruccion);
              request.setAttribute("existeHistorial",Boolean.valueOf(bHistorial));
      		
      	}
      
      
      
      
      
      
      
      
      
      
      
       
      out.write(__oracle_jsp_text[5]);
      out.print(strFolioTurnado);
      out.write(__oracle_jsp_text[6]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[7]);
      out.print(strTelefono );
      out.write(__oracle_jsp_text[8]);
      out.print(strCorreo);
      out.write(__oracle_jsp_text[9]);
      out.print(strAtencion );
      out.write(__oracle_jsp_text[10]);
      out.print(strAcceso);
      out.write(__oracle_jsp_text[11]);
      out.print(strAsunto);
      out.write(__oracle_jsp_text[12]);
      out.print(strPaso);
      out.write(__oracle_jsp_text[13]);
      out.print(strFecGeneracion);
      out.write(__oracle_jsp_text[14]);
      out.print(strFecVencimiento);
      out.write(__oracle_jsp_text[15]);
      out.print(strDelegado );
      out.write(__oracle_jsp_text[16]);
      out.print(strTurnadoPor);
      out.write(__oracle_jsp_text[17]);
      out.print(strFolioRecepcion);
      out.write(__oracle_jsp_text[18]);
      out.print(strFolioIntermedio);
      out.write(__oracle_jsp_text[19]);
      out.print(strNombreInstruccion);
      out.write(__oracle_jsp_text[20]);
      out.print(strSintesis);
      out.write(__oracle_jsp_text[21]);
       if(bHistorial){ 
      out.write(__oracle_jsp_text[22]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(historialInstruccion);
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
            out.write(__oracle_jsp_text[23]);
             if(campo7.equals("1")){ 
            out.write(__oracle_jsp_text[24]);
            out.print( campo3 );
            out.write(__oracle_jsp_text[25]);
            String avanceUsuario=ActualizaUsuario.NombreUsuario(campo4);
            out.write(__oracle_jsp_text[26]);
            out.print(avanceUsuario);
            out.write(__oracle_jsp_text[27]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[28]);
            out.print( campo5 );
            out.write(__oracle_jsp_text[29]);
            out.print(campo5);
            out.write(__oracle_jsp_text[30]);
            out.print( campo6 );
            out.write(__oracle_jsp_text[31]);
             }else if(campo7.equals("2")){ 
            out.write(__oracle_jsp_text[32]);
            out.print( campo3 );
            out.write(__oracle_jsp_text[33]);
            out.print( ActualizaUsuario.NombreUsuario(campo4) );
            out.write(__oracle_jsp_text[34]);
            out.print( campo6 );
            out.write(__oracle_jsp_text[35]);
             }else if(campo7.equals("3")){ 
            out.write(__oracle_jsp_text[36]);
            out.print( campo3 );
            out.write(__oracle_jsp_text[37]);
            out.print( ActualizaInstrucciones.NombreUsuarioInstruccion(strIdInstruccion) );
            out.write(__oracle_jsp_text[38]);
            out.print( ActualizaUsuario.NombreUsuario(campo4) );
            out.write(__oracle_jsp_text[39]);
            out.print( campo6 );
            out.write(__oracle_jsp_text[40]);
             }else if(campo7.equals("4")){ 
            out.write(__oracle_jsp_text[41]);
            out.print( campo3 );
            out.write(__oracle_jsp_text[42]);
            out.print(ActualizaUsuario.NombreUsuario(strDelegado));
            out.write(__oracle_jsp_text[43]);
            out.print( campo6 );
            out.write(__oracle_jsp_text[44]);
             } 
            out.write(__oracle_jsp_text[45]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[46]);
       }else{ 
      out.write(__oracle_jsp_text[47]);
       } 
      out.write(__oracle_jsp_text[48]);
       
           boolean firmado=strFirmaDigital.equals("1");
      
      	if(firmado){
      out.write(__oracle_jsp_text[49]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[50]);
      out.print(strFechaTerminacionReal);
      out.write(__oracle_jsp_text[51]);
      
       }    
      
      out.write(__oracle_jsp_text[52]);

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
  private static final char __oracle_jsp_text[][]=new char[53][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Imprimir Instrucci&oacute;n Terminada</TITLE>\n\n<SCRIPT language=\"JavaScript\"> \n\n\tfunction imprime(){\n\n   \t\tdocument.forma.imprimeBtn.style.display='none';\n\t\tself.window.print();\n        self.close();\n\t}\n\n</SCRIPT>\n</HEAD>\n<BODY onBlur=\"window.focus()\" background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n\n\n\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\n\n\n<FORM action=\"ImprimeInstruccionTerminada.jsp\" name=\"forma\">\n<p align=\"left\"><input type=\"button\" onclick=\"imprime()\" name=\"imprimeBtn\" value=\"Imprimir\"></p>\n<div align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\">\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"22%\" align=\"right\"><font size=\"2\" color=\"#00204f\"\n\t\t\tface=\"Verdana\">Folio:&nbsp;</font></td>\n\t\t<td align=\"left\" width=\"29%\"><font size=\"2\" color=\"#00204f\"\n\t\t\tface=\"Verdana\"><b>".toCharArray();
    __oracle_jsp_text[6] = 
    "</b></font></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" bgcolor=\"#00204F\" colspan=\"4\"></td>\n\t</tr>\n</table>\n</div>\n<DIV class=documentBody id=Body>\n<div align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\">&nbsp;</td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"18%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"32%\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Nombre:</font>\n\t\t</td>\n\t\t<td colspan=\"3\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[7] = 
    "</font></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\">&nbsp;</td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"18%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"32%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Teléfono:</font>\n\t\t</td>\n\t\t<td width=\"29%\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[8] = 
    "</font></td>\n\t\t<td width=\"18%\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Correo\n\t\tElectrónico:</font></td>\n\t\t<td width=\"32%\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[9] = 
    "</font></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\"\n\t\t\talt=\"\">&nbsp;</td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"18%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"32%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Tipo de\n\t\tatención:</font></td>\n\t\t<td width=\"29%\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[10] = 
    "</font>\n\t\t</td>\n\t\t<td width=\"18%\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Acceso al\n\t\tDocumento Original:&nbsp;</font></td>\n\t\t<td width=\"32%\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[11] = 
    "</font>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\"\n\t\t\talt=\"\">&nbsp;</td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"18%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"32%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Asunto:</font>\n\t\t</td>\n\t\t<td colspan=\"3\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[12] = 
    "</font></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\">&nbsp;</td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"18%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"32%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Paso:</font>\n\t\t</td>\n\t\t<td colspan=\"3\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[13] = 
    "</font></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\">&nbsp;</td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"18%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"32%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha de\n\t\tgeneración:</font></td>\n\t\t<td width=\"29%\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[14] = 
    "</font>\n\t\t</td>\n\t\t<td><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha Vencimiento:</font>\n\t\t</td>\n\t\t<td width=\"32%\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[15] = 
    "</font>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\">&nbsp;</td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"18%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"32%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Estatus:</font>\n\t\t</td>\n\t\t<td width=\"29%\"><font size=\"2\" face=\"Arial\">Notificado</font></td>\n\t\t<td width=\"18%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"32%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\">&nbsp;</td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td colspan=\"2\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\">\n\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Delegado a:</font>\n\t\t</td>\n\t\t\n\t\t<td colspan=\"3\">\n\t\t\t<font size=\"2\" face=\"Arial\">\n\t\t\t ".toCharArray();
    __oracle_jsp_text[16] = 
    " \n\t\t\t</font>\n\t\t</td>\n\t\t\n\t\t<td colspan=\"3\"></td>\n\t\t\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\">&nbsp;</td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"18%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"32%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Asignada\n\t\tpor: </font></td>\n\t\t<td width=\"29%\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[17] = 
    "</font>\n\t\t</td>\n\t\t<td width=\"18%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"32%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\"\n\t\t\talt=\"\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Folio de\n\t\tRecepción:</font> <font size=\"2\" face=\"Arial\"> </font></td>\n\t\t<td colspan=\"3\"><font size=\"2\" face=\"Arial\">\n         ".toCharArray();
    __oracle_jsp_text[18] = 
    "</font>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\"\n\t\t\talt=\"\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Folio\n\t\tIntermedio:</font></td>\n\t\t<td width=\"29%\"><font size=\"2\" face=\"Arial\">\n        \n           </font>".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t</td>\n\t\t<td width=\"18%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"32%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\"\n\t\t\talt=\"\">&nbsp;</td>\n\t</tr>\n</table>\n</div>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">INSTRUCCION</font></b>\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"21%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"150%\" bgcolor=\"#00204F\" colspan=\"4\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\"\n\t\t\talt=\"\">&nbsp;</td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"21%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[20] = 
    "</font></td>\n\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\"\n\t\t\talt=\"\">&nbsp;</td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"21%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</table>\n</DIV>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">SINTESIS</font></b>\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;</td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"21%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[21] = 
    "</font></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\"\n\t\t\talt=\"\">&nbsp;</td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"21%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"29%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" bgcolor=\"#00204F\" colspan=\"4\"></td>\n\t</tr>\n</table>\n</DIV>\n<br>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"64%\" colspan=\"2\"><b><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">Historia de la instrucción</font></b>\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t<td width=\"21%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"14%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" bgcolor=\"#00204F\" colspan=\"4\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t<td width=\"100%\" colspan=\"4\">\n\t\t<font size=\"1\" color=\"#004080\" face=\"Arial\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "----><br>".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\tAvance del Usuario: ".toCharArray();
    __oracle_jsp_text[27] = 
    "/meve<br>\n\t\t\t\t<a href=\"Responder.jsp?id_his=".toCharArray();
    __oracle_jsp_text[28] = 
    "\">\n\t\t\t\t\t<font size=\"1\" color=\"#004080\" face=\"Arial\">\n\t\t\t\t\t\t<U>Avance de: ".toCharArray();
    __oracle_jsp_text[29] = 
    "%</U><input type=\"hidden\" name=\"avanceDeHdn\" value=\"".toCharArray();
    __oracle_jsp_text[30] = 
    "\">\n\t\t\t\t\t</font>\n\t\t\t\t</a><br>\n\t\t\t\tComentarios Adicionales: ".toCharArray();
    __oracle_jsp_text[31] = 
    "<br><br>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "----><br>\n\t\t\t\tDocumento Rechazado por: ".toCharArray();
    __oracle_jsp_text[34] = 
    "/meve<br>\n\t\t\t\tRazon de Rechazo: ".toCharArray();
    __oracle_jsp_text[35] = 
    "<br><br>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "----><br>\n\t\t\t\tDocumento Resignado a: ".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\tpor el Usuario: ".toCharArray();
    __oracle_jsp_text[39] = 
    "/meve<br>\n\t\t\t\tComentarios Adicionales: ".toCharArray();
    __oracle_jsp_text[40] = 
    "<br><br>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "----><br>\n\t\t\t\tDocumento Delegado a : ".toCharArray();
    __oracle_jsp_text[43] = 
    "<br>\n\t\t\t\tComentarios Adicionales: ".toCharArray();
    __oracle_jsp_text[44] = 
    "<br><br>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t</font>\n\t\t</td>\n\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" bgcolor=\"#00204F\" colspan=\"4\"></td>\n\t</tr>\n\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n  \n        <tr valign=\"top\" id=\"hileraFirmaId\" style=\"display:none\">        \n\t\t<td width=\"64%\" colspan=\"2\"><b><font size=\"2\" color=\"#004080\"\n\t\tface=\"Arial\">Firmado</font></b>\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t<td width=\"21%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"14%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\\\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n \n        <tr valign=\"top\">\n\t\t<td width=\"100%\" bgcolor=\"#00204F\" colspan=\"4\"></td>\n\t\t</tr>\n        <tr valign=\"top\">\n         <td align=\"center\">\n         <b>Usuario</b>\n         </td>\n\t\t <td align=\"center\">\n         <b>Fecha</b>\n\t\t</td>\n\t\t<TD align=\"center\">\t\t\n\t\t</TD>\n        </tr>\n        <tr valign=\"top\">\n         <td align=\"center\">\n\t\t\t\n\t\t</td>\n        </tr>\n        <tr valign=\"top\">\n        <td align=\"center\">\n         ".toCharArray();
    __oracle_jsp_text[50] = 
    " \n\t\t</td>\n        <td align=\"center\">\n         ".toCharArray();
    __oracle_jsp_text[51] = 
    "\n        </td>\n        <td align=\"center\">\n        <IMG src=\"../Imagenes/0.jpg\" alt=\"firmado\" width=\"30\" height=\"30\">\n        </td>\n        </tr>\n\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n</table>\n</DIV>\n</DIV>\n</FORM>\n\n\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
