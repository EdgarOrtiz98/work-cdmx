package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;


public class _FrameVentanilla extends com.orionserver.http.OrionHttpJspPage {


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
    _FrameVentanilla page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      
      	String strIdArea	= 	(request.getParameter("idArea")!=null)?request.getParameter("idArea"):"";
      	String strIdAsunto 	= 	(request.getParameter("ida")!=null)?request.getParameter("ida"):"";
      	String num 			=	request.getParameter("num");
      	String strDatosRemitenteArea[][]	=	null;
      	
      	boolean	bExisteReg = false;
      	bExisteReg		   = ActualizaUsuario.getExistenUsuarios();
      	int t = 0;
      	boolean bMostrar	=	false;
      	String strAccion = request.getParameter("accion");
      
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[5]);
      out.print(num);
      out.write(__oracle_jsp_text[6]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[7]);
      out.print(num);
      out.write(__oracle_jsp_text[8]);
      if(bExisteReg){
      out.write(__oracle_jsp_text[9]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaUsuario.getUsuarioPorRol(strIdArea));
        __jsp_taghandler_1.setCampo("usuario");
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
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_1,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[10]);
            if(par(t)==true){
            }else{
            out.write(__oracle_jsp_text[11]);
            }
            out.write(__oracle_jsp_text[12]);
            out.print( usuario1 );
            out.write(__oracle_jsp_text[13]);
            out.print( usuario2 );
            out.write(__oracle_jsp_text[14]);
            out.print( usuario3 );
            out.write(__oracle_jsp_text[15]);
            out.print( usuario4 );
            out.write(__oracle_jsp_text[16]);
            out.print( usuario5 );
            out.write(__oracle_jsp_text[17]);
            out.print( usuario2 );
            out.write(__oracle_jsp_text[18]);
            out.print( com.meve.sigma.util.Utilerias.recortaString(usuario2,35) );
            out.write(__oracle_jsp_text[19]);
            out.print( usuario3 );
            out.write(__oracle_jsp_text[20]);
            out.print( com.meve.sigma.util.Utilerias.recortaString(usuario3,35) );
            out.write(__oracle_jsp_text[21]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[22]);
      }else{
      out.write(__oracle_jsp_text[23]);
      }
      out.write(__oracle_jsp_text[24]);

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
  private static final char __oracle_jsp_text[][]=new char[25][];
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
    " \n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>FrameDestinatario.jsp</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n\t\n\tfunction aceptar(numero){\n\t\t\n\t\tvar form = document.framevent;\n\t\tvar form = document.forms[0];\n\t\tvar formP = opener.window.document.forms[0];\n  \t\tvar cadena = \"\";\n  \t\tvar numdoc=0;\n\t\tfor (var i = 0; i < form.elements.length; i++) {\n    \t\tif (form.elements[i].type == \"radio\") {\n      \t\t\tif (form.elements[i].name == \"Sel\") {\n        \t\t\tif (form.elements[i].checked == true){\n        \t\t\t\tvalor = form.elements[i].value;\n        \t\t\t\tif(valor != \"\"){\n\t\t\t\t\t\t\tcadena = cadena + valor;\n        \t\t\t\t\tnumdoc=numdoc + 1;\n\t\t\t\t\t\t}\n        \t\t\t}\n      \t\t\t}\n    \t\t}\n\t\t}\n\t\tif (cadena == \"\")\n\t\t\talert(\"Debe seleccionar un puesto\"); \n\n\t\telse {\n        \tif (numdoc >1)\n\t\t\t\t\talert(\"Debe seleccionar sólo un documento\");\n           \telse {\n\t\t\t\tvar ID = valor.substring(0, valor.indexOf(\"|\"));\n\t\t\t\tvar nombre = valor.substring(valor.indexOf(\"|\")+1, valor.indexOf(\"/\"));\n\t\t\t\tvar cargo = valor.substring(valor.indexOf(\"/\")+1, valor.indexOf(\"*\"));\n\t\t\t\tvar area = valor.substring(valor.indexOf(\"*\")+1, valor.indexOf(\"&\"));\n\t\t\t\tvar correo = valor.substring(valor.indexOf(\"&\")+1, valor.length);\n\n\t\t\t\topener.window.document.forms[0].idDestinatario.value = ID;\n\t\t\t\topener.window.document.forms[0].asuntoDestinatario.value = cargo+\" / \"+nombre;\n\t\t\t\topener.window.document.forms[0].asuntoCargoDest.value = cargo;\n\t\t\t\topener.window.document.forms[0].asuntoAreaDest.value = area;\n\t\t\t\topener.window.document.forms[0].mailDest.value = correo;\n\t\t\t\topener.window.document.forms[0].banderaVent.value = \"1\";\n\n\t\t\t\topener.hay_hija = new Boolean(false);\n\t\t\t\topener.hija = null;\n\n\t\t\t\t//cerrarIframe('pop4', '".toCharArray();
    __oracle_jsp_text[5] = 
    "', numero);\n\t\t\t\twindow.opener.document.Asunto.submit();\n\t\t\t\twindow.close();\n\t\t\t}\n\t\t}\n\t}\n</SCRIPT>\n\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonunload=\"opener.hay_hija=true\"\n\tonClick=\"opener.resetTimer();\"\n\tonKeyPress=\"opener.resetTimer();\">\n<form name=\"framevent\" action=\"FrameVentanilla.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"50%\">\n\t\t\t<DIV>\n\t\t\t\t<input type=\"button\" value=\"Aceptar\" class=\"blue100\" onclick=\"aceptar(".toCharArray();
    __oracle_jsp_text[6] = 
    ")\">\n\t\t\t\t<!-- <input type=\"button\" value=\"Cancelar\" class=\"blue100\" onclick=\"cerrarIframe('pop4', '".toCharArray();
    __oracle_jsp_text[7] = 
    "', ".toCharArray();
    __oracle_jsp_text[8] = 
    ");\"> -->\n\t\t\t\t<input type=\"button\" value=\"Cancelar\" class=\"blue100\" onclick=\"Cancelar();\">\n\t\t\t</DIV>                                                    \n\t\t</td>\n\t\t<td width=\"50%\" align=\"right\">\n\t\t\t<b><font size=\"2\" color=\"#00204F\" face=\"Verdana\"></font></b>\n\t\t</td>\n\t</tr>\n</table>\n<TABLE width=\"100%\" BORDER=\"0\">\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH=\"50%\" align=\"center\">\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"Arial\"><b>Puesto</b></font>\n\t\t</TD>\n\t\t<TD WIDTH=\"50%\" align=\"center\">\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"Arial\"><b>Responsable</b></font>\n\t\t</TD>\n\t</TR>\t\n</TABLE>\n<DIV class=documentBody id=Body>\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<TABLE width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[11] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[12] = 
    ">\n\t\t<td width=\"5%\" align=\"left\">\n\t\t\t<INPUT type=\"radio\" name=\"Sel\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "|".toCharArray();
    __oracle_jsp_text[14] = 
    "/".toCharArray();
    __oracle_jsp_text[15] = 
    "*".toCharArray();
    __oracle_jsp_text[16] = 
    "&".toCharArray();
    __oracle_jsp_text[17] = 
    "\">\n\t\t</td>\n\t\t<td width=\"41%\" align=\"left\">\n\t\t\t<!-- <IMG height=1 src=\"../Imagenes/ecblank.gif\" width=16 border=0>  -->\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[19] = 
    " </A>\n\t\t\t</FONT>\n\t\t</td>\n\t\t<TD width=\"5%\"> &nbsp;&nbsp;</TD>\n\t\t<TD width=\"49%\" align=\"left\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[21] = 
    " </A>\n\t\t\t</FONT>\n\t\t</TD>\n\t</tr>\n\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[23] = 
    "\n<CENTER>\n<table cellspacing=\"2\" cellpadding=\"2\">\n\t<tr>\n\t\t<TD align=\"center\">\n\t\t\t<DIV align=\"center\">\n\t\t\t\t<p><FONT size=\"4\" face=\"Verdana\">** No hay Puestos Registrados ** </FONT></DIV>\n\t\t</TD>\n\t</tr>\n</table>\n</CENTER>\n".toCharArray();
    __oracle_jsp_text[24] = 
    "\n<BR>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</form>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
