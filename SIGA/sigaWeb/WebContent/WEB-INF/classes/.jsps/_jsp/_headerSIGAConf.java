package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.ActualizaArea;


public class _headerSIGAConf extends com.orionserver.http.OrionHttpJspPage {


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
    _headerSIGAConf page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      
      boolean bRolUserAdmon;
      boolean bRolUserSuper;
      UsuarioBean BUsuarioCat = (UsuarioBean)session.getAttribute("UsuarioBean");
      
      if(BUsuarioCat==null){
      }else{
      		
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
      if (bRolUserAdmon == true){ 
      out.write(__oracle_jsp_text[8]);
      }
      out.write(__oracle_jsp_text[9]);
      if (bRolUserSuper == true){ 
      out.write(__oracle_jsp_text[10]);
      } 
      out.write(__oracle_jsp_text[11]);
      if (bRolUserAdmon == true){ 
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
    "\n<HEAD>\n<SCRIPT type=\"text/javascript\">\n</SCRIPT></HEAD><META http-equiv=Content-Type content=\"text/html; charset=utf-8\">\n<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/link.css\" />\n<script type=\"text/javascript\" src=\"./js/link.js\">\n\n</script> \n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n<script type=\"text/javascript\" src=\"./js/SigmaJS.js\"></script>\n<TABLE cellSpacing=0 cellPadding=0 width=\"100%\" border=0>\n<TBODY>\n  \t<TR>\n    \t<TD background=./Imagenes/h1.jpg colspan=\"2\">\n      \t\t<TABLE cellSpacing=0 cellPadding=0 width=0 align=right border=0>\n        \t<TBODY>\n        \t<TR>\n          \t\t<TD>\n\t\t\t\t\t<A onmouseover=\"dropdownmenu(this, event, 'menuHelp')\">\n\t\t\t\t\t\t<IMG height=17 src=\"./Imagenes/L2b1_ayu.jpg\" width=75 \n            \t\t\tborder=0 name=Image18>\n\t\t\t\t\t</A> \n\t\t\t\t\t<div id=\"menuHelp\" class=\"anylinkcssHelp\" style=\"width: 65px; background-color: lightblue\">\n\t\t\t\t\t\t<a href=\"./DownLoadDicument?fol=".toCharArray();
    __oracle_jsp_text[3] = 
    "&name=".toCharArray();
    __oracle_jsp_text[4] = 
    "\" target=\"_blank\" >Manual</a>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<a href=\"./DownLoadDicument?fol=".toCharArray();
    __oracle_jsp_text[5] = 
    "&name=".toCharArray();
    __oracle_jsp_text[6] = 
    "\" target=\"_blank\" >F.A.Q.</a>\n\t\t\t\t\t</div>             \n            \t</TD>\n          \t\t<TD>\n\t\t\t\t\t<A onmouseover=\"MM_swapImage('Image20','','./Imagenes/b1_sal.jpg',1)\" \n            \t\t\tonmouseout=MM_swapImgRestore() \n            \t\t\thref=\"jsp/index.jsp\" target=\"_top\">\n\t\t\t\t\t<IMG height=17 src=\"./Imagenes/b1_sal.jpg\" width=68 \n            \t\t\tborder=0 name=Image20>\n\t\t\t\t\t</A>\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t</TD>\n\t</TR>\n  \t<TR>\n    \t    <TD background=./Imagenes/fon_head_shcp.jpg> \n               <IMG height=20 src=\"./Imagenes/header_shcp.jpg\" width=771>\n            </TD>\n\t\t    <TD align=\"right\" background=./Imagenes/fon_head_shcp.jpg><B\n\t\t\t\tstyle=\"color: white;\">".toCharArray();
    __oracle_jsp_text[7] = 
    "&nbsp;&nbsp;&nbsp;</B>\n\t\t\t</TD>\n\t</TR>\n  \t<TR>\n    \t<TD background=./Imagenes/h2.jpg colspan=\"2\">\n      \t\t<TABLE cellSpacing=0 cellPadding=0 width=0 border=0>\n        \t<TBODY>\n        \t<TR id=\"TablaUno\">\n\t\t\t\t<TD>\n\t\t\t\t\t<A onmouseover=\"MM_swapImage('Image49','','./Imagenes/b_inicio.jpg',0)\" \n            \t\t\tonmouseout=MM_swapImgRestore() \n            \t\t\thref=\"jsp/portalPrincipal.jsp\">\n\t\t\t\t\t\t<IMG height=24 src=\"./Imagenes/b_inicio.jpg\" width=62 border=0 name=Image49>\n\t\t\t\t\t</A>\n\t\t\t\t</TD>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\t\t\t<TD>\n\t\t\t\t\t<A onmouseover=\"dropdownmenu(this, event, 'anylinkmenu6')\">\n\t\t\t\t\t\t<IMG height=24 src=\"./Imagenes/b_cat.gif\" width=84 border=0 name=Image30>\n\t\t\t\t\t</A>\n\t\t\t\t\t<div id=\"anylinkmenu6\" class=\"anylinkcss\" style=\"width: 155px; background-color: lightblue\">\n\t\t\t\t\t\t<a href=\"./jsp/Archivado.jsp\">Archivado</a>\n\t\t\t\t\t\t<a href=\"./jsp/AreaView.jsp\">Unidades Administrativas</a>\n\t\t\t\t\t\t<a href=\"./jsp/UsuariosView.jsp\">Puestos</a>\n\t\t\t\t\t\t<a href=\"./jsp/EntidadView.jsp\">Entidades</a>\n\t\t\t\t\t\t<a href=\"./jsp/RemitenteView.jsp\">Remitentes</a>\n\t\t\t\t\t\t<a href=\"./jsp/tramitesView.jsp\">Tramites</a>\n\t\t\t\t\t\t<a href=\"./jsp/TipoDocumentoView.jsp\">Tipo de Documentos</a>\n\t\t\t\t\t\t<a href=\"./jsp/TipoAsuntoView.jsp\">Tipo de Asuntos</a>\n\t\t\t\t\t\t<a href=\"./jsp/PrioridadesView.jsp\">Prioridades</a>\n\t\t\t\t\t\t<a href=\"./jsp/FoliosView.jsp\">Folios</a>\n\t\t\t\t\t\t<a href=\"./jsp/PasosView.jsp\">Pasos</a>\n\t\t\t\t\t\t<a href=\"./jsp/InstruccionesView.jsp\">Instrucciones</a>\n\t\t\t\t\t\t<a href=\"./jsp/RazonesRechazoView.jsp\">Razones de Rechazo</a>\n\t\t\t\t\t\t<a href=\"./jsp/DiasFestivosView.jsp\">Días Festivos</a>\n\t\t\t\t\t\t<a href=\"./jsp/Configuraciones.jsp\">Configuracion SIGA</a>\n\t\t\t\t\t\t<a href=\"ma1.jsp\">Migrar Content</a>\n\t\t\t\t\t</div>\n\t\t\t\t</TD>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    " \n\t\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t\t<TD>\n\t\t\t\t\t<A onmouseover=\"dropdownmenu(this, event, 'anylinkmenu6')\">\n\t\t\t\t\t\t<IMG height=24 src=\"./Imagenes/b_cat.gif\" width=84 border=0 name=Image30>\n\t\t\t\t\t</A>\n\t\t\t\t\t<div id=\"anylinkmenu6\" class=\"anylinkcss\" style=\"width: 155px; background-color: lightblue\">\n\t\t\t\t\t\t<a href=\"./jsp/Archivado.jsp\">Archivado</a>\n\t\t\t\t\t\t<a href=\"./jsp/AreaView.jsp\">Unidad Administrativa</a>\n\t\t\t\t\t\t<a href=\"./jsp/UsuariosView.jsp\">Puestos</a>\n\t\t\t\t\t\t<a href=\"./jsp/EntidadView.jsp\">Entidades</a>\n\t\t\t\t\t\t<a href=\"./jsp/RemitenteView.jsp\">Remitentes</a>\n\t\t\t\t\t\t<a href=\"./jsp/ramitesView.jsp\">Tramites</a>\n\t\t\t\t\t\t<a href=\"./jsp/TipoDocumentoView.jsp\">Tipo de Documentos</a>\n\t\t\t\t\t\t<a href=\"./jsp/FoliosView.jsp\">Folios</a>\n\t\t\t\t\t</div>\n\t\t\t\t</TD>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t\t<TD>\n                        <A href=\"./parametros.siga?accion=mostrarParametros\">\n                            <IMG height=24 src=\"./Imagenes/b_param.JPG\" width=89 border=0 name=Image16>\n                        </A> \n                </TD>\n                ".toCharArray();
    __oracle_jsp_text[13] = 
    "\n                 <TD align=\"right\" width=\"100%\">\n\t\t\t\t\t\t    <b>Bienvenido: ".toCharArray();
    __oracle_jsp_text[14] = 
    " / ".toCharArray();
    __oracle_jsp_text[15] = 
    "&nbsp;&nbsp;&nbsp;</b>\n\t\t\t     </TD>\n\t\t\t</TR>\n\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
