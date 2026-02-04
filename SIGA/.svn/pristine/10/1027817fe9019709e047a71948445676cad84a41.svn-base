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


public class _Expediente extends com.orionserver.http.OrionHttpJspPage {


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
    _Expediente page = this;
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
      
      	String strIdExpediente	=	"";
      	String strExpediente	=	"";
      	String strIdArea		=	"";
      	String strCreador		=	"";
      	String strCreador1		=	"";		
      	String strFechaCreacion	=	"";
      	String strAccion		=	"";
      	String strEstatus		=	"1";
      
      	boolean bInsertar		=	false;
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFechaCreacion 				=	sdf.format(f);
      	
      	strCreador1		=	BUsuario.getIdUsuario();
      	strCreador		=	BUsuario.getNombre();
      	strAccion		=	request.getParameter("accion");
      	strIdExpediente	=	(request.getParameter("id_exp") != null)?request.getParameter("id_exp"):"";
      	
      	if(strAccion!=null && strAccion.trim().length()>0)
      	{
      		if(strAccion != null && strAccion.equals("guardar"))
      		{
      			strExpediente	=	request.getParameter("expediente");
      			strIdArea		=	request.getParameter("expArea");
      
      			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Entidad
      			strExpediente	=	(strExpediente.length()<= 200) ? strExpediente : strExpediente.substring(0,200);
      			
      			bInsertar		=	ActualizaExpediente.InsertarExpediente(	strIdArea, strExpediente,
      																		strCreador1, strFechaCreacion);
      		}
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      			strExpediente	=	request.getParameter("expediente");
      			strIdArea		=	request.getParameter("expArea");
      			
      			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Expedientes
      			strExpediente	=	(strExpediente.length()<= 200) ? strExpediente : strExpediente.substring(0,200);
      			
      			bInsertar = ActualizaExpediente.ActualizarExpediente(	strIdArea, strExpediente,
      																	strCreador1, strFechaCreacion,
      																	strIdExpediente);
      		}
      	}
      
      	if(strIdExpediente != null && strIdExpediente.trim().length()>0)
      	{
      		String strDatosExpediente[][] = ActualizaExpediente.getDatosExpediente(strIdExpediente);
      		strIdArea		=	strDatosExpediente[0][0];
      		strExpediente	=	strDatosExpediente[0][1];
      	//	//System.out.println("IdUbicaciones="+strIdExpediente);
      //		//System.out.println("strIdArea="+strIdArea);
      //		//System.out.println("strUbicacion="+strExpediente);
      	}
      
      out.write(__oracle_jsp_text[9]);
      
      	if(strAccion!=null && (strAccion.equals("cambiar") || strAccion.equals("guardar")))
      	{
      
      out.write(__oracle_jsp_text[10]);
      
      	}
      
      out.write(__oracle_jsp_text[11]);
      out.print( strIdExpediente );
      out.write(__oracle_jsp_text[12]);
      out.print( strCreador );
      out.write(__oracle_jsp_text[13]);
      out.print( strFechaCreacion );
      out.write(__oracle_jsp_text[14]);
       if(BUsuario.getSupervisor()){ 
      out.write(__oracle_jsp_text[15]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_1.setName("expArea");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_1.setClassHtml("blue500");
        __jsp_taghandler_1.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_1.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[16]);
       }else{ 
      out.write(__oracle_jsp_text[17]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getAreasCombo());
        __jsp_taghandler_2.setName("expArea");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_2.setClassHtml("blue500");
        __jsp_taghandler_2.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_2.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
        __jsp_taghandler_2.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[18]);
       } 
      out.write(__oracle_jsp_text[19]);
      out.print( strExpediente );
      out.write(__oracle_jsp_text[20]);

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
  private static final char __oracle_jsp_text[][]=new char[21][];
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
    "\n<SCRIPT language=JavaScript type=text/javascript>\n\tlocation.assign('ExpedienteView.jsp');\n</SCRIPT>\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<TITLE>Expedientes</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n<!-- \n\nfunction guardar() { \n\n\tdoc = document.Expedientes;\n\t\n\tvalida = 0;\n\tmsg=\"\";\n\n\tif (doc.expArea[doc.expArea.selectedIndex].value == -1) {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes seleccionar una Unidad\t\"+ \"\\n\";\n\t}\n\tif (doc.expediente.value ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debes capturar el nombre del Expediente\t\"+ \"\\n\";\n\t}\n\tif (valida == 1) \n\t{\n\t\talert(msg);\n\t\treturn false;\n\t} \n\telse if(document.Expedientes.id_exp.value != \"\") \n\t\tdocument.Expedientes.accion.value=\"cambiar\";\n\telse\n\tif(document.Expedientes.id_exp.value == \"\")\n\t\tdocument.Expedientes.accion.value=\"guardar\";\n\tdocument.Expedientes.submit();\n}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"Expediente.jsp\" name=\"Expedientes\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"id_exp\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"125\">\n\t\t\t<a onclick=\"history.go(-1);return false;\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/Regresar.gif\" width=\"82\" height=\"26\">\n\t\t\t</a>\n\t\t</TD>\n\t\t<TD width=\"125\">\n\t\t\t<a onclick=\"guardar()\">\n\t\t\t<img src=\"../Imagenes/Guardar.gif\" width=\"81\" border=\"0\">\n\t\t\t</a>\n\t\t</TD>\n\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t<TD width=\"48\"></TD>\n    </TR>\n<TR valign=\"top\">\n<TD></TD>\n<TD width=\"125\">&nbsp;</TD>\n<TD width=\"125\">&nbsp;</TD>\n        </TR>\n    </TBODY>\n</TABLE>\n</DIV>\n\n\n<DIV class=\"documentBody\" id=\"Body\" style=\"HEIGHT: 441px\">\n<DIV align=\"center\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n        <TR valign=\"top\">\n            <TD width=\"336\" colspan=\"2\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Expedientes</FONT></B></TD>\n            <TD width=\"144\">&nbsp;</TD>\n            <TD width=\"192\">&nbsp;</TD>\n        </TR>\n        <TR valign=\"top\">\n\t\t\t<td width=\"672\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</TR>\n    </TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT>\n\t\t</TD>\n\t\t<TD width=\"528\" align=\"right\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">Creado por: <I>".toCharArray();
    __oracle_jsp_text[13] = 
    " - ".toCharArray();
    __oracle_jsp_text[14] = 
    "</I></FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"528\">&nbsp;</TD>\n    </TR>\n<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Unidad Administrativa:</FONT></TD>\n\t\t<TD width=\"528\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"528\">&nbsp;</TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Expedientes:</FONT></TD>\n\t\t<TD width=\"528\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t<INPUT class=\"blue500\" size=\"80\" name=\"expediente\" value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\">\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"528\">&nbsp;</TD>\n    </TR>\n</TBODY>\n</TABLE>\n<BR>\n<BR>\n</DIV>\n</DIV>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
