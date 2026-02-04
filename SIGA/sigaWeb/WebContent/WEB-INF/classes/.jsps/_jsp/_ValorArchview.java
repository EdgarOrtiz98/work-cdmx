package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _ValorArchview extends com.orionserver.http.OrionHttpJspPage {


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
    _ValorArchview page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("headerC.jsp");
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
      		catch(java.io.IOException io){;}
      	}
      
      out.write(__oracle_jsp_text[4]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[5]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[6]);
       } 
      out.write(__oracle_jsp_text[7]);
      
      	boolean bExiste			=	false;
      	boolean bOperacion		=	false;
      	int bOperacion1		=	0;	
      	String strIds_Borrar[]	=	null;
      	String strAccion		=	"";
      	String msg				=	request.getParameter("msg");	
      	int t = 0;
      	strAccion				=	request.getParameter("accion");
      	strIds_Borrar			=	request.getParameterValues("Borrar");
      
      	bExiste					=	ActualizaExpArchivado.getExisteValor();	
      	
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
      
      	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar"))
      	{
      		bOperacion1	=	ActualizaExpArchivado.getDeleteValor(strIds_Borrar,BUsuario.getIdUsuario());
      			if(bOperacion1 == 2)
      			{
      			msg ="Existen registros asociados, el proceso de borrado no fue exitoso";
      			}
      	}
      	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
      
      out.write(__oracle_jsp_text[8]);
      out.write(__oracle_jsp_text[9]);
      if(msg!= null && msg.trim().length()>0)
      		{
      		
      out.write(__oracle_jsp_text[10]);
      out.print(msg);
      out.write(__oracle_jsp_text[11]);
      
      		}
      		
      out.write(__oracle_jsp_text[12]);
      out.print( strOrden );
      out.write(__oracle_jsp_text[13]);
      out.print( strTipo );
      out.write(__oracle_jsp_text[14]);
      out.print( contPag );
      out.write(__oracle_jsp_text[15]);
      out.print( contligas );
      out.write(__oracle_jsp_text[16]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[17]);
      	numRegistros = ActualizaExpArchivado.getDatosValor(strOrden, strTipo).length; 
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
       if(bExiste){ 
      out.write(__oracle_jsp_text[27]);
      	String[][] sql = ActualizaExpArchivado.getDatosValor(strOrden, strTipo);
      			for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
      				String campo1 = sql[i][0];
      				String campo2 = sql[i][1];
      				String campo3 = sql[i][2];
      				String campo4 = sql[i][3];
      				String campo5 = sql[i][4];
      		
      out.write(__oracle_jsp_text[28]);
       t++; 
      out.write(__oracle_jsp_text[29]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[30]);
      }
      out.write(__oracle_jsp_text[31]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[32]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[33]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[34]);
      out.print( campo4 );
      out.write(__oracle_jsp_text[35]);
      out.print(campo2);
      out.write(__oracle_jsp_text[36]);
      out.print(campo2);
      out.write(__oracle_jsp_text[37]);
      out.print(campo3);
      out.write(__oracle_jsp_text[38]);
      out.print(campo3);
      out.write(__oracle_jsp_text[39]);
      out.print(campo5);
      out.write(__oracle_jsp_text[40]);
       } 
      out.write(__oracle_jsp_text[41]);
      
      			if (contligas>0 && numPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[42]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[43]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[44]);
      	}
      			if (contPag > 0){  
      				if (contPag > contligas){
      out.write(__oracle_jsp_text[45]);
      out.print(contligas);
      out.write(__oracle_jsp_text[46]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[47]);
      	}else{
      out.write(__oracle_jsp_text[48]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[49]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[50]);
      	} 
      			}
      			if (numPaginas > 1){
      				for (int i=contligas; i<muestraPaginas+contligas && i<numPaginas; i++){ 
      					if (i==contPag){  
      out.write(__oracle_jsp_text[51]);
      out.print(i);
      out.write(__oracle_jsp_text[52]);
      out.print(i+1);
      out.write(__oracle_jsp_text[53]);
      		}else{ 
      out.write(__oracle_jsp_text[54]);
      out.print(i);
      out.write(__oracle_jsp_text[55]);
      out.print(i+1);
      out.write(__oracle_jsp_text[56]);
      		}
      				}
      			} 
      			if (contPag < numPaginas-1){  
      				if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[57]);
      out.print(contligas);
      out.write(__oracle_jsp_text[58]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[59]);
      	}else{
      out.write(__oracle_jsp_text[60]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[61]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[62]);
      	} 
      			}
      			if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[63]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[64]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[65]);
      	
      			} 
      out.write(__oracle_jsp_text[66]);
       } else { 
      out.write(__oracle_jsp_text[67]);
       } 
      out.write(__oracle_jsp_text[68]);

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
  private static final char __oracle_jsp_text[][]=new char[69][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML> \n<HEAD>\n".toCharArray();
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
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Valoración Documental</TITLE>\n<SCRIPT language=\"JavaScript\" src=\"../js/GeneralFunctions.js\"></SCRIPT>\n<script language=\"JavaScript\" type=\"text/javascript\">\n\tfunction cambio(o, t){\n\t\tdoc = document.valoracionv;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\n\tfunction validaReg() { \n\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\talert(\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\");\n\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t}\t\nfunction pagina(contador){\n\tdoc = document.valorv;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\n\nfunction paginaLiga(contador){\n\tdoc = document.valorv;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n</script>\n<STYLE type=text/css>\n\tBODY {\n\t\tmargin: 0px;\n\t}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"validaReg();timer_load();\" \n\tonKeyPress=\"timer_reload();\" \n\tonClick=\"timer_reload();\">\n<span id=\"ruler\" style=\"visibility:hidden;\"></span> \n<FORM action=\"ValorArchview.jsp\" name=\"valorv\" method=\"post\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"contligas\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"100%\" colspan=\"2\"></TD>\n    </TR>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"43%\">\n\t\t\t<A href=\"Archivado.jsp\">\n\t\t\t<IMG border=\"0\" alt=\"Regresar\" src=\"../Imagenes/NavLeft.gif\" width=\"30\" height=\"27\">\n\t\t\t</A>\n\t\t\t<A href=\"ValorArch.jsp?retURI=".toCharArray();
    __oracle_jsp_text[17] = 
    "\">\n\t\t\t<IMG height=\"26\" alt=\"Agregar Valoracion\" src=\"../Imagenes/nuevo1.gif\" width=\"27\" border=\"0\"></A>\n\t\t\t<FONT face=\"Tahoma\" size=\"2\">\n\t\t\t</FONT>\n\t\t\t<A href=\"javascript:Borrar()\">\n\t\t\t<IMG border=\"0\" alt=\"Borrar Valoracion\" src=\"../Imagenes/borrar1.gif\" width=\"30\" height=\"27\">\n\t\t\t</A>\n\t\t</TD>\n\t\t<TD width=\"57%\" align=\"right\" valign=\"middle\">\n\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t".toCharArray();
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
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n        </TD>\n    </TR>\n</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n<TBODY align=\"center\">\n\t<TR bgcolor=\"#00204f\">\n\t\t<TD align=\"center\" >&nbsp;\n\t\t\t\t\t<FONT size=\"2\" color=\"white\" face=\"verdana\">CATALOGO VALORES</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"100%\" colspan=\"2\"></TD>\n    </TR>\n</TABLE>\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR bgcolor=\"#00204f\">\n\t\t<TD width=\"15%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Clave</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n        </TD>\n\t\t<TD id=\"Asunto_HD\" width=\"30%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Nombre Valor</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n        </TD>\n        <TD id=\"Asunto_HD2\" width=\"40%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 3)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Descripción</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 3)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n        </TD>\n\t\t<TD width=\"15%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Estatus</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n        </TD>         \n    </TR>\n</TBODY>\n</TABLE>\n<DIV id=\"msg\"></DIV>\n<DIV id=\"view\">\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t<TR vAlign=\"middle\" ".toCharArray();
    __oracle_jsp_text[30] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[31] = 
    ">\n\t\t<TD width=\"15%\" >\n\t\t\t<INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[32] = 
    "\" name=\"Borrar\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t<A href=\"ValorArch.jsp?id_sub=".toCharArray();
    __oracle_jsp_text[33] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[34] = 
    "\">".toCharArray();
    __oracle_jsp_text[35] = 
    "</A>\n\t\t\t</FONT>\n\t\t</TD>\t\n\t\t<TD width=\"30%\" align=\"center\" >\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[36] = 
    "\"> <script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[37] = 
    "','Asunto_HD'));</script> </A>\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"40%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[38] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[39] = 
    "','Asunto_HD2'));</script> </A>\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"15%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\t\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t<TR>\n\t\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[43] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[44] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[46] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[47] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[49] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[50] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[52] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[53] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[55] = 
    ")\">".toCharArray();
    __oracle_jsp_text[56] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[58] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[59] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[61] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[62] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[64] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[65] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[66] = 
    "\n\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[67] = 
    "\n\t<TR> \n\t\t<TD width=\"100%\">\n\t\t\t<div align=center>\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">******No Hay Valoraciones capturadas******</FONT>\n\t\t\t</div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[68] = 
    "\n</TBODY>\n</TABLE>\n</DIV>\n<BR>\n\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
