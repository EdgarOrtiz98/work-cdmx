/*
 * Clase:						SQLParamCorreo.java
 * 
 * Paquete:						com.meve.sigma.sql		
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
 * Descripción de la clase:		
 */

package com.meve.sigma.sql;

/**
 * SQLParamCorreo es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_FOLIO
 * @author Meve Soluciones SA de CV
 */
public class SQLParamCorreo {
    
    /**
     * Función que regresa un query, donde se inserta el ID del usuario 
     * con 1 o más id de la parametrización de correos
     * @param IdUsuario ID del usuario
     * @param IdCorreo Contiene el valor de la parametrización
     * @return Regresa un String con el Query correspondiente
     */
    public static String getInsertaParamCorreo(String IdUsuario,String IdCorreo)
	{
		String strSql="";		
		strSql=	" INSERT INTO SD_CONF_CORREOS "+ 
				" (ID_USUARIO2,ID_CORREO) "+
				" VALUES ("+IdUsuario+","+IdCorreo+")";			
		return strSql;	
	}
    
    /**
     * Función que regresa un query, donde se elimina los datos del ID de un usuario
     * con sus roles
     * @param IdUsuario Id del usuario
     * @return Regresa un String con el Query correspondiente
     */
	public static String getDeleteParamCorreo(String IdUsuario)
	{
		String strSql="";		
		strSql=	" DELETE FROM SD_CONF_CORREOS WHERE ID_USUARIO2="+IdUsuario;								
		return strSql;	
	}
	
	/**
	 * Función que regresa un query, donde muestra una lista de 1 o más roles
	 * que puede tener un usuario
	 * @param IdUsuario String Contiene el Id del usuario
	 * @return	Regresa un String con el Query correspondiente
	 */
	public static String getParamCorreo(String IdUsuario)
	{
	    String strSql="";		
		strSql=	"SELECT ID_CORREO, " +
				"CASE ID_CORREO " +
				"	WHEN 0 THEN 'Nuevo Asunto' " +
				"	WHEN 1 THEN 'Turnar instrucción' " +
				"	WHEN 2 THEN 'Responder instrucción' " +
				"	WHEN 3 THEN 'Rechazar instrucción' " +
				"	WHEN 4 THEN 'Delegar instrucción' " +
				"	WHEN 5 THEN 'Reasignar instrucción' " +
				"	WHEN 6 THEN 'Habilitar instrucción' " +
				"	WHEN 7 THEN 'Solicitar cambio de fecha de una instrucción' " +
				"	WHEN 8 THEN 'Respuesta cambio de fecha de una instrucción' " +
				"END " +
				"FROM SD_CONF_CORREOS WHERE ID_USUARIO2="+IdUsuario;								
		return strSql;
	}

}

