/**
 * Clase:						ResponderBean.java
 * 
 * Paquete:						gob.hacienda.cgtic.siga.beans		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				        Nov 26, 2007
 * 
 * @author: 					        Javier Vega
 * 							
 * 			
 * Empresa:						Secretaría de Hacienda y Crédito Público.
 * 
 * 
 * Descripción de la clase:		Esta clase se encarga de registrar la respuesta de una instrucción omitiendo envio de correo electrónico.
 */

package gob.hacienda.cgtic.siga.beans;

import java.sql.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.actualiza.ActualizaArea;
import com.meve.sigma.actualiza.ActualizaAsunto;
import com.meve.sigma.actualiza.ActualizaAsuntoTurnado;
import com.meve.sigma.actualiza.ActualizaBitacora;
import com.meve.sigma.actualiza.ActualizaHistorial;
import com.meve.sigma.actualiza.ActualizaInstrucciones;
import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.reportes.ActualizaInst;
import com.meve.sigma.util.CalculoAvance;
import com.meve.sigma.util.Utilerias;
import com.meve.sigma.util.SenderMail;


public class ResponderBean {

	public static void responderInstruccion(HttpServletRequest request,
			UsuarioBean usuBean, String strTurnador, String SN, String strBase,boolean enviaEmailRespIns, ServletContext context) {
		String strIdInstruccion = "";
		boolean bEsHijo = false;
		strIdInstruccion = request.getParameter("id_ins");

		// ** determina si es hijo de una instruccion
		bEsHijo = ActualizaAsuntoTurnado.getEsHijo(strIdInstruccion);
		//System.out.println("idinstruccion="+strIdInstruccion);
		String strBandera = ActualizaInstrucciones.getbandera(strIdInstruccion);
		/*if (bEsHijo)
			respuestaInstruccionHija(request, usuBean, strTurnador, SN,
					strBase, strBandera,enviaEmailRespIns,context);
		else*/
			respuestaInstruccionPadre(request, usuBean, strTurnador, SN,
					strBase, strBandera,enviaEmailRespIns,context);

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
	 * @param SN
	 *            nombre de servidor
	 * @param strBase
	 *            contexto
	 * @param strBandera
	 *            bandera
	 */
	public static void respuestaInstruccionHija(HttpServletRequest request,
			UsuarioBean BUsuario, String strTurnador, String SN,
			String strBase, String strBandera,boolean enviaEmailRespIns, ServletContext context) {

		String strIdUsrResp = ""; // Usuario que responde
		String strRespuesta = ""; // Comentario a la respuesta
		String strResponderA = ""; // Usuario al que se le quiere responder
		String strAvance = ""; // Avance que le da el usuario a la respuesta
		String strIdUsuario = ""; // Id del Usuario
		String strIdAsunto = ""; // Id del Asunto al que pertenece la
									// instrucción
		String strIdInstruccion = ""; // Id de la instrucción
		String strEstatus = ""; // Estatus de la instrucción
		String strFechaCreacion = ""; // Fecha de Creación de la respuesta
		String Avance1 = ""; // Avance original de la instrucción
		String firmarDigitalmente = ""; // FIrma digital
		String nombre = ""; // Nombre de un usuario
		String correo = ""; // Correo del Usuario
		String sec = ""; // Secuencia de la instrucción
		String idPadre = "";
		String strUsrOrg = "";
		String strAnio = "";

		int count = 0; // Variable para inicializar un contador

		boolean bInsertar = false; // Inserta la respuesta de la instrucción
		boolean bActualizarAvance = false; // Actualiza el avance de la
											// instrucción
		boolean bInstruccionNext = false; // Para verificar si tiene otras
											// instrucciones
		boolean bInstruccionNext1 = false; // Para verificar si tiene otras
											// instrucciones
		boolean bInsertarBitacora = false; // Actualiza events en la bitacora
		boolean bActualizaFechas = false; // Actualiza Fechas
		boolean bEsHijo = false; // Verifica si la instrucción es hija

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

		if (BUsuario.getAsistente()) {
			try {
				bInsertar = ActualizaHistorial.InsertarRespuesta(
						strIdInstruccion, strIdAsunto, strRespuesta,
						strIdUsrResp, strAvance, strFechaCreacion, BUsuario
								.getCargo()
								+ " / "
								+ BUsuario.getNombre()
								+ " en Nombre de "
								+ gob.hacienda.cgtic.siga.instruccion.Rechazo
										.aNombre(BUsuario, strIdInstruccion));
			} catch (Exception e) {// System.err.println("ResponderBean.RespuestaInstruccionHija(...):
									// "+e.getMessage());
			}
		} else
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
			  SenderMail mail = new SenderMail(); 
			  if(ActualizaUsuario.getNotificacionMail(ActualizaInstrucciones.getTurnador(strIdInstruccion)) && enviaEmailRespIns) {
				  try{
				  mail.SendMailResponderHija(strIdAsunto,strIdInstruccion,SN, strBase,iAvance, strRespuesta,context);				  
				  }
				  catch(MessagingException me){
		        	    
	                    me.printStackTrace();
				  }catch(UnsupportedEncodingException uee){
	        	    
	                    uee.printStackTrace();
				  }					  				  
			  } 							       				  				  		  			   
				/*
				 * if (true) { try { SenderMail notificar = new SenderMail(); if
				 * (ActualizaUsuario.getNotificacionMail(ActualizaInstrucciones.getTurnador(strIdInstruccion))) {
				 * //notificar.SendMailResponderHija(strIdAsunto,strIdInstruccion,
				 * Smail,PMail, SN, strBase,iAvance, strRespuesta); } } catch
				 * (MessagingException me) { //System.err.println("Mensaje=" +
				 * me.getMessage()); } catch (UnsupportedEncodingException uee) {
				 * //System.err.println("Mensaje1=" + uee.getMessage()); } }
				 */			 			  		
		//System.out.println("responderIns hija="+BUsuario.getResponder()+", notificación="+ActualizaUsuario.getNotificacionMail(ActualizaInstrucciones.getTurnador(strIdInstruccion))+"->idturnador="+ActualizaInstrucciones.getTurnador(strIdInstruccion));
		//System.out.println("parametro="+enviaEmailRespIns);
		 
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
						strAnio = ActualizaArea.getSalida(strIdArea[0][0]);
						int iConsecutivoE = new Integer(strEntrada).intValue();
						int countE = iConsecutivoE;
						String strFolioEntrada = strAnio + "/" + countE;
						countE = countE + 1;
						if (strBandera.equals("1")) {
							bActualizaConse = ActualizaArea.actualizaEntrada(
									countE, strIdArea[0][0]);
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
						String strGetFolio = ActualizaInstrucciones
								.getUltimoFolioTurnado(strIdInstruccion);
						String num = strGetFolio
								.substring(strGetFolio.length() - 1);
						String strGetFolio1 = strGetFolio.substring(0,
								strGetFolio.length() - 2);
						int iNum = new Integer(num).intValue();
						String fol = strGetFolio1 + "-" + (iNum + 1);
						boolean bFol =
						/* , strFolioSalida */ActualizaInstrucciones
								.UpdateFolioInstruccion(strSecuencia[i][2], fol);
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
					}
				}
			}
		}

	} // **Fin Envio de mail de notificación

	/**
	 * Responde a las Instrucciones Padre
	 * 
	 * @param request
	 *            solicitud
	 * @param BUsuario
	 *            Bean de usuario
	 * @param strTurnador
	 *            turnador
	 * @param SN
	 *            nombre de servidor
	 * @param strBase
	 *            contexto
	 * @param strBandera
	 *            bandera
	 */
	public static void respuestaInstruccionPadre(HttpServletRequest request,
			UsuarioBean BUsuario, String strTurnador, String SN,
			String strBase, String strBandera,boolean enviaEmailRespIns, ServletContext context) {
		String strIdUsrResp = ""; // Usuario que responde
		String strRespuesta = ""; // Comentario a la respuesta
		String strAvance = ""; // Avance que le da el usuario a la respuesta
		String strIdAsunto = ""; // Id del Asunto al que pertenece la
									// instrucción
		String strIdInstruccion = ""; // Id de la instrucción
		String strEstatus = ""; // Estatus de la instrucción
		String strFechaCreacion = ""; // Fecha de Creación de la respuesta
		String Avance1 = ""; // Avance original de la instrucción
		String firmarDigitalmente = ""; // FIrma digital
		String sec = ""; // Secuencia de la instrucción
		String strAva = "";
		String strUsrOrg = "";
		String strAnio = "";

		int count = 0; // Variable para inicializar un contador

		boolean bInsertar = false; // Inserta la respuesta de la instrucción
		boolean bActualizarAvance = false; // Actualiza el avance de la
											// instrucción
		boolean bInstruccionNext = false; // Para verificar si tiene otras
											// instrucciones
		boolean bInstruccionNext1 = false; // Para verificar si tiene otras
											// instrucciones
		boolean bInsertarBitacora = false; // Actualiza events en la bitacora
		boolean bActualizaFechas = false; // Actualiza Fechas
		boolean bEsHijo = false; // Verifica si la instrucción es hija

		String countRequeridos[][] = null;
		String strCount[][] = null;
		String strSum[][] = null;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date f = new java.util.Date();
		strFechaCreacion = sdf.format(f);

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date f1 = new java.util.Date();
		String strFechaReal = sdf1.format(f1);
		String horariosArea[][] = ActualizaArea.getHorarioUsuario(strTurnador);
		strFechaCreacion = Utilerias.getFechaInicio(strFechaCreacion,
				horariosArea[0][1], horariosArea[0][2]);

		strRespuesta = request.getParameter("contestar");
		strAvance = request.getParameter("responderAvance");
		strIdAsunto = request.getParameter("id_asunto");
		strIdInstruccion = request.getParameter("id_ins");
		strEstatus = request.getParameter("id_es");
		Avance1 = request.getParameter("ava");
		firmarDigitalmente = request.getParameter("firmaDigital");
		strUsrOrg = request.getParameter("us_or");
		strIdUsrResp = strUsrOrg;

		// **Determina si la instruccion es informativa
		String strTipoAtencion = ActualizaAsuntoTurnado
				.getTipoAtencion(strIdInstruccion);
		if (strTipoAtencion.equals("0")) {
			// **Calcula el avance del asunto
			strCount = ActualizaAsuntoTurnado.getCountInstruccion(strIdAsunto);
			strSum = ActualizaAsuntoTurnado.getSumInstruccion(strIdAsunto);
			strAva = strAvance;
			float fAvance = new Float(Avance1).floatValue();
			float su = new Float(strSum[0][0]).floatValue();
			float a = new Float(strAva).floatValue();
			float c = new Float(strCount[0][0]).floatValue();
			float dif = a - fAvance;
			float total = (su + dif) / c;
			NumberFormat df = NumberFormat.getNumberInstance();
			df.setMaximumFractionDigits(2);
			String strTotal = df.format(total);

			ActualizaAsuntoTurnado.ActualizaAvanceAsunto(strIdAsunto, strTotal);
			float fin = new Float(strTotal).floatValue();
			if (fin >= 100) {
				ActualizaAsuntoTurnado.ActualizaEstatusAsunto(strIdAsunto,
						strFechaReal, strFechaCreacion);
			}
			// **Fin calculo avance asunto
		}
		Date fechaTerminacionReal = new Date(new java.util.Date().getTime());
		if (firmarDigitalmente != null
				&& firmarDigitalmente.equalsIgnoreCase("on"))
			firmarDigitalmente = "1";
		else
			firmarDigitalmente = "0";

		if (BUsuario.getAsistente()) {
			try {
				bInsertar = ActualizaHistorial.InsertarRespuesta(
						strIdInstruccion, strIdAsunto, strRespuesta,
						strIdUsrResp, strAvance, strFechaCreacion, BUsuario
								.getCargo()
								+ " / "
								+ BUsuario.getNombre()
								+ " en Nombre de "
								+ gob.hacienda.cgtic.siga.instruccion.Rechazo
										.aNombre(BUsuario, strIdInstruccion));
			} catch (Exception e) {
			}
		} else
			bInsertar = ActualizaHistorial.InsertarRespuesta(strIdInstruccion,
					strIdAsunto, strRespuesta, strIdUsrResp, strAvance,
					strFechaCreacion, BUsuario.getCargo() + " / "
							+ BUsuario.getNombre());

		bActualizarAvance = ActualizaInstrucciones.avanceInstruccionPadre(
				strIdInstruccion, strAvance, strEstatus, firmarDigitalmente,
				fechaTerminacionReal.toString(), strIdUsrResp);

		// ** Verifica a que paso pertenece
		sec = ActualizaInstrucciones.getPasoPertenece(strIdInstruccion);
		countRequeridos = ActualizaInstrucciones
				.getCountInstruccionesRequeridas(strIdAsunto, sec);
		// ** Se hace conversión del numero total de pasos existentes a un int
		count = new Integer(countRequeridos[0][0]).intValue();
		// ** Se inserta en la bitacora lo que ha hecho el usuario, en este
		// ** caso una respuesta a una instrucción

		String msnBitacora = "Se respondió la instrucción con folio "
				+ ActualizaInstrucciones
						.getUltimoFolioTurnado(strIdInstruccion)
				+ " reportando un avance del " + Avance1 + "%";
		bInsertarBitacora = ActualizaBitacora.InsertarEventoResponder(BUsuario
				.getIdUsuario(), msnBitacora);

		bInstruccionNext = ActualizaAsuntoTurnado
				.VerificarInstruccionesTurnar(strIdAsunto);
		float iAvance = new Float(strAvance).floatValue(); // ?		
		// **Envio de Mail de respuesta				  			  
			  SenderMail mail = new SenderMail();			  			  
			  if(ActualizaUsuario.getNotificacionMail(ActualizaInstrucciones.getTurnador(strIdInstruccion)) && enviaEmailRespIns) {				  
				  try{
				  mail.SendMailResponder(strIdAsunto,strIdInstruccion,SN, strBase,iAvance, strRespuesta,context);				  
				  }
				  catch(MessagingException me){
		        	    
	                    me.printStackTrace();
				  }catch(UnsupportedEncodingException uee){
	        	    
	                    uee.printStackTrace();
				  }					  				  
			  } 							       				  				  		  						
		/*
		 * if (true) { try { SenderMail notificar = new SenderMail(); if
		 * (ActualizaUsuario.getNotificacionMail(ActualizaInstrucciones.getTurnador(strIdInstruccion))) { //
		 * notificar.SendMailResponder(strIdAsunto, strIdInstruccion,Smail,
		 * PMail, SN, strBase,iAvance, strRespuesta); } } catch
		 * (MessagingException me) { //System.err.println("Mensaje=" +
		 * me.getMessage()); } catch (UnsupportedEncodingException uee) {
		 * //System.err.println("Mensaje1=" + uee.getMessage()); } }
		 */
		// **Fin Envio de Mail de respuesta
		//System.out.println("responderIns padre="+BUsuario.getResponder()+", notificación="+ActualizaUsuario.getNotificacionMail(ActualizaInstrucciones.getTurnador(strIdInstruccion))+"->idturnador="+ActualizaInstrucciones.getTurnador(strIdInstruccion));
		//System.out.println("parametro="+enviaEmailRespIns);
		if (iAvance >= 100) {
			if (bInstruccionNext) {
				// ** Verifica si las instrucciones tienes alguna secuencia que
				// tenga
				// ** una instruccion requerida
				if (count == 0) {
					Calendar cFechaInicio = Utilerias
							.StringCalendar2(strFechaCreacion);
					String strSecuencia[][] = ActualizaAsuntoTurnado
							.SecuenciaPasosInstruccion(strIdAsunto);
					int s1 = new Integer(strSecuencia[0][0]).intValue();
					int req1 = new Integer(strSecuencia[0][5]).intValue();

					// **asignación de folio de entrada
					boolean bExisteFolioEntrada = false;
					bExisteFolioEntrada = ActualizaAsunto
							.getExisteFolioSalidaAsunto(strIdAsunto);
					String[][] strIdArea = ActualizaAsunto
							.getAreaFoleo(strIdAsunto);
					if (!bExisteFolioEntrada) {
						String strEntrada = ActualizaArea
								.getEntrada(strIdArea[0][0]);
						// String strSalida =
						// ActualizaArea.getSalida(strIdArea[0][0]);
						strAnio = ActualizaArea.getSalida(strIdArea[0][0]);
						int iConsecutivoE = new Integer(strEntrada).intValue();
						int countE = iConsecutivoE; // + 1;

						/*
						 * int iConsecutivoS = new
						 * Integer(strSalida).intValue(); int countS =
						 * iConsecutivoS + 1;
						 */

						String strFolioEntrada = strAnio + "/" + countE;
						countE = countE + 1;
						// strFolioSalida = countS+"/"+strAnio;
						if (strBandera.equals("1")) {
							ActualizaArea.actualizaEntrada(
									countE, strIdArea[0][0]);
							ActualizaAsunto
									.setFolioEntrada(strFolioEntrada,
											strIdAsunto);
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
						String strGetFolio1 = ActualizaInstrucciones
								.getFolioRecepcion(strIdAsunto);
						String strUltimoID = ActualizaInstrucciones
								.getUltimoID(strIdAsunto);
						String strGetFolio = ActualizaInstrucciones
								.getUltimoFolioTurnado(strUltimoID);
						String num = strGetFolio
								.substring(strGetFolio.length() - 1);

						int iNum = new Integer(num).intValue();
						String fol = strGetFolio1 + "-" + (iNum + 1);
						boolean bFol =
						/* , strFolioSalida */ActualizaInstrucciones
								.UpdateFolioInstruccion(strSecuencia[i][2], fol);
						// ** Fin Asignación Folio

						// se manda a traer el id del area a la que pertenece el
						// asunto original
						String strIdAreaOrigen = ActualizaInstrucciones
								.getIdAreaOrigen(strIdAsunto);

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
										strTurnador, strIdAreaOrigen,
										strSecuencia[i][6], iBandera,
										nombreInst);

						// ** Envio de mail para notificar que se le ha asignado
						// una instrucción
						/*
						 * if (true) { try { SenderMail notificar = new
						 * SenderMail(); if
						 * (ActualizaUsuario.getNotificacionMail(strSecuencia[i][3])) {
						 * String strUsuEnviar[][] =
						 * ActualizaUsuario.getUsuario(strSecuencia[i][3]);
						 * String strUserCorreo = ""; if (strUsuEnviar != null &&
						 * strUsuEnviar[0][0].length() > 0) { strUserCorreo =
						 * strUsuEnviar[0][0]; } else { strUserCorreo = ""; }
						 * //notificar.sendNotificar(nombre,
						 * correo,strUserCorreo,
						 * strSecuencia[i][4],strSecuencia[i][2], null,Smail,
						 * PMail, SN,request.getContextPath()); } } catch
						 * (MessagingException me) {
						 * //System.err.println("Mensaje=" + me.getMessage()); }
						 * catch (UnsupportedEncodingException uee) {
						 * //System.err.println("Mensaje1=" + uee.getMessage()); } }
						 */
						// ** Fin de envio de mail
					}
				}
			}
		}
		// **Envio de mail de notificación
		/***********************************************************************
		 * if (true) { if (strResponderA.length() != 0) { String UsrMailResponde =
		 * BUsuario.getCorreo(); StringTokenizer st = new
		 * StringTokenizer(strResponderA, ","); Vector vprueba = new Vector();
		 * while (st.hasMoreTokens()) { vprueba.add(st.nextToken()); }
		 *  // SendMailMultiple senderMul = new SendMailMultiple(); try { //
		 * senderMul.sendNotificar(vprueba, strRespuesta,
		 * UsrMailResponde,strIdInstruccion, Smail, PMail, SN,
		 * strBase,strIdAsunto, 0);
		 *  } catch (MessagingException me) { //System.err.println("Mensaje=" +
		 * me.getMessage()); } catch (UnsupportedEncodingException uee) {
		 * //System.err.println("Mensaje1=" + uee.getMessage()); } /** Fin envio
		 * mail
		 **********************************************************************/
		/*
		 * } else { //System.err.println("No se envia mail de aviso"); }
		 */
	} // **Fin Envio de mail de notificación
}
