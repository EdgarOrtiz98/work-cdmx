package com.meve.sigma.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContext;

import com.ienjinia.mail.MailTask;
import com.ienjinia.mail.TaskQueue;
import com.ienjinia.mail.TaskQueues;
import com.meve.sigma.actualiza.ActualizaAsunto;
import com.meve.sigma.actualiza.ActualizaAsuntoTurnado;
import com.meve.sigma.actualiza.ActualizaHistorial;
import com.meve.sigma.actualiza.ActualizaInstrucciones;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.catalogos.Catalogos;
import com.meve.sigma.organizacional.EstructuraOrganizacional;
import com.meve.sigma.organizacional.vo.PuestoVO;
import com.meve.sigma.reportes.ActualizaInst;
import com.meve.util.DateFormatter;

/**
 * Clase que contruye y envia los mails o notificaciones de los diferenctes
 * eventos del sistema, como: responder, delegar, reasignar, crear asuntos, etc
 * 
 * @author Meve Soluciones SA de CV
 */
public class SenderMail {

	/**
	 * Nombre del Turnador
	 */
	private String nombreTurnador = null;

	/**
	 * Mail del Turnador
	 */
	private String mailTurnador = null;

	/**
	 * Nombre del usuario que rechaza la instrucción
	 */
	private String nombre = null;

	/**
	 * Mail del usuario que rechaza la instrucción
	 */
	private String mail = null;

	/**
	 * Comentario a una respuesta, Razón de rechazo, Delegación, reasignación y
	 * habilitado de turnado
	 */
	private String Razon = null;

	/**
	 * Nombre de la instrucción
	 */
	private String NombreI = null;

	/**
	 * Nombre del Asunto al que pertenece la instrucción
	 */
	private String Asunto = null;

	/**
	 * Avance de una instrucción
	 */
	private String Avance = null;

	/**
	 * Id instrucción
	 */
	private String IdInstruccion = null;

	/**
	 * Servidor mail
	 */
	private String serverMail = null;

	/**
	 * Puerto mail
	 */
	private String portMail = null;

	/**
	 * Nombre del servidor
	 */
	private String serverName = null;

	/**
	 * Contexto de la aplicación
	 */
	private String strRutaBase = null;

	/**
	 * Contructor SenderMail()
	 * 
	 */
	public SenderMail() {

	}

	/**
	 * Constructor que inicializa valores para una Razon de Rechazo
	 * 
	 * @param nombreT
	 *            String Contiene el nombre del turnador
	 * @param mailT
	 *            String Contiene el mail del turnador
	 * @param nombreE
	 *            String Contiene el Nombre del usuario que esta rechazando la
	 *            instrución
	 * @param mailE
	 *            String Contiene el mail del usuario que esta rechazando la
	 *            instrución
	 * @param razon
	 *            String Contiene la razon de rechazo de la instrucción
	 * @param instruccion
	 *            String Contiene el nombre de la instrucción
	 * @param asunto
	 *            String Contiene el nombre del Asunto al que pertenece la
	 *            instrucción
	 */
	public SenderMail(String nombreT, String mailT, String nombreE,
			String mailE, String razon, String instruccion, String asunto,
			String stridInstruccion, String _ServerMail, String _PortMail,
			String _serverName, String _strRutaBase) {

		nombreTurnador = nombreT;
		mailTurnador = mailT;
		nombre = nombreE;
		mail = mailE;
		Razon = razon;
		NombreI = instruccion;
		Asunto = asunto;
		IdInstruccion = stridInstruccion;
		serverMail = _ServerMail;
		portMail = _PortMail;
		serverName = _serverName;
		strRutaBase = _strRutaBase;
	}

	/**
	 * Constructor que inicializa valores para Responder el avance de una
	 * instrucción
	 * 
	 * @param _nombreD
	 *            Nombre destinatario
	 * @param _mailD
	 *            mail destinatario
	 * @param _nombreR
	 *            Nombre remitente
	 * @param _mailR
	 *            Mail remitente
	 * @param _respuesta
	 *            respuesta de la instrucción
	 * @param _avance
	 *            avance
	 * @param _idInstruccion
	 *            Id instrucción
	 * @param _ServerMail
	 *            Nombre del servidor mail
	 * @param _PortMail
	 *            Puesto salida mail
	 * @param _serverName
	 *            Nombre del servidor
	 * @param _strRutaBase
	 *            Contexto aplicación
	 */
	public SenderMail(String _nombreD, String _mailD, String _nombreR,
			String _mailR, String _respuesta, String _avance,
			String _idInstruccion, String _ServerMail, String _PortMail,
			String _serverName, String _strRutaBase) {
		nombreTurnador = _nombreD;
		mailTurnador = _mailD;
		nombre = _nombreR;
		mail = _mailR;
		Razon = _respuesta;
		Avance = _avance;
		IdInstruccion = _idInstruccion;
		serverMail = _ServerMail;
		portMail = _PortMail;
		serverName = _serverName;
		strRutaBase = _strRutaBase;
	}

	/**
	 * Constructor que inicializa valores para notificar a un usuario que se le
	 * ha reasignado o delegado una instrucción
	 * 
	 * @param _nombreD
	 *            Nombre destinatario
	 * @param _mailD
	 *            mail destinatario
	 * @param _nombreR
	 *            Nombre remitente
	 * @param _mailR
	 *            Mail remitente
	 * @param _respuesta
	 *            respuesta de la instrucción
	 * @param _strIdInstruccion
	 *            Id instrucción
	 * @param _ServerMail
	 *            Nombre del servidor mail
	 * @param _PortMail
	 *            Puesto salida mail
	 * @param _serverName
	 *            Nombre del servidor
	 * @param _strRutaBase
	 *            Contexto aplicación
	 */
	public SenderMail(String _nombreD, String _mailD, String _nombreR,
			String _mailR, String _respuesta, String _strIdInstruccion,
			String _ServerMail, String _PortMail, String _serverName,
			String _strRutaBase) {
		nombreTurnador = _nombreD;
		mailTurnador = _mailD;
		nombre = _nombreR;
		mail = _mailR;
		Razon = _respuesta;
		IdInstruccion = _strIdInstruccion;
		serverMail = _ServerMail;
		portMail = _PortMail;
		serverName = _serverName;
		strRutaBase = _strRutaBase;
	}

