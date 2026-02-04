/*
 * Created on Sep 14, 2005
 */
package com.meve.sigma.sql;

/**
 * SQLPrioridad es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_PRIORIDAD
 * @author Meve Soluciones SA de CV
 *
 */
public class SQLPrioridad {
    
    /**
     * Inserta los registros de un prioridad
     * @param strPrioridad	Nombre prioridad
     * @param strPrioridadArea	área a la que pertenece la prioridad
     * @param strPrioridadHexagesimal	Número hexagesimal
     * @param strCreador1	Usuario creador o que actualiza el registro
     * @param strFechaCreacion	fecha de Creación o Actualización
     * @param strEstatus	estatus de la prioridad
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getInsertaPrioridad(	String strPrioridad, String strPrioridadArea, String strPrioridadHexagesimal,
												String strCreador1, String strFechaCreacion, String strEstatus)
    {
        String sql = 	"INSERT INTO SD_PRIORIDAD (ID_PRIORIDADES, PRI_NOMBRE, PRI_AREA, PRI_NUMERO_HEX," +
        				" PRI_FEC_ACTUALIZACION, PRI_USR_ACTUALIZO, PRI_ESTATUS) " +
        				" VALUES (SD_PRIORIDAD_SEQ.NEXTVAL,'"+strPrioridad+"', "+strPrioridadArea+", " +
        				//"'"+strPrioridadHexagesimal+"', '"+strFechaCreacion+"', "+strCreador1+", "+strEstatus+")";
        				"'"+strPrioridadHexagesimal+"', SYSDATE, "+strCreador1+", "+strEstatus+")";
        
        return sql;
    }
    
    /**
     * 
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getPrioridadCombo()
    {
        String strSql="";		
		strSql=	"SELECT  ID_PRIORIDADES, PRI_NOMBRE FROM SD_PRIORIDAD ORDER BY PRI_NOMBRE";												
		return strSql;	
    }
    
    /**
     * 
     * @param strIdArea
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getPrioridadCombo(String strIdArea)
    {
        String strSql="";		
		strSql=	"SELECT  ID_PRIORIDADES, PRI_NOMBRE FROM SD_PRIORIDAD WHERE PRI_AREA="+strIdArea+" AND PRI_ESTATUS=1 AND ID_PRIORIDADES <> 0 ORDER BY PRI_NOMBRE";												
		return strSql;	
    }
    
    /**
     * 
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getPrioridadComboGral()
    {
        String strSql="";		
		strSql=	"SELECT  ID_PRIORIDADES, PRI_NOMBRE FROM SD_PRIORIDAD " +
				"WHERE PRI_AREA=0 AND PRI_ESTATUS=1 AND ID_PRIORIDADES <> 0 ORDER BY PRI_NOMBRE";												
		return strSql;	
    }
    
    /**
     * Lista de las prioridades para la vista del catalogo 
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getPrioridades(String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT PRI_NOMBRE, ID_PRIORIDADES, PRI_NUMERO_HEX, PRI_AREA, ARE_NOMBRE ";
		strSql+="FROM SD_PRIORIDAD, SD_AREA WHERE PRI_ESTATUS=1 ";
		strSql+="AND SD_PRIORIDAD.PRI_AREA=SD_AREA.ID_AREA ";
		strSql+="AND ID_PRIORIDADES <> 0 ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 1 "+strOrden+", 1 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 5 "+strOrden+", 1 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 3 "+strOrden+", 1 ASC ";
		}
		return strSql;	
	}
    
    /**
     * 
     * @param idPrioridad
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getPrioridad(String idPrioridad)
	{
		String strSql="";		
		strSql=	" SELECT PRI_NOMBRE, PRI_AREA, PRI_NUMERO_HEX, PRI_USR_ACTUALIZO, TO_CHAR(PRI_FEC_ACTUALIZACION, 'dd/MM/yyyy HH:MI:SS AM') " +
				"FROM SD_PRIORIDAD WHERE PRI_ESTATUS=1 AND ID_PRIORIDADES="+idPrioridad; 
		return strSql;	
	}
    
    /**
     * Elimina registros de prioridades del catalogo
     * @param strIds	Id de prioridades a eliminar
     * @return	Regresa un String con el Query correspondiente
     */
	public static String getDeletePrioridad(String strIds)
	{
	    String strSql="";
		strSql=	" UPDATE SD_PRIORIDAD SET PRI_ESTATUS=0, PRI_FEC_ACTUALIZACION=SYSDATE WHERE "	+
				"ID_PRIORIDADES IN ("+strIds+")";
		return strSql;
	}

