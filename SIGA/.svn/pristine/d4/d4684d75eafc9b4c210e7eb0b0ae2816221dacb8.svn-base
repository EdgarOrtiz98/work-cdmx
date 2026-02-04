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


public class _Prioridades extends com.orionserver.http.OrionHttpJspPage {


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
    _Prioridades page = this;
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
      
      	String strPrioridad		=	"";
      	String strIdArea		=	"";
      	String strHexagesimal	=	"";
      	String strCreador		=	"";
      	String strCreador1		=	"";		
      	String strFechaCreacion	=	"";
      	String strFechaCreacion2=	"";
      	String strAccion		=	"";
      	String strEstatus		=	"1";
      	String strPrioridades[][]		=	null;
      	String strIdPrioridad	=	"";
      
      	String retURI = (request.getParameter("retURI")== null)?"PrioridadesView.jsp":request.getParameter("retURI");
      	String strAux = "1a2b3c", strAux2 = "1a2b3c";
      	int valida = -2;
      	boolean bInsertar		=	false;
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFechaCreacion 				=	sdf.format(f);
      	strFechaCreacion2 				=	strFechaCreacion;
      
      	strCreador1		=	BUsuario.getIdUsuario();
      	strCreador		=	ActualizaUsuario.NombreUsuario(strCreador1);
      	strIdPrioridad	=	request.getParameter("id_prioridad");
      	strAccion		=	request.getParameter("accion");
      	
      	if(strIdPrioridad != null)
      	{
      		strPrioridades=ActualizaPrioridad.getPrioridades(strIdPrioridad);
      		strPrioridad=strPrioridades[0][0];		
      		strIdArea=strPrioridades[0][1];
      		strHexagesimal=strPrioridades[0][2];
      		strCreador = ActualizaUsuario.NombreUsuario(strPrioridades[0][3]);
      		strFechaCreacion2 = strPrioridades[0][4];
      
      		strAux = strPrioridad;
      		strAux2 = strIdArea;
      	} 
      	if(strAccion != null && strAccion.equals("guardar"))
      	{
      		strPrioridad	=	request.getParameter("prioridad");
      		strIdArea		=	request.getParameter("prioridadArea");
      		strHexagesimal	=	request.getParameter("prioridadHexa");
      
      		strAux	=	request.getParameter("aux");
      		strAux2	=	request.getParameter("aux2");
      
      		// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Prioridades
      		strPrioridad	=	(strPrioridad.length()<= 200) ? strPrioridad : strPrioridad.substring(0,200);
      
      		valida = ActualizaPrioridad.getPrioridadExiste(strPrioridad, strAux, strIdArea, strAux2);	
      
      		if (valida == 2){
      			bInsertar	=	ActualizaPrioridad.InsertarPrioridad(	strIdPrioridad, strPrioridad, strIdArea, strHexagesimal,
      																	strCreador1, strFechaCreacion, strEstatus);
      
      out.write(__oracle_jsp_text[9]);
      out.print( retURI );
      out.write(__oracle_jsp_text[10]);
      
      		}
      	}
      
