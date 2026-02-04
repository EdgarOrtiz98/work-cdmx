package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.servlet.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import java.io.*;


public class _ImportarCMO extends com.orionserver.http.OrionHttpJspPage {


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
    _ImportarCMO page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      
      	String contentUri = application.getInitParameter("content");
      	String userContent = application.getInitParameter("user");
      	String passContent = application.getInitParameter("passwd");
      	String pathContent = application.getInitParameter("path");
      	String strIdAsunto = request.getParameter("IdAsunto");
      	String strSeguridad= request.getParameter("bo");
      	String strEstatus = request.getParameter("est");
      	String strMessage = (request.getParameter("mess")==null)?"":request.getParameter("mess");
      	String strName = (request.getParameter("name")==null)?"":request.getParameter("name");
      	String srtExcp = (request.getParameter("excp")==null)?"":request.getParameter("excp");
      	String strIdDoc = (request.getParameter("strIdDoc")==null)?"":request.getParameter("strIdDoc");
      	String strFolio = (request.getParameter("fol")==null)?"":request.getParameter("fol");
      	String strFolioCarp = (request.getParameter("strFolioCarp")==null)?"":request.getParameter("strFolioCarp");
      	String strInstruccion = (request.getParameter("IdInst")== null)?request.getParameter("IdInstruccion"):request.getParameter("IdInst");
      
      	String bInst = (request.getParameter("inst")== null)?"":request.getParameter("inst");
      	String strIds_Borrar[] = null;
      	String strAccion = request.getParameter("accion");
      	strIds_Borrar = request.getParameterValues("archivo");
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	String strIdUsuario =  BUsuario.getIdUsuario();
      
      	////System.out.println("strIdAsunto" + strIdAsunto);
      	////System.out.println("strInstruccion ........." +strInstruccion);
      	////System.out.println("strIdUsuario" +strIdUsuario);
      	////System.out.println("strMessage1" +strMessage);
      	if(strInstruccion == null || strInstruccion == "" ){
      		strInstruccion = "";
      	}
      
      	int contar = 0;
      	boolean bExisteArchivos = false;
      	boolean bExisteArchivoDocS = false;
      	boolean bOperacion = false;
      	boolean bInsTurno = false;
      	String content;
      	String nameObject;
      	String strMessageAlert = "";
      	////System.out.println("strIdAsunto2 " + strIdAsunto);
      	////System.out.println("strInstruccion2 " +strInstruccion);	
      	////System.out.println("Valor Pasa + " + bInst);
      	bInst = (bInst == "null")?"":bInst;
      	if (bInst== "null"){ bInst = "";}
      	//System.out.println(strInstruccion + " " + strInstruccion.length() + " " + strIdAsunto);
      
