package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.*;


public class _TipoRespuestaView extends com.orionserver.http.OrionHttpJspPage {


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
    _TipoRespuestaView page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("headerC.jsp");
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
      		catch(java.io.IOException io){;}
      	}
      
      
      out.write(__oracle_jsp_text[4]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[5]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[6]);
       } 
      out.write(__oracle_jsp_text[7]);
      
      		boolean bOperacion = false;
      		String strIds_Borrar[] = null;
      		String strAccion = "";
      		boolean bexiste = false;
      		bexiste = ActualizaTipoRespuesta.existenTipoRespuesta();
      		int t = 0;
      		strAccion = request.getParameter("accion");
      		strIds_Borrar = request.getParameterValues("Borrar");
      		if (strAccion != null && strAccion.trim().length() > 0 && strAccion.equals("borrar")) {
      			bOperacion = ActualizaTipoRespuesta.getDeleteTipoRespuesta(strIds_Borrar);
      		}
      
      out.write(__oracle_jsp_text[8]);
      out.write(__oracle_jsp_text[9]);
       int j=0; 
      out.write(__oracle_jsp_text[10]);
       if(bexiste){ 
      out.write(__oracle_jsp_text[11]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaTipoRespuesta.getTipoRespuesta());
        __jsp_taghandler_1.setCampo("Lista");
        java.lang.String Lista1 = null;
        java.lang.String Lista2 = null;
        java.lang.String Lista3 = null;
        java.lang.String Lista4 = null;
        java.lang.String Lista5 = null;
        java.lang.String Lista6 = null;
        java.lang.String Lista7 = null;
        java.lang.String Lista8 = null;
        java.lang.String Lista9 = null;
        java.lang.String Lista10 = null;
        java.lang.String Lista11 = null;
        java.lang.String Lista12 = null;
        java.lang.String Lista13 = null;
        java.lang.String Lista14 = null;
        java.lang.String Lista15 = null;
        java.lang.String Lista16 = null;
        java.lang.String Lista17 = null;
        java.lang.String Lista18 = null;
        java.lang.String Lista19 = null;
        java.lang.String Lista20 = null;
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_1,__jsp_tag_starteval,out);
          do {
            Lista1 = (java.lang.String) pageContext.findAttribute("Lista1");
            Lista2 = (java.lang.String) pageContext.findAttribute("Lista2");
            Lista3 = (java.lang.String) pageContext.findAttribute("Lista3");
            Lista4 = (java.lang.String) pageContext.findAttribute("Lista4");
            Lista5 = (java.lang.String) pageContext.findAttribute("Lista5");
            Lista6 = (java.lang.String) pageContext.findAttribute("Lista6");
            Lista7 = (java.lang.String) pageContext.findAttribute("Lista7");
            Lista8 = (java.lang.String) pageContext.findAttribute("Lista8");
            Lista9 = (java.lang.String) pageContext.findAttribute("Lista9");
            Lista10 = (java.lang.String) pageContext.findAttribute("Lista10");
            Lista11 = (java.lang.String) pageContext.findAttribute("Lista11");
            Lista12 = (java.lang.String) pageContext.findAttribute("Lista12");
            Lista13 = (java.lang.String) pageContext.findAttribute("Lista13");
            Lista14 = (java.lang.String) pageContext.findAttribute("Lista14");
            Lista15 = (java.lang.String) pageContext.findAttribute("Lista15");
            Lista16 = (java.lang.String) pageContext.findAttribute("Lista16");
            Lista17 = (java.lang.String) pageContext.findAttribute("Lista17");
            Lista18 = (java.lang.String) pageContext.findAttribute("Lista18");
            Lista19 = (java.lang.String) pageContext.findAttribute("Lista19");
            Lista20 = (java.lang.String) pageContext.findAttribute("Lista20");
            out.write(__oracle_jsp_text[12]);
             if(	BUsuario.getAdmon() ||
            			BUsuario.getSupervisor()){ 
            out.write(__oracle_jsp_text[13]);
             t++; 
            out.write(__oracle_jsp_text[14]);
            if(par(t)==true){
            }else{
            out.write(__oracle_jsp_text[15]);
            }
            out.write(__oracle_jsp_text[16]);
            out.print(Lista1 );
            out.write(__oracle_jsp_text[17]);
            out.print(Lista1);
            out.write(__oracle_jsp_text[18]);
            out.print(Lista2);
            out.write(__oracle_jsp_text[19]);
            out.print(Lista3);
            out.write(__oracle_jsp_text[20]);
             j++; 
            out.write(__oracle_jsp_text[21]);
             } 
            out.write(__oracle_jsp_text[22]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[23]);
       if(j==0){ 
      out.write(__oracle_jsp_text[24]);
       } 
      out.write(__oracle_jsp_text[25]);
       }else{ 
      out.write(__oracle_jsp_text[26]);
       } 
      out.write(__oracle_jsp_text[27]);

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
  private static final char __oracle_jsp_text[][]=new char[28][];
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
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<SCRIPT language=\"JavaScript\" src=\"../js/GeneralFunctions.js\"></SCRIPT>\n<TITLE>Tipo de Respuesta</TITLE>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"TipoRespuestaView.jsp\" name=\"tiporespuestaView\" method=\"get\">\n<INPUT type=\"hidden\" name=\"accion\" size=\"20\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"43%\"><A href=\"TipoRespuesta.jsp\" target=\"_self\"> <IMG\n\t\t\t\theight=\"26\" src=\"../Imagenes/Nuevo.gif\" width=\"27\" border=\"0\"\n\t\t\t\talt=\"Nuevo Tipo de Respuesta\"> </A> <FONT face=\"Tahoma\" size=\"2\"></FONT> <A\n\t\t\t\thref=\"javascript:Borrar()\" target=\"_self\"><IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/borrar2.gif\" width=\"30\" height=\"27\"\n\t\t\t\talt=\"Borrar Tipo de Respuesta\"></A></TD>\n\t\t\t<TD width=\"57%\">\n\t\t\t<DIV align=\"right\"><IMG border=\"0\" src=\"../Imagenes/flech_cal1.gif\"\n\t\t\t\twidth=\"11\" height=\"9\"> <IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/flech_cal.gif\" width=\"11\" height=\"9\"> &nbsp; <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/masbien.gif\" width=\"20\" height=\"20\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/menosbien.gif\" width=\"20\" height=\"20\"></DIV>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" bgcolor=\"#002060\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<BR>\n<TABLE width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR bgcolor=\"#00204f\">\n\t\t\t<TD width=\"70%\">\n\t\t\t<CENTER><FONT size=\"2\" face=\"verdana\" color=\"white\">Tipo de Respuesta</FONT></CENTER>\n\t\t\t</TD>\n\t\t\t<TD width=\"30%\">\n\t\t\t<CENTER><FONT size=\"2\" face=\"verdana\" color=\"white\">Fecha de Registro</FONT></CENTER>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV id=\"msg\"></DIV>\n<DIV id=\"view\"><BR>\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n<TABLE width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t<TR valign=\"top\" ".toCharArray();
    __oracle_jsp_text[15] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[16] = 
    ">\n\t\t\t<TD width=\"100%\">\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"70%\"><INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\"\n\t\t\t\t\t\tname=\"Borrar\"> <IMG height=1 src=\"../Imagenes/ecblank.gif\"\n\t\t\t\t\t\twidth=16 border=0><FONT face=Arial color=#000080 size=1>\n\t\t\t\t\t\t<A href=\"TipoRespuesta.jsp?id_res=".toCharArray();
    __oracle_jsp_text[18] = 
    "\">".toCharArray();
    __oracle_jsp_text[19] = 
    "</A>\n\t\t\t\t\t</FONT></td>\n\t\t\t\t\t<td width=\"2%\">&nbsp;</td>\n\t\t\t\t\t<td width=\"28%\">".toCharArray();
    __oracle_jsp_text[20] = 
    "</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t<TR>\n\t\t<TD width=\"100%\">\n\t\t<div align=center><FONT face=\"verdana\" size=\"4\">******No hay Tipos \n\t\tde Respuestas capturados ******</FONT></div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t<tr>\n\t\t<TD width=\"100%\">\n\t\t<div align=center><FONT face=\"verdana\" size=\"4\">******No hay Tipos \n\t\tde Respuestas capturados ******</FONT></div>\n\t\t</TD>\n\t</tr>\n\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n</TABLE>\n</DIV>\n</FORM>\n\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
