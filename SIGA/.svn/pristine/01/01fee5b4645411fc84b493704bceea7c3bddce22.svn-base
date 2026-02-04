/**
 * Clase:						SQLFlujo.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Sep 23, 2005
 * 
 * @author: 					Luis Melgoza
 * 								luis.melgoza@tecnoaplicada.com
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		
 */

package com.meve.sigma.sql;

/**
 * SQLFlujo es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_ENTIDAD
 * @author Meve Soluciones SA de CV
 *
 */
public class SQLFlujo {
    
    /**
     * Inserta ruta Automática
     * @param strFlujoArea	área
	 * @param strFlujoTipoDoc	tipo de documento
	 * @param strFlujoTipoAsunto	Tipo de asunto
	 * @param strCreador1		usuario que actualiza o crea el registro
	 * @param strFechaCreacion	fecha Creación
	 * @param strEstatus		Estatus
	 * @param strDescripcion	Descripción
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getInsertaFlujo(	String strFlujoArea, String strFlujoTipoDoc, 
    		String strFlujoTipoAsunto, String strCreador1, String strFechaCreacion, String strEstatus, 
			String strDescripcion)
    {
        String sql = 	"INSERT INTO SD_RUTA_AUTOMATICA (ID_RUTA_AUTOMATICA, RUT_AUT_AREA, RUT_AUT_TIPO_DOCTO," +
        				" RUT_AUT_TIPO_ASUNTO, RUT_AUT_FEC_ACTUALIZACION, RUT_AUT_USR_ACTUALIZO, RUT_AUT_ESTATUS, " +
        				" RUT_AUT_DESCRIPCION) VALUES (SD_RUTA_AUTOMATICA_SEQ.NEXTVAL,"+strFlujoArea+", " +
        				""+strFlujoTipoDoc+", "+strFlujoTipoAsunto+", " +
        				//"'"+strFechaCreacion+"', "+strCreador1+", "+strEstatus+", '"+strDescripcion+"')";
        				"SYSDATE, "+strCreador1+", "+strEstatus+", '"+strDescripcion+"')";
        
        return sql;
    }
    
    /**
     * 
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getFlujoCombo()
    {
        String strSql="";		
		strSql=	"SELECT  ID_RUTA_AUTOMATICA, RUT_AUT_AREA FROM SD_RUTA_AUTOMATICA WHERE RUT_AUT_ESTATUS=1 ORDER BY ID_RUTA_AUTOMATICA";												
		return strSql;	
    }
    
    /**
     * 
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getFlujoAreaCombo(String strIdDocto)
    {
        String strSql="";		
		strSql=	"SELECT  ID_RUTA_AUTOMATICA, RUT_AUT_DESCRIPCION, RUT_AUT_AREA " +
				"FROM SD_RUTA_AUTOMATICA WHERE rut_aut_tipo_docto="+strIdDocto+" " +
				"AND RUT_AUT_ESTATUS=1 " +
				"ORDER BY 2";												
		return strSql;	
    }
    
    /**
     * Lista de ruta de atención
	 * @param strOrden	orden
	 * @param tipo		tipo de orden
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getFlujos(String strOrden, String tipo)
	{
		String strSql="";		
		strSql+="SELECT RUT_AUT_DESCRIPCION, ID_RUTA_AUTOMATICA, RUT_AUT_AREA ";
		strSql+="FROM SD_RUTA_AUTOMATICA WHERE RUT_AUT_ESTATUS=1";
		if(tipo.equals("1")){
			strSql+="ORDER BY 1 "+strOrden+", 1 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 2 "+strOrden+", 1 ASC ";
		}
		return strSql;	
	}
    
    /**
     * Datos de la ruta de atención
     * @param idFlujo	id flujo
     * @return lista flujo
     */
    public static String getFlujo(String idFlujo)
	{
		String strSql="";		
		strSql=	" SELECT RUT_AUT_AREA, RUT_AUT_TIPO_DOCTO, RUT_AUT_TIPO_ASUNTO, RUT_AUT_DESCRIPCION, RUT_AUT_USR_ACTUALIZO, TO_CHAR(RUT_AUT_FEC_ACTUALIZACION, 'DD/MM/YYYY HH:MI:SS AM') " +
				" FROM SD_RUTA_AUTOMATICA WHERE RUT_AUT_ESTATUS=1 AND ID_RUTA_AUTOMATICA="+idFlujo; 
		return strSql;	
	}
    
