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


public class _PortalATramite extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations

public static boolean par(int num) {
		boolean p = false;
		if (num % 2 == 0) {
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
    _PortalATramite page = this;
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
      	boolean BExisteInsAsunto = false;
      	boolean bExisteMisAsuntos = false;
      	boolean noPuedeVerVentanillas		=   AsuntoVerifica.noPuedeUaVerVentanillas(session.getServletContext(),BUsuario.getIdArea());
      	int t = 0;
      	int iDuracion = 0;
      	float fPorcentaje = 0;
      	float fAvance = 0;
      	
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
      	int iSAmarillo = 70;
      	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
      	if(strConfig != null && strConfig.length > 0){
      		regPorPagina 	= 	Integer.parseInt(strConfig[0][3]);
      		muestraPaginas 	= 	Integer.parseInt(strConfig[0][4]);
      		iSAmarillo		=	Integer.parseInt(strConfig[0][2]);
      	}
      	int numRegistros = 0;
      	int numPaginas = 0;
      
      out.write(__oracle_jsp_text[6]);
      out.write(__oracle_jsp_text[7]);
      out.print(strCambio);
      out.write(__oracle_jsp_text[8]);
      out.print( strOrden );
      out.write(__oracle_jsp_text[9]);
      out.print( strTipo );
      out.write(__oracle_jsp_text[10]);
      out.print( strCambio );
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
      	numRegistros = ActualizaAsunto.getDatosMisAsuntosTramite(strOrden, strTipo, BUsuario.getIdUsuario()).length;
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
      
      		bExisteMisAsuntos = ActualizaAsunto.getExistenMisAsuntosTramite(BUsuario.getIdUsuario());
      		if(bExisteMisAsuntos){
      		
      out.write(__oracle_jsp_text[39]);
       int j = 0; 
      out.write(__oracle_jsp_text[40]);
      	String[][] sql = ActualizaAsunto.getDatosMisAsuntosTramite(strOrden, strTipo, BUsuario.getIdUsuario());
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
      		
      out.write(__oracle_jsp_text[41]);
       if(	BUsuario.getIdArea().equals(campo6)){ 
      out.write(__oracle_jsp_text[42]);
       t++; 
      out.write(__oracle_jsp_text[43]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[44]);
      }
      out.write(__oracle_jsp_text[45]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[46]);
      }else{
      out.write(__oracle_jsp_text[47]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[48]);
      }
      out.write(__oracle_jsp_text[49]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[50]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&cambio1="+strCambio+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[51]);
      out.print( campo2 );
      out.write(__oracle_jsp_text[52]);
      out.print( Utilerias.recortaString(campo2,40) );
      out.write(__oracle_jsp_text[53]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[54]);
      }else{
      out.write(__oracle_jsp_text[55]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[56]);
      }
      out.write(__oracle_jsp_text[57]);
      out.print(campo4 );
      out.write(__oracle_jsp_text[58]);
      out.print(campo10 );
      out.write(__oracle_jsp_text[59]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[60]);
      }else{
      out.write(__oracle_jsp_text[61]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[62]);
      }
      out.write(__oracle_jsp_text[63]);
      out.print(Utilerias.recortaString(campo10,15) );
      out.write(__oracle_jsp_text[64]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[65]);
      }else{
      out.write(__oracle_jsp_text[66]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[67]);
      }
      out.write(__oracle_jsp_text[68]);
      out.print(campo5 );
      out.write(__oracle_jsp_text[69]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[70]);
      }else{
      out.write(__oracle_jsp_text[71]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[72]);
      }
      out.write(__oracle_jsp_text[73]);
      out.print(campo11 );
      out.write(__oracle_jsp_text[74]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[75]);
      }else{
      out.write(__oracle_jsp_text[76]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[77]);
      }
      out.write(__oracle_jsp_text[78]);
      out.print(campo12 );
      out.write(__oracle_jsp_text[79]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[80]);
      }else{
      out.write(__oracle_jsp_text[81]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[82]);
      }
      out.write(__oracle_jsp_text[83]);
      out.print(campo13 );
      out.write(__oracle_jsp_text[84]);
      
      						iDuracion = Utilerias.DiasdeTrabajoEntre(Utilerias.StringCalendar(campo9), 
      																	Utilerias.StringCalendar(campo8), 0);
      						fPorcentaje = Utilerias.getPorcentajeDebido(iDuracion, campo9, campo8, 5);
      						fAvance = new Float(campo5).floatValue();
      						if(fPorcentaje>100){
      					
      out.write(__oracle_jsp_text[85]);
      }else if(fPorcentaje>=iSAmarillo &&  fPorcentaje<=100){
      out.write(__oracle_jsp_text[86]);
      if(fPorcentaje<=fAvance){
      out.write(__oracle_jsp_text[87]);
      }else{
      out.write(__oracle_jsp_text[88]);
      out.print(fPorcentaje);
      out.write(__oracle_jsp_text[89]);
      }
      out.write(__oracle_jsp_text[90]);
      }else if(fPorcentaje<iSAmarillo){
      out.write(__oracle_jsp_text[91]);
      }
      out.write(__oracle_jsp_text[92]);
       j++; 
      out.write(__oracle_jsp_text[93]);
       } 
      out.write(__oracle_jsp_text[94]);
       } 
      out.write(__oracle_jsp_text[95]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[96]);
       } else {
      out.write(__oracle_jsp_text[97]);
      
      			int numeroPaginas = (sql!=null)?sql.length/regPorPagina:0;	
      			if (sql.length%regPorPagina != 0)
      				numeroPaginas++; 
      			if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[98]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[99]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[100]);
      	}
      			if (contPag > 0){  
      				if (contPag > contligas){
      out.write(__oracle_jsp_text[101]);
      out.print(contligas);
      out.write(__oracle_jsp_text[102]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[103]);
      	}else{
      out.write(__oracle_jsp_text[104]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[105]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[106]);
      	} 
      			}
      			if (numeroPaginas > 1){
      				for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
      					if (i==contPag){  
      out.write(__oracle_jsp_text[107]);
      out.print(i);
      out.write(__oracle_jsp_text[108]);
      out.print(i+1);
      out.write(__oracle_jsp_text[109]);
      		}else{ 
      out.write(__oracle_jsp_text[110]);
      out.print(i);
      out.write(__oracle_jsp_text[111]);
      out.print(i+1);
      out.write(__oracle_jsp_text[112]);
      		}
      				}
      			} 
      			if (contPag < numeroPaginas-1){  
      				if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[113]);
      out.print(contligas);
      out.write(__oracle_jsp_text[114]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[115]);
      	}else{
      out.write(__oracle_jsp_text[116]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[117]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[118]);
      	} 
      			}
      			if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[119]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[120]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[121]);
      	
      			} 
      out.write(__oracle_jsp_text[122]);
       } 
      out.write(__oracle_jsp_text[123]);
       } else { 
      out.write(__oracle_jsp_text[124]);
       } 
      out.write(__oracle_jsp_text[125]);
      }
      if(!noPuedeVerVentanillas){
      out.write(__oracle_jsp_text[126]);
      out.print((strCambio.equals("2"))?"collapse.gif":"expand.gif");
      out.write(__oracle_jsp_text[127]);
      	if(strCambio.equals("2")){
      out.write(__oracle_jsp_text[128]);
      	numRegistros = ActualizaAsunto.getDatosAsuntoTramite(strOrden, strTipo, BUsuario.getIdArea(), BUsuario.getIdUsuario()).length;
      			if (numRegistros>0){ 
      out.write(__oracle_jsp_text[129]);
      	} 
      out.write(__oracle_jsp_text[130]);
      	numPaginas = numRegistros/regPorPagina;	
      			if (numRegistros%regPorPagina != 0)
      				numPaginas++; 
      out.write(__oracle_jsp_text[131]);
      	if (numRegistros > 0){	
      out.write(__oracle_jsp_text[132]);
      out.print( numRegistros );
      out.write(__oracle_jsp_text[133]);
      	} 
      out.write(__oracle_jsp_text[134]);
      	} 
      out.write(__oracle_jsp_text[135]);
      if(strCambio.equals("2")){
      out.write(__oracle_jsp_text[136]);
      
      		String[][] turnadores = ActualizaAsunto.getTurnadoreUnidadTramite(BUsuario.getIdArea(), BUsuario.getIdUsuario());
      		for(int i=0;i<turnadores.length;i++){
      		int iCount = i+4;
      		String count = String.valueOf(iCount);
      		
      out.write(__oracle_jsp_text[137]);
      out.print(count);
      out.write(__oracle_jsp_text[138]);
      out.print((strCambioT.equals(count))?"collapse.gif":"expand.gif");
      out.write(__oracle_jsp_text[139]);
      out.print(turnadores[i][1]);
      out.write(__oracle_jsp_text[140]);
      if(strCambioT.equals(count)){
      out.write(__oracle_jsp_text[141]);
      numRegistros = ActualizaAsunto.datosAsuntoTurnadorTramite(strOrden, strTipo, BUsuario.getIdArea(), turnadores[i][0]).length; 
      out.write(__oracle_jsp_text[142]);
      	numPaginas = numRegistros/regPorPagina;	
      						if (numRegistros%regPorPagina != 0)
      						numPaginas++; 
      out.write(__oracle_jsp_text[143]);
      if(numRegistros > 0){
      out.write(__oracle_jsp_text[144]);
      out.print(numRegistros);
      out.write(__oracle_jsp_text[145]);
      }
      out.write(__oracle_jsp_text[146]);
      
      					bExiste	= ActualizaAsunto.existeAsuntoTurnadorTramite(BUsuario.getIdArea(), turnadores[i][0]); 
      					if(bExiste){
      					
      out.write(__oracle_jsp_text[147]);
       int j = 0; 
      out.write(__oracle_jsp_text[148]);
      	String[][] sql = ActualizaAsunto.datosAsuntoTurnadorTramite(strOrden, strTipo, BUsuario.getIdArea(), turnadores[i][0]);
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
      							String campo13 = sql[y][12];
      					
      					
      out.write(__oracle_jsp_text[149]);
       t++; 
      out.write(__oracle_jsp_text[150]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[151]);
      }
      out.write(__oracle_jsp_text[152]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[153]);
      }else{
      out.write(__oracle_jsp_text[154]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[155]);
      }
      out.write(__oracle_jsp_text[156]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[157]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&cambio1="+strCambio+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[158]);
      out.print( campo2 );
      out.write(__oracle_jsp_text[159]);
      out.print( Utilerias.recortaString(campo2,40) );
      out.write(__oracle_jsp_text[160]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[161]);
      }else{
      out.write(__oracle_jsp_text[162]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[163]);
      }
      out.write(__oracle_jsp_text[164]);
      out.print(campo4 );
      out.write(__oracle_jsp_text[165]);
      out.print(campo10 );
      out.write(__oracle_jsp_text[166]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[167]);
      }else{
      out.write(__oracle_jsp_text[168]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[169]);
      }
      out.write(__oracle_jsp_text[170]);
      out.print(Utilerias.recortaString(campo10,15) );
      out.write(__oracle_jsp_text[171]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[172]);
      }else{
      out.write(__oracle_jsp_text[173]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[174]);
      }
      out.write(__oracle_jsp_text[175]);
      out.print(campo5 );
      out.write(__oracle_jsp_text[176]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[177]);
      }else{
      out.write(__oracle_jsp_text[178]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[179]);
      }
      out.write(__oracle_jsp_text[180]);
      out.print(campo11 );
      out.write(__oracle_jsp_text[181]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[182]);
      }else{
      out.write(__oracle_jsp_text[183]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[184]);
      }
      out.write(__oracle_jsp_text[185]);
      out.print(campo12 );
      out.write(__oracle_jsp_text[186]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[187]);
      }else{
      out.write(__oracle_jsp_text[188]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[189]);
      }
      out.write(__oracle_jsp_text[190]);
      out.print(campo13 );
      out.write(__oracle_jsp_text[191]);
      
      						iDuracion = Utilerias.DiasdeTrabajoEntre(Utilerias.StringCalendar(campo9), 
      																Utilerias.StringCalendar(campo8), 0);
      						fPorcentaje = Utilerias.getPorcentajeDebido(iDuracion, campo9, campo8, 5);
      						fAvance = new Float(campo5).floatValue();
      						if(fPorcentaje>100){
      							
      out.write(__oracle_jsp_text[192]);
      }else if(fPorcentaje>=iSAmarillo &&  fPorcentaje<=100){
      out.write(__oracle_jsp_text[193]);
      if(fPorcentaje<=fAvance){
      out.write(__oracle_jsp_text[194]);
      }else{
      out.write(__oracle_jsp_text[195]);
      out.print(fPorcentaje);
      out.write(__oracle_jsp_text[196]);
      }
      out.write(__oracle_jsp_text[197]);
      }else if(fPorcentaje<iSAmarillo){
      out.write(__oracle_jsp_text[198]);
      }
      out.write(__oracle_jsp_text[199]);
       j++; 
      out.write(__oracle_jsp_text[200]);
      }
      out.write(__oracle_jsp_text[201]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[202]);
      }else{
      out.write(__oracle_jsp_text[203]);
      
      						int numeroPaginas = (sql!=null)?sql.length/regPorPagina:0;	
      						if (sql.length%regPorPagina != 0)
      							numeroPaginas++; 
      						if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[204]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[205]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[206]);
      	}
      						if (contPag > 0){  
      							if (contPag > contligas){
      out.write(__oracle_jsp_text[207]);
      out.print(contligas);
      out.write(__oracle_jsp_text[208]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[209]);
      	}else{
      out.write(__oracle_jsp_text[210]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[211]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[212]);
      	} 
      						}
      						if (numeroPaginas > 1){
      							for (int k=contligas; k<muestraPaginas+contligas && k<numeroPaginas; k++){ 
      								if (i==contPag){  
      out.write(__oracle_jsp_text[213]);
      out.print(k);
      out.write(__oracle_jsp_text[214]);
      out.print(k+1);
      out.write(__oracle_jsp_text[215]);
      	}else{ 
      out.write(__oracle_jsp_text[216]);
      out.print(k);
      out.write(__oracle_jsp_text[217]);
      out.print(k+1);
      out.write(__oracle_jsp_text[218]);
      	}
      							}
      						} 
      						if (contPag < numeroPaginas-1){  
      							if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[219]);
      out.print(contligas);
      out.write(__oracle_jsp_text[220]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[221]);
      	}else{
      out.write(__oracle_jsp_text[222]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[223]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[224]);
      	} 
      						}
      						if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[225]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[226]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[227]);
      }
      out.write(__oracle_jsp_text[228]);
      }
      out.write(__oracle_jsp_text[229]);
      }else{
      out.write(__oracle_jsp_text[230]);
      }
      out.write(__oracle_jsp_text[231]);
      }
      out.write(__oracle_jsp_text[232]);
      } if(turnadores.length == 0) {
      out.write(__oracle_jsp_text[233]);
      }
      out.write(__oracle_jsp_text[234]);
      }
      out.write(__oracle_jsp_text[235]);
      out.print((strCambio.equals("3"))?"collapse.gif":"expand.gif");
      out.write(__oracle_jsp_text[236]);
      	if(strCambio.equals("3")){
      out.write(__oracle_jsp_text[237]);
      	if(!BUsuario.getSupervisor()){//Un rol de atención
      			numRegistros = ActualizaInstrucciones.getInstruccionTramiteUsuarioAsunto(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea(), 1).length;
      			}else{
      			numRegistros = ActualizaInstrucciones.getInstruccionTramiteUsuarioAsunto(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea(), 1).length;
      			}
      			if (numRegistros>0){ 
      out.write(__oracle_jsp_text[238]);
      	} 
      out.write(__oracle_jsp_text[239]);
      	numPaginas = numRegistros/regPorPagina;	
      			if (numRegistros%regPorPagina != 0)
      				numPaginas++; 
      out.write(__oracle_jsp_text[240]);
      	if (numRegistros > 0){	
      out.write(__oracle_jsp_text[241]);
      out.print( numRegistros );
      out.write(__oracle_jsp_text[242]);
      	} 
      out.write(__oracle_jsp_text[243]);
      	if (numPaginas > 1){	
      out.write(__oracle_jsp_text[244]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[245]);
      out.print( numPaginas );
      out.write(__oracle_jsp_text[246]);
       	} 
      out.write(__oracle_jsp_text[247]);
      	} 
      out.write(__oracle_jsp_text[248]);
      if(strCambio.equals("3")){
      out.write(__oracle_jsp_text[249]);
      
      		BExisteInsAsunto = ActualizaInstrucciones.TieneInstruccionesEnTramiteAsunto(BUsuario.getIdUsuario());
      		if(numRegistros!=0){
      		
      out.write(__oracle_jsp_text[250]);
       int j = 0; 
      out.write(__oracle_jsp_text[251]);
      
      			String[][] sql = null; 
      			if(!BUsuario.getSupervisor()){//Un rol de atención
      			sql = ActualizaInstrucciones.getInstruccionTramiteUsuarioAsunto(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea(), 1);
      			}else{
      			sql = ActualizaInstrucciones.getInstruccionTramiteUsuarioAsunto(BUsuario.getIdUsuario(), strOrden, strTipo, BUsuario.getIdArea(), 1);
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
      		
      out.write(__oracle_jsp_text[252]);
       t++; 
      out.write(__oracle_jsp_text[253]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[254]);
      }
      out.write(__oracle_jsp_text[255]);
      if(campo10.length() == 0){
      out.write(__oracle_jsp_text[256]);
      }else{
      out.write(__oracle_jsp_text[257]);
      out.print(campo10 );
      out.write(__oracle_jsp_text[258]);
      }
      out.write(__oracle_jsp_text[259]);
      out.print( campo1 );
      out.write(__oracle_jsp_text[260]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&cambio1="+strCambio+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[261]);
      out.print(campo11);
      out.write(__oracle_jsp_text[262]);
       if(campo2.length() == 0){ 
      out.write(__oracle_jsp_text[263]);
      out.print( campo3 );
      out.write(__oracle_jsp_text[264]);
       }else{ 
      out.write(__oracle_jsp_text[265]);
      out.print( ActualizaInst.getNombreInstruccion1(campo2) );
      }
      out.write(__oracle_jsp_text[266]);
      out.print(Utilerias.recortaString(campo11,20));
      out.write(__oracle_jsp_text[267]);
       if(campo2.length() == 0){ 
      out.write(__oracle_jsp_text[268]);
      out.print( Utilerias.recortaString(campo3,30) );
      out.write(__oracle_jsp_text[269]);
       }else{ 
      out.write(__oracle_jsp_text[270]);
      out.print( Utilerias.recortaString(ActualizaInst.getNombreInstruccion1(campo2),30) );
      }
      out.write(__oracle_jsp_text[271]);
      if(campo10.length() == 0){
      out.write(__oracle_jsp_text[272]);
      }else{
      out.write(__oracle_jsp_text[273]);
      out.print(campo10 );
      out.write(__oracle_jsp_text[274]);
      }
      out.write(__oracle_jsp_text[275]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[276]);
      out.print(campo8 );
      out.write(__oracle_jsp_text[277]);
      if(campo10.length() == 0){
      out.write(__oracle_jsp_text[278]);
      }else{
      out.write(__oracle_jsp_text[279]);
      out.print(campo10 );
      out.write(__oracle_jsp_text[280]);
      }
      out.write(__oracle_jsp_text[281]);
      out.print( Utilerias.recortaString(campo8,15) );
      out.write(__oracle_jsp_text[282]);
      if(campo10.length() == 0){
      out.write(__oracle_jsp_text[283]);
      }else{
      out.write(__oracle_jsp_text[284]);
      out.print(campo10 );
      out.write(__oracle_jsp_text[285]);
      }
      out.write(__oracle_jsp_text[286]);
      out.print(campo9 );
      out.write(__oracle_jsp_text[287]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[288]);
      }else{
      out.write(__oracle_jsp_text[289]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[290]);
      }
      out.write(__oracle_jsp_text[291]);
      out.print(Utilerias.formatearFechas(campo4) );
      out.write(__oracle_jsp_text[292]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[293]);
      }else{
      out.write(__oracle_jsp_text[294]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[295]);
      }
      out.write(__oracle_jsp_text[296]);
      if(campo7.length() == 0){
      out.write(__oracle_jsp_text[297]);
      }else{
      out.write(__oracle_jsp_text[298]);
      out.print(campo7 );
      out.write(__oracle_jsp_text[299]);
      }
      out.write(__oracle_jsp_text[300]);
      out.print(Utilerias.formatearFechas(campo5) );
      out.write(__oracle_jsp_text[301]);
      
      						iDuracion = Utilerias.DiasdeTrabajoEntre(Utilerias.StringCalendar(campo4), 
      																	Utilerias.StringCalendar(campo5), 0);
      						fPorcentaje = Utilerias.getPorcentajeDebido(iDuracion, campo4, campo5, 5);
      						fAvance = new Float(campo9).floatValue();
      						if(fPorcentaje>=100){
      					
      out.write(__oracle_jsp_text[302]);
      }else if(fPorcentaje>=iSAmarillo &&  fPorcentaje<=100){
      out.write(__oracle_jsp_text[303]);
      if(fPorcentaje<=fAvance){
      out.write(__oracle_jsp_text[304]);
      }else{
      out.write(__oracle_jsp_text[305]);
      out.print(fPorcentaje);
      out.write(__oracle_jsp_text[306]);
      }
      out.write(__oracle_jsp_text[307]);
      }else if(fPorcentaje<iSAmarillo){
      out.write(__oracle_jsp_text[308]);
      }
      out.write(__oracle_jsp_text[309]);
       j++; 
      out.write(__oracle_jsp_text[310]);
       } 
      out.write(__oracle_jsp_text[311]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[312]);
       } else {
      out.write(__oracle_jsp_text[313]);
      
      			int numeroPaginas = (sql!=null)?sql.length/regPorPagina:0;	
      			if (sql.length%regPorPagina != 0)
      				numeroPaginas++; 
      			if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[314]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[315]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[316]);
      	}
      			if (contPag > 0){  
      				if (contPag > contligas){
      out.write(__oracle_jsp_text[317]);
      out.print(contligas);
      out.write(__oracle_jsp_text[318]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[319]);
      	}else{
      out.write(__oracle_jsp_text[320]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[321]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[322]);
      	} 
      			}
      			if (numeroPaginas > 1){
      				for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
      					if (i==contPag){  
      out.write(__oracle_jsp_text[323]);
      out.print(i);
      out.write(__oracle_jsp_text[324]);
      out.print(i+1);
      out.write(__oracle_jsp_text[325]);
      		}else{ 
      out.write(__oracle_jsp_text[326]);
      out.print(i);
      out.write(__oracle_jsp_text[327]);
      out.print(i+1);
      out.write(__oracle_jsp_text[328]);
      		}
      				}
      			} 
      			if (contPag < numeroPaginas-1){  
      				if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[329]);
      out.print(contligas);
      out.write(__oracle_jsp_text[330]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[331]);
      	}else{
      out.write(__oracle_jsp_text[332]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[333]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[334]);
      	} 
      			}
      			if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[335]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[336]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[337]);
      	
      			} 
      out.write(__oracle_jsp_text[338]);
       } 
      out.write(__oracle_jsp_text[339]);
       } else { 
      out.write(__oracle_jsp_text[340]);
       } 
      out.write(__oracle_jsp_text[341]);
      }
      }
      out.write(__oracle_jsp_text[342]);

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
  private static final char __oracle_jsp_text[][]=new char[343][];
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Asuntos en Tramite</TITLE>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script language=\"JavaScript\" type=\"text/javascript\">\n\tfunction cambio(o, t){\n\t\tdoc = document.pATramite;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\t//doc.cambio1.value=".toCharArray();
    __oracle_jsp_text[8] = 
    ";\n\t\tdoc.submit();\n\t}\n\tfunction desplegar(id){\n\t\tdoc = document.pATramite;\n\t\tif (id==doc.cambio1.value){\n\t\t\tdoc.cambio1.value=0;\n\t\t\tdoc.submit();\n\t\t}else{\n\t\t\tdoc.cambio1.value=id;\n\t\t\tdoc.contPag.value=0;\n\t\t\tdoc.contligas.value=0;\n\t\t\tdoc.submit();\n\t\t}\n\t}\n\tfunction desplegarT(id, ido){\n\t\tdoc = document.pATramite;\n\t\tif (id==doc.cambioT.value){\n\t\t\tdoc.cambioT.value=0;\n\t\t\tdoc.cambio1.value=ido\n\t\t\tdoc.submit();\n\t\t}else{\n\t\t\tdoc.cambioT.value=id;\n\t\t\tdoc.cambio1.value=ido\n\t\t\tdoc.contPag.value=0;\n\t\t\tdoc.contligas.value=0;\n\t\t\tdoc.submit();\n\t\t}\n\t}\nfunction pagina(contador){\n\tdoc = document.pATramite;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\n\nfunction paginaLiga(contador){\n\tdoc = document.pATramite;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n\n<form method=\"post\" action=\"PortalATramite.jsp\" name=\"pATramite\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
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
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntos()\";>Asuntos por turnar</a></td>\n                    <td class=\"dominoSelTopTab\" bgcolor=\"#004080\"><a onclick=\"goAsuntosTr()\";>Asuntos en Trámite</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntosTer()\";>Asuntos terminados</a></td>\n\t\t".toCharArray();
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
    "\n\t</tr>\n\t</TBODY>\n</table>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='25%' align=\"center\">\n\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\tAsunto\n\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</font></TD>\n\t\t<TD WIDTH='15%' align=\"center\">\n\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\tFolio\n\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</font></TD>\n\t\t<TD WIDTH='15%' align=\"center\">\n\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t<a onclick=\"cambio('asc', 3)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\tIdentificador del Docto.\n\t\t<a onclick=\"cambio('desc', 3)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</font></TD>\n\t\t<TD WIDTH='10%' align=\"center\">\n\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t<a onclick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\tAvance (%)\n\t\t<a onclick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t</font></TD>\n\t\t<TD WIDTH='10%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t\t<a onclick=\"cambio('asc', 5)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tFecha <BR>Recepción\n\t\t\t<a onclick=\"cambio('desc', 5)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font>\n\t\t</TD>\n\t\t<TD WIDTH='10%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t\t<a onclick=\"cambio('asc', 6)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tFecha <BR>Documento\n\t\t\t<a onclick=\"cambio('desc', 6)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font>\n\t\t</TD>\n\t\t<TD WIDTH='10%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t\t<a onclick=\"cambio('asc', 7)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tFecha <BR>Compromiso\n\t\t\t<a onclick=\"cambio('desc', 7)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font>\n\t\t</TD>\n\t\t<TD WIDTH='5%' align=\"center\"><FONT SIZE=1 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"verdana\">Estatus</font></TD>\n\t</TR>\n</TABLE>\n<DIV class=documentBody id=Body>\n<div id=\"view\">\n<A onclick=\"desplegar(1)\">\n<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[25] = 
    "\" border=\"0\" height=\"16\" width=\"16\">\n<FONT face=\"Arial\" size=\"2\"><b>Mis Asuntos</b></FONT>\n</A>\n".toCharArray();
    __oracle_jsp_text[26] = 
    "\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD align=\"left\">\n\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A href=\"../ReporteAsuntoExcel?tip=tramite_01\">\n\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t</A> \n\t\t".toCharArray();
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
    "\n\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[44] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[45] = 
    ">\n\t\t\t\t<td width='25%'><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"16\" alt=\"\"> <FONT SIZE=2 ".toCharArray();
    __oracle_jsp_text[46] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[47] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[48] = 
    "\"".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t\t\tFACE=\"Verdana\"> <A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[50] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[51] = 
    "\"\n\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[52] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[53] = 
    "</A>\n\t\t\t\t</Font></td>\n\t\t\t\t<td width='15%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[54] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[55] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[56] = 
    "\"".toCharArray();
    __oracle_jsp_text[57] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[58] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='15%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<a title=\"".toCharArray();
    __oracle_jsp_text[59] = 
    "\">\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[60] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[61] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[62] = 
    "\"".toCharArray();
    __oracle_jsp_text[63] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[64] = 
    "</font>\n\t\t\t\t\t</a>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[65] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[66] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[67] = 
    "\"".toCharArray();
    __oracle_jsp_text[68] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[69] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[70] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[71] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[72] = 
    "\"".toCharArray();
    __oracle_jsp_text[73] = 
    " face=\"Arial\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[75] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[76] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[77] = 
    "\"".toCharArray();
    __oracle_jsp_text[78] = 
    " face=\"Arial\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[80] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[81] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[82] = 
    "\"".toCharArray();
    __oracle_jsp_text[83] = 
    " face=\"Arial\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[84] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='5%' align=\"center\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[85] = 
    " \n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/rojo5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[86] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[87] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/verde5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[88] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/amarillo5.gif\" width=\"11\" height=\"11\" alt=\"Debería llevar el ".toCharArray();
    __oracle_jsp_text[89] = 
    "%\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[90] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[91] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/verde5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[92] = 
    "\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[93] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[94] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[95] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[96] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"verdana\" size=\"4\">****** No tiene Asuntos en Trámite ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[97] = 
    "\n\t\t<TR>\n\t\t<TD colspan=\"6\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[98] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[99] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[100] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[101] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[102] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[103] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[105] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[106] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[107] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[108] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[109] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[110] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[111] = 
    ")\">".toCharArray();
    __oracle_jsp_text[112] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[113] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[114] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[115] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[116] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[117] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[118] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[119] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[120] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[121] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[122] = 
    "\n\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[123] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[124] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"verdana\" size=\"4\">****** No tiene Asuntos en Trámite ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[125] = 
    "\n\t</TBODY>\n</table>\n<BR>\n".toCharArray();
    __oracle_jsp_text[126] = 
    "\n<A onclick=\"desplegar(2)\">\n<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[127] = 
    "\" border=\"0\" height=\"16\" width=\"16\">\n<FONT face=\"Arial\" size=\"2\"><b>Asuntos de la Ventanilla</b></FONT>\n</A>\n".toCharArray();
    __oracle_jsp_text[128] = 
    "\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD align=\"left\">\n\t\t".toCharArray();
    __oracle_jsp_text[129] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A href=\"../ReporteAsuntoExcel?tip=tramite_02\">\n\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t</A> \n\t\t".toCharArray();
    __oracle_jsp_text[130] = 
    "\n\t\t</TD>\n\t\t<TD align=\"right\">\n\t\t".toCharArray();
    __oracle_jsp_text[131] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[132] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[133] = 
    " registros mostrados.\n\t\t".toCharArray();
    __oracle_jsp_text[134] = 
    "\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[135] = 
    "\n<BR>\n".toCharArray();
    __oracle_jsp_text[136] = 
    "\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[137] = 
    "\n\t\t<TR>\n\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t<TD width=\"99%\">\n\t\t<A onclick=\"desplegarT(".toCharArray();
    __oracle_jsp_text[138] = 
    ", 2)\">\n\t\t<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[139] = 
    "\" border=\"0\" height=\"16\" width=\"16\">\n\t\t<FONT face=\"Arial\" size=\"2\"><b>".toCharArray();
    __oracle_jsp_text[140] = 
    "</b></FONT>\n\t\t</A>\n\t\t\t".toCharArray();
    __oracle_jsp_text[141] = 
    "\n\t\t\t<TABLE width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t\t\t\t<TBODY>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD align=\"left\" width=\"50%\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[142] = 
    "\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD align=\"right\" width=\"50%\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[143] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[144] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[145] = 
    " registros mostrados. \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[146] = 
    "\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t\t<TABLE width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t\t\t\t<TBODY>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[147] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[148] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[149] = 
    "\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[150] = 
    "\n\t\t\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[151] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[152] = 
    ">\n\t\t\t\t\t\t<td width='25%'><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\t\theight=\"1\" width=\"16\" alt=\"\"> <FONT SIZE=2 ".toCharArray();
    __oracle_jsp_text[153] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[154] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[155] = 
    "\"".toCharArray();
    __oracle_jsp_text[156] = 
    "\n\t\t\t\t\t\t\tFACE=\"Verdana\"> <A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[157] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[158] = 
    "\"\n\t\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[159] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[160] = 
    "</A>\n\t\t\t\t\t\t\t</Font></td>\n\t\t\t\t\t\t<td width='15%'>\n\t\t\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[161] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[162] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[163] = 
    "\"".toCharArray();
    __oracle_jsp_text[164] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[165] = 
    "</font>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width='15%'>\n\t\t\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t\t<a title=\"".toCharArray();
    __oracle_jsp_text[166] = 
    "\">\n\t\t\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[167] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[168] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[169] = 
    "\"".toCharArray();
    __oracle_jsp_text[170] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[171] = 
    "</font>\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width='10%'>\n\t\t\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[172] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[173] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[174] = 
    "\"".toCharArray();
    __oracle_jsp_text[175] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[176] = 
    "</font>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width='10%'>\n\t\t\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[177] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[178] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[179] = 
    "\"".toCharArray();
    __oracle_jsp_text[180] = 
    " face=\"Arial\">\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[181] = 
    "</font>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width='10%'>\n\t\t\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[182] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[183] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[184] = 
    "\"".toCharArray();
    __oracle_jsp_text[185] = 
    " face=\"Arial\">\n\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[186] = 
    "</font>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width='10%'>\n\t\t\t\t\t\t\t<div align=center>\n\t\t\t\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[187] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[188] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[189] = 
    "\"".toCharArray();
    __oracle_jsp_text[190] = 
    " face=\"Arial\">\n\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[191] = 
    "</font>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width='5%' align=\"center\">\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[192] = 
    " \n\t\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/rojo5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[193] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[194] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/verde5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[195] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/amarillo5.gif\" width=\"11\" height=\"11\" alt=\"Debería llevar el ".toCharArray();
    __oracle_jsp_text[196] = 
    "%\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[197] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[198] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/verde5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[199] = 
    "\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[200] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[201] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[202] = 
    "\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD width=\"100%\">\n\t\t\t\t\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No hay Asuntos en Trámite de la Ventanilla ******</FONT></div>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[203] = 
    "\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[204] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[205] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[206] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[207] = 
    "\n\t\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[208] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[209] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[210] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[211] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[212] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[213] = 
    "\n\t\t\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[214] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[215] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[216] = 
    "\n\t\t\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[217] = 
    ")\"><!--<FONT color=\"red\"><B>[-->".toCharArray();
    __oracle_jsp_text[218] = 
    "<!--]</B></FONT>--></A> &nbsp;\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[219] = 
    "\n\t\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[220] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[221] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[222] = 
    "\n\t\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[223] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[224] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[225] = 
    "\n\t\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[226] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[227] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[228] = 
    "\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[229] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[230] = 
    "\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD width=\"100%\">\n\t\t\t\t\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No hay Asuntos en Trámite de la Ventanilla ******</FONT></div>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[231] = 
    "\n\t\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t\t".toCharArray();
    __oracle_jsp_text[232] = 
    "\n\t\t</TD>\n\t\t</TR>\n                ".toCharArray();
    __oracle_jsp_text[233] = 
    "\n                    <TR>\n                        <TD width=\"100%\">\n                            <div align=center><FONT face=\"Arial\" size=\"4\">****** No hay Asuntos en Trámite de la Ventanilla ******</FONT></div>\n\t\t\t</TD>\n                    </TR>\n\t\t".toCharArray();
    __oracle_jsp_text[234] = 
    "\n\t</TBODY>\n</table>\n<BR>\n".toCharArray();
    __oracle_jsp_text[235] = 
    "\n<A onclick=\"desplegar(3)\">\n<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[236] = 
    "\" border=\"0\" height=\"16\" width=\"16\">\n<FONT face=\"Arial\" size=\"2\"><b>De otras Ventanillas</b></FONT>\n</A>\n".toCharArray();
    __oracle_jsp_text[237] = 
    "\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD align=\"left\">\n\t\t".toCharArray();
    __oracle_jsp_text[238] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A href=\"../ReporteAsuntoExcel?tip=tramite_03\">\n\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t</A> \n\t\t".toCharArray();
    __oracle_jsp_text[239] = 
    "\n\t\t</TD>\n\t\t<TD align=\"right\">\n\t\t".toCharArray();
    __oracle_jsp_text[240] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[241] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[242] = 
    " registros mostrados.\n\t\t".toCharArray();
    __oracle_jsp_text[243] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[244] = 
    "\n\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[245] = 
    " de ".toCharArray();
    __oracle_jsp_text[246] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[247] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[248] = 
    "\n<BR>\n".toCharArray();
    __oracle_jsp_text[249] = 
    "\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[250] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[251] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[252] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[253] = 
    "\n\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[254] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[255] = 
    ">\n\t\t\t\t<td width='25%'>\n\t\t\t\t\t<img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\" width=\"16\" alt=\"\">\n\t\t\t\t\t<FONT SIZE=2 ".toCharArray();
    __oracle_jsp_text[256] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[257] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[258] = 
    "\"".toCharArray();
    __oracle_jsp_text[259] = 
    " FACE=\"Verdana\">\n\t\t\t\t\t<A href=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[260] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[261] = 
    "\"\n\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[262] = 
    "(".toCharArray();
    __oracle_jsp_text[263] = 
    " ".toCharArray();
    __oracle_jsp_text[264] = 
    " ".toCharArray();
    __oracle_jsp_text[265] = 
    " ".toCharArray();
    __oracle_jsp_text[266] = 
    ")\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[267] = 
    "(".toCharArray();
    __oracle_jsp_text[268] = 
    " ".toCharArray();
    __oracle_jsp_text[269] = 
    " ".toCharArray();
    __oracle_jsp_text[270] = 
    " ".toCharArray();
    __oracle_jsp_text[271] = 
    ")\n\t\t\t\t\t</A>\n\t\t\t\t\t</Font>\n\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td width='15%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[272] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[273] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[274] = 
    "\"".toCharArray();
    __oracle_jsp_text[275] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[276] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='15%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[277] = 
    "\">\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[278] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[279] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[280] = 
    "\"".toCharArray();
    __oracle_jsp_text[281] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[282] = 
    "</font>\n\t\t\t\t\t</A>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[283] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[284] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[285] = 
    "\"".toCharArray();
    __oracle_jsp_text[286] = 
    " face=\"Arial\">".toCharArray();
    __oracle_jsp_text[287] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[288] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[289] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[290] = 
    "\"".toCharArray();
    __oracle_jsp_text[291] = 
    " face=\"Arial\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[292] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[293] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[294] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[295] = 
    "\"".toCharArray();
    __oracle_jsp_text[296] = 
    " face=\"Arial\">\n\t\t\t\t\t--</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='10%'>\n\t\t\t\t<div align=center>\n\t\t\t\t\t<font size=\"1\" ".toCharArray();
    __oracle_jsp_text[297] = 
    "color=\"black\"".toCharArray();
    __oracle_jsp_text[298] = 
    "COLOR=\"".toCharArray();
    __oracle_jsp_text[299] = 
    "\"".toCharArray();
    __oracle_jsp_text[300] = 
    " face=\"Arial\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[301] = 
    "</font>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width='5%' align=\"center\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[302] = 
    " \n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/rojo5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[303] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[304] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/verde5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[305] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/amarillo5.gif\" width=\"11\" height=\"11\" alt=\"Debería llevar el ".toCharArray();
    __oracle_jsp_text[306] = 
    "%\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[307] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[308] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/verde5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[309] = 
    "\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[310] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[311] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[312] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No hay Asuntos en Trámite de otras Ventanillas ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[313] = 
    "\n\t\t<TR>\n\t\t<TD colspan=\"6\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[314] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[315] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[316] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[317] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[318] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[319] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[320] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[321] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[322] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[323] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[324] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[325] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[326] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[327] = 
    ")\">".toCharArray();
    __oracle_jsp_text[328] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[329] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[330] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[331] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[332] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[333] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[334] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[335] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[336] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[337] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[338] = 
    "\n\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[339] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[340] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"Arial\" size=\"4\">****** No hay Asuntos en Trámite de otras Ventanillas ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[341] = 
    "\n\t</TBODY>\n</table>\n".toCharArray();
    __oracle_jsp_text[342] = 
    "\n</div>\n<br>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n<BR>\n</form>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
