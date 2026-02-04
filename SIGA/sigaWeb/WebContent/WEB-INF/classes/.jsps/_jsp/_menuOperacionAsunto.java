package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.asunto.AsuntoStateMachine;
import com.meve.sigma.util.Estatus;


public class _menuOperacionAsunto extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html");
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
    _menuOperacionAsunto page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      if (AsuntoStateMachine.canChangeStateSolicitud(request,
       			      Estatus.ASU_EN_RECEPCION)) { 
      out.write(__oracle_jsp_text[3]);
      }
      out.write(__oracle_jsp_text[4]);
      if (AsuntoStateMachine.canChangeStateSolicitud(request,
       			      Estatus.ASU_POR_TURNAR)) { 
      out.write(__oracle_jsp_text[5]);
      }
      out.write(__oracle_jsp_text[6]);

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
  private static final char __oracle_jsp_text[][]=new char[7][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"900\">\n\t<TR>\n\t\t<TD align=\"left\">\n\t\t<A onclick=\"if(botonBandera){botonBandera=false; regresarURI();}\" \n\t\t   onMouseOver=\"document.MyImage.src='./Imagenes/NavLeft2.gif'\" \n\t\t   onMouseOut=\"document.MyImage.src='./Imagenes/NavLeft.gif'\">\n\t\t      <IMG border=\"0\" src=\"./Imagenes/NavLeft.gif\" alt=\"Regresar / Cancelar\" name=\"MyImage\">\n\t\t</A>\n \t\t\t".toCharArray();
    __oracle_jsp_text[3] = 
    "\n \t\t\t   <A onclick=\"if(botonBandera){botonBandera=false; guardarAsuntoEnRecepcion();}\" \n\t\t\t\t  onMouseOver=\"document.guardarRepBtn.src='./Imagenes/SaveRecepOff.gif';\" \n\t\t\t\t  onMouseOut=\"document.guardarRepBtn.src='./Imagenes/SaveRecepOn.gif';\">\n\t\t\t\t    <IMG border=\"0\" src=\"./Imagenes/SaveRecepOn.gif\" name=\"guardarRepBtn\" alt=\"Guardar en Recepción\">\n\t\t\t   </A>\n\t\t\t".toCharArray();
    __oracle_jsp_text[4] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[5] = 
    "\n \t\t\t    <A onclick=\"if(botonBandera){botonBandera=false; guardarAsunto();}\" \n\t\t\t\t   onMouseOver=\"document.guardarBtn.src='./Imagenes/Save2.gif';\" \n\t\t\t\t   onMouseOut=\"document.guardarBtn.src='./Imagenes/Save.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"./Imagenes/Save.gif\" alt=\"Guardar para Turnar\" name=\"guardarBtn\">\n\t\t\t\t</A>\n\t\t\t".toCharArray();
    __oracle_jsp_text[6] = 
    "\n\t\t</TD>\n\t</TR>\n</TABLE>\n</DIV>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
