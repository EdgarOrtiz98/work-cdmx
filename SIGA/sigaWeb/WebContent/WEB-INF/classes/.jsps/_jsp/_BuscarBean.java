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
import java.util.*;
import gob.hacienda.cgtic.siga.util.*;


public class _BuscarBean extends com.orionserver.http.OrionHttpJspPage {


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
    _BuscarBean page = this;
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
      com.meve.sigma.beans.search.BuscarCampoIns BeanBuscar;
      synchronized (pageContext) {
        if ((BeanBuscar = (com.meve.sigma.beans.search.BuscarCampoIns) pageContext.getAttribute( "BeanBuscar", PageContext.PAGE_SCOPE)) == null) {
          BeanBuscar = (com.meve.sigma.beans.search.BuscarCampoIns) new com.meve.sigma.beans.search.BuscarCampoIns();
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
      	String pathContent = application.getInitParameter("path");
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
      
      	String strResultado[][]		= null;
      	String strEstatus = "99";
      	String strTipoAte = "99";
      	
      	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"2";
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
      
      		BeanBuscar 			= (BuscarCampoIns)session.getAttribute("UsuarioBuscaBeanIns");
      		strResultado 		= (String[][])session.getAttribute("ResultadoBuscar");
      		strContenido 		= (String)session.getAttribute("buscaSobreContenido");
      		strBusquedaContent 	= (String)session.getAttribute("buscaContenido");
                      int criterio = (strOrden.equalsIgnoreCase("ASC"))?1:0;
                      int campo = 0;
                      switch (Integer.parseInt(strTipo)) {
                          case 1:
                              campo = 1;
                          break;
                          case 2:
                              campo = 5;
                          break;
                          case 3:
                              campo = 15;
                          break;
                          case 4:
                              campo = 3;
                          break;
                          case 5:
                              campo = 2;
                          break;
                          default:
                              campo = 1;
                          break;
                      }
                      Arrays.sort(strResultado,new ComparatorIntruccionesResult(criterio,campo)); 
      	}else {
                      //Si no es asistente busca las instrucciones propias
                      if(!BUsuario.getAsistente()) {
                          strResultado = ActualizaBuscar.getBuscarMultiCampoInstruccion(
                                                  BeanBuscar,
                                                  strOrden, strTipo,
                                                  BUsuario.getIdUsuario(), 
                                                  BUsuario.getIdArea(),
                                                  strBusquedaContent);
                      }
                      
                      //Si es asistente Busca las instrucciones de sus jefes
                      if(BUsuario.getAsistente()) {
                          String[][] strJefes = ActualizaUsuario.getJefesDeAsistente(BUsuario.getIdUsuario());
                          ArrayList<String[]> resultadoJefes = new ArrayList<String[]>();
                          for(String[] jefe : strJefes ) {
                              String areaUsuario = ActualizaUsuario.getAreaUsuario(jefe[0]);
                              String[][] strResultadoAsistente = ActualizaBuscar.getBuscarMultiCampoInstruccion(
                                                  BeanBuscar,
                                                  strOrden, strTipo,
                                                  jefe[0], 
                                                  areaUsuario,
                                                  strBusquedaContent);
                              for(String[] registro : strResultadoAsistente) {
                                  resultadoJefes.add(registro);
                              }
                          }
                          strResultado = new String[resultadoJefes.size()][];
                          int i = 0;
                          for(String[] registro : resultadoJefes) {
                              strResultado[i++] = registro;
                          }
                          int criterio = (strOrden.equalsIgnoreCase("ASC"))?1:0;
                          int campo = 0;
                          switch (Integer.parseInt(strTipo)) {
                              case 1:
                                  campo = 1;
                              break;
                              case 2:
                                  campo = 5;
                              break;
                              case 3:
                                  campo = 15;
                              break;
                              case 4:
                                  campo = 3;
                              break;
                              case 5:
                                  campo = 2;
                              break;
                              default:
                                  campo = 1;
                              break;
                          }
                          Arrays.sort(strResultado,new ComparatorIntruccionesResult(criterio,campo));
      		}
      
      		if (strBusquedaContent.equals("5")){
      
      			strBusqueda = com.meve.sigma.servlet.SearchArchiveByContent.searchByContent1(
      								strContenido, strResultado, strAreaUs, contentUri, passContent, userContent, pathContent, "I");  
      
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
      							if (strResultado[k][17].equals(datos[3]) && strResultado[k][16].equals(datos[0])){
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
      
      				float fPorcentaje = Utilerias.getPorcentajeDebido(new Integer(strResultado[i][13]).intValue(), strResultado[i][11], strResultado[i][12], 5);
      				float iAvance = new Float(strResultado[i][14]).floatValue();
      				if(fPorcentaje > 100){
      					if (strSemaforo.indexOf('r')!=-1)
      						vResult.add(strResultado[i]);				
      				}else if(fPorcentaje>=iSAmarillo &&  fPorcentaje<=100){
      					if(fPorcentaje<=iAvance){
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
      	}
      
      	session.setAttribute("UsuarioBuscaBeanIns",BeanBuscar);
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
       if(strResultado == null || strResultado.length == 0){ 
      out.write(__oracle_jsp_text[15]);
       }else{ 
      out.write(__oracle_jsp_text[16]);
      	numRegistros = strResultado.length;
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
      	for (int j=contPag*regPorPagina; j<strResultado.length && j<(contPag+1)*regPorPagina; j++){ 
      out.write(__oracle_jsp_text[27]);
      if(par(j+1)==true){
      }else{
      out.write(__oracle_jsp_text[28]);
      }
      out.write(__oracle_jsp_text[29]);
      out.print(strResultado[j][0]);
      out.write(__oracle_jsp_text[30]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&buscaSobreContenido="+strContenido+"&buscaContenido="+strBusquedaContent) );
      out.write(__oracle_jsp_text[31]);
      out.print(strResultado[j][1]);
      out.write(__oracle_jsp_text[32]);
       	if(strResultado[j][9].equals("0")){
      						String padre1 = strResultado[j][10];
      						if(padre1.length() != 0){ 
      				
      out.write(__oracle_jsp_text[33]);
      out.print(strResultado[j][0]);
      out.write(__oracle_jsp_text[34]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&buscaSobreContenido="+strContenido+"&buscaContenido="+strBusquedaContent) );
      out.write(__oracle_jsp_text[35]);
      out.print(strResultado[j][1]);
      out.write(__oracle_jsp_text[36]);
      		}else{ 
      out.write(__oracle_jsp_text[37]);
      out.print(strResultado[j][0]);
      out.write(__oracle_jsp_text[38]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&buscaSobreContenido="+strContenido+"&buscaContenido="+strBusquedaContent) );
      out.write(__oracle_jsp_text[39]);
      out.print(strResultado[j][1]);
      out.write(__oracle_jsp_text[40]);
       		} 
      out.write(__oracle_jsp_text[41]);
       } else if(strResultado[j][9].equals("1")){ 
      out.write(__oracle_jsp_text[42]);
      out.print(strResultado[j][0]);
      out.write(__oracle_jsp_text[43]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&buscaSobreContenido="+strContenido+"&buscaContenido="+strBusquedaContent) );
      out.write(__oracle_jsp_text[44]);
      out.print(strResultado[j][1]);
      out.write(__oracle_jsp_text[45]);
       } 
      out.write(__oracle_jsp_text[46]);
      out.print(strResultado[j][5]);
      out.write(__oracle_jsp_text[47]);
      out.print(strResultado[j][5]);
      out.write(__oracle_jsp_text[48]);
      out.print(strResultado[j][15]);
      out.write(__oracle_jsp_text[49]);
      out.print(strResultado[j][3]);
      out.write(__oracle_jsp_text[50]);
      out.print(strResultado[j][3]);
      out.write(__oracle_jsp_text[51]);
      out.print(strResultado[j][2]);
      out.write(__oracle_jsp_text[52]);
       if (strBusquedaContent.equals("5")){ 
      out.write(__oracle_jsp_text[53]);
      out.print( strResultado[j][16] );
      out.write(__oracle_jsp_text[54]);
      out.print(strResultado[j][16]);
      out.write(__oracle_jsp_text[55]);
       }else{ 
      out.write(__oracle_jsp_text[56]);
      out.print( ActualizaArchivo.getStringNombreArchivosIns(strResultado[j][0]) );
      out.write(__oracle_jsp_text[57]);
      out.print(ActualizaArchivo.getStringNombreArchivosIns(strResultado[j][0]));
      out.write(__oracle_jsp_text[58]);
       } 
      out.write(__oracle_jsp_text[59]);
       } 
      out.write(__oracle_jsp_text[60]);
      
      		if (contligas>0 && numPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[61]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[62]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[63]);
      	}
      		if (contPag > 0){  
      			if (contPag > contligas){
      out.write(__oracle_jsp_text[64]);
      out.print(contligas);
      out.write(__oracle_jsp_text[65]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[66]);
      	}else{
      out.write(__oracle_jsp_text[67]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[68]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[69]);
      	} 
      		}
      		if (numPaginas > 1){
      			for (int ik=contligas; ik<muestraPaginas+contligas && ik<numPaginas; ik++){ 
      				if (ik==contPag){  
      out.write(__oracle_jsp_text[70]);
      out.print(ik);
      out.write(__oracle_jsp_text[71]);
      out.print(ik+1);
      out.write(__oracle_jsp_text[72]);
      		}else{ 
      out.write(__oracle_jsp_text[73]);
      out.print(ik);
      out.write(__oracle_jsp_text[74]);
      out.print(ik+1);
      out.write(__oracle_jsp_text[75]);
      		}
      			}
      		} 
      		if (contPag < numPaginas-1){  
      			if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[76]);
      out.print(contligas);
      out.write(__oracle_jsp_text[77]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[78]);
      	}else{
      out.write(__oracle_jsp_text[79]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[80]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[81]);
      	} 
      		}
      		if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[82]);
      out.print( numPaginas-muestraPaginas );
      out.write(__oracle_jsp_text[83]);
      out.print( numPaginas-1 );
      out.write(__oracle_jsp_text[84]);
      	
      		} 
      out.write(__oracle_jsp_text[85]);
       } 
      out.write(__oracle_jsp_text[86]);

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
  private static final char __oracle_jsp_text[][]=new char[87][];
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Buscar por instrucción</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\">\n<!--\n\tfunction cambio(o, t){\n\t\tdoc = document.BuscarBean;\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\n\tfunction pagina(contador){\n\t\tdoc = document.BuscarBean;\n\t\tdoc.contPag.value=contador;\n\t\tdoc.submit();\n\t}\n\tfunction paginaLiga(contador){\n\t\tdoc = document.BuscarBean;\n\t\tdoc.contligas.value=contador;\n\t\tdoc.submit();\n\t}\n//-->\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n<span id=\"ruler\" style=\"visibility:hidden;\"></span> \n<FORM name=\"BuscarBean\" action=\"BuscarBean.jsp\" method=\"post\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
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
    "\" name=\"buscaContenido\">\n\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\n<TBODY>\n\t<TR>\n\t\t<TD width=\"20%\" align=\"center\">\n\t\t\t<INPUT type=\"button\" class=\"blue200\" value=\"Realizar Otra Busqueda\" onclick=\"regresarBCIns()\">\n\t\t</TD>\n\t\t<td width=\"20%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"40%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"20%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n</TBODY>\n</table>\n</DIV> \n<br>\n<DIV align=\"center\">\n<table border=\"0\" width=\"100%\">\n<TBODY>\n\t<TR bgcolor=\"#00204f\">\n\t\t<TD width=\"15%\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">\n\t\t\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\tFOLIO DE Recepción \n\t\t\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\t</FONT></b>\n\t\t\t</CENTER>\n\t\t</TD>\n\t\t<td id=\"Asunto_HD\" width=\"20%\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">\n\t\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\tRESPONSABLE DE LA instrucción\n\t\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\t</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"10%\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">\n\t\t\t\t<a onclick=\"cambio('asc', 3)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\tTIPO DE ATENCION\n\t\t\t\t<a onclick=\"cambio('desc', 3)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\t</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td id=\"Asunto_HD2\" width=\"25%\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">\n\t\t\t\t<a onclick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\tINSTRUCCION\n\t\t\t\t<a onclick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\t</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"10%\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">\n\t\t\t\t<a onclick=\"cambio('asc', 5)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\tFECHA DE generación\n\t\t\t\t<a onclick=\"cambio('desc', 5)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t\t</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td id=\"Asunto_HD3\" width=\"20%\">\n\t\t\t<CENTER>\n\t\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">\n\t\t\t\tDOCUMENTOS ANEXADOS\t\n\t\t\t\t</FONT></b>\n\t\t\t</CENTER>\n\t\t</td>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n<BR>\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\n<TBODY>\n\t<TR>\n\t\t<TD width=\"20%\"><b><FONT size=\"2\" color=\"red\" face=\"Arial\">\n\t\t\tNo se encontraron Documentos</FONT></b></TD>\n\t\t<td width=\"20%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"40%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"20%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\n<DIV class=documentBody id=Body>\n<DIV align=\"center\">\n<table border=\"0\" width=\"100%\">\n<TBODY>\n\t<TR>\n\t\t<TD align=\"left\" colspan=\"2\">\n\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A onclick=\"window.open('../ReporteBeanExcel?tip=busquedaInst_beanExcel');\" title=\"Exportar a Excel\">\n\t\t\t<img src=\"../Imagenes/ic_excel.gif\" border=\"0\"></A>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A onclick=\"window.open('../ReporteBeanPDF?tip=busquedaInst_bean');\" title=\"Exportar a PDF\">\n\t\t\t<img src=\"../Imagenes/ic_pdf.gif\" border=\"0\"></A>\n\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t</TD>\n\t\t<TD align=\"right\" colspan=\"5\">\n\t\t".toCharArray();
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
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t</TD>\n\t</TR>\n\t<TR><TD><BR></TD></TR>\n\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t<TR ".toCharArray();
    __oracle_jsp_text[28] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[29] = 
    ">\n\t\t<TD width=\"15%\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t<!-- <a href=\"InstruccionesAtender.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[30] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[31] = 
    "\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t</a>  -->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t\t<A href=\"InstruccionHija.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[34] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[35] = 
    "\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t\t\t</A> \n\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t\t<A href=\"InstruccionesAtender.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[38] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[39] = 
    "\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t\t\t</A> \n\t\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t\t\t<A href=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[43] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[44] = 
    "\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t\t\t</A> \n\t\t\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\n\t\t\t\t</FONT>\n\t\t\t</CENTER>\n\t\t</TD>\n\t\t<td width=\"20%\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[47] = 
    "\">\n\t\t\t\t<script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[48] = 
    "','Asunto_HD'));</script></A>\t\n\t\t\t\t</FONT>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"10%\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t\t</FONT>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"25%\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[50] = 
    "\">\n\t\t\t<script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[51] = 
    "','Asunto_HD2'));</script></A></FONT>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"10%\">\n\t\t\t<CENTER>\n\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[52] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t</td>\n\t\t<td width=\"20%\">\n\t\t\t<CENTER>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[54] = 
    "\">\n\t\t\t\t\t<script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[55] = 
    "','Asunto_HD3'));</script></A></FONT>\n\t\t\t\t\t</A></FONT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[57] = 
    "\">\n\t\t\t\t\t<script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[58] = 
    "','Asunto_HD3'));</script></A></FONT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t\t</CENTER>\n\t\t</td>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t<TR>\n\t<TD colspan=\"6\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\n\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[62] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[63] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\n\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[65] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[66] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[67] = 
    "\n\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[68] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[69] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[70] = 
    "\n\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[71] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[72] = 
    "]</B></FONT></A> &nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "\n\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[74] = 
    ")\">".toCharArray();
    __oracle_jsp_text[75] = 
    "</A> &nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[76] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[77] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[78] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "\n\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[80] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[81] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[82] = 
    "\n\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[83] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[84] = 
    ");\"> <B>FINAL</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[85] = 
    "\n\t</TD>\n\t</TR>\n</TBODY>\n</table>\n</DIV>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n".toCharArray();
    __oracle_jsp_text[86] = 
    "\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
