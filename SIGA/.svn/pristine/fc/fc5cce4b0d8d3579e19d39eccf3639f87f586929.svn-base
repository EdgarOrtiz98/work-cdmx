<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>

<%@taglib uri="c" prefix="c"%>
<HTML>
<jsp:useBean id="BTurnarInst"
	class="com.meve.sigma.beans.TurnarInstruccionBean" scope="page"></jsp:useBean>
<HEAD>
<TITLE>Instruccion Turnada</TITLE>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,com.meve.sigma.util.*,com.meve.sigma.reportes.*,java.sql.Date"%>

<%@ page import="gob.hacienda.cgtic.siga.actualiza.RechazoInstruccion"%>
<%@ page import="gob.hacienda.cgtic.siga.actualiza.AtenderInstrucciones"%>
<%@ page import="gob.hacienda.cgtic.siga.util.Jefe"%>
<%@	page import="gob.hacienda.cgtic.siga.asunto.AsuntoVerifica"%>

<jsp:useBean id="BEscritura" class="com.meve.sigma.beans.EscrituraBean"
	scope="page"></jsp:useBean>
<jsp:useBean id="BEscritura1" class="com.meve.sigma.beans.EscrituraBean"
	scope="page"></jsp:useBean>
<jsp:useBean id="BEscritura2" class="com.meve.sigma.beans.EscrituraBean"
	scope="page"></jsp:useBean>
<jsp:useBean id="BEscrituraAr"
	class="com.meve.sigma.beans.EscrituraBean" scope="page"></jsp:useBean>
<jsp:useBean id="BEscrituraTur"
	class="com.meve.sigma.beans.EscrituraBean" scope="page"></jsp:useBean>

<%
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
%>
<%
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
		//** ú otra Instrucción 
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

    //Control de acceso seguún sea el perfil del usuario.//
    
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
%>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<%!public static boolean par(int num) {
		boolean p = false;
		if (num % 2 == 0) {
			p = true;
		}
		return p;
	}%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Instrucción</TITLE>
<SCRIPT language=JavaScript type=text/javascript>
	
	//function imprimir(){
    //     var url='ImprimeInstruccionTerminada.jsp?idInstruccion='+<%=strIdInstruccion%>;
    //     var ventanaImpresion=window.open(url,'','',true);
	//}
	valid = 0;
	var botonBandera = true;

	function imprimir(){
		var isCenter ='true';
		var features = '';

		if(window.screen)if(isCenter)if(isCenter=="true"){
		    var myLeft = (screen.width-800)/2;
		    var myTop = (screen.height-600)/2;
		    features+=(features!='')?',':'';
		    features+=',left='+myLeft+',top='+myTop; 
		}
		window.open("../ReporteInstruccion?id="+<%=strIdInstruccion%>, "", features+((features!='')?',':'')+'width=800, height=600 , resizable=yes');
	}
	function Regresar(){
		location.assign('<%=retURI%>');		 
	}
	function Responder(){
		location.assign('Responder.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&id_es=<%=strEstatus%>&ava=<%=strAvance%>&us_or=<%=strUsuarioOriginal%>&estValidacion=<%= strEstValidacion %>');
	}
	function Rechazar(){
		location.assign('Rechazar.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&tur=<%=strTurnadoPor%>&ava=<%=strAvance%>&ins=<%=strNombreInstruccion%>&estValidacion=<%= strEstValidacion %>&retURI1=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp)%>&retURI2=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)%>');
	}
	function Reasignar(){
		location.assign('Reasignar.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&ava=<%=strAvance%>&usr_ori=<%=strUsuarioOriginal%>&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>&retURI2=<%=Utilerias.codificaPostHTML(retURI)%>');
	}
	function Delegar(){
		location.assign('Delegar.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&ava=<%=strAvance%>&usr_ori=<%=strUsuarioOriginal%>');
	}
	function Turnar(){
		doc = document.turnado;
		doc.accion.value="desturnar";
		doc.submit();
	}
	function TerminarRechazada(){
		doc = document.turnado;
		doc.accion.value="terminarRechazada";
		doc.submit();
	}
	function turnar1(){
		
		doc = document.turnado;
		doc.accion.value="turnar";
		if(<%=bEstanVacias%>){
		   alert("Existen instrucciónes incompletas. Verifique en la ruta de atención")
		   botonBandera=true;
		}else{
		  if(valid == 0){
			 if (confirm("Está usted seguro que desea Turnar las instrucciones?")) {
				doc.submit();
				valid=1;
			}else{
				alert("Su petición de Turnado ya fue cancelada");
                                botonBandera=true;
			}
		 }else if(valid == 1){
			alert("Su solicitud ya fue enviada");
		 }
	  }
	}
	function firmar(){
		location.assign('http://192.168.0.144:8080/firma/explorer_applet.html');
	}
   	function agregarComentario(){
            //location.assign('AgregarComentarioInstruccion.jsp?id_ins=<%=strIdInstruccion%>&tur=<%=strTurno%>&ins=<%=strNombreInstruccion%>&a=2&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');
            location.assign('AgregarComentarioInstruccion.jsp?id_ins=<%=strIdInstruccion%>&tur=<%=strTurno%>&ins=<%=strNombreInstruccion%>&a=2&estValidacion=<%= strEstValidacion %>&retURI=<%=Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH)%>&retURI2=<%=Utilerias.codificaPostHTML(retURI)%>');
	}
	function agregarContent() {
		location.assign('ImportarCM.jsp?Folio=<%=strFolioRecepcion%>&IdAsunto=<%=strIdAsunto%>&a=3&id_ins=<%=strIdInstruccion%>&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');
	}
	function agregar()
	{
		var frameNvaRef = '<%= serverContentManager %>/eclient/SIGMA/Avance.jsp?id=<%=strIdAsunto%>&bo=true&it=<%=strItemType%>';
		document.getElementById('frame1').src  = frameNvaRef;		
	}
	function cambioFecha(){
		location.assign('CambioFechaInst.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&tur=<%=strTurno%>&i=<%=iTieneFechaCambio%>&re=3&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');
	}
	function cargaApplet(){
		location.assign('VisualizaInstrucciones.jsp?idAsunto=<%=strIdAsunto%>&Instruccion=<%= strIdInstruccion %>&Url=<%=URL%>&retURI=<%=Utilerias.codificaPostHTML(retURI)%>');
	}
	function cargaAppletMul(){
		location.assign('delMultiple.jsp?idAsunto=<%=strIdAsunto%>&Instruccion=<%= strIdInstruccion %>&retURI=<%=Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI))%>&us=<%=strUsuarioOriginal%>');
	}
	function escaner(){
		<% if(strActivarCM.equals("si")){ %>
		location.assign('sigmaCM:%20<%= serverContentManager %>/eclient/ArchivoCM%20<%=strItemType%>%20escanear%20false%20<%=strIdAsunto%>%20<%="SinFilio"%>%20<%=BUsuario.getNombre()%>');
		<%}else{%>
		location.assign('sigmaCM:%20<%=server%><%=strBase%>/ArchivoCM%20<%=strItemType%>%20escanear%20true%20<%=strIdAsunto%>%20<%="SinFolio"%>%20<%=BUsuario.getIdUsuario()%>');
		<%}%>
	}
</SCRIPT>
<STYLE type=text/css>
BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="timer_load();"
	onclick="timer_reload();" onkeypress="timer_reload();">
<FORM action="InstruccionTurnada.jsp" name="turnado" method="post">
<INPUT name="turnar" value="" type="hidden"> <INPUT
	name="id_ins" value="<%= strIdInstruccion %>" type="hidden"> <INPUT
	type="hidden" value="" name="accion"> <INPUT name="retURI"
	value="<%=retURI%>" type="hidden"> <INPUT name="retURI2"
	value="<%=retURI2%>" type="hidden"> <INPUT name="dif"
	value="<%=strDif%>" type="hidden"> <INPUT type="hidden"
	value="<%=strEstValidacion%>" name="estValidacion">
