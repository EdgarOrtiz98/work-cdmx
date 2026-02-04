package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.taglib.*;
import com.meve.sigma.beans.*;


public class _Ubicacion extends com.orionserver.http.OrionHttpJspPage {


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
    _Ubicacion page = this;
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
      		catch(java.io.IOException io){;}
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
      
      	String strIdUbicacion	=	"";
      	String strUbicacion		=	"";
      	String strIdArea		=	"";
      	String strCreador		=	"";
      	String strCreador1		=	"";		
      	String strFechaCreacion	=	"";
      	String strAccion		=	"";
      	String strEstatus		=	"1";
      
      	String strAux = "1a2b3c", strAux2 = "1a2b3c";
      	int valida = -2;
      
      	boolean bInsertar		=	false;
      	boolean bActualizar		=	false;
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFechaCreacion 				=	sdf.format(f);
      
      	String retURI = (request.getParameter("retURI")==null)?"UsuariosView.jsp":request.getParameter("retURI");
      	strCreador1		=	BUsuario.getIdUsuario();
      	strCreador		=	BUsuario.getNombre();
      	strAccion		=	request.getParameter("accion");
      	strIdUbicacion	=	(request.getParameter("id_ubi") != null)?request.getParameter("id_ubi"):"";
      	
      	if(strIdUbicacion != null && strIdUbicacion.trim().length()>0)
      	{
      		String strDatosUbicacion[][] = ActualizaUbicacion.getDatosUbicacion(strIdUbicacion);
      		strIdArea		=	strDatosUbicacion[0][0];
      		strUbicacion	=	strDatosUbicacion[0][1];
      
      		strAux = strUbicacion;
      		strAux2 = strIdArea;
      	}
      	
