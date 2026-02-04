<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<%@taglib uri="c" prefix="c"%>
<HTML> 
<HEAD>
<TITLE>Asunto en Recepci&oacute;n</TITLE>
<jsp:useBean id="AsuntoRep" class="com.meve.sigma.beans.Asunto" scope="page">
	<jsp:setProperty name="AsuntoRep" property="*" />
<%@ page language="java"
%>
<%@ page import="com.meve.sigma.taglib.*,com.meve.sigma.actualiza.*" %>
<%@ page import="com.meve.sigma.beans.*,com.meve.sigma.util.*,java.util.*,com.meve.sigma.beans.search.*, java.io.*;" %>
<jsp:useBean id="BEscritura" class="com.meve.sigma.beans.EscrituraBean"
	scope="page"></jsp:useBean>
<jsp:useBean id="BEscritura1" class="com.meve.sigma.beans.EscrituraBean"
	scope="page"></jsp:useBean>
<jsp:useBean id="BEscritura2" class="com.meve.sigma.beans.EscrituraBean"
	scope="page"></jsp:useBean>
<%
	String strIdAsunto = "";
	String carga = "";
	strIdAsunto	=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
	carga = request.getParameter("cargar");
	
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+strTmp+"?id_asunto="+strIdAsunto);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}
%>
<%
	String contentUri = application.getInitParameter("content");
	String userContent = application.getInitParameter("user");
	String passContent = application.getInitParameter("passwd");
	String pathContent = application.getInitParameter("path");
	Vector listaPara 	= new Vector();
	Vector listaCC 		= new Vector();
	Vector listaParaE 	= new Vector();
	Vector listaIDSPara = new Vector();
	Vector listaIDSCC	= new Vector();
	Vector listaIDSParaExt = new Vector();
	String strEntidad			=	(AsuntoRep.getAsuntoEntidad()== null)?"":AsuntoRep.getAsuntoEntidad();
	String strIdEntidad			=	(AsuntoRep.getIdEntidad()== null)?"":AsuntoRep.getIdEntidad();
	String strRemitente			=	(AsuntoRep.getAsuntoRemitente()== null)?"":AsuntoRep.getAsuntoRemitente();
	String strIdRemitente		=	(AsuntoRep.getIdRemitente()== null)?"":AsuntoRep.getIdRemitente();
	String strCargo				=	(AsuntoRep.getAsuntoCargo()== null)?"":AsuntoRep.getAsuntoCargo();
	String strCorreo			=	(AsuntoRep.getAsuntoCorreo()== null)?"":AsuntoRep.getAsuntoCorreo();
	String strFirmante			=	(AsuntoRep.getAsuntoFirmante()== null)?"":AsuntoRep.getAsuntoFirmante();
	String strIdDestinatario	=	(AsuntoRep.getIdDestinatario()== null)?"":AsuntoRep.getIdDestinatario();
	String strDestinatario		=	(AsuntoRep.getAsuntoDestinatario()== null)?"":AsuntoRep.getAsuntoDestinatario();
	String strCargoDest			=	(AsuntoRep.getAsuntoCargoDest()== null)?"":AsuntoRep.getAsuntoCargoDest();
	String strAreaDest			=	(AsuntoRep.getAsuntoAreaDest()== null)?"":AsuntoRep.getAsuntoAreaDest();
	String strMailDest			=	(AsuntoRep.getMailDest()== null)?"":AsuntoRep.getMailDest();
	String strAsunto			=	(AsuntoRep.getAsunto()== null)?"":AsuntoRep.getAsunto();
	String strIdExpediente		=	(AsuntoRep.getAsuntoExpediente()== null)?"":AsuntoRep.getAsuntoExpediente();
	//String strUbicacion			=	(AsuntoRep.getAsuntoUbicacion()== null)?"":AsuntoRep.getAsuntoUbicacion();
	//String strReferenciaExp		=	(AsuntoRep.getAsuntoReferencia()== null)?"":AsuntoRep.getAsuntoReferencia();
	String strIdTipoDocto		=	(AsuntoRep.getAsuntoTipoDocto()== null)?"":AsuntoRep.getAsuntoTipoDocto();
	String strFechaRecepcion	=	(AsuntoRep.getAsuntoFechaRecepcion()== null)?"":AsuntoRep.getAsuntoFechaRecepcion();
	String strFechaDocto		=	(AsuntoRep.getAsuntoFechaDocto()== null)?"":AsuntoRep.getAsuntoFechaDocto();
	String strFechaCaducidad	=	(AsuntoRep.getAsuntoFechaCad()== null)?"":AsuntoRep.getAsuntoFechaCad();
	String strFolioExterno		=	(AsuntoRep.getAsuntoFolioExt()== null)?"":AsuntoRep.getAsuntoFolioExt();
	String strFolioIntermedio	=	(AsuntoRep.getAsuntoFolioInt()== null)?"":AsuntoRep.getAsuntoFolioInt();
	String strSintesis			=	(AsuntoRep.getAsuntoSintesis()== null)?"":AsuntoRep.getAsuntoSintesis();
	String strComentarios		=	(AsuntoRep.getAsuntoComentario()== null)?"":AsuntoRep.getAsuntoComentario();
	String strPalabraClave		=	(AsuntoRep.getAsuntoPalabraClave()== null)?"":AsuntoRep.getAsuntoPalabraClave();
	String strAsuntoAnterior	=	(AsuntoRep.getAsuntoAnterior()== null)?"":AsuntoRep.getAsuntoAnterior();
	String strIdPrioridad		=	(AsuntoRep.getAsuntoPrioridad()== null)?"":AsuntoRep.getAsuntoPrioridad();
	String strIdTipoAsunto		=	(AsuntoRep.getAsuntoTipoAsunto()== null)?"":AsuntoRep.getAsuntoTipoAsunto();
	String strIdRutaAuto		=	(AsuntoRep.getAsuntoRutaAuto()== null)?"":AsuntoRep.getAsuntoRutaAuto();
	String strControl			=	(AsuntoRep.getControl()== null)?"":AsuntoRep.getControl();
	String URL 					=	(AsuntoRep.getUrl()== null)?"":AsuntoRep.getUrl();
	String strFolioGenerado		=	(AsuntoRep.getFol()== null)?"":AsuntoRep.getFol();
	String strPara				=	(AsuntoRep.getAsuntoPara()== null)?"":AsuntoRep.getAsuntoPara();
	String strCC				=	(AsuntoRep.getAsuntoCC()== null)?"":AsuntoRep.getAsuntoCC();
	String strIdsPara			=	(AsuntoRep.getAsuntoIdsPara()== null)?"":AsuntoRep.getAsuntoIdsPara();
	String strIdsCC				=	(AsuntoRep.getAsuntoIdsCC()== null)?"":AsuntoRep.getAsuntoIdsCC();
	String strLugarEvento		= 	(AsuntoRep.getlugarEvento()== null)?"":AsuntoRep.getlugarEvento();
	String strFormateada		=	(AsuntoRep.getFechaEvento()== null)?"":AsuntoRep.getFechaEvento();
	String strHoraEvento		=	(AsuntoRep.getHora_evento()== null)?"":AsuntoRep.getHora_evento();         
	String strMinEvento		=		(AsuntoRep.getMin_evento()== null)?"":AsuntoRep.getMin_evento();  

	String strHoraRecep			=	(AsuntoRep.getHoraRecepcion()== null)?"":AsuntoRep.getHoraRecepcion();         
	String strMinRecep			=	(AsuntoRep.getMinRecepcion()== null)?"":AsuntoRep.getMinRecepcion();  

	String strParaE				=	(AsuntoRep.getAsuntoParaE()== null)?"":AsuntoRep.getAsuntoParaE();
	String strIdsParaE			=	(AsuntoRep.getAsuntoIdsParaE()== null)?"":AsuntoRep.getAsuntoIdsParaE();    
	String strAccion			=	"";
	String idAsuntoAnt			=	(AsuntoRep.getIdAsuntoAnt()== null)?"":AsuntoRep.getIdAsuntoAnt();
	String idAsuntoRef			=	(AsuntoRep.getIdAsuntoRef()== null)?"":AsuntoRep.getIdAsuntoRef(); 
	String strTramite			=	(AsuntoRep.getAsuntoTramite()== null)?"":AsuntoRep.getAsuntoTramite();
	String strTipoFolio			=	(AsuntoRep.getAsuntoTipoFolio()==null)?"":AsuntoRep.getAsuntoTipoFolio();
	String strbanderaVent		=	(request.getParameter("banderaVent")==null)?"1":request.getParameter("banderaVent");
	String strIdTramite			=	(request.getParameter("id_tra")==null)?"":request.getParameter("id_tra");
	String strCreador			=	"";
	String strCreador1			=	"";
	String strAreaUs			=	"";
	String strFechaCreacion		=	"";
	String strEstatus			=	(request.getParameter("estatusN")==null)?"":request.getParameter("estatusN");
	String strAvance			=	"";
	String strIdUsuario			=	"";
	String strPrioridad			=	"";
	String strTipoDocto			=	"";
	String strTipoAsunto		=	"";
	String strRutaAuto			=	"";
	String strFeFormateada1		=	"";
	String strFeFormateada2		=	"";
	String strFeFormateada3		=	"";
	String strFeFormateada4		=	(request.getParameter("formateada")==null)?"":request.getParameter("formateada");
	String strMensajeDuplicado	=	"";
	String strEstatusN			=	"";
	String serverContentManager	=  	application.getInitParameter("content");
	String strActivarCM 		= 	application.getInitParameter("ActivarContent");
	String strItemType  		=  	application.getInitParameter("ItemType");
	String server				=	application.getInitParameter("servername");
	String strRutaBase			= 	(application.getInitParameter("RutaBase")==null)?"":application.getInitParameter("RutaBase");
	String ids					=	"";
	String refs					=	"";
	String strAccionArchivo		=	(request.getParameter("accionArchivo")== null)?"":request.getParameter("accionArchivo");
	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");

	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
	Vector finesSemana = com.meve.sigma.util.Utilerias.getFinesSemana(1,1);
	String diasFestivos[][] = ActualizaDiaFestivo.getListaDiasFestivos();
	if (diasFestivos!=null && diasFestivos.length>0){
		for (int i=0; i<diasFestivos.length; i++){
			finesSemana.add(com.meve.sigma.util.Utilerias.formatearFechas(diasFestivos[i][1]));
		}
	}

	listaPara = Utilerias.getNombres(strPara);
	listaCC = Utilerias.getNombres(strCC);
	listaParaE = Utilerias.getNombres(strParaE);
	listaIDSPara = Utilerias.getNombrePuesto(strIdsPara,0);
	listaIDSCC = Utilerias.getNombrePuesto(strIdsCC,0);
	listaIDSParaExt = Utilerias.getRemitenteEntidad(strIdsParaE,1);
	
	String strDatosNewWindow[][] = new String[2][2];
	String strDatosAsuntoAnt[][] = new String[0][0];
	String strDatosAsuntoAntRef[][] = new String[0][0];
	String strDatosAsuntoLigas[][] = new String[0][0];

	boolean bUpdate			=	false;
	boolean bDelete			=	false;
	boolean bInsertarBit	=	false;
	boolean bexisteInst		=	false;
	
	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaCreacion 				=	sdf.format(f);
	
	String strHorarioUAEntrada	= ActualizaArea.getHoraEntradaArea(BUsuario.getIdArea());
	String strHorarioUASalida	= ActualizaArea.getHoraSalidaArea(BUsuario.getIdArea());
	
	if(strFechaRecepcion.length()!=0)
		strFeFormateada1 = strFechaRecepcion;
	else
		strFeFormateada1 = strFechaCreacion;
	strCreador1 = 	BUsuario.getIdUsuario();
	strCreador	=	BUsuario.getNombre();
	strAreaUs	=	BUsuario.getIdArea();
	
	strAccion	=	(request.getParameter("accion")== null)?"":request.getParameter("accion");
	carga		= 	request.getParameter("cargar");
	String strA =	request.getParameter("a");

	String mensaje = "";
	boolean bvalida = false;
	int contador = (request.getParameter("contador")== null)?0:Integer.parseInt(request.getParameter("contador"));
	contador++;
	String strBandera = (request.getParameter("strBandera")== null)?"false":request.getParameter("strBandera");
	String setFoco = (request.getParameter("setFoco")== null)?"botEntidad":request.getParameter("setFoco");

	if(strA == null){
		strA = "4";
	}
	
	String url 		= 	request.getRequestURI();
	URL 		= 	server+url+"?id_asunto="+strIdAsunto;
	if(strIdAsunto != null && strIdAsunto.trim().length()>0 && strAccion.length()==0 && !strAccion.equals("EditDest"))
	{
		String strDatosAsunto[][] = ActualizaAsunto.getAsuntos(strIdAsunto);
		if (contador==1){
		strIdEntidad		=	strDatosAsunto[0][0];
		strIdRemitente		=	strDatosAsunto[0][2];
		strFirmante			=	strDatosAsunto[0][4];
		strAsunto			=	strDatosAsunto[0][5];
		strIdExpediente		=	strDatosAsunto[0][6];
		strIdTipoDocto		=	strDatosAsunto[0][10];
		strFechaRecepcion	=	strDatosAsunto[0][13];
		strFechaRecepcion	=	Utilerias.formatearFechas(strFechaRecepcion);
		strFeFormateada1	= 	strFechaRecepcion;
		strFechaDocto		=	strDatosAsunto[0][14];
		strFechaDocto		=	Utilerias.formatearFechas(strFechaDocto);
		strFechaCaducidad	=	strDatosAsunto[0][15];
		strFechaCaducidad	=	Utilerias.formatearFechas(strFechaCaducidad);
		strFolioExterno		=	strDatosAsunto[0][16];
		strFolioIntermedio	=	strDatosAsunto[0][17];
		strSintesis			=	strDatosAsunto[0][18];
		strComentarios		=	strDatosAsunto[0][19];
		strPalabraClave		=	strDatosAsunto[0][20];
		strAsuntoAnterior	=	strDatosAsunto[0][21];
		strIdPrioridad		=	strDatosAsunto[0][22];
		strFolioGenerado	=	strDatosAsunto[0][23];
		strCreador1			=	strDatosAsunto[0][24];
		
		strAreaUs			=	strDatosAsunto[0][26];
		strIdTipoAsunto		=	strDatosAsunto[0][27];
		
		strIdDestinatario	=	strDatosAsunto[0][30];
		strDestinatario		=	strDatosAsunto[0][35]+" / "+strDatosAsunto[0][31];
		strMailDest			=	strDatosAsunto[0][34];
		strCargoDest		=	strDatosAsunto[0][35];
		strCorreo			=	strDatosAsunto[0][37];
		strCargo			=	strDatosAsunto[0][38];
		strAreaDest			=	strDatosAsunto[0][39];
		strPrioridad		=	strDatosAsunto[0][40];
		strTipoDocto		=	strDatosAsunto[0][41];
		strTipoAsunto		=	strDatosAsunto[0][42];
		strRutaAuto			=	strDatosAsunto[0][43];
		strControl			=	strDatosAsunto[0][45];
		strPara				=	strDatosAsunto[0][46];
		strCC				=	strDatosAsunto[0][47];
		strIdsPara			=	strDatosAsunto[0][48];
		strIdsCC			=	strDatosAsunto[0][49];
		strLugarEvento		= 	strDatosAsunto[0][50];
		strFormateada		=	Utilerias.formatearFechas(strDatosAsunto[0][51]);
		strHoraEvento		=   strDatosAsunto[0][52];
		strMinEvento		=   strDatosAsunto[0][53];
		strParaE			=	strDatosAsunto[0][54];
		strIdsParaE			=	strDatosAsunto[0][55];
		strTramite			=	strDatosAsunto[0][56];
		strTipoFolio		=	strDatosAsunto[0][57];
		strHoraRecep		=	strDatosAsunto[0][58];
		strMinRecep			=	strDatosAsunto[0][59];
		}
		strAvance			=	strDatosAsunto[0][29];
		strFechaCreacion	=	strDatosAsunto[0][25];
		strFeFormateada4	=	Utilerias.formatearFechas(strFechaCreacion);
		strEstatus			=	strDatosAsunto[0][28];
		
		listaPara = Utilerias.getNombres1(strPara);
		listaCC = Utilerias.getNombres1(strCC);
		listaParaE = Utilerias.getNombres(strParaE);
		listaIDSPara = Utilerias.getNombrePuesto(strIdsPara,0);
		listaIDSCC = Utilerias.getNombrePuesto(strIdsCC,0);
		listaIDSParaExt = Utilerias.getRemitenteEntidad(strIdsParaE,1);

		bexisteInst			=	ActualizaInstrucciones.TieneInstrucciones(strIdAsunto);

		if(strControl.equals("1")){
			strEntidad	=	ActualizaArea.NombreArea(strIdEntidad);
			strRemitente=	ActualizaUsuario.NombrePuesto(strIdRemitente);
			strCargo	=	ActualizaUsuario.getMailCargoUsuario(strIdRemitente)[0][0];
			strCorreo	=	ActualizaUsuario.getMailCargoUsuario(strIdRemitente)[0][1];
		}else{
			strEntidad	=	ActualizaEntidad.getNombreEntidad(strIdEntidad);
			strRemitente=	ActualizaRemitente.getNombreRemitente(strIdRemitente);
			String strDat[][] = ActualizaRemitente.getRemitentes(strIdRemitente);
			strCargo	=	strDat[0][2];
			strCorreo	=	strDat[0][5];
		}
		strRemitente = strCargo + " / " + strRemitente;

		if(strRutaAuto == null || strRutaAuto.length() <= 0)
			strRutaAuto = "No hay ruta automatica";
		if(strCorreo.length() == 0 || strCorreo == null)
			strCorreo = "No tiene correo registrado";
		if(strCargo.length() == 0 || strCargo == null)
			strCargo = "No tienes cargo registrado";
		
		if(strEstatus.equals("0")){
			strEstatusN = "En Recepci&oacute;n";
		}else if(strEstatus.equals("1")){
			strEstatusN = "Por Turnar";
		}else if(strEstatus.equals("2")){
			strEstatusN = "En tr&aacute;mite";
		}else if(strEstatus.equals("3")){
			strEstatusN = "Terminada"; 
		}

		strDatosNewWindow = ActualizaAsunto.getIdsRef(strIdAsunto); 
		if(strDatosNewWindow.length > 0){

			ids = strDatosNewWindow[0][0];
			refs = strDatosNewWindow[0][1];
		}
			
		strDatosAsuntoAnt = ActualizaAsunto.getAsuntosAnt(strIdAsunto); 
	 	strDatosAsuntoLigas	=	ActualizaAsunto.getAsuntosLigados(strIdAsunto);
		
	}

	///***Calculo Tramite
	if(strIdTramite.length()!=0 && !strIdTramite.equals("-1")){
		String str[][] = ActualizaTramite.getTramite(strIdTramite);
		String strDuracion = str[0][5];   
		Calendar cFechaInicio	=	Utilerias.StringCalendar2(strFeFormateada1);
		String strFechaFin	= Utilerias.getFechaTerminacionInst((Calendar)cFechaInicio.clone(), str[0][5]);
		Calendar FI = Utilerias.StringCalendar2(strFeFormateada1);
		Calendar FF = Utilerias.StringCalendar2(strFechaFin);
		int iDuracion = Utilerias.getSinDiasFestivos(FI, FF);
		String strDuracion1 = String.valueOf(iDuracion);
		strFechaCaducidad = Utilerias.getFechaTerminacionInst((Calendar)FF.clone(), strDuracion1);
	}
	///***Fin Calculo Tramite
	
	if(strEstatus.equals("0")){
		strEstatusN = "En Recepci&oacute;n";
	}else if(strEstatus.equals("1")){
		strEstatusN = "Por Turnar";
	}else if(strEstatus.equals("2")){
		strEstatusN = "En tr&aacute;mite";
	}else if(strEstatus.equals("3")){
		strEstatusN = "Terminada"; 
	}
	
	boolean bValidaFechaRec = true;
	boolean bValidaEstatus = false;
	if (strIdAsunto!=null && !strIdAsunto.equals("")){
		if (strEstValidacion.equals("")){
			strEstValidacion = ActualizaAsunto.getEstatus(strIdAsunto);
		}
		String strEstatusValida = ActualizaAsunto.getEstatus(strIdAsunto);
		if (!strEstatusValida.equals(strEstValidacion) || strEstValidacion.equalsIgnoreCase("4")){ 
			bValidaEstatus = true; 
		}
	}

	if(strAccion != null && strAccion.length() > 0 && !strAccion.equals("EditDest")){
		String serverMail	= session.getServletContext().getAttribute("app.siga.serverMail").toString();
		String portServer	= application.getInitParameter("PortMail");
		String serverName 	= application.getInitParameter("servername");
		String strConfigFolio = application.getInitParameter("genFolio");

		mensaje = "Ocurrio un error durante el registro, por favor verifique sus datos " + "\\n";
		bvalida = false;
		int j=0;
		if (strIdEntidad!= null && strIdEntidad.equals("") && ((ActualizaEntidad.getEstatusEntidad(strIdEntidad).equals("0") && strControl.equals("0")) || 
			(ActualizaArea.getEstatusArea(strIdEntidad).equals("0") && strControl.equals("1")))){
			mensaje = mensaje + " - La Entidad fue borrada durante el registro" + "\\n";
			bvalida = true;
		}
		
		if (strIdRemitente!= null && strIdRemitente.equals("") && ((ActualizaRemitente.getEstatusRemitente(strIdRemitente).equals("0") && strControl.equals("0"))
			|| (ActualizaUsuario.getEstatusUsuario(strIdRemitente).equals("0") && strControl.equals("1")))){
			mensaje = mensaje + " - El Remitente fue borrado durante el registro" + "\\n";
			bvalida = true;
		}
		
		if (strIdDestinatario!= null && strIdDestinatario.equals("") && ActualizaUsuario.getEstatusUsuario(strIdDestinatario).equals("0")){
			mensaje = mensaje + " - La Ventanilla fue borrada durante el registro" + "\\n";
			bvalida = true;
		}
		
		if (strIdTipoDocto!= null && strIdTipoDocto.equals("") && ActualizaTipo_Doc.getEstatusTipoDoc(strIdTipoDocto).equals("0")){
			mensaje = mensaje + " - El Tipo de Documento fue borrado durante el registro" + "\\n";
			bvalida = true;
		}
		
		if (strTramite!= null && strTramite.equals("") && strTramite.indexOf('|')!=-1){
			if (ActualizaTramite.getEstatusTramite(strTramite.substring(0,strTramite.indexOf('|'))).equals("0")){
				mensaje = mensaje + " - El Tramite fue borrado durante el registro" + "\\n";
				bvalida = true;
			}
		}
		if(strIdPrioridad.length()!=0){
			if (strIdPrioridad!= null && strIdPrioridad.equals("") && ActualizaPrioridad.getEstatusPrioridad(strIdPrioridad).equals("0")){
				mensaje = mensaje + " - La Prioridad fue borrada durante el registro" + "\\n";
				bvalida = true;
			}
		}
		if(strIdTipoAsunto.length()!=0){
			if (strIdTipoAsunto!= null && strIdTipoAsunto.equals("") && ActualizaTipoAsunto.getEstatusTipoAsunto(strIdTipoAsunto).equals("0")){
				mensaje = mensaje + " - El Tipo de Asunto fue borrado durante el registro" + "\\n";
				bvalida = true;
			}
		}
		StringTokenizer usuarioTkn = new StringTokenizer(strIdsPara,",");
		while (usuarioTkn.hasMoreTokens()){
			String idUsuario = usuarioTkn.nextToken();
			if (ActualizaUsuario.getEstatusUsuario(idUsuario).equals("0")){
				mensaje = mensaje + " - El Destinatario "+ActualizaUsuario.NombreUsuario(idUsuario)+" fue borrado durante el registro" + "\\n";
				bvalida = true;
			}
		}

		usuarioTkn = new StringTokenizer(strIdsCC,",");
		while (usuarioTkn.hasMoreTokens()){
			String idUsuario = usuarioTkn.nextToken();
			if (ActualizaUsuario.getEstatusUsuario(idUsuario).equals("0")){
				mensaje = mensaje + " - El Destinatario "+ActualizaUsuario.NombreUsuario(idUsuario)+" fue borrado durante el registro" + "\\n";
				bvalida = true;
			}
		}

		if (!strAccion.equals("cambiarRep") && !strAccion.equals("guardarRep") && !ActualizaFolio.ExisteFolio(BUsuario.getIdArea())){
			mensaje = mensaje + " - No existe un Folio de Recepci&oacute;n definido para su Unidad Administrativa \\n   Favor de contactar a su Administrador" + "\\n";
			strAccionArchivo = "";
			strAccion = "";
			bvalida = true;
		}

		bValidaFechaRec = Utilerias.comparaFechaActual(strFechaRecepcion+" "+strHoraRecep+":"+strMinRecep+":00");
		if (bValidaFechaRec && !bvalida){
			strFechaRecepcion = strFechaRecepcion+" "+strHoraRecep+":"+strMinRecep+":00";
			String fechaTemCaducidad = "";
			fechaTemCaducidad = strFechaCaducidad+" "+strHoraRecep+":"+strMinRecep+":00";
			AsuntoRep.setAsuntoFechaRecepcion(strFechaRecepcion);
			AsuntoRep.setAsuntoFechaCad(fechaTemCaducidad);
		}

		if (!bvalida && !bValidaEstatus && bValidaFechaRec){
			AsuntoProceso proceso = new AsuntoProceso(contentUri, userContent, passContent, pathContent); 
			String redireccion = proceso.procesarAsunto(request, BUsuario, serverMail, portServer, serverName,
									serverContentManager, strActivarCM, strItemType, server,
									strConfigFolio, strRutaBase, strAccion, AsuntoRep);
			try{
				if(redireccion.length() < 2){
					AsuntoRep.setDuplicado("El Folio del Documento ya existe");
					strMensajeDuplicado = AsuntoRep.getDuplicado();
				}else{
						if (strAccionArchivo!=null && strAccionArchivo.equals("guardarInsertarArchivo")){ %>
							<script type="text/javascript">
						<!--
							location.assign('ImportarCM.jsp?Folio=<%=strFolioGenerado%>&IdAsunto=<%=strIdAsunto%>&a=<%=strA%>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');
						//-->
							</script>
<%						}else{
							if (strAccionArchivo!=null && strAccionArchivo.equals("guardarRegresarURI")){ %>
								<script type="text/javascript">	
							<!--
								location.assign('<%= retURI %>');
							//-->
								</script>
<%							}else{
							redireccion = (redireccion.equals("PortalBorrador.jsp") || strAccion.equals("borrar"))?redireccion:(redireccion+"&folioControl=1");
							response.sendRedirect(redireccion);
							}
						}
							}
				//response.sendRedirect(redireccion);
			}catch(java.io.IOException io){
			}
		}
	}

	//** Este bloque se utiliza para mostrar el botón
	//** de guardar
	if(BUsuario.getRecepcion() || BUsuario.getTurnado())
			BEscritura.setValue(true);
		else
			BEscritura.setValue(false);
	//** Fin botón guardar
	
	if(strIdAsunto != null && strIdAsunto.trim().length() > 0)
		BEscritura1.setValue(true);
	else
		BEscritura1.setValue(false);

	//** Este bloque de escritura se utiliza para mostrar los datos del
	//** turnado a los usuarios que tengan el perfil de Turnador
	if(BUsuario.getTurnado())
		BEscritura2.setValue(true);
	else
		BEscritura2.setValue(false);
	//** Fin perfil turnar

