package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import java.util.*;
import com.meve.sigma.reportes.*;


public class _ventradas extends com.orionserver.http.OrionHttpJspPage {


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
    _ventradas page = this;
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
      	boolean bExiste1	= false;
      	int t = 0;
      	String strIdArea = BUsuario.getIdArea();
      	bExiste	= ActualizaInstrucciones.getExistenFolioEntradaInst(strIdArea);
      	bExiste1= ActualizaInstrucciones.getExisteFolioEntradaAsunto(strIdArea);
      	String strAccion = request.getParameter("accion");
      	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
      	int noTiene = 0;
      
      	String aux1[][] = ActualizaInstrucciones.getFolioEntradasInst(strIdArea, strOrden, strTipo);
      	String aux2[][] = ActualizaInstrucciones.getFolioEntradaAsunto(strIdArea, strOrden, strTipo);
      	String strDatos[][] = null;
      
      	if (bExiste && !bExiste1)
      		strDatos = aux1;
      
      	if (!bExiste && bExiste1)
      		strDatos = aux2;
      
      	if (bExiste && bExiste1){
      		strDatos = new String[aux1.length + aux2.length][aux1[0].length];
      		for (int i=0; i<strDatos.length; i++){
      			if (i<aux1.length)
      				strDatos[i] = aux1[i];
      			else 
      				strDatos[i] = aux2[i-aux1.length];			
      		}
      	}
      
      	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
      	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");
      
      	int regPorPagina = 20;
      	int muestraPaginas = 20;
      	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
      	if(strConfig != null && strConfig.length > 0){
      		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
      		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
      	}	
      
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
      if(BUsuario.getRecepcion() && 
      		!(BUsuario.getAdmon() || BUsuario.getSupervisor() || BUsuario.getAtencion() || BUsuario.getTurnado() || BUsuario.getAsistente())){
      out.write(__oracle_jsp_text[7]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[8]);
      }
      out.write(__oracle_jsp_text[9]);
      out.print(strOrden );
      out.write(__oracle_jsp_text[10]);
      out.print(strTipo );
      out.write(__oracle_jsp_text[11]);
      out.print(contPag );
      out.write(__oracle_jsp_text[12]);
      out.print(contligas );
      out.write(__oracle_jsp_text[13]);
       	int j = 0; 
      out.write(__oracle_jsp_text[14]);
       	if ((bExiste || bExiste1) && (BUsuario.getTurnado() || BUsuario.getSupervisor())){
      out.write(__oracle_jsp_text[15]);
      
      			if((bExiste || bExiste1) && (BUsuario.getTurnado() || BUsuario.getSupervisor())){
      
      				int numeroPaginas = strDatos.length/regPorPagina;	
      				if (strDatos.length%regPorPagina != 0)
      					numeroPaginas++;
      				if (strDatos.length == 1){ 
      out.write(__oracle_jsp_text[16]);
      out.print( strDatos.length );
      out.write(__oracle_jsp_text[17]);
      	}
      				if (strDatos.length > 1){ 
      out.write(__oracle_jsp_text[18]);
      out.print( strDatos.length );
      out.write(__oracle_jsp_text[19]);
      	}
      				if (numeroPaginas > 1){ 
      out.write(__oracle_jsp_text[20]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[21]);
      out.print( numeroPaginas );
      out.write(__oracle_jsp_text[22]);
      	}
      			}
      			
      out.write(__oracle_jsp_text[23]);
      		int numeroPaginas = strDatos.length/regPorPagina;	
      				if (strDatos.length%regPorPagina != 0)
      					numeroPaginas++;
      
      				for (int i=contPag*regPorPagina; i<strDatos.length && i<(contPag+1)*regPorPagina; i++){
      					String campo1 = strDatos[i][0];
      					String campo2 = strDatos[i][1];
      					String campo3 = strDatos[i][2];
      					String campo4 = strDatos[i][3];
      					String campo5 = strDatos[i][4];
      					String campo6 = strDatos[i][5];
      					if(BUsuario.getTurnado() || BUsuario.getSupervisor()){
      		 				t++; 
      		
      out.write(__oracle_jsp_text[24]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[25]);
      }
      out.write(__oracle_jsp_text[26]);
      out.print( campo2 );
      out.write(__oracle_jsp_text[27]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[28]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[29]);
      out.print(campo4);
      out.write(__oracle_jsp_text[30]);
      out.print(campo6);
      out.write(__oracle_jsp_text[31]);
      out.print(campo5);
      out.write(__oracle_jsp_text[32]);
       				j++;  			
      					}	 
      		 		} 
      		
