package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _Archivado extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


	public static boolean par(int num)
    {
        boolean p = false;
        if (num % 2 == 0) 
        {
            p = true;
        }    
        return p;
    }

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
    _Archivado page = this;
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
      out.write(__oracle_jsp_text[3]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	boolean supervisor	= BUsuario.getSupervisor();
      	boolean admin 		= BUsuario.getAdmon();
      	String 	cat			= BUsuario.getCatArchivado();
      
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
      
      	boolean bExiste			=	false;
      	boolean bOperacion		=	false;
      	String strIds_Borrar[]	=	null;
      	String strAccion		=	"";
      	int t = 0;
      	strAccion				=	request.getParameter("accion");
      	strIds_Borrar			=	request.getParameterValues("Borrar");
      	bExiste					=	ActualizaClasificacion.getExiste();	
      	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar"))
      	{
      		bOperacion	=	ActualizaClasificacion.getDeleteClasificacion(strIds_Borrar);	
      	} 
      	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
      
      out.write(__oracle_jsp_text[8]);
      out.write(__oracle_jsp_text[9]);
      if(supervisor == true && !cat.equalsIgnoreCase("1")){
      out.write(__oracle_jsp_text[10]);
      }
      out.write(__oracle_jsp_text[11]);
      if((admin == true && supervisor == false) ){ 
      out.write(__oracle_jsp_text[12]);
      } 
      out.write(__oracle_jsp_text[13]);
      if(supervisor == true && cat.equals("1")){
      out.write(__oracle_jsp_text[14]);
      }
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Catálogos Archivo</TITLE>\n<SCRIPT language=\"JavaScript\" src=\"../js/GeneralFunctions.js\"></SCRIPT>\n<script language=\"JavaScript\" type=\"text/javascript\">\n\tfunction cambio(o, t){\n\t\tdoc = document.ClaView;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n<FORM action=\"ClasificacionAsuntoView.jsp\" name=\"ClaView\" method=\"get\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n<TBODY align=\"center\">\n\t<TR bgcolor=\"#00204f\">\n\t\t<TD align=\"center\" >&nbsp;\n\t\t\t\t\t<FONT size=\"2\" color=\"white\" face=\"verdana\">CATALOGOS ARCHIVOS</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"100%\" colspan=\"2\"></TD>\n    </TR>\n</TABLE>\n<TABLE width=\"70%\" height=\"40%\" border=\"0\">\n<TBODY>\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t<TR valign=top height=\"20\">\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"TipoCedArchview.jsp\">Cédula Tipo</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\t\n\t<TR valign=top height=\"20\">\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ExpedienteArchview.jsp\">Expedientes</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top height=\"20\">\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ConsultaExpediente.jsp\">Consultas por Asunto</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ConsultaExpedienteInst.jsp\">Consultas por instrucción</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n    <TR>\n    \t<TD nowrap></TD>\n\t</TR>\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ValorArchview.jsp\">Tipo de Valores</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ValoracionArchview.jsp\">Valoración</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"SeleccionArchview.jsp\">Técnica de Selección</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ClasifInfArchview.jsp\">Clasificación de información</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"UbicacionView.jsp\">Ubicaciones</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\t\t\t\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"FondoArchview.jsp\">Fondo</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"SubfondoArchview.jsp\">Subfondo</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"SeccionArchview.jsp\">Sección</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ClasificacionArchview.jsp\">Instrumento Clasificación y Disposición Documental Serie</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD>\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ClasificacionArchSubview.jsp\">Instrumento Clasificación y Disposición Documental Subserie</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"Icddview.jsp\">ICDD por Unidad</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"TipoCedArchview.jsp\">Cédula Tipo</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\t\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ExpedienteArchview.jsp\">Expedientes</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ConsultaExpediente.jsp\">Consultas por Asunto</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\t\n\t\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ConsultaExpedienteInst.jsp\">Consultas por instrucción</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ValorArchview.jsp\">Tipo de Valores</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ValoracionArchview.jsp\">Valoración</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t     <b>* <A href=\"SeleccionArchview.jsp\">Técnica de Selección</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ClasifInfArchview.jsp\">Clasificación de información</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"UbicacionView.jsp\">Ubicaciones</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\t\t\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t   <b>* <A href=\"FondoArchview.jsp\">Fondo</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t   <b>* <A href=\"SubfondoArchview.jsp\">Subfondo</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t   <b>* <A href=\"SeccionArchview.jsp\">Sección</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ClasificacionArchview.jsp\">Instrumento Clasificación y Disposición Documental Serie</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ClasificacionArchSubview.jsp\">Instrumento Clasificación y Disposición Documental Subserie</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\t\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t   <b>* <A href=\"Icddview.jsp\">ICDD por Unidad</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\t\t\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"TipoCedArchview.jsp\">Cédula Tipo</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\t\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ExpedienteArchview.jsp\">Expedientes</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ConsultaExpediente.jsp\">Consultas por Asunto</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=top>\n\t\t<TD >\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <b>* <A href=\"ConsultaExpedienteInst.jsp\">Consultas por instrucción</A></b>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD  align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n</TBODY>\n</TABLE>\n<BR>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
