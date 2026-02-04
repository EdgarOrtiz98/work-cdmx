package _cgtic._seguimiento;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import gob.hacienda.cgtic.siga.seguimiento.*;
import com.meve.sigma.beans.*;


public class _AsuntosRelacionados extends com.orionserver.http.OrionHttpJspPage {


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
    _AsuntosRelacionados page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      
          UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
          String idUsr = BUsuario.getIdUsuario();
          
          String server = (application.getInitParameter("servername")==null)?
                      "":application.getInitParameter("servername");
          String strRutaBase = (application.getInitParameter("RutaBase")==null)?
                      "/SIGA":application.getInitParameter("RutaBase");	
          String urlSIGA = server + strRutaBase;
      
          String folio = request.getParameter("folio");
          HttpSession sesion = request.getSession(true);
          
          boolean resultadoOK = false;
          boolean consulto = false;
          Ruta ruta = null;
          
         // System.out.println(this.getClass()+" Folio: "+folio);
          if (folio!= null){
              // Instancia la clase sura y asocia valores iniciales para crear la ruta de asuntos
              ruta = new Ruta(folio);
              ruta.setSesion(sesion.getId().toString());
              
      //        //System.out.println("Session ID: " + sesion.getId().toString());
              
              // Obtiene el idAsunto a partir del folio
             // System.out.println(this.getClass()+" resultadoOk: "+resultadoOK+" : ruta.cosultaIdAsunto(): "+ruta.consultaIdAsunto());
              /*
                  Se obtiene:
                      idAsunto;
                      descAsunto;
                      firmante;
                      unidadAdministrativa;
                      remitente;
                      comentarios;
              */
              if (resultadoOK = ruta.consultaIdAsunto()){
      //            System.out.println(this.getClass()+" resultadoOk: "+resultadoOK+" : ruta.ObtenerAsuntosRelacionados(): "+ruta.ObtenerAsuntosRelacionados());
                  /*Manda a llamar a SP_RUTA_ASUNTOS_RELACIONADOS(idAsunto,session,error,out); y regresa un error o el número de asuntos relacionados.*/
                  if (resultadoOK = ruta.ObtenerAsuntosRelacionados()){
      //                System.out.println(this.getClass()+" resultadoOk: "+resultadoOK+" : ruta.consultaAsuntos(): "+ruta.consultaAsuntos());
                      /*Carga los nodos encontrados por el store*/
                      if (resultadoOK = ruta.consultaAsuntos()){
      //                    System.out.println(this.getClass()+" resultadoOk: "+resultadoOK+" : ruta.consultaRelaciones(): "+ruta.consultaRelaciones());
                          /*Carga los nodos encontrados por el store*/
                          if (resultadoOK = ruta.consultaRelaciones()){
      //                        System.out.println(this.getClass()+" resultadoOk: "+resultadoOK+" : ruta.consultaAsuntosViejos(): "+ruta.consultaAsuntosViejos());
                              /*Carga los nodos encontrados por sentencia SQL*/
                              if (resultadoOK = ruta.consultaAsuntosViejos()){
      //                            System.out.println(this.getClass()+" resultadoOk: "+resultadoOK+" : ruta.borraAsuntosAsociados()");
                                  /*Elimina consultas*/
                                  resultadoOK = ruta.borraAsuntosAsociados();
                              }
                          }
                      }
                  }
              }
              //consulto = true;
              consulto = request.getParameter("folio").length()>0?true:false;
          }
      
      
      out.write(__oracle_jsp_text[2]);
      out.print(strRutaBase );
      out.write(__oracle_jsp_text[3]);
      
          // Pone la descripción del Asunto en caso de que se tenga
          if (consulto && resultadoOK){
      
      out.write(__oracle_jsp_text[4]);
      {
        String __url=OracleJspRuntime.toStr("/cgtic/seguimiento/datosAsunto.jsp");
        __url=OracleJspRuntime.genPageUrl(__url,request,response,new String[] {"folio" } ,new String[] {OracleJspRuntime.toStr(folio) } );
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[5]);
        }
      out.write(__oracle_jsp_text[6]);
      
