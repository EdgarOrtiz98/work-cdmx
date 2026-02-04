package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.beans.search.*;


public class _busquedaAsuntos extends com.orionserver.http.OrionHttpJspPage {


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
    _busquedaAsuntos page = this;
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
      	try{
      		response.sendRedirect("index.jsp?pagina="+ strTmp);
      	}catch(java.io.IOException io){;}
      
      
      out.write(__oracle_jsp_text[4]);
      
      	String strBusqueda 	= 	"";
      	String strAccion	=	"";
      	String strPP		=	"";
      	boolean bExiste		= 	false;
      	int t 				= 	0;
      	String strResult[][]=	null;
      	bExiste	= ActualizaAsunto.getExistenAsuntos(BUsuario.getIdArea(), BUsuario.getIdUsuario());
      
        	strAccion = request.getParameter("accion");
      
      	if(strAccion != null && strAccion.equals("buscar")){
      		strBusqueda = 	request.getParameter("buscarAsunto");
      		strPP		=	request.getParameter("PP");
      		strResult = ActualizaBuscar.busquedaAsunto(strBusqueda, strPP);
      	}
      
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
       if(strBusqueda != null && strBusqueda.length() > 0){ 
      out.write(__oracle_jsp_text[7]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(strResult);
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
            if(par(t)==true){
            }else{
            out.write(__oracle_jsp_text[9]);
            }
            out.write(__oracle_jsp_text[10]);
             t++; 
            out.write(__oracle_jsp_text[11]);
            if(campo7.length() == 0){
            out.write(__oracle_jsp_text[12]);
            }else{
            out.write(__oracle_jsp_text[13]);
            out.print(campo7 );
            out.write(__oracle_jsp_text[14]);
            }
            out.write(__oracle_jsp_text[15]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[16]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[17]);
            if(campo7.length() == 0){
            out.write(__oracle_jsp_text[18]);
            }else{
            out.write(__oracle_jsp_text[19]);
            out.print(campo7 );
            out.write(__oracle_jsp_text[20]);
            }
            out.write(__oracle_jsp_text[21]);
            out.print(campo4 );
            out.write(__oracle_jsp_text[22]);
            if(campo7.length() == 0){
            out.write(__oracle_jsp_text[23]);
            }else{
            out.write(__oracle_jsp_text[24]);
            out.print(campo7 );
            out.write(__oracle_jsp_text[25]);
            }
            out.write(__oracle_jsp_text[26]);
            out.print(campo5 );
            out.write(__oracle_jsp_text[27]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[28]);
       }else{ 
      out.write(__oracle_jsp_text[29]);
       } 
      out.write(__oracle_jsp_text[30]);

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
  private static final char __oracle_jsp_text[][]=new char[31][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<html>\n<head>\n<TITLE>Busqueda de Asunto</TITLE>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    " \n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<link rel=\"stylesheet\" href=\"../css/menu.css\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<META HTTP-EQUIV=\"Pragma\" CONTENT=\"no-cache\">\n<META HTTP-EQUIV=\"Expires\" CONTENT=\"-1\">\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</head>\n<body background=\"../Imagenes/fondo_claro.jpg\"\nonclick=\"opener.timer_cancel()\"\nonkeypress=\"opener.timer_cancel()\">\n\n<input type=\"hidden\" name=\"__Click\" value=\"0\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"buscar\">\n\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='25%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">Asunto</font></TD>\n\t\t<TD WIDTH='25%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">Folio</font></TD>\n\t\t<TD WIDTH='25%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">Avance (%)</font></TD>\n\t\t<TD WIDTH='25%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">Estatus</font></TD>\n\t</TR>\n</TABLE>\n<div id=\"msg\"></div>\n<br>\n<DIV class=documentBody id=Body>\n<div id=\"view\">\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\t<TR valign=\"top\" ".toCharArray();
    __oracle_jsp_text[9] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[10] = 
    ">\n\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\t<TD width=\"25%\">\n\t\t\t\t<img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\" width=\"16\" alt=\"\">\n\t\t\t\t<FONT SIZE=2 ".toCharArray();
    __oracle_jsp_text[12] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[13] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t\t\tFACE=\"Verdana\"> <A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[16] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[17] = 
    "</A>\n\t\t\t\t</Font>\n\t\t\t</TD>\n\t\t\t<TD width=\"25%\" align=\"center\">\n\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[18] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[19] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\"".toCharArray();
    __oracle_jsp_text[21] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[22] = 
    "</font>\n\t\t\t</TD>\n\t\t\t<TD width=\"25%\" align=\"center\">\n\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[23] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[24] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[25] = 
    "\"".toCharArray();
    __oracle_jsp_text[26] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[27] = 
    "</font>\n\t\t\t</TD>\n\t\t\t<TD width=\"25%\" align=\"center\">\n\t\t\t\t<IMG SRC='../Imagenes/gris5.gif' BORDER=0 ALT=''>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\t\n\t\t<TR>\n\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t<TD align=\"center\">\n\t\t\t\t<FONT face=\"Arial\" size=\"4\">** Debe de capturar un criterio de Busqueda **</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t</TBODY>\n</table>\n</div>\n<br>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</body>\n</html>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
