/*
 * Created on Sep 14, 2005
 */
package com.meve.sigma.sql;


/**
 * Clase para generar codigo SQL para Tipo de Documento
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class SQLTipo_Doc {
    
	/**
	 * Construye un SQL Query para Inserta Tipos de Docuemnto en la Base de Datos
	 * @param strTipo_Doc Tipo de Documento 
	 * @param strTipo_DocArea Unidad Administrativa
	 * @param strTipo_DocClave Clave
	 * @param strCreador1 Usuario que lo edita
	 * @param strFechaCreacion Fecha de creación
	 * @param strEstatus Estatus
	 * @param strConsecutivo Consecutivo
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getInsertaTipo_Doc(	String strTipo_Doc, String strTipo_DocArea, String strTipo_DocClave,
			String strCreador1, String strFechaCreacion, String strEstatus, String strConsecutivo)
    {
        String sql = 	"INSERT INTO SD_TIPO_DOCUMENTO (ID_TIPO_DOCTO, TIP_DOCTO_NOMBRE, TIP_DOCTO_AREA, TIP_DOCTO_CLAVE_DOCTO," +
        				" TIP_DOCTO_FEC_ACTUALIZACION, TIP_DOCTO_USR_ACTUALIZO, TIP_DOCTO_ESTATUS, TIP_DOCTO_CONSECUTIVO) " +
        				" VALUES (SD_TIPO_DOCUMENTO_SEQ.NEXTVAL, '"+strTipo_Doc+"', "+strTipo_DocArea+", '"+strTipo_DocClave+"', " +
        				//"'"+strFechaCreacion+"', "+strCreador1+", "+strEstatus+", "+strConsecutivo+")";
        				"SYSDATE, "+strCreador1+", "+strEstatus+", "+strConsecutivo+")";
        
        return sql;
    }
      
    /**
     * Construye un SQL Query para Regresar una lista ordenada por Nombre de los Tipos de Documento
     * @return Regresa un String con el Query correspondiente
     */
    public static String getTipoDoctoCombo()
	{
		String strSql="";		
		strSql=	"SELECT ID_TIPO_DOCTO, TIP_DOCTO_NOMBRE FROM SD_TIPO_DOCUMENTO WHERE TIP_DOCTO_ESTATUS=1 ORDER BY TIP_DOCTO_NOMBRE";												
		return strSql;	
	}
    
    /**
     * Construye un SQL Query para Regresar una lista ordenada por Nombre de los Tipos de Documento
     * @return Regresa un String con el Query correspondiente
     */
    public static String getTipoDoctosGralesCombo(){
        String sql = "SELECT ID_TIPO_DOCTO, TIP_DOCTO_NOMBRE FROM SD_TIPO_DOCUMENTO WHERE TIP_DOCTO_AREA=0" +
        		" AND TIP_DOCTO_ESTATUS=1 AND ID_TIPO_DOCTO <> 0 ORDER BY TIP_DOCTO_NOMBRE";
        return sql;
    }
    
    /**
     * Construye un SQL Query para Regresar una lista ordenada por Nombre de los Tipos de Documento por Unidad Administrativa
     * @param strIdArea Unidad Administrativa
     * @return Regresa un String con el Query correspondiente
     */
    public static String getTipoDoctoCombo(String strIdArea)
	{
		String strSql="";		
		strSql=	"SELECT ID_TIPO_DOCTO, TIP_DOCTO_NOMBRE FROM SD_TIPO_DOCUMENTO WHERE TIP_DOCTO_AREA="+strIdArea+" AND TIP_DOCTO_ESTATUS=1 ORDER BY TIP_DOCTO_NOMBRE";												
		return strSql;	
	}

    /**
     * Construye un SQL Query para Regresar una lista ordenada de los Tipos de Documento
     * @param strOrden Campor por el cual se ordena la lista
     * @param tipo Ordenamiento ascendente o descendente
     * @return Regresa un String con el Query correspondiente
     */
    public static String getTipos_Doc(String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT TIP_DOCTO_NOMBRE, ID_TIPO_DOCTO, TIP_DOCTO_AREA, ARE_NOMBRE ";
		strSql+="FROM SD_TIPO_DOCUMENTO, SD_AREA WHERE TIP_DOCTO_ESTATUS=1 ";
		strSql+="AND SD_TIPO_DOCUMENTO.TIP_DOCTO_AREA=SD_AREA.ID_AREA ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 1 "+strOrden+", 1 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 1 ASC ";
		}
		return strSql;	
	}
    
    /**
	 * Construye un SQL Query para Obtiener los campos del tipo de docuemto por su ID
	 * @param idTipo_Doc ID del Tipo de Documento
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getTipo_Doc(String idTipo_Doc)
	{
		String strSql="";		
		strSql=	" SELECT TIP_DOCTO_NOMBRE, TIP_DOCTO_AREA, TIP_DOCTO_CLAVE_DOCTO, TIP_DOCTO_CONSECUTIVO, TIP_DOCTO_USR_ACTUALIZO, TO_CHAR(TIP_DOCTO_FEC_ACTUALIZACION, 'DD/MM/YYYY HH:MI:SS AM') " +
				" FROM SD_TIPO_DOCUMENTO WHERE TIP_DOCTO_ESTATUS=1 AND ID_TIPO_DOCTO="+idTipo_Doc; 
		return strSql;	
	}

    /**
	 * Construye un SQL Query para Eliminar logicamente los registros de Tipo de Documento
	 * @param strIds ID del Usuario que ejecuta la accion
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getDeleteTipo_Doc(String strIds)
	{
	    String strSql="";
		strSql=	" UPDATE SD_TIPO_DOCUMENTO SET TIP_DOCTO_ESTATUS=0, TIP_DOCTO_FEC_ACTUALIZACION=SYSDATE WHERE "	+
				"ID_TIPO_DOCTO IN ("+strIds+")";
		return strSql;
	}

	/**
	 * Construye un SQL Query para Actualizar Tipos de Docuemnto en la Base de Datos
	 * @param strId ID del Tipo de Documento
	 * @param strNombre Tipo de Documento 
	 * @param strArea Unidad Administrativa
	 * @param strClave Clave
	 * @param strCreador1 Usuario que lo edita
	 * @param strFechaCreacion Fecha de creación
	 * @param strEstatus Estatus
	 * @param strConsecutivo Consecutivo
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getActualizaTipo_Doc(	String strId, String strNombre, String strArea, 
            									String strClave, String strCreador1, 
            									String strFechaCreacion, String strEstatus, 
            									String strConsecutivo)
    {
        String sql =	"UPDATE SD_TIPO_DOCUMENTO SET TIP_DOCTO_NOMBRE='"+strNombre
						+"', TIP_DOCTO_AREA="+strArea+", TIP_DOCTO_CLAVE_DOCTO='"+strClave+"', TIP_DOCTO_USR_ACTUALIZO="
						//+strCreador1+", TIP_DOCTO_FEC_ACTUALIZACION='"+strFechaCreacion+"', TIP_DOCTO_ESTATUS="
						+strCreador1+", " +
						//"TIP_DOCTO_FEC_ACTUALIZACION=TO_DATE('"+strFechaCreacion+"', 'DD/MM/YYYY'), " +
						"TIP_DOCTO_FEC_ACTUALIZACION=SYSDATE, " +
						"TIP_DOCTO_ESTATUS="+strEstatus+", TIP_DOCTO_CONSECUTIVO="+strConsecutivo+" WHERE "+"ID_TIPO_DOCTO IN ("+ strId + ")";

    	return sql;
    }
    
    /**
     * Construye un SQL Query para Regresar los campos de Tipo de Documento por ID
     * @param strIdTipoDocto ID del Tipo de Documento
     * @return Regresa un String con el Query correspondiente
     */
    public static String getTipoDoctoFolio(String strIdTipoDocto)
    {
        String sql = "";
        sql = 	"SELECT TIP_DOCTO_NOMBRE, TIP_DOCTO_CLAVE_DOCTO, TIP_DOCTO_AREA, TIP_DOCTO_CONSECUTIVO " +
        		"FROM SD_TIPO_DOCUMENTO WHERE ID_TIPO_DOCTO="+strIdTipoDocto+
        		" AND TIP_DOCTO_ESTATUS=1";
        return sql;
    }
    
    /**
     * Construye un SQL Query para Regresar los campos de Tipo de Documento por UA
     * @param strIdArea ID de la Unidad Administrativa
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDoctosArea(String strIdArea)
    {
        String sql = "";
        sql = 	"SELECT ID_TIPO_DOCTO, TIP_DOCTO_NOMBRE FROM SD_TIPO_DOCUMENTO WHERE TIP_DOCTO_AREA="+strIdArea;
        return sql;
    }
    
    /**
     * Construye un SQL Query para Regresar el nombre del Tipo de Documento segun su ID
     * @param strIdTipoDocto ID del Tipo de Documento
     * @return Regresa un String con el Query correspondiente
     */
    public static String getNombreTipoDocto(String strIdTipoDocto){
        String sql = "SELECT TIP_DOCTO_NOMBRE FROM SD_TIPO_DOCUMENTO WHERE ID_TIPO_DOCTO="+strIdTipoDocto+"";
        return sql;
    }
    
    /**
     * Construye un SQL Query para Regresar una lista con los ID's de tipo de Documento
     * @return Regresa un String con el Query correspondiente
     */
    public static String getIdDocto0(){
        String sql = "SELECT ID_TIPO_DOCTO, TIP_DOCTO_NOMBRE FROM SD_TIPO_DOCUMENTO WHERE ID_TIPO_DOCTO=1";
        return sql;
    }
    
    /**
     * Construye un SQL Query para actualizar
     * el consecutivo de un tipo de documento
     * @param strConsecutivo Consecutivo
     * @param strIdTD ID del tipo de Documento
     * @return Regresa un String con el Query correspondiente
     */
    public static String getActualizaConsecutivoTD(String strConsecutivo, String strIdTD)
    {
        String strSql = "";
        strSql = "UPDATE SD_TIPO_DOCUMENTO SET TIP_DOCTO_CONSECUTIVO="+strConsecutivo+" " +
        		"WHERE ID_TIPO_DOCTO="+strIdTD;
        return strSql;
    }
    
    /**
     * Construye un SQL Query para Verificar si Existe un Tipo de Docto por su Clave y UA, ademas de compararlos con sus datos antes de ser editados
     * @param strClave Clave
     * @param strArea Unidad Administrativa 
     * @param strAux Clave del Tipo de Docto antes de ser editado
     * @param strAux2 Unidad Administrativa  antes de ser editado
     * @return Regresa un String con el Query correspondiente
     */
    public static String getTipoDocExiste(String strClave, String strAux, String strArea, String strAux2)
    {   
		String strSql=	"SELECT TIP_DOCTO_CLAVE_DOCTO FROM SD_TIPO_DOCUMENTO WHERE " +
		"NOT (LOWER(TIP_DOCTO_CLAVE_DOCTO)	= LOWER('" + strAux + "') " +
		"AND  LOWER(TIP_DOCTO_AREA) 	= LOWER('" + strAux2 + "')) " +
		"AND  LOWER(TIP_DOCTO_CLAVE_DOCTO)	= LOWER('" + strClave + "') " +
		"AND  LOWER(TIP_DOCTO_AREA) 	= LOWER('" + strArea + "') " +
		"AND  TIP_DOCTO_ESTATUS = 1";
    
		return strSql;
    }
    
    /**
     * Construye un SQL Query para regresar todos los Pasos asociados a un Tipo de Documento
     * 
     * @param strIdArea ID del Tipo de Documento
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountPasos(String strIdArea){
    	String sql = "SELECT COUNT(PAS_TIPO_DOCTO) FROM SD_PASO WHERE PAS_TIPO_DOCTO="+strIdArea+" AND PAS_ESTATUS=1";
    	return sql;
    }    

    /**
     * Construye un SQL Query para regresar todas las Rutas Automaticas asociadas a un Tipo de Documento
     * 
     * @param strIdArea ID del Tipo de Documento
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountRuta(String strIdArea){
    	String sql = "SELECT COUNT(RUT_AUT_TIPO_DOCTO) FROM SD_RUTA_AUTOMATICA WHERE RUT_AUT_TIPO_DOCTO="+strIdArea+" AND RUT_AUT_ESTATUS=1";
    	return sql;
    }    

    /**
     * Construye un SQL Query para regresar todos los Asuntos asociados a un Tipo de Documento
     * 
     * @param strIdArea ID del Tipo de Documento
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountAsuntos(String strIdArea){
    	String sql = "SELECT COUNT(ASU_TIP_DOCTO) FROM SD_ASUNTO WHERE ASU_TIP_DOCTO="+strIdArea+" AND (ASU_ESTATUS<>3 AND ASU_ESTATUS<>4)";
    	return sql;
    }    

    /**
     * Construye un SQL Query para Regresar el Estatus de un Tipo de Documento  
     * @param strIdTipoDoc ID del Tipo de Documento  
     * @return Regresa un String con el Query correspondiente
     */
    public static String getEstatusTipoDoc(String strIdTipoDoc)
    {
        String sql = "";
        sql = "SELECT TIP_DOCTO_ESTATUS FROM SD_TIPO_DOCUMENTO WHERE ID_TIPO_DOCTO="+strIdTipoDoc;
        return sql;
    }
}