          String[][] resultadoConsulta = (String[][])request.getAttribute("resultadoConsulta");
          if (consulto /*&& resultadoConsulta != null && resultadoConsulta.length > 0*/){
      
      out.write(__oracle_jsp_text[7]);
      
              if (!resultadoOK){
                  if (folio != null && !folio.equals("")) {
      
      out.write(__oracle_jsp_text[8]);
      out.print(ruta.getError());
      out.write(__oracle_jsp_text[9]);
      }      
          }else{
          String nombres = "";
          String relaciones = "";
          String asuntosViejos = "";
          String asuntosConPermiso="";
          String relacionIDFolioStr="";
          int elementos = 0;
          
                  
                  
                  // Crea el parámetro nombres
                  for(int i=0;i<ruta.getNumNodos();i++)
                      nombres+= ruta.getNodos()[i][0] +  ",";
                  nombres = nombres.substring(0,nombres.length()-1);
                  
                  // Crea el parámetro relaciones
                  for(int i=0;i<ruta.getNumReg();i++)
                      relaciones+= ruta.getSalida()[i][0] + "@" +ruta.getSalida()[i][1] 
                      + "@" +ruta.getSalida()[i][2] + "@" +ruta.getSalida()[i][3] + ",";
                  
                  relaciones = relaciones.substring(0, (relaciones.length()>0)?relaciones.length()-1:0);
      
                  // Crea el parámetro AsuntosViejos
                  for(int i=0;i<ruta.getNumAsuntosViejos();i++)
                      asuntosViejos+= ruta.getAsuntosViejos()[i][0] +  ",";
      
      
                  asuntosViejos = asuntosViejos.substring(0,(asuntosViejos.length()>0)?asuntosViejos.length()-1:0);
      
                  // Asigna el número de elementos(Asuntos) a tratar
                  elementos = ruta.getNumNodos() + ruta.getNumReg();
                  
                  // Asigna los folios dentro del conjunto de relaciones a los cuales el usuario tiene permiso
                  asuntosConPermiso = ruta.asuntosConPermiso(nombres, idUsr);
                  relacionIDFolioStr = ruta.relacionIDFolio ;
                  out.println("<!--");
                  out.println("<br>Lista de folios: " + nombres);
                  out.println("<br>Lista de folios con permiso: " + asuntosConPermiso);
                  out.println("<br>idUsr: " + idUsr);
                  out.println("-->");
                  if(relaciones != null && !relaciones.equals("") ) {
                      // Invocación del Applet
                      // out.println("<applet Archive='DiagramaAsuntos.jar,lib/jgraph.jar,lib/jgraphlayout.jar' ");
                      // out.println("<applet Archive='lib/jgraph.jar,lib/jgraphlayout.jar' ");
                      // out.println("CODE='DiagramaAsuntos.class' WIDTH='1000' HEIGHT='800' ALIGN='BOTTOM'>");
                      
                      
                      String urlDetalle = request.getScheme() +"://" + request.getServerName() + (request.getServerPort()!= 80? ":" + request.getServerPort():"") + request.getContextPath() + "/jsp/AsuntoTurnado.jsp";
                      String urlRuta = request.getScheme() +"://" + request.getServerName() + (request.getServerPort()!= 80? ":" + request.getServerPort():"") + request.getContextPath() + "/jsp/rastreoRuta.jsp";
                      out.println("<applet Archive='lib/jgraph.jar,lib/jgraphlayout.jar'  style='background:transparent;' ");
                      out.println("CODEBASE='../cgtic/seguimiento' CODE='DiagramaAsuntos.class' WIDTH='800' HEIGHT='600' ALIGN='BOTTOM'>");
                      out.println("<param name='elementos' value='" + elementos + "'>");
                      out.println("<param name='inicio' value='" + ruta.getFolio() + "'>");
                      out.println("<param name='masViejo' value='" + asuntosViejos + "'>");
                      out.println("<param name='conPermiso' value='"+ asuntosConPermiso + "'>");
                      out.println("<param name='nombres' value='" + nombres + "'>");
                      out.println("<param name='relaciones' value='" + relaciones + "'>");
                      out.println("<param name='relacionIDFolioStr' value='" + relacionIDFolioStr + "'>");
                      out.println("<param name='urlDetalle' value='" + urlDetalle + "'>");
                      out.println("<param name='urlRuta' value='" + urlRuta + "'>");
                      out.println("<param name='w' value='120'>");
                      out.println("<param name='h' value='30'>");
                      out.println("</applet>");
                  } else {
                      out.println("No existen Relaciones para el asunto: " + ruta.getFolio());
                  }
              }// Termina if (!resultadoOK)
      
      out.write(__oracle_jsp_text[10]);
        }  // Termina if(consulto && resultadoConsulta != null && resultadoConsulta.length > 0)
          else if(consulto&&! resultadoOK){ 
      out.write(__oracle_jsp_text[11]);
      out.print(ruta.getFolio());
      out.write(__oracle_jsp_text[12]);
      }else{
      out.write(__oracle_jsp_text[13]);
      }
      out.write(__oracle_jsp_text[14]);

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
  private static final char __oracle_jsp_text[][]=new char[15][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n\n// Pone el foco en el campo cuyo id se indique\nfunction foco(id){\n    var foliof=document.getElementById(id);\n    foliof.focus();\n    foliof.select();\n}\n\n\nfunction validarFormulario(formulario) {\n    if(formulario.folio.value == '') {\n        alert('El campo Folio es obligatorio');\n        return false;\n    }\n    return true;\n}\n</SCRIPT>\n\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n\n<html>\n  <head>\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\"/>\n    <title>AsuntosRelacionados</title>\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[3] = 
    "/cgtic/css/cgtic-siga.css\"/>\n    <STYLE type=text/css>BODY {\n\tMARGIN: 0px\n    }\n    </STYLE>\n  </head>\n  <body background=\"../Imagenes/fondo_claro.jpg\" onload=\"foco('foliof')\">\n  <form name=\"formaFolio\" action=\"rastreoRuta.jsp\" method=\"POST\" onSubmit=\"return validarFormulario(this);\")>\n        <span class=\"rowElementTitle\">\n          Folio:\n        </span>\n      <input type=\"text\" name=\"folio\" id=\"foliof\" maxlength=\"50\" size=\"50\"/>\n      <input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Buscar...\"/>\n      \n    </form><p>\n    \n".toCharArray();
    __oracle_jsp_text[4] = 
    "    \n        ".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "    \n    <hr/ style=\"border-color:rgb(82,140,255);\" size=\"1\">\n".toCharArray();
    __oracle_jsp_text[7] = 
    "    \n    <table class=\"tableInstr\" width=\"50%\" cellspacing=\"0\">\n".toCharArray();
    __oracle_jsp_text[8] = 
    "    \n              <tr>\n                <th>\n                  <div align=\"left\">\n                    Ocurrio el siguiente error: ".toCharArray();
    __oracle_jsp_text[9] = 
    "\n                  </div>\n                </th>\n              </tr>\n            \n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n    </table>\n    <input type=\"hidden\" name=\"creado\" id=\"creado\" value=\"0\"/>\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n    <table class=\"tableInstr\" width=\"50%\" cellspacing=\"0\">\n      <tr>\n        <th>\n          <div align=\"left\">\n            No existe una rutas de Rastreo para el asunto: ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n          </div>\n        </th>\n      </tr>\n      </table>\n    ".toCharArray();
    __oracle_jsp_text[13] = 
    "\n    <table class=\"tableInstr\" width=\"50%\" cellspacing=\"0\">\n      <tr>\n        <th>\n          <div align=\"left\">\n            Escriba un n&uacute;mero de folio...\n          </div>\n        </th>\n      </tr>\n      </table>\n    ".toCharArray();
    __oracle_jsp_text[14] = 
    "\n  </body>\n</html>\n\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
