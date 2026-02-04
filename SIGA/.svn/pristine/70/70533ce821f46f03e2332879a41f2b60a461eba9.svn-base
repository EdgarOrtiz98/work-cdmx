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


public class _Entidad extends com.orionserver.http.OrionHttpJspPage {


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
    _Entidad page = this;
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
      
      	String strEntidad		=	"";
      	String strIdArea		=	"";
      	String strEntidadClasificacion	=	"";
      	String strEntidadDireccion	=	"";
      	String strEntidadTel	=	"";
      	String strCreador		=	"";
      	String strCreador1		=	"";		
      	String strFechaCreacion	=	"";
      	String strFechaCreacion2=	"";
      	String strAccion		=	"";
      	String strEstatus		=	"1";
      	String strEntidades[][]		=	null;
      	String strIdEntidad		=	"";
      
      	String strAux = "1a2b3c", strAux2 = "1a2b3c";
      	int valida = -2;
      	String retURI = (request.getParameter("retURI")== null)?"EntidadView.jsp":request.getParameter("retURI");
      
      	boolean bInsertar		=	false;
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFechaCreacion 				=	sdf.format(f);
      	strFechaCreacion2 				=	strFechaCreacion;
      
      	strCreador1		=	BUsuario.getIdUsuario();
      	strCreador		=	ActualizaUsuario.NombreUsuario(strCreador1);
      	strIdEntidad	=	request.getParameter("id_entidad");
      	strAccion		=	request.getParameter("accion");
      	
      	if(strIdEntidad != null)
      	{
      		strEntidades			=	ActualizaEntidad.getEntidades(strIdEntidad);
      		strEntidad				=	strEntidades[0][0];
      		strIdArea				=	strEntidades[0][1];		
      		strEntidadClasificacion	=	strEntidades[0][2];
      		strEntidadDireccion		=	strEntidades[0][3];
      		strEntidadTel			=	strEntidades[0][4];
      		strCreador				=	ActualizaUsuario.NombreUsuario(strEntidades[0][5]);
      		strFechaCreacion2		=	strEntidades[0][6];
      		
      		strAux = strEntidad;
      		strAux2 = strIdArea;
      	}
      	
      	if(strAccion != null && strAccion.equals("guardar"))
      	{
      		strEntidad					=	request.getParameter("entidad");
      		strIdArea					=	request.getParameter("entidadArea");
      		strEntidadClasificacion		=	request.getParameter("entidadClasificacion");
      		strEntidadDireccion			=	request.getParameter("direccion");
      		strEntidadTel				=	request.getParameter("tel");
      		strAux						=	request.getParameter("aux");
      		strAux2						=	request.getParameter("aux2");
      
      		valida = ActualizaEntidad.getEntidadExiste(strEntidad, strAux, strIdArea, strAux2);
      
      		if (valida == 2){
      			bInsertar	=	ActualizaEntidad.InsertarEntidad(	strIdEntidad, strEntidad, strIdArea, strEntidadClasificacion,
      																strEntidadDireccion, strEntidadTel, 
      																strCreador1, strFechaCreacion, strEstatus);
      	
      			
      out.write(__oracle_jsp_text[9]);
      out.print( retURI );
      out.write(__oracle_jsp_text[10]);
      
      		}
      	}
      
