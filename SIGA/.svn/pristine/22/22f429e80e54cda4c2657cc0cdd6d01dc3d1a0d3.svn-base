/*
 * Clase:						SQLHistorial.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Oct 5, 2005
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
 * SQLFolio es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_FOLIO
 * @author Meve Soluciones SA de CV
 *
 */
public class SQLHistorial {
    
    /**
     * Función que regresa el query de Insertar un Avance al responder
     * una instrucción.
     * 
     * @param strIdInstruccion 	String Contiene el ID de la instrucción
     * @param strIdAsunto 		String Contiene el ID de Asunto
     * @param strComentario		String Contiene el Comentario de la repsuesta de la instrucción
     * @param strUsrResponde	String Contiene el ID del Usuario que respondio
     * @param strAvance			String Contiene el avance que asigna el usuario a la instrucción
     * @return sql				String Retorna query
     */
    public static String InsertarRespuesta(	String strIdInstruccion, String strIdAsunto, String strComentario, String strUsrResponde,
            								String strAvance, String strFecha, String strPuesto)
    {
        String sql = "";
        sql = 	"INSERT INTO SD_HISTORIAL_INSTRUCCIONES (ID_HISTORIAL,ID_INSTRUCCION_ASUNTO, ID_ASUNTO, " +
        		"HIS_COMENTARIOS, HIS_USUARIO, HIS_AVANCE, HIS_VIGENCIA, HIS_FECHA, HIS_EVENTO, HIS_PUESTO) "+
        		"VALUES (SD_HISTORIAL_INSTRUCCIONES_SEQ.NEXTVAL, "+strIdInstruccion+", "+strIdAsunto+", '"+strComentario+"', " +
        		//""+strUsrResponde+", "+strAvance+", 0, '"+strFecha+"', 1)";
        		""+strUsrResponde+", "+strAvance+", 0, SYSDATE, 1, '"+strPuesto+"')";
        return sql;
    }
    
    /**
     * Función que regresa el query que inserta un rechazo en el historial
     * de una instrucción
     * @param strIdInstruccion	String Contiene el ID de la instrucción
     * @param strIdAsunto 	   	String Contiene el ID de Asunto
     * @param strRazon			String Contiene la razon de rechazo de la instrucción
     * @param strIdUsrRechazo	String Contiene el ID del usuario que ha rechazado
     * @param strAvance			String Contiene el Avance actual de la instrucción
     * @param strFecha			String Contiene la fecha en la que se ha rechazado la instrucción
     * @return					sql
     */
    public static String InsertarRechazo(String strIdInstruccion, String strIdAsunto, String strRazon,String strIdUsrRechazo, String strAvance, String strFecha, String strPuesto){
        String sql = "";
        sql = 	"INSERT INTO SD_HISTORIAL_INSTRUCCIONES (ID_HISTORIAL,ID_INSTRUCCION_ASUNTO, ID_ASUNTO, HIS_COMENTARIOS, " +
        		"HIS_USUARIO, HIS_AVANCE, HIS_FECHA, HIS_EVENTO, HIS_VIGENCIA, HIS_PUESTO) VALUES (SD_HISTORIAL_INSTRUCCIONES_SEQ.NEXTVAL, "+strIdInstruccion+", "+strIdAsunto+", " +
        		//"'"+strRazon+"', "+strIdUsrRechazo+", "+strAvance+", '"+strFecha+"', 2, 0)";
        		"'"+strRazon+"', "+strIdUsrRechazo+", "+strAvance+", SYSDATE, 2, 0, '"+strPuesto+"')";
        return sql;
    }
    
    
    /**
     * Función que regresa el query que inserta un nuevo comentario en el historial
     * de una instrucción
     * @param strIdInstruccion	String Contiene el ID de la instrucción
     * @param strIdAsunto 	   	String Contiene el ID de Asunto
     * @param strComentario		String Contiene el comentario a la instrucción
     * @param strIdUsrComentario  String Contiene el ID del usuario que ha agregado el comentario a la instrucción
     * @param strAvance			String Contiene el Avance actual de la instrucción
     * @param strFecha			String Contiene la fecha en la que se ha rechazado la instrucción
     * @return					sql
     */
    
