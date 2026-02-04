package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.Utilerias;
import com.meve.sigma.beans.*;
import com.meve.sigma.taglib.*;


public class _FrameRemitente extends com.orionserver.http.OrionHttpJspPage {


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
    _FrameRemitente page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
          String strProcedencia 	=   "";
      	String strIdArea 		= 	"";
      	String strIdArea1 		= 	"";
      	String strControl		=	"";
      	
      	String strNombre		=	"";
      	String strCargo			=	"";
      	String strIdEntidad		=	"";
      	String strTelefono		=	"";
      	String strCorreo		=	"";
      	String strDireccion		=	"";
      	String strFax			=	"";
      	String strCreador		=	"";
      	String strFechaCreacion	=	"";
      	String strAccion		=	"";
      	String strIdRemitente	=	null;
      	
      	boolean bInsertar		=	false;
      	boolean	bExisteReg 		= 	false;
      	
      	int valida 				= 	-2;
      	
      	strProcedencia			=	request.getParameter("porcedencia");
      	strIdArea 				= 	(request.getParameter("id_us")!=null)?request.getParameter("id_us"):"";
      	strControl				=	(request.getParameter("con")!=null)?request.getParameter("con"):"";
      	String strIdAsunto 		= 	(request.getParameter("ida")!=null)?request.getParameter("ida"):"";
      	String num 				=	request.getParameter("num");
      	strAccion				=	request.getParameter("accion");
      	String retURI 			= 	(request.getParameter("retURI")!=null)?request.getParameter("retURI"):"portalPrincipal.jsp";
      	String strIdRmt 		= 	(request.getParameter("idRemitente")!=null)?request.getParameter("idRemitente"):"";
      
      	String strBusqueda = (request.getParameter("buscar")!=null)?request.getParameter("buscar"):"";
      	boolean bBuscar 	= Utilerias.detectaCEBuscar(strBusqueda)?true:false;
      	strBusqueda 		= Utilerias.detectaCEBuscar(strBusqueda)?"":strBusqueda;
      	
      	String strBusqueda2 = (request.getParameter("buscar2")!=null)?request.getParameter("buscar2"):"";
      	boolean bBuscar2 	= Utilerias.detectaCEBuscar(strBusqueda2)?true:false;
      	strBusqueda2 		= Utilerias.detectaCEBuscar(strBusqueda2)?"":strBusqueda2;
      	
      	bExisteReg				=	ActualizaRemitente.getExistenRemitentes();
      	
      	if(strAccion != null && strAccion.equals("guardar")){
      		strNombre		=	request.getParameter("remitente");
      		strIdArea1		=	request.getParameter("remitenteArea");
      		strCargo		=	request.getParameter("remitenteCargo");
      		strIdEntidad	=	request.getParameter("remitenteEntidad");
      		strDireccion	=	request.getParameter("remitenteDireccion");
      		strTelefono		=	request.getParameter("remitenteTelefono");
      		strFax			=	request.getParameter("remitenteFax");
      		strCorreo		=	request.getParameter("remitenteCorreo");
      
      		valida = ActualizaRemitente.getRemitenteExiste(strNombre, "1a2b3c", strIdEntidad, "1a2b3c");
      
      		if (valida == 2)
      		{
      			bInsertar	= 	ActualizaRemitente.InsertarRemitente(	strIdRemitente, strNombre, strCargo, strIdArea1, strIdEntidad, strTelefono,
      																	strCorreo, BUsuario.getIdUsuario(), strFechaCreacion, "1", strDireccion, strFax);
      			strIdRmt = "0";
      			if(bInsertar){
      				strIdRmt = ActualizaRemitente.ultimoIdRemitente();
      			}
      			try{
      				if("receptor".equals(strProcedencia)){
      					response.sendRedirect(retURI);
      			}else{ 
      			    response.sendRedirect("FrameRemitente.jsp?id_us="+strIdArea+"&con="+strControl+"&ida="+strIdAsunto+"&num=1&idRemitente="+strIdRmt);
      			}
      			}catch(Exception io){
      				//System.out.println("ErrorRedirect-->"+io);
      			}
      		}
      	}
      
