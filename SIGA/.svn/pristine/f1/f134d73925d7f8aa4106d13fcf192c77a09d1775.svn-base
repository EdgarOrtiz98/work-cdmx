package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.ActualizaArea;


public class _headerC extends com.orionserver.http.OrionHttpJspPage {


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
    _headerC page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      
      	boolean bRolUserAdmon;
      	boolean bRolUserSuper;
      	UsuarioBean BUsuarioCat = (UsuarioBean) session
      			.getAttribute("UsuarioBean");
      
      	if (BUsuarioCat == null) {
      	} else {
      
      		bRolUserSuper = BUsuarioCat.getSupervisor();
      		bRolUserAdmon = BUsuarioCat.getAdmon();
      		String strImagen = application.getInitParameter("Imagen");
      		String strFolio = "HelpSIGA";
      		String strManual = "manual_siga.pdf";
      		String strFqa = "fqa_siga.pdf";
      
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.print(strFolio );
      out.write(__oracle_jsp_text[3]);
      out.print(strManual );
      out.write(__oracle_jsp_text[4]);
      out.print(strFolio );
      out.write(__oracle_jsp_text[5]);
      out.print(strFqa );
      out.write(__oracle_jsp_text[6]);
      out.print(ActualizaArea.getNombreArea(BUsuarioCat.getIdArea()));
      out.write(__oracle_jsp_text[7]);
      
      						if (bRolUserAdmon == true) {
      						
      out.write(__oracle_jsp_text[8]);
      
      						}
      						
      out.write(__oracle_jsp_text[9]);
      
      						if (bRolUserSuper == true) {
      						
      out.write(__oracle_jsp_text[10]);
      
      						}
      						
      out.write(__oracle_jsp_text[11]);
      
      						if (bRolUserAdmon == true) {
      						
      out.write(__oracle_jsp_text[12]);
      
      						}
      						
      out.write(__oracle_jsp_text[13]);
      out.print(BUsuarioCat.getCargo());
      out.write(__oracle_jsp_text[14]);
      out.print(BUsuarioCat.getNombre());
      out.write(__oracle_jsp_text[15]);
      
      }
      
