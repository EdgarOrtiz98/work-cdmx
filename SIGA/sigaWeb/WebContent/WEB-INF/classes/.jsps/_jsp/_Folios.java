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


public class _Folios extends com.orionserver.http.OrionHttpJspPage {


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
    _Folios page = this;
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
      
      		
      		String recCreador[][] 	=	null;
      		String recFolio[][] 	= 	null;
      		String strIdFolio 		=	"";
      		String strIdArea 		= 	"";
      		String strTipoFolio 	= 	"";
      		String strClave 		= 	"";
      		String strConsecutivo 	= 	"";
      		String strOrden 		= 	"";
      		String strCreador 		= 	"";
      		String strCreador1 		= 	"";
      		String strFechaCreacion	=	"";
      		String strFechaCreacion2=	"";
      		String strAccion 		= 	"";
      		String strEstatus 		= 	"1";
      		String strConfFolio 	= 	application.getInitParameter("genFolio");
      
      		String retURI = (request.getParameter("retURI")== null)?"FoliosView.jsp":request.getParameter("retURI");
      		String strAux = "1a2b3c", strAux2 = "1a2b3c";
      		int valida = -2;
      		boolean bInsertar = false;
      		boolean bActualizar = false;
      		boolean bvalida = true;
      		boolean bvalidaClave = true;
      
      		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
      				"dd/MM/yyyy");
      		java.util.Date f = new java.util.Date();
      		strFechaCreacion = sdf.format(f);
      		strFechaCreacion2=	strFechaCreacion;
      
      		strCreador1	=	BUsuario.getIdUsuario();
      		strCreador	=	ActualizaUsuario.NombreUsuario(strCreador1);
      		
      		strAccion 	= 	request.getParameter("accion");
      		
      		if (strAccion != null && strAccion.equals("consultar")) {
      			strIdFolio = request.getParameter("folio_idFolio");
      			if (strIdFolio != null) {
      				recFolio 		= ActualizaFolio.getFolio(strIdFolio);
      				strIdArea 		= recFolio[0][0];
      				strTipoFolio 	= recFolio[0][1];
      				strClave 		= recFolio[0][2];
      				strConsecutivo 	= recFolio[0][3];
      				strOrden 		= recFolio[0][4];
      				strCreador1		= recFolio[0][5];
      				strCreador		= ActualizaUsuario.NombreUsuario(recFolio[0][5]);
      				strFechaCreacion2 = recFolio[0][6];
      
      				strAux = strClave;
      				strAux2 = strIdArea;
      			}
      		}
      		if (strAccion != null && strAccion.equals("cambiar")) {
      			strIdFolio = request.getParameter("folio_idFolio");
      			////System.out.println("strIdFolio=" + strIdFolio);
      			if (strIdFolio != null) {
      				strIdArea 		= request.getParameter("folio_area");
      				strTipoFolio 	= request.getParameter("folio_tipo");
      				strClave 		= request.getParameter("folio_clave");
      				strOrden 		= request.getParameter("folio_orden");
      				strAux 			= request.getParameter("aux");
      				strAux2			= request.getParameter("aux2");
      				if(strConfFolio.equals("1"))
      					strConsecutivo = "0";
      				else
      					strConsecutivo 	= request.getParameter("folio_consecutivo");
      
      				// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Folio
      				strClave	=	(strClave.length()<= 200) ? strClave : strClave.substring(0,200);
      
      				if (strTipoFolio.equals("1"))
      					bvalida = ActualizaFolio.getFolioExiste(strIdArea, strIdFolio);	
      				else
      					bvalida = true;
      
      				bvalidaClave = ActualizaFolio.getClaveFolioExiste(strClave, strIdFolio);				
      
      				if (bvalida && bvalidaClave){
      					String datos[][] = ActualizaFolio.getFolio(strIdFolio);
      					bInsertar 		= ActualizaFolio.ActualizarFolio(strIdFolio,
      							strIdArea, strTipoFolio, strClave, strConsecutivo,
      							strOrden, strCreador1, strFechaCreacion);
      					boolean b = ActualizaBitacora.InsertarEventoCambioFolio(BUsuario.getIdUsuario(),strClave,strIdArea,strIdFolio,datos);
      				}
      			}
      		}
      
      		if (strAccion != null && strAccion.equals("guardar")) {
      			strIdArea 		= request.getParameter("folio_area");
      			strTipoFolio 	= request.getParameter("folio_tipo");
      			strClave 		= request.getParameter("folio_clave");
      			strOrden 		= request.getParameter("folio_orden");
      			if(strConfFolio.equals("1"))
      				strConsecutivo = "0";
      			else
      				strConsecutivo 	= request.getParameter("folio_consecutivo");
      
      			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Folio
      			strClave	=	(strClave.length()<= 200) ? strClave : strClave.substring(0,200);
      
      			if (strTipoFolio.equals("1"))
      				bvalida = ActualizaFolio.getFolioExiste(strIdArea, "-1");	
      			else
      				bvalida = true;
      
      			bvalidaClave = ActualizaFolio.getClaveFolioExiste(strClave, "-1");				
      
      			if (bvalida && bvalidaClave){
      				bInsertar 		= ActualizaFolio.InsertarFolio(strIdArea, strTipoFolio,
      								strClave, strConsecutivo, strOrden, strCreador1,
      								strFechaCreacion, strEstatus);
      				boolean b = ActualizaBitacora.InsertarEventoAltaFolio(BUsuario.getIdUsuario(),strClave,strIdArea);
      //				strIdArea 		= "";
      //				strTipoFolio 	= "";
      //				strClave 		= "";
      //				strConsecutivo 	= "";
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
       if(strIdFolio!=null && strIdFolio.length()!=0){ 
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
      out.print( strAccion );
      out.write(__oracle_jsp_text[19]);
      out.print(strOrden);
      out.write(__oracle_jsp_text[20]);
      out.print(strIdFolio);
      out.write(__oracle_jsp_text[21]);
      out.print(strAux);
      out.write(__oracle_jsp_text[22]);
      out.print(strAux2);
      out.write(__oracle_jsp_text[23]);
      out.print(retURI);
      out.write(__oracle_jsp_text[24]);
      out.print( retURI );
      out.write(__oracle_jsp_text[25]);
      out.print((strIdFolio!=null && !strIdFolio.equals(""))?"última Modificación por: ":"Creado por: ");
      out.write(__oracle_jsp_text[26]);
      out.print( strCreador );
      out.write(__oracle_jsp_text[27]);
      out.print( strFechaCreacion2 );
      out.write(__oracle_jsp_text[28]);
       if(BUsuario.getSupervisor()){ 
      				if(strIdFolio.equals("")){
      					strIdArea = BUsuario.getIdArea();
      				} 
      			
      out.write(__oracle_jsp_text[29]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_1.setName("folio_area");
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
      out.write(__oracle_jsp_text[30]);
       }else{ 
      out.write(__oracle_jsp_text[31]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getAreasComboAll());
        __jsp_taghandler_2.setName("folio_area");
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
      out.write(__oracle_jsp_text[32]);
       } 
      out.write(__oracle_jsp_text[33]);
      if (!bvalida) {
      out.write(__oracle_jsp_text[34]);
      } 
      out.write(__oracle_jsp_text[35]);
      out.print(strTipoFolio.trim().equals("1")? "CHECKED":"");
      out.write(__oracle_jsp_text[36]);
      out.print(strTipoFolio.trim().equals("0")? "CHECKED":"");
      out.write(__oracle_jsp_text[37]);
      out.print(strClave);
      out.write(__oracle_jsp_text[38]);
      if (!bvalidaClave) {
      out.write(__oracle_jsp_text[39]);
      } 
      out.write(__oracle_jsp_text[40]);
       if(!strConfFolio.equals("1")){ 
      out.write(__oracle_jsp_text[41]);
      out.print(strConsecutivo);
      out.write(__oracle_jsp_text[42]);
       } 
      out.write(__oracle_jsp_text[43]);
      if(!strConfFolio.equals("1")){
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
    "\n<HTML>\n<HEAD>\n<TITLE>Folios</TITLE>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "    \n".toCharArray();
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
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<STYLE type=\"text/css\">\n</STYLE>\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\"\n\tsrc=\"../js/domapi/core_c.js\"></script>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\"\n\tsrc=\"../js/domapi/examples_c.js\"></script>\n\n<SCRIPT language=JavaScript type=text/javascript>\n\n\tfunction limpiarCampos(){\n\t\tdocument.Folio.reset();\n\t}\n</SCRIPT>\n\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"valida=0;\";\n\tonKeyPress=\"timer_load();timer_reload()\" \n\tonClick=\"timer_load();timer_reload()\">\n<FORM action=\"Folios.jsp\" name=\"Folio\" method=\"post\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\"> \n<INPUT type=\"hidden\" name=\"folio_orden\" value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\"> \n<INPUT type=\"hidden\" name=\"folio_idFolio\" value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\">\n<INPUT type=\"hidden\" name=\"aux\" value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\">\n<INPUT type=\"hidden\" name=\"aux2\" value=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\">\n<INPUT type=\"hidden\" name=\"retURI\" value=\"".toCharArray();
    __oracle_jsp_text[24] = 
    "\">\n<DIV class=\"documentBody\" id=\"Body\" style=\"HEIGHT: 459px\">\n<CENTER>\n<BR>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"3\"><A href=\"".toCharArray();
    __oracle_jsp_text[25] = 
    "\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"\n\t\t\t\talt=\"Regresar\"> </A>\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<a onclick=\"guardarFolio()\">\n\t\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\">\n\t\t\t\t</a>\n\t\t\t</TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"159\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\"><FONT\n\t\t\t\tcolor=\"#00204f\" size=\"37777777777\"><FONT color=\"#00204f\"\n\t\t\t\tsize=\"37777777777\"><FONT size=\"+1\" color=\"#004080\">Folios</FONT></FONT></FONT></FONT></B></TD>\n\t\t\t<TD align=\"right\" colspan=\"2\">&nbsp;<FONT color=\"black\">**Los datos\n\t\t\tmarcados con negritas son obligatorios</FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"159\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t<TD align=\"right\" colspan=\"2\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "<I>".toCharArray();
    __oracle_jsp_text[27] = 
    " - ".toCharArray();
    __oracle_jsp_text[28] = 
    "</I></FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"159\"><BR>\n\t\t\t<BR>\n\t\t\t</TD>\n\t\t\t<TD width=\"479\">&nbsp;</TD>\n\t\t\t<TD width=\"11\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"159\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Unidad\n\t\t\tAdministrativa:</B></FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t<TD colspan=\"2\"><FONT size=\"2\" face=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[30] = 
    "</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t<TD colspan=\"2\"><FONT size=\"2\" face=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[32] = 
    "</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t<TR>\n\t\t\t<TD colspan=\"2\">\n\t\t\t\t<FONT color=\"red\"><B>*Ya existe un Folio de Recepción en esta Unidad Administrativa* </B></FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"159\">&nbsp;</TD>\n\t\t\t<TD width=\"479\">&nbsp;</TD>\n\t\t\t<TD width=\"11\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"159\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">Tipo de Folio:</FONT></TD>\n\t\t\t<TD width=\"479\"><FONT face=\"Verdana\" size=\"2\"> <INPUT type=\"radio\"\n\t\t\t\tvalue=\"1\" name=\"folio_tipo\"\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    " checked>Recepción <INPUT\n\t\t\t\ttype=\"radio\" value=\"0\" name=\"folio_tipo\"\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    ">Turnado</FONT></TD>\n\t\t\t<TD width=\"11\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"159\">&nbsp;</TD>\n\t\t\t<TD width=\"479\">&nbsp;</TD>\n\t\t\t<TD width=\"11\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"159\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Clave:</B></FONT></TD>\n\t\t\t<TD width=\"479\"><FONT face=\"Verdana\" size=\"2\"><INPUT\n\t\t\t\tname=\"folio_clave\"  class=\"blue200a\" value=\"".toCharArray();
    __oracle_jsp_text[38] = 
    "\" maxlength=\"199\"></FONT></TD>\n\t\t\t<TD width=\"11\">&nbsp;</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t<TR>\n\t\t\t<TD colspan=\"2\">\n\t\t\t\t<FONT color=\"red\"><B>*Ya existe esta Clave* </B></FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"159\">&nbsp;</TD>\n\t\t\t<TD width=\"479\">&nbsp;</TD>\n\t\t\t<TD width=\"11\">&nbsp;</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"159\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">Consecutivo:</FONT></TD>\n\t\t\t<TD width=\"479\"><FONT face=\"Verdana\" size=\"2\"><INPUT size=\"5\"\n\t\t\t\tname=\"folio_consecutivo\" class=\"blue100\" value=\"".toCharArray();
    __oracle_jsp_text[42] = 
    "\" onKeyPress='AceptaSoloTeclaNumericaYPunto();' maxlength=\"5\"></FONT></TD>\n\t\t\t<TD width=\"11\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"159\">&nbsp;</TD>\n\t\t\t<TD width=\"479\">&nbsp;</TD>\n\t\t\t<TD width=\"11\">&nbsp;</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"159\"><FONT face=\"Verdana\" size=\"2\"></FONT></TD>\n\t\t\t<TD width=\"479\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Orden</B></FONT></TD>\n\t\t\t<TD width=\"11\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"159\">&nbsp;</TD>\n\t\t\t<TD width=\"479\">&nbsp;&nbsp;<FONT size=\"-2\">Arrastre las opciones de\n\t\t\tla lista según el orden de importancia</FONT></TD>\n\t\t\t<TD width=\"11\">&nbsp;</TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"3\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</CENTER>\n</DIV>\n</FORM>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n<!-- \n\tvar doc = document.forms[0];\n\tcore.loadUnit(\"listbox\");\n    core.loadUnit(\"drag\");\n\tvar Lista = doc.folio_orden.value; \n    var valores1='';\n    var valores2='';\n\tfor(i=0;i<Lista.length;i++){\n\t\t//alert(\"[\" +i+ \"]=\"+Lista.charAt(i)+\"\\nvalores1=\" + valores1);\n\t\tif(Lista.charAt(i)=='D')\n\t\t\tvalores2 = valores2 + \"Clave de Tipo de Documento,\";\n\t\telse if(Lista.charAt(i)=='A')\n\t\t\tvalores2 = valores2 + \"Clave,\";\n\t\telse if(Lista.charAt(i)=='C')\n\t\t\tvalores2 = valores2 + \"Consecutivo,\";\n\t}\n\tif(Lista.indexOf('D')<0)\n\t\tvalores1 = valores1 + \"Clave de Tipo de Documento,\";\n\tif(Lista.indexOf('A')<0)\n\t\tvalores1 = valores1 + \"Clave,\";\n\tif(Lista.indexOf('C')<0)\n\t\tvalores1 = valores1 + \"Consecutivo,\";\n\t//alert('valores1=' + valores1 + '\\nvalores2=' + valores2);\n\tif(valores1 != '' )\tvalores1= valores1.substring(0, valores1.length-1);\t\t\n\tif(valores2 != '' ) valores2= valores2.substring(0, valores2.length-1);\t\t\n\n    onload=function(){\n      elm1=Listbox({x:430,y:450,w:170,h:70});\n      elm2=Listbox({x:630,y:450,w:170,h:70});\t\n      if(valores1 != '' ) elm1.delimitedText(valores1);\n      if(valores2 != '' ) elm2.delimitedText(valores2);\n\t\t\n      for(var a=0;a<elm1.items.length;a++){\n        core.Elm(elm1.items[a].id);\n        elm1.items[a].turnOnDrag(null,core.drag.dtDragDrop);\n      }\n      for(var a=0;a<elm2.items.length;a++){\n        core.Elm(elm2.items[a].id);\n        elm2.items[a].turnOnDrag(null,core.drag.dtDragDrop);\n      }\n      elm1.ondragdrop=function(){return true};\n      elm2.ondragdrop=function(){return true};\n    }\n\nfunction GetList()\n{\n\tvar doc = document.forms[0];\n\tvar Lista='';\n\tfor(var a=0;a<elm2.items.length;a++){\n\t\tif(elm2.items[a].outerText == 'Clave de Tipo de Documento')\n\t\t\tLista=Lista + 'D';\n\t\tif(elm2.items[a].outerText == 'Clave')\n\t\t\tLista=Lista + 'A';\n\t\tif(elm2.items[a].outerText == 'Consecutivo')\n\t\t\tLista=Lista + 'C';\n    }\n\tdoc.folio_orden.value=Lista;\n}\n\nfunction guardarFolio() { \n\n\tvar doc = document.Folio\n\t//var valida = 0;\n\tvar msg=\"\";\n\tGetList();\n\tLista=doc.folio_orden.value;\n\n//\tif (valida != 1)\t{\n\t\tmensaje = 'Algunos de los campos tienen caracteres invalidos (&, \", <, >, \\', `,  ´)\\nPresione Aceptar para eliminarlos automaticamente\\no Cancelar para regresar'\n\t\tif(detectaCE(doc.folio_clave.value)){\n\t\t\tif (confirm(mensaje)){\n\n\t\t\t\tdoc.folio_clave.value\t= quitaCE(doc.folio_clave.value);\n\t\t\t\tdoc.aux.value\t= quitaCE(doc.aux.value);\n\t\t\t\t\n\t\t\t\tif(doc.folio_idFolio.value != \"\")\n\t\t\t\t\tdoc.accion.value=\"cambiar\";\n\t\t\t\tif(doc.folio_idFolio.value == \"\")\n\t\t\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\t\tdoc.submit();\n\t\t\t}\n\t\t\telse \n\t\t\t\tdoc.accion.value=\"\";\n\t\t}\n\t\telse{\n\t\t\tif(doc.folio_idFolio.value != \"\")\n\t\t\t\tdoc.accion.value=\"cambiar\";\n\t\t\tif(doc.folio_idFolio.value == \"\")\n\t\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\tdoc.submit();\n\t\t}\n//\t}\n\tif (doc.folio_area[doc.folio_area.selectedIndex].value == -1) {\n\t\tvalida =1;\n\t\tmsg = msg + \"Debe seleccionar una Unidad\t\"+ \"\\n\";\n\t}\n\tif(Trim(doc.folio_clave.value) == \"\"){\n\t\tvalida =1;\n\t\tmsg = msg + \"Debe capturar la clave del Folio\t\"+ \"\\n\";\n\t}\n\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\tif(doc.folio_consecutivo.value == \"\"){\n\t\tvalida =1;\n\t\tmsg = msg + \"Debe capturar el numero Consecutivo\t\"+ \"\\n\";\n\t}\n\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\tif(Lista.indexOf('A')<0){\t\t\n\t\tvalida =1;\n\t\tmsg = msg + \"El Orden debe incluir a la Clave\"+ \"\\n\";\n\t}\n\tif(Lista.indexOf('D')<0){\t\t\n\t\tvalida =1;\n\t\tmsg = msg + \"El Orden debe incluir a la Clave de Tipo de Documento\"+ \"\\n\";\n\t}\n\tif(Lista.indexOf('C')<0){\n\t\tvalida =1;\n\t\tmsg = msg + \"El Orden debe incluir al Consecutivo\"+ \"\\n\";\n\t}\n\tif (Trim(quitaPuntos(doc.folio_clave.value)) ==\"\" && doc.folio_clave.value!=\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \"La Clave no es válida\"+ \"\\n\";\n\t}\n\n\tif (valida == 1) \n\t{\n\t\talert(msg);\n\t\tvalida=0;\n\t\treturn false;\n\t}else if(valida == 2){\n\t\talert(\"Su solicitud ya fue enviada\");\n\t\treturn false;\n\t}else{\n\t\tvalida=2;\n\t\tdoc.submit();\n\t}\n}\n</SCRIPT>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
