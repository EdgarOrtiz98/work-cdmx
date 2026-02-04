/*
 * Clase:						SQLBuscar.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * VersiÛn						1.0
 * 
 * Fecha CreaciÛn:				Nov 17, 2005
 * 
 * @author: 					Rodrigo Soto Ch.
 * 								rodrigo_s_ch@yahoo.com.mx, rodrigo.soto.ch@gmail.com
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * DescripciÛn de la clase:		Clase que contiene los querys que realizaran las busquedas de
 * 								Asuntos e Instrucciones
 */

package com.meve.sigma.sql;

import java.util.StringTokenizer;

import com.meve.sigma.beans.search.BuscarCampo;
import com.meve.sigma.beans.search.BuscarCampoIns;

/**
 * Clase para generar codigo SQL para realizar las busquedas
 * 
 * @author Meve Soluciones S.A. de C.V.
 */

public class SQLBuscar {

	/**
	 * Construye un SQL Query para regresar todos los Asuntos capturados entre
	 * ciertas fechas
	 * 
	 * @param strFechaInicio
	 *            Fecha de Inicio de la Fecha de captura
	 * @param strFechaFin
	 *            Fecha de Final de la Fecha de captura
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getConsultaCiudadano(String strFechaInicio,
			String strFechaFin) {
		String sql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_FOLIO_RECEPCION, "
				+ "ASU_FECHA_CAPTURA, ASU_ESTATUS, USU_AREA "
				+ "FROM SD_ASUNTO, SD_USUARIO "
				+ "WHERE SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO "
				+ "AND ASU_FECHA_CAPTURA >= '" + strFechaInicio + "' "
				+ "AND ASU_FECHA_CAPTURA <= '" + strFechaFin + "' "
				+ "ORDER BY 2";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos Ciudadanos entre Fecha
	 * Inicial y Fecha Final.
	 * 
	 * @param strFechaInicio
	 *            Fecha de Inicio de la Fecha de captura
	 * @param strFechaFin
	 *            Fecha de Final de la Fecha de captura
	 * @param strTipoResp
	 *            Tipo de Respuesta
	 * @param strArea
	 *            Unidad Administrativa
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getConsultaCiudadanoTerminados(String strFechaInicio,
			String strFechaFin, String strTipoResp, String strArea) {

		String sql = "";
		if (strTipoResp.equals("-1") && strArea.equals("-1")) {
			sql = "SELECT ID_SOLICITUD, SOL_FOLIO_SOLICITUD, NOT_ID_ASUNTO, NOT_TIPO_RESPUESTA, "
					+ "NOT_ESTATUS, NOT_FECHA "
					+ "FROM SD_ASUNTO_CIUDADANO, SD_NOTIFICACION_CIUDADANO "
					+ "WHERE SOL_FECHA_CREACION >='"
					+ strFechaInicio
					+ "' "
					+ "AND SOL_FECHA_CREACION <='"
					+ strFechaFin
					+ "' "
					+ "AND SD_ASUNTO_CIUDADANO.SOL_ID_ASUNTO=SD_NOTIFICACION_CIUDADANO.NOT_ID_ASUNTO "
					+ "AND NOT_ACTIVA=1 AND NOT_CERRAR=1 "
					+ "ORDER BY SOL_FOLIO_SOLICITUD";
		} else if (!strTipoResp.equals("-1") && strArea.equals("-1")) {
			sql = "SELECT ID_SOLICITUD, SOL_FOLIO_SOLICITUD, NOT_ID_ASUNTO, "
					+ "NOT_TIPO_RESPUESTA, NOT_ESTATUS, NOT_FECHA "
					+ "FROM SD_ASUNTO_CIUDADANO, SD_NOTIFICACION_CIUDADANO "
					+ "WHERE SOL_FECHA_CREACION >='"
					+ strFechaInicio
					+ "' "
					+ "AND SOL_FECHA_CREACION <='"
					+ strFechaFin
					+ "' "
					+ "AND SD_ASUNTO_CIUDADANO.SOL_ID_ASUNTO=SD_NOTIFICACION_CIUDADANO.NOT_ID_ASUNTO "
					+ "AND NOT_ACTIVA=1 "
					+ "AND NOT_CERRAR=1 AND NOT_TIPO_RESPUESTA=" + strTipoResp
					+ " " + "ORDER BY SOL_FOLIO_SOLICITUD";
		} else if (strTipoResp.equals("-1") && !strArea.equals("-1")) {
			sql = "SELECT DISTINCT ID_SOLICITUD, SOL_FOLIO_SOLICITUD, NOT_ID_ASUNTO, "
					+ "NOT_TIPO_RESPUESTA, NOT_ESTATUS, NOT_FECHA, ARE_NOMBRE "
					+ "FROM SD_ASUNTO_CIUDADANO, SD_NOTIFICACION_CIUDADANO, SD_INSTRUCCION_ASUNTO, SD_USUARIO, SD_AREA "
					+ "WHERE SOL_FECHA_CREACION >='"
					+ strFechaInicio
					+ "' "
					+ "AND SOL_FECHA_CREACION <='"
					+ strFechaFin
					+ "' "
					+ "AND SD_ASUNTO_CIUDADANO.SOL_ID_ASUNTO=SD_NOTIFICACION_CIUDADANO.NOT_ID_ASUNTO "
					+ "AND SD_INSTRUCCION_ASUNTO.ID_ASUNTO=SD_NOTIFICACION_CIUDADANO.NOT_ID_ASUNTO "
					+ "AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
					+ "AND SD_AREA.ID_AREA=SD_USUARIO.USU_AREA AND NOT_ACTIVA=1 "
					+ "AND NOT_CERRAR=1 AND ID_AREA="
					+ strArea
					+ " "
					+ "ORDER BY SOL_FOLIO_SOLICITUD";
		} else if (!strTipoResp.equals("-1") && !strArea.equals("-1")) {
			sql = "SELECT DISTINCT ID_SOLICITUD, SOL_FOLIO_SOLICITUD, NOT_ID_ASUNTO, "
					+ "NOT_TIPO_RESPUESTA, NOT_ESTATUS, NOT_FECHA, ARE_NOMBRE "
					+ "FROM SD_ASUNTO_CIUDADANO, SD_NOTIFICACION_CIUDADANO, SD_INSTRUCCION_ASUNTO, SD_USUARIO, SD_AREA "
					+ "WHERE SOL_FECHA_CREACION >='"
					+ strFechaInicio
					+ "' "
					+ "AND SOL_FECHA_CREACION <='"
					+ strFechaFin
					+ "' "
					+ "AND SD_ASUNTO_CIUDADANO.SOL_ID_ASUNTO=SD_NOTIFICACION_CIUDADANO.NOT_ID_ASUNTO "
					+ "AND SD_INSTRUCCION_ASUNTO.ID_ASUNTO=SD_NOTIFICACION_CIUDADANO.NOT_ID_ASUNTO "
					+ "AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
					+ "AND SD_AREA.ID_AREA=SD_USUARIO.USU_AREA AND NOT_ACTIVA=1 "
					+ "AND NOT_CERRAR=1 AND ID_AREA="
					+ strArea
					+ " AND NOT_TIPO_RESPUESTA="
					+ strTipoResp
					+ " "
					+ "ORDER BY SOL_FOLIO_SOLICITUD";
		}
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar la Unidade Administrativa las
	 * Instrucciones Asociadas a un Asunto
	 * 
	 * @param strIdAsunto
	 *            ID del Asunto
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAreasAtencion(String strIdAsunto) {
		String sql = " SELECT DISTINCT USU_AREA FROM SD_USUARIO, SD_INSTRUCCION_ASUNTO "
				+ "WHERE SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
				+ "AND ID_ASUNTO=" + strIdAsunto;
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar la Unidade Administrativa las
	 * Instrucciones Asociadas a un Asunto y que sean Ejecutoras
	 * 
	 * @param strIdAsunto
	 *            ID del Asunto
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAreasAtencionEjecutoras(String strIdAsunto) {
		String sql = " SELECT DISTINCT USU_AREA FROM SD_USUARIO, SD_INSTRUCCION_ASUNTO "
				+ "WHERE SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
				+ "AND ID_ASUNTO=" + strIdAsunto + " AND INS_TIPO_ATENCION=0";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar la Unidade Administrativa las
	 * Instrucciones Asociadas a un Asunto y que sean Informativa
	 * 
	 * @param strIdAsunto
	 *            ID del Asunto
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAreasAtencionInformativas(String strIdAsunto) {
		String sql = " SELECT DISTINCT USU_AREA FROM SD_USUARIO, SD_INSTRUCCION_ASUNTO "
				+ "WHERE SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
				+ "AND ID_ASUNTO=" + strIdAsunto + " AND INS_TIPO_ATENCION=1";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos entre las Fechas de
	 * captura Inical y Final
	 * 
	 * @param fechaInicio
	 *            Fecha de captura Inicial
	 * @param fechaFin
	 *            Fecha de captura Final
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getEntreFechasA(String fechaInicio, String fechaFin) {
		String sql = "";
		sql = "SELECT ASU_FOLIO_RECEPCION, RMT_NOMBRE, ASU_DESCRIPCION, ASU_FECHA_CAPTURA "
				+ "FROM SD_ASUNTO, SD_REMITENTE WHERE ASU_FECHA_CAPTURA >= '"
				+ fechaInicio
				+ "' "
				+ "AND ASU_FECHA_CAPTURA <= '"
				+ fechaFin
				+ "' "
				+ "AND SD_REMITENTE.ID_REMITENTE=SD_ASUNTO.ASU_REMITENTE";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos entre las Fechas de
	 * captura Inical y Final
	 * 
	 * @param fechaInicio
	 *            Fecha de captura Inicial
	 * @param fechaFin
	 *            Fecha de captura Final
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getEntreFechasI(String fechaInicio, String fechaFin) {
		String sql = "";
		sql = "SELECT ASU_FOLIO_RECEPCION, RMT_NOMBRE, ASU_DESCRIPCION, ASU_FECHA_CAPTURA "
				+ "FROM SD_ASUNTO WHERE ASU_FECHA_CAPTURA >= '"
				+ fechaInicio
				+ "' " + "AND ASU_FECHA_CAPTURA <= '" + fechaFin + "'";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos que contengan en su
	 * descripcion el String campo
	 * 
	 * @param campo
	 *            Descripcion del Asunto
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getBusquedasAsunto(String campo) {
		String sql = "";
		campo = campo.trim();
		/*
		 * sql = "SELECT ASU_FOLIO_RECEPCION, RMT_NOMBRE, ASU_DESCRIPCION,
		 * ASU_FECHA_CAPTURA, ID_ASUNTO " + "FROM SD_ASUNTO, SD_REMITENTE WHERE
		 * LOWER(ASU_DESCRIPCION) LIKE LOWER('%"+campo+"%') " + "AND
		 * SD_REMITENTE.ID_REMITENTE=SD_ASUNTO.ASU_REMITENTE " + "ORDER BY 1";
		 */
		sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, TO_CHAR(ASU_FECHA_CAPTURA, 'DD/MM/YYYY HH:MI:SS AM'), ID_ASUNTO, ASU_CONTROL "
				+ "FROM SD_ASUNTO WHERE LOWER(ASU_DESCRIPCION) LIKE LOWER('%"
				+ campo + "%') " + "ORDER BY 3";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar las Instrucciones que contengan en
	 * su descripcion el String campo
	 * 
	 * @param campo
	 *            Descripcion de la instrucciÛn
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getBusquedasInstruccion(String campo) {
		String sql = "";
		campo = campo.trim();
		// campo = campo.toUpperCase();
		sql = "SELECT ID_INSTRUCCION_ASUNTO, INS_FOLIO_TURNADO, TO_CHAR(INS_FECHA_ASIGNACION, 'DD/MM/YYYY HH:MI:SS AM'), "
				+ "INS_INSTRUCCION, INS_INSTRUCCION_OTRO, USU_NOMBRE "
				+ "FROM SD_INSTRUCCION_ASUNTO, SD_INSTRUCCION, SD_USUARIO "
				+ "WHERE SD_INSTRUCCION_ASUNTO.INS_INSTRUCCION=SD_INSTRUCCION.ID_INSTRUCCION "
				+ "AND SD_INSTRUCCION_ASUNTO.INS_USUARIO=SD_USUARIO.ID_USUARIO "
				+ "AND (LOWER(INS_INSTRUCCION_OTRO) LIKE LOWER('%"
				+ campo
				+ "%') "
				+ "OR LOWER(INS_NOMBRE) LIKE LOWER('%"
				+ campo
				+ "%')) " + "AND INS_ESTATUS <> 0 " + "ORDER BY 2";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos que contengan en su
	 * Folio el String campo
	 * 
	 * @param campo
	 *            Folio del Asunto
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getBusquedaPorFolioA(String campo) {
		String sql = "";
		sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, TO_CHAR(ASU_FECHA_CAPTURA, 'DD/MM/YYYY HH:MI:SS AM'), ID_ASUNTO, ASU_CONTROL "
				+ "FROM SD_ASUNTO WHERE LOWER(ASU_FOLIO_RECEPCION) LIKE LOWER('%"
				+ campo + "%') " + "ORDER BY 1";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar las Instrucciones que contengan en
	 * su Folio el String campo
	 * 
	 * @param campo
	 *            Folio de la instrucciÛn
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getBusquedaPorFolioI(String campo) {
		String sql = "";
		// campo = campo.toUpperCase();
		sql = "SELECT ID_INSTRUCCION_ASUNTO, INS_FOLIO_TURNADO, TO_CHAR(INS_FECHA_ASIGNACION, 'DD/MM/YYYY HH:MI:SS AM'), "
				+ "INS_INSTRUCCION, INS_INSTRUCCION_OTRO, USU_NOMBRE "
				+ "FROM SD_INSTRUCCION_ASUNTO, SD_ASUNTO, SD_USUARIO "
				+ "WHERE LOWER(INS_FOLIO_TURNADO) LIKE LOWER('%"
				+ campo
				+ "%') "
				+ "AND INS_ESTATUS <> 0 "
				+ "AND SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO "
				+ "AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA "
				+ "ORDER BY 2";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos por Remitente
	 * 
	 * @param campo
	 *            Remitente
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getBusquedaPorSolicitanteA(String campo) {
		String sql = "";
		/*
		 * sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION,
		 * ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL " + "FROM SD_ASUNTO,
		 * SD_REMITENTE, SD_USUARIO WHERE (LOWER(RMT_NOMBRE) LIKE
		 * LOWER('%"+campo+"%') " + "AND
		 * SD_REMITENTE.ID_REMITENTE=SD_ASUNTO.ASU_REMITENTE) " + "OR
		 * (LOWER(USU_NOMBRE) LIKE LOWER('%"+campo+"%') " + "AND
		 * SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_REMITENTE)" + "ORDER BY 1";
		 */
		sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, TO_CHAR(ASU_FECHA_CAPTURA, 'DD/MM/YYYY HH:MI:SS AM'), ID_ASUNTO, ASU_CONTROL "
				+ "FROM SD_ASUNTO WHERE "
				+ "(ASU_REMITENTE IN( "
				+ "SELECT ID_REMITENTE "
				+ "FROM SD_REMITENTE "
				+ "WHERE LOWER(RMT_NOMBRE) LIKE LOWER('%"
				+ campo
				+ "%')) AND ASU_CONTROL=0) OR "
				+ "(ASU_REMITENTE IN( "
				+ "SELECT ID_USUARIO "
				+ "FROM SD_USUARIO "
				+ "WHERE LOWER(USU_CARGO) LIKE LOWER('%"
				+ campo
				+ "%')) AND ASU_CONTROL=1) ORDER BY 1";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar las Instrucciones por Solicitante
	 * 
	 * @param campo
	 *            Solicitnate
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getBusquedaPorSolicitanteI(String campo) {
		String sql = "";
		// campo = campo.toUpperCase();
		sql = "SELECT ID_INSTRUCCION_ASUNTO, INS_FOLIO_TURNADO, TO_CHAR(INS_FECHA_ASIGNACION, 'DD/MM/YYYY HH:MI:SS AM'), "
				+ "INS_INSTRUCCION, INS_INSTRUCCION_OTRO, USU_NOMBRE "
				+ "FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO "
				+ "WHERE LOWER(USU_NOMBRE) LIKE LOWER('%"
				+ campo
				+ "%') "
				+ "AND INS_ESTATUS <> 0 "
				+ "AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
				+ "ORDER BY 2";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos por Nombre de la Unidad
	 * Administrativa
	 * 
	 * @param campo
	 *            Unidad Administrativa
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getBusquedaPorAreaA(String campo) {
		String sql = "";
		sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, TO_CHAR(ASU_FECHA_CAPTURA, 'DD/MM/YYYY HH:MI:SS AM'), ID_ASUNTO, ASU_CONTROL "
				+ "FROM SD_ASUNTO, SD_AREA WHERE LOWER(ARE_NOMBRE) LIKE LOWER('%"
				+ campo
				+ "%') "
				+ "AND SD_ASUNTO.ASU_AREA_RECEPCION=SD_AREA.ID_AREA "
				+ "ORDER BY 1";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar las Instrucciones por Nombre de la
	 * Unidad Administrativa
	 * 
	 * @param campo
	 *            Unidad Administrativa
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getBusquedaPorAreaI(String campo) {
		String sql = "";
		// campo = campo.toUpperCase();
		sql = "SELECT ID_INSTRUCCION_ASUNTO, INS_FOLIO_TURNADO, TO_CHAR(INS_FECHA_ASIGNACION, 'DD/MM/YYYY HH:MI:SS AM'), "
				+ "INS_INSTRUCCION, INS_INSTRUCCION_OTRO, USU_NOMBRE "
				+ "FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, SD_AREA "
				+ "WHERE LOWER(ARE_NOMBRE) LIKE LOWER('%"
				+ campo
				+ "%') "
				+ "AND INS_ESTATUS <> 0 "
				+ "AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
				+ "AND SD_AREA.ID_AREA=SD_USUARIO.USU_AREA " + "ORDER BY 2";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos por Fecha de Captura
	 * 
	 * @param campo
	 *            Fecha de Captura
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getBusquedaPorFechaA(String campo) {
		String sql = "";
		sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, TO_CHAR(ASU_FECHA_CAPTURA, 'DD/MM/YYYY HH:MI:SS AM'), ID_ASUNTO, ASU_CONTROL "
				+ "FROM SD_ASUNTO WHERE TO_CHAR(ASU_FECHA_CAPTURA, 'DD/MM/YYYY')='"
				+ campo + "' " + "ORDER BY 1";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar las Instrucciones por Fecha de
	 * Captura
	 * 
	 * @param campo
	 *            Fecha de Captura
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getBusquedaPorFechaI(String campo) {
		String sql = "";
		sql = "SELECT ID_INSTRUCCION_ASUNTO, INS_FOLIO_TURNADO, TO_CHAR(INS_FECHA_ASIGNACION, 'DD/MM/YYYY HH:MI:SS AM'), "
				+ "INS_INSTRUCCION, INS_INSTRUCCION_OTRO, USU_NOMBRE "
				+ "FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO "
				+ "WHERE TO_CHAR(INS_FECHA_ASIGNACION, 'DD/MM/YYYY')='"
				+ campo
				+ "' "
				+ "AND INS_ESTATUS <> 0 "
				+ "AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
				+ "ORDER BY 2";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos resultado de la busqueda
	 * multicriterio
	 * 
	 * @param BeanBuscar
	 *            Bean de datos de la busqueda
	 * @param strOrden
	 *            Campo por el cual se ordenar· la busqueda
	 * @param strTipo
	 *            Ordenamiento Ascendente o Descendente
	 * @param strIdUsuario
	 *            Usuario que realiza la busqueda
	 * @param strIdArea
	 *            UA del usuario que realiza la busqueda
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getBuscarMultiCampoAsunto(BuscarCampo BeanBuscar,
			String strOrden, String strTipo, String strIdUsuario,
			String strIdArea, String busquedaContent) {

		String buscaEntidad = BeanBuscar.getbuscaEntidad();
		String buscaRemitente = BeanBuscar.getbuscaRemitente();
		String buscaVentanilla = BeanBuscar.getbuscaVentanilla();
		String buscaPara = BeanBuscar.getbuscaPara();
		String buscaCC = BeanBuscar.getbuscaCC();
		String buscaAsunto = BeanBuscar.getbuscaAsunto();
		String buscaEstatus[] = BeanBuscar.getbuscaEstatus();
		String buscaExpediente = BeanBuscar.getbuscaExpediente();
		String buscaTipoDoc = BeanBuscar.getbuscaTipoDoc();
		String buscaTramite = BeanBuscar.getbuscaTramite();
		String buscaFechaCapI = BeanBuscar.getbuscaFechaCapI();
		String buscaFechaCapF = BeanBuscar.getbuscaFechaCapF();
		String buscaFechaRecI = BeanBuscar.getbuscaFechaRecI();
		String buscaFechaRecF = BeanBuscar.getbuscaFechaRecF();
		String buscaFechaDocI = BeanBuscar.getbuscaFechaDocI();
		String buscaFechaDocF = BeanBuscar.getbuscaFechaDocF();
		String buscaFechaComI = BeanBuscar.getbuscaFechaComI();
		String buscaFechaComF = BeanBuscar.getbuscaFechaComF();
		String buscaIdDoc = BeanBuscar.getbuscaIdDoc();
		String buscaFolio = BeanBuscar.getbuscaFolio();
		String buscaPalabraClave = BeanBuscar.getbuscaPalabraClave();
		String buscaFirmante = BeanBuscar.getbuscaFirmante();
		String buscaFolioInter = BeanBuscar.getbuscaFolioInter();
		String buscaSolicitud = BeanBuscar.getbuscaSolicitud();
		String buscaComentario = BeanBuscar.getbuscaComentario();
		String buscaFechaEveI = BeanBuscar.getbuscaFechaEveI();
		String buscaFechaEveF = BeanBuscar.getbuscaFechaEveF();
		String buscaEvento = BeanBuscar.getbuscaEvento();
		String buscaPrioridad = BeanBuscar.getbuscaPrioridad();
		String buscaTipoAsunto = BeanBuscar.getbuscaTipoAsunto();
		String buscaCaptura = BeanBuscar.getbuscaCaptura();
		String buscaFolioControl = BeanBuscar.getbuscaFolioControl();
		String horaRecepcionI = BeanBuscar.getHoraRecepcionI();
		String minRecepcionI = BeanBuscar.getMinRecepcionF();
		String horaRecepcionF = BeanBuscar.getHoraRecepcionF();
		String minRecepcionF = BeanBuscar.getMinRecepcionF();
		String relacionAnexada = BeanBuscar.getRelacionAnexada();
		String tipoRelacion[] = BeanBuscar.getTipoRelacion();
		String controlFolio[] = BeanBuscar.getControlFolio();
		String horaEventoI = BeanBuscar.getHoraEventoI();
		String minEventoI = BeanBuscar.getMinEventoI();
		String horaEventoF = BeanBuscar.getHoraEventoF();
		String minEventoF = BeanBuscar.getMinEventoF();
		String buscaFechaTerI = BeanBuscar.getBuscaFechaTerI();
		String buscaFechaTerF = BeanBuscar.getBuscaFechaTerF();
		String avanceAsuntoI = BeanBuscar.getAvanceAsuntoI();
		String avanceAsuntoF = BeanBuscar.getAvanceAsuntoF();

		String sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
				+ "TO_CHAR(ASU_FECHA_CAPTURA, 'DD/MM/YYYY HH24:MI:SS') AS FECHA, ID_ASUNTO, ASU_CONTROL, ASU_FECHA_CAPTURA, "
				+ "CASE ASU_CONTROL "
				+ "WHEN 1 THEN ( "
				+ "CASE ASU_ESTATUS	"
				+ "WHEN 0 THEN (SELECT USU_CARGO FROM SD_USUARIO WHERE ID_USUARIO=ASU_REMITENTE)	"
				+ "WHEN 1 THEN (SELECT USU_CARGO FROM SD_USUARIO WHERE ID_USUARIO=ASU_REMITENTE)	"
				+ "WHEN 2 THEN (SELECT ASU_REF_REMITENTE_NOMBRE FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF=ID_ASUNTO)  	"
				+ "WHEN 3 THEN (SELECT ASU_REF_REMITENTE_NOMBRE FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF=ID_ASUNTO)     "
				+ "END ) "
				+ "WHEN 0 THEN ("
				+ "CASE ASU_ESTATUS 	"
				+ "WHEN 0 THEN (SELECT RMT_NOMBRE FROM SD_REMITENTE WHERE ID_REMITENTE=ASU_REMITENTE) 	"
				+ "WHEN 1 THEN (SELECT RMT_NOMBRE FROM SD_REMITENTE WHERE ID_REMITENTE=ASU_REMITENTE)	    "
				+ "WHEN 2 THEN (SELECT ASU_REF_REMITENTE_NOMBRE FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF=ID_ASUNTO)	  "
				+ "WHEN 3 THEN (SELECT ASU_REF_REMITENTE_NOMBRE FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF=ID_ASUNTO)   "
				+ "END ) "
				+ "END AS REMITENTE, TO_CHAR(ASU_FECHA_CADUCIDAD, 'yyyy-MM-dd'), TO_CHAR(ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), "
				+ // 10
				"ASU_AVANCE, ASU_FOLIO_ENTRADA "; // 12

		if (busquedaContent.equals("5")) {
			sql += ", NOMBRE_ARCHIVO " + "FROM SD_ASUNTO, SD_CONTENT_ORACLE "
					+ "WHERE ID_ASUNTO_CONTENT = ID_ASUNTO "
					+ "AND ID_INS_CONTENT = -1 AND";
		} else {
			sql += "FROM SD_ASUNTO WHERE  ";

		}
		/*
		 * sql += " ID_ASUNTO IN ( SELECT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO,
		 * SD_USUARIO_ROL " + " WHERE
		 * SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA " + " AND
		 * SD_USUARIO.ID_USUARIO = SD_USUARIO_ROL.ID_USUARIO1 " + " AND
		 * (ASU_REMITENTE=" + strIdUsuario + " OR ASU_USUARIO_CAPTURA= " +
		 * strIdUsuario + " OR ASU_USR_TURNA= " + strIdUsuario + " OR
		 * (USU_AREA=" + strIdArea +" AND ID_ROL=5) " + " OR (USU_AREA=" +
		 * strIdArea +" AND ID_ROL=4) ) UNION " + " SELECT ID_ASUNTO FROM
		 * SD_INSTRUCCION_ASUNTO " + " WHERE INS_USUARIO = "+strIdUsuario+" AND
		 * INS_ACCESO = 1) ";
		 */
		sql += " ID_ASUNTO IN ( SELECT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO "
				+ " WHERE SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA "
				+ " AND (ASU_REMITENTE=" + strIdUsuario
				+ " OR ASU_USUARIO_CAPTURA= " + strIdUsuario
				+ " OR ASU_USR_TURNA= " + strIdUsuario + " OR (USU_AREA="
				+ strIdArea + ") " + " OR (USU_AREA=" + strIdArea
				+ ") ) UNION "
				+ " SELECT ID_ASUNTO FROM SD_INSTRUCCION_ASUNTO "
				+ " WHERE INS_USUARIO = " + strIdUsuario
				+ " AND INS_ACCESO = 1) ";

		if (buscaEntidad != null && buscaEntidad.length() > 0) {
			sql += "AND ((ASU_ENTIDAD IN ( "
					+ "SELECT ID_AREA FROM SD_AREA WHERE ARE_ESTATUS = 1	"
					+ "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaEntidad, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				// aux.equals()
				sql += "LOWER(TRANSLATE(ARE_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄ö','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) AND ASU_CONTROL = 1) "
					+ "OR (ASU_ENTIDAD IN (	"
					+ "SELECT ID_ENTIDAD FROM SD_ENTIDAD WHERE ENT_ESTATUS = 1	"
					+ "AND ( ";

			strToken = new StringTokenizer(buscaEntidad, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ENT_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄ö','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) AND ASU_CONTROL = 0) OR "
					+ "(ID_ASUNTO IN (SELECT ID_ASUNTO_REF FROM SD_ASUNTO_DESCRIPCION WHERE ";

			strToken = new StringTokenizer(buscaEntidad, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_REF_ENTIDAD,'·ÈÌÛ˙¡…Õ”⁄ö','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += "))) ";

		}
		if (buscaRemitente != null && buscaRemitente.length() > 0) {

			sql += "AND ((ASU_REMITENTE IN(	"
					+ "SELECT ID_REMITENTE FROM SD_REMITENTE WHERE RMT_ESTATUS = 1	"
					+ "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaRemitente, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "(LOWER(TRANSLATE(RMT_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄ö','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux
						+ "','·ÈÌÛ˙¡…Õ”⁄ö','aeiouAEIOU')) OR "
						+ "LOWER(TRANSLATE(RMT_CARGO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU'))) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) AND ASU_CONTROL=0) "
					+ "OR  (ASU_REMITENTE IN(	"
					+ "SELECT ID_USUARIO FROM SD_USUARIO WHERE USU_ESTATUS = 1 "
					+ "AND ( ";

			strToken = new StringTokenizer(buscaRemitente, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "(LOWER(TRANSLATE(USU_CARGO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux
						+ "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) OR "
						+ "LOWER(TRANSLATE(USU_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU'))) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) AND ASU_CONTROL=1) OR (ID_ASUNTO IN (SELECT ID_ASUNTO_REF FROM SD_ASUNTO_DESCRIPCION WHERE ";

			strToken = new StringTokenizer(buscaRemitente, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "(LOWER(TRANSLATE(ASU_REF_REMITENTE_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux
						+ "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) OR "
						+ "LOWER(TRANSLATE(ASU_REF_REMITENTE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU'))) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += "))) ";
		}
		if (buscaVentanilla != null && buscaVentanilla.length() > 0) {
			/*
			 * sql += "AND ASU_USR_TURNA IN ( " + "SELECT ID_USUARIO FROM
			 * SD_USUARIO WHERE USU_ESTATUS = 1 " + "AND LOWER(USU_NOMBRE) LIKE
			 * LOWER('%"+buscaVentanilla+"%')) ";
			 */

			sql += "AND (ASU_USR_TURNA IN ( 	"
					+ "SELECT ID_USUARIO FROM SD_USUARIO WHERE USU_ESTATUS = 1	"
					+ "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaVentanilla, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "(LOWER(TRANSLATE(USU_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux
						+ "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) OR "
						+ "LOWER(TRANSLATE(USU_CARGO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU'))) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) OR (ID_ASUNTO IN (SELECT ID_ASUNTO_REF FROM SD_ASUNTO_DESCRIPCION WHERE ";

			strToken = new StringTokenizer(buscaVentanilla, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "(LOWER(TRANSLATE(ASU_TURNADOR_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux
						+ "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) OR "
						+ "LOWER(TRANSLATE(ASU_TURNADOR_PUESTO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU'))) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += "))) ";
		}
		if (buscaPara != null && buscaPara.length() > 0) {
			// sql += "AND LOWER(ASU_LISTA_PARA) LIKE LOWER('%"+buscaPara+"%')
			// ";

			sql += "AND (( ASU_LISTAIDS_PARA IN (SELECT '%,'||ID_USUARIO||',%' FROM SD_USUARIO WHERE ";
			StringTokenizer strToken = new StringTokenizer(buscaPara, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "(LOWER(TRANSLATE(USU_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux
						+ "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) OR "
						+ "LOWER(TRANSLATE(USU_CARGO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU'))) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) OR ( ASU_LISTAIDS_CC IN (SELECT '%,'||ID_USUARIO||',%' FROM SD_USUARIO WHERE ";
			strToken = new StringTokenizer(buscaPara, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "(LOWER(TRANSLATE(USU_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux
						+ "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) OR "
						+ "LOWER(TRANSLATE(USU_CARGO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU'))) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) OR ( ASU_LISTAIDS_PARA_EXT IN (SELECT '%,'||ID_REMITENTE||',%' FROM SD_REMITENTE WHERE ";
			strToken = new StringTokenizer(buscaPara, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "(LOWER(TRANSLATE(RMT_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux
						+ "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) OR "
						+ "LOWER(TRANSLATE(RMT_CARGO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU'))) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) OR ( ID_ASUNTO IN (SELECT ID_ASUNTO_REF FROM SD_REF_DESTINATARIOS WHERE ";
			strToken = new StringTokenizer(buscaPara, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(REF_DESCRIPCION,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += " ))) ";
		}
		if (buscaAsunto != null && buscaAsunto.length() > 0) {
			sql += "AND ( ";

			StringTokenizer strToken = new StringTokenizer(buscaAsunto, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_DESCRIPCION,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += " ) ";
		}
		if (buscaEstatus != null && buscaEstatus.length > 0) {

			String strEstatus = "";
			for (int i = 0; i < buscaEstatus.length; i++) {
				strEstatus = strEstatus + buscaEstatus[i] + ",";
			}
			strEstatus = strEstatus.substring(0, strEstatus.length() - 1);
			sql += "AND ASU_ESTATUS IN (" + strEstatus + ") ";
		}
		if (buscaExpediente != null && buscaExpediente.length() > 0) {

			sql += "AND (ASU_EXPEDIENTE IN ( "
					+ "SELECT ID_EXPEDIENTE FROM SD_EXPEDIENTES WHERE EXP_STATUS <> 0 "
					+ "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaExpediente, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "(LOWER(TRANSLATE(EXP_CLAVE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux
						+ "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) OR "
						+ "LOWER(TRANSLATE(EXP_DENOMINACION,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')))";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) OR ( ";

			strToken = new StringTokenizer(buscaExpediente, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_EXPEDIENTE_OTRO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) ";
		}
		if (buscaTipoDoc != null && buscaTipoDoc.length() > 0) {
			/*
			 * sql += "AND ASU_TIP_DOCTO IN ( " + "SELECT ID_TIPO_DOCTO FROM
			 * SD_TIPO_DOCUMENTO WHERE TIP_DOCTO_ESTATUS = 1 " + "AND
			 * LOWER(TIP_DOCTO_NOMBRE) LIKE LOWER('%"+buscaTipoDoc+"%')) ";
			 */

			sql += "AND (ASU_TIP_DOCTO IN ( "
					+ "SELECT ID_TIPO_DOCTO FROM SD_TIPO_DOCUMENTO WHERE TIP_DOCTO_ESTATUS = 1 "
					+ "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaTipoDoc, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(TIP_DOCTO_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) OR (ID_ASUNTO IN (SELECT ID_ASUNTO_REF FROM SD_ASUNTO_DESCRIPCION WHERE ";

			strToken = new StringTokenizer(buscaTipoDoc, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_REF_TIPO_DOCTO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += "))) ";
		}
		if (buscaTramite != null && buscaTramite.length() > 0) {
			/*
			 * sql += "AND ASU_TRAMITE IN ( " + "SELECT ID_TRAMITE FROM
			 * SD_TRAMITE WHERE TRA_ESTATUS = 1 " + "AND LOWER(TRA_NOMBRE) LIKE
			 * LOWER('%"+buscaTramite+"%')) ";
			 */

			sql += "AND (ASU_TRAMITE IN ( "
					+ "SELECT ID_TRAMITE FROM SD_TRAMITE WHERE TRA_ESTATUS = 1 "
					+ "AND  ( ";
			StringTokenizer strToken = new StringTokenizer(buscaTramite, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(TRA_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) OR (ID_ASUNTO IN (SELECT ID_ASUNTO_REF FROM SD_ASUNTO_DESCRIPCION WHERE ";

			strToken = new StringTokenizer(buscaTramite, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_REF_TRAMITE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += "))) ";
		}
		if (buscaFechaCapI != null && buscaFechaCapI.length() > 0) {
			sql += "AND ASU_FECHA_CAPTURA 	>= TO_DATE('" + buscaFechaCapI
					+ " 00:00:00', 'DD/MM/YYYY HH24:MI:SS') ";
		}
		if (buscaFechaCapF != null && buscaFechaCapF.length() > 0) {
			sql += "AND ASU_FECHA_CAPTURA 	<= TO_DATE('" + buscaFechaCapF
					+ " 23:59:59', 'DD/MM/YYYY HH24:MI:SS') ";
		}
		if (buscaFechaRecI != null && buscaFechaRecI.length() > 0) {
			sql += "AND ASU_FECHA_RECEPCION >= TO_DATE('" + buscaFechaRecI
					+ " " + horaRecepcionI + ":" + minRecepcionI
					+ ":00', 'DD/MM/YYYY HH24:MI:SS') ";
		}
		if (buscaFechaRecF != null && buscaFechaRecF.length() > 0) {
			sql += "AND ASU_FECHA_RECEPCION <= TO_DATE('" + buscaFechaRecF
					+ " " + horaRecepcionF + ":" + minRecepcionF
					+ ":59', 'DD/MM/YYYY HH24:MI:SS') ";
		}
		if (buscaFechaDocI != null && buscaFechaDocI.length() > 0) {
			sql += "AND ASU_FECHA_DOCTO 	>= TO_DATE('" + buscaFechaDocI
					+ " 00:00:00', 'DD/MM/YYYY HH24:MI:SS') ";
		}
		if (buscaFechaDocF != null && buscaFechaDocF.length() > 0) {
			sql += "AND ASU_FECHA_DOCTO 	<= TO_DATE('" + buscaFechaDocF
					+ " 23:59:59', 'DD/MM/YYYY HH24:MI:SS') ";
		}
		if (buscaFechaComI != null && buscaFechaComI.length() > 0) {
			sql += "AND ASU_FECHA_CADUCIDAD >= TO_DATE('" + buscaFechaComI
					+ " 00:00:00', 'DD/MM/YYYY HH24:MI:SS') ";
		}
		if (buscaFechaComF != null && buscaFechaComF.length() > 0) {
			sql += "AND ASU_FECHA_CADUCIDAD <= TO_DATE('" + buscaFechaComF
					+ " 23:59:59', 'DD/MM/YYYY HH24:MI:SS') ";
		}
		if (buscaIdDoc != null && buscaIdDoc.length() > 0) {
			// sql += "AND LOWER(ASU_FOLIO_EXTERNO) LIKE
			// LOWER('%"+buscaIdDoc+"%') ";

			sql += "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaIdDoc, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_FOLIO_EXTERNO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ") ";
		}
		if (buscaFolio != null && buscaFolio.length() > 0) {
			// sql += "AND LOWER(ASU_FOLIO_RECEPCION) LIKE
			// LOWER('%"+buscaFolio+"%') ";

			sql += "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaFolio, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_FOLIO_RECEPCION,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ") ";
		}
		if (buscaPalabraClave != null && buscaPalabraClave.length() > 0) {
			// sql += "AND LOWER(ASU_PALABRA_CLAVE) LIKE
			// LOWER('%"+buscaPalabraClave+"%') ";

			sql += "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaPalabraClave,
					",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_PALABRA_CLAVE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ") ";
		}
		if (buscaFirmante != null && buscaFirmante.length() > 0) {

			sql += "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaFirmante, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_FIRMANTE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ") ";
		}
		if (buscaFolioInter != null && buscaFolioInter.length() > 0) {

			sql += "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaFolioInter, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_FOLIO_INTERMEDIO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ") ";
		}
		if (buscaSolicitud != null && buscaSolicitud.length() > 0) {

			sql += "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaSolicitud, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_SINTESIS,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ") ";
		}
		if (buscaComentario != null && buscaComentario.length() > 0) {

			sql += "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaComentario, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_COMENTARIOS,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ") ";
		}
		if (buscaFechaEveI != null && buscaFechaEveI.length() > 0) {
			sql += "AND ID_ASUNTO IN (SELECT ID_ASUNTO "
					+ "FROM SD_ASUNTO "
					+ "WHERE ASU_FECHA_EVENTO IS NOT null "
					+ "AND ASU_HORA_EVENTO IS NOT null "
					+ "AND ASU_MIN_EVENTO IS NOT null "
					+ "AND TO_DATE(TO_CHAR(ASU_FECHA_EVENTO,'DD/MM/YYYY')||' '||ASU_HORA_EVENTO||':'||ASU_MIN_EVENTO,'DD/MM/YYYY HH24:MI') "
					+ " >= TO_DATE('" + buscaFechaEveI + " " + horaEventoI
					+ ":" + minEventoI + ":00', 'DD/MM/YYYY HH24:MI:SS')) ";
		}
		if (buscaFechaEveF != null && buscaFechaEveF.length() > 0) {
			sql += "AND ID_ASUNTO IN (SELECT ID_ASUNTO "
					+ "FROM SD_ASUNTO "
					+ "WHERE ASU_FECHA_EVENTO IS NOT null "
					+ "AND ASU_HORA_EVENTO IS NOT null "
					+ "AND ASU_MIN_EVENTO IS NOT null "
					+ "AND TO_DATE(TO_CHAR(ASU_FECHA_EVENTO,'DD/MM/YYYY')||' '||ASU_HORA_EVENTO||':'||ASU_MIN_EVENTO,'DD/MM/YYYY HH24:MI') "
					+ " <= TO_DATE('" + buscaFechaEveF + " " + horaEventoF
					+ ":" + minEventoF + ":59', 'DD/MM/YYYY HH24:MI:SS')) ";
		}
		if (buscaEvento != null && buscaEvento.length() > 0) {

			sql += "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaEvento, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_LUGAR_EVENTO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ") ";
		}
		if (buscaPrioridad != null && buscaPrioridad.length() > 0) {
			sql += "AND (ASU_PRIORIDAD IN ( "
					+ "SELECT ID_PRIORIDADES FROM SD_PRIORIDAD WHERE PRI_ESTATUS = 1 "
					+ "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaPrioridad, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(PRI_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) OR (ID_ASUNTO IN (SELECT ID_ASUNTO_REF FROM SD_ASUNTO_DESCRIPCION WHERE ";

			strToken = new StringTokenizer(buscaPrioridad, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_REF_PRIORIDAD,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += "))) ";
		}
		if (buscaTipoAsunto != null && buscaTipoAsunto.length() > 0) {
			sql += "AND (ASU_TIPO_ASUNTO IN ( "
					+ "SELECT ID_TIPO_ASUNTO FROM SD_TIPO_ASUNTO WHERE TIP_ASU_ESTATUS = 1 "
					+ "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaTipoAsunto, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(TIP_ASU_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) OR (ID_ASUNTO IN (SELECT ID_ASUNTO_REF FROM SD_ASUNTO_DESCRIPCION WHERE ";

			strToken = new StringTokenizer(buscaTipoAsunto, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_REF_TIPO_ASUNTO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += "))) ";
		}
		if (buscaCaptura != null && buscaCaptura.length() > 0) {

			sql += "AND (ASU_USUARIO_CAPTURA IN ( 	"
					+ "SELECT ID_USUARIO FROM SD_USUARIO WHERE USU_ESTATUS = 1	"
					+ "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaCaptura, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "(LOWER(TRANSLATE(USU_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux
						+ "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) OR "
						+ "LOWER(TRANSLATE(USU_CARGO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')))";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) OR (ID_ASUNTO IN (SELECT ID_ASUNTO_REF FROM SD_ASUNTO_DESCRIPCION WHERE ";

			strToken = new StringTokenizer(buscaCaptura, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_REF_USR_CAPTURA,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += "))) ";
		}
		if (buscaFolioControl != null && buscaFolioControl.length() > 0) {

			sql += "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaFolioControl,
					",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_FOLIO_ENTRADA,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ") ";
		}
		if (relacionAnexada != null && relacionAnexada.length() > 0) {

			sql += "AND ( ID_ASUNTO IN (SELECT SD_ASUNTOS__ANT.ID_ASUNTO FROM SD_ASUNTOS__ANT, SD_ASUNTO "
					+ "WHERE SD_ASUNTO.ID_ASUNTO = SD_ASUNTOS__ANT.ID_ASUNTOS_REL AND ";
			StringTokenizer strToken = new StringTokenizer(relacionAnexada, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_FOLIO_RECEPCION,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += "AND ( ";
			if (tipoRelacion != null && tipoRelacion.length > 0) {
				for (int i = 0; i < tipoRelacion.length; i++) {
					// System.out.println(i+".- "+tipoRelacion[i]);
					if (i == tipoRelacion.length - 1) {
						sql += "TIPO_REF LIKE '" + tipoRelacion[i] + "' ";
					} else {
						sql += "TIPO_REF LIKE '" + tipoRelacion[i] + "' OR ";
					}
				}
			}
			sql += "))) ";
		}
		if (controlFolio != null && controlFolio.length > 0) {

			String strControl = "";
			for (int i = 0; i < controlFolio.length; i++) {
				strControl = strControl + controlFolio[i] + ",";
			}
			strControl = strControl.substring(0, strControl.length() - 1);
			sql += "AND ASU_CONTROL_FOLIO IN (" + strControl + ") ";
		}
		if (buscaFechaTerI != null && buscaFechaTerI.length() > 0) {
			sql += "AND ASU_FECHA_TERMINACION >= TO_DATE('" + buscaFechaTerI
					+ " 00:00:00', 'DD/MM/YYYY HH24:MI:SS') ";
		}
		if (buscaFechaTerF != null && buscaFechaTerF.length() > 0) {
			sql += "AND ASU_FECHA_TERMINACION <= TO_DATE('" + buscaFechaTerF
					+ " 23:59:59', 'DD/MM/YYYY HH24:MI:SS') ";
		}
		if (avanceAsuntoI != null && avanceAsuntoI.length() > 0) {
			sql += "AND ASU_AVANCE >= " + avanceAsuntoI + " ";
		}
		if (avanceAsuntoF != null && avanceAsuntoF.length() > 0) {
			sql += "AND ASU_AVANCE <= " + avanceAsuntoF + " ";
		}

		if (strTipo.equals("1")) {
			sql += "ORDER BY ASU_FOLIO_RECEPCION " + strOrden + " ";
		} else if (strTipo.equals("2")) {
			sql += "ORDER BY ASU_FOLIO_ENTRADA " + strOrden
					+ ", ASU_FOLIO_RECEPCION " + strOrden + " ";
		} else if (strTipo.equals("3")) {
			sql += "ORDER BY ASU_DESCRIPCION " + strOrden
					+ ", ASU_FOLIO_RECEPCION " + strOrden + " ";
		} else if (strTipo.equals("4")) {
			sql += "ORDER BY ASU_FECHA_CAPTURA " + strOrden
					+ ", ASU_FOLIO_RECEPCION " + strOrden + " ";
		}

		return sql;
	}

	/**
	 * Construye un SQL Query para regresar las Instrucciones resultado de la
	 * busqueda multicriterio
	 * 
	 * @param BeanBuscar
	 *            Bean de datos de la busqueda
	 * @param strOrden
	 *            Campo por el cual se ordenar· la busqueda
	 * @param strTipo
	 *            Ordenamiento Ascendente o Descendente
	 * @param strIdUsuario
	 *            Usuario que realiza la busqueda
	 * @param strIdArea
	 *            UA del usuario que realiza la busqueda
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getBuscarMultiCampoInstruccion(
			BuscarCampoIns BeanBuscar, String strOrden, String strTipo,
			String strIdUsuario, String strIdArea, String busquedaContent) {

		String buscaResponsable = BeanBuscar.getbuscaResponsable();
		String buscaTipoAte[] = BeanBuscar.getbuscaTipoAte();
		String buscaFechaGenI = BeanBuscar.getbuscaFechaGenI();
		String buscaFechaGenF = BeanBuscar.getbuscaFechaGenF();
		String buscaFechaVenI = BeanBuscar.getbuscaFechaVenI();
		String buscaFechaVenF = BeanBuscar.getbuscaFechaVenF();
		String buscaEstatus[] = BeanBuscar.getbuscaEstatus();
		String buscaNomIns = BeanBuscar.getbuscaNomIns();
		String buscaFolio = BeanBuscar.getbuscaFolio();
		String buscaAsunto = BeanBuscar.getBuscaAsunto();
		String buscaAsignadaPor = BeanBuscar.getBuscaAsignadaPor();
		String buscaFolioInter = BeanBuscar.getBuscaFolioInter();
		String avanceAsuntoI = BeanBuscar.getAvanceAsuntoI();
		String avanceAsuntoF = BeanBuscar.getAvanceAsuntoF();
		String buscaFolioControl = BeanBuscar.getBuscaFolioControl();
		String buscaExpediente = BeanBuscar.getBuscaExpediente();

		String sql = "SELECT ID_INSTRUCCION_ASUNTO, INS_FOLIO_TURNADO, "
				+ // 2
				"TO_CHAR(INS_FECHA_ASIGNACION, 'DD/MM/YYYY HH24:MI:SS') AS FECHA, "
				+ // 3
				"CASE "
				+ "	WHEN INS_INSTRUCCION IS NOT null THEN (SELECT INS_NOMBRE FROM SD_INSTRUCCION WHERE ID_INSTRUCCION = INS_INSTRUCCION) "
				+ "	ELSE INS_INSTRUCCION_OTRO "
				+ "END AS INS_NOMBRE, "
				+ // 4
				"INS_INSTRUCCION_OTRO, "
				+ // 5
				"(SELECT USU_CARGO FROM SD_USUARIO WHERE ID_USUARIO=INS_USUARIO) AS USU_NOMBRE, "
				+ // 6
				"INS_TIPO_ATENCION, INS_ESTATUS, INS_FECHA_ASIGNACION, INS_HABILITADA, INS_PADRE, "
				+ // 11
				"TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), "
				+ // 13
				"INS_TIEMPO, INS_AVANCE, "
				+ // 15
				"CASE INS_TIPO_ATENCION " + "	WHEN 0 THEN 'Ejecutoria' "
				+ "	WHEN 1 THEN 'Informativa' " + "END AS ATENCION "; // 16

		if (busquedaContent.equals("5")) {
			sql += ", NOMBRE_ARCHIVO, ASU_FOLIO_RECEPCION "
					+ "FROM SD_INSTRUCCION_ASUNTO, SD_CONTENT_ORACLE, SD_ASUNTO "
					+ "WHERE ID_INS_CONTENT = ID_INSTRUCCION_ASUNTO "
					+ "AND SD_INSTRUCCION_ASUNTO.ID_ASUNTO=SD_ASUNTO.ID_ASUNTO "
					+ "AND ID_INSTRUCCION_ASUNTO >= 0 ";
		} else {
			sql += "FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO >= 0 ";

		}

		sql += " AND ID_INSTRUCCION_ASUNTO IN (SELECT ID_INSTRUCCION_ASUNTO "
				+ " FROM SD_INSTRUCCION_ASUNTO, SD_ASUNTO, SD_USUARIO, SD_USUARIO_ROL "
				+ " WHERE SD_ASUNTO.ID_ASUNTO = SD_INSTRUCCION_ASUNTO.ID_ASUNTO "
				+ " AND SD_USUARIO.ID_USUARIO = SD_INSTRUCCION_ASUNTO.INS_USUARIO "
				+ " AND SD_USUARIO.ID_USUARIO = SD_USUARIO_ROL.ID_USUARIO1 "
				+ " AND (ID_USUARIO="
				+ strIdUsuario
				+ " "
				+
				// " OR USU_ASISTENTE="+strIdUsuario+" " +
				" OR USU_JEFE=" + strIdUsuario + " " + " OR ASU_USR_TURNA="
				+ strIdUsuario + " " + " OR INS_TURNO=" + strIdUsuario + " "
				+ " OR (USU_AREA=" + strIdArea + " AND ID_ROL=1) "
				+ " OR (USU_AREA=" + strIdArea + " AND ID_ROL=5) "
				+ " OR (USU_AREA=" + strIdArea + " AND ID_ROL=4) " + " )) ";

		if (buscaResponsable != null && buscaResponsable.length() > 0) {
			/*
			 * sql += "AND INS_USUARIO IN ( " + "SELECT ID_USUARIO FROM
			 * SD_USUARIO " + "WHERE LOWER(USU_CARGO) LIKE
			 * LOWER('%"+buscaResponsable+"%')) ";
			 */

			sql += "AND INS_USUARIO IN ( "
					+ "SELECT ID_USUARIO FROM SD_USUARIO " + "WHERE ( ";
			StringTokenizer strToken = new StringTokenizer(buscaResponsable,
					",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "(LOWER(TRANSLATE(USU_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux
						+ "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) OR "
						+ "LOWER(TRANSLATE(USU_CARGO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')))";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) ";
		}
		if (buscaTipoAte != null && buscaTipoAte.length > 0) {
			String strTipoAte = "";
			for (int i = 0; i < buscaTipoAte.length; i++) {
				strTipoAte = strTipoAte + buscaTipoAte[i] + ",";
			}
			strTipoAte = strTipoAte.substring(0, strTipoAte.length() - 1);
			sql += "AND INS_TIPO_ATENCION IN (" + strTipoAte + ") ";
		}
		if (buscaFechaGenI != null && buscaFechaGenI.length() > 0) {
			sql += "AND INS_FECHA_ASIGNACION	>= TO_DATE('" + buscaFechaGenI
					+ " 00:00:00', 'DD/MM/YYYY HH24:MI:SS') ";
		}
		if (buscaFechaGenF != null && buscaFechaGenF.length() > 0) {
			sql += "AND INS_FECHA_ASIGNACION	<= TO_DATE('" + buscaFechaGenF
					+ " 23:59:59', 'DD/MM/YYYY HH24:MI:SS') ";
		}
		if (buscaFechaVenI != null && buscaFechaVenI.length() > 0) {
			sql += "AND INS_FECHA_TERMINACION	>= TO_DATE('" + buscaFechaVenI
					+ " 00:00:00', 'DD/MM/YYYY HH24:MI:SS') ";
		}
		if (buscaFechaVenF != null && buscaFechaVenF.length() > 0) {
			sql += "AND INS_FECHA_TERMINACION	<= TO_DATE('" + buscaFechaVenF
					+ " 23:59:59', 'DD/MM/YYYY HH24:MI:SS') ";
		}
		if (buscaEstatus != null && buscaEstatus.length > 0) {
			String strEstatus = "";
			for (int i = 0; i < buscaEstatus.length; i++) {
				strEstatus = strEstatus + buscaEstatus[i] + ",";
			}
			strEstatus = strEstatus.substring(0, strEstatus.length() - 1);
			sql += "AND INS_ESTATUS IN (" + strEstatus + ") ";
		}
		if (buscaNomIns != null && buscaNomIns.length() > 0) {

			sql += "AND (( ";
			StringTokenizer strToken = new StringTokenizer(buscaNomIns, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(INS_INSTRUCCION_OTRO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ") OR INS_INSTRUCCION IN ( "
					+ "SELECT ID_INSTRUCCION FROM SD_INSTRUCCION WHERE (";
			strToken = new StringTokenizer(buscaNomIns, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(INS_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += "))) ";
		}
		if (buscaFolio != null && buscaFolio.length() > 0) {

			sql += "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaFolio, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(INS_FOLIO_TURNADO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ") ";
		}
		if (buscaAsignadaPor != null && buscaAsignadaPor.length() > 0) {

			sql += "AND INS_TURNO IN (" + "SELECT ID_USUARIO FROM SD_USUARIO "
					+ "WHERE ( ";
			StringTokenizer strToken = new StringTokenizer(buscaAsignadaPor,
					",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "(LOWER(TRANSLATE(USU_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux
						+ "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) OR "
						+ "LOWER(TRANSLATE(USU_CARGO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')))";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) ";
		}
		if (buscaAsunto != null && buscaAsunto.length() > 0) {
			sql += "AND ID_ASUNTO IN ( " + "SELECT ID_ASUNTO FROM SD_ASUNTO "
					+ "WHERE ( ";
			StringTokenizer strToken = new StringTokenizer(buscaAsunto, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_DESCRIPCION,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU'))";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) ";
		}
		if (buscaFolioInter != null && buscaFolioInter.length() > 0) {
			sql += "AND ID_ASUNTO IN ( " + "SELECT ID_ASUNTO FROM SD_ASUNTO "
					+ "WHERE ( ";
			StringTokenizer strToken = new StringTokenizer(buscaFolioInter, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_FOLIO_INTERMEDIO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU'))";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) ";
		}
		if (avanceAsuntoI != null && avanceAsuntoI.length() > 0) {
			sql += "AND INS_AVANCE	>= " + avanceAsuntoI + " ";
		}
		if (avanceAsuntoF != null && avanceAsuntoF.length() > 0) {
			sql += "AND INS_AVANCE	<= " + avanceAsuntoF + " ";
		}
		if (buscaFolioControl != null && buscaFolioControl.length() > 0) {
			sql += "AND ID_ASUNTO IN ( " + "SELECT ID_ASUNTO FROM SD_ASUNTO "
					+ "WHERE ( ";
			StringTokenizer strToken = new StringTokenizer(buscaFolioControl,
					",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(ASU_FOLIO_ENTRADA,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU'))";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) ";
		}
		if (buscaExpediente != null && buscaExpediente.length() > 0) {

			sql += "AND (INS_EXPEDIENTE_ID IN ( "
					+ "SELECT ID_EXPEDIENTE FROM SD_EXPEDIENTES WHERE EXP_STATUS <> 0 "
					+ "AND ( ";
			StringTokenizer strToken = new StringTokenizer(buscaExpediente, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "(LOWER(TRANSLATE(EXP_CLAVE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux
						+ "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) OR "
						+ "LOWER(TRANSLATE(EXP_DENOMINACION,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')))";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) OR ( ";

			strToken = new StringTokenizer(buscaExpediente, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				if (aux.charAt(0) == '\"'
						&& aux.charAt(aux.length() - 1) == '\"') {
					aux = "%" + aux.substring(1, aux.length() - 1) + "%";
				} else {
					aux = "%" + aux + "%";
				}
				sql += "LOWER(TRANSLATE(INS_EXPEDIENTE_NOMBRE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
						+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
				if (strToken.countTokens() != 0) {
					sql += "AND ";
				}
			}
			sql += ")) ";
		}

		if (strTipo.equals("1")) {
			sql += "ORDER BY INS_FOLIO_TURNADO " + strOrden + " ";
		} else if (strTipo.equals("2")) {
			sql += "ORDER BY USU_NOMBRE " + strOrden + ", INS_FOLIO_TURNADO "
					+ strOrden + " ";
		} else if (strTipo.equals("3")) {
			sql += "ORDER BY ATENCION " + strOrden + ", INS_FOLIO_TURNADO "
					+ strOrden + " ";
		} else if (strTipo.equals("4")) {
			sql += "ORDER BY INS_NOMBRE " + strOrden + ", INS_FOLIO_TURNADO "
					+ strOrden + " ";
		} else if (strTipo.equals("5")) {
			sql += "ORDER BY INS_FECHA_ASIGNACION " + strOrden
					+ ", INS_FOLIO_TURNADO " + strOrden + " ";
		}

		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos por su DescripciÛn
	 * 
	 * @param strAsunto
	 *            Descripcion del Asunto
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String busquedaAsunto(String strAsunto, String strPP) {
		String sql = "";
		sql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_ESTATUS, ASU_FOLIO_RECEPCION, "
				+ "ASU_AVANCE, USU_AREA, PRI_NUMERO_HEX "
				+ "FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD "
				+ "ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO "
				+ "WHERE ASU_DESCRIPCION LIKE '%"
				+ strAsunto
				+ "%' "
				+ "AND ASU_ESTATUS=1 "
				+ "AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA "
				+ "ORDER BY 2";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos resultado de una
	 * busqueda por Folio, Asunto, UA, Tipo de Documento, Fecha inicial de
	 * Captura y Fecha final de Captura
	 * 
	 * @param strFolio
	 *            Folio del Asunto
	 * @param strArea
	 *            Unidad Administrativa
	 * @param strAsunto
	 *            Descripcion del Asunto
	 * @param strDocto
	 *            Tipo de Documento
	 * @param strFinicio
	 *            Fecha inicial de Captura
	 * @param strFfin
	 *            Fecha final de Captura
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String buscarPorAsunto(String strFolio, String strArea,
			String strAsunto, String strDocto, String strFinicio, String strFfin) {
		String sql = "";
		if (strArea.equals("-1") && strAsunto == null && strDocto == null
				&& strFinicio == null && strFfin == null && strFolio != null) {
			strFolio = strFolio.toUpperCase();// Solo el Folio
			// //System.err.println("Solo folio");
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO "
					+ "WHERE ASU_FOLIO_RECEPCION LIKE '%"
					+ strFolio
					+ "%' "
					+ "ORDER BY 1";
		} else if (strArea.equals("-1") && strAsunto != null
				&& strDocto == null && strFinicio == null && strFfin == null
				&& strFolio == null) {
			strAsunto = strAsunto.toUpperCase();// Solo el nombre del asunto
			// //System.err.println("Solo asunto");
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO "
					+ "WHERE TRANSLATE(ASU_DESCRIPCION) LIKE '%"
					+ strAsunto
					+ "%' " + "ORDER BY 1";
		} else if (strArea.equals("-1") && strAsunto == null
				&& strDocto != null && strFinicio == null && strFfin == null
				&& strFolio == null) {
			strDocto = strDocto.toUpperCase();// Solo el tipo de docto
			// //System.err.println("Solo Docto");
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO, SD_TIPO_DOCUMENTO "
					+ "WHERE SD_ASUNTO.ASU_TIP_DOCTO=SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO "
					+ "AND TRANSLATE(TIP_DOCTO_NOMBRE) LIKE '%"
					+ strDocto
					+ "%' " + "ORDER BY 1";
		} else if (!strArea.equals("-1") && strAsunto == null
				&& strDocto == null && strFinicio == null && strFfin == null
				&& strFolio == null) {
			// Solo el area
			// //System.err.println("Solo Area");
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO, SD_USUARIO "
					+ "WHERE SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO "
					+ "AND USU_AREA=" + strArea + "  " + "ORDER BY 1";
		} else if (strArea.equals("-1") && strAsunto == null
				&& strDocto == null && strFinicio != null && strFfin != null
				&& strFolio == null) {
			// Solo las fechas
			// //System.err.println("Solo Fechas");
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO "
					+ "WHERE (ASU_FECHA_CAPTURA >= '"
					+ strFinicio
					+ "' AND ASU_FECHA_CAPTURA <= '"
					+ strFfin
					+ "') "
					+ "ORDER BY 1";
		} else if (strArea.equals("-1") && strAsunto != null
				&& strDocto == null && strFinicio == null && strFfin == null
				&& strFolio != null) {
			// Solo asunto y folio
			// //System.err.println("Solo asunto y folio");
			strAsunto = strAsunto.toUpperCase();
			strFolio = strFolio.toUpperCase();
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO "
					+ "WHERE TRANSLATE(ASU_FOLIO_RECEPCION) LIKE '%"
					+ strFolio
					+ "%' "
					+ "OR TRANSLATE(ASU_DESCRIPCION) LIKE '%"
					+ strAsunto + "%' " + "ORDER BY 1";
		} else if (!strArea.equals("-1") && strAsunto == null
				&& strDocto == null && strFinicio == null && strFfin == null
				&& strFolio != null) {
			// Solo area y folio
			// //System.err.println("Solo area y folio");
			strFolio = strFolio.toUpperCase();
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO, SD_USUARIO "
					+ "WHERE SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO "
					+ "AND (USU_AREA="
					+ strArea
					+ " "
					+ "OR  TRANSLATE(ASU_FOLIO_RECEPCION) LIKE '%"
					+ strFolio
					+ "%') " + "ORDER BY 1";
		} else if (strArea.equals("-1") && strAsunto == null
				&& strDocto != null && strFinicio == null && strFfin == null
				&& strFolio != null) {
			// Solo docto y folio
			// //System.err.println("Solo docto y folio");
			strFolio = strFolio.toUpperCase();
			strDocto = strDocto.toUpperCase();
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO, SD_TIPO_DOCUMENTO "
					+ "WHERE SD_ASUNTO.ASU_TIP_DOCTO=SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO "
					+ "AND (TRANSLATE(TIP_DOCTO_NOMBRE) LIKE '%"
					+ strDocto
					+ "%' "
					+ "OR  TRANSLATE(ASU_FOLIO_RECEPCION) LIKE '%"
					+ strFolio + "%') " + "ORDER BY 1";
		} else if (!strArea.equals("-1") && strAsunto != null
				&& strDocto == null && strFinicio == null && strFfin == null
				&& strFolio == null) {
			// Solo area y asunto
			// //System.err.println("Solo area y asunto");
			strAsunto = strAsunto.toUpperCase();
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO, SD_USUARIO "
					+ "WHERE SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO "
					+ "AND (USU_AREA="
					+ strArea
					+ " "
					+ "OR  TRANSLATE(ASU_DESCRIPCION) LIKE '%"
					+ strAsunto
					+ "%') " + "ORDER BY 1";
		} else if (!strArea.equals("-1") && strAsunto == null
				&& strDocto != null && strFinicio == null && strFfin == null
				&& strFolio == null) {
			// Solo area y docto
			// //System.err.println("Solo area y docto");
			strDocto = strDocto.toUpperCase();
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO, SD_USUARIO, SD_TIPO_DOCUMENTO "
					+ "WHERE SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO "
					+ "AND SD_ASUNTO.ASU_TIP_DOCTO=SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO "
					+ "AND (USU_AREA="
					+ strArea
					+ " "
					+ "OR  TRANSLATE(TIP_DOCTO_NOMBRE) LIKE '%"
					+ strDocto
					+ "%') " + "ORDER BY 1";
		} else if (strArea.equals("-1") && strAsunto != null
				&& strDocto != null && strFinicio == null && strFfin == null
				&& strFolio == null) {
			// Solo asunto y docto
			// //System.err.println("Solo asunto y docto");
			strDocto = strDocto.toUpperCase();
			strAsunto = strAsunto.toUpperCase();
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO, SD_TIPO_DOCUMENTO "
					+ "WHERE SD_ASUNTO.ASU_TIP_DOCTO=SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO "
					+ "AND (TRANSLATE(ASU_DESCRIPCION) LIKE '%"
					+ strAsunto
					+ "%' "
					+ "OR  TRANSLATE(TIP_DOCTO_NOMBRE) LIKE '%"
					+ strDocto + "%') " + "ORDER BY 1";
		} else if (strArea.equals("-1") && strAsunto == null
				&& strDocto == null && strFinicio != null && strFfin != null
				&& strFolio != null) {
			// Solo folio y fechas
			// //System.err.println("Solo folio y fechas");
			strFolio = strFolio.toUpperCase();
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO "
					+ "WHERE ((ASU_FECHA_CAPTURA >= '"
					+ strFinicio
					+ "' AND ASU_FECHA_CAPTURA <= '"
					+ strFfin
					+ "') "
					+ "OR  TRANSLATE(ASU_FOLIO_RECEPCION) LIKE '%"
					+ strFolio
					+ "%') " + "ORDER BY 1";
		} else if (!strArea.equals("-1") && strAsunto == null
				&& strDocto == null && strFinicio != null && strFfin != null
				&& strFolio == null) {
			// Solo area y fechas
			// //System.err.println("Solo area y fechas");
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO, SD_USUARIO "
					+ "WHERE SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO "
					+ "AND ((ASU_FECHA_CAPTURA >= '"
					+ strFinicio
					+ "' AND ASU_FECHA_CAPTURA <= '"
					+ strFfin
					+ "') "
					+ "OR  USU_AREA=" + strArea + ") " + "ORDER BY 1";
		} else if (strArea.equals("-1") && strAsunto != null
				&& strDocto == null && strFinicio != null && strFfin != null
				&& strFolio == null) {
			// Solo asunto y fechas
			strAsunto = strAsunto.toUpperCase();
			// //System.err.println("Solo asunto y fechas");
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO "
					+ "WHERE ((ASU_FECHA_CAPTURA >= '"
					+ strFinicio
					+ "' AND ASU_FECHA_CAPTURA <= '"
					+ strFfin
					+ "') "
					+ "OR  TRANSLATE(ASU_DESCRIPCION) LIKE '%"
					+ strAsunto
					+ "%') " + "ORDER BY 1";
		} else if (strArea.equals("-1") && strAsunto == null
				&& strDocto != null && strFinicio != null && strFfin != null
				&& strFolio == null) {
			// Solo docto y fechas
			strDocto = strDocto.toUpperCase();
			// //System.err.println("Solo docto y fechas");
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO, SD_TIPO_DOCUMENTO "
					+ "WHERE SD_ASUNTO.ASU_TIP_DOCTO=SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO "
					+ "AND ((ASU_FECHA_CAPTURA >= '"
					+ strFinicio
					+ "' AND ASU_FECHA_CAPTURA <= '"
					+ strFfin
					+ "') "
					+ "OR  TRANSLATE(TIP_DOCTO_NOMBRE) LIKE '%"
					+ strDocto
					+ "%') " + "ORDER BY 1";
		} else if (!strArea.equals("-1") && strAsunto != null
				&& strDocto != null && strFinicio != null && strFfin != null
				&& strFolio != null) {
			// todos
			strDocto = strDocto.toUpperCase();
			strAsunto = strAsunto.toUpperCase();
			strFolio = strFolio.toUpperCase();
			// //System.err.println("todos");
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO, SD_TIPO_DOCUMENTO, SD_USUARIO "
					+ "WHERE SD_ASUNTO.ASU_TIP_DOCTO=SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO "
					+ "AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO "
					+ "AND ((ASU_FECHA_CAPTURA >= '"
					+ strFinicio
					+ "' AND ASU_FECHA_CAPTURA <= '"
					+ strFfin
					+ "') "
					+ "OR TRANSLATE(TIP_DOCTO_NOMBRE) LIKE '%"
					+ strDocto
					+ "%' "
					+ "OR TRANSLATE(ASU_DESCRIPCION) LIKE '%"
					+ strAsunto
					+ "%' "
					+ "OR TRANSLATE(ASU_FOLIO_RECEPCION) LIKE '%"
					+ strFolio
					+ "%' " + "OR USU_AREA=" + strArea + ") " + "ORDER BY 1";
		} else if (!strArea.equals("-1") && strAsunto != null
				&& strDocto == null && strFinicio == null && strFfin == null
				&& strFolio != null) {
			// folio, area y asunto
			strAsunto = strAsunto.toUpperCase();
			strFolio = strFolio.toUpperCase();
			// //System.err.println("folio, area y asunto");
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO, SD_USUARIO "
					+ "WHERE SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO "
					+ "AND (TRANSLATE(ASU_DESCRIPCION) LIKE '%"
					+ strAsunto
					+ "%' "
					+ "OR TRANSLATE(ASU_FOLIO_RECEPCION) LIKE '%"
					+ strFolio
					+ "%' "
					+ "OR USU_AREA="
					+ strArea
					+ ") "
					+ "ORDER BY 1";
		} else if (!strArea.equals("-1") && strAsunto != null
				&& strDocto != null && strFinicio == null && strFfin == null
				&& strFolio == null) {
			// docto, area y asunto
			strAsunto = strAsunto.toUpperCase();
			strDocto = strDocto.toUpperCase();
			// //System.err.println("docto, area y asunto");
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO, SD_USUARIO, SD_TIPO_DOCUMENTO "
					+ "WHERE SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO "
					+ "AND SD_ASUNTO.ASU_TIP_DOCTO=SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO "
					+ "AND (TRANSLATE(ASU_DESCRIPCION) LIKE '%"
					+ strAsunto
					+ "%' "
					+ "OR TRANSLATE(TIP_DOCTO_NOMBRE) LIKE '%"
					+ strDocto
					+ "%' "
					+ "OR USU_AREA="
					+ strArea
					+ ") "
					+ "ORDER BY 1";
		} else if (!strArea.equals("-1") && strAsunto == null
				&& strDocto != null && strFinicio == null && strFfin == null
				&& strFolio != null) {
			// docto, area y folio
			strFolio = strFolio.toUpperCase();
			strDocto = strDocto.toUpperCase();
			// //System.err.println("docto, area y folio");
			sql = "SELECT ASU_FOLIO_RECEPCION, ASU_REMITENTE, ASU_DESCRIPCION, "
					+ "ASU_FECHA_CAPTURA, ID_ASUNTO, ASU_CONTROL, ASU_USR_TURNA FROM SD_ASUNTO, SD_USUARIO, SD_TIPO_DOCUMENTO "
					+ "WHERE SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO "
					+ "AND SD_ASUNTO.ASU_TIP_DOCTO=SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO "
					+ "AND (TRANSLATE(ASU_FOLIO_RECEPCION) LIKE '%"
					+ strFolio
					+ "%' "
					+ "OR TRANSLATE(TIP_DOCTO_NOMBRE) LIKE '%"
					+ strDocto
					+ "%' "
					+ "OR USU_AREA="
					+ strArea
					+ ") "
					+ "ORDER BY 1";
		}
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos que tengan como ID a
	 * campo y Estatus en Tramite o Terminado
	 * 
	 * @param strINameAsunto
	 *            ID del Asunto
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAsuntosAnidados(String strINameAsunto) {

		strINameAsunto = strINameAsunto.toUpperCase();

		String sql = "SELECT A1.ID_ASUNTO, A1.ASU_FOLIO_RECEPCION, A1.ASU_FOLIO_EXTERNO, "
				+ "A1.ASU_ESTATUS "
				+
				// "CASE A1.ASU_ESTATUS " +
				// " WHEN 2 THEN 'Tr·mite' " +
				// " WHEN 3 THEN 'Terminado' " +
				// "END AS ESTATUS "+
				"FROM SD_ASUNTO A1, SD_USUARIO A2 "
				+ "WHERE A1.ASU_USR_TURNA =A2.ID_USUARIO AND "
				+ "A1.ID_ASUNTO = " + strINameAsunto;
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos que tengan como ID a
	 * campo
	 * 
	 * @param strINameAsunto
	 *            ID del Asunto
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAsuntosAnidadosLigado(String strINameAsunto) {

		strINameAsunto = strINameAsunto.toUpperCase();

		String sql = "SELECT A1.ID_ASUNTO, A1.ASU_FOLIO_RECEPCION, A1.ASU_FOLIO_EXTERNO, "
				+
				// "A1.ASU_ESTATUS " +
				"CASE A1.ASU_ESTATUS "
				+ "	WHEN 2 THEN 'Tr·mite' "
				+ "	WHEN 3 THEN 'Terminado' "
				+ "	WHEN 1 THEN 'Por Turnar' "
				+ "	WHEN 0 THEN 'RecepciÛn' "
				+ "END AS ESTATUS "
				+ "FROM SD_ASUNTO A1, SD_USUARIO A2 "
				+ "WHERE A1.ASU_USR_TURNA =A2.ID_USUARIO "
				+ "AND A1.ID_ASUNTO = " + strINameAsunto;
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos referenciados por Folio
	 * de recepcion
	 * 
	 * @param strINameAsunto
	 *            Folio del RecepciÛn
	 * @param stridArea
	 *            Unidad Administrativa
	 * @param strIdAsunto
	 *            Id del Asunto Actual
	 * @param idBusqueda
	 *            Lista de Id de Asuntos que no se deben de incluir en la
	 *            busqueda
	 * @param strIdUsuario
	 *            Usuario que realiza la busqueda
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAsuntosAnt(String strINameAsunto, String stridArea,
			String strIdAsunto, String idBusqueda, String strIdUsuario) {

		strINameAsunto = strINameAsunto.toUpperCase();

		String sql = "SELECT A1.ID_ASUNTO, A1.ASU_FOLIO_RECEPCION, A1.ASU_DESCRIPCION, "
				+ "A1.ASU_FOLIO_EXTERNO, A1.ASU_ESTATUS "
				+ "FROM SD_ASUNTO A1, SD_USUARIO A2 "
				+ "WHERE A1.ASU_USR_TURNA =A2.ID_USUARIO AND A1.ASU_ESTATUS <> 0 AND A2.USU_AREA="
				+ stridArea
				+ " AND A1.ID_ASUNTO <> "
				+ strIdAsunto
				+ " AND "
				+ "( ";
		StringTokenizer strToken = new StringTokenizer(strINameAsunto, ",");
		while (strToken.hasMoreTokens()) {
			String aux = strToken.nextToken().trim();
			if (aux.charAt(0) == '\"' && aux.charAt(aux.length() - 1) == '\"') {
				aux = "%" + aux.substring(1, aux.length() - 1) + "%";
			} else {
				aux = "%" + aux + "%";
			}
			sql += "UPPER(TRANSLATE(A1.ASU_FOLIO_RECEPCION,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE UPPER(TRANSLATE('"
					+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
			if (strToken.countTokens() != 0) {
				sql += "AND ";
			}
		}
		sql += ") AND NOT(A1.ID_ASUNTO IN (" + idBusqueda + "))";

		sql += " AND A1.ID_ASUNTO IN ( SELECT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO, SD_USUARIO_ROL "
				+ " WHERE SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA "
				+ " AND SD_USUARIO.ID_USUARIO = SD_USUARIO_ROL.ID_USUARIO1 "
				+ " AND (ASU_REMITENTE="
				+ strIdUsuario
				+ " OR ASU_USUARIO_CAPTURA= "
				+ strIdUsuario
				+ " OR ASU_USR_TURNA= "
				+ strIdUsuario
				+ " OR (USU_AREA="
				+ stridArea
				+ " AND ID_ROL=1) "
				+ " OR (USU_AREA="
				+ stridArea
				+ " AND ID_ROL=5) "
				+ " OR (USU_AREA="
				+ stridArea
				+ " AND ID_ROL=4) ) UNION "
				+ " SELECT ID_ASUNTO FROM SD_INSTRUCCION_ASUNTO "
				+ " WHERE INS_USUARIO = "
				+ strIdUsuario
				+ " AND INS_ACCESO = 1) ";
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar las Instrucciones-Asuntos
	 * referenciados por Folio de recepcion
	 * 
	 * @param strINameAsunto
	 *            Folio del RecepciÛn
	 * @param stridArea
	 *            Unidad Administrativa
	 * @param idBusqueda
	 *            Lista de Id de Asuntos que no se deben de incluir en la
	 *            busqueda
	 * @param strIdUsuario
	 *            Usuario que realiza la busqueda
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAsuntosAntIns(String strINameAsunto,
			String strIdArea, String idBusqueda, String strIdUsuario) {

		strINameAsunto = strINameAsunto.toUpperCase();

		String sql = "SELECT A1.ID_ASUNTO, A1.ASU_FOLIO_RECEPCION, A1.ASU_DESCRIPCION, "
				+ "A1.ASU_FOLIO_EXTERNO, A1.ASU_ESTATUS  "
				+ "FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, SD_ASUNTO A1 "
				+ "WHERE A1.ASU_ESTATUS <> 0 AND USU_AREA="
				+ strIdArea
				+ "  "
				+ "AND A1.ID_ASUNTO NOT IN(" + idBusqueda + ") " + "AND (";
		StringTokenizer strToken = new StringTokenizer(strINameAsunto, ",");
		while (strToken.hasMoreTokens()) {
			String aux = strToken.nextToken().trim();
			if (aux.charAt(0) == '\"' && aux.charAt(aux.length() - 1) == '\"') {
				aux = "%" + aux.substring(1, aux.length() - 1) + "%";
			} else {
				aux = "%" + aux + "%";
			}
			sql += "UPPER(TRANSLATE(A1.ASU_FOLIO_RECEPCION,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE UPPER(TRANSLATE('"
					+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
			if (strToken.countTokens() != 0) {
				sql += "AND ";
			}
		}
		sql += ") "
				+ "AND A1.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO "
				+ "AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
				+ "AND INS_ESTATUS=2 " + "AND INS_BANDERA1=1 ";

		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos referenciados por
	 * DescripciÛn del Asunto
	 * 
	 * @param strINameAsunto
	 *            DescripciÛn del Asunto
	 * @param stridArea
	 *            Unidad Administrativa
	 * @param strIdAsunto
	 *            Id del Asunto Actual
	 * @param idBusqueda
	 *            Lista de Id de Asuntos que no se deben de incluir en la
	 *            busqueda
	 * @param strIdUsuario
	 *            Usuario que realiza la busqueda
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAsuntosAntD(String strINameAsunto,
			String stridArea, String strIdAsunto, String idBusqueda,
			String strIdUsuario) {

		strINameAsunto = strINameAsunto.toUpperCase();

		String sql = "SELECT A1.ID_ASUNTO, A1.ASU_FOLIO_RECEPCION, A1.ASU_DESCRIPCION, "
				+ "A1.ASU_FOLIO_EXTERNO, A1.ASU_ESTATUS "
				+ "FROM SD_ASUNTO A1, SD_USUARIO A2 "
				+ "WHERE A1.ASU_USR_TURNA =A2.ID_USUARIO AND A1.ASU_ESTATUS <> 0 AND A2.USU_AREA="
				+ stridArea + " AND A1.ID_ASUNTO NOT IN(" + strIdAsunto + ") AND ( ";
		StringTokenizer strToken = new StringTokenizer(strINameAsunto, ",");
		while (strToken.hasMoreTokens()) {
			String aux = strToken.nextToken().trim();
			if (aux.charAt(0) == '\"' && aux.charAt(aux.length() - 1) == '\"') {
				aux = "%" + aux.substring(1, aux.length() - 1) + "%";
			} else {
				aux = "%" + aux + "%";
			}
			sql += "UPPER(TRANSLATE(A1.ASU_DESCRIPCION,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE UPPER(TRANSLATE('"
					+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
			if (strToken.countTokens() != 0) {
				sql += "AND ";
			}
		}
		sql += ") AND NOT(A1.ID_ASUNTO IN (" + idBusqueda + "))";

		sql += " AND A1.ID_ASUNTO IN ( SELECT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO, SD_USUARIO_ROL "
				+ " WHERE SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA "
				+ " AND SD_USUARIO.ID_USUARIO = SD_USUARIO_ROL.ID_USUARIO1 "
				+ " AND (ASU_REMITENTE="
				+ strIdUsuario
				+ " OR ASU_USUARIO_CAPTURA= "
				+ strIdUsuario
				+ " OR ASU_USR_TURNA= "
				+ strIdUsuario
				+ " OR (USU_AREA="
				+ stridArea
				+ " AND ID_ROL=1) "
				+ " OR (USU_AREA="
				+ stridArea
				+ " AND ID_ROL=5) "
				+ " OR (USU_AREA="
				+ stridArea
				+ " AND ID_ROL=4) ) UNION "
				+ " SELECT ID_ASUNTO FROM SD_INSTRUCCION_ASUNTO "
				+ " WHERE INS_USUARIO = "
				+ strIdUsuario
				+ " AND INS_ACCESO = 1) ";

		return sql;
	}

	/**
	 * Construye un SQL Query para regresar las Instrucciones-Asuntos
	 * referenciados por DescripciÛn del Asunto
	 * 
	 * @param strINameAsunto
	 *            DescripciÛn del Asunto
	 * @param stridArea
	 *            Unidad Administrativa
	 * @param idBusqueda
	 *            Lista de Id de Asuntos que no se deben de incluir en la
	 *            busqueda
	 * @param strIdUsuario
	 *            Usuario que realiza la busqueda
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAsuntosAntDIns(String strINameAsunto,
			String strIdArea, String idBusqueda, String strIdUsuario) {

		strINameAsunto = strINameAsunto.toUpperCase();

		String sql = "SELECT A1.ID_ASUNTO, A1.ASU_FOLIO_RECEPCION, A1.ASU_DESCRIPCION, "
				+ "A1.ASU_FOLIO_EXTERNO, A1.ASU_ESTATUS  "
				+ "FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, SD_ASUNTO A1 "
				+ "WHERE A1.ASU_ESTATUS <> 0 AND USU_AREA="
				+ strIdArea
				+ "  "
				+ "AND A1.ID_ASUNTO NOT IN( " + idBusqueda + ") " + "AND (";
		StringTokenizer strToken = new StringTokenizer(strINameAsunto, ",");
		while (strToken.hasMoreTokens()) {
			String aux = strToken.nextToken().trim();
			if (aux.charAt(0) == '\"' && aux.charAt(aux.length() - 1) == '\"') {
				aux = "%" + aux.substring(1, aux.length() - 1) + "%";
			} else {
				aux = "%" + aux + "%";
			}
			sql += "UPPER(TRANSLATE(A1.ASU_DESCRIPCION,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE UPPER(TRANSLATE('"
					+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
			if (strToken.countTokens() != 0) {
				sql += "AND ";
			}
		}
		sql += ") "
				+ "AND A1.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO "
				+ "AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
				+ "AND INS_ESTATUS=2 " + "AND INS_BANDERA1=1 ";

		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos referenciados por
	 * Identificacior del Documento
	 * 
	 * @param strINameAsunto
	 *            DescripciÛn del Asunto
	 * @param stridArea
	 *            Unidad Administrativa
	 * @param strIdAsunto
	 *            Id del Asunto Actual
	 * @param idBusqueda
	 *            Lista de Id de Asuntos que no se deben de incluir en la
	 *            busqueda
	 * @param strIdUsuario
	 *            Usuario que realiza la busqueda
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getBusquedaAsuntAntIdDoc(String strINameAsunto,
			String stridArea, String strIdAsunto, String idBusqueda,
			String strIdUsuario) {

		strINameAsunto = strINameAsunto.toUpperCase();

		String sql = "SELECT A1.ID_ASUNTO, A1.ASU_FOLIO_RECEPCION, A1.ASU_DESCRIPCION, "
				+ "A1.ASU_FOLIO_EXTERNO, A1.ASU_ESTATUS  "
				+ "FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, SD_ASUNTO A1 "
				+ "WHERE A1.ASU_ESTATUS <> 0 AND USU_AREA="
				+ stridArea
				+ "  "
				+ "AND A1.ID_ASUNTO NOT IN(" + idBusqueda + ") " + "AND (";
		StringTokenizer strToken = new StringTokenizer(strINameAsunto, ",");
		while (strToken.hasMoreTokens()) {
			String aux = strToken.nextToken().trim();
			if (aux.charAt(0) == '\"' && aux.charAt(aux.length() - 1) == '\"') {
				aux = "%" + aux.substring(1, aux.length() - 1) + "%";
			} else {
				aux = "%" + aux + "%";
			}
			sql += "UPPER(TRANSLATE(A1.ASU_FOLIO_EXTERNO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE UPPER(TRANSLATE('"
					+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
			if (strToken.countTokens() != 0) {
				sql += "AND ";
			}
		}
		sql += ") "
				+ "AND A1.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO "
				+ "AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
				+ "AND INS_ESTATUS=2 " + "AND INS_BANDERA1=1 ";

		
		return sql;
	}

	/**
	 * Construye un SQL Query para regresar las Instrucciones-Asuntos
	 * referenciados por Identificacior del Documento
	 * 
	 * @param strINameAsunto
	 *            DescripciÛn del Asunto
	 * @param stridArea
	 *            Unidad Administrativa
	 * @param idBusqueda
	 *            Lista de Id de Asuntos que no se deben de incluir en la
	 *            busqueda
	 * @param strIdUsuario
	 *            Usuario que realiza la busqueda
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAsuntosAntIdDocIns(String strINameAsunto,
			String strIdArea, String idBusqueda, String strIdUsuario) {
		strINameAsunto = strINameAsunto.toUpperCase();
		String sql = "SELECT A1.ID_ASUNTO, A1.ASU_FOLIO_RECEPCION, A1.ASU_DESCRIPCION, "
				+ "A1.ASU_FOLIO_EXTERNO, A1.ASU_ESTATUS FROM SD_ASUNTO A1, SD_INSTRUCCION_ASUNTO A2, SD_USUARIO A3 "
				+ "WHERE A1.ID_ASUNTO=A2.ID_ASUNTO AND A1.ASU_ESTATUS <> 0 AND A3.ID_USUARIO=A2.INS_USUARIO "
				+ "AND USU_AREA=" + strIdArea + " AND ( ";
		StringTokenizer strToken = new StringTokenizer(strINameAsunto, ",");
		while (strToken.hasMoreTokens()) {
			String aux = strToken.nextToken().trim();
			if (aux.charAt(0) == '\"' && aux.charAt(aux.length() - 1) == '\"') {
				aux = "%" + aux.substring(1, aux.length() - 1) + "%";
			} else {
				aux = "%" + aux + "%";
			}
			sql += "UPPER(TRANSLATE(A1.ASU_FOLIO_EXTERNO,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE UPPER(TRANSLATE('"
					+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
			if (strToken.countTokens() != 0) {
				sql += "AND ";
			}
		}
		sql += ") AND NOT(A1.ID_ASUNTO IN (" + idBusqueda
				+ ")) AND A2.INS_BANDERA1 = 1";

		sql += " AND A1.ID_ASUNTO IN ( SELECT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO, SD_USUARIO_ROL "
				+ " WHERE SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA "
				+ " AND SD_USUARIO.ID_USUARIO = SD_USUARIO_ROL.ID_USUARIO1 "
				+ " AND (ASU_REMITENTE="
				+ strIdUsuario
				+ " OR ASU_USUARIO_CAPTURA= "
				+ strIdUsuario
				+ " OR ASU_USR_TURNA= "
				+ strIdUsuario
				+ " OR (USU_AREA="
				+ strIdArea
				+ " AND ID_ROL=1) "
				+ " OR (USU_AREA="
				+ strIdArea
				+ " AND ID_ROL=5) "
				+ " OR (USU_AREA="
				+ strIdArea
				+ " AND ID_ROL=4) ) UNION "
				+ " SELECT ID_ASUNTO FROM SD_INSTRUCCION_ASUNTO "
				+ " WHERE INS_USUARIO = "
				+ strIdUsuario
				+ " AND INS_ACCESO = 1) ";

		return sql;
	}

	/**
	 * Construye un SQL Query para regresar los Asuntos referenciados por
	 * Palabra Clave
	 * 
	 * @param strINameAsunto
	 *            DescripciÛn del Asunto
	 * @param stridArea
	 *            Unidad Administrativa
	 * @param strIdAsunto
	 *            Id del Asunto Actual
	 * @param idBusqueda
	 *            Lista de Id de Asuntos que no se deben de incluir en la
	 *            busqueda
	 * @param strIdUsuario
	 *            Usuario que realiza la busqueda
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAsuntosAntPalabraClave(String strINameAsunto,
			String stridArea, String strIdAsunto, String idBusqueda,
			String strIdUsuario) {

		strINameAsunto = strINameAsunto.toUpperCase();

		String sql = "SELECT A1.ID_ASUNTO, A1.ASU_FOLIO_RECEPCION, A1.ASU_DESCRIPCION, "
				+ "A1.ASU_FOLIO_EXTERNO, A1.ASU_ESTATUS "
				+ "FROM SD_ASUNTO A1, SD_USUARIO A2 "
				+ "WHERE A1.ASU_USR_TURNA = A2.ID_USUARIO AND A1.ASU_ESTATUS <> 0 AND A2.USU_AREA="
				+ stridArea
				+ " AND A1.ID_ASUNTO <> "
				+ strIdAsunto
				+ " AND "
				+ "( ";
		StringTokenizer strToken = new StringTokenizer(strINameAsunto, ",");
		while (strToken.hasMoreTokens()) {
			String aux = strToken.nextToken().trim();
			if (aux.charAt(0) == '\"' && aux.charAt(aux.length() - 1) == '\"') {
				aux = "%" + aux.substring(1, aux.length() - 1) + "%";
			} else {
				aux = "%" + aux + "%";
			}
			sql += "UPPER(TRANSLATE(A1.ASU_PALABRA_CLAVE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE UPPER(TRANSLATE('"
					+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
			if (strToken.countTokens() != 0) {
				sql += "AND ";
			}
		}
		sql += ") AND NOT(A1.ID_ASUNTO IN (" + idBusqueda + "))";

		sql += " AND A1.ID_ASUNTO IN ( SELECT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO, SD_USUARIO_ROL "
				+ " WHERE SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA "
				+ " AND SD_USUARIO.ID_USUARIO = SD_USUARIO_ROL.ID_USUARIO1 "
				+ " AND (ASU_REMITENTE="
				+ strIdUsuario
				+ " OR ASU_USUARIO_CAPTURA= "
				+ strIdUsuario
				+ " OR ASU_USR_TURNA= "
				+ strIdUsuario
				+ " OR (USU_AREA="
				+ stridArea
				+ " AND ID_ROL=1) "
				+ " OR (USU_AREA="
				+ stridArea
				+ " AND ID_ROL=5) "
				+ " OR (USU_AREA="
				+ stridArea
				+ " AND ID_ROL=4) ) UNION "
				+ " SELECT ID_ASUNTO FROM SD_INSTRUCCION_ASUNTO "
				+ " WHERE INS_USUARIO = "
				+ strIdUsuario
				+ " AND INS_ACCESO = 1) ";

		return sql;
	}

	/**
	 * Construye un SQL Query para regresar las Instrucciones-Asuntos
	 * referenciados por Palabra Clave
	 * 
	 * @param strINameAsunto
	 *            DescripciÛn del Asunto
	 * @param stridArea
	 *            Unidad Administrativa
	 * @param idBusqueda
	 *            Lista de Id de Asuntos que no se deben de incluir en la
	 *            busqueda
	 * @param strIdUsuario
	 *            Usuario que realiza la busqueda
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAsuntosAntPalabraClaveIns(String strINameAsunto,
			String strIdArea, String idBusqueda, String strIdUsuario) {

		strINameAsunto = strINameAsunto.toUpperCase();

		String sql = "SELECT A1.ID_ASUNTO, A1.ASU_FOLIO_RECEPCION, A1.ASU_DESCRIPCION, "
				+ "A1.ASU_FOLIO_EXTERNO, A1.ASU_ESTATUS  "
				+ "FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, SD_ASUNTO A1 "
				+ "WHERE  A1.ASU_ESTATUS <> 0 AND USU_AREA="
				+ strIdArea
				+ "  "
				+ "AND A1.ID_ASUNTO NOT IN(" + idBusqueda + ") " + "AND (";
		StringTokenizer strToken = new StringTokenizer(strINameAsunto, ",");
		while (strToken.hasMoreTokens()) {
			String aux = strToken.nextToken().trim();
			if (aux.charAt(0) == '\"' && aux.charAt(aux.length() - 1) == '\"') {
				aux = "%" + aux.substring(1, aux.length() - 1) + "%";
			} else {
				aux = "%" + aux + "%";
			}
			sql += "UPPER(TRANSLATE(A1.ASU_PALABRA_CLAVE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) LIKE UPPER(TRANSLATE('"
					+ aux + "','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
			if (strToken.countTokens() != 0) {
				sql += "AND ";
			}
		}
		sql += ") "
				+ "AND A1.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO "
				+ "AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
				+ "AND INS_ESTATUS=2 " + "AND INS_BANDERA1=1 ";

		// String sql = "SELECT A1.ID_ASUNTO, A1.ASU_FOLIO_RECEPCION,
		// A1.ASU_DESCRIPCION, " +
		// "A1.ASU_FOLIO_EXTERNO, A1.ASU_ESTATUS FROM SD_ASUNTO A1,
		// SD_INSTRUCCION_ASUNTO A2, SD_USUARIO A3 " +
		// "WHERE A1.ID_ASUNTO=A2.ID_ASUNTO AND A3.ID_USUARIO=A2.INS_USUARIO " +
		// "AND USU_AREA="+strIdArea+" AND ( ";
		// StringTokenizer strToken = new StringTokenizer(strINameAsunto,",");
		// while (strToken.hasMoreTokens()){
		// String aux = strToken.nextToken().trim();
		// if (aux.charAt(0)=='\"' && aux.charAt(aux.length()-1)=='\"'){
		// aux = "%"+aux.substring(1,aux.length()-1)+"%";
		// }else{
		// aux = "%"+aux+"%";
		// }
		// sql +=
		// "UPPER(TRANSLATE(A1.ASU_PALABRA_CLAVE,'·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU'))
		// LIKE UPPER(TRANSLATE('"+aux+"','·ÈÌÛ˙¡…Õ”⁄','aeiouAEIOU')) ";
		// if(strToken.countTokens()!=0){
		// sql += "AND ";
		// }
		// }
		// sql += ") AND NOT(A1.ID_ASUNTO IN ("+idBusqueda+")) AND
		// A2.INS_BANDERA1 = 1";
		//	
		// sql += " AND A1.ID_ASUNTO IN ( SELECT ID_ASUNTO FROM SD_ASUNTO,
		// SD_USUARIO, SD_USUARIO_ROL " +
		// " WHERE SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA " +
		// " AND SD_USUARIO.ID_USUARIO = SD_USUARIO_ROL.ID_USUARIO1 " +
		// " AND (ASU_REMITENTE=" + strIdUsuario +
		// " OR ASU_USUARIO_CAPTURA= " + strIdUsuario +
		// " OR ASU_USR_TURNA= " + strIdUsuario +
		// " OR (USU_AREA=" + strIdArea +" AND ID_ROL=5) " +
		// " OR (USU_AREA=" + strIdArea +" AND ID_ROL=4) ) UNION " +
		// " SELECT ID_ASUNTO FROM SD_INSTRUCCION_ASUNTO " +
		// " WHERE INS_USUARIO = "+strIdUsuario+" AND INS_ACCESO = 1) ";

		return sql;
	}

	public static String getAsuntosUsuario(String strUsuario, String strArea) {

		String sql = " SELECT A.NOMBRE_ARCHIVO, A.ID_ASUNTO_CONTENT, B.ASU_FOLIO_RECEPCION "
				+ " FROM  SD_CONTENT_ORACLE A, SD_ASUNTO B "
				+ " WHERE ID_ASUNTO IN ( ";

		sql += " SELECT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO, SD_USUARIO_ROL "
				+ " WHERE SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA "
				+ " AND SD_USUARIO.ID_USUARIO = SD_USUARIO_ROL.ID_USUARIO1 "
				+ " AND (ASU_REMITENTE=" + strUsuario
				+ " OR ASU_USUARIO_CAPTURA= " + strUsuario
				+ " OR ASU_USR_TURNA= " + strUsuario + " OR (USU_AREA="
				+ strArea + " AND ID_ROL=1) " + " OR (USU_AREA=" + strArea
				+ " AND ID_ROL=5) " + " OR (USU_AREA=" + strArea
				+ " AND ID_ROL=4) ) UNION "
				+ " SELECT ID_ASUNTO FROM SD_INSTRUCCION_ASUNTO "
				+ " WHERE INS_USUARIO = " + strArea + " AND INS_ACCESO = 1) "
				+ " AND A.ID_ASUNTO_CONTENT = B.ID_ASUNTO";

		return sql;

	}

	public static String getIdAsunto(String strNombreArchivo) {

		String sql = " SELECT ID_ASUNTO_CONTENT " + " FROM SD_CONTENT_ORACLE "
				+ " WHERE NOMBRE_ARCHIVO = '" + strNombreArchivo + "'";

		return sql;
	}

	/**
	 * Construye un SQL Query para regresar el Folio del Asunto por ID del
	 * Asunto
	 * 
	 * @param strIdAsunto
	 *            ID del Asunto
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAsuntoId(String strIdAsunto) {

		String sql = " SELECT asu_folio_recepcion " + " FROM sd_asunto "
				+ " WHERE id_asunto = " + strIdAsunto;

		return sql;
	}

	/**
	 * Regresa el query los datos de un Asunto segun su ID para la busqueda
	 * 
	 * @param strIdAsutno
	 *            ID asunto
	 * @return string del query
	 */
	public static String getAsuntoBuscar(String strIdAsutno) {

		String sql = " SELECT DISTINCT "
				+ "CASE ASU_ESTATUS"
				+ "	WHEN 0 THEN 'Sin Folio de Control' "
				+ "	WHEN 1 THEN 'Sin Folio de Control' "
				+ "	WHEN 2 THEN ASU_FOLIO_ENTRADA "
				+ "	WHEN 3 THEN ASU_FOLIO_ENTRADA "
				+ "END AS FOLIO_CONTROL, "
				+ "ASU_FOLIO_RECEPCION, ASU_FOLIO_EXTERNO, "
				+ "ASU_DESCRIPCION, "
				+ "CASE ASU_CONTROL "
				+ "	WHEN 0 THEN ( "
				+ "		CASE ASU_ESTATUS "
				+ "			WHEN 0 THEN (SELECT RMT_NOMBRE FROM SD_REMITENTE WHERE ID_REMITENTE=ASU_REMITENTE) "
				+ "			WHEN 1 THEN (SELECT RMT_NOMBRE FROM SD_REMITENTE WHERE ID_REMITENTE=ASU_REMITENTE) "
				+ "			WHEN 2 THEN (SELECT ASU_REF_REMITENTE_NOMBRE FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF=ID_ASUNTO) "
				+ "			WHEN 3 THEN (SELECT ASU_REF_REMITENTE_NOMBRE FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF=ID_ASUNTO) "
				+ "		END ) "
				+ "	WHEN 1 THEN ( "
				+ "		CASE ASU_ESTATUS "
				+ "			WHEN 0 THEN (SELECT USU_CARGO FROM SD_USUARIO WHERE ID_USUARIO=ASU_REMITENTE) "
				+ "			WHEN 1 THEN (SELECT USU_CARGO FROM SD_USUARIO WHERE ID_USUARIO=ASU_REMITENTE) "
				+ "			WHEN 2 THEN (SELECT ASU_REF_REMITENTE_NOMBRE FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF=ID_ASUNTO) "
				+ "			WHEN 3 THEN (SELECT ASU_REF_REMITENTE_NOMBRE FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF=ID_ASUNTO) "
				+ "		END ) "
				+ "END AS REMITENTE,  "
				+ "CASE ASU_CONTROL "
				+ "	WHEN 0 THEN ( "
				+ "		CASE ASU_ESTATUS "
				+ "			WHEN 0 THEN (SELECT ENT_NOMBRE FROM SD_REMITENTE, SD_ENTIDAD WHERE ID_REMITENTE = ASU_REMITENTE AND ID_ENTIDAD = RMT_ENTIDAD) "
				+ "			WHEN 1 THEN (SELECT ENT_NOMBRE FROM SD_REMITENTE, SD_ENTIDAD WHERE ID_REMITENTE = ASU_REMITENTE AND ID_ENTIDAD = RMT_ENTIDAD) "
				+ "			WHEN 2 THEN (SELECT ASU_REF_ENTIDAD FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF=ID_ASUNTO) "
				+ "			WHEN 3 THEN (SELECT ASU_REF_ENTIDAD FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF=ID_ASUNTO) "
				+ "		END ) "
				+ "	WHEN 1 THEN ( "
				+ "		CASE ASU_ESTATUS "
				+ "			WHEN 0 THEN (SELECT ARE_NOMBRE FROM SD_USUARIO, SD_AREA WHERE ID_USUARIO = ASU_REMITENTE AND ID_AREA = USU_AREA) "
				+ "			WHEN 1 THEN (SELECT ARE_NOMBRE FROM SD_USUARIO, SD_AREA WHERE ID_USUARIO = ASU_REMITENTE AND ID_AREA = USU_AREA) "
				+ "			WHEN 2 THEN (SELECT ASU_REF_ENTIDAD FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF=ID_ASUNTO) "
				+ "			WHEN 3 THEN (SELECT ASU_REF_ENTIDAD FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF=ID_ASUNTO) "
				+ "		END ) "
				+ "END AS UA_REMITENTE, "
				+ "CASE ASU_CONTROL_FOLIO "
				+ "	WHEN 0 THEN 'Entrada' "
				+ "	WHEN 1 THEN 'Salida' "
				+ "END AS TIPO_ES, "
				+ "ASU_AVANCE||'%' AS AVANCE, "
				+ "TO_CHAR(ASU_FECHA_CAPTURA,'DD/MM/YYYY HH24:MI:SS') AS FECHA_CAPTURA, "
				+ "TO_CHAR(ASU_FECHA_RECEPCION,'DD/MM/YYYY HH24:MI:SS') AS FECHA_RECEPCION, "
				+ "TO_CHAR(ASU_FECHA_DOCTO,'DD/MM/YYYY') AS FECHA_DOCTO, "
				+ "TO_CHAR(ASU_FECHA_CADUCIDAD,'DD/MM/YYYY HH24:MI:SS') AS FECHA_COMPROMISO, "
				+ "CASE ASU_ESTATUS "
				+ "   	WHEN 0 THEN 'No ha sido Terminado' "
				+ "   	WHEN 1 THEN 'No ha sido Terminado' "
				+ "   	WHEN 2 THEN 'No ha sido Terminado' "
				+ "   	WHEN 3 THEN TO_CHAR(ASU_FECHA_TERMINACION,'DD/MM/YYYY HH24:MI:SS') "
				+ "END AS FECHA_TERMINACION, " + "CASE ASU_ESTATUS "
				+ " 	WHEN 0 THEN 'En RecepciÛn' "
				+ "	WHEN 1 THEN 'Por Turnar' " + "	WHEN 2 THEN 'En Tramite' "
				+ "	WHEN 3 THEN 'Terminada' " + "END AS ESTATUS, "
				+ "ASU_LISTAIDS_PARA, " + "ASU_LISTAIDS_CC, "
				+ "ASU_ESTATUS, ID_ASUNTO, " + // 18

				"ASU_FIRMANTE, ASU_TIP_DOCTO, " + // 20
				"ASU_TRAMITE, ASU_FOLIO_INTERMEDIO, " + // 22
				"ASU_SINTESIS, ASU_EXPEDIENTE_OTRO, " + // 24
				"TO_CHAR(ASU_FECHA_EVENTO,'DD/MM/YYYY') AS FECHA_EVENTO, " + // 25
				"ASU_HORA_EVENTO, ASU_MIN_EVENTO, " + // 27
				"ASU_LUGAR_EVENTO, ASU_PRIORIDAD, " + // 29
				"ASU_TIPO_ASUNTO " + // 30
				"FROM SD_ASUNTO " + "WHERE ID_ASUNTO = " + strIdAsutno;

		return sql;
	}

	/**
	 * Regresa el query los datos de una Instruccion segun su ID para la
	 * busqueda
	 * 
	 * @param strIdAsutno
	 *            ID Instruccion
	 * @return string del query
	 */
	public static String getInstruccionBuscar(String strIdInstruccion) {

		String sql = "SELECT "
				+ "(SELECT USU_CARGO||'/'||USU_NOMBRE "
				+ "FROM SD_USUARIO WHERE ID_USUARIO = INS_USUARIO) "
				+ "AS REMITENTE, "
				+ "ASU_DESCRIPCION, "
				+ "(SELECT INS_NOMBRE FROM SD_INSTRUCCION "
				+ "WHERE ID_INSTRUCCION = INS_INSTRUCCION) "
				+ "AS INSTRUCCION, "
				+ "INS_INSTRUCCION_OTRO, "
				+ "CASE INS_TIPO_ATENCION "
				+ "	WHEN 0 THEN 'Ejecutora' "
				+ "	WHEN 1 THEN 'Informativa' "
				+ "END AS TIPO_ATENCION, "
				+ "TO_CHAR(INS_FECHA_ASIGNACION,'DD/MM/YYYY'), "
				+ "TO_CHAR(INS_FECHA_TERMINACION,'DD/MM/YYYY'), "
				+ "CASE INS_ESTATUS "
				+ " 	WHEN 1 THEN 'Por Atender' "
				+ "	WHEN 2 THEN 'En Tramite' "
				+ "	WHEN 3 THEN 'Rechazada' "
				+ "	WHEN 4 THEN 'Terminada' "
				+ "END AS ESTATUS, "
				+ "INS_AVANCE||'%', "
				+ "(SELECT USU_CARGO||'/'||USU_NOMBRE "
				+ "FROM SD_USUARIO WHERE ID_USUARIO = ASU_USR_TURNA) "
				+ "AS ASIGNDA, "
				+ "INS_FOLIO_TURNADO, "
				+ "ASU_FOLIO_INTERMEDIO, "
				+ "ASU_FOLIO_ENTRADA, "
				+ "INS_EXPEDIENTE_NOMBRE  "
				+ "FROM SD_INSTRUCCION_ASUNTO, SD_ASUNTO "
				+ "WHERE SD_ASUNTO.ID_ASUNTO = SD_INSTRUCCION_ASUNTO.ID_ASUNTO "
				+ "AND ID_INSTRUCCION_ASUNTO = " + strIdInstruccion;
		return sql;
	}

}