<TABLE cellspacing="0" cellpadding="0" width="99%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%" colspan="2">
			<DIV align="right"></DIV>
			</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<%if(strBandera1.equals("1")){%>
		<td width="863">
		<% if(strEstatus.equals("1")){ %>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Asunto Por Atender</font></b></div>
		<% }else if(strEstatus.equals("2")){ %>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Asunto En Trámite</font></b></div>
		<% }else if(strEstatus.equals("3")){ %>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Asunto Rechazado</font></b></div>
		<% }else if(strEstatus.equals("4")){ %>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Asunto Terminado</font></b></div>
		<% } %>
		</td>
		<% }else{ %>
		<td width="863">
		<% if(strEstatus.equals("1")){ %>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Instrucción Por Atender</font></b></div>
		<% }else if(strEstatus.equals("2")){ %>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Instrucción En Trámite</font></b></div>
		<% }else if(strEstatus.equals("3")){ %>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Instrucción Rechazada</font></b></div>
		<% }else if(strEstatus.equals("4")){ %>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Instrucción Terminada</font></b></div>
		<% } %>
		</td>
		<% } %>
	</tr>
</table>
</DIV>
<br>

<DIV align="center">

<table border="0" cellspacing="0" cellpadding="0" width="863">
	<tr>
		<td>
		<table border="0" cellspacing="0" cellpadding="0">
			<tr valign="top">
				<td width="60"><A
					onclick="if(botonBandera){botonBandera=false; location.assign('<%=retURI%>');}"
					onMouseOver="document.MyImage.src='../Imagenes/NavLeft2.gif';"
					onMouseOut="document.MyImage.src='../Imagenes/NavLeft.gif';"> <IMG
					border="0" src="../Imagenes/NavLeft.gif" title="Regresar / Cancelar"
					name="MyImage"></A></td>
				<%if(strTipoAtencion.equals("1")){%>
				<%if(strEstatus.equals("1") || strEstatus.equals("2")){%>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<%if(!strEstatus.equals("1")){%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; location.assign('Responder.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&id_es=<%=strEstatus%>&ava=<%=strAvance%>&us_or=<%=strUsuarioOriginal%>&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');}"
							onMouseOver="document.Responder3.src='../Imagenes/Responder2.gif';"
							onMouseOut="document.Responder3.src='../Imagenes/Responder.gif';"><IMG
							src="../Imagenes/Responder.gif" border=0 name="Responder3"
							title="Responder"></A></td>
						<%}%>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscritura.value}'>

						<%if(strInsHijos.length == 0){%>
						<%if(bTieneSubordinados){%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Turnar();}"
							onMouseOver="document.Habilitar2.src='../Imagenes/elim_delg_multiple2.gif';"
							onMouseOut="document.Habilitar2.src='../Imagenes/elim_delg_multiple.gif';">
						<IMG border="0" src="../Imagenes/elim_delg_multiple.gif"
							title="Deshabilitar Delegación Multiple" name="Habilitar2"></A></td>
						<%}%>
						<%}%>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscrituraAr.value}'>
						<td width="60"><a
							onclick="if(botonBandera){botonBandera=false; agregarContent();}"
							onMouseOver="document.Insertar.src='../Imagenes/Attach2.gif';"
							onMouseOut="document.Insertar.src='../Imagenes/Attach.gif';">
						<IMG border="0" src="../Imagenes/Attach.gif"
							title="Insertar Archivo" name="Insertar"></a></td>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; agregarComentario();}"
							onMouseOver="document.Comentario.src='../Imagenes/Comentario2.gif';"
							onMouseOut="document.Comentario.src='../Imagenes/Comentario.gif';">
						<IMG border="0" src="../Imagenes/Comentario.gif"
							title="Crear un Comentario" name="Comentario"></A></td>
					</c:when>
				</c:choose>

				<c:choose>
					<c:when test='${BEscritura.value}'>
						<% if(strInsHijos.length == 0){ %>
						<td width="60">
						<DIV align="left"><A
							onclick="if(botonBandera){botonBandera=false; cargaAppletMul();}"
							onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
							onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
						<IMG border="0" src="../Imagenes/CrearRuta.gif" title="Crear ruta"
							name="CrearRuta" /></A></DIV>
						</TD>
						<%}else if(strInsHijos.length>0 && sumEstatus == 0){%>
						<td width="60">

						<DIV align="left">
						<%if(strBandera1.equals("1")){ %> <A
							onclick="if(botonBandera){botonBandera=false; cargaApplet();}"
							onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
							onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
						<IMG border="0" src="../Imagenes/CrearRuta.gif"
							title="Ver Ruta de Atención" name="CrearRuta"></A> <%}else{ %> <A
							onclick="if(botonBandera){botonBandera=false; cargaAppletMul();}"
							onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
							onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
						<IMG border="0" src="../Imagenes/CrearRuta.gif"
							title="Ver Ruta de Atención" name="CrearRuta" /></A> <%} %>
						</div>
						</TD>
						<td width="60">
						<DIV align="left"><A onclick="turnar1()"
							onMouseOver="document.Turnar.src='../Imagenes/Turnar2.gif';"
							onMouseOut="document.Turnar.src='../Imagenes/Turnar.gif';"> <IMG
							border="0" src="../Imagenes/Turnar.gif" title="Turnar"
							name="Turnar"> </A></DIV>
						</TD>
						<%}else if(estatusHijos.length() > 0 && sumEstatus > 0){%>
						<td width="60">
						<DIV align="left"><A
							onclick="if(botonBandera){botonBandera=false; cargaAppletMul();}"
							onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
							onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
						<IMG border="0" src="../Imagenes/CrearRuta.gif" title="Editar Ruta"
							name="CrearRuta" /> </A></DIV>
						</TD>
						<%if(ActualizaInstrucciones.getTieneHijosPorTurnar(strIdInstruccion)){%>
						<td width="60">
						<DIV align="left"><A
							onclick="if(botonBandera){botonBandera=false; turnar1();}"
							onMouseOver="document.Turnar.src='../Imagenes/Turnar2.gif';"
							onMouseOut="document.Turnar.src='../Imagenes/Turnar.gif';"><IMG
							border="0" src="../Imagenes/Turnar.gif" title="Turnar"
							name="Turnar" /></A></DIV>
						</TD>
						<%}%>
						<%}%>
					</c:when>
				</c:choose>

				<td width="400">&nbsp;</td>
				<%}else{%>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<td width="60"><A onclick="if(botonBandera){imprimir(); }"
							onMouseOver="document.Imprimir.src='../Imagenes/Imprimir2.gif';"
							onMouseOut="document.Imprimir.src='../Imagenes/Imprimir.gif';">
						<IMG border="0" src="../Imagenes/Imprimir.gif" title="Imprimir"
							name="Imprimir"></A></td>
					</c:when>
				</c:choose>
				<td width="500">&nbsp;</td>
				<%}%>
				<!-- Instrucciones que son de tipo ejecutorias  -->
				<%}else{%>
				<!-- Instrucciones que ya estan terminadas  -->
				<%if(strEstatus.equals("4")){ %>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<td width="60"><A onclick="if(botonBandera){imprimir(); }"
							onMouseOver="document.Imprimir.src='../Imagenes/Imprimir2.gif';"
							onMouseOut="document.Imprimir.src='../Imagenes/Imprimir.gif';">
						<IMG border="0" src="../Imagenes/Imprimir.gif" title="Imprimir"
							name="Imprimir"></A></td>
					</c:when>
				</c:choose>
				<%}%>
				<!-- Si la instruccion tiene como estatus "Por atender", se mostraran todos los botones -->
				<% if(!bhijosTurnados){ %>
				<% if(strEstatus.equals("1")){ %>
				<% if(!bTieneHijos){ %>
				<c:choose>
					<c:when test='${BEscrituraTur.value}'>
						<%if(strBandera1.equals("0")){%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; location.assign('Responder.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&id_es=<%=strEstatus%>&ava=<%=strAvance%>&us_or=<%=strUsuarioOriginal%>&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');}"
							onMouseOver="document.Responder3.src='../Imagenes/Responder2.gif';"
							onMouseOut="document.Responder3.src='../Imagenes/Responder.gif';"><IMG
							src="../Imagenes/Responder.gif" border=0 name="Responder3"
							title="Responder"></A></td>
						<%}%>
					</c:when>
				</c:choose>

				<c:choose>
					<c:when test='${BEscrituraTur.value}'>
						<%if(strBandera1.equals("0")){%>
						<%if(bTieneSubordinados){%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Turnar();}"
							onMouseOver="document.Habilitar2.src='../Imagenes/elim_delg_multiple2.gif';"
							onMouseOut="document.Habilitar2.src='../Imagenes/elim_delg_multiple.gif';">
						<IMG border="0" src="../Imagenes/elim_delg_multiple.gif"
							title="Deshabilitar Delegación Multiple" name="Habilitar2"></A></td>
						<%}%>
						<%}%>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscrituraTur.value}'>
						<%if(strBandera1.equals("0")){%>
						<%if(bTieneSubordinados){%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Reasignar();}"
							onMouseOver="document.Reasignar2.src='../Imagenes/Reasignar2.gif';"
							onMouseOut="document.Reasignar2.src='../Imagenes/Reasignar.gif';">
						<IMG border="0" src="../Imagenes/Reasignar.gif" title="Reasignar"
							name="Reasignar2"></A></td>
						<%}%>
						<%}%>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscrituraTur.value}'>
						<%if(strBandera1.equals("0")){%>
						<%if(strPadre.length() == 0){%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Rechazar();}"
							onMouseOver="document.Rechazar2.src='../Imagenes/Rechazar2.gif';"
							onMouseOut="document.Rechazar2.src='../Imagenes/Rechazar.gif';">
						<IMG border="0" src="../Imagenes/Rechazar.gif" title="Rechazar"
							name="Rechazar2"></A></td>
						<%}%>
						<%}%>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscrituraAr.value}'>
						<td width="60"><a
							onclick="if(botonBandera){botonBandera=false; agregarContent();}"
							onMouseOver="document.Insertar.src='../Imagenes/Attach2.gif';"
							onMouseOut="document.Insertar.src='../Imagenes/Attach.gif';">
						<IMG border="0" src="../Imagenes/Attach.gif"
							title="Insertar Archivo" name="Insertar"></a></td>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscritura2.value}'>
						<%if(strBandera1.equals("0")){%>
						<% if(!bTieneTramite && iTieneFechaCambio == 2){ %>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; cambioFecha();}"
							onMouseOver="document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';"
							onMouseOut="document.cambioFecha1.src='../Imagenes/CambioFecha.gif';">
						<IMG border="0" src="../Imagenes/CambioFecha.gif"
							title="Solicitar Cambio de Fecha" name="cambioFecha1"></A></td>
						<% }else if(!bTieneTramite && iTieneFechaCambio == 1){ %>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; cambioFecha();}"
							onMouseOver="document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';"
							onMouseOut="document.cambioFecha1.src='../Imagenes/CambioFecha.gif';">
						<IMG border="0" src="../Imagenes/CambioFecha.gif"
							title="Cambiar Fecha" name="cambioFecha1"></A></td>
						<% } %>
						<%}%>
					</c:when>
				</c:choose>

				<c:choose>
					<c:when test='${BEscritura.value}'>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; agregarComentario();}"
							onMouseOver="document.Comentario.src='../Imagenes/Comentario2.gif';"
							onMouseOut="document.Comentario.src='../Imagenes/Comentario.gif';">
						<IMG border="0" src="../Imagenes/Comentario.gif"
							title="Crear un Comentario" name="Comentario"></A></td>
					</c:when>
				</c:choose>
				<%if(strBandera1.equals("1")){%>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; cargaApplet();}"
							onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
							onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
						<IMG border="0" src="../Imagenes/CrearRuta.gif" title="Crear ruta"
							name="CrearRuta"></A></td>
					</c:when>
				</c:choose>
				<%}%>
				<%if(bTieneSubordinados){%>
				<% if(strEstatus.equals("1") || strEstatus.equals("2") || strEstatus.equals("3")){ %>
				<% if(strInsHijos.length == 0){ %>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<%if(strBandera1.equals("0")){%>
						<td width="60" align="center"><%--Crear Ruta applet2--%> <A
							onclick="if(botonBandera){botonBandera=false; cargaAppletMul();}"
							onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
							onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
						<IMG border="0" src="../Imagenes/CrearRuta.gif" title="Crear ruta"
							name="CrearRuta"></A></td>
						<%}else{%>
						<td width="60" align="center"><%--Crear Ruta applet1--%> <A
							onclick="if(botonBandera){botonBandera=false; cargaApplet();}"
							onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
							onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
						<IMG border="0" src="../Imagenes/CrearRuta.gif" title="Crear ruta"
							name="CrearRuta"></A></td>
						<%}%>
					</c:when>
				</c:choose>
				<% }else if(estatusHijos.length() > 0 && sumEstatus > 0){ %>
				<td width="60">&nbsp;</td>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<A onclick="if(botonBandera){botonBandera=false; cargaApplet();}"
							onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
							onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
						<IMG border="0" src="../Imagenes/CrearRuta.gif" title="Editar Ruta"
							name="CrearRuta"></A>
					</c:when>
				</c:choose>
				<% } %>
				<%}%>
				<%}%>
				<%--Fin if si no tiene hijos  if(!bTieneHijos){  --%>
				<% }else{ %>
				<c:choose>
					<c:when test='${BEscrituraAr.value}'>
						<td width="60"><a
							onclick="if(botonBandera){botonBandera=false; agregarContent();}"
							onMouseOver="document.Insertar.src='../Imagenes/Attach2.gif';"
							onMouseOut="document.Insertar.src='../Imagenes/Attach.gif';">
						<IMG border="0" src="../Imagenes/Attach.gif"
							title="Insertar Archivo" name="Insertar"></a></td>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; agregarComentario();}"
							onMouseOver="document.Comentario.src='../Imagenes/Comentario2.gif';"
							onMouseOut="document.Comentario.src='../Imagenes/Comentario.gif';">
						<IMG border="0" src="../Imagenes/Comentario.gif"
							title="Crear un Comentario--" name="Comentario"></A></td>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<%if(strBandera1.equals("0")){%>
						<td width="60"><%--Carga Applet2 para ver ruta--%>
						<DIV align="left"><A
							onclick="if(botonBandera){botonBandera=false; cargaAppletMul();}"
							onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
							onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
						<IMG border="0" src="../Imagenes/CrearRuta.gif"
							title="Ver Ruta de Atención" name="CrearRuta"></A></DIV>
						</TD>
						<td width="60">
						<DIV align="left"><A
							onclick="if(botonBandera){botonBandera=false; turnar1();}"
							onMouseOver="document.Turnar.src='../Imagenes/Turnar2.gif';"
							onMouseOut="document.Turnar.src='../Imagenes/Turnar.gif';"><IMG
							border="0" src="../Imagenes/Turnar.gif" title="Turnar"
							name="Turnar"></A></DIV>
						</TD>
						<%}else{%>
						<%
					boolean bVacios=false;
					bVacios=ActualizaInstrucciones.getInstruccionHijasVacias(strIdInstruccion);
				%>
						<td width="60"><%--Carga Applet1 para ver ruta de la ventanilla 2 Hola--%>
						<DIV align="left"><A
							onclick="if(botonBandera){botonBandera=false; cargaApplet();}"
							onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
							onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
						<IMG border="0" src="../Imagenes/CrearRuta.gif"
							title="Ver Ruta de Atención" name="CrearRuta"></A></div>
						</TD>
						<%if(!bVacios){%>
						<td width="60">
						<DIV align="left"><A
							onclick="if(botonBandera){botonBandera=false; turnar1();}"
							onMouseOver="document.Turnar.src='../Imagenes/Turnar2.gif';"
							onMouseOut="document.Turnar.src='../Imagenes/Turnar.gif';"> <IMG
							border="0" src="../Imagenes/Turnar.gif" title="Turnar"
							name="Turnar"> </A></DIV>
						</TD>
						<%}%>
						<%}%>
					</c:when>
				</c:choose>

				<td width="300">&nbsp;</td>
				<%}%>
				<!-- Fin de si tienes hijos -->
				<td width="300">&nbsp;</td>

				<!-- Si la instrucción se encuestra en tramite, no mostrara el boton de rechazar -->
				<% }else if(strEstatus.equals("2") && strDelegado.length() == 0){ %>
				<c:choose>
					<c:when test='${BEscrituraTur.value}'>
						<td width="60" vAlign=top><A
							onclick="if(botonBandera){botonBandera=false; location.assign('Responder.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&id_es=<%=strEstatus%>&ava=<%=strAvance%>&us_or=<%=strUsuarioOriginal%>&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');}"
							onMouseOver="document.Responder3.src='../Imagenes/Responder2.gif';"
							onMouseOut="document.Responder3.src='../Imagenes/Responder.gif';"><IMG
							src="../Imagenes/Responder.gif" border=0 name="Responder3"
							title="Responder"></A></td>
					</c:when>
				</c:choose>

				<c:choose>
					<c:when test='${BEscrituraTur.value}'>
						<%if(bTieneSubordinados){%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Turnar();}"
							onMouseOver="document.Habilitar2.src='../Imagenes/elim_delg_multiple2.gif';"
							onMouseOut="document.Habilitar2.src='../Imagenes/elim_delg_multiple.gif';">
						<IMG border="0" src="../Imagenes/elim_delg_multiple.gif"
							title="Deshabilitar Delegación Multiple" name="Habilitar2"></A></td>
						<%}%>
					</c:when>
				</c:choose>

				<c:choose>
					<c:when test='${BEscrituraTur.value}'>
						<%if(bTieneSubordinados){%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Reasignar();}"
							onMouseOver="document.Reasignar2.src='../Imagenes/Reasignar2.gif';"
							onMouseOut="document.Reasignar2.src='../Imagenes/Reasignar.gif';">
						<IMG border="0" src="../Imagenes/Reasignar.gif" title="Reasignar"
							name="Reasignar2"></A></td>
						<%}%>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscrituraAr.value}'>
						<td width="60"><a
							onclick="if(botonBandera){botonBandera=false; agregarContent();}"
							onMouseOver="document.Insertar.src='../Imagenes/Attach2.gif';"
							onMouseOut="document.Insertar.src='../Imagenes/Attach.gif';">
						<IMG border="0" src="../Imagenes/Attach.gif"
							title="Insertar Archivo" name="Insertar"></a></td>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscritura2.value}'>
						<% if(!bTieneTramite && iTieneFechaCambio == 2){ %>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; cambioFecha();}"
							onMouseOver="document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';"
							onMouseOut="document.cambioFecha1.src='../Imagenes/CambioFecha.gif';">
						<IMG border="0" src="../Imagenes/CambioFecha.gif"
							title="Solicitar Cambio de Fecha" name="cambioFecha1"></A></td>
						<% }else if(!bTieneTramite && iTieneFechaCambio == 1){ %>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; cambioFecha();}"
							onMouseOver="document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';"
							onMouseOut="document.cambioFecha1.src='../Imagenes/CambioFecha.gif';">
						<IMG border="0" src="../Imagenes/CambioFecha.gif"
							title="Cambiar Fecha" name="cambioFecha1"></A></td>
						<% } %>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; agregarComentario();}"
							onMouseOver="document.Comentario.src='../Imagenes/Comentario2.gif';"
							onMouseOut="document.Comentario.src='../Imagenes/Comentario.gif';">
						<IMG border="0" src="../Imagenes/Comentario.gif"
							title="Crear un Comentario" name="Comentario"></A></td>
					</c:when>
				</c:choose>
				<%if(bTieneSubordinados){%>
				<% if(strInsHijos.length == 0){ %>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<td width="60" align="center"><A
							onclick="if(botonBandera){botonBandera=false; cargaAppletMul();}"
							onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
							onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
						<IMG border="0" src="../Imagenes/CrearRuta.gif" title="Crear ruta"
							name="CrearRuta"></A> <!-- <input type="button"
					onclick="cargaApplet()"
					value="Crear ruta" class="blue200">--></td>
					</c:when>
				</c:choose>
				<% }else if(estatusHijos.length() > 0 && sumEstatus > 0){ %>
				<td width="60">&nbsp;</td>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<A
							onclick="if(botonBandera){botonBandera=false; cargaAppletMul();}"
							onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
							onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
						<IMG border="0" src="../Imagenes/CrearRuta.gif" title="Editar Ruta"
							name="CrearRuta"></A>
					</c:when>
				</c:choose>
				<% }else if(strInsHijos.length > 0){ %>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<td width="60">
						<DIV align="left"><A
							onclick="if(botonBandera){botonBandera=false; cargaAppletMul();}"
							onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
							onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
						<IMG border="0" src="../Imagenes/CrearRuta.gif"
							title="Ver Ruta de Atención" name="CrearRuta" /> </A></DIV>
						</TD>
						<td width="60">
						<DIV align="left"><A
							onclick="if(botonBandera){botonBandera=false; turnar1();}"> <IMG
							border="0" src="../Imagenes/Turnar.gif" title="Turnar" /> </A></DIV>
						</TD>
					</c:when>
				</c:choose>
				<%}%>
				<%}%>
				<td width="300">&nbsp;</td>
				<!-- 	Si la instruccion ha sido rechazada, solo mostrara los 
				botones de reasignar -->
				<% }else if(strEstatus.equals("3")){ %>
				<c:choose>
					<c:when test='${BEscritura1.value}'>
						<%
				boolean tiene = false;
				strSubordinado = ActualizaUsuario.getSubordinados(strTurno);
				if(strSubordinado.length!=0)
					tiene = true;
				else
					tiene = false;
				//Checar caso de insidencia
                                
				if(tiene){%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Reasignar();}"
							onMouseOver="document.Reasignar2.src='../Imagenes/Reasignar2.gif';"
							onMouseOut="document.Reasignar2.src='../Imagenes/Reasignar.gif';">
						<IMG border="0" src="../Imagenes/Reasignar.gif" title="Reasignar"
							name="Reasignar2"></A></td>
						<%}%>
						<% if(!strTipoAtencion.equals("1")){ %>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; TerminarRechazada();}"
							onMouseOver="document.TerRechazada.src='../Imagenes/Responder2.gif';"
							onMouseOut="document.TerRechazada.src='../Imagenes/Responder.gif';">
						<IMG border="0" src="../Imagenes/Responder.gif"
							title="Terminar Instrucción Rechazada" name="TerRechazada"></A></td>
						<% } %>
					</c:when>
				</c:choose>
				<TD width="400">&nbsp;</TD>

				<!-- Si la instrucción ha sido terminada, no mostrara ningun boton -->
				<% }else if(strEstatus.equals("4")){ %>
				<td width="600">&nbsp;</td>
				<!-- Si la instrucción ha sido delegada, solo mostrara los botones de responder y delegar -->
				<% }else if(strEstatus.equals("2") && strDelegado.length() > 0){ %>
				<c:choose>
					<c:when test='${BEscrituraTur.value}'>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; location.assign('Responder.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&id_es=<%=strEstatus%>&ava=<%=strAvance%>&us_or=<%=strUsuarioOriginal%>&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');}"
							onMouseOver="document.Responder3.src='../Imagenes/Responder2.gif';"
							onMouseOut="document.Responder3.src='../Imagenes/Responder.gif';"><IMG
							src="../Imagenes/Responder.gif" border="0" name="Responder3"
							title="Responder"></A></td>
					</c:when>
				</c:choose>

				<c:choose>
					<c:when test='${BEscritura.value}'>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Delegar();}"
							onMouseOver="document.Delegar2.src='../Imagenes/Delegar2.gif';"
							onMouseOut="document.Delegar2.src='../Imagenes/Delegar.gif';">
						<IMG border="0" src="../Imagenes/Delegar.gif" title="Delegar"
							name="Delegar2"></A>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; agregarComentario();}"
							onMouseOver="document.Comentario.src='../Imagenes/Comentario2.gif';"
							onMouseOut="document.Comentario.src='../Imagenes/Comentario.gif';">
						<IMG border="0" src="../Imagenes/Comentario.gif"
							title="Crear un Comentario" name="Comentario"></A></td>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscrituraAr.value}'>
						<td width="60"><a
							onclick="if(botonBandera){botonBandera=false; agregarContent();}"
							onMouseOver="document.Insertar.src='../Imagenes/Attach2.gif';"
							onMouseOut="document.Insertar.src='../Imagenes/Attach.gif';">
						<IMG border="0" src="../Imagenes/Attach.gif"
							title="Insertar Archivo" name="Insertar"></a></td>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscritura2.value}'>
						<% if(!bTieneTramite){ %>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; cambioFecha();}"
							onMouseOver="document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';"
							onMouseOut="document.cambioFecha1.src='../Imagenes/CambioFecha.gif';">
						<IMG border="0" src="../Imagenes/CambioFecha.gif"
							title="Solicitar Cambio de Fecha" name="cambioFecha1"></A></td>
						<% } %>
					</c:when>
				</c:choose>
				<td width="623">&nbsp;</td>
				<% } %>
				<%--Fin de si hijas ya estas turnadas--%>
				<% }else{ %>
				<%
			int iTerminada = ActualizaInstrucciones.getInstruccionesTerminadas(strIdInstruccion);
			float fAvance = new Float(strAvance).floatValue();
		%>
				<%if(fAvance <100 && iTerminada==0){%>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; location.assign('Responder.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&id_es=<%=strEstatus%>&ava=<%=strAvance%>&us_or=<%=strUsuarioOriginal%>&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');}"
							onMouseOver="document.Responder3.src='../Imagenes/Responder2.gif';"
							onMouseOut="document.Responder3.src='../Imagenes/Responder.gif';"><IMG
							src="../Imagenes/Responder.gif" border="0" name="Responder3"
							title="Responder"></A></td>
					</c:when>
				</c:choose>
				<% } %>
				<%if(!(fAvance >= 100)){%>
				<c:choose>
					<c:when test='${BEscrituraAr.value}'>
						<td width="60"><a
							onclick="if(botonBandera){botonBandera=false; agregarContent();}"
							onMouseOver="document.Insertar.src='../Imagenes/Attach2.gif';"
							onMouseOut="document.Insertar.src='../Imagenes/Attach.gif';">
						<IMG border="0" src="../Imagenes/Attach.gif"
							title="Insertar Archivo" name="Insertar"></a></td>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<!--Muestra los el boton de editar ruta en el estatus 2-->
						<%if(strBandera1.equals("0")){%>
						<td width="60">
						<div align="left"><A
							onclick="if(botonBandera){botonBandera=false; cargaAppletMul();}"
							onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
							onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
						<IMG border="0" src="../Imagenes/CrearRuta.gif" title="Editar Ruta"
							name="CrearRuta" /> </A></div>
						</td>
						<%if(ActualizaInstrucciones.getTieneHijosPorTurnar(strIdInstruccion)){%>
						<td width="60">
						<div align="left"><A
							onclick="if(botonBandera){botonBandera=false; turnar1();}"
							onMouseOver="document.Turnar.src='../Imagenes/Turnar2.gif';"
							onMouseOut="document.Turnar.src='../Imagenes/Turnar.gif';"><IMG
							border="0" src="../Imagenes/Turnar.gif" title="Turnar"
							name="Turnar"></A></div>
						</td>
						<%}%>
						<%}else{%>
						<td width="60">
						<div align="left"><A
							onclick="if(botonBandera){botonBandera=false; cargaApplet();}"
							onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
							onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
						<IMG border="0" src="../Imagenes/CrearRuta.gif" title="Editar Ruta"
							name="CrearRuta"></A></div>
						</td>
						<%if(ActualizaInstrucciones.getTieneHijosPorTurnar(strIdInstruccion)){%>
						<td width="60">
						<div align="left"><A
							onclick="if(botonBandera){botonBandera=false; turnar1();}"
							onMouseOver="document.Turnar.src='../Imagenes/Turnar2.gif';"
							onMouseOut="document.Turnar.src='../Imagenes/Turnar.gif';"><IMG
							border="0" src="../Imagenes/Turnar.gif" title="Turnar"
							name="Turnar"></A></div>
						</td>
						<%}%>
						<%}%>
					</c:when>
				</c:choose>

				<% } %>

				<td width="300"></td>
				<%}%>
				<%}%>
			</tr>
		</table>
		</td>
	</tr>
