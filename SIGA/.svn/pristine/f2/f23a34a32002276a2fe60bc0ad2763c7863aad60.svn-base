package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.util.*;


public class _PortalBorrador extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


	public static boolean par(int num)
    {
        boolean p = false;
        if (num % 2 == 0) 
        {
            p = true;
        }    
        return p;
    }

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
    _PortalBorrador page = this;
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
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null)
      		response.sendRedirect("index.jsp?pagina="+ strTmp);		
      
      
      out.write(__oracle_jsp_text[4]);
      
      	boolean bExiste	= false;
      	int t = 0;
      	bExiste	= ActualizaAsunto.getExistenAsuntosEnAtencion();
        	String strActivarPortal = application.getInitParameter("ActivarPortal");
      	String strAccion = request.getParameter("accion");
      	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
      
      	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
      	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");
      	int regPorPagina = 20;
      	int muestraPaginas = 20;
      	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
      	if(strConfig != null && strConfig.length > 0){
      		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
      		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
      	}
      	int numRegistros = 0;
      	int numPaginas = 0;
      
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
      out.print( strOrden );
      out.write(__oracle_jsp_text[7]);
      out.print( strTipo );
      out.write(__oracle_jsp_text[8]);
      out.print( contPag );
      out.write(__oracle_jsp_text[9]);
      out.print( contligas );
      out.write(__oracle_jsp_text[10]);
      if(BUsuario.getTurnado() || BUsuario.getRecepcion()){
      out.write(__oracle_jsp_text[11]);
      }
      out.write(__oracle_jsp_text[12]);
      if(BUsuario.getTurnado()){
      out.write(__oracle_jsp_text[13]);
      }
      out.write(__oracle_jsp_text[14]);
      if(BUsuario.getAtencion()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[15]);
      }
      out.write(__oracle_jsp_text[16]);
      if(BUsuario.getAtencion()||BUsuario.getRecepcion()||BUsuario.getSupervisor()||BUsuario.getTurnado()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[17]);
      }
      out.write(__oracle_jsp_text[18]);
      if(BUsuario.getAtencion()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[19]);
      }
      out.write(__oracle_jsp_text[20]);
      	numRegistros = ActualizaAsunto.getAsuntoEnAtencion(strOrden, strTipo, BUsuario.getIdArea(), BUsuario.getIdUsuario()).length;
      			if (numRegistros>0){ 
      out.write(__oracle_jsp_text[21]);
      	} 
      out.write(__oracle_jsp_text[22]);
      	numPaginas = numRegistros/regPorPagina;	
      			if (numRegistros%regPorPagina != 0)
      				numPaginas++; 
      out.write(__oracle_jsp_text[23]);
      	if (numRegistros > 0){	
      out.write(__oracle_jsp_text[24]);
      out.print( numRegistros );
      out.write(__oracle_jsp_text[25]);
      	} 
      out.write(__oracle_jsp_text[26]);
      	if (numPaginas > 1){	
      out.write(__oracle_jsp_text[27]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[28]);
      out.print( numPaginas );
      out.write(__oracle_jsp_text[29]);
       	} 
      out.write(__oracle_jsp_text[30]);
       if(bExiste){ 
      out.write(__oracle_jsp_text[31]);
       int j = 0; 
      out.write(__oracle_jsp_text[32]);
      	String[][] sql = ActualizaAsunto.getAsuntoEnAtencion(strOrden, strTipo, BUsuario.getIdArea(), BUsuario.getIdUsuario());
      			for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
      				String campo1 = sql[i][0];
      				String campo2 = sql[i][1];
      				String campo3 = sql[i][2];
      				String campo4 = sql[i][3];
      				String campo5 = sql[i][4];
      				String campo6 = sql[i][5];
      				String campo7 = sql[i][6];
      				String campo8 = sql[i][7];
      				String campo9 = sql[i][8];
      				String campo10 = sql[i][9];
      		
      out.write(__oracle_jsp_text[33]);
       t++; 
      out.write(__oracle_jsp_text[34]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[35]);
      }
      out.write(__oracle_jsp_text[36]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[37]);
      }else{
      out.write(__oracle_jsp_text[38]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[39]);
      }
      out.write(__oracle_jsp_text[40]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[41]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[42]);
      out.print( campo2 );
      out.write(__oracle_jsp_text[43]);
      out.print( Utilerias.recortaString(campo2,50) );
      out.write(__oracle_jsp_text[44]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[45]);
      }else{
      out.write(__oracle_jsp_text[46]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[47]);
      }
      out.write(__oracle_jsp_text[48]);
      out.print(campo4 );
      out.write(__oracle_jsp_text[49]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[50]);
      }else{
      out.write(__oracle_jsp_text[51]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[52]);
      }
      out.write(__oracle_jsp_text[53]);
      out.print(campo10 );
      out.write(__oracle_jsp_text[54]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[55]);
      }else{
      out.write(__oracle_jsp_text[56]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[57]);
      }
      out.write(__oracle_jsp_text[58]);
       j++; 
      out.write(__oracle_jsp_text[59]);
       } 
      out.write(__oracle_jsp_text[60]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[61]);
       } else {
      out.write(__oracle_jsp_text[62]);
      
      			int numeroPaginas = (sql!=null)?sql.length/regPorPagina:0;	
      			if (sql.length%regPorPagina != 0)
      				numeroPaginas++; 
      			if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[63]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[64]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[65]);
      	}
      			if (contPag > 0){  
      				if (contPag > contligas){
      out.write(__oracle_jsp_text[66]);
      out.print(contligas);
      out.write(__oracle_jsp_text[67]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[68]);
      	}else{
      out.write(__oracle_jsp_text[69]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[70]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[71]);
      	} 
      			}
      			if (numeroPaginas > 1){
      				for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
      					if (i==contPag){  
      out.write(__oracle_jsp_text[72]);
      out.print(i);
      out.write(__oracle_jsp_text[73]);
      out.print(i+1);
      out.write(__oracle_jsp_text[74]);
      		}else{ 
      out.write(__oracle_jsp_text[75]);
      out.print(i);
      out.write(__oracle_jsp_text[76]);
      out.print(i+1);
      out.write(__oracle_jsp_text[77]);
      		}
      				}
      			} 
      			if (contPag < numeroPaginas-1){  
      				if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[78]);
      out.print(contligas);
      out.write(__oracle_jsp_text[79]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[80]);
      	}else{
      out.write(__oracle_jsp_text[81]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[82]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[83]);
      	} 
      			}
      			if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[84]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[85]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[86]);
      	
      			} 
      out.write(__oracle_jsp_text[87]);
       } 
      out.write(__oracle_jsp_text[88]);
       } else { 
      out.write(__oracle_jsp_text[89]);
       } 
      out.write(__oracle_jsp_text[90]);

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
  private static final char __oracle_jsp_text[][]=new char[91][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<html>\n<head>\n<TITLE>Asuntos en Recepción....</TITLE>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[5] = 
    " \n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<link rel=\"stylesheet\" href=\"../css/menu.css\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<META HTTP-EQUIV=\"Pragma\" CONTENT=\"no-cache\">\n<META HTTP-EQUIV=\"Expires\" CONTENT=\"-1\">\n<script language=\"JavaScript\" type=\"text/javascript\">\n\tfunction cambio(o, t){\n\t\tdoc = document._gestionTable2;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\nfunction pagina(contador){\n\tdoc = document._gestionTable2;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\n\nfunction paginaLiga(contador){\n\tdoc = document._gestionTable2;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</head>\n<body background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n\n<form method=\"post\" action=\"PortalBorrador.jsp\" name=\"_gestionTable2\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\" name=\"contligas\">\n<table cellspacing=\"2\" cellpadding=\"2\">\n<TBODY>\n\t<TR>\n\t\t<TD class=\"etiquetas\">\n\t\t\t\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\n\n<table cellspacing=\"2\" cellpadding=\"2\">\n\t<TBODY>\n\t\t<tr>\n\t\t<tr>\n\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n                    <td class=\"dominoSelTopTab\" bgcolor=\"#004080\"><a onclick=\"goAtencion()\";>Asuntos en Recepción</a></td>\n                ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[13] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntos()\";>Asuntos por turnar</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntosTr()\";>Asuntos en Trámite</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntosTer()\";>Asuntos terminados</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[15] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAtender()\";>Instrucciones por atender</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goTramite()\";>Instrucciones en Trámite</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goTerminadas()\";>Instrucciones terminadas</a></td>\n                ".toCharArray();
    __oracle_jsp_text[16] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[17] = 
    "\n                    <td class=\"dominoTopTab\" ><a onclick=\"goRechazadas()\";>Instrucciones rechazadas</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[19] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goSolicitada()\";>Asuntos Solicitados</a></td>\n                ".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t</tr>\n\t</TBODY>\n</table>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='45%' align=\"center\">\n\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">\n\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\tAsunto\n\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</font></TD>\n\t\t<TD WIDTH='15%' align=\"center\">\n\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">\n\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\tFolio\n\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</font>\n\t\t</TD>\n\t\t<TD WIDTH='25%' align=\"center\">\n\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">\n\t\t<a onclick=\"cambio('asc', 3)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\tIdentificador del Docto.\n\t\t<a onclick=\"cambio('desc', 3)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</font>\n\t\t</TD>\n\t\t<TD WIDTH='15%' align=\"center\"><FONT SIZE=1 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">Estatus</font></TD>\n\t</TR>\n</TABLE>\n<div id=\"msg\"></div>\n<DIV class=documentBody id=Body>\n<div id=\"view\">\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD align=\"left\">\n\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A href=\"../ReporteAsuntoExcel?tip=enrecepcion_001\">\n\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t</A>\n\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t</TD>\n\t\t<TD align=\"right\">\n\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    " registros mostrados.\n\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[28] = 
    " de ".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[35] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[36] = 
    ">\n\t\t\t\t<td width='45%'><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"16\" alt=\"\"><FONT SIZE=2 ".toCharArray();
    __oracle_jsp_text[37] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[38] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[39] = 
    "\"".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t\t\tFACE=\"Verdana\"> <A href=\"AsuntoRecepcion.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[41] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[42] = 
    "\"\n\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[43] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[44] = 
    "</A>\n\t\t\t\t</Font></td>\n\t\t\t\t<td width='15%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[45] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[46] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[47] = 
    "\"".toCharArray();
    __oracle_jsp_text[48] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[49] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='25%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[50] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[51] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[52] = 
    "\"".toCharArray();
    __oracle_jsp_text[53] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[54] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='15%'><font size=\"2\" ".toCharArray();
    __oracle_jsp_text[55] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[56] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[57] = 
    "\"".toCharArray();
    __oracle_jsp_text[58] = 
    " face=\"Arial\"></font>\n\t\t\t\t<div align=center>En Recepción</div>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No tiene Asuntos en Recepción ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t<TR>\n\t\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[64] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[65] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[66] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[67] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[68] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[69] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[70] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[71] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[72] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[73] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[74] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[75] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[76] = 
    ")\">".toCharArray();
    __oracle_jsp_text[77] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[79] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[80] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[81] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[82] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[83] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[85] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[86] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[87] = 
    "\n\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[88] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[89] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No tiene Asuntos en Recepción ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[90] = 
    "\n\t</TBODY>\n</table>\n</div>\n<br>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</form>\n</body>\n</html>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
