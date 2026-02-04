/*
 * Clase:						SQLSeccion.java
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
 * Clase para generar codigo SQL para Sección
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class SQLSeccion {
    
    /**
     * Función que regresa un query donde se inserta datos a la
     * tabla de SD_SECCION
     * @param codigo Codigo de seccion
     * @param seccion Seccion del seccion
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @return Regresa un String con el Query correspondiente
     */
    public static String insertarSeccion(	String codigo, String seccion,String idSub,
            								String fecha, String Usr)
    {
        String sql = "";
        sql = "INSERT INTO SD_SECCION (ID_SECCION, SEC_CODIGO, SEC_SERIE, SEC_SUBFONDO, SEC_FECHA_ACTUALIZACION, " +
        		"SEC_USR_ACTUALIZA, SEC_ESTATUS) VALUES (SD_SECCION_SEQ.NEXTVAL,'"+codigo+"', '"+seccion+"', "+idSub+", " +
        		//"'"+fecha+"', "+Usr+", 1)";
        		"SYSDATE, "+Usr+", 1)";
        return sql;
    }
    
    /**
     * Construye un SQL Query para Regresar lor registros ordenados de Seccion
     * @param strOrden Campo por el cual se hace el ordenamiento 
     * @param tipo Ordenamiento ascendente o descendente
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDatosSeccion(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = "SELECT ID_SECCION, SEC_CODIGO, SEC_SERIE, SUB_SECCION ";
        strSql+="FROM SD_SECCION, SD_SUBFONDO WHERE SEC_ESTATUS=1 ";
        strSql+="AND SD_SUBFONDO.ID_SUBFONDO=SD_SECCION.SEC_SUBFONDO ";
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
     * Función que regresa un query con los datos de un seccion 
     * por medio de si id
     * @param strIdSeccion Contiene el Id del seccion
     * @return Regresa un String con el Query correspondiente
     */
    public static String getSeccion(String strIdSeccion)
    {
        String sql = "";
        sql = "SELECT SEC_CODIGO, SEC_SERIE, SEC_SUBFONDO, to_char(SEC_FECHA_ACTUALIZACION, 'dd/MM/yyyy'), SEC_USR_ACTUALIZA " +
        		"FROM SD_SECCION WHERE ID_SECCION="+strIdSeccion;
        return sql;
    }
    
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla
     * @return Regresa un String con el Query correspondiente
     */
    public static String getExisteSec()
    {
        String sql = "SELECT * FROM SD_SECCION";
        return sql;
    }
    
    /**
     * Construye un SQL Query para ejecutar un borrado logico
     * @param strIds Contiene los id de los seccion a borrar
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDeleteSec(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);				
		strSql=	" UPDATE SD_SECCION SET"	+
				" SEC_ESTATUS=0 WHERE ID_SECCION IN ("+ids+")";				
		return strSql;
    }
    
    /**
     * Función que regresa un query, donde se actualiza el registro de la 
     * tabla de SD_SECCION 
     * @param codigo codigo del seccion
     * @param seccion Sección del seccion
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param IdSubfondo Id del registro
     * @return Regresa un String con el Query correspondiente
     */
    public static String actualizaSeccion(String codigo, String seccion, String idSub,
									String fecha, String Usr, String IdSubfondo)
    {
        String sql = "";
        sql = "UPDATE SD_SECCION SET SEC_CODIGO='"+codigo+"', SEC_SERIE='"+seccion+"', " +
        		//"SEC_SUBFONDO="+idSub+", SEC_FECHA_ACTUALIZACION='"+fecha+"', SEC_USR_ACTUALIZA="+Usr+" " +
        		"SEC_SUBFONDO="+idSub+", SEC_FECHA_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), SEC_USR_ACTUALIZA="+Usr+" " +
        		"WHERE ID_SECCION="+IdSubfondo;
        return sql;
    }
    
    /**
     * Función que regresa un query para contruir un combo
     * @param idSubFondo ID del Subfondo
     * @return Regresa un String con el Query correspondiente
     */
    public static String getSeccionCombo(String idSubFondo)
    {
        String sql = "";
        sql = "SELECT ID_SECCION, SEC_CODIGO || ' - ' || SEC_SERIE " +
        		"FROM SD_SECCION WHERE SEC_ESTATUS=1 " +
        		"AND SEC_SUBFONDO="+idSubFondo;
        return sql;
    }
    
    /**
     * Función que regresa un query para contruir un combo
     * @return Regresa un String con el Query correspondiente
     */
    public static String getSeccionCombo()
    {
        String sql = "";
        sql = "SELECT ID_SECCION, SEC_CODIGO || ' - ' || SEC_SERIE " +
        		"FROM SD_SECCION WHERE SEC_ESTATUS=1 ";
        return sql;
    }

}

