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


public class _DinamicRemitente extends com.orionserver.http.OrionHttpJspPage {


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
    _DinamicRemitente page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      com.meve.sigma.beans.BeanRemitente Bremitente;
      synchronized (pageContext) {
        if ((Bremitente = (com.meve.sigma.beans.BeanRemitente) pageContext.getAttribute( "Bremitente", PageContext.PAGE_SCOPE)) == null) {
          Bremitente = (com.meve.sigma.beans.BeanRemitente) new com.meve.sigma.beans.BeanRemitente();
          pageContext.setAttribute( "Bremitente", Bremitente, PageContext.PAGE_SCOPE);
          out.write(__oracle_jsp_text[2]);
          OracleJspRuntime.__jspSetAllParams(request, (Object)Bremitente, true);
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
           if(BUsuario.getTurnado() ||
          	BUsuario.getRecepcion()){ 
          out.write(__oracle_jsp_text[7]);
          }else{
          out.write(__oracle_jsp_text[8]);
          if (true) {
            String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
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
          	String strAccion		=	"";
          	String strEstatus		=	"1";
          	String strEntidades[][] = 	null;
          	String strRemitentes[][]=	null;
          	
          
          	boolean bInsertar		=	false;
          	int valida = -2;
          
          	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
          	java.util.Date f 				=	new java.util.Date();
          	strFechaCreacion 				=	sdf.format(f);
          
          	strCreador1		=	BUsuario.getIdUsuario();
          	strCreador		=	BUsuario.getNombre();
          	strIdRemitente	=	request.getParameter("id_remitente");
          
          	strAccion		=	request.getParameter("accion");
          
          	if(strIdRemitente != null)
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
          
          		valida = ActualizaRemitente.getRemitenteExiste(strNombre, "1a2b3c", strIdEntidad, "1a2b3c");
          
          		if (valida == 2)
          		{
          			bInsertar	= 	ActualizaRemitente.InsertarRemitente(	strIdRemitente, strNombre, strCargo, strIdArea, strIdEntidad, strTelefono,
          																	strCorreo, strCreador1, strFechaCreacion, strEstatus, strDireccion, strFax);
          			
          			String strIdRem = "";
          			if(bInsertar)
          				strIdRem = ActualizaRemitente.ultimoIdRemitente();
          			try{
          			
          out.write(__oracle_jsp_text[11]);
          out.print(strIdRem);
          out.write(__oracle_jsp_text[12]);
          out.print(strNombre);
          out.write(__oracle_jsp_text[13]);
          out.print(strCargo);
          out.write(__oracle_jsp_text[14]);
          out.print(strCorreo);
          out.write(__oracle_jsp_text[15]);
          out.print(strNombre);
          out.write(__oracle_jsp_text[16]);
           
          			}catch(Exception io){
          				//System.out.println("ErrorRedirect-->"+io);
          			}
          		}
          	}
          
          out.write(__oracle_jsp_text[17]);
          if (strIdRemitente!=null){ 
          out.write(__oracle_jsp_text[18]);
          out.print(strIdRemitente );
          out.write(__oracle_jsp_text[19]);
          }
          out.write(__oracle_jsp_text[20]);
          out.print( strCreador );
          out.write(__oracle_jsp_text[21]);
          out.print( strFechaCreacion );
          out.write(__oracle_jsp_text[22]);
           if(BUsuario.getSupervisor() || BUsuario.getRecepcion() || BUsuario.getTurnado()){ 
          out.write(__oracle_jsp_text[23]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_1.setParent(null);
            __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
            __jsp_taghandler_1.setName("remitenteArea");
            __jsp_taghandler_1.setSize(1);
            __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strIdArea));
            __jsp_taghandler_1.setClassHtml("blue500a");
            __jsp_taghandler_1.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='entidades()'");
            __jsp_taghandler_1.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
            __jsp_taghandler_1.setValorNoSeleccion("-1");
            __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
            if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
          }
          out.write(__oracle_jsp_text[24]);
           }else{ 
          out.write(__oracle_jsp_text[25]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_2.setParent(null);
            __jsp_taghandler_2.setData(ComboData.getAreasCombo());
            __jsp_taghandler_2.setName("remitenteArea");
            __jsp_taghandler_2.setSize(1);
            __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strIdArea));
            __jsp_taghandler_2.setClassHtml("blue500a");
            __jsp_taghandler_2.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='entidades()'");
            __jsp_taghandler_2.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
            __jsp_taghandler_2.setValorNoSeleccion("-1");
            __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
            if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
          }
          out.write(__oracle_jsp_text[26]);
           } 
          out.write(__oracle_jsp_text[27]);
          out.print(strNombre );
          out.write(__oracle_jsp_text[28]);
          if (valida == 1) {
          out.write(__oracle_jsp_text[29]);
          } 
          out.write(__oracle_jsp_text[30]);
          out.print(strCargo );
          out.write(__oracle_jsp_text[31]);
          if(strIdArea.length() > 0){
          out.write(__oracle_jsp_text[32]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_3.setParent(null);
            __jsp_taghandler_3.setData(ComboData.getEntidadAreaCombo(strIdArea));
            __jsp_taghandler_3.setName("remitenteEntidad");
            __jsp_taghandler_3.setSize(1);
            __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( strIdEntidad));
            __jsp_taghandler_3.setClassHtml("blue500a");
            __jsp_taghandler_3.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
            __jsp_taghandler_3.setTextoNoSeleccion(" ------------ Selecciona una Entidad ------------ ");
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
          out.print(strDireccion );
          out.write(__oracle_jsp_text[36]);
          out.print(strTelefono );
          out.write(__oracle_jsp_text[37]);
          out.print(strFax );
          out.write(__oracle_jsp_text[38]);
          out.print(strCorreo );
          out.write(__oracle_jsp_text[39]);
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
  private static final char __oracle_jsp_text[][]=new char[40][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<TITLE>Remitentes</TITLE>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n\t".toCharArray();
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
    "\n\t\t\t<SCRIPT language=JavaScript type=text/javascript>\n\t\t\t\t\t{\n\t\t\t\t\t\t//opener.document.getElementById('Remitente').contentWindow.location.reload();\n\t\t\t\t\t\twindow.opener.document.Asunto.idRemitente.value = ".toCharArray();
    __oracle_jsp_text[12] = 
    ";\n\t\t\t\t\t\twindow.opener.document.Asunto.asuntoRemitente.value = '".toCharArray();
    __oracle_jsp_text[13] = 
    "';\n\t\t\t\t\t\twindow.opener.document.Asunto.asuntoCargo.value = '".toCharArray();
    __oracle_jsp_text[14] = 
    "';\n\t\t\t\t\t\twindow.opener.document.Asunto.asuntoCorreo.value = '".toCharArray();
    __oracle_jsp_text[15] = 
    "';\n\t\t\t\t\t\twindow.opener.document.Asunto.asuntoFirmante.value = '".toCharArray();
    __oracle_jsp_text[16] = 
    "';\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t}\n\t\t\t</SCRIPT>\n\n\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\nfunction entidades() {\n\tdoc = document.dRemitente;\n\tdoc.accion.value=\"reload\";\n\tdoc.submit();\n}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onunload=\"opener.hay_hija=false\"\n\tonClick=\"opener.resetTimer();\"\n\tonKeyPress=\"opener.resetTimer();\">\n<FORM action=\"DinamicRemitente.jsp\" name=\"dRemitente\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"id_remitente\">\n".toCharArray();
    __oracle_jsp_text[20] = 
    "\n<BR>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"150\">\n\t\t\t<a onclick=\"window.close();\">\n\t\t\t<img src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\" border=\"0\">\n\t\t\t</a>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<a onclick=\"guardarRemitenteOtro()\">\n\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\" border=\"0\">\n\t\t\t</a>\n\t\t&nbsp;</TD>\n\t\t<TD width=\"150\">\n\n\t\t&nbsp;</TD>\n\t\t<TD width=\"150\"></TD>\n\t\t<TD width=\"217\"></TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n<BR>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n        <TR valign=\"top\">\n            <TD width=\"336\" colspan=\"2\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Remitentes</FONT></B></TD>\n            <TD width=\"144\">&nbsp;</TD>\n            <TD width=\"192\">&nbsp;</TD>\n        </TR>\n        <TR valign=\"top\">\n\t\t\t<td bgcolor=\"#004080\" colspan=\"4\" width=\"672\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT>\n\t\t\t</TD>\n\t\t\t<TD align=\"right\" colspan=\"3\" width=\"528\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">Creado por: <I>".toCharArray();
    __oracle_jsp_text[21] = 
    " - ".toCharArray();
    __oracle_jsp_text[22] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n    \t</TR>\n    </TBODY>\n</TABLE>\n</DIV>\n\n\n\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Unidad\n\t\t\tAdministrativa:</B></FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\">\n\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Nombre:</B></FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue500\" name=\"remitente\" value=\"".toCharArray();
    __oracle_jsp_text[28] = 
    "\" maxlength=\"199\"></FONT>\n\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "<br>\n\t\t<FONT color=\"red\"><B>*Este Nombre ya existe en esta Entidad* </B></FONT>".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Cargo:</FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue500\" name=\"remitenteCargo\" value=\"".toCharArray();
    __oracle_jsp_text[31] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Entidad:</B></FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t\t<SELECT class=\"blue500a\" name=\"remitenteEntidad\">\n\t\t\t\t\t<OPTION value=\"-1\">------------ Selecciona una Entidad ------------</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Dirección:</FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue500\" name=\"remitenteDireccion\" value=\"".toCharArray();
    __oracle_jsp_text[36] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Telefono:</FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue500\" name=\"remitenteTelefono\" value=\"".toCharArray();
    __oracle_jsp_text[37] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Fax:</FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue500\" name=\"remitenteFax\" value=\"".toCharArray();
    __oracle_jsp_text[38] = 
    "\" maxlength=\"49\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Correo:</FONT></TD>\n\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT class=\"blue500\" name=\"remitenteCorreo\" value=\"".toCharArray();
    __oracle_jsp_text[39] = 
    "\" maxlength=\"199\"></FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t\n    </TBODY>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
