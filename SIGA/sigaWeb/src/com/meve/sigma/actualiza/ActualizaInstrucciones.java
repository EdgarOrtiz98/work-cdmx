/*s
 * Clase:						ActualizaInstruccones.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Oct 3, 2005
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
import java.util.Calendar;
import java.util.Vector;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLInstrucciones;
import com.meve.sigma.util.AsignarArbol;
import com.meve.sigma.util.Estatus;
import com.meve.sigma.util.SubDirectos;
import com.meve.sigma.util.Utilerias;

/**
 * Realiza multiples operaciones sobre asuntos e instrucciones
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class ActualizaInstrucciones {

	/**
	 * Función que ejecuta un query donde trae una lista de los usuarios que van
	 * a atender una instrucción
	 * 
	 * @param strIdUsuario
	 *            Id del usuario
	 * @return String[][] con el query
	 */
	public static String[][] UsuarioInstruccionAtender(String strIdUsuario) {
		try {
			String strsql = SQLInstrucciones
					.UsuarioInstruccionAtender(strIdUsuario);
			// //System.err.println("UsuarioInstruccionAtender:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("UsuarioInstruccionAtender:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query donde trae una lista de los usuarios que
	 * estan tramitando una instrucción
	 * 
	 * @param strIdUsuario
	 *            Id del usuario
	 * @return String[][] con el query
	 */
	public static String[][] UsuarioInstruccionTramite(String strIdUsuario) {
		try {
			String strsql = SQLInstrucciones
					.UsuarioInstruccionTramite(strIdUsuario);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta en query donde se trae una lista de los usuarios que
	 * han terminado alguna instrucción
	 * 
	 * @param strIdUsuario
	 *            Id del usuario
	 * @return String[][] con el query
	 */
	public static String[][] UsuarioInstruccionTerminada(String strIdUsuario) {
		try {
			String strsql = SQLInstrucciones
					.UsuarioInstruccionTerminada(strIdUsuario);
			// //System.out.println("UsuarioInstruccionTerminada:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("UsuarioInstruccionTerminada:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query que trae una lista de los usuarios que han
	 * rechazado alguna instrucción
	 * 
	 * @return String[][] con el query
	 */
	public static String[][] UsuarioInstruccionRechazada() {
		try {
			String strsql = SQLInstrucciones.UsuarioInstruccionRechazada();
			// //System.out.println("UsuarioInstruccionRechazada:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("UsuarioInstruccionRechazada:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Crea un query para regresar instrucciones por atender
	 * 
	 * @param strIdUsuario
	 *            Id del usuario
	 * @return String[][] con el query
	 */
	public static String[][] getInstruccionAtenderUsuario(String strIdUsuario) {
		try {
			String strsql = SQLInstrucciones
					.getInstruccionAtenderUsuario(strIdUsuario);
			// //System.out.println("getInstruccionAtenderUsuario:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getInstruccionAtenderUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Crea un query para regresar instrucciones por atender ordenadas
	 * 
	 * @param strIdUsuario
	 *            Id del usuario
	 * @param orden
	 *            Ordenamiento
	 * @param tipo
	 *            Tipo de ordenamiento
	 * @return String[][] con el query
	 */
	public static String[][] getInstruccionAtenderUsuario(String strIdUsuario,
			String orden, String tipo) {
		try {
			String strsql = SQLInstrucciones.getInstruccionAtenderUsuario(
					strIdUsuario, orden, tipo);
			// //System.out.println("getInstruccionAtenderUsuario:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getInstruccionAtenderUsuario:"+sqle.getMessage());
			// sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Crea un query para regresar instrucciones en tramite ordenadas
	 * 
	 * @param strIdUsuario
	 *            Id del usuario
	 * @param orden
	 *            Ordenamiento
	 * @param tipo
	 *            Tipo de ordenamiento
	 * @return String[][] con el query
	 */
	public static String[][] getInstruccionTramiteUsuario(String strIdUsuario,
			String orden, String tipo) {
		try {
			String strsql = SQLInstrucciones.getInstruccionTramiteUsuario(
					strIdUsuario, orden, tipo);
			// //System.out.println("getInstruccionTramiteUsuario:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getInstruccionTramiteUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Crea un query para regresar instrucciones terminadas ordenadas
	 * 
	 * @param strIdUsuario
	 *            Id del usuario
	 * @param orden
	 *            Ordenamiento
	 * @param tipo
	 *            Tipo de ordenamiento
	 * @return String[][] con el query
	 */
	public static String[][] getInstruccionTerminadaUsuario(
			String strIdUsuario, String orden, String tipo) {
		try {
			String strsql = SQLInstrucciones.getInstruccionTerminadaUsuario(
					strIdUsuario, orden, tipo);
			// //System.out.println("getInstruccionTramiteTerminada:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getInstruccionTramiteTerminada:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query para mostrar los datos de la instrucción
	 * rechazada|
	 * 
	 * @param strIdUsuario
	 *            Id del usuario
	 * @param orden
	 *            Ordenamiento
	 * @param tipo
	 *            Tipo de ordenamiento
	 * @return String[][] con el query
	 */
	public static String[][] getInstruccionRechazadaUsuario(
			String strIdUsuario, String orden, String tipo) {
		try {
			String strsql = SQLInstrucciones.getInstruccionRechazadaUsuario(
					strIdUsuario, orden, tipo);
			// //System.out.println("getInstruccionRechazadaUsuario:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getInstruccionRechazadaUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query donde regresa datos para la vista de una
	 * instruccion
	 * 
	 * @param strIdInstruccion
	 *            String Contiene el ID de la Instruccion
	 * @return String[][] con el query
	 */
	public static String[][] getInstruccionDatos(String strIdInstruccion) {
		try {
			String strsql = SQLInstrucciones
					.getInstruccionDatos(strIdInstruccion);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que regresa el ID del Asunto al que pertenece la instrucción al
	 * mandar a ejecutar el query en en la clase ConexionDS
	 * 
	 * @param strIdInstruccion
	 *            String que recibe el ID de la instrucción
	 * @return String[][] con el query
	 */
	public static String getIdAsuntoInstruccion(String strIdInstruccion) {
		String strsql = SQLInstrucciones
				.getIdAsuntoInstruccion(strIdInstruccion);
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(strsql);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualiza el avance de las Instrucciones
	 * 
	 * @param strIdInstruccion
	 *            ID de la instrucción
	 * @param strAvance
	 *            Avance
	 * @param strEstatus
	 *            Estatus de la instrucción
	 * @param evento
	 *            Descripcion del evento
	 * @param usuarioOriginal
	 *            Usuarios que da el avance
	 * @param liberado
	 *            Estatus de liberado
	 * @param id_historial
	 *            ID de l historial de la instrucción
	 * @param firmarDigitalmente
	 *            Firma digital
	 * @param fechaTerminacionReal
	 *            Techa de terminacion real
	 * @return Regresa true si la actualizacion fue exitosa y false en caso
	 *         contrario
	 */
	public static boolean ActualizarAvance(String strIdInstruccion,
			String strAvance, String strEstatus, String evento,
			String usuarioOriginal, String liberado, String id_historial,
			String firmarDigitalmente, String fechaTerminacionReal) {
		int r = 0;
		try {
			String strSql = SQLInstrucciones.ActualizarAvance(strIdInstruccion,
					strAvance, strEstatus, evento, usuarioOriginal, liberado,
					id_historial, firmarDigitalmente, fechaTerminacionReal);
			// //System.out.println("ActualizarAvance:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("ActualizarAvance:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Actualizacion de rechazo
	 * 
	 * @param strIdInstruccion
	 *            ID de la instrucción
	 * @param strAvance
	 *            Avance
	 * @return Regresa true si la actualizacion fue exitosa y false en caso
	 *         contrario
	 */
	public static boolean ActualizarRechazo(String strIdInstruccion,
			String strAvance) {
		int r = 0;
		try {
			String strSql = SQLInstrucciones.ActualizarRechazo(
					strIdInstruccion, strAvance);
			// //System.out.println("ActualizarRechazo(...):"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("ActualizarRechazo:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Actualizacion de Reasignar
	 * 
	 * @param strIdInstruccion
	 *            ID de la instrucción
	 * @param strIdUsuario
	 *            ID del Usuario
	 * @param strAvance
	 *            Avance
	 * @return Regresa true si la actualizacion fue exitosa y false en caso
	 *         contrario
	 */
	public static boolean ActualizaReasignar(String strIdInstruccion,
			String strIdUsuario, String strAvance) {
		int r = 0;
		try {
			String strSql = SQLInstrucciones.ActualizaReasignar(
					strIdInstruccion, strIdUsuario, strAvance);
			// //System.out.println("ActualizaInstrucciones.ActualizaReasignar(...):
			// "+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("ActualizaReasignar:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Actualizacion de Delegar
	 * 
	 * @param strIdInstruccion
	 *            ID de la instrucción
	 * @param strAvance
	 *            Avance
	 * @param strIdUsuario
	 *            ID del Usuario
	 * @return Regresa true si la actualizacion fue exitosa y false en caso
	 *         contrario
	 */
	public static boolean ActualizaDelegar(String strIdInstruccion,
			String strAvance, String strIdUsuario) {
		int r = 0;
		try {
			String strSql = SQLInstrucciones.ActualizaDelegar(strIdInstruccion,
					strAvance, strIdUsuario);
			// //System.out.println("ActualizaDelegar:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("ActualizaDelegar:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Verifica si existen Instrucciones por Atender
	 * 
	 * @param strIdUsuario
	 *            ID usuario
	 * @return Regresa true si existen instrucciones y false en caso contrario
	 */
	public static boolean TieneInstruccionesPorAtender(String strIdUsuario) {
		boolean boleano = false;
		String strExpediente[][] = null;
		String sql = "SELECT DISTINCT ID_USUARIO,USU_CARGO, USU_NOMBRE "
				+ "FROM SD_INSTRUCCION_ASUNTO INNER JOIN SD_USUARIO ON ID_USUARIO = INS_USUARIO "
				+ "WHERE INS_ESTATUS = 1 AND INS_USUARIO IN "
				+ "(SELECT DISTINCT A.ID_USUARIO "
				+ "FROM SD_USUARIO A, SD_USUARIO_ROL B "
				+ "WHERE A.USU_ESTATUS = 1 AND A.USU_ACTIVO = 1 AND A.ID_USUARIO = B.ID_USUARIO1 START WITH A.ID_USUARIO ="
				+ strIdUsuario + " CONNECT BY PRIOR A.ID_USUARIO = A.USU_JEFE"
				+ ") " + "ORDER BY 3";
		try {
			String strsql = SQLInstrucciones
					.TieneInstruccionesPorAtender(strIdUsuario);
			// System.out.println("TieneInstruccionesPorAtender:"+strsql);
			// System.out.println("Segundo Criterio:"+sql);
			strExpediente = ConexionDS.ejecutarSQL(strsql);
			if (Integer.parseInt(strExpediente[0][0]) > 0)
				boleano = true;
			else {
				// strExpediente = ConexionDS.ejecutarSQL(sql);
				// boleano =strExpediente.length>0?true:false;
				boleano = false;
			}
		} catch (SQLException sqle) {
			// System.out.println("Error:
			// TieneInstruccionesPorAtender->"+sqle.getMessage());
			sqle.printStackTrace();
			try {
				strExpediente = ConexionDS.ejecutarSQL(sql);
				boleano = strExpediente.length > 0 ? true : false;
			} catch (Exception e) {
				boleano = false;
			}
		}
		return boleano;
	}

	/**
	 * Verifica si existen Instrucciones en Tramite
	 * 
	 * @param strIdUsuario
	 *            ID usuario
	 * @return Regresa true si existen instrucciones y false en caso contrario
	 */
	public static boolean TieneInstruccionesEnTramite(String strIdUsuario) {
		try {
			String strsql = SQLInstrucciones
					.TieneInstruccionesEnTramite(strIdUsuario);
			// //System.out.println("TieneInstruccionesEnTramite:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;

			// //System.out.println("="+false);
			return false;
		} catch (SQLException sqle) {
			// System.out.println("TieneInstruccionesEnTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica si existen Instrucciones Terminadas
	 * 
	 * @param strIdUsuario
	 *            ID usuario
	 * @return Regresa true si existen instrucciones y false en caso contrario
	 */
	public static boolean TieneInstruccionesTerminadas(String strIdUsuario) {
		try {
			String strsql = SQLInstrucciones
					.TieneInstruccionesTerminadas(strIdUsuario);
			// //System.out.println("TieneInstruccionesTerminadas:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;

			// //System.out.println("="+false);
			return false;
		} catch (SQLException sqle) {
			// System.out.println("TieneInstruccionesTerminadas:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica si existen Instrucciones Rechazadas
	 * 
	 * @param strIdUsuario
	 *            ID usuario
	 * @return Regresa true si existen instrucciones y false en caso contrario
	 */
	public static boolean TieneInstruccionesRechazadas(String strIdUsuario) {
		try {
			String strsql = SQLInstrucciones
					.TieneInstruccionesRechazadas(strIdUsuario);
			// //System.out.println("TieneInstruccionesRechazadas:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			// //System.out.println("="+false);
			return false;
		} catch (SQLException sqle) {
			// System.out.println("TieneInstruccionesRechazadas:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Función qeu ejecuta un query que determina si tiene Instrucciones
	 * rechazadas
	 * 
	 * @return True si existen, False no existen
	 */
	public static boolean TieneInstruccionesRechazadas() {
		try {
			String strsql = SQLInstrucciones.TieneInstruccionesRechazadas();
			// //System.out.println("TieneInstruccionesRechazadas:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;

			// //System.out.println("="+false);
			return false;
		} catch (SQLException sqle) {
			// System.out.println("TieneInstruccionesRechazadas:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa las instrucciones por Unidad Administrativa
	 * 
	 * @param strIdAsunto
	 *            String que contiene ID de Asunto
	 * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] InstruccionPorIdAsunto(String strIdAsunto) {
		try {
			String strsql = SQLInstrucciones
					.InstruccionPorIdAsunto(strIdAsunto);
			// System.out.println("InstruccionPorIdAsunto:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("InstruccionPorIdAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Regresa las instrucciones por ID de instrucción
	 * 
	 * @param strIdInstruccion
	 *            ID de instrucción
	 * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] InstruccionPorIdInstruccion(String strIdInstruccion) {
		try {
			String strsql = SQLInstrucciones
					.InstruccionPorIdInstruccion(strIdInstruccion);
			// //System.out.println("InstruccionPorIdInstruccion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("InstruccionPorIdInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Verifica si existen instrucciones por ID de Asunto
	 * 
	 * @param strIdAsunto
	 *            ID del Asunto
	 * @return Regresa true si existen instrucciones y false en caso contrario
	 */
	public static boolean TieneInstrucciones(String strIdAsunto) {
		try {
			String strsql = SQLInstrucciones.TieneInstrucciones(strIdAsunto);
			// //System.out.println("TieneInstrucciones:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;

			// //System.out.println("="+false);
			return false;
		} catch (SQLException sqle) {
			// System.out.println("TieneInstruccionesPorAtender:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa el Tiempo de una instrucción
	 * 
	 * @param strIdAsunto
	 *            ID Asunto
	 * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] getTimeInstrucciones(String strIdAsunto) {
		try {
			String strsql = SQLInstrucciones.getTimeInstrucciones(strIdAsunto);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Regresa el Tiempo de una instrucción Habilitada
	 * 
	 * @param strIdInstruccion
	 * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] getTimeInstruccionesHabilitadas(
			String strIdInstruccion) {
		try {
			String strsql = SQLInstrucciones
					.getTimeInstruccionesHabilitadas(strIdInstruccion);
			// //System.out.println("getTimeInstruccionesHabilitadas:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getTimeInstruccionesHabilitadas:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualiza Instrucciones turnadas
	 * 
	 * @param strIdInstruccion
	 *            ID de la instrucción
	 * @param strFechaInicio
	 *            Fecha inicial
	 * @param strFechaFin
	 *            Fecha final
	 * @param strTurnador
	 *            Usuaro turnador
	 * @param strAreaOrigen
	 *            Area del Usuario
	 * @param strAreaInst
	 *            Area de la instrucción
	 * @return Regresa true si la actualizacion fue exitosa o false en caso
	 *         contrario
	 */
	public static boolean UpdateInstruccionTurnado(String strIdInstruccion,
			String strFechaInicio, String strFechaFin, String strTurnador,
			String strAreaOrigen, String strAreaInst, int iBandera,
			String nombreInst) {
		int r = 0;
		try {
			if (getTurnadorJefe(strIdInstruccion, strTurnador)) {
				strAreaInst = strAreaOrigen;
			}
			String strSql = SQLInstrucciones.UpdateInstruccionTurnado(
					strIdInstruccion, strFechaInicio, strFechaFin, strTurnador,
					strAreaOrigen, strAreaInst, iBandera, nombreInst);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Obtiene el nombre de usuario de una instrucción
	 * 
	 * @param idInstruccion
	 *            Id de instrucción
	 * @return nombre de usuario
	 */
	public static String NombreUsuarioInstruccion(String idInstruccion) {
		String SQL = "SELECT INS_USUARIO FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="
				+ idInstruccion;
		try {
			String strResult1[][] = ConexionDS.ejecutarSQL(SQL);
			// //System.out.println("IdUsuario"+strResult1[0][0]);
			String idUsuario = strResult1[0][0];
			String SQL1 = "SELECT USU_NOMBRE FROM SD_USUARIO WHERE ID_USUARIO="
					+ idUsuario;
			String strResult[][] = ConexionDS.ejecutarSQL(SQL1);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("NombreUsuario:");
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene el E-mail del turnador
	 * 
	 * @param idAsunto
	 *            id asunto
	 * @return E-mail del turnador
	 */
	public static String[][] getMailNombreTurnador(String idAsunto) {
		String SQL_MAIL_NOMBRE_TURNADOR = "SELECT USU_NOMBRE, USU_CORREO, ASU_DESCRIPCION, ID_USUARIO, USU_CARGO FROM SD_ASUNTO, SD_USUARIO "
				+ "WHERE SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA "
				+ "AND ID_ASUNTO=" + idAsunto;
		try {
			return ConexionDS.ejecutarSQL(SQL_MAIL_NOMBRE_TURNADOR);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Obtiene el E-mail del 
	 * 
	 * @param idAsunto
	 *            id asunto
	 * @return E-mail del turnador
	 */
	public static String[][] getMailNombreTurno(String idInstruccion) {
		String SQL_MAIL_NOMBRE_TURNADOR = "SELECT  USU_NOMBRE, USU_CORREO, ASU_DESCRIPCION, ID_USUARIO, USU_CARGO  " +
				" FROM SD_USUARIO USU, SD_INSTRUCCION_ASUNTO INS, SD_ASUNTO ASU "
				+ "WHERE USU.ID_USUARIO=INS.INS_TURNO AND ASU.ID_ASUNTO=INS.ID_ASUNTO AND INS.ID_INSTRUCCION_ASUNTO = " + idInstruccion;
		try {
			return ConexionDS.ejecutarSQL(SQL_MAIL_NOMBRE_TURNADOR);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene el E-mail del turnador
	 * 
	 * @param idAsunto
	 *            id asunto
	 * @return E-mail del turnador
	 */

	public static String[][] getMailNombreTurnadorId(String idAsunto) {
		String SQL_MAIL_NOMBRE_TURNADOR = "SELECT USU_NOMBRE, USU_CORREO, ASU_DESCRIPCION, ID_USUARIO FROM SD_ASUNTO, SD_USUARIO "
				+ "WHERE SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA "
				+ "AND ID_ASUNTO=" + idAsunto;
		try {
			// //System.out.println("getMailNombreTurnador:"+SQL_MAIL_NOMBRE_TURNADOR);
			return ConexionDS.ejecutarSQL(SQL_MAIL_NOMBRE_TURNADOR);
		} catch (SQLException sqle) {
			// System.out.println("getMailNombreTurnador:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Inserta una instrucción
	 * 
	 * @param strDetalleFlujo
	 *            Detalle flujo
	 * @param strIdAsunto
	 *            Id asunto
	 */
	public static void insertarInstruccion(String[][] strDetalleFlujo,
			String strIdAsunto) {
		int r = 0;
		try {
			for (int i = 0; i < strDetalleFlujo.length; i++) {
				String strSql = SQLInstrucciones.insertaInstruccion(
						strDetalleFlujo[i][0], strDetalleFlujo[i][1],
						strDetalleFlujo[i][2], strDetalleFlujo[i][3],
						strDetalleFlujo[i][4], strDetalleFlujo[i][5],
						strDetalleFlujo[i][6], strDetalleFlujo[i][7],
						strDetalleFlujo[i][5], strIdAsunto);
				// //System.out.println("InsertRuta="+strSql);
				r = ConexionDS.ejecutarActualizacion(strSql);
			}
		} catch (SQLException sqle) {
			// System.out.println("insertarInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
		}
	}

	/**
	 * Actualiza el estatus de entrada-salida
	 * 
	 * @param strIdInstruccion
	 *            id instrucción
	 * @return Indicador que muestra si la Actualización fue exitosa
	 */
	public static boolean getActualizaEstatusIO(String strIdInstruccion) {
		String SQL = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_ESTATUS=2 WHERE ID_INSTRUCCION_ASUNTO=";
		int r = 0;
		try {
			String strSql = SQL + strIdInstruccion;
			// //System.out.println("getActualizaEstatusIO:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("getActualizaEstatusIO:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Obtiene un evento
	 * 
	 * @param idInstruccion
	 *            Id instrucción
	 * @return evento
	 */
	public static String[][] getEvento(String idInstruccion) {
		String SQL = "SELECT HIS_EVENTO FROM SD_HISTORIAL_INSTRUCCIONES "
				+ "WHERE ID_INSTRUCCION_ASUNTO=" + idInstruccion
				+ " AND HIS_EVENTO=5";
		try {
			// //System.out.println("getEvento:"+SQL);
			return ConexionDS.ejecutarSQL(SQL);
		} catch (SQLException sqle) {
			// System.out.println("getEvento:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Regresa el historial de una instruccion
	 * 
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @return String[][] resultante
	 */
	public static String[][] getDelegarActivo(String strIdInstruccion) {
		String SQL = "SELECT HIS_EVENTO, HIS_USUARIO, HIS_DELEGACION_LIBERADO, ID_HISTORIAL, ID_HISTORIAL, USU_CORREO, USU_NOMBRE, ID_INSTRUCCION_ASUNTO"
				+ " FROM SD_HISTORIAL_INSTRUCCIONES, SD_USUARIO "
				+ "WHERE ID_INSTRUCCION_ASUNTO="
				+ strIdInstruccion
				+ " AND HIS_EVENTO=4 "
				+ "AND HIS_DELEGACION_LIBERADO=0 "
				+ "AND SD_HISTORIAL_INSTRUCCIONES.HIS_USUARIO=SD_USUARIO.ID_USUARIO";
		try {
			// //System.out.println("getDelegarActivo:"+SQL);
			return ConexionDS.ejecutarSQL(SQL);
		} catch (SQLException sqle) {
			// System.out.println("getDelegarActivo:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualiza la Delegación delegada
	 * 
	 * @param strIdHistorial
	 *            Id historial
	 */
	public static void getActualizarVigencia(String strIdHistorial) {
		int r = 0;
		String SQL = "UPDATE SD_HISTORIAL_INSTRUCCIONES SET HIS_DELEGACION_LIBERADO=1 WHERE ID_HISTORIAL="
				+ strIdHistorial;
		try {
			// System.out.println(SQL);
			r = ConexionDS.ejecutarActualizacion(SQL);
		} catch (SQLException sqle) {
			// System.out.println("UpdateInstruccionTurnado:"+sqle.getMessage());
			sqle.printStackTrace();
		}
	}

	/**
	 * Obtiene folio Recepción
	 * 
	 * @param idAsunto
	 *            Id asunto
	 * @return Folio Recepción
	 */
	public static String getFolioRecepcion(String idAsunto) {
		String SQL = "SELECT ASU_FOLIO_RECEPCION FROM SD_ASUNTO WHERE ID_ASUNTO="
				+ idAsunto;
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQL);
			// //System.out.println("FolioReceocion="+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getFolioRecepcion:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Regresa el ultimo folio formado
	 * 
	 * @param idAsunto
	 *            ID del Asunto
	 * @return String[][] resultante
	 */
	public static String getFolioUltimoFormado(String idAsunto)// ///////////////////
	{
		String SQL = "SELECT COUNT(*) FROM SD_INSTRUCCION_ASUNTO "
				+ "WHERE INS_PADRE IS NULL AND ID_ASUNTO=" + idAsunto
				+ " AND INS_ESTATUS <> 0";
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQL);
			// //System.out.println("FolioReceocion="+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getFolioRecepcion:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualiza folio de instrucción
	 * 
	 * @param strIdInstruccion
	 *            Id de instrucción
	 * @param folio
	 *            Folio nuevo
	 * @return Indicador que muestra si la Actualización fue exitosa
	 */
	public static boolean UpdateFolioInstruccion(String strIdInstruccion,
			String folio/* , String strSalida */) {
		int r = 0;
		try {
			String strSql = SQLInstrucciones.UpdateFolioInstruccion(
					strIdInstruccion, folio/* , strSalida */);
			// //System.out.println("UpdateFolioInstruccion:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("UpdateFolioInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Obtiene el último id de una instrucción - asunto
	 * 
	 * @param strIdAsunto
	 *            Id asunto
	 * @return id de asunto - instrucción
	 */
	public static String getUltimoID(String strIdAsunto) {
		String SQL = "SELECT MAX(ID_INSTRUCCION_ASUNTO) FROM SD_INSTRUCCION_ASUNTO WHERE ID_ASUNTO="
				+ strIdAsunto + " AND INS_ESTATUS != 0 AND INS_PADRE IS NULL";
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQL);
			// //System.out.println("getUltimoID="+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getUltimoID:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene el último folio turnado
	 * 
	 * @param strIdInstruccion
	 *            Id de instrucción
	 * @return Obtiene el ultimo folio turnado
	 */
	public static String getUltimoFolioTurnado(String strIdInstruccion) {
		String SQL = "SELECT INS_FOLIO_TURNADO FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="
				+ strIdInstruccion;
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQL);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getUltimoFolioTurnado:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query donde muestra una lista de nombre del asunto
	 * y el nombre de la instrucción
	 * 
	 * @param strIdInstruccion
	 *            ID de instrucción
	 * @return String[][] resultante
	 */
	public static String[][] getNombreInstruccion(String strIdInstruccion) {
		try {
			String sql = SQLInstrucciones
					.getNombreInstruccion(strIdInstruccion);
			return ConexionDS.ejecutarSQL(sql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que que ejecuta un query donde se trae la secuencia a la que
	 * pertenece la instrucción recien terminada y verificar si en ella existe
	 * alguna instrucción requerida
	 * 
	 * @param strIdInstruccion
	 *            Contiene el ID de la instrucción
	 * @return Query
	 */
	public static String getPasoPertenece(String strIdInstruccion) {
		try {
			String sql = SQLInstrucciones.getPasoPertenece(strIdInstruccion);
			// //System.out.println("getPasoPertenece-->"+sql);
			String strResult[][] = ConexionDS.ejecutarSQL(sql);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getPasoPertenece:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que regresa un entero con el numero total de instrucciones que
	 * tienen una opcion requerida
	 * 
	 * @param strIdAsunto
	 *            Contiene el ID del Asunto
	 * @param secuencia
	 *            Contiene la secuencia que va a evaluar
	 * @return String[][] resultante
	 */
	public static String[][] getCountInstruccionesRequeridas(
			String strIdAsunto, String secuencia) {
		try {
			String sql = SQLInstrucciones.getCountInstruccionesRequeridas(
					strIdAsunto, secuencia);
			// //System.out.println("getCountInstruccionesRequeridas="+sql);
			return ConexionDS.ejecutarSQL(sql);
		} catch (SQLException sqle) {
			// System.out.println("getCountInstruccionesRequeridas:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * funcion que ejecuta un query, donde verifica si hay instruciones con la
	 * mismas secuencia sin turnar
	 * 
	 * @param strIdAsunto
	 *            ID del Asunto
	 * @param secuencia
	 *            Secuencia
	 * @return String[][] resultante
	 */
	public static String[][] getCountInstCreadasSinTurnar(String strIdAsunto,
			String secuencia) {
		try {
			String sql = SQLInstrucciones.getCountInstCreadasSinTurnar(
					strIdAsunto, secuencia);
			// //System.out.println("getCountInstCreadasSinTurnar="+sql);
			return ConexionDS.ejecutarSQL(sql);
		} catch (SQLException sqle) {
			// System.out.println("getCountInstCreadasSinTurnar:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que regresa un entero con el numero total de instrucciones que
	 * tienen una opcion requerida
	 * 
	 * @param strIdPadre
	 *            Contiene el ID de la instruccion padre
	 * @param secuencia
	 *            Contiene la secuencia que va a evaluar
	 * @return String[][] resultante
	 */
	public static String[][] getCountInstruccionesRequeridasPadre(
			String strIdPadre, String secuencia) {
		try {
			String sql = SQLInstrucciones.getCountInstruccionesRequeridasPadre(
					strIdPadre, secuencia);
			return ConexionDS.ejecutarSQL(sql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query donde se trae las fechas de inicio y fin de
	 * una instrucción mediante su Id
	 * 
	 * @param strIdInstruccion
	 *            Contiene el Id de la instrucción
	 * @return String[][] resultante
	 */
	public static String[][] getFechasInstruccion(String strIdInstruccion) {
		try {
			String sql = SQLInstrucciones
					.getFechasInstruccion(strIdInstruccion);
			// //System.out.println("getFechasInstruccion="+sql);
			return ConexionDS.ejecutarSQL(sql);
		} catch (SQLException sqle) {
			// System.out.println("getFechasInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query donde se actualizara la fecha de cambio de
	 * una instrucción
	 * 
	 * @param fechaCambio
	 *            Fecha de cambio
	 * @param idInstruccion
	 *            ID de instrucción
	 * @param comentario
	 *            Comentario
	 * @return String[][] resultante
	 */
	public static boolean actualizarFechaCambio(String fechaCambio,
			String idInstruccion, String comentario) {
		int r = 0;
		try {
			String strSql = SQLInstrucciones.actualizarFechaCambio(fechaCambio,
					idInstruccion, comentario);
			// //System.out.println("actualizarFechaCambio:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("actualizarFechaCambio:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Función que ejecuta un query, donde muestrs una la fecha de cambio de
	 * solicitud, la fecha original de vencimiento y el comentario o Razón por
	 * la que se quiere cambiar
	 * 
	 * @param strIdInstruccion
	 *            Contiene el ID de la instrucción
	 * @return String[][] resultante
	 */
	public static String[][] getSolicitudCambio(String strIdInstruccion) {
		try {
			String sql = SQLInstrucciones.getSolicitudCambio(strIdInstruccion);
			return ConexionDS.ejecutarSQL(sql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Solicitud de cambio de Fecha
	 * 
	 * @param strIdInstruccion
	 *            ID instrucción
	 * @return String[][] resultante
	 */
	public static String[][] getSolicitudCambioId(String strIdInstruccion) {
		try {
			String sql = SQLInstrucciones
					.getSolicitudCambioId(strIdInstruccion);
			return ConexionDS.ejecutarSQL(sql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que actualiza la fecha de terminación de una instrucción, al se
	 * aceptado el cambio de fecha
	 * 
	 * @param strIdInstruccion
	 *            Contiene el Id de la instrucción
	 * @param fecha
	 *            Contiene la fecha a cambiar
	 * @return True cuando ejecuta correctamente la Actualización
	 */
	public static boolean actualizaFechaVencimiento(String strIdInstruccion,
			String fecha) {
		int r = 0;
		try {
			String strSql = SQLInstrucciones.actualizaFechaVencimiento(
					strIdInstruccion, fecha);
			// //System.out.println("actualizaFechaVencimiento:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("actualizaFechaVencimiento:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Función que ejecuta un query, donde se actualiza el habilitado o
	 * deshabilitado de una instrucción
	 * 
	 * @param idInstruccion
	 *            Contiene el id de la instrucción
	 * @param n
	 *            Determina si es un habilitado o deshabilitado
	 * @param strB
	 *            Bandera de identificacion
	 * @return True o False
	 */
	public static boolean actualizaHabilitado(String idInstruccion, int n,
			String strB) {
		int r = 0;
		try {
			String strSql = SQLInstrucciones.actualizaHabilitado(idInstruccion,
					n, strB);
			// //System.out.println("actualizaHabilitado:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("actualizaHabilitado:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Función que ejecuta un query, donde verifica si la instruccion tiene
	 * hijos o no
	 * 
	 * @param idInstruccion
	 *            Id de instrucción
	 * @return Indicador que muestra si la instrucción tiene hijos true - existe
	 *         false - no existes
	 */
	public static boolean getTieneHijos(String idInstruccion) {
		try {
			String strsql = SQLInstrucciones.getTieneHijos(idInstruccion);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getTieneHijos:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Valida si hay instrucciones Infromativas
	 * 
	 * @param strIdInstruccion
	 *            Id de instrucción
	 * @param strFechaTerminacion
	 *            Fecha de terminación
	 * @param strTiempoReal
	 *            Tiempo real de instrucción
	 * @return Regresa True su hay instrucciones o false en caso contrario
	 */
	public static boolean getTerminaInstruccionInsformativa(
			String strIdInstruccion, String strFechaTerminacion,
			int strTiempoReal) {
		int r = 0;
		try {
			String strSql = SQLInstrucciones.getTerminaInstruccionInsformativa(
					strIdInstruccion, strFechaTerminacion, strTiempoReal);
			// //System.out.println("getTerminaInstruccionInsformativa:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("getTerminaInstruccionInsformativa:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Muestra el detalle de una instrucción
	 * 
	 * @param strIdAsunto
	 *            Id asunto
	 * @return Lista con el detalle de una instrucción
	 */
	public static String[][] getInstruccionesDetalle(String strIdAsunto) {
		try {
			String sql = SQLInstrucciones.getInstruccionesDetalle(strIdAsunto);
			return ConexionDS.ejecutarSQL(sql);
		} catch (SQLException sqle) {
			// System.out.println("getInstruccionesDetalle:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	public static String[][] getInstruccionesMail(String strIdAsunto) {
		try {
			String sql = SQLInstrucciones.getInstruccionesMail(strIdAsunto);
			return ConexionDS.ejecutarSQL(sql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query, donde se muestra el avance de una
	 * instuccion
	 * 
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @return Lista de avances de instrucción
	 */
	public static String getAvance(String strIdInstruccion) {
		try {
			String sql = SQLInstrucciones.getAvance(strIdInstruccion);
			String strResult[][] = ConexionDS.ejecutarSQL(sql);
			// //System.out.println("getAvance="+strResult[0][0]);
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
	 * Actualiza el registro de la isntruccion, si el responsable de la misma la
	 * ha consultado por primera vez
	 * 
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @return Indicador que muestra si el responsable de la misma la ha
	 *         consultado por primera vez true - existe false - no existes
	 */
	public static boolean updateBandera(String strIdInstruccion) {
		int r = 0;
		try {
			String strSql = SQLInstrucciones.updateBandera(strIdInstruccion);
			// //System.out.println("updateBandera:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("updateBandera:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Obtiene el Id de usuario que turno la instrucción
	 * 
	 * @param strIdInstruccion
	 *            Id de instrucción
	 * @return Id de usuario que turno la instrucción
	 */
	public static String getTurnador(String strIdInstruccion) {
		try {
			String strSql = SQLInstrucciones.getTurnador(strIdInstruccion);
			String strResult1[][] = ConexionDS.ejecutarSQL(strSql);
			if (strResult1 != null && strResult1.length > 0)
				return strResult1[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getTurnador:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query para verificar si la instruccion padre
	 * tienes intrucuones hijas para turnar
	 * 
	 * @param idInstruccion
	 *            Id instrucción
	 * @return Indicador que muestra si la instrucción tiene instrucciones hijas
	 *         true - existe false - no existes
	 */
	public static boolean getTieneHijosPorTurnar(String idInstruccion) {
		try {
			String strsql = SQLInstrucciones
					.getTieneHijosPorTurnar(idInstruccion);
			// //System.out.println("getTieneHijos:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getTieneHijos:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Función que ejecuta un query para mostrar el id del asduntos original
	 * 
	 * @param strIdAsunto
	 *            Id asunto
	 * @return Id del asduntos original
	 */
	public static String getIdAreaOrigen(String strIdAsunto) {
		try {
			String strSql = SQLInstrucciones.getIdAreaOrigen(strIdAsunto);
			// //System.out.println("getIdAreaOrigen:"+strSql);
			String strResult1[][] = ConexionDS.ejecutarSQL(strSql);
			if (strResult1 != null && strResult1.length > 0)
				return strResult1[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getIdAreaOrigen:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query para mostrar el id del asduntos original
	 * 
	 * @param strIdInstPadre
	 *            Id instrucción padre
	 * @return Regresa el Id del asduntos original
	 */
	public static String getIdAreaOrigenInst(String strIdInstPadre) {
		try {
			String strSql = SQLInstrucciones
					.getIdAreaOrigenInst(strIdInstPadre);
			// //System.out.println("getIdAreaOrigenInst:"+strSql);
			String strResult1[][] = ConexionDS.ejecutarSQL(strSql);
			if (strResult1 != null && strResult1.length > 0)
				return strResult1[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getIdAreaOrigenInst:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene el folio de un área
	 * 
	 * @param strIdAsunto
	 *            Id asunto
	 * @return el folio de área
	 */
	public static String[][] getAreaFoleo(String strIdAsunto) {
		try {
			String strsql = SQLInstrucciones.getAreaFoleo(strIdAsunto);
			// //System.out.println("getAreaFoleo:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAreaFoleo:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene folio de entrada de una instrucción
	 * 
	 * @param strInstruccion
	 *            id de instrucción
	 * @return Indicador para saber si existe el folio true - existe false - no
	 *         existes
	 */
	public static boolean getExisteFolioEntradaInstruccion(String strInstruccion) {
		try {
			String strsql = SQLInstrucciones
					.getExisteFolioEntradaInstruccion(strInstruccion);
			// //System.out.println("getExisteFolioEntradaInstruccion:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 1)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExisteFolioEntradaInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Obtiene folio de salida de una instrucción
	 * 
	 * @param strInstruccion
	 *            Id de instrucción
	 * @return Indicador para saber si existe el folio true - existe false - no
	 *         existes
	 */
	public static boolean getExisteFolioSalidaInstruccion(String strInstruccion) {
		try {
			String strsql = SQLInstrucciones
					.getExisteFolioSalidaInstruccion(strInstruccion);
			// //System.out.println("getExisteFolioSalidaInstruccion:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 1)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExisteFolioSalidaInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Asigna un folio de entrada
	 * 
	 * @param strFolio
	 *            Folio a asignar
	 * @param stridInstruccion
	 *            Id de instrucción
	 * @return Retorna una bandera que indica el éxito de la operación
	 */
	public static boolean setFolioEntrada(String strFolio,
			String stridInstruccion) {
		int r = 0;
		try {
			String strsql = SQLInstrucciones.setFolioEntrada(strFolio,
					stridInstruccion);
			// //System.out.println("setFolioEntrada:"+strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			// System.out.println("setFolioEntrada:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Verifica si existe un folio de entrada para una instrucción
	 * 
	 * @param stridArea
	 *            Id área
	 * @return Indicador para saber si existe el folio true - existe false - no
	 *         existes
	 */
	public static boolean getExistenFolioEntradaInst(String stridArea) {
		try {
			String strsql = SQLInstrucciones
					.getExistenFolioEntradaInst(stridArea);
			// //System.out.println("getExistenFolioEntradaInst:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExistenFolioEntradaInst:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica si existe un folio de entrada
	 * 
	 * @param strIdArea
	 *            Id área
	 * @return Indicador para saber si existe el folio true - existe false - no
	 *         existes
	 */
	public static boolean getExisteFolioEntradaAsunto(String strIdArea) {
		try {
			String strsql = SQLInstrucciones
					.getExisteFolioEntradaAsunto(strIdArea);
			// //System.out.println("getExisteFolioEntradaAsunto:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExisteFolioEntradaAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica si existe un folio de salida
	 * 
	 * @param stridArea
	 *            id de área
	 * @return Indicador para saber si existe el folio true - existe false - no
	 *         existes
	 */
	public static boolean getExisteFolioSalida(String stridArea) {
		try {
			String strsql = SQLInstrucciones.getExisteFolioSalida(stridArea);
			// //System.out.println("getExisteFolioSalida:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExisteFolioSalida:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Obtiene el folio de entrada por instrucción
	 * 
	 * @param getFolioEntradasInst
	 *            Folio de entrada
	 * @param strOrden
	 *            Orden
	 * @param tipo
	 *            Tipo
	 * @return retorna un arreglo con el folio de salida
	 */
	public static String[][] getFolioEntradasInst(String getFolioEntradasInst,
			String strOrden, String tipo) {
		try {
			String strsql = SQLInstrucciones.getFolioEntradasInst(
					getFolioEntradasInst, strOrden, tipo);
			// //System.out.println("getFolioEntradasInst:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getFolioEntradasInst:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene el folio de entrada por asunto
	 * 
	 * @param strIdArea
	 *            Id área
	 * @param strOrden
	 *            Orden
	 * @param strTipo
	 *            Tipo
	 * @return retorna un arreglo con el folio de salida
	 */
	public static String[][] getFolioEntradaAsunto(String strIdArea,
			String strOrden, String strTipo) {
		try {
			String strsql = SQLInstrucciones.getFolioEntradaAsunto(strIdArea,
					strOrden, strTipo);
			// //System.out.println("getFolioEntradaAsunto:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getFolioEntradaAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene el folio de salida por asunto
	 * 
	 * @param strIdArea
	 *            Id área
	 * @param strOrden
	 *            Orden
	 * @param strTipo
	 *            Tipo
	 * @return retorna un arreglo con el folio de salida
	 */
	public static String[][] getFolioSalida(String strIdArea, String strOrden,
			String strTipo) {
		try {
			String strsql = SQLInstrucciones.getFolioSalida(strIdArea,
					strOrden, strTipo);
			// //System.out.println("getFolioSalida:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getFolioSalida:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene la última instrucción padre
	 * 
	 * @return instrucción padre
	 */
	public synchronized static String getUltimoIdInsPadre() {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLInstrucciones
					.getUltimoIdInsPadre());
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que carga instrucciones a partir del para y cc
	 * 
	 * @param vIdspara
	 *            Id usuarios "para"
	 * @param IdsCC
	 *            id usuarios "cc"
	 * @param strIdAsunto
	 *            Id asunto
	 */

	/**
	 * Función que carga instrucciones a partir del para y cc
	 * 
	 * @param vIdspara
	 *            Vector con ID's destinatarios Para
	 * @param IdsCC
	 *            Vector con ID 's destinatarios CC
	 * @param strIdAsunto
	 *            ID de Asunto
	 * @param strIdPaso
	 *            ID pasos
	 * @param strIdAreaOrigen
	 *            ID de la UA
	 * @param strFechaCompromiso
	 *            Fecha compromiso
	 * @param strTipoFolio
	 *            Tipo de folio
	 * @param vIdsExt
	 *            Vector destinatarios Externos
	 * @param strFechaRecepcion
	 *            Fecha de Recepción
	 * @return Regresa true si la actualizacion fue exitosa o false en caso
	 *         contrario
	 */
	public static boolean insertarInstruccionParaCC(Vector vIdspara,
			Vector IdsCC, String strIdAsunto, String strIdPaso,
			String strIdAreaOrigen, String strFechaCompromiso,
			String strTipoFolio, Vector vIdsExt, String strFechaRecepcion) {
		boolean bNoTieneAtencion = false;
		String strAreaOrigen = strIdAreaOrigen;
		Vector vIdsAr = new Vector();
		Vector vIdsArCC = new Vector();
		Vector vIdsUs = new Vector();
		Vector vIdsIns = new Vector();
		Vector vIdsUsCC = new Vector();
		Vector vAtencion = new Vector();// Vector con instrucciones de atencion
		Vector vIdsExternos = new Vector();// Vector con los ids de areas
		// externas
		Vector vIdsExtDes = new Vector();
		String strIdTurna[][] = null;
		int r = 0;

		// **Calculo tiempo asignado a instrucciones
		Calendar FI = Utilerias.StringCalendar(strFechaRecepcion);
		Calendar FF = Utilerias.StringCalendar2(strFechaCompromiso);
		int iDuracion = Utilerias.getDuracion(FI, FF);
		int iDuracion1 = Utilerias.getSinDiasFestivos(FI, FF);
		int iSuma = iDuracion - iDuracion1;
		String strDuracion = String.valueOf(iSuma);
		// **Fin Calculo tiempo asignado a instrucciones

		try {
			// Ejecuta las instrucciones para
			for (int i = 0; i < vIdspara.size(); i++) {

				String strIdArea = ActualizaUsuario
						.getIdAreaUs((String) vIdspara.elementAt(i));
				if (strIdArea != null) {
					if (strIdArea.equals(strAreaOrigen)) {
						String strSql = SQLInstrucciones
								.insertaInstruccionParaCC((String) vIdspara
										.elementAt(i), strIdAsunto, "0",
										strIdPaso, "", strDuracion, "");
						r = ConexionDS.ejecutarActualizacion(strSql);
					} else {
						if (ActualizaArea.getEsAreaExterna(strIdArea)) {// Instrucciones
							// Externas
							vIdsExternos.add(vIdspara.elementAt(i));
						} else {// Instrucciones de otras área
							vIdsUs.add((String) vIdspara.elementAt(i));
							vAtencion.add("" + 0);
							if (vIdsAr.contains(strIdArea)) {
							} else {
								vIdsAr.add(strIdArea);
							}
						}
					}
				}

			}

			// Ejecuta las instrucciones CC
			for (int i = 0; i < IdsCC.size(); i++) {
				String strIdArea = ActualizaUsuario.getIdAreaUs((String) IdsCC
						.elementAt(i));
				if (strIdArea != null) {
					if (strIdArea.equals(strAreaOrigen)) {
						String strSql = SQLInstrucciones
								.insertaInstruccionParaCC((String) IdsCC
										.elementAt(i), strIdAsunto, "1",
										strIdPaso, "", strDuracion, "");
						r = ConexionDS.ejecutarActualizacion(strSql);
					} else {
						if (ActualizaArea.getEsAreaExterna(strIdArea)) {// Instrucciones
							// Externas
							vIdsExternos.add(IdsCC.elementAt(i));
						} else {// Instrucciones de otras área
							vIdsUs.add((String) IdsCC.elementAt(i));
							vAtencion.add("" + 1);
							if (vIdsAr.contains(strIdArea)) {
							} else {
								vIdsAr.add(strIdArea);
							}
						}
					}
				}
			}// fin Ejecuta las instrucciones CC

			// Verifica si las instrucciones son externas y crea una sola
			// instruccion
			// para que sean atendidas por un usuario
			int contador = 0;
			if (vIdsExternos.size() > 0) {
				contador++;
			}

			// if(vIdsExtDes.size()>0){vIdsExt
			if (vIdsExt.size() > 0) {
				contador++;
			}

			if (strTipoFolio.equals("1")) {
				if (contador > 0) {
					String strUsrDesExt[][] = ActualizaUsuario
							.getUsuarioDesExt(strAreaOrigen);
					if (strUsrDesExt.length == 0) {
						bNoTieneAtencion = true;
					} else {
						String strSql = SQLInstrucciones
								.insertaInstruccionParaCC(strUsrDesExt[0][0],
										strIdAsunto, "0", strIdPaso, "",
										strDuracion,
										"Enviar Documentación a los Destinatarios Externos a SIGA");
						r = ConexionDS.ejecutarActualizacion(strSql);
						bNoTieneAtencion = false;
					}
				}
			}

			if (strTipoFolio.equals("1")) {
				for (int i = 0; i < vIdsAr.size(); i++) {
					strIdTurna = ActualizaUsuario
							.getIdUsuarioTurnador((String) vIdsAr.get(i));
					String strSql = SQLInstrucciones.insertaInstruccionParaCC(
							strIdTurna[0][0], strIdAsunto, "0", strIdPaso, "",
							strDuracion, "");
					r = ConexionDS.ejecutarActualizacion(strSql);
					String strIdInstruccion = ActualizaInstrucciones
							.getUltimoIdInsPadre();
					vIdsIns.add(strIdInstruccion);
				}
			}
		} catch (SQLException sqle) {
			// System.out.println("insertarInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
		}
		// Condicionado pendiente
		if (strTipoFolio.equals("1")) {
			setInsertarInsHijas(vIdsIns, vIdsUs, vIdsAr, strIdAsunto,
					strIdPaso, vAtencion, strDuracion);
		}

		return bNoTieneAtencion;
	}

	/**
	 * Inserta instrucciones hijas
	 * 
	 * @param vIdsIns
	 *            Instrucciones
	 * @param vIdsUs
	 *            Usuarios
	 * @param IdsArea
	 *            áreas
	 * @param strIdAsunto
	 *            Id asunto
	 * @param strIdPaso
	 *            Id Paso
	 * @param vAtencion
	 *            atención
	 * @param strDuracion
	 *            duración
	 */
	public static void setInsertarInsHijas(Vector vIdsIns, Vector vIdsUs,
			Vector IdsArea, String strIdAsunto, String strIdPaso,
			Vector vAtencion, String strDuracion) {
		int r = 0;
		try {
			for (int i = 0; i < vIdsUs.size(); i++) {
				String strIdArea = ActualizaUsuario.getIdAreaUs((String) vIdsUs
						.elementAt(i));
				for (int j = 0; j < IdsArea.size(); j++) {
					if (IdsArea.get(j).equals(strIdArea)) {

						String strSql = SQLInstrucciones
								.insertaInstruccionParaCC((String) vIdsUs
										.elementAt(i), strIdAsunto,
										(String) vAtencion.get(i), strIdPaso,
										(String) vIdsIns.get(j), strDuracion,
										"");
						r = ConexionDS.ejecutarActualizacion(strSql);
						break;
					}
				}
			}
		} catch (SQLException sqle) {
			// System.out.println("setInsertarInsHijas:"+sqle.getMessage());
			sqle.printStackTrace();
		}
	}

	/**
	 * Obtine el estatus de la una instruccion
	 * 
	 * @param strIdAsunto
	 *            id asunto
	 * @return retorna el estatus
	 */
	public static String[][] getEstatusInstrucciones(String strIdAsunto) {
		try {
			String strsql = SQLInstrucciones
					.getEstatusInstrucciones(strIdAsunto);
			// System.out.println("ActualizaInstrucciones.getEstatusInstrucciones:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getEstatusInstrucciones:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene instrucciones vacías
	 * 
	 * @param strIdAsunto
	 *            Id asunto
	 * @return indicador paras saber si estan vacias las instrucciones
	 */
	public static boolean getInstruccionesVacias(String strIdAsunto) {
		String strDatos[][] = null;
		boolean bEstanVacios = false;
		try {
			String strsql = SQLInstrucciones
					.getInstruccionesVacias(strIdAsunto);
			strDatos = ConexionDS.ejecutarSQL(strsql);
			if (strDatos.length == 0
					|| ((strDatos[0][0].length() == 0 && strDatos[0][0] != null)
							&& (strDatos[0][1].length() == 0 && strDatos[0][1] != null) && strDatos.length > 0)) {

				bEstanVacios = true;
				return bEstanVacios;
			} else {
				bEstanVacios = false;
				return bEstanVacios;
			}
			// return bEstanVacios;
		} catch (SQLException sqle) {
			// System.out.println("getInstruccionesVacias:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		// return bEstanVacios;
	}

	/**
	 * Obtiene instrucciones vacías
	 * 
	 * @param strIdAsunto
	 *            Id asunto
	 * @return indicador paras saber si estan vacias las instrucciones
	 */
	public static boolean getInstruccionesVacias(String strDatos[][]) {
		for (int i = 0; i < strDatos.length; i++) {
			if (strDatos[i][3] == null || "".equals(strDatos[i][3].trim())) {
				if (strDatos.length == 0
						|| ((strDatos[i][0].length() != 0 && strDatos[i][0] != null) && ((""
								.equals(strDatos[i][2].trim())) && strDatos[i][2] != null))) {
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * Obtiene instrucciones hijas vacias
	 * 
	 * @param strIdPadre
	 *            Id instrucción padre
	 * @return indicador paras saber si estan vacias las instrucciones
	 */
	public static boolean getInstruccionHijasVacias(String strIdPadre) {
		String strDatos[][] = null;
		boolean bEstanVacios = false;
		try {
			String strsql = SQLInstrucciones
					.getInstruccionHijasVacias(strIdPadre);
			// //System.out.println("getInstruccionHijasVacias:"+strsql);
			strDatos = ConexionDS.ejecutarSQL(strsql);
			if (strDatos.length == 0
					|| ((strDatos[0][0].length() == 0 && strDatos[0][0] != null)
							&& (strDatos[0][1].length() == 0 && strDatos[0][1] != null) && strDatos.length == 1)) {
				bEstanVacios = true;
				return bEstanVacios;
			} else {
				bEstanVacios = false;
				return bEstanVacios;
			}
			// return bEstanVacios;
		} catch (SQLException sqle) {
			// System.out.println("getInstruccionHijasVacias:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		// return bEstanVacios;
	}

	/**
	 * Obtiene lista de instrucciones por atender de un usuario - asunto
	 * 
	 * @param strIdUsuario
	 *            ID de Usuario
	 * @param strOrden
	 *            Orden (ordenamiento)
	 * @param strTipo
	 *            Tipo (ordenamiento)
	 * @param strIdArea
	 *            ID del Area
	 * @param iBandera
	 *            Bandera de la instrucción
	 * @return arreglo de instrucciones
	 */
	public static String[][] getInstruccionAtenderUsuarioAsunto(
			String strIdUsuario, String strOrden, String strTipo,
			String strIdArea, int iBandera) {
		try {
			String strsql = SQLInstrucciones
					.getInstruccionAtenderUsuarioAsunto(strIdUsuario, strOrden,
							strTipo, strIdArea, iBandera);
			// //System.out.println("getInstruccionAtenderUsuarioAsunto:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getInstruccionAtenderUsuarioAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene las instrucciones Trámite por Usuario-Asunto
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @param strOrden
	 *            Orden
	 * @param strTipo
	 *            Tipo
	 * @param strIdArea
	 *            Id área
	 * @param iBandera
	 *            Bandera
	 * @return Un arreglo que contiene las instrucciones Trámite
	 */
	public static String[][] getInstruccionTramiteUsuarioAsunto(
			String strIdUsuario, String strOrden, String strTipo,
			String strIdArea, int iBandera) {
		try {
			String strsql = SQLInstrucciones
					.getInstruccionTramiteUsuarioAsunto(strIdUsuario, strOrden,
							strTipo, strIdArea, iBandera);
			// //System.out.println("getInstruccionTramiteUsuarioAsunto:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getInstruccionTramiteUsuarioAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene las instrucciones terminadas por Usuario-Asunto
	 * 
	 * @param strIdUsuario
	 *            ID usuario
	 * @param strOrden
	 *            Orden
	 * @param strTipo
	 *            Tipo de ordenamiento
	 * @param strIdArea
	 *            ID Area
	 * @param iBandera
	 *            Bandera
	 * @return Un arreglo que contiene las instrucciones terminadas
	 */
	public static String[][] getInstruccionTerminadaUsuarioAsunto(
			String strIdUsuario, String strOrden, String strTipo,
			String strIdArea, int iBandera) {
		try {
			String strsql = SQLInstrucciones
					.getInstruccionTerminadaUsuarioAsunto(strIdUsuario,
							strOrden, strTipo, strIdArea, iBandera);
			// //System.out.println("getInstruccionTerminadaUsuarioAsunto:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getInstruccionTerminadaUsuarioAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función qeu ejecuta un query que determina si tiene Instrucciones por
	 * atender
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return True si existen, False no existen
	 */
	public static boolean TieneInstruccionesPorAtenderAsunto(String strIdUsuario) {
		try {
			String strsql = SQLInstrucciones
					.TieneInstruccionesPorAtenderAsunto(strIdUsuario);
			// //System.out.println("TieneInstruccionesPorAtenderAsunto:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("TieneInstruccionesPorAtenderAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Función qeu ejecuta un query que determina si tiene Instrucciones en
	 * tramite
	 * 
	 * @param strIdUsuario
	 *            id usuario
	 * @return True si existen, False no existen
	 */
	public static boolean TieneInstruccionesEnTramiteAsunto(String strIdUsuario) {
		try {
			String strsql = SQLInstrucciones
					.TieneInstruccionesEnTramiteAsunto(strIdUsuario);
			// //System.out.println("TieneInstruccionesEnTramiteAsunto:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("TieneInstruccionesEnTramiteAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Función qeu ejecuta un query que determina si tiene Instrucciones
	 * terminadas
	 * 
	 * @param strIdUsuario
	 *            Id de usuario
	 * @return True si existen, False no existen
	 */
	public static boolean TieneInstruccionesTerminadasAsunto(String strIdUsuario) {
		try {
			String strsql = SQLInstrucciones
					.TieneInstruccionesTerminadasAsunto(strIdUsuario);
			// //System.out.println("TieneInstruccionesTerminadasAsunto:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;

			// //System.out.println("="+false);
			return false;
		} catch (SQLException sqle) {
			// System.out.println("TieneInstruccionesTerminadasAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Inserta en el avance de una instrucción Padre
	 * 
	 * @param strIdInstruccion
	 *            Id de instrucción
	 * @param strAvance
	 *            Avance instrucción
	 * @param strEstatus
	 *            Estatus instrucción
	 * @param firmarDigitalmente
	 *            Firma Digital
	 * @param fechaTerminacionReal
	 *            Fecha de terminación
	 * @param strIdUsuario
	 *            ID de Usuario
	 * @return Retorna una bandera que indica el éxito de la operación
	 */
	public static boolean avanceInstruccionPadre(String strIdInstruccion,
			String strAvance, String strEstatus, String firmarDigitalmente,
			String fechaTerminacionReal, String strIdUsuario) {
		int r = 0;
		try {
			String strSql = SQLInstrucciones.avanceInstruccionPadre(
					strIdInstruccion, strAvance, strEstatus,
					firmarDigitalmente, fechaTerminacionReal, strIdUsuario);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta en el avance de una instrucción hija
	 * 
	 * @param strIdInstruccion
	 *            Id de instrucción
	 * @param strAvance
	 *            Avance instrucción
	 * @param strEstatus
	 *            Estatus instrucción
	 * @param firmarDigitalmente
	 *            Firma Digital
	 * @param fechaTerminacionReal
	 *            Fecha de terminación
	 * @param strIdUsuario
	 *            ID de Usuario
	 * @return Retorna una bandera que indica el éxito de la operación
	 */
	public static boolean avanceInstruccionHija(String strIdInstruccion,
			String strAvance, String strEstatus, String firmarDigitalmente,
			String fechaTerminacionReal, String strIdUsuario) {
		int r = 0;
		try {
			String strSql = SQLInstrucciones.avanceInstruccionPadre(
					strIdInstruccion, strAvance, strEstatus,
					firmarDigitalmente, fechaTerminacionReal, strIdUsuario);
			// //System.out.println("avanceInstruccionHija:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("avanceInstruccionHija:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Función que ejecuta un query con los tiempos de las instrucciones
	 * normales
	 * 
	 * @param stridAsunto
	 *            Id asunto
	 * @return lista con tiempo de instrucciones
	 */
	public static String[][] getTiempos(String stridAsunto) {
		try {
			String strsql = SQLInstrucciones.getTiempos(stridAsunto);
			// //System.out.println("getTiempos:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getTiempos:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Valida si tiene Instrucciones rechazadas por atender
	 * 
	 * @param strIdTurnador
	 *            Id turnador
	 * @return indicador para verificar si existen instrucciones rechazadas
	 */
	public static boolean existeInstruccionesRechazadasPorAtender(
			String strIdTurnador) {
		try {
			String strsql = SQLInstrucciones
					.existeInstruccionesRechazadasPorAtender(strIdTurnador);
			// //System.out.println("existeInstruccionesRechazadasPorAtender:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;

			// //System.out.println("="+false);
			return false;
		} catch (SQLException sqle) {
			// System.out.println("existeInstruccionesRechazadasPorAtender:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Función que ejecuta un query que trae una lista de los usuarios que han
	 * rechazado alguna instrucción POR TURNADOR
	 * 
	 * @param strIdTurnador
	 *            Id turnador
	 * @return lista de ususarios
	 */
	public static String[][] UsuarioInstruccionRechazadaPorTurnador(
			String strIdTurnador) {
		try {
			String strsql = SQLInstrucciones
					.UsuarioInstruccionRechazadaPorTurnador(strIdTurnador);
			// //System.out.println("UsuarioInstruccionRechazadaPorTurnador:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("UsuarioInstruccionRechazadaPorTurnador:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Regresa todos los usuarios de atencion con instrucciones rechazadas
	 * 
	 * @param strIdArea:
	 *            ID del area
	 * @return String[][] con los valores
	 */
	public static String[][] UsuarioInstruccionRechazadaPorArea(String strIdArea) {
		try {
			String strsql = SQLInstrucciones
					.UsuarioInstruccionRechazadaPorArea(strIdArea);
			// System.out.println("UsuarioInstruccionRechazadaPorArea:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("UsuarioInstruccionRechazadaPorArea:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene Subordinados por puesto
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return lista de subordinados
	 */
	public static String[][] getSub1(String strIdUsuario, String idArea) {

		String strUsuario[][] = null;
		String subordinadosDirectos[][] = null;
		String subordinadosOtraUa[][] = null;
		Vector vIds = new Vector();
		// **Verifica si el usuario es un titular de una UA
		String esTitular = "0";// ActualizaArea.esEncargadoUA(idArea,
		// strIdUsuario);

		if (esTitular.equals("1")) {

			// **Instrucciones del Usuario
			strUsuario = ActualizaInstrucciones
					.UsuarioInstruccionAtender(strIdUsuario);

			// **Instrucciones de sus subordinados directos
			subordinadosDirectos = ActualizaUsuario.getSubordinadosDirectos(
					strIdUsuario, idArea);

			// **Instrucciones de sus subordinados de UA's Hijas
			subordinadosOtraUa = ActualizaUsuario.getSubordinadosOtraUA(
					strIdUsuario, idArea);

			AsignarArbol tree = new AsignarArbol(subordinadosDirectos);
			vIds = tree.getIds();
		} else if (esTitular.equals("0")) {
			// **Instrucciones del Usuario
			strUsuario = ActualizaInstrucciones
					.UsuarioInstruccionAtender(strIdUsuario);

			// **Instrucciones de sus subordinados directos
			subordinadosDirectos = ActualizaUsuario
					.getSubordinados(strIdUsuario);

			AsignarArbol tree = new AsignarArbol(subordinadosDirectos);
			vIds = tree.getIds();
		}

		// **variable que aloja a los subordinados directos
		String strResultado[][] = null;

		// **Variable que alojara las instrucciones del puesto que consulta +
		// **los subordinados directos
		String strDatos[][] = null;

		// **Variable que alojara las instrucciones del puesto que consulta +
		// **los subordinados directos + las UA's hijas
		String arregloFinal[][] = null;

		strResultado = new String[vIds.size()][1];
		for (int i = 0; i < vIds.size(); i++) {
			strResultado[i][0] = (String) vIds.elementAt(i);
		}

		// **Inserta en strDatos las instrucciones del usuario
		// **y las de sus subordinados
		if (strUsuario.length + strResultado.length > 0) {
			strDatos = new String[strUsuario.length + strResultado.length][1];// [strUsuario[0].length];
			for (int i = 0; i < strDatos.length; i++) {
				if (i < strUsuario.length)
					strDatos[i] = strUsuario[i];
				else
					strDatos[i] = strResultado[i - strUsuario.length];
			}
		}

		if (esTitular.equals("1")) {
			// **Inserta en strDatos las instrucciones del usuario y
			// subordinasos
			// **mas el nombre de las UA's
			if (strDatos != null && strDatos.length > 0) {
				if (subordinadosOtraUa.length + strDatos.length > 0) {
					arregloFinal = new String[subordinadosOtraUa.length
							+ strDatos.length][1];// [strUsuario[0].length];
					for (int i = 0; i < arregloFinal.length; i++) {
						if (i < strDatos.length)
							arregloFinal[i] = strDatos[i];
						else
							arregloFinal[i] = subordinadosOtraUa[i
									- strDatos.length];
					}
				}
			} else {
				if (subordinadosOtraUa.length > 0) {
					arregloFinal = new String[subordinadosOtraUa.length][1];// [strUsuario[0].length];
					for (int i = 0; i < arregloFinal.length; i++) {
						arregloFinal[i] = subordinadosOtraUa[i];
					}
				}
			}
			return arregloFinal;
		} else {
			return strDatos;
		}
		// return arregloFinal;
	}

	/**
	 * Obtiene Subordinados por puesto
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return lista de subordinados
	 */
	public static String[][] getSub2(String strIdUsuario) {

		String strUsuario[][] = ActualizaInstrucciones
				.UsuarioInstruccionTramite(strIdUsuario);
		String strUsuarios[][] = ActualizaUsuario.getSubordinados(strIdUsuario);
		AsignarArbol tree = new AsignarArbol(strUsuarios);
		Vector vNombres1 = new Vector();
		Vector vIds = new Vector();
		vIds = tree.getIds();
		String strResultado[][] = null;
		String strDatos[][] = null;
		strResultado = new String[vIds.size()][1];
		for (int i = 0; i < vIds.size(); i++) {
			strResultado[i][0] = (String) vIds.elementAt(i);
		}
		if (strUsuario.length + strResultado.length > 0) {
			strDatos = new String[strUsuario.length + strResultado.length][1];// [strUsuario[0].length];
			for (int i = 0; i < strDatos.length; i++) {
				if (i < strUsuario.length)
					strDatos[i] = strUsuario[i];
				else
					strDatos[i] = strResultado[i - strUsuario.length];
			}
		}
		return strDatos;
	}

	/**
	 * Obtiene Subordinados por puesto
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return lista de subordinados
	 */
	public static String[][] getSub3(String strIdUsuario) {

		String strUsuario[][] = ActualizaInstrucciones
				.UsuarioInstruccionTerminada(strIdUsuario);
		String strUsuarios[][] = ActualizaUsuario.getSubordinados(strIdUsuario);
		AsignarArbol tree = new AsignarArbol(strUsuarios);
		Vector vNombres1 = new Vector();
		Vector vIds = new Vector();
		vIds = tree.getIds();
		String strResultado[][] = null;
		String strDatos[][] = null;
		strResultado = new String[vIds.size()][1];
		for (int i = 0; i < vIds.size(); i++) {
			strResultado[i][0] = (String) vIds.elementAt(i);
		}
		if (strUsuario.length + strResultado.length > 0) {
			strDatos = new String[strUsuario.length + strResultado.length][1];// [strUsuario[0].length];
			for (int i = 0; i < strDatos.length; i++) {
				if (i < strUsuario.length)
					strDatos[i] = strUsuario[i];
				else
					strDatos[i] = strResultado[i - strUsuario.length];
			}
		}
		return strDatos;
	}

	/**
	 * Obtiene la instrucción habilitada para delegar instrucciones multiples
	 * 
	 * @param strIdInstruccion
	 *            id de instrucción
	 * @return instrucción
	 */
	public static String getHabilitado(String strIdInstruccion) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLInstrucciones
					.getHabilitado(strIdInstruccion));
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getHabilitado:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene la instrucción habilitada para delegar instrucciones multiples
	 * 
	 * @param strIdInstruccion
	 *            id de instrucción
	 * @return instrucción
	 */
	public static String getUsuario(String strIdInstruccion) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLInstrucciones
					.getHabilitado(strIdInstruccion));
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getUsuario:"+sqle.getMessage());
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
			// //System.out.println("getAvance="+strResult[0][0]);
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
	 * Obtiene el último folio formado
	 * 
	 * @param strIdPadre
	 *            id instrucción padre
	 * @return último folio
	 */
	public static String getFolioUltimoFormadoInst(String strIdPadre) {
		String SQL = "SELECT COUNT(*) FROM SD_INSTRUCCION_ASUNTO WHERE INS_PADRE="
				+ strIdPadre + " AND INS_ESTATUS <> 0";
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQL);
			// //System.out.println("getFolioUltimoFormadoInst="+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return "0";
		} catch (SQLException sqle) {
			// System.out.println("getFolioUltimoFormadoInst:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Ejecuta una consulta para saber si tiene acceso a la instrucción o asunto
	 * padre
	 * 
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @return regresa una lista con los accesos permitidos
	 */
	public static String[][] getPermiso(String strIdInstruccion) {
		try {
			String strsql = SQLInstrucciones.getPermiso(strIdInstruccion);
			// //System.out.println("getPermiso:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getPermiso:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene el usuario que dio termino a una instrucción
	 * 
	 * @param strIdInstruccion
	 *            ID de instrucción
	 * @return un arreglo con el id de usuario
	 */
	public static String getUsuarioTermino(String strIdInstruccion) {
		String SQL = "SELECT INS_USUARIO_TERMINO FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="
				+ strIdInstruccion + "";
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQL);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return "";
		} catch (SQLException sqle) {
			// System.out.println("getUsuarioTermino:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualiza el cambio de la fecha de un asolicitud de cambio
	 * 
	 * @param strIdInstruccion
	 *            Id de instrucción
	 * @return retorna una bandera que indica el éxito de la operación
	 */
	public static boolean actualizaRechazoCambio(String strIdInstruccion) {
		int r = 0;
		try {
			String strSql = SQLInstrucciones
					.actualizaRechazoCambio(strIdInstruccion);
			// //System.out.println("actualizaRechazoCambio:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("actualizaRechazoCambio:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Función que muestra la bandera de una instruccion
	 * 
	 * @param strIdInstruccion
	 *            Id de instrucción
	 * @return regresa un indicador
	 */
	public static String getbandera(String strIdInstruccion) {
		String SQL = "SELECT INS_BANDERA1 FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="
				+ strIdInstruccion + "";
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQL);
			// //System.out.println("getbandera="+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return "";
		} catch (SQLException sqle) {
			// System.out.println("getbandera:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualiza el tiempo de vida de una instrucción
	 * 
	 * @param strIdAsunto
	 *            Id de asunto
	 * @param strDuracion
	 *            duración
	 * @return retorna una bandera que indica el éxito de la operación
	 */
	public static boolean updateTiempoInst(String strIdAsunto,
			String strDuracion) {
		int r = 0;
		try {
			String strSql = SQLInstrucciones.updateTiempoInst(strIdAsunto,
					strDuracion);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Obtiene la secuencia máxima de una secuencia
	 * 
	 * @param strIdAsunto
	 *            id asunto
	 * @return la secuencia máxima
	 */
	public static String getMaxPasos(String strIdAsunto) {
		try {
			String sql = SQLInstrucciones.getMaxPasos(strIdAsunto);
			// //System.out.println("getMaxPasos="+sql);
			String strResult[][] = ConexionDS.ejecutarSQL(sql);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return "";
		} catch (SQLException sqle) {
			// System.out.println("getMaxPasos:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene las lista de instrucciones terminadas
	 * 
	 * @param strIdInstruccion
	 *            id instrucción
	 * @return un arreglo con el Número de instrucciones terminadas
	 */
	public static int getInstruccionesTerminadas(String strIdInstruccion) {
		try {
			String sql = SQLInstrucciones
					.getInstruccionesTerminadas(strIdInstruccion);
			// //System.out.println("getInstruccionesTerminadas="+sql);
			String strResult[][] = ConexionDS.ejecutarSQL(sql);
			if (strResult != null && strResult.length > 0)
				return new Integer(strResult[0][0]).intValue();
			return -1;
		} catch (SQLException sqle) {
			// System.out.println("getInstruccionesTerminadas:"+sqle);
			sqle.printStackTrace();
			return -1;
		}
	}

	/**
	 * Obtiene el folio de entrada para reporte
	 * 
	 * @param strIdArea
	 *            id área
	 * @return un arreglo conlos folios de entrada
	 */
	public static String[][] getFolioEntradaReporte(String strIdArea) {
		try {
			String strsql = SQLInstrucciones.getFolioEntradaReporte(strIdArea);
			// //System.out.println("getFolioEntradaReporte:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getFolioEntradaReporte:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Regresa 0 si el área o UA aplica el turnado por subventanilla
	 * 
	 * @param strIdArea
	 *            Id área
	 * @return 0 Si tiene asiganda la subventanilla, 1 no tiene subventanilla
	 */
	public static String getAreaSubventanilla(String strIdArea) {
		try {
			String sql = SQLInstrucciones.getAreaSubventanilla(strIdArea);
			// //System.out.println("getAreaSubventanilla="+sql);
			String strResult[][] = ConexionDS.ejecutarSQL(sql);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return "";
		} catch (SQLException sqle) {
			// System.out.println("getAreaSubventanilla:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Regresa el Id del Puesto a partir del cual podra turnar
	 * 
	 * @param strIdTurnador
	 *            Id Turnador
	 * @return Id Usuario atención, 0 si no tiene asignado
	 */
	public static String getUsuarioSubventanilla(String strIdTurnador) {
		try {
			String sql = SQLInstrucciones
					.getUsuarioSubventanilla(strIdTurnador);
			// //System.out.println("getAreaSubventanilla="+sql);
			String strResult[][] = ConexionDS.ejecutarSQL(sql);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return "";
		} catch (SQLException sqle) {
			// System.out.println("getUsuarioSubventanilla:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Jefe del turnador
	 * 
	 * @param strIdInstruccion
	 *            Id instruccion
	 * @param strTurnador
	 *            Turnador
	 * @return arreglo
	 */
	public static boolean getTurnadorJefe(String strIdInstruccion,
			String strTurnador) {
		try {
			String strSql[][] = ConexionDS.ejecutarSQL(SQLInstrucciones
					.getTurnadorJefe(strIdInstruccion, strTurnador));

			if (strSql != null && strSql.length > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// System.out.println("getFolioEntradaReporte:"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public static boolean getSupervisorEsArea(String strIdUsOr,
			String strIdSupervisor, boolean bSupervisor) {
		boolean bEsSupervisor = false;
		if (!bSupervisor)
			return false;
		String strAreaOr = ActualizaUsuario.getAreaUsuario(strIdUsOr);
		String strAreaSp = ActualizaUsuario.getAreaUsuario(strIdSupervisor);
		if (strAreaOr.equals(strAreaSp))
			bEsSupervisor = true;
		return bEsSupervisor;
	}

	/**
	 * Regresa el estatus de uns instruccion por su ID
	 * 
	 * @param strIdInstruccion
	 *            ID instruccion
	 * @return String con el estatus de la instruccion
	 */
	public static String getEstatusPorInstruccion(String strIdInstruccion) {
		try {
			String strsql = SQLInstrucciones
					.getEstatusPorInstruccion(strIdInstruccion);
			String resultado[][] = ConexionDS.ejecutarSQL(strsql);
			if (resultado != null && resultado.length > 0) {
				return resultado[0][0];
			}
			return "";
		} catch (SQLException sqle) {
			// System.out.println("getEstatusPorInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * verifica si existen instrucciones para ser mostradar al supervisor
	 * 
	 * @param idArea
	 *            Id del área
	 * @return
	 */
	public static boolean existeInstRechazadasAtenderSup(String idArea) {
		try {
			String strsql = SQLInstrucciones
					.existeInstRechazadasAtenderSup(idArea);
			// //System.out.println("existeInstRechazadasAtenderSup:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0) {
				return (Integer.parseInt(strExpediente[0][0]) > 0);
			}
			return false;
		} catch (SQLException sqle) {
			// System.out.println("existeInstRechazadasAtenderSup:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Devuelve el Id del usuario titular de la instrucción
	 * 
	 * @param idInstruccion
	 *            Id Instruccion
	 * @return Query
	 */
	public static String getIdUsuarioInstruccion(String idInstruccion) {
		try {
			String strsql = SQLInstrucciones
					.getIdUsuarioInstruccion(idInstruccion);
			String resultado[][] = ConexionDS.ejecutarSQL(strsql);
			if (resultado != null && resultado.length > 0) {
				return resultado[0][0];
			}
			return "";
		} catch (SQLException sqle) {
			// System.out.println("getIdUsuarioInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	public static boolean TieneInstruccionesPorAtenderUsuario(String idUsuario) {
		String[][] rs = null;
		boolean resultado = false;
		try {
			rs = ConexionDS.ejecutarSQL(SQLInstrucciones
					.TieneInstruccionesPorAtender(idUsuario));
			resultado = Integer.parseInt(rs[0][0]) > 0 ? true : false;
		} catch (Exception e) {
		}
		return resultado;
	}

	public static boolean eliminaInstruccionesNoAtendidas(Connection conn,
			int idAsunto) {

		String sql = "DELETE FROM SD_INSTRUCCION_ASUNTO WHERE ID_ASUNTO = ? AND INS_ESTATUS IN(?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idAsunto);
			pstmt.setInt(2, Estatus.INS_POR_TURNAR);
			pstmt.setInt(3, Estatus.INS_POR_ATENDER);
			return 0 < pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, pstmt, null);
		}
		return false;
	}

	/**
	 * Metodo que actualizauna intruccion
	 * 
	 * 
	 * @param conn
	 *            Conexiona a la base de datos
	 * @param idInsPadre
	 *            id de la instruccion padre
	 * @return
	 */
	public static boolean actualizaInstruccion(Connection conn,
			int idInstruccion, int idAsunto, int idPto, int idTipoInstruccion,
			String otraInst, int tipoAtencion, int tiempo) {
		String sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_USUARIO = ?, INS_INSTRUCCION = ?, "
				+ "INS_INSTRUCCION_OTRO = ?, INS_TIPO_ATENCION = ?, INS_TIEMPO = ? WHERE ID_INSTRUCCION_ASUNTO = ?"
				+ " AND ID_ASUNTO =?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idPto);
			pstmt.setInt(2, idTipoInstruccion);
			pstmt.setString(3, otraInst);
			pstmt.setInt(4, tipoAtencion);
			pstmt.setInt(5, tiempo);
			pstmt.setInt(6, idInstruccion);
			pstmt.setInt(7, idAsunto);
			return 0 < pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, pstmt, null);
		}
		return false;
	}

	/**
	 * Metodo que actualiza el tiempo de las instrucciones hijas de una
	 * instruccion
	 * 
	 * @param conn
	 *            Conexiona a la base de datos
	 * @param idInsPadre
	 *            id de la instruccion padre
	 * @return
	 */
	public static boolean actualizaTiempoHijas(Connection conn, int idInsPadre,
			int tiempo) {

		String sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_TIEMPO = ? WHERE INS_PADRE = ? ";
		PreparedStatement pstmt = null;
		System.out.println("id Padre: " + idInsPadre);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tiempo);
			pstmt.setInt(2, idInsPadre);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			ConexionDS.endConnection(null, pstmt, null);
		}
		return true;
	}
}