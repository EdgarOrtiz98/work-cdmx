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
import java.util.*;
import com.meve.sigma.util.*;
import gob.hacienda.cgtic.siga.instruccion.Rechazo;
import gob.hacienda.cgtic.siga.Usuario;
import gob.hacienda.cgtic.siga.actualiza.AtenderInstrucciones;
import gob.hacienda.cgtic.siga.actualiza.RechazoInstruccion;
import gob.hacienda.cgtic.siga.util.Jefe;


public class _PortalRechazadas extends com.orionserver.http.OrionHttpJspPage {


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
    _PortalRechazadas page = this;
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
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
      out.write(__oracle_jsp_text[7]);
      out.write(__oracle_jsp_text[8]);
      out.write(__oracle_jsp_text[9]);
       
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null)
      		response.sendRedirect("index.jsp?pagina="+ strTmp);
      
      out.write(__oracle_jsp_text[10]);
      
      	boolean bExiste	= false;
      	boolean bExiste1 = false;
      	boolean bExisteSup = false;
      	boolean bMostrar	=	false;
      	boolean bNoExiste = false;
      	int t = 0;
      	int y = 0;
      	bExiste	= ActualizaInstrucciones.TieneInstruccionesRechazadas();
      	bExiste1 = ActualizaInstrucciones.existeInstruccionesRechazadasPorAtender(BUsuario.getIdUsuario());
      	bExisteSup = ActualizaInstrucciones.existeInstRechazadasAtenderSup(BUsuario.getIdArea());
      	float fPorcentaje = 0;
       	String strActivarPortal = application.getInitParameter("ActivarPortal");
      	String strAccion = request.getParameter("accion");
      	String strIdUsuario = (request.getParameter("idUs")!=null)?request.getParameter("idUs"):"";
      	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"6";
      
      	String strIdsAsiste[][] =	null;
              if(BUsuario.getAsistente())
                  strIdsAsiste = Rechazo.getInsRechazadasAsistente(BUsuario.getIdUsuario(),BUsuario.getIdArea());
      
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
      
      
      out.write(__oracle_jsp_text[11]);
      out.write(__oracle_jsp_text[12]);
      out.print( strIdUsuario );
      out.write(__oracle_jsp_text[13]);
      out.print( strOrden );
      out.write(__oracle_jsp_text[14]);
      out.print( strTipo );
      out.write(__oracle_jsp_text[15]);
      out.print( contPag );
      out.write(__oracle_jsp_text[16]);
      out.print( contligas );
      out.write(__oracle_jsp_text[17]);
      if(BUsuario.getTurnado() || BUsuario.getRecepcion()){
      out.write(__oracle_jsp_text[18]);
      }
      out.write(__oracle_jsp_text[19]);
      if(BUsuario.getTurnado()){
      out.write(__oracle_jsp_text[20]);
      }
      out.write(__oracle_jsp_text[21]);
      if(BUsuario.getAtencion()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[22]);
      }
      out.write(__oracle_jsp_text[23]);
      if(BUsuario.getAtencion()||BUsuario.getRecepcion()||BUsuario.getSupervisor()||BUsuario.getTurnado()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[24]);
      }
      out.write(__oracle_jsp_text[25]);
      if(BUsuario.getAtencion()||BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[26]);
      }
      out.write(__oracle_jsp_text[27]);
      if(BUsuario.getAtencion() && !BUsuario.getTurnado() && !BUsuario.getSupervisor()){
      out.write(__oracle_jsp_text[28]);
       
      		int j = 0;
      		boolean bExisteAs = false;
      
                      String[][] strSubAlternos = Rechazo.getInsRechazadasOtros(BUsuario.getIdUsuario(),BUsuario.getIdArea());
      		///String[][] strSubAlternos = ActualizaUsuario.getInsRechazadas(BUsuario.getIdUsuario());
      		AsignarArbol tree = new AsignarArbol(strSubAlternos);
      		Vector vIdsCadena = tree.getIds();
      		//vIdsCadena.add(0,BUsuario.getIdUsuario());
      	
      out.write(__oracle_jsp_text[29]);
      for(int k=0; vIdsCadena!=null && k<vIdsCadena.size(); k++){
      out.write(__oracle_jsp_text[30]);
      
      //                bExisteAs = Rechazo.getDatosInstruccionUsuario((String)vIdsCadena.get(k),strOrden,strTipo).length>0?true:false;
                          //bExisteAs	= ActualizaInstrucciones.TieneInstruccionesRechazadas((String)vIdsCadena.get(k));
                          bExisteAs = Rechazo.getDatosInstruccionUsuario((String)vIdsCadena.get(k),strOrden,strTipo).length>0?true:false;
                          ////System.out.println("Analisando al usuario: "+(String)vIdsCadena.get(k)+" Valor: "+bExiste);
      			if(bExisteAs){ 
      				bMostrar = strIdUsuario.equals((String)vIdsCadena.get(k));
      	
      out.write(__oracle_jsp_text[31]);
      out.print((String)vIdsCadena.get(k));
      out.write(__oracle_jsp_text[32]);
      out.print((bMostrar)?"collapse.gif":"expand.gif");
      out.write(__oracle_jsp_text[33]);
      out.print( ActualizaUsuario.NombreUsuario((String)vIdsCadena.get(k)) );
      out.write(__oracle_jsp_text[34]);
      out.print( ActualizaUsuario.NombrePuesto((String)vIdsCadena.get(k)) );
      out.write(__oracle_jsp_text[35]);
       j++; 
      out.write(__oracle_jsp_text[36]);
      if(bMostrar){ 
      out.write(__oracle_jsp_text[37]);
      numRegistros = Rechazo.getDatosInstruccionUsuario((String)vIdsCadena.get(k),strOrden,strTipo).length;
                                              //numRegistros = ActualizaInstrucciones.getInstruccionRechazadaUsuario((String)vIdsCadena.get(k),strOrden,strTipo).length;
      						if (numRegistros>0){ 
      out.write(__oracle_jsp_text[38]);
      out.print( (String)vIdsCadena.get(k) );
      out.write(__oracle_jsp_text[39]);
      	} 
      out.write(__oracle_jsp_text[40]);
      	numPaginas = numRegistros/regPorPagina;	
      						if (numRegistros%regPorPagina != 0)
      							numPaginas++; 
      out.write(__oracle_jsp_text[41]);
      	if (numRegistros > 0){	
      out.write(__oracle_jsp_text[42]);
      out.print( numRegistros );
      out.write(__oracle_jsp_text[43]);
      	} 
      out.write(__oracle_jsp_text[44]);
      	if (numPaginas > 1){	
      out.write(__oracle_jsp_text[45]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[46]);
      out.print( numPaginas );
      out.write(__oracle_jsp_text[47]);
       	} 
      out.write(__oracle_jsp_text[48]);
            String[][] sql = Rechazo.getDatosInstruccionUsuario((String)vIdsCadena.get(k),strOrden,strTipo);
                                      //	String[][] sql = ActualizaInstrucciones.getInstruccionRechazadaUsuario((String)vIdsCadena.get(k),strOrden,strTipo);
      					for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
      						String usuario1 = sql[i][0];
      						String usuario2 = sql[i][1];
      						String usuario3 = sql[i][2];
      						String usuario4 = sql[i][3];
      						String usuario5 = sql[i][4];
      						String usuario6 = sql[i][5];
      						String usuario7 = sql[i][6];
      						String usuario8 = sql[i][7];
      						String usuario9 = sql[i][8];
      						String usuario10 = sql[i][9];
      						String usuario15 = sql[i][14];
      						String usuario16 = sql[i][15];
      				
      out.write(__oracle_jsp_text[49]);
       t++; 
      out.write(__oracle_jsp_text[50]);
      if(par(t)==true){
      out.write(__oracle_jsp_text[51]);
      }else{
      out.write(__oracle_jsp_text[52]);
      }
      out.write(__oracle_jsp_text[53]);
       	if(usuario15.equals("0")){
      								String padre1 = usuario16;
      								if(padre1.length() != 0){ 
      						
      out.write(__oracle_jsp_text[54]);
      out.print( usuario1 );
      out.write(__oracle_jsp_text[55]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[56]);
      out.print( usuario6 );
      out.write(__oracle_jsp_text[57]);
      out.print(usuario6);
      out.write(__oracle_jsp_text[58]);
      		}else{ 
      out.write(__oracle_jsp_text[59]);
      out.print( usuario1 );
      out.write(__oracle_jsp_text[60]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[61]);
      out.print( usuario6 );
      out.write(__oracle_jsp_text[62]);
      out.print(usuario6);
      out.write(__oracle_jsp_text[63]);
       		} 
      out.write(__oracle_jsp_text[64]);
       } else if(usuario15.equals("1")){ 
      out.write(__oracle_jsp_text[65]);
      out.print( usuario1 );
      out.write(__oracle_jsp_text[66]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[67]);
      out.print( usuario6 );
      out.write(__oracle_jsp_text[68]);
      out.print(usuario6);
      out.write(__oracle_jsp_text[69]);
       } 
      out.write(__oracle_jsp_text[70]);
      out.print( usuario7 );
       if(usuario2.length() == 0){ 
      out.write(__oracle_jsp_text[71]);
      out.print( usuario8 );
      out.write(__oracle_jsp_text[72]);
       }else{ 
      out.write(__oracle_jsp_text[73]);
      out.print(ActualizaInst.getNombreInstruccion1(usuario2));
      out.write(__oracle_jsp_text[74]);
       } 
      out.write(__oracle_jsp_text[75]);
      out.print(usuario7);
      out.write(__oracle_jsp_text[76]);
       if(usuario2.length() == 0){ 
      out.write(__oracle_jsp_text[77]);
      out.print(usuario8);
      out.write(__oracle_jsp_text[78]);
       }else{ 
      out.write(__oracle_jsp_text[79]);
      out.print(ActualizaInst.getNombreInstruccion1(usuario2));
      out.write(__oracle_jsp_text[80]);
       } 
      out.write(__oracle_jsp_text[81]);
      out.print( Utilerias.formatearFechas(usuario3) );
      out.write(__oracle_jsp_text[82]);
      out.print( Utilerias.formatearFechas(usuario4) );
      out.write(__oracle_jsp_text[83]);
      
      							fPorcentaje = Utilerias.getPorcentajeDebido(new Integer(usuario9).intValue(), usuario3, usuario4, 5);
      							float iAvance = new Float(usuario10).floatValue();
      							if(fPorcentaje > 100){
      						
      out.write(__oracle_jsp_text[84]);
       }else if(iAvance<fPorcentaje-10){ 
      out.write(__oracle_jsp_text[85]);
       }else if(iAvance > 20 || iAvance < 80){ 
      out.write(__oracle_jsp_text[86]);
       }if(iAvance>fPorcentaje){ 
      out.write(__oracle_jsp_text[87]);
       } 
      out.write(__oracle_jsp_text[88]);
       } 
      out.write(__oracle_jsp_text[89]);
      
      						if (contligas>0 && numPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[90]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[91]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[92]);
      	}
      						if (contPag > 0){  
      							if (contPag > contligas){
      out.write(__oracle_jsp_text[93]);
      out.print(contligas);
      out.write(__oracle_jsp_text[94]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[95]);
      	}else{
      out.write(__oracle_jsp_text[96]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[97]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[98]);
      	} 
      						}
      						if (numPaginas > 1){
      							for (int i=contligas; i<muestraPaginas+contligas && i<numPaginas; i++){ 
      								if (i==contPag){  
      out.write(__oracle_jsp_text[99]);
      out.print(i);
      out.write(__oracle_jsp_text[100]);
      out.print(i+1);
      out.write(__oracle_jsp_text[101]);
      		}else{ 
      out.write(__oracle_jsp_text[102]);
      out.print(i);
      out.write(__oracle_jsp_text[103]);
      out.print(i+1);
      out.write(__oracle_jsp_text[104]);
      		}
      							}
      						} 
      						if (contPag < numPaginas-1){  
      							if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[105]);
      out.print(contligas);
      out.write(__oracle_jsp_text[106]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[107]);
      	}else{
      out.write(__oracle_jsp_text[108]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[109]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[110]);
      	} 
      						}
      						if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[111]);
      out.print( numPaginas-muestraPaginas );
      out.write(__oracle_jsp_text[112]);
      out.print( numPaginas-1 );
      out.write(__oracle_jsp_text[113]);
      	
      						} 
      out.write(__oracle_jsp_text[114]);
       } 
      out.write(__oracle_jsp_text[115]);
       } 
      out.write(__oracle_jsp_text[116]);
       } 
      out.write(__oracle_jsp_text[117]);
       if(j == 0){ 
      		bNoExiste = true;
      	
      out.write(__oracle_jsp_text[118]);
       } 
      out.write(__oracle_jsp_text[119]);
      } else if(BUsuario.getAsistente()){
      out.write(__oracle_jsp_text[120]);
       
      		int j = 0;
      		boolean bExisteAs = false;
      	
      out.write(__oracle_jsp_text[121]);
      
              try{
              for(int k=0;k<strIdsAsiste.length;k++){
      out.write(__oracle_jsp_text[122]);
      
      //		bExisteAs	= ActualizaInstrucciones.TieneInstruccionesRechazadas(strIdsAsiste[k][0]);
                      //bExisteAs = ActualizaInstrucciones.getInstruccionRechazadaUsuario(strIdsAsiste[k][0],strOrden,strTipo).length>0?true:false;
                      bExisteAs = Rechazo.getDatosInstruccionUsuario(strIdsAsiste[k][0],strOrden,strTipo).length>0?true:false;
      			if(bExisteAs){ 
      				bMostrar = strIdUsuario.equals(strIdsAsiste[k][0]);
      	
      out.write(__oracle_jsp_text[123]);
      out.print(strIdsAsiste[k][0]);
      out.write(__oracle_jsp_text[124]);
      out.print((bMostrar)?"collapse.gif":"expand.gif");
      out.write(__oracle_jsp_text[125]);
      out.print( ActualizaUsuario.NombreUsuario(strIdsAsiste[k][0]) );
      out.write(__oracle_jsp_text[126]);
      out.print( ActualizaUsuario.NombrePuesto(strIdsAsiste[k][0]) );
      out.write(__oracle_jsp_text[127]);
       j++; 
      out.write(__oracle_jsp_text[128]);
      if(bMostrar){ 
      out.write(__oracle_jsp_text[129]);
        numRegistros = Rechazo.getDatosInstruccionUsuario(strIdsAsiste[k][0],strOrden,strTipo).length;
      					//	numRegistros = ActualizaInstrucciones.getInstruccionRechazadaUsuario(strIdsAsiste[k][0],strOrden,strTipo).length;
      						if (numRegistros>0){ 
      out.write(__oracle_jsp_text[130]);
      out.print( strIdsAsiste[k][0] );
      out.write(__oracle_jsp_text[131]);
      	} 
      out.write(__oracle_jsp_text[132]);
      	numPaginas = numRegistros/regPorPagina;	
      						if (numRegistros%regPorPagina != 0)
      							numPaginas++; 
      out.write(__oracle_jsp_text[133]);
      	if (numRegistros > 0){	
      out.write(__oracle_jsp_text[134]);
      out.print( numRegistros );
      out.write(__oracle_jsp_text[135]);
      	} 
      out.write(__oracle_jsp_text[136]);
      	if (numPaginas > 1){	
      out.write(__oracle_jsp_text[137]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[138]);
      out.print( numPaginas );
      out.write(__oracle_jsp_text[139]);
       	} 
      out.write(__oracle_jsp_text[140]);
      	String[][] sql = Rechazo.getDatosInstruccionUsuario(strIdsAsiste[k][0],strOrden,strTipo);
      					for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
      						String usuario1 = sql[i][0];
      						String usuario2 = sql[i][1];
      						String usuario3 = sql[i][2];
      						String usuario4 = sql[i][3];
      						String usuario5 = sql[i][4];
      						String usuario6 = sql[i][5];
      						String usuario7 = sql[i][6];
      						String usuario8 = sql[i][7];
      						String usuario9 = sql[i][8];
      						String usuario10 = sql[i][9];
      						String usuario15 = sql[i][14];
      						String usuario16 = sql[i][15];
      				
      out.write(__oracle_jsp_text[141]);
       t++; 
      out.write(__oracle_jsp_text[142]);
      if(par(t)==true){
      out.write(__oracle_jsp_text[143]);
      }else{
      out.write(__oracle_jsp_text[144]);
      }
      out.write(__oracle_jsp_text[145]);
       	if(usuario15.equals("0")){
      								String padre1 = usuario16;
      								if(padre1.length() != 0){ 
      						
      out.write(__oracle_jsp_text[146]);
      out.print( usuario1 );
      out.write(__oracle_jsp_text[147]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[148]);
      out.print( usuario6 );
      out.write(__oracle_jsp_text[149]);
      out.print(usuario6);
      out.write(__oracle_jsp_text[150]);
      		}else{ 
      out.write(__oracle_jsp_text[151]);
      out.print( usuario1 );
      out.write(__oracle_jsp_text[152]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[153]);
      out.print( usuario6 );
      out.write(__oracle_jsp_text[154]);
      out.print(usuario6);
      out.write(__oracle_jsp_text[155]);
       		} 
      out.write(__oracle_jsp_text[156]);
       } else if(usuario15.equals("1")){ 
      out.write(__oracle_jsp_text[157]);
      out.print( usuario1 );
      out.write(__oracle_jsp_text[158]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[159]);
      out.print( usuario6 );
      out.write(__oracle_jsp_text[160]);
      out.print(usuario6);
      out.write(__oracle_jsp_text[161]);
       } 
      out.write(__oracle_jsp_text[162]);
      out.print( usuario7 );
       if(usuario2.length() == 0){ 
      out.write(__oracle_jsp_text[163]);
      out.print( usuario8 );
      out.write(__oracle_jsp_text[164]);
       }else{ 
      out.write(__oracle_jsp_text[165]);
      out.print(ActualizaInst.getNombreInstruccion1(usuario2));
      out.write(__oracle_jsp_text[166]);
       } 
      out.write(__oracle_jsp_text[167]);
      out.print(usuario7);
      out.write(__oracle_jsp_text[168]);
       if(usuario2.length() == 0){ 
      out.write(__oracle_jsp_text[169]);
      out.print(usuario8);
      out.write(__oracle_jsp_text[170]);
       }else{ 
      out.write(__oracle_jsp_text[171]);
      out.print(ActualizaInst.getNombreInstruccion1(usuario2));
      out.write(__oracle_jsp_text[172]);
       } 
      out.write(__oracle_jsp_text[173]);
      out.print( Utilerias.formatearFechas(usuario3) );
      out.write(__oracle_jsp_text[174]);
      out.print( Utilerias.formatearFechas(usuario4) );
      out.write(__oracle_jsp_text[175]);
      
      							fPorcentaje = Utilerias.getPorcentajeDebido(new Integer(usuario9).intValue(), usuario3, usuario4, 5);
      							float iAvance = new Float(usuario10).floatValue();
      							if(fPorcentaje > 100){
      						
      out.write(__oracle_jsp_text[176]);
       }else if(iAvance<fPorcentaje-10){ 
      out.write(__oracle_jsp_text[177]);
       }else if(iAvance > 20 || iAvance < 80){ 
      out.write(__oracle_jsp_text[178]);
       }if(iAvance>fPorcentaje){ 
      out.write(__oracle_jsp_text[179]);
       } 
      out.write(__oracle_jsp_text[180]);
       } 
      out.write(__oracle_jsp_text[181]);
      
      						if (contligas>0 && numPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[182]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[183]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[184]);
      	}
      						if (contPag > 0){  
      							if (contPag > contligas){
      out.write(__oracle_jsp_text[185]);
      out.print(contligas);
      out.write(__oracle_jsp_text[186]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[187]);
      	}else{
      out.write(__oracle_jsp_text[188]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[189]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[190]);
      	} 
      						}
      						if (numPaginas > 1){
      							for (int i=contligas; i<muestraPaginas+contligas && i<numPaginas; i++){ 
      								if (i==contPag){  
      out.write(__oracle_jsp_text[191]);
      out.print(i);
      out.write(__oracle_jsp_text[192]);
      out.print(i+1);
      out.write(__oracle_jsp_text[193]);
      		}else{ 
      out.write(__oracle_jsp_text[194]);
      out.print(i);
      out.write(__oracle_jsp_text[195]);
      out.print(i+1);
      out.write(__oracle_jsp_text[196]);
      		}
      							}
      						} 
      						if (contPag < numPaginas-1){  
      							if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[197]);
      out.print(contligas);
      out.write(__oracle_jsp_text[198]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[199]);
      	}else{
      out.write(__oracle_jsp_text[200]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[201]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[202]);
      	} 
      						}
      						if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[203]);
      out.print( numPaginas-muestraPaginas );
      out.write(__oracle_jsp_text[204]);
      out.print( numPaginas-1 );
      out.write(__oracle_jsp_text[205]);
      	
      						} 
      out.write(__oracle_jsp_text[206]);
       } 
      out.write(__oracle_jsp_text[207]);
       } 
      out.write(__oracle_jsp_text[208]);
       }}catch(Exception e){} 
      out.write(__oracle_jsp_text[209]);
       if(j == 0){ 
      		bNoExiste = true;
      	
      out.write(__oracle_jsp_text[210]);
       } 
      out.write(__oracle_jsp_text[211]);
      } else if(BUsuario.getTurnado() || BUsuario.getSupervisor()){
      out.write(__oracle_jsp_text[212]);
       if(RechazoInstruccion.boleanInstruccionRechazadaVentannilla(BUsuario.getIdArea())){ 
      out.write(__oracle_jsp_text[213]);
       int j = 0; 
      out.write(__oracle_jsp_text[214]);
       String[][] dstosLista = null; 
      out.write(__oracle_jsp_text[215]);
      /* dstosLista = ActualizaInstrucciones.UsuarioInstruccionRechazadaPorTurnador(BUsuario.getIdUsuario()); */
      	/*Consulta todas las instrucciones que han sido rechazadas, dentro de su area */
                  dstosLista = RechazoInstruccion.getDatosInstruccionRechazados(BUsuario.getIdArea());
      	
      out.write(__oracle_jsp_text[216]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(dstosLista);
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
            out.write(__oracle_jsp_text[217]);
            bMostrar = strIdUsuario.equals(campo1);
            out.write(__oracle_jsp_text[218]);
            out.print(campo1);
            out.write(__oracle_jsp_text[219]);
            out.print((bMostrar)?"collapse.gif":"expand.gif");
            out.write(__oracle_jsp_text[220]);
            out.print( ActualizaUsuario.NombreUsuario(campo1) );
            out.write(__oracle_jsp_text[221]);
            out.print( ActualizaUsuario.NombrePuesto(campo1) );
            out.write(__oracle_jsp_text[222]);
             j++; 
            out.write(__oracle_jsp_text[223]);
            if(bMostrar){ 
            out.write(__oracle_jsp_text[224]);
            numRegistros = Rechazo.getDatosInstruccionUsuarioVentanilla(campo1,strOrden,strTipo).length;
                                      if (numRegistros>0){
            out.write(__oracle_jsp_text[225]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[226]);
            	} 
            out.write(__oracle_jsp_text[227]);
            	numPaginas = numRegistros/regPorPagina;	
            					if (numRegistros%regPorPagina != 0)
            						numPaginas++; 
            out.write(__oracle_jsp_text[228]);
            	if (numRegistros > 0){	
            out.write(__oracle_jsp_text[229]);
            out.print( numRegistros );
            out.write(__oracle_jsp_text[230]);
            	} 
            out.write(__oracle_jsp_text[231]);
            	if (numPaginas > 1){	
            out.write(__oracle_jsp_text[232]);
            out.print( contPag+1 );
            out.write(__oracle_jsp_text[233]);
            out.print( numPaginas );
            out.write(__oracle_jsp_text[234]);
             	} 
            out.write(__oracle_jsp_text[235]);
            	String[][] sql = Rechazo.getDatosInstruccionUsuarioVentanilla(campo1,strOrden,strTipo);
            				for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
            					String usuario1 = sql[i][0];
            					String usuario2 = sql[i][1];
            					String usuario3 = sql[i][2];
            					String usuario4 = sql[i][3];
            					String usuario5 = sql[i][4];
            					String usuario6 = sql[i][5];
            					String usuario7 = sql[i][6];
            					String usuario8 = sql[i][7];
            					String usuario9 = sql[i][8];
            					String usuario10 = sql[i][9];
            					String usuario15 = sql[i][14];
            					String usuario16 = sql[i][15];
            			
            out.write(__oracle_jsp_text[236]);
             t++; 
            out.write(__oracle_jsp_text[237]);
            if(par(t)==true){
            }else{
            out.write(__oracle_jsp_text[238]);
            }
            out.write(__oracle_jsp_text[239]);
             	if(usuario15.equals("0")){
            								String padre1 = usuario16;
            								if(padre1.length() != 0){ 
            						
            out.write(__oracle_jsp_text[240]);
            out.print( usuario1 );
            out.write(__oracle_jsp_text[241]);
            out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) );
            out.write(__oracle_jsp_text[242]);
            out.print( usuario6 );
            out.write(__oracle_jsp_text[243]);
            out.print(usuario6);
            out.write(__oracle_jsp_text[244]);
            		}else{ 
            out.write(__oracle_jsp_text[245]);
            out.print( usuario1 );
            out.write(__oracle_jsp_text[246]);
            out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) );
            out.write(__oracle_jsp_text[247]);
            out.print( usuario6 );
            out.write(__oracle_jsp_text[248]);
            out.print(usuario6);
            out.write(__oracle_jsp_text[249]);
             		} 
            out.write(__oracle_jsp_text[250]);
             } else if(usuario15.equals("1")){ 
            out.write(__oracle_jsp_text[251]);
            out.print( usuario1 );
            out.write(__oracle_jsp_text[252]);
            out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) );
            out.write(__oracle_jsp_text[253]);
            out.print( usuario6 );
            out.write(__oracle_jsp_text[254]);
            out.print(usuario6);
            out.write(__oracle_jsp_text[255]);
             } 
            out.write(__oracle_jsp_text[256]);
            out.print( usuario7 );
             if(usuario2.length() == 0){ 
            out.write(__oracle_jsp_text[257]);
            out.print( usuario8 );
            out.write(__oracle_jsp_text[258]);
             }else{ 
            out.write(__oracle_jsp_text[259]);
            out.print(ActualizaInst.getNombreInstruccion1(usuario2));
            out.write(__oracle_jsp_text[260]);
             } 
            out.write(__oracle_jsp_text[261]);
            out.print(usuario7);
            out.write(__oracle_jsp_text[262]);
             if(usuario2.length() == 0){ 
            out.write(__oracle_jsp_text[263]);
            out.print(usuario8);
            out.write(__oracle_jsp_text[264]);
             }else{ 
            out.write(__oracle_jsp_text[265]);
            out.print(ActualizaInst.getNombreInstruccion1(usuario2));
            out.write(__oracle_jsp_text[266]);
             } 
            out.write(__oracle_jsp_text[267]);
            out.print( Utilerias.formatearFechas(usuario3) );
            out.write(__oracle_jsp_text[268]);
            out.print( Utilerias.formatearFechas(usuario4) );
            out.write(__oracle_jsp_text[269]);
            
            							fPorcentaje = Utilerias.getPorcentajeDebido(new Integer(usuario9).intValue(), usuario3, usuario4, 5);
            							float iAvance = new Float(usuario10).floatValue();
            							if(fPorcentaje > 100){
            						
            out.write(__oracle_jsp_text[270]);
             }else if(iAvance<fPorcentaje-10){ 
            out.write(__oracle_jsp_text[271]);
             }else if(iAvance > 20 || iAvance < 80){ 
            out.write(__oracle_jsp_text[272]);
             }if(iAvance>fPorcentaje){ 
            out.write(__oracle_jsp_text[273]);
             } 
            out.write(__oracle_jsp_text[274]);
             } 
            out.write(__oracle_jsp_text[275]);
            
            				if (contligas>0 && numPaginas > muestraPaginas){  
            out.write(__oracle_jsp_text[276]);
            out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
            out.write(__oracle_jsp_text[277]);
            out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
            out.write(__oracle_jsp_text[278]);
            	}
            				if (contPag > 0){  
            					if (contPag > contligas){
            out.write(__oracle_jsp_text[279]);
            out.print(contligas);
            out.write(__oracle_jsp_text[280]);
            out.print(contPag-1);
            out.write(__oracle_jsp_text[281]);
            	}else{
            out.write(__oracle_jsp_text[282]);
            out.print(contligas-1);
            out.write(__oracle_jsp_text[283]);
            out.print(contPag-1);
            out.write(__oracle_jsp_text[284]);
            	} 
            				}
            				if (numPaginas > 1){
            					for (int i=contligas; i<muestraPaginas+contligas && i<numPaginas; i++){ 
            						if (i==contPag){  
            out.write(__oracle_jsp_text[285]);
            out.print(i);
            out.write(__oracle_jsp_text[286]);
            out.print(i+1);
            out.write(__oracle_jsp_text[287]);
            		}else{ 
            out.write(__oracle_jsp_text[288]);
            out.print(i);
            out.write(__oracle_jsp_text[289]);
            out.print(i+1);
            out.write(__oracle_jsp_text[290]);
            		}
            					}
            				} 
            				if (contPag < numPaginas-1){  
            					if (contPag < contligas + muestraPaginas-1){
            out.write(__oracle_jsp_text[291]);
            out.print(contligas);
            out.write(__oracle_jsp_text[292]);
            out.print(contPag+1);
            out.write(__oracle_jsp_text[293]);
            	}else{
            out.write(__oracle_jsp_text[294]);
            out.print(contligas+1);
            out.write(__oracle_jsp_text[295]);
            out.print(contPag+1);
            out.write(__oracle_jsp_text[296]);
            	} 
            				}
            				if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){  
            out.write(__oracle_jsp_text[297]);
            out.print( numPaginas-muestraPaginas );
            out.write(__oracle_jsp_text[298]);
            out.print( numPaginas-1 );
            out.write(__oracle_jsp_text[299]);
            	
            				} 
            out.write(__oracle_jsp_text[300]);
             } 
            out.write(__oracle_jsp_text[301]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[302]);
       if(j == 0 && !bNoExiste){ 
      out.write(__oracle_jsp_text[303]);
       } 
      out.write(__oracle_jsp_text[304]);
       } else if (!bNoExiste){ 
      out.write(__oracle_jsp_text[305]);
       } 
      out.write(__oracle_jsp_text[306]);
      }
      out.write(__oracle_jsp_text[307]);

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
  private static final char __oracle_jsp_text[][]=new char[308][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD> \n".toCharArray();
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
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Instrucciones Rechazadas</TITLE>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script language=\"JavaScript\" type=\"text/javascript\">\nfunction desplegar(id){\n\tdoc = document.pRechaza;\n\tdoc.accion.value=\"reload\";\n\tif (id==doc.idUs.value){\n\t\tdoc.idUs.value=0;\n\t\tdoc.submit();\n\t}else{\n\t\tdoc.idUs.value=id;\n\t\tdoc.contPag.value=0;\n\t\tdoc.contligas.value=0;\n\t\tdoc.submit();\n\t}\n}\nfunction cambio(o, t){\n\tdoc = document.pRechaza;\n\tdoc.accion.value=\"reload\";\n\tdoc.orden.value=o;\n\tdoc.tipo.value=t;\n\tdoc.submit();\n}\nfunction pagina(contador){\n\tdoc = document.pRechaza;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\n\nfunction paginaLiga(contador){\n\tdoc = document.pRechaza;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<span id=\"ruler\" style=\"visibility:hidden;\"></span> \n<FORM method=\"post\" action=\"PortalRechazadas.jsp\" name=\"pRechaza\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"idUs\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"contligas\">\n<table cellspacing=\"2\" cellpadding=\"2\">\n<TBODY>\n\t<TR>\n\t\t<TD class=\"etiquetas\">\n\t\t\t\n\t\t</TD>\n\t</TR>\n</TBODY>\n</table>\n<table cellspacing=\"2\" cellpadding=\"2\">\n\t<TBODY>\n\t\t<tr>\n\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAtencion()\";>Asuntos en Recepción</a></td>\n                ".toCharArray();
    __oracle_jsp_text[19] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[20] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntos()\";>Asuntos por turnar</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntosTr()\";>Asuntos en Trámite</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goAsuntosTer()\";>Asuntos terminados</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[22] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goAtender()\";>Instrucciones por atender</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goTramite()\";>Instrucciones en Trámite</a></td>\n                    <td class=\"dominoTopTab\"><a onclick=\"goTerminadas()\";>Instrucciones terminadas</a></td>\n                ".toCharArray();
    __oracle_jsp_text[23] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[24] = 
    "\n                    <td class=\"dominoSelTopTab\" bgcolor=\"#004080\"><a onclick=\"goRechazadas()\";>Instrucciones rechazadas</a></td>\n\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[26] = 
    "\n                    <td class=\"dominoTopTab\"><a onclick=\"goSolicitada()\";>Asuntos Solicitados</a></td>\n                ".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t</tr>\n\t</TBODY>\n</table>\n<br>\n<!--- Encabezado de las instrucciones rechazadas -->\n<TABLE WIDTH='100%' BORDER=\"0\">\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD id=\"Asunto_HD\" WIDTH='20%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">\n\t\t\t<a onclick=\"cambio('asc', 6)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tFolio\n\t\t\t<a onclick=\"cambio('desc', 6)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font>\n\t\t</TD>\n\t\t<TD id=\"Asunto_HD2\" WIDTH='50%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">\n\t\t\t<a onclick=\"cambio('asc', 7)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tAsunto(instrucción)\n\t\t\t<a onclick=\"cambio('desc', 7)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font>\n\t\t</TD>\n\t\t<TD id=\"Asunto_HD3\" WIDTH='20%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">\n\t\t\t<a onclick=\"cambio('asc', 14)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tRecibido/Concluido\n\t\t\t<a onclick=\"cambio('desc', 14)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font>\n\t\t</TD>\n\t\t<TD id=\"Asunto_HD4\" WIDTH='10%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"Arial\">Estatus</font>\n\t\t</TD>\n\t</TR>\t\n </TABLE> \n<div id=\"msg\">\n</div>\n\n<DIV class=documentBody id=Body>\n".toCharArray();
    __oracle_jsp_text[28] = 
    "\n<div id=\"view\">\n<!-- Instrucciones rechazadas de usuario con rol de atención -->\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t<TR>\n\t\t<TD colspan=\"4\">\n\t\t<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n\t\t\t<TBODY>\n\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t<td colspan=\"5\" width=\"100%\"><a onClick=\"desplegar(".toCharArray();
    __oracle_jsp_text[32] = 
    ")\"> <img\n\t\t\t\t\t\tsrc=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[33] = 
    "\"\n\t\t\t\t\t\tborder=\"0\" height=\"16\" width=\"16\"> \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    " / ".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t\t\t</a></td>\n\t\t\t\t</tr>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t<TR>\n\t\t\t\t\t<TD align=\"left\" colspan=\"2\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<A href=\"../ReporteAsuntoExcel?tip=inst_rechazada_01&id_remitente=".toCharArray();
    __oracle_jsp_text[39] = 
    "\">\n\t\t\t\t\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t\t\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t\t\t\t\t</A>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD align=\"right\" colspan=\"3\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    " registros mostrados.\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[46] = 
    " de ".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t</TD>\n\t\t\t\t</TR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[51] = 
    " ".toCharArray();
    __oracle_jsp_text[52] = 
    " bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[53] = 
    ">\n\t\t\t\t\t\t<td align=\"left\" width=\"20%\">\n                                                &nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\"> \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t\t\t\t\t\t<A href=\"InstruccionHija.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[55] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[56] = 
    "\"\n\t\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[57] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[58] = 
    "','Asunto_HD'));</script>\n\t\t\t\t\t\t\t</A> \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t\t\t\t\t\t<A href=\"InstruccionesAtender.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[60] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[61] = 
    "\"\n\t\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[62] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[63] = 
    "','Asunto_HD'));</script>\n\t\t\t\t\t\t\t</A> \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t\t\t\t\t\t\t<A href=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[66] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[67] = 
    "\"\n\t\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[68] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[69] = 
    "','Asunto_HD'));</script>\n\t\t\t\t\t\t\t</A> \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[70] = 
    "\n\t\t\t\t\t\t</font>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td align=\"center\" width=\"50%\"><A\n\t\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[71] = 
    "(".toCharArray();
    __oracle_jsp_text[72] = 
    ")\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "(".toCharArray();
    __oracle_jsp_text[74] = 
    ")".toCharArray();
    __oracle_jsp_text[75] = 
    "\">\n\t\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\"> <script>document.write(trunc('".toCharArray();
    __oracle_jsp_text[76] = 
    "','Asunto_HD2'));</script>".toCharArray();
    __oracle_jsp_text[77] = 
    "(<script>document.write(trunc('".toCharArray();
    __oracle_jsp_text[78] = 
    "','Asunto_HD2'));</script>)\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "(<script>document.write(trunc('".toCharArray();
    __oracle_jsp_text[80] = 
    "','Asunto_HD2'));</script>)".toCharArray();
    __oracle_jsp_text[81] = 
    "\n\t\t\t\t\t\t</font></A></td>\n\t\t\t\t\t\t<td align=\"center\" width=\"20%\"><font size=\"1\" color=\"#000080\"\n\t\t\t\t\t\t\tface=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[82] = 
    " -- ".toCharArray();
    __oracle_jsp_text[83] = 
    "\n\t\t\t\t\t\t</font>\n                                                </td>\n\t\t\t\t\t\t<td align=\"center\" width=\"10%\"><font size=\"1\" color=\"#000080\"\n\t\t\t\t\t\t\tface=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[84] = 
    " <IMG border=\"0\" src=\"../Imagenes/rojob5.gif\" width=\"10\"\n\t\t\t\t\t\t\theight=\"10\" alt=\"Deberia llevar el 100%\"> ".toCharArray();
    __oracle_jsp_text[85] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/rojo5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[86] = 
    " <IMG border=\"0\"\n\t\t\t\t\t\t\tsrc=\"../Imagenes/amarillo5.gif\" width=\"11\" height=\"11\"> ".toCharArray();
    __oracle_jsp_text[87] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/verde5.gif\" width=\"11\"\n\t\t\t\t\t\t\theight=\"11\"> ".toCharArray();
    __oracle_jsp_text[88] = 
    " </font></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[89] = 
    "\n\t\t\t\t\t<TR>\n\t\t\t\t\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[90] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[91] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[92] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[93] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[94] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[95] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[96] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[97] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[98] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[99] = 
    "\n\t\t\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[100] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[101] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[102] = 
    "\n\t\t\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[103] = 
    ")\">".toCharArray();
    __oracle_jsp_text[104] = 
    "</A> &nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[105] = 
    "\n\t\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[106] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[107] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[108] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[109] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[110] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[111] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[112] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[113] = 
    ");\"> <B>FINAL</B> </A>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[114] = 
    "\n\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[115] = 
    "\n\t\t\t</TBODY>\n\t\t</table>\n\t\t".toCharArray();
    __oracle_jsp_text[116] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[117] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[118] = 
    "\n                </TD>\n        </TR>\n\t<TR>\n\t\t<TD width=\"100%\">\n\t\t\t<div align=center>\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">****** No tiene Instrucciones Rechazadas ******</FONT>\n\t\t\t</div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[119] = 
    "\n</TBODY>\n</table>\n</div>\n".toCharArray();
    __oracle_jsp_text[120] = 
    "\n<div id=\"view\">\n<!-- Instruccion es rechazadas de usurio con rol de tipo Asistente -->\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[121] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[122] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[123] = 
    "\n\t<TR>\n\t\t<TD>\n\t\t<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%>\n\t\t\t<TBODY>\n\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t<td colspan=\"5\" width=\"100%\"><a onClick=\"desplegar(".toCharArray();
    __oracle_jsp_text[124] = 
    ")\"> <img\n\t\t\t\t\t\tsrc=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[125] = 
    "\"\n\t\t\t\t\t\tborder=\"0\" height=\"16\" width=\"16\"> \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[126] = 
    " / ".toCharArray();
    __oracle_jsp_text[127] = 
    "\n\t\t\t\t\t</a></td>\n\t\t\t\t</tr>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[128] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[129] = 
    "\n\t\t\t\t<TR>\n\t\t\t\t\t<TD align=\"left\" colspan=\"2\">\n                                        ".toCharArray();
    __oracle_jsp_text[130] = 
    "\n\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<A href=\"../ReporteAsuntoExcel?tip=inst_rechazada_01&id_remitente=".toCharArray();
    __oracle_jsp_text[131] = 
    "\">\n\t\t\t\t\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t\t\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t\t\t\t\t</A>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[132] = 
    "\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD align=\"right\" colspan=\"3\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[133] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[134] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[135] = 
    " registros mostrados.\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[136] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[137] = 
    "\n\t\t\t\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[138] = 
    " de ".toCharArray();
    __oracle_jsp_text[139] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[140] = 
    "\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t</TD>\n\t\t\t\t</TR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[141] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[142] = 
    "\n\t\t\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[143] = 
    " ".toCharArray();
    __oracle_jsp_text[144] = 
    " bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[145] = 
    ">\n<!--\t\t\t\t\t\t<td width=\"2%\"></td>    -->\n\t\t\t\t\t\t<td align=\"left\" width=\"20%\">\n                                                &nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\"> \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[146] = 
    "\n\t\t\t\t\t\t\t<A href=\"InstruccionHija.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[147] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[148] = 
    "\"\n\t\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[149] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[150] = 
    "','Asunto_HD'));</script>\n\t\t\t\t\t\t\t</A> \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[151] = 
    "\n\t\t\t\t\t\t\t<A href=\"InstruccionesAtender.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[152] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[153] = 
    "\"\n\t\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[154] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[155] = 
    "','Asunto_HD'));</script>\n\t\t\t\t\t\t\t</A> \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[156] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[157] = 
    "\n\t\t\t\t\t\t\t<A href=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[158] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[159] = 
    "\"\n\t\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[160] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[161] = 
    "','Asunto_HD'));</script>\n\t\t\t\t\t\t\t</A> \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[162] = 
    "\n\t\t\t\t\t\t</font>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td align=\"center\" width=\"50%\"><A\n\t\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[163] = 
    "(".toCharArray();
    __oracle_jsp_text[164] = 
    ")\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[165] = 
    "(".toCharArray();
    __oracle_jsp_text[166] = 
    ")".toCharArray();
    __oracle_jsp_text[167] = 
    "\">\n\t\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\"> <script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[168] = 
    "','Asunto_HD2'));</script>".toCharArray();
    __oracle_jsp_text[169] = 
    "(<script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[170] = 
    "','Asunto_HD2'));</script>)\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[171] = 
    "(<script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[172] = 
    "','Asunto_HD2'));</script>)".toCharArray();
    __oracle_jsp_text[173] = 
    "\n\t\t\t\t\t\t</font></A></td>\n\t\t\t\t\t\t<td align=\"center\" width=\"20%\"><font size=\"1\" color=\"#000080\"\n\t\t\t\t\t\t\tface=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[174] = 
    " -- ".toCharArray();
    __oracle_jsp_text[175] = 
    "\n\t\t\t\t\t\t</font></td>\n\t\t\t\t\t\t<td align=\"center\" width=\"10%\"><font size=\"1\" color=\"#000080\"\n\t\t\t\t\t\t\tface=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[176] = 
    " <IMG border=\"0\" src=\"../Imagenes/rojob5.gif\" width=\"10\"\n\t\t\t\t\t\t\theight=\"10\" alt=\"Deberia llevar el 100%\"> ".toCharArray();
    __oracle_jsp_text[177] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/rojo5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[178] = 
    " <IMG border=\"0\"\n\t\t\t\t\t\t\tsrc=\"../Imagenes/amarillo5.gif\" width=\"11\" height=\"11\"> ".toCharArray();
    __oracle_jsp_text[179] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/verde5.gif\" width=\"11\"\n\t\t\t\t\t\t\theight=\"11\"> ".toCharArray();
    __oracle_jsp_text[180] = 
    " </font></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[181] = 
    "\n\t\t\t\t\t<TR>\n\t\t\t\t\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[182] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[183] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[184] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[185] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[186] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[187] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[188] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[189] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[190] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[191] = 
    "\n\t\t\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[192] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[193] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[194] = 
    "\n\t\t\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[195] = 
    ")\">".toCharArray();
    __oracle_jsp_text[196] = 
    "</A> &nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[197] = 
    "\n\t\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[198] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[199] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[200] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[201] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[202] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[203] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[204] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[205] = 
    ");\"> <B>FINAL</B> </A>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[206] = 
    "\n\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[207] = 
    "\n\t\t\t</TBODY>\n\t\t</table>\n\t\t".toCharArray();
    __oracle_jsp_text[208] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[209] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[210] = 
    "\n\t<TR>\n\t\t<TD width=\"100%\">\n\t\t\t<div align=center>\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">****** No tiene Instrucciones Rechazadas ******</FONT>\n\t\t\t</div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[211] = 
    "\n</TBODY>\t\n</table>\n</div>\n".toCharArray();
    __oracle_jsp_text[212] = 
    "\n<div id=\"view\">\n<!-- Instrucciones rechazadas de usuario con rol de tipo turnador -->\n<table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n<TBODY>\n<!-- Se verifica que este pool, contiene instrucciones rechazadas -->\n\t".toCharArray();
    __oracle_jsp_text[213] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[214] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[215] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[216] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[217] = 
    "     \n\t".toCharArray();
    __oracle_jsp_text[218] = 
    "\n            <table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\">\n                <TBODY>\n                    <tr valign=\"top\">\n                        <td colspan=\"5\" width=\"100%\">\n                            <a onClick=\"desplegar(".toCharArray();
    __oracle_jsp_text[219] = 
    ")\">\n                                <img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[220] = 
    "\" border=\"0\" height=\"16\" width=\"16\"/>\n                                    ".toCharArray();
    __oracle_jsp_text[221] = 
    " / ".toCharArray();
    __oracle_jsp_text[222] = 
    "\n                            </a>\n                        </td>\n                    </tr>\n                    ".toCharArray();
    __oracle_jsp_text[223] = 
    "\n                    ".toCharArray();
    __oracle_jsp_text[224] = 
    "\n                    <TR>\n                        <TD align=\"left\" colspan=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[225] = 
    "\n                            &nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t  <A href=\"../ReporteAsuntoExcel?tip=inst_rechazada_01&id_remitente=".toCharArray();
    __oracle_jsp_text[226] = 
    "\">\n\t\t\t\t\t<img src=\"../Imagenes/button_xls.gif\" border=\"0\" height=\"16\" width=\"16\">\n\t\t\t\t\t<FONT face=\"Arial\" size=\"2\">Exportar a Excel</FONT>\n\t\t\t\t\t</A>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[227] = 
    "\n\t\t\t\t</TD>\n\t\t\t\t<TD align=\"right\" colspan=\"3\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[228] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[229] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[230] = 
    " registros mostrados.\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[231] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[232] = 
    "\n\t\t\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[233] = 
    " de ".toCharArray();
    __oracle_jsp_text[234] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[235] = 
    "\n\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[236] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[237] = 
    "\n\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[238] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[239] = 
    ">\n\t\t\t\t<td align=\"left\" width=\"20%\">&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[240] = 
    "\n\t\t\t\t\t\t\t<A href=\"InstruccionHija.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[241] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[242] = 
    "\"\n\t\t\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[243] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[244] = 
    "','Asunto_HD'));</script>\n\t\t\t\t\t\t\t</A>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[245] = 
    "\n\t\t\t\t\t\t\t<A href=\"InstruccionesAtender.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[246] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[247] = 
    "\"\n\t\t\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[248] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[249] = 
    "','Asunto_HD'));</script>\n\t\t\t\t\t\t\t</A>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[250] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[251] = 
    "\n\t\t\t\t\t\t\t<A href=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[252] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[253] = 
    "\"\n\t\t\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[254] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[255] = 
    "','Asunto_HD'));</script>\n\t\t\t\t\t\t\t</A>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[256] = 
    "\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"center\" width=\"50%\">\n\t\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[257] = 
    "(".toCharArray();
    __oracle_jsp_text[258] = 
    ")\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[259] = 
    "(".toCharArray();
    __oracle_jsp_text[260] = 
    ")".toCharArray();
    __oracle_jsp_text[261] = 
    "\">\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t<script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[262] = 
    "','Asunto_HD2'));</script>".toCharArray();
    __oracle_jsp_text[263] = 
    "(<script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[264] = 
    "','Asunto_HD2'));</script>)\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[265] = 
    "(<script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[266] = 
    "','Asunto_HD2'));</script>)".toCharArray();
    __oracle_jsp_text[267] = 
    "\n\t\t\t\t\t</font></A>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"center\" width=\"20%\">\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[268] = 
    " -- ".toCharArray();
    __oracle_jsp_text[269] = 
    "\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"center\" width=\"10%\">\n\t\t\t\t\t<font size=\"1\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[270] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/rojob5.gif\" width=\"10\"\theight=\"10\" alt=\"Deberia llevar el 100%\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[271] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/rojo5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[272] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/amarillo5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[273] = 
    "\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/verde5.gif\" width=\"11\" height=\"11\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[274] = 
    "\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[275] = 
    "\n\t\t\t<TR>\n\t\t\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[276] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[277] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[278] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[279] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[280] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[281] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[282] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[283] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[284] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[285] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[286] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[287] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[288] = 
    "\n\t\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[289] = 
    ")\">".toCharArray();
    __oracle_jsp_text[290] = 
    "</A> &nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[291] = 
    "\n\t\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[292] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[293] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[294] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[295] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[296] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[297] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[298] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[299] = 
    ");\"> <B>FINAL</B> </A>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[300] = 
    "\n\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[301] = 
    "\n\t\t</TBODY>\n\t\t</table>\n\t".toCharArray();
    __oracle_jsp_text[302] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[303] = 
    "\n\t<TR>\n\t\t<TD width=\"100%\">\n\t\t\t<div align=center>\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">****** No tiene Instrucciones Rechazadas ******</FONT>\n\t\t\t</div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[304] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[305] = 
    " \n\t<TR>\n\t\t<TD width=\"100%\">\n\t\t\t<div align=center>\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">****** No tiene Instrucciones Rechazadas ******</FONT>\n\t\t\t</div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[306] = 
    "\n</TBODY>\t\n</table>\n</div>\n".toCharArray();
    __oracle_jsp_text[307] = 
    "\n<BR>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n<BR>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
