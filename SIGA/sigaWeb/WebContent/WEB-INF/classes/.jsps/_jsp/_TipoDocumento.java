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


public class _TipoDocumento extends com.orionserver.http.OrionHttpJspPage {


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
    _TipoDocumento page = this;
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
      		catch(java.io.IOException io){;}
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
      
      	String strTipo_Doc		=	"";
      	String strIdArea		=	"";
      	String strTipo_DocClave	=	"";
      	String strCreador		=	"";
      	String strCreador1		=	"";		
      	String strFechaCreacion	=	"";
      	String strFechaCreacion2=	"";
      	String strConsecutivo	=	"";//nuevo
      	String strAccion		=	"";
      	String strEstatus		=	"1";
      	String strTipos_Doc[][]	=	null;
      	String strIdTipo_Doc	=	"";
      	String strConfFolio		=	application.getInitParameter("genFolio");
      
      	String retURI = (request.getParameter("retURI")== null)?"TipoDocumentoView.jsp":request.getParameter("retURI");
      	String strAux = "1a2b3c", strAux2 = "1a2b3c";
      	int valida = -2;
      
      	boolean bInsertar		=	false;
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFechaCreacion 				=	sdf.format(f);
      	strFechaCreacion2 				=	strFechaCreacion;
      
      	strCreador1		=	BUsuario.getIdUsuario();
      	strCreador		=	ActualizaUsuario.NombreUsuario(strCreador1);
      	strIdTipo_Doc	=	request.getParameter("id_tipo_doc");
      	strAccion		=	request.getParameter("accion");
      	
      	if(strIdTipo_Doc != null)
      	{
      		strTipos_Doc=ActualizaTipo_Doc.getTipos_Doc(strIdTipo_Doc);
      		strTipo_Doc=strTipos_Doc[0][0];		
      		strIdArea=strTipos_Doc[0][1];
      		strTipo_DocClave=strTipos_Doc[0][2];
      		strConsecutivo = strTipos_Doc[0][3];//nuevo
      
      		strCreador 			= ActualizaUsuario.NombreUsuario(strTipos_Doc[0][4]);
      		strFechaCreacion2	= strTipos_Doc[0][5];
      
      		strAux = strTipo_DocClave;
      		strAux2 = strIdArea;
      	} 
      		
      	if(strAccion != null && strAccion.equals("guardar"))
      	{
      		strTipo_Doc		=	request.getParameter("tipo_doc");
      		strIdArea		=	request.getParameter("tipo_docArea");
      		strTipo_DocClave	=	request.getParameter("cveTipoDoc");
      		if(strConfFolio.equals("1"))
      			strConsecutivo	=	request.getParameter("cveConsecutivo"); 
      		else
      			strConsecutivo 	=	"0";
      		
      		valida = ActualizaTipo_Doc.getTipoDocExiste(strTipo_DocClave, strAux, strIdArea, strAux2);	
      
      		if (valida == 2){
      			bInsertar	=	ActualizaTipo_Doc.InsertarTipo_Doc(	strIdTipo_Doc, strTipo_Doc, 
      																strIdArea, strTipo_DocClave,
      																strCreador1, strFechaCreacion, 
      																strEstatus, strConsecutivo);
      	
      out.write(__oracle_jsp_text[9]);
      out.print( retURI );
      out.write(__oracle_jsp_text[10]);
      
      		}
      	}
      
