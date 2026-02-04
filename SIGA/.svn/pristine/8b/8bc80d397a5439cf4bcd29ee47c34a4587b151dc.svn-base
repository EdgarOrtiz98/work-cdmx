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
import com.meve.sigma.util.*;


public class _TipoDocumentoView extends com.orionserver.http.OrionHttpJspPage {


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
    _TipoDocumentoView page = this;
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
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp);
      		}
      		catch(java.io.IOException io){;}
      	}
      
      
      out.write(__oracle_jsp_text[5]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[6]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[7]);
       } 
      out.write(__oracle_jsp_text[8]);
      
      	String [][] sql	=null;
      	boolean bOperacion		=	false;
      	Vector vTiene = new Vector();
      	String strIds_Borrar[]	=	null;
      	String strAccion		=	"";
      	int t = 0;
      	strAccion				=	request.getParameter("accion");
      	strIds_Borrar			=	request.getParameterValues("Borrar");
      	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar")){
      		vTiene			=	ActualizaTipo_Doc.deleteTipo_Doc(strIds_Borrar, BUsuario.getIdUsuario());	
      
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
      	sql = ActualizaTipo_Doc.getListaTipos_Doc(strOrden, strTipo);
      	if (sql!=null && sql.length>0){
      		for (int ix=0; ix<sql.length; ix++){
      			if(BUsuario.getAdmon() || BUsuario.getIdArea().equals(sql[ix][2])){ 
      				numeroRegistros++;
      				vRegistros.addElement(sql[ix]);
      			}
      		}
      	}
       
      out.write(__oracle_jsp_text[9]);
      out.write(__oracle_jsp_text[10]);
      out.print( strOrden );
      out.write(__oracle_jsp_text[11]);
      out.print( strTipo );
      out.write(__oracle_jsp_text[12]);
      out.print( contPag );
      out.write(__oracle_jsp_text[13]);
      out.print( contligas );
      out.write(__oracle_jsp_text[14]);
      if(vTiene.size()>0){
      out.write(__oracle_jsp_text[15]);
      for(int i=0;i<vTiene.size();i=i+2){
      out.write(__oracle_jsp_text[16]);
      out.print(ActualizaTipo_Doc.getNombreTipoDocto((String)vTiene.get(i)));
      out.write(__oracle_jsp_text[17]);
      out.print(Utilerias.recortaString(ActualizaTipo_Doc.getNombreTipoDocto((String)vTiene.get(i)),80));
      out.write(__oracle_jsp_text[18]);
      out.print((String)vTiene.get(i+1));
      out.write(__oracle_jsp_text[19]);
      }
      out.write(__oracle_jsp_text[20]);
      }
      out.write(__oracle_jsp_text[21]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[22]);
       
      				if (vRegistros.size()>0){
      					int numeroPaginas = numeroRegistros/regPorPagina;	
      					if (numeroRegistros%regPorPagina != 0)
      						numeroPaginas++; 
      out.write(__oracle_jsp_text[23]);
      	if (numeroRegistros > 0){	
      out.write(__oracle_jsp_text[24]);
      out.print( numeroRegistros );
      out.write(__oracle_jsp_text[25]);
      	} 
      out.write(__oracle_jsp_text[26]);
      	if (numeroPaginas > 1){	
      out.write(__oracle_jsp_text[27]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[28]);
      out.print( numeroPaginas );
      out.write(__oracle_jsp_text[29]);
       	} 
      out.write(__oracle_jsp_text[30]);
      } 
      out.write(__oracle_jsp_text[31]);
       int j = 0; 
      out.write(__oracle_jsp_text[32]);
      sql=ActualizaTipo_Doc.getListaTipos_Doc(strOrden, strTipo);
      out.write(__oracle_jsp_text[33]);
      if(vRegistros.size()==0){
      out.write(__oracle_jsp_text[34]);
      }else {
      			int numeroPaginas = numeroRegistros/regPorPagina;	
      			if (numeroRegistros%regPorPagina != 0)
      				numeroPaginas++; 
      
      			for (int i=contPag*regPorPagina; i<vRegistros.size() && i<(contPag+1)*regPorPagina; i++){
      
      				String sqlAux[] = (String[])vRegistros.get(i);
      				sql[i]=sqlAux;
      
      				String campo1 = sql[i][0];
      				String campo2 = sql[i][1];
      				String campo3 = sql[i][2];
      				String campo4 = sql[i][3];
      
      out.write(__oracle_jsp_text[35]);
       if(	BUsuario.getAdmon() ||
      			BUsuario.getIdArea().equals(campo3)){ 
      out.write(__oracle_jsp_text[36]);
       t++; 
      out.write(__oracle_jsp_text[37]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[38]);
      }
      out.write(__oracle_jsp_text[39]);
      out.print(campo2);
      out.write(__oracle_jsp_text[40]);
      out.print(campo2);
      out.write(__oracle_jsp_text[41]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[42]);
      out.print(campo1);
      out.write(__oracle_jsp_text[43]);
      out.print(campo1);
      out.write(__oracle_jsp_text[44]);
      out.print( campo4 );
      out.write(__oracle_jsp_text[45]);
      out.print(campo4);
      out.write(__oracle_jsp_text[46]);
       j++; 
      out.write(__oracle_jsp_text[47]);
       } 
      out.write(__oracle_jsp_text[48]);
       } 
      out.write(__oracle_jsp_text[49]);
       } 
      out.write(__oracle_jsp_text[50]);
       if(j==0){ 
      out.write(__oracle_jsp_text[51]);
       } else {
      out.write(__oracle_jsp_text[52]);
      
      			int numeroPaginas = (sql!=null)?numeroRegistros/regPorPagina:0;	
      			if (numeroRegistros%regPorPagina != 0)
      				numeroPaginas++; 
      			if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[53]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[54]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[55]);
      	}
      			if (contPag > 0){  
      				if (contPag > contligas){
      out.write(__oracle_jsp_text[56]);
      out.print(contligas);
      out.write(__oracle_jsp_text[57]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[58]);
      	}else{
      out.write(__oracle_jsp_text[59]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[60]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[61]);
      	} 
      			}
      			if (numeroPaginas > 1){
      				for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
      					if (i==contPag){  
      out.write(__oracle_jsp_text[62]);
      out.print(i);
      out.write(__oracle_jsp_text[63]);
      out.print(i+1);
      out.write(__oracle_jsp_text[64]);
      		}else{ 
      out.write(__oracle_jsp_text[65]);
      out.print(i);
      out.write(__oracle_jsp_text[66]);
      out.print(i+1);
      out.write(__oracle_jsp_text[67]);
      		}
      				}
      			} 
      			if (contPag < numeroPaginas-1){  
      				if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[68]);
      out.print(contligas);
      out.write(__oracle_jsp_text[69]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[70]);
      	}else{
      out.write(__oracle_jsp_text[71]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[72]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[73]);
      	} 
      			}
      			if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[74]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[75]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[76]);
      	
      			} 
      out.write(__oracle_jsp_text[77]);
       } 
      out.write(__oracle_jsp_text[78]);

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
  private static final char __oracle_jsp_text[][]=new char[79][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Tipo de Documento</TITLE>\n".toCharArray();
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
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT language=\"JavaScript\" src=\"../js/GeneralFunctions.js\"></SCRIPT>\n<script language=\"JavaScript\" type=\"text/javascript\">\n\tfunction cambio(o, t){\n\t\tdoc = document.TipoDocumentoView;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\nfunction pagina(contador){\n\tdoc = document.TipoDocumentoView;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\n\nfunction paginaLiga(contador){\n\tdoc = document.TipoDocumentoView;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<span id=\"ruler\" style=\"visibility:hidden;\"></span> \n<FORM action=\"TipoDocumentoView.jsp\" name=\"TipoDocumentoView\" method=\"post\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"contligas\">\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD width=\"43%\" class=\"etiquetas\">\n\t\t\t\t<FONT size=\"1\" color=\"RED\">\n\t\t\t\t&nbsp;&nbsp;No se pueden eliminar los siguientes Tipos de Documento (razones)<BR><BR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\">\n\t\t\t\t&nbsp;&nbsp;** ".toCharArray();
    __oracle_jsp_text[18] = 
    " **&nbsp;&nbsp;</A> tiene ".toCharArray();
    __oracle_jsp_text[19] = 
    "<BR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<br>\n".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"40%\"><A href=\"TipoDocumento.jsp?retURI=".toCharArray();
    __oracle_jsp_text[22] = 
    "\" \n\t\t\t\ttarget=\"_self\"> <IMG\n\t\t\t\theight=\"26\" src=\"../Imagenes/nuevo1.gif\" width=\"27\" border=\"0\"\n\t\t\t\talt=\"Nuevo Tipo de Asunto\"> </A> <FONT face=\"Tahoma\" size=\"2\"></FONT> <A\n\t\t\t\thref=\"javascript:Borrar()\" target=\"_self\"><IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/borrar1.gif\" width=\"30\" height=\"27\"\n\t\t\t\talt=\"Borrar Tipos de Asunto\"></A></TD>\n\t\t\t<TD width=\"50%\">\n\t\t\t<DIV align=\"right\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    " registros mostrados.\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[28] = 
    " de ".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t</DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"10%\"> &nbsp;\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n<TR bgcolor=\"#00204f\">\n<TD id=\"Asunto_HD\" width=\"50%\" align=\"center\">\n\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Tipo de Documento</FONT></b>\n\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n</TD>\n<TD id=\"Asunto_HD2\" width=\"50%\" align=\"center\">\n\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Unidad Administrativa</FONT></b>\n\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n</TD>\n</TR>\n</TBODY>\n</TABLE>\n<DIV class=documentBody id=Body>\n<DIV id=\"view\">\n".toCharArray();
    __oracle_jsp_text[32] = 
    "\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n  ".toCharArray();
    __oracle_jsp_text[33] = 
    "\n".toCharArray();
    __oracle_jsp_text[34] = 
    "\n".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t<TR ".toCharArray();
    __oracle_jsp_text[38] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[39] = 
    ">\n\t\t<TD width=\"50%\">\n    \t\t\t<INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[40] = 
    "\" name=\"Borrar\">\n    \t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t    \t<A href=\"TipoDocumento.jsp?id_tipo_doc=".toCharArray();
    __oracle_jsp_text[41] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[42] = 
    "\" \n\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[43] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[44] = 
    "','Asunto_HD'));</script></A>\n    \t\t\t</FONT>\n\t\t</TD>\n\t\t<TD\twidth=\"50%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1><A title=\"".toCharArray();
    __oracle_jsp_text[45] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[46] = 
    "','Asunto_HD2'));</script> </A></FONT>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t<TR>\n\t\t<TD width=\"100%\">\n\t\t<div align=center><FONT face=\"verdana\" size=\"4\">******No hay Tipo de Documentos\n\t\tCapturados en su Unidad Administrativa ******</FONT></div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t<TR>\n\t\t<TD colspan=\"3\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[54] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[55] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[57] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[58] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[60] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[61] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[63] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[64] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[66] = 
    ")\">".toCharArray();
    __oracle_jsp_text[67] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[69] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[70] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[71] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[72] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[73] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[75] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[76] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n    </TBODY>\n</TABLE>\n</DIV>\n<BR>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
