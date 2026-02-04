package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.taglib.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.beans.catalogos.*;
import com.meve.sigma.actualiza.*;
import java.util.*;


public class _tramites extends com.orionserver.http.OrionHttpJspPage {


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
    _tramites page = this;
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
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp);
      		}
      		catch(java.io.IOException io){;}
      	}
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[4]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[5]);
       } 
      out.write(__oracle_jsp_text[6]);
      
      	String strAccion = "";
      	String strIdTramite = (request.getParameter("tIdTramite")== null)?"":request.getParameter("tIdTramite");
      	String strIdArea = (request.getParameter("tArea")== null)?"":request.getParameter("tArea");
      	String strNombre = (request.getParameter("tNombre")== null)?"":request.getParameter("tNombre");
      	String strClave = (request.getParameter("tClave")== null)?"":request.getParameter("tClave");
      	String strDescripción = (request.getParameter("tDescripcion")== null)?"":request.getParameter("tDescripcion");
      	String strTiempo = (request.getParameter("tTiempo")==null)?"":request.getParameter("tTiempo");
      	String strFecha = "";
      	String strUsuario = "";
      	Vector mensajes = new Vector();
      	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f = new java.util.Date();
      	String strFechaCreacion = sdf.format(f);
      	
      	String retURI = (request.getParameter("retURI")== null)?"tramitesView.jsp":request.getParameter("retURI");
      	
      	String strTramites[][] = null;
      	strAccion	=	request.getParameter("accion");
              
      	if(strIdTramite != null && strIdTramite.length()>0){
      		strTramites = ActualizaTramite.getTramite(strIdTramite);
      		strIdArea = strTramites[0][1];
      		strNombre = strTramites[0][2];
      		strClave = strTramites[0][3];
      		strDescripción = strTramites[0][4];
      		strTiempo = strTramites[0][5];
      		strFecha = strTramites[0][6];
      		strUsuario = strTramites[0][7];
      	}
              
              
      	if(strAccion != null && strAccion.equals("guardar")){
      		Tramite tramite = new Tramite();
      //                request.setAttribute("msg",msg);
      		mensajes = tramite.procesoTramite(request, BUsuario);
      		try{
      			if(mensajes.get(5).equals("si"))
      				response.sendRedirect(retURI);
      		}catch(java.io.IOException io){;}
      	}else{
      		mensajes.add("");
      		mensajes.add("");
      		mensajes.add("");
      		mensajes.add("");
      		mensajes.add("");
      	}
      
      out.write(__oracle_jsp_text[7]);
       if(strIdTramite!=null && strIdTramite.length()!=0){ 
      out.write(__oracle_jsp_text[8]);
       if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ 
      out.write(__oracle_jsp_text[9]);
       }else{ 
      out.write(__oracle_jsp_text[10]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[11]);
       } 
      out.write(__oracle_jsp_text[12]);
       } 
      out.write(__oracle_jsp_text[13]);
      out.print(strIdTramite);
      out.write(__oracle_jsp_text[14]);
      out.print(strClave );
      out.write(__oracle_jsp_text[15]);
      out.print(strIdArea );
      out.write(__oracle_jsp_text[16]);
      out.print(retURI );
      out.write(__oracle_jsp_text[17]);
      out.print( retURI );
      out.write(__oracle_jsp_text[18]);
      if(strIdTramite!=null && strIdTramite.length()>0){
      out.write(__oracle_jsp_text[19]);
      out.print((strIdTramite!=null && !strIdTramite.equals(""))?"última Modificación por: ":"Creado por: ");
      out.write(__oracle_jsp_text[20]);
      out.print(ActualizaUsuario.NombreUsuario(strUsuario));
      out.write(__oracle_jsp_text[21]);
      out.print(strFecha);
      out.write(__oracle_jsp_text[22]);
      }else{
      out.write(__oracle_jsp_text[23]);
      out.print((strIdTramite!=null && !strIdTramite.equals(""))?"última Modificación por: ":"Creado por: ");
      out.write(__oracle_jsp_text[24]);
      out.print(ActualizaUsuario.NombreUsuario(BUsuario.getIdUsuario()));
      out.write(__oracle_jsp_text[25]);
      out.print(strFechaCreacion);
      out.write(__oracle_jsp_text[26]);
      }
      out.write(__oracle_jsp_text[27]);
       if(BUsuario.getSupervisor()){ 
      				if(strIdTramite.equals("")){
      					strIdArea = BUsuario.getIdArea();
      				} 
      			
      out.write(__oracle_jsp_text[28]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_1.setName("tArea");
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
      out.write(__oracle_jsp_text[29]);
      out.print(mensajes.get(0));
      out.write(__oracle_jsp_text[30]);
      }else{
      out.write(__oracle_jsp_text[31]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getAreasComboAll());
        __jsp_taghandler_2.setName("tArea");
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
      out.print(mensajes.get(0));
      out.write(__oracle_jsp_text[33]);
      }
      out.write(__oracle_jsp_text[34]);
      out.print(strNombre.trim());
      out.write(__oracle_jsp_text[35]);
      out.print(mensajes.get(1));
      out.write(__oracle_jsp_text[36]);
      out.print(strClave.trim());
      out.write(__oracle_jsp_text[37]);
      out.print(mensajes.get(2));
      out.print(mensajes.get(4));
      out.write(__oracle_jsp_text[38]);
      out.print(strDescripción);
      out.write(__oracle_jsp_text[39]);
      out.print(strTiempo);
      out.write(__oracle_jsp_text[40]);
      out.print(mensajes.get(3));
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
    "\n<HTML>\n<HEAD>\n".toCharArray();
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
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/link.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJsCat.js\"></script>\n<TITLE>Tramites</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\nfunction limpiarCampos(){\n\tdocument.tramites.reset();\n}\n\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"valida=0;timer_load();limpiarCampos();\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM name=\"tramites\" action=\"tramites.jsp\" method=\"post\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"tIdTramite\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"aux\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"aux2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"retURI\">\n\n<DIV align=\"center\">\n<BR>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\n\t<TR valign=\"top\">\n\t\t<TD colspan=\"4\">\n\t\t\t<A href=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"></A>\n\t\t\t<a onclick=\"guardarTramite()\">\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\">\n\t\t\t</a>\n\t\t</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD colspan=\"4\"></TD>\n    </TR>\n\n\t<TR valign=\"top\">\n\t\t<TD colspan=\"2\" class=\"etiquetas1v\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\"><FONT size=\"+1\"\n\t\t\t\tcolor=\"#004080\">Tramites</FONT></FONT></B></TD>\n\t\t<TD colspan=\"2\" align=\"right\">&nbsp;**Los datos marcados con negritas son obligatorios&nbsp;</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD align=\"right\" colspan=\"4\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t<I>".toCharArray();
    __oracle_jsp_text[21] = 
    " - ".toCharArray();
    __oracle_jsp_text[22] = 
    "</I></FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t<I>".toCharArray();
    __oracle_jsp_text[25] = 
    " - ".toCharArray();
    __oracle_jsp_text[26] = 
    "</I></FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD colspan=\"4\">&nbsp;</TD>\n    </TR>\n\n\t<TR valign=\"top\">\n\t\t<TD width=\"162\">&nbsp;</TD>\n\t\t<TD width=\"174\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"162\" class=\"etiquetas\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\t<B>Unidad Administrativa:</B></FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\" class=\"etiquetas\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t<BR><FONT color=\"red\" size=\"1\">".toCharArray();
    __oracle_jsp_text[30] = 
    "</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t<BR><FONT color=\"red\" size=\"1\">".toCharArray();
    __oracle_jsp_text[33] = 
    "</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"162\">&nbsp;</TD>\n\t\t<TD width=\"174\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"162\" class=\"etiquetas\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\t<B>Nombre:</B></FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\" class=\"etiquetas\">\n\t\t\t<INPUT type=\"text\" class=\"blue600a\" maxlength=\"199\" name=\"tNombre\" onkeydown=\"\" value=\"".toCharArray();
    __oracle_jsp_text[35] = 
    "\">\n\t\t\t<BR><FONT color=\"red\" size=\"1\">".toCharArray();
    __oracle_jsp_text[36] = 
    "</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"162\">&nbsp;</TD>\n\t\t<TD width=\"174\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"162\" class=\"etiquetas\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\t<B>Clave:</B></FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\" class=\"etiquetas\">\n\t\t\t<INPUT type=\"text\" class=\"blue200a\" maxlength=\"50\" name=\"tClave\" onkeydown=\"\" value=\"".toCharArray();
    __oracle_jsp_text[37] = 
    "\">\n\t\t\t<BR><FONT color=\"red\" size=\"1\">".toCharArray();
    __oracle_jsp_text[38] = 
    "</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"162\">&nbsp;</TD>\n\t\t<TD width=\"174\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"162\" class=\"etiquetas\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tDescripción:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\" class=\"etiquetas\">\n\t\t\t<INPUT type=\"text\" class=\"blue600a\" maxlength=\"199\" name=\"tDescripcion\" onkeydown=\"\" value=\"".toCharArray();
    __oracle_jsp_text[39] = 
    "\">\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"162\">&nbsp;</TD>\n\t\t<TD width=\"174\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"162\" class=\"etiquetas\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\t<B>Tiempo del Tramite:</B></FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\" class=\"etiquetas\">\n\t\t\t<INPUT type=\"text\" class=\"blue200a\" maxlength=\"3\" onKeyPress='AceptaSoloTeclaNumericaYPunto();' name=\"tTiempo\" value=\"".toCharArray();
    __oracle_jsp_text[40] = 
    "\">\n\t\t\t&nbsp;Día(s)\n\t\t\t<BR><FONT color=\"red\" size=\"1\">".toCharArray();
    __oracle_jsp_text[41] = 
    "</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"162\">&nbsp;</TD>\n\t\t<TD width=\"174\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n</TBODY>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
