package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;


public class _Configuraciones extends com.orionserver.http.OrionHttpJspPage {


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
    _Configuraciones page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("headerC.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp);
      		}catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
      	}
      
      
      out.write(__oracle_jsp_text[3]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[4]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[5]);
       } 
      out.write(__oracle_jsp_text[6]);
       if(!BUsuario.getAdmon()){ 
      out.write(__oracle_jsp_text[7]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[8]);
       } 
      out.write(__oracle_jsp_text[9]);
      
      	String strDuracion 	= 	"10";
      	String strAmarillo 	= 	"";
      	String strIdConf 	=	"";
      	String strRegistros =	"";
      	String strPaginas	=	"";
      	String strDatos[][] =	null;
      	String strAccion = request.getParameter("accion");
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      	java.util.Date f 				=	new java.util.Date();
      	String strFechaCreacion			=	sdf.format(f);
      
      	boolean bActualizar = false;
      	
      	strDatos = ActualizaConfiguracion.getDatosConf();
      	if(strDatos != null && strDatos.length > 0){
      		strIdConf 		= strDatos[0][0];
      		strDuracion 	= strDatos[0][1];
      		strAmarillo 	= strDatos[0][2];
      		strRegistros 	= strDatos[0][3];
      		strPaginas 		= strDatos[0][4];
      	}
      	
      	if(strAccion != null && strAccion.equals("guardar")){
      		strDuracion = request.getParameter("confDuracion");
      		strAmarillo = request.getParameter("confAmarillo");
      		strRegistros = request.getParameter("registros");
      		strPaginas = request.getParameter("paginas");
      		bActualizar = ActualizaConfiguracion.getInsertaConf(strDuracion, strAmarillo, strFechaCreacion, strRegistros, strPaginas);
      		boolean bBitacora = ActualizaBitacora.InsertarEventoModificaConfig(BUsuario.getIdUsuario(),strDuracion,strAmarillo);
      		try{
      			response.sendRedirect("UsuariosView.jsp");
      		}catch(java.io.IOException io){
      			//System.err.println("Error redireccion->"+io);
      		}
      	}
      	if(strAccion != null && strAccion.equals("cambiar")){
      		strDuracion = request.getParameter("confDuracion");
      		strAmarillo = request.getParameter("confAmarillo");
      		strRegistros = request.getParameter("registros");
      		strPaginas = request.getParameter("paginas");
      		strIdConf	= request.getParameter("id_conf");
      		bActualizar = ActualizaConfiguracion.getUpdateConf(strDuracion, strAmarillo, strIdConf, strFechaCreacion, strRegistros, strPaginas);
      		boolean bBitacora = ActualizaBitacora.InsertarEventoModificaConfig(BUsuario.getIdUsuario(),strDuracion,strAmarillo);
      		try{
      			response.sendRedirect("UsuariosView.jsp");
      		}catch(java.io.IOException io){
      			//System.err.println("Error redireccion->"+io);
      		}
      	}
      	
      
      out.write(__oracle_jsp_text[10]);
      out.print(strIdConf);
      out.write(__oracle_jsp_text[11]);
      out.print(strDuracion);
      out.write(__oracle_jsp_text[12]);
      out.print(strAmarillo);
      out.write(__oracle_jsp_text[13]);
      out.print(strRegistros);
      out.write(__oracle_jsp_text[14]);
      out.print(strPaginas);
      out.write(__oracle_jsp_text[15]);

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
  private static final char __oracle_jsp_text[][]=new char[16][];
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
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<TITLE>Configuraciones</TITLE>\n<script type=\"text/javascript\">\n<!--\n\n//-->\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0; timer_load();\" \n\tonKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM name=\"confForm\" action=\"Configuraciones.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\" name=\"id_conf\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"99%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><A href=\"../jsp/UsuariosView.jsp\"> <IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"> </A>\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\t\t\t\n\t\t\t\t<a onclick=\"guardarConf()\">\n\t\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\">\n\t\t\t\t</a>\n\t\t\t\t</TD>\n\t\t\t<TD width=\"125\">\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"48\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\" colspan=\"2\" class=\"etiquetas1v\"><B><FONT face=\"Verdana\" color=\"#004080\"\n\t\t\t\tsize=\"2\"></FONT><FONT size=\"+1\"><B>Configuraciones</B></FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"672\" bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR VALIGN=top>\n\t\t\t\n\t\t\t<TD width=\"672\">\n\t\t\t\t<FIELDSET dir=\"ltr\">\n\t\t\t\t<LEGEND align=\"left\"><FONT SIZE=2 FACE=\"Verdana\">Semaforización</FONT></LEGEND>\t\n\t\t\t\t<TABLE>\n\t\t\t\t\t<TBODY>\n\t\t\t\t\t\t<TR>        \n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t\tNo. de Días de caducidad de un Asunto:&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<INPUT name=\"confDuracion\" type=\"text\" class=\"blue50\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" onKeyPress='AceptaSoloTeclaNumericaYPunto();'>\n\t\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD>&nbsp;</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t\tsemáforo Amarillo:&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<INPUT name=\"confAmarillo\" type=\"text\" class=\"blue50\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" onKeyPress='AceptaSoloTeclaNumericaYPunto();'>%\n\t\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD>&nbsp;</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t</TBODY>\n\t\t\t\t</TABLE>\n\t\t\t</FIELDSET>\n\t\t</TD>\n\t</TR>\n\t\t<TR VALIGN=top>\n\t\t\t\n\t\t\t<TD width=\"672\">\n\t\t\t\t<FIELDSET dir=\"ltr\">\n\t\t\t\t<LEGEND align=\"left\"><FONT SIZE=2 FACE=\"Verdana\">Paginación</FONT></LEGEND>\t\n\t\t\t\t<TABLE>\n\t\t\t\t\t<TBODY>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t\t<BR>Registros por página:&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<INPUT name=\"registros\" type=\"text\" class=\"blue50\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" onKeyPress='AceptaSoloTeclaNumerica();'>\n\t\t\t\t\t\t\t<BR>páginas por pantalla:&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<INPUT name=\"paginas\" type=\"text\" class=\"blue50\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" onKeyPress='AceptaSoloTeclaNumerica();'>\n\t\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD>&nbsp;</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t</TBODY>\n\t\t\t\t</TABLE>\n\t\t\t</FIELDSET>\n\t\t</TD>\n\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