    public static String InsertarComentario(	String strIdInstruccion, String strIdAsunto, String strComentario,
			String strIdUsrComentario, String strAvance, String strFecha, String strPuesto)
    {
    	String sql = "";
    	sql = 	"INSERT INTO SD_HISTORIAL_INSTRUCCIONES (ID_HISTORIAL, ID_INSTRUCCION_ASUNTO, ID_ASUNTO, HIS_COMENTARIOS, " +
		"HIS_USUARIO, HIS_AVANCE, HIS_FECHA, HIS_EVENTO, HIS_VIGENCIA, HIS_PUESTO) VALUES (SD_HISTORIAL_INSTRUCCIONES_SEQ.NEXTVAL, "+strIdInstruccion+", "+strIdAsunto+", " +
		//"'"+strComentario+"', "+strIdUsrComentario+", "+strAvance+", '"+strFecha+"', 6, 0)";
		"'"+strComentario+"', "+strIdUsrComentario+", "+strAvance+", SYSDATE, 6, 0, '"+strPuesto+"')";
    	return sql;
    }
    
    
    
    /**
     * Función que regresa el query que inserta una Reasignacio en el historial
     * de una instruccion		
     * @param strIdInstruccion	String Contiene el ID de la instrucción
     * @param strIdAsunto		String Contiene el ID de Asunto
     * @param strComentarios	String Contiene un comentario sobre la reasignación
     * @param strIdUsuario		String Contiene el ID del usuario al que se reasigno
     * @param strIdUsrReasig	String Contiene el ID del usuarios que reasigno
     * @param strFecha			String Contiene la fecha en la que se hizo la reasignación
     * @return					sql
     */
    public static String InsertarReasignacion(String strIdInstruccion, String strIdAsunto, String strComentarios,String strIdUsrDeleg, String strFecha, String strPuesto){
        String sql = "INSERT INTO SD_HISTORIAL_INSTRUCCIONES (ID_HISTORIAL,ID_INSTRUCCION_ASUNTO, ID_ASUNTO, HIS_COMENTARIOS, " +
        "HIS_USUARIO, HIS_FECHA, HIS_EVENTO, HIS_VIGENCIA, HIS_PUESTO) VALUES (SD_HISTORIAL_INSTRUCCIONES_SEQ.NEXTVAL, "+strIdInstruccion+", "+strIdAsunto+", " +
        //"'"+strComentarios+"', "+strIdUsrDeleg+", '"+strFecha+"', 3, 0)";
        "'"+strComentarios+"', "+strIdUsrDeleg+", SYSDATE, 3, 0, '"+strPuesto+"')";
        return sql;
    }
    
    /**
     * Función que regresa un query que inserta la Delegación de una instrucción
     * en el historial
     * @param strIdInstruccion	String Contiene el ID de la instrucción
     * @param strIdAsunto		String Contiene el ID de Asunto
     * @param strComentarios	String Contiene un comentario sobre la Delegación
     * @param strIdUsrDeleg		String Contiene el ID del usuarios que delego
     * @param strFecha			String Contiene la fecha en la que se hizo la reasignación
     * @return					Sql 
     */
    public static String InsertarDelegar(String strIdInstruccion, String strIdAsunto, String strComentarios,
			String strIdUsrReasig, String strFecha, String strPuesto)
    {
        String sql = "";
        sql = 	"INSERT INTO SD_HISTORIAL_INSTRUCCIONES (ID_HISTORIAL, ID_INSTRUCCION_ASUNTO, ID_ASUNTO, HIS_COMENTARIOS, " +
        "HIS_USUARIO, HIS_FECHA, HIS_EVENTO, HIS_VIGENCIA, HIS_DELEGACION_LIBERADO, HIS_PUESTO) VALUES (SD_HISTORIAL_INSTRUCCIONES_SEQ.NEXTVAL, "+strIdInstruccion+", "+strIdAsunto+", " +
        //"'"+strComentarios+"', "+strIdUsrReasig+", '"+strFecha+"', 4, 1, 0)";
        "'"+strComentarios+"', "+strIdUsrReasig+", SYSDATE, 4, 1, 0, '"+strPuesto+"')";
        return sql;
    }
    
