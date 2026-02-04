package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.*;
import com.meve.sigma.reportes.*;
import java.sql.Date;
import gob.hacienda.cgtic.siga.actualiza.RechazoInstruccion;
import gob.hacienda.cgtic.siga.actualiza.AtenderInstrucciones;
import gob.hacienda.cgtic.siga.util.Jefe;
import gob.hacienda.cgtic.siga.asunto.AsuntoVerifica;


public class _InstruccionTurnada extends com.orionserver.http.OrionHttpJspPage {


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
    _InstruccionTurnada page = this;
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
      com.meve.sigma.beans.TurnarInstruccionBean BTurnarInst;
      synchronized (pageContext) {
        if ((BTurnarInst = (com.meve.sigma.beans.TurnarInstruccionBean) pageContext.getAttribute( "BTurnarInst", PageContext.PAGE_SCOPE)) == null) {
          BTurnarInst = (com.meve.sigma.beans.TurnarInstruccionBean) new com.meve.sigma.beans.TurnarInstruccionBean();
          pageContext.setAttribute( "BTurnarInst", BTurnarInst, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
      out.write(__oracle_jsp_text[7]);
      out.write(__oracle_jsp_text[8]);
      out.write(__oracle_jsp_text[9]);
      com.meve.sigma.beans.EscrituraBean BEscritura;
      synchronized (pageContext) {
        if ((BEscritura = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscritura", PageContext.PAGE_SCOPE)) == null) {
          BEscritura = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
          pageContext.setAttribute( "BEscritura", BEscritura, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[10]);
      com.meve.sigma.beans.EscrituraBean BEscritura1;
      synchronized (pageContext) {
        if ((BEscritura1 = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscritura1", PageContext.PAGE_SCOPE)) == null) {
          BEscritura1 = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
          pageContext.setAttribute( "BEscritura1", BEscritura1, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[11]);
      com.meve.sigma.beans.EscrituraBean BEscritura2;
      synchronized (pageContext) {
        if ((BEscritura2 = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscritura2", PageContext.PAGE_SCOPE)) == null) {
          BEscritura2 = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
          pageContext.setAttribute( "BEscritura2", BEscritura2, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[12]);
      com.meve.sigma.beans.EscrituraBean BEscrituraAr;
      synchronized (pageContext) {
        if ((BEscrituraAr = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscrituraAr", PageContext.PAGE_SCOPE)) == null) {
          BEscrituraAr = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
          pageContext.setAttribute( "BEscrituraAr", BEscrituraAr, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[13]);
      com.meve.sigma.beans.EscrituraBean BEscrituraTur;
      synchronized (pageContext) {
        if ((BEscrituraTur = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscrituraTur", PageContext.PAGE_SCOPE)) == null) {
          BEscrituraTur = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
          pageContext.setAttribute( "BEscrituraTur", BEscrituraTur, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[14]);
      
      	String strIdInstruccion		=	""; //Contiene el ID de la instrucción
      	strIdInstruccion		=	(request.getParameter("id_ins") != null)?request.getParameter("id_ins"):"";
                                                       request.setAttribute("idInstruccion",strIdInstruccion);
      	UsuarioBean BUsuario            =       (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp                   =        request.getRequestURI();
      	strTmp                          =        strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+strTmp+"?id_ins="+strIdInstruccion);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("E/RROR:"+io.getMessage());
      		}
      	}
      	String [][]historialInstruccion     =   ActualizaHistorial.getHistorialInstruccion(strIdInstruccion);
                                                      request.setAttribute("historial",historialInstruccion);
      
      out.write(__oracle_jsp_text[15]);
      
      	String strItemType                  =  (application.getInitParameter("ItemType")==null)?"":application.getInitParameter("ItemType");
      	String strIdAsunto		    =	""; //Contiene el ID del Asunto
      	String strNombre		    =	"";
      	String strTelefono		    =	"";
      	String strCorreo		    =	"";
      	String strTipoAtencion		    =   "";
      	String strAcceso		    =	"";
      	String strAsunto	            =	"";
      	String strPaso			    =	"";
      	String strFecGeneracion		    =	"";
      	String strFecVencimiento	    =	"";
      	String strEstatus		    =	"";
      	String strTurnadoPor		    =	"";
      	String strFolioRecepcion	    =	"";
      	String strFolioTurnado		    =	"";
      	String strFolioIntermedio	    =	"";
      	String strInstruccion		    =	"";
      	String strInstruccionOtro	    =	"";
      	String strSintesis		    =	"";
      	String strAtencion		    =	"";
      	String strVerDocto		    =	"";
      	String strNombreInstruccion	    =	"";
      	String strAvance		    =	"";
      	String strMostrarHabilitado	    =	"";
      	String strDelegado		    =	"";
      	String strPadre			    =	"";
      	String estatusHijos		    =  	"";
      	String strAccion		    =   "";
      	String strFechaInicio		    =	"";
      	String strUsuarioOriginal	    =	"";
          String strFirmaDigital		    = 	"";
          String strFechaTerminacionReal          =   "";
      	String strIdAsistente		    =	"";
      	String strIdJefe		    =	"";
      	String strIdUsuario		    =	"";
      	String strIdArea		    =	"";
      	String strFechaCambio		    =	"";
      	String esDelegado		    =   "";
      	String strHabilitado		    =	"";
      	String strCargo			    =	"";
      	String strBandera		    =	"";
      	String strBandera1		    =	"";
      	String strTurno			   =	""; 
      	String strIdUsuarioAsistente      =	"";
      	String strFolioEntrada		=	"";
      	String strUsuarioTermino	=	"";
      	int iTieneFechaCambio		=	0;
      	int sumEstatus			=	0;
      	
      	String strInsHijos[][]		=	null;
      	String strHijosEstatusAt[][]    =	null;
      	String strSubordinado[][]	=	null;
      	String asistentes[]		=	null;
      
      	boolean bHistorial		=	false;
      	boolean bActualizaInstruccion 	= 	false;
      	boolean bActualizahistorial 	= 	false;
      	boolean bActualizaInsOriginal 	= 	false;
      	boolean bInsertarBit			=	false;
      	boolean bhijosTurnados			=	false;
      	boolean bTieneHijos			=	false;
      	boolean tieneHijos			=	false;
      	boolean bAsistente			= 	false;
      
      	String serverContentManager	        =  	application.getInitParameter("content");
      	String server 				= 	application.getInitParameter("servername");
      	String strActivarCM 		        = 	application.getInitParameter("ActivarContent");
      	String strBase				=       request.getContextPath();//	application.getInitParameter("RutaBase");
      	String strIH				=	(request.getParameter("ih")== null)?"":request.getParameter("ih");
      	String strDif				=	"";
              
      	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
          String retURI2 = (request.getParameter("retURI2")== null)?retURI:request.getParameter("retURI2");
      	
              String strReload  =  (request.getParameter("reload")==null)?"":request.getParameter("reload");
      	
      	//** Se crea un String para forma el url de la pagina
      	//** y pasarla como atributo al applet
      	String url = request.getRequestURI();
      	String URL = request.getScheme() +"://"+request.getServerName()+(request.getServerPort()!= 80? ":" + request.getServerPort():"")+url+"?id_ins="+strIdInstruccion;
      	//** Fin String de url
      	
      	strAccion	=	request.getParameter("accion");
      
      	java.text.SimpleDateFormat sdf      	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 			=	new java.util.Date();
      	strFechaInicio		    	        =	sdf.format(f);
      	boolean bTieneTramite                   =       false;
      /*Variable de control de acceso para los distintos iconos*/
          boolean bEstanVacias = true;
      	if(strInstruccion != null){
      		String strDatosInstrucciones[][]	=	ActualizaInstrucciones.getInstruccionDatos(strIdInstruccion);
      		strIdAsunto		=	ActualizaInstrucciones.getIdAsuntoInstruccion(strIdInstruccion);
      		strNombre		=	strDatosInstrucciones[0][13];
      		strTelefono		=	strDatosInstrucciones[0][14];
      		strCorreo		=	strDatosInstrucciones[0][15];
      		strTipoAtencion		=	strDatosInstrucciones[0][3];
      		strAcceso		=	strDatosInstrucciones[0][4];
      		strAsunto		=	strDatosInstrucciones[0][10];
      		//strPaso		=	strDatosInstrucciones[0][17];
      		strFecGeneracion	=	strDatosInstrucciones[0][7];
      		strFecVencimiento	=	strDatosInstrucciones[0][8];
      		strTurnadoPor		=	strDatosInstrucciones[0][12];
      		strFolioRecepcion	=	strDatosInstrucciones[0][16];
      		strFolioIntermedio	=	strDatosInstrucciones[0][17];
      		strInstruccion		=	strDatosInstrucciones[0][1];
      		strInstruccionOtro	=	strDatosInstrucciones[0][9];
      		strSintesis		=	strDatosInstrucciones[0][11];
      		strFolioTurnado		=	strDatosInstrucciones[0][18];
      		strEstatus		=	strDatosInstrucciones[0][19];
      		strAvance		=	strDatosInstrucciones[0][20];
      		strDelegado		=	strDatosInstrucciones[0][21];
      		strPadre		=	strDatosInstrucciones[0][22];
      		strUsuarioOriginal	=	strDatosInstrucciones[0][0];
      		strFirmaDigital		= 	strDatosInstrucciones[0][23];
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
      		strDif			=	strDatosInstrucciones[0][35];
      		strFolioEntrada		=	strDatosInstrucciones[0][36];
      		strUsuarioTermino	=	strDatosInstrucciones[0][37];
      		
      		//**Asistentes Multiples
      		if(BUsuario.getAsistente()){
      			asistentes  =	ActualizaUsuario.getAsistentes(strUsuarioOriginal);
      			if(ActualizaUsuario.esAsistente(BUsuario.getIdUsuario(), asistentes)){
      				strIdUsuarioAsistente = BUsuario.getIdUsuario();
      				bAsistente = true;
      			}
                              bAsistente = Jefe.esAsistenteDe(BUsuario.getIdUsuario(),strUsuarioOriginal);
                      }                
      		//if(strIdAsistente.equals(BUsuario.getIdUsuario())){
      		//** Verifica si tiene hijos
      		strInsHijos			=	ActualizaAsuntoTurnado.getInstruccionesHabilitadas(strIdInstruccion);
      		
      		if(strInsHijos.length != 0){
      			estatusHijos	=	strInsHijos[0][1];
      			tieneHijos		=	true;
      			bEstanVacias			=	ActualizaInstrucciones.getInstruccionesVacias(strInsHijos);
      			for(int w=0;w<strInsHijos.length;w++){
      				int q = new Integer(strInsHijos[w][1]).intValue();
      				sumEstatus = sumEstatus + q;
      			}
      		}
      		else{
      			estatusHijos = "0";
      			tieneHijos		=	false;
      		}//** Fin verificar hijos
      
      		strHijosEstatusAt	=	ActualizaAsuntoTurnado.getInstHabAtender(strIdInstruccion);
      		if(strHijosEstatusAt.length != 0){
      			bhijosTurnados	=	true;
      		}else{
      			bhijosTurnados	=	false;
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
      		
      		if(strTipoAtencion.equals("0"))
      			strAtencion = "Ejecutor";
      		else
      			strAtencion = "Informativo";
      		
      		if(strAcceso.equals("0"))
      			strVerDocto = "No";
      		else
      			strVerDocto = "Si";
      		
      		//** Verifica si del query trae el ID de la instrucción
      		//** ó otra instrucción 
      		if(strInstruccion.length() == 0)
      			strNombreInstruccion = strInstruccionOtro;
      
      		bHistorial  =   ActualizaHistorial.TieneHistorial(strIdInstruccion);
                      request.setAttribute("existeHistorial",Boolean.valueOf(bHistorial));
      		bTieneTramite = ActualizaAsunto.getTieneTramite(strIdAsunto);
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
      
      	if(!bValidaEstatus && strBandera.equals("0") && 
      		(strUsuarioOriginal.equals(BUsuario.getIdUsuario()) || //strIdUsuarioAsistente.equals(strIdAsistente)
      		bAsistente||BUsuario.getTurnado())){
      		boolean bBandera = ActualizaInstrucciones.updateBandera(strIdInstruccion);
      	}
      
      	if(!bValidaEstatus && strAccion != null && strAccion.equals("turnar")){
      		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
      		String portServer = application.getInitParameter("PortMail");
      		String serverName = application.getInitParameter("servername");  
      		BTurnarInst.turnarInstOfInst(	request, BUsuario, serverMail, portServer, serverName, strBase, strIdArea, strBandera1, strTipoAtencion); 
                      response.sendRedirect("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)+"&retURI2="+Utilerias.codificaPostHTML(retURI2));
      	}
          else 
              if(!bValidaEstatus && strAccion != null && strAccion.equals("desturnar")){
      		strIdInstruccion 	=	request.getParameter("id_ins");
      		boolean habilitar = ActualizaInstrucciones.actualizaHabilitado(strIdInstruccion, 0, "0"); 
      		String strNombreRed = "";
      		if(strDif.equals("1"))
      			strNombreRed = "InstruccionesAtender.jsp";
      		else
      			strNombreRed = "InstruccionHija.jsp";
      		response.sendRedirect(""+strNombreRed+"?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)+"&retURI2="+Utilerias.codificaPostHTML(retURI2));
      	}
      
      	if(!bValidaEstatus && strAccion != null && strAccion.equals("terminarRechazada")){
      		strIdInstruccion 	=	request.getParameter("id_ins"); 
      		Date fechaTerminacionReal=new Date(new java.util.Date().getTime());
                      boolean bHisTerminadoRechazo = false;
                      if(BUsuario.getAsistente()){
                          try{
                              bHisTerminadoRechazo	=	ActualizaHistorial.InsertarRespuesta(strIdInstruccion, strIdAsunto, "Se termino la instruccion Rechazada ",gob.hacienda.cgtic.siga.Usuario.aTitular(BUsuario.getIdUsuario()), "100", "", BUsuario.getCargo()+" / "+BUsuario.getNombre()+" en Nombre de "+gob.hacienda.cgtic.siga.instruccion.Rechazo.aNombre(BUsuario,strIdInstruccion));
                          }catch(Exception e){//System.err.println("InstruccionTurnada->291: "+e.getMessage());e.printStackTrace();
                          }
                      }else
                          bHisTerminadoRechazo	=	ActualizaHistorial.InsertarRespuesta(strIdInstruccion, strIdAsunto, "Se termino la instruccion Rechazada ",BUsuario.getIdUsuario(), "100", "", BUsuario.getCargo()+" / "+BUsuario.getNombre());
                      
      		boolean bActualizarAvance	=	ActualizaInstrucciones.avanceInstruccionPadre(strIdInstruccion, "100",strEstatus, "",fechaTerminacionReal.toString(),BUsuario.getIdUsuario());
      
                  if(strTipoAtencion.equals("0")){
          		//**Calculo Avance General
          		CalculoAvance cAvance = new CalculoAvance();
          		cAvance.calculoAvance(strIdAsunto, strIdInstruccion);
          		//**Fin Calculo Avance General
                  }
                      strEstatus = "4";
      //		response.sendRedirect("PortalTerminado.jsp");
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
              
      	bTieneHijos = ActualizaInstrucciones.getTieneHijos(strIdInstruccion);
      	if(( BUsuario.getIdUsuario().equals(strUsuarioOriginal) || bAsistente || bCadena || (BUsuario.getIdArea().equals(ActualizaUsuario.getAreaUsuario(strUsuarioOriginal)) && (BUsuario.getSupervisor()||BUsuario.getTurnado())))&&esPropietario)
                              BEscritura.setValue(true);
              else
                              BEscritura.setValue(false);
                  
      	//*Solo turnador y supervisor
      	if(( BUsuario.getIdUsuario().equals(strUsuarioOriginal) || bAsistente || bCadena ||BUsuario.getTurnado()|| BUsuario.getIdUsuario().equals(strTurno) || ActualizaInstrucciones.getSupervisorEsArea(strUsuarioOriginal, BUsuario.getIdUsuario(), BUsuario.getSupervisor()))&&esPropietario)
      			BEscrituraTur.setValue(true);
      	else
      			BEscrituraTur.setValue(false);
      //	
      	if(( BUsuario.getIdUsuario().equals(strTurnadoPor) || BUsuario.getIdUsuario().equals(strTurno) || bAsistente || BUsuario.getTurnado())&&esPropietario)
      			BEscritura1.setValue(true);
      	else
      			BEscritura1.setValue(false);
      //	
      	if(( BUsuario.getIdUsuario().equals(strUsuarioOriginal) || BUsuario.getTurnado() || bAsistente || bCadena || BUsuario.getIdUsuario().equals(strTurno))&&esPropietario)
      			BEscritura2.setValue(true);
              else    
      			BEscritura2.setValue(false);
                              
      	if(( BUsuario.getTurnado() || BUsuario.getIdUsuario().equals(strUsuarioOriginal) || BUsuario.getIdUsuario().equals(strTurno) || bAsistente || bCadena ||(BUsuario.getIdArea().equals(ActualizaUsuario.getAreaUsuario(strUsuarioOriginal)) && BUsuario.getSupervisor()))&&esPropietario)
                              BEscrituraAr.setValue(true);
      	else
                              BEscrituraAr.setValue(false);
      	
      	boolean bTieneAcceso = false;
      	if(strIH.length()!=0){
      		String str[][] = ActualizaInstrucciones.getPermiso(strIH);
      		if(str[0][1].equals(strIdInstruccion)){
      			if(str[0][0].equals("1"))
      				bTieneAcceso = true;
      		}
      	}
      
      	int t = 0;
      	
      	boolean noPuedeVerVentanillas=AsuntoVerifica.noPuedeUaVerVentanillas(session.getServletContext(),BUsuario.getIdArea());// acceso por parámetro
      	
      	//**Verifica si el usuario tiene subordinados
      	strSubordinado = ActualizaUsuario.getSubordinados(strUsuarioOriginal);
      	boolean bTieneSubordinados = false;
      	if(strSubordinado.length!=0)
      		bTieneSubordinados = true;
      	else
      		bTieneSubordinados = false;
      
          //Control de acceso según sea el perfil del usuario.//
          
         // System.out.println("uno="+strHabilitado.equals("1") +" y "+ BUsuario.getIdArea().equals(strIdArea));
         // System.out.println("dos="+BUsuario.getIdUsuario().equals(strTurnadoPor));
          //System.out.println("tres="+BUsuario.getIdUsuario().equals(strTurno));
          //System.out.println("cuatro="+BUsuario.getIdUsuario().equals(strIdUsuario));
          //System.out.println("cinco="+BUsuario.getTurnado());
          //System.out.println("seis="+bAsistente);
          //System.out.println("siete="+BUsuario.getIdUsuario().equals(strIdJefe));
          
          //System.out.println("ocho="+bCadena);
          //System.out.println("neuve="+accesoAsistente);
          //System.out.println("diez="+bAccesoRutaAtencion);
          //System.out.println("once="+ActualizaInstrucciones.getSupervisorEsArea(strUsuarioOriginal,BUsuario.getIdUsuario(), BUsuario.getSupervisor()));
          //System.out.println("doce="+!noPuedeVerVentanillas);
          
          
          
      	if(
      			strHabilitado.equals("1") && 
      			(				
      				BUsuario.getIdUsuario().equals(strTurnadoPor) ||
      				BUsuario.getIdUsuario().equals(strTurno) ||
      				BUsuario.getIdUsuario().equals(strIdUsuario) ||
      				(
      					BUsuario.getIdArea().equals(strIdArea) ||
      			        BUsuario.getTurnado()||				
      					bAsistente ||
      					BUsuario.getIdUsuario().equals(strIdJefe) ||
      					bCadena || 
      					accesoAsistente || //bTieneAcceso || 
      					bAccesoRutaAtencion ||
      					ActualizaInstrucciones.getSupervisorEsArea(strUsuarioOriginal,BUsuario.getIdUsuario(), BUsuario.getSupervisor())
      				)
      				&& !(noPuedeVerVentanillas)
      			)
      		)
      	{
      	}else{
      
      out.write(__oracle_jsp_text[16]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[17]);
       } 
      out.write(__oracle_jsp_text[18]);
      out.write(__oracle_jsp_text[19]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[20]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[21]);
      out.print(retURI);
      out.write(__oracle_jsp_text[22]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[23]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[24]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[25]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[26]);
      out.print(strUsuarioOriginal);
      out.write(__oracle_jsp_text[27]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[28]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[29]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[30]);
      out.print(strTurnadoPor);
      out.write(__oracle_jsp_text[31]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[32]);
      out.print(strNombreInstruccion);
      out.write(__oracle_jsp_text[33]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[34]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp));
      out.write(__oracle_jsp_text[35]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(retURI));
      out.write(__oracle_jsp_text[36]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[37]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[38]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[39]);
      out.print(strUsuarioOriginal);
      out.write(__oracle_jsp_text[40]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[41]);
      out.print( Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[42]);
      out.print(Utilerias.codificaPostHTML(retURI));
      out.write(__oracle_jsp_text[43]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[44]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[45]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[46]);
      out.print(strUsuarioOriginal);
      out.write(__oracle_jsp_text[47]);
      out.print(bEstanVacias);
      out.write(__oracle_jsp_text[48]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[49]);
      out.print(strTurno);
      out.write(__oracle_jsp_text[50]);
      out.print(strNombreInstruccion);
      out.write(__oracle_jsp_text[51]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[52]);
      out.print( Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[53]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[54]);
      out.print(strTurno);
      out.write(__oracle_jsp_text[55]);
      out.print(strNombreInstruccion);
      out.write(__oracle_jsp_text[56]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[57]);
      out.print(Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH));
      out.write(__oracle_jsp_text[58]);
      out.print(Utilerias.codificaPostHTML(retURI));
      out.write(__oracle_jsp_text[59]);
      out.print(strFolioRecepcion);
      out.write(__oracle_jsp_text[60]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[61]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[62]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[63]);
      out.print( Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[64]);
      out.print( serverContentManager );
      out.write(__oracle_jsp_text[65]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[66]);
      out.print(strItemType);
      out.write(__oracle_jsp_text[67]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[68]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[69]);
      out.print(strTurno);
      out.write(__oracle_jsp_text[70]);
      out.print(iTieneFechaCambio);
      out.write(__oracle_jsp_text[71]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[72]);
      out.print( Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[73]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[74]);
      out.print( strIdInstruccion );
      out.write(__oracle_jsp_text[75]);
      out.print(URL);
      out.write(__oracle_jsp_text[76]);
      out.print(Utilerias.codificaPostHTML(retURI));
      out.write(__oracle_jsp_text[77]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[78]);
      out.print( strIdInstruccion );
      out.write(__oracle_jsp_text[79]);
      out.print(Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)));
      out.write(__oracle_jsp_text[80]);
      out.print(strUsuarioOriginal);
      out.write(__oracle_jsp_text[81]);
       if(strActivarCM.equals("si")){ 
      out.write(__oracle_jsp_text[82]);
      out.print( serverContentManager );
      out.write(__oracle_jsp_text[83]);
      out.print(strItemType);
      out.write(__oracle_jsp_text[84]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[85]);
      out.print("SinFilio");
      out.write(__oracle_jsp_text[86]);
      out.print(BUsuario.getNombre());
      out.write(__oracle_jsp_text[87]);
      }else{
      out.write(__oracle_jsp_text[88]);
      out.print(server);
      out.print(strBase);
      out.write(__oracle_jsp_text[89]);
      out.print(strItemType);
      out.write(__oracle_jsp_text[90]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[91]);
      out.print("SinFolio");
      out.write(__oracle_jsp_text[92]);
      out.print(BUsuario.getIdUsuario());
      out.write(__oracle_jsp_text[93]);
      }
      out.write(__oracle_jsp_text[94]);
      out.print( strIdInstruccion );
      out.write(__oracle_jsp_text[95]);
      out.print(retURI);
      out.write(__oracle_jsp_text[96]);
      out.print(retURI2);
      out.write(__oracle_jsp_text[97]);
      out.print(strDif);
      out.write(__oracle_jsp_text[98]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[99]);
      if(strBandera1.equals("1")){
      out.write(__oracle_jsp_text[100]);
       if(strEstatus.equals("1")){ 
      out.write(__oracle_jsp_text[101]);
       }else if(strEstatus.equals("2")){ 
      out.write(__oracle_jsp_text[102]);
       }else if(strEstatus.equals("3")){ 
      out.write(__oracle_jsp_text[103]);
       }else if(strEstatus.equals("4")){ 
      out.write(__oracle_jsp_text[104]);
       } 
      out.write(__oracle_jsp_text[105]);
       }else{ 
      out.write(__oracle_jsp_text[106]);
       if(strEstatus.equals("1")){ 
      out.write(__oracle_jsp_text[107]);
       }else if(strEstatus.equals("2")){ 
      out.write(__oracle_jsp_text[108]);
       }else if(strEstatus.equals("3")){ 
      out.write(__oracle_jsp_text[109]);
       }else if(strEstatus.equals("4")){ 
      out.write(__oracle_jsp_text[110]);
       } 
      out.write(__oracle_jsp_text[111]);
       } 
      out.write(__oracle_jsp_text[112]);
      out.print(retURI);
      out.write(__oracle_jsp_text[113]);
      if(strTipoAtencion.equals("1")){
      out.write(__oracle_jsp_text[114]);
      if(strEstatus.equals("1") || strEstatus.equals("2")){
      out.write(__oracle_jsp_text[115]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_1=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_1.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[116]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_2=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[117]);
                  if(!strEstatus.equals("1")){
                  out.write(__oracle_jsp_text[118]);
                  out.print(strIdInstruccion);
                  out.write(__oracle_jsp_text[119]);
                  out.print(strIdAsunto);
                  out.write(__oracle_jsp_text[120]);
                  out.print(strEstatus);
                  out.write(__oracle_jsp_text[121]);
                  out.print(strAvance);
                  out.write(__oracle_jsp_text[122]);
                  out.print(strUsuarioOriginal);
                  out.write(__oracle_jsp_text[123]);
                  out.print( strEstValidacion );
                  out.write(__oracle_jsp_text[124]);
                  out.print( Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
                  out.write(__oracle_jsp_text[125]);
                  }
                  out.write(__oracle_jsp_text[126]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[127]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[128]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_3=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_3.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[129]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_4=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_4.setParent(__jsp_taghandler_3);
              __jsp_taghandler_4.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[130]);
                  if(strInsHijos.length == 0){
                  out.write(__oracle_jsp_text[131]);
                  if(bTieneSubordinados){
                  out.write(__oracle_jsp_text[132]);
                  }
                  out.write(__oracle_jsp_text[133]);
                  }
                  out.write(__oracle_jsp_text[134]);
                } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[135]);
          } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[136]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_5=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_5.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[137]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_6=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_6.setParent(__jsp_taghandler_5);
              __jsp_taghandler_6.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraAr.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[138]);
                } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[139]);
          } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[140]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_7=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_7.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[141]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_8=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_8.setParent(__jsp_taghandler_7);
              __jsp_taghandler_8.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[142]);
                } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[143]);
          } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      out.write(__oracle_jsp_text[144]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_9=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_9.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[145]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_10=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_10.setParent(__jsp_taghandler_9);
              __jsp_taghandler_10.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[146]);
                   if(strInsHijos.length == 0){ 
                  out.write(__oracle_jsp_text[147]);
                  }else if(strInsHijos.length>0 && sumEstatus == 0){
                  out.write(__oracle_jsp_text[148]);
                  if(strBandera1.equals("1")){ 
                  out.write(__oracle_jsp_text[149]);
                  }else{ 
                  out.write(__oracle_jsp_text[150]);
                  } 
                  out.write(__oracle_jsp_text[151]);
                  }else if(estatusHijos.length() > 0 && sumEstatus > 0){
                  out.write(__oracle_jsp_text[152]);
                  if(ActualizaInstrucciones.getTieneHijosPorTurnar(strIdInstruccion)){
                  out.write(__oracle_jsp_text[153]);
                  }
                  out.write(__oracle_jsp_text[154]);
                  }
                  out.write(__oracle_jsp_text[155]);
                } while (__jsp_taghandler_10.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,2);
            }
            out.write(__oracle_jsp_text[156]);
          } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,1);
      }
      out.write(__oracle_jsp_text[157]);
      }else{
      out.write(__oracle_jsp_text[158]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_11=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_11.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[159]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_12=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_12.setParent(__jsp_taghandler_11);
              __jsp_taghandler_12.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[160]);
                } while (__jsp_taghandler_12.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
            }
            out.write(__oracle_jsp_text[161]);
          } while (__jsp_taghandler_11.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,1);
      }
      out.write(__oracle_jsp_text[162]);
      }
      out.write(__oracle_jsp_text[163]);
      }else{
      out.write(__oracle_jsp_text[164]);
      if(strEstatus.equals("4")){ 
      out.write(__oracle_jsp_text[165]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_13=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_13.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[166]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_14=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_14.setParent(__jsp_taghandler_13);
              __jsp_taghandler_14.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[167]);
                } while (__jsp_taghandler_14.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,2);
            }
            out.write(__oracle_jsp_text[168]);
          } while (__jsp_taghandler_13.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,1);
      }
      out.write(__oracle_jsp_text[169]);
      }
      out.write(__oracle_jsp_text[170]);
       if(!bhijosTurnados){ 
      out.write(__oracle_jsp_text[171]);
       if(strEstatus.equals("1")){ 
      out.write(__oracle_jsp_text[172]);
       if(!bTieneHijos){ 
      out.write(__oracle_jsp_text[173]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_15=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_15.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[174]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_16=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_16.setParent(__jsp_taghandler_15);
              __jsp_taghandler_16.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[175]);
                  if(strBandera1.equals("0")){
                  out.write(__oracle_jsp_text[176]);
                  out.print(strIdInstruccion);
                  out.write(__oracle_jsp_text[177]);
                  out.print(strIdAsunto);
                  out.write(__oracle_jsp_text[178]);
                  out.print(strEstatus);
                  out.write(__oracle_jsp_text[179]);
                  out.print(strAvance);
                  out.write(__oracle_jsp_text[180]);
                  out.print(strUsuarioOriginal);
                  out.write(__oracle_jsp_text[181]);
                  out.print( strEstValidacion );
                  out.write(__oracle_jsp_text[182]);
                  out.print( Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
                  out.write(__oracle_jsp_text[183]);
                  }
                  out.write(__oracle_jsp_text[184]);
                } while (__jsp_taghandler_16.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,2);
            }
            out.write(__oracle_jsp_text[185]);
          } while (__jsp_taghandler_15.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,1);
      }
      out.write(__oracle_jsp_text[186]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_17=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_17.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[187]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_18=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_18.setParent(__jsp_taghandler_17);
              __jsp_taghandler_18.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[188]);
                  if(strBandera1.equals("0")){
                  out.write(__oracle_jsp_text[189]);
                  if(bTieneSubordinados){
                  out.write(__oracle_jsp_text[190]);
                  }
                  out.write(__oracle_jsp_text[191]);
                  }
                  out.write(__oracle_jsp_text[192]);
                } while (__jsp_taghandler_18.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,2);
            }
            out.write(__oracle_jsp_text[193]);
          } while (__jsp_taghandler_17.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,1);
      }
      out.write(__oracle_jsp_text[194]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_19=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_19.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[195]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_20=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_20.setParent(__jsp_taghandler_19);
              __jsp_taghandler_20.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[196]);
                  if(strBandera1.equals("0")){
                  out.write(__oracle_jsp_text[197]);
                  if(bTieneSubordinados){
                  out.write(__oracle_jsp_text[198]);
                  }
                  out.write(__oracle_jsp_text[199]);
                  }
                  out.write(__oracle_jsp_text[200]);
                } while (__jsp_taghandler_20.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,2);
            }
            out.write(__oracle_jsp_text[201]);
          } while (__jsp_taghandler_19.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,1);
      }
      out.write(__oracle_jsp_text[202]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_21=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_21.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[203]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_22=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_22.setParent(__jsp_taghandler_21);
              __jsp_taghandler_22.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[204]);
                  if(strBandera1.equals("0")){
                  out.write(__oracle_jsp_text[205]);
                  if(strPadre.length() == 0){
                  out.write(__oracle_jsp_text[206]);
                  }
                  out.write(__oracle_jsp_text[207]);
                  }
                  out.write(__oracle_jsp_text[208]);
                } while (__jsp_taghandler_22.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,2);
            }
            out.write(__oracle_jsp_text[209]);
          } while (__jsp_taghandler_21.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,1);
      }
      out.write(__oracle_jsp_text[210]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_23=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_23.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[211]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_24=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_24.setParent(__jsp_taghandler_23);
              __jsp_taghandler_24.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraAr.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[212]);
                } while (__jsp_taghandler_24.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,2);
            }
            out.write(__oracle_jsp_text[213]);
          } while (__jsp_taghandler_23.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,1);
      }
      out.write(__oracle_jsp_text[214]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_25=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_25.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[215]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_26=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_26.setParent(__jsp_taghandler_25);
              __jsp_taghandler_26.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura2.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[216]);
                  if(strBandera1.equals("0")){
                  out.write(__oracle_jsp_text[217]);
                   if(!bTieneTramite && iTieneFechaCambio == 2){ 
                  out.write(__oracle_jsp_text[218]);
                   }else if(!bTieneTramite && iTieneFechaCambio == 1){ 
                  out.write(__oracle_jsp_text[219]);
                   } 
                  out.write(__oracle_jsp_text[220]);
                  }
                  out.write(__oracle_jsp_text[221]);
                } while (__jsp_taghandler_26.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,2);
            }
            out.write(__oracle_jsp_text[222]);
          } while (__jsp_taghandler_25.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,1);
      }
      out.write(__oracle_jsp_text[223]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_27=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_27.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[224]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_28=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_28.setParent(__jsp_taghandler_27);
              __jsp_taghandler_28.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[225]);
                } while (__jsp_taghandler_28.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,2);
            }
            out.write(__oracle_jsp_text[226]);
          } while (__jsp_taghandler_27.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,1);
      }
      out.write(__oracle_jsp_text[227]);
      if(strBandera1.equals("1")){
      out.write(__oracle_jsp_text[228]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_29=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_29.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[229]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_30=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_30.setParent(__jsp_taghandler_29);
              __jsp_taghandler_30.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_30.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[230]);
                } while (__jsp_taghandler_30.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_30.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_30,2);
            }
            out.write(__oracle_jsp_text[231]);
          } while (__jsp_taghandler_29.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,1);
      }
      out.write(__oracle_jsp_text[232]);
      }
      out.write(__oracle_jsp_text[233]);
      if(bTieneSubordinados){
      out.write(__oracle_jsp_text[234]);
       if(strEstatus.equals("1") || strEstatus.equals("2") || strEstatus.equals("3")){ 
      out.write(__oracle_jsp_text[235]);
       if(strInsHijos.length == 0){ 
      out.write(__oracle_jsp_text[236]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_31=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_31.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_31.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[237]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_32=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_32.setParent(__jsp_taghandler_31);
              __jsp_taghandler_32.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_32.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[238]);
                  if(strBandera1.equals("0")){
                  out.write(__oracle_jsp_text[239]);
                  out.write(__oracle_jsp_text[240]);
                  }else{
                  out.write(__oracle_jsp_text[241]);
                  out.write(__oracle_jsp_text[242]);
                  }
                  out.write(__oracle_jsp_text[243]);
                } while (__jsp_taghandler_32.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_32.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_32,2);
            }
            out.write(__oracle_jsp_text[244]);
          } while (__jsp_taghandler_31.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_31.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_31,1);
      }
      out.write(__oracle_jsp_text[245]);
       }else if(estatusHijos.length() > 0 && sumEstatus > 0){ 
      out.write(__oracle_jsp_text[246]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_33=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_33.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_33.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[247]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_34=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_34.setParent(__jsp_taghandler_33);
              __jsp_taghandler_34.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_34.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[248]);
                } while (__jsp_taghandler_34.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_34.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_34,2);
            }
            out.write(__oracle_jsp_text[249]);
          } while (__jsp_taghandler_33.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_33.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_33,1);
      }
      out.write(__oracle_jsp_text[250]);
       } 
      out.write(__oracle_jsp_text[251]);
      }
      out.write(__oracle_jsp_text[252]);
      }
      out.write(__oracle_jsp_text[253]);
      out.write(__oracle_jsp_text[254]);
       }else{ 
      out.write(__oracle_jsp_text[255]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_35=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_35.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_35.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[256]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_36=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_36.setParent(__jsp_taghandler_35);
              __jsp_taghandler_36.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraAr.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_36.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[257]);
                } while (__jsp_taghandler_36.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_36.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_36,2);
            }
            out.write(__oracle_jsp_text[258]);
          } while (__jsp_taghandler_35.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_35.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_35,1);
      }
      out.write(__oracle_jsp_text[259]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_37=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_37.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_37.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[260]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_38=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_38.setParent(__jsp_taghandler_37);
              __jsp_taghandler_38.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_38.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[261]);
                } while (__jsp_taghandler_38.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_38.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_38,2);
            }
            out.write(__oracle_jsp_text[262]);
          } while (__jsp_taghandler_37.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_37.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_37,1);
      }
      out.write(__oracle_jsp_text[263]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_39=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_39.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_39.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[264]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_40=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_40.setParent(__jsp_taghandler_39);
              __jsp_taghandler_40.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_40.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[265]);
                  if(strBandera1.equals("0")){
                  out.write(__oracle_jsp_text[266]);
                  out.write(__oracle_jsp_text[267]);
                  }else{
                  out.write(__oracle_jsp_text[268]);
                  
                  					boolean bVacios=false;
                  					bVacios=ActualizaInstrucciones.getInstruccionHijasVacias(strIdInstruccion);
                  				
                  out.write(__oracle_jsp_text[269]);
                  out.write(__oracle_jsp_text[270]);
                  if(!bVacios){
                  out.write(__oracle_jsp_text[271]);
                  }
                  out.write(__oracle_jsp_text[272]);
                  }
                  out.write(__oracle_jsp_text[273]);
                } while (__jsp_taghandler_40.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_40.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_40,2);
            }
            out.write(__oracle_jsp_text[274]);
          } while (__jsp_taghandler_39.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_39.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_39,1);
      }
      out.write(__oracle_jsp_text[275]);
      }
      out.write(__oracle_jsp_text[276]);
       }else if(strEstatus.equals("2") && strDelegado.length() == 0){ 
      out.write(__oracle_jsp_text[277]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_41=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_41.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_41.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[278]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_42=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_42.setParent(__jsp_taghandler_41);
              __jsp_taghandler_42.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_42.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[279]);
                  out.print(strIdInstruccion);
                  out.write(__oracle_jsp_text[280]);
                  out.print(strIdAsunto);
                  out.write(__oracle_jsp_text[281]);
                  out.print(strEstatus);
                  out.write(__oracle_jsp_text[282]);
                  out.print(strAvance);
                  out.write(__oracle_jsp_text[283]);
                  out.print(strUsuarioOriginal);
                  out.write(__oracle_jsp_text[284]);
                  out.print( strEstValidacion );
                  out.write(__oracle_jsp_text[285]);
                  out.print( Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
                  out.write(__oracle_jsp_text[286]);
                } while (__jsp_taghandler_42.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_42.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_42,2);
            }
            out.write(__oracle_jsp_text[287]);
          } while (__jsp_taghandler_41.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_41.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_41,1);
      }
      out.write(__oracle_jsp_text[288]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_43=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_43.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_43.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[289]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_44=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_44.setParent(__jsp_taghandler_43);
              __jsp_taghandler_44.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_44.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[290]);
                  if(bTieneSubordinados){
                  out.write(__oracle_jsp_text[291]);
                  }
                  out.write(__oracle_jsp_text[292]);
                } while (__jsp_taghandler_44.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_44.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_44,2);
            }
            out.write(__oracle_jsp_text[293]);
          } while (__jsp_taghandler_43.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_43.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_43,1);
      }
      out.write(__oracle_jsp_text[294]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_45=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_45.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_45.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[295]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_46=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_46.setParent(__jsp_taghandler_45);
              __jsp_taghandler_46.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_46.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[296]);
                  if(bTieneSubordinados){
                  out.write(__oracle_jsp_text[297]);
                  }
                  out.write(__oracle_jsp_text[298]);
                } while (__jsp_taghandler_46.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_46.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_46,2);
            }
            out.write(__oracle_jsp_text[299]);
          } while (__jsp_taghandler_45.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_45.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_45,1);
      }
      out.write(__oracle_jsp_text[300]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_47=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_47.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_47.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[301]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_48=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_48.setParent(__jsp_taghandler_47);
              __jsp_taghandler_48.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraAr.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_48.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[302]);
                } while (__jsp_taghandler_48.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_48.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_48,2);
            }
            out.write(__oracle_jsp_text[303]);
          } while (__jsp_taghandler_47.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_47.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_47,1);
      }
      out.write(__oracle_jsp_text[304]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_49=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_49.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_49.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[305]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_50=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_50.setParent(__jsp_taghandler_49);
              __jsp_taghandler_50.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura2.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_50.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[306]);
                   if(!bTieneTramite && iTieneFechaCambio == 2){ 
                  out.write(__oracle_jsp_text[307]);
                   }else if(!bTieneTramite && iTieneFechaCambio == 1){ 
                  out.write(__oracle_jsp_text[308]);
                   } 
                  out.write(__oracle_jsp_text[309]);
                } while (__jsp_taghandler_50.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_50.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_50,2);
            }
            out.write(__oracle_jsp_text[310]);
          } while (__jsp_taghandler_49.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_49.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_49,1);
      }
      out.write(__oracle_jsp_text[311]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_51=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_51.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_51.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[312]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_52=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_52.setParent(__jsp_taghandler_51);
              __jsp_taghandler_52.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_52.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[313]);
                } while (__jsp_taghandler_52.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_52.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_52,2);
            }
            out.write(__oracle_jsp_text[314]);
          } while (__jsp_taghandler_51.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_51.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_51,1);
      }
      out.write(__oracle_jsp_text[315]);
      if(bTieneSubordinados){
      out.write(__oracle_jsp_text[316]);
       if(strInsHijos.length == 0){ 
      out.write(__oracle_jsp_text[317]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_53=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_53.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_53.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[318]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_54=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_54.setParent(__jsp_taghandler_53);
              __jsp_taghandler_54.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_54.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[319]);
                } while (__jsp_taghandler_54.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_54.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_54,2);
            }
            out.write(__oracle_jsp_text[320]);
          } while (__jsp_taghandler_53.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_53.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_53,1);
      }
      out.write(__oracle_jsp_text[321]);
       }else if(estatusHijos.length() > 0 && sumEstatus > 0){ 
      out.write(__oracle_jsp_text[322]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_55=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_55.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_55.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[323]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_56=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_56.setParent(__jsp_taghandler_55);
              __jsp_taghandler_56.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_56.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[324]);
                } while (__jsp_taghandler_56.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_56.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_56,2);
            }
            out.write(__oracle_jsp_text[325]);
          } while (__jsp_taghandler_55.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_55.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_55,1);
      }
      out.write(__oracle_jsp_text[326]);
       }else if(strInsHijos.length > 0){ 
      out.write(__oracle_jsp_text[327]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_57=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_57.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_57.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[328]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_58=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_58.setParent(__jsp_taghandler_57);
              __jsp_taghandler_58.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_58.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[329]);
                } while (__jsp_taghandler_58.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_58.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_58,2);
            }
            out.write(__oracle_jsp_text[330]);
          } while (__jsp_taghandler_57.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_57.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_57,1);
      }
      out.write(__oracle_jsp_text[331]);
      }
      out.write(__oracle_jsp_text[332]);
      }
      out.write(__oracle_jsp_text[333]);
       }else if(strEstatus.equals("3")){ 
      out.write(__oracle_jsp_text[334]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_59=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_59.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_59.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[335]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_60=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_60.setParent(__jsp_taghandler_59);
              __jsp_taghandler_60.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura1.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_60.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[336]);
                  
                  				boolean tiene = false;
                  				strSubordinado = ActualizaUsuario.getSubordinados(strTurno);
                  				if(strSubordinado.length!=0)
                  					tiene = true;
                  				else
                  					tiene = false;
                  				//Checar caso de insidencia
                                                  
                  				if(tiene){
                  out.write(__oracle_jsp_text[337]);
                  }
                  out.write(__oracle_jsp_text[338]);
                   if(!strTipoAtencion.equals("1")){ 
                  out.write(__oracle_jsp_text[339]);
                   } 
                  out.write(__oracle_jsp_text[340]);
                } while (__jsp_taghandler_60.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_60.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_60,2);
            }
            out.write(__oracle_jsp_text[341]);
          } while (__jsp_taghandler_59.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_59.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_59,1);
      }
      out.write(__oracle_jsp_text[342]);
       }else if(strEstatus.equals("4")){ 
      out.write(__oracle_jsp_text[343]);
       }else if(strEstatus.equals("2") && strDelegado.length() > 0){ 
      out.write(__oracle_jsp_text[344]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_61=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_61.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_61.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[345]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_62=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_62.setParent(__jsp_taghandler_61);
              __jsp_taghandler_62.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_62.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[346]);
                  out.print(strIdInstruccion);
                  out.write(__oracle_jsp_text[347]);
                  out.print(strIdAsunto);
                  out.write(__oracle_jsp_text[348]);
                  out.print(strEstatus);
                  out.write(__oracle_jsp_text[349]);
                  out.print(strAvance);
                  out.write(__oracle_jsp_text[350]);
                  out.print(strUsuarioOriginal);
                  out.write(__oracle_jsp_text[351]);
                  out.print( strEstValidacion );
                  out.write(__oracle_jsp_text[352]);
                  out.print( Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
                  out.write(__oracle_jsp_text[353]);
                } while (__jsp_taghandler_62.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_62.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_62,2);
            }
            out.write(__oracle_jsp_text[354]);
          } while (__jsp_taghandler_61.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_61.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_61,1);
      }
      out.write(__oracle_jsp_text[355]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_63=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_63.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_63.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[356]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_64=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_64.setParent(__jsp_taghandler_63);
              __jsp_taghandler_64.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_64.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[357]);
                } while (__jsp_taghandler_64.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_64.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_64,2);
            }
            out.write(__oracle_jsp_text[358]);
          } while (__jsp_taghandler_63.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_63.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_63,1);
      }
      out.write(__oracle_jsp_text[359]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_65=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_65.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_65.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[360]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_66=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_66.setParent(__jsp_taghandler_65);
              __jsp_taghandler_66.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_66.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[361]);
                } while (__jsp_taghandler_66.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_66.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_66,2);
            }
            out.write(__oracle_jsp_text[362]);
          } while (__jsp_taghandler_65.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_65.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_65,1);
      }
      out.write(__oracle_jsp_text[363]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_67=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_67.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_67.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[364]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_68=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_68.setParent(__jsp_taghandler_67);
              __jsp_taghandler_68.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraAr.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_68.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[365]);
                } while (__jsp_taghandler_68.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_68.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_68,2);
            }
            out.write(__oracle_jsp_text[366]);
          } while (__jsp_taghandler_67.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_67.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_67,1);
      }
      out.write(__oracle_jsp_text[367]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_69=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_69.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_69.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[368]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_70=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_70.setParent(__jsp_taghandler_69);
              __jsp_taghandler_70.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura2.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_70.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[369]);
                   if(!bTieneTramite){ 
                  out.write(__oracle_jsp_text[370]);
                   } 
                  out.write(__oracle_jsp_text[371]);
                } while (__jsp_taghandler_70.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_70.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_70,2);
            }
            out.write(__oracle_jsp_text[372]);
          } while (__jsp_taghandler_69.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_69.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_69,1);
      }
      out.write(__oracle_jsp_text[373]);
       } 
      out.write(__oracle_jsp_text[374]);
      out.write(__oracle_jsp_text[375]);
       }else{ 
      out.write(__oracle_jsp_text[376]);
      
      			int iTerminada = ActualizaInstrucciones.getInstruccionesTerminadas(strIdInstruccion);
      			float fAvance = new Float(strAvance).floatValue();
      		
      out.write(__oracle_jsp_text[377]);
      if(fAvance <100 && iTerminada==0){
      out.write(__oracle_jsp_text[378]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_71=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_71.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_71.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[379]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_72=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_72.setParent(__jsp_taghandler_71);
              __jsp_taghandler_72.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_72.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[380]);
                  out.print(strIdInstruccion);
                  out.write(__oracle_jsp_text[381]);
                  out.print(strIdAsunto);
                  out.write(__oracle_jsp_text[382]);
                  out.print(strEstatus);
                  out.write(__oracle_jsp_text[383]);
                  out.print(strAvance);
                  out.write(__oracle_jsp_text[384]);
                  out.print(strUsuarioOriginal);
                  out.write(__oracle_jsp_text[385]);
                  out.print( strEstValidacion );
                  out.write(__oracle_jsp_text[386]);
                  out.print( Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
                  out.write(__oracle_jsp_text[387]);
                } while (__jsp_taghandler_72.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_72.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_72,2);
            }
            out.write(__oracle_jsp_text[388]);
          } while (__jsp_taghandler_71.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_71.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_71,1);
      }
      out.write(__oracle_jsp_text[389]);
       } 
      out.write(__oracle_jsp_text[390]);
      if(!(fAvance >= 100)){
      out.write(__oracle_jsp_text[391]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_73=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_73.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_73.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[392]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_74=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_74.setParent(__jsp_taghandler_73);
              __jsp_taghandler_74.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraAr.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_74.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[393]);
                } while (__jsp_taghandler_74.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_74.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_74,2);
            }
            out.write(__oracle_jsp_text[394]);
          } while (__jsp_taghandler_73.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_73.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_73,1);
      }
      out.write(__oracle_jsp_text[395]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_75=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_75.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_75.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[396]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_76=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_76.setParent(__jsp_taghandler_75);
              __jsp_taghandler_76.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_76.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[397]);
                  if(strBandera1.equals("0")){
                  out.write(__oracle_jsp_text[398]);
                  if(ActualizaInstrucciones.getTieneHijosPorTurnar(strIdInstruccion)){
                  out.write(__oracle_jsp_text[399]);
                  }
                  out.write(__oracle_jsp_text[400]);
                  }else{
                  out.write(__oracle_jsp_text[401]);
                  if(ActualizaInstrucciones.getTieneHijosPorTurnar(strIdInstruccion)){
                  out.write(__oracle_jsp_text[402]);
                  }
                  out.write(__oracle_jsp_text[403]);
                  }
                  out.write(__oracle_jsp_text[404]);
                } while (__jsp_taghandler_76.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_76.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_76,2);
            }
            out.write(__oracle_jsp_text[405]);
          } while (__jsp_taghandler_75.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_75.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_75,1);
      }
      out.write(__oracle_jsp_text[406]);
       } 
      out.write(__oracle_jsp_text[407]);
      }
      out.write(__oracle_jsp_text[408]);
      }
      out.write(__oracle_jsp_text[409]);
      if(iTieneFechaCambio==1){
      out.write(__oracle_jsp_text[410]);
      }
      out.write(__oracle_jsp_text[411]);
      out.print(strFolioTurnado);
      out.write(__oracle_jsp_text[412]);
      if(!strBandera1.equals("0")){
      out.write(__oracle_jsp_text[413]);
      out.print(strFolioEntrada);
      out.write(__oracle_jsp_text[414]);
      }
      out.write(__oracle_jsp_text[415]);
      if(!strBandera1.equals("1") && strEstatus.equals("3")) {
      out.write(__oracle_jsp_text[416]);
      out.print(ActualizaHistorial.getUsuarioRechazo(strIdInstruccion)[0][0]);
      out.write(__oracle_jsp_text[417]);
      }else if(strUsuarioTermino.length()==0){
      out.write(__oracle_jsp_text[418]);
      out.print(strCargo);
      out.write(__oracle_jsp_text[419]);
      }else{
      out.write(__oracle_jsp_text[420]);
      out.print(strUsuarioTermino);
      out.write(__oracle_jsp_text[421]);
      }
      out.write(__oracle_jsp_text[422]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[423]);
      out.print(strTelefono);
      out.write(__oracle_jsp_text[424]);
      out.print(strCorreo);
      out.write(__oracle_jsp_text[425]);
      out.print( strAtencion );
      out.write(__oracle_jsp_text[426]);
      out.print(strAtencion);
      out.write(__oracle_jsp_text[427]);
      out.print( strVerDocto );
      out.write(__oracle_jsp_text[428]);
      out.print(strVerDocto);
      out.write(__oracle_jsp_text[429]);
       if(strAcceso.equals("1")){ 
      out.write(__oracle_jsp_text[430]);
      if(strPadre.length()!=0){
      out.write(__oracle_jsp_text[431]);
      out.print( strPadre );
      out.write(__oracle_jsp_text[432]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[433]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[434]);
      }else{
      out.write(__oracle_jsp_text[435]);
      out.print( strIdAsunto );
      out.write(__oracle_jsp_text[436]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[437]);
      }
      out.write(__oracle_jsp_text[438]);
      }
      out.write(__oracle_jsp_text[439]);
      out.print( strAsunto );
      out.write(__oracle_jsp_text[440]);
      out.print(strAsunto);
      out.write(__oracle_jsp_text[441]);
      out.print(strPaso);
      out.write(__oracle_jsp_text[442]);
      out.print(strFecGeneracion);
      out.write(__oracle_jsp_text[443]);
      out.print(strFecGeneracion);
      out.write(__oracle_jsp_text[444]);
      out.print(strFecVencimiento);
      out.write(__oracle_jsp_text[445]);
      out.print(strFecVencimiento);
      out.write(__oracle_jsp_text[446]);
       if(strEstatus.equals("1")){
      out.write(__oracle_jsp_text[447]);
      }else if(strEstatus.equals("2")){
      out.write(__oracle_jsp_text[448]);
      }else if(strEstatus.equals("3")){
      out.write(__oracle_jsp_text[449]);
      }else if(strEstatus.equals("4")){
      out.write(__oracle_jsp_text[450]);
      }
      out.write(__oracle_jsp_text[451]);
       if(strDelegado.length() != 0){ 
      out.write(__oracle_jsp_text[452]);
       String delegadoA=ActualizaUsuario.NombreUsuario(strDelegado);
      out.write(__oracle_jsp_text[453]);
      out.print(delegadoA);
      out.write(__oracle_jsp_text[454]);
      out.print(delegadoA);
      out.write(__oracle_jsp_text[455]);
       }else{ 
      out.write(__oracle_jsp_text[456]);
       } 
      out.write(__oracle_jsp_text[457]);
      String turnadoPor=ActualizaUsuario.NombreUsuario(strTurno);
      out.print(turnadoPor);
      out.write(__oracle_jsp_text[458]);
      out.print(turnadoPor);
      out.write(__oracle_jsp_text[459]);
      out.print( strFolioRecepcion );
      out.write(__oracle_jsp_text[460]);
      out.print(strFolioRecepcion);
      out.write(__oracle_jsp_text[461]);
      out.print( strFolioIntermedio );
      out.write(__oracle_jsp_text[462]);
      out.print(strFolioIntermedio);
      out.write(__oracle_jsp_text[463]);
      out.print( strNombreInstruccion );
      out.write(__oracle_jsp_text[464]);
      out.print(strNombreInstruccion);
      out.write(__oracle_jsp_text[465]);
      out.print( strSintesis );
      out.write(__oracle_jsp_text[466]);
      out.print(strSintesis);
      out.write(__oracle_jsp_text[467]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[468]);
       if(tieneHijos){ 
      out.write(__oracle_jsp_text[469]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_77=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_77.setParent(null);
        __jsp_taghandler_77.setDatos(ActualizaInstrucciones.InstruccionPorIdInstruccion(strIdInstruccion));
        __jsp_taghandler_77.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_77.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_77,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[470]);
            t++;
            out.write(__oracle_jsp_text[471]);
            if(par(t)==true){
            out.write(__oracle_jsp_text[472]);
            }else{
            out.write(__oracle_jsp_text[473]);
            }
            out.write(__oracle_jsp_text[474]);
            if("1".equals(campo17)){
            out.write(__oracle_jsp_text[475]);
            }else{
            out.write(__oracle_jsp_text[476]);
            }
            out.write(__oracle_jsp_text[477]);
            out.print( campo13 );
            out.write(__oracle_jsp_text[478]);
            
            								String strterminoUs = ActualizaInstrucciones.getUsuarioTermino(campo12);
            								if(strterminoUs.length()==0){
            								
            out.write(__oracle_jsp_text[479]);
            out.print(campo20);
            out.write(__oracle_jsp_text[480]);
            }else{
            out.write(__oracle_jsp_text[481]);
            out.print(strterminoUs);
            out.write(__oracle_jsp_text[482]);
            }
            out.write(__oracle_jsp_text[483]);
            out.print( ActualizaArea.NombreArea(campo10) );
            out.write(__oracle_jsp_text[484]);
             if(campo3.length() == 0){ 
            out.write(__oracle_jsp_text[485]);
            out.print( campo8 );
            out.write(__oracle_jsp_text[486]);
             }else{ 
            out.write(__oracle_jsp_text[487]);
            out.print( ActualizaInst.getNombreInstruccion1(campo3) );
            out.write(__oracle_jsp_text[488]);
             } 
            out.write(__oracle_jsp_text[489]);
             if(campo5.length() == 0){ 
            out.write(__oracle_jsp_text[490]);
             }else{ 
            out.write(__oracle_jsp_text[491]);
            out.print( Utilerias.formatearFechas(campo4) );
            out.write(__oracle_jsp_text[492]);
             } 
            out.write(__oracle_jsp_text[493]);
             if(campo5.length() == 0){ 
            out.write(__oracle_jsp_text[494]);
             }else{ 
            out.write(__oracle_jsp_text[495]);
            out.print( Utilerias.formatearFechas(campo5) );
            out.write(__oracle_jsp_text[496]);
             } 
            out.write(__oracle_jsp_text[497]);
            out.print( campo14 );
            out.write(__oracle_jsp_text[498]);
            
            									boolean bExistenFechas = false;
            									bExistenFechas = ActualizaAsuntoTurnado.tieneFechas(campo15);
            									if(bExistenFechas){
            out.write(__oracle_jsp_text[499]);
            out.print( campo18 );
            out.write(__oracle_jsp_text[500]);
             }else{ 
            out.write(__oracle_jsp_text[501]);
             } 
            out.write(__oracle_jsp_text[502]);
            out.print( campo6 );
            out.write(__oracle_jsp_text[503]);
             if(campo7.equals("1")){ 
            out.write(__oracle_jsp_text[504]);
             if(campo17.equals("0")){ 
            out.write(__oracle_jsp_text[505]);
            out.print( campo12 );
            out.write(__oracle_jsp_text[506]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[507]);
             }else if(campo17.equals("1")){ 
            out.write(__oracle_jsp_text[508]);
            out.print( campo12 );
            out.write(__oracle_jsp_text[509]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[510]);
             } 
            out.write(__oracle_jsp_text[511]);
             }else if(campo7.equals("2")){ 
            out.write(__oracle_jsp_text[512]);
             if(campo17.equals("0")){ 
            out.write(__oracle_jsp_text[513]);
            out.print( campo12 );
            out.write(__oracle_jsp_text[514]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[515]);
             }else if(campo17.equals("1")){ 
            out.write(__oracle_jsp_text[516]);
            out.print( campo12 );
            out.write(__oracle_jsp_text[517]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[518]);
             } 
            out.write(__oracle_jsp_text[519]);
             }else if(campo7.equals("3")){ 
            out.write(__oracle_jsp_text[520]);
            out.print( campo12 );
            out.write(__oracle_jsp_text[521]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[522]);
             }else if(campo7.equals("4")){ 
            out.write(__oracle_jsp_text[523]);
             if(campo17.equals("0")){ 
            out.write(__oracle_jsp_text[524]);
            out.print( campo12 );
            out.write(__oracle_jsp_text[525]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[526]);
             }else if(campo17.equals("1")){ 
            out.write(__oracle_jsp_text[527]);
            out.print( campo12 );
            out.write(__oracle_jsp_text[528]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[529]);
             } 
            out.write(__oracle_jsp_text[530]);
             } 
            out.write(__oracle_jsp_text[531]);
            if("1".equals(campo19)){
            out.write(__oracle_jsp_text[532]);
            }else{
            out.write(__oracle_jsp_text[533]);
            }
            out.write(__oracle_jsp_text[534]);
          } while (__jsp_taghandler_77.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_77.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_77,1);
      }
      out.write(__oracle_jsp_text[535]);
       } 
      out.write(__oracle_jsp_text[536]);
       if(bHistorial){ 
      out.write(__oracle_jsp_text[537]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_78=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_78.setParent(null);
        __jsp_taghandler_78.setDatos(historialInstruccion);
        __jsp_taghandler_78.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_78.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_78,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[538]);
             if(campo7.equals("1")){ 
            out.write(__oracle_jsp_text[539]);
            out.print(campo3 );
            out.write(__oracle_jsp_text[540]);
            String avanceUsuario=campo8;
            out.write(__oracle_jsp_text[541]);
             if(campo6.equals("Actualización de la instruccion Padre")){ 
            out.write(__oracle_jsp_text[542]);
             }else{ 
            out.write(__oracle_jsp_text[543]);
            out.print( (campo8.indexOf(" / ")!=-1)?campo8:campo8+" / "+ActualizaUsuario.NombrePuesto(campo4) );
            out.write(__oracle_jsp_text[544]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[545]);
            out.print( strEstValidacion );
            out.write(__oracle_jsp_text[546]);
            out.print( Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[547]);
            out.print( campo5 );
            out.write(__oracle_jsp_text[548]);
            out.print(campo5);
            out.write(__oracle_jsp_text[549]);
             } 
            out.write(__oracle_jsp_text[550]);
             }else if(campo7.equals("2")){ 
            out.write(__oracle_jsp_text[551]);
            out.print(campo3);
            out.write(__oracle_jsp_text[552]);
            out.print( (campo8.indexOf(" / ")!=-1)?campo8:campo8+" / "+ActualizaUsuario.NombrePuesto(campo4) );
            out.write(__oracle_jsp_text[553]);
            out.print( campo6 );
            out.write(__oracle_jsp_text[554]);
             }else if(campo7.equals("3")){ 
            out.write(__oracle_jsp_text[555]);
            out.print(campo3);
            out.write(__oracle_jsp_text[556]);
            out.print( ActualizaInstrucciones.NombreUsuarioInstruccion(strIdInstruccion) );
            out.write(__oracle_jsp_text[557]);
            out.print( (campo8.indexOf(" / ")!=-1)?campo8:campo8+" / "+ActualizaUsuario.NombrePuesto(campo4) );
            out.write(__oracle_jsp_text[558]);
            out.print( campo6 );
            out.write(__oracle_jsp_text[559]);
             }else if(campo7.equals("4")){ 
            out.write(__oracle_jsp_text[560]);
            out.print(campo3);
            out.write(__oracle_jsp_text[561]);
            out.print(ActualizaUsuario.NombreUsuario(strDelegado));
            out.write(__oracle_jsp_text[562]);
            out.print( campo6 );
            out.write(__oracle_jsp_text[563]);
             } else if(campo7.equals("5")){
            out.write(__oracle_jsp_text[564]);
            out.print(campo3);
            out.write(__oracle_jsp_text[565]);
            out.print( (campo8.indexOf(" / ")!=-1)?campo8:campo8+" / "+ActualizaUsuario.NombrePuesto(campo4) );
            out.write(__oracle_jsp_text[566]);
             } else if(campo7.equals("6")){
            out.write(__oracle_jsp_text[567]);
            out.print(campo3);
            out.write(__oracle_jsp_text[568]);
            out.print(campo8);
            out.write(__oracle_jsp_text[569]);
            out.print(com.meve.sigma.util.Utilerias.cambioSaltosDeLinea(campo6));
            out.write(__oracle_jsp_text[570]);
            } else if(campo7.equals("7")){
            out.write(__oracle_jsp_text[571]);
            out.print(campo3);
            out.write(__oracle_jsp_text[572]);
            out.print(campo8);
            out.write(__oracle_jsp_text[573]);
            out.print(ActualizaUsuario.NombrePuesto(campo4));
            out.write(__oracle_jsp_text[574]);
            out.print(campo9);
            out.write(__oracle_jsp_text[575]);
            out.print(com.meve.sigma.util.Utilerias.cambioSaltosDeLinea(campo6));
            out.write(__oracle_jsp_text[576]);
            } else if(campo7.equals("8")){
            out.write(__oracle_jsp_text[577]);
            out.print(campo3);
            out.write(__oracle_jsp_text[578]);
            out.print(campo8);
            out.write(__oracle_jsp_text[579]);
            out.print(ActualizaUsuario.NombrePuesto(campo4));
            out.write(__oracle_jsp_text[580]);
            out.print(campo9);
            out.write(__oracle_jsp_text[581]);
            out.print(com.meve.sigma.util.Utilerias.cambioSaltosDeLinea(campo6));
            out.write(__oracle_jsp_text[582]);
            } else if(campo7.equals("9")){
            out.write(__oracle_jsp_text[583]);
            out.print(campo3);
            out.write(__oracle_jsp_text[584]);
            out.print(campo8);
            out.write(__oracle_jsp_text[585]);
            out.print(ActualizaUsuario.NombrePuesto(campo4));
            out.write(__oracle_jsp_text[586]);
            out.print(campo9);
            out.write(__oracle_jsp_text[587]);
            out.print(com.meve.sigma.util.Utilerias.cambioSaltosDeLinea(campo6));
            out.write(__oracle_jsp_text[588]);
            }
            out.write(__oracle_jsp_text[589]);
          } while (__jsp_taghandler_78.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_78.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_78,1);
      }
      out.write(__oracle_jsp_text[590]);
       }else{ 
      out.write(__oracle_jsp_text[591]);
       } 
      out.write(__oracle_jsp_text[592]);
       if(BUsuario.getIdUsuario().equals(strUsuarioOriginal) || 
      				  (BUsuario.getTurnado() && 
      				  BUsuario.getIdArea().equals(ActualizaUsuario.getAreaUsuario(strUsuarioOriginal)))){ 
      out.write(__oracle_jsp_text[593]);
       if(strActivarCM.equals("si")){ 
      out.write(__oracle_jsp_text[594]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[595]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[596]);
      out.print(strFolioRecepcion );
      out.write(__oracle_jsp_text[597]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[598]);
       }else{ 
      out.write(__oracle_jsp_text[599]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[600]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[601]);
      out.print(strFolioRecepcion );
      out.write(__oracle_jsp_text[602]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[603]);
       } 
      out.write(__oracle_jsp_text[604]);
       }else{ 
      out.write(__oracle_jsp_text[605]);
       if(strActivarCM.equals("no")){ 
      out.write(__oracle_jsp_text[606]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[607]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[608]);
      out.print(strFolioRecepcion );
      out.write(__oracle_jsp_text[609]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[610]);
       }else{ 
      out.write(__oracle_jsp_text[611]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[612]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[613]);
      out.print(strFolioRecepcion );
      out.write(__oracle_jsp_text[614]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[615]);
       } 
      out.write(__oracle_jsp_text[616]);
       } 
      out.write(__oracle_jsp_text[617]);
       
      		boolean firmado = strFirmaDigital.equals("1");
      		if(firmado){
      	
      out.write(__oracle_jsp_text[618]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[619]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[620]);
      out.print(strFechaTerminacionReal);
      out.write(__oracle_jsp_text[621]);
      out.print(strFechaTerminacionReal);
      out.write(__oracle_jsp_text[622]);
      
       }
          
      
            
      
      out.write(__oracle_jsp_text[623]);
       if(strReload.equals("0")){ 
      out.write(__oracle_jsp_text[624]);
      }
      out.write(__oracle_jsp_text[625]);
      out.print( bValidaEstatus );
      out.write(__oracle_jsp_text[626]);

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
  private static final char __oracle_jsp_text[][]=new char[627][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<HEAD>\n<TITLE>Instruccion Turnada</TITLE>\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\n".toCharArray();
    __oracle_jsp_text[19] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>instrucción</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n\t\n\t//function imprimir(){\n    //     var url='ImprimeInstruccionTerminada.jsp?idInstruccion='+".toCharArray();
    __oracle_jsp_text[20] = 
    ";\n    //     var ventanaImpresion=window.open(url,'','',true);\n\t//}\n\tvalid = 0;\n\tvar botonBandera = true;\n\n\tfunction imprimir(){\n\t\tvar isCenter ='true';\n\t\tvar features = '';\n\n\t\tif(window.screen)if(isCenter)if(isCenter==\"true\"){\n\t\t    var myLeft = (screen.width-800)/2;\n\t\t    var myTop = (screen.height-600)/2;\n\t\t    features+=(features!='')?',':'';\n\t\t    features+=',left='+myLeft+',top='+myTop; \n\t\t}\n\t\twindow.open(\"../ReporteInstruccion?id=\"+".toCharArray();
    __oracle_jsp_text[21] = 
    ", \"\", features+((features!='')?',':'')+'width=800, height=600 , resizable=yes');\n\t}\n\tfunction Regresar(){\n\t\tlocation.assign('".toCharArray();
    __oracle_jsp_text[22] = 
    "');\t\t \n\t}\n\tfunction Responder(){\n\t\tlocation.assign('Responder.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[23] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[24] = 
    "&id_es=".toCharArray();
    __oracle_jsp_text[25] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[26] = 
    "&us_or=".toCharArray();
    __oracle_jsp_text[27] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[28] = 
    "');\n\t}\n\tfunction Rechazar(){\n\t\tlocation.assign('Rechazar.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[29] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[30] = 
    "&tur=".toCharArray();
    __oracle_jsp_text[31] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[32] = 
    "&ins=".toCharArray();
    __oracle_jsp_text[33] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[34] = 
    "&retURI1=".toCharArray();
    __oracle_jsp_text[35] = 
    "&retURI2=".toCharArray();
    __oracle_jsp_text[36] = 
    "');\n\t}\n\tfunction Reasignar(){\n\t\tlocation.assign('Reasignar.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[37] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[38] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[39] = 
    "&usr_ori=".toCharArray();
    __oracle_jsp_text[40] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[41] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[42] = 
    "&retURI2=".toCharArray();
    __oracle_jsp_text[43] = 
    "');\n\t}\n\tfunction Delegar(){\n\t\tlocation.assign('Delegar.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[44] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[45] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[46] = 
    "&usr_ori=".toCharArray();
    __oracle_jsp_text[47] = 
    "');\n\t}\n\tfunction Turnar(){\n\t\tdoc = document.turnado;\n\t\tdoc.accion.value=\"desturnar\";\n\t\tdoc.submit();\n\t}\n\tfunction TerminarRechazada(){\n\t\tdoc = document.turnado;\n\t\tdoc.accion.value=\"terminarRechazada\";\n\t\tdoc.submit();\n\t}\n\tfunction turnar1(){\n\t\t\n\t\tdoc = document.turnado;\n\t\tdoc.accion.value=\"turnar\";\n\t\tif(".toCharArray();
    __oracle_jsp_text[48] = 
    "){\n\t\t   alert(\"Existen instrucciónes incompletas. Verifique en la ruta de atención\")\n\t\t   botonBandera=true;\n\t\t}else{\n\t\t  if(valid == 0){\n\t\t\t if (confirm(\"está usted seguro que desea Turnar las instrucciones?\")) {\n\t\t\t\tdoc.submit();\n\t\t\t\tvalid=1;\n\t\t\t}else{\n\t\t\t\talert(\"Su petición de Turnado ya fue cancelada\");\n                                botonBandera=true;\n\t\t\t}\n\t\t }else if(valid == 1){\n\t\t\talert(\"Su solicitud ya fue enviada\");\n\t\t }\n\t  }\n\t}\n\tfunction firmar(){\n\t\tlocation.assign('http://192.168.0.144:8080/firma/explorer_applet.html');\n\t}\n   \tfunction agregarComentario(){\n            //location.assign('AgregarComentarioInstruccion.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[49] = 
    "&tur=".toCharArray();
    __oracle_jsp_text[50] = 
    "&ins=".toCharArray();
    __oracle_jsp_text[51] = 
    "&a=2&estValidacion=".toCharArray();
    __oracle_jsp_text[52] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[53] = 
    "');\n            location.assign('AgregarComentarioInstruccion.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[54] = 
    "&tur=".toCharArray();
    __oracle_jsp_text[55] = 
    "&ins=".toCharArray();
    __oracle_jsp_text[56] = 
    "&a=2&estValidacion=".toCharArray();
    __oracle_jsp_text[57] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[58] = 
    "&retURI2=".toCharArray();
    __oracle_jsp_text[59] = 
    "');\n\t}\n\tfunction agregarContent() {\n\t\tlocation.assign('ImportarCM.jsp?Folio=".toCharArray();
    __oracle_jsp_text[60] = 
    "&IdAsunto=".toCharArray();
    __oracle_jsp_text[61] = 
    "&a=3&id_ins=".toCharArray();
    __oracle_jsp_text[62] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[63] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[64] = 
    "');\n\t}\n\tfunction agregar()\n\t{\n\t\tvar frameNvaRef = '".toCharArray();
    __oracle_jsp_text[65] = 
    "/eclient/SIGMA/Avance.jsp?id=".toCharArray();
    __oracle_jsp_text[66] = 
    "&bo=true&it=".toCharArray();
    __oracle_jsp_text[67] = 
    "';\n\t\tdocument.getElementById('frame1').src  = frameNvaRef;\t\t\n\t}\n\tfunction cambioFecha(){\n\t\tlocation.assign('CambioFechaInst.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[68] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[69] = 
    "&tur=".toCharArray();
    __oracle_jsp_text[70] = 
    "&i=".toCharArray();
    __oracle_jsp_text[71] = 
    "&re=3&estValidacion=".toCharArray();
    __oracle_jsp_text[72] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[73] = 
    "');\n\t}\n\tfunction cargaApplet(){\n\t\tlocation.assign('VisualizaInstrucciones.jsp?idAsunto=".toCharArray();
    __oracle_jsp_text[74] = 
    "&Instruccion=".toCharArray();
    __oracle_jsp_text[75] = 
    "&Url=".toCharArray();
    __oracle_jsp_text[76] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[77] = 
    "');\n\t}\n\tfunction cargaAppletMul(){\n\t\tlocation.assign('delMultiple.jsp?idAsunto=".toCharArray();
    __oracle_jsp_text[78] = 
    "&Instruccion=".toCharArray();
    __oracle_jsp_text[79] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[80] = 
    "&us=".toCharArray();
    __oracle_jsp_text[81] = 
    "');\n\t}\n\tfunction escaner(){\n\t\t".toCharArray();
    __oracle_jsp_text[82] = 
    "\n\t\tlocation.assign('sigmaCM:%20".toCharArray();
    __oracle_jsp_text[83] = 
    "/eclient/ArchivoCM%20".toCharArray();
    __oracle_jsp_text[84] = 
    "%20escanear%20false%20".toCharArray();
    __oracle_jsp_text[85] = 
    "%20".toCharArray();
    __oracle_jsp_text[86] = 
    "%20".toCharArray();
    __oracle_jsp_text[87] = 
    "');\n\t\t".toCharArray();
    __oracle_jsp_text[88] = 
    "\n\t\tlocation.assign('sigmaCM:%20".toCharArray();
    __oracle_jsp_text[89] = 
    "/ArchivoCM%20".toCharArray();
    __oracle_jsp_text[90] = 
    "%20escanear%20true%20".toCharArray();
    __oracle_jsp_text[91] = 
    "%20".toCharArray();
    __oracle_jsp_text[92] = 
    "%20".toCharArray();
    __oracle_jsp_text[93] = 
    "');\n\t\t".toCharArray();
    __oracle_jsp_text[94] = 
    "\n\t}\n</SCRIPT>\n<STYLE type=text/css>\nBODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"timer_load();\"\n\tonclick=\"timer_reload();\" onkeypress=\"timer_reload();\">\n<FORM action=\"InstruccionTurnada.jsp\" name=\"turnado\" method=\"post\">\n<INPUT name=\"turnar\" value=\"\" type=\"hidden\"> <INPUT\n\tname=\"id_ins\" value=\"".toCharArray();
    __oracle_jsp_text[95] = 
    "\" type=\"hidden\"> <INPUT\n\ttype=\"hidden\" value=\"\" name=\"accion\"> <INPUT name=\"retURI\"\n\tvalue=\"".toCharArray();
    __oracle_jsp_text[96] = 
    "\" type=\"hidden\"> <INPUT name=\"retURI2\"\n\tvalue=\"".toCharArray();
    __oracle_jsp_text[97] = 
    "\" type=\"hidden\"> <INPUT name=\"dif\"\n\tvalue=\"".toCharArray();
    __oracle_jsp_text[98] = 
    "\" type=\"hidden\"> <INPUT type=\"hidden\"\n\tvalue=\"".toCharArray();
    __oracle_jsp_text[99] = 
    "\" name=\"estValidacion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"99%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t".toCharArray();
    __oracle_jsp_text[100] = 
    "\n\t\t<td width=\"863\">\n\t\t".toCharArray();
    __oracle_jsp_text[101] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">Asunto Por Atender</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[102] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">Asunto En Trámite</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[103] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">Asunto Rechazado</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">Asunto Terminado</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[105] = 
    "\n\t\t</td>\n\t\t".toCharArray();
    __oracle_jsp_text[106] = 
    "\n\t\t<td width=\"863\">\n\t\t".toCharArray();
    __oracle_jsp_text[107] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">instrucción Por Atender</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[108] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">instrucción En Trámite</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[109] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">instrucción Rechazada</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[110] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">instrucción Terminada</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[111] = 
    "\n\t\t</td>\n\t\t".toCharArray();
    __oracle_jsp_text[112] = 
    "\n\t</tr>\n</table>\n</DIV>\n<br>\n\n<DIV align=\"center\">\n\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"863\">\n\t<tr>\n\t\t<td>\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; location.assign('".toCharArray();
    __oracle_jsp_text[113] = 
    "');}\"\n\t\t\t\t\tonMouseOver=\"document.MyImage.src='../Imagenes/NavLeft2.gif';\"\n\t\t\t\t\tonMouseOut=\"document.MyImage.src='../Imagenes/NavLeft.gif';\"> <IMG\n\t\t\t\t\tborder=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar / Cancelar\"\n\t\t\t\t\tname=\"MyImage\"></A></td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[114] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[115] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[116] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[117] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[118] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; location.assign('Responder.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[119] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[120] = 
    "&id_es=".toCharArray();
    __oracle_jsp_text[121] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[122] = 
    "&us_or=".toCharArray();
    __oracle_jsp_text[123] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[124] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[125] = 
    "');}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Responder3.src='../Imagenes/Responder2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Responder3.src='../Imagenes/Responder.gif';\"><IMG\n\t\t\t\t\t\t\tsrc=\"../Imagenes/Responder.gif\" border=0 name=\"Responder3\"\n\t\t\t\t\t\t\talt=\"Responder\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[126] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[127] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[128] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[129] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[130] = 
    "\n\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[131] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[132] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Turnar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Habilitar2.src='../Imagenes/elim_delg_multiple2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Habilitar2.src='../Imagenes/elim_delg_multiple.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/elim_delg_multiple.gif\"\n\t\t\t\t\t\t\talt=\"Deshabilitar Delegación Multiple\" name=\"Habilitar2\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[133] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[134] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[135] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[136] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[137] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[138] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><a\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarContent();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Insertar.src='../Imagenes/Attach2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Insertar.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\"\n\t\t\t\t\t\t\talt=\"Insertar Archivo\" name=\"Insertar\"></a></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[139] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[140] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[141] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[142] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarComentario();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Comentario.src='../Imagenes/Comentario2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Comentario.src='../Imagenes/Comentario.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Comentario.gif\"\n\t\t\t\t\t\t\talt=\"Crear un Comentario\" name=\"Comentario\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[143] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[144] = 
    "\n\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[145] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[146] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[147] = 
    "\n\t\t\t\t\t\t<td width=\"60\">\n\t\t\t\t\t\t<DIV align=\"left\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaAppletMul();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\" alt=\"Crear ruta\"\n\t\t\t\t\t\t\tname=\"CrearRuta\" /></A></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[148] = 
    "\n\t\t\t\t\t\t<td width=\"60\">\n\n\t\t\t\t\t\t<DIV align=\"left\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[149] = 
    " <A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaApplet();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\"\n\t\t\t\t\t\t\talt=\"Ver Ruta de atención\" name=\"CrearRuta\"></A> ".toCharArray();
    __oracle_jsp_text[150] = 
    " <A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaAppletMul();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\"\n\t\t\t\t\t\t\talt=\"Ver Ruta de atención\" name=\"CrearRuta\" /></A> ".toCharArray();
    __oracle_jsp_text[151] = 
    "\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<td width=\"60\">\n\t\t\t\t\t\t<DIV align=\"left\"><A onclick=\"turnar1()\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Turnar.src='../Imagenes/Turnar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Turnar.src='../Imagenes/Turnar.gif';\"> <IMG\n\t\t\t\t\t\t\tborder=\"0\" src=\"../Imagenes/Turnar.gif\" alt=\"Turnar\"\n\t\t\t\t\t\t\tname=\"Turnar\"> </A></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[152] = 
    "\n\t\t\t\t\t\t<td width=\"60\">\n\t\t\t\t\t\t<DIV align=\"left\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaAppletMul();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\" alt=\"Editar Ruta\"\n\t\t\t\t\t\t\tname=\"CrearRuta\" /> </A></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[153] = 
    "\n\t\t\t\t\t\t<td width=\"60\">\n\t\t\t\t\t\t<DIV align=\"left\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; turnar1();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Turnar.src='../Imagenes/Turnar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Turnar.src='../Imagenes/Turnar.gif';\"><IMG\n\t\t\t\t\t\t\tborder=\"0\" src=\"../Imagenes/Turnar.gif\" alt=\"Turnar\"\n\t\t\t\t\t\t\tname=\"Turnar\" /></A></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[154] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[155] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[156] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[157] = 
    "\n\n\t\t\t\t<td width=\"400\">&nbsp;</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[158] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[159] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[160] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A onclick=\"if(botonBandera){imprimir(); }\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Imprimir.src='../Imagenes/Imprimir2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Imprimir.src='../Imagenes/Imprimir.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Imprimir.gif\" alt=\"Imprimir\"\n\t\t\t\t\t\t\tname=\"Imprimir\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[161] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[162] = 
    "\n\t\t\t\t<td width=\"500\">&nbsp;</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[163] = 
    "\n\t\t\t\t<!-- Instrucciones que son de tipo ejecutorias  -->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[164] = 
    "\n\t\t\t\t<!-- Instrucciones que ya estan terminadas  -->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[165] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[166] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[167] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A onclick=\"if(botonBandera){imprimir(); }\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Imprimir.src='../Imagenes/Imprimir2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Imprimir.src='../Imagenes/Imprimir.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Imprimir.gif\" alt=\"Imprimir\"\n\t\t\t\t\t\t\tname=\"Imprimir\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[168] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[169] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[170] = 
    "\n\t\t\t\t<!-- Si la instruccion tiene como estatus \"Por atender\", se mostraran todos los botones -->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[171] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[172] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[173] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[174] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[175] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[176] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; location.assign('Responder.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[177] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[178] = 
    "&id_es=".toCharArray();
    __oracle_jsp_text[179] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[180] = 
    "&us_or=".toCharArray();
    __oracle_jsp_text[181] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[182] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[183] = 
    "');}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Responder3.src='../Imagenes/Responder2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Responder3.src='../Imagenes/Responder.gif';\"><IMG\n\t\t\t\t\t\t\tsrc=\"../Imagenes/Responder.gif\" border=0 name=\"Responder3\"\n\t\t\t\t\t\t\talt=\"Responder\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[184] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[185] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[186] = 
    "\n\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[187] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[188] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[189] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[190] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Turnar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Habilitar2.src='../Imagenes/elim_delg_multiple2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Habilitar2.src='../Imagenes/elim_delg_multiple.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/elim_delg_multiple.gif\"\n\t\t\t\t\t\t\talt=\"Deshabilitar Delegación Multiple\" name=\"Habilitar2\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[191] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[192] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[193] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[194] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[195] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[196] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[197] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[198] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Reasignar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Reasignar2.src='../Imagenes/Reasignar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Reasignar2.src='../Imagenes/Reasignar.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Reasignar.gif\" alt=\"Reasignar\"\n\t\t\t\t\t\t\tname=\"Reasignar2\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[199] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[200] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[201] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[202] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[203] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[204] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[205] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[206] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Rechazar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Rechazar2.src='../Imagenes/Rechazar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Rechazar2.src='../Imagenes/Rechazar.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Rechazar.gif\" alt=\"Rechazar\"\n\t\t\t\t\t\t\tname=\"Rechazar2\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[207] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[208] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[209] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[210] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[211] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[212] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><a\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarContent();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Insertar.src='../Imagenes/Attach2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Insertar.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\"\n\t\t\t\t\t\t\talt=\"Insertar Archivo\" name=\"Insertar\"></a></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[213] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[214] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[215] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[216] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[217] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[218] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cambioFecha();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.cambioFecha1.src='../Imagenes/CambioFecha.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CambioFecha.gif\"\n\t\t\t\t\t\t\talt=\"Solicitar Cambio de Fecha\" name=\"cambioFecha1\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[219] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cambioFecha();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.cambioFecha1.src='../Imagenes/CambioFecha.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CambioFecha.gif\"\n\t\t\t\t\t\t\talt=\"Cambiar Fecha\" name=\"cambioFecha1\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[220] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[221] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[222] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[223] = 
    "\n\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[224] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[225] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarComentario();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Comentario.src='../Imagenes/Comentario2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Comentario.src='../Imagenes/Comentario.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Comentario.gif\"\n\t\t\t\t\t\t\talt=\"Crear un Comentario\" name=\"Comentario\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[226] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[227] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[228] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[229] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[230] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaApplet();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\" alt=\"Crear ruta\"\n\t\t\t\t\t\t\tname=\"CrearRuta\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[231] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[232] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[233] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[234] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[235] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[236] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[237] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[238] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[239] = 
    "\n\t\t\t\t\t\t<td width=\"60\" align=\"center\">".toCharArray();
    __oracle_jsp_text[240] = 
    " <A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaAppletMul();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\" alt=\"Crear ruta\"\n\t\t\t\t\t\t\tname=\"CrearRuta\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[241] = 
    "\n\t\t\t\t\t\t<td width=\"60\" align=\"center\">".toCharArray();
    __oracle_jsp_text[242] = 
    " <A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaApplet();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\" alt=\"Crear ruta\"\n\t\t\t\t\t\t\tname=\"CrearRuta\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[243] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[244] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[245] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[246] = 
    "\n\t\t\t\t<td width=\"60\">&nbsp;</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[247] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[248] = 
    "\n\t\t\t\t\t\t<A onclick=\"if(botonBandera){botonBandera=false; cargaApplet();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\" alt=\"Editar Ruta\"\n\t\t\t\t\t\t\tname=\"CrearRuta\"></A>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[249] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[250] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[251] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[252] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[253] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[254] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[255] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[256] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[257] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><a\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarContent();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Insertar.src='../Imagenes/Attach2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Insertar.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\"\n\t\t\t\t\t\t\talt=\"Insertar Archivo\" name=\"Insertar\"></a></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[258] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[259] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[260] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[261] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarComentario();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Comentario.src='../Imagenes/Comentario2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Comentario.src='../Imagenes/Comentario.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Comentario.gif\"\n\t\t\t\t\t\t\talt=\"Crear un Comentario--\" name=\"Comentario\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[262] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[263] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[264] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[265] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[266] = 
    "\n\t\t\t\t\t\t<td width=\"60\">".toCharArray();
    __oracle_jsp_text[267] = 
    "\n\t\t\t\t\t\t<DIV align=\"left\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaAppletMul();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\"\n\t\t\t\t\t\t\talt=\"Ver Ruta de atención\" name=\"CrearRuta\"></A></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<td width=\"60\">\n\t\t\t\t\t\t<DIV align=\"left\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; turnar1();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Turnar.src='../Imagenes/Turnar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Turnar.src='../Imagenes/Turnar.gif';\"><IMG\n\t\t\t\t\t\t\tborder=\"0\" src=\"../Imagenes/Turnar.gif\" alt=\"Turnar\"\n\t\t\t\t\t\t\tname=\"Turnar\"></A></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[268] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[269] = 
    "\n\t\t\t\t\t\t<td width=\"60\">".toCharArray();
    __oracle_jsp_text[270] = 
    "\n\t\t\t\t\t\t<DIV align=\"left\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaApplet();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\"\n\t\t\t\t\t\t\talt=\"Ver Ruta de atención\" name=\"CrearRuta\"></A></div>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[271] = 
    "\n\t\t\t\t\t\t<td width=\"60\">\n\t\t\t\t\t\t<DIV align=\"left\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; turnar1();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Turnar.src='../Imagenes/Turnar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Turnar.src='../Imagenes/Turnar.gif';\"> <IMG\n\t\t\t\t\t\t\tborder=\"0\" src=\"../Imagenes/Turnar.gif\" alt=\"Turnar\"\n\t\t\t\t\t\t\tname=\"Turnar\"> </A></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[272] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[273] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[274] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[275] = 
    "\n\n\t\t\t\t<td width=\"300\">&nbsp;</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[276] = 
    "\n\t\t\t\t<!-- Fin de si tienes hijos -->\n\t\t\t\t<td width=\"300\">&nbsp;</td>\n\n\t\t\t\t<!-- Si la instrucción se encuestra en tramite, no mostrara el boton de rechazar -->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[277] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[278] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[279] = 
    "\n\t\t\t\t\t\t<td width=\"60\" vAlign=top><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; location.assign('Responder.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[280] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[281] = 
    "&id_es=".toCharArray();
    __oracle_jsp_text[282] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[283] = 
    "&us_or=".toCharArray();
    __oracle_jsp_text[284] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[285] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[286] = 
    "');}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Responder3.src='../Imagenes/Responder2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Responder3.src='../Imagenes/Responder.gif';\"><IMG\n\t\t\t\t\t\t\tsrc=\"../Imagenes/Responder.gif\" border=0 name=\"Responder3\"\n\t\t\t\t\t\t\talt=\"Responder\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[287] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[288] = 
    "\n\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[289] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[290] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[291] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Turnar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Habilitar2.src='../Imagenes/elim_delg_multiple2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Habilitar2.src='../Imagenes/elim_delg_multiple.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/elim_delg_multiple.gif\"\n\t\t\t\t\t\t\talt=\"Deshabilitar Delegación Multiple\" name=\"Habilitar2\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[292] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[293] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[294] = 
    "\n\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[295] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[296] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[297] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Reasignar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Reasignar2.src='../Imagenes/Reasignar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Reasignar2.src='../Imagenes/Reasignar.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Reasignar.gif\" alt=\"Reasignar\"\n\t\t\t\t\t\t\tname=\"Reasignar2\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[298] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[299] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[300] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[301] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[302] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><a\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarContent();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Insertar.src='../Imagenes/Attach2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Insertar.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\"\n\t\t\t\t\t\t\talt=\"Insertar Archivo\" name=\"Insertar\"></a></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[303] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[304] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[305] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[306] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[307] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cambioFecha();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.cambioFecha1.src='../Imagenes/CambioFecha.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CambioFecha.gif\"\n\t\t\t\t\t\t\talt=\"Solicitar Cambio de Fecha\" name=\"cambioFecha1\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[308] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cambioFecha();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.cambioFecha1.src='../Imagenes/CambioFecha.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CambioFecha.gif\"\n\t\t\t\t\t\t\talt=\"Cambiar Fecha\" name=\"cambioFecha1\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[309] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[310] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[311] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[312] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[313] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarComentario();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Comentario.src='../Imagenes/Comentario2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Comentario.src='../Imagenes/Comentario.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Comentario.gif\"\n\t\t\t\t\t\t\talt=\"Crear un Comentario\" name=\"Comentario\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[314] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[315] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[316] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[317] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[318] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[319] = 
    "\n\t\t\t\t\t\t<td width=\"60\" align=\"center\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaAppletMul();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\" alt=\"Crear ruta\"\n\t\t\t\t\t\t\tname=\"CrearRuta\"></A> <!-- <input type=\"button\"\n\t\t\t\t\tonclick=\"cargaApplet()\"\n\t\t\t\t\tvalue=\"Crear ruta\" class=\"blue200\">--></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[320] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[321] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[322] = 
    "\n\t\t\t\t<td width=\"60\">&nbsp;</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[323] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[324] = 
    "\n\t\t\t\t\t\t<A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaAppletMul();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\" alt=\"Editar Ruta\"\n\t\t\t\t\t\t\tname=\"CrearRuta\"></A>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[325] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[326] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[327] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[328] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[329] = 
    "\n\t\t\t\t\t\t<td width=\"60\">\n\t\t\t\t\t\t<DIV align=\"left\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaAppletMul();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\"\n\t\t\t\t\t\t\talt=\"Ver Ruta de atención\" name=\"CrearRuta\" /> </A></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<td width=\"60\">\n\t\t\t\t\t\t<DIV align=\"left\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; turnar1();}\"> <IMG\n\t\t\t\t\t\t\tborder=\"0\" src=\"../Imagenes/Turnar.gif\" alt=\"Turnar\" /> </A></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[330] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[331] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[332] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[333] = 
    "\n\t\t\t\t<td width=\"300\">&nbsp;</td>\n\t\t\t\t<!-- \tSi la instruccion ha sido rechazada, solo mostrara los \n\t\t\t\tbotones de reasignar -->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[334] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[335] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[336] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[337] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Reasignar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Reasignar2.src='../Imagenes/Reasignar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Reasignar2.src='../Imagenes/Reasignar.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Reasignar.gif\" alt=\"Reasignar\"\n\t\t\t\t\t\t\tname=\"Reasignar2\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[338] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[339] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; TerminarRechazada();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.TerRechazada.src='../Imagenes/Responder2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.TerRechazada.src='../Imagenes/Responder.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Responder.gif\"\n\t\t\t\t\t\t\talt=\"Terminar instrucción Rechazada\" name=\"TerRechazada\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[340] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[341] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[342] = 
    "\n\t\t\t\t<TD width=\"400\">&nbsp;</TD>\n\n\t\t\t\t<!-- Si la instrucción ha sido terminada, no mostrara ningun boton -->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[343] = 
    "\n\t\t\t\t<td width=\"600\">&nbsp;</td>\n\t\t\t\t<!-- Si la instrucción ha sido delegada, solo mostrara los botones de responder y delegar -->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[344] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[345] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[346] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; location.assign('Responder.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[347] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[348] = 
    "&id_es=".toCharArray();
    __oracle_jsp_text[349] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[350] = 
    "&us_or=".toCharArray();
    __oracle_jsp_text[351] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[352] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[353] = 
    "');}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Responder3.src='../Imagenes/Responder2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Responder3.src='../Imagenes/Responder.gif';\"><IMG\n\t\t\t\t\t\t\tsrc=\"../Imagenes/Responder.gif\" border=\"0\" name=\"Responder3\"\n\t\t\t\t\t\t\talt=\"Responder\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[354] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[355] = 
    "\n\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[356] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[357] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Delegar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Delegar2.src='../Imagenes/Delegar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Delegar2.src='../Imagenes/Delegar.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Delegar.gif\" alt=\"Delegar\"\n\t\t\t\t\t\t\tname=\"Delegar2\"></A>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[358] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[359] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[360] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[361] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarComentario();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Comentario.src='../Imagenes/Comentario2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Comentario.src='../Imagenes/Comentario.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Comentario.gif\"\n\t\t\t\t\t\t\talt=\"Crear un Comentario\" name=\"Comentario\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[362] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[363] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[364] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[365] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><a\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarContent();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Insertar.src='../Imagenes/Attach2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Insertar.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\"\n\t\t\t\t\t\t\talt=\"Insertar Archivo\" name=\"Insertar\"></a></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[366] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[367] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[368] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[369] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[370] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cambioFecha();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.cambioFecha1.src='../Imagenes/CambioFecha.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CambioFecha.gif\"\n\t\t\t\t\t\t\talt=\"Solicitar Cambio de Fecha\" name=\"cambioFecha1\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[371] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[372] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[373] = 
    "\n\t\t\t\t<td width=\"623\">&nbsp;</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[374] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[375] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[376] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[377] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[378] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[379] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[380] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; location.assign('Responder.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[381] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[382] = 
    "&id_es=".toCharArray();
    __oracle_jsp_text[383] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[384] = 
    "&us_or=".toCharArray();
    __oracle_jsp_text[385] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[386] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[387] = 
    "');}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Responder3.src='../Imagenes/Responder2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Responder3.src='../Imagenes/Responder.gif';\"><IMG\n\t\t\t\t\t\t\tsrc=\"../Imagenes/Responder.gif\" border=\"0\" name=\"Responder3\"\n\t\t\t\t\t\t\talt=\"Responder\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[388] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[389] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[390] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[391] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[392] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[393] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><a\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarContent();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Insertar.src='../Imagenes/Attach2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Insertar.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\"\n\t\t\t\t\t\t\talt=\"Insertar Archivo\" name=\"Insertar\"></a></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[394] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[395] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[396] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[397] = 
    "\n\t\t\t\t\t\t<!--Muestra los el boton de editar ruta en el estatus 2-->\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[398] = 
    "\n\t\t\t\t\t\t<td width=\"60\">\n\t\t\t\t\t\t<div align=\"left\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaAppletMul();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\" alt=\"Editar Ruta\"\n\t\t\t\t\t\t\tname=\"CrearRuta\" /> </A></div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[399] = 
    "\n\t\t\t\t\t\t<td width=\"60\">\n\t\t\t\t\t\t<div align=\"left\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; turnar1();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Turnar.src='../Imagenes/Turnar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Turnar.src='../Imagenes/Turnar.gif';\"><IMG\n\t\t\t\t\t\t\tborder=\"0\" src=\"../Imagenes/Turnar.gif\" alt=\"Turnar\"\n\t\t\t\t\t\t\tname=\"Turnar\"></A></div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[400] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[401] = 
    "\n\t\t\t\t\t\t<td width=\"60\">\n\t\t\t\t\t\t<div align=\"left\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaApplet();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\" alt=\"Editar Ruta\"\n\t\t\t\t\t\t\tname=\"CrearRuta\"></A></div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[402] = 
    "\n\t\t\t\t\t\t<td width=\"60\">\n\t\t\t\t\t\t<div align=\"left\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; turnar1();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Turnar.src='../Imagenes/Turnar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Turnar.src='../Imagenes/Turnar.gif';\"><IMG\n\t\t\t\t\t\t\tborder=\"0\" src=\"../Imagenes/Turnar.gif\" alt=\"Turnar\"\n\t\t\t\t\t\t\tname=\"Turnar\"></A></div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[403] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[404] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[405] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[406] = 
    "\n\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[407] = 
    "\n\n\t\t\t\t<td width=\"300\"></td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[408] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[409] = 
    "\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n</table>\n</DIV>\n<br>\n".toCharArray();
    __oracle_jsp_text[410] = 
    "\n<DIV align=\"center\">\n<TABLE>\n\t<TBODY>\n\t\t<TR>\n\t\t\t<td><FONT size=\"2\" color=\"red\">Se ha solicitado un Cambio\n\t\t\tde Fecha de Vencimiento para esta instrucción</FONT></td>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[411] = 
    "\n<div align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td align=\"right\" width=\"394\"><font size=\"2\" color=\"#00204f\"\n\t\t\tface=\"Verdana\">Folio:&nbsp;<b>".toCharArray();
    __oracle_jsp_text[412] = 
    "</b></font><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[413] = 
    " <font size=\"2\" color=\"#00204f\"\n\t\t\tface=\"Verdana\">Folio de Control:&nbsp;<b>".toCharArray();
    __oracle_jsp_text[414] = 
    "</b></font><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[415] = 
    "\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\"\n\t\t\twidth=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n</table>\n</div>\n\n\n\n\n<DIV class=documentBody id=Body>\n<div align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Nombre:</font>\n\t\t</td>\n\t\t<td colspan=\"3\" width=\"680\"><font size=\"2\" face=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[416] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[417] = 
    " ".toCharArray();
    __oracle_jsp_text[418] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[419] = 
    " ".toCharArray();
    __oracle_jsp_text[420] = 
    " ".toCharArray();
    __oracle_jsp_text[421] = 
    " ".toCharArray();
    __oracle_jsp_text[422] = 
    " <INPUT type=\"hidden\"\n\t\t\tname=\"nombreHdn\" value=\"".toCharArray();
    __oracle_jsp_text[423] = 
    "\"> <INPUT type=\"hidden\"\n\t\t\tname=\"telefonoHdn\" value=\"".toCharArray();
    __oracle_jsp_text[424] = 
    "\"> <INPUT\n\t\t\ttype=\"hidden\" name=\"correoHdn\" value=\"".toCharArray();
    __oracle_jsp_text[425] = 
    "\"> </font></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Tipo\n\t\tde atención:</font></td>\n\t\t<td width=\"\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[426] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"atencionHdn\" value=\"".toCharArray();
    __oracle_jsp_text[427] = 
    "\"></font></td>\n\t\t<td width=\"\" align=\"right\"><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">Acceso al Documento Original:&nbsp;&nbsp;</font></td>\n\t\t<td width=\"\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[428] = 
    "\n\t\t<INPUT type=\"hidden\" name=\"verDoctoHdn\" value=\"".toCharArray();
    __oracle_jsp_text[429] = 
    "\"></font>\n\t\t".toCharArray();
    __oracle_jsp_text[430] = 
    " ".toCharArray();
    __oracle_jsp_text[431] = 
    " <A\n\t\t\thref=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[432] = 
    "&ih=".toCharArray();
    __oracle_jsp_text[433] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[434] = 
    "\">\n\t\t<IMG SRC='../Imagenes/type_document.gif' BORDER=0> </A> ".toCharArray();
    __oracle_jsp_text[435] = 
    " <A\n\t\t\thref=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[436] = 
    "&per=1&inst=1&retURI=".toCharArray();
    __oracle_jsp_text[437] = 
    "\">\n\t\t<IMG SRC='../Imagenes/type_document.gif' BORDER=0> </A> ".toCharArray();
    __oracle_jsp_text[438] = 
    " ".toCharArray();
    __oracle_jsp_text[439] = 
    "\n\t\t</td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Asunto:</font>\n\t\t</td>\n\t\t<td colspan=\"3\" width=\"680\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[440] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"asuntoHdn\" value=\"".toCharArray();
    __oracle_jsp_text[441] = 
    "\"><INPUT\n\t\t\ttype=\"hidden\" name=\"pasoHdn\" value=\"".toCharArray();
    __oracle_jsp_text[442] = 
    "\"></font></td>\n\t</tr>\n\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha\n\t\tde generación:</font></td>\n\t\t<td width=\"\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[443] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"fechaGenHdn\" value=\"".toCharArray();
    __oracle_jsp_text[444] = 
    "\"></font>\n\t\t</td>\n\t\t<td align=\"right\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha\n\t\tVencimiento:&nbsp;&nbsp;</font></td>\n\t\t<td width=\"\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[445] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"fechaVenHdn\" value=\"".toCharArray();
    __oracle_jsp_text[446] = 
    "\"></font>\n\t\t</td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Estatus:</font>\n\t\t</td>\n\t\t<td>\n\t\t".toCharArray();
    __oracle_jsp_text[447] = 
    " <font size=\"2\" face=\"Arial\">Notificado</font>\n\t\t".toCharArray();
    __oracle_jsp_text[448] = 
    " <font size=\"2\" face=\"Arial\">En\n\t\tTrámite</font> ".toCharArray();
    __oracle_jsp_text[449] = 
    " <font size=\"2\"\n\t\t\tface=\"Arial\">Rechazada</font> ".toCharArray();
    __oracle_jsp_text[450] = 
    " <font\n\t\t\tsize=\"2\" face=\"Arial\">Terminada</font> ".toCharArray();
    __oracle_jsp_text[451] = 
    "\n\t\t</td>\n\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\twidth=\"1\" alt=\"\"></td>\n\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\twidth=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\t<!-- <tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Delegado\n\t\ta:</font></td>\n\t\t".toCharArray();
    __oracle_jsp_text[452] = 
    "\n\t\t<td colspan=\"3\" width=\"680\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[453] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[454] = 
    " <INPUT type=\"hidden\" name=\"delegadoAHdn\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[455] = 
    "\"> </font></td>\n\t\t".toCharArray();
    __oracle_jsp_text[456] = 
    "\n\t\t<td colspan=\"3\" width=\"380\"></td>\n\t\t".toCharArray();
    __oracle_jsp_text[457] = 
    "\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR> -->\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Asignada\n\t\tpor: </font></td>\n\t\t<td width=\"\"><font size=\"2\" face=\"Arial\">\n\t\t".toCharArray();
    __oracle_jsp_text[458] = 
    "<input\n\t\t\ttype=\"hidden\" name=\"turnadoPorHdn\" value=\"".toCharArray();
    __oracle_jsp_text[459] = 
    "\"></font></td>\n\t\t<td width=\"\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\"\n\t\t\theight=\"1\" alt=\"\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Folio\n\t\tde Recepción:</font> <font size=\"2\" face=\"Arial\"> </font></td>\n\t\t<td colspan=\"3\" width=\"680\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[460] = 
    "\n\t\t<input type=\"hidden\" name=\"folioRecepcionHdn\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[461] = 
    "\"></font></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\"\n\t\t\theight=\"1\" alt=\"\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Folio\n\t\tIntermedio:</font></td>\n\t\t<td width=\"\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[462] = 
    "\n\n\t\t</font><input type=\"hidden\" name=\"folioIntermedioHdn\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[463] = 
    "\"></td>\n\t\t<td width=\"\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\"\n\t\t\theight=\"1\" alt=\"\">&nbsp;</td>\n\t</tr>\n</table>\n</div>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">INSTRUCCION</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\"\n\t\t\twidth=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><img src=\"../Imagenes/shim.gif\" width=\"1\"\n\t\t\theight=\"1\" alt=\"\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[464] = 
    "<input\n\t\t\ttype=\"hidden\" name=\"nombreInstruccionHdn\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[465] = 
    "\"></font></td>\n\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><img src=\"../Imagenes/shim.gif\" width=\"1\"\n\t\t\theight=\"1\" alt=\"\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</table>\n</DIV>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">SINTESIS</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\"\n\t\t\twidth=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[466] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"sintesisHdn\" value=\"".toCharArray();
    __oracle_jsp_text[467] = 
    "\"></font></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><img src=\"../Imagenes/shim.gif\" width=\"1\"\n\t\t\theight=\"1\" alt=\"\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\n</table>\n</DIV>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">EXPEDIENTES</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\"\n\t\t\twidth=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><IFRAME\n\t\t\tsrc=\"ExpedienteInstrccion.jsp?ida=".toCharArray();
    __oracle_jsp_text[468] = 
    "&num=1\"\n\t\t\tWIDTH=800 HEIGHT=100 frameborder=0 id=\"Entidad\"></IFRAME></td>\n\t</tr>\n\n\n</table>\n\n</DIV>\n\n<br>\n".toCharArray();
    __oracle_jsp_text[469] = 
    "\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"64%\" colspan=\"2\"><B><FONT face=\"Arial\"\n\t\t\t\tcolor=\"#004080\" size=\"2\">Lista Ruta de atención</FONT></B></TD>\n\t\t\t<TD width=\"21%\">&nbsp;</TD>\n\t\t\t<TD width=\"14%\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" bgcolor=\"#004080\" colspan=\"4\"><IMG height=\"2\"\n\t\t\t\talt=\"\" src=\"../Imagenes/shim.gif\" width=\"1\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" colspan=\"4\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" colspan=\"4\"><FONT face=\"Arial\" size=\"2\"></FONT>\n\t\t\t<TABLE width=\"100%\" border=\"0\">\n\t\t\t\t<TBODY>\n\t\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t\t<TD width=\"2%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">H.</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"3%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">Paso</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"17%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">Responsable</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"15%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">Unidad Administrativa</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"21%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">N. instrucción</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"10%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">F. Recepción</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"10%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">F. Vencimiento</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"5%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">D. Plan.</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"5%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">D. Real</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"5%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">Avance</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"5%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">Estatus</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"2%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">Con.</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[470] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[471] = 
    "\n\t\t\t\t\t\t<TR valign=\"top\" ".toCharArray();
    __oracle_jsp_text[472] = 
    " ".toCharArray();
    __oracle_jsp_text[473] = 
    "\n\t\t\t\t\t\t\tbgcolor=\"#f6f6f6\" ".toCharArray();
    __oracle_jsp_text[474] = 
    ">\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[475] = 
    "\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">Si</FONT></DIV>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[476] = 
    "\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">No</FONT></DIV>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[477] = 
    "\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">".toCharArray();
    __oracle_jsp_text[478] = 
    "</FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\"> ".toCharArray();
    __oracle_jsp_text[479] = 
    " ".toCharArray();
    __oracle_jsp_text[480] = 
    " ".toCharArray();
    __oracle_jsp_text[481] = 
    " ".toCharArray();
    __oracle_jsp_text[482] = 
    " ".toCharArray();
    __oracle_jsp_text[483] = 
    " </FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">".toCharArray();
    __oracle_jsp_text[484] = 
    "</FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\"> ".toCharArray();
    __oracle_jsp_text[485] = 
    " ".toCharArray();
    __oracle_jsp_text[486] = 
    " ".toCharArray();
    __oracle_jsp_text[487] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[488] = 
    " ".toCharArray();
    __oracle_jsp_text[489] = 
    " </FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\"> ".toCharArray();
    __oracle_jsp_text[490] = 
    "- ".toCharArray();
    __oracle_jsp_text[491] = 
    " ".toCharArray();
    __oracle_jsp_text[492] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[493] = 
    " </FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\"> ".toCharArray();
    __oracle_jsp_text[494] = 
    "- ".toCharArray();
    __oracle_jsp_text[495] = 
    " ".toCharArray();
    __oracle_jsp_text[496] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[497] = 
    " </FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">".toCharArray();
    __oracle_jsp_text[498] = 
    "</FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\"> ".toCharArray();
    __oracle_jsp_text[499] = 
    " ".toCharArray();
    __oracle_jsp_text[500] = 
    " ".toCharArray();
    __oracle_jsp_text[501] = 
    "-".toCharArray();
    __oracle_jsp_text[502] = 
    " </FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">".toCharArray();
    __oracle_jsp_text[503] = 
    "%</FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\"> ".toCharArray();
    __oracle_jsp_text[504] = 
    " ".toCharArray();
    __oracle_jsp_text[505] = 
    "\n\t\t\t\t\t\t\t<A\n\t\t\t\t\t\t\t\thref=\"InstruccionHija.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[506] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[507] = 
    "\">\n\t\t\t\t\t\t\t<U>Notificado</U></A> ".toCharArray();
    __oracle_jsp_text[508] = 
    " <A\n\t\t\t\t\t\t\t\thref=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[509] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[510] = 
    "\">\n\t\t\t\t\t\t\t<U>Notificado</U></A> ".toCharArray();
    __oracle_jsp_text[511] = 
    " ".toCharArray();
    __oracle_jsp_text[512] = 
    " ".toCharArray();
    __oracle_jsp_text[513] = 
    "\n\t\t\t\t\t\t\t<A\n\t\t\t\t\t\t\t\thref=\"InstruccionHija.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[514] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[515] = 
    "\">\n\t\t\t\t\t\t\t<U>En Proceso</U></A> ".toCharArray();
    __oracle_jsp_text[516] = 
    " <A\n\t\t\t\t\t\t\t\thref=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[517] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[518] = 
    "\">\n\t\t\t\t\t\t\t<U>En Proceso</U></A> ".toCharArray();
    __oracle_jsp_text[519] = 
    " ".toCharArray();
    __oracle_jsp_text[520] = 
    " <A\n\t\t\t\t\t\t\t\thref=\"InstruccionHija.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[521] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[522] = 
    "\">\n\t\t\t\t\t\t\t<U>Rechazada</U></A> ".toCharArray();
    __oracle_jsp_text[523] = 
    " ".toCharArray();
    __oracle_jsp_text[524] = 
    "\n\t\t\t\t\t\t\t<A\n\t\t\t\t\t\t\t\thref=\"InstruccionHija.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[525] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[526] = 
    "\">\n\t\t\t\t\t\t\t<U>Terminada</U></A> ".toCharArray();
    __oracle_jsp_text[527] = 
    " <A\n\t\t\t\t\t\t\t\thref=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[528] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[529] = 
    "\">\n\t\t\t\t\t\t\t<U>Terminada</U></A> ".toCharArray();
    __oracle_jsp_text[530] = 
    " ".toCharArray();
    __oracle_jsp_text[531] = 
    "\n\t\t\t\t\t\t\t</FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[532] = 
    "\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">Si</FONT></DIV>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[533] = 
    "\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">No</FONT></DIV>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[534] = 
    "\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[535] = 
    "\n\t\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" colspan=\"4\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"36%\">&nbsp;</TD>\n\t\t\t<TD width=\"29%\">&nbsp;</TD>\n\t\t\t<TD width=\"21%\">&nbsp;</TD>\n\t\t\t<TD width=\"14%\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<BR>\n".toCharArray();
    __oracle_jsp_text[536] = 
    " <!-- Historial de la instrucción -->\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"863\">\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">Historia de la instrucción</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\"\n\t\t\twidth=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t".toCharArray();
    __oracle_jsp_text[537] = 
    "\n\t\t<td width=\"100%\" colspan=\"4\"><font size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[538] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[539] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[540] = 
    "----><br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[541] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[542] = 
    "\n\t\t\t\tSe ha alcanzado el estatus de &quot;Terminado&quot; en todas las Instrucciones delegadas <br>\n\t\t\t<U>Avance de: 99%</U>\n\t\t\t".toCharArray();
    __oracle_jsp_text[543] = 
    "\n\t\t\t\tAvance del Usuario: ".toCharArray();
    __oracle_jsp_text[544] = 
    "<br>\n\t\t\t<a\n\t\t\t\thref=\"Responder.jsp?id_his=".toCharArray();
    __oracle_jsp_text[545] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[546] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[547] = 
    "\">\n\t\t\t<font size=\"1\" color=\"#004080\" face=\"Arial\"> <U>Avance de:\n\t\t\t".toCharArray();
    __oracle_jsp_text[548] = 
    "%</U><input type=\"hidden\" name=\"avanceDeHdn\"\n\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[549] = 
    "\"> </font> </a>\n\t\t\t".toCharArray();
    __oracle_jsp_text[550] = 
    "\n\t\t\t<!--<br>\n\t\t\t\t  Comentarios Adicionales:  //campo6 -->\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[551] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[552] = 
    "----><br>\n\t\t\t\tDocumento Rechazado por: ".toCharArray();
    __oracle_jsp_text[553] = 
    "<br>\n\t\t\t\tRazón de Rechazo: ".toCharArray();
    __oracle_jsp_text[554] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[555] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[556] = 
    "----><br>\n\t\t\t\tDocumento Reasignado a: ".toCharArray();
    __oracle_jsp_text[557] = 
    "\n\t\t\t\tpor el Usuario: ".toCharArray();
    __oracle_jsp_text[558] = 
    "<br>\n\t\t\t\tComentarios Adicionales: ".toCharArray();
    __oracle_jsp_text[559] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[560] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[561] = 
    "----><br>\n\t\t\t\tDocumento Delegado a : ".toCharArray();
    __oracle_jsp_text[562] = 
    "\n\t\t\t<br>\n\t\t\t\tComentarios Adicionales: ".toCharArray();
    __oracle_jsp_text[563] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[564] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[565] = 
    "----><br>\n\t\t\t\tEl Usuario: ".toCharArray();
    __oracle_jsp_text[566] = 
    " Generó Instrucciones para Atender la solicitud\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[567] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[568] = 
    "----><br>\n\t\t\t\tPuesto: ".toCharArray();
    __oracle_jsp_text[569] = 
    "\n\t\t\t<br>\n                Comentario: ".toCharArray();
    __oracle_jsp_text[570] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[571] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[572] = 
    "----><br>\n\t\t\t\tEl Usuario ".toCharArray();
    __oracle_jsp_text[573] = 
    " / ".toCharArray();
    __oracle_jsp_text[574] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[575] = 
    "<br>\n                Comentario: ".toCharArray();
    __oracle_jsp_text[576] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[577] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[578] = 
    "----><br>\n\t\t\t\tEl Usuario ".toCharArray();
    __oracle_jsp_text[579] = 
    " / ".toCharArray();
    __oracle_jsp_text[580] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[581] = 
    "<br>\n                Comentario: ".toCharArray();
    __oracle_jsp_text[582] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[583] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[584] = 
    "----><br>\n\t\t\t\tEl Usuario ".toCharArray();
    __oracle_jsp_text[585] = 
    " / ".toCharArray();
    __oracle_jsp_text[586] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[587] = 
    "<br>\n                Comentario: ".toCharArray();
    __oracle_jsp_text[588] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[589] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[590] = 
    " </font></td>\n\t\t".toCharArray();
    __oracle_jsp_text[591] = 
    "\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t\t".toCharArray();
    __oracle_jsp_text[592] = 
    "\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\n\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\"><B><FONT face=\"Arial\"\n\t\t\tcolor=\"#004080\" size=\"2\">Documentos Anexados</FONT></B></td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">\n\t\t<div>\n\t\t".toCharArray();
    __oracle_jsp_text[593] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[594] = 
    " <IFRAME ID=\"frame1\"\n\t\t\tSRC=\"ImportarCMO.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[595] = 
    "&bo=true&IdInst=".toCharArray();
    __oracle_jsp_text[596] = 
    "&fol=".toCharArray();
    __oracle_jsp_text[597] = 
    "&est=".toCharArray();
    __oracle_jsp_text[598] = 
    "\"\n\t\t\tWIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME> ".toCharArray();
    __oracle_jsp_text[599] = 
    " <IFRAME\n\t\t\tID=\"frame1\"\n\t\t\tSRC=\"ImportarAR.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[600] = 
    "&bo=true&IdInst=".toCharArray();
    __oracle_jsp_text[601] = 
    "&fol=".toCharArray();
    __oracle_jsp_text[602] = 
    "&est=".toCharArray();
    __oracle_jsp_text[603] = 
    "\"\n\t\t\tWIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME> ".toCharArray();
    __oracle_jsp_text[604] = 
    " ".toCharArray();
    __oracle_jsp_text[605] = 
    " ".toCharArray();
    __oracle_jsp_text[606] = 
    "\n\t\t<IFRAME ID=\"frame1\"\n\t\t\tSRC=\"ImportarAR.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[607] = 
    "&bo=false&IdInst=".toCharArray();
    __oracle_jsp_text[608] = 
    "&fol=".toCharArray();
    __oracle_jsp_text[609] = 
    "&est=".toCharArray();
    __oracle_jsp_text[610] = 
    "\"\n\t\t\tWIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME> ".toCharArray();
    __oracle_jsp_text[611] = 
    " <IFRAME\n\t\t\tID=\"frame1\"\n\t\t\tSRC=\"ImportarCMO.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[612] = 
    "&bo=false&IdInst=".toCharArray();
    __oracle_jsp_text[613] = 
    "&fol=".toCharArray();
    __oracle_jsp_text[614] = 
    "&est=".toCharArray();
    __oracle_jsp_text[615] = 
    "\"\n\t\t\tWIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME> ".toCharArray();
    __oracle_jsp_text[616] = 
    " ".toCharArray();
    __oracle_jsp_text[617] = 
    "\n\t\t</div>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\n\t".toCharArray();
    __oracle_jsp_text[618] = 
    "\n\n\t<tr valign=\"top\">\n\t\t<td width=\"64%\" colspan=\"2\"><b><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">Firmado<INPUT type=\"hidden\" name=\"firmadoHdn\"\n\t\t\tvalue=\"true\"></font></b>\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t<td width=\"21%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"14%\"><img src=../Imagenes/ecblank.gif \" border=\"0\"\n\t\t\theight=\"1\\\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td align=\"center\"><b>Usuario</b></td>\n\t\t<td align=\"center\"><b>Fecha</b></td>\n\t\t<TD align=\"center\"></TD>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td align=\"center\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td align=\"center\">".toCharArray();
    __oracle_jsp_text[619] = 
    "<INPUT type=\"hidden\"\n\t\t\tname=\"nombreFirmanteHdn\" value=\"".toCharArray();
    __oracle_jsp_text[620] = 
    "\"></td>\n\t\t<td align=\"center\">".toCharArray();
    __oracle_jsp_text[621] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"fechaTerminacionRealHdn\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[622] = 
    "\"></td>\n\t\t<td align=\"center\"><IMG src=\"../Imagenes/0.jpg\" alt=\"firmado\"\n\t\t\twidth=\"30\" height=\"30\"></td>\n\t</tr>\n\t".toCharArray();
    __oracle_jsp_text[623] = 
    "\n</table>\n<br>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[624] = 
    " <script language=JavaScript\n\ttype=text/javascript>\ndoc = document.turnado;\ndoc.submit();\n</script> ".toCharArray();
    __oracle_jsp_text[625] = 
    "\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n<BR>\n<script type=\"text/javascript\">\n<!--\nif (".toCharArray();
    __oracle_jsp_text[626] = 
    "){\n\talert(\"Esta instrucción ha sido modificada por otro usuario y Cambió su Estatus,\\npor lo que la acción solicitada será cancelada\");\n\tlocation.assign(\"portalPrincipal.jsp\");\n}\n//-->\n</script></FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
