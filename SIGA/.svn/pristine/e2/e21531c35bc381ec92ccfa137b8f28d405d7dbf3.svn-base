package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;


public class _AgregarComentarioInstruccion extends com.orionserver.http.OrionHttpJspPage {


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
    _AgregarComentarioInstruccion page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("header.jsp");
        // Include 
        pageContext.include( __url,true);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      
      	String strIdInstruccion		=	"";
      	String strIdAsunto			=	"";
      	String strAvance			=	"";
      	String strTurnador			=	""; 
      	String strNombreInst		=	"";            
      	String strA1		=	(request.getParameter("a") != null)?request.getParameter("a"):"";
      	strIdInstruccion	=	(request.getParameter("id_ins") != null)?request.getParameter("id_ins"):"";
      	strIdAsunto			=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";	
      	strTurnador			=	(request.getParameter("tur") != null)?request.getParameter("tur"):"";
      	strNombreInst		=	(request.getParameter("ins") != null)?request.getParameter("ins"):"";
      	
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp = request.getRequestURI();
      	
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+strTmp+"?id_ins="+strIdInstruccion+"&id_asunto="+strIdAsunto+"&tur="+strTurnador+"&ava="+strAvance+"&ins="+strNombreInst);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("E/RROR:"+io.getMessage());
      		}
      	}
      
      out.write(__oracle_jsp_text[5]);
      
      	String strComentario		=	"";
      	String strAccion			=	"";
      	String strFechaCreacion		=	"";
      	String strDireccion 		= 	"";
      	
      	boolean bInsertarComentario	=	false;
      	boolean bActualiza			=	false;
      	
      	strAccion			=	request.getParameter("accion");
      	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
          String retURI2 = (request.getParameter("retURI2")== null)?retURI:request.getParameter("retURI2");
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFechaCreacion 				=	sdf.format(f);
      
      	java.text.SimpleDateFormat sdf1	=	new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      	java.util.Date f1 				=	new java.util.Date();
      	String strFecha					=	sdf1.format(f1);
      	
      	boolean bValidaEstatus = false;
      	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
      	if (strIdInstruccion!=null && !strIdInstruccion.equals("")){
      		if (strEstValidacion.equals("")){
      			strEstValidacion = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
      		}
      		String strEstatusValida = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
      		if (!strEstatusValida.equals(strEstValidacion)){ 
      			bValidaEstatus = true; 
      		}
      	}
      
      	if(!bValidaEstatus && strAccion != null && strAccion.equals("guardar"))
      	{
      		strA1 = request.getParameter("a");
      		String strDatosInstrucciones[][]	=	ActualizaInstrucciones.getInstruccionDatos(strIdInstruccion);
      
      		strIdAsunto			=	ActualizaInstrucciones.getIdAsuntoInstruccion(strIdInstruccion);
      		strAvance			=	strDatosInstrucciones[0][20];
      		strComentario		=	request.getParameter("comentario");	
      		
      		bInsertarComentario	=	ActualizaHistorial.InsertarComentario(	strIdInstruccion, strIdAsunto,
      																	strComentario, BUsuario.getIdUsuario(), 
      																	strAvance, strFechaCreacion, BUsuario.getCargo()+" / "+BUsuario.getNombre());
      		
      		//boolean bInsertaNot	=	ActualizaCiudadano.insertarNotificacion(strComentario, strIdAsunto, BUsuario.getNombre(), 
      		//															BUsuario.getCorreo(), strFecha);
      		if(strA1.equals("1")){
      			strDireccion = "InstruccionesAtender.jsp";
      		}else if(strA1.equals("2")){
      			strDireccion = "InstruccionTurnada.jsp";
      		}else if(strA1.equals("3")){
      			strDireccion = "InstruccionHija.jsp";
      		}
      
      
      out.write(__oracle_jsp_text[6]);
      out.print(strDireccion);
      out.write(__oracle_jsp_text[7]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[8]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(retURI2));
      out.write(__oracle_jsp_text[9]);
      
      
      	}
      	if(strA1.equals("1")){
      		strDireccion = "InstruccionesAtender.jsp";
      	}else if(strA1.equals("2")){
      		strDireccion = "InstruccionTurnada.jsp";
      	}else if(strA1.equals("3")){
      		strDireccion = "InstruccionHija.jsp";
      	}
      
      out.write(__oracle_jsp_text[10]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[11]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[12]);
      out.print(strTurnador);
      out.write(__oracle_jsp_text[13]);
      out.print(strNombreInst);
      out.write(__oracle_jsp_text[14]);
      out.print( retURI );
      out.write(__oracle_jsp_text[15]);
      out.print(strA1);
      out.write(__oracle_jsp_text[16]);
      out.print(retURI);
      out.write(__oracle_jsp_text[17]);
      out.print(retURI2);
      out.write(__oracle_jsp_text[18]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[19]);
      out.print( bValidaEstatus );
      out.write(__oracle_jsp_text[20]);

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
  private static final char __oracle_jsp_text[][]=new char[21][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    " \n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "    \n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<SCRIPT language=JavaScript type=text/javascript>\n    var url='".toCharArray();
    __oracle_jsp_text[7] = 
    "?id_ins='+'".toCharArray();
    __oracle_jsp_text[8] = 
    "'+'&retURI=".toCharArray();
    __oracle_jsp_text[9] = 
    "';\n\tlocation.assign(url);\n</SCRIPT>\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Agregar Comentario</TITLE>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\nfunction guardar(){\n    forma1=document.forma;\n\t//valida = 0;\n\tmsg=\"\";\n\tforma1.id_ins.value='".toCharArray();
    __oracle_jsp_text[11] = 
    "';\n\tforma1.id_asunto.value='".toCharArray();
    __oracle_jsp_text[12] = 
    "';\n\tforma1.tur.value='".toCharArray();
    __oracle_jsp_text[13] = 
    "';\n\tforma1.ins.value='".toCharArray();
    __oracle_jsp_text[14] = 
    "';\n\tdocument.getElementById(\"btnReasignar\").disabled = true;\n\tif(Trim(forma1.comentario.value)==\"\"){\n\t\tvalida =1;\n\t\tmsg = msg + \"Debe capturar un comentario\"+ \"\\n\";\n\t}\n\tif (valida == 1){\n\t\talert(msg);\n\t\tvalida = 0;\n\t\treturn false;\n\t}else if(valida==2){\n\t\talert(\"Su solicitud ya fue enviada\");\n\t\treturn false;\n\t}else{\n\t\tmensaje = 'Algunos de los campos tienen caracteres invalidos (&, \", <, >, \\')\\nPresione Aceptar para modificarlos automaticamente\\no Cancelar para regresar'\n\t\tif(detectaCE(forma1.comentario.value)){\n\t\t\tif (confirm(mensaje)){\n\t\t\t\tforma1.comentario.value\t= quitaCE(forma1.comentario.value);\n\t\t\t\tforma1.accion.value=\"guardar\";\n\t\t\t\tforma1.submit();\n\t\t\t}\n\t\t\telse \n\t\t\t\tforma1.accion.value=\"\";\n\t\t}else{\n\t\t\tforma1.accion.value=\"guardar\";\n\t\t\tvalida=2;\n\t\t\tforma1.submit();\n\t\t}\n\t}\n}\nfunction regresar(){\n    var url='".toCharArray();
    __oracle_jsp_text[15] = 
    "';\n\tlocation.assign(url);\n}\n</SCRIPT>\n\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load();valida=0;\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\"\n\tonMouseMove=\"limitaTextArea(document.forma.comentario,'Comentario','4000')\">\n<form action=\"AgregarComentarioInstruccion.jsp\" name=\"forma\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"\" name=\"id_ins\">  \n<INPUT type=\"hidden\" value=\"\" name=\"id_asunto\">\n<INPUT type=\"hidden\" value=\"\" name=\"tur\">\n<INPUT type=\"hidden\" value=\"\" name=\"ins\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"a\">\n<INPUT name=\"retURI\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" type=\"hidden\">\n<INPUT name=\"retURI2\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" type=\"hidden\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"estValidacion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE>\n\t<tr align=\"left\">\n\t\t<TD align=\"left\">\n\t\t\t<INPUT class=\"blue100\" type=\"button\" name=\"cancelarBtn\" value=\"Cancelar\" onclick=\"regresar();\">&nbsp;&nbsp;\n\t\t\t<INPUT id=\"btnReasignar\" name=\"btnReasignar\" class=\"blue100\" type=\"button\" name=\"guardarBtn\" value=\"Guardar\" onclick=\"guardar();\">\n\t\t</td>\n\t</tr>\n\t<tr align=\"left\">\n\t\t<td>\n\t\t\t<FIELDSET dir=\"ltr\"><LEGEND align=\"left\">Comentarios de la instrucción</LEGEND>\n\t\t\t<TEXTAREA cols=\"80\" rows=\"5\" name=\"comentario\" class=\"blue500\"\n\t\t\tonKeyDown=\"limitaTextArea(document.forma.comentario,'Comentario','4000')\"></TEXTAREA>\n\t\t\t</FIELDSET>\n\t\t</td>\n\t</tr>\n</TABLE>\n</DIV>\n<script type=\"text/javascript\">\n<!--\nif (".toCharArray();
    __oracle_jsp_text[20] = 
    "){\n\talert(\"Esta instrucción ha sido modificada por otro usuario y Cambió su Estatus,\\npor lo que la acción solicitada será cancelada\");\n\tlocation.assign(\"portalPrincipal.jsp\");\n}\n//-->\n</script>\n</form>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
