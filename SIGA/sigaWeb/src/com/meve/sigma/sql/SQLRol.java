/*
 * Clase:						SQLRol.java
 * 
 * Paquete:						com.meve.sigma.sql		
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
 * Descripción de la clase:		
 */

package com.meve.sigma.sql;

/**
 * Clase para generar codigo SQL para Roles
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class SQLRol {
    
    /**
     * Función que regresa un query, donde se inserta el ID del usuario 
     * con 1 o más id de rol
     * @param IdUsuario ID del usuario
     * @param IdRol ID ROl
     * @return Query
     */
    public static String getInsertaRolUsuario(String IdUsuario,String IdRol)
	{
		String strSql="";		
		strSql=	" INSERT INTO SD_USUARIO_ROL "+ 
				" (ID_USUARIO1,ID_ROL) "+
				" VALUES ("+IdUsuario+","+IdRol+")";								
		return strSql;	
	}
    
    /**
     * Función que regresa un query, donde se elimina los datos del ID de un usuario
     * con sus roles
     * @param IdUsuario Id del usuario
     * @return Query Delete
     */
	public static String getDeleteRolUsuario(String IdUsuario)
	{
		String strSql="";		
		strSql=	" DELETE FROM SD_USUARIO_ROL WHERE ID_USUARIO1="+IdUsuario;								
		return strSql;	
	}
	
	/**
	 * Función que regresa un query, donde muestra una lista de 1 o más roles
	 * que puede tener un usuario
	 * @param IdUsuario String Contiene el Id del usuario
	 * @return Query
	 */
	public static String getRoles(String IdUsuario)
	{
	    String strSql="";		
		strSql=	"SELECT ID_ROL, " +
				"CASE ID_ROL " +
				"	WHEN 0 THEN 'Administrador' " +
				"	WHEN 1 THEN 'atención' " +
				"	WHEN 2 THEN 'SCP' " +
				"	WHEN 3 THEN 'Recepción' " +
				"	WHEN 4 THEN 'Supervisor de área' " +
				"	WHEN 5 THEN 'Turnador' " +
				"	WHEN 6 THEN 'Asistente' " +
				"END " +
				"FROM SD_USUARIO_ROL WHERE ID_USUARIO1="+IdUsuario;								
		return strSql;
	}

}

