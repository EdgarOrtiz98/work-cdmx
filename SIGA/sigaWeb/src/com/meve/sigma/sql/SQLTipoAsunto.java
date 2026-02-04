/*
 * Clase:						SQLTipoAsunto.java
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
 * Clase para generar codigo SQL para Tipo de Asuntos
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class SQLTipoAsunto {
    
	/**
     * Construye un SQL Query para Regresar una lista ordenada por Nombre de los Tipos de Asunto 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getTipoAsuntoCombo()
	{
		String strSql="";		
		strSql=	"SELECT ID_TIPO_ASUNTO, TIP_ASU_NOMBRE" +
				" FROM SD_TIPO_ASUNTO" +
				" ORDER BY TIP_ASU_NOMBRE";												
		return strSql;	
	}
    
    /**
     * Construye un SQL Query para Regresar una lista ordenada por Nombre de los Tipos de Asunto por Unidad Administrativa
     * @return Regresa un String con el Query correspondiente
     */
    public static String getTipoAsuntoCombo(String strIdArea)
	{
		String strSql="";		
		strSql=	"SELECT ID_TIPO_ASUNTO, TIP_ASU_NOMBRE" +
				" FROM SD_TIPO_ASUNTO" +
				" WHERE TIP_ASU_AREA="+strIdArea+" AND TIP_ASU_ESTATUS=1 AND ID_TIPO_ASUNTO <> 0 ORDER BY TIP_ASU_NOMBRE";												
		return strSql;	
	}
    
    /**
     * Construye un SQL Query para Regresar una lista ordenada por Nombre de los Tipos de Asunto 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getTipoAsuntoComboGral()
	{
		String strSql="";		
		strSql=	"SELECT ID_TIPO_ASUNTO, TIP_ASU_NOMBRE" +
				" FROM SD_TIPO_ASUNTO" +
				" WHERE TIP_ASU_AREA=0 AND TIP_ASU_ESTATUS=1 AND ID_TIPO_ASUNTO <> 0 ORDER BY TIP_ASU_NOMBRE";												
		return strSql;	
	}

    /**
	 * Construye un SQL Query para Regresar los campos de Tipo de Asunto por ID
	 * @param DN ID del Tipo de Asunto
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getTipoAsunto(String DN)
	{
		String strSql="";		
		strSql=	"SELECT TIP_ASU_AREA, TIP_ASU_NOMBRE, TIP_ASU_USR_ACTUALIZO," +
				" to_char(TIP_ASU_FEC_ACTUALIZACION, 'dd/MM/yyyy HH:MI:SS AM'), TIP_ASU_ESTATUS" +
				" FROM SD_TIPO_ASUNTO" +
				" WHERE ID_TIPO_ASUNTO=" + DN;
		return strSql;
	}
    
    /**
     * Construye un SQL Query para Regresar una lista de Tipo de Asuntos ordenada
     * @param strOrden Campo por el que se hace el ordenamiento 
     * @param tipo Ordenamiento ascendente o descendente
     * @return Regresa un String con el Query correspondiente
     */
    public static String getTipoAsuntos(String strOrden, String tipo)
	{
		String strSql="";
		strSql=	"SELECT ID_TIPO_ASUNTO, TIP_ASU_NOMBRE, ARE_NOMBRE,";
		strSql+=" TIP_ASU_FEC_ACTUALIZACION, TIP_ASU_USR_ACTUALIZO, TIP_ASU_ESTATUS, TIP_ASU_AREA";
		strSql+=" FROM SD_TIPO_ASUNTO , SD_AREA";
		strSql+=" WHERE TIP_ASU_ESTATUS=1 AND";
		strSql+=" SD_TIPO_ASUNTO.TIP_ASU_AREA= SD_AREA.ID_AREA ";
		strSql+=" AND ID_TIPO_ASUNTO <> 0 ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}												
		return strSql;	
	}

    /**
	 * Construye un SQL Query para Insertar un Tipo de Asunto en la BD
	 * @param area Unidad Administrativa
	 * @param nombre Nombre
	 * @param actualizo Usuario que actualizá
	 * @param fecha Fecha de Actualización
	 * @param estatus Estatus 
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getInsertaTipoAsunto(String area, String nombre, 
			String actualizo, String fecha, String estatus)
    {
        String sql = "";
        sql = 	"INSERT INTO SD_TIPO_ASUNTO" +
        		" (ID_TIPO_ASUNTO, TIP_ASU_AREA, TIP_ASU_NOMBRE," +
				" TIP_ASU_USR_ACTUALIZO, TIP_ASU_FEC_ACTUALIZACION, TIP_ASU_ESTATUS)" +
        		" VALUES (SD_TIPO_ASUNTO_SEQ.NEXTVAL, "+area+", '"+nombre+"', "+
        		//" "+actualizo+", '"+fecha+"', "+estatus+")";
        		" "+actualizo+", SYSDATE, "+estatus+")";
				return sql;
    }
    
    /**
	 * Construye un SQL Query para Actualizar un Tipo de Asunto en la BD
	 * @param idTipoAsunto ID del Tipo de Asunto
	 * @param idArea Unidad Administrativa
	 * @param nombre Nombre
	 * @param actualizo Usuario que actualizá
	 * @param fecha Fecha de Actualización
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getActualizarTipoAsunto(String idTipoAsunto, String idArea, String nombre, 
			String actualizo, String fecha)
    {
    	String strSql="";
    	strSql=	"UPDATE SD_TIPO_ASUNTO SET" +
		" TIP_ASU_AREA="+idArea+", TIP_ASU_NOMBRE='"+nombre+ "', " +
		//" TIP_ASU_USR_ACTUALIZO="+actualizo+", TIP_ASU_FEC_ACTUALIZACION='"+fecha+"'" +
		" TIP_ASU_USR_ACTUALIZO="+actualizo+", " +
		//"TIP_ASU_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY')" +
		"TIP_ASU_FEC_ACTUALIZACION=SYSDATE " +
		" WHERE ID_TIPO_ASUNTO="+idTipoAsunto;
    	return strSql;
    }

    /**
	 * Construye un SQL Query para Eliminar logicamente los registros de Tipo de Asunto
	 * @param strIds ID's de los Tipos de Asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getDeleteTipoAsunto(String strIds)
	{
		String strSql="";  
		strSql=	" UPDATE SD_TIPO_ASUNTO SET"	+
		" TIP_ASU_ESTATUS=0, TIP_ASU_FEC_ACTUALIZACION=SYSDATE WHERE ID_TIPO_ASUNTO IN ("+strIds+")";				
		return strSql;    	
	}
	
	/**
	 * Construye un SQL Query para mostrar el nombre del
	 * tipo de asunto
	 * @param idTipoAsunto Contiene el Id de Tipo de Asunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getNombreTipoAsunto(String idTipoAsunto)
    {
        String sql = "";
        sql = "SELECT TIP_ASU_NOMBRE FROM SD_TIPO_ASUNTO WHERE ID_TIPO_ASUNTO="+idTipoAsunto;
        return sql ;
    }
	
	/**
     * Construye un SQL Query para Verificar si Existe un Tipo de Asunto por su Nombre y UA, ademas de compararlos con sus datos antes de ser editados
     * @param strNombre Nombre 
     * @param strArea Unidad Administrativa 
     * @param strAux Nombre del Tipo de Asunto antes de ser editado
     * @param strAux2 Unidad Administrativa  antes de ser editado
     * @return Regresa un String con el Query correspondiente
     */
	public static String getTipoAsuntoExiste(String strNombre, String strAux, String strArea, String strAux2)
    {   
		String strSql=	"SELECT TIP_ASU_NOMBRE FROM SD_TIPO_ASUNTO WHERE " +
		"NOT (LOWER(TIP_ASU_NOMBRE)	= LOWER('" + strAux + "') " +
		"AND  LOWER(TIP_ASU_AREA) 	= LOWER('" + strAux2 + "')) " +
		"AND  LOWER(TIP_ASU_NOMBRE)	= LOWER('" + strNombre + "') " +
		"AND  LOWER(TIP_ASU_AREA) 	= LOWER('" + strArea + "') " +
		"AND  TIP_ASU_ESTATUS = 1";
    
		return strSql;
    } 

	/**
     * Construye un SQL Query para regresar todas las Rutas Automaticas asociadas a un Tipo de Asunto
     * 
     * @param strIdArea ID del Tipo de Asunto
     * 
     * @return Regresa un String con el Query correspondiente
     */
	public static String getCountRuta(String strIdArea){
    	String sql = "SELECT COUNT(RUT_AUT_TIPO_ASUNTO) FROM SD_RUTA_AUTOMATICA WHERE RUT_AUT_TIPO_ASUNTO="+strIdArea+" AND RUT_AUT_ESTATUS=1";
    	return sql;
    }
	
	/**
     * Construye un SQL Query para regresar todos los Asuntos asociados a un Tipo de Asunto
     * 
     * @param IdTipoAsunto ID del Tipo de Asunto
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountAsuntos(String IdTipoAsunto){
    	String sql = "SELECT COUNT(ASU_TIPO_ASUNTO) FROM SD_ASUNTO WHERE ASU_TIPO_ASUNTO="+IdTipoAsunto+" AND (ASU_ESTATUS<>3 AND ASU_ESTATUS<>4)";
    	return sql;
    }

    /**
     * Construye un SQL Query para Regresar el Estatus de un Tipo de Asunto  
     * @param strIdTipoAsunto ID del Tipo de Asunto  
     * @return Regresa un String con el Query correspondiente
     */
    public static String getEstatusTipoAsunto(String strIdTipoAsunto)
    {
        String sql = "";
        sql = "SELECT TIP_ASU_ESTATUS FROM SD_TIPO_ASUNTO WHERE ID_TIPO_ASUNTO="+strIdTipoAsunto;
        return sql;
    }
}

