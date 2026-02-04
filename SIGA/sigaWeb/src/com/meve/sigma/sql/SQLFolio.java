/**
 * Clase:						SQLFolio.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Sep 22, 2005
 * 
 * @author: 					Arturo Corichi Guerrero
 * 								corichi@yahoo.com.mx

 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		Clase que contiene metodos que contruyen sentencias sql para la 
 * 								actualizacion y lectura de la tabla FOLIO
 */

package com.meve.sigma.sql;

/**
 * SQLFolio es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_FOLIO
 * @author Meve Soluciones SA de CV
 *
 */
public class SQLFolio {
    
    /**
     * Datos del folio
     * @param DN	id folio
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getFolio(String DN)
	{
		String strSql="";		
		strSql=	"SELECT FOL_AREA, FOL_TIPO_FOLIO, FOL_CLAVE, FOL_CONSECUTIVO," +
				" FOL_ORDEN, FOL_USR_ACTUALIZO, to_char(FOL_FEC_ACTUALIZACION, 'dd/MM/yyyy HH:MI:SS AM')" +
				" FROM SD_FOLIO" +
				" WHERE ID_FOLIO=" + DN;
		return strSql;
	}
    
    /**
     * Inserta registro de un folio
     * @param idArea	Id área
     * @param tipoFolio	tipo de folio
     * @param clave		clave
     * @param consecutivo	consecutivo
     * @param orden			orden 
     * @param actualizo		usuario que actualizo
     * @param fecha			fecha de Actualización
     * @param estatus		Estatus
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getInsertaFolio(	String idArea, String tipoFolio, String clave, String consecutivo, 
			String orden, String actualizo, String fecha, String estatus)
    {
        String sql = "";
        sql = 	"INSERT INTO SD_FOLIO" +
        		" (ID_FOLIO, FOL_AREA, FOL_TIPO_FOLIO, FOL_CLAVE, FOL_CONSECUTIVO, FOL_ORDEN, FOL_USR_ACTUALIZO, FOL_FEC_ACTUALIZACION, FOL_ESTATUS)" +
        		" VALUES (SD_FOLIO_SEQ.NEXTVAL, "+idArea+", "+tipoFolio+", '"+clave+"', "+consecutivo+"," +
        		//" '"+ orden + "', "+actualizo+", '"+fecha+"', "+estatus+")";
        		" '"+ orden + "', "+actualizo+", SYSDATE, "+estatus+")";
        return sql;
    }
    
    /**
     * Lista de los folios para la consulta en el catalogo
	 * @return	regresa arreglo con la lista de folios de las áreas
	 * @param strOrden	Orden
	 * @param tipo		tipo de orden
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getFolios(String strOrden, String tipo)
	{
		String strSql="";
		strSql=	"SELECT  ID_FOLIO, ARE_NOMBRE, CASE FOL_TIPO_FOLIO WHEN 1 THEN 'Recepcion' WHEN 0 THEN 'Turnado' END AS FOL_TIPO,";
		strSql+=" FOL_CLAVE, FOL_CONSECUTIVO, FOL_ORDEN, FOL_USR_ACTUALIZO, FOL_FEC_ACTUALIZACION, FOL_AREA";
		strSql+=" FROM SD_FOLIO , SD_AREA";
		strSql+=" WHERE FOL_ESTATUS=1 ";
		strSql+=" AND SD_FOLIO.FOL_AREA=SD_AREA.ID_AREA ";
		strSql+=" AND FOL_ESTATUS=1 ";
		strSql+=" AND ID_FOLIO <> 0 ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}												
		return strSql;	
	}

	/**
	 * Actualización de un registro de folio
	 * @param idFolio	id folio
	 * @param idArea	Id área
     * @param tipoFolio	tipo de folio
     * @param clave		clave
     * @param consecutivo	consecutivo
     * @param orden			orden 
     * @param actualizo		usuario que actualizo
     * @param fecha			fecha de Actualización
     * @param estatus		Estatus
	 * @return	Regresa un String con el Query correspondiente
	 */
    public static String getActualizarFolio(String idFolio, String idArea, 
    										String tipoFolio, String clave, String consecutivo, 
											String orden, String actualizo, String fecha)
    {
    	String strSql="";
    	strSql=	"UPDATE SD_FOLIO SET " +
		"FOL_AREA="+idArea+", FOL_TIPO_FOLIO="+tipoFolio+", FOL_CLAVE='" + clave +"', "+
		"FOL_CONSECUTIVO="+consecutivo+ ", FOL_ORDEN='" + orden +"', " +
		"FOL_USR_ACTUALIZO="+actualizo+", " +
		//"FOL_FEC_ACTUALIZACION='"+fecha+"' " +
		//"FOL_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY') " +
		"FOL_FEC_ACTUALIZACION=SYSDATE " +
		"WHERE ID_FOLIO="+idFolio;
    	return strSql;
    }
    
