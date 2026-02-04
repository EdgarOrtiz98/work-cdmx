/*
 * Clase:						SQLAsuntoTurnado.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Oct 6, 2005
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

package com.meve.sigma.sql;

/**
 * SQLAsuntoTurnado es una clase que contiene los querys que hacen consultas y
 * actualizaciones a la tabla de SD_ASUNTO
 * 
 * @author Meve Soluciones SA de CV
 * 
 */
public class SQLAsuntoTurnado {

	/**
	 * Función que ejecuta un query que trae todos los datos de la tabla de
	 * SD_ASunto que tenga como estatus Turnado
	 * 
	 * @param strIdAsunto
	 *            Id asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAsuntoTurnado(String strIdAsunto) {
		String sql = "";

		sql = "SELECT ASU_ENTIDAD, ASU_ENTIDAD_OTRO, ASU_REMITENTE, ASU_REMITENTE_OTRO, ASU_FIRMANTE,"
				+ // 5
				" ASU_DESCRIPCION, ASU_EXPEDIENTE, ASU_EXPEDIENTE_OTRO, ASU_UBICACION, ASU_REF_EXPEDIENTE,"
				+ // 10
				" ASU_TIP_DOCTO, ASU_TIP_DOCTO_OTRO, ASU_CATEGORIA, to_char(ASU_FECHA_RECEPCION,'yyyy-MM-dd'),"
				+ // 14
				" to_char(ASU_FECHA_DOCTO,'yyyy-MM-dd'), to_char(ASU_FECHA_CADUCIDAD,'yyyy-MM-dd'), "
				+ // 16
				" ASU_FOLIO_EXTERNO, ASU_FOLIO_INTERMEDIO, ASU_SINTESIS, ASU_COMENTARIOS,"
				+ // 20
				" ASU_PALABRA_CLAVE, ASU_REF_ASUNTO_ANTERIOR, ASU_PRIORIDAD, ASU_FOLIO_RECEPCION,"
				+ // 24
				" ASU_USUARIO_CAPTURA, to_char(ASU_FECHA_CAPTURA,'yyyy-MM-dd'), ASU_AREA_RECEPCION, ASU_TIPO_ASUNTO,"
				+ // 28
				" ASU_ESTATUS, ASU_AVANCE, "
				+ // 30
				" ASU_TIP_DOCTO, ASU_PRIORIDAD, ASU_USR_TURNA, USU_AREA, ASU_CONTROL, ASU_RUTA_AUTOMATICA,"
				+ // 36
				" asu_lista_para, asu_lista_cc, to_char(ASU_FECHA_EVENTO,'yyyy-MM-dd') , ASU_LUGAR_EVENTO, "
				+ // 40
				" ASU_HORA_EVENTO, ASU_MIN_EVENTO, asu_lista_para_Ext, ASU_TRAMITE, ASU_MAIL, "
				+ // 45
				" ASU_FOLIO_ENTRADA, ASU_CONTROL_FOLIO, ASU_LISTAIDS_PARA, ASU_LISTAIDS_CC, ASU_LISTAIDS_PARA_EXT, "
				+ // 50
				" TO_CHAR(ASU_FECHA_RECEPCION, 'HH24'), TO_CHAR(ASU_FECHA_RECEPCION, 'MI') "
				+ // 52
				" FROM SD_ASUNTO, SD_USUARIO "
				+ " WHERE ID_ASUNTO="
				+ strIdAsunto
				+ ""
				+ " AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA ";
		return sql;
	}

	/**
	 * Actualiza el estatus a 2(Trámite)
	 * 
	 * @param strIdAsunto
	 *            Id Asuntos
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String ActualizaIDEstatus(String strIdAsunto) {
		String sql = "";
		sql = "UPDATE SD_ASUNTO SET ASU_ESTATUS=2 WHERE ID_ASUNTO="
				+ strIdAsunto;
		return sql;
	}

	/**
	 * Verifica las instrucciones a turnar
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getVerificarInstruccionesTurnar(String strIdAsunto) {
		String sql = "";
		sql = "SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE ID_ASUNTO="
				+ strIdAsunto + " " + "AND INS_ESTATUS=0 AND INS_PADRE IS NULL";
		return sql;
	}

	/**
	 * Verifica instrucciones que tiene instrucciones hijas
	 * 
	 * @param strIdPadre
	 *            Id instrucción padre
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getVerificarInstruccionesTurnarPadre(String strIdPadre) {
		String sql = "";
		sql = "SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE INS_PADRE="
				+ strIdPadre + " " + "AND INS_ESTATUS=0";
		return sql;
	}

	/**
	 * Función que regresa un query para verificar la secuencia de los pasos que
	 * tiene cada instrucción
	 * 
	 * @param strIdAsunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String SecuenciaPasosInstruccion(String strIdAsunto) {
		String sql = "";
		sql = "SELECT PAS_SECUENCIA, INS_TIEMPO, ID_INSTRUCCION_ASUNTO, "
				+ "INS_USUARIO, USU_CORREO, INS_REQUERIDO, USU_AREA, INS_INSTRUCCION, INS_TIPO_ATENCION "
				+ "FROM SD_INSTRUCCION_ASUNTO, SD_PASO, SD_USUARIO  "
				+ "WHERE ID_ASUNTO="
				+ strIdAsunto
				+ " AND INS_ESTATUS=0 "
				+ "AND INS_PADRE IS NULL "
				+ "AND SD_INSTRUCCION_ASUNTO.INS_PASO=SD_PASO.ID_PASOS "
				+ "AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
				+ "ORDER BY PAS_SECUENCIA ASC";
		return sql;
	}

	/**
	 * Secuencia de los pasos de las instrucciones hijas
	 * 
	 * @param strIdPadre
	 *            Id instrucción
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String SecuenciaPasosInstruccionPadre(String strIdPadre) {
		String sql = "";
		sql = "SELECT PAS_SECUENCIA, INS_TIEMPO, ID_INSTRUCCION_ASUNTO, "
				+ "INS_USUARIO, USU_CORREO, INS_REQUERIDO, USU_AREA, INS_TIPO_ATENCION "
				+ "FROM SD_INSTRUCCION_ASUNTO, SD_PASO, SD_USUARIO  "
				+ "WHERE INS_PADRE="
				+ strIdPadre
				+ " AND INS_ESTATUS=0 "
				+ "AND SD_INSTRUCCION_ASUNTO.INS_PASO=SD_PASO.ID_PASOS "
				+ "AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
				+ "ORDER BY PAS_SECUENCIA ASC";
		return sql;
	}

	/**
	 * Función que ejecuta un query para comprobar si la instrucción ha sido
	 * turnada verificando si tiene fecha de inicio y fin
	 * 
	 * @param strIdInstruccion
	 *            String Contiene el ID de la Instruccion
	 * @return sql Query
	 */
	public static String tieneFechas(String strIdInstruccion) {
		String sql = "";
		sql = "SELECT TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd') "
				+ "FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="
				+ strIdInstruccion + " " + "AND INS_ESTATUS=4";
		return sql;
	}