      out.write(__oracle_jsp_text[11]);
       if(strIdTipo_Doc!=null && strIdTipo_Doc.length()!=0){ 
      out.write(__oracle_jsp_text[12]);
       if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ 
      out.write(__oracle_jsp_text[13]);
       }else{ 
      out.write(__oracle_jsp_text[14]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[15]);
       } 
      out.write(__oracle_jsp_text[16]);
       } 
      out.write(__oracle_jsp_text[17]);
      if(strConfFolio.equals("1")){
      out.write(__oracle_jsp_text[18]);
      }
      out.write(__oracle_jsp_text[19]);
      if (strIdTipo_Doc!=null){ 
      out.write(__oracle_jsp_text[20]);
      out.print(strIdTipo_Doc );
      out.write(__oracle_jsp_text[21]);
      }
      out.write(__oracle_jsp_text[22]);
      out.print(strAux );
      out.write(__oracle_jsp_text[23]);
      out.print(strAux2 );
      out.write(__oracle_jsp_text[24]);
      out.print(retURI );
      out.write(__oracle_jsp_text[25]);
      out.print( retURI );
      out.write(__oracle_jsp_text[26]);
      out.print((strIdTipo_Doc!=null && !strIdTipo_Doc.equals(""))?"última Modificación por: ":"Creado por: ");
      out.write(__oracle_jsp_text[27]);
      out.print( strCreador );
      out.write(__oracle_jsp_text[28]);
      out.print( strFechaCreacion2 );
      out.write(__oracle_jsp_text[29]);
       if(BUsuario.getSupervisor()){ 
      					if(strIdTipo_Doc==null){
      						strIdArea = BUsuario.getIdArea();
      					} 
      			
      out.write(__oracle_jsp_text[30]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_1.setName("tipo_docArea");
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
      out.write(__oracle_jsp_text[31]);
       }else{ 
      out.write(__oracle_jsp_text[32]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getAreasComboAll());
        __jsp_taghandler_2.setName("tipo_docArea");
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
      out.write(__oracle_jsp_text[33]);
       } 
      out.write(__oracle_jsp_text[34]);
      out.print(strTipo_Doc );
      out.write(__oracle_jsp_text[35]);
      if (valida == 1) {
      out.write(__oracle_jsp_text[36]);
      } 
      out.write(__oracle_jsp_text[37]);
      out.print(strTipo_DocClave );
      out.write(__oracle_jsp_text[38]);
       if(strConfFolio.equals("1")){ 
      out.write(__oracle_jsp_text[39]);
      out.print(strConsecutivo );
      out.write(__oracle_jsp_text[40]);
       } 
      out.write(__oracle_jsp_text[41]);

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
  private static final char __oracle_jsp_text[][]=new char[42][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Tipo de Documento</TITLE>\n".toCharArray();
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
    "\n<SCRIPT language=JavaScript type=text/javascript>\n{\n\tlocation.assign('".toCharArray();
    __oracle_jsp_text[10] = 
    "');\n}\n</SCRIPT>\n".toCharArray();
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
    "\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript>\n<!-- \n\nfunction guardar() { \n\n\tdoc = document.TipoDoc;\n\t\n\tmsg=\"\";\n\n\t\tmensaje = 'Algunos de los campos tienen caracteres invalidos (&, \", <, >, \\' )\\nPresione Aceptar para eliminarlos automaticamente\\no Cancelar para regresar'\n\t\tif(detectaCE(doc.tipo_doc.value) || detectaCE(doc.cveTipoDoc.value)){\n\t\t\tif (confirm(mensaje)){\n\n\t\t\t\tdoc.tipo_doc.value\t\t= quitaCE(doc.tipo_doc.value);\n\t\t\t\tdoc.cveTipoDoc.value\t= quitaCE(doc.cveTipoDoc.value);\n\t\t\t\tdoc.aux.value\t= quitaCE(doc.aux.value);\n\n\t\t\t\tdoc.accion.value=\"guardar\";\n\t\t\t}\n\t\t\telse \n\t\t\t\tdoc.accion.value=\"\";\n\t\t}\n\t\telse{\n\t\t\tdoc.accion.value=\"guardar\";\n\t\t}\n\tif (doc.tipo_docArea[doc.tipo_docArea.selectedIndex].value == -1) {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes seleccionar una Unidad\t\"+ \"\\n\";\n\t}\n\tif(Trim(doc.tipo_doc.value) == \"\"){\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes capturar el nombre del Tipo de Documento\t\"+ \"\\n\";\n\t}\n\tif(Trim(doc.cveTipoDoc.value) == \"\"){\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes capturar la clave del Tipo de Documento\t\"+ \"\\n\";\n\t}\n\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\tif(Trim(doc.cveConsecutivo.value) == \"\"){\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes capturar un Consecutivo al Tipo de Documento\t\"+ \"\\n\";\n\t}\n\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\tif (Trim(quitaPuntos(doc.tipo_doc.value)) ==\"\" && doc.tipo_doc.value!=\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" El Tipo de Documento no es válido\"+ \"\\n\";\n\t}\n\tif (Trim(quitaPuntos(doc.cveTipoDoc.value)) ==\"\" && doc.cveTipoDoc.value!=\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" La Clave de Tipo de Documento no es válida\"+ \"\\n\";\n\t}\n\tif (Trim(quitaPuntos(doc.cveConsecutivo.value)) ==\"\" && doc.cveConsecutivo.value!=\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" El Cosecutivo al Tipo de Documento no es válido\"+ \"\\n\";\n\t}\n\tif (valida == 1) \n\t{\n\t\talert(msg);\n\t\tvalida=0;\n\t\treturn false;\n\t}else if(valida == 2){\n\t\talert(\"Su solicitud ya fue enviada\");\n\t\treturn false;\n\t}else{\n\t\tvalida=2;\n\t\tdoc.submit();\n\t}\n\n}\n\nfunction limpiarCampos(){\n\tdocument.TipoDoc.reset();\n}\n\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"valida=0;timer_load();limpiarCampos();\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\"\n\tonmousemove=\"validaSoloNumeros(document.TipoDoc.cveConsecutivo,'Consecutivo');\">\n<FORM action=\"TipoDocumento.jsp\" name=\"TipoDoc\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n".toCharArray();
    __oracle_jsp_text[20] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\" name=\"id_tipo_doc\">\n".toCharArray();
    __oracle_jsp_text[22] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\" name=\"aux\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[24] = 
    "\" name=\"aux2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[25] = 
    "\" name=\"retURI\">\n\n<DIV class=\"documentBody\" id=\"Body\" style=\"HEIGHT: 441px\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\n\t<TR valign=\"top\">\n\t\t<TD colspan=\"2\">\n\t\t\t<a href=\"".toCharArray();
    __oracle_jsp_text[26] = 
    "\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\">\n\t\t\t</a>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<a onclick=\"guardar()\">\n\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\">\n\t\t\t</a>\n\t\t</TD>\n    </TR>\n\n        <TR valign=\"top\">\n            <TD width=\"30%\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\"><FONT\n\t\t\t\tsize=\"+1\" color=\"#004080\">Tipo de Documento</FONT></FONT></B></TD>\n            <TD width=\"70%\" align=\"right\">&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n        </TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD colspan=\"2\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD colspan=\"2\"></TD>\n\t\t</TR>\n\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT>\n\t\t</TD>\n\t\t<TD width=\"528\" align=\"right\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "<I>".toCharArray();
    __oracle_jsp_text[28] = 
    " - ".toCharArray();
    __oracle_jsp_text[29] = 
    "</I></FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><BR>\n\t\t\t<BR>\n\t\t\t&nbsp;</TD>\n\t\t<TD width=\"528\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Unidad\n\t\t\tAdministrativa:</B></FONT></TD>\n\t\t<TD width=\"528\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"528\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Tipo de Documento:</B></FONT></TD>\n\t\t<TD width=\"528\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"tipo_doc\"  value=\"".toCharArray();
    __oracle_jsp_text[35] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"528\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Clave del Documento:</B></FONT>\n\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "<br>\n\t\t<FONT color=\"red\"><B>*Esta Clave ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t</TD>\n\t\t<TD width=\"528\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"cveTipoDoc\"  value=\"".toCharArray();
    __oracle_jsp_text[38] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"528\">&nbsp;</TD>\n    </TR>\n\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Consecutivo:</B></FONT></TD>\n\t\t<TD width=\"528\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t<INPUT class=\"blue50a\" size=\"80\" name=\"cveConsecutivo\" value=\"".toCharArray();
    __oracle_jsp_text[40] = 
    "\" onKeyPress='AceptaSoloTeclaNumericaYPunto();' maxlength=\"5\"></FONT></TD>\n    </TR>\n\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n    </TBODY>\n</TABLE>\n</DIV>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
