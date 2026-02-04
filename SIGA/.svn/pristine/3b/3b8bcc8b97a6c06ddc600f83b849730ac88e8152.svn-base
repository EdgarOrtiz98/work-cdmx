/*
 * Clase:						SQLExpediente.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Sep 22, 2005
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
 * SQLEntidad es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_ENTIDAD
 * @author Meve Soluciones SA de CV
 *
 */
public class SQLExpediente {
    
    /**
     * Función que regresa un query para Insertar un registro en la tabla de SD_CAREA,
     * a partir de pasar algunos parametros
     * @param idArea		String
     * @param expediente	String
     * @param idActualizo	String
     * @param fechaUpdate	String
     * @return Regresa un String con el Query correspondiente
     */
    public static String getInsertaExpediente(	String idArea, String expediente,
            									String idActualizo,	String fechaUpdate)
    {
        String sql = 	"INSERT INTO SD_EXPEDIENTE (ID_EXPEDIENTE, EXP_AREA, EXP_DESCRIPCION, EXP_USR_ACTUALIZO," +
        				" EXP_FEC_ACTUALIZACION, EXP_ESTATUS) " +
        				//" VALUES (SD_EXPEDIENTE_SEQ.NEXTVAL, "+idArea+", '"+expediente+"', "+idActualizo+", '"+fechaUpdate+"', 1)";
        				" VALUES (SD_EXPEDIENTE_SEQ.NEXTVAL, "+idArea+", '"+expediente+"', "+idActualizo+", SYSDATE, 1)";

        return sql;
    }
    
    /**
     * Función que regresa el query para construir un Combo
     * @return Regresa un String con el Query correspondiente
     */
    public static String getExpedienteCombo(String strExpediente)
	{
		String strSql="";		
		strSql=	"SELECT  ID_EXPEDIENTE, EXP_CLAVE || '/' || EXP_DENOMINACION FROM SD_EXPEDIENTES WHERE EXP_CVE_UA="+strExpediente+" AND EXP_STATUS=1 ORDER BY EXP_DENOMINACION";												
		return strSql;	
	}
    
    /**
     * Verifica si existen los expedientes
     * @param strIdArea	id área
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getExisteExpedientesPorArea(String strIdArea){
        String sql = "SELECT * FROM SD_EXPEDIENTES WHERE EXP_CVE_UA="+strIdArea+" AND EXP_STATUS=1";
        return sql;
    }
    
    /**
     * 
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getExpedienteComboGral()
	{
		String strSql="";		
		strSql=	"SELECT  ID_EXPEDIENTE, EXP_DENOMINACION FROM SD_EXPEDIENTES WHERE EXP_STATUS=1 ORDER BY EXP_DESCRIPCION";												
		return strSql;	
	}
    
    /**
     * Función que regresa el query para construir un Combo Archivado
     * @return Regresa un String con el Query correspondiente
     */
    public static String getExpedienteComboArch(String strExpediente)
	{
		String strSql="";		
		strSql=	"SELECT  ID_EXPEDIENTE, EXP_DENOMINACION FROM SD_EXPEDIENTES WHERE EXP_CVE_UA="+strExpediente+" AND EXP_STATUS=1 ORDER BY EXP_DENOMINACION";												
		return strSql;	
	}
    
    /**
     * Verifica si existen los expedientes
     * @param strIdArea	id área
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getExisteExpedientesPorAreaArch(String strIdArea){
        String sql = "SELECT * FROM SD_EXPEDIENTES WHERE EXP_CVE_UA="+strIdArea+" AND EXP_STATUS=1";
        return sql;
    }
    
    /**
     * Combo de los expedientes generales
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getExpedienteComboGralArch()
	{
		String strSql="";		
		strSql=	"SELECT  ID_EXPEDIENTE, EXP_DENOMINACION FROM SD_EXPEDIENTES WHERE EXP_CVE_UA=0 " +
				"AND EXP_STATUS=1 ORDER BY EXP_DENOMINACION";												
		return strSql;	
	}
    
    /**
     * Función que regresa un query para crear una lista de los Expedientes existenes
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getListaExpediente(String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	"SELECT ID_EXPEDIENTE, EXP_DESCRIPCION, EXP_AREA, ARE_NOMBRE ";
		strSql+="FROM SD_EXPEDIENTE, SD_AREA WHERE EXP_ESTATUS=1 ";
		strSql+="AND SD_EXPEDIENTE.EXP_AREA=SD_AREA.ID_AREA ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}
		return strSql;	
	}
    
    /**
     * Función que regresa un query para comprobar si existen registros 
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getExiste()
    {
        String strSql="";		
		strSql=	"SELECT * FROM SD_EXPEDIENTE"; 
		return strSql;
    }
    
    /**
     * Función que regresa un query de borrado logico asignado el valor
     * de EXP_ESTATUS=0
     * @param strIds Id a eliminar
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDeleteExpediente(String strIds[])
	{
	    String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);				
		strSql=	" UPDATE SD_EXPEDIENTE SET"	+
				" EXP_ESTATUS=0 WHERE ID_EXPEDIENTE IN ("+ids + ")";				
		return strSql;
    	
	}
    
    /**
     * Actualiza registro de expedientes
     * @param strIdArea		Id área
     * @param strDescripcion	Descripción
     * @param strUsrUpdate		usuario que actualizá
     * @param strFechaUpdate	fecha Actualización
     * @param strIdExp			id expediente
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getActualizarExpediente(	String strIdArea,String strDescripcion,
													String strUsrUpdate, String strFechaUpdate, 
													String strIdExp)
    {
        String strSql="";		
        strSql=	"UPDATE SD_EXPEDIENTE SET " +
        		"EXP_AREA="+strIdArea+", EXP_DESCRIPCION='"+strDescripcion+"', " +
        		"EXP_USR_ACTUALIZO="+strUsrUpdate+", EXP_FEC_ACTUALIZACION=TO_DATE('"+strFechaUpdate+"', 'DD/MM/YYYY') " +
        		"WHERE ID_EXPEDIENTE="+strIdExp; 
        return strSql;
    }
    
    /**
     * Lista de expedientes para formar combo
     * @param strIdExpediente	Id Expediente
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getDatosExpediente(String strIdExpediente)
    {
        String strSql="";		
		strSql=	"SELECT EXP_AREA, EXP_DESCRIPCION FROM SD_EXPEDIENTE WHERE ID_EXPEDIENTE="+strIdExpediente; 
		return strSql;
    }
    
    /**
     * Nombre del expediente
     * @param strIdExpediente	Id expediente
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getNombreExpediente(String strIdExpediente)
    {
        String strSql="";		
		strSql=	"SELECT EXP_CLAVE || '/' || EXP_DENOMINACION FROM SD_EXPEDIENTES WHERE ID_EXPEDIENTE="+strIdExpediente; 
		return strSql;
    }
    
}

