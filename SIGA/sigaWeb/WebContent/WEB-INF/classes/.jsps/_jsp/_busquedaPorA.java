package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.search.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.*;


public class _busquedaPorA extends com.orionserver.http.OrionHttpJspPage {


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
    _busquedaPorA page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      com.meve.sigma.beans.BeanPorAsunto BPorAsunto;
      synchronized (pageContext) {
        if ((BPorAsunto = (com.meve.sigma.beans.BeanPorAsunto) pageContext.getAttribute( "BPorAsunto", PageContext.PAGE_SCOPE)) == null) {
          BPorAsunto = (com.meve.sigma.beans.BeanPorAsunto) new com.meve.sigma.beans.BeanPorAsunto();
          pageContext.setAttribute( "BPorAsunto", BPorAsunto, PageContext.PAGE_SCOPE);
          out.write(__oracle_jsp_text[0]);
          OracleJspRuntime.__jspSetAllParams(request, (Object)BPorAsunto, true);
          out.write(__oracle_jsp_text[1]);
        }
      }
      out.write(__oracle_jsp_text[2]);
      {
        String __url=OracleJspRuntime.toStr("header.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      
      	String strResultado[][] = ActualizaBuscar.buscarPorAsunto(BPorAsunto.getBuscarRecepcion(), 
      								BPorAsunto.getBuscarArea(), BPorAsunto.getBuscarAsunto(), 
      								BPorAsunto.getBuscarTDocto(), BPorAsunto.getBuscarFechaGen(), 
      								BPorAsunto.getBuscarFechaVen());
      
      out.write(__oracle_jsp_text[5]);
      out.print(strResultado.length);
      out.write(__oracle_jsp_text[6]);
       if(strResultado.length == 0){ 
      out.write(__oracle_jsp_text[7]);
       }else{ 
      out.write(__oracle_jsp_text[8]);
       for(int i=0;i<strResultado.length;i++){ 
      out.write(__oracle_jsp_text[9]);
      out.print(strResultado[i][4]);
      out.write(__oracle_jsp_text[10]);
      out.print(strResultado[i][0]);
      out.write(__oracle_jsp_text[11]);
       if(strResultado[i][5].equals("0")){ 
      out.write(__oracle_jsp_text[12]);
      out.print(ActualizaRemitente.getNombreRemitente(strResultado[i][1]));
      out.write(__oracle_jsp_text[13]);
       }else if(strResultado[i][5].equals("1")){ 
      out.write(__oracle_jsp_text[14]);
      out.print(ActualizaUsuario.NombreUsuario(strResultado[i][1]));
      out.write(__oracle_jsp_text[15]);
       } 
      out.write(__oracle_jsp_text[16]);
      out.print(ActualizaUsuario.NombreUsuario(strResultado[i][6]));
      out.write(__oracle_jsp_text[17]);
      out.print(strResultado[i][2]);
      out.write(__oracle_jsp_text[18]);
      out.print(Utilerias.formatearFechas(strResultado[i][3]));
      out.write(__oracle_jsp_text[19]);
       } 
      out.write(__oracle_jsp_text[20]);
       } 
      out.write(__oracle_jsp_text[21]);

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
  private static final char __oracle_jsp_text[][]=new char[22][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<TITLE>Busqueda por Asunto</TITLE>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD width=\"283\"><INPUT type=\"button\" class=\"blue200\"\n\t\t\t\tvalue=\"Realizar Otra Busqueda\"\n\t\t\t\tonclick=\"location.assign('busquedaPorAsunto.jsp');\"></TD>\n\t\t\t<td width=\"133\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</TR>\n\t</TBODY>\n</table>\n</DIV>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD width=\"283\"><b><FONT size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tResultados encontrados en SigmaDoc </FONT></b></TD>\n\t\t\t<td width=\"133\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<td width=\"863\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</TR>\n\t</TBODY>\n</table>\n</DIV>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD width=\"283\"><b><FONT size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tNumero de Resultados: ".toCharArray();
    __oracle_jsp_text[6] = 
    "</FONT></b></TD>\n\t\t<td width=\"133\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" width=\"863\">\n<TBODY>\n\t<TR bgcolor=\"#00204f\">\n\t\t<TD width=\"172\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Folio</FONT></b>\n\t\t\t</CENTER>\n\t\t</TD>\n\t\t<td width=\"172\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Solicitante</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"173\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Destinatario</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"173\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Titulo</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"173\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Fecha Recepción</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n<br>\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD width=\"383\"><b><FONT size=\"2\" color=\"red\" face=\"Arial\">\n\t\t\tNo se encontraron Documentos</FONT></b></TD>\n\t\t<td width=\"33\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n<DIV class=documentBody id=Body>\n<DIV align=\"center\">\n<table border=\"0\" width=\"863\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t<TR>\n\t\t<TD width=\"172\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t<a href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[10] = 
    "\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\t\t</a>\n\t\t\t\t</FONT>\n\t\t\t</CENTER>\n\t\t</TD>\n\t\t<td width=\"172\">\n\t\t\t<CENTER>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t\t</FONT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t\t</FONT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"173\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t</FONT>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"173\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[18] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"173\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t\t</FONT>\n\t\t\t</CENTER>\n\t\t</td>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n</TBODY>\n</table>\n</DIV>\n</DIV>\n<BR>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n".toCharArray();
    __oracle_jsp_text[21] = 
    "\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
