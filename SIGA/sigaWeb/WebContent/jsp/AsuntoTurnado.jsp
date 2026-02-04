<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@taglib uri="c" prefix="c"%>
<%@ taglib uri="meve_combo" prefix="meve_combo"%>
<%@taglib uri="meve_front" prefix="meve_front"%>
<jsp:useBean id="BEscritura" class="com.meve.sigma.beans.EscrituraBean" scope="page"></jsp:useBean>
<jsp:useBean id="BEscrituraAr" class="com.meve.sigma.beans.EscrituraBean" scope="page"></jsp:useBean>
<jsp:useBean id="BTurnar" class="com.meve.sigma.beans.TurnarBean" scope="page"></jsp:useBean>
<jsp:useBean id="BTurnarNew" class="com.meve.sigma.beans.TurnarNew" scope="page"></jsp:useBean>
<%@page import="gob.hacienda.cgtic.siga.asunto.AsuntoVerifica"%>
<HTML>
<HEAD>
<%@ page language="java"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,com.meve.sigma.reportes.*,com.meve.sigma.util.*,com.meve.sigma.taglib.*,java.text.SimpleDateFormat,java.util.*,com.meve.sigma.beans.search.*,com.meve.sigma.instruccion.*"%>
	
<!-- Este bloque contiene la sesion de una usuario -->
<%
	String strIdAsunto	=	"";
	String carga 		= 	"";
	strIdAsunto		=	request.getParameter("id_asunto");
	carga 	            	= 	request.getParameter("cargar");
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
<!-- Fin codigo sesion -->
<%
	String server			= 	application.getInitParameter("servername");
	String serverContentManager	=	application.getInitParameter("content");
	String strActivarPortal		=	application.getInitParameter("ActivarPortal");
	String strActivarCM 		= 	application.getInitParameter("ActivarContent");
	String strConfFolio 		= 	application.getInitParameter("genFolio");
	String strBase			=	application.getInitParameter("RutaBase");
	String strMensaje       	=	"";
	String strAccion		=	"";
	String strFechaInicio		=	"";
	String strNotificar		=	"";
	String nombre			=	"";
	String d 			=	"";
	String c 			=	"";
	String a 			=	"";
	String strAcceso 		=	"";
	String ids					=	"";
	String refs					=	"";
	String strBandera			=	"0";
	strAcceso					=	(request.getParameter("per")==null)?"0":request.getParameter("per");
	String bInst 				= 	request.getParameter("inst");
	strAccion					=	request.getParameter("accion");

	SimpleDateFormat sdf 	=	new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date f 		=	new java.util.Date();
    String strFechaCreacion =	sdf.format(f);   
    	
    SimpleDateFormat sdf1 	=	new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date f1 		=	new java.util.Date();
	String strFechaReal		=	sdf1.format(f1); 

	String strItemType	=	(application.getInitParameter("ItemType")==null)?"":application.getInitParameter("ItemType");
	String strReload  	=  	(request.getParameter("reload")==null)?"":request.getParameter("reload");
	String folioControl = 	request.getParameter("folioControl");
	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
	String retURI 		= (request.getParameter("retURI")== null)?"PortalBorrador.jsp":request.getParameter("retURI");
    String retURI2  =   (request.getParameter("retURI2")==null)?retURI:request.getParameter("retURI2");
        
	boolean bExisteInstrucciones	=	false; 
	boolean bExisteHistorial		=	false;
	boolean bEstanVacias			=	false;
	boolean bTienePasos				=	false;
	boolean bNoTiene				=	false;
	boolean puedeRecuperarUa		=   AsuntoVerifica.puedeUaRecuperar(session.getServletContext(),BUsuario.getIdArea());
	boolean bTieneArchivado			=	false;
	
	String strGetAsuntoTurnado[][]	=	null;
	String dest1[][]  				=	null;
	String strGetDatosRem[][]		=	null;
	String strEstatus[][] 			= 	null;

	
	String strDatosNewWindow[][]	=	new String[2][2];
	String strDatosAsuntoAnt[][] 	= 	new String[0][0];
	String strDatosAsuntoLigas[][] 	= 	new String[0][0];
	String strDatosDes[][] 			= 	null;
	String strDatosDesPara[][] 		= 	new String[0][0];
	String strDatosDesCC[] 		= 	new String[0];
	String strDatosDesParaE[][] 	= 	new String[0][0];
	
	String url = request.getRequestURI();
	String urlIndex = request.getScheme() +"://" + request.getServerName() + (request.getServerPort()!= 80? ":" + request.getServerPort():"")+url+"/";
    String URL = request.getScheme() +"://" + request.getServerName() + (request.getServerPort()!= 80? ":" + request.getServerPort():"")+url+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI2);
	
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

	int iFinalizado = 0;
	int iBandera = 0;
	float fAvance = 0;

	boolean accesoSolicitado = true;
	if(strIdAsunto != null && strIdAsunto.length() > 0)
	{
		strGetAsuntoTurnado		= 	ActualizaAsuntoTurnado.getAsuntoTurnado(strIdAsunto);
		bExisteInstrucciones	=	ActualizaInstrucciones.TieneInstrucciones(strIdAsunto);
		//bTieneArchivado			=	ActualizaArchivado.getTieneArchivado(strIdAsunto);
		bEstanVacias			=	ActualizaInstrucciones.getInstruccionesVacias(strIdAsunto);
		dest1					=	ActualizaUsuario.getNombreCargoAreaUsr(strGetAsuntoTurnado[0][32]);
		if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TURNADO)) || strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO))){
			strDatosDes = ActualizaAsuntoTurnado.getDatosDes(strIdAsunto);
			strDatosDesPara = ActualizaAsuntoTurnado.getDesPara(strIdAsunto);
			strDatosDesCC = ActualizaAsuntoTurnado.getDesCCReporte(strIdAsunto);
			strDatosDesParaE = ActualizaAsuntoTurnado.getDesParaE(strIdAsunto);
		}
		if(strGetAsuntoTurnado[0][34].equals("1")){
		}else{
			strGetDatosRem	=	ActualizaRemitente.getRemitentes(strGetAsuntoTurnado[0][2]);
		}
		if(!strGetAsuntoTurnado[0][6].equals("") && strGetAsuntoTurnado[0][6].length()>0 ){
			ActualizaExpArchivado.insertarExpAsunto(strIdAsunto, strGetAsuntoTurnado[0][6]);
		}
		String strUsuemRemitente = strGetAsuntoTurnado[0][2];
		if (strUsuemRemitente.equals(BUsuario.getIdUsuario()) && !BUsuario.getSupervisor() && !BUsuario.getTurnado()){
			accesoSolicitado = false;
		}
	}
	
	// Al turnar el asunto se actualiza el estatus, la fecha de inicio,
	// la fecha de fin de la instruccion y el ID del usuario que esta turnando
	if(strAccion != null && strAccion.equals("turnar") && !bValidaEstatus){
		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
		String portServer = application.getInitParameter("PortMail");
		String serverName = application.getInitParameter("servername");
		String strIdAreaOrigen = strGetAsuntoTurnado[0][33]; 
		String strPasoMax = ActualizaInstrucciones.getMaxPasos(strIdAsunto);
		
		String strFechaCaducidad = "";
		if(strGetAsuntoTurnado[0][43].length()>0){
			String strTramite[][] = ActualizaTramite.getTramite(strGetAsuntoTurnado[0][43]);
			String strDuracion = strTramite[0][5];
			Calendar cFechaInicio	=	Utilerias.StringCalendar(strGetAsuntoTurnado[0][13]);
			String strFechaFin	= Utilerias.getFechaTerminacionInst((Calendar)cFechaInicio.clone(), strTramite[0][5]);
			Calendar FI = Utilerias.StringCalendar(strGetAsuntoTurnado[0][13]);
			Calendar FF = Utilerias.StringCalendar2(strFechaFin);
			int iDuracion = Utilerias.getSinDiasFestivos(FI, FF);
			String strDuracion1 = String.valueOf(iDuracion);
			strFechaCaducidad = Utilerias.getFechaTerminacionInst((Calendar)FF.clone(), strDuracion1);
			boolean ba = ActualizaAsuntoTurnado.actualizaFechaCompromiso(strIdAsunto, strFechaCaducidad);
			//Calcula os nuevos dias para atender una instruccion
			Calendar FI1 = Utilerias.StringCalendar(strGetAsuntoTurnado[0][13]);
			Calendar FF1 = Utilerias.StringCalendar2(strFechaCaducidad);
			int iDuracion1  = Utilerias.getDuracion(FI1, FF1);
			int iDuracion2 = Utilerias.getSinDiasFestivos(FI1, FF1);
			int iSuma = iDuracion1-iDuracion2;
			String strDuracion2 = String.valueOf(iSuma);
			boolean bAct = ActualizaInstrucciones.updateTiempoInst(strIdAsunto, strDuracion2);
		}
		try{
			int iPasoMax = Integer.parseInt(strPasoMax);
			if(iPasoMax>=1){
				strPasoMax="1";
			}else{
				strPasoMax="0";
			}
		}catch(NumberFormatException n){
			strPasoMax ="0";
		}
		if(strPasoMax.equals("1")){
			BTurnar.turnarInstrucciones(request, BUsuario, serverMail, portServer, serverName, strBase, strIdAreaOrigen);
			response.sendRedirect("AsuntoTurnado.jsp?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI2));
		}else{
%>
<script type="text/javascript">
alert("La secuencia de pasos es incorrecta, favor de verificar la Ruta de Atención\n\nSe requiere al menos una instruccion con paso 1");
</script>
<%
		}
	}else if(strAccion != null && strAccion.equals("guardar") && !bValidaEstatus){
		String prioridad = request.getParameter("asuntoPrioridad");
		String tipoAsunto = request.getParameter("asuntoTipoAsunto");
		String esRecepcion = request.getParameter("esRecepcion");
 		boolean bactualiza1 = ActualizaAsuntoTurnado.actualizaPrioridad1(strIdAsunto, prioridad, tipoAsunto); 
		if(!bExisteInstrucciones){
			String strDatos[][] = ActualizaAsunto.getParaCC(strIdAsunto);
			Vector listaIdsPara = Utilerias.getNombres(strDatos[0][2]);
			Vector listaIdsCC = Utilerias.getNombres(strDatos[0][3]); 
			Vector listaDesExtids = Utilerias.getNombres(strDatos[0][6]);
			String strIdDoc = strDatos[0][4];
			String strIdPas[][] = ActualizaPaso.getSecMin(strIdDoc);
			if(strIdPas == null){
				bTienePasos = true;
			}else{
				//if(strIdPas[0][1].equals("1")){//Verifica que el primer registro tenga un paso 1
				String strFechaCaducidad = "";
				if(strGetAsuntoTurnado[0][43].length()>0){
					String strTramite[][] = ActualizaTramite.getTramite(strGetAsuntoTurnado[0][43]);
					String strDuracion = strTramite[0][5];
					Calendar cFechaInicio	=	Utilerias.StringCalendar(strGetAsuntoTurnado[0][13]);
					String strFechaFin	= Utilerias.getFechaTerminacionInst((Calendar)cFechaInicio.clone(), strTramite[0][5]);
					Calendar FI = Utilerias.StringCalendar(strGetAsuntoTurnado[0][13]);
					Calendar FF = Utilerias.StringCalendar2(strFechaFin);
					int iDuracion = Utilerias.getSinDiasFestivos(FI, FF);
					String strDuracion1 = String.valueOf(iDuracion);
					strFechaCaducidad = Utilerias.getFechaTerminacionInst((Calendar)FF.clone(), strDuracion1);
					boolean ba = ActualizaAsuntoTurnado.actualizaFechaCompromiso(strIdAsunto, strFechaCaducidad);
				}else{
					strFechaCaducidad = Utilerias.formatearFechas(strGetAsuntoTurnado[0][15]);
				}
				bNoTiene =	ActualizaInstrucciones.insertarInstruccionParaCC(listaIdsPara, listaIdsCC, 
																strIdAsunto, strIdPas[0][0],
																strDatos[0][5], 
																strFechaCaducidad,
																strGetAsuntoTurnado[0][46],
																listaDesExtids,
																strGetAsuntoTurnado[0][13]);
				String urlE= request.getScheme() +"://" + request.getServerName() + (request.getServerPort()!= 80? ":" + request.getServerPort():"");
				response.sendRedirect(urlE+"/SIGA/jsp/VisualizaInstrucciones.jsp?idAsunto="+strIdAsunto+"&Url="+URL+"&no="+bNoTiene+"&retURI="+Utilerias.codificaPostHTML(retURI));
			}
		}else{
			String urlE= request.getScheme() +"://" + request.getServerName() + (request.getServerPort()!= 80? ":" + request.getServerPort():"");
			response.sendRedirect(urlE+"/SIGA/jsp/VisualizaInstrucciones.jsp?idAsunto="+strIdAsunto+"&Url="+URL+"&retURI="+Utilerias.codificaPostHTML(retURI));
		}
		
	}else if(strAccion != null && strAccion.equals("turnar1") && !bValidaEstatus){
		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
		String portServer = application.getInitParameter("PortMail");
		String serverName = application.getInitParameter("servername");
		strIdAsunto = request.getParameter("id_asunto");
		String Avance = request.getParameter("avanceAsunto"); 
		String strIdAreaOrigen = strGetAsuntoTurnado[0][33]; 
		boolean b = BTurnarNew.turnarInstrucciones1(request, BUsuario, serverMail, 
										portServer, serverName, strIdAreaOrigen);
		if(b)
			response.sendRedirect("AsuntoTurnado.jsp?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI2));
		else
			strMensaje = "Los Tiempos de las Instrucciones han excedido la Fecha Compromiso";
	}else if(strAccion != null && strAccion.equals("finalizar") && !bValidaEstatus){
		strIdAsunto = request.getParameter("id_asunto");
		boolean bFin = ActualizaAsuntoTurnado.terminarAsunto(strIdAsunto, strFechaReal, strFechaCreacion);
		strBandera = "1";
		response.sendRedirect("AsuntoTurnado.jsp?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI));
	}else if(strAccion != null && strAccion.equals("recuperar") && !bValidaEstatus){
		strIdAsunto = request.getParameter("id_asunto");
		boolean bRecuperado = ActualizaAsuntoTurnado.recuperarAsunto(Integer.parseInt(strIdAsunto),BUsuario,session.getServletContext());
		strBandera = "1";
		if(bRecuperado){
		   response.sendRedirect("AsuntoRecepcion.jsp?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI));
		}else{
			strMensaje="Este asunto ya no puede ser recuperado";
		}
	}else if(strAccion != null && strAccion.equals("cargar") && !bValidaEstatus){
		if(!bExisteInstrucciones){
			String strDatos[][] = ActualizaAsunto.getParaCC(strIdAsunto);
			Vector listaIdsPara = Utilerias.getNombres(strDatos[0][2]);
			Vector listaIdsCC = Utilerias.getNombres(strDatos[0][3]);
			Vector listaDesExtids = Utilerias.getNombres(strDatos[0][6]);
			String strIdDoc = strDatos[0][4];
			String strIdPas[][] = ActualizaPaso.getSecMin(strIdDoc);

			if(strIdPas == null){
				bTienePasos = true;
			}else{
				String strFechaCaducidad = "";
				if(strGetAsuntoTurnado[0][43].length()>0){
					String strTramite[][] = ActualizaTramite.getTramite(strGetAsuntoTurnado[0][43]);
					String strDuracion = strTramite[0][5];
					Calendar cFechaInicio	=	Utilerias.StringCalendar(strGetAsuntoTurnado[0][13]);
					String strFechaFin	= Utilerias.getFechaTerminacionInst((Calendar)cFechaInicio.clone(), strTramite[0][5]);
					Calendar FI = Utilerias.StringCalendar(strGetAsuntoTurnado[0][13]);
					Calendar FF = Utilerias.StringCalendar2(strFechaFin);
					int iDuracion = Utilerias.getSinDiasFestivos(FI, FF);
					String strDuracion1 = String.valueOf(iDuracion);
					strFechaCaducidad = Utilerias.getFechaTerminacionInst((Calendar)FF.clone(), strDuracion1);
					boolean ba = ActualizaAsuntoTurnado.actualizaFechaCompromiso(strIdAsunto, strFechaCaducidad);
				}else{
					strFechaCaducidad = Utilerias.formatearFechas(strGetAsuntoTurnado[0][15]);
				}
				bNoTiene =	ActualizaInstrucciones.insertarInstruccionParaCC(listaIdsPara, listaIdsCC, 
															strIdAsunto, strIdPas[0][0],
															strDatos[0][5], 
															strFechaCaducidad,
															strGetAsuntoTurnado[0][46],
															listaDesExtids,
															strGetAsuntoTurnado[0][13]);
				String urlE= request.getScheme() +"://" + request.getServerName() + (request.getServerPort()!= 80? ":" + request.getServerPort():"");
				response.sendRedirect(urlE+"/SIGA/jsp/VisualizaInstrucciones.jsp?idAsunto="+strIdAsunto+"&Url="+URL+"&no="+bNoTiene+"&retURI="+Utilerias.codificaPostHTML(retURI));
			}
		}else{
			String urlE= request.getScheme() +"://" + request.getServerName() + (request.getServerPort()!= 80? ":" + request.getServerPort():"");
			response.sendRedirect(urlE+"/SIGA/jsp/VisualizaInstrucciones.jsp?idAsunto="+strIdAsunto+"&Url="+URL+"&retURI="+Utilerias.codificaPostHTML(retURI));
		}
	}
	if(bExisteInstrucciones){
		strEstatus = ActualizaInstrucciones.getEstatusInstrucciones(strIdAsunto);
		if(strEstatus.length == 0){
			if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TURNADO))){
				iFinalizado = 1;
				iBandera = 1;
			}
		}else{
			if(strEstatus[0][0].equals("4")){
				iFinalizado = 1;
			}
		}
	} 
	if(iBandera==1){
		fAvance = 99;
		if(strBandera.equals("0")){
			boolean bAvance = ActualizaAsuntoTurnado.ActualizaAvanceAsunto(strIdAsunto, "99");
		}
	}else{
		fAvance = new Float(strGetAsuntoTurnado[0][29]).floatValue();
	}
	//fAvance = new Float(strGetAsuntoTurnado[0][29]).floatValue();

	//**Ligar Asunto
	strDatosNewWindow = ActualizaAsunto.getIdsRef(strIdAsunto); 
	if(strDatosNewWindow.length > 0){
		ids = strDatosNewWindow[0][0];
		refs = strDatosNewWindow[0][1];
	}
	strDatosAsuntoAnt 	= 	ActualizaAsunto.getAsuntosAnt(strIdAsunto);
 	strDatosAsuntoLigas	=	ActualizaAsunto.getAsuntosLigados(strIdAsunto);
	//**Fin Ligar Asunto

	bExisteHistorial	=	ActualizaComentario.getExistenComentarios(strIdAsunto);	
	if(	BUsuario.getIdUsuario().equals(strGetAsuntoTurnado[0][32]) ||
		(BUsuario.getIdArea().equals(strGetAsuntoTurnado[0][33]) && BUsuario.getTurnado()) ||
		ActualizaInstrucciones.getSupervisorEsArea(strGetAsuntoTurnado[0][32], 
					BUsuario.getIdUsuario(), BUsuario.getSupervisor()))
			BEscritura.setValue(true);
		else
			BEscritura.setValue(false);

	if(BUsuario.getIdUsuario().equals(strGetAsuntoTurnado[0][32])){
			BEscrituraAr.setValue(true);
	}else{
			BEscrituraAr.setValue(false);
	}

	String[][] strRutaAcceso = ActualizaAsunto.getIdsRutaAcceso(strIdAsunto);
	boolean accJefes = Utilerias.getAccesoJefes(BUsuario.getIdUsuario(),strGetAsuntoTurnado[0][47],strGetAsuntoTurnado[0][48],strRutaAcceso);

	boolean accesoAsistente = false;
	if (BUsuario.getAsistente()){
		String strIdsJefes[][] = ActualizaUsuario.getJefesDeAsistente(BUsuario.getIdUsuario());
		if (strIdsJefes!=null && strIdsJefes.length>0){
			for (int i=0; i<strIdsJefes.length; i++){
				boolean bCadenaAsis = Utilerias.getAccesoJefes(strIdsJefes[i][0],strGetAsuntoTurnado[0][47],strGetAsuntoTurnado[0][48],strRutaAcceso);
				if (bCadenaAsis){
					accesoAsistente = true;
				}
			}
		}
	}

	//**Acceso desde instrucciones-asunto para ventanilla
	boolean bAccesoPool = false;
	if(strAcceso.equals("1"))
		bAccesoPool = ActualizaAsunto.getAccesoTurnadores(BUsuario.getIdArea(), strIdAsunto);
	boolean AccesoIns=false;
	//AccesoIns=InstruccionUtil.getAccesoInstruccion(BUsuario.getIdUsuario(),strIdAsunto);
	boolean noPuedeVerVentanillas		=   AsuntoVerifica.noPuedeUaVerVentanillas(session.getServletContext(),BUsuario.getIdArea());
	
//	System.out.println(" uno="+BUsuario.getIdArea().equals(strGetAsuntoTurnado[0][33])+" y "+BUsuario.getSupervisor());
//	System.out.println(" dos="+BUsuario.getIdUsuario().equals(strGetAsuntoTurnado[0][32]));
//	System.out.println(" tres="+ActualizaAsunto.getAccesoAsunto(strIdAsunto,BUsuario.getIdUsuario()));
	
//	System.out.println(" tresmdio="+BUsuario.getIdArea().equals(strGetAsuntoTurnado[0][33])+", y "+BUsuario.getTurnado());
//	System.out.println(" cuatro="+BUsuario.getIdUsuario().equals(strGetAsuntoTurnado[0][24]));
//	System.out.println(" cinco="+BUsuario.getIdUsuario().equals(strGetAsuntoTurnado[0][2])+",y "+strGetAsuntoTurnado[0][34].equals("1"));
//	System.out.println(" seis="+accJefes);
//	System.out.println(" siete="+accesoAsistente);
//	System.out.println(" ocho="+bAccesoPool);
//	System.out.println(" eveun="+!noPuedeVerVentanillas);
	if(     
			/////////
				(BUsuario.getIdArea().equals(strGetAsuntoTurnado[0][33]) && BUsuario.getSupervisor()) //area
						
			||
				BUsuario.getIdUsuario().equals(strGetAsuntoTurnado[0][32])  //turnó
			||			
				ActualizaAsunto.getAccesoAsunto(strIdAsunto,BUsuario.getIdUsuario()) //acceso al asunto original
			||
			///////  
				((
					(BUsuario.getIdArea().equals(strGetAsuntoTurnado[0][33]) && BUsuario.getTurnado())     //turnado
					||
					//BUsuario.getIdArea().equals(strGetAsuntoTurnado[0][26]) ||//id del usuario que capturo
					BUsuario.getIdUsuario().equals(strGetAsuntoTurnado[0][24]) //area de recepciï¿½n					
					||
						(BUsuario.getIdUsuario().equals(strGetAsuntoTurnado[0][2])   
						&& 
						strGetAsuntoTurnado[0][34].equals("1")) 
					|| 									
					accJefes //&& ActualizaAsunto.getAccesoAsunto(strIdAsunto,BUsuario.getIdUsuario())) // remitentes y acceso al asunto original
					|| 
					accesoAsistente
					|| 
					bAccesoPool							
				)
				&&	
				!noPuedeVerVentanillas// 		acceso a ventanillas por parámetro					
				)
		)
	{
	}
	else{	
%>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% 	} %>
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
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../css/link.css" />
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script type="text/javascript" src="../js/link.js"></script>
<TITLE>Asunto Turnado</TITLE>
<SCRIPT language=JavaScript type=text/javascript>

	valid = 0;
	var botonBandera = true;
	
	function Set(elemento)
	{
		elemento.style.border=" 1px solid #eeeeee "
	}
	function unSet(elemento)
	{
		elemento.style.border=" 0px solid #000000 "
	}

	function EditarAsunto(){
		location.assign('Asuntos.jsp?id_asunto=<%= strIdAsunto %>&estValidacion=<%= strEstValidacion %>&retURI=<%=Utilerias.codificaPostHTML("AsuntoTurnado.jsp?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI))%>');
	}
	function ComentarioAsunto(){
		location.assign('Comentarios.jsp?id_asunto=<%=strIdAsunto%>&estValidacion=<%=strEstValidacion%>&retURI=<%=Utilerias.codificaPostHTML("AsuntoTurnado.jsp?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI))%>');
	}
	function agregarContent(){
		location.assign('ImportarCM.jsp?Folio=<%=strGetAsuntoTurnado[0][23]%>&IdAsunto=<%=strIdAsunto%>&a=1&estValidacion=<%=strEstValidacion%>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');
	}
	function listadoContent() {
		var url = '<%= serverContentManager %>/eclient/SIGMA/Buscar.jsp?id=<%= strIdAsunto %>&bo=true&it=<%=strItemType%>';
		window.open(url)
	}
	function agregar(){
		var frameNvaRef = '<%= serverContentManager %>/eclient/SIGMA/Avance.jsp?id=<%=strIdAsunto%>&bo=true&it=<%=strItemType%>';
		document.getElementById('frame1').src  = frameNvaRef;
	}
	function exportar(){
		window.open("../AsuntoWord?id="+<%=strIdAsunto%>);
	}
	function escaner(){
		<% if(strActivarCM.equals("si")){ %>
		location.assign('sigmaCM:%20<%= serverContentManager %>/eclient/ArchivoCM%20<%=strItemType%>%20escanear%20false%20<%=strIdAsunto%>%20<%=strGetAsuntoTurnado[0][23]%>%20<%=BUsuario.getNombre()%>');
		<%}else{%>
		location.assign('sigmaCM:%20<%=server%><%=strBase%>/ArchivoCM%20<%=strItemType%>%20escanear%20true%20<%=strIdAsunto%>%20<%=strGetAsuntoTurnado[0][23]%>%20<%=BUsuario.getIdUsuario()%>');
		<%}%>
	}
	<% if(bTieneArchivado){ %>
	function archivado(){
		location.assign('ArchivadoAsunto.jsp?idAsunto=<%=strIdAsunto%>&asunto=<%=strGetAsuntoTurnado[0][5]%>&area=<%=dest1[0][2]%>&a=1');
	}
	<% }else{%>
	function archivado(){
		location.assign('ArchivadoAsunto.jsp?idAsunto=<%=strIdAsunto%>&asunto=<%=strGetAsuntoTurnado[0][5]%>&area=<%=dest1[0][2]%>');
	}
	<%}%>

	function mailNoty(){
	<% 
	String ma = null;
	%>
	<% if(strGetAsuntoTurnado[0][34].equals("1")){ %>
	<% ma =  ActualizaUsuario.getMailCargoUsuario(strGetAsuntoTurnado[0][2])[0][1];%>
	<% }else{ %>
	<% ma = strGetDatosRem[0][5];%>
	<% } %>
	fola = "<%= strGetAsuntoTurnado[0][5].replace("\"", "\'") %>";
	folb = "<%= strGetAsuntoTurnado[0][23] %>";
	asu = fola.replace("-", "_");
	foliom = folb.replace("-", "_");
	window.open("MailNoty.jsp?id_asunto="+<%=strIdAsunto%>+"&asunto="+asu+"&foliom="+foliom+"&mailsend=<%=ma%>",null,"toolbar=no,status=yes,scrollbars=yes");
	}

