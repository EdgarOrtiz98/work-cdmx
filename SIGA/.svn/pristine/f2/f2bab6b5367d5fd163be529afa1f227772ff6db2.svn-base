package _ciudadano;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;


public class _PortalCiudadano extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


	public static boolean par(int num)
    {
        boolean p = false;
        if (num % 2 == 0) 
        {
            p = true;
        }    
        return p;
    }

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
    _PortalCiudadano page = this;
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
      	boolean bExiste = false;
      	bExiste = ActualizaCiudadano.getExisteSolicitud(BCiudadano.getIdUsuario());
      	int t = 0;
      
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
       if(bExiste){  
      out.write(__oracle_jsp_text[6]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaCiudadano.getDatosCiudadanoPortal(BCiudadano.getIdUsuario()));
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
            out.write(__oracle_jsp_text[7]);
             t++; 
            out.write(__oracle_jsp_text[8]);
            
            		boolean existe = ActualizaCiudadano.getExistenNotificaciones(campo7);
            	
            out.write(__oracle_jsp_text[9]);
            if(par(t)==true){
            }else{
            out.write(__oracle_jsp_text[10]);
            }
            out.write(__oracle_jsp_text[11]);
            out.print(campo1);
            out.write(__oracle_jsp_text[12]);
            out.print(campo3);
            out.write(__oracle_jsp_text[13]);
            out.print(campo4);
            out.write(__oracle_jsp_text[14]);
             
            				if(existe){
            					String strNotificaciones[][] = null;
            					strNotificaciones = ActualizaCiudadano.getDatosNotificacion(campo7);
            					String strTipoRespuesta = "";
            
            					if(strNotificaciones!=null && strNotificaciones.length>0 && strNotificaciones[0].length>=5){
            						strTipoRespuesta=strNotificaciones[0][4];
            					}
            
            					if(strTipoRespuesta.length()!=0){
            			
            out.write(__oracle_jsp_text[15]);
            out.print(campo7);
            out.write(__oracle_jsp_text[16]);
            out.print( ActualizaTipoRespuesta.getNombreTipoRespuesta(strTipoRespuesta)[0][0] );
            out.write(__oracle_jsp_text[17]);
             
            					}else{ 
            						
            out.write(__oracle_jsp_text[18]);
            
            					}
            
            			   }else{ 
            out.write(__oracle_jsp_text[19]);
             } 
            out.write(__oracle_jsp_text[20]);
             
            				if(existe){
            					String strNotificaciones[][] = null;
            					strNotificaciones = ActualizaCiudadano.getDatosNotificacion(campo7);
            					String strFechaRespuesta = "--";
            					if(strNotificaciones!=null && strNotificaciones.length>0 && strNotificaciones[0].length>=4){
            						strFechaRespuesta = strNotificaciones[0][3];
            					}
            					
            			
            out.write(__oracle_jsp_text[21]);
            out.print(strFechaRespuesta);
            out.write(__oracle_jsp_text[22]);
             }else{ 
            out.write(__oracle_jsp_text[23]);
             } 
            out.write(__oracle_jsp_text[24]);
              
            				if(existe){
            					String strNotificaciones[][] = null;
            					//String strAreasAtencion[][] = null;
            					//strAreasAtencion = ActualizaBuscar.getAreasAtencion(campo7);
            					strNotificaciones = ActualizaCiudadano.getDatosNotificacion(campo7);
            					
            					if(strNotificaciones==null){
            						strNotificaciones = new String[0][0];
            					}
            
            					if(strNotificaciones.length==0){
            						
            out.write(__oracle_jsp_text[25]);
            
            					}
            					for(int i = 0;i<strNotificaciones.length;i++){
            			
            out.write(__oracle_jsp_text[26]);
            out.print(ActualizaEstatus.getNombreEstatus(strNotificaciones[i][6])[0][0]);
            out.write(__oracle_jsp_text[27]);
             }}else{ 
            out.write(__oracle_jsp_text[28]);
             } 
            out.write(__oracle_jsp_text[29]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[30]);
       }else{ 
      out.write(__oracle_jsp_text[31]);
       } 
      out.write(__oracle_jsp_text[32]);

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
  private static final char __oracle_jsp_text[][]=new char[33][];
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
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<STYLE type=\"text/css\">\n</STYLE>\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<script language=\"JavaScript\" type=\"text/javascript\">\n\nfunction goSolicitud(){\n\tlocation.assign('ConsultaCiudadano.jsp');\n}\nfunction goEditar(){\n\tlocation.assign('EditarDatos.jsp');\n}\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY BGCOLOR=\"FFFFFF\" background=\"../Imagenes/fondo_claro.jpg\">\n<FORM action=\"PortalCiudadano.jsp\" name=\"formPortalCiu\" method=\"post\">\n<INPUT type=\"hidden\" value=\"guardar\" name=\"accion\">\n<TABLE cellspacing=\"2\" cellpadding=\"2\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD class=\"dominoSelTopTab\"><A onclick=\"goSolicitud()\";>Ingresar una Solicitud nueva</A></TD>\n\t\t\t<TD class=\"dominoSelTopTab\"><A onclick=\"goEditar()\";>Editar mis datos</A></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<br>\n<TABLE width=\"100%\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD align=\"left\" width=\"65%\"><FONT size=\"2\" color=\"red\" face=\"Arial\">\n\t\t\t\tDar click al <b><u>Folio</u></b> para consultar Solicitud. Si tu Solicitud ha sido contestada, da click en <b><u>Tipo de Respuesta</u></b></FONT>\n\t\t\t</TD>\n\t\t\t<td align=\"right\" width=\"35%\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Historicos de Solicitudes</FONT></B></td>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE width=\"100%\" border=\"1\">\n\t<TR bgcolor=\"00204F\">\n\t\t<TD width=\"20%\" align=\"center\"><FONT size=\"2\" color=\"FFFFFF\"\n\t\t\tface=\"Arial\">Folio Solicitud</FONT></TD>\n\t\t<TD width=\"20%\" align=\"center\"><FONT size=\"2\" color=\"FFFFFF\"\n\t\t\tface=\"Arial\">Fecha de Solicitud</FONT></TD>\n\t\t<TD width=\"20%\" align=\"center\"><FONT size=\"2\" color=\"FFFFFF\"\n\t\t\tface=\"Arial\">Tipo de Respuesta</FONT></TD>\n\t\t<TD width=\"20%\" align=\"center\"><FONT size=\"2\" color=\"FFFFFF\"\n\t\t\tface=\"Arial\">Fecha de Respuesta</FONT></TD>\n\t\t<TD width=\"20%\" align=\"center\"><FONT size=\"2\" color=\"FFFFFF\"\n\t\t\tface=\"Arial\">Estatus</FONT></TD>\n\t</TR>\n</TABLE>\n<DIV class=\"documentBody\" id=\"Body\">\n<TABLE width=\"100%\">\n\t".toCharArray();
    __oracle_jsp_text[6] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t<TR valign=\"top\" ".toCharArray();
    __oracle_jsp_text[10] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[11] = 
    ">\n\t\t<TD width=\"20%\" align=\"left\">\n\t\t\t<FONT size=\"2\" color=\"#00204f\" face=\"Arial\">\n\t\t\t\t<a href=\"seguimiento.jsp?id_solicitud=".toCharArray();
    __oracle_jsp_text[12] = 
    "\">".toCharArray();
    __oracle_jsp_text[13] = 
    "</a>\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"20%\" align=\"center\">\n\t\t\t<FONT size=\"2\" color=\"#00204f\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[14] = 
    "</FONT>\n\t\t</TD>\n\t\t<TD width=\"20%\" align=\"center\">\n\t\t\t<FONT size=\"2\" color=\"#00204f\" face=\"Arial\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    " \n\t\t\t<a href=\"DetalleRespuesta.jsp?id_solicitud=".toCharArray();
    __oracle_jsp_text[16] = 
    "\">".toCharArray();
    __oracle_jsp_text[17] = 
    "</a>\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t\t\t\t\t--\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\tSin Respuesta\n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n\t\t\n\t\t<TD width=\"20%\" align=\"center\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t<FONT size=\"2\" color=\"#00204f\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[22] = 
    "</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t<FONT size=\"2\" color=\"#00204f\" face=\"Arial\">--</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t</TD>\n\t\t<TD width=\"20%\" align=\"center\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t\t\t\t\t<FONT size=\"2\" color=\"#00204f\" face=\"Arial\">\n\t\t\t\t\t\t\t--\n\t\t\t\t\t\t\t</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t<FONT size=\"2\" color=\"#00204f\" face=\"Arial\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "<br>\n\t\t\t</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t<FONT size=\"2\" color=\"#00204f\" face=\"Arial\">--</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t<tr>\n\t\t<TD width=\"100%\" align=\"center\">\n\t\t\t<b><FONT size=\"2\" color=\"#00204f\" face=\"Arial\">\n\t\t\t** No tiene Solicitudes Registradas **\n\t\t\t</FONT></b>\n\t\t</TD>\n\t</tr>\n\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n</TABLE>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