      out.write(__oracle_jsp_text[4]);
      out.print( "FrameRemitente.jsp?id_us="+strIdArea+"&con="+strControl+"&ida="+strIdAsunto+"&num=1&idRemitente="+strIdRmt );
      out.write(__oracle_jsp_text[5]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[6]);
      out.print(strControl);
      out.write(__oracle_jsp_text[7]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[8]);
      out.print(num);
      out.write(__oracle_jsp_text[9]);
      out.print( retURI );
      out.write(__oracle_jsp_text[10]);
      out.print( strIdRmt );
      out.write(__oracle_jsp_text[11]);
      out.print( strProcedencia );
      out.write(__oracle_jsp_text[12]);
      if(num.equals("1")){
      out.write(__oracle_jsp_text[13]);
      out.print( strBusqueda );
      out.write(__oracle_jsp_text[14]);
      out.print( strBusqueda2 );
      out.write(__oracle_jsp_text[15]);
      out.print(strControl);
      out.write(__oracle_jsp_text[16]);
       if(bExisteReg){ 
      out.write(__oracle_jsp_text[17]);
       if(strControl.equals("0")){ 
      out.write(__oracle_jsp_text[18]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaRemitente.getRemitenteFrame(strIdArea,strBusqueda,strBusqueda2));
        __jsp_taghandler_1.setCampo("campo");
        java.lang.String campo1 = null;
        java.lang.String campo2 = null;
        java.lang.String campo3 = null;
        java.lang.String campo4 = null;
        java.lang.String campo5 = null;
        java.lang.String campo6 = null;
        java.lang.String campo7 = null;
        java.lang.String campo8 = null;
        java.lang.String campo9 = null;
        java.lang.String campo10 = null;
        java.lang.String campo11 = null;
        java.lang.String campo12 = null;
        java.lang.String campo13 = null;
        java.lang.String campo14 = null;
        java.lang.String campo15 = null;
        java.lang.String campo16 = null;
        java.lang.String campo17 = null;
        java.lang.String campo18 = null;
        java.lang.String campo19 = null;
        java.lang.String campo20 = null;
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_1,__jsp_tag_starteval,out);
          do {
            campo1 = (java.lang.String) pageContext.findAttribute("campo1");
            campo2 = (java.lang.String) pageContext.findAttribute("campo2");
            campo3 = (java.lang.String) pageContext.findAttribute("campo3");
            campo4 = (java.lang.String) pageContext.findAttribute("campo4");
            campo5 = (java.lang.String) pageContext.findAttribute("campo5");
            campo6 = (java.lang.String) pageContext.findAttribute("campo6");
            campo7 = (java.lang.String) pageContext.findAttribute("campo7");
            campo8 = (java.lang.String) pageContext.findAttribute("campo8");
            campo9 = (java.lang.String) pageContext.findAttribute("campo9");
            campo10 = (java.lang.String) pageContext.findAttribute("campo10");
            campo11 = (java.lang.String) pageContext.findAttribute("campo11");
            campo12 = (java.lang.String) pageContext.findAttribute("campo12");
            campo13 = (java.lang.String) pageContext.findAttribute("campo13");
            campo14 = (java.lang.String) pageContext.findAttribute("campo14");
            campo15 = (java.lang.String) pageContext.findAttribute("campo15");
            campo16 = (java.lang.String) pageContext.findAttribute("campo16");
            campo17 = (java.lang.String) pageContext.findAttribute("campo17");
            campo18 = (java.lang.String) pageContext.findAttribute("campo18");
            campo19 = (java.lang.String) pageContext.findAttribute("campo19");
            campo20 = (java.lang.String) pageContext.findAttribute("campo20");
            out.write(__oracle_jsp_text[19]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[20]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[21]);
            out.print( campo3 );
            out.write(__oracle_jsp_text[22]);
            out.print( campo4 );
            out.write(__oracle_jsp_text[23]);
            out.print( (strIdRmt.equals(campo1))?"checked=\"checked\"":"");
            out.write(__oracle_jsp_text[24]);
            out.print( campo3 );
            out.write(__oracle_jsp_text[25]);
            out.print( Utilerias.recortaString(campo3,60) );
            out.write(__oracle_jsp_text[26]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[27]);
            out.print( Utilerias.recortaString(campo2,60) );
            out.write(__oracle_jsp_text[28]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[29]);
       }else if(strControl.equals("1")){ 
      out.write(__oracle_jsp_text[30]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_2=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setDatos(ActualizaRemitente.getRemitenteInternas(strIdArea,strBusqueda,strBusqueda2));
        __jsp_taghandler_2.setCampo("campo");
        java.lang.String campo1 = null;
        java.lang.String campo2 = null;
        java.lang.String campo3 = null;
        java.lang.String campo4 = null;
        java.lang.String campo5 = null;
        java.lang.String campo6 = null;
        java.lang.String campo7 = null;
        java.lang.String campo8 = null;
        java.lang.String campo9 = null;
        java.lang.String campo10 = null;
        java.lang.String campo11 = null;
        java.lang.String campo12 = null;
        java.lang.String campo13 = null;
        java.lang.String campo14 = null;
        java.lang.String campo15 = null;
        java.lang.String campo16 = null;
        java.lang.String campo17 = null;
        java.lang.String campo18 = null;
        java.lang.String campo19 = null;
        java.lang.String campo20 = null;
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_2,__jsp_tag_starteval,out);
          do {
            campo1 = (java.lang.String) pageContext.findAttribute("campo1");
            campo2 = (java.lang.String) pageContext.findAttribute("campo2");
            campo3 = (java.lang.String) pageContext.findAttribute("campo3");
            campo4 = (java.lang.String) pageContext.findAttribute("campo4");
            campo5 = (java.lang.String) pageContext.findAttribute("campo5");
            campo6 = (java.lang.String) pageContext.findAttribute("campo6");
            campo7 = (java.lang.String) pageContext.findAttribute("campo7");
            campo8 = (java.lang.String) pageContext.findAttribute("campo8");
            campo9 = (java.lang.String) pageContext.findAttribute("campo9");
            campo10 = (java.lang.String) pageContext.findAttribute("campo10");
            campo11 = (java.lang.String) pageContext.findAttribute("campo11");
            campo12 = (java.lang.String) pageContext.findAttribute("campo12");
            campo13 = (java.lang.String) pageContext.findAttribute("campo13");
            campo14 = (java.lang.String) pageContext.findAttribute("campo14");
            campo15 = (java.lang.String) pageContext.findAttribute("campo15");
            campo16 = (java.lang.String) pageContext.findAttribute("campo16");
            campo17 = (java.lang.String) pageContext.findAttribute("campo17");
            campo18 = (java.lang.String) pageContext.findAttribute("campo18");
            campo19 = (java.lang.String) pageContext.findAttribute("campo19");
            campo20 = (java.lang.String) pageContext.findAttribute("campo20");
            out.write(__oracle_jsp_text[31]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[32]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[33]);
            out.print( campo3 );
            out.write(__oracle_jsp_text[34]);
            out.print( campo4 );
            out.write(__oracle_jsp_text[35]);
            out.print( (strIdRmt.equals(campo1))?"checked=\"checked\"":"");
            out.write(__oracle_jsp_text[36]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[37]);
            out.print( Utilerias.recortaString(campo2,60) );
            out.write(__oracle_jsp_text[38]);
            out.print( campo3 );
            out.write(__oracle_jsp_text[39]);
            out.print( Utilerias.recortaString(campo3,60) );
            out.write(__oracle_jsp_text[40]);
          } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[41]);
       } 
      out.write(__oracle_jsp_text[42]);
       } else { 
      out.write(__oracle_jsp_text[43]);
      out.print( bBuscar );
      out.write(__oracle_jsp_text[44]);
      }
      out.write(__oracle_jsp_text[45]);
      }
      out.write(__oracle_jsp_text[46]);
      if(num.equals("2")){
      out.write(__oracle_jsp_text[47]);
      out.print( retURI );
      out.write(__oracle_jsp_text[48]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_3.setName("remitenteArea");
        __jsp_taghandler_3.setSize(1);
        __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( BUsuario.getIdArea()));
        __jsp_taghandler_3.setClassHtml("blue500a");
        __jsp_taghandler_3.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[49]);
      out.print(strNombre );
      out.write(__oracle_jsp_text[50]);
      if (valida == 1) {
      out.write(__oracle_jsp_text[51]);
      } 
      out.write(__oracle_jsp_text[52]);
      out.print(strCargo );
      out.write(__oracle_jsp_text[53]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_4=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setData(ComboData.getEntidadAreaCombo(BUsuario.getIdArea()));
        __jsp_taghandler_4.setName("remitenteEntidad");
        __jsp_taghandler_4.setSize(1);
        __jsp_taghandler_4.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_4.setClassHtml("blue500a");
        __jsp_taghandler_4.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_4.setTextoNoSeleccion(" ------------ Selecciona una Entidad ------------ ");
        __jsp_taghandler_4.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[54]);
      out.print(strDireccion );
      out.write(__oracle_jsp_text[55]);
      out.print(strTelefono );
      out.write(__oracle_jsp_text[56]);
      out.print(strFax );
      out.write(__oracle_jsp_text[57]);
      out.print(strCorreo );
      out.write(__oracle_jsp_text[58]);
      }
      out.write(__oracle_jsp_text[59]);

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
  private static final char __oracle_jsp_text[][]=new char[60][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n\n\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Remitente</TITLE>\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\nfunction cambioVista(){\n\tdoc = document.frameremitente;\n\tdoc.id_us.value = doc.id_us.value;\n\tdoc.con.value = doc.con.value;\n\tdoc.ida.value = doc.ida.value;\n\tdoc.num.value = 2;\n\tdoc.retURI.value = \"".toCharArray();
    __oracle_jsp_text[5] = 
    "\"\n\tdoc.submit();\n\n}\nfunction cambioVista1(){\n\tdoc = document.frameremitente;\n\tdoc.id_us.value = doc.id_us.value;\n\tdoc.con.value = doc.con.value;\n\tdoc.ida.value = doc.ida.value;\n\tdoc.num.value = 1;\n\tdoc.submit();\n}\n</SCRIPT>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" \n\tonunload=\"opener.hay_hija=true\"\n\tonClick=\"opener.resetTimer();\"\n\tonKeyPress=\"opener.resetTimer();\">\n<form name=\"frameremitente\" action=\"FrameRemitente.jsp\" method=\"post\">\n<INPUT type=\"hidden\" name=\"id_us\" value=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\">\n<INPUT type=\"hidden\" name=\"con\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\">\n<INPUT type=\"hidden\" name=\"ida\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\">\n<INPUT type=\"hidden\" name=\"num\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT name=\"retURI\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\" type=\"hidden\">\n<INPUT name=\"idRemitente\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\" type=\"hidden\">\n<input name=\"porcedencia\"value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\"type=\"hidden\"/>\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"367\" class=\"etiquetas\"> \n\t\t\t<div align=\"left\">\n\t\t\t\t<!--<input type=\"button\" onclick=\"\" value=\"Internas\" class=\"blue100\">-->\n\t\t\t\tPuesto:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<INPUT name=\"buscar\" type=\"text\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" class=\"blue200\" width=\"50\" maxlength=\"199\"><BR>\n\t\t\t\tResponsable:&nbsp;\n\t\t\t\t<INPUT name=\"buscar2\" type=\"text\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" class=\"blue200\" width=\"50\" maxlength=\"199\">\n\t\t\t\tBuscar:&nbsp;<A title=\"Buscar\" onclick=\"buscarRemitente();\"><IMG border=\"0\" src=\"../Imagenes/ico_bus.gif\" width=\"26\" height=\"26\" ></A><br>\n\t\t\t</div>\n\t\t</td>\n\t\t<td width=\"10\">\n\t\t\t<div align=\"right\">\n\t\t\t\t\n\t\t\t</div>\n\t\t</td>\n\t\t<td width=\"\">\n\t\t\t&nbsp;\n\t\t</td>\n\n\t\t<td width=\"500\">\n\t\t\t<DIV align=\"right\">\n\t\t\t\t<input type=\"button\" value=\"Otro Remitente...\" class=\"blue200a\" onclick=\"cambioVista()\">\n\t\t\t\t<input type=\"button\" value=\"Aceptar\" class=\"blue100a\" onclick=\"AceptarRemitenteFrame(".toCharArray();
    __oracle_jsp_text[16] = 
    ")\">\n\t\t\t\t<input type=\"button\" value=\"Cancelar\" class=\"blue100a\" onclick=\"Cancelar()\">\n\t\t\t</DIV>\n\t\t</td>\n\t</tr>\n</table>\n<BR>\n<div align=\"left\">\n</div>\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\">\n\t\t\t<b><font size=\"2\" color=\"#00204F\" face=\"Verdana\">Remitentes</font></b>\n\t\t\t<b><font size=\"2\" color=\"#00204F\" face=\"Verdana\">de la Unidad</font></b>\n\t\t</td>\n\t</tr>\n</table>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='50%' align=\"center\">\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"verdana\"><b>Puesto</b></font>\n\t\t</TD>\n\t\t<TD WIDTH='50%' align=\"center\">\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"verdana\"><b>Responsable</b></font>\n\t\t</TD>\n\t</TR>\t\n</TABLE>\n<DIV class=documentBody id=Body>\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\n<TABLE width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"5%\">\n\t\t\t\t<INPUT type=\"radio\" name=\"Sel\" value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "|".toCharArray();
    __oracle_jsp_text[21] = 
    "/".toCharArray();
    __oracle_jsp_text[22] = 
    "*".toCharArray();
    __oracle_jsp_text[23] = 
    "\" ".toCharArray();
    __oracle_jsp_text[24] = 
    ">\n\t\t\t</TD>\n\t\t\t<TD width=\"42%\">\n\t\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[25] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[26] = 
    " </A>\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"5%\"> &nbsp;&nbsp;</TD>\n\t\t\t<TD width=\"48%\">\n\t\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[27] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[28] = 
    " </A>\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"5%\">\n\t\t\t\t<INPUT type=\"radio\" name=\"Sel\" value=\"".toCharArray();
    __oracle_jsp_text[32] = 
    "|".toCharArray();
    __oracle_jsp_text[33] = 
    "/".toCharArray();
    __oracle_jsp_text[34] = 
    "*".toCharArray();
    __oracle_jsp_text[35] = 
    "\" ".toCharArray();
    __oracle_jsp_text[36] = 
    ">\n\t\t\t</TD>\n\t\t\t<TD width=\"42%\">\n\t\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[37] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[38] = 
    " </A>\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"5%\"> &nbsp;&nbsp;</TD>\n\t\t\t<TD width=\"48%\">\n\t\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[39] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[40] = 
    " </A>\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[43] = 
    "\n<CENTER>\n<table cellspacing=\"2\" cellpadding=\"2\">\n\t<tr>\n\t\t<TD align=\"center\">\n\t\t\t<DIV align=\"center\">\n\t\t\t\t<p><FONT size=\"4\" face=\"Verdana\">***** No se han encontrado\n\t\tDocumentos ***** </FONT></DIV>\n\t\t</TD>\n\t</tr>\n</table>\n</CENTER>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n\tif (".toCharArray();
    __oracle_jsp_text[44] = 
    ")\n\t\talert(\"No se permiten caracteres especiales ( % , & , \\' ) en la Busqueda \"+ \"\\n\");\n</SCRIPT>\n".toCharArray();
    __oracle_jsp_text[45] = 
    "\n<BR>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n".toCharArray();
    __oracle_jsp_text[46] = 
    "\n".toCharArray();
    __oracle_jsp_text[47] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"150\">\n\t\t\t<!-- <a onclick=\"cambioVista1()\"> -->\n\t\t\t<a href=\"".toCharArray();
    __oracle_jsp_text[48] = 
    "\">\n\t\t\t<img src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\" border=\"0\">\n\t\t\t</a>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<a onclick=\"guardarRemitenteOtro1()\">\n\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\" border=\"0\">\n\t\t\t</a>\n\t\t&nbsp;</TD>\n\t\t<TD width=\"150\">\n\n\t\t&nbsp;</TD>\n\t\t<TD width=\"150\"></TD>\n\t\t<TD width=\"217\"></TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n<BR>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n        <TR valign=\"top\">\n            <TD width=\"336\" colspan=\"2\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Remitentes</FONT></B></TD>\n            <TD width=\"144\">&nbsp;</TD>\n            <TD width=\"192\">&nbsp;</TD>\n        </TR>\n        <TR valign=\"top\">\n\t\t\t<td bgcolor=\"#004080\" colspan=\"4\" width=\"672\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT>\n\t\t\t</TD>\n\t\t\t<TD align=\"right\" colspan=\"3\" width=\"528\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\"></FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n    \t</TR>\n    </TBODY>\n</TABLE>\n</DIV>\n\n\n\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Unidad\n\t\t\tAdministrativa:</B></FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\">\n\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Nombre:</B></FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue500\" name=\"remitente\" value=\"".toCharArray();
    __oracle_jsp_text[50] = 
    "\" maxlength=\"199\"></FONT>\n\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "<br>\n\t\t<FONT color=\"red\"><B>*Este Nombre ya existe en esta Entidad* </B></FONT>".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t\t</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Cargo:</B></FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue500\" name=\"remitenteCargo\" value=\"".toCharArray();
    __oracle_jsp_text[53] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Entidad:</B></FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Dirección:</FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue500\" name=\"remitenteDireccion\" value=\"".toCharArray();
    __oracle_jsp_text[55] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Telefono:</FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue500\" name=\"remitenteTelefono\" value=\"".toCharArray();
    __oracle_jsp_text[56] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Fax:</FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue500\" name=\"remitenteFax\" value=\"".toCharArray();
    __oracle_jsp_text[57] = 
    "\" maxlength=\"49\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Correo:</FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue500\" name=\"remitenteCorreo\" value=\"".toCharArray();
    __oracle_jsp_text[58] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t\n    </TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[59] = 
    "\n</form>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