	/**
	 * Instancia el Método sendEmail() para el envio de respuestas
	 * 
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void send(ServletContext context) throws MessagingException,
			UnsupportedEncodingException {
		sendEmail(context);
	}

	/**
	 * Instancia el Método SendMailResponder() para el envio de respuestas
	 * 
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendResponder(ServletContext context)
			throws MessagingException, UnsupportedEncodingException {
		SendMailResponder(context);
	}

	/**
	 * Instancia el Método SendMailDelegar() para la Delegación
	 * 
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendDelegacion(ServletContext context)
			throws MessagingException, UnsupportedEncodingException {
		SendMailDelegar(context);
	}

	/**
	 * Función que envia un correo electronico del usuario que ha rechazado la
	 * instrucción al usuario que le asigno originalmente la instrucción
	 */
	private void sendEmail(ServletContext context) {
		String subject = "Rechazo de instrucción!";
		StringBuffer sb = new StringBuffer();
		sb.append("Saludos!\n");
		sb.append("\nAsunto: " + Asunto + "\n");
		sb.append("Puesto: " + nombre + "\n");
		sb.append("instrucción: " + NombreI + ", \n");
		sb.append("Razón de Rechazo: " + Razon + "\n");
		sb.append("Consultar: " + serverName + strRutaBase
				+ "/jsp/InstruccionesAtender.jsp?id_ins=" + IdInstruccion
				+ " \n\n");
		sendMail(mailTurnador, subject, sb.toString(), context);
	}

	/**
	 * Función que envia un correo electronico a varios usuarios que haya
	 * seleccionado el usuario que respondio la instrucción
	 */
	private void SendMailResponder(ServletContext context) {

		String nombreAsunto = "";
		String nombreInstruccion = "";
		String strFolio = "";
		strFolio = ActualizaAsunto.getFolioAsuntoInst(IdInstruccion);
		String strAsuntoInstruccion[][] = ActualizaInstrucciones
				.getNombreInstruccion(IdInstruccion);
		nombreAsunto = strAsuntoInstruccion[0][0];
		if (strAsuntoInstruccion[0][1] != null
				&& strAsuntoInstruccion[0][1].length() != 0) {
			nombreInstruccion = ActualizaInst
					.getNombreInstruccion1(strAsuntoInstruccion[0][1]);
		} else {
			nombreInstruccion = strAsuntoInstruccion[0][2];
		}
		String subject = "";
		StringBuffer sb = new StringBuffer();
		sb.append("Saludos!\n");
		sb.append("\nAsunto: " + nombreAsunto + " \n");
		sb.append("Folio: " + strFolio + " \n");
		sb.append("Puesto: " + nombre + " \n");
		sb.append("instrucción: " + nombreInstruccion + "  \n");
		sb.append("Respuesta a la instrucción: " + Razon + " \n");
		if (Avance.equals("100")) {
			sb.append("Avance de la instrucción: " + Avance + "%  \n");
		} else {
			sb.append("La instrucción lleva un Avance del: " + Avance + "% \n");
		}
		sb.append("Consultar: " + serverName + strRutaBase
				+ "/jsp/InstruccionesAtender.jsp?id_ins=" + IdInstruccion
				+ " \n");
		sb.append("\n");
		if (Avance.equals("100")) {
			subject = "instrucción Terminada!";
		} else {
			subject = "Respuesta de instrucción!";
		}
		sendMail(mailTurnador, subject, sb.toString(), context);

	}

	/**
	 * Función que envia un correo electronico a la persona que se le ha
	 * reasignado la instrucción
	 */
	public void sendNotificarInstruccionReasignada(String receptorMail,
			String receptorNombre, String nombreReasigno, int idInstruccion,
			String razonReasignacion, ServletContext context) {
		String serverName = context.getInitParameter("servername");
		String strRutaBase = (context.getInitParameter("RutaBase") == null) ? ""
				: context.getInitParameter("RutaBase");
		String nombreAsunto = "";
		String nombreInstruccion = "";
		String strFolio = "";
		strFolio = ActualizaAsunto.getFolioAsuntoInst(String
				.valueOf(idInstruccion));
		String strAsuntoInstruccion[][] = ActualizaInstrucciones
				.getNombreInstruccion(String.valueOf(idInstruccion));
		nombreAsunto = strAsuntoInstruccion[0][0];
		if (strAsuntoInstruccion[0][1] != null
				&& strAsuntoInstruccion[0][1].length() != 0) {
			nombreInstruccion = ActualizaInst
					.getNombreInstruccion1(strAsuntoInstruccion[0][1]);
		} else {
			nombreInstruccion = strAsuntoInstruccion[0][2];
		}
		boolean bUrl = ActualizaAsuntoTurnado.getEsHijo(String
				.valueOf(idInstruccion));
		// Verifica la bandera de habilitado - 0=Atender, 1=para turnar
		String strHabilitado = ActualizaInstrucciones.getHabilitado(String
				.valueOf(idInstruccion));
		String subject = "instrucción Reasignada!";
		StringBuffer sb = new StringBuffer();
		sb.append("Saludos " + receptorNombre + ",\n");
		sb.append("\nEl usuario " + nombreReasigno);
		sb
				.append(", le Reasignó una instrucción con la siguiente información:\n");
		sb.append("\nDatos del asunto:\n");
		sb.append("   Folio: " + strFolio + "\n");
		sb.append("   Descripción: " + nombreAsunto + "\n");
		sb.append("\nDatos de la instrucción Reasignada:\n");
		sb.append("   Descripción:  " + nombreInstruccion + "\n");
		sb.append("   Razón de la asignación: " + razonReasignacion + " \n");
		if (strHabilitado.equals("0")) {
			if (bUrl) {
				sb.append("   Consultar en: " + serverName + strRutaBase
						+ "/jsp/InstruccionHija.jsp?id_ins=" + idInstruccion
						+ " \n");
			} else {
				sb.append("   Consultar en: " + serverName + strRutaBase
						+ "/jsp/InstruccionesAtender.jsp?id_ins="
						+ idInstruccion + " \n");
			}
		} else if (strHabilitado.equals("1")) {
			sb.append("   Consultar en: " + serverName + strRutaBase
					+ "/jsp/InstruccionTurnada.jsp?id_ins=" + idInstruccion
					+ " \n");
		}
		sb.append("\nFecha de registro: " + DateFormatter.getFechaActual());
		sendMail(receptorMail, subject, sb.toString(), context);

	}

