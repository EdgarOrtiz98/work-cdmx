/*
 * Clase:						ActualizaAsuntoTurnado.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
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

package com.meve.sigma.actualiza;

import gob.hacienda.cgtic.siga.asunto.AsuntoVerifica;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.mail.MessagingException;
import javax.naming.NamingException;
import javax.servlet.ServletContext;

import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLAsuntoTurnado;
import com.meve.sigma.util.Estatus;
import com.meve.sigma.util.SenderMail;
import com.meve.sigma.util.Utilerias;

/**
 * ActualizaAsunto es una clase que ejecuta Querys de Consulta y Actualización
 * de registros de la Tabla de Asuntos
 * 
 * @author Meve Soluciones
 */
public class ActualizaAsuntoTurnado {

	/**
	 * Función que ejecuta un query que trae todos los datos de la tabla de
	 * SD_ASunto que tenga como estatus Turnado
	 * 
	 * @param strIdAsunto
	 *            Id asunto
	 * @return Arreglo de los datos de un asunto turnado
	 */
	public static String[][] getAsuntoTurnado(String strIdAsunto) {
		try {
			String strsql = SQLAsuntoTurnado.getAsuntoTurnado(strIdAsunto);
			// System.out.println("getAsuntoTurnado:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAsuntoTurnado:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualiza el estatus a 2(Trámite)
	 * 
	 * @param strIdAsunto
	 *            Id Asuntos
	 * @return true o false
	 */
	public static boolean ActualizaIDEstatus(String strIdAsunto) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado.ActualizaIDEstatus(strIdAsunto);
			// //System.out.println("ActualizaIDEstatus:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("ActualizaIDEstatus:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Verifica las instrucciones a turnar
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return true o false
	 */
	public static boolean VerificarInstruccionesTurnar(String strIdAsunto) {
		try {
			String strsql = SQLAsuntoTurnado
					.getVerificarInstruccionesTurnar(strIdAsunto);
			// //System.out.println("VerificarInstruccionesTurnar:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;

			// //System.out.println("="+false);
			return false;
		} catch (SQLException sqle) {
			// System.out.println("VerificarInstruccionesTurnar:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica instrucciones que tiene instrucciones hijas
	 * 
	 * @param strIdPadre
	 *            Id instrucción padre
	 * @return true o false
	 */
	public static boolean VerificarInstruccionesTurnarPadre(String strIdPadre) {
		try {
			String strsql = SQLAsuntoTurnado
					.getVerificarInstruccionesTurnarPadre(strIdPadre);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Secuencia de los pasos de la instrucción
	 * 
	 * @param strIdAsunto
	 *            id Asunto
	 * @return arreglo de secuencias de las instrucciones
	 */
	public static String[][] SecuenciaPasosInstruccion(String strIdAsunto) {
		try {
			String strsql = SQLAsuntoTurnado
					.SecuenciaPasosInstruccion(strIdAsunto);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Secuencia de los pasos de las instrucciones hijas
	 * 
	 * @param strIdPadre
	 *            Id instrucción
	 * @return arreglo de secuencias de las instrucciones
	 */
	public static String[][] SecuenciaPasosInstruccionPadre(String strIdPadre) {
		try {
			String strsql = SQLAsuntoTurnado
					.SecuenciaPasosInstruccionPadre(strIdPadre);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query para comprobar si la instrucción ha sido
	 * turnada verificando si tiene fecha de inicio y fin
	 * 
	 * @param strIdInstruccion
	 *            String Contiene el ID de la Instruccion
	 * @return true si tiene fechas y false si no ha sido turnado
	 */
	public static boolean tieneFechas(String strIdInstruccion) {
		try {
			String strsql = SQLAsuntoTurnado.tieneFechas(strIdInstruccion);
			// //System.out.println("tieneFechas:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;

			// //System.out.println("="+false);
			return false;
		} catch (SQLException sqle) {
			// System.out.println("tieneFechas:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Fecha de asignación de la instrucción
	 * 
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @return Fecha de asignación de un asunto
	 */
	public static String[][] FechasAsignacion(String strIdInstruccion) {
		try {
			String strsql = SQLAsuntoTurnado.FechasAsignacion(strIdInstruccion);
			// //System.out.println("FechasAsignacion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("FechasAsignacion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query que trae como consulta la fecha en la que se
	 * termino alguna instrucción, para calcular la duración real
	 * 
	 * @param strIdInstruccion
	 *            String Contiene el ID de la instrucción
	 * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] getFechaFinInstruccion(String strIdInstruccion) {
		try {
			String strsql = SQLAsuntoTurnado
					.getFechaFinInstruccion(strIdInstruccion);
			// //System.out.println("getFechaFinInstruccion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getFechaFinInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Instrucciones habilitadas
	 * 
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @return Instrucciones habilitadas
	 */
	public static String[][] getInstruccionesHabilitadas(String strIdInstruccion) {
		try {
			String strsql = SQLAsuntoTurnado
					.getInstruccionesHabilitadas(strIdInstruccion);
			// //System.out.println("getInstruccionesHabilitadas:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getInstruccionesHabilitadas:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Instrucciones habilitadas para instrucciones padrees
	 * 
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @return Instrucciones habilitadas
	 */
	public static String[][] getInstHabAtender(String strIdInstruccion) {
		try {
			String strsql = SQLAsuntoTurnado
					.getInstHabAtender(strIdInstruccion);
			// //System.out.println("getInstHabAtender:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getInstHabAtender:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Número de instrucciones que se le han turnado
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Número de instrucciones
	 */
	public static String[][] getCountInstruccion(String strIdAsunto) {
		try {
			String strsql = SQLAsuntoTurnado.getCountInstruccion(strIdAsunto);
			// //System.out.println("getCountInstruccion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getCountInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Número de instrucciones padre que se le han turnado
	 * 
	 * @param strIdPadre
	 *            Id asunto
	 * @return Número de instrucciones
	 */
	public static String[][] getCountInstruccionPadre(String strIdPadre) {
		try {
			String strsql = SQLAsuntoTurnado
					.getCountInstruccionPadre(strIdPadre);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Determina si un instruccion tiene o no instrucciones hijas no terminadas
	 * 
	 * @param strIdPadre
	 *            ID de la instruccion padre
	 * @return True si tiene instrucciones hijas sin terminar o False en caso
	 *         contrario
	 */
	public static boolean getCountInstNoTerminadas(String strIdPadre) {
		try {
			String strsql = SQLAsuntoTurnado
					.getCountInstNoTerminadas(strIdPadre);
			String result[][] = ConexionDS.ejecutarSQL(strsql);
			if (result != null && result.length > 0) {
				if (result[0][0].equals("0")) {
					return false;
				} else {
					return true;
				}
			} else {
				return false;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Suma de avance de las instrucciones que pertenecen a un asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Sum avance de instrucciones
	 */
	public static String[][] getSumInstruccion(String strIdAsunto) {
		String SQL = "SELECT SUM(INS_AVANCE) FROM SD_INSTRUCCION_ASUNTO WHERE INS_PADRE IS NULL AND ID_ASUNTO=";
		try {
			String strsql = SQL + strIdAsunto + " AND INS_TIPO_ATENCION=0 ";
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Suma de avance de las instrucciones que pertenecen a una instrucción
	 * 
	 * @param strIdPadre
	 *            Id instrucción
	 * @return Sum avance de instrucciones hija
	 */
	public static String[][] getSumInstruccionPadre(String strIdPadre) {
		String SQL = "SELECT SUM(INS_AVANCE) FROM SD_INSTRUCCION_ASUNTO WHERE INS_PADRE=";
		try {
			String strsql = SQL + strIdPadre + " AND INS_TIPO_ATENCION=0 ";
			// //System.out.println("getCountInstruccion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getCountInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualización del avance general de un asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return true o false
	 */
	public static boolean ActualizaAvanceAsunto(String strIdAsunto,
			String strAvance) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado.ActualizaAvanceAsunto(strIdAsunto,
					strAvance);
			// //System.out.println("ActualizaAvanceAsunto:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("ActualizaAvanceAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Función que ejecuta un query, donde ejecuta una Actualización de la
	 * instruccion padre
	 * 
	 * @param strIdPadre
	 *            Contiene el Id de la instrucción padre
	 * @param strAvance
	 *            Avance de la instrucción
	 * @return True o False
	 */
	public static boolean ActualizaAvancePadre(String strIdPadre,
			String strAvance) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado.ActualizaAvancePadre(strIdPadre,
					strAvance);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Actualización del estatus de un asunto y el avance al 99%
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return true o false
	 */
	public static boolean ActualizaEstatusAsunto(String strIdAsunto,
			String strFechaReal, String strFechaTerminacion) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado.ActualizaEstatusAsunto(
					strIdAsunto, strFechaReal, strFechaTerminacion);
			// //System.out.println("ActualizaEstatusAsunto:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("ActualizaEstatusAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
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
	 * @return true o false
	 */
	public static boolean terminarAsunto(String strIdAsunto,
			String strFechaReal, String strFechaTerminacion) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado.terminarAsunto(strIdAsunto,
					strFechaReal, strFechaTerminacion);
			// //System.out.println("terminarAsunto:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("terminarAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Recupera el asunto y borra las instrucciones genereadas
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return true si lo recupero o false si no pude recuperarlo
	 */
	public static boolean recuperarAsunto(int idAsunto, UsuarioBean usuario,
			ServletContext context) {
		// TODO: ver la forma de pasar esta conexion
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConexionDS.getConexion();
			conn.setAutoCommit(false);
			if (AsuntoVerifica.esRecuperable(conn, idAsunto)) {
				SenderMail mail = new SenderMail();
				if (ActualizaUsuario
						.getNotificacionMail(usuario.getIdUsuario())) {
					mail.sendNotificarRecuperacion(String.valueOf(idAsunto),
							usuario, context);
				}
				mail
						.sendNotificarCancelacion(String.valueOf(idAsunto),
								context);
				if (ActualizaInstrucciones.eliminaInstruccionesNoAtendidas(
						conn, idAsunto)) {
					if (eliminaDestinatarios(idAsunto, conn)) {
						String sql = "UPDATE SD_ASUNTO SET ASU_ESTATUS = ? WHERE ID_ASUNTO = ? ";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, Estatus.ASU_EN_RECEPCION);
						pstmt.setInt(2, idAsunto);
						pstmt.executeUpdate();
						conn.commit();
						return true;
					} else {
						conn.rollback();
					}
				} else {
					conn.rollback();
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, pstmt, conn);
		}
		return false;
	}

	/**
	 * Elimina los registros del asunto de la tabla de destinatarios(Para la
	 * recuperacion de asuntos)
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return true si lo recupero o false si no pude recuperarlo
	 */
	private static boolean eliminaDestinatarios(int idAsunto, Connection conn) {
		PreparedStatement pstmt = null;
		try {
			String sql = "DELETE FROM SD_REF_DESTINATARIOS WHERE ID_ASUNTO_REF = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idAsunto);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		} finally {
			ConexionDS.endConnection(null, pstmt, null);
		}
	}

	/**
	 * Función que que ejcuta un query, donde actualiza los campo de prioridad y
	 * tipo de asunto. La ruta automatica es opcional
	 * 
	 * @param strIdAsunto
	 *            Contiene el ID del Asunto
	 * @return True
	 */
	public static boolean actualizaPrioridad(String strIdAsunto,
			String idPrioridad, String strIdTipoAsunto, String idRuta,
			String strIdDocto, String strFolio) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado.actualizaPrioridad(strIdAsunto,
					idPrioridad, strIdTipoAsunto, idRuta, strIdDocto, strFolio);
			if (!idRuta.equals("null")) {
				String strDetalleRuta[][] = ActualizaFlujo
						.getDetalleRuta(idRuta);
				ActualizaInstrucciones.insertarInstruccion(strDetalleRuta,
						strIdAsunto);

			}
			// //System.out.println("actualizaPrioridad---->"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("actualizaPrioridad:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
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
	 * @return true o false
	 */
	public static boolean actualizaPrioridad1(String strIdAsunto,
			String idPrioridad, String strIdTipoAsunto/* , String idRuta */) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado.actualizaPrioridad1(strIdAsunto,
					idPrioridad, strIdTipoAsunto/* , idRuta */);
			// if(!idRuta.equals("null")){
			// //System.out.println("**ruta automatica**");
			// String strDetalleRuta[][] =
			// ActualizaFlujo.getDetalleRuta(idRuta);
			// ActualizaInstrucciones.insertarInstruccion(strDetalleRuta,
			// strIdAsunto);
			// }
			// //System.out.println("actualizaPrioridad1---->"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("actualizaPrioridad1:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Función que ejecuta un query, donde muestra los datos de las
	 * instrucciones hijo de la instrucción padre
	 * 
	 * @param strIdInstPadre
	 *            Contiene el ID de la instrucción padre
	 * @return String[][]
	 */
	public static String[][] getInstHabilitarTur(String strIdInstPadre) {
		try {
			String strsql = SQLAsuntoTurnado
					.getInstHabilitarTur(strIdInstPadre);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query, donde regresa el folio de la instrucción
	 * padre
	 * 
	 * @param idInStPadre
	 *            Contiene el Id de la instrucción Padre
	 * @return String
	 */
	public static String getFolioInstTur(String idInStPadre) {
		String SQL = "SELECT INS_FOLIO_TURNADO FROM SD_INSTRUCCION_ASUNTO "
				+ "WHERE ID_INSTRUCCION_ASUNTO=" + idInStPadre;
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
	 * Función que ejecuta un query, donde actualiza el estatus de la
	 * instrucción padre
	 * 
	 * @param strIdInstPadre
	 *            Contiene el Id de la instrucción padre
	 * @return True
	 */
	public static boolean ActualizaIDEstatusInst(String strIdInstPadre) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado
					.ActualizaIDEstatusInst(strIdInstPadre);
			// //System.out.println("ActualizaIDEstatusInst:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("ActualizaIDEstatusInst:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Función que ejecuta un query, donde muestra el avance de la instrucción
	 * padre y el id de asunto
	 * 
	 * @param strIdInstPadre
	 *            Contiene el Id de la instrución padre
	 * @return Query
	 */
	public static String[][] getAvanceInstTurnado(String strIdInstPadre) {
		try {
			String sql = SQLAsuntoTurnado.getAvanceInstTurnado(strIdInstPadre);
			// //System.out.println("getAvanceInstTurnado="+sql);
			return ConexionDS.ejecutarSQL(sql);
		} catch (SQLException sqle) {
			// System.out.println("getAvanceInstTurnado:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query donde devuelve True o False si la
	 * instrucción es hija o no
	 * 
	 * @param idInstruccion
	 *            Contiene el Id de la instrucción
	 * @return True o False
	 */
	public static boolean getEsHijo(String idInstruccion) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado.getEsHijo(idInstruccion);
			// //System.out.println("getEsHijo:"+strSql);
			String s[][] = ConexionDS.ejecutarSQL(strSql);
			if (s[0][0].length() == 0)
				return false;
			return true;
		} catch (SQLException sqle) {
			// System.out.println("getEsHijo:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		// return (r>0);
	}

	/**
	 * Función que ejecuta un query, donde muestra el id de la instruccion padre
	 * 
	 * @param idInstruccion
	 *            Contiene el id de la instrucción hijo
	 * @return String
	 */
	public static String getIdPadre(String idInstruccion) {
		try {
			String sql = SQLAsuntoTurnado.getIdPadre(idInstruccion);
			// //System.out.println("sql--->"+sql);
			String strResult[][] = ConexionDS.ejecutarSQL(sql);
			// //System.out.println("getIdPadre-->="+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getIdPadre:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta unquery, donde actualiza el estatus de la instrucción
	 * padre, en este caso para terminarla
	 * 
	 * @param strIdPadre
	 *            Contiene el id de la instrucción padre
	 * @return True o False
	 */
	public static boolean actualizaRespuestaPadre(String strIdPadre) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado
					.actualizaRespuestaPadre(strIdPadre);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Función que ejecuta unquery, donde actualiza el estatus de la instrucción
	 * padre, en este caso para terminarla
	 * 
	 * @param strIdPadre
	 *            Contiene el id de la instrucción padre
	 * @return True o False
	 */
	public static boolean actualizaRespuestaPadre1(String strIdPadre) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado
					.actualizaRespuestaPadre1(strIdPadre);
			// //System.out.println("actualizaRespuestaPadre1:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("actualizaRespuestaPadre1:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Verifica si un asuntos en Trámite tiene instrucciones por turnar
	 * 
	 * @param IdAsunto
	 *            Id Asunto
	 * @return true si tiene instrucciones, false no
	 */
	public static boolean TieneMasInstTurnar(String IdAsunto) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado.TieneMasInstTurnar(IdAsunto);
			// //System.out.println("TieneMasInstTurnar:"+strSql);
			String s[][] = ConexionDS.ejecutarSQL(strSql);
			// //System.err.println("S--->"+s[0][0]);
			if (s[0][0].length() == 0)
				return false;
			return true;
		} catch (SQLException sqle) {
			// System.out.println("TieneMasInstTurnar:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		// return (r>0);
	}

	/**
	 * Vericia si existen instrucciones nuevas sin turnar
	 * 
	 * @param strIdAsunto
	 *            Id Asuntos
	 * @return true o false
	 */
	public static boolean existenInstruccionesNuevasSinTurnar(String strIdAsunto) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado
					.existenInstruccionesNuevasSinTurnar(strIdAsunto);
			// //System.out.println("existenInstruccionesNuevasSinTurnar:"+strSql);
			String s[][] = ConexionDS.ejecutarSQL(strSql);
			String numero = s[0][0];
			r = new Integer(numero).intValue();
			if (r == 0)
				return false;
			return true;
		} catch (SQLException sqle) {
			// System.out.println("existenInstruccionesNuevasSinTurnar:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Función que ejecuta un query, donde se actualiza la fecha estimada de
	 * termianción de un asunto
	 * 
	 * @param strIdAsunto
	 *            Id del Asunto
	 * @param strFechaEstimada
	 *            Fecha estimada
	 * @return true si actualiza la fecha estimada
	 */
	public static boolean getUpdateFechaEstimada(String strIdAsunto,
			String strFechaEstimada) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado.getUpdateFechaEstimada(
					strIdAsunto, strFechaEstimada);
			// //System.out.println("getUpdateFechaEstimada:"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("getUpdateFechaEstimada:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Función que ejecuta un query que trae todos los datos de la tabla de
	 * SD_ASunto que tenga como estatus Turnado para la generación del Reporte
	 * 
	 * @return Arreglo de datos de un asunto para generar reporte
	 */
	public static String[][] getAsuntoTurnadoReporte(String strIdAsunto) {
		try {
			String strsql = SQLAsuntoTurnado
					.getAsuntoTurnadoReporte(strIdAsunto);
			// //System.out.println("getAsuntoTurnadoReporte:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAsuntoTurnadoReporte:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Tipo de atención de la instrucción
	 * 
	 * @param strIdInstruccion
	 *            Id de la instrucción
	 * @return 0 Ejecutora, 1 informativa
	 */
	public static String getTipoAtencion(String strIdInstruccion) {
		try {
			String sql = SQLAsuntoTurnado.getTipoAtencion(strIdInstruccion);
			// //System.out.println("getTipoAtencion--->"+sql);
			String strResult[][] = ConexionDS.ejecutarSQL(sql);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getTipoAtencion:"+sqle);
			sqle.printStackTrace();
			return null;
		}
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
	 * @return true o false
	 */
	public static boolean insertAsuntoDescriptivos(String strIdAsunto,
			String strAreaRep, String strEntidad, String strRemitente,
			String strRemNombre, String strRemMail, String strControl,
			String strTurPuesto, String strTurNombre, String strTurArea,
			String strTipoDocto, String strExpediente, String strTramite,
			String strTipoAsunto, String strPrioridad, String strUsrCaptura) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado.insertAsuntoDescriptivos(
					strIdAsunto, strAreaRep, strEntidad, strRemitente,
					strRemNombre, strRemMail, strControl, strTurPuesto,
					strTurNombre, strTurArea, strTipoDocto, strExpediente,
					strTramite, strTipoAsunto, strPrioridad, strUsrCaptura);
			// //System.out.println("insertAsuntoDescriptivos"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("insertAsuntoDescriptivos:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Control del asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return getControl
	 */
	public static String getControl(String strIdAsunto) {
		try {
			String sql = SQLAsuntoTurnado.getControl(strIdAsunto);
			// //System.out.println("getControl--->"+sql);
			String strResult[][] = ConexionDS.ejecutarSQL(sql);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getControl:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query que trae la lista de los descriptivos de un
	 * asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @param strControl
	 *            Control
	 * @return Arreglo de los datos de un asunto
	 */
	public static String[][] getDatosDescripcion(String strIdAsunto,
			String strControl) {
		try {
			String strsql = SQLAsuntoTurnado.getDatosDescripcion(strIdAsunto,
					strControl);
			// //System.out.println("getDatosDescripcion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDatosDescripcion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Datos del turnador
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Arreglo de datos del turnador
	 */
	public static String[][] getDatosTurnador(String strIdAsunto) {
		try {
			String strsql = SQLAsuntoTurnado.getDatosTurnador(strIdAsunto);
			// //System.out.println("getDatosTurnador:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDatosTurnador:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Verifica si existe asuntos con Descripción
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return true si existe descriptivos del asunto
	 */
	public static boolean getExisteDes(String strIdAsunto) {
		try {
			String strsql = SQLAsuntoTurnado.getExisteDes(strIdAsunto);
			// //System.out.println("getExisteDes:"+strsql);
			String str[][] = ConexionDS.ejecutarSQL(strsql);
			if (str.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExisteDes:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Descriptivo de un asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Regresa un arreglo con los datos de un descriptivo de un asunto
	 */
	public static String[][] getDatosDes(String strIdAsunto) {
		try {
			String strsql = SQLAsuntoTurnado.getDatosDes(strIdAsunto);
			// //System.out.println("getDatosDes:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDatosDes:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que inserta datos de los descriptivos de los destinatarios de un
	 * asunto
	 * 
	 * @param strIdAsunto
	 * @param strIdsPara
	 * @param strIdsCC
	 * @param strIdsParaExt
	 * @return true si el insert fue existoso
	 */
	public static boolean insertDescriptivosDest(String strIdAsunto,
			String strIdsPara, String strIdsCC, String strIdsParaExt) {
		int r = 0;
		Vector vPara = Utilerias.getNombrePuesto(strIdsPara, 0);
		Vector vCc = Utilerias.getNombrePuesto(strIdsCC, 0);
		Vector vParaE = Utilerias.getRemitenteEntidad(strIdsParaExt, 1);
		Vector vIPara = Utilerias.getNombres(strIdsPara);
		Vector vIcc = Utilerias.getNombres(strIdsCC);
		Vector vIparaE = Utilerias.getNombres(strIdsParaExt);
		try {

			for (int i = 0; i < vPara.size(); i++) {
				String strSql = SQLAsuntoTurnado.insertDescriptivosDest(
						strIdAsunto, "1", (String) vIPara.elementAt(i),
						(String) vPara.elementAt(i));
				r = ConexionDS.ejecutarActualizacion(strSql);
			}
			for (int i = 0; i < vCc.size(); i++) {
				String strSql = SQLAsuntoTurnado.insertDescriptivosDest(
						strIdAsunto, "2", (String) vIcc.elementAt(i),
						(String) vCc.elementAt(i));
				r = ConexionDS.ejecutarActualizacion(strSql);
			}
			for (int i = 0; i < vParaE.size(); i++) {
				String strSql = SQLAsuntoTurnado.insertDescriptivosDest(
						strIdAsunto, "3", (String) vIparaE.elementAt(i),
						(String) vParaE.elementAt(i));
				r = ConexionDS.ejecutarActualizacion(strSql);
			}

		} catch (SQLException sqle) {
			// System.out.println("insertDescriptivosDest:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Descriptivos de los destinatarios Para
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Regresa un arreglo con los destinatarios Para
	 */
	public static String[][] getDesPara(String strIdAsunto) {
		try {
			String strsql = SQLAsuntoTurnado.getDesPara(strIdAsunto);
			// //System.out.println("getDesPara:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDesPara:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Descriptivos CCp
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Regresa un arreglo con los destinatarios CCp
	 */
	public static String[][] getDesCC(String strIdAsunto) {
		try {
			String strsql = SQLAsuntoTurnado.getDesCC(strIdAsunto);
			// //System.out.println("getDesCC:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDesCC:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}
	
	public static String[] getDesCCReporte(String strIdAsunto) {
			String [] ccReporte = null;
			Vector vNomPue = new Vector();
		
		try {
			String strsql = SQLAsuntoTurnado.getDesCCReporte(strIdAsunto);
			String[][] arregloResulado = ConexionDS.ejecutarSQL(strsql);
			String cadenaTurnados[] = arregloResulado[0][0].split(",");
			ccReporte = new String [cadenaTurnados.length];
			String strNombre = "";
			String strPuesto = "";
			String strUA = "";
			
			for (int i = 0; i < cadenaTurnados.length; i++) {
				if(cadenaTurnados[i] != null){
					if(!cadenaTurnados[i].equals("")){
						strNombre = ActualizaUsuario.NombreUsuario(cadenaTurnados[i]);				
						strPuesto = ActualizaUsuario.NombrePuesto(cadenaTurnados[i]);
						strUA = ActualizaArea.NombreArea(ActualizaUsuario.getIdAreaUs(cadenaTurnados[i]));

						if(strNombre != null  && strPuesto != null && strUA != null){
							if(!strNombre.equals("") && !strPuesto.equals("") && !strUA.equals("")){
								ccReporte[i] = strNombre + "/" + strPuesto + " -- " + strUA;
							}
						}
				  }
				}
			}
			return ccReporte;
		} catch (SQLException sqle) {
			// System.out.println("getDesCC:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Descriptivos ParaExt
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Regresa un arreglo con los destinatarios ParaExt
	 */
	public static String[][] getDesParaE(String strIdAsunto) {
		try {
			String strsql = SQLAsuntoTurnado.getDesParaE(strIdAsunto);
			// //System.out.println("getDesParaE:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDesParaE:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualiza Fecha compromiso de un asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @param strFechaCom
	 *            Id Nueva fecha compromiso
	 * @return true si la Actualización fue exitosa
	 */
	public static boolean actualizaFechaCompromiso(String strIdAsunto,
			String strFechaCom) {
		int r = 0;
		try {
			String strSql = SQLAsuntoTurnado.actualizaFechaCompromiso(
					strIdAsunto, strFechaCom);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

}