</table>
</DIV>
<br>
<%if(iTieneFechaCambio==1){%>
<DIV align="center">
<TABLE>
	<TBODY>
		<TR>
			<td><FONT size="2" color="red">Se ha solicitado un Cambio
			de Fecha de Vencimiento para esta Instrucción</FONT></td>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<%}%>
<div align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="183"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td align="right" width="394"><font size="2" color="#00204f"
			face="Verdana">Folio:&nbsp;<b><%=strFolioTurnado%></b></font><BR>
		<%if(!strBandera1.equals("0")){%> <font size="2" color="#00204f"
			face="Verdana">Folio de Control:&nbsp;<b><%=strFolioEntrada%></b></font><BR>
		<%}%>
		</td>
	</tr>
	<tr valign="top">
		<td bgcolor="#004080" colspan="4"><img src="../Imagenes/shim.gif"
			width="1" height="2" title=""></td>
	</tr>
</table>
</div>




<DIV class=documentBody id=Body>
<div align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<TR valign="top">
		<TD width="183">&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
	</TR>
	<tr valign="top">
		<td width="183"><font size="2" color="#004080" face="Arial">Nombre:</font>
		</td>
		<td colspan="3" width="680"><font size="2" face="Arial"> <%if(!strBandera1.equals("1") && strEstatus.equals("3")) {%>
		<%=ActualizaHistorial.getUsuarioRechazo(strIdInstruccion)[0][0]%> <%}else if(strUsuarioTermino.length()==0){%>
		<%=strCargo%> <%}else{%> <%=strUsuarioTermino%> <%}%> <INPUT type="hidden"
			name="nombreHdn" value="<%=strNombre%>"> <INPUT type="hidden"
			name="telefonoHdn" value="<%=strTelefono%>"> <INPUT
			type="hidden" name="correoHdn" value="<%=strCorreo%>"> </font></td>
	</tr>
	<TR valign="top">
		<TD width="183">&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
	</TR>

	<tr valign="top">
		<td width="183"><font size="2" color="#004080" face="Arial">Tipo
		de Atención:</font></td>
		<td width=""><font size="2" face="Arial"><%= strAtencion %><INPUT
			type="hidden" name="atencionHdn" value="<%=strAtencion%>"></font></td>
		<td width="" align="right"><font size="2" color="#004080"
			face="Arial">Acceso al Documento Original:&nbsp;&nbsp;</font></td>
		<td width=""><font size="2" face="Arial"><%= strVerDocto %>
		<INPUT type="hidden" name="verDoctoHdn" value="<%=strVerDocto%>"></font>
		<% if(strAcceso.equals("1")){ %> <%if(strPadre.length()!=0){%> <A
			href="InstruccionTurnada.jsp?id_ins=<%= strPadre %>&ih=<%=strIdInstruccion%>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>">
		<IMG SRC='../Imagenes/type_document.gif' BORDER=0> </A> <%}else{%> <A
			href="AsuntoTurnado.jsp?id_asunto=<%= strIdAsunto %>&per=1&inst=1&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>">
		<IMG SRC='../Imagenes/type_document.gif' BORDER=0> </A> <%}%> <%}%>
		</td>
	</tr>
	<TR valign="top">
		<TD width="183">&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
	</TR>
	<tr valign="top">
		<td width="183"><font size="2" color="#004080" face="Arial">Asunto:</font>
		</td>
		<td colspan="3" width="680"><font size="2" face="Arial"><%= strAsunto %><INPUT
			type="hidden" name="asuntoHdn" value="<%=strAsunto%>"><INPUT
			type="hidden" name="pasoHdn" value="<%=strPaso%>"></font></td>
	</tr>

	<TR valign="top">
		<TD width="183">&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
	</TR>
	<tr valign="top">
		<td width="183"><font size="2" color="#004080" face="Arial">Fecha
		de Generación:</font></td>
		<td width=""><font size="2" face="Arial"><%=strFecGeneracion%><INPUT
			type="hidden" name="fechaGenHdn" value="<%=strFecGeneracion%>"></font>
		</td>
		<td align="right"><font size="2" color="#004080" face="Arial">Fecha
		Vencimiento:&nbsp;&nbsp;</font></td>
		<td width=""><font size="2" face="Arial"><%=strFecVencimiento%><INPUT
			type="hidden" name="fechaVenHdn" value="<%=strFecVencimiento%>"></font>
		</td>
	</tr>
	<TR valign="top">
		<TD width="183">&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
	</TR>
	<tr valign="top">
		<td width="183"><font size="2" color="#004080" face="Arial">Estatus:</font>
		</td>
		<td>
		<% if(strEstatus.equals("1")){%> <font size="2" face="Arial">Notificado</font>
		<%}else if(strEstatus.equals("2")){%> <font size="2" face="Arial">En
		Trámite</font> <%}else if(strEstatus.equals("3")){%> <font size="2"
			face="Arial">Rechazada</font> <%}else if(strEstatus.equals("4")){%> <font
			size="2" face="Arial">Terminada</font> <%}%>
		</td>
		<td><img src="../Imagenes/ecblank.gif" border="0" height="1"
			width="1" title=""></td>
		<td><img src="../Imagenes/ecblank.gif" border="0" height="1"
			width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183">&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
	</TR>
	<!-- <tr valign="top">
		<td width="183"><font size="2" color="#004080" face="Arial">Delegado
		a:</font></td>
		<% if(strDelegado.length() != 0){ %>
		<td colspan="3" width="680"><font size="2" face="Arial"><% String delegadoA=ActualizaUsuario.NombreUsuario(strDelegado);%>
		<%=delegadoA%> <INPUT type="hidden" name="delegadoAHdn"
			value="<%=delegadoA%>"> </font></td>
		<% }else{ %>
		<td colspan="3" width="380"></td>
		<% } %>
	</tr>
	<TR valign="top">
		<TD width="183">&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
	</TR> -->
	<tr valign="top">
		<td width="183"><font size="2" color="#004080" face="Arial">Asignada
		por: </font></td>
		<td width=""><font size="2" face="Arial">
		<%String turnadoPor=ActualizaUsuario.NombreUsuario(strTurno);%><%=turnadoPor%><input
			type="hidden" name="turnadoPorHdn" value="<%=turnadoPor%>"></font></td>
		<td width=""><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width=""><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td colspan="4"><img src="../Imagenes/shim.gif" width="1"
			height="1" title="">&nbsp;</td>
	</tr>
	<tr valign="top">
		<td width="183"><font size="2" color="#004080" face="Arial">Folio
		de Recepción:</font> <font size="2" face="Arial"> </font></td>
		<td colspan="3" width="680"><font size="2" face="Arial"><%= strFolioRecepcion %>
		<input type="hidden" name="folioRecepcionHdn"
			value="<%=strFolioRecepcion%>"></font></td>
	</tr>
	<tr valign="top">
		<td colspan="4"><img src="../Imagenes/shim.gif" width="1"
			height="1" title="">&nbsp;</td>
	</tr>
	<tr valign="top">
		<td width="183"><font size="2" color="#004080" face="Arial">Folio
		Intermedio:</font></td>
		<td width=""><font size="2" face="Arial"><%= strFolioIntermedio %>

		</font><input type="hidden" name="folioIntermedioHdn"
			value="<%=strFolioIntermedio%>"></td>
		<td width=""><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width=""><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td colspan="4"><img src="../Imagenes/shim.gif" width="1"
			height="1" title="">&nbsp;</td>
	</tr>
