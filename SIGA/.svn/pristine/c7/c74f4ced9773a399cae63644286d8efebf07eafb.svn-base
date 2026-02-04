package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.reportes.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.taglib.*;


public class _ComentarioCiudadano extends com.orionserver.http.OrionHttpJspPage {


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
    _ComentarioCiudadano page = this;
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
      
      	String strIdComentario	=	"";
      	String strIdAsunto		=	"";
      	String strComentario	=	"";
      	String strFecha			=	"";
      	String strAccion		=	"";
      	String stridRespuest	=	"";
      	String strEstatus		=	"";
      	boolean bInsertar		=	false;
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      	java.util.Date f 				=	new java.util.Date();
      	strFecha		 				=	sdf.format(f);
      	
      	strAccion	=	request.getParameter("accion");
      	strIdAsunto	=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
      	if(strAccion != null && strAccion.equals("guardar"))
      	{
      		strComentario	=	request.getParameter("Comentario1");
      		strIdAsunto		=	request.getParameter("id_asunto");
      		stridRespuest	=	request.getParameter("tipoRespuesta");
      		strEstatus		=	request.getParameter("estatus");
      		String strCerrar = "0";
      		if(ActualizaCiudadano.getExistenNotificaciones(strIdAsunto)){
      			String strIdNotDesctivar = ActualizaCiudadano.getNotificacionDesacticar(strIdAsunto);
      			boolean bActualizaActiva = ActualizaCiudadano.actualizaActivarNuevaNot(strIdNotDesctivar);
      		}
      
      		boolean bCerrar = false;
      		bCerrar = ActualizaEstatus.getCierre(strEstatus);
      		if(bCerrar){
      			strCerrar = "1";
      		}
      		int i = 1;
      		boolean bInser	=	ActualizaCiudadano.insertarNotificacion(strComentario, strIdAsunto, BUsuario.getNombre(), 
      																BUsuario.getCorreo(), strFecha, stridRespuest, strEstatus, strCerrar, "1", i); 
      		try{
      			response.sendRedirect("AsuntoTurnado.jsp?id_asunto="+strIdAsunto);
      		}catch(java.io.IOException io){
      			//System.out.println("Erro-->"+io);
      		}
      	}
      
      out.write(__oracle_jsp_text[5]);
      out.print( strIdAsunto );
      out.write(__oracle_jsp_text[6]);
      out.print( strIdAsunto );
      out.write(__oracle_jsp_text[7]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getTipoRespuestaCombo());
        __jsp_taghandler_1.setName("tipoRespuesta");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected("");
        __jsp_taghandler_1.setClassHtml("blue500");
        __jsp_taghandler_1.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_1.setTextoNoSeleccion("-- Selecciona Tipo de Respuesta --");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[8]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getEstatusCombo());
        __jsp_taghandler_2.setName("estatus");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected("");
        __jsp_taghandler_2.setClassHtml("blue500");
        __jsp_taghandler_2.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_2.setTextoNoSeleccion("-- Selecciona el Estatus --");
        __jsp_taghandler_2.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[9]);

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
  private static final char __oracle_jsp_text[][]=new char[10][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Comentario Ciudadano</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n\t\n\tfunction regresar(){\n\t\tlocation.assign('AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[6] = 
    "');\n\t}\n\t\n\tfunction guardar(){\t\n\t\tdoc = document.comentarioUCT;\n\t\tvalida = 0;\n\t\tmsg=\"\";\n\n\t\tif (doc.tipoRespuesta[doc.tipoRespuesta.selectedIndex].value == -1) {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \"- Debes seleccionar un tipo de Respuesta\t\"+ \"\\n\";\n\t\t}\n\t\tif (doc.estatus[doc.estatus.selectedIndex].value == -1) {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \"- Debes seleccionar un Estatus para la Respuesta\t\"+ \"\\n\";\n\t\t}\n\t\tif (doc.Comentario1.value == \"\") {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \"- Debe capturar un comentario para la Delegación\t\"+ \"\\n\";\n\t\t}\n\t\tif (valida == 1) \n\t\t{\n\t\t\talert(msg);\n\t\t} \n\t\tif (valida != 1)\n\t\t{\n\t\t\tdoc.accion.value=\"guardar\";\n\t\t\tdoc.submit();\n\t\t}\n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"ComentarioCiudadano.jsp\" name=\"comentarioUCT\" method=\"post\">\n<INPUT type=\"hidden\" value=\"guardar\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\" name=\"id_asunto\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\" colspan=\"2\">\n\t\t\t\t<INPUT class=\"blue100\" onclick=\"regresar()\" type=\"button\" value=\"Cancelar\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<INPUT class=\"blue100\" onclick=\"guardar()\" type=\"button\" value=\"Aceptar\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"672\" bgcolor=\"#00204f\" colspan=\"4\"><FONT size=\"0\"></FONT></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Tipo de Respuesta:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Estatus a la Respuesta:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Comentarios:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t<TEXTAREA cols=\"50\" rows=\"5\" class=\"blue500\" name=\"Comentario1\"></TEXTAREA>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
