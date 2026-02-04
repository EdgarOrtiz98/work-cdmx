/*
 * Clase:						TurnarBean.java
 * 
 * Paquete:						com.meve.sigma.beans		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Nov 1, 2005
 * 
 * @author: 					Rodrigo Soto Ch.
 * 								rodrigo_s_ch@yahoo.com.mx, rodrigo.soto.ch@gmail.com
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		
 */

package com.meve.sigma.beans;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import com.meve.sigma.actualiza.ActualizaArea;
import com.meve.sigma.actualiza.ActualizaAsunto;
import com.meve.sigma.actualiza.ActualizaAsuntoTurnado;
import com.meve.sigma.actualiza.ActualizaBitacora;
import com.meve.sigma.actualiza.ActualizaExpediente;
import com.meve.sigma.actualiza.ActualizaInstrucciones;
import com.meve.sigma.actualiza.ActualizaTramite;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.reportes.ActualizaInst;
import com.meve.sigma.util.SenderMail;
import com.meve.sigma.util.Utilerias;

/**
 * Bean que se utiliza para turnar un asunto
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class TurnarBean {
	/**
	 * Turna instrccuones por medio del turnador
	 * 
	 * @param request
	 *            solicitud
	 * @param BUsuario
	 *            Bean de usuario
	 * @param Smail
	 *            servidor de correo
	 * @param PMail
	 *            puerto de servidor de correo
	 * @param SN
	 *            nombre de servidor
	 * @param strBase
	 *            contexto
	 * @param strIdAreaOrigen
	 *            Id de área origen
	 */
	public void turnarInstrucciones(HttpServletRequest request,
			UsuarioBean BUsuario, String Smail, String PMail, String SN,
			String strBase, String strIdAreaOrigen) {
		String strFechaFin = "";
		String strIdAsunto = "";
		String strNotificar = "";
		String nombre = "";
		String strFechaInicio = "";
		String strIdDocto = "";

		String claveFolio = "";
		String consecutivo = "";
		String tipoDocto = "";
		String orden = "";
		String idFolio = "";
		String strFolioGenerado = "";
		String strFechaCreacion = "";
		String strNombreAsunto = "";
		String strAnio = "";

		int ns = 1;
		int req1 = 1;

		boolean bActualizaInstruccion = false;
		boolean bActualizaAsunto = false;
		boolean bInsertarBit = false;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date f = new Date();
		strFechaInicio = sdf.format(f);
		strIdAsunto = request.getParameter("id_asunto");
		strNotificar = request.getParameter("usuarioNombre");
		strNombreAsunto = request.getParameter("NombreAsu");
		nombre = request.getParameter("b");
		Calendar cFechaInicio = Utilerias.StringCalendar2(strFechaInicio);
		String strTimeInstruc[][] = ActualizaInstrucciones
				.getTimeInstrucciones(strIdAsunto);
		String strGetFolio = ActualizaInstrucciones
				.getFolioRecepcion(strIdAsunto);
		String strTurno = ActualizaAsunto.getAsuntoTurnado(strIdAsunto);
		String horariosArea[][] = ActualizaArea.getHorarioUsuario(strTurno);
		strFechaInicio = Utilerias.getFechaInicio(strFechaInicio,
				horariosArea[0][1], horariosArea[0][2]);
		if (strNotificar != null && strNotificar.length() != 0) {
			if (!strNotificar.equals("-1")) {
				SenderMail notificar1 = new SenderMail();
				try {
					if (ActualizaUsuario.getNotificacionMail(strNotificar)) {
						notificar1.sendNotificacionAsuntoTurnado(strNotificar, strNombreAsunto,
								SN, strIdAsunto, strBase, request.getSession()
										.getServletContext());
					}
				} catch (MessagingException me) {
				} catch (UnsupportedEncodingException uee) {
				}
			}
		}

		// Se asigna el folio a las instrucciones que tiene el paso 1

		// **asignación de folio de entrada
		boolean bExisteFolioEntrada = false;
		boolean bActualizaConse = false;
		boolean bActualizaFolioEnt = false;
		// String strFolioSalida = "";
		bExisteFolioEntrada = ActualizaAsunto
				.getExisteFolioSalidaAsunto(strIdAsunto);
		String[][] strIdArea = ActualizaAsunto.getAreaFoleo(strIdAsunto);
		if (!bExisteFolioEntrada) {
			String strEntrada = ActualizaArea.getEntrada(strIdArea[0][0]);
			strAnio = ActualizaArea.getSalida(strIdArea[0][0]);
			int iConsecutivoE = new Integer(strEntrada).intValue();
			int countE = iConsecutivoE;// + 1;
			String strFolioEntrada = strAnio + "/"
					+ Utilerias.getAgregarCeros(countE);
			countE = countE + 1;
			bActualizaConse = ActualizaArea.actualizaEntrada(countE,
					strIdArea[0][0]);
			bActualizaFolioEnt = ActualizaAsunto.setFolioEntrada(
					strFolioEntrada, strIdAsunto);
		}
		// **fin asignación de folio de entrada

		int iSecuencia = new Integer(strTimeInstruc[0][1]).intValue();
		for (int y = 0; y < strTimeInstruc.length; y++) {
			int iSecuencia1 = new Integer(strTimeInstruc[y][1]).intValue();
			if (iSecuencia1 > iSecuencia)
				break;
			String fol = strGetFolio + "-" + (y + 1);
			boolean bFol = ActualizaInstrucciones.UpdateFolioInstruccion(
					strTimeInstruc[y][2], fol/* , strFolioSalida */);
		}// Fin asignación de Folio
		// Turna la instrucción o instrucciones que tengan el paso 1
		for (int i = 0; i < strTimeInstruc.length; i++) {
			int s = Integer.parseInt(strTimeInstruc[i][1]);
			if (s > iSecuencia)
				break;
			iSecuencia = s;
			strFechaFin = Utilerias.getFechaTerminacionInst(
					(Calendar) cFechaInicio.clone(), strTimeInstruc[i][0]);
			String strIdInstruccion = strTimeInstruc[i][2];
			Calendar FI = Utilerias.StringCalendar2(strFechaInicio);
			Calendar FF = Utilerias.StringCalendar2(strFechaFin);
			int iDuracion = Utilerias.getSinDiasFestivos(FI, FF);
			String strDuracion = String.valueOf(iDuracion);
			strFechaFin = Utilerias.getFechaTerminacionInst((Calendar) FF
					.clone(), strDuracion);
			int diferencia = Utilerias.DiasdeTrabajoEntre(
					(Calendar) (cFechaInicio.clone()), Utilerias
							.StringCalendar2(strFechaFin), 0);
			String nombreInst = "";
			int iBandera = -1;
			if (strTimeInstruc[i][7] != null
					&& strTimeInstruc[i][7].length() > 0) {
				nombreInst = ActualizaInst
						.getNombreInstruccion1(strTimeInstruc[i][7]);
				iBandera = 0;
			}

			bActualizaInstruccion = ActualizaInstrucciones
					.UpdateInstruccionTurnado(strIdInstruccion, strFechaInicio,
							strFechaFin, strTurno, strIdAreaOrigen,
							strTimeInstruc[i][6], iBandera, nombreInst);
			bActualizaAsunto = ActualizaAsuntoTurnado
					.ActualizaIDEstatus(strIdAsunto);

			// ** Envio de mail para notificar que se le ha asignado una
			// instrucción
			if (BUsuario.getTurnar()) {

				SenderMail notificar = new SenderMail();
				try {
					if (ActualizaUsuario
							.getNotificacionMail(strTimeInstruc[i][3])) {

						String strUsuEnviar[][] = ActualizaUsuario
								.getUsuario(strTimeInstruc[i][3]);
						String usuarioNombre = "";
						String usuarioCorreo = "";
						int tipoAtencion = Integer
								.parseInt(strTimeInstruc[i][8]);
						if (strUsuEnviar != null
								&& strUsuEnviar[0][0].length() > 0) {
							usuarioNombre = strUsuEnviar[0][2];
							usuarioCorreo = strUsuEnviar[0][3];
						}
						notificar.sendNotificarInstruccionAsignada(BUsuario
								.getCargo()
								+ "/" + BUsuario.getNombre(), usuarioNombre,
								usuarioCorreo, strIdInstruccion, tipoAtencion,
								SN, request.getContextPath(), request
										.getSession().getServletContext());
					}
				} catch (MessagingException me) {
				} catch (UnsupportedEncodingException uee) {
				}
			}
		}

		// Inserta los descriptivos de los asuntos
		boolean bExisteDes = ActualizaAsuntoTurnado.getExisteDes(strIdAsunto);
		if (!bExisteDes) {
			String strControl = ActualizaAsuntoTurnado.getControl(strIdAsunto);
			String strDatos[][] = ActualizaAsuntoTurnado.getDatosDescripcion(
					strIdAsunto, strControl);
			String strTur[][] = ActualizaAsuntoTurnado
					.getDatosTurnador(strIdAsunto);

			if (strDatos.length == 0)
				strDatos = new String[0][2];
			if (strTur.length == 0)
				strTur = new String[0][2];

			String strTramite = "";
			String strExpediente[][] = null;
			String strExp = "";
			if (strDatos[0][7].length() != 0)
				strTramite = ActualizaTramite.getNombreTramite(strDatos[0][7]);
			else
				strTramite = "No tiene Trámite";

			if (strDatos[0][8].length() != 0) {
				strExpediente = ActualizaExpediente
						.getNombreExpediente(strDatos[0][8]);
				strExp = strExpediente[0][0];
			} else
				strExp = "No tiene Expediente Asignado";

			String strAreaRep = ActualizaArea.NombreArea(strDatos[0][10]);

			String strUrsCap = ActualizaUsuario.NombreUsuario(strDatos[0][9]);
			boolean bInsetDes = ActualizaAsuntoTurnado
					.insertAsuntoDescriptivos(strIdAsunto, strAreaRep,
							strDatos[0][0], strDatos[0][1], strDatos[0][2],
							strDatos[0][3], strControl, strTur[0][0],
							strTur[0][1], strTur[0][2], strDatos[0][4], strExp,
							strTramite, strDatos[0][5], strDatos[0][6],
							strUrsCap);

			boolean bInsertDest = ActualizaAsuntoTurnado
					.insertDescriptivosDest(strIdAsunto, strDatos[0][11],
							strDatos[0][12], strDatos[0][13]);
		}
		// Fin Inserta los descriptivos de los asuntos

		// Se calcula el tiempo estimado del asunto
		int iTiempoEstimado = 0;
		for (int i = 0; i < strTimeInstruc.length; i++) {
			iTiempoEstimado += new Integer(strTimeInstruc[i][0]).intValue();
		}
		String strFechaCaptura = ActualizaAsunto
				.getFechaInicioAsunto(strIdAsunto);
		Calendar cFechaCaptura = Utilerias.StringCalendar(strFechaCaptura);
		String strFechaEstimada = Utilerias.getFechaTerminacionInst(
				(Calendar) cFechaCaptura.clone(), String
						.valueOf(iTiempoEstimado));
		Calendar cFechaEstimada = Utilerias.StringCalendar2(strFechaEstimada);
		int iSinDiasFest = Utilerias.getSinDiasFestivos(cFechaCaptura,
				cFechaEstimada);
		String strFechaFinalEst = Utilerias
				.getFechaTerminacionInst((Calendar) cFechaEstimada.clone(),
						String.valueOf(iSinDiasFest));
		boolean bActFecEst = ActualizaAsuntoTurnado.getUpdateFechaEstimada(
				strIdAsunto, strFechaFinalEst);
		// Fin del calculo del tiempo estimado del asunto

		String strFolio = ActualizaAsunto.getFolioAsunto(strIdAsunto);
		bInsertarBit = ActualizaBitacora.InsertarEventoTurnar(BUsuario
				.getIdUsuario(), strFolio);
		// return true;
	}

}