</SCRIPT>
<STYLE type=text/css>
BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="timer_load();"
	onKeyPress="timer_load();timer_reload();"
	onClick="timer_load();timer_reload();">
<FORM name="asuntoTurnado" action="AsuntoTurnado.jsp" method="post">
<INPUT type="hidden" value="" name="accion"> <INPUT
	type="hidden" value="<%=strIdAsunto%>" name="id_asunto"> <INPUT
	name="retURI" value="<%=retURI%>" type="hidden"> <INPUT
	name="retURI2" value="<%=retURI2%>" type="hidden"> <INPUT
	name="avanceAsunto" value="<%=fAvance%>" type="hidden"> <INPUT
	name="NombreAsu" value="<%=strGetAsuntoTurnado[0][5]%>" type="hidden">
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
<%if(bTienePasos){%>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD align="center"><FONT size="3" color="red"><B>No
			tiene Pasos Configurados</B></FONT></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<BR>
<%}%>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="863">
		<% if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_EN_RECEPCION))){ %>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Asunto En Recepci&oacute;n</font></b></div>
		<% }else if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_POR_TURNAR))){ %>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Asunto Por Turnar</font></b></div>
		<% }else if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TURNADO))){ %>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Asunto En Tr&aacute;mite</font></b></div>
		<% }else if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO))){ %>
		<div align="right"><b><font size="4" color="#00204F"
			face="Verdana">Asunto Terminado</font></b></div>
		<% }%>
		</td>
	</tr>