	/**
	 * Busca si existe el id de la prioridad
	 * @param strId	id prioridd
	 * @param strIdArea	Id área
	 * @return	Regresa un String con el Query correspondiente
	 */
	public static String findPrioridades(String strId, String strIdArea)
	{
		String strSql="";		
		strSql=	" SELECT ID_PRIORIDADES FROM SD_PRIORIDAD WHERE PRI_ESTATUS=1 AND PRI_NOMBRE='"+strId+"' AND PRI_AREA="+strIdArea; 
		return strSql;	
	}
    
	/**
	 * Actualiza los registros de un prioridad
     * @param strId	Id Prioridad
	 * @param strPrioridad	Nombre prioridad
     * @param strPrioridadArea	área a la que pertenece la prioridad
     * @param strPrioridadHexagesimal	Número hexagesimal
     * @param strCreador1	Usuario creador o que actualiza el registro
     * @param strFechaCreacion	fecha de Creación o Actualización
     * @param strEstatus	estatus de la prioridad
	 * @return	Regresa un String con el Query correspondiente
	 */
    public static String getActualizaPrioridad(	String strId, String strPrioridad, String strPrioridadArea, String strPrioridadHexagesimal,
			String strCreador1, String strFechaCreacion, String strEstatus)
    {
    	String sql =	"UPDATE SD_PRIORIDAD SET PRI_NOMBRE='"+strPrioridad+"', PRI_AREA="+strPrioridadArea
		+", PRI_NUMERO_HEX='"+strPrioridadHexagesimal+"', PRI_USR_ACTUALIZO="+strCreador1+", " +
		//"PRI_FEC_ACTUALIZACION='"+strFechaCreacion+"', " +
		//"PRI_FEC_ACTUALIZACION=TO_DATE('"+strFechaCreacion+"', 'DD/MM/YYYY'), " +
		"PRI_FEC_ACTUALIZACION=SYSDATE, " +
		"PRI_ESTATUS="+strEstatus+" WHERE "+"ID_PRIORIDADES IN ("+ strId + ")";
    	return sql;
    }
    
    /**
     * Función que regresa un query con el nombre de la prioridad
     * @param idPrioridad Contiene el ID de la Prioridad
     * @return Query
     */
    public static String getNombrePrioridad(String idPrioridad)
    {
        String sql = "";
        sql = "SELECT PRI_NOMBRE FROM SD_PRIORIDAD WHERE ID_PRIORIDADES="+idPrioridad;
        return sql ;
    }
    
    /**
     * Verifica si existe el registro de la prioridad en los catalogos
     * @param strPrioridad	Nombre de la prioridad
     * @param strAux		Auxiliar
     * @param strArea		área
     * @param strAux2		Auxiliar2
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getPrioridadExiste(String strPrioridad, String strAux, String strArea, String strAux2)
	{
		String strSql=	"SELECT PRI_NOMBRE FROM SD_PRIORIDAD WHERE " +
				"NOT (LOWER(PRI_NOMBRE) = LOWER('" + strAux + "') " +
				"AND  LOWER(PRI_AREA) 	= LOWER('" + strAux2 + "')) " +
				"AND  LOWER(PRI_NOMBRE) = LOWER('" + strPrioridad + "') " +
				"AND  LOWER(PRI_AREA) 	= LOWER('" + strArea + "') " +
				"AND  PRI_ESTATUS = 1";
				
		return strSql;
	}
    
    /**
     * Estatus de la prioridad
     * @param strIdPrioridad	Id prioridad
     * @return	Regresa un String con el Query correspondiente
     */	
    public static String getEstatusPrioridad(String strIdPrioridad)
    {
        String sql = "";
        sql = "SELECT PRI_ESTATUS FROM SD_PRIORIDAD WHERE ID_PRIORIDADES="+strIdPrioridad;
        return sql;
    }
    
    /**
     * Número de prioridades por asunto
     * @param strIdPrioridad	Id Prioridad
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getCountAsuntos(String strIdPrioridad){
    	String sql = "SELECT COUNT(ASU_PRIORIDAD) FROM SD_ASUNTO WHERE ASU_PRIORIDAD="+strIdPrioridad+" AND (ASU_ESTATUS<>3 AND ASU_ESTATUS<>4)";
    	return sql;
    }

}