	/**
	 * Fecha de asignación de la instrucción
	 * 
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String FechasAsignacion(String strIdInstruccion) {
		String sql = "";
		sql = "SELECT TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd') "
				+ "FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="
				+ strIdInstruccion + " ";
		return sql;
	}

	/**
	 * Función que regresa un query de la tabla de SD_HISTORIAL_INSTUECCIONES la
	 * fecha en la que se termino la instrucción
	 * 
	 * @param strIdInstruccion
	 *            String Contiene el ID de la instrucción
	 * @return sql Query
	 */
	public static String getFechaFinInstruccion(String strIdInstruccion) {
		String sql = "";
		sql = "SELECT TO_CHAR(HIS_FECHA, 'yyyy-MM-dd'), HIS_AVANCE FROM SD_HISTORIAL_INSTRUCCIONES "
				+ "WHERE ID_INSTRUCCION_ASUNTO="
				+ strIdInstruccion
				+ " AND HIS_AVANCE=100.0";
		return sql;
	}

	/**
	 * Instrucciones habilitadas
	 * 
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getInstruccionesHabilitadas(String strIdInstruccion) {
		String sql = "";
		sql = "SELECT INS_PADRE, INS_ESTATUS, INS_INSTRUCCION_OTRO, INS_INSTRUCCION FROM SD_INSTRUCCION_ASUNTO WHERE INS_PADRE="
				+ strIdInstruccion;
		return sql;
	}

	/**
	 * Instrucciones habilitadas para instrucciones padrees
	 * 
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getInstHabAtender(String strIdInstruccion) {
		String sql = "";
		sql = "SELECT INS_PADRE, INS_ESTATUS FROM SD_INSTRUCCION_ASUNTO "
				+ "WHERE INS_PADRE=" + strIdInstruccion + " AND INS_ESTATUS>0";
		return sql;
	}

	/**
	 * Función que regresa un query con el Número de instrucciones que se le han
	 * turnado
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getCountInstruccion(String strIdAsunto) {
		String sql = "";
		sql = "SELECT COUNT(*) FROM SD_INSTRUCCION_ASUNTO WHERE INS_PADRE IS NULL "
				+ "AND ID_ASUNTO=" + strIdAsunto + " AND INS_TIPO_ATENCION=0";
		return sql;
	}

	/**
	 * Número de instrucciones padre que se le han turnado
	 * 
	 * @param strIdPadre
	 *            Contiene el id de la instrucción padre
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getCountInstruccionPadre(String strIdPadre) {
		String sql = "";
		sql = "SELECT COUNT(*) FROM SD_INSTRUCCION_ASUNTO WHERE INS_PADRE="
				+ strIdPadre + " AND INS_TIPO_ATENCION=0 ";
		return sql;
	}

	/**
	 * Número de instrucciones no terminadas segun su instruccion padre
	 * 
	 * @param strIdPadre
	 *            Contiene el id de la instrucción padre
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getCountInstNoTerminadas(String strIdPadre) {
		String sql = "";
		sql = "SELECT COUNT(*) FROM SD_INSTRUCCION_ASUNTO "
				+ "WHERE INS_TIPO_ATENCION=0 " + "AND INS_AVANCE < 100 "
				+ "AND INS_PADRE = " + strIdPadre;
		return sql;
	}

	/**
	 * Actualización del avance general de un asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String ActualizaAvanceAsunto(String strIdAsunto,
			String strAvance) {
		String sql = "";
		sql = "UPDATE SD_ASUNTO SET ASU_AVANCE=" + strAvance
				+ " WHERE ID_ASUNTO=" + strIdAsunto;
		return sql;
	}

	/**
	 * Función que regresa un query, donde actualiza el avance de una
	 * instrucción padre
	 * 
	 * @param strIdPadre
	 *            Contiene el Id de la instrucción padre
	 * @param strAvance
	 *            Avance de la instruccion
	 * @return Update
	 */
	public static String ActualizaAvancePadre(String strIdPadre,
			String strAvance) {
		String sql = "";
		sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_AVANCE=" + strAvance
				+ " WHERE ID_INSTRUCCION_ASUNTO=" + strIdPadre;
		return sql;
	}