    /**
     * Elimian ruta
     * @param strIds	id ruta
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getDeleteFlujo(String strIds)
	{
	    String strSql="";
		strSql=	" UPDATE SD_RUTA_AUTOMATICA SET RUT_AUT_ESTATUS=0 WHERE "	+
				"ID_RUTA_AUTOMATICA IN ("+strIds+")";
		return strSql;
	}
    
    /**
     * 
     * @param strId
     * @param strIdArea
     * @param strIdTipoDoc
     * @param strIdTipoAsunto
     * @param strDescripcion
     * @return	Regresa un String con el Query correspondiente
     */
    public static String findFlujos(String strId, String strIdArea, String strIdTipoDoc, String strIdTipoAsunto, String strDescripcion)
	{
		String strSql="";		
		strSql=	" SELECT ID_RUTA_AUTOMATICA FROM SD_RUTA_AUTOMATICA WHERE RUT_AUT_ESTATUS=1"
				+" AND RUT_AUT_AREA="+strIdArea+" AND RUT_AUT_DESCRIPCION='"+strDescripcion+"' AND RUT_AUT_TIPO_DOCTO="
				+strIdTipoDoc+" AND RUT_AUT_TIPO_ASUNTO="+strIdTipoAsunto; 
		return strSql;	
	}
    
    /**
     * actualiza ruta Automática
     * @param strId	id ruta
     * @param strFlujoArea	área
	 * @param strFlujoTipoDoc	tipo de documento
	 * @param strFlujoTipoAsunto	Tipo de asunto
	 * @param strCreador1		usuario que actualiza o crea el registro
	 * @param strFechaCreacion	fecha Creación
	 * @param strEstatus		Estatus
	 * @param strDescripcion	Descripción
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getActualizaFlujo(	String strId,String strFlujoArea, String strFlujoTipoDoc, 
    										String strFlujoTipoAsunto, String strCreador1, 
    										String strFechaCreacion, String strEstatus, 
    										String strDescripcion)
    {
        String sql ="UPDATE SD_RUTA_AUTOMATICA SET RUT_AUT_TIPO_DOCTO="+strFlujoTipoDoc
    				+", RUT_AUT_AREA="+strFlujoArea+", RUT_AUT_DESCRIPCION='"+strDescripcion+"', " +
    				//"RUT_AUT_FEC_ACTUALIZACION='"+strFechaCreacion+"', RUT_AUT_ESTATUS="+strEstatus+", " +
    				//"RUT_AUT_FEC_ACTUALIZACION=TO_DATE('"+strFechaCreacion+"', 'DD/MM/YYYY'), " +
    				"RUT_AUT_FEC_ACTUALIZACION=SYSDATE, " +
    				"RUT_AUT_ESTATUS="+strEstatus+", " +
    				"RUT_AUT_TIPO_ASUNTO="+strFlujoTipoAsunto
    				+", RUT_AUT_USR_ACTUALIZO="+strCreador1+" WHERE "+"ID_RUTA_AUTOMATICA IN ("+ strId + ")";

    	return sql;
    }
    
    /**
     * Detalle de la ruta
	 * @param strIdRuta	id ruta
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getDetalleRuta(String strIdRuta)
    {
        String sql = "";
        sql = "SELECT DET_RUTA_USUARIO, DET_RUTA_INSTRUCCION, DET_RUTA_INSTRUCCION_OTRO, " +
        		"DET_RUTA_TIPO_ATENCION, DET_RUTA_PASO, DET_RUTA_TIEMPO, DET_RUTA_ACCESO, " +
        		"DET_RUTA_REQUERIDO, DET_RUTA_CONFIDENCIAL FROM SD_DETALLLE_RUTA " +
        		"WHERE ID_RUTA_AUTOMATICA="+strIdRuta+" ORDER BY ID_DET_RUTA";
        return sql;
    }
    
    /**
     * Ultimo Id de la ruta
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getUltimoIDRuta()
	{
	    String strSql="";		
		strSql=	"SELECT MAX(ID_RUTA_AUTOMATICA) FROM SD_RUTA_AUTOMATICA";
		return strSql;
	}
    
    /**
     * Verifica si existe la ruta Automática
	 * @param strDescripcion	Descripción de la ruta
	 * @param strAux			Auxiliar
	 * @param strArea			área
	 * @param strAux2			Auxiliar2
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getRutaExiste(String strDescripcion, String strAux, String strArea, String strAux2){
    	String sql = "SELECT RUT_AUT_DESCRIPCION FROM SD_RUTA_AUTOMATICA " +
    			"WHERE NOT(LOWER(RUT_AUT_DESCRIPCION) = LOWER('"+strAux+"') " +
    			"AND LOWER(RUT_AUT_AREA) = LOWER('"+strAux2+"')) " +
    			"AND LOWER(RUT_AUT_DESCRIPCION) = LOWER('"+strDescripcion+"') " +
    			"AND LOWER(RUT_AUT_AREA) = LOWER('"+strArea+"') " +
    			"AND RUT_AUT_ESTATUS = 1";
    	return sql;
    }


}

