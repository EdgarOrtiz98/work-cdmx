/*
 * Clase:						ActualizaTipoRespuesta.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Jan 17, 2006
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

import java.sql.SQLException;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLTipoRespuesta;

/**
 * Clase para Insertar, Eliminar, Editar y Obtener informacion de los Tipos de Respuesta
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class ActualizaTipoRespuesta {
    
	/**
	 * Regresa los campos de Tipo de Respuesta por ID
	 * @param idTipoRespuesta ID del Tipo de Respuesta
	 * @return Regresa el String[][] correspondiente
	 */
    public static String[][] getTipoInstrucciones(String idTipoRespuesta) {
		try {
			String strsql = SQLTipoRespuesta.getTipoRespuesta(idTipoRespuesta);
			////System.out.println("getTipoInstrucciones:" + strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getTipoInstrucciones:" + sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

    /**
	 * Regresa los campos de Tipo de Respuesta
	 * @return Regresa el String[][] correspondiente
	 */
	public static String[][] getTipoRespuesta() {
		try {
			String strsql = SQLTipoRespuesta.getTipoRespuesta();
			////System.out.println("getTipoRespuesta:" + strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getTipoRespuesta:" + sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Inserta un Tipo de Respuesta en la BD 
	 * @param nombre Nombre
	 * @param actualizo Usuarios que actualizá
	 * @param fecha Fecha de actualizacion
	 * @return Regresa un True si la operacion fue exitosa y False en caso contrario
	 */
	public static boolean getInsertaTipoRespuesta(String nombre, 
											String actualizo, String fecha) {
		int r = 0;
		try {
			String strSql = SQLTipoRespuesta.getInsertaTipoRespuesta(nombre,
												actualizo, fecha);
			////System.out.println("getInsertaTipoRespuesta:" + strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			//System.out.println("getInsertaTipoRespuesta:" + sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Actualiza un Tipo de Respuesta en la BD 
	 * @param idTipoRespuesta ID tipo de Respuesta
	 * @param nombre Nombre
	 * @param actualizo Usuarios que actualizá
	 * @param fecha Fecha de actualizacion
	 * @return Regresa un True si la operacion fue exitosa y False en caso contrario
	 */
	public static boolean getActualizarTipoRespuesta(String idTipoRespuesta, String nombre, 
													String actualizo, String fecha) {
		int r = 0;
		try {
			String strsql = SQLTipoRespuesta.getActualizarTipoRespuesta(idTipoRespuesta, nombre,
			        													actualizo, fecha);
			////System.out.println("getActualizarTipoRespuesta:" + strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getActualizarTipoRespuesta:" + sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Elimina logicamente los registros de Tipo de Asunto
	 * @param strIds ID's de los Tipos de Respuesta
	 * @return Regresa un True si la operacion fue exitosa y False en caso contrario
	 */
	public static boolean getDeleteTipoRespuesta(String strIds[]) {
		int r = 0;
		if (strIds == null || strIds.length < 0)
			return false;

		try {
			String strsql = SQLTipoRespuesta.getDeleteTipoRespuesta(strIds);
			////System.out.println("getDeleteTipoRespuesta:" + strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getDeleteTipoRespuesta:" + sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}
	
	/**
	 * Regresa el nombre del Tipo de Respuesta segun su ID
	 * @param idTipoRespuesta ID tipo de Respuesta
	 * @return Regresa el String[][] correspondiente
	 */
	public static String[][] getNombreTipoRespuesta(String idTipoRespuesta) {
		try {
			String strsql = SQLTipoRespuesta.getNombreTipoRespuesta(idTipoRespuesta);
			////System.out.println("getNombreTipoRespuesta:" + strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getNombreTipoRespuesta:" + sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Valida si existen Tipos de Respuesta
	 * @return Regresa un True si SI existen Tipos de Respuesta o un False en caso contrario
	 */
	public static boolean existenTipoRespuesta()
	{		
		try
		{
			String strsql = SQLTipoRespuesta.existenTipoRespuesta();
			////System.out.println("existenTipoRespuesta:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
			////System.out.println("="+false);
			return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("existenTipoRespuesta:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Regresa una lista de los Tipos de Respuesta
	 * @return Regresa el String[][] correspondiente
	 */
	public static String[][] getTiposRespuestaPortal() {
		try {
			String strsql = SQLTipoRespuesta.getTiposRespuestaPortal();
			////System.out.println("getTiposRespuestaPortal:" + strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getTiposRespuestaPortal:" + sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}
	
}

