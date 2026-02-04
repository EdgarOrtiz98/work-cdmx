package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.reportes.*;
import com.meve.sigma.util.*;


public class _portalPrincipal__new extends com.orionserver.http.OrionHttpJspPage {


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
    _portalPrincipal__new page = this;
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
      
      			UsuarioBean BUsuario = (UsuarioBean) session
      			.getAttribute("UsuarioBean");
      
      	String strTmp = request.getRequestURI();
      	strTmp = strTmp.substring(strTmp.indexOf('/', 2) + 5, strTmp
      			.length());
      
      	if (BUsuario == null) {
      		response.sendRedirect("index.jsp?pagina=" + strTmp);
      	} else if ((BUsuario.getAtencion() || BUsuario.getAsistente())
      			&& !(BUsuario.getTurnado() || BUsuario.getSupervisor() || BUsuario
      			.getRecepcion())) {
      		response.sendRedirect("PortalAtender.jsp");
      	} else if (BUsuario.getAdmon()) {
      		response.sendRedirect("UsuariosView.jsp");
      	}
      
      out.write(__oracle_jsp_text[4]);
      
      					if (BUsuario.getTurnado() || BUsuario.getRecepcion()
      					|| BUsuario.getSupervisor()) {
      		
      out.write(__oracle_jsp_text[5]);
      
      		if (BUsuario.getAtencion()) {
      		
      out.write(__oracle_jsp_text[6]);
      
      		} else {
      		
      out.write(__oracle_jsp_text[7]);
      
      		}
      		
      out.write(__oracle_jsp_text[8]);
      
      		} else if (BUsuario.getAtencion()) {
      		
      out.write(__oracle_jsp_text[9]);
      
      		} else if (BUsuario.getAsistente()) {
      		
      out.write(__oracle_jsp_text[10]);
      
      		}
      		
      out.write(__oracle_jsp_text[11]);

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
  private static final char __oracle_jsp_text[][]=new char[12][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n\n<html>\n<head>\n<TITLE>Asuntos por Turnar</TITLE>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n<link rel=\"stylesheet\" href=\"../css/menu.css\" type=\"text/css\">\n<META HTTP-EQUIV=\"Pragma\" CONTENT=\"no-cache\">\n<META HTTP-EQUIV=\"Expires\" CONTENT=\"-1\">\n</head>\n<body background=\"../Imagenes/fondo_claro.jpg\" onLoad=\"timer_load()\"\n\tonKeyPress=\"timer_reload()\" onClick=\"timer_reload()\" margin=\"0px\">\n\n<table cellspacing=\"0\" cellpadding=\"0\">\n\t<TR>\n\t\t<TD class=\"etiquetas\">\n\t\t</TD>\n\t</TR>\n</table>\n\n<table cellspacing=\"2\" cellpadding=\"2\">\n\t<tr>\n\t\t".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAtencion()\";>Asuntos\n\t\ten Recepción</a></td>\n\t\t<td class=\"dominoSelTopTab\" bgcolor=\"#004080\"><a\n\t\t\tonclick=\"goAsuntos()\";>Asuntos por turnar</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAsuntosTr()\";>Asuntos\n\t\ten Trámite</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAsuntosTer()\";>Asuntos\n\t\tterminados</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[6] = 
    "\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goAtender()\";>Instrucciones\n\t\tpor atender</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goTramite()\";>Instrucciones\n\t\ten Trámite</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goTerminadas()\";>Instrucciones\n\t\tterminadas</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goRechazadas()\";>Instrucciones\n\t\trechazadas</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goRechazadas()\";>Instrucciones\n\t\trechazadas</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t<td class=\"dominoSelTopTab\" bgcolor=\"#004080\"><a\n\t\t\tonclick=\"goAtender()\";>Instrucciones por atender</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goTramite()\";>Instrucciones\n\t\ten Trámite</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goTerminadas()\";>Instrucciones\n\t\tterminadas</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goRechazadas()\";>Instrucciones\n\t\trechazadas</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t<td class=\"dominoSelTopTab\" bgcolor=\"#004080\"><a\n\t\t\tonclick=\"goAtender()\";>Instrucciones por atender</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goTramite()\";>Instrucciones\n\t\ten Trámite</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goTerminadas()\";>Instrucciones\n\t\tterminadas</a></td>\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goRechazadas()\";>Instrucciones\n\t\trechazadas</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t<td class=\"dominoTopTab\"><a onclick=\"goSolicitada()\";>Asuntos\n\t\tSolicitados</a></td>\n\t</tr>\n</table>\n</body>\n</html>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
