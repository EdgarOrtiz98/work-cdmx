/*
 * Clase:						ActualizaRol.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Nov 12, 2005
 * 
 * @author: 					Rodrigo Soto Ch.
 * 								rodrigo_s_ch@yahoo.com.mx, rodrigo.soto.ch@gmail.com
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		Clase donde se ejcutan los querys que estan relacionados con
 * 								la table de SD_ROL
 */

package com.meve.sigma.actualiza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringTokenizer;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLRol;

/**
 * Clase para Insertar, Eliminar, Editar y Obtener informacion de los Roles
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class ActualizaRol {

	/**
	 * Función que ejecuta un query, donde se inserta los datos del Id del
	 * usuario con los roles que puede tener dentro de Sigma
	 * 
	 * @param IdUsuario
	 *            Id del usuario
	 * @param IdRol
	 *            Id del Rol
	 * @return ConexionDS.ejecutarActualizacion(strsql)
	 */
	public static synchronized boolean InsertaRolUsuario(String IdUsuario,
			String IdRol) {
		int r = 0;
		String strsql = "";
		try {
			StringTokenizer strtST = new StringTokenizer(IdRol, ",");
			if (DeleteRolUsuario(IdUsuario))
				while (strtST.hasMoreElements()) {
					strsql = SQLRol.getInsertaRolUsuario(IdUsuario, strtST
							.nextToken());
					// //System.err.println("InsertaRolUsuari:"+strsql);
					r += ConexionDS.ejecutarActualizacion(strsql);
				}

		} catch (SQLException sqle) {
			// System.out.println("InsertaRolUsuari:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Función que ejecuta un query, donde se inserta los datos del Id del
	 * usuario con los roles que puede tener dentro de Sigma
	 * 
	 * @param IdUsuario
	 *            Id del usuario
	 * @param IdRoles
	 *            ids de los roles del usuario
	 * 
	 * @return ConexionDS.ejecutarActualizacion(strsql)
	 */
	public static synchronized boolean insertaRolUsuario(int IdUsuario,
			String[] idRoles, Connection conn) {
		PreparedStatement pstmt = null;
		try {
			if (deleteRolUsuario(IdUsuario, conn)) {
				if (idRoles != null) {
					String sql = "INSERT INTO SD_USUARIO_ROL (ID_USUARIO1,ID_ROL)  VALUES (?,?)";
					for (int i = 0; i < idRoles.length; i++) {
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, IdUsuario);
						pstmt.setInt(2, Integer.parseInt(idRoles[i]));
						pstmt.executeUpdate();
						ConexionDS.endConnection(null, pstmt, null);
					}
				}

			} else {
				return false;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Esta Función se ejecuta cuando se quiere inserta los registros de un id
	 * del usuario con sus posibles roles que se le han asignado
	 * 
	 * @param IdUsuario
	 *            Id del usuario
	 * @return True o False
	 */
	public static boolean DeleteRolUsuario(String IdUsuario) {
		int r = 0;
		try {
			String strsql = SQLRol.getDeleteRolUsuario(IdUsuario);
			// //System.out.println("DeleteRolUsuario:"+strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			// System.out.println("DeleteRolUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Esta Función se ejecuta cuando se quiere inserta los registros de un id
	 * del usuario con sus posibles roles que se le han asignado
	 * 
	 * @param IdUsuario
	 *            Id del usuario
	 * @param conn
	 *            conexiona a la base de datos
	 * @return True o False
	 */
	public static boolean deleteRolUsuario(int idUsuario, Connection conn) {
		PreparedStatement pstmt = null;
		try {
			String sql = "DELETE FROM SD_USUARIO_ROL WHERE ID_USUARIO1=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idUsuario);
			pstmt.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;

		} finally {
			ConexionDS.endConnection(null, pstmt, null);
		}
		return true;
	}

	/**
	 * Función que ejecuta un query, donde trae una lista de 1 ó más roles que
	 * puede tener asignado un usuario
	 * 
	 * @param IdUsuario
	 *            Contienes el Id del usuario
	 * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] getRoles(String IdUsuario) {
		try {
			String strsql = SQLRol.getRoles(IdUsuario);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

}