	/**
	 * Actualización del estatus de un asunto y el avance al 99%
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String ActualizaEstatusAsunto(String strIdAsunto,
			String strFechaReal, String strFechaTerminacion) {
		String sql = "";
		// sql = "UPDATE SD_ASUNTO SET ASU_ESTATUS=3,
		// ASU_FECHA_REAL='"+strFechaReal+"', " +
		// "ASU_FECHA_TERMINACION='"+strFechaTerminacion+"' WHERE
		// ID_ASUNTO="+strIdAsunto;
		sql = "UPDATE SD_ASUNTO SET ASU_ESTATUS=2, ASU_AVANCE=99 "
				+ " WHERE ID_ASUNTO=" + strIdAsunto;
		return sql;
	}

	/**
	 * Termina el asunto y actuliza la fecha real de terminación
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @param strFechaReal
	 *            Fecha Real
	 * @param strFechaTerminacion
	 *            Fecha terminación
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String terminarAsunto(String strIdAsunto,
			String strFechaReal, String strFechaTerminacion) {
		String sql = "";
		sql = "UPDATE SD_ASUNTO SET ASU_ESTATUS=3, ASU_FECHA_REAL=to_timestamp('"
				+ strFechaReal
				+ "', 'YYYY-MM-DD HH24:MI:SS'), "
				+
				// "ASU_FECHA_TERMINACION='"+strFechaTerminacion+"',
				// ASU_AVANCE=100 WHERE ID_ASUNTO="+strIdAsunto;
				"ASU_FECHA_TERMINACION=TO_DATE('"
				+ strFechaTerminacion
				+ "', 'DD/MM/YYYY'), ASU_AVANCE=100 WHERE ID_ASUNTO="
				+ strIdAsunto;
		return sql;
	}

	/**
	 * Función que que ejcuta un query, donde actualiza los campo de prioridad y
	 * tipo de asunto. La ruta automatica es opcional
	 * 
	 * @param strIdAsunto
	 *            Contiene el ID del Asunto
	 * @return Query
	 */
	public static String actualizaPrioridad(String strIdAsunto,
			String idPrioridad, String strIdTipoAsunto, String idRuta,
			String strIdTipoDocto, String strFolio) {
		String sql = "";
		if (idRuta.equals("null")) {
			sql = "UPDATE SD_ASUNTO SET ASU_PRIORIDAD=" + idPrioridad
					+ ", ASU_TIPO_ASUNTO=" + strIdTipoAsunto + ", "
					+ "ASU_TIP_DOCTO=" + strIdTipoDocto
					+ ", ASU_FOLIO_RECEPCION='" + strFolio
					+ "' WHERE ID_ASUNTO=" + strIdAsunto;
		} else {
			sql = "UPDATE SD_ASUNTO SET ASU_PRIORIDAD=" + idPrioridad
					+ ", ASU_TIPO_ASUNTO=" + strIdTipoAsunto + ", "
					+ "ASU_RUTA_AUTOMATICA=" + idRuta + ", ASU_TIP_DOCTO="
					+ strIdTipoDocto + ", ASU_FOLIO_RECEPCION='" + strFolio
					+ "' " + "WHERE ID_ASUNTO=" + strIdAsunto;
		}
		return sql;
	}

