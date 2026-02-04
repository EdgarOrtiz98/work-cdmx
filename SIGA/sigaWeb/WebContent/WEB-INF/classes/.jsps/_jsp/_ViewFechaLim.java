package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.reportes.*;


public class _ViewFechaLim extends com.orionserver.http.OrionHttpJspPage {


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
    _ViewFechaLim page = this;
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
      
      	boolean bExistenRem = false;
      	bExistenRem = ActualizaReportes.getExistenTiempoLim();
      
      out.write(__oracle_jsp_text[5]);
      if(BUsuario.getSupervisor()){
      out.write(__oracle_jsp_text[6]);
      }
      out.write(__oracle_jsp_text[7]);
       if(bExistenRem){ 
      out.write(__oracle_jsp_text[8]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaReportes.getReportesPorFechaLim());
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
            out.write(__oracle_jsp_text[9]);
            out.print(campo1);
            out.write(__oracle_jsp_text[10]);
            out.print(campo2);
            out.write(__oracle_jsp_text[11]);
            out.print(campo3);
            out.write(__oracle_jsp_text[12]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[13]);
       }else{ 
      out.write(__oracle_jsp_text[14]);
       } 
      out.write(__oracle_jsp_text[15]);

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
  private static final char __oracle_jsp_text[][]=new char[16][];
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
    "\n\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Asuntos por Fecha Límite</TITLE>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM name=\"viewFechLim\" action=\"ViewFechaLim.jsp\" method=\"post\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"right\">\n<IMG border=\"0\" src=\"../Imagenes/tit_por_fec_lim.gif\" width=\"244\" height=\"32\">\n</DIV>\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr valign=\"top\">\n\t<td width=\"43%\">\n\t\t".toCharArray();
    __oracle_jsp_text[6] = 
    "\n\t\t<a title=\"Genera Reporte\">\n\t\t\t<img src=\"../Imagenes/nuevo1.gif\" width=\"27\" height=\"24\" border=\"0\" alt=\"Generar Reporte\">\n\t\t</a>\n\t\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t\t<font size=\"2\" face=\"Tahoma\"></font>\n\t</td>\n\t<td width=\"57%\">\n\t<div align=\"right\">\n\t\t<a>\n\t\t\t<img src=\"../Imagenes/flech_cal1.gif\" width=\"11\" height=\"9\" border=\"0\" alt=\"\">\n\t\t</a>\n\t\t<a>\n\t\t\t<img src=\"../Imagenes/flech_cal.gif\" width=\"11\" height=\"9\" border=\"0\" alt=\"\">\n\t\t</a>\n\t\t\t<img src=\"../Imagenes/trans.gif\" width=\"20\" height=\"3\" alt=\"\">\n\t</div>\n\t</td>\n</tr>\n</table>\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr valign=\"top\">\n\t<td width=\"100%\" bgcolor=\"#002060\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\" alt=\"\"></td>\n</tr>\n</table>\n<br>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='15%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">No. de Reporte</font></TD>\n\t\t<TD WIDTH='60%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">Reporte</font></TD>\n\t\t<TD WIDTH='25%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">Fecha de Creación</font></TD>\n\t</TR>\n</TABLE>\n<br>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t<TR>\n\t\t<TD WIDTH='15%' align=\"center\">\n\t\t\t<FONT SIZE=2 COLOR=\"000000\" FACE=\"Arial\">\n\t\t\t<A>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t</A>\n\t\t\t</font>\n\t\t</TD>\n\t\t<TD WIDTH='60%' align=\"center\"><FONT SIZE=2 COLOR=\"000000\"\n\t\t\tFACE=\"Arial\">".toCharArray();
    __oracle_jsp_text[11] = 
    "</font></TD>\n\t\t<TD WIDTH='25%' align=\"center\"><FONT SIZE=2 COLOR=\"000000\"\n\t\t\tFACE=\"Arial\">".toCharArray();
    __oracle_jsp_text[12] = 
    "</font></TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t<TR>\n\t\t<TD>******** No existen reportes generados *******</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t</TBODY>\n</TABLE>\n\n</FORM>\n</BODY>\n\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
