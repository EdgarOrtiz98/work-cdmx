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


public class _Pasos extends com.orionserver.http.OrionHttpJspPage {


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
    _Pasos page = this;
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
      out.write(__oracle_jsp_text[6]);
      
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
      
      
      out.write(__oracle_jsp_text[7]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[8]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[9]);
       } 
      out.write(__oracle_jsp_text[10]);
      
      	String strIdPaso 				= 	"";
      	String strIdArea				=	"";
      	String strDescripcion 			= 	"";
      	String strIdTipoDocto 			= 	"";
      	String strSecuencia 			= 	"";
      	String strFechaActualizacion	=	"";
      	String strFechaActualizacion2	=	"";
      	String strUsrActualizo 			= 	"";
      	String strUsrActualizo1 		= 	"";
      	String strAccion 				= 	"";
      
      	strUsrActualizo1	=	BUsuario.getIdUsuario();
      	String strCreador	= 	ActualizaUsuario.NombreUsuario(strUsrActualizo1);
      	String retURI = (request.getParameter("retURI")== null)?"PasosView.jsp":request.getParameter("retURI");
      	
      	String strAux = "0", strAux2 = "0";
      	int valida = -2;
      	boolean bInsertar		=	false;
      	boolean bActualizar		=	false;
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFechaActualizacion			=	sdf.format(f);
      	strFechaActualizacion2			=	strFechaActualizacion;
      	
      	strAccion 	= 	request.getParameter("accion");
      	strIdArea	=	request.getParameter("id_area");
      	strIdPaso	=	(request.getParameter("id_pas") != null)?request.getParameter("id_pas"):"";
      	int a = 0;
      
      	if(strIdPaso != null && strIdPaso.trim().length()>0)
      	{
      		String strDatosPasos[][] = ActualizaPaso.getPaso(strIdPaso);
      		strIdTipoDocto	=	strDatosPasos[0][0];
      		strSecuencia	=	strDatosPasos[0][1];
      		strDescripcion	=	strDatosPasos[0][2];
      		strIdArea		=	strDatosPasos[0][5];
      
      		strCreador					=	ActualizaUsuario.NombreUsuario(strDatosPasos[0][6]);
      		strFechaActualizacion2		=	strDatosPasos[0][7];
      
      		strAux = strSecuencia;
      		strAux2 = strIdTipoDocto;
      	}
      
      	if(strAccion!=null && strAccion.trim().length()>0)
      	{
      		if(strAccion.equals("guardar"))
      		{
      			strDescripcion	=	request.getParameter("pasoNombre");
      			strIdTipoDocto	=	request.getParameter("pasoTipoDocto");
      			strSecuencia	=	request.getParameter("pasoSecuencia");
      
      			valida = ActualizaPaso.getPasoExiste(strSecuencia, strAux, strIdTipoDocto, strAux2);	
      
      			if (valida == 2){
      				bInsertar		=	ActualizaPaso.InsertarPaso(	strIdTipoDocto, strSecuencia, strDescripcion,
      																strUsrActualizo1, strFechaActualizacion);
      				boolean b = ActualizaBitacora.InsertarEventoAltaPaso(BUsuario.getIdUsuario(),strSecuencia,strIdTipoDocto);
      			
      				try{
      					//response.sendRedirect("PasosView.jsp");
      					response.sendRedirect(retURI);
      				}catch(java.io.IOException io){
      					//System.out.println("ERROR REDIRECCON="+io);
      				}
      			}
      		}
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      			strDescripcion	=	request.getParameter("pasoNombre");
      			strIdTipoDocto	=	request.getParameter("pasoTipoDocto");
      			strSecuencia	=	request.getParameter("pasoSecuencia");
      			strAux			=	request.getParameter("aux");
      			strAux2			=	request.getParameter("aux2");
      
      			//valida = ActualizaPaso.getPasoExiste(strSecuencia, strAux, strIdTipoDocto, strAux2);	
      			String datos[][] = ActualizaPaso.getPaso(strIdPaso);
      			bInsertar = ActualizaPaso.ActualizarPaso(strIdPaso, strIdTipoDocto, strSecuencia,
      														strDescripcion, strUsrActualizo1, strFechaActualizacion);
      			boolean b = ActualizaBitacora.InsertarEventoCambioPaso(BUsuario.getIdUsuario(),strSecuencia,strIdTipoDocto,strIdPaso,datos);
      			try{
      				//response.sendRedirect("PasosView.jsp");
      				response.sendRedirect(retURI);
      			}catch(java.io.IOException io){
      				//System.out.println("ERROR REDIRECCON="+io);
      			}
      		}
      	}
      
      	String sec = null;
      	if(strIdArea != null && strIdArea.trim().length()>0)
      	{
      		String strSec[][] = ActualizaPaso.getSec(strIdArea);
      		sec	=	strSec[0][0];
      
      	}
      
      
      out.write(__oracle_jsp_text[11]);
       if(strIdPaso!=null && strIdPaso.length()!=0){ 
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
      out.print(sec);
      out.write(__oracle_jsp_text[18]);
      out.print( retURI );
      out.write(__oracle_jsp_text[19]);
      out.print(strIdPaso);
      out.write(__oracle_jsp_text[20]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[21]);
      out.print(strAux);
      out.write(__oracle_jsp_text[22]);
      out.print(strAux2);
      out.write(__oracle_jsp_text[23]);
      out.print(retURI);
      out.write(__oracle_jsp_text[24]);
      out.print((strIdPaso!=null && !strIdPaso.equals(""))?"última Modificación por: ":"Creado por: ");
      out.print( strCreador );
      out.write(__oracle_jsp_text[25]);
      out.print( strFechaActualizacion2 );
      out.write(__oracle_jsp_text[26]);
       if(BUsuario.getSupervisor()){ 
      				if(strIdPaso.equals("")){
      					strIdArea = BUsuario.getIdArea();
      				} 
      			
      out.write(__oracle_jsp_text[27]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_1.setName("pasoArea");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_1.setClassHtml("blue600a");
        __jsp_taghandler_1.setScript("onchange='area()'");
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
        __jsp_taghandler_2.setData(ComboData.getAreasComboAll());
        __jsp_taghandler_2.setName("pasoArea");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_2.setClassHtml("blue600a");
        __jsp_taghandler_2.setScript("onchange='area()' onKeypress='buscar_opPAS(this)' onblur='borrar_bufferPAS()' onclick='borrar_bufferPAS()'");
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
        __jsp_taghandler_3.setName("pasoTipoDocto");
        __jsp_taghandler_3.setSize(1);
        __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( strIdTipoDocto));
        __jsp_taghandler_3.setClassHtml("blue600a");
        __jsp_taghandler_3.setTextoNoSeleccion(" ------------ Selecciona un Tipo de Documento ------------ ");
        __jsp_taghandler_3.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[33]);
       }else if(strIdPaso.length() != 0){ 
      out.write(__oracle_jsp_text[34]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_4=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setData(ComboData.getTipoDoctoCombo());
        __jsp_taghandler_4.setName("pasoTipoDocto");
        __jsp_taghandler_4.setSize(1);
        __jsp_taghandler_4.setSelected(OracleJspRuntime.toStr( strIdTipoDocto));
        __jsp_taghandler_4.setClassHtml("blue600a");
        __jsp_taghandler_4.setTextoNoSeleccion(" ------------ Selecciona un Tipo de Documento ------------ ");
        __jsp_taghandler_4.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[35]);
       }else{ 
      out.write(__oracle_jsp_text[36]);
       } 
      out.write(__oracle_jsp_text[37]);
      if (valida == 1) {
      out.write(__oracle_jsp_text[38]);
      } 
      out.write(__oracle_jsp_text[39]);
      out.print(strSecuencia );
      out.write(__oracle_jsp_text[40]);
      out.print(strDescripcion);
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
    "\n<HTML>\n<HEAD>\n<TITLE>Pasos</TITLE>\n".toCharArray();
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
    "\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<STYLE type=\"text/css\"></STYLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n\n\tfunction guardar() { \n\t\n\t\tdoc = document.Pasos;\n\t\t//valida = 0;\n\t\tmsg=\"\";\n\t\t\n//\t\telse {\n\t\t\tmensaje = 'Algunos de los campos tienen caracteres invalidos (&, \", <, >, \\', `,  ´)\\nPresione Aceptar para eliminarlos automaticamente\\no Cancelar para regresar'\n\t\t\tif(detectaCE(doc.pasoNombre.value)){\n\t\t\t\tif (confirm(mensaje)){\n\n\t\t\t\t\tdoc.pasoNombre.value\t= quitaCE(doc.pasoNombre.value);\n\t\t\t\t\n\t\t\t\t\tif(document.Pasos.id_pas.value != \"\") \n\t\t\t\t\t\tdocument.Pasos.accion.value=\"cambiar\";\n\t\t\t\t\telse\n\t\t\t\t\t\tif(document.Pasos.id_pas.value == \"\")\n\t\t\t\t\t\t\tdocument.Pasos.accion.value=\"guardar\";\n//\t\t\t\t\tdocument.Pasos.submit();\n\t\t\t\t}\n\t\t\t\telse \n\t\t\t\t\tdoc.accion.value=\"\";\n\t\t\t}\n\t\t\telse{\n\t\t\t\tif(document.Pasos.id_pas.value != \"\") \n\t\t\t\t\tdocument.Pasos.accion.value=\"cambiar\";\n\t\t\t\telse\n\t\t\t\t\tif(document.Pasos.id_pas.value == \"\")\n\t\t\t\t\t\tdocument.Pasos.accion.value=\"guardar\";\n//\t\t\t\tdocument.Pasos.submit();\n\t\t\t}\n//\t\t}\t\t\n\t\tif (doc.pasoArea[doc.pasoArea.selectedIndex].value == -1) {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" Debe seleccionar una Unidad\"+ \"\\n\";\n\t\t}\n\t\tif (Trim(doc.pasoSecuencia.value) ==\"\") {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" Debe capturar la secuencia del paso\t\"+ \"\\n\";\n\t\t}\n\n\t\tvar numsec = doc.pasoSecuencia.value;\n\t\tif (numsec == 0) {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" La secuencia debe ser mayor de 0\t\"+ \"\\n\";\n\t\t}\n\n\t\t//if(sec == null || sec.equalsIgnoreCase(\"\") )\n\t\t//\tsec=\"0\"; %>\n\t\t//var numsec2 = ".toCharArray();
    __oracle_jsp_text[18] = 
    ";\n\t\t//if (numsec <= numsec2) {\n\t\t//\tnumsec2 = numsec2 + 1;\n\t\t//\tvalida =1;\n\t\t//\tmsg = msg + \" Proxima secuencia: \"  + numsec2 + \"\\n\";\n\t\t//}\n\n\t\tif (doc.pasoTipoDocto[doc.pasoTipoDocto.selectedIndex].value == -1) {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" Debe seleccionar el Tipo de Documento\t\"+ \"\\n\";\n\t\t}\n\t\tif (Trim(doc.pasoNombre.value) ==\"\") {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" Debe capturar la Descripción del Paso\t\"+ \"\\n\";\n\t\t}\n\t\tif (Trim(quitaPuntos(doc.pasoSecuencia.value)) ==\"\" && doc.pasoSecuencia.value!=\"\") {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" La Secuencia no es válida\"+ \"\\n\";\n\t\t}\n\t\tif (Trim(quitaPuntos(doc.pasoNombre.value)) ==\"\" && doc.pasoNombre.value!=\"\") {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" La Descripción no es válida\"+ \"\\n\";\n\t\t}\n\t\n\t\tif (valida == 1) \n\t\t{\n\t\t\talert(msg);\n\t\t\tvalida=0;\n\t\t\treturn false;\n\t\t}else if(valida == 2){\n\t\t\talert(\"Su solicitud ya fue enviada\");\n\t\t\treturn false;\n\t\t}else{\n\t\t\tvalida=2;\n\t\t\tdocument.Pasos.submit();\n\t\t}\n\t}\n\n\n\tfunction area(){\n\t\tdoc = document.Pasos;\n\t\tvar a = doc.pasoArea.value;\n\t\tlocation.assign('Pasos.jsp?id_area='+a);\n\t}\n\tfunction paso(){\n\t\tdoc = document.Pasos;\n\t\tvar a = doc.pasoArea.value;\n\t\tvar p = doc.pasoAreapasoArea.value;\n\t\tlocation.assign('Pasos.jsp?id_area='+a+ '&id_pas'+p);\n\t}\n\tfunction regresar(){\n\t\tlocation.assign('".toCharArray();
    __oracle_jsp_text[19] = 
    "');\n\t}\n\tvar digitos=10 //cantidad de digitos buscados \n\tvar puntero=0 \n\tvar buffer=new Array(digitos) //declaración del array Buffer \n\tvar cadena=\"\" \n\n\tfunction buscar_opPAS(obj){\n\t\tvar forma=document.Pasos;\n\t   \tvar letra = String.fromCharCode(event.keyCode)\n\t   \tif(puntero >= digitos){ \n\t    \tcadena=\"\"; \n\t       \tpuntero=0; \n\t    } \n\t   \tif (event.keyCode == 13){ \n\t    \tborrar_buffer(); \n\t\t\tvar cad=\"\";\n\t\t\tif(obj.options[obj.selectedIndex].value!=\"-1\")\n\t\t\t{\n\t\t\t\tvar a = forma.pasoArea.value;\n\t\t\t\tlocation.assign('Pasos.jsp?id_area='+a);\n\t\t\t}\n\t    } \n\t   \telse{ \n\t       \tbuffer[puntero]=letra; \n\t       \tcadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array \n\t       \tpuntero++; \n\t\n\t       \tfor (var opcombo=0;opcombo < obj.length;opcombo++){ \n\t          \tif(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ \n\t          \t\tobj.selectedIndex=opcombo; \n\t        \t} \n\t       \t} \n\t    } \n\t   \tevent.returnValue = false; //invalida la acción de pulsado de tecla para evitar busqueda del primer caracter \n\t}\n\tfunction borrar_bufferPAS(){ \n    \tcadena=\"\"; \n    \tpuntero=0; \n\t}\n\n\tfunction limpiarCampos(){\n\t\tdocument.Pasos.reset();\n\t}\n\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"valida=0;timer_load();limpiarCampos();\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"Pasos.jsp\" name=\"Pasos\" method=\"post\">\n<INPUT type=hidden value=\"\" name=\"accion\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\" name=\"id_pas\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\" name=\"id_area\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\" name=\"aux\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\" name=\"aux2\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[24] = 
    "\" name=\"retURI\">\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\">\n\t\t\t\t<A onclick=\"regresar()\"><IMG border=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"></A>\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \t\n\t\t\t\t<A onclick=\"guardar()\">\n\t\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\">\n\t\t\t</A>\n\t\t\t</TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD ><B><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\"><FONT size=\"+1\" color=\"#004080\">Pasos</FONT><FONT size=\"+1\"></FONT></FONT></B></TD>\n\t\t\t<TD align=\"right\" valign=\"middle\">&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<td bgcolor=\"#004080\" colspan=\"2\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t<TD align=\"right\"><FONT face=\"Verdana\" size=\"2\"><I>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    " - ".toCharArray();
    __oracle_jsp_text[26] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><BR>\n\t\t\t<BR>\n\t\t\t</TD>\n\t\t\t<TD width=\"528\"></TD>\n\t\t\t<TD></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Unidad\n\t\t\tAdministrativa:</B></FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t<TD width=\"528\"><FONT face=\"Verdana\" size=\"2\">".toCharArray();
    __oracle_jsp_text[28] = 
    "</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t<TD width=\"528\"><FONT face=\"Verdana\" size=\"2\">".toCharArray();
    __oracle_jsp_text[30] = 
    "</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Tipo\n\t\t\tde Documento:</B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t\t\t<SELECT class=\"blue100a\" name=\"pasoTipoDocto\">\n\t\t\t\t\t\t<OPTION value=\"-1\">---</OPTION>\n\t\t\t\t\t</SELECT>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Secuencia:</B></FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "<br>\n\t\t\t<FONT color=\"red\"><B>*Esta Secuencia ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t\t<INPUT class=\"blue100a\" name=\"pasoSecuencia\" value=\"".toCharArray();
    __oracle_jsp_text[40] = 
    "\" onKeyPress='AceptaSoloTeclaNumericaYPunto();' maxlength=\"3\">\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">\n\t\t\t\t<B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">Descripción:</FONT> </B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t\t<INPUT class=\"blue600a\" name=\"pasoNombre\" value=\"".toCharArray();
    __oracle_jsp_text[41] = 
    "\" maxlength=\"199\">\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
