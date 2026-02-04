/*
 * Creado el 17/04/2007
 */
package com.meve.sigma.scp;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import com.meve.sigma.actualiza.ActualizaArea;
import com.meve.sigma.actualiza.ActualizaAsunto;
import com.meve.sigma.actualiza.ActualizaBitacora;
import com.meve.sigma.actualiza.ActualizaFolio;
import com.meve.sigma.actualiza.ActualizaTipo_Doc;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLAsunto;
import com.meve.sigma.sql.SQLInstrucciones;
import com.meve.sigma.util.GeneracionFolio;
import com.meve.sigma.util.SenderMail;

/**
 * @author Enrique Velazco Acosta
 * 
 */
public class GeneraAsunto {

	public GeneraAsunto() {

	}

	public static void main(String arg[]) {

		// //System.out.println("Nuevoo " + getFolioAsunto("PRUEBA") );

	}

	public static void InsertaAsunto(String strIdEntidad,
			String strIdRemitente, String strFirmante, String strAsunto,
			String strIdExpediente, String strIdTipoDocto,
			String strFechaRecepcion, String strFechaDocto,
			String strFechaCaducidad, String strFolioExterno,
			String strFolioIntermedio, String strSintesis,
			String strComentarios, String strPalabraClave,
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
			String strTipoFolio, int iBandera, HttpServletRequest request) {

		// Guardar un asunto con estado 0 SIGA
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"dd/MM/yyyy");
		java.util.Date f = new java.util.Date();
		String strFechaCreacion = sdf.format(f);

