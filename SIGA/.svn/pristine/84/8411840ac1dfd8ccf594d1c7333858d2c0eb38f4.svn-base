package com.meve.sigma.sql;

/**
 * SQLEntidad es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_ENTIDAD
 * @author Meve Soluciones SA de CV
 *
 */
public class SQLEntidad {
    
    /**
     * Inserta una entidad
     * @param strEntidad	Nombre entidad
	 * @param strEntidadArea	área de la entidad
	 * @param strEntidadClasificacion	Clasificación de la entidad
	 * @param strEntidadDireccion		Dirección
	 * @param strEntidadTel				Teléfono
	 * @param strCreador1				usuario que créa o atualiza el registro
	 * @param strFechaCreacion			fecha de Creación
	 * @param strEstatus				Estatus
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getInsertaEntidad(	String strEntidad, String strEntidadArea, String strEntidadClasificacion,
    		String strEntidadDireccion, String strEntidadTel, String strCreador1, String strFechaCreacion, String strEstatus)
    {
        String sql = 	"INSERT INTO SD_ENTIDAD (ID_ENTIDAD, ENT_NOMBRE, ENT_AREA, " +
        				"ENT_CLASIFICACION, ENT_DIRECCION, ENT_TELEFONO, " +
        				"ENT_FEC_ACTUALIZACION, ENT_USR_ACTUALIZO, ENT_ESTATUS) " +
        				" VALUES (SD_ENTIDAD_SEQ.NEXTVAL,'"+strEntidad+"', "+strEntidadArea+", " +
        				"'"+strEntidadClasificacion+"', '"+
        				strEntidadDireccion+"', '"+ strEntidadTel+"', " +
        				//"'"+strFechaCreacion+"', "+strCreador1+", "+strEstatus+")";
        				"SYSDATE, "+strCreador1+", "+strEstatus+")";
        
        return sql;
    }
    
    /**
     * 
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getEntidadCombo()
	{
		String strSql="";		
		strSql=	"SELECT ID_ENTIDAD, ENT_NOMBRE FROM SD_ENTIDAD " +
				"WHERE ENT_ESTATUS=1 AND ID_ENTIDAD <> 0 ORDER BY ENT_NOMBRE";												
		return strSql;	
	}
    
    /**
     * 
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getEntidadCombo1()
	{
		String strSql="";		
		strSql=	"SELECT ID_ENTIDAD, ENT_NOMBRE " +
				"FROM SD_ENTIDAD WHERE ENT_ESTATUS=1 " +
				"AND ID_ENTIDAD <> 0 ORDER BY ENT_NOMBRE";												
		return strSql;	
	}
    
    /**
     * Lista de entidades por un área para generar un combo
     * @param strIdArea	id área
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getEntidadCombo(String strIdArea)
	{
		String strSql="";		
		strSql=	"SELECT ID_ENTIDAD, ENT_NOMBRE FROM SD_ENTIDAD " +
				"WHERE ENT_AREA="+strIdArea+" AND ENT_ESTATUS=1 ORDER BY ENT_NOMBRE";												
		return strSql;	
	}
    
    /**
     * Lista de entidades generales para generar un combo
     * @param strIdArea	id área
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getEntidadGralExt(String strIdArea)
    {
        String strSql="";		
		strSql+="SELECT ID_ENTIDAD, ENT_NOMBRE ";
		strSql+=	"FROM SD_ENTIDAD WHERE (ENT_AREA="+strIdArea+" OR ENT_AREA=1) ";
		strSql+=	"AND ENT_ESTATUS=1 ";
		strSql+=	"ORDER BY 2";												
		return strSql;
    }
    
    /**
     * 
     * @param strOrden
     * @param tipo
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getEntidades(String strOrden, String tipo)
	{
		String strSql="";		
		strSql+=" SELECT ENT_NOMBRE, ID_ENTIDAD, ENT_AREA, ARE_NOMBRE ";
		strSql+="FROM SD_ENTIDAD, SD_AREA WHERE ENT_ESTATUS=1 ";
		strSql+="AND SD_ENTIDAD.ENT_AREA=SD_AREA.ID_AREA ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 1 "+strOrden+", 1 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 1 ASC ";
		}
		return strSql;	
	}
    
    /**
     * 
     * @param idEntidad
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getEntidad(String idEntidad)
	{
		String strSql="";		
		strSql=	" SELECT ENT_NOMBRE, ENT_AREA, ENT_CLASIFICACION, " +
				"ENT_DIRECCION, ENT_TELEFONO, ENT_USR_ACTUALIZO, TO_CHAR(ENT_FEC_ACTUALIZACION, 'DD/MM/YYYY HH:MI:SS AM') FROM SD_ENTIDAD " +
				"WHERE ENT_ESTATUS=1 AND ID_ENTIDAD="+idEntidad; 
		return strSql;	
	}
    
    /**
     * Eliminó registro de una entidad
     * @param strIds	id entidad
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getDeleteEntidad(String strIds)
	{
	    String strSql="";
		strSql=	" UPDATE SD_ENTIDAD SET ENT_ESTATUS=0, ENT_FEC_ACTUALIZACION=SYSDATE WHERE "	+
				"ID_ENTIDAD IN ("+strIds+")";
		return strSql;
	}
    
    /**
     * 
     * @param strId ID 
     * @param strIdArea id área
     * @return	Regresa un String con el Query correspondiente
     */
    public static String findEntidades(String strId, String strIdArea)
	{
		String strSql="";		
		strSql=	" SELECT ID_ENTIDAD FROM SD_ENTIDAD " +
				"WHERE ENT_ESTATUS=1 AND ENT_NOMBRE='"+strId+"' AND ENT_AREA="+strIdArea; 
		return strSql;	
	}
    
