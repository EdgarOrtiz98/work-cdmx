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


public class _Comentarios extends com.orionserver.http.OrionHttpJspPage {


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
    _Comentarios page = this;
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
      	boolean bInsertar		=	false;
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      	java.util.Date f 				=	new java.util.Date();
      	strFecha		 				=	sdf.format(f);
      	
      	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
      	strAccion	=	request.getParameter("accion");
      	strIdAsunto	=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
      
      	boolean bValidaEstatus = false;
      	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
      	if (strIdAsunto!=null && !strIdAsunto.equals("")){
      		if (strEstValidacion.equals("")){
      			strEstValidacion = ActualizaAsunto.getEstatus(strIdAsunto);
      		}
      		String strEstatusValida = ActualizaAsunto.getEstatus(strIdAsunto);
      		if (!strEstatusValida.equals(strEstValidacion) || strEstValidacion.equalsIgnoreCase("4")){ 
      			bValidaEstatus = true; 
      		}
      	}
      
      	if(!bValidaEstatus && strAccion != null && strAccion.equals("guardar"))
      	{
      		strComentario	=	request.getParameter("Comentario1");
      		strIdAsunto		=	request.getParameter("id_asunto");
      		//stridRespuest	=	request.getParameter("tipoRespuesta");
      		bInsertar		=	ActualizaComentario.InsertarEventoResponder(strComentario, BUsuario.getIdUsuario(), 
      																		strFecha, strIdAsunto, BUsuario.getCargo());
      		
      		try{
      			//response.sendRedirect("AsuntoTurnado.jsp?id_asunto="+strIdAsunto);
      			response.sendRedirect(retURI);
      		}catch(java.io.IOException io){
      			//System.out.println("Erro-->"+io);
      		}
      	}
      
      out.write(__oracle_jsp_text[5]);
      out.print( strIdAsunto );
      out.write(__oracle_jsp_text[6]);
      out.print( retURI );
      out.write(__oracle_jsp_text[7]);
      out.print( strIdAsunto );
      out.write(__oracle_jsp_text[8]);
      out.print(retURI);
      out.write(__oracle_jsp_text[9]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[10]);
      out.print( bValidaEstatus );
      out.write(__oracle_jsp_text[11]);

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
  private static final char __oracle_jsp_text[][]=new char[12][];
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Comentarios</TITLE>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript>\n\t\n\n\tfunction regresar(){\n\t\t//location.assign('AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[6] = 
    "');\n\t\tlocation.assign('".toCharArray();
    __oracle_jsp_text[7] = 
    "');\n\t}\n\t\n    function guardar(){\t\n        document.getElementById(\"btnAceptar\").disabled = true;\n    \n        doc = document.comentario;\n        valida = 0;\n        msg=\"\";\n\n        mensaje = 'Algunos de los campos tienen caracteres invalidos (&, \", <, >, \\', `, ´)\\nPresione Aceptar para modificarlos automaticamente\\no Cancelar para regresar'\n        \n        if(detectaCE(doc.Comentario1.value)){\n            if (confirm(mensaje)){\n                    doc.Comentario1.value\t= quitaCE(doc.Comentario1.value);\n                    doc.accion.value=\"guardar\";\n            }\n            else \n                        doc.accion.value=\"\";\n        }\n        else{\n                doc.accion.value=\"guardar\";\n        }\n    \n        if (Trim(doc.Comentario1.value) == \"\") {\n                valida =1;\n                msg = msg + \"Debe capturar un comentario para el Asunto\t\"+ \"\\n\";\n        }\n    \n        if (valida == 1) \n        {\n                alert(msg);\n                return false;\n        }\n    \n        doc.submit();\n    }\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\"\n\tonMouseMove=\"limitaTextArea(document.comentario.Comentario1,'Comentario','4000')\">\n<FORM action=\"Comentarios.jsp\" name=\"comentario\" method=\"post\">\n<INPUT type=\"hidden\" value=\"guardar\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\" name=\"id_asunto\">\n<INPUT name=\"retURI\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\" type=\"hidden\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\" name=\"estValidacion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\" colspan=\"2\">\n\t\t\t\t<INPUT class=\"blue100\" onclick=\"regresar()\" type=\"button\" value=\"Cancelar\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<INPUT id=\"btnAceptar\" name=\"btnAcertar()\" class=\"blue100\" onclick=\"guardar()\" type=\"button\" value=\"Aceptar\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"672\" bgcolor=\"#00204f\" colspan=\"4\"><FONT size=\"0\"></FONT></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Comentarios:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t<TEXTAREA cols=\"50\" rows=\"5\" class=\"blue500\" name=\"Comentario1\"\n\t\t\t\tonKeyDown=\"limitaTextArea(document.comentario.Comentario1,'Comentario','4000');\"></TEXTAREA>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<script type=\"text/javascript\">\n<!--\nif (".toCharArray();
    __oracle_jsp_text[11] = 
    "){\n\talert(\"Este Asunto ha sido modificado por otro usuario y Cambió su Estatus,\\npor lo que la acción solicitada será cancelada\");\n\tlocation.assign(\"portalPrincipal.jsp\");\n}\n//-->\n</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
