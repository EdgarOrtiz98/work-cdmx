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


public class _RecepcionSolA extends com.orionserver.http.OrionHttpJspPage {


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
    _RecepcionSolA page = this;
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
      
      	boolean bMostrar	=	false;
      	boolean bExiste		=	true;
      	String IdsArea[][]	=	ActualizaAsunto.getIdsAreaPertenece();
      	int t = 0;
      	bExiste		=	ActualizaAsunto.getExistenAsuntos(BUsuario.getIdArea(), BUsuario.getIdUsuario());
      	String strAccion = request.getParameter("accion");
      	String strIdUsuario = (request.getParameter("idUs")!=null)?request.getParameter("idUs"):"";
      
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
      out.print( strIdUsuario );
      out.write(__oracle_jsp_text[10]);
      out.print( strOrden );
      out.write(__oracle_jsp_text[11]);
      out.print( strTipo );
      out.write(__oracle_jsp_text[12]);
      out.print( contPag );
      out.write(__oracle_jsp_text[13]);
      out.print( contligas );
      out.write(__oracle_jsp_text[14]);
       if(bExiste){ 
      out.write(__oracle_jsp_text[15]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaAsunto.AsuntosPorSolicitanteInternos());
        __jsp_taghandler_1.setCampo("campo");
        java.lang.String campo1 = null;
        java.lang.String campo2 = null;
        java.lang.String campo3 = null;
        java.lang.String campo4 = null;
        java.lang.String campo5 = null;
        java.lang.String campo6 = null;
        java.lang.String campo7 = null;
        java.lang.String campo8 = null;
        java.lang.String campo9 = null;
        java.lang.String campo10 = null;
        java.lang.String campo11 = null;
        java.lang.String campo12 = null;
        java.lang.String campo13 = null;
        java.lang.String campo14 = null;
        java.lang.String campo15 = null;
        java.lang.String campo16 = null;
        java.lang.String campo17 = null;
        java.lang.String campo18 = null;
        java.lang.String campo19 = null;
        java.lang.String campo20 = null;
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_1,__jsp_tag_starteval,out);
          do {
            campo1 = (java.lang.String) pageContext.findAttribute("campo1");
            campo2 = (java.lang.String) pageContext.findAttribute("campo2");
            campo3 = (java.lang.String) pageContext.findAttribute("campo3");
            campo4 = (java.lang.String) pageContext.findAttribute("campo4");
            campo5 = (java.lang.String) pageContext.findAttribute("campo5");
            campo6 = (java.lang.String) pageContext.findAttribute("campo6");
            campo7 = (java.lang.String) pageContext.findAttribute("campo7");
            campo8 = (java.lang.String) pageContext.findAttribute("campo8");
            campo9 = (java.lang.String) pageContext.findAttribute("campo9");
            campo10 = (java.lang.String) pageContext.findAttribute("campo10");
            campo11 = (java.lang.String) pageContext.findAttribute("campo11");
            campo12 = (java.lang.String) pageContext.findAttribute("campo12");
            campo13 = (java.lang.String) pageContext.findAttribute("campo13");
            campo14 = (java.lang.String) pageContext.findAttribute("campo14");
            campo15 = (java.lang.String) pageContext.findAttribute("campo15");
            campo16 = (java.lang.String) pageContext.findAttribute("campo16");
            campo17 = (java.lang.String) pageContext.findAttribute("campo17");
            campo18 = (java.lang.String) pageContext.findAttribute("campo18");
            campo19 = (java.lang.String) pageContext.findAttribute("campo19");
            campo20 = (java.lang.String) pageContext.findAttribute("campo20");
            out.write(__oracle_jsp_text[16]);
             if (	(campo2.equals("1") && BUsuario.getIdArea().equals((ActualizaUsuario.getIdUsrArea(campo1)==null)?"":ActualizaUsuario.getIdUsrArea(campo1))) || 
            					(campo2.equals("0") && BUsuario.getIdArea().equals((ActualizaRemitente.getIdArea(campo1)==null)?"":ActualizaRemitente.getIdArea(campo1)))){ 
            out.write(__oracle_jsp_text[17]);
            bMostrar = strIdUsuario.equals(campo1);
            out.write(__oracle_jsp_text[18]);
            out.print(campo1);
            out.write(__oracle_jsp_text[19]);
            out.print((bMostrar)?"collapse.gif":"expand.gif");
            out.write(__oracle_jsp_text[20]);
             if(campo2.equals("1")){ 
            out.write(__oracle_jsp_text[21]);
            out.print( ActualizaUsuario.NombreUsuario(campo1) );
            out.write(__oracle_jsp_text[22]);
             }else{ 
            out.write(__oracle_jsp_text[23]);
            out.print( ActualizaRemitente.getNombreRemitente(campo1) );
            out.write(__oracle_jsp_text[24]);
             } 
            out.write(__oracle_jsp_text[25]);
            if(bMostrar)
            	  		{  
            			
            out.write(__oracle_jsp_text[26]);
            	numRegistros = ActualizaAsunto.getRemitenteAsunto(campo2, campo1, strOrden, strTipo).length;
            					if (numRegistros>0){ 
            out.write(__oracle_jsp_text[27]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[28]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[29]);
            	} 
            out.write(__oracle_jsp_text[30]);
            	numPaginas = numRegistros/regPorPagina;	
            					if (numRegistros%regPorPagina != 0)
            						numPaginas++; 
            out.write(__oracle_jsp_text[31]);
            	if (numRegistros > 0){	
            out.write(__oracle_jsp_text[32]);
            out.print( numRegistros );
            out.write(__oracle_jsp_text[33]);
            	} 
            out.write(__oracle_jsp_text[34]);
            	if (numPaginas > 1){	
            out.write(__oracle_jsp_text[35]);
            out.print( contPag+1 );
            out.write(__oracle_jsp_text[36]);
            out.print( numPaginas );
            out.write(__oracle_jsp_text[37]);
             	} 
            out.write(__oracle_jsp_text[38]);
            	String[][] sql = ActualizaAsunto.getRemitenteAsunto(campo2, campo1, strOrden, strTipo);
            				for (int ix=contPag*regPorPagina; ix<sql.length && ix<(contPag+1)*regPorPagina; ix++){
            					String usuario1 = sql[ix][0];
            					String usuario2 = sql[ix][1];
            					String usuario3 = sql[ix][2];
            					String usuario4 = sql[ix][3];
            					String usuario5 = sql[ix][4];
            					String usuario6 = sql[ix][5];
            			
            out.write(__oracle_jsp_text[39]);
             t++; 
            out.write(__oracle_jsp_text[40]);
            if(par(t)==true){
            }else{
            out.write(__oracle_jsp_text[41]);
            }
            out.write(__oracle_jsp_text[42]);
            out.print( usuario1 );
            out.write(__oracle_jsp_text[43]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas+"&orden="+strOrden+"&tipo="+strTipo) );
            out.write(__oracle_jsp_text[44]);
            out.print( usuario2 );
            out.write(__oracle_jsp_text[45]);
            out.print( usuario3 );
            out.write(__oracle_jsp_text[46]);
            out.print(Utilerias.formatearFechas(usuario6));
            out.write(__oracle_jsp_text[47]);
            	} 
            out.write(__oracle_jsp_text[48]);
            
            				if (contligas>0 && numPaginas > muestraPaginas){  
            out.write(__oracle_jsp_text[49]);
            out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
            out.write(__oracle_jsp_text[50]);
            out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
            out.write(__oracle_jsp_text[51]);
            	}
            				if (contPag > 0){  
            					if (contPag > contligas){
            out.write(__oracle_jsp_text[52]);
            out.print(contligas);
            out.write(__oracle_jsp_text[53]);
            out.print(contPag-1);
            out.write(__oracle_jsp_text[54]);
            	}else{
            out.write(__oracle_jsp_text[55]);
            out.print(contligas-1);
            out.write(__oracle_jsp_text[56]);
            out.print(contPag-1);
            out.write(__oracle_jsp_text[57]);
            	} 
            				}
            				if (numPaginas > 1){
            					for (int ik=contligas; ik<muestraPaginas+contligas && ik<numPaginas; ik++){ 
            						if (ik==contPag){  
            out.write(__oracle_jsp_text[58]);
            out.print(ik);
            out.write(__oracle_jsp_text[59]);
            out.print(ik+1);
            out.write(__oracle_jsp_text[60]);
            		}else{ 
            out.write(__oracle_jsp_text[61]);
            out.print(ik);
            out.write(__oracle_jsp_text[62]);
            out.print(ik+1);
            out.write(__oracle_jsp_text[63]);
            		}
            					}
            				} 
            				if (contPag < numPaginas-1){  
            					if (contPag < contligas + muestraPaginas-1){
            out.write(__oracle_jsp_text[64]);
            out.print(contligas);
            out.write(__oracle_jsp_text[65]);
            out.print(contPag+1);
            out.write(__oracle_jsp_text[66]);
            	}else{
            out.write(__oracle_jsp_text[67]);
            out.print(contligas+1);
            out.write(__oracle_jsp_text[68]);
            out.print(contPag+1);
            out.write(__oracle_jsp_text[69]);
            	} 
            				}
            				if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){  
            out.write(__oracle_jsp_text[70]);
            out.print( numPaginas-muestraPaginas );
            out.write(__oracle_jsp_text[71]);
            out.print( numPaginas-1 );
            out.write(__oracle_jsp_text[72]);
            	
            				} 
            out.write(__oracle_jsp_text[73]);
             
            	  		}
            		   }
            			
            out.write(__oracle_jsp_text[74]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[75]);
       
      		}else{ 
      	
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Ordenados por Remitentes Internos</TITLE>\n<script language=\"JavaScript\" type=\"text/javascript\">\nfunction desplegar(id){\n\tdoc = document.recepcionSolA;\n\tdoc.accion.value=\"reload\";\n\tif (id==doc.idUs.value){\n\t\tdoc.idUs.value=0;\n\t\tdoc.submit();\n\t}else{\n\t\tdoc.idUs.value=id;\n\t\tdoc.contPag.value=0;\n\t\tdoc.contligas.value=0;\n\t\tdoc.submit();\n\t}\n}\nfunction cambio(o, t){\n\tdoc = document.recepcionSolA;\n\tdoc.accion.value=\"reload\";\n\tdoc.orden.value=o;\n\tdoc.tipo.value=t;\n\tdoc.submit();\n}\nfunction pagina(contador){\n\tdoc = document.recepcionSolA;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\nfunction paginaLiga(contador){\n\tdoc = document.recepcionSolA;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM name=\"recepcionSolA\" action=\"RecepcionSolA.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\" name=\"idUs\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"contligas\">\n<TABLE>\n\t<TBODY>\n\t<TR>\n\t\t<TD align=\"left\" class=\"etiquetas\">\n\t\t<FONT size=\"3\"><B>Recepción por Remitentes Internos</B></FONT> \n\t\t</TD>\n\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='20%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">\n\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tFolio\n\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font></TD>\n\t\t<TD WIDTH='30%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">\n\t\t\t<a onclick=\"cambio('asc', 3)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tAsunto\n\t\t\t<a onclick=\"cambio('desc', 3)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font></TD>\n\t\t<TD WIDTH='30%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">\n\t\t\t<a onclick=\"cambio('asc', 7)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tFecha Recepción\n\t\t\t<a onclick=\"cambio('desc', 7)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font></TD>\n\t\t<TD WIDTH='20%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"Arial\">Estatus</font></TD>\n\t</TR>\n</TABLE>\n<br>\n<DIV class=documentBody id=Body>\n<table>\n\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td colspan=\"2\">\n\t\t\t\t<a onClick=\"desplegar(".toCharArray();
    __oracle_jsp_text[19] = 
    ")\">\n\t\t\t\t\t<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[20] = 
    "\"\n\t\t\t\t\tborder=\"0\" height=\"16\" width=\"16\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t\t</a>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"368\"></td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t<TR>\n\t\t\t\t<TD align=\"left\" colspan=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<A href=\"../ReporteAsuntoExcel?tip=recepcion_rem_int&id_remitente=".toCharArray();
    __oracle_jsp_text[28] = 
    "&control=".toCharArray();
    __oracle_jsp_text[29] = 
    "\">\n\t\t\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t\t\t</A>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t</TD>\n\t\t\t\t<TD align=\"right\" colspan=\"3\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    " registros mostrados.\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[36] = 
    " de ".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[41] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[42] = 
    ">\n\t\t\t\t\t<td width=\"2%\"></td>\n\t\t\t\t\t<td align=\"center\" width=\"18%\"><font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t<A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[43] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[44] = 
    "\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "</A></font>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td align=\"center\" width=\"30%\"><font size=\"1\" color=\"#000080\" face=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t\t\t\t</font></td>\n\t\t\t\t\t<td align=\"center\" width=\"30%\"><font size=\"1\" color=\"#000080\" face=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t\t\t\t</font></td>\n\t\t\t\t\t<td align=\"center\" width=\"20%\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/gris5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t<TR>\n\t\t\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[50] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[51] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[53] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[54] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[55] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[56] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[57] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[59] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[60] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[62] = 
    ")\">".toCharArray();
    __oracle_jsp_text[63] = 
    "</A> &nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\n\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[65] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[66] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[67] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[68] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[69] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[70] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[71] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[72] = 
    ");\"> <B>FINAL</B> </A>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "\n\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t</table>\n\t".toCharArray();
    __oracle_jsp_text[75] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[76] = 
    "\n\t<TR>\n\t\t<TD width=\"20%\">\n\t\t\t<div align=center>\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">******No Existen Asuntos******</FONT>\n\t\t\t</div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n</table>\n</DIV>\n</FORM>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