	/**
	 * Actualización de un prioridad
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @param idPrioridad
	 *            Id prioridad
	 * @param strIdTipoAsunto
	 *            Id Tipo de Asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String actualizaPrioridad1(String strIdAsunto,
			String idPrioridad, String strIdTipoAsunto/* , String idRuta */) {
		String sql = "";
		// if(idRuta.equals("null")){
		sql = "UPDATE SD_ASUNTO SET ASU_PRIORIDAD=" + idPrioridad
				+ ", ASU_TIPO_ASUNTO=" + strIdTipoAsunto + " "
				+ " WHERE ID_ASUNTO=" + strIdAsunto;
		/*
		 * }else{ sql = "UPDATE SD_ASUNTO SET ASU_PRIORIDAD="+idPrioridad+",
		 * ASU_TIPO_ASUNTO="+strIdTipoAsunto+", " +
		 * "ASU_RUTA_AUTOMATICA="+idRuta+" " + "WHERE ID_ASUNTO="+strIdAsunto; }
		 */
		return sql;
	}

	/**
	 * Función que regresa un query, donde muestra las instrucciónes hijos de la
	 * instrucción padre
	 * 
	 * @param strIdInstPadre
	 *            Contiene el ID de la instrucción padre
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getInstHabilitarTur(String strIdInstPadre) {
		String sql = "SELECT INS_TIEMPO, PAS_SECUENCIA, ID_INSTRUCCION_ASUNTO, "
				+ "INS_USUARIO, USU_CORREO, INS_REQUERIDO, USU_AREA, INS_INSTRUCCION,"
				+ "INS_INSTRUCCION_OTRO, INS_TIPO_ATENCION"
				+ " FROM SD_INSTRUCCION_ASUNTO, SD_PASO, SD_USUARIO "
				+ "WHERE INS_PADRE="
				+ strIdInstPadre
				+ " AND INS_ESTATUS=0 "
				+ "AND SD_PASO.ID_PASOS=SD_INSTRUCCION_ASUNTO.INS_PASO "
				+ "AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
				+ "ORDER BY 2, 3 ASC";
		return sql;
	}

	/**
	 * Función que regresa un query, donde muestra las instrucciónes hijos de la
	 * instrucción padre
	 * 
	 * @param strIdInstPadre
	 *            Contiene el ID de la instrucción padre
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getDatosInstruccionTurnar(String string) {
		return ("SELECT INS_TIEMPO, PAS_SECUENCIA, ID_INSTRUCCION_ASUNTO, "
				+ "INS_USUARIO, USU_CORREO, INS_REQUERIDO, USU_AREA "
				+ "FROM SD_INSTRUCCION_ASUNTO, SD_PASO, SD_USUARIO "
				+ "WHERE INS_PADRE="
				+ string
				+ " AND INS_ESTATUS=0 "
				+ "AND SD_PASO.ID_PASOS=SD_INSTRUCCION_ASUNTO.INS_PASO "
				+ "AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO " + "ORDER BY 2, 3 ASC");
	}

	/**
	 * Función que regresa un query donde actualiza el estatus de la instrucción
	 * padre
	 * 
	 * @param strIdInstPadre
	 *            Contiene el Id de la instrucción padre
	 * @return Query
	 */
	public static String ActualizaIDEstatusInst(String strIdInstPadre) {
		String sql = "";
		sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_ESTATUS=2 WHERE ID_INSTRUCCION_ASUNTO="
				+ strIdInstPadre;
		return sql;
	}

	/**
	 * Función que regresa un query con el avance de la instruccion padre
	 * 
	 * @param strIdInstPadre
	 *            Contiene el Id de la instruccion padre
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAvanceInstTurnado(String strIdInstPadre) {
		String sql = "";
		sql = "SELECT INS_AVANCE, ID_ASUNTO FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="
				+ strIdInstPadre;
		return sql;
	}

	/**
	 * Función que regresa un query para verificar si instrucción es hijo
	 * 
	 * @param idInstruccion
	 *            Contiene el Id de la instrucción
	 * @return Query
	 */
	public static String getEsHijo(String idInstruccion) {
		String sql = "";
		sql = "SELECT INS_PADRE FROM SD_INSTRUCCION_ASUNTO "
				+ "WHERE ID_INSTRUCCION_ASUNTO=" + idInstruccion;
		return sql;
	}

	/**
	 * Función que regresa un query, donde trae el id de la instruccion padre
	 * 
	 * @param idInstruccion
	 *            Contiene el Id de la Instruccion hija
	 * @return Query
	 */
	public static String getIdPadre(String idInstruccion) {
		String sql = "";
		sql = "SELECT INS_PADRE FROM SD_INSTRUCCION_ASUNTO "
				+ "WHERE ID_INSTRUCCION_ASUNTO=" + idInstruccion;
		return sql;
	}

	/**
	 * Función que regresa un query, donde actualiza el estatus para finalizar
	 * la instrucción padre
	 * 
	 * @param strIdPadre
	 *            Contiene el Id de la instrucción padre
	 * @return Query
	 */
	public static String actualizaRespuestaPadre(String strIdPadre) {
		String sql = "";
		sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_ESTATUS=4 WHERE INS_PADRE="
				+ strIdPadre;
		return sql;
	}

	/**
	 * Función que regresa un query, donde actualiza el estatus para finalizar
	 * la instrucción padre
	 * 
	 * @param strIdPadre
	 *            Contiene el Id de la instrucción padre
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String actualizaRespuestaPadre1(String strIdPadre) {
		String sql = "";
		sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_ESTATUS=2, INS_AVANCE=99 WHERE ID_INSTRUCCION_ASUNTO="
				+ strIdPadre;
		return sql;
	}

	/**
	 * Función que regrsa un query, donde verifica dentro de una instruccion
	 * hija, si la instruccion padre puede turnar otras instrucciones que estan
	 * a su mismo nivel
	 * 
	 * @param IdAsunto
	 *            Contien el Id del Asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String TieneMasInstTurnar(String IdAsunto) {
		String sql = "";
		sql = "SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE ID_ASUNTO=" + IdAsunto
				+ " AND INS_ESTATUS=0 AND INS_PADRE IS NULL";
		return sql;
	}

	/**
	 * Vericia si existen instrucciones nuevas sin turnar
	 * 
	 * @param strIdAsunto
	 *            Id Asuntos
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String existenInstruccionesNuevasSinTurnar(String strIdAsunto) {
		String sql = "";
		sql = "SELECT COUNT(*) FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS=0 "
				+ "AND ID_ASUNTO=" + strIdAsunto + " AND INS_PADRE IS NULL";
		return sql;
	}

	/**
	 * Función que regresa un query, donde actualiza la fecha estimada de
	 * terminacion de un asunto
	 * 
	 * @param strIdAsunto
	 *            id del Asunto
	 * @param strFechaEstimada
	 *            Fecha estimada de terminacion
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getUpdateFechaEstimada(String strIdAsunto,
			String strFechaEstimada) {
		String sql = "UPDATE SD_ASUNTO SET ASU_FECHA_ESTIMADA=TO_DATE('"
				+ strFechaEstimada + "', 'DD/MM/YYYY') " + "WHERE ID_ASUNTO="
				+ strIdAsunto;
		return sql;
	}

	/**
	 * Función que ejecuta un query que trae todos los datos de la tabla de
	 * SD_ASunto que tenga como estatus Turnado para la generación del Reporte
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getAsuntoTurnadoReporte(String strIdAsunto) {
		String sql = "";
		sql = "SELECT ASU_ENTIDAD, ASU_ENTIDAD_OTRO, ASU_REMITENTE, ASU_REMITENTE_OTRO, ASU_FIRMANTE,"
				+ " ASU_DESCRIPCION, ASU_EXPEDIENTE, ASU_EXPEDIENTE_OTRO, ASU_UBICACION, ASU_REF_EXPEDIENTE,"
				+ " ASU_TIP_DOCTO, ASU_TIP_DOCTO_OTRO, ASU_CATEGORIA, to_char(ASU_FECHA_RECEPCION,'yyyy-MM-dd'),"
				+ " to_char(ASU_FECHA_DOCTO,'yyyy-MM-dd'), to_char(ASU_FECHA_CADUCIDAD,'yyyy-MM-dd'), "
				+ " ASU_FOLIO_EXTERNO, ASU_FOLIO_INTERMEDIO, ASU_SINTESIS, ASU_COMENTARIOS,"
				+ " ASU_PALABRA_CLAVE, ASU_REF_ASUNTO_ANTERIOR, ASU_PRIORIDAD, ASU_FOLIO_RECEPCION,"
				+ " ASU_USUARIO_CAPTURA, to_char(ASU_FECHA_CAPTURA,'yyyy-MM-dd'), ASU_AREA_RECEPCION, ASU_TIPO_ASUNTO,"
				+ " ASU_ESTATUS, ASU_AVANCE, "
				+ " ASU_TIP_DOCTO, ASU_PRIORIDAD, ASU_USR_TURNA, USU_AREA, ASU_CONTROL, ASU_RUTA_AUTOMATICA,"
				+ " asu_lista_para, asu_lista_cc, to_char(ASU_FECHA_EVENTO,'yyyy-MM-dd') , ASU_LUGAR_EVENTO, "
				+ " ASU_HORA_EVENTO, ASU_MIN_EVENTO, asu_lista_para_Ext, ASU_TRAMITE, ASU_MAIL, ASU_FOLIO_ENTRADA,"
				+ " ASU_LISTAIDS_PARA, ASU_LISTAIDS_CC, ASU_LISTAIDS_PARA_EXT, ASU_CONTROL_FOLIO, TO_CHAR(ASU_FECHA_RECEPCION, 'HH24:MI') AS HORA "
				+ " FROM SD_ASUNTO, SD_USUARIO "
				+ " WHERE ID_ASUNTO="
				+ strIdAsunto
				+ ""
				+ " AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA ";
		return sql;
	}

	/**
	 * Query que trae el tipo de atencion de una instrucción
	 * 
	 * @param strIdInstruccion
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getTipoAtencion(String strIdInstruccion) {
		String sql = "SELECT INS_TIPO_ATENCION FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="
				+ strIdInstruccion;
		return sql;
	}

	/**
	 * Inserta los descriptivos de un asuntos al ser turnado
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @param strAreaRep
	 *            área de Recepción
	 * @param strEntidad
	 *            Entidad
	 * @param strRemitente
	 *            Remitente
	 * @param strRemNombre
	 *            Nombre del Remitente
	 * @param strRemMail
	 *            Mail del Remitente
	 * @param strControl
	 *            Control
	 * @param strTurPuesto
	 *            Puesto del turnadr
	 * @param strTurNombre
	 *            Nombre del turnador
	 * @param strTurArea
	 *            área del turnador
	 * @param strTipoDocto
	 *            Tipo de documento
	 * @param strExpediente
	 *            Expediente
	 * @param strTramite
	 *            Trámite
	 * @param strTipoAsunto
	 *            Tipo de Asunto
	 * @param strPrioridad
	 *            Prioridad
	 * @param strUsrCaptura
	 *            usuario de captura de un asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String insertAsuntoDescriptivos(String strIdAsunto,
			String strAreaRep, String strEntidad, String strRemitente,
			String strRemNombre, String strRemMail, String strControl,
			String strTurPuesto, String strTurNombre, String strTurArea,
			String strTipoDocto, String strExpediente, String strTramite,
			String strTipoAsunto, String strPrioridad, String strUsrCaptura) {

		String sql = "INSERT INTO SD_ASUNTO_DESCRIPCION (ID_ASUNTO_REF, ASU_REF_AREA_RECEPCION,"
				+ "ASU_REF_ENTIDAD, ASU_REF_REMITENTE, ASU_REF_REMITENTE_NOMBRE,"
				+ "ASU_REF_REMITENTE_CORREO, ASU_REF_CONTROL, ASU_TURNADOR_PUESTO,"
				+ "ASU_TURNADOR_NOMBRE, ASU_REF_TURNADOR_AREA, ASU_REF_TIPO_DOCTO,"
				+ "ASU_REF_EXPEDIENTE, ASU_REF_TRAMITE, ASU_REF_TIPO_ASUNTO, "
				+ "ASU_REF_PRIORIDAD, ASU_REF_USR_CAPTURA) VALUES " + "("
				+ strIdAsunto
				+ ",'"
				+ strAreaRep
				+ "', '"
				+ strEntidad
				+ "', "
				+ "'"
				+ strRemitente
				+ "', '"
				+ strRemNombre
				+ "', '"
				+ strRemMail
				+ "', "
				+ ""
				+ strControl
				+ ", '"
				+ strTurPuesto
				+ "',"
				+ "'"
				+ strTurNombre
				+ "', '"
				+ strTurArea
				+ "', '"
				+ strTipoDocto
				+ "', "
				+ "'"
				+ strExpediente
				+ "', '"
				+ strTramite
				+ "', "
				+ "'"
				+ strTipoAsunto
				+ "', '"
				+ strPrioridad + "', '" + strUsrCaptura + "')";
		return sql;
	}

	/**
	 * Control del asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getControl(String strIdAsunto) {
		String sql = "SELECT ASU_CONTROL FROM SD_ASUNTO WHERE ID_ASUNTO="
				+ strIdAsunto;
		return sql;
	}

	/**
	 * Función que ejecuta un query que trae la lista de los descriptivos de un
	 * asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @param strControl
	 *            Control
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getDatosDescripcion(String strIdAsunto,
			String strControl) {
		String sql = "";
		if (strControl.equals("0")) {// Entidades Externas
			sql = "SELECT ENT_NOMBRE, RMT_NOMBRE, RMT_CARGO, RMT_CORREO, "
					+ "TIP_DOCTO_NOMBRE, TIP_ASU_NOMBRE, PRI_NOMBRE, ASU_TRAMITE, "
					+ "ASU_EXPEDIENTE, ASU_USUARIO_CAPTURA, ASU_AREA_RECEPCION, "
					+ "ASU_LISTAIDS_PARA, ASU_LISTAIDS_CC, ASU_LISTAIDS_PARA_EXT "
					+ "FROM SD_ASUNTO, SD_ENTIDAD, SD_REMITENTE, SD_TIPO_DOCUMENTO, "
					+ "SD_TIPO_ASUNTO, SD_PRIORIDAD "
					+ "WHERE ID_ASUNTO="
					+ strIdAsunto
					+ " "
					+ "AND SD_ASUNTO.ASU_ENTIDAD=SD_ENTIDAD.ID_ENTIDAD "
					+ "AND SD_ASUNTO.ASU_REMITENTE=SD_REMITENTE.ID_REMITENTE "
					+ "AND SD_ASUNTO.ASU_TIP_DOCTO=SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO "
					+ "AND SD_ASUNTO.ASU_TIPO_ASUNTO=SD_TIPO_ASUNTO.ID_TIPO_ASUNTO "
					+ "AND SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES";
		} else if (strControl.equals("1")) {// Entidades Internas(UA'S)
			sql = "SELECT ARE_NOMBRE, USU_NOMBRE, USU_CARGO, USU_CORREO, "
					+ "TIP_DOCTO_NOMBRE, TIP_ASU_NOMBRE, PRI_NOMBRE, ASU_TRAMITE, "
					+ "ASU_EXPEDIENTE, ASU_USUARIO_CAPTURA, ASU_AREA_RECEPCION, "
					+ "ASU_LISTAIDS_PARA, ASU_LISTAIDS_CC, ASU_LISTAIDS_PARA_EXT "
					+ "FROM SD_ASUNTO, SD_AREA, SD_USUARIO, SD_TIPO_DOCUMENTO, "
					+ "SD_TIPO_ASUNTO, SD_PRIORIDAD "
					+ "WHERE ID_ASUNTO="
					+ strIdAsunto
					+ " "
					+ "AND SD_ASUNTO.ASU_ENTIDAD=SD_AREA.ID_AREA "
					+ "AND SD_ASUNTO.ASU_REMITENTE=SD_USUARIO.ID_USUARIO "
					+ "AND SD_ASUNTO.ASU_TIP_DOCTO=SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO "
					+ "AND SD_ASUNTO.ASU_TIPO_ASUNTO=SD_TIPO_ASUNTO.ID_TIPO_ASUNTO "
					+ "AND SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES";
		}
		return sql;
	}

	/**
	 * Datos del turnador
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getDatosTurnador(String strIdAsunto) {
		String sql = "SELECT USU_NOMBRE, USU_CARGO, ARE_NOMBRE "
				+ "FROM SD_ASUNTO, SD_USUARIO, SD_AREA WHERE ID_ASUNTO="
				+ strIdAsunto + " "
				+ "AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO "
				+ "AND SD_USUARIO.USU_AREA=SD_AREA.ID_AREA";
		return sql;
	}

	/**
	 * Verifica si existe asuntos con Descripción
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getExisteDes(String strIdAsunto) {
		String sql = "SELECT * FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF="
				+ strIdAsunto;
		return sql;
	}

	/**
	 * Descriptivo de un asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getDatosDes(String strIdAsunto) {
		String sql = "SELECT ASU_REF_AREA_RECEPCION, "
				+ // 1
				"ASU_REF_ENTIDAD, ASU_REF_REMITENTE, ASU_REF_REMITENTE_NOMBRE, "
				+ // 4
				"ASU_REF_REMITENTE_CORREO, ASU_REF_CONTROL, ASU_TURNADOR_PUESTO, "
				+ // 7
				"ASU_TURNADOR_NOMBRE, ASU_REF_TURNADOR_AREA, ASU_REF_TIPO_DOCTO, "
				+ // 10
				"ASU_REF_EXPEDIENTE, ASU_REF_TRAMITE, ASU_REF_TIPO_ASUNTO, " + // 13
				"ASU_REF_PRIORIDAD, ASU_REF_USR_CAPTURA " + // 15
				"FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF=" + strIdAsunto;
		return sql;
	}

	/**
	 * Función que inserta datos de los descriptivos de los destinatarios de un
	 * asunto
	 * 
	 * @param strIdAsunto
	 * @param strIdsPara
	 * @param strIdsCC
	 * @param strIdsParaExt
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String insertDescriptivosDest(String strIdAsunto,
			String strTipoDest, String strIdUsuario, String strDescriptivo) {
		String sql = "INSERT INTO SD_REF_DESTINATARIOS (ID_ASUNTO_REF, REF_TIPO_DESTINATARIO, "
				+ "REF_ID_USUARIO, REF_DESCRIPCION) VALUES("
				+ strIdAsunto
				+ ", "
				+ strTipoDest
				+ ", "
				+ ""
				+ strIdUsuario
				+ ", '"
				+ strDescriptivo + "')";
		return sql;
	}

	/**
	 * Descriptivos de los destinatarios Para
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getDesPara(String strIdAsunto) {
		String sql = "SELECT REF_DESCRIPCION FROM SD_REF_DESTINATARIOS WHERE ID_ASUNTO_REF="
				+ strIdAsunto + " AND REF_TIPO_DESTINATARIO=1";
		return sql;
	}

	/**
	 * Descriptivos CCp
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getDesCC(String strIdAsunto) {
		String sql = "SELECT REF_DESCRIPCION FROM SD_REF_DESTINATARIOS WHERE ID_ASUNTO_REF="
				+ strIdAsunto + " AND REF_TIPO_DESTINATARIO=2";
		return sql;
	}

	public static String getDesCCReporte(String strIdAsunto) {
		String sql = "SELECT  ASU_LISTAIDS_CC FROM SD_ASUNTO, SD_USUARIO " +
						"WHERE ID_ASUNTO = " + strIdAsunto + 
						" AND SD_USUARIO.ID_USUARIO = SD_ASUNTO.ASU_USR_TURNA";
		return sql;
	}
	
	/**
	 * Descriptivos ParaExt
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getDesParaE(String strIdAsunto) {
		String sql = "SELECT REF_DESCRIPCION FROM SD_REF_DESTINATARIOS WHERE ID_ASUNTO_REF="
				+ strIdAsunto + " AND REF_TIPO_DESTINATARIO=3";
		return sql;
	}

	/**
	 * Actualiza Fecha compromiso de un asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @param strFechaCom
	 *            Id Nueva fecha compromiso
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String actualizaFechaCompromiso(String strIdAsunto,
			String strFechaCom) {
		String sql = "UPDATE SD_ASUNTO SET ASU_FECHA_CADUCIDAD=TO_DATE('"
				+ strFechaCom + "', 'DD/MM/YYYY') WHERE ID_ASUNTO="
				+ strIdAsunto;
		return sql;
	}

}
