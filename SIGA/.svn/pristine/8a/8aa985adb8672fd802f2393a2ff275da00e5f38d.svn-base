package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.reportes.*;


public class _ViewTipoAsunto extends com.orionserver.http.OrionHttpJspPage {


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
    _ViewTipoAsunto page = this;
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
      
      
      out.write(__oracle_jsp_text[4]);
      
      	boolean bExistenTA = false;
      	bExistenTA = ActualizaReportes.getExistenRTA(BUsuario.getIdArea());
      	String strIds_Borrar[]	=	null;
      	String strAccion		=	"";
      	strAccion				=	request.getParameter("accion");
      	strIds_Borrar			=	request.getParameterValues("Borrar");
      	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar"))
      	{
      		boolean bOperacion	=	ActualizaReportes.deleteReportes(strIds_Borrar);
      	}
      
      	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
      	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
      	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");
      
      	int regPorPagina = 20;
      	int muestraPaginas = 20;
      	String[][] strConfig = com.meve.sigma.actualiza.ActualizaConfiguracion.getDatosConf();
      	if(strConfig != null && strConfig.length > 0){
      		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
      		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
      	}
      	int numRegistros = 0;
      	int numPaginas = 0;
      	
      
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
       if (	BUsuario.getRecepcion() && 
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
      if(BUsuario.getSupervisor()){
      out.write(__oracle_jsp_text[14]);
      }
      out.write(__oracle_jsp_text[15]);
       if(bExistenTA){ 
      out.write(__oracle_jsp_text[16]);
      	numRegistros = ActualizaReportes.getReportesPorTA(BUsuario.getIdArea(),strOrden,strTipo).length;
      			if (numRegistros>0){ 
      out.write(__oracle_jsp_text[17]);
      	} 
      out.write(__oracle_jsp_text[18]);
      	numPaginas = numRegistros/regPorPagina;	
      			if (numRegistros%regPorPagina != 0)
      				numPaginas++; 
      out.write(__oracle_jsp_text[19]);
      	if (numRegistros > 0){	
      out.write(__oracle_jsp_text[20]);
      out.print( numRegistros );
      out.write(__oracle_jsp_text[21]);
      	} 
      out.write(__oracle_jsp_text[22]);
      	if (numPaginas > 1){	
      out.write(__oracle_jsp_text[23]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[24]);
      out.print( numPaginas );
      out.write(__oracle_jsp_text[25]);
       	} 
      out.write(__oracle_jsp_text[26]);
      	String[][] sql = ActualizaReportes.getReportesPorTA(BUsuario.getIdArea(),strOrden,strTipo);
      		for (int ix=contPag*regPorPagina; ix<sql.length && ix<(contPag+1)*regPorPagina; ix++){
      			String campo1 = sql[ix][0];
      			String campo2 = sql[ix][1];
      			String campo3 = sql[ix][2];
      	
      out.write(__oracle_jsp_text[27]);
      if(par(ix+1)==true){
      }else{
      out.write(__oracle_jsp_text[28]);
      }
      out.write(__oracle_jsp_text[29]);
      if(BUsuario.getSupervisor()){
      out.write(__oracle_jsp_text[30]);
      out.print(campo1);
      out.write(__oracle_jsp_text[31]);
      }
      out.write(__oracle_jsp_text[32]);
      out.print(campo1);
      out.write(__oracle_jsp_text[33]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas));
      out.write(__oracle_jsp_text[34]);
      out.print(campo1);
      out.write(__oracle_jsp_text[35]);
      out.print(campo2);
      out.write(__oracle_jsp_text[36]);
      out.print(campo3);
      out.write(__oracle_jsp_text[37]);
       	} 
      out.write(__oracle_jsp_text[38]);
      
      		if (contligas>0 && numPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[39]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[40]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[41]);
      	}
      		if (contPag > 0){  
      			if (contPag > contligas){
      out.write(__oracle_jsp_text[42]);
      out.print(contligas);
      out.write(__oracle_jsp_text[43]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[44]);
      	}else{
      out.write(__oracle_jsp_text[45]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[46]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[47]);
      	} 
      		}
      		if (numPaginas > 1){
      			for (int ik=contligas; ik<muestraPaginas+contligas && ik<numPaginas; ik++){ 
      				if (ik==contPag){  
      out.write(__oracle_jsp_text[48]);
      out.print(ik);
      out.write(__oracle_jsp_text[49]);
      out.print(ik+1);
      out.write(__oracle_jsp_text[50]);
      		}else{ 
      out.write(__oracle_jsp_text[51]);
      out.print(ik);
      out.write(__oracle_jsp_text[52]);
      out.print(ik+1);
      out.write(__oracle_jsp_text[53]);
      		}
      			}
      		} 
      		if (contPag < numPaginas-1){  
      			if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[54]);
      out.print(contligas);
      out.write(__oracle_jsp_text[55]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[56]);
      	}else{
      out.write(__oracle_jsp_text[57]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[58]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[59]);
      	} 
      		}
      		if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[60]);
      out.print( numPaginas-muestraPaginas );
      out.write(__oracle_jsp_text[61]);
      out.print( numPaginas-1 );
      out.write(__oracle_jsp_text[62]);
      	
      		} 
      out.write(__oracle_jsp_text[63]);
       }else{ 
      out.write(__oracle_jsp_text[64]);
       } 
      out.write(__oracle_jsp_text[65]);

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
  private static final char __oracle_jsp_text[][]=new char[66][];
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
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Por Tipo de Asunto</TITLE>\n<SCRIPT language=\"JavaScript\" src=\"../js/GeneralFunctions.js\"></SCRIPT>\n<script type=\"text/javascript\">\n<!--\n\tfunction cambio(o, t){\n\t\tdoc = document.viewRTAsunto;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\n\tfunction pagina(contador){\n\t\tdoc = document.viewRTAsunto;\n\t\tdoc.contPag.value=contador;\n\t\tdoc.submit();\n\t}\n\tfunction paginaLiga(contador){\n\t\tdoc = document.viewRTAsunto;\n\t\tdoc.contligas.value=contador;\n\t\tdoc.submit();\n\t}\n//-->\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM name=\"viewRTAsunto\" action=\"ViewTipoAsunto.jsp\" method=\"post\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"contligas\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr valign=\"top\">\n\t<td width=\"43%\">\n\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t<a href=\"ReporteTAsunto.jsp\" title=\"Genera Reporte\">\n\t\t\t<img src=\"../Imagenes/nuevo1.gif\" border=\"0\" alt=\"Generar Reporte\">\n\t\t</a>\n\t\t<A href=\"javascript:Borrar()\" target=\"_self\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/borrar1.gif\">\n\t\t</A>\n\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t<font size=\"2\" face=\"Tahoma\"></font>\n\t</td>\n\t<td width=\"57%\" align=\"right\">\n\t<font face=\"verdana\" size=\"4\">Asuntos por Tipo de Asunto</font>\n\t</td>\n</tr>\n</table>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='15%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">\n\t\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tNo. de Reporte\n\t\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font></TD>\n\t\t<TD WIDTH='60%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">\n\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tReporte\n\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font></TD>\n\t\t<TD WIDTH='25%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">\n\t\t\t<a onclick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tFecha de Creación\n\t\t\t<a onclick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font></TD>\n\t</TR>\n</TABLE>\n<br>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t<TR>\n\t\t<TD align=\"left\" colspan=\"2\">\n\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t<!-- &nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A href=\"../ReporteAsuntoExcel?tip=porturnar_01\">\n\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t</A> -->\n\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t</TD>\n\t\t<TD align=\"right\" colspan=\"3\">\n\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    " registros mostrados.\n\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[24] = 
    " de ".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t<TR ".toCharArray();
    __oracle_jsp_text[28] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[29] = 
    ">\n\t\t<TD WIDTH='15%' align=\"center\">\n\t\t\t<FONT SIZE=2 COLOR=\"000000\" FACE=\"Arial\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t<INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[31] = 
    "\" name=\"Borrar\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t<A href=\"ReporteTAsunto.jsp?id_rep=".toCharArray();
    __oracle_jsp_text[33] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[34] = 
    "\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t</A>\n\t\t\t</font>\n\t\t</TD>\n\t\t<TD WIDTH='60%' align=\"center\"><FONT SIZE=2 COLOR=\"000000\"\n\t\t\tFACE=\"Arial\">".toCharArray();
    __oracle_jsp_text[36] = 
    "</font></TD>\n\t\t<TD WIDTH='25%' align=\"center\"><FONT SIZE=2 COLOR=\"000000\"\n\t\t\tFACE=\"Arial\">".toCharArray();
    __oracle_jsp_text[37] = 
    "</font></TD>\n\t</TR> \n\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t<TR>\n\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[40] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[41] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[43] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[44] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[46] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[47] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[49] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[50] = 
    "]</B></FONT></A> &nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[52] = 
    ")\">".toCharArray();
    __oracle_jsp_text[53] = 
    "</A> &nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[55] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[56] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[58] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[59] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[61] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[62] = 
    ");\"> <B>FINAL</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\n\t<TR>\n\t\t<TD align=\"center\">\n\t\t<FONT face=\"verdana\" size=\"4\">\n\t\t***** No existen reportes generados *****\n\t\t</FONT></TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t</TBODY>\n</TABLE>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
