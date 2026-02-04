
package com.meve.sigma.sql;


/**
 * Clase para generar codigo SQL para Tramite
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class SQLTramite {

	public SQLTramite() {
		super();
	}
	
	/**
	 * Construye un SQL Query para Insertar un Tramite en la Base de Datos
	 * @param strNombre Nombre
	 * @param strClave Clave 
	 * @param strDes Descripción
	 * @param strTiempo Tiempo
	 * @param strIdUsuario Usuario que actualiza
	 * @param strIdArea Unidad Administrativa
	 * @return Regresa un String con el Query correspondiente
	 */ 
	public static String insertaTramite(String strNombre, String strClave, String strDes,
								String strTiempo, String strIdUsuario, String strIdArea){
		String sql = "INSERT INTO SD_TRAMITE (ID_TRAMITE, TRA_NOMBRE, TRA_CLAVE, " +
					"TRA_DESCRIPCION, TRA_TIEMPO, TRA_FECHA_CREACION, TRA_FECHA_ACTUALIZACION, " +
					"TRA_USR_ACTUALIZO, TRA_AREA)VALUES(SD_TRAMITE_SEQ.NEXTVAL, '"+strNombre+"', '"+strClave+"', " +
					"'"+strDes+"', "+strTiempo+", SYSDATE, SYSDATE, "+strIdUsuario+", "+strIdArea+")";
		return sql;
	}
	
	/**
	 * Construye un SQL Query para Regresar una lista de los tramites ordenados
	 * @param strOrden Campo por el cual se ordena la lista 
	 * @param tipo Ordenamiento ascendente o descendente
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getVistaTramite(String strOrden, String tipo){
		String sql = "SELECT ID_TRAMITE, TRA_NOMBRE, TRA_CLAVE, TRA_TIEMPO, ARE_NOMBRE, TRA_AREA ";
		sql+="FROM SD_TRAMITE, SD_AREA WHERE TRA_ESTATUS=1 AND ";
		sql+="SD_TRAMITE.TRA_AREA=SD_AREA.ID_AREA ";
		if(tipo.equals("1")){
			sql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			sql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			sql+="ORDER BY 5 "+strOrden+", 2 ASC ";
		}	
		return sql;
	}
	
	/**
	 * Construye un SQL Query para Actualizar un Tramite en la Base de Datos
	 * @param strIdTramite ID del Tramite
	 * @param strIdArea Unidad Administrativa
	 * @param strNombre Nombre 
	 * @param strClave Clave
	 * @param strDescripcion Descripción
	 * @param strTiempo Tiempo
	 * @param strFecha Fecha de Actualización
	 * @param strIdUsuario Usuario que actualiza
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String actualizaTramite(String strIdTramite, String strIdArea, String strNombre, 
				String strClave, String strDescripcion, String strTiempo, 
				String strFecha, String strIdUsuario){
		String sql = "UPDATE SD_TRAMITE SET TRA_AREA="+strIdArea+", " +
				"TRA_NOMBRE='"+strNombre+"', TRA_CLAVE='"+strClave+"', " +
				"TRA_DESCRIPCION='"+strDescripcion+"', TRA_TIEMPO="+strTiempo+", " +
				//"TRA_FECHA_ACTUALIZACION=TO_DATE('"+strFecha+"', 'DD/MM/YYYY'), " +
				"TRA_FECHA_ACTUALIZACION=SYSDATE, " +
				"TRA_USR_ACTUALIZO="+strIdUsuario+" " +
				"WHERE ID_TRAMITE="+strIdTramite;
		return sql;
	}
	
	/**
	 * Construye un SQL Query para Regresar el Tramite por su ID
	 * @param strIdTramite ID del Tramite
	 * @return  Regresa un String con el Query correspondiente
	 */
	public static String getTramite(String strIdTramite){
		String sql = "SELECT ID_TRAMITE, TRA_AREA, TRA_NOMBRE, TRA_CLAVE, " +
				"TRA_DESCRIPCION, TRA_TIEMPO, TO_CHAR(TRA_FECHA_ACTUALIZACION, 'DD/MM/YYYY HH:MI:SS AM') , TRA_USR_ACTUALIZO " +
				"FROM SD_TRAMITE WHERE ID_TRAMITE="+strIdTramite;
		return sql;
	}
	
	/**
	 * Construye un SQL Query para Eliminar logicamente el tramite
	 * @param strIds ID's de los Tramites
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String deleteTramite(String strIds){
		String strSql="";  
		strSql=	" UPDATE SD_TRAMITE SET"	+
		" TRA_ESTATUS=0, TRA_FECHA_ACTUALIZACION=SYSDATE WHERE ID_TRAMITE IN ("+strIds+")";				
		return strSql;
	}
	
	/**
	 * Construye un SQL Query para Validar se existen Tramites en una Unidad Administrativa
	 * @param strIdArea Unidad Administrativa
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getExisteTramite(String strIdArea)
    {
        String strSql = "";
        strSql = "SELECT * FROM SD_TRAMITE WHERE TRA_AREA="+strIdArea+"";
        return strSql;
    }
	
	/**
	 * Construye un SQL Query para Regresar una lista de Tramites segun su UA
	 * @param strIdArea Unidad Administrativa
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getComboTramite(String strIdArea){
		String sql = "SELECT ID_TRAMITE, TRA_NOMBRE, TRA_TIEMPO FROM SD_TRAMITE WHERE TRA_AREA="+strIdArea+" AND TRA_ESTATUS=1";
		return sql;
	}
	
	/**
	 * Construye un SQL Query para Regresar una lista con todos los Tramites
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getComboTramiteGral(){
        String sql = "SELECT ID_TRAMITE, TRA_NOMBRE, TRA_TIEMPO FROM SD_TRAMITE WHERE TRA_AREA=0" +
        		" AND TRA_ESTATUS=1 ORDER BY 2";
        return sql;
    }
	
	/**
	 * Construye un SQL Query para Regresar el nombre del tramite segun su ID
	 * @param strIdTramite ID del Tramite
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getNombreTramite(String strIdTramite){
		String sql = "SELECT TRA_NOMBRE FROM SD_TRAMITE WHERE ID_TRAMITE="+strIdTramite+"";
		return sql;
	}
	
	/**
	 * Construye un SQL Query para Varificar si un tramite ya existe por su Clave y UA 
	 * @param strEntidad Entidad 
	 * @param strAux Clave antes de ser editada
	 * @param strIdArea Unidad Administrativa
	 * @param strAux2 Unidad Administrativa antes de ser editada
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getTramiteExiste(String strEntidad, String strAux, String strIdArea, String strAux2){
    	String sql = "SELECT TRA_CLAVE FROM SD_TRAMITE " +
    			"WHERE NOT (LOWER(TRA_CLAVE) = LOWER('"+strAux+"') AND LOWER(TRA_AREA) = LOWER('"+strAux2+"')) " +
    			"AND LOWER(TRA_CLAVE) = LOWER('"+strEntidad+"') AND LOWER(TRA_AREA) = LOWER('"+strIdArea+"') " +
    			"AND TRA_ESTATUS = 1";
    	return sql;
    }
    
    /**
     * Construye un SQL Query para Regresar el Estatus del tramite por su ID
     * @param strIdTramite ID del tramite
     * @return Regresa un String con el Query correspondiente
     */
    public static String getEstatusTramite(String strIdTramite)
    {
        String sql = "";
        sql = "SELECT TRA_ESTATUS FROM SD_TRAMITE WHERE ID_TRAMITE="+strIdTramite;
        return sql;
    }
    
    /**
     * Construye un SQL Query para regresar todos los Asuntos asociados a un Tramite
     * @param strIdTramite ID de Tramite
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountAsuntos(String strIdTramite){
    	String sql = "SELECT COUNT(ASU_TRAMITE) FROM SD_ASUNTO WHERE ASU_TRAMITE="+strIdTramite+" AND (ASU_ESTATUS<>3 AND ASU_ESTATUS<>4)";
    	return sql;
    }
    


}
