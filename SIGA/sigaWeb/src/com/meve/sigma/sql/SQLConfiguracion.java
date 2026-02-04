/**
 * Clase:						SQLConfiguracion.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Mar 13, 2006
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

public class SQLConfiguracion {
    
    /**
     * Inserta configuracion del sistema 
     * @param strDuracion Duracion en dias de un asunto 
     * @param strAmarrillo porcentaje del semaforo amarillo
     * @param strFecha Fecha de actualizacion 
     * @param strRegistro Numero de registros mostrados en la paginacion 
     * @param strPagina Numero de paginas mostradas en la paginacion 
     * @return sql
     */
	public static String getInsertaConf(String strDuracion, String strAmarrillo,
            							String strFecha, String strRegistro, String strPagina){
        String sql = "INSERT INTO SD_CONFIGURACION (ID_CONF, CONF_DURACION, CONF_AMARILLO, CONF_FECHA, CONF_PAGINACION_REG, CONF_PAGINACION_PAG) " +
        			"VALUES (SD_CONFIGURACION_SEQ.NEXTVAL,"+strDuracion+", "+strAmarrillo+", '"+strFecha+"',"+strRegistro+","+strPagina+")";
					//"VALUES (SD_CONFIGURACION_SEQ.NEXTVAL,"+strDuracion+", "+strAmarrillo+", SYSDATE)";
        return sql;
    }
    
    /**
     *  actualiza Configuración
     * @param strDuracion duración
     * @param strAmarrillo amarillo
     * @param strIdConf Id Configuración
     * @return Query
     */
    public static String getUpdateConf(	String strDuracion, String strAmarrillo, 
            							String strIdConf, String strFecha, String strRegistro, String strPagina){
        String sql = "UPDATE SD_CONFIGURACION SET CONF_DURACION="+strDuracion+", " +
        			"CONF_AMARILLO="+strAmarrillo+", CONF_FECHA='"+strFecha+"' " + 
					", CONF_PAGINACION_REG="+strRegistro+ ", CONF_PAGINACION_PAG="+strPagina+" " +
        			//"CONF_AMARILLO="+strAmarrillo+", CONF_FECHA=TO_DATE('"+strFecha+"', 'DD/MM/YYYY') " +
        			"WHERE ID_CONF="+strIdConf;
        return sql;
    }
    
    /**
     *  datos de la Configuración
     * @return query
     */
    public static String getDatosConf(){
        String sql = "SELECT ID_CONF, CONF_DURACION, CONF_AMARILLO, CONF_PAGINACION_REG, CONF_PAGINACION_PAG FROM SD_CONFIGURACION";
        return sql;
    }

}

