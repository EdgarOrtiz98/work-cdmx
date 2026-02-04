package _ciudadano;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;


public class _Responder extends com.orionserver.http.OrionHttpJspPage {


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
    _Responder page = this;
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
      out.write(__oracle_jsp_text[2]);
      
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
      	String strIdSol = "";
      	String strFecha = "";
      	String strAccion = "";
      	String strRespuesta = "";
      	strIdSol = request.getParameter("id_solicitud");
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      	java.util.Date f 				=	new java.util.Date();
      	strFecha		 				=	sdf.format(f);
      	
      	strAccion	=	request.getParameter("accion");
      	//strIdAsunto	=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
      	if(strAccion != null && strAccion.equals("guardar"))
      	{
      		strRespuesta	=	request.getParameter("respuesta");
      		strIdSol		=	request.getParameter("id_solicitud");
      		//stridRespuest	=	request.getParameter("tipoRespuesta");
      		int i = 0;
      		boolean bInsertar	=	ActualizaCiudadano.insertarNotificacion(strRespuesta, strIdSol, BCiudadano.getNombre(), 
      																BCiudadano.getMail(), strFecha, null, null, null, "0", i);
      		
      		try{
      			response.sendRedirect("DetalleRespuesta.jsp?id_solicitud="+strIdSol);
      		}catch(java.io.IOException io){
      			//System.out.println("Erro-->"+io);
      		}
      	}
      
      out.write(__oracle_jsp_text[3]);
      out.print( strIdSol );
      out.write(__oracle_jsp_text[4]);
      out.print(strIdSol);
      out.write(__oracle_jsp_text[5]);

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
  private static final char __oracle_jsp_text[][]=new char[6][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Responder.jsp</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n\t\n\tfunction regresar(){\n\t\tlocation.assign('DetalleRespuesta.jsp?id_solicitud=".toCharArray();
    __oracle_jsp_text[4] = 
    "');\n\t}\n\t\n\tfunction guardar(){\t\n\t\tdoc = document.responder;\n\t\tvalida = 0;\n\t\tmsg=\"\";\n\n\t\tif (doc.respuesta.value == \"\") {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \"- Debe capturar una Respuesta\t\"+ \"\\n\";\n\t\t}\n\t\tif (valida == 1) \n\t\t{\n\t\t\talert(msg);\n\t\t} \n\t\tif (valida != 1)\n\t\t{\n\t\t\tdoc.accion.value=\"guardar\";\n\t\t\tdoc.submit();\n\t\t}\n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n<FORM name=\"responder\" action=\"Responder.jsp\" method=\"post\">\n<INPUT name=\"accion\" value=\"\" type=\"hidden\">\n<INPUT name=\"id_solicitud\" value=\"".toCharArray();
    __oracle_jsp_text[5] = 
    "\" type=\"hidden\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\" colspan=\"2\">\n\t\t\t\t<INPUT class=\"blue100\" onclick=\"regresar()\" type=\"button\" value=\"Cancelar\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<INPUT class=\"blue100\" onclick=\"guardar()\" type=\"button\" value=\"Aceptar\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"672\" bgcolor=\"#00204f\" colspan=\"4\"><FONT size=\"0\"></FONT></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Responder:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t<TEXTAREA cols=\"50\" rows=\"5\" class=\"blue500\" name=\"respuesta\"></TEXTAREA>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