%>
<% 
	//** los usuarios que tengan el perfil de administrador y recepción
	//** pueden modificar el asunto
	if(BUsuario.getRecepcion() ||
		BUsuario.getTurnado()){
	}
	else{
%>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% 	} %>
<%!
	public static boolean par(int num)
    {
        boolean p = false;
        if (num % 2 == 0) 
        {
            p = true;
        }    
        return p;
    }
%>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../css/link.css" />
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script type="text/javascript" src="../js/link.js"></script>
<SCRIPT language=JavaScript type=text/javascript>
	
	var botonBandera = true;
	var hay_hija = new Boolean(false);
	var hija = new Object(); 
	var bandera = false;
	
	function resetTimer(){
		timer_reload();
	}

	function Abrir(para, cc, ipara, icc){

		var isCenter ='true';
		var features = '';

		if(window.screen)if(isCenter)if(isCenter=="true"){
		    var myLeft = (screen.width-800)/2;
		    var myTop = (screen.height-450)/2;
		    features+=(features!='')?',':'';
		    features+=',left='+myLeft+',top='+myTop; 
		}	
		hija = window.open('listUserUR.jsp?para=' + para + '&cc=' + cc + '&ipara=' + ipara + '&icc= ' +icc  ,'hija',features+((features!='')?',':'')+'width=800, height=450, status=yes');
		hay_hija = true; 
	}
	function AbrirAnex(idAsunto, ids, refs){

		bandera = "false"; //document.Asunto.strBandera.value;
		var isCenter ='true';
		var features = '';

		if(bandera == "true"){
			if(confirm("Al Seleccionar esta opción, los cambios que no hayan sido guardados se perderan,\n¿Deseas continuar?")){
				if(window.screen)if(isCenter)if(isCenter=="true"){
				    var myLeft = (screen.width-760)/2;
				    var myTop = (screen.height-360)/2;
				    features+=(features!='')?',':'';
				    features+=',left='+myLeft+',top='+myTop; 
				}
				//BloquearElementos();
				hija = window.open('AnexarReferencia.jsp?strIdAsunto='+ idAsunto + '&idAsuntoAnt=' + ids + '&idAsuntoRef=' + refs + '&idArea=<%=BUsuario.getIdArea()%>&idUs=<%=BUsuario.getIdUsuario()%>&estValidacion=<%=strEstValidacion%>','hija',features+((features!='')?',':'')+'width=760, height=360, status=yes');
				hay_hija = true; 
			}
		} else{
			if(window.screen)if(isCenter)if(isCenter=="true"){
			    var myLeft = (screen.width-760)/2;
			    var myTop = (screen.height-360)/2;
			    features+=(features!='')?',':'';
			    features+=',left='+myLeft+',top='+myTop; 
			}
			//BloquearElementos();
			hija = window.open('AnexarReferencia.jsp?strIdAsunto='+ idAsunto + '&idAsuntoAnt=' + ids + '&idAsuntoRef=' + refs + '&idArea=<%=BUsuario.getIdArea()%>&idUs=<%=BUsuario.getIdUsuario()%>&estValidacion=<%=strEstValidacion%>','hija',features+((features!='')?',':'')+'width=760, height=360, status=yes');
			hay_hija = true; 
		}	
	}
	function agregarContent(){
		doc = document.Asunto;
		bandera = document.Asunto.strBandera.value;
		if(doc.id_asunto.value == ""){
			validacionesAsunto11();
		}else{
			if(bandera == "true"){
				if(confirm("Se detectaron cambios en el Asunto.\nPulse Aceptar para guardar los cambios y continuar o\npulse Cancelar para continuar sin guardar los cambios.")){
					guardarAsuntoEnRecepcion('guardarInsertarArchivo');
				}else{
					location.assign('ImportarCM.jsp?Folio=<%=strFolioGenerado%>&IdAsunto=<%=strIdAsunto%>&a=<%=strA%>&estValidacion=<%=strEstValidacion%>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');
				}
			}else{
				location.assign('ImportarCM.jsp?Folio=<%=strFolioGenerado%>&IdAsunto=<%=strIdAsunto%>&a=<%=strA%>&estValidacion=<%=strEstValidacion%>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');
			}
		}
	}
	function agregar() 
	{	
		location.assign('ImportarCM.jsp?Folio=<%=strFolioGenerado%>&IdAsunto=<%=strIdAsunto%>&a=<%=strA%>');
	}
	function escaner(){
		<% if(strActivarCM.equals("si")){ %>
		location.assign('sigmaCM:%20<%= serverContentManager %>/eclient/ArchivoCM%20<%=strItemType%>%20escanear%20false%20<%=strIdAsunto%>%20<%="SinFilio"%>%20<%=BUsuario.getNombre()%>');
		<%}else{%>
		location.assign('sigmaCM:%20<%=server%><%=strRutaBase%>/ArchivoCM%20<%=strItemType%>%20escanear%20true%20<%=strIdAsunto%>%20<%="SinFolio"%>%20<%=BUsuario.getIdUsuario()%>');
		<%}%>
	}
	function cargaFoco(){
		doc = document.Asunto;
		if (doc.setFoco.value == 'asunto'){
			doc.asunto.focus();
		}
		else{
			var elemento = document.getElementsByName(doc.setFoco.value);
			elemento[0].focus();
		}
	}
	function regresarURI(){
		doc = document.Asunto;
		bandera = document.Asunto.strBandera.value;

		if(bandera == "true"){
			if(confirm("Se detectaron cambios en el Asunto.\nPulse Aceptar para guardar los cambios y continuar o\npulse Cancelar para continuar sin guardar los cambios.")){
				guardarAsuntoEnRecepcion('guardarRegresarURI');
			}else{
				location.assign('<%= retURI %>');
			}
		} else{
			location.assign('<%= retURI %>');
		}
	}

	function ventanaHija(){
		if (hija!= null && hay_hija == true){ 
			try{
				hija.focus(); 
			}catch(err){
				hay_hija = new Boolean(false);
				hija = new Object(); 
			}
		}
	}

