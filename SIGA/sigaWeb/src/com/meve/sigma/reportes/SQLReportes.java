/*
 * Clase:						SQLReportes.java
 * 
 * Paquete:						com.meve.sigma.reportes		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Oct 22, 2005 
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

package com.meve.sigma.reportes;

import com.meve.sigma.util.Utilerias;


/**
 * Clase para generar codigo SQL Query
 *
 * @author Meve Soluciones S.A. de C.V.
 */
public class SQLReportes {
    
	/**
     * Construye un SQL Query para regresar un Reporte de Asuntos
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getReporte(String inicio, String fin, String strIdArea)
    {
        String sql = "";
        sql = "SELECT AREA, AREA||' - '||TIPO_DOCTO, COUNT(TIPO_DOCTO) FROM( " +
        		"SELECT " +
        		"CASE ASU_ESTATUS " +
        		"	WHEN 1 THEN ARE_NOMBRE " +
        		"	WHEN 2 THEN (SELECT ASU_REF_AREA_RECEPCION FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"	WHEN 3 THEN (SELECT ASU_REF_AREA_RECEPCION FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"END AS AREA, " +
        		"CASE ASU_ESTATUS " +
        		"	WHEN 1 THEN TIP_DOCTO_NOMBRE " +
        		" 	WHEN 2 THEN (SELECT ASU_REF_TIPO_DOCTO FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"	WHEN 3 THEN (SELECT ASU_REF_TIPO_DOCTO FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"END AS TIPO_DOCTO " +
        		"FROM SD_ASUNTO, SD_TIPO_DOCUMENTO, SD_AREA, SD_USUARIO " +
        		"WHERE ASU_FECHA_CAPTURA>=TO_DATE('"+inicio+" 00:00:00','DD/MM/YYYY HH24:MI:SS') " +
        		"AND ASU_FECHA_CAPTURA<=TO_DATE('"+fin+" 23:59:59','DD/MM/YYYY HH24:MI:SS') " +
        		"AND ASU_TIP_DOCTO=ID_TIPO_DOCTO " +
        		"AND ID_AREA=TIP_DOCTO_AREA " +
        		"AND ASU_ESTATUS IN (1,2,3) " +
        		"AND (ID_AREA="+strIdArea+" OR ID_AREA=0)  " +
        		"AND SD_ASUNTO.ASU_USUARIO_CAPTURA = SD_USUARIO.ID_USUARIO " +
        		"AND SD_USUARIO.USU_AREA = "+strIdArea+" ) " +
        		"WHERE AREA IS NOT null " +
        		"AND TIPO_DOCTO IS NOT null " +
        		"GROUP BY AREA, TIPO_DOCTO " +
        		"ORDER BY 2";        
        return sql;
    }
    
    /**
     * Construye un SQL Query para regresar un Reporte por Tiempos de Respuesta
     * 
     * @param strInicio limite inferior de la Fecha de Creacion del Asunto
     * @param strFin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getReportePorTiempos(String strInicio, String strFin, String strIdArea){
    	
        
        String sql = "SELECT ASU_REF_AREA_RECEPCION||' - '||ASU_REF_TIPO_DOCTO, " +
        		"ASU_REF_AREA_RECEPCION, " +
        		"COUNT(ASU_REF_TIPO_DOCTO) AS ASUNTOS, " +
        		" " +
        		"(SELECT MIN(INS_TIEMPO) " +
        		"FROM SD_ASUNTO_DESCRIPCION B, SD_INSTRUCCION_ASUNTO, SD_ASUNTO " +
        		"WHERE INS_ESTATUS=4 " +
        		"AND INS_PADRE IS NULL " +
        		"AND SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO " +
        		"AND B.ID_ASUNTO_REF = SD_ASUNTO.ID_ASUNTO " +
        		"AND A.ASU_REF_TIPO_DOCTO = B.ASU_REF_TIPO_DOCTO " +
        		"AND A.ASU_REF_AREA_RECEPCION = B.ASU_REF_AREA_RECEPCION " +
        		"AND ASU_ESTATUS=3) AS MIN_PLAN, " +
        		" " +
        		"(SELECT MAX(INS_TIEMPO) " +
        		"FROM SD_ASUNTO_DESCRIPCION B, SD_INSTRUCCION_ASUNTO, SD_ASUNTO " +
        		"WHERE INS_ESTATUS=4 " +
        		"AND INS_PADRE IS NULL " +
        		"AND SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO " +
        		"AND B.ID_ASUNTO_REF = SD_ASUNTO.ID_ASUNTO " +
        		"AND A.ASU_REF_TIPO_DOCTO = B.ASU_REF_TIPO_DOCTO " +
        		"AND A.ASU_REF_AREA_RECEPCION = B.ASU_REF_AREA_RECEPCION " +
        		"AND ASU_ESTATUS=3) AS MAX_PLAN, " +
        		" " +
        		"(SELECT AVG(INS_TIEMPO) " +
        		"FROM SD_ASUNTO_DESCRIPCION B, SD_INSTRUCCION_ASUNTO, SD_ASUNTO " +
        		"WHERE INS_ESTATUS=4 " +
        		"AND INS_PADRE IS NULL " +
        		"AND SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO " +
        		"AND B.ID_ASUNTO_REF = SD_ASUNTO.ID_ASUNTO " +
        		"AND A.ASU_REF_TIPO_DOCTO = B.ASU_REF_TIPO_DOCTO " +
        		"AND A.ASU_REF_AREA_RECEPCION = B.ASU_REF_AREA_RECEPCION " +
        		"AND ASU_ESTATUS=3) AS AVG_PLAN, " +
        		" " +
        		"(SELECT MIN(INS_TIEMPO_REAL) " +
        		"FROM SD_ASUNTO_DESCRIPCION B, SD_INSTRUCCION_ASUNTO, SD_ASUNTO " +
        		"WHERE INS_ESTATUS=4 " +
        		"AND INS_PADRE IS NULL " +
        		"AND SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO " +
        		"AND B.ID_ASUNTO_REF = SD_ASUNTO.ID_ASUNTO " +
        		"AND A.ASU_REF_TIPO_DOCTO = B.ASU_REF_TIPO_DOCTO " +
        		"AND A.ASU_REF_AREA_RECEPCION = B.ASU_REF_AREA_RECEPCION " +
        		"AND ASU_ESTATUS=3) AS MIN_PLAN, " +
        		" " +
        		"(SELECT MAX(INS_TIEMPO_REAL) " +
        		"FROM SD_ASUNTO_DESCRIPCION B, SD_INSTRUCCION_ASUNTO, SD_ASUNTO " +
        		"WHERE INS_ESTATUS=4 " +
        		"AND INS_PADRE IS NULL " +
        		"AND SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO " +
        		"AND B.ID_ASUNTO_REF = SD_ASUNTO.ID_ASUNTO " +
        		"AND A.ASU_REF_TIPO_DOCTO = B.ASU_REF_TIPO_DOCTO " +
        		"AND A.ASU_REF_AREA_RECEPCION = B.ASU_REF_AREA_RECEPCION " +
        		"AND ASU_ESTATUS=3) AS MAX_PLAN, " +
        		" " +
        		"(SELECT AVG(INS_TIEMPO_REAL) " +
        		"FROM SD_ASUNTO_DESCRIPCION B, SD_INSTRUCCION_ASUNTO, SD_ASUNTO " +
        		"WHERE INS_ESTATUS=4 " +
        		"AND INS_PADRE IS NULL " +
        		"AND SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO " +
        		"AND B.ID_ASUNTO_REF = SD_ASUNTO.ID_ASUNTO " +
        		"AND A.ASU_REF_TIPO_DOCTO = B.ASU_REF_TIPO_DOCTO " +
        		"AND A.ASU_REF_AREA_RECEPCION = B.ASU_REF_AREA_RECEPCION " +
        		"AND ASU_ESTATUS=3) AS AVG_PLAN " +
        		"FROM SD_ASUNTO_DESCRIPCION A, SD_ASUNTO, SD_TIPO_DOCUMENTO, SD_USUARIO " +
        		"WHERE ASU_FECHA_CAPTURA >= TO_DATE('"+strInicio+" 00:00:00','DD/MM/YYYY HH24:MI:SS') " +
        		"AND ASU_FECHA_CAPTURA<= TO_DATE('"+strFin+" 23:59:59','DD/MM/YYYY HH24:MI:SS') " +
        		"AND A.ID_ASUNTO_REF = SD_ASUNTO.ID_ASUNTO " +
        		"AND SD_ASUNTO.ASU_TIP_DOCTO = SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO " +
        		"AND (TIP_DOCTO_AREA = "+strIdArea+" OR TIP_DOCTO_AREA=0) " + 
        		"AND SD_ASUNTO.ASU_USUARIO_CAPTURA = SD_USUARIO.ID_USUARIO " +
        		"AND SD_USUARIO.USU_AREA = "+strIdArea+" " +
				"AND ASU_ESTATUS=3 " +
        		"GROUP BY ASU_REF_AREA_RECEPCION, ASU_REF_TIPO_DOCTO " +
        		"ORDER BY ASU_REF_AREA_RECEPCION, ASU_REF_TIPO_DOCTO ";
        
        return sql;
    }
    
    /**
     * Construye un SQL Query para regresar un Reporte por Remitente
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getReportePorRemitente(String inicio, String fin, String strIdArea)
    {
        String sql = "";
       
        sql = "SELECT AREA, AREA||' - '||REMITENTE, COUNT(REMITENTE) FROM ( " +
        		"SELECT " +
        		"CASE ASU_ESTATUS " +
        		"	WHEN 1 THEN ENT_NOMBRE " +
        		"	WHEN 2 THEN (SELECT ASU_REF_ENTIDAD FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"	WHEN 3 THEN (SELECT ASU_REF_ENTIDAD FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"END AS AREA, " +
        		"CASE ASU_ESTATUS " +
        		"	WHEN 1 THEN RMT_NOMBRE " +
        		"	WHEN 2 THEN (SELECT ASU_REF_REMITENTE_NOMBRE FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"	WHEN 3 THEN (SELECT ASU_REF_REMITENTE_NOMBRE FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"END AS REMITENTE " +
        		"FROM SD_ASUNTO, SD_REMITENTE, SD_AREA, SD_ENTIDAD " +
        		"WHERE ASU_FECHA_CAPTURA>=TO_DATE('"+inicio+" 00:00:00','DD/MM/YYYY HH24:MI:SS') " +
        		"AND ASU_FECHA_CAPTURA<=TO_DATE('"+fin+" 23:59:59','DD/MM/YYYY HH24:MI:SS') " +
        		"AND ID_AREA="+strIdArea+" " +
        		"AND SD_ASUNTO.ASU_REMITENTE=SD_REMITENTE.ID_REMITENTE " +
        		"AND SD_REMITENTE.RMT_AREA=SD_AREA.ID_AREA " +
        		"AND SD_REMITENTE.RMT_ENTIDAD = SD_ENTIDAD.ID_ENTIDAD " +
        		"AND RMT_ESTATUS=1 " +
        		"AND ASU_ESTATUS IN (1,2,3) " +
        		"AND ASU_CONTROL=0 ) " +
        		"WHERE AREA IS NOT null " +
        		"AND REMITENTE IS NOT null " +
        		"GROUP BY AREA, REMITENTE " +
        		"ORDER BY AREA, REMITENTE";
        return sql;
    }
    
    /**
     * Construye un SQL Query para regresar un Reporte por Remitentes Internos
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getReportePorRemitenteI(String inicio, String fin, String strIdArea)
    {
        String sql = "";
       
        sql = "SELECT AREA, AREA||' - '||USUARIO, COUNT(USUARIO) FROM ( " +
        		"SELECT " +
        		"CASE ASU_ESTATUS " +
        		"	WHEN 1 THEN ARE_NOMBRE " +
        		"	WHEN 2 THEN (SELECT ASU_REF_AREA_RECEPCION FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"	WHEN 3 THEN (SELECT ASU_REF_AREA_RECEPCION FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"END AS AREA, " +
        		"CASE ASU_ESTATUS " +
        		"	WHEN 1 THEN USU_CARGO " +
        		"	WHEN 2 THEN (SELECT ASU_REF_REMITENTE_NOMBRE FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"	WHEN 3 THEN (SELECT ASU_REF_REMITENTE_NOMBRE FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"END AS USUARIO " +
        		"FROM SD_ASUNTO, SD_USUARIO, SD_AREA " +
        		"WHERE ASU_FECHA_CAPTURA>=TO_DATE('"+inicio+" 00:00:00','DD/MM/YYYY HH24:MI:SS') " +
        		"AND ASU_FECHA_CAPTURA<=TO_DATE('"+fin+" 23:59:59','DD/MM/YYYY HH24:MI:SS') " +
        		"AND ID_AREA="+strIdArea+" " +
        		"AND SD_ASUNTO.ASU_REMITENTE=SD_USUARIO.ID_USUARIO " +
        		"AND SD_USUARIO.USU_AREA=SD_AREA.ID_AREA " +
        		"AND USU_ESTATUS=1 " +
        		"AND ASU_ESTATUS IN (1,2,3) " +
        		"AND ASU_CONTROL=1 ) " +
        		"WHERE AREA IS NOT null " +
        		"AND USUARIO IS NOT null " +
        		"GROUP BY AREA, USUARIO " +
        		"ORDER BY 2 ";
        return sql;
    }
    
    /**
     * Construye un SQL Query para regresar un Reporte por Remitente
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getReportePorDestinatario(String inicio, String fin, String strIdArea)
    {
        String sql = "";
        
        sql = "SELECT AREA, (AREA||' - '||NOMBRE_TUR) AS NOMBRE, COUNT(ASU_ESTATUS) FROM( " +
        		"SELECT " +
        		"CASE ASU_ESTATUS 	" +
        		"	WHEN 1 THEN ARE_NOMBRE " +
        		"	WHEN 2 THEN (SELECT ASU_REF_AREA_RECEPCION FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"	WHEN 3 THEN (SELECT ASU_REF_AREA_RECEPCION FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"END AS AREA, " +
        		"CASE ASU_ESTATUS " +
        		"	WHEN 1 THEN USU_NOMBRE " +
        		"	WHEN 2 THEN (SELECT ASU_TURNADOR_PUESTO FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"	WHEN 3 THEN (SELECT ASU_TURNADOR_PUESTO FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"END AS NOMBRE_TUR, ASU_ESTATUS " +
        		"FROM SD_ASUNTO, SD_USUARIO, SD_AREA " +
        		"WHERE SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
        		"AND SD_USUARIO.USU_AREA=SD_AREA.ID_AREA " +
        		"AND ASU_FECHA_CAPTURA>=TO_DATE('"+inicio+" 00:00:00','DD/MM/YYYY HH24:MI:SS') " +
	        	"AND ASU_FECHA_CAPTURA<=TO_DATE('"+fin+" 23:59:59','DD/MM/YYYY HH24:MI:SS') " +
	        	"AND SD_AREA.ID_AREA = "+strIdArea+" " +
        		"AND ASU_ESTATUS IN (1,2,3) ) " +
        		"WHERE AREA IS NOT null " +
        		"GROUP BY AREA, NOMBRE_TUR " +
        		"ORDER BY NOMBRE ";
        return sql;
    }
    
    /**
     * Construye un SQL Query para regresar un Reporte por Estatus
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea Id de la Unidad Administrativa del Usuario
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getReportePorEstatus(String inicio, String fin, String strIdArea)
    {
        String sql = "";
        sql = "SELECT ASU_REF_AREA_RECEPCION, ASU_REF_AREA_RECEPCION||' - '||ASU_REF_TIPO_DOCTO,  " +
		"COUNT(ASU_REF_TIPO_DOCTO), " +
		" " +
		"(SELECT COUNT(ASU_REF_TIPO_DOCTO) " +
		"FROM SD_ASUNTO_DESCRIPCION B, SD_ASUNTO, SD_TIPO_DOCUMENTO " +
		"WHERE B.ID_ASUNTO_REF = SD_ASUNTO.ID_ASUNTO " +
		"AND ASU_FECHA_CAPTURA>=TO_DATE('"+inicio+" 00:00:00','DD/MM/YYYY HH24:MI:SS') " +
        "AND ASU_FECHA_CAPTURA<=TO_DATE('"+fin+" 23:59:59','DD/MM/YYYY HH24:MI:SS') " +
        "AND SD_ASUNTO.ASU_TIP_DOCTO = SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO " +
		"AND A.ASU_REF_TIPO_DOCTO = B.ASU_REF_TIPO_DOCTO " +
		"AND A.ASU_REF_AREA_RECEPCION = B.ASU_REF_AREA_RECEPCION " +
		"AND ASU_ESTATUS=2 " +
		"AND (TIP_DOCTO_AREA = "+strIdArea+" OR TIP_DOCTO_AREA=0)" + 
		"AND ASU_FECHA_CADUCIDAD<=SYSDATE) AS ESTATUS1, " +
		" " +
		"(SELECT COUNT(ASU_REF_TIPO_DOCTO) " +
		"FROM SD_ASUNTO_DESCRIPCION B, SD_ASUNTO, SD_TIPO_DOCUMENTO " +
		"WHERE B.ID_ASUNTO_REF = SD_ASUNTO.ID_ASUNTO " +
		"AND ASU_FECHA_CAPTURA>=TO_DATE('"+inicio+" 00:00:00','DD/MM/YYYY HH24:MI:SS') " +
        "AND ASU_FECHA_CAPTURA<=TO_DATE('"+fin+" 23:59:59','DD/MM/YYYY HH24:MI:SS') " +
        "AND SD_ASUNTO.ASU_TIP_DOCTO = SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO " +
		"AND A.ASU_REF_TIPO_DOCTO = B.ASU_REF_TIPO_DOCTO " +
		"AND A.ASU_REF_AREA_RECEPCION = B.ASU_REF_AREA_RECEPCION " +
		"AND ASU_ESTATUS=2 " +
		"AND (TIP_DOCTO_AREA = "+strIdArea+" OR TIP_DOCTO_AREA=0)" + 
		"AND ASU_FECHA_CADUCIDAD>SYSDATE) AS ESTATUS2, " +
		" " +
		"(SELECT COUNT(ASU_REF_TIPO_DOCTO) " +
		"FROM SD_ASUNTO_DESCRIPCION B, SD_ASUNTO, SD_TIPO_DOCUMENTO " +
		"WHERE B.ID_ASUNTO_REF = SD_ASUNTO.ID_ASUNTO " +
		"AND ASU_FECHA_CAPTURA>=TO_DATE('"+inicio+" 00:00:00','DD/MM/YYYY HH24:MI:SS') " +
        "AND ASU_FECHA_CAPTURA<=TO_DATE('"+fin+" 23:59:59','DD/MM/YYYY HH24:MI:SS') " +
        "AND SD_ASUNTO.ASU_TIP_DOCTO = SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO " +
		"AND A.ASU_REF_TIPO_DOCTO = B.ASU_REF_TIPO_DOCTO " +
		"AND A.ASU_REF_AREA_RECEPCION = B.ASU_REF_AREA_RECEPCION " +
		"AND ASU_ESTATUS=3 " +
		"AND (TIP_DOCTO_AREA = "+strIdArea+" OR TIP_DOCTO_AREA=0)" + 
		"AND ASU_FECHA_CADUCIDAD<=SYSDATE) AS ESTATUS3, " +
		" " +
		"(SELECT COUNT(ASU_REF_TIPO_DOCTO) " +
		"FROM SD_ASUNTO_DESCRIPCION B, SD_ASUNTO, SD_TIPO_DOCUMENTO " +
		"WHERE B.ID_ASUNTO_REF = SD_ASUNTO.ID_ASUNTO " +
		"AND ASU_FECHA_CAPTURA>=TO_DATE('"+inicio+" 00:00:00','DD/MM/YYYY HH24:MI:SS') " +
        "AND ASU_FECHA_CAPTURA<=TO_DATE('"+fin+" 23:59:59','DD/MM/YYYY HH24:MI:SS') " +
        "AND SD_ASUNTO.ASU_TIP_DOCTO = SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO " +
		"AND A.ASU_REF_TIPO_DOCTO = B.ASU_REF_TIPO_DOCTO " +
		"AND A.ASU_REF_AREA_RECEPCION = B.ASU_REF_AREA_RECEPCION " +
		"AND ASU_ESTATUS=3 " +
		"AND (TIP_DOCTO_AREA = "+strIdArea+" OR TIP_DOCTO_AREA=0)" + 
		"AND ASU_FECHA_CADUCIDAD>SYSDATE) AS ESTATUS4 " +
		" " +
		"FROM SD_ASUNTO_DESCRIPCION A, SD_ASUNTO, SD_TIPO_DOCUMENTO, SD_USUARIO " +
		"WHERE A.ID_ASUNTO_REF = SD_ASUNTO.ID_ASUNTO " +
		"AND ASU_FECHA_CAPTURA>=TO_DATE('"+inicio+" 00:00:00','DD/MM/YYYY HH24:MI:SS') " +
        "AND ASU_FECHA_CAPTURA<=TO_DATE('"+fin+" 23:59:59','DD/MM/YYYY HH24:MI:SS') " +
        "AND SD_ASUNTO.ASU_TIP_DOCTO = SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO " +
        "AND (TIP_DOCTO_AREA = "+strIdArea+" OR TIP_DOCTO_AREA=0)" + 
        "AND SD_ASUNTO.ASU_USUARIO_CAPTURA = SD_USUARIO.ID_USUARIO " +
		"AND SD_USUARIO.USU_AREA = "+strIdArea+" " +
		"GROUP BY ASU_REF_AREA_RECEPCION, ASU_REF_TIPO_DOCTO " +
		"ORDER BY ASU_REF_AREA_RECEPCION, ASU_REF_TIPO_DOCTO ";

        return sql;
    }
    
    /**
     * Construye un SQL Query para regresar un Reporte por Fecha Limite
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getReportePorFechaLim()
    {
        String sql = "";
        sql = "SELECT DISTINCT C.ARE_NOMBRE, B.TIP_DOCTO_NOMBRE," +
        		"(SELECT COUNT (Z.ASU_DESCRIPCION) FROM SD_ASUNTO Z " +
        		"WHERE Z.ASU_TIP_DOCTO=B.ID_TIPO_DOCTO) " +
        		"FROM SD_ASUNTO A, SD_TIPO_DOCUMENTO B, SD_AREA C " +
        		"WHERE A.ASU_FECHA_CAPTURA>='01/11/2005' " +
        		"AND A.ASU_FECHA_CAPTURA<='30/11/2005' " +
        		"AND A.ASU_TIP_DOCTO=B.ID_TIPO_DOCTO " +
        		"AND C.ID_AREA=B.TIP_DOCTO_AREA ORDER BY 1";
        return sql;
    }
    
    /**
     * Construye un SQL Query para regresar un Reporte por Asuntos
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getReportePorAsuntos(String inicio, String fin, String strIdArea)
    {
        String sql = "";
       
        sql = "SELECT AREA, AREA||' - '||TIPO_ASUNTO, COUNT(TIPO_ASUNTO) FROM( " +
        		"SELECT " +
        		"CASE ASU_ESTATUS " +
        		"	WHEN 1 THEN ARE_NOMBRE " +
        		"	WHEN 2 THEN (SELECT ASU_REF_AREA_RECEPCION FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"	WHEN 3 THEN (SELECT ASU_REF_AREA_RECEPCION FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"END AS AREA, " +
        		"CASE ASU_ESTATUS " +
        		"	WHEN 1 THEN TIP_ASU_NOMBRE " +
        		"	WHEN 2 THEN (SELECT ASU_REF_TIPO_ASUNTO FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"	WHEN 3 THEN (SELECT ASU_REF_TIPO_ASUNTO FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"END AS TIPO_ASUNTO " +
        		"FROM SD_ASUNTO, SD_TIPO_ASUNTO, SD_AREA, SD_USUARIO " +
        		"WHERE ASU_FECHA_CAPTURA>=TO_DATE('"+inicio+" 00:00:00','DD/MM/YYYY HH24:MI:SS') " +
        		"AND ASU_FECHA_CAPTURA<=TO_DATE('"+fin+" 23:59:59','DD/MM/YYYY HH24:MI:SS') " +
        		"AND ASU_TIPO_ASUNTO=ID_TIPO_ASUNTO " +
        		"AND ID_AREA=TIP_ASU_AREA " +
        		"AND ASU_ESTATUS IN (1,2,3) " +
        		"AND (ID_AREA="+strIdArea+" OR ID_AREA=0 ) " +
        		"AND SD_ASUNTO.ASU_USUARIO_CAPTURA = SD_USUARIO.ID_USUARIO " +
        		"AND SD_USUARIO.USU_AREA = "+strIdArea+" ) " +
        		"WHERE AREA IS NOT null " +
        		"AND TIPO_ASUNTO IS NOT null " +
        		"GROUP BY AREA, TIPO_ASUNTO " +
        		"ORDER BY 2 ";
        return sql;
    }
    
    /**
     * Construye un SQL Query para regresar un Reporte por Asuntos Remitidos
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getReportePorAsuntosRemitidos(	String inicio, 
    													String fin,
														String strIdArea)
    {
        String sql = "";
       
        sql = "SELECT AREA, NOMBRE, COUNT(NOMBRE), ID_AREA, FOLIO_CRT FROM ( " +
        		"SELECT " +
        		"CASE ASU_ESTATUS " +
        		"	WHEN 1 THEN ARE_NOMBRE " +
        		"	WHEN 2 THEN (SELECT ASU_REF_AREA_RECEPCION FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"	WHEN 3 THEN (SELECT ASU_REF_AREA_RECEPCION FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"END AS AREA, " +
        		"CASE ASU_CONTROL_FOLIO " +
        		"	WHEN 0 THEN 'Entrada' " +
        		"	WHEN 1 THEN 'Salida'  " +
        		"END AS FOLIO_CRT, " +
        		"(CASE ASU_ESTATUS " +
        		"	WHEN 1 THEN ARE_NOMBRE " +
        		"	WHEN 2 THEN (SELECT ASU_REF_AREA_RECEPCION FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"	WHEN 3 THEN (SELECT ASU_REF_AREA_RECEPCION FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"END || ' - ' || " +
        		"CASE ASU_CONTROL_FOLIO " +
        		"	WHEN 0 THEN 'Entrada' " +
        		"	WHEN 1 THEN 'Salida' " +
        		"END) AS NOMBRE,  ID_ASUNTO, ID_AREA " +
        		"FROM SD_ASUNTO, SD_USUARIO, SD_AREA " +
        		"WHERE SD_ASUNTO.ASU_USUARIO_CAPTURA = SD_USUARIO.ID_USUARIO " +
        		"AND SD_USUARIO.USU_AREA = SD_AREA.ID_AREA " +
        		"AND SD_AREA.ID_AREA = " + strIdArea + " " +
        		"AND ASU_ESTATUS IN (2,3) " +
				"AND ASU_FECHA_CAPTURA>=TO_DATE('"+inicio+" 00:00:00','DD/MM/YYYY HH24:MI:SS') " +
				"AND ASU_FECHA_CAPTURA<=TO_DATE('"+fin+" 23:59:59','DD/MM/YYYY HH24:MI:SS') " +
				"UNION " +
        		"SELECT ARE_NOMBRE, 'Entrada', ARE_NOMBRE || ' - Entrada', " +
        		"ID_INSTRUCCION_ASUNTO, ID_AREA " +
        		"FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, SD_AREA " +
        		"WHERE INS_BANDERA1 = 1  " +
        		"AND INS_USUARIO = ID_USUARIO " +
        		"AND SD_USUARIO.USU_AREA = SD_AREA.ID_AREA " +
        		"AND SD_AREA.ID_AREA = " + strIdArea + " " +
        		"AND INS_ESTATUS <> 0 ) " +
        		"WHERE AREA IS NOT null " +
        		"AND FOLIO_CRT IS NOT null " +
        		"GROUP BY ID_AREA, AREA, NOMBRE, FOLIO_CRT " +
        		"ORDER BY AREA ";
        return sql;
    }
    
    /**
     * Construye un SQL Query para regresar un Reporte por Fecha de Captura
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getReportePorFechaCaptura(String inicio, String fin, String strIdArea)
    {
        String sql = "";
        
        sql = "SELECT (AREA||' - '||FECHA), AREA, COUNT(FECHA) FROM( " +
        		"SELECT TO_CHAR(ASU_FECHA_RECEPCION, 'DD/MM/YYYY') AS FECHA, " +
        		"CASE ASU_ESTATUS " +
        		"	WHEN 1 THEN ARE_NOMBRE " +
        		"	WHEN 2 THEN (SELECT ASU_REF_AREA_RECEPCION FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"	WHEN 3 THEN (SELECT ASU_REF_AREA_RECEPCION FROM SD_ASUNTO_DESCRIPCION WHERE ID_ASUNTO_REF = ID_ASUNTO) " +
        		"END AS AREA " +
        		"FROM SD_ASUNTO, SD_USUARIO, SD_AREA " +
        		"WHERE ASU_FECHA_CAPTURA>=TO_DATE('"+inicio+" 00:00:00','DD/MM/YYYY HH24:MI:SS') " +
        		"AND ASU_FECHA_CAPTURA<=TO_DATE('"+fin+" 23:59:59','DD/MM/YYYY HH24:MI:SS') " +
        		"AND ASU_ESTATUS IN (1,2,3) " +
        		"AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
        		"AND SD_USUARIO.USU_AREA=SD_AREA.ID_AREA " +
        		"AND ID_AREA="+strIdArea+") " +
        		"WHERE AREA IS NOT null " +
        		"GROUP BY AREA, FECHA " +
        		"ORDER BY AREA, FECHA";
        return sql;
    }
    
    /**
     * Construye un SQL Query para insertar Reportes por Asuntos
     * 
     * @param id ID del Reporte
     * @param area Unidad Administrativa
     * @param tipoRep Tipo de reporte
     * @param tipoDocto Detalle del registro
     * @param num Numero de Asuntos por registro 
     * @param avg Porcentaje de Asuntos por registro
     * @param fecha Fecha de creacion del Reporte
     * @param strTitulo Título del Reporte
     * @param strIdArea ID de la UA
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String InsertarReportes(int id, String tipoRep, String area, String tipoDocto,
            								String num, String avg, String fecha, String strTitulo,
											String strIdArea)
    {
        String sql = "";
        sql = "INSERT INTO SD_REPORTES (ID_REPORTE, REP_DESCRIPCION, REP_TIPO_REPORTE, REP_AREA, " +
        		"REP_TIPO_DOCTO, REP_NUM_ASUNTO, REP_PORCENTAJE, REP_FECHA_CREACION, REP_ID_AREA) VALUES" +
        		"("+id+", '"+strTitulo+"', "+tipoRep+", '"+area+"', '"+tipoDocto+"', " +
        		""+num+", "+avg+", '"+fecha+"', "+strIdArea+")";
        return sql;
    }
    
    /**
     * Construye un SQL Query para insertar Reportes por Estatus
     * 
     * @param id ID del Reporte
     * @param area Unidad Administrativa
     * @param tipoRep Tipo de reporte
     * @param tipoDocto Detalle del registro
     * @param fecha Fecha de creacion del Reporte
     * @param recepcion Numero de Asuntos en Recepción
     * @param turnado Numero de Asuntos Turnados
     * @param terminado Numero de Asuntos Terminados
     * @param turnado_vencida Numero de Asuntos Turnados Vencidos 
     * @param terminado_vencida Numero de Asuntos Terminados Vencidos
     * @param strIdArea ID del area del reporte
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String InsertarReportesEstatus(int id, String tipoRep, String area, String tipoDocto,
			String recepcion, String turnado, String terminado, String fecha, String turnado_vencida, String terminado_vencida,
			String strIdArea, String strTitulo)
    {
        String sql = "";
        sql = "INSERT INTO SD_REPORTES (ID_REPORTE, REP_DESCRIPCION, REP_TIPO_REPORTE, REP_AREA, " +
        "REP_TIPO_DOCTO, REP_RECEPCION, REP_TURNADO, REP_TERMINADO, REP_FECHA_CREACION," +
        "REP_MIN_PLAN, REP_MAX_PLAN, REP_ID_AREA) VALUES" +
        "("+id+", '"+strTitulo+"', "+tipoRep+", '"+area+"', '"+tipoDocto+"', " +
        ""+recepcion+", "+turnado+", "+terminado+",'"+fecha+"',"+turnado_vencida+","+terminado_vencida+","+strIdArea+")";
        return sql;
    }
    
    /**
     * Construye un SQL Query para insertar Reportes por Tiempos de Respuesta
     * 
     * @param id ID del Reporte
     * @param tipoRep Tipo de reporte
     * @param tipoDocto Detalle del registro
     * @param area Unidad Administrativa
     * @param totalAsuntos Total de Asuntos
     * @param minPlan Minimo Planeado
     * @param maxPlan Maximo Planeado
     * @param avgPlan Promedio Planeado
     * @param minReal Minimo Real
     * @param maxReal Maximo Real
     * @param avgReal Promedio Real
     * @param fecha Fecha de creacion del Reporte
     * @param titulo Título del Reporte
     * @param strIdArea ID de la UA
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String insertarReportesTiempos(int id, String tipoRep, String tipoDocto, String area, 
            									String totalAsuntos, String minPlan, String maxPlan, 
            									String avgPlan, String minReal, String maxReal,
            									String avgReal, String fecha, String titulo, String strIdArea){
        String sql = "INSERT INTO SD_REPORTES (ID_REPORTE, REP_DESCRIPCION, REP_TIPO_REPORTE, REP_TIPO_DOCTO, REP_AREA, " +
        			"REP_NUM_ASUNTO, REP_MIN_PLAN, REP_MAX_PLAN, REP_AVG_PLAN, " +
        			"REP_MIN_REAL, REP_MAX_REAL, REP_AVG_REAL, REP_FECHA_CREACION, REP_ID_AREA) VALUES ("+id+", '"+titulo+"', " +
        			""+tipoRep+", '"+tipoDocto+"', '"+area+"', "+totalAsuntos+", "+minPlan+"," +
        			""+maxPlan+", "+avgPlan+", "+minReal+", "+maxReal+", "+avgReal+", '"+fecha+"', "+strIdArea+")";
        return sql;
    }
    
    /**
     * Construye un SQL Query para insertar Reportes por Tiempos de Respuesta
     * @param id ID del Reporte
     * @param strTitulo Título del Reporte
     * @param tipoRep Tipo de reporte
     * @param area Unidad Administrativa
     * @param strFechaCaptura Fecha de captura del reporte
     * @param strCountAsunto Numero de Asuntos
     * @param fecha Fecha de creacion del Reporte
     * @param strIdArea ID de la UA
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String insertarPorFechaCap(
    		int id, 
    		String strTitulo, 
			String tipoRep, 
			String area, 
            String strFechaCaptura, 
			String strCountAsunto, 
			String fecha,
			String strIdArea ){
    	
        String sql = "";
        sql = "INSERT INTO SD_REPORTES (ID_REPORTE, REP_DESCRIPCION, REP_TIPO_REPORTE, REP_AREA, " +
        		"REP_TIPO_DOCTO, REP_NUM_ASUNTO, REP_FECHA_CREACION, REP_ID_AREA) VALUES" +
        		"("+id+", '"+strTitulo+"', "+tipoRep+", '"+area+"', '"+strFechaCaptura+"', " +
        		""+strCountAsunto+", '"+fecha+"', "+strIdArea+")";
        		return sql;
    }
    
    /**
     * Construye un SQL Query para obtener los datos de los reportes asociados a un ID de Reporte
     * 
     * @param strIdReporte ID del Reporte
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDatosReportes(String strIdReporte)
    {
        String sql = "";
        sql = "SELECT REP_DESCRIPCION, REP_AREA, REP_TIPO_DOCTO, REP_NUM_ASUNTO, " +
        		"REP_PORCENTAJE, REP_FECHA_CREACION FROM SD_REPORTES " +
        		"WHERE ID_REPORTE="+strIdReporte;
        return sql;
    }
    
    /**
     * Construye un SQL Query para obtener los datos de los reportes ordenados por Tipo de Docuemnto asociados a un ID de Reporte
     * 
     * @param strIdReporte ID del Reporte
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDatosReportesPorFechaCap(String strIdReporte)
    {
        String sql = "";
        sql = "SELECT REP_DESCRIPCION, REP_AREA, REP_TIPO_DOCTO, REP_NUM_ASUNTO " +
        		"FROM SD_REPORTES " +
        		"WHERE ID_REPORTE="+strIdReporte+" " +
        		"ORDER BY 3";
        return sql;
    }
    
    /**
     * Construye un SQL Query para obtener los datos de los reportes asociados a un ID de Reporte y a una UA
     * 
     * @param strIdReporte ID del Reporte
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDatosReportesEstatus(String strIdReporte, String strIdArea)
    {
        String sql = "";
        sql = "SELECT REP_DESCRIPCION, REP_AREA, REP_TIPO_DOCTO, REP_RECEPCION, " +
        		"REP_TURNADO, REP_TERMINADO, REP_FECHA_CREACION, " +
        		"REP_MIN_PLAN AS TURNADO_VENCIDAS, REP_MAX_PLAN AS TERMINADO_VENCIDAS " +
        		"FROM SD_REPORTES " +
        		"WHERE ID_REPORTE="+strIdReporte+" ";
        return sql;
    }
    
    /**
     * Construye un SQL Query para obtener los datos de los Reportes por Tiempos 
     * 
     * @param strIdReporte ID del Reporte
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getReporteTiempos(String strIdReporte){
        String sql = "SELECT REP_DESCRIPCION, REP_AREA, REP_TIPO_DOCTO, REP_NUM_ASUNTO, " +
        		"REP_FECHA_CREACION, REP_MIN_PLAN, REP_MAX_PLAN, REP_AVG_PLAN, " +
        		"REP_MIN_REAL, REP_MAX_REAL, REP_AVG_REAL FROM SD_REPORTES " +
        		"WHERE ID_REPORTE="+strIdReporte;
        return sql;
    }
    
    /**
     * Construye un SQL Query para obtener los datos de los Reportes por Fecha de Captura
     * 
     * @param strIdReporte ID del Reporte
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAsuntoPorFechaCap(String strfecha, String stridArea)
    {
        String sql = "";
        ////System.err.println("strfecha="+strfecha);
        strfecha = Utilerias.formatearFechas(strfecha);
        sql = 	"SELECT COUNT(*) FROM SD_ASUNTO, SD_USUARIO, SD_AREA " +
        		"WHERE TO_CHAR(ASU_FECHA_CAPTURA, 'dd/MM/yyyy')=TO_DATE('"+strfecha+"', 'dd/MM/yyyy') " +
        		"AND ASU_ESTATUS<>0 " +
        		"AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
        		"AND SD_USUARIO.USU_AREA=SD_AREA.ID_AREA " +
        		"AND ID_AREA="+stridArea;
        return sql;
    }
    
    /**
     * Construye un SQL Query para eliminar Reportes por ID
     * 
     * @param strIds ID del Reporte
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String deleteReportes(String strIds){
    	String sql = "";
    	sql = "DELETE FROM SD_REPORTES WHERE ID_REPORTE="+strIds;
    	return sql;
    }

}

