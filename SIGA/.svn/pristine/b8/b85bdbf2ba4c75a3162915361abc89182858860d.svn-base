package com.meve.sigma.beans;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

//import com.meve.sigma.actualiza.ActualizaAsuntoTurnado;
//import com.meve.sigma.actualiza.ActualizaBitacora;
import com.meve.sigma.actualiza.ActualizaArea;
import com.meve.sigma.actualiza.ActualizaAsunto;
import com.meve.sigma.actualiza.ActualizaBitacora;
import com.meve.sigma.actualiza.ActualizaInstrucciones;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.reportes.ActualizaInst;
import com.meve.sigma.util.CalculoAvance;
import com.meve.sigma.util.SenderMail;
import com.meve.sigma.util.Utilerias;

/**
 * Se encarga de turnar instrucciones de una instrucción cuando esta en Trámite
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class TurnarNew {
	/**
	 * Turna nuevo asunto
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
	 * @param strIdAreaOrigen
	 *            id de área origen
	 * @return una bandera que indica la inserción exitosa
	 */
	public boolean turnarInstrucciones1(HttpServletRequest request,
			UsuarioBean BUsuario, String Smail, String PMail, String SN,
			String strIdAreaOrigen) {
		String strFechaFin = "";
		String strIdAsunto = "";
		String strFechaInicio = "";
		String strAnio = "";
		// int iNuevos = 0;

		int ns = 1;
		int req1 = 1;

		boolean bActualizaInstruccion = false;
		boolean bActualizaAsunto = false;
		boolean bInsertarBit = false;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date f = new Date();
		strFechaInicio = sdf.format(f);

		/*
		 * SimpleDateFormat anio = new SimpleDateFormat("yyyy"); Date dAnio =
		 * new Date(); strAnio = anio.format(dAnio);
		 */

		strIdAsunto = request.getParameter("id_asunto");
		String strTurno = ActualizaAsunto.getAsuntoTurnado(strIdAsunto);
		String horariosArea[][] = ActualizaArea.getHorarioUsuario(strTurno);
		strFechaInicio = Utilerias.getFechaInicio(strFechaInicio,
				horariosArea[0][1], horariosArea[0][2]);
		Calendar cFechaInicio = Utilerias.StringCalendar2(strFechaInicio);
		String strTimeInstruc[][] = ActualizaInstrucciones
				.getTimeInstrucciones(strIdAsunto);// secuencia con estatus 0
		String CountFolio = ActualizaInstrucciones
				.getFolioUltimoFormado(strIdAsunto);// numero total de
		// instrucciones ya
		// generadas
		String strFolio = ActualizaInstrucciones.getFolioRecepcion(strIdAsunto);// folio
		// del
		// asunto

		// **asignación de folio de entrada
		boolean bExisteFolioEntrada = false;
		boolean bActualizaConse = false;
		boolean bActualizaFolioEnt = false;
		String[][] strIdArea = ActualizaAsunto.getAreaFoleo(strIdAsunto);
		strAnio = ActualizaArea.getSalida(strIdArea[0][0]);
		// Se asigna el folio a las instrucciones que tiene el paso n

		int iNum = new Integer(CountFolio).intValue();
		int iSecuencia = new Integer(strTimeInstruc[0][1]).intValue();

		// Turna la instrucción o instrucciones que tengan el paso n
		for (int i = 0; i < strTimeInstruc.length; i++) {
			int s = Integer.parseInt(strTimeInstruc[i][1]);
			if (s > iSecuencia)
				break;
			// ns = s;

			iNum++;
			String fol = strFolio + "-" + (iNum);
			boolean bFol = ActualizaInstrucciones.UpdateFolioInstruccion(
					strTimeInstruc[i][2], fol/* , strFolioSalida */);
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
							strFechaFin, BUsuario.getIdUsuario(),
							strIdAreaOrigen, strTimeInstruc[i][6], iBandera,
							nombreInst);
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
		// **Calculo Avance General
		CalculoAvance cAvance = new CalculoAvance();
		cAvance.calculoAvanceGeneral(strIdAsunto);
		// **Fin Calculo Avance General
		String strFolioBit = ActualizaAsunto.getFolioAsunto(strIdAsunto);
		bInsertarBit = ActualizaBitacora.InsertarEventoTurnar(BUsuario
				.getIdUsuario(), strFolioBit);
		return true;
	}
}
