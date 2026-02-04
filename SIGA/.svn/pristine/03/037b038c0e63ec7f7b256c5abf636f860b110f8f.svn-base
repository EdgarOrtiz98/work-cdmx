package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.util.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.reportes.*;


public class _MailNoty extends com.orionserver.http.OrionHttpJspPage {


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
    _MailNoty page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      
      	String strIdAsunto	=	"";
      	String strIdAsunto2	=	"";
      	String strAsunto	=	"";
      	String strfoliom = 		"";
      	String strenviar = 		"";
      	String mailsend = "";
      
      	strIdAsunto2			=	"72";//request.getParameter("id_asunto");
      	strIdAsunto	=	request.getParameter("id_asunto");
      	strAsunto	=	request.getParameter("asunto");
      	strfoliom	=	request.getParameter("foliom");
      	strenviar	=	request.getParameter("enviar");
      	mailsend	=	request.getParameter("mailsend");
      	String serverName = application.getInitParameter("servername");
      	SenderMail mail = new SenderMail();
      
      	if(strenviar!= null && !strenviar.equalsIgnoreCase("")){
      	  	mail.sendConfirmacionTerminado(strIdAsunto,strAsunto,strfoliom,mailsend, session.getServletContext());
      		boolean bActualiza = ActualizaAsunto.getUpdateMail(strIdAsunto);
      	}
      
      
      out.write(__oracle_jsp_text[4]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[5]);
      out.print(strAsunto);
      out.write(__oracle_jsp_text[6]);
      out.print(strfoliom);
      out.write(__oracle_jsp_text[7]);
      out.print(mailsend);
      out.write(__oracle_jsp_text[8]);
      if(strenviar != null && !strenviar.equalsIgnoreCase("")){
      	
      out.write(__oracle_jsp_text[9]);
      }
      out.write(__oracle_jsp_text[10]);
      out.print(strAsunto);
      out.write(__oracle_jsp_text[11]);
      out.print(strfoliom);
      out.write(__oracle_jsp_text[12]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaInstrucciones.InstruccionPorIdAsunto(strIdAsunto));
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
            out.write(__oracle_jsp_text[13]);
             if(campo3.length() == 0){ 
            out.write(__oracle_jsp_text[14]);
            out.print( campo8 );
            out.write(__oracle_jsp_text[15]);
             }else{ 
            out.write(__oracle_jsp_text[16]);
            out.print( ActualizaInst.getNombreInstruccion1(campo3) );
            out.write(__oracle_jsp_text[17]);
             } 
            out.write(__oracle_jsp_text[18]);
            {
              com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_2=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setDatos(ActualizaHistorial.getHistorialRespuestasPorInstruccion(campo12));
              __jsp_taghandler_2.setCampo("lista");
              java.lang.String lista1 = null;
              java.lang.String lista2 = null;
              java.lang.String lista3 = null;
              java.lang.String lista4 = null;
              java.lang.String lista5 = null;
              java.lang.String lista6 = null;
              java.lang.String lista7 = null;
              java.lang.String lista8 = null;
              java.lang.String lista9 = null;
              java.lang.String lista10 = null;
              java.lang.String lista11 = null;
              java.lang.String lista12 = null;
              java.lang.String lista13 = null;
              java.lang.String lista14 = null;
              java.lang.String lista15 = null;
              java.lang.String lista16 = null;
              java.lang.String lista17 = null;
              java.lang.String lista18 = null;
              java.lang.String lista19 = null;
              java.lang.String lista20 = null;
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_2,__jsp_tag_starteval,out);
                do {
                  lista1 = (java.lang.String) pageContext.findAttribute("lista1");
                  lista2 = (java.lang.String) pageContext.findAttribute("lista2");
                  lista3 = (java.lang.String) pageContext.findAttribute("lista3");
                  lista4 = (java.lang.String) pageContext.findAttribute("lista4");
                  lista5 = (java.lang.String) pageContext.findAttribute("lista5");
                  lista6 = (java.lang.String) pageContext.findAttribute("lista6");
                  lista7 = (java.lang.String) pageContext.findAttribute("lista7");
                  lista8 = (java.lang.String) pageContext.findAttribute("lista8");
                  lista9 = (java.lang.String) pageContext.findAttribute("lista9");
                  lista10 = (java.lang.String) pageContext.findAttribute("lista10");
                  lista11 = (java.lang.String) pageContext.findAttribute("lista11");
                  lista12 = (java.lang.String) pageContext.findAttribute("lista12");
                  lista13 = (java.lang.String) pageContext.findAttribute("lista13");
                  lista14 = (java.lang.String) pageContext.findAttribute("lista14");
                  lista15 = (java.lang.String) pageContext.findAttribute("lista15");
                  lista16 = (java.lang.String) pageContext.findAttribute("lista16");
                  lista17 = (java.lang.String) pageContext.findAttribute("lista17");
                  lista18 = (java.lang.String) pageContext.findAttribute("lista18");
                  lista19 = (java.lang.String) pageContext.findAttribute("lista19");
                  lista20 = (java.lang.String) pageContext.findAttribute("lista20");
                  out.write(__oracle_jsp_text[19]);
                  out.print(lista2);
                  out.write(__oracle_jsp_text[20]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[21]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[22]);

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
  private static final char __oracle_jsp_text[][]=new char[23][];
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/link.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Notificar Correo Electrónico</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n\tfunction enviar(){\n\tlocation.assign('MailNoty.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[5] = 
    "&enviar=yes&asunto=".toCharArray();
    __oracle_jsp_text[6] = 
    "&foliom=".toCharArray();
    __oracle_jsp_text[7] = 
    "&mailsend=".toCharArray();
    __oracle_jsp_text[8] = 
    "');\n\t\n\t}\n\tfunction sierra()\n\t{\n\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\talert(\"Confirmación Enviada\");\n\t\twindow.close();\n\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t}\n\n</SCRIPT>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" \n\tonblur=(window.focus()) \n\tonload=\"sierra();\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"99%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Presente</FONT></TD>\n\t\t\t<TD colspan=\"3\" width=\"660\">\n\t\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\" colspan=\"4\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\" colspan=\"4\" align=\"justify\">Por&nbsp;medio de la presente manifiesto que el asunto\n\t\t\t<b>".toCharArray();
    __oracle_jsp_text[11] = 
    "</b><BR>con el Número de folio <b>".toCharArray();
    __oracle_jsp_text[12] = 
    " </b>ya ha sido terminado.<BR>\n\t\t\t<BR>A continuación se detalla el historial de las respuestas hacia la solicitud:<BR>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\" colspan=\"4\">&nbsp;</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t<tr>\n\t\t<TD>\n\t\t\t<DIV align=\"left\">\n\t\t\t<FONT face=\"Verdana\" color=\"#000000\" size=\"1\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t</FONT>\n\t\t\t</DIV>\n\t\t</TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<TD>\n\t\t\t\t<TABLE>\n\t\t\t\t<TBODY>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TD>\n\t\t\t\t\t\t<TD>".toCharArray();
    __oracle_jsp_text[20] = 
    "</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t\t</TD>\n\t\t</tr>\n\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t</TBODY>\n</TABLE>\n</DIV>\n<TABLE align=\"center\">\n\t\t<tr align=\"center\">\n\t\t\t<TD align=\"center\">\n\t\t\t\t<INPUT type=\"button\" value=\"Enviar\" name=\"Enviar\" onclick=\"enviar()\">\n\t\t\t\t<INPUT type=\"button\" value=\"Cancelar\" name=\"Cancelar\" onClick=\"javascript:window.close();\">\n\t\t\t</TD>\n\t\t</tr>\n</TABLE>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