      	if(strIdAsunto != null && strIdAsunto.length()> 0 && strInstruccion.length()== 0)
      	{	//bExisteArchivos = ActualizaArchivo.getExisteArchivo(strIdAsunto);
      //                //System.out.println("bExisteArchivos = ActualizaArchivo.getExisteArchivoReferencia(strIdAsunto);");
      		bExisteArchivos = ActualizaArchivo.getExisteArchivoReferencia(strIdAsunto);
      		bExisteArchivoDocS = ActualizaArchivo.getExisteArchivoReferenciaDocS(strIdAsunto);
      		if (bInst != null && bInst.length()  > 0 ){
                              strIdUsuario = ActualizaArchivo.getIdDocPrincipal(strIdAsunto); 
      		}
      	}
      	else if(strInstruccion!=null && strInstruccion.length() > 0 && strIdAsunto != null){
      //                //System.out.println("bExisteArchivos = ActualizaArchivo.getExisteArchivoReferenciaInstruccion(strInstruccion);");
      		bExisteArchivos = ActualizaArchivo.getExisteArchivoReferenciaInstruccion(strInstruccion);
                      bExisteArchivoDocS = ActualizaArchivo.getExisteArchivoReferenciaInsDocS(strInstruccion);
      		if (bInst.length() > 0 ){
      			strIdUsuario = ActualizaArchivo.getIdDocPrincipal(strIdAsunto); 
      		}
                      
      
      	}else{
      		bExisteArchivos = false;
                      }
      	//bExisteArchivos = ActualizaArchivo.getExisteArchivo(strIdAsunto);
      	if (strAccion != null && strAccion.trim().length() > 0 && strAccion.equals("borrar")) {
      
      		String[] strNameArchive = ActualizaArchivo.getNombreArchivo(strIdAsunto, strIdDoc); 
      
      		FolderAsunto.deleteArchives(strFolio, strNameArchive, contentUri, userContent, passContent, pathContent);   
      		
      		bOperacion = ActualizaArchivo.deleteArchivoReferencia(strIds_Borrar);
      		if(strIdAsunto != null && strIdAsunto.length()> 0 && strInstruccion.length()== 0){	
      
      			bExisteArchivos = ActualizaArchivo.getExisteArchivoReferencia(strIdAsunto);
      			bExisteArchivoDocS = ActualizaArchivo.getExisteArchivoReferenciaDocS(strIdAsunto);
      			if (bInst != null && bInst.length()  > 0 ){
      					strIdUsuario = ActualizaArchivo.getIdDocPrincipal(strIdAsunto); 
      			}
      		}else		
      	 		if(strInstruccion!=null && strInstruccion.length() > 0 && strIdAsunto != null){	
      				bExisteArchivos = ActualizaArchivo.getExisteArchivoReferenciaInstruccion(strInstruccion);
      				bExisteArchivoDocS = ActualizaArchivo.getExisteArchivoReferenciaInsDocS(strInstruccion);
      				if (bInst.length() > 0 ){
      					strIdUsuario = ActualizaArchivo.getIdDocPrincipal(strIdAsunto); 
      				}
      			}else
      				bExisteArchivos = false;
      	}
      
      	content = Dos.statusContent(contentUri, userContent, passContent); 
      
      	if(srtExcp.startsWith("java.io.FileNotFoundException",0)){
      
      		strMessageAlert =  "El archivo que Intentó anexar no se encuentra en la ruta especificada \n" +
      					   "o puede que este tratando de subir un archivo sin contenido" ;
      	}
      
      	if(srtExcp.equals("ORACLE.FDK.QuotaReached")&& srtExcp.length() > 0 ){
      
      	strMessageAlert = "No se cuenta con espacio suficiente para anexar el archivo." +
      					  " Contacte a su administrador";
      	}
      
      	if(srtExcp.equals("ORACLE.FDK.ServerError")&& srtExcp.length() > 0 ){
      
      	strMessageAlert = "Ya se ha anexado un archivo con el nombre " + strName ;
      	}
      	
      	if(srtExcp.equals("ORACLE.FDK.VersioningDisabled")&& srtExcp.length() > 0 ){
      
      	strMessageAlert = "Ya se ha anexado un archivo con el nombre " + strName ;
      	}
      	
