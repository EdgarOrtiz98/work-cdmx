package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.taglib.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.*;
import java.util.*;


public class _listUserURExt extends com.orionserver.http.OrionHttpJspPage {


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
    _listUserURExt page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      com.meve.sigma.beans.ListUserUR BList;
      synchronized (pageContext) {
        if ((BList = (com.meve.sigma.beans.ListUserUR) pageContext.getAttribute( "BList", PageContext.PAGE_SCOPE)) == null) {
          BList = (com.meve.sigma.beans.ListUserUR) new com.meve.sigma.beans.ListUserUR();
          pageContext.setAttribute( "BList", BList, PageContext.PAGE_SCOPE);
          out.write(__oracle_jsp_text[1]);
          OracleJspRuntime.__jspSetAllParams(request, (Object)BList, true);
          out.write(__oracle_jsp_text[2]);
          out.write(__oracle_jsp_text[3]);
          out.write(__oracle_jsp_text[4]);
          
          	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
          	String p = (request.getParameter("para")== null)?"":request.getParameter("para");
          	String ip = (request.getParameter("ipara")== null)?"":request.getParameter("ipara");
          	String strIdArea = (BList.getIdArea()== null)?"":BList.getIdArea();
          	String nombreTO = (BList.getTmpSendToRef()== null)?p:BList.getTmpSendToRef();
          	String strIdsTO = (BList.getIdsTO()== null)?ip:BList.getIdsTO();
          
          
          	String strIdAreaUs = (request.getParameter("idAreaUs")== null)?"":request.getParameter("idAreaUs");
          
          	String strUsuarios[][] = new String[0][0];
          	if(strIdArea.length() != 0 && strIdArea != null){
          		strUsuarios = ActualizaUsuario.getRemitenteXEntidad(strIdArea);  
          	}
          	
          	Vector lista = Utilerias.getNombres1(nombreTO.trim());
          	Vector listaIDSPara = Utilerias.getNombres(strIdsTO.trim());
          
          
          out.write(__oracle_jsp_text[5]);
          out.print(Utilerias.codificaPostHTML("listUserURExt.jsp?para=" + Utilerias.codificaPostHTML(nombreTO) + "&ipara=" + strIdsTO + "&idAreaUs=" + strIdAreaUs));
          out.write(__oracle_jsp_text[6]);
          out.print(Utilerias.codificaPostHTML("listUserURExt.jsp?para=" + Utilerias.codificaPostHTML(nombreTO) + "&ipara=" + strIdsTO + "&idAreaUs=" + strIdAreaUs));
          out.write(__oracle_jsp_text[7]);
          out.print(nombreTO);
          out.write(__oracle_jsp_text[8]);
          out.print(strIdsTO);
          out.write(__oracle_jsp_text[9]);
          out.print( strIdAreaUs );
          out.write(__oracle_jsp_text[10]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_1.setParent(null);
            __jsp_taghandler_1.setData(ComboData.getEntidadComboXArea(BUsuario.getIdArea()));
            __jsp_taghandler_1.setName("idArea");
            __jsp_taghandler_1.setSize(1);
            __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strIdArea));
            __jsp_taghandler_1.setClassHtml("blue700a");
            __jsp_taghandler_1.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='reloadListUserURE()'");
            __jsp_taghandler_1.setTextoNoSeleccion("---------------------------------------------- Selecciona una Entidad ----------------------------------------------");
            __jsp_taghandler_1.setValorNoSeleccion("-1");
            __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
            if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
          }
          out.write(__oracle_jsp_text[11]);
          out.print(strIdAreaUs);
          out.write(__oracle_jsp_text[12]);
          for(int i=0;i<strUsuarios.length;i++){
          out.write(__oracle_jsp_text[13]);
          out.print(strUsuarios[i][0]);
          out.write(__oracle_jsp_text[14]);
          out.print(strUsuarios[i][1]);
          out.write(__oracle_jsp_text[15]);
          out.print(ActualizaEntidad.getNombreEntidad(strIdArea));
          out.write(__oracle_jsp_text[16]);
          }
          out.write(__oracle_jsp_text[17]);
          if(strUsuarios.length!=0){
          out.write(__oracle_jsp_text[18]);
          }else{
          out.write(__oracle_jsp_text[19]);
          }
          out.write(__oracle_jsp_text[20]);
          for(int t=0;t<lista.size();t++){
          out.write(__oracle_jsp_text[21]);
          out.print(listaIDSPara.elementAt(t));
          out.write(__oracle_jsp_text[22]);
          out.print(lista.elementAt(t));
          out.write(__oracle_jsp_text[23]);
          }
          out.write(__oracle_jsp_text[24]);
        }
      }

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
  private static final char __oracle_jsp_text[][]=new char[25][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML> \n<HEAD>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/link.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\" src=\"../js/link.js\"></script>\n<script type=\"text/javascript\">\n<!--\n\tfunction verNuevaEntidad(idArea){\n\t\tlocation.assign('FrameEntidad.jsp?id_us='+idArea+'&porcedencia=receptor&b=2&retURI=".toCharArray();
    __oracle_jsp_text[6] = 
    "');\n\t}\n\n\tfunction cambioVista(){\n\t\tlocation.assign('FrameRemitente.jsp?num=2&porcedencia=receptor&retURI=".toCharArray();
    __oracle_jsp_text[7] = 
    "');\n\t}\n//-->\n</script>\n<TITLE>Lista de Destinatarios Externos</TITLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onunload=\"opener.hay_hija=true\"\n\tonClick=\"opener.resetTimer();\"\n\tonKeyPress=\"opener.resetTimer();\">\n<FORM name=\"listUserUAE\" action=\"listUserURExt.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<input name=\"tmpSendToRef\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\">\n<input name=\"tmpCopyToRef\" type=\"hidden\" value=\"\">\n<input name=\"idsTO\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\">\n<input name=\"idsCC\" type=\"hidden\" value=\"\">\n<INPUT name=\"idAreaUs\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\">\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"1\">&nbsp;</td>   \n\t\t<td width=\"444\"><img width=\"1\" height=\"1\"\n\t\t\tsrc=\"../Imagenes/ecblank.gif\" border=\"0\" alt=\"\"></td>\n\t\t<td width=\"88\"><img width=\"1\" height=\"1\" src=\"../Imagenes/ecblank.gif\"\n\t\t\tborder=\"0\" alt=\"\"></td>\n\t\t<td width=\"333\"><IMG width=\"1\" height=\"1\"\n\t\t\tsrc=\"../Imagenes/ecblank.gif\" border=\"0\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td class=\"etiquetas\" width=\"1\"></td>\n\t\t<td colspan=\"3\">".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t</td>\n\t</tr>\n</table>\n</DIV>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"1\">&nbsp;</td>   \n\t\t<td width=\"444\"><img width=\"1\" height=\"1\"\n\t\t\tsrc=\"../Imagenes/ecblank.gif\" border=\"0\" alt=\"\"></td>\n\t\t<td width=\"88\"><img width=\"1\" height=\"1\" src=\"../Imagenes/ecblank.gif\"\n\t\t\tborder=\"0\" alt=\"\"></td>\n\t\t<td width=\"333\"><IMG width=\"1\" height=\"1\"\n\t\t\tsrc=\"../Imagenes/ecblank.gif\" border=\"0\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td class=\"etiquetas\" width=\"1\"></td>\n\t\t<td width=\"444\"><img width=\"1\" height=\"1\" src=\"../Imagenes/ecblank.gif\"\n\t\t\tborder=\"0\" alt=\"\"></td>\n\t\t<td width=\"88\"><img width=\"1\" height=\"1\" src=\"../Imagenes/ecblank.gif\"\n\t\t\tborder=\"0\" alt=\"\"></td>\n\t\t<td width=\"333\">\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<input type=\"button\" onclick=\"verNuevaEntidad(".toCharArray();
    __oracle_jsp_text[12] = 
    ")\" value=\"Otra Entidad\" class=\"blue100a\">\n\t\t\t&nbsp;&nbsp;<input type=\"button\" onclick=\"cambioVista()\" value=\"Otro Remitente\" class=\"blue100a\" >\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"1\">&nbsp;</td>\n\t\t<td width=\"444\"><img width=\"1\" height=\"1\"\n\t\t\tsrc=\"../Imagenes/ecblank.gif\" border=\"0\" alt=\"\"></td>\n\t\t<td width=\"88\"><img width=\"1\" height=\"1\" src=\"../Imagenes/ecblank.gif\"\n\t\t\tborder=\"0\" alt=\"\"></td>\n\t\t<td width=\"333\"><img width=\"1\" height=\"1\" src=\"../Imagenes/ecblank.gif\"\n\t\t\tborder=\"0\" alt=\"\"></td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td rowspan=\"3\" colspan=\"2\" align=\"left\">\n\t\t \t<SELECT NAME=\"EntryList\" size=\"20\" multiple=\"multiple\" class=\"blue400a\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\">".toCharArray();
    __oracle_jsp_text[15] = 
    " - ".toCharArray();
    __oracle_jsp_text[16] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t</SELECT><BR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t<B>Buscar:</B> &nbsp;&nbsp;&nbsp;<IMG width=\"1\" height=\"1\"\n\t\t\t\tsrc=\"../Imagenes/ecblank.gif\" border=\"0\" alt=\"\"><INPUT type=\"text\"\n\t\t\t\tname=\"buscaDest\" class=\"blue300\"\n\t\t\t\tonkeyup=\"buscaElementosLista(document.listUserUAE.EntryList, document.listUserUAE.buscaDest)\" maxlength=\"199\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t<B>Buscar:</B> &nbsp;&nbsp;&nbsp;<IMG width=\"1\" height=\"1\"\n\t\t\t\tsrc=\"../Imagenes/ecblank.gif\" border=\"0\" alt=\"\"><INPUT type=\"text\"\n\t\t\t\tname=\"buscaDest\" class=\"blue300\" disabled=\"disabled\"\n\t\t\t\tonkeyup=\"buscaElementosLista(document.listUserUAE.EntryList, document.listUserUAE.buscaDest)\" maxlength=\"199\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t</td>\n\t\t<td align=\"center\" width=\"88\"><input type=\"button\" \n\t\t\tonclick=\"addSelected(document.listUserUAE.listTO, document.listUserUAE.EntryList, document.listUserUAE.listTO);\n\t\t\t\t\ttmpSendToRef.value = selectToStringAndID(document.listUserUAE.listTO);\n\t\t\t\t\tidsTO.value = selectToIdString(document.listUserUAE.listTO)\"\n\t\t\tvalue=\" Para &gt; \" class=\"blue50\"><BR>\n\t\t\t<BR>\n\t\t\t<INPUT type=\"button\"\n\t\t\t\tonclick=\"quitaElementosListTOE(document.listUserUAE.listTO);\n\t\t\t\t\ttmpSendToRef.value = selectToStringAndID(document.listUserUAE.listTO);\n\t\t\t\t\tidsTO.value = selectToIdString(document.listUserUAE.listTO)\"\n\t\t\t\tvalue=\"&lt;&lt; \" class=\"blue50\" name=\"quitaTO\"><BR><BR>\n\t\t\t</td>\n\t\t<td align=\"center\" width=\"333\">\n\t\t\t<select name=\"listTO\" size=\"6\" class=\"blue300a\" multiple=\"multiple\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\">".toCharArray();
    __oracle_jsp_text[23] = 
    "</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t</select>\n\t\t<BR>\n\t\t\t<BR>\n\t\t\t<BR>\n\t\t\t<BR>\n\t\t\t<BR>\n\t\t\t</td>\n\t\t\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td align=\"center\" height=\"115\" width=\"88\"><BR>\n\t\t\t<BR>\n\t\t\t<BR>\n\t\t\t<BR>\n\t\t\t<!--<input type=\"button\" \n\t\t\tonclick=\"RemoveSelected(document.listUserUA.listCC);\"\n\t\t\tvalue=\"&lt;\" class=\"blue50\"> -->\n\t\t\t</td>\n\t\t<td align=\"center\" height=\"115\" width=\"333\">\n\t\t\t</td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td align=\"center\" width=\"88\" height=\"25\"></td>\n\t\t<td align=\"center\" width=\"333\" height=\"25\">\n\t\t<div align=\"center\"><input type=\"button\" onclick=\"RemoveAllClickE()\"\n\t\t\tvalue=\"Eliminar Todo\" class=\"blue100\"></div>\n\t\t</td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t\t<td colspan=\"2\" align=\"center\" height=\"9\"></td>\n\t\t\t<td width=\"88\" height=\"9\"><img width=\"1\" height=\"1\" src=\"../Imagenes/ecblank.gif\"\n\t\t\tborder=\"0\" alt=\"\"></td>\n\t\t<td width=\"333\" height=\"9\"></td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t\t<td colspan=\"4\" height=\"43\">\n\t\t\t<div align=\"center\">\n\t\t\t<hr width=\"100%\" size=\"2\" align=\"center\">\n\t\t\t</div>\n\t\t\t<div align=\"right\"><input type=\"button\" onclick=\"aceptarListExt()\"\n\t\t\t\tvalue=\"OK\" name=\"OK\" class=\"blue100\"> <input type=\"button\"\n\t\t\t\tonclick=\"Cancelar();\"\n\t\t\t\tvalue=\" Cancel\" class=\"blue100\"></div>\n\t\t\t</td>\n\t\t</tr>\n</table>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
