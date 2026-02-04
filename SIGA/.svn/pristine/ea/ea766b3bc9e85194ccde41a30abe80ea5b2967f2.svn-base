/*
 * Clase:						ActualizaBitacora.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Oct 20, 2005
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

package com.meve.sigma.actualiza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.organizacional.puesto.PuestoForm;

/**
 * Clase para Insertar y Consultar eventos en la bitacora de los usuarios
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class ActualizaBitacora {

	private static String SQL_INSERT = "INSERT INTO SD_BITACORA1 (ID_BITACORA, BIT_USUARIO, BIT_FECHA_EVENTO, "
			+ "BIT_EVENTO) VALUES (SD_BITACORA1_SEQ.NEXTVAL,";
	private static String SQL_RESPUESTA = "Respuesta a una instrucción";
	private static String SQL_RECHAZO = "Rechazó una instrucción";
	private static String SQL_DELEGO = "Delegó una instrucción";
	private static String SQL_REASIGNO = "Reasignó una instrucción";
	private static String SQL_HABILITAR = "Generó instrucciones para atender la solicitud ";
	private static String SQL_ALTA_AREA = "Registró una nueva Unidad Administrativa";
	private static String SQL_CAMBIO_AREA = "Cambió el registro de una Unidad Administrativa";
	private static String SQL_ALTA_ASUNTO = "El usuario Registró un nuevo asunto";
	private static String SQL_CAMBIO_ASUNTO = "El usuario Cambió el registro de un asunto";
	private static String SQL_TURNAR = "El usuario ha turnado instrucciones";
	private static String SQL_RUTA_AUTO = "El usuario creo una ruta automatica";
	private static String SQL_DELETE_AREA = "Eliminó Registro de una Unidad Administrativa";
	private static String SQL_SELECT_USR = "SELECT BIT_USUARIO, BIT_EVENTO, TO_CHAR(BIT_FECHA_EVENTO, 'DD/MM/YYYY HH:MI:SS AM'), BIT_FECHA_EVENTO FROM SD_BITACORA1 "
			+ "WHERE BIT_USUARIO=";
	private static String SQL_ORDER_BY = " ORDER BY ";
	private static String SQL_EXISTE_BIT = "SELECT * FROM SD_BITACORA1 WHERE BIT_USUARIO=";
	private static String SQL_UNIC_USR = "SELECT DISTINCT BIT_USUARIO FROM SD_BITACORA1 WHERE BIT_USUARIO=";

	// **Destinatarios Externos
	private static String DES_ALTA = "Registró un Destinatario Externo";
	private static String DES_BAJA = "Eliminó Registro de un Destinatario Externo";
	private static String DES_CAMBIO = "Cambió el Registro de un Destinatario Externo";

	// **Entidad
	private static String ENT_ALTA = "Registró una Entidad";
	private static String ENT_BAJA = "Eliminó Registro de una Entidad";
	private static String ENT_CAMBIO = "Cambió el Registro de una Entidad";

	// **Remitente
	private static String RMT_ALTA = "Registró un Remitente";
	private static String RMT_BAJA = "Eliminó Registro de un Remitente";
	private static String RMT_CAMBIO = "Cambió el Registro de un Remitente";

	// **Tramites
	private static String TRA_ALTA = "Registró un Trámite";
	private static String TRA_BAJA = "Eliminó Registro de un Trámite";
	private static String TRA_CAMBIO = "Cambió el Registro de un Trámite";

	// **Tipo de Documento
	private static String TDO_ALTA = "Registró un Tipo de Documento";
	private static String TDO_BAJA = "Eliminó Registro de un Tipo de Documento";
	private static String TDO_CAMBIO = "Cambió el Registro de un Tipo de Documento";

	// **Tipo de Asunto
	private static String TAS_ALTA = "Registró un Tipo de Asunto";
	private static String TAS_BAJA = "Eliminó Registro de un Tipo de Asunto";
	private static String TAS_CAMBIO = "Cambió el Registro de un Tipo de Asunto";

	// **Prioridades
	private static String PRI_ALTA = "Registró una Prioridad";
	private static String PRI_BAJA = "Eliminó Registro de una Prioridad";
	private static String PRI_CAMBIO = "Cambió el Registro de una Prioridad";

	// **Folios
	private static String FOL_ALTA = "Registró un Folio";
	private static String FOL_BAJA = "Eliminó Registro de un Folio";
	private static String FOL_CAMBIO = "Cambió el Registro de un Folio"; // ///

	// **Pasos
	private static String PAS_ALTA = "Registró un Paso";
	private static String PAS_BAJA = "Eliminó Registro de un Paso";
	private static String PAS_CAMBIO = "Cambió el Registro de un Paso";

	// **Ubicación
	private static String UBI_ALTA = "Registró una Ubicación";
	private static String UBI_BAJA = "Eliminó Registro de una Ubicación";
	private static String UBI_CAMBIO = "Cambió el Registro de una Ubicación";

	// **Ruta Automática
	private static String RAT_ALTA = "Registró una Ruta Automática";
	private static String RAT_BAJA = "Eliminó Registro de una Ruta Automática";
	private static String RAT_CAMBIO = "Cambió el Registro de una Ruta Automática";

	// **Instrucciones
	private static String INS_ALTA = "Registró una instrucción";
	private static String INS_BAJA = "Eliminó Registro de una instrucción";
	private static String INS_CAMBIO = "Cambió el Registro de una instrucción";

	// **Razón de Rechazo
	private static String REC_ALTA = "Registró una Razón de Rechazo";
	private static String REC_BAJA = "Eliminó Registro de una Razón de Rechazo";
	private static String REC_CAMBIO = "Cambió el Registro de una Razón de Rechazo";

	// **Día Festivo
	private static String DIA_ALTA = "Registró un Día Festivo";
	private static String DIA_BAJA = "Eliminó Registro de un Día Festivo";
	private static String DIA_CAMBIO = "Cambió el Registro de un Día Festivo";

	// **Puestos
	private static String USU_ALTA = "Registró un Puesto";
	private static String USU_BAJA = "Eliminó Registro de un Puesto";
	private static String USU_CAMBIO = "Cambió el Registro de un Puesto";

	// **Fondos
	private static String FONDO_ALTA = "Registró un Fondo";
	private static String FONDO_BAJA = "Eliminó Registro de un Fondo";
	private static String FONDO_CAMBIO = "Cambió el Registro de un Fondo";

	// **Subfondos
	private static String SUBFON_ALTA = "Registró un Subfondo";
	private static String SUBFON_BAJA = "Eliminó Registro de un Subfondo";
	private static String SUBFON_CAMBIO = "Cambió el Registro de un Subfondo";

	// **Seccion
	private static String SECC_ALTA = "Registró una Sección";
	private static String SECC_BAJA = "Eliminó Registro de una Sección";
	private static String SECC_CAMBIO = "Cambió el Registro de una Sección";

	// **Serie
	private static String SERIE_ALTA = "Registró una Serie";
	private static String SERIE_BAJA = "Eliminó Registro de una Serie";
	private static String SERIE_CAMBIO = "Cambió el Registro de una Serie";

	// **Subserie
	private static String SUBSE_ALTA = "Registró una Subserie";
	private static String SUBSE_BAJA = "Eliminó Registro de una Subserie";
	private static String SUBSE_CAMBIO = "Cambió el Registro de una Subserie";

	// **Estructura de Clasificacion
	private static String ESTR_ALTA = "Registró una Estructura de Clasificación";
	private static String ESTR_BAJA = "Eliminó Registro de una Estructura de Clasificación";
	private static String ESTR_CAMBIO = "Cambió el Registro de una Estructura de Clasificación";

	// **Valores
	private static String VALOR_ALTA = "Registró un Valor";
	private static String VALOR_BAJA = "Eliminó Registro de un Valor";
	private static String VALOR_CAMBIO = "Cambió el Registro de un Valor";

	// **Valoracion
	private static String VCION_ALTA = "Registró una Valoración";
	private static String VCION_BAJA = "Eliminó Registro de una Valoración";
	private static String VCION_CAMBIO = "Cambió el Registro de una Valoración";

	// **Seleccion
	private static String SELEC_ALTA = "Registró una Selección";
	private static String SELEC_BAJA = "Eliminó Registro de una Selección";
	private static String SELEC_CAMBIO = "Cambió el Registro de una Selección";

	// **Clasificacion de Informacion
	private static String CDI_ALTA = "Registró una Clasificacion de información";
	private static String CDI_BAJA = "Eliminó Registro de una Clasificacion de información";
	private static String CDI_CAMBIO = "Cambió el Registro de una Clasificacion de información";

	// **Instrumento Clasificación y Disposición Documental Serie
	private static String ICDD_ALTA = "Registró un Instrumento Clasificación y Disposición Documental Serie";
	private static String ICDD_BAJA = "Eliminó Registro de Instrumento Clasificación y Disposición Documental Serie";
	private static String ICDD_CAMBIO = "Cambió el Registro de Instrumento Clasificación y Disposición Documental Serie";

	// **Instrumento Clasificación y Disposición Documental Subserie
	private static String ICDD_SUBALTA = "Registró un Instrumento Clasificación y Disposición Documental SubSerie";
	private static String ICDD_SUBBAJA = "Eliminó Registro de Instrumento Clasificación y Disposición Documental SubSerie";
	private static String ICDD_SUBCAMBIO = "Cambió el Registro de Instrumento Clasificación y Disposición Documental SubSerie";

	// **Cedula Tipo
	private static String CTIPO_ALTA = "Registró una Cedula Tipo";
	private static String CTIPO_BAJA = "Eliminó Registro de Cedula Tipo";
	private static String CTIPO_CAMBIO = "Cambió el Registro de Cedula Tipo";

	// **ICDD por Unidad
	private static String ICDDU_ALTA = "Registró ICDD por Unidad";
	private static String ICDDU_BAJA = "Eliminó ICDD por Unidad";
	private static String ICDDU_CAMBIO = "Cambió el Registro ICDD por Unidad";

	// **Expedientes
	private static String EXPE_ALTA = "Registró un Expedientes";
	private static String EXPE_BAJA = "Eliminó Registro de un Expedientes";
	private static String EXPE_CAMBIO = "Cambió el Registro de un Expedientes";

	// **Configuracion SIGA
	private static String CONF_CAMBIO = "Modificó la Configuracion de SIGA";

	// **Entrada fallida al sistema
	private static String INT_ENTRAR = "Intentó entrar al Sistema";

	// **Suspencion del usuario
	private static String SUSPENCION = "Se suspendió al usuario";

	// **Cambio de Expediente de una instruccion
	private static String CAMBIO_EXP_INT = "Se Cambió el Expediente a una instrucción";

	// **Cambio de Expediente de un Asunto
	private static String CAMBIO_EXP_ASU = "Se Cambió el Expediente a un Asunto";

	// **Baja de un Asunto
	private static String ASUNTO_BAJA = "Se Eliminó un Asunto";

	/**
	 * Inserta en la bitacora un Evento de Responder Instrucciones
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param strMensaje
	 *            Mensaje a insertar en la bitacora
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoResponder(String idUsuario,
			String strMensaje) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date f = new Date();
		String FechaCreacion = sdf.format(f);
		int r = 0;
		try {
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '"
					+ SQL_RESPUESTA + ". " + strMensaje + "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertaUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Reasignar instrucción
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param strFolio
	 *            Folio de la instrucción
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoReasignar(String idUsuario,
			String strFolio) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date f = new Date();
		String FechaCreacion = sdf.format(f);
		int r = 0;
		try {
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + SQL_REASIGNO
					+ ". Folio: " + strFolio + "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoReasignar:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Rechazar instrucción
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param strFolio
	 *            Folio de la instrucción
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoRechazar(String idUsuario,
			String strFolio) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date f = new Date();
		String FechaCreacion = sdf.format(f);
		int r = 0;
		try {
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + SQL_RECHAZO
					+ ". Folio: " + strFolio + "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoRechazar:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Delegar instrucción
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param strFolio
	 *            Folio de la instrucción
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoDelegar(String idUsuario,
			String strFolio) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date f = new Date();
		String FechaCreacion = sdf.format(f);
		int r = 0;
		try {
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + SQL_DELEGO
					+ ". Folio: " + strFolio + "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoDelegar:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Delegación Multiple instrucción
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param strFolio
	 *            Folio de la instrucción
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoHabilitar(String idUsuario,
			String strFolio) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date f = new Date();
		String FechaCreacion = sdf.format(f);
		int r = 0;
		try {
			String sql = SQL_INSERT
					+ idUsuario
					+ ", SYSDATE, '"
					+ SQL_HABILITAR
					+ ". Se generaron instrucciones para la instrucción con Folio: "
					+ strFolio + "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoHabilitar:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Unidad Administrativa
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombreUnidad
	 *            Nombre de la UA
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaArea(String idUsuario,
			String nombreUnidad) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date f = new Date();
		String FechaCreacion = sdf.format(f);
		int r = 0;
		try {
			String sqlIdAreas = "SELECT ID_AREA FROM SD_AREA WHERE LOWER(ARE_NOMBRE)=LOWER('"
					+ nombreUnidad + "') AND ARE_ESTATUS=1";
			String idArea = getIdRegistroAltas(sqlIdAreas);
			String descripcion = SQL_ALTA_AREA + ". Nombre de la Unidad: "
					+ nombreUnidad + ", ID: " + idArea;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaArea:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Unidad Administrativa
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombreUnidad
	 *            Nombre de la UA
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean deleteEventoArea(String idUsuario, String idArea,
			String nombreUnidad) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date f = new Date();
		String FechaCreacion = sdf.format(f);
		int r = 0;
		try {
			String descripcion = SQL_DELETE_AREA + ". Nombre de la Unidad: "
					+ nombreUnidad + ", ID: " + idArea;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("deleteEventoArea:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Unidad Administrativa
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param idArea
	 *            ID de la UA
	 * @param nombreUnidad
	 *            Nombre de la UA
	 * @param datosPrevios
	 *            Datos anteriores del registro
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioArea(String idUsuario,
			String idArea, String nombreUnidad, String datosPrevios[][]) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date f = new Date();
		String FechaCreacion = sdf.format(f);
		int r = 0;
		try {
			String descripcion = SQL_CAMBIO_AREA
					+ ". <BR>"
					+ "ID: "
					+ idArea
					+ "<BR>"
					+ "Nombre: "
					+ datosPrevios[0][0]
					+ "<BR>"
					+ "Clave: "
					+ datosPrevios[0][7]
					+ "<BR>"
					+ "Descripción: "
					+ datosPrevios[0][1]
					+ "<BR>"
					+ "Supervisor UA: "
					+ (datosPrevios[0][2].equals("") ? "Sin Supervisor"
							: ActualizaUsuario.NombrePuesto(datosPrevios[0][2])
									+ "/"
									+ ActualizaUsuario
											.NombreUsuario(datosPrevios[0][2]))
					+ "<BR>"
					+ "UA Padre: "
					+ (datosPrevios[0][8].equals("") ? "Sin UA Padre"
							: ActualizaArea.NombreArea(datosPrevios[0][8]))
					+ "<BR>" + "Entrada: " + datosPrevios[0][3] + ":"
					+ datosPrevios[0][5] + "<BR>" + "Salida: "
					+ datosPrevios[0][4] + ":" + datosPrevios[0][6] + "<BR>"
					+ "Operando SIGA: "
					+ (datosPrevios[0][13].equals("0") ? "Si" : "No") + "<BR>"
					+ "Manejo Subventanilla: "
					+ (datosPrevios[0][14].equals("0") ? "Si" : "No") + "<BR>"
					+ "Año: " + datosPrevios[0][10] + "<BR>" + "Cosecutivo: "
					+ datosPrevios[0][9] + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioArea:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Asunto
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param strFolio
	 *            Folio del Asunto
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaAsunto(String idUsuario,
			String strFolio) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date f = new Date();
		String FechaCreacion = sdf.format(f);
		int r = 0;
		try {
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '"
					+ SQL_ALTA_ASUNTO + ". Folio: " + strFolio + "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Asunto
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param strFolio
	 *            Folio del Asunto
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioAsunto(String idUsuario,
			String strFolio) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date f = new Date();
		String FechaCreacion = sdf.format(f);
		int r = 0;
		try {
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '"
					+ SQL_CAMBIO_ASUNTO + ". Folio: " + strFolio + "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Turnado de Instrucciones
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param strFolio
	 *            Folio del Asunto
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoTurnar(String idUsuario, String strFolio) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date f = new Date();
		String FechaCreacion = sdf.format(f);
		int r = 0;
		try {
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + SQL_TURNAR
					+ ". Se turnaron instrucciones para el Asunto con Folio: "
					+ strFolio + "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoTurnar:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Creación de Ruta de atención
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoRutaAuto(String idUsuario) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date f = new Date();
		String FechaCreacion = sdf.format(f);
		int r = 0;
		try {
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '"
					+ SQL_RUTA_AUTO + "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoRutaAuto:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Verifica si un Usuario tiene registros en la Bitacora
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean getExisteBitacoraUsr(String strIdUsuario) {
		try {
			String strsql = SQL_EXISTE_BIT + strIdUsuario;
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;

			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExisteBitacoraUsr
			// strIdUsuario:"+strIdUsuario+"\n"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa los registros de la Bitacora para una Usuario. Ordenados y
	 * delimitados por fechas
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param orden
	 *            Campo por el cual se ordenan los registros
	 * @param tipo
	 *            Ordenamiento Ascendente o Descendente
	 * @param fechaIni
	 *            Fecha del Evento Inicial
	 * @param fechaFin
	 *            Fecha del Evento Final
	 * @param strDetalleEvento
	 *            Detalle del Evento
	 * 
	 * @return Regresa los registros correspondiente
	 */
	public static String[][] getBitacoraUsuario(String strIdUsuario,
			String orden, String tipo, String fechaIni, String fechaFin,
			String strDetalleEvento) {
		try {
			String strsql = "";
			strsql = SQL_SELECT_USR + strIdUsuario + " ";

			if (fechaIni != null && fechaIni.length() > 0) {
				strsql += "AND BIT_FECHA_EVENTO >= TO_DATE('" + fechaIni
						+ " 00:00:00', 'DD/MM/YYYY HH24:MI:SS') ";
			}
			if (fechaFin != null && fechaFin.length() > 0) {
				strsql += "AND BIT_FECHA_EVENTO <= TO_DATE('" + fechaFin
						+ " 23:59:59', 'DD/MM/YYYY HH24:MI:SS') ";
			}
			if (strDetalleEvento != null && strDetalleEvento.length() > 0) {
				strsql += "AND ( ";

				StringTokenizer strToken = new StringTokenizer(
						strDetalleEvento, ",");
				while (strToken.hasMoreTokens()) {
					String aux = strToken.nextToken().trim();
					if (aux.charAt(0) == '\"'
							&& aux.charAt(aux.length() - 1) == '\"') {
						aux = "%" + aux.substring(1, aux.length() - 1) + "%";
					} else {
						aux = "%" + aux + "%";
					}
					strsql += "LOWER(TRANSLATE(BIT_EVENTO,'áéíóúÁÉÍÓÚ','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"
							+ aux + "','áéíóúÁÉÍÓÚš','aeiouAEIOU')) ";
					if (strToken.countTokens() != 0) {
						strsql += "AND ";
					}
				}
				strsql += " ) ";
			}
			strsql += " " + SQL_ORDER_BY + tipo + " " + orden + ", 4 DESC ";
			// //System.err.println("Bitacora: " + strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getBitacoraUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Regresa los registros por ID de usuario
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * 
	 * @return Regresa los registros correspondiente
	 */
	public static String[][] getBitacoraUsuarioNombre(String strIdUsuario) {
		try {
			String strsql = SQL_UNIC_USR + strIdUsuario;
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getBitacoraUsuarioNombre:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Destinatario Externo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre del Destinatario
	 * @param idArea
	 *            ID de la UA
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaDestExt(String idUsuario,
			String nombre, String idArea) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_USUARIO FROM SD_DESTINATARIO WHERE LOWER(DES_NOMBRE)=LOWER('"
					+ nombre
					+ "') AND DES_AREA="
					+ idArea
					+ " AND DES_ESTATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = DES_ALTA + ". Nombre: " + nombre + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaDestExt:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Destinatario Externo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre del Destinatario
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID del Destinatario
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioDestExt(String idUsuario,
			String nombre, String idArea, String idRegistro) {
		int r = 0;
		try {
			String descripcion = DES_CAMBIO + ". Nombre: " + nombre + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioDestExt:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Destinatario Externo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre del Destinatario
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID del Destinatario
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarDestExt(String idUsuario,
			String nombre, String idArea, String idRegistro) {
		int r = 0;
		try {
			String descripcion = DES_BAJA + ". Nombre: " + nombre + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarDestExt:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Entidad
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre de la Entidad
	 * @param idArea
	 *            ID de la UA
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaEntidad(String idUsuario,
			String nombre, String idArea) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_ENTIDAD FROM SD_ENTIDAD WHERE LOWER(ENT_NOMBRE)=LOWER('"
					+ nombre
					+ "') AND ENT_AREA="
					+ idArea
					+ " AND ENT_ESTATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = ENT_ALTA + ". Nombre: " + nombre + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaEntidad:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Entidad
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre de la Entidad
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID de la Entidad
	 * @param datos
	 *            Datos previos del registro
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioEntidad(String idUsuario,
			String nombre, String idArea, String idRegistro, String[][] datos) {
		int r = 0;
		try {
			String descripcion = ENT_CAMBIO + ". " + "ID: " + idRegistro
					+ "<BR>" + "UA: " + ActualizaArea.NombreArea(datos[0][1])
					+ "<BR>" + "Entidad: " + datos[0][0] + "<BR>"
					+ "Clasificación: " + datos[0][2] + "<BR>" + "Dirección: "
					+ datos[0][3] + "<BR>" + "Teléfono: " + datos[0][4] + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioEntidad:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Entidad
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre de la Entidad
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID de la Entidad
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarEntidad(String idUsuario,
			String nombre, String idArea, String idRegistro) {
		int r = 0;
		try {
			String descripcion = ENT_BAJA + ". Nombre: " + nombre + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarEntidad:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Remitente
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre del Remitente
	 * @param idArea
	 *            ID de la UA
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaRemitente(String idUsuario,
			String nombre, String idEntidad) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_REMITENTE FROM SD_REMITENTE WHERE LOWER(RMT_NOMBRE)=LOWER('"
					+ nombre
					+ "') AND RMT_ENTIDAD="
					+ idEntidad
					+ " AND RMT_ESTATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = RMT_ALTA + ". Nombre: " + nombre
					+ ", Entidad: "
					+ ActualizaEntidad.getNombreEntidad(idEntidad) + ", ID: "
					+ idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaRemitente:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Remitente
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre del Remitente
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID del Remitente
	 * @param datos
	 *            Datos previos del registro
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioRemitente(String idUsuario,
			String nombre, String idEntidad, String idRegistro,
			String datos[][]) {
		int r = 0;
		try {
			String descripcion = RMT_CAMBIO + ".<BR>" + "ID: " + idRegistro
					+ "<BR>" + "UA: " + ActualizaArea.NombreArea(datos[0][1])
					+ "<BR>" + "Nombre: " + datos[0][0] + "<BR>" + "Cargo: "
					+ datos[0][2] + "<BR>" + "Entidad: "
					+ ActualizaEntidad.getNombreEntidad(datos[0][3]) + "<BR>"
					+ "Dirección: " + datos[0][6] + "<BR>" + "Teléfono: "
					+ datos[0][4] + "<BR>" + "Fax: " + datos[0][7] + "<BR>"
					+ "Correo Electrónico: " + datos[0][5] + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioRemitente:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Remitente
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre del Remitente
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID del Remitente
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarRemitente(String idUsuario,
			String nombre, String idEntidad, String idRegistro) {
		int r = 0;
		try {
			String descripcion = RMT_BAJA + ". Nombre: " + nombre
					+ ", Entidad: "
					+ ActualizaEntidad.getNombreEntidad(idEntidad) + ", ID: "
					+ idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoEliminarRemitente="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarRemitente:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Tramite
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Nombre del Tramite
	 * @param idArea
	 *            ID de la UA
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaTramite(String idUsuario,
			String clave, String idArea) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_TRAMITE FROM SD_TRAMITE WHERE LOWER(TRA_CLAVE)=LOWER('"
					+ clave
					+ "') AND TRA_AREA="
					+ idArea
					+ " AND TRA_ESTATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = TRA_ALTA + ". Clave: " + clave + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Tramite
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Nombre del Tramite
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID del Tramite
	 * @param datos
	 *            Datos previos del registro
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioTramite(String idUsuario,
			String clave, String idArea, String idRegistro, String datos[][]) {
		int r = 0;
		try {
			String descripcion = TRA_CAMBIO + ".<BR>" + "ID: " + idRegistro
					+ "<BR>" + "UA: " + ActualizaArea.NombreArea(datos[0][1])
					+ "<BR>" + "Nombre: " + datos[0][2] + "<BR>" + "Clave: "
					+ datos[0][3] + "<BR>" + "Descripción: " + datos[0][4]
					+ "<BR>" + "Tiempo: " + datos[0][5] + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoCambioTramite="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Tramite
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Nombre del Tramite
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID del Tramite
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarTramite(String idUsuario,
			String clave, String idArea, String idRegistro) {
		int r = 0;
		try {
			String descripcion = TRA_BAJA + ". Clave: " + clave + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Tipo de Documento
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Nombre del Tipo de Documento
	 * @param idArea
	 *            ID de la UA
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaTipoDoc(String idUsuario,
			String clave, String idArea) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_TIPO_DOCTO FROM SD_TIPO_DOCUMENTO WHERE LOWER(TIP_DOCTO_CLAVE_DOCTO)=LOWER('"
					+ clave
					+ "') AND TIP_DOCTO_AREA="
					+ idArea
					+ " AND TIP_DOCTO_ESTATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = TDO_ALTA + ". Clave: " + clave + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Tipo de Documento
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Nombre del Tipo de Documento
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID del Tipo de Documento
	 * @param datos
	 *            Datos previos del registro
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioTipoDoc(String idUsuario,
			String clave, String idArea, String idRegistro, String datos[][]) {
		int r = 0;
		try {
			String descripcion = TDO_CAMBIO + ".<BR>" + "ID: " + idRegistro
					+ "<BR>" + "UA: " + ActualizaArea.NombreArea(datos[0][1])
					+ "<BR>" + "Tipo de Docto: " + datos[0][0] + "<BR>"
					+ "Clave: " + datos[0][2] + "<BR>" + "Consecutivo: "
					+ datos[0][3] + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioTipoDoc:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Tipo de Documento
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Nombre del Tipo de Documento
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID del Tipo de Documento
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarTipoDoc(String idUsuario,
			String clave, String idArea, String idRegistro) {
		int r = 0;
		try {
			String descripcion = TDO_BAJA + ". Clave: " + clave + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarTipoDoc:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Tipo de Asunto
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre del Tipo de Asunto
	 * @param idArea
	 *            ID de la UA
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaTipoAsu(String idUsuario,
			String nombre, String idArea) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_TIPO_ASUNTO FROM SD_TIPO_ASUNTO WHERE LOWER(TIP_ASU_NOMBRE)=LOWER('"
					+ nombre
					+ "') AND TIP_ASU_AREA="
					+ idArea
					+ " AND TIP_ASU_ESTATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = TAS_ALTA + ". Nombre: " + nombre + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaTipoAsu:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Tipo de Asunto
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre del Tipo de Asunto
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID del Tipo de Asunto
	 * @param datos
	 *            Datos anteriores del registro
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioTipoAsu(String idUsuario,
			String nombre, String idArea, String idRegistro, String datos[][]) {
		int r = 0;
		try {
			String descripcion = TAS_CAMBIO + ".<BR>" + "ID: " + idRegistro
					+ "<BR>" + "UA: " + ActualizaArea.NombreArea(datos[0][0])
					+ "<BR>" + "Tipo de Asunto: " + datos[0][1] + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.err.println("---->"+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioTipoAsu:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Tipo de Asunto
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre del Tipo de Asunto
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID del Tipo de Asunto
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarTipoAsu(String idUsuario,
			String nombre, String idArea, String idRegistro) {
		int r = 0;
		try {
			String descripcion = TAS_BAJA + ". Nombre: " + nombre + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarTipoAsu:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Prioridades
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre de la Prioridad
	 * @param idArea
	 *            ID de la UA
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaPrioridades(String idUsuario,
			String nombre, String idArea) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_PRIORIDADES FROM SD_PRIORIDAD WHERE LOWER(PRI_NOMBRE)=LOWER('"
					+ nombre
					+ "') AND PRI_AREA="
					+ idArea
					+ " AND PRI_ESTATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = PRI_ALTA + ". Nombre: " + nombre + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaPrioridades:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Prioridades
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre de la Prioridad
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID de la Prioridad
	 * @param datos
	 *            Datos anteriores del registro
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioPrioridades(String idUsuario,
			String nombre, String idArea, String idRegistro, String datos[][]) {
		int r = 0;
		try {
			String descripcion = PRI_CAMBIO + ".<BR>" + "ID: " + idRegistro
					+ "<BR>" + "UA: " + ActualizaArea.NombreArea(datos[0][1])
					+ "<BR>" + "Prioridad: " + datos[0][0] + "<BR>"
					+ "No. Hex: " + datos[0][2] + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioPrioridades:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Prioridades
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre de la Prioridad
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID de la Prioridad
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarPrioridades(String idUsuario,
			String nombre, String idArea, String idRegistro) {
		int r = 0;
		try {
			String descripcion = PRI_BAJA + ". Nombre: " + nombre + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarPrioridades:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Folios
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre del Folio
	 * @param idArea
	 *            ID de la UA
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaFolio(String idUsuario,
			String nombre, String idArea) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_FOLIO FROM SD_FOLIO WHERE LOWER(FOL_CLAVE)=LOWER('"
					+ nombre
					+ "') AND FOL_AREA="
					+ idArea
					+ " AND FOL_ESTATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = FOL_ALTA + ". Clave: " + nombre + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaFolio:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Folios
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre del Folio
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID del Folio
	 * @param datos
	 *            Datos previos del registro
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioFolio(String idUsuario,
			String nombre, String idArea, String idRegistro, String datos[][]) {
		int r = 0;
		try {
			String descripcion = FOL_CAMBIO + ".<BR>" + "ID: " + idRegistro
					+ "<BR>" + "UA: " + ActualizaArea.NombreArea(datos[0][0])
					+ "<BR>" + "Tipo de Folio: "
					+ (datos[0][1].equals("1") ? "Recepción" : "Turnado")
					+ "<BR>" + "Clave: " + datos[0][2] + "<BR>" + "Orden: "
					+ datos[0][4] + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioFolio:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Folios
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre del Folio
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID del Folio
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarFolio(String idUsuario,
			String nombre, String idArea, String idRegistro) {
		int r = 0;
		try {
			String descripcion = FOL_BAJA + ". Clave: " + nombre + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarFolio:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Pasos
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param secuencia
	 *            Nombre del Paso
	 * @param idArea
	 *            ID de la UA
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaPaso(String idUsuario,
			String secuencia, String idTDoc) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_PASOS FROM SD_PASO WHERE LOWER(PAS_SECUENCIA)=LOWER('"
					+ secuencia
					+ "') AND PAS_TIPO_DOCTO="
					+ idTDoc
					+ " AND PAS_ESTATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = PAS_ALTA + ". Secuencia: " + secuencia
					+ ", Tipo de Doc: "
					+ ActualizaTipo_Doc.getNombreTipoDocto(idTDoc) + ", ID: "
					+ idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaPaso:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Pasos
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param secuencia
	 *            Nombre del Paso
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID del Paso
	 * @param datos
	 *            Datos previos del registro
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioPaso(String idUsuario,
			String secuencia, String idTDoc, String idRegistro,
			String datos[][]) {
		int r = 0;
		try {
			String descripcion = PAS_CAMBIO + ".<BR>" + "ID: " + idRegistro
					+ "<BR>" + "UA: " + ActualizaArea.NombreArea(datos[0][5])
					+ "<BR>" + "Tipo de Docto: "
					+ ActualizaTipo_Doc.getNombreTipoDocto(datos[0][0])
					+ "<BR>" + "Secuencia: " + datos[0][1] + "<BR>"
					+ "Descripción: " + datos[0][2] + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioPaso:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Pasos
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param secuencia
	 *            Nombre del Paso
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID del Paso
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarPaso(String idUsuario,
			String secuencia, String idTDoc, String idRegistro) {
		int r = 0;
		try {
			String descripcion = PAS_BAJA + ". Secuencia: " + secuencia
					+ ", Tipo de Doc: "
					+ ActualizaTipo_Doc.getNombreTipoDocto(idTDoc) + ", ID: "
					+ idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarPaso:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Ubicación
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param ubicacion
	 *            Nombre de la Ubicación
	 * @param idArea
	 *            ID de la UA
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaUbicacion(String idUsuario,
			String ubicacion, String idArea) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_UBICACION FROM SD_UBICACION WHERE LOWER(UNI_DESCRIPCION)=LOWER('"
					+ ubicacion
					+ "') AND UBI_AREA="
					+ idArea
					+ " AND UBI_ESTATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = UBI_ALTA + ". Ubicación: " + ubicacion
					+ ", UA: " + ActualizaArea.NombreArea(idArea) + ", ID: "
					+ idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaUbicacion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Ubicación
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param ubicacion
	 *            Nombre de la Ubicación
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID de la Ubicación
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioUbicacion(String idUsuario,
			String ubicacion, String idArea, String idRegistro) {
		int r = 0;
		try {
			String descripcion = UBI_CAMBIO + ". Ubicación: " + ubicacion
					+ ", UA: " + ActualizaArea.NombreArea(idArea) + ", ID: "
					+ idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioUbicacion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Ubicación
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param ubicacion
	 *            Nombre de la Ubicación
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID de la Ubicación
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarUbicacion(String idUsuario,
			String ubicacion, String idArea, String idRegistro) {
		int r = 0;
		try {
			String descripcion = UBI_BAJA + ". Ubicación: " + ubicacion
					+ ", UA: " + ActualizaArea.NombreArea(idArea) + ", ID: "
					+ idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarUbicacion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Ruta Automática
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param rutaDesc
	 *            Nombre de la Ruta Automática
	 * @param idArea
	 *            ID de la UA
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaRuta(String idUsuario,
			String rutaDesc, String idArea) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_RUTA_AUTOMATICA FROM SD_RUTA_AUTOMATICA WHERE LOWER(RUT_AUT_DESCRIPCION)=LOWER('"
					+ rutaDesc
					+ "') AND RUT_AUT_AREA="
					+ idArea
					+ " AND RUT_AUT_ESTATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = RAT_ALTA + ". Descripción: " + rutaDesc
					+ ", UA: " + ActualizaArea.NombreArea(idArea) + ", ID: "
					+ idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaRuta:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Ruta Automática
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param rutaDesc
	 *            Nombre de la Ruta Automática
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID de la Ruta Automática
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioRuta(String idUsuario,
			String rutaDesc, String idArea, String idRegistro) {
		int r = 0;
		try {
			String descripcion = RAT_CAMBIO + ". Descripción: " + rutaDesc
					+ ", UA: " + ActualizaArea.NombreArea(idArea) + ", ID: "
					+ idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioRuta:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Ruta Automática
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param rutaDesc
	 *            Nombre de la Ruta Automática
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID de la Ruta Automática
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarRuta(String idUsuario,
			String rutaDesc, String idArea, String idRegistro) {
		int r = 0;
		try {
			String descripcion = RAT_BAJA + ". Descripción: " + rutaDesc
					+ ", UA: " + ActualizaArea.NombreArea(idArea) + ", ID: "
					+ idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarRuta:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de instrucción
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre de la instrucción
	 * @param idArea
	 *            ID de la UA
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaInstruccion(String idUsuario,
			String nombre, String idArea) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_INSTRUCCION FROM SD_INSTRUCCION WHERE LOWER(INS_NOMBRE)=LOWER('"
					+ nombre
					+ "') AND INS_AREA="
					+ idArea
					+ " AND INS_ESTATUS1=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = INS_ALTA + ". Nombre: " + nombre + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de instrucción
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre de la instrucción
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID de la instrucción
	 * @param datos
	 *            Datos previos del registro
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioInstruccion(String idUsuario,
			String nombre, String idArea, String idRegistro, String datos[][]) {
		int r = 0;
		try {
			String descripcion = INS_CAMBIO + ".<BR>" + "ID: " + idRegistro
					+ "<BR>" + "UA: " + ActualizaArea.NombreArea(datos[0][0])
					+ "<BR>" + "Nombre: " + datos[0][1] + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de instrucción
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre de la instrucción
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID de la instrucción
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarInstruccion(String idUsuario,
			String nombre, String idArea, String idRegistro) {
		int r = 0;
		try {
			String descripcion = INS_BAJA + ". Nombre: " + nombre + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Razón de Rechazo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre de la Razón de Rechazo
	 * @param idArea
	 *            ID de la UA
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaRazon(String idUsuario,
			String nombre, String idArea) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_RAZON_RECH FROM SD_RAZON_RECHAZO WHERE LOWER(RAZ_RECH_DESCRIPCION)=LOWER('"
					+ nombre
					+ "') AND RAZ_RECH_AREA="
					+ idArea
					+ " AND RAZ_RECH_ESTATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = REC_ALTA + ". Nombre: " + nombre + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaRazon:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Razón de Rechazo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre de la Razón de Rechazo
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID de la Razón de Rechazo
	 * @param datos
	 *            Datos previos del registro
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioRazon(String idUsuario,
			String nombre, String idArea, String idRegistro, String datos[][]) {
		int r = 0;
		try {
			String descripcion = REC_CAMBIO + ".<BR>" + "ID: " + idRegistro
					+ "<BR>" + "UA: " + ActualizaArea.NombreArea(datos[0][0])
					+ "<BR>" + "Descripción: " + datos[0][1] + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioRazon:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Razón de Rechazo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre de la Razón de Rechazo
	 * @param idArea
	 *            ID de la UA
	 * @param idRegistro
	 *            ID de la Razón de Rechazo
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarRazon(String idUsuario,
			String nombre, String idArea, String idRegistro) {
		int r = 0;
		try {
			String descripcion = REC_BAJA + ". Nombre: " + nombre + ", UA: "
					+ ActualizaArea.NombreArea(idArea) + ", ID: " + idRegistro
					+ "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarRazon:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Día Festivo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param fecha
	 *            Día Festivo
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaDia(String idUsuario, String fecha) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_DIA_FESTIVO FROM SD_DIA_FESTIVO WHERE TO_CHAR(DIA_FEST_FECHA, 'DD/MM/YYYY') = '"
					+ fecha + "' AND DIA_FEST_ESTATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = DIA_ALTA + ". Fecha: " + fecha + ", ID: "
					+ idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaDia:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Día Festivo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param fecha
	 *            Día Festivo
	 * @param idRegistro
	 *            ID del Día Festivo
	 * @param datos
	 *            Datos previos del registro
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioDia(String idUsuario,
			String fecha, String idRegistro, String datos[][]) {
		int r = 0;
		try {
			String descripcion = DIA_CAMBIO + ". " + "ID: " + idRegistro
					+ "<BR>" + "Fecha: " + datos[0][1] + "<BR>"
					+ "Descripción: " + datos[0][2] + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioDia:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Día Festivo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param fecha
	 *            Día Festivo
	 * @param idRegistro
	 *            ID del Día Festivo
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarDia(String idUsuario,
			String fecha, String idRegistro) {
		int r = 0;
		try {
			String descripcion = DIA_BAJA + ". Fecha: " + fecha + ", ID: "
					+ idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarDia:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Regresa el resultado del Query contenido en sql
	 * 
	 * @param sql
	 *            Query a ejecutar
	 * 
	 * @return Regresa los registros correspondientes
	 */
	public static String getIdRegistroAltas(String sql) {
		try {
			return ConexionDS.ejecutarSQL(sql)[0][0];
		} catch (SQLException sqle) {
			// System.out.println("getIdRegistroAltas:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Puesto
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param responsable
	 *            Nombre del Responsable del Puesto
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaPuesto(String idUsuario,
			String responsable) {
		int r = 0;
		try {
			String sqlIdAreas = "SELECT ID_USUARIO FROM SD_USUARIO WHERE LOWER(USU_CARGO)=LOWER('"
					+ responsable + "') AND USU_ESTATUS=1";
			String idPuesto = getIdRegistroAltas(sqlIdAreas);
			String descripcion = USU_ALTA + ". Responsable: " + responsable
					+ ", ID: " + idPuesto + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Puesto
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param responsable
	 *            Nombre del Responsable del Puesto
	 * @param conn
	 *            Conexion a la base de datos
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaPuesto(int idUsuario,
			PuestoForm pf, Connection conn) {

		String descripcion = USU_ALTA + ". Responsable: " + pf.getResponsable()
				+ ", ID: " + pf.getPuesto() + "";
		String sql = "INSERT INTO SD_BITACORA1 (ID_BITACORA, BIT_USUARIO, BIT_FECHA_EVENTO, "
				+ "BIT_EVENTO) VALUES (SD_BITACORA1_SEQ.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idUsuario);
			pstmt
					.setTimestamp(2, new Timestamp(new java.util.Date()
							.getTime()));
			pstmt.setString(3, descripcion);
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConexionDS.endConnection(null, pstmt, null);
		}
		return false;
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Puesto
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre del Responsable del Puesto
	 * @param idPuesto
	 *            ID del Puesto
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean deleteEventoPuesto(String idUsuario, String idPuesto,
			String nombre) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date f = new Date();
		String FechaCreacion = sdf.format(f);
		int r = 0;
		try {
			String descripcion = USU_BAJA + ". Responsable: " + nombre
					+ ", ID: " + idPuesto;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("deleteEventoPuesto:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Puesto
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param nombre
	 *            Nombre del Responsable del Puesto
	 * @param idPuesto
	 *            ID del Puesto
	 * @param datos
	 *            Datos previos del registro
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioPuesto(String idUsuario,
			String idPuesto, String nombre, String datos[][]) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date f = new Date();
		String FechaCreacion = sdf.format(f);

		String strArrRoles[][] = ActualizaRol.getRoles(idPuesto);
		String strRoles = "";
		for (int i = 0; i < strArrRoles.length; i++) {
			strRoles += strArrRoles[i][1] + ", ";
		}

		String strConfigCorreo[][] = ActualizaParamCorreo
				.getParamCorreo(idPuesto);
		String strCorreo = "";
		for (int i = 0; i < strConfigCorreo.length; i++) {
			strCorreo += strConfigCorreo[i][1] + ", ";
		}

		int r = 0;
		try {
			String descripcion = USU_CAMBIO
					+ ".<BR>"
					+ "ID: "
					+ idPuesto
					+ "<BR>"
					+ "Usuario: "
					+ datos[0][13]
					+ "<BR>"
					+ "UA: "
					+ ActualizaArea.NombreArea(datos[0][1])
					+ "<BR>"
					+ "Puesto: "
					+ datos[0][0]
					+ "<BR>"
					+ "Responsable: "
					+ datos[0][2]
					+ "<BR>"
					+ "Correo Electrónico: "
					+ datos[0][3]
					+ "<BR>"
					+ "Telefono: "
					+ datos[0][4]
					+ "<BR>"
					+ "Consecutivo: "
					+ datos[0][5]
					+ "<BR>"
					+ "Jefe: "
					+ ((datos[0][6].equals("") || datos[0][6].equals("-1")) ? "Sin Jefe Asignado"
							: ActualizaUsuario.NombrePuesto(datos[0][6])
									+ "/"
									+ ActualizaUsuario
											.NombreUsuario(datos[0][6]))
					+ "<BR>"
					+ "Asistente: "
					+ ((datos[0][7].equals("") || datos[0][7].equals("-1")) ? "Sin Asistente"
							: ActualizaUsuario.NombrePuesto(datos[0][7])
									+ "/"
									+ ActualizaUsuario
											.NombreUsuario(datos[0][6]))
					+ "<BR>" + "Usuario Activo: "
					+ (datos[0][12].equals("1") ? "Activo" : "Suspendido")
					+ "<BR>" + "Atencion Destinatario Ext: "
					+ (datos[0][16].equals("1") ? "Si" : "No") + "<BR>"
					+ "Roles: " + strRoles + "<BR>"
					+ "Config Correo de Salida: " + strCorreo + "<BR>"
					+ "Recibir Notificaciones: "
					+ (datos[0][15].equals("0") ? "Si" : "No") + "<BR>"
					+ "Catalogo Archivado: "
					+ (datos[0][14].equals("1") ? "Si" : "No") + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.err.println("sql-->"+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioPuesto:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/*
	 * ===========================================================================================
	 * Bitacora de Archivados
	 * ===========================================================================================
	 */

	/**
	 * Inserta en la bitacora un Evento de Alta de Fondo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del Fondo
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaFondo(String idUsuario,
			String clave, String nombre, String desc, String sisi) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_FONDO FROM SD_FONDO_ARCH WHERE FON_CLAVE='"
					+ clave + "' AND FON_STATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = FONDO_ALTA + ".<br> Clave: " + clave
					+ ",<br> Nombre: " + nombre + ",<br> Descripción: " + desc
					+ ",<br> Años Consulta SISI: " + sisi + ",<br> ID: "
					+ idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaFondo:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Fondo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del Fondo
	 * @param idRegistro
	 *            ID del Fondo
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioFondo(String idUsuario,
			String clave, String idRegistro, String[][] datosAnt) {
		int r = 0;
		String estatus = "";
		if (datosAnt[0][8].equals("1"))
			estatus = "Activo";
		else
			estatus = "Inactivo";
		try {
			String descripcion = FONDO_CAMBIO + ". <br> " + "ID: " + idRegistro
					+ " <br> " + "Clave: " + datosAnt[0][4] + ", <br> "
					+ "Nombre: " + datosAnt[0][0] + ", <br> " + "Descripción: "
					+ datosAnt[0][1] + ", <br> " + "Años Consulta SISI: "
					+ datosAnt[0][5] + ", <br> " + "" + estatus + " ";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioFondo:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Fondo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del Fondo
	 * @param idRegistro
	 *            ID del Fondo
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarFondo(String idUsuario,
			String clave, String idRegistro, String nombre, String desc) {
		int r = 0;
		try {
			String descripcion = FONDO_BAJA + ". Clave: " + clave
					+ ", Nombre: " + nombre + ", Descripción: " + desc
					+ ", ID: " + idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarFondo:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Sub Fondo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del Sub Fondo
	 * @param fondo
	 *            Fondo Asociado
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaSubFondo(String idUsuario,
			String clave, String fondo) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_SUBFONDO FROM SD_SUBFONDOARCH WHERE SUBF_CLAVE='"
					+ clave
					+ "' AND SUBF_FONDO='"
					+ fondo
					+ "' AND SUBF_STATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = SUBFON_ALTA + ". Clave: " + clave
					+ ", Fondo: " + ActualizaExpArchivado.getFondo(fondo)[0][0]
					+ ", ID: " + idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaSubFondo:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Sub Fondo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del Sub Fondo
	 * @param fondo
	 *            Fondo Asociado
	 * @param idRegistro
	 *            ID del Sub Fondo
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioSubFondo(String idUsuario,
			String clave, String fondo, String idRegistro, String[][] datosAnt) {
		int r = 0;
		String estatus = "";
		if (datosAnt[0][8].equals("1"))
			estatus = "Activo";
		else
			estatus = "Inactivo";
		try {
			String descripcion = SUBFON_CAMBIO + ". <br> " + "ID: "
					+ idRegistro + " <br> " + "Fondo: "
					+ ActualizaExpArchivado.getFondo(fondo)[0][0] + ", <br> "
					+ "Clave: " + datosAnt[0][5] + ", <br> " + "Nombre: "
					+ datosAnt[0][0] + " <br> " + "Descripción: "
					+ datosAnt[0][1] + " <br> " + "" + estatus + "  ";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioSubFondo:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Sub Fondo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del Sub Fondo
	 * @param fondo
	 *            Fondo Asociado
	 * @param idRegistro
	 *            ID del Sub Fondo
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarSubFondo(String idUsuario,
			String clave, String fondo, String idRegistro) {
		int r = 0;
		try {
			String descripcion = SUBFON_BAJA + ". Clave: " + clave
					+ ", Fondo: " + ActualizaExpArchivado.getFondo(fondo)[0][0]
					+ ", ID: " + idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarSubFondo:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Sección
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Sección
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaSeccionArch(String idUsuario,
			String clave, String fondo, String subfondo, String nombre,
			String desc) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_SECCION FROM SD_SECCION_ARCH WHERE SEC_CLAVE='"
					+ clave + "' AND SEC_STATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = SECC_ALTA + ". <br> " + "Fondo: "
					+ ActualizaExpArchivado.getFondo(fondo)[0][0] + ", <br> "
					+ "SubFondo: "
					+ ActualizaExpArchivado.getSubfondoA(subfondo)[0][0]
					+ ", <br> " + "Clave: " + clave + ", <br> " + "Nombre: "
					+ nombre + ", <br> " + "Descripción: " + desc + ", <br> "
					+ "ID: " + idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaSeccionArch:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Sección
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Sección
	 * @param idRegistro
	 *            ID de la Sección
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioSeccionArch(String idUsuario,
			String clave, String idRegistro, String[][] datosAnt) {
		int r = 0;
		try {
			String descripcion = SECC_CAMBIO + ". <br> " + "ID: " + idRegistro
					+ " <br> " + "Fondo: "
					+ ActualizaExpArchivado.getFondo(datosAnt[0][8])[0][0]
					+ ", <br> " + "SubFondo: "
					+ ActualizaExpArchivado.getSubfondoA(datosAnt[0][9])[0][0]
					+ ", <br> " + "Clave: " + datosAnt[0][4] + ", <br> "
					+ "Nombre: " + datosAnt[0][0] + ", <br> " + "Descripción: "
					+ datosAnt[0][1] + ", <br> ";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioSeccionArch:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Sección
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Sección
	 * @param idRegistro
	 *            ID de la Sección
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarSeccionArch(String idUsuario,
			String clave, String idRegistro, String nombre, String desc) {
		int r = 0;
		try {
			String descripcion = SECC_BAJA + ". Clave: " + clave + ", Nombre: "
					+ nombre + ", Descripción: " + desc + ",ID: " + idRegistro
					+ "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarSeccionArch:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Serie
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Serie
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaSerie(String idUsuario, String clave) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_SERIE FROM SD_SERIE WHERE SER_CLAVE='"
					+ clave + "' AND SER_STATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = SERIE_ALTA + ". Clave: " + clave + ", ID: "
					+ idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaSerie:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Serie
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Serie
	 * @param idRegistro
	 *            ID de la Serie
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioSerie(String idUsuario,
			String clave, String idRegistro) {
		int r = 0;
		try {
			String descripcion = SERIE_CAMBIO + ". Clave: " + clave + ", ID: "
					+ idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioSerie:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Serie
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Serie
	 * @param idRegistro
	 *            ID de la Serie
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarSerie(String idUsuario,
			String clave, String idRegistro) {
		int r = 0;
		try {
			String descripcion = SECC_BAJA + ". Clave: " + clave + ", ID: "
					+ idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarSerie:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de SubSerie
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la SubSerie
	 * @param serie
	 *            Serie asociada
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaSubSerie(String idUsuario,
			String clave, String serie) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_SUBSERIE FROM SD_SUBSERIE WHERE SUBS_CLAVE='"
					+ clave
					+ "' AND SUBS_SERIE='"
					+ serie
					+ "' AND SUBS_STATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = SUBSE_ALTA + ". Clave: " + clave + ", Serie: "
					+ ActualizaExpArchivado.getSerie(serie)[0][0] + ", ID: "
					+ idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaSubSerie:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de SubSerie
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la SubSerie
	 * @param serie
	 *            Serie asociada
	 * @param idRegistro
	 *            ID de la SubSerie
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioSubSerie(String idUsuario,
			String clave, String serie, String idRegistro) {
		int r = 0;
		try {
			String descripcion = SUBSE_CAMBIO + ". Clave: " + clave
					+ ", Serie: " + ActualizaExpArchivado.getSerie(serie)[0][0]
					+ ", ID: " + idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioSubSerie:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de SubSerie
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la SubSerie
	 * @param serie
	 *            Serie asociada
	 * @param idRegistro
	 *            ID de la SubSerie
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarSubSerie(String idUsuario,
			String clave, String serie, String idRegistro) {
		int r = 0;
		try {
			String descripcion = SUBSE_BAJA + ". Clave: " + clave + ", Serie: "
					+ ActualizaExpArchivado.getSerie(serie)[0][0] + ", ID: "
					+ idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarSubSerie:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Combinación
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Combinación
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaCombinacion(String idUsuario,
			String clave) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_COMBINACION FROM SD_COMBINACION WHERE COM_CLAVE='"
					+ clave + "' AND COM_STATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = ESTR_ALTA + ". Clave: " + clave + ", ID: "
					+ idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaCombinacion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Combinación
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Combinación
	 * @param idRegistro
	 *            ID de la Combinación
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioCombinacion(String idUsuario,
			String clave, String idRegistro) {
		int r = 0;
		try {
			String descripcion = ESTR_CAMBIO + ". Clave: " + clave + ", ID: "
					+ idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioCombinacion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Combinación
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Combinación
	 * @param idRegistro
	 *            ID de la Combinación
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarCombinacion(String idUsuario,
			String clave, String idRegistro) {
		int r = 0;
		try {
			String descripcion = ESTR_BAJA + ". Clave: " + clave + ", ID: "
					+ idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarCombinacion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta del Valor
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del Valor
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaValore(String idUsuario,
			String clave, String nombre, String desc) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_VALOR FROM SD_VALOR WHERE V_CLAVE='"
					+ clave + "' AND V_STATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = VALOR_ALTA + ". Clave: " + clave
					+ ", Nombre: " + nombre + ", Descripción: " + desc
					+ ", ID: " + idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaValore:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición del Valor
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del Valor
	 * @param idRegistro
	 *            ID del Valor
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioValore(String idUsuario,
			String clave, String idRegistro, String[][] datosPrevios) {
		int r = 0;
		String estatus = "";
		if (datosPrevios[0][7].equals("1"))
			estatus = "Activo";
		else
			estatus = "Inactivo";
		try {
			String descripcion = VALOR_CAMBIO + ". " + "ID: " + idRegistro
					+ " <BR>" + "Clave: " + datosPrevios[0][4] + ", <BR>"
					+ "Nombre: " + datosPrevios[0][0] + ", <BR>"
					+ "Descripción: " + datosPrevios[0][1] + ", <BR> " + ""
					+ estatus + " ";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";

			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioValore:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja del Valor
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del Valor
	 * @param idRegistro
	 *            ID del Valor
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarValore(String idUsuario,
			String clave, String idRegistro, String nombre, String desc) {
		int r = 0;
		try {
			String descripcion = VALOR_BAJA + ". Clave: " + clave
					+ ", Nombre: " + nombre + ", Descripción: " + desc
					+ ", ID: " + idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarValore:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Valoración
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Valoración
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaValoracion(String idUsuario,
			String clave, String nombre, String desc) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_VALORACION FROM SD_VALORACION WHERE VAL_CLAVE='"
					+ clave + "' AND VAL_STATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = VCION_ALTA + ". Clave: " + clave
					+ ", Nombre: " + nombre + ", Descripción: " + desc
					+ ", ID: " + idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.err.println("sql--->"+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaValoracion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Valoración
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Valoración
	 * @param idRegistro
	 *            ID de la Valoración
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioValoracion(String idUsuario,
			String clave, String idRegistro, String[][] datosPrevios) {
		int r = 0;
		String estatus = "";
		if (datosPrevios[0][10].equals("1"))
			estatus = "Activo";
		else
			estatus = "Inactivo";
		try {
			String descripcion = VCION_CAMBIO + ". " + "ID: " + idRegistro
					+ " <BR>" + "Clave: " + datosPrevios[0][7] + ", <BR>"
					+ "Nombre: " + datosPrevios[0][0] + ", <BR>"
					+ "Descripción: " + datosPrevios[0][1] + ", <BR> " + ""
					+ estatus + " ";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioValoracion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Valoración
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Valoración
	 * @param idRegistro
	 *            ID de la Valoración
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarValoracion(String idUsuario,
			String clave, String idRegistro, String nombre, String desc) {
		int r = 0;
		try {
			String descripcion = VCION_BAJA + ". Clave: " + clave
					+ ", Nombre: " + nombre + ", Descripción: " + desc
					+ " , ID: " + idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarValoracion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Selección
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Selección
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaSeleccion(String idUsuario,
			String clave, String nombre, String desc) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_SELECCION FROM SD_SELECCION WHERE SEL_CLAVE='"
					+ clave + "' AND SEL_STATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = SELEC_ALTA + ". Clave: " + clave
					+ ", <br>Nombre: " + nombre + ", <br>Descripción: " + desc
					+ ", <br>ID: " + idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaSeleccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Selección
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Selección
	 * @param idRegistro
	 *            ID de la Selección
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioSeleccion(String idUsuario,
			String clave, String idRegistro, String[][] datosAnteriores) {
		int r = 0;
		String estatus = "";
		if (datosAnteriores[0][7].equals("1"))
			estatus = "Activo";
		else
			estatus = "Inactivo";
		try {
			String descripcion = SELEC_CAMBIO + ". " + "ID: " + idRegistro
					+ " <br>" + "Clave: " + datosAnteriores[0][4] + ", <br>"
					+ "Nombre: " + datosAnteriores[0][0] + ", <br>"
					+ "Descripción: " + datosAnteriores[0][1] + " <br>" + ""
					+ estatus + " ";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioSeleccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Selección
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Selección
	 * @param idRegistro
	 *            ID de la Selección
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarSeleccion(String idUsuario,
			String clave, String idRegistro, String nombre, String desc) {
		int r = 0;
		try {
			String descripcion = SELEC_BAJA + ". Clave: " + clave
					+ ", Nombre: " + nombre + ", Descripción: " + desc
					+ ",ID: " + idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoEliminarSeleccion="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarSeleccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de CDI
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del CDI
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaCDI(String idUsuario, String clave,
			String nombre, String desc) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_CLASIF_INF FROM SD_CLASIF_INF WHERE CLSI_CLAVE='"
					+ clave + "' AND CLSI_STATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = CDI_ALTA + ". Clave: " + clave + ", Nombre: "
					+ nombre + ", Descripción: " + desc + ", ID: " + idRegistro
					+ "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoAltaCDI="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaCDI:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de CDI
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del CDI
	 * @param idRegistro
	 *            ID del CDI
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioCDI(String idUsuario,
			String clave, String idRegistro, String[][] datosAnt) {
		int r = 0;
		String estatus = "";
		if (datosAnt[0][7].equals("1"))
			estatus = "Activo";
		else
			estatus = "Inactivo";
		try {
			String descripcion = CDI_CAMBIO + ". <br>" + "ID: " + idRegistro
					+ " <br>" + "Clave: " + datosAnt[0][4] + ", <br>"
					+ "Nombre: " + datosAnt[0][0] + ", <br>" + "Descripción: "
					+ datosAnt[0][1] + ", <br>" + "" + estatus + " ";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoCambioCDI="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioCDI:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de CDI
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del CDI
	 * @param idRegistro
	 *            ID del CDI
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarCDI(String idUsuario,
			String clave, String idRegistro, String nombre, String desc) {
		int r = 0;
		try {
			String descripcion = CDI_BAJA + ". Clave: " + clave + ", Nombre: "
					+ nombre + ", Descripción: " + desc + ", ID: " + idRegistro
					+ "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoEliminarCDI="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarCDI:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de ICDD
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del ICDD
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaICDD(String idUsuario,
			String clave, String nombre, String desc, String fondo,
			String subfondo, String seccion) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_CLASIFICACION FROM SD_CLASIFICACION WHERE CLS_CLAVE='"
					+ clave + "' AND CLS_STATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = ICDD_ALTA + ". <br> " + "Fondo: "
					+ ActualizaExpArchivado.getFondo(fondo)[0][0] + ", <br> "
					+ "SubFondo: "
					+ ActualizaExpArchivado.getSubfondoA(subfondo)[0][0]
					+ ", <br> " + "Sección: "
					+ ActualizaExpArchivado.getSeccion(seccion)[0][0]
					+ ", <br> " + "Clave: " + clave + ", <br> " + "Nombre: "
					+ nombre + ", <br> " + "Descripción: " + desc + ", <br> "
					+ "ID: " + idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoAltaICDD="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaICDD:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de ICDDSub
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del ICDDSub
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaICDDsub(String idUsuario,
			String clave, String nombre, String desc, String fondo,
			String subfondo, String seccion, String serie) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_CLASIFICACION FROM SD_CLASIFICACION_SUB WHERE CLS_CLAVE='"
					+ clave + "' AND CLS_STATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = ICDD_SUBALTA + ". <br> " + "Nombre: " + nombre
					+ ", <br> " + "Descripción: " + desc + ", <br> "
					+ "Fondo: " + ActualizaExpArchivado.getFondo(fondo)[0][0]
					+ ", <br> " + "SubFondo: "
					+ ActualizaExpArchivado.getSubfondoA(subfondo)[0][0]
					+ ", <br> " + "Sección: "
					+ ActualizaExpArchivado.getSeccion(seccion)[0][0]
					+ ", <br> " + "Serie: "
					+ ActualizaExpArchivado.getClasificacion(serie)[0][0]
					+ ", <br> " + "Clave: " + clave + ", <br> " + "ID: "
					+ idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoAltaICDD="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaICDD:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de ICDDSub
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del ICDDSub
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioICDDSub(String idUsuario,
			String clave, String idRegistro, String[][] datosAnt) {
		int r = 0;
		try {
			String descripcion = ICDD_SUBCAMBIO
					+ ". <br> "
					+ "ID: "
					+ idRegistro
					+ ", <br> "
					+ "Nombre: "
					+ datosAnt[0][0]
					+ ", <br> "
					+ "Descripción: "
					+ datosAnt[0][1]
					+ ", <br> "
					+ "Vigencia AT: "
					+ datosAnt[0][6]
					+ ", <br> "
					+ "Vigencia AC: "
					+ datosAnt[0][7]
					+ ", <br> "
					+ "Vigencia TOTAL: "
					+ datosAnt[0][8]
					+ ", <br> "
					+ "Años Reserva: "
					+ datosAnt[0][12]
					+ ", <br> "
					+ "Fondo: "
					+ ActualizaExpArchivado.getFondo(datosAnt[0][13])[0][0]
					+ ", <br> "
					+ "SubFondo: "
					+ ActualizaExpArchivado.getSubfondoA(datosAnt[0][14])[0][0]
					+ ", <br> "
					+ "Sección: "
					+ ActualizaExpArchivado.getSeccion(datosAnt[0][15])[0][0]
					+ ", <br> "
					+ "Serie: "
					+ ActualizaExpArchivado.getClasificacion(datosAnt[0][16])[0][0]
					+ ", <br> " + "Clave: " + datosAnt[0][11] + ", <br> ";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoCambioICDD="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioICDD:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de ICDD
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del ICDD
	 * @param idRegistro
	 *            ID del ICDD
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioICDD(String idUsuario,
			String clave, String idRegistro, String[][] datosAnt) {
		int r = 0;
		try {
			String descripcion = ICDD_CAMBIO + ". <br> " + "ID: " + idRegistro
					+ ", <br> " + "Nombre: " + datosAnt[0][0] + ", <br> "
					+ "Descripción: " + datosAnt[0][1] + ", <br> "
					+ "Vigencia AT: " + datosAnt[0][6] + ", <br> "
					+ "Vigencia AC: " + datosAnt[0][7] + ", <br> "
					+ "Vigencia TOTAL: " + datosAnt[0][8] + ", <br> "
					+ "Años Reserva: " + datosAnt[0][12] + ", <br> "
					+ "Fondo: "
					+ ActualizaExpArchivado.getFondo(datosAnt[0][13])[0][0]
					+ ", <br> " + "SubFondo: "
					+ ActualizaExpArchivado.getSubfondoA(datosAnt[0][14])[0][0]
					+ ", <br> " + "Sección: "
					+ ActualizaExpArchivado.getSeccion(datosAnt[0][15])[0][0]
					+ ", <br> " + "Clave: " + datosAnt[0][11] + ", <br> ";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoCambioICDD="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioICDD:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de ICDD
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del ICDD
	 * @param idRegistro
	 *            ID del ICDD
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarICDD(String idUsuario,
			String clave, String idRegistro, String nombre, String desc) {
		int r = 0;
		try {
			String descripcion = ICDD_BAJA + ". Clave: " + clave + ", Nombre: "
					+ nombre + ", Descripción: " + desc + ",ID: " + idRegistro
					+ "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoEliminarICDD="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarICDD:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	public static boolean InsertarEventoEliminarICDDSub(String idUsuario,
			String clave, String idRegistro, String nombre, String desc) {
		int r = 0;
		try {
			String descripcion = ICDD_SUBBAJA + ". Clave: " + clave
					+ ", Nombre: " + nombre + ", Descripción: " + desc
					+ ",ID: " + idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarICDDSub:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Cedula Tipo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Cedula Tipo
	 * @param area
	 *            Unidad Administrativa
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaCedTipo(String idUsuario,
			String clave, String area) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_CEDULA FROM SD_TIPO_CEDULA WHERE CED_CLAVE='"
					+ clave
					+ "' AND CED_CVE_UA='"
					+ area
					+ "' AND CED_STATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = CTIPO_ALTA + ". Clave: " + clave
					+ ", Clave-UA: " + area + ", ID: " + idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoAltaCedTipo="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaCedTipo:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Cedula Tipo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Cedula Tipo
	 * @param area
	 *            Unidad Administrativa
	 * @param idRegistro
	 *            ID de la Cedula Tipo
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioCedTipo(String idUsuario,
			String clave, String area, String idRegistro) {
		int r = 0;
		try {
			String descripcion = CTIPO_CAMBIO + ". Clave: " + clave
					+ ", Clave-UA: " + area + ", ID: " + idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoCambioCedTipo="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioCedTipo:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Cedula Tipo
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave de la Cedula Tipo
	 * @param area
	 *            Unidad Administrativa
	 * @param idRegistro
	 *            ID de la Cedula Tipo
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarCedTipo(String idUsuario,
			String clave, String area, String idRegistro) {
		int r = 0;
		try {
			String descripcion = CTIPO_BAJA + ". Clave: " + clave
					+ ", Clave-UA: " + area + ", ID: " + idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoEliminarCedTipo="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarCedTipo:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de Expediente
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del Expediente
	 * @param area
	 *            Unidad Administrativa
	 * @param cedTipo
	 *            Cedula Tipo
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaExpe(String idUsuario,
			String clave, String area, String cedTipo) {
		int r = 0;
		try {
			String sqlId = "SELECT ID_EXPEDIENTE FROM SD_EXPEDIENTES WHERE EXP_CLAVE='"
					+ clave
					+ "' "
					+ "AND EXP_CVE_UA='"
					+ area
					+ "' AND EXP_CED_TIPO='" + cedTipo + "' AND EXP_STATUS=1";
			String idRegistro = getIdRegistroAltas(sqlId);
			String descripcion = EXPE_ALTA + ". Clave: " + clave + ", UA: "
					+ ActualizaArea.NombreArea(area) + ", " + "Cedula Tipo: "
					+ ActualizaExpArchivado.getTipCed(cedTipo)[0][0] + ", ID: "
					+ idRegistro + "";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoAltaExpe="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaExpe:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de Expediente
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del Expediente
	 * @param area
	 *            Unidad Administrativa
	 * @param cedTipo
	 *            Cedula Tipo
	 * @param idRegistro
	 *            ID del Expediente
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioExpe(String idUsuario,
			String clave, String area, String cedTipo, String idRegistro,
			String[][] datoAnt) {
		int r = 0;
		try {
			String descripcion = EXPE_CAMBIO + ". <br> " + "Clave: " + clave
					+ ", <br> " + "UA: "
					+ ActualizaArea.NombreArea(datoAnt[0][0]) + ", <br> "
					+ "Cédula Tipo: "
					+ ActualizaExpArchivado.getTipCed(datoAnt[0][2])[0][0]
					+ ", <br> " + "Fecha de Apertura: " + datoAnt[0][3]
					+ ", <br> " + "Clave: " + datoAnt[0][4] + ", <br> "
					+ "Identificador Interno: " + datoAnt[0][5] + ", <br> "
					+ "Ubicación Topográfica: " + datoAnt[0][6] + ", <br> "
					+ "Denominación: " + datoAnt[0][7] + ", <br> "
					+ "Descripción: " + datoAnt[0][8] + ", <br> "
					+ "Valoración: "
					+ ActualizaExpArchivado.getValoracion(datoAnt[0][9])[0][0]
					+ ", <br> " + "Fundamento Jurídico: " + datoAnt[0][17]
					+ ", <br> " + "Motivación: " + datoAnt[0][16] + ", <br> "
					+ "Observaciones: " + datoAnt[0][18] + ", <br> "
					+ "Año AT: " + datoAnt[0][11] + ", <br> " + "Año AC: "
					+ datoAnt[0][12] + ", <br> "
					+ "Vigencia Total Disposición: " + datoAnt[0][14]
					+ ", <br> " + "Años Reserva: " + datoAnt[0][19] + ", <br> "
					+ "Reserva Real: " + datoAnt[0][20] + ", <br> "
					+ "Vigencia Total Clasificación: " + datoAnt[0][21]
					+ " <br> " + "ID: " + idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoCambioExpe="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioExpe:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de Expediente
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del Expediente
	 * @param area
	 *            Unidad Administrativa
	 * @param cedTipo
	 *            Cedula Tipo
	 * @param idRegistro
	 *            ID del Expediente
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarExpe(String idUsuario,
			String clave, String area, String cedTipo, String idRegistro) {
		int r = 0;
		try {
			String descripcion = EXPE_BAJA + ". Clave: " + clave + ", UA: "
					+ ActualizaArea.NombreArea(area) + ", " + "Cédula Tipo: "
					+ ActualizaExpArchivado.getTipCed(cedTipo)[0][0] + ", ID: "
					+ idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoEliminarExpe="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarExpe:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Configuracion del Sistema
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param dias
	 *            Dias de Caducidad del Asunto
	 * @param semaforo
	 *            Porcentaje del Semaforo Amarillo
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoModificaConfig(String idUsuario,
			String dias, String semaforo) {
		int r = 0;
		try {
			String descripcion = CONF_CAMBIO + ". ";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoModificaConfig="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoModificaConfig:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de intentos de entrar al sistema
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param intentos
	 *            Numero de intentos para entrar al sistema
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoIntentoEnt(String idUsuario,
			String intentos) {
		int r = 0;
		try {
			String descripcion = INT_ENTRAR + ". " + intentos + "° intento";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoIntentoEnt="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoIntentoEnt:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Suspensión de un Usuario
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param intentos
	 *            Numero de intentos para entrar al sistema
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoSuspencion(String idUsuario,
			String intentos) {
		int r = 0;
		try {
			String descripcion = INT_ENTRAR + ". " + intentos + "° intento. "
					+ SUSPENCION;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoSuspencion="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoSuspencion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Cambio de Expediente en una
	 * instrucción
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param idRegistro
	 *            ID de la instrucción
	 * @param datos
	 *            Datos previos del registro
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAsignacionExpedienteInst(
			String idUsuario, String idRegistro, String[][] datos) {
		int r = 0;
		try {
			String descripcion = CAMBIO_EXP_INT + ".<BR>" + "ID instrucción: "
					+ idRegistro + "<BR>" + "Folio de Recepción: "
					+ datos[0][2] + "<BR>" + "ID Expediente: " + datos[0][0]
					+ "<BR>" + "Expediente: " + datos[0][1] + "<BR>" + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// System.out.println(sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAsignacionExpedienteInst:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Cambio de Expediente en un Asunto
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param idRegistro
	 *            ID del Asunto
	 * @param datos
	 *            Datos previos del registro
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAsignacionExpedienteAsu(
			String idUsuario, String idRegistro, String[][] datos) {
		int r = 0;
		try {
			String descripcion = CAMBIO_EXP_ASU + ".<BR>" + "ID Asunto: "
					+ idRegistro + "<BR>" + "Folio de Recepción: "
					+ datos[0][2] + "<BR>" + "ID Expediente: " + datos[0][0]
					+ "<BR>" + "Expediente: " + datos[0][1] + "<BR>" + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// System.out.println(sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAsignacionExpedienteAsu:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Cambio de Expediente en un Asunto
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param idRegistro
	 *            ID del Asunto
	 * @param datos
	 *            Datos previos del registro
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoBajaAsunto(String idUsuario,
			String idRegistro) {
		int r = 0;
		try {
			String descripcion = ASUNTO_BAJA + ".<BR>" + "ID Asunto: "
					+ idRegistro + "<BR>" + "Folio de Recepción: "
					+ ActualizaAsunto.getFolioAsunto(idRegistro) + "";
			descripcion = (descripcion.length() > 3000) ? descripcion
					.substring(0, 3000) : descripcion;
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// System.out.println(sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAsignacionExpedienteAsu:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Alta de ICDD Unidad
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del ICDD Unidad
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoAltaICDDUnidad(String area,
			String seccion, String fecha, String idUsuario) {
		int r = 0;
		try {
			String descripcion = ICDDU_ALTA + ". <br> "
					+ "Unidad Administrativa: "
					+ ActualizaArea.NombreArea(area) + ", <br> "
					+ "Sección-Fondo-SubFondo: "
					+ ActualizaExpArchivado.getICDDUnidadSeccion(seccion)
					+ ", <br> " + "Fecha: " + fecha + ", <br> ";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoAltaICDD="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoAltaICDD:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Edición de ICDD
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del ICDD
	 * @param idRegistro
	 *            ID del ICDD
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoCambioICDDUnidad(String idUsuario,
			String idRegistro, String[][] datosAnt) {
		int r = 0;
		try {
			String descripcion = ICDDU_CAMBIO
					+ ". <br> "
					+ "ID: "
					+ idRegistro
					+ ", <br> "
					+ "Unidad Administrativa: "
					+ ActualizaArea.NombreArea(datosAnt[0][0])
					+ ", <br> "
					+ "Sección-Fondo-SubFondo: "
					+ ActualizaExpArchivado
							.getICDDUnidadSeccion(datosAnt[0][1]) + ", <br> "
					+ "Fecha Registro: " + datosAnt[0][5] + " <br> ";

			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoCambioICDD="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoCambioICDD:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en la bitacora un Evento de Baja de ICDD
	 * 
	 * @param idUsuario
	 *            Usuario que realiza el Evento
	 * @param clave
	 *            Clave del ICDD
	 * @param idRegistro
	 *            ID del ICDD
	 * 
	 * @return Regresa True si la inserción fue satisfactoria y False en caso
	 *         contrario
	 */
	public static boolean InsertarEventoEliminarICDDUnidad(String idUsuario,
			String idRegistro, String area, String seccion, String fecha) {
		int r = 0;
		try {
			String descripcion = ICDDU_BAJA + ". <br> "
					+ "Unidad Administrativa: "
					+ ActualizaArea.NombreArea(area) + ", <br> "
					+ "Sección-Fondo-SubFondo: "
					+ ActualizaExpArchivado.getICDDUnidadSeccion(seccion)
					+ ", <br> " + "Fecha Registro: " + fecha + ", <br> "
					+ "ID: " + idRegistro + "";
			String sql = SQL_INSERT + idUsuario + ", SYSDATE, '" + descripcion
					+ "')";
			// //System.out.println("InsertarEventoEliminarICDD="+sql);
			r = ConexionDS.ejecutarActualizacion(sql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarEventoEliminarICDD:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

}