</SCRIPT>
<script type="text/javascript">
	function validaFechaFinesSem(campoFecha){
		var valida = 0 
	<% 	for (int ik=0; ik<finesSemana.size(); ik++){ %>	
		if (campoFecha != null && campoFecha.value == "<%= (String)finesSemana.get(ik) %>") {
			valida =1;
		}
	<%	} %>
		if (valida == 1){
			alert("La fecha seleccionada no es laborable");
			campoFecha.value = "";
			//break;
		} 
	}
</script>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="valida=0;timer_load();cargaFoco();"
onmouseover="ventanaHija();" 
onfocus="ventanaHija();"
onMouseMove="limitaTextArea(document.Asunto.asuntoSintesis,'Comentario','4000');
			limitaTextArea(document.Asunto.asuntoComentario,'Comentarios','4000');
			limitaTextArea(document.Asunto.lugarEvento,'Lugar del Evento', '4000');
			validaFechaRec();validaFechaDoc();validaFechaCom();validaFechaEve();
			validaFechaFinesSem(document.Asunto.asuntoFechaCad);
			validaFechaFinesSem(document.Asunto.asuntoFechaDocto);
			validaFechaFinesSem(document.Asunto.asuntoFechaRecepcion);
			validaFechaFinesSem(document.Asunto.fechaEvento);"