    /**
     * Query que actualizá el registro de una entidad
     * @param strId			id entidad
     * @param strEntidad	Nombre entidad
	 * @param strEntidadArea	área de la entidad
	 * @param strEntidadClasificacion	Clasificación de la entidad
	 * @param strEntidadDireccion		Dirección
	 * @param strEntidadTel				Teléfono
	 * @param strCreador1				usuario que créa o atualiza el registro
	 * @param strFechaCreacion			fecha de Creación
	 * @param strEstatus				Estatus
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getActualizaEntidad(	String strId, String strEntidad, String strEntidadArea, 
            									String strEntidadClasificacion, String strEntidadDireccion, 
            									String strEntidadTel, String strCreador1, 
            									String strFechaCreacion, String strEstatus)
    {
    	String sql =	"UPDATE SD_ENTIDAD SET ENT_NOMBRE='"+strEntidad+"', ENT_AREA="+strEntidadArea
    					+", ENT_CLASIFICACION='"+strEntidadClasificacion+"', ENT_DIRECCION='"+strEntidadDireccion
    					+"', ENT_TELEFONO='"+strEntidadTel+"', ENT_USR_ACTUALIZO="+strCreador1+", " +
    					"ENT_FEC_ACTUALIZACION=SYSDATE, " +
    					"ENT_ESTATUS="+strEstatus+" " +
    					"WHERE "+"ID_ENTIDAD IN ("+ strId + ")";

    	return sql;
    }
    
    /**
     * Verifica si existe la entidad
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getExisteEntidad()
    {
        String sql = "";
        sql = "SELECT * FROM SD_ENTIDAD WHERE ENT_ESTATUS=1";
        return sql;
    }
    
    /**
     * @param ID	id entidad
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getNombreEntidad(String ID)
    {
        String sql = "";
        sql = "SELECT ENT_NOMBRE FROM SD_entidad WHERE ID_ENTIDAD="+ID;
        return sql;
    }
    
    /**
     * Función que regresa un query con la entidades generales
     * @return Regresa un String con el Query correspondiente
     */
    public static String getEntidadesGenerales()
    {
        String sql = "";
        sql = 	"SELECT ID_ENTIDAD, ENT_NOMBRE " +
        		"FROM SD_ENTIDAD WHERE ENT_AREA=0 " +
        		//"AND ID_ENTIDAD <> 0 " +
        		"AND ENT_ESTATUS=1 " +
        		"ORDER BY 2";
        return sql;
    }
    
    /**
     * Función que regresa un query con las entidades internas, osea
     * las áreas
     * @return Regresa un String con el Query correspondiente
     */
    public static String getEntidadesInternas()
    {
        String sql = "";
        sql = "SELECT ID_AREA, ARE_NOMBRE " +
        		"FROM SD_AREA WHERE ID_AREA <> 0 " +
        		"AND ARE_ESTATUS=1 " +
        		"ORDER BY 2";
        return sql;
    }
    
    /**
     * Función que regresa un query, donde se inserta una entidad que ha sido registrada
     * al capturar un nuevo asunto
     * @param strIdArea Contiene el Id del Area
     * @param strEntidad Nombre de la entidad
     * @param strCreador Id del usuario que crea el asunto
     * @param strFechaCreacion Fecha en la que se creo el registro de la entidad
     * @return Regresa un String con el Query correspondiente
     */
    public static String insertarEntidadDesdeAsunto(String strIdArea, String strEntidad, 
													String strCreador, String strFechaCreacion)
    {
        String sql = "";
        sql = "INSERT INTO SD_ENTIDAD (ID_ENTIDAD,ENT_NOMBRE, ENT_AREA, ENT_FEC_ACTUALIZACION, ENT_USR_ACTUALIZO, ENT_ESTATUS) " +
        		"VALUES (SD_ENTIDAD_SEQ.NEXTVAL,'"+strEntidad+"', "+strIdArea+", '"+strFechaCreacion+"', "+strCreador+", 1)";
        return sql;
    }
    
    /**
     * Función que regresa un query con el ultimo ID de los
     * registros de entidades en el catalog 
     * @return Regresa un String con el Query correspondiente
     */
    public static String ultimoIdEntidad()
    {
        String sql = "SELECT MAX(ID_ENTIDAD) FROM SD_ENTIDAD";
        return sql;
    }
    