      out.write(__oracle_jsp_text[11]);
       if(strIdEntidad!=null && strIdEntidad.length()!=0){ 
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
      if (strIdEntidad!=null){ 
      out.write(__oracle_jsp_text[18]);
      out.print(strIdEntidad );
      out.write(__oracle_jsp_text[19]);
      }
      out.write(__oracle_jsp_text[20]);
      out.print(strAux );
      out.write(__oracle_jsp_text[21]);
      out.print(strAux2 );
      out.write(__oracle_jsp_text[22]);
      out.print(retURI );
      out.write(__oracle_jsp_text[23]);
      out.print( retURI );
      out.write(__oracle_jsp_text[24]);
      out.print((strIdEntidad!=null && !strIdEntidad.equals(""))?"última Modificación por: ":"Creado por: ");
      out.write(__oracle_jsp_text[25]);
      out.print( strCreador );
      out.write(__oracle_jsp_text[26]);
      out.print( strFechaCreacion2 );
      out.write(__oracle_jsp_text[27]);
       if(BUsuario.getSupervisor()){
      				if(strIdEntidad==null){
      					strIdArea = BUsuario.getIdArea();
      				} 
      			
      out.write(__oracle_jsp_text[28]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_1.setName("entidadArea");
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
      out.write(__oracle_jsp_text[29]);
       }else{ 
      out.write(__oracle_jsp_text[30]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getAreasComboAll());
        __jsp_taghandler_2.setName("entidadArea");
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
      out.write(__oracle_jsp_text[31]);
       } 
      out.write(__oracle_jsp_text[32]);
      if (valida == 1) {
      out.write(__oracle_jsp_text[33]);
      } 
      out.write(__oracle_jsp_text[34]);
      out.print( strEntidad  );
      out.write(__oracle_jsp_text[35]);
      out.print((strEntidadClasificacion.trim().equals("Privada")?"selected":""));
      out.write(__oracle_jsp_text[36]);
      out.print((strEntidadClasificacion.trim().equals("Pública")?"selected":""));
      out.write(__oracle_jsp_text[37]);
      out.print( strEntidadDireccion  );
      out.write(__oracle_jsp_text[38]);
      out.print( strEntidadTel  );
      out.write(__oracle_jsp_text[39]);

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
  private static final char __oracle_jsp_text[][]=new char[40][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Entidad</TITLE>\n".toCharArray();
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
    "\n\t\t\t<SCRIPT language=JavaScript type=text/javascript>\n\t\t\t{\n\t\t\tlocation.assign('".toCharArray();
    __oracle_jsp_text[10] = 
    "');\n\t\t\t}\n\t\t\t</SCRIPT>\n\t\t\t".toCharArray();
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
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript>\n\nfunction guardar() { \n\n\tdoc = document.Entidad;\n\t\n\t//valida = 0;\n\tmsg=\"\";\n\tmensaje = 'Algunos de los campos tienen caracteres invalidos (&, \", <, >, \\')\\nPresione Aceptar para modificarlos automaticamente\\no Cancelar para regresar'\n//\telse \t{\n\t\tif(detectaCE(doc.entidad.value) || detectaCE(doc.direccion.value)){\n\t\t\tif (confirm(mensaje)){\n\n\t\t\t\tdoc.entidad.value\t=quitaCE(doc.entidad.value);\n\t\t\t\tdoc.direccion.value\t=quitaCE(doc.direccion.value);\n\t\t\t\tdoc.aux.value\t\t=quitaCE(doc.aux.value);\n\t\t\t\t\n\t\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\t\tdoc.submit();\n\t\t\t}\n\t\t\telse \n\t\t\t\tdoc.accion.value=\"\";\n\t\t}\n\t\telse{\n\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\tdoc.submit();\n\t\t}\n//\t}\n\tif (doc.entidadArea[doc.entidadArea.selectedIndex].value == -1) {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes seleccionar una Unidad\t\"+ \"\\n\";\n\t}\n\tif (Trim(doc.entidad.value) ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes capturar el nombre de la Entidad\t\"+ \"\\n\";\n\t}\n\tif (!isTelefono(Trim(doc.tel.value))) {\n\t\tvalida =1;\n\t\tmsg = msg + \" El Número de Teléfono es inválido\t\"+ \"\\n\";\n\t}\n\tif (Trim(quitaPuntos(doc.entidad.value)) ==\"\" && doc.entidad.value!=\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" El Nombre de la Entidad no es válido\"+ \"\\n\";\n\t}\n\tif (Trim(quitaPuntos(doc.direccion.value)) ==\"\" && doc.direccion.value!=\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" La Dirección no es válida\"+ \"\\n\";\n\t}\n\tif (valida == 1) \n\t{\n\t\talert(msg);\n\t\tvalida=0;\n\t\treturn false;\n\t}else if(valida == 2){\n\t\talert(\"Su solicitud ya fue enviada\");\n\t\treturn false;\n\t}else{\n\t\tvalida=2;\n\t\tdoc.submit();\n\t}\n}\n\nfunction limpiarCampos(){\n\tdocument.Entidad.reset();\n}\n\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\t\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"valida=0;timer_load();limpiarCampos();\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\"\n\tonMouseMove=\"limitaTextArea(document.Entidad.direccion,'Dirección','200')\">\n<FORM action=\"Entidad.jsp\" name=\"Entidad\" method=\"post\">\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"id_entidad\">\n".toCharArray();
    __oracle_jsp_text[20] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\" name=\"aux\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\" name=\"aux2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\" name=\"retURI\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"125\">\n\t\t\t<A href=\"".toCharArray();
    __oracle_jsp_text[24] = 
    "\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"></A>\n\t\t\t<a onclick=\"guardar()\">\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\">\n\t\t\t</a>\n\t\t</TD>\n\t\t<TD width=\"125\">\n\n\t\t</TD>\n\t\t<TD></TD>\n\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t<TD width=\"164\">&nbsp;</TD>\n    </TR>\n</TBODY>\n</TABLE>\n</DIV>\n\n<DIV align=\"center\">\n<BR>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t\t<TD colspan=\"2\"><B><FONT color=\"#004080\" size=\"0\"></FONT></B><FONT\n\t\t\t\tcolor=\"#00204f\" size=\"37777777777\"><B><FONT size=\"+1\"\n\t\t\t\tcolor=\"#004080\">Entidad</FONT></B></FONT></TD>\n\t\t\t\t<TD colspan=\"2\" align=\"right\">&nbsp;<FONT color=\"black\">**Los datos\tmarcados con negritas son obligatorios</FONT></TD>\n        </TR>\n<TR valign=\"top\">\n<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n        </TR>\n\n\t<TR valign=\"top\">\n\t\t<TD width=\"161\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT>\n\t\t</TD>\n\t\t<TD align=\"right\" colspan=\"3\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "<I>".toCharArray();
    __oracle_jsp_text[26] = 
    " - ".toCharArray();
    __oracle_jsp_text[27] = 
    "</I></FONT>\n\t\t</TD>\n\t</TR>\n\n<TR valign=\"top\">\n<TD width=\"161\"><BR>\n\t\t\t<BR></TD>\n<TD>&nbsp;</TD>\n<TD>&nbsp;</TD>\n<TD width=\"493\">&nbsp;</TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"161\"><FONT face=\"Verdana\" size=\"2\"> </FONT><FONT\n\t\t\t\tface=\"Verdana\" size=\"2\" color=\"#004080\"><B>Unidad Administrativa</B>:</FONT></TD>\n<TD colspan=\"3\">\n\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t</FONT>\n</TD>\n</TR>\n<TR valign=\"top\">\n<TD width=\"161\">&nbsp;</TD>\n<TD>&nbsp;</TD>\n<TD>&nbsp;</TD>\n<TD width=\"493\">&nbsp;</TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"161\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Entidad</B></FONT><FONT\n\t\t\t\tface=\"Verdana\" size=\"2\">:</FONT>\n".toCharArray();
    __oracle_jsp_text[33] = 
    " <br>\n<FONT color=\"red\"><B>*Esta Entidad ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[34] = 
    "\n</TD>\n<TD colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n<INPUT class=\"blue600a\" name=\"entidad\" onkeydown=\"\" value=\"".toCharArray();
    __oracle_jsp_text[35] = 
    "\" maxlength=\"199\"></FONT></TD>\n</TR>\n<TR valign=\"top\">\n<TD width=\"161\">&nbsp;</TD>\n<TD>&nbsp;</TD>\n<TD>&nbsp;</TD>\n<TD width=\"493\">&nbsp;</TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"161\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">Clasificación:</FONT></TD>\n<TD colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t<SELECT name=\"entidadClasificacion\" class=\"blue200a\">\n\t\t<OPTION value=\"Privada\" ".toCharArray();
    __oracle_jsp_text[36] = 
    ">Privada</OPTION>\n\t\t<OPTION value=\"Pública\" ".toCharArray();
    __oracle_jsp_text[37] = 
    ">Pública</OPTION>\n\t</SELECT>\n\t</FONT></TD>\n</TR>\n<TR valign=\"top\">\n<TD width=\"161\">&nbsp;</TD>\n<TD>&nbsp;</TD>\n<TD>&nbsp;</TD>\n<TD width=\"493\">&nbsp;</TD>\n        </TR>\n\n\n<TR valign=\"top\">\n<TD width=\"161\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">Dirección:</FONT></TD>\n<TD colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t<TEXTAREA class=\"blue600a\" rows=\"3\" name=\"direccion\"\n\t\tonKeyDown=\"limitaTextArea(document.Entidad.direccion,'Dirección','200')\">".toCharArray();
    __oracle_jsp_text[38] = 
    "</TEXTAREA> \n<!-- El campo esta delimitado a 500 caracteres -->\n</FONT></TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"161\">&nbsp;</TD>\n<TD>&nbsp;</TD>\n<TD>&nbsp;</TD>\n<TD width=\"493\">&nbsp;</TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"161\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">Teléfono:</FONT></TD>\n<TD colspan=\"3\"><FONT face=\"Arial\" size=\"2\"><INPUT class=\"blue600a\" name=\"tel\"  value=\"".toCharArray();
    __oracle_jsp_text[39] = 
    "\" maxlength=\"199\"></FONT></TD>\n        </TR>\n<TR valign=\"top\">\n<TD colspan=\"4\">&nbsp;</TD>\n        </TR>\n    </TBODY>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
