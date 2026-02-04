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


public class _FlujoAtencion extends com.orionserver.http.OrionHttpJspPage {


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
    _FlujoAtencion page = this;
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
      
      	String strIdArea		=	"";
      	String strIdTipoDocto	=	"";
      	String strIdTipoAsunto	=	"";
      	String strDescripcion	=	"";
      	String strCreador		=	"";
      	String strCreador1		=	"";		
      	String strFechaCreacion	=	"";
      	String strFechaCreacion2=	"";
      	String strAccion		=	"";
      	String strEstatus		=	"1";
      	String strIdFlujo			=	"";
      	String strFlujos[][]		=	null;
      
      	String strAux = "1a2b3c", strAux2 = "1a2b3c";
      	int valida = -2;
      	boolean bInsertar		=	false;
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFechaCreacion 				=	sdf.format(f);
      	strFechaCreacion2 				=	strFechaCreacion;
      
      	strCreador1		=	BUsuario.getIdUsuario();
      	strCreador		=	ActualizaUsuario.NombreUsuario(strCreador1);
      	strIdFlujo		=	request.getParameter("id_flujo");
      	strAccion		=	request.getParameter("accion");
      	strIdArea		=	request.getParameter("id_area");
      
      	String url = request.getRequestURI();
      	String server = application.getInitParameter("servername");
      	String URL = server+url+"?id_flujo="+strIdFlujo;
      	////System.err.println("URL="+URL);
      	//////System.out.println("IdArea"+strIdArea);
      	if(strIdFlujo != null)
      	{
      		strFlujos=ActualizaFlujo.getFlujos(strIdFlujo);
      		strIdArea=strFlujos[0][0];		
      		strIdTipoDocto=strFlujos[0][1];
      		strIdTipoAsunto=strFlujos[0][2];
      		strDescripcion=strFlujos[0][3];
      		strCreador			=	ActualizaUsuario.NombreUsuario(strFlujos[0][4]);
      		strFechaCreacion2	=	strFlujos[0][5];
      
      		
      		strAux = strDescripcion;
      		strAux2 = strIdArea;
      	}	
      	
      	if(strIdArea != null)
      	{
      		//strIdArea = request.getParameter("id_area");
      		String TipDocArea[][] = ActualizaTipo_Doc.getDoctosArea(strIdArea);
      	}
      	
      	if(strAccion != null && strAccion.equals("guardar"))
      	{
      		strIdArea		=	request.getParameter("flujoArea");
      		strIdTipoDocto		=	request.getParameter("flujoTipoDocto");
      		strIdTipoAsunto		=	request.getParameter("flujoTipoAsunto");
      		strDescripcion		=	request.getParameter("flujoDescripcion");
      
      		valida = ActualizaFlujo.getRutaExiste(strDescripcion, strAux, strIdArea, strAux2);
      
      		if (valida == 2){
      			bInsertar	=	ActualizaFlujo.InsertarFlujo(	strIdFlujo, strIdArea, strIdTipoDocto, strIdTipoAsunto,
      															strCreador1, strFechaCreacion, strEstatus, strDescripcion);
      			try{
      				response.sendRedirect("FlujoAtencionView.jsp");
      			}catch(java.io.IOException io){
      				//System.err.println("Error de reDirección="+io);
      			}
      		}
      	}else if(strAccion != null && strAccion.equals("guardar1")){
      		strIdArea		=	request.getParameter("flujoArea");
      		strIdTipoDocto		=	request.getParameter("flujoTipoDocto");
      		strIdTipoAsunto		=	request.getParameter("flujoTipoAsunto");
      		strDescripcion		=	request.getParameter("flujoDescripcion");
      		strAux				=	request.getParameter("aux");
      		strAux2				=	request.getParameter("aux2");
      
      		valida = ActualizaFlujo.getRutaExiste(strDescripcion, strAux, strIdArea, strAux2);
      
      		if (valida == 2){
      			bInsertar	=	ActualizaFlujo.InsertarFlujo(	strIdFlujo, strIdArea, strIdTipoDocto, strIdTipoAsunto,
      															strCreador1, strFechaCreacion, strEstatus, strDescripcion);
      			
      			String strIdRutaUltima = ActualizaFlujo.getUltimoIDRuta();
      			
      			String url1 = request.getRequestURI();
      			String server1 = application.getInitParameter("servername");
      			String URL1 = server+url+"?id_flujo="+strIdRutaUltima;
      			
      			try{
      				response.sendRedirect("VisualizaInstrucciones.jsp?Ruta="+strIdRutaUltima+"&Url="+URL1);
      			}catch(java.io.IOException io){
      				//System.err.println("Error de reDirección="+io);
      			}
      		}
      	}
      
