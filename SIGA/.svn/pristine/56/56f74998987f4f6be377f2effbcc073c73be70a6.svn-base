package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _RecepcionFechaV extends com.orionserver.http.OrionHttpJspPage {


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
    _RecepcionFechaV page = this;
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
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
      	}	
      
      
      out.write(__oracle_jsp_text[4]);
      
      	boolean bMostrar	=	true;
      	boolean bExiste		=	true;
      
      	bExiste		=	ActualizaAsunto.getExistenAsuntos(BUsuario.getIdArea(), BUsuario.getIdUsuario());
      	//String strAccion	=	"";
      	//strAccion			=	request.getParameter("mostrar");
      	
      	//if(strAccion !=null && strAccion.equals("true"))
      	//{
      	//	bMostrar	=	true;
      	//}
      
      out.write(__oracle_jsp_text[5]);
       if(bExiste){ 
      out.write(__oracle_jsp_text[6]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaAsunto.AsuntosPorFechaRV());
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
            out.print((bMostrar)?"collapse.gif":"expand.gif");
            out.write(__oracle_jsp_text[8]);
            out.print((bMostrar)?"Hide":"Show");
            out.write(__oracle_jsp_text[9]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[10]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[11]);
            if(bMostrar)
            	  		{ 
            		
            out.write(__oracle_jsp_text[12]);
            {
              com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_2=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setDatos(ActualizaAsunto.getFechaAsuntoRV(campo1));
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
                  out.write(__oracle_jsp_text[13]);
                  out.print( usuario1 );
                  out.write(__oracle_jsp_text[14]);
                  out.print( usuario2 );
                  out.write(__oracle_jsp_text[15]);
                  out.print( usuario3 );
                  out.write(__oracle_jsp_text[16]);
                  out.print( ActualizaRemitente.getNombreRemitente(usuario4) );
                  out.write(__oracle_jsp_text[17]);
                  out.print( usuario5 );
                  out.write(__oracle_jsp_text[18]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[19]);
             
            	  }
            	
            out.write(__oracle_jsp_text[20]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[21]);
       }else{ 
      out.write(__oracle_jsp_text[22]);
       } 
      out.write(__oracle_jsp_text[23]);

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
  private static final char __oracle_jsp_text[][]=new char[24][];
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Recepcion por Fecha</TITLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM name=\"recepcionFechaV\" action=\"RecepcionFechaV.jsp\" method=\"post\">\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='20%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">Folio</font></TD>\n\t\t<TD WIDTH='30%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">Titulo</font></TD>\n\t\t<TD WIDTH='30%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">Solicitante</font></TD>\n\t\t<TD WIDTH='20%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">Estatus</font></TD>\n\t</TR>\n</TABLE>\n<br>\n<table>\n\t".toCharArray();
    __oracle_jsp_text[6] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t\t<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td colspan=\"2\" nowrap onClick=\"document.recepcionFecha.submit();\">\n\t\t\t\t<a name=\"1\"></a> <img\n\t\t\t\t\tsrc=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[8] = 
    "\"\n\t\t\t\t\tborder=\"0\" height=\"16\" width=\"16\"\n\t\t\t\t\talt=\"".toCharArray();
    __oracle_jsp_text[9] = 
    " details for ".toCharArray();
    __oracle_jsp_text[10] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[11] = 
    "</td>\n\t\t\t\t<td width=\"203\"></td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t<td nowrap></td>\n\t\t\t\t\t<td align=\"center\" width=\"19%\"><font size=\"1\" color=\"#000080\"\n\t\t\t\t\t\tface=\"Arial\"> <A href=\"Asuntos.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[14] = 
    "\">".toCharArray();
    __oracle_jsp_text[15] = 
    "</A></font>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td align=\"center\" width=\"19\"><font size=\"1\" color=\"#000080\"\n\t\t\t\t\t\tface=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[16] = 
    " </font></td>\n\t\t\t\t\t<td align=\"center\" width=\"230\"><font size=\"1\" color=\"#000080\"\n\t\t\t\t\t\tface=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t\t</font></td>\n\t\t\t\t\t<td align=\"center\" width=\"116\"><font size=\"1\" color=\"#000080\"\n\t\t\t\t\t\tface=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[18] = 
    " </font></td>\n\t\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t</table>\n\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t<TR>\n\t\t<TD width=\"100%\">\n\t\t<div align=center><FONT face=\"verdana\" size=\"4\">******No Existen\n\t\tAsuntos por Fecha de Vencimiento******</FONT></div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n</table>\n</FORM>\n</BODY>\n\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
