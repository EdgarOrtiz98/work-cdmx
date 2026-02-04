<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="c" prefix="c"%>
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
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,com.meve.sigma.reportes.*,java.text.SimpleDateFormat,com.meve.sigma.util.*,java.sql.Date,gob.hacienda.cgtic.siga.actualiza.RechazoInstruccion,gob.hacienda.cgtic.siga.actualiza.AtenderInstrucciones"
	autoFlush="true" buffer="8kb" isThreadSafe="true"%>
<%@ page import="gob.hacienda.cgtic.siga.util.Jefe"%>
<%@ page import="gob.hacienda.cgtic.siga.instruccion.Actualiza"%>
<%@ page import="gob.hacienda.cgtic.siga.Usuario"%>
<%@ page import="gob.hacienda.cgtic.siga.instruccion.Rechazo"%>
<%
	String strIdInstruccion = ""; //Contiene el ID de la instrucción
	strIdInstruccion = (request.getParameter("id_ins") != null) ? request
			.getParameter("id_ins")
			: "";
	request.setAttribute("idInstruccion", strIdInstruccion);
	UsuarioBean BUsuario = (UsuarioBean) session
			.getAttribute("UsuarioBean");
	String strTmp = request.getRequestURI();
	strTmp = strTmp.substring(strTmp.indexOf('/', 2) + 5, strTmp
			.length());
	if (BUsuario == null) {
		try {
			response.sendRedirect("index.jsp?pagina=" + strTmp
			+ "?id_ins=" + strIdInstruccion);
			return;
		} catch (java.io.IOException io) {
		}
	}
	String[][] historialInstruccion = ActualizaHistorial
			.getHistorialInstruccion(strIdInstruccion);
	request.setAttribute("historial", historialInstruccion);
	boolean isEditableRechazo = true;
	String strIdAsunto = ""; //Contiene el ID del Asunto
	String strNombre = "";
	String strTelefono = "";
	String strCorreo = "";
	String strTipoAtencion = "";
	String strAcceso = "";
	String strAsunto = "";
	String strPaso = "";
	String strFecGeneracion = "";
	String strFecVencimiento = "";
	String strEstatus = "";
	String strTurnadoPor = "";
	String strFolioRecepcion = "";
	String strFolioTurnado = "";
	String strFolioIntermedio = "";
	String strInstruccion = "";
	String strInstruccionOtro = "";
	String strSintesis = "";
	String strAtencion = "";
	String strVerDocto = "";
	String strNombreInstruccion = "";
	String strAvance = "";
	String strMostrarHabilitado = "";
	String strDelegado = "";
	String strUsuarioOriginal = "";
	String strFirmaDigital = "";
	String strFechaTerminacionReal = "";
	String strIdAsistente = "";
	String strIdJefe = "";
	String strIdUsuario = "";
	String strIdArea = "";
	String strFechaCambio = "";
	String esDelegado = "";
	String strAccion = "";
	String strPadre = "";
	String strFechaCreacion = "";
	String strHabilitado = "";
	String strBandera = "";
	String strCargo = "";
	String strBandera1 = "";
	String strTurno = "";
	String strUsuarioTermino = "";
	String strIdUsuarioAsistente = "";
	int iTieneFechaCambio = 0;
	String serverContentManager = application
			.getInitParameter("content");
	String server = application.getInitParameter("servername");
	String strActivarCM = application
			.getInitParameter("ActivarContent");
	String strBase = application.getInitParameter("RutaBase");
	String strItemType = (application.getInitParameter("ItemType") == null) ? ""
			: application.getInitParameter("ItemType");
	String strSubordinado[][] = null;
	String asistentes[] = null;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f = new java.util.Date();
	strFechaCreacion = sdf.format(f);

	String url = request.getRequestURI();
	String URL = server + url + "?id_ins=" + strIdInstruccion;

	String retURI = (request.getParameter("retURI") == null) ? "portalPrincipal.jsp"
			: request.getParameter("retURI");
	String retURI2 = (request.getParameter("retURI2") == null) ? retURI
			: request.getParameter("retURI2");

	boolean bHistorial = false;
	boolean bActualizaInf = false;
	boolean bInsertar = false;
	boolean bTieneSubordinados = false;
	boolean bTieneTramite = false;
	boolean bAsistente = false;

	strAccion = request.getParameter("accion");

	if (strInstruccion != null) {
		String strDatosInstrucciones[][] = ActualizaInstrucciones
		.getInstruccionDatos(strIdInstruccion);
		if (strDatosInstrucciones.length == 0) {%>
			<jsp:forward page="../Error/ERNoInstruccionExistente.jsp"></jsp:forward>
	  <%} else {
			strIdAsunto = ActualizaInstrucciones
			.getIdAsuntoInstruccion(strIdInstruccion);
			strNombre = strDatosInstrucciones[0][13];
			strTelefono = strDatosInstrucciones[0][14];
			strCorreo = strDatosInstrucciones[0][15];
			strTipoAtencion = strDatosInstrucciones[0][3];
			strAcceso = strDatosInstrucciones[0][4];
			strAsunto = strDatosInstrucciones[0][10];
			strFecGeneracion = strDatosInstrucciones[0][7];
			strFecVencimiento = strDatosInstrucciones[0][8];
			strTurnadoPor = strDatosInstrucciones[0][12];
			strFolioRecepcion = strDatosInstrucciones[0][16];
			strFolioIntermedio = strDatosInstrucciones[0][17];
			strInstruccion = strDatosInstrucciones[0][1];
			strInstruccionOtro = strDatosInstrucciones[0][9];
			strSintesis = strDatosInstrucciones[0][11];
			strFolioTurnado = strDatosInstrucciones[0][18];
			strEstatus = strDatosInstrucciones[0][19];
			strAvance = strDatosInstrucciones[0][20];
			strDelegado = strDatosInstrucciones[0][21];
			strPadre = strDatosInstrucciones[0][22];
			strUsuarioOriginal = strDatosInstrucciones[0][0];
			strFirmaDigital = strDatosInstrucciones[0][23];
			strFechaTerminacionReal = strDatosInstrucciones[0][24];
			strIdAsistente = strDatosInstrucciones[0][25];
			strIdJefe = strDatosInstrucciones[0][26];
			strIdUsuario = strDatosInstrucciones[0][27];
			strIdArea = strDatosInstrucciones[0][28];
			strFechaCambio = strDatosInstrucciones[0][29];
			strHabilitado = strDatosInstrucciones[0][30];
			strBandera = strDatosInstrucciones[0][31];
			strCargo = strDatosInstrucciones[0][32];
			strBandera1 = strDatosInstrucciones[0][33];
			strTurno = strDatosInstrucciones[0][34];
			strUsuarioTermino = strDatosInstrucciones[0][37];
		
		//**Asistentes Multiples
		if (BUsuario.getAsistente() || BUsuario.getAtencion()) {
			asistentes = ActualizaUsuario.getAsistentes(strUsuarioOriginal);
			if (ActualizaUsuario.esAsistente(BUsuario.getIdUsuario(),
			asistentes)) {
		strIdUsuarioAsistente = BUsuario.getIdUsuario();
		bAsistente = true;
			}
			bAsistente = Jefe.esAsistenteDe(BUsuario.getIdUsuario(),
			strUsuarioOriginal);
		}
		if (strTipoAtencion.equals("0")) {
			strAtencion = "Ejecutor";
		} else if (strTipoAtencion.equals("1")
		&& strEstatus.equals("1")
		&& (strUsuarioOriginal.equals(BUsuario.getIdUsuario()) || //strIdUsuarioAsistente.equals(strIdAsistente)
		bAsistente)) {
			strAtencion = "Informativo";
		} else if (strTipoAtencion.equals("1")) {
			strAtencion = "Informativo";
		}

		request.setAttribute("delegado", strDelegado);

		if (strFechaCambio != null && strFechaCambio.length() > 0)
			iTieneFechaCambio = 1;
		else
			iTieneFechaCambio = 2;

		String strVigencia[][] = ActualizaInstrucciones
		.getDelegarActivo(strIdInstruccion);
		if (strVigencia.length > 0 && strVigencia != null) {
			esDelegado = "si";
		} else {
			esDelegado = "no";
		}

		if (strAcceso.equals("0"))
			strVerDocto = "No";
		else
			strVerDocto = "Si";

		//** Verifica si del query trae el ID de la instrucción
		//** ú otra Instrucción 
		if (strInstruccion.length() == 0)
			strNombreInstruccion = strInstruccionOtro;
		else
			strNombreInstruccion = ActualizaInst
			.getNombreInstruccion1(strInstruccion);

		bHistorial = ActualizaHistorial
		.TieneHistorial(strIdInstruccion);
		request.setAttribute("existeHistorial", Boolean
		.valueOf(bHistorial));

		bTieneTramite = ActualizaAsunto.getTieneTramite(strIdAsunto);
		}
	}

	boolean bValidaEstatus = false;
	String strEstValidacion = (request.getParameter("estValidacion") == null) ? ""
			: request.getParameter("estValidacion");
	if (strIdInstruccion != null && !strIdInstruccion.equals("")) {
		if (strEstValidacion.equals("")) {
			strEstValidacion = ActualizaInstrucciones
			.getEstatusPorInstruccion(strIdInstruccion);
		}
		String strEstatusValida = ActualizaInstrucciones
		.getEstatusPorInstruccion(strIdInstruccion);
		if (!strEstatusValida.equals(strEstValidacion)) {
			bValidaEstatus = true;
		}
	}

	if (!bValidaEstatus && strAccion != null && strAccion.equals("tur")) {
		strIdInstruccion = request.getParameter("id_ins");
		boolean habilitar = ActualizaInstrucciones.actualizaHabilitado(
		strIdInstruccion, 1, "1");
		response.sendRedirect("InstruccionTurnada.jsp?id_ins="
		+ strIdInstruccion + "&retURI="
		+ Utilerias.codificaPostHTML(retURI) + "&retURI2="
		+ Utilerias.codificaPostHTML(retURI2));
	}

	if (!bValidaEstatus && strBandera.equals("0")
			&& (strUsuarioOriginal.equals(BUsuario.getIdUsuario()) || //strIdUsuarioAsistente.equals(strIdAsistente)
			bAsistente)) {
		boolean bBandera = ActualizaInstrucciones
		.updateBandera(strIdInstruccion);
	}

	if (!bValidaEstatus && strAccion != null
			&& strAccion.equals("terminarRechazada")) {
		strIdInstruccion = request.getParameter("id_ins");
		Date fechaTerminacionReal = new Date(new java.util.Date()
		.getTime());
		boolean bHisTerminadoRechazo = false;
		if (BUsuario.getAsistente()) {
			try {
		bHisTerminadoRechazo = ActualizaHistorial
				.InsertarRespuesta(
				strIdInstruccion,
				strIdAsunto,
				"Se termino la instruccion Rechazada ",
				gob.hacienda.cgtic.siga.Usuario
				.aTitular(BUsuario
						.getIdUsuario()),
				"100",
				"",
				BUsuario.getCargo()
				+ " / "
				+ BUsuario.getNombre()
				+ " en Nombre de "
				+ gob.hacienda.cgtic.siga.instruccion.Rechazo
						.aNombre(BUsuario,
						strIdInstruccion));
			} catch (Exception e) {//System.err.println("InstruccionesAtender-> 247: "+e.getMessage());e.printStackTrace();
			}
		} else
			bHisTerminadoRechazo = ActualizaHistorial
			.InsertarRespuesta(strIdInstruccion, strIdAsunto,
			"Se termino la instruccion Rechazada ",
			BUsuario.getIdUsuario(), "100", "",
			BUsuario.getCargo() + " / "
					+ BUsuario.getNombre());
		boolean bActualizarAvance = ActualizaInstrucciones
		.avanceInstruccionPadre(strIdInstruccion, "100",
				strEstatus, "",
				fechaTerminacionReal.toString(), BUsuario
				.getIdUsuario());
		if (strTipoAtencion.equals("0")) {
			//**Calculo Avance General
			CalculoAvance cAvance = new CalculoAvance();
			cAvance.calculoAvance(strIdAsunto, strIdInstruccion);
			//**Fin Calculo Avance General
		}
		strEstatus = "4";
		//response.sendRedirect(retURI);
		//		response.sendRedirect("PortalTerminado.jsp");
	}

	//**Verifica cadena de mando
	CadenaMando cadena = new CadenaMando(strUsuarioOriginal, BUsuario
			.getIdUsuario());
	boolean bCadena = cadena.getEsJefe();
	//**Fin Verifica cadena de mando 

	String[][] strRutaAcceso = ActualizaAsunto
			.getIdsRutaAcceso(strIdAsunto);
	boolean bAccesoRutaAtencion = ActualizaAsunto
			.getAccesoRutaAtencion(BUsuario.getIdUsuario(),
			strRutaAcceso);

	boolean accesoAsistente = false;
	if (BUsuario.getAsistente()) {
		String strIdsJefes[][] = ActualizaUsuario
		.getJefesDeAsistente(BUsuario.getIdUsuario());
		if (strIdsJefes != null && strIdsJefes.length > 0) {
			for (int i = 0; i < strIdsJefes.length; i++) {
		CadenaMando cadenaAsis = new CadenaMando(
				strUsuarioOriginal, strIdsJefes[i][0]);
		boolean bCadenaAsis = cadena.getEsJefe();
		if (bCadenaAsis) {
			accesoAsistente = true;
		}
		if (ActualizaAsunto.getAccesoRutaAtencion(
				strIdsJefes[i][0], strRutaAcceso)) {
			bAccesoRutaAtencion = true;
		}
			}
		}
	}

	boolean esPropietario = true;
	if ((BUsuario.getAtencion() || BUsuario.getAsistente())
			&& (strEstatus.equals("3")))
		esPropietario = strTurno.equals(BUsuario.getIdUsuario())
		|| gob.hacienda.cgtic.siga.Usuario.asiste(strTurno,
				BUsuario.getIdUsuario())
		|| gob.hacienda.cgtic.siga.Usuario.asiste(BUsuario
				.getIdUsuario(), strTurno) ? true : false;

	if ((BUsuario.getIdUsuario().equals(strUsuarioOriginal)
			|| bAsistente || bCadena || AtenderInstrucciones
			.getTitular(BUsuario.getIdUsuario()))
			&& esPropietario)
		BEscritura.setValue(true);
	else
		BEscritura.setValue(false);

	//*Solo turnador y supervisor
	if ((BUsuario.getIdUsuario().equals(strUsuarioOriginal)
			|| bAsistente
			|| bCadena
			|| BUsuario.getIdUsuario().equals(strTurno)
			|| ActualizaInstrucciones.getSupervisorEsArea(
			strUsuarioOriginal, BUsuario.getIdUsuario(),
			BUsuario.getSupervisor()) || AtenderInstrucciones
			.getTitular(BUsuario.getIdUsuario()))
			&& esPropietario)
		BEscrituraTur.setValue(true);
	else
		BEscrituraTur.setValue(false);

	if ((BUsuario.getIdUsuario().equals(strTurnadoPor)
			|| BUsuario.getIdUsuario().equals(strTurno)
			|| accesoAsistente || AtenderInstrucciones
			.getTitular(BUsuario.getIdUsuario()))
			&& esPropietario)
		BEscritura1.setValue(true);
	else
		BEscritura1.setValue(false);

	if ((BUsuario.getIdUsuario().equals(strUsuarioOriginal)
			|| bAsistente || bCadena
			|| BUsuario.getIdUsuario().equals(strTurnadoPor) || AtenderInstrucciones
			.getTitular(BUsuario.getIdUsuario()))
			&& esPropietario)
		BEscritura2.setValue(true);
	else
		BEscritura2.setValue(false);

	if ((BUsuario.getIdUsuario().equals(strUsuarioOriginal)
			|| BUsuario.getIdUsuario().equals(strTurno) || bAsistente
			|| bCadena || AtenderInstrucciones.getTitular(BUsuario
			.getIdUsuario()))
			&& esPropietario)
		BEscrituraAr.setValue(true);
	else
		BEscrituraAr.setValue(false);

	//**Verifica si el usuario tiene subordinados
	//strSubordinado = ActualizaUsuario.getSubalterno(strUsuarioOriginal);
	String strTurnador = Actualiza.getTurnador(strIdInstruccion,
			BUsuario.getIdUsuario());
	strSubordinado = ActualizaUsuario
			.getSubordinados(strUsuarioOriginal).length != 0 ? ActualizaUsuario
			.getSubordinados(strUsuarioOriginal)
			: ActualizaUsuario.getSubordinados(strTurnador);
	if (strSubordinado.length != 0)
		bTieneSubordinados = true;
	else
		bTieneSubordinados = false;

	//**Verifica la linea de turnado
	UsuarioTurnado turnado = new UsuarioTurnado(
			BUsuario.getIdUsuario(), strUsuarioOriginal,
			strIdInstruccion);
	boolean bTurnado = turnado.getEsTurnado();
	//**Fin Verifica la linea de turnado