</table>
</DIV>
<BR />
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0" width="863">
	<TBODY>
		<TR valign="top">
			<TD width="5%"><A href="<%= retURI2 %>"
				onMouseOver="document.MyImage.src='../Imagenes/NavLeft2.gif';"
				onMouseOut="document.MyImage.src='../Imagenes/NavLeft.gif';"> <IMG
				border="0" src="../Imagenes/NavLeft.gif" title="Regresar / Cancelar"
				name="MyImage"></A></TD>
			<c:choose>
				<c:when test='${BEscritura.value}'>
					<%-- Inicio KHCH Cambio para dar Acceso a la edicion de un asunto en tramite --%>
					<%--<%if(!strGetAsuntoTurnado[0][28].equals("0") && !strGetAsuntoTurnado[0][28].equals("1") /*fAvance>=100*/){%>--%>
					<%if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO)) && fAvance >=100){%>
					<%-- Fin KHCH Cambio para dar Acceso a la edicion de un asunto en tramite --%>
					<TD></TD>
					<%}else if(accesoSolicitado){%>
					<TD width="5%"><A
						onclick="if(botonBandera){botonBandera=false; EditarAsunto();}"
						onMouseOver="document.Editar.src='../Imagenes/Editar2.gif';"
						onMouseOut="document.Editar.src='../Imagenes/Editar.gif';"> <IMG
						border="0" src="../Imagenes/Editar.gif" title="Modificar Datos"
						name="Editar"></A></TD>
					<%}%>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test='${BEscritura.value}'>
					<%if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO)) && fAvance >=100){%>
					<td></td>
					<%}else if(accesoSolicitado){%>
					<td width="5%"><a
						onclick="if(botonBandera){botonBandera=false; agregarContent();}"
						onMouseOver="document.Insertar.src='../Imagenes/Attach2.gif';"
						onMouseOut="document.Insertar.src='../Imagenes/Attach.gif';">
					<IMG border="0" src="../Imagenes/Attach.gif" title="Insertar Archivo"
						name="Insertar"></a></td>
					<%}%>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test='${BEscritura.value}'>
					<%if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO)) && fAvance >=100){%>
					<td></td>
					<%}else if(accesoSolicitado){%>
					<TD width="5%"><a
						onclick="if(botonBandera){botonBandera=false; ComentarioAsunto();}"
						onMouseOver="document.Comentario.src='../Imagenes/Comentario2.gif';"
						onMouseOut="document.Comentario.src='../Imagenes/Comentario.gif';">
					<IMG border="0" src="../Imagenes/Comentario.gif"
						title="Crear un Comentario" name="Comentario"></A></TD>
					<%}%>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test='${BEscritura.value}'>
					<TD width="5%"><A
						onclick="if(botonBandera){Imprimir1(<%=strIdAsunto%>);}"
						onMouseOver="document.Imprimir.src='../Imagenes/Imprimir2.gif';"
						onMouseOut="document.Imprimir.src='../Imagenes/Imprimir.gif';">
					<IMG border="0" src="../Imagenes/Imprimir.gif" title="Imprimir"
						name="Imprimir"></A></TD>
				</c:when>
			</c:choose>
			
			<c:choose>
				<c:when test='${BEscritura.value}'>
					<% if(strActivarPortal.equals("si")){ %>
					<%if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO)) && fAvance >=100){%>
					<td></td>
					<%}else if(accesoSolicitado && !strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_POR_TURNAR))){%>
					<TD width="5%"><A
						onclick="if(botonBandera){botonBandera=false; location.assign('NotificacionCiudadano.jsp?id_asunto=<%= strIdAsunto %>');}"
						onMouseOver="document.Editar1.src='../Imagenes/RespuestaCiudadana2.gif';"
						onMouseOut="document.Editar1.src='../Imagenes/RespuestaCiudadana.gif';">
					<IMG border="0" src="../Imagenes/RespuestaCiudadana.gif"
						title="Ver Respuesta del Ciudadano" name="Editar1"> </A></TD>
					<%}%>
					<% }else{ %>
					<TD></TD>
					<% } %>
				</c:when>
				<c:otherwise>
					<td></td>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test='${BEscritura.value}'>

					<% if(accesoSolicitado && bExisteInstrucciones && strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_POR_TURNAR))){ %>
					<TD width="5%">
					<DIV align="left"><A
						onclick="if(botonBandera){botonBandera=false; cargaApplet1();}"
						onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
						onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
					<IMG border="0" src="../Imagenes/CrearRuta.gif"
						title="Ver Ruta de Atenci&oacute;n" name="CrearRuta"></A>&nbsp;&nbsp;&nbsp;&nbsp;
					<%if(accesoSolicitado && !bEstanVacias){%> <A
						onclick="if(botonBandera){botonBandera=false; turnar();}"
						onMouseOver="document.Turnar.src='../Imagenes/Turnar2.gif';"
						onMouseOut="document.Turnar.src='../Imagenes/Turnar.gif';"><IMG
						border="0" src="../Imagenes/Turnar.gif" title="Turnar" name="Turnar"></A>
					<%}%>
					</DIV>
					</TD>
					<% }else if(accesoSolicitado && strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TURNADO))){ %>
					<!-- aplica lo del nuevo turnado -->
					<TD width="5%">
					<DIV align="left"><A
						onclick="if(botonBandera){botonBandera=false; cargaApplet1();}"
						onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
						onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
					<IMG border="0" src="../Imagenes/CrearRuta.gif"
						title="Ver Ruta de Atenci&oacute;n" name="CrearRuta"></A>&nbsp;&nbsp;&nbsp;&nbsp;
					<% if(accesoSolicitado && ActualizaAsuntoTurnado.existenInstruccionesNuevasSinTurnar(strIdAsunto)){ %>
					<A onclick="if(botonBandera){botonBandera=false; turnarNuevo();}"
						onMouseOver="document.Turnar.src='../Imagenes/Turnar2.gif';"
						onMouseOut="document.Turnar.src='../Imagenes/Turnar.gif';"><IMG
						border="0" src="../Imagenes/Turnar.gif" title="Turnar" name="Turnar"></A>
					<% } %>
					</DIV>
					</TD>
					<% }else if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO)) && fAvance >=100){ %>
					<TD></TD>
					<% }else if(accesoSolicitado && strGetAsuntoTurnado[0][22].length() != 0 && strGetAsuntoTurnado[0][27].length() == 0){ %>
					<TD width="5%">
					<DIV align="left"><A
						onclick="if(botonBandera){botonBandera=false; cargaAppletTur();}"
						onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
						onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
					<IMG border="0" src="../Imagenes/CrearRuta.gif" title="Crear Ruta"
						name="CrearRuta"></A></DIV>
					</TD>
					<% }else if(accesoSolicitado && strGetAsuntoTurnado[0][27].length() != 0 && strGetAsuntoTurnado[0][22].length() == 0){ %>
					<TD width="5%">
					<DIV align="left"><A
						onclick="if(botonBandera){botonBandera=false; cargaAppletTur();}"
						onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
						onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
					<IMG border="0" src="../Imagenes/CrearRuta.gif" title="Crear Ruta"
						name="CrearRuta"></A></DIV>
					</TD>
					<% }else if(accesoSolicitado && strGetAsuntoTurnado[0][27].length() == 0 && strGetAsuntoTurnado[0][22].length() == 0){ %>
					<TD width="5%">
					<DIV align="left"><A
						onclick="if(botonBandera){botonBandera=false; cargaAppletTur();}"
						onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
						onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
					<IMG border="0" src="../Imagenes/CrearRuta.gif" title="Crear Ruta"
						name="CrearRuta"></A></DIV>
					</TD>
					<% }else if(accesoSolicitado) { %>
					<TD width="5%">
					<DIV align="left"><A
						onclick="if(botonBandera){botonBandera=false; cargaApplet2();}"
						onMouseOver="document.CrearRuta.src='../Imagenes/CrearRuta2.gif';"
						onMouseOut="document.CrearRuta.src='../Imagenes/CrearRuta.gif';">
					<IMG border="0" src="../Imagenes/CrearRuta.gif" title="Crear Ruta"
						name="CrearRuta"></A></DIV>
					</TD>
					<% } %>
				</c:when>
			</c:choose>
			<%if(puedeRecuperarUa&&(AsuntoVerifica.esRecuperable(Integer.parseInt(strIdAsunto))&&strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TURNADO)))){%>
			<c:choose>
				<c:when test='${BEscritura.value}'>
					<TD width="5%"><A onclick="if(botonBandera){botonBandera=false; recuperarAsunto();}"
						onMouseOver="document.recuperar.src='../Imagenes/recuperarOn.gif';"
						onMouseOut="document.recuperar.src='../Imagenes/recuperarOff.gif';">
					<IMG border="0" src="../Imagenes/recuperarOff.gif" title="Recuperar Asunto"
						name="recuperar"></A></TD>
				</c:when>
			</c:choose>
			<%} %>
			<c:choose>
				<c:when test='${BEscritura.value}'>
					<%if(fAvance >= 100 && strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO))){%>
					<td width="5%">
					<%if(strGetAsuntoTurnado[0][44].equals("0")){%> <%}%>
					</td>
					<%}else if(	accesoSolicitado && fAvance == 99 && iFinalizado == 1 && (bEstanVacias ||
								!ActualizaAsuntoTurnado.existenInstruccionesNuevasSinTurnar(strIdAsunto))){%>
					<TD width="5%"><A
						onclick="if(botonBandera){botonBandera=false; finalizar();}"
						onMouseOver="document.Responder.src='../Imagenes/RegresarD.png';"
						onMouseOut="document.Responder.src='../Imagenes/Regresar.png';">
					<IMG border="0" src="../Imagenes/Regresar.png"
						title="Terminar Asunto" name="Responder"></A></TD>
					<%}%>
				</c:when>
				<c:otherwise>
					<td width="5%">&nbsp;</td>
				</c:otherwise>
			</c:choose>
			<TD width="35%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<br>
