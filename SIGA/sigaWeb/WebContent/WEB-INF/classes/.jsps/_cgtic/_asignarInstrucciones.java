package _cgtic;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import gob.hacienda.cgtic.siga.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.Utilerias;


public class _asignarInstrucciones extends com.orionserver.http.OrionHttpJspPage {


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
    _asignarInstrucciones page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      
      	String rutaBase = request.getContextPath();
      	UsuarioBean BUsuario = (UsuarioBean) session
      			.getAttribute("UsuarioBean");
      	Instruccion instruccion = new Instruccion();
      	Puestos puesto = new Puestos();
      	Unidad unidad = new Unidad();
      
      	String idArea = BUsuario.getIdArea();
      	String idUsr = BUsuario.getIdUsuario();
      	String idAsunto = "";
      	String idInstr = "";
      	String indexRow = "";
      
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
      	int tiempoEstimado;
      	if (idInstr == null || "".equals(idInstr)) {
      		tiempoEstimado = instruccion.getTiempoEstimado(idAsunto);
      	} else {
      		tiempoEstimado = instruccion.getTiempoEstimado(idAsunto,idInstr);
      	}
      	java.util.ResourceBundle labels = java.util.ResourceBundle
      			.getBundle("Etiquetas", java.util.Locale.US);
      
      	instruccion.updateIntrsExtra(idAsunto);
      
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.print(labels.getString("turnar.titulo"));
      out.write(__oracle_jsp_text[4]);
      out.print(rutaBase);
      out.write(__oracle_jsp_text[5]);
      out.print(labels.getString("instr.regresa"));
      out.write(__oracle_jsp_text[6]);
      out.print(rutaBase);
      out.write(__oracle_jsp_text[7]);
      out.print(labels.getString("instr.inserta"));
      out.write(__oracle_jsp_text[8]);
      out.print(rutaBase);
      out.write(__oracle_jsp_text[9]);
      out.print(labels.getString("instr.borra"));
      out.write(__oracle_jsp_text[10]);
      out.print(rutaBase);
      out.write(__oracle_jsp_text[11]);
      out.print(labels.getString("instr.guarda"));
      out.write(__oracle_jsp_text[12]);
      out.print(rutaBase);
      out.write(__oracle_jsp_text[13]);
      out.print(indexRow);
      out.write(__oracle_jsp_text[14]);
      out.print(idAsunto);
      out.write(__oracle_jsp_text[15]);
      out.print(idInstr);
      out.write(__oracle_jsp_text[16]);
      out.print(request.getParameter("retURI"));
      out.write(__oracle_jsp_text[17]);
      out.print(labels.getString("instr.nueva"));
      out.write(__oracle_jsp_text[18]);
      out.print(labels.getString("instr.actualiza"));
      out.write(__oracle_jsp_text[19]);
      out.print(labels.getString("A"));
      out.write(__oracle_jsp_text[20]);
      out.print(labels.getString("ua"));
      out.write(__oracle_jsp_text[21]);
      out.print(unidad.getComboUnidades());
      out.write(__oracle_jsp_text[22]);
      out.print(labels.getString("pto"));
      out.write(__oracle_jsp_text[23]);
      out.print(rutaBase);
      out.write(__oracle_jsp_text[24]);
      out.print(labels.getString("instr"));
      out.write(__oracle_jsp_text[25]);
      out.print(instruccion.getComboInstrucciones(idArea));
      out.write(__oracle_jsp_text[26]);
      out.print(labels.getString("ta"));
      out.write(__oracle_jsp_text[27]);
      
      					if (Utilerias.isIdInString(BUsuario.getIdArea(), session
      					.getServletContext().getAttribute(
      					"app.siga.informativas.tiempo.uas").toString())) {
      		
      out.write(__oracle_jsp_text[28]);
      out.print(labels.getString("E"));
      out.write(__oracle_jsp_text[29]);
      out.print(labels.getString("I"));
      out.write(__oracle_jsp_text[30]);
      
      		} else {
      		
      out.write(__oracle_jsp_text[31]);
      out.print(labels.getString("E"));
      out.write(__oracle_jsp_text[32]);
      out.print(labels.getString("I"));
      out.write(__oracle_jsp_text[33]);
      
      		}
      		
      out.write(__oracle_jsp_text[34]);
      out.print(labels.getString("tiemp"));
      out.write(__oracle_jsp_text[35]);
      out.print(tiempoEstimado);
      out.write(__oracle_jsp_text[36]);
      