</table>
</div>
<br>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="183"><b><font size="2" color="#004080"
			face="Arial">INSTRUCCION</font></b></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td bgcolor="#004080" colspan="4"><img src="../Imagenes/shim.gif"
			width="1" height="2" title=""></td>
	</tr>
	<tr valign="top">
		<td width="183"><img src="../Imagenes/shim.gif" width="1"
			height="1" title="">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td colspan="4"><font size="2" face="Arial"><%= strNombreInstruccion %><input
			type="hidden" name="nombreInstruccionHdn"
			value="<%=strNombreInstruccion%>"></font></td>

	</tr>
	<tr valign="top">
		<td width="183"><img src="../Imagenes/shim.gif" width="1"
			height="1" title="">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
</table>
</DIV>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="183"><b><font size="2" color="#004080"
			face="Arial">SINTESIS</font></b></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	<tr valign="top">
		<td bgcolor="#004080" colspan="4"><img src="../Imagenes/shim.gif"
			width="1" height="2" title=""></td>
	</tr>
	<tr valign="top">
		<td colspan="4"><font size="2" face="Arial"><%= strSintesis %><INPUT
			type="hidden" name="sintesisHdn" value="<%=strSintesis%>"></font></td>
	</tr>
	<tr valign="top">
		<td width="183"><img src="../Imagenes/shim.gif" width="1"
			height="1" title="">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>

