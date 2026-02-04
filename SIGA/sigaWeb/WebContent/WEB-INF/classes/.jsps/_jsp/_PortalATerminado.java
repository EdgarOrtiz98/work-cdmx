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
import com.meve.sigma.util.*;
import com.meve.sigma.reportes.*;


public class _PortalATerminado extends com.orionserver.http.OrionHttpJspPage {


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
    _PortalATerminado page = this;
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
      	if(BUsuario==null)
      		response.sendRedirect("index.jsp?pagina="+ strTmp);		
      
      
      out.write(__oracle_jsp_text[5]);
      
      	boolean bExiste	= false;
      	boolean bExisteInsAsunto = false;
      	boolean bExisteMisAsuntos = false;
      	boolean noPuedeVerVentanillas		=   AsuntoVerifica.noPuedeUaVerVentanillas(session.getServletContext(),BUsuario.getIdArea());
      	int iDuracion = 0;
      	float fPorcentaje = 0;
      	float fAvance = 0;
      	int t = 0;
      	String strActivarPortal = application.getInitParameter("ActivarPortal");
      	String strAccion 	= 	request.getParameter("accion");
      	String strOrden 	= 	(request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo 		= 	(request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
      	String strCambio 	= 	(request.getParameter("cambio1")!=null)?request.getParameter("cambio1"):"0";
      	String strCambioT	=	(request.getParameter("cambioT")!=null)?request.getParameter("cambioT"):"0";
      	//String subVentanilla=	ActualizaInstrucciones.getAreaSubventanilla(BUsuario.getIdArea());
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
      
      out.write(__oracle_jsp_text[6]);
      out.write(__oracle_jsp_text[7]);
      out.print(strCambio);
      out.write(__oracle_jsp_text[8]);
      out.print( strOrden );
      out.write(__oracle_jsp_text[9]);
      out.print(strTipo );
      out.write(__oracle_jsp_text[10]);
      out.print(strCambio);
      out.write(__oracle_jsp_text[11]);
      out.print(strCambioT);
      out.write(__oracle_jsp_text[12]);
      out.print( contPag );
      out.write(__oracle_jsp_text[13]);
      out.print( contligas );
      out.write(__oracle_jsp_text[14]);
      if(BUsuario.getTurnado() || BUsuario.getRecepcion()){
      out.write(__oracle_jsp_text[15]);
      }
      out.write(__oracle_jsp_text[16]);
      if(BUsuario.getTurnado()){
      out.write(__oracle_jsp_text[17]);
      }
      out.write(__oracle_jsp_text[18]);
      if(BUsuario.getAtencion()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[19]);
      }
      out.write(__oracle_jsp_text[20]);
      if(BUsuario.getAtencion()||BUsuario.getRecepcion()||BUsuario.getSupervisor()||BUsuario.getTurnado()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[21]);
      }
      out.write(__oracle_jsp_text[22]);
      if(BUsuario.getAtencion()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[23]);
      }
      out.write(__oracle_jsp_text[24]);
      out.print((strCambio.equals("1"))?"collapse.gif":"expand.gif");
      out.write(__oracle_jsp_text[25]);
      	if(strCambio.equals("1")){
      out.write(__oracle_jsp_text[26]);
      	numRegistros = ActualizaAsunto.getDatosMisAsuntosTerminado(strOrden, strTipo, BUsuario.getIdUsuario()).length;
      			if (numRegistros>0){ 
      out.write(__oracle_jsp_text[27]);
      	} 
      out.write(__oracle_jsp_text[28]);
      	numPaginas = numRegistros/regPorPagina;	
      			if (numRegistros%regPorPagina != 0)
      				numPaginas++; 
      out.write(__oracle_jsp_text[29]);
      	if (numRegistros > 0){	
      out.write(__oracle_jsp_text[30]);
      out.print( numRegistros );
      out.write(__oracle_jsp_text[31]);
      	} 
      out.write(__oracle_jsp_text[32]);
      	if (numPaginas > 1){	
      out.write(__oracle_jsp_text[33]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[34]);
      out.print( numPaginas );
      out.write(__oracle_jsp_text[35]);
       	} 
      out.write(__oracle_jsp_text[36]);
      	} 
      out.write(__oracle_jsp_text[37]);
      if(strCambio.equals("1")){
      out.write(__oracle_jsp_text[38]);
      
      		bExisteMisAsuntos = ActualizaAsunto.getExistenMisAsuntosTerminados(BUsuario.getIdUsuario());
      		if(bExisteMisAsuntos){
      		
      out.write(__oracle_jsp_text[39]);
       int j = 0; 
      out.write(__oracle_jsp_text[40]);
      	String[][] sql = ActualizaAsunto.getDatosMisAsuntosTerminado(strOrden, strTipo, BUsuario.getIdUsuario());
      			for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
      				String campo1 = sql[i][0];
      				String campo2 = sql[i][1];
      				String campo3 = sql[i][2];
      				String campo4 = sql[i][3];
      				String campo5 = sql[i][4];
      				String campo6 = sql[i][5];
      				String campo7 = sql[i][6];
      				String campo8 = sql[i][7];
      		
      out.write(__oracle_jsp_text[41]);
       t++; 
      out.write(__oracle_jsp_text[42]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[43]);
      }
      out.write(__oracle_jsp_text[44]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[45]);
      }else{
      out.write(__oracle_jsp_text[46]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[47]);
      }
      out.write(__oracle_jsp_text[48]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[49]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&cambio1="+strCambio+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[50]);
      out.print( campo2 );
      out.write(__oracle_jsp_text[51]);
      out.print( Utilerias.recortaString(campo2,40) );
      out.write(__oracle_jsp_text[52]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[53]);
      }else{
      out.write(__oracle_jsp_text[54]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[55]);
      }
      out.write(__oracle_jsp_text[56]);
      out.print(campo4 );
      out.write(__oracle_jsp_text[57]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[58]);
      }else{
      out.write(__oracle_jsp_text[59]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[60]);
      }
      out.write(__oracle_jsp_text[61]);
      out.print(campo5 );
      out.write(__oracle_jsp_text[62]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[63]);
      }else{
      out.write(__oracle_jsp_text[64]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[65]);
      }
      out.write(__oracle_jsp_text[66]);
      out.print(campo8 );
      out.write(__oracle_jsp_text[67]);
      	
      					fAvance = new Float(campo5).floatValue();
      					if(fAvance >= 100){
      				
      out.write(__oracle_jsp_text[68]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[69]);
      }else{
      out.write(__oracle_jsp_text[70]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[71]);
      }
      out.write(__oracle_jsp_text[72]);
      }else{
      out.write(__oracle_jsp_text[73]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[74]);
      }else{
      out.write(__oracle_jsp_text[75]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[76]);
      }
      out.write(__oracle_jsp_text[77]);
      }
      out.write(__oracle_jsp_text[78]);
       j++; 
      out.write(__oracle_jsp_text[79]);
       } 
      out.write(__oracle_jsp_text[80]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[81]);
       } else {
      out.write(__oracle_jsp_text[82]);
      
      			int numeroPaginas = (sql!=null)?sql.length/regPorPagina:0;	
      			if (sql.length%regPorPagina != 0)
      				numeroPaginas++; 
      			if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[83]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[84]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[85]);
      	}
      			if (contPag > 0){  
      				if (contPag > contligas){
      out.write(__oracle_jsp_text[86]);
      out.print(contligas);
      out.write(__oracle_jsp_text[87]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[88]);
      	}else{
      out.write(__oracle_jsp_text[89]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[90]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[91]);
      	} 
      			}
      			if (numeroPaginas > 1){
      				for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
      					if (i==contPag){  
      out.write(__oracle_jsp_text[92]);
      out.print(i);
      out.write(__oracle_jsp_text[93]);
      out.print(i+1);
      out.write(__oracle_jsp_text[94]);
      		}else{ 
      out.write(__oracle_jsp_text[95]);
      out.print(i);
      out.write(__oracle_jsp_text[96]);
      out.print(i+1);
      out.write(__oracle_jsp_text[97]);
      		}
      				}
      			} 
      			if (contPag < numeroPaginas-1){  
      				if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[98]);
      out.print(contligas);
      out.write(__oracle_jsp_text[99]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[100]);
      	}else{
      out.write(__oracle_jsp_text[101]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[102]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[103]);
      	} 
      			}
      			if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[104]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[105]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[106]);
      	
      			} 
      out.write(__oracle_jsp_text[107]);
       } 
      out.write(__oracle_jsp_text[108]);
       } else { 
      out.write(__oracle_jsp_text[109]);
       } 
      out.write(__oracle_jsp_text[110]);
      }
      if(!noPuedeVerVentanillas){
      out.write(__oracle_jsp_text[111]);
      out.print((strCambio.equals("2"))?"collapse.gif":"expand.gif");
      out.write(__oracle_jsp_text[112]);
      	if(strCambio.equals("2")){
      out.write(__oracle_jsp_text[113]);
      	numRegistros = ActualizaAsunto.getDatosAsuntoTerminado(strOrden, strTipo, BUsuario.getIdArea(), BUsuario.getIdUsuario()).length;
      			if (numRegistros>0){ 
      out.write(__oracle_jsp_text[114]);
      	} 
      out.write(__oracle_jsp_text[115]);
      	numPaginas = numRegistros/regPorPagina;	
      			if (numRegistros%regPorPagina != 0)
      				numPaginas++; 
      out.write(__oracle_jsp_text[116]);
      	if (numRegistros > 0){	
      out.write(__oracle_jsp_text[117]);
      out.print( numRegistros );
      out.write(__oracle_jsp_text[118]);
      	} 
      out.write(__oracle_jsp_text[119]);
      	} 
      out.write(__oracle_jsp_text[120]);
      if(strCambio.equals("2")){
      out.write(__oracle_jsp_text[121]);
      
      		String[][] turnadores = ActualizaAsunto.getTurnadoreUnidadTerminado(BUsuario.getIdArea(), BUsuario.getIdUsuario());
                      if(turnadores.length==0){
      out.write(__oracle_jsp_text[122]);
      }
                      for(int i=0;i<turnadores.length;i++){
      		int iCount = i+4;
      		String count = String.valueOf(iCount);
      		
      out.write(__oracle_jsp_text[123]);
      out.print(count);
      out.write(__oracle_jsp_text[124]);
      out.print((strCambioT.equals(count))?"collapse.gif":"expand.gif");
      out.write(__oracle_jsp_text[125]);
      out.print(turnadores[i][1]);
      out.write(__oracle_jsp_text[126]);
      if(strCambioT.equals(count)){
      out.write(__oracle_jsp_text[127]);
      numRegistros = ActualizaAsunto.datosAsuntoTurnadorTerminado(strOrden, strTipo, BUsuario.getIdArea(), turnadores[i][0]).length; 
      out.write(__oracle_jsp_text[128]);
      	numPaginas = numRegistros/regPorPagina;	
      						if (numRegistros%regPorPagina != 0)
      						numPaginas++; 
      out.write(__oracle_jsp_text[129]);
      if(numRegistros > 0){
      out.write(__oracle_jsp_text[130]);
      out.print(numRegistros);
      out.write(__oracle_jsp_text[131]);
      }
      out.write(__oracle_jsp_text[132]);
      
      					bExiste	= ActualizaAsunto.existeAsuntoTurnadorTerminado(BUsuario.getIdArea(), turnadores[i][0]); 
      					if(bExiste){
      					
      out.write(__oracle_jsp_text[133]);
       int j = 0; 
      out.write(__oracle_jsp_text[134]);
      	String[][] sql = ActualizaAsunto.datosAsuntoTurnadorTerminado(strOrden, strTipo, BUsuario.getIdArea(), turnadores[i][0]);
      						for (int y=contPag*regPorPagina; y<sql.length && y<(contPag+1)*regPorPagina; y++){
      							String campo1 = sql[y][0];
      							String campo2 = sql[y][1];
      							String campo3 = sql[y][2];
      							String campo4 = sql[y][3];
      							String campo5 = sql[y][4];
      							String campo6 = sql[y][5];
      							String campo7 = sql[y][6];
      							String campo8 = sql[y][7];
      					
      					
      out.write(__oracle_jsp_text[135]);
       t++; 
      out.write(__oracle_jsp_text[136]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[137]);
      }
      out.write(__oracle_jsp_text[138]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[139]);
      }else{
      out.write(__oracle_jsp_text[140]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[141]);
      }
      out.write(__oracle_jsp_text[142]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[143]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&cambio1="+strCambio+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[144]);
      out.print( campo2 );
      out.write(__oracle_jsp_text[145]);
      out.print( Utilerias.recortaString(campo2,40) );
      out.write(__oracle_jsp_text[146]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[147]);
      }else{
      out.write(__oracle_jsp_text[148]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[149]);
      }
      out.write(__oracle_jsp_text[150]);
      out.print(campo4 );
      out.write(__oracle_jsp_text[151]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[152]);
      }else{
      out.write(__oracle_jsp_text[153]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[154]);
      }
      out.write(__oracle_jsp_text[155]);
      out.print(campo5 );
      out.write(__oracle_jsp_text[156]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[157]);
      }else{
      out.write(__oracle_jsp_text[158]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[159]);
      }
      out.write(__oracle_jsp_text[160]);
      out.print(campo8 );
      out.write(__oracle_jsp_text[161]);
      	
      						fAvance = new Float(campo5).floatValue();
      						if(fAvance >= 100){
      						
      out.write(__oracle_jsp_text[162]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[163]);
      }else{
      out.write(__oracle_jsp_text[164]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[165]);
      }
      out.write(__oracle_jsp_text[166]);
      }else{
      out.write(__oracle_jsp_text[167]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[168]);
      }else{
      out.write(__oracle_jsp_text[169]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[170]);
      }
      out.write(__oracle_jsp_text[171]);
      }
      out.write(__oracle_jsp_text[172]);
       j++; 
      out.write(__oracle_jsp_text[173]);
      }
      out.write(__oracle_jsp_text[174]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[175]);
      }else{
      out.write(__oracle_jsp_text[176]);
      
      						int numeroPaginas = (sql!=null)?sql.length/regPorPagina:0;	
      						if (sql.length%regPorPagina != 0)
      							numeroPaginas++; 
      						if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[177]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[178]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[179]);
      	}
      						if (contPag > 0){  
      							if (contPag > contligas){
      out.write(__oracle_jsp_text[180]);
      out.print(contligas);
      out.write(__oracle_jsp_text[181]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[182]);
      	}else{
      out.write(__oracle_jsp_text[183]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[184]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[185]);
      	} 
      						}
      						if (numeroPaginas > 1){
      							for (int k=contligas; k<muestraPaginas+contligas && k<numeroPaginas; k++){ 
      								if (i==contPag){  
      out.write(__oracle_jsp_text[186]);
      out.print(k);
      out.write(__oracle_jsp_text[187]);
      out.print(k+1);
      out.write(__oracle_jsp_text[188]);
      	}else{ 
      out.write(__oracle_jsp_text[189]);
      out.print(k);
      out.write(__oracle_jsp_text[190]);
      out.print(k+1);
      out.write(__oracle_jsp_text[191]);
      	}
      							}
      						} 
      						if (contPag < numeroPaginas-1){  
      							if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[192]);
      out.print(contligas);
      out.write(__oracle_jsp_text[193]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[194]);
      	}else{
      out.write(__oracle_jsp_text[195]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[196]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[197]);
      	} 
      						}
      						if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[198]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[199]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[200]);
      }
      out.write(__oracle_jsp_text[201]);
      }
      out.write(__oracle_jsp_text[202]);
      }else{
      out.write(__oracle_jsp_text[203]);
      }
      out.write(__oracle_jsp_text[204]);
      }
      out.write(__oracle_jsp_text[205]);
      }
      out.write(__oracle_jsp_text[206]);
      }
      out.write(__oracle_jsp_text[207]);
      out.print((strCambio.equals("3"))?"collapse.gif":"expand.gif");
      out.write(__oracle_jsp_text[208]);
      	if(strCambio.equals("3")){
      out.write(__oracle_jsp_text[209]);
      	if(!BUsuario.getSupervisor()){//Un rol de atención 
      			numRegistros = ActualizaInstrucciones.getInstruccionTerminadaUsuarioAsunto(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea(), 1).length;
      			}else{
      			numRegistros = ActualizaInstrucciones.getInstruccionTerminadaUsuarioAsunto(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea(), 1).length;
      			}
      			if (numRegistros>0){ 
      out.write(__oracle_jsp_text[210]);
      	} 
      out.write(__oracle_jsp_text[211]);
      	numPaginas = numRegistros/regPorPagina;	
      			if (numRegistros%regPorPagina != 0)
      				numPaginas++; 
      out.write(__oracle_jsp_text[212]);
      	if (numRegistros > 0){	
      out.write(__oracle_jsp_text[213]);
      out.print( numRegistros );
      out.write(__oracle_jsp_text[214]);
      	} 
      out.write(__oracle_jsp_text[215]);
      	if (numPaginas > 1){	
      out.write(__oracle_jsp_text[216]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[217]);
      out.print( numPaginas );
      out.write(__oracle_jsp_text[218]);
       	} 
      out.write(__oracle_jsp_text[219]);
      	} 
      out.write(__oracle_jsp_text[220]);
      if(strCambio.equals("3")){
      out.write(__oracle_jsp_text[221]);
      
      		bExisteInsAsunto = ActualizaInstrucciones.TieneInstruccionesTerminadasAsunto(BUsuario.getIdUsuario());
      		if(numRegistros!=0){
      		
      out.write(__oracle_jsp_text[222]);
       int j = 0; 
      out.write(__oracle_jsp_text[223]);
      	String[][] sql = null;
      			if(!BUsuario.getSupervisor()){//Un rol de atención
      			sql = ActualizaInstrucciones.getInstruccionTerminadaUsuarioAsunto(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea(), 1);
      			}else{
      			sql = ActualizaInstrucciones.getInstruccionTerminadaUsuarioAsunto(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea(), 1);
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
      				String campo11 = sql[i][10];
      				String campo12 = sql[i][11];
      		
      out.write(__oracle_jsp_text[224]);
       t++; 
      out.write(__oracle_jsp_text[225]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[226]);
      }
      out.write(__oracle_jsp_text[227]);
      if(campo10.length() == 0){
      out.write(__oracle_jsp_text[228]);
      }else{
      out.write(__oracle_jsp_text[229]);
      out.print(campo10 );
      out.write(__oracle_jsp_text[230]);
      }
      out.write(__oracle_jsp_text[231]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[232]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&cambio1="+strCambio+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[233]);
      out.print(campo11);
      out.write(__oracle_jsp_text[234]);
       if(campo2.length() == 0){ 
      out.write(__oracle_jsp_text[235]);
      out.print( campo3 );
      out.write(__oracle_jsp_text[236]);
       }else{ 
      out.write(__oracle_jsp_text[237]);
      out.print( ActualizaInst.getNombreInstruccion1(campo2) );
      }
      out.write(__oracle_jsp_text[238]);
      out.print(Utilerias.recortaString(campo12,20));
      out.write(__oracle_jsp_text[239]);
       if(campo2.length() == 0){ 
      out.write(__oracle_jsp_text[240]);
      out.print( Utilerias.recortaString(campo3,20) );
      out.write(__oracle_jsp_text[241]);
       }else{ 
      out.write(__oracle_jsp_text[242]);
      out.print( Utilerias.recortaString(ActualizaInst.getNombreInstruccion1(campo2),20) );
      }
      out.write(__oracle_jsp_text[243]);
      if(campo10.length() == 0){
      out.write(__oracle_jsp_text[244]);
      }else{
      out.write(__oracle_jsp_text[245]);
      out.print(campo10 );
      out.write(__oracle_jsp_text[246]);
      }
      out.write(__oracle_jsp_text[247]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[248]);
      if(campo10.length() == 0){
      out.write(__oracle_jsp_text[249]);
      }else{
      out.write(__oracle_jsp_text[250]);
      out.print(campo10 );
      out.write(__oracle_jsp_text[251]);
      }
      out.write(__oracle_jsp_text[252]);
      out.print(campo9 );
      out.write(__oracle_jsp_text[253]);
      if(campo10.length() == 0){
      out.write(__oracle_jsp_text[254]);
      }else{
      out.write(__oracle_jsp_text[255]);
      out.print(campo10 );
      out.write(__oracle_jsp_text[256]);
      }
      out.write(__oracle_jsp_text[257]);
      out.print(campo4 );
      out.write(__oracle_jsp_text[258]);
      
      							iDuracion = Utilerias.DiasdeTrabajoEntre(Utilerias.StringCalendar(campo4), 
      																	Utilerias.StringCalendar(campo5), 0);
      							fPorcentaje = Utilerias.getPorcentajeDebido(iDuracion, campo4, campo5, 5);
      							fAvance = new Float(campo9).floatValue();
      							if(fPorcentaje>=100){
      						
      out.write(__oracle_jsp_text[259]);
       }else if(fPorcentaje < 75  ){ 
      out.write(__oracle_jsp_text[260]);
       }else if(fPorcentaje >= 75){ 
      out.write(__oracle_jsp_text[261]);
       } 
      out.write(__oracle_jsp_text[262]);
       j++; 
      out.write(__oracle_jsp_text[263]);
       } 
      out.write(__oracle_jsp_text[264]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[265]);
       } else {
      out.write(__oracle_jsp_text[266]);
      
      			int numeroPaginas = (sql!=null)?sql.length/regPorPagina:0;	
      			if (sql.length%regPorPagina != 0)
      				numeroPaginas++; 
      			if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[267]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[268]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[269]);
      	}
      			if (contPag > 0){  
      				if (contPag > contligas){
      out.write(__oracle_jsp_text[270]);
      out.print(contligas);
      out.write(__oracle_jsp_text[271]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[272]);
      	}else{
      out.write(__oracle_jsp_text[273]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[274]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[275]);
      	} 
      			}
      			if (numeroPaginas > 1){
      				for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
      					if (i==contPag){  
      out.write(__oracle_jsp_text[276]);
      out.print(i);
      out.write(__oracle_jsp_text[277]);
      out.print(i+1);
      out.write(__oracle_jsp_text[278]);
      		}else{ 
      out.write(__oracle_jsp_text[279]);
      out.print(i);
      out.write(__oracle_jsp_text[280]);
      out.print(i+1);
      out.write(__oracle_jsp_text[281]);
      		}
      				}
      			} 
      			if (contPag < numeroPaginas-1){  
      				if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[282]);
      out.print(contligas);
      out.write(__oracle_jsp_text[283]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[284]);
      	}else{
      out.write(__oracle_jsp_text[285]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[286]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[287]);
      	} 
      			}
      			if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[288]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[289]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[290]);
      	
      			} 
      out.write(__oracle_jsp_text[291]);
       } 
      out.write(__oracle_jsp_text[292]);
       } else { 
      out.write(__oracle_jsp_text[293]);
       } 
      out.write(__oracle_jsp_text[294]);
      }
      }
      out.write(__oracle_jsp_text[295]);

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
  private static final char __oracle_jsp_text[][]=new char[296][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Asuntos Terminados</TITLE>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script language=\"JavaScript\" type=\"text/javascript\">\n\tfunction cambio(o, t){\n\t\tdoc = document.pATerminado;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\t//doc.cambio1.value=".toCharArray();
    __oracle_jsp_text[8] = 
    ";\n\t\tdoc.submit();\n\t}\n\tfunction desplegar(id){\n\t\tdoc = document.pATerminado;\n\t\tif (id==doc.cambio1.value){\n\t\t\tdoc.cambio1.value=0;\n\t\t\tdoc.submit();\n\t\t}else{\n\t\t\tdoc.cambio1.value=id;\n\t\t\tdoc.contPag.value=0;\n\t\t\tdoc.contligas.value=0;\n\t\t\tdoc.submit();\n\t\t}\n\t}\n\tfunction desplegarT(id, ido){\n\t\tdoc = document.pATerminado;\n\t\tif (id==doc.cambioT.value){\n\t\t\tdoc.cambioT.value=0;\n\t\t\tdoc.cambio1.value=ido\n\t\t\tdoc.submit();\n\t\t}else{\n\t\t\tdoc.cambioT.value=id;\n\t\t\tdoc.cambio1.value=ido\n\t\t\tdoc.contPag.value=0;\n\t\t\tdoc.contligas.value=0;\n\t\t\tdoc.submit();\n\t\t}\n\t}\nfunction pagina(contador){\n\tdoc = document.pATerminado;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\n\nfunction paginaLiga(contador){\n\tdoc = document.pATerminado;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n\n<form method=\"post\" action=\"PortalATerminado.jsp\" name=\"pATerminado\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"cambio1\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\">\n<INPUT type=\"hidden\" name=\"cambioT\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"contligas\">\n<table cellspacing=\"2\" cellpadding=\"2\">\n<TBODY>\n\t<TR>\n\t\t<TD class=\"etiquetas\">\n\t\t\t\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\n<table cellspacing=\"2\" cellpadding=\"2\">\n\t<TBODY>\n\t\t<tr>\n\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAtencion()\";>Asuntos en Recepción</a></td>\n                ".toCharArray();
    __oracle_jsp_text[16] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[17] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntos()\";>Asuntos por turnar</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntosTr()\";>Asuntos en Trámite</a></td>\n                    <td class=\"dominoSelTopTab\" bgcolor=\"#004080\"><a onclick=\"goAsuntosTer()\";>Asuntos terminados</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[19] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAtender()\";>Instrucciones por atender</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goTramite()\";>Instrucciones en Trámite</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goTerminadas()\";>Instrucciones terminadas</a></td>\n                ".toCharArray();
    __oracle_jsp_text[20] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[21] = 
    "\n                    <td class=\"dominoTopTab\" ><a onclick=\"goRechazadas()\";>Instrucciones rechazadas</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[23] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goSolicitada()\";>Asuntos Solicitados</a></td>\n                ".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t</tr>\n\t</TBODY>\n</table>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='40%' align=\"center\">\n\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\tAsunto\n\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</font></TD>\n\t\t<TD WIDTH='20%' align=\"center\">\n\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\tFolio\n\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</font></TD>\n\t\t<TD WIDTH='10%' align=\"center\">\n\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t<a onclick=\"cambio('asc', 3)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\tAvance (%)\n\t\t<a onclick=\"cambio('desc', 3)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</font></TD>\n\t\t<TD WIDTH='20%' align=\"center\">\n\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t<a onclick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\tFecha terminación\n\t\t<a onclick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</font></TD>\n\t\t<TD WIDTH='10%' align=\"center\"><FONT SIZE=1 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"verdana\">Estatus</font></TD>\n\t</TR>\n</TABLE>\n<DIV class=documentBody id=Body>\n<div id=\"view\">\n<A onclick=\"desplegar(1)\">\n<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[25] = 
    "\" border=\"0\" height=\"16\" width=\"16\">\n<FONT face=\"Arial\" size=\"2\"><b>Mis Asuntos</b></FONT>\n</A>\n".toCharArray();
    __oracle_jsp_text[26] = 
    "\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD align=\"left\">\n\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A href=\"../ReporteAsuntoExcel?tip=terminado_01\">\n\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t</A> \n\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t</TD>\n\t\t<TD align=\"right\">\n\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    " registros mostrados.\n\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[34] = 
    " de ".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[37] = 
    "\n<BR>\n".toCharArray();
    __oracle_jsp_text[38] = 
    "\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[43] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[44] = 
    ">\n\t\t\t\t<td width='40%'><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"16\" alt=\"\"> <FONT SIZE=2 ".toCharArray();
    __oracle_jsp_text[45] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[46] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[47] = 
    "\"".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t\t\tFACE=\"Verdana\"> <A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[49] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[50] = 
    "\" \n\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[51] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[52] = 
    "</A>\n\t\t\t\t</Font></td>\n\t\t\t\t<td width='20%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[53] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[54] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[55] = 
    "\"".toCharArray();
    __oracle_jsp_text[56] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[57] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[58] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[59] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[60] = 
    "\"".toCharArray();
    __oracle_jsp_text[61] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[62] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='20%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[63] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[64] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[65] = 
    "\"".toCharArray();
    __oracle_jsp_text[66] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[67] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'><font size=\"2\" face=\"Verdana\"></font>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[69] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[70] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[71] = 
    "\"".toCharArray();
    __oracle_jsp_text[72] = 
    " face=\"Arial\">Terminado</font>\n\t\t\t\t</div>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[74] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[75] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[76] = 
    "\"".toCharArray();
    __oracle_jsp_text[77] = 
    " face=\"Arial\">Por Aprobar</font>\n\t\t\t\t</div>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[81] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"verdana\" size=\"4\">****** No tiene Asuntos Terminados ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[82] = 
    "\n\t\t<TR>\n\t\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[83] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[84] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[85] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[86] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[87] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[88] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[89] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[90] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[91] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[92] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[93] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[94] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[95] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[96] = 
    ")\">".toCharArray();
    __oracle_jsp_text[97] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[98] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[99] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[100] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[101] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[102] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[103] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[105] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[106] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[107] = 
    "\n\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[108] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[109] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"verdana\" size=\"4\">****** No tiene Asuntos Terminados ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[110] = 
    "\n\t</TBODY>\n</table>\n<BR>\n".toCharArray();
    __oracle_jsp_text[111] = 
    "\n<A onclick=\"desplegar(2)\">\n<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[112] = 
    "\" border=\"0\" height=\"16\" width=\"16\">\n<FONT face=\"Arial\" size=\"2\"><b>Asuntos de la Ventanilla</b></FONT>\n</A>\n".toCharArray();
    __oracle_jsp_text[113] = 
    "\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD align=\"left\">\n\t\t".toCharArray();
    __oracle_jsp_text[114] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A href=\"../ReporteAsuntoExcel?tip=terminado_02\">\n\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t</A> \n\t\t".toCharArray();
    __oracle_jsp_text[115] = 
    "\n\t\t</TD>\n\t\t<TD align=\"right\">\n\t\t".toCharArray();
    __oracle_jsp_text[116] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[117] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[118] = 
    " registros mostrados.\n\t\t".toCharArray();
    __oracle_jsp_text[119] = 
    "\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[120] = 
    "\n<BR>\n".toCharArray();
    __oracle_jsp_text[121] = 
    "\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[122] = 
    "\n                <TR>\n\t\t\t\t\t\t<TD width=\"100%\">\n\t\t\t\t\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No hay Asuntos Terminados de la Ventanilla ******</FONT></div>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n                ".toCharArray();
    __oracle_jsp_text[123] = 
    "\n\t\t<TR>\n\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t<TD width=\"99%\">\n\t\t<A onclick=\"desplegarT(".toCharArray();
    __oracle_jsp_text[124] = 
    ", 2)\">\n\t\t<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[125] = 
    "\" border=\"0\" height=\"16\" width=\"16\">\n\t\t<FONT face=\"Arial\" size=\"2\"><b>".toCharArray();
    __oracle_jsp_text[126] = 
    "</b></FONT>\n\t\t</A>\n\t\t\t".toCharArray();
    __oracle_jsp_text[127] = 
    "\n\t\t\t<TABLE width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t\t\t\t<TBODY>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD align=\"left\" width=\"50%\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[128] = 
    "\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD align=\"right\" width=\"50%\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[129] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[130] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[131] = 
    " registros mostrados. \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[132] = 
    "\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t\t<TABLE width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t\t\t\t<TBODY>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[133] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[134] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[135] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[136] = 
    "\n\t\t\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[137] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[138] = 
    ">\n\t\t\t\t\t\t<td width='40%'><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\t\theight=\"1\" width=\"16\" alt=\"\"> <FONT SIZE=2 ".toCharArray();
    __oracle_jsp_text[139] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[140] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[141] = 
    "\"".toCharArray();
    __oracle_jsp_text[142] = 
    "\n\t\t\t\t\t\t\tFACE=\"Verdana\"> <A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[143] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[144] = 
    "\" \n\t\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[145] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[146] = 
    "</A>\n\t\t\t\t\t\t\t</Font></td>\n\t\t\t\t\t\t<td width='20%'>\n\t\t\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[147] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[148] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[149] = 
    "\"".toCharArray();
    __oracle_jsp_text[150] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[151] = 
    "</font>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width='10%'>\n\t\t\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[152] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[153] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[154] = 
    "\"".toCharArray();
    __oracle_jsp_text[155] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[156] = 
    "</font>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width='20%'>\n\t\t\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[157] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[158] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[159] = 
    "\"".toCharArray();
    __oracle_jsp_text[160] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[161] = 
    "</font>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width='10%'><font size=\"2\" face=\"Verdana\"></font>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[162] = 
    "\n\t\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[163] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[164] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[165] = 
    "\"".toCharArray();
    __oracle_jsp_text[166] = 
    " face=\"Arial\">Terminado</font>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[167] = 
    "\n\t\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[168] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[169] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[170] = 
    "\"".toCharArray();
    __oracle_jsp_text[171] = 
    " face=\"Arial\">Por Aprobar</font>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[172] = 
    "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[173] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[174] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[175] = 
    "\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD width=\"100%\">\n\t\t\t\t\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No hay Asuntos Terminados de la Ventanilla ******</FONT></div>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[176] = 
    "\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[177] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[178] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[179] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[180] = 
    "\n\t\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[181] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[182] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[183] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[184] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[185] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[186] = 
    "\n\t\t\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[187] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[188] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[189] = 
    "\n\t\t\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[190] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[191] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t\t\t\t\t".toCharArray();
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
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[198] = 
    "\n\t\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[199] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[200] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[201] = 
    "\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[202] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[203] = 
    "\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD width=\"100%\">\n\t\t\t\t\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No hay Asuntos Terminados de la Ventanilla ******</FONT></div>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[204] = 
    "\n\t\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t\t".toCharArray();
    __oracle_jsp_text[205] = 
    "\n\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[206] = 
    "\n\t</TBODY>\n</table>\n<BR>\n".toCharArray();
    __oracle_jsp_text[207] = 
    "\n<A onclick=\"desplegar(3)\">\n<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[208] = 
    "\" border=\"0\" height=\"16\" width=\"16\">\n<FONT face=\"Arial\" size=\"2\"><b>De otras Ventanillas</b></FONT>\n</A>\n".toCharArray();
    __oracle_jsp_text[209] = 
    "\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD align=\"left\">\n\t\t".toCharArray();
    __oracle_jsp_text[210] = 
    " \n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A href=\"../ReporteAsuntoExcel?tip=terminado_03\">\n\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t</A> \n\t\t".toCharArray();
    __oracle_jsp_text[211] = 
    "\n\t\t</TD>\n\t\t<TD align=\"right\">\n\t\t".toCharArray();
    __oracle_jsp_text[212] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[213] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[214] = 
    " registros mostrados.\n\t\t".toCharArray();
    __oracle_jsp_text[215] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[216] = 
    "\n\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[217] = 
    " de ".toCharArray();
    __oracle_jsp_text[218] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[219] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[220] = 
    "\n<BR>\n".toCharArray();
    __oracle_jsp_text[221] = 
    "\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[222] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[223] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[224] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[225] = 
    "\n\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[226] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[227] = 
    ">\n\t\t\t\t<td width='40%'>\n\t\t\t\t\t<img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\" width=\"16\" alt=\"\">\n\t\t\t\t\t<FONT SIZE=2 ".toCharArray();
    __oracle_jsp_text[228] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[229] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[230] = 
    "\"".toCharArray();
    __oracle_jsp_text[231] = 
    " FACE=\"Verdana\">\n\t\t\t\t\t<A href=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[232] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[233] = 
    "\" \n\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[234] = 
    "(".toCharArray();
    __oracle_jsp_text[235] = 
    " ".toCharArray();
    __oracle_jsp_text[236] = 
    " ".toCharArray();
    __oracle_jsp_text[237] = 
    " ".toCharArray();
    __oracle_jsp_text[238] = 
    ")\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[239] = 
    "(".toCharArray();
    __oracle_jsp_text[240] = 
    " ".toCharArray();
    __oracle_jsp_text[241] = 
    " ".toCharArray();
    __oracle_jsp_text[242] = 
    " ".toCharArray();
    __oracle_jsp_text[243] = 
    ")\n\t\t\t\t\t</A>\n\t\t\t\t\t</Font>\n\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td width='20%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[244] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[245] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[246] = 
    "\"".toCharArray();
    __oracle_jsp_text[247] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[248] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[249] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[250] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[251] = 
    "\"".toCharArray();
    __oracle_jsp_text[252] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[253] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='20%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[254] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[255] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[256] = 
    "\"".toCharArray();
    __oracle_jsp_text[257] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[258] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'>\n\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[259] = 
    " \n\t\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/rojo5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[260] = 
    "\n\t\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/verde5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[261] = 
    "\n\t\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/amarillo5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[262] = 
    "\n\t\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[263] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[264] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[265] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No hay Asuntos Terminados de otras Ventanillas ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[266] = 
    "\n\t\t<TR>\n\t\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[267] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[268] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[269] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[270] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[271] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[272] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[273] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[274] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[275] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[276] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[277] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[278] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[279] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[280] = 
    ")\">".toCharArray();
    __oracle_jsp_text[281] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[282] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[283] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[284] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[285] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[286] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[287] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[288] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[289] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[290] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[291] = 
    "\n\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[292] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[293] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No hay Asuntos Terminados de otras Ventanillas ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[294] = 
    "\n\t</TBODY>\n</table>\n".toCharArray();
    __oracle_jsp_text[295] = 
    "\n</div>\n<BR>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</form>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