    /**
     * 
     * @param strIdInstruccion
     * @param strIdAsunto
     * @param strComentario
     * @param strUsrResponde
     * @param strAvance
     * @param strFecha
     * @return	Regresa un String con el Query correspondiente
     */
    public static String InsertarHabilitado(String strIdInstruccion, String strIdAsunto,
											String strUsrResponde,
											String strAvance, String strFecha, String strPuesto)
    {
        String sql = "";
        sql = 	"INSERT INTO SD_HISTORIAL_INSTRUCCIONES (ID_HISTORIAL,ID_INSTRUCCION_ASUNTO, ID_ASUNTO, " +
        "HIS_USUARIO, HIS_AVANCE, HIS_VIGENCIA, HIS_FECHA, HIS_EVENTO, HIS_PUESTO)" +
        " VALUES (SD_HISTORIAL_INSTRUCCIONES_SEQ.NEXTVAL, "+strIdInstruccion+", "+strIdAsunto+", " +
        //""+strUsrResponde+", "+strAvance+", 0, '"+strFecha+"', 5)";
        ""+strUsrResponde+", "+strAvance+", 0, SYSDATE, 5, '"+strPuesto+"')";
        return sql;
    }
    
    /**
     * Función que regresa un query con una lista del historial de una instrucción
     * dependiendo de su ID
     * @param strIdInstruccion String Contiene el ID de la instrucción
     * @return sql String Retorna query
     */
    public static String getHistorialInstruccion(String strIdInstruccion)
    {
        String sql = "";
        sql = 	"SELECT ID_HISTORIAL, ID_ASUNTO, TO_CHAR(HIS_FECHA, 'dd/MM/yyyy HH24:MI:SS'), " +
        		"HIS_USUARIO, HIS_AVANCE, HIS_COMENTARIOS, " +
        		"HIS_EVENTO, HIS_PUESTO, HIS_COMENTARIO_OTRO, USU_CARGO || ' / ' || USU_NOMBRE " +
        		"FROM SD_HISTORIAL_INSTRUCCIONES, SD_USUARIO WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion+" " +
        		"AND SD_HISTORIAL_INSTRUCCIONES.HIS_USUARIO=SD_USUARIO.ID_USUARIO " +
        		"ORDER BY 1 DESC";
        return sql;
    }
    
    /**
     * Función que regresa un query para verificar si la instrucción tiene datos
     * @param strIdInstruccion String Contiene el ID de la Instruccion
     * @return sql Retorna query
     */
    public static String TieneHistorial(String strIdInstruccion)
    {
        String sql = "";
        sql = 	"SELECT * FROM SD_HISTORIAL_INSTRUCCIONES " +
        		"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
        return sql;
    }
    
    /**
     * 
     * @param strIdHistorial
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getHistorial(String strIdHistorial)
    {
        String sql = "";
        sql = 	"SELECT HIS_COMENTARIOS, HIS_AVANCE FROM SD_HISTORIAL_INSTRUCCIONES " +
        		"WHERE ID_HISTORIAL="+strIdHistorial;
        return sql;
    }
    
    /**
     * Función que forma un query para traer una lista de las respuestas de una instrucción
     * @param strIdInstruccion
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getHistorialRespuestasPorInstruccion(String strIdInstruccion){
    	String sql = "";
    	sql = "SELECT ID_HISTORIAL, HIS_COMENTARIOS, TO_CHAR(HIS_FECHA, 'dd/MM/yyyy') " +
    			"FROM SD_HISTORIAL_INSTRUCCIONES " +
    			"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion+" AND HIS_EVENTO=1";
    	return sql;
    }
    
    /**
     * Inserta el historial del cambio de la fecha de solicitud
     * @param strIdInstruccion	Id de la instrucción
     * @param strComentarios	Comentarios
     * @param strFechaActual	Fecha Actual
     * @param strFechaSolicitud	Fecha Solicitada
     * @param strPuesto			Puesto
     * @param strUsuario		usuario
     * @param strIdAsunto		id usuario
     * @return	Regresa un String con el Query correspondiente
     */
    public static String insertarSolCambioFecha(String strIdInstruccion,  
    											String strComentarios, String strFechaActual, 
												String strFechaSolicitud, String strPuesto,
												String strUsuario, String strIdAsunto)
    {
    	String sql = "";  
    	sql = 	"INSERT INTO SD_HISTORIAL_INSTRUCCIONES (ID_HISTORIAL, ID_INSTRUCCION_ASUNTO, " +
    			"HIS_COMENTARIOS, HIS_COMENTARIO_OTRO, HIS_USUARIO, HIS_FECHA, HIS_EVENTO, " +
    			"HIS_PUESTO, HIS_VIGENCIA, ID_ASUNTO) " +
    			"VALUES (SD_HISTORIAL_INSTRUCCIONES_SEQ.NEXTVAL, "+strIdInstruccion+", '"+strComentarios+"', " +
				"'solicitó prorroga de fecha del "+strFechaActual+" al "+strFechaSolicitud+"', " +
				""+strUsuario+", SYSDATE, 7, '"+strPuesto+"', 0, "+strIdAsunto+")";
    	return sql;
    }
    
