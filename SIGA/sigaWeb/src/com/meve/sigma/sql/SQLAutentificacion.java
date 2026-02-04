/**
 * Clase:						SQLAutentificacion.java
 * 
 * Paquete:						com.meve.sigma.sql		
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

package com.meve.sigma.sql;

/**
 * SQLAutentificacion es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_AUTENTIFICACION
 * 
 * @author Meve Soluciones SA de CV
 *
 */
public class SQLAutentificacion {
    
    /**
     * Funcion que regresa unquery, donde inserta los datos de un usuario como su UID
     * y password
     * @param strUID Nombre del usuario
     * @param strPassword Password
     * @return Query
     */
    public static String insertarDatosUsuario(String strUID, String strPassword){
        String sql = "INSERT INTO SD_AUTENTIFICACION (AUT_NOMBRE_USUARIO, AUT_CLAVE_USUARIO) " +
        		"VALUES('"+strUID+"','"+strPassword+"')";
        return sql;
    }
    
    /**
     * Función que regresa un query, donde muestra el registro del usuario por medio
     * de su UID
     * @param strUID UID del usuario
     * @return Query
     */
    public static String getDatosUsuario(String strUID){
        String sql = "SELECT AUT_NOMBRE_USUARIO, AUT_CLAVE_USUARIO " +
        		"FROM SD_AUTENTIFICACION WHERE AUT_NOMBRE_USUARIO='"+strUID+"'";
        return sql;
    }
    
    /**
     * Función que regresa un query, donde actualiza los datos de una 
     * usuario para su autentificación en el sistema
     * @param strUID UID del usuario
     * @param strPassword Password del usuario a cambiar
     * @return query
     */
    public static String updateDatosUsuario(String strUID, String strPassword){
        String sql = "UPDATE SD_AUTENTIFICACION SET AUT_NOMBRE_USUARIO='"+strUID+"', " +
        		"AUT_CLAVE_USUARIO='"+strPassword+"' WHERE AUT_NOMBRE_USUARIO='"+strUID+"'";
        return sql;
    }
    
    /**
     * Verifica si existe los datos de autentificación de un usuario
     * @param strUID	UID
     * @return query
     */
    public static String getExisteUsuario(String strUID)
	{
		String strSql="";		
		//strSql=	"SELECT COUNT(*) FROM SD_USUARIO WHERE USU_ESTATUS=1 AND USU_UID='"+strNombre+"'";
		strSql = "SELECT COUNT(*) FROM SD_AUTENTIFICACION WHERE AUT_NOMBRE_USUARIO='"+strUID+"'";
		return strSql;	
	}
    
    /**
     * Función que regresa un query, donde se valida si el usuario y su 
     * password coinciden con los capturados por el usuarios que intenta 
     * logearse
     * @param strUsuario
     * @param password
     * @return query
     */
    public static String autentificaUsuario(String strUsuario, String password){
	    String sql;
	    sql = "SELECT * FROM SD_AUTENTIFICACION WHERE AUT_NOMBRE_USUARIO='"+strUsuario+"' AND AUT_CLAVE_USUARIO='"+password+"' ";
	    return sql;
	}
    public static String esadmin(String strUsuario){
    	String sqlad;    	
    	sqlad="SELECT * FROM SD_USUARIO WHERE USU_AREA=0 AND USU_UID='" + strUsuario + "'";
    	return sqlad;
    }
}

