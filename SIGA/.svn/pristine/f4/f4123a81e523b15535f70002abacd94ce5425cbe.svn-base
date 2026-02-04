/*
 * Clase:						SQLUbicacion.java
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
 * Clase para generar codigo SQL para Ubicación
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class SQLUbicacion {
    
	/**
	 * Construye un SQL Query para Insertar una Ubicación en la Base de Datos
	 * @param idArea Unidad Administrativa
	 * @param ubicacion Ubicación 
	 * @param idActualizo Usuario que actualizá
	 * @param fechaUpdate Fecha de Actualización
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getInsertaUbicacion(	String idArea, String ubicacion,
            									String idActualizo,	String fechaUpdate)
    {
        String sql = 	"INSERT INTO SD_UBICACION (ID_UBICACION, UBI_AREA, UNI_DESCRIPCION, UBI_USR_ACTUALIZO," +
        				" UBI_FEC_ACTUALIZACION, UBI_ESTATUS) " +
        				//" VALUES (SD_UBICACION_SEQ.NEXTVAL,"+idArea+", '"+ubicacion+"', "+idActualizo+", '"+fechaUpdate+"', 1)";
        				" VALUES (SD_UBICACION_SEQ.NEXTVAL,"+idArea+", '"+ubicacion+"', "+idActualizo+", SYSDATE, 1)";

        return sql;
    }
    
    /**
     * Función que regresa el query para construir un Combo
     * @return strSql
     */
    public static String getUbicacionCombo(String strUbicacion)
	{
		String strSql="";		
		strSql=	"SELECT  ID_UBICACION, UNI_DESCRIPCION FROM SD_UBICACION WHERE UBI_AREA="+strUbicacion+" AND UBI_ESTATUS=1 ORDER BY UNI_DESCRIPCION";												
		return strSql;	
	}
    
    /**
     * Función que regresa un query con las ubicaciones de las areas
     * @return Query
     */
    public static String getUbicacionCombo()
    {
        String strSql="";		
		strSql=	"SELECT ID_UBICACION, UNI_DESCRIPCION FROM SD_UBICACION WHERE UBI_ESTATUS=1 ORDER BY 2";												
		return strSql;
    }
    
    /**
	 * Construye un SQL Query para Regresar una lista de las Ubicaciones 
	 * @param strOrden Campo por el cual se ordena la lista 
	 * @param tipo Ordenamiento ascendente o descendente
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getListaUbicacion(String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	"SELECT ID_UBICACION, UNI_DESCRIPCION, UBI_AREA, ARE_NOMBRE ";
		strSql+="FROM SD_UBICACION, SD_AREA WHERE UBI_ESTATUS=1 ";
		strSql+="AND SD_UBICACION.UBI_AREA=SD_AREA.ID_AREA ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}
		return strSql;	
	}
    
    /**
     * Construye un SQL Query para Validar si existen Ubicaciones
     * @return Regresa un String con el Query correspondiente
     */
    public static String getExiste()
    {
        String strSql="";		
		strSql=	"SELECT * FROM SD_UBICACION"; 
		return strSql;
    }
    
    /**
	 * Construye un SQL Query para Eliminar logicamente el tramite
	 * @param strIds ID's de los Tramites
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getDeleteUbicacion(String strIds)
	{
	    String strSql="";
		strSql=	" UPDATE SD_UBICACION SET"	+
				" UBI_ESTATUS=0 WHERE ID_UBICACION IN ("+strIds+")";				
		return strSql;
    	
	}
    
    /**
     * Construye un SQL Query para Regresar los campos de la Ubicación segun su ID
     * @param strIdUbicacion ID de Ubicacion
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDatosUbicacion(String strIdUbicacion)
    {
        String strSql="";		
		strSql=	"SELECT UBI_AREA, UNI_DESCRIPCION FROM SD_UBICACION WHERE ID_UBICACION="+strIdUbicacion; 
		return strSql;
    }
    
    /**
     * Construye un SQL Query para Actualizar una Ubicación en la Base de Datos
     * @param strIdArea Unidad Administrativa
     * @param strDescripcion Descripción
     * @param strUsrUpdate Usuario que actualizá
     * @param strFechaUpdate Fecha de Actualización 
     * @param strIdUbi ID de Ubicación
     * @return Regresa un String con el Query correspondiente
     */
    public static String getActualizarUbicacion(	String strIdArea,String strDescripcion,
            										String strUsrUpdate, String strFechaUpdate, String strIdUbi)
    {
        String strSql="";		
		strSql=	"UPDATE SD_UBICACION SET " +
				"UBI_AREA="+strIdArea+", UNI_DESCRIPCION='"+strDescripcion+"', " +
				//"UBI_USR_ACTUALIZO="+strUsrUpdate+", UBI_FEC_ACTUALIZACION='"+strFechaUpdate+"' " +
				"UBI_USR_ACTUALIZO="+strUsrUpdate+", UBI_FEC_ACTUALIZACION=TO_DATE('"+strFechaUpdate+"', 'DD/MM/YYYY') " +
				"WHERE ID_UBICACION="+strIdUbi; 
		return strSql;
    }
    
    /**
     * Construye un SQL Query para Regresar el Nombre de la Ubicación segun su ID 
     * @param strIdubicacion ID de la Ubicación
     * @return Regresa un String con el Query correspondiente
     */
    public static String getNombreUbicacion(String strIdubicacion)
    {
        String strSql="";		
		strSql=	"SELECT UNI_DESCRIPCION FROM SD_UBICACION WHERE ID_UBICACION="+strIdubicacion; 
		return strSql;
    }
    
    /**
     * Construye un SQL Query para Verificar si una Ubicación ya existe segun su Descripcion y Unidad Administrativa
     * @param strDescripcion Descripción
     * @param strAux Descripcion antes de ser editada de 
     * @param strArea Unidad Administrativa
     * @param strAux2 Unidad Administrativa antes de ser editada
     * @return Regresa un String con el Query correspondiente
     */
    public static String getUbicacionExiste(String strDescripcion, String strAux, String strArea, String strAux2)
    {   
		String strSql=	"SELECT UNI_DESCRIPCION FROM SD_UBICACION WHERE " +
		"NOT (LOWER(UNI_DESCRIPCION)	= LOWER('" + strAux + "') " +
		"AND  LOWER(UBI_AREA) 	= LOWER('" + strAux2 + "')) " +
		"AND  LOWER(UNI_DESCRIPCION)	= LOWER('" + strDescripcion + "') " +
		"AND  LOWER(UBI_AREA) 	= LOWER('" + strArea + "') " +
		"AND  UBI_ESTATUS = 1";
    
		return strSql;
    } 

}

