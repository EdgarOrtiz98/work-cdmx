/*
 * Creado el 27/06/2006
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.meve.sigma.actualiza.ActualizaAsunto;
import com.meve.sigma.actualiza.ActualizaInstrucciones;
import com.meve.sigma.reportes.ActualizaInst;

/**
 * Clase que contruye y envia los mails o notificaciones a multiples usuarios
 * 
 * @author Meve Soluciones SA de CV
 * @deprecated
 */
public class SendMailMultiple {

	/**
	 * Constructor SendMailMultiple()
	 * 
	 */
	public SendMailMultiple() {
	}

	/**
	 * Método que envia los mails multiple a los usuarios
	 * 
	 * @param toUsers
	 *            Usuarios
	 * @param _respuesta
	 *            respuesta
	 * @param mailFrom
	 *            mail
	 * @param _strIdInstruccion
	 *            id instrucción
	 * @param SMail
	 *            Servidor mail
	 * @param PMail
	 *            Puesto salida mail
	 * @param SN
	 *            Nombre servidor
	 * @param _strRutaBase
	 *            Contexto aplicación
	 * @param strIdAsunto
	 *            Id asunto
	 * @param iHija
	 *            Hija
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 * @deprecated
	 */
	public void sendNotificar(Vector toUsers, String _respuesta,
			String mailFrom, String _strIdInstruccion, String SMail,
			String PMail, String SN, String _strRutaBase, String strIdAsunto,
			int iHija) throws MessagingException, UnsupportedEncodingException {
		try {
			Properties props = System.getProperties();
			props = new Properties();

			String strAsunto[][] = ActualizaAsunto.getAsuntos(strIdAsunto);
			String strInstrucciones[][] = ActualizaInstrucciones
					.getInstruccionDatos(_strIdInstruccion);

			String strAsunto1 = strAsunto[0][5];
			String strFolio = strAsunto[0][23];
			String strInstruccion = strInstrucciones[0][1];
			String strInstruccionOtro = strInstrucciones[0][9];
			String strAvance = strInstrucciones[0][20];
			String strNombreInstruccion = "";
			String strHabilitado = "";

			// Verifica la bandera de habilitado - 0=Atender, 1=para turnar
			strHabilitado = ActualizaInstrucciones
					.getHabilitado(_strIdInstruccion);

			if (strInstruccion.length() == 0)
				strNombreInstruccion = strInstruccionOtro;
			else
				strNombreInstruccion = ActualizaInst
						.getNombreInstruccion1(strInstruccion);

			props.put("mail.smtp.host", SMail);
			props.put("mail.port", PMail);
			props.put("mail.store.protocol", "smtp");
			props.put("mail.transport.protocol", "smtp");

			Session session = Session.getDefaultInstance(props, null);

			MimeMessage message = new MimeMessage(session);

			HashMap toAddresses = new HashMap();
			HashMap ccAddresses = new HashMap();

			StringBuffer sb = new StringBuffer();

			sb.append("Saludos!\n");
			sb.append("\nAsunto: " + strAsunto1 + " \n");
			sb.append("Folio: " + strFolio + " \n");
			sb.append("Instruccion: " + strNombreInstruccion + "  \n");
			sb.append("Respuesta a la instrucción: " + _respuesta + " \n");
			if (_respuesta.equals("100")) {
				sb.append("Avance de la instrucción: " + strAvance + "%  \n");
			} else {
				sb.append("La instrucción lleva un Avance del: " + strAvance
						+ "% \n");
			}
			if (strHabilitado.equals("0")) {
				if (iHija == 1) {
					sb.append("Consultar: " + SN + _strRutaBase
							+ "/jsp/InstruccionHija.jsp?id_ins="
							+ _strIdInstruccion + " \n");
					sb.append("\n");
				} else if (iHija == 0) {
					sb.append("Consultar: " + SN + _strRutaBase
							+ "/jsp/InstruccionesAtender.jsp?id_ins="
							+ _strIdInstruccion + " \n");
					sb.append("\n");
				}
			} else if (strHabilitado.equals("1")) {
				sb.append("Consultar: " + SN + _strRutaBase
						+ "/jsp/InstruccionTurnada.jsp?id_ins="
						+ _strIdInstruccion + " \n");
				sb.append("\n");
				// //System.err.println("Consultar:
				// "+SN+_strRutaBase+"/jsp/InstruccionTurnada.jsp?id_ins="+_strIdInstruccion);
			}

			message.setContent(sb.toString(), "text/plain; charset=iso-8859-1");
			message.setSubject("información de avance de la instrucción: "
					+ strNombreInstruccion + " ");

			// Address address = new InternetAddress(mailFrom);
			Address address = new InternetAddress("siga@hacienda.gob.mx",
					"Sistema Integral de gestión Administrativa");
			message.setFrom(address);

			Vector TO = toUsers;
			if (TO.size() > 0 && TO != null) {
				// String CC[][] = getMailsCC();
				for (int i = 0; i < TO.size(); i++) {
					toAddresses.put(TO.elementAt(i), "");
				}
				try {
					InternetAddress[] to = getAddresses(toAddresses);
					message.addRecipients(Message.RecipientType.TO, to);

				} catch (Exception e) {
					// System.out.println("error mail-->"+e);
				}
			} else {
				Address toAddress = new InternetAddress("@");
				message.addRecipient(Message.RecipientType.TO, toAddress);
			}

			Transport.send(message);

		} catch (Exception e) {
		}
	}

	/**
	 * Agrega al InternetAddress[] los mails a enviar
	 * 
	 * @param addresses
	 *            Hasmap que contiene los mail a enviar
	 * @return Arreglo de los mails
	 * @throws Exception
	 * @deprecated
	 */
	private InternetAddress[] getAddresses(HashMap addresses) throws Exception {

		InternetAddress address = null;
		ArrayList list = new ArrayList();
		String name = null;
		String email = null;
		Iterator i = addresses.keySet().iterator();

		while (i.hasNext()) {
			email = (String) i.next();
			// email = (String) addresses.get(name);

			try {
				list.add(new InternetAddress(email));
			} catch (Exception ex) {
				// System.out.println("Dirección de correo inválida: " + email);
			}
		}

		if (list.isEmpty()) {
			return null;
		}

		InternetAddress all[] = new InternetAddress[list.size()];
		all = (InternetAddress[]) list.toArray(all);
		return all;
	}
}
