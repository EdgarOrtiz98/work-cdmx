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
import gob.hacienda.cgtic.siga.instruccion.Rechazo;


public class _InstruccionesAtender extends com.orionserver.http.OrionHttpJspPage {


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
    PageContext pageContext = JspFactory.getDefaultFactory().getPageContext( this, request, response, null, true, 8192, true);
    // Note: this is not emitted if the session directive == false
    HttpSession session = pageContext.getSession();
    int __jsp_tag_starteval;
    ServletContext application = pageContext.getServletContext();
    JspWriter out = pageContext.getOut();
    _InstruccionesAtender page = this;
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
      out.write(__oracle_jsp_text[9]);
      out.write(__oracle_jsp_text[10]);
      out.write(__oracle_jsp_text[11]);
      out.write(__oracle_jsp_text[12]);
      out.write(__oracle_jsp_text[13]);
      
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
      		if (strDatosInstrucciones.length == 0) {
      out.write(__oracle_jsp_text[14]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoInstruccionExistente.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[15]);
      } else {
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
      		//** ó otra instrucción 
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
      
      out.write(__oracle_jsp_text[16]);
      
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
      		////System.out.println("Pueden ver la instrucción");
      	} else {
      
      out.write(__oracle_jsp_text[17]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[18]);
      
      }
      
