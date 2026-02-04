/**
 * Clase:						SQLClasificacion.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Oct 24, 2005
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

public class SQLClasificacion {
    
    /**
     * Inserta Clasificación
     * @param strTipo tipo
     * @param strUsrActualizo usuario que actualizo
     * @param strFecha fecha
     * @return Query
     */
    public static String InsertarClasificacion(String strTipo,
												String strUsrActualizo, String strFecha)
    {
        String sql = "";
        sql = "INSERT INTO SD_CLASIFICACION_ASUNTO (ID_CLA_ASUNTO,CLA_TIPO, CLA_USR_ACTUALIZO," +
				" CLA_FECHA, CLA_ESTATUS) " +
				" VALUES (SD_CLASIFICACION_ASUNTO_SEQ.NEXTVAL,'"+strTipo+"', " +
				//""+strUsrActualizo+", '"+strFecha+"', 1)";
				""+strUsrActualizo+", SYSDATE, 1)";
        return sql;
    }
    
    /**
     * Actualiza expediente
     * @param strIdCla id Clasificación
     * @param strTipo tipo 
     * @param strUsrActualizo usuario que actualizo
     * @param strFecha fecha
     * @return Query
     */
    public static String getActualizarExpediente(String strIdCla, String strTipo,
												String strUsrActualizo, String strFecha)
    {
        String sql = "";
        sql = "UPDATE SD_CLASIFICACION_ASUNTO SET " +
			"CLA_TIPO='"+strTipo+"', " +
			"CLA_USR_ACTUALIZO="+strUsrActualizo+", CLA_FECHA=TO_DATE('"+strFecha+"','DD/MM/YYYY') " +
			"WHERE ID_CLA_ASUNTO="+strIdCla; 
        return sql;
    }
    
    /**
     * 
     * @param strIdCla Id Clasificación
     * @return Query
     */
    public static String getDatosClasificacion(String strIdCla)
    {
        String strSql="";		
		strSql=	"SELECT CLA_TIPO, CLA_USR_ACTUALIZO, TO_CHAR(CLA_FECHA, 'dd/MM/yyyy') " +
				"FROM SD_CLASIFICACION_ASUNTO WHERE ID_CLA_ASUNTO="+strIdCla; 
		return strSql;
    }
    
    /**
     * Elimina registros de Clasificación
     * @param strIds Ids Clasificación
     * @return Query
     */
    public static String getDeleteClasificacion(String strIds[])
	{
	    String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);				
		strSql=	" UPDATE SD_CLASIFICACION_ASUNTO SET"	+
				" CLA_ESTATUS=0 WHERE ID_CLA_ASUNTO IN ("+ids + ")";				
		return strSql;
    	
	}
    
    /**
     * Verifica si existe registros en la tabla de Clasificación
     * @return Query
     */
    public static String getExiste()
    {
        String strSql="";		
		strSql=	"SELECT * FROM SD_CLASIFICACION_ASUNTO"; 
		return strSql;
    }
    
    /**
     * Lista Clasificación
     * @return Query
     */
    public static String getListaClasificacion(String strOrden, String tipo)
	{
		String strSql="";		
		strSql+="SELECT ID_CLA_ASUNTO, CLA_TIPO, to_char(CLA_FECHA, 'dd/mm/yyyy')  ";
		strSql+="FROM SD_CLASIFICACION_ASUNTO WHERE CLA_ESTATUS=1 ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC  ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC  ";
		}
		return strSql;	
	}
    
    /**
     * Combo Clasificación
     * @return Query
     */
    public static String getClasificacionCombo()
	{
		String strSql="";		
		strSql=	"SELECT  ID_CLA_ASUNTO, CLA_TIPO FROM SD_CLASIFICACION_ASUNTO " +
				"WHERE CLA_ESTATUS=1 ORDER BY 2";												
		return strSql;	
	}
    
    /**
     * Función que regresa un query con el nombre del tipo de clasificación de 
     * un Asunto
     * @param idClaAsunto Contiene el ID de la Clasificación del asunto
     * @return Query
     */
    public static String getNombreTipoClasificacion(String idClaAsunto)
    {
        String strSql="";		
		strSql=	"SELECT  CLA_TIPO FROM SD_CLASIFICACION_ASUNTO " +
				"WHERE ID_CLA_ASUNTO="+idClaAsunto+" ";												
		return strSql;
    }
    
    /**
     * Función que regresa la lista de asuntos que pertencen
     * a cada Clasificación de asunto defeindo en los catalogos
     * de sigma
     * @param IdCla Contiene el ID de la Clasificación de asunto
     * @return Query
     */
    public static String getAsuntosHijos(String IdCla)
    {
        String sql = "";
        sql = "SELECT ID_ASUNTO, ASU_DESCRIPCION FROM SD_ASUNTO WHERE ASU_CATEGORIA="+IdCla;
        return sql;
    }

}

