package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.beans.search.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.*;
import java.util.StringTokenizer;
import com.meve.sigma.servlet.SearchArchiveByContent;
import java.util.Vector;


public class _BuscarCampoBean extends com.orionserver.http.OrionHttpJspPage {


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
    _BuscarCampoBean page = this;
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
      com.meve.sigma.beans.search.BuscarCampo BeanBuscar;
      synchronized (pageContext) {
        if ((BeanBuscar = (com.meve.sigma.beans.search.BuscarCampo) pageContext.getAttribute( "BeanBuscar", PageContext.PAGE_SCOPE)) == null) {
          BeanBuscar = (com.meve.sigma.beans.search.BuscarCampo) new com.meve.sigma.beans.search.BuscarCampo();
          pageContext.setAttribute( "BeanBuscar", BeanBuscar, PageContext.PAGE_SCOPE);
          out.write(__oracle_jsp_text[2]);
          OracleJspRuntime.__jspSetAllParams(request, (Object)BeanBuscar, true);
          out.write(__oracle_jsp_text[3]);
        }
      }
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
      
      	String contentUri = application.getInitParameter("content");
      	String passContent = application.getInitParameter("user");
      	String userContent = application.getInitParameter("passwd");
      	String pathContent = (application.getInitParameter("path")==null)?"/vmserver2/SIGA_WS/SIGA_LIB":application.getInitParameter("path");
      	String strCreador1 = 	BUsuario.getIdUsuario();
      	String strAreaUs	=	BUsuario.getIdArea();
      	String[] strBusqueda = null;
      	String[] strIdAsunto = null;
      	StringTokenizer tokens;
      	
      	String strContenido = request.getParameter("buscaSobreContenido");
      	String strBusquedaContent = request.getParameter("buscaContenido");
      	
      	if (strBusquedaContent== null || strBusquedaContent == ""){
      		strBusquedaContent = "0";
      	}
      	
      	String strResultado[][]	= null;
      	String strEstatus = "99";
      
      	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
      	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
      	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");
      
      	int regPorPagina = 20;
      	int muestraPaginas = 20;
      	int iSAmarillo = 70;
      	String[][] strConfig = com.meve.sigma.actualiza.ActualizaConfiguracion.getDatosConf();
      	if(strConfig != null && strConfig.length > 0){
      		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
      		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
      		iSAmarillo		=	Integer.parseInt(strConfig[0][2]);
      	}
      
      	int numRegistros = 0;
      	int numPaginas = 0;
      	
      	if(BeanBuscar.getbuscaEstatus() == null || BeanBuscar.getbuscaEstatus().equals("")){
      		BeanBuscar 			= (BuscarCampo)session.getAttribute("UsuarioBuscaBean");
      		//strResultado 		= (String[][])session.getAttribute("ResultadoBuscar");
      		strContenido 		= (String)session.getAttribute("buscaSobreContenido");
      		strBusquedaContent 	= (String)session.getAttribute("buscaContenido");
                      strResultado = ActualizaBuscar.getBuscarMultiCampoAsunto(
      						BeanBuscar, 
      						strOrden, strTipo,
      						BUsuario.getIdUsuario(),
      						BUsuario.getIdArea(),
      						strBusquedaContent);
      	}//else{
      
      		strResultado = ActualizaBuscar.getBuscarMultiCampoAsunto(
      						BeanBuscar, 
      						strOrden, strTipo,
      						BUsuario.getIdUsuario(),
      						BUsuario.getIdArea(),
      						strBusquedaContent);	
      
