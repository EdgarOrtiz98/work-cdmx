package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.taglib.*;


public class _Seccion extends com.orionserver.http.OrionHttpJspPage {


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
    _Seccion page = this;
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
      
      	String idSeccion		=	"";
      	String idSubfondo		=	"";
      	String strCodigo		=	"";
      	String strSerie			=	"";
      	String strUsrActualiza	=	"";
      	String strFecha			=	"";
      	String strAccion		=	"";
      
      	boolean bInsertar		=	false;
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFecha						=	sdf.format(f);
      
      	strAccion		=	request.getParameter("accion");
      	idSeccion		=	(request.getParameter("id_sec") != null)?request.getParameter("id_sec"):"";
      	if(strAccion!=null && strAccion.trim().length()>0)
      	{
      		if(strAccion != null && strAccion.equals("guardar"))
      		{
      			strSerie	=	request.getParameter("secSerie");
      			strCodigo	=	request.getParameter("secCodigo");
      			idSubfondo	=	request.getParameter("secSubfondo");
      
      			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Seccion
      			strSerie	=	(strSerie.length()<= 500) ? strSerie : strSerie.substring(0,500);
      			strCodigo	=	(strCodigo.length()<= 50) ? strCodigo : strCodigo.substring(0,50);
      
      			bInsertar	=	ActualizaSeccion.insertarSeccion(	strCodigo, strSerie, idSubfondo,
      																strFecha, BUsuario.getIdUsuario());
      			try{
      				response.sendRedirect("SeccionView.jsp");
      			}catch(java.io.IOException io){
      				//System.out.println("Error-->"+io);
      			}
      		}
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      			strSerie	=	request.getParameter("secSerie");
      			strCodigo	=	request.getParameter("secCodigo");
      			idSubfondo	=	request.getParameter("secSubfondo");
      			
      			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Seccion
      			strSerie	=	(strSerie.length()<= 500) ? strSerie : strSerie.substring(0,500);
      			strCodigo	=	(strCodigo.length()<= 50) ? strCodigo : strCodigo.substring(0,50);
      
      			bInsertar = ActualizaSeccion.actualizaSeccion(	strCodigo, strSerie, idSubfondo, strFecha, 
      															BUsuario.getIdUsuario(), idSeccion);
      			try{
      				response.sendRedirect("SeccionView.jsp");
      			}catch(java.io.IOException io){
      				//System.out.println("Error-->"+io);
      			}
      		}
      	}
      	if(idSeccion != null && idSeccion.trim().length()>0)
      	{
      		String strDatosSeccion[][] = ActualizaSeccion.getSeccion(idSeccion); 
      		strCodigo		=	strDatosSeccion[0][0];
      		strSerie		=	strDatosSeccion[0][1];
      		idSubfondo		=	strDatosSeccion[0][2];
      		strFecha		=	strDatosSeccion[0][3];
      		strUsrActualiza	=	strDatosSeccion[0][4];
      		
      	}
      
      out.write(__oracle_jsp_text[8]);
      out.print(idSeccion);
      out.write(__oracle_jsp_text[9]);
       if(idSeccion != null && idSeccion.trim().length()>0){ 
      out.write(__oracle_jsp_text[10]);
      out.print(ActualizaUsuario.NombreUsuario(strUsrActualiza));
      out.write(__oracle_jsp_text[11]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[12]);
       }else{ 
      out.write(__oracle_jsp_text[13]);
      out.print( BUsuario.getNombre() );
      out.write(__oracle_jsp_text[14]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[15]);
       } 
      out.write(__oracle_jsp_text[16]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getSubFondoCombo());
        __jsp_taghandler_1.setName("secSubfondo");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( idSubfondo));
        __jsp_taghandler_1.setClassHtml("blue500");
        __jsp_taghandler_1.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_1.setTextoNoSeleccion("-- Seleccione un Subfondo --");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[17]);
      out.print(strCodigo);
      out.write(__oracle_jsp_text[18]);
      out.print(strSerie);
      out.write(__oracle_jsp_text[19]);

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
  private static final char __oracle_jsp_text[][]=new char[20][];
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Sección</TITLE>\n<STYLE type=text/css>\n\tBODY {\n\t\tmargin: 0px;\n\t}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"Seccion.jsp\" name=\"seccion1\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\" name=\"id_sec\">\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a onclick=\"location.assign('SeccionView.jsp');\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/Regresar.gif\" width=\"82\" height=\"26\"> </a>\n\t\t\t</TD>\n\t\t\t<TD width=\"125\"><a><img\n\t\t\t\tsrc=\"../Imagenes/Guardar.gif\" width=\"81\" border=\"0\"\n\t\t\t\tonclick=\"GuardarSeccion()\"></a></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"48\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n\n<DIV class=\"documentBody\" id=\"Body\" style=\"HEIGHT: 441px\">\n<DIV align=\"center\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\" colspan=\"2\"><B><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\">Sección</FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"672\" bgcolor=\"#00204f\" colspan=\"4\"><FONT size=\"1\">&nbsp;</FONT></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[11] = 
    " - ".toCharArray();
    __oracle_jsp_text[12] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[14] = 
    " - ".toCharArray();
    __oracle_jsp_text[15] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tSubfondo:</FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tcódigo:</FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"secCodigo\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" type=\"text\" class=\"blue100\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tSerie:</FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"secSerie\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" type=\"text\" class=\"blue500\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<BR>\n<BR>\n</DIV>\n</DIV>\n</DIV>\n\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