      out.write(__oracle_jsp_text[9]);
       if(strIdFlujo!=null && strIdFlujo.length()!=0){ 
      out.write(__oracle_jsp_text[10]);
       if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ 
      out.write(__oracle_jsp_text[11]);
       }else{ 
      out.write(__oracle_jsp_text[12]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[13]);
       } 
      out.write(__oracle_jsp_text[14]);
       } 
      out.write(__oracle_jsp_text[15]);
      out.print(strIdFlujo);
      out.write(__oracle_jsp_text[16]);
      out.print(URL);
      out.write(__oracle_jsp_text[17]);
      out.print( strAccion );
      out.write(__oracle_jsp_text[18]);
      if (strIdFlujo!=null){ 
      out.write(__oracle_jsp_text[19]);
      out.print(strIdFlujo );
      out.write(__oracle_jsp_text[20]);
      }
      out.write(__oracle_jsp_text[21]);
      out.print(strIdArea );
      out.write(__oracle_jsp_text[22]);
      out.print(strAux );
      out.write(__oracle_jsp_text[23]);
      out.print(strAux2 );
      out.write(__oracle_jsp_text[24]);
      out.print( strCreador );
      out.write(__oracle_jsp_text[25]);
      out.print( strFechaCreacion2 );
      out.write(__oracle_jsp_text[26]);
       if(BUsuario.getSupervisor()){ 
      out.write(__oracle_jsp_text[27]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_1.setName("flujoArea");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_1.setClassHtml("blue500");
        __jsp_taghandler_1.setScript("onchange='area()' onKeypress='buscar_opFLU(this)' onblur='borrar_bufferFLU()' onclick='borrar_bufferFLU()'");
        __jsp_taghandler_1.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[28]);
       }else{ 
      out.write(__oracle_jsp_text[29]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getAreasCombo());
        __jsp_taghandler_2.setName("flujoArea");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_2.setClassHtml("blue500");
        __jsp_taghandler_2.setScript("onchange='areaRuta()' onKeypress='buscar_opFLU(this)' onblur='borrar_bufferFLU()' onclick='borrar_bufferFLU()'");
        __jsp_taghandler_2.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
        __jsp_taghandler_2.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[30]);
       } 
      out.write(__oracle_jsp_text[31]);
       if(strIdArea != null){ 
      out.write(__oracle_jsp_text[32]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setData(ComboData.getTipoDoctoCombo(strIdArea));
        __jsp_taghandler_3.setName("flujoTipoDocto");
        __jsp_taghandler_3.setSize(1);
        __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( strIdTipoDocto));
        __jsp_taghandler_3.setClassHtml("blue500");
        __jsp_taghandler_3.setTextoNoSeleccion(" ------------ Selecciona un Tipo de Documento ------------ ");
        __jsp_taghandler_3.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[33]);
       }else{ 
      out.write(__oracle_jsp_text[34]);
       } 
      out.write(__oracle_jsp_text[35]);
       if(strIdArea != null){ 
      out.write(__oracle_jsp_text[36]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_4=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setData(ComboData.getTipoAsuntoCombo(strIdArea));
        __jsp_taghandler_4.setName("flujoTipoAsunto");
        __jsp_taghandler_4.setSize(1);
        __jsp_taghandler_4.setSelected(OracleJspRuntime.toStr( strIdTipoAsunto));
        __jsp_taghandler_4.setClassHtml("blue500");
        __jsp_taghandler_4.setTextoNoSeleccion(" ------------ Selecciona un Tipo de Asunto ------------ ");
        __jsp_taghandler_4.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[37]);
       }else{ 
      out.write(__oracle_jsp_text[38]);
       } 
      out.write(__oracle_jsp_text[39]);
      if (valida == 1) {
      out.write(__oracle_jsp_text[40]);
      } 
      out.write(__oracle_jsp_text[41]);
      out.print(strDescripcion );
      out.write(__oracle_jsp_text[42]);
       if(strIdFlujo != null){ 
      out.write(__oracle_jsp_text[43]);
       }else{ 
      out.write(__oracle_jsp_text[44]);
       } 
      out.write(__oracle_jsp_text[45]);

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
  private static final char __oracle_jsp_text[][]=new char[46][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Ruta Automatica</TITLE>\n".toCharArray();
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
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT language=JavaScript type=text/javascript>\n\nfunction guardarRuta() { \n\n\tdoc = document.FlujoAtencion;\n\t\n\tvalida = 0;\n\tmsg=\"\";\n\t\n\tif (doc.flujoArea[doc.flujoArea.selectedIndex].value == -1) {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes seleccionar una Unidad\t\"+ \"\\n\";\n\t}\n\tif (doc.flujoTipoDocto[doc.flujoTipoDocto.selectedIndex].value == -1) {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes seleccionar un Tipo de Documento\t\"+ \"\\n\";\n\t}\n\tif (doc.flujoTipoAsunto[doc.flujoTipoAsunto.selectedIndex].value == -1) {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes seleccionar un Tipo de Asunto\t\"+ \"\\n\";\n\t}\n\tif(Trim(doc.flujoDescripcion.value) == \"\" ){\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes capturar la Descripción de la Ruta\t\"+ \"\\n\";\n\t}\n\tif (valida == 1) \n\t{\n\t\talert(msg);\n\t\treturn false;\n\t} \n\telse \n\t{\n\t\tmensaje = 'Algunos de los campos tienen caracteres invalidos (&, \", <, >, \\' )\\nPresione Aceptar para eliminarlos automaticamente\\no Cancelar para regresar'\n\t\tif(detectaCE(doc.flujoDescripcion.value)){\n\t\t\tif (confirm(mensaje)){\n\n\t\t\t\tdoc.flujoDescripcion.value\t= quitaCE(doc.flujoDescripcion.value);\n\n\t\t\t\tdoc.aux.value\t= quitaCE(doc.aux.value);\n\t\t\t\t\n\t\t\t\tdoc.accion.value=\"guardar\";\n\t\t\t\tdoc.submit();\n\t\t\t}\n\t\t\telse \n\t\t\t\tdoc.accion.value=\"\";\n\t\t}\n\t\telse{\n\t\t\tdoc.accion.value=\"guardar\";\n\t\t\tdoc.submit();\n\t\t}\n\t}\n}\nfunction areaRuta(){\n\n\tdoc = document.FlujoAtencion;\n\tvar a = doc.flujoArea.value;\n\tlocation.assign('FlujoAtencion.jsp?id_area='+a);\n}\nfunction regresarRuta(){\n\tlocation.assign('FlujoAtencionView.jsp');\n}\nfunction cargaApplet(){\n\n\tdoc = document.FlujoAtencion;\n\t\n\tvalida = 0;\n\tmsg=\"\";\n\t\n\tif (doc.flujoArea[doc.flujoArea.selectedIndex].value == -1) {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes seleccionar una Unidad\t\"+ \"\\n\";\n\t}\n\tif (doc.flujoTipoDocto[doc.flujoTipoDocto.selectedIndex].value == -1) {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes seleccionar un Tipo de Documento\t\"+ \"\\n\";\n\t}\n\tif (doc.flujoTipoAsunto[doc.flujoTipoAsunto.selectedIndex].value == -1) {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes seleccionar un Tipo de Asunto\t\"+ \"\\n\";\n\t}\n\tif(Trim(doc.flujoDescripcion.value) == \"\" ){\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes capturar la Descripción de la Ruta\t\"+ \"\\n\";\n\t}\n\tif (valida == 1) \n\t{\n\t\talert(msg);\n\t\treturn false;\n\t} \n\telse \n\t{\n\t\tmensaje = 'Algunos de los campos tienen caracteres invalidos (&, \", <, >, \\')\\nPresione Aceptar para eliminaros automaticamente\\no Cancelar para regresar'\n\t\tif(detectaCE(doc.flujoDescripcion.value)){\n\t\t\tif (confirm(mensaje)){\n\n\t\t\t\tdoc.flujoDescripcion.value\t= quitaCE(doc.flujoDescripcion.value);\n\n\t\t\t\tdoc.aux.value\t= quitaCE(doc.aux.value);\n\t\t\t\t\n\t\t\t\tdoc.accion.value=\"guardar1\";\n\t\t\t\tdoc.submit();\n\t\t\t}\n\t\t\telse \n\t\t\t\tdoc.accion.value=\"\";\n\t\t}\n\t\telse{\n\t\t\tdoc.accion.value=\"guardar1\";\n\t\t\tdoc.submit();\n\t\t}\n\t}\n\t//location.assign('VisualizaInstrucciones.jsp?Ruta=strIdFlujo%>&Url==URL%>');\n}\nfunction cargaApplet1(){\n\tlocation.assign('VisualizaInstrucciones.jsp?Ruta=".toCharArray();
    __oracle_jsp_text[16] = 
    "&Url=".toCharArray();
    __oracle_jsp_text[17] = 
    "');\n}\n\tvar digitos=10 //cantidad de digitos buscados \n\tvar puntero=0 \n\tvar buffer=new Array(digitos) //declaración del array Buffer \n\tvar cadena=\"\" \n\n\tfunction buscar_opFLU(obj){\n\t\tvar forma=document.FlujoAtencion;\n\t   \tvar letra = String.fromCharCode(event.keyCode)\n\t   \tif(puntero >= digitos){ \n\t    \tcadena=\"\"; \n\t       \tpuntero=0; \n\t    } \n\t   \tif (event.keyCode == 13){ \n\t    \tborrar_buffer(); \n\t\t\tvar cad=\"\";\n\t\t\tif(obj.options[obj.selectedIndex].value!=\"-1\")\n\t\t\t{\n\t\t\t\tvar a = forma.flujoArea.value;\n\t\t\t\tlocation.assign('FlujoAtencion.jsp?id_area='+a);\n\t\t\t}\n\t    } \n\t   \telse{ \n\t       \tbuffer[puntero]=letra; \n\t       \tcadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array \n\t       \tpuntero++; \n\t\n\t       \tfor (var opcombo=0;opcombo < obj.length;opcombo++){ \n\t          \tif(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ \n\t          \t\tobj.selectedIndex=opcombo; \n\t        \t} \n\t       \t} \n\t    } \n\t   \tevent.returnValue = false; //invalida la acción de pulsado de tecla para evitar busqueda del primer caracter \n\t}\n\tfunction borrar_bufferFLU(){ \n    \tcadena=\"\"; \n    \tpuntero=0; \n\t}\n\n\tfunction limpiarCampos(){\n\t\tdocument.FlujoAtencion.reset();\n\t}\n\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load(); limpiarCampos();\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM name=\"FlujoAtencion\" method=\"post\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"accion\">\n".toCharArray();
    __oracle_jsp_text[19] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\" name=\"id_flujo\">\n".toCharArray();
    __oracle_jsp_text[21] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\" name=\"id_area\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\" name=\"aux\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[24] = 
    "\" name=\"aux2\">\n<input type=\"hidden\" name=\"vari\" value=\"\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"99%\" colspan=\"2\">&nbsp;</TD>\n\t\t<TD width=\"1%\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\">\n\t\t\t</DIV>\n\t\t</TD>\n\t\t<TD width=\"1%\">&nbsp;</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"125\">\n\t\t\t<A onclick=\"regresarRuta()\" >\n\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Regresar.gif\" width=\"82\" height=\"26\">\n\t\t\t</A>\n\t\t</TD>\n\t\t<TD width=\"125\">\n\t\t\t<a onclick=\"guardarRuta()\">\n\t\t\t<img src=\"../Imagenes/Guardar.gif\" width=\"81\" border=\"0\">\n\t\t\t</a>\n\t\t</TD>\n\t\t<TD></TD>\n\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t<TD width=\"344\">&nbsp;</TD>\n\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV><DIV align=\"center\"><BR>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><B><FONT size=\"37777777777\" color=\"#004080\"\n\t\t\t\tface=\"Arial\"></FONT></B><FONT\n\t\t\t\tcolor=\"#00204f\" size=\"37777777777\"><B><FONT size=\"+1\"\n\t\t\t\tcolor=\"#004080\">Ruta Automática</FONT></B></FONT></td>\n\t\t<td width=\"190\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"53\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td align=\"right\" width=\"305\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"><FONT color=\"black\">**Los datos marcados\n\t\t\tcon negritas son obligatorios</FONT></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\" align=\"right\" width=\"548\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">Creado por: <I>".toCharArray();
    __oracle_jsp_text[25] = 
    " - ".toCharArray();
    __oracle_jsp_text[26] = 
    "</I></FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><BR>\n\t\t\t<BR>\n\t\t\t&nbsp;</TD>\n\t\t<TD colspan=\"3\" width=\"548\">&nbsp;</TD>\n    </TR>\n</TBODY>\n</TABLE>\n</DIV>\n<DIV class=documentBody id=Body>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Unidad Administrativa:</B></FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n            </FONT>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\">&nbsp;</td>\n\t\t<td width=\"67\">&nbsp;</td>\n\t\t<TD width=\"246\">&nbsp;</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Tipo de Documento:</B></FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t\t<SELECT class=\"blue100\" name=\"flujoTipoDocto\">\n\t\t\t\t\t<OPTION value=\"-1\">---</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\">&nbsp;</td>\n\t\t<td width=\"67\">&nbsp;</td>\n\t\t<TD width=\"246\">&nbsp;</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Tipo de Asunto:</B></FONT></TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t<SELECT class=\"blue100\" name=\"flujoTipoAsunto\">\n\t\t\t\t\t<OPTION value=\"-1\">---</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t        </FONT>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD colspan=\"4\">&nbsp;</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Descripción:</B></FONT>\n\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "<br>\n\t\t<FONT color=\"red\"><B>*Esta Descripción ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t<INPUT name=\"flujoDescripcion\" value=\"".toCharArray();
    __oracle_jsp_text[42] = 
    "\" class=\"blue200\" maxlength=\"199\">\n\t        </FONT>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD colspan=\"4\">&nbsp;</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD colspan=\"4\" align=\"center\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t<INPUT type=\"button\" value=\"Ver Ruta\" class=\"blue200\" onclick=\"cargaApplet1()\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t\t<INPUT type=\"button\" value=\"Crear Ruta\" class=\"blue200\" onclick=\"cargaApplet()\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t</TD>\n\t</TR>\n\t\n</TBODY>\n</TABLE>\n<br>\n</DIV>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
