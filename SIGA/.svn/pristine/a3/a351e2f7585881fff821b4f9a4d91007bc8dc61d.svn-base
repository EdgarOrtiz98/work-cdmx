/**
 * Clase:						SQLArchivado.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Dec 7, 2005
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
 * SQLArchivado es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_ARCHIVADO
 * 
 * @author Meve Soluciones SA de CV
 *
 */
public class SQLArchivado {
    
    /**
     * Función que ejecuta un query, donde se inserta los datos de un archivado 
	 * @param strSubFondo		Subfondo
	 * @param strSeccion		Sección
	 * @param strSerie			Seríe
	 * @param strSubserie		SubSeríe
	 * @param strFechaApertura	Fecha de apertura
	 * @param strFechaCierre	Fecha cierre
	 * @param strValorDocto		Valor docto.
	 * @param strVigenciaDocto	Vigencia docto.
	 * @param strFojas			Fojas
	 * @param strLegajos		Legajos
	 * @param strTipoAsunto		Tipo asunto
	 * @param strFechaCla		Fecha Clasificación
	 * @param strFundamento		Fundamento
	 * @param strPeriodoReserva	Periodo reserva
	 * @param strDesclasificacion	desClasificación
	 * @param strAmpliacion			Ampliación
	 * @param strNumAnios			Número de Años
	 * @param strDesclasificacion1	desClasificación
	 * @param strResponsableExp		Responsable
	 * @param strResponsableCla		Responsable Clasificación
	 * @param strIdAsunto			Id asunto
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getInsertaArchivado(String strSubFondo,
            String strSeccion, String strSerie, String strSubserie, String strFechaApertura,
            String strFechaCierre, String strValorDocto, String strVigenciaDocto,
            String strFojas, String strLegajos, String strTipoAsunto, String strFechaCla,
            String strFundamento, String strPeriodoReserva, String strDesclasificacion, String strAmpliacion,
            String strNumAnios, String strDesclasificacion1, String strResponsableExp, String strResponsableCla,
            String strIdAsunto)
    {
        String sql = "";
        sql 	= 	"INSERT INTO SD_ARCHIVADO (AR_SUBFONDO, AR_SECCION, AR_SERIE, AR_SUBSERIE, ";
        sql +=	"AR_FECHA_APERTURA, AR_FECHA_CIERRE, AR_VALOR_DOCUMENTAL, AR_VIGENCIA_DOCUMENTAL, ";
        sql +=	"AR_NUM_FOJAS, AR_NUM_LEGAJOS, AR_TIPO_INF, AR_FECHA_CLASIFICACION, ";
        sql +=	"AR_FUNDAMENTO_LEGAL, AR_PERIODO_RESERVA, AR_FECHA_DESCLASIFICACION, ";
        sql +=	"AR_AMPLIAR_PERIODO_RESERVA, AR_NUM_ANIOS, AR_NVA_FECHA_DESCLASIFICACION, ";
        sql +=	"AR_NOMBRE_GENERADOR_EXPEDIENTE, AR_NOM_CLASIFICACION_INFO, ID_ASUNTO) ";
        sql +=	"VALUES (";
        sql +=	""+strSubFondo+", "+strSeccion+", '"+strSerie+"', '"+strSubserie+"', ";
        if(strFechaApertura.length() == 0){
            sql +=	"null, ";
        }else{
            sql +=	"'"+strFechaApertura+"', ";
        }
        
        if(strFechaCierre.length() == 0){
            sql +=	"null, ";
        }else{
            sql +=	"'"+strFechaCierre+"', ";
        }
        
        if(strValorDocto.length() == 0){
            sql +=	"'null', ";
        }else{
            sql +=	"'"+strValorDocto+"', ";
        }
        
        if(strVigenciaDocto.length() == 0){
            sql +=	"null, ";
        }else{
            sql +=	"'"+strVigenciaDocto+"', ";
        }
        
        sql +=	"'"+strFojas+"', '"+strLegajos+"', ";
        
        if(strTipoAsunto.length() == 0){
            sql +=	"null, ";
        }else{
            sql +=	""+strTipoAsunto+", ";
        }
        
        if(strFechaCla.length() == 0){
            sql +=	"null, ";
        }else{
            sql +=	"'"+strFechaCla+"', ";
        }
        
        sql +=	"'"+strFundamento+"', ";
        
        if(strPeriodoReserva.length() == 0){
            sql +=	"null, ";
        }else{
            sql +=	""+strPeriodoReserva+", ";
        }
        
        if(strDesclasificacion.length() == 0){
            sql +=	"null, ";
        }else{
            sql +=	"'"+strDesclasificacion+"', ";
        }
        
        sql +=	""+strAmpliacion+", ";
        
        if(strNumAnios.length() == 0){
            sql +=	"null, ";
        }else{
            sql +=	""+strNumAnios+", ";
        }
        
        if(strDesclasificacion1.length() == 0){
            sql +=	"null, ";
        }else{
            sql +=	"'"+strDesclasificacion1+"', ";
        }
        
        if(strResponsableExp.length() == 0){
            sql +=	"null, ";
        }else{
            sql +=	""+strResponsableExp+", ";
        }
        
        if(strResponsableCla.length() == 0){
            sql +=	"null, ";
        }else{
            sql +=	""+strResponsableCla+", ";
        }
        
        sql +=	""+strIdAsunto+")";
        
        return sql;
    }
    
    /**
     * Función que ejecuta un query donde verifica si el
     * asunto tiene datos en el archivado
     * @param idAsunto Contiene el ID del Asunto
     * @return Query
     */
    public static String getTieneArchivado(String idAsunto)
    {
        String sql = "";
        sql = "SELECT * FROM SD_ARCHIVADO WHERE ID_ASUNTO="+idAsunto;
        return sql;
    }
    
    /**
     * Función que regresa un query con la lista de los datos de
     * un archivado de un asunto en especifico
     * @param stridAsunto Contiene el Id del Asunto
     * @return Query
     */
    public static String getDatosArchivado(String stridAsunto)
    {
        String sql = "";
        sql = "SELECT AR_SUBFONDO, AR_SECCION, AR_SERIE, AR_SUBSERIE, " +
        		"TO_CHAR(AR_FECHA_APERTURA, 'yyyy-MM-dd'), TO_CHAR(AR_FECHA_CIERRE, 'yyyy-MM-dd'), AR_VALOR_DOCUMENTAL, TO_CHAR(AR_VIGENCIA_DOCUMENTAL, 'yyyy-MM-dd'), " +
        		"AR_NUM_FOJAS, AR_NUM_LEGAJOS, AR_TIPO_INF, TO_CHAR(AR_FECHA_CLASIFICACION, 'yyyy-MM-dd'), " +
        		"AR_FUNDAMENTO_LEGAL, AR_PERIODO_RESERVA, TO_CHAR(AR_FECHA_DESCLASIFICACION, 'yyyy-MM-dd'), " +
        		"AR_AMPLIAR_PERIODO_RESERVA, AR_NUM_ANIOS, TO_CHAR(AR_NVA_FECHA_DESCLASIFICACION, 'yyyy-MM-dd'), " +
        		"AR_NOMBRE_GENERADOR_EXPEDIENTE, AR_NOM_CLASIFICACION_INFO " +
        		"FROM SD_ARCHIVADO WHERE ID_ASUNTO="+stridAsunto;
        return sql;
    }

}

