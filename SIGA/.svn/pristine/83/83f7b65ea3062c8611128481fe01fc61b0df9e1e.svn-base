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


public class _TipoAsunto extends com.orionserver.http.OrionHttpJspPage {


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
    _TipoAsunto page = this;
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
      
      		String recCreador[][] 		= null;
      		String recTipoAsunto[][]	= null;
      		String strIdTipoAsunto 		= "";
      		String strIdArea 			= "";
      		String strNombreTipoAsunto 	= "";
      		String strCreador 			= "";
      		String strCreador1 			= "";
      		String strFechaCreacion 	= "";
      		String strFechaCreacion2 	= "";
      		String strAccion 			= "";
      		String strEstatus 			= "1";
      
      		String retURI = (request.getParameter("retURI")== null)?"TipoAsuntoView.jsp":request.getParameter("retURI");
      		String strAux = "1a2b3c", strAux2 = "1a2b3c";
      		int valida = -2;
      
      		boolean bInsertar = false;
      		boolean bActualizar = false;
      		boolean b = false;
      
      		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
      		//java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-mm-dd");
      		java.util.Date f = new java.util.Date();
      		strFechaCreacion = sdf.format(f);
      		strFechaCreacion2 = strFechaCreacion;
      
      		strCreador1	=	BUsuario.getIdUsuario();
      		strCreador	=	ActualizaUsuario.NombreUsuario(strCreador1);
      		strAccion 	= 	request.getParameter("accion");
      		
      		if (strAccion != null && strAccion.equals("consultar")) {
      			strIdTipoAsunto = request.getParameter("TipoAsunto_idTipoAsunto");
      			if (strIdTipoAsunto != null) {
      				recTipoAsunto 		= ActualizaTipoAsunto.getTipoAsunto(strIdTipoAsunto);
      				strIdArea 			= recTipoAsunto[0][0];
      				strNombreTipoAsunto	= recTipoAsunto[0][1];
      				strCreador			= ActualizaUsuario.NombreUsuario(recTipoAsunto[0][2]);
      				strFechaCreacion2 	= recTipoAsunto[0][3];
      
      				strAux = strNombreTipoAsunto;
      				strAux2 = strIdArea;
      			}
      		}
      		if (strAccion != null && strAccion.equals("cambiar")) {
      			strIdTipoAsunto = request.getParameter("TipoAsunto_idTipoAsunto");
      			if (strIdTipoAsunto != null) { 
      				strIdArea 				= request.getParameter("TipoAsunto_area");
      				strNombreTipoAsunto 	= request.getParameter("TipoAsunto_Nombre");
      				
      				strAux 	= request.getParameter("aux");
      				strAux2 = request.getParameter("aux2");
      
      				valida = ActualizaTipoAsunto.getTipoAsuntoExiste(strNombreTipoAsunto, strAux, strIdArea, strAux2);	
      
      				if (valida == 2){
      					
      					String [][] datos = ActualizaTipoAsunto.getTipoAsunto(strIdTipoAsunto);
      					bInsertar 				= ActualizaTipoAsunto.ActualizarTipoAsunto(strIdTipoAsunto,
      										strIdArea, strNombreTipoAsunto, strCreador1, strFechaCreacion);
      					b = ActualizaBitacora.InsertarEventoCambioTipoAsu(BUsuario.getIdUsuario(),strNombreTipoAsunto,strIdArea,strIdTipoAsunto,datos);
      					try{
      						//response.sendRedirect("TipoAsuntoView.jsp");
      						response.sendRedirect(retURI);
      					}catch(java.io.IOException io){
      						//System.err.println("Error ReDirección->"+io);
      					}
      				}
      			}
      		}
      
