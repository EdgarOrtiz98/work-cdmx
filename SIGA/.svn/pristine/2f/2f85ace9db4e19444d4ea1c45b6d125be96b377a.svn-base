package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.taglib.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _Remitente extends com.orionserver.http.OrionHttpJspPage {


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
    _Remitente page = this;
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
      com.meve.sigma.beans.BeanRemitente Bremitente;
      synchronized (pageContext) {
        if ((Bremitente = (com.meve.sigma.beans.BeanRemitente) pageContext.getAttribute( "Bremitente", PageContext.PAGE_SCOPE)) == null) {
          Bremitente = (com.meve.sigma.beans.BeanRemitente) new com.meve.sigma.beans.BeanRemitente();
          pageContext.setAttribute( "Bremitente", Bremitente, PageContext.PAGE_SCOPE);
          out.write(__oracle_jsp_text[3]);
          OracleJspRuntime.__jspSetAllParams(request, (Object)Bremitente, true);
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
           
          	String strNombre		=	(Bremitente.getRemitente()== null)?"":Bremitente.getRemitente();
          	String strCargo			=	(Bremitente.getRemitenteCargo()== null)?"":Bremitente.getRemitenteCargo();
          	String strIdArea		=	(Bremitente.getRemitenteArea()== null)?"":Bremitente.getRemitenteArea();
          	String strIdEntidad		=	(Bremitente.getRemitenteEntidad()== null)?"":Bremitente.getRemitenteEntidad();
          	String strTelefono		=	(Bremitente.getRemitenteTelefono()== null)?"":Bremitente.getRemitenteTelefono();
          	String strCorreo		=	(Bremitente.getRemitenteCorreo()== null)?"":Bremitente.getRemitenteCorreo();
          	String strDireccion		=	(Bremitente.getRemitenteDireccion()== null)?"":Bremitente.getRemitenteDireccion();
          	String strFax			=	(Bremitente.getRemitenteFax()== null)?"":Bremitente.getRemitenteFax();
          
          	String strIdRemitente	=	"";
          	String strCreador		=	"";
          	String strCreador1		=	"";
          	String strFechaCreacion	=	"";
          	String strFechaCreacion2=	"";
          	String strAccion		=	"";
          	String strEstatus		=	"1";
          	String strEntidades[][] = 	null;
          	String strRemitentes[][]=	null;
          	
          	String retURI = (request.getParameter("retURI")== null)?"RemitenteView.jsp":request.getParameter("retURI");
          	String strAux = "1a2b3c", strAux2 = "1a2b3c"; 
          	int valida = -2;
          	boolean bInsertar =	false;
          
          	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
          	java.util.Date f 				=	new java.util.Date();
          	strFechaCreacion 				=	sdf.format(f);
          	strFechaCreacion2 				=	strFechaCreacion;
          
          	strCreador1		=	BUsuario.getIdUsuario();
          	strCreador		=	ActualizaUsuario.NombreUsuario(strCreador1);
          	strIdRemitente	=	request.getParameter("id_remitente");
          
          	strAccion		=	request.getParameter("accion");
          
          	if(strIdRemitente != null && strAccion == null)
          	{
          		strRemitentes=ActualizaRemitente.getRemitentes(strIdRemitente);
          		strNombre		=	strRemitentes[0][0];
          		strIdArea		=	strRemitentes[0][1];
          		strCargo		=	strRemitentes[0][2];
          		strIdEntidad	=	strRemitentes[0][3];
          		strTelefono		=	strRemitentes[0][4];
          		strCorreo		=	strRemitentes[0][5];
          		strDireccion	=	strRemitentes[0][6];
          		strFax			=	strRemitentes[0][7];
          		strCreador			=	ActualizaUsuario.NombreUsuario(strRemitentes[0][8]);
          		strFechaCreacion2	=	strRemitentes[0][9];
          
          		strAux = strNombre;
          		strAux2 = strIdEntidad;
          	}
          	if(strAccion != null && strAccion.equals("guardar"))
          	{
          		strNombre		=	request.getParameter("remitente");
          		strIdArea		=	request.getParameter("remitenteArea");
          		strCargo		=	request.getParameter("remitenteCargo");
          		strIdEntidad	=	request.getParameter("remitenteEntidad");
          		strDireccion	=	request.getParameter("remitenteDireccion");
          		strTelefono		=	request.getParameter("remitenteTelefono");
          		strFax			=	request.getParameter("remitenteFax");
          		strCorreo		=	request.getParameter("remitenteCorreo");
          
          		strAux		=	request.getParameter("aux");
          		strAux2		=	request.getParameter("aux2");
          
          		valida = ActualizaRemitente.getRemitenteExiste(strNombre, strAux, strIdEntidad, strAux2);	
          
          		if (valida == 2){
          			bInsertar	= 	ActualizaRemitente.InsertarRemitente(	strIdRemitente, strNombre, strCargo, strIdArea, strIdEntidad, strTelefono,
          																	strCorreo, strCreador1, strFechaCreacion, strEstatus, strDireccion, strFax);
          
          			try{
          				response.sendRedirect(retURI);
          			}catch(java.io.IOException io){
          				//System.out.println("ErrorRedirect-->"+io);
          			}
          		}
          	}
          
          out.write(__oracle_jsp_text[11]);
           if(strIdRemitente!=null && strIdRemitente.length()!=0){ 
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
          out.print( retURI );
          out.write(__oracle_jsp_text[18]);
          if (strIdRemitente!=null){ 
          out.write(__oracle_jsp_text[19]);
          out.print(strIdRemitente );
          out.write(__oracle_jsp_text[20]);
          }
          out.write(__oracle_jsp_text[21]);
          out.print(strAux );
          out.write(__oracle_jsp_text[22]);
          out.print(strAux2 );
          out.write(__oracle_jsp_text[23]);
          out.print(retURI );
          out.write(__oracle_jsp_text[24]);
          out.print((strIdRemitente!=null && !strIdRemitente.equals(""))?"última Modificación por: ":"Creado por: ");
          out.write(__oracle_jsp_text[25]);
          out.print( strCreador );
          out.write(__oracle_jsp_text[26]);
          out.print( strFechaCreacion2 );
          out.write(__oracle_jsp_text[27]);
           if(BUsuario.getSupervisor()){ 
          				if(strIdRemitente==null){
          					strIdArea = BUsuario.getIdArea();
          				} 
          			
          out.write(__oracle_jsp_text[28]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_1.setParent(null);
            __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
            __jsp_taghandler_1.setName("remitenteArea");
            __jsp_taghandler_1.setSize(1);
            __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strIdArea));
            __jsp_taghandler_1.setClassHtml("blue600a");
            __jsp_taghandler_1.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='entidades()'");
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
            __jsp_taghandler_2.setName("remitenteArea");
            __jsp_taghandler_2.setSize(1);
            __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strIdArea));
            __jsp_taghandler_2.setClassHtml("blue600a");
            __jsp_taghandler_2.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='entidades()'");
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
          out.print(strNombre );
          out.write(__oracle_jsp_text[35]);
          out.print(strCargo );
          out.write(__oracle_jsp_text[36]);
          if(strIdArea.length() > 0){
          out.write(__oracle_jsp_text[37]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_3.setParent(null);
            __jsp_taghandler_3.setData(ComboData.getEntidadAreaCombo(strIdArea));
            __jsp_taghandler_3.setName("remitenteEntidad");
            __jsp_taghandler_3.setSize(1);
            __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( strIdEntidad));
            __jsp_taghandler_3.setClassHtml("blue600a");
            __jsp_taghandler_3.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
            __jsp_taghandler_3.setTextoNoSeleccion(" ------------ Selecciona una Entidad ------------ ");
            __jsp_taghandler_3.setValorNoSeleccion("-1");
            __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
            if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
          }
          out.write(__oracle_jsp_text[38]);
          }else{
          out.write(__oracle_jsp_text[39]);
          }
          out.write(__oracle_jsp_text[40]);
          out.print(strDireccion );
          out.write(__oracle_jsp_text[41]);
          out.print(strTelefono );
          out.write(__oracle_jsp_text[42]);
          out.print(strFax );
          out.write(__oracle_jsp_text[43]);
          out.print(strCorreo );
          out.write(__oracle_jsp_text[44]);
        }
      }

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
  private static final char __oracle_jsp_text[][]=new char[45][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Remitente</TITLE>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n\t".toCharArray();
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
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript>\n\n\nfunction soloNumeros(ob){\n\tvar ok=false;\n\tvar texto=ob.value\n\tvar codigo=texto.charCodeAt(texto.length-1);\n\tif((codigo>=48&&codigo<=57))\n\tok=true;\n\tif(!ok){\n\t\ttexto=texto.substring(0,texto.length-1);\n\t\tob.value=texto;\n\t\t}\n\t}\nfunction guardar() {\n\n\tdoc = document.Remitente;\n\t//valida = 0;\n\tmsg=\"\";\n\n//\telse \t{\n\t\tmensaje = 'Algunos de los campos tienen caracteres invalidos (&, \", <, >, \\', `,  ´)\\nPresione Aceptar para eliminarlos automaticamente\\no Cancelar para regresar'\n\n\t\tif(detectaCE(doc.remitente.value) || detectaCE(doc.remitenteCargo.value) || detectaCE(doc.remitenteDireccion.value)){\n\n\t\t\tif (confirm(mensaje)){\n\n\t\t\t\tdoc.remitente.value\t= quitaCE(doc.remitente.value);\n\t\t\t\tdoc.remitenteCargo.value\t= quitaCE(doc.remitenteCargo.value);\n\t\t\t\tdoc.remitenteDireccion.value\t= quitaCE(doc.remitenteDireccion.value);\n\t\n\t\t\t\tdoc.aux.value\t= quitaCE(doc.aux.value);\n\t\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\t\tdoc.submit();\n\t\t\t}\n\t\t\telse \n\t\t\t\tdoc.accion.value=\"\";\n\t\t}\n\t\telse{\n\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\tdoc.submit();\n\t\t}\n//\t}\n\t\tif (doc.remitenteArea[doc.remitenteArea.selectedIndex].value == -1) {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" Debes seleccionar una Unidad Administrativa\"+ \"\\n\";\n\t\t}\n\t\tif (Trim(doc.remitente.value) ==\"\") {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" Debes capturar el Nombre del Remitente\t\"+ \"\\n\";\n\t\t}\n\t\tif (Trim(doc.remitenteCargo.value) ==\"\") {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" Debes capturar el Cargo del Remitente\t\"+ \"\\n\";\n\t\t}\n\t\tif (doc.remitenteEntidad[doc.remitenteEntidad.selectedIndex].value == -1) {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" Debes seleccionar una Entidad para el Remitente\t\"+ \"\\n\";\n\t\t}\n\t\tif (!isCorreo(Trim(doc.remitenteCorreo.value))) {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" El Correo Electrónico es inválido\t\"+ \"\\n\";\n\t\t}\n\t\tif (!isTelefono(Trim(doc.remitenteTelefono.value))) {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" El Número de Teléfono es inválido\t\"+ \"\\n\";\n\t\t}\n\t\tif (!isTelefono(Trim(doc.remitenteFax.value))) {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" El Número de Fax es inválido\t\"+ \"\\n\";\n\t\t}\n\t\tif (Trim(quitaPuntos(doc.remitente.value)) ==\"\" && doc.remitente.value!=\"\") {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" El Nombre del Remitente no es válido\"+ \"\\n\";\n\t\t}\n\t\tif (Trim(quitaPuntos(doc.remitenteCargo.value)) ==\"\" && doc.remitenteCargo.value!=\"\") {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" El Cargo no es válido\"+ \"\\n\";\n\t\t}\n\t\tif (Trim(quitaPuntos(doc.remitenteDireccion.value)) ==\"\" && doc.remitenteDireccion.value!=\"\") {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" La Dirección no es válida\"+ \"\\n\";\n\t\t}\n\t\tif (valida == 1) \n\t\t{\n\t\t\talert(msg);\n\t\t\tvalida=0;\n\t\t\treturn false;\n\t\t}else if(valida == 2){\n\t\t\talert(\"Su solicitud ya fue enviada\");\n\t\t\treturn false;\n\t\t}else{\n\t\t\tvalida=2;\n\t\t\tdoc.submit();\n\t\t}\n}\n\nfunction entidades() {\n\tdoc = document.Remitente;\n\tdoc.accion.value=\"reload\";\n\tdoc.submit();\n}\nfunction regresarRemitente(){\n\tlocation.assign(\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\");\n}\n\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"valida=0;timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"Remitente.jsp\" name=\"Remitente\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n".toCharArray();
    __oracle_jsp_text[19] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\" name=\"id_remitente\">".toCharArray();
    __oracle_jsp_text[21] = 
    "<BR>\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\" name=\"aux\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\" name=\"aux2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[24] = 
    "\" name=\"retURI\">\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD colspan=\"4\">\n\t\t\t<a onclick=\"regresarRemitente()\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\">\n\t\t\t</a>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<a onclick=\"guardar()\">\n\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\">\n\t\t\t</a>\n\t\t</TD>\n    </TR>\n\n        <TR valign=\"top\">\n            <TD colspan=\"2\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\"><FONT\n\t\t\t\tsize=\"+1\" color=\"#004080\">Remitente</FONT></FONT></B></TD>\n            <TD colspan=\"2\" align=\"right\">&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n        </TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD colspan=\"2\"></TD>\n\t\t\t<TD colspan=\"2\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD colspan=\"2\"></TD>\n\t\t\t<TD colspan=\"2\"></TD>\n\t\t</TR>\n\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\" align=\"right\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "<I>".toCharArray();
    __oracle_jsp_text[26] = 
    " - ".toCharArray();
    __oracle_jsp_text[27] = 
    "</I></FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><BR>\n\t\t\t<BR>\n\t\t\t</TD>\n\t\t<TD width=\"233\">&nbsp;</TD>\n\t\t<TD width=\"67\">&nbsp;</TD>\n\t\t<TD width=\"272\">&nbsp;</TD>\n    </TR>\n\t\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Unidad\n\t\t\tAdministrativa:</B></FONT></TD>\n\t\t<TD colspan=\"3\">\n\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD width=\"233\">&nbsp;</TD>\n\t\t<TD width=\"67\">&nbsp;</TD>\n\t\t<TD width=\"272\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Nombre:</B></FONT>\n\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "<br>\n\t\t<FONT color=\"red\"><B>*Esta Nombre ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t</TD>\n\t\t<TD colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue600a\" name=\"remitente\" value=\"".toCharArray();
    __oracle_jsp_text[35] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD width=\"233\">&nbsp;</TD>\n\t\t<TD width=\"67\">&nbsp;</TD>\n\t\t<TD width=\"272\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Cargo:</B></FONT></TD>\n\t\t<TD colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue600a\" name=\"remitenteCargo\"  value=\"".toCharArray();
    __oracle_jsp_text[36] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD width=\"233\">&nbsp;</TD>\n\t\t<TD width=\"67\">&nbsp;</TD>\n\t\t<TD width=\"272\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Entidad:</B></FONT></TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t\t<SELECT class=\"blue600a\" name=\"remitenteEntidad\">\n\t\t\t\t\t<OPTION value=\"-1\">------------ Selecciona una Entidad ------------</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD width=\"233\">&nbsp;</TD>\n\t\t<TD width=\"67\">&nbsp;</TD>\n\t\t<TD width=\"272\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">Dirección:</FONT></TD>\n\t\t<TD colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue600a\" name=\"remitenteDireccion\" value=\"".toCharArray();
    __oracle_jsp_text[41] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT color=\"#004080\">&nbsp;</FONT></TD>\n\t\t<TD width=\"233\">&nbsp;</TD>\n\t\t<TD width=\"67\">&nbsp;</TD>\n\t\t<TD width=\"272\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">Teléfono:</FONT></TD>\n\t\t<TD colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue600a\" name=\"remitenteTelefono\" onkeydown=\"soloNumeros(this)\" value=\"".toCharArray();
    __oracle_jsp_text[42] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT color=\"#004080\">&nbsp;</FONT></TD>\n\t\t<TD width=\"233\">&nbsp;</TD>\n\t\t<TD width=\"67\">&nbsp;</TD>\n\t\t<TD width=\"272\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">Fax:</FONT></TD>\n\t\t<TD colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue600a\" name=\"remitenteFax\" onkeydown=\"soloNumeros(this)\" value=\"".toCharArray();
    __oracle_jsp_text[43] = 
    "\" maxlength=\"49\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT color=\"#004080\">&nbsp;</FONT></TD>\n\t\t<TD width=\"233\">&nbsp;</TD>\n\t\t<TD width=\"67\">&nbsp;</TD>\n\t\t<TD width=\"272\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">Correo Electrónico:</FONT></TD>\n\t\t<TD colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue600a\" name=\"remitenteCorreo\" value=\"".toCharArray();
    __oracle_jsp_text[44] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD width=\"233\">&nbsp;</TD>\n\t\t<TD width=\"67\">&nbsp;</TD>\n\t\t<TD width=\"272\">&nbsp;</TD>\n    </TR>\n    </TBODY>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