    /**
     * Inserta el historial del cambio de la fecha de solicitud rechazada
     * @param strIdInstruccion	Id de la instrucción
     * @param strComentarios	Comentarios
     * @param strFechaActual	Fecha Actual
     * @param strFechaSolicitud	Fecha Solicitada
     * @param strPuesto			Puesto
     * @param strUsuario		usuario
     * @param strIdAsunto		id usuario
     * @return	Regresa un String con el Query correspondiente
     */
    public static String insertarSolCambioFechaRechazo(	String strIdInstruccion,  
														String strComentarios, String strPuesto,
														String strUsuario, String strIdAsunto)
    {
    	String sql = "";  
    	sql = 	"INSERT INTO SD_HISTORIAL_INSTRUCCIONES (ID_HISTORIAL, ID_INSTRUCCION_ASUNTO, " +
			"HIS_COMENTARIOS, HIS_COMENTARIO_OTRO, HIS_USUARIO, HIS_FECHA, HIS_EVENTO, " +
			"HIS_PUESTO, HIS_VIGENCIA, ID_ASUNTO) " +
			"VALUES (SD_HISTORIAL_INSTRUCCIONES_SEQ.NEXTVAL, "+strIdInstruccion+", '"+strComentarios+"', " +
			"'Rechazó la prorroga de la fecha', " +
			""+strUsuario+", SYSDATE, 8, '"+strPuesto+"', 0, "+strIdAsunto+")";
    	return sql;
    }
    
    /**
     * Inserta el historial del cambio de la fecha de solicitud aceptada
     * @param strIdInstruccion	Id de la instrucción
     * @param strComentarios	Comentarios
     * @param strFechaActual	Fecha Actual
     * @param strFechaSolicitud	Fecha Solicitada
     * @param strPuesto			Puesto
     * @param strUsuario		usuario
     * @param strIdAsunto		id usuario
     * @return	Regresa un String con el Query correspondiente
     */
    public static String insertarSolCambioFechaAceptacion(	String strIdInstruccion,  
															String strComentarios, String strPuesto,
															String strUsuario, String strIdAsunto)
    {
    	String sql = "";  
    	sql = 	"INSERT INTO SD_HISTORIAL_INSTRUCCIONES (ID_HISTORIAL, ID_INSTRUCCION_ASUNTO, " +
			"HIS_COMENTARIOS, HIS_COMENTARIO_OTRO, HIS_USUARIO, HIS_FECHA, HIS_EVENTO, " +
			"HIS_PUESTO, HIS_VIGENCIA, ID_ASUNTO) " +
			"VALUES (SD_HISTORIAL_INSTRUCCIONES_SEQ.NEXTVAL, "+strIdInstruccion+", '"+strComentarios+"', " +
			"'autorizó la prorroga de la fecha', " +
			""+strUsuario+", SYSDATE, 9, '"+strPuesto+"', 0, "+strIdAsunto+")";
    	return sql;
    }

}

