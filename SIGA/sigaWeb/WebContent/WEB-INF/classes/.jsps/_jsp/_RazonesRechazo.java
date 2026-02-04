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


public class _RazonesRechazo extends com.orionserver.http.OrionHttpJspPage {


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
    _RazonesRechazo page = this;
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
      out.write(__oracle_jsp_text[5]);
      
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
      
      
      out.write(__oracle_jsp_text[6]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[7]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[8]);
       } 
      out.write(__oracle_jsp_text[9]);
      
      		String recCreador[][] 	= null;
      		String recRazon[][]		= null;
      		String strIdRazon 		= "";
      		String strDescripcion	= "";
      		String strIdArea 		= "";
      		String strCreador 			= "";
      		String strCreador1 			= "";
      		String strFechaCreacion 	= "";
      		String strFechaCreacion2 	= "";
      		String strAccion 			= "";
      		String strEstatus 			= "1";
      
      		String retURI = (request.getParameter("retURI")== null)?"RazonesRechazoView.jsp":request.getParameter("retURI");
      		String strAux = "1a2b3c", strAux2 = "1a2b3c";
      		int valida = -2;
      
      		boolean bInsertar = false;
      		boolean bActualizar = false;
      
      		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
      		java.util.Date f = new java.util.Date();
      		strFechaCreacion = sdf.format(f);
      		strFechaCreacion2 	=	strFechaCreacion;
      		
      		strCreador1	=	BUsuario.getIdUsuario();
      		strCreador	=	ActualizaUsuario.NombreUsuario(strCreador1);
      		strAccion 	= request.getParameter("accion");
      
      		if (strAccion != null && strAccion.equals("consultar")) {
      			strIdRazon = request.getParameter("Razon_IdRazon");
      			
      			if (strIdRazon != null) {
      				recRazon 		= ActualizaRazonRechazo.getRazonRechazo(strIdRazon);
      				strIdArea 		= recRazon[0][0];
      				strDescripcion	= recRazon[0][1];
      				strCreador		=	ActualizaUsuario.NombreUsuario(recRazon[0][2]);
      				strFechaCreacion2 = recRazon[0][3];
      
      				strAux = strDescripcion;
      				strAux2 = strIdArea;
      			}
      		}
      		if (strAccion != null && strAccion.equals("cambiar")) {
      			strIdRazon = request.getParameter("Razon_IdRazon");
      			
      			if (strIdRazon != null) {
      				strDescripcion	= request.getParameter("Razon_Descripcion");
      				strIdArea 		= request.getParameter("Razon_Area");
      
      				strAux 		= request.getParameter("aux");
      				strAux2 	= request.getParameter("aux2");
      
      				valida = ActualizaRazonRechazo.getRazonExiste(strDescripcion, strAux, strIdArea, strAux2);	
      
      				if (valida == 2){
      					String datos[][] = ActualizaRazonRechazo.getRazonRechazo(strIdRazon);
      					bInsertar 				= ActualizaRazonRechazo.ActualizarRazonRechazo(strIdRazon,
      							strIdArea, strDescripcion, strCreador1, strFechaCreacion);
      					boolean c = ActualizaBitacora.InsertarEventoCambioRazon(BUsuario.getIdUsuario(),strDescripcion,strIdArea,strIdRazon,datos);
      				}
      			}
      		}
      
      		if (strAccion != null && strAccion.equals("guardar")) {
      			strDescripcion	= request.getParameter("Razon_Descripcion");
      			strIdArea 		= request.getParameter("Razon_Area");
      
      			valida = ActualizaRazonRechazo.getRazonExiste(strDescripcion, strAux, strIdArea, strAux2);	
      
      			if (valida == 2){
      				bInsertar 			= ActualizaRazonRechazo.InsertarRazonRechazo(strIdArea, strDescripcion,
      										strCreador1, strFechaCreacion, strEstatus);
      				boolean c = ActualizaBitacora.InsertarEventoAltaRazon(BUsuario.getIdUsuario(),strDescripcion,strIdArea);
      				strIdArea		= ""; 
      				strDescripcion 	= "";
      			}
      		}
      		//recCreador  = ActualizaUsuario.getUsuario(strCreador1);
      		//strCreador	= recCreador[0][0];
      		if(strAccion!=null && (strAccion.equals("cambiar") || strAccion.equals("guardar")) && bInsertar)
      		{
      			strAccion 			= "";
      
      out.write(__oracle_jsp_text[10]);
      out.print( retURI );
      out.write(__oracle_jsp_text[11]);
      
      		}
      
      out.write(__oracle_jsp_text[12]);
       if(strIdRazon!=null && strIdRazon.length()!=0){ 
      out.write(__oracle_jsp_text[13]);
       if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ 
      out.write(__oracle_jsp_text[14]);
       }else{ 
      out.write(__oracle_jsp_text[15]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[16]);
       } 
      out.write(__oracle_jsp_text[17]);
       } 
      out.write(__oracle_jsp_text[18]);
      out.print(strIdRazon);
      out.write(__oracle_jsp_text[19]);
      out.print(strAux);
      out.write(__oracle_jsp_text[20]);
      out.print(strAux2);
      out.write(__oracle_jsp_text[21]);
      out.print(retURI);
      out.write(__oracle_jsp_text[22]);
      out.print( retURI );
      out.write(__oracle_jsp_text[23]);
      out.print((strIdRazon!=null && !strIdRazon.equals(""))?"última Modificación por: ":"Creado por: ");
      out.print( strCreador);
      out.write(__oracle_jsp_text[24]);
      out.print( strFechaCreacion2);
      out.write(__oracle_jsp_text[25]);
       if(BUsuario.getSupervisor()){
      				if(strIdRazon.equals("")){
      					strIdArea = BUsuario.getIdArea();
      				}  
      out.write(__oracle_jsp_text[26]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_1.setName("Razon_Area");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_1.setClassHtml("blue600a");
        __jsp_taghandler_1.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_1.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[27]);
       }else{ 
      out.write(__oracle_jsp_text[28]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getAreasComboAll());
        __jsp_taghandler_2.setName("Razon_Area");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_2.setClassHtml("blue600a");
        __jsp_taghandler_2.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_2.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
        __jsp_taghandler_2.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[29]);
       } 
      out.write(__oracle_jsp_text[30]);
      if (valida == 1) {
      out.write(__oracle_jsp_text[31]);
      } 
      out.write(__oracle_jsp_text[32]);
      out.print(strDescripcion);
      out.write(__oracle_jsp_text[33]);

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
  private static final char __oracle_jsp_text[][]=new char[34][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Razones de Rechazo</TITLE>\n".toCharArray();
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
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n<SCRIPT language=JavaScript type=text/javascript>\n\tlocation.assign(\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\");\n</SCRIPT>\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<STYLE type=\"text/css\">\n</STYLE>\n<SCRIPT language=JavaScript type=text/javascript>\n\t\n\tfunction limpiarCampos(){\n\t\tdocument.RazonesRechazo.reset();\n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"valida=0;timer_load();limpiarCampos();\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"RazonesRechazo.jsp\" name=\"RazonesRechazo\" method=\"post\">\n<INPUT type=hidden value=\"guardar\" name=\"accion\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"Razon_IdRazon\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\" name=\"aux\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\" name=\"aux2\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\" name=\"retURI\">\n<DIV align=\"center\">\n<BR>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\"><A href=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"\n\t\t\t\talt=\"Regresar\"> </A>\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<a onclick=\"guardar()\">\n\t\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\">\n\t\t\t\t</a>\n\t\t\t</TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"25%\"><B><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\"><FONT size=\"+1\" color=\"#004080\">Razones de Rechazo</FONT></FONT></B></TD>\n\t\t\t<TD width=\"75%\" align=\"right\">&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD colspan=\"2\" ></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD colspan=\"2\" ></TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD ><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t<TD align=\"right\"><FONT face=\"Verdana\" size=\"2\"><I>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    " - ".toCharArray();
    __oracle_jsp_text[25] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><BR>\n\t\t\t<BR>\n\t\t\t</TD>\n\t\t\t<TD width=\"528\" align=\"right\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Unidad\n\t\t\tAdministrativa:</B></FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t<TD width=\"528\"><FONT face=\"Verdana\" size=\"2\">".toCharArray();
    __oracle_jsp_text[27] = 
    "</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t<TD width=\"528\"><FONT face=\"Verdana\" size=\"2\">".toCharArray();
    __oracle_jsp_text[29] = 
    "</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\" align=\"right\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Descripción:</B></FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "<br>\n\t\t\t<FONT color=\"red\"><B>*Esta Descripción ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"528\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t<INPUT class=\"blue600a\" name=\"Razon_Descripcion\"  value=\"".toCharArray();
    __oracle_jsp_text[33] = 
    "\" maxlength=\"200\">\n\t\t\t</FONT>\t\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"></TD>\n\t\t\t<TD width=\"528\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<BR>\n</FORM>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\"><!-- \nfunction guardar() { \n\tvar doc = document.RazonesRechazo\n\t//var valida = 0;\n\tvar msg=\"\";\n\n//\tif (valida != 1)\t{\n\t\tmensaje = 'Algunos de los campos tienen caracteres invalidos (&, <, >, \\', \", `,  ´)\\nPresione Aceptar para eliminarlos automaticamente\\no Cancelar para regresar'\n\t\tif(detectaCE(doc.Razon_Descripcion.value)){\n\t\t\tif (confirm(mensaje)){\n\n\t\t\t\tdoc.Razon_Descripcion.value\t= quitaCE(doc.Razon_Descripcion.value);\n\t\n\t\t\t\tdoc.aux.value\t= quitaCE(doc.aux.value);\n\t\t\t\t\n\t\t\t\tif(doc.Razon_IdRazon.value != \"\")\n\t\t\t\t\tdoc.accion.value=\"cambiar\";\n\t\t\t\tif(doc.Razon_IdRazon.value == \"\")\n\t\t\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\t\tdoc.submit();\n\t\t\t}\n\t\t\telse \n\t\t\t\tdoc.accion.value=\"\";\n\t\t}\n\t\telse{\n\t\t\tif(doc.Razon_IdRazon.value != \"\")\n\t\t\t\tdoc.accion.value=\"cambiar\";\n\t\t\tif(doc.Razon_IdRazon.value == \"\")\n\t\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\tdoc.submit();\n\t\t}\n//\t}\n\tif (doc.Razon_Area[doc.Razon_Area.selectedIndex].value == -1) {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes seleccionar una Unidad\t\"+ \"\\n\";\n\t}\n\tif (Trim(doc.Razon_Descripcion.value) ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debe capturar la Descripción de la Razon de Rechazo\"+ \"\\n\";\n\t}\n\tif (Trim(quitaPuntos(doc.Razon_Descripcion.value)) ==\"\" && doc.Razon_Descripcion.value!=\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" La Descripción de la Razon de Rechazo no es válida\"+ \"\\n\";\n\t}\n\tif (valida == 1) \n\t{\n\t\talert(msg);\n\t\tvalida=0;\n\t\treturn false;\n\t}else if(valida == 2){\n\t\talert(\"Su solicitud ya fue enviada\");\n\t\treturn false;\n\t}else{\n\t\tvalida=2;\n\t\tdoc.submit();\n\t}\n}\n</SCRIPT>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