%>
<%
			if (strHabilitado.equals("0")
			&& strPadre.length() == 0
			&& (//BUsuario.getIdArea().equals(strIdArea) || 
			BUsuario.getIdUsuario().equals(strIdUsuario)
			||
			//BUsuario.getIdUsuario().equals(strIdAsistente) || 
			bAsistente
			|| BUsuario.getIdUsuario().equals(strIdJefe)
			|| BUsuario.getIdUsuario().equals(strTurnadoPor)
			|| BUsuario.getIdUsuario().equals(strTurno)
			|| bCadena || accesoAsistente
			|| bAccesoRutaAtencion || ActualizaInstrucciones
			.getSupervisorEsArea(strUsuarioOriginal, BUsuario
			.getIdUsuario(), BUsuario.getSupervisor()))
			|| BUsuario.getTurnado()
			|| AtenderInstrucciones.getTitular(BUsuario.getIdUsuario())) {
		////System.out.println("Pueden ver la Instrucción");
	} else {
%>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<%
}
%>

<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>Instrucción</TITLE>
<SCRIPT language=JavaScript type=text/javascript>

	var botonBandera = true;
	
   	//function imprimir(){
    //     var url='ImprimeInstruccionTerminada.jsp?idInstruccion='+<%=strIdInstruccion%>;
    //     var ventanaImpresion=window.open(url,'','',true);
	//}
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
		location.assign('<%=retURI2%>');		 
	}
	function Responder(){ 
	//	location.assign('Responder.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&id_es=<%=strEstatus%>&ava=<%=strAvance%>&us_or=<%=strUsuarioOriginal%>&estValidacion=<%= strEstValidacion %>');
		location.assign('Responder.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&id_es=<%=strEstatus%>&ava=<%=strAvance%>&us_or=<%=strUsuarioOriginal%>&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML("InstruccionesAtender.jsp?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');
	}
	function Rechazar(){
                location.assign('Rechazar.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&tur=<%=strTurnadoPor%>&ava=<%=strAvance%>&ins=<%=strNombreInstruccion%>&estValidacion=<%= strEstValidacion %>&retURI1=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp)%>&retURI2=<%=com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)%>');
	}
	function Reasignar(){
                /*KHCH Navegacion Reasignacion*/
		<%--location.assign('Reasignar.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&ava=<%=strAvance%>&usr_ori=<%=strUsuarioOriginal%>&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML("InstruccionesAtender.jsp?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI))%>');--%>
		location.assign('Reasignar.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&ava=<%=strAvance%>&usr_ori=<%=strUsuarioOriginal%>&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML("InstruccionesAtender.jsp?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI))%>&retURI2=<%=Utilerias.codificaPostHTML(retURI)%>');
	}
	function ReasignarRechazar(){
		location.assign('ReasignarRechazo.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&ava=<%=strAvance%>&estValidacion=<%= strEstValidacion %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI))%>&retURI2=<%=Utilerias.codificaPostHTML(retURI)%>');
	}
	function Delegar(){
		location.assign('Delegar.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&ava=<%=strAvance%>&usr_ori=<%=strUsuarioOriginal%>');
	}
	function Turnar(){
		doc = document.atender;
		doc.turnar.value="tur";
		doc.submit();
	}
	function TerminarRechazada(){
		doc = document.atender;
		doc.accion.value="terminarRechazada";
		doc.submit();
	}
	function firmar(){
		location.assign('http://192.168.0.144:8080/firma/explorer_applet.html');
	}
   	function agregarComentario(){
            location.assign('AgregarComentarioInstruccion.jsp?id_ins=<%=strIdInstruccion%>&tur=<%=strTurnadoPor%>&ins=<%=strNombreInstruccion%>&a=1&estValidacion=<%= strEstValidacion %>&retURI=<%=Utilerias.codificaPostHTML("InstruccionesAtender.jsp?id_ins="+strIdInstruccion)%>&retURI2=<%=Utilerias.codificaPostHTML(retURI)%>');
	}
	function agregarContent() {
		location.assign('ImportarCM.jsp?Folio=<%=strFolioRecepcion%>&IdAsunto=<%=strIdAsunto%>&a=2&id_ins=<%=strIdInstruccion%>&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');
	}
	function agregar()
	{
		var frameNvaRef = '<%= serverContentManager %>/eclient/SIGMA/Avance.jsp?id=<%=strIdAsunto%>&bo=true&it=<%=strItemType%>';
		document.getElementById('frame1').src  = frameNvaRef;		
	}
	function cambioFecha(){
		location.assign('CambioFechaInst.jsp?id_ins=<%=strIdInstruccion%>&id_asunto=<%=strIdAsunto%>&tur=<%=strTurno%>&i=<%=iTieneFechaCambio%>&re=1&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML("InstruccionesAtender.jsp?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');
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
<FORM action="InstruccionesAtender.jsp" name="atender" method="post">
<INPUT name="turnar" value="<%= strMostrarHabilitado %>" type="hidden">
<INPUT name="id_ins" value="<%= strIdInstruccion %>" type="hidden">
<INPUT type="hidden" name="folioHdn" value="<%=strFolioTurnado%>">
<INPUT type="hidden" name="accion" value="tur"> <INPUT
	name="retURI" value="<%=retURI%>" type="hidden"> <INPUT
	name="retURI2" value="<%=retURI2%>" type="hidden"> <INPUT
	type="hidden" value="<%=strEstValidacion%>" name="estValidacion">
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
		<td width="863">
		<%
		if (strEstatus.equals("1")) {
		%>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Instrucción Por Atender</font></b></div>
		<%
		} else if (strEstatus.equals("2")) {
		%>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Instrucción En Trámite</font></b></div>
		<%
		} else if (strEstatus.equals("3")) {
		%>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Instrucción Rechazada</font></b></div>
		<%
		} else if (strEstatus.equals("4")) {
		%>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Instrucción Terminada</font></b></div>
		<%
		}
		%>
		</td>
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
				<td width="60"><!-- <input type="button" onclick="Regresar()" value="Regresar" class="blue100"> -->
				<A
					onclick="if(botonBandera){botonBandera=false; location.assign('<%=retURI%>')}"
					onMouseOver="document.MyImage.src='../Imagenes/NavLeft2.gif';"
					onMouseOut="document.MyImage.src='../Imagenes/NavLeft.gif';"> <IMG
					border="0" src="../Imagenes/NavLeft.gif" title="Regresar / Cancelar"
					name="MyImage"></A></td>
				<%
				if (strTipoAtencion.equals("1")) {
				%>
				<%
				if (strEstatus.equals("1") || strEstatus.equals("2")) {
				%>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Responder();}"
							onMouseOver="document.Responder3.src='../Imagenes/Responder2.gif';"
							onMouseOut="document.Responder3.src='../Imagenes/Responder.gif';">
						<IMG src="../Imagenes/Responder.gif" border=0 name="Responder3"
							title="Responder"> </A></td>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<%
						if (bTieneSubordinados) {
						%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Turnar();}"
							onMouseOver="document.Habilitar2.src='../Imagenes/deleg_multiple2.gif';"
							onMouseOut="document.Habilitar2.src='../Imagenes/deleg_multiple.gif';">
						<IMG border="0" src="../Imagenes/deleg_multiple.gif"
							title="Habilitar Delegado Multiple" name="Habilitar2"></A></td>
						<%
						}
						%>
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
						<%
									float fAvance = new Float(strAvance).floatValue();
									if (fAvance == 0) {
						%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Rechazar();}"
							onMouseOver="document.Rechazar2.src='../Imagenes/Rechazar2.gif';"
							onMouseOut="document.Rechazar2.src='../Imagenes/Rechazar.gif';">
						<IMG border="0" src="../Imagenes/Rechazar.gif" title="Rechazar"
							name="Rechazar2"></A></td>
						<%
						}
						%>
					</c:when>
				</c:choose>
				<td width="200">&nbsp;</td>
				<%
						} else if (strEstatus.equals("3")
						&& (BUsuario.getTurnado() || RechazoInstruccion
								.myInstruccion(strIdInstruccion, BUsuario
								.getIdUsuario()))) {
				%>
				<c:choose>
					<c:when test="true">
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; TerminarRechazada();}"
							onMouseOver="document.TerRechazada.src='../Imagenes/Responder2.gif';"
							onMouseOut="document.TerRechazada.src='../Imagenes/Responder.gif';">
						<IMG border="0" src="../Imagenes/Responder.gif"
							title="Terminar Instrucción Rechazada" name="TerRechazada"></A></td>
					</c:when>
				</c:choose>
				<%
				} else {
				%>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<td width="60"><A onclick="if(botonBandera){imprimir();}"
							onMouseOver="document.Imprimir.src='../Imagenes/Imprimir2.gif';"
							onMouseOut="document.Imprimir.src='../Imagenes/Imprimir.gif';">
						<IMG border="0" src="../Imagenes/Imprimir.gif" title="Imprimir"
							name="Imprimir"></A></td>
					</c:when>
				</c:choose>
				<td width="200">&nbsp;</td>
				<%
				}
				%>
				<%
				} else {
				%>
				<!--    Instrucciones que no son de tipo informativas, sino ejecutorias     -->
				<!-- Si la instruccion tiene como estatus "Por atender", se mostraran todos los botones -->
				<%
				if (strEstatus.equals("1")) {
				%>
				<c:choose>
					<c:when test='${BEscrituraTur.value}'>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Responder();}"
							onMouseOver="document.Responder3.src='../Imagenes/Responder2.gif';"
							onMouseOut="document.Responder3.src='../Imagenes/Responder.gif';"><IMG
							src="../Imagenes/Responder.gif" border=0 name="Responder3"
							title="Responder"></A></td>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<%
						if (strPadre.length() == 0) {
						%>
						<%
						if (bTieneSubordinados) {
						%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Turnar();}"
							onMouseOver="document.Habilitar2.src='../Imagenes/deleg_multiple2.gif';"
							onMouseOut="document.Habilitar2.src='../Imagenes/deleg_multiple.gif';">
						<IMG border="0" src="../Imagenes/deleg_multiple.gif"
							title="Habilitar Delegado Multiple" name="Habilitar2"></A></td>
						<%
						}
						%>
						<%
						}
						%>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscrituraTur.value}'>
						<%
									if (bTieneSubordinados
									&& !strTurno.equals(BUsuario.getIdUsuario())) {
						%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Reasignar();}"
							onMouseOver="document.Reasignar2.src='../Imagenes/Reasignar2.gif';"
							onMouseOut="document.Reasignar2.src='../Imagenes/Reasignar.gif';">
						<IMG border="0" src="../Imagenes/Reasignar.gif" title="Reasignar"
							name="Reasignar2"></A></td>
						<%
						} else {
						%>
						<%
										if (bTieneSubordinados
										&& (strTurno.equals(BUsuario.getIdUsuario()) || ActualizaInstrucciones
										.getSupervisorEsArea(
										strUsuarioOriginal, BUsuario
												.getIdUsuario(),
										BUsuario.getSupervisor()))) {
						%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Reasignar();}"
							onMouseOver="document.Reasignar2.src='../Imagenes/Reasignar2.gif';"
							onMouseOut="document.Reasignar2.src='../Imagenes/Reasignar.gif';">
						<IMG border="0" src="../Imagenes/Reasignar.gif" title="Reasignar"
							name="Reasignar2"></A></td>
						<%
						}
						%>
						<%
						}
						%>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscrituraTur.value}'>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Rechazar();}"
							onMouseOver="document.Rechazar2.src='../Imagenes/Rechazar2.gif';"
							onMouseOut="document.Rechazar2.src='../Imagenes/Rechazar.gif';">
						<IMG border="0" src="../Imagenes/Rechazar.gif" title="Rechazar"
							name="Rechazar2"></A></td>
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
						<%
						if (!bTieneTramite && iTieneFechaCambio == 2) {
						%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; cambioFecha();}"
							onMouseOver="document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';"
							onMouseOut="document.cambioFecha1.src='../Imagenes/CambioFecha.gif';">
						<IMG border="0" src="../Imagenes/CambioFecha.gif"
							title="Solicitar Cambio de Fecha" name="cambioFecha1"></A></td>
						<%
						} else if (!bTieneTramite && iTieneFechaCambio == 1) {
						%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; cambioFecha();}"
							onMouseOver="document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';"
							onMouseOut="document.cambioFecha1.src='../Imagenes/CambioFecha.gif';">
						<IMG border="0" src="../Imagenes/CambioFecha.gif"
							title="Cambiar Fecha" name="cambioFecha1"></A></td>
						<%
						}
						%>
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
				<!-- Si la instrucción se encuestra en tramite, no mostrara el boton de rechazar -->
				<%
				} else if (strEstatus.equals("2") && strDelegado.length() == 0) {
				%>
				<c:choose>
					<c:when test='${BEscrituraTur.value}'>
						<td width="60" valign="top"><A
							onclick="if(botonBandera){botonBandera=false; Responder();}"
							onMouseOver="document.Responder3.src='../Imagenes/Responder2.gif';"
							onMouseOut="document.Responder3.src='../Imagenes/Responder.gif';"><IMG
							src="../Imagenes/Responder.gif" border=0 name="Responder3"
							title="Responder"></A></td>
					</c:when>
				</c:choose>

				<c:choose>
					<c:when test='${BEscritura.value}'>
						<%
						if (strPadre.length() == 0) {
						%>
						<%
						if (bTieneSubordinados) {
						%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Turnar();}"
							onMouseOver="document.Habilitar2.src='../Imagenes/deleg_multiple2.gif';"
							onMouseOut="document.Habilitar2.src='../Imagenes/deleg_multiple.gif';">
						<IMG border="0" src="../Imagenes/deleg_multiple.gif"
							title="Habilitar Delegado Multiple" name="Habilitar2"></A></td>
						<%
						}
						%>
						<%
						}
						%>
					</c:when>
				</c:choose>

				<c:choose>
					<c:when test='${BEscrituraTur.value}'>
						<%
									if (bTieneSubordinados
									&& !strTurno.equals(BUsuario.getIdUsuario())) {
						%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Reasignar();}"
							onMouseOver="document.Reasignar2.src='../Imagenes/Reasignar2.gif';"
							onMouseOut="document.Reasignar2.src='../Imagenes/Reasignar.gif';">
						<IMG border="0" src="../Imagenes/Reasignar.gif" title="Reasignar"
							name="Reasignar2"></A></td>
						<%
						} else {
						%>
						<%
										if (strTurno.equals(BUsuario.getIdUsuario())
										|| ActualizaInstrucciones.getSupervisorEsArea(
										strUsuarioOriginal, BUsuario
										.getIdUsuario(), BUsuario
										.getSupervisor())) {
						%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Reasignar();}"
							onMouseOver="document.Reasignar2.src='../Imagenes/Reasignar2.gif';"
							onMouseOut="document.Reasignar2.src='../Imagenes/Reasignar.gif';">
						<IMG border="0" src="../Imagenes/Reasignar.gif" title="Reasignar"
							name="Reasignar2"></A></td>
						<%
						}
						%>
						<%
						}
						%>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscrituraAr.value}'>
						<td width="60"><a
							onclick="if(botonBandera){botonBandera=false; agregarContent();}"
							onMouseOver="document.Insertar.src='../Imagenes/Attach2.gif';"
							onMouseOut="document.Insertar.src='../Imagenes/Attach.gif';">
						<IMG border="0" src="../Imagenes/Attach.gif"
							title="Insertar Archivo / Escanear documento!" name="Insertar"></a>
						</td>

					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscritura2.value}'>
						<%
						if (!bTieneTramite && iTieneFechaCambio == 2) {
						%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; cambioFecha();}"
							onMouseOver="document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';"
							onMouseOut="document.cambioFecha1.src='../Imagenes/CambioFecha.gif';">
						<IMG border="0" src="../Imagenes/CambioFecha.gif"
							title="Solicitar Cambio de Fecha" name="cambioFecha1"></A></td>
						<%
						} else if (!bTieneTramite && iTieneFechaCambio == 1) {
						%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; cambioFecha();}"
							onMouseOver="document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';"
							onMouseOut="document.cambioFecha1.src='../Imagenes/CambioFecha.gif';">
						<IMG border="0" src="../Imagenes/CambioFecha.gif"
							title="Cambiar Fecha" name="cambioFecha1"></A></td>
						<%
						}
						%>

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

				<td width="60">&nbsp;</td>

				<!-- 	Si la instruccion ha sido rechazada, solo mostrara los botones de reasignar -->
				<!--    En caso de que la instruccion tenga estatus de rechazada    -->
				<!--    En caso de que la instruccion sea visualizada por un usuario logeado com oturnador, pueda reasignar dicha instruccion   -->
				<%
						} else if (strEstatus.equals("3")
						&& (BUsuario.getTurnado()
								|| RechazoInstruccion
								.myInstruccion(strInstruccion, BUsuario
								.getIdUsuario())
								|| BUsuario.getAsistente() || BUsuario
								.getAtencion())) {
							String strIdsAsiste[][] = null;
							if (BUsuario.getTurnado()) {
						isEditableRechazo = true;
							} else {
						if (BUsuario.getAsistente()) {
							strIdsAsiste = Rechazo.getInsRechazadasAsistente(
							BUsuario.getIdUsuario(), BUsuario
									.getIdArea());
						} else {
							strIdsAsiste = Rechazo.getInsRechazadasOtros(
							BUsuario.getIdUsuario(), BUsuario
									.getIdArea());
						}
						//Son instrucciones generadas por sus colaboradores
						for (int i = 0; i < strIdsAsiste.length; i++) {
							if (strIdsAsiste[i][0].equals(strTurno)) {
								isEditableRechazo = true;
								break;
							} else {
								isEditableRechazo = false;
							}
						}
							}
							//Son generadas por el mismo
							if (isEditableRechazo == false) {
						if (BUsuario.getIdUsuario().equals(strTurno)) {
							isEditableRechazo = true;
						} else {
							isEditableRechazo = false;
						}
							}
				%>

				<%
				if (isEditableRechazo) {
				%>
				<td width="60"><A
					onclick="if(botonBandera){botonBandera=false; Reasignar();}"
					onMouseOver="document.Reasignar2.src='../Imagenes/Reasignar2.gif';"
					onMouseOut="document.Reasignar2.src='../Imagenes/Reasignar.gif';">
				<IMG border="0" src="../Imagenes/Reasignar.gif" title="Reasignar"
					name="Reasignar2"></A></td>
				<td width="60"><A
					onclick="if(botonBandera){botonBandera=false; TerminarRechazada();}"
					onMouseOver="document.TerRechazada.src='../Imagenes/Responder2.gif';"
					onMouseOut="document.TerRechazada.src='../Imagenes/Responder.gif';">
				<IMG border="0" src="../Imagenes/Responder.gif"
					title="Terminar Instrucción Rechazada" name="TerRechazada"></A></td>
				<%
				}
				%>


				<!-- Si la instrucción ha sido terminada, no mostrara ningun boton -->
				<%
						} else
						//Si la instrucción ha sido terminada, no mostrara ningun boton 
						if (strEstatus.equals("4")) {
				%>
				<!-- td width="125">&nbsp;</td-->
				<c:choose>
					<c:when test='${BEscritura.value}'>
						<td width="60"><A onclick="if(botonBandera){imprimir(); }"
							onMouseOver="document.Imprimir.src='../Imagenes/Imprimir2.gif';"
							onMouseOut="document.Imprimir.src='../Imagenes/Imprimir.gif';">
						<IMG border="0" src="../Imagenes/Imprimir.gif" title="Imprimir"
							name="Imprimir"></A></td>
					</c:when>
				</c:choose>
				<td width="300">&nbsp;</td>

				<!-- Si la instrucción ha sido delegada, solo mostrara los botones de responder y delegar -->
				<%
				} else if (strEstatus.equals("2") && strDelegado.length() > 0) {
				%>
				<c:choose>
					<c:when test='${BEscrituraTur.value}'>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; Responder();}"
							onMouseOver="document.Responder3.src='../Imagenes/Responder2.gif';"
							onMouseOut="document.Responder3.src='../Imagenes/Responder.gif';"><IMG
							src="../Imagenes/Responder.gif" border=0 name="Responder3"
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
							name="Delegar2"></A></td>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test='${BEscrituraAr.value}'>
						<td width="60"><a
							onclick="if(botonBandera){botonBandera=false; agregarContent();}"
							onMouseOver="document.Insertar.src='../Imagenes/Attach2.gif';"
							onMouseOut="document.Insertar.src='../Imagenes/Attach.gif';">
						<IMG border="0" src="../Imagenes/Attach.gif"
							title="Insertar Archivo / Escanear documento!" name="Insertar"></a>
						</td>
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
					<c:when test='${BEscritura2.value}'>
						<%
						if (!bTieneTramite) {
						%>
						<td width="60"><A
							onclick="if(botonBandera){botonBandera=false; cambioFecha();}"
							onMouseOver="document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';"
							onMouseOut="document.cambioFecha1.src='../Imagenes/CambioFecha.gif';">
						<IMG border="0" src="../Imagenes/CambioFecha.gif"
							title="Solicitar Cambio de Fecha" name="cambioFecha1"></A></td>
						<%
						}
						%>

					</c:when>
				</c:choose>
				<%
					}
					}
				%>
				<td width="300">&nbsp;</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</DIV>