      		try {
      		if (idAsunto != null || idInstr != null) {
      			out
      			.println("<iframe id=\"tableInstr\" src=\""
      			+ rutaBase
      			+ "/cgtic/tablaInstrucciones.jsp?idAsunto="
      			+ idAsunto
      			+ "&idInstr="
      			+ idInstr
      			+ "&call=New&tipoTabla=1&filtro=AS\" width='852' height='600' frameborder='0'>"
      			+ "</iframe>");
      		} else {
      			out
      			.println("<br><center>No hay instruciones relacionadas.</center>");
      		}
      	} catch (java.io.IOException io) {
      	}
      
      out.write(__oracle_jsp_text[37]);
      out.print(tiempoEstimado);
      out.write(__oracle_jsp_text[38]);
      out.print(idArea);
      out.write(__oracle_jsp_text[39]);
      out.print(idUsr);
      out.write(__oracle_jsp_text[40]);

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
  private static final char __oracle_jsp_text[][]=new char[41][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<!--Menu del JSP -->\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<br>\n<center>\n<table width=\"850\">\n\t<tr>\n\t\t<td class=\"bodyTitle\">".toCharArray();
    __oracle_jsp_text[4] = 
    "</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t<table>\n\t\t\t<tr>\n\t\t\t\t<td class=\"btnMenu\"><img\n\t\t\t\t\tsrc=\"".toCharArray();
    __oracle_jsp_text[5] = 
    "/cgtic/img/salir.gif\"\n\t\t\t\t\tonclick=\"javascript:salir();\"\n\t\t\t\t\talt=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\" id='btnSalir'></td>\n\t\t\t\t<td class=\"btnMenu\"><img src=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "/cgtic/img/mas.gif\"\n\t\t\t\t\tonclick=\"javascript:insertRow();\"\n\t\t\t\t\talt=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\" id='btnInst'></td>\n\t\t\t\t<td class=\"btnMenu\"><img\n\t\t\t\t\tsrc=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "/cgtic/img/menos.gif\"\n\t\t\t\t\tonclick=\"javascript:delRow();\"\n\t\t\t\t\talt=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\" id='btnDel'></td>\n\t\t\t\t<td class=\"btnMenu\"><img\n\t\t\t\t\tsrc=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "/cgtic/img/guardar.gif\"\n\t\t\t\t\tonclick=\"javascript:SaveRows();\"\n\t\t\t\t\talt=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" id='btnGuarda'></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"bodyTitle\">\n\t\t<hr width=\"850\" size=\"2pt\" style=\"color: #004080;\">\n\t\t</hr>\n\t\t</td>\n\t</tr>\n</table>\n<form action=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "/cgtic/guardaInstruccion.jsp\" id=\"actionForm\">\n<input type=\"hidden\" id=\"indexRow\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"indexRow\">\n<input type=\"hidden\" id=\"idAsunto\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"idAsunto\">\n<input type=\"hidden\" id=\"idInstr\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"idInstr\">\n<input type=\"hidden\" id=\"instStat\" value=\"0\" name=\"instStat\"> <input\n\ttype=\"hidden\" id=\"auto\" value=\"\" name=\"auto\"> <input\n\ttype=\"hidden\" name=\"retURI\" value='".toCharArray();
    __oracle_jsp_text[17] = 
    "' />\n<input type=\"text\" id=\"dataLine\" value=\"\" name=\"dataLine\" size=\"1\"\n\tonfocus=\"javascript:dataLineChanged();\"\n\tstyle=\"position: absolute; left: -100\"> <input type=\"text\"\n\tid=\"varPtoInst\" value=\"\" name=\"varPtoInst\" size=\"1\"\n\tonfocus=\"javascript:ptoInstChanged();\"\n\tstyle=\"position: absolute; left: -100\">\n\n<table class=\"tableForm\" width=\"850\">\n\t<tr>\n\t\t<td colspan=\"4\" align=\"right\"><input type=\"button\" tabindex=\"7\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\"\n\t\t\tonclick=\"javascript:clearFields();\"> <input type=\"button\"\n\t\t\ttabindex=\"7\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\"\n\t\t\tonclick=\"javascript:updateInstr();\" id='btnActInst'></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"rowElementTitle\">".toCharArray();
    __oracle_jsp_text[20] = 
    "</td>\n\t\t<td class=\"rowElementBody\" width=\"320\" colspan>\n\t\t<input type=\"checkbox\" name=\"B\" id=\"B\" checked=\"1\" value=\"1\" tabindex=\"0\"></td>\t\t\t\n\n\t\t<td class=\"rowElementTitle\">&nbsp;</td>\n\t\t<td class=\"rowElementBody\"><input type=\"checkbox\" name=\"R\" id=\"R\"\n\t\t\tchecked=\"0\" value=\"1\" tabindex=\"1\" style=\"visibility: hidden;\"></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"rowElementTitle\"><br>".toCharArray();
    __oracle_jsp_text[21] = 
    "</td>\n\t\t<td class=\"rowElementBody\" colspan=\"3\"><select name=\"ua\" id=\"ua\"\n\t\t\tonchange=\"javascript:changeUA(this.value);\" tabindex=\"1\" size=\"1\"\n\t\t\tstyle=\"position: absolute; left: -1000\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t</select>\n\t\t<div id=\"uaLabel\" class=\"rowElementBody\"></div>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"rowElementTitle\"><br>".toCharArray();
    __oracle_jsp_text[23] = 
    "</td>\n\t\t<td class=\"rowElementBody\" colspan=\"3\"><select name=\"pto\"\n\t\t\tid=\"pto\" onchange=\"javascript:changePuesto(this.value);\" tabindex=\"2\">\n\t\t\t<option value=\"null\" selected=\"selected\">[Seleccionar]</option>\n\t\t</select></td>\n\t</tr>\n\n\t<tr>\n\t\t<td class=\"rowElementTitle\">&nbsp;</td>\n\t\t<td colspan=\"3\" height=\"0\">\n\t\t<div id=\"iFrmPtoDiv\"\n\t\t\tstyle=\"posotion: absolute; visibility: hidden; height: 0;\"><iframe\n\t\t\tsrc=\"".toCharArray();
    __oracle_jsp_text[24] = 
    "/cgtic/detallePuesto.jsp\" height=\"0\" id=\"iFrmPto\"\n\t\t\tscrolling=\"no\" frameborder=\"0\"></iframe></div>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"rowElementTitle\">".toCharArray();
    __oracle_jsp_text[25] = 
    "</td>\n\t\t<td class=\"rowElementBody\" colspan=\"3\"><select name=\"instr\"\n\t\t\tid=\"instr\" onchange=\"javascript:selInstr();\" tabindex=\"3\">\n\t\t\t<div id=\"instrucciones\" name=\"instrucciones\">\n\t\t\t   ".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t</div>\n\t\t</select><input type=\"button\" value=\"Modificar >>\"\n\t\t\tonclick=\"javascript:modificaInstruccion();\" id='btnModIns'\n\t\t\tstyle=\"font-size: 8pt\"></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"rowElementTitle\">&nbsp;</td>\n\t\t<td class=\"rowElementBody\" colspan=\"3\"><input name=\"otraInstr\"\n\t\t\tvalue=\"\" id=\"otraInstr\" size=\"100\" maxlength=\"100\" tabindex=\"4\"\n\t\t\tonkeypress=\"return soloAlfanumerico(event)\"></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"rowElementTitle\">".toCharArray();
    __oracle_jsp_text[27] = 
    "</td>\n\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t<td class=\"rowElementBody\"><select name=\"ta\" id=\"ta\" tabindex=\"5\"\n\t\t\tonchange=\"javascript:changeTAEspecial(this.value);\">\n\t\t\t<option value=\"0\">".toCharArray();
    __oracle_jsp_text[29] = 
    "</option>\n\t\t\t<option value=\"1\">".toCharArray();
    __oracle_jsp_text[30] = 
    "</option>\n\t\t</select></td>\n\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t<td class=\"rowElementBody\"><select name=\"ta\" id=\"ta\" tabindex=\"5\"\n\t\t\tonchange=\"javascript:changeTA(this.value);\">\n\t\t\t<option value=\"0\">".toCharArray();
    __oracle_jsp_text[32] = 
    "</option>\n\t\t\t<option value=\"1\">".toCharArray();
    __oracle_jsp_text[33] = 
    "</option>\n\t\t</select></td>\n\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t<td class=\"rowElementTitle\">".toCharArray();
    __oracle_jsp_text[35] = 
    "(".toCharArray();
    __oracle_jsp_text[36] = 
    ")</td>\n\t\t<td class=\"rowElementBody\"><input type=\"text\" size=\"4\"\n\t\t\tname=\"tiemp\" tabindex=\"6\" id=\"tiemp\" maxlength=\"3\"\n\t\t\tonkeypress=\"return soloNumeros(event)\"></td>\n\t</tr>\n</table>\n</form>\n".toCharArray();
    __oracle_jsp_text[37] = 
    " <iframe id=\"iFrmSupport\" src=\"\" width='1' height='1' frameborder='0'\n\tstyle=\"position: absolute; top: 200; left: 0; filter: alpha(opacity = 50);\">\n</iframe> <script type=\"text/javascript\">\n    // Establece el tiempo estimado\n    tiempoEstimado = ".toCharArray();
    __oracle_jsp_text[38] = 
    ";    \n    //Define el tipo de la tabla a 1, tabla de turnado de instrucciones\n    tipoTabla=1;\n    // Establece el ID de la Unidad Administrativa\n    idArea=".toCharArray();
    __oracle_jsp_text[39] = 
    ";\n\tidUsr=".toCharArray();
    __oracle_jsp_text[40] = 
    ";\n    clearFields();\n</script>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