      		if (strAccion != null && strAccion.equals("guardar")) {
      			strIdArea 			= request.getParameter("TipoAsunto_area");
      			strNombreTipoAsunto = request.getParameter("TipoAsunto_Nombre"); 
      
      			valida = ActualizaTipoAsunto.getTipoAsuntoExiste(strNombreTipoAsunto, strAux, strIdArea, strAux2);	
      
      			if (valida == 2){
      				bInsertar 			= ActualizaTipoAsunto.InsertarTipoAsunto(strIdArea, strNombreTipoAsunto,
      										strCreador1, strFechaCreacion, strEstatus);
      				b = ActualizaBitacora.InsertarEventoAltaTipoAsu(BUsuario.getIdUsuario(),strNombreTipoAsunto,strIdArea);
      				try{
      					//response.sendRedirect("TipoAsuntoView.jsp");
      					response.sendRedirect(retURI);
      				}catch(java.io.IOException io){
      					//System.err.println("Error ReDirección->"+io);
      				}
      			}
      			//strIdArea 			= ""; 
      			//strNombreTipoAsunto = "";
      		}
      		//recCreador  = ActualizaUsuario.getUsuario(strCreador1);
      		//strCreador	= recCreador[0][0];
      		//if(strAccion!=null && (strAccion.equals("cambiar") || strAccion.equals("guardar")))
      		//{
      		//	strAccion 			= "";
      