<br>
<%
if (iTieneFechaCambio == 1) {
%>
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
<%
}
%>
<div align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<tr valign="top">
			<td width="183"><b><font size="2" color="#004080"
				face="Arial">Datos Básicos</font></b></td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="396">
			<DIV align="right"><FONT face="Arial" color="#00204f" size="2">Folio:<b><%=strFolioTurnado%></b></FONT>
			</DIV>
			</td>
		</tr>
		<tr valign="top">
			<td bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</tr>
	</TBODY>
</TABLE>
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
		<td colspan="3" width="680"><font size="2" face="Arial"> <%
 if (strEstatus.equals("3")) {
 %> <%=ActualizaHistorial
								.getUsuarioRechazo(strIdInstruccion)[0][0]%> <%
 } else if (strUsuarioTermino.length() == 0) {
 %> <%=strCargo%> <%
 } else {
 %> <%=strUsuarioTermino%> <%
 }
 %> <INPUT type="hidden" name="nombreHdn" value="<%=strNombre%>">
		<INPUT type="hidden" name="telefonoHdn" value="<%=strTelefono%>">
		<INPUT type="hidden" name="correoHdn" value="<%=strCorreo%>">
		</font></td>
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
		<td width=""><font size="2" face="Arial"><%=strAtencion%><INPUT
			type="hidden" name="atencionHdn" value="<%=strAtencion%>"></font></td>
		<td width="" align="right"><font size="2" color="#004080"
			face="Arial">Acceso al Documento Original:&nbsp;&nbsp;</font></td>
		<td><font size="2" face="Arial"><%=strVerDocto%><INPUT
			type="hidden" name="verDoctoHdn" value="<%=strVerDocto%>"></font> <%
 if (strAcceso.equals("1")) {
 %> <A
			href="AsuntoTurnado.jsp?id_asunto=<%= strIdAsunto %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>&per=1&inst=1;">
		<IMG SRC='../Imagenes/type_document.gif' BORDER=0> </A> <%
 }
 %>
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
		<td colspan="3" width="680"><font size="2" face="Arial"><%=strAsunto%><INPUT
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
		<td><font size="2" face="Arial"><%=strFecVencimiento%><INPUT
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
		<%
		if (strEstatus.equals("1")) {
		%> <font size="2" face="Arial">Notificado</font> <%
 } else if (strEstatus.equals("2")) {
 %> <font size="2" face="Arial">En Trámite</font> <%
 } else if (strEstatus.equals("3")) {
 %> <font size="2" face="Arial">Rechazada</font> <%
 } else if (strEstatus.equals("4")) {
 %> <font size="2" face="Arial">Terminada</font> <%
 }
 %>
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
	<tr valign="top">
		<td width="183"><font size="2" color="#004080" face="Arial">Asignada
		por: </font></td>
		<td width=""><font size="2" face="Arial"> <%
 String turnadoPor = ActualizaUsuario.NombreUsuario(strTurno);
 %><%=turnadoPor%><input type="hidden" name="turnadoPorHdn"
			value="<%=turnadoPor%>"></font></td>
		<td width=""><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td><img src="../Imagenes/ecblank.gif" border="0" height="1"
			width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td colspan="4"><img src="../Imagenes/shim.gif" width="1"
			height="1" title="">&nbsp;</td>
	</tr>
	<tr valign="top">
		<td width="183"><font size="2" color="#004080" face="Arial">Folio
		de Recepción:</font> <font size="2" face="Arial"> </font></td>
		<td colspan="3" width="680"><font size="2" face="Arial"><%=strFolioRecepcion%>
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
		<td width=""><font size="2" face="Arial"><%=strFolioIntermedio%>

		</font><input type="hidden" name="folioIntermedioHdn"
			value="<%=strFolioIntermedio%>"></td>
		<td width=""><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td><img src="../Imagenes/ecblank.gif" border="0" height="1"
			width="1" title=""></td>
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
		<td colspan="4"><font size="2" face="Arial"><%=strNombreInstruccion%><input
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
		<td colspan="4"><font size="2" face="Arial"><%=strSintesis%><INPUT
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
			src="ExpedienteInstrccion.jsp?ida=<%=strIdInstruccion%>&num=1%>"
			WIDTH=800 HEIGHT=100 frameborder=0 id="Entidad"></IFRAME></td>
	</tr>


