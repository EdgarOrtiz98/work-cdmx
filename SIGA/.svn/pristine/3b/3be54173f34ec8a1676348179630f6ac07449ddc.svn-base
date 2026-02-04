package _cgtic._seguimiento;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import gob.hacienda.cgtic.siga.Asunto;


public class _datosAsunto extends com.orionserver.http.OrionHttpJspPage {


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
    _datosAsunto page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      
          String folio = request.getParameter("folio");
          Asunto asu = new Asunto(folio);
      
              /*
               0 - A.ID_ASUNTO
               1 - A.ASU_FOLIO_RECEPCION
               2 - A.ASU_ENTIDAD 
               3 - B.ENT_NOMBRE 
               4 - A.ASU_REMITENTE 
               5 - C.RMT_NOMBRE 
               6 - A.ASU_FIRMANTE 
               7 - A.ASU_TIP_DOCTO
               8 - D.TIP_DOCTO_NOMBRE 
               9 - A.ASU_LISTAIDS_PARA 
               10 - A.ASU_LISTAIDS_CC 
               11 - A.ASU_DESCRIPCION     //Esconder
               12 - A.ASU_TRAMITE 
               13 - A.ASU_FECHA_CAPTURA 
               14 - A.ASU_FECHA_RECEPCION 
               15 - A.ASU_FECHA_DOCTO 
               16 - A.ASU_FECHA_CADUCIDAD 
               17 - A.ASU_AVANCE 
               18 - A.ASU_ESTATUS 
               19 - A.ASU_FOLIO_EXTERNO 
               20 - A.ASU_FOLIO_INTERMEDIO 
               21 - A.ASU_FECHA_EVENTO 
               22 - A.ASU_HORA_EVENTO
               23 - A.ASU_LUGAR_EVENTO 
               24 - A.ASU_PRIORIDAD 
               25 - E.PRI_NOMBRE
               26 - A.ASU_TIPO_ASUNTO  
               27 - F.TIP_ASU_NOMBRE
               */
          String [][] regAsu = asu.getDatos();
          request.setAttribute("resultadoConsulta",regAsu);
          //for(int i=0;i<regAsu.length;i++) {
             // //System.out.println("regAsu["+ regAsu.length + "][" + regAsu[i].length+"]");
          //}
          if (regAsu != null){
              if (asu.getTipoRegistro().equalsIgnoreCase("variable")){
      
      out.write(__oracle_jsp_text[1]);
      try{out.println(regAsu[0][1]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[2]);
      try{out.println(regAsu[0][2]+" - "+regAsu[0][3]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[3]);
      try{out.println(regAsu[0][13]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[4]);
      try{out.println(regAsu[0][14]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[5]);
      try{out.println(regAsu[0][15]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[6]);
      try{out.println(regAsu[0][16]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[7]);
      try{out.println(regAsu[0][5]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[8]);
      try{out.println(regAsu[0][6]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[9]);
      try{out.println(regAsu[0][8]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[10]);
      try{out.println(regAsu[0][12]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[11]);
      try{out.println(regAsu[0][17]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[12]);
      try{out.println(regAsu[0][12]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[13]);
      try{out.println(regAsu[0][19]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[14]);
      try{out.println(regAsu[0][20]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[15]);
      try{out.println(regAsu[0][21]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[16]);
      try{out.println(regAsu[0][22]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[17]);
      try{out.println(regAsu[0][23]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[18]);
      try{out.println(regAsu[0][24]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[19]);
      try{out.println(regAsu[0][27]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[20]);
       
              }
              /*
               0 - ID_ASUNTO_REF           
               1 - ASU_REF_AREA_RECEPCION  
               2 - ASU_REF_ENTIDAD         
               3 - ASU_REF_REMITENTE       
               4 - ASU_REF_REMITENTE_NOMBRE
               5 - ASU_REF_REMITENTE_CORREO
               6 - ASU_REF_CONTROL         
               7 - ASU_TURNADOR_PUESTO     
               8 - ASU_TURNADOR_NOMBRE     
               9 - ASU_REF_TURNADOR_AREA   
               10 - ASU_REF_TIPO_DOCTO      
               11 - ASU_REF_EXPEDIENTE      
               12 - ASU_REF_TRAMITE         
               13 - ASU_REF_TIPO_ASUNTO     
               14 - ASU_REF_PRIORIDAD       
               15 - ASU_REF_USR_CAPTURA     
              */
      
              if (asu.getTipoRegistro().equalsIgnoreCase("fijo")){
      
      out.write(__oracle_jsp_text[21]);
      out.print(folio );
      out.write(__oracle_jsp_text[22]);
      try{out.println(regAsu[0][2]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[23]);
      try{out.println(regAsu[0][41]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[24]);
      try{out.println(regAsu[0][31]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[25]);
      try{out.println(regAsu[0][32]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[26]);
      try{out.println(regAsu[0][33]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[27]);
      try{out.println(regAsu[0][4]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[28]);
      try{out.println(regAsu[0][22]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[29]);
      try{out.println(regAsu[0][10]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[30]);
      try{out.println(regAsu[0][65]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[31]);
      try{out.println(regAsu[0][44]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[32]);
      try{out.println(regAsu[0][43]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[33]);
      try{out.println(regAsu[0][34]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[34]);
      try{out.println(regAsu[0][35]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[35]);
      try{out.println(regAsu[0][58]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[36]);
      try{out.println(regAsu[0][57]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[37]);
      try{out.println(regAsu[0][59]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[38]);
      try{out.println(regAsu[0][14]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[39]);
      try{out.println(regAsu[0][13]);}catch(Exception e){out.println("&nbsp;");}
      out.write(__oracle_jsp_text[40]);
      
              }
              
          }
      
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
    "\n\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n    <table cellspacing=\"0\" cellpadding=\"2\" border=\"0\" width=\"800\">\n      <tr>\n        <td class=\"rowElementTitle\">Folio</td>\n        <td class=\"rowElementBody\">\n            ".toCharArray();
    __oracle_jsp_text[2] = 
    "\n        </td>\n        <td class=\"rowElementTitle\">Entidad</td>\n        <td class=\"rowElementBody\">\n            ".toCharArray();
    __oracle_jsp_text[3] = 
    "\n        </td>\n      </tr>\n      <tr>\n        <td class=\"rowElementTitle\">Fecha de Captura</td>\n        <td class=\"rowElementBody\">\n            ".toCharArray();
    __oracle_jsp_text[4] = 
    "\n        </td>\n        <td class=\"rowElementTitle\">Fecha de Recepción</td>\n        <td class=\"rowElementBody\">\n            ".toCharArray();
    __oracle_jsp_text[5] = 
    "\n        </td>\n      </tr>\n      <tr>\n        <td class=\"rowElementTitle\">Fecha del Documento</td>\n        <td class=\"rowElementBody\">\n            ".toCharArray();
    __oracle_jsp_text[6] = 
    "\n        </td>\n        <td class=\"rowElementTitle\">Fecha de Caducidad</td>\n        <td class=\"rowElementBody\">\n            ".toCharArray();
    __oracle_jsp_text[7] = 
    "\n        </td>\n      </tr>\n      <tr>\n        <td class=\"rowElementBody\" colspan=\"4\" align=\"right\">\n        <div id=\"info_lab\"><a href=\"javascript:moreInfo();\">\n        [+] Ver más\n        </a></div>\n        </td>\n      </tr>\n      <tr>\n        <td class=\"rowElementBody\" colspan=\"4\">\n        <div id=\"mInfo\" style=\"visibility:hidden;position:absolute;\" name=\"mInfo\">\n        <table cellspacing=\"0\" cellpadding=\"2\" border=\"0\" width=\"800\">\n\t  <tr>\n\t    <td class=\"rowElementBody\" colspan=\"4\"><hr>\n\t  </tr>\n          <tr>\n            <td class=\"rowElementTitle\">Remitente</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[8] = 
    "\n            </td>\n            <td class=\"rowElementTitle\">Firmante</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[9] = 
    "\n            </td>\n          </tr>\n          <tr>\n            <td class=\"rowElementTitle\">Tipo de Documento</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[10] = 
    "\n            </td>\n            <td class=\"rowElementTitle\">Tramite</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[11] = 
    "\n            </td>\n          </tr>\n          <tr>\n            <td class=\"rowElementTitle\">Avance</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n            </td>\n            <td class=\"rowElementTitle\">Estatus</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[13] = 
    "\n            </td>\n          </tr>\n          <tr>\n            <td class=\"rowElementTitle\">Folio Externo</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[14] = 
    "\n            </td>\n            <td class=\"rowElementTitle\">Folio Intermedio</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[15] = 
    "\n            </td>\n          </tr>\n          <tr>\n            <td class=\"rowElementTitle\">Fecha de Evento</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[16] = 
    "\n            </td>\n            <td class=\"rowElementTitle\">Hora de Evento</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[17] = 
    "\n            </td>\n          </tr>\n          <tr>\n            <td class=\"rowElementTitle\">Lugar de Evento</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[18] = 
    "\n            </td>\n            <td class=\"rowElementTitle\">Prioridad</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[19] = 
    "\n            </td>\n          </tr>\n          <tr>\n            <td class=\"rowElementTitle\">Tipo de Asunto</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[20] = 
    "\n            </td>\n            <td class=\"rowElementTitle\">&nbsp;</td>\n            <td class=\"rowElementBody\">\n                &nbsp;\n            </td>\n          </tr>\n        </table>\n        </div>           \n        </td>\n      </tr>\n    </table>\n\t    \n".toCharArray();
    __oracle_jsp_text[21] = 
    "\n    <table cellspacing=\"0\" cellpadding=\"2\" border=\"0\" width=\"800\">\n      <tr>\n        <td class=\"rowElementTitle\">Folio</td>\n        <td class=\"rowElementBody\">\n            ".toCharArray();
    __oracle_jsp_text[22] = 
    "\n        </td>\n        <td class=\"rowElementTitle\">Entidad</td>\n        <td class=\"rowElementBody\">\n           ".toCharArray();
    __oracle_jsp_text[23] = 
    "\n        </td>\n      </tr>\n      <tr>\n        <td class=\"rowElementTitle\">Fecha de Captura</td>\n        <td class=\"rowElementBody\">\n            ".toCharArray();
    __oracle_jsp_text[24] = 
    "\n        </td>\n        <td class=\"rowElementTitle\">Fecha de Recepción</td>\n        <td class=\"rowElementBody\">\n            ".toCharArray();
    __oracle_jsp_text[25] = 
    "\n        </td>\n      </tr>\n      <tr>\n        <td class=\"rowElementTitle\">Fecha del Documento</td>\n        <td class=\"rowElementBody\">\n            ".toCharArray();
    __oracle_jsp_text[26] = 
    "\n        </td>\n        <td class=\"rowElementTitle\">Fecha de Caducidad</td>\n        <td class=\"rowElementBody\">\n            ".toCharArray();
    __oracle_jsp_text[27] = 
    "\n        </td>\n      </tr>\n      <tr>\n        <td class=\"rowElementBody\" colspan=\"4\" align=\"right\">\n        <div id=\"info_lab\"><a href=\"javascript:moreInfo();\">\n        [+] Ver más\n        </a></div>\n        </td>\n      </tr>\n      <tr>\n        <td class=\"rowElementBody\" colspan=\"4\">\n        <div id=\"mInfo\" style=\"visibility:hidden;position:absolute;\" name=\"mInfo\">\n        <table cellspacing=\"0\" cellpadding=\"2\" border=\"0\" width=\"800\">\n\t  <tr>\n\t    <td class=\"rowElementBody\" colspan=\"4\"><hr>\n\t  </tr>\n          <tr>\n            <td class=\"rowElementTitle\">Remitente</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[28] = 
    "\n            </td>\n            <td class=\"rowElementTitle\">Firmante</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[29] = 
    "\n            </td>\n          </tr>\n          <tr>\n            <td class=\"rowElementTitle\">Tipo de Documento</td>\n            <td class=\"rowElementBody\">\n               ".toCharArray();
    __oracle_jsp_text[30] = 
    "\n            </td>\n            <td class=\"rowElementTitle\">Tramite</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[31] = 
    "\n            </td>\n          </tr>\n          <tr>\n            <td class=\"rowElementTitle\">Avance</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[32] = 
    "\n            </td>\n            <td class=\"rowElementTitle\">Estatus</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[33] = 
    "\n            </td>\n          </tr>\n          <tr>\n            <td class=\"rowElementTitle\">Folio Externo</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[34] = 
    "\n            </td>\n            <td class=\"rowElementTitle\">Folio Intermedio</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[35] = 
    "\n            </td>\n          </tr>\n          <tr>\n            <td class=\"rowElementTitle\">Fecha de Evento</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[36] = 
    "\n            </td>\n            <td class=\"rowElementTitle\">Hora de Evento</td>\n            <td class=\"rowElementBody\">\n               ".toCharArray();
    __oracle_jsp_text[37] = 
    "\n            </td>\n          </tr>\n          <tr>\n            <td class=\"rowElementTitle\">Lugar de Evento</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[38] = 
    "\n            </td>\n            <td class=\"rowElementTitle\">Prioridad</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[39] = 
    "\n            </td>\n          </tr>\n          <tr>\n            <td class=\"rowElementTitle\">Tipo de Asunto</td>\n            <td class=\"rowElementBody\">\n                ".toCharArray();
    __oracle_jsp_text[40] = 
    "\n            </td>\n            <td class=\"rowElementTitle\">&nbsp;</td>\n            <td class=\"rowElementBody\">\n                &nbsp;\n            </td>\n          </tr>\n        </table>\n        </div>           \n        </td>\n      </tr>\n    </table>\n\t    \n".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\n<script>\nvar info_hidden = true;\n\nfunction moreInfo(){\n\t//alert(info_hidden);\n\tif (info_hidden){\n\t    info_hidden = false;\n\t    writeText(\"info_lab\", \"<a href='javascript:moreInfo();'>[-] Ocultar</a>\");\n\t    document.getElementById(\"mInfo\").style.visibility =\"visible\";\n\t    document.getElementById(\"mInfo\").style.position=\"fixed\";\n\t}else{\n\t    info_hidden = true;\n\t    writeText(\"info_lab\", \"<a href='javascript:moreInfo();'>[+] Ver más</a>\");\n\t    document.getElementById(\"mInfo\").style.visibility =\"hidden\";\n\t    document.getElementById(\"mInfo\").style.position=\"absolute\";\n\t}\n}\n\nfunction writeText(id, text)\n{\n\tif (document.getElementById)\n\t{\n\t\tobj = document.getElementById(id);\n\t\tobj.innerHTML = '';\n\t\tobj.innerHTML = text;\n\t}\n\telse if (document.all)\n\t{\n\t\tobj = document.all[id];\n\t\tobj.innerHTML = text;\n\t}\n\telse if (document.layers)\n\t{\n\t\tobj = document.layers[id];\n\t\ttext2 = \"<P CLASS='rowElementBody'>\" + text + \"</P>\";\n\t\tobj.document.open();\n\t\tobj.document.write(text2);\n\t\tobj.document.close();\n\t}\n}\n\n</script>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
