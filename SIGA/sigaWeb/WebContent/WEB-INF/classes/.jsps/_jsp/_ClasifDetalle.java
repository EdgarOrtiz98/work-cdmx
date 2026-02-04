package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _ClasifDetalle extends com.orionserver.http.OrionHttpJspPage {


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
    _ClasifDetalle page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
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
      
      	String at = "";
      	String ac = "";
      	String strTipo	=	request.getParameter("cls");
      	String strDatos[][] = ActualizaExpArchivado.getExpedienteAtAc(strTipo);
      		at		=	strDatos[0][0];
      		ac		=	strDatos[0][1];
      
      out.write(__oracle_jsp_text[8]);
      out.print(at);
      out.write(__oracle_jsp_text[9]);
      out.print(ac);
      out.write(__oracle_jsp_text[10]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaExpArchivado.getDatosClasificacionDeta(strTipo));
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
            out.write(__oracle_jsp_text[11]);
            out.print( campo7 );
            out.write(__oracle_jsp_text[12]);
            out.print(campo5);
            out.write(__oracle_jsp_text[13]);
            out.print(campo3);
            out.write(__oracle_jsp_text[14]);
            out.print(campo6);
            out.write(__oracle_jsp_text[15]);
            out.print(campo4);
            out.write(__oracle_jsp_text[16]);
            out.print(campo1);
            out.write(__oracle_jsp_text[17]);
            out.print(campo2);
            out.write(__oracle_jsp_text[18]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[19]);

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
  private static final char __oracle_jsp_text[][]=new char[20][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/link.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\" src=\"../js/link.js\"></script>\n<TITLE>Detalle de Clasificacion</TITLE>\n</HEAD>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\nfunction AtAc(at,ac) { \n\tparent.window.document.getElementById('ano_AT').value = at;\n\tparent.window.document.getElementById('ano_AC').value = ac;\n\t}\n</SCRIPT>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"AtAc(".toCharArray();
    __oracle_jsp_text[9] = 
    ",".toCharArray();
    __oracle_jsp_text[10] = 
    ");\">\n<FORM name=\"ClasifDetalle\" action=\"ClasifDetalle.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<input name=\"tmpCopyToRef\" type=\"hidden\" value=\"\">\n<input name=\"idsCC\" type=\"hidden\" value=\"\">\n<DIV align=\"center\">\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n <TR bgcolor=\"#00204f\">\n\t\t<TD width=\"10%\" align=\"center\" colspan=\"7\">\n\t\t<FONT size=\"2\" color=\"white\" face=\"verdana\">DETALLE INSTRUMENTO</FONT>\n\t\t</TD>\n </TR>\n\t<TR bgcolor=\"#00204f\">\n\t\t<TD width=\"15%\" align=\"center\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Fondo</FONT></b>\n        </TD>\n\t\t<TD width=\"15%\" align=\"center\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Subfondo</FONT></b>\n        </TD>\n        <TD width=\"15%\" align=\"center\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Seccion</FONT></b>\n        </TD>\n        <TD width=\"15%\" align=\"center\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Serie</FONT></b>\n        </TD>\n        <TD width=\"15%\" align=\"center\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Subserie</FONT></b>\n        </TD>\n        <TD width=\"15%\" align=\"center\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Valoracion</FONT></b>\n        </TD>\n        <TD width=\"10%\" align=\"center\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Seleccion</FONT></b>\n        </TD>\n    </TR>\n\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t<TR vAlign=top>\n\t\t<TD width=\"15%\">\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t   ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD width=\"15%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"15%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"15%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"15%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"15%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"10%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\t\t\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t<TR vAlign=top>\t\n\t<TD COLSPAN=\"7\" align=\"center\">\n\t<input type=\"button\"\n\t\t\t\tonclick=\"parent.window.document.getElementById('pop9').style.visibility='hidden';\"\n\t\t\t\tvalue=\" Cancel\" class=\"blue100\">\n\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
