package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.*;
import java.util.*;
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import gob.hacienda.cgtic.siga.instruccion.Actualiza;
import gob.hacienda.cgtic.siga.actualiza.AtenderInstrucciones;


public class _Reasignar extends com.orionserver.http.OrionHttpJspPage {


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
    _Reasignar page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      {
        String __url=OracleJspRuntime.toStr("header.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
      out.write(__oracle_jsp_text[7]);
      
      	String strIdAsunto = "";
      	String strIdInstruc = "";
      	String strAvance = "";
      	String strUsrOrg = "";
      	String strUsuario = "";
      	strIdInstruc = (request.getParameter("id_ins") != null) ? request
      			.getParameter("id_ins") : "";
      	strIdAsunto = (request.getParameter("id_asunto") != null) ? request
      			.getParameter("id_asunto") : "";
      	strAvance = (request.getParameter("ava") != null) ? request
      			.getParameter("ava") : "";
      	strUsrOrg = (request.getParameter("usr_ori") != null) ? request
      			.getParameter("usr_ori") : "";
      	strUsuario = (request.getParameter("id_usuario") != null) ? request
      			.getParameter("id_usuario") : "";
      	UsuarioBean BUsuario = (UsuarioBean) session
      			.getAttribute("UsuarioBean");
      	String strTmp = request.getRequestURI();
      	strTmp = strTmp.substring(strTmp.indexOf('/', 2) + 5, strTmp
      			.length());
      	if (BUsuario == null) {
      		try {
      			response.sendRedirect("index.jsp?pagina=" + strTmp
      			+ "?id_ins=" + strIdInstruc + "&id_asunto="
      			+ strIdAsunto + "&ava=" + strAvance + "&usr_ori="
      			+ strUsrOrg);
      		} catch (java.io.IOException io) {
      			;
      		}
      	}
      
      out.write(__oracle_jsp_text[8]);
      
      	String strIdUsuario = "";
      	String strComentarios = "";
      	String strAccion = "";
      	String strFechaCreacion = "";
      	boolean bReasignar = false;
      	boolean bInsertar = false;
      	boolean bInsertarBit = false;
      	boolean bEsAtencion = false;
      
      	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
      			"dd/MM/yyyy");
      	java.util.Date f = new java.util.Date();
      	strFechaCreacion = sdf.format(f);
      
      	String strIdAreaUs = BUsuario.getIdArea();
      	String strIdUsrReasigna = BUsuario.getIdUsuario();
      
      	strAccion = request.getParameter("accion");
      	/*KHCH Navegacion Reasignacion*/
      	String retURI2 = request.getParameter("retURI2");
      	String retURI = (request.getParameter("retURI") == null) ? "portalPrincipal.jsp"
      			: request.getParameter("retURI");
      
      	boolean bValidaEstatus = false;
      	String strEstValidacion = (request.getParameter("estValidacion") == null) ? ""
      			: request.getParameter("estValidacion");
      	if (strIdInstruc != null && !strIdInstruc.equals("")) {
      		if (strEstValidacion.equals("")) {
      			strEstValidacion = ActualizaInstrucciones
      			.getEstatusPorInstruccion(strIdInstruc);
      		}
      		String strEstatusValida = ActualizaInstrucciones
      		.getEstatusPorInstruccion(strIdInstruc);
      		if (!strEstatusValida.equals(strEstValidacion)) {
      			bValidaEstatus = true;
      		}
      	}
      
      	if (!bValidaEstatus && strAccion != null
      			&& strAccion.equals("guardar")) {
      		strIdInstruc = request.getParameter("id_ins");
      		strIdAsunto = request.getParameter("id_asunto");
      		strAvance = request.getParameter("ava");
      		strIdUsuario = request.getParameter("reasignarUsr");
      		strComentarios = request.getParameter("reasignarComen");
      
      		if (BUsuario.getAsistente()) {
      			try {
      		bInsertar = ActualizaHistorial
      				.InsertarReasignacion(
      				strIdInstruc,
      				strIdAsunto,
      				strComentarios,
      				gob.hacienda.cgtic.siga.Usuario
      				.aTitular(BUsuario
      						.getIdUsuario()),
      				strFechaCreacion,
      				BUsuario.getCargo()
      				+ " / "
      				+ BUsuario.getNombre()
      				+ " en Nombre de "
      				+ gob.hacienda.cgtic.siga.instruccion.Rechazo
      						.aNombre(BUsuario,
      						strIdInstruc));
      			} catch (Exception e) { //System.err.println("ReasignarRechazo-->"+e.getMessage());
      			}
      		} else
      			bInsertar = ActualizaHistorial.InsertarReasignacion(
      			strIdInstruc, strIdAsunto, strComentarios,
      			strIdUsrReasigna, strFechaCreacion, BUsuario
      			.getCargo()
      			+ " / " + BUsuario.getNombre());
      
      		bReasignar = ActualizaInstrucciones.ActualizaReasignar(
      		strIdInstruc, strIdUsuario, strAvance);
      
      		String strFolioBit = ActualizaInstrucciones
      		.getUltimoFolioTurnado(strIdInstruc);
      		bInsertarBit = ActualizaBitacora.InsertarEventoReasignar(
      		BUsuario.getIdUsuario(), strFolioBit);
      
      		String strUsr[][] = ActualizaUsuario
      		.NombreMailUsuario(strIdUsuario);
      		String UsrNombreResponde = BUsuario.getCargo()+"/"+BUsuario.getNombre();
      		String UsrNombreDirigido = strUsr[0][2];
      		String UsrMailDirigido = strUsr[0][1];
      		if (BUsuario.getReasignar()) {
      			if (ActualizaUsuario.getNotificacionMail(strIdUsuario)) {
      		        SenderMail mail = new SenderMail();
      		        mail.sendNotificarInstruccionReasignada(
      				UsrMailDirigido, UsrNombreDirigido,
      				UsrNombreResponde, Integer
      				.parseInt(strIdInstruc),
      				strComentarios, session.getServletContext());
      			}
      
      		}
      
      		try {
      			/*KHCH Navegacion Reasignacion*/
      			//response.sendRedirect(retURI);
      			response.sendRedirect((retURI2 == null
      			|| retURI2.equals("") || retURI2
      			.equalsIgnoreCase("null")) ? retURI : retURI2);
      		} catch (java.io.IOException io) {
      			//System.out.println("E/RROR:"+io.getMessage());
      		}
      	}
      	//	String strTurnador = ActualizaInstrucciones.getTurnador(strIdInstruc);
      	String strTurnador = Actualiza.getTurnador(strIdInstruc, BUsuario
      			.getIdUsuario());
      	bEsAtencion = ActualizaUsuario.getEsAtencion(strTurnador);
      	String strUsuarios[][] = null;
      	Vector vNombres1 = new Vector();
      	Vector vIds = new Vector();
      	//	if((strUsrOrg.equals(BUsuario.getIdUsuario())&&BUsuario.getTurnado()) || (Actualiza.esTurnador(strUsrOrg)&&BUsuario.getTurnado())){
      	if ((strTurnador.equals(BUsuario.getIdUsuario()) || Actualiza
      			.esTurnador(strTurnador))
      			&& BUsuario.getTurnado()) {
      		strUsuarios = Actualiza.getIdPersonalArea(BUsuario.getIdArea());
      		AsignarArbol tree = new AsignarArbol(strUsuarios);
      		vNombres1 = tree.getNombres();
      		vIds = tree.getIds();
      	} else if (strUsrOrg.equals(BUsuario.getIdUsuario())) {
      		strUsuarios = ActualizaUsuario.getSubordinados(strUsrOrg);
      		AsignarArbol tree = new AsignarArbol(strUsuarios);
      		vNombres1 = tree.getNombres();
      		vIds = tree.getIds();
      	} else {
      		if (bEsAtencion && !BUsuario.getAsistente()) {
      			//	strUsuarios = ActualizaUsuario.getSubordinados(BUsuario.getIdUsuario());
      			strUsuarios = ActualizaUsuario.getSubordinados(strTurnador);
      			AsignarArbol tree = new AsignarArbol(strUsuarios);
      			vNombres1 = tree.getNombres();
      			vIds = tree.getIds();
      		} else if (BUsuario.getAsistente()) {
      			strUsuarios = ActualizaUsuario.getSubordinados(strTurnador);
      			AsignarArbol tree = new AsignarArbol(strUsuarios);
      			vNombres1 = tree.getNombres();
      			vIds = tree.getIds();
      		} else {
      			strUsuarios = ActualizaUsuario.getSubordinados(BUsuario
      			.getIdUsuario());
      			AsignarArbol tree = new AsignarArbol(strUsuarios);
      			vNombres1 = tree.getNombres();
      			vIds = tree.getIds();
      		}
      	}
      
      out.write(__oracle_jsp_text[9]);
      out.print(retURI);
      out.write(__oracle_jsp_text[10]);
      out.print(strIdInstruc);
      out.write(__oracle_jsp_text[11]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[12]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[13]);
      out.print(strUsrOrg);
      out.write(__oracle_jsp_text[14]);
      out.print(strUsuario);
      out.write(__oracle_jsp_text[15]);
      out.print(retURI);
      out.write(__oracle_jsp_text[16]);
      out.write(__oracle_jsp_text[17]);
      out.print(retURI2);
      out.write(__oracle_jsp_text[18]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[19]);
      
      				for (int i = 0; i < vNombres1.size(); i++) {
      				
      out.write(__oracle_jsp_text[20]);
      out.print(vIds.get(i));
      out.write(__oracle_jsp_text[21]);
      out.print((strUsuario.equals(vIds.get(i))?"selected":""));
      out.write(__oracle_jsp_text[22]);
      out.print(ActualizaUsuario.NombreUsuario((String) vIds.get(i)));
      out.write(__oracle_jsp_text[23]);
      out.print(vNombres1.get(i));
      out.write(__oracle_jsp_text[24]);
      
      				}
      				
      out.write(__oracle_jsp_text[25]);
      
      		if (!bEsAtencion) {
      		
      out.write(__oracle_jsp_text[26]);
      
      			if (strUsuario != null && strUsuario.length() != 0) {
      			
      out.write(__oracle_jsp_text[27]);
      out.print(ActualizaUsuario.NombreUsuario(strUsuario));
      out.write(__oracle_jsp_text[28]);
      
      			} else {
      			
      out.write(__oracle_jsp_text[29]);
      
       }
       
      out.write(__oracle_jsp_text[30]);
      
      		}
      		
      out.write(__oracle_jsp_text[31]);
      out.print( bValidaEstatus );
      out.write(__oracle_jsp_text[32]);

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
  private static final char __oracle_jsp_text[][]=new char[33][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n\n".toCharArray();
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
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Reasignar</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n\t\n\tfunction regresar(){\n\t\t//history.go(-1);\n                var url='".toCharArray();
    __oracle_jsp_text[10] = 
    "';\n\t\tlocation.assign(url);\n\t}\n\t\n\tfunction Reasignar(){\t\n        document.getElementById(\"btnReasignar\").disabled = true;\n        doc = document.reasignar1;\n\t\t//valida = 0;\n\t\tmsg=\"\";\n\n\t\tif (doc.reasignarUsr[doc.reasignarUsr.selectedIndex].value == -1){\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" Debes seleccionar un Usuario\t\"+ \"\\n\";\n\t\t}\n\t\t\n\t\tif (doc.reasignarComen.value == \"\") {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" Debe capturar un comentario de Reasignación\t\"+ \"\\n\";\n\t\t}\n\t\n\t\tif (valida == 1){\n\t\t\tvalida=0;\n\t\t\talert(msg);\n                        document.getElementById(\"btnReasignar\").disabled = false;\n\t\t\treturn false;\n\t\t}else if(valida==2){\n\t\t\talert(\"Su solicitud ya fue enviada\");\n                        document.getElementById(\"btnReasignar\").disabled = false;\n\t\t\treturn false;\n\t\t}else{\n\t\t\tdoc.accion.value=\"guardar\";\n\t\t\tif (confirm(\"está usted seguro que desea Reasignar la instrucción?\")){\n\t\t\t\tvalida=2;\n\t\t\t\tdoc.submit();\n\t\t\t}else{\n\t\t\t\talert(\"Su petición de Reasignación ya fue cancelada\");\n                                document.getElementById(\"btnReasignar\").disabled = false;\n\t\t\t}\n\t\t}\n\t}\n</SCRIPT>\n<SCRIPT src=\"../js/SigmaJsCat.js\" type=text/javascript></SCRIPT>\n<STYLE type=text/css>\nBODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load();valida = 0;\" onKeyPress=\"timer_reload()\"\n\tonClick=\"timer_reload()\"\n\tonMouseMove=\"limitaTextArea(document.reasignar1.reasignarComen,'Comentarios','4000')\">\n<FORM action=\"Reasignar.jsp\" name=\"reasignar1\" method=\"post\"><INPUT\n\ttype=\"hidden\" value=\"\" name=\"accion\"> <INPUT type=\"hidden\"\n\tvalue=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\" name=\"id_ins\"> <INPUT type=\"hidden\"\n\tvalue=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"id_asunto\"> <INPUT type=\"hidden\"\n\tvalue=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"ava\"> <INPUT type=\"hidden\"\n\tvalue=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"usr_ori\"> <INPUT type=\"hidden\"\n\tvalue=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"id_usuario\"> <INPUT type=\"hidden\"\n\tvalue=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"retURI\"> ".toCharArray();
    __oracle_jsp_text[17] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"retURI2\"> <INPUT\n\ttype=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"estValidacion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\" colspan=\"2\"><INPUT class=\"blue100\"\n\t\t\t\tonclick=\"regresar();\" type=\"button\" value=\"Cancelar\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<INPUT id=\"btnReasignar\" name=\"btnReasignar\" class=\"blue100\"\n\t\t\t\tonclick=\"Reasignar();\" type=\"button\" value=\"Aceptar\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"672\" bgcolor=\"#00204f\" colspan=\"4\"><FONT size=\"0\">&nbsp;</FONT></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Puesto:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\"><SELECT name=\"reasignarUsr\"\n\t\t\t\tonkeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\"\n\t\t\t\tonclick=\"borrar_buffer()\" class=\"blue500a\" onchange='puestoReg()'>\n\t\t\t\t<OPTION value=\"-1\">-- Compañeros de la Unidad a Reasignar\n\t\t\t\t--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    ">".toCharArray();
    __oracle_jsp_text[23] = 
    "/".toCharArray();
    __oracle_jsp_text[24] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t</SELECT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Responsable:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    " <FONT face=\"Arial\" color=\"#004080\" size=\"2\">".toCharArray();
    __oracle_jsp_text[28] = 
    "</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    " <FONT face=\"Arial\" color=\"#004080\" size=\"2\">----</FONT> ".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Comentarios:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\"><TEXTAREA cols=\"50\" rows=\"5\"\n\t\t\t\tclass=\"blue500a\" name=\"reasignarComen\"\n\t\t\t\tonKeyDown=\"limitaTextArea(document.reasignar1.reasignarComen,'Comentarios','4000')\"></TEXTAREA>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<script type=\"text/javascript\">\n<!--\nif (".toCharArray();
    __oracle_jsp_text[32] = 
    "){\n\talert(\"Esta instrucción ha sido modificada por otro usuario y Cambió su Estatus,\\npor lo que la acción solicitada será cancelada\");\n\tlocation.assign(\"portalPrincipal.jsp\");\n}\n//-->\n</script></FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
