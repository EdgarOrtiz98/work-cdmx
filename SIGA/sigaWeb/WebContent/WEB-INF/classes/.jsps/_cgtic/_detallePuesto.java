package _cgtic;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import gob.hacienda.cgtic.siga.*;


public class _detallePuesto extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html;charset=windows-1252");
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
    _detallePuesto page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      
        // Variable que sirve para verificar si la consulta a la BD fué correcta
          boolean consultaOK = false; 
          String puestoPar= "";
          Puesto puesto=null;
        // Verificamos que el parametro no sea null, para evitar un NullPointerException...
          if (request.getParameter("puestoPar")!=null){
            // Obtiene el parámetro puestoPar que trae el IdUsuario
            puestoPar = request.getParameter("puestoPar");
            
            // Crea una instancia de la clase puesto y realiza la consulta a la BD
            puesto = new Puesto(puestoPar);
            consultaOK = puesto.consultaPuesto();
        }
      
      out.write(__oracle_jsp_text[3]);
       
          /* En caso de que no se haya podido realizar la consulta manda un mensaje de 
          * error a pantalla, en caso que contrario muestra la información solicitada
          */
          if(!consultaOK){
          
      out.write(__oracle_jsp_text[4]);
       
          }else{
            /* Crea la variable de propiedades, para obtener las etiquetas del archivo
            * de propiedades Etiquetas.properties
            */
            java.util.ResourceBundle etiquetas = java.util.ResourceBundle.getBundle(
            "Etiquetas",java.util.Locale.US);
          
            /* Procede a pintar la tabla con los valores obtenidos, las etiqutas
            * se obtienen de la clase etiquetas y los valores de la clase puesto
            */
          
      out.write(__oracle_jsp_text[5]);
      out.println(etiquetas.getString("detallePuesto.cargo")+":");
      out.write(__oracle_jsp_text[6]);
      out.print(puesto.getCargo());
      out.write(__oracle_jsp_text[7]);
      out.println(etiquetas.getString("detallePuesto.telefono")+":");
      out.write(__oracle_jsp_text[8]);
      out.print(puesto.getTelefono());
      out.write(__oracle_jsp_text[9]);
      out.println(etiquetas.getString("detallePuesto.correo")+":");
      out.write(__oracle_jsp_text[10]);
      out.print(puesto.getCorreo());
      out.write(__oracle_jsp_text[11]);
       }
      out.write(__oracle_jsp_text[12]);

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
  private static final char __oracle_jsp_text[][]=new char[13][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!--\n**************************************************************\n* Copyright (C) 2007 SHCP \n* CGTIyC - alberto_ortiz@hacienda.gob.mx\n* \n* $$Archivo: \t  detallePuesto.jsp\n* $$Revisión: \t  AOA - detalle del puesto\n* $$Fecha: \t  14 Ene 2007\n* $$Descripción:  Muestra el detalle de un puesto seleccionado en la pantalla\n*                 que invoca\n* \n* Este software es información propietaria y confidencial de la SHCP - CGTIyC. \n**************************************************************\n-->\n\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n\"http://www.w3.org/TR/html4/loose.dtd\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n\n<html>\n  <head>\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\"/>\n    <title>detallePuesto</title>\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"../cgtic/css/cgtic-siga.css\"/>\n  </head>\n  <body background=\"../Imagenes/fondo_claro.jpg\">\n  <!--<hr width=\"600\" size=\"1pt\" style=\"color=#004080;\">-->\n    ".toCharArray();
    __oracle_jsp_text[4] = 
    "\n        <p class=\"rowElementTitle\"><strong>No se ha podido obtener informaci&oacute;n del puesto</strong></p>\n    ".toCharArray();
    __oracle_jsp_text[5] = 
    "\n    <table cellspacing=\"0\" cellpadding=\"3\" border=\"0\" width=\"600\" align=\"left\">\n      <tr>\n        <td width=\"100\" height=\"10\" class=\"rowElementTitle\">\n          <div align=\"left\">\n            ".toCharArray();
    __oracle_jsp_text[6] = 
    "\n          </div>\n        </td>\n        <td width=\"600\" class=\"tableBody\" colspan=\"3\">".toCharArray();
    __oracle_jsp_text[7] = 
    "</td>\n      </tr>\n      <tr>\n        <th width=\"100\" height=\"10\" class=\"rowElementTitle\">\n          <div align=\"left\">\n            ".toCharArray();
    __oracle_jsp_text[8] = 
    "\n          </div>\n        </th>\n        <td width=\"300\" class=\"tableBody\">".toCharArray();
    __oracle_jsp_text[9] = 
    "</td>\n        <th width=\"100\" height=\"10\" class=\"rowElementTitle\">\n          <div align=\"left\">\n            ".toCharArray();
    __oracle_jsp_text[10] = 
    "\n          </div>\n        </th>\n        <td width=\"300\" class=\"tableBody\">".toCharArray();
    __oracle_jsp_text[11] = 
    "</td>\n      </tr>\n    </table>\n    ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n    </body>\n</html>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
