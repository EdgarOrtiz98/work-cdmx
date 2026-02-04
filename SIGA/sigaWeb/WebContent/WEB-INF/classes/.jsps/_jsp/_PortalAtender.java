package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.reportes.*;
import com.meve.sigma.util.*;
import java.util.*;
import java.io.*;
import gob.hacienda.cgtic.siga.actualiza.AtenderInstrucciones;


public class _PortalAtender extends com.orionserver.http.OrionHttpJspPage {


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
    _PortalAtender page = this;
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
      		response.sendRedirect("index.jsp?pagina="+ strTmp);
      
      	boolean bExiste		=	false;
      	boolean bMostrar	=	false;
      	int t 				= 	0; 
      	float fPorcentaje	= 	0;
      
      	String strActivarPortal =	application.getInitParameter("ActivarPortal");
      	String strAccion 	=	request.getParameter("accion");
      	String strIdUsuario 	=	(request.getParameter("idUs")!=null)?request.getParameter("idUs"):"";
      
      	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"6";
      
      	String strIdsAsiste[][] =	null;
      	
      	if(BUsuario.getAsistente()||AtenderInstrucciones.getTitular(BUsuario.getIdUsuario())){
                      
                      if(AtenderInstrucciones.getTitular(BUsuario.getIdUsuario()))                    
                          strIdsAsiste = ActualizaUsuario.getIdsUsAsistente(AtenderInstrucciones.getMyAsistente(BUsuario.getIdUsuario()));
                      else
                          strIdsAsiste = ActualizaUsuario.getIdsUsAsistente(BUsuario.getIdUsuario());
      		
                      Vector vecUsr = new Vector();
      		String strDatos[][] = null;
      		
      		if (strIdsAsiste != null && !strIdsAsiste.equals("") && strIdsAsiste.length>0){
      			for (int i=0; i<strIdsAsiste.length; i++){
      				vecUsr.addElement(strIdsAsiste[i][0]);
      				strDatos = ActualizaUsuario.getSubordinados(strIdsAsiste[i][0]);
      				AsignarArbol tree = new AsignarArbol(strDatos);
      				Vector vNom = tree.getIds();
      
      				if (vNom.size()>0){
      					for (int k=0; k<vNom.size(); k++){
      						vecUsr.addElement(vNom.get(k));
      					}
      				}
      			}
      		}else{
                          vecUsr.addElement(BUsuario.getIdUsuario());
      				strDatos = ActualizaUsuario.getSubordinados(BUsuario.getIdUsuario());
      				AsignarArbol tree = new AsignarArbol(strDatos);
      				Vector vNom = tree.getIds();
      
      				if (vNom.size()>0){
      					for (int k=0; k<vNom.size(); k++){
      						vecUsr.addElement(vNom.get(k));
      					}
      				}
                      }
      		for (int i=0; i<vecUsr.size(); i++){
      			for (int j=0; j<vecUsr.size(); j++){
      				if (i!=j){
                                          try{
      					String aux1 = (String)vecUsr.get(i);
      					String aux2 = (String)vecUsr.get(j);
      					if(aux1.equals(aux2)){
      						vecUsr.removeElementAt(i);
      						i=-1;
      						j=vecUsr.size();
      					}
                                          }catch(Exception e){}
      				}
      			}
      		}
                      
      		strIdsAsiste = new String[vecUsr.size()][1];
      		for (int i=0; i<vecUsr.size(); i++){
      			String aux = (String)vecUsr.get(i);
      			strIdsAsiste[i][0] = aux;
      		}
      	}
      
      	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
      	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");
      	int regPorPagina = 20;
      	int muestraPaginas = 20;
      	int iSAmarillo = 70;
      	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
      	if(strConfig != null && strConfig.length > 0){
      		regPorPagina 	= 	Integer.parseInt(strConfig[0][3]);
      		muestraPaginas 	= 	Integer.parseInt(strConfig[0][4]);
      		iSAmarillo		=	Integer.parseInt(strConfig[0][2]);
      	}
      	int numRegistros = 0;
      	int numPaginas = 0;
      
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
       if (	BUsuario.getRecepcion() && 
      		!(BUsuario.getAdmon() || BUsuario.getSupervisor() || BUsuario.getAtencion() || BUsuario.getTurnado() || BUsuario.getAsistente())){ 
      out.write(__oracle_jsp_text[6]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[7]);
       } 
      out.write(__oracle_jsp_text[8]);
      out.print( strIdUsuario );
      out.write(__oracle_jsp_text[9]);
      out.print( strOrden );
      out.write(__oracle_jsp_text[10]);
      out.print( strTipo );
      out.write(__oracle_jsp_text[11]);
      out.print( contPag );
      out.write(__oracle_jsp_text[12]);
      out.print( contligas );
      out.write(__oracle_jsp_text[13]);
      if(BUsuario.getTurnado() || BUsuario.getRecepcion()){
      out.write(__oracle_jsp_text[14]);
      }
      out.write(__oracle_jsp_text[15]);
      if(BUsuario.getTurnado()){
      out.write(__oracle_jsp_text[16]);
      }
      out.write(__oracle_jsp_text[17]);
      if(BUsuario.getAtencion()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[18]);
      }
      out.write(__oracle_jsp_text[19]);
      if(BUsuario.getAtencion()||BUsuario.getRecepcion()||BUsuario.getSupervisor()||BUsuario.getTurnado()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[20]);
      }
      out.write(__oracle_jsp_text[21]);
      if(BUsuario.getAtencion()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[22]);
      }
      out.write(__oracle_jsp_text[23]);
      
      	if(BUsuario.getAsistente()||AtenderInstrucciones.getTitular(BUsuario.getIdUsuario())){
      		boolean bExisteAs = false;
      		int j = 0;
      		for(int i=0;i<strIdsAsiste.length;i++){
      out.write(__oracle_jsp_text[24]);
      		bExisteAs	= ActualizaInstrucciones.TieneInstruccionesPorAtender(strIdsAsiste[i][0]);
      			if(bExisteAs){
      				bMostrar = strIdUsuario.equals(strIdsAsiste[i][0]);
      	
      out.write(__oracle_jsp_text[25]);
      out.print(strIdsAsiste[i][0]);
      out.write(__oracle_jsp_text[26]);
      out.print((bMostrar)?"collapse.gif":"expand.gif");
      out.write(__oracle_jsp_text[27]);
      out.print( ActualizaUsuario.NombreUsuario(strIdsAsiste[i][0]) );
      out.write(__oracle_jsp_text[28]);
      out.print( ActualizaUsuario.NombrePuesto(strIdsAsiste[i][0]) );
      out.write(__oracle_jsp_text[29]);
      
      			j++;
      			String str[][]=ActualizaInstrucciones.getInstruccionAtenderUsuario(strIdsAsiste[i][0],strOrden,strTipo);
                              int longitud = str!=null ? str.length:0;
      			if(bMostrar && longitud!=0){ 
      out.write(__oracle_jsp_text[30]);
      	numRegistros = ActualizaInstrucciones.getInstruccionAtenderUsuario(strIdsAsiste[i][0],strOrden,strTipo).length;
      					if (numRegistros>0){ 
      out.write(__oracle_jsp_text[31]);
      out.print( strIdsAsiste[i][0] );
      out.write(__oracle_jsp_text[32]);
      	} 
      out.write(__oracle_jsp_text[33]);
      	numPaginas = numRegistros/regPorPagina;	
      					if (numRegistros%regPorPagina != 0)
      						numPaginas++; 
      out.write(__oracle_jsp_text[34]);
      	if (numRegistros > 0){	
      out.write(__oracle_jsp_text[35]);
      out.print( numRegistros );
      out.write(__oracle_jsp_text[36]);
      	} 
      out.write(__oracle_jsp_text[37]);
      	if (numPaginas > 1){	
      out.write(__oracle_jsp_text[38]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[39]);
      out.print( numPaginas );
      out.write(__oracle_jsp_text[40]);
       	} 
      out.write(__oracle_jsp_text[41]);
      	String[][] sql = ActualizaInstrucciones.getInstruccionAtenderUsuario(strIdsAsiste[i][0],strOrden,strTipo);
      				for (int ix=contPag*regPorPagina; ix<sql.length && ix<(contPag+1)*regPorPagina; ix++){
      					String usuario1 = sql[ix][0];
      					String usuario2 = sql[ix][1];
      					String usuario3 = sql[ix][2];
      					String usuario4 = sql[ix][3];
      					String usuario5 = sql[ix][4];
      					String usuario6 = sql[ix][5];
      					String usuario7 = sql[ix][6];
      					String usuario8 = sql[ix][7];
      					String usuario9 = sql[ix][8];
      					String usuario10 = sql[ix][9];
      					String usuario11 = sql[ix][10];
      					String usuario12 = sql[ix][11];
      					String usuario13 = sql[ix][12];
      					String usuario14 = sql[ix][13];
      					String usuario15 = sql[ix][14];
      					String usuario16 = sql[ix][15];
      					String usuario17 = sql[ix][16];
      			
      out.write(__oracle_jsp_text[42]);
       t++; 
      out.write(__oracle_jsp_text[43]);
      if(par(t)==true){;}else{
      out.write(__oracle_jsp_text[44]);
      }
      out.write(__oracle_jsp_text[45]);
       
      							if(usuario14.equals("0")){
      								String padre1 = usuario17;
      								if(padre1.length() != 0){ 
      						
      out.write(__oracle_jsp_text[46]);
      out.print( usuario1 );
      out.write(__oracle_jsp_text[47]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas+"&orden="+strOrden+"&tipo="+strTipo) );
      out.write(__oracle_jsp_text[48]);
      out.print( usuario6 );
      out.write(__oracle_jsp_text[49]);
      out.print( Utilerias.recortaString(usuario6,30) );
      out.write(__oracle_jsp_text[50]);
      
      								}else{
      						
      out.write(__oracle_jsp_text[51]);
      out.print( usuario1 );
      out.write(__oracle_jsp_text[52]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas+"&orden="+strOrden+"&tipo="+strTipo)+"uriU" );
      out.write(__oracle_jsp_text[53]);
      out.print( usuario6 );
      out.write(__oracle_jsp_text[54]);
      out.print( usuario1 );
      out.write(__oracle_jsp_text[55]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas+"&orden="+strOrden+"&tipo="+strTipo));
      out.write(__oracle_jsp_text[56]);
      out.print( usuario6 );
      out.write(__oracle_jsp_text[57]);
      out.print( Utilerias.recortaString(usuario6,30) );
      out.write(__oracle_jsp_text[58]);
       		} 
      out.write(__oracle_jsp_text[59]);
       }else if(usuario14.equals("1")){ 
      out.write(__oracle_jsp_text[60]);
      out.print( usuario1 );
      out.write(__oracle_jsp_text[61]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas+"&orden="+strOrden+"&tipo="+strTipo) );
      out.write(__oracle_jsp_text[62]);
      out.print( usuario6 );
      out.write(__oracle_jsp_text[63]);
      out.print( Utilerias.recortaString(usuario6,30) );
      out.write(__oracle_jsp_text[64]);
       } 
      out.write(__oracle_jsp_text[65]);
      out.print( usuario7 );
       if(usuario2.length() == 0){ 
      out.write(__oracle_jsp_text[66]);
      out.print( usuario8 );
      out.write(__oracle_jsp_text[67]);
       }else{ 
      out.write(__oracle_jsp_text[68]);
      out.print(ActualizaInst.getNombreInstruccion1(usuario2));
      out.write(__oracle_jsp_text[69]);
       } 
      out.write(__oracle_jsp_text[70]);
      out.print( Utilerias.recortaString(usuario7,20) );
       if(usuario2.length() == 0){ 
      out.write(__oracle_jsp_text[71]);
      out.print( Utilerias.recortaString(usuario8,20) );
      out.write(__oracle_jsp_text[72]);
       }else{ 
      out.write(__oracle_jsp_text[73]);
      out.print(Utilerias.recortaString(ActualizaInst.getNombreInstruccion1(usuario2),20));
      out.write(__oracle_jsp_text[74]);
       } 
      out.write(__oracle_jsp_text[75]);
      out.print(Utilerias.formatearFechas(usuario3));
      out.write(__oracle_jsp_text[76]);
      out.print(Utilerias.formatearFechas(usuario4));
      out.write(__oracle_jsp_text[77]);
      fPorcentaje = Utilerias.getPorcentajeDebido(new Integer(usuario9).intValue(), usuario3, usuario4, 5);
      						float iAvance = new Float(usuario10).floatValue();
      						if(fPorcentaje > 100){
      out.write(__oracle_jsp_text[78]);
      }else if(fPorcentaje>=iSAmarillo &&  fPorcentaje<=100){
      out.write(__oracle_jsp_text[79]);
      if(fPorcentaje<=iAvance){
      out.write(__oracle_jsp_text[80]);
      }else{
      out.write(__oracle_jsp_text[81]);
      out.print(fPorcentaje);
      out.write(__oracle_jsp_text[82]);
      }
      out.write(__oracle_jsp_text[83]);
      out.write(__oracle_jsp_text[84]);
       }else if(fPorcentaje<iSAmarillo){ 
      out.write(__oracle_jsp_text[85]);
       } 
      out.write(__oracle_jsp_text[86]);
      }
      out.write(__oracle_jsp_text[87]);
      
      				if (contligas>0 && numPaginas > muestraPaginas){  
                                      
      out.write(__oracle_jsp_text[88]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[89]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[90]);
      	}
      				if (contPag > 0){  
      					if (contPag > contligas){
      out.write(__oracle_jsp_text[91]);
      out.print(contligas);
      out.write(__oracle_jsp_text[92]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[93]);
      	}else{
      out.write(__oracle_jsp_text[94]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[95]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[96]);
      	} 
      				}
      				if (numPaginas > 1){
      					for (int ik=contligas; ik<muestraPaginas+contligas && ik<numPaginas; ik++){
                                              
      out.write(__oracle_jsp_text[97]);
      out.print( ik+1 );
      out.write(__oracle_jsp_text[98]);
      if (ik==contPag){
      out.write(__oracle_jsp_text[99]);
      out.print(ik+1);
      out.write(__oracle_jsp_text[100]);
      }else{
      out.write(__oracle_jsp_text[101]);
      out.print(ik+1);
      out.write(__oracle_jsp_text[102]);
      }
      out.write(__oracle_jsp_text[103]);
      }
      				} 
      				if (contPag < numPaginas-1){  
      					if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[104]);
      out.print(contligas);
      out.write(__oracle_jsp_text[105]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[106]);
      	}else{
      out.write(__oracle_jsp_text[107]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[108]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[109]);
      	} 
      				}
      				if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[110]);
      out.print( numPaginas-muestraPaginas );
      out.write(__oracle_jsp_text[111]);
      out.print( numPaginas-1 );
      out.write(__oracle_jsp_text[112]);
      }
      out.write(__oracle_jsp_text[113]);
      }
      out.write(__oracle_jsp_text[114]);
      }
      out.write(__oracle_jsp_text[115]);
      }
      out.write(__oracle_jsp_text[116]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[117]);
       } 
      out.write(__oracle_jsp_text[118]);
      }else{
      out.write(__oracle_jsp_text[119]);
      bExiste	= ActualizaInstrucciones.TieneInstruccionesPorAtender(BUsuario.getIdUsuario());
                String strDatos[][] = null;
                strDatos = ActualizaInstrucciones.getSub1(BUsuario.getIdUsuario(), BUsuario.getIdArea());
      out.write(__oracle_jsp_text[120]);
      ////System.out.println("bExiste: "+bExiste);
      out.write(__oracle_jsp_text[121]);
      if(bExiste || (strDatos != null && strDatos.length > 0)){
      		
      /*                if(AtenderInstrucciones.getTitular(BUsuario.getIdUsuario()))
                          strDatos = */
      		
      	
      out.write(__oracle_jsp_text[122]);
      out.print(ListaInstrucciones.instruccionesPorAtender(	strDatos, 
													BUsuario.getIdUsuario(), 
													BUsuario.getIdArea(),
													BUsuario.getAsistente(),
													strIdUsuario,
													strOrden,
													strTipo,
													contPag,
													contligas,
													regPorPagina,
													muestraPaginas,
													iSAmarillo,
													numRegistros,
													numPaginas,
													bMostrar,
													t,
													strTmp,
													fPorcentaje) );
      out.write(__oracle_jsp_text[123]);
       } else { 
      out.write(__oracle_jsp_text[124]);
      }
      out.write(__oracle_jsp_text[125]);
      }
      out.write(__oracle_jsp_text[126]);

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
  private static final char __oracle_jsp_text[][]=new char[127][];
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
    "\n\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Instrucciones por Atender</TITLE>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script language=\"JavaScript\" type=\"text/javascript\">\nfunction desplegar(id){\n\tdoc = document.pAtender;\n\tdoc.accion.value=\"reload\";\n\tif (id==doc.idUs.value){\n\t\tdoc.idUs.value=0;\n\t\tdoc.submit();\n\t}else{\n\t\tdoc.idUs.value=id;\n\t\tdoc.contPag.value=0;\n\t\tdoc.contligas.value=0;\n\t\tdoc.submit();\n\t}\n}\n</script>\n<script language=\"JavaScript\" type=\"text/javascript\">\nfunction cambio(o, t){\n\tdoc = document.pAtender;\n\tdoc.accion.value=\"reload\";\n\tdoc.orden.value=o;\n\tdoc.tipo.value=t;\n\tdoc.submit();\n}\nfunction pagina(contador){\n\tdoc = document.pAtender;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\nfunction paginaLiga(contador){\n\tdoc = document.pAtender;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n\n<FORM method=\"post\" action=\"PortalAtender.jsp\" name=\"pAtender\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\" name=\"idUs\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\" name=\"orden\" >\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\" name=\"tipo\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"contligas\">\n<table cellspacing=\"2\" cellpadding=\"2\">\n<TBODY>\n\t<TR>\n\t\t<TD class=\"etiquetas\">\n\t\t\t\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\n<table cellspacing=\"2\" cellpadding=\"2\">\n\t<TBODY>\n\t\t<tr>\n\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAtencion()\";>Asuntos en Recepción</a></td>\n                ".toCharArray();
    __oracle_jsp_text[15] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[16] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntos()\";>Asuntos por turnar</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntosTr()\";>Asuntos en Trámite</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntosTer()\";>Asuntos terminados</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[18] = 
    "\n                    <td class=\"dominoSelTopTab\" bgcolor=\"#004080\"><a onclick=\"goAtender()\";>Instrucciones por atender</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goTramite()\";>Instrucciones en Trámite</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goTerminadas()\";>Instrucciones terminadas</a></td>\n                ".toCharArray();
    __oracle_jsp_text[19] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[20] = 
    "\n                    <td class=\"dominoTopTab\" ><a onclick=\"goRechazadas()\";>Instrucciones rechazadas</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[22] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goSolicitada()\";>Asuntos Solicitados</a></td>\n                ".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t</tr>\n\t</TBODY>\n</table>\n<br>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='19%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t\t<a onclick=\"cambio('asc', 6)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tFolio\n\t\t\t<a onclick=\"cambio('desc', 6)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font>\n\t\t</TD>\n\t\t<TD WIDTH='368' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t\t<a onclick=\"cambio('asc', 7)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tAsunto(instrucción)\n\t\t\t<a onclick=\"cambio('desc', 7)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font>\n\t\t</TD>\n\t\t<TD WIDTH='368' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t\t<a onclick=\"cambio('asc', 18)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tRecibido/Vence\n\t\t\t<a onclick=\"cambio('desc', 18)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font>\n\t\t</TD>\n\t\t<TD WIDTH='243' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t\tEstatus\n\t\t\t</font>\n\t\t</TD>\n\t</TR>\t\n</TABLE>\n<div id=\"msg\">\n</div>\n<DIV class=documentBody id=Body>\n<div id=\"view\">\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t<TR>\n\t\t<TD>\n\t\t<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t\t<TBODY>\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td colspan=\"5\" width=\"100%\">\n\t\t\t\t\t<a onClick=\"desplegar(".toCharArray();
    __oracle_jsp_text[26] = 
    ")\">\n\t\t\t\t\t<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[27] = 
    "\" \n\t\t\t\t\t\tborder=\"0\" height=\"16\" width=\"16\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    " / ".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t\t</a>\n\t\t\t\t</td>\n\t\t\t</tr> \n\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t<TR>\n\t\t\t\t<TD align=\"left\" colspan=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<A href=\"../ReporteAsuntoExcel?tip=inst_atender_01&id_remitente=".toCharArray();
    __oracle_jsp_text[32] = 
    "\">\n\t\t\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t\t\t</A>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t</TD>\n\t\t\t\t<TD align=\"right\" colspan=\"3\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    " registros mostrados.\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[39] = 
    " de ".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[44] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[45] = 
    ">\n\t\t\t\t<td width=\"2%\"></td>\n\t\t\t\t<td align=\"left\" width=\"17%\">\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t\t\t\t\t<A href=\"InstruccionHija.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[47] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[48] = 
    "\" title=\"".toCharArray();
    __oracle_jsp_text[49] = 
    "\">\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t\t\t\t\t</A>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n<!--\t\t\t\t\t\t<A href=\"InstruccionesAtender.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[52] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[53] = 
    "\" title=\"".toCharArray();
    __oracle_jsp_text[54] = 
    "\"> -->\n                                                <A href=\"InstruccionesAtender.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[55] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[56] = 
    "\" title=\"".toCharArray();
    __oracle_jsp_text[57] = 
    "\">\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\t\t\t\t\t\t</A>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t\t\t\t\t<A href=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[61] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[62] = 
    "\" title=\"".toCharArray();
    __oracle_jsp_text[63] = 
    "\">\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\n\t\t\t\t\t\t</A>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"center\" width=\"368\">\n\t\t\t\t\t<a title=\"".toCharArray();
    __oracle_jsp_text[66] = 
    "(".toCharArray();
    __oracle_jsp_text[67] = 
    ")\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "(".toCharArray();
    __oracle_jsp_text[69] = 
    ")".toCharArray();
    __oracle_jsp_text[70] = 
    "\">\n\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[71] = 
    "(".toCharArray();
    __oracle_jsp_text[72] = 
    ")\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "(".toCharArray();
    __oracle_jsp_text[74] = 
    ")".toCharArray();
    __oracle_jsp_text[75] = 
    "\n\t\t\t\t\t</font></a>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"center\" width=\"368\">\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[76] = 
    " -- ".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"center\" width=\"243\">\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/rojob5.gif\" width=\"10\" height=\"10\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\n\t\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/verde5.gif\" width=\"11\" height=\"11\"/>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[81] = 
    "\n\t\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/amarillo5.gif\" width=\"11\" height=\"11\" alt=\"Debería llevar el ".toCharArray();
    __oracle_jsp_text[82] = 
    "%\"/>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[83] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[85] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/verde5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[86] = 
    "\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[87] = 
    "\n\t\t\t<TR>\n\t\t\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[88] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[89] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[90] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[91] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[92] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[93] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[94] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[95] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[96] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[97] = 
    "\n                                            <A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[98] = 
    ")\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[99] = 
    "\n                                                    <FONT color='red'><B>[".toCharArray();
    __oracle_jsp_text[100] = 
    "]</B></FONT>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[101] = 
    "\n                                                    ".toCharArray();
    __oracle_jsp_text[102] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[103] = 
    "\n                                                </A> &nbsp; \n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[105] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[106] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[107] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[108] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[109] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[110] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[111] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[112] = 
    ");\"> <B>FINAL</B> </A>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[113] = 
    "\n\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[114] = 
    "\n\t\t</TBODY>\n\t\t</table>\n\t\t</TD>\n\t\t</TR>\n\n\t\t\t".toCharArray();
    __oracle_jsp_text[115] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[116] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[117] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center>\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">****** No tiene Instrucciones por Atender ******</FONT>\n\t\t\t</div>\n\t\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[118] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[119] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[120] = 
    "\n        ".toCharArray();
    __oracle_jsp_text[121] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[122] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[123] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[124] = 
    "\n\t<TR>\n\t\t<TD width=\"100%\">\n\t\t\t<div align=center>\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">****** No tiene Instrucciones por Atender ******</FONT>\n\t\t\t</div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[125] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[126] = 
    "\n</TBODY>\t\n</table>\n</div>\n<BR>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n<BR>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
