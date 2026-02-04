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


public class _Bitacora extends com.orionserver.http.OrionHttpJspPage {


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
    _Bitacora page = this;
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
      
      out.write(__oracle_jsp_text[3]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[4]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[5]);
       } 
      out.write(__oracle_jsp_text[6]);
      
      	String strIdUsuario = "";
      	boolean bExiste 	= false;
      	String strNombre = "";
      	String stBit[][] = null;
      
      	String retURI 	= 	(request.getParameter("retURI")==null)?"UsuariosView.jsp":request.getParameter("retURI");
      	strIdUsuario 	= 	(request.getParameter("id_usuario")==null)?"":request.getParameter("id_usuario");
      	bExiste			=	ActualizaBitacora.getExisteBitacoraUsr(strIdUsuario);
      
      	String strOrden 	= (request.getParameter("orden")!=null)?request.getParameter("orden"):"desc";
      	String strTipo 		= (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"4";
      	String strAccion 	= (request.getParameter("accion")!=null)?request.getParameter("accion"):"";
      	String strFechaIni 	= (request.getParameter("fechaInicial")!=null)?request.getParameter("fechaInicial"):"";
      	String strFechaFin 	= (request.getParameter("fechaFinal")!=null)?request.getParameter("fechaFinal"):"";
      	String strDetalleEvento	= (request.getParameter("buscaEvento")!=null)?request.getParameter("buscaEvento"):"";
      	
      	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
      	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");
      
      	int regPorPagina = 30;
      	int muestraPaginas = 20;
      	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
      	if(strConfig != null && strConfig.length > 0){
      		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
      		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
      	}
      
      //	if(bExiste){
      //		stBit = ActualizaBitacora.getBitacoraUsuarioNombre(strIdUsuario);
      //		strNombre = ActualizaUsuario.NombreUsuario(stBit[0][0]);
      //	}
      	strNombre = ActualizaUsuario.NombreUsuario(strIdUsuario);
      	if (strNombre==null){
      		response.sendRedirect("UsuariosView.jsp");
      	}
      
      
      out.write(__oracle_jsp_text[7]);
      out.write(__oracle_jsp_text[8]);
      out.print(retURI );
      out.write(__oracle_jsp_text[9]);
      out.print(strOrden );
      out.write(__oracle_jsp_text[10]);
      out.print(strTipo );
      out.write(__oracle_jsp_text[11]);
      out.print(retURI );
      out.write(__oracle_jsp_text[12]);
      out.print(strIdUsuario );
      out.write(__oracle_jsp_text[13]);
      out.print(contPag );
      out.write(__oracle_jsp_text[14]);
      out.print(contligas );
      out.write(__oracle_jsp_text[15]);
      out.print(strAccion );
      out.write(__oracle_jsp_text[16]);
      out.print(strFechaIni );
      out.write(__oracle_jsp_text[17]);
      out.print(strFechaFin );
      out.write(__oracle_jsp_text[18]);
      out.print(strDetalleEvento );
      out.write(__oracle_jsp_text[19]);
      	if (bExiste && strAccion.equals("buscar")){ 
      out.write(__oracle_jsp_text[20]);
      	} 
      out.write(__oracle_jsp_text[21]);
      	if (!strAccion.equals("buscar")){ 
      out.write(__oracle_jsp_text[22]);
      	} 
      out.write(__oracle_jsp_text[23]);
      	if (bExiste && !strAccion.equals("buscar") && (!strFechaIni.equals("") || !strFechaFin.equals("") || !strDetalleEvento.equals(""))){ 
      out.write(__oracle_jsp_text[24]);
      	} 
      out.write(__oracle_jsp_text[25]);
      	if (bExiste && !strAccion.equals("buscar")){ 
      out.write(__oracle_jsp_text[26]);
      	} 
      out.write(__oracle_jsp_text[27]);
      	if (bExiste && !strFechaIni.equals("") && !strFechaFin.equals("") && !strAccion.equals("buscar")){ 
      out.write(__oracle_jsp_text[28]);
      out.print( strFechaIni );
      out.write(__oracle_jsp_text[29]);
      out.print( strFechaFin );
      out.write(__oracle_jsp_text[30]);
       }
      out.write(__oracle_jsp_text[31]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[32]);
       
      			if(bExiste && !strAccion.equals("buscar")){
      				String strBitacoraDatos[][] = ActualizaBitacora.getBitacoraUsuario(strIdUsuario,strOrden,strTipo,strFechaIni,strFechaFin,strDetalleEvento);	
      
      				int numeroPaginas = strBitacoraDatos.length/regPorPagina;	
      				if (strBitacoraDatos.length%regPorPagina != 0)
      					numeroPaginas++; 
      out.write(__oracle_jsp_text[33]);
      	if (strBitacoraDatos.length > 0){	
      out.write(__oracle_jsp_text[34]);
      out.print( strBitacoraDatos.length );
      out.write(__oracle_jsp_text[35]);
      	} 
      out.write(__oracle_jsp_text[36]);
      	if (numeroPaginas > 1){	
      out.write(__oracle_jsp_text[37]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[38]);
      out.print( numeroPaginas );
      out.write(__oracle_jsp_text[39]);
       	} 
      out.write(__oracle_jsp_text[40]);
      } 
      out.write(__oracle_jsp_text[41]);
       	if (!strAccion.equals("buscar")) {
      out.write(__oracle_jsp_text[42]);
       	} else { 
      out.write(__oracle_jsp_text[43]);
      out.print( strFechaIni );
      out.write(__oracle_jsp_text[44]);
      out.print( strFechaFin );
      out.write(__oracle_jsp_text[45]);
      out.print( strDetalleEvento );
      out.write(__oracle_jsp_text[46]);
       	} 
      out.write(__oracle_jsp_text[47]);
       
      		if(bExiste && !strAccion.equals("buscar")){
      
      		String strBitacoraDatos[][] = ActualizaBitacora.getBitacoraUsuario(strIdUsuario,strOrden,strTipo,strFechaIni,strFechaFin,strDetalleEvento);
      		int numeroPaginas = strBitacoraDatos.length/regPorPagina;
      		if (strBitacoraDatos.length%regPorPagina != 0)
      			numeroPaginas++; 
      
      		if (numeroPaginas == 0){
      out.write(__oracle_jsp_text[48]);
       }
      		for(int i=contPag*regPorPagina; i<strBitacoraDatos.length && i<(contPag+1)*regPorPagina; i++){ 
      out.write(__oracle_jsp_text[49]);
       int a = i+1; 
      out.write(__oracle_jsp_text[50]);
      if(par(a)==true){
      }else{
      out.write(__oracle_jsp_text[51]);
      }
      out.write(__oracle_jsp_text[52]);
      out.print(i+1);
      out.write(__oracle_jsp_text[53]);
      out.print(strBitacoraDatos[i][1]);
      out.write(__oracle_jsp_text[54]);
      out.print(strBitacoraDatos[i][2]);
      out.write(__oracle_jsp_text[55]);
       } 
      out.write(__oracle_jsp_text[56]);
      
      				if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[57]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[58]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[59]);
      	}
      				if (contPag > 0){  
      					if (contPag > contligas){
      out.write(__oracle_jsp_text[60]);
      out.print(contligas);
      out.write(__oracle_jsp_text[61]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[62]);
      	}else{
      out.write(__oracle_jsp_text[63]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[64]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[65]);
      	} 
      				}
      				if (numeroPaginas > 1){
      					for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
      						if (i==contPag){  
      out.write(__oracle_jsp_text[66]);
      out.print(i);
      out.write(__oracle_jsp_text[67]);
      out.print(i+1);
      out.write(__oracle_jsp_text[68]);
      		}else{ 
      out.write(__oracle_jsp_text[69]);
      out.print(i);
      out.write(__oracle_jsp_text[70]);
      out.print(i+1);
      out.write(__oracle_jsp_text[71]);
      		}
      					}
      				} 
      				if (contPag < numeroPaginas-1){  
      					if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[72]);
      out.print(contligas);
      out.write(__oracle_jsp_text[73]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[74]);
      	}else{
      out.write(__oracle_jsp_text[75]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[76]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[77]);
      	} 
      				}
      				if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[78]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[79]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[80]);
      	
      				} 
      out.write(__oracle_jsp_text[81]);
       }else if(!strAccion.equals("buscar")){ 
      out.write(__oracle_jsp_text[82]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[83]);
       } 
      out.write(__oracle_jsp_text[84]);

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
  private static final char __oracle_jsp_text[][]=new char[85][];
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
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>botácora</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n\nfunction regresarBit(){\n\tdoc=document.bitacora1;\n\tlocation.assign(\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\");\n}\n\nfunction cambio(o, t){\n\tdoc = document.bitacora1;\n\tdoc.orden.value=o;\n\tdoc.tipo.value=t;\n\tdoc.submit();\n}\n\nfunction pagina(contador){\n\tdoc = document.bitacora1;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\n\nfunction paginaLiga(contador){\n\tdoc = document.bitacora1;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n\nfunction verBuscar(){\n\tdoc = document.bitacora1;\t\n\tdoc.accion.value=\"buscar\";\n\tdoc.submit();\n}\n\nfunction cancelar(){\n\tdoc = document.bitacora1;\t\n\tdoc.accion.value=\"\";\n\tdoc.submit();\n}\n\nfunction verTodosRegistros(){\n\tdoc = document.bitacora1;\n\tdoc.accion.value=\"\";\n\tdoc.fechaInicial.value = \"\";\n\tdoc.fechaFinal.value = \"\";\n\tdoc.buscaEvento.value = \"\";\n\tpagina(0);\n\tpaginaLiga(0);\n\tdoc.submit();\n}\n\nfunction borrarCampos(){\n\tdoc = document.bitacora1;\n\tdoc.fechaDe.value=\"\";\n\tdoc.fechaA.value=\"\";\n\tdoc.detalle.value=\"\";\n}\n\nfunction buscarRegistros(){\n\tdoc = document.bitacora1;\n\tvalida = 0;\n\tmsg=\"\";\n\t\n\tdoc.detalle.value = Trim(doc.detalle.value);\n\t\n\t/*if (Trim(doc.fechaDe.value) ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \"Debe capturar la Fecha Inicial \"+ \"\\n\";\n\t}\n\tif (Trim(doc.fechaA.value) ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \"Debe capturar la Fecha Final \"+ \"\\n\";\n\t}*/\n\tif (comparaFechas(doc.fechaDe.value,getfechaActual())==1) {\n\t\tvalida =1;\n\t\tmsg = msg + \"La Fecha Inicial debe ser menor o igual a la actual\"+ \"\\n\";\n\t}\n\tif (comparaFechas(doc.fechaA.value,getfechaActual())==1) {\n\t\tvalida =1;\n\t\tmsg = msg + \"La Fecha Final debe ser menor o igual a la actual\"+ \"\\n\";\n\t}\n\tif (valida!=1 && Trim(doc.fechaDe.value)!=\"\" && Trim(doc.fechaA.value)!=\"\" && comparaFechas(doc.fechaDe.value,doc.fechaA.value)==1) {\n\t\tvalida =1;\n\t\tmsg = msg + \"La Fecha Inicial debe ser menor o igual a la Fecha Final \"+ \"\\n\";\n\t}\n\tif (detectaCEBusquedaB(doc.detalle.value)){\n\t\tvalida = 1;\n\t\tmsg = msg + \"No son permitidos los caracteres ( ' & < >  `  ´  ) \"+ \"\\n\";\n\t}\t\n\tif( doc.detalle.value == '\"'){\n\t\tvalida = 1;\n\t\tmsg = msg + \"No esta permitido colocar solo una comilla \" + \"\\n\";\n\t}\n\tif (valida == 1){\n\t\talert(msg);\n\t}\n\telse{\n\t\tdoc.accion.value = \"\";\n\t\tdoc.fechaInicial.value = doc.fechaDe.value;\n\t\tdoc.fechaFinal.value = doc.fechaA.value;\n\t\tdoc.buscaEvento.value = doc.detalle.value;\n\t\tpagina(0);\n\t\tpaginaLiga(0);\n\t\tdoc.submit();\n\t}\n}\n\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"Bitacora.jsp\" name=\"bitacora1\" method=\"post\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"retURI\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"id_usuario\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"contligas\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"fechaInicial\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"fechaFinal\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"buscaEvento\">\n<DIV align=\"center\">\n<table border=\"0\" width=\"874\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD width=\"50%\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Cancelar\" onclick=\"cancelar()\">\n\t\t\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Borrar\" onclick=\"borrarCampos()\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Regresar\" onclick=\"regresarBit()\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Ver Todo\" onclick=\"verTodosRegistros();\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Buscar\" onclick=\"verBuscar();\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"50%\" align=\"right\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t\t&nbsp;&nbsp;<B> Resultados del ".toCharArray();
    __oracle_jsp_text[29] = 
    " al ".toCharArray();
    __oracle_jsp_text[30] = 
    " </B>\n\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</table>\n<br>\n<table border=\"0\" width=\"874\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD width=\"75%\"><b><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tBitacora de Acceso del Usuario: ".toCharArray();
    __oracle_jsp_text[32] = 
    " </FONT></b>\n\t\t\t</TD>\n\t\t\t<TD width=\"25%\" align=\"right\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    " registros mostrados.\n\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[38] = 
    " de ".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</table>\n</DIV>\n<DIV align=\"center\">\n<table border=\"0\" width=\"874\">\n\t<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t<TR bgcolor=\"#004080\">\n\t\t\t<TD width=\"75%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Evento</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t\t<TD width=\"25%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Fecha del Evento</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t<TR bgcolor=\"#004080\">\n\t\t\t<TD width=\"75%\" align=\"center\" colspan=\"2\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Buscar por Fecha</FONT></b>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</table>\n<table border=\"0\" width=\"874\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD width=\"25%\" colspan=\"2\" align=\"left\">\n\t\t\t\t<BR>\n\t\t\t\t<A onclick=\"buscarRegistros()\" title=\"Buscar Evento\">\n\t\t\t\t<FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Buscar Evento</B></FONT>\t\t\t\t\n\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/ico_bus.gif\" width=\"26\" height=\"26\"></A>\n\t\t\t\t<BR>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD colspan=\"2\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD width=\"25%\">\n\t\t\t\t<FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Fecha Inicial: &nbsp;</B></FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"75%\">\n\t\t\t\t<INPUT class=\"blue100\"  name=\"fechaDe\" onfocus=\"blur();\" value=\"".toCharArray();
    __oracle_jsp_text[44] = 
    "\">\n\t\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" \n\t\t\t\t\tonclick='show_calendar(\"forms[0].fechaDe\");'></A> \n\t\t\t\t<BR>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD colspan=\"2\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD width=\"25%\">\n\t\t\t\t<FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Fecha Final: &nbsp;</B></FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"75%\">\n\t\t\t\t<INPUT class=\"blue100\"  name=\"fechaA\" onfocus=\"blur();\" value=\"".toCharArray();
    __oracle_jsp_text[45] = 
    "\">\n\t\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" \n\t\t\t\t\tonclick='show_calendar(\"forms[0].fechaA\");'></A>\n\t\t\t\t<BR>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD colspan=\"2\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD width=\"25%\">\n\t\t\t\t<FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Detalle del Evento:&nbsp;</B></FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"75%\">\n\t\t\t\t<INPUT class=\"blue500\" name=\"detalle\" value=\"".toCharArray();
    __oracle_jsp_text[46] = 
    "\">\n\t\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t</TBODY>\n</table>\n</DIV>\n<BR>\n<DIV class=documentBody id=Body>\n<DIV align=\"center\">\n<table border=\"0\" width=\"874\" cellpadding=\"0\">\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\" colspan=\"2\" align=\"center\"><FONT size=\"2\" color=\"red\" face=\"verdana\"> \n\t\t\t<BR>\n\t\t\t<BR>\n\t\t\t**** No hay registros en la bitacora para esta consulta **** \n\t\t\t</FONT></TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t<TR ".toCharArray();
    __oracle_jsp_text[51] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[52] = 
    ">\n\t\t\t<TD width=\"5%\"><FONT size=\"1\" color=\"#00204f\" face=\"verdana\">  ".toCharArray();
    __oracle_jsp_text[53] = 
    ".- </FONT></TD>\n\t\t\t<TD width=\"70%\"><FONT size=\"1\" color=\"#00204f\" face=\"verdana\"> ".toCharArray();
    __oracle_jsp_text[54] = 
    " </FONT></TD>\n\t\t\t<TD align=\"center\" width=\"25%\"><FONT size=\"1\" color=\"#00204f\" face=\"verdana\"> ".toCharArray();
    __oracle_jsp_text[55] = 
    " </FONT></TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t<TR>\n\t\t\t<TD colspan=\"3\" align=\"center\"><BR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[58] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[59] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[61] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[62] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[64] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[65] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[66] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[67] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[68] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[69] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[70] = 
    ")\">".toCharArray();
    __oracle_jsp_text[71] = 
    "</A> &nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[72] = 
    "\n\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[73] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[74] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[75] = 
    "\n\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[76] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[77] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[79] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[80] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t\t".toCharArray();
    __oracle_jsp_text[81] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[82] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\" colspan=\"2\" align=\"center\"><FONT size=\"2\" color=\"red\" face=\"verdana\"> \n\t\t\t<BR>\n\t\t\t<BR>\n\t\t\t**** El Usuario &quot;".toCharArray();
    __oracle_jsp_text[83] = 
    "&quot; no tiene registros en la Bitacora **** \n\t\t\t</FONT></TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\t</TBODY>\n</table>\n</DIV>\n<br>\n</DIV>\n<BR>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
