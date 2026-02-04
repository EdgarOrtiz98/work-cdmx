package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.taglib.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;


public class _Instrucciones extends com.orionserver.http.OrionHttpJspPage {


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
    _Instrucciones page = this;
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
      
      	String stridInstruccion = "";
      	String strInstruccion = "";
      	String strIdArea = "";
      	String strfecha = "";
      	String strfecha2 = "";
      	String strCreador = "";
      	String strCreador1 = "";
      	String strAccion = "";
      	stridInstruccion	=	(request.getParameter("id_inst") != null)?request.getParameter("id_inst"):"";
      	strAccion = request.getParameter("accion");
      
      	String retURI = (request.getParameter("retURI")== null)?"InstruccionesView.jsp":request.getParameter("retURI");
      	String strAux = "1a2b3c", strAux2 = "1a2b3c"; 
      	int valida = -2;
      
      	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f = new java.util.Date();
      	strfecha = sdf.format(f);
      	strfecha2 = strfecha;
      
      	strCreador1		=	BUsuario.getIdUsuario();
      	strCreador		=	ActualizaUsuario.NombreUsuario(strCreador1);
      
      	if(stridInstruccion != null && stridInstruccion.trim().length()>0)
      	{
      		String strInst[][] = com.meve.sigma.reportes.ActualizaInst.getInstrucciones(stridInstruccion);
      		strIdArea = strInst[0][0];
      		strInstruccion = strInst[0][1];
      		strCreador	=	ActualizaUsuario.NombreUsuario(strInst[0][2]);
      		strfecha2	=	strInst[0][3];
      
      		strAux = strInstruccion;
      		strAux2 = strIdArea;
      	}
      	
