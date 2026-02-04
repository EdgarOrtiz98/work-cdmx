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


public class _DinamicEntidad extends com.orionserver.http.OrionHttpJspPage {


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
    _DinamicEntidad page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      
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
      
      
      out.write(__oracle_jsp_text[4]);
       if(BUsuario.getTurnado() ||
      	BUsuario.getRecepcion()){ 
      out.write(__oracle_jsp_text[5]);
      }else{
      out.write(__oracle_jsp_text[6]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
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
      	String strAccion		=	"";
      	String strEstatus		=	"1";
      	String strEntidades[][]		=	null;
      	String strIdEntidad		=	"";
      
      	boolean bInsertar		=	false;
      	int valida = -2;
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFechaCreacion 				=	sdf.format(f);
      
      	strCreador1		=	BUsuario.getIdUsuario();
      	strCreador		=	BUsuario.getNombre();
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
      	}
      	
      	if(strAccion != null && strAccion.equals("guardar"))
      	{
      		strEntidad		=	request.getParameter("entidad");
      		strIdArea		=	request.getParameter("entidadArea");
      		strEntidadClasificacion		=	request.getParameter("entidadClasificacion");
      		strEntidadDireccion		=	request.getParameter("direccion");
      		strEntidadTel		=	request.getParameter("tel");
      
      		valida = ActualizaEntidad.getEntidadExiste(strEntidad, "1a2b3c", strIdArea, "1a2b3c");
      
      		if (valida == 2)
      		{
      			bInsertar	=	ActualizaEntidad.InsertarEntidad(	strIdEntidad, strEntidad, strIdArea, strEntidadClasificacion,
      																strEntidadDireccion, strEntidadTel, 
      																strCreador1, strFechaCreacion, strEstatus);
      			String strIdEnt = "0";
      			if(bInsertar)
      				strIdEnt = ActualizaEntidad.ultimoIdEntidad();
      			
      out.write(__oracle_jsp_text[9]);
      out.print(strIdEnt);
      out.write(__oracle_jsp_text[10]);
      out.print(strEntidad);
      out.write(__oracle_jsp_text[11]);
      
      		}
      	}
      
      out.write(__oracle_jsp_text[12]);
      if (strIdEntidad!=null){ 
      out.write(__oracle_jsp_text[13]);
      out.print(strIdEntidad );
      out.write(__oracle_jsp_text[14]);
      }
      out.write(__oracle_jsp_text[15]);
      out.print( strCreador );
      out.write(__oracle_jsp_text[16]);
      out.print( strFechaCreacion );
      out.write(__oracle_jsp_text[17]);
       if(BUsuario.getSupervisor() || BUsuario.getRecepcion() || BUsuario.getTurnado()){ 
      out.write(__oracle_jsp_text[18]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_1.setName("entidadArea");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_1.setClassHtml("blue500a");
        __jsp_taghandler_1.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_1.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[19]);
       }else{ 
      out.write(__oracle_jsp_text[20]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getAreasCombo());
        __jsp_taghandler_2.setName("entidadArea");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_2.setClassHtml("blue500a");
        __jsp_taghandler_2.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_2.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
        __jsp_taghandler_2.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[21]);
       } 
      out.write(__oracle_jsp_text[22]);
      if (valida == 1) {
      out.write(__oracle_jsp_text[23]);
      } 
      out.write(__oracle_jsp_text[24]);
      out.print( strEntidad  );
      out.write(__oracle_jsp_text[25]);
      out.print((strEntidadClasificacion.trim().equals("Privada")?"selected":""));
      out.write(__oracle_jsp_text[26]);
      out.print((strEntidadClasificacion.trim().equals("Pública")?"selected":""));
      out.write(__oracle_jsp_text[27]);
      out.print( strEntidadDireccion  );
      out.write(__oracle_jsp_text[28]);
      out.print( strEntidadTel  );
      out.write(__oracle_jsp_text[29]);

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
  private static final char __oracle_jsp_text[][]=new char[30][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<TITLE>Entidad</TITLE>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
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
    "\n\t\t\t<SCRIPT language=JavaScript type=text/javascript>\n\t\t\t\t{\n\t\t\t\t\t//opener.document.getElementById('Entidad').contentWindow.location.reload();\n\t\t\t\t\twindow.opener.document.Asunto.idEntidad.value = ".toCharArray();
    __oracle_jsp_text[10] = 
    ";\n\t\t\t\t\twindow.opener.document.Asunto.asuntoEntidad.value = '".toCharArray();
    __oracle_jsp_text[11] = 
    "';\n\t\t\t\t\twindow.opener.document.Asunto.control.value = 0;\n\t\t\t\t\twindow.opener.document.Asunto.asuntoRemitente.value = '';\n\t\t\t\t\twindow.opener.document.Asunto.asuntoCargo.value = '';\n\t\t\t\t\twindow.opener.document.Asunto.asuntoCorreo.value = '';\n\t\t\t\t\twindow.close();\n\t\t\t\t}\n\t\t\t</SCRIPT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\" src=\"../js/link.js\"></script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onunload=\"opener.hay_hija=false\"\n\tonClick=\"opener.resetTimer();\"\n\tonKeyPress=\"opener.resetTimer();\"\n\tonMouseMove=\"limitaTextArea(document.dEntidad.direccion,'Dirección','200')\";>\n<FORM action=\"DinamicEntidad.jsp\" name=\"dEntidad\" method=\"post\">\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"id_entidad\">\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<BR>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"150\">\n\t\t\t<a onclick=\"window.close();\">\n\t\t\t<img src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\" border=\"0\">\n\t\t\t</a>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<a onclick=\"guardarEntidadOtro()\">\n\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\"  border=\"0\">\n\t\t\t</a>\n\t\t&nbsp;</TD>\n\t\t<TD width=\"150\">\n\n\t\t&nbsp;</TD>\n\t\t<TD width=\"150\"></TD>\n\t\t<TD width=\"217\"></TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n<BR>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n<TR valign=\"top\">\n<TD width=\"336\" colspan=\"2\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Entidad</FONT></B></TD>\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n        </TR>\n<TR valign=\"top\">\n<td width=\"672\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n        </TR>\n\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT>\n\t\t</TD>\n\t\t<TD width=\"528\" align=\"right\" colspan=\"3\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">Creado por: <I>".toCharArray();
    __oracle_jsp_text[16] = 
    " - ".toCharArray();
    __oracle_jsp_text[17] = 
    "</I></FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\n<TR valign=\"top\">\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Unidad Administrativa:</B></FONT></TD>\n<TD width=\"528\" colspan=\"3\">\n\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t</FONT>\n</TD>\n</TR>\n<TR valign=\"top\">\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Entidad:</B></FONT>\n".toCharArray();
    __oracle_jsp_text[23] = 
    "<br>\n<FONT color=\"red\"><B>*Esta Entidad ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[24] = 
    "\n</TD>\n<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n<INPUT class=\"blue500\" name=\"entidad\" value=\"".toCharArray();
    __oracle_jsp_text[25] = 
    "\" maxlength=\"199\"></FONT></TD>\n</TR>\n<TR valign=\"top\">\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Clasificación:</FONT></TD>\n<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t<SELECT name=\"entidadClasificacion\" class=\"blue200a\">\n\t\t<OPTION value=\"Privada\" ".toCharArray();
    __oracle_jsp_text[26] = 
    ">Privada</OPTION>\n\t\t<OPTION value=\"Pública\" ".toCharArray();
    __oracle_jsp_text[27] = 
    ">Pública</OPTION>\n\t</SELECT>\n\t</FONT></TD>\n</TR>\n<TR valign=\"top\">\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n        </TR>\n\n\n<TR valign=\"top\">\n<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Dirección:</FONT></TD>\n<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t<TEXTAREA class=\"blue500\" name=\"direccion\" rows=\"3\"\n\t\tonKeyDown=\"limitaTextArea(document.dEntidad.direccion,'Dirección','200')\";>".toCharArray();
    __oracle_jsp_text[28] = 
    "</TEXTAREA> \n</FONT></TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Teléfono:</FONT></TD>\n<TD width=\"528\" colspan=\"3\"><FONT face=\"Arial\" size=\"2\"><INPUT class=\"blue500\" name=\"tel\" value=\"".toCharArray();
    __oracle_jsp_text[29] = 
    "\" maxlength=\"199\"></FONT></TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"672\" colspan=\"4\">&nbsp;</TD>\n        </TR>\n    </TBODY>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
