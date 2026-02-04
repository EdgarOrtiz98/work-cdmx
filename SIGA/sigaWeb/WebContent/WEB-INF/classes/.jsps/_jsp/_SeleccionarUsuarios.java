package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _SeleccionarUsuarios extends com.orionserver.http.OrionHttpJspPage {


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
    _SeleccionarUsuarios page = this;
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
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaUsuario.getListaUsuarios());
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
            out.write(__oracle_jsp_text[4]);
            out.print(Lista1 );
            out.write(__oracle_jsp_text[5]);
            out.print(Lista2);
            out.write(__oracle_jsp_text[6]);
            out.print(Lista2);
            out.write(__oracle_jsp_text[7]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[8]);

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
  private static final char __oracle_jsp_text[][]=new char[9][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Seleccionar Usuarios</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n\t\n\tfunction aceptar(){\n\t\t\n\t\tvar form = document.forms[0];\n  \t\tvar cadena = \"\";\n  \t\tvar numdoc=0;\n\t\tfor (var i = 0; i < form.elements.length; i++) {\n    \t\tif (form.elements[i].type == \"checkbox\") {\n      \t\t\tif (form.elements[i].name == \"Sel\") {\n        \t\t\tif (form.elements[i].checked == true){\n        \t\t\t\tvalor = form.elements[i].value;\n        \t\t\t\tif(valor != \"\"){\n\t\t\t\t\t\t\tcadena = cadena + valor;\n        \t\t\t\t\tnumdoc=numdoc + 1;\n\t\t\t\t\t\t}\n        \t\t\t}\n      \t\t\t}\n    \t\t}\n\t\t}\n\t\tif (cadena == \"\")\n\t\t\talert(\"Debe seleccionar un Usuario\"); \n\n\t\telse{ \n        \tif (numdoc >1)\n\t\t\t\t\talert(\"Debe seleccionar sólo un documento\");\n           \telse {\n\t\t\t\tvar ID = valor.substring(0, valor.indexOf(\"|\"));\n\t\t\t\tvar nombre = valor.substring(valor.indexOf(\"|\")+1, valor.length);\n\t\t\t\twindow.opener.document.forms[0].idUsuario.value = ID;\n\t\t\t\twindow.opener.document.forms[0].responderA.value = nombre;\n\t\t\t\twindow.close();\n\t\t\t}\n\t\t}\n\t}\n\n</SCRIPT>\n\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"SeleccionarUsuarios.jsp\" name=\"SelUsr\" method=\"post\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t<TD width=\"1%\">&nbsp;</TD>\n    </TR>\n</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"100%\" align=\"right\">\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<INPUT class=\"blue100\" type=\"button\" value=\"Aceptar\" onclick=\"aceptar()\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<INPUT class=\"blue100\" type=\"button\" value=\"Cancelar\" onclick=\"window.close();\">\n\t\t</TD>\t\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" bgcolor=\"#00204F\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n<DIV class=documentBody id=Body>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[4] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t\n\t\t\t<TD align=\"left\" width=\"100%\">\n\t\t\t\t<INPUT type=\"checkbox\" value=\"".toCharArray();
    __oracle_jsp_text[5] = 
    "|".toCharArray();
    __oracle_jsp_text[6] = 
    "\" name=\"Sel\">\n\t\t\t\t<IMG height=1 src=\"../Imagenes/ecblank.gif\" width=16 border=0>\n\t\t\t\t<FONT face=Arial color=#000080 size=1>".toCharArray();
    __oracle_jsp_text[7] = 
    "/meve</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n</TBODY>\n</TABLE>\n</DIV>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