      	if(strAccion!=null && strAccion.trim().length()>0)
      	{
      		if(strAccion.equals("guardar"))
      		{
      			strUbicacion	=	request.getParameter("ubicacion");
      			strIdArea		=	request.getParameter("ubicArea");
      
      			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Ubicacion
      			strUbicacion	=	(strUbicacion.length()<= 200) ? strUbicacion : strUbicacion.substring(0,200);
      
      			valida = ActualizaUbicacion.getUbicacionExiste(strUbicacion, strAux, strIdArea, strAux2);	
      
      			if (valida == 2){
      				bInsertar		=	ActualizaUbicacion.InsertarUbicacion(	strIdArea, strUbicacion,
      																		strCreador1, strFechaCreacion);
      				boolean b = ActualizaBitacora.InsertarEventoAltaUbicacion(BUsuario.getIdUsuario(),strUbicacion,strIdArea);
      			}
      		}
      		
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      			strUbicacion	=	request.getParameter("ubicacion");
      			strIdArea		=	request.getParameter("ubicArea");
      
      			strAux		=	request.getParameter("aux");
      			strAux2		=	request.getParameter("aux2");
      
      
      			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Ubicacion
      			strUbicacion	=	(strUbicacion.length()<= 200) ? strUbicacion : strUbicacion.substring(0,200);
      
      			valida = ActualizaUbicacion.getUbicacionExiste(strUbicacion, strAux, strIdArea, strAux2);	
      
      			if (valida == 2){
      				bInsertar = ActualizaUbicacion.ActualizarUbicacion(	strIdArea, strUbicacion,
      																	strCreador1, strFechaCreacion,
      																	strIdUbicacion);
      				boolean b = ActualizaBitacora.InsertarEventoCambioUbicacion(BUsuario.getIdUsuario(),strUbicacion,strIdArea,strIdUbicacion);
      			}
      		}
      	}
      	
      	
      
      out.write(__oracle_jsp_text[8]);
      
      	if(strAccion!=null && (strAccion.equals("cambiar") || strAccion.equals("guardar")) && bInsertar)
      	{
      
      out.write(__oracle_jsp_text[9]);
      out.print( retURI );
      out.write(__oracle_jsp_text[10]);
      
      	}
      
      out.write(__oracle_jsp_text[11]);
      out.print( strIdUbicacion );
      out.write(__oracle_jsp_text[12]);
      out.print( strAux );
      out.write(__oracle_jsp_text[13]);
      out.print( strAux2 );
      out.write(__oracle_jsp_text[14]);
      out.print(retURI);
      out.write(__oracle_jsp_text[15]);
      out.print( retURI );
      out.write(__oracle_jsp_text[16]);
      out.print( strCreador );
      out.write(__oracle_jsp_text[17]);
      out.print( strFechaCreacion );
      out.write(__oracle_jsp_text[18]);
       if(BUsuario.getSupervisor()){ 
      out.write(__oracle_jsp_text[19]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_1.setName("ubicArea");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_1.setClassHtml("blue500");
        __jsp_taghandler_1.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_1.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[20]);
       }else{ 
      out.write(__oracle_jsp_text[21]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getAreasCombo());
        __jsp_taghandler_2.setName("ubicArea");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_2.setClassHtml("blue500");
        __jsp_taghandler_2.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_2.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
        __jsp_taghandler_2.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[22]);
       } 
      out.write(__oracle_jsp_text[23]);
      if (valida == 1) {
      out.write(__oracle_jsp_text[24]);
      } 
      out.write(__oracle_jsp_text[25]);
      out.print( strUbicacion );
      out.write(__oracle_jsp_text[26]);

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
  private static final char __oracle_jsp_text[][]=new char[27][];
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
    "\n<SCRIPT language=JavaScript type=text/javascript>\n\tlocation.assign('".toCharArray();
    __oracle_jsp_text[10] = 
    "');\n</SCRIPT>\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n<!-- \n\nfunction guardar() { \n\tdoc = document.Ubicacion;\n\tmsg=\"\";\n\t\n\t\tmensaje = 'Algunos de los campos tienen caracteres invalidos (&, \", <, >, \\' )\\nPresione Aceptar para eliminarlos automaticamente\\no Cancelar para regresar'\n\t\tif(detectaCE(doc.ubicacion.value)){\n\t\t\tif (confirm(mensaje)){\n\n\t\t\t\tdoc.ubicacion.value\t\t= quitaCE(doc.ubicacion.value);\n\t\n\t\t\t\tdoc.aux.value\t= quitaCE(doc.aux.value);\n\t\t\t\t\n\t\t\t\tif(document.Ubicacion.id_ubi.value != \"\") \n\t\t\t\t\tdocument.Ubicacion.accion.value=\"cambiar\";\n\t\t\t\tif(document.Ubicacion.id_ubi.value == \"\")\n\t\t\t\t\t\tdocument.Ubicacion.accion.value=\"guardar\";\n\t\t\t}\n\t\t\telse \n\t\t\t\tdoc.accion.value=\"\";\n\t\t}\n\t\telse{\n\t\t\tif(document.Ubicacion.id_ubi.value != \"\") \n\t\t\t\tdocument.Ubicacion.accion.value=\"cambiar\";\n\t\t\tif(document.Ubicacion.id_ubi.value == \"\")\n\t\t\t\tdocument.Ubicacion.accion.value=\"guardar\";\n\t\t}\n\t\tif (doc.ubicArea[doc.ubicArea.selectedIndex].value == -1) {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" Debes seleccionar una Unidad\t\"+ \"\\n\";\n\t\t}\n\t\tif (Trim(doc.ubicacion.value) ==\"\") {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" Debes capturar el nombre de la Ubicacion\t\"+ \"\\n\";\n\t\t}\n\t\tif (valida == 1) \n\t\t{\n\t\t\talert(msg);\n\t\t\tvalida=0;\n\t\t\treturn false;\n\t\t}else if(valida == 2){\n\t\t\talert(\"Su solicitud ya fue enviada\");\n\t\t\treturn false;\n\t\t}else{\n\t\t\tvalida=2;\n\t\t\tdocument.Ubicacion.submit();\t\n\t\t}\n}\n\nfunction limpiarUBI(){\n\tdocument.Ubicacion.reset();\n}\n</SCRIPT>\n\n<TITLE>Ubicación</TITLE>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load();limpiarUBI();\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"Ubicacion.jsp\" name=\"Ubicacion\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"id_ubi\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"aux\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"aux2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"retURI\">\n<DIV align=\"center\">\n<BR>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"125\">\n\t\t\t<a href=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\">\n\t\t\t</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<a onclick=\"guardar()\">\n\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\">\n\t\t\t</a>\n\t\t</TD>\n\t\t<TD width=\"125\">\n\n\t\t</TD>\n\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t<TD width=\"48\"></TD>\n    </TR>\n    </TBODY>\n</TABLE>\n</DIV>\n\n\n<DIV class=\"documentBody\" id=\"Body\" style=\"HEIGHT: 441px\">\n<DIV align=\"center\">\n<DIV align=\"center\">\n<BR>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n        <TR valign=\"top\">\n            <TD colspan=\"2\" width=\"254\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\"><FONT\n\t\t\t\tsize=\"+1\" color=\"#004080\">Ubicación</FONT></FONT></B></TD>\n            <TD width=\"111\">&nbsp;</TD>\n            <TD width=\"307\" align=\"right\">&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n        </TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD colspan=\"2\" width=\"254\"></TD>\n\t\t\t<TD width=\"111\"></TD>\n\t\t\t<TD width=\"307\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD colspan=\"2\" width=\"254\" height=\"0\"></TD>\n\t\t\t<TD width=\"111\" height=\"0\"></TD>\n\t\t\t<TD width=\"307\" height=\"0\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT>\n\t\t</TD>\n\t\t<TD width=\"528\" align=\"right\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">Creado por: <I>".toCharArray();
    __oracle_jsp_text[17] = 
    " - ".toCharArray();
    __oracle_jsp_text[18] = 
    "</I></FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><BR>\n\t\t\t<BR>\n\t\t\t&nbsp;</TD>\n\t\t<TD width=\"528\">&nbsp;</TD>\n    </TR>\n<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Unidad\n\t\t\tAdministrativa:</B></FONT></TD>\n\t\t<TD width=\"528\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"528\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Ubicación:</B></FONT>\n\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "<br>\n\t\t<FONT color=\"red\"><B>*Esta Ubicación ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t</TD>\n\t\t<TD width=\"528\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t<INPUT class=\"blue500\" size=\"80\" name=\"ubicacion\"  value=\"".toCharArray();
    __oracle_jsp_text[26] = 
    "\" maxlength=\"199\">\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"528\">&nbsp;</TD>\n    </TR>\n</TBODY>\n</TABLE>\n<BR>\n<BR>\n</DIV>\n</DIV>\n</DIV>\n</FORM>\n\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
