package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _ClasificacionArchSubview extends com.orionserver.http.OrionHttpJspPage {


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
    _ClasificacionArchSubview page = this;
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
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
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
      
      	boolean bExiste			=	false;
      	boolean bOperacion		=	false;
      	String strIds_Borrar[]	=	null;
      	String strAccion		=	"";
      	int bOperacion1		=	0;	
      	String msg				=	request.getParameter("msg");
      	int t = 0;
      	strAccion				=	request.getParameter("accion");
      	strIds_Borrar			=	request.getParameterValues("Borrar");
      
      	bExiste					=	ActualizaExpArchivado.getExisteClssub();	
      
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
      		bOperacion1	=	ActualizaExpArchivado.getDeleteClssub(strIds_Borrar,BUsuario.getIdUsuario());
      			if(bOperacion1 == 2)
      			{
      			msg ="Existen registros asociados, el proceso de borrado no fue exitoso";
      			}			
      	}
      	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
      
      out.write(__oracle_jsp_text[9]);
      out.write(__oracle_jsp_text[10]);
      if(msg!= null && msg.trim().length()>0)
      		{
      		
      out.write(__oracle_jsp_text[11]);
      out.print(msg);
      out.write(__oracle_jsp_text[12]);
      
      		}
      		
      out.write(__oracle_jsp_text[13]);
      out.print( strOrden );
      out.write(__oracle_jsp_text[14]);
      out.print( strTipo );
      out.write(__oracle_jsp_text[15]);
      out.print( contPag );
      out.write(__oracle_jsp_text[16]);
      out.print( contligas );
      out.write(__oracle_jsp_text[17]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[18]);
      	numRegistros = ActualizaExpArchivado.getDatosClasificacionsub(strOrden, strTipo).length; 
      out.write(__oracle_jsp_text[19]);
      	numPaginas = numRegistros/regPorPagina;	
      			if (numRegistros%regPorPagina != 0)
      				numPaginas++; 
      out.write(__oracle_jsp_text[20]);
      	if (numRegistros > 0){	
      out.write(__oracle_jsp_text[21]);
      out.print( numRegistros );
      out.write(__oracle_jsp_text[22]);
      	} 
      out.write(__oracle_jsp_text[23]);
      	if (numPaginas > 1){	
      out.write(__oracle_jsp_text[24]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[25]);
      out.print( numPaginas );
      out.write(__oracle_jsp_text[26]);
       	} 
      out.write(__oracle_jsp_text[27]);
       if(bExiste){ 
      out.write(__oracle_jsp_text[28]);
      	String[][] sql = ActualizaExpArchivado.getDatosClasificacionsub(strOrden, strTipo);
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
      				String campo11 = sql[i][10];
      				String campo12 = sql[i][11];
      				String campo13 = sql[i][12];
      		
      out.write(__oracle_jsp_text[29]);
       t++; 
      out.write(__oracle_jsp_text[30]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[31]);
      }
      out.write(__oracle_jsp_text[32]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[33]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[34]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[35]);
      out.print(campo3 );
      out.write(__oracle_jsp_text[36]);
      out.print(campo4);
      out.write(__oracle_jsp_text[37]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[38]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[39]);
      out.print(campo5 );
      out.write(__oracle_jsp_text[40]);
      out.print(campo6);
      out.write(__oracle_jsp_text[41]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[42]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[43]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[44]);
      out.print(campo8);
      out.write(__oracle_jsp_text[45]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[46]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[47]);
      out.print(campo9 );
      out.write(__oracle_jsp_text[48]);
      out.print(campo10);
      out.write(__oracle_jsp_text[49]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[50]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[51]);
      out.print( campo2 );
      out.write(__oracle_jsp_text[52]);
      out.print(campo11);
      out.write(__oracle_jsp_text[53]);
      out.print(campo11);
      out.write(__oracle_jsp_text[54]);
      out.print(campo12);
      out.write(__oracle_jsp_text[55]);
      out.print(campo12);
      out.write(__oracle_jsp_text[56]);
      out.print(campo13);
      out.write(__oracle_jsp_text[57]);
       } 
      out.write(__oracle_jsp_text[58]);
      
      			if (contligas>0 && numPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[59]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[60]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[61]);
      	}
      			if (contPag > 0){  
      				if (contPag > contligas){
      out.write(__oracle_jsp_text[62]);
      out.print(contligas);
      out.write(__oracle_jsp_text[63]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[64]);
      	}else{
      out.write(__oracle_jsp_text[65]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[66]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[67]);
      	} 
      			}
      			if (numPaginas > 1){
      				for (int i=contligas; i<muestraPaginas+contligas && i<numPaginas; i++){ 
      					if (i==contPag){  
      out.write(__oracle_jsp_text[68]);
      out.print(i);
      out.write(__oracle_jsp_text[69]);
      out.print(i+1);
      out.write(__oracle_jsp_text[70]);
      		}else{ 
      out.write(__oracle_jsp_text[71]);
      out.print(i);
      out.write(__oracle_jsp_text[72]);
      out.print(i+1);
      out.write(__oracle_jsp_text[73]);
      		}
      				}
      			} 
      			if (contPag < numPaginas-1){  
      				if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[74]);
      out.print(contligas);
      out.write(__oracle_jsp_text[75]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[76]);
      	}else{
      out.write(__oracle_jsp_text[77]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[78]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[79]);
      	} 
      			}
      			if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[80]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[81]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[82]);
      	
      			} 
      out.write(__oracle_jsp_text[83]);
       } else { 
      out.write(__oracle_jsp_text[84]);
       } 
      out.write(__oracle_jsp_text[85]);

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
  private static final char __oracle_jsp_text[][]=new char[86][];
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
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Instrumento</TITLE>\n<SCRIPT language=\"JavaScript\" src=\"../js/GeneralFunctions.js\"></SCRIPT>\n<script language=\"JavaScript\" type=\"text/javascript\">\n\tfunction cambio(o, t){\n\t\tdoc = document.clsSubview;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\n\tfunction validaReg() { \n\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\talert(\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\");\n\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t}\nfunction pagina(contador){\n\tdoc = document.clsSubview;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\n\nfunction paginaLiga(contador){\n\tdoc = document.clsSubview;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n</script>\n<STYLE type=text/css>\n\tBODY {\n\t\tmargin: 0px;\n\t}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"validaReg();timer_load();\" \n\tonKeyPress=\"timer_reload();\" \n\tonClick=\"timer_reload();\">\n<span id=\"ruler\" style=\"visibility:hidden;\"></span> \n<FORM action=\"ClasificacionArchSubview.jsp\" name=\"clsSubview\" method=\"post\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"contligas\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"100%\" colspan=\"2\"></TD>\n    </TR>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"43%\">\n\t\t\t<A href=\"Archivado.jsp\">\n\t\t\t<IMG border=\"0\" alt=\"Regresar\" src=\"../Imagenes/NavLeft.gif\" width=\"30\" height=\"27\">\n\t\t\t</A>\n\t\t\t<A href=\"ClasificacionArchSub.jsp?retURI=".toCharArray();
    __oracle_jsp_text[18] = 
    "\">\n\t\t\t\t<IMG height=\"26\" alt=\"Agregar SubSerie\" src=\"../Imagenes/nuevo1.gif\" width=\"27\" border=\"0\"></A>\n\t\t\t\t<FONT face=\"Tahoma\" size=\"2\">\n\t\t\t\t</FONT>\n\t\t\t\t<A href=\"javascript:Borrar()\">\n\t\t\t\t<IMG border=\"0\" alt=\"Borrar SubSerie\" src=\"../Imagenes/borrar1.gif\" width=\"30\" height=\"27\">\n\t\t\t\t</A>\n\t\t</TD>\n\t\t<TD width=\"57%\" align=\"right\" valign=\"middle\">\n\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    " registros mostrados.\n\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[25] = 
    " de ".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n        </TD>\n    </TR>\n</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n<TBODY align=\"center\">\n\t<TR bgcolor=\"#00204f\">\n\t\t<TD align=\"center\" >&nbsp;\n\t\t\t\t\t<FONT size=\"2\" color=\"white\" face=\"verdana\">CATALOGO SUBSERIES</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"100%\" colspan=\"2\"></TD>\n    </TR>\n</TABLE>\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR bgcolor=\"#00204f\">\n\n\t\t<TD width=\"10%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Cve Fondo</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n        </TD>\n\t\t<TD width=\"10%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Cve Subfondo</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n        </TD>\n\t\t<TD width=\"10%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 3)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Cve Sección</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 3)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n        </TD>\n\t\t<TD width=\"10%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Cve Serie</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n        </TD>\n\t\t<TD width=\"10%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 5)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Cve Subserie</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 5)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n        </TD>        \n        <TD id=\"Asunto_HD\" width=\"20%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 6)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Nombre Subserie</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 6)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n        </TD>\n        <TD id=\"Asunto_HD2\"  width=\"20%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 7)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Descripción</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 7)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n        </TD>\n        <TD width=\"10%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 8)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Estatus</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 8)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n        </TD>        \n    </TR>\n</TBODY>\n</TABLE>\n<DIV id=\"msg\"></DIV>\n<DIV id=\"view\">\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t<TR vAlign=\"middle\" ".toCharArray();
    __oracle_jsp_text[31] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[32] = 
    ">\n\t\t<TD width=\"10%\">\n    \t\t<INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[33] = 
    "\" name=\"Borrar\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t<A href=\"ClasificacionArchSub.jsp?id_sub=".toCharArray();
    __oracle_jsp_text[34] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[35] = 
    "\" class =\"etiquetas\" title= \"".toCharArray();
    __oracle_jsp_text[36] = 
    "\">".toCharArray();
    __oracle_jsp_text[37] = 
    "</A>\n\t\t\t</FONT>\n\t   \t</TD> \n\t\t<TD width=\"10%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t<A href=\"ClasificacionArchSub.jsp?id_sub=".toCharArray();
    __oracle_jsp_text[38] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[39] = 
    "\" class =\"etiquetas\" title= \"".toCharArray();
    __oracle_jsp_text[40] = 
    "\">".toCharArray();
    __oracle_jsp_text[41] = 
    "</A>\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"10%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t<A href=\"ClasificacionArchSub.jsp?id_sub=".toCharArray();
    __oracle_jsp_text[42] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[43] = 
    "\" class =\"etiquetas\" title= \"".toCharArray();
    __oracle_jsp_text[44] = 
    "\">".toCharArray();
    __oracle_jsp_text[45] = 
    "</A>\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"10%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t<A href=\"ClasificacionArchSub.jsp?id_sub=".toCharArray();
    __oracle_jsp_text[46] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[47] = 
    "\" class =\"etiquetas\" title= \"".toCharArray();
    __oracle_jsp_text[48] = 
    "\">".toCharArray();
    __oracle_jsp_text[49] = 
    "</A>\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"10%\" align=\"center\">\n\t\t    <FONT face=Arial color=#000080 size=1>\n\t\t    <A href=\"ClasificacionArchSub.jsp?id_sub=".toCharArray();
    __oracle_jsp_text[50] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[51] = 
    "\">".toCharArray();
    __oracle_jsp_text[52] = 
    "</A>\n    \t\t</FONT>\n\t\t\t\n\t\t</TD>\t\t\n\t\t<TD width=\"20%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[53] = 
    "\"><script>document.write(trunc('".toCharArray();
    __oracle_jsp_text[54] = 
    "','Asunto_HD'));</script> </A>\n\t\t\t</FONT>\n\t\t</TD>\t\n\t\t<TD width=\"20%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[55] = 
    "\"><script>document.write(trunc('".toCharArray();
    __oracle_jsp_text[56] = 
    "','Asunto_HD'));</script></A>\n\t\t\t</FONT>\n\t\t</TD>\t\n\t\t<TD width=\"10%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\t\t\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\t\t<TR>\n\t\t<TD colspan=\"8\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[60] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[61] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[63] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[64] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[66] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[67] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[69] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[70] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[71] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[72] = 
    ")\">".toCharArray();
    __oracle_jsp_text[73] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[75] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[76] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[78] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[79] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[81] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[82] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[83] = 
    "\n\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\t<TR> \n\t\t<TD width=\"100%\">\n\t\t\t<div align=center>\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">******No Hay Instrumentos de SubSerie Capturados******</FONT>\n\t\t\t</div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[85] = 
    "\n</TBODY>\n</TABLE>\n</DIV>\n<BR>\n\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