</table>
</DIV>
<br>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="183"><b><font size="2" color="#004080"
			face="Arial">EXPEDIENTES</font></b></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	<tr valign="top">
		<td bgcolor="#004080" colspan="4"><img src="../Imagenes/shim.gif"
			width="1" height="2" title=""></td>
	</tr>
	<tr valign="top">
		<td colspan="4"><IFRAME
			src="ExpedienteInstrccion.jsp?ida=<%=strIdInstruccion%>&num=1"
			WIDTH=800 HEIGHT=100 frameborder=0 id="Entidad"></IFRAME></td>
	</tr>


</table>

</DIV>

<br>
<% if(tieneHijos){ %>
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="64%" colspan="2"><B><FONT face="Arial"
				color="#004080" size="2">Lista Ruta de Atención</FONT></B></TD>
			<TD width="21%">&nbsp;</TD>
			<TD width="14%">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="100%" bgcolor="#004080" colspan="4"><IMG height="2"
				title="" src="../Imagenes/shim.gif" width="1"></TD>
		</TR>
		<TR valign="top">
			<TD width="100%" colspan="4">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="100%" colspan="4"><FONT face="Arial" size="2"></FONT>
			<TABLE width="100%" border="0">
				<TBODY>
					<TR valign="top">
						<TD width="2%" bgcolor="#00204f">
						<DIV align="center"><FONT face="Verdana" color="#ffffff"
							size="1">H.</FONT></DIV>
						</TD>
						<TD width="3%" bgcolor="#00204f">
						<DIV align="center"><FONT face="Verdana" color="#ffffff"
							size="1">Paso</FONT></DIV>
						</TD>
						<TD width="17%" bgcolor="#00204f">
						<DIV align="center"><FONT face="Verdana" color="#ffffff"
							size="1">Responsable</FONT></DIV>
						</TD>
						<TD width="15%" bgcolor="#00204f">
						<DIV align="center"><FONT face="Verdana" color="#ffffff"
							size="1">Unidad Administrativa</FONT></DIV>
						</TD>
						<TD width="21%" bgcolor="#00204f">
						<DIV align="center"><FONT face="Verdana" color="#ffffff"
							size="1">N. Instrucción</FONT></DIV>
						</TD>
						<TD width="10%" bgcolor="#00204f">
						<DIV align="center"><FONT face="Verdana" color="#ffffff"
							size="1">F. Recepción</FONT></DIV>
						</TD>
						<TD width="10%" bgcolor="#00204f">
						<DIV align="center"><FONT face="Verdana" color="#ffffff"
							size="1">F. Vencimiento</FONT></DIV>
						</TD>
						<TD width="5%" bgcolor="#00204f">
						<DIV align="center"><FONT face="Verdana" color="#ffffff"
							size="1">D. Plan.</FONT></DIV>
						</TD>
						<TD width="5%" bgcolor="#00204f">
						<DIV align="center"><FONT face="Verdana" color="#ffffff"
							size="1">D. Real</FONT></DIV>
						</TD>
						<TD width="5%" bgcolor="#00204f">
						<DIV align="center"><FONT face="Verdana" color="#ffffff"
							size="1">Avance</FONT></DIV>
						</TD>
						<TD width="5%" bgcolor="#00204f">
						<DIV align="center"><FONT face="Verdana" color="#ffffff"
							size="1">Estatus</FONT></DIV>
						</TD>
						<TD width="2%" bgcolor="#00204f">
						<DIV align="center"><FONT face="Verdana" color="#ffffff"
							size="1">Con.</FONT></DIV>
						</TD>
					</TR>
					<meve_front:ListaDatos
						datos="<%= ActualizaInstrucciones.InstruccionPorIdInstruccion(strIdInstruccion) %>"
						campo="campo">
						<%t++;%>
						<TR valign="top" <%if(par(t)==true){%> <%}else{%>
							bgcolor="#f6f6f6" <%}%>>
							<TD>
							<%if("1".equals(campo17)){%>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1">Si</FONT></DIV>
							<%}else{%>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1">No</FONT></DIV>
							<%}%>
							</TD>
							<TD>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1"><%= campo13 %></FONT></DIV>
							</TD>
							<TD>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1"> <%
								String strterminoUs = ActualizaInstrucciones.getUsuarioTermino(campo12);
								if(strterminoUs.length()==0){
								%> <%=campo20%> <%}else{%> <%=strterminoUs%> <%}%> </FONT></DIV>
							</TD>
							<TD>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1"><%= ActualizaArea.NombreArea(campo10) %></FONT></DIV>
							</TD>
							<TD>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1"> <% if(campo3.length() == 0){ %> <%= campo8 %> <% }else{ %>
							<%= ActualizaInst.getNombreInstruccion1(campo3) %> <% } %> </FONT></DIV>
							</TD>
							<TD>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1"> <% if(campo5.length() == 0){ %>- <% }else{ %> <%= Utilerias.formatearFechas(campo4) %>
							<% } %> </FONT></DIV>
							</TD>
							<TD>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1"> <% if(campo5.length() == 0){ %>- <% }else{ %> <%= Utilerias.formatearFechas(campo5) %>
							<% } %> </FONT></DIV>
							</TD>
							<TD>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1"><%= campo14 %></FONT></DIV>
							</TD>
							<TD>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1"> <%
									boolean bExistenFechas = false;
									bExistenFechas = ActualizaAsuntoTurnado.tieneFechas(campo15);
									if(bExistenFechas){%> <%= campo18 %> <% }else{ %>-<% } %> </FONT></DIV>
							</TD>
							<TD>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1"><%= campo6 %>%</FONT></DIV>
							</TD>
							<TD>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1"> <% if(campo7.equals("1")){ %> <% if(campo17.equals("0")){ %>
							<A
								href="InstruccionHija.jsp?id_ins=<%= campo12 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>">
							<U>Notificado</U></A> <% }else if(campo17.equals("1")){ %> <A
								href="InstruccionTurnada.jsp?id_ins=<%= campo12 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>">
							<U>Notificado</U></A> <% } %> <% }else if(campo7.equals("2")){ %> <% if(campo17.equals("0")){ %>
							<A
								href="InstruccionHija.jsp?id_ins=<%= campo12 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>">
							<U>En Proceso</U></A> <% }else if(campo17.equals("1")){ %> <A
								href="InstruccionTurnada.jsp?id_ins=<%= campo12 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>">
							<U>En Proceso</U></A> <% } %> <% }else if(campo7.equals("3")){ %> <A
								href="InstruccionHija.jsp?id_ins=<%= campo12 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>">
							<U>Rechazada</U></A> <% }else if(campo7.equals("4")){ %> <% if(campo17.equals("0")){ %>
							<A
								href="InstruccionHija.jsp?id_ins=<%= campo12 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>">
							<U>Terminada</U></A> <% }else if(campo17.equals("1")){ %> <A
								href="InstruccionTurnada.jsp?id_ins=<%= campo12 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>">
							<U>Terminada</U></A> <% } %> <% } %>
							</FONT></DIV>
							</TD>
							<TD>
							<%if("1".equals(campo19)){%>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1">Si</FONT></DIV>
							<%}else{%>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1">No</FONT></DIV>
							<%}%>
							</TD>
						</TR>
					</meve_front:ListaDatos>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="100%" colspan="4">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="36%">&nbsp;</TD>
			<TD width="29%">&nbsp;</TD>
			<TD width="21%">&nbsp;</TD>
			<TD width="14%">
			<DIV align="right"></DIV>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<BR>
