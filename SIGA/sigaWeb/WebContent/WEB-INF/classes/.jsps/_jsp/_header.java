package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.ActualizaArea;


public class _header extends com.orionserver.http.OrionHttpJspPage {


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
    _header page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      
      UsuarioBean BUsuarioheader = (UsuarioBean)session.getAttribute("UsuarioBean");
      boolean bAtencion = false;
      if(BUsuarioheader==null){
      }else{
      	if((BUsuarioheader.getAtencion() || BUsuarioheader.getAsistente()) && !(BUsuarioheader.getTurnado() ||	BUsuarioheader.getRecepcion() ||BUsuarioheader.getSupervisor()))
      		bAtencion = true;
      
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
       if ((BUsuarioheader.getAdmon()) || (BUsuarioheader.getSupervisor()) ) { 
      out.write(__oracle_jsp_text[3]);
      }
      out.write(__oracle_jsp_text[4]);
      out.print(ActualizaArea.getNombreArea(BUsuarioheader.getIdArea()));
      out.write(__oracle_jsp_text[5]);
      if(!bAtencion){
                          if(BUsuarioheader.getRecepcion()||BUsuarioheader.getTurnado()){
      out.write(__oracle_jsp_text[6]);
      }
      out.write(__oracle_jsp_text[7]);
      }
      out.write(__oracle_jsp_text[8]);
      if(BUsuarioheader.getTurnado()){ 
      out.write(__oracle_jsp_text[9]);
      }else{ 
      out.write(__oracle_jsp_text[10]);
      } 
      out.write(__oracle_jsp_text[11]);
      if(BUsuarioheader.getAtencion()||BUsuarioheader.getAsistente()){ 
      out.write(__oracle_jsp_text[12]);
      }else{ 
      out.write(__oracle_jsp_text[13]);
      } 
      out.write(__oracle_jsp_text[14]);
      out.print(BUsuarioheader.getCargo());
      out.write(__oracle_jsp_text[15]);
      out.print(BUsuarioheader.getNombre());
      out.write(__oracle_jsp_text[16]);
      }

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
  private static final char __oracle_jsp_text[][]=new char[17][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<META http-equiv=Content-Type content=\"text/html; charset=utf-8\">\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/link.css\" />\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/link.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n\n<TABLE cellSpacing=0 cellPadding=0 width=\"100%\" border=0>\n    <TR>\n    \t<TD background=../Imagenes/L2h1.jpg colspan=\"2\">\n            <TABLE cellSpacing=0 cellPadding=0 width=0 align=right border=0>\n        \t<TR>        \t\n                    ".toCharArray();
    __oracle_jsp_text[3] = 
    "\n                    <TD>    \n                        <A onmouseover=\"MM_swapImage('Image19','','../Imagenes/L2b1_conf.jpg',1)\" \n            \t\t   onmouseout=MM_swapImgRestore() \n                           href=\"UsuariosView.jsp\">\n                           <IMG height=17 src=\"../Imagenes/L2b1_conf.jpg\" width=123 border=0 name=Image19>\n                        </A>\n                    </TD>\n                    ".toCharArray();
    __oracle_jsp_text[4] = 
    "\n                    <TD>\n\t\t\t<A onmouseover=\"dropdownmenu(this, event, 'menuHelp')\">\n                        \t<IMG height=17 src=\"../Imagenes/L2b1_ayu.jpg\" width=75 border=0 name=Image18>\n                        </A> \n                        <div id=\"menuHelp\" class=\"anylinkcssHelp\" style=\"width: 65px; background-color: lightblue\">\n                                <a href=\"../DownLoadDicument?fol=HelpSIGA&name=manual_siga.pdf\" target=\"_blank\" >Manual</a>\t\t\t\t\t\t\t\t\t\t\t\t\n                                <a href=\"../DownLoadDicument?fol=HelpSIGA&name=fqa_siga.pdf\" target=\"_blank\" >F.A.Q.</a>\n                        </div>             \n                    </TD>\n                    <TD>\n                        <A onmouseover=\"MM_swapImage('Image20','','../Imagenes/L2b1_sal.jpg',1)\" \n                            onmouseout=MM_swapImgRestore() \n                            href=\"estructuraGestion.jsp\" target=\"_top\">\n                            <IMG src=\"../Imagenes/b1_estruct.jpg\" border=0 name=Image20>\n                        </A>\n                    </TD>\n                    <TD>\n                        <A onmouseover=\"MM_swapImage('Image20','','../Imagenes/L2b1_sal.jpg',1)\" \n                            onmouseout=MM_swapImgRestore() \n                            href=\"index.jsp\" target=\"_top\">\n                            <IMG height=17 src=\"../Imagenes/L2b1_sal.jpg\" width=68 border=0 name=Image20>\n                        </A>\n                    </TD>\n                </TR>\n            </TABLE>\n        </TD>\n    </TR>\n    <TR>\n        <TD background=../Imagenes/fon_head_shcp.jpg>\n            <IMG height=20 src=\"../Imagenes/header_shcp.jpg\" width=771>\n        </TD>\n        <TD align=\"right\"  background=../Imagenes/fon_head_shcp.jpg>\n           <B style=\"color: white; size: 11px;\">".toCharArray();
    __oracle_jsp_text[5] = 
    "&nbsp;&nbsp;&nbsp;</B>\n        </TD>\n    </TR>\n    <TR>\n    \t<TD background=../Imagenes/L2h2.jpg colspan=\"2\">\n            <TABLE cellSpacing=0 cellPadding=0 width=0 border=0>\n        \t<TR>\n                    <TD>\n                        <IMG height=21 src=\"../Imagenes/L2b_ini.jpg\" width=12>\n                    </TD>\n                    <TD>\n                        <A onmouseover=\"MM_swapImage('Image50','','../Imagenes/b_inicio.jpg',0)\" \n                            onmouseout=MM_swapImgRestore() \n                            href=\"portalPrincipal.jsp\">\n                            <IMG height=24 src=\"../Imagenes/b_inicio.jpg\" width=62 border=0 name=Image50>\n                        </A>\n                    </TD>\n                    ".toCharArray();
    __oracle_jsp_text[6] = 
    "\n                    <TD>\n                        <A onmouseover=\"MM_swapImage('Image51','','../Imagenes/b_nue_asu.gif',0)\" \n                            onmouseout=MM_swapImgRestore() \n                            href=\"Asuntos.jsp\"> \n                            <IMG height=24 src=\"../Imagenes/b_nue_asu.gif\" width=106 border=0 name=Image51>\n                        </A>\n                    </TD>\n                    ".toCharArray();
    __oracle_jsp_text[7] = 
    "\n                    ".toCharArray();
    __oracle_jsp_text[8] = 
    "\n                    <TD>\n                        <A onmouseover=\"dropdownmenu(this, event, 'anylinkmenu6')\">\n                            <IMG height=24 src=\"../Imagenes/b_bus.jpg\" width=89 border=0 name=Image16>\n                        </A>\n                        <div id=\"anylinkmenu6\" class=\"anylinkcss\" style=\"width: 155px; background-color: lightblue\">\n                            <a href=\"Buscar.jsp\">Buscar por instrucción</a>\n           \n                            <a href=\"BuscarCampo.jsp\">Buscar por Asunto</a>\n \n                            <a href=\"rastreoRuta.jsp\">Trayectoria de Asunto</a>\n                        </div>             \n                    </TD>\n                     <TD>\n                        <A onmouseover=\"dropdownmenu(this, event, 'menuReporte')\">\n                            <IMG height=24 src=\"../Imagenes/b_rep.jpg\" width=89 border=0 name=Image16>\n                        </A>\n                         <div id=\"menuReporte\" class=\"anylinkcss\" style=\"width: 155px; background-color: lightblue\">\n                            ".toCharArray();
    __oracle_jsp_text[9] = 
    "\n                               <a href=\"../reporteador.siga?accion=mostrarAsuntos\">Reporte de Asuntos</a>\n                            ".toCharArray();
    __oracle_jsp_text[10] = 
    "\n                            <a style=\"color: gray\">Reporte de Asuntos</a>\n                            ".toCharArray();
    __oracle_jsp_text[11] = 
    "\n                            ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n                            <a href=\"../reporteador.siga?accion=mostrarInstrucciones\">Reporte de Instrucciones</a>\n                            ".toCharArray();
    __oracle_jsp_text[13] = 
    "\n                            <a style=\"color: gray\">Reporte de Instrucciones</a>\n                            ".toCharArray();
    __oracle_jsp_text[14] = 
    "\n                        </div>            \n                    </TD>\n                    <TD align=\"right\" width=\"100%\">\n                       <b style=\"size: 11px;\">Bienvenido: ".toCharArray();
    __oracle_jsp_text[15] = 
    " / ".toCharArray();
    __oracle_jsp_text[16] = 
    "&nbsp;&nbsp;&nbsp;</b>\n                    </TD>\n                </TR>\n            </TABLE>\n        </TD>\n    </TR>\n</TABLE>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