onKeyPress="timer_reload();" onClick="timer_reload();" onunload="hija.close()">
<FORM action="AsuntoRecepcion.jsp" name="Asunto" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%= strIdAsunto %>" name="id_asunto">
<INPUT type="hidden" value="<%= strControl %>" name="control">
<INPUT type="hidden" value="<%=URL%>" name="url">
<INPUT type="hidden" value="<%=strFolioGenerado%>" name="fol">
<INPUT type="hidden" value="<%= strIdRemitente %>" name="idRemitente">
<INPUT type="hidden" value="<%= strIdEntidad %>" name="idEntidad">
<INPUT type="hidden" value="<%= strIdDestinatario %>" name="idDestinatario">
<INPUT type="hidden" value="<%= strMailDest %>" name="mailDest">
<INPUT type="hidden" value="<%= carga %>" name="carga">
<INPUT type="hidden" value="<%= idAsuntoAnt %>" name="idAsuntoAnt">
<INPUT type="hidden" value="<%= idAsuntoRef %>" name="idAsuntoRef">
<INPUT type="hidden" value="<%=strIdsPara%>" name="asuntoIdsPara">
<INPUT type="hidden" value="<%=strIdsCC%>" name="asuntoIdsCC">
<INPUT type="hidden" value="<%=strIdsParaE%>" name="asuntoIdsParaE">
<INPUT type="hidden" value="" name="asuntoIdsCCE">
<INPUT type="hidden" value="<%=strPara%>" name="asuntoPara">
<INPUT type="hidden" value="<%=strCC%>" name="asuntoCC">
<INPUT type="hidden" value="<%=strParaE%>" name="asuntoParaE">
<INPUT type="hidden" value="<%=retURI%>" name="retURI" >
<INPUT type="hidden" value="<%= strHorarioUAEntrada %>" name="horarioEntrada">
<INPUT type="hidden" value="<%= strHorarioUASalida %>" name="horarioSalida" >
<INPUT type="hidden" value="<%= BUsuario.getIdArea() %>" name="idAreaUsuario" >
<INPUT type="hidden" value="<%= contador %>" name="contador">
<INPUT type="hidden" value="<%= strBandera %>" name="strBandera">
<INPUT type="hidden" value="<%= setFoco %>" name="setFoco">
<INPUT type="hidden" value="<%=strEstatus%>" name="estatusN">
<INPUT type="hidden" value="<%=strFeFormateada4%>" name="formateada">
<INPUT type="hidden" value="<%=strAccionArchivo%>" name="accionArchivo">
<INPUT type="hidden" value="<%=strIdTramite%>" name="id_tra">
<INPUT type="hidden" value="" name="banderaVent">
<INPUT type="hidden" value="<%=strEstValidacion%>" name="estValidacion">
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
<BR/>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="863"><%if(strEstatus.equals("0")){ %>
		<div align="right"><b><font size="4" color="#00204F" face="Verdana">Asunto
		En Recepci&oacute;n</font></b></div>
		<% }else if(strEstatus.equals("1")){ %>
		<div align="right"><b><font size="4" color="#00204F" face="Verdana">Asunto
		Por Turnar</font></b></div>
		<% }else if(strEstatus.equals("2")){ %>
		<div align="right"><b><font size="4" color="#00204F" face="Verdana">Asunto
		En Tr&aacute;mite</font></b></div>
		<% }else if(strEstatus.equals("3")){%>
		<div align="right"><b><font size="4" color="#00204F" face="Verdana">Asunto
		Terminado</font></b></div>
		<% }%></td>
            </tr>
        </table>
    </DIV>
<BR/>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0" width="863">
<TBODY>
	<TR>	
		<TD width="5%">
			<A onclick="if(botonBandera){botonBandera=false; regresarURI();}" onMouseOver="document.MyImage.src='../Imagenes/NavLeft2.gif';" onMouseOut="document.MyImage.src='../Imagenes/NavLeft.gif';">
			<IMG border="0" src="../Imagenes/NavLeft.gif" title="Regresar / Cancelar" name="MyImage"></A>
		</TD>
		<c:choose>
			<c:when test='${BEscritura.value}'>
				<td width="5%">
					<A onclick="if(botonBandera){botonBandera=false; guardarAsuntoEnRecepcion();}" onMouseOver="document.guardarRepBtn.src='../Imagenes/SaveRecepOff.gif';" onMouseOut="document.guardarRepBtn.src='../Imagenes/SaveRecepOn.gif';">
					<IMG border="0" src="../Imagenes/SaveRecepOn.gif" name="guardarRepBtn" title="Guardar en Recepci&oacute;n"></A>
				</td>
			</c:when>
			<c:otherwise>
				<td width="5%">&nbsp;</td>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='${BEscritura.value}'>
				<TD width="5%">
					<A onclick="if(botonBandera){botonBandera=false; guardarAsunto();}" onMouseOver="document.guardarBtn.src='../Imagenes/Save2.gif';" onMouseOut="document.guardarBtn.src='../Imagenes/Save.gif';">
					<IMG border="0" src="../Imagenes/Save.gif" title="Guardar para Turnar" name="guardarBtn"></A>
				</TD>
			</c:when>
			<c:otherwise>
				<td width="5%">&nbsp;</td>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='${BEscritura.value}'>
				<TD width="5%">
					<a onclick="if(botonBandera){botonBandera=false; agregarContent();}" onMouseOver="document.Attach.src='../Imagenes/Attach2.gif';" onMouseOut="document.Attach.src='../Imagenes/Attach.gif';">
					<IMG border="0" src="../Imagenes/Attach.gif" title="Insertar Archivo" name="Attach"></a>
				</TD>
			</c:when>
			<c:otherwise>
				<TD width="5%">&nbsp;</TD>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='${BEscritura.value}'>
				<TD width="5%">
					<a onclick="if(botonBandera){botonBandera=false; AbrirAnex(<%=strIdAsunto %>,'<%=ids %>','<%=refs %>');}" onMouseOver="document.Refe.src='../Imagenes/asuntAntOff.gif';" onMouseOut="document.Refe.src='../Imagenes/asuntAntOn.gif';">
					<IMG border="0" src="../Imagenes/asuntAntOn.gif" title="Anexar Referencia" name="Refe"></a>
				</TD>
			</c:when>
			<c:otherwise>
				<TD width="5%">&nbsp;</TD>
			</c:otherwise>
		</c:choose>
		<%if (strFolioGenerado.equals("folio por asignar")){%>
		<c:choose>
			<c:when test='${BEscritura.value}'>
			<TD width="5%">
				<A onclick="if(botonBandera){botonBandera=false; BorrarAsunto();}" onMouseOver="document.Borrar.src='../Imagenes/Borrar2a.gif';" onMouseOut="document.Borrar.src='../Imagenes/Borrar.gif';">
				<IMG border="0" src="../Imagenes/Borrar.gif" name="Borrar" title="Borrar Documento"></A>
			</TD>
			</c:when>
			<c:otherwise>
				<td width="5%">&nbsp;</td>
			</c:otherwise>
		</c:choose>
		<%}%>
		<TD width="40%">&nbsp;</TD>
	</TR>
</TBODY>
</TABLE>
</DIV>


<BR>
<DIV align="center">
<TABLE>
<TBODY>
	<TR>
		<TD width="863" align="center">
			<FONT face="Arial" color="red" size="4"><%=strMensajeDuplicado%></FONT>
		</TD>
	</TR>
</TBODY>
</TABLE>
</DIV>
<BR>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<tr valign="top">
		<td width="183"><b><font size="2" color="#004080" face="Arial">Datos
		Generales</font></b></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="380">
			<DIV align="right">
			<FONT face="Arial" color="#00204f" size="2">**Los datos marcados con negritas son obligatorios</FONT>
			</DIV>
		</td>
	</tr>
	<tr valign="top">
		<td width="863" bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
	</tr>
