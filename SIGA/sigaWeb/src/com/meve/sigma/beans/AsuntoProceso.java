/*
 * Creado el 22/08/2006
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.beans;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.meve.sigma.actualiza.ActualizaArea;
import com.meve.sigma.actualiza.ActualizaAsunto;
import com.meve.sigma.actualiza.ActualizaBitacora;
import com.meve.sigma.actualiza.ActualizaFolio;
import com.meve.sigma.actualiza.ActualizaInstrucciones;
import com.meve.sigma.actualiza.ActualizaTipo_Doc;
import com.meve.sigma.actualiza.ActualizaTramite;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.servlet.FolderAsunto;
import com.meve.sigma.util.GeneracionFolio;
import com.meve.sigma.util.SenderMail;
import com.meve.sigma.util.Utilerias;

/**
 * ActualizaArea es una clase que ejecuta Querys de Consulta y Actualización de
 * registros de la Tabla de área
 * 
 * @author Meve Soluciones SA de CV
 */
public class AsuntoProceso {

	String strUriContent;
	String strUserContet;
	String strPassContent;
	String strPathContent;

	// String strVariable;

	public AsuntoProceso() {
	}

	public AsuntoProceso(String contentUri, String userContent,
			String passContent, String pathContent) {

		this.strUriContent = contentUri;
		this.strUserContet = userContent;
		this.strPassContent = passContent;
		this.strPathContent = pathContent;
	}

	/**
	 * Proceso del asunto, ya sea el guardado, Actualización en diferentes
	 * estatus
	 * 
	 * @param request
	 *            Request del form
	 * @param BUsuario
	 *            Bean del usuario
	 * @param Smail
	 *            Servidor mail
	 * @param PMail
	 *            Puerto de salida del mail
	 * @param SN
	 *            Nombre del servidor
	 * @param CM
	 *            Content managent
	 * @param ActivarCM
	 *            Activar CM
	 * @param Item
	 *            Item
	 * @param Server
	 *            Servidor
	 * @param strConfigFolio
	 *            Configuración folio
	 * @param strRutaBase1
	 *            Contexto de la aplicación
	 * @param strAccion1
	 *            acción del asunto
	 * @param asunto
	 *            Bean del asunto
	 * @return
	 */
	public synchronized String procesarAsunto(HttpServletRequest request,
			UsuarioBean BUsuario, String Smail, String PMail, String SN,
			String CM, String ActivarCM, String Item, String Server,
			String strConfigFolio, String strRutaBase1, String strAccion1,
			Asunto asunto) {

		// Asunto asunto = new Asunto();
		String strEsDuplicado = "";

		String strAreaUs = BUsuario.getIdArea();
		String strIdUsrCaptura = BUsuario.getIdUsuario();
		String strAccion = strAccion1;
		// ** Datos de Configuracion
		String server = Server;
		String strConfFolio = strConfigFolio;
		String strRutaBase = strRutaBase1;
		String serverMail = Smail;
		String portServer = PMail;
		String serverName = SN;
		// ** Fin Datos de Configuracion
		String URL1 = asunto.getUrl();
		String SendRedirection = "";
		// System.out.println(strAccion);
		// ** Guarda un asunto con un estatus 1
		if (asunto.getId_asunto() == null && strAccion.equals("guardar")) {
			String strIdAsuntoUltimo = "";

			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"dd/MM/yyyy");
			java.util.Date f = new java.util.Date();
			String strFechaCreacion = sdf.format(f);

			String idEntidad = asunto.getIdEntidad();
			String idRemitente = asunto.getIdRemitente();
			boolean bExisteFolio = false;
			bExisteFolio = ActualizaAsunto
					.getExisteFolioExterno(asunto.getAsuntoFolioExt(), asunto
							.getAsuntoFechaDocto(), asunto.getControl(),
							idEntidad, idRemitente, BUsuario.getIdArea());
			if (!bExisteFolio) {
				// //System.err.println("****** Guarda Asunto A Turnar
				// *******");
				strIdAsuntoUltimo = guardarAsunto(idEntidad, idRemitente,
						asunto.getAsuntoFirmante(), asunto.getAsunto(), asunto
								.getAsuntoExpediente(), asunto
								.getAsuntoTipoDocto(),asunto
								.getAsuntoFechaRecepcion(), asunto
								.getAsuntoFechaDocto(), asunto
								.getAsuntoFechaCad(), asunto
								.getAsuntoFolioExt(), asunto
								.getAsuntoFolioInt(), asunto
								.getAsuntoSintesis(), asunto
								.getAsuntoComentario(), asunto
								.getAsuntoPalabraClave(), asunto
								.getAsuntoAnterior(), asunto
								.getAsuntoPrioridad(), asunto
								.getAsuntoTipoAsunto(), asunto
								.getIdDestinatario(), 
						asunto.getAsuntoDestinatario(), asunto.getMailDest(),
						asunto.getAsuntoRemitente(), asunto.getAsuntoCorreo(),
						strAreaUs, strIdUsrCaptura, asunto.getControl(),
						BUsuario.getNuevoAsunto(), serverMail, portServer,
						serverName, strRutaBase, strConfFolio, "1", asunto
								.getAsuntoPara(), asunto.getAsuntoCC(), asunto
								.getAsuntoIdsPara(), asunto.getAsuntoIdsCC(),
						asunto.getlugarEvento(), asunto.getHora_evento(),
						asunto.getFechaEvento(), asunto.getMin_evento(), 1,
						asunto.getAsuntoParaE(), asunto.getAsuntoIdsParaE(),
						asunto.getAsuntoTramite(), asunto.getAsuntoTipoFolio(),
						0,request);

				SendRedirection = "AsuntoTurnado.jsp?id_asunto="
						+ strIdAsuntoUltimo;
			} else {
				SendRedirection = "1";
			}
			// SendRedirection = "portalPrincipal.jsp";

		}// ** Guarda un asunto con estatus cero
		else if (asunto.getId_asunto() == null
				&& strAccion.equals("guardarRep")) {

			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"dd/MM/yyyy");
			java.util.Date f = new java.util.Date();
			String strFechaCreacion = sdf.format(f);