<% if(bExisteInstrucciones && strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_POR_TURNAR))){ %>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR>
			<c:choose>
				<c:when test='${BEscritura.value}'>
					<TD width="183"><FONT face="Arial" color="#004080" size="2">
					<INPUT name="CHNotificar" type="checkbox"  value="0"
						onclick="activarNotificarA()">Notificar a: </FONT></TD>
					<TD width="533"><meve_combo:comboseleccion
						data="<%= ComboData.getUsuarioCombo(BUsuario.getIdArea()) %>"
						size="1" name="usuarioNombre" classHtml="blue500a"
						selected="<%= strNotificar %>" disabled="true"
						textoNoSeleccion="------ Seleccione un Puesto ------"
						valorNoSeleccion="-1"
						script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'" />
					</TD>
					<td width="67">&nbsp;</td>
					<td width="80">&nbsp;</td>
				</c:when>
				<c:otherwise>
					<td width="183">&nbsp;</td>
					<td width="233">&nbsp;</td>
					<td width="67">&nbsp;</td>
					<td width="380">&nbsp;</td>
				</c:otherwise>
			</c:choose>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<% } %><BR>
<% if(strMensaje.length()!=0){%>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR>
			<TD><font size="2" color="red" face="Arial"> <%=strMensaje%>
			</font></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<% } %>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<td width="183"><b><font size="2" color="#004080"
				face="Arial">Datos Generales</font></b></td>
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
	</TBODY>
