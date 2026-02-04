package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.taglib.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.util.*;
import java.util.*;
import com.meve.sigma.beans.search.*;


public class _Asuntos extends com.orionserver.http.OrionHttpJspPage {


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
    PageContext pageContext = JspFactory.getDefaultFactory().getPageContext( this, request, response, null, true, 8192, true);
    // Note: this is not emitted if the session directive == false
    HttpSession session = pageContext.getSession();
    int __jsp_tag_starteval;
    ServletContext application = pageContext.getServletContext();
    JspWriter out = pageContext.getOut();
    _Asuntos page = this;
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
      com.meve.sigma.beans.Asunto Asunto;
      synchronized (pageContext) {
        if ((Asunto = (com.meve.sigma.beans.Asunto) pageContext.getAttribute( "Asunto", PageContext.PAGE_SCOPE)) == null) {
          Asunto = (com.meve.sigma.beans.Asunto) new com.meve.sigma.beans.Asunto();
          pageContext.setAttribute( "Asunto", Asunto, PageContext.PAGE_SCOPE);
          out.write(__oracle_jsp_text[4]);
          OracleJspRuntime.__jspSetAllParams(request, (Object)Asunto, true);
          out.write(__oracle_jsp_text[5]);
          out.write(__oracle_jsp_text[6]);
          out.write(__oracle_jsp_text[7]);
          out.write(__oracle_jsp_text[8]);
          com.meve.sigma.beans.EscrituraBean BEscritura;
          synchronized (pageContext) {
            if ((BEscritura = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscritura", PageContext.PAGE_SCOPE)) == null) {
              BEscritura = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
              pageContext.setAttribute( "BEscritura", BEscritura, PageContext.PAGE_SCOPE);
            }
          }
          out.write(__oracle_jsp_text[9]);
          com.meve.sigma.beans.EscrituraBean BEscritura1;
          synchronized (pageContext) {
            if ((BEscritura1 = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscritura1", PageContext.PAGE_SCOPE)) == null) {
              BEscritura1 = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
              pageContext.setAttribute( "BEscritura1", BEscritura1, PageContext.PAGE_SCOPE);
            }
          }
          out.write(__oracle_jsp_text[10]);
          com.meve.sigma.beans.EscrituraBean BEscritura2;
          synchronized (pageContext) {
            if ((BEscritura2 = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscritura2", PageContext.PAGE_SCOPE)) == null) {
              BEscritura2 = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
              pageContext.setAttribute( "BEscritura2", BEscritura2, PageContext.PAGE_SCOPE);
            }
          }
          out.write(__oracle_jsp_text[11]);
          
          	String strIdAsunto  = "";
          	String carga        = "";
          	String strFoco      = "";
          	strIdAsunto	    = (request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
          	strFoco	            = (request.getParameter("focus") != null)?request.getParameter("focus"):"0";
          	carga               = request.getParameter("cargar");
          	UsuarioBean BUsuario= (UsuarioBean)session.getAttribute("UsuarioBean");
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
          	String strEntidad			=	(Asunto.getAsuntoEntidad()== null)?"":Asunto.getAsuntoEntidad();
          	String strIdEntidad			=	(Asunto.getIdEntidad()== null)?"":Asunto.getIdEntidad();
          	String strRemitente			=	(Asunto.getAsuntoRemitente()== null)?"":Asunto.getAsuntoRemitente();
          	String strIdRemitente		=	(Asunto.getIdRemitente()== null)?"":Asunto.getIdRemitente();
          	String strCargo				=	(Asunto.getAsuntoCargo()== null)?"":Asunto.getAsuntoCargo();
          	String strCorreo			=	(Asunto.getAsuntoCorreo()== null)?"":Asunto.getAsuntoCorreo();
          	String strFirmante			=	(Asunto.getAsuntoFirmante()== null)?"":Asunto.getAsuntoFirmante();
          	String strIdDestinatario	=	(Asunto.getIdDestinatario()== null)?"":Asunto.getIdDestinatario();
          	String strDestinatario		=	(Asunto.getAsuntoDestinatario()== null)?"":Asunto.getAsuntoDestinatario();
          	String strCargoDest			=	(Asunto.getAsuntoCargoDest()== null)?"":Asunto.getAsuntoCargoDest();
          	String strAreaDest			=	(Asunto.getAsuntoAreaDest()== null)?"":Asunto.getAsuntoAreaDest();
          	String strMailDest			=	(Asunto.getMailDest()== null)?"":Asunto.getMailDest();
          	String strAsunto			=	(Asunto.getAsunto()== null)?"":Asunto.getAsunto();
          	String strIdExpediente		=	(Asunto.getAsuntoExpediente()== null)?"":Asunto.getAsuntoExpediente();
          	//String strUbicacion			=	(Asunto.getAsuntoUbicacion()== null)?"":Asunto.getAsuntoUbicacion();
          	//String strReferenciaExp		=	(Asunto.getAsuntoReferencia()== null)?"":Asunto.getAsuntoReferencia();
          	String strIdTipoDocto		=	(Asunto.getAsuntoTipoDocto()== null)?"":Asunto.getAsuntoTipoDocto();
          	String strFechaRecepcion	=	(Asunto.getAsuntoFechaRecepcion()== null)?"":Asunto.getAsuntoFechaRecepcion();
          	String strFechaDocto		=	(Asunto.getAsuntoFechaDocto()== null)?"":Asunto.getAsuntoFechaDocto();
          	String strFechaCaducidad	=	(Asunto.getAsuntoFechaCad()== null)?"":Asunto.getAsuntoFechaCad();
          	String strFolioExterno		=	(Asunto.getAsuntoFolioExt()== null)?"":Asunto.getAsuntoFolioExt();
          	String strFolioIntermedio	=	(Asunto.getAsuntoFolioInt()== null)?"":Asunto.getAsuntoFolioInt();
          	String strSintesis			=	(Asunto.getAsuntoSintesis()== null)?"":Asunto.getAsuntoSintesis();
          	String strComentarios		=	(Asunto.getAsuntoComentario()== null)?"":Asunto.getAsuntoComentario();
          	String strPalabraClave		=	(Asunto.getAsuntoPalabraClave()== null)?"":Asunto.getAsuntoPalabraClave();
          	String strAsuntoAnterior	=	(Asunto.getAsuntoAnterior()== null)?"":Asunto.getAsuntoAnterior();
          	String strIdPrioridad		=	(Asunto.getAsuntoPrioridad()== null)?"":Asunto.getAsuntoPrioridad();
          	String strIdTipoAsunto		=	(Asunto.getAsuntoTipoAsunto()== null)?"":Asunto.getAsuntoTipoAsunto();
          	String strIdRutaAuto		=	(Asunto.getAsuntoRutaAuto()== null)?"":Asunto.getAsuntoRutaAuto();
          	String strControl			=	(Asunto.getControl()== null)?"":Asunto.getControl();
          	String URL 					=	(Asunto.getUrl()== null)?"":Asunto.getUrl();
          	String strFolioGenerado		=	(Asunto.getFol()== null)?"":Asunto.getFol();
          	String strPara				=	(Asunto.getAsuntoPara()== null)?"":Asunto.getAsuntoPara();
          	String strCC				=	(Asunto.getAsuntoCC()== null)?"":Asunto.getAsuntoCC();
          	String strIdsPara			=	(Asunto.getAsuntoIdsPara()== null)?"":Asunto.getAsuntoIdsPara();
          	String strIdsCC				=	(Asunto.getAsuntoIdsCC()== null)?"":Asunto.getAsuntoIdsCC();
          	String strLugarEvento		= 	(Asunto.getlugarEvento()== null)?"":Asunto.getlugarEvento();
          	String strFormateada		=	(Asunto.getFechaEvento()== null)?"":Asunto.getFechaEvento();
          	String strHoraEvento		=	(Asunto.getHora_evento()== null)?"":Asunto.getHora_evento();         
          	String strMinEvento			=	(Asunto.getMin_evento()== null)?"":Asunto.getMin_evento();  
          
          	String strHoraRecep			=	(Asunto.getHoraRecepcion()== null)?"":Asunto.getHoraRecepcion();         
          	String strMinRecep			=	(Asunto.getMinRecepcion()== null)?"":Asunto.getMinRecepcion();  
          
          	String strParaE				=	(Asunto.getAsuntoParaE()== null)?"":Asunto.getAsuntoParaE();
          	String strIdsParaE			=	(Asunto.getAsuntoIdsParaE()== null)?"":Asunto.getAsuntoIdsParaE();    
          	String strAccion			=	"";
          	String idAsuntoAnt			=	(Asunto.getIdAsuntoAnt()== null)?"":Asunto.getIdAsuntoAnt();
          	String idAsuntoRef			=	(Asunto.getIdAsuntoRef()== null)?"":Asunto.getIdAsuntoRef(); 
          	String strTramite			=	(Asunto.getAsuntoTramite()== null)?"":Asunto.getAsuntoTramite();
          	String strTipoFolio			=	(Asunto.getAsuntoTipoFolio()==null)?"":Asunto.getAsuntoTipoFolio();
          	String strbanderaVent		=	(request.getParameter("banderaVent")==null)?"1":request.getParameter("banderaVent");
          	String strIdTramite			=	(request.getParameter("id_tra")==null)?"":request.getParameter("id_tra");
          	String strCreador			=	"";
          	String strCreador1			=	"";
          	String strAreaUs			=	"";
          	String strFechaCreacion		=	"";
          	String strEstatus			=	(request.getParameter("estatusN")==null)?"":request.getParameter("estatusN");
          	String strEstatusN			=	"";
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
          	String strFeFormateada5		=	"";
          	String strMensajeDuplicado	=	"";
          
          	String strIds				=	"";
          	String ids					=	"";
          	String refs					=	"";
          
          	String strAccionArchivo		=	(request.getParameter("accionArchivo")== null)?"":request.getParameter("accionArchivo");
          	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
          
          	String retURI = (request.getParameter("retURI")== null)?"PortalBorrador.jsp":request.getParameter("retURI");
                  
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
          	listaIDSPara = Utilerias.getNombrePuesto(strIdsPara, 0);
          	listaIDSCC = Utilerias.getNombrePuesto(strIdsCC, 0);
          	listaIDSParaExt = Utilerias.getRemitenteEntidad(strIdsParaE, 1);
          
          	String strDatosNewWindow[][] = new String[2][2];
          	String strDatosAsuntoAnt[][] = new String[0][0];
          	String strDatosAsuntoAntRef[][] = new String[0][0];
          	String strDatosAsuntoLigas[][] = new String[0][0];
          	String strDatosDes[][] 			= 	new String[0][0];
          	String strDatosDesPara[][] 		= 	new String[0][0];
          	String strDatosDesCC[][] 		= 	new String[0][0];
          	String strDatosDesParaE[][] 	= 	new String[0][0];
          
          	String serverContentManager	=  	application.getInitParameter("content");
          	String strActivarCM 		= 	application.getInitParameter("ActivarContent");
          	String strItemType  		=  	application.getInitParameter("ItemType");
          	String server				=	application.getInitParameter("servername");
          	String strRutaBase			= 	(application.getInitParameter("RutaBase")==null)?"":application.getInitParameter("RutaBase");
          	
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
          
          	int contador = (request.getParameter("contador")== null)?0:Integer.parseInt(request.getParameter("contador"));
          	contador++;
          	String strBandera = (request.getParameter("strBandera")== null)?"false":request.getParameter("strBandera");
          	String setFoco = (request.getParameter("setFoco")== null)?"botEntidad":request.getParameter("setFoco");
          
          	String mensaje = "";
          	boolean bvalida = false;
          
          	if(strA == null)
          		strA = "1";
          	
          	String url 		= 	request.getRequestURI();
          	URL 		= 	server+url+"?id_asunto="+strIdAsunto;
                  
                  
          	if(strIdAsunto != null && strIdAsunto.trim().length()>0 && strAccion.length()==0 && !strAccion.equals("EditDest")){        
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
          		strSintesis		=	strDatosAsunto[0][18];
          		strComentarios		=	strDatosAsunto[0][19];
          		strPalabraClave		=	strDatosAsunto[0][20];
          		strAsuntoAnterior	=	strDatosAsunto[0][21];
          		strIdPrioridad		=	strDatosAsunto[0][22];
          		strFolioGenerado	=	strDatosAsunto[0][23];
          		strCreador1		=	strDatosAsunto[0][24];
          		strAreaUs		=	strDatosAsunto[0][26];
          		strIdTipoAsunto		=	strDatosAsunto[0][27];
          		strEstatus		=	strDatosAsunto[0][28];
          		strIdDestinatario	=	strDatosAsunto[0][30];
          		strDestinatario		=	strDatosAsunto[0][31];
          		strMailDest		=	strDatosAsunto[0][34];
          		strCargoDest		=	strDatosAsunto[0][35];
          		strCorreo		=	strDatosAsunto[0][37];
          		strCargo		=	strDatosAsunto[0][38];
          		strAreaDest		=	strDatosAsunto[0][39];
          		strPrioridad		=	strDatosAsunto[0][40];
          		strTipoDocto		=	strDatosAsunto[0][41];
          		strTipoAsunto		=	strDatosAsunto[0][42];
          		strRutaAuto		=	strDatosAsunto[0][43];
          		strControl		=	strDatosAsunto[0][45];
          		strPara			=	strDatosAsunto[0][46];
          		strCC			=	strDatosAsunto[0][47];
          		strIdsPara		=	strDatosAsunto[0][48];
          		strIdsCC		=	strDatosAsunto[0][49];
          		strLugarEvento		= 	strDatosAsunto[0][50];
          		strFormateada		=	Utilerias.formatearFechas(strDatosAsunto[0][51]);
          		strHoraEvento		=   strDatosAsunto[0][52];
          		strMinEvento 		=	strDatosAsunto[0][53];
          		strParaE		=	strDatosAsunto[0][54];
          		strIdsParaE		=	strDatosAsunto[0][55];
          		strTramite		=	strDatosAsunto[0][56];
          		strTipoFolio		=	strDatosAsunto[0][57];
          		strHoraRecep		=	strDatosAsunto[0][58];
          		strMinRecep		=	strDatosAsunto[0][59];
          		}
          		strAvance		=	strDatosAsunto[0][29];
          		strFechaCreacion	=	strDatosAsunto[0][25];  
          		strFeFormateada4	=	Utilerias.formatearFechas(strFechaCreacion);
          		strEstatus		=	strDatosAsunto[0][28];
          
          		listaPara = Utilerias.getNombres1(strPara);
          		listaCC = Utilerias.getNombres1(strCC);
          		listaParaE = Utilerias.getNombres(strParaE);
          		listaIDSPara = Utilerias.getNombrePuesto(strIdsPara, 0);
          		listaIDSCC = Utilerias.getNombrePuesto(strIdsCC, 0);
          		listaIDSParaExt = Utilerias.getRemitenteEntidad(strIdsParaE, 1);
          		
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
                  //strFirmante = strFirmante + " / "+ strRemitente;
          		if(strRutaAuto == null || strRutaAuto.length() <= 0)
          			strRutaAuto = "No hay ruta automatica";
          		if(strCorreo.length() == 0 || strCorreo == null)
          			strCorreo = "No tiene correo registrado";
          		if(strCargo.length() == 0 || strCargo == null)
          			strCargo = "No tienes cargo registrado";
          		
          		if(strEstatus.equals("0")){
          			strEstatusN = "En Recepción";
          		}else if(strEstatus.equals("1")){
          			strEstatusN = "Por Turnar";
          		}else if(strEstatus.equals("2")){
          			strEstatusN = "En Trámite";
          		}else if(strEstatus.equals("3")){
          			strEstatusN = "Terminada";
          		}
          
          		strDatosNewWindow = ActualizaAsunto.getIdsRef(strIdAsunto);
          		if(strDatosNewWindow.length > 0){
          
          			ids = strDatosNewWindow[0][0];
          			refs = strDatosNewWindow[0][1];
          		}
          			
          		strDatosAsuntoAnt = ActualizaAsunto.getAsuntosAnt(strIdAsunto);
          	 	//strDatosAsuntoAntRef = ActualizaAsunto.getAsuntosAntRef(strIdAsunto); 
          	 	strDatosAsuntoLigas	=	ActualizaAsunto.getAsuntosLigados(strIdAsunto);
          		
          		if(strEstatus.equals("2") || strEstatus.equals("3")){
          			strDatosDes = ActualizaAsuntoTurnado.getDatosDes(strIdAsunto);
          			strDatosDesPara = ActualizaAsuntoTurnado.getDesPara(strIdAsunto);
          			strDatosDesCC = ActualizaAsuntoTurnado.getDesCC(strIdAsunto);
          			strDatosDesParaE = ActualizaAsuntoTurnado.getDesParaE(strIdAsunto);
          		}
          
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
          		strEstatusN = "En Recepción";
          	}else if(strEstatus.equals("1")){
          		strEstatusN = "Por Turnar";
          	}else if(strEstatus.equals("2")){
          		strEstatusN = "En Trámite";
          	}else if(strEstatus.equals("3")){
          		strEstatusN = "Terminada";
          	}
          out.write(__oracle_jsp_text[12]);
          	
          
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
          		String strIdTD		=	request.getParameter("asuntoTipoDocto_1");
          		
          		if(strIdTD.length()!=0)
          			strIdTipoDocto = strIdTD;
          		
          		mensaje = "Ocurrio un error durante el registro, por favor verifique sus datos " + "\\n";
          		bvalida = false;
          
          		int j=0;
          		if (strIdEntidad!= null && !strIdEntidad.equals("") && ((ActualizaEntidad.getEstatusEntidad(strIdEntidad).equals("0") && strControl.equals("0")) || 
          			(ActualizaArea.getEstatusArea(strIdEntidad).equals("0") && strControl.equals("1")))){
          			mensaje = mensaje + " - La Entidad fue borrada durante el registro" + "\\n";
          			bvalida = true;
          		}
          		if (strIdRemitente!= null && !strIdRemitente.equals("") && ((ActualizaRemitente.getEstatusRemitente(strIdRemitente).equals("0") && strControl.equals("0"))
          			|| (ActualizaUsuario.getEstatusUsuario(strIdRemitente).equals("0") && strControl.equals("1")))){
          			mensaje = mensaje + " - El Remitente fue borrado durante el registro" + "\\n";
          			bvalida = true;
          		}
          		if (strIdDestinatario!= null && !strIdDestinatario.equals("") && ActualizaUsuario.getEstatusUsuario(strIdDestinatario).equals("0")){
          			mensaje = mensaje + " - La Ventanilla fue borrada durante el registro" + "\\n";
          			bvalida = true;
          		}
          		if (strIdTipoDocto!= null && !strIdTipoDocto.equals("") && ActualizaTipo_Doc.getEstatusTipoDoc(strIdTipoDocto).equals("0")){
          			mensaje = mensaje + " - El Tipo de Documento fue borrado durante el registro" + "\\n";
          			bvalida = true;
          		}
          		
          		if (strTramite!= null && !strTramite.equals("") && strTramite.indexOf('|')!=-1){
          			if (ActualizaTramite.getEstatusTramite(strTramite.substring(0,strTramite.indexOf('|'))).equals("0")){
          				mensaje = mensaje + " - El Tramite fue borrado durante el registro" + "\\n";
          				bvalida = true;
          			}
          		}
          
          		if (strIdPrioridad!= null && !strIdPrioridad.equals("") && ActualizaPrioridad.getEstatusPrioridad(strIdPrioridad).equals("0")){
          			mensaje = mensaje + " - La Prioridad fue borrada durante el registro" + "\\n";
          			bvalida = true;
          		}
          		
          		if (strIdTipoAsunto!= null && !strIdTipoAsunto.equals("") && ActualizaTipoAsunto.getEstatusTipoAsunto(strIdTipoAsunto).equals("0")){
          			mensaje = mensaje + " - El Tipo de Asunto fue borrado durante el registro" + "\\n";
          			bvalida = true;
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
          			mensaje = mensaje + " - No existe un Folio de Recepción definido para su Unidad Administrativa \\n   Favor de contactar a su Administrador" + "\\n";
          			strAccionArchivo = "";
          			strAccion = "";
          			bvalida = true;
          		}
          
          		bValidaFechaRec = Utilerias.comparaFechaActual(strFechaRecepcion+" "+strHoraRecep+":"+strMinRecep+":00");
          		if (bValidaFechaRec && !bvalida){
          			strFechaRecepcion = strFechaRecepcion+" "+strHoraRecep+":"+strMinRecep+":00";
          			String fechaTemCaducidad = "";
          			fechaTemCaducidad = strFechaCaducidad+" "+strHoraRecep+":"+strMinRecep+":00";
          			Asunto.setAsuntoFechaRecepcion(strFechaRecepcion);
          			Asunto.setAsuntoFechaCad(fechaTemCaducidad);
          		}
           
          		if (!bvalida && !bValidaEstatus && bValidaFechaRec){
          			AsuntoProceso proceso = new AsuntoProceso(contentUri, userContent, passContent, pathContent); 
          			String redireccion = proceso.procesarAsunto(request, BUsuario, serverMail, portServer, serverName,
          									serverContentManager, strActivarCM, strItemType, server,
          									strConfigFolio, strRutaBase, strAccion, Asunto);
          		
          			try{
          				if(redireccion.length() < 2){
          					Asunto.setDuplicado("El Folio del Documento ya existe");
          					strMensajeDuplicado = Asunto.getDuplicado();
          				}else{
          					if(strIdAsunto.length()!=0){
          						if (strAccionArchivo!=null && strAccionArchivo.equals("guardarInsertarArchivo")){ 
          out.write(__oracle_jsp_text[13]);
          out.print(strFolioGenerado);
          out.write(__oracle_jsp_text[14]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[15]);
          out.print(strA);
          out.write(__oracle_jsp_text[16]);
          out.print( Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
          out.write(__oracle_jsp_text[17]);
          						}else{
          							if (strAccionArchivo!=null && strAccionArchivo.equals("guardarRegresarURI")){ 
          out.write(__oracle_jsp_text[18]);
          out.print( retURI );
          out.write(__oracle_jsp_text[19]);
          							}else{
          								if(redireccion.equals("PortalBorrador.jsp") || strAccion.equals("borrar"))
          									response.sendRedirect(redireccion);
          								else
          									response.sendRedirect(retURI);
          							}
          						}
          
          					}else{
          						if (strAccionArchivo!=null && strAccionArchivo.equals("guardarInsertarArchivo")){
          out.write(__oracle_jsp_text[20]);
          out.print(strFolioGenerado);
          out.write(__oracle_jsp_text[21]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[22]);
          out.print(strA);
          out.write(__oracle_jsp_text[23]);
          out.print( Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
          out.write(__oracle_jsp_text[24]);
          						}else{
          							if (strAccionArchivo!=null && strAccionArchivo.equals("guardarRegresarURI")){
          out.write(__oracle_jsp_text[25]);
          out.print( retURI );
          out.write(__oracle_jsp_text[26]);
          							}else{
          								if(redireccion.equals("PortalBorrador.jsp") || strAccion.equals("borrar"))
          									response.sendRedirect(redireccion);
          								else
          									response.sendRedirect(redireccion+"&folioControl=1");
          							}
          						}
          					}
          				}
          			}catch(java.io.IOException io){
          			}
          		}
          	}
          	//** Este bloque se utiliza para mostrar el botón
          	//** de guardar
          	if(BUsuario.getTurnado() || BUsuario.getRecepcion() ||
          		ActualizaInstrucciones.getSupervisorEsArea(strIdDestinatario, 
          					BUsuario.getIdUsuario(), BUsuario.getSupervisor()))
          			BEscritura.setValue(true);
          		else
          			BEscritura.setValue(false);
          	//** Fin botón guardar
          	
          	if(BUsuario.getRecepcion() || BUsuario.getTurnado())
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
          	float fAvance = 0;
          	if(strIdAsunto != null && strIdAsunto.trim().length()>0 && strAccion.length()==0 && !strAccion.equals("EditDest")){
          		fAvance = new Float(strAvance).floatValue();
          	}
          
          out.write(__oracle_jsp_text[27]);
           
          	//** los usuarios que tengan el perfil de administrador y Recepción
          	//** pueden modificar el asunto
                  /*-- Inicio KHCH Cambio para dar Acceso a la edicion de un asunto en tramite --*/
          	//if(strIdAsunto != null && strIdAsunto.trim().length()>0 && strAccion.length()==0 && !strAccion.equals("EditDest")){
          	//	if(((BUsuario.getIdUsuario().equals(strIdDestinatario) || !strbanderaVent.equals("0")) && fAvance<100 && 
          	//		(strEstatus.equals("0") || strEstatus.equals("1")) )){
          	if(strIdAsunto != null && strIdAsunto.trim().length()>0 && strAccion.length()==0 && !strAccion.equals("EditDest")){
          		if(((BUsuario.getIdUsuario().equals(strIdDestinatario) || !strbanderaVent.equals("0")) && fAvance<100 && 
          			(strEstatus.equals("0") || strEstatus.equals("1") || strEstatus.equals("2")) )){
          	/*-- Fin KHCH Cambio para dar Acceso a la edicion de un asunto en tramite --*/
                  }else{
          
          out.write(__oracle_jsp_text[28]);
          if (true) {
            String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
            // Forward 
            pageContext.forward( __url);
            return;
          }

          out.write(__oracle_jsp_text[29]);
          		
          		}
          	}else{
          		if(BUsuario.getRecepcion() ||
          			BUsuario.getTurnado()){
          		}
          		else{
          
          out.write(__oracle_jsp_text[30]);
          if (true) {
            String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
            // Forward 
            pageContext.forward( __url);
            return;
          }

          out.write(__oracle_jsp_text[31]);
           		}
          	}
          
          out.write(__oracle_jsp_text[32]);
          out.write(__oracle_jsp_text[33]);
          out.print( strBandera );
          out.write(__oracle_jsp_text[34]);
          out.print(BUsuario.getIdArea());
          out.write(__oracle_jsp_text[35]);
          out.print(BUsuario.getIdUsuario());
          out.write(__oracle_jsp_text[36]);
          out.print(strEstValidacion);
          out.write(__oracle_jsp_text[37]);
          out.print(BUsuario.getIdArea());
          out.write(__oracle_jsp_text[38]);
          out.print(BUsuario.getIdUsuario());
          out.write(__oracle_jsp_text[39]);
          out.print(strEstValidacion);
          out.write(__oracle_jsp_text[40]);
          out.print(strFolioGenerado);
          out.write(__oracle_jsp_text[41]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[42]);
          out.print(strA);
          out.write(__oracle_jsp_text[43]);
          out.print(strEstValidacion);
          out.write(__oracle_jsp_text[44]);
          out.print( Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
          out.write(__oracle_jsp_text[45]);
          out.print(strFolioGenerado);
          out.write(__oracle_jsp_text[46]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[47]);
          out.print(strA);
          out.write(__oracle_jsp_text[48]);
          out.print(strEstValidacion);
          out.write(__oracle_jsp_text[49]);
          out.print( Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
          out.write(__oracle_jsp_text[50]);
          out.print(strFolioGenerado);
          out.write(__oracle_jsp_text[51]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[52]);
          out.print(strA);
          out.write(__oracle_jsp_text[53]);
          out.print( Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
          out.write(__oracle_jsp_text[54]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[55]);
          out.print(URL);
          out.write(__oracle_jsp_text[56]);
          for (int ik=0; ik<finesSemana.size(); ik++){ 
          out.write(__oracle_jsp_text[57]);
          out.print( (String)finesSemana.get(ik) );
          out.write(__oracle_jsp_text[58]);
          }
          out.write(__oracle_jsp_text[59]);
          out.print( retURI );
          out.write(__oracle_jsp_text[60]);
          out.print( retURI );
          out.write(__oracle_jsp_text[61]);
          out.print( strIdAsunto );
          out.write(__oracle_jsp_text[62]);
          out.print( strControl );
          out.write(__oracle_jsp_text[63]);
          out.print(URL);
          out.write(__oracle_jsp_text[64]);
          out.print(strFolioGenerado);
          out.write(__oracle_jsp_text[65]);
          out.print( strIdRemitente );
          out.write(__oracle_jsp_text[66]);
          out.print( strIdEntidad );
          out.write(__oracle_jsp_text[67]);
          out.print( strIdDestinatario );
          out.write(__oracle_jsp_text[68]);
          out.print( strMailDest );
          out.write(__oracle_jsp_text[69]);
          out.print( carga );
          out.write(__oracle_jsp_text[70]);
          out.print( idAsuntoAnt );
          out.write(__oracle_jsp_text[71]);
          out.print( idAsuntoRef );
          out.write(__oracle_jsp_text[72]);
          out.print(strIdsPara);
          out.write(__oracle_jsp_text[73]);
          out.print(strIdsCC);
          out.write(__oracle_jsp_text[74]);
          out.print(strIdsParaE);
          out.write(__oracle_jsp_text[75]);
          out.print(strParaE);
          out.write(__oracle_jsp_text[76]);
          out.print(strFoco);
          out.write(__oracle_jsp_text[77]);
          out.print(strPara);
          out.write(__oracle_jsp_text[78]);
          out.print(strCC);
          out.write(__oracle_jsp_text[79]);
          out.print(retURI);
          out.write(__oracle_jsp_text[80]);
          out.print( strHorarioUAEntrada );
          out.write(__oracle_jsp_text[81]);
          out.print( strHorarioUASalida );
          out.write(__oracle_jsp_text[82]);
          out.print( BUsuario.getIdArea() );
          out.write(__oracle_jsp_text[83]);
          out.print( contador );
          out.write(__oracle_jsp_text[84]);
          out.print( strBandera );
          out.write(__oracle_jsp_text[85]);
          out.print( setFoco );
          out.write(__oracle_jsp_text[86]);
          out.print(strEstatus);
          out.write(__oracle_jsp_text[87]);
          out.print(strEstatus);
          out.write(__oracle_jsp_text[88]);
          out.print(strFeFormateada4);
          out.write(__oracle_jsp_text[89]);
          out.print(strAccionArchivo);
          out.write(__oracle_jsp_text[90]);
          out.print(strIdTramite);
          out.write(__oracle_jsp_text[91]);
          out.print(strEstValidacion);
          out.write(__oracle_jsp_text[92]);
           if(strEstatus.equals("0")){ 
          out.write(__oracle_jsp_text[93]);
           }else if(strEstatus.equals("1")){ 
          out.write(__oracle_jsp_text[94]);
           }else if(strEstatus.equals("2")){ 
          out.write(__oracle_jsp_text[95]);
           }else if(strEstatus.equals("3")){ 
          out.write(__oracle_jsp_text[96]);
           }
          out.write(__oracle_jsp_text[97]);
          {
            org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_1=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
            __jsp_taghandler_1.setParent(null);
            __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
            {
              do {
                out.write(__oracle_jsp_text[98]);
                {
                  org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_2=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
                  __jsp_taghandler_2.setParent(__jsp_taghandler_1);
                  __jsp_taghandler_2.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura1.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
                  __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[99]);
                      if(strEstatus.equals("0") || strIdAsunto.length() == 0){
                      out.write(__oracle_jsp_text[100]);
                      }
                      out.write(__oracle_jsp_text[101]);
                    } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
                }
                out.write(__oracle_jsp_text[102]);
                {
                  org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_3=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
                  __jsp_taghandler_3.setParent(__jsp_taghandler_1);
                  __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[103]);
                    } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
                }
                out.write(__oracle_jsp_text[104]);
              } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
          }
          out.write(__oracle_jsp_text[105]);
          {
            org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_4=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
            __jsp_taghandler_4.setParent(null);
            __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
            {
              do {
                out.write(__oracle_jsp_text[106]);
                {
                  org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_5=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
                  __jsp_taghandler_5.setParent(__jsp_taghandler_4);
                  __jsp_taghandler_5.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
                  __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[107]);
                      out.write(__oracle_jsp_text[108]);
                      if(!strEstatus.equals("2")) { 
                      out.write(__oracle_jsp_text[109]);
                      }
                      out.write(__oracle_jsp_text[110]);
                    } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
                }
                out.write(__oracle_jsp_text[111]);
                {
                  org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_6=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
                  __jsp_taghandler_6.setParent(__jsp_taghandler_4);
                  __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[112]);
                    } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
                }
                out.write(__oracle_jsp_text[113]);
              } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
          }
          out.write(__oracle_jsp_text[114]);
          {
            org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_7=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
            __jsp_taghandler_7.setParent(null);
            __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
            {
              do {
                out.write(__oracle_jsp_text[115]);
                {
                  org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_8=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
                  __jsp_taghandler_8.setParent(__jsp_taghandler_7);
                  __jsp_taghandler_8.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
                  __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[116]);
                      out.write(__oracle_jsp_text[117]);
                      if(!strEstatus.equals("2") && strIdAsunto!=null && strIdAsunto.length()!=0){
                      out.write(__oracle_jsp_text[118]);
                      }
                      out.write(__oracle_jsp_text[119]);
                    } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
                }
                out.write(__oracle_jsp_text[120]);
                {
                  org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_9=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
                  __jsp_taghandler_9.setParent(__jsp_taghandler_7);
                  __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[121]);
                    } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
                }
                out.write(__oracle_jsp_text[122]);
              } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
          }
          out.write(__oracle_jsp_text[123]);
          {
            org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_10=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
            __jsp_taghandler_10.setParent(null);
            __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
            {
              do {
                out.write(__oracle_jsp_text[124]);
                {
                  org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_11=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
                  __jsp_taghandler_11.setParent(__jsp_taghandler_10);
                  __jsp_taghandler_11.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
                  __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[125]);
                      if (strIdAsunto != null && strIdAsunto.trim().length()>0){ 
                      out.write(__oracle_jsp_text[126]);
                      out.print(strIdAsunto );
                      out.write(__oracle_jsp_text[127]);
                      out.print(ids );
                      out.write(__oracle_jsp_text[128]);
                      out.print(refs );
                      out.write(__oracle_jsp_text[129]);
                      }
                      out.write(__oracle_jsp_text[130]);
                    } while (__jsp_taghandler_11.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,2);
                }
                out.write(__oracle_jsp_text[131]);
                {
                  org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_12=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
                  __jsp_taghandler_12.setParent(__jsp_taghandler_10);
                  __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[132]);
                    } while (__jsp_taghandler_12.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
                }
                out.write(__oracle_jsp_text[133]);
              } while (__jsp_taghandler_10.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,1);
          }
          out.write(__oracle_jsp_text[134]);
          {
            org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_13=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
            __jsp_taghandler_13.setParent(null);
            __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
            {
              do {
                out.write(__oracle_jsp_text[135]);
                {
                  org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_14=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
                  __jsp_taghandler_14.setParent(__jsp_taghandler_13);
                  __jsp_taghandler_14.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura2.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
                  __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[136]);
                      if(strEstatus.equals("1") && !ActualizaAsuntoTurnado.existenInstruccionesNuevasSinTurnar(strIdAsunto)){
                      out.write(__oracle_jsp_text[137]);
                      }else{
                      out.write(__oracle_jsp_text[138]);
                      }
                      out.write(__oracle_jsp_text[139]);
                    } while (__jsp_taghandler_14.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,2);
                }
                out.write(__oracle_jsp_text[140]);
                {
                  org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_15=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
                  __jsp_taghandler_15.setParent(__jsp_taghandler_13);
                  __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[141]);
                    } while (__jsp_taghandler_15.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,2);
                }
                out.write(__oracle_jsp_text[142]);
              } while (__jsp_taghandler_13.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,1);
          }
          out.write(__oracle_jsp_text[143]);
          out.print(strMensajeDuplicado);
          out.write(__oracle_jsp_text[144]);
           if(strIdAsunto != null && strIdAsunto.trim().length()>0){ 
          out.write(__oracle_jsp_text[145]);
          out.print( ActualizaUsuario.NombreUsuario(strCreador1) );
          out.write(__oracle_jsp_text[146]);
          out.print( strFeFormateada4 );
          out.write(__oracle_jsp_text[147]);
          out.print( strEstatusN );
          out.write(__oracle_jsp_text[148]);
          out.print( strFolioGenerado );
          out.write(__oracle_jsp_text[149]);
           } else { 
          out.write(__oracle_jsp_text[150]);
          out.print( BUsuario.getCargo() );
          out.write(__oracle_jsp_text[151]);
          out.print( strFechaCreacion );
          out.write(__oracle_jsp_text[152]);
           } 
          out.write(__oracle_jsp_text[153]);
          out.write(__oracle_jsp_text[154]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[155]);
          }else{
          out.write(__oracle_jsp_text[156]);
          out.write(__oracle_jsp_text[157]);
          if(strIdAsunto != null && strIdAsunto.trim().length() >0 && bexisteInst == true){
          out.write(__oracle_jsp_text[158]);
          }else{
          out.write(__oracle_jsp_text[159]);
          out.print(strAreaUs);
          out.write(__oracle_jsp_text[160]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[161]);
          out.print( (strControl!=null && strControl.equals("0"))?"0":"1" );
          out.write(__oracle_jsp_text[162]);
          out.print(strIdEntidad+"|"+strEntidad+"/"+strControl);
          out.write(__oracle_jsp_text[163]);
          }
          out.write(__oracle_jsp_text[164]);
          }
          out.write(__oracle_jsp_text[165]);
          out.write(__oracle_jsp_text[166]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[167]);
           if (strDatosDes.length!=0){ 
          out.write(__oracle_jsp_text[168]);
          out.print( strDatosDes[0][1] );
          out.write(__oracle_jsp_text[169]);
           }else{ 
          out.write(__oracle_jsp_text[170]);
          out.print( strEntidad);
          out.write(__oracle_jsp_text[171]);
           } 
          out.write(__oracle_jsp_text[172]);
          }else{
          out.write(__oracle_jsp_text[173]);
          out.print( strEntidad );
          out.write(__oracle_jsp_text[174]);
          }
          out.write(__oracle_jsp_text[175]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[176]);
          }else{
          out.write(__oracle_jsp_text[177]);
          if(strIdAsunto != null && strIdAsunto.length() >0 && bexisteInst == true){
          out.write(__oracle_jsp_text[178]);
          }else{
          out.write(__oracle_jsp_text[179]);
          }
          out.write(__oracle_jsp_text[180]);
          }
          out.write(__oracle_jsp_text[181]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[182]);
           if (strDatosDes.length!=0){ 
          out.write(__oracle_jsp_text[183]);
          out.print( strDatosDes[0][3] );
          out.write(__oracle_jsp_text[184]);
          out.print( strDatosDes[0][2] );
          out.write(__oracle_jsp_text[185]);
           }else{ 
          out.write(__oracle_jsp_text[186]);
          out.print( strRemitente );
          out.write(__oracle_jsp_text[187]);
           } 
          out.write(__oracle_jsp_text[188]);
          out.print( strCargo );
          out.write(__oracle_jsp_text[189]);
          out.print(strCorreo);
          out.write(__oracle_jsp_text[190]);
          }else{
          out.write(__oracle_jsp_text[191]);
          out.print( strRemitente );
          out.write(__oracle_jsp_text[192]);
          out.print(strCargo);
          out.write(__oracle_jsp_text[193]);
          out.print(strCorreo);
          out.write(__oracle_jsp_text[194]);
          }
          out.write(__oracle_jsp_text[195]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[196]);
          out.print( strFirmante );
          out.write(__oracle_jsp_text[197]);
          }else{
          out.write(__oracle_jsp_text[198]);
          out.print( strFirmante );
          out.write(__oracle_jsp_text[199]);
          }
          out.write(__oracle_jsp_text[200]);
          if(strIdAsunto != null && strIdAsunto.trim().length()>0){ 
          out.write(__oracle_jsp_text[201]);
          out.print((strTipoFolio.equals("1")?"Salida":"Entrada"));
          out.write(__oracle_jsp_text[202]);
          out.print(strTipoFolio);
          out.write(__oracle_jsp_text[203]);
          }else{
          out.write(__oracle_jsp_text[204]);
          if(strTipoFolio.length()==0){
          out.write(__oracle_jsp_text[205]);
          out.print(strTipoFolio);
          out.write(__oracle_jsp_text[206]);
          }else if(strTipoFolio.length()!=0){
          out.write(__oracle_jsp_text[207]);
          out.print((strTipoFolio.equals("1")?"Salida":"Entrada"));
          out.write(__oracle_jsp_text[208]);
          out.print(strTipoFolio);
          out.write(__oracle_jsp_text[209]);
          }
          out.write(__oracle_jsp_text[210]);
          }
          out.write(__oracle_jsp_text[211]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[212]);
          }else{
          out.write(__oracle_jsp_text[213]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[214]);
          out.print(BUsuario.getIdArea());
          out.write(__oracle_jsp_text[215]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[216]);
          }
          out.write(__oracle_jsp_text[217]);
          out.print(BUsuario.getIdArea());
          out.write(__oracle_jsp_text[218]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[219]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[220]);
           if (strDatosDes.length!=0){ 
          out.write(__oracle_jsp_text[221]);
          out.print( strDatosDes[0][6] );
          out.write(__oracle_jsp_text[222]);
           }else{ 
          out.write(__oracle_jsp_text[223]);
          out.print( strDestinatario );
          out.write(__oracle_jsp_text[224]);
           } 
          out.write(__oracle_jsp_text[225]);
          out.print(strCargoDest);
          out.write(__oracle_jsp_text[226]);
          out.print(strAreaDest);
          out.write(__oracle_jsp_text[227]);
          }else{
          out.write(__oracle_jsp_text[228]);
          out.print( strDestinatario );
          out.write(__oracle_jsp_text[229]);
          out.print(strCargoDest);
          out.write(__oracle_jsp_text[230]);
          out.print(strAreaDest);
          out.write(__oracle_jsp_text[231]);
          }
          out.write(__oracle_jsp_text[232]);
          if(strIdAsunto != null && strIdAsunto.length() >0 && bexisteInst == true){
          out.write(__oracle_jsp_text[233]);
          }else{
          out.write(__oracle_jsp_text[234]);
          out.print(strTipoFolio );
          out.write(__oracle_jsp_text[235]);
          out.print(BUsuario.getIdArea());
          out.write(__oracle_jsp_text[236]);
          out.print(Utilerias.getCadenaParaCC(listaIDSPara));
          out.write(__oracle_jsp_text[237]);
          out.print(Utilerias.getCadenaParaCC(listaIDSCC));
          out.write(__oracle_jsp_text[238]);
          out.print(strIdsPara);
          out.write(__oracle_jsp_text[239]);
          out.print(strIdsCC);
          out.write(__oracle_jsp_text[240]);
          }
          out.write(__oracle_jsp_text[241]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[242]);
           if (strDatosDesPara.length!=0){ 
          out.write(__oracle_jsp_text[243]);
          for(int t=0; t<strDatosDesPara.length; t++){
          out.write(__oracle_jsp_text[244]);
          out.print( strDatosDesPara[t][0] );
          out.write(__oracle_jsp_text[245]);
          }
          out.write(__oracle_jsp_text[246]);
          }else{
          out.write(__oracle_jsp_text[247]);
          for(int t=0;t<listaIDSPara.size();t++){
          out.write(__oracle_jsp_text[248]);
          out.print(listaIDSPara.elementAt(t));
          out.write(__oracle_jsp_text[249]);
          out.print(listaIDSPara.elementAt(t));
          out.write(__oracle_jsp_text[250]);
          }
          out.write(__oracle_jsp_text[251]);
          }
          out.write(__oracle_jsp_text[252]);
          }else{
          out.write(__oracle_jsp_text[253]);
          for(int t=0;t<listaIDSPara.size();t++){
          out.write(__oracle_jsp_text[254]);
          out.print(listaIDSPara.elementAt(t));
          out.write(__oracle_jsp_text[255]);
          out.print(listaIDSPara.elementAt(t));
          out.write(__oracle_jsp_text[256]);
          }
          out.write(__oracle_jsp_text[257]);
          }
          out.write(__oracle_jsp_text[258]);
          if(strDatosDesCC.length!=0 && (strEstatus.equals("2") || strEstatus.equals("3"))){
          out.write(__oracle_jsp_text[259]);
          for(int t=0;t<strDatosDesCC.length;t++){
          out.write(__oracle_jsp_text[260]);
          out.print( strDatosDesCC[t][0] );
          out.write(__oracle_jsp_text[261]);
          }
          out.write(__oracle_jsp_text[262]);
          }else{
          out.write(__oracle_jsp_text[263]);
          for(int t=0;t<listaIDSCC.size();t++){
          out.write(__oracle_jsp_text[264]);
          out.print(listaIDSCC.elementAt(t));
          out.write(__oracle_jsp_text[265]);
          out.print(listaIDSCC.elementAt(t));
          out.write(__oracle_jsp_text[266]);
          }
          out.write(__oracle_jsp_text[267]);
          }
          out.write(__oracle_jsp_text[268]);
          if(strIdAsunto != null && strIdAsunto.length() >0 && bexisteInst == true){
          out.write(__oracle_jsp_text[269]);
          }else{
          out.write(__oracle_jsp_text[270]);
          out.print(Utilerias.codificaPostHTML(Utilerias.getCadenaParaCC(listaIDSParaExt)));
          out.write(__oracle_jsp_text[271]);
          out.print(strIdsParaE);
          out.write(__oracle_jsp_text[272]);
          out.print( strAreaUs );
          out.write(__oracle_jsp_text[273]);
          }
          out.write(__oracle_jsp_text[274]);
          if(strDatosDes.length!=0 && (strEstatus.equals("2") || strEstatus.equals("3"))){
          out.write(__oracle_jsp_text[275]);
          for(int t=0;t<listaIDSParaExt.size();t++){
          out.write(__oracle_jsp_text[276]);
          out.print(listaIDSParaExt.elementAt(t));
          out.write(__oracle_jsp_text[277]);
          out.print(listaIDSParaExt.elementAt(t));
          out.write(__oracle_jsp_text[278]);
          }
          out.write(__oracle_jsp_text[279]);
          }else{
          out.write(__oracle_jsp_text[280]);
          for(int t=0;t<listaIDSParaExt.size();t++){
          out.write(__oracle_jsp_text[281]);
          out.print(listaIDSParaExt.elementAt(t));
          out.write(__oracle_jsp_text[282]);
          out.print(listaIDSParaExt.elementAt(t));
          out.write(__oracle_jsp_text[283]);
          }
          out.write(__oracle_jsp_text[284]);
          }
          out.write(__oracle_jsp_text[285]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[286]);
          out.print( strAsunto );
          out.write(__oracle_jsp_text[287]);
          }else{
          out.write(__oracle_jsp_text[288]);
          out.print( strAsunto );
          out.write(__oracle_jsp_text[289]);
          }
          out.write(__oracle_jsp_text[290]);
          {
            org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_16=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
            __jsp_taghandler_16.setParent(null);
            __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
            {
              do {
                out.write(__oracle_jsp_text[291]);
                {
                  org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_17=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
                  __jsp_taghandler_17.setParent(__jsp_taghandler_16);
                  __jsp_taghandler_17.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
                  __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[292]);
                      	if(strDatosDes.length!=0 && (strEstatus.equals("2") || strEstatus.equals("3"))){ 
                      out.write(__oracle_jsp_text[293]);
                      out.print(strDatosDes[0][9]);
                      out.write(__oracle_jsp_text[294]);
                      out.print(strIdTipoDocto);
                      out.write(__oracle_jsp_text[295]);
                      out.print(strIdTipoDocto);
                      out.write(__oracle_jsp_text[296]);
                      	}else{ 
                      out.write(__oracle_jsp_text[297]);
                       if(strIdAsunto != null && strIdAsunto.length() >0 && bexisteInst == false){ 
                      out.write(__oracle_jsp_text[298]);
                       
                      				String strComboTipDoc[][] = null;
                      				String strComboTipDocGral[][] = null;
                      				strComboTipDoc = ComboData.getTipoDoctoAreaCombo(strAreaUs);
                      				strComboTipDocGral = ComboData.getTipoDoctosGralesCombo();
                      			
                      out.write(__oracle_jsp_text[299]);
                       for(int q=0;q<strComboTipDoc.length;q++){ 
                      out.write(__oracle_jsp_text[300]);
                      out.print(strComboTipDoc[q][0]);
                      out.write(__oracle_jsp_text[301]);
                      out.print((strIdTipoDocto.trim().equals(strComboTipDoc[q][0])?"selected":""));
                      out.write(__oracle_jsp_text[302]);
                      out.print(strComboTipDoc[q][1]);
                      out.write(__oracle_jsp_text[303]);
                       } 
                      out.write(__oracle_jsp_text[304]);
                       for(int y=0;y<strComboTipDocGral.length;y++){ 
                      out.write(__oracle_jsp_text[305]);
                      out.print(strComboTipDocGral[y][0]);
                      out.write(__oracle_jsp_text[306]);
                      out.print((strIdTipoDocto.trim().equals(strComboTipDocGral[y][0])?"selected":""));
                      out.write(__oracle_jsp_text[307]);
                      out.print(strComboTipDocGral[y][1]);
                      out.write(__oracle_jsp_text[308]);
                       } 
                      out.write(__oracle_jsp_text[309]);
                      out.print(strIdTipoDocto);
                      out.write(__oracle_jsp_text[310]);
                      out.print(strIdTipoDocto);
                      out.write(__oracle_jsp_text[311]);
                       }else if(strIdAsunto != null && strIdAsunto.length() >0 && bexisteInst == true){ 
                      out.write(__oracle_jsp_text[312]);
                      {
                        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_18=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml textoNoSeleccion valorNoSeleccion");
                        __jsp_taghandler_18.setParent(__jsp_taghandler_17);
                        __jsp_taghandler_18.setData(ComboData.getTipoDoctoAreaCombo(strAreaUs));
                        __jsp_taghandler_18.setName("asuntoTipoDocto_1");
                        __jsp_taghandler_18.setSize(1);
                        __jsp_taghandler_18.setSelected(OracleJspRuntime.toStr( strIdTipoDocto));
                        __jsp_taghandler_18.setDisabled(true);
                        __jsp_taghandler_18.setClassHtml("blue600a");
                        __jsp_taghandler_18.setTextoNoSeleccion("  ");
                        __jsp_taghandler_18.setValorNoSeleccion("-1");
                        __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
                        if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                          return;
                        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,3);
                      }
                      out.write(__oracle_jsp_text[313]);
                      out.print(strIdTipoDocto);
                      out.write(__oracle_jsp_text[314]);
                      out.print(strIdTipoDocto);
                      out.write(__oracle_jsp_text[315]);
                       }else{ 
                      out.write(__oracle_jsp_text[316]);
                       
                      				String strComboTipDoc[][] = null;
                      				String strComboTipDocGral[][] = null;
                      				strComboTipDoc = ComboData.getTipoDoctoAreaCombo(strAreaUs);
                      				strComboTipDocGral = ComboData.getTipoDoctosGralesCombo();
                      			
                      out.write(__oracle_jsp_text[317]);
                       for(int q=0;q<strComboTipDoc.length;q++){ 
                      out.write(__oracle_jsp_text[318]);
                      out.print(strComboTipDoc[q][0]);
                      out.write(__oracle_jsp_text[319]);
                      out.print((strIdTipoDocto.trim().equals(strComboTipDoc[q][0])?"selected":""));
                      out.write(__oracle_jsp_text[320]);
                      out.print(strComboTipDoc[q][1]);
                      out.write(__oracle_jsp_text[321]);
                       } 
                      out.write(__oracle_jsp_text[322]);
                       for(int y=0;y<strComboTipDocGral.length;y++){ 
                      out.write(__oracle_jsp_text[323]);
                      out.print(strComboTipDocGral[y][0]);
                      out.write(__oracle_jsp_text[324]);
                      out.print((strIdTipoDocto.trim().equals(strComboTipDocGral[y][0])?"selected":""));
                      out.write(__oracle_jsp_text[325]);
                      out.print(strComboTipDocGral[y][1]);
                      out.write(__oracle_jsp_text[326]);
                       } 
                      out.write(__oracle_jsp_text[327]);
                       } 
                      out.write(__oracle_jsp_text[328]);
                       } 
                      out.write(__oracle_jsp_text[329]);
                    } while (__jsp_taghandler_17.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,2);
                }
                out.write(__oracle_jsp_text[330]);
                {
                  org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_19=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
                  __jsp_taghandler_19.setParent(__jsp_taghandler_16);
                  __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[331]);
                    } while (__jsp_taghandler_19.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,2);
                }
                out.write(__oracle_jsp_text[332]);
              } while (__jsp_taghandler_16.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,1);
          }
          out.write(__oracle_jsp_text[333]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[334]);
          out.print(strFeFormateada1);
          out.write(__oracle_jsp_text[335]);
          for(int i=0;i<24;i++){
          out.write(__oracle_jsp_text[336]);
          
          				String a = String.valueOf(i);
          				if(a.length()==1)
          					a="0"+a;
          				if(strHoraRecep.length()==1)
          					strHoraRecep="0"+strHoraRecep;
          				
          out.write(__oracle_jsp_text[337]);
          out.print(a);
          out.write(__oracle_jsp_text[338]);
          out.print((strHoraRecep.equals(a)?"selected":""));
          out.write(__oracle_jsp_text[339]);
          out.print(a);
          out.write(__oracle_jsp_text[340]);
          }
          out.write(__oracle_jsp_text[341]);
          for(int i=0;i<60;i++){
          out.write(__oracle_jsp_text[342]);
          
          				String a = String.valueOf(i);
          				if(a.length()==1)
          					a="0"+a;
          				if(strMinRecep.length()==1)
          					strMinRecep="0"+strMinRecep;
          				
          out.write(__oracle_jsp_text[343]);
          out.print(a);
          out.write(__oracle_jsp_text[344]);
          out.print((strMinRecep.equals(a)?"selected":""));
          out.write(__oracle_jsp_text[345]);
          out.print(a);
          out.write(__oracle_jsp_text[346]);
          }
          out.write(__oracle_jsp_text[347]);
           }else{ 
          out.write(__oracle_jsp_text[348]);
          out.print(strFeFormateada1);
          out.write(__oracle_jsp_text[349]);
          for(int i=0;i<24;i++){
          out.write(__oracle_jsp_text[350]);
          
          				String a = String.valueOf(i);
          				if(a.length()==1)
          					a="0"+a;
          				if(strHoraRecep.length()==1)
          					strHoraRecep="0"+strHoraRecep;
          				
          out.write(__oracle_jsp_text[351]);
          out.print(a);
          out.write(__oracle_jsp_text[352]);
          out.print((strHoraRecep.equals(a)?"selected":""));
          out.write(__oracle_jsp_text[353]);
          out.print(a);
          out.write(__oracle_jsp_text[354]);
          }
          out.write(__oracle_jsp_text[355]);
          for(int i=0;i<60;i++){
          out.write(__oracle_jsp_text[356]);
          
          				String a = String.valueOf(i);
          				if(a.length()==1)
          					a="0"+a;
          				if(strMinRecep.length()==1)
          					strMinRecep="0"+strMinRecep;
          				
          out.write(__oracle_jsp_text[357]);
          out.print(a);
          out.write(__oracle_jsp_text[358]);
          out.print((strMinRecep.equals(a)?"selected":""));
          out.write(__oracle_jsp_text[359]);
          out.print(a);
          out.write(__oracle_jsp_text[360]);
          }
          out.write(__oracle_jsp_text[361]);
          }
          out.write(__oracle_jsp_text[362]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[363]);
          out.print( strFechaDocto );
          out.write(__oracle_jsp_text[364]);
           }else{ 
          out.write(__oracle_jsp_text[365]);
          out.print( strFechaDocto );
          out.write(__oracle_jsp_text[366]);
          }
          out.write(__oracle_jsp_text[367]);
          if(strDatosDes.length!=0 && (strEstatus.equals("2") || strEstatus.equals("3"))){
          out.write(__oracle_jsp_text[368]);
          out.print( strDatosDes[0][11] );
          out.write(__oracle_jsp_text[369]);
          
          					String strTramite1[][] = null;
          					strTramite1 =  ActualizaTramite.getComboTramite(BUsuario.getIdArea());  
          					for(int i=0;i<strTramite1.length;i++){
          				
          out.write(__oracle_jsp_text[370]);
          out.print(strTramite1[i][0]);
          out.write(__oracle_jsp_text[371]);
          out.print((strTramite.equals(strTramite1[i][0])?"selected":""));
          out.write(__oracle_jsp_text[372]);
          out.print(strTramite1[i][1]);
          out.write(__oracle_jsp_text[373]);
          }
          out.write(__oracle_jsp_text[374]);
          
          					String strTramite2[][] = null;
          					strTramite2 =  ActualizaTramite.getComboTramiteGral();
          					for(int i=0;i<strTramite2.length;i++){
          				
          out.write(__oracle_jsp_text[375]);
          out.print(strTramite2[i][0]);
          out.write(__oracle_jsp_text[376]);
          out.print((strTramite.equals(strTramite2[i][0])?"selected":""));
          out.write(__oracle_jsp_text[377]);
          out.print(strTramite2[i][1]);
          out.write(__oracle_jsp_text[378]);
          }
          out.write(__oracle_jsp_text[379]);
          }else{
          out.write(__oracle_jsp_text[380]);
          
          					String strTramite1[][] = null;
          					strTramite1 =  ActualizaTramite.getComboTramite(BUsuario.getIdArea());
          					for(int i=0;i<strTramite1.length;i++){
          				
          out.write(__oracle_jsp_text[381]);
          out.print(strTramite1[i][0]);
          out.write(__oracle_jsp_text[382]);
          out.print((strTramite.equals(strTramite1[i][0])?"selected":""));
          out.write(__oracle_jsp_text[383]);
          out.print(strTramite1[i][1]);
          out.write(__oracle_jsp_text[384]);
          }
          out.write(__oracle_jsp_text[385]);
          
          					String strTramite2[][] = null;
          					strTramite2 =  ActualizaTramite.getComboTramiteGral();
          					for(int i=0;i<strTramite2.length;i++){					
          				
          out.write(__oracle_jsp_text[386]);
          out.print(strTramite2[i][0]);
          out.write(__oracle_jsp_text[387]);
          out.print((strTramite.equals(strTramite2[i][0])?"selected":""));
          out.write(__oracle_jsp_text[388]);
          out.print(strTramite2[i][1]);
          out.write(__oracle_jsp_text[389]);
          }
          out.write(__oracle_jsp_text[390]);
          }
          out.write(__oracle_jsp_text[391]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[392]);
          out.print( strFechaCaducidad );
          out.write(__oracle_jsp_text[393]);
           }else{ 
          out.write(__oracle_jsp_text[394]);
          if(strIdAsunto.length()==0){
          out.write(__oracle_jsp_text[395]);
          if(Asunto.getAsuntoTramite()==null || Asunto.getAsuntoTramite().equals("-1")){
          out.write(__oracle_jsp_text[396]);
          out.print( strFechaCaducidad );
          out.write(__oracle_jsp_text[397]);
          }else{
          out.write(__oracle_jsp_text[398]);
          out.print( strFechaCaducidad );
          out.write(__oracle_jsp_text[399]);
          out.print( strFechaCaducidad );
          out.write(__oracle_jsp_text[400]);
          }
          out.write(__oracle_jsp_text[401]);
          }else{
          out.write(__oracle_jsp_text[402]);
          if(strTramite.length()==0 || strTramite.equals("-1")){
          out.write(__oracle_jsp_text[403]);
          out.print( strFechaCaducidad );
          out.write(__oracle_jsp_text[404]);
          }else{
          out.write(__oracle_jsp_text[405]);
          out.print( strFechaCaducidad );
          out.write(__oracle_jsp_text[406]);
          out.print( strFechaCaducidad );
          out.write(__oracle_jsp_text[407]);
          }
          out.write(__oracle_jsp_text[408]);
          }
          out.write(__oracle_jsp_text[409]);
          }
          out.write(__oracle_jsp_text[410]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[411]);
          out.print( strFolioExterno );
          out.write(__oracle_jsp_text[412]);
          }else{
          out.write(__oracle_jsp_text[413]);
          out.print( strFolioExterno );
          out.write(__oracle_jsp_text[414]);
          }
          out.write(__oracle_jsp_text[415]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[416]);
          out.print( strFolioIntermedio );
          out.write(__oracle_jsp_text[417]);
          }else{
          out.write(__oracle_jsp_text[418]);
          out.print( strFolioIntermedio );
          out.write(__oracle_jsp_text[419]);
          }
          out.write(__oracle_jsp_text[420]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[421]);
          out.print( strSintesis );
          out.write(__oracle_jsp_text[422]);
          }else{
          out.write(__oracle_jsp_text[423]);
          out.print( strSintesis );
          out.write(__oracle_jsp_text[424]);
          }
          out.write(__oracle_jsp_text[425]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[426]);
          out.print( strComentarios );
          out.write(__oracle_jsp_text[427]);
          }else{
          out.write(__oracle_jsp_text[428]);
          out.print( strComentarios );
          out.write(__oracle_jsp_text[429]);
          }
          out.write(__oracle_jsp_text[430]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[431]);
          out.print( strPalabraClave );
          out.write(__oracle_jsp_text[432]);
          }else{
          out.write(__oracle_jsp_text[433]);
          out.print( strPalabraClave );
          out.write(__oracle_jsp_text[434]);
          }
          out.write(__oracle_jsp_text[435]);
           if(strIdAsunto != null && strIdAsunto.trim().length()>0){ 
          out.write(__oracle_jsp_text[436]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[437]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[438]);
          }else{
          out.write(__oracle_jsp_text[439]);
          
          						boolean bExisteExp = false;
          						String strExpedienteArea[][] = null; 
          						String strExpedienteGral[][] = null;
          						strExpedienteArea = ComboData.getExpedienteCombo(strAreaUs);
          						strExpedienteGral = ComboData.getExpedienteComboGral();
          						bExisteExp = ActualizaExpediente.getExisteExpedientesPorAreaArch(strAreaUs);
                                          	
          out.write(__oracle_jsp_text[440]);
           for(int z=0;z<strExpedienteArea.length;z++){ 
          out.write(__oracle_jsp_text[441]);
          out.print(strExpedienteArea[z][0]);
          out.write(__oracle_jsp_text[442]);
          out.print((strIdExpediente.trim().equals(strExpedienteArea[z][0])?"selected":""));
          out.write(__oracle_jsp_text[443]);
          out.print(strExpedienteArea[z][1]);
          out.write(__oracle_jsp_text[444]);
           } 
          out.write(__oracle_jsp_text[445]);
          }
          out.write(__oracle_jsp_text[446]);
           }else{ 
          out.write(__oracle_jsp_text[447]);
          
          						boolean bExisteExp = false;
          						String strExpedienteArea[][] = null;
          						String strExpedienteGral[][] = null;
          						strExpedienteArea = ComboData.getExpedienteCombo(strAreaUs);
          						strExpedienteGral = ComboData.getExpedienteComboGral();
          						bExisteExp = ActualizaExpediente.getExisteExpedientesPorArea(strAreaUs);
                                          
          					
          out.write(__oracle_jsp_text[448]);
           for(int z=0;z<strExpedienteArea.length;z++){ 
          out.write(__oracle_jsp_text[449]);
          out.print(strExpedienteArea[z][0]);
          out.write(__oracle_jsp_text[450]);
          out.print((strIdExpediente.trim().equals(strExpedienteArea[z][0])?"selected":""));
          out.write(__oracle_jsp_text[451]);
          out.print(strExpedienteArea[z][1]);
          out.write(__oracle_jsp_text[452]);
           } 
          out.write(__oracle_jsp_text[453]);
           } 
          out.write(__oracle_jsp_text[454]);
          if (strDatosAsuntoAnt.length == 0 && strDatosAsuntoLigas.length==0){
          out.write(__oracle_jsp_text[455]);
          }else{
          out.write(__oracle_jsp_text[456]);
          if(strDatosAsuntoAnt.length!=0){
          out.write(__oracle_jsp_text[457]);
          
          	String strConsulta[][];
          	for (int m = 0; m < strDatosAsuntoAnt.length ; m ++){
          		strConsulta = ActualizaBuscar.getBusquedaAsuntosAnidados(strDatosAsuntoAnt[m][0]);
          	
          out.write(__oracle_jsp_text[458]);
          if(par(m)==true){
          out.write(__oracle_jsp_text[459]);
          }else{
          out.write(__oracle_jsp_text[460]);
          }
          out.write(__oracle_jsp_text[461]);
          out.print( strFolioGenerado );
          out.write(__oracle_jsp_text[462]);
          out.print(strDatosAsuntoAnt[m][1]);
          out.write(__oracle_jsp_text[463]);
          out.print( strConsulta[0][0] );
          out.write(__oracle_jsp_text[464]);
          out.print( Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
          out.write(__oracle_jsp_text[465]);
          out.print( strConsulta[0][1] );
          out.write(__oracle_jsp_text[466]);
          out.print(strDatosAsuntoAnt[m][1]);
          out.write(__oracle_jsp_text[467]);
          out.print(strConsulta[0][2]);
          out.write(__oracle_jsp_text[468]);
           if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_EN_RECEPCION))){ 
          out.write(__oracle_jsp_text[469]);
           }else if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_POR_TURNAR))){ 
          out.write(__oracle_jsp_text[470]);
           }else if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_TURNADO))){ 
          out.write(__oracle_jsp_text[471]);
           }else if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_TERMINADO))){ 
          out.write(__oracle_jsp_text[472]);
           }
          out.write(__oracle_jsp_text[473]);
          }
          out.write(__oracle_jsp_text[474]);
          }
          out.write(__oracle_jsp_text[475]);
          if(strDatosAsuntoLigas.length!=0){
          out.write(__oracle_jsp_text[476]);
          
          	String strConsulta[][];
          	for (int m = 0; m < strDatosAsuntoLigas.length ; m ++){
          		strConsulta = ActualizaBuscar.getBusquedaAsuntosAnidadosLigado(strDatosAsuntoLigas[m][0]);
          	
          out.write(__oracle_jsp_text[477]);
          if(par(m)==true){
          out.write(__oracle_jsp_text[478]);
          }else{
          out.write(__oracle_jsp_text[479]);
          }
          out.write(__oracle_jsp_text[480]);
          if(!strConsulta[0][1].equals("folio por asignar")){
          out.write(__oracle_jsp_text[481]);
          out.print( strConsulta[0][0] );
          out.write(__oracle_jsp_text[482]);
          out.print( Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
          out.write(__oracle_jsp_text[483]);
          out.print( strConsulta[0][1] );
          out.write(__oracle_jsp_text[484]);
          }else{
          out.write(__oracle_jsp_text[485]);
          out.print( strConsulta[0][0] );
          out.write(__oracle_jsp_text[486]);
          out.print( Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
          out.write(__oracle_jsp_text[487]);
          out.print( strConsulta[0][1] );
          out.write(__oracle_jsp_text[488]);
          }
          out.write(__oracle_jsp_text[489]);
          out.print(strDatosAsuntoLigas[m][1]);
          out.write(__oracle_jsp_text[490]);
          out.print(strFolioGenerado);
          out.write(__oracle_jsp_text[491]);
          out.print(strDatosAsuntoLigas[m][1]);
          out.write(__oracle_jsp_text[492]);
          out.print(strConsulta[0][2]);
          out.write(__oracle_jsp_text[493]);
          out.print(strConsulta[0][3]);
          out.write(__oracle_jsp_text[494]);
          }
          out.write(__oracle_jsp_text[495]);
          }
          out.write(__oracle_jsp_text[496]);
          }
          out.write(__oracle_jsp_text[497]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[498]);
          out.print( strFormateada );
          out.write(__oracle_jsp_text[499]);
          }else{
          out.write(__oracle_jsp_text[500]);
          out.print( strFormateada );
          out.write(__oracle_jsp_text[501]);
          }
          out.write(__oracle_jsp_text[502]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[503]);
          for(int i=0;i<24;i++){
          out.write(__oracle_jsp_text[504]);
          
          				String a = String.valueOf(i);
          				if(a.length()==1)
          					a="0"+a;
          				if(strHoraEvento.length()==1)
          					strHoraEvento="0"+strHoraEvento;
          				
          out.write(__oracle_jsp_text[505]);
          out.print(a);
          out.write(__oracle_jsp_text[506]);
          out.print((strHoraEvento.equals(a)?"selected":""));
          out.write(__oracle_jsp_text[507]);
          out.print(a);
          out.write(__oracle_jsp_text[508]);
          }
          out.write(__oracle_jsp_text[509]);
          for(int i=0;i<60;i++){
          out.write(__oracle_jsp_text[510]);
          
          				String a = String.valueOf(i);
          				if(a.length()==1)
          					a="0"+a;
          				if(strMinEvento.length()==1)
          					strMinEvento="0"+strMinEvento;
          				
          out.write(__oracle_jsp_text[511]);
          out.print(a);
          out.write(__oracle_jsp_text[512]);
          out.print((strMinEvento.equals(a)?"selected":""));
          out.write(__oracle_jsp_text[513]);
          out.print(a);
          out.write(__oracle_jsp_text[514]);
          }
          out.write(__oracle_jsp_text[515]);
          }else{
          out.write(__oracle_jsp_text[516]);
          for(int i=0;i<24;i++){
          out.write(__oracle_jsp_text[517]);
          
          				String a = String.valueOf(i);
          				if(a.length()==1)
          					a="0"+a;
          				if(strHoraEvento.length()==1)
          					strHoraEvento="0"+strHoraEvento;
          				
          out.write(__oracle_jsp_text[518]);
          out.print(a);
          out.write(__oracle_jsp_text[519]);
          out.print((strHoraEvento.equals(a)?"selected":""));
          out.write(__oracle_jsp_text[520]);
          out.print(a);
          out.write(__oracle_jsp_text[521]);
          }
          out.write(__oracle_jsp_text[522]);
          for(int i=0;i<60;i++){
          out.write(__oracle_jsp_text[523]);
          
          				String a = String.valueOf(i);
          				if(a.length()==1)
          					a="0"+a;
          				if(strMinEvento.length()==1)
          					strMinEvento="0"+strMinEvento;
          				
          out.write(__oracle_jsp_text[524]);
          out.print(a);
          out.write(__oracle_jsp_text[525]);
          out.print((strMinEvento.equals(a)?"selected":""));
          out.write(__oracle_jsp_text[526]);
          out.print(a);
          out.write(__oracle_jsp_text[527]);
          }
          out.write(__oracle_jsp_text[528]);
          }
          out.write(__oracle_jsp_text[529]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[530]);
          out.print(strLugarEvento );
          out.write(__oracle_jsp_text[531]);
          }else{
          out.write(__oracle_jsp_text[532]);
          out.print(strLugarEvento );
          out.write(__oracle_jsp_text[533]);
          }
          out.write(__oracle_jsp_text[534]);
          {
            org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_20=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
            __jsp_taghandler_20.setParent(null);
            __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
            {
              do {
                out.write(__oracle_jsp_text[535]);
                {
                  org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_21=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
                  __jsp_taghandler_21.setParent(__jsp_taghandler_20);
                  __jsp_taghandler_21.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura2.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
                  __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[536]);
                      if(strDatosDes.length!=0 && (strEstatus.equals("2") || strEstatus.equals("3"))){
                      out.write(__oracle_jsp_text[537]);
                      out.print( strDatosDes[0][13] );
                      out.write(__oracle_jsp_text[538]);
                      }else{
                      out.write(__oracle_jsp_text[539]);
                      
                      							String strPrioridadArea[][] = null;
                      							String strPrioridadGral[][] = null;
                      							strPrioridadArea = ComboData.getPrioridadAreaCombo(strAreaUs);
                      							strPrioridadGral = ComboData.getPrioridadAreaComboGral();
                      						
                      out.write(__oracle_jsp_text[540]);
                       for(int x=0;x<strPrioridadArea.length;x++){ 
                      out.write(__oracle_jsp_text[541]);
                      out.print(strPrioridadArea[x][0]);
                      out.write(__oracle_jsp_text[542]);
                      out.print((strIdPrioridad.trim().equals(strPrioridadArea[x][0])?"selected":""));
                      out.write(__oracle_jsp_text[543]);
                      out.print(strPrioridadArea[x][1]);
                      out.write(__oracle_jsp_text[544]);
                       } 
                      out.write(__oracle_jsp_text[545]);
                       for(int x=0;x<strPrioridadGral.length;x++){ 
                      out.write(__oracle_jsp_text[546]);
                      out.print(strPrioridadGral[x][0]);
                      out.write(__oracle_jsp_text[547]);
                      out.print((strIdPrioridad.trim().equals(strPrioridadGral[x][0])?"selected":""));
                      out.write(__oracle_jsp_text[548]);
                      out.print(strPrioridadGral[x][1]);
                      out.write(__oracle_jsp_text[549]);
                       } 
                      out.write(__oracle_jsp_text[550]);
                      }
                      out.write(__oracle_jsp_text[551]);
                      if(strDatosDes.length!=0 && (strEstatus.equals("2") || strEstatus.equals("3"))){
                      out.write(__oracle_jsp_text[552]);
                      out.print( strDatosDes[0][12] );
                      out.write(__oracle_jsp_text[553]);
                      }else{
                      out.write(__oracle_jsp_text[554]);
                      
                      							String strTipoAsuntoArea[][] = null;
                      							String strTipoAsuntoGral[][] = null;
                      							strTipoAsuntoArea = ComboData.getTipoAsuntoAreaCombo(strAreaUs);
                      							strTipoAsuntoGral = ComboData.getTipoAsuntoAreaComboGral();
                      						
                      out.write(__oracle_jsp_text[555]);
                       for(int c=0;c<strTipoAsuntoArea.length;c++){ 
                      out.write(__oracle_jsp_text[556]);
                      out.print(strTipoAsuntoArea[c][0]);
                      out.write(__oracle_jsp_text[557]);
                      out.print((strIdTipoAsunto.trim().equals(strTipoAsuntoArea[c][0])?"selected":""));
                      out.write(__oracle_jsp_text[558]);
                      out.print(strTipoAsuntoArea[c][1]);
                      out.write(__oracle_jsp_text[559]);
                       } 
                      out.write(__oracle_jsp_text[560]);
                       for(int c=0;c<strTipoAsuntoGral.length;c++){ 
                      out.write(__oracle_jsp_text[561]);
                      out.print(strTipoAsuntoGral[c][0]);
                      out.write(__oracle_jsp_text[562]);
                      out.print((strIdTipoAsunto.trim().equals(strTipoAsuntoGral[c][0])?"selected":""));
                      out.write(__oracle_jsp_text[563]);
                      out.print(strTipoAsuntoGral[c][1]);
                      out.write(__oracle_jsp_text[564]);
                       } 
                      out.write(__oracle_jsp_text[565]);
                      }
                      out.write(__oracle_jsp_text[566]);
                      out.write(__oracle_jsp_text[567]);
                    } while (__jsp_taghandler_21.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,2);
                }
                out.write(__oracle_jsp_text[568]);
                {
                  org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_22=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
                  __jsp_taghandler_22.setParent(__jsp_taghandler_20);
                  __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[569]);
                    } while (__jsp_taghandler_22.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,2);
                }
                out.write(__oracle_jsp_text[570]);
              } while (__jsp_taghandler_20.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,1);
          }
          out.write(__oracle_jsp_text[571]);
          if(strIdAsunto != null && strIdAsunto.length() > 0){
          out.write(__oracle_jsp_text[572]);
          }
          out.write(__oracle_jsp_text[573]);
          if(strIdAsunto != null && strIdAsunto.length() > 0){
          out.write(__oracle_jsp_text[574]);
           if(BUsuario.getIdUsuario().equals(strIdDestinatario)){ 
          out.write(__oracle_jsp_text[575]);
           if(strActivarCM.equals("si")){ 
          out.write(__oracle_jsp_text[576]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[577]);
          out.print(strEstatus);
          out.write(__oracle_jsp_text[578]);
           }else{ 
          out.write(__oracle_jsp_text[579]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[580]);
          out.print(strEstatus);
          out.write(__oracle_jsp_text[581]);
           } 
          out.write(__oracle_jsp_text[582]);
           }else{ 
          out.write(__oracle_jsp_text[583]);
           if(strActivarCM.equals("no")){ 
          out.write(__oracle_jsp_text[584]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[585]);
          out.print(strEstatus);
          out.write(__oracle_jsp_text[586]);
           }else{ 
          out.write(__oracle_jsp_text[587]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[588]);
          out.print(strEstatus);
          out.write(__oracle_jsp_text[589]);
           } 
          out.write(__oracle_jsp_text[590]);
           } 
          out.write(__oracle_jsp_text[591]);
          }
          out.write(__oracle_jsp_text[592]);
           if(carga != null && carga.equals("1")){ 
          out.write(__oracle_jsp_text[593]);
           } 
          out.write(__oracle_jsp_text[594]);
          out.print( mensaje );
          out.write(__oracle_jsp_text[595]);
          out.print( bvalida );
          out.write(__oracle_jsp_text[596]);
          out.print( bValidaEstatus );
          out.write(__oracle_jsp_text[597]);
          out.print( !bValidaFechaRec );
          out.write(__oracle_jsp_text[598]);
           	if(BUsuario.getTurnado()){ 
          out.write(__oracle_jsp_text[599]);
          out.print( BUsuario.getIdUsuario() );
          out.write(__oracle_jsp_text[600]);
          out.print( BUsuario.getCargo() );
          out.write(__oracle_jsp_text[601]);
          out.print( BUsuario.getNombre() );
          out.write(__oracle_jsp_text[602]);
          out.print( BUsuario.getCargo() );
          out.write(__oracle_jsp_text[603]);
          out.print( ActualizaArea.NombreArea(BUsuario.getIdArea()) );
          out.write(__oracle_jsp_text[604]);
          out.print( BUsuario.getCorreo() );
          out.write(__oracle_jsp_text[605]);
          	} 
          out.write(__oracle_jsp_text[606]);
        }
      }

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
  private static final char __oracle_jsp_text[][]=new char[607][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<HTML> \n<HEAD>\n<TITLE>Nuevo Asunto</TITLE>\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    " \n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\n\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\t\t\tlocation.assign('ImportarCM.jsp?Folio=".toCharArray();
    __oracle_jsp_text[14] = 
    "&IdAsunto=".toCharArray();
    __oracle_jsp_text[15] = 
    "&a=".toCharArray();
    __oracle_jsp_text[16] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[17] = 
    "');\n\t\t\t\t\t\t\t</script>\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t\t\t\t\t\t<script type=\"text/javascript\">\t\n\t\t\t\t\t\t\t\tlocation.assign('".toCharArray();
    __oracle_jsp_text[19] = 
    "');\n\t\t\t\t\t\t\t\t</script>\n".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\t\t\tlocation.assign('ImportarCM.jsp?Folio=".toCharArray();
    __oracle_jsp_text[21] = 
    "&IdAsunto=".toCharArray();
    __oracle_jsp_text[22] = 
    "&a=".toCharArray();
    __oracle_jsp_text[23] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[24] = 
    "');\n\t\t\t\t\t\t\t</script>\n".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\t\t\t\tlocation.assign('".toCharArray();
    __oracle_jsp_text[26] = 
    "');\n\t\t\t\t\t\t\t\t</script>\n".toCharArray();
    __oracle_jsp_text[27] = 
    "\n".toCharArray();
    __oracle_jsp_text[28] = 
    "\n".toCharArray();
    __oracle_jsp_text[29] = 
    "\n".toCharArray();
    __oracle_jsp_text[30] = 
    "\n".toCharArray();
    __oracle_jsp_text[31] = 
    "\n".toCharArray();
    __oracle_jsp_text[32] = 
    "\n".toCharArray();
    __oracle_jsp_text[33] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/link.css\" />\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\" src=\"../js/link.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n\n\tvar botonBandera = true;\t\n\n\tfunction alfaNumerico(ob){\n\t\tvar ok=false;\n\t\tvar texto=ob.value\n\t\tvar codigo=texto.charCodeAt(texto.length-1);\n\t\tif( (codigo>=48&&codigo<=57)||(codigo>=65&&codigo<=90)||(codigo>=97&&codigo<=122)||(codigo==32)\n\t\t   )\n\t\t\tok=true;\n\t\tif(!ok){\n\t\t\ttexto=texto.substring(0,texto.length-1);\n\t\t\tob.value=texto;\n\t\t}\n\t}\n\tvar hay_hija = new Boolean(false);\n\tvar hija = new Object(); \n\tvar bandera = ".toCharArray();
    __oracle_jsp_text[34] = 
    ";\n\n\tfunction resetTimer(){\n\t\ttimer_reload();\n\t}\n\tfunction AbrirAnex(idAsunto, ids, refs){\n\t\tbandera = \"false\"; //document.Asunto.strBandera.value;\n\t\tvar isCenter ='true';\n\t\tvar features = '';\n\n\t\tif(bandera == \"true\"){\n\t\t\tif(confirm(\"Al Seleccionar esta opción, los cambios que no hayan sido guardados se perderan,\\n¿Deseas continuar?\")){\n\t\t\t\tif(window.screen)if(isCenter)if(isCenter==\"true\"){\n\t\t\t\t    var myLeft = (screen.width-760)/2;\n\t\t\t\t    var myTop = (screen.height-360)/2;\n\t\t\t\t    features+=(features!='')?',':'';\n\t\t\t\t    features+=',left='+myLeft+',top='+myTop; \n\t\t\t\t}\n\t\t\t\t//BloquearElementos();\n\t\t\t\thija = window.open('AnexarReferencia.jsp?strIdAsunto='+ idAsunto + '&idAsuntoAnt=' + ids + '&idAsuntoRef=' + refs + '&idArea=".toCharArray();
    __oracle_jsp_text[35] = 
    "&idUs=".toCharArray();
    __oracle_jsp_text[36] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[37] = 
    "','hija',features+((features!='')?',':'')+'width=760, height=360, status=yes');\n\t\t\t\thay_hija = true; \n\t\t\t}\n\t\t} else{\n\t\t\tif(window.screen)if(isCenter)if(isCenter==\"true\"){\n\t\t\t    var myLeft = (screen.width-760)/2;\n\t\t\t    var myTop = (screen.height-360)/2;\n\t\t\t    features+=(features!='')?',':'';\n\t\t\t    features+=',left='+myLeft+',top='+myTop; \n\t\t\t}\n\t\t\t//BloquearElementos();\n\t\t\thija = window.open('AnexarReferencia.jsp?strIdAsunto='+ idAsunto + '&idAsuntoAnt=' + ids + '&idAsuntoRef=' + refs + '&idArea=".toCharArray();
    __oracle_jsp_text[38] = 
    "&idUs=".toCharArray();
    __oracle_jsp_text[39] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[40] = 
    "','hija',features+((features!='')?',':'')+'width=760, height=360, status=yes');\n\t\t\thay_hija = true; \n\t\t}\n\t}\n\tfunction agregarContent(){\n\t\tdoc = document.Asunto;\n\t\tbandera = document.Asunto.strBandera.value;\n\n\t\tif(doc.id_asunto.value == \"\"){\n\t\t\tvalidacionesAsunto11();\n\t\t}else{\n\t\t\tif(bandera == \"true\"){\n\t\t\t\tif(confirm(\"Se detectaron cambios en el Asunto.\\nPulse Aceptar para guardar los cambios y continuar o\\npulse Cancelar para continuar sin guardar los cambios.\")){\n\t\t\t\t\tguardarAsunto('guardarInsertarArchivo');\n\t\t\t\t}else{\n\t\t\t\t\tlocation.assign('ImportarCM.jsp?Folio=".toCharArray();
    __oracle_jsp_text[41] = 
    "&IdAsunto=".toCharArray();
    __oracle_jsp_text[42] = 
    "&a=".toCharArray();
    __oracle_jsp_text[43] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[44] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[45] = 
    "');\n\t\t\t\t}\n\t\t\t} else{\n\t\t\t\tlocation.assign('ImportarCM.jsp?Folio=".toCharArray();
    __oracle_jsp_text[46] = 
    "&IdAsunto=".toCharArray();
    __oracle_jsp_text[47] = 
    "&a=".toCharArray();
    __oracle_jsp_text[48] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[49] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[50] = 
    "');\n\t\t\t}\n\t\t}\n\t}\n\tfunction agregar() \n\t{\n\t\tlocation.assign('ImportarCM.jsp?Folio=".toCharArray();
    __oracle_jsp_text[51] = 
    "&IdAsunto=".toCharArray();
    __oracle_jsp_text[52] = 
    "&a=".toCharArray();
    __oracle_jsp_text[53] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[54] = 
    "');\n\t}\n\tfunction cargaApplet21(){\n\t\tvalidacionesAsunto();\n\t}\n\tfunction cargaApplet1(){\n\t\tlocation.assign('VisualizaInstrucciones.jsp?idAsunto=".toCharArray();
    __oracle_jsp_text[55] = 
    "&Url=".toCharArray();
    __oracle_jsp_text[56] = 
    "');\n\t}\n\tfunction validaFechaFinesSem(campoFecha){\n\n\t\tvar valida = 0 \n\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\t\n\t\tif (campoFecha != null && campoFecha.value == \"".toCharArray();
    __oracle_jsp_text[58] = 
    "\") {\n\t\t\tvalida =1;\n\t\t}\n\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\tif (valida == 1){\n\t\t\talert(\"La fecha seleccionada no es laborable\");\n\t\t\tcampoFecha.value = \"\";\n\t\t} \n\t}\n\n\tfunction regresarURI(){\n\t\tdoc = document.Asunto;\n\t\tbandera = document.Asunto.strBandera.value;\n\n\t\tif(bandera == \"true\"){\n\t\t\tif(confirm(\"Se detectaron cambios en el Asunto.\\nPulse Aceptar para guardar los cambios y continuar o\\npulse Cancelar para continuar sin guardar los cambios.\")){\n\t\t\t\tguardarAsunto('guardarRegresarURI');\n\t\t\t}else{\n\t\t\t\tlocation.assign('".toCharArray();
    __oracle_jsp_text[60] = 
    "');\n\t\t\t}\n\t\t} else{\n\t\t\tlocation.assign('".toCharArray();
    __oracle_jsp_text[61] = 
    "');\n\t\t}\n\t}\n\n\tfunction ventanaHija(){\n\t\tif (hija!= null && hay_hija == true){ \n\t\t\ttry{\n\t\t\t\thija.focus(); \n\t\t\t}catch(err){\n\t\t\t\thay_hija = new Boolean(false);\n\t\t\t\thija = new Object(); \n\t\t\t}\n\t\t}\n\t}\n\n</SCRIPT>\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<meta HTTP-EQUIV=\"Expires\" CONTENT=\"0\">\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0;focos();timer_load();cargaFoco();\"\nonmouseover=\"ventanaHija();\" \nonfocus=\"ventanaHija();\"\nonMouseMove=\"limitaTextArea(document.Asunto.asuntoSintesis,'Comentario','4000');\n\t\t\tlimitaTextArea(document.Asunto.asuntoComentario,'Comentarios','4000');\n\t\t\tlimitaTextArea(document.Asunto.lugarEvento,'Lugar del Evento', '100');\n\t\t\tvalidaFechaRec();validaFechaDoc();validaFechaCom();validaFechaEve();\n\t\t\tvalidaFechaFinesSem(document.Asunto.asuntoFechaCad);\n\t\t\tvalidaFechaFinesSem(document.Asunto.asuntoFechaDocto);\n\t\t\tvalidaFechaFinesSem(document.Asunto.asuntoFechaRecepcion);\n\t\t\tvalidaFechaFinesSem(document.Asunto.fechaEvento);\"\nonKeyPress=\"timer_reload();\" onClick=\"timer_reload();\" onunload=\"hija.close()\">\n\n<FORM action=\"Asuntos.jsp\" name=\"Asunto\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[62] = 
    "\" name=\"id_asunto\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[63] = 
    "\" name=\"control\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[64] = 
    "\" name=\"url\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[65] = 
    "\" name=\"fol\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[66] = 
    "\" name=\"idRemitente\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[67] = 
    "\" name=\"idEntidad\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[68] = 
    "\" name=\"idDestinatario\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[69] = 
    "\" name=\"mailDest\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[70] = 
    "\" name=\"carga\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[71] = 
    "\" name=\"idAsuntoAnt\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[72] = 
    "\" name=\"idAsuntoRef\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[73] = 
    "\" name=\"asuntoIdsPara\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[74] = 
    "\" name=\"asuntoIdsCC\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[75] = 
    "\" name=\"asuntoIdsParaE\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[76] = 
    "\" name=\"asuntoParaE\">\n<INPUT type=\"hidden\" value=\"\" name=\"asuntoIdsCCE\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[77] = 
    "\" name=\"focus\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[78] = 
    "\" name=\"asuntoPara\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[79] = 
    "\" name=\"asuntoCC\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[80] = 
    "\" name=\"retURI\" >\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[81] = 
    "\" name=\"horarioEntrada\" >\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[82] = 
    "\" name=\"horarioSalida\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[83] = 
    "\" name=\"idAreaUsuario\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[84] = 
    "\" name=\"contador\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[85] = 
    "\" name=\"strBandera\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[86] = 
    "\" name=\"setFoco\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[87] = 
    "\" name=\"asuntoEst\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[88] = 
    "\" name=\"estatusN\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[89] = 
    "\" name=\"formateada\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[90] = 
    "\" name=\"accionArchivo\">\n<INPUT type=\"hidden\" value=\"\" name=\"banderaVent\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[91] = 
    "\" name=\"id_tra\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[92] = 
    "\" name=\"estValidacion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"99%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<BR/>\n<DIV align=\"center\">\n\n\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"863\">".toCharArray();
    __oracle_jsp_text[93] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\" face=\"Verdana\">Asunto\n\t\tEn Recepci&oacute;n</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[94] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\" face=\"Verdana\">Asunto\n\t\tPor Turnar</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[95] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\" face=\"Verdana\">Asunto\n\t\tEn Tr&aacute;mite</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[96] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\" face=\"Verdana\">Asunto\n\t\tTerminado</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[97] = 
    "</td>\n            </tr>\n        </table>\n    </DIV>\n<BR/>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"863\">\n<TBODY> \n\t<TR>\t\n\t\t<TD width=\"5%\">\n\t\t\t<A onclick=\"if(botonBandera){botonBandera=false; regresarURI();}\" onMouseOver=\"document.MyImage.src='../Imagenes/NavLeft2.gif'\" onMouseOut=\"document.MyImage.src='../Imagenes/NavLeft.gif'\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar / Cancelar\" name=\"MyImage\"></A>\n\t\t</TD>\n\t\t".toCharArray();
    __oracle_jsp_text[98] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[99] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[100] = 
    "\n\t\t\t\t<td width=\"5%\">\n\t\t\t\t\t<A onclick=\"if(botonBandera){botonBandera=false; guardarAsuntoEnRecepcion();}\" \n\t\t\t\t\t\tonMouseOver=\"document.guardarRepBtn.src='../Imagenes/SaveRecepOff.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.guardarRepBtn.src='../Imagenes/SaveRecepOn.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/SaveRecepOn.gif\" name=\"guardarRepBtn\" alt=\"Guardar en Recepción\"></A>\n\t\t\t\t</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[101] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[102] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[103] = 
    "\n\t\t\t\t<td width=\"0%\"></td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[105] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[106] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[107] = 
    "\n                        ".toCharArray();
    __oracle_jsp_text[108] = 
    "\n                                ".toCharArray();
    __oracle_jsp_text[109] = 
    "\n\t\t\t\t<TD width=\"5%\">\n\t\t\t\t\t<A onclick=\"if(botonBandera){botonBandera=false; guardarAsunto();}\" \n\t\t\t\t\t\tonMouseOver=\"document.guardarBtn.src='../Imagenes/Save2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.guardarBtn.src='../Imagenes/Save.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Save.gif\" alt=\"Guardar para Turnar\" name=\"guardarBtn\"></A>\n\t\t\t\t</TD>\n                                ".toCharArray();
    __oracle_jsp_text[110] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[111] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[112] = 
    "\n\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[113] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[114] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[115] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[116] = 
    "\n                        ".toCharArray();
    __oracle_jsp_text[117] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[118] = 
    "\n                                \n                                \n\t\t\t\t<TD width=\"5%\">\n\t\t\t\t\t<a onclick=\"if(botonBandera){botonBandera=false; agregarContent();}\" \n\t\t\t\t\t\tonMouseOver=\"document.Attach.src='../Imagenes/Attach2.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Attach.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\" alt=\"Insertar Archivo\" name=\"Attach\"></a>\n\t\t\t\t</TD>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[119] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[120] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[121] = 
    "\n\t\t\t\t<TD width=\"5%\">&nbsp;</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[122] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[123] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[124] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[125] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[126] = 
    "\n\t\t\t\t<TD width=\"5%\">\n\t\t\t\t\t<a onclick=\"if(botonBandera){botonBandera=false; AbrirAnex(".toCharArray();
    __oracle_jsp_text[127] = 
    ",'".toCharArray();
    __oracle_jsp_text[128] = 
    "','".toCharArray();
    __oracle_jsp_text[129] = 
    "');}\" \n\t\t\t\t\t\tonMouseOver=\"document.Refe.src='../Imagenes/asuntAntOff.gif';\" \n\t\t\t\t\t\tonMouseOut=\"document.Refe.src='../Imagenes/asuntAntOn.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/asuntAntOn.gif\" alt=\"Anexar relación\" name=\"Refe\"></a>\n\t\t\t\t</TD>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[130] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[131] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[132] = 
    "\n\t\t\t\t<TD width=\"5%\">&nbsp;</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[133] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[134] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[135] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[136] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[137] = 
    "\n\t\t\t\t<TD width=\"5%\">\n\t\t\t\t<A onclick=\"if(botonBandera){botonBandera=false; BorrarAsunto();}\" \n\t\t\t\t\tonMouseOver=\"document.Borrar.src='../Imagenes/Borrar2a.gif';\" \n\t\t\t\t\tonMouseOut=\"document.Borrar.src='../Imagenes/Borrar.gif';\">\n\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Borrar.gif\" name=\"Borrar\" alt=\"Borrar Documento\"></A>\n\t\t\t\t</TD>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[138] = 
    "\n\t\t\t\t<TD></TD>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[139] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[140] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[141] = 
    "\n\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[142] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[143] = 
    "\n\t\t<TD width=\"40%\">&nbsp;</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<TABLE>\n<TBODY>\n\t<TR>\n\t\t<TD width=\"863\" align=\"center\">\n\t\t\t<FONT face=\"Arial\" color=\"red\" size=\"4\">".toCharArray();
    __oracle_jsp_text[144] = 
    "</FONT>\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n<BR>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos\n\t\tGenerales</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\">\n\t\t\t<DIV align=\"right\">\n\t\t\t<FONT face=\"Arial\" color=\"#00204f\" size=\"2\">**Los datos marcados con negritas son obligatorios</FONT>\n\t\t\t</DIV>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"847\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[145] = 
    "\n\t<TR valign=\"top\">\n\t\t<td width=\"183\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<TD width=\"380\">\n\t\t\t<DIV  align=\"right\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">Creado por: <I>".toCharArray();
    __oracle_jsp_text[146] = 
    " - ".toCharArray();
    __oracle_jsp_text[147] = 
    "</I></FONT>\n\t\t\t</DIV>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<td width=\"183\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<TD width=\"380\" align=\"right\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\tEstatus: <b>".toCharArray();
    __oracle_jsp_text[148] = 
    "</b>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<td width=\"183\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<TD width=\"380\" align=\"right\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\tFolio Identificador: <b>".toCharArray();
    __oracle_jsp_text[149] = 
    "</b>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<td width=\"183\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<TD width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[150] = 
    "\n\t<TR valign=\"top\">\n\t\t<td width=\"183\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<TD width=\"380\">\n\t\t\t<DIV  align=\"right\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">Creado por: <I>".toCharArray();
    __oracle_jsp_text[151] = 
    " - ".toCharArray();
    __oracle_jsp_text[152] = 
    "</I></FONT>\n\t\t\t</DIV>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[153] = 
    "\n\t\n</TBODY>\n</TABLE>\n</DIV>\n<SCRIPT type=\"text/javascript\">\nif (navigator.appName!=\"Netscape\") { document.write('<DIV class=documentBody id=Body>'); }\n</SCRIPT>\n".toCharArray();
    __oracle_jsp_text[154] = 
    "\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos del Remitente</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"363\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">&Aacute;rea Generadora:</FONT></B>\n\t\t\t".toCharArray();
    __oracle_jsp_text[155] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[156] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[157] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[158] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[159] = 
    "\n\t\t\t<INPUT name=\"botEntidad\" type=\"button\" onclick=\"document.Asunto.strBandera.value=true;AbrirF('".toCharArray();
    __oracle_jsp_text[160] = 
    "','".toCharArray();
    __oracle_jsp_text[161] = 
    "','".toCharArray();
    __oracle_jsp_text[162] = 
    "','".toCharArray();
    __oracle_jsp_text[163] = 
    "');\" class=\"s-dropdown-btn\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[164] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[165] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[166] = 
    "\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[167] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\"> \n\t\t\t\t".toCharArray();
    __oracle_jsp_text[168] = 
    "\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoEntidad\" value=\"".toCharArray();
    __oracle_jsp_text[169] = 
    "\" onclick=\"\" disabled=\"disabled\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[170] = 
    "\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoEntidad\" value=\"".toCharArray();
    __oracle_jsp_text[171] = 
    "\" onclick=\"\" disabled=\"disabled\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[172] = 
    "\n\t\t\t</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[173] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\"> \n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoEntidad\" value=\"".toCharArray();
    __oracle_jsp_text[174] = 
    "\" onclick=\"\" onfocus=\"blur();\">\n\t\t\t</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[175] = 
    "\n\t\t</TD>\n\t</TR>\n\t\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">                                            \n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">De:</FONT></B>\n\t\t\t".toCharArray();
    __oracle_jsp_text[176] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[177] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[178] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[179] = 
    "\n\t\t\t<INPUT name=\"botDe\" type=\"button\" onclick=\"document.Asunto.strBandera.value=true;AbrirR('FrameRemitente.jsp?id_us='+idEntidad.value+'&con='+control.value+'&ida='+id_asunto.value+'&num=1&idRemitente='+idRemitente.value)\" class=\"s-dropdown-btn\">\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[180] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[181] = 
    "\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[182] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[183] = 
    "\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoRemitente\" value=\"".toCharArray();
    __oracle_jsp_text[184] = 
    " / ".toCharArray();
    __oracle_jsp_text[185] = 
    "\" disabled=\"disabled\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[186] = 
    "\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoRemitente\" value=\"".toCharArray();
    __oracle_jsp_text[187] = 
    "\" disabled=\"disabled\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[188] = 
    "\n\t\t\t\t<input name=\"asuntoCargo\" value=\"".toCharArray();
    __oracle_jsp_text[189] = 
    "\" type=\"hidden\" disabled=\"disabled\">\n\t\t\t\t<input name=\"asuntoCorreo\" value=\"".toCharArray();
    __oracle_jsp_text[190] = 
    "\" type=\"hidden\" disabled=\"disabled\">\n\t\t\t</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[191] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoRemitente\" value=\"".toCharArray();
    __oracle_jsp_text[192] = 
    "\" onclick=\"\" onfocus=\"blur();\">\n\t\t\t\t<input name=\"asuntoCargo\" value=\"".toCharArray();
    __oracle_jsp_text[193] = 
    "\" type=\"hidden\">\n\t\t\t\t<input name=\"asuntoCorreo\" value=\"".toCharArray();
    __oracle_jsp_text[194] = 
    "\" type=\"hidden\">\n\t\t\t</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[195] = 
    "\n\t\t</TD>\n\t</TR>\n\t\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Firmante:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[196] = 
    "\n\t\t\t\t<INPUT class=\"blue600a\" name=\"asuntoFirmante\" value=\"".toCharArray();
    __oracle_jsp_text[197] = 
    "\" disabled=\"disabled\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[198] = 
    "\n\t\t\t<INPUT class=\"blue600a\" name=\"asuntoFirmante\" value=\"".toCharArray();
    __oracle_jsp_text[199] = 
    "\" maxlength=\"200\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[200] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\"><B>Documento de:</B></FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[201] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[202] = 
    "\n\t\t\t\t<input name=\"asuntoTipoFolio\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[203] = 
    "\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[204] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[205] = 
    "\n\t\t\t\tPor Asignar<input name=\"asuntoTipoFolio\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[206] = 
    "\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[207] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[208] = 
    "\n\t\t\t\t<input name=\"asuntoTipoFolio\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[209] = 
    "\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[210] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[211] = 
    "\n\t\t\t</font>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos de Ventanilla</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"363\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Responsable del<BR>Turno:</FONT></B>\n\t\t\t".toCharArray();
    __oracle_jsp_text[212] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[213] = 
    "\n\t\t\t<!-- <INPUT type=\"button\" onclick=\"document.Asunto.strBandera.value=true;AbrirIframe('pop4', '".toCharArray();
    __oracle_jsp_text[214] = 
    "');\" class=\"s-dropdown-btn\"> -->\n\t\t\t<INPUT name=\"botVentanilla\" type=\"button\" onclick=\"document.Asunto.strBandera.value=true;AbrirV('FrameVentanilla.jsp?idArea=".toCharArray();
    __oracle_jsp_text[215] = 
    "&ida=".toCharArray();
    __oracle_jsp_text[216] = 
    "&num=1');\" class=\"s-dropdown-btn\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[217] = 
    "\n\t\t\t<!-- <DIV class=\"popup\" id=\"pop4\">\n\t\t\t\t<IFRAME src=\"FrameVentanilla.jsp?idArea=".toCharArray();
    __oracle_jsp_text[218] = 
    "&ida=".toCharArray();
    __oracle_jsp_text[219] = 
    "&num=1\" WIDTH=600 HEIGHT=270 frameborder=1></IFRAME>\n\t\t\t</DIV> -->\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[220] = 
    "<BR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[221] = 
    "\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoDestinatario\" type=\"text\" value=\"".toCharArray();
    __oracle_jsp_text[222] = 
    "\" disabled=\"disabled\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[223] = 
    "\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoDestinatario\" type=\"text\" value=\"".toCharArray();
    __oracle_jsp_text[224] = 
    "\" disabled=\"disabled\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[225] = 
    "\n\t\t\t\t<input name=\"asuntoCargoDest\" value=\"".toCharArray();
    __oracle_jsp_text[226] = 
    "\" type=\"hidden\" disabled=\"disabled\">\n\t\t\t\t<input name=\"asuntoAreaDest\" value=\"".toCharArray();
    __oracle_jsp_text[227] = 
    "\" type=\"hidden\" disabled=\"disabled\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[228] = 
    "<BR>\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoDestinatario\" type=\"text\" value=\"".toCharArray();
    __oracle_jsp_text[229] = 
    "\" onfocus=\"blur();\">\n\t\t\t\t<input name=\"asuntoCargoDest\" value=\"".toCharArray();
    __oracle_jsp_text[230] = 
    "\" type=\"hidden\">\n\t\t\t\t<input name=\"asuntoAreaDest\" value=\"".toCharArray();
    __oracle_jsp_text[231] = 
    "\" type=\"hidden\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[232] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Destinatarios</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"363\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">\n          Receptor Interno\n          <BR>de la SHCP\n\t\t\t:</FONT></B>\n\t\t\t".toCharArray();
    __oracle_jsp_text[233] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[234] = 
    "\n\t\t\t<INPUT type=\"button\" onclick=\"document.Asunto.strBandera.value=true;AbrirPara('".toCharArray();
    __oracle_jsp_text[235] = 
    "','".toCharArray();
    __oracle_jsp_text[236] = 
    "','".toCharArray();
    __oracle_jsp_text[237] = 
    "', '".toCharArray();
    __oracle_jsp_text[238] = 
    "', '".toCharArray();
    __oracle_jsp_text[239] = 
    "', '".toCharArray();
    __oracle_jsp_text[240] = 
    "' );\" class=\"s-dropdown-btn\"> \n\t\t\t".toCharArray();
    __oracle_jsp_text[241] = 
    "\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Para:</FONT></B>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[242] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[243] = 
    "\n\t\t\t\t<SELECT name=\"listTO\" size=\"8\" class=\"blue600a\" multiple=\"multiple\" disabled=\"disabled\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[244] = 
    "\n\t\t\t\t<OPTION>".toCharArray();
    __oracle_jsp_text[245] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[246] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[247] = 
    "\n\t\t\t\t<SELECT name=\"listTO\" size=\"8\" class=\"blue600a\" multiple=\"multiple\" disabled=\"disabled\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[248] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[249] = 
    "\">".toCharArray();
    __oracle_jsp_text[250] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[251] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[252] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[253] = 
    "\n\t\t\t\t<SELECT name=\"listTO\" size=\"8\" class=\"blue600a\" multiple=\"multiple\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[254] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[255] = 
    "\">".toCharArray();
    __oracle_jsp_text[256] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[257] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[258] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Ccp:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[259] = 
    "\n\t\t\t\t<SELECT name=\"listCC\" size=\"8\" class=\"blue600a\" multiple=\"multiple\" disabled=\"disabled\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[260] = 
    "\n\t\t\t\t<OPTION>".toCharArray();
    __oracle_jsp_text[261] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[262] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[263] = 
    "\n\t\t\t\t<SELECT name=\"listCC\" size=\"8\" class=\"blue600a\" multiple=\"multiple\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[264] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[265] = 
    "\">".toCharArray();
    __oracle_jsp_text[266] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[267] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[268] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Receptor Externo:</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[269] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[270] = 
    " <INPUT type=\"button\"\n\t\t\t\tonclick=\"document.Asunto.strBandera.value=true;AbrirDest('".toCharArray();
    __oracle_jsp_text[271] = 
    "', '".toCharArray();
    __oracle_jsp_text[272] = 
    "', '".toCharArray();
    __oracle_jsp_text[273] = 
    "');\"\n\t\t\t\tclass=\"s-dropdown-btn\"> ".toCharArray();
    __oracle_jsp_text[274] = 
    " </TD>\n\t\t<TD colspan=\"3\">\n\t\t\t\n\t\t</TD>\n\t</TR>\n\t\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Para:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[275] = 
    "\n\t\t\t\t<SELECT name=\"listTOE\" size=\"6\" class=\"blue600a\" multiple=\"multiple\" disabled=\"disabled\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[276] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[277] = 
    "\">".toCharArray();
    __oracle_jsp_text[278] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[279] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[280] = 
    "\n\t\t\t\t<SELECT name=\"listTOE\" size=\"6\" class=\"blue600a\" multiple=\"multiple\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[281] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[282] = 
    "\">".toCharArray();
    __oracle_jsp_text[283] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[284] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[285] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos del Asunto</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"363\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n <BR>\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Asunto:</FONT></B>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[286] = 
    "\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asunto\" type=\"text\" value=\"".toCharArray();
    __oracle_jsp_text[287] = 
    "\" disabled=\"disabled\">\n\t\t\t\t<INPUT type=\"hidden\" name=\"tram\" value=\"0\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[288] = 
    "\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asunto\" type=\"text\" value=\"".toCharArray();
    __oracle_jsp_text[289] = 
    "\" maxlength=\"200\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[290] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\n\t".toCharArray();
    __oracle_jsp_text[291] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[292] = 
    "\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Tipo de Documento:</FONT></B>\n\t\t\t<br><font face=\"Arial\" size=\"1\" color=\"#004080\">(Requerido solo para turnar)</font>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[293] = 
    "\n\t\t\t\t<INPUT type=\"text\" name=\"asuntoTipoDocto_2\" value=\"".toCharArray();
    __oracle_jsp_text[294] = 
    "\" class=\"blue600a\" disabled=\"disabled\">\n\t\t\t\t<INPUT type=\"hidden\" name=\"asuntoTipoDocto\" value=\"".toCharArray();
    __oracle_jsp_text[295] = 
    "\">\n\t\t\t\t<INPUT type=\"hidden\" name=\"esRecepcion\" value=\"2\">\n\t\t\t\t<INPUT type=\"hidden\" name=\"asuntoTipoDocto_1\" value=\"".toCharArray();
    __oracle_jsp_text[296] = 
    "\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[297] = 
    "\n\t\t\t<!-- este if se ejecuta cuando el asunto fue creado y no tiene instrucciones creadas. -->\n\t\t\t".toCharArray();
    __oracle_jsp_text[298] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[299] = 
    "\n\t\t\t<SELECT name=\"asuntoTipoDocto_1\" class=\"blue600a\" disabled=\"disabled\" onchange=\"document.Asunto.strBandera.value=true;\" style>\n\t\t\t\t<OPTION value=\"-1\">------ Tipo de Documentos de la Unidad Administrativa ------</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[300] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[301] = 
    "\" ".toCharArray();
    __oracle_jsp_text[302] = 
    ">".toCharArray();
    __oracle_jsp_text[303] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[304] = 
    "\n\t\t\t\t<OPTION value=\"-1\">------ Tipo de Documentos Generales ------</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[305] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[306] = 
    "\" ".toCharArray();
    __oracle_jsp_text[307] = 
    ">".toCharArray();
    __oracle_jsp_text[308] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[309] = 
    "\n\t\t\t</SELECT>\n\t\t\t<INPUT type=\"hidden\" name=\"asuntoTipoDocto\" value=\"".toCharArray();
    __oracle_jsp_text[310] = 
    "\">\n\t\t\t<INPUT type=\"hidden\" name=\"esRecepcion\" value=\"2\">\n\t\t\t<INPUT type=\"hidden\" name=\"asuntoTipoDocto_1\" value=\"".toCharArray();
    __oracle_jsp_text[311] = 
    "\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[312] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[313] = 
    "\n\t\t\t</FONT>\n\t\t\t<INPUT type=\"hidden\" name=\"esRecepcion\" value=\"2\">\n\t\t\t<INPUT type=\"hidden\" name=\"asuntoTipoDocto_1\" value=\"".toCharArray();
    __oracle_jsp_text[314] = 
    "\">\n\t\t\t<INPUT type=\"hidden\" name=\"asuntoTipoDocto\" value=\"".toCharArray();
    __oracle_jsp_text[315] = 
    "\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[316] = 
    "\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[317] = 
    "\n\t\t\t<SELECT name=\"asuntoTipoDocto\" class=\"blue600a\" onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t<OPTION value=\"null\">------ Tipo de Documentos de la Unidad Administrativa ------</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[318] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[319] = 
    "\" ".toCharArray();
    __oracle_jsp_text[320] = 
    ">".toCharArray();
    __oracle_jsp_text[321] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[322] = 
    "\n\t\t\t\t<OPTION value=\"null\">------ Tipo de Documentos Generales ------</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[323] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[324] = 
    "\" ".toCharArray();
    __oracle_jsp_text[325] = 
    ">".toCharArray();
    __oracle_jsp_text[326] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[327] = 
    "\n\t\t\t</SELECT> \n\t\t\t<INPUT type=\"hidden\" name=\"esRecepcion\" value=\"1\">\n\t\t\t<INPUT type=\"hidden\" name=\"asuntoTipoDocto_1\" value=\"\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[328] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[329] = 
    "\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[330] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[331] = 
    "\n\t\t<tr>\n\t\t<TD>\n\t\t\t<INPUT type=\"hidden\" name=\"asuntoTipoDocto\" value=\"-1\">\n\t\t\t<INPUT type=\"hidden\" name=\"esRecepcion\" value=\"0\">\n\t\t</TD>\n\t</tr>\n\t".toCharArray();
    __oracle_jsp_text[332] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[333] = 
    "\n\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fecha de Recepción del documento:</FONT></B>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[334] = 
    "\n\t\t\t<INPUT class=\"blue100a\"  name=\"asuntoFechaRecepcion\" value=\"".toCharArray();
    __oracle_jsp_text[335] = 
    "\" disabled=\"disabled\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\tHora de Recepción:</FONT></B>\n\t\t\t<SELECT name=\"horaRecepcion\" class=\"blue50a\" disabled=\"disabled\">\n\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[336] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[337] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[338] = 
    "\" ".toCharArray();
    __oracle_jsp_text[339] = 
    ">".toCharArray();
    __oracle_jsp_text[340] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[341] = 
    "\n\t\t\t</SELECT>\n\t\t\t<FONT face=\"Verdana\" size=\"2\">:</FONT>\n\t\t\t<SELECT name=\"minRecepcion\" class=\"blue50a\" disabled=\"disabled\">\n\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[342] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[343] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[344] = 
    "\" ".toCharArray();
    __oracle_jsp_text[345] = 
    ">".toCharArray();
    __oracle_jsp_text[346] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[347] = 
    "\n\t\t\t</SELECT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[348] = 
    "\n\t\t\t<INPUT class=\"blue100a\"  name=\"asuntoFechaRecepcion\" value=\"".toCharArray();
    __oracle_jsp_text[349] = 
    "\" maxlength=\"10\" onblur=\"validaFormatoFecha();keyTra()\" onKeyUp=\"validaFechaRec();\" onKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick='document.Asunto.strBandera.value=true;showCalFechaDocRec();' name=\"cRep\"></A>\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\tHora de Recepción:</FONT></B>\n\t\t\t<SELECT name=\"horaRecepcion\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[350] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[351] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[352] = 
    "\" ".toCharArray();
    __oracle_jsp_text[353] = 
    ">".toCharArray();
    __oracle_jsp_text[354] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[355] = 
    "\n\t\t\t</SELECT>\n\t\t\t<FONT face=\"Verdana\" size=\"2\">:</FONT>\n\t\t\t<SELECT name=\"minRecepcion\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[356] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[357] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[358] = 
    "\" ".toCharArray();
    __oracle_jsp_text[359] = 
    ">".toCharArray();
    __oracle_jsp_text[360] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[361] = 
    "\n\t\t\t</SELECT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[362] = 
    "\n\t\t</TD>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fecha del documento:</font></B>\n\t\t</td>\n\t\t<td colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[363] = 
    "\n\t\t\t<INPUT class=\"blue100a\" name=\"asuntoFechaDocto\" value=\"".toCharArray();
    __oracle_jsp_text[364] = 
    "\" disabled=\"disabled\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[365] = 
    "\n\t\t\t<INPUT class=\"blue100a\" name=\"asuntoFechaDocto\" value=\"".toCharArray();
    __oracle_jsp_text[366] = 
    "\" maxlength=\"10\" onblur=\"validaFormatoFecha();\" onKeyUp=\"validaFechaDoc();\" onKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick=\"document.Asunto.strBandera.value=true;showCalFechaDoc();\" name=\"cDoc\"></A>\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[367] = 
    "\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Trámite:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[368] = 
    "\n\t\t\t<INPUT name=\"asuntoTramite_2\" type=\"text\" value=\"".toCharArray();
    __oracle_jsp_text[369] = 
    "\" disabled=\"disabled\" class=\"blue600a\">\n\t\t\t<!-- <INPUT name=\"asuntoTramite\" type=\"hidden\" value=\"-1\">\n\t\t\t<SELECT name=\"asuntoTramite1\" class=\"blue600a\" onchange=\"pruebaCom(this.value)\" disabled=\"disabled\">\n\t\t\t\t<OPTION value=\"-1\">------ Selecciona un Trámite de la Unidad Administrativa ------</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[370] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[371] = 
    "\" ".toCharArray();
    __oracle_jsp_text[372] = 
    ">".toCharArray();
    __oracle_jsp_text[373] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[374] = 
    "\n\t\t\t\t<OPTION value=\"-1\">------ Selecciona un Trámite General ------</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[375] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[376] = 
    "\" ".toCharArray();
    __oracle_jsp_text[377] = 
    ">".toCharArray();
    __oracle_jsp_text[378] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[379] = 
    "\n\t\t\t</SELECT> -->\n\t\t\t".toCharArray();
    __oracle_jsp_text[380] = 
    "\n\t\t\t<SELECT name=\"asuntoTramite\" class=\"blue600a\" onchange=\"document.Asunto.strBandera.value=true;pruebaCom(this.value)\">\n\t\t\t\t<OPTION value=\"-1\">------ Selecciona un Trámite de la Unidad Administrativa ------</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[381] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[382] = 
    "\" ".toCharArray();
    __oracle_jsp_text[383] = 
    ">".toCharArray();
    __oracle_jsp_text[384] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[385] = 
    "\n\t\t\t\t<OPTION value=\"-1\">------ Selecciona un Trámite General ------</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[386] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[387] = 
    "\" ".toCharArray();
    __oracle_jsp_text[388] = 
    ">".toCharArray();
    __oracle_jsp_text[389] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[390] = 
    "\n\t\t\t</SELECT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[391] = 
    "\n\t\t</TD>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><B><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha compromiso:</font></B>\n\t\t</td>\n\t\t<td colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[392] = 
    "\n\t\t\t<INPUT class=\"blue100\"  name=\"asuntoFechaCad\" value=\"".toCharArray();
    __oracle_jsp_text[393] = 
    "\" disabled=\"disabled\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[394] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[395] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[396] = 
    "\n\t\t\t\t\t<INPUT class=\"blue100a\"  name=\"asuntoFechaCad\" value=\"".toCharArray();
    __oracle_jsp_text[397] = 
    "\" maxlength=\"10\" onblur=\"validaFormatoFecha();\" onKeyUp=\"validaFechaCom();\" onKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t\t\t<INPUT type=\"text\" value=\"\" name=\"fechaOcultoCompromiso\" style=\"display:none\" class=\"blue100\" disabled=\"disabled\">\n\t\t\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick=\"document.Asunto.strBandera.value=true;showCalFechaCom();\" name=\"fechaCom\"></A>\n\t\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[398] = 
    "\n\t\t\t\t\t<INPUT class=\"blue100a\"  name=\"asuntoFechaCad\" value=\"".toCharArray();
    __oracle_jsp_text[399] = 
    "\" style=\"display:none\" maxlength=\"10\" onblur=\"validaFormatoFecha();\" onKeyUp=\"validaFechaCom();\" onKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t\t\t<INPUT type=\"text\" value=\"".toCharArray();
    __oracle_jsp_text[400] = 
    "\" name=\"fechaOcultoCompromiso\" class=\"blue100\" disabled=\"disabled\">\n\t\t\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick=\"document.Asunto.strBandera.value=true;showCalFechaCom();\" name=\"fechaCom\" style=\"display:none\"></A>\n\t\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[401] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[402] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[403] = 
    "\n\t\t\t\t\t<INPUT class=\"blue100a\"  name=\"asuntoFechaCad\" value=\"".toCharArray();
    __oracle_jsp_text[404] = 
    "\" maxlength=\"10\" onblur=\"validaFormatoFecha();\" onKeyUp=\"validaFechaCom();\" onKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t\t\t<INPUT type=\"text\" value=\"\" name=\"fechaOcultoCompromiso\" class=\"blue100\" disabled=\"disabled\" style=\"display:none\">\n\t\t\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick=\"document.Asunto.strBandera.value=true;showCalFechaCom();\" name=\"fechaCom\"></A>\n\t\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[405] = 
    "\n\t\t\t\t\t<INPUT class=\"blue100a\"  name=\"asuntoFechaCad\" value=\"".toCharArray();
    __oracle_jsp_text[406] = 
    "\" style=\"display:none\"  maxlength=\"10\" onblur=\"validaFormatoFecha();\" onkeyup=\"validaFechaCom();\" onKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t\t\t<INPUT type=\"text\" value=\"".toCharArray();
    __oracle_jsp_text[407] = 
    "\" name=\"fechaOcultoCompromiso\" class=\"blue100\" disabled=\"disabled\">\n\t\t\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick=\"document.Asunto.strBandera.value=true;showCalFechaCom();\" name=\"fechaCom\" style=\"display:none\"></A>\n\t\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[408] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[409] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[410] = 
    "\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\n\t\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><B><font size=\"2\" color=\"#004080\" face=\"Arial\">Identificador del docto.:</font></B>\n\t\t</td>\n\t\t<td colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[411] = 
    "\n\t\t\t<INPUT class=\"blue500a\" name=\"asuntoFolioExt\" value=\"".toCharArray();
    __oracle_jsp_text[412] = 
    "\" disabled=\"disabled\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[413] = 
    "\n\t\t\t<INPUT class=\"blue500a\" name=\"asuntoFolioExt\" value=\"".toCharArray();
    __oracle_jsp_text[414] = 
    "\" maxlength=\"100\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[415] = 
    "\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Folio Intermedio:</font>\n\t\t<BR>\n\t\t\t<FONT color=\"#004080\">(VDG, VOM, VSP, etc.) </FONT></td>\n\t\t<td colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[416] = 
    "\n\t\t\t<INPUT class=\"blue500a\" name=\"asuntoFolioInt\" value=\"".toCharArray();
    __oracle_jsp_text[417] = 
    "\" disabled=\"disabled\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[418] = 
    "\n\t\t\t<INPUT class=\"blue500a\" name=\"asuntoFolioInt\" value=\"".toCharArray();
    __oracle_jsp_text[419] = 
    "\" maxlength=\"100\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[420] = 
    "\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Descripción:</FONT> </B></TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[421] = 
    "\n\t\t\t<TEXTAREA name=\"asuntoSintesis\" rows=\"8\" cols=\"60\" disabled=\"disabled\" class=\"blue600a\"\n\t\t\tonKeyDown=\"limitaTextArea(document.Asunto.asuntoSintesis,'Solicitud','4000')\">".toCharArray();
    __oracle_jsp_text[422] = 
    "</TEXTAREA>\n\t\t\t".toCharArray();
    __oracle_jsp_text[423] = 
    "\n\t\t\t<TEXTAREA name=\"asuntoSintesis\" rows=\"8\" cols=\"60\" class=\"blue600a\"\n\t\t\tonKeyDown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);limitaTextArea(document.Asunto.asuntoSintesis,'Solicitud','4000');\">".toCharArray();
    __oracle_jsp_text[424] = 
    "</TEXTAREA>\n\t\t\t".toCharArray();
    __oracle_jsp_text[425] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Comentarios:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[426] = 
    "\n\t\t\t<TEXTAREA name=\"asuntoComentario\" rows=\"8\" cols=\"60\" disabled=\"disabled\" class=\"blue600a\"\n\t\t\tonKeyDown=\"limitaTextArea(document.Asunto.asuntoComentario,'Comentarios','4000')\">".toCharArray();
    __oracle_jsp_text[427] = 
    "</TEXTAREA>\n\t\t\t".toCharArray();
    __oracle_jsp_text[428] = 
    "\n\t\t\t<TEXTAREA name=\"asuntoComentario\" rows=\"8\" cols=\"60\" class=\"blue600a\"\n\t\t\tonKeyDown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);limitaTextArea(document.Asunto.asuntoComentario,'Comentarios','4000');\">".toCharArray();
    __oracle_jsp_text[429] = 
    "</TEXTAREA>\n\t\t\t".toCharArray();
    __oracle_jsp_text[430] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Palabra Clave:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[431] = 
    "\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoPalabraClave\" value=\"".toCharArray();
    __oracle_jsp_text[432] = 
    "\" disabled=\"disabled\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[433] = 
    "\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoPalabraClave\" value=\"".toCharArray();
    __oracle_jsp_text[434] = 
    "\" maxlength=\"200\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[435] = 
    "\n\t\t</TD>\n    </TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Expediente:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[436] = 
    "\n                                    ".toCharArray();
    __oracle_jsp_text[437] = 
    "\n\t\t\t\t<IFRAME src=\"ExpedienteInstrccion.jsp?strIdAsunto=".toCharArray();
    __oracle_jsp_text[438] = 
    "\" WIDTH=800 HEIGHT=100 frameborder=0 id=\"Entidad\"></IFRAME>\n                                    ".toCharArray();
    __oracle_jsp_text[439] = 
    "\n                                \n\t\t\t\t<SELECT name=\"asuntoExpediente\" class=\"blue600a\" onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[440] = 
    " \n\t\t\t\t\t<OPTION value=\"null\">----- Expedientes de la Unidad Administrativa -----</OPTION>\n                                            ".toCharArray();
    __oracle_jsp_text[441] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[442] = 
    "\" ".toCharArray();
    __oracle_jsp_text[443] = 
    ">".toCharArray();
    __oracle_jsp_text[444] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[445] = 
    "\t\n\t\t\t\t</SELECT>\n                                ".toCharArray();
    __oracle_jsp_text[446] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[447] = 
    "\n\t\t\t\t<SELECT name=\"asuntoExpediente\" class=\"blue600a\" onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[448] = 
    "\n\t\t\t\t\t<OPTION value=\"null\">------ Expedientes de la Unidad Administrativa ------</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[449] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[450] = 
    "\" ".toCharArray();
    __oracle_jsp_text[451] = 
    ">".toCharArray();
    __oracle_jsp_text[452] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[453] = 
    "\n\t\t\t\t\t\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[454] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n ".toCharArray();
    __oracle_jsp_text[455] = 
    "\n".toCharArray();
    __oracle_jsp_text[456] = 
    " \n<DIV align=\"center\">\n<TABLE>\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD align=\"center\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\"><b>Relaciones Anexadas</b></FONT></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE border=\"0\">\n\t<TR bgcolor=\"#00204f\">\n\t\t<TD width=\"438\" align=\"center\"><FONT size=\"1\" color=\"#ffffff\"\n\t\t\tface=\"verdana\">Folio / Tipo de relación</FONT></TD>\n\t\t<!-- <TD align=\"center\" width=\"274\"><FONT size=\"1\" color=\"#ffffff\"\n\t\t\tface=\"verdana\">Tipo de relación</FONT></TD> -->\n\t\t<TD width=\"200\" align=\"center\"><FONT size=\"1\" color=\"#ffffff\"\n\t\t\tface=\"verdana\">Folio Documento</FONT></TD>\n\t\t<TD width=\"194\" align=\"center\"><FONT size=\"1\" color=\"#ffffff\"\n\t\t\tface=\"verdana\">Estatus</FONT></TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[457] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[458] = 
    "\n\t<TR ".toCharArray();
    __oracle_jsp_text[459] = 
    " ".toCharArray();
    __oracle_jsp_text[460] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[461] = 
    ">\n\t\t<TD width=\"438\" align=\"left\">".toCharArray();
    __oracle_jsp_text[462] = 
    "&nbsp;es&nbsp;".toCharArray();
    __oracle_jsp_text[463] = 
    "&nbsp;de&nbsp; \n\t\t\t<A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[464] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[465] = 
    "\">\n\t\t\t<FONT size=\"1\" color=\"#004080\" face=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[466] = 
    "</FONT></A>\n\t\t</TD>\n\t\t<!-- <td width=\"274\" align=\"center\"><FONT size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">".toCharArray();
    __oracle_jsp_text[467] = 
    "</FONT></td> -->\n\t\t<td width=\"200\" align=\"center\"><FONT size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">".toCharArray();
    __oracle_jsp_text[468] = 
    "</FONT></td>\n\t\t<td width=\"194\" align=\"center\"><FONT size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[469] = 
    "\n\t\t\tAsunto En Recepci&oacute;n\n\t\t".toCharArray();
    __oracle_jsp_text[470] = 
    "\n\t\t    Asunto Por Turnar\n\t\t".toCharArray();
    __oracle_jsp_text[471] = 
    "\n\t\t    Asunto En Tr&aacute;mite\n\t\t".toCharArray();
    __oracle_jsp_text[472] = 
    "\n\t\t    Asunto Terminado\n\t\t".toCharArray();
    __oracle_jsp_text[473] = 
    "\n         </FONT></td>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[474] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[475] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[476] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[477] = 
    "\n\t<TR ".toCharArray();
    __oracle_jsp_text[478] = 
    " ".toCharArray();
    __oracle_jsp_text[479] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[480] = 
    ">\n\t\t<TD width=\"438\" align=\"left\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[481] = 
    "\n\t\t\t<A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[482] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[483] = 
    "\">\n\t\t\t<FONT size=\"1\" color=\"#004080\" face=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[484] = 
    "</FONT>\n\t\t\t</A>".toCharArray();
    __oracle_jsp_text[485] = 
    "\n\t\t\t<A href=\"AsuntoRecepcion.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[486] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[487] = 
    "\">\n\t\t\t<FONT size=\"1\" color=\"#004080\" face=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[488] = 
    "</FONT></A>\n\t\t\t".toCharArray();
    __oracle_jsp_text[489] = 
    " &nbsp;es&nbsp;".toCharArray();
    __oracle_jsp_text[490] = 
    "&nbsp;de&nbsp;".toCharArray();
    __oracle_jsp_text[491] = 
    "\n\t\t</TD>\n\t\t<!-- <td width=\"274\" align=\"center\"><FONT size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">".toCharArray();
    __oracle_jsp_text[492] = 
    "</FONT></td> -->\n\t\t<td width=\"200\" align=\"center\"><FONT size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">".toCharArray();
    __oracle_jsp_text[493] = 
    "</FONT></td>\n\t\t<td width=\"194\" align=\"center\"><FONT size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">".toCharArray();
    __oracle_jsp_text[494] = 
    "</FONT></td>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[495] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[496] = 
    "\n</TABLE>\n</div>\n ".toCharArray();
    __oracle_jsp_text[497] = 
    " <BR>\n\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TBODY>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos de Evento</font></b></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"847\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</tr>\n\t</TBODY>\n</table>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t  <td width=\"183\" height=\"22\"></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"60\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"283\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fecha del evento:</FONT></td>\n\t\t<td colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[498] = 
    "\n\t\t\t<INPUT class=\"blue100a\"  name=\"fechaEvento\" value=\"".toCharArray();
    __oracle_jsp_text[499] = 
    "\" disabled=\"disabled\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[500] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t<INPUT class=\"blue100a\"  name=\"fechaEvento\" value=\"".toCharArray();
    __oracle_jsp_text[501] = 
    "\" maxlength=\"10\" onblur=\"validaFormatoFecha();\" onKeyUp=\"validaFechaEve();\" onKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t</FONT> \n\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick='document.Asunto.strBandera.value=true;show_calendar(\"forms[0].fechaEvento\");' name=\"cEvento\"></A>\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[502] = 
    "\n\t\t</td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t  <td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\"></FONT></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Hora del Evento:</FONT></td>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[503] = 
    "\n\t\t\t<SELECT name=\"hora_evento\" class=\"blue50a\" disabled=\"disabled\">\n\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[504] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[505] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[506] = 
    "\" ".toCharArray();
    __oracle_jsp_text[507] = 
    ">".toCharArray();
    __oracle_jsp_text[508] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[509] = 
    "\n\t\t\t</SELECT>\n\t\t\t<FONT face=\"Verdana\" size=\"2\">:</FONT>\n\t\t\t<SELECT name=\"min_evento\" class=\"blue50a\" disabled=\"disabled\">\n\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[510] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[511] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[512] = 
    "\" ".toCharArray();
    __oracle_jsp_text[513] = 
    ">".toCharArray();
    __oracle_jsp_text[514] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[515] = 
    "\n\t\t\t</SELECT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[516] = 
    "\n\t\t\t<SELECT name=\"hora_evento\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[517] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[518] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[519] = 
    "\" ".toCharArray();
    __oracle_jsp_text[520] = 
    ">".toCharArray();
    __oracle_jsp_text[521] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[522] = 
    "\n\t\t\t</SELECT>\n\t\t\t<FONT face=\"Verdana\" size=\"2\">:</FONT>\n\t\t\t<SELECT name=\"min_evento\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[523] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[524] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[525] = 
    "\" ".toCharArray();
    __oracle_jsp_text[526] = 
    ">".toCharArray();
    __oracle_jsp_text[527] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[528] = 
    "\n\t\t\t</SELECT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[529] = 
    "\n\t\t</TD>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t  <td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\"></FONT></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Lugar del evento:</FONT></td>\n\t\t<td colspan=\"3\">\n\t\t".toCharArray();
    __oracle_jsp_text[530] = 
    "\n\t\t<TEXTAREA name=\"lugarEvento\" rows=\"2\" cols=\"60\" disabled=\"disabled\" class=\"blue600a\">".toCharArray();
    __oracle_jsp_text[531] = 
    "</TEXTAREA>\n\t\t".toCharArray();
    __oracle_jsp_text[532] = 
    "\n\t\t<TEXTAREA name=\"lugarEvento\" rows=\"2\" cols=\"60\" class=\"blue600a\"\n\t\t\t\tonkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);limitaTextArea(document.Asunto.lugarEvento,'Lugar del Evento', '100');\">".toCharArray();
    __oracle_jsp_text[533] = 
    "</TEXTAREA>\n\t\t".toCharArray();
    __oracle_jsp_text[534] = 
    "\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t  <td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\"></FONT></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t</TBODY>\n</table>\n</DIV>\n <!-- \n\tBloque para ver los datos de turnado, solo el usuario que tenga\n\tel rol de turnado puede ver este bloque\n--> ".toCharArray();
    __oracle_jsp_text[535] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[536] = 
    "\n\t\t<DIV align=\"center\">\n\n\t\t<TABLE border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<TBODY>\n\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t<TD width=\"183\"><B><FONT size=\"2\" color=\"#004080\" face=\"Arial\">Datos\n\t\t\t\t\tdel Turnado</FONT></B></TD>\n\t\t\t\t\t<TD width=\"233\"><IMG src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t\t\t<TD width=\"67\"><IMG src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t\t\t<TD width=\"364\"><IMG src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t\t</TR>\n\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t<TD width=\"847\" bgcolor=\"#004080\" colspan=\"4\"><IMG\n\t\t\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t\t\t</TR>\n\t\t\t</TBODY>\n\t\t</TABLE>\n\n\n\t\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t\t<TBODY>\n\n\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t\t\t<TD width=\"233\"><IMG src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t\t\t<TD width=\"67\"><IMG src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t\t\t<TD width=\"364\"><IMG src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t\t</TR>\n\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Prioridad:</FONT>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD colspan=\"3\">".toCharArray();
    __oracle_jsp_text[537] = 
    "\n\t\t\t\t\t<INPUT name=\"asuntoPrioridad_2\" value=\"".toCharArray();
    __oracle_jsp_text[538] = 
    "\" disabled=\"disabled\" class=\"blue600a\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[539] = 
    "\n\t\t\t\t\t\t<FONT face=\"Arial\" size=\"2\"> <SELECT\n\t\t\t\t\t\tname=\"asuntoPrioridad\" class=\"blue600a\" \n\t\t\t\t\t\tonchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[540] = 
    "\n\t\t\t\t\t\t<OPTION value=\"null\">------ Prioridades de la Unidad\n\t\t\t\t\t\tAdministrativa ------</OPTION>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[541] = 
    "\n\t\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[542] = 
    "\"\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[543] = 
    ">".toCharArray();
    __oracle_jsp_text[544] = 
    "</OPTION>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[545] = 
    "\n\t\t\t\t\t\t<OPTION value=\"null\">------ Prioridades Generales ------</OPTION>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[546] = 
    "\n\t\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[547] = 
    "\"\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[548] = 
    ">".toCharArray();
    __oracle_jsp_text[549] = 
    "</OPTION>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[550] = 
    "\n\t\t\t\t\t\t</SELECT> </FONT>\n\t\t\t\t\t\t \n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[551] = 
    "\n\t\t\t\t\t</TD>\n\t\t\t\t</TR>\n\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t\t\t<TD width=\"233\"><IMG src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t\t\t<TD width=\"67\"><IMG src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t\t\t<TD width=\"364\"><IMG src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t\t</TR>\n\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Tipo de\n\t\t\t\t\tAsunto:</FONT></TD>\n\t\t\t\t\t<TD colspan=\"3\">".toCharArray();
    __oracle_jsp_text[552] = 
    "\n\t\t\t\t\t<FONT face=\"Arial\" size=\"2\"> \n\t\t\t\t\t<INPUT name=\"asuntoTipoAsunto_2\" value=\"".toCharArray();
    __oracle_jsp_text[553] = 
    "\" disabled=\"disabled\" class=\"blue600a\">\n\t\t\t\t\t</FONT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[554] = 
    " \n\t\t\t\t\t\t<FONT face=\"Arial\" size=\"2\"> \t\t\t\t\t\n\t\t\t\t\t\t<SELECT name=\"asuntoTipoAsunto\" class=\"blue600a\" onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[555] = 
    "\n\t\t\t\t\t\t<OPTION value=\"null\">------ Tipos de Asunto de la Unidad ------</OPTION>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[556] = 
    "\n\t\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[557] = 
    "\"\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[558] = 
    ">".toCharArray();
    __oracle_jsp_text[559] = 
    "</OPTION>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[560] = 
    "\n\t\t\t\t\t\t<OPTION value=\"null\">------ Tipos de Asunto Generales ------</OPTION>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[561] = 
    "\n\t\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[562] = 
    "\"\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[563] = 
    ">".toCharArray();
    __oracle_jsp_text[564] = 
    "</OPTION>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[565] = 
    "\n\t\t\t\t\t\t</SELECT> </FONT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[566] = 
    "\n\t\t\t\t<INPUT type=\"hidden\" name=\"asuntoDiferencia\" value=\"0\"></TD>\n\t\t\t\t</TR>\n\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t\t\t\t<TD width=\"233\"><IMG src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t\t\t<TD width=\"67\"><IMG src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t\t\t<TD width=\"364\"><IMG src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t\t\t</TR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[567] = 
    "\n\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t<TD colspan=\"4\">&nbsp;</TD>\n\t\t\t\t</TR>\n\t\t\t</TBODY>\n\t\t</TABLE>\n\t\t</DIV>\n\t".toCharArray();
    __oracle_jsp_text[568] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[569] = 
    "\n\t\t<TR>\n\t\t\t<TD><INPUT type=\"hidden\" name=\"asuntoPrioridad\" value=\"null\"> <INPUT\n\t\t\t\ttype=\"hidden\" name=\"asuntoTipoAsunto\" value=\"null\"> <INPUT\n\t\t\t\ttype=\"hidden\" name=\"asuntoRutaAuto\" value=\"null\"> <INPUT\n\t\t\t\ttype=\"hidden\" name=\"asuntoDiferencia\" value=\"1\"></TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[570] = 
    "\n".toCharArray();
    __oracle_jsp_text[571] = 
    " ".toCharArray();
    __oracle_jsp_text[572] = 
    " \n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Ruta de atención</FONT></B>\n\t\t</TD>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"863\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n ".toCharArray();
    __oracle_jsp_text[573] = 
    " <BR>\n".toCharArray();
    __oracle_jsp_text[574] = 
    " \n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><B><FONT face=\"Arial\" color=\"#004080\"\n\t\t\t\tsize=\"2\">Documentos Anexados</FONT></B></TD>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"863\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"4\">\n\t\t\t\t<div>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[575] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[576] = 
    "\n\t\t\t\t\t\t<IFRAME ID=\"frame1\" SRC=\"ImportarCMO.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[577] = 
    "&bo=true&est=".toCharArray();
    __oracle_jsp_text[578] = 
    "\" WIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME> \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[579] = 
    "\n\t\t\t\t\t\t<IFRAME ID=\"frame1\" SRC=\"ImportarAR.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[580] = 
    "&bo=true&est=".toCharArray();
    __oracle_jsp_text[581] = 
    "\" WIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[582] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[583] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[584] = 
    "\n\t\t\t\t\t\t<IFRAME ID=\"frame1\" SRC=\"ImportarAR.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[585] = 
    "&bo=true&est=".toCharArray();
    __oracle_jsp_text[586] = 
    "\" WIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[587] = 
    "\n\t\t\t\t\t\t<IFRAME ID=\"frame1\" SRC=\"ImportarCMO.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[588] = 
    "&bo=true&est=".toCharArray();
    __oracle_jsp_text[589] = 
    "\" WIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[590] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[591] = 
    "\n\t\t\t\t</div>\n\t\t\t</TD> \n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n ".toCharArray();
    __oracle_jsp_text[592] = 
    " ".toCharArray();
    __oracle_jsp_text[593] = 
    " <SCRIPT\n\tlanguage=\"JavaScript\" type=\"text/javascript\">\nagregar();\n</SCRIPT> ".toCharArray();
    __oracle_jsp_text[594] = 
    " <SCRIPT>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</SCRIPT>\n<BR>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n\nhorarioVent = horarioVentanilla();\n//if(horarioVent)\n//\talert(\"La hora actual está fuera del rango de atención de la Unidad Administrativa\");\n\nmensaje = \"".toCharArray();
    __oracle_jsp_text[595] = 
    "\";\n\nif (".toCharArray();
    __oracle_jsp_text[596] = 
    "){\n\talert(mensaje);\n}\n\nif (".toCharArray();
    __oracle_jsp_text[597] = 
    "){\n\talert(\"Este Asunto ha sido modificado por otro usuario y Cambió su Estatus,\\npor lo que la acción solicitada será cancelada\");\n\tlocation.assign(\"portalPrincipal.jsp\");\n}\n\nif (".toCharArray();
    __oracle_jsp_text[598] = 
    "){\n\talert(\"La Fecha-Hora de Recepcion no puede ser mayor a la actual\");\n}\n\n</SCRIPT> ".toCharArray();
    __oracle_jsp_text[599] = 
    " <SCRIPT\n\ttype=\"text/javascript\">\n<!--\n\tdoc = document.Asunto;\n\tif (doc.idDestinatario.value == \"\"){\n\t\tdoc.idDestinatario.value = \"".toCharArray();
    __oracle_jsp_text[600] = 
    "\";\n\t\tdoc.asuntoDestinatario.value = \"".toCharArray();
    __oracle_jsp_text[601] = 
    "\"+\" / \"+\"".toCharArray();
    __oracle_jsp_text[602] = 
    "\";\n\t\tdoc.asuntoCargoDest.value = \"".toCharArray();
    __oracle_jsp_text[603] = 
    "\";\n\t\tdoc.asuntoAreaDest.value = \"".toCharArray();
    __oracle_jsp_text[604] = 
    "\";\n\t\tdoc.mailDest.value = \"".toCharArray();
    __oracle_jsp_text[605] = 
    "\";\n\t}\n//-->\n</SCRIPT> ".toCharArray();
    __oracle_jsp_text[606] = 
    " </FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
