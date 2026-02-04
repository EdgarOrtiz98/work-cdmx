/*
 * Clase:						ActualizaAutentificacion.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Apr 26, 2006
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

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLAutentificacion;

/**
 * ActualizaAutentificacion es una clase que ejecuta Querys de Consulta y
 * Actualización de registros de la Tabla de autentificación
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaAutentificacion {

	/**
	 * Inserta el UID y password de un usuario
	 * 
	 * @param strUID
	 *            UID
	 * @param strPassword
	 *            Password
	 * @return true si inserta correctamente
	 */
	public static boolean insertarDatosUsuario(String strUID, String strPassword) {
		int r = 0;
		try {
			String strSql = SQLAutentificacion.insertarDatosUsuario(strUID,
					strPassword);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Inserta el UID y password de un usuario
	 * 
	 * @param strUID
	 *            UID
	 * @param strPassword
	 *            Password
	 * @return true si inserta correctamente
	 */
	public static boolean insertarDatosUsuario(String uid, String password,
			Connection conn) {
		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO SD_AUTENTIFICACION (AUT_NOMBRE_USUARIO, AUT_CLAVE_USUARIO) "
					+ "VALUES(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, password);
			return pstmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, pstmt, null);
		}
		return false;
	}

	/**
	 * Datos del usuario para autentificarse por UID
	 * 
	 * @param strUID
	 *            UID
	 * @return regresa arreglo con los datos de autentificación de un usuario
	 */
	public static String[][] getDatosUsuario(String strUID) {
		try {
			String strsql = SQLAutentificacion.getDatosUsuario(strUID);
			// //System.out.println("getDatosUsuario:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDatosUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualización de UID y password de un usuario
	 * 
	 * @param strUID
	 * @param strPassword
	 * @return true o false
	 */
	public static boolean updateDatosUsuario(String strUID, String strPassword) {
		int r = 0;
		try {
			String strsql = SQLAutentificacion.updateDatosUsuario(strUID,
					strPassword);
			// //System.out.println("updateDatosUsuario:"+strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			// System.out.println("updateDatosUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Verifica si existe los datos de autentificación de un usuario
	 * 
	 * @param strUID
	 *            UID
	 * @return true si existe
	 */
	public static boolean getExisteUsuario(String strUID) {
		int r = 0;
		int nusuario = 0;
		try {
			String strsql = SQLAutentificacion.getExisteUsuario(strUID);
			String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
			nusuario = new Integer(strResultado[0][0]).intValue();
		} catch (SQLException sqle) {
			// System.out.println("getExisteUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			nusuario = 0;
		} catch (NumberFormatException nfe) {
			nusuario = 0;
		}

		if (nusuario == 0)
			return false;
		return true;
	}

	/**
	 * Autentifica al usuario para verificar sus credenciales en el sistema
	 * 
	 * @param strUsuario
	 *            UID
	 * @param strPassword
	 *            Password
	 * @param limite
	 *            Número de intentos para acceder
	 * @return un valor de credencial
	 */
	public static int autentificaUsuario(String strUsuario, String strPassword,
			String limite) {

		int AUTENTICADO = 1;
		int CREDENCIALES_INVALIDAS = 2;
		int ERROR_CONNECT_SERVER = 3;
		int USUARIO_NO_EXISTE_DB = 4;
		int NO_EXISTE_CONFIG_LDAP = 5;
		int ERROR_GENERAL = 6;
		int USUARIO_INACTIVO = 7;
		int PASSWORD_VACIO = 8;
		int intentos = 0;
		int iIntentos = ActualizaUsuario.getIntentos(strUsuario);
		int iLimite = new Integer(limite).intValue();

		boolean bExisteUsuario = false;
		boolean bEsActivo = false;
		boolean bIntentos = false;
		boolean bSuspender = false;
		boolean bActivoBorrado = false;
		boolean bResetIntentos = false;
		boolean bBitacora = false;

		bExisteUsuario = getExisteUsuario(strUsuario);
		bActivoBorrado = ActualizaUsuario.getEsBorrado(strUsuario);
		bEsActivo = ActualizaUsuario.getEsActivo(strUsuario);
		if (bExisteUsuario) {
			if (!bActivoBorrado) {
				if (bEsActivo) {
					try {
						String strResult[][] = ConexionDS
								.ejecutarSQL(SQLAutentificacion
										.autentificaUsuario(strUsuario,
												strPassword));

						if (strResult != null && strResult.length > 0) {
							bResetIntentos = ActualizaUsuario
									.resetIntentos(strUsuario);
							return AUTENTICADO;
						} else {
							/***********  aquí va chequeo de admin area 0 *********///							
							String strResult2[][]=ConexionDS.ejecutarSQL(SQLAutentificacion.esadmin(strUsuario));/// colocar este llamado en sqlautentificacion.java
							if (strResult2!=null && strResult2.length>0){
								intentos=0;
								bResetIntentos = ActualizaUsuario.resetIntentos(strUsuario);								
							}else{
								
							
							intentos++;
							int y = iIntentos + 1;
							bIntentos = ActualizaUsuario.UpdateIntentos(y,
									strUsuario);
							if (y >= iLimite) {
								intentos = 0;
								bSuspender = ActualizaUsuario
										.SuspenderUsuario(strUsuario);
								bBitacora = ActualizaBitacora
										.InsertarEventoSuspencion(
												ActualizaUsuario
														.getIdUsuario(strUsuario),
												y + "");
							} else {
								bBitacora = ActualizaBitacora
										.InsertarEventoIntentoEnt(
												ActualizaUsuario
														.getIdUsuario(strUsuario),
												y + "");
							}
							}
							
							return CREDENCIALES_INVALIDAS;							
							/*************  termina Chequeo admin    *************/														
						}
					} catch (SQLException sqle) {
						// System.out.println("autentificaUsuario:"+sqle);
						sqle.printStackTrace();
						return 2;
					}
				} else {
					return USUARIO_INACTIVO;
				}
			} else {
				return USUARIO_INACTIVO;
			}
		} else {
			return USUARIO_NO_EXISTE_DB;
		}
	}

}