</table>

</DIV>

<br>
<br>
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
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr valign="top">
		<%
		if (bHistorial) {
		%>
		<td width="100%" colspan="4"><font size="1" color="#004080"
			face="Arial"><meve_front:ListaDatos
			datos="<%=ActualizaHistorial.getHistorialInstruccion(strIdInstruccion)%>"
			campo="campo">
			<%
													if ("1"
													.equals(campo7)) {
			%>
			<%=campo3%>----><br>
			<%
			String avanceUsuario = campo8;
			%>
			<%
												if (campo6
												.equals("Actualización de la instruccion Padre")) {
			%>
				Se ha alcanzado el estatus de &quot;Terminado&quot; en todas las Instrucciones delagadas <br>
			<U>Avance de: 99%</U>
			<%
			} else {
			%>
				Avance del Usuario: <%=(campo8
																																.indexOf(" / ") != -1) ? campo8
																														: campo8
																																+ " / "
																																+ ActualizaUsuario
																																		.NombrePuesto(campo4)%>
			<br>
			<a
				href="Responder.jsp?id_his=<%= campo1 %>&estValidacion=<%= strEstValidacion %>&retURI=<%= Utilerias.codificaPostHTML("InstruccionesAtender.jsp?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>">
			<font size="1" color="#004080" face="Arial"> <U>Avance de:
			<%=campo5%>%</U><input type="hidden" name="avanceDeHdn"
				value="<%=campo5%>"> </font> </a>
			<%
			}
			%>
			<br>
			<br>
			<%
													} else if (campo7
													.equals("2")) {
			%>
			<%=campo3%>----><br>
				Documento Rechazado por: <%=(campo8
																															.indexOf(" / ") != -1) ? campo8
																													: campo8
																															+ " / "
																															+ ActualizaUsuario
																																	.NombrePuesto(campo4)%><br>
				Razón de Rechazo: <%=campo6%>
			<br>
			<br>
			<%
													} else if (campo7
													.equals("3")) {
			%>
			<%=campo3%>----><br>
				Documento Reasignado a: <%=ActualizaInstrucciones
																															.NombreUsuarioInstruccion(strIdInstruccion)%>
				por el Usuario: <%=(campo8
																															.indexOf(" / ") != -1) ? campo8
																													: campo8
																															+ " / "
																															+ ActualizaUsuario
																																	.NombrePuesto(campo4)%><br>
				Comentarios Adicionales: <%=campo6%>
			<br>
			<br>
			<%
													} else if (campo7
													.equals("4")) {
			%>
			<%=campo3%>----><br>
				Documento Delegado a : <%=ActualizaUsuario
																															.NombreUsuario(strDelegado)%>
			<br>
				Comentarios Adicionales: <%=campo6%>
			<br>
			<br>
			<%
													} else if (campo7
													.equals("5")) {
			%>
			<%=campo3%>----><br>
				El Usuario: <%=(campo8
																															.indexOf(" / ") != -1) ? campo8
																													: campo8
																															+ " / "
																															+ ActualizaUsuario
																																	.NombrePuesto(campo4)%> generó Instrucciones para Atender la solicitud
			<br>
			<br>
			<%
													} else if (campo7
													.equals("6")) {
			%>
			<%=campo3%>----><br>
				Puesto: <%=campo8%>
			<br>
                Comentario: <%=com.meve.sigma.util.Utilerias
																															.cambioSaltosDeLinea(campo6)%>
			<br>
			<br>
			<%
													} else if (campo7
													.equals("7")) {
			%>
			<%=campo3%>----><br>
				El Usuario <%=campo8%> / <%=ActualizaUsuario
																															.NombrePuesto(campo4)%>
			<%=campo9%><br>
                Comentario: <%=com.meve.sigma.util.Utilerias
																															.cambioSaltosDeLinea(campo6)%>
			<br>
			<br>
			<%
													} else if (campo7
													.equals("8")) {
			%>
			<%=campo3%>----><br>
				El Usuario <%=campo8%> / <%=ActualizaUsuario
																															.NombrePuesto(campo4)%>
			<%=campo9%><br>
                Comentario: <%=com.meve.sigma.util.Utilerias
																															.cambioSaltosDeLinea(campo6)%>
			<br>
			<br>
			<%
													} else if (campo7
													.equals("9")) {
			%>
			<%=campo3%>----><br>
				El Usuario <%=campo8%> / <%=ActualizaUsuario
																															.NombrePuesto(campo4)%>
			<%=campo9%><br>
                Comentario: <%=com.meve.sigma.util.Utilerias
																															.cambioSaltosDeLinea(campo6)%>
			<br>
			<br>
			<%
			}
			%>
		</meve_front:ListaDatos> </font></td>
		<%
		} else {
		%>
		<td width="100%" colspan="4">&nbsp;</td>
		<%
		}
		%>
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
		<%
					if (BUsuario.getIdUsuario().equals(strUsuarioOriginal)
					|| bAsistente /*BUsuario.getIdUsuario().equals(strIdAsistente)*/) {
		%> <%
 if (strActivarCM.equals("si")) {
 %> <!-- <IFRAME ID="frame1" SRC="<%= serverContentManager %>/eclient/SIGMA/Buscar.jsp?id=<%=strIdAsunto%>&bo=true&it=<%=strItemType%>" WIDTH="800" HEIGHT="200" frameborder=0></IFRAME>  -->
		<IFRAME ID="frame1"
			SRC="ImportarCMO.jsp?IdAsunto=<%=strIdAsunto%>&bo=true&IdInst=<%=strIdInstruccion%>&fol=<%=strFolioRecepcion %>&est=<%=strEstatus%>"
			WIDTH="800" HEIGHT="250" frameborder=0></IFRAME> <%
 } else {
 %> <IFRAME ID="frame1"
			SRC="ImportarAR.jsp?IdAsunto=<%=strIdAsunto%>&bo=true&IdInst=<%=strIdInstruccion%>&fol=<%=strFolioRecepcion %>&est=<%=strEstatus%>"
			WIDTH="800" HEIGHT="250" frameborder=0></IFRAME> <%
 }
 %> <%
 } else {
 %> <%
 if (strActivarCM.equals("no")) {
 %> <IFRAME ID="frame1"
			SRC="ImportarAR.jsp?IdAsunto=<%=strIdAsunto%>&bo=false&IdInst=<%=strIdInstruccion%>&fol=<%=strFolioRecepcion %>&est=<%=strEstatus%>"
			WIDTH="800" HEIGHT="250" frameborder=0></IFRAME> <%
 } else {
 %> <IFRAME ID="frame1"
			SRC="ImportarCMO.jsp?IdAsunto=<%=strIdAsunto%>&bo=false&IdInst=<%=strIdInstruccion%>&fol=<%=strFolioRecepcion %>&est=<%=strEstatus%>"
			WIDTH="800" HEIGHT="250" frameborder=0></IFRAME> <%
 }
 %> <%
 }
 %>
		</div>
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
		if (firmado) {
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
		<td width="14%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
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
</DIV>
<script type="text/javascript">
<!--
if (<%= bValidaEstatus %>){
	alert("Esta Instrucción ha sido modificada por otro usuario y cambió su Estatus,\npor lo que la acción solicitada será cancelada");
	location.assign("portalPrincipal.jsp");
}
-->
</script></FORM>
</BODY>
</HTML>