	/**
	 * Función que envia un correo electronico a la persona que se le ha
	 * delegado la instrucción
	 */
	private void SendMailDelegar(ServletContext context) {

		String nombreAsunto = "";
		String nombreInstruccion = "";
		String strFolio = "";
		strFolio = ActualizaAsunto.getFolioAsuntoInst(IdInstruccion);
		String strAsuntoInstruccion[][] = ActualizaInstrucciones
				.getNombreInstruccion(IdInstruccion);
		nombreAsunto = strAsuntoInstruccion[0][0];
		if (strAsuntoInstruccion[0][1] != null
				&& strAsuntoInstruccion[0][1].length() != 0) {
			nombreInstruccion = ActualizaInst
					.getNombreInstruccion1(strAsuntoInstruccion[0][1]);
		} else {
			nombreInstruccion = strAsuntoInstruccion[0][2];
		}

		String subject = "";
		StringBuffer sb = new StringBuffer();
		sb.append("Saludos!\n");
		sb.append("\nDatos de la instrucción Delegada: \n");
		sb.append("Puesto que delego la instrución: " + nombre + " \n");
		sb.append("Asunto: " + nombreAsunto + "\n");
		sb.append("Folio: " + strFolio + "\n");
		sb.append("instrucción:  " + nombreInstruccion + "\n");
		sb.append("Comentario: " + Razon + " \n");
		sb.append("Consultar: " + serverName + strRutaBase
				+ "/jsp/InstruccionesAtender.jsp?id_ins=" + IdInstruccion
				+ " \n");
		sb.append("\n");
		sendMail(mailTurnador, subject, sb.toString(), context);
	}