</TABLE>
</DIV>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="183"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></TD>
			<TD width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></TD>
			<TD width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></TD>
			<TD width="380">
			<DIV align="right">Capturado por: <%= ActualizaUsuario.NombreUsuario(strGetAsuntoTurnado[0][24]) %>
			- <%= Utilerias.formatearFechas(strGetAsuntoTurnado[0][25]) %><BR>
			Estatus: <% if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO))){ %><B>Terminado</B>
			<% }else if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TURNADO))){ %><B>Turnado</B> <% }else if(strGetAsuntoTurnado[0][28].equals("1")){ %><B>Por
			Turnar</B> <% }else if(strGetAsuntoTurnado[0][28].equals("0")){ %><B>Recepci&oacute;n</B>
			<% } %> <BR>
			Folio de Identificador: <B><%= strGetAsuntoTurnado[0][23] %></B><BR>
			Folio de Control: <B><%=strGetAsuntoTurnado[0][45]%></B></DIV>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="183"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></TD>
			<TD width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></TD>
			<TD width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></TD>
			<TD width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<DIV class=documentBody id=Body>
<DIV align="center">

<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>

		<TR valign="top">
			<TD><B><font size="2" color="#004080" face="Arial">Datos
			del Remitente</font></B></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>

		<TR valign="top">
			<TD width="183"><FONT face="Arial" color="#004080" size="2">Entidad:</FONT>
			</TD>
			<%if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){%>
			<TD width="660" colspan="3">
			<% if(strGetAsuntoTurnado[0][0].length() == 0){ %> <FONT face="Arial"
				size="2"> <%= strGetAsuntoTurnado[0][1] %> </FONT> <% }else if(strGetAsuntoTurnado[0][34].equals("1")){ %>
			<FONT face="Arial" size="2"> <%= ActualizaArea.NombreArea(strGetAsuntoTurnado[0][0]) %>
			</FONT> <% }else{ %> <FONT face="Arial" size="2"> <%=ActualizaEntidad.getNombreEntidad(strGetAsuntoTurnado[0][0])%>
			</FONT> <% } %>
			</TD>
			<%}else{%>
			<TD width="660" colspan="3">
			<%if(strDatosDes.length!=0){%> <FONT face="Arial" size="2"><%= strDatosDes[0][1] %></FONT>
			<%}else{%> <% if(strGetAsuntoTurnado[0][0].length() == 0){ %> <FONT
				face="Arial" size="2"> <%= strGetAsuntoTurnado[0][1] %> </FONT> <% }else if(strGetAsuntoTurnado[0][34].equals("1")){ %>
			<FONT face="Arial" size="2"> <%= ActualizaArea.NombreArea(strGetAsuntoTurnado[0][0]) %>
			</FONT> <% }else{ %> <FONT face="Arial" size="2"> <%=ActualizaEntidad.getNombreEntidad(strGetAsuntoTurnado[0][0])%>
			</FONT> <% } %> <%}%>
			</TD>
			<%}%>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="183"><FONT face="Arial" color="#004080" size="2">De:</FONT>
			</TD>
			<%if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){%>
			<TD width="660" colspan="3">
			<% if(strGetAsuntoTurnado[0][34].equals("1")){ %> <FONT face="Arial"
				size="2"> <%= ActualizaUsuario.getMailCargoUsuario(strGetAsuntoTurnado[0][2])[0][0] %>
			/ <%= ActualizaUsuario.NombrePuesto(strGetAsuntoTurnado[0][2]) %> </FONT> <% }else{ %>
			<FONT face="Arial" size="2"> <%=strGetDatosRem[0][2]%> / <%=strGetDatosRem[0][0]%>
			</FONT> <% } %>
			</TD>
			<%}else{%>
			<TD width="660" colspan="3">
			<%if(strDatosDes.length!=0){%> <FONT face="Arial" size="2"><%= strDatosDes[0][3] %>
			/ <%= strDatosDes[0][2] %></FONT> <%}else{%> <% if(strGetAsuntoTurnado[0][34].equals("1")){ %>
			<FONT face="Arial" size="2"> <%= ActualizaUsuario.getMailCargoUsuario(strGetAsuntoTurnado[0][2])[0][0] %>
			/ <%= ActualizaUsuario.NombrePuesto(strGetAsuntoTurnado[0][2]) %> </FONT> <% }else{ %>
			<FONT face="Arial" size="2"><%=strGetDatosRem[0][2]%> / <%=strGetDatosRem[0][0]%>
			</FONT> <% } %> <%}%>
			</TD>
			<%}%>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
		</TR>
		
		<TR valign="top">
			<TD width="183"><FONT face="Arial" color="#004080" size="2">
			Firmante: </FONT></TD>
			<TD width="660" colspan="3"><FONT face="Arial" size="2">
			<%= strGetAsuntoTurnado[0][4] %> </FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="183"><FONT face="Arial" color="#004080" size="2">
			Documento de: </FONT></TD>
			<TD width="660" colspan="3"><FONT face="Arial" size="2">
			<%if(strGetAsuntoTurnado[0][46].equals("0")){%> Entrada <%}else{%> Salida
			<%}%> </FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>

		<TR valign="top">
			<TD><B><font size="2" color="#004080" face="Arial">Datos
			de Ventanilla</font></B></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>

		<TR valign="top">
			<TD width="183"><FONT face="Arial" color="#004080" size="2">Responsable
			del Turno: </FONT></TD>
			<%if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){%>
			<TD width="660" colspan="3">
			<% 
					if(strGetAsuntoTurnado[0][32].length() == 0){ %> <FONT face="Arial"
				size="2"> </FONT> <% }else{ %> <FONT face="Arial" size="2"> <%
						String dest[][] = ActualizaUsuario.getNombreCargoAreaUsr(strGetAsuntoTurnado[0][32]); 
						d = dest[0][0];
						c = dest[0][1];
						a = dest[0][2];
					%> <%= d %> </FONT> <% } %>
			</TD>
			<%}else{%>
			<TD width="660" colspan="3">
			<%if(strDatosDes.length!=0){%> <FONT face="Arial" size="2"><%=strDatosDes[0][6]%></FONT>
			<%}else{%> <% 
					if(strGetAsuntoTurnado[0][32].length() == 0){ %> <FONT face="Arial"
				size="2"> </FONT> <% }else{ %> <FONT face="Arial" size="2"> <%
						String dest[][] = ActualizaUsuario.getNombreCargoAreaUsr(strGetAsuntoTurnado[0][32]); 
						d = dest[0][0];
						c = dest[0][1];
						a = dest[0][2];
					%> <%= d %> </FONT> <% } %> <%}%>
			</TD>
			<%}%>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD><B><font size="2" color="#004080" face="Arial">Destinatarios</font></B></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD><font size="2" color="#004080" face="Arial">Receptor&nbsp;Interno<BR>
			de la SHCP</font></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>

		<TR valign="top">
			<TD width="183"><FONT face="Arial" color="#004080" size="2">Para:</FONT>
			</TD>
			<TD width="660" colspan="3"><FONT face="Arial" size="1">
			<%if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){%>
			<%Vector vPara = Utilerias.getNombrePuesto(strGetAsuntoTurnado[0][47],0);
				for(int i=0;i<vPara.size();i++){ %> <%=Utilerias.recortaString((String)vPara.elementAt(i), 100)%><br>
			<%}%> <%}else{%> <%if(strDatosDesPara.length!=0){%> <%for(int i=0;i<strDatosDesPara.length;i++){ %>
			<%=Utilerias.recortaString(strDatosDesPara[i][0], 100)%><br>
			<%}%> <%}else{%> <%Vector vPara = Utilerias.getNombrePuesto(strGetAsuntoTurnado[0][47],0);
					for(int i=0;i<vPara.size();i++){ %> <%=Utilerias.recortaString((String)vPara.elementAt(i), 100)%><br>
			<%}%> <%}%> <%}%> </FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="183"><FONT face="Arial" color="#004080" size="2">Ccp:</FONT>
			</TD>
			<TD width="660" colspan="3"><FONT face="Arial" size="1">
			<%if(!(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TURNADO)) || strGetAsuntoTurnado[0][28].equals(Integer.valueOf(Estatus.ASU_TERMINADO)))){%>
			<%Vector vCC = Utilerias.getNombrePuesto(strGetAsuntoTurnado[0][48],0);
				for(int i=0;i<vCC.size();i++){ %> 
				   <%=Utilerias.recortaString((String)vCC.elementAt(i), 100)%><br>
			    <%}%> 
			<%}else{%> 
			   <%if(strDatosDesCC.length!=0){%> 
			        <%for(int i=1;i<strDatosDesCC.length;i++){ %>
			           <%=Utilerias.recortaString((String)strDatosDesCC[i], 100)%><br>
			         <%}%> 
			    <%}else{%> 
			       <%Vector vCC = Utilerias.getNombrePuesto(strGetAsuntoTurnado[0][48],0);
					for(int i=0;i<vCC.size();i++){ %> 
					   <%=Utilerias.recortaString((String)vCC.elementAt(i), 100)%><br>
			        <%}%> 
			    <%}%> 
			 <%}%> </FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD><font size="2" color="#004080" face="Arial">Receptor&nbsp;Externos</font></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="183"><FONT face="Arial" color="#004080" size="2">Para:</FONT></TD>
			<TD width="660" colspan="3"><FONT face="Arial" size="1">
			<%if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){%>
			<%Vector vPEx = Utilerias.getRemitenteEntidad(strGetAsuntoTurnado[0][49],1);
					for(int i=0;i<vPEx.size();i++){ %> <%=Utilerias.recortaString((String)vPEx.elementAt(i), 100)%><br>
			<%}%> <%}else{%> <%if(strDatosDesParaE.length!=0){%> <%for(int i=0;i<strDatosDesParaE.length;i++){ %>
			<%=Utilerias.recortaString(strDatosDesParaE[i][0], 100)%><br>
			<%}%> <%}else{%> <%Vector vPEx = Utilerias.getRemitenteEntidad(strGetAsuntoTurnado[0][49],1);
						for(int i=0;i<vPEx.size();i++){ %> <%=Utilerias.recortaString((String)vPEx.elementAt(i), 100)%><br>
			<%}%> <%}%> <%}%> </FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>

		<TR valign="top">
			<TD><B><font size="2" color="#004080" face="Arial">Datos
			del Asunto</font></B></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>

		<TR valign="top">
			<TD width="183"><FONT face="Arial" color="#004080" size="2">Asunto:</FONT>
			</TD>
			<TD width="660" colspan="3"><FONT face="Arial" size="2"><%= strGetAsuntoTurnado[0][5] %></FONT>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="183"><FONT face="Arial" color="#004080" size="2">Tipo
			de Documento:</FONT></TD>
			<%if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){%>
			<TD width="660" colspan="3"><FONT face="Arial" size="2">
			<%= ActualizaTipo_Doc.getNombreTipoDocto(strGetAsuntoTurnado[0][30]) %>
			<INPUT type="hidden" name="esRecepcion" value="2"></FONT></TD>
			<%}else{%>
			<TD width="660" colspan="3">
			<%if(strDatosDes.length!=0){%> <FONT face="Arial" size="2"><%=strDatosDes[0][9]%></FONT>
			<INPUT type="hidden" name="esRecepcion" value="2"> <%}else{%> <FONT
				face="Arial" size="2"> <%= ActualizaTipo_Doc.getNombreTipoDocto(strGetAsuntoTurnado[0][30]) %>
			<INPUT type="hidden" name="esRecepcion" value="2"></FONT> <%}%>
			</TD>
			<%}%>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>

		<tr valign="top">
			<TD width="183"><FONT face="Arial" color="#004080" size="2">Fecha
			de recepci&oacute;n del documento:</FONT></TD>
			<TD width="233"><FONT face="Arial" size="2"> <% if(strGetAsuntoTurnado[0][13].length() >0){ %>
			<%=Utilerias.formatearFechas(strGetAsuntoTurnado[0][13])%> <% }else{ %>&nbsp;<% } %>
			</FONT></TD>
			<td width="107"><font size="2" color="#004080" face="Arial">Hora
			de Recepci&oacute;n:</font></td>
			<TD width="249"><FONT face="Arial" size="2"> <%= (strGetAsuntoTurnado[0][50].length()==1)?"0"+strGetAsuntoTurnado[0][50]:strGetAsuntoTurnado[0][50] %>:<%= (strGetAsuntoTurnado[0][51].length()==1)?"0"+strGetAsuntoTurnado[0][51]:strGetAsuntoTurnado[0][51] %>
		</tr>
		<tr valign="top">
			<td width="183">&nbsp;</td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="289"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td width="183"><FONT face="Arial" color="#004080" size="2">Fecha
			del documento:</font></td>
			<TD><FONT face="Arial" size="2"> <% if(strGetAsuntoTurnado[0][14].length() >0){ %>
			<%=Utilerias.formatearFechas(strGetAsuntoTurnado[0][14])%> <% }else{ %>
			&nbsp; <% } %> </FONT></TD>
		</tr>
		<tr valign="top">
			<td width="183">&nbsp;</td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="289"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>

		<TR valign="top">
			<TD width="183"><FONT face="Arial" color="#004080" size="2">Tr&aacute;mite:</FONT></TD>
			<%if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){%>
			<TD width="660" colspan="3"><FONT face="Arial" size="2">
			<%if(strGetAsuntoTurnado[0][43].length()>0){%> <%= ActualizaTramite.getNombreTramite(strGetAsuntoTurnado[0][43]) %>
			<%}else{%> No tiene Tr&aacute;mite <%}%> </FONT></TD>
			<%}else{%>
			<TD width="660" colspan="3">
			<%if(strDatosDes.length!=0){%> <FONT face="Arial" size="2"><%=strDatosDes[0][11]%></FONT>
			<%}else{%> <FONT face="Arial" size="2"> <%if(strGetAsuntoTurnado[0][43].length()>0){%>
			<%= ActualizaTramite.getNombreTramite(strGetAsuntoTurnado[0][43]) %>
			<%}else{%> No tiene Tr&aacute;mite <%}%> </FONT> <%}%>
			</TD>
			<%}%>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>

		<tr valign="top">
			<td width="183"><font size="2" color="#004080" face="Arial">Fecha
			compromiso:</font></td>
			<TD><FONT face="Arial" size="2"> <% if(strGetAsuntoTurnado[0][15].length() >0){ %>
			<%=Utilerias.formatearFechas(strGetAsuntoTurnado[0][15])%> <% }else{ %>
			&nbsp; <% } %> </FONT></TD>
		</tr>
		<tr valign="top">
			<td width="183">&nbsp;</td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="289"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td width="183"><font size="2" color="#004080" face="Arial">Identificador
			del documento:</font></td>
			<TD width="250"><FONT face="Arial" size="2"><%= strGetAsuntoTurnado[0][16] %></FONT></TD>
		</tr>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>
		<tr valign="top">
			<td width="183"><font size="2" color="#004080" face="Arial">Folio
			Intermedio:<BR>
			(VDG, VOM, VSP, etc.)</font></td>
			<TD width="250"><FONT face="Arial" size="2"><%= strGetAsuntoTurnado[0][17] %></FONT></TD>
		</tr>


		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="183"><FONT face="Arial" color="#004080" size="2">Descripci&oacute;n:</FONT></TD>
			<TD width="660" colspan="3"><FONT face="Arial" size="2"><%= Utilerias.cambioSaltosDeLinea(strGetAsuntoTurnado[0][18]) %></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="183"><FONT face="Arial" color="#004080" size="2">Comentarios:</FONT></TD>
			<TD width="660" colspan="3"><FONT face="Arial" size="2"><%= Utilerias.cambioSaltosDeLinea(strGetAsuntoTurnado[0][19]) %></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="183"><FONT face="Arial" color="#004080" size="2">Palabra
			Clave:</FONT></TD>
			<TD width="660" colspan="3"><FONT face="Arial" size="2"><%= strGetAsuntoTurnado[0][20] %></FONT>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD><B><font size="2" color="#004080" face="Arial">Expediente</font></B></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
			<TD><img src="../Imagenes/ecblank.gif" border="0" height="1"
				width="1" title=""></TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
		<TR valign="top">
			<TD colspan="4"><IFRAME
				src="ExpedienteInstrccion.jsp?strIdAsunto=<%=strIdAsunto%>"
				WIDTH=800 HEIGHT=100 frameborder=0 id="Entidad"></IFRAME></TD>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD width="289">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<BR>