</TBODY>
</TABLE>
</DIV>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<% if(strIdAsunto != null && strIdAsunto.trim().length()>0){ %>
	<TR valign="top">
		<td width="183"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<TD width="380">
			<DIV  align="right">
				<FONT face="Verdana" size="2">Creado por: <I><%= ActualizaUsuario.NombreUsuario(strCreador1) %> - <%= strFeFormateada4 %></I></FONT>
			</DIV>
		</TD>
	</TR>
	<TR>
		<td width="183"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<TD width="380" align="right">
			<FONT face="Verdana" size="2">
				Estatus: <b><%= strEstatusN %></b>
			</FONT>
		</TD>
	</TR>
	<TR>
		<td width="183"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<TD width="380" align="right">
			<FONT face="Verdana" size="2">
				Folio de Recepci&oacute;n: <b><%= strFolioGenerado %></b>
			</FONT>
		</TD>
	</TR>
	<TR>
		<td width="183"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<TD width="380"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></TD>
	</TR>
	<% } %>
	
</TBODY>
</TABLE>
</DIV>
<SCRIPT type="text/javascript">
</SCRIPT>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<tr valign="top">
		<td width="183"><b><font size="2" color="#004080" face="Arial">Datos del Remitente</font></b></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="363"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
	</tr>
</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183">
			<B><FONT face="Arial" color="#004080" size="2">Entidad:</FONT></B>
			<%if(strEstatus.equals("2") || strEstatus.equals("3")){%>
			<%}else{%>
			<%--<INPUT type="button" onclick="AbrirIframe('pop2', '<%=strIdAsunto%>');" class="s-dropdown-btn">--%>
			<INPUT name="botEntidad" type="button" onclick="document.Asunto.strBandera.value=true;AbrirF('<%=strAreaUs%>','<%=strIdAsunto%>','<%= (strControl!=null && strControl.equals("0"))?"0":"1" %>','<%=strIdEntidad+"|"+strEntidad+"/"+strControl%>');" class="s-dropdown-btn">
			<%}%>
			<%--<DIV class="popup" id="pop2">
				<IFRAME src="FrameEntidad.jsp?id_us=<%= strAreaUs %>&b=1&int=1&ida=<%=strIdAsunto%>&num=1" WIDTH=600 HEIGHT=300 frameborder=1 id="Entidad"></IFRAME>
			</DIV>--%>
		</TD>
		<TD colspan="3">
			<%if(strEstatus.equals("2") || strEstatus.equals("3")){%>
			<FONT face="Arial" size="2"> 
				<INPUT class="blue600a" size="80" name="asuntoEntidad" value="<%= strEntidad %>" onclick="" disabled="disabled">
			</FONT>
			<%}else{%>
			<FONT face="Arial" size="2"> 
				<INPUT class="blue600a" size="80" name="asuntoEntidad" value="<%= strEntidad %>" onclick="" onfocus="blur();"">
			</FONT>
			<%}%>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">
			<%if(strEstatus.equals("2") || strEstatus.equals("3")){%>
			<%}else{%>
			<%--<INPUT type="button" name="oEntidad" value="Otra Entidad *" class="blue100b" onclick="AbrirCatDinamic('DinamicEntidad.jsp')">
			<a href="#" onclick="AbrirCatDinamic('DinamicEntidad.jsp')" >
			<font size="1" color="blue" face="Arial" color="#004080">Otra Entidad *</font>
			</a>&nbsp;--%>
			<%}%>
		</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	
	<TR valign="top">
		<TD width="183">
			<B><FONT face="Arial" color="#004080" size="2">De:</FONT></B>
			<%if(strEstatus.equals("2") || strEstatus.equals("3")){%>
			<%}else{%>
			<INPUT name="botDe" type="button" onclick="document.Asunto.strBandera.value=true;AbrirR('FrameRemitente.jsp?id_us='+idEntidad.value+'&con='+control.value+'&ida='+id_asunto.value+'&num=1&idRemitente='+idRemitente.value)" class="s-dropdown-btn">
			<%}%>
			<%--
			<DIV class="popup" id="pop3">
				<IFRAME id="Remitente" name="Remitente" WIDTH=600 HEIGHT=300 frameborder=1></IFRAME>
			</DIV>--%>
		</TD>
		<TD colspan="3">
			<%if(strEstatus.equals("2") || strEstatus.equals("3")){%>
			<FONT face="Arial" size="2">
				<INPUT class="blue600a" size="80" name="asuntoRemitente" value="<%= strRemitente %>" disabled="disabled">
				<input name="asuntoCargo" value="<%= strCargo %>" type="hidden" disabled="disabled">
				<input name="asuntoCorreo" value="<%=strCorreo%>" type="hidden" disabled="disabled">
			</FONT>
			<%}else{%>
			<FONT face="Arial" size="2">
				<INPUT class="blue600a" size="80" name="asuntoRemitente" value="<%= strRemitente %>" onclick="" onfocus="blur();"">
				<input name="asuntoCargo" value="<%=strCargo%>" type="hidden">
				<input name="asuntoCorreo" value="<%=strCorreo%>" type="hidden">
			</FONT>
			<%}%>
		</TD>
	</TR>
	
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183">
			<FONT face="Arial" color="#004080" size="2">Firmante:</FONT>
		</TD>
		<TD colspan="3">
			<FONT face="Arial" size="2">
				<INPUT class="blue600a" name="asuntoFirmante" value="<%= strFirmante %>" maxlength="200" onkeydown="document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);">
			</FONT>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183">
			<FONT face="Arial" color="#004080" size="2"><B>Documento de:</B></FONT>
		</TD>
		<TD colspan="3">
			<font size="2" color="#004080" face="Arial">
			<%--<INPUT type="radio" value="0" name="asuntoTipoFolio" <%=(strTipoFolio.equals("0")?"checked":"")%> onchange="document.Asunto.strBandera.value=true;">Entrada&nbsp;&nbsp;&nbsp;&nbsp;
			<INPUT type="radio" value="1" name="asuntoTipoFolio" <%=(strTipoFolio.equals("1")?"checked":"")%> onchange="document.Asunto.strBandera.value=true;">Salida--%>
			<%=(strTipoFolio.equals("1")?"Salida":"Entrada")%><input name="asuntoTipoFolio" type="hidden" value="<%=strTipoFolio%>">
			</font>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<tr valign="top">
		<td width="183"><b><font size="2" color="#004080" face="Arial">Datos de Ventanilla</font></b></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="363"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
	</tr>
</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183"><B><FONT face="Arial" color="#004080" size="2">Responsable
			del<BR>
			Turno:</FONT></B>
			
			<INPUT name="botVentanilla" type="button" onclick="document.Asunto.strBandera.value=true;AbrirV('FrameVentanilla.jsp?idArea=<%=BUsuario.getIdArea()%>&ida=<%=strIdAsunto%>&num=1');" class="s-dropdown-btn">
			<!-- <INPUT type="button" onclick="document.Asunto.strBandera.value=true;AbrirIframeRep('pop4', '<%=strIdAsunto%>');" class="s-dropdown-btn"> 
			<DIV class="popup" id="pop4">
				<IFRAME src="FrameVentanilla.jsp?idArea=<%=BUsuario.getIdArea()%>&num=0" WIDTH=600 HEIGHT=300 frameborder=1></IFRAME>
			</DIV> -->
		</TD>
		<TD colspan="3">
			<FONT face="Arial" size="2">
				<BR><INPUT class="blue600a" size="80" name="asuntoDestinatario" type="text" value="<%= strDestinatario %>" onfocus="blur();">
				<input name="asuntoCargoDest" value="<%=strCargoDest%>" type="hidden">
				<input name="asuntoAreaDest" value="<%=strAreaDest%>" type="hidden">
			</FONT>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<tr valign="top">
		<td width="183"><b><font size="2" color="#004080" face="Arial">Destinatarios</font></b></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="363"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
	</tr>
</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183">
			<B><FONT face="Arial" color="#004080" size="2">Destinatarios Internos<BR>de la SHCP
			:</FONT></B>
			<%if(strIdAsunto != null && strIdAsunto.length() >0 && bexisteInst == true){%>
			<%}else{%>
			<INPUT type="button" onclick="document.Asunto.strBandera.value=true;AbrirPara('<%=strTipoFolio %>','<%=BUsuario.getIdArea()%>','<%=Utilerias.getCadenaParaCC(listaIDSPara)%>', '<%=Utilerias.getCadenaParaCC(listaIDSCC)%>', '<%=strIdsPara%>', '<%=strIdsCC%>' );" class="s-dropdown-btn">
			<%}%>
		</TD>
		<TD colspan="3">
			
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	
	<TR valign="top">
		<TD width="183">
			<B><FONT face="Arial" color="#004080" size="2">Para:</FONT></B>
		</TD>
		<TD colspan="3">
			<FONT face="Arial" size="2">
				<SELECT name="listTO" size="6" class="blue600a" multiple="multiple">
				<%for(int t=0;t<listaIDSPara.size();t++){%>
				<OPTION value="<%=listaIDSPara.elementAt(t)%>"><%=listaIDSPara.elementAt(t)%></OPTION>
				<%}%>
				</SELECT>
			</FONT>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183">
			<FONT face="Arial" color="#004080" size="2">Ccp:</FONT>
		</TD>
		<TD colspan="3">
			<FONT face="Arial" size="2">
				<SELECT name="listCC" size="6" class="blue600a" multiple="multiple">
				<%for(int t=0;t<listaIDSCC.size();t++){%>
				<OPTION value="<%=listaIDSCC.elementAt(t)%>"><%=listaIDSCC.elementAt(t)%></OPTION>
				<%}%>
				</SELECT>
			</FONT>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	
	<TR valign="top">
		<TD width="183">
			<FONT face="Arial" color="#004080" size="2">Destinatarios Externos:</FONT>
			<%if(strIdAsunto != null && strIdAsunto.length() >0 && bexisteInst == true){%>
			<%}else{%>
			<INPUT type="button" onclick="document.Asunto.strBandera.value=true;AbrirDest('<%=Utilerias.codificaPostHTML(Utilerias.getCadenaParaCC(listaIDSParaExt))%>', '<%=strIdsParaE%>', '<%= strAreaUs %>');" class="s-dropdown-btn">
			<%}%>
		</TD>
		<TD colspan="3">
			
		</TD>
	</TR> 
	<tr valign="top">
		<td width="183">
			<img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title="">
		</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	
	<TR valign="top">
		<TD width="183">
			<FONT face="Arial" color="#004080" size="2">Para:</FONT>
		</TD>
		<TD colspan="3">
			<FONT face="Arial" size="2">
				<SELECT name="listTOE" size="6" class="blue600a" multiple="multiple">
				<%for(int t=0;t<listaIDSParaExt.size();t++){%>
				<OPTION value="<%=listaIDSParaExt.elementAt(t)%>"><%=listaIDSParaExt.elementAt(t)%></OPTION>
				<%}%>
				</SELECT>
			</FONT>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
</TBODY>
</TABLE>
</DIV>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<tr valign="top">
		<td width="183"><b><font size="2" color="#004080" face="Arial">Datos del Asunto</font></b></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="363"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
	</tr>