      out.write(__oracle_jsp_text[33]);
       if (BUsuario.getTurnado() || BUsuario.getSupervisor()){ 
      out.write(__oracle_jsp_text[34]);
      
      				if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[35]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[36]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[37]);
      	}
      				if (contPag > 0){  
      					if (contPag > contligas){
      out.write(__oracle_jsp_text[38]);
      out.print(contligas);
      out.write(__oracle_jsp_text[39]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[40]);
      	}else{
      out.write(__oracle_jsp_text[41]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[42]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[43]);
      	} 
      				}
      				if (numeroPaginas > 1){
      					for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
      						if (i==contPag){  
      out.write(__oracle_jsp_text[44]);
      out.print(i);
      out.write(__oracle_jsp_text[45]);
      out.print(i+1);
      out.write(__oracle_jsp_text[46]);
      		}else{ 
      out.write(__oracle_jsp_text[47]);
      out.print(i);
      out.write(__oracle_jsp_text[48]);
      out.print(i+1);
      out.write(__oracle_jsp_text[49]);
      		}
      					}
      				} 
      				if (contPag < numeroPaginas-1){  
      					if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[50]);
      out.print(contligas);
      out.write(__oracle_jsp_text[51]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[52]);
      	}else{
      out.write(__oracle_jsp_text[53]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[54]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[55]);
      	} 
      				}
      				if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[56]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[57]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[58]);
      	
      				} 
      out.write(__oracle_jsp_text[59]);
       	} 
      out.write(__oracle_jsp_text[60]);
       } 
      out.write(__oracle_jsp_text[61]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[62]);
       } 
      out.write(__oracle_jsp_text[63]);

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
  private static final char __oracle_jsp_text[][]=new char[64][];
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
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    " \n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/link.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<TITLE>Folios De Control</TITLE>\n<script language=\"JavaScript\" type=\"text/javascript\">\n\tfunction cambio(o, t){\n\t\tdoc = document.salidasE;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\n\n\tfunction pagina(contador){\n\t\tdoc = document.salidasE;\n\t\tdoc.contPag.value=contador;\n\t\tdoc.submit();\n\t}\n\n\tfunction paginaLiga(contador){\n\t\tdoc = document.salidasE;\n\t\tdoc.contligas.value=contador;\n\t\tdoc.submit();\n\t}\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<body background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<form method=\"post\" action=\"ventradas.jsp\" name=\"salidasE\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"PP\" value=\"1\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"contligas\">\n<table cellspacing=\"2\" cellpadding=\"2\" width=\"100%\">\n<TBODY>\n\t<TR>\n\t\t<TD align=\"right\" width=\"40%\">\n\t\t\t<font face=\"verdana\" size=\"4\">Folios de Control de Ventanilla</font>\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='20%' align=\"center\">\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tFolio de Control\n\t\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font></TD>\n\n\t\t<TD WIDTH='20%' align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"verdana\">Folio del Documento</font>\n\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</TD>\n\t\t<TD WIDTH='30%' align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 3)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"verdana\">Asunto</font>\n\t\t\t<a onclick=\"cambio('desc', 3)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</TD>\n\t\t<TD WIDTH='30%' align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"verdana\">Identificador del Documento</font>\n\t\t\t<a onclick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</TD>\n\t</TR>\n</TABLE>\n<BR>\n<div id=\"msg\"></div>\n<DIV class=documentBody id=Body>\n<div id=\"view\">\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t<TR>\n\t\t\t<TD align=\"center\">\n\t\t\t<A onclick=\"window.open('../ReporteBeanExcel?tip=foliodecontrol_beanExcel');\" title=\"Exportar a Excel\">\n\t\t\t<img src=\"../Imagenes/ic_excel.gif\" border=\"0\"></A>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A onclick=\"window.open('../ReporteBeanPDF?tip=foliodecontrol_bean');\" title=\"Exportar a PDF\">\n\t\t\t<img src=\"../Imagenes/ic_pdf.gif\" border=\"0\"></A>\n\t\t\t</TD>\n\t\t\t<TD colspan=\"3\" align=\"right\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    " registro mostrado\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    " registros mostrados\n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t\t&nbsp;Pagina ".toCharArray();
    __oracle_jsp_text[21] = 
    " de ".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[25] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[26] = 
    ">\n\t\t\t<td width='20%' align=\"center\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"16\" alt=\"\"><FONT SIZE=2\n\t\t\t\tFACE=\"Verdana\"> <A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[27] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[28] = 
    "\">".toCharArray();
    __oracle_jsp_text[29] = 
    "</A></Font></td>\n\t\t\t<td width='20%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[30] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t</td>\n\t\t\t<td width='30%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[31] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t</td>\n\t\t\t<td width='30%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[32] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t</td>\n\t\t</tr>\n\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t<TR>\n\t\t\t<TD colspan=\"4\" align=\"center\"><BR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[36] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[37] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[39] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[40] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[42] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[43] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[45] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[46] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[48] = 
    ")\">".toCharArray();
    __oracle_jsp_text[49] = 
    "</A> &nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[51] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[52] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[54] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[55] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[57] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[58] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">******No Hay Asuntos con Folio de Entrada******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t</TBODY>\n</table>\n</div>\n<br>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</form>\n</body>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