<% } %> <!-- Historial de la instrucción -->
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0" width="863">
	<tr valign="top">
		<td width="183"><b><font size="2" color="#004080"
			face="Arial">Historia de la Instrucción</font></b></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td bgcolor="#004080" colspan="4"><img src="../Imagenes/shim.gif"
			width="1" height="2" title=""></td>
	</tr>
	<tr valign="top">
		<td width="100%" colspan="4">&nbsp;</td>
	</tr>
	<tr valign="top">
		<% if(bHistorial){ %>
		<td width="100%" colspan="4"><font size="1" color="#004080"
			face="Arial"> <meve_front:ListaDatos
			datos="<%=historialInstruccion%>" campo="campo">
			<% if(campo7.equals("1")){ %>
			<%=campo3 %>----><br>
			<%String avanceUsuario=campo8;%>
			<% if(campo6.equals("Actualización de la instruccion Padre")){ %>
				Se ha alcanzado el estatus de &quot;Terminado&quot; en todas las Instrucciones delegadas <br>
			<U>Avance de: 99%</U>
			<% }else{ %>
				Avance del Usuario: <%= (campo8.indexOf(" / ")!=-1)?campo8:campo8+" / "+ActualizaUsuario.NombrePuesto(campo4) %><br>
			<a
				href="Responder.jsp?id_his=<%= campo1 %>&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML("InstruccionTurnada.jsp?id_ins="+strIdInstruccion+"&ih="+strIH+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>">
			<font size="1" color="#004080" face="Arial"> <U>Avance de:
			<%= campo5 %>%</U><input type="hidden" name="avanceDeHdn"
				value="<%=campo5%>"> </font> </a>
			<% } %>
			<!--<br>
				  Comentarios Adicionales:  //campo6 -->
			<br>
			<br>
			<% }else if(campo7.equals("2")){ %>
			<%=campo3%>----><br>
				Documento Rechazado por: <%= (campo8.indexOf(" / ")!=-1)?campo8:campo8+" / "+ActualizaUsuario.NombrePuesto(campo4) %><br>
				Razón de Rechazo: <%= campo6 %>
			<br>
			<br>
			<% }else if(campo7.equals("3")){ %>
			<%=campo3%>----><br>
				Documento Reasignado a: <%= ActualizaInstrucciones.NombreUsuarioInstruccion(strIdInstruccion) %>
				por el Usuario: <%= (campo8.indexOf(" / ")!=-1)?campo8:campo8+" / "+ActualizaUsuario.NombrePuesto(campo4) %><br>
				Comentarios Adicionales: <%= campo6 %>
			<br>
			<br>
			<% }else if(campo7.equals("4")){ %>
			<%=campo3%>----><br>
				Documento Delegado a : <%=ActualizaUsuario.NombreUsuario(strDelegado)%>
			<br>
				Comentarios Adicionales: <%= campo6 %>
			<br>
			<br>
			<% } else if(campo7.equals("5")){%>
			<%=campo3%>----><br>
				El Usuario: <%= (campo8.indexOf(" / ")!=-1)?campo8:campo8+" / "+ActualizaUsuario.NombrePuesto(campo4) %> generó Instrucciones para Atender la solicitud
			<br>
			<br>
			<% } else if(campo7.equals("6")){%>
			<%=campo3%>----><br>
				Puesto: <%=campo8%>
			<br>
                Comentario: <%=com.meve.sigma.util.Utilerias.cambioSaltosDeLinea(campo6)%>
			<br>
			<br>
			<%} else if(campo7.equals("7")){%>
			<%=campo3%>----><br>
				El Usuario <%=campo8%> / <%=ActualizaUsuario.NombrePuesto(campo4)%>
			<%=campo9%><br>
                Comentario: <%=com.meve.sigma.util.Utilerias.cambioSaltosDeLinea(campo6)%>
			<br>
			<br>
			<%} else if(campo7.equals("8")){%>
			<%=campo3%>----><br>
				El Usuario <%=campo8%> / <%=ActualizaUsuario.NombrePuesto(campo4)%>
			<%=campo9%><br>
                Comentario: <%=com.meve.sigma.util.Utilerias.cambioSaltosDeLinea(campo6)%>
			<br>
			<br>
			<%} else if(campo7.equals("9")){%>
			<%=campo3%>----><br>
				El Usuario <%=campo8%> / <%=ActualizaUsuario.NombrePuesto(campo4)%>
			<%=campo9%><br>
                Comentario: <%=com.meve.sigma.util.Utilerias.cambioSaltosDeLinea(campo6)%>
			<br>
			<br>
			<%}%>
		</meve_front:ListaDatos> </font></td>
		<% }else{ %>
		<td width="100%" colspan="4">&nbsp;</td>
		<% } %>
	</tr>

	<tr valign="top">
		<td width="100%" colspan="4">&nbsp;</td>
	</tr>


	<tr valign="top">
		<td width="100%" colspan="4">&nbsp;</td>
	</tr>
	<tr valign="top">
		<td width="100%" colspan="4">&nbsp;</td>
	</tr>
	<tr valign="top">
		<td width="100%" colspan="4"><B><FONT face="Arial"
			color="#004080" size="2">Documentos Anexados</FONT></B></td>
	</tr>

	<tr valign="top">
		<td width="100%" bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
	</tr>

	<tr valign="top">
		<td width="100%" colspan="4">
		<div>
		<% if(BUsuario.getIdUsuario().equals(strUsuarioOriginal) || 
				  (BUsuario.getTurnado() && 
				  BUsuario.getIdArea().equals(ActualizaUsuario.getAreaUsuario(strUsuarioOriginal)))){ %>
		<% if(strActivarCM.equals("si")){ %> <IFRAME ID="frame1"
			SRC="ImportarCMO.jsp?IdAsunto=<%=strIdAsunto%>&bo=true&IdInst=<%=strIdInstruccion%>&fol=<%=strFolioRecepcion %>&est=<%=strEstatus%>"
			WIDTH="800" HEIGHT="250" frameborder=0></IFRAME> <% }else{ %> <IFRAME
			ID="frame1"
			SRC="ImportarAR.jsp?IdAsunto=<%=strIdAsunto%>&bo=true&IdInst=<%=strIdInstruccion%>&fol=<%=strFolioRecepcion %>&est=<%=strEstatus%>"
			WIDTH="800" HEIGHT="250" frameborder=0></IFRAME> <% } %> <% }else{ %> <% if(strActivarCM.equals("no")){ %>
		<IFRAME ID="frame1"
			SRC="ImportarAR.jsp?IdAsunto=<%=strIdAsunto%>&bo=false&IdInst=<%=strIdInstruccion%>&fol=<%=strFolioRecepcion %>&est=<%=strEstatus%>"
			WIDTH="800" HEIGHT="250" frameborder=0></IFRAME> <% }else{ %> <IFRAME
			ID="frame1"
			SRC="ImportarCMO.jsp?IdAsunto=<%=strIdAsunto%>&bo=false&IdInst=<%=strIdInstruccion%>&fol=<%=strFolioRecepcion %>&est=<%=strEstatus%>"
			WIDTH="800" HEIGHT="250" frameborder=0></IFRAME> <% } %> <% } %>
		</div>
		</td>
	</tr>
	<tr valign="top">
		<td width="100%" colspan="4">&nbsp;</td>
	</tr>
	<tr valign="top">
		<td width="100%" bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
	</tr>

	<% 
		boolean firmado = strFirmaDigital.equals("1");
		if(firmado){
	%>

	<tr valign="top">
		<td width="64%" colspan="2"><b><font size="2" color="#004080"
			face="Arial">Firmado<INPUT type="hidden" name="firmadoHdn"
			value="true"></font></b>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td width="21%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="14%"><img src=../Imagenes/ecblank.gif " border="0"
			height="1\" width="1" title=""></td>
	</tr>

	<tr valign="top">
		<td width="100%" bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
	</tr>
	<tr valign="top">
		<td align="center"><b>Usuario</b></td>
		<td align="center"><b>Fecha</b></td>
		<TD align="center"></TD>
	</tr>
	<tr valign="top">
		<td align="center"></td>
	</tr>
	<tr valign="top">
		<td align="center"><%=strNombre%><INPUT type="hidden"
			name="nombreFirmanteHdn" value="<%=strNombre%>"></td>
		<td align="center"><%=strFechaTerminacionReal%><INPUT
			type="hidden" name="fechaTerminacionRealHdn"
			value="<%=strFechaTerminacionReal%>"></td>
		<td align="center"><IMG src="../Imagenes/0.jpg" title="firmado"
			width="30" height="30"></td>
	</tr>
	<%
 }
    

      
%>
</table>
<br>
</DIV>
<% if(strReload.equals("0")){ %> <script language=JavaScript
	type=text/javascript>
doc = document.turnado;
doc.submit();
</script> <%}%>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
<BR>
<script type="text/javascript">
<!--
if (<%= bValidaEstatus %>){
	alert("Esta Instrucción ha sido modificada por otro usuario y cambió su Estatus,\npor lo que la acción solicitada será cancelada");
	location.assign("portalPrincipal.jsp");
}
//-->
</script></FORM>
</BODY>
</HTML>