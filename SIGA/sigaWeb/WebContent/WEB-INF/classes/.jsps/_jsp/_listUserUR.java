package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.taglib.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.*;
import java.util.*;


public class _listUserUR extends com.orionserver.http.OrionHttpJspPage {


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
    _listUserUR page = this;
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
          
          	String p = (request.getParameter("para")== null)?"":request.getParameter("para");
          	String c = (request.getParameter("cc")== null)?"":request.getParameter("cc");
          	String ip = (request.getParameter("ipara")== null)?"":request.getParameter("ipara");
          	String ic = (request.getParameter("icc")== null)?"":request.getParameter("icc");
          	String tipoFolio= (request.getParameter("tipoFolio")== null)?"":request.getParameter("tipoFolio");
          	String idAreaGen= (request.getParameter("idAreaGen")== null)?"":request.getParameter("idAreaGen");
          	String strIdArea = (BList.getIdArea()== null)?"":BList.getIdArea();
          	String nombreTO = (BList.getTmpSendToRef()== null)?p:BList.getTmpSendToRef();
          	String nombreCC = (BList.getTmpCopyToRef()== null)?c:BList.getTmpCopyToRef();
          	String strIdsTO = (BList.getIdsTO()== null)?ip:BList.getIdsTO();
          	String strIdsCC = (BList.getIdsCC()== null)?ic:BList.getIdsCC();
          	String strUsuarios[][] = new String[0][0];
          	if(strIdArea.length() != 0 && strIdArea != null){
          		strUsuarios = ActualizaUsuario.getUsuarioAreaAtencion(strIdArea);
          	}
          	Vector lista = Utilerias.getNombres1(nombreTO.trim());
          	Vector listaCC = Utilerias.getNombres1(nombreCC.trim());
          	Vector listaIPara = Utilerias.getNombres(strIdsTO.trim());
          	Vector listaICC = Utilerias.getNombres(strIdsCC.trim());
          
          out.write(__oracle_jsp_text[5]);
          out.print(nombreTO);
          out.write(__oracle_jsp_text[6]);
          out.print(nombreCC);
          out.write(__oracle_jsp_text[7]);
          out.print(strIdsTO);
          out.write(__oracle_jsp_text[8]);
          out.print(strIdsCC);
          out.write(__oracle_jsp_text[9]);
          out.print(tipoFolio );
          out.write(__oracle_jsp_text[10]);
          out.print(idAreaGen );
          out.write(__oracle_jsp_text[11]);
          
