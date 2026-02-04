package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.taglib.*;


public class _FrameDestinatario extends com.orionserver.http.OrionHttpJspPage {


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
    _FrameDestinatario page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      
      	String strIdArea 					= 	"";
      	String strDatosRemitenteArea[][]	=	null;
      	
      	boolean	bExisteReg = false;
      	bExisteReg		   = ActualizaUsuario.getExistenUsuarios();
      	int t = 0;
      	boolean bMostrar	=	false;
      	String strAccion = request.getParameter("accion");
      	String strIdUsuario = (request.getParameter("idUs")!=null)?request.getParameter("idUs"):"";
      	String strIdAsunto = (request.getParameter("ida")!=null)?request.getParameter("ida"):"";
      
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[5]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[6]);
       if(bExisteReg){ 
      out.write(__oracle_jsp_text[7]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ComboData.getAreasCombo());
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
             bMostrar = strIdUsuario.equals(campo1); 
            out.write(__oracle_jsp_text[9]);
            out.print(campo1);
            out.write(__oracle_jsp_text[10]);
            out.print((bMostrar)?"collapse.gif":"expand.gif");
            out.write(__oracle_jsp_text[11]);
            out.print( ActualizaArea.NombreArea(campo1) );
            out.write(__oracle_jsp_text[12]);
            if(bMostrar){ 
            out.write(__oracle_jsp_text[13]);
            {
              com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_2=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setDatos(ActualizaUsuario.getUsuarioPorRol(campo1));
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
                  out.write(__oracle_jsp_text[14]);
                  t++;
                  out.write(__oracle_jsp_text[15]);
                  if(par(t)==true){
                  }else{
                  out.write(__oracle_jsp_text[16]);
                  }
                  out.write(__oracle_jsp_text[17]);
                  out.print( usuario1 );
                  out.write(__oracle_jsp_text[18]);
                  out.print( usuario2 );
                  out.write(__oracle_jsp_text[19]);
                  out.print( usuario3 );
                  out.write(__oracle_jsp_text[20]);
                  out.print( usuario4 );
                  out.write(__oracle_jsp_text[21]);
                  out.print( usuario5 );
                  out.write(__oracle_jsp_text[22]);
                  out.print( usuario2 );
                  out.write(__oracle_jsp_text[23]);
                  out.print( usuario5 );
                  out.write(__oracle_jsp_text[24]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[25]);
            }
            out.write(__oracle_jsp_text[26]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[27]);
       }else{ 
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
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    " \n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>FrameDestinatario.jsp</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n\t\n\tfunction aceptar(){\n\t\t\n\t\tvar form = document.framedestinatario;\n  \t\tvar cadena = \"\";\n  \t\tvar numdoc=0;\n\t\tfor (var i = 0; i < form.elements.length; i++) {\n    \t\tif (form.elements[i].type == \"radio\") {\n      \t\t\tif (form.elements[i].name == \"Sel\") {\n        \t\t\tif (form.elements[i].checked == true){\n        \t\t\t\tvalor = form.elements[i].value;\n        \t\t\t\tif(valor != \"\"){\n\t\t\t\t\t\t\tcadena = cadena + valor;\n        \t\t\t\t\tnumdoc=numdoc + 1;\n\t\t\t\t\t\t}\n        \t\t\t}\n      \t\t\t}\n    \t\t}\n\t\t}\n\t\tif (cadena == \"\")\n\t\t\talert(\"Debe seleccionar un documento\"); \n\n\t\telse {\n        \tif (numdoc >1)\n\t\t\t\t\talert(\"Debe seleccionar sólo un documento\");\n           \telse {\n\t\t\t\tvar ID = valor.substring(0, valor.indexOf(\"|\"));\n\t\t\t\tvar nombre = valor.substring(valor.indexOf(\"|\")+1, valor.indexOf(\"/\"));\n\t\t\t\tvar cargo = valor.substring(valor.indexOf(\"/\")+1, valor.indexOf(\"*\"));\n\t\t\t\tvar area = valor.substring(valor.indexOf(\"*\")+1, valor.indexOf(\"&\"));\n\t\t\t\tvar correo = valor.substring(valor.indexOf(\"&\")+1, valor.length);\n\t\t\t\tparent.window.document.forms[0].idDestinatario.value = ID;\n\t\t\t\tparent.window.document.forms[0].asuntoDestinatario.value = nombre;\n\t\t\t\tparent.window.document.forms[0].asuntoCargoDest.value = cargo;\n\t\t\t\tparent.window.document.forms[0].asuntoAreaDest.value = area;\n\t\t\t\tparent.window.document.forms[0].mailDest.value = correo;\n\t\t\t\tcerrarIframe('pop4', '".toCharArray();
    __oracle_jsp_text[5] = 
    "');\n\t\t\t}\n\t\t}\n\t}\n\n\tfunction desplegar(id){\n\t\tdoc = document.framedestinatario;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.idUs.value=id;\n\t\tdoc.submit();\n\t}\n\n</SCRIPT>\n\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n<form name=\"framedestinatario\" action=\"FrameDestinatario.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"\" name=\"idUs\">\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"50%\">\n\t\t\t<DIV>\n\t\t\t\t<input type=\"button\" value=\"Aceptar\" class=\"blue100\" onclick=\"aceptar()\">\n\t\t\t\t<input type=\"button\" value=\"Cancelar\" class=\"blue100\" onclick=\"cerrarIframe('pop4', '".toCharArray();
    __oracle_jsp_text[6] = 
    "');\">\n\t\t\t</DIV>\n\t\t</td>\n\t\t<td width=\"50%\" align=\"right\">\n\t\t\t<b><font size=\"2\" color=\"#00204F\" face=\"Verdana\">Destinatario</font></b>\n\t\t</td>\n\t</tr>\n</table>\n<TABLE width=\"100%\" BORDER=\"0\">\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH=\"50%\" align=\"center\">\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"Arial\"><b>Destinatario</b></font>\n\t\t</TD>\n\t\t<TD WIDTH=\"50%\" align=\"center\">\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"Arial\"><b>Unidad Administrativa</b></font>\n\t\t</TD>\n\t</TR>\t\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n<TABLE width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t\t<TBODY>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td colspan=\"2\" width=\"600\">\n\t\t\t\t\t<a onClick=\"desplegar(".toCharArray();
    __oracle_jsp_text[10] = 
    ")\">\n\t\t\t\t\t<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[11] = 
    "\" \n\t\t\t\t\t\tborder=\"0\" height=\"16\" width=\"16\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t\t\t</a>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "  \n\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[16] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[17] = 
    ">\n\t\t\t\t<td width=\"50%\" align=\"left\">\n\t\t\t\t\t<INPUT type=\"radio\" name=\"Sel\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "|".toCharArray();
    __oracle_jsp_text[19] = 
    "/".toCharArray();
    __oracle_jsp_text[20] = 
    "*".toCharArray();
    __oracle_jsp_text[21] = 
    "&".toCharArray();
    __oracle_jsp_text[22] = 
    "\">\n\t\t\t\t\t<IMG height=1 src=\"../Imagenes/ecblank.gif\" width=16 border=0>\n\t\t\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t\t\t</FONT>\n\t\t\t\t</td>\n\t\t\t\t<TD width=\"50%\" align=\"center\">\n\t\t\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t\t</FONT>\n\t\t\t\t</TD>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t</TBODY>\n\t\t</table>\n\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[28] = 
    "\n<CENTER>\n<table cellspacing=\"2\" cellpadding=\"2\">\n\t<tr>\n\t\t<TD align=\"center\">\n\t\t\t<DIV align=\"center\">\n\t\t\t\t<p><FONT size=\"4\" face=\"Verdana\">***** No se han encontrado\n\t\tDocumentos ***** </FONT></DIV>\n\t\t</TD>\n\t</tr>\n</table>\n</CENTER>\n".toCharArray();
    __oracle_jsp_text[29] = 
    "\n</form>\n</BODY>\n\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
