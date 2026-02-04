package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import gob.hacienda.cgtic.siga.asunto.AsuntoVerifica;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.reportes.*;
import com.meve.sigma.util.*;
import com.meve.sigma.taglib.*;
import java.text.SimpleDateFormat;
import java.util.*;
import com.meve.sigma.beans.search.*;
import com.meve.sigma.instruccion.*;


public class _AsuntoTurnado extends com.orionserver.http.OrionHttpJspPage {


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
    _AsuntoTurnado page = this;
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
      com.meve.sigma.beans.EscrituraBean BEscritura;
      synchronized (pageContext) {
        if ((BEscritura = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscritura", PageContext.PAGE_SCOPE)) == null) {
          BEscritura = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
          pageContext.setAttribute( "BEscritura", BEscritura, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[5]);
      com.meve.sigma.beans.EscrituraBean BEscrituraAr;
      synchronized (pageContext) {
        if ((BEscrituraAr = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscrituraAr", PageContext.PAGE_SCOPE)) == null) {
          BEscrituraAr = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
          pageContext.setAttribute( "BEscrituraAr", BEscrituraAr, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[6]);
      com.meve.sigma.beans.TurnarBean BTurnar;
      synchronized (pageContext) {
        if ((BTurnar = (com.meve.sigma.beans.TurnarBean) pageContext.getAttribute( "BTurnar", PageContext.PAGE_SCOPE)) == null) {
          BTurnar = (com.meve.sigma.beans.TurnarBean) new com.meve.sigma.beans.TurnarBean();
          pageContext.setAttribute( "BTurnar", BTurnar, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[7]);
      com.meve.sigma.beans.TurnarNew BTurnarNew;
      synchronized (pageContext) {
        if ((BTurnarNew = (com.meve.sigma.beans.TurnarNew) pageContext.getAttribute( "BTurnarNew", PageContext.PAGE_SCOPE)) == null) {
          BTurnarNew = (com.meve.sigma.beans.TurnarNew) new com.meve.sigma.beans.TurnarNew();
          pageContext.setAttribute( "BTurnarNew", BTurnarNew, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[8]);
      out.write(__oracle_jsp_text[9]);
      out.write(__oracle_jsp_text[10]);
      
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
      
      out.write(__oracle_jsp_text[11]);
      
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
      
      out.write(__oracle_jsp_text[12]);
      
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
      
      				response.sendRedirect("VisualizaInstrucciones.jsp?idAsunto="+strIdAsunto+"&Url="+URL+"&no="+bNoTiene+"&retURI="+Utilerias.codificaPostHTML(retURI));
      			}
      		}else{
      			response.sendRedirect("VisualizaInstrucciones.jsp?idAsunto="+strIdAsunto+"&Url="+URL+"&retURI="+Utilerias.codificaPostHTML(retURI));
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
      				response.sendRedirect("VisualizaInstrucciones.jsp?idAsunto="+strIdAsunto+"&Url="+URL+"&no="+bNoTiene+"&retURI="+Utilerias.codificaPostHTML(retURI));
      			}
      		}else{
      			response.sendRedirect("VisualizaInstrucciones.jsp?idAsunto="+strIdAsunto+"&Url="+URL+"&retURI="+Utilerias.codificaPostHTML(retURI));
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
      					BUsuario.getIdUsuario().equals(strGetAsuntoTurnado[0][24]) //area de Recepción					
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
      
      out.write(__oracle_jsp_text[13]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[14]);
       	} 
      out.write(__oracle_jsp_text[15]);
      out.write(__oracle_jsp_text[16]);
      out.print( strIdAsunto );
      out.write(__oracle_jsp_text[17]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[18]);
      out.print(Utilerias.codificaPostHTML("AsuntoTurnado.jsp?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)));
      out.write(__oracle_jsp_text[19]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[20]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[21]);
      out.print(Utilerias.codificaPostHTML("AsuntoTurnado.jsp?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)));
      out.write(__oracle_jsp_text[22]);
      out.print(strGetAsuntoTurnado[0][23]);
      out.write(__oracle_jsp_text[23]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[24]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[25]);
      out.print( Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[26]);
      out.print( serverContentManager );
      out.write(__oracle_jsp_text[27]);
      out.print( strIdAsunto );
      out.write(__oracle_jsp_text[28]);
      out.print(strItemType);
      out.write(__oracle_jsp_text[29]);
      out.print( serverContentManager );
      out.write(__oracle_jsp_text[30]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[31]);
      out.print(strItemType);
      out.write(__oracle_jsp_text[32]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[33]);
       if(strActivarCM.equals("si")){ 
      out.write(__oracle_jsp_text[34]);
      out.print( serverContentManager );
      out.write(__oracle_jsp_text[35]);
      out.print(strItemType);
      out.write(__oracle_jsp_text[36]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[37]);
      out.print(strGetAsuntoTurnado[0][23]);
      out.write(__oracle_jsp_text[38]);
      out.print(BUsuario.getNombre());
      out.write(__oracle_jsp_text[39]);
      }else{
      out.write(__oracle_jsp_text[40]);
      out.print(server);
      out.print(strBase);
      out.write(__oracle_jsp_text[41]);
      out.print(strItemType);
      out.write(__oracle_jsp_text[42]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[43]);
      out.print(strGetAsuntoTurnado[0][23]);
      out.write(__oracle_jsp_text[44]);
      out.print(BUsuario.getIdUsuario());
      out.write(__oracle_jsp_text[45]);
      }
      out.write(__oracle_jsp_text[46]);
       if(bTieneArchivado){ 
      out.write(__oracle_jsp_text[47]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[48]);
      out.print(strGetAsuntoTurnado[0][5]);
      out.write(__oracle_jsp_text[49]);
      out.print(dest1[0][2]);
      out.write(__oracle_jsp_text[50]);
       }else{
      out.write(__oracle_jsp_text[51]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[52]);
      out.print(strGetAsuntoTurnado[0][5]);
      out.write(__oracle_jsp_text[53]);
      out.print(dest1[0][2]);
      out.write(__oracle_jsp_text[54]);
      }
      out.write(__oracle_jsp_text[55]);
       
      	String ma = null;
      	
      out.write(__oracle_jsp_text[56]);
       if(strGetAsuntoTurnado[0][34].equals("1")){ 
      out.write(__oracle_jsp_text[57]);
       ma =  ActualizaUsuario.getMailCargoUsuario(strGetAsuntoTurnado[0][2])[0][1];
      out.write(__oracle_jsp_text[58]);
       }else{ 
      out.write(__oracle_jsp_text[59]);
       ma = strGetDatosRem[0][5];
      out.write(__oracle_jsp_text[60]);
       } 
      out.write(__oracle_jsp_text[61]);
      out.print( strGetAsuntoTurnado[0][5] );
      out.write(__oracle_jsp_text[62]);
      out.print( strGetAsuntoTurnado[0][23] );
      out.write(__oracle_jsp_text[63]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[64]);
      out.print(ma);
      out.write(__oracle_jsp_text[65]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[66]);
      out.print(retURI);
      out.write(__oracle_jsp_text[67]);
      out.print(retURI2);
      out.write(__oracle_jsp_text[68]);
      out.print(fAvance);
      out.write(__oracle_jsp_text[69]);
      out.print(strGetAsuntoTurnado[0][5]);
      out.write(__oracle_jsp_text[70]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[71]);
      if(bTienePasos){
      out.write(__oracle_jsp_text[72]);
      }
      out.write(__oracle_jsp_text[73]);
       if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_EN_RECEPCION))){ 
      out.write(__oracle_jsp_text[74]);
       }else if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_POR_TURNAR))){ 
      out.write(__oracle_jsp_text[75]);
       }else if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TURNADO))){ 
      out.write(__oracle_jsp_text[76]);
       }else if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO))){ 
      out.write(__oracle_jsp_text[77]);
       }
      out.write(__oracle_jsp_text[78]);
      out.print( retURI2 );
      out.write(__oracle_jsp_text[79]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_1=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_1.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[80]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_2=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[81]);
                  out.write(__oracle_jsp_text[82]);
                  out.write(__oracle_jsp_text[83]);
                  if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO)) && fAvance >=100){
                  out.write(__oracle_jsp_text[84]);
                  out.write(__oracle_jsp_text[85]);
                  }else if(accesoSolicitado){
                  out.write(__oracle_jsp_text[86]);
                  }
                  out.write(__oracle_jsp_text[87]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[88]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[89]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_3=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_3.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[90]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_4=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_4.setParent(__jsp_taghandler_3);
              __jsp_taghandler_4.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[91]);
                  if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO)) && fAvance >=100){
                  out.write(__oracle_jsp_text[92]);
                  }else if(accesoSolicitado){
                  out.write(__oracle_jsp_text[93]);
                  }
                  out.write(__oracle_jsp_text[94]);
                } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[95]);
          } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[96]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_5=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_5.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[97]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_6=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_6.setParent(__jsp_taghandler_5);
              __jsp_taghandler_6.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[98]);
                  if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO)) && fAvance >=100){
                  out.write(__oracle_jsp_text[99]);
                  }else if(accesoSolicitado){
                  out.write(__oracle_jsp_text[100]);
                  }
                  out.write(__oracle_jsp_text[101]);
                } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[102]);
          } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[103]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_7=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_7.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[104]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_8=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_8.setParent(__jsp_taghandler_7);
              __jsp_taghandler_8.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[105]);
                  out.print(strIdAsunto);
                  out.write(__oracle_jsp_text[106]);
                } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[107]);
          } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      out.write(__oracle_jsp_text[108]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_9=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_9.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[109]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_10=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_10.setParent(__jsp_taghandler_9);
              __jsp_taghandler_10.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[110]);
                   if(strActivarPortal.equals("si")){ 
                  out.write(__oracle_jsp_text[111]);
                  if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO)) && fAvance >=100){
                  out.write(__oracle_jsp_text[112]);
                  }else if(accesoSolicitado && !strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_POR_TURNAR))){
                  out.write(__oracle_jsp_text[113]);
                  out.print( strIdAsunto );
                  out.write(__oracle_jsp_text[114]);
                  }
                  out.write(__oracle_jsp_text[115]);
                   }else{ 
                  out.write(__oracle_jsp_text[116]);
                   } 
                  out.write(__oracle_jsp_text[117]);
                } while (__jsp_taghandler_10.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,2);
            }
            out.write(__oracle_jsp_text[118]);
            {
              org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_11=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
              __jsp_taghandler_11.setParent(__jsp_taghandler_9);
              __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[119]);
                } while (__jsp_taghandler_11.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,2);
            }
            out.write(__oracle_jsp_text[120]);
          } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,1);
      }
      out.write(__oracle_jsp_text[121]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_12=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_12.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[122]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_13=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_13.setParent(__jsp_taghandler_12);
              __jsp_taghandler_13.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[123]);
                   if(accesoSolicitado && bExisteInstrucciones && strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_POR_TURNAR))){ 
                  out.write(__oracle_jsp_text[124]);
                  if(accesoSolicitado && !bEstanVacias){
                  out.write(__oracle_jsp_text[125]);
                  }
                  out.write(__oracle_jsp_text[126]);
                   }else if(accesoSolicitado && strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TURNADO))){ 
                  out.write(__oracle_jsp_text[127]);
                   if(accesoSolicitado && ActualizaAsuntoTurnado.existenInstruccionesNuevasSinTurnar(strIdAsunto)){ 
                  out.write(__oracle_jsp_text[128]);
                   } 
                  out.write(__oracle_jsp_text[129]);
                   }else if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO)) && fAvance >=100){ 
                  out.write(__oracle_jsp_text[130]);
                   }else if(accesoSolicitado && strGetAsuntoTurnado[0][22].length() != 0 && strGetAsuntoTurnado[0][27].length() == 0){ 
                  out.write(__oracle_jsp_text[131]);
                   }else if(accesoSolicitado && strGetAsuntoTurnado[0][27].length() != 0 && strGetAsuntoTurnado[0][22].length() == 0){ 
                  out.write(__oracle_jsp_text[132]);
                   }else if(accesoSolicitado && strGetAsuntoTurnado[0][27].length() == 0 && strGetAsuntoTurnado[0][22].length() == 0){ 
                  out.write(__oracle_jsp_text[133]);
                   }else if(accesoSolicitado) { 
                  out.write(__oracle_jsp_text[134]);
                   } 
                  out.write(__oracle_jsp_text[135]);
                } while (__jsp_taghandler_13.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,2);
            }
            out.write(__oracle_jsp_text[136]);
          } while (__jsp_taghandler_12.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,1);
      }
      out.write(__oracle_jsp_text[137]);
      if(puedeRecuperarUa&&(AsuntoVerifica.esRecuperable(Integer.parseInt(strIdAsunto))&&strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TURNADO)))){
      out.write(__oracle_jsp_text[138]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_14=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_14.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[139]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_15=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_15.setParent(__jsp_taghandler_14);
              __jsp_taghandler_15.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[140]);
                } while (__jsp_taghandler_15.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,2);
            }
            out.write(__oracle_jsp_text[141]);
          } while (__jsp_taghandler_14.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,1);
      }
      out.write(__oracle_jsp_text[142]);
      } 
      out.write(__oracle_jsp_text[143]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_16=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_16.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[144]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_17=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_17.setParent(__jsp_taghandler_16);
              __jsp_taghandler_17.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[145]);
                  if(fAvance >= 100 && strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO))){
                  out.write(__oracle_jsp_text[146]);
                  if(strGetAsuntoTurnado[0][44].equals("0")){
                  out.write(__oracle_jsp_text[147]);
                  }
                  out.write(__oracle_jsp_text[148]);
                  }else if(	accesoSolicitado && fAvance == 99 && iFinalizado == 1 && (bEstanVacias ||
                  								!ActualizaAsuntoTurnado.existenInstruccionesNuevasSinTurnar(strIdAsunto))){
                  out.write(__oracle_jsp_text[149]);
                  }
                  out.write(__oracle_jsp_text[150]);
                } while (__jsp_taghandler_17.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,2);
            }
            out.write(__oracle_jsp_text[151]);
            {
              org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_18=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
              __jsp_taghandler_18.setParent(__jsp_taghandler_16);
              __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[152]);
                } while (__jsp_taghandler_18.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,2);
            }
            out.write(__oracle_jsp_text[153]);
          } while (__jsp_taghandler_16.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,1);
      }
      out.write(__oracle_jsp_text[154]);
       if(bExisteInstrucciones && strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_POR_TURNAR))){ 
      out.write(__oracle_jsp_text[155]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_19=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_19.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[156]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_20=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_20.setParent(__jsp_taghandler_19);
              __jsp_taghandler_20.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[157]);
                  {
                    com.meve.sigma.taglib.CreaCombo __jsp_taghandler_21=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
                    __jsp_taghandler_21.setParent(__jsp_taghandler_20);
                    __jsp_taghandler_21.setData(ComboData.getUsuarioCombo(BUsuario.getIdArea()));
                    __jsp_taghandler_21.setName("usuarioNombre");
                    __jsp_taghandler_21.setSize(1);
                    __jsp_taghandler_21.setSelected(OracleJspRuntime.toStr( strNotificar));
                    __jsp_taghandler_21.setDisabled(true);
                    __jsp_taghandler_21.setClassHtml("blue500a");
                    __jsp_taghandler_21.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
                    __jsp_taghandler_21.setTextoNoSeleccion("------ Seleccione un Puesto ------");
                    __jsp_taghandler_21.setValorNoSeleccion("-1");
                    __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
                    if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,3);
                  }
                  out.write(__oracle_jsp_text[158]);
                } while (__jsp_taghandler_20.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,2);
            }
            out.write(__oracle_jsp_text[159]);
            {
              org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_22=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
              __jsp_taghandler_22.setParent(__jsp_taghandler_19);
              __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[160]);
                } while (__jsp_taghandler_22.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,2);
            }
            out.write(__oracle_jsp_text[161]);
          } while (__jsp_taghandler_19.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,1);
      }
      out.write(__oracle_jsp_text[162]);
       } 
      out.write(__oracle_jsp_text[163]);
       if(strMensaje.length()!=0){
      out.write(__oracle_jsp_text[164]);
      out.print(strMensaje);
      out.write(__oracle_jsp_text[165]);
       } 
      out.write(__oracle_jsp_text[166]);
      out.print( ActualizaUsuario.NombreUsuario(strGetAsuntoTurnado[0][24]) );
      out.write(__oracle_jsp_text[167]);
      out.print( Utilerias.formatearFechas(strGetAsuntoTurnado[0][25]) );
      out.write(__oracle_jsp_text[168]);
       if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TERMINADO))){ 
      out.write(__oracle_jsp_text[169]);
       }else if(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TURNADO))){ 
      out.write(__oracle_jsp_text[170]);
       }else if(strGetAsuntoTurnado[0][28].equals("1")){ 
      out.write(__oracle_jsp_text[171]);
       }else if(strGetAsuntoTurnado[0][28].equals("0")){ 
      out.write(__oracle_jsp_text[172]);
       } 
      out.write(__oracle_jsp_text[173]);
      out.print( strGetAsuntoTurnado[0][23] );
      out.write(__oracle_jsp_text[174]);
      out.print(strGetAsuntoTurnado[0][45]);
      out.write(__oracle_jsp_text[175]);
      if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){
      out.write(__oracle_jsp_text[176]);
       if(strGetAsuntoTurnado[0][0].length() == 0){ 
      out.write(__oracle_jsp_text[177]);
      out.print( strGetAsuntoTurnado[0][1] );
      out.write(__oracle_jsp_text[178]);
       }else if(strGetAsuntoTurnado[0][34].equals("1")){ 
      out.write(__oracle_jsp_text[179]);
      out.print( ActualizaArea.NombreArea(strGetAsuntoTurnado[0][0]) );
      out.write(__oracle_jsp_text[180]);
       }else{ 
      out.write(__oracle_jsp_text[181]);
      out.print(ActualizaEntidad.getNombreEntidad(strGetAsuntoTurnado[0][0]));
      out.write(__oracle_jsp_text[182]);
       } 
      out.write(__oracle_jsp_text[183]);
      }else{
      out.write(__oracle_jsp_text[184]);
      if(strDatosDes.length!=0){
      out.write(__oracle_jsp_text[185]);
      out.print( strDatosDes[0][1] );
      out.write(__oracle_jsp_text[186]);
      }else{
      out.write(__oracle_jsp_text[187]);
       if(strGetAsuntoTurnado[0][0].length() == 0){ 
      out.write(__oracle_jsp_text[188]);
      out.print( strGetAsuntoTurnado[0][1] );
      out.write(__oracle_jsp_text[189]);
       }else if(strGetAsuntoTurnado[0][34].equals("1")){ 
      out.write(__oracle_jsp_text[190]);
      out.print( ActualizaArea.NombreArea(strGetAsuntoTurnado[0][0]) );
      out.write(__oracle_jsp_text[191]);
       }else{ 
      out.write(__oracle_jsp_text[192]);
      out.print(ActualizaEntidad.getNombreEntidad(strGetAsuntoTurnado[0][0]));
      out.write(__oracle_jsp_text[193]);
       } 
      out.write(__oracle_jsp_text[194]);
      }
      out.write(__oracle_jsp_text[195]);
      }
      out.write(__oracle_jsp_text[196]);
      if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){
      out.write(__oracle_jsp_text[197]);
       if(strGetAsuntoTurnado[0][34].equals("1")){ 
      out.write(__oracle_jsp_text[198]);
      out.print( ActualizaUsuario.getMailCargoUsuario(strGetAsuntoTurnado[0][2])[0][0] );
      out.write(__oracle_jsp_text[199]);
      out.print( ActualizaUsuario.NombrePuesto(strGetAsuntoTurnado[0][2]) );
      out.write(__oracle_jsp_text[200]);
       }else{ 
      out.write(__oracle_jsp_text[201]);
      out.print(strGetDatosRem[0][2]);
      out.write(__oracle_jsp_text[202]);
      out.print(strGetDatosRem[0][0]);
      out.write(__oracle_jsp_text[203]);
       } 
      out.write(__oracle_jsp_text[204]);
      }else{
      out.write(__oracle_jsp_text[205]);
      if(strDatosDes.length!=0){
      out.write(__oracle_jsp_text[206]);
      out.print( strDatosDes[0][3] );
      out.write(__oracle_jsp_text[207]);
      out.print( strDatosDes[0][2] );
      out.write(__oracle_jsp_text[208]);
      }else{
      out.write(__oracle_jsp_text[209]);
       if(strGetAsuntoTurnado[0][34].equals("1")){ 
      out.write(__oracle_jsp_text[210]);
      out.print( ActualizaUsuario.getMailCargoUsuario(strGetAsuntoTurnado[0][2])[0][0] );
      out.write(__oracle_jsp_text[211]);
      out.print( ActualizaUsuario.NombrePuesto(strGetAsuntoTurnado[0][2]) );
      out.write(__oracle_jsp_text[212]);
       }else{ 
      out.write(__oracle_jsp_text[213]);
      out.print(strGetDatosRem[0][2]);
      out.write(__oracle_jsp_text[214]);
      out.print(strGetDatosRem[0][0]);
      out.write(__oracle_jsp_text[215]);
       } 
      out.write(__oracle_jsp_text[216]);
      }
      out.write(__oracle_jsp_text[217]);
      }
      out.write(__oracle_jsp_text[218]);
      out.print( strGetAsuntoTurnado[0][4] );
      out.write(__oracle_jsp_text[219]);
      if(strGetAsuntoTurnado[0][46].equals("0")){
      out.write(__oracle_jsp_text[220]);
      }else{
      out.write(__oracle_jsp_text[221]);
      }
      out.write(__oracle_jsp_text[222]);
      if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){
      out.write(__oracle_jsp_text[223]);
       
      					if(strGetAsuntoTurnado[0][32].length() == 0){ 
      out.write(__oracle_jsp_text[224]);
       }else{ 
      out.write(__oracle_jsp_text[225]);
      
      						String dest[][] = ActualizaUsuario.getNombreCargoAreaUsr(strGetAsuntoTurnado[0][32]); 
      						d = dest[0][0];
      						c = dest[0][1];
      						a = dest[0][2];
      					
      out.write(__oracle_jsp_text[226]);
      out.print( d );
      out.write(__oracle_jsp_text[227]);
       } 
      out.write(__oracle_jsp_text[228]);
      }else{
      out.write(__oracle_jsp_text[229]);
      if(strDatosDes.length!=0){
      out.write(__oracle_jsp_text[230]);
      out.print(strDatosDes[0][6]);
      out.write(__oracle_jsp_text[231]);
      }else{
      out.write(__oracle_jsp_text[232]);
       
      					if(strGetAsuntoTurnado[0][32].length() == 0){ 
      out.write(__oracle_jsp_text[233]);
       }else{ 
      out.write(__oracle_jsp_text[234]);
      
      						String dest[][] = ActualizaUsuario.getNombreCargoAreaUsr(strGetAsuntoTurnado[0][32]); 
      						d = dest[0][0];
      						c = dest[0][1];
      						a = dest[0][2];
      					
      out.write(__oracle_jsp_text[235]);
      out.print( d );
      out.write(__oracle_jsp_text[236]);
       } 
      out.write(__oracle_jsp_text[237]);
      }
      out.write(__oracle_jsp_text[238]);
      }
      out.write(__oracle_jsp_text[239]);
      if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){
      out.write(__oracle_jsp_text[240]);
      Vector vPara = Utilerias.getNombrePuesto(strGetAsuntoTurnado[0][47],0);
      				for(int i=0;i<vPara.size();i++){ 
      out.write(__oracle_jsp_text[241]);
      out.print(Utilerias.recortaString((String)vPara.elementAt(i), 100));
      out.write(__oracle_jsp_text[242]);
      }
      out.write(__oracle_jsp_text[243]);
      }else{
      out.write(__oracle_jsp_text[244]);
      if(strDatosDesPara.length!=0){
      out.write(__oracle_jsp_text[245]);
      for(int i=0;i<strDatosDesPara.length;i++){ 
      out.write(__oracle_jsp_text[246]);
      out.print(Utilerias.recortaString(strDatosDesPara[i][0], 100));
      out.write(__oracle_jsp_text[247]);
      }
      out.write(__oracle_jsp_text[248]);
      }else{
      out.write(__oracle_jsp_text[249]);
      Vector vPara = Utilerias.getNombrePuesto(strGetAsuntoTurnado[0][47],0);
      					for(int i=0;i<vPara.size();i++){ 
      out.write(__oracle_jsp_text[250]);
      out.print(Utilerias.recortaString((String)vPara.elementAt(i), 100));
      out.write(__oracle_jsp_text[251]);
      }
      out.write(__oracle_jsp_text[252]);
      }
      out.write(__oracle_jsp_text[253]);
      }
      out.write(__oracle_jsp_text[254]);
      if(!(strGetAsuntoTurnado[0][28].equals(String.valueOf(Estatus.ASU_TURNADO)) || strGetAsuntoTurnado[0][28].equals(Integer.valueOf(Estatus.ASU_TERMINADO)))){
      out.write(__oracle_jsp_text[255]);
      Vector vCC = Utilerias.getNombrePuesto(strGetAsuntoTurnado[0][48],0);
      				for(int i=0;i<vCC.size();i++){ 
      out.write(__oracle_jsp_text[256]);
      out.print(Utilerias.recortaString((String)vCC.elementAt(i), 100));
      out.write(__oracle_jsp_text[257]);
      }
      out.write(__oracle_jsp_text[258]);
      }else{
      out.write(__oracle_jsp_text[259]);
      if(strDatosDesCC.length!=0){
      out.write(__oracle_jsp_text[260]);
      for(int i=1;i<strDatosDesCC.length;i++){ 
      out.write(__oracle_jsp_text[261]);
      out.print(Utilerias.recortaString((String)strDatosDesCC[i], 100));
      out.write(__oracle_jsp_text[262]);
      }
      out.write(__oracle_jsp_text[263]);
      }else{
      out.write(__oracle_jsp_text[264]);
      Vector vCC = Utilerias.getNombrePuesto(strGetAsuntoTurnado[0][48],0);
      					for(int i=0;i<vCC.size();i++){ 
      out.write(__oracle_jsp_text[265]);
      out.print(Utilerias.recortaString((String)vCC.elementAt(i), 100));
      out.write(__oracle_jsp_text[266]);
      }
      out.write(__oracle_jsp_text[267]);
      }
      out.write(__oracle_jsp_text[268]);
      }
      out.write(__oracle_jsp_text[269]);
      if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){
      out.write(__oracle_jsp_text[270]);
      Vector vPEx = Utilerias.getRemitenteEntidad(strGetAsuntoTurnado[0][49],1);
      					for(int i=0;i<vPEx.size();i++){ 
      out.write(__oracle_jsp_text[271]);
      out.print(Utilerias.recortaString((String)vPEx.elementAt(i), 100));
      out.write(__oracle_jsp_text[272]);
      }
      out.write(__oracle_jsp_text[273]);
      }else{
      out.write(__oracle_jsp_text[274]);
      if(strDatosDesParaE.length!=0){
      out.write(__oracle_jsp_text[275]);
      for(int i=0;i<strDatosDesParaE.length;i++){ 
      out.write(__oracle_jsp_text[276]);
      out.print(Utilerias.recortaString(strDatosDesParaE[i][0], 100));
      out.write(__oracle_jsp_text[277]);
      }
      out.write(__oracle_jsp_text[278]);
      }else{
      out.write(__oracle_jsp_text[279]);
      Vector vPEx = Utilerias.getRemitenteEntidad(strGetAsuntoTurnado[0][49],1);
      						for(int i=0;i<vPEx.size();i++){ 
      out.write(__oracle_jsp_text[280]);
      out.print(Utilerias.recortaString((String)vPEx.elementAt(i), 100));
      out.write(__oracle_jsp_text[281]);
      }
      out.write(__oracle_jsp_text[282]);
      }
      out.write(__oracle_jsp_text[283]);
      }
      out.write(__oracle_jsp_text[284]);
      out.print( strGetAsuntoTurnado[0][5] );
      out.write(__oracle_jsp_text[285]);
      if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){
      out.write(__oracle_jsp_text[286]);
      out.print( ActualizaTipo_Doc.getNombreTipoDocto(strGetAsuntoTurnado[0][30]) );
      out.write(__oracle_jsp_text[287]);
      }else{
      out.write(__oracle_jsp_text[288]);
      if(strDatosDes.length!=0){
      out.write(__oracle_jsp_text[289]);
      out.print(strDatosDes[0][9]);
      out.write(__oracle_jsp_text[290]);
      }else{
      out.write(__oracle_jsp_text[291]);
      out.print( ActualizaTipo_Doc.getNombreTipoDocto(strGetAsuntoTurnado[0][30]) );
      out.write(__oracle_jsp_text[292]);
      }
      out.write(__oracle_jsp_text[293]);
      }
      out.write(__oracle_jsp_text[294]);
       if(strGetAsuntoTurnado[0][13].length() >0){ 
      out.write(__oracle_jsp_text[295]);
      out.print(Utilerias.formatearFechas(strGetAsuntoTurnado[0][13]));
      out.write(__oracle_jsp_text[296]);
       }else{ 
      out.write(__oracle_jsp_text[297]);
       } 
      out.write(__oracle_jsp_text[298]);
      out.print( (strGetAsuntoTurnado[0][50].length()==1)?"0"+strGetAsuntoTurnado[0][50]:strGetAsuntoTurnado[0][50] );
      out.write(__oracle_jsp_text[299]);
      out.print( (strGetAsuntoTurnado[0][51].length()==1)?"0"+strGetAsuntoTurnado[0][51]:strGetAsuntoTurnado[0][51] );
      out.write(__oracle_jsp_text[300]);
       if(strGetAsuntoTurnado[0][14].length() >0){ 
      out.write(__oracle_jsp_text[301]);
      out.print(Utilerias.formatearFechas(strGetAsuntoTurnado[0][14]));
      out.write(__oracle_jsp_text[302]);
       }else{ 
      out.write(__oracle_jsp_text[303]);
       } 
      out.write(__oracle_jsp_text[304]);
      if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){
      out.write(__oracle_jsp_text[305]);
      if(strGetAsuntoTurnado[0][43].length()>0){
      out.write(__oracle_jsp_text[306]);
      out.print( ActualizaTramite.getNombreTramite(strGetAsuntoTurnado[0][43]) );
      out.write(__oracle_jsp_text[307]);
      }else{
      out.write(__oracle_jsp_text[308]);
      }
      out.write(__oracle_jsp_text[309]);
      }else{
      out.write(__oracle_jsp_text[310]);
      if(strDatosDes.length!=0){
      out.write(__oracle_jsp_text[311]);
      out.print(strDatosDes[0][11]);
      out.write(__oracle_jsp_text[312]);
      }else{
      out.write(__oracle_jsp_text[313]);
      if(strGetAsuntoTurnado[0][43].length()>0){
      out.write(__oracle_jsp_text[314]);
      out.print( ActualizaTramite.getNombreTramite(strGetAsuntoTurnado[0][43]) );
      out.write(__oracle_jsp_text[315]);
      }else{
      out.write(__oracle_jsp_text[316]);
      }
      out.write(__oracle_jsp_text[317]);
      }
      out.write(__oracle_jsp_text[318]);
      }
      out.write(__oracle_jsp_text[319]);
       if(strGetAsuntoTurnado[0][15].length() >0){ 
      out.write(__oracle_jsp_text[320]);
      out.print(Utilerias.formatearFechas(strGetAsuntoTurnado[0][15]));
      out.write(__oracle_jsp_text[321]);
       }else{ 
      out.write(__oracle_jsp_text[322]);
       } 
      out.write(__oracle_jsp_text[323]);
      out.print( strGetAsuntoTurnado[0][16] );
      out.write(__oracle_jsp_text[324]);
      out.print( strGetAsuntoTurnado[0][17] );
      out.write(__oracle_jsp_text[325]);
      out.print( Utilerias.cambioSaltosDeLinea(strGetAsuntoTurnado[0][18]) );
      out.write(__oracle_jsp_text[326]);
      out.print( Utilerias.cambioSaltosDeLinea(strGetAsuntoTurnado[0][19]) );
      out.write(__oracle_jsp_text[327]);
      out.print( strGetAsuntoTurnado[0][20] );
      out.write(__oracle_jsp_text[328]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[329]);
      if (strDatosAsuntoAnt.length == 0 && strDatosAsuntoLigas.length==0){
      out.write(__oracle_jsp_text[330]);
      }else{
      out.write(__oracle_jsp_text[331]);
      if(strDatosAsuntoAnt.length!=0){
      out.write(__oracle_jsp_text[332]);
      
      	String strConsulta[][];
      	for (int m = 0; m < strDatosAsuntoAnt.length ; m ++){
      		strConsulta = ActualizaBuscar.getBusquedaAsuntosAnidados(strDatosAsuntoAnt[m][0]);
      	
      out.write(__oracle_jsp_text[333]);
      if(par(m)==true){
      out.write(__oracle_jsp_text[334]);
      }else{
      out.write(__oracle_jsp_text[335]);
      }
      out.write(__oracle_jsp_text[336]);
      out.print( strGetAsuntoTurnado[0][23] );
      out.write(__oracle_jsp_text[337]);
      out.print(strDatosAsuntoAnt[m][1]);
      out.write(__oracle_jsp_text[338]);
      out.print( strConsulta[0][0] );
      out.write(__oracle_jsp_text[339]);
      out.print( Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[340]);
      out.print( strConsulta[0][1] );
      out.write(__oracle_jsp_text[341]);
      out.print(strDatosAsuntoAnt[m][1]);
      out.write(__oracle_jsp_text[342]);
      out.print(strConsulta[0][2]);
      out.write(__oracle_jsp_text[343]);
       if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_EN_RECEPCION))){ 
      out.write(__oracle_jsp_text[344]);
       }else if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_POR_TURNAR))){ 
      out.write(__oracle_jsp_text[345]);
       }else if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_TURNADO))){ 
      out.write(__oracle_jsp_text[346]);
       }else if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_TERMINADO))){ 
      out.write(__oracle_jsp_text[347]);
       }
      out.write(__oracle_jsp_text[348]);
      }
      out.write(__oracle_jsp_text[349]);
      }
      out.write(__oracle_jsp_text[350]);
      if(strDatosAsuntoLigas.length!=0){
      out.write(__oracle_jsp_text[351]);
      
      	String strConsulta[][];
      	for (int m = 0; m < strDatosAsuntoLigas.length ; m ++){
      		strConsulta = ActualizaBuscar.getBusquedaAsuntosAnidadosLigado(strDatosAsuntoLigas[m][0]);
      	
      out.write(__oracle_jsp_text[352]);
      if(par(m)==true){
      out.write(__oracle_jsp_text[353]);
      }else{
      out.write(__oracle_jsp_text[354]);
      }
      out.write(__oracle_jsp_text[355]);
      if(!strConsulta[0][1].equals("folio por asignar")){
      out.write(__oracle_jsp_text[356]);
      out.print( strConsulta[0][0] );
      out.write(__oracle_jsp_text[357]);
      out.print( Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[358]);
      out.print( strConsulta[0][1] );
      out.write(__oracle_jsp_text[359]);
      }else{
      out.write(__oracle_jsp_text[360]);
      out.print( strConsulta[0][0] );
      out.write(__oracle_jsp_text[361]);
      out.print( Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[362]);
      out.print( strConsulta[0][1] );
      out.write(__oracle_jsp_text[363]);
      }
      out.write(__oracle_jsp_text[364]);
      out.print(strDatosAsuntoLigas[m][1]);
      out.write(__oracle_jsp_text[365]);
      out.print( strGetAsuntoTurnado[0][23] );
      out.write(__oracle_jsp_text[366]);
      out.print(strDatosAsuntoLigas[m][1]);
      out.write(__oracle_jsp_text[367]);
      out.print(strConsulta[0][2]);
      out.write(__oracle_jsp_text[368]);
      out.print(strConsulta[0][3]);
      out.write(__oracle_jsp_text[369]);
      }
      out.write(__oracle_jsp_text[370]);
      }
      out.write(__oracle_jsp_text[371]);
      }
      out.write(__oracle_jsp_text[372]);
      out.print(Utilerias.formatearFechas(strGetAsuntoTurnado[0][38]) );
      out.write(__oracle_jsp_text[373]);
      if (strGetAsuntoTurnado[0][40].length() == 0 && strGetAsuntoTurnado[0][41].length() == 0){
      out.write(__oracle_jsp_text[374]);
      }else{
      out.write(__oracle_jsp_text[375]);
      out.print(strGetAsuntoTurnado[0][40] );
      out.write(__oracle_jsp_text[376]);
      out.print("0".equals(strGetAsuntoTurnado[0][41])?"00":strGetAsuntoTurnado[0][41] );
      out.write(__oracle_jsp_text[377]);
      }
      out.write(__oracle_jsp_text[378]);
      out.print(Utilerias.cambioSaltosDeLinea(strGetAsuntoTurnado[0][39]) );
      out.write(__oracle_jsp_text[379]);
       if(strGetAsuntoTurnado[0][22].length() != 0){ 
      out.write(__oracle_jsp_text[380]);
      if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){
      out.write(__oracle_jsp_text[381]);
      out.print(ActualizaPrioridad.getNombrePrioridad(strGetAsuntoTurnado[0][22]));
      out.write(__oracle_jsp_text[382]);
      out.print(strGetAsuntoTurnado[0][22]);
      out.write(__oracle_jsp_text[383]);
      }else{
      out.write(__oracle_jsp_text[384]);
      if(strDatosDes.length!=0){
      out.write(__oracle_jsp_text[385]);
      out.print(strDatosDes[0][13]);
      out.write(__oracle_jsp_text[386]);
      }else{
      out.write(__oracle_jsp_text[387]);
      out.print(ActualizaPrioridad.getNombrePrioridad(strGetAsuntoTurnado[0][22]));
      out.write(__oracle_jsp_text[388]);
      }
      out.write(__oracle_jsp_text[389]);
      out.print(strGetAsuntoTurnado[0][22]);
      out.write(__oracle_jsp_text[390]);
      }
      out.write(__oracle_jsp_text[391]);
       }else{ 
      out.write(__oracle_jsp_text[392]);
      
      						String strPrioridadArea[][] = null;
      						String strPrioridadGral[][] = null;
      						strPrioridadArea = ComboData.getPrioridadAreaCombo(BUsuario.getIdArea());
      						strPrioridadGral = ComboData.getPrioridadAreaComboGral();
      					
      out.write(__oracle_jsp_text[393]);
       for(int x=0;x<strPrioridadArea.length;x++){ 
      out.write(__oracle_jsp_text[394]);
      out.print(strPrioridadArea[x][0]);
      out.write(__oracle_jsp_text[395]);
      out.print(strPrioridadArea[x][1]);
      out.write(__oracle_jsp_text[396]);
       } 
      out.write(__oracle_jsp_text[397]);
       for(int x=0;x<strPrioridadGral.length;x++){ 
      out.write(__oracle_jsp_text[398]);
      out.print(strPrioridadGral[x][0]);
      out.write(__oracle_jsp_text[399]);
      out.print(strPrioridadGral[x][1]);
      out.write(__oracle_jsp_text[400]);
       } 
      out.write(__oracle_jsp_text[401]);
       } 
      out.write(__oracle_jsp_text[402]);
       if(strGetAsuntoTurnado[0][27].length() != 0){ 
      out.write(__oracle_jsp_text[403]);
      if(!(strGetAsuntoTurnado[0][28].equals("2") || strGetAsuntoTurnado[0][28].equals("3"))){
      out.write(__oracle_jsp_text[404]);
      out.print(ActualizaTipoAsunto.getNombreTipoAsunto(strGetAsuntoTurnado[0][27]));
      out.write(__oracle_jsp_text[405]);
      out.print(strGetAsuntoTurnado[0][27]);
      out.write(__oracle_jsp_text[406]);
      out.print(strGetAsuntoTurnado[0][27]);
      out.write(__oracle_jsp_text[407]);
      }else{
      out.write(__oracle_jsp_text[408]);
      if(strDatosDes.length!=0){
      out.write(__oracle_jsp_text[409]);
      out.print( strDatosDes[0][12] );
      out.write(__oracle_jsp_text[410]);
      }else{
      out.write(__oracle_jsp_text[411]);
      out.print(ActualizaTipoAsunto.getNombreTipoAsunto(strGetAsuntoTurnado[0][27]));
      out.write(__oracle_jsp_text[412]);
      }
      out.write(__oracle_jsp_text[413]);
      }
      out.write(__oracle_jsp_text[414]);
       }else{ 
      out.write(__oracle_jsp_text[415]);
      
      						String strTipoAsuntoArea[][] = null;
      						String strTipoAsuntoGral[][] = null;
      						strTipoAsuntoArea = ComboData.getTipoAsuntoAreaCombo(BUsuario.getIdArea());
      						strTipoAsuntoGral = ComboData.getTipoAsuntoAreaComboGral();
      					
      out.write(__oracle_jsp_text[416]);
       for(int s=0;s<strTipoAsuntoArea.length;s++){ 
      out.write(__oracle_jsp_text[417]);
      out.print(strTipoAsuntoArea[s][0]);
      out.write(__oracle_jsp_text[418]);
      out.print(strTipoAsuntoArea[s][1]);
      out.write(__oracle_jsp_text[419]);
       } 
      out.write(__oracle_jsp_text[420]);
       for(int s=0;s<strTipoAsuntoGral.length;s++){ 
      out.write(__oracle_jsp_text[421]);
      out.print(strTipoAsuntoGral[s][0]);
      out.write(__oracle_jsp_text[422]);
      out.print(strTipoAsuntoGral[s][1]);
      out.write(__oracle_jsp_text[423]);
       } 
      out.write(__oracle_jsp_text[424]);
       } 
      out.write(__oracle_jsp_text[425]);
       if(bExisteInstrucciones){ 
      out.write(__oracle_jsp_text[426]);
       int t = 0; 
      out.write(__oracle_jsp_text[427]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_23=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_23.setParent(null);
        __jsp_taghandler_23.setDatos(ActualizaInstrucciones.InstruccionPorIdAsunto(strIdAsunto));
        __jsp_taghandler_23.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_23,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[428]);
            if(campo1!=null){ 
            out.write(__oracle_jsp_text[429]);
            t++;
            out.write(__oracle_jsp_text[430]);
            if(par(t)==true){
            out.write(__oracle_jsp_text[431]);
            }else{
            out.write(__oracle_jsp_text[432]);
            }
            out.write(__oracle_jsp_text[433]);
            if("1".equals(campo17)){
            out.write(__oracle_jsp_text[434]);
            }else{
            out.write(__oracle_jsp_text[435]);
            }
            out.write(__oracle_jsp_text[436]);
            out.print( campo13 );
            out.write(__oracle_jsp_text[437]);
            
            								String strterminoUs = ActualizaInstrucciones.getUsuarioTermino(campo12);
            								if(strterminoUs.length()==0){
            								
            out.write(__oracle_jsp_text[438]);
            out.print(campo20);
            out.write(__oracle_jsp_text[439]);
            }else{
            out.write(__oracle_jsp_text[440]);
            out.print(strterminoUs);
            out.write(__oracle_jsp_text[441]);
            }
            out.write(__oracle_jsp_text[442]);
            out.print( ActualizaArea.NombreArea(campo10) );
            out.write(__oracle_jsp_text[443]);
             if(campo3.length() == 0){ 
            out.write(__oracle_jsp_text[444]);
            out.print( campo8 );
            out.write(__oracle_jsp_text[445]);
             }else{ 
            out.write(__oracle_jsp_text[446]);
            out.print( ActualizaInst.getNombreInstruccion1(campo3) );
            out.write(__oracle_jsp_text[447]);
             } 
            out.write(__oracle_jsp_text[448]);
             if(campo5.length() == 0){ 
            out.write(__oracle_jsp_text[449]);
             }else{ 
            out.write(__oracle_jsp_text[450]);
            out.print( Utilerias.formatearFechas(campo4) );
            out.write(__oracle_jsp_text[451]);
             } 
            out.write(__oracle_jsp_text[452]);
             if(campo5.length() == 0){ 
            out.write(__oracle_jsp_text[453]);
             }else{ 
            out.write(__oracle_jsp_text[454]);
            out.print( Utilerias.formatearFechas(campo5) );
            out.write(__oracle_jsp_text[455]);
             } 
            out.write(__oracle_jsp_text[456]);
            out.print( campo14 );
            out.write(__oracle_jsp_text[457]);
            
            									boolean bExistenFechas = false;
            									bExistenFechas = ActualizaAsuntoTurnado.tieneFechas(campo15);
            									if(bExistenFechas){
            								
            out.write(__oracle_jsp_text[458]);
            out.print( campo18 );
            out.write(__oracle_jsp_text[459]);
             }else{ 
            out.write(__oracle_jsp_text[460]);
             } 
            out.write(__oracle_jsp_text[461]);
            out.print( campo6 );
            out.write(__oracle_jsp_text[462]);
             if(campo7.equals("1")){ 
            out.write(__oracle_jsp_text[463]);
             if(campo17.equals("0")){ 
            out.write(__oracle_jsp_text[464]);
            if(BUsuario.getIdArea().equals(campo10)){
            out.write(__oracle_jsp_text[465]);
            out.print( campo12 );
            out.write(__oracle_jsp_text[466]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[467]);
            }else{
            out.write(__oracle_jsp_text[468]);
            }
            out.write(__oracle_jsp_text[469]);
             }else if(campo17.equals("1")){ 
            out.write(__oracle_jsp_text[470]);
            if(BUsuario.getIdArea().equals(campo10)){
            out.write(__oracle_jsp_text[471]);
            out.print( campo12 );
            out.write(__oracle_jsp_text[472]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[473]);
            }else{
            out.write(__oracle_jsp_text[474]);
            }
            out.write(__oracle_jsp_text[475]);
             } 
            out.write(__oracle_jsp_text[476]);
             }else if(campo7.equals("2")){ 
            out.write(__oracle_jsp_text[477]);
             if(campo17.equals("0")){ 
            out.write(__oracle_jsp_text[478]);
            if(BUsuario.getIdArea().equals(campo10)){
            out.write(__oracle_jsp_text[479]);
            out.print( campo12 );
            out.write(__oracle_jsp_text[480]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[481]);
            }else{
            out.write(__oracle_jsp_text[482]);
            }
            out.write(__oracle_jsp_text[483]);
             }else if(campo17.equals("1")){ 
            out.write(__oracle_jsp_text[484]);
            if(BUsuario.getIdArea().equals(campo10)){
            out.write(__oracle_jsp_text[485]);
            out.print( campo12 );
            out.write(__oracle_jsp_text[486]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[487]);
            }else{
            out.write(__oracle_jsp_text[488]);
            }
            out.write(__oracle_jsp_text[489]);
             } 
            out.write(__oracle_jsp_text[490]);
             }else if(campo7.equals("3")){ 
            out.write(__oracle_jsp_text[491]);
            if(BUsuario.getIdArea().equals(campo10)){
            out.write(__oracle_jsp_text[492]);
            out.print( campo12 );
            out.write(__oracle_jsp_text[493]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[494]);
            }else{
            out.write(__oracle_jsp_text[495]);
            }
            out.write(__oracle_jsp_text[496]);
             }else if(campo7.equals("4")){ 
            out.write(__oracle_jsp_text[497]);
             if(campo17.equals("0")){ 
            out.write(__oracle_jsp_text[498]);
            if(BUsuario.getIdArea().equals(campo10)){
            out.write(__oracle_jsp_text[499]);
            out.print( campo12 );
            out.write(__oracle_jsp_text[500]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[501]);
            }else{
            out.write(__oracle_jsp_text[502]);
            }
            out.write(__oracle_jsp_text[503]);
             }else if(campo17.equals("1")){ 
            out.write(__oracle_jsp_text[504]);
            if(BUsuario.getIdArea().equals(campo10)){
            out.write(__oracle_jsp_text[505]);
            out.print( campo12 );
            out.write(__oracle_jsp_text[506]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[507]);
            }else{
            out.write(__oracle_jsp_text[508]);
            }
            out.write(__oracle_jsp_text[509]);
            }
            out.write(__oracle_jsp_text[510]);
            }
            out.write(__oracle_jsp_text[511]);
            if("1".equals(campo19)){
            out.write(__oracle_jsp_text[512]);
            }else{
            out.write(__oracle_jsp_text[513]);
            }
            out.write(__oracle_jsp_text[514]);
            }
            out.write(__oracle_jsp_text[515]);
          } while (__jsp_taghandler_23.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,1);
      }
      out.write(__oracle_jsp_text[516]);
       } 
      out.write(__oracle_jsp_text[517]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_24=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_24.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[518]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_25=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_25.setParent(__jsp_taghandler_24);
              __jsp_taghandler_25.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[519]);
                } while (__jsp_taghandler_25.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,2);
            }
            out.write(__oracle_jsp_text[520]);
            {
              org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_26=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
              __jsp_taghandler_26.setParent(__jsp_taghandler_24);
              __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[521]);
                } while (__jsp_taghandler_26.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,2);
            }
            out.write(__oracle_jsp_text[522]);
          } while (__jsp_taghandler_24.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,1);
      }
      out.write(__oracle_jsp_text[523]);
       if(BUsuario.getIdUsuario().equals(strGetAsuntoTurnado[0][32]) ||
      						(BUsuario.getTurnado() && BUsuario.getIdArea().equals(strGetAsuntoTurnado[0][33]))){ 
      out.write(__oracle_jsp_text[524]);
       if(strActivarCM.equals("si")){ 
      	                      
      out.write(__oracle_jsp_text[525]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[526]);
      out.print(strGetAsuntoTurnado[0][23] );
      out.write(__oracle_jsp_text[527]);
      out.print(bInst );
      out.write(__oracle_jsp_text[528]);
      out.print(strGetAsuntoTurnado[0][28]);
      out.write(__oracle_jsp_text[529]);
       }
      					else{ 
      out.write(__oracle_jsp_text[530]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[531]);
      out.print(strGetAsuntoTurnado[0][23] );
      out.write(__oracle_jsp_text[532]);
      out.print(bInst );
      out.write(__oracle_jsp_text[533]);
      out.print(strGetAsuntoTurnado[0][28]);
      out.write(__oracle_jsp_text[534]);
       }
      out.write(__oracle_jsp_text[535]);
       
      				}else{ 
      out.write(__oracle_jsp_text[536]);
       
      					if(strActivarCM.equals("no")){ 					
      	                    
      out.write(__oracle_jsp_text[537]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[538]);
      out.print(strGetAsuntoTurnado[0][23] );
      out.write(__oracle_jsp_text[539]);
      out.print(bInst );
      out.write(__oracle_jsp_text[540]);
      out.print(strGetAsuntoTurnado[0][28]);
      out.write(__oracle_jsp_text[541]);
       }
      					else{ 
      out.write(__oracle_jsp_text[542]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[543]);
      out.print(strGetAsuntoTurnado[0][23] );
      out.write(__oracle_jsp_text[544]);
      out.print(bInst );
      out.write(__oracle_jsp_text[545]);
      out.print(strGetAsuntoTurnado[0][28]);
      out.write(__oracle_jsp_text[546]);
       
      						} 
      out.write(__oracle_jsp_text[547]);
       
      				} 
      out.write(__oracle_jsp_text[548]);
       if(bExisteHistorial){ 
      out.write(__oracle_jsp_text[549]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_27=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_27.setParent(null);
        __jsp_taghandler_27.setDatos(ActualizaComentario.getDatosComentarios(strIdAsunto));
        __jsp_taghandler_27.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_27,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[550]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[551]);
            out.print( campo3 );
            out.write(__oracle_jsp_text[552]);
            out.print( Utilerias.cambioSaltosDeLinea(campo1) );
            out.write(__oracle_jsp_text[553]);
          } while (__jsp_taghandler_27.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,1);
      }
      out.write(__oracle_jsp_text[554]);
       }else{ 
      out.write(__oracle_jsp_text[555]);
       } 
      out.write(__oracle_jsp_text[556]);
      out.print(nombre);
      out.write(__oracle_jsp_text[557]);
       if(carga != null && carga.equals("1")){ 
      out.write(__oracle_jsp_text[558]);
       } 
      out.write(__oracle_jsp_text[559]);
       if(strReload.equals("0")){ 
      out.write(__oracle_jsp_text[560]);
      out.print(retURI);
      out.write(__oracle_jsp_text[561]);
      }
      out.write(__oracle_jsp_text[562]);
       if (folioControl!=null && folioControl.equals("1")){ 
      out.write(__oracle_jsp_text[563]);
      out.print( strGetAsuntoTurnado[0][23]);
      out.write(__oracle_jsp_text[564]);
       } 
      out.write(__oracle_jsp_text[565]);
      out.print( bValidaEstatus );
      out.write(__oracle_jsp_text[566]);

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
  private static final char __oracle_jsp_text[][]=new char[567][];
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
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\n<!-- Este bloque contiene la Sesión de una usuario -->\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n<!-- Fin codigo Sesión -->\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n<script type=\"text/javascript\">\nalert(\"La secuencia de pasos es incorrecta, favor de verificar la Ruta de atención\\n\\nSe requiere al menos una instruccion con paso 1\");\n</script>\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<META HTTP-EQUIV=\"Pragma\" CONTENT=\"no-cache\">\n<META HTTP-EQUIV=\"Expires\" CONTENT=\"-1\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/link.css\" />\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\" src=\"../js/link.js\"></script>\n<TITLE>Asunto Turnado</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n\n\tvalid = 0;\n\tvar botonBandera = true;\n\t\n\tfunction Set(elemento)\n\t{\n\t\telemento.style.border=\" 1px solid #eeeeee \"\n\t}\n\tfunction unSet(elemento)\n\t{\n\t\telemento.style.border=\" 0px solid #000000 \"\n\t}\n\n\tfunction EditarAsunto(){\n\t\tlocation.assign('Asuntos.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[17] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[18] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[19] = 
    "');\n\t}\n\tfunction ComentarioAsunto(){\n\t\tlocation.assign('Comentarios.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[20] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[21] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[22] = 
    "');\n\t}\n\tfunction agregarContent(){\n\t\tlocation.assign('ImportarCM.jsp?Folio=".toCharArray();
    __oracle_jsp_text[23] = 
    "&IdAsunto=".toCharArray();
    __oracle_jsp_text[24] = 
    "&a=1&estValidacion=".toCharArray();
    __oracle_jsp_text[25] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[26] = 
    "');\n\t}\n\tfunction listadoContent() {\n\t\tvar url = '".toCharArray();
    __oracle_jsp_text[27] = 
    "/eclient/SIGMA/Buscar.jsp?id=".toCharArray();
    __oracle_jsp_text[28] = 
    "&bo=true&it=".toCharArray();
    __oracle_jsp_text[29] = 
    "';\n\t\twindow.open(url)\n\t}\n\tfunction agregar(){\n\t\tvar frameNvaRef = '".toCharArray();
    __oracle_jsp_text[30] = 
    "/eclient/SIGMA/Avance.jsp?id=".toCharArray();
    __oracle_jsp_text[31] = 
    "&bo=true&it=".toCharArray();
    __oracle_jsp_text[32] = 
    "';\n\t\tdocument.getElementById('frame1').src  = frameNvaRef;\n\t}\n\tfunction exportar(){\n\t\twindow.open(\"../AsuntoWord?id=\"+".toCharArray();
    __oracle_jsp_text[33] = 
    ");\n\t}\n\tfunction escaner(){\n\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\tlocation.assign('sigmaCM:%20".toCharArray();
    __oracle_jsp_text[35] = 
    "/eclient/ArchivoCM%20".toCharArray();
    __oracle_jsp_text[36] = 
    "%20escanear%20false%20".toCharArray();
    __oracle_jsp_text[37] = 
    "%20".toCharArray();
    __oracle_jsp_text[38] = 
    "%20".toCharArray();
    __oracle_jsp_text[39] = 
    "');\n\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\tlocation.assign('sigmaCM:%20".toCharArray();
    __oracle_jsp_text[41] = 
    "/ArchivoCM%20".toCharArray();
    __oracle_jsp_text[42] = 
    "%20escanear%20true%20".toCharArray();
    __oracle_jsp_text[43] = 
    "%20".toCharArray();
    __oracle_jsp_text[44] = 
    "%20".toCharArray();
    __oracle_jsp_text[45] = 
    "');\n\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t}\n\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\tfunction archivado(){\n\t\tlocation.assign('ArchivadoAsunto.jsp?idAsunto=".toCharArray();
    __oracle_jsp_text[48] = 
    "&asunto=".toCharArray();
    __oracle_jsp_text[49] = 
    "&area=".toCharArray();
    __oracle_jsp_text[50] = 
    "&a=1');\n\t}\n\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\tfunction archivado(){\n\t\tlocation.assign('ArchivadoAsunto.jsp?idAsunto=".toCharArray();
    __oracle_jsp_text[52] = 
    "&asunto=".toCharArray();
    __oracle_jsp_text[53] = 
    "&area=".toCharArray();
    __oracle_jsp_text[54] = 
    "');\n\t}\n\t".toCharArray();
    __oracle_jsp_text[55] = 
    "\n\n\tfunction mailNoty(){\n\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\n\tfola = \"".toCharArray();
    __oracle_jsp_text[62] = 
    "\";\n\tfolb = \"".toCharArray();
    __oracle_jsp_text[63] = 
    "\";\n\tasu = fola.replace(\"-\", \"_\");\n\tfoliom = folb.replace(\"-\", \"_\");\n\twindow.open(\"MailNoty.jsp?id_asunto=\"+".toCharArray();
    __oracle_jsp_text[64] = 
    "+\"&asunto=\"+asu+\"&foliom=\"+foliom+\"&mailsend=".toCharArray();
    __oracle_jsp_text[65] = 
    "\",null,\"toolbar=no,status=yes,scrollbars=yes\");\n\t}\n\n</SCRIPT>\n<STYLE type=text/css>\nBODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"timer_load();\"\n\tonKeyPress=\"timer_load();timer_reload();\"\n\tonClick=\"timer_load();timer_reload();\">\n<FORM name=\"asuntoTurnado\" action=\"AsuntoTurnado.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\"> <INPUT\n\ttype=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[66] = 
    "\" name=\"id_asunto\"> <INPUT\n\tname=\"retURI\" value=\"".toCharArray();
    __oracle_jsp_text[67] = 
    "\" type=\"hidden\"> <INPUT\n\tname=\"retURI2\" value=\"".toCharArray();
    __oracle_jsp_text[68] = 
    "\" type=\"hidden\"> <INPUT\n\tname=\"avanceAsunto\" value=\"".toCharArray();
    __oracle_jsp_text[69] = 
    "\" type=\"hidden\"> <INPUT\n\tname=\"NombreAsu\" value=\"".toCharArray();
    __oracle_jsp_text[70] = 
    "\" type=\"hidden\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[71] = 
    "\" name=\"estValidacion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"99%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[72] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD align=\"center\"><FONT size=\"3\" color=\"red\"><B>No\n\t\t\ttiene Pasos Configurados</B></FONT></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<BR>\n".toCharArray();
    __oracle_jsp_text[73] = 
    "\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"863\">\n\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">Asunto En Recepci&oacute;n</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[75] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">Asunto Por Turnar</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[76] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">Asunto En Tr&aacute;mite</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">Asunto Terminado</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n\t\t</td>\n\t</tr>\n</table>\n</DIV>\n<BR />\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"863\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"5%\"><A href=\"".toCharArray();
    __oracle_jsp_text[79] = 
    "\"\n\t\t\t\tonMouseOver=\"document.MyImage.src='../Imagenes/NavLeft2.gif';\"\n\t\t\t\tonMouseOut=\"document.MyImage.src='../Imagenes/NavLeft.gif';\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar / Cancelar\"\n\t\t\t\tname=\"MyImage\"></A></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[81] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[82] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[83] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[85] = 
    "\n\t\t\t\t\t<TD></TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[86] = 
    "\n\t\t\t\t\t<TD width=\"5%\"><A\n\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; EditarAsunto();}\"\n\t\t\t\t\t\tonMouseOver=\"document.Editar.src='../Imagenes/Editar2.gif';\"\n\t\t\t\t\t\tonMouseOut=\"document.Editar.src='../Imagenes/Editar.gif';\"> <IMG\n\t\t\t\t\t\tborder=\"0\" src=\"../Imagenes/Editar.gif\" alt=\"Modificar Datos\"\n\t\t\t\t\t\tname=\"Editar\"></A></TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[87] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[88] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[89] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[90] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[91] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[92] = 
    "\n\t\t\t\t\t<td></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[93] = 
    "\n\t\t\t\t\t<td width=\"5%\"><a\n\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarContent();}\"\n\t\t\t\t\t\tonMouseOver=\"document.Insertar.src='../Imagenes/Attach2.gif';\"\n\t\t\t\t\t\tonMouseOut=\"document.Insertar.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\" alt=\"Insertar Archivo\"\n\t\t\t\t\t\tname=\"Insertar\"></a></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[94] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[95] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[96] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[97] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[98] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[99] = 
    "\n\t\t\t\t\t<td></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[100] = 
    "\n\t\t\t\t\t<TD width=\"5%\"><a\n\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; ComentarioAsunto();}\"\n\t\t\t\t\t\tonMouseOver=\"document.Comentario.src='../Imagenes/Comentario2.gif';\"\n\t\t\t\t\t\tonMouseOut=\"document.Comentario.src='../Imagenes/Comentario.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Comentario.gif\"\n\t\t\t\t\t\talt=\"Crear un Comentario\" name=\"Comentario\"></A></TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[101] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[102] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[103] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[105] = 
    "\n\t\t\t\t\t<TD width=\"5%\"><A\n\t\t\t\t\t\tonclick=\"if(botonBandera){Imprimir1(".toCharArray();
    __oracle_jsp_text[106] = 
    ");}\"\n\t\t\t\t\t\tonMouseOver=\"document.Imprimir.src='../Imagenes/Imprimir2.gif';\"\n\t\t\t\t\t\tonMouseOut=\"document.Imprimir.src='../Imagenes/Imprimir.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Imprimir.gif\" alt=\"Imprimir\"\n\t\t\t\t\t\tname=\"Imprimir\"></A></TD>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[107] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[108] = 
    "\n\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[109] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[110] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[111] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[112] = 
    "\n\t\t\t\t\t<td></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[113] = 
    "\n\t\t\t\t\t<TD width=\"5%\"><A\n\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; location.assign('NotificacionCiudadano.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[114] = 
    "');}\"\n\t\t\t\t\t\tonMouseOver=\"document.Editar1.src='../Imagenes/RespuestaCiudadana2.gif';\"\n\t\t\t\t\t\tonMouseOut=\"document.Editar1.src='../Imagenes/RespuestaCiudadana.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/RespuestaCiudadana.gif\"\n\t\t\t\t\t\talt=\"Ver Respuesta del Ciudadano\" name=\"Editar1\"> </A></TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[115] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[116] = 
    "\n\t\t\t\t\t<TD></TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[117] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[118] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[119] = 
    "\n\t\t\t\t\t<td></td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[120] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[121] = 
    "\n\n\t\t\t".toCharArray();
    __oracle_jsp_text[122] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[123] = 
    "\n\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[124] = 
    "\n\t\t\t\t\t<TD width=\"5%\">\n\t\t\t\t\t<DIV align=\"left\"><A\n\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaApplet1();}\"\n\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\"\n\t\t\t\t\t\talt=\"Ver Ruta de Atenci&oacute;n\" name=\"CrearRuta\"></A>&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[125] = 
    " <A\n\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; turnar();}\"\n\t\t\t\t\t\tonMouseOver=\"document.Turnar.src='../Imagenes/Turnar2.gif';\"\n\t\t\t\t\t\tonMouseOut=\"document.Turnar.src='../Imagenes/Turnar.gif';\"><IMG\n\t\t\t\t\t\tborder=\"0\" src=\"../Imagenes/Turnar.gif\" alt=\"Turnar\" name=\"Turnar\"></A>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[126] = 
    "\n\t\t\t\t\t</DIV>\n\t\t\t\t\t</TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[127] = 
    "\n\t\t\t\t\t<!-- aplica lo del nuevo turnado -->\n\t\t\t\t\t<TD width=\"5%\">\n\t\t\t\t\t<DIV align=\"left\"><A\n\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaApplet1();}\"\n\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\"\n\t\t\t\t\t\talt=\"Ver Ruta de Atenci&oacute;n\" name=\"CrearRuta\"></A>&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[128] = 
    "\n\t\t\t\t\t<A onclick=\"if(botonBandera){botonBandera=false; turnarNuevo();}\"\n\t\t\t\t\t\tonMouseOver=\"document.Turnar.src='../Imagenes/Turnar2.gif';\"\n\t\t\t\t\t\tonMouseOut=\"document.Turnar.src='../Imagenes/Turnar.gif';\"><IMG\n\t\t\t\t\t\tborder=\"0\" src=\"../Imagenes/Turnar.gif\" alt=\"Turnar\" name=\"Turnar\"></A>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[129] = 
    "\n\t\t\t\t\t</DIV>\n\t\t\t\t\t</TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[130] = 
    "\n\t\t\t\t\t<TD></TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[131] = 
    "\n\t\t\t\t\t<TD width=\"5%\">\n\t\t\t\t\t<DIV align=\"left\"><A\n\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaAppletTur();}\"\n\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\" alt=\"Crear Ruta\"\n\t\t\t\t\t\tname=\"CrearRuta\"></A></DIV>\n\t\t\t\t\t</TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[132] = 
    "\n\t\t\t\t\t<TD width=\"5%\">\n\t\t\t\t\t<DIV align=\"left\"><A\n\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaAppletTur();}\"\n\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\" alt=\"Crear Ruta\"\n\t\t\t\t\t\tname=\"CrearRuta\"></A></DIV>\n\t\t\t\t\t</TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[133] = 
    "\n\t\t\t\t\t<TD width=\"5%\">\n\t\t\t\t\t<DIV align=\"left\"><A\n\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaAppletTur();}\"\n\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\" alt=\"Crear Ruta\"\n\t\t\t\t\t\tname=\"CrearRuta\"></A></DIV>\n\t\t\t\t\t</TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[134] = 
    "\n\t\t\t\t\t<TD width=\"5%\">\n\t\t\t\t\t<DIV align=\"left\"><A\n\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cargaApplet2();}\"\n\t\t\t\t\t\tonMouseOver=\"document.CrearRuta.src='../Imagenes/CrearRuta2.gif';\"\n\t\t\t\t\t\tonMouseOut=\"document.CrearRuta.src='../Imagenes/CrearRuta.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CrearRuta.gif\" alt=\"Crear Ruta\"\n\t\t\t\t\t\tname=\"CrearRuta\"></A></DIV>\n\t\t\t\t\t</TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[135] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[136] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[137] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[138] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[139] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[140] = 
    "\n\t\t\t\t\t<TD width=\"5%\"><A onclick=\"if(botonBandera){botonBandera=false; recuperarAsunto();}\"\n\t\t\t\t\t\tonMouseOver=\"document.recuperar.src='../Imagenes/recuperarOn.gif';\"\n\t\t\t\t\t\tonMouseOut=\"document.recuperar.src='../Imagenes/recuperarOff.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/recuperarOff.gif\" alt=\"Recuperar Asunto\"\n\t\t\t\t\t\tname=\"recuperar\"></A></TD>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[141] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[142] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[143] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[144] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[145] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[146] = 
    "\n\t\t\t\t\t<td width=\"5%\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[147] = 
    " ".toCharArray();
    __oracle_jsp_text[148] = 
    "\n\t\t\t\t\t</td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[149] = 
    "\n\t\t\t\t\t<TD width=\"5%\"><A\n\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; finalizar();}\"\n\t\t\t\t\t\tonMouseOver=\"document.Responder.src='../Imagenes/RegresarD.png';\"\n\t\t\t\t\t\tonMouseOut=\"document.Responder.src='../Imagenes/Regresar.png';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Regresar.png\"\n\t\t\t\t\t\talt=\"Terminar Asunto\" name=\"Responder\"></A></TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[150] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[151] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[152] = 
    "\n\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[153] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[154] = 
    "\n\t\t\t<TD width=\"35%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n".toCharArray();
    __oracle_jsp_text[155] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[156] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[157] = 
    "\n\t\t\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">\n\t\t\t\t\t<INPUT name=\"CHNotificar\" type=\"checkbox\"  value=\"0\"\n\t\t\t\t\t\tonclick=\"activarNotificarA()\">Notificar a: </FONT></TD>\n\t\t\t\t\t<TD width=\"533\">".toCharArray();
    __oracle_jsp_text[158] = 
    "\n\t\t\t\t\t</TD>\n\t\t\t\t\t<td width=\"67\">&nbsp;</td>\n\t\t\t\t\t<td width=\"80\">&nbsp;</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[159] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[160] = 
    "\n\t\t\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t\t\t<td width=\"233\">&nbsp;</td>\n\t\t\t\t\t<td width=\"67\">&nbsp;</td>\n\t\t\t\t\t<td width=\"380\">&nbsp;</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[161] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[162] = 
    "\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[163] = 
    "<BR>\n".toCharArray();
    __oracle_jsp_text[164] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD><font size=\"2\" color=\"red\" face=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[165] = 
    "\n\t\t\t</font></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[166] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\t\tface=\"Arial\">Datos Generales</font></b></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"863\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</tr>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t<TD width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t<TD width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t<TD width=\"380\">\n\t\t\t<DIV align=\"right\">Capturado por: ".toCharArray();
    __oracle_jsp_text[167] = 
    "\n\t\t\t- ".toCharArray();
    __oracle_jsp_text[168] = 
    "<BR>\n\t\t\tEstatus: ".toCharArray();
    __oracle_jsp_text[169] = 
    "<B>Terminado</B>\n\t\t\t".toCharArray();
    __oracle_jsp_text[170] = 
    "<B>Turnado</B> ".toCharArray();
    __oracle_jsp_text[171] = 
    "<B>Por\n\t\t\tTurnar</B> ".toCharArray();
    __oracle_jsp_text[172] = 
    "<B>Recepci&oacute;n</B>\n\t\t\t".toCharArray();
    __oracle_jsp_text[173] = 
    " <BR>\n\t\t\tFolio de Identificador: <B>".toCharArray();
    __oracle_jsp_text[174] = 
    "</B><BR>\n\t\t\tFolio de Control: <B>".toCharArray();
    __oracle_jsp_text[175] = 
    "</B></DIV>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t<TD width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t<TD width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t<TD width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV class=documentBody id=Body>\n<DIV align=\"center\">\n\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD><B><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos\n\t\t\tdel Remitente</font></B></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Entidad:</FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[176] = 
    "\n\t\t\t<TD width=\"660\" colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[177] = 
    " <FONT face=\"Arial\"\n\t\t\t\tsize=\"2\"> ".toCharArray();
    __oracle_jsp_text[178] = 
    " </FONT> ".toCharArray();
    __oracle_jsp_text[179] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[180] = 
    "\n\t\t\t</FONT> ".toCharArray();
    __oracle_jsp_text[181] = 
    " <FONT face=\"Arial\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[182] = 
    "\n\t\t\t</FONT> ".toCharArray();
    __oracle_jsp_text[183] = 
    "\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[184] = 
    "\n\t\t\t<TD width=\"660\" colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[185] = 
    " <FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[186] = 
    "</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[187] = 
    " ".toCharArray();
    __oracle_jsp_text[188] = 
    " <FONT\n\t\t\t\tface=\"Arial\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[189] = 
    " </FONT> ".toCharArray();
    __oracle_jsp_text[190] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[191] = 
    "\n\t\t\t</FONT> ".toCharArray();
    __oracle_jsp_text[192] = 
    " <FONT face=\"Arial\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[193] = 
    "\n\t\t\t</FONT> ".toCharArray();
    __oracle_jsp_text[194] = 
    " ".toCharArray();
    __oracle_jsp_text[195] = 
    "\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[196] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">De:</FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[197] = 
    "\n\t\t\t<TD width=\"660\" colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[198] = 
    " <FONT face=\"Arial\"\n\t\t\t\tsize=\"2\"> ".toCharArray();
    __oracle_jsp_text[199] = 
    "\n\t\t\t/ ".toCharArray();
    __oracle_jsp_text[200] = 
    " </FONT> ".toCharArray();
    __oracle_jsp_text[201] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[202] = 
    " / ".toCharArray();
    __oracle_jsp_text[203] = 
    "\n\t\t\t</FONT> ".toCharArray();
    __oracle_jsp_text[204] = 
    "\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[205] = 
    "\n\t\t\t<TD width=\"660\" colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[206] = 
    " <FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[207] = 
    "\n\t\t\t/ ".toCharArray();
    __oracle_jsp_text[208] = 
    "</FONT> ".toCharArray();
    __oracle_jsp_text[209] = 
    " ".toCharArray();
    __oracle_jsp_text[210] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[211] = 
    "\n\t\t\t/ ".toCharArray();
    __oracle_jsp_text[212] = 
    " </FONT> ".toCharArray();
    __oracle_jsp_text[213] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[214] = 
    " / ".toCharArray();
    __oracle_jsp_text[215] = 
    "\n\t\t\t</FONT> ".toCharArray();
    __oracle_jsp_text[216] = 
    " ".toCharArray();
    __oracle_jsp_text[217] = 
    "\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[218] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t</TR>\n\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">\n\t\t\tFirmante: </FONT></TD>\n\t\t\t<TD width=\"660\" colspan=\"3\"><FONT face=\"Arial\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[219] = 
    " </FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">\n\t\t\tDocumento de: </FONT></TD>\n\t\t\t<TD width=\"660\" colspan=\"3\"><FONT face=\"Arial\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[220] = 
    " Entrada ".toCharArray();
    __oracle_jsp_text[221] = 
    " Salida\n\t\t\t".toCharArray();
    __oracle_jsp_text[222] = 
    " </FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD><B><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos\n\t\t\tde Ventanilla</font></B></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Responsable\n\t\t\tdel Turno: </FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[223] = 
    "\n\t\t\t<TD width=\"660\" colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[224] = 
    " <FONT face=\"Arial\"\n\t\t\t\tsize=\"2\"> </FONT> ".toCharArray();
    __oracle_jsp_text[225] = 
    " <FONT face=\"Arial\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[226] = 
    " ".toCharArray();
    __oracle_jsp_text[227] = 
    " </FONT> ".toCharArray();
    __oracle_jsp_text[228] = 
    "\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[229] = 
    "\n\t\t\t<TD width=\"660\" colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[230] = 
    " <FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[231] = 
    "</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[232] = 
    " ".toCharArray();
    __oracle_jsp_text[233] = 
    " <FONT face=\"Arial\"\n\t\t\t\tsize=\"2\"> </FONT> ".toCharArray();
    __oracle_jsp_text[234] = 
    " <FONT face=\"Arial\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[235] = 
    " ".toCharArray();
    __oracle_jsp_text[236] = 
    " </FONT> ".toCharArray();
    __oracle_jsp_text[237] = 
    " ".toCharArray();
    __oracle_jsp_text[238] = 
    "\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[239] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD><B><font size=\"2\" color=\"#004080\" face=\"Arial\">Destinatarios</font></B></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD><font size=\"2\" color=\"#004080\" face=\"Arial\">Receptor&nbsp;Interno<BR>\n\t\t\tde la SHCP</font></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Para:</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"660\" colspan=\"3\"><FONT face=\"Arial\" size=\"1\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[240] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[241] = 
    " ".toCharArray();
    __oracle_jsp_text[242] = 
    "<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[243] = 
    " ".toCharArray();
    __oracle_jsp_text[244] = 
    " ".toCharArray();
    __oracle_jsp_text[245] = 
    " ".toCharArray();
    __oracle_jsp_text[246] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[247] = 
    "<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[248] = 
    " ".toCharArray();
    __oracle_jsp_text[249] = 
    " ".toCharArray();
    __oracle_jsp_text[250] = 
    " ".toCharArray();
    __oracle_jsp_text[251] = 
    "<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[252] = 
    " ".toCharArray();
    __oracle_jsp_text[253] = 
    " ".toCharArray();
    __oracle_jsp_text[254] = 
    " </FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Ccp:</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"660\" colspan=\"3\"><FONT face=\"Arial\" size=\"1\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[255] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[256] = 
    " \n\t\t\t\t   ".toCharArray();
    __oracle_jsp_text[257] = 
    "<br>\n\t\t\t    ".toCharArray();
    __oracle_jsp_text[258] = 
    " \n\t\t\t".toCharArray();
    __oracle_jsp_text[259] = 
    " \n\t\t\t   ".toCharArray();
    __oracle_jsp_text[260] = 
    " \n\t\t\t        ".toCharArray();
    __oracle_jsp_text[261] = 
    "\n\t\t\t           ".toCharArray();
    __oracle_jsp_text[262] = 
    "<br>\n\t\t\t         ".toCharArray();
    __oracle_jsp_text[263] = 
    " \n\t\t\t    ".toCharArray();
    __oracle_jsp_text[264] = 
    " \n\t\t\t       ".toCharArray();
    __oracle_jsp_text[265] = 
    " \n\t\t\t\t\t   ".toCharArray();
    __oracle_jsp_text[266] = 
    "<br>\n\t\t\t        ".toCharArray();
    __oracle_jsp_text[267] = 
    " \n\t\t\t    ".toCharArray();
    __oracle_jsp_text[268] = 
    " \n\t\t\t ".toCharArray();
    __oracle_jsp_text[269] = 
    " </FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD><font size=\"2\" color=\"#004080\" face=\"Arial\">Receptor&nbsp;Externos</font></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Para:</FONT></TD>\n\t\t\t<TD width=\"660\" colspan=\"3\"><FONT face=\"Arial\" size=\"1\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[270] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[271] = 
    " ".toCharArray();
    __oracle_jsp_text[272] = 
    "<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[273] = 
    " ".toCharArray();
    __oracle_jsp_text[274] = 
    " ".toCharArray();
    __oracle_jsp_text[275] = 
    " ".toCharArray();
    __oracle_jsp_text[276] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[277] = 
    "<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[278] = 
    " ".toCharArray();
    __oracle_jsp_text[279] = 
    " ".toCharArray();
    __oracle_jsp_text[280] = 
    " ".toCharArray();
    __oracle_jsp_text[281] = 
    "<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[282] = 
    " ".toCharArray();
    __oracle_jsp_text[283] = 
    " ".toCharArray();
    __oracle_jsp_text[284] = 
    " </FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD><B><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos\n\t\t\tdel Asunto</font></B></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Asunto:</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"660\" colspan=\"3\"><FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[285] = 
    "</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Tipo\n\t\t\tde Documento:</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[286] = 
    "\n\t\t\t<TD width=\"660\" colspan=\"3\"><FONT face=\"Arial\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[287] = 
    "\n\t\t\t<INPUT type=\"hidden\" name=\"esRecepcion\" value=\"2\"></FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[288] = 
    "\n\t\t\t<TD width=\"660\" colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[289] = 
    " <FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[290] = 
    "</FONT>\n\t\t\t<INPUT type=\"hidden\" name=\"esRecepcion\" value=\"2\"> ".toCharArray();
    __oracle_jsp_text[291] = 
    " <FONT\n\t\t\t\tface=\"Arial\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[292] = 
    "\n\t\t\t<INPUT type=\"hidden\" name=\"esRecepcion\" value=\"2\"></FONT> ".toCharArray();
    __oracle_jsp_text[293] = 
    "\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[294] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\n\t\t<tr valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fecha\n\t\t\tde recepci&oacute;n del documento:</FONT></TD>\n\t\t\t<TD width=\"233\"><FONT face=\"Arial\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[295] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[296] = 
    " ".toCharArray();
    __oracle_jsp_text[297] = 
    "&nbsp;".toCharArray();
    __oracle_jsp_text[298] = 
    "\n\t\t\t</FONT></TD>\n\t\t\t<td width=\"107\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Hora\n\t\t\tde Recepci&oacute;n:</font></td>\n\t\t\t<TD width=\"249\"><FONT face=\"Arial\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[299] = 
    ":".toCharArray();
    __oracle_jsp_text[300] = 
    "\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"289\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fecha\n\t\t\tdel documento:</font></td>\n\t\t\t<TD><FONT face=\"Arial\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[301] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[302] = 
    " ".toCharArray();
    __oracle_jsp_text[303] = 
    "\n\t\t\t&nbsp; ".toCharArray();
    __oracle_jsp_text[304] = 
    " </FONT></TD>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"289\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Tr&aacute;mite:</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[305] = 
    "\n\t\t\t<TD width=\"660\" colspan=\"3\"><FONT face=\"Arial\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[306] = 
    " ".toCharArray();
    __oracle_jsp_text[307] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[308] = 
    " No tiene Trámite ".toCharArray();
    __oracle_jsp_text[309] = 
    " </FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[310] = 
    "\n\t\t\t<TD width=\"660\" colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[311] = 
    " <FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[312] = 
    "</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[313] = 
    " <FONT face=\"Arial\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[314] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[315] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[316] = 
    " No tiene Tr&aacute;mite ".toCharArray();
    __oracle_jsp_text[317] = 
    " </FONT> ".toCharArray();
    __oracle_jsp_text[318] = 
    "\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[319] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha\n\t\t\tcompromiso:</font></td>\n\t\t\t<TD><FONT face=\"Arial\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[320] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[321] = 
    " ".toCharArray();
    __oracle_jsp_text[322] = 
    "\n\t\t\t&nbsp; ".toCharArray();
    __oracle_jsp_text[323] = 
    " </FONT></TD>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\">&nbsp;</td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"289\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Identificador\n\t\t\tdel documento:</font></td>\n\t\t\t<TD width=\"250\"><FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[324] = 
    "</FONT></TD>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Folio\n\t\t\tIntermedio:<BR>\n\t\t\t(VDG, VOM, VSP, etc.)</font></td>\n\t\t\t<TD width=\"250\"><FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[325] = 
    "</FONT></TD>\n\t\t</tr>\n\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Descripci&oacute;n:</FONT></TD>\n\t\t\t<TD width=\"660\" colspan=\"3\"><FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[326] = 
    "</FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Comentarios:</FONT></TD>\n\t\t\t<TD width=\"660\" colspan=\"3\"><FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[327] = 
    "</FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Palabra\n\t\t\tClave:</FONT></TD>\n\t\t\t<TD width=\"660\" colspan=\"3\"><FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[328] = 
    "</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD><B><font size=\"2\" color=\"#004080\" face=\"Arial\">Expediente</font></B></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t\t<TD><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\t\twidth=\"1\" alt=\"\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"4\"><IFRAME\n\t\t\t\tsrc=\"ExpedienteInstrccion.jsp?strIdAsunto=".toCharArray();
    __oracle_jsp_text[329] = 
    "\"\n\t\t\t\tWIDTH=800 HEIGHT=100 frameborder=0 id=\"Entidad\"></IFRAME></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD width=\"289\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<BR>\n".toCharArray();
    __oracle_jsp_text[330] = 
    " ".toCharArray();
    __oracle_jsp_text[331] = 
    "\n<DIV align=\"center\">\n<TABLE>\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD align=\"center\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\"><b>Relaciones\n\t\t\tAnexadas</b></FONT></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE border=\"0\">\n\t<TR bgcolor=\"#00204f\">\n\t\t<TD width=\"438\" align=\"center\"><FONT size=\"1\" color=\"#ffffff\"\n\t\t\tface=\"verdana\">Folio / Tipo de Relaci&oacute;n</FONT></TD>\n\t\t<TD width=\"200\" align=\"center\"><FONT size=\"1\" color=\"#ffffff\"\n\t\t\tface=\"verdana\">Folio Documento</FONT></TD>\n\t\t<TD width=\"194\" align=\"center\"><FONT size=\"1\" color=\"#ffffff\"\n\t\t\tface=\"verdana\">Estatus</FONT></TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[332] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[333] = 
    "\n\t<TR ".toCharArray();
    __oracle_jsp_text[334] = 
    " ".toCharArray();
    __oracle_jsp_text[335] = 
    " bgcolor=\"#f6f6f6\" ".toCharArray();
    __oracle_jsp_text[336] = 
    ">\n\t\t<TD width=\"438\" align=\"left\">".toCharArray();
    __oracle_jsp_text[337] = 
    "&nbsp;es&nbsp;".toCharArray();
    __oracle_jsp_text[338] = 
    "&nbsp;de&nbsp;\n\t\t<A\n\t\t\thref=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[339] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[340] = 
    "\">\n\t\t<FONT size=\"1\" color=\"#004080\" face=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[341] = 
    "</FONT></A>\n\t\t</TD>\n\t\t<!-- <td width=\"274\" align=\"center\"><FONT size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">".toCharArray();
    __oracle_jsp_text[342] = 
    "</FONT></td> -->\n\t\t<td width=\"200\" align=\"center\"><FONT size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">".toCharArray();
    __oracle_jsp_text[343] = 
    "</FONT></td>\n\t\t<td width=\"194\" align=\"center\"><FONT size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[344] = 
    "\n\t\t\tAsunto En Recepci&oacute;n\n\t\t".toCharArray();
    __oracle_jsp_text[345] = 
    "\n\t\t    Asunto Por Turnar\n\t\t".toCharArray();
    __oracle_jsp_text[346] = 
    "\n\t\t    Asunto En Tr&aacute;mite\n\t\t".toCharArray();
    __oracle_jsp_text[347] = 
    "\n\t\t    Asunto Terminado\n\t\t".toCharArray();
    __oracle_jsp_text[348] = 
    "\n\t\t\t</FONT></td>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[349] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[350] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[351] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[352] = 
    "\n\t<TR ".toCharArray();
    __oracle_jsp_text[353] = 
    " ".toCharArray();
    __oracle_jsp_text[354] = 
    " bgcolor=\"#f6f6f6\" ".toCharArray();
    __oracle_jsp_text[355] = 
    ">\n\t\t<TD width=\"438\" align=\"left\">\n\t\t".toCharArray();
    __oracle_jsp_text[356] = 
    " <A\n\t\t\thref=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[357] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[358] = 
    "\">\n\t\t<FONT size=\"1\" color=\"#004080\" face=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[359] = 
    "</FONT>\n\t\t</A>\n\t\t".toCharArray();
    __oracle_jsp_text[360] = 
    " <A\n\t\t\thref=\"AsuntoRecepcion.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[361] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[362] = 
    "\">\n\t\t<FONT size=\"1\" color=\"#004080\" face=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[363] = 
    "</FONT></A>\n\t\t".toCharArray();
    __oracle_jsp_text[364] = 
    " &nbsp;es&nbsp;".toCharArray();
    __oracle_jsp_text[365] = 
    "&nbsp;de&nbsp;".toCharArray();
    __oracle_jsp_text[366] = 
    "\n\t\t</TD>\n\t\t<!-- <td width=\"274\" align=\"center\"><FONT size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">".toCharArray();
    __oracle_jsp_text[367] = 
    "</FONT></td> -->\n\t\t<td width=\"200\" align=\"center\"><FONT size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">".toCharArray();
    __oracle_jsp_text[368] = 
    "</FONT></td>\n\t\t<td width=\"194\" align=\"center\"><FONT size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">".toCharArray();
    __oracle_jsp_text[369] = 
    "</FONT></td>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[370] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[371] = 
    "\n</TABLE>\n</div>\n".toCharArray();
    __oracle_jsp_text[372] = 
    " <BR>\n\n\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TBODY>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\t\tface=\"Arial\">Datos del Evento</font></b></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"368\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</tr>\n\t</TBODY>\n</table>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\" height=\"22\"></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"60\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"370\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\"\n\t\t\t\tsize=\"2\">Fecha del evento:</FONT></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"><FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[373] = 
    "</FONT>\n\t\t\t</td>\n\t\t\t<td width=\"60\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"370\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\"\n\t\t\t\tsize=\"2\"></FONT></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"60\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"370\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\"\n\t\t\t\tsize=\"2\">Hora del evento:</FONT></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"><FONT face=\"Arial\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[374] = 
    "\n\t\t\t-- : -- ".toCharArray();
    __oracle_jsp_text[375] = 
    " ".toCharArray();
    __oracle_jsp_text[376] = 
    ":".toCharArray();
    __oracle_jsp_text[377] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[378] = 
    " </FONT></td>\n\t\t\t<td width=\"60\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"370\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\"\n\t\t\t\tsize=\"2\"></FONT></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"60\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"370\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\"\n\t\t\t\tsize=\"2\">Lugar del evento:</FONT></td>\n\t\t\t<td width=\"660\" colspan=\"3\"><img src=\"../Imagenes/ecblank.gif\"\n\t\t\t\tborder=\"0\" height=\"1\" width=\"1\" alt=\"\"> ".toCharArray();
    __oracle_jsp_text[379] = 
    "</td>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\"\n\t\t\t\tsize=\"2\"></FONT></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"60\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"370\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t</TBODY>\n</table>\n</DIV>\n<DIV align=\"center\">\n<TABLE border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><B><FONT color=\"#004080\" face=\"Arial\"\n\t\t\t\tsize=\"2\">Datos del Turnado</FONT></B></TD>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"366\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</tr>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<TABLE border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<td width=\"183\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<TD width=\"360\">\n\t\t\t<DIV align=\"right\"><FONT face=\"Arial\" size=\"2\"><BR>\n\t\t\t</FONT> <FONT color=\"#004080\" face=\"Arial\" size=\"2\"> </FONT><FONT\n\t\t\t\tface=\"Arial\" size=\"2\"><B></B></FONT></DIV>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT color=\"#004080\" face=\"Arial\" size=\"2\">Prioridad:</FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[380] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[381] = 
    "\n\t\t\t<TD width=\"660\" colspan=\"3\"><FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[382] = 
    "</FONT>\n\t\t\t<INPUT name=\"asuPri_1\" type=\"hidden\" value=\"0\"> <INPUT\n\t\t\t\tname=\"asuntoPrioridad\" type=\"hidden\"\n\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[383] = 
    "\"></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[384] = 
    "\n\t\t\t<TD width=\"660\" colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[385] = 
    " <FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[386] = 
    "</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[387] = 
    " <FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[388] = 
    "</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[389] = 
    " <INPUT name=\"asuntoPrioridad\" type=\"hidden\"\n\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[390] = 
    "\"> <INPUT\n\t\t\t\tname=\"asuPri_1\" type=\"hidden\" value=\"0\"></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[391] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[392] = 
    "\n\t\t\t<TD colspan=\"3\"><SELECT name=\"asuntoPrioridad\" class=\"blue500a\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[393] = 
    "\n\t\t\t\t<OPTION value=\"-1\">--Prioridades de la Unidad--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[394] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[395] = 
    "\">".toCharArray();
    __oracle_jsp_text[396] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[397] = 
    "\n\t\t\t\t<OPTION value=\"-1\">--Prioridades Generales--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[398] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[399] = 
    "\">".toCharArray();
    __oracle_jsp_text[400] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[401] = 
    "\n\t\t\t</SELECT> <INPUT name=\"asuPri_1\" type=\"hidden\" value=\"1\"></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[402] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><FONT color=\"#004080\" face=\"Arial\" size=\"2\">Tipo\n\t\t\tde Asunto:</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[403] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[404] = 
    "\n\t\t\t<TD width=\"660\" colspan=\"3\"><FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[405] = 
    "</FONT>\n\t\t\t<INPUT name=\"asuTip_1\" type=\"hidden\"\n\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[406] = 
    "\"> <INPUT\n\t\t\t\tname=\"asuntoTipoAsunto\" type=\"hidden\"\n\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[407] = 
    "\"></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[408] = 
    "\n\t\t\t<TD width=\"660\" colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[409] = 
    " <FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[410] = 
    "</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[411] = 
    " <FONT face=\"Arial\" size=\"2\">".toCharArray();
    __oracle_jsp_text[412] = 
    "</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[413] = 
    " <INPUT name=\"asuTip_1\" type=\"hidden\" value=\"0\"></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[414] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[415] = 
    "\n\t\t\t<TD colspan=\"3\"><SELECT name=\"asuntoTipoAsunto\" class=\"blue500a\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[416] = 
    "\n\t\t\t\t<OPTION value=\"-1\">--Tipos de Asunto de la Unidad--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[417] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[418] = 
    "\">".toCharArray();
    __oracle_jsp_text[419] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[420] = 
    "\n\t\t\t\t<OPTION value=\"-1\">--Tipos de Asunto Generales--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[421] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[422] = 
    "\">".toCharArray();
    __oracle_jsp_text[423] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[424] = 
    "\n\t\t\t</SELECT> <INPUT name=\"asuTip_1\" type=\"hidden\" value=\"1\"></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[425] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"4\" align=\"left\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<P><BR>\n</P>\n\n".toCharArray();
    __oracle_jsp_text[426] = 
    "\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"64%\" colspan=\"2\"><B><FONT face=\"Arial\"\n\t\t\t\tcolor=\"#004080\" size=\"2\">Lista Ruta de Atenci&oacute;n</FONT></B></TD>\n\t\t\t<TD width=\"21%\">&nbsp;</TD>\n\t\t\t<TD width=\"14%\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" bgcolor=\"#004080\" colspan=\"4\"><IMG height=\"2\"\n\t\t\t\talt=\"\" src=\"../Imagenes/shim.gif\" width=\"1\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" colspan=\"4\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" colspan=\"4\"><FONT face=\"Arial\" size=\"2\"></FONT>\n\t\t\t<TABLE width=\"100%\" border=\"0\">\n\t\t\t\t<TBODY>\n\t\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t\t<TD width=\"2%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">H.</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"3%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">Paso</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"17%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">Responsable</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"15%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">Unidad</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"21%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">N. Instrucci&oacute;n</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"10%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">F. Recepci&oacute;n</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"10%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">F. Vencimiento</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"5%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">D. Plan.</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"5%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">D. Real</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"5%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">Avance</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"5%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">Estatus</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"2%\" bgcolor=\"#00204f\">\n\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#ffffff\"\n\t\t\t\t\t\t\tsize=\"1\">Con.</FONT></DIV>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[427] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[428] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[429] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[430] = 
    "\n\t\t\t\t\t\t<TR valign=\"top\" ".toCharArray();
    __oracle_jsp_text[431] = 
    " ".toCharArray();
    __oracle_jsp_text[432] = 
    "\n\t\t\t\t\t\t\tbgcolor=\"#f6f6f6\" ".toCharArray();
    __oracle_jsp_text[433] = 
    ">\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[434] = 
    "\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">Si</FONT></DIV>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[435] = 
    "\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">No</FONT></DIV>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[436] = 
    "\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">".toCharArray();
    __oracle_jsp_text[437] = 
    "</FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\"> ".toCharArray();
    __oracle_jsp_text[438] = 
    " ".toCharArray();
    __oracle_jsp_text[439] = 
    " ".toCharArray();
    __oracle_jsp_text[440] = 
    " ".toCharArray();
    __oracle_jsp_text[441] = 
    " ".toCharArray();
    __oracle_jsp_text[442] = 
    " </FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">".toCharArray();
    __oracle_jsp_text[443] = 
    "</FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\"> ".toCharArray();
    __oracle_jsp_text[444] = 
    " ".toCharArray();
    __oracle_jsp_text[445] = 
    " ".toCharArray();
    __oracle_jsp_text[446] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[447] = 
    " ".toCharArray();
    __oracle_jsp_text[448] = 
    " </FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\"> ".toCharArray();
    __oracle_jsp_text[449] = 
    "- ".toCharArray();
    __oracle_jsp_text[450] = 
    " ".toCharArray();
    __oracle_jsp_text[451] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[452] = 
    " </FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\"> ".toCharArray();
    __oracle_jsp_text[453] = 
    "- ".toCharArray();
    __oracle_jsp_text[454] = 
    " ".toCharArray();
    __oracle_jsp_text[455] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[456] = 
    " </FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">".toCharArray();
    __oracle_jsp_text[457] = 
    "</FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\"> ".toCharArray();
    __oracle_jsp_text[458] = 
    " ".toCharArray();
    __oracle_jsp_text[459] = 
    " ".toCharArray();
    __oracle_jsp_text[460] = 
    "-".toCharArray();
    __oracle_jsp_text[461] = 
    " </FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">".toCharArray();
    __oracle_jsp_text[462] = 
    "%</FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\"> ".toCharArray();
    __oracle_jsp_text[463] = 
    " ".toCharArray();
    __oracle_jsp_text[464] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[465] = 
    " <A\n\t\t\t\t\t\t\t\thref=\"InstruccionesAtender.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[466] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[467] = 
    "\"><U>Notificado</U></A>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[468] = 
    "Notificado".toCharArray();
    __oracle_jsp_text[469] = 
    " ".toCharArray();
    __oracle_jsp_text[470] = 
    " ".toCharArray();
    __oracle_jsp_text[471] = 
    "\n\t\t\t\t\t\t\t<A\n\t\t\t\t\t\t\t\thref=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[472] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[473] = 
    "\"><U>Notificado</U></A>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[474] = 
    "Notificado".toCharArray();
    __oracle_jsp_text[475] = 
    " ".toCharArray();
    __oracle_jsp_text[476] = 
    " ".toCharArray();
    __oracle_jsp_text[477] = 
    " ".toCharArray();
    __oracle_jsp_text[478] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[479] = 
    " <A\n\t\t\t\t\t\t\t\thref=\"InstruccionesAtender.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[480] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[481] = 
    "\"><U>En\n\t\t\t\t\t\t\tProceso</U></A> ".toCharArray();
    __oracle_jsp_text[482] = 
    "En Proceso".toCharArray();
    __oracle_jsp_text[483] = 
    " ".toCharArray();
    __oracle_jsp_text[484] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[485] = 
    " <A\n\t\t\t\t\t\t\t\thref=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[486] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[487] = 
    "\"><U>En\n\t\t\t\t\t\t\tProceso</U></A> ".toCharArray();
    __oracle_jsp_text[488] = 
    "En Proceso".toCharArray();
    __oracle_jsp_text[489] = 
    " ".toCharArray();
    __oracle_jsp_text[490] = 
    " ".toCharArray();
    __oracle_jsp_text[491] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[492] = 
    " <A\n\t\t\t\t\t\t\t\thref=\"InstruccionesAtender.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[493] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[494] = 
    "\">\n\t\t\t\t\t\t\t<U>Rechazada</U></A> ".toCharArray();
    __oracle_jsp_text[495] = 
    "Rechazada".toCharArray();
    __oracle_jsp_text[496] = 
    " ".toCharArray();
    __oracle_jsp_text[497] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[498] = 
    " ".toCharArray();
    __oracle_jsp_text[499] = 
    "\n\t\t\t\t\t\t\t<A\n\t\t\t\t\t\t\t\thref=\"InstruccionesAtender.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[500] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[501] = 
    "\">\n\t\t\t\t\t\t\t<U>Terminada</U></A> ".toCharArray();
    __oracle_jsp_text[502] = 
    "Terminada".toCharArray();
    __oracle_jsp_text[503] = 
    " ".toCharArray();
    __oracle_jsp_text[504] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[505] = 
    " <A\n\t\t\t\t\t\t\t\thref=\"InstruccionTurnada.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[506] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[507] = 
    "\">\n\t\t\t\t\t\t\t<U>Terminada</U></A> ".toCharArray();
    __oracle_jsp_text[508] = 
    "Terminada".toCharArray();
    __oracle_jsp_text[509] = 
    " ".toCharArray();
    __oracle_jsp_text[510] = 
    " ".toCharArray();
    __oracle_jsp_text[511] = 
    " </FONT></DIV>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[512] = 
    "\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">Si</FONT></DIV>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[513] = 
    "\n\t\t\t\t\t\t\t<DIV align=\"center\"><FONT face=\"Verdana\" color=\"#000000\"\n\t\t\t\t\t\t\t\tsize=\"1\">No</FONT></DIV>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[514] = 
    "\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[515] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[516] = 
    "\n\t\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" colspan=\"4\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"36%\">&nbsp;</TD>\n\t\t\t<TD width=\"29%\">&nbsp;</TD>\n\t\t\t<TD width=\"21%\">&nbsp;</TD>\n\t\t\t<TD width=\"14%\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<BR>\n".toCharArray();
    __oracle_jsp_text[517] = 
    "\n\n<CENTER>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><B><FONT face=\"Arial\" color=\"#004080\"\n\t\t\t\tsize=\"2\">Documentos Anexados</FONT></B></TD>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"863\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</tr>\n\t\t<!-- <TR valign=\"top\">\n\t\t\t<TD width=\"19%\">&nbsp;</TD>\n\t\t\t<TD width=\"31%\">&nbsp;</TD>\n\t\t\t<TD width=\"19%\">&nbsp;</TD>\n\t\t\t<TD width=\"31%\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[518] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[519] = 
    "\n\t\t\t\t\t<TD width=\"30%\">&nbsp;</TD>\n\t\t\t\t\t<TD width=\"20%\" align=\"center\">\n\t\t\t\t\t\t<INPUT type=\"button\" class=\"blue200\" value=\"Agregar Archivo\" onclick=\"agregarContent();\">&nbsp;\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD width=\"20%\" align=\"center\">\n\t\t\t\t\t\t<INPUT type=\"button\" class=\"blue200\" value=\"Listado Archivos\" onclick=\"listadoContent();\">&nbsp;\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD width=\"50%\">&nbsp;</TD>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[520] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[521] = 
    "\n\t\t\t\t\t<TD width=\"30%\">&nbsp;</TD>\n\t\t\t\t\t<TD width=\"20%\">&nbsp;</TD>\n\t\t\t\t\t<TD width=\"50%\">&nbsp;</TD>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[522] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[523] = 
    "\n\t\t</TR> -->\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"4\">\n\t\t\t<div>\n\t\t\t".toCharArray();
    __oracle_jsp_text[524] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[525] = 
    " <IFRAME ID=\"frame1\"\n\t\t\t\t\tSRC=\"ImportarCMO.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[526] = 
    "&bo=true&fol=".toCharArray();
    __oracle_jsp_text[527] = 
    "&inst=".toCharArray();
    __oracle_jsp_text[528] = 
    "&est=".toCharArray();
    __oracle_jsp_text[529] = 
    "\"\n\t\t\t\t\tWIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME> ".toCharArray();
    __oracle_jsp_text[530] = 
    " <IFRAME\n\t\t\t\t\t\tID=\"frame1\"\n\t\t\t\t\t\tSRC=\"ImportarAR.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[531] = 
    "&bo=true&fol=".toCharArray();
    __oracle_jsp_text[532] = 
    "&inst=".toCharArray();
    __oracle_jsp_text[533] = 
    "&est=".toCharArray();
    __oracle_jsp_text[534] = 
    "\"\n\t\t\t\t\t\tWIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME> ".toCharArray();
    __oracle_jsp_text[535] = 
    " ".toCharArray();
    __oracle_jsp_text[536] = 
    " ".toCharArray();
    __oracle_jsp_text[537] = 
    " <IFRAME ID=\"frame1\"\n\t\t\t\t\t\tSRC=\"ImportarAR.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[538] = 
    "&bo=false&fol=".toCharArray();
    __oracle_jsp_text[539] = 
    "&inst=".toCharArray();
    __oracle_jsp_text[540] = 
    "&est=".toCharArray();
    __oracle_jsp_text[541] = 
    "\"\n\t\t\t\t\t\tWIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME> ".toCharArray();
    __oracle_jsp_text[542] = 
    " <IFRAME\n\t\t\t\t\t\tID=\"frame1\"\n\t\t\t\t\t\tSRC=\"ImportarCMO.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[543] = 
    "&bo=false&fol=".toCharArray();
    __oracle_jsp_text[544] = 
    "&inst=".toCharArray();
    __oracle_jsp_text[545] = 
    "&est=".toCharArray();
    __oracle_jsp_text[546] = 
    "\"\n\t\t\t\t\t\tWIDTH=\"800\" HEIGHT=\"250\" frameborder=\"0\"></IFRAME> ".toCharArray();
    __oracle_jsp_text[547] = 
    " ".toCharArray();
    __oracle_jsp_text[548] = 
    "\n\t\t\t</div>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</CENTER>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">Comentarios del Asunto</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"863\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n</table>\n</DIV>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"863\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t".toCharArray();
    __oracle_jsp_text[549] = 
    "\n\t\t<td width=\"863\"><font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t".toCharArray();
    __oracle_jsp_text[550] = 
    "\n\t\t\t<B>Fecha y Hora:</B>\n\t\t\t".toCharArray();
    __oracle_jsp_text[551] = 
    "\n\t\t\t<br>\n\t\t\t<B>Usuario:</B>\n\t\t\t".toCharArray();
    __oracle_jsp_text[552] = 
    "\n\t\t\t<br>\n\t\t\t<B>Comentario:</B>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[553] = 
    "\n\t\t\t<br>\n\t\t\t\t-------------<br>\n\t\t\t<br>\n\t\t".toCharArray();
    __oracle_jsp_text[554] = 
    " </font></td>\n\t\t".toCharArray();
    __oracle_jsp_text[555] = 
    "\n\t\t<td width=\"100%\">&nbsp;</td>\n\t\t".toCharArray();
    __oracle_jsp_text[556] = 
    "\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"863\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"863\" bgcolor=\"#00204F\" colspan=\"4\"></td>\n\t</tr>\n</table>\n</DIV>\n</DIV>\n<INPUT type=\"hidden\" name=\"b\" value=\"".toCharArray();
    __oracle_jsp_text[557] = 
    "\"><BR>\n".toCharArray();
    __oracle_jsp_text[558] = 
    " <script language=JavaScript\n\ttype=text/javascript>\nagregarContent();\n</script>\n".toCharArray();
    __oracle_jsp_text[559] = 
    " ".toCharArray();
    __oracle_jsp_text[560] = 
    " <script language=JavaScript\n\ttype=text/javascript>\ndoc = document.asuntoTurnado;\ndoc.retURI.value='".toCharArray();
    __oracle_jsp_text[561] = 
    "';\ndoc.submit();\n</script> ".toCharArray();
    __oracle_jsp_text[562] = 
    "\n</DIV>\n".toCharArray();
    __oracle_jsp_text[563] = 
    " <script\n\ttype=\"text/javascript\">\n\talert(\"Se le asign&oacute; el folio ".toCharArray();
    __oracle_jsp_text[564] = 
    " al Asunto\");\n</script> ".toCharArray();
    __oracle_jsp_text[565] = 
    " <SCRIPT language=\"JavaScript\" type=\"text/javascript\">\nif (".toCharArray();
    __oracle_jsp_text[566] = 
    "){\n\talert(\"Este Asunto ha sido modificado por otro usuario y cambi&oacute; su Estatus,\\npor lo que la acci&oacute;n solicitada ser&aacute; cancelada\");\n\tlocation.assign(\"portalPrincipal.jsp\");\n}\n</SCRIPT> <script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
