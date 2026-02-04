package _ciudadano;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;


public class _EditarPassword extends com.orionserver.http.OrionHttpJspPage {


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
    _EditarPassword page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("headerCiudadano.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[1]);
      com.meve.sigma.beans.CiudadanoBean CiudadanoBean;
      synchronized (pageContext) {
        if ((CiudadanoBean = (com.meve.sigma.beans.CiudadanoBean) pageContext.getAttribute( "CiudadanoBean", PageContext.PAGE_SCOPE)) == null) {
          CiudadanoBean = (com.meve.sigma.beans.CiudadanoBean) new com.meve.sigma.beans.CiudadanoBean();
          pageContext.setAttribute( "CiudadanoBean", CiudadanoBean, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      
      	BeanCiudadano BCiudadano = (BeanCiudadano)session.getAttribute("CiudadanoBean"); 
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+11,strTmp.length());
      	if(BCiudadano==null){  
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
      	}
      
      	int ir = 0;
      	String strAccion = request.getParameter("accion");
      	String strIdCiudadano = BCiudadano.getIdUsuario();
      	String strMail		=	BCiudadano.getMail();
      	String strNombre	=	BCiudadano.getNombre();
      	String strUser		=	BCiudadano.getUsuario();
      
      	if(strAccion != null && strAccion.equals("editar")){
      		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
      		String portServer = application.getInitParameter("PortMail");
      		String serverName = application.getInitParameter("servername");
      		ir = CiudadanoBean.editarPassword(request, serverMail, portServer, serverName);
      		//ir = new Integer(strDatos[0]).intValue();
      		//if(ir == 0){
      			//String stridCiudadano = ActualizaCiudadano.getUltimoIdCiudadano();
      		if(ir >= 0){
      			//String stridCiudadano = Integer.toString(ir);
      			try{
      				response.sendRedirect("PortalCiudadano.jsp");
      			}catch(java.io.IOException io){
      				//System.err.println("Error de reDirección-->"+io);
      			}
      		}
      	}
      
      out.write(__oracle_jsp_text[4]);
      out.print(strIdCiudadano);
      out.write(__oracle_jsp_text[5]);
      out.print(strMail);
      out.write(__oracle_jsp_text[6]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[7]);
      out.print(strUser);
      out.write(__oracle_jsp_text[8]);
       if(ir == -1){
      out.write(__oracle_jsp_text[9]);
       } 
      out.write(__oracle_jsp_text[10]);
       if(ir == -2){
      out.write(__oracle_jsp_text[11]);
       } 
      out.write(__oracle_jsp_text[12]);
      out.print(BCiudadano.getUsuario());
      out.write(__oracle_jsp_text[13]);
      if(ir == -1){
      out.write(__oracle_jsp_text[14]);
      }
      out.write(__oracle_jsp_text[15]);
      if(ir == -2){
      out.write(__oracle_jsp_text[16]);
      }
      out.write(__oracle_jsp_text[17]);

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
  private static final char __oracle_jsp_text[][]=new char[18][];
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<TITLE>EditarPassword.jsp</TITLE>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0;\">\n<FORM name=\"formPassword\" action=\"EditarPassword.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[5] = 
    "\" name=\"reg_id\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\" name=\"mail\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\" name=\"nombre\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\" name=\"user\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"536\"><B><FONT face=\"Verdana\" color=\"RED\" size=\"3\">La Clave Anterior no coincide</FONT></B></TD>\n\t\t\t<TD width=\"44\">&nbsp;</TD>\n\t\t\t<TD width=\"265\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<BR>\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"628\"><B><FONT face=\"Verdana\" color=\"RED\" size=\"3\">Verifique que la nueva clave coincida con la clave de Confirmación</FONT></B></TD>\n\t\t\t<TD width=\"111\">&nbsp;</TD>\n\t\t\t<TD width=\"106\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"EditarDatos.jsp\"> <IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/Regresar.gif\" width=\"82\" height=\"26\"> </a></TD>\n\t\t\t<TD width=\"125\"><a onclick=\"EditarPassword()\"> <img\n\t\t\t\tsrc=\"../Imagenes/Guardar.gif\" width=\"81\" border=\"0\" name=\"guardaImg\"> </a></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"227\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t<TD colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><I></I></FONT></TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<TD colspan=\"4\">\n\t\t\t<B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Datos de Usuario</FONT></B>\n\t\t</TD>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<TD bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Usuario*:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[13] = 
    "</FONT><br>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Clave Anterior*:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT size=\"2\" face=\"Arial\"><INPUT size=\"50\"\n\t\t\ttype=\"password\" name=\"pass1\" class=\"blue100\" maxlength=\"8\"></FONT><br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "<FONT size=\"1\" face=\"Arial\" color=\"red\">La clave anterior no coincide</FONT>".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Nueva Clave*:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT size=\"2\" face=\"Arial\"><INPUT size=\"50\"\n\t\t\ttype=\"password\" name=\"pass2\" class=\"blue100\" maxlength=\"8\"></FONT></TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Confirmar Nueva Clave*:</FONT></b></TD>\n\t\t<TD colspan=\"3\"><FONT size=\"2\" face=\"Arial\"><INPUT size=\"50\"\n\t\t\ttype=\"password\" name=\"pass3\" class=\"blue100\" maxlength=\"8\"></FONT><br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "<FONT size=\"1\" face=\"Arial\" color=\"red\">Ingresa la misma Clave para los mismos casilleros</FONT>".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"155\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"276\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</table>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"628\"><FONT size=\"2\" face=\"Arial\" color=\"#004080\">Si tienes tu correo Electrónico registrado en el sistema,\n\t\t\tse te emitira un mail con tu nueva Contraseña</FONT>\n\t\t\t<TD width=\"111\">&nbsp;</TD>\n\t\t\t<TD width=\"106\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
