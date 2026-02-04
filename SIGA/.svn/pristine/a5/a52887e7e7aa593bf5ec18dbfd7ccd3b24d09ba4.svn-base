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


public class _FoliosView extends com.orionserver.http.OrionHttpJspPage {


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
    _FoliosView page = this;
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
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      
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
      
      
      out.write(__oracle_jsp_text[6]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[7]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[8]);
       } 
      out.write(__oracle_jsp_text[9]);
      
      	boolean bOperacion = false;
      	String strIds_Borrar[] = null;
      	String strAccion = "";
      	int t = 0;
      	strAccion = request.getParameter("accion");
      	strIds_Borrar = request.getParameterValues("Borrar");
      	if (strAccion != null && strAccion.trim().length() > 0 && strAccion.equals("borrar")) {
      		bOperacion = ActualizaFolio.deleteFolio(strIds_Borrar,BUsuario.getIdUsuario());
      	}
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
      
      	Vector vRegistros = new Vector();
      	int numeroRegistros = 0;
      	String sql[][] = ActualizaFolio.getListaFolios(strOrden, strTipo);
      	if (sql!=null && sql.length>0){
      		for (int ix=0; ix<sql.length; ix++){
      			if(BUsuario.getAdmon() || BUsuario.getIdArea().equals(sql[ix][8])){ 
      				numeroRegistros++;
      				vRegistros.addElement(sql[ix]);
      			}
      		}
      	}
      
      out.write(__oracle_jsp_text[10]);
      out.write(__oracle_jsp_text[11]);
      out.print( strOrden );
      out.write(__oracle_jsp_text[12]);
      out.print( strTipo );
      out.write(__oracle_jsp_text[13]);
      out.print( contPag );
      out.write(__oracle_jsp_text[14]);
      out.print( contligas );
      out.write(__oracle_jsp_text[15]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[16]);
       
      				if (vRegistros.size()>0){
      					int numeroPaginas = numeroRegistros/regPorPagina;	
      					if (numeroRegistros%regPorPagina != 0)
      						numeroPaginas++; 
      out.write(__oracle_jsp_text[17]);
      	if (numeroRegistros > 0){	
      out.write(__oracle_jsp_text[18]);
      out.print( numeroRegistros );
      out.write(__oracle_jsp_text[19]);
      	} 
      out.write(__oracle_jsp_text[20]);
      	if (numeroPaginas > 1){	
      out.write(__oracle_jsp_text[21]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[22]);
      out.print( numeroPaginas );
      out.write(__oracle_jsp_text[23]);
       	} 
      out.write(__oracle_jsp_text[24]);
      } 
      out.write(__oracle_jsp_text[25]);
       int j=0; 
      out.write(__oracle_jsp_text[26]);
       if (vRegistros.size()>0){ 
      out.write(__oracle_jsp_text[27]);
       	int numeroPaginas = numeroRegistros/regPorPagina;	
      			if (numeroRegistros%regPorPagina != 0)
      				numeroPaginas++; 
      
      		String [][] strDatos = 	ActualizaFolio.getListaFolios(strOrden, strTipo);
      		for (int i=contPag*regPorPagina; i<vRegistros.size() && i<(contPag+1)*regPorPagina; i++){
      
      			String sqlAux[] = (String[])vRegistros.get(i);
      			strDatos[i]=sqlAux;
      
      			String Lista1 = strDatos[i][0];
      			String Lista2 = strDatos[i][1];
      			String Lista3 = strDatos[i][2];
      			String Lista4 = strDatos[i][3];
      			String Lista5 = strDatos[i][4];
      			String Lista6 = strDatos[i][5];
      			String Lista7 = strDatos[i][6];
      			String Lista8 = strDatos[i][7];
      			String Lista9 = strDatos[i][8];
      	
      out.write(__oracle_jsp_text[28]);
       if(	BUsuario.getAdmon() ||
      			BUsuario.getIdArea().equals(Lista9)){ 
      out.write(__oracle_jsp_text[29]);
       t++; 
      out.write(__oracle_jsp_text[30]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[31]);
      }
      out.write(__oracle_jsp_text[32]);
      out.print(Lista1 );
      out.write(__oracle_jsp_text[33]);
      out.print(Lista1 );
      out.write(__oracle_jsp_text[34]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[35]);
      out.print(Lista2);
      out.write(__oracle_jsp_text[36]);
      out.print(Lista2);
      out.write(__oracle_jsp_text[37]);
      out.print(Lista3);
      out.write(__oracle_jsp_text[38]);
      out.print(Lista4);
      out.write(__oracle_jsp_text[39]);
      out.print(Lista4);
      out.write(__oracle_jsp_text[40]);
       j++; 
      out.write(__oracle_jsp_text[41]);
       } 
      out.write(__oracle_jsp_text[42]);
       } 
      out.write(__oracle_jsp_text[43]);
       if(j==0){ 
      out.write(__oracle_jsp_text[44]);
       } else {
      out.write(__oracle_jsp_text[45]);
      
      			if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[46]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[47]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[48]);
      	}
      			if (contPag > 0){  
      				if (contPag > contligas){
      out.write(__oracle_jsp_text[49]);
      out.print(contligas);
      out.write(__oracle_jsp_text[50]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[51]);
      	}else{
      out.write(__oracle_jsp_text[52]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[53]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[54]);
      	} 
      			}
      			if (numeroPaginas > 1){
      				for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
      					if (i==contPag){  
      out.write(__oracle_jsp_text[55]);
      out.print(i);
      out.write(__oracle_jsp_text[56]);
      out.print(i+1);
      out.write(__oracle_jsp_text[57]);
      		}else{ 
      out.write(__oracle_jsp_text[58]);
      out.print(i);
      out.write(__oracle_jsp_text[59]);
      out.print(i+1);
      out.write(__oracle_jsp_text[60]);
      		}
      				}
      			} 
      			if (contPag < numeroPaginas-1){  
      				if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[61]);
      out.print(contligas);
      out.write(__oracle_jsp_text[62]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[63]);
      	}else{
      out.write(__oracle_jsp_text[64]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[65]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[66]);
      	} 
      			}
      			if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[67]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[68]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[69]);
      	
      			} 
      out.write(__oracle_jsp_text[70]);
       } 
      out.write(__oracle_jsp_text[71]);
       } 
      out.write(__oracle_jsp_text[72]);

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
  private static final char __oracle_jsp_text[][]=new char[73][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Folios</TITLE>\n".toCharArray();
    __oracle_jsp_text[4] = 
    "  \n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT language=\"JavaScript\" src=\"../js/GeneralFunctions.js\"></SCRIPT>\n<script language=\"JavaScript\" type=\"text/javascript\">\n\tfunction cambio(o, t){\n\t\tdoc = document.FoliosView;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\nfunction pagina(contador){\n\tdoc = document.FoliosView;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\n\nfunction paginaLiga(contador){\n\tdoc = document.FoliosView;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n\nfunction BorrarFolios(){\n\tdoc=document.forms[0];\n\tvar form = document.forms[0]; \n\tvar cadena=\"\";\n\n\tfor (var i = 0; i < form.elements.length; i++) \n\t{  \n\t\tif (form.elements[i].type == 'checkbox') \n\t\t{      \n\t\t\tif (form.elements[i].name == 'Borrar') \n\t\t\t{       \n\t\t\t\tif (form.elements[i].checked == true)\n\t\t\t\t{\n\t\t\t\t\tvalor = form.elements[i].value;\n\t\t\t\t\tif(valor != \"\") \n\t\t\t\t\t\tcadena = cadena +valor + ' ';        \n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\tif (cadena == \"\") \n\talert(\"Debe seleccionar un Registro\");\n\telse \n\t{\n\t\tif (confirm(\"El Folio es requerido en el proceso de gestión,\\nsi se elimina(n) provocará una inconsistencia.\\n\\nestá usted seguro de que desea borrar el/los Registro(s)?\")) \n\t\t{    \n\t\t\t doc.accion.value=\"borrar\";\n\t\t\t doc.submit();\n\t\t} \n\t\telse \n\t\t\talert(\"Su petición de borrado ya fue cancelada\");\n\t}\n}\n\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<span id=\"ruler\" style=\"visibility:hidden;\"></span> \n<FORM action=\"FoliosView.jsp\" name=\"FoliosView\" method=\"get\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"contligas\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD width=\"40%\"><A href=\"Folios.jsp?retURI=".toCharArray();
    __oracle_jsp_text[16] = 
    "\" target=\"_self\"> <IMG height=\"26\"\n\t\t\t\tsrc=\"../Imagenes/nuevo1.gif\" width=\"27\" border=\"0\" alt=\"Nuevo Folio\">\n\t\t\t</A> <FONT face=\"Tahoma\" size=\"2\"></FONT> <A\n\t\t\t\tonclick=\"BorrarFolios();\" target=\"_self\"><IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/borrar1.gif\" width=\"30\" height=\"27\"\n\t\t\t\talt=\"Borrar Folio(s)\"></A></TD>\n\t\t\t<TD width=\"50%\">\n\t\t\t<DIV align=\"right\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    " registros mostrados.\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[22] = 
    " de ".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t</DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"10%\"> &nbsp;\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR bgcolor=\"#00204f\">\n\t\t\t<TD id=\"Asunto_HD\" width=\"35%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Unidad Administrativa</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t\t<TD width=\"35%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Tipo de Folio</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t\t<TD id=\"Asunto_HD2\" width=\"30%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 3)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Clave</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 3)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV class=documentBody id=Body>\n<DIV id=\"view\"><BR>\n".toCharArray();
    __oracle_jsp_text[26] = 
    "\n".toCharArray();
    __oracle_jsp_text[27] = 
    "\n<TABLE width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t<TR valign=\"top\" ".toCharArray();
    __oracle_jsp_text[31] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[32] = 
    ">\n\t\t\t<TD width=\"100%\">\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"35%\"><INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[33] = 
    "\"\n\t\t\t\t\t\tname=\"Borrar\"> <IMG height=1 src=\"../Imagenes/ecblank.gif\"\n\t\t\t\t\t\twidth=16 border=0><FONT face=Arial color=#000080 size=1> <A\n\t\t\t\t\t\thref=\"Folios.jsp?accion=consultar&folio_idFolio=".toCharArray();
    __oracle_jsp_text[34] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[35] = 
    "\" \n\t\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[36] = 
    "\">\n\t\t\t\t\t\t\t<script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[37] = 
    "','Asunto_HD'));</script>\n\t\t\t\t\t\t\t</A>\n\t\t\t\t\t</FONT></td>\n\t\t\t\t\t<td width=\"35%\" align=\"center\" valign=\"middle\">".toCharArray();
    __oracle_jsp_text[38] = 
    "</td>\n\t\t\t\t\t<td width=\"30%\" align=\"center\" valign=\"middle\"><A title=\"".toCharArray();
    __oracle_jsp_text[39] = 
    "\">\n\t\t\t\t\t<script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[40] = 
    "','Asunto_HD'));</script></A></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t<TR>\n\t\t<TD width=\"100%\">\n\t\t<div align=center><FONT face=\"verdana\" size=\"4\">******No hay Folios\n\t\tCapturados en su Unidad Administrativa ******</FONT></div>\n\t\t</TD>\n\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t<TR>\n\t\t<TD colspan=\"3\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[47] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[48] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[50] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[51] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[53] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[54] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[55] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[56] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[57] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[59] = 
    ")\">".toCharArray();
    __oracle_jsp_text[60] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[62] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[63] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[65] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[66] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[67] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[68] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[69] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[70] = 
    "\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[71] = 
    "\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[72] = 
    "\n</DIV>\n<BR>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