</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183">
			<B><FONT face="Arial" color="#004080" size="2">Asunto:</FONT></B>
		</TD>
		<TD colspan="3">
			<FONT face="Arial" size="2">
				<INPUT class="blue600a" size="80" name="asunto" type="text" value="<%= strAsunto %>" maxlength="200" onkeydown="document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);">
			</FONT>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<c:choose>
	<c:when test='${BEscritura.value}'>
	<TR valign="top">
		<TD width="183">
			<B><FONT face="Arial" color="#004080" size="2">Tipo de Documento:</FONT></B>
			<br><font face="Arial" size="1" color="#004080">(Requerido solo para turnar)</font>
		</TD>
	
		<TD colspan="3">
			<% if(strIdAsunto != null && strIdAsunto.length() >0 && bexisteInst == false){ %>
			<% 
				String strComboTipDoc[][] = null;
				String strComboTipDocGral[][] = null;
				strComboTipDoc = ComboData.getTipoDoctoAreaCombo(strAreaUs);
				strComboTipDocGral = ComboData.getTipoDoctosGralesCombo();
			%>
		    <%if (!strFolioGenerado.equals("folio por asignar")){%>
			<SELECT name="asuntoTipoDocto" class="blue600a">
			<% for(int q=0;q<strComboTipDoc.length;q++){
			      if(strIdTipoDocto.equals(strComboTipDoc[q][0])){%>
			        <OPTION value="<%=strComboTipDoc[q][0]%>" <%=(strIdTipoDocto.trim().equals(strComboTipDoc[q][0])?"selected":"")%>><%=strComboTipDoc[q][1]%></OPTION>
			    <%}
			   } %>
		   <% for(int y=0;y<strComboTipDocGral.length;y++){ %>
		      <%if(strIdTipoDocto.equals(strComboTipDocGral[y][0])){ %>
				<OPTION value="<%=strComboTipDocGral[y][0]%>" <%=(strIdTipoDocto.trim().equals(strComboTipDocGral[y][0])?"selected":"")%>><%=strComboTipDocGral[y][1]%></OPTION>
				<% }
		      }%>
		      </SELECT>
			<%}else{ %>
			<SELECT name="asuntoTipoDocto" class="blue600a"  onchange="document.Asunto.strBandera.value=true;">
			
				<OPTION value="null">--Tipo de Documentos de la Unidad--</OPTION>
				<% for(int q=0;q<strComboTipDoc.length;q++){ %>
				<OPTION value="<%=strComboTipDoc[q][0]%>" <%=(strIdTipoDocto.trim().equals(strComboTipDoc[q][0])?"selected":"")%>><%=strComboTipDoc[q][1]%></OPTION>
				<% } %>
				<OPTION value="null">--Tipo de Documentos Generales--</OPTION>
				<% for(int y=0;y<strComboTipDocGral.length;y++){ %>
				<OPTION value="<%=strComboTipDocGral[y][0]%>" <%=(strIdTipoDocto.trim().equals(strComboTipDocGral[y][0])?"selected":"")%>><%=strComboTipDocGral[y][1]%></OPTION>
				<% } %>
			</SELECT>
			<%} %>
			<INPUT type="hidden" name="esRecepcion" value="1">
			<% }else if(strIdAsunto != null && strIdAsunto.length() >0 && bexisteInst == true){ %>
			<FONT face="Arial" size="2">
			<meve_combo:comboseleccion data="<%= ComboData.getTipoDoctoAreaCombo(strAreaUs) %>" size="1" name="asuntoTipoDocto" classHtml="blue600a" selected="<%= strIdTipoDocto %>" textoNoSeleccion="  " valorNoSeleccion="-1" disabled="true"/>
			</FONT>
			<INPUT type="hidden" name="esRecepcion" value="2">
			<% }else{ %>
			<% 
				String strComboTipDoc[][] = null;
				String strComboTipDocGral[][] = null;
				strComboTipDoc = ComboData.getTipoDoctoAreaCombo(strAreaUs);
				strComboTipDocGral = ComboData.getTipoDoctosGralesCombo();
			%>
			<SELECT name="asuntoTipoDocto" class="blue600a" onchange="document.Asunto.strBandera.value=true;">
				<OPTION value="null">--Tipo de Documentos de la Unidad--</OPTION>
				<% for(int q=0;q<strComboTipDoc.length;q++){ %>
				<OPTION value="<%=strComboTipDoc[q][0]%>"><%=strComboTipDoc[q][1]%></OPTION>
				<% } %>
				<OPTION value="null">--Tipo de Documentos Generales--</OPTION>
				<% for(int y=0;y<strComboTipDocGral.length;y++){ %>
				<OPTION value="<%=strComboTipDocGral[y][0]%>"><%=strComboTipDocGral[y][1]%></OPTION>
				<% } %>
			</SELECT>
			<INPUT type="hidden" name="esRecepcion" value="1">
			<% } %>
		</TD>
	</TR>
	</c:when>
	<c:otherwise>
		<tr>
		<TD>
			<INPUT type="hidden" name="asuntoTipoDocto" value="null">
			<INPUT type="hidden" name="esRecepcion" value="0">
		</TD>
	</tr>
	</c:otherwise>
	</c:choose>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	
	<tr valign="top">
		<TD width="183">
			<B><FONT face="Arial" color="#004080" size="2">Fecha de recepci&oacute;n del documento:</FONT></B>
		</TD>
		<TD colspan="3">
			<%if(strEstatus.equals("2") || strEstatus.equals("3")){%>
			<INPUT class="blue100a"  name="asuntoFechaRecepcion" value="<%= strFeFormateada1 %>" disabled="disabled">
			<B><FONT face="Arial" color="#004080" size="2">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Hora de Recepci&oacute;n:</FONT></B>
			<SELECT name="horaRecepcion" class="blue50a" disabled="disabled">
				<OPTION value="-1">--</OPTION>
				<%for(int i=0;i<24;i++){%>
				<%
				String a = String.valueOf(i);
				if(a.length()==1)
					a="0"+a;
				if(strHoraRecep.length()==1)
					strHoraRecep="0"+strHoraRecep;
				%>
				<OPTION value="<%=a%>" <%=(strHoraRecep.equals(a)?"selected":"")%>><%=a%></OPTION>
				<%}%>
			</SELECT>
			<FONT face="Verdana" size="2">:</FONT>
			<SELECT name="minRecepcion" class="blue50a" disabled="disabled">
				<OPTION value="-1">--</OPTION>
				<%for(int i=0;i<60;i++){%>
				<%
				String a = String.valueOf(i);
				if(a.length()==1)
					a="0"+a;
				if(strMinRecep.length()==1)
					strMinRecep="0"+strMinRecep;
				%>
				<OPTION value="<%=a%>" <%=(strMinRecep.equals(a)?"selected":"")%>><%=a%></OPTION>
				<%}%>
			</SELECT>
			<% }else{ %>
			<INPUT class="blue100a"  name="asuntoFechaRecepcion" value="<%= strFeFormateada1 %>" onblur="validaFormatoFecha();keyTra()" onKeyUp="validaFechaRec();" onKeyPress="AceptaSoloTeclaNumericaYDiagonal();" onkeydown="document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);">
			<A><IMG height="20" title="" src="../Imagenes/act_calFormat.gif" width="20" border="0" onclick='document.Asunto.strBandera.value=true;showCalFechaDocRec();' name="cRep"></A>
			<FONT face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT>
			<B><FONT face="Arial" color="#004080" size="2">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Hora de Recepci&oacute;n:</FONT></B>
			<SELECT name="horaRecepcion" class="blue50a" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange="document.Asunto.strBandera.value=true;">
				<OPTION value="-1">--</OPTION>
				<%for(int i=0;i<24;i++){%>
				<%
				String a = String.valueOf(i);
				if(a.length()==1)
					a="0"+a;
				if(strHoraRecep.length()==1)
					strHoraRecep="0"+strHoraRecep;
				%>
				<OPTION value="<%=a%>" <%=(strHoraRecep.equals(a)?"selected":"")%>><%=a%></OPTION>
				<%}%>
			</SELECT>
			<FONT face="Verdana" size="2">:</FONT>
			<SELECT name="minRecepcion" class="blue50a" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange="document.Asunto.strBandera.value=true;">
				<OPTION value="-1">--</OPTION>
				<%for(int i=0;i<60;i++){%>
				<%
				String a = String.valueOf(i);
				if(a.length()==1)
					a="0"+a;
				if(strMinRecep.length()==1)
					strMinRecep="0"+strMinRecep;
				%>
				<OPTION value="<%=a%>" <%=(strMinRecep.equals(a)?"selected":"")%>><%=a%></OPTION>
				<%}%>
			</SELECT>
			<%}%>
		</TD>
	</tr>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="183"><B><FONT face="Arial" color="#004080" size="2">Fecha del documento:</font></B>
		</td>
		<td colspan="3">
			<%if(strEstatus.equals("2") || strEstatus.equals("3")){%>
			<INPUT class="blue100a" name="asuntoFechaDocto" value="<%= strFechaDocto %>" disabled="disabled">
			<% }else{ %>
			<INPUT class="blue100a" name="asuntoFechaDocto" value="<%= strFechaDocto %>" maxlength="10" onblur="validaFormatoFecha();" onKeyUp="validaFechaDoc();" onKeyPress="AceptaSoloTeclaNumericaYDiagonal();" onkeydown="document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);">
			<A><IMG height="20" title="" src="../Imagenes/act_calFormat.gif" width="20" border="0" onclick="document.Asunto.strBandera.value=true;showCalFechaDoc();" name="cDoc"></A>
			<FONT face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT>
			<%}%>
		</td>
	</tr>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<TD width="183">
			<FONT face="Arial" color="#004080" size="2">Tr&aacute;mite:</FONT>
		</TD>
		<TD colspan="3">
			<SELECT name="asuntoTramite" class="blue600a" onchange="document.Asunto.strBandera.value=true;pruebaCom(this.value)">
				<OPTION value="-1">------ Selecciona un Tr&aacute;mite de la Unidad Administrativa ------</OPTION>
				<%
					String strTramite1[][] = null;
					strTramite1 =  ActualizaTramite.getComboTramite(BUsuario.getIdArea());
					for(int i=0;i<strTramite1.length;i++){
				%>
				<OPTION value="<%=strTramite1[i][0]%>" <%=(strTramite.equals(strTramite1[i][0])?"selected":"")%>><%=strTramite1[i][1]%></OPTION>
				<%}%>
				<%
					String strTramite2[][] = null;
					strTramite2 =  ActualizaTramite.getComboTramiteGral();
					for(int i=0;i<strTramite2.length;i++){					
				%>
				<OPTION value="<%=strTramite2[i][0]%>" <%=(strTramite.equals(strTramite2[i][0])?"selected":"")%>><%=strTramite2[i][1]%></OPTION>
				<%}%>
			</SELECT>
		</TD>
	</tr>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	
	
	<tr valign="top">
		<td width="183"><B><font size="2" color="#004080" face="Arial">Fecha compromiso:</font></B>
		</td>
		<td colspan="3">
			<%if(strEstatus.equals("2") || strEstatus.equals("3")){%>
			<INPUT class="blue100a"  name="asuntoFechaCad" value="<%= strFechaCaducidad %>" disabled="disabled">
			<% }else{ %>
				<%if(strTramite.length()==0 || strTramite.equals("-1")){%>
				<INPUT class="blue100a"  name="asuntoFechaCad" value="<%= strFechaCaducidad %>" maxlength="10" onblur="validaFormatoFecha();" onKeyUp="validaFechaCom();" onKeyPress="AceptaSoloTeclaNumericaYDiagonal();" onkeydown="document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);">
				<INPUT type="text" value="" name="fechaOcultoCompromiso" class="blue100" disabled="disabled" style="display:none">
				<A><IMG height="20" title="" src="../Imagenes/act_calFormat.gif" width="20" border="0" onclick="document.Asunto.strBandera.value=true;showCalFechaCom();" name="fechaCom"></A>
				<FONT face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT>
				<%}else{%>
				<INPUT class="blue100a"  name="asuntoFechaCad" value="<%= strFechaCaducidad %>" style="display:none"  maxlength="10" onblur="validaFormatoFecha();" onkeyup="validaFechaCom();" onKeyPress="AceptaSoloTeclaNumericaYDiagonal();" onkeydown="document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);">
				<INPUT type="text" value="<%= strFechaCaducidad %>" name="fechaOcultoCompromiso" class="blue100" disabled="disabled">
				<A><IMG height="20" title="" src="../Imagenes/act_calFormat.gif" width="20" border="0" onclick="document.Asunto.strBandera.value=true;showCalFechaCom();" name="fechaCom" style="display:none"></A>
				<FONT face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT>
				<%}%>
			<%}%>
		</td>
	</tr>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="183"><B><font size="2" color="#004080" face="Arial">Identificador del docto.:</font></B>
		</td>
		<td colspan="3">
			<INPUT class="blue500a" name="asuntoFolioExt" value="<%= strFolioExterno %>" maxlength="100" onkeydown="document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);">
		</td>
	</tr>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="183"><font size="2" color="#004080" face="Arial">Folio Intermedio:</font>
		
		<BR>
			<FONT color="#004080">(VDG, VOM, VSP, etc.) </FONT></td>
		<td colspan="3">
			<INPUT class="blue500a" name="asuntoFolioInt" value="<%= strFolioIntermedio %>" maxlength="100" onkeydown="document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);">
		</td>
	</tr>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183">
			<B><FONT face="Arial" color="#004080" size="2">Descripci&oacute;n:</FONT></B>
		</TD>
		<TD colspan="3">
			<TEXTAREA name="asuntoSintesis" rows="9" cols="60" class="blue600a"
			onKeyDown="document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);limitaTextArea(document.Asunto.asuntoSintesis,'Solicitud','4000');"><%= strSintesis %></TEXTAREA>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183">
			<FONT face="Arial" color="#004080" size="2">Comentarios:</FONT>
		</TD>
		<TD colspan="3">
			<TEXTAREA name="asuntoComentario" rows="9" cols="60" class="blue600a"
			onKeyDown="document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);limitaTextArea(document.Asunto.asuntoComentario,'Comentarios','4000');"><%= strComentarios %></TEXTAREA>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183">
			<FONT face="Arial" color="#004080" size="2">Palabra Clave:</FONT>
		</TD>
		<TD colspan="3">
			<FONT face="Arial" size="2">
				<INPUT class="blue600a" size="80" name="asuntoPalabraClave" value="<%= strPalabraClave %>" maxlength="200">
			</FONT>
		</TD>
    </TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183">
			<FONT face="Arial" color="#004080" size="2">Expediente:</FONT>
		</TD>
		<TD colspan="3">
			<FONT face="Arial" size="2">
				<% if(strIdAsunto != null && strIdAsunto.trim().length()>0){ %>
				<SELECT name="asuntoExpediente" class="blue600a" onchange="document.Asunto.strBandera.value=true;">
					<%
						boolean bExisteExp = false;
						String strExpedienteArea[][] = null;
						String strExpedienteGral[][] = null;
						strExpedienteArea = ComboData.getExpedienteCombo(strAreaUs);
						strExpedienteGral = ComboData.getExpedienteComboGral();
						bExisteExp = ActualizaExpediente.getExisteExpedientesPorArea(strAreaUs);
					%>
					<OPTION value="null">--Expedientes de la Unidad--</OPTION>
					<% for(int z=0;z<strExpedienteArea.length;z++){ %>
					<OPTION value="<%=strExpedienteArea[z][0]%>" <%=(strIdExpediente.trim().equals(strExpedienteArea[z][0])?"selected":"")%>><%=strExpedienteArea[z][1]%></OPTION>
					<% } %>
					
				</SELECT>
				<% }else{ %>
				<SELECT name="asuntoExpediente" class="blue600a" onchange="document.Asunto.strBandera.value=true;">
					<%
						boolean bExisteExp = false;
						String strExpedienteArea[][] = null;
						String strExpedienteGral[][] = null;
						strExpedienteArea = ComboData.getExpedienteCombo(strAreaUs);
						strExpedienteGral = ComboData.getExpedienteComboGral();
						bExisteExp = ActualizaExpediente.getExisteExpedientesPorArea(strAreaUs);
					%>
					<OPTION value="null">--Expedientes de la Unidad--</OPTION>
					<% for(int z=0;z<strExpedienteArea.length;z++){ %>
					<OPTION value="<%=strExpedienteArea[z][0]%>"><%=strExpedienteArea[z][1]%></OPTION>
					<% } %>
					
				</SELECT>
				<% } %>
			</FONT>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