          				String strArea[][]=ComboData.getAreaComboListDes();
          				for(int i=0;i<strArea.length;i++){
          				
          out.write(__oracle_jsp_text[12]);
          if(strArea[i][2].equals("0")){
          out.write(__oracle_jsp_text[13]);
          out.print(strArea[i][0]);
          out.write(__oracle_jsp_text[14]);
          out.print((strIdArea.equals(strArea[i][0]))?"selected":"");
          out.write(__oracle_jsp_text[15]);
          out.print(strArea[i][1]);
          out.write(__oracle_jsp_text[16]);
          }else{
          out.write(__oracle_jsp_text[17]);
          out.print(strArea[i][0]);
          out.write(__oracle_jsp_text[18]);
          out.print((strIdArea.equals(strArea[i][0]))?"selected":"");
          out.write(__oracle_jsp_text[19]);
          out.print(strArea[i][1]);
          out.write(__oracle_jsp_text[20]);
          }
          out.write(__oracle_jsp_text[21]);
          }
          out.write(__oracle_jsp_text[22]);
          for(int i=0;i<strUsuarios.length;i++){
          out.write(__oracle_jsp_text[23]);
          out.print(strUsuarios[i][0]);
          out.write(__oracle_jsp_text[24]);
          out.print(strUsuarios[i][4]);
          out.write(__oracle_jsp_text[25]);
          out.print(strUsuarios[i][1]);
          out.write(__oracle_jsp_text[26]);
          }
          out.write(__oracle_jsp_text[27]);
          if(strUsuarios.length!=0){
          out.write(__oracle_jsp_text[28]);
          }else{
          out.write(__oracle_jsp_text[29]);
          }
          out.write(__oracle_jsp_text[30]);
          out.print(strIdArea);
          out.write(__oracle_jsp_text[31]);
          for(int t=0;t<lista.size();t++){
          out.write(__oracle_jsp_text[32]);
          out.print(listaIPara.elementAt(t));
          out.write(__oracle_jsp_text[33]);
          out.print(lista.elementAt(t));
          out.write(__oracle_jsp_text[34]);
          }
          out.write(__oracle_jsp_text[35]);
          for(int t=0;t<listaCC.size();t++){
          out.write(__oracle_jsp_text[36]);
          out.print(listaICC.elementAt(t));
          out.write(__oracle_jsp_text[37]);
          out.print(listaCC.elementAt(t));
          out.write(__oracle_jsp_text[38]);
          }
          out.write(__oracle_jsp_text[39]);
          out.print(idAreaGen);
          out.write(__oracle_jsp_text[40]);
          out.print(tipoFolio);
          out.write(__oracle_jsp_text[41]);
        }
      }
      out.write(__oracle_jsp_text[42]);

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
  private static final char __oracle_jsp_text[][]=new char[43][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/link.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\"> \n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\" src=\"../js/ajax.js\"></script>\n<script type=\"text/javascript\" src=\"../js/link.js\"></script>\n<TITLE>Lista de Destinatarios</TITLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onunload=\"opener.hay_hija=true\"\n\tonClick=\"opener.resetTimer();\"\n\tonKeyPress=\"opener.resetTimer();\">\n<FORM name=\"listUserUA\" action=\"listUserUR.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<input name=\"tmpSendToRef\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\">\n<input name=\"tmpCopyToRef\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\">\n<input name=\"idsTO\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\">\n<input name=\"idsCC\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\">\n<input name=\"tipoFolio\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\">\n<input name=\"idAreaGen\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\">\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr valign=\"top\">\n\t\t<td width=\"1\">&nbsp;</td>\n\t\t<td width=\"444\"><img width=\"1\" height=\"1\"\n\t\t\tsrc=\"../Imagenes/ecblank.gif\" border=\"0\" alt=\"\"></td>\n\t\t<td width=\"88\"><img width=\"1\" height=\"1\" src=\"../Imagenes/ecblank.gif\"\n\t\t\tborder=\"0\" alt=\"\"></td>\n\t\t<td width=\"333\"><IMG width=\"1\" height=\"1\"\n\t\t\tsrc=\"../Imagenes/ecblank.gif\" border=\"0\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td class=\"etiquetas\" width=\"1\"></td>\n\t\t<td colspan=\"3\">\n\t\t\t<SELECT  name=\"idArea\" class=\"blue700a\" onkeypress=\"buscar_op1(this)\" \n\t\t\t\t\tonblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\" \n\t\t\t\t\tonchange=\"reloadListUserUR();\">\n\t\t\t\t<OPTION value=\"-1\">---------------------------------------------- Selecciona una Unidad Administrativa ----------------------------------------------</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" ".toCharArray();
    __oracle_jsp_text[15] = 
    ">".toCharArray();
    __oracle_jsp_text[16] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" style=\"color:red;\" ".toCharArray();
    __oracle_jsp_text[19] = 
    ">".toCharArray();
    __oracle_jsp_text[20] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t</SELECT>\n\t\t</td>\n\t</tr>\n</table>\n</DIV>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"1\">&nbsp;</td>\n\t\t<td width=\"444\"><img width=\"1\" height=\"1\"\n\t\t\tsrc=\"../Imagenes/ecblank.gif\" border=\"0\" alt=\"\"></td>\n\t\t<td width=\"88\"><img width=\"1\" height=\"1\" src=\"../Imagenes/ecblank.gif\"\n\t\t\tborder=\"0\" alt=\"\"></td>\n\t\t\t<td width=\"333\" align=\"left\"><B></B></td>\n\t\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td rowspan=\"3\" colspan=\"2\" align=\"left\" valign=\"top\">\n\t\t\t<SELECT NAME=\"EntryList\" size=\"20\" multiple=\"multiple\" class=\"blue400a\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[24] = 
    "\">".toCharArray();
    __oracle_jsp_text[25] = 
    "/".toCharArray();
    __oracle_jsp_text[26] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t</SELECT><BR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t<B>Buscar:</B>&nbsp;&nbsp;&nbsp;<IMG width=\"1\" height=\"1\"\n\t\t\t\tsrc=\"../Imagenes/ecblank.gif\" border=\"0\" alt=\"\"><INPUT type=\"text\"\n\t\t\t\tname=\"buscaDest\" class=\"blue300\"\n\t\t\t\tonkeyup=\"buscaElementosLista(document.listUserUA.EntryList, document.listUserUA.buscaDest)\" maxlength=\"199\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t<B>Buscar:</B>&nbsp;&nbsp;&nbsp;<IMG width=\"1\" height=\"1\"\n\t\t\t\tsrc=\"../Imagenes/ecblank.gif\" border=\"0\" alt=\"\"><INPUT type=\"text\"\n\t\t\t\tname=\"buscaDest\" class=\"blue300\" disabled=\"disabled\"\n\t\t\t\tonkeyup=\"buscaElementosLista(document.listUserUA.EntryList, document.listUserUA.buscaDest)\" maxlength=\"199\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t</td>\n\t\t<td align=\"center\" width=\"88\"><input type=\"button\" \n\t\t\tonclick=\"addSelected(document.listUserUA.listTO, document.listUserUA.EntryList, document.listUserUA.listCC);\n\t\t\t\t\ttmpSendToRef.value = selectToStringAndID(document.listUserUA.listTO,'".toCharArray();
    __oracle_jsp_text[31] = 
    "');\n\t\t\t\t\tidsTO.value = selectToIdString(document.listUserUA.listTO)\"\n\t\t\tvalue=\" Para &gt; \" class=\"blue50\"><BR>\n\t\t\t<BR>\n\t\t\t<INPUT type=\"button\"\n\t\t\t\tonclick=\"quitaElementosListTO(document.listUserUA.listTO);\n\t\t\t\t\ttmpSendToRef.value = selectToStringAndID(document.listUserUA.listTO);\n\t\t\t\t\tidsTO.value = selectToIdString(document.listUserUA.listTO)\"\n\t\t\t\tvalue=\"&lt;&lt; \" class=\"blue50\" name=\"quitaTO\"><BR><BR>\n\t\t</td>\n\t\t<td align=\"center\" width=\"333\">\n\t\t\t<select name=\"listTO\" size=\"6\" class=\"blue300a\" multiple=\"multiple\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[33] = 
    "\">".toCharArray();
    __oracle_jsp_text[34] = 
    "</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t</select>\n\t\t<BR>\n\t\t\t<BR>\n\t\t\t<BR>\n\t\t\t<BR>\n\t\t\t<BR>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td align=\"center\" height=\"115\" width=\"88\"><input type=\"button\" \n\t\t\tonclick=\"addSelected(document.listUserUA.listCC, document.listUserUA.EntryList, document.listUserUA.listTO);\n\t\t\t\t\ttmpCopyToRef.value = selectToStringAndID(document.listUserUA.listCC);\n\t\t\t\t\tidsCC.value = selectToIdString(document.listUserUA.listCC)\"\n\t\t\tvalue=\" Ccp &gt; \" class=\"blue50\"><BR>\n\t\t\t<BR>\n\t\t\t<INPUT type=\"button\"\n\t\t\t\tonclick=\"quitaElementosListCC(document.listUserUA.listCC);\n\t\t\t\t\ttmpCopyToRef.value = selectToStringAndID(document.listUserUA.listCC);\n\t\t\t\t\tidsCC.value = selectToIdString(document.listUserUA.listCC)\"\n\t\t\t\tvalue=\"&lt;&lt; \" class=\"blue50\" name=\"quitaCC\"><BR>\n\t\t\t<BR>\n\t\t</td>\n\t\t<td align=\"center\" height=\"115\" width=\"333\">\n\t\t\t<select name=\"listCC\" size=\"6\" class=\"blue300a\" multiple=\"multiple\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[37] = 
    "\">".toCharArray();
    __oracle_jsp_text[38] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t</select>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td align=\"center\" width=\"88\" height=\"25\"></td>\n\t\t<td align=\"center\" width=\"333\" height=\"25\">\n\t\t<div align=\"center\"><input type=\"button\" onclick=\"RemoveAllClick()\"\n\t\t\tvalue=\"Eliminar Todo\" class=\"blue100\"></div>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t\t<td colspan=\"2\" align=\"center\" height=\"9\"></td>\n\t\t\t<td width=\"88\" height=\"9\"><img width=\"1\" height=\"1\" src=\"../Imagenes/ecblank.gif\"\n\t\t\tborder=\"0\" alt=\"\"></td>\n\t\t<td width=\"333\" height=\"9\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t\t<td colspan=\"4\" height=\"43\">\n\t\t\t<div align=\"center\">\n\t\t\t<hr width=\"100%\" size=\"2\" align=\"center\">\n\t\t\t</div>\n\t\t\t<div align=\"right\"><input type=\"button\" onclick=\"compruebaAreaDestinatarios('".toCharArray();
    __oracle_jsp_text[40] = 
    "',idsTO.value,idsCC.value,'".toCharArray();
    __oracle_jsp_text[41] = 
    "');return false;\"\n\t\t\t\tvalue=\"Aceptar\" name=\"OK\" class=\"blue100\"> <input type=\"button\"\n\t\t\t\tonclick=\"Cancelar()\"\n\t\t\t\tvalue=\" Cancelar\" class=\"blue100\"></div>\n\t\t\t</td>\n\t\t</tr>\n</table>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    __oracle_jsp_text[42] = 
    "\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