      		if (strBusquedaContent.equals("5")){
      
      			strBusqueda = SearchArchiveByContent.searchByContent1(
      								strContenido, strResultado, strAreaUs, contentUri, passContent, userContent, pathContent, "A");  
      
      			if ( strBusqueda!=null && strBusqueda.length>0 && strResultado!=null && strResultado.length>0){
      				////System.out.println("busqueda ....." + strBusqueda.length);
      
      				Vector vContenido = new Vector();
      				for (int i = 0; i < strBusqueda.length ; i++){
      
      					if (!strBusqueda[i].equals("") && strBusqueda[i].length()>0){
      						tokens=new StringTokenizer(strBusqueda[i], "|");
      						int nDatos=tokens.countTokens();
      						String[] datos=new String[nDatos];		
      						int j=0;
      					
      						while(tokens.hasMoreTokens()){
         			         		String str=tokens.nextToken();
         		        		 	datos[j]=str;
         			         		//System.out.println(datos[j]);
         		    	     		j++;
         		     			}
      				
      						////System.out.println("  ***************  "+i+".- Folio="+datos[3]+" Archivo="+datos[0]);
      						
      						for (int k=0; k<strResultado.length; k++){
      							if (strResultado[k][0].equals(datos[3]) && strResultado[k][12].equals(datos[0])){
      								vContenido.add(strResultado[k]);
      							}
      						}
      						
      					}else{
      						////System.out.println("  ***************  "+i+"    NADA    ");
      					}
      				}
      
      				strResultado = new String[vContenido.size()][strResultado[0].length];
      				for (int k=0; k<vContenido.size(); k++){
      					strResultado[k] = (String[])vContenido.get(k);
      				}
      
      			}else {
      				strResultado = new String[0][strResultado.length];
      				////System.out.println("Sin resultados");
      			}
      		}
      
      		int iDuracion = 0;
      		float fPorcentaje = 0;
      		float fAvance = 0;
      		String[] semaforo = BeanBuscar.getSemaforoAsunto();
      		String strSemaforo = "";
      		if (semaforo!=null && semaforo.length>0){
      			for (int i=0; i<semaforo.length; i++){
      				strSemaforo += semaforo[i];
      			}
      		}
      
      		if (strResultado!=null && strResultado.length>0){
      			Vector vResult = new Vector();
      
      			for (int i=0; i<strResultado.length; i++){
      				iDuracion = Utilerias.DiasdeTrabajoEntre(Utilerias.StringCalendar(strResultado[i][9]), Utilerias.StringCalendar(strResultado[i][8]), 0);
      				fPorcentaje = Utilerias.getPorcentajeDebido(iDuracion, strResultado[i][9], strResultado[i][8], 5);
      				fAvance = new Float(strResultado[i][10]).floatValue();
      				if(fPorcentaje>100){
      					if (strSemaforo.indexOf('r')!=-1)
      						vResult.add(strResultado[i]);				
      				}else if(fPorcentaje>=iSAmarillo &&  fPorcentaje<=100){
      					if(fPorcentaje<=fAvance){
      						if (strSemaforo.indexOf('v')!=-1)
      							vResult.add(strResultado[i]);				
      					}else{	
      						if (strSemaforo.indexOf('a')!=-1)
      							vResult.add(strResultado[i]);				
      				}
      				}else if(fPorcentaje<iSAmarillo){
      					if (strSemaforo.indexOf('v')!=-1)
      						vResult.add(strResultado[i]);				
      				}
      			}
      		
      			strResultado = new String[vResult.size()][strResultado[0].length];
      			for (int i=0; i<vResult.size(); i++){
      				strResultado[i] = (String[])vResult.get(i);
      			}
      		}
      //	}
      