      out.write(__oracle_jsp_text[19]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[20]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[21]);
      out.print(retURI2);
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
      out.print(strEstatus);
      out.write(__oracle_jsp_text[31]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[32]);
      out.print(strUsuarioOriginal);
      out.write(__oracle_jsp_text[33]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[34]);
      out.print( Utilerias.codificaPostHTML("InstruccionesAtender.jsp?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[35]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[36]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[37]);
      out.print(strTurnadoPor);
      out.write(__oracle_jsp_text[38]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[39]);
      out.print(strNombreInstruccion);
      out.write(__oracle_jsp_text[40]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[41]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp));
      out.write(__oracle_jsp_text[42]);
      out.print(com.meve.sigma.util.Utilerias.codificaPostHTML(retURI));
      out.write(__oracle_jsp_text[43]);
      out.write(__oracle_jsp_text[44]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[45]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[46]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[47]);
      out.print(strUsuarioOriginal);
      out.write(__oracle_jsp_text[48]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[49]);
      out.print( Utilerias.codificaPostHTML("InstruccionesAtender.jsp?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)));
      out.write(__oracle_jsp_text[50]);
      out.print(Utilerias.codificaPostHTML(retURI));
      out.write(__oracle_jsp_text[51]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[52]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[53]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[54]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[55]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)));
      out.write(__oracle_jsp_text[56]);
      out.print(Utilerias.codificaPostHTML(retURI));
      out.write(__oracle_jsp_text[57]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[58]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[59]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[60]);
      out.print(strUsuarioOriginal);
      out.write(__oracle_jsp_text[61]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[62]);
      out.print(strTurnadoPor);
      out.write(__oracle_jsp_text[63]);
      out.print(strNombreInstruccion);
      out.write(__oracle_jsp_text[64]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[65]);
      out.print(Utilerias.codificaPostHTML("InstruccionesAtender.jsp?id_ins="+strIdInstruccion));
      out.write(__oracle_jsp_text[66]);
      out.print(Utilerias.codificaPostHTML(retURI));
      out.write(__oracle_jsp_text[67]);
      out.print(strFolioRecepcion);
      out.write(__oracle_jsp_text[68]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[69]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[70]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[71]);
      out.print( Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[72]);
      out.print( serverContentManager );
      out.write(__oracle_jsp_text[73]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[74]);
      out.print(strItemType);
      out.write(__oracle_jsp_text[75]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[76]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[77]);
      out.print(strTurno);
      out.write(__oracle_jsp_text[78]);
      out.print(iTieneFechaCambio);
      out.write(__oracle_jsp_text[79]);
      out.print( strEstValidacion );
      out.write(__oracle_jsp_text[80]);
      out.print( Utilerias.codificaPostHTML("InstruccionesAtender.jsp?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
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
      out.print( strMostrarHabilitado );
      out.write(__oracle_jsp_text[95]);
      out.print( strIdInstruccion );
      out.write(__oracle_jsp_text[96]);
      out.print(strFolioTurnado);
      out.write(__oracle_jsp_text[97]);
      out.print(retURI);
      out.write(__oracle_jsp_text[98]);
      out.print(retURI2);
      out.write(__oracle_jsp_text[99]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[100]);
      
      		if (strEstatus.equals("1")) {
      		
      out.write(__oracle_jsp_text[101]);
      
      		} else if (strEstatus.equals("2")) {
      		
      out.write(__oracle_jsp_text[102]);
      
      		} else if (strEstatus.equals("3")) {
      		
      out.write(__oracle_jsp_text[103]);
      
      		} else if (strEstatus.equals("4")) {
      		
      out.write(__oracle_jsp_text[104]);
      
      		}
      		
      out.write(__oracle_jsp_text[105]);
      out.print(retURI);
      out.write(__oracle_jsp_text[106]);
      
      				if (strTipoAtencion.equals("1")) {
      				
      out.write(__oracle_jsp_text[107]);
      
      				if (strEstatus.equals("1") || strEstatus.equals("2")) {
      				
      out.write(__oracle_jsp_text[108]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_1=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_1.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[109]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_2=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[110]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[111]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[112]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_3=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_3.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[113]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_4=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_4.setParent(__jsp_taghandler_3);
              __jsp_taghandler_4.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[114]);
                  
                  						if (bTieneSubordinados) {
                  						
                  out.write(__oracle_jsp_text[115]);
                  
                  						}
                  						
                  out.write(__oracle_jsp_text[116]);
                } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[117]);
          } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[118]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_5=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_5.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[119]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_6=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_6.setParent(__jsp_taghandler_5);
              __jsp_taghandler_6.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraAr.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[120]);
                } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[121]);
          } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[122]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_7=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_7.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[123]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_8=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_8.setParent(__jsp_taghandler_7);
              __jsp_taghandler_8.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[124]);
                } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[125]);
          } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      out.write(__oracle_jsp_text[126]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_9=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_9.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[127]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_10=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_10.setParent(__jsp_taghandler_9);
              __jsp_taghandler_10.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[128]);
                  
                  									float fAvance = new Float(strAvance).floatValue();
                  									if (fAvance == 0) {
                  						
                  out.write(__oracle_jsp_text[129]);
                  
                  						}
                  						
                  out.write(__oracle_jsp_text[130]);
                } while (__jsp_taghandler_10.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,2);
            }
            out.write(__oracle_jsp_text[131]);
          } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,1);
      }
      out.write(__oracle_jsp_text[132]);
      
      						} else if (strEstatus.equals("3")
      						&& (BUsuario.getTurnado() || RechazoInstruccion
      								.myInstruccion(strIdInstruccion, BUsuario
      								.getIdUsuario()))) {
      				
      out.write(__oracle_jsp_text[133]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_11=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_11.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[134]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_12=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_12.setParent(__jsp_taghandler_11);
              __jsp_taghandler_12.setTest(true);
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[135]);
                } while (__jsp_taghandler_12.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
            }
            out.write(__oracle_jsp_text[136]);
          } while (__jsp_taghandler_11.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,1);
      }
      out.write(__oracle_jsp_text[137]);
      
      				} else {
      				
      out.write(__oracle_jsp_text[138]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_13=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_13.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[139]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_14=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_14.setParent(__jsp_taghandler_13);
              __jsp_taghandler_14.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[140]);
                } while (__jsp_taghandler_14.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,2);
            }
            out.write(__oracle_jsp_text[141]);
          } while (__jsp_taghandler_13.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,1);
      }
      out.write(__oracle_jsp_text[142]);
      
      				}
      				
      out.write(__oracle_jsp_text[143]);
      
      				} else {
      				
      out.write(__oracle_jsp_text[144]);
      
      				if (strEstatus.equals("1")) {
      				
      out.write(__oracle_jsp_text[145]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_15=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_15.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[146]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_16=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_16.setParent(__jsp_taghandler_15);
              __jsp_taghandler_16.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[147]);
                } while (__jsp_taghandler_16.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,2);
            }
            out.write(__oracle_jsp_text[148]);
          } while (__jsp_taghandler_15.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,1);
      }
      out.write(__oracle_jsp_text[149]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_17=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_17.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[150]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_18=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_18.setParent(__jsp_taghandler_17);
              __jsp_taghandler_18.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[151]);
                  
                  						if (strPadre.length() == 0) {
                  						
                  out.write(__oracle_jsp_text[152]);
                  
                  						if (bTieneSubordinados) {
                  						
                  out.write(__oracle_jsp_text[153]);
                  
                  						}
                  						
                  out.write(__oracle_jsp_text[154]);
                  
                  						}
                  						
                  out.write(__oracle_jsp_text[155]);
                } while (__jsp_taghandler_18.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,2);
            }
            out.write(__oracle_jsp_text[156]);
          } while (__jsp_taghandler_17.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,1);
      }
      out.write(__oracle_jsp_text[157]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_19=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_19.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[158]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_20=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_20.setParent(__jsp_taghandler_19);
              __jsp_taghandler_20.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[159]);
                  
                  									if (bTieneSubordinados
                  									&& !strTurno.equals(BUsuario.getIdUsuario())) {
                  						
                  out.write(__oracle_jsp_text[160]);
                  
                  						} else {
                  						
                  out.write(__oracle_jsp_text[161]);
                  
                  										if (bTieneSubordinados
                  										&& (strTurno.equals(BUsuario.getIdUsuario()) || ActualizaInstrucciones
                  										.getSupervisorEsArea(
                  										strUsuarioOriginal, BUsuario
                  												.getIdUsuario(),
                  										BUsuario.getSupervisor()))) {
                  						
                  out.write(__oracle_jsp_text[162]);
                  
                  						}
                  						
                  out.write(__oracle_jsp_text[163]);
                  
                  						}
                  						
                  out.write(__oracle_jsp_text[164]);
                } while (__jsp_taghandler_20.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,2);
            }
            out.write(__oracle_jsp_text[165]);
          } while (__jsp_taghandler_19.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,1);
      }
      out.write(__oracle_jsp_text[166]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_21=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_21.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[167]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_22=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_22.setParent(__jsp_taghandler_21);
              __jsp_taghandler_22.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[168]);
                } while (__jsp_taghandler_22.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,2);
            }
            out.write(__oracle_jsp_text[169]);
          } while (__jsp_taghandler_21.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,1);
      }
      out.write(__oracle_jsp_text[170]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_23=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_23.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[171]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_24=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_24.setParent(__jsp_taghandler_23);
              __jsp_taghandler_24.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraAr.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[172]);
                } while (__jsp_taghandler_24.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,2);
            }
            out.write(__oracle_jsp_text[173]);
          } while (__jsp_taghandler_23.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,1);
      }
      out.write(__oracle_jsp_text[174]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_25=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_25.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[175]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_26=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_26.setParent(__jsp_taghandler_25);
              __jsp_taghandler_26.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura2.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[176]);
                  
                  						if (!bTieneTramite && iTieneFechaCambio == 2) {
                  						
                  out.write(__oracle_jsp_text[177]);
                  
                  						} else if (!bTieneTramite && iTieneFechaCambio == 1) {
                  						
                  out.write(__oracle_jsp_text[178]);
                  
                  						}
                  						
                  out.write(__oracle_jsp_text[179]);
                } while (__jsp_taghandler_26.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,2);
            }
            out.write(__oracle_jsp_text[180]);
          } while (__jsp_taghandler_25.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,1);
      }
      out.write(__oracle_jsp_text[181]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_27=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_27.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[182]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_28=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_28.setParent(__jsp_taghandler_27);
              __jsp_taghandler_28.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[183]);
                } while (__jsp_taghandler_28.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,2);
            }
            out.write(__oracle_jsp_text[184]);
          } while (__jsp_taghandler_27.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,1);
      }
      out.write(__oracle_jsp_text[185]);
      
      				} else if (strEstatus.equals("2") && strDelegado.length() == 0) {
      				
      out.write(__oracle_jsp_text[186]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_29=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_29.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[187]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_30=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_30.setParent(__jsp_taghandler_29);
              __jsp_taghandler_30.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_30.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[188]);
                } while (__jsp_taghandler_30.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_30.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_30,2);
            }
            out.write(__oracle_jsp_text[189]);
          } while (__jsp_taghandler_29.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,1);
      }
      out.write(__oracle_jsp_text[190]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_31=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_31.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_31.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[191]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_32=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_32.setParent(__jsp_taghandler_31);
              __jsp_taghandler_32.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_32.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[192]);
                  
                  						if (strPadre.length() == 0) {
                  						
                  out.write(__oracle_jsp_text[193]);
                  
                  						if (bTieneSubordinados) {
                  						
                  out.write(__oracle_jsp_text[194]);
                  
                  						}
                  						
                  out.write(__oracle_jsp_text[195]);
                  
                  						}
                  						
                  out.write(__oracle_jsp_text[196]);
                } while (__jsp_taghandler_32.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_32.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_32,2);
            }
            out.write(__oracle_jsp_text[197]);
          } while (__jsp_taghandler_31.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_31.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_31,1);
      }
      out.write(__oracle_jsp_text[198]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_33=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_33.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_33.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[199]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_34=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_34.setParent(__jsp_taghandler_33);
              __jsp_taghandler_34.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_34.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[200]);
                  
                  									if (bTieneSubordinados
                  									&& !strTurno.equals(BUsuario.getIdUsuario())) {
                  						
                  out.write(__oracle_jsp_text[201]);
                  
                  						} else {
                  						
                  out.write(__oracle_jsp_text[202]);
                  
                  										if (strTurno.equals(BUsuario.getIdUsuario())
                  										|| ActualizaInstrucciones.getSupervisorEsArea(
                  										strUsuarioOriginal, BUsuario
                  										.getIdUsuario(), BUsuario
                  										.getSupervisor())) {
                  						
                  out.write(__oracle_jsp_text[203]);
                  
                  						}
                  						
                  out.write(__oracle_jsp_text[204]);
                  
                  						}
                  						
                  out.write(__oracle_jsp_text[205]);
                } while (__jsp_taghandler_34.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_34.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_34,2);
            }
            out.write(__oracle_jsp_text[206]);
          } while (__jsp_taghandler_33.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_33.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_33,1);
      }
      out.write(__oracle_jsp_text[207]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_35=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_35.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_35.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[208]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_36=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_36.setParent(__jsp_taghandler_35);
              __jsp_taghandler_36.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraAr.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_36.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[209]);
                } while (__jsp_taghandler_36.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_36.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_36,2);
            }
            out.write(__oracle_jsp_text[210]);
          } while (__jsp_taghandler_35.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_35.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_35,1);
      }
      out.write(__oracle_jsp_text[211]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_37=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_37.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_37.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[212]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_38=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_38.setParent(__jsp_taghandler_37);
              __jsp_taghandler_38.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura2.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_38.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[213]);
                  
                  						if (!bTieneTramite && iTieneFechaCambio == 2) {
                  						
                  out.write(__oracle_jsp_text[214]);
                  
                  						} else if (!bTieneTramite && iTieneFechaCambio == 1) {
                  						
                  out.write(__oracle_jsp_text[215]);
                  
                  						}
                  						
                  out.write(__oracle_jsp_text[216]);
                } while (__jsp_taghandler_38.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_38.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_38,2);
            }
            out.write(__oracle_jsp_text[217]);
          } while (__jsp_taghandler_37.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_37.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_37,1);
      }
      out.write(__oracle_jsp_text[218]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_39=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_39.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_39.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[219]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_40=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_40.setParent(__jsp_taghandler_39);
              __jsp_taghandler_40.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_40.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[220]);
                } while (__jsp_taghandler_40.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_40.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_40,2);
            }
            out.write(__oracle_jsp_text[221]);
          } while (__jsp_taghandler_39.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_39.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_39,1);
      }
      out.write(__oracle_jsp_text[222]);
      
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
      				
      out.write(__oracle_jsp_text[223]);
      
      				if (isEditableRechazo) {
      				
      out.write(__oracle_jsp_text[224]);
      
      				}
      				
      out.write(__oracle_jsp_text[225]);
      
      						} else
      						//Si la instrucción ha sido terminada, no mostrara ningun boton 
      						if (strEstatus.equals("4")) {
      				
      out.write(__oracle_jsp_text[226]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_41=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_41.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_41.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[227]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_42=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_42.setParent(__jsp_taghandler_41);
              __jsp_taghandler_42.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_42.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[228]);
                } while (__jsp_taghandler_42.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_42.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_42,2);
            }
            out.write(__oracle_jsp_text[229]);
          } while (__jsp_taghandler_41.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_41.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_41,1);
      }
      out.write(__oracle_jsp_text[230]);
      
      				} else if (strEstatus.equals("2") && strDelegado.length() > 0) {
      				
      out.write(__oracle_jsp_text[231]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_43=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_43.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_43.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[232]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_44=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_44.setParent(__jsp_taghandler_43);
              __jsp_taghandler_44.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraTur.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_44.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[233]);
                } while (__jsp_taghandler_44.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_44.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_44,2);
            }
            out.write(__oracle_jsp_text[234]);
          } while (__jsp_taghandler_43.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_43.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_43,1);
      }
      out.write(__oracle_jsp_text[235]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_45=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_45.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_45.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[236]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_46=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_46.setParent(__jsp_taghandler_45);
              __jsp_taghandler_46.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_46.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[237]);
                } while (__jsp_taghandler_46.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_46.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_46,2);
            }
            out.write(__oracle_jsp_text[238]);
          } while (__jsp_taghandler_45.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_45.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_45,1);
      }
      out.write(__oracle_jsp_text[239]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_47=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_47.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_47.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[240]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_48=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_48.setParent(__jsp_taghandler_47);
              __jsp_taghandler_48.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscrituraAr.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_48.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[241]);
                } while (__jsp_taghandler_48.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_48.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_48,2);
            }
            out.write(__oracle_jsp_text[242]);
          } while (__jsp_taghandler_47.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_47.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_47,1);
      }
      out.write(__oracle_jsp_text[243]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_49=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_49.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_49.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[244]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_50=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_50.setParent(__jsp_taghandler_49);
              __jsp_taghandler_50.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_50.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[245]);
                } while (__jsp_taghandler_50.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_50.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_50,2);
            }
            out.write(__oracle_jsp_text[246]);
          } while (__jsp_taghandler_49.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_49.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_49,1);
      }
      out.write(__oracle_jsp_text[247]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_51=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_51.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_51.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[248]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_52=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_52.setParent(__jsp_taghandler_51);
              __jsp_taghandler_52.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura2.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_52.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[249]);
                  
                  						if (!bTieneTramite) {
                  						
                  out.write(__oracle_jsp_text[250]);
                  
                  						}
                  						
                  out.write(__oracle_jsp_text[251]);
                } while (__jsp_taghandler_52.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_52.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_52,2);
            }
            out.write(__oracle_jsp_text[252]);
          } while (__jsp_taghandler_51.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_51.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_51,1);
      }
      out.write(__oracle_jsp_text[253]);
      
      					}
      					}
      				
      out.write(__oracle_jsp_text[254]);
      
      if (iTieneFechaCambio == 1) {
      
      out.write(__oracle_jsp_text[255]);
      
      }
      
      out.write(__oracle_jsp_text[256]);
      out.print(strFolioTurnado);
      out.write(__oracle_jsp_text[257]);
      
       if (strEstatus.equals("3")) {
       
      out.write(__oracle_jsp_text[258]);
      out.print(ActualizaHistorial
								.getUsuarioRechazo(strIdInstruccion)[0][0]);
      out.write(__oracle_jsp_text[259]);
      
       } else if (strUsuarioTermino.length() == 0) {
       
      out.write(__oracle_jsp_text[260]);
      out.print(strCargo);
      out.write(__oracle_jsp_text[261]);
      
       } else {
       
      out.write(__oracle_jsp_text[262]);
      out.print(strUsuarioTermino);
      out.write(__oracle_jsp_text[263]);
      
       }
       
      out.write(__oracle_jsp_text[264]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[265]);
      out.print(strTelefono);
      out.write(__oracle_jsp_text[266]);
      out.print(strCorreo);
      out.write(__oracle_jsp_text[267]);
      out.print(strAtencion);
      out.write(__oracle_jsp_text[268]);
      out.print(strAtencion);
      out.write(__oracle_jsp_text[269]);
      out.print(strVerDocto);
      out.write(__oracle_jsp_text[270]);
      out.print(strVerDocto);
      out.write(__oracle_jsp_text[271]);
      
       if (strAcceso.equals("1")) {
       
      out.write(__oracle_jsp_text[272]);
      out.print( strIdAsunto );
      out.write(__oracle_jsp_text[273]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&retURI="+com.meve.sigma.util.Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[274]);
      
       }
       
      out.write(__oracle_jsp_text[275]);
      out.print(strAsunto);
      out.write(__oracle_jsp_text[276]);
      out.print(strAsunto);
      out.write(__oracle_jsp_text[277]);
      out.print(strPaso);
      out.write(__oracle_jsp_text[278]);
      out.print(strFecGeneracion);
      out.write(__oracle_jsp_text[279]);
      out.print(strFecGeneracion);
      out.write(__oracle_jsp_text[280]);
      out.print(strFecVencimiento);
      out.write(__oracle_jsp_text[281]);
      out.print(strFecVencimiento);
      out.write(__oracle_jsp_text[282]);
      
      		if (strEstatus.equals("1")) {
      		
      out.write(__oracle_jsp_text[283]);
      
       } else if (strEstatus.equals("2")) {
       
      out.write(__oracle_jsp_text[284]);
      
       } else if (strEstatus.equals("3")) {
       
      out.write(__oracle_jsp_text[285]);
      
       } else if (strEstatus.equals("4")) {
       
      out.write(__oracle_jsp_text[286]);
      
       }
       
      out.write(__oracle_jsp_text[287]);
      
       String turnadoPor = ActualizaUsuario.NombreUsuario(strTurno);
       
      out.print(turnadoPor);
      out.write(__oracle_jsp_text[288]);
      out.print(turnadoPor);
      out.write(__oracle_jsp_text[289]);
      out.print(strFolioRecepcion);
      out.write(__oracle_jsp_text[290]);
      out.print(strFolioRecepcion);
      out.write(__oracle_jsp_text[291]);
      out.print(strFolioIntermedio);
      out.write(__oracle_jsp_text[292]);
      out.print(strFolioIntermedio);
      out.write(__oracle_jsp_text[293]);
      out.print(strNombreInstruccion);
      out.write(__oracle_jsp_text[294]);
      out.print(strNombreInstruccion);
      out.write(__oracle_jsp_text[295]);
      out.print(strSintesis);
      out.write(__oracle_jsp_text[296]);
      out.print(strSintesis);
      out.write(__oracle_jsp_text[297]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[298]);
      
      		if (bHistorial) {
      		
      out.write(__oracle_jsp_text[299]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_53=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_53.setParent(null);
        __jsp_taghandler_53.setDatos(ActualizaHistorial.getHistorialInstruccion(strIdInstruccion));
        __jsp_taghandler_53.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_53.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_53,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[300]);
            
            													if ("1"
            													.equals(campo7)) {
            			
            out.write(__oracle_jsp_text[301]);
            out.print(campo3);
            out.write(__oracle_jsp_text[302]);
            
            			String avanceUsuario = campo8;
            			
            out.write(__oracle_jsp_text[303]);
            
            												if (campo6
            												.equals("Actualización de la instruccion Padre")) {
            			
            out.write(__oracle_jsp_text[304]);
            
            			} else {
            			
            out.write(__oracle_jsp_text[305]);
            out.print((campo8
																																.indexOf(" / ") != -1) ? campo8
																														: campo8
																																+ " / "
																																+ ActualizaUsuario
																																		.NombrePuesto(campo4));
            out.write(__oracle_jsp_text[306]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[307]);
            out.print( strEstValidacion );
            out.write(__oracle_jsp_text[308]);
            out.print( Utilerias.codificaPostHTML("InstruccionesAtender.jsp?id_ins="+strIdInstruccion+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
            out.write(__oracle_jsp_text[309]);
            out.print(campo5);
            out.write(__oracle_jsp_text[310]);
            out.print(campo5);
            out.write(__oracle_jsp_text[311]);
            
            			}
            			
            out.write(__oracle_jsp_text[312]);
            
            													} else if (campo7
            													.equals("2")) {
            			
            out.write(__oracle_jsp_text[313]);
            out.print(campo3);
            out.write(__oracle_jsp_text[314]);
            out.print((campo8
																															.indexOf(" / ") != -1) ? campo8
																													: campo8
																															+ " / "
																															+ ActualizaUsuario
																																	.NombrePuesto(campo4));
            out.write(__oracle_jsp_text[315]);
            out.print(campo6);
            out.write(__oracle_jsp_text[316]);
            
            													} else if (campo7
            													.equals("3")) {
            			
            out.write(__oracle_jsp_text[317]);
            out.print(campo3);
            out.write(__oracle_jsp_text[318]);
            out.print(ActualizaInstrucciones
																															.NombreUsuarioInstruccion(strIdInstruccion));
            out.write(__oracle_jsp_text[319]);
            out.print((campo8
																															.indexOf(" / ") != -1) ? campo8
																													: campo8
																															+ " / "
																															+ ActualizaUsuario
																																	.NombrePuesto(campo4));
            out.write(__oracle_jsp_text[320]);
            out.print(campo6);
            out.write(__oracle_jsp_text[321]);
            
            													} else if (campo7
            													.equals("4")) {
            			
            out.write(__oracle_jsp_text[322]);
            out.print(campo3);
            out.write(__oracle_jsp_text[323]);
            out.print(ActualizaUsuario
																															.NombreUsuario(strDelegado));
            out.write(__oracle_jsp_text[324]);
            out.print(campo6);
            out.write(__oracle_jsp_text[325]);
            
            													} else if (campo7
            													.equals("5")) {
            			
            out.write(__oracle_jsp_text[326]);
            out.print(campo3);
            out.write(__oracle_jsp_text[327]);
            out.print((campo8
																															.indexOf(" / ") != -1) ? campo8
																													: campo8
																															+ " / "
																															+ ActualizaUsuario
																																	.NombrePuesto(campo4));
            out.write(__oracle_jsp_text[328]);
            
            													} else if (campo7
            													.equals("6")) {
            			
            out.write(__oracle_jsp_text[329]);
            out.print(campo3);
            out.write(__oracle_jsp_text[330]);
            out.print(campo8);
            out.write(__oracle_jsp_text[331]);
            out.print(com.meve.sigma.util.Utilerias
																															.cambioSaltosDeLinea(campo6));
            out.write(__oracle_jsp_text[332]);
            
            													} else if (campo7
            													.equals("7")) {
            			
            out.write(__oracle_jsp_text[333]);
            out.print(campo3);
            out.write(__oracle_jsp_text[334]);
            out.print(campo8);
            out.write(__oracle_jsp_text[335]);
            out.print(ActualizaUsuario
																															.NombrePuesto(campo4));
            out.write(__oracle_jsp_text[336]);
            out.print(campo9);
            out.write(__oracle_jsp_text[337]);
            out.print(com.meve.sigma.util.Utilerias
																															.cambioSaltosDeLinea(campo6));
            out.write(__oracle_jsp_text[338]);
            
            													} else if (campo7
            													.equals("8")) {
            			
            out.write(__oracle_jsp_text[339]);
            out.print(campo3);
            out.write(__oracle_jsp_text[340]);
            out.print(campo8);
            out.write(__oracle_jsp_text[341]);
            out.print(ActualizaUsuario
																															.NombrePuesto(campo4));
            out.write(__oracle_jsp_text[342]);
            out.print(campo9);
            out.write(__oracle_jsp_text[343]);
            out.print(com.meve.sigma.util.Utilerias
																															.cambioSaltosDeLinea(campo6));
            out.write(__oracle_jsp_text[344]);
            
            													} else if (campo7
            													.equals("9")) {
            			
            out.write(__oracle_jsp_text[345]);
            out.print(campo3);
            out.write(__oracle_jsp_text[346]);
            out.print(campo8);
            out.write(__oracle_jsp_text[347]);
            out.print(ActualizaUsuario
																															.NombrePuesto(campo4));
            out.write(__oracle_jsp_text[348]);
            out.print(campo9);
            out.write(__oracle_jsp_text[349]);
            out.print(com.meve.sigma.util.Utilerias
																															.cambioSaltosDeLinea(campo6));
            out.write(__oracle_jsp_text[350]);
            
            			}
            			
            out.write(__oracle_jsp_text[351]);
          } while (__jsp_taghandler_53.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_53.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_53,1);
      }
      out.write(__oracle_jsp_text[352]);
      
      		} else {
      		
      out.write(__oracle_jsp_text[353]);
      
      		}
      		
      out.write(__oracle_jsp_text[354]);
      
      					if (BUsuario.getIdUsuario().equals(strUsuarioOriginal)
      					|| bAsistente /*BUsuario.getIdUsuario().equals(strIdAsistente)*/) {
      		
      out.write(__oracle_jsp_text[355]);
      
       if (strActivarCM.equals("si")) {
       
      out.write(__oracle_jsp_text[356]);
      out.print( serverContentManager );
      out.write(__oracle_jsp_text[357]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[358]);
      out.print(strItemType);
      out.write(__oracle_jsp_text[359]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[360]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[361]);
      out.print(strFolioRecepcion );
      out.write(__oracle_jsp_text[362]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[363]);
      
       } else {
       
      out.write(__oracle_jsp_text[364]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[365]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[366]);
      out.print(strFolioRecepcion );
      out.write(__oracle_jsp_text[367]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[368]);
      
       }
       
      out.write(__oracle_jsp_text[369]);
      
       } else {
       
      out.write(__oracle_jsp_text[370]);
      
       if (strActivarCM.equals("no")) {
       
      out.write(__oracle_jsp_text[371]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[372]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[373]);
      out.print(strFolioRecepcion );
      out.write(__oracle_jsp_text[374]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[375]);
      
       } else {
       
      out.write(__oracle_jsp_text[376]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[377]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[378]);
      out.print(strFolioRecepcion );
      out.write(__oracle_jsp_text[379]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[380]);
      
       }
       
      out.write(__oracle_jsp_text[381]);
      
       }
       
      out.write(__oracle_jsp_text[382]);
      
      		boolean firmado = strFirmaDigital.equals("1");
      		if (firmado) {
      	
      out.write(__oracle_jsp_text[383]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[384]);
      out.print(strNombre);
      out.write(__oracle_jsp_text[385]);
      out.print(strFechaTerminacionReal);
      out.write(__oracle_jsp_text[386]);
      out.print(strFechaTerminacionReal);
      out.write(__oracle_jsp_text[387]);
      
      	}
      	
      out.write(__oracle_jsp_text[388]);
      out.print( bValidaEstatus );
      out.write(__oracle_jsp_text[389]);

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
  private static final char __oracle_jsp_text[][]=new char[390][];
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
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t  ".toCharArray();
    __oracle_jsp_text[16] = 
    "\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\n".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>instrucción</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n\n\tvar botonBandera = true;\n\t\n   \t//function imprimir(){\n    //     var url='ImprimeInstruccionTerminada.jsp?idInstruccion='+".toCharArray();
    __oracle_jsp_text[20] = 
    ";\n    //     var ventanaImpresion=window.open(url,'','',true);\n\t//}\n\tfunction imprimir(){\n\t\tvar isCenter ='true';\n\t\tvar features = '';\n\n\t\tif(window.screen)if(isCenter)if(isCenter==\"true\"){\n\t\t    var myLeft = (screen.width-800)/2;\n\t\t    var myTop = (screen.height-600)/2;\n\t\t    features+=(features!='')?',':'';\n\t\t    features+=',left='+myLeft+',top='+myTop; \n\t\t}\n\t\twindow.open(\"../ReporteInstruccion?id=\"+".toCharArray();
    __oracle_jsp_text[21] = 
    ", \"\", features+((features!='')?',':'')+'width=800, height=600 , resizable=yes');\n\t}\n\tfunction Regresar(){\n\t\tlocation.assign('".toCharArray();
    __oracle_jsp_text[22] = 
    "');\t\t \n\t}\n\tfunction Responder(){ \n\t//\tlocation.assign('Responder.jsp?id_ins=".toCharArray();
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
    "');\n\t\tlocation.assign('Responder.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[29] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[30] = 
    "&id_es=".toCharArray();
    __oracle_jsp_text[31] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[32] = 
    "&us_or=".toCharArray();
    __oracle_jsp_text[33] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[34] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[35] = 
    "');\n\t}\n\tfunction Rechazar(){\n                location.assign('Rechazar.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[36] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[37] = 
    "&tur=".toCharArray();
    __oracle_jsp_text[38] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[39] = 
    "&ins=".toCharArray();
    __oracle_jsp_text[40] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[41] = 
    "&retURI1=".toCharArray();
    __oracle_jsp_text[42] = 
    "&retURI2=".toCharArray();
    __oracle_jsp_text[43] = 
    "');\n\t}\n\tfunction Reasignar(){\n                /*KHCH Navegacion Reasignacion*/\n\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\tlocation.assign('Reasignar.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[45] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[46] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[47] = 
    "&usr_ori=".toCharArray();
    __oracle_jsp_text[48] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[49] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[50] = 
    "&retURI2=".toCharArray();
    __oracle_jsp_text[51] = 
    "');\n\t}\n\tfunction ReasignarRechazar(){\n\t\tlocation.assign('ReasignarRechazo.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[52] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[53] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[54] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[55] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[56] = 
    "&retURI2=".toCharArray();
    __oracle_jsp_text[57] = 
    "');\n\t}\n\tfunction Delegar(){\n\t\tlocation.assign('Delegar.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[58] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[59] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[60] = 
    "&usr_ori=".toCharArray();
    __oracle_jsp_text[61] = 
    "');\n\t}\n\tfunction Turnar(){\n\t\tdoc = document.atender;\n\t\tdoc.turnar.value=\"tur\";\n\t\tdoc.submit();\n\t}\n\tfunction TerminarRechazada(){\n\t\tdoc = document.atender;\n\t\tdoc.accion.value=\"terminarRechazada\";\n\t\tdoc.submit();\n\t}\n\tfunction firmar(){\n\t\tlocation.assign('http://192.168.0.144:8080/firma/explorer_applet.html');\n\t}\n   \tfunction agregarComentario(){\n            location.assign('AgregarComentarioInstruccion.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[62] = 
    "&tur=".toCharArray();
    __oracle_jsp_text[63] = 
    "&ins=".toCharArray();
    __oracle_jsp_text[64] = 
    "&a=1&estValidacion=".toCharArray();
    __oracle_jsp_text[65] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[66] = 
    "&retURI2=".toCharArray();
    __oracle_jsp_text[67] = 
    "');\n\t}\n\tfunction agregarContent() {\n\t\tlocation.assign('ImportarCM.jsp?Folio=".toCharArray();
    __oracle_jsp_text[68] = 
    "&IdAsunto=".toCharArray();
    __oracle_jsp_text[69] = 
    "&a=2&id_ins=".toCharArray();
    __oracle_jsp_text[70] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[71] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[72] = 
    "');\n\t}\n\tfunction agregar()\n\t{\n\t\tvar frameNvaRef = '".toCharArray();
    __oracle_jsp_text[73] = 
    "/eclient/SIGMA/Avance.jsp?id=".toCharArray();
    __oracle_jsp_text[74] = 
    "&bo=true&it=".toCharArray();
    __oracle_jsp_text[75] = 
    "';\n\t\tdocument.getElementById('frame1').src  = frameNvaRef;\t\t\n\t}\n\tfunction cambioFecha(){\n\t\tlocation.assign('CambioFechaInst.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[76] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[77] = 
    "&tur=".toCharArray();
    __oracle_jsp_text[78] = 
    "&i=".toCharArray();
    __oracle_jsp_text[79] = 
    "&re=1&estValidacion=".toCharArray();
    __oracle_jsp_text[80] = 
    "&retURI=".toCharArray();
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
    "\n\t}\n\t\n</SCRIPT>\n<STYLE type=text/css>\nBODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"timer_load();\"\n\tonclick=\"timer_reload();\" onkeypress=\"timer_reload();\">\n<FORM action=\"InstruccionesAtender.jsp\" name=\"atender\" method=\"post\">\n<INPUT name=\"turnar\" value=\"".toCharArray();
    __oracle_jsp_text[95] = 
    "\" type=\"hidden\">\n<INPUT name=\"id_ins\" value=\"".toCharArray();
    __oracle_jsp_text[96] = 
    "\" type=\"hidden\">\n<INPUT type=\"hidden\" name=\"folioHdn\" value=\"".toCharArray();
    __oracle_jsp_text[97] = 
    "\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"tur\"> <INPUT\n\tname=\"retURI\" value=\"".toCharArray();
    __oracle_jsp_text[98] = 
    "\" type=\"hidden\"> <INPUT\n\tname=\"retURI2\" value=\"".toCharArray();
    __oracle_jsp_text[99] = 
    "\" type=\"hidden\"> <INPUT\n\ttype=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[100] = 
    "\" name=\"estValidacion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"99%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"863\">\n\t\t".toCharArray();
    __oracle_jsp_text[101] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">instrucción Por Atender</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[102] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">instrucción En Trámite</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[103] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">instrucción Rechazada</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t<div align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\tface=\"Verdana\">instrucción Terminada</font></b></div>\n\t\t".toCharArray();
    __oracle_jsp_text[105] = 
    "\n\t\t</td>\n\t</tr>\n</table>\n</DIV>\n<br>\n<DIV align=\"center\">\n\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"863\">\n\t<tr>\n\t\t<td>\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"60\"><!-- <input type=\"button\" onclick=\"Regresar()\" value=\"Regresar\" class=\"blue100\"> -->\n\t\t\t\t<A\n\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; location.assign('".toCharArray();
    __oracle_jsp_text[106] = 
    "')}\"\n\t\t\t\t\tonMouseOver=\"document.MyImage.src='../Imagenes/NavLeft2.gif';\"\n\t\t\t\t\tonMouseOut=\"document.MyImage.src='../Imagenes/NavLeft.gif';\"> <IMG\n\t\t\t\t\tborder=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar / Cancelar\"\n\t\t\t\t\tname=\"MyImage\"></A></td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[107] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[108] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[109] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[110] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Responder();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Responder3.src='../Imagenes/Responder2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Responder3.src='../Imagenes/Responder.gif';\">\n\t\t\t\t\t\t<IMG src=\"../Imagenes/Responder.gif\" border=0 name=\"Responder3\"\n\t\t\t\t\t\t\talt=\"Responder\"> </A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[111] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[112] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[113] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[114] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[115] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Turnar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Habilitar2.src='../Imagenes/deleg_multiple2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Habilitar2.src='../Imagenes/deleg_multiple.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/deleg_multiple.gif\"\n\t\t\t\t\t\t\talt=\"Habilitar Delegado Multiple\" name=\"Habilitar2\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[116] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[117] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[118] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[119] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[120] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><a\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarContent();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Insertar.src='../Imagenes/Attach2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Insertar.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\"\n\t\t\t\t\t\t\talt=\"Insertar Archivo\" name=\"Insertar\"></a></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[121] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[122] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[123] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[124] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarComentario();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Comentario.src='../Imagenes/Comentario2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Comentario.src='../Imagenes/Comentario.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Comentario.gif\"\n\t\t\t\t\t\t\talt=\"Crear un Comentario\" name=\"Comentario\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[125] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[126] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[127] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[128] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[129] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Rechazar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Rechazar2.src='../Imagenes/Rechazar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Rechazar2.src='../Imagenes/Rechazar.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Rechazar.gif\" alt=\"Rechazar\"\n\t\t\t\t\t\t\tname=\"Rechazar2\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[130] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[131] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[132] = 
    "\n\t\t\t\t<td width=\"200\">&nbsp;</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[133] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[134] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[135] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; TerminarRechazada();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.TerRechazada.src='../Imagenes/Responder2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.TerRechazada.src='../Imagenes/Responder.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Responder.gif\"\n\t\t\t\t\t\t\talt=\"Terminar instrucción Rechazada\" name=\"TerRechazada\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[136] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[137] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[138] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[139] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[140] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A onclick=\"if(botonBandera){imprimir();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Imprimir.src='../Imagenes/Imprimir2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Imprimir.src='../Imagenes/Imprimir.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Imprimir.gif\" alt=\"Imprimir\"\n\t\t\t\t\t\t\tname=\"Imprimir\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[141] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[142] = 
    "\n\t\t\t\t<td width=\"200\">&nbsp;</td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[143] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[144] = 
    "\n\t\t\t\t<!--    Instrucciones que no son de tipo informativas, sino ejecutorias     -->\n\t\t\t\t<!-- Si la instruccion tiene como estatus \"Por atender\", se mostraran todos los botones -->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[145] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[146] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[147] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Responder();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Responder3.src='../Imagenes/Responder2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Responder3.src='../Imagenes/Responder.gif';\"><IMG\n\t\t\t\t\t\t\tsrc=\"../Imagenes/Responder.gif\" border=0 name=\"Responder3\"\n\t\t\t\t\t\t\talt=\"Responder\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[148] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[149] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[150] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[151] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[152] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[153] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Turnar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Habilitar2.src='../Imagenes/deleg_multiple2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Habilitar2.src='../Imagenes/deleg_multiple.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/deleg_multiple.gif\"\n\t\t\t\t\t\t\talt=\"Habilitar Delegado Multiple\" name=\"Habilitar2\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[154] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[155] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[156] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[157] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[158] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[159] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[160] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Reasignar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Reasignar2.src='../Imagenes/Reasignar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Reasignar2.src='../Imagenes/Reasignar.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Reasignar.gif\" alt=\"Reasignar\"\n\t\t\t\t\t\t\tname=\"Reasignar2\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[161] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[162] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Reasignar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Reasignar2.src='../Imagenes/Reasignar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Reasignar2.src='../Imagenes/Reasignar.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Reasignar.gif\" alt=\"Reasignar\"\n\t\t\t\t\t\t\tname=\"Reasignar2\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[163] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[164] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[165] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[166] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[167] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[168] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Rechazar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Rechazar2.src='../Imagenes/Rechazar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Rechazar2.src='../Imagenes/Rechazar.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Rechazar.gif\" alt=\"Rechazar\"\n\t\t\t\t\t\t\tname=\"Rechazar2\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[169] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[170] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[171] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[172] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><a\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarContent();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Insertar.src='../Imagenes/Attach2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Insertar.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\"\n\t\t\t\t\t\t\talt=\"Insertar Archivo\" name=\"Insertar\"></a></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[173] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[174] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[175] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[176] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[177] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cambioFecha();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.cambioFecha1.src='../Imagenes/CambioFecha.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CambioFecha.gif\"\n\t\t\t\t\t\t\talt=\"Solicitar Cambio de Fecha\" name=\"cambioFecha1\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[178] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cambioFecha();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.cambioFecha1.src='../Imagenes/CambioFecha.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CambioFecha.gif\"\n\t\t\t\t\t\t\talt=\"Cambiar Fecha\" name=\"cambioFecha1\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[179] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[180] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[181] = 
    "\n\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[182] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[183] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarComentario();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Comentario.src='../Imagenes/Comentario2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Comentario.src='../Imagenes/Comentario.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Comentario.gif\"\n\t\t\t\t\t\t\talt=\"Crear un Comentario\" name=\"Comentario\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[184] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[185] = 
    "\n\t\t\t\t<!-- Si la instrucción se encuestra en tramite, no mostrara el boton de rechazar -->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[186] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[187] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[188] = 
    "\n\t\t\t\t\t\t<td width=\"60\" valign=\"top\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Responder();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Responder3.src='../Imagenes/Responder2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Responder3.src='../Imagenes/Responder.gif';\"><IMG\n\t\t\t\t\t\t\tsrc=\"../Imagenes/Responder.gif\" border=0 name=\"Responder3\"\n\t\t\t\t\t\t\talt=\"Responder\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[189] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[190] = 
    "\n\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[191] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[192] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[193] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[194] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Turnar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Habilitar2.src='../Imagenes/deleg_multiple2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Habilitar2.src='../Imagenes/deleg_multiple.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/deleg_multiple.gif\"\n\t\t\t\t\t\t\talt=\"Habilitar Delegado Multiple\" name=\"Habilitar2\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[195] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[196] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[197] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[198] = 
    "\n\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[199] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[200] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[201] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Reasignar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Reasignar2.src='../Imagenes/Reasignar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Reasignar2.src='../Imagenes/Reasignar.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Reasignar.gif\" alt=\"Reasignar\"\n\t\t\t\t\t\t\tname=\"Reasignar2\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[202] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[203] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Reasignar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Reasignar2.src='../Imagenes/Reasignar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Reasignar2.src='../Imagenes/Reasignar.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Reasignar.gif\" alt=\"Reasignar\"\n\t\t\t\t\t\t\tname=\"Reasignar2\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[204] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[205] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[206] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[207] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[208] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[209] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><a\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarContent();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Insertar.src='../Imagenes/Attach2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Insertar.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\"\n\t\t\t\t\t\t\talt=\"Insertar Archivo / Escanear documento!\" name=\"Insertar\"></a>\n\t\t\t\t\t\t</td>\n\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[210] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[211] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[212] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[213] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[214] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cambioFecha();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.cambioFecha1.src='../Imagenes/CambioFecha.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CambioFecha.gif\"\n\t\t\t\t\t\t\talt=\"Solicitar Cambio de Fecha\" name=\"cambioFecha1\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[215] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cambioFecha();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.cambioFecha1.src='../Imagenes/CambioFecha.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CambioFecha.gif\"\n\t\t\t\t\t\t\talt=\"Cambiar Fecha\" name=\"cambioFecha1\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[216] = 
    "\n\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[217] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[218] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[219] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[220] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarComentario();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Comentario.src='../Imagenes/Comentario2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Comentario.src='../Imagenes/Comentario.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Comentario.gif\"\n\t\t\t\t\t\t\talt=\"Crear un Comentario\" name=\"Comentario\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[221] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[222] = 
    "\n\n\t\t\t\t<td width=\"60\">&nbsp;</td>\n\n\t\t\t\t<!-- \tSi la instruccion ha sido rechazada, solo mostrara los botones de reasignar -->\n\t\t\t\t<!--    En caso de que la instruccion tenga estatus de rechazada    -->\n\t\t\t\t<!--    En caso de que la instruccion sea visualizada por un usuario logeado com oturnador, pueda reasignar dicha instruccion   -->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[223] = 
    "\n\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[224] = 
    "\n\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Reasignar();}\"\n\t\t\t\t\tonMouseOver=\"document.Reasignar2.src='../Imagenes/Reasignar2.gif';\"\n\t\t\t\t\tonMouseOut=\"document.Reasignar2.src='../Imagenes/Reasignar.gif';\">\n\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Reasignar.gif\" alt=\"Reasignar\"\n\t\t\t\t\tname=\"Reasignar2\"></A></td>\n\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; TerminarRechazada();}\"\n\t\t\t\t\tonMouseOver=\"document.TerRechazada.src='../Imagenes/Responder2.gif';\"\n\t\t\t\t\tonMouseOut=\"document.TerRechazada.src='../Imagenes/Responder.gif';\">\n\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Responder.gif\"\n\t\t\t\t\talt=\"Terminar instrucción Rechazada\" name=\"TerRechazada\"></A></td>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[225] = 
    "\n\n\n\t\t\t\t<!-- Si la instrucción ha sido terminada, no mostrara ningun boton -->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[226] = 
    "\n\t\t\t\t<!-- td width=\"125\">&nbsp;</td-->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[227] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[228] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A onclick=\"if(botonBandera){imprimir(); }\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Imprimir.src='../Imagenes/Imprimir2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Imprimir.src='../Imagenes/Imprimir.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Imprimir.gif\" alt=\"Imprimir\"\n\t\t\t\t\t\t\tname=\"Imprimir\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[229] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[230] = 
    "\n\t\t\t\t<td width=\"300\">&nbsp;</td>\n\n\t\t\t\t<!-- Si la instrucción ha sido delegada, solo mostrara los botones de responder y delegar -->\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[231] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[232] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[233] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Responder();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Responder3.src='../Imagenes/Responder2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Responder3.src='../Imagenes/Responder.gif';\"><IMG\n\t\t\t\t\t\t\tsrc=\"../Imagenes/Responder.gif\" border=0 name=\"Responder3\"\n\t\t\t\t\t\t\talt=\"Responder\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[234] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[235] = 
    "\n\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[236] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[237] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; Delegar();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Delegar2.src='../Imagenes/Delegar2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Delegar2.src='../Imagenes/Delegar.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Delegar.gif\" alt=\"Delegar\"\n\t\t\t\t\t\t\tname=\"Delegar2\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[238] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[239] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[240] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[241] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><a\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarContent();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Insertar.src='../Imagenes/Attach2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Insertar.src='../Imagenes/Attach.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Attach.gif\"\n\t\t\t\t\t\t\talt=\"Insertar Archivo / Escanear documento!\" name=\"Insertar\"></a>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[242] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[243] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[244] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[245] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; agregarComentario();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.Comentario.src='../Imagenes/Comentario2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.Comentario.src='../Imagenes/Comentario.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Comentario.gif\"\n\t\t\t\t\t\t\talt=\"Crear un Comentario\" name=\"Comentario\"></A></td>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[246] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[247] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[248] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[249] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[250] = 
    "\n\t\t\t\t\t\t<td width=\"60\"><A\n\t\t\t\t\t\t\tonclick=\"if(botonBandera){botonBandera=false; cambioFecha();}\"\n\t\t\t\t\t\t\tonMouseOver=\"document.cambioFecha1.src='../Imagenes/CambioFecha2.gif';\"\n\t\t\t\t\t\t\tonMouseOut=\"document.cambioFecha1.src='../Imagenes/CambioFecha.gif';\">\n\t\t\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/CambioFecha.gif\"\n\t\t\t\t\t\t\talt=\"Solicitar Cambio de Fecha\" name=\"cambioFecha1\"></A></td>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[251] = 
    "\n\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[252] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[253] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[254] = 
    "\n\t\t\t\t<td width=\"300\">&nbsp;</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n</table>\n</DIV>\n<br>\n".toCharArray();
    __oracle_jsp_text[255] = 
    "\n<DIV align=\"center\">\n<TABLE>\n\t<TBODY>\n\t\t<TR>\n\t\t\t<td><FONT size=\"2\" color=\"red\">Se ha solicitado un Cambio\n\t\t\tde Fecha de Vencimiento para esta instrucción</FONT></td>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[256] = 
    "\n<div align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\t\tface=\"Arial\">Datos básicos</font></b></td>\n\t\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"396\">\n\t\t\t<DIV align=\"right\"><FONT face=\"Arial\" color=\"#00204f\" size=\"2\">Folio:<b>".toCharArray();
    __oracle_jsp_text[257] = 
    "</b></FONT>\n\t\t\t</DIV>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr valign=\"top\">\n\t\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</tr>\n\t</TBODY>\n</TABLE>\n</div>\n<DIV class=documentBody id=Body>\n<div align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Nombre:</font>\n\t\t</td>\n\t\t<td colspan=\"3\" width=\"680\"><font size=\"2\" face=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[258] = 
    " ".toCharArray();
    __oracle_jsp_text[259] = 
    " ".toCharArray();
    __oracle_jsp_text[260] = 
    " ".toCharArray();
    __oracle_jsp_text[261] = 
    " ".toCharArray();
    __oracle_jsp_text[262] = 
    " ".toCharArray();
    __oracle_jsp_text[263] = 
    " ".toCharArray();
    __oracle_jsp_text[264] = 
    " <INPUT type=\"hidden\" name=\"nombreHdn\" value=\"".toCharArray();
    __oracle_jsp_text[265] = 
    "\">\n\t\t<INPUT type=\"hidden\" name=\"telefonoHdn\" value=\"".toCharArray();
    __oracle_jsp_text[266] = 
    "\">\n\t\t<INPUT type=\"hidden\" name=\"correoHdn\" value=\"".toCharArray();
    __oracle_jsp_text[267] = 
    "\">\n\t\t</font></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Tipo\n\t\tde atención:</font></td>\n\t\t<td width=\"\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[268] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"atencionHdn\" value=\"".toCharArray();
    __oracle_jsp_text[269] = 
    "\"></font></td>\n\t\t<td width=\"\" align=\"right\"><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">Acceso al Documento Original:&nbsp;&nbsp;</font></td>\n\t\t<td><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[270] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"verDoctoHdn\" value=\"".toCharArray();
    __oracle_jsp_text[271] = 
    "\"></font> ".toCharArray();
    __oracle_jsp_text[272] = 
    " <A\n\t\t\thref=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[273] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[274] = 
    "&per=1&inst=1;\">\n\t\t<IMG SRC='../Imagenes/type_document.gif' BORDER=0> </A> ".toCharArray();
    __oracle_jsp_text[275] = 
    "\n\t\t</td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Asunto:</font>\n\t\t</td>\n\t\t<td colspan=\"3\" width=\"680\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[276] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"asuntoHdn\" value=\"".toCharArray();
    __oracle_jsp_text[277] = 
    "\"><INPUT\n\t\t\ttype=\"hidden\" name=\"pasoHdn\" value=\"".toCharArray();
    __oracle_jsp_text[278] = 
    "\"></font></td>\n\t</tr>\n\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha\n\t\tde generación:</font></td>\n\t\t<td width=\"\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[279] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"fechaGenHdn\" value=\"".toCharArray();
    __oracle_jsp_text[280] = 
    "\"></font>\n\t\t</td>\n\t\t<td align=\"right\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Fecha\n\t\tVencimiento:&nbsp;&nbsp;</font></td>\n\t\t<td><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[281] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"fechaVenHdn\" value=\"".toCharArray();
    __oracle_jsp_text[282] = 
    "\"></font>\n\t\t</td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Estatus:</font>\n\t\t</td>\n\t\t<td>\n\t\t".toCharArray();
    __oracle_jsp_text[283] = 
    " <font size=\"2\" face=\"Arial\">Notificado</font> ".toCharArray();
    __oracle_jsp_text[284] = 
    " <font size=\"2\" face=\"Arial\">En Trámite</font> ".toCharArray();
    __oracle_jsp_text[285] = 
    " <font size=\"2\" face=\"Arial\">Rechazada</font> ".toCharArray();
    __oracle_jsp_text[286] = 
    " <font size=\"2\" face=\"Arial\">Terminada</font> ".toCharArray();
    __oracle_jsp_text[287] = 
    "\n\t\t</td>\n\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\twidth=\"1\" alt=\"\"></td>\n\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\twidth=\"1\" alt=\"\"></td>\n\t</tr>\n\t<TR valign=\"top\">\n\t\t<TD width=\"183\">&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD>&nbsp;</TD>\n\t</TR>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Asignada\n\t\tpor: </font></td>\n\t\t<td width=\"\"><font size=\"2\" face=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[288] = 
    "<input type=\"hidden\" name=\"turnadoPorHdn\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[289] = 
    "\"></font></td>\n\t\t<td width=\"\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\twidth=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\"\n\t\t\theight=\"1\" alt=\"\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Folio\n\t\tde Recepción:</font> <font size=\"2\" face=\"Arial\"> </font></td>\n\t\t<td colspan=\"3\" width=\"680\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[290] = 
    "\n\t\t<input type=\"hidden\" name=\"folioRecepcionHdn\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[291] = 
    "\"></font></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\"\n\t\t\theight=\"1\" alt=\"\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><font size=\"2\" color=\"#004080\" face=\"Arial\">Folio\n\t\tIntermedio:</font></td>\n\t\t<td width=\"\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[292] = 
    "\n\n\t\t</font><input type=\"hidden\" name=\"folioIntermedioHdn\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[293] = 
    "\"></td>\n\t\t<td width=\"\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td><img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\"\n\t\t\twidth=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\"\n\t\t\theight=\"1\" alt=\"\">&nbsp;</td>\n\t</tr>\n</table>\n</div>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">INSTRUCCION</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\"\n\t\t\twidth=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><img src=\"../Imagenes/shim.gif\" width=\"1\"\n\t\t\theight=\"1\" alt=\"\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[294] = 
    "<input\n\t\t\ttype=\"hidden\" name=\"nombreInstruccionHdn\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[295] = 
    "\"></font></td>\n\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><img src=\"../Imagenes/shim.gif\" width=\"1\"\n\t\t\theight=\"1\" alt=\"\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</table>\n</DIV>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">SINTESIS</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\"\n\t\t\twidth=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><font size=\"2\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[296] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"sintesisHdn\" value=\"".toCharArray();
    __oracle_jsp_text[297] = 
    "\"></font></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><img src=\"../Imagenes/shim.gif\" width=\"1\"\n\t\t\theight=\"1\" alt=\"\">&nbsp;</td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\n</table>\n</DIV>\n\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">EXPEDIENTES</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\"\n\t\t\twidth=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\"><IFRAME\n\t\t\tsrc=\"ExpedienteInstrccion.jsp?ida=".toCharArray();
    __oracle_jsp_text[298] = 
    "&num=1%>\"\n\t\t\tWIDTH=800 HEIGHT=100 frameborder=0 id=\"Entidad\"></IFRAME></td>\n\t</tr>\n\n\n</table>\n\n</DIV>\n\n<br>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"863\">\n\t<tr valign=\"top\">\n\t\t<td width=\"183\"><b><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">Historia de la instrucción</font></b></td>\n\t\t<td width=\"233\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\"\n\t\t\twidth=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t".toCharArray();
    __oracle_jsp_text[299] = 
    "\n\t\t<td width=\"100%\" colspan=\"4\"><font size=\"1\" color=\"#004080\"\n\t\t\tface=\"Arial\">".toCharArray();
    __oracle_jsp_text[300] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[301] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[302] = 
    "----><br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[303] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[304] = 
    "\n\t\t\t\tSe ha alcanzado el estatus de &quot;Terminado&quot; en todas las Instrucciones delagadas <br>\n\t\t\t<U>Avance de: 99%</U>\n\t\t\t".toCharArray();
    __oracle_jsp_text[305] = 
    "\n\t\t\t\tAvance del Usuario: ".toCharArray();
    __oracle_jsp_text[306] = 
    "\n\t\t\t<br>\n\t\t\t<a\n\t\t\t\thref=\"Responder.jsp?id_his=".toCharArray();
    __oracle_jsp_text[307] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[308] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[309] = 
    "\">\n\t\t\t<font size=\"1\" color=\"#004080\" face=\"Arial\"> <U>Avance de:\n\t\t\t".toCharArray();
    __oracle_jsp_text[310] = 
    "%</U><input type=\"hidden\" name=\"avanceDeHdn\"\n\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[311] = 
    "\"> </font> </a>\n\t\t\t".toCharArray();
    __oracle_jsp_text[312] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[313] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[314] = 
    "----><br>\n\t\t\t\tDocumento Rechazado por: ".toCharArray();
    __oracle_jsp_text[315] = 
    "<br>\n\t\t\t\tRazón de Rechazo: ".toCharArray();
    __oracle_jsp_text[316] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[317] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[318] = 
    "----><br>\n\t\t\t\tDocumento Reasignado a: ".toCharArray();
    __oracle_jsp_text[319] = 
    "\n\t\t\t\tpor el Usuario: ".toCharArray();
    __oracle_jsp_text[320] = 
    "<br>\n\t\t\t\tComentarios Adicionales: ".toCharArray();
    __oracle_jsp_text[321] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[322] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[323] = 
    "----><br>\n\t\t\t\tDocumento Delegado a : ".toCharArray();
    __oracle_jsp_text[324] = 
    "\n\t\t\t<br>\n\t\t\t\tComentarios Adicionales: ".toCharArray();
    __oracle_jsp_text[325] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[326] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[327] = 
    "----><br>\n\t\t\t\tEl Usuario: ".toCharArray();
    __oracle_jsp_text[328] = 
    " Generó Instrucciones para Atender la solicitud\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[329] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[330] = 
    "----><br>\n\t\t\t\tPuesto: ".toCharArray();
    __oracle_jsp_text[331] = 
    "\n\t\t\t<br>\n                Comentario: ".toCharArray();
    __oracle_jsp_text[332] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[333] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[334] = 
    "----><br>\n\t\t\t\tEl Usuario ".toCharArray();
    __oracle_jsp_text[335] = 
    " / ".toCharArray();
    __oracle_jsp_text[336] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[337] = 
    "<br>\n                Comentario: ".toCharArray();
    __oracle_jsp_text[338] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[339] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[340] = 
    "----><br>\n\t\t\t\tEl Usuario ".toCharArray();
    __oracle_jsp_text[341] = 
    " / ".toCharArray();
    __oracle_jsp_text[342] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[343] = 
    "<br>\n                Comentario: ".toCharArray();
    __oracle_jsp_text[344] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[345] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[346] = 
    "----><br>\n\t\t\t\tEl Usuario ".toCharArray();
    __oracle_jsp_text[347] = 
    " / ".toCharArray();
    __oracle_jsp_text[348] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[349] = 
    "<br>\n                Comentario: ".toCharArray();
    __oracle_jsp_text[350] = 
    "\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t".toCharArray();
    __oracle_jsp_text[351] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[352] = 
    " </font></td>\n\t\t".toCharArray();
    __oracle_jsp_text[353] = 
    "\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t\t".toCharArray();
    __oracle_jsp_text[354] = 
    "\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\n\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\"><B><FONT face=\"Arial\"\n\t\t\tcolor=\"#004080\" size=\"2\">Documentos Anexados</FONT></B></td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">\n\t\t<div>\n\t\t".toCharArray();
    __oracle_jsp_text[355] = 
    " ".toCharArray();
    __oracle_jsp_text[356] = 
    " <!-- <IFRAME ID=\"frame1\" SRC=\"".toCharArray();
    __oracle_jsp_text[357] = 
    "/eclient/SIGMA/Buscar.jsp?id=".toCharArray();
    __oracle_jsp_text[358] = 
    "&bo=true&it=".toCharArray();
    __oracle_jsp_text[359] = 
    "\" WIDTH=\"800\" HEIGHT=\"200\" frameborder=0></IFRAME>  -->\n\t\t<IFRAME ID=\"frame1\"\n\t\t\tSRC=\"ImportarCMO.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[360] = 
    "&bo=true&IdInst=".toCharArray();
    __oracle_jsp_text[361] = 
    "&fol=".toCharArray();
    __oracle_jsp_text[362] = 
    "&est=".toCharArray();
    __oracle_jsp_text[363] = 
    "\"\n\t\t\tWIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME> ".toCharArray();
    __oracle_jsp_text[364] = 
    " <IFRAME ID=\"frame1\"\n\t\t\tSRC=\"ImportarAR.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[365] = 
    "&bo=true&IdInst=".toCharArray();
    __oracle_jsp_text[366] = 
    "&fol=".toCharArray();
    __oracle_jsp_text[367] = 
    "&est=".toCharArray();
    __oracle_jsp_text[368] = 
    "\"\n\t\t\tWIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME> ".toCharArray();
    __oracle_jsp_text[369] = 
    " ".toCharArray();
    __oracle_jsp_text[370] = 
    " ".toCharArray();
    __oracle_jsp_text[371] = 
    " <IFRAME ID=\"frame1\"\n\t\t\tSRC=\"ImportarAR.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[372] = 
    "&bo=false&IdInst=".toCharArray();
    __oracle_jsp_text[373] = 
    "&fol=".toCharArray();
    __oracle_jsp_text[374] = 
    "&est=".toCharArray();
    __oracle_jsp_text[375] = 
    "\"\n\t\t\tWIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME> ".toCharArray();
    __oracle_jsp_text[376] = 
    " <IFRAME ID=\"frame1\"\n\t\t\tSRC=\"ImportarCMO.jsp?IdAsunto=".toCharArray();
    __oracle_jsp_text[377] = 
    "&bo=false&IdInst=".toCharArray();
    __oracle_jsp_text[378] = 
    "&fol=".toCharArray();
    __oracle_jsp_text[379] = 
    "&est=".toCharArray();
    __oracle_jsp_text[380] = 
    "\"\n\t\t\tWIDTH=\"800\" HEIGHT=\"250\" frameborder=0></IFRAME> ".toCharArray();
    __oracle_jsp_text[381] = 
    " ".toCharArray();
    __oracle_jsp_text[382] = 
    "\n\t\t</div>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" colspan=\"4\">&nbsp;</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\n\t".toCharArray();
    __oracle_jsp_text[383] = 
    "\n\n\t<tr valign=\"top\">\n\t\t<td width=\"64%\" colspan=\"2\"><b><font size=\"2\" color=\"#004080\"\n\t\t\tface=\"Arial\">Firmado<INPUT type=\"hidden\" name=\"firmadoHdn\"\n\t\t\tvalue=\"true\"></font></b>\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t<td width=\"21%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"14%\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"100%\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td align=\"center\"><b>Usuario</b></td>\n\t\t<td align=\"center\"><b>Fecha</b></td>\n\t\t<TD align=\"center\"></TD>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td align=\"center\"></td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td align=\"center\">".toCharArray();
    __oracle_jsp_text[384] = 
    "<INPUT type=\"hidden\"\n\t\t\tname=\"nombreFirmanteHdn\" value=\"".toCharArray();
    __oracle_jsp_text[385] = 
    "\"></td>\n\t\t<td align=\"center\">".toCharArray();
    __oracle_jsp_text[386] = 
    "<INPUT\n\t\t\ttype=\"hidden\" name=\"fechaTerminacionRealHdn\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[387] = 
    "\"></td>\n\t\t<td align=\"center\"><IMG src=\"../Imagenes/0.jpg\" alt=\"firmado\"\n\t\t\twidth=\"30\" height=\"30\"></td>\n\t</tr>\n\t".toCharArray();
    __oracle_jsp_text[388] = 
    "\n</table>\n<br>\n</DIV>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n<script type=\"text/javascript\">\n<!--\nif (".toCharArray();
    __oracle_jsp_text[389] = 
    "){\n\talert(\"Esta instrucción ha sido modificada por otro usuario y Cambió su Estatus,\\npor lo que la acción solicitada será cancelada\");\n\tlocation.assign(\"portalPrincipal.jsp\");\n}\n-->\n</script></FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
