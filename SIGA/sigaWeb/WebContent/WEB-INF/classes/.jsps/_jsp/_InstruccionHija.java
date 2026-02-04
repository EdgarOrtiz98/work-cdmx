package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.reportes.*;
import java.text.SimpleDateFormat;
import com.meve.sigma.util.*;
import java.sql.Date;
import gob.hacienda.cgtic.siga.actualiza.RechazoInstruccion;
import gob.hacienda.cgtic.siga.actualiza.AtenderInstrucciones;
import gob.hacienda.cgtic.siga.util.Jefe;
import gob.hacienda.cgtic.siga.instruccion.Actualiza;
import gob.hacienda.cgtic.siga.Usuario;


public class _InstruccionHija extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


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
    _InstruccionHija page = this;
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
      com.meve.sigma.beans.EscrituraBean BEscritura;
      synchronized (pageContext) {
        if ((BEscritura = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscritura", PageContext.PAGE_SCOPE)) == null) {
          BEscritura = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
          pageContext.setAttribute( "BEscritura", BEscritura, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[4]);
      com.meve.sigma.beans.EscrituraBean BEscritura1;
      synchronized (pageContext) {
        if ((BEscritura1 = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscritura1", PageContext.PAGE_SCOPE)) == null) {
          BEscritura1 = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
          pageContext.setAttribute( "BEscritura1", BEscritura1, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[5]);
      com.meve.sigma.beans.EscrituraBean BEscritura2;
      synchronized (pageContext) {
        if ((BEscritura2 = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscritura2", PageContext.PAGE_SCOPE)) == null) {
          BEscritura2 = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
          pageContext.setAttribute( "BEscritura2", BEscritura2, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[6]);
      com.meve.sigma.beans.EscrituraBean BEscrituraAr;
      synchronized (pageContext) {
        if ((BEscrituraAr = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscrituraAr", PageContext.PAGE_SCOPE)) == null) {
          BEscrituraAr = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
          pageContext.setAttribute( "BEscrituraAr", BEscrituraAr, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[7]);
      com.meve.sigma.beans.EscrituraBean BEscrituraTur;
      synchronized (pageContext) {
        if ((BEscrituraTur = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscrituraTur", PageContext.PAGE_SCOPE)) == null) {
          BEscrituraTur = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
          pageContext.setAttribute( "BEscrituraTur", BEscrituraTur, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[8]);
      com.meve.sigma.beans.EscrituraBean CambioTra;
      synchronized (pageContext) {
        if ((CambioTra = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "CambioTra", PageContext.PAGE_SCOPE)) == null) {
          CambioTra = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
          pageContext.setAttribute( "CambioTra", CambioTra, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[9]);
      com.meve.sigma.beans.EscrituraBean BImprimir;
      synchronized (pageContext) {
        if ((BImprimir = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BImprimir", PageContext.PAGE_SCOPE)) == null) {
          BImprimir = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
          pageContext.setAttribute( "BImprimir", BImprimir, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[10]);
      out.write(__oracle_jsp_text[11]);
      out.write(__oracle_jsp_text[12]);
      out.write(__oracle_jsp_text[13]);
      out.write(__oracle_jsp_text[14]);
      out.write(__oracle_jsp_text[15]);
      out.write(__oracle_jsp_text[16]);
      
      	String strIdInstruccion		=	""; //Contiene el ID de la instrucción
      	strIdInstruccion		=	(request.getParameter("id_ins") != null)?request.getParameter("id_ins"):"";
          request.setAttribute("idInstruccion",strIdInstruccion);
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp = request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+strTmp+"?id_ins="+strIdInstruccion);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("E/RROR:"+io.getMessage());
      		}
      	}
      	String [][]historialInstruccion=ActualizaHistorial.getHistorialInstruccion(strIdInstruccion);
      	request.setAttribute("historial",historialInstruccion);
      
      out.write(__oracle_jsp_text[17]);
      
          String idUsuarioTurnador    =   "";
      	String strIdAsunto			=	""; //Contiene el ID del Asunto
      	String strNombre			=	"";
      	String strTelefono			=	"";
      	String strCorreo			=	"";
      	String strTipoAtencion		=	"";
      	String strAcceso			=	"";
      	String strAsunto			=	"";
      	String strPaso				=	"";
      	String strFecGeneracion		=	"";
      	String strFecVencimiento	=	"";
      	String strEstatus			=	"";
      	String strTurnadoPor		=	"";
      	String strFolioRecepcion	=	"";
      	String strFolioTurnado		=	"";
      	String strFolioIntermedio	=	"";
      	String strInstruccion		=	"";
      	String strInstruccionOtro	=	"";
      	String strSintesis			=	"";
      	String strAtencion			=	"";
      	String strVerDocto			=	"";
      	String strNombreInstruccion	=	"";
      	String strAvance			=	"";
      	String strMostrarHabilitado	=	"";
      	String strDelegado			=	"";
      	String strUsuarioOriginal	=	"";
          String strFirmaDigital		= 	"";
          String strFechaTerminacionReal = "";
      	String strIdAsistente		=	"";
      	String strIdJefe			=	"";
      	String strIdUsuario			=	"";
      	String strIdArea			=	"";
      	String strFechaCambio		=	"";
      	String esDelegado			=	"";
      	String strAccion			=	"";
      	String strPadre				=	"";
      	String strFechaCreacion		=	"";
      	String strHabilitado		=	"";
      	String strBandera			=	"";
      	String strCargo				=	"";
      	String strBandera1			=	"";
      	String strTurno				=	"";
      	String strIdUsuarioAsistente=	"";
      	String strUsuarioTermino	=	"";
      	/* <MEVE CORTE: 20071130> */
      	String folioEntrada			=	"";
      	String ruta					=	"";
      	String califica				=	"";
      	String paso					=	"";
      	/* </MEVE CORTE> 			*/
      	int iTieneFechaCambio		=	0;
      	String serverContentManager	=  	application.getInitParameter("content");
      	String server 				= 	application.getInitParameter("servername");
      	String strActivarCM 		= 	application.getInitParameter("ActivarContent");
      	String strBase				=	application.getInitParameter("RutaBase");
      	/* <MEVE CORTE: 20071130> */
      	String serverMail			= 	session.getServletContext().getAttribute("app.siga.serverMail").toString();
      	String portServer			= 	application.getInitParameter("PortMail");
      	String serverName 			= 	application.getInitParameter("servername");
      	/* </MEVE CORTE>		*/
      	String strItemType  		=  (application.getInitParameter("ItemType")==null)?"":application.getInitParameter("ItemType");
      
      	String strSubordinado[][]	=	null;
      	String asistentes[]			=	null;
      
      	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
          String retURI2 = (request.getParameter("retURI2")== null)?retURI:request.getParameter("retURI2");
          
      	SimpleDateFormat sdf 	=	new SimpleDateFormat("dd/MM/yyyy");
          java.util.Date f 		=	new java.util.Date();
         	strFechaCreacion 		=	sdf.format(f);
          
      	String url = request.getRequestURI();
      	String URL = server+url+"?id_ins="+strIdInstruccion;
      
      	boolean bHistorial			= false;
      	boolean bActualizaInf 		= false;
      	boolean bInsertar 			= false;
      	boolean bTieneSubordinados 	= false;
      	boolean bTieneTramite 		= false;
      	boolean bAsistente			= false;
      
              boolean bJefe                   = false;
      
      	strAccion	=	(request.getParameter("accion")==null)?"":request.getParameter("accion");
      	
      	/*<MEVE CORTE: 20071130>*/
      /*	if (strAccion.equals("cancelar")){
      		ActualizaInstrucciones.cancelacionProceso(request, BUsuario, serverMail, portServer, serverName);
      	}*/
      	/*</MEVE CORTE>*/
      	if(strInstruccion != null)
      	{
      		String strDatosInstrucciones[][]	=	ActualizaInstrucciones.getInstruccionDatos(strIdInstruccion);
      		
      		if (strDatosInstrucciones.length == 0) {
      out.write(__oracle_jsp_text[18]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoInstruccionExistente.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[19]);
      } else {
      		
      					strIdAsunto			=	ActualizaInstrucciones.getIdAsuntoInstruccion(strIdInstruccion);
      			                strUsuarioOriginal      =	strDatosInstrucciones[0][0];
      			                strInstruccion	        =	strDatosInstrucciones[0][1];
      					paso		        =	strDatosInstrucciones[0][2];
      			                strTipoAtencion	        =	strDatosInstrucciones[0][3];
      			                strFecGeneracion        =	strDatosInstrucciones[0][7];
      					strFecVencimiento       =	strDatosInstrucciones[0][8];
      					strAcceso	        =	strDatosInstrucciones[0][4];
      			                strInstruccionOtro      =	strDatosInstrucciones[0][9];
      			                strAsunto   	        =	strDatosInstrucciones[0][10];
      			                strSintesis	        =	strDatosInstrucciones[0][11];
      			                strTurnadoPor	        =	strDatosInstrucciones[0][12];
      					strNombre	        =	strDatosInstrucciones[0][13];
      					strTelefono	        =	strDatosInstrucciones[0][14];
      					strCorreo	        =	strDatosInstrucciones[0][15];
      					strFolioRecepcion       =	strDatosInstrucciones[0][16];
      					strFolioIntermedio      =	strDatosInstrucciones[0][17];
      					strFolioTurnado	        =	strDatosInstrucciones[0][18];
      					strEstatus	        =	strDatosInstrucciones[0][19];
      					strAvance	        =	strDatosInstrucciones[0][20];
      					strDelegado	        =	strDatosInstrucciones[0][21];
      					strPadre	        =	strDatosInstrucciones[0][22];
      					strFirmaDigital	        = 	strDatosInstrucciones[0][23];
      			                strFechaTerminacionReal =       strDatosInstrucciones[0][24];
      					strIdAsistente		=	strDatosInstrucciones[0][25];
      					strIdJefe		=	strDatosInstrucciones[0][26];
      					strIdUsuario		=	strDatosInstrucciones[0][27];
      					strIdArea		=	strDatosInstrucciones[0][28];
      					strFechaCambio		=	strDatosInstrucciones[0][29];
      					strHabilitado		=	strDatosInstrucciones[0][30];
      					strBandera		=	strDatosInstrucciones[0][31];
      					strCargo		=	strDatosInstrucciones[0][32];
      					strBandera1		=	strDatosInstrucciones[0][33];
      					strTurno		=	strDatosInstrucciones[0][34];
      			                idUsuarioTurnador       =   strTurno;
      					strUsuarioTermino	=	strDatosInstrucciones[0][37];
      			
      					//**Asistentes Multiples
      					if(BUsuario.getAsistente()||AtenderInstrucciones.getTitular(BUsuario.getIdUsuario())){
      						asistentes =	ActualizaUsuario.getAsistentes(strUsuarioOriginal);
      						if(ActualizaUsuario.esAsistente(BUsuario.getIdUsuario(), asistentes)||AtenderInstrucciones.getTitular(BUsuario.getIdUsuario())){
      							strIdUsuarioAsistente = AtenderInstrucciones.getTitular(BUsuario.getIdUsuario())?AtenderInstrucciones.getMyAsistente(BUsuario.getIdUsuario()):BUsuario.getIdUsuario();
      							bAsistente = true;
      						}
      			           bAsistente = Jefe.esAsistenteDe(BUsuario.getIdUsuario(),strUsuarioOriginal);
      			        }
      					//if(strIdAsistente.equals(BUsuario.getIdUsuario())){
      					//	strIdUsuarioAsistente = BUsuario.getIdUsuario();
      					//}
      					if(strTipoAtencion.equals("0")){
      						strAtencion = "Ejecutor";
      					}
      					else if(strTipoAtencion.equals("1") && strEstatus.equals("1") && 
      							(strUsuarioOriginal.equals(BUsuario.getIdUsuario()) || //strIdUsuarioAsistente.equals(strIdAsistente)
      							bAsistente)){
      						strAtencion = "Informativo";
      						//String serverMail = application.getAttribute("app.siga.serverMail").toString();
      						//String portServer = application.getInitParameter("PortMail");
      						//String serverName = application.getInitParameter("servername");
      						//BeanInformativas bInformativa = new BeanInformativas();
      						//bInformativa.instruccionesInformativas(	strIdAsunto, strIdInstruccion, strFechaCreacion, 
      						//										BUsuario, serverMail, portServer, 
      						//										serverName, strBase);
      						
      						//strEstatus = "2";
      					}else if(strTipoAtencion.equals("1")){
      						strAtencion = "Informativo";
      					}
      					
      					request.setAttribute("delegado",strDelegado);
      					
      			        if(strFechaCambio != null && strFechaCambio.length() > 0)
      						iTieneFechaCambio = 1;
      					else
      						iTieneFechaCambio =	2;
      					
      					String strVigencia[][] = ActualizaInstrucciones.getDelegarActivo(strIdInstruccion);	
      					if(strVigencia.length > 0 && strVigencia != null){
      						esDelegado = "si";
      					}else{
      						esDelegado = "no";
      					}
      					
      					if(strAcceso.equals("0"))
      						strVerDocto = "No";
      					else
      						strVerDocto = "Si";
      					
      					//** Verifica si del query trae el ID de la instrucción
      					//** ó otra instrucción 
      					if(strInstruccion.length() == 0)
      						strNombreInstruccion = strInstruccionOtro;
      					else
      						strNombreInstruccion = ActualizaInst.getNombreInstruccion1(strInstruccion);
      			
      					bHistorial	=	ActualizaHistorial.TieneHistorial(strIdInstruccion);
      			        request.setAttribute("existeHistorial",Boolean.valueOf(bHistorial));
      					
      					bTieneTramite = ActualizaAsunto.getTieneTramite(strIdAsunto);
        		}
      	}
      
      	boolean bValidaEstatus = false;
      	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
      	if (strIdInstruccion!=null && !strIdInstruccion.equals("")){
      		if (strEstValidacion.equals("")){
      			strEstValidacion = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
      		}
      		String strEstatusValida = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
      		if (!strEstatusValida.equals(strEstValidacion)){ 
      			bValidaEstatus = true; 
      		}
      	}
      
      	if(!bValidaEstatus && strAccion != null && strAccion.equals("tur")){
      		strIdInstruccion 	=	request.getParameter("id_ins"); 
      		boolean habilitar = ActualizaInstrucciones.actualizaHabilitado(strIdInstruccion, 1, "2");
      //		response.sendRedirect("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"");
              response.sendRedirect("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)+"&retURI2="+Utilerias.codificaPostHTML(retURI2));
      	}
      
      	if(!bValidaEstatus && strBandera.equals("0") && 
      		(strUsuarioOriginal.equals(BUsuario.getIdUsuario()) || //strIdUsuarioAsistente.equals(strIdAsistente)
      		bAsistente)){
      		boolean bBandera = ActualizaInstrucciones.updateBandera(strIdInstruccion);
      	}
      
      	//**Verifica cadena de mando
      	CadenaMando cadena = new CadenaMando(strUsuarioOriginal, BUsuario.getIdUsuario());
      	boolean bCadena = cadena.getEsJefe();
      	//**Fin Verifica cadena de mando
      
      	String[][] strRutaAcceso = ActualizaAsunto.getIdsRutaAcceso(strIdAsunto);
      	boolean bAccesoRutaAtencion = ActualizaAsunto.getAccesoRutaAtencion(BUsuario.getIdUsuario(),strRutaAcceso);
      
      	boolean accesoAsistente = false;
      	if (BUsuario.getAsistente()){
      		String strIdsJefes[][] = ActualizaUsuario.getJefesDeAsistente(BUsuario.getIdUsuario());
      		if (strIdsJefes!=null && strIdsJefes.length>0){
      			for (int i=0; i<strIdsJefes.length; i++){
      				CadenaMando cadenaAsis = new CadenaMando(strUsuarioOriginal, strIdsJefes[i][0]);
      				boolean bCadenaAsis = cadena.getEsJefe();
      				if (bCadenaAsis){
      					accesoAsistente = true;
      				}
      				if(ActualizaAsunto.getAccesoRutaAtencion(strIdsJefes[i][0],strRutaAcceso)){
      					bAccesoRutaAtencion = true; 
      				}
      			}
      		}
      	}
              
              boolean esPropietario = true;
              if((BUsuario.getAtencion()||BUsuario.getAsistente())&&(strEstatus.equals("3")))
                  esPropietario = strTurno.equals(BUsuario.getIdUsuario())||gob.hacienda.cgtic.siga.Usuario.asiste(strTurno,BUsuario.getIdUsuario())||gob.hacienda.cgtic.siga.Usuario.asiste(BUsuario.getIdUsuario(),strTurno)?true:false;
      	
      	if((BUsuario.getIdUsuario().equals(strUsuarioOriginal) ||bAsistente || bCadena)&&esPropietario)
      			BEscritura.setValue(true);
      	else
      			BEscritura.setValue(false);
      
      	if ((BUsuario.getIdUsuario().equals(strUsuarioOriginal) ||bAsistente || bCadena ||BUsuario.getIdUsuario().equals(strTurno) ||ActualizaInstrucciones.getSupervisorEsArea(strUsuarioOriginal, BUsuario.getIdUsuario(), BUsuario.getSupervisor()))&&esPropietario)
      			BEscrituraTur.setValue(true);
      	else
      			BEscrituraTur.setValue(false);
      	
      	if((BUsuario.getIdUsuario().equals(strTurnadoPor) || BUsuario.getIdUsuario().equals(strTurno) ||accesoAsistente || Jefe.esJefeDe(strUsuarioOriginal,BUsuario.getIdUsuario()) || BUsuario.getTurnado())&&esPropietario)
                      BEscritura1.setValue(true);
      	else
                      BEscritura1.setValue(false);
      	
      	if((BUsuario.getIdUsuario().equals(strUsuarioOriginal) ||bAsistente || bCadena ||BUsuario.getIdUsuario().equals(strTurno))&&esPropietario)
      			BEscritura2.setValue(true);
      	else
      			BEscritura2.setValue(false);
      
      	if((BUsuario.getIdUsuario().equals(strUsuarioOriginal) || BUsuario.getIdUsuario().equals(strTurno) ||bCadena || bAsistente)&&esPropietario)
                      BEscrituraAr.setValue(true);
      	else
      		BEscrituraAr.setValue(false);
      
      	//**Verifica si el usuario tiene subordinados
      	//strSubordinado = ActualizaUsuario.getSubalterno(strUsuarioOriginal);
      	strSubordinado = ActualizaUsuario.getSubordinados(strUsuarioOriginal);
      	if(strSubordinado.length!=0)
      		bTieneSubordinados = true;
      	else
      		bTieneSubordinados = false;
      
      	//**Verifica la linea de turnado
      	UsuarioTurnado turnado = new UsuarioTurnado(BUsuario.getIdUsuario(), strUsuarioOriginal, strIdInstruccion);
      	boolean bTurnado = turnado.getEsTurnado();
      	//**Fin Verifica la linea de turnado
      
      	if(!bValidaEstatus && strAccion != null && strAccion.equals("terminarRechazada")){
      		strIdInstruccion 	=	request.getParameter("id_ins"); 
      		Date fechaTerminacionReal=new Date(new java.util.Date().getTime());
                      
                      boolean bHisTerminadoRechazo = false;
                      
                      if(BUsuario.getAsistente())
                          try{
                              bHisTerminadoRechazo=ActualizaHistorial.InsertarRespuesta(strIdInstruccion, strIdAsunto,"Se termino la instruccion Rechazada ",gob.hacienda.cgtic.siga.Usuario.aTitular(BUsuario.getIdUsuario()), "100", "", BUsuario.getCargo()+" / "+BUsuario.getNombre()+" en Nombre de "+gob.hacienda.cgtic.siga.instruccion.Rechazo.aNombre(BUsuario,strIdInstruccion));
                          }catch(Exception e){//System.err.println("InstruccionHija->368: "+e.getMessage()); e.printStackTrace();
                          }
                      else
                          bHisTerminadoRechazo=ActualizaHistorial.InsertarRespuesta(strIdInstruccion, strIdAsunto, "Se termino la instruccion Rechazada ",BUsuario.getIdUsuario(), "100", "", BUsuario.getCargo()+" / "+BUsuario.getNombre());
      		
      		boolean bActualizarAvance	=	ActualizaInstrucciones.avanceInstruccionPadre(strIdInstruccion, "100", 
      											strEstatus, "",fechaTerminacionReal.toString(),BUsuario.getIdUsuario());
      
                  if(strTipoAtencion.equals("0")){
          		//**Calculo Avance General
          		CalculoAvance cAvance = new CalculoAvance();
          		cAvance.calculoAvance(strIdAsunto, strIdInstruccion);
          		//**Fin Calculo Avance General
                  }
                      strEstatus = "4";
      		//response.sendRedirect("PortalTerminado.jsp");
      	}
      
      
      out.write(__oracle_jsp_text[20]);
      
      	if(	strHabilitado.equals("0") && strPadre.length() > 0 && 
      		(//BUsuario.getIdArea().equals(strIdArea) || 
      		BUsuario.getIdUsuario().equals(strIdUsuario) || 
      		//BUsuario.getIdUsuario().equals(strIdAsistente) || 
      		bAsistente ||
      		BUsuario.getIdUsuario().equals(strIdJefe) ||
      		BUsuario.getIdUsuario().equals(strTurnadoPor) ||
      		BUsuario.getIdUsuario().equals(strTurno) || 
      		bTurnado || bCadena || accesoAsistente || 
      		bAccesoRutaAtencion) ||
      		ActualizaInstrucciones.getSupervisorEsArea(strUsuarioOriginal, 
      		BUsuario.getIdUsuario(), BUsuario.getSupervisor()) || BUsuario.getTurnado())
      	{
      		////System.out.println("Pueden ver la instrucción");
      	}else{
      
      out.write(__oracle_jsp_text[21]);
      System.out.println("1.- "+strHabilitado.equals("0")+" 2.- "+strPadre.length()+" "+BUsuario.getIdUsuario().equals(strIdUsuario)+" "+bAsistente +" "+BUsuario.getIdUsuario().equals(strIdJefe) +" "+BUsuario.getIdUsuario().equals(strTurnadoPor) +" "+BUsuario.getIdUsuario().equals(strTurno) +" "+bTurnado +" "+ bCadena +" "+ accesoAsistente +" "+ bAccesoRutaAtencion +" "+ActualizaInstrucciones.getSupervisorEsArea(strUsuarioOriginal,	BUsuario.getIdUsuario(), BUsuario.getSupervisor())+" "+ BUsuario.getTurnado());
      out.write(__oracle_jsp_text[22]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[23]);
       } 
      out.write(__oracle_jsp_text[24]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[25]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[26]);
      out.print(retURI2);
      out.write(__oracle_jsp_text[27]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[28]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[29]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[30]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[31]);
      out.print(strUsuarioOriginal);
      out.write(__oracle_jsp_text[32]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[33]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[34]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[35]);
      out.print(strTurnadoPor);
      out.write(__oracle_jsp_text[36]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[37]);
      out.print(strNombreInstruccion);
      out.write(__oracle_jsp_text[38]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[39]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp));
      out.write(__oracle_jsp_text[40]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(retURI));
      out.write(__oracle_jsp_text[41]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[42]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[43]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[44]);
      out.print(strUsuarioOriginal);
      out.write(__oracle_jsp_text[45]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[46]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML("InstruccionHija.jsp?id_ins="+strIdInstruccion+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)));
      out.write(__oracle_jsp_text[47]);
      out.print(Utilerias.codificaPostHTML(retURI));
      out.write(__oracle_jsp_text[48]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[49]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[50]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[51]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[52]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)));
      out.write(__oracle_jsp_text[53]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(retURI));
      out.write(__oracle_jsp_text[54]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[55]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[56]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[57]);
      out.print(strUsuarioOriginal);
      out.write(__oracle_jsp_text[58]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[59]);
      out.print(strTurno);
      out.write(__oracle_jsp_text[60]);
      out.print(strNombreInstruccion);
      out.write(__oracle_jsp_text[61]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[62]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML("InstruccionHija.jsp?id_ins="+strIdInstruccion+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[63]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[64]);
      out.print(strTurno);
      out.write(__oracle_jsp_text[65]);
      out.print(strNombreInstruccion);
      out.write(__oracle_jsp_text[66]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[67]);
      out.print(Utilerias.codificaPostHTML("InstruccionHija.jsp?id_ins="+strIdInstruccion));
      out.write(__oracle_jsp_text[68]);
      out.print(Utilerias.codificaPostHTML(retURI));
      out.write(__oracle_jsp_text[69]);
      out.print(strFolioRecepcion);
      out.write(__oracle_jsp_text[70]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[71]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[72]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[73]);
      out.print( Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[74]);
      out.print( serverContentManager );
      out.write(__oracle_jsp_text[75]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[76]);
      out.print(strItemType);
      out.write(__oracle_jsp_text[77]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[78]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[79]);
      out.print(strTurno);
      out.write(__oracle_jsp_text[80]);
      out.print(iTieneFechaCambio);
      out.write(__oracle_jsp_text[81]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[82]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML("InstruccionHija.jsp?id_ins="+strIdInstruccion+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[83]);
       if(strActivarCM.equals("si")){ 
      out.write(__oracle_jsp_text[84]);
      out.print( serverContentManager );
      out.write(__oracle_jsp_text[85]);
      out.print(strItemType);
      out.write(__oracle_jsp_text[86]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[87]);
      out.print("SinFilio");
      out.write(__oracle_jsp_text[88]);
      out.print(BUsuario.getNombre());
      out.write(__oracle_jsp_text[89]);
      }else{
      out.write(__oracle_jsp_text[90]);
      out.print(server);
      out.print(strBase);
      out.write(__oracle_jsp_text[91]);
      out.print(strItemType);
      out.write(__oracle_jsp_text[92]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[93]);
      out.print("SinFolio");
      out.write(__oracle_jsp_text[94]);
      out.print(BUsuario.getIdUsuario());
      out.write(__oracle_jsp_text[95]);
      }
      out.write(__oracle_jsp_text[96]);
      out.print( strMostrarHabilitado );
      out.write(__oracle_jsp_text[97]);
      out.print( strIdInstruccion );
      out.write(__oracle_jsp_text[98]);
      out.print(strFolioTurnado);
      out.write(__oracle_jsp_text[99]);
      out.print(retURI);
      out.write(__oracle_jsp_text[100]);
      out.print(retURI2);
      out.write(__oracle_jsp_text[101]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[102]);
       if(strEstatus.equals("1")){ 
      out.write(__oracle_jsp_text[103]);
       }else if(strEstatus.equals("2")){ 
      out.write(__oracle_jsp_text[104]);
       }else if(strEstatus.equals("3")){ 
      out.write(__oracle_jsp_text[105]);
       }else if(strEstatus.equals("4")){ 
      out.write(__oracle_jsp_text[106]);
       } 
      out.write(__oracle_jsp_text[107]);
      out.print(retURI);
      out.write(__oracle_jsp_text[108]);
      if(strTipoAtencion.equals("1")){
      out.write(__oracle_jsp_text[109]);
      if(strEstatus.equals("1") || strEstatus.equals("2")){
      out.write(__oracle_jsp_text[110]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_1=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_1.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[111]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_2=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[112]);
                  out.print(strIdInstruccion);
                  out.write(__oracle_jsp_text[113]);
                  out.print(strIdAsunto);
                  out.write(__oracle_jsp_text[114]);
                  out.print(strEstatus);
                  out.write(__oracle_jsp_text[115]);
                  out.print(strAvance);
                  out.write(__oracle_jsp_text[116]);
                  out.print(strUsuarioOriginal);
                  out.write(__oracle_jsp_text[117]);
                  out.print( strEstValidacion );
                  out.write(__oracle_jsp_text[118]);
                  out.print( com.meve.sigma.util.Utilerias.codificaPostHTML("InstruccionHija.jsp?id_ins="+strIdInstruccion+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
                  out.write(__oracle_jsp_text[119]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[120]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[121]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_3=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_3.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[122]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_4=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_4.setParent(__jsp_taghandler_3);
              __jsp_taghandler_4.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[123]);
                  if(bTieneSubordinados){
                  out.write(__oracle_jsp_text[124]);
                  }
                  out.write(__oracle_jsp_text[125]);
                } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[126]);
          } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[127]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_5=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_5.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[128]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_6=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_6.setParent(__jsp_taghandler_5);
              __jsp_taghandler_6.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraAr.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[129]);
                } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[130]);
          } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[131]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_7=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_7.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[132]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_8=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_8.setParent(__jsp_taghandler_7);
              __jsp_taghandler_8.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[133]);
                } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[134]);
          } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      out.write(__oracle_jsp_text[135]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_9=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_9.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[136]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_10=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_10.setParent(__jsp_taghandler_9);
              __jsp_taghandler_10.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[137]);
                  
                  				float fAvance = new Float(strAvance).floatValue();
                  				if(fAvance==0){
                  				
                  out.write(__oracle_jsp_text[138]);
                  }
                  out.write(__oracle_jsp_text[139]);
                } while (__jsp_taghandler_10.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,2);
            }
            out.write(__oracle_jsp_text[140]);
          } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,1);
      }
      out.write(__oracle_jsp_text[141]);
      }else if(strEstatus.equals("3")){
      out.write(__oracle_jsp_text[142]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_11=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_11.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[143]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_12=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_12.setParent(__jsp_taghandler_11);
              __jsp_taghandler_12.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura1.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[144]);
                  
                  				boolean tiene = false;
                  				/*strSubordinado = ActualizaUsuario.getSubordinados(strUsuarioOriginal);//ActualizaUsuario.getSubalterno(strTurno);
                  				if(strSubordinado.length!=0)
                  					tiene = true;
                  				else
                  					tiene = false;                                */
                  				
                  out.write(__oracle_jsp_text[145]);
                  /*if(Usuario.tieneSubordinados(strUsuarioOriginal)||idUsuarioTurnador.equals(BUsuario.getIdUsuario())){*/
                  out.write(__oracle_jsp_text[146]);
                  /*}*/
                  out.write(__oracle_jsp_text[147]);
                  /* if(!strTipoAtencion.equals("1")){ */
                  out.write(__oracle_jsp_text[148]);
                   /*}*/ 
                  out.write(__oracle_jsp_text[149]);
                } while (__jsp_taghandler_12.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
            }
            out.write(__oracle_jsp_text[150]);
          } while (__jsp_taghandler_11.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,1);
      }
      out.write(__oracle_jsp_text[151]);
      }else{
      out.write(__oracle_jsp_text[152]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_13=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_13.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[153]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_14=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_14.setParent(__jsp_taghandler_13);
              __jsp_taghandler_14.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[154]);
                } while (__jsp_taghandler_14.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,2);
            }
            out.write(__oracle_jsp_text[155]);
          } while (__jsp_taghandler_13.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,1);
      }
      out.write(__oracle_jsp_text[156]);
      }
      out.write(__oracle_jsp_text[157]);
      }else{
      out.write(__oracle_jsp_text[158]);
       if(strEstatus.equals("1")){ 
      out.write(__oracle_jsp_text[159]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_15=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_15.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[160]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_16=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_16.setParent(__jsp_taghandler_15);
              __jsp_taghandler_16.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[161]);
                  out.print(strIdInstruccion);
                  out.write(__oracle_jsp_text[162]);
                  out.print(strIdAsunto);
                  out.write(__oracle_jsp_text[163]);
                  out.print(strEstatus);
                  out.write(__oracle_jsp_text[164]);
                  out.print(strAvance);
                  out.write(__oracle_jsp_text[165]);
                  out.print(strUsuarioOriginal);
                  out.write(__oracle_jsp_text[166]);
                  out.print( strEstValidacion );
                  out.write(__oracle_jsp_text[167]);
                  out.print( com.meve.sigma.util.Utilerias.codificaPostHTML("InstruccionHija.jsp?id_ins="+strIdInstruccion+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
                  out.write(__oracle_jsp_text[168]);
                } while (__jsp_taghandler_16.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,2);
            }
            out.write(__oracle_jsp_text[169]);
          } while (__jsp_taghandler_15.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,1);
      }
      out.write(__oracle_jsp_text[170]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_17=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_17.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[171]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_18=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_18.setParent(__jsp_taghandler_17);
              __jsp_taghandler_18.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[172]);
                  if(bTieneSubordinados){
                  out.write(__oracle_jsp_text[173]);
                  }
                  out.write(__oracle_jsp_text[174]);
                } while (__jsp_taghandler_18.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,2);
            }
            out.write(__oracle_jsp_text[175]);
          } while (__jsp_taghandler_17.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,1);
      }
      out.write(__oracle_jsp_text[176]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_19=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_19.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[177]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_20=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_20.setParent(__jsp_taghandler_19);
              __jsp_taghandler_20.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[178]);
                  if(Usuario.tieneSubordinados(strUsuarioOriginal)){//&& ActualizaInstrucciones.getSupervisorEsArea(strUsuarioOriginal,BUsuario.getIdUsuario(), BUsuario.getSupervisor()))){
                  out.write(__oracle_jsp_text[179]);
                  /*if(bTieneSubordinados && !strTurno.equals(BUsuario.getIdUsuario())){*/
                  out.write(__oracle_jsp_text[180]);
                  }
                  out.write(__oracle_jsp_text[181]);
                } while (__jsp_taghandler_20.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,2);
            }
            out.write(__oracle_jsp_text[182]);
          } while (__jsp_taghandler_19.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,1);
      }
      out.write(__oracle_jsp_text[183]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_21=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_21.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[184]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_22=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_22.setParent(__jsp_taghandler_21);
              __jsp_taghandler_22.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[185]);
                } while (__jsp_taghandler_22.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,2);
            }
            out.write(__oracle_jsp_text[186]);
          } while (__jsp_taghandler_21.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,1);
      }
      out.write(__oracle_jsp_text[187]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_23=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_23.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[188]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_24=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_24.setParent(__jsp_taghandler_23);
              __jsp_taghandler_24.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraAr.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[189]);
                } while (__jsp_taghandler_24.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,2);
            }
            out.write(__oracle_jsp_text[190]);
          } while (__jsp_taghandler_23.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,1);
      }
      out.write(__oracle_jsp_text[191]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_25=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_25.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[192]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_26=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_26.setParent(__jsp_taghandler_25);
              __jsp_taghandler_26.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura2.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[193]);
                   if(!bTieneTramite && iTieneFechaCambio == 2){ 
                  out.write(__oracle_jsp_text[194]);
                   }else if(!bTieneTramite && iTieneFechaCambio == 1){ 
                  out.write(__oracle_jsp_text[195]);
                   } 
                  out.write(__oracle_jsp_text[196]);
                } while (__jsp_taghandler_26.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,2);
            }
            out.write(__oracle_jsp_text[197]);
          } while (__jsp_taghandler_25.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,1);
      }
      out.write(__oracle_jsp_text[198]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_27=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_27.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[199]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_28=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_28.setParent(__jsp_taghandler_27);
              __jsp_taghandler_28.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[200]);
                } while (__jsp_taghandler_28.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,2);
            }
            out.write(__oracle_jsp_text[201]);
          } while (__jsp_taghandler_27.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,1);
      }
      out.write(__oracle_jsp_text[202]);
       }else if(strEstatus.equals("2") && strDelegado.length() == 0){ 
      out.write(__oracle_jsp_text[203]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_29=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_29.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[204]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_30=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_30.setParent(__jsp_taghandler_29);
              __jsp_taghandler_30.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_30.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[205]);
                  out.print(strIdInstruccion);
                  out.write(__oracle_jsp_text[206]);
                  out.print(strIdAsunto);
                  out.write(__oracle_jsp_text[207]);
                  out.print(strEstatus);
                  out.write(__oracle_jsp_text[208]);
                  out.print(strAvance);
                  out.write(__oracle_jsp_text[209]);
                  out.print(strUsuarioOriginal);
                  out.write(__oracle_jsp_text[210]);
                  out.print( strEstValidacion );
                  out.write(__oracle_jsp_text[211]);
                  out.print( com.meve.sigma.util.Utilerias.codificaPostHTML("InstruccionHija.jsp?id_ins="+strIdInstruccion+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
                  out.write(__oracle_jsp_text[212]);
                } while (__jsp_taghandler_30.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_30.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_30,2);
            }
            out.write(__oracle_jsp_text[213]);
          } while (__jsp_taghandler_29.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,1);
      }
      out.write(__oracle_jsp_text[214]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_31=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_31.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_31.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[215]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_32=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_32.setParent(__jsp_taghandler_31);
              __jsp_taghandler_32.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_32.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[216]);
                  if(bTieneSubordinados){
                  out.write(__oracle_jsp_text[217]);
                  }
                  out.write(__oracle_jsp_text[218]);
                } while (__jsp_taghandler_32.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_32.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_32,2);
            }
            out.write(__oracle_jsp_text[219]);
          } while (__jsp_taghandler_31.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_31.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_31,1);
      }
      out.write(__oracle_jsp_text[220]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_33=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_33.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_33.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[221]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_34=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_34.setParent(__jsp_taghandler_33);
              __jsp_taghandler_34.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_34.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[222]);
                  if(bTieneSubordinados && !strTurno.equals(BUsuario.getIdUsuario())){
                  out.write(__oracle_jsp_text[223]);
                  }else{
                  out.write(__oracle_jsp_text[224]);
                  if((strTurno.equals(BUsuario.getIdUsuario()) || 
                  					ActualizaInstrucciones.getSupervisorEsArea(strUsuarioOriginal, 
                  					BUsuario.getIdUsuario(), BUsuario.getSupervisor()))&&(bTieneSubordinados)){
                  out.write(__oracle_jsp_text[225]);
                  }
                  out.write(__oracle_jsp_text[226]);
                  }
                  out.write(__oracle_jsp_text[227]);
                } while (__jsp_taghandler_34.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_34.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_34,2);
            }
            out.write(__oracle_jsp_text[228]);
          } while (__jsp_taghandler_33.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_33.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_33,1);
      }
      out.write(__oracle_jsp_text[229]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_35=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_35.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_35.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[230]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_36=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_36.setParent(__jsp_taghandler_35);
              __jsp_taghandler_36.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraAr.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_36.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[231]);
                } while (__jsp_taghandler_36.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_36.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_36,2);
            }
            out.write(__oracle_jsp_text[232]);
          } while (__jsp_taghandler_35.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_35.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_35,1);
      }
      out.write(__oracle_jsp_text[233]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_37=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_37.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_37.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[234]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_38=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_38.setParent(__jsp_taghandler_37);
              __jsp_taghandler_38.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura2.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_38.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[235]);
                   if(!bTieneTramite && iTieneFechaCambio == 2){ 
                  out.write(__oracle_jsp_text[236]);
                   }else if(!bTieneTramite && iTieneFechaCambio == 1){ 
                  out.write(__oracle_jsp_text[237]);
                   } 
                  out.write(__oracle_jsp_text[238]);
                } while (__jsp_taghandler_38.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_38.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_38,2);
            }
            out.write(__oracle_jsp_text[239]);
          } while (__jsp_taghandler_37.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_37.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_37,1);
      }
      out.write(__oracle_jsp_text[240]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_39=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_39.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_39.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[241]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_40=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_40.setParent(__jsp_taghandler_39);
              __jsp_taghandler_40.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_40.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[242]);
                } while (__jsp_taghandler_40.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_40.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_40,2);
            }
            out.write(__oracle_jsp_text[243]);
          } while (__jsp_taghandler_39.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_39.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_39,1);
      }
      out.write(__oracle_jsp_text[244]);
       }else if(strEstatus.equals("3")){ 
      out.write(__oracle_jsp_text[245]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_41=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_41.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_41.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[246]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_42=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_42.setParent(__jsp_taghandler_41);
              __jsp_taghandler_42.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura1.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_42.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[247]);
                  boolean tiene = ActualizaUsuario.getSubordinados(strUsuarioOriginal).length>0?true:false;
                  out.write(__oracle_jsp_text[248]);
                  if(tiene||idUsuarioTurnador.equals(BUsuario.getIdUsuario())||AtenderInstrucciones.equalsAsis(idUsuarioTurnador,BUsuario.getIdUsuario()) || Jefe.esJefeDe(idUsuarioTurnador,BUsuario.getIdUsuario())||BUsuario.getTurnado()){
                  out.write(__oracle_jsp_text[249]);
                  }
                  out.write(__oracle_jsp_text[250]);
                   if(!strTipoAtencion.equals("1")){ 
                  out.write(__oracle_jsp_text[251]);
                   } 
                  out.write(__oracle_jsp_text[252]);
                } while (__jsp_taghandler_42.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_42.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_42,2);
            }
            out.write(__oracle_jsp_text[253]);
          } while (__jsp_taghandler_41.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_41.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_41,1);
      }
      out.write(__oracle_jsp_text[254]);
       }else if(strEstatus.equals("4")){ 
      out.write(__oracle_jsp_text[255]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_43=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_43.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_43.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[256]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_44=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_44.setParent(__jsp_taghandler_43);
              __jsp_taghandler_44.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_44.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[257]);
                } while (__jsp_taghandler_44.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_44.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_44,2);
            }
            out.write(__oracle_jsp_text[258]);
          } while (__jsp_taghandler_43.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_43.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_43,1);
      }
      out.write(__oracle_jsp_text[259]);
       }else if(strEstatus.equals("2") && strDelegado.length() > 0){ 
      out.write(__oracle_jsp_text[260]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_45=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_45.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_45.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[261]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_46=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_46.setParent(__jsp_taghandler_45);
              __jsp_taghandler_46.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_46.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[262]);
                  out.print(strIdInstruccion);
                  out.write(__oracle_jsp_text[263]);
                  out.print(strIdAsunto);
                  out.write(__oracle_jsp_text[264]);
                  out.print(strEstatus);
                  out.write(__oracle_jsp_text[265]);
                  out.print(strAvance);
                  out.write(__oracle_jsp_text[266]);
                  out.print(strUsuarioOriginal);
                  out.write(__oracle_jsp_text[267]);
                  out.print( strEstValidacion );
                  out.write(__oracle_jsp_text[268]);
                  out.print( com.meve.sigma.util.Utilerias.codificaPostHTML("InstruccionHija.jsp?id_ins="+strIdInstruccion+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
                  out.write(__oracle_jsp_text[269]);
                } while (__jsp_taghandler_46.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_46.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_46,2);
            }
            out.write(__oracle_jsp_text[270]);
          } while (__jsp_taghandler_45.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_45.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_45,1);
      }
      out.write(__oracle_jsp_text[271]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_47=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_47.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_47.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[272]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_48=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_48.setParent(__jsp_taghandler_47);
              __jsp_taghandler_48.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_48.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[273]);
                } while (__jsp_taghandler_48.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_48.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_48,2);
            }
            out.write(__oracle_jsp_text[274]);
          } while (__jsp_taghandler_47.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_47.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_47,1);
      }
      out.write(__oracle_jsp_text[275]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_49=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_49.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_49.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[276]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_50=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_50.setParent(__jsp_taghandler_49);
              __jsp_taghandler_50.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_50.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[277]);
                } while (__jsp_taghandler_50.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_50.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_50,2);
            }
            out.write(__oracle_jsp_text[278]);
          } while (__jsp_taghandler_49.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_49.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_49,1);
      }
      out.write(__oracle_jsp_text[279]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_51=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_51.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_51.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[280]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_52=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_52.setParent(__jsp_taghandler_51);
              __jsp_taghandler_52.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraAr.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_52.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[281]);
                } while (__jsp_taghandler_52.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_52.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_52,2);
            }
            out.write(__oracle_jsp_text[282]);
          } while (__jsp_taghandler_51.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_51.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_51,1);
      }
      out.write(__oracle_jsp_text[283]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_53=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_53.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_53.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[284]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_54=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_54.setParent(__jsp_taghandler_53);
              __jsp_taghandler_54.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura2.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_54.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[285]);
                   if (!bTieneTramite ){ 
                  out.write(__oracle_jsp_text[286]);
                   } 
                  out.write(__oracle_jsp_text[287]);
                } while (__jsp_taghandler_54.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_54.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_54,2);
            }
            out.write(__oracle_jsp_text[288]);
          } while (__jsp_taghandler_53.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_53.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_53,1);
      }
      out.write(__oracle_jsp_text[289]);
       } 
      out.write(__oracle_jsp_text[290]);
       } 
      out.write(__oracle_jsp_text[291]);
      if(iTieneFechaCambio==1){
      out.write(__oracle_jsp_text[292]);
      }
      out.write(__oracle_jsp_text[293]);
      out.print( strFolioTurnado );
      out.write(__oracle_jsp_text[294]);
      if(!strBandera1.equals("1") && strEstatus.equals("3")) {
      out.write(__oracle_jsp_text[295]);
      out.print(ActualizaHistorial.getUsuarioRechazo(strIdInstruccion)[0][0]);
      out.write(__oracle_jsp_text[296]);
      }else if(strUsuarioTermino.length()==0){
      out.write(__oracle_jsp_text[297]);
      out.print(strCargo);
      out.write(__oracle_jsp_text[298]);
      }else{
      out.write(__oracle_jsp_text[299]);
      out.print(strUsuarioTermino);
      out.write(__oracle_jsp_text[300]);
      }
      out.write(__oracle_jsp_text[301]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[302]);
      out.print(strTelefono);
      out.write(__oracle_jsp_text[303]);
      out.print(strCorreo);
      out.write(__oracle_jsp_text[304]);
      out.print( strAtencion );
      out.write(__oracle_jsp_text[305]);
      out.print(strAtencion);
      out.write(__oracle_jsp_text[306]);
      out.print( strVerDocto );
      out.write(__oracle_jsp_text[307]);
      out.print(strVerDocto);
      out.write(__oracle_jsp_text[308]);
       if(strAcceso.equals("1")){ 
      out.write(__oracle_jsp_text[309]);
      out.print( strPadre );
      out.write(__oracle_jsp_text[310]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[311]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[312]);
       } 
      out.write(__oracle_jsp_text[313]);
      out.print( strAsunto );
      out.write(__oracle_jsp_text[314]);
      out.print(strAsunto);
      out.write(__oracle_jsp_text[315]);
      out.print(strPaso);
      out.write(__oracle_jsp_text[316]);
      out.print(strFecGeneracion);
      out.write(__oracle_jsp_text[317]);
      out.print(strFecGeneracion);
      out.write(__oracle_jsp_text[318]);
      out.print(strFecVencimiento);
      out.write(__oracle_jsp_text[319]);
      out.print(strFecVencimiento);
      out.write(__oracle_jsp_text[320]);
       if(strEstatus.equals("1")){
      out.write(__oracle_jsp_text[321]);
      }else if(strEstatus.equals("2")){
      out.write(__oracle_jsp_text[322]);
      }else if(strEstatus.equals("3")){
      out.write(__oracle_jsp_text[323]);
      }else if(strEstatus.equals("4")){
      out.write(__oracle_jsp_text[324]);
      }
      out.write(__oracle_jsp_text[325]);
       if(strDelegado.length() != 0){ 
      out.write(__oracle_jsp_text[326]);
       String delegadoA=ActualizaUsuario.NombreUsuario(strDelegado);
      out.write(__oracle_jsp_text[327]);
      out.print(delegadoA);
      out.write(__oracle_jsp_text[328]);
      out.print(delegadoA);
      out.write(__oracle_jsp_text[329]);
       }else{ 
      out.write(__oracle_jsp_text[330]);
       } 
      out.write(__oracle_jsp_text[331]);
      String turnadoPor=ActualizaUsuario.NombreUsuario(strTurno);
      out.print(turnadoPor);
      out.write(__oracle_jsp_text[332]);
      out.print(turnadoPor);
      out.write(__oracle_jsp_text[333]);
      out.print( strFolioRecepcion );
      out.write(__oracle_jsp_text[334]);
      out.print(strFolioRecepcion);
      out.write(__oracle_jsp_text[335]);
      out.print( strFolioIntermedio );
      out.write(__oracle_jsp_text[336]);
      out.print(strFolioIntermedio);
      out.write(__oracle_jsp_text[337]);
      out.print( strNombreInstruccion );
      out.write(__oracle_jsp_text[338]);
      out.print(strNombreInstruccion);
      out.write(__oracle_jsp_text[339]);
      out.print( strSintesis );
      out.write(__oracle_jsp_text[340]);
      out.print(strSintesis);
      out.write(__oracle_jsp_text[341]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[342]);
       if(bHistorial){ 
      out.write(__oracle_jsp_text[343]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_55=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_55.setParent(null);
        __jsp_taghandler_55.setDatos(ActualizaHistorial.getHistorialInstruccion(strIdInstruccion));
        __jsp_taghandler_55.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_55.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_55,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[344]);
             if("1".equals(campo7)){ 
            out.write(__oracle_jsp_text[345]);
            out.print(campo3 );
            out.write(__oracle_jsp_text[346]);
            String avanceUsuario=campo8;
            out.write(__oracle_jsp_text[347]);
             if(campo6.equals("Actualización de la instruccion Padre")){ 
            out.write(__oracle_jsp_text[348]);
             }else{ 
            out.write(__oracle_jsp_text[349]);
            out.print( (campo8.indexOf(" / ")!=-1)?campo8:campo8+" / "+ActualizaUsuario.NombrePuesto(campo4) );
            out.write(__oracle_jsp_text[350]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[351]);
            out.print( strEstValidacion );
            out.write(__oracle_jsp_text[352]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML("InstruccionHija.jsp?id_ins="+strIdInstruccion+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[353]);
            out.print( campo5 );
            out.write(__oracle_jsp_text[354]);
            out.print(campo5);
            out.write(__oracle_jsp_text[355]);
             } 
            out.write(__oracle_jsp_text[356]);
             }else if(campo7.equals("2")){ 
            out.write(__oracle_jsp_text[357]);
            out.print(campo3);
            out.write(__oracle_jsp_text[358]);
            out.print( (campo8.indexOf(" / ")!=-1)?campo8:campo8+" / "+ActualizaUsuario.NombrePuesto(campo4) );
            out.write(__oracle_jsp_text[359]);
            out.print( campo6 );
            out.write(__oracle_jsp_text[360]);
             }else if(campo7.equals("3")){ 
            out.write(__oracle_jsp_text[361]);
            out.print(campo3);
            out.write(__oracle_jsp_text[362]);
            out.print( ActualizaInstrucciones.NombreUsuarioInstruccion(strIdInstruccion) );
            out.write(__oracle_jsp_text[363]);
            out.print( (campo8.indexOf(" / ")!=-1)?campo8:campo8+" / "+ActualizaUsuario.NombrePuesto(campo4) );
            out.write(__oracle_jsp_text[364]);
            out.print( campo6 );
            out.write(__oracle_jsp_text[365]);
             }else if(campo7.equals("4")){ 
            out.write(__oracle_jsp_text[366]);
            out.print(campo3);
            out.write(__oracle_jsp_text[367]);
            out.print(ActualizaUsuario.NombreUsuario(strDelegado));
            out.write(__oracle_jsp_text[368]);
            out.print( campo6 );
            out.write(__oracle_jsp_text[369]);
             } else if(campo7.equals("5")){
            out.write(__oracle_jsp_text[370]);
            out.print(campo3);
            out.write(__oracle_jsp_text[371]);
            out.print( (campo8.indexOf(" / ")!=-1)?campo8:campo8+" / "+ActualizaUsuario.NombrePuesto(campo4) );
            out.write(__oracle_jsp_text[372]);
             } else if(campo7.equals("6")){
            out.write(__oracle_jsp_text[373]);
            out.print(campo3);
            out.write(__oracle_jsp_text[374]);
            out.print(campo8);
            out.write(__oracle_jsp_text[375]);
            out.print(com.meve.sigma.util.Utilerias.cambioSaltosDeLinea(campo6));
            out.write(__oracle_jsp_text[376]);
            } else if(campo7.equals("7")){
            out.write(__oracle_jsp_text[377]);
            out.print(campo3);
            out.write(__oracle_jsp_text[378]);
            out.print(campo8);
            out.write(__oracle_jsp_text[379]);
            out.print(ActualizaUsuario.NombrePuesto(campo4));
            out.write(__oracle_jsp_text[380]);
            out.print(campo9);
            out.write(__oracle_jsp_text[381]);
            out.print(com.meve.sigma.util.Utilerias.cambioSaltosDeLinea(campo6));
            out.write(__oracle_jsp_text[382]);
            } else if(campo7.equals("8")){
            out.write(__oracle_jsp_text[383]);
            out.print(campo3);
            out.write(__oracle_jsp_text[384]);
            out.print(campo8);
            out.write(__oracle_jsp_text[385]);
            out.print(ActualizaUsuario.NombrePuesto(campo4));
            out.write(__oracle_jsp_text[386]);
            out.print(campo9);
            out.write(__oracle_jsp_text[387]);
            out.print(com.meve.sigma.util.Utilerias.cambioSaltosDeLinea(campo6));
            out.write(__oracle_jsp_text[388]);
            } else if(campo7.equals("9")){
            out.write(__oracle_jsp_text[389]);
            out.print(campo3);
            out.write(__oracle_jsp_text[390]);
            out.print(campo8);
            out.write(__oracle_jsp_text[391]);
            out.print(ActualizaUsuario.NombrePuesto(campo4));
            out.write(__oracle_jsp_text[392]);
            out.print(campo9);
            out.write(__oracle_jsp_text[393]);
            out.print(com.meve.sigma.util.Utilerias.cambioSaltosDeLinea(campo6));
            out.write(__oracle_jsp_text[394]);
            }
            out.write(__oracle_jsp_text[395]);
          } while (__jsp_taghandler_55.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_55.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_55,1);
      }
      out.write(__oracle_jsp_text[396]);
       }else{ 
      out.write(__oracle_jsp_text[397]);
       } 
      out.write(__oracle_jsp_text[398]);
       if(BUsuario.getIdUsuario().equals(strUsuarioOriginal) || bAsistente/*BUsuario.getIdUsuario().equals(strIdAsistente)*/){ 
      out.write(__oracle_jsp_text[399]);
       if(strActivarCM.equals("si")){ 
      out.write(__oracle_jsp_text[400]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[401]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[402]);
      out.print(strFolioRecepcion );
      out.write(__oracle_jsp_text[403]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[404]);
       }else{ 
      out.write(__oracle_jsp_text[405]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[406]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[407]);
      out.print(strFolioRecepcion );
      out.write(__oracle_jsp_text[408]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[409]);
       } 
      out.write(__oracle_jsp_text[410]);
       }else{ 
      out.write(__oracle_jsp_text[411]);
       if(strActivarCM.equals("no")){ 
      out.write(__oracle_jsp_text[412]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[413]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[414]);
      out.print(strFolioRecepcion );
      out.write(__oracle_jsp_text[415]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[416]);
       }else{ 
      out.write(__oracle_jsp_text[417]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[418]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[419]);
      out.print(strFolioRecepcion );
      out.write(__oracle_jsp_text[420]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[421]);
       } 
      out.write(__oracle_jsp_text[422]);
       } 
      out.write(__oracle_jsp_text[423]);
       
      		boolean firmado = strFirmaDigital.equals("1");
      		if(firmado){
      	
      out.write(__oracle_jsp_text[424]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[425]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[426]);
      out.print(strFechaTerminacionReal);
      out.write(__oracle_jsp_text[427]);
      out.print(strFechaTerminacionReal);
      out.write(__oracle_jsp_text[428]);
      
       }
          
      
            
      
      out.write(__oracle_jsp_text[429]);
      out.print( bValidaEstatus );
      out.write(__oracle_jsp_text[430]);

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
  private static final char __oracle_jsp_text[][]=new char[431][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
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
    "\n<!-- <MEVE CORTE: 20071130>-->\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n<!-- </MEVE CORTE>         -->\n<HTML>  \n<HEAD> \n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n  \t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n".toCharArray();
    __oracle_jsp_text[21] = 
    "\n".toCharArray();
    __oracle_jsp_text[22] = 
    "\n".toCharArray();
    __oracle_jsp_text[23] = 
    "\n".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>instrucción</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n\n   \t//function imprimir(){\n    //     var url='ImprimeInstruccionTerminada.jsp?idInstruccion='+".toCharArray();
    __oracle_jsp_text[25] = 
    ";\n    //     var ventanaImpresion=window.open(url,'','',true);\n\t//}\n\n\tvar botonBandera = true;\n\n\tfunction imprimir(){\n\t\tvar isCenter ='true';\n\t\tvar features = '';\n\n\t\tif(window.screen)if(isCenter)if(isCenter==\"true\"){\n\t\t    var myLeft = (screen.width-800)/2;\n\t\t    var myTop = (screen.height-600)/2;\n\t\t    features+=(features!='')?',':'';\n\t\t    features+=',left='+myLeft+',top='+myTop; \n\t\t}\n\t\twindow.open(\"../ReporteInstruccion?id=\"+".toCharArray();
    __oracle_jsp_text[26] = 
    ", \"\", features+((features!='')?',':'')+'width=800, height=600 , resizable=yes');\n\t}\n\tfunction Regresar(){\n\t\tlocation.assign('".toCharArray();
    __oracle_jsp_text[27] = 
    "');\t\t \n\t}\n\tfunction Responder(){\n\t\tlocation.assign('Responder.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[28] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[29] = 
    "&id_es=".toCharArray();
    __oracle_jsp_text[30] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[31] = 
    "&us_or=".toCharArray();
    __oracle_jsp_text[32] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[33] = 
    "');\n\t}\n\tfunction Rechazar(){\n\t\tlocation.assign('Rechazar.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[34] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[35] = 
    "&tur=".toCharArray();
    __oracle_jsp_text[36] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[37] = 
    "&ins=".toCharArray();
    __oracle_jsp_text[38] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[39] = 
    "&retURI1=".toCharArray();
    __oracle_jsp_text[40] = 
    "&retURI2=".toCharArray();
    __oracle_jsp_text[41] = 
    "');\n\t}\n\tfunction Reasignar(){\n\t\tlocation.assign('Reasignar.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[42] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[43] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[44] = 
    "&usr_ori=".toCharArray();
    __oracle_jsp_text[45] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[46] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[47] = 
    "&retURI2=".toCharArray();
    __oracle_jsp_text[48] = 
    "');\n\t}\n\tfunction ReasignarRechazar(){\n\t\tlocation.assign('ReasignarRechazo.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[49] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[50] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[51] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[52] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[53] = 
    "&retURI2=".toCharArray();
    __oracle_jsp_text[54] = 
    "');\n\t}\n\tfunction Delegar(){\n\t\tlocation.assign('Delegar.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[55] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[56] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[57] = 
    "&usr_ori=".toCharArray();
    __oracle_jsp_text[58] = 
    "');\n\t}\n\tfunction Turnar(){\n\t\tdoc = document.Ihijas;\n\t\tdoc.turnar.value=\"tur\";\n\t\tdoc.submit();\n\t}\n\tfunction TerminarRechazada(){\n\t\tdoc = document.Ihijas;\n\t\tdoc.accion.value=\"terminarRechazada\";\n\t\tdoc.submit();\n\t}\n\tfunction firmar(){\n\t\tlocation.assign('http://192.168.0.144:8080/firma/explorer_applet.html');\n\t}\n   \tfunction agregarComentario(){\n            //location.assign('AgregarComentarioInstruccion.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[59] = 
    "&tur=".toCharArray();
    __oracle_jsp_text[60] = 
    "&ins=".toCharArray();
    __oracle_jsp_text[61] = 
    "&a=3&estValidacion=".toCharArray();
    __oracle_jsp_text[62] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[63] = 
    "');\n            location.assign('AgregarComentarioInstruccion.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[64] = 
    "&tur=".toCharArray();
    __oracle_jsp_text[65] = 
    "&ins=".toCharArray();
    __oracle_jsp_text[66] = 
    "&a=3&estValidacion=".toCharArray();
    __oracle_jsp_text[67] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[68] = 
    "&retURI2=".toCharArray();
    __oracle_jsp_text[69] = 
    "');\n\t}\n\tfunction agregarContent() {\n\t\tlocation.assign('ImportarCM.jsp?Folio=".toCharArray();
    __oracle_jsp_text[70] = 
    "&IdAsunto=".toCharArray();
    __oracle_jsp_text[71] = 
    "&a=5&id_ins=".toCharArray();
    __oracle_jsp_text[72] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[73] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[74] = 
    "');\n\t}\n\tfunction agregar()\n\t{\n\t\tvar frameNvaRef = '".toCharArray();
    __oracle_jsp_text[75] = 
    "/eclient/SIGMA/Avance.jsp?id=".toCharArray();
    __oracle_jsp_text[76] = 
    "&bo=true&it=".toCharArray();
    __oracle_jsp_text[77] = 
    "';\n\t\tdocument.getElementById('frame1').src  = frameNvaRef;\t\t\n\t}\n\tfunction cambioFecha(){\n\t\tlocation.assign('CambioFechaInst.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[78] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[79] = 
    "&tur=".toCharArray();
    __oracle_jsp_text[80] = 
    "&i=".toCharArray();
    __oracle_jsp_text[81] = 
    "&re=2&estValidacion=".toCharArray();
    __oracle_jsp_text[82] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[83] = 
    "');\n\t}\n\tfunction escaner(){\n\t\t".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\t\tlocation.assign('sigmaCM:%20".toCharArray();
    __oracle_jsp_text[85] = 
    "/eclient/ArchivoCM%20".toCharArray();
    __oracle_jsp_text[86] = 
    "%20escanear%20false%20".toCharArray();
    __oracle_jsp_text[87] = 
    "%20".toCharArray();
    __oracle_jsp_text[88] = 
    "%20".toCharArray();
    __oracle_jsp_text[89] = 
    "');\n\t\t".toCharArray();
    __oracle_jsp_text[90] = 
    "\n\t\tlocation.assign('sigmaCM:%20".toCharArray();
    __oracle_jsp_text[91] = 
    "/ArchivoCM%20".toCharArray();
    __oracle_jsp_text[92] = 
    "%20escanear%20true%20".toCharArray();
    __oracle_jsp_text[93] = 
    "%20".toCharArray();
    __oracle_jsp_text[94] = 
    "%20".toCharArray();
    __oracle_jsp_text[95] = 
    "');\n\t\t".toCharArray();
    __oracle_jsp_text[96] = 
    "\n\t}\n\t\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"timer_load();\" onclick=\"timer_reload();\" onkeypress=\"timer_reload();\">\n<FORM action=\"InstruccionHija.jsp\" name=\"Ihijas\" method=\"post\">\n    <INPUT name=\"turnar\"        value=\"".toCharArray();
    __oracle_jsp_text[97] = 
    "\" type=\"hidden\"> \n    <INPUT name=\"id_ins\"        value=\"".toCharArray();
    __oracle_jsp_text[98] = 
    "\"     type=\"hidden\"> \n    <INPUT name=\"folioHdn\"      value=\"".toCharArray();
    __oracle_jsp_text[99] = 
    "\"        type=\"hidden\"> \n    <INPUT name=\"accion\"        value=\"tur\"                         type=\"hidden\">\n    <INPUT name=\"retURI\"        value=\"".toCharArray();
    __oracle_jsp_text[100] = 
    "\"                 type=\"hidden\">\n    <INPUT name=\"retURI2\"        value=\"".toCharArray();
    __oracle_jsp_text[101] = 
    "\"                 type=\"hidden\">\n    <INPUT name=\"estValidacion\" value=\"".toCharArray();
    __oracle_jsp_text[102] = 
    "\"       type=\"hidden\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"99%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"863\">".toCharArray();
    __oracle_jsp_text[103] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\" face=\"Verdana\">instrucción\n\t\tPor Atender</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\" face=\"Verdana\">instrucción\n\t\tEn Trámite</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[105] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\" face=\"Verdana\">instrucción\n\t\tRechazada</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[106] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\" face=\"Verdana\">instrucción\n\t\tTerminada</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[107] = 
    "</td>\n\t</tr>\n</table>\n</DIV>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"863\"><tr><td>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"60\">\n\t\t\t<!-- <input type=\"button\" onclick=\"Regresar()\" value=\"Regresar\" class=\"blue100\"> -->\n\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; location.assign('".toCharArray();
    __oracle_jsp_text[108] = 
    "');}\" onMouseOver=\"document.MyImage.src='../Imagenes/NavLeft2.gif';\" \n\t\t\t\tonMouseOut=\"document.MyImage.src='../Imagenes/NavLeft.gif';\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar / Cancelar\" name=\"MyImage\"></A>\n\t\t</td>\n\t\t".toCharArray();
    __oracle_jsp_text[109] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[110] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[111] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[112] = 
    "\n\t\t\t\t<td width=\"60\"><!-- <input type=\"button\" onclick=\"Responder();\" value=\"Responder\" class=\"blue100\"> -->\n\t\t\t\t<A\tonclick=\"if(botonBandera){botonBandera=false; location.assign('Responder.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[113] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[114] = 
    "&id_es=".toCharArray();
    __oracle_jsp_text[115] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[116] = 
    "&us_or=".toCharArray();
    __oracle_jsp_text[117] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[118] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[119] = 
    "');}\"\n\t\t\t\t\tonMouseOver=\"document.Responder3.src='../Imagenes/Responder2.gif';\"\n\t\t\t\t\tonMouseOut=\"document.Responder3.src='../Imagenes/Responder.gif';\"><IMG\n\t\t\t\t\tsrc=\"../Imagenes/Responder.gif\" border=0 name=\"Responder3\" alt=\"Responder\"></A>\n\t\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[120] = 
    " \n\t\t".toCharArray();
    __oracle_jsp_text[121] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[122] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[123] = 
    "\n\t\t\t\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[124] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; Turnar();}\" onMouseOver=\"document.Habilitar2.src='../Imagenes/deleg_multiple2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Habilitar2.src='../Imagenes/deleg_multiple.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/deleg_multiple.gif\" alt=\"Habilitar Delegado Multiple\" name=\"Habilitar2\"></A>\n\t\t\t\t</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[125] = 
    "\n\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[126] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[127] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[128] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[129] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<a \tonclick=\"if(botonBandera){botonBandera=false; agregarContent();}\" onMouseOver=\"document.Insertar.src='../Imagenes/Attach2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Insertar.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\" alt=\"Insertar Archivo\" name=\"Insertar\"></a>\n\t\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[130] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[131] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[132] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[133] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; agregarComentario();}\" \n\t\t\t\t\t\tonMouseOver=\"document.Comentario.src='../Imagenes/Comentario2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Comentario.src='../Imagenes/Comentario.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Comentario.gif\" alt=\"Crear un Comentario\" name=\"Comentario\"></A>\n\t\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[134] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[135] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[136] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[137] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[138] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; Rechazar();}\" onMouseOver=\"document.Rechazar2.src='../Imagenes/Rechazar2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Rechazar2.src='../Imagenes/Rechazar.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Rechazar.gif\" alt=\"Rechazar\" name=\"Rechazar2\"></A>\n\t\t\t\t</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[139] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[140] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[141] = 
    "\n\t\t<td width=\"200\">&nbsp;</td>\t\t\n\t\t".toCharArray();
    __oracle_jsp_text[142] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[143] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[144] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[145] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[146] = 
    "\n<!--\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; ReasignarRechazar();}\" onMouseOver=\"document.Reasignar2.src='../Imagenes/Reasignar2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Reasignar2.src='../Imagenes/Reasignar.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Reasignar.gif\" alt=\"Reasignar\" name=\"Reasignar2\"></A>\n\t\t\t\t</td>   -->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[147] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[148] = 
    "     \n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; TerminarRechazada();}\" \n\t\t\t\t\t\tonMouseOver=\"document.TerRechazada.src='../Imagenes/Responder2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.TerRechazada.src='../Imagenes/Responder.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Responder.gif\" alt=\"Terminar instrucción Rechazada\" name=\"TerRechazada\"></A>\n\t\t\t\t</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[149] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[150] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[151] = 
    "\n\t\t<td width=\"200\">&nbsp;</td>\n\t\t".toCharArray();
    __oracle_jsp_text[152] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[153] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[154] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A onclick=\"if(botonBandera){imprimir();}\" onMouseOver=\"document.Imprimir.src='../Imagenes/Imprimir2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Imprimir.src='../Imagenes/Imprimir.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Imprimir.gif\" alt=\"Imprimir\" name=\"Imprimir\"></A>\n\t\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[155] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[156] = 
    "\n\t\t<td width=\"200\">&nbsp;</td>\n\t\t".toCharArray();
    __oracle_jsp_text[157] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[158] = 
    "\n\t\t<!-- Si la instruccion tiene como estatus \"Por atender\", se mostraran todos los botones -->\n\t\t".toCharArray();
    __oracle_jsp_text[159] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[160] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[161] = 
    "\n\t\t\t\t<td width=\"60\"><!-- <input type=\"button\" onclick=\"Responder();\" value=\"Responder\" class=\"blue100\"> -->\n\t\t\t\t<A\n\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; location.assign('Responder.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[162] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[163] = 
    "&id_es=".toCharArray();
    __oracle_jsp_text[164] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[165] = 
    "&us_or=".toCharArray();
    __oracle_jsp_text[166] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[167] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[168] = 
    "');}\"\n\t\t\t\t\tonMouseOver=\"document.Responder3.src='../Imagenes/Responder2.gif';\"\n\t\t\t\t\tonMouseOut=\"document.Responder3.src='../Imagenes/Responder.gif';\"><IMG\n\t\t\t\t\tsrc=\"../Imagenes/Responder.gif\" border=0 name=\"Responder3\" alt=\"Responder\"></A>\n\t\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[169] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[170] = 
    "\n\t\t\n\t\t".toCharArray();
    __oracle_jsp_text[171] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[172] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[173] = 
    "\n\t\t\t<td width=\"60\">\n\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; Turnar();}\" onMouseOver=\"document.Habilitar2.src='../Imagenes/deleg_multiple2.gif';\" \n\t\t\t\t\tonMouseOut=\"document.Habilitar2.src='../Imagenes/deleg_multiple.gif';\">\n\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/deleg_multiple.gif\" alt=\"Habilitar Delegado Multiple\" name=\"Habilitar2\"></A>\n\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[174] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[175] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[176] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[177] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[178] = 
    "\n                                ".toCharArray();
    __oracle_jsp_text[179] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[180] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; Reasignar();}\" onMouseOver=\"document.Reasignar2.src='../Imagenes/Reasignar2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Reasignar2.src='../Imagenes/Reasignar.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Reasignar.gif\" alt=\"Reasignar\" name=\"Reasignar2\"></A>\n\t\t\t\t</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[181] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[182] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[183] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[184] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[185] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; Rechazar();}\" onMouseOver=\"document.Rechazar2.src='../Imagenes/Rechazar2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Rechazar2.src='../Imagenes/Rechazar.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Rechazar.gif\" alt=\"Rechazar\" name=\"Rechazar2\"></A>\n\t\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[186] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[187] = 
    "\n\n\t\t".toCharArray();
    __oracle_jsp_text[188] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[189] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<a \tonclick=\"if(botonBandera){botonBandera=false; agregarContent();}\" onMouseOver=\"document.Insertar.src='../Imagenes/Attach2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Insertar.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\" alt=\"Insertar Archivo\" name=\"Insertar\"></a>\n\t\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[190] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[191] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[192] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[193] = 
    "\t\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[194] = 
    "\n                                        <td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; cambioFecha();}\" \n\t\t\t\t\t\tonMouseOver=\"document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.cambioFecha1.src='../Imagenes/CambioFecha.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CambioFecha.gif\" alt=\"Solicitar Cambio de Fecha\" name=\"cambioFecha1\"></A>\n                                        </td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[195] = 
    "\n                                        <td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; cambioFecha();}\" \n\t\t\t\t\t\tonMouseOver=\"document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.cambioFecha1.src='../Imagenes/CambioFecha.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CambioFecha.gif\" alt=\"Cambiar Fecha\" name=\"cambioFecha1\"></A>\n                                        </td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[196] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[197] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[198] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[199] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[200] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; agregarComentario();}\" \n\t\t\t\t\t\tonMouseOver=\"document.Comentario.src='../Imagenes/Comentario2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Comentario.src='../Imagenes/Comentario.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Comentario.gif\" alt=\"Crear un Comentario\" name=\"Comentario\"></A>\n\t\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[201] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[202] = 
    "\n\t\t\n\t\t<td width=\"300\">&nbsp;</td>\n\n\t\t<!-- Si la instrucción se encuestra en tramite, no mostrara el boton de rechazar -->\n\t\t".toCharArray();
    __oracle_jsp_text[203] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[204] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[205] = 
    "\n\t\t\t\t<td width=\"60\" vAlign=top><A\n\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; location.assign('Responder.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[206] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[207] = 
    "&id_es=".toCharArray();
    __oracle_jsp_text[208] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[209] = 
    "&us_or=".toCharArray();
    __oracle_jsp_text[210] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[211] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[212] = 
    "');}\"\n\t\t\t\t\tonMouseOver=\"document.Responder3.src='../Imagenes/Responder2.gif';\"\n\t\t\t\t\tonMouseOut=\"document.Responder3.src='../Imagenes/Responder.gif';\"><IMG\n\t\t\t\t\tsrc=\"../Imagenes/Responder.gif\" border=0 name=\"Responder3\" alt=\"Responder\"></A>\n\t\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[213] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[214] = 
    "\n\n\t\t".toCharArray();
    __oracle_jsp_text[215] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[216] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[217] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; Turnar();}\" onMouseOver=\"document.Habilitar2.src='../Imagenes/deleg_multiple2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Habilitar2.src='../Imagenes/deleg_multiple.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/deleg_multiple.gif\" alt=\"Habilitar Delegado Multiple\" name=\"Habilitar2\"></A>\n\t\t\t\t</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[218] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[219] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[220] = 
    "\n<!-- Parte de Reasignacion de instruccion -->\n\t\t".toCharArray();
    __oracle_jsp_text[221] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[222] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[223] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; Reasignar();}\" onMouseOver=\"document.Reasignar2.src='../Imagenes/Reasignar2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Reasignar2.src='../Imagenes/Reasignar.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Reasignar.gif\" alt=\"Reasignar\" name=\"Reasignar2\"></A>\n\t\t\t\t</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[224] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[225] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; Reasignar();}\" onMouseOver=\"document.Reasignar2.src='../Imagenes/Reasignar2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Reasignar2.src='../Imagenes/Reasignar.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Reasignar.gif\" alt=\"Reasignar\" name=\"Reasignar2\"></A>\n\t\t\t\t</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[226] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[227] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[228] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[229] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[230] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[231] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<a \tonclick=\"if(botonBandera){botonBandera=false; agregarContent();}\" onMouseOver=\"document.Insertar.src='../Imagenes/Attach2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Insertar.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\" alt=\"Insertar Archivo / Escanear documento!\" name=\"Insertar\"></a>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[232] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[233] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[234] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[235] = 
    "\n\t\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[236] = 
    "\n                                        <td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; cambioFecha();}\" \n\t\t\t\t\t\tonMouseOver=\"document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.cambioFecha1.src='../Imagenes/CambioFecha.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CambioFecha.gif\" alt=\"Solicitar Cambio de Fecha\" name=\"cambioFecha1\"></A>\n                                        </td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[237] = 
    "\n\t\t\t\t\t<!-- <INPUT type=\"button\" onclick=\"cambioFecha()\" value=\"Cambiar Fecha\" class=\"blue200\"> -->\n\t\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; cambioFecha();}\" \n\t\t\t\t\t\tonMouseOver=\"document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.cambioFecha1.src='../Imagenes/CambioFecha.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CambioFecha.gif\" alt=\"Cambiar Fecha\" name=\"cambioFecha1\"></A>\n                                        </td>\n\t\t\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[238] = 
    "\n\t\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[239] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[240] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[241] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[242] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; agregarComentario();}\" \n\t\t\t\t\t\tonMouseOver=\"document.Comentario.src='../Imagenes/Comentario2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Comentario.src='../Imagenes/Comentario.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Comentario.gif\" alt=\"Crear un Comentario\" name=\"Comentario\"></A>\n\t\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[243] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[244] = 
    "\n\t\t<td width=\"100\">&nbsp;</td>\n\n\t\t<!-- \tSi la instruccion ha sido rechazada, solo mostrara los \n\t\t\t\tbotones de reasignar -->\n\t\t".toCharArray();
    __oracle_jsp_text[245] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[246] = 
    "\n                    ".toCharArray();
    __oracle_jsp_text[247] = 
    "\n                                ".toCharArray();
    __oracle_jsp_text[248] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[249] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; ReasignarRechazar();}\" onMouseOver=\"document.Reasignar2.src='../Imagenes/Reasignar2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Reasignar2.src='../Imagenes/Reasignar.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Reasignar.gif\" alt=\"Reasignar\" name=\"Reasignar2\"></A>\n\t\t\t\t</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[250] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[251] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; TerminarRechazada();}\" \n\t\t\t\t\t\tonMouseOver=\"document.TerRechazada.src='../Imagenes/Responder2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.TerRechazada.src='../Imagenes/Responder.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Responder.gif\" alt=\"Terminar instrucción Rechazada\" name=\"TerRechazada\"></A>\n\t\t\t\t</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[252] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[253] = 
    "\n                    ".toCharArray();
    __oracle_jsp_text[254] = 
    "\n\t\t<td width=\"400\">&nbsp;</td>\n\n\t\t<!-- Si la instrucción ha sido terminada, no mostrara ningun boton -->\n\t\t".toCharArray();
    __oracle_jsp_text[255] = 
    "\n\t\t<!-- td width=\"125\">&nbsp;</td-->\n\t\t".toCharArray();
    __oracle_jsp_text[256] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[257] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A onclick=\"if(botonBandera){imprimir();}\" onMouseOver=\"document.Imprimir.src='../Imagenes/Imprimir2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Imprimir.src='../Imagenes/Imprimir.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Imprimir.gif\" alt=\"Imprimir\" name=\"Imprimir\"></A>\n\t\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[258] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[259] = 
    "\n\t\t<td width=\"500\">&nbsp;</td>\n\n\t\t<!-- Si la instrucción ha sido delegada, solo mostrara los botones de responder y delegar -->\n\t\t".toCharArray();
    __oracle_jsp_text[260] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[261] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[262] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t<A\n\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; location.assign('Responder.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[263] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[264] = 
    "&id_es=".toCharArray();
    __oracle_jsp_text[265] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[266] = 
    "&us_or=".toCharArray();
    __oracle_jsp_text[267] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[268] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[269] = 
    "');}\"\n\t\t\t\t\tonclick=\"\" onmouseover=\"dropdownmenu(this, event, 'anylinkmenuR')\"\n\t\t\t\t\tonMouseOut=\"document.Responder3.src='../Imagenes/Responder.gif';\"><IMG\n\t\t\t\t\tsrc=\"../Imagenes/Responder.gif\" border=\"0\" name=\"Responder3\" alt=\"Responder\"></A>\n\t\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[270] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[271] = 
    "\n\n\t\t".toCharArray();
    __oracle_jsp_text[272] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[273] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; Delegar();}\" onMouseOver=\"document.Delegar2.src='../Imagenes/Delegar2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Delegar2.src='../Imagenes/Delegar.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Delegar.gif\" alt=\"Delegar\" name=\"Delegar2\"></A>\n\t\t\t".toCharArray();
    __oracle_jsp_text[274] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[275] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[276] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[277] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; agregarComentario();}\" \n\t\t\t\t\t\tonMouseOver=\"document.Comentario.src='../Imagenes/Comentario2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Comentario.src='../Imagenes/Comentario.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Comentario.gif\" alt=\"Crear un Comentario\" name=\"Comentario\"></A>\n\t\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[278] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[279] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[280] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[281] = 
    "\n\t\t\t\t<td width=\"60\">\n\t\t\t\t\t<a \tonclick=\"if(botonBandera){botonBandera=false; agregarContent();}\" onMouseOver=\"document.Insertar.src='../Imagenes/Attach2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Insertar.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\" alt=\"Insertar Archivo / Escanear documento!\" name=\"Insertar\"></a>\n\t\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[282] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[283] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[284] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[285] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[286] = 
    "\n                                        <td width=\"60\">\n\t\t\t\t\n\t\t\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; cambioFecha();}\" \n\t\t\t\t\t\tonMouseOver=\"document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.cambioFecha1.src='../Imagenes/CambioFecha.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CambioFecha.gif\" alt=\"Solicitar Cambio de Fecha\" name=\"cambioFecha1\"></A>\n                                        </td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[287] = 
    "\n\t\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[288] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[289] = 
    "\n\t\t<td width=\"300\">&nbsp;</td>\n\t\t".toCharArray();
    __oracle_jsp_text[290] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[291] = 
    "\n\t</tr>\n</table>\n</td></tr></table>\n</DIV>\n<br>\n".toCharArray();
    __oracle_jsp_text[292] = 
    "\n<DIV align=\"center\">\n<TABLE>\n<TBODY>\n<TR>\n<td>\n<FONT size=\"2\" color=\"red\">Se ha solicitado un Cambio de Fecha de Vencimiento para esta instrucción</FONT>\n</td>\n</TR>\n</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[293] = 
    "\n<div align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos\n\t\tbásicos</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"394\">\n\t\t\t<DIV align=\"right\">\n\t\t\t<FONT face=\"Arial\" color=\"#00204f\" size=\"2\">Folio:<b>".toCharArray();
    __oracle_jsp_text[294] = 
    "</b></FONT>\n\t\t\t</DIV>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</div>\n<DIV class=documentBody id=Body>\n<div align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Nombre:</font>\n\t\t</td>\n\t\t<td colspan=\"3\" width=\"680\">\n\t\t\t<font size=\"2\" face=\"Arial\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[295] = 
    "\n                            ".toCharArray();
    __oracle_jsp_text[296] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[297] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[298] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[299] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[300] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[301] = 
    "\n\t\t\t<INPUT type=\"hidden\" name=\"nombreHdn\" value=\"".toCharArray();
    __oracle_jsp_text[302] = 
    "\">\n\t\t\t<INPUT type=\"hidden\" name=\"telefonoHdn\" value=\"".toCharArray();
    __oracle_jsp_text[303] = 
    "\">\n\t\t\t<INPUT type=\"hidden\" name=\"correoHdn\" value=\"".toCharArray();
    __oracle_jsp_text[304] = 
    "\">\n\t\t\t</font>\n\t\t</td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Tipo de\n\t\tatención:</font></td>\n\t\t<td width=\"\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[305] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"atencionHdn\" value=\"".toCharArray();
    __oracle_jsp_text[306] = 
    "\"></font></td>\n\t\t<td width=\"\" align=\"right\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Acceso al\n\t\tDocumento Original:&nbsp;&nbsp;</font></td>\n\t\t<td><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[307] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"verDoctoHdn\" value=\"".toCharArray();
    __oracle_jsp_text[308] = 
    "\"></font> ".toCharArray();
    __oracle_jsp_text[309] = 
    "\n\t\t<A href=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[310] = 
    "&ih=".toCharArray();
    __oracle_jsp_text[311] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[312] = 
    "\"> <IMG\n\t\t\tSRC='../Imagenes/type_document.gif' BORDER=0> </A> ".toCharArray();
    __oracle_jsp_text[313] = 
    "</td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Asunto:</font>\n\t\t</td>\n\t\t<td colspan=\"3\" width=\"680\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[314] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"asuntoHdn\" value=\"".toCharArray();
    __oracle_jsp_text[315] = 
    "\"><INPUT\n\t\t\ttype=\"hidden\" name=\"pasoHdn\" value=\"".toCharArray();
    __oracle_jsp_text[316] = 
    "\"></font></td>\n\t</tr>\n\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha de\n\t\tgeneración:</font></td>\n\t\t<td width=\"\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[317] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"fechaGenHdn\" value=\"".toCharArray();
    __oracle_jsp_text[318] = 
    "\"></font>\n\t\t</td>\n\t\t<td align=\"right\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha Vencimiento:&nbsp;&nbsp;</font>\n\t\t</td>\n\t\t<td><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[319] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"fechaVenHdn\" value=\"".toCharArray();
    __oracle_jsp_text[320] = 
    "\"></font>\n\t\t</td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Estatus:</font>\n\t\t</td>\n\t\t<td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[321] = 
    "\n\t\t\t<font size=\"2\" face=\"Arial\">Notificado</font>\n\t\t\t".toCharArray();
    __oracle_jsp_text[322] = 
    "\n\t\t\t<font size=\"2\" face=\"Arial\">En Trámite</font>\n\t\t\t".toCharArray();
    __oracle_jsp_text[323] = 
    "\n\t\t\t<font size=\"2\" face=\"Arial\">Rechazada</font>\n\t\t\t".toCharArray();
    __oracle_jsp_text[324] = 
    "\n\t\t\t<font size=\"2\" face=\"Arial\">Terminada</font>\n\t\t\t".toCharArray();
    __oracle_jsp_text[325] = 
    "</td>\n\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\t<!-- <tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Delegado\n\t\ta:</font></td>\n\t\t".toCharArray();
    __oracle_jsp_text[326] = 
    "\n\t\t<td colspan=\"3\" width=\"680\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[327] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[328] = 
    " <INPUT type=\"hidden\" name=\"delegadoAHdn\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[329] = 
    "\"> </font></td>\n\t\t".toCharArray();
    __oracle_jsp_text[330] = 
    "\n\t\t<td colspan=\"3\" width=\"680\"></td>\n\t\t".toCharArray();
    __oracle_jsp_text[331] = 
    "\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR> -->\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Asignada\n\t\tpor: </font></td>\n\t\t<td width=\"\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[332] = 
    "<input\n\t\t\ttype=\"hidden\" name=\"turnadoPorHdn\" value=\"".toCharArray();
    __oracle_jsp_text[333] = 
    "\"></font></td>\n\t\t<td width=\"\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\"\n\t\t\talt=\"\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Folio de\n\t\tRecepción:</font> <font size=\"2\" face=\"Arial\"> </font></td>\n\t\t<td colspan=\"3\" width=\"680\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[334] = 
    " <input\n\t\t\ttype=\"hidden\" name=\"folioRecepcionHdn\" value=\"".toCharArray();
    __oracle_jsp_text[335] = 
    "\"></font>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\"\n\t\t\talt=\"\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Folio\n\t\tIntermedio:</font></td>\n\t\t<td width=\"\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[336] = 
    "\n\n\t\t</font><input type=\"hidden\" name=\"folioIntermedioHdn\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[337] = 
    "\"></td>\n\t\t<td width=\"\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\"\n\t\t\talt=\"\">&nbsp;</td>\n\t</tr>\n</table>\n</div>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">INSTRUCCION</font></b>\n\t\t</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#00204F\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\"\n\t\t\twidth=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\"\n\t\t\talt=\"\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[338] = 
    "<input\n\t\t\ttype=\"hidden\" name=\"nombreInstruccionHdn\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[339] = 
    "\"></font></td>\n\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\"\n\t\t\talt=\"\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</table>\n</DIV>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">SINTESIS</font></b>\n\t\t</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#00204F\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\"\n\t\t\twidth=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[340] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"sintesisHdn\" value=\"".toCharArray();
    __oracle_jsp_text[341] = 
    "\"></font></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\"\n\t\t\talt=\"\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\n</table>\n</DIV>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">EXPEDIENTES</font></b>\n\t\t</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\"\n\t\t\twidth=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\">\n\t\t<IFRAME src=\"ExpedienteInstrccion.jsp?ida=".toCharArray();
    __oracle_jsp_text[342] = 
    "&num=1\" WIDTH=800 HEIGHT=100 frameborder=0 id=\"Entidad\"></IFRAME>\n\t\t</td>\n\t</tr>\n\n\n</table>\n\n</DIV>\n<br>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"863\">\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">Historia de la instrucción</font></b>\n\t\t</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#00204F\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\"\n\t\t\twidth=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t".toCharArray();
    __oracle_jsp_text[343] = 
    " \n\t\t<td width=\"100%\" colspan=\"4\"><font size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">".toCharArray();
    __oracle_jsp_text[344] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[345] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[346] = 
    "----><br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[347] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[348] = 
    "\n\t\t\t\tSe ha alcanzado el estatus de &quot;Terminado&quot; en todas las Instrucciones delagadas <br>\n\t\t\t\t<U>Avance de: 99%</U>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[349] = 
    "\n\t\t\t\tAvance del Usuario: ".toCharArray();
    __oracle_jsp_text[350] = 
    "<br>\n\t\t\t<a href=\"Responder.jsp?id_his=".toCharArray();
    __oracle_jsp_text[351] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[352] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[353] = 
    "\"> <font size=\"1\"\n\t\t\t\tcolor=\"#004080\" face=\"Arial\"> <U>Avance de: ".toCharArray();
    __oracle_jsp_text[354] = 
    "%</U><input\n\t\t\t\ttype=\"hidden\" name=\"avanceDeHdn\" value=\"".toCharArray();
    __oracle_jsp_text[355] = 
    "\"> </font> </a>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[356] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[357] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[358] = 
    "----><br>\n\t\t\t\tDocumento Rechazado por: ".toCharArray();
    __oracle_jsp_text[359] = 
    "<br>\n\t\t\t\tRazón de Rechazo: ".toCharArray();
    __oracle_jsp_text[360] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[361] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[362] = 
    "----><br>\n\t\t\t\tDocumento Reasignado a: ".toCharArray();
    __oracle_jsp_text[363] = 
    "\n\t\t\t\tpor el Usuario: ".toCharArray();
    __oracle_jsp_text[364] = 
    "<br>\n\t\t\t\tComentarios Adicionales: ".toCharArray();
    __oracle_jsp_text[365] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[366] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[367] = 
    "----><br>\n\t\t\t\tDocumento Delegado a : ".toCharArray();
    __oracle_jsp_text[368] = 
    "\n\t\t\t<br>\n\t\t\t\tComentarios Adicionales: ".toCharArray();
    __oracle_jsp_text[369] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[370] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[371] = 
    "----><br>\n\t\t\t\tEl Usuario: ".toCharArray();
    __oracle_jsp_text[372] = 
    " Generó Instrucciones para Atender la solicitud\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[373] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[374] = 
    "----><br>\n\t\t\t\tPuesto: ".toCharArray();
    __oracle_jsp_text[375] = 
    " <br>\n                Comentario: ".toCharArray();
    __oracle_jsp_text[376] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[377] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[378] = 
    "----><br>\n\t\t\t\tEl Usuario ".toCharArray();
    __oracle_jsp_text[379] = 
    " / ".toCharArray();
    __oracle_jsp_text[380] = 
    " ".toCharArray();
    __oracle_jsp_text[381] = 
    "<br>\n                Comentario: ".toCharArray();
    __oracle_jsp_text[382] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[383] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[384] = 
    "----><br>\n\t\t\t\tEl Usuario ".toCharArray();
    __oracle_jsp_text[385] = 
    " / ".toCharArray();
    __oracle_jsp_text[386] = 
    " ".toCharArray();
    __oracle_jsp_text[387] = 
    "<br>\n                Comentario: ".toCharArray();
    __oracle_jsp_text[388] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[389] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[390] = 
    "----><br>\n\t\t\t\tEl Usuario ".toCharArray();
    __oracle_jsp_text[391] = 
    " / ".toCharArray();
    __oracle_jsp_text[392] = 
    " ".toCharArray();
    __oracle_jsp_text[393] = 
    "<br>\n                Comentario: ".toCharArray();
    __oracle_jsp_text[394] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[395] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[396] = 
    " </font></td>\n\t\t".toCharArray();
    __oracle_jsp_text[397] = 
    "\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t\t".toCharArray();
    __oracle_jsp_text[398] = 
    "\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\n\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\"><B><FONT face=\"Arial\" color=\"#004080\"\n\t\t\tsize=\"2\">Documentos Anexados</FONT></B></td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" bgcolor=\"#00204F\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">\n\t\t<div>\n\t\t\t".toCharArray();
    __oracle_jsp_text[399] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[400] = 
    "\n\t\t\t\t<IFRAME ID=\"frame1\" SRC=\"ImportarCMO.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[401] = 
    "&bo=true&IdInst=".toCharArray();
    __oracle_jsp_text[402] = 
    "&fol=".toCharArray();
    __oracle_jsp_text[403] = 
    "&est=".toCharArray();
    __oracle_jsp_text[404] = 
    "\" WIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[405] = 
    "\n\t\t\t\t<IFRAME ID=\"frame1\" SRC=\"ImportarAR.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[406] = 
    "&bo=true&IdInst=".toCharArray();
    __oracle_jsp_text[407] = 
    "&fol=".toCharArray();
    __oracle_jsp_text[408] = 
    "&est=".toCharArray();
    __oracle_jsp_text[409] = 
    "\" WIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[410] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[411] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[412] = 
    "\n\t\t\t\t<IFRAME ID=\"frame1\" SRC=\"ImportarAR.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[413] = 
    "&bo=false&IdInst=".toCharArray();
    __oracle_jsp_text[414] = 
    "&fol=".toCharArray();
    __oracle_jsp_text[415] = 
    "&est=".toCharArray();
    __oracle_jsp_text[416] = 
    "\" WIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[417] = 
    "\n\t\t\t\t<IFRAME ID=\"frame1\" SRC=\"ImportarCMO.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[418] = 
    "&bo=false&IdInst=".toCharArray();
    __oracle_jsp_text[419] = 
    "&fol=".toCharArray();
    __oracle_jsp_text[420] = 
    "&est=".toCharArray();
    __oracle_jsp_text[421] = 
    "\" WIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[422] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[423] = 
    "\n\t\t</div>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" bgcolor=\"#00204F\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\n\t".toCharArray();
    __oracle_jsp_text[424] = 
    "\n\n\t<tr valign=\"top\">\n\t\t<td width=\"64%\" colspan=\"2\"><b><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">Firmado<INPUT type=\"hidden\" name=\"firmadoHdn\"\n\t\t\tvalue=\"true\"></font></b>\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t<td width=\"21%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"14%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" bgcolor=\"#00204F\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td align=\"center\"><b>Usuario</b></td>\n\t\t<td align=\"center\"><b>Fecha</b></td>\n\t\t<TD align=\"center\"></TD>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td align=\"center\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td align=\"center\">".toCharArray();
    __oracle_jsp_text[425] = 
    "<INPUT type=\"hidden\"\n\t\t\tname=\"nombreFirmanteHdn\" value=\"".toCharArray();
    __oracle_jsp_text[426] = 
    "\"></td>\n\t\t<td align=\"center\">".toCharArray();
    __oracle_jsp_text[427] = 
    "<INPUT type=\"hidden\"\n\t\t\tname=\"fechaTerminacionRealHdn\" value=\"".toCharArray();
    __oracle_jsp_text[428] = 
    "\">\n\t\t</td>\n\t\t<td align=\"center\"><IMG src=\"../Imagenes/0.jpgpg\" alt=\"firmado\"\n\t\t\twidth=\"30\" height=\"30\"></td>\n\t</tr>\n\t".toCharArray();
    __oracle_jsp_text[429] = 
    "\n</table>\n<br>\n</DIV>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n<script type=\"text/javascript\">\n<!--\nif (".toCharArray();
    __oracle_jsp_text[430] = 
    "){\n\talert(\"Esta instrucción ha sido modificada por otro usuario y Cambió su Estatus,\\npor lo que la acción solicitada será cancelada\");\n\tlocation.assign(\"portalPrincipal.jsp\");\n}\n//-->\n</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