    /**
     * Verifica si existe la entidad
     * @param strEntidad	Id Entidad
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getEntidadExiste(String strEntidad){
    	String sql = "SELECT ENT_NOMBRE FROM SD_ENTIDAD WHERE LOWER(ENT_NOMBRE) = LOWER('"+strEntidad+"')";
    	return sql;
    }
    
    /**
     * Verifica si la entidad no existe en los catalogos
     * @param strEntidad	Nombre entidad
     * @param strAux		Auxiliar
     * @param strIdArea		área
     * @param strAux2		Auxiliar 2
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getEntidadExiste(String strEntidad, String strAux, String strIdArea, String strAux2){
    	String sql = "SELECT ENT_NOMBRE FROM SD_ENTIDAD " +
    			"WHERE NOT (LOWER(ENT_NOMBRE) = LOWER('"+strAux+"') AND LOWER(ENT_AREA) = LOWER('"+strAux2+"')) " +
    			"AND LOWER(ENT_NOMBRE) = LOWER('"+strEntidad+"') AND LOWER(ENT_AREA) = LOWER('"+strIdArea+"') " +
    			"AND ENT_ESTATUS = 1";
    	return sql;
    }
    
    /**
     * 
     * @param strIdArea
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getCountRemitente(String strIdArea){
    	String sql = "SELECT COUNT(RMT_ENTIDAD) FROM SD_REMITENTE WHERE RMT_ENTIDAD="+strIdArea+" AND RMT_ESTATUS=1";
    	return sql;
    }
    
    /**
     * 
     * @param strIdArea
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getCountAsuntos(String strIdArea){
    	String sql = "SELECT COUNT(ASU_ENTIDAD) FROM SD_ASUNTO WHERE ASU_ENTIDAD="+strIdArea+" AND (ASU_ESTATUS<>3 AND ASU_ESTATUS<>4) AND ASU_CONTROL=0";
    	return sql;
    }
    
    /**
     * 
     * @param idArea
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getEntidadComboXArea(String idArea)
	{
		String strSql="";		
		strSql=	"SELECT ID_ENTIDAD, ENT_NOMBRE FROM SD_ENTIDAD " +
				"WHERE ENT_ESTATUS=1 AND ID_ENTIDAD <> 0 AND ENT_AREA = "+idArea+" ORDER BY ENT_NOMBRE";												
		return strSql;	
	}
    
    /**
     * Busqueda de entidades
     * @param strIdArea	Id áreas
     * @param buscar	criterio de busqueda
     * @param strOrden	Orden
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getEntidadGralExt(String strIdArea, String buscar,
    										String strOrden)
    {
        String strSql="";		
		strSql+="SELECT ID_ENTIDAD, ENT_NOMBRE ";
		strSql+="FROM SD_ENTIDAD WHERE (ENT_AREA="+strIdArea+" OR ENT_AREA=0) ";
		strSql+="AND ENT_ESTATUS=1 AND LOWER(ENT_NOMBRE) LIKE LOWER('%"+buscar+"%') ";
		strSql+="ORDER BY 2 "+strOrden+" ";												
		return strSql;
    }
    
    /**
     * Busqueda entidades 	internas(área)
     * @param buscar		Criterio de busqueda
     * @param strOrden		orden de la columna
     * @param strTipo		Tipo de orden(asc o desc)
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getEntidadesInternas(String buscar, String strOrden, String strTipo)
    {
        String sql = "";
        
        sql += "SELECT ID_AREA, ARE_NOMBRE, ";
        sql += "CASE ARE_BANDERA WHEN 1 THEN 'No' WHEN 0 THEN 'Si' END AS BANDERA ";
        sql += "FROM SD_AREA WHERE ID_AREA <> 0 AND ARE_ESTATUS=1 ";
        sql += "AND LOWER(ARE_NOMBRE) LIKE LOWER('%"+buscar+"%') ";
        if(strTipo.equals("1")){
        	sql += "ORDER BY LOWER(ARE_NOMBRE) "+strOrden+" ";
        }else if(strTipo.equals("2")){
        	sql += "ORDER BY 3 "+strOrden+"";
        }
        return sql;
    }
    
    /**
     * Estatus de la entidad
     * @param strIdEntidad	Id entidad
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getEstatusEntidad(String strIdEntidad)
    {
        String sql = "";
        sql = "SELECT ENT_ESTATUS FROM SD_ENTIDAD WHERE ID_ENTIDAD="+strIdEntidad;
        return sql;
    }
    
    /**
     * Buscar entidades externas
     * @param buscar	Criterio de Búsqueda
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getEntidadesExternas(String buscar)
    {
        String sql = "";
        sql = "SELECT ID_AREA, ARE_NOMBRE " +
        		"FROM SD_AREA WHERE ID_AREA <> 0 " +
        		"AND ARE_ESTATUS=1 AND ARE_BANDERA=1 " +
        		"AND LOWER(ARE_NOMBRE) LIKE LOWER('%"+buscar+"%') " +
        		"ORDER BY 2";
        return sql;
    }
    


}
