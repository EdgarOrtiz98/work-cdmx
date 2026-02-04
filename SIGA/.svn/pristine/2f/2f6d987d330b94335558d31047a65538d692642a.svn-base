package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _PortalHoy extends com.orionserver.http.OrionHttpJspPage {


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
    _PortalHoy page = this;
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
      	if(BUsuario==null)
      		response.sendRedirect("index.jsp?pagina="+ strTmp);
      
      out.write(__oracle_jsp_text[4]);
      
      	boolean bExiste	= false;
      	int t = 0;
      	int j = 0;
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	String strFechaCreacion			=	sdf.format(f); 
      	bExiste = ActualizaAsunto.getExistenAsuntosHoy(strFechaCreacion);
      	String strActivarPortal = application.getInitParameter("ActivarPortal");
      
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
       if(strActivarPortal.equals("si")){ 
      out.write(__oracle_jsp_text[7]);
       } 
      out.write(__oracle_jsp_text[8]);
       if(bExiste){ 
      out.write(__oracle_jsp_text[9]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaAsunto.getDatosAsuntoHoy(strFechaCreacion));
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
            out.write(__oracle_jsp_text[10]);
             if(	BUsuario.getIdArea().equals(campo4)){ 
            out.write(__oracle_jsp_text[11]);
             t++; 
            out.write(__oracle_jsp_text[12]);
            if(par(t)==true){
            }else{
            out.write(__oracle_jsp_text[13]);
            }
            out.write(__oracle_jsp_text[14]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[15]);
            out.print(strTmp );
            out.write(__oracle_jsp_text[16]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[17]);
             if(campo3.equals("1")){ 
            out.write(__oracle_jsp_text[18]);
             }else if(campo3.equals("2")){ 
            out.write(__oracle_jsp_text[19]);
             }else if(campo3.equals("3")){ 
            out.write(__oracle_jsp_text[20]);
             } 
            out.write(__oracle_jsp_text[21]);
             j++; 
            out.write(__oracle_jsp_text[22]);
             } 
            out.write(__oracle_jsp_text[23]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[24]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[25]);
       ////System.out.println("j-->"+j); 
      out.write(__oracle_jsp_text[26]);
       } 
      out.write(__oracle_jsp_text[27]);
       } else { 
      out.write(__oracle_jsp_text[28]);
       } 
      out.write(__oracle_jsp_text[29]);

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
  private static final char __oracle_jsp_text[][]=new char[30][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Asuntos de Hoy</TITLE>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>PortalTramite.jsp</TITLE>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM method=\"post\" action=\"PortalHoy.jsp\" name=\"pHoy\">\n<input type=\"hidden\" name=\"__Click\" value=\"0\">\n<table cellspacing=\"2\" cellpadding=\"2\">\n<TBODY>\n\t<TR>\n\t\t<TD class=\"etiquetas\">\n\t\t\t\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\n<table cellspacing=\"2\" cellpadding=\"2\">\n<TBODY>\n\t<tr>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAtencion()\";>Asuntos en Recepción</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAsuntos()\";>Asuntos por turnar</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAsuntosTr()\";>Asuntos en Trámite</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAsuntosTer()\";>Asuntos terminados</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAtender()\";>Instrucciones por atender</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goTramite()\";>Instrucciones en Trámite</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goTerminadas()\";>Instrucciones terminadas</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goRechazadas()\";>Instrucciones rechazadas</a></td>\n\t\t<td class=\"dominoSelTopTab\" bgcolor=\"#004080\"><a onclick=\"goHoy()\";>Hoy</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goTipoRespuesta()\";>Solicitudes Respondidas</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\t<!-- <td class=\"dominoTopTab\"><a onclick=\"goTipoRespuestaSin()\";>Solicitudes Sin Notificar</a></td>-->\n\t</tr>\n</TBODY>\n</table>\n<br>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='75%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">Asunto</font></TD>\n\t\t<TD WIDTH='25%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">Estatus</font></TD>\n\t</TR>\n</TABLE> \n<div id=\"msg\">\n</div>\n\n<DIV class=documentBody id=Body>\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[9] = 
    "  \n\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[13] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[14] = 
    ">\n\t\t<td width='75%'>\n\t\t\t<img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\" width=\"16\" alt=\"\">\n\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t<A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[15] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[16] = 
    "\">".toCharArray();
    __oracle_jsp_text[17] = 
    "</A>\n\t\t\t</Font>\n\t\t</td>\n\t\t<td width='25%' align=\"center\">\n\t\t\t<font size=\"1\" face=\"Verdana\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t\tatención\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t\tEn Tramite\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\tTerminada\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t</font>\t\t\t\t\n\t\t</td>\n\t</tr>\n\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t<TR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"verdana\" size=\"4\">******No Hay Asuntos\n\t\t\tCapturados de su Unidad Administrativa******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t<TR>\n\t\t<TD width=\"100%\">\n\t\t\t<div align=center>\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">******No Hay Asuntos generados el Día de hoy******</FONT>\n\t\t\t</div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n</TBODY>\t\n</table>\n</div>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>\n\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
