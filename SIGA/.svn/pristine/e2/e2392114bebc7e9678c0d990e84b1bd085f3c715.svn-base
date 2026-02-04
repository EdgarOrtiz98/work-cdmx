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
import com.meve.sigma.ldap.*;


public class _DinamicExterno extends com.orionserver.http.OrionHttpJspPage {


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
    _DinamicExterno page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      com.meve.sigma.beans.AreaBean BUsuario1;
      synchronized (pageContext) {
        if ((BUsuario1 = (com.meve.sigma.beans.AreaBean) pageContext.getAttribute( "BUsuario1", PageContext.PAGE_SCOPE)) == null) {
          BUsuario1 = (com.meve.sigma.beans.AreaBean) new com.meve.sigma.beans.AreaBean();
          pageContext.setAttribute( "BUsuario1", BUsuario1, PageContext.PAGE_SCOPE);
          out.write(__oracle_jsp_text[2]);
          OracleJspRuntime.__jspSetAllParams(request, (Object)BUsuario1, true);
          out.write(__oracle_jsp_text[3]);
          out.write(__oracle_jsp_text[4]);
          out.write(__oracle_jsp_text[5]);
          out.write(__oracle_jsp_text[6]);
          out.write(__oracle_jsp_text[7]);
          out.write(__oracle_jsp_text[8]);
          com.meve.sigma.beans.EscrituraBean BEscritura;
          synchronized (pageContext) {
            if ((BEscritura = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscritura", PageContext.PAGE_SCOPE)) == null) {
              BEscritura = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
              pageContext.setAttribute( "BEscritura", BEscritura, PageContext.PAGE_SCOPE);
            }
          }
          out.write(__oracle_jsp_text[9]);
          
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
          
          
          out.write(__oracle_jsp_text[10]);
           if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
          		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
          		//(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
          		//(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
          		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
          out.write(__oracle_jsp_text[11]);
          if (true) {
            String __url=OracleJspRuntime.toStr("../Error/ERError.jsp");
            // Forward 
            pageContext.forward( __url);
            return;
          }

          out.write(__oracle_jsp_text[12]);
           } 
          out.write(__oracle_jsp_text[13]);
          
          	String recCreador[][]  	= 	null;
          	String recUsuario[][] 	= 	null;
          	String strIdsRol[][]	=	null;
          	String strIdsCorreos[][]=	null;
          	String strUsrLDAP[][]	=	null;
          	String strIdUsuario 	= 	"";
          	String strUsuario 		= 	"";//(BUsuario1.getUsuarioNombre()== null)?"":BUsuario1.getUsuarioNombre();
          	String strIdArea 		= 	"";//(BUsuario1.getUsuarioArea()== null)?"":BUsuario1.getUsuarioArea();
          	String strDesc 		= 	"";//(BUsuario1.getUsuarioCargo()== null)?"":BUsuario1.getUsuarioCargo();
          	String strCorreo 		= 	"";//(BUsuario1.getUsuarioEmail()== null)?"":BUsuario1.getUsuarioEmail();
          	String strTelefono 		= 	"";//(BUsuario1.getUsuarioTelefono()== null)?"":BUsuario1.getUsuarioTelefono();
          	String strConsecutivo 	= 	"";//(BUsuario1.getUsuarioConsecutivo()== null)?"0":BUsuario1.getUsuarioConsecutivo();
          	String strIdRol			=	"";//(BUsuario1.getUsuarioRol1()== null)?"":BUsuario1.getUsuarioRol1();
          	String strIdJefe 		= 	"";//(BUsuario1.getUsuarioJefe()== null)?"":BUsuario1.getUsuarioJefe();
          	String strIdAsistente 	= 	"";//(BUsuario1.getUsuarioAsistente()== null)?"":BUsuario1.getUsuarioAsistente();
          	String strCadenaMando 	= 	"";
          	String strcompasArea 	= 	"";
          	String strCreador 		= 	"";
          	String strCreador1 		= 	"";
          	String strFechaCreacion	=	"";
          	String strAccion 		= 	"";
          	String strEstatus 		= 	"1";
          
          	String strUID			=	"";//(BUsuario1.getUid()== null)?"":BUsuario1.getUid();
          	String strUID1			=	"";
          	String strActivarLDAP	=	application.getInitParameter("ActivarLDAP");
          
          	String strAux = "1a2b3c", strAux2 = "1a2b3c";
          	int valida = -2;
          	boolean insertado = false;
              
          	boolean blnExisteFirma	=	false; //Para comprobar si existe una firma digital
          	boolean bInsertar 		= 	false; //Insertar un nuevo usuario
          	boolean bActualizar 	= 	false; //Actualizar datos de un usuario
          	boolean bExisteUsuario	=	false; //Si existe un usuario en la base de datos
          	boolean bInsertaRol		=	false; //Inserta el rol del usuario
          	boolean bInsertaCorreo	=	false; //Inserta la Configuración de correos
          	boolean bExisteUSR		=	false;
          	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
          	java.util.Date f = new java.util.Date();
          	strFechaCreacion = sdf.format(f);
          
          	strCreador1	=	BUsuario.getIdUsuario();
          	strCreador	=	BUsuario.getNombre();
          		
          	strIdUsuario = (request.getParameter("id_usuario")!=null)?request.getParameter("id_usuario"):"";
          	strAccion 	= 	request.getParameter("accion");
          	//** Cuando se desea ver la información de un usuario en especifico
          	//** se manda a ejecutar un query con todos los datos del usuario para
          	//** ser mostrados en la vista del Usuario
          	if (strAccion != null && strAccion.equals("consultar"))
          	{
          		strIdUsuario = (request.getParameter("id_usuario")!=null)?request.getParameter("id_usuario"):"";
          		if (strIdUsuario != null) {
          			recUsuario       	= 	ActualizaDestino.getDestino(strIdUsuario);
          
          			String ini = recUsuario[0][0];
          			strDesc	     		= 	recUsuario[0][1];
          			strUsuario        	= 	recUsuario[0][2];
          			strCorreo        	= 	recUsuario[0][3];
          			strTelefono      	= 	recUsuario[0][4];
          			strIdArea       	= 	recUsuario[0][5];
          
          			strAux = strUsuario;
          			strAux2 = strIdArea;
          		}
          	}//** Fin Consultar información Usuario
          
          	//** Si se va a actualizar algun cambio en los datos de un usuario
          	//** se ejecuta este blooque de codigo
          	//** Si se va a crear un nuevo usuario
          	//** se ejecuta este bloque de codigo
          	if (strAccion != null && strAccion.equals("guardar"))
          	{
          		if (strIdUsuario == null || strIdUsuario.equalsIgnoreCase("") ) {
          			strUsuario		= 	request.getParameter("usuarioNombre");
          			strUID			=	request.getParameter("uid");
          			strIdArea		= 	request.getParameter("usuarioArea");
          			strDesc			= 	request.getParameter("usuarioDesc");
          			strCorreo		= 	request.getParameter("usuarioEmail");
          			strTelefono 	= 	request.getParameter("usuarioTelefono");
          		
          			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Destinatario externo
          			strUsuario	=	(strUsuario.length()<= 100) ? strUsuario : strUsuario.substring(0,100);
          			strDesc		=	(strDesc.length()<= 200) ? strDesc : strDesc.substring(0,200);
          			strCorreo	=	(strCorreo.length()<= 50) ? strCorreo : strCorreo.substring(0,50);
          			strTelefono	=	(strTelefono.length()<= 50) ? strTelefono : strTelefono.substring(0,50);
          
          			valida = ActualizaDestino.getDestinatarioExiste(strUsuario, strAux, strIdArea, strAux2);	
          
          			if (valida == 2){
          				boolean insertar = ActualizaDestino.InsertarDestino(strUsuario, strIdArea,strDesc, strCorreo, strTelefono);
          				insertado = insertar;
          					
          out.write(__oracle_jsp_text[14]);
          
          			}
          		}
          	}//** Fin Guardar un nuevo usuario	
          	recCreador  = ActualizaUsuario.getUsuario(strCreador1);
          	strCreador	= recCreador[0][0];
          
          	//** Se redirecciona a la pagina de UsuarioView cuando se ejecutan
          	//** los eventos de cambiar o guardar un Usuario
          
          	
          
          
          out.write(__oracle_jsp_text[15]);
          out.print(strIdUsuario);
          out.write(__oracle_jsp_text[16]);
          out.print(strIdRol);
          out.write(__oracle_jsp_text[17]);
          out.print(strAux);
          out.write(__oracle_jsp_text[18]);
          out.print(strAux2);
          out.write(__oracle_jsp_text[19]);
          out.print( strCreador);
          out.write(__oracle_jsp_text[20]);
          out.print( strFechaCreacion);
          out.write(__oracle_jsp_text[21]);
          if(strActivarLDAP.equals("1")){
          out.write(__oracle_jsp_text[22]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name multiple classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_1.setParent(null);
            __jsp_taghandler_1.setData(ActualizaLdap.getComboUsuariosLdapA());
            __jsp_taghandler_1.setName("comboUsuarios1");
            __jsp_taghandler_1.setMultiple(false);
            __jsp_taghandler_1.setClassHtml("blue500");
            __jsp_taghandler_1.setScript(" onblur='borrar_buffer()' onclick='borrar_buffer()'");
            __jsp_taghandler_1.setTextoNoSeleccion(" ---------------- Selecciona un Puesto ---------------- ");
            __jsp_taghandler_1.setValorNoSeleccion("-1");
            __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
            if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
          }
          out.write(__oracle_jsp_text[23]);
          }
          out.write(__oracle_jsp_text[24]);
           if(BUsuario.getSupervisor()|| BUsuario.getRecepcion() || BUsuario.getTurnado()){ 
          out.write(__oracle_jsp_text[25]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_2.setParent(null);
            __jsp_taghandler_2.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
            __jsp_taghandler_2.setName("usuarioArea");
            __jsp_taghandler_2.setSize(1);
            __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strIdArea));
            __jsp_taghandler_2.setClassHtml("blue500");
            __jsp_taghandler_2.setScript("onblur='borrar_buffer()' onclick='borrar_buffer()' ");
            __jsp_taghandler_2.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
            __jsp_taghandler_2.setValorNoSeleccion("-1");
            __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
            if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
          }
          out.write(__oracle_jsp_text[26]);
           }else{ 
          out.write(__oracle_jsp_text[27]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_3.setParent(null);
            __jsp_taghandler_3.setData(ComboData.getAreasCombo());
            __jsp_taghandler_3.setName("usuarioArea");
            __jsp_taghandler_3.setSize(1);
            __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( strIdArea));
            __jsp_taghandler_3.setClassHtml("blue500");
            __jsp_taghandler_3.setScript(" onblur='borrar_buffer()' onclick='borrar_buffer()' ");
            __jsp_taghandler_3.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
            __jsp_taghandler_3.setValorNoSeleccion("-1");
            __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
            if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
          }
          out.write(__oracle_jsp_text[28]);
           } 
          out.write(__oracle_jsp_text[29]);
          if (valida == 1) {
          out.write(__oracle_jsp_text[30]);
          } 
          out.write(__oracle_jsp_text[31]);
          out.print(strUsuario);
          out.write(__oracle_jsp_text[32]);
          out.print(strDesc);
          out.write(__oracle_jsp_text[33]);
          out.print(  (strUsuario!=null)?strCorreo:"" );
          out.write(__oracle_jsp_text[34]);
          out.print(strTelefono);
          out.write(__oracle_jsp_text[35]);
        }
      }
      out.write(__oracle_jsp_text[36]);

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
  private static final char __oracle_jsp_text[][]=new char[37][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<TITLE>Destinatarios Externos</TITLE>\n<HEAD>\n".toCharArray();
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
    " \n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<!-- Se hace una instancia al Bean del usuario para la Sesión -->\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n<!-- Fin bloque Sesión -->\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t<SCRIPT language=JavaScript type=text/javascript>\n\t\t{\n\t\t\topener.document.getElementById('Externo').contentWindow.location.reload();\n\t\t\twindow.close();\n\t\t}\n\t\t</SCRIPT>\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<STYLE type=\"text/css\">\n</STYLE>\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript>\n\n\tfunction usuarios1() {\n\t\tdoc = document.DestExtFormDinamic;\n\t\tdoc.submit();\n\t}\n\t function cerrar()\n\t {\n\t window.close();\n\t }\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n} \n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onunload=\"opener.hay_hija=false\"\n\tonClick=\"opener.resetTimer();\"\n\tonKeyPress=\"opener.resetTimer();\">\n<FORM action=\"DinamicExterno.jsp\" name=\"DestExtFormDinamic\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" name=\"id_usuario\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\">\n<INPUT type=\"hidden\" name=\"usuarioRol1\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\">\n<INPUT type=\"hidden\" name=\"aux\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\">\n<INPUT type=\"hidden\" name=\"aux2\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\">\n\n\n\n<DIV align=\"center\">\n\n<BR>\n</DIV><DIV class=documentBody id=Body>\n<!-- tag para los campos de username y password -->\n<!-- fin tag para los campos de username y password -->\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Destinatarios Externos</FONT></B></TD>\n\t\t\t<TD width=\"38\">&nbsp;</TD>\n\t\t\t<TD width=\"377\" align=\"right\">&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD width=\"336\"></TD>\n\t\t\t<TD width=\"38\"></TD>\n\t\t\t<TD width=\"377\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD width=\"336\" height=\"0\"></TD>\n\t\t\t<TD width=\"38\" height=\"0\"></TD>\n\t\t\t<TD width=\"377\" height=\"0\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\" height=\"30\"></TD>\n\t\t\t<TD width=\"38\" height=\"30\"></TD>\n\t\t\t<TD align=\"right\" width=\"377\" height=\"30\"><FONT face=\"Verdana\" size=\"2\">Creado por: <I>".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t- ".toCharArray();
    __oracle_jsp_text[21] = 
    "</I></FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\" height=\"30\"><BR>\n\t\t\t<BR>\n\t\t\t</TD>\n\t\t\t<TD width=\"38\" height=\"30\"></TD>\n\t\t\t<TD align=\"right\" width=\"377\" height=\"30\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t<TR VALIGN=top>\n\t\t<TD width=\"164\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Buscar Datos:</B></FONT></TD>\n\t\t<TD valign=\"bottom\" width=\"517\"><FONT SIZE=2 FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[23] = 
    " </FONT></TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t<TR VALIGN=top>\n\t\t<TD width=\"164\"><B><FONT size=\"2\" face=\"Verdana\" color=\"#004080\">Unidad Administrativa:</FONT></B></TD>\n\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t<TD valign=\"bottom\" width=\"517\"><FONT SIZE=2 FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t</FONT></TD>\n\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t<TD width=\"65\"><FONT SIZE=2 FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[28] = 
    " </FONT></TD>\n\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"164\"></TD>\n\t\t<TD valign=\"bottom\" width=\"517\"></TD>\n\t\t<TD width=\"65\"></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"164\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t<TD valign=\"bottom\" width=\"517\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"164\"><B><FONT size=\"2\" face=\"Verdana\" color=\"#004080\">Nombre:</FONT></B>\n\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "<br>\n\t\t<FONT color=\"red\"><B>*Este Nombre ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t</TD>\n\t\t<TD valign=\"bottom\" width=\"517\"><FONT SIZE=2 FACE=\"Verdana\"> <INPUT size=\"50\" maxlength=\"199\"\n\t\t\ttype=\"text\" name=\"usuarioNombre\" class=\"blue500\" value=\"".toCharArray();
    __oracle_jsp_text[32] = 
    "\"></FONT></TD>\n\t</TR>\n\t\t<TR valign=\"top\">\n\t\t<TD width=\"164\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t<TD valign=\"bottom\" width=\"517\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"164\"><B><FONT size=\"2\" face=\"Verdana\" color=\"#004080\">Descripcion:</FONT></B></TD>\n\t\t<TD valign=\"bottom\" width=\"517\"><FONT SIZE=2 FACE=\"Verdana\"> <INPUT size=\"50\" maxlength=\"199\"\n\t\t\ttype=\"text\" name=\"usuarioDesc\" class=\"blue500\" value=\"".toCharArray();
    __oracle_jsp_text[33] = 
    "\"></FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"164\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t<TD valign=\"bottom\" width=\"517\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"164\"><B><FONT size=\"2\" face=\"Verdana\" color=\"#004080\">Correo Electronico:</FONT></B></TD>\n\t\t<TD valign=\"bottom\" width=\"517\"><FONT SIZE=2 FACE=\"Verdana\"> <INPUT size=\"50\"\n\t\t\ttype=\"text\" maxlength=\"199\" name=\"usuarioEmail\" class=\"blue500\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[34] = 
    "\"></FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"164\"><FONT color=\"#004080\">&nbsp;</FONT></TD>\n\t\t<TD valign=\"bottom\" width=\"517\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"164\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\">Teléfono:</FONT></TD>\n\t\t<TD valign=\"bottom\" width=\"517\"><FONT SIZE=2 FACE=\"Verdana\"> <INPUT size=\"50\"\n\t\t\ttype=\"text\" name=\"usuarioTelefono\" class=\"blue500\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[35] = 
    "\" maxlength=\"199\"></FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"164\"></TD>\n\t\t<TD valign=\"bottom\" width=\"517\"></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"164\"></TD>\n\t\t<TD width=\"517\"></TD>\n\t</TR>\n\t<TR align=\"center\">\n\t\t<TD width=\"164\" align=\"center\" colspan=\"2\"></TD>\n\t\t<TD width=\"517\"></TD>\n\t</TR>\n\t<TR align=\"center\">\n\t\t<TD  align=\"left\">\n\t\t\t&nbsp;</TD>\n\t\t<TD >\n\t\t\t<a onclick=\"window.close()\">\n\t\t\t<img src=\"../Imagenes/Regresar.gif\"  border=\"0\">\n\t\t\t</a>&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<a onclick=\"guardarDestinoExt()\">\n\t\t\t<img src=\"../Imagenes/Guardar.gif\"  border=\"0\">\n\t\t\t</a>\n\t\t</TD>\n\t</TR>\n</TABLE><BR>\n</DIV>\n</DIV>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    __oracle_jsp_text[36] = 
    "\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
