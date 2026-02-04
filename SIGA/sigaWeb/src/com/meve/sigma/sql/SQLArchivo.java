/*
 * Clase:						SQLArchivo.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Mar 10, 2006
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
 * SQLArchivo es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_ARCHIVO
 * 
 * @author Meve Soluciones SA de CV
 *
 */
public class SQLArchivo {
    
    /**
     * Datos de un archivo
     * @param strIdAsunto	Id asunto
     * @return query
     */
    public static String getArchivos(String strIdAsunto,String strInstruccion)	
	{
    	
    	String strSql="";
    	String strAsunto = "-1";
    	if (strIdAsunto.length() > 0 && strInstruccion.length() == 0) {
    		strSql=	" SELECT ID_ARCHIVO, ARC_NOMBRE_ARCHIVO FROM SD_ARCHIVOS "	+
			" WHERE ARC_ASUNTO="+strIdAsunto+ " AND ARC_TIPO_DOC='DP' AND ARC_INSTRUCCION="+strAsunto+
			" ORDER BY 1";
    		
    		/*strSql="SELECT ID_REFERENCIA, NOMBRE_ARCHIVO " + "FROM SD_CONTENT_ORACLE WHERE TIPO_DOCUMENTO  = 'DP' AND  ID_ASUNTO_CONTENT=" + 
                strIdAsunto + " AND ID_INS_CONTENT  = " + strAsunto;*/    		
    	}
    	if (strInstruccion.length() > 0) {
    		strSql=	" SELECT ID_ARCHIVO, ARC_NOMBRE_ARCHIVO FROM SD_ARCHIVOS "	+
			" WHERE ARC_ASUNTO="+strIdAsunto+ " AND ARC_TIPO_DOC='DP' AND ARC_INSTRUCCION="+strInstruccion+
			" ORDER BY 1";
    		
    		/*strSql="SELECT ID_REFERENCIA, NOMBRE_ARCHIVO " + "FROM SD_CONTENT_ORACLE WHERE TIPO_DOCUMENTO  = 'DP' AND  ID_INS_CONTENT=" + 
            strInstruccion;*/
    	}
		
		return strSql;
	}
    
    public static String getArchivosDocS(String strIdAsunto,String strInstruccion)	
	{
    	
    	String strSql="";
    	String strAsunto = "-1";
    	if (strIdAsunto.length() > 0 && strInstruccion.length() == 0) {
    		strSql=	" SELECT ID_ARCHIVO, ARC_NOMBRE_ARCHIVO FROM SD_ARCHIVOS "	+
			" WHERE ARC_ASUNTO="+strIdAsunto+ " AND ARC_TIPO_DOC='DS' AND ARC_INSTRUCCION="+strAsunto+
			" ORDER BY 1";
    		
    		/*strSql="SELECT ID_REFERENCIA, NOMBRE_ARCHIVO " + "FROM SD_CONTENT_ORACLE WHERE TIPO_DOCUMENTO  = 'DP' AND  ID_ASUNTO_CONTENT=" + 
                strIdAsunto + " AND ID_INS_CONTENT  = " + strAsunto;*/    		
    	}
    	if (strInstruccion.length() > 0) {
    		strSql=	" SELECT ID_ARCHIVO, ARC_NOMBRE_ARCHIVO FROM SD_ARCHIVOS "	+
			" WHERE ARC_ASUNTO="+strIdAsunto+ " AND ARC_TIPO_DOC='DS' AND ARC_INSTRUCCION="+strInstruccion+
			" ORDER BY 1";
    		
    		/*strSql="SELECT ID_REFERENCIA, NOMBRE_ARCHIVO " + "FROM SD_CONTENT_ORACLE WHERE TIPO_DOCUMENTO  = 'DP' AND  ID_INS_CONTENT=" + 
            strInstruccion;*/
    	}
		//System.out.println("sql="+strSql);
		return strSql;
	}    
    