<%if (strDatosAsuntoAnt.length == 0 && strDatosAsuntoLigas.length==0){%> <%}else{%>
<DIV align="center">
<TABLE>
	<TBODY>
		<TR>
			<TD align="center"><FONT face="Arial" color="#004080" size="2"><b>Relaciones
			Anexadas</b></FONT></TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE border="0">
	<TR bgcolor="#00204f">
		<TD width="438" align="center"><FONT size="1" color="#ffffff"
			face="verdana">Folio / Tipo de Relaci&oacute;n</FONT></TD>
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
	<TR <%if(par(m)==true){%> <%}else{%> bgcolor="#f6f6f6" <%}%>>
		<TD width="438" align="left"><%= strGetAsuntoTurnado[0][23] %>&nbsp;es&nbsp;<%=strDatosAsuntoAnt[m][1]%>&nbsp;de&nbsp;
		<A
			href="AsuntoTurnado.jsp?id_asunto=<%= strConsulta[0][0] %>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>">
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
	<%if(strDatosAsuntoLigas.length!=0){%>
	<%
	String strConsulta[][];
	for (int m = 0; m < strDatosAsuntoLigas.length ; m ++){
		strConsulta = ActualizaBuscar.getBusquedaAsuntosAnidadosLigado(strDatosAsuntoLigas[m][0]);
	%>
	<TR <%if(par(m)==true){%> <%}else{%> bgcolor="#f6f6f6" <%}%>>
		<TD width="438" align="left">
		<%if(!strConsulta[0][1].equals("folio por asignar")){%> <A
			href="AsuntoTurnado.jsp?id_asunto=<%= strConsulta[0][0] %>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>">
		<FONT size="1" color="#004080" face="Arial"> <%= strConsulta[0][1] %></FONT>
		</A>
		<%}else{%> <A
			href="AsuntoRecepcion.jsp?id_asunto=<%= strConsulta[0][0] %>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>">
		<FONT size="1" color="#004080" face="Arial"> <%= strConsulta[0][1] %></FONT></A>
		<%}%> &nbsp;es&nbsp;<%=strDatosAsuntoLigas[m][1]%>&nbsp;de&nbsp;<%= strGetAsuntoTurnado[0][23] %>
		</TD>
		<!-- <td width="274" align="center"><FONT size="1" color="#004080"
			face="Arial"><%=strDatosAsuntoLigas[m][1]%></FONT></td> -->
		<td width="200" align="center"><FONT size="1" color="#004080"
			face="Arial"><%=strConsulta[0][2]%></FONT></td>
		<td width="194" align="center"><FONT size="1" color="#004080"
			face="Arial"><%=strConsulta[0][3]%></FONT></td>
	</TR>
	<%}%>
	<%}%>
</TABLE>
</div>
<%}%> <BR>


