package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import java.util.*;
import com.meve.sigma.util.*;
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;


public class _Delegar extends com.orionserver.http.OrionHttpJspPage {


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
    _Delegar page = this;
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
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
      
      	String strIdAsunto			=	"";
      	String strIdInstruc			=	"";
      	String strAvance			=	"";
      	String strUsuarioOriginal	=	"";
      	
      	strIdInstruc			=	(request.getParameter("id_ins") != null)?request.getParameter("id_ins"):"";
      	strIdAsunto				=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
      	strAvance				=	(request.getParameter("ava") != null)?request.getParameter("ava"):"";
      	strUsuarioOriginal		=	(request.getParameter("usr_ori") != null)?request.getParameter("usr_ori"):"";
      	
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp = request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+strTmp+"?id_ins="+strIdInstruc+"&id_asunto="+strIdAsunto+"&ava="+strAvance+"&usr_ori="+strUsuarioOriginal);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("E/RROR:"+io.getMessage());
      		}
      	}
      
      out.write(__oracle_jsp_text[7]);
      
      	String strIdUsuario			=	"";
      	String strComentarios		=	"";
      	String strAccion			=	"";
      	String strFechaCreacion		=	"";
      	
      	boolean bDelegar		=	false;
      	boolean bInsertar		=	false;
      	boolean bInsertarBit	=	false;
      	
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFechaCreacion 				=	sdf.format(f);
      	
      	String strIdAreaUs		=	BUsuario.getIdArea();
      	String strIdUsrDelega	=	BUsuario.getIdUsuario();
      	strAccion				=	request.getParameter("accion");
      
      	if(strAccion != null && strAccion.equals("guardar"))
      	{
      		strIdInstruc	=	request.getParameter("id_ins");
      		strIdAsunto		=	request.getParameter("id_asunto");
      		strAvance		=	request.getParameter("ava");
      		strIdUsuario	=	request.getParameter("delegarUsr");
      		strComentarios	=	request.getParameter("delegarComentario");
      		strUsuarioOriginal	=	request.getParameter("usr_ori");
      		  
      		bInsertar		=	ActualizaHistorial.InsertarDelegar(	strIdInstruc, strIdAsunto, strComentarios,
      																strUsuarioOriginal, strFechaCreacion, BUsuario.getCargo()+" / "+BUsuario.getNombre());
      		 
      		bDelegar		=	ActualizaInstrucciones.ActualizaDelegar(strIdInstruc, strAvance, strIdUsuario);
      		
      		String strFolioBit = ActualizaInstrucciones.getUltimoFolioTurnado(strIdInstruc);
      		bInsertarBit	=	ActualizaBitacora.InsertarEventoDelegar(BUsuario.getIdUsuario(), strFolioBit);
      		
      		String strUsr[][]			=	ActualizaUsuario.NombreMailUsuario(strIdUsuario);
      		String UsrNombreResponde 	=	BUsuario.getNombre();
      		String UsrMailResponde		=	BUsuario.getCorreo();
      		String UsrDirigido			=	strUsr[0][0];
      		String UsrMailDirigido		=	strUsr[0][1];
      		
      		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
      		String portServer = application.getInitParameter("PortMail");
      		String serverName = application.getInitParameter("servername");
      
      		String strRutaBase = (application.getInitParameter("RutaBase")==null)?"":application.getInitParameter("RutaBase");
      		if(BUsuario.getDelegar()){
      			try{
      				if (ActualizaUsuario.getNotificacionMail(strIdUsuario)){
      					SenderMail mail = new SenderMail(UsrDirigido, UsrMailDirigido, UsrNombreResponde, 
      											UsrMailResponde, strComentarios, strIdInstruc,
      											serverMail, portServer, serverName,strRutaBase);
      					mail.sendDelegacion(session.getServletContext());
      				}
      			}catch(MessagingException me){
              	    //System.err.println("Mensaje="+me.getMessage());
              	}catch(UnsupportedEncodingException uee){
              	    //System.err.println("Mensaje1="+uee.getMessage());
              	}
      		}
      		try{
      		response.sendRedirect("PortalAtender.jsp");
      		}catch(java.io.IOException io){
      			//System.out.println("E/RROR:"+io.getMessage());
      		}
      	}
      	//String strUsuarios[][] = ActualizaUsuario.getSubalterno(strUsuarioOriginal);
      	String strUsuarios[][] = ActualizaUsuario.getSubordinados(strUsuarioOriginal);
      	//Arboles tree = new Arboles(strUsuarios);
      	AsignarArbol tree = new AsignarArbol(strUsuarios);
      	Vector vNombres1 = new Vector();
      	Vector vIds = new Vector();
      	vNombres1 = tree.getNombres();
      	vIds = tree.getIds();
      
      out.write(__oracle_jsp_text[8]);
      out.print( strIdInstruc );
      out.write(__oracle_jsp_text[9]);
      out.print( strIdAsunto );
      out.write(__oracle_jsp_text[10]);
      out.print( strAvance );
      out.write(__oracle_jsp_text[11]);
      out.print( strUsuarioOriginal );
      out.write(__oracle_jsp_text[12]);
      for(int i=0;i<vNombres1.size();i++){
      out.write(__oracle_jsp_text[13]);
      out.print(vIds.get(i));
      out.write(__oracle_jsp_text[14]);
      out.print(vNombres1.get(i));
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
    "\n\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Delegar</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n\t\n\tfunction regresar(){\n\t\thistory.go(-1);\n\t}\n\t\n\tfunction Delegar(){\t\n\t\tdoc = document.delegar;\n\t\tvalida = 0;\n\t\tmsg=\"\";\n\n\t\tif (doc.delegarUsr[doc.delegarUsr.selectedIndex].value == -1){\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" Debes seleccionar un Usuario\t\"+ \"\\n\";\n\t\t}\n\t\t\n\t\tif (doc.delegarComentario.value == \"\") {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" Debe capturar un comentario para la Delegación\t\"+ \"\\n\";\n\t\t}\n\t\n\t\tif (valida == 1) \n\t\t{\n\t\t\talert(msg);\n\t\t} \n\t\tif (valida != 1)\n\t\t{\n\t\t\tdoc.accion.value=\"guardar\";\n\t\t\tif (confirm(\"está usted seguro que desea Delegar la instrucción?\")) \n\t\t\t{\n\t\t\t\tdoc.submit();\n\t\t\t}else{\n\t\t\t\talert(\"Su petición de Delegación ya fue cancelada\");\n\t\t\t}\n\t\t}\n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\"\n\tonMouseMove=\"limitaTextArea(document.delegar.delegarComentario,'Delegar','4000')\">\n<FORM action=\"Delegar.jsp\" name=\"delegar\" method=\"post\">\n<INPUT type=\"hidden\" value=\"guardar\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\" name=\"id_ins\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\" name=\"id_asunto\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\" name=\"ava\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"usr_ori\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\" colspan=\"2\">\n\t\t\t\t<INPUT class=\"blue100\" onclick=\"regresar()\" type=\"button\" value=\"Cancelar\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<INPUT class=\"blue100\" onclick=\"Delegar()\" type=\"button\" value=\"Aceptar\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"672\" bgcolor=\"#00204f\" colspan=\"4\"><FONT size=\"0\"></FONT></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Usuario:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t<SELECT name=\"delegarUsr\" onkeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\" class=\"blue500\" >\n\t\t\t\t\t<OPTION value=\"-1\">-- Selecciona Usuario a Delegar --</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\">".toCharArray();
    __oracle_jsp_text[15] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t</TD>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Comentarios:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t<TEXTAREA cols=\"50\" rows=\"5\" class=\"blue500\" name=\"delegarComentario\" \n\t\t\t\t\t\t\tonKeyDown=\"limitaTextArea(document.delegar.delegarComentario,'Delegar','4000')\"></TEXTAREA>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