    /**
     * Verifica si existe el archivo en la base de datos por id de asunto
     * @param strIdAsunto	Id asunto
     * @return query
     */
    public static String getExisteArchivo(String strIdAsunto)
    {
        String sql = "SELECT ARC_NOMBRE_ARCHIVO FROM SD_ARCHIVOS " +
        			"WHERE ARC_ASUNTO="+strIdAsunto+ "AND ARC_TIPO_DOC='DP' AND ARC_INSTRUCCION=-1";
        return sql;
    }
    
    public static String getExisteArchivoDocS(String strIdAsunto)
    {
        String sql = "SELECT ARC_NOMBRE_ARCHIVO FROM SD_ARCHIVOS " +
        			"WHERE ARC_ASUNTO="+strIdAsunto+ "AND ARC_TIPO_DOC='DP' AND ARC_INSTRUCCION=-1";
        return sql;
    }
    
    /**
     * Elimina archivo
     * @param strIds	Ids de los archivos a eliminar
     * @return Query
     */
    public static String deleteArchivo(String strIds[])
    {
        String strSql="";  
		String ids="";  
		for(int i=0; i<strIds.length;i++) 
			ids+=strIds[i]+","; 
		ids=ids.substring(0,ids.length()-1);
        String sql = "DELETE FROM SD_ARCHIVOS WHERE ID_ARCHIVO IN("+ids+")";
        return sql;
    }
    
    /**
     * Content Type del archivo
     * @param strIdArchivo	Id archivo
     * @return query
     */
    public static String getContentType(String strIdArchivo)
	{
		String strSql="";
		
		strSql=	" SELECT ARC_CONTENT_TYPE FROM SD_ARCHIVOS WHERE "+				
				" ID_ARCHIVO="+ strIdArchivo;		
		
		return strSql;
	}
    
    /**
     * Obtiene el arreglo de bytes de un archivo
     * @param strId_Archivo	Id archivo
     * @return Regresa un String con el Query correspondiente
     */
    public static String getArchivoBinario(String strId_Archivo)
	{
		String strSql="";
		
		strSql=	" SELECT ARC_ARCHIVO FROM SD_ARCHIVOS WHERE "+				
				" ID_ARCHIVO="+strId_Archivo;		
		return strSql;
	}
    
    /**
	 * Función que realiza la conexión a la base de datos de oracle, con los datos parametrizados.
	 * 
	 * @return		boolean		Regresa un valor booleano. Regresa un valor de true en caso de que
	 * 							la conexion se realizó exitosamente, y false en caso de que no se
	 * 							pueda realizar la conexión.
	 */	
	public static String getInsertaArchivo(	String strNombreArchivo,			
											String strContentType,
											String strIdAsunto,
											String strIdInst,
											String strIdUsuario,											
											String strTipoDoc)	
	{
		String strSql="";
		/*strSql=	"INSERT INTO SD_ARCHIVOS(ID_ARCHIVO, ARC_NOMBRE_ARCHIVO, ARC_CONTENT_TYPE, " +
				"ARC_ASUNTO, ARC_INSTRUCCION, ARC_USUARIO, ARC_FECHA_CREACION, ARC_ARCHIVO) VALUES "	+
				"(SD_ARCHIVOS_SEQ.NEXTVAL,'"	+	strNombreArchivo+
				"','"+strContentType+
				"',"+strIdAsunto+
				", 0"+
				","+strIdUsuario+
				", SYSDATE"+
				",?)";*/
		strSql=	"INSERT INTO SD_ARCHIVOS(ID_ARCHIVO, ARC_NOMBRE_ARCHIVO, ARC_CONTENT_TYPE, " +
		"ARC_ASUNTO, ARC_INSTRUCCION, ARC_USUARIO,ARC_TIPO_DOC, ARC_FECHA_CREACION,ARC_ARCHIVO) VALUES "	+
		"(SD_ARCHIVOS_SEQ.NEXTVAL,'"	+	strNombreArchivo+
		"','"+strContentType+
		"',"+strIdAsunto+
		", "+strIdInst+
		","+strIdUsuario+
		",'"+strTipoDoc+
		"', SYSDATE,?)";
		
	//System.out.println("getInsertaArchivo->"+strSql);
		return strSql;
		
	}
	
