/*
 * Clase:						TurnarInstruccionBean.java
 * 
 * Paquete:						com.meve.sigma.beans		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Dec 12, 2005
 * 
 * @author: 					Rodrigo Soto Ch.
 * 								rodrigo_s_ch@yahoo.com.mx, rodrigo.soto.ch@gmail.com
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		Clase que se encarga de turnar instrucciones de una instrucción
 */

package com.meve.sigma.beans;

/**
 * Clase que se encarga de turnar instrucciones de una instrucción
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
import gob.hacienda.cgtic.siga.Usuario;
import gob.hacienda.cgtic.siga.instruccion.Rechazo;

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
import com.meve.sigma.actualiza.ActualizaHistorial;
import com.meve.sigma.actualiza.ActualizaInstrucciones;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.util.CalculoAvance;
import com.meve.sigma.util.SenderMail;
import com.meve.sigma.util.Utilerias;

/**
 * Clase que se encarga de turnar instrucciones de una instrucción
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class

TurnarInstruccionBean {
	/**
	 * Se encarga de turnar instrucciones de una instrucción
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
	 *            id de área origen
	 * @param strBandera
	 *            bandera
	 * @param strInformativa
	 *            secuencia informativa
	 */
	public void turnarInstOfInst(HttpServletRequest request,
			UsuarioBean BUsuario, String Smail, String PMail, String SN,
			String strBase, String strIdAreaOrigen, String strBandera,
			String strInformativa) {
		String strFechaFin = "";
		String strFechaInicio = "";
		String strIdInstPadre = "";
		String strIdAsunto = "";
		String strAvance = "";
		String strAnio = "";
		String strDatos[][] = null;
		String idUsuario = Usuario.esAsistente(BUsuario.getIdUsuario()) ? Usuario
				.aTitular(BUsuario.getIdUsuario())
				: BUsuario.getIdUsuario();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date f = new Date();
		strFechaInicio = sdf.format(f);
		strIdInstPadre = request.getParameter("id_ins");
		strDatos = ActualizaAsuntoTurnado.getAvanceInstTurnado(strIdInstPadre);
		strAvance = strDatos[0][0];
		strIdAsunto = strDatos[0][1];
		String horariosArea[][] = ActualizaArea.getHorarioUsuario(BUsuario
				.getIdUsuario());
		strFechaInicio = Utilerias.getFechaInicio(strFechaInicio,
				horariosArea[0][1], horariosArea[0][2]);
		Calendar cFechaInicio = Utilerias.StringCalendar2(strFechaInicio);

		// **asignación de folio de entrada
		boolean bExisteFolioEntrada = false;
		bExisteFolioEntrada = ActualizaInstrucciones
				.getExisteFolioEntradaInstruccion(strIdInstPadre);
		String[][] strIdArea = ActualizaInstrucciones
				.getAreaFoleo(strIdInstPadre);
		if (!bExisteFolioEntrada) {
			String strEntrada = ActualizaArea.getEntrada(strIdArea[0][0]);
			strAnio = ActualizaArea.getSalida(strIdArea[0][0]);
			int iConsecutivoE = new Integer(strEntrada).intValue();
			int countE = iConsecutivoE;
			String strFolioEntrada = strAnio + "/"
					+ Utilerias.getAgregarCeros(countE);
			countE = countE + 1;
			if (strBandera.equals("1")) {
				ActualizaArea.actualizaEntrada(countE, strIdArea[0][0]);
				ActualizaInstrucciones.setFolioEntrada(strFolioEntrada,
						strIdInstPadre);
			}
		}
		// **fin asignación de folio de entrada
		String strTimeInstruc[][] = ActualizaAsuntoTurnado
				.getInstHabilitarTur(strIdInstPadre);
		String strGetFolio = ActualizaAsuntoTurnado
				.getFolioInstTur(strIdInstPadre);
		int iSecuencia = Integer.parseInt(strTimeInstruc[0][1].trim());

		// numero total de instrucciones ya generadas
		String CountFolio = ActualizaInstrucciones
				.getFolioUltimoFormadoInst(strIdInstPadre);
		int iNum = 0;
		if (!CountFolio.equals("0")) {
			iNum = new Integer(CountFolio).intValue();
		}
		// ** Se asigna a la instrucción un folio
		for (int y = 0; y < strTimeInstruc.length; y++) {
			int iSecuencia1 = new Integer(strTimeInstruc[y][1]).intValue();
			if (iSecuencia1 > iSecuencia)
				break;
			String fol = "";
			if (iNum == 0) {
				fol = strGetFolio + "-" + (y + 1);
			} else {
				iNum++;
				fol = strGetFolio + "-" + (iNum);
			}
			ActualizaInstrucciones.UpdateFolioInstruccion(strTimeInstruc[y][2],
					fol/* , strFolioSalida */);
		}// Fin asignación de Folio
		// Turna la instrucción o instrucciones que tengan el paso 1
		for (int i = 0; i < strTimeInstruc.length; i++) {
			int s = Integer.parseInt(strTimeInstruc[i][1]);
			if (s > iSecuencia)
				break;
			iSecuencia = s;
			strFechaFin = Utilerias.getFechaTerminacionInst(
					(Calendar) cFechaInicio.clone(), strTimeInstruc[i][0]);
			String nombreInst = strTimeInstruc[i][8];
			int iBandera = strTimeInstruc[i][8].length() > 0
					&& strTimeInstruc[i][8] != null ? 0 : -1;
			ActualizaInstrucciones.UpdateInstruccionTurnado(
					strTimeInstruc[i][2], strFechaInicio, strFechaFin,
					idUsuario, strIdAreaOrigen, strTimeInstruc[i][6], iBandera,
					nombreInst);
			ActualizaAsuntoTurnado.ActualizaIDEstatusInst(strIdInstPadre);

			// ** Envio de mail para notificar que se le ha asignado una
			// instrucción
			SenderMail notificar = new SenderMail();
			try {
				if (ActualizaUsuario.getNotificacionMail(strTimeInstruc[i][3])) {
					String strUsuEnviar[][] = ActualizaUsuario
							.getUsuario(strTimeInstruc[i][3]);
					int tipoAtencion = Integer.parseInt(strTimeInstruc[i][9]);
					String usuarioReceptor = "";
					if (strUsuEnviar != null && strUsuEnviar[0][0].length() > 0) {
						usuarioReceptor = strUsuEnviar[0][2];
					} else {
						usuarioReceptor = "";
					}
					notificar.sendNotificarInstruccionAsignada(BUsuario.getCargo() + "/"
							+ BUsuario.getNombre(), usuarioReceptor,
							strTimeInstruc[i][4], strTimeInstruc[i][2],
							tipoAtencion, SN, request.getContextPath(), request
									.getSession().getServletContext());
				}

			} catch (MessagingException me) {
			} catch (UnsupportedEncodingException uee) {

			}
		}
		// **Calculo Avance General
		if (strInformativa.equals("0")) {
			CalculoAvance cAvance = new CalculoAvance();
			cAvance.calculoAvanceInsPadre(strIdInstPadre);
			cAvance.calculoAvance(strIdAsunto, strIdInstPadre);
		}
		// **Fin Calculo Avance General
		if (BUsuario.getAsistente()) {
			try {
				ActualizaHistorial.InsertarHabilitado(strIdInstPadre,
						strIdAsunto, idUsuario, strAvance, strFechaInicio,
						BUsuario.getCargo() + " / " + BUsuario.getNombre()
								+ " en Nombre de "
								+ Rechazo.aNombre(BUsuario, strIdInstPadre));
			} catch (Exception e) {
				System.err.println("ReasignarRechazo-->" + e.getMessage());
			}
		} else
			ActualizaHistorial.InsertarHabilitado(strIdInstPadre, strIdAsunto,
					idUsuario, strAvance, strFechaInicio, BUsuario.getCargo()
							+ " / " + BUsuario.getNombre());
		String strFolioBit = ActualizaInstrucciones
				.getUltimoFolioTurnado(strIdInstPadre);
		ActualizaBitacora.InsertarEventoHabilitar(idUsuario, strFolioBit);

		strFolioBit = ActualizaAsunto.getFolioAsunto(strIdAsunto);
		ActualizaBitacora.InsertarEventoTurnar(idUsuario, strFolioBit);
	}

}
