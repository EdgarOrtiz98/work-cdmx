package _cgtic;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import gob.hacienda.cgtic.siga.*;
import com.meve.sigma.beans.*;
import gob.hacienda.cgtic.siga.beans.*;
import com.meve.sigma.util.Utilerias;


public class _tablaInstrucciones extends com.orionserver.http.OrionHttpJspPage {


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
    _tablaInstrucciones page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      
      UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      Instruccion instruccion = new Instruccion();
      String idUsr = BUsuario.getIdUsuario();
      String idArea = BUsuario.getIdArea();
      String idAsunto = "";
      String idInstr = "";
      String strRutaBase = request.getContextPath();// (application.getInitParameter("RutaBase")==null)?"/SIGA":application.getInitParameter("RutaBase");
      try{
      if (request.getParameter("idAsunto")==null){
          out.println("<font color='#FF0000'>Error: No hay Id de Asunto.");
      }else{
          idAsunto = request.getParameter("idAsunto");
      }
      if (request.getParameter("idInstr")!=null){
          idInstr = request.getParameter("idInstr");
      }
      }catch(java.io.IOException io){
      	//System.err.println("io="+io);
      }
      java.util.ResourceBundle labels = java.util.ResourceBundle.getBundle(
          "Etiquetas",java.util.Locale.US);
      
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.print(strRutaBase);
      out.write(__oracle_jsp_text[4]);
      out.print(idAsunto);
      out.write(__oracle_jsp_text[5]);
      out.print(idInstr);
      out.write(__oracle_jsp_text[6]);
      if(Utilerias.isIdInString(idArea,session.getServletContext().getAttribute("app.siga.informativas.tiempo.uas").toString())){ 
      out.write(__oracle_jsp_text[7]);
      }else{
      out.write(__oracle_jsp_text[8]);
      }
      out.write(__oracle_jsp_text[9]);
      
      String action = (request.getParameter("action")==null)?"":
                          request.getParameter("action");
      String tipoTabla = "0";                    
      String filtro = "";
      if (request.getParameter("filtro")!=null)
          filtro = request.getParameter("filtro");
      if (request.getParameter("tipoTabla")!=null)
          tipoTabla = request.getParameter("tipoTabla");
          tablaInstruccionesBean instrBean;
      
      // primera entrada...
      if (request.getParameter("call")!=null){
          if (request.getParameter("call").equals("New")){
              instrBean = instruccion.getTablaInstruccionesBean(idAsunto, idInstr);
              //Verifica el tipo de tabla que se requiere construir...
              if (tipoTabla.equals("0"))
                  instrBean.setTipoTabla(tablaInstruccionesBean.TIPO_DELEGADO);
              else
                  instrBean.setTipoTabla(tablaInstruccionesBean.TIPO_TURNADO);
              session.setAttribute("tablaInstruccionesBean", instrBean);
          }
      }    
      // Si no existe el objeto....
      if (session.getAttribute("tablaInstruccionesBean")==null){
          instrBean = instruccion.getTablaInstruccionesBean(idAsunto, idInstr);
          instrBean.setTipoTabla((tipoTabla.equals("0"))?tablaInstruccionesBean.TIPO_DELEGADO:tablaInstruccionesBean.TIPO_TURNADO);
      }else{
          instrBean = (tablaInstruccionesBean) session.getAttribute("tablaInstruccionesBean");
          instrBean.setTipoTabla((tipoTabla.equals("0"))?tablaInstruccionesBean.TIPO_DELEGADO:tablaInstruccionesBean.TIPO_TURNADO);
      }
      
      // Borrar una instrucción...
      if (action.equalsIgnoreCase("delete")){
          instrBean.delRow(Integer.parseInt(request.getParameter("indexRow")) );
          //out.println("DELETED!");
      }
      
      // Instertar una instrucción...
      if (action.equalsIgnoreCase("insert")){
          String A= request.getParameter("A");
          String R= request.getParameter("R");
          String pto= request.getParameter("pto");
          String instr= request.getParameter("instr");
          if (instr.equals("[otra]"))
              instr = "0";
          String otraInstr= request.getParameter("otraInstr");
          //char tiat[]= request.getParameter("ta").toCharArray();
      	String tiat = request.getParameter("ta");
          String tiemp= request.getParameter("tiemp");
      
          instrBean.insertRow(Integer.parseInt(A), Integer.parseInt(R), Integer.parseInt(pto),
              Integer.parseInt(instr), otraInstr, tiat, Integer.parseInt(tiemp));
          //out.println("INSERTED!"); 
      }
      
