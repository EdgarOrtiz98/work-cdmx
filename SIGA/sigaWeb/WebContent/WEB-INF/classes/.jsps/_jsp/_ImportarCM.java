package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.servlet.*;
import com.meve.sigma.actualiza.*;


public class _ImportarCM extends com.orionserver.http.OrionHttpJspPage {


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
    _ImportarCM page = this;
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
      
      	String contentUri = application.getInitParameter("content");
      	String passContent = application.getInitParameter("user");
      	String userContent = application.getInitParameter("passwd");
      	String strCM = request.getParameter("cm");
      	String strFolio = request.getParameter("Folio");
      	String strIdAsunto = request.getParameter("IdAsunto");
      	String strIdInstruccion = (request.getParameter("id_ins") != null)?request.getParameter("id_ins"):"";
      	String strUrl =	request.getParameter("url");
      	String a1 = request.getParameter("a");
      	String strIdInst = request.getParameter("id_ins");
      	String strActivarCM = application.getInitParameter("ActivarContent");
      	String strMessage = request.getParameter("mess");
      	String strName = request.getParameter("name");
      	String srtExcp = request.getParameter("excp");
              String srtArcRep = request.getParameter("arcrep");
              String srtArcBig = request.getParameter("arcbig");
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	String strIdUsuario =  BUsuario.getIdUsuario();
      	String strRol = BUsuario.getIdRol();
      	String content = "";
      	String strTmp3 = request.getRequestURI();
      
      	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
      
