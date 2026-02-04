package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import gob.hacienda.cgtic.siga.asunto.AsuntoVerifica;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.reportes.*;
import com.meve.sigma.util.*;


public class _portalPrincipal extends com.orionserver.http.OrionHttpJspPage {


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
    _portalPrincipal page = this;
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
      out.write(__oracle_jsp_text[4]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		response.sendRedirect("index.jsp?pagina="+ strTmp);		
      	}else if((BUsuario.getAtencion() || BUsuario.getAsistente()) && !(BUsuario.getTurnado() || BUsuario.getRecepcion())){
      		response.sendRedirect("PortalAtender.jsp");
      	}else if(BUsuario.getAdmon()){
      		response.sendRedirect("UsuariosView.jsp");
      	}else if(BUsuario.getSupervisor()&&!BUsuario.getTurnado()&&!BUsuario.getRecepcion()){
                      response.sendRedirect("PortalRechazadas.jsp");
      	}else if(!BUsuario.getTurnado() && BUsuario.getRecepcion()){ 
                      response.sendRedirect("PortalBorrador.jsp");
      	}
              
      	boolean bExiste	= false;
      	boolean bExisteInsAsunto = false;
      	boolean bExisteMisAsuntos = false;
      	boolean bMostrar = false;
      	boolean noPuedeVerVentanillas		=   AsuntoVerifica.noPuedeUaVerVentanillas(session.getServletContext(),BUsuario.getIdArea());
      	int t = 0;
      	bExisteInsAsunto	= 	ActualizaInstrucciones.TieneInstruccionesPorAtenderAsunto(BUsuario.getIdUsuario());
        	String strAccion 	= 	request.getParameter("accion");
      	String strOrden 	= 	(request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo 		=	(request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
      	String strCambio 	=	(request.getParameter("cambio1")!=null)?request.getParameter("cambio1"):"0";
      	String strCambioT	=	(request.getParameter("cambioT")!=null)?request.getParameter("cambioT"):"0";
      	
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
      out.print( strOrden );
      out.write(__oracle_jsp_text[7]);
      out.print( strTipo );
      out.write(__oracle_jsp_text[8]);
      out.print(strCambio);
      out.write(__oracle_jsp_text[9]);
      out.print(strCambioT);
      out.write(__oracle_jsp_text[10]);
      out.print( contPag );
      out.write(__oracle_jsp_text[11]);
      out.print( contligas );
      out.write(__oracle_jsp_text[12]);
      if(BUsuario.getTurnado() || BUsuario.getRecepcion()){
      out.write(__oracle_jsp_text[13]);
      }
      out.write(__oracle_jsp_text[14]);
      if(BUsuario.getTurnado()){
      out.write(__oracle_jsp_text[15]);
      }
      out.write(__oracle_jsp_text[16]);
      if(BUsuario.getAtencion()|| BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[17]);
      }
      out.write(__oracle_jsp_text[18]);
      if(BUsuario.getAtencion()||BUsuario.getRecepcion()||BUsuario.getSupervisor()||BUsuario.getTurnado()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[19]);
      }
      out.write(__oracle_jsp_text[20]);
      if(BUsuario.getAtencion()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[21]);
      }
      out.write(__oracle_jsp_text[22]);
      out.print((strCambio.equals("1"))?"collapse.gif":"expand.gif");
      out.write(__oracle_jsp_text[23]);
      	if(strCambio.equals("1")){
      out.write(__oracle_jsp_text[24]);
      	numRegistros = ActualizaAsunto.getDatosMisAsunto(strOrden, strTipo, BUsuario.getIdUsuario()).length;
      			if (numRegistros>0){ 
      out.write(__oracle_jsp_text[25]);
      	} 
      out.write(__oracle_jsp_text[26]);
      	numPaginas = numRegistros/regPorPagina;	
      			if (numRegistros%regPorPagina != 0)
      				numPaginas++; 
      out.write(__oracle_jsp_text[27]);
      	if (numRegistros > 0){	
      out.write(__oracle_jsp_text[28]);
      out.print( numRegistros );
      out.write(__oracle_jsp_text[29]);
      	} 
      out.write(__oracle_jsp_text[30]);
      	if (numPaginas > 1){	
      out.write(__oracle_jsp_text[31]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[32]);
      out.print( numPaginas );
      out.write(__oracle_jsp_text[33]);
       	} 
      out.write(__oracle_jsp_text[34]);
      	} 
      out.write(__oracle_jsp_text[35]);
      if(strCambio.equals("1")){
      out.write(__oracle_jsp_text[36]);
       
      		bExisteMisAsuntos = ActualizaAsunto.getExistenMisAsuntos(BUsuario.getIdUsuario());
      		if(bExisteMisAsuntos){
      		
      out.write(__oracle_jsp_text[37]);
       int j = 0; 
      out.write(__oracle_jsp_text[38]);
      	String[][] sql = ActualizaAsunto.getDatosMisAsunto(strOrden, strTipo, BUsuario.getIdUsuario());
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
      				
      		
      out.write(__oracle_jsp_text[39]);
       t++; 
      out.write(__oracle_jsp_text[40]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[41]);
      }
      out.write(__oracle_jsp_text[42]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[43]);
      }else{
      out.write(__oracle_jsp_text[44]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[45]);
      }
      out.write(__oracle_jsp_text[46]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[47]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&cambio1="+strCambio+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[48]);
      out.print( campo2 );
      out.write(__oracle_jsp_text[49]);
      out.print(campo2);
      out.write(__oracle_jsp_text[50]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[51]);
      }else{
      out.write(__oracle_jsp_text[52]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[53]);
      }
      out.write(__oracle_jsp_text[54]);
      out.print(campo4 );
      out.write(__oracle_jsp_text[55]);
      out.print(campo10 );
      out.write(__oracle_jsp_text[56]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[57]);
      }else{
      out.write(__oracle_jsp_text[58]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[59]);
      }
      out.write(__oracle_jsp_text[60]);
      out.print(campo10);
      out.write(__oracle_jsp_text[61]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[62]);
      }else{
      out.write(__oracle_jsp_text[63]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[64]);
      }
      out.write(__oracle_jsp_text[65]);
      out.print(campo11 );
      out.write(__oracle_jsp_text[66]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[67]);
      }else{
      out.write(__oracle_jsp_text[68]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[69]);
      }
      out.write(__oracle_jsp_text[70]);
      out.print(campo12 );
      out.write(__oracle_jsp_text[71]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[72]);
      }else{
      out.write(__oracle_jsp_text[73]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[74]);
      }
      out.write(__oracle_jsp_text[75]);
       j++; 
      out.write(__oracle_jsp_text[76]);
       } 
      out.write(__oracle_jsp_text[77]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[78]);
       } else {
      out.write(__oracle_jsp_text[79]);
      
      			int numeroPaginas = (sql!=null)?sql.length/regPorPagina:0;	
      			if (sql.length%regPorPagina != 0)
      				numeroPaginas++; 
      			if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[80]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[81]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[82]);
      	}
      			if (contPag > 0){  
      				if (contPag > contligas){
      out.write(__oracle_jsp_text[83]);
      out.print(contligas);
      out.write(__oracle_jsp_text[84]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[85]);
      	}else{
      out.write(__oracle_jsp_text[86]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[87]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[88]);
      	} 
      			}
      			if (numeroPaginas > 1){
      				for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
      					if (i==contPag){  
      out.write(__oracle_jsp_text[89]);
      out.print(i);
      out.write(__oracle_jsp_text[90]);
      out.print(i+1);
      out.write(__oracle_jsp_text[91]);
      		}else{ 
      out.write(__oracle_jsp_text[92]);
      out.print(i);
      out.write(__oracle_jsp_text[93]);
      out.print(i+1);
      out.write(__oracle_jsp_text[94]);
      		}
      				}
      			} 
      			if (contPag < numeroPaginas-1){  
      				if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[95]);
      out.print(contligas);
      out.write(__oracle_jsp_text[96]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[97]);
      	}else{
      out.write(__oracle_jsp_text[98]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[99]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[100]);
      	} 
      			}
      			if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[101]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[102]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[103]);
      	
      			} 
      out.write(__oracle_jsp_text[104]);
       } 
      out.write(__oracle_jsp_text[105]);
       } else { 
      out.write(__oracle_jsp_text[106]);
       } 
      out.write(__oracle_jsp_text[107]);
      }
      out.write(__oracle_jsp_text[108]);
      
      if(!noPuedeVerVentanillas){
      out.write(__oracle_jsp_text[109]);
      out.print((strCambio.equals("2"))?"collapse.gif":"expand.gif");
      out.write(__oracle_jsp_text[110]);
      	if(strCambio.equals("2")){
      out.write(__oracle_jsp_text[111]);
      	numRegistros = ActualizaAsunto.getDatosAsunto(strOrden, strTipo, BUsuario.getIdArea(), BUsuario.getIdUsuario()).length;
      			if (numRegistros>0){ 
      out.write(__oracle_jsp_text[112]);
      	} 
      out.write(__oracle_jsp_text[113]);
      	numPaginas = numRegistros/regPorPagina;	
      			if (numRegistros%regPorPagina != 0)
      				numPaginas++; 
      out.write(__oracle_jsp_text[114]);
      	if (numRegistros > 0){	
      out.write(__oracle_jsp_text[115]);
      out.print( numRegistros );
      out.write(__oracle_jsp_text[116]);
      	} 
      out.write(__oracle_jsp_text[117]);
      	} 
      out.write(__oracle_jsp_text[118]);
      if(strCambio.equals("2")){
      out.write(__oracle_jsp_text[119]);
      
      		String[][] turnadores = ActualizaAsunto.getTurnadoreUnidad(BUsuario.getIdArea(), BUsuario.getIdUsuario());
      		for(int i=0;i<turnadores.length;i++){
      		int iCount = i+4;
      		String count = String.valueOf(iCount);
      		
      out.write(__oracle_jsp_text[120]);
      out.print(count);
      out.write(__oracle_jsp_text[121]);
      out.print((strCambioT.equals(count))?"collapse.gif":"expand.gif");
      out.write(__oracle_jsp_text[122]);
      out.print(turnadores[i][1]);
      out.write(__oracle_jsp_text[123]);
      if(strCambioT.equals(count)){
      out.write(__oracle_jsp_text[124]);
      numRegistros = ActualizaAsunto.datosAsuntoTurnadorAtender(strOrden, strTipo, BUsuario.getIdArea(), turnadores[i][0]).length; 
      out.write(__oracle_jsp_text[125]);
      	numPaginas = numRegistros/regPorPagina;	
      						if (numRegistros%regPorPagina != 0)
      						numPaginas++; 
      out.write(__oracle_jsp_text[126]);
      if(numRegistros > 0){
      out.write(__oracle_jsp_text[127]);
      out.print(numRegistros);
      out.write(__oracle_jsp_text[128]);
      }
      out.write(__oracle_jsp_text[129]);
      
      					bExiste	= ActualizaAsunto.existeAsuntoTurnadorAtender(BUsuario.getIdArea(), turnadores[i][0]); 
      					if(bExiste){
      					
      out.write(__oracle_jsp_text[130]);
       int j = 0; 
      out.write(__oracle_jsp_text[131]);
      	String[][] sql = ActualizaAsunto.datosAsuntoTurnadorAtender(strOrden, strTipo, BUsuario.getIdArea(), turnadores[i][0]);
      						for (int y=contPag*regPorPagina; y<sql.length && y<(contPag+1)*regPorPagina; y++){
      							String campo1 = sql[y][0];
      							String campo2 = sql[y][1];
      							String campo3 = sql[y][2];
      							String campo4 = sql[y][3];
      							String campo5 = sql[y][4];
      							String campo6 = sql[y][5];
      							String campo7 = sql[y][6];
      							String campo8 = sql[y][7];
      							String campo9 = sql[y][8];
      							String campo10 = sql[y][9];
      							String campo11 = sql[y][10];
      							String campo12 = sql[y][11];
      					
      					
      out.write(__oracle_jsp_text[132]);
       t++; 
      out.write(__oracle_jsp_text[133]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[134]);
      }
      out.write(__oracle_jsp_text[135]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[136]);
      }else{
      out.write(__oracle_jsp_text[137]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[138]);
      }
      out.write(__oracle_jsp_text[139]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[140]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&cambio1="+strCambio+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[141]);
      out.print( campo2 );
      out.write(__oracle_jsp_text[142]);
      out.print(campo2);
      out.write(__oracle_jsp_text[143]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[144]);
      }else{
      out.write(__oracle_jsp_text[145]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[146]);
      }
      out.write(__oracle_jsp_text[147]);
      out.print(campo4 );
      out.write(__oracle_jsp_text[148]);
      out.print(campo10 );
      out.write(__oracle_jsp_text[149]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[150]);
      }else{
      out.write(__oracle_jsp_text[151]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[152]);
      }
      out.write(__oracle_jsp_text[153]);
      out.print(Utilerias.recortaString(campo10,15) );
      out.write(__oracle_jsp_text[154]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[155]);
      }else{
      out.write(__oracle_jsp_text[156]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[157]);
      }
      out.write(__oracle_jsp_text[158]);
      out.print(campo11 );
      out.write(__oracle_jsp_text[159]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[160]);
      }else{
      out.write(__oracle_jsp_text[161]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[162]);
      }
      out.write(__oracle_jsp_text[163]);
      out.print(campo12 );
      out.write(__oracle_jsp_text[164]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[165]);
      }else{
      out.write(__oracle_jsp_text[166]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[167]);
      }
      out.write(__oracle_jsp_text[168]);
       j++; 
      out.write(__oracle_jsp_text[169]);
      }
      out.write(__oracle_jsp_text[170]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[171]);
      }else{
      out.write(__oracle_jsp_text[172]);
      
      						int numeroPaginas = (sql!=null)?sql.length/regPorPagina:0;	
      						if (sql.length%regPorPagina != 0)
      							numeroPaginas++; 
      						if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[173]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[174]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[175]);
      	}
      						if (contPag > 0){  
      							if (contPag > contligas){
      out.write(__oracle_jsp_text[176]);
      out.print(contligas);
      out.write(__oracle_jsp_text[177]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[178]);
      	}else{
      out.write(__oracle_jsp_text[179]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[180]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[181]);
      	} 
      						}
      						if (numeroPaginas > 1){
      							for (int k=contligas; k<muestraPaginas+contligas && k<numeroPaginas; k++){ 
      out.write(__oracle_jsp_text[182]);
      out.print(k);
      out.write(__oracle_jsp_text[183]);
      if (k==contPag){
      out.write(__oracle_jsp_text[184]);
      out.print(k+1);
      out.write(__oracle_jsp_text[185]);
      }else{
      out.write(__oracle_jsp_text[186]);
      out.print(k+1);
      out.write(__oracle_jsp_text[187]);
      }
      out.write(__oracle_jsp_text[188]);
      }
      						} 
      						if (contPag < numeroPaginas-1){  
      							if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[189]);
      out.print(contligas);
      out.write(__oracle_jsp_text[190]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[191]);
      	}else{
      out.write(__oracle_jsp_text[192]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[193]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[194]);
      	} 
      						}
      						if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[195]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[196]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[197]);
      }
      out.write(__oracle_jsp_text[198]);
      }
      out.write(__oracle_jsp_text[199]);
      }else{
      out.write(__oracle_jsp_text[200]);
      }
      out.write(__oracle_jsp_text[201]);
      }
      out.write(__oracle_jsp_text[202]);
      } if(turnadores.length == 0) {
      out.write(__oracle_jsp_text[203]);
      }
      out.write(__oracle_jsp_text[204]);
      }
      out.write(__oracle_jsp_text[205]);
      out.print((strCambio.equals("3"))?"collapse.gif":"expand.gif");
      out.write(__oracle_jsp_text[206]);
      	if(strCambio.equals("3")){
      out.write(__oracle_jsp_text[207]);
      	if(!BUsuario.getSupervisor()){
      			numRegistros = ActualizaInstrucciones.getInstruccionAtenderUsuarioAsunto(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea(), 1).length;
      			}else{
      			numRegistros = ActualizaInstrucciones.getInstruccionAtenderUsuarioAsunto(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea(), 1).length;
      			}
      			if (numRegistros>0){ 
      out.write(__oracle_jsp_text[208]);
      	} 
      out.write(__oracle_jsp_text[209]);
      	numPaginas = numRegistros/regPorPagina;	
      			if (numRegistros%regPorPagina != 0)
      				numPaginas++; 
      out.write(__oracle_jsp_text[210]);
      	if (numRegistros > 0){	
      out.write(__oracle_jsp_text[211]);
      out.print( numRegistros );
      out.write(__oracle_jsp_text[212]);
      	} 
      out.write(__oracle_jsp_text[213]);
      	if (numPaginas > 1){	
      out.write(__oracle_jsp_text[214]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[215]);
      out.print( numPaginas );
      out.write(__oracle_jsp_text[216]);
       	} 
      out.write(__oracle_jsp_text[217]);
      	} 
      out.write(__oracle_jsp_text[218]);
      if(strCambio.equals("3")){
      out.write(__oracle_jsp_text[219]);
       if(numRegistros!=0){ 
      out.write(__oracle_jsp_text[220]);
       int j = 0; 
      out.write(__oracle_jsp_text[221]);
      	
      			String[][] sql = null;
      			if(!BUsuario.getSupervisor()){//Un rol de atención
      			sql = ActualizaInstrucciones.getInstruccionAtenderUsuarioAsunto(	BUsuario.getIdUsuario(), 
      																						strOrden, strTipo, 
      																						BUsuario.getIdArea(), 1);
      			}else{//Rol de Supervisor
      			sql = ActualizaInstrucciones.getInstruccionAtenderUsuarioAsunto(	BUsuario.getIdUsuario(), 
      																						strOrden, strTipo, 
      																						BUsuario.getIdArea(), 1);
      			}
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
      		
      out.write(__oracle_jsp_text[222]);
       t++; 
      out.write(__oracle_jsp_text[223]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[224]);
      }
      out.write(__oracle_jsp_text[225]);
      if(campo9.length() == 0){
      out.write(__oracle_jsp_text[226]);
      }else{
      out.write(__oracle_jsp_text[227]);
      out.print(campo9 );
      out.write(__oracle_jsp_text[228]);
      }
      out.write(__oracle_jsp_text[229]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[230]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&cambio1="+strCambio+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[231]);
      out.print(campo10);
      out.write(__oracle_jsp_text[232]);
       if(campo2.length() == 0){ 
      out.write(__oracle_jsp_text[233]);
      out.print( campo3 );
      out.write(__oracle_jsp_text[234]);
       }else{ 
      out.write(__oracle_jsp_text[235]);
      out.print( ActualizaInst.getNombreInstruccion1(campo2) );
      }
      out.write(__oracle_jsp_text[236]);
      out.print(Utilerias.recortaString(campo10,20));
      out.write(__oracle_jsp_text[237]);
       if(campo2.length() == 0){ 
      out.write(__oracle_jsp_text[238]);
      out.print( Utilerias.recortaString(campo3,30) );
      out.write(__oracle_jsp_text[239]);
       }else{ 
      out.write(__oracle_jsp_text[240]);
      out.print( Utilerias.recortaString(ActualizaInst.getNombreInstruccion1(campo2),90) );
      }
      out.write(__oracle_jsp_text[241]);
      if(campo9.length() == 0){
      out.write(__oracle_jsp_text[242]);
      }else{
      out.write(__oracle_jsp_text[243]);
      out.print(campo9 );
      out.write(__oracle_jsp_text[244]);
      }
      out.write(__oracle_jsp_text[245]);
      out.print(campo6 );
      out.write(__oracle_jsp_text[246]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[247]);
      if(campo9.length() == 0){
      out.write(__oracle_jsp_text[248]);
      }else{
      out.write(__oracle_jsp_text[249]);
      out.print(campo9 );
      out.write(__oracle_jsp_text[250]);
      }
      out.write(__oracle_jsp_text[251]);
      out.print(Utilerias.recortaString(campo7,15) );
      out.write(__oracle_jsp_text[252]);
      if(campo9.length() == 0){
      out.write(__oracle_jsp_text[253]);
      }else{
      out.write(__oracle_jsp_text[254]);
      out.print(campo9 );
      out.write(__oracle_jsp_text[255]);
      }
      out.write(__oracle_jsp_text[256]);
      out.print(campo4 );
      out.write(__oracle_jsp_text[257]);
      if(campo9.length() == 0){
      out.write(__oracle_jsp_text[258]);
      }else{
      out.write(__oracle_jsp_text[259]);
      out.print(campo9 );
      out.write(__oracle_jsp_text[260]);
      }
      out.write(__oracle_jsp_text[261]);
      if(campo9.length() == 0){
      out.write(__oracle_jsp_text[262]);
      }else{
      out.write(__oracle_jsp_text[263]);
      out.print(campo9 );
      out.write(__oracle_jsp_text[264]);
      }
      out.write(__oracle_jsp_text[265]);
       j++; 
      out.write(__oracle_jsp_text[266]);
       } 
      out.write(__oracle_jsp_text[267]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[268]);
       } else {
      out.write(__oracle_jsp_text[269]);
      
      			int numeroPaginas = (sql!=null)?sql.length/regPorPagina:0;	
      			if (sql.length%regPorPagina != 0)
      				numeroPaginas++; 
      			if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[270]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[271]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[272]);
      	}
      			if (contPag > 0){  
      				if (contPag > contligas){
      out.write(__oracle_jsp_text[273]);
      out.print(contligas);
      out.write(__oracle_jsp_text[274]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[275]);
      	}else{
      out.write(__oracle_jsp_text[276]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[277]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[278]);
      	} 
      			}
      			if (numeroPaginas > 1){
      				for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
      					if (i==contPag){  
      out.write(__oracle_jsp_text[279]);
      out.print(i);
      out.write(__oracle_jsp_text[280]);
      out.print(i+1);
      out.write(__oracle_jsp_text[281]);
      		}else{ 
      out.write(__oracle_jsp_text[282]);
      out.print(i);
      out.write(__oracle_jsp_text[283]);
      out.print(i+1);
      out.write(__oracle_jsp_text[284]);
      		}
      				}
      			} 
      			if (contPag < numeroPaginas-1){  
      				if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[285]);
      out.print(contligas);
      out.write(__oracle_jsp_text[286]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[287]);
      	}else{
      out.write(__oracle_jsp_text[288]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[289]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[290]);
      	} 
      			}
      			if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[291]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[292]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[293]);
      	
      			} 
      out.write(__oracle_jsp_text[294]);
       } 
      out.write(__oracle_jsp_text[295]);
       } else { 
      out.write(__oracle_jsp_text[296]);
       } 
      out.write(__oracle_jsp_text[297]);
      }
      }
      out.write(__oracle_jsp_text[298]);

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
  private static final char __oracle_jsp_text[][]=new char[299][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<html> \n<head> \n<TITLE>Asuntos por Turnar</TITLE>\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    " \n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<link rel=\"stylesheet\" href=\"../css/menu.css\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<META HTTP-EQUIV=\"Pragma\" CONTENT=\"no-cache\">\n<META HTTP-EQUIV=\"Expires\" CONTENT=\"-1\">\n<script language=\"JavaScript\" type=\"text/javascript\">\n\tfunction cambio(o, t){\n\t\tdoc = document._gestionTable1;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\n\tfunction desplegar(id){\n\t\tdoc = document._gestionTable1;\n\t\tif (id==doc.cambio1.value){\n\t\t\tdoc.cambio1.value=0;\n\t\t\tdoc.submit();\n\t\t}else{\n\t\t\tdoc.cambio1.value=id;\n\t\t\tdoc.contPag.value=0;\n\t\t\tdoc.contligas.value=0;\n\t\t\tdoc.submit();\n\t\t}\n\t}\n\tfunction desplegarT(id, ido){\n\t\tdoc = document._gestionTable1;\n\t\tif (id==doc.cambioT.value){\n\t\t\tdoc.cambioT.value=0;\n\t\t\tdoc.cambio1.value=ido\n\t\t\tdoc.submit();\n\t\t}else{\n\t\t\tdoc.cambioT.value=id;\n\t\t\tdoc.cambio1.value=ido\n\t\t\tdoc.contPag.value=0;\n\t\t\tdoc.contligas.value=0;\n\t\t\tdoc.submit();\n\t\t}\n\t}\nfunction pagina(contador){\n\tdoc = document._gestionTable1;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\n\nfunction paginaLiga(contador){\n\tdoc = document._gestionTable1;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</head>\n<body background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<span id=\"ruler\" style=\"visibility:hidden;\"></span> \n<form method=\"post\" action=\"portalPrincipal.jsp\" name=\"_gestionTable1\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"PP\" value=\"1\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\">\n<INPUT type=\"hidden\" name=\"cambio1\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\">\n<INPUT type=\"hidden\" name=\"cambioT\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"contligas\">\n<table cellspacing=\"2\" cellpadding=\"2\">\n<TBODY>\n\t<TR>\n\t\t<TD class=\"etiquetas\">\n\t\t\t\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\n<table cellspacing=\"2\" cellpadding=\"2\">\n\t<TBODY>\n\t\t<tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAtencion()\";>Asuntos en Recepción</a></td>\n                ".toCharArray();
    __oracle_jsp_text[14] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[15] = 
    "\n                    <td class=\"dominoSelTopTab\"  bgcolor=\"#004080\"><a onclick=\"goAsuntos()\";>Asuntos por turnar</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntosTr()\";>Asuntos en Trámite</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntosTer()\";>Asuntos terminados</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[17] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAtender()\";>Instrucciones por atender</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goTramite()\";>Instrucciones en Trámite</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goTerminadas()\";>Instrucciones terminadas</a></td>\n                ".toCharArray();
    __oracle_jsp_text[18] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[19] = 
    "\n                    <td class=\"dominoTopTab\" ><a onclick=\"goRechazadas()\";>Instrucciones rechazadas</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[21] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goSolicitada()\";>Asuntos Solicitados</a></td>\n                ".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t</tr>\n\t</TBODY>\n</table>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD id=\"Asunto_HD\" WIDTH='30%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tAsunto\n\t\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font></TD>\n\n\t\t<TD WIDTH='15%' align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">Folio</font>\n\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</TD>\n\t\t<TD id=\"Asunto_HD2\" WIDTH='15%' align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 3)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">Identificador del Docto.</font>\n\t\t\t<a onclick=\"cambio('desc', 3)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</TD>\n\t\t<TD WIDTH='15%' align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">Fecha de Recepción</font>\n\t\t\t<a onclick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</TD>\n\t\t<TD WIDTH='15%' align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 5)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">Fecha del Documento</font>\n\t\t\t<a onclick=\"cambio('desc', 5)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</TD>\n\t\t<TD WIDTH='10%' align=\"center\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"verdana\">Estatus</font></TD>\n\t</TR>\n</TABLE>\n<DIV class=documentBody id=Body>\n<div id=\"view\">\n<A onclick=\"desplegar(1)\">\n<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[23] = 
    "\" border=\"0\" height=\"16\" width=\"16\">\n<FONT face=\"Arial\" size=\"2\"><b>Mis Asuntos</b></FONT>\n</A>\n".toCharArray();
    __oracle_jsp_text[24] = 
    "\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD align=\"left\">\n\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A href=\"../ReporteAsuntoExcel?tip=porturnar_01\">\n\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t</A>\n\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t</TD>\n\t\t<TD align=\"right\">\n\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    " registros mostrados.\n\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[32] = 
    " de ".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[35] = 
    "\n<BR>\n".toCharArray();
    __oracle_jsp_text[36] = 
    "\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[41] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[42] = 
    ">\n\t\t\t\t<td width='30%'>\n\t\t\t\t\t<img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\" width=\"16\" alt=\"\">\n\t\t\t\t\t<FONT SIZE=1 ".toCharArray();
    __oracle_jsp_text[43] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[44] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[45] = 
    "\"".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t\t\t\tFACE=\"Verdana\"> <A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[47] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[48] = 
    "\" \n\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[49] = 
    "\"> \n                          <script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[50] = 
    "','Asunto_HD'));</script>\n                         </A>\n\t\t\t\t</Font></td>\n\t\t\t\t<td width='15%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[51] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[52] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[53] = 
    "\"".toCharArray();
    __oracle_jsp_text[54] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[55] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='15%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<a title=\"".toCharArray();
    __oracle_jsp_text[56] = 
    "\">\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[57] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[58] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[59] = 
    "\"".toCharArray();
    __oracle_jsp_text[60] = 
    " face=\"Arial\">\n\t\t\t\t\t<script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[61] = 
    "','Asunto_HD2'));</script>\n\t\t\t\t\t</a>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='15%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[62] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[63] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[64] = 
    "\"".toCharArray();
    __oracle_jsp_text[65] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[66] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='15%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[67] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[68] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[69] = 
    "\"".toCharArray();
    __oracle_jsp_text[70] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[71] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'><font size=\"2\" ".toCharArray();
    __oracle_jsp_text[72] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[73] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[74] = 
    "\"".toCharArray();
    __oracle_jsp_text[75] = 
    " face=\"Arial\"></font>\n\t\t\t\t<div align=center><IMG SRC='../Imagenes/gris5.gif' BORDER=0 ALT=''></div>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[76] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No tiene Asuntos por Turnar ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "\n\t\t<TR>\n\t\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[81] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[82] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[83] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[84] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[85] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[86] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[87] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[88] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[89] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[90] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[91] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[92] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[93] = 
    ")\">".toCharArray();
    __oracle_jsp_text[94] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[95] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[96] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[97] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[98] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[99] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[100] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[101] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[102] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[103] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[105] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[106] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No tiene Asuntos por Turnar ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[107] = 
    "\n\t</TBODY>\n</table>\n<BR>\n".toCharArray();
    __oracle_jsp_text[108] = 
    "\n".toCharArray();
    __oracle_jsp_text[109] = 
    "\n<A onclick=\"desplegar(2)\">\n<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[110] = 
    "\" border=\"0\" height=\"16\" width=\"16\">\n<FONT face=\"Arial\" size=\"2\"><b>Asuntos de la Ventanilla</b></FONT>\n</A>\n".toCharArray();
    __oracle_jsp_text[111] = 
    "\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD align=\"left\">\n\t\t".toCharArray();
    __oracle_jsp_text[112] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A href=\"../ReporteAsuntoExcel?tip=porturnar_02\">\n\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t</A>\n\t\t".toCharArray();
    __oracle_jsp_text[113] = 
    "\n\t\t</TD>\n\t\t<TD align=\"right\">\n\t\t".toCharArray();
    __oracle_jsp_text[114] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[115] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[116] = 
    " registros.\n\t\t".toCharArray();
    __oracle_jsp_text[117] = 
    "\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[118] = 
    "\n<BR>\n".toCharArray();
    __oracle_jsp_text[119] = 
    "\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[120] = 
    "\n\t\t<TR>\n\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t<TD width=\"99%\">\n\t\t<A onclick=\"desplegarT(".toCharArray();
    __oracle_jsp_text[121] = 
    ", 2)\">\n\t\t<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[122] = 
    "\" border=\"0\" height=\"16\" width=\"16\">\n\t\t<FONT face=\"Arial\" size=\"2\"><b>".toCharArray();
    __oracle_jsp_text[123] = 
    "</b></FONT>\n\t\t</A>\n\t\t\t".toCharArray();
    __oracle_jsp_text[124] = 
    "\n\t\t\t<TABLE width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t\t\t\t<TBODY>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD align=\"left\" width=\"50%\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[125] = 
    "\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD align=\"right\" width=\"50%\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[126] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[127] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[128] = 
    " registros mostrados. \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[129] = 
    "\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t\t<TABLE width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t\t\t\t<TBODY>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[130] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[131] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[132] = 
    "\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[133] = 
    "\n\t\t\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[134] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[135] = 
    ">\n\t\t\t\t\t\t<td width='30%'>\n\t\t\t\t\t\t\t<img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\" width=\"16\" alt=\"\">\n\t\t\t\t\t\t\t<FONT SIZE=2 ".toCharArray();
    __oracle_jsp_text[136] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[137] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[138] = 
    "\"".toCharArray();
    __oracle_jsp_text[139] = 
    " FACE=\"Verdana\">\n\t\t\t\t\t\t\t<A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[140] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[141] = 
    "\" title=\"".toCharArray();
    __oracle_jsp_text[142] = 
    "\">\n                            <script>\n                            \tdocument.write(trunc('".toCharArray();
    __oracle_jsp_text[143] = 
    "','Asunto_HD'));\n                            </script>\n                            </A>\n\t\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width='15%'>\n\t\t\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[144] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[145] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[146] = 
    "\"".toCharArray();
    __oracle_jsp_text[147] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[148] = 
    "</font>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width='15%'>\n\t\t\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t\t\t<a title=\"".toCharArray();
    __oracle_jsp_text[149] = 
    "\">\n\t\t\t\t\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[150] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[151] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[152] = 
    "\"".toCharArray();
    __oracle_jsp_text[153] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[154] = 
    "</font>\n\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width='15%'>\n\t\t\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[155] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[156] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[157] = 
    "\"".toCharArray();
    __oracle_jsp_text[158] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[159] = 
    "</font>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width='15%'>\n\t\t\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[160] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[161] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[162] = 
    "\"".toCharArray();
    __oracle_jsp_text[163] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[164] = 
    "</font>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width='10%'>\n\t\t\t\t\t\t\t<font size=\"2\" ".toCharArray();
    __oracle_jsp_text[165] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[166] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[167] = 
    "\"".toCharArray();
    __oracle_jsp_text[168] = 
    " face=\"Arial\"></font>\n\t\t\t\t\t\t\t<div align=center><IMG SRC='../Imagenes/gris5.gif' BORDER=0 ALT=''></div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[169] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[170] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[171] = 
    "\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD width=\"100%\">\n\t\t\t\t\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No hay Asuntos por Turnar de la Ventanilla ******</FONT></div>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[172] = 
    "\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[173] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[174] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[175] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[176] = 
    "\n\t\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[177] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[178] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[179] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[180] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[181] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[182] = 
    "\n                                                                <A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[183] = 
    ")\">\n\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[184] = 
    "\n\t\t\t\t\t\t\t\t\t<FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[185] = 
    "]</B></FONT>\n                                                                ".toCharArray();
    __oracle_jsp_text[186] = 
    "\n\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[187] = 
    "\n                                                                ".toCharArray();
    __oracle_jsp_text[188] = 
    "\n                                                                </A>&nbsp;\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[189] = 
    "\n\t\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[190] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[191] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[192] = 
    "\n\t\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[193] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[194] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[195] = 
    "\n\t\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[196] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[197] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[198] = 
    "\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[199] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[200] = 
    "\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD width=\"100%\">\n\t\t\t\t\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No hay Asuntos por Turnar de la Ventanilla ******</FONT></div>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[201] = 
    "\n\t\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t\t".toCharArray();
    __oracle_jsp_text[202] = 
    "\n\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[203] = 
    "\n                    <TR>\n                        <TD width=\"100%\">\n                            <div align=center><FONT face=\"Arial\" size=\"4\">****** No hay Asuntos por Turnar de la Ventanilla ******</FONT></div>\n\t\t\t</TD>\n                    </TR>\n                ".toCharArray();
    __oracle_jsp_text[204] = 
    "\n\t</TBODY>\n</table>\n<BR>\n".toCharArray();
    __oracle_jsp_text[205] = 
    "\n<A onclick=\"desplegar(3)\">\n<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[206] = 
    "\" border=\"0\" height=\"16\" width=\"16\">\n<FONT face=\"Arial\" size=\"2\"><b>De otras Ventanillas</b></FONT>\n</A>\n".toCharArray();
    __oracle_jsp_text[207] = 
    "\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD align=\"left\">\n\t\t".toCharArray();
    __oracle_jsp_text[208] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A href=\"../ReporteAsuntoExcel?tip=porturnar_03\">\n\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t</A>\n\t\t".toCharArray();
    __oracle_jsp_text[209] = 
    "\n\t\t</TD>\n\t\t<TD align=\"right\">\n\t\t".toCharArray();
    __oracle_jsp_text[210] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[211] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[212] = 
    " registros mostrados.\n\t\t".toCharArray();
    __oracle_jsp_text[213] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[214] = 
    "\n\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[215] = 
    " de ".toCharArray();
    __oracle_jsp_text[216] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[217] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[218] = 
    "\n<BR>\n".toCharArray();
    __oracle_jsp_text[219] = 
    "\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[220] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[221] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[222] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[223] = 
    "\n\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[224] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[225] = 
    ">\n\t\t\t\t<td width='30%'>\n\t\t\t\t\t<img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\" width=\"16\" alt=\"\">\n\t\t\t\t\t<FONT SIZE=2 ".toCharArray();
    __oracle_jsp_text[226] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[227] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[228] = 
    "\"".toCharArray();
    __oracle_jsp_text[229] = 
    " FACE=\"Verdana\">\n\t\t\t\t\t<A href=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[230] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[231] = 
    "\"\n\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[232] = 
    "(".toCharArray();
    __oracle_jsp_text[233] = 
    " ".toCharArray();
    __oracle_jsp_text[234] = 
    " ".toCharArray();
    __oracle_jsp_text[235] = 
    " ".toCharArray();
    __oracle_jsp_text[236] = 
    ")\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[237] = 
    "(".toCharArray();
    __oracle_jsp_text[238] = 
    " ".toCharArray();
    __oracle_jsp_text[239] = 
    " ".toCharArray();
    __oracle_jsp_text[240] = 
    " ".toCharArray();
    __oracle_jsp_text[241] = 
    ")\n\t\t\t\t\t</A>\n\t\t\t\t\t</Font>\n\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td width='15%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[242] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[243] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[244] = 
    "\"".toCharArray();
    __oracle_jsp_text[245] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[246] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='15%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<a title=\"".toCharArray();
    __oracle_jsp_text[247] = 
    "\">\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[248] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[249] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[250] = 
    "\"".toCharArray();
    __oracle_jsp_text[251] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[252] = 
    "</font>\n\t\t\t\t\t</a>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='15%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[253] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[254] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[255] = 
    "\"".toCharArray();
    __oracle_jsp_text[256] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[257] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='15%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[258] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[259] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[260] = 
    "\"".toCharArray();
    __oracle_jsp_text[261] = 
    " face=\"Arial\">--</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'><font size=\"2\" ".toCharArray();
    __oracle_jsp_text[262] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[263] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[264] = 
    "\"".toCharArray();
    __oracle_jsp_text[265] = 
    " face=\"Arial\"></font>\n\t\t\t\t<div align=center><IMG SRC='../Imagenes/gris5.gif' BORDER=0 ALT=''></div>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[266] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[267] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[268] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No hay Asuntos por Turnar de otras Ventanillas ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[269] = 
    "\n\t\t<TR>\n\t\t<TD colspan=\"8\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[270] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[271] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[272] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[273] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[274] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[275] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[276] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[277] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[278] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[279] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[280] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[281] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[282] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[283] = 
    ")\">".toCharArray();
    __oracle_jsp_text[284] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[285] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[286] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[287] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[288] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[289] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[290] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[291] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[292] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[293] = 
    ");\"> <B>&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[294] = 
    "\n\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[295] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[296] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No hay Asuntos por Turnar de otras Ventanillas ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[297] = 
    "\n\t</TBODY>\n</table>\n".toCharArray();
    __oracle_jsp_text[298] = 
    "\n</div>\n<br>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</form>\n</body>\n</html>\n\n\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