</TBODY>
</TABLE>
</DIV>
<BR>
<%if (strDatosAsuntoAnt.length == 0 && strDatosAsuntoLigas.length==0){%>
<%}else{%>
<DIV align="center">
<TABLE>
	<TBODY>
		<TR>
			<TD align="center"><FONT face="Arial" color="#004080" size="2"><b>Relaciones Anexadas</b></FONT></TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE border="0">
	<TR bgcolor="#00204f">
		<TD width="438" align="center"><FONT size="1" color="#ffffff"
			face="verdana">Folio / Tipo de Relación</FONT></TD>
		<!-- <TD align="center" width="274"><FONT size="1" color="#ffffff"
			face="verdana">Tipo de Relación</FONT></TD> -->
		<TD width="200" align="center"><FONT size="1" color="#ffffff"
			face="verdana">Folio Documento</FONT></TD>
		<TD width="194" align="center"><FONT size="1" color="#ffffff"
			face="verdana">Estatus</FONT></TD>
	</TR>
	<%if(strDatosAsuntoAnt.length!=0){%>
	<%
	String strConsulta[][];
	for (int m = 0; m < strDatosAsuntoAnt.length ; m ++){
		strConsulta = ActualizaBuscar.getBusquedaAsuntosAnidados(strDatosAsuntoAnt[m][0]);
	%>
	<TR <%if(par(m)==true){%> <%}else{%>bgcolor="#f6f6f6"<%}%>>
		<TD width="438" align="left">El Asunto actual&nbsp;es&nbsp;<%=strDatosAsuntoAnt[m][1]%>&nbsp;de&nbsp; 
			<A href="AsuntoTurnado.jsp?id_asunto=<%= strConsulta[0][0] %>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>">
			<FONT size="1" color="#004080" face="Arial"> <%= strConsulta[0][1] %></FONT></A>
		</TD>
		<!-- <td width="274" align="center"><FONT size="1" color="#004080"
			face="Arial"><%=strDatosAsuntoAnt[m][1]%></FONT></td> -->
		<td width="200" align="center"><FONT size="1" color="#004080"
			face="Arial"><%=strConsulta[0][2]%></FONT></td>
		<td width="194" align="center"><FONT size="1" color="#004080"
			face="Arial">
			<% if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_EN_RECEPCION))){ %>
			Asunto En Recepci&oacute;n
		<% }else if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_POR_TURNAR))){ %>
		    Asunto Por Turnar
		<% }else if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_TURNADO))){ %>
		    Asunto En Tr&aacute;mite
		<% }else if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_TERMINADO))){ %>
		    Asunto Terminado
		<% }%>
       </FONT></td>
	</TR>
	<%}%>
	<%}%>
</TABLE>
</div>
<%}%>
<BR>

<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<TBODY>
		<tr valign="top">
			<td width="183"><b><font size="2" color="#004080" face="Arial">Datos del Evento</font></b></td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td width="863" bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</tr>
	</TBODY>
</table>
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<tr valign="top">
		  <td width="183" height="22"></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="60"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="265"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>

	<tr valign="top">
		  <td width="183">
			<FONT face="Arial" color="#004080" size="2">Fecha del evento:</FONT></td>
			<td colspan="3">
			<img src="../Imagenes/ecblank.gif" border="0" height="1" width="1" title="">
			<FONT face="Arial" size="2">
				<INPUT class="blue100a"  name="fechaEvento" value="<%=strFormateada%>" maxlength="10" onblur="validaFormatoFecha();" onKeyUp="validaFechaEve();" onKeyPress="AceptaSoloTeclaNumericaYDiagonal();"> 
			</FONT> 
			<A><IMG height="20" title="" src="../Imagenes/act_calFormat.gif" width="20" border="0" onclick='document.Asunto.strBandera.value=true;show_calendar("forms[0].fechaEvento");' name="cEvento"></A>
			<FONT face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT>
		</td>
	</tr>

	<tr valign="top">
		  <td width="183" height="22"><FONT face="Arial" color="#004080" size="2"></FONT></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>

	<tr valign="top">
		  <td width="183" height="22"><FONT face="Arial" color="#004080" size="2">Hora del Evento:</FONT></td>
		<TD colspan="3">
				<SELECT name="hora_evento" class="blue50a" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange="document.Asunto.strBandera.value=true;">
					<OPTION value="-1">--</OPTION>
					<%for(int i=0;i<24;i++){%>
					<%
					String a = String.valueOf(i);
					if(a.length()==1)
						a="0"+a;
					if(strHoraEvento.length()==1)
						strHoraEvento="0"+strHoraEvento;
					%>
					<OPTION value="<%=a%>" <%=(strHoraEvento.equals(a)?"selected":"")%>><%=a%></OPTION>
					<%}%>
				</SELECT>
				<FONT face="Verdana" size="2">:</FONT>
				<SELECT name="min_evento" class="blue50a" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange="document.Asunto.strBandera.value=true;">
					<OPTION value="-1">--</OPTION>
					<%for(int i=0;i<60;i++){%>
					<%
					String a = String.valueOf(i);
					if(a.length()==1)
						a="0"+a;
					if(strMinEvento.length()==1)
						strMinEvento="0"+strMinEvento;
					%>
					<OPTION value="<%=a%>" <%=(strMinEvento.equals(a)?"selected":"")%>><%=a%></OPTION>
					<%}%>
				</SELECT>
			</TD>
	</tr>
	<tr valign="top">
		  <td width="183" height="22"><FONT face="Arial" color="#004080" size="2"></FONT></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		  <td width="183" height="22"><FONT face="Arial" color="#004080" size="2">Lugar del evento:</FONT></td>
		<td colspan="3"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title="">
			<TEXTAREA name="lugarEvento" rows="2" cols="40" class="blue600a"
				onkeydown="document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);limitaTextArea(document.Asunto.lugarEvento,'Lugar del Evento', '4000');"><%=strLugarEvento %></TEXTAREA></td>
	</tr>
	<tr valign="top">
		  <td width="183" height="22"><FONT face="Arial" color="#004080" size="2"></FONT></td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>


	</TBODY>