<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<TBODY>
		<tr valign="top">
			<td width="183"><b><font size="2" color="#004080"
				face="Arial">Datos del Evento</font></b></td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="368"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td bgcolor="#004080" colspan="4"><img
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
			<td width="370"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td width="183" height="22"><FONT face="Arial" color="#004080"
				size="2">Fecha del evento:</FONT></td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""><FONT face="Arial" size="2"><%=Utilerias.formatearFechas(strGetAsuntoTurnado[0][38]) %></FONT>
			</td>
			<td width="60"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="370"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>

		<tr valign="top">
			<td width="183" height="22"><FONT face="Arial" color="#004080"
				size="2"></FONT></td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="60"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="370"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>

		<tr valign="top">
			<td width="183" height="22"><FONT face="Arial" color="#004080"
				size="2">Hora del evento:</FONT></td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""><FONT face="Arial" size="2">
			<%if (strGetAsuntoTurnado[0][40].length() == 0 && strGetAsuntoTurnado[0][41].length() == 0){%>
			-- : -- <%}else{%> <%=strGetAsuntoTurnado[0][40] %>:<%="0".equals(strGetAsuntoTurnado[0][41])?"00":strGetAsuntoTurnado[0][41] %>
			<%}%> </FONT></td>
			<td width="60"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="370"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>

		<tr valign="top">
			<td width="183" height="22"><FONT face="Arial" color="#004080"
				size="2"></FONT></td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="60"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="370"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td width="183" height="22"><FONT face="Arial" color="#004080"
				size="2">Lugar del evento:</FONT></td>
			<td width="660" colspan="3"><img src="../Imagenes/ecblank.gif"
				border="0" height="1" width="1" title=""> <%=Utilerias.cambioSaltosDeLinea(strGetAsuntoTurnado[0][39]) %></td>
		</tr>
		<tr valign="top">
			<td width="183" height="22"><FONT face="Arial" color="#004080"
				size="2"></FONT></td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="60"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="370"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
	</TBODY>
</table>
</DIV>
<DIV align="center">
<TABLE border="0" cellpadding="0" cellspacing="0">
	<TBODY>
		<TR valign="top">
			<TD width="183"><B><FONT color="#004080" face="Arial"
				size="2">Datos del Turnado</FONT></B></TD>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="366"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</TR>
		<tr valign="top">
			<td bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</tr>
	</TBODY>
</TABLE>
</DIV>
<DIV align="center">
<TABLE border="0" cellpadding="0" cellspacing="0">
	<TBODY>
		<TR valign="top">
			<td width="183"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<TD width="360">
			<DIV align="right"><FONT face="Arial" size="2"><BR>
			</FONT> <FONT color="#004080" face="Arial" size="2"> </FONT><FONT
				face="Arial" size="2"><B></B></FONT></DIV>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="183"><FONT color="#004080" face="Arial" size="2">Prioridad:</FONT>
			</TD>
			<% if(strGetAsuntoTurnado[0][22].length() != 0){ %>
			<%if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){%>
			<TD width="660" colspan="3"><FONT face="Arial" size="2"><%=ActualizaPrioridad.getNombrePrioridad(strGetAsuntoTurnado[0][22])%></FONT>
			<INPUT name="asuPri_1" type="hidden" value="0"> <INPUT
				name="asuntoPrioridad" type="hidden"
				value="<%=strGetAsuntoTurnado[0][22]%>"></TD>
			<%}else{%>
			<TD width="660" colspan="3">
			<%if(strDatosDes.length!=0){%> <FONT face="Arial" size="2"><%=strDatosDes[0][13]%></FONT>
			<%}else{%> <FONT face="Arial" size="2"><%=ActualizaPrioridad.getNombrePrioridad(strGetAsuntoTurnado[0][22])%></FONT>
			<%}%> <INPUT name="asuntoPrioridad" type="hidden"
				value="<%=strGetAsuntoTurnado[0][22]%>"> <INPUT
				name="asuPri_1" type="hidden" value="0"></TD>
			<%}%>
			<% }else{ %>
			<TD colspan="3"><SELECT name="asuntoPrioridad" class="blue500a">
				<%
						String strPrioridadArea[][] = null;
						String strPrioridadGral[][] = null;
						strPrioridadArea = ComboData.getPrioridadAreaCombo(BUsuario.getIdArea());
						strPrioridadGral = ComboData.getPrioridadAreaComboGral();
					%>
				<OPTION value="-1">--Prioridades de la Unidad--</OPTION>
				<% for(int x=0;x<strPrioridadArea.length;x++){ %>
				<OPTION value="<%=strPrioridadArea[x][0]%>"><%=strPrioridadArea[x][1]%></OPTION>
				<% } %>
				<OPTION value="-1">--Prioridades Generales--</OPTION>
				<% for(int x=0;x<strPrioridadGral.length;x++){ %>
				<OPTION value="<%=strPrioridadGral[x][0]%>"><%=strPrioridadGral[x][1]%></OPTION>
				<% } %>
			</SELECT> <INPUT name="asuPri_1" type="hidden" value="1"></TD>
			<% } %>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="183"><FONT color="#004080" face="Arial" size="2">Tipo
			de Asunto:</FONT></TD>
			<% if(strGetAsuntoTurnado[0][27].length() != 0){ %>
			<%if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){%>
			<TD width="660" colspan="3"><FONT face="Arial" size="2"><%=ActualizaTipoAsunto.getNombreTipoAsunto(strGetAsuntoTurnado[0][27])%></FONT>
			<INPUT name="asuTip_1" type="hidden"
				value="<%=strGetAsuntoTurnado[0][27]%>"> <INPUT
				name="asuntoTipoAsunto" type="hidden"
				value="<%=strGetAsuntoTurnado[0][27]%>"></TD>
			<%}else{%>
			<TD width="660" colspan="3">
			<%if(strDatosDes.length!=0){%> <FONT face="Arial" size="2"><%= strDatosDes[0][12] %></FONT>
			<%}else{%> <FONT face="Arial" size="2"><%=ActualizaTipoAsunto.getNombreTipoAsunto(strGetAsuntoTurnado[0][27])%></FONT>
			<%}%> <INPUT name="asuTip_1" type="hidden" value="0"></TD>
			<%}%>
			<% }else{ %>
			<TD colspan="3"><SELECT name="asuntoTipoAsunto" class="blue500a">
				<%
						String strTipoAsuntoArea[][] = null;
						String strTipoAsuntoGral[][] = null;
						strTipoAsuntoArea = ComboData.getTipoAsuntoAreaCombo(BUsuario.getIdArea());
						strTipoAsuntoGral = ComboData.getTipoAsuntoAreaComboGral();
					%>
				<OPTION value="-1">--Tipos de Asunto de la Unidad--</OPTION>
				<% for(int s=0;s<strTipoAsuntoArea.length;s++){ %>
				<OPTION value="<%=strTipoAsuntoArea[s][0]%>"><%=strTipoAsuntoArea[s][1]%></OPTION>
				<% } %>
				<OPTION value="-1">--Tipos de Asunto Generales--</OPTION>
				<% for(int s=0;s<strTipoAsuntoGral.length;s++){ %>
				<OPTION value="<%=strTipoAsuntoGral[s][0]%>"><%=strTipoAsuntoGral[s][1]%></OPTION>
				<% } %>
			</SELECT> <INPUT name="asuTip_1" type="hidden" value="1"></TD>
			<% } %>
		</TR>
		<TR valign="top">
			<TD width="183">&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD colspan="4" align="left"></TD>
		</TR>
	</TBODY>
