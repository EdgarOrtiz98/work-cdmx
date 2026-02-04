package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _ClasificacionAsunto extends com.orionserver.http.OrionHttpJspPage {


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
    _ClasificacionAsunto page = this;
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
      out.write(__oracle_jsp_text[4]);
      
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
      
      
      out.write(__oracle_jsp_text[5]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[6]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[7]);
       } 
      out.write(__oracle_jsp_text[8]);
      
      	String strIdClaAsunto	=	"";
      	String strIdArena		=	"";
      	String strTipo			=	"";
      	String strUsrActualizo	=	"";
      	String strFecha			=	"";
      	String strAccion		=	"";
      
      	boolean bInsertar		=	false;
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFecha						=	sdf.format(f);
      
      	strAccion	=	request.getParameter("accion");
      	strIdClaAsunto	=	(request.getParameter("id_cla") != null)?request.getParameter("id_cla"):"";
      
      	if(strAccion!=null && strAccion.trim().length()>0)
      	{
      		if(strAccion != null && strAccion.equals("guardar"))
      		{
      			//strIdArena		=	request.getParameter("claArea");
      			strTipo			=	request.getParameter("claTipo");
      
      			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Remitente
      			strTipo		=	(strTipo.length()<= 200) ? strTipo : strTipo.substring(0,200);
      
      			bInsertar		=	ActualizaClasificacion.InsertarClasificacion(strTipo,
      																		BUsuario.getIdUsuario(), strFecha);
      			try{
      				response.sendRedirect("ClasificacionAsuntoView.jsp");
      			}catch(java.io.IOException io){
      				//System.out.println("Error-->"+io);
      			}
      		}
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      			//strIdArena		=	request.getParameter("claArea");
      			strTipo			=	request.getParameter("claTipo");
      			
      			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Remitente
      			strTipo		=	(strTipo.length()<= 200) ? strTipo : strTipo.substring(0,200);
      
      			bInsertar = ActualizaClasificacion.ActualizarClasificacion(strIdClaAsunto,strTipo,
      																	BUsuario.getIdUsuario(), strFecha);
      			try{
      				response.sendRedirect("ClasificacionAsuntoView.jsp");
      			}catch(java.io.IOException io){
      				//System.out.println("Error-->"+io);
      			}
      		}
      	}
      
      	if(strIdClaAsunto != null && strIdClaAsunto.trim().length()>0)
      	{
      		String strDatosClasificacion[][] = ActualizaClasificacion.getDatosClasificacion(strIdClaAsunto);
      		//strIdArena		=	strDatosClasificacion[0][0];
      		strTipo			=	strDatosClasificacion[0][0];
      		strUsrActualizo	=	strDatosClasificacion[0][1];
      		strFecha		=	strDatosClasificacion[0][2];
      		
      	}
      	
      
      out.write(__oracle_jsp_text[9]);
      out.print( strIdClaAsunto );
      out.write(__oracle_jsp_text[10]);
      out.print( BUsuario.getNombre() );
      out.write(__oracle_jsp_text[11]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[12]);
      out.print(strTipo);
      out.write(__oracle_jsp_text[13]);

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
  private static final char __oracle_jsp_text[][]=new char[14][];
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
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Clasificacion Asunto</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n<!-- \n\nfunction guardar() { \n\n\tdoc = document.clasifi;\n\t\n\tvalida = 0;\n\tmsg=\"\";\n\n\tif (doc.claTipo.value == \"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes seleccionar el Tipo de Clasificación de Asunto\t\"+ \"\\n\";\n\t}\n\t\n\t\n\tif (valida == 1) \n\t{\n\t\talert(msg);\n\t\treturn false;\n\t} \n\telse if(document.clasifi.id_cla.value != \"\") \n\t\tdocument.clasifi.accion.value=\"cambiar\";\n\telse\n\tif(document.clasifi.id_cla.value == \"\")\n\t\tdocument.clasifi.accion.value=\"guardar\";\n\tdocument.clasifi.submit();\n}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"ClasificacionAsunto.jsp\" name=\"clasifi\" method=\"post\"><INPUT\n\ttype=\"hidden\" value=\"\" name=\"accion\"> <INPUT type=\"hidden\"\n\tvalue=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\" name=\"id_cla\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a onclick=\"history.go(-1);return false;\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/Regresar.gif\" width=\"82\" height=\"26\"> </a>\n\t\t\t</TD>\n\t\t\t<TD width=\"125\"><a><img\n\t\t\t\tsrc=\"../Imagenes/Guardar.gif\" width=\"81\" border=\"0\"\n\t\t\t\tonclick=\"guardar()\"></a></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"48\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n\n<DIV class=\"documentBody\" id=\"Body\" style=\"HEIGHT: 441px\">\n<DIV align=\"center\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\" colspan=\"2\"><B><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\">Clasificación de Asunto</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<td width=\"672\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[11] = 
    " - ".toCharArray();
    __oracle_jsp_text[12] = 
    "</I></FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Clasificación del\n\t\t\tAsunto:</FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"claTipo\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" type=\"text\" class=\"blue500\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<BR>\n<BR>\n</DIV>\n</DIV>\n</DIV>\n</FORM>\n</BODY>\n\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