</table>
</DIV>
<!-- 
	Bloque para ver los datos de turnado, solo el usuario que tenga
	el rol de turnado puede ver este bloque
-->
<c:choose>
<c:when test='${BEscritura2.value}'>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<TBODY>
		<tr valign="top">
			<td width="183"><b><font size="2" color="#004080" face="Arial">Datos
			de Turnado</font></b></td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td width="847" bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</tr>
	</TBODY>
</table>


<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<TD width="183">&nbsp;</TD>
		<TD colspan="3">
		<DIV align="right">
			<FONT face="Arial" size="2">Unidad que turna:</FONT>
		</DIV>
        </TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183"><FONT face="Arial" color="#004080" size="2">Prioridad:</FONT>
		</TD>
		<TD colspan="3">
		<INPUT type="hidden" name="asuntoDiferencia" value="1">
		<%if(strEstatus.equals("2") || strEstatus.equals("3")){%>
		<SELECT name="asuntoPrioridad" class="blue600a" disabled="disabled">
			<%
				String strPrioridadArea[][] = null;
				String strPrioridadGral[][] = null;
				strPrioridadArea = ComboData.getPrioridadAreaCombo(strAreaUs);
				strPrioridadGral = ComboData.getPrioridadAreaComboGral();
			%>
			<OPTION value="null">------ Prioridades de la Unidad ------</OPTION> 
			<% for(int x=0;x<strPrioridadArea.length;x++){ %>
			<OPTION value="<%=strPrioridadArea[x][0]%>" <%=(strIdPrioridad.trim().equals(strPrioridadArea[x][0])?"selected":"")%>><%=strPrioridadArea[x][1]%></OPTION>
			<% } %>
			<OPTION value="null">------ Prioridades Generales ------</OPTION>
			<% for(int x=0;x<strPrioridadGral.length;x++){ %>
			<OPTION value="<%=strPrioridadGral[x][0]%>" <%=(strIdPrioridad.trim().equals(strPrioridadGral[x][0])?"selected":"")%>><%=strPrioridadGral[x][1]%></OPTION>
			<% } %>
		</SELECT>
		<%}else{%>
		<FONT face="Arial" size="2">
		<SELECT name="asuntoPrioridad" class="blue600a" onchange="document.Asunto.strBandera.value=true;">
			<%
				String strPrioridadArea[][] = null;
				String strPrioridadGral[][] = null;
				strPrioridadArea = ComboData.getPrioridadAreaCombo(strAreaUs);
				strPrioridadGral = ComboData.getPrioridadAreaComboGral();
			%>
			<OPTION value="null">------ Prioridades de la Unidad Administrativa ------</OPTION> 
			<% for(int x=0;x<strPrioridadArea.length;x++){ %>
			<OPTION value="<%=strPrioridadArea[x][0]%>" <%=(strIdPrioridad.trim().equals(strPrioridadArea[x][0])?"selected":"")%>><%=strPrioridadArea[x][1]%></OPTION>
			<% } %>
			<OPTION value="null">------ Prioridades Generales ------</OPTION>
			<% for(int x=0;x<strPrioridadGral.length;x++){ %>
			<OPTION value="<%=strPrioridadGral[x][0]%>" <%=(strIdPrioridad.trim().equals(strPrioridadGral[x][0])?"selected":"")%>><%=strPrioridadGral[x][1]%></OPTION>
			<% } %>
		</SELECT>
		</FONT>
		<%}%>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183"><FONT face="Arial" color="#004080" size="2">Tipo
		de Asunto:</FONT></TD>
		<TD colspan="3">
			<%if(strEstatus.equals("2") || strEstatus.equals("3")){%>
			<FONT face="Arial" size="2">
			<SELECT name="asuntoTipoAsunto" class="blue600a" disabled="disabled">
			<%
				String strTipoAsuntoArea[][] = null;
				String strTipoAsuntoGral[][] = null;
				strTipoAsuntoArea = ComboData.getTipoAsuntoAreaCombo(strAreaUs);
				strTipoAsuntoGral = ComboData.getTipoAsuntoAreaComboGral();
			%>
			<OPTION value="null">------ Tipos de Asunto de la Unidad Administrativa ------</OPTION>
			<% for(int c=0;c<strTipoAsuntoArea.length;c++){ %>
			<OPTION value="<%=strTipoAsuntoArea[c][0]%>" <%=(strIdTipoAsunto.trim().equals(strTipoAsuntoArea[c][0])?"selected":"")%>><%=strTipoAsuntoArea[c][1]%></OPTION>
			<% } %>
			<OPTION value="null">------ Tipos de Asunto Generales ------</OPTION>
			<% for(int c=0;c<strTipoAsuntoGral.length;c++){ %>
			<OPTION value="<%=strTipoAsuntoGral[c][0]%>" <%=(strIdTipoAsunto.trim().equals(strTipoAsuntoGral[c][0])?"selected":"")%>><%=strTipoAsuntoGral[c][1]%></OPTION>
			<% } %>
			</SELECT>
			</FONT>
			<%}else{%>
			<FONT face="Arial" size="2">
			<SELECT name="asuntoTipoAsunto" class="blue600a" onchange="document.Asunto.strBandera.value=true;">
			<%
				String strTipoAsuntoArea[][] = null;
				String strTipoAsuntoGral[][] = null;
				strTipoAsuntoArea = ComboData.getTipoAsuntoAreaCombo(strAreaUs);
				strTipoAsuntoGral = ComboData.getTipoAsuntoAreaComboGral();
			%>
			<OPTION value="null">------ Tipos de Asunto de la Unidad ------</OPTION>
			<% for(int c=0;c<strTipoAsuntoArea.length;c++){ %>
			<OPTION value="<%=strTipoAsuntoArea[c][0]%>" <%=(strIdTipoAsunto.trim().equals(strTipoAsuntoArea[c][0])?"selected":"")%>><%=strTipoAsuntoArea[c][1]%></OPTION>
			<% } %>
			<OPTION value="null">------ Tipos de Asunto Generales ------</OPTION>
			<% for(int c=0;c<strTipoAsuntoGral.length;c++){ %>
			<OPTION value="<%=strTipoAsuntoGral[c][0]%>" <%=(strIdTipoAsunto.trim().equals(strTipoAsuntoGral[c][0])?"selected":"")%>><%=strTipoAsuntoGral[c][1]%></OPTION>
			<% } %>
			</SELECT>
			</FONT>
			<%}%>
			<INPUT type="hidden" name="asuntoDiferencia" value="0">
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD colspan="4">&nbsp;</TD>
	</TR>
</TBODY>
</TABLE>
</DIV>
</c:when>
<c:otherwise>
	<tr>
		<TD>
			<INPUT type="hidden" name="asuntoPrioridad" value="<%=strIdPrioridad%>">
			<INPUT type="hidden" name="asuntoTipoAsunto" value="<%=strIdTipoAsunto%>">
			<INPUT type="hidden" name="asuntoRutaAuto" value="null">
			<INPUT type="hidden" name="asuntoDiferencia" value="1">
		</TD>
	</tr>
</c:otherwise>
</c:choose>

<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="183"><B><FONT face="Arial" color="#004080"
				size="2">Documentos Anexados</FONT></B></TD>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		</TR>
		<tr valign="top">
			<td width="863" bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</tr>
		<%	
			if (strFolioGenerado.equals("folio por asignar")){
				strFolioGenerado = strIdAsunto;
			}
		%> 
		<TR valign="top">
			<TD colspan="4">
				<div>
					<% if(BUsuario.getIdUsuario().equals(strCreador1)){ %>
						<% if(strActivarCM.equals("si")){ %>
						<IFRAME ID="frame1" SRC="ImportarCMO.jsp?IdAsunto=<%=strIdAsunto%>&bo=true&fol=<%=strFolioGenerado%>&est=0" WIDTH="800" HEIGHT="250" frameborder=0></IFRAME> 
						<% }else{ %>
						<IFRAME ID="frame1" SRC="ImportarAR.jsp?IdAsunto=<%=strIdAsunto%>&bo=true&fol=<%=strFolioGenerado%>&est=0" WIDTH="800" HEIGHT="250" frameborder=0></IFRAME>
						<% } %>
					<% }else{ %>
						<% if(strActivarCM.equals("no")){ %>
						<IFRAME ID="frame1" SRC="ImportarAR.jsp?IdAsunto=<%=strIdAsunto%>&bo=true&fol=<%=strFolioGenerado%>&est=0" WIDTH="800" HEIGHT="250" frameborder=0></IFRAME>
						<% }else{ %>
						<!-- <IFRAME ID="frame1" SRC="http://linux.meve.com:7778/content/dav/meve/SIGMA/gestion/contenedor/" WIDTH="800" HEIGHT="200" frameborder=0></IFRAME>-->
						<IFRAME ID="frame1" SRC=ImportarCMO.jsp?IdAsunto=<%=strIdAsunto%>&bo=true&fol=<%=strFolioGenerado%>&est=0" WIDTH="800" HEIGHT="250" frameborder=0></IFRAME> 
						<% } %>
					<% } %>
				</div>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>

<% if(carga != null && carga.equals("1")){ %> <script
	language=JavaScript type=text/javascript>
agregar();
</script> <% } %>
<BR>
<SCRIPT language=JavaScript type=text/javascript>

horarioVent = horarioVentanilla();
if(horarioVent)
	alert("La hora actual est&aacute; fuera del rango de atención de la Unidad Administrativa");

mensaje = "<%= mensaje %>";

if (<%= bvalida %>){
	alert(mensaje);
}

if (<%= bValidaEstatus %>){
	alert("Este Asunto ha sido modificado por otro usuario y cambió su Estatus,\npor lo que la acción solicitada ser&aacute; cancelada");
	location.assign("portalPrincipal.jsp");
}

if (<%= !bValidaFechaRec %>){
	alert("La Fecha-Hora de Recepcion no puede ser mayor a la actual");
}

</SCRIPT>
</FORM>
</BODY>
</jsp:useBean>
</HTML>