	/**
	 * Notifica que la instrucción padre a notificado a sus subordinados el
	 * turnado de las instrucciones asignadas
	 * 
	 * @param strNotificador
	 *            Notificador
	 * @param strMailNotificador
	 *            Mail notificador
	 * @param strUsrEnviar
	 *            Usuario que se le envia la notificación
	 * @param strMailUsrEnviar
	 *            mail del usuario que se le envia la notificación
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @param strIDMail
	 *            Mail
	 * @param SN
	 *            Nombre del servidor
	 * @param _strRutaBase
	 *            Contexto aplicación
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendNotificarInstruccionAsignada(String notificadorNombre,
			String nombreReceptor, String mailReceptor,
			String strIdInstruccion, int tipoAtencion, String SN,
			String rutaBase, ServletContext context) throws MessagingException,
			UnsupportedEncodingException {
		String nombreAsunto = "";
		String nombreInstruccion = "";
		String strFolio = "";
		strFolio = ActualizaAsunto.getFolioAsuntoInst(strIdInstruccion);
		String strAsuntoInstruccion[][] = ActualizaInstrucciones
				.getNombreInstruccion(strIdInstruccion);
		nombreAsunto = strAsuntoInstruccion[0][0];
		if (strAsuntoInstruccion[0][1] != null
				&& strAsuntoInstruccion[0][1].length() != 0) {
			nombreInstruccion = ActualizaInst
					.getNombreInstruccion1(strAsuntoInstruccion[0][1]);
		} else {
			nombreInstruccion = strAsuntoInstruccion[0][2];
		}
		String subject = "asignación de instrucción!";
		StringBuffer sb = new StringBuffer();
		sb.append("Saludos " + nombreReceptor + ",\n");
		sb.append("\nEl usuario " + notificadorNombre);
		sb.append(", le ASIGNÁ una instrucción con la siguiente información:\n");
		sb.append("\nDatos del Asunto:\n");
		sb.append("   Folio: " + strFolio + "\n");
		sb.append("   Descripción: " + nombreAsunto + "\n");
		sb.append("\nDatos de la instrucción asignada:\n");
		sb.append("   Descripción: " + nombreInstruccion + " \n");
		sb.append("   Tipo: ");
		if (tipoAtencion == 0) {
			sb.append("Para su atención\n");
		} else {
			sb.append("Para su Conocimiento\n");
		}
		sb.append("   Consultar en: " + SN + rutaBase
						+ "/jsp/InstruccionHija.jsp?id_ins=" + strIdInstruccion
						+ " \n");
		sb.append("\nFecha de Registro: " + DateFormatter.getFechaActual());
		sendMail(mailReceptor, subject, sb.toString(), context);
	}

	/**
	 * Función que envia un mail al turnador que atendera o asignara las
	 * instrucciones para darle seguimiento al asunto
	 * 
	 * @param destinatario
	 *            Nombre del turnador
	 * @param mailDest
	 *            Correo del turnador
	 * @param remitente
	 *            Nombre del remitente
	 * @param mailRmt
	 *            Correo del Remitente
	 * @param Asunto
	 *            Nombre del Asunto
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendNotificarNuevoAsunto(String destinatario, String mailDest,
			String remitente, String mailRmt, String asunto, String SN,
			String strIdAsunto, String _strRutaBase, ServletContext context) {
		String strFolio = "folio por asignar";
		strFolio = ActualizaAsunto.getFolioAsunto(strIdAsunto);
		String subject = "Atender Nuevo Asunto!";
		StringBuffer sb = new StringBuffer();
		if (destinatario.indexOf("/")!=-1) {
			destinatario = destinatario.substring(0,
					destinatario.indexOf("/") - 1);
		}
		sb.append("Saludos " + destinatario + ",\n");
		sb.append("\nEl Remitente " + remitente
				+ ", ha solicitado que se atienda el siguiente Asunto:\n");
		sb.append("\nDatos del Asunto: \n");
		sb.append("   Folio: " + strFolio + "\n");
		sb.append("   Descripción: " + asunto + "\n");
		sb.append("   Consultar en: ");
		sb.append(SN + _strRutaBase + "/jsp/AsuntoTurnado.jsp?id_asunto="
				+ strIdAsunto + " \n");
		sb.append("\nFecha de registro: " + DateFormatter.getFechaActual());
		sb.append("\n");
		sendMail(mailDest, subject, sb.toString(), context);
	}

	/**
	 * notificación del turnado de un asunto
	 * 
	 * @param strIdUsuario
	 *            id usuario
	 * @param Asunto
	 *            Nombre asunto
	 * @param SN
	 *            Nombre del servidor
	 * @param strIdAsunto
	 *            id asunto
	 * @param _strRutaBase
	 *            Contexto aplicación
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendNotificacionAsuntoTurnado(String strIdUsuario,
			String asunto, String SN, String strIdAsunto, String _strRutaBase,
			ServletContext context) throws MessagingException,
			UnsupportedEncodingException {
		try {
			String strFolio = ActualizaAsunto.getFolioAsunto(strIdAsunto);
			String[][] datosReceptor = ActualizaUsuario
					.NombreMailUsuario(strIdUsuario);
			String mailReceptor = datosReceptor[0][1];
			String nombreReceptor = datosReceptor[0][2];
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date f = new Date();
			String FechaCreacion = sdf.format(f);
			String subject = "notificación de Turnado de un Asunto!";
			StringBuffer sb = new StringBuffer();
			sb.append("Saludos " + nombreReceptor + ",\n");
			sb.append("\nSe le notifica que ha sido turnado un asunto el Día "+ FechaCreacion+ 
					  ", con la siguiente información:\n");
			sb.append("\nDatos del Asunto Turnado:\n");
			sb.append("   Folio: " + strFolio + "\n");
			sb.append("   Descripción: " + asunto + "\n");
			sb.append("   Consultar: ");
			sb.append(SN + _strRutaBase + "/jsp/AsuntoTurnado.jsp?id_asunto="
					+ strIdAsunto + " \n");
			sb.append("\nFecha de registro:  " + DateFormatter.getFechaActual()+ "\n");
			sendMail(mailReceptor, subject, sb.toString(), context);
		} catch (Exception e) {
		}
	}

	/**
	 * Envia un mail de notificación en el cual se informa que la instrucción
	 * delegada ha respondido al 100% su avance
	 * 
	 * @param strNotificador
	 *            Notificador
	 * @param strMailNotificador
	 *            Mail notificador
	 * @param strUsrEnviar
	 *            Usuario que se le envia la notificación
	 * @param strMailUsrEnviar
	 *            mail del usuario que se le envia la notificación
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @param SN
	 *            Nombre del servidor
	 * @param _strRutaBase
	 *            Contexto aplicación
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendEnviarControl(String strNotificador,
			String strMailNotificador, String strUsrEnviar,
			String strMailUsrEnviar, String strIdInstruccion, String SN,
			String _strRutaBase, ServletContext context) {
		String nombreAsunto = "";
		String nombreInstruccion = "";
		String nombreInstruccionOtro = "";
		String strFolio = "";
		strFolio = ActualizaAsunto.getFolioAsuntoInst(strIdInstruccion);
		String strAsuntoInstruccion[][] = ActualizaInstrucciones
				.getNombreInstruccion(strIdInstruccion);
		nombreAsunto = strAsuntoInstruccion[0][0];
		if (nombreInstruccionOtro.length() <= 0
				|| nombreInstruccionOtro == null) {
			nombreInstruccion = strAsuntoInstruccion[0][1];
		} else {
			nombreInstruccion = strAsuntoInstruccion[0][2];
		}
		String subject = "terminación de instrucción Delegada!";
		StringBuffer sb = new StringBuffer();
		sb.append("Saludos!\n");
		sb.append("\nEl Puesto " + strNotificador
				+ " ha terminado de responder la instrucción Delegada: \n");
		sb.append("\nNombre del Asunto: " + nombreAsunto + "\n");
		sb.append("Folio: " + strFolio + "\n");
		sb.append("Nombre de la instrucción:  " + nombreInstruccion + "\n");
		sb.append("Consultar: " + SN + _strRutaBase
				+ "/jsp/InstruccionesAtender.jsp?id_ins=" + strIdInstruccion
				+ " \n");
		sb.append("\n");
		sendMail(strMailUsrEnviar, subject, sb.toString(), context);
	}

	/**
	 * Solicitud de cambio de fecha
	 * 
	 * @param Solicitante
	 *            Solicitante
	 * @param MailSolicitante
	 *            Mail Solicitante
	 * @param Tunador
	 *            Turnador
	 * @param MailTurnador
	 *            Mail turnador
	 * @param strIdInstruccion
	 *            id instrucción
	 * @param comentario
	 *            Comentarios
	 * @param SN
	 *            Nombre del servidor
	 * @param _strRutaBase
	 *            Contexto aplicación
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendSolCambioFechaInst(String solicitante,
			String MailSolicitante, String turnador, String MailTurnador,
			String strIdInstruccion, String comentario, String SN,
			String _strRutaBase, ServletContext context) {
		String nombreInstruccion = "";
		String strAsuntoInstruccion[][] = ActualizaInstrucciones
				.getNombreInstruccion(strIdInstruccion);
		if (strAsuntoInstruccion[0][2].length() <= 0
				|| strAsuntoInstruccion[0][2] == null) {
			nombreInstruccion = ActualizaInst
					.getNombreInstruccion1(strAsuntoInstruccion[0][1]);
		} else {
			nombreInstruccion = strAsuntoInstruccion[0][2];
		}
		String subject = "Solicitud de Cambio de fecha de la instrucción";
		StringBuffer sb = new StringBuffer();
		sb.append("Saludos " + turnador + ",\n");
		sb.append("\nLe informamos que " + solicitante);
		sb
				.append(", Solicita el cambio de fecha de la siguiente instrucción:\n");
		sb.append("\nDatos de la instrucción:\n");
		sb.append("   Folio: " + strAsuntoInstruccion[0][7] + "\n");
		sb.append("   Descripción: " + nombreInstruccion + "\n");
		sb.append("   Razón de Cambio: " + comentario + "\n");
		if (strAsuntoInstruccion[0][6].equals("1")) {
			sb.append("   Consultar en:   " + SN + _strRutaBase
					+ "/jsp/InstruccionTurnada.jsp?id_ins=" + strIdInstruccion
					+ " \n");
		} else {
			if (strAsuntoInstruccion[0][5].length() == 0) {
				sb.append("   Consultar en: \n   " + SN + _strRutaBase
						+ "/jsp/InstruccionesAtender.jsp?id_ins="
						+ strIdInstruccion + " \n");
			} else {
				sb.append("   Consultar en: \n   " + SN + _strRutaBase
						+ "/jsp/InstruccionHija.jsp?id_ins=" + strIdInstruccion
						+ " \n");
			}
		}
		sb.append("\nFecha de registro: " + DateFormatter.getFechaActual());
		sendMail(MailTurnador, subject, sb.toString(), context);

	}

	/**
	 * Notifica respuesta del cambio de fecha ya sea aceptada o rechazada
	 * 
	 * @param Turnador
	 *            Turnador
	 * @param MailTurnador
	 *            Mail turnador
	 * @param UsrEnviar
	 *            Destinatario
	 * @param MailUsrEnviar
	 *            Mail destinatario
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @param comentario
	 *            Comentario
	 * @param respuesta
	 *            Respuesta
	 * @param SN
	 *            Nombre del servidor
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendRespuestaCambioFecha(String turnador, String mailTurnador,
			String usrEnviar, String mailUsrEnviar, String strIdInstruccion,
			String comentario, int respuesta, String SN, ServletContext context) {
		String nombreInstruccion = "";
		String strAsuntoInstruccion[][] = ActualizaInstrucciones
				.getNombreInstruccion(strIdInstruccion);
		if (strAsuntoInstruccion[0][2].length() <= 0
				|| strAsuntoInstruccion[0][2] == null) {
			nombreInstruccion = ActualizaInst
					.getNombreInstruccion1(strAsuntoInstruccion[0][1]);
		} else {
			nombreInstruccion = strAsuntoInstruccion[0][2];
		}

		String strDatos[][] = ActualizaInstrucciones
				.getSolicitudCambio(strIdInstruccion);
		String subject = "";
		StringBuffer sb = new StringBuffer();
		// ** Si es aceptado el cambio de fecha, respuesta=1
		if (respuesta == 1) {
			subject = "Cambio de Fecha \"Aceptada\"";
			sb.append("Saludos " + usrEnviar + ", \n");
			sb.append("\nLe informamos que " + turnador);
			sb.append(", ha aceptado su solicitud de cambio de fecha de vencimiento para la siguiente instrucción: \n");
			sb.append("\nDatos de la instrucción:\n");
			sb.append("   Folio: " + strAsuntoInstruccion[0][7] + "\n");
			sb.append("   Descripción: " + nombreInstruccion + "\n");
			sb.append("   Nueva fecha de Vencimiento: "+ Utilerias.formatearFechas(strDatos[0][2]) + "\n");
			sb.append("   Comentarios adicionales: " + comentario+ "\n");
		} else if (respuesta == 2) {
			subject = "Cambio de Fecha \"Rechazada\"";
			sb.append("Saludos " + usrEnviar + ", \n");
			sb.append("\nLe informamos que " + turnador);
			sb.append(", ha rechazado el cambio de fecha de la siguiente instrucción: \n");
			sb.append("\nDatos de la instrucción rechazada:\n");
			sb.append("   Folio: " + strAsuntoInstruccion[0][7] + "\n");
			sb.append("   Descripción: " + nombreInstruccion + "\n");
			sb.append("   Razón del Rechazo: " + comentario+ "\n");
		}
		sb.append("\nFecha de Registro:" + DateFormatter.getFechaActual());
		sendMail(mailUsrEnviar, subject, sb.toString(), context);
	}

	/**
	 * Notifica al ciudadano al registrarse por primera vez al portal ciudadano
	 * 
	 * @param strNombre
	 *            Nombre del usuario
	 * @param strMail
	 *            Mail usuario
	 * @param strUsuario
	 *            Username
	 * @param strClave
	 *            Clave o password
	 * @param SN
	 *            Nombre del servidor
	 * @param _strRutaBase
	 *            Contexto aplicación
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendConfirmacionCiudadano(String strNombre, String strMail,
			String strUsuario, String strClave, String SN, String _strRutaBase,
			ServletContext context) throws MessagingException,
			UnsupportedEncodingException {

		String subject = "Inscripción al Portal de SIGA";
		StringBuffer sb = new StringBuffer();

		sb.append("Saludos!\n");
		sb.append("\nGracias por registrarte en SIGA \n");
		sb.append("" + strNombre + " \n");
		sb.append("Tu Cuenta de Usuario es: " + strUsuario + "  \n");
		sb.append("Tu Clave de Acceso es: " + strClave + " \n");
		sb.append(" \n");
		sb.append("Consultar: " + SN + _strRutaBase
				+ "/ciudadano/index.jsp  \n");
		sb.append(" \n");
		sendMail(strMail, subject, sb.toString(), context);
	}

	/**
	 * Notifica al ciudadano cuando hace algun cambio en sus datos registrados
	 * en el portal ciudadano
	 * 
	 * @param strNombre
	 *            Nombre del usuario
	 * @param strMail
	 *            Mail usuario
	 * @param strUsuario
	 *            Username
	 * @param strClave
	 *            Clave o password
	 * @param SN
	 *            Nombre del servidor
	 * @param _strRutaBase
	 *            Contexto aplicación
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendConfirmacionCiudadanoCambioPass(String strNombre,
			String strMail, String strUsuario, String strClave, String SN,
			String _strRutaBase, ServletContext context)
			throws MessagingException, UnsupportedEncodingException {
		String subject = "Cambio de Contraseña";
		StringBuffer sb = new StringBuffer();
		sb.append("Saludos!\n");
		sb.append("\nSe ha editado tu clave \n");
		sb.append("" + strNombre + " \n");
		sb.append("Tu Cuenta de Usuario es: " + strUsuario + "  \n");
		sb.append("Tu Nueva Clave de Acceso es: " + strClave + " \n");
		sb.append(" \n");
		sb.append("Consultar: " + SN + _strRutaBase
				+ "/ciudadano/index.jsp  \n");
		sb.append(" \n");
		sendMail(strMail, subject, sb.toString(), context);
	}

	/**
	 * Metodo q envia confirmacion de terminacion
	 * 
	 * @param strIdAsunto
	 *            id asunto
	 * @param strAsunto
	 *            Asunto
	 * @param strfoliom
	 *            Folio asunto
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendConfirmacionTerminado(String strIdAsunto, String strAsunto,
			String strfoliom, String strMail, ServletContext context)
			throws MessagingException, UnsupportedEncodingException {
		String subject = "Confirmación de Termino";
		StringBuffer sb = new StringBuffer();
		sb.append("Por&nbsp;medio de la presente manifiesto que el asunto "
				+ strAsunto + "\n");
		sb.append("con el Número de folio " + strfoliom + " \n");
		sb.append("ya ha sido terminado. \n");
		sb
				.append("\n A continuación se detalla el historial de las respuestas hacia la solicitud:  \n");
		sb.append(" \n");
		int iIndice = 0;
		String strDatos[][] = ActualizaInstrucciones
				.InstruccionPorIdAsunto(strIdAsunto);

		if (strDatos != null) {
			if (iIndice < strDatos.length) {

				for (int j = 0; j < strDatos.length; j++) {
					sb.append(strDatos[iIndice][7] + " ");
					String strDatos2[][] = ActualizaHistorial
							.getHistorialRespuestasPorInstruccion(strDatos[iIndice][11]);
					sb.append(strDatos2[0][1]);
					iIndice = iIndice + 1;
					sb.append(" \n");
				}

			}
		}
		sb.append(" \n");
		sendMail(strMail, subject, sb.toString(), context);
	}

	/**
	 * notificación de la respuesta de una instrucción
	 * 
	 * @param strIdAsunto
	 *            Id asunto
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @param SN
	 *            Nombre servidor
	 * @param strRuta
	 *            Contexto de la aplicación
	 * @param fAvance
	 *            Avance
	 * @param strRespuesta
	 *            Respuesta
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void SendMailResponder(String strIdAsunto, String strIdInstruccion,
			String SN, String strRuta, float fAvance, String strRespuesta,
			ServletContext context) throws MessagingException,
			UnsupportedEncodingException {
		String nombreAsunto = "";
		String nombreInstruccion = "";
		String strFolio = "";
		String strHabilitado = "";
		String strAsuntoInstruccion[][] = ActualizaInstrucciones
				.getNombreInstruccion(strIdInstruccion);
		String[][] datos = null;
		//datos = ActualizaUsuario.NombreMailUsuario(strAsuntoInstruccion[0][4]);
		datos = ActualizaUsuario.NombreMailUsuario(ActualizaInstrucciones.getTurnador(strIdInstruccion));
		
		strFolio = ActualizaAsunto.getFolioAsuntoInst(strIdInstruccion);
		nombreAsunto = strAsuntoInstruccion[0][0];
		// Verifica la bandera de habilitado - 0=Atender, 1=para turnar
		strHabilitado = ActualizaInstrucciones.getHabilitado(strIdInstruccion);
		if (strAsuntoInstruccion[0][1] != null
				&& strAsuntoInstruccion[0][1].length() != 0) {
			nombreInstruccion = ActualizaInst
					.getNombreInstruccion1(strAsuntoInstruccion[0][1]);
		} else {
			nombreInstruccion = strAsuntoInstruccion[0][2];
		}
		String subject = "";
		StringBuffer sb = new StringBuffer();
		sb.append("Saludos "+ datos[0][2]+"!\n");
		sb.append("\nAsunto: " + nombreAsunto + " \n");
		sb.append("Folio: " + strFolio + " \n");
		sb.append("Puesto: "
				+ ActualizaUsuario.NombrePuesto(strAsuntoInstruccion[0][3])
				+ " \n");
		sb.append("instrucción: " + nombreInstruccion + "  \n");
		sb.append("Respuesta a la instrucción: " + strRespuesta + " \n");
		if (fAvance >= 100) {
			sb.append("Avance de la instrucción: " + fAvance + "%  \n");
		} else {
			sb
					.append("La instrucción lleva un Avance del: " + fAvance
							+ "% \n");
		}
		if (strHabilitado.equals("0")) {
			sb.append("Consultar: " + SN + strRuta
					+ "/jsp/InstruccionesAtender.jsp?id_ins="
					+ strIdInstruccion + " \n");
		} else if (strHabilitado.equals("1")) {
			sb.append("Consultar: " + SN + strRuta
					+ "/jsp/InstruccionTurnada.jsp?id_ins=" + strIdInstruccion
					+ " \n");
		}
		sb.append("\n");
		if (fAvance >= 100) {
			subject = "instrucción Terminada!";
		} else {
			subject = "Respuesta de instrucción!";
		}
		sendMail(datos[0][1], subject, sb.toString(), context);

	}

	/**
	 * Envio de Mail para respuestas de instrucciones hijas
	 * 
	 * @param strIdAsunto
	 *            Id asunto
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @param SN
	 *            Nombre servidor
	 * @param strRuta
	 *            Contexto de la aplicación
	 * @param fAvance
	 *            Avance
	 * @param strRespuesta
	 *            Respuesta
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void SendMailResponderHija(String strIdAsunto,
			String strIdInstruccion, String SN, String strRuta, float fAvance,
			String strRespuesta, ServletContext context)
			throws MessagingException, UnsupportedEncodingException {
		String nombreAsunto = "";
		String nombreInstruccion = "";
		String strFolio = "";
		String strHabilitado = "";
		String[][] datos = null;
		String idPadre = ActualizaAsuntoTurnado.getIdPadre(strIdInstruccion);
		String strNombreTurno = ActualizaInstrucciones.getUsuario(idPadre);
		String strAsuntoInstruccion[][] = ActualizaInstrucciones
				.getNombreInstruccion(strIdInstruccion);

		datos = ActualizaUsuario.NombreMailUsuario(strNombreTurno);
		strFolio = ActualizaAsunto.getFolioAsuntoInst(strIdInstruccion);
		nombreAsunto = strAsuntoInstruccion[0][0];
		// Verifica la bandera de habilitado - 0=Atender, 1=para turnar
		strHabilitado = ActualizaInstrucciones.getHabilitado(strIdInstruccion);
		if (strAsuntoInstruccion[0][1] != null
				&& strAsuntoInstruccion[0][1].length() != 0) {
			nombreInstruccion = ActualizaInst
					.getNombreInstruccion1(strAsuntoInstruccion[0][1]);
		} else {
			nombreInstruccion = strAsuntoInstruccion[0][2];
		}
		String subject = "";
		StringBuffer sb = new StringBuffer();
		sb.append("Saludos!\n");
		sb.append("\nAsunto: " + nombreAsunto + " \n");
		sb.append("Folio: " + strFolio + " \n");
		sb.append("Puesto: "
				+ ActualizaUsuario.NombrePuesto(strAsuntoInstruccion[0][3])
				+ " \n");
		sb.append("instrucción: " + nombreInstruccion + "  \n");
		sb.append("Respuesta a la instrucción: " + strRespuesta + " \n");
		if (fAvance >= 100) {
			sb.append("Avance de la instrucción: " + fAvance + "%  \n");
		} else {
			sb
					.append("La instrucción lleva un Avance del: " + fAvance
							+ "% \n");
		}
		if (strHabilitado.equals("0")) {
			sb.append("Consultar: " + SN + strRuta
					+ "/jsp/InstruccionHija.jsp?id_ins=" + strIdInstruccion
					+ " \n");
		} else if (strHabilitado.equals("1")) {
			sb.append("Consultar: " + SN + strRuta
					+ "/jsp/InstruccionTurnada.jsp?id_ins=" + strIdInstruccion
					+ " \n");
		}
		sb.append("\n");
		if (fAvance >= 100) {
			subject = "instrucción Terminada!";
		} else {
			subject = "Respuesta de instrucción!";
		}
		sendMail(datos[0][1], subject, sb.toString(), context);

	}

	/**
	 * notificación del rechazo de un instrucción
	 * 
	 * @param strNombreT
	 *            Turnador
	 * @param strMailT
	 *            Mail turnado
	 * @param strRazon
	 *            Razón de rechazo
	 * @param strNombreInst
	 *            Nombre de la instrucción
	 * @param strNombreAsunto
	 *            Nombre del asunto
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @param strServerMail
	 *            Servidor mail
	 * @param strPortServer
	 *            puesto de salida mail
	 * @param strServerName
	 *            Nombre del servidor
	 * @param strBase
	 *            Contexto de la aplicación
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendMailRechazo(String strNombreT, String strMailT,
			String strRazon, String strNombreInst, String strNombreAsunto,
			String strIdInstruccion, String strServerName, String strBase,
			ServletContext context) throws MessagingException,
			UnsupportedEncodingException {
		EstructuraOrganizacional eOrg = (EstructuraOrganizacional) context
				.getAttribute(Catalogos.CATALOGO_ESTRUCTURA_ORGANIZACIONAL);
		String strHabilitado = "";
		boolean bUrl = ActualizaAsuntoTurnado.getEsHijo(strIdInstruccion);
		// Verifica la bandera de habilitado - 0=Atender, 1=para turnar
		strHabilitado = ActualizaInstrucciones.getHabilitado(strIdInstruccion);
		String strAsuntoInstruccion[][] = ActualizaInstrucciones
				.getNombreInstruccion(strIdInstruccion);
		PuestoVO puestoRechazo = eOrg.getPuesto(Integer
				.parseInt(strAsuntoInstruccion[0][3]));
		String subject = "Rechazo de instrucción!";
		StringBuffer sb = new StringBuffer();
		sb.append("Saludos " + strNombreT + ", \n");
		sb.append("Le informamos que ");
		sb.append(puestoRechazo.getNombre() + "/" + puestoRechazo.getCargo());
		sb.append(", ha rechazado la siguiente instrucción:\n");
		sb.append("\nDatos del Asunto:");
		sb.append("\n   Descripción: " + strNombreAsunto + "\n");
		sb.append("\nDatos de la instrucción rechazada:\n");
		sb.append("   Folio: " + strAsuntoInstruccion[0][7] + "\n");
		sb.append("   Descripción: " + strNombreInst + "\n");
		sb.append("   Razón de Rechazo: " + strRazon + "\n");
		if (strHabilitado.equals("0")) {
			if (bUrl) {
				sb.append("   Consultar en : " + strServerName + strBase
						+ "/jsp/InstruccionHija.jsp?id_ins=" + strIdInstruccion
						+ " \n");
			} else {
				sb.append("   Consultar en: " + strServerName + strBase
						+ "/jsp/InstruccionesAtender.jsp?id_ins="
						+ strIdInstruccion + " \n");
			}
		} else if (strHabilitado.equals("1")) {
			sb.append("   Consultar en: " + strServerName + strBase
					+ "/jsp/InstruccionTurnada.jsp?id_ins=" + strIdInstruccion
					+ " \n");
		}
		sb.append("\nFecha de registro: " + DateFormatter.getFechaActual());
		sendMail(strMailT, subject, sb.toString(), context);
	}

	/**
	 * Función que envia un mail a los usuarios de atencion, notificando la
	 * cancelacion de las instrucciones
	 * 
	 * 
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendNotificarCancelacion(String strIdAsunto,
			ServletContext context) throws MessagingException,
			UnsupportedEncodingException {
		String[][] instrucciones = ActualizaInstrucciones
				.getInstruccionesMail(strIdAsunto);
		for (int i = 0; i < instrucciones.length; i++) {
			if (ActualizaUsuario.getNotificacionMail(instrucciones[i][4])) {
				String strFolio = instrucciones[i][0];
				String strMailUsrEnviar = instrucciones[i][2];
				String subject = "Recuperación de instrucción!";
				StringBuffer sb = new StringBuffer();
				sb.append("Saludos " + instrucciones[i][3] + ", \n");
				sb
						.append("\nSe le informa que fue recuperada una instrucción de su fólder "
								+ "\"Instrucciones por Atender\" en el sistema SIGA, el proceso fue ejecutado "
								+ "por la ventanilla que originalmente le turno la instrucción:\n");
				sb.append("\nDatos de la instrucción recuperada:\n");
				sb.append("   Folio: " + strFolio + "\n");
				sb.append("\nFecha de registro:  "
						+ DateFormatter.getFechaActual() + "\n");
				sb
						.append("\nEs posible que haya recibido previamente un correo "
								+ "Electrónico de SIGA que le informa sobre la asignación de esta instrucción, "
								+ "debido a este proceso dicho correo debe ser ignorado.");
				sendMail(strMailUsrEnviar, subject, sb.toString(), context);
			}
		}

	}

	/**
	 * Función que envia un mail al usuario de ventanilla, notificando la
	 * recuperacion del Asunto
	 * 
	 * 
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendNotificarRecuperacion(String strIdAsunto,
			UsuarioBean usuario, ServletContext context)
			throws MessagingException, UnsupportedEncodingException {
		String[][] instrucciones = ActualizaInstrucciones
				.getInstruccionesMail(strIdAsunto);

		String[][] asunto = ActualizaAsunto.getAsuntoRecuperado(strIdAsunto);
		String descripcion = asunto[0][0];
		String strFolio = asunto[0][1];
		String subject = "Recuperación de Asunto turnado con Folio: "
				+ strFolio;
		StringBuffer sb = new StringBuffer();
		sb.append("Saludos " + usuario.getCargo() + ",\n");
		sb.append("\nSe le confirma la Recuperación del asunto solicitado, ");
		sb
				.append("este se encuentra ahora en el fólder \"Asuntos en Recepción\", ");
		sb
				.append("También fueron recuperadas las instrucciones tunadas a los destinatarios indicadas en el asunto: \n");
		sb.append("\nDatos del Asunto Recuperado:\n");
		sb.append("   Folio: " + strFolio + "\n");
		sb.append("   Descripción: " + descripcion + "\n");
		StringBuffer sbInst = new StringBuffer(
				"\nDatos de las Instrucciones Recuperadas:\n");
		for (int i = 0; i < instrucciones.length; i++) {
			sbInst.append("   Destinatario: " + instrucciones[i][3] + "/"
					+ instrucciones[i][1] + "\n");
			sbInst.append("   Folio: /" + instrucciones[i][0] + "\n\n");
		}
		sb.append(sbInst);
		sb.append("Fecha de Registro: " + DateFormatter.getFechaActual());
		sendMail(usuario.getCorreo(), subject, sb.toString(), context);
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
	 * @param _strRutaBase
	 *            Contexto aplicación
	 * @param strIdAsunto
	 *            Id asunto
	 * @param iHija
	 *            Hija
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendNotificar(Vector toUsers, String _respuesta,
			String mailFrom, String _strIdInstruccion, String SN,
			String _strRutaBase, String strIdAsunto, int iHija,
			ServletContext context) throws MessagingException,
			UnsupportedEncodingException {
		try {
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

			HashMap toAddresses = new HashMap();

			String subject = "información de avance de la instrucción: "
					+ strNombreInstruccion + " ";
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
			}

			if (toUsers.size() > 0 && toUsers != null) {
				for (int i = 0; i < toUsers.size(); i++) {
					toAddresses.put(toUsers.elementAt(i), "");
					sendMail((String) toUsers.elementAt(i), subject, sb
							.toString(), context);
				}
			}

		} catch (Exception e) {
		}
	}

	/**
	 * Método que envia un Mail informando del cambio de semaforo de un asunto
	 * 
	 * @param strNombreAsu
	 *            Nombre Asunto
	 * @param strMail
	 *            Mail Mail del solicitante
	 * @param strSema
	 *            Semaforo (Rojo - Amarillo -Verde)
	 * @throws MessagingException
	 *             cuando no encuentra el nombre del jdbc
	 * @throws UnsupportedEncodingException
	 *             Configuración de correo
	 */
	public void sendConfirmacionCambioSemaforo(String strNombreAsu,
			String strMail, String nombre, String strSema, String folio,
			ServletContext context) throws MessagingException,
			UnsupportedEncodingException {
		try {
			String subject = "Aviso! Cambio de semáforo del un asunto con el folio: "
					+ folio + " ";
			StringBuffer sb = new StringBuffer();
			sb.append("Saludos " + nombre + ",\n");
			sb
					.append("\nLe informamos que el siguiente Asunto ha cambiado su semáforo a color  ");
			sb.append(strSema + ": \n");
			sb.append("\nDatos del Asunto que cambio: \n");
			sb.append("   Folio: " + folio + " \n");
			sb.append("   Descripción:  " + strNombreAsu + " \n");
			sendMail(strMail, subject, sb.toString(), context);
		} catch (Exception e) {
		}
	}