      	if(srtExcp.equals("ORACLE.FDK.SessionError:ORACLE.FDK.SessionNotConnected")&& srtExcp.length() > 0 ){
      
      	strMessageAlert = "Perdida de conexión OCS" ;
      	}
      
      
      out.write(__oracle_jsp_text[3]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[4]);
      out.print(strInstruccion);
      out.write(__oracle_jsp_text[5]);
      out.print(strFolio);
      out.write(__oracle_jsp_text[6]);
      out.print(strSeguridad);
      out.write(__oracle_jsp_text[7]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[8]);
      out.print(strIdDoc);
      out.write(__oracle_jsp_text[9]);
      try{
      if (content.equals("activo")){
      out.write(__oracle_jsp_text[10]);
      if(strMessage.equals("s") && strName.length()> 0){
      out.write(__oracle_jsp_text[11]);
      out.print(strMessageAlert );
      out.write(__oracle_jsp_text[12]);
      } 
      out.write(__oracle_jsp_text[13]);
       if(strSeguridad.equals("true")){ 
      out.write(__oracle_jsp_text[14]);
      if(strEstatus.equals("0") || strEstatus.equals("1")){
      out.write(__oracle_jsp_text[15]);
      }
      out.write(__oracle_jsp_text[16]);
      }
      out.write(__oracle_jsp_text[17]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaArchivo.getArchivosReferenciaContent(strIdAsunto, strIdUsuario, strInstruccion));
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
            out.write(__oracle_jsp_text[18]);
            contar++;
            out.write(__oracle_jsp_text[19]);
            if(contar==0){
            out.write(__oracle_jsp_text[20]);
            
            		}else 
                            if((contar%3)==1 || (contar%3)==2){
            		
            out.write(__oracle_jsp_text[21]);
            
            		}else 
                            if((contar%3)==0){
            		
            out.write(__oracle_jsp_text[22]);
            
            		}
            		if(strSeguridad.equals("true"))
            		{
            		
            out.write(__oracle_jsp_text[23]);
            if(strEstatus.equals("0") || strEstatus.equals("1")){
            out.write(__oracle_jsp_text[24]);
            out.print(campo1);
            out.write(__oracle_jsp_text[25]);
            }
            out.write(__oracle_jsp_text[26]);
            
            		}
                            String image= TypeDoc.tipoDoc(campo2); 
            		
            out.write(__oracle_jsp_text[27]);
            out.print(campo1);
            out.write(__oracle_jsp_text[28]);
            out.print(strFolio );
            out.write(__oracle_jsp_text[29]);
            out.print(campo2 );
            out.write(__oracle_jsp_text[30]);
            out.print(image);
            out.write(__oracle_jsp_text[31]);
            out.print(campo2);
            out.write(__oracle_jsp_text[32]);
            if((contar+1)>=ActualizaArchivo.getArchivosReferenciaContent(strIdAsunto, strIdUsuario, strInstruccion).length){		
            out.write(__oracle_jsp_text[33]);
            }
            out.write(__oracle_jsp_text[34]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[35]);
       }else{ 
      out.write(__oracle_jsp_text[36]);
       } 
      out.write(__oracle_jsp_text[37]);
       if(bExisteArchivoDocS){ 
      out.write(__oracle_jsp_text[38]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_2=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setDatos(ActualizaArchivo.getArchivosReferenciaContentDocSec(strIdAsunto,strIdUsuario, strInstruccion));
        __jsp_taghandler_2.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_2,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[39]);
            contar++;
            out.write(__oracle_jsp_text[40]);
            if(contar==0){
            out.write(__oracle_jsp_text[41]);
            
            		}else if((contar%3)==1 || (contar%3)==2){
            		
            out.write(__oracle_jsp_text[42]);
            
            		}else if((contar%3)==0){
            		
            out.write(__oracle_jsp_text[43]);
            
            		}
            		if(strSeguridad.equals("true"))
            		{
            		
            out.write(__oracle_jsp_text[44]);
            if(strEstatus.equals("0") || strEstatus.equals("1")){
            out.write(__oracle_jsp_text[45]);
            out.print(campo1);
            out.write(__oracle_jsp_text[46]);
            }
            out.write(__oracle_jsp_text[47]);
            
            		}
            			String image = TypeDoc.tipoDoc(campo2);
            		
            out.write(__oracle_jsp_text[48]);
            out.print(campo1);
            out.write(__oracle_jsp_text[49]);
            out.print(strFolio );
            out.write(__oracle_jsp_text[50]);
            out.print(campo2 );
            out.write(__oracle_jsp_text[51]);
            out.print(image);
            out.write(__oracle_jsp_text[52]);
            out.print(campo2);
            out.write(__oracle_jsp_text[53]);
            if((contar+1)>=ActualizaArchivo.getArchivosReferenciaContentDocSec(strIdAsunto, strIdUsuario, strInstruccion).length){
            out.write(__oracle_jsp_text[54]);
            }
            out.write(__oracle_jsp_text[55]);
          } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[56]);
       }else{ 
      out.write(__oracle_jsp_text[57]);
       } 
      out.write(__oracle_jsp_text[58]);
      
      }catch(Exception e){
      out.write(__oracle_jsp_text[59]);
      out.print(content );
      out.write(__oracle_jsp_text[60]);
      //System.err.println("El servidor content no funciona correctamente con la aplicación, favor de informarle al web-master");
      }
      out.write(__oracle_jsp_text[61]);

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
  private static final char __oracle_jsp_text[][]=new char[62][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Importar Archivos</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n\tfunction Eliminar(){\n\t\tdoc = document.archivoForm1;\n\t\tvalida = 0;\n\t\tmsg=\"\";\n\t\tvar cadena=\"\";\t\n\t\tvar folio =\"\";\n\t\tvar idFolio = \"\";\n\t\tfor (var i = 0; i < doc.elements.length; i++) \n\t\t{  \n\t\t\tif (doc.elements[i].type == 'checkbox') \n\t\t\t{      \n\t\t\t\tif (doc.elements[i].name == 'archivo') \n\t\t\t\t{       \n\t\t\t\t\tif (doc.elements[i].checked == true)\n\t\t\t\t\t{\n\t\t\t\t\t\tvalor = doc.elements[i].value;\n\t\t\t\t\t\tif(valor != \"\") \n\t\t\t\t\t\t\tcadena = cadena +valor + \"|\";        \n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\t\n\t\tfor ( var j = 0; j < doc.elements.length; j++){\n\t\t\t\tif (doc.elements[j].name == \"fol\"){\n\t\t\t\t\tfolio =\tdoc.elements[j].value;\n\t\t\t\t}\n\t\t}\n\n\t\tif (cadena == \"\") \n\t\t\talert(\"Debe seleccionar un documento\");\n\t\telse \n\t\t{\n\t\t\tif (confirm(\"está usted seguro de que desea borrar el/los documento(s)?\")) \n\t\t\t{    \n\t\t\t\t doc.accion.value=\"borrar\";\n\t\t\t\t document.forms[0].fol.value = folio;\n\t\t\t\t document.forms[0].strIdDoc.value = cadena;\n\t\t\t\t \n\t\t\t\t\n\t\t\t\t doc.submit();\n\t\t\t\t document.forms[0].fol.value = folio;\n\t\t\t\t document.forms[0].strIdDoc.value = cadena;\n\t\t\t\t \n\t\t\t} \n\t\t\telse \n\t\t\t\talert(\"Su petición de borrado ya fue cancelada\");\n\t\t}\n\n\t\t//doc.accion.value=\"borrar\";\n\t\t//doc.submit();\n\t}\n</SCRIPT>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n<FORM name=\"archivoForm1\" action=\"ImportarCMO.jsp\" method=\"post\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"borrar\">\n<INPUT type=\"hidden\" name=\"IdAsunto\" value=\"".toCharArray();
    __oracle_jsp_text[4] = 
    "\">\n<INPUT type=\"hidden\" name=\"IdInstruccion\" value=\"".toCharArray();
    __oracle_jsp_text[5] = 
    "\">\n<INPUT type=\"hidden\" name=\"fol\" value=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\">\n<INPUT type=\"hidden\" name=\"bo\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\">\n<INPUT type=\"hidden\" name=\"est\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\">\n<INPUT type=\"hidden\" name=\"strIdDoc\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\">\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n<table width=\"75%\" border=\"0\">\n  <tr>\n    <td width=\"27\">&nbsp;</td>\n    <td width=\"670\"><div align=\"center\"><B><font face=\"Arial\" color=\"#FF0000\" size=\"2\">".toCharArray();
    __oracle_jsp_text[12] = 
    "</font><B></div></td>\n    <td width=\"24\">&nbsp;</td>\n  </tr>\n</table>\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n<table>\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n<tr>\n\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t<TD>\n\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Eliminar\" onclick=\"Eliminar()\">\n\t</TD>\n\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n</tr>\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\n<tr>\n\t<tr>\n\t\t<td><B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Documentos Principales</FONT></B></td>\n\t</tr>\n\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t<TR>\n\t\t<TD>\n\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t<TD>\n\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t</TR>\n\t<TR>\n\t\t<TD>\n\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t<input type=\"checkbox\" name=\"archivo\" value=\"".toCharArray();
    __oracle_jsp_text[25] = 
    "\">\n\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\t\n\t\t<a href=\"../DownLoadDicument?ida=".toCharArray();
    __oracle_jsp_text[28] = 
    "&fol=".toCharArray();
    __oracle_jsp_text[29] = 
    "&name=".toCharArray();
    __oracle_jsp_text[30] = 
    "\">\n\t\t<FONT size = \"1\" face = \"Arial\">\n\t\t<img src=\"".toCharArray();
    __oracle_jsp_text[31] = 
    "\" border=\"0\" alt=\"\"><br>\n\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t</FONT>\n\t\t</a>\n\t\t</TD>\n\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n".toCharArray();
    __oracle_jsp_text[35] = 
    "\n".toCharArray();
    __oracle_jsp_text[36] = 
    "\n<TD align=\"center\">\n\t<FONT face=\"Arial\" size=\"1\"><b>No se encontraron archivos que mostrar...</b></FONT>\n</TD>\n".toCharArray();
    __oracle_jsp_text[37] = 
    "\n</tr> \n<tr>\n\t<tr>\n\t\t<td><B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Documentos Soporte</FONT></B></td>\n\t</tr>\n".toCharArray();
    __oracle_jsp_text[38] = 
    "\n".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t<TR>\n\t\t<TD>\n\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t<TD>\n\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t</TR>\n\t<TR>\n\t\t<TD>\n\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t<input type=\"checkbox\" name=\"archivo\" value=\"".toCharArray();
    __oracle_jsp_text[46] = 
    "\">\n\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\t\n\t\t<a href=\"../DownLoadDicument?ida=".toCharArray();
    __oracle_jsp_text[49] = 
    "&fol=".toCharArray();
    __oracle_jsp_text[50] = 
    "&name=".toCharArray();
    __oracle_jsp_text[51] = 
    "\">\n\t\t<FONT size = \"1\" face = \"Arial\">\n\t\t<img src=\"".toCharArray();
    __oracle_jsp_text[52] = 
    "\" border=\"0\" alt=\"\"><br>\n\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\t</FONT>\n\t\t</a>\n\t\t</TD>\n\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[55] = 
    "\n".toCharArray();
    __oracle_jsp_text[56] = 
    "\n".toCharArray();
    __oracle_jsp_text[57] = 
    "\n<TD align=\"center\">\n\t<FONT face=\"Arial\" size=\"1\"><b>No se encontraron archivos que mostrar...</b></FONT>\n</TD>\n".toCharArray();
    __oracle_jsp_text[58] = 
    "\n</tr>\n</table>\n".toCharArray();
    __oracle_jsp_text[59] = 
    "\n<table border=\"0\">\n  <tr>\n    <td width=\"616\"><B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">\n\t\tEl servicio del Contenedor de Archivos no esta disponible por el momento</FONT></B><br>\n\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">\n\t\t(Favor de contactar a su administrador)\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t</FONT>\n\t</td>\n  </tr>\n</table>\n".toCharArray();
    __oracle_jsp_text[61] = 
    "\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