    /**
     * Eliminó los registros de los folios seleccionados
     * @param strId	ids folios
     * @return	Regresa un String con el Query correspondiente
     */
	public static String getDeleteFolio(String strIds)
	{
		String strSql="";  
		strSql=	" UPDATE SD_FOLIO SET"	+
		" FOL_ESTATUS=0, FOL_FEC_ACTUALIZACION=SYSDATE WHERE ID_FOLIO IN ("+strIds+")";				
		return strSql;    	
	}
    
    /**
     * Datos para la generación del folio como consecutivo, clave
     * @param idArea	id área
     * @return	Regresa un String con el Query correspondiente
     */	
    public static String getGeneracionFolio(String idArea)
    {
        String strSql = "";
        strSql = 	"SELECT FOL_CLAVE, FOL_CONSECUTIVO, FOL_TIPO_FOLIO, " +
        			" FOL_ORDEN, ID_FOLIO FROM SD_FOLIO WHERE FOL_AREA="+idArea+" AND FOL_TIPO_FOLIO=1 AND FOL_ESTATUS=1";
        return strSql;
    }
    
    /**
     * Actualización del consecutivo del folio
     * @param strConsecutivo	Consecutivo
     * @param strIdFolio		id Folio
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getActualizaConsecutivoFolio(String strConsecutivo, String strIdFolio)
    {
        String strSql = "";
        strSql = "UPDATE SD_FOLIO SET FOL_CONSECUTIVO="+strConsecutivo+" WHERE ID_FOLIO="+strIdFolio;
        return strSql;
    }
    
    /**
     * Retorna un query para comprobar que exista un registro de cierta área
     * @param strIdArea	Id área
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getExisteFolio(String strIdArea)
    {
        String strSql = "";
        strSql = "SELECT * FROM SD_FOLIO WHERE FOL_AREA="+strIdArea+" AND FOL_TIPO_FOLIO=1 AND FOL_ESTATUS=1";
        return strSql;
    }
    
    /**
     * Función que crea un query con el folio de turnado
     * @param idArea
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getGeneracionFolioTurnado(String idArea)
    {
        String strSql = "";
        strSql = 	"SELECT FOL_CLAVE, FOL_CONSECUTIVO, FOL_TIPO_FOLIO, " +
        			" FOL_ORDEN, ID_FOLIO FROM SD_FOLIO " +
        			"WHERE FOL_AREA="+idArea+" AND FOL_TIPO_FOLIO=0 AND FOL_ESTATUS=1";
        return strSql;
    }
    
    /**
     * Crea un sql query para verificar que exitan Folios en una UA
     * @param strIdArea		Unidad Administrativa
     * @param strIdFolio	ID del Folio
     * @return	String del Query
     */
    public static String getFolioExiste(String strIdArea, String strIdFolio){
    	String sql = "SELECT COUNT(FOL_CLAVE) FROM SD_FOLIO " +
					"WHERE FOL_AREA = " + strIdArea + 
					"AND ID_FOLIO <> " + strIdFolio + 
					"AND FOL_TIPO_FOLIO = 1 AND FOL_ESTATUS = 1";
    	return sql;
    }     

    /**
     * Crea un sql query para verificar que exitan Claves de Folios
     * @param strClave		Clave del Folio
     * @param strIdFolio	ID del Folio
     * @return	String del Query
     */
    public static String getClaveFolioExiste(String strClave, String strIdFolio){
    	String sql = "SELECT COUNT(FOL_CLAVE) FROM SD_FOLIO " +
					"WHERE LOWER(TRANSLATE(FOL_CLAVE,'áéíóúÁÉÍÓÚ','aeiouAEIOU')) LIKE LOWER(TRANSLATE('"+strClave+"','áéíóúÁÉÍÓÚ','aeiouAEIOU'))" +  
					"AND ID_FOLIO <> " + strIdFolio + 
					"AND FOL_ESTATUS = 1";
    	return sql;
    }     

}

