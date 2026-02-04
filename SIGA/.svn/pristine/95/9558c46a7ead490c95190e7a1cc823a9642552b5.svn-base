/*
 * Clase:						ActualizaParamCorreo.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Dec 5, 2005
 * 
 * @author: 					Rodrigo Soto Ch.
 * 								rodrigo_s_ch@yahoo.com.mx, rodrigo.soto.ch@gmail.com
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		Clase donde se ejecutan las funciones para ejecutar los querys de la tabla
 * 								de SD_CONF_CORREOS 
 */

package com.meve.sigma.actualiza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringTokenizer;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLParamCorreo;

/**
 * ActualizaParamCorreo es una clase que ejecuta Querys de Consulta y
 * Actualización de registros de la Tabla de SD_CONF_CORREOS
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaParamCorreo {

	/**
	 * Función que ejecuta un query, donde se inserta los datos del Id del
	 * usuario con los roles que puede tener dentro de Sigma
	 * 
	 * @param IdUsuario
	 *            Id del usuario
	 * @param IdCorreo
	 *            Id Correo
	 * @return ConexionDS.ejecutarActualizacion(strsql)
	 */
	public static synchronized boolean InsertaParamCorreo(String IdUsuario,
			String IdCorreo) {
		int r = 0;
		String strsql = "";
		try {
			StringTokenizer strtST = new StringTokenizer(IdCorreo, ",");
			if (DeleteParamCorreo(IdUsuario))
				while (strtST.hasMoreElements()) {
					strsql = SQLParamCorreo.getInsertaParamCorreo(IdUsuario,
							strtST.nextToken());
					// //System.err.println("InsertaParamCorreo:"+strsql);
					r += ConexionDS.ejecutarActualizacion(strsql);
				}

		} catch (SQLException sqle) {
			// System.out.println("InsertaParamCorreo:"+sqle.getMessage());
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
	 * @param IdCorreo
	 *            Id Correo
	 * @return ConexionDS.ejecutarActualizacion(strsql)
	 */
	public static synchronized boolean insertaParamCorreo(int IdUsuario,
			String[] idsCorreo, Connection conn) {
		PreparedStatement pstmt = null;
		if (deleteParamCorreo(IdUsuario, conn)) {
			String sql = "INSERT INTO SD_CONF_CORREOS  (ID_USUARIO2,ID_CORREO) VALUES (?,?)";
			for (int i = 0; i < idsCorreo.length; i++) {
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, IdUsuario);
					pstmt.setInt(2, Integer.parseInt(idsCorreo[i]));
					pstmt.executeUpdate();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					return false;
				} finally {
					ConexionDS.endConnection(null, pstmt, null);
				}
			}
		}else{
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
	public static boolean DeleteParamCorreo(String IdUsuario) {
		int r = 0;
		try {
			String strsql = SQLParamCorreo.getDeleteParamCorreo(IdUsuario);
			// //System.out.println("DeleteParamCorreo:"+strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			// System.out.println("DeleteParamCorreo:"+sqle.getMessage());
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
	public static boolean deleteParamCorreo(int idUsuario, Connection conn) {
		PreparedStatement pstmt = null;
		try {
			String sql = " DELETE FROM SD_CONF_CORREOS WHERE ID_USUARIO2 = ?";
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
	public static String[][] getParamCorreo(String IdUsuario) {
		try {
			String strsql = SQLParamCorreo.getParamCorreo(IdUsuario);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

}
