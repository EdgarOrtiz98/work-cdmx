/*
 * Creado el 31/10/2006
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.beans;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import com.meve.sigma.actualiza.ActualizaArea;
import com.meve.sigma.actualiza.ActualizaAsuntoTurnado;
import com.meve.sigma.actualiza.ActualizaBitacora;
import com.meve.sigma.actualiza.ActualizaHistorial;
import com.meve.sigma.actualiza.ActualizaInstrucciones;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.reportes.ActualizaInst;
import com.meve.sigma.util.CalculoAvance;
import com.meve.sigma.util.SendMailMultiple;
import com.meve.sigma.util.SenderMail;
import com.meve.sigma.util.Utilerias;

/**
 * Responde a las Instrucciones Hijas
 * 
 * @author Meve Soluciones
 */
public class ResponderInstHija {

	/**
	 * Constructor por defecto
	 */
	public ResponderInstHija() {

	}

	/**
	 * Responde a las Instrucciones Hijas
	 * 
	 * @param request
	 *            solicitud
	 * @param BUsuario
	 *            Bean de usuario
	 * @param strTurnador
	 *            turnador
	 * @param Smail
	 *            servidor de correo
	 * @param PMail
	 *            puerto de servidor de correo
	 * @param SN
	 *            nombre de servidor
	 * @param strBase
	 *            contexto
	 * @param strBandera
	 *            bandera
	 */
	public void respuestaInstruccionHija(HttpServletRequest request,
			UsuarioBean BUsuario, String strTurnador, String Smail,
			String PMail, String SN, String strBase, String strBandera) {

		String strIdUsrResp = "";// Usuario que responde
		String strRespuesta = "";// Comentario a la respuesta
		String strResponderA = "";// Usuario al que se le quiere responder
		String strAvance = "";// Avance que le da el usuario a la respuesta
		String strIdUsuario = "";// Id del Usuario
		String strIdAsunto = "";// Id del Asunto al que pertenece la instrucción
		String strIdInstruccion = "";// Id de la instrucción
		String strEstatus = "";// Estatus de la instrucción
		String strFechaCreacion = "";// Fecha de Creación de la respuesta
		String Avance1 = "";// Avance original de la instrucción
		String firmarDigitalmente = "";// FIrma digital
		String correo = "";// Correo del Usuario
		String sec = "";// Secuencia de la instrucción
		String idPadre = "";
		String strUsrOrg = "";
		String strAnio = "";

		int count = 0;// Variable para inicializar un contador

		boolean bInsertar = false;// Inserta la respuesta de la instrucción
		boolean bActualizarAvance = false;// Actualiza el avance de la
		// instrucción
		boolean bInstruccionNext = false;// Para verificar si tiene otras
		// instrucciones
		boolean bInstruccionNext1 = false;// Para verificar si tiene otras
		// instrucciones
		boolean bInsertarBitacora = false;// Actualiza events en la bitacora
		boolean bActualizaFechas = false;// Actualiza Fechas
		boolean bEsHijo = false;// Verifica si la instrucción es hija

		String countRequeridos[][] = null;
		String strCount[][] = null;
		String strSum[][] = null;
		String countSinTurnar = null;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date f = new java.util.Date();
		strFechaCreacion = sdf.format(f);

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date f1 = new java.util.Date();
		String strFechaReal = sdf1.format(f1);

		/*
		 * SimpleDateFormat anio = new SimpleDateFormat("yyyy"); java.util.Date
		 * dAnio = new java.util.Date(); strAnio = anio.format(dAnio);
		 */
		String horariosArea[][] = ActualizaArea.getHorarioUsuario(strTurnador);
		strFechaCreacion = Utilerias.getFechaInicio(strFechaCreacion,
				horariosArea[0][1], horariosArea[0][2]);
		strRespuesta = request.getParameter("contestar");
		strResponderA = request.getParameter("responderA");
		strAvance = request.getParameter("responderAvance");
		strIdUsuario = request.getParameter("idUsuario");
		strIdAsunto = request.getParameter("id_asunto");
		strIdInstruccion = request.getParameter("id_ins");
		strEstatus = request.getParameter("id_es");
		Avance1 = request.getParameter("ava");
		firmarDigitalmente = request.getParameter("firmaDigital");
		strUsrOrg = request.getParameter("us_or");

		// strIdUsrResp = BUsuario.getIdUsuario();
		strIdUsrResp = strUsrOrg;

		// **Determina si la instruccion es informativa
		String strTipoAtencion = ActualizaAsuntoTurnado
				.getTipoAtencion(strIdInstruccion);
		float fin = 0;

		// ** Trae el ID del padre
		idPadre = ActualizaAsuntoTurnado.getIdPadre(strIdInstruccion);

		if (strTipoAtencion.equals("0")) {
			// ** trae el total de hijos que tiene el padre
			String countHijos[][] = ActualizaAsuntoTurnado
					.getCountInstruccionPadre(idPadre);

			// ** trae la suma de los avances de las instrucciones hijas
			String sumHijos[][] = ActualizaAsuntoTurnado
					.getSumInstruccionPadre(idPadre);

			float fAvance = new Float(Avance1).floatValue();
			float su = new Float(sumHijos[0][0]).floatValue();
			float a = new Float(strAvance).floatValue();
			float c = new Float(countHijos[0][0]).floatValue();
			float dif = a - fAvance;
			float total = (su + dif) / c;
			NumberFormat df = NumberFormat.getNumberInstance();
			df.setMaximumFractionDigits(2);
			String strTotalHijos = df.format(total);
			// ** actualiza el avance de la isntruccion padre
			// boolean bAct =
			// ActualizaAsuntoTurnado.ActualizaAvancePadre(idPadre,
			// strTotalHijos);

			// **Al actualizar el padre debe de desarrollarse una Función que
			// actualice el asunto
			// **Al actualizar el padre debe de desarrollarse una Función que
			// actualice el asunto

			// **Actualiza el Asunto General
			/*
			 * strCount =
			 * ActualizaAsuntoTurnado.getCountInstruccion(strIdAsunto); strSum =
			 * ActualizaAsuntoTurnado.getSumInstruccion(strIdAsunto); float su1=
			 * new Float(strSum[0][0]).floatValue(); float c1 = new
			 * Float(strCount[0][0]).floatValue(); float dif1 = su1/c1; float
			 * total2 = dif1; NumberFormat df1 =
			 * NumberFormat.getNumberInstance(); df.setMaximumFractionDigits(2);
			 * String strTotal = df.format(total2); boolean bAct1 =
			 * ActualizaAsuntoTurnado.ActualizaAvanceAsunto(strIdAsunto,
			 * strTotal);
			 */
			// **Fin Actualiza el Asunto General
			fin = new Float(strTotalHijos).floatValue();
		}
		Date fechaTerminacionReal = new Date(new java.util.Date().getTime());
		if (firmarDigitalmente != null
				&& firmarDigitalmente.equalsIgnoreCase("on"))
			firmarDigitalmente = "1";
		else
			firmarDigitalmente = "0";

		bInsertar = ActualizaHistorial.InsertarRespuesta(strIdInstruccion,
				strIdAsunto, strRespuesta, strIdUsrResp, strAvance,
				strFechaCreacion, BUsuario.getCargo() + " / "
						+ BUsuario.getNombre());

		bActualizarAvance = ActualizaInstrucciones.avanceInstruccionHija(
				strIdInstruccion, strAvance, strEstatus, firmarDigitalmente,
				fechaTerminacionReal.toString(), strIdUsrResp);

		if (strTipoAtencion.equals("0")) {
			// **Calculo Avance General
			CalculoAvance cAvance = new CalculoAvance();
			cAvance.calculoAvance(strIdAsunto, strIdInstruccion);
			// **Fin Calculo Avance General
		}

		// ** se actualiza el total de la instruccion padre al 99%
		if (fin >= 100) {
			/*
			 * bInsertar =
			 * ActualizaHistorial.InsertarRespuesta(strIdInstruccion,
			 * strIdAsunto, "instrucción Terminada", strIdUsrResp, "100",
			 * strFechaCreacion, BUsuario.getCargo());
			 */

			// ** Actualiza el estatus de la intruccion padre en estatus=2
			// ** y con un avance del del 99%
			boolean bAcP = ActualizaAsuntoTurnado
					.actualizaRespuestaPadre1(idPadre);

			boolean bInsertarPadre = ActualizaHistorial.InsertarRespuesta(
					idPadre, strIdAsunto,
					"Actualización de la instruccion Padre", strIdUsrResp,
					"99", strFechaCreacion, BUsuario.getCargo() + " / "
							+ BUsuario.getNombre());

		}

		// ** Se inserta en la bitacora lo que ha hecho el usuario, en este
		// ** caso una respuesta a una instrucción

		String msnBitacora = "Se respondió la instrucción con folio "
				+ ActualizaInstrucciones
						.getUltimoFolioTurnado(strIdInstruccion)
				+ " reportando un avance del " + Avance1 + "%";
		bInsertarBitacora = ActualizaBitacora.InsertarEventoResponder(BUsuario
				.getIdUsuario(), msnBitacora);

		// ** Verifica a que paso pertenece
		sec = ActualizaInstrucciones.getPasoPertenece(strIdInstruccion);

		// ** Manda el total de los pasos posibles a los que pertenece la
		// instrucción
		countRequeridos = ActualizaInstrucciones
				.getCountInstruccionesRequeridasPadre(idPadre, sec);

		// ** Se hace conversión del numero total de pasos existentes a un int
		count = new Integer(countRequeridos[0][0]).intValue();

		float iAvance = new Float(strAvance).floatValue();

		bInstruccionNext1 = ActualizaAsuntoTurnado
				.VerificarInstruccionesTurnarPadre(idPadre);

		// **Envio de Mail de respuesta
		if (true) {
			try {
				SenderMail notificar = new SenderMail();
				if (ActualizaUsuario.getNotificacionMail(ActualizaInstrucciones
						.getTurnador(strIdInstruccion))) {
					notificar.SendMailResponderHija(strIdAsunto,
							strIdInstruccion, SN, strBase, iAvance,
							strRespuesta, request.getSession()
									.getServletContext());
				}
			} catch (MessagingException me) {
				// System.err.println("Mensaje="+me.getMessage());
			} catch (UnsupportedEncodingException uee) {
				// System.err.println("Mensaje1="+uee.getMessage());
			}
		}
		// **Fin Envio de Mail de respuesta

		if (iAvance >= 100) {
			if (bInstruccionNext1) {
				// ** Verifica si las instrucciones tienes alguna secuencia que
				// tenga
				// ** una instruccion requerida
				if (count == 0) {

					Calendar cFechaInicio = Utilerias
							.StringCalendar2(strFechaCreacion);
					String strSecuencia[][] = ActualizaAsuntoTurnado
							.SecuenciaPasosInstruccionPadre(idPadre);
					int s1 = new Integer(strSecuencia[0][0]).intValue();
					int req1 = new Integer(strSecuencia[0][5]).intValue();

					// **asignación de folio de entrada
					boolean bExisteFolioEntrada = false;
					boolean bActualizaConse = false;
					boolean bActualizaFolioEnt = false;
					String strFolioSalida = "";
					bExisteFolioEntrada = ActualizaInstrucciones
							.getExisteFolioEntradaInstruccion(idPadre);
					String[][] strIdArea = ActualizaInstrucciones
							.getAreaFoleo(idPadre);
					if (!bExisteFolioEntrada) {
						String strEntrada = ActualizaArea
								.getEntrada(strIdArea[0][0]);
						// String strSalida =
						// ActualizaArea.getSalida(strIdArea[0][0]);
						strAnio = ActualizaArea.getSalida(strIdArea[0][0]);
						int iConsecutivoE = new Integer(strEntrada).intValue();
						int countE = iConsecutivoE;// + 1;

						/*
						 * int iConsecutivoS = new
						 * Integer(strSalida).intValue(); int countS =
						 * iConsecutivoS + 1;
						 */

						String strFolioEntrada = strAnio + "/" + countE;
						countE = countE + 1;
						// strFolioSalida = countS+"/"+strAnio;
						if (strBandera.equals("1")) {
							bActualizaConse = ActualizaArea.actualizaEntrada(
									countE, strIdArea[0][0]);
							// bActualizaConse =
							// ActualizaArea.actualizaSalida(countS,
							// strIdArea[0][0]);
							bActualizaFolioEnt = ActualizaInstrucciones
									.setFolioEntrada(strFolioEntrada, idPadre);
						}
					}
					// **fin asignación de folio de entrada

					for (int i = 0; i < strSecuencia.length; i++) {

						int s = new Integer(strSecuencia[i][0]).intValue();
						if (s > s1)
							break;

						String strFechaFin = Utilerias.getFechaTerminacionInst(
								(Calendar) cFechaInicio.clone(),
								strSecuencia[i][1]);

						// ** Asignacion de Folio
						// String strGetFolio1 =
						// ActualizaInstrucciones.getFolioRecepcion(strIdAsunto);
						// String strUltimoID =
						// ActualizaInstrucciones.getUltimoID(strIdAsunto);
						String strGetFolio = ActualizaInstrucciones
								.getUltimoFolioTurnado(strIdInstruccion);
						String num = strGetFolio
								.substring(strGetFolio.length() - 1);
						String strGetFolio1 = strGetFolio.substring(0,
								strGetFolio.length() - 2);
						int iNum = new Integer(num).intValue();
						String fol = strGetFolio1 + "-" + (iNum + 1);
						boolean bFol = ActualizaInstrucciones
								.UpdateFolioInstruccion(strSecuencia[i][2], fol/*
																				 * ,
																				 * strFolioSalida
																				 */);
						// ** Fin Asignación Folio

						// se manda a traer el id del area a la que pertenece el
						// asunto original
						String strIdAreaOrigenPadre = ActualizaInstrucciones
								.getIdAreaOrigenInst(idPadre);

						String nombreInst = "";
						int iBandera = -1;
						if (strSecuencia[i][7] != null
								&& strSecuencia[i][7].length() > 0) {
							nombreInst = ActualizaInst
									.getNombreInstruccion1(strSecuencia[i][7]);
							iBandera = 0;
						}

						// ** Actualiza la siguiente instruccion
						bActualizaFechas = ActualizaInstrucciones
								.UpdateInstruccionTurnado(strSecuencia[i][2],
										strFechaCreacion, strFechaFin,
										strTurnador, strIdAreaOrigenPadre,
										strSecuencia[i][6], iBandera,
										nombreInst);

						// ** Envio de mail para notificar que se le ha asignado
						// una instrucción
						try {
							SenderMail notificar = new SenderMail();
							if (ActualizaUsuario
									.getNotificacionMail(strSecuencia[i][3])) {
								String strUsuEnviar[][] = ActualizaUsuario
										.getUsuario(strSecuencia[i][3]);
								String usuarioNombre = "";
								String usuarioCorreo = "";
								int tipoAtencion = Integer
										.parseInt(strSecuencia[i][7]);
								if (strUsuEnviar != null
										&& strUsuEnviar[0][0].length() > 0) {
									usuarioNombre = strUsuEnviar[0][2];
									usuarioCorreo = strUsuEnviar[0][3];
								}
								notificar.sendNotificarInstruccionAsignada(
										BUsuario.getCargo() + "/"
												+ BUsuario.getNombre(),
										usuarioNombre, usuarioCorreo,
										strIdInstruccion, tipoAtencion, SN,
										request.getContextPath(), request
												.getSession()
												.getServletContext());
							}
						} catch (MessagingException me) {
						} catch (UnsupportedEncodingException uee) {
						}
						// ** Fin de envio de mail
					}
				}
			}
		}

		// **Envio de mail de notificación

		if (strResponderA.length() != 0) {
			String UsrMailResponde = BUsuario.getCorreo();
			StringTokenizer st = new StringTokenizer(strResponderA, ",");

			Vector vprueba = new Vector();
			while (st.hasMoreTokens()) {
				vprueba.add(st.nextToken());
			}

			SenderMail senderMail = new SenderMail();
			try {
				senderMail.sendNotificar(vprueba, strRespuesta,
						UsrMailResponde, strIdInstruccion, SN, strBase,
						strIdAsunto, 1, request.getSession()
								.getServletContext());
			} catch (MessagingException me) {
				// System.err.println("Mensaje="+me.getMessage());
			} catch (UnsupportedEncodingException uee) {
				// System.err.println("Mensaje1="+uee.getMessage());
			}
			/** Fin envio mail * */
		} else {
			// System.err.println("No se envia mail de aviso");
		}
	}// **Fin Envio de mail de notificación

}