      	boolean bValidaEstatus = false;
      	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
      	if (strIdAsunto!=null && !strIdAsunto.equals("")){
      		if (strIdInstruccion!=null && !strIdInstruccion.equals("")){
      			if (strEstValidacion.equals("")){
      				strEstValidacion = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
      			}
      			String strEstatusValida = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
      			if (!strEstatusValida.equals(strEstValidacion)){ 
      				bValidaEstatus = true; 
      			}
      		}else{
      			if (strEstValidacion.equals("")){
      				strEstValidacion = ActualizaAsunto.getEstatus(strIdAsunto);
      			}
      			String strEstatusValida = ActualizaAsunto.getEstatus(strIdAsunto);
      			if (!strEstatusValida.equals(strEstValidacion) || strEstValidacion.equalsIgnoreCase("4")){ 
      				bValidaEstatus = true; 
      			}
      		}
      	}
      
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+strTmp+"?cm="+strCM+"&Folio="+strFolio+"&IdAsunto="+strIdAsunto+"&a="+a1);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
      	}
      	try{
      		content = statusOCS.statusContent(contentUri, passContent, userContent); 
      	}catch(java.rmi.RemoteException ri){
      		//System.err.println("Exception="+ri);
      	}
      	if (strFolio.equals("folio por asignar")){
      		strFolio = strIdAsunto;
      	}
      
      out.write(__oracle_jsp_text[3]);
      
      	String strItemType  =  (application.getInitParameter("ItemType")==null)?"":application.getInitParameter("ItemType");
      	String server =	application.getInitParameter("servername");
      	String url = request.getRequestURI();
      
      out.write(__oracle_jsp_text[4]);
      out.print(retURI);
      out.write(__oracle_jsp_text[5]);
      out.print(retURI);
      out.write(__oracle_jsp_text[6]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[7]);
       if(a1.equals("1")){ 
      out.write(__oracle_jsp_text[8]);
      out.print(retURI);
      out.write(__oracle_jsp_text[9]);
       }else if(a1.equals("2")){ 
      out.write(__oracle_jsp_text[10]);
      out.print(retURI);
      out.write(__oracle_jsp_text[11]);
       }else if(a1.equals("4")){ 
      out.write(__oracle_jsp_text[12]);
      out.print(retURI);
      out.write(__oracle_jsp_text[13]);
       }else if(a1.equals("3")){ 
      out.write(__oracle_jsp_text[14]);
      out.print(retURI);
      out.write(__oracle_jsp_text[15]);
       }else if(a1.equals("5")){ 
      out.write(__oracle_jsp_text[16]);
      out.print(retURI);
      out.write(__oracle_jsp_text[17]);
      }else if(a1.equals("6")){
      out.write(__oracle_jsp_text[18]);
      out.print(retURI);
      out.write(__oracle_jsp_text[19]);
       }
      out.write(__oracle_jsp_text[20]);
      if(content.equals("activo")){ 
      out.write(__oracle_jsp_text[21]);
      }else { 
      out.write(__oracle_jsp_text[22]);
      } 
      out.write(__oracle_jsp_text[23]);
      out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.String.class, __ojsp_varRes, null));
      out.write(__oracle_jsp_text[24]);
       if(strActivarCM.equals("si")){ 
      out.write(__oracle_jsp_text[25]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[26]);
      out.print(strFolio);
      out.write(__oracle_jsp_text[27]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[28]);
      out.print(strMessage);
      out.write(__oracle_jsp_text[29]);
      out.print(strName );
      out.write(__oracle_jsp_text[30]);
      out.print(srtExcp );
      out.write(__oracle_jsp_text[31]);
       }else{ 
      out.write(__oracle_jsp_text[32]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[33]);
      out.print(strFolio);
      out.write(__oracle_jsp_text[34]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[35]);
      out.print(strMessage);
      out.write(__oracle_jsp_text[36]);
      out.print(strName );
      out.write(__oracle_jsp_text[37]);
      out.print(srtExcp );
      out.write(__oracle_jsp_text[38]);
       } 
      out.write(__oracle_jsp_text[39]);
      out.print(strCM);
      out.write(__oracle_jsp_text[40]);
      out.print(strFolio);
      out.write(__oracle_jsp_text[41]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[42]);
      out.print(strUrl);
      out.write(__oracle_jsp_text[43]);
      out.print( strItemType);
      out.write(__oracle_jsp_text[44]);
      out.print(strActivarCM);
      out.write(__oracle_jsp_text[45]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[46]);
      out.print(a1);
      out.write(__oracle_jsp_text[47]);
      out.print(server);
      out.write(__oracle_jsp_text[48]);
      out.print(strIdUsuario);
      out.write(__oracle_jsp_text[49]);
      out.print(strTmp3);
      out.write(__oracle_jsp_text[50]);
       if (srtArcRep!=null){ 
      out.write(__oracle_jsp_text[51]);
       } 
      out.write(__oracle_jsp_text[52]);
       if (srtArcBig!=null){ 
      out.write(__oracle_jsp_text[53]);
       } 
      out.write(__oracle_jsp_text[54]);
      out.print( bValidaEstatus );
      out.write(__oracle_jsp_text[55]);
       if (strIdInstruccion!=null && !strIdInstruccion.equals("")){ 
      out.write(__oracle_jsp_text[56]);
       }else{ 
      out.write(__oracle_jsp_text[57]);
       } 
      out.write(__oracle_jsp_text[58]);

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
  private static final char __oracle_jsp_text[][]=new char[59][];
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<TITLE>Importar Archivos</TITLE>\n\n<script type=\"text/javascript\">\n<!--\nfunction valorRuta(){\n\tdoc = document.insertarCM;\n\tdoc.solicitud_view.value = doc.solicitud_archivo.value;\n\tdoc.rutaArchivo.value = doc.solicitud_archivo.value;\n\n\tdoc.solicitud_view.focus();\n}\n//-->\n</script>\n\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0;timer_load();\"\n\t\tonclick=\"timer_reload()\" onkeypress=\"timer_reload()\"\n\t\tonmousemove=\"valorRuta();\">\n\n<FORM \taction=\"../UploadArchivo\" name=\"insertarCM\" \n\t\tmethod=\"post\" enctype=\"multipart/form-data\">\n<INPUT name=\"retURI\" value=\"".toCharArray();
    __oracle_jsp_text[5] = 
    "\" type=\"hidden\">\n<INPUT name=\"rutaArchivo\" value=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\" type=\"hidden\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\" name=\"estValidacion\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\t\t<TD width=\"50\"><a href=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\"> <IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/NavLeft.gif\" width=\"32\" height=\"32\" alt=\"Regresar\"> </a></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t<TD width=\"50\"><a href=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\"> <IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/NavLeft.gif\" width=\"32\" height=\"32\" alt=\"Regresar\"> </a></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t<TD width=\"50\"><a href=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\"> <IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/NavLeft.gif\" width=\"32\" height=\"32\" alt=\"Regresar\"> </a></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t<TD width=\"50\"><a href=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\"> <IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/NavLeft.gif\" width=\"32\" height=\"32\" alt=\"Regresar\"> </a></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t<TD width=\"50\"><a href=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\"> <IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/NavLeft.gif\" width=\"32\" height=\"32\" alt=\"Regresar\"> </a></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t<TD width=\"50\"><a href=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\"> <IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/NavLeft.gif\" width=\"32\" height=\"32\" alt=\"Regresar\"> </a></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t<TD width=\"50\"><a onclick=\"guardarImportarCM()\"> <img\n\t\t\t\tsrc=\"../Imagenes/Save.gif\" width=\"32\" border=\"0\" alt=\"Guardar archivo\"> </a></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"214\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<br>\n<br>\n".toCharArray();
    __oracle_jsp_text[21] = 
    "\n<TABLE>\n<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT size=\"2\" color=\"#004080\" face=\"Arial\">Anexar un archivo(Opcional):</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<INPUT class=\"blue500\" type=\"text\" name=\"solicitud_view\" onfocus=\"blur();\">\n\t\t\t<INPUT class=\"blue50\" type=\"file\" name=\"solicitud_archivo\" onkeypress=\"valorRuta();\">\n\t\t</TD>\n</TR>\n</TABLE>\t\n".toCharArray();
    __oracle_jsp_text[22] = 
    "\n<TABLE>\n<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT size=\"2\" color=\"#004080\" face=\"Arial\">Anexar un archivo(Opcional):</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<INPUT class=\"blue500\" type=\"text\" name=\"solicitud_view\" onfocus=\"blur();\">\n\t\t\t<INPUT class=\"blue50\" type=\"file\" name=\"solicitud_archivo\" onkeypress=\"valorRuta();\">\n\t\t</TD>\n</TR>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\n<BR>\n<TABLE>\n<TR valign=\"top\">\n\t\t<TD width=\"150\"><p>\n            <label><font size=\"2\" color=\"#004080\" face=\"Arial\">\n            <input type=\"radio\" name=\"optionDoc\" value=\"DP\" checked>\n            Documento Principal</font></label>\n          </p></TD>\n\t\t<TD width=\"160\"><p><label><font size=\"2\" color=\"#004080\" face=\"Arial\">\n            <input type=\"radio\" name=\"optionDoc\" value=\"DS\">\n            Documento Soporte</font></label></p></TD>\n</TR>\n</TABLE>\n</DIV>\n<br><br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><B><FONT face=\"Arial\" color=\"#004080\"\n\t\t\t\tsize=\"2\">Documentos Anexados</FONT></B></TD>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"203\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</tr>\n\t\t<!-- <TR valign=\"top\">\n\t\t\t<TD width=\"19%\">&nbsp;</TD>\n\t\t\t<TD width=\"31%\">&nbsp;</TD>\n\t\t\t<TD width=\"19%\">&nbsp;</TD>\n\t\t\t<TD width=\"31%\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<c:choose>\n\t\t\t\t<c:when test='".toCharArray();
    __oracle_jsp_text[24] = 
    "'>\n\t\t\t\t\t<TD width=\"30%\">&nbsp;</TD>\n\t\t\t\t\t<TD width=\"20%\" align=\"center\">\n\t\t\t\t\t\t<INPUT type=\"button\" class=\"blue200\" value=\"Agregar Archivo\" onclick=\"agregarContent();\">&nbsp;\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD width=\"20%\" align=\"center\">\n\t\t\t\t\t\t<INPUT type=\"button\" class=\"blue200\" value=\"Listado Archivos\" onclick=\"listadoContent();\">&nbsp;\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD width=\"50%\">&nbsp;</TD>\n\t\t\t\t</c:when>\n\t\t\t\t<c:otherwise>\n\t\t\t\t\t<TD width=\"30%\">&nbsp;</TD>\n\t\t\t\t\t<TD width=\"20%\">&nbsp;</TD>\n\t\t\t\t\t<TD width=\"50%\">&nbsp;</TD>\n\t\t\t\t</c:otherwise>\n\t\t\t</c:choose>\n\t\t</TR> -->\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"4\">\n\t\t\t\t<div>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t\t\t<IFRAME ID=\"frame1\" SRC=\"ImportarCMO.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[26] = 
    "&bo=false&fol=".toCharArray();
    __oracle_jsp_text[27] = 
    "&IdInst=".toCharArray();
    __oracle_jsp_text[28] = 
    "&mess=".toCharArray();
    __oracle_jsp_text[29] = 
    "&name=".toCharArray();
    __oracle_jsp_text[30] = 
    "&excp=".toCharArray();
    __oracle_jsp_text[31] = 
    "\" WIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME> \n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t\t<IFRAME ID=\"frame1\" SRC=\"ImportarAR.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[33] = 
    "&bo=false&fol=".toCharArray();
    __oracle_jsp_text[34] = 
    "&IdInst=".toCharArray();
    __oracle_jsp_text[35] = 
    "&mess=".toCharArray();
    __oracle_jsp_text[36] = 
    "&name=".toCharArray();
    __oracle_jsp_text[37] = 
    "&excp=".toCharArray();
    __oracle_jsp_text[38] = 
    "\" WIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t\t</div>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<input type=\"hidden\" name =\"cm\" value=\"".toCharArray();
    __oracle_jsp_text[40] = 
    "\">\n<input type=\"hidden\" name =\"Folio\" value=\"".toCharArray();
    __oracle_jsp_text[41] = 
    "\">\n<input type=\"hidden\" name =\"IdAsunto\" value=\"".toCharArray();
    __oracle_jsp_text[42] = 
    "\">\n<input type=\"hidden\" name =\"url\" value=\"".toCharArray();
    __oracle_jsp_text[43] = 
    "\">\n<input type=\"hidden\" name =\"ItemType\" value=\"".toCharArray();
    __oracle_jsp_text[44] = 
    "\">\n<input type=\"hidden\" name =\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"ActivarCM\" value=\"".toCharArray();
    __oracle_jsp_text[45] = 
    "\">\n<INPUT type=\"hidden\" name=\"id_ins\" value=\"".toCharArray();
    __oracle_jsp_text[46] = 
    "\">\n<INPUT type=\"hidden\" name=\"a1\" value=\"".toCharArray();
    __oracle_jsp_text[47] = 
    "\">\n<INPUT type=\"hidden\" name=\"server\" value=\"".toCharArray();
    __oracle_jsp_text[48] = 
    "\">\n<INPUT type=\"hidden\" name=\"idUsuario\" value=\"".toCharArray();
    __oracle_jsp_text[49] = 
    "\">\n<INPUT type=\"hidden\" name=\"uri\" value=\"".toCharArray();
    __oracle_jsp_text[50] = 
    "\">\n\n<script type=\"text/javascript\">\n<!--\n\n\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\talert(\"No es permitido guardar archivos con el mismo nombre dentro de un asunto, cambie el nombre del archivo o verifique por favor.\");\n\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\n\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\talert(\"El archivo no puede ser anexado por ser de un tamAño muy grande, por favor verifique.\");\n\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\nif (".toCharArray();
    __oracle_jsp_text[55] = 
    "){\n\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\talert(\"Esta instrucción ha sido modificada por otro usuario y Cambió su Estatus,\\npor lo que la acción solicitada será cancelada\");\n\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\talert(\"Este Asunto ha sido modificado por otro usuario y Cambió su Estatus,\\npor lo que la acción solicitada será cancelada\");\n\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\tlocation.assign(\"portalPrincipal.jsp\");\n}\n//-->\n</script>\n\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
