package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.reportes.*;
import com.meve.sigma.util.*;


public class _portalAsuntosSolicitados extends com.orionserver.http.OrionHttpJspPage {


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
    _portalAsuntosSolicitados page = this;
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
      	try{
      		response.sendRedirect("index.jsp?pagina="+ strTmp);
      	}catch(java.io.IOException io){;}
      
      	boolean bExiste	= false;
      	boolean bMostrar = false;
      	int t = 0;
      	bExiste = ActualizaAsunto.getExistenAsuntosSolicitadas(BUsuario.getIdUsuario(), BUsuario.getIdArea());
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
      
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      out.print( strOrden );
      out.write(__oracle_jsp_text[6]);
      out.print( strTipo );
      out.write(__oracle_jsp_text[7]);
      out.print( contPag );
      out.write(__oracle_jsp_text[8]);
      out.print( contligas );
      out.write(__oracle_jsp_text[9]);
      if(BUsuario.getTurnado() || BUsuario.getRecepcion()){
      out.write(__oracle_jsp_text[10]);
      }
      out.write(__oracle_jsp_text[11]);
      if(BUsuario.getTurnado()){
      out.write(__oracle_jsp_text[12]);
      }
      out.write(__oracle_jsp_text[13]);
      if(BUsuario.getAtencion()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[14]);
      }
      out.write(__oracle_jsp_text[15]);
      if(BUsuario.getAtencion()||BUsuario.getRecepcion()||BUsuario.getSupervisor()||BUsuario.getTurnado()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[16]);
      }
      out.write(__oracle_jsp_text[17]);
      if(BUsuario.getAtencion()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[18]);
      }
      out.write(__oracle_jsp_text[19]);
      	numRegistros = ActualizaAsunto.getAsuntosSolicitados(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea()).length;
      			if (numRegistros>0){ 
      out.write(__oracle_jsp_text[20]);
      	} 
      out.write(__oracle_jsp_text[21]);
      	numPaginas = numRegistros/regPorPagina;	
      			if (numRegistros%regPorPagina != 0)
      				numPaginas++; 
      out.write(__oracle_jsp_text[22]);
      	if (numRegistros > 0){	
      out.write(__oracle_jsp_text[23]);
      out.print( numRegistros );
      out.write(__oracle_jsp_text[24]);
      	} 
      out.write(__oracle_jsp_text[25]);
      	if (numPaginas > 1){	
      out.write(__oracle_jsp_text[26]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[27]);
      out.print( numPaginas );
      out.write(__oracle_jsp_text[28]);
       	} 
      out.write(__oracle_jsp_text[29]);
      if(bExiste){
      out.write(__oracle_jsp_text[30]);
       int j = 0; 
      out.write(__oracle_jsp_text[31]);
      	String[][] sql = ActualizaAsunto.getAsuntosSolicitados(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea());
      			for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
      				String campo1 = sql[i][0];
      				String campo2 = sql[i][1];
      				String campo3 = sql[i][2];
      				String campo4 = sql[i][3];
      				String campo5 = sql[i][4];
      				String campo6 = sql[i][5];
      				String campo7 = sql[i][6];
      		
      out.write(__oracle_jsp_text[32]);
       t++; 
      out.write(__oracle_jsp_text[33]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[34]);
      }
      out.write(__oracle_jsp_text[35]);
      out.print(campo1);
      out.write(__oracle_jsp_text[36]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[37]);
      out.print( campo2 );
      out.write(__oracle_jsp_text[38]);
      out.print( Utilerias.recortaString(campo2,40) );
      out.write(__oracle_jsp_text[39]);
      out.print(campo3);
      out.write(__oracle_jsp_text[40]);
      out.print(campo5 );
      out.write(__oracle_jsp_text[41]);
      out.print(Utilerias.recortaString(campo5,20) );
      out.write(__oracle_jsp_text[42]);
      out.print(campo4 );
      out.write(__oracle_jsp_text[43]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[44]);
      out.print(Utilerias.recortaString(campo7,20) );
      out.write(__oracle_jsp_text[45]);
       j++; 
      out.write(__oracle_jsp_text[46]);
       } 
      out.write(__oracle_jsp_text[47]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[48]);
       } else {
      out.write(__oracle_jsp_text[49]);
      
      			int numeroPaginas = (sql!=null)?sql.length/regPorPagina:0;	
      			if (sql.length%regPorPagina != 0)
      				numeroPaginas++; 
      			if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[50]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[51]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[52]);
      	}
      			if (contPag > 0){  
      				if (contPag > contligas){
      out.write(__oracle_jsp_text[53]);
      out.print(contligas);
      out.write(__oracle_jsp_text[54]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[55]);
      	}else{
      out.write(__oracle_jsp_text[56]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[57]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[58]);
      	} 
      			}
      			if (numeroPaginas > 1){
      				for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
      					if (i==contPag){  
      out.write(__oracle_jsp_text[59]);
      out.print(i);
      out.write(__oracle_jsp_text[60]);
      out.print(i+1);
      out.write(__oracle_jsp_text[61]);
      		}else{ 
      out.write(__oracle_jsp_text[62]);
      out.print(i);
      out.write(__oracle_jsp_text[63]);
      out.print(i+1);
      out.write(__oracle_jsp_text[64]);
      		}
      				}
      			} 
      			if (contPag < numeroPaginas-1){  
      				if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[65]);
      out.print(contligas);
      out.write(__oracle_jsp_text[66]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[67]);
      	}else{
      out.write(__oracle_jsp_text[68]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[69]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[70]);
      	} 
      			}
      			if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[71]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[72]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[73]);
      	
      			} 
      out.write(__oracle_jsp_text[74]);
       } 
      out.write(__oracle_jsp_text[75]);
       } else { 
      out.write(__oracle_jsp_text[76]);
       } 
      out.write(__oracle_jsp_text[77]);

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
  private static final char __oracle_jsp_text[][]=new char[78][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    " \n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<link rel=\"stylesheet\" href=\"../css/menu.css\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<TITLE>Asuntos Solicitados</TITLE>\n<script language=\"JavaScript\" type=\"text/javascript\">\n\tfunction cambio(o, t){\n\t\tdoc = document.pSolicitados;\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\nfunction pagina(contador){\n\tdoc = document.pSolicitados;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\n\nfunction paginaLiga(contador){\n\tdoc = document.pSolicitados;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<form method=\"post\" action=\"portalAsuntosSolicitados.jsp\" name=\"pSolicitados\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\" name=\"contligas\">\n<table cellspacing=\"2\" cellpadding=\"2\">\n<TBODY>\n\t<TR>\n\t\t<TD class=\"etiquetas\">\n\t\t\t\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\n<table cellspacing=\"2\" cellpadding=\"2\">\n\t<TBODY>\n\t\t<tr>\n\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAtencion()\";>Asuntos en Recepción</a></td>\n                ".toCharArray();
    __oracle_jsp_text[11] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntos()\";>Asuntos por turnar</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntosTr()\";>Asuntos en Trámite</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntosTer()\";>Asuntos terminados</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[14] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAtender()\";>Instrucciones por atender</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goTramite()\";>Instrucciones en Trámite</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goTerminadas()\";>Instrucciones terminadas</a></td>\n                ".toCharArray();
    __oracle_jsp_text[15] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[16] = 
    "\n                    <td class=\"dominoTopTab\" ><a onclick=\"goRechazadas()\";>Instrucciones rechazadas</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[18] = 
    "\n                    <td class=\"dominoSelTopTab\" bgcolor=\"#004080\"><a onclick=\"goSolicitada()\";>Asuntos Solicitados</a></td>\n                ".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t</tr>\n\t</TBODY>\n</table>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='30%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t\t<a onClick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tAsunto\n\t\t\t<a onClick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font></TD>\n\n\t\t<TD WIDTH='15%' align=\"center\">\n\t\t\t<a onClick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">Folio</font>\n\t\t\t<a onClick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</TD>\n\t\t<TD WIDTH='20%' align=\"center\">\n\t\t\t<a onClick=\"cambio('asc', 3)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">Identificador del Docto.</font>\n\t\t\t<a onClick=\"cambio('desc', 3)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</TD>\n\t\t<TD WIDTH='10%' align=\"center\">\n\t\t\t<a onClick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">Avance(%)</font>\n\t\t\t<a onClick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</TD>\n\t\t<TD WIDTH='15%' align=\"center\">\n\t\t\t<a onClick=\"cambio('asc', 5)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">Atendido Por</font>\n\t\t\t<a onClick=\"cambio('desc', 5)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</TD>\n\t\t<TD WIDTH='10%' align=\"center\"><FONT SIZE=1 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"verdana\">Estatus</font></TD>\n\t</TR>\n</TABLE>\n<DIV class=documentBody id=Body>\n<div id=\"view\">\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD align=\"left\">\n\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A href=\"../ReporteAsuntoExcel?tip=solicitado_01\">\n\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t</A>\n\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t</TD>\n\t\t<TD align=\"right\">\n\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    " registros mostrados.\n\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[27] = 
    " de ".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[34] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[35] = 
    ">\n\t\t\t\t<td width='30%' align=\"left\">\n\t\t\t\t\t<FONT SIZE=2 FACE=\"Arial\">&nbsp;&nbsp;\n\t\t\t\t\t\t<A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[36] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[37] = 
    "\" \n\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[38] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[39] = 
    "</A>\n\t\t\t\t</Font></td>\n\t\t\t\t<td width='15%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[40] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='20%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<a title=\"".toCharArray();
    __oracle_jsp_text[41] = 
    "\">\n\t\t\t\t\t<font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[42] = 
    "</font>\n\t\t\t\t\t</a>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[43] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='15%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<a title=\"".toCharArray();
    __oracle_jsp_text[44] = 
    "\">\n\t\t\t\t\t<font size=\"1\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[45] = 
    "</font>\n\t\t\t\t\t</a>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'>\n\t\t\t\t<div align=center><IMG SRC='../Imagenes/gris5.gif' BORDER=0 ALT=''></div>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">******No Tiene Asuntos\n\t\t\tSolicitados******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t<TR>\n\t\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t\t\t<A onClick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[51] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[52] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\t\t\t\t<A onClick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[54] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[55] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t\t\t<A onClick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[57] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[58] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t\t\t\t\t<A onClick=\"pagina(".toCharArray();
    __oracle_jsp_text[60] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[61] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t\t\t\t\t<A onClick=\"pagina(".toCharArray();
    __oracle_jsp_text[63] = 
    ")\">".toCharArray();
    __oracle_jsp_text[64] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t\t\t\t\t<A onClick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[66] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[67] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "\n\t\t\t\t\t<A onClick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[69] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[70] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[71] = 
    "\n\t\t\t\t<A onClick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[72] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[73] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[75] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[76] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">******No Tiene Asuntos\n\t\t\tSolicitados******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t</TBODY>\n</table>\n<BR>\n</div>\n<br>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</form>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