      // Actualizar una instrucción...
      if (action.equalsIgnoreCase("update")){
          String A= request.getParameter("A");
          String R= request.getParameter("R");
          String pto= request.getParameter("pto");
          String instr= request.getParameter("instr");
          if (instr.equals("[otra]"))
              instr = "0";
          String otraInstr= request.getParameter("otraInstr");
          //char tiat[]= request.getParameter("ta").toCharArray();
      	String tiat = request.getParameter("ta");
          String tiemp= request.getParameter("tiemp");
          String instStat = request.getParameter("instStat");
          String indxRow = request.getParameter("indxRow");
      	String auto = request.getParameter("auto");
           
          instrBean.updateRow(Integer.parseInt(A), Integer.parseInt(R), Integer.parseInt(pto),
              Integer.parseInt(instr), otraInstr, tiat, Integer.parseInt(tiemp), 
              Integer.parseInt(instStat), Integer.parseInt(indxRow), Integer.parseInt(auto));
          //out.println("INSERTED!");
      }
      try{
      // Guardar todas las instrucciones...
      if (action.equalsIgnoreCase("saveAll")){
          try{
              instrBean.Save();
              out.println("alert(\"Las instrucciones se han guardado exitosamente.\");");
          }catch(Exception e){
              out.println("alert('El tipo de documento no tiene pasos configurados');");
          }
      	instrBean = instruccion.getTablaInstruccionesBean(idAsunto, idInstr);
              instrBean.setTipoTabla((tipoTabla.equals("0"))?tablaInstruccionesBean.TIPO_DELEGADO:tablaInstruccionesBean.TIPO_TURNADO);
          
      }
      
      
      out.write(__oracle_jsp_text[10]);
      
          String wTD="300";
          if (Integer.parseInt(tipoTabla)==tablaInstruccionesBean.TIPO_TURNADO){
              wTD = "200";
              out.print("<td class='tableTitle' width='" + wTD + "'>");
              out.print(labels.getString("ua") + "</td>");
          }
      
      out.write(__oracle_jsp_text[11]);
      out.print(wTD);
      out.write(__oracle_jsp_text[12]);
      out.print(labels.getString("usu-pto"));
      out.write(__oracle_jsp_text[13]);
      out.print(wTD);
      out.write(__oracle_jsp_text[14]);
      out.print(labels.getString("instr"));
      out.write(__oracle_jsp_text[15]);
      out.print(labels.getString("ta_short"));
      out.write(__oracle_jsp_text[16]);
      out.print(labels.getString("tiemp_short"));
      out.write(__oracle_jsp_text[17]);
      out.print(labels.getString("A_short"));
      out.write(__oracle_jsp_text[18]);
      out.print(labels.getString("R"));
      out.write(__oracle_jsp_text[19]);
      
      out.println(instrBean.getHTML());
      session.setAttribute("tablaInstruccionesBean", instrBean);
      }catch(java.io.IOException io){
      	//System.err.println("io="+io);
      }
      
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
    "\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<html><head>\n<link rel=\"stylesheet\" type=\"text/css\" \n    href=\"".toCharArray();
    __oracle_jsp_text[4] = 
    "/cgtic/css/cgtic-siga.css\"/>\n<script type=\"text/javascript\" >\nfunction getRowBy(indx){\n    var dataLine=\"\";\n    var elID = \"\";\n    var styleTR=\"\";\n    for (i=0;i<25;i++){\n        if (document.getElementById(\"rowLn\"+i)){\n        \n            if(document.getElementById(\"R\" + i + \"C7\").value==\"0\")\n                styleTR=\"tableBody\";\n            else \n                styleTR=\"tableBody2\";        \n\n            if (document.getElementById(\"R\" + i + \"C1\").value==\"[otra]\" &&\n                document.getElementById(\"R\" + i + \"C1a\").value==\"\") \n                styleTR=\"tableBodyRed\";    \n\n            document.getElementById(\"rowLn\"+i).className = styleTR;\n\t    document.getElementById(\"rowLn\"+i).style.borderStyle= \"solid\";    \n\t    document.getElementById(\"rowLn\"+i).style.borderBottomWidth= \"1pt\";    \n\t    document.getElementById(\"rowLn\"+i).style.borderBottomColor= \"#c0c0c0\";\n   \t    if(i != indx)\n                document.getElementById(\"iRw\"+i).checked = false;\n   \t    \n        }\n    }\n    document.getElementById(\"rowLn\"+indx).className  =\"tableSelect\";\n    document.getElementById(\"rowLn\"+indx).style.borderWidth= \"4pt\";    \n    document.getElementById(\"rowLn\"+indx).style.borderStyle= \"solid\";    \n    document.getElementById(\"rowLn\"+indx).style.borderColor= \"#AAAAFF\";\n    if(document.getElementById(\"R\" + indx + \"C7\").value==\"1\")\n        document.getElementById(\"rowLn\"+indx).style.color= \"#C0C0C0\";        \n\n//Index\n    dataLine+= indx + \",\";\n//Acceso    \n    elID = \"R\" + indx + \"C5\";\n    dataLine += document.getElementById(elID).value + \",\";    \n//Requerido    \n/*\n    elID = \"R\" + indx + \"C6\";\n    dataLine += document.getElementById(elID).value + \",\";    \n    \n    Deja de ser útil el campo requerido, por default se maneja el cero...\n*/\n    dataLine += \"0,\";    \n    \n//Puesto\n    elID = \"R\" + indx + \"C2\";\n    dataLine += document.getElementById(elID).value + \",\"; \n//Insrtrucción\n    elID = \"R\" + indx + \"C1\";\n    dataLine += document.getElementById(elID).value + \",\";    \n    elID = \"R\" + indx + \"C1a\";\n    dataLine += document.getElementById(elID).value + \",\";    \n//tipo ate.\n    elID = \"R\" + indx + \"C3\";\n    dataLine += document.getElementById(elID).value + \",\";    \n//tiempo\n    elID = \"R\" + indx + \"C4\";\n    dataLine += document.getElementById(elID).value + \",\";    \n//iD's\n    dataLine += \"".toCharArray();
    __oracle_jsp_text[5] = 
    ",\";    \n    dataLine += \"".toCharArray();
    __oracle_jsp_text[6] = 
    ",\";    \n//estatus\n    elID = \"R\" + indx + \"C7\";\n    dataLine += document.getElementById(elID).value + \",\";    \n//UA\n    elID = \"R\" + indx + \"C2a\";\n    dataLine += document.getElementById(elID).value + \",\";\n//auto\n    elID = \"R\" + indx + \"C8\";\n    dataLine += document.getElementById(elID).value + \",\";\n//Estado del checkbox\n    dataLine += document.getElementById(\"iRw\"+indx).checked;\n    \n   ".toCharArray();
    __oracle_jsp_text[7] = 
    "\n        dataLine += \",1\";\n    ".toCharArray();
    __oracle_jsp_text[8] = 
    "\n        dataLine += \",0\";    \n    ".toCharArray();
    __oracle_jsp_text[9] = 
    "   \n    top.window.document.getElementById(\"dataLine\").value = dataLine;\n    top.window.document.getElementById(\"dataLine\").focus();\n}\n\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n</script>\n</head><body  background=\"../Imagenes/fondo_claro.jpg\">\n<form action=\"tablaInstrucciones.jsp\" id='tableIns'>\n<table class=\"tableInstr\" cellspacing=\"0\" width=\"800\">\n  <tr>\n    <td class=\"tableTitle\">&nbsp;</td>\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n    <td class=\"tableTitle\" width='".toCharArray();
    __oracle_jsp_text[12] = 
    "'>".toCharArray();
    __oracle_jsp_text[13] = 
    "</td>\n    <td class=\"tableTitle\" width='".toCharArray();
    __oracle_jsp_text[14] = 
    "'>".toCharArray();
    __oracle_jsp_text[15] = 
    "</td>\n    <td class=\"tableTitle\">".toCharArray();
    __oracle_jsp_text[16] = 
    "</td>\n    <td class=\"tableTitle\">".toCharArray();
    __oracle_jsp_text[17] = 
    "</td>\n    <td class=\"tableTitle\">".toCharArray();
    __oracle_jsp_text[18] = 
    "</td>\n<!--\n    <td class=\"tableTitle\">".toCharArray();
    __oracle_jsp_text[19] = 
    "</td>\n-->\n  </tr>\n".toCharArray();
    __oracle_jsp_text[20] = 
    "\n</table>\n<table>  \n  <tr>\n    <td colspan=\"8\" style=\"{font-family:Arial,Helvetica;color:#FF2020;\n    font-size:10pt;background:transparent;}\">(*) Instrucciones incompletas.\n    </td>\n  </tr>\n</table>\n</form>\n</body></html>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