	/**
	 * Método que envia un Mail informando acerca del cambio de semaforo de una
	 * instrucción
	 * 
	 * @param strNombreAsu
	 *            Nombre Asunto
	 * @param strMail
	 *            Mail Mail del solicitante
	 * @param strSema
	 *            Semaforo (Rojo - Amarillo -Verde)
	 * @throws MessagingException
	 *             cuando no encuentra el nombre del jdbc
	 * @throws UnsupportedEncodingException
	 *             Configuración de correo
	 */
	public void sendConfirmacionCambioSemaforoInst(String strNombreAsu,
			String strMail, String nombre, String strSema, String folio,
			ServletContext context) throws MessagingException,
			UnsupportedEncodingException {
		String subject = "Aviso! Cambio de semáforo en Instrucciones con el folio: "
				+ folio + " ";
		StringBuffer sb = new StringBuffer();
		sb.append("Saludos " + nombre + ",\n");
		sb
				.append("\nLe informamos que la siguiente instrucción ha cambiado su semáforo a color "
						+ strSema + ":\n");
		sb.append("\nDatos de la instrucción que cambio: \n");
		sb.append("   Folio: " + folio + "\n");
		sb.append("   Descripción:" + strNombreAsu + "\n");
		sendMail(strMail, subject, sb.toString(), context);

	}