	/**
	 * Inserta sis
	 * @param strDescribe describe
	 * @param strFoliio  folio
	 * @return  Regresa un String con el Query correspondiente
	 */
	public static String getInsertaSisi(String strDescribe, String strFoliio)	
	{
		String strSql="";
			
		strSql=	"INSERT INTO SD_ASUNTO(ID_ASUNTO, ASU_ENTIDAD, ASU_REMITENTE, ASU_USR_TURNA,ASU_DESCRIPCION,ASU_TIP_DOCTO,ASU_SINTESIS,ASU_FOLIO_EXTERNO,ASU_ESTATUS,ASU_FECHA_CAPTURA,ASU_AVANCE,ASU_USUARIO_CAPTURA,ASU_AREA_RECEPCION, ASU_CONTROL, ASU_FECHA_RECEPCION, ASU_FOLIO_RECEPCION) " +
		"VALUES (SD_ASUNTO_SEQ.NEXTVAL, (SELECT ID_ENTIDAD FROM SD_ENTIDAD WHERE ENT_NOMBRE = 'SISI'),(SELECT ID_REMITENTE FROM SD_REMITENTE WHERE  RMT_ENTIDAD = (SELECT ID_ENTIDAD FROM SD_ENTIDAD WHERE ENT_NOMBRE = 'SISI')),(SELECT ARE_SUPERVISOR FROM SD_AREA WHERE ARE_NOMBRE 'Unidad de Enlace'),'Solicitud de Informacion SISI',(SELECT ID_TIPO_DOCTO FROM SD_TIPO_DOCUMENTO WHERE TIP_DOCTO_NOMBRE = 'Solicitud de SISI'),' "	+
		strDescribe+"','"	+	strFoliio	+
		"',0,SYSDATE,0,(SELECT ARE_SUPERVISOR FROM SD_AREA WHERE ARE_NOMBRE='Unidad de Enlace'),(SELECT ID_AREA FROM SD_AREA WHERE ARE_NOMBRE='Unidad de Enlace'),0, SYSDATE, 'folio por asignar')";	
	//	//System.out.println("getInsertaArchivo-->"+strSql);
		return strSql;

	}
	
	/**
     * Elimina los archivos referenciados a un asunto
     * @param strIds ids
     * @return Regresa un String con el Query correspondiente
     */
    public static String deleteArchivoReferencia(String strIds[])
    {
        String strSql="";  
		String ids="";  
		for(int i=0; i<strIds.length;i++) 
			ids+=strIds[i]+","; 
		ids=ids.substring(0,ids.length()-1);
        String sql = "DELETE FROM SD_CONTENT_ORACLE WHERE ID_REFERENCIA IN("+ids+")";
        return sql;
    }
    
    public static String deleteArchivoRepetido(String pstr_idContent,String pstr_referencia,String pstr_nombreArchivo)
    {
    return  "DELETE \n" + 
                      "    FROM SD_CONTENT_ORACLE\n" + 
                      "    WHERE ID_ASUNTO_CONTENT = '"+pstr_idContent+"'\n" + 
                      "    AND ID_REFERENCIA = '"+pstr_referencia+"'\n" + 
                      "    AND NOMBRE_ARCHIVO = '"+pstr_nombreArchivo+"'";
    }
    
    /**
     * Actualiza referencias 
     * @param strIdArchivo	Id archivo
     * @param strIdItemDoc		Item
     * @return Regresa un String con el Query correspondiente
     */
    public static String updateReferencia(String strIdArchivo, Long strIdItemDoc)
    {
    	String strId = String.valueOf(strIdItemDoc);
        String sql="UPDATE SD_CONTENT_ORACLE SET ID_ITEM_DOC='"+strId+"' " +
        		"WHERE ID_REFERENCIA="+strIdArchivo;
        return sql;
    }



}

