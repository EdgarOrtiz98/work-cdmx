package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _PortalSinNotificacion extends com.orionserver.http.OrionHttpJspPage {


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
    _PortalSinNotificacion page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      
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
      
      
      out.write(__oracle_jsp_text[3]);
      
      	boolean bMostrar	=	false;
      	boolean bExiste		=	false;
      	int t = 0;
      	int j = 0;
      	bExiste		=	ActualizaAsunto.getExistenAsuntos(BUsuario.getIdArea(), BUsuario.getIdUsuario());//ActualizaTipoRespuesta.existenTipoRespuesta();
      
      
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
       
      		if(bExiste){
      			String strDatosNotificados[][] = ActualizaCiudadano.getAsuntosNotificados(); 
      	
      out.write(__oracle_jsp_text[6]);
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
            out.write(__oracle_jsp_text[7]);
            
            			String area = ActualizaUsuario.getIdUsrArea(BUsuario.getIdUsuario());
            			if(BUsuario.getIdArea().equals(area)){
            		
            out.write(__oracle_jsp_text[8]);
             } 
            out.write(__oracle_jsp_text[9]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[10]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[11]);
       } 
      out.write(__oracle_jsp_text[12]);
       } else { 
      out.write(__oracle_jsp_text[13]);
       } 
      out.write(__oracle_jsp_text[14]);

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
  private static final char __oracle_jsp_text[][]=new char[15][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Asuntos sin notificación</TITLE>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script language=\"JavaScript\" type=\"text/javascript\">\n<!-- \ndocument._domino_target = \"_self\";\nfunction _doClick(v, o, t, h) {\n  var form = document.portalTSNOT;\n  if (form.onsubmit) {\n     var retVal = form.onsubmit();\n     if (typeof retVal == \"boolean\" && retVal == false)\n       return false;\n  }\n  var target = document._domino_target;\n  if (o.href != null) {\n    if (o.target != null)\n       target = o.target;\n  } else {\n    if (t != null)\n      target = t;\n  }\n  form.target = target;\n  form.__Click.value = v;\n  if (h != null)\n    form.action += h;\n  form.submit();\n  return false;\n}\n// -->\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"PortalSinNotificacion.jsp\" method=\"post\" name=\"portalTSNOT\">\n<input type=\"hidden\" name=\"__Click\" value=\"0\">\n<table cellspacing=\"2\" cellpadding=\"2\">\n<TBODY>\n\t<tr>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAtencion()\";>Asuntos en Recepción</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAsuntos()\";>Asuntos por turnar</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAsuntosTr()\";>Asuntos en Trámite</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAsuntosTer()\";>Asuntos terminados</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAtender()\";>Instrucciones por atender</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goTramite()\";>Instrucciones en Trámite</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goTerminadas()\";>Instrucciones terminadas</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goRechazadas()\";>Instrucciones rechazadas</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goHoy()\";>Hoy</a></td>\n\t\t<td class=\"dominoSelTopTab\" bgcolor=\"#004080\"><a onclick=\"goTipoRespuesta()\";>Solicitudes Respondidas</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goTipoRespuestaSin()\";>Solicitudes Sin Notificar</a></td>\n\t</tr>\n</TBODY>\n</table>\n<br>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='40%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">Asunto</font>\n\t\t</TD>\n\t\t<TD WIDTH='40%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">Folio</font>\n\t\t</TD>\n\t\t<TD WIDTH='10%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">Estatus</font>\n\t\t</TD>\n\t\t<TD WIDTH='10%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">Respuesta</font>\n\t\t</TD>\n\t</TR>\t\n</TABLE>\n<DIV class=documentBody id=Body>\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[6] = 
    "\n\t\n\t\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\t\t<TR>\n\t\t\t\t<td align=\"center\" width=\"40%\">\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"center\" width=\"40%\">\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"center\" width=\"10%\">\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"center\" width=\"10%\">\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t\t<div align=center>\n\t\t\t\t\t<FONT face=\"verdana\" size=\"4\">******No Hay Solicitudes Sin Notificar en tu Unidad Administrativa******</FONT>\n\t\t\t\t</div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t<TR>\n\t\t<TD width=\"100%\">\n\t\t\t<div align=center>\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">******No Hay Solicitudes Sin Notificar******</FONT>\n\t\t\t</div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n</TBODY>\t\n</table>\n<BR>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n<BR>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