	/**
	 * Envia un correo al vencerse el tiempo de respuesta
	 * 
	 * @param strNombreAsu
	 *            Nombre del asunto
	 * @param strMail
	 *            Mail del asunto
	 * @param strfolioNom
	 *            Folio del asunto
	 * @return Regresa un indicador de éxito
	 * @throws MessagingException
	 *             cuando no encuentra el nombre del jdbc
	 * @throws UnsupportedEncodingException
	 *             Configuración de correo
	 */
	public void sendConfirmacionCaduca(String strNombreAsu, String strMail,
			String strfolioNom, String MailServer, String PortServer,
			ServletContext context) throws MessagingException,
			UnsupportedEncodingException {
		String subject = "Aviso! Asunto vencido";
		StringBuffer sb = new StringBuffer();
		sb.append("Saludos!\n");
		sb.append("\nLe informamos que el Asunto: ");
		sb.append(" " + strNombreAsu + " ");
		sb.append(" con numero de folio ");
		sb.append(" " + strfolioNom + " ");
		sb.append(" ha vencido de la fecha compromiso. \n");
		sb.append(" \n");
		sb.append(" \n");
		sb
				.append("Esperamos pueda darle el seguimiento correspondiente a la brevedad posible. \n");
		sb.append("Gracias. \n");
		sb.append(" \n");
		sb.append(" \n");
		sendMail(strMail, subject, sb.toString(), context);
	}

	private static boolean sendMail(String emailTo, String subject,
			String body, ServletContext context) {
		try {
			String headerMail = "";
			String footerMail = "";
			String from = "siga@hacienda.gob.mx";
			String serverMail = (String) context
					.getAttribute("app.siga.serverMail");
			MailTask mailTask = new MailTask(from, emailTo, null, subject,
					headerMail + "\n" + body + "\n" + footerMail, serverMail);
			TaskQueue tq = TaskQueues.getQueue("EMAIL", 10);
			tq.addTask(mailTask);
			return true;
		} catch (AddressException e) {
			e.printStackTrace();
			return false;
		}
	}
}