</TABLE>
<P><BR>
</P>

<% if(bExisteInstrucciones){ %>
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="64%" colspan="2"><B><FONT face="Arial"
				color="#004080" size="2">Lista Ruta de Atenci&oacute;n</FONT></B></TD>
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
							size="1">Unidad</FONT></DIV>
						</TD>
						<TD width="21%" bgcolor="#00204f">
						<DIV align="center"><FONT face="Verdana" color="#ffffff"
							size="1">N. Instrucci&oacute;n</FONT></DIV>
						</TD>
						<TD width="10%" bgcolor="#00204f">
						<DIV align="center"><FONT face="Verdana" color="#ffffff"
							size="1">F. Recepci&oacute;n</FONT></DIV>
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
					<% int t = 0; %>
					<meve_front:ListaDatos
						datos="<%= ActualizaInstrucciones.InstruccionPorIdAsunto(strIdAsunto) %>"
						campo="campo">
						<%if(campo1!=null){ %>
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
									if(bExistenFechas){
								%> <%= campo18 %> <% }else{ %>-<% } %> </FONT></DIV>
							</TD>
							<TD>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1"><%= campo6 %>%</FONT></DIV>
							</TD>
							<TD>
							<DIV align="center"><FONT face="Verdana" color="#000000"
								size="1"> <% if(campo7.equals("1")){ %> <% if(campo17.equals("0")){ %>
							<%if(BUsuario.getIdArea().equals(campo10)){%> <A
								href="InstruccionesAtender.jsp?id_ins=<%= campo12 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>"><U>Notificado</U></A>
							<%}else{%>Notificado<%}%> <% }else if(campo17.equals("1")){ %> <%if(BUsuario.getIdArea().equals(campo10)){%>
							<A
								href="InstruccionTurnada.jsp?id_ins=<%= campo12 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>"><U>Notificado</U></A>
							<%}else{%>Notificado<%}%> <% } %> <% }else if(campo7.equals("2")){ %> <% if(campo17.equals("0")){ %>
							<%if(BUsuario.getIdArea().equals(campo10)){%> <A
								href="InstruccionesAtender.jsp?id_ins=<%= campo12 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>"><U>En
							Proceso</U></A> <%}else{%>En Proceso<%}%> <% }else if(campo17.equals("1")){ %>
							<%if(BUsuario.getIdArea().equals(campo10)){%> <A
								href="InstruccionTurnada.jsp?id_ins=<%= campo12 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>"><U>En
							Proceso</U></A> <%}else{%>En Proceso<%}%> <% } %> <% }else if(campo7.equals("3")){ %>
							<%if(BUsuario.getIdArea().equals(campo10)){%> <A
								href="InstruccionesAtender.jsp?id_ins=<%= campo12 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>">
							<U>Rechazada</U></A> <%}else{%>Rechazada<%}%> <% }else if(campo7.equals("4")){ %>
							<% if(campo17.equals("0")){ %> <%if(BUsuario.getIdArea().equals(campo10)){%>
							<A
								href="InstruccionesAtender.jsp?id_ins=<%= campo12 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>">
							<U>Terminada</U></A> <%}else{%>Terminada<%}%> <% }else if(campo17.equals("1")){ %>
							<%if(BUsuario.getIdArea().equals(campo10)){%> <A
								href="InstruccionTurnada.jsp?id_ins=<%= campo12 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) %>">
							<U>Terminada</U></A> <%}else{%>Terminada<%}%> <%}%> <%}%> </FONT></DIV>
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
						<%}%>
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
<% } %>

<CENTER>
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
		<!-- <TR valign="top">
			<TD width="19%">&nbsp;</TD>
			<TD width="31%">&nbsp;</TD>
			<TD width="19%">&nbsp;</TD>
			<TD width="31%">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<c:choose>
				<c:when test='${BEscritura.value}'>
					<TD width="30%">&nbsp;</TD>
					<TD width="20%" align="center">
						<INPUT type="button" class="blue200" value="Agregar Archivo" onclick="agregarContent();">&nbsp;
					</TD>
					<TD width="20%" align="center">
						<INPUT type="button" class="blue200" value="Listado Archivos" onclick="listadoContent();">&nbsp;
					</TD>
					<TD width="50%">&nbsp;</TD>
				</c:when>
				<c:otherwise>
					<TD width="30%">&nbsp;</TD>
					<TD width="20%">&nbsp;</TD>
					<TD width="50%">&nbsp;</TD>
				</c:otherwise>
			</c:choose>
		</TR> -->
		<TR valign="top">
			<TD colspan="4">
			<div>
			<% if(BUsuario.getIdUsuario().equals(strGetAsuntoTurnado[0][32]) ||
						(BUsuario.getTurnado() && BUsuario.getIdArea().equals(strGetAsuntoTurnado[0][33]))){ %>
				<% if(strActivarCM.equals("si")){ 
	                      %> <IFRAME ID="frame1"
					SRC="ImportarCMO.jsp?IdAsunto=<%=strIdAsunto%>&bo=true&fol=<%=strGetAsuntoTurnado[0][23] %>&inst=<%=bInst %>&est=<%=strGetAsuntoTurnado[0][28]%>"
					WIDTH="800" HEIGHT="250" frameborder=0></IFRAME> <% }
					else{ %> <IFRAME
						ID="frame1"
						SRC="ImportarAR.jsp?IdAsunto=<%=strIdAsunto%>&bo=true&fol=<%=strGetAsuntoTurnado[0][23] %>&inst=<%=bInst %>&est=<%=strGetAsuntoTurnado[0][28]%>"
						WIDTH="800" HEIGHT="250" frameborder=0></IFRAME> <% }%> <% 
				}else{ %> <% 
					if(strActivarCM.equals("no")){ 					
	                    %> <IFRAME ID="frame1"
						SRC="ImportarAR.jsp?IdAsunto=<%=strIdAsunto%>&bo=false&fol=<%=strGetAsuntoTurnado[0][23] %>&inst=<%=bInst %>&est=<%=strGetAsuntoTurnado[0][28]%>"
						WIDTH="800" HEIGHT="250" frameborder=0></IFRAME> <% }
					else{ %> <IFRAME
						ID="frame1"
						SRC="ImportarCMO.jsp?IdAsunto=<%=strIdAsunto%>&bo=false&fol=<%=strGetAsuntoTurnado[0][23] %>&inst=<%=bInst %>&est=<%=strGetAsuntoTurnado[0][28]%>"
						WIDTH="800" HEIGHT="250" frameborder="0"></IFRAME> <% 
						} %> <% 
				} %>
			</div>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</CENTER>
<br>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="183"><b><font size="2" color="#004080"
			face="Arial">Comentarios del Asunto</font></b></td>
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
</table>
</DIV>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="863" colspan="4">&nbsp;</td>
	</tr>
	<tr valign="top">
		<% if(bExisteHistorial){ %>
		<td width="863"><font size="2" color="#004080" face="Arial">
		<meve_front:ListaDatos
			datos="<%=ActualizaComentario.getDatosComentarios(strIdAsunto)%>"
			campo="campo">
			<B>Fecha y Hora:</B>
			<%= campo2 %>
			<br>
			<B>Usuario:</B>
			<%= campo3 %>
			<br>
			<B>Comentario:</B>
			<br>
			<%= Utilerias.cambioSaltosDeLinea(campo1) %>
			<br>
				-------------<br>
			<br>
		</meve_front:ListaDatos> </font></td>
		<% }else{ %>
		<td width="100%">&nbsp;</td>
		<% } %>
	</tr>
	<tr valign="top">
		<td width="863" colspan="4">&nbsp;</td>
	</tr>
	<tr valign="top">
		<td width="863" bgcolor="#00204F" colspan="4"></td>
	</tr>
</table>
</DIV>
</DIV>
<INPUT type="hidden" name="b" value="<%=nombre%>"><BR>
<% if(carga != null && carga.equals("1")){ %> <script language=JavaScript
	type=text/javascript>
agregarContent();
</script>
<% } %> <% if(strReload.equals("0")){ %> <script language=JavaScript
	type=text/javascript>
doc = document.asuntoTurnado;
doc.retURI.value='<%=retURI%>';
doc.submit();
</script> <%}%>
</DIV>
<% if (folioControl!=null && folioControl.equals("1")){ %> <script
	type="text/javascript">
	alert("Se le asign\xF3 el folio <%= strGetAsuntoTurnado[0][23]%> al Asunto");
</script> <% } %> <SCRIPT language="JavaScript" type="text/javascript">
if (<%= bValidaEstatus %>){
	alert("Este Asunto ha sido modificado por otro usuario y cambi&oacute; su Estatus,\npor lo que la acci&oacute;n solicitada ser&aacute; cancelada");
	location.assign("portalPrincipal.jsp");
}
</script>
</FORM>
</BODY>
</HTML>
