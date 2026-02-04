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
import java.io.*;;


public class _AsuntoRecepcion extends com.orionserver.http.OrionHttpJspPage {


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
    _AsuntoRecepcion page = this;
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
      com.meve.sigma.beans.Asunto AsuntoRep;
      synchronized (pageContext) {
        if ((AsuntoRep = (com.meve.sigma.beans.Asunto) pageContext.getAttribute( "AsuntoRep", PageContext.PAGE_SCOPE)) == null) {
          AsuntoRep = (com.meve.sigma.beans.Asunto) new com.meve.sigma.beans.Asunto();
          pageContext.setAttribute( "AsuntoRep", AsuntoRep, PageContext.PAGE_SCOPE);
          out.write(__oracle_jsp_text[4]);
          OracleJspRuntime.__jspSetAllParams(request, (Object)AsuntoRep, true);
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
          
          out.write(__oracle_jsp_text[12]);
          
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
          		strEstatusN = "En Recepción";
          	}else if(strEstatus.equals("1")){
          		strEstatusN = "Por Turnar";
          	}else if(strEstatus.equals("2")){
          		strEstatusN = "En Trámite";
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
          
          
          out.write(__oracle_jsp_text[20]);
           
          	//** los usuarios que tengan el perfil de administrador y Recepción
          	//** pueden modificar el asunto
          	if(BUsuario.getRecepcion() ||
          		BUsuario.getTurnado()){
          	}
          	else{
          
          out.write(__oracle_jsp_text[21]);
          if (true) {
            String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
            // Forward 
            pageContext.forward( __url);
            return;
          }

          out.write(__oracle_jsp_text[22]);
           	} 
          out.write(__oracle_jsp_text[23]);
          out.write(__oracle_jsp_text[24]);
          out.print(BUsuario.getIdArea());
          out.write(__oracle_jsp_text[25]);
          out.print(BUsuario.getIdUsuario());
          out.write(__oracle_jsp_text[26]);
          out.print(strEstValidacion);
          out.write(__oracle_jsp_text[27]);
          out.print(BUsuario.getIdArea());
          out.write(__oracle_jsp_text[28]);
          out.print(BUsuario.getIdUsuario());
          out.write(__oracle_jsp_text[29]);
          out.print(strEstValidacion);
          out.write(__oracle_jsp_text[30]);
          out.print(strFolioGenerado);
          out.write(__oracle_jsp_text[31]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[32]);
          out.print(strA);
          out.write(__oracle_jsp_text[33]);
          out.print(strEstValidacion);
          out.write(__oracle_jsp_text[34]);
          out.print( Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
          out.write(__oracle_jsp_text[35]);
          out.print(strFolioGenerado);
          out.write(__oracle_jsp_text[36]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[37]);
          out.print(strA);
          out.write(__oracle_jsp_text[38]);
          out.print(strEstValidacion);
          out.write(__oracle_jsp_text[39]);
          out.print( Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
          out.write(__oracle_jsp_text[40]);
          out.print(strFolioGenerado);
          out.write(__oracle_jsp_text[41]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[42]);
          out.print(strA);
          out.write(__oracle_jsp_text[43]);
           if(strActivarCM.equals("si")){ 
          out.write(__oracle_jsp_text[44]);
          out.print( serverContentManager );
          out.write(__oracle_jsp_text[45]);
          out.print(strItemType);
          out.write(__oracle_jsp_text[46]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[47]);
          out.print("SinFilio");
          out.write(__oracle_jsp_text[48]);
          out.print(BUsuario.getNombre());
          out.write(__oracle_jsp_text[49]);
          }else{
          out.write(__oracle_jsp_text[50]);
          out.print(server);
          out.print(strRutaBase);
          out.write(__oracle_jsp_text[51]);
          out.print(strItemType);
          out.write(__oracle_jsp_text[52]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[53]);
          out.print("SinFolio");
          out.write(__oracle_jsp_text[54]);
          out.print(BUsuario.getIdUsuario());
          out.write(__oracle_jsp_text[55]);
          }
          out.write(__oracle_jsp_text[56]);
          out.print( retURI );
          out.write(__oracle_jsp_text[57]);
          out.print( retURI );
          out.write(__oracle_jsp_text[58]);
           	for (int ik=0; ik<finesSemana.size(); ik++){ 
          out.write(__oracle_jsp_text[59]);
          out.print( (String)finesSemana.get(ik) );
          out.write(__oracle_jsp_text[60]);
          	} 
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
          out.print(strPara);
          out.write(__oracle_jsp_text[76]);
          out.print(strCC);
          out.write(__oracle_jsp_text[77]);
          out.print(strParaE);
          out.write(__oracle_jsp_text[78]);
          out.print(retURI);
          out.write(__oracle_jsp_text[79]);
          out.print( strHorarioUAEntrada );
          out.write(__oracle_jsp_text[80]);
          out.print( strHorarioUASalida );
          out.write(__oracle_jsp_text[81]);
          out.print( BUsuario.getIdArea() );
          out.write(__oracle_jsp_text[82]);
          out.print( contador );
          out.write(__oracle_jsp_text[83]);
          out.print( strBandera );
          out.write(__oracle_jsp_text[84]);
          out.print( setFoco );
          out.write(__oracle_jsp_text[85]);
          out.print(strEstatus);
          out.write(__oracle_jsp_text[86]);
          out.print(strFeFormateada4);
          out.write(__oracle_jsp_text[87]);
          out.print(strAccionArchivo);
          out.write(__oracle_jsp_text[88]);
          out.print(strIdTramite);
          out.write(__oracle_jsp_text[89]);
          out.print(strEstValidacion);
          out.write(__oracle_jsp_text[90]);
          if(strEstatus.equals("0")){ 
          out.write(__oracle_jsp_text[91]);
           }else if(strEstatus.equals("1")){ 
          out.write(__oracle_jsp_text[92]);
           }else if(strEstatus.equals("2")){ 
          out.write(__oracle_jsp_text[93]);
           }else if(strEstatus.equals("3")){
          out.write(__oracle_jsp_text[94]);
           }
          out.write(__oracle_jsp_text[95]);
          {
            org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_1=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
            __jsp_taghandler_1.setParent(null);
            __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
            {
              do {
                out.write(__oracle_jsp_text[96]);
                {
                  org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_2=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
                  __jsp_taghandler_2.setParent(__jsp_taghandler_1);
                  __jsp_taghandler_2.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
                  __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[97]);
                    } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
                }
                out.write(__oracle_jsp_text[98]);
                {
                  org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_3=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
                  __jsp_taghandler_3.setParent(__jsp_taghandler_1);
                  __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[99]);
                    } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
                }
                out.write(__oracle_jsp_text[100]);
              } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
          }
          out.write(__oracle_jsp_text[101]);
          {
            org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_4=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
            __jsp_taghandler_4.setParent(null);
            __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
            {
              do {
                out.write(__oracle_jsp_text[102]);
                {
                  org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_5=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
                  __jsp_taghandler_5.setParent(__jsp_taghandler_4);
                  __jsp_taghandler_5.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
                  __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[103]);
                    } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
                }
                out.write(__oracle_jsp_text[104]);
                {
                  org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_6=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
                  __jsp_taghandler_6.setParent(__jsp_taghandler_4);
                  __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[105]);
                    } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
                }
                out.write(__oracle_jsp_text[106]);
              } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
          }
          out.write(__oracle_jsp_text[107]);
          {
            org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_7=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
            __jsp_taghandler_7.setParent(null);
            __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
            {
              do {
                out.write(__oracle_jsp_text[108]);
                {
                  org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_8=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
                  __jsp_taghandler_8.setParent(__jsp_taghandler_7);
                  __jsp_taghandler_8.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
                  __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[109]);
                    } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
                }
                out.write(__oracle_jsp_text[110]);
                {
                  org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_9=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
                  __jsp_taghandler_9.setParent(__jsp_taghandler_7);
                  __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[111]);
                    } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
                }
                out.write(__oracle_jsp_text[112]);
              } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
          }
          out.write(__oracle_jsp_text[113]);
          {
            org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_10=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
            __jsp_taghandler_10.setParent(null);
            __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
            {
              do {
                out.write(__oracle_jsp_text[114]);
                {
                  org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_11=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
                  __jsp_taghandler_11.setParent(__jsp_taghandler_10);
                  __jsp_taghandler_11.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
                  __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[115]);
                      out.print(strIdAsunto );
                      out.write(__oracle_jsp_text[116]);
                      out.print(ids );
                      out.write(__oracle_jsp_text[117]);
                      out.print(refs );
                      out.write(__oracle_jsp_text[118]);
                    } while (__jsp_taghandler_11.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,2);
                }
                out.write(__oracle_jsp_text[119]);
                {
                  org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_12=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
                  __jsp_taghandler_12.setParent(__jsp_taghandler_10);
                  __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[120]);
                    } while (__jsp_taghandler_12.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
                }
                out.write(__oracle_jsp_text[121]);
              } while (__jsp_taghandler_10.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,1);
          }
          out.write(__oracle_jsp_text[122]);
          if (strFolioGenerado.equals("folio por asignar")){
          out.write(__oracle_jsp_text[123]);
          {
            org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_13=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
            __jsp_taghandler_13.setParent(null);
            __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
            {
              do {
                out.write(__oracle_jsp_text[124]);
                {
                  org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_14=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
                  __jsp_taghandler_14.setParent(__jsp_taghandler_13);
                  __jsp_taghandler_14.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
                  __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[125]);
                    } while (__jsp_taghandler_14.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,2);
                }
                out.write(__oracle_jsp_text[126]);
                {
                  org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_15=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
                  __jsp_taghandler_15.setParent(__jsp_taghandler_13);
                  __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[127]);
                    } while (__jsp_taghandler_15.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,2);
                }
                out.write(__oracle_jsp_text[128]);
              } while (__jsp_taghandler_13.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,1);
          }
          out.write(__oracle_jsp_text[129]);
          }
          out.write(__oracle_jsp_text[130]);
          out.print(strMensajeDuplicado);
          out.write(__oracle_jsp_text[131]);
           if(strIdAsunto != null && strIdAsunto.trim().length()>0){ 
          out.write(__oracle_jsp_text[132]);
          out.print( ActualizaUsuario.NombreUsuario(strCreador1) );
          out.write(__oracle_jsp_text[133]);
          out.print( strFeFormateada4 );
          out.write(__oracle_jsp_text[134]);
          out.print( strEstatusN );
          out.write(__oracle_jsp_text[135]);
          out.print( strFolioGenerado );
          out.write(__oracle_jsp_text[136]);
           } 
          out.write(__oracle_jsp_text[137]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[138]);
          }else{
          out.write(__oracle_jsp_text[139]);
          out.write(__oracle_jsp_text[140]);
          out.print(strAreaUs);
          out.write(__oracle_jsp_text[141]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[142]);
          out.print( (strControl!=null && strControl.equals("0"))?"0":"1" );
          out.write(__oracle_jsp_text[143]);
          out.print(strIdEntidad+"|"+strEntidad+"/"+strControl);
          out.write(__oracle_jsp_text[144]);
          }
          out.write(__oracle_jsp_text[145]);
          out.write(__oracle_jsp_text[146]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[147]);
          out.print( strEntidad );
          out.write(__oracle_jsp_text[148]);
          }else{
          out.write(__oracle_jsp_text[149]);
          out.print( strEntidad );
          out.write(__oracle_jsp_text[150]);
          }
          out.write(__oracle_jsp_text[151]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[152]);
          }else{
          out.write(__oracle_jsp_text[153]);
          out.write(__oracle_jsp_text[154]);
          }
          out.write(__oracle_jsp_text[155]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[156]);
          }else{
          out.write(__oracle_jsp_text[157]);
          }
          out.write(__oracle_jsp_text[158]);
          out.write(__oracle_jsp_text[159]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[160]);
          out.print( strRemitente );
          out.write(__oracle_jsp_text[161]);
          out.print( strCargo );
          out.write(__oracle_jsp_text[162]);
          out.print(strCorreo);
          out.write(__oracle_jsp_text[163]);
          }else{
          out.write(__oracle_jsp_text[164]);
          out.print( strRemitente );
          out.write(__oracle_jsp_text[165]);
          out.print(strCargo);
          out.write(__oracle_jsp_text[166]);
          out.print(strCorreo);
          out.write(__oracle_jsp_text[167]);
          }
          out.write(__oracle_jsp_text[168]);
          out.print( strFirmante );
          out.write(__oracle_jsp_text[169]);
          out.write(__oracle_jsp_text[170]);
          out.print((strTipoFolio.equals("1")?"Salida":"Entrada"));
          out.write(__oracle_jsp_text[171]);
          out.print(strTipoFolio);
          out.write(__oracle_jsp_text[172]);
          out.print(BUsuario.getIdArea());
          out.write(__oracle_jsp_text[173]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[174]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[175]);
          out.print(BUsuario.getIdArea());
          out.write(__oracle_jsp_text[176]);
          out.print( strDestinatario );
          out.write(__oracle_jsp_text[177]);
          out.print(strCargoDest);
          out.write(__oracle_jsp_text[178]);
          out.print(strAreaDest);
          out.write(__oracle_jsp_text[179]);
          if(strIdAsunto != null && strIdAsunto.length() >0 && bexisteInst == true){
          out.write(__oracle_jsp_text[180]);
          }else{
          out.write(__oracle_jsp_text[181]);
          out.print(strTipoFolio );
          out.write(__oracle_jsp_text[182]);
          out.print(BUsuario.getIdArea());
          out.write(__oracle_jsp_text[183]);
          out.print(Utilerias.getCadenaParaCC(listaIDSPara));
          out.write(__oracle_jsp_text[184]);
          out.print(Utilerias.getCadenaParaCC(listaIDSCC));
          out.write(__oracle_jsp_text[185]);
          out.print(strIdsPara);
          out.write(__oracle_jsp_text[186]);
          out.print(strIdsCC);
          out.write(__oracle_jsp_text[187]);
          }
          out.write(__oracle_jsp_text[188]);
          for(int t=0;t<listaIDSPara.size();t++){
          out.write(__oracle_jsp_text[189]);
          out.print(listaIDSPara.elementAt(t));
          out.write(__oracle_jsp_text[190]);
          out.print(listaIDSPara.elementAt(t));
          out.write(__oracle_jsp_text[191]);
          }
          out.write(__oracle_jsp_text[192]);
          for(int t=0;t<listaIDSCC.size();t++){
          out.write(__oracle_jsp_text[193]);
          out.print(listaIDSCC.elementAt(t));
          out.write(__oracle_jsp_text[194]);
          out.print(listaIDSCC.elementAt(t));
          out.write(__oracle_jsp_text[195]);
          }
          out.write(__oracle_jsp_text[196]);
          if(strIdAsunto != null && strIdAsunto.length() >0 && bexisteInst == true){
          out.write(__oracle_jsp_text[197]);
          }else{
          out.write(__oracle_jsp_text[198]);
          out.print(Utilerias.codificaPostHTML(Utilerias.getCadenaParaCC(listaIDSParaExt)));
          out.write(__oracle_jsp_text[199]);
          out.print(strIdsParaE);
          out.write(__oracle_jsp_text[200]);
          out.print( strAreaUs );
          out.write(__oracle_jsp_text[201]);
          }
          out.write(__oracle_jsp_text[202]);
          for(int t=0;t<listaIDSParaExt.size();t++){
          out.write(__oracle_jsp_text[203]);
          out.print(listaIDSParaExt.elementAt(t));
          out.write(__oracle_jsp_text[204]);
          out.print(listaIDSParaExt.elementAt(t));
          out.write(__oracle_jsp_text[205]);
          }
          out.write(__oracle_jsp_text[206]);
          out.print( strAsunto );
          out.write(__oracle_jsp_text[207]);
          {
            org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_16=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
            __jsp_taghandler_16.setParent(null);
            __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
            {
              do {
                out.write(__oracle_jsp_text[208]);
                {
                  org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_17=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
                  __jsp_taghandler_17.setParent(__jsp_taghandler_16);
                  __jsp_taghandler_17.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
                  __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[209]);
                       if(strIdAsunto != null && strIdAsunto.length() >0 && bexisteInst == false){ 
                      out.write(__oracle_jsp_text[210]);
                       
                      				String strComboTipDoc[][] = null;
                      				String strComboTipDocGral[][] = null;
                      				strComboTipDoc = ComboData.getTipoDoctoAreaCombo(strAreaUs);
                      				strComboTipDocGral = ComboData.getTipoDoctosGralesCombo();
                      			
                      out.write(__oracle_jsp_text[211]);
                      if (!strFolioGenerado.equals("folio por asignar")){
                      out.write(__oracle_jsp_text[212]);
                       for(int q=0;q<strComboTipDoc.length;q++){
                      			      if(strIdTipoDocto.equals(strComboTipDoc[q][0])){
                      out.write(__oracle_jsp_text[213]);
                      out.print(strComboTipDoc[q][0]);
                      out.write(__oracle_jsp_text[214]);
                      out.print((strIdTipoDocto.trim().equals(strComboTipDoc[q][0])?"selected":""));
                      out.write(__oracle_jsp_text[215]);
                      out.print(strComboTipDoc[q][1]);
                      out.write(__oracle_jsp_text[216]);
                      }
                      			   } 
                      out.write(__oracle_jsp_text[217]);
                       for(int y=0;y<strComboTipDocGral.length;y++){ 
                      out.write(__oracle_jsp_text[218]);
                      if(strIdTipoDocto.equals(strComboTipDocGral[y][0])){ 
                      out.write(__oracle_jsp_text[219]);
                      out.print(strComboTipDocGral[y][0]);
                      out.write(__oracle_jsp_text[220]);
                      out.print((strIdTipoDocto.trim().equals(strComboTipDocGral[y][0])?"selected":""));
                      out.write(__oracle_jsp_text[221]);
                      out.print(strComboTipDocGral[y][1]);
                      out.write(__oracle_jsp_text[222]);
                       }
                      		      }
                      out.write(__oracle_jsp_text[223]);
                      }else{ 
                      out.write(__oracle_jsp_text[224]);
                       for(int q=0;q<strComboTipDoc.length;q++){ 
                      out.write(__oracle_jsp_text[225]);
                      out.print(strComboTipDoc[q][0]);
                      out.write(__oracle_jsp_text[226]);
                      out.print((strIdTipoDocto.trim().equals(strComboTipDoc[q][0])?"selected":""));
                      out.write(__oracle_jsp_text[227]);
                      out.print(strComboTipDoc[q][1]);
                      out.write(__oracle_jsp_text[228]);
                       } 
                      out.write(__oracle_jsp_text[229]);
                       for(int y=0;y<strComboTipDocGral.length;y++){ 
                      out.write(__oracle_jsp_text[230]);
                      out.print(strComboTipDocGral[y][0]);
                      out.write(__oracle_jsp_text[231]);
                      out.print((strIdTipoDocto.trim().equals(strComboTipDocGral[y][0])?"selected":""));
                      out.write(__oracle_jsp_text[232]);
                      out.print(strComboTipDocGral[y][1]);
                      out.write(__oracle_jsp_text[233]);
                       } 
                      out.write(__oracle_jsp_text[234]);
                      } 
                      out.write(__oracle_jsp_text[235]);
                       }else if(strIdAsunto != null && strIdAsunto.length() >0 && bexisteInst == true){ 
                      out.write(__oracle_jsp_text[236]);
                      {
                        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_18=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml textoNoSeleccion valorNoSeleccion");
                        __jsp_taghandler_18.setParent(__jsp_taghandler_17);
                        __jsp_taghandler_18.setData(ComboData.getTipoDoctoAreaCombo(strAreaUs));
                        __jsp_taghandler_18.setName("asuntoTipoDocto");
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
                      out.write(__oracle_jsp_text[237]);
                       }else{ 
                      out.write(__oracle_jsp_text[238]);
                       
                      				String strComboTipDoc[][] = null;
                      				String strComboTipDocGral[][] = null;
                      				strComboTipDoc = ComboData.getTipoDoctoAreaCombo(strAreaUs);
                      				strComboTipDocGral = ComboData.getTipoDoctosGralesCombo();
                      			
                      out.write(__oracle_jsp_text[239]);
                       for(int q=0;q<strComboTipDoc.length;q++){ 
                      out.write(__oracle_jsp_text[240]);
                      out.print(strComboTipDoc[q][0]);
                      out.write(__oracle_jsp_text[241]);
                      out.print(strComboTipDoc[q][1]);
                      out.write(__oracle_jsp_text[242]);
                       } 
                      out.write(__oracle_jsp_text[243]);
                       for(int y=0;y<strComboTipDocGral.length;y++){ 
                      out.write(__oracle_jsp_text[244]);
                      out.print(strComboTipDocGral[y][0]);
                      out.write(__oracle_jsp_text[245]);
                      out.print(strComboTipDocGral[y][1]);
                      out.write(__oracle_jsp_text[246]);
                       } 
                      out.write(__oracle_jsp_text[247]);
                       } 
                      out.write(__oracle_jsp_text[248]);
                    } while (__jsp_taghandler_17.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,2);
                }
                out.write(__oracle_jsp_text[249]);
                {
                  org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_19=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
                  __jsp_taghandler_19.setParent(__jsp_taghandler_16);
                  __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[250]);
                    } while (__jsp_taghandler_19.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,2);
                }
                out.write(__oracle_jsp_text[251]);
              } while (__jsp_taghandler_16.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,1);
          }
          out.write(__oracle_jsp_text[252]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[253]);
          out.print( strFeFormateada1 );
          out.write(__oracle_jsp_text[254]);
          for(int i=0;i<24;i++){
          out.write(__oracle_jsp_text[255]);
          
          				String a = String.valueOf(i);
          				if(a.length()==1)
          					a="0"+a;
          				if(strHoraRecep.length()==1)
          					strHoraRecep="0"+strHoraRecep;
          				
          out.write(__oracle_jsp_text[256]);
          out.print(a);
          out.write(__oracle_jsp_text[257]);
          out.print((strHoraRecep.equals(a)?"selected":""));
          out.write(__oracle_jsp_text[258]);
          out.print(a);
          out.write(__oracle_jsp_text[259]);
          }
          out.write(__oracle_jsp_text[260]);
          for(int i=0;i<60;i++){
          out.write(__oracle_jsp_text[261]);
          
          				String a = String.valueOf(i);
          				if(a.length()==1)
          					a="0"+a;
          				if(strMinRecep.length()==1)
          					strMinRecep="0"+strMinRecep;
          				
          out.write(__oracle_jsp_text[262]);
          out.print(a);
          out.write(__oracle_jsp_text[263]);
          out.print((strMinRecep.equals(a)?"selected":""));
          out.write(__oracle_jsp_text[264]);
          out.print(a);
          out.write(__oracle_jsp_text[265]);
          }
          out.write(__oracle_jsp_text[266]);
           }else{ 
          out.write(__oracle_jsp_text[267]);
          out.print( strFeFormateada1 );
          out.write(__oracle_jsp_text[268]);
          for(int i=0;i<24;i++){
          out.write(__oracle_jsp_text[269]);
          
          				String a = String.valueOf(i);
          				if(a.length()==1)
          					a="0"+a;
          				if(strHoraRecep.length()==1)
          					strHoraRecep="0"+strHoraRecep;
          				
          out.write(__oracle_jsp_text[270]);
          out.print(a);
          out.write(__oracle_jsp_text[271]);
          out.print((strHoraRecep.equals(a)?"selected":""));
          out.write(__oracle_jsp_text[272]);
          out.print(a);
          out.write(__oracle_jsp_text[273]);
          }
          out.write(__oracle_jsp_text[274]);
          for(int i=0;i<60;i++){
          out.write(__oracle_jsp_text[275]);
          
          				String a = String.valueOf(i);
          				if(a.length()==1)
          					a="0"+a;
          				if(strMinRecep.length()==1)
          					strMinRecep="0"+strMinRecep;
          				
          out.write(__oracle_jsp_text[276]);
          out.print(a);
          out.write(__oracle_jsp_text[277]);
          out.print((strMinRecep.equals(a)?"selected":""));
          out.write(__oracle_jsp_text[278]);
          out.print(a);
          out.write(__oracle_jsp_text[279]);
          }
          out.write(__oracle_jsp_text[280]);
          }
          out.write(__oracle_jsp_text[281]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[282]);
          out.print( strFechaDocto );
          out.write(__oracle_jsp_text[283]);
           }else{ 
          out.write(__oracle_jsp_text[284]);
          out.print( strFechaDocto );
          out.write(__oracle_jsp_text[285]);
          }
          out.write(__oracle_jsp_text[286]);
          
          					String strTramite1[][] = null;
          					strTramite1 =  ActualizaTramite.getComboTramite(BUsuario.getIdArea());
          					for(int i=0;i<strTramite1.length;i++){
          				
          out.write(__oracle_jsp_text[287]);
          out.print(strTramite1[i][0]);
          out.write(__oracle_jsp_text[288]);
          out.print((strTramite.equals(strTramite1[i][0])?"selected":""));
          out.write(__oracle_jsp_text[289]);
          out.print(strTramite1[i][1]);
          out.write(__oracle_jsp_text[290]);
          }
          out.write(__oracle_jsp_text[291]);
          
          					String strTramite2[][] = null;
          					strTramite2 =  ActualizaTramite.getComboTramiteGral();
          					for(int i=0;i<strTramite2.length;i++){					
          				
          out.write(__oracle_jsp_text[292]);
          out.print(strTramite2[i][0]);
          out.write(__oracle_jsp_text[293]);
          out.print((strTramite.equals(strTramite2[i][0])?"selected":""));
          out.write(__oracle_jsp_text[294]);
          out.print(strTramite2[i][1]);
          out.write(__oracle_jsp_text[295]);
          }
          out.write(__oracle_jsp_text[296]);
          if(strEstatus.equals("2") || strEstatus.equals("3")){
          out.write(__oracle_jsp_text[297]);
          out.print( strFechaCaducidad );
          out.write(__oracle_jsp_text[298]);
           }else{ 
          out.write(__oracle_jsp_text[299]);
          if(strTramite.length()==0 || strTramite.equals("-1")){
          out.write(__oracle_jsp_text[300]);
          out.print( strFechaCaducidad );
          out.write(__oracle_jsp_text[301]);
          }else{
          out.write(__oracle_jsp_text[302]);
          out.print( strFechaCaducidad );
          out.write(__oracle_jsp_text[303]);
          out.print( strFechaCaducidad );
          out.write(__oracle_jsp_text[304]);
          }
          out.write(__oracle_jsp_text[305]);
          }
          out.write(__oracle_jsp_text[306]);
          out.print( strFolioExterno );
          out.write(__oracle_jsp_text[307]);
          out.print( strFolioIntermedio );
          out.write(__oracle_jsp_text[308]);
          out.print( strSintesis );
          out.write(__oracle_jsp_text[309]);
          out.print( strComentarios );
          out.write(__oracle_jsp_text[310]);
          out.print( strPalabraClave );
          out.write(__oracle_jsp_text[311]);
           if(strIdAsunto != null && strIdAsunto.trim().length()>0){ 
          out.write(__oracle_jsp_text[312]);
          
          						boolean bExisteExp = false;
          						String strExpedienteArea[][] = null;
          						String strExpedienteGral[][] = null;
          						strExpedienteArea = ComboData.getExpedienteCombo(strAreaUs);
          						strExpedienteGral = ComboData.getExpedienteComboGral();
          						bExisteExp = ActualizaExpediente.getExisteExpedientesPorArea(strAreaUs);
          					
          out.write(__oracle_jsp_text[313]);
           for(int z=0;z<strExpedienteArea.length;z++){ 
          out.write(__oracle_jsp_text[314]);
          out.print(strExpedienteArea[z][0]);
          out.write(__oracle_jsp_text[315]);
          out.print((strIdExpediente.trim().equals(strExpedienteArea[z][0])?"selected":""));
          out.write(__oracle_jsp_text[316]);
          out.print(strExpedienteArea[z][1]);
          out.write(__oracle_jsp_text[317]);
           } 
          out.write(__oracle_jsp_text[318]);
           }else{ 
          out.write(__oracle_jsp_text[319]);
          
          						boolean bExisteExp = false;
          						String strExpedienteArea[][] = null;
          						String strExpedienteGral[][] = null;
          						strExpedienteArea = ComboData.getExpedienteCombo(strAreaUs);
          						strExpedienteGral = ComboData.getExpedienteComboGral();
          						bExisteExp = ActualizaExpediente.getExisteExpedientesPorArea(strAreaUs);
          					
          out.write(__oracle_jsp_text[320]);
           for(int z=0;z<strExpedienteArea.length;z++){ 
          out.write(__oracle_jsp_text[321]);
          out.print(strExpedienteArea[z][0]);
          out.write(__oracle_jsp_text[322]);
          out.print(strExpedienteArea[z][1]);
          out.write(__oracle_jsp_text[323]);
           } 
          out.write(__oracle_jsp_text[324]);
           } 
          out.write(__oracle_jsp_text[325]);
          if (strDatosAsuntoAnt.length == 0 && strDatosAsuntoLigas.length==0){
          out.write(__oracle_jsp_text[326]);
          }else{
          out.write(__oracle_jsp_text[327]);
          if(strDatosAsuntoAnt.length!=0){
          out.write(__oracle_jsp_text[328]);
          
          	String strConsulta[][];
          	for (int m = 0; m < strDatosAsuntoAnt.length ; m ++){
          		strConsulta = ActualizaBuscar.getBusquedaAsuntosAnidados(strDatosAsuntoAnt[m][0]);
          	
          out.write(__oracle_jsp_text[329]);
          if(par(m)==true){
          out.write(__oracle_jsp_text[330]);
          }else{
          out.write(__oracle_jsp_text[331]);
          }
          out.write(__oracle_jsp_text[332]);
          out.print(strDatosAsuntoAnt[m][1]);
          out.write(__oracle_jsp_text[333]);
          out.print( strConsulta[0][0] );
          out.write(__oracle_jsp_text[334]);
          out.print( Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
          out.write(__oracle_jsp_text[335]);
          out.print( strConsulta[0][1] );
          out.write(__oracle_jsp_text[336]);
          out.print(strDatosAsuntoAnt[m][1]);
          out.write(__oracle_jsp_text[337]);
          out.print(strConsulta[0][2]);
          out.write(__oracle_jsp_text[338]);
           if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_EN_RECEPCION))){ 
          out.write(__oracle_jsp_text[339]);
           }else if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_POR_TURNAR))){ 
          out.write(__oracle_jsp_text[340]);
           }else if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_TURNADO))){ 
          out.write(__oracle_jsp_text[341]);
           }else if(strConsulta[0][3].equals(String.valueOf(Estatus.ASU_TERMINADO))){ 
          out.write(__oracle_jsp_text[342]);
           }
          out.write(__oracle_jsp_text[343]);
          }
          out.write(__oracle_jsp_text[344]);
          }
          out.write(__oracle_jsp_text[345]);
          }
          out.write(__oracle_jsp_text[346]);
          out.print(strFormateada);
          out.write(__oracle_jsp_text[347]);
          for(int i=0;i<24;i++){
          out.write(__oracle_jsp_text[348]);
          
          					String a = String.valueOf(i);
          					if(a.length()==1)
          						a="0"+a;
          					if(strHoraEvento.length()==1)
          						strHoraEvento="0"+strHoraEvento;
          					
          out.write(__oracle_jsp_text[349]);
          out.print(a);
          out.write(__oracle_jsp_text[350]);
          out.print((strHoraEvento.equals(a)?"selected":""));
          out.write(__oracle_jsp_text[351]);
          out.print(a);
          out.write(__oracle_jsp_text[352]);
          }
          out.write(__oracle_jsp_text[353]);
          for(int i=0;i<60;i++){
          out.write(__oracle_jsp_text[354]);
          
          					String a = String.valueOf(i);
          					if(a.length()==1)
          						a="0"+a;
          					if(strMinEvento.length()==1)
          						strMinEvento="0"+strMinEvento;
          					
          out.write(__oracle_jsp_text[355]);
          out.print(a);
          out.write(__oracle_jsp_text[356]);
          out.print((strMinEvento.equals(a)?"selected":""));
          out.write(__oracle_jsp_text[357]);
          out.print(a);
          out.write(__oracle_jsp_text[358]);
          }
          out.write(__oracle_jsp_text[359]);
          out.print(strLugarEvento );
          out.write(__oracle_jsp_text[360]);
          {
            org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_20=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
            __jsp_taghandler_20.setParent(null);
            __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
            {
              do {
                out.write(__oracle_jsp_text[361]);
                {
                  org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_21=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
                  __jsp_taghandler_21.setParent(__jsp_taghandler_20);
                  __jsp_taghandler_21.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura2.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
                  __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[362]);
                      if(strEstatus.equals("2") || strEstatus.equals("3")){
                      out.write(__oracle_jsp_text[363]);
                      
                      				String strPrioridadArea[][] = null;
                      				String strPrioridadGral[][] = null;
                      				strPrioridadArea = ComboData.getPrioridadAreaCombo(strAreaUs);
                      				strPrioridadGral = ComboData.getPrioridadAreaComboGral();
                      			
                      out.write(__oracle_jsp_text[364]);
                       for(int x=0;x<strPrioridadArea.length;x++){ 
                      out.write(__oracle_jsp_text[365]);
                      out.print(strPrioridadArea[x][0]);
                      out.write(__oracle_jsp_text[366]);
                      out.print((strIdPrioridad.trim().equals(strPrioridadArea[x][0])?"selected":""));
                      out.write(__oracle_jsp_text[367]);
                      out.print(strPrioridadArea[x][1]);
                      out.write(__oracle_jsp_text[368]);
                       } 
                      out.write(__oracle_jsp_text[369]);
                       for(int x=0;x<strPrioridadGral.length;x++){ 
                      out.write(__oracle_jsp_text[370]);
                      out.print(strPrioridadGral[x][0]);
                      out.write(__oracle_jsp_text[371]);
                      out.print((strIdPrioridad.trim().equals(strPrioridadGral[x][0])?"selected":""));
                      out.write(__oracle_jsp_text[372]);
                      out.print(strPrioridadGral[x][1]);
                      out.write(__oracle_jsp_text[373]);
                       } 
                      out.write(__oracle_jsp_text[374]);
                      }else{
                      out.write(__oracle_jsp_text[375]);
                      
                      				String strPrioridadArea[][] = null;
                      				String strPrioridadGral[][] = null;
                      				strPrioridadArea = ComboData.getPrioridadAreaCombo(strAreaUs);
                      				strPrioridadGral = ComboData.getPrioridadAreaComboGral();
                      			
                      out.write(__oracle_jsp_text[376]);
                       for(int x=0;x<strPrioridadArea.length;x++){ 
                      out.write(__oracle_jsp_text[377]);
                      out.print(strPrioridadArea[x][0]);
                      out.write(__oracle_jsp_text[378]);
                      out.print((strIdPrioridad.trim().equals(strPrioridadArea[x][0])?"selected":""));
                      out.write(__oracle_jsp_text[379]);
                      out.print(strPrioridadArea[x][1]);
                      out.write(__oracle_jsp_text[380]);
                       } 
                      out.write(__oracle_jsp_text[381]);
                       for(int x=0;x<strPrioridadGral.length;x++){ 
                      out.write(__oracle_jsp_text[382]);
                      out.print(strPrioridadGral[x][0]);
                      out.write(__oracle_jsp_text[383]);
                      out.print((strIdPrioridad.trim().equals(strPrioridadGral[x][0])?"selected":""));
                      out.write(__oracle_jsp_text[384]);
                      out.print(strPrioridadGral[x][1]);
                      out.write(__oracle_jsp_text[385]);
                       } 
                      out.write(__oracle_jsp_text[386]);
                      }
                      out.write(__oracle_jsp_text[387]);
                      if(strEstatus.equals("2") || strEstatus.equals("3")){
                      out.write(__oracle_jsp_text[388]);
                      
                      				String strTipoAsuntoArea[][] = null;
                      				String strTipoAsuntoGral[][] = null;
                      				strTipoAsuntoArea = ComboData.getTipoAsuntoAreaCombo(strAreaUs);
                      				strTipoAsuntoGral = ComboData.getTipoAsuntoAreaComboGral();
                      			
                      out.write(__oracle_jsp_text[389]);
                       for(int c=0;c<strTipoAsuntoArea.length;c++){ 
                      out.write(__oracle_jsp_text[390]);
                      out.print(strTipoAsuntoArea[c][0]);
                      out.write(__oracle_jsp_text[391]);
                      out.print((strIdTipoAsunto.trim().equals(strTipoAsuntoArea[c][0])?"selected":""));
                      out.write(__oracle_jsp_text[392]);
                      out.print(strTipoAsuntoArea[c][1]);
                      out.write(__oracle_jsp_text[393]);
                       } 
                      out.write(__oracle_jsp_text[394]);
                       for(int c=0;c<strTipoAsuntoGral.length;c++){ 
                      out.write(__oracle_jsp_text[395]);
                      out.print(strTipoAsuntoGral[c][0]);
                      out.write(__oracle_jsp_text[396]);
                      out.print((strIdTipoAsunto.trim().equals(strTipoAsuntoGral[c][0])?"selected":""));
                      out.write(__oracle_jsp_text[397]);
                      out.print(strTipoAsuntoGral[c][1]);
                      out.write(__oracle_jsp_text[398]);
                       } 
                      out.write(__oracle_jsp_text[399]);
                      }else{
                      out.write(__oracle_jsp_text[400]);
                      
                      				String strTipoAsuntoArea[][] = null;
                      				String strTipoAsuntoGral[][] = null;
                      				strTipoAsuntoArea = ComboData.getTipoAsuntoAreaCombo(strAreaUs);
                      				strTipoAsuntoGral = ComboData.getTipoAsuntoAreaComboGral();
                      			
                      out.write(__oracle_jsp_text[401]);
                       for(int c=0;c<strTipoAsuntoArea.length;c++){ 
                      out.write(__oracle_jsp_text[402]);
                      out.print(strTipoAsuntoArea[c][0]);
                      out.write(__oracle_jsp_text[403]);
                      out.print((strIdTipoAsunto.trim().equals(strTipoAsuntoArea[c][0])?"selected":""));
                      out.write(__oracle_jsp_text[404]);
                      out.print(strTipoAsuntoArea[c][1]);
                      out.write(__oracle_jsp_text[405]);
                       } 
                      out.write(__oracle_jsp_text[406]);
                       for(int c=0;c<strTipoAsuntoGral.length;c++){ 
                      out.write(__oracle_jsp_text[407]);
                      out.print(strTipoAsuntoGral[c][0]);
                      out.write(__oracle_jsp_text[408]);
                      out.print((strIdTipoAsunto.trim().equals(strTipoAsuntoGral[c][0])?"selected":""));
                      out.write(__oracle_jsp_text[409]);
                      out.print(strTipoAsuntoGral[c][1]);
                      out.write(__oracle_jsp_text[410]);
                       } 
                      out.write(__oracle_jsp_text[411]);
                      }
                      out.write(__oracle_jsp_text[412]);
                    } while (__jsp_taghandler_21.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,2);
                }
                out.write(__oracle_jsp_text[413]);
                {
                  org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_22=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
                  __jsp_taghandler_22.setParent(__jsp_taghandler_20);
                  __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
                    do {
                      out.write(__oracle_jsp_text[414]);
                      out.print(strIdPrioridad);
                      out.write(__oracle_jsp_text[415]);
                      out.print(strIdTipoAsunto);
                      out.write(__oracle_jsp_text[416]);
                    } while (__jsp_taghandler_22.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                  }
                  if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,2);
                }
                out.write(__oracle_jsp_text[417]);
              } while (__jsp_taghandler_20.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,1);
          }
          out.write(__oracle_jsp_text[418]);
          	
          			if (strFolioGenerado.equals("folio por asignar")){
          				strFolioGenerado = strIdAsunto;
          			}
          		
          out.write(__oracle_jsp_text[419]);
           if(BUsuario.getIdUsuario().equals(strCreador1)){ 
          out.write(__oracle_jsp_text[420]);
           if(strActivarCM.equals("si")){ 
          out.write(__oracle_jsp_text[421]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[422]);
          out.print(strFolioGenerado);
          out.write(__oracle_jsp_text[423]);
           }else{ 
          out.write(__oracle_jsp_text[424]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[425]);
          out.print(strFolioGenerado);
          out.write(__oracle_jsp_text[426]);
           } 
          out.write(__oracle_jsp_text[427]);
           }else{ 
          out.write(__oracle_jsp_text[428]);
           if(strActivarCM.equals("no")){ 
          out.write(__oracle_jsp_text[429]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[430]);
          out.print(strFolioGenerado);
          out.write(__oracle_jsp_text[431]);
           }else{ 
          out.write(__oracle_jsp_text[432]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[433]);
          out.print(strFolioGenerado);
          out.write(__oracle_jsp_text[434]);
           } 
          out.write(__oracle_jsp_text[435]);
           } 
          out.write(__oracle_jsp_text[436]);
           if(carga != null && carga.equals("1")){ 
          out.write(__oracle_jsp_text[437]);
           } 
          out.write(__oracle_jsp_text[438]);
          out.print( mensaje );
          out.write(__oracle_jsp_text[439]);
          out.print( bvalida );
          out.write(__oracle_jsp_text[440]);
          out.print( bValidaEstatus );
          out.write(__oracle_jsp_text[441]);
          out.print( !bValidaFechaRec );
          out.write(__oracle_jsp_text[442]);
        }
      }
      out.write(__oracle_jsp_text[443]);

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
  private static final char __oracle_jsp_text[][]=new char[444][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<HTML> \n<HEAD>\n<TITLE>Asunto en Recepción</TITLE>\n".toCharArray();
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
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\t\t<!--\n\t\t\t\t\t\t\tlocation.assign('ImportarCM.jsp?Folio=".toCharArray();
    __oracle_jsp_text[14] = 
    "&IdAsunto=".toCharArray();
    __oracle_jsp_text[15] = 
    "&a=".toCharArray();
    __oracle_jsp_text[16] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[17] = 
    "');\n\t\t\t\t\t\t//-->\n\t\t\t\t\t\t\t</script>\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t\t\t\t\t\t<script type=\"text/javascript\">\t\n\t\t\t\t\t\t\t<!--\n\t\t\t\t\t\t\t\tlocation.assign('".toCharArray();
    __oracle_jsp_text[19] = 
    "');\n\t\t\t\t\t\t\t//-->\n\t\t\t\t\t\t\t\t</script>\n".toCharArray();
    __oracle_jsp_text[20] = 
    "\n".toCharArray();
    __oracle_jsp_text[21] = 
    "\n".toCharArray();
    __oracle_jsp_text[22] = 
    "\n".toCharArray();
    __oracle_jsp_text[23] = 
    "\n".toCharArray();
    __oracle_jsp_text[24] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/link.css\" />\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\" src=\"../js/link.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n\t\n\tvar botonBandera = true;\n\tvar hay_hija = new Boolean(false);\n\tvar hija = new Object(); \n\tvar bandera = false;\n\t\n\tfunction resetTimer(){\n\t\ttimer_reload();\n\t}\n\n\tfunction Abrir(para, cc, ipara, icc){\n\n\t\tvar isCenter ='true';\n\t\tvar features = '';\n\n\t\tif(window.screen)if(isCenter)if(isCenter==\"true\"){\n\t\t    var myLeft = (screen.width-800)/2;\n\t\t    var myTop = (screen.height-450)/2;\n\t\t    features+=(features!='')?',':'';\n\t\t    features+=',left='+myLeft+',top='+myTop; \n\t\t}\t\n\t\thija = window.open('listUserUR.jsp?para=' + para + '&cc=' + cc + '&ipara=' + ipara + '&icc= ' +icc  ,'hija',features+((features!='')?',':'')+'width=800, height=450, status=yes');\n\t\thay_hija = true; \n\t}\n\tfunction AbrirAnex(idAsunto, ids, refs){\n\n\t\tbandera = \"false\"; //document.Asunto.strBandera.value;\n\t\tvar isCenter ='true';\n\t\tvar features = '';\n\n\t\tif(bandera == \"true\"){\n\t\t\tif(confirm(\"Al Seleccionar esta opción, los cambios que no hayan sido guardados se perderan,\\n¿Deseas continuar?\")){\n\t\t\t\tif(window.screen)if(isCenter)if(isCenter==\"true\"){\n\t\t\t\t    var myLeft = (screen.width-760)/2;\n\t\t\t\t    var myTop = (screen.height-360)/2;\n\t\t\t\t    features+=(features!='')?',':'';\n\t\t\t\t    features+=',left='+myLeft+',top='+myTop; \n\t\t\t\t}\n\t\t\t\t//BloquearElementos();\n\t\t\t\thija = window.open('AnexarReferencia.jsp?strIdAsunto='+ idAsunto + '&idAsuntoAnt=' + ids + '&idAsuntoRef=' + refs + '&idArea=".toCharArray();
    __oracle_jsp_text[25] = 
    "&idUs=".toCharArray();
    __oracle_jsp_text[26] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[27] = 
    "','hija',features+((features!='')?',':'')+'width=760, height=360, status=yes');\n\t\t\t\thay_hija = true; \n\t\t\t}\n\t\t} else{\n\t\t\tif(window.screen)if(isCenter)if(isCenter==\"true\"){\n\t\t\t    var myLeft = (screen.width-760)/2;\n\t\t\t    var myTop = (screen.height-360)/2;\n\t\t\t    features+=(features!='')?',':'';\n\t\t\t    features+=',left='+myLeft+',top='+myTop; \n\t\t\t}\n\t\t\t//BloquearElementos();\n\t\t\thija = window.open('AnexarReferencia.jsp?strIdAsunto='+ idAsunto + '&idAsuntoAnt=' + ids + '&idAsuntoRef=' + refs + '&idArea=".toCharArray();
    __oracle_jsp_text[28] = 
    "&idUs=".toCharArray();
    __oracle_jsp_text[29] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[30] = 
    "','hija',features+((features!='')?',':'')+'width=760, height=360, status=yes');\n\t\t\thay_hija = true; \n\t\t}\t\n\t}\n\tfunction agregarContent(){\n\t\tdoc = document.Asunto;\n\t\tbandera = document.Asunto.strBandera.value;\n\t\tif(doc.id_asunto.value == \"\"){\n\t\t\tvalidacionesAsunto11();\n\t\t}else{\n\t\t\tif(bandera == \"true\"){\n\t\t\t\tif(confirm(\"Se detectaron cambios en el Asunto.\\nPulse Aceptar para guardar los cambios y continuar o\\npulse Cancelar para continuar sin guardar los cambios.\")){\n\t\t\t\t\tguardarAsuntoEnRecepcion('guardarInsertarArchivo');\n\t\t\t\t}else{\n\t\t\t\t\tlocation.assign('ImportarCM.jsp?Folio=".toCharArray();
    __oracle_jsp_text[31] = 
    "&IdAsunto=".toCharArray();
    __oracle_jsp_text[32] = 
    "&a=".toCharArray();
    __oracle_jsp_text[33] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[34] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[35] = 
    "');\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tlocation.assign('ImportarCM.jsp?Folio=".toCharArray();
    __oracle_jsp_text[36] = 
    "&IdAsunto=".toCharArray();
    __oracle_jsp_text[37] = 
    "&a=".toCharArray();
    __oracle_jsp_text[38] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[39] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[40] = 
    "');\n\t\t\t}\n\t\t}\n\t}\n\tfunction agregar() \n\t{\t\n\t\tlocation.assign('ImportarCM.jsp?Folio=".toCharArray();
    __oracle_jsp_text[41] = 
    "&IdAsunto=".toCharArray();
    __oracle_jsp_text[42] = 
    "&a=".toCharArray();
    __oracle_jsp_text[43] = 
    "');\n\t}\n\tfunction escaner(){\n\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\tlocation.assign('sigmaCM:%20".toCharArray();
    __oracle_jsp_text[45] = 
    "/eclient/ArchivoCM%20".toCharArray();
    __oracle_jsp_text[46] = 
    "%20escanear%20false%20".toCharArray();
    __oracle_jsp_text[47] = 
    "%20".toCharArray();
    __oracle_jsp_text[48] = 
    "%20".toCharArray();
    __oracle_jsp_text[49] = 
    "');\n\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\tlocation.assign('sigmaCM:%20".toCharArray();
    __oracle_jsp_text[51] = 
    "/ArchivoCM%20".toCharArray();
    __oracle_jsp_text[52] = 
    "%20escanear%20true%20".toCharArray();
    __oracle_jsp_text[53] = 
    "%20".toCharArray();
    __oracle_jsp_text[54] = 
    "%20".toCharArray();
    __oracle_jsp_text[55] = 
    "');\n\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t}\n\tfunction cargaFoco(){\n\t\tdoc = document.Asunto;\n\t\tif (doc.setFoco.value == 'asunto'){\n\t\t\tdoc.asunto.focus();\n\t\t}\n\t\telse{\n\t\t\tvar elemento = document.getElementsByName(doc.setFoco.value);\n\t\t\telemento[0].focus();\n\t\t}\n\t}\n\tfunction regresarURI(){\n\t\tdoc = document.Asunto;\n\t\tbandera = document.Asunto.strBandera.value;\n\n\t\tif(bandera == \"true\"){\n\t\t\tif(confirm(\"Se detectaron cambios en el Asunto.\\nPulse Aceptar para guardar los cambios y continuar o\\npulse Cancelar para continuar sin guardar los cambios.\")){\n\t\t\t\tguardarAsuntoEnRecepcion('guardarRegresarURI');\n\t\t\t}else{\n\t\t\t\tlocation.assign('".toCharArray();
    __oracle_jsp_text[57] = 
    "');\n\t\t\t}\n\t\t} else{\n\t\t\tlocation.assign('".toCharArray();
    __oracle_jsp_text[58] = 
    "');\n\t\t}\n\t}\n\n\tfunction ventanaHija(){\n\t\tif (hija!= null && hay_hija == true){ \n\t\t\ttry{\n\t\t\t\thija.focus(); \n\t\t\t}catch(err){\n\t\t\t\thay_hija = new Boolean(false);\n\t\t\t\thija = new Object(); \n\t\t\t}\n\t\t}\n\t}\n\n</SCRIPT>\n<script type=\"text/javascript\">\n\tfunction validaFechaFinesSem(campoFecha){\n\t\tvar valida = 0 \n\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\t\n\t\tif (campoFecha != null && campoFecha.value == \"".toCharArray();
    __oracle_jsp_text[60] = 
    "\") {\n\t\t\tvalida =1;\n\t\t}\n\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\n\t\tif (valida == 1){\n\t\t\talert(\"La fecha seleccionada no es laborable\");\n\t\t\tcampoFecha.value = \"\";\n\t\t\t//break;\n\t\t} \n\t}\n</script>\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0;timer_load();cargaFoco();\"\nonmouseover=\"ventanaHija();\" \nonfocus=\"ventanaHija();\"\nonMouseMove=\"limitaTextArea(document.Asunto.asuntoSintesis,'Comentario','4000');\n\t\t\tlimitaTextArea(document.Asunto.asuntoComentario,'Comentarios','4000');\n\t\t\tlimitaTextArea(document.Asunto.lugarEvento,'Lugar del Evento', '4000');\n\t\t\tvalidaFechaRec();validaFechaDoc();validaFechaCom();validaFechaEve();\n\t\t\tvalidaFechaFinesSem(document.Asunto.asuntoFechaCad);\n\t\t\tvalidaFechaFinesSem(document.Asunto.asuntoFechaDocto);\n\t\t\tvalidaFechaFinesSem(document.Asunto.asuntoFechaRecepcion);\n\t\t\tvalidaFechaFinesSem(document.Asunto.fechaEvento);\"\nonKeyPress=\"timer_reload();\" onClick=\"timer_reload();\" onunload=\"hija.close()\">\n<FORM action=\"AsuntoRecepcion.jsp\" name=\"Asunto\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
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
    "\" name=\"asuntoIdsParaE\">\n<INPUT type=\"hidden\" value=\"\" name=\"asuntoIdsCCE\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[76] = 
    "\" name=\"asuntoPara\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[77] = 
    "\" name=\"asuntoCC\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[78] = 
    "\" name=\"asuntoParaE\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[79] = 
    "\" name=\"retURI\" >\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[80] = 
    "\" name=\"horarioEntrada\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[81] = 
    "\" name=\"horarioSalida\" >\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[82] = 
    "\" name=\"idAreaUsuario\" >\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[83] = 
    "\" name=\"contador\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[84] = 
    "\" name=\"strBandera\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[85] = 
    "\" name=\"setFoco\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[86] = 
    "\" name=\"estatusN\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[87] = 
    "\" name=\"formateada\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[88] = 
    "\" name=\"accionArchivo\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[89] = 
    "\" name=\"id_tra\">\n<INPUT type=\"hidden\" value=\"\" name=\"banderaVent\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[90] = 
    "\" name=\"estValidacion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"99%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<BR/>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"863\">".toCharArray();
    __oracle_jsp_text[91] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\" face=\"Verdana\">Asunto\n\t\tEn Recepci&oacute;n</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[92] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\" face=\"Verdana\">Asunto\n\t\tPor Turnar</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[93] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\" face=\"Verdana\">Asunto\n\t\tEn Trámite</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[94] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\" face=\"Verdana\">Asunto\n\t\tTerminado</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[95] = 
    "</td>\n            </tr>\n        </table>\n    </DIV>\n<BR/>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"863\">\n<TBODY>\n\t<TR>\t\n\t\t<TD width=\"5%\">\n\t\t\t<A onclick=\"if(botonBandera){botonBandera=false; regresarURI();}\" onMouseOver=\"document.MyImage.src='../Imagenes/NavLeft2.gif';\" onMouseOut=\"document.MyImage.src='../Imagenes/NavLeft.gif';\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar / Cancelar\" name=\"MyImage\"></A>\n\t\t</TD>\n\t\t".toCharArray();
    __oracle_jsp_text[96] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[97] = 
    "\n\t\t\t\t<td width=\"5%\">\n\t\t\t\t\t<A onclick=\"if(botonBandera){botonBandera=false; guardarAsuntoEnRecepcion();}\" onMouseOver=\"document.guardarRepBtn.src='../Imagenes/SaveRecepOff.gif';\" onMouseOut=\"document.guardarRepBtn.src='../Imagenes/SaveRecepOn.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/SaveRecepOn.gif\" name=\"guardarRepBtn\" alt=\"Guardar en Recepción\"></A>\n\t\t\t\t</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[98] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[99] = 
    "\n\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[100] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[101] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[102] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[103] = 
    "\n\t\t\t\t<TD width=\"5%\">\n\t\t\t\t\t<A onclick=\"if(botonBandera){botonBandera=false; guardarAsunto();}\" onMouseOver=\"document.guardarBtn.src='../Imagenes/Save2.gif';\" onMouseOut=\"document.guardarBtn.src='../Imagenes/Save.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Save.gif\" alt=\"Guardar para Turnar\" name=\"guardarBtn\"></A>\n\t\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[105] = 
    "\n\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[106] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[107] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[108] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[109] = 
    "\n\t\t\t\t<TD width=\"5%\">\n\t\t\t\t\t<a onclick=\"if(botonBandera){botonBandera=false; agregarContent();}\" onMouseOver=\"document.Attach.src='../Imagenes/Attach2.gif';\" onMouseOut=\"document.Attach.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\" alt=\"Insertar Archivo\" name=\"Attach\"></a>\n\t\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[110] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[111] = 
    "\n\t\t\t\t<TD width=\"5%\">&nbsp;</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[112] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[113] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[114] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[115] = 
    "\n\t\t\t\t<TD width=\"5%\">\n\t\t\t\t\t<a onclick=\"if(botonBandera){botonBandera=false; AbrirAnex(".toCharArray();
    __oracle_jsp_text[116] = 
    ",'".toCharArray();
    __oracle_jsp_text[117] = 
    "','".toCharArray();
    __oracle_jsp_text[118] = 
    "');}\" onMouseOver=\"document.Refe.src='../Imagenes/asuntAntOff.gif';\" onMouseOut=\"document.Refe.src='../Imagenes/asuntAntOn.gif';\">\n\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/asuntAntOn.gif\" alt=\"Anexar Referencia\" name=\"Refe\"></a>\n\t\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[119] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[120] = 
    "\n\t\t\t\t<TD width=\"5%\">&nbsp;</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[121] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[122] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[123] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[124] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[125] = 
    "\n\t\t\t<TD width=\"5%\">\n\t\t\t\t<A onclick=\"if(botonBandera){botonBandera=false; BorrarAsunto();}\" onMouseOver=\"document.Borrar.src='../Imagenes/Borrar2a.gif';\" onMouseOut=\"document.Borrar.src='../Imagenes/Borrar.gif';\">\n\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Borrar.gif\" name=\"Borrar\" alt=\"Borrar Documento\"></A>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[126] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[127] = 
    "\n\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t".toCharArray();
    __oracle_jsp_text[128] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[129] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[130] = 
    "\n\t\t<TD width=\"40%\">&nbsp;</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n\n\n<BR>\n<DIV align=\"center\">\n<TABLE>\n<TBODY>\n\t<TR>\n\t\t<TD width=\"863\" align=\"center\">\n\t\t\t<FONT face=\"Arial\" color=\"red\" size=\"4\">".toCharArray();
    __oracle_jsp_text[131] = 
    "</FONT>\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n<BR>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos\n\t\tGenerales</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\">\n\t\t\t<DIV align=\"right\">\n\t\t\t<FONT face=\"Arial\" color=\"#00204f\" size=\"2\">**Los datos marcados con negritas son obligatorios</FONT>\n\t\t\t</DIV>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"863\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[132] = 
    "\n\t<TR valign=\"top\">\n\t\t<td width=\"183\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<TD width=\"380\">\n\t\t\t<DIV  align=\"right\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">Creado por: <I>".toCharArray();
    __oracle_jsp_text[133] = 
    " - ".toCharArray();
    __oracle_jsp_text[134] = 
    "</I></FONT>\n\t\t\t</DIV>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<td width=\"183\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<TD width=\"380\" align=\"right\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\tEstatus: <b>".toCharArray();
    __oracle_jsp_text[135] = 
    "</b>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<td width=\"183\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<TD width=\"380\" align=\"right\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\tFolio de Recepción: <b>".toCharArray();
    __oracle_jsp_text[136] = 
    "</b>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<td width=\"183\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<TD width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[137] = 
    "\n\t\n</TBODY>\n</TABLE>\n</DIV>\n<SCRIPT type=\"text/javascript\">\nif (navigator.appName!=\"Netscape\") { document.write('<DIV class=documentBody id=Body>'); }\n</SCRIPT>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos del Remitente</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"363\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Entidad:</FONT></B>\n\t\t\t".toCharArray();
    __oracle_jsp_text[138] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[139] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[140] = 
    "\n\t\t\t<INPUT name=\"botEntidad\" type=\"button\" onclick=\"document.Asunto.strBandera.value=true;AbrirF('".toCharArray();
    __oracle_jsp_text[141] = 
    "','".toCharArray();
    __oracle_jsp_text[142] = 
    "','".toCharArray();
    __oracle_jsp_text[143] = 
    "','".toCharArray();
    __oracle_jsp_text[144] = 
    "');\" class=\"s-dropdown-btn\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[145] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[146] = 
    "\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[147] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\"> \n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoEntidad\" value=\"".toCharArray();
    __oracle_jsp_text[148] = 
    "\" onclick=\"\" disabled=\"disabled\">\n\t\t\t</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[149] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\"> \n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoEntidad\" value=\"".toCharArray();
    __oracle_jsp_text[150] = 
    "\" onclick=\"\" onfocus=\"blur();\"\">\n\t\t\t</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[151] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[152] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[153] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[154] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[155] = 
    "\n\t\t</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">De:</FONT></B>\n\t\t\t".toCharArray();
    __oracle_jsp_text[156] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[157] = 
    "\n\t\t\t<INPUT name=\"botDe\" type=\"button\" onclick=\"document.Asunto.strBandera.value=true;AbrirR('FrameRemitente.jsp?id_us='+idEntidad.value+'&con='+control.value+'&ida='+id_asunto.value+'&num=1&idRemitente='+idRemitente.value)\" class=\"s-dropdown-btn\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[158] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[159] = 
    "\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[160] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoRemitente\" value=\"".toCharArray();
    __oracle_jsp_text[161] = 
    "\" disabled=\"disabled\">\n\t\t\t\t<input name=\"asuntoCargo\" value=\"".toCharArray();
    __oracle_jsp_text[162] = 
    "\" type=\"hidden\" disabled=\"disabled\">\n\t\t\t\t<input name=\"asuntoCorreo\" value=\"".toCharArray();
    __oracle_jsp_text[163] = 
    "\" type=\"hidden\" disabled=\"disabled\">\n\t\t\t</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[164] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoRemitente\" value=\"".toCharArray();
    __oracle_jsp_text[165] = 
    "\" onclick=\"\" onfocus=\"blur();\"\">\n\t\t\t\t<input name=\"asuntoCargo\" value=\"".toCharArray();
    __oracle_jsp_text[166] = 
    "\" type=\"hidden\">\n\t\t\t\t<input name=\"asuntoCorreo\" value=\"".toCharArray();
    __oracle_jsp_text[167] = 
    "\" type=\"hidden\">\n\t\t\t</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[168] = 
    "\n\t\t</TD>\n\t</TR>\n\t\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Firmante:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t<INPUT class=\"blue600a\" name=\"asuntoFirmante\" value=\"".toCharArray();
    __oracle_jsp_text[169] = 
    "\" maxlength=\"200\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\"><B>Documento de:</B></FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<font size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[170] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[171] = 
    "<input name=\"asuntoTipoFolio\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[172] = 
    "\">\n\t\t\t</font>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos de Ventanilla</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"363\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Responsable\n\t\t\tdel<BR>\n\t\t\tTurno:</FONT></B>\n\t\t\t\n\t\t\t<INPUT name=\"botVentanilla\" type=\"button\" onclick=\"document.Asunto.strBandera.value=true;AbrirV('FrameVentanilla.jsp?idArea=".toCharArray();
    __oracle_jsp_text[173] = 
    "&ida=".toCharArray();
    __oracle_jsp_text[174] = 
    "&num=1');\" class=\"s-dropdown-btn\">\n\t\t\t<!-- <INPUT type=\"button\" onclick=\"document.Asunto.strBandera.value=true;AbrirIframeRep('pop4', '".toCharArray();
    __oracle_jsp_text[175] = 
    "');\" class=\"s-dropdown-btn\"> \n\t\t\t<DIV class=\"popup\" id=\"pop4\">\n\t\t\t\t<IFRAME src=\"FrameVentanilla.jsp?idArea=".toCharArray();
    __oracle_jsp_text[176] = 
    "&num=0\" WIDTH=600 HEIGHT=300 frameborder=1></IFRAME>\n\t\t\t</DIV> -->\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t<BR><INPUT class=\"blue600a\" size=\"80\" name=\"asuntoDestinatario\" type=\"text\" value=\"".toCharArray();
    __oracle_jsp_text[177] = 
    "\" onfocus=\"blur();\">\n\t\t\t\t<input name=\"asuntoCargoDest\" value=\"".toCharArray();
    __oracle_jsp_text[178] = 
    "\" type=\"hidden\">\n\t\t\t\t<input name=\"asuntoAreaDest\" value=\"".toCharArray();
    __oracle_jsp_text[179] = 
    "\" type=\"hidden\">\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Destinatarios</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"363\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Destinatarios Internos<BR>de la SHCP\n\t\t\t:</FONT></B>\n\t\t\t".toCharArray();
    __oracle_jsp_text[180] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[181] = 
    "\n\t\t\t<INPUT type=\"button\" onclick=\"document.Asunto.strBandera.value=true;AbrirPara('".toCharArray();
    __oracle_jsp_text[182] = 
    "','".toCharArray();
    __oracle_jsp_text[183] = 
    "','".toCharArray();
    __oracle_jsp_text[184] = 
    "', '".toCharArray();
    __oracle_jsp_text[185] = 
    "', '".toCharArray();
    __oracle_jsp_text[186] = 
    "', '".toCharArray();
    __oracle_jsp_text[187] = 
    "' );\" class=\"s-dropdown-btn\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[188] = 
    "\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Para:</FONT></B>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t<SELECT name=\"listTO\" size=\"6\" class=\"blue600a\" multiple=\"multiple\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[189] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[190] = 
    "\">".toCharArray();
    __oracle_jsp_text[191] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[192] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Ccp:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t<SELECT name=\"listCC\" size=\"6\" class=\"blue600a\" multiple=\"multiple\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[193] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[194] = 
    "\">".toCharArray();
    __oracle_jsp_text[195] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[196] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Destinatarios Externos:</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[197] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[198] = 
    "\n\t\t\t<INPUT type=\"button\" onclick=\"document.Asunto.strBandera.value=true;AbrirDest('".toCharArray();
    __oracle_jsp_text[199] = 
    "', '".toCharArray();
    __oracle_jsp_text[200] = 
    "', '".toCharArray();
    __oracle_jsp_text[201] = 
    "');\" class=\"s-dropdown-btn\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[202] = 
    "\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t\n\t\t</TD>\n\t</TR> \n\t<tr valign=\"top\">\n\t\t<td width=\"183\">\n\t\t\t<img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\">\n\t\t</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Para:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t<SELECT name=\"listTOE\" size=\"6\" class=\"blue600a\" multiple=\"multiple\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[203] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[204] = 
    "\">".toCharArray();
    __oracle_jsp_text[205] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[206] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos del Asunto</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"363\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Asunto:</FONT></B>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asunto\" type=\"text\" value=\"".toCharArray();
    __oracle_jsp_text[207] = 
    "\" maxlength=\"200\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t".toCharArray();
    __oracle_jsp_text[208] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[209] = 
    "\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Tipo de Documento:</FONT></B>\n\t\t\t<br><font face=\"Arial\" size=\"1\" color=\"#004080\">(Requerido solo para turnar)</font>\n\t\t</TD>\n\t\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[210] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[211] = 
    "\n\t\t    ".toCharArray();
    __oracle_jsp_text[212] = 
    "\n\t\t\t<SELECT name=\"asuntoTipoDocto\" class=\"blue600a\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[213] = 
    "\n\t\t\t        <OPTION value=\"".toCharArray();
    __oracle_jsp_text[214] = 
    "\" ".toCharArray();
    __oracle_jsp_text[215] = 
    ">".toCharArray();
    __oracle_jsp_text[216] = 
    "</OPTION>\n\t\t\t    ".toCharArray();
    __oracle_jsp_text[217] = 
    "\n\t\t   ".toCharArray();
    __oracle_jsp_text[218] = 
    "\n\t\t      ".toCharArray();
    __oracle_jsp_text[219] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[220] = 
    "\" ".toCharArray();
    __oracle_jsp_text[221] = 
    ">".toCharArray();
    __oracle_jsp_text[222] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[223] = 
    "\n\t\t      </SELECT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[224] = 
    "\n\t\t\t<SELECT name=\"asuntoTipoDocto\" class=\"blue600a\"  onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\n\t\t\t\t<OPTION value=\"null\">--Tipo de Documentos de la Unidad--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[225] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[226] = 
    "\" ".toCharArray();
    __oracle_jsp_text[227] = 
    ">".toCharArray();
    __oracle_jsp_text[228] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[229] = 
    "\n\t\t\t\t<OPTION value=\"null\">--Tipo de Documentos Generales--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[230] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[231] = 
    "\" ".toCharArray();
    __oracle_jsp_text[232] = 
    ">".toCharArray();
    __oracle_jsp_text[233] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[234] = 
    "\n\t\t\t</SELECT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[235] = 
    "\n\t\t\t<INPUT type=\"hidden\" name=\"esRecepcion\" value=\"1\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[236] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[237] = 
    "\n\t\t\t</FONT>\n\t\t\t<INPUT type=\"hidden\" name=\"esRecepcion\" value=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[238] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[239] = 
    "\n\t\t\t<SELECT name=\"asuntoTipoDocto\" class=\"blue600a\" onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t<OPTION value=\"null\">--Tipo de Documentos de la Unidad--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[240] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[241] = 
    "\">".toCharArray();
    __oracle_jsp_text[242] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[243] = 
    "\n\t\t\t\t<OPTION value=\"null\">--Tipo de Documentos Generales--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[244] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[245] = 
    "\">".toCharArray();
    __oracle_jsp_text[246] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[247] = 
    "\n\t\t\t</SELECT>\n\t\t\t<INPUT type=\"hidden\" name=\"esRecepcion\" value=\"1\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[248] = 
    "\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[249] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[250] = 
    "\n\t\t<tr>\n\t\t<TD>\n\t\t\t<INPUT type=\"hidden\" name=\"asuntoTipoDocto\" value=\"null\">\n\t\t\t<INPUT type=\"hidden\" name=\"esRecepcion\" value=\"0\">\n\t\t</TD>\n\t</tr>\n\t".toCharArray();
    __oracle_jsp_text[251] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[252] = 
    "\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t\n\t<tr valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fecha de Recepción del documento:</FONT></B>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[253] = 
    "\n\t\t\t<INPUT class=\"blue100a\"  name=\"asuntoFechaRecepcion\" value=\"".toCharArray();
    __oracle_jsp_text[254] = 
    "\" disabled=\"disabled\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\tHora de Recepción:</FONT></B>\n\t\t\t<SELECT name=\"horaRecepcion\" class=\"blue50a\" disabled=\"disabled\">\n\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[255] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[256] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[257] = 
    "\" ".toCharArray();
    __oracle_jsp_text[258] = 
    ">".toCharArray();
    __oracle_jsp_text[259] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[260] = 
    "\n\t\t\t</SELECT>\n\t\t\t<FONT face=\"Verdana\" size=\"2\">:</FONT>\n\t\t\t<SELECT name=\"minRecepcion\" class=\"blue50a\" disabled=\"disabled\">\n\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[261] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[262] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[263] = 
    "\" ".toCharArray();
    __oracle_jsp_text[264] = 
    ">".toCharArray();
    __oracle_jsp_text[265] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[266] = 
    "\n\t\t\t</SELECT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[267] = 
    "\n\t\t\t<INPUT class=\"blue100a\"  name=\"asuntoFechaRecepcion\" value=\"".toCharArray();
    __oracle_jsp_text[268] = 
    "\" onblur=\"validaFormatoFecha();keyTra()\" onKeyUp=\"validaFechaRec();\" onKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick='document.Asunto.strBandera.value=true;showCalFechaDocRec();' name=\"cRep\"></A>\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\tHora de Recepción:</FONT></B>\n\t\t\t<SELECT name=\"horaRecepcion\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[269] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[270] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[271] = 
    "\" ".toCharArray();
    __oracle_jsp_text[272] = 
    ">".toCharArray();
    __oracle_jsp_text[273] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[274] = 
    "\n\t\t\t</SELECT>\n\t\t\t<FONT face=\"Verdana\" size=\"2\">:</FONT>\n\t\t\t<SELECT name=\"minRecepcion\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[275] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[276] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[277] = 
    "\" ".toCharArray();
    __oracle_jsp_text[278] = 
    ">".toCharArray();
    __oracle_jsp_text[279] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[280] = 
    "\n\t\t\t</SELECT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[281] = 
    "\n\t\t</TD>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fecha del documento:</font></B>\n\t\t</td>\n\t\t<td colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[282] = 
    "\n\t\t\t<INPUT class=\"blue100a\" name=\"asuntoFechaDocto\" value=\"".toCharArray();
    __oracle_jsp_text[283] = 
    "\" disabled=\"disabled\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[284] = 
    "\n\t\t\t<INPUT class=\"blue100a\" name=\"asuntoFechaDocto\" value=\"".toCharArray();
    __oracle_jsp_text[285] = 
    "\" maxlength=\"10\" onblur=\"validaFormatoFecha();\" onKeyUp=\"validaFechaDoc();\" onKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick=\"document.Asunto.strBandera.value=true;showCalFechaDoc();\" name=\"cDoc\"></A>\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[286] = 
    "\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Trámite:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<SELECT name=\"asuntoTramite\" class=\"blue600a\" onchange=\"document.Asunto.strBandera.value=true;pruebaCom(this.value)\">\n\t\t\t\t<OPTION value=\"-1\">------ Selecciona un Trámite de la Unidad Administrativa ------</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[287] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[288] = 
    "\" ".toCharArray();
    __oracle_jsp_text[289] = 
    ">".toCharArray();
    __oracle_jsp_text[290] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[291] = 
    "\n\t\t\t\t<OPTION value=\"-1\">------ Selecciona un Trámite General ------</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[292] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[293] = 
    "\" ".toCharArray();
    __oracle_jsp_text[294] = 
    ">".toCharArray();
    __oracle_jsp_text[295] = 
    "</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[296] = 
    "\n\t\t\t</SELECT>\n\t\t</TD>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t\n\t\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><B><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha compromiso:</font></B>\n\t\t</td>\n\t\t<td colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[297] = 
    "\n\t\t\t<INPUT class=\"blue100a\"  name=\"asuntoFechaCad\" value=\"".toCharArray();
    __oracle_jsp_text[298] = 
    "\" disabled=\"disabled\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[299] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[300] = 
    "\n\t\t\t\t<INPUT class=\"blue100a\"  name=\"asuntoFechaCad\" value=\"".toCharArray();
    __oracle_jsp_text[301] = 
    "\" maxlength=\"10\" onblur=\"validaFormatoFecha();\" onKeyUp=\"validaFechaCom();\" onKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t\t<INPUT type=\"text\" value=\"\" name=\"fechaOcultoCompromiso\" class=\"blue100\" disabled=\"disabled\" style=\"display:none\">\n\t\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick=\"document.Asunto.strBandera.value=true;showCalFechaCom();\" name=\"fechaCom\"></A>\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[302] = 
    "\n\t\t\t\t<INPUT class=\"blue100a\"  name=\"asuntoFechaCad\" value=\"".toCharArray();
    __oracle_jsp_text[303] = 
    "\" style=\"display:none\"  maxlength=\"10\" onblur=\"validaFormatoFecha();\" onkeyup=\"validaFechaCom();\" onKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t\t\t<INPUT type=\"text\" value=\"".toCharArray();
    __oracle_jsp_text[304] = 
    "\" name=\"fechaOcultoCompromiso\" class=\"blue100\" disabled=\"disabled\">\n\t\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick=\"document.Asunto.strBandera.value=true;showCalFechaCom();\" name=\"fechaCom\" style=\"display:none\"></A>\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[305] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[306] = 
    "\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><B><font size=\"2\" color=\"#004080\" face=\"Arial\">Identificador del docto.:</font></B>\n\t\t</td>\n\t\t<td colspan=\"3\">\n\t\t\t<INPUT class=\"blue500a\" name=\"asuntoFolioExt\" value=\"".toCharArray();
    __oracle_jsp_text[307] = 
    "\" maxlength=\"100\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Folio Intermedio:</font>\n\t\t\n\t\t<BR>\n\t\t\t<FONT color=\"#004080\">(VDG, VOM, VSP, etc.) </FONT></td>\n\t\t<td colspan=\"3\">\n\t\t\t<INPUT class=\"blue500a\" name=\"asuntoFolioInt\" value=\"".toCharArray();
    __oracle_jsp_text[308] = 
    "\" maxlength=\"100\" onkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);\">\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<B><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Descripción:</FONT></B>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<TEXTAREA name=\"asuntoSintesis\" rows=\"9\" cols=\"60\" class=\"blue600a\"\n\t\t\tonKeyDown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);limitaTextArea(document.Asunto.asuntoSintesis,'Solicitud','4000');\">".toCharArray();
    __oracle_jsp_text[309] = 
    "</TEXTAREA>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Comentarios:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<TEXTAREA name=\"asuntoComentario\" rows=\"9\" cols=\"60\" class=\"blue600a\"\n\t\t\tonKeyDown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);limitaTextArea(document.Asunto.asuntoComentario,'Comentarios','4000');\">".toCharArray();
    __oracle_jsp_text[310] = 
    "</TEXTAREA>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Palabra Clave:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"asuntoPalabraClave\" value=\"".toCharArray();
    __oracle_jsp_text[311] = 
    "\" maxlength=\"200\">\n\t\t\t</FONT>\n\t\t</TD>\n    </TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Expediente:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[312] = 
    "\n\t\t\t\t<SELECT name=\"asuntoExpediente\" class=\"blue600a\" onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[313] = 
    "\n\t\t\t\t\t<OPTION value=\"null\">--Expedientes de la Unidad--</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[314] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[315] = 
    "\" ".toCharArray();
    __oracle_jsp_text[316] = 
    ">".toCharArray();
    __oracle_jsp_text[317] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[318] = 
    "\n\t\t\t\t\t\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[319] = 
    "\n\t\t\t\t<SELECT name=\"asuntoExpediente\" class=\"blue600a\" onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[320] = 
    "\n\t\t\t\t\t<OPTION value=\"null\">--Expedientes de la Unidad--</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[321] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[322] = 
    "\">".toCharArray();
    __oracle_jsp_text[323] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[324] = 
    "\n\t\t\t\t\t\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[325] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</TBODY>\n</TABLE>\n</DIV>\n<BR>\n".toCharArray();
    __oracle_jsp_text[326] = 
    "\n".toCharArray();
    __oracle_jsp_text[327] = 
    "\n<DIV align=\"center\">\n<TABLE>\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD align=\"center\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\"><b>Relaciones Anexadas</b></FONT></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE border=\"0\">\n\t<TR bgcolor=\"#00204f\">\n\t\t<TD width=\"438\" align=\"center\"><FONT size=\"1\" color=\"#ffffff\"\n\t\t\tface=\"verdana\">Folio / Tipo de relación</FONT></TD>\n\t\t<!-- <TD align=\"center\" width=\"274\"><FONT size=\"1\" color=\"#ffffff\"\n\t\t\tface=\"verdana\">Tipo de relación</FONT></TD> -->\n\t\t<TD width=\"200\" align=\"center\"><FONT size=\"1\" color=\"#ffffff\"\n\t\t\tface=\"verdana\">Folio Documento</FONT></TD>\n\t\t<TD width=\"194\" align=\"center\"><FONT size=\"1\" color=\"#ffffff\"\n\t\t\tface=\"verdana\">Estatus</FONT></TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[328] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[329] = 
    "\n\t<TR ".toCharArray();
    __oracle_jsp_text[330] = 
    " ".toCharArray();
    __oracle_jsp_text[331] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[332] = 
    ">\n\t\t<TD width=\"438\" align=\"left\">El Asunto actual&nbsp;es&nbsp;".toCharArray();
    __oracle_jsp_text[333] = 
    "&nbsp;de&nbsp; \n\t\t\t<A href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[334] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[335] = 
    "\">\n\t\t\t<FONT size=\"1\" color=\"#004080\" face=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[336] = 
    "</FONT></A>\n\t\t</TD>\n\t\t<!-- <td width=\"274\" align=\"center\"><FONT size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">".toCharArray();
    __oracle_jsp_text[337] = 
    "</FONT></td> -->\n\t\t<td width=\"200\" align=\"center\"><FONT size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">".toCharArray();
    __oracle_jsp_text[338] = 
    "</FONT></td>\n\t\t<td width=\"194\" align=\"center\"><FONT size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[339] = 
    "\n\t\t\tAsunto En Recepci&oacute;n\n\t\t".toCharArray();
    __oracle_jsp_text[340] = 
    "\n\t\t    Asunto Por Turnar\n\t\t".toCharArray();
    __oracle_jsp_text[341] = 
    "\n\t\t    Asunto En Tr&aacute;mite\n\t\t".toCharArray();
    __oracle_jsp_text[342] = 
    "\n\t\t    Asunto Terminado\n\t\t".toCharArray();
    __oracle_jsp_text[343] = 
    "\n       </FONT></td>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[344] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[345] = 
    "\n</TABLE>\n</div>\n".toCharArray();
    __oracle_jsp_text[346] = 
    "\n<BR>\n\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TBODY>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos del Evento</font></b></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"863\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</tr>\n\t</TBODY>\n</table>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<tr valign=\"top\">\n\t\t  <td width=\"183\" height=\"22\"></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"60\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"265\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t  <td width=\"183\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fecha del evento:</FONT></td>\n\t\t\t<td colspan=\"3\">\n\t\t\t<img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\" width=\"1\" alt=\"\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t\t<INPUT class=\"blue100a\"  name=\"fechaEvento\" value=\"".toCharArray();
    __oracle_jsp_text[347] = 
    "\" maxlength=\"10\" onblur=\"validaFormatoFecha();\" onKeyUp=\"validaFechaEve();\" onKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\"> \n\t\t\t</FONT> \n\t\t\t<A><IMG height=\"20\" alt=\"\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick='document.Asunto.strBandera.value=true;show_calendar(\"forms[0].fechaEvento\");' name=\"cEvento\"></A>\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t</td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t  <td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\"></FONT></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t  <td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Hora del Evento:</FONT></td>\n\t\t<TD colspan=\"3\">\n\t\t\t\t<SELECT name=\"hora_evento\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[348] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[349] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[350] = 
    "\" ".toCharArray();
    __oracle_jsp_text[351] = 
    ">".toCharArray();
    __oracle_jsp_text[352] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[353] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">:</FONT>\n\t\t\t\t<SELECT name=\"min_evento\" class=\"blue50a\" onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[354] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[355] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[356] = 
    "\" ".toCharArray();
    __oracle_jsp_text[357] = 
    ">".toCharArray();
    __oracle_jsp_text[358] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[359] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t</TD>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t  <td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\"></FONT></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t  <td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Lugar del evento:</FONT></td>\n\t\t<td colspan=\"3\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\">\n\t\t\t<TEXTAREA name=\"lugarEvento\" rows=\"2\" cols=\"40\" class=\"blue600a\"\n\t\t\t\tonkeydown=\"document.Asunto.strBandera.value=DetectaCambios(document.Asunto.strBandera.value);limitaTextArea(document.Asunto.lugarEvento,'Lugar del Evento', '4000');\">".toCharArray();
    __oracle_jsp_text[360] = 
    "</TEXTAREA></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t  <td width=\"183\" height=\"22\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\"></FONT></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"360\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\n\n\t</TBODY>\n</table>\n</DIV>\n<!-- \n\tBloque para ver los datos de turnado, solo el usuario que tenga\n\tel rol de turnado puede ver este bloque\n-->\n".toCharArray();
    __oracle_jsp_text[361] = 
    "\n".toCharArray();
    __oracle_jsp_text[362] = 
    "\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TBODY>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\" face=\"Arial\">Datos\n\t\t\tde Turnado</font></b></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"847\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</tr>\n\t</TBODY>\n</table>\n\n\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD colspan=\"3\">\n\t\t<DIV align=\"right\">\n\t\t\t<FONT face=\"Arial\" size=\"2\">Unidad que turna:</FONT>\n\t\t</DIV>\n        </TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Prioridad:</FONT>\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t<INPUT type=\"hidden\" name=\"asuntoDiferencia\" value=\"1\">\n\t\t".toCharArray();
    __oracle_jsp_text[363] = 
    "\n\t\t<SELECT name=\"asuntoPrioridad\" class=\"blue600a\" disabled=\"disabled\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[364] = 
    "\n\t\t\t<OPTION value=\"null\">------ Prioridades de la Unidad ------</OPTION> \n\t\t\t".toCharArray();
    __oracle_jsp_text[365] = 
    "\n\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[366] = 
    "\" ".toCharArray();
    __oracle_jsp_text[367] = 
    ">".toCharArray();
    __oracle_jsp_text[368] = 
    "</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[369] = 
    "\n\t\t\t<OPTION value=\"null\">------ Prioridades Generales ------</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[370] = 
    "\n\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[371] = 
    "\" ".toCharArray();
    __oracle_jsp_text[372] = 
    ">".toCharArray();
    __oracle_jsp_text[373] = 
    "</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[374] = 
    "\n\t\t</SELECT>\n\t\t".toCharArray();
    __oracle_jsp_text[375] = 
    "\n\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t<SELECT name=\"asuntoPrioridad\" class=\"blue600a\" onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[376] = 
    "\n\t\t\t<OPTION value=\"null\">------ Prioridades de la Unidad Administrativa ------</OPTION> \n\t\t\t".toCharArray();
    __oracle_jsp_text[377] = 
    "\n\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[378] = 
    "\" ".toCharArray();
    __oracle_jsp_text[379] = 
    ">".toCharArray();
    __oracle_jsp_text[380] = 
    "</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[381] = 
    "\n\t\t\t<OPTION value=\"null\">------ Prioridades Generales ------</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[382] = 
    "\n\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[383] = 
    "\" ".toCharArray();
    __oracle_jsp_text[384] = 
    ">".toCharArray();
    __oracle_jsp_text[385] = 
    "</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[386] = 
    "\n\t\t</SELECT>\n\t\t</FONT>\n\t\t".toCharArray();
    __oracle_jsp_text[387] = 
    "\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Tipo\n\t\tde Asunto:</FONT></TD>\n\t\t<TD colspan=\"3\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[388] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t<SELECT name=\"asuntoTipoAsunto\" class=\"blue600a\" disabled=\"disabled\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[389] = 
    "\n\t\t\t<OPTION value=\"null\">------ Tipos de Asunto de la Unidad Administrativa ------</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[390] = 
    "\n\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[391] = 
    "\" ".toCharArray();
    __oracle_jsp_text[392] = 
    ">".toCharArray();
    __oracle_jsp_text[393] = 
    "</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[394] = 
    "\n\t\t\t<OPTION value=\"null\">------ Tipos de Asunto Generales ------</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[395] = 
    "\n\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[396] = 
    "\" ".toCharArray();
    __oracle_jsp_text[397] = 
    ">".toCharArray();
    __oracle_jsp_text[398] = 
    "</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[399] = 
    "\n\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[400] = 
    "\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t<SELECT name=\"asuntoTipoAsunto\" class=\"blue600a\" onchange=\"document.Asunto.strBandera.value=true;\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[401] = 
    "\n\t\t\t<OPTION value=\"null\">------ Tipos de Asunto de la Unidad ------</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[402] = 
    "\n\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[403] = 
    "\" ".toCharArray();
    __oracle_jsp_text[404] = 
    ">".toCharArray();
    __oracle_jsp_text[405] = 
    "</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[406] = 
    "\n\t\t\t<OPTION value=\"null\">------ Tipos de Asunto Generales ------</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[407] = 
    "\n\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[408] = 
    "\" ".toCharArray();
    __oracle_jsp_text[409] = 
    ">".toCharArray();
    __oracle_jsp_text[410] = 
    "</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[411] = 
    "\n\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[412] = 
    "\n\t\t\t<INPUT type=\"hidden\" name=\"asuntoDiferencia\" value=\"0\">\n\t\t</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"364\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD colspan=\"4\">&nbsp;</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[413] = 
    "\n".toCharArray();
    __oracle_jsp_text[414] = 
    "\n\t<tr>\n\t\t<TD>\n\t\t\t<INPUT type=\"hidden\" name=\"asuntoPrioridad\" value=\"".toCharArray();
    __oracle_jsp_text[415] = 
    "\">\n\t\t\t<INPUT type=\"hidden\" name=\"asuntoTipoAsunto\" value=\"".toCharArray();
    __oracle_jsp_text[416] = 
    "\">\n\t\t\t<INPUT type=\"hidden\" name=\"asuntoRutaAuto\" value=\"null\">\n\t\t\t<INPUT type=\"hidden\" name=\"asuntoDiferencia\" value=\"1\">\n\t\t</TD>\n\t</tr>\n".toCharArray();
    __oracle_jsp_text[417] = 
    "\n".toCharArray();
    __oracle_jsp_text[418] = 
    "\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"183\"><B><FONT face=\"Arial\" color=\"#004080\"\n\t\t\t\tsize=\"2\">Documentos Anexados</FONT></B></TD>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"863\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</tr>\n\t\t".toCharArray();
    __oracle_jsp_text[419] = 
    " \n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"4\">\n\t\t\t\t<div>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[420] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[421] = 
    "\n\t\t\t\t\t\t<IFRAME ID=\"frame1\" SRC=\"ImportarCMO.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[422] = 
    "&bo=true&fol=".toCharArray();
    __oracle_jsp_text[423] = 
    "&est=0\" WIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME> \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[424] = 
    "\n\t\t\t\t\t\t<IFRAME ID=\"frame1\" SRC=\"ImportarAR.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[425] = 
    "&bo=true&fol=".toCharArray();
    __oracle_jsp_text[426] = 
    "&est=0\" WIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[427] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[428] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[429] = 
    "\n\t\t\t\t\t\t<IFRAME ID=\"frame1\" SRC=\"ImportarAR.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[430] = 
    "&bo=true&fol=".toCharArray();
    __oracle_jsp_text[431] = 
    "&est=0\" WIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[432] = 
    "\n\t\t\t\t\t\t<!-- <IFRAME ID=\"frame1\" SRC=\"http://linux.meve.com:7778/content/dav/meve/SIGMA/gestion/contenedor/\" WIDTH=\"800\" HEIGHT=\"200\" frameborder=0></IFRAME>-->\n\t\t\t\t\t\t<IFRAME ID=\"frame1\" SRC=ImportarCMO.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[433] = 
    "&bo=true&fol=".toCharArray();
    __oracle_jsp_text[434] = 
    "&est=0\" WIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME> \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[435] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[436] = 
    "\n\t\t\t\t</div>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n".toCharArray();
    __oracle_jsp_text[437] = 
    " <script\n\tlanguage=JavaScript type=text/javascript>\nagregar();\n</script> ".toCharArray();
    __oracle_jsp_text[438] = 
    "\n\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n<BR>\n<SCRIPT language=JavaScript type=text/javascript>\n\nhorarioVent = horarioVentanilla();\nif(horarioVent)\n\talert(\"La hora actual está fuera del rango de atención de la Unidad Administrativa\");\n\nmensaje = \"".toCharArray();
    __oracle_jsp_text[439] = 
    "\";\n\nif (".toCharArray();
    __oracle_jsp_text[440] = 
    "){\n\talert(mensaje);\n}\n\nif (".toCharArray();
    __oracle_jsp_text[441] = 
    "){\n\talert(\"Este Asunto ha sido modificado por otro usuario y Cambió su Estatus,\\npor lo que la acción solicitada será cancelada\");\n\tlocation.assign(\"portalPrincipal.jsp\");\n}\n\nif (".toCharArray();
    __oracle_jsp_text[442] = 
    "){\n\talert(\"La Fecha-Hora de Recepcion no puede ser mayor a la actual\");\n}\n\n</SCRIPT>\n</FORM>\n</BODY>\n".toCharArray();
    __oracle_jsp_text[443] = 
    "\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
