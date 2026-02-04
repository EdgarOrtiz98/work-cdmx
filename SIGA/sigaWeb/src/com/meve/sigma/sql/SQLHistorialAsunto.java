

/*
 * Created on Sep 14, 2005
 */
package com.meve.sigma.sql;

/**
 * @author 	Rodrigo Soto Ch.
 * 			rodrigo_s_ch@yahoo.com.mx, rodrigo.soto.ch@gmail.com
 * 			Meve Soluciones S.A. de C.V.
 *
 * @version	1.0
 */
public class SQLHistorialAsunto {
    
    /**
     * Inserta asunto
     * @param nombre Nombre del Asunto
     * @param descripcion descripcion del área
     * @param idResponsable responsable
     * @param fechaUpdate fecha
     * @param usUpdate Actualización
     * @param estatus estatus
     * @return Query
     */
    public static String getInsertaAsunto(String nombre, String descripcion, String idResponsable,
            							String fechaUpdate, String usUpdate, String estatus)
    {
        String sql = 	"INSERT INTO SD_AREA (ID_AREA, ARE_NOMBRE, ARE_DESCRIPCION, ARE_SUPERVISOR," +
        				" ARE_FEC_ACTUALIZACION, ARE_USR_ACTUALIZO, ARE_ESTATUS) " +
        				" VALUES (SD_AREA_SEQ.NEXTVAL,'"+nombre+"', '"+descripcion+"', "+idResponsable+", '"+fechaUpdate+"', " +
        				" "+usUpdate+", "+estatus+")";
        
        return sql;
    }
    
    /**
     * lista de áreas
     * @return lista de áreas
     */
    public static String getAsuntoCombo()
	{
		String strSql="";		
		strSql=	"SELECT ID_AREA, ARE_NOMBRE FROM SD_AREA WHERE ARE_ESTATUS=1 ORDER BY ARE_NOMBRE";												
		return strSql;	
	}
    
    /**
     * lista de asuntos por área
     * @param IdArea id área
     * @return Lista asuntos
     */
    public static String getAsuntoCombo(String IdArea)
	{
		String strSql="";		
		strSql=	"SELECT ID_AREA, ARE_NOMBRE FROM SD_AREA WHERE ARE_ESTATUS=1 " +
				"AND ID_AREA="+IdArea+" ORDER BY ARE_NOMBRE";												
		return strSql;	
	}

    /**
     * Datos del asunto
     * @return Datos del asunto
     */
    public static String getAsuntos()
	{
		String strSql="";		
		strSql=	" SELECT ARE_NOMBRE, ID_AREA, USU_NOMBRE " +
				"FROM SD_AREA LEFT OUTER JOIN SD_USUARIO " +
				"ON SD_AREA.ARE_SUPERVISOR=SD_USUARIO.ID_USUARIO " +
				"WHERE ARE_ESTATUS=1 " +
				"ORDER BY 1"; 
		return strSql;	
	}
    
    /**
     * Datos del área
     * @param idArea id área
     * @return Query
     */
    public static String getAsunto(String idArea)
	{
		String strSql="";		
		strSql=	" SELECT ARE_NOMBRE, ARE_DESCRIPCION, ARE_SUPERVISOR FROM SD_AREA WHERE ARE_ESTATUS=1 AND ID_AREA="+idArea; 
		return strSql;	
	}
    
    /**
     * elimina áreas
     * @param strIds Ids área
     * @return Query
     */
    public static String getDeleteAsunto(String strIds[])
	{
	    String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);				
		strSql=	" UPDATE SD_AREA SET ARE_ESTATUS=0 WHERE "	+
				"ID_AREA IN ("+ids + ")";
		return strSql;
	}
    
    /**
     * Busca el área de un asunto
     * @param strId id asunto
     * @return Query
     */
    public static String findAsuntos(String strId)
	{
		String strSql="";		
		strSql=	" SELECT ID_AREA FROM SD_AREA WHERE ARE_ESTATUS=1 AND ARE_NOMBRE='"+strId+"'"; 
		return strSql;	
	}
    
    /**
     * Actualiza el asuntos
     * @param strId Id asunto
     * @param strArea área
     * @param strDescripcion Descripción
     * @param strResponsable responsable
     * @param strCreador1 Creador
     * @param strFechaCreacion Fecha
     * @param strEstatus Estatus
     * @return Query
     */
    public static String getActualizaAsunto(	String strId, String strArea, String strDescripcion, 
            								String strResponsable, String strCreador1, 
            								String strFechaCreacion, String strEstatus)
    {
    	String sql =	"UPDATE SD_AREA SET ARE_NOMBRE='"+strArea+"', ARE_DESCRIPCION='"+strDescripcion
		+"', ARE_SUPERVISOR="+strResponsable+", ARE_USR_ACTUALIZO="+strCreador1+", ARE_FEC_ACTUALIZACION='"
		+strFechaCreacion+"', ARE_ESTATUS="+strEstatus+" WHERE "+"ID_AREA IN ("+ strId + ")";
   		return sql;
	}
    
    /**
     * Folio área
     * @param idArea Id área
     * @return Query
     */
    public static String getAsuntoFolio(String idArea)
    {
        String strSql = "";
        strSql	=	"SELECT ARE_NOMBRE FROM SD_AREA WHERE ID_AREA="+idArea;
        return strSql;
    }
    
    /**
     * Nombre asunto
     * @param idArea área
     * @return query
     */
    public static String NombreAsunto(String idArea)
	{
	    String strSql="";		
		strSql=	"SELECT ARE_NOMBRE FROM SD_AREA WHERE ID_AREA="+idArea+"";
		////System.out.println("NombreUsuario="+strSql);
		return strSql;
	}
    
    /**
     * Función que devuelve un query con la información del responsable del área
     * @param strIdArea String Contiene el ID del Area
     * @return strSql Query
     */
    public static String getIDAsunto(String strIdArea)
    {
        String strSql="";		
		strSql=	"SELECT ID_AREA, ARE_NOMBRE, USU_NOMBRE " +
				"FROM SD_AREA, SD_USUARIO " +
				"WHERE ID_AREA="+strIdArea+" " +
				"AND SD_USUARIO.ID_USUARIO=SD_AREA.ARE_SUPERVISOR ";
		return strSql;
    }
    
    /**
     * Función que devuelve un query que trae una lista de 
     * los usuarios que formen parte del área
     * @param idArea String Contiene el ID del área
     * @return strSql Query
     */
    public static String getMiembrosAsunto(String idArea)
    {
        String strSql="";		
		strSql=	"SELECT USU_NOMBRE FROM SD_USUARIO " +
				"WHERE USU_AREA="+idArea+" AND USU_ESTATUS=1";
		return strSql;
    }
    
    /**
     * Función que regresa el ID del área
     * @param idArea Contiene el ID del área
     * @return Query
     */
    public static String getIdAsunto(String idArea)
    {
        String sql = "";
        sql = "";
        return sql;
    }
    
    /**
     * devuelve el nombre y el Id del area para la busqueda del potal ciudadano
     * @return Query
     */
    public static String getAsuntosCiudadano(){
        String sql = "SELECT ID_AREA, ARE_NOMBRE FROM SD_AREA WHERE ARE_ESTATUS=1 AND ID_AREA <> 0 ORDER BY 2";
        return sql;
    }
 
}