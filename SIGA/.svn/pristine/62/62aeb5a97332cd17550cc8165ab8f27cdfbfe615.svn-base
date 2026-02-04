package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;


public class _Estatus extends com.orionserver.http.OrionHttpJspPage {


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
    _Estatus page = this;
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
      		}
      		catch(java.io.IOException io){
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
      
      	String strIdEstatus		 	=	"";
      	String strNombreEstatus		=	"";
      	String strCerrar			=	"";
      	String strFecha				=	"";
      	String strUsuario			=	"";
      	String strAccion			=	"";
      	
      	strAccion		=	request.getParameter("accion");
      	strIdEstatus	=	(request.getParameter("id_estatus") != null)?request.getParameter("id_estatus"):"";
      	
      	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f = new java.util.Date();
      	strFecha = sdf.format(f);
      
      	if(strAccion!=null && strAccion.trim().length()>0)
      	{
      		if(strAccion != null && strAccion.equals("guardar"))
      		{
      			strNombreEstatus = request.getParameter("nombre_estatus");  
      			strCerrar		=	request.getParameter("fin");
      			
      			if(strCerrar == null)
      				strCerrar = "0";
      			
      			boolean b = ActualizaEstatus.getInsertaEstatus(strNombreEstatus, strCerrar, 
      															BUsuario.getIdUsuario(), strFecha);
      			try{
      				response.sendRedirect("EstatusView.jsp");
      			}catch(java.io.IOException io){
      				//System.out.println("Error-->"+io);
      			}
      		}
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      			strIdEstatus = request.getParameter("id_estatus"); 
      			strNombreEstatus = request.getParameter("nombre_estatus"); 
      			strCerrar	=	request.getParameter("fin");
      			if(strCerrar == null)
      				strCerrar = "0"; 
      			boolean c = ActualizaEstatus.getActualizarEstatus(strIdEstatus, strNombreEstatus, 
      															strCerrar, BUsuario.getIdUsuario(), strFecha);
      
      			try{
      				response.sendRedirect("EstatusView.jsp");
      			}catch(java.io.IOException io){
      				//System.out.println("Error-->"+io);
      			}
      		}
      		
      	}
      	if(strIdEstatus != null && strIdEstatus.trim().length()>0)
      	{
      		String strTip[][] = ActualizaEstatus.getEstatus(strIdEstatus);
      		strNombreEstatus 	=	strTip[0][0];
      		strCerrar			=	strTip[0][1];
      		strFecha			=	strTip[0][2];
      		strUsuario			=	strTip[0][3];
      	}
      
      out.write(__oracle_jsp_text[7]);
      out.print(strIdEstatus);
      out.write(__oracle_jsp_text[8]);
       if(strIdEstatus != null && strIdEstatus.trim().length()>0){ 
      out.write(__oracle_jsp_text[9]);
      out.print( ActualizaUsuario.NombreUsuario(strUsuario) );
      out.write(__oracle_jsp_text[10]);
      out.print( strFecha);
      out.write(__oracle_jsp_text[11]);
       }else{ 
      out.write(__oracle_jsp_text[12]);
      out.print( BUsuario.getNombre() );
      out.write(__oracle_jsp_text[13]);
      out.print( strFecha);
      out.write(__oracle_jsp_text[14]);
       } 
      out.write(__oracle_jsp_text[15]);
      out.print(strNombreEstatus);
      out.write(__oracle_jsp_text[16]);
      out.print((strCerrar.trim().equals("1")?"checked":""));
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Estatus</TITLE>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n<!-- \nfunction guardarEstatus() { \n\tvar doc = document.estatusForm\n\tvar valida = 0;\n\tvar msg=\"\";\n\n\tif (doc.nombre_estatus.value ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debe capturar el nombre del Estatus\"+ \"\\n\";\n\t}\n\tif (valida == 1){\n\t\talert(msg);\n\t} \n\tif (valida != 1)\n\t{\n\tif(doc.id_estatus.value != \"\")\n\t\tdoc.accion.value=\"cambiar\";\n\tif(doc.id_estatus.value == \"\")\n\t\tdoc.accion.value=\"guardar\";\n\tdoc.submit();\n\t}\n}\n</SCRIPT>\n<TITLE>TipoRespuesta.jsp</TITLE>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM name=\"estatusForm\" action=\"Estatus.jsp\" method=\"post\">\n<INPUT type=hidden value=\"\" name=\"accion\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\" name=\"id_estatus\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><A href=\"EstatusView.jsp\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/Regresar.gif\" width=\"82\" height=\"26\"></A></TD>\n\t\t\t<TD width=\"553\">\n\t\t\t\t<a onclick=\"guardarEstatus()\">\n\t\t\t\t<img src=\"../Imagenes/Guardar.gif\" width=\"81\" border=\"0\">\n\t\t\t\t</a>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\n\t</TBODY>\n</TABLE>\n<BR>\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\" width=\"574\"><B><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\">Estatus a los Tipos de Respuestas</FONT></B></TD>\n\t\t\t<TD width=\"98\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<td width=\"672\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\"><I>\n\t\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t\tCreado por: ".toCharArray();
    __oracle_jsp_text[10] = 
    " - ".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\tCreado por: ".toCharArray();
    __oracle_jsp_text[13] = 
    " - ".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t</I></FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\" align=\"right\">&nbsp;</TD>\n\t\t</TR>\n\t\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Estatus:</FONT></TD>\n\t\t\t<TD width=\"528\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue500\"\n\t\t\t\tname=\"nombre_estatus\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\"></FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Estatus de Cierre:</FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t<INPUT \ttype=\"checkbox\" value=\"1\" \n\t\t\t\t\t\tname=\"fin\" ".toCharArray();
    __oracle_jsp_text[17] = 
    ">Fin de Flujo\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<BR>\n\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
