package _cgtic;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import gob.hacienda.cgtic.siga.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.util.AsignarArbol;
import java.util.Vector;
import gob.hacienda.cgtic.siga.util.*;


public class _delegarInstrucciones extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html");
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
    _delegarInstrucciones page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      
      	String rutaBase = application.getInitParameter("RutaBase");
      	rutaBase = request.getContextPath();
      
      	UsuarioBean BUsuario = (UsuarioBean) session
      			.getAttribute("UsuarioBean");
      	Instruccion instruccion = new Instruccion();
      	Puestos puesto = new Puestos();
      	String idArea = BUsuario.getIdArea();
      	String idUsr = BUsuario.getIdUsuario();
      	String idAsunto = "";
      	String idInstr = "";
      	String indexRow = "";
      
      	boolean bEsInformativa = false; //Instrucciones Informativas
      	try {
      		if (request.getParameter("idAsunto") == null) {
      			out
      			.println("<font color='#FF0000'>Error: No hay Id de Asunto.</font>");
      		} else {
      			idAsunto = request.getParameter("idAsunto");
      		}
      		if (request.getParameter("Instruccion") != null) {
      			idInstr = request.getParameter("Instruccion");
      		}
      		if (request.getParameter("indexRow") != null) {
      			indexRow = request.getParameter("indexRow");
      		}
      	} catch (java.io.IOException io) {
      		//System.out.println("io="+io);
      	}
      	java.util.ResourceBundle labels = java.util.ResourceBundle
      			.getBundle("Etiquetas", java.util.Locale.US);
      
      	if (instruccion.getEsInformativa(idInstr))//Instrucciones Informativas
      		bEsInformativa = true;
      
      out.write(__oracle_jsp_text[6]);
      out.print(labels.getString("delega.titulo"));
      out.write(__oracle_jsp_text[7]);
      out.print(request.getContextPath());
      out.write(__oracle_jsp_text[8]);
      out.print(labels.getString("instr.regresa"));
      out.write(__oracle_jsp_text[9]);
      out.print(request.getContextPath());
      out.write(__oracle_jsp_text[10]);
      out.print(labels.getString("instr.inserta"));
      out.write(__oracle_jsp_text[11]);
      out.print(request.getContextPath());
      out.write(__oracle_jsp_text[12]);
      out.print(labels.getString("instr.borra"));
      out.write(__oracle_jsp_text[13]);
      out.print(request.getContextPath());
      out.write(__oracle_jsp_text[14]);
      out.print(labels.getString("instr.guarda"));
      out.write(__oracle_jsp_text[15]);
      out.print(rutaBase);
      out.write(__oracle_jsp_text[16]);
      out.print(indexRow);
      out.write(__oracle_jsp_text[17]);
      out.print(idAsunto);
      out.write(__oracle_jsp_text[18]);
      out.print(idInstr);
      out.write(__oracle_jsp_text[19]);
      out.print(labels.getString("instr.nueva"));
      out.write(__oracle_jsp_text[20]);
      out.print(labels.getString("instr.actualiza"));
      out.write(__oracle_jsp_text[21]);
      out.print(labels.getString("A"));
      out.write(__oracle_jsp_text[22]);
      out.print(labels.getString("pto"));
      out.write(__oracle_jsp_text[23]);
      out.print(puesto.getComboPuestosSubordinados(Items
							.idInstruccionUsuario(idInstr)));
      out.write(__oracle_jsp_text[24]);
      out.print(rutaBase);
      out.write(__oracle_jsp_text[25]);
      out.print(labels.getString("instr"));
      out.write(__oracle_jsp_text[26]);
      out.print(instruccion.getComboInstrucciones(idArea));
      out.write(__oracle_jsp_text[27]);
      out.print(labels.getString("ta"));
      out.write(__oracle_jsp_text[28]);
      
      			if (!bEsInformativa) {
      			
      out.write(__oracle_jsp_text[29]);
      out.print(labels.getString("E"));
      out.write(__oracle_jsp_text[30]);
      
      			}
      			
      out.write(__oracle_jsp_text[31]);
      out.print(labels.getString("I"));
      out.write(__oracle_jsp_text[32]);
      out.print(labels.getString("tiemp"));
      out.write(__oracle_jsp_text[33]);
      out.print(instruccion.getTiempoEstimado(idAsunto, idInstr));
      out.write(__oracle_jsp_text[34]);
      
      		try {
      		if (idAsunto != null || idInstr != null) {
      			out
      			.println("<iframe id=\"tableInstr\" src=\""
      			+ rutaBase
      			+ "/cgtic/tablaInstrucciones.jsp?idAsunto="
      			+ idAsunto
      			+ "&idInstr="
      			+ idInstr
      			+ "&call=New&tipoTabla=0\" width='852' height='600' frameborder='0'>"
      			+ "</iframe>");
      		} else {
      			out
      			.println("<br><center>No hay instruciones relacionadas.</center>");
      		}
      	} catch (java.io.IOException io) {
      		//System.out.println("io="+io);
      	}
      
      out.write(__oracle_jsp_text[35]);
      out.print(idArea );
      out.write(__oracle_jsp_text[36]);
      out.print(instruccion.getTiempoEstimado(idAsunto, idInstr) );
      out.write(__oracle_jsp_text[37]);
      out.print(instruccion.getTipoAcceso(idAsunto, idInstr) );
      out.write(__oracle_jsp_text[38]);

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
  private static final char __oracle_jsp_text[][]=new char[39][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n\n<!--Menu del JSP -->\n<br>\n<center>\n<table width=\"850\">\n\t<tr>\n\t\t<td class=\"bodyTitle\">".toCharArray();
    __oracle_jsp_text[7] = 
    "</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t<table>\n\t\t\t<tr>\n\t\t\t\t<td class=\"btnMenu\"><img\n\t\t\t\t\tsrc=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "/cgtic/img/salir.gif\"\n\t\t\t\t\tonclick=\"javascript:salir();\"\n\t\t\t\t\talt=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\" id='btnSalir'></td>\n\t\t\t\t<td class=\"btnMenu\"><img\n\t\t\t\t\tsrc=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "/cgtic/img/mas.gif\"\n\t\t\t\t\tonclick=\"javascript:insertRow();\"\n\t\t\t\t\talt=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\" id='btnInst'></td>\n\t\t\t\t<td class=\"btnMenu\"><img\n\t\t\t\t\tsrc=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "/cgtic/img/menos.gif\"\n\t\t\t\t\tonclick=\"javascript:delRow();\"\n\t\t\t\t\talt=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" id='btnDel'></td>\n\t\t\t\t<td class=\"btnMenu\"><img\n\t\t\t\t\tsrc=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "/cgtic/img/guardar.gif\"\n\t\t\t\t\tonclick=\"javascript:SaveRows();\"\n\t\t\t\t\talt=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" id='btnGuarda'></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"bodyTitle\">\n\t\t<hr width=\"850\" size=\"2pt\" style=\"color: #004080;\">\n\t\t</hr>\n\t\t</td>\n\t</tr>\n</table>\n<form action=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "/cgtic\" id=\"actionForm\"><input\n\ttype=\"hidden\" id=\"indexRow\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"indexRow\">\n<input type=\"hidden\" id=\"idAsunto\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"idAsunto\">\n<input type=\"hidden\" id=\"idInstr\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"idInstr\">\n<input type=\"hidden\" id=\"instStat\" value=\"0\" name=\"instStat\"> <input\n\ttype=\"hidden\" id=\"auto\" value=\"\" name=\"auto\"> <input\n\ttype=\"text\" id=\"dataLine\" value=\"\" name=\"dataLine\" size=\"1\"\n\tonfocus=\"javascript:dataLineChanged();\"\n\tstyle=\"position: absolute; left: -100\">\n<table class=\"tableForm\" width=\"850\">\n\t<tr>\n\t\t<td colspan=\"4\" align=\"right\"><input type=\"button\" tabindex=\"7\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\"\n\t\t\tonclick=\"javascript:clearFields();\"> <input type=\"button\"\n\t\t\ttabindex=\"7\" value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\"\n\t\t\tonclick=\"javascript:updateInstr();\" id='btnActInst'></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"rowElementTitle\">".toCharArray();
    __oracle_jsp_text[22] = 
    "</td>\n\t\t<td> <INPUT TYPE=CHECKBOX NAME=\"B\" ID=\"B\" VALUE=\"1\" TABINDEX=\"1\" CHECKED><td>\t\t\n\t\t\t\t\t\t\t\t\n\t\t<td class=\"rowElementTitle\">&nbsp;</td>\n\t\t<td class=\"rowElementBody\"><input type=\"checkbox\" name=\"R\" id=\"R\"\t\t\t\n\t\t\tchecked=\"0\" value=\"1\" tabindex=\"1\" style=\"visibility: hidden;\"></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"rowElementTitle\"><br>".toCharArray();
    __oracle_jsp_text[23] = 
    "</td>\n\t\t<td class=\"rowElementBody\" colspan=\"3\"><select name=\"pto\"\n\t\t\tid=\"pto\" onchange=\"javascript:changePuesto(this.value);\" tabindex=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t</select></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"rowElementTitle\">&nbsp;</td>\n\t\t<td colspan=\"3\" height=\"0\">\n\t\t<div id=\"iFrmPtoDiv\"\n\t\t\tstyle=\"posotion: absolute; visibility: hidden; height: 0;\"><iframe\n\t\t\tsrc=\"".toCharArray();
    __oracle_jsp_text[25] = 
    "/cgtic/detallePuesto.jsp\" height=\"0\" id=\"iFrmPto\"\n\t\t\tscrolling=\"no\" frameborder=\"0\"></iframe></div>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"rowElementTitle\">".toCharArray();
    __oracle_jsp_text[26] = 
    "</td>\n\t\t<td class=\"rowElementBody\" colspan=\"3\"><select name=\"instr\"\n\t\t\tid=\"instr\" onchange=\"javascript:selInstr();\" tabindex=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t</select><input type=\"button\" value=\"Modificar >>\"\n\t\t\tonclick=\"javascript:modificaInstruccion();\" id='btnModIns'\n\t\t\tstyle=\"font-size: 8pt\"></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"rowElementTitle\">&nbsp;</td>\n\t\t<td class=\"rowElementBody\" colspan=\"3\"><input name=\"otraInstr\"\n\t\t\tvalue=\"\" id=\"otraInstr\" size=\"100\" maxlength=\"100\" tabindex=\"4\"\n\t\t\tonkeypress=\"return soloAlfanumerico(event)\"></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"rowElementTitle\">".toCharArray();
    __oracle_jsp_text[28] = 
    "</td>\n\t\t<td class=\"rowElementBody\"><select name=\"ta\" id=\"ta\" tabindex=\"5\"\n\t\t\tonchange=\"javascript:changeTA(this.value);\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t<option value=\"0\">".toCharArray();
    __oracle_jsp_text[30] = 
    "</option>\n\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t<option value=\"1\">".toCharArray();
    __oracle_jsp_text[32] = 
    "</option>\n\t\t</select></td>\n\t\t<td class=\"rowElementTitle\">".toCharArray();
    __oracle_jsp_text[33] = 
    " (".toCharArray();
    __oracle_jsp_text[34] = 
    ")</td>\n\t\t<td class=\"rowElementBody\"><input type=\"text\" size=\"4\"\n\t\t\tname=\"tiemp\" tabindex=\"6\" id=\"tiemp\" maxlength=\"3\"\n\t\t\tonkeypress=\"return soloNumeros(event)\"></td>\n\t</tr>\n</table>\n</form>\n".toCharArray();
    __oracle_jsp_text[35] = 
    " <script type=\"text/javascript\">\n    idArea=".toCharArray();
    __oracle_jsp_text[36] = 
    ";\n    tiempoEstimado = ".toCharArray();
    __oracle_jsp_text[37] = 
    ";    \n    tipoAcceso = ".toCharArray();
    __oracle_jsp_text[38] = 
    ";    \n    //Define el tipo de la tabla a 0, tabla de delegado de instrucciones\n    tipoTabla=0;\n    clearFields();\n</script>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
