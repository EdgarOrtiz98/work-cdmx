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


public class _RecepcionFolio extends com.orionserver.http.OrionHttpJspPage {


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
    _RecepcionFolio page = this;
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
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
      	}	
      
      
      out.write(__oracle_jsp_text[4]);
      
      	boolean bMostrar	=	true;
      	boolean bExiste		=	true;
      	int t = 0;
      	bExiste		=	ActualizaAsunto.getExistenAsuntos(BUsuario.getIdArea(), BUsuario.getIdUsuario());
      
      	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"2";
      
      	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
      	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");
      
      	int regPorPagina = 20;
      	int muestraPaginas = 20;
      	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
      	if(strConfig != null && strConfig.length > 0){
      		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
      		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
      	}	
      
      	String[][] strDatos = ActualizaAsunto.AsuntosPorFolio(BUsuario.getIdArea(),strOrden,strTipo);
      
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
       if(bExiste){ 
      out.write(__oracle_jsp_text[14]);
      	int numeroPaginas = strDatos.length/regPorPagina;	
      				if (strDatos.length%regPorPagina != 0)
      					numeroPaginas++;
      				if (strDatos.length == 1){ 
      out.write(__oracle_jsp_text[15]);
      out.print( strDatos.length );
      out.write(__oracle_jsp_text[16]);
      	}
      				if (strDatos.length > 1){ 
      out.write(__oracle_jsp_text[17]);
      out.print( strDatos.length );
      out.write(__oracle_jsp_text[18]);
      	}
      				if (numeroPaginas > 1){ 
      out.write(__oracle_jsp_text[19]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[20]);
      out.print( numeroPaginas );
      out.write(__oracle_jsp_text[21]);
      	} 
      out.write(__oracle_jsp_text[22]);
       	
      			numeroPaginas = strDatos.length/regPorPagina;	
      			if (strDatos.length%regPorPagina != 0)
      				numeroPaginas++;	
      
      			for (int i=contPag*regPorPagina; i<strDatos.length && i<(contPag+1)*regPorPagina; i++){
      				String usuario1 = strDatos[i][0];
      				String usuario2 = strDatos[i][1];
      				String usuario3 = strDatos[i][2];
      				String usuario4 = strDatos[i][3];
      				String usuario5 = strDatos[i][4];
      				String usuario6 = strDatos[i][5];
      				String usuario7 = strDatos[i][6];
      				String usuario8 = strDatos[i][7];
      		
      out.write(__oracle_jsp_text[23]);
       t++; 
      out.write(__oracle_jsp_text[24]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[25]);
      }
      out.write(__oracle_jsp_text[26]);
      out.print( usuario1 );
      out.write(__oracle_jsp_text[27]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[28]);
      out.print( usuario2 );
      out.write(__oracle_jsp_text[29]);
       if(usuario8.equals("1")){ 
      out.write(__oracle_jsp_text[30]);
      out.print( ActualizaUsuario.NombreUsuario(usuario4) );
      out.write(__oracle_jsp_text[31]);
       }else{ 
      out.write(__oracle_jsp_text[32]);
      out.print( ActualizaRemitente.getNombreRemitente(usuario4) );
      out.write(__oracle_jsp_text[33]);
       } 
      out.write(__oracle_jsp_text[34]);
      out.print( usuario3 );
      out.write(__oracle_jsp_text[35]);
      out.print(Utilerias.formatearFechas(usuario6));
      out.write(__oracle_jsp_text[36]);
       		} 	
      out.write(__oracle_jsp_text[37]);
      
      				if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[38]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[39]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[40]);
      	}
      				if (contPag > 0){  
      					if (contPag > contligas){
      out.write(__oracle_jsp_text[41]);
      out.print(contligas);
      out.write(__oracle_jsp_text[42]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[43]);
      	}else{
      out.write(__oracle_jsp_text[44]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[45]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[46]);
      	} 
      				}
      				if (numeroPaginas > 1){
      					for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
      						if (i==contPag){  
      out.write(__oracle_jsp_text[47]);
      out.print(i);
      out.write(__oracle_jsp_text[48]);
      out.print(i+1);
      out.write(__oracle_jsp_text[49]);
      		}else{ 
      out.write(__oracle_jsp_text[50]);
      out.print(i);
      out.write(__oracle_jsp_text[51]);
      out.print(i+1);
      out.write(__oracle_jsp_text[52]);
      		}
      					}
      				} 
      				if (contPag < numeroPaginas-1){  
      					if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[53]);
      out.print(contligas);
      out.write(__oracle_jsp_text[54]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[55]);
      	}else{
      out.write(__oracle_jsp_text[56]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[57]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[58]);
      	} 
      				}
      				if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[59]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[60]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[61]);
      	
      				} 
      out.write(__oracle_jsp_text[62]);
       }else{ 
      out.write(__oracle_jsp_text[63]);
       } 
      out.write(__oracle_jsp_text[64]);

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
  private static final char __oracle_jsp_text[][]=new char[65][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Ordenados por Folios</TITLE>\n<script language=\"JavaScript\" type=\"text/javascript\">\n\tfunction cambio(o, t){\n\t\tdoc = document.recepcionFolio;\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\n\n\tfunction pagina(contador){\n\t\tdoc = document.recepcionFolio;\n\t\tdoc.contPag.value=contador;\n\t\tdoc.submit();\n\t}\n\n\tfunction paginaLiga(contador){\n\t\tdoc = document.recepcionFolio;\n\t\tdoc.contligas.value=contador;\n\t\tdoc.submit();\n\t}\n</script>\n\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM name=\"recepcionFolio\" action=\"RecepcionFolio.jsp\" method=\"post\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"contligas\">\n<table cellspacing=\"2\" cellpadding=\"2\" width=\"100%\">\n<TBODY>\n\t<TR>\n\t\t<TD class=\"etiquetas\" width=\"30%\">\n\t\t\t<b><FONT size=\"3\">En Recepción, Ordenados por Folios</FONT></b>\n\t\t</TD>\n\t\t<TD class=\"etiquetas\" align=\"center\" width=\"40%\">\n\t\t</TD>\n\t\t<TD class=\"etiquetas\" align=\"center\" width=\"30%\">\n\t\t\t&nbsp;\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='20%' align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"Arial\">Folio</font>\n\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</TD>\n\t\t<TD WIDTH='30%' align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"Arial\">Solicitante</font>\n\t\t\t<a onclick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</TD>\n\t\t<TD WIDTH='30%' align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 3)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"Arial\">Título</font>\n\t\t\t<a onclick=\"cambio('desc', 3)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</TD>\n\t\t<TD WIDTH='20%' align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 6)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"Arial\">Fecha por Captura</font>\n\t\t\t<a onclick=\"cambio('desc', 6)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</TD>\n\t</TR>\n</TABLE>\n<br>\n<table>\n\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t<TR>\n\t\t\t<TD align=\"left\">\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<A href=\"../ReporteAsuntoExcel?tip=recepcion_folio\">\n\t\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t\t</A>\n\t\t\t</TD>\n\t\t\t<TD align=\"right\" colspan=\"4\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    " registro mostrado\n\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    " registros mostrados\n\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t\t\t, &nbsp;Pagina ".toCharArray();
    __oracle_jsp_text[20] = 
    " de ".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[25] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[26] = 
    ">\n\t\t\t<td align=\"center\" width=\"20%\">\n\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t<A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[27] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[28] = 
    "\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "</A>\n\t\t\t\t</font>\n\t\t\t</td>\n\t\t\t<td align=\"center\" width=\"364\">\n\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t\t</font>\n\t\t\t</td>\n\t\t\t<td align=\"center\" width=\"367\"><font size=\"1\" color=\"#000080\"\n\t\t\t\tface=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[35] = 
    " </font></td>\n\t\t\t<td align=\"center\" width=\"239\"><font size=\"1\" color=\"#000080\"\n\t\t\t\tface=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[36] = 
    " </font></td>\n\t\t</tr>\n\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t<TR>\n\t\t\t<TD colspan=\"4\" align=\"center\"><BR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[39] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[40] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[42] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[43] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[45] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[46] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[48] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[49] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[51] = 
    ")\">".toCharArray();
    __oracle_jsp_text[52] = 
    "</A> &nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[54] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[55] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[57] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[58] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[60] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[61] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\n\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t<TR>\n\t\t<TD width=\"20%\">\n\t\t\t<div align=center>\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">******No Existen Asuntos******</FONT>\n\t\t\t</div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\n</table>\n</FORM>\n\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