      out.write(__oracle_jsp_text[11]);
       if(strIdPrioridad!=null && strIdPrioridad.length()!=0){ 
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
      if(strHexagesimal!=null){
      out.write(__oracle_jsp_text[18]);
      out.print(strHexagesimal);
      out.write(__oracle_jsp_text[19]);
      } else {
      out.write(__oracle_jsp_text[20]);
      }
      out.write(__oracle_jsp_text[21]);
      if (strIdPrioridad!=null){ 
      out.write(__oracle_jsp_text[22]);
      out.print(strIdPrioridad );
      out.write(__oracle_jsp_text[23]);
      }
      out.write(__oracle_jsp_text[24]);
      out.print(strAux );
      out.write(__oracle_jsp_text[25]);
      out.print(strAux2 );
      out.write(__oracle_jsp_text[26]);
      out.print(retURI );
      out.write(__oracle_jsp_text[27]);
      out.print( retURI );
      out.write(__oracle_jsp_text[28]);
      out.print((strIdPrioridad!=null && !strIdPrioridad.equals(""))?"última Modificación por: ":"Creado por: ");
      out.write(__oracle_jsp_text[29]);
      out.print( strCreador );
      out.write(__oracle_jsp_text[30]);
      out.print( strFechaCreacion2 );
      out.write(__oracle_jsp_text[31]);
       if(BUsuario.getSupervisor()){ 
      					if(strIdPrioridad==null){
      						strIdArea = BUsuario.getIdArea();
      					} 
      			
      out.write(__oracle_jsp_text[32]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_1.setName("prioridadArea");
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
      out.write(__oracle_jsp_text[33]);
       }else{ 
      out.write(__oracle_jsp_text[34]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getAreasComboAll());
        __jsp_taghandler_2.setName("prioridadArea");
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
      out.write(__oracle_jsp_text[35]);
       } 
      out.write(__oracle_jsp_text[36]);
      if (valida == 1) {
      out.write(__oracle_jsp_text[37]);
      } 
      out.write(__oracle_jsp_text[38]);
      out.print( strPrioridad  );
      out.write(__oracle_jsp_text[39]);
      out.print(strHexagesimal );
      out.write(__oracle_jsp_text[40]);

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
  private static final char __oracle_jsp_text[][]=new char[41][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Prioridades</TITLE>\n".toCharArray();
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
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript>\n\n\nfunction guardarPrioridad() { \n\n\tdoc = document.Prioridad;\n\t\n\t//valida = 0;\n\tmsg=\"\";\n\n//\telse \t{\n\t\tmensaje = 'Algunos de los campos tienen caracteres invalidos (&, \", <, >, \\' )\\nPresione Aceptar para eliminarlos automaticamente\\no Cancelar para regresar'\n\t\tif(detectaCE(doc.prioridad.value)){\n\t\t\tif (confirm(mensaje)){\n\n\t\t\t\tdoc.prioridad.value\t= quitaCE(doc.prioridad.value);\n\t\n\t\t\t\tdoc.aux.value\t= quitaCE(doc.aux.value);\n\t\t\t\t\n\t\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\t\tdoc.submit();\n\t\t\t}\n\t\t\telse \n\t\t\t\tdoc.accion.value=\"\";\n\t\t}\n\t\telse{\n\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\tdoc.submit();\n\t\t}\n//\t}\n\tif (doc.prioridadArea[doc.prioridadArea.selectedIndex].value == -1) {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes seleccionar una Unidad\t\"+ \"\\n\";\n\t}\n\tif (Trim(doc.prioridad.value) ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes capturar el nombre de la Prioridad\t\"+ \"\\n\";\n\t}\n\tif (Trim(doc.prioridadHexa.value) ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes seleccionar un Color para la Prioridad\t\"+ \"\\n\";\n\t}\n\tif (Trim(quitaPuntos(doc.prioridad.value)) ==\"\" && doc.prioridad.value!=\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" La Prioridad no es válida\"+ \"\\n\";\n\t}\n\tif (valida == 1) \n\t{\n\t\talert(msg);\n\t\tvalida=0;\n\t\treturn false;\n\t}else if(valida == 2){\n\t\talert(\"Su solicitud ya fue enviada\");\n\t\treturn false;\n\t}else{\n\t\tvalida=2;\n\t\tdoc.submit();\n\t}\n}\n\nfunction limpiarCampos(){\n\tdocument.Prioridad.reset();\n}\n\n</SCRIPT>\n<script type=\"text/javascript\" src=\"../js/domapi/core_c.js\"></script>\n  <script type=\"text/javascript\">\n    core.loadUnit(\"colorpicker\");\n    onload=function(){\n\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n      elm1=Colorpicker({x:450,y:355,kind:0,c:\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\"});\n\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\telm1=Colorpicker({x:450,y:355,kind:0});\n\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n      //label1=core.createElm(null,250,70);\n     /* elm1.onbeforechange=function(c){\n        return c=\"\";\n      };*/\n\t  elm1.onchange=function(){\n\t\t\tcolor = elm1.value;\n\t\t\tvalcolor = 0;\n\t\t\tif(color.length!=7){\n\t\t\t\tvalcolor = 1;\n\t\t\t}\n\t\t\tif(color.charAt(0)!='#'){\n\t\t\t\tvalcolor = 1;\n\t\t\t}\n\t\t\tfor(i=1; i<color.length; i++){\n\t\t\t\tif(\tcolor.charAt(i)!='0' && color.charAt(i)!='1' && color.charAt(i)!='2' && color.charAt(i)!='3' && color.charAt(i)!='4' && \n\t\t\t\t\tcolor.charAt(i)!='5' && color.charAt(i)!='6' && color.charAt(i)!='7' && color.charAt(i)!='8' &&\tcolor.charAt(i)!='9' && \n\t\t\t\t\tcolor.charAt(i)!='a' && color.charAt(i)!='b' && color.charAt(i)!='c' && \n\t\t\t\t\tcolor.charAt(i)!='d' && color.charAt(i)!='e' && color.charAt(i)!='f' && \n\t\t\t\t\tcolor.charAt(i)!='A' && color.charAt(i)!='B' && color.charAt(i)!='C' && \n\t\t\t\t\tcolor.charAt(i)!='D' && color.charAt(i)!='E' && color.charAt(i)!='F' ){\n\t\t\t\t\tvalcolor = 1;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif (valcolor==1){\n\t\t\t\talert(\"El numero Hexagecimal no es válido\");\n\t\t\t\telm1.value=\"#FFFFFF\";\n\t\t\t}\n\t\t\twindow.document.forms[0].prioridadHexa.value=elm1.value;\n\t\t};\n      elm1.onchange();\n      //elm1.dropBtn.onclick();\n      // ---- relative test\n     // Colorpicker({parent:core.getElm(\"t1\").rows[1].cells[1]});\n     // exampleInit();\n     // elm1.attachToForm(f,\"elm1_value\");\n    }\n  </script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"valida=0;timer_load();limpiarCampos();\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"Prioridades.jsp\" name=\"Prioridad\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n".toCharArray();
    __oracle_jsp_text[22] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\" name=\"id_prioridad\">".toCharArray();
    __oracle_jsp_text[24] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[25] = 
    "\" name=\"aux\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[26] = 
    "\" name=\"aux2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[27] = 
    "\" name=\"retURI\">\n<BR>\n<DIV align=\"center\">\n<BR>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\n\t<TR valign=\"top\">\n\t\t<TD colspan=\"2\">\n\t\t\t<a href=\"".toCharArray();
    __oracle_jsp_text[28] = 
    "\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\">\n\t\t\t</a>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<a onclick=\"guardarPrioridad()\">\n\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\">\n\t\t\t</a>\n\t\t</TD>\n    </TR>\n\n        <TR valign=\"top\">\n            <TD width=\"20%\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\"><FONT\n\t\t\t\tsize=\"+1\" color=\"#004080\">Prioridades</FONT></FONT></B></TD>\n            <TD width=\"80%\" align=\"right\">&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n        </TR>\n        <TR valign=\"top\">\n\t\t\t<td bgcolor=\"#004080\" colspan=\"2\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</TR>\n\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT>\n\t\t</TD>\n\t\t<TD width=\"528\" align=\"right\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "<I>".toCharArray();
    __oracle_jsp_text[30] = 
    " - ".toCharArray();
    __oracle_jsp_text[31] = 
    "</I></FONT>\n\t\t</TD>\n\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><BR>\n\t\t\t<BR>\n\t\t\t</TD>\n\t\t\t<TD width=\"528\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Unidad\n\t\t\tAdministrativa:</B></FONT></TD>\n\t\t<TD width=\"528\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"528\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Prioridad:</B></FONT>\n\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "<br>\n\t\t<FONT color=\"red\"><B>*Esta Prioridad ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t</TD>\n\t\t<TD width=\"528\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue600a\" name=\"prioridad\"  value=\"".toCharArray();
    __oracle_jsp_text[39] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"528\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">No. Hexagecimal</FONT></TD>\n\t\t<TD width=\"528\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue600a\" name=\"prioridadHexa\" value=\"".toCharArray();
    __oracle_jsp_text[40] = 
    "\" type=\"hidden\"></FONT></TD>\n        </TR>\n    </TBODY>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
