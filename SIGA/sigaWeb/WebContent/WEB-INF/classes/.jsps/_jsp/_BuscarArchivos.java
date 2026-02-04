package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import java.util.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.beans.search.*;
import com.meve.sigma.servlet.SearchArchiveByContent;
import com.meve.sigma.util.*;


public class _BuscarArchivos extends com.orionserver.http.OrionHttpJspPage {


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
    _BuscarArchivos page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("header.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[1]);
      com.meve.sigma.beans.search.BuscarCampoIns BeanBuscar;
      synchronized (pageContext) {
        if ((BeanBuscar = (com.meve.sigma.beans.search.BuscarCampoIns) pageContext.getAttribute( "BeanBuscar", PageContext.PAGE_SCOPE)) == null) {
          BeanBuscar = (com.meve.sigma.beans.search.BuscarCampoIns) new com.meve.sigma.beans.search.BuscarCampoIns();
          pageContext.setAttribute( "BeanBuscar", BeanBuscar, PageContext.PAGE_SCOPE);
          out.write(__oracle_jsp_text[2]);
          OracleJspRuntime.__jspSetAllParams(request, (Object)BeanBuscar, true);
          out.write(__oracle_jsp_text[3]);
        }
      }
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      
      	if(BeanBuscar.getbuscaEstatus() == null || BeanBuscar.getbuscaEstatus().equals("")){
      		BeanBuscar = (BuscarCampoIns)session.getAttribute("UsuarioBuscaBeanIns");
      		////System.out.println("Entró-"+BeanBuscar);
      	}
      
      	String[] strBusqueda = null;
      	String[] strIdAsunto = null;
      	StringTokenizer tokens;
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      
      	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
      	
      	String strAsunto	=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
      	String contentUri = application.getInitParameter("content");
      	String passContent = application.getInitParameter("user");
      	String userContent = application.getInitParameter("passwd");
      	String pathContent = application.getInitParameter("path");
      	String strContent	 = request.getParameter("buscaContenido");
      
      	String strCreador1 = 	BUsuario.getIdUsuario();
      	String strAreaUs	=	BUsuario.getIdArea();
      
      	//System.out.println(  " --- " + strCreador1 + " "  +  strAreaUs );
      
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+strTmp+"?id_asunto="+strIdAsunto);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
      	}
      	
      
      out.write(__oracle_jsp_text[6]);
      out.print(strCreador1);
      out.write(__oracle_jsp_text[7]);
      out.print(strAreaUs);
      out.write(__oracle_jsp_text[8]);
       if (strContent != null){ 
      out.write(__oracle_jsp_text[9]);
      
      	strBusqueda = SearchArchiveByContent.searchByContent(strContent, strCreador1, strAreaUs, contentUri, passContent, userContent, pathContent);
      
      	if ( strBusqueda.length > 0 || strBusqueda != null ){
      		////System.out.println("busqueda ....." + strBusqueda.length);
      
      		for (int i = 0; i < strBusqueda.length; i++){
      
      				tokens=new StringTokenizer(strBusqueda[i], "|");
      				int nDatos=tokens.countTokens();
      				String[] datos=new String[nDatos];		
      				int j=0;
      				
      				while(tokens.hasMoreTokens()){
                  		String str=tokens.nextToken();
                 		 	datos[j]=str;
                  		//System.out.println(datos[j]);
                  		j++;
              		}
      				
      				strIdAsunto = SearchArchiveByContent.searchIdFolioAsunto(datos[0]);
      				////System.out.println("Datos procesados ....  jsp " + strIdAsunto.length);
      
      				for (int x = 0; x < datos.length; x++){
      
      					////System.out.println("Datos procesados .... " + datos[x]);
      
      				}
      
      out.write(__oracle_jsp_text[10]);
      out.print( strIdAsunto[0] );
      out.write(__oracle_jsp_text[11]);
      out.print( Utilerias.codificaPostHTML(strTmp+"?buscaContenido="+strContent) );
      out.write(__oracle_jsp_text[12]);
      out.print(strIdAsunto[1] );
      out.write(__oracle_jsp_text[13]);
      out.print(datos[0] );
      out.write(__oracle_jsp_text[14]);
      out.print(datos[1] );
      out.write(__oracle_jsp_text[15]);
      out.print(datos[2] );
      out.write(__oracle_jsp_text[16]);
      
      		}}
      		if ( strBusqueda.length == 0 || strBusqueda == null ) {
      
      out.write(__oracle_jsp_text[17]);
      }}
      out.write(__oracle_jsp_text[18]);

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
  private static final char __oracle_jsp_text[][]=new char[19][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n\tfunction BurcarArchivos(){\n\n\t\tvar form = document.buscarArchivo;\n\n\t\tif ( form.buscaContenido.value == \"\" ){\n\t\t\talert(\"Introduzca un criterio de busqueda\");\n\t\t}else\n\t\t\tform.submit();\n\t}\n\n\tfunction regresarBuscar(){ \n\t\tlocation.assign('BuscarArchivos.jsp');\n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>BuscarArchivos.jsp</TITLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM method=\"post\" action=\"BuscarArchivos.jsp\" name=\"buscarArchivo\">\n<INPUT name=\"usuarioSiga\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\" type=\"hidden\">\n<INPUT name=\"areaSiga\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\" type=\"hidden\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TBODY>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"208\"><input type=\"button\" onclick=\"regresarBuscar()\"\n\t\t\t\tvalue=\"Limpiar Pantalla\" class=\"blue200\">&nbsp;</td>\n\t\t\t<td width=\"208\"><input type=\"button\" onclick=\"BurcarArchivos()\" \n\t\t\t\tvalue=\"Buscar\" class=\"blue100\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\" align=\"right\"></td>\n\t\t</tr>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TBODY>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"393\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">B&uacute;squeda de archivos por contenido</font></b></td>\n\t\t\t<td width=\"23\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</tr>\n\t</TBODY>\n</table>\n</DIV>\n<BR>\n<DIV class=documentBody id=Body>\n<DIV align=\"center\">\n\t<TABLE>\n\t\t<TR>\n\t\t<TD width=\"163\" height=\"34\">\n\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">Contenido:</font><BR>\n\t\t</TD>\t\n\t\t<TD width=\"700\" height=\"34\">\n\t\t\t<input name=\"buscaContenido\" onkeydown=\"\" value=\"\" class=\"blue500\" maxlength=\"199\"> \n\t\t</TD>\n\t\t</TR>\n\t</TABLE>\n\t<BR>\n\t<BR>\n".toCharArray();
    __oracle_jsp_text[9] = 
    "  \n\t<TABLE border=\"0\" >\n\t\t\t<TR bgcolor=\"#00204f\">\n\t\t\t\t<TH width=\"216\">\n\t\t\t\t<CENTER><b><FONT size=\"1\" color=\"white\" face=\"verdana\">Ubicación</FONT></b>\n\t\t\t\t</CENTER>\n\t\t\t\t</TH>\n\t\t\t\t<TH width=\"216\">\n\t\t\t\t<CENTER><b><FONT size=\"1\" color=\"white\" face=\"verdana\">NOMBRE</FONT></b></CENTER>\n\t\t\t\t</TH>\n\t\t\t\t<TH width=\"216\">\n\t\t\t\t<CENTER><b><FONT size=\"1\" color=\"white\" face=\"verdana\">TAMAño</FONT></b></CENTER>\n\t\t\t\t</TH>\n\t\t\t\t<TH width=\"216\">\n\t\t\t\t<CENTER><b><FONT size=\"1\" color=\"white\" face=\"verdana\">FECHA DE Creación</FONT></b>\n\t\t\t\t</CENTER>\n\t\t\t\t</TH>\n\t\t\t</TR>\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t<TR>\n\t\t\t\t<TD width=\"216\">\n\t\t\t\t<CENTER><b>\n\t\t\t\t<A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[11] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[12] = 
    "\">\n\t\t\t\t<FONT size=\"1\" face=\"verdana\">".toCharArray();
    __oracle_jsp_text[13] = 
    "</FONT></b>\n\t\t\t\t</CENTER>\n\t\t\t\t</TD>\n\t\t\t\t<TD width=\"216\">\n\t\t\t\t<CENTER><b><FONT size=\"1\" face=\"verdana\">".toCharArray();
    __oracle_jsp_text[14] = 
    "</FONT></b></CENTER>\n\t\t\t\t</TD>\n\t\t\t\t<TD width=\"216\">\n\t\t\t\t<CENTER><b><FONT size=\"1\" face=\"verdana\">".toCharArray();
    __oracle_jsp_text[15] = 
    "B</FONT></b></CENTER>\n\t\t\t\t</TD>\n\t\t\t\t<TD width=\"216\">\n\t\t\t\t<CENTER><b><FONT size=\"1\" face=\"verdana\">".toCharArray();
    __oracle_jsp_text[16] = 
    "</FONT></b>\n\t\t\t\t</CENTER>\n\t\t\t\t</TD>\n\t\t\t</TR>\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\t\n\t<TR>\n\t\t<TD colspan=\"4\"> <BR> <CENTER><b> NO SE ENCONTRARÃ“N ARCHIVOS CON ESTE CRITERIO </b></CENTER></TD>\n\t\t\t\t\n\t</TR>\n\n\t\n\t</TABLE>\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\n</DIV>\n<br>\n</DIV>\n<br>\n</FORM>\n</BODY>\n</HTML> \n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