      	session.setAttribute("UsuarioBuscaBean",BeanBuscar);
      	session.setAttribute("ResultadoBuscar",strResultado);
      	session.setAttribute("buscaSobreContenido",strContenido);
      	session.setAttribute("buscaContenido",strBusquedaContent);
      
      
      out.write(__oracle_jsp_text[7]);
      out.write(__oracle_jsp_text[8]);
      out.print(strOrden );
      out.write(__oracle_jsp_text[9]);
      out.print(strTipo );
      out.write(__oracle_jsp_text[10]);
      out.print(contPag );
      out.write(__oracle_jsp_text[11]);
      out.print(contligas );
      out.write(__oracle_jsp_text[12]);
      out.print(strContenido );
      out.write(__oracle_jsp_text[13]);
      out.print(strBusquedaContent );
      out.write(__oracle_jsp_text[14]);
      	
      
      out.write(__oracle_jsp_text[15]);
       if(strResultado == null || strResultado.length == 0){ 
      out.write(__oracle_jsp_text[16]);
       }else{ 
      out.write(__oracle_jsp_text[17]);
      	numRegistros = strResultado.length;
      			if (numRegistros>0){ 
      out.write(__oracle_jsp_text[18]);
      	} 
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
       	//for(int i=0;i<strResultado.length;i++){ 
      out.write(__oracle_jsp_text[28]);
      	for (int i=contPag*regPorPagina; i<strResultado.length && i<(contPag+1)*regPorPagina; i++){ 
      out.write(__oracle_jsp_text[29]);
      if(par(i+1)==true){
      }else{
      out.write(__oracle_jsp_text[30]);
      }
      out.write(__oracle_jsp_text[31]);
       if(strResultado[i][0].equals("folio por asignar")){ 
      out.write(__oracle_jsp_text[32]);
      out.print(strResultado[i][4]);
      out.write(__oracle_jsp_text[33]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&buscaSobreContenido="+strContenido+"&buscaContenido="+strBusquedaContent) );
      out.write(__oracle_jsp_text[34]);
      out.print( strResultado[i][0] );
      out.write(__oracle_jsp_text[35]);
       }else{ 
      out.write(__oracle_jsp_text[36]);
      out.print(strResultado[i][4]);
      out.write(__oracle_jsp_text[37]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&buscaSobreContenido="+strContenido+"&buscaContenido="+strBusquedaContent) );
      out.write(__oracle_jsp_text[38]);
      out.print( strResultado[i][0] );
      out.write(__oracle_jsp_text[39]);
       } 
      out.write(__oracle_jsp_text[40]);
      out.print( strResultado[i][11].equals("")?"Sin Folio de Control":strResultado[i][11] );
      out.write(__oracle_jsp_text[41]);
      out.print(strResultado[i][2]);
      out.write(__oracle_jsp_text[42]);
      out.print(Utilerias.recortaString(strResultado[i][2],35));
      out.write(__oracle_jsp_text[43]);
      out.print(strResultado[i][3]);
      out.write(__oracle_jsp_text[44]);
       if (strBusquedaContent.equals("5")){ 
      out.write(__oracle_jsp_text[45]);
      out.print( strResultado[i][12] );
      out.write(__oracle_jsp_text[46]);
      out.print( Utilerias.recortaString(strResultado[i][12],30) );
      out.write(__oracle_jsp_text[47]);
       }else{ 
      out.write(__oracle_jsp_text[48]);
      out.print( ActualizaArchivo.getStringNombreArchivos(strResultado[i][4]) );
      out.write(__oracle_jsp_text[49]);
      out.print( Utilerias.recortaString(ActualizaArchivo.getStringNombreArchivos(strResultado[i][4]),30) );
      out.write(__oracle_jsp_text[50]);
       } 
      out.write(__oracle_jsp_text[51]);
       } 
      out.write(__oracle_jsp_text[52]);
      
      		if (contligas>0 && numPaginas > muestraPaginas){ 
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
      		if (numPaginas > 1){
      			for (int ik=contligas; ik<muestraPaginas+contligas && ik<numPaginas; ik++){ 
      				if (ik==contPag){  
      out.write(__oracle_jsp_text[62]);
      out.print(ik);
      out.write(__oracle_jsp_text[63]);
      out.print(ik+1);
      out.write(__oracle_jsp_text[64]);
      		}else{ 
      out.write(__oracle_jsp_text[65]);
      out.print(ik);
      out.write(__oracle_jsp_text[66]);
      out.print(ik+1);
      out.write(__oracle_jsp_text[67]);
      		}
      			}
      		} 
      		if (contPag < numPaginas-1){  
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
      		if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[74]);
      out.print( numPaginas-muestraPaginas );
      out.write(__oracle_jsp_text[75]);
      out.print( numPaginas-1 );
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
    "\n\t".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Buscar por Asunto</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\">\n<!--\n\tfunction cambio(o, t){\n\t\tdoc = document.BuscarCampoBean;\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\n\tfunction pagina(contador){\n\t\tdoc = document.BuscarCampoBean;\n\t\tdoc.contPag.value=contador;\n\t\tdoc.submit();\n\t}\n\tfunction paginaLiga(contador){\n\t\tdoc = document.BuscarCampoBean;\n\t\tdoc.contligas.value=contador;\n\t\tdoc.submit();\n\t}\n//-->\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n<FORM name=\"BuscarCampoBean\" action=\"BuscarCampoBean.jsp\" method=\"post\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"contligas\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"buscaSobreContenido\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"buscaContenido\">\n\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\n<TBODY>\n\t<TR>\n\t\t<TD width=\"20%\" align=\"center\">\n\t\t\t<INPUT type=\"button\" class=\"blue200\" value=\"Realizar Otra Busqueda\" onclick=\"regresarBC()\">\n\t\t</TD>\n\t\t<td width=\"30%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"25%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"25%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n<br>\n\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\n<DIV align=\"center\">\n<table border=\"0\" width=\"100%\">\n<TBODY>\n\t<TR bgcolor=\"#00204f\">\n\t\t<TD width=\"15%\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">\n\t\t\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\tFOLIO DE Recepción\n\t\t\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\t</FONT></b>\n\t\t\t</CENTER>\n\t\t</TD>\n\t\t<td width=\"15%\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">\n\t\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\tFOLIO DE CONTROL\n\t\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\t</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"30%\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">\n\t\t\t\t<a onclick=\"cambio('asc', 3)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\tASUNTO\n\t\t\t\t<a onclick=\"cambio('desc', 3)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\t</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"15%\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">\n\t\t\t\t<a onclick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\tFECHA DE Creación\n\t\t\t\t<a onclick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\t</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"25%\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">\n\t\t\t\tDOCUMENTOS ANEXADOS\t\t\t\t\n\t\t\t\t</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n<BR>\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD width=\"383\"><b><FONT size=\"2\" color=\"red\" face=\"Arial\">\n\t\t\tNo se encontraron Documentos</FONT></b></TD>\n\t\t<td width=\"33\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\n<DIV class=documentBody id=Body>\n<DIV align=\"center\">\n<table border=\"0\" width=\"100%\">\n<TBODY>\n\t<TR>\t\t\t\n\t\t<TD align=\"left\" colspan=\"2\">\n\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A onclick=\"window.open('../ReporteBeanExcel?tip=busqueda_beanExcel');\" title=\"Exportar a Excel\">\n\t\t\t<img src=\"../Imagenes/ic_excel.gif\" border=\"0\"></A>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A onclick=\"window.open('../ReporteBeanPDF?tip=busqueda_bean');\" title=\"Exportar a PDF\">\n\t\t\t<img src=\"../Imagenes/ic_pdf.gif\" border=\"0\"></A>\n\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t</TD>\n\t\t<TD align=\"right\" colspan=\"3\">\n\t\t".toCharArray();
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
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t</TD>\n\t</TR>\n\t<TR><TD><BR></TD></TR>\n\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t<TR ".toCharArray();
    __oracle_jsp_text[30] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[31] = 
    ">\n\t\t<TD width=\"15%\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t\t<a href=\"AsuntoRecepcion.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[33] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[34] = 
    "\">\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "</a>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t\t\t<a href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[37] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[38] = 
    "\">\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "</a>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t\t</FONT>\n\t\t\t</CENTER>\n\t\t</TD>\n\t\t<td width=\"15%\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"30%\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[42] = 
    "\" >".toCharArray();
    __oracle_jsp_text[43] = 
    "</A></FONT>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"15%\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[44] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"25%\">\n\t\t\t<CENTER>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[46] = 
    "\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "</A></FONT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[49] = 
    "\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "</A></FONT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t\t</CENTER>\n\t\t</td>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t<TR>\n\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[54] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[55] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[57] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[58] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[60] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[61] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[63] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[64] = 
    "]</B></FONT></A> &nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[66] = 
    ")\">".toCharArray();
    __oracle_jsp_text[67] = 
    "</A> &nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[69] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[70] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[71] = 
    "\n\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[72] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[73] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[75] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[76] = 
    ");\"> <B>FINAL</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t</TD>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n".toCharArray();
    __oracle_jsp_text[78] = 
    "\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