		boolean bExisteFolio = false;
		bExisteFolio = ActualizaAsunto.getExisteFolioExterno(strFolioExterno,
				strFechaDocto, strControl, strIdEntidad, strIdRemitente,
				strAreaUs);
		if (!bExisteFolio) {
			// System.err.println("****** Guarda Asunto A Para Turnar******");
			guardarAsunto(strIdEntidad, strIdRemitente, strFirmante, strAsunto,
					strIdExpediente, strIdTipoDocto, strFechaRecepcion,
					strFechaDocto, strFechaCaducidad, strFolioExterno,
					strFolioIntermedio, strSintesis, strComentarios,
					strPalabraClave, strAsuntoAnterior, strIdPrioridad,
					strIdTipoAsunto, strIdDestinatario, strDestinatario,
					strMailDest, strRemitente, strCorreo, strAreaUs,
					strIdUsrCaptura, strControl, nuevoAsunto, SMail, SPort, SN,
					strRutaBase, strConfFolio, strEstatus, strPara, strCC,
					strIdsPara, strIdsCC, lugarEvento, stringHoraEvento,
					strFechaEvento, stringMinEvento, iesRescepcion, strParaE,
					strIdsParaE, strTramite, strTipoFolio, iBandera, request);
		} else {

		}

	}

	public static String guardarAsunto(String strIdEntidad,
			String strIdRemitente, String strFirmante, String strAsunto,
			String strIdExpediente, String strIdTipoDocto,
			String strFechaRecepcion, String strFechaDocto,
			String strFechaCaducidad, String strFolioExterno,
			String strFolioIntermedio, String strSintesis,
			String strComentarios, String strPalabraClave,
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
			String strTipoFolio, int iBandera, HttpServletRequest request) {
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

			if (strAreaUsuario.length == 0) {
				strNombreArea = "";
			} else {
				strNombreArea = strAreaUsuario[0][0];
			}

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
			strFolioGenerado = "folio por asignar";
		}// fin strIdTipoDocto
		// ** Se insertan los datos en la tabla de SD_ASUNTO
		String stridUltimoId = ActualizaAsunto.InsertarAsunto(strIdEntidad,
				strIdRemitente, strFirmante, strAsunto, strIdExpediente,
				strIdTipoDocto, strFechaRecepcion, strFechaDocto,
				strFechaCaducidad, strFolioExterno, strFolioIntermedio,
				strSintesis, strComentarios, strPalabraClave,
				strAsuntoAnterior, strIdPrioridad, strFolioGenerado,
				strIdUsrCaptura, strFechaCreacion, strAreaUs, strIdTipoAsunto,
				strIdDestinatario, strControl, strEstatus, strPara, strCC,
				strIdsPara, strIdsCC, lugarEvento, stringHoraEvento,
				strFechaEvento, stringMinEvento, strParaE, strIdsParaE,
				strTramite, strTipoFolio);
		// ** Fin Insertar Asunto
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
							strRemitente, strCorreo, strAsunto, SN,
							stridUltimoId, strRutaBase, request.getSession()
									.getServletContext());
				}
			}
		}
		return stridUltimoId;
	}

	// operaciones de asuntos
	// Crea Folio

	public static void asuntoInsercion(String strIdEntidad,
			String strIdRemitente, String strFirmante, String strAsunto,
			String strIdExpediente, String strIdTipoDocto,
			String strFechaRecepcion, String strFechaDocto,
			String strFechaCaducidad, String strFolioExterno,
			String strFolioIntermedio, String strSintesis,
			String strComentarios, String strPalabraClave,
			String strAsuntoAnterior, String strIdPrioridad,
			String strFolioGenerado, String strIdUsrCaptura,
			String strFechaCreacion, String strAreaUs, String strIdTipoAsunto,
			String strIdDestinatario, String strControl, String strEstatus,
			String strPara, String strCC, String strIdsPara, String strIdsCC,
			String lugarEvento, String stringHoraEvento, String strFechaEvento,
			String stringMinEvento, String strParaE, String strIdsParaE,
			String strTramite, String strTipoFolio) {

		String stridUltimoId = ActualizaAsunto.InsertarAsunto(strIdEntidad,
				strIdRemitente, strFirmante, strAsunto,
				/* strIdExpediente */"null",/* strIdTipoDocto */"50",
				strFechaRecepcion, /* strFechaDocto */strFechaRecepcion,
				/* strFechaCaducidad */strFechaRecepcion, strFolioExterno,
				strFolioIntermedio, strSintesis, strComentarios,
				strPalabraClave, strAsuntoAnterior, /* strIdPrioridad, */"null",
				strFolioGenerado, strIdUsrCaptura, strFechaCreacion, strAreaUs,
				/* strIdTipoAsunto */"null", strIdDestinatario, strControl,
				strEstatus, strPara, strCC, strIdsPara, strIdsCC, lugarEvento, /* stringHoraEvento */
				"null",
				/* strFechaEvento */null, /* stringMinEvento */"null", strParaE,
				strIdsParaE, /* strTramite */"null", strTipoFolio);

	}

	public static String getFolioAsunto(String strIdAsunto) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLAsunto
					.getFolioAsunto(strIdAsunto));
			// //System.out.println("getFolioAsunto:"+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getFolioAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query, donde contabiliza el numero de
	 * instrucciones que tiene el asunto sin turnar
	 * 
	 * @param strIdAsunto
	 *            Id del Asunto
	 * @return
	 */
	public static String getCountInstSinTurnar(String strIdAsunto) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLAsunto
					.getCountInstSinTurnar(strIdAsunto));
			// //System.out.println("getCountInstSinTurnar:"+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getCountInstSinTurnar:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene el avance inicial de una instrucción
	 * 
	 * @param strIdInstruccion
	 *            id de instrucción
	 * @return el avance de la instrucción
	 */
	public static String getAvanceOriginal(String strIdInstruccion) {
		try {
			String sql = SQLInstrucciones.getAvanceOriginal(strIdInstruccion);
			String strResult[][] = ConexionDS.ejecutarSQL(sql);
			// System.out.println("getAvance="+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getAvance:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	public static String getAvanceAsunto(String strIdAsunto) {

		try {

			String sql = SQLAsunto.getAvanceAsunto(strIdAsunto);
			String strResult[][] = ConexionDS.ejecutarSQL(sql);
			// System.out.println("getAvance="+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;

		} catch (SQLException sqle) {
			// System.out.println("getAvance:"+sqle);
			sqle.printStackTrace();
			return null;
		}

	}

	/**
	 * 
	 * @param strIdAsunto
	 * @return
	 */
	public static String getFechaInicioAsunto(String strIdAsunto) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLAsunto
					.getFechaInicioAsunto(strIdAsunto));
			// //System.out.println("getFechaInicioAsunto:"+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getFechaInicioAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que trae la fecha de compromiso
	 * 
	 * @param strIdAsunto
	 * @return
	 * @throws SQLException
	 */
	public static String getFechaVencimiento(String strIdAsunto) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLAsunto
					.getFechaVencimiento(strIdAsunto));
			// //System.out.println("getFechaInicioAsunto:"+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getFechaInicioAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}

	}

	public static String[][] getIdAsuntoSIGA(String strFolio) {
		try {
			String strSql = "SELECT id_asunto FROM sd_asunto WHERE ASU_FOLIO_INTERMEDIO ='"
					+ strFolio + "'";
			// System.out.println("getIdAsuntoSIGA:" + strSql);
			return ConexionDS.ejecutarSQL(strSql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

}
