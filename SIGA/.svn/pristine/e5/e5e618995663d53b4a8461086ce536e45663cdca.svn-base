/*
 * Clase:						ActualizaConfiguracion.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
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

package com.meve.sigma.actualiza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.meve.sigma.beans.ConfiguracionBean;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLConfiguracion;

/**
 * 	ActualizaConfiguracion es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de Configuración
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaConfiguracion {
    
    /**
     * Inserta registro de la Configuración del sistema
     * @param strDuracion	duración de un asunto
     * @param strAmarillo	Semaforo amarillo
     * @param strFecha		Fecha de Actualización
     * @param strRegistro	Número de registros por página
     * @param strPagina		Número de páginas en la vista
     * @return	true si inserto correctamente
     */
    public static boolean getInsertaConf(String strDuracion, String strAmarillo,
            							String strFecha, String strRegistro, String strPagina)
    {
        int r = 0;
        try
        {
            String strSql = SQLConfiguracion.getInsertaConf(strDuracion, strAmarillo, strFecha, strRegistro, strPagina);
            ////System.out.println("getInsertaConf"+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
       	catch (SQLException sqle)
       	{
       	    //System.out.println("getInsertaConf:"+sqle.getMessage());
       	    sqle.printStackTrace();
       	    return false;
       	}
       	return (r>0);
    }
    
    /**
     * Actualiza registro de la Configuración del sistema
     * @param strDuracion	duración de un asunto
     * @param strAmarrillo	Semaforo amarillo
     * @param strIdConf		strIdConf
     * @param strFecha		Fecha de Actualización
     * @param strRegistro	Número de registros por página
     * @param strPagina		Número de páginas en la vista
     * @return	true si actualizo correctamente
     */
    public static boolean getUpdateConf(	String strDuracion, String strAmarrillo, 
											String strIdConf, String strFecha, 
											String strRegistro, String strPagina)
    {
    	int r=0;
    	try{
    			String strsql = SQLConfiguracion.getUpdateConf(strDuracion, strAmarrillo,
    			        										strIdConf, strFecha, strRegistro, strPagina);
    			////System.out.println("getUpdateConf:"+strsql);
    			r=ConexionDS.ejecutarActualizacion(strsql);
    		}
    		catch(SQLException sqle){
    			//System.out.println("getUpdateConf:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return false;
    		}
    		return (r>0);
    }
    
    /**
     * datos de la Configuración 
     * @return	regresa arreglo de los datos de Configuración
     */
    public static String[][] getDatosConf()
	{
	    try{
	        String strResult[][] = ConexionDS.ejecutarSQL(SQLConfiguracion.getDatosConf());
	        
	        return strResult;
	    }catch(SQLException sqle){
	        //System.out.println(" getDatosConf:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
	    }
	}
    
    /**
     * datos de la Configuración pasandole una conexion 
     * @return	regresa un objeto ConfiguracionBean con los datos de Configuración
     */
    public static ConfiguracionBean getDatosConf(Connection conn)
	{
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	ConfiguracionBean conf = new ConfiguracionBean();
	    try{
	    	pstmt = conn.prepareStatement(SQLConfiguracion.getDatosConf());
	    	rs= pstmt.executeQuery();
	    	while(rs.next()){
	    		conf.setIdConfiguracion(rs.getInt("ID_CONF"));
	    		conf.setDuracion(rs.getInt("CONF_DURACION"));
	    		conf.setPaginacionPaginasMostrables(rs.getInt("CONF_PAGINACION_REG"));
	    		conf.setPaginacionRegistrosPorPagina(rs.getInt("CONF_PAGINACION_PAG"));
	    		conf.setSemaforoPorcentajeAmarillo(rs.getInt("CONF_AMARILLO"));	
	    	}
	        return conf;
	    }catch(SQLException sqle){
			sqle.printStackTrace();
			return null;
	    }finally{
	    	ConexionDS.endConnection(rs, pstmt, null);
	    }
	}

}