      out.write(__oracle_jsp_text[16]);

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
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HEAD>\n<SCRIPT type=\"text/javascript\">\n</SCRIPT>\n</HEAD>\n<META http-equiv=Content-Type content=\"text/html; charset=utf-8\">\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/link.css\" />\n<script type=\"text/javascript\" src=\"../js/link.js\">\n\n</script>\n<STYLE type=text/css>\nBODY {\n\tMARGIN: 0px\n}\n</STYLE>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<TABLE cellSpacing=0 cellPadding=0 width=\"100%\" border=0>\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD background=../Imagenes/h1.jpg colspan=\"2\">\n\t\t\t<TABLE cellSpacing=0 cellPadding=0 width=0 align=right border=0>\n\t\t\t\t<TBODY>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD><A onmouseover=\"dropdownmenu(this, event, 'menuHelp')\">\n\t\t\t\t\t\t<IMG height=17 src=\"../Imagenes/L2b1_ayu.jpg\" width=75 border=0\n\t\t\t\t\t\t\tname=Image18> </A>\n\t\t\t\t\t\t<div id=\"menuHelp\" class=\"anylinkcssHelp\"\n\t\t\t\t\t\t\tstyle=\"width: 65px; background-color: lightblue\"><a\n\t\t\t\t\t\t\thref=\"../DownLoadDicument?fol=".toCharArray();
    __oracle_jsp_text[3] = 
    "&name=".toCharArray();
    __oracle_jsp_text[4] = 
    "\"\n\t\t\t\t\t\t\ttarget=\"_blank\">Manual</a> <a\n\t\t\t\t\t\t\thref=\"../DownLoadDicument?fol=".toCharArray();
    __oracle_jsp_text[5] = 
    "&name=".toCharArray();
    __oracle_jsp_text[6] = 
    "\"\n\t\t\t\t\t\t\ttarget=\"_blank\">F.A.Q.</a></div>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD><A\n\t\t\t\t\t\t\tonmouseover=\"MM_swapImage('Image20','','../Imagenes/b1_sal.jpg',1)\"\n\t\t\t\t\t\t\tonmouseout=MM_swapImgRestore() href=\"index.jsp\" target=\"_top\">\n\t\t\t\t\t\t<IMG height=17 src=\"../Imagenes/b1_sal.jpg\" width=68 border=0\n\t\t\t\t\t\t\tname=Image20> </A></TD>\n\t\t\t\t\t</TR>\n\t\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD background=../Imagenes/fon_head_shcp.jpg>\n               <IMG height=20 src=\"../Imagenes/header_shcp.jpg\" width=771>\n            </TD>\n\t\t\t<TD align=\"right\" background=../Imagenes/fon_head_shcp.jpg>\n\t\t\t   <B style=\"color: white;\">".toCharArray();
    __oracle_jsp_text[7] = 
    "&nbsp;&nbsp;&nbsp;</B>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD background=../Imagenes/h2.jpg colspan=\"2\">\n\t\t\t<TABLE cellSpacing=0 cellPadding=0 width=0 border=0>\n\t\t\t\t<TBODY>\n\t\t\t\t\t<TR id=\"TablaUno\">\n\t\t\t\t\t\t<TD><A\n\t\t\t\t\t\t\tonmouseover=\"MM_swapImage('Image49','','../Imagenes/b_inicio.jpg',0)\"\n\t\t\t\t\t\t\tonmouseout=MM_swapImgRestore() href=\"portalPrincipal.jsp\"> <IMG\n\t\t\t\t\t\t\theight=24 src=\"../Imagenes/b_inicio.jpg\" width=62 border=0\n\t\t\t\t\t\t\tname=Image49> </A></TD>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\t\t\t\t\t<TD><A\n\t\t\t\t\t\t\tonmouseover=\"dropdownmenu(this, event, 'anylinkmenu6')\"> <IMG\n\t\t\t\t\t\t\theight=24 src=\"../Imagenes/b_cat.gif\" width=84 border=0\n\t\t\t\t\t\t\tname=Image30> </A>\n\t\t\t\t\t\t<div id=\"anylinkmenu6\" class=\"anylinkcss\"\n\t\t\t\t\t\t\tstyle=\"width: 155px; background-color: lightblue\"><a\n\t\t\t\t\t\t\thref=\"Archivado.jsp\">Archivado</a> <a href=\"AreaView.jsp\">Unidades\n\t\t\t\t\t\tAdministrativas</a> <a href=\"UsuariosView.jsp\">Puestos</a> <a\n\t\t\t\t\t\t\thref=\"EntidadView.jsp\">Entidades</a> <a href=\"RemitenteView.jsp\">Remitentes</a>\n\t\t\t\t\t\t<a href=\"tramitesView.jsp\">Tramites</a> <a\n\t\t\t\t\t\t\thref=\"TipoDocumentoView.jsp\">Tipo de Documentos</a> <a\n\t\t\t\t\t\t\thref=\"TipoAsuntoView.jsp\">Tipo de Asuntos</a> <a\n\t\t\t\t\t\t\thref=\"PrioridadesView.jsp\">Prioridades</a> <a\n\t\t\t\t\t\t\thref=\"FoliosView.jsp\">Folios</a> <a href=\"PasosView.jsp\">Pasos</a>\n\t\t\t\t\t\t<a href=\"InstruccionesView.jsp\">Instrucciones</a> <a\n\t\t\t\t\t\t\thref=\"RazonesRechazoView.jsp\">Razones de Rechazo</a> <a\n\t\t\t\t\t\t\thref=\"DiasFestivosView.jsp\">Días Festivos</a> <!--\t\t\t\t\t\t<a href=\"CargarSisi.jsp\">Cargar Sisi</a> -->\n\t\t\t\t\t\t<a href=\"Configuraciones.jsp\">Configuracion SIGA</a>\n\t\t\t\t\t\t<a href=\"ma1.jsp?casuntos=1\">Migrar Content</a></div>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t\t\t\t<TD><A\n\t\t\t\t\t\t\tonmouseover=\"dropdownmenu(this, event, 'anylinkmenu6')\"> <IMG\n\t\t\t\t\t\t\theight=24 src=\"../Imagenes/b_cat.gif\" width=84 border=0\n\t\t\t\t\t\t\tname=Image30> </A>\n\t\t\t\t\t\t<div id=\"anylinkmenu6\" class=\"anylinkcss\"\n\t\t\t\t\t\t\tstyle=\"width: 155px; background-color: lightblue\"><a\n\t\t\t\t\t\t\thref=\"Archivado.jsp\">Archivado</a> <a href=\"AreaView.jsp\">Unidad\n\t\t\t\t\t\tAdministrativa</a> <a href=\"UsuariosView.jsp\">Puestos</a> <a\n\t\t\t\t\t\t\thref=\"EntidadView.jsp\">Entidades</a> <a href=\"RemitenteView.jsp\">Remitentes</a>\n\t\t\t\t\t\t<a href=\"tramitesView.jsp\">Tramites</a> <a\n\t\t\t\t\t\t\thref=\"TipoDocumentoView.jsp\">Tipo de Documentos</a> <a\n\t\t\t\t\t\t\thref=\"FoliosView.jsp\">Folios</a></div>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t\t\t\t<TD><A href=\"../parametros.siga?accion=mostrarParametros\">\n\t\t\t\t\t\t<IMG height=24 src=\"../Imagenes/b_param.JPG\" width=89 border=0\n\t\t\t\t\t\t\tname=Image16> </A></TD>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t\t\t\t <TD align=\"right\" width=\"100%\">\n\t\t\t\t\t\t    <b>Bienvenido: ".toCharArray();
    __oracle_jsp_text[14] = 
    " / ".toCharArray();
    __oracle_jsp_text[15] = 
    "&nbsp;&nbsp;&nbsp;</b>\n\t\t\t\t\t\t </TD>\n\t\t\t\t\t</TR>\n\t\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