      	if(strAccion!=null && strAccion.trim().length()>0)
      	{
      		if(strAccion != null && strAccion.equals("guardar"))
      		{
      			strIdArea = request.getParameter("instArea");
      			strInstruccion = request.getParameter("instDescripcion");  
      
      			valida = com.meve.sigma.reportes.ActualizaInst.getInstruccionExiste(strInstruccion, strAux, strIdArea, strAux2);	
      
      			if (valida == 2){
      				boolean b = com.meve.sigma.reportes.ActualizaInst.getInsertaInstruccion(strIdArea, strInstruccion,
      															BUsuario.getIdUsuario(), strfecha);
      				boolean c = ActualizaBitacora.InsertarEventoAltaInstruccion(BUsuario.getIdUsuario(),strInstruccion,strIdArea);
      				try{
      					//response.sendRedirect("InstruccionesView.jsp");
      					response.sendRedirect(retURI);
      				}catch(java.io.IOException io){
      					//System.out.println("Error-->"+io);
      				}
      			}
      		}
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      			strIdArea = request.getParameter("instArea");
      			strInstruccion = request.getParameter("instDescripcion"); 
      			stridInstruccion = request.getParameter("id_inst"); 
      			strAux 	= request.getParameter("aux"); 
      			strAux2 = request.getParameter("aux2"); 
      
      			valida = com.meve.sigma.reportes.ActualizaInst.getInstruccionExiste(strInstruccion, strAux, strIdArea, strAux2);	
      
      			if (valida == 2){
      
      				String datos[][] = com.meve.sigma.reportes.ActualizaInst.getInstrucciones(stridInstruccion);
      				boolean c = com.meve.sigma.reportes.ActualizaInst.getActualizarInstruccio(stridInstruccion, strIdArea,
      						 strInstruccion, BUsuario.getIdUsuario(), strfecha);
      
      				boolean d = ActualizaBitacora.InsertarEventoCambioInstruccion(BUsuario.getIdUsuario(),strInstruccion,strIdArea,stridInstruccion,datos);	
      
      				try{
      					//response.sendRedirect("InstruccionesView.jsp");
      					response.sendRedirect(retURI);
      				}catch(java.io.IOException io){
      					//System.out.println("Error-->"+io);
      				}
      			}
      		}	
      	}
      
      out.write(__oracle_jsp_text[9]);
       if(stridInstruccion!=null && stridInstruccion.length()!=0){ 
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
      out.print( strAccion );
      out.write(__oracle_jsp_text[16]);
      out.print(stridInstruccion);
      out.write(__oracle_jsp_text[17]);
      out.print(strAux);
      out.write(__oracle_jsp_text[18]);
      out.print(strAux2);
      out.write(__oracle_jsp_text[19]);
      out.print(retURI);
      out.write(__oracle_jsp_text[20]);
      out.print( retURI );
      out.write(__oracle_jsp_text[21]);
      out.print((stridInstruccion!=null && !stridInstruccion.equals(""))?"última Modificación por: ":"Creado por: ");
      out.print( strCreador );
      out.write(__oracle_jsp_text[22]);
      out.print( strfecha2 );
      out.write(__oracle_jsp_text[23]);
       if(BUsuario.getSupervisor()){ 
      				if(stridInstruccion.equals("")){
      					strIdArea = BUsuario.getIdArea();
      				} 
      out.write(__oracle_jsp_text[24]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_1.setName("instArea");
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
      out.write(__oracle_jsp_text[25]);
       }else{ 
      out.write(__oracle_jsp_text[26]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getAreasComboAll());
        __jsp_taghandler_2.setName("instArea");
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
      out.write(__oracle_jsp_text[27]);
       } 
      out.write(__oracle_jsp_text[28]);
      if (valida == 1) {
      out.write(__oracle_jsp_text[29]);
      } 
      out.write(__oracle_jsp_text[30]);
      out.print(strInstruccion);
      out.write(__oracle_jsp_text[31]);

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
  private static final char __oracle_jsp_text[][]=new char[32][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Instrucciones</TITLE>\n".toCharArray();
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
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT language=JavaScript type=text/javascript>\n\tfunction limpiarCampos(){\n\t\tdocument.InstruccionesCat.reset();\n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"valida=0;timer_load();limpiarCampos();\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"Instrucciones.jsp\" name=\"InstruccionesCat\" method=\"post\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"accion\"> \n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"id_inst\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"aux\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"aux2\">\n<INPUT type=hidden value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\" name=\"retURI\">\n<BR>\n<BR>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\"><A href=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"></A>\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<a onclick=\"guardarInst()\">\n\t\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\">\n\t\t\t\t</a>\n\t\t\t</TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\"><B><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\"><FONT color=\"#00204f\" size=\"37777777777\"><FONT\n\t\t\t\tcolor=\"#00204f\" size=\"37777777777\"><FONT size=\"+1\" color=\"#004080\">Instrucciones</FONT></FONT></FONT></FONT></B></TD>\n\t\t\t<TD align=\"right\" >&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TH width=\"190\" ></TH>\n\t\t\t<TH align=\"right\" width=\"490\"></TH>\n\t\t\t<TD></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TH width=\"190\" height=\"0\"></TH>\n\t\t\t<TH align=\"right\" width=\"490\" height=\"0\"></TH>\n\t\t\t<TD height=\"0\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"190\" height=\"28\"></TD>\n\t\t\t<TD align=\"right\" ><FONT face=\"Verdana\" size=\"2\"><I>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    " - ".toCharArray();
    __oracle_jsp_text[23] = 
    "</I></FONT></TD>\n\t\t\t<TD height=\"28\"></TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"154\"><BR>&nbsp;</TD>\n\t\t\t<TD align=\"right\" width=\"444\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"154\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Unidad\n\t\t\tAdministrativa:</B></FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t<TD width=\"444\"><FONT face=\"Verdana\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[25] = 
    " </FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t<TD width=\"528\"><FONT face=\"Verdana\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[27] = 
    " </FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"154\">&nbsp;</TD>\n\t\t\t<TD width=\"444\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"154\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>instrucción:</B></FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "<br>\n\t\t\t<FONT color=\"red\"><B>*Esta instrucción ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"444\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue600a\"\n\t\t\t\tname=\"instDescripcion\"  value=\"".toCharArray();
    __oracle_jsp_text[31] = 
    "\" maxlength=\"199\"></FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"154\">&nbsp;</TD>\n\t\t\t<TD width=\"444\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV></FORM>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n<!-- \nfunction guardarInst() { \n\tvar doc = document.InstruccionesCat\n\t//var valida = 0;\n\tvar msg=\"\";\n\n//\tif (valida != 1)\t{\n\t\tmensaje = 'Algunos de los campos tienen caracteres invalidos (&, \", <, >, \\', `,  ´)\\nPresione Aceptar para eliminarlos automaticamente\\no Cancelar para regresar'\n\t\tif(detectaCE(doc.instDescripcion.value)){\n\t\t\tif (confirm(mensaje)){\n\n\t\t\t\tdoc.instDescripcion.value\t= quitaCE(doc.instDescripcion.value);\n\t\n\t\t\t\tdoc.aux.value\t= quitaCE(doc.aux.value);\n\t\t\t\t\n\t\t\t\tif(doc.id_inst.value != \"\")\n\t\t\t\t\tdoc.accion.value=\"cambiar\";\n\t\t\t\tif(doc.id_inst.value == \"\")\n\t\t\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\t\tdoc.submit();\n\t\t\t}\n\t\t\telse \n\t\t\t\tdoc.accion.value=\"\";\n\t\t}\n\t\telse{\n\t\t\tif(doc.id_inst.value != \"\")\n\t\t\t\tdoc.accion.value=\"cambiar\";\n\t\t\tif(doc.id_inst.value == \"\")\n\t\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\tdoc.submit();\n\t\t}\n//\t}\n\tif (doc.instArea[doc.instArea.selectedIndex].value == -1) {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes seleccionar una Unidad  \"+ \"\\n\";\n\t}\n\tif (Trim(doc.instDescripcion.value) ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debe capturar el nombre de una instrucción\"+ \"\\n\";\n\t}\n\tif (Trim(quitaPuntos(doc.instDescripcion.value)) ==\"\" && doc.instDescripcion.value!=\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" El Nombre de la instrucción no es válido\"+ \"\\n\";\n\t}\n\tif (valida == 1) \n\t{\n\t\talert(msg);\n\t\tvalida=0;\n\t\treturn false;\n\t}else if(valida == 2){\n\t\talert(\"Su solicitud ya fue enviada\");\n\t\treturn false;\n\t}else{\n\t\tvalida=2;\n\t\tdoc.submit();\n\t}\n}\n</SCRIPT>\n\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