			String idEntidad = asunto.getIdEntidad();
			String idRemitente = asunto.getIdRemitente();
			// //System.err.println("****** Guarda Asunto A Recepción *******");
			boolean bExisteFolio = false;
			if (asunto.getAsuntoFolioExt() == null) {
				bExisteFolio = false;
			} else {
				bExisteFolio = ActualizaAsunto.getExisteFolioExterno(asunto
						.getAsuntoFolioExt(), asunto.getAsuntoFechaDocto(),
						asunto.getControl(), idEntidad, idRemitente, BUsuario
								.getIdArea());
			}
			if (!bExisteFolio) {
				guardarAsunto(idEntidad, idRemitente, asunto
						.getAsuntoFirmante(), asunto.getAsunto(), asunto
						.getAsuntoExpediente(), asunto.getAsuntoTipoDocto(),
				/* asunto.getAsuntoCategoriaDocto(), */asunto
						.getAsuntoFechaRecepcion(), asunto
						.getAsuntoFechaDocto(), asunto.getAsuntoFechaCad(),
						asunto.getAsuntoFolioExt(), asunto.getAsuntoFolioInt(),
						asunto.getAsuntoSintesis(), asunto
								.getAsuntoComentario(), asunto
								.getAsuntoPalabraClave(), asunto
								.getAsuntoAnterior(), asunto
								.getAsuntoPrioridad(), asunto
								.getAsuntoTipoAsunto(), asunto
								.getIdDestinatario(), /* asunto.getAsuntoRutaAuto(), */
						asunto.getAsuntoDestinatario(), asunto.getMailDest(),
						asunto.getAsuntoRemitente(), asunto.getAsuntoCorreo(),
						strAreaUs, strIdUsrCaptura, asunto.getControl(),
						BUsuario.getNuevoAsunto(), serverMail, portServer,
						serverName, strRutaBase, strConfFolio, "0", asunto
								.getAsuntoPara(), asunto.getAsuntoCC(), asunto
								.getAsuntoIdsPara(), asunto.getAsuntoIdsCC(),
						asunto.getlugarEvento(), asunto.getHora_evento(),
						asunto.getFechaEvento(), asunto.getMin_evento(), 0,
						asunto.getAsuntoParaE(), asunto.getAsuntoIdsParaE(),
						asunto.getAsuntoTramite(), asunto.getAsuntoTipoFolio(),
						1,request);

				SendRedirection = "PortalBorrador.jsp";
			} else {
				SendRedirection = "1";
			}

		}
		// ** Guarda el asunto al momento de crear la ruta automatica, es
		// estatus es 1
		else if (asunto.getId_asunto() == null && strAccion.equals("guardar1")) {

			boolean bExisteFolio = false;
			bExisteFolio = ActualizaAsunto.getExisteFolioExterno(asunto
					.getAsuntoFolioExt(), asunto.getAsuntoFechaDocto(), asunto
					.getControl(), asunto.getIdEntidad(), asunto
					.getIdRemitente(), BUsuario.getIdArea());
			if (!bExisteFolio) {
				// //System.err.println("Guarda para cargar el applet");
				String idAsunto1 = guardarAsunto(asunto.getIdEntidad(), asunto
						.getIdRemitente(), asunto.getAsuntoFirmante(), asunto
						.getAsunto(), asunto.getAsuntoExpediente(), asunto
						.getAsuntoTipoDocto(),
				/* asunto.getAsuntoCategoriaDocto(), */asunto
						.getAsuntoFechaRecepcion(), asunto
						.getAsuntoFechaDocto(), asunto.getAsuntoFechaCad(),
						asunto.getAsuntoFolioExt(), asunto.getAsuntoFolioInt(),
						asunto.getAsuntoSintesis(), asunto
								.getAsuntoComentario(), asunto
								.getAsuntoPalabraClave(), asunto
								.getAsuntoAnterior(), asunto
								.getAsuntoPrioridad(), asunto
								.getAsuntoTipoAsunto(), asunto
								.getIdDestinatario(), /* asunto.getAsuntoRutaAuto(), */
						asunto.getAsuntoDestinatario(), asunto.getMailDest(),
						asunto.getAsuntoRemitente(), asunto.getAsuntoCorreo(),
						strAreaUs, strIdUsrCaptura, asunto.getControl(),
						BUsuario.getNuevoAsunto(), serverMail, portServer,
						serverName, strRutaBase, strConfFolio, "1", asunto
								.getAsuntoPara(), asunto.getAsuntoCC(), asunto
								.getAsuntoIdsPara(), asunto.getAsuntoIdsCC(),
						asunto.getlugarEvento(), asunto.getHora_evento(),
						asunto.getFechaEvento(), asunto.getMin_evento(), 1,
						asunto.getAsuntoParaE(), asunto.getAsuntoIdsParaE(),
						asunto.getAsuntoTramite(), asunto.getAsuntoTipoFolio(),
						0,request);

				// String idAsunto = ActualizaAsunto.getUltimoIdAsunto();
				String url = request.getRequestURI();
				// //System.out.println("IdAsunto="+idAsunto1);
				// String strRutaBase =
				// (application.getInitParameter("RutaBase")==null)?"":application.getInitParameter("RutaBase");
				String URL = server + strRutaBase
						+ "/jsp/AsuntoTurnado.jsp?id_asunto=" + idAsunto1;
				// //System.err.println("Url1="+URL);
				SendRedirection = "VisualizaInstrucciones.jsp?idAsunto="
						+ idAsunto1 + "&Url=" + URL;
			} else {
				SendRedirection = "1";
			}

		}
		// ** guarda para el archivado, es estatus es 1
		else if (asunto.getId_asunto() == null && strAccion.equals("guardar2")) {

			boolean bExisteFolio = false;
			bExisteFolio = ActualizaAsunto.getExisteFolioExterno(asunto
					.getAsuntoFolioExt(), asunto.getAsuntoFechaDocto(), asunto
					.getControl(), asunto.getIdEntidad(), asunto
					.getIdRemitente(), BUsuario.getIdArea());
			if (!bExisteFolio) {
				// //System.err.println("Guarda para entrar al archivado");
				String idAsunto1 = guardarAsunto(asunto.getIdEntidad(), asunto
						.getIdRemitente(), asunto.getAsuntoFirmante(), asunto
						.getAsunto(), asunto.getAsuntoExpediente(), asunto
						.getAsuntoTipoDocto(),
				/* asunto.getAsuntoCategoriaDocto(), */asunto
						.getAsuntoFechaRecepcion(), asunto
						.getAsuntoFechaDocto(), asunto.getAsuntoFechaCad(),
						asunto.getAsuntoFolioExt(), asunto.getAsuntoFolioInt(),
						asunto.getAsuntoSintesis(), asunto
								.getAsuntoComentario(), asunto
								.getAsuntoPalabraClave(), asunto
								.getAsuntoAnterior(), asunto
								.getAsuntoPrioridad(), asunto
								.getAsuntoTipoAsunto(), asunto
								.getIdDestinatario(), /* asunto.getAsuntoRutaAuto(), */
						asunto.getAsuntoDestinatario(), asunto.getMailDest(),
						asunto.getAsuntoRemitente(), asunto.getAsuntoCorreo(),
						strAreaUs, strIdUsrCaptura, asunto.getControl(),
						BUsuario.getNuevoAsunto(), serverMail, portServer,
						serverName, strRutaBase, strConfFolio, "1", asunto
								.getAsuntoPara(), asunto.getAsuntoCC(), asunto
								.getAsuntoIdsPara(), asunto.getAsuntoIdsCC(),
						asunto.getlugarEvento(), asunto.getHora_evento(),
						asunto.getFechaEvento(), asunto.getMin_evento(), 1,
						asunto.getAsuntoParaE(), asunto.getAsuntoIdsParaE(),
						asunto.getAsuntoTramite(), asunto.getAsuntoTipoFolio(),
						0,request);

				// String idAsunto1 = ActualizaAsunto.getUltimoIdAsunto();
				String dest[][] = ActualizaUsuario.getNombreCargoAreaUsr(asunto
						.getAsuntoDestinatario());
				SendRedirection = "ArchivadoAsunto.jsp?idAsunto=" + idAsunto1
						+ "&asunto=" + asunto.getAsunto() + "&area="
						+ dest[0][2];
			} else {
				SendRedirection = "1";
			}

		}// ** Guarda un asunto cuando se agrega un archivo para turnar**//
		else if (asunto.getId_asunto() == null
				&& strAccion.equals("guardarAttTur")) {

			boolean bExisteFolio = false;
			bExisteFolio = ActualizaAsunto.getExisteFolioExterno(asunto
					.getAsuntoFolioExt(), asunto.getAsuntoFechaDocto(), asunto
					.getControl(), asunto.getIdEntidad(), asunto
					.getIdRemitente(), BUsuario.getIdArea());
			if (!bExisteFolio) {
				String idAsunto1 = guardarAsunto(asunto.getIdEntidad(), asunto
						.getIdRemitente(), asunto.getAsuntoFirmante(), asunto
						.getAsunto(), asunto.getAsuntoExpediente(), asunto
						.getAsuntoTipoDocto(),
				/* asunto.getAsuntoCategoriaDocto(), */asunto
						.getAsuntoFechaRecepcion(), asunto
						.getAsuntoFechaDocto(), asunto.getAsuntoFechaCad(),
						asunto.getAsuntoFolioExt(), asunto.getAsuntoFolioInt(),
						asunto.getAsuntoSintesis(), asunto
								.getAsuntoComentario(), asunto
								.getAsuntoPalabraClave(), asunto
								.getAsuntoAnterior(), asunto
								.getAsuntoPrioridad(), asunto
								.getAsuntoTipoAsunto(), asunto
								.getIdDestinatario(), /* asunto.getAsuntoRutaAuto(), */
						asunto.getAsuntoDestinatario(), asunto.getMailDest(),
						asunto.getAsuntoRemitente(), asunto.getAsuntoCorreo(),
						strAreaUs, strIdUsrCaptura, asunto.getControl(),
						BUsuario.getNuevoAsunto(), serverMail, portServer,
						serverName, strRutaBase, strConfFolio, "1", asunto
								.getAsuntoPara(), asunto.getAsuntoCC(), asunto
								.getAsuntoIdsPara(), asunto.getAsuntoIdsCC(),
						asunto.getlugarEvento(), asunto.getHora_evento(),
						asunto.getFechaEvento(), asunto.getMin_evento(), 1,
						asunto.getAsuntoParaE(), asunto.getAsuntoIdsParaE(),
						asunto.getAsuntoTramite(), asunto.getAsuntoTipoFolio(),
						0,request);

				SendRedirection = "AsuntoTurnado.jsp?id_asunto=" + idAsunto1
						+ "&cargar=1&a=1";
			} else {
				SendRedirection = "1";
			}

		}// ** Guarda un asunto cuando se agrega un archivo para
		// recepcion**//
		else if (asunto.getId_asunto() == null
				&& strAccion.equals("guardarAttRep")) {

			boolean bExisteFolio = false;
			bExisteFolio = ActualizaAsunto.getExisteFolioExterno(asunto
					.getAsuntoFolioExt(), asunto.getAsuntoFechaDocto(), asunto
					.getControl(), asunto.getIdEntidad(), asunto
					.getIdRemitente(), BUsuario.getIdArea());
			if (!bExisteFolio) {
				String idAsunto1 = guardarAsunto(asunto.getIdEntidad(), asunto
						.getIdRemitente(), asunto.getAsuntoFirmante(), asunto
						.getAsunto(), asunto.getAsuntoExpediente(), asunto
						.getAsuntoTipoDocto(),
				/* asunto.getAsuntoCategoriaDocto(), */asunto
						.getAsuntoFechaRecepcion(), asunto
						.getAsuntoFechaDocto(), asunto.getAsuntoFechaCad(),
						asunto.getAsuntoFolioExt(), asunto.getAsuntoFolioInt(),
						asunto.getAsuntoSintesis(), asunto
								.getAsuntoComentario(), asunto
								.getAsuntoPalabraClave(), asunto
								.getAsuntoAnterior(), asunto
								.getAsuntoPrioridad(), asunto
								.getAsuntoTipoAsunto(), asunto
								.getIdDestinatario(), /* asunto.getAsuntoRutaAuto(), */
						asunto.getAsuntoDestinatario(), asunto.getMailDest(),
						asunto.getAsuntoRemitente(), asunto.getAsuntoCorreo(),
						strAreaUs, strIdUsrCaptura, asunto.getControl(),
						BUsuario.getNuevoAsunto(), serverMail, portServer,
						serverName, strRutaBase, strConfFolio, "0", asunto
								.getAsuntoPara(), asunto.getAsuntoCC(), asunto
								.getAsuntoIdsPara(), asunto.getAsuntoIdsCC(),
						asunto.getlugarEvento(), asunto.getHora_evento(),
						asunto.getFechaEvento(), asunto.getMin_evento(), 0,
						asunto.getAsuntoParaE(), asunto.getAsuntoIdsParaE(),
						asunto.getAsuntoTramite(), asunto.getAsuntoTipoFolio(),
						0,request);

				SendRedirection = "AsuntoRecepcion.jsp?id_asunto=" + idAsunto1
						+ "&cargar=1&a=4";
			} else {
				SendRedirection = "1";
			}
		} else if (asunto.getId_asunto() != null && strAccion.equals("cambiar")) {

			String tram = request.getParameter("tram");
			int ident = 0;
			if (tram != null) {
				ident = 2;
			} else {
				ident = 1;
			}

			// Actualización de los dias de las intrucciones, si
			// la fecha compromiso ha sido modificada cuando estar por turnar
			String str[][] = null;
			try {
				str = ActualizaAsunto
						.getFechaVencimiento(asunto.getId_asunto());
			} catch (SQLException io) {
				// System.err.println("Error="+io);
			}
			String strEstatus = request.getParameter("asuntoEst");
			String strFechaAct = asunto.getAsuntoFechaCad();
			String strFechaBD = str[0][0];
			boolean bExInst = ActualizaInstrucciones.TieneInstrucciones(asunto
					.getId_asunto());
			if (strEstatus.equals("1") && !strFechaBD.equals(strFechaAct)) {
				if (bExInst) {
					Calendar FI = Utilerias.StringCalendar(ActualizaAsunto
							.getFechaInicioAsunto(asunto.getId_asunto()));
					Calendar FF = Utilerias.StringCalendar2(strFechaAct
							.substring(0, 10));
					int iDuracion = Utilerias.getDuracion(FI, FF);
					int iDuracion1 = Utilerias.getSinDiasFestivos(FI, FF);
					int iSuma = iDuracion - iDuracion1;
					String strDuracion = String.valueOf(iSuma);
					boolean bAct = ActualizaInstrucciones.updateTiempoInst(
							asunto.getId_asunto(), strDuracion);
				}
			}// Fin

			if (!asunto.getAsuntoTramite().equals("-1")) {
				String strTramite[][] = ActualizaTramite.getTramite(asunto
						.getAsuntoTramite());
				String strDuracion = strTramite[0][5];
				Calendar cFechaInicio = Utilerias.StringCalendar2(asunto
						.getAsuntoFechaRecepcion().substring(0, 10));
				String strFechaFin = Utilerias.getFechaTerminacionInst(
						(Calendar) cFechaInicio.clone(), strTramite[0][5]);
				Calendar FI = Utilerias.StringCalendar2(asunto
						.getAsuntoFechaRecepcion().substring(0, 10));
				Calendar FF = Utilerias.StringCalendar2(strFechaFin);
				int iDuracion = Utilerias.getSinDiasFestivos(FI, FF);
				String strDuracion1 = String.valueOf(iDuracion);
				String strFechaCaducidad = Utilerias.getFechaTerminacionInst(
						(Calendar) FF.clone(), strDuracion1);
				asunto.setAsuntoFechaCad(strFechaCaducidad);
			}

			String stridTipoDocto = asunto.getAsuntoTipoDocto_1();
			ActualizarAsunto(asunto.getIdEntidad(), asunto.getIdRemitente(),
					asunto.getAsuntoFirmante(), asunto.getAsunto(), asunto
							.getAsuntoExpediente(), stridTipoDocto,
					/* asunto.getAsuntoCategoriaDocto(), */asunto
							.getAsuntoFechaRecepcion(), asunto
							.getAsuntoFechaDocto(), asunto.getAsuntoFechaCad(),
					asunto.getAsuntoFolioExt(), asunto.getAsuntoFolioInt(),
					asunto.getAsuntoSintesis(), asunto.getAsuntoComentario(),
					asunto.getAsuntoPalabraClave(), asunto.getAsuntoAnterior(),
					asunto.getAsuntoPrioridad(), asunto.getAsuntoTipoAsunto(),
					asunto.getId_asunto(), strIdUsrCaptura, ident, "1", asunto
							.getFol(), asunto.getAsuntoPara(), asunto
							.getAsuntoCC(), asunto.getAsuntoIdsPara(), asunto
							.getAsuntoIdsCC(), asunto.getlugarEvento(), asunto
							.getHora_evento(), asunto.getFechaEvento(), asunto
							.getMin_evento(), asunto.getAsuntoParaE(), asunto
							.getAsuntoIdsParaE(), asunto.getControl(), asunto
							.getAsuntoTramite(), asunto.getIdDestinatario(),
					asunto.getAsuntoTipoFolio());

			SendRedirection = "portalPrincipal.jsp";
			// SendRedirection =
			// "AsuntoTurnado.jsp?id_asunto="+asunto.getId_asunto();

		}
		// ** Se actualiza el asunto con estatus 1
		else if (asunto.getId_asunto() != null && strAccion.equals("cambiar1")) {

			// //System.err.println("Entra
			// actualizarRecepcion-->PorTunar******>");
			String strFolioGenerado = "";
			if ("folio por asignar".equals(asunto.getFol())) {
				boolean bExisteFolio = false;
				bExisteFolio = ActualizaAsunto.getExisteFolioExternoRepTur(
						asunto.getAsuntoFolioExt(), asunto
								.getAsuntoFechaDocto(), asunto.getControl(),
						asunto.getIdEntidad(), asunto.getIdRemitente(),
						BUsuario.getIdArea());

				String stridTipoDocto = asunto.getAsuntoTipoDocto_1();
				// //System.err.println("control=>"+asunto.getControl());
				if (!bExisteFolio) {
					String strDatosTD[][] = ActualizaTipo_Doc
							.getTipoDoctoFolio(asunto.getAsuntoTipoDocto());

					if (strDatosTD == null || strDatosTD.length < 1
							|| strDatosTD[0].length < 3) {
						strDatosTD = new String[1][4];
						strDatosTD[0][0] = "";
						strDatosTD[0][1] = "";
						strDatosTD[0][2] = "";
						strDatosTD[0][3] = "";
					}
					String strNombreDocto = strDatosTD[0][0] == null ? ""
							: strDatosTD[0][0];
					String strClaveOP = strDatosTD[0][1] == null ? ""
							: strDatosTD[0][1];
					String strAreaDocto = strDatosTD[0][2] == null ? ""
							: strDatosTD[0][2];
					String strConseTD = strDatosTD[0][3] == null ? ""
							: strDatosTD[0][3];
					String strAreaUsuario[][] = ActualizaArea
							.getAreaFolio(strAreaUs);

					if (strAreaUsuario == null) {
						strAreaUsuario = new String[1][1];
						strAreaUsuario[0][0] = "";
					}
					String strNombreArea = strAreaUsuario[0][0];

					// * strDatosFolio almacena los datos de un folio

					boolean bExisteFol = ActualizaFolio.ExisteFolio(strAreaUs);
					if (bExisteFol) {
						String strDatosFolio[][] = ActualizaFolio
								.getGeneracionFolio(strAreaUs);

						if (strDatosFolio == null) {
							strDatosFolio = new String[1][5];
							strDatosFolio[0][0] = "";
							strDatosFolio[0][1] = "";
							strDatosFolio[0][2] = "";
							strDatosFolio[0][3] = "";
							strDatosFolio[0][4] = "";
						}

						String claveFolio = strDatosFolio[0][0];
						String consecutivo = strDatosFolio[0][1];
						String tipoDocto = strDatosFolio[0][2];
						String orden = strDatosFolio[0][3];// 0=SI, 1=NO
						String idFolio = strDatosFolio[0][4];
						int iConsecutivo = 0;
						if (strConfFolio.equals("1")) {
							strFolioGenerado = GeneracionFolio
									.setGeneracionFolios(strClaveOP,
											claveFolio, strConseTD, orden);
							iConsecutivo = new Integer(strConseTD).intValue();
						} else {
							strFolioGenerado = com.meve.sigma.util.GeneracionFolio
									.setGeneracionFolios(strClaveOP,
											claveFolio, consecutivo, orden);
							iConsecutivo = new Integer(consecutivo).intValue();
						}

						int a = iConsecutivo + 1;
						boolean bUpdateConse = false;
						if (strConfFolio.equals("1")) {
							bUpdateConse = ActualizaTipo_Doc
									.ActualizaConsecutivoFolio(a, asunto
											.getAsuntoTipoDocto());
						} else {
							bUpdateConse = ActualizaFolio
									.ActualizaConsecutivoFolio(a, idFolio);
						}
					} else {
						strFolioGenerado = com.meve.sigma.util.GeneracionFolio
								.setGeneracionSinFolio(strNombreArea);
					}// ** Fin de la generacion del folio
					// **Cambio de nombre del folder
					FolderAsunto.moveArchives(asunto.id_asunto,
							strFolioGenerado, strUriContent, strUserContet,
							strPassContent, strPathContent);

					if (BUsuario.getNuevoAsunto()) {
							SenderMail notificar = new SenderMail();
							if (ActualizaUsuario.getNotificacionMail(asunto
									.getIdDestinatario())) {
								notificar.sendNotificarNuevoAsunto(asunto
										.getAsuntoDestinatario(), asunto
										.getMailDest(), asunto
										.getAsuntoRemitente(), asunto
										.getAsuntoCorreo(), asunto.getAsunto(),
										 SN,
										asunto.id_asunto, strRutaBase,request.getSession().getServletContext());
							}
					}

					if (!asunto.getAsuntoTramite().equals("-1")) {
						String strTramite[][] = ActualizaTramite
								.getTramite(asunto.getAsuntoTramite());
						String strDuracion = strTramite[0][5];
						Calendar cFechaInicio = Utilerias
								.StringCalendar2(asunto
										.getAsuntoFechaRecepcion().substring(0,
												10));
						String strFechaFin = Utilerias.getFechaTerminacionInst(
								(Calendar) cFechaInicio.clone(),
								strTramite[0][5]);
						Calendar FI = Utilerias.StringCalendar2(asunto
								.getAsuntoFechaRecepcion().substring(0, 10));
						Calendar FF = Utilerias.StringCalendar2(strFechaFin);
						int iDuracion = Utilerias.getSinDiasFestivos(FI, FF);
						String strDuracion1 = String.valueOf(iDuracion);
						String strFechaCaducidad = Utilerias
								.getFechaTerminacionInst((Calendar) FF.clone(),
										strDuracion1);
						asunto.setAsuntoFechaCad(strFechaCaducidad);
					}
					ActualizarAsunto(asunto.getIdEntidad(), asunto
							.getIdRemitente(), asunto.getAsuntoFirmante(),
							asunto.getAsunto(), asunto.getAsuntoExpediente(),
							asunto.getAsuntoTipoDocto(), asunto
									.getAsuntoFechaRecepcion(), asunto
									.getAsuntoFechaDocto(), asunto
									.getAsuntoFechaCad(), asunto
									.getAsuntoFolioExt(), asunto
									.getAsuntoFolioInt(), asunto
									.getAsuntoSintesis(), asunto
									.getAsuntoComentario(), asunto
									.getAsuntoPalabraClave(), asunto
									.getAsuntoAnterior(), asunto
									.getAsuntoPrioridad(), asunto
									.getAsuntoTipoAsunto(), asunto
									.getId_asunto(), strIdUsrCaptura, 1, "1",
							strFolioGenerado, asunto.getAsuntoPara(), asunto
									.getAsuntoCC(), asunto.getAsuntoIdsPara(),
							asunto.getAsuntoIdsCC(), asunto.getlugarEvento(),
							asunto.getHora_evento(), asunto.getFechaEvento(),
							asunto.getMin_evento(), asunto.getAsuntoParaE(),
							asunto.getAsuntoIdsParaE(), asunto.getControl(),
							asunto.getAsuntoTramite(), asunto
									.getIdDestinatario(), asunto
									.getAsuntoTipoFolio());

					// SendRedirection = "portalPrincipal.jsp";
					SendRedirection = "AsuntoTurnado.jsp?id_asunto="
							+ asunto.getId_asunto();
				} else {
					SendRedirection = "1";
				}
			} else {
				ActualizarAsunto(asunto.getIdEntidad(),
						asunto.getIdRemitente(), asunto.getAsuntoFirmante(),
						asunto.getAsunto(), asunto.getAsuntoExpediente(),
						asunto.getAsuntoTipoDocto(), asunto
								.getAsuntoFechaRecepcion(), asunto
								.getAsuntoFechaDocto(), asunto
								.getAsuntoFechaCad(), asunto
								.getAsuntoFolioExt(), asunto
								.getAsuntoFolioInt(), asunto
								.getAsuntoSintesis(), asunto
								.getAsuntoComentario(), asunto
								.getAsuntoPalabraClave(), asunto
								.getAsuntoAnterior(), asunto
								.getAsuntoPrioridad(), asunto
								.getAsuntoTipoAsunto(), asunto.getId_asunto(),
						strIdUsrCaptura, 1, "1", asunto.getFol(), asunto
								.getAsuntoPara(), asunto.getAsuntoCC(), asunto
								.getAsuntoIdsPara(), asunto.getAsuntoIdsCC(),
						asunto.getlugarEvento(), asunto.getHora_evento(),
						asunto.getFechaEvento(), asunto.getMin_evento(), asunto
								.getAsuntoParaE(), asunto.getAsuntoIdsParaE(),
						asunto.getControl(), asunto.getAsuntoTramite(), asunto
								.getIdDestinatario(), asunto
								.getAsuntoTipoFolio());
				SendRedirection = "AsuntoTurnado.jsp?id_asunto="
						+ asunto.getId_asunto();

			}

		}
		// ** Se actualiza el asunto cuando cuando se pretende crear la ruta
		else if (asunto.getId_asunto() != null && strAccion.equals("cambiar2")) {

			boolean bExisteFolio = false;
			bExisteFolio = ActualizaAsunto.getExisteFolioExterno(asunto
					.getAsuntoFolioExt(), asunto.getAsuntoFechaDocto(), asunto
					.getControl(), asunto.getIdEntidad(), asunto
					.getIdRemitente(), BUsuario.getIdArea());

			// //System.err.println("Entra actualizar******>");
			ActualizarAsunto(asunto.getIdEntidad(), asunto.getIdRemitente(),
					asunto.getAsuntoFirmante(), asunto.getAsunto(), asunto
							.getAsuntoExpediente(),
					asunto.getAsuntoTipoDocto(),
					/* asunto.getAsuntoCategoriaDocto(), */asunto
							.getAsuntoFechaRecepcion(), asunto
							.getAsuntoFechaDocto(), asunto.getAsuntoFechaCad(),
					asunto.getAsuntoFolioExt(), asunto.getAsuntoFolioInt(),
					asunto.getAsuntoSintesis(), asunto.getAsuntoComentario(),
					asunto.getAsuntoPalabraClave(), asunto.getAsuntoAnterior(),
					asunto.getAsuntoPrioridad(), asunto.getAsuntoTipoAsunto(),
					asunto.getId_asunto(), strIdUsrCaptura, 1, "1", asunto
							.getFol(), asunto.getAsuntoPara(), asunto
							.getAsuntoCC(), asunto.getAsuntoIdsPara(), asunto
							.getAsuntoIdsCC(), asunto.getlugarEvento(), asunto
							.getHora_evento(), asunto.getFechaEvento(), asunto
							.getMin_evento(), asunto.getAsuntoParaE(), asunto
							.getAsuntoIdsParaE(), asunto.getControl(), asunto
							.getAsuntoTramite(), asunto.getIdDestinatario(),
					asunto.getAsuntoTipoFolio());

			SendRedirection = "VisualizaInstrucciones.jsp?idAsunto="
					+ asunto.getId_asunto() + "&Url=" + URL1;

		}
		// ** Se actualiza el asunto por medio de Recepción,
		// ** el estatus del asunto es cero
		else if (asunto.getId_asunto() != null
				&& strAccion.equals("cambiarRep")) {
			boolean bExisteFolio = false;
			bExisteFolio = ActualizaAsunto.getExisteFolioExterno(asunto
					.getAsuntoFolioExt(), asunto.getAsuntoFechaDocto(), asunto
					.getControl(), asunto.getIdEntidad(), asunto
					.getIdRemitente(), BUsuario.getIdArea());

			// Verifica si el Trámite ha cambiado en el Número de dias
			if (!asunto.getAsuntoTramite().equals("-1")) {
				String strTramite[][] = ActualizaTramite.getTramite(asunto
						.getAsuntoTramite());
				String strDuracion = strTramite[0][5];
				Calendar cFechaInicio = Utilerias.StringCalendar2(asunto
						.getAsuntoFechaRecepcion().substring(0, 10));
				String strFechaFin = Utilerias.getFechaTerminacionInst(
						(Calendar) cFechaInicio.clone(), strTramite[0][5]);
				Calendar FI = Utilerias.StringCalendar2(asunto
						.getAsuntoFechaRecepcion().substring(0, 10));
				Calendar FF = Utilerias.StringCalendar2(strFechaFin);
				int iDuracion = Utilerias.getSinDiasFestivos(FI, FF);
				String strDuracion1 = String.valueOf(iDuracion);
				String strFechaCaducidad = Utilerias.getFechaTerminacionInst(
						(Calendar) FF.clone(), strDuracion1);
				asunto.setAsuntoFechaCad(strFechaCaducidad);
			}

			// //System.err.println("Actualizacion Recepción con estatus 0");
			ActualizarAsunto(asunto.getIdEntidad(), asunto.getIdRemitente(),
					asunto.getAsuntoFirmante(), asunto.getAsunto(), asunto
							.getAsuntoExpediente(),
					asunto.getAsuntoTipoDocto(),
					/* asunto.getAsuntoCategoriaDocto(), */asunto
							.getAsuntoFechaRecepcion(), asunto
							.getAsuntoFechaDocto(), asunto.getAsuntoFechaCad(),
					asunto.getAsuntoFolioExt(), asunto.getAsuntoFolioInt(),
					asunto.getAsuntoSintesis(), asunto.getAsuntoComentario(),
					asunto.getAsuntoPalabraClave(), asunto.getAsuntoAnterior(),
					asunto.getAsuntoPrioridad(), asunto.getAsuntoTipoAsunto(),
					asunto.getId_asunto(), strIdUsrCaptura, 0, "0",
					"folio por asignar", asunto.getAsuntoPara(), asunto
							.getAsuntoCC(), asunto.getAsuntoIdsPara(), asunto
							.getAsuntoIdsCC(), asunto.getlugarEvento(), asunto
							.getHora_evento(), asunto.getFechaEvento(), asunto
							.getMin_evento(), asunto.getAsuntoParaE(), asunto
							.getAsuntoIdsParaE(), asunto.getControl(), asunto
							.getAsuntoTramite(), asunto.getIdDestinatario(),
					asunto.getAsuntoTipoFolio());

			SendRedirection = "PortalBorrador.jsp";
		}
		// ** Se actualiza el asunto y lo guarda con estatus 1
		// ** en este caso cambia para ser turnado
		else if (asunto.getId_asunto() != null
				&& strAccion.equals("cambiarGuaTur")) {
			boolean bExisteFolio = false;
			bExisteFolio = ActualizaAsunto.getExisteFolioExterno(asunto
					.getAsuntoFolioExt(), asunto.getAsuntoFechaDocto(), asunto
					.getControl(), asunto.getIdEntidad(), asunto
					.getIdRemitente(), BUsuario.getIdArea());
			// //System.err.println("Actualizacion Recepción a estatus 1");
			ActualizarAsunto(asunto.getIdEntidad(), asunto.getIdRemitente(),
					asunto.getAsuntoFirmante(), asunto.getAsunto(), asunto
							.getAsuntoExpediente(),
					asunto.getAsuntoTipoDocto(), asunto
							.getAsuntoFechaRecepcion(), asunto
							.getAsuntoFechaDocto(), asunto.getAsuntoFechaCad(),
					asunto.getAsuntoFolioExt(), asunto.getAsuntoFolioInt(),
					asunto.getAsuntoSintesis(), asunto.getAsuntoComentario(),
					asunto.getAsuntoPalabraClave(), asunto.getAsuntoAnterior(),
					asunto.getAsuntoPrioridad(), asunto.getAsuntoTipoAsunto(),
					asunto.getId_asunto(), strIdUsrCaptura, 0, "1", "", asunto
							.getAsuntoPara(), asunto.getAsuntoCC(), asunto
							.getAsuntoIdsPara(), asunto.getAsuntoIdsCC(),
					asunto.getlugarEvento(), asunto.getHora_evento(), asunto
							.getFechaEvento(), asunto.getMin_evento(), asunto
							.getAsuntoParaE(), asunto.getAsuntoIdsParaE(),
					asunto.getControl(), asunto.getAsuntoTramite(), asunto
							.getIdDestinatario(), asunto.getAsuntoTipoFolio());

			SendRedirection = "portalPrincipal.jsp";
		}
		// ** Elimina el asunto
		else if (asunto.getId_asunto() != null && strAccion.equals("borrar")) {
			// //System.out.println("**************Se va a
			// borrar****************");
			// //System.out.println("ID_ASUNTO="+asunto.getId_asunto());
			boolean bDelete = ActualizaAsunto.deleteAsunto(asunto
					.getId_asunto());
			ActualizaBitacora.InsertarEventoBajaAsunto(BUsuario.getIdUsuario(),
					asunto.getId_asunto());
			SendRedirection = "portalPrincipal.jsp";

		}

		return SendRedirection;
	}

	/**
	 * Guarda y procesa el asunto en Recepción, por turnar o en Trámite
	 * 
	 * @param strIdEntidad
	 *            Entidad
	 * @param strIdRemitente
	 *            Remitente
	 * @param strFirmante
	 *            Firmante
	 * @param strAsunto
	 *            Asunto
	 * @param strIdExpediente
	 *            Expediente
	 * @param strIdTipoDocto
	 *            Tipo de Docto.
	 * @param strFechaRecepcion
	 *            Fecha de Recepción
	 * @param strFechaDocto
	 *            Fecha de docto.
	 * @param strFechaCaducidad
	 *            Fecha compromiso
	 * @param strFolioExterno
	 *            Identificador del docto.
	 * @param strFolioIntermedio
	 *            Folio Intermedio
	 * @param strSintesis
	 *            Sintesis
	 * @param strComentarios
	 *            Comentarios
	 * @param strPalabraClave
	 *            palabra clave
	 * @param strAsuntoAnterior
	 *            Referencias de asuntos
	 * @param strIdPrioridad
	 *            Prioridad
	 * @param strIdTipoAsunto
	 *            Tipo de asunto
	 * @param strIdDestinatario
	 *            Id ventanilla
	 * @param strDestinatario
	 *            Ventanilla
	 * @param strMailDest
	 *            Mail destinatario
	 * @param strRemitente
	 *            Remitente
	 * @param strCorreo
	 *            Correo remitente
	 * @param strAreaUs
	 *            área del usuario que captura
	 * @param strIdUsrCaptura
	 *            Nombre usuario que captura
	 * @param strControl
	 *            Control del asunto
	 * @param nuevoAsunto
	 *            Nuevo asunto
	 * @param SMail
	 *            Servidor mail
	 * @param SPort
	 *            Puerto de salida del mail
	 * @param SN
	 *            Nombre del servidor
	 * @param strRutaBase
	 *            Contexto de la aplicación
	 * @param strConfFolio
	 *            Configuración folio
	 * @param strEstatus
	 *            Estatus del asunto
	 * @param strPara
	 *            Destinatarios para
	 * @param strCC
	 *            Destinatarios cc
	 * @param strIdsPara
	 *            ids Destinatarios para
	 * @param strIdsCC
	 *            ids Destinatarios cc
	 * @param lugarEvento
	 *            Lugar del evento
	 * @param stringHoraEvento
	 *            Hora del evento
	 * @param strFechaEvento
	 *            Fecha del evento
	 * @param stringMinEvento
	 *            Minuto del evento
	 * @param iesRescepcion
	 *            Verifica si es de Recepción
	 * @param strParaE
	 *            Destinatarios externos
	 * @param strIdsParaE
	 *            ids Destinatarios externos
	 * @param strTramite
	 *            Trámite
	 * @param strTipoFolio
	 *            Tipo de folio
	 * @param iBandera
	 *            bandera
	 * @return Ultimo id del asunto registrado
	 */
	public synchronized String guardarAsunto(String strIdEntidad,
			String strIdRemitente, String strFirmante, String strAsunto,
			String strIdExpediente,String strIdTipoDocto,String strFechaRecepcion,
			String strFechaDocto, String strFechaCaducidad,
			String strFolioExterno, String strFolioIntermedio,
			String strSintesis, String strComentarios, String strPalabraClave,
			String strAsuntoAnterior, String strIdPrioridad,
			String strIdTipoAsunto, String strIdDestinatario,
			String strDestinatario, String strMailDest, String strRemitente,
			String strCorreo, String strAreaUs, String strIdUsrCaptura,
			String strControl, boolean nuevoAsunto, String SMail, String SPort,
			String SN, String strRutaBase, String strConfFolio,
			String strEstatus, String strPara, String strCC, String strIdsPara,
			String strIdsCC, String lugarEvento, String stringHoraEvento,
			String strFechaEvento, String stringMinEvento, int iesRescepcion,
			String strParaE, String strIdsParaE, String strTramite,
			String strTipoFolio, int iBandera,HttpServletRequest request) {

		boolean bExisteFol = false;
		boolean bUpdateConse = false;
		boolean bInsertarBit = false;
		boolean bInsertar = false;

		String claveFolio = "";
		String consecutivo = "";
		String tipoDocto = "";
		String orden = "";
		String idFolio = "";
		String strFolioGenerado = "";
		String strFechaCreacion = "";

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date f = new Date();
		strFechaCreacion = sdf.format(f);
		// if(!strIdTipoDocto.equals("null")){
		if (iBandera == 0) {

			String strDatosTD[][] = ActualizaTipo_Doc
					.getTipoDoctoFolio(strIdTipoDocto);

			if (strDatosTD == null || strDatosTD.length < 1
					|| strDatosTD[0].length < 3) {
				strDatosTD = new String[1][4];
				strDatosTD[0][0] = "";
				strDatosTD[0][1] = "";
				strDatosTD[0][2] = "";
				strDatosTD[0][3] = "";
			}
			String strNombreDocto = strDatosTD[0][0] == null ? ""
					: strDatosTD[0][0];
			String strClaveOP = strDatosTD[0][1] == null ? ""
					: strDatosTD[0][1];
			String strAreaDocto = strDatosTD[0][2] == null ? ""
					: strDatosTD[0][2];
			String strConseTD = strDatosTD[0][3] == null ? ""
					: strDatosTD[0][3];
			String strNombreArea = "";
			String strAreaUsuario[][] = ActualizaArea.getAreaFolio(strAreaUs);

			/*
			 * if(strAreaUsuario == null){ strAreaUsuario = new String[1][1];
			 * strAreaUsuario[0][0]=""; }
			 */
			if (strAreaUsuario.length == 0) {
				strNombreArea = "";
			} else {
				strNombreArea = strAreaUsuario[0][0];
			}
			// strNombreArea = strAreaUsuario[0][0];

			// * strDatosFolio almacena los datos de un folio
			bExisteFol = ActualizaFolio.ExisteFolio(strAreaUs);
			if (bExisteFol) {
				String strDatosFolio[][] = ActualizaFolio
						.getGeneracionFolio(strAreaUs);

				if (strDatosFolio == null) {
					strDatosFolio = new String[1][5];
					strDatosFolio[0][0] = "";
					strDatosFolio[0][1] = "";
					strDatosFolio[0][2] = "";
					strDatosFolio[0][3] = "";
					strDatosFolio[0][4] = "";
				}

				claveFolio = strDatosFolio[0][0];
				consecutivo = strDatosFolio[0][1];
				tipoDocto = strDatosFolio[0][2];
				orden = strDatosFolio[0][3];// 0=SI, 1=NO
				idFolio = strDatosFolio[0][4];
				int iConsecutivo = 0;

				if (strConfFolio.equals("1")) {
					strFolioGenerado = GeneracionFolio.setGeneracionFolios(
							strClaveOP, claveFolio, strConseTD, orden);
					iConsecutivo = new Integer(strConseTD).intValue();
				} else {
					strFolioGenerado = GeneracionFolio.setGeneracionFolios(
							strClaveOP, claveFolio, consecutivo, orden);
					iConsecutivo = new Integer(consecutivo).intValue();
				}

				int a = iConsecutivo + 1;

				if (strConfFolio.equals("1")) {
					bUpdateConse = ActualizaTipo_Doc.ActualizaConsecutivoFolio(
							a, strIdTipoDocto);
				} else {
					bUpdateConse = ActualizaFolio.ActualizaConsecutivoFolio(a,
							idFolio);
				}
			} else {
				strFolioGenerado = GeneracionFolio
						.setGeneracionSinFolio(strNombreArea);
			}// ** Fin de la generacion del folio
		} else {
			// //System.err.println("No genera ningun folio");
			strFolioGenerado = "folio por asignar";
		}// fin strIdTipoDocto != null && strIdTipoDocto.length() > 0

		// ** Se insertan los datos en la tabla de SD_ASUNTO
		String stridUltimoId = ActualizaAsunto.InsertarAsunto(strIdEntidad,
				strIdRemitente, strFirmante, strAsunto, strIdExpediente, /*
																			 * strUbicacion,
																			 * strReferenciaExp,
																			 */strIdTipoDocto,
				/* strCategoriaDocto, */strFechaRecepcion, strFechaDocto,
				strFechaCaducidad, strFolioExterno, strFolioIntermedio,
				strSintesis, strComentarios, strPalabraClave,
				strAsuntoAnterior, strIdPrioridad, strFolioGenerado,
				strIdUsrCaptura, strFechaCreacion, strAreaUs, strIdTipoAsunto,
				strIdDestinatario, strControl, strEstatus, strPara, strCC,
				strIdsPara, strIdsCC, lugarEvento, stringHoraEvento,
				strFechaEvento, stringMinEvento, strParaE, strIdsParaE,
				strTramite, strTipoFolio);
		// ** Fin Insertar Asunto
		// String stridUltimoId = ActualizaAsunto.getUltimoIdAsunto();
		// ** Se registra en la bitacora quien ha creado el nuevo asunto
		bInsertarBit = ActualizaBitacora.InsertarEventoAltaAsunto(
				strIdUsrCaptura, strFolioGenerado);
		// ** Se envia un mail al Destinatario o usuario que tiene como rol de
		// turnador
		// ** para que atienda el nuevo asunto
		if (iesRescepcion == 1) {
			if (nuevoAsunto) {
					SenderMail notificar = new SenderMail();
					if (ActualizaUsuario.getNotificacionMail(strIdDestinatario)) {
						notificar.sendNotificarNuevoAsunto(strDestinatario, strMailDest,
								strRemitente, strCorreo, strAsunto, SN, stridUltimoId, strRutaBase,request.getSession().getServletContext());
					}
			}
		}
		return stridUltimoId;
	}

	/**
	 * 
	 * @param strIdEntidad
	 *            Entidad
	 * @param strIdRemitente
	 *            Remitente
	 * @param strFirmante
	 *            Firmante
	 * @param strAsunto
	 *            Asunto
	 * @param strIdExpediente
	 *            Expediente
	 * @param strIdTipoDocto
	 *            Tipo de Docto.
	 * @param strFechaRecepcion
	 *            Fecha de Recepción
	 * @param strFechaDocto
	 *            Fecha de docto.
	 * @param strFechaCaducidad
	 *            Fecha compromiso
	 * @param strFolioExterno
	 *            Identificador del docto.
	 * @param strFolioIntermedio
	 *            Folio Intermedio
	 * @param strSintesis
	 *            Sintesis
	 * @param strComentarios
	 *            Comentarios
	 * @param strPalabraClave
	 *            palabra clave
	 * @param strAsuntoAnterior
	 *            Referencias de asuntos
	 * @param strIdPrioridad
	 *            Prioridad
	 * @param strIdTipoAsunto
	 *            Tipo de asunto
	 * @param strIdAsunto
	 *            Id del asunto
	 * @param strIdUsrCaptura
	 *            Id usuario que actualizá
	 * @param numero
	 *            Número
	 * @param strEstatus
	 *            Estatus
	 * @param strFolioRep
	 *            Folio Recepción
	 * @param strPara
	 *            Destinatarios Para
	 * @param strCC
	 *            Destinatarios CC
	 * @param strIdsPara
	 *            ids Destinatarios Para
	 * @param strIdsCC
	 *            ids Destinatarios cc
	 * @param lugarEvento
	 *            lugar del evento
	 * @param stringHoraEvento
	 *            Hora del evento
	 * @param strFechaEvento
	 *            fecha del evento
	 * @param stringMinEvento
	 *            minuto del evento
	 * @param strParaE
	 *            Destinatarios Externos
	 * @param strIdsParaE
	 *            ids Destinatarios Externos
	 * @param strControl
	 *            Control
	 * @param strTramite
	 *            Trámite
	 * @param strIdDestinatario
	 *            Id destinatario
	 * @param strTipoFolio
	 *            Folio de control
	 */
	public void ActualizarAsunto(String strIdEntidad, String strIdRemitente,
			String strFirmante, String strAsunto, String strIdExpediente,
			String strIdTipoDocto, String strFechaRecepcion,
			String strFechaDocto, String strFechaCaducidad,
			String strFolioExterno, String strFolioIntermedio,
			String strSintesis, String strComentarios, String strPalabraClave,
			String strAsuntoAnterior, String strIdPrioridad,
			String strIdTipoAsunto, String strIdAsunto, String strIdUsrCaptura,
			int numero, String strEstatus, String strFolioRep, String strPara,
			String strCC, String strIdsPara, String strIdsCC,
			String lugarEvento, String stringHoraEvento, String strFechaEvento,
			String stringMinEvento, String strParaE, String strIdsParaE,
			String strControl, String strTramite, String strIdDestinatario,
			String strTipoFolio) {
		boolean bUpdate = false;
		boolean bInsertarBit = false;

		bUpdate = ActualizaAsunto.ActualizarAsuntos(strIdEntidad,
				strIdRemitente, strFirmante, strAsunto, strIdExpediente,
				strIdTipoDocto, strFechaRecepcion, strFechaDocto,
				strFechaCaducidad, strFolioExterno, strFolioIntermedio,
				strSintesis, strComentarios, strPalabraClave,
				strAsuntoAnterior, strIdPrioridad, strIdTipoAsunto,
				strIdAsunto, numero, strEstatus, strFolioRep, strPara, strCC,
				strIdsPara, strIdsCC, lugarEvento, stringHoraEvento,
				strFechaEvento, stringMinEvento, strParaE, strIdsParaE,
				strControl, strTramite, strIdDestinatario, strTipoFolio);

		bInsertarBit = ActualizaBitacora.InsertarEventoCambioAsunto(
				strIdUsrCaptura, strFolioRep);
	}

}
