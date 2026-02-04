/*
 * Clase:						SQLTipoRespuesta.java
 * 
 * Paquete:						com.meve.sigma.sql		
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

package com.meve.sigma.sql;

/**
 * Clase para generar codigo SQL para Tipo de Respuesta
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class SQLTipoRespuesta {
    
    public static String getTipoRespuestaCombo()
	{
		String strSql="";		
		strSql=	"SELECT ID_TIPO_RESPUESTA, TIP_RES_NOMBRE" +
				" FROM SD_TIPO_RESPUESTA WHERE TIP_RES_ESTATUS=1 " +
				" ORDER BY 2";												
		return strSql;	
	}
    
    /**
	 * Construye un SQL Query para Regresar los campos de Tipo de Respuesta por ID
	 * @param stridRespuesta ID del Tipo de Respuesta
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getTipoRespuesta(String stridRespuesta)
	{
		String strSql="";		
		strSql=	"SELECT TIP_RES_NOMBRE, to_char(TIP_RES_FECHA, 'dd/MM/yyyy'), TIP_RES_ESTATUS," +
				" TIP_RES_URS " +
				" FROM SD_TIPO_RESPUESTA" +
				" WHERE ID_TIPO_RESPUESTA="+stridRespuesta;
		return strSql;
	}
    
    /**
	 * Construye un SQL Query para Regresar los campos de Tipo de Respuesta
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getTipoRespuesta()
	{
		String strSql="";
		strSql=	"SELECT ID_TIPO_RESPUESTA, TIP_RES_NOMBRE, to_char(TIP_RES_FECHA, 'dd/MONTH/yyyy')," +
				" TIP_RES_ESTATUS, TIP_RES_URS " +
				" FROM SD_TIPO_RESPUESTA " +
				" WHERE TIP_RES_ESTATUS=1 " +
				" ORDER BY 2";												
		return strSql;	
	}

    /**
	 * Construye un SQL Query para Insertar un Tipo de Respuesta en la BD 
	 * @param nombre Nombre
	 * @param actualizo Usuarios que actualizá
	 * @param fecha Fecha de actualizacion
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getInsertaTipoRespuesta(String nombre, 
											String actualizo, String fecha)
    {
        String sql = "";
        sql = 	"INSERT INTO SD_TIPO_RESPUESTA" +
        		" (ID_TIPO_RESPUESTA, TIP_RES_NOMBRE, TIP_RES_FECHA," +
				" TIP_RES_ESTATUS, TIP_RES_URS)" +
        		//" VALUES (SD_TIPO_RESPUESTA_SEQ.NEXTVAL,'"+nombre+"', '"+fecha+"', "+
				" VALUES (SD_TIPO_RESPUESTA_SEQ.NEXTVAL,'"+nombre+"', SYSDATE, "+
        		" 1, "+actualizo+")";
        return sql;
    }
    
    /**
	 * Construye un SQL Query para Actualiza un Tipo de Respuesta en la BD 
	 * @param idTipoRespuesta ID tipo de Respuesta
	 * @param nombre Nombre
	 * @param actualizo Usuarios que actualizá
	 * @param fecha Fecha de actualizacion
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getActualizarTipoRespuesta(String idTipoRespuesta, String nombre, 
													String actualizo, String fecha)
    {
    	String strSql="";
    	strSql=	"UPDATE SD_TIPO_RESPUESTA SET" +
		" TIP_RES_NOMBRE='"+nombre+"', TIP_RES_URS="+actualizo+", " +
		//" TIP_RES_FECHA='"+fecha+"'" +
		" TIP_RES_FECHA=TO_DATE('"+fecha+"', 'DD/MM/YYYY')" +
		" WHERE ID_TIPO_RESPUESTA="+idTipoRespuesta;
    	return strSql;
    }

    /**
	 * Construye un SQL Query para Eliminar logicamente los registros de Tipo de Asunto
	 * @param strIds ID's de los Tipos de Respuesta
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getDeleteTipoRespuesta(String strIds[])
	{
		String strSql="";  
		String ids="";  
		for(int i=0; i<strIds.length;i++) 
			ids+=strIds[i]+","; 
		ids=ids.substring(0,ids.length()-1);
		strSql=	" UPDATE SD_TIPO_RESPUESTA SET"	+
		" TIP_RES_ESTATUS=0 WHERE ID_TIPO_RESPUESTA IN ("+ids + ")";				
		return strSql;    	
	}
	
	/**
	 * Construye un SQL Query para Regresar el nombre del Tipo de Respuesta segun su ID
	 * @param idTipoRespuesta ID tipo de Respuesta
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getNombreTipoRespuesta(String idTipoRespuesta)
	{
	    String sql = "";
	    sql = "SELECT TIP_RES_NOMBRE FROM SD_TIPO_RESPUESTA " +
	    		"WHERE ID_TIPO_RESPUESTA="+idTipoRespuesta;
	    return sql;
	}
	
	/**
	 * Construye un SQL Query para Validar si existen Tipos de Respuesta
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String existenTipoRespuesta(){
	    String sql = "SELECT * FROM SD_TIPO_RESPUESTA WHERE TIP_RES_ESTATUS=1";
	    return sql;
	}
	
	/**
	 * Construye un SQL Query para Regresar una lista de los Tipos de Respuesta
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getTiposRespuestaPortal(){
		String sql = "SELECT ID_TIPO_RESPUESTA, TIP_RES_NOMBRE FROM SD_TIPO_RESPUESTA WHERE TIP_RES_ESTATUS=1";
		return sql;
	}

}