      out.write(__oracle_jsp_text[10]);
       if(strIdTipoAsunto!=null && strIdTipoAsunto.length()!=0){ 
      out.write(__oracle_jsp_text[11]);
       if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ 
      out.write(__oracle_jsp_text[12]);
       }else{ 
      out.write(__oracle_jsp_text[13]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[14]);
       } 
      out.write(__oracle_jsp_text[15]);
       } 
      out.write(__oracle_jsp_text[16]);
      out.print( strAccion );
      out.write(__oracle_jsp_text[17]);
      out.print(strIdTipoAsunto);
      out.write(__oracle_jsp_text[18]);
      out.print(strAux);
      out.write(__oracle_jsp_text[19]);
      out.print(strAux2);
      out.write(__oracle_jsp_text[20]);
      out.print(retURI);
      out.write(__oracle_jsp_text[21]);
      out.print( retURI );
      out.write(__oracle_jsp_text[22]);
      out.print((strIdTipoAsunto!=null && !strIdTipoAsunto.equals(""))?"última Modificación por: ":"Creado por: ");
      out.print( strCreador );
      out.write(__oracle_jsp_text[23]);
      out.print( strFechaCreacion2 );
      out.write(__oracle_jsp_text[24]);
       if(BUsuario.getSupervisor()){ 
      				if(strIdTipoAsunto==null){
      					strIdArea = BUsuario.getIdArea();
      				} 
      			
      out.write(__oracle_jsp_text[25]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_1.setName("TipoAsunto_area");
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
      out.write(__oracle_jsp_text[26]);
       }else{ 
      out.write(__oracle_jsp_text[27]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getAreasComboAll());
        __jsp_taghandler_2.setName("TipoAsunto_area");
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
      out.write(__oracle_jsp_text[28]);
       } 
      out.write(__oracle_jsp_text[29]);
      if (valida == 1) {
      out.write(__oracle_jsp_text[30]);
      } 
      out.write(__oracle_jsp_text[31]);
      out.print(strNombreTipoAsunto);
      out.write(__oracle_jsp_text[32]);

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
  private static final char __oracle_jsp_text[][]=new char[33][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Tipo de Asunto</TITLE>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    " \n".toCharArray();
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
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\n<!-- <SCRIPT language=JavaScript type=text/javascript>\n\tlocation.assign(\"TipoAsuntoView.jsp\");\n</SCRIPT> -->\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<STYLE type=\"text/css\">\n</STYLE>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"valida=0;timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"TipoAsunto.jsp\" name=\"TipoAsunto\" method=\"post\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"accion\"> \n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"TipoAsunto_idTipoAsunto\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"aux\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\" name=\"aux2\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\" name=\"retURI\">\n\n<DIV align=\"center\">\n<BR>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\"><A href=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"\n\t\t\t\talt=\"Regresar\"> </A>\n\t\t\t\t<a onclick=\"guardar()\">\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\">\n\t\t\t\t</a>\n\t\t\t</TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"20%\"><B><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\"><FONT size=\"+1\" color=\"#004080\">Tipo de Asunto</FONT></FONT></B></TD>\n\t\t\t<TD width=\"80%\" align=\"right\">&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD colspan=\"2\" ></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD colspan=\"2\" ></TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\"><I>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    " - ".toCharArray();
    __oracle_jsp_text[24] = 
    "</I></FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><BR>\n\t\t\t<BR>\n\t\t\t&nbsp;</TD>\n\t\t\t<TD width=\"528\" align=\"right\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Unidad\n\t\t\tAdministrativa:</B></FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t<TD width=\"528\"><FONT face=\"Verdana\" size=\"2\">".toCharArray();
    __oracle_jsp_text[26] = 
    "</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t<TD width=\"528\"><FONT face=\"Verdana\" size=\"2\">".toCharArray();
    __oracle_jsp_text[28] = 
    "</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Tipo\n\t\t\tde Asunto:</B></FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "<br>\n\t\t\t<FONT color=\"red\"><B>*Este Tipo de Asunto ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"528\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue600a\"\n\t\t\t\tname=\"TipoAsunto_Nombre\" value=\"".toCharArray();
    __oracle_jsp_text[32] = 
    "\" maxlength=\"199\"></FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<BR>\n</FORM>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n<!-- \n\n\nfunction guardar() { \n\tvar doc = document.TipoAsunto\n\t//var valida = 0;\n\tvar msg=\"\";\n\n\n//\tif (valida != 1)\t{\n\t\tmensaje = 'Algunos de los campos tienen caracteres invalidos (&, \", <, >, \\' )\\nPresione Aceptar para eliminarlos automaticamente\\no Cancelar para regresar'\n\t\tif(detectaCE(doc.TipoAsunto_Nombre.value)){\n\t\t\tif (confirm(mensaje)){\n\n\t\t\t\tdoc.TipoAsunto_Nombre.value\t= quitaCE(doc.TipoAsunto_Nombre.value);\n\t\n\t\t\t\tdoc.aux.value\t= quitaCE(doc.aux.value);\n\t\t\t\t\n\t\t\t\tif(doc.TipoAsunto_idTipoAsunto.value != \"\")\n\t\t\t\t\tdoc.accion.value=\"cambiar\";\n\t\t\t\tif(doc.TipoAsunto_idTipoAsunto.value == \"\")\n\t\t\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\t\tdoc.submit();\n\t\t\t}\n\t\t\telse \n\t\t\t\tdoc.accion.value=\"\";\n\t\t}\n\t\telse{\n\t\t\tif(doc.TipoAsunto_idTipoAsunto.value != \"\")\n\t\t\t\tdoc.accion.value=\"cambiar\";\n\t\t\tif(doc.TipoAsunto_idTipoAsunto.value == \"\")\n\t\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\tdoc.submit();\n\t\t}\n//\t}\n\tif (doc.TipoAsunto_area[doc.TipoAsunto_area.selectedIndex].value == -1) {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes seleccionar un área\t\"+ \"\\n\";\n\t}\n\tif (Trim(doc.TipoAsunto_Nombre.value) ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debe capturar el Tipo de Asunto\"+ \"\\n\";\n\t}\n\tif (Trim(quitaPuntos(doc.TipoAsunto_Nombre.value)) ==\"\" && doc.TipoAsunto_Nombre.value!=\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" El Tipo de Asunto no es válido\"+ \"\\n\";\n\t}\n\tif (valida == 1) \n\t{\n\t\talert(msg);\n\t\tvalida=0;\n\t\treturn false;\n\t}else if(valida == 2){\n\t\talert(\"Su solicitud ya fue enviada\");\n\t\treturn false;\n\t}else{\n\t\tvalida=2;\n\t\tdoc.submit();\n\t}\n}\n</SCRIPT>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
