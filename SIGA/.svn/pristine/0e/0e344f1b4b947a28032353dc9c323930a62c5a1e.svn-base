package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _PortalTipoRespuesta extends com.orionserver.http.OrionHttpJspPage {


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
    _PortalTipoRespuesta page = this;
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
      
      	boolean bMostrar	=	false;
      	boolean bExiste		=	false;
      	//String IdsArea[][]	=	ActualizaAsunto.getIdsAreaPertenece();
      	int t = 0;
      	int j = 0;
      	bExiste		=	ActualizaTipoRespuesta.existenTipoRespuesta();
      	String strAccion = request.getParameter("accion");
      	String strIdUsuario = (request.getParameter("idUs")!=null)?request.getParameter("idUs"):"";
      
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
       if(bExiste){ 
      out.write(__oracle_jsp_text[7]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaTipoRespuesta.getTiposRespuestaPortal());
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
            out.write(__oracle_jsp_text[8]);
            
            		String area = ActualizaUsuario.getIdUsrArea(BUsuario.getIdUsuario());
            		if(BUsuario.getAdmon() || BUsuario.getIdArea().equals(area)){
            		bMostrar = strIdUsuario.equals(campo1);
            	
            out.write(__oracle_jsp_text[9]);
            out.print(campo1);
            out.write(__oracle_jsp_text[10]);
            out.print((bMostrar)?"collapse.gif":"expand.gif");
            out.write(__oracle_jsp_text[11]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[12]);
             j++; 
            out.write(__oracle_jsp_text[13]);
            if(ActualizaCiudadano.getExisteRespuestas(campo1)){ 
            out.write(__oracle_jsp_text[14]);
            {
              com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_2=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setDatos(ActualizaCiudadano.getAsuntosPorTipoRespuesta(campo1));
              __jsp_taghandler_2.setCampo("usuario");
              java.lang.String usuario1 = null;
              java.lang.String usuario2 = null;
              java.lang.String usuario3 = null;
              java.lang.String usuario4 = null;
              java.lang.String usuario5 = null;
              java.lang.String usuario6 = null;
              java.lang.String usuario7 = null;
              java.lang.String usuario8 = null;
              java.lang.String usuario9 = null;
              java.lang.String usuario10 = null;
              java.lang.String usuario11 = null;
              java.lang.String usuario12 = null;
              java.lang.String usuario13 = null;
              java.lang.String usuario14 = null;
              java.lang.String usuario15 = null;
              java.lang.String usuario16 = null;
              java.lang.String usuario17 = null;
              java.lang.String usuario18 = null;
              java.lang.String usuario19 = null;
              java.lang.String usuario20 = null;
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_2,__jsp_tag_starteval,out);
                do {
                  usuario1 = (java.lang.String) pageContext.findAttribute("usuario1");
                  usuario2 = (java.lang.String) pageContext.findAttribute("usuario2");
                  usuario3 = (java.lang.String) pageContext.findAttribute("usuario3");
                  usuario4 = (java.lang.String) pageContext.findAttribute("usuario4");
                  usuario5 = (java.lang.String) pageContext.findAttribute("usuario5");
                  usuario6 = (java.lang.String) pageContext.findAttribute("usuario6");
                  usuario7 = (java.lang.String) pageContext.findAttribute("usuario7");
                  usuario8 = (java.lang.String) pageContext.findAttribute("usuario8");
                  usuario9 = (java.lang.String) pageContext.findAttribute("usuario9");
                  usuario10 = (java.lang.String) pageContext.findAttribute("usuario10");
                  usuario11 = (java.lang.String) pageContext.findAttribute("usuario11");
                  usuario12 = (java.lang.String) pageContext.findAttribute("usuario12");
                  usuario13 = (java.lang.String) pageContext.findAttribute("usuario13");
                  usuario14 = (java.lang.String) pageContext.findAttribute("usuario14");
                  usuario15 = (java.lang.String) pageContext.findAttribute("usuario15");
                  usuario16 = (java.lang.String) pageContext.findAttribute("usuario16");
                  usuario17 = (java.lang.String) pageContext.findAttribute("usuario17");
                  usuario18 = (java.lang.String) pageContext.findAttribute("usuario18");
                  usuario19 = (java.lang.String) pageContext.findAttribute("usuario19");
                  usuario20 = (java.lang.String) pageContext.findAttribute("usuario20");
                  out.write(__oracle_jsp_text[15]);
                   t++; 
                  out.write(__oracle_jsp_text[16]);
                  if(par(t)==true){
                  }else{
                  out.write(__oracle_jsp_text[17]);
                  }
                  out.write(__oracle_jsp_text[18]);
                  out.print( usuario1 );
                  out.write(__oracle_jsp_text[19]);
                  out.print(strTmp );
                  out.write(__oracle_jsp_text[20]);
                  out.print( usuario2 );
                  out.write(__oracle_jsp_text[21]);
                  out.print( usuario3 );
                  out.write(__oracle_jsp_text[22]);
                  out.print( ActualizaEstatus.getNombreEstatus(usuario4)[0][0] );
                  out.write(__oracle_jsp_text[23]);
                   if(ActualizaCiudadano.getTieneContestacion(usuario1)){ 
                  out.write(__oracle_jsp_text[24]);
                   }else{ 
                  out.write(__oracle_jsp_text[25]);
                   } 
                  out.write(__oracle_jsp_text[26]);
                   if(ActualizaCiudadano.getTieneContestacion(usuario1)){ 
                  out.write(__oracle_jsp_text[27]);
                  out.print( ActualizaCiudadano.getUltimaRespuestaCiudadano(usuario1) );
                  out.write(__oracle_jsp_text[28]);
                   }else{ 
                  out.write(__oracle_jsp_text[29]);
                   } 
                  out.write(__oracle_jsp_text[30]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[31]);
             } 
            out.write(__oracle_jsp_text[32]);
             } 
            out.write(__oracle_jsp_text[33]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[34]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[35]);
       } 
      out.write(__oracle_jsp_text[36]);
       } else { 
      out.write(__oracle_jsp_text[37]);
       } 
      out.write(__oracle_jsp_text[38]);

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
  private static final char __oracle_jsp_text[][]=new char[39][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>  \n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Tipo de Respuesta</TITLE>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script language=\"JavaScript\" type=\"text/javascript\">\nfunction desplegar(id){\n\tdoc = document.portalTRES;\n\tdoc.accion.value=\"reload\";\n\tdoc.idUs.value=id;\n\tdoc.submit();\n}\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM name=\"portalTRES\" action=\"PortalTipoRespuesta.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"\" name=\"idUs\">\n<table cellspacing=\"2\" cellpadding=\"2\">\n<TBODY>\n\t<TR>\n\t\t<TD class=\"etiquetas\">\n\t\t\t\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\n<table cellspacing=\"2\" cellpadding=\"2\">\n<TBODY>\n\t<tr>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAtencion()\";>Asuntos en Recepción</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAsuntos()\";>Asuntos por turnar</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAsuntosTr()\";>Asuntos en Trámite</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAsuntosTer()\";>Asuntos terminados</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAtender()\";>Instrucciones por atender</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goTramite()\";>Instrucciones en Trámite</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goTerminadas()\";>Instrucciones terminadas</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goRechazadas()\";>Instrucciones rechazadas</a></td>\n\t\t<td class=\"dominoSelTopTab\" bgcolor=\"#004080\"><a onclick=\"goTipoRespuesta()\";>Solicitudes Respondidas</a></td>\n\t\t<!-- <td class=\"dominoTopTab\"><a onclick=\"goTipoRespuestaSin()\";>Solicitudes Sin Notificar</a></td>-->\n\t</tr>\n</TBODY>\n</table>\n<br>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='30%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">Asunto</font>\n\t\t</TD>\n\t\t<TD WIDTH='20%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">Folio</font>\n\t\t</TD>\n\t\t<TD WIDTH='20%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">Estatus</font>\n\t\t</TD>\n\t\t<TD WIDTH='15%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">Respuesta</font>\n\t\t</TD>\n\t\t<TD WIDTH='15%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">Fecha ultima respuesta</font>\n\t\t</TD>\n\t</TR>\t\n</TABLE>\n\n\n<DIV class=documentBody id=Body>\n<div id=\"view\">\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t\t<TBODY>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td colspan=\"2\">\n\t\t\t\t\t<a onClick=\"desplegar(".toCharArray();
    __oracle_jsp_text[10] = 
    ")\">\n\t\t\t\t\t<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[11] = 
    "\" \n\t\t\t\t\t\tborder=\"0\" height=\"16\" width=\"16\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t\t\t</a>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[17] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[18] = 
    ">\n\t\t\t\t<td width=\"2%\"></td>\n\t\t\t\t<td align=\"left\" width=\"28%\">\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t<A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[19] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[20] = 
    "\">\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\t\t\t\t\t\t\n\t\t\t\t\t\t</A>\n\t\t\t\t\t\t\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"center\" width=\"20%\">\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"center\" width=\"20%\">\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"center\" width=\"15%\">\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t\t\tTiene Respuesta\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t\t\t\tNo tiene Respuesta\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"center\" width=\"15%\">\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t\t\tNo ha respondido\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t</TBODY>\n\t\t</table>\n\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t<TR>\n\t\t<TD width=\"100%\">\n\t\t\t<div align=center>\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">******No Hay Solicitudes Respondidas en tu Unidad Administrativa******</FONT>\n\t\t\t</div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t<TR>\n\t\t<TD width=\"100%\">\n\t\t\t<div align=center>\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">******No Hay Solicitudes Respondidas******</FONT>\n\t\t\t</div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n</TBODY>\t\n</table>\n</div>\n<BR>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n<BR>